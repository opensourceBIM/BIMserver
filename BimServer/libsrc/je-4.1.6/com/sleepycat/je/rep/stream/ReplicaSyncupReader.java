/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.stream;

import static com.sleepycat.je.utilint.DbLsn.NULL_LSN;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.recovery.CheckpointEnd;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.vlsn.VLSNIndex;
import com.sleepycat.je.rep.vlsn.VLSNRange;
import com.sleepycat.je.txn.TxnCommit;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.VLSN;

/**
 * The ReplicaSyncupReader scans the log backwards for requested log entries. 
 * The reader must track whether it has passed a checkpoint, and therefore
 * can not used the vlsn index to skip over entries.
 *
 * The ReplicaSyncupReader is not thread safe, and can only be used
 * serially. It will stop at the finishLsn, which should be set using the
 * GlobalCBVLSN.
 */
public class ReplicaSyncupReader extends VLSNReader {

    /* True if this particular record retrieval is for a syncable record. */
    private boolean syncableSearch;

    private final LogEntry ckptEndLogEntry = 
        LogEntryType.LOG_CKPT_END.getNewLogEntry();

    private final LogEntry commitLogEntry = 
        LogEntryType.LOG_TXN_COMMIT.getNewLogEntry();

    /* 
     * SearchResults retains the information as to whether the found
     * matchpoint is valid.
     */
    private final MatchpointSearchResults searchResults; 

    private final Logger logger;


    public ReplicaSyncupReader(EnvironmentImpl envImpl,
                               VLSNIndex vlsnIndex,
                               long endOfLogLsn,
                               int readBufferSize,
                               NameIdPair nameIdPair,
                               VLSN startVLSN,
                               long finishLsn,
                               MatchpointSearchResults searchResults)
        throws IOException, DatabaseException {

        /*
         * If we go backwards, endOfFileLsn and startLsn must not be null.
         * Make them the same, so we always start at the same very end.
         */
        super(envImpl,
              vlsnIndex,
              false,           // forward
              endOfLogLsn,
              readBufferSize,
              nameIdPair,
              finishLsn);

        initScan(startVLSN, endOfLogLsn);
        this.searchResults = searchResults;
        logger = LoggerUtils.getLogger(getClass());
    }

    /**
     * Set up the ReplicaSyncupReader to start scanning from this VLSN. 
     * @throws IOException
     */
    private void initScan(VLSN startVLSN, long endOfLogLsn)
        throws IOException {

        if (startVLSN.equals(VLSN.NULL_VLSN)) {
            throw EnvironmentFailureException.unexpectedState
                ("ReplicaSyncupReader start can't be NULL_VLSN");
        }

        startLsn = endOfLogLsn;
        assert startLsn != NULL_LSN;

        /*
         * Flush the log so that syncup can assume that all log entries that
         * are represented in the VLSNIndex  are safely out of the log buffers
         * and on disk. Simplifies this reader, so it can use the regular
         * ReadWindow, which only works on a file.
         */
        envImpl.getLogManager().flush();

        window.initAtFileStart(startLsn);
        currentEntryPrevOffset = window.getEndOffset();
        currentEntryOffset = window.getEndOffset();
        currentVLSN = startVLSN;
    }

    /**
     * Backward scanning for the replica's part in syncup.
     */
    public OutputWireRecord scanBackwards(VLSN vlsn)
        throws DatabaseException {

        syncableSearch = false;
        VLSNRange range = vlsnIndex.getRange();
        if (vlsn.compareTo(range.getFirst()) < 0) {
            /*
             * The requested VLSN is before the start of our range, we don't
             * have this record.
             */
            return null;
        }

        currentVLSN = vlsn;

        if (readNextEntry()) {
            return currentFeedRecord;
        }

        return null;
    }

    /**
     * Backward scanning for finding an earlier candidate syncup matchpoint.
     */
    public OutputWireRecord findPrevSyncEntry()
        throws DatabaseException {

        currentFeedRecord = null;
        syncableSearch = true;

        /* Start by looking at the entry before the current record. */
        currentVLSN = currentVLSN.getPrev();

        VLSNRange range = vlsnIndex.getRange();
        if (currentVLSN.compareTo(range.getFirst()) < 0) {

            /*
             * We've walked off the end of the contiguous VLSN range.
             */
            return null;
        }

        if (readNextEntry() == false) {
            /*
             * We scanned all the way to the front of the log, no
             * other sync-able entry found.
             */
            return null;
        }

        assert LogEntryType.isSyncPoint(currentFeedRecord.getEntryType()) :
        "Unexpected log type= " + currentFeedRecord;

        return currentFeedRecord;
    }

    /**
     * @throw an EnvironmentFailureException if we were scanning for a
     * particular VLSN and we have passed it by.
     */
    private void checkForPassingTarget(int compareResult) {

        if (compareResult < 0) {
            /* Hey, we passed the VLSN we wanted. */
            throw EnvironmentFailureException.unexpectedState
                ("want to read " + currentVLSN + " but reader at " +
                 currentEntryHeader.getVLSN());
        }
    }

    /**
     * Return true for ckpt entries, for syncable entries, and if we're in
     * specific vlsn scan mode, any replicated entry.  There is an additional
     * level of filtering in processEntry.
     */
    @Override
    protected boolean isTargetEntry()
        throws DatabaseException {

        if (logger.isLoggable(Level.FINEST)) {
            LoggerUtils.finest(logger, envImpl,
                               " isTargetEntry " +  currentEntryHeader); 
        }

        nScanned++;

        /* Skip invisible entries. */
        if (currentEntryHeader.isInvisible()) {
            return false;
        }

        byte currentType = currentEntryHeader.getType();

        /* 
         * Return true if this entry is replicated. All entries need to be
         * perused by processEntry, when we are doing a vlsn based search,
         * even if they are not a sync point, because:
         *  (a) If this is a vlsn-based search, it's possible that the replica
         * and feeder are mismatched. The feeder will only propose a sync type
         * entry as a matchpoint but it might be that the replica has a non-
         * sync entry at that vlsn.
         *  (b) We need to note passed commits in processEntry.
         */
        if (entryIsReplicated()) {
            if (syncableSearch) {
                if (LogEntryType.isSyncPoint(currentType)) {
                    return true;
                }
                currentVLSN = currentEntryHeader.getVLSN().getPrev();
            } else {
                return true;
            }
        }

        /* 
         * We'll also need to read checkpoint end records to record their 
         * presence.
         */
        if (LogEntryType.LOG_CKPT_END.equalsType(currentType)) {
            return true;
        }

        return false;
    }

    /**
     * ProcessEntry does additional filtering before deciding whether to
     * return an entry as a candidate for matching.
     *
     * If this is a record we are submitting as a matchpoint candidate,
     * instantiate a WireRecord to house this log entry. If this is a
     * non-replicated entry or a txn end that follows the candidate matchpoint,
     * record whatever status we need to, but don't use it for comparisons.
     * 
     * For example, suppose the log is like this:f
     *
     * VLSN  entry
     * 10    LN
     * 11    commit
     * 12    LN
     *  --   ckpt end
     * 13    commit
     * 14    abort
     *
     * And that the master only has VLSNs 1-12. The replica will suggest vlsn
     * 14 as the first matchpoint. The feeder will counter with a suggestion
     * of vlsn 11, since it doe not have vlsn 14.
     *
     * At that point, the ReplicaSyncupReader will scan backwards in the log,
     * looking for vlsn 11. Although the reader should only return an entry
     * when it gets to vlsn 11.  the reader must process commits and ckpts that
     * follow 11, so that they can be recorded in the searchResults, so the
     * number of rolled back commits can be accurately reported.
     */
    @Override
    protected boolean processEntry(ByteBuffer entryBuffer) {

        if (logger.isLoggable(Level.FINEST)) {
            LoggerUtils.finest(logger, envImpl,
                               " syncup reader saw " +  currentEntryHeader); 
        }
        byte currentType = currentEntryHeader.getType();


        /*
         * CheckpointEnd entries are tracked in order to see if a rollback
         * must be done, but are not returned as possible matchpoints.
         */
        if (LogEntryType.LOG_CKPT_END.equalsType(currentType)) {

            /* 
             * Read the entry, which both lets us decipher its contents and 
             * also advances the file reader position.
             */
            ckptEndLogEntry.readEntry(currentEntryHeader, entryBuffer, 
                                     true /*readFullItem*/);

            if (logger.isLoggable(Level.FINEST)) {
                LoggerUtils.finest(logger, envImpl,
                                   " syncup reader read " + 
                                   currentEntryHeader + ckptEndLogEntry);
            }

            if (((CheckpointEnd) ckptEndLogEntry.getMainItem()).
                getCleanedFilesToDelete()) {
                searchResults.notePassedCheckpointEnd();
            }
            
            return false;
        }

        /* 
         * Setup the log entry as a wire record so we can compare it to
         * the entry from the feeder as we look for a matchpoint. Do this
         * before we change positions on the entry buffer by reading it.
         */
        ByteBuffer buffer = entryBuffer.slice();
        buffer.limit(currentEntryHeader.getItemSize());
        currentFeedRecord = new OutputWireRecord(currentEntryHeader, buffer);

        /* 
         * All commit records must be tracked to figure out if we've exceeded
         * the txn rollback limit. For reporting reasons, we'll need to
         * unmarshal the log entry, so we can read the timestamp in the commit
         * record.
         */
        if (LogEntryType.LOG_TXN_COMMIT.equalsType(currentType)) {

            commitLogEntry.readEntry(currentEntryHeader, entryBuffer, 
                                     true /*readFullItem*/);
            TxnCommit commit = (TxnCommit) commitLogEntry.getMainItem();
            searchResults.notePassedCommits(commit.getTime(), 
                                            commit.getId(),
                                            currentEntryHeader.getVLSN(),
                                            getLastLsn());

            if (logger.isLoggable(Level.FINEST)) {
                LoggerUtils.finest(logger, envImpl,
                                   "syncup reader read " +
                                   currentEntryHeader + commitLogEntry);
            }
        } else {
            entryBuffer.position(entryBuffer.position() +
                                 currentEntryHeader.getItemSize());
        }

        if (syncableSearch) {
            return true;
        } 

        /* We're looking for a particular VLSN. */
        int compareResult = currentEntryHeader.getVLSN().compareTo(currentVLSN);
        checkForPassingTarget(compareResult);
        
        /* return true if this is the entry we want. */
        return (compareResult == 0);
    }
}
