/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.stream;

import static com.sleepycat.je.utilint.DbLsn.NULL_LSN;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.ChecksumException;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.vlsn.VLSNIndex;
import com.sleepycat.je.rep.vlsn.VLSNRange;
import com.sleepycat.je.rep.vlsn.VLSNIndex.BackwardVLSNScanner;
import com.sleepycat.je.utilint.VLSN;

/**
 * The FeederSyncupReader scans the log backwards for requested log entries.
 * It uses the vlsnIndex to optimize its search, repositioning when a concrete
 * vlsn->lsn mapping is available.
 *
 * The FeederSyncupReader is not thread safe, and can only be used serially. It
 * will stop at the finishLsn, which should be set using the GlobalCBVLSN.
 */
public class FeederSyncupReader extends VLSNReader {
    /* The scanner is a cursor over the VLSNIndex. */
    private final BackwardVLSNScanner scanner;

    public FeederSyncupReader(EnvironmentImpl envImpl,
                              VLSNIndex vlsnIndex,
                              long endOfLogLsn,
                              int readBufferSize,
                              NameIdPair nameIdPair,
                              VLSN startVLSN,
                              long finishLsn)
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
        scanner = new BackwardVLSNScanner(vlsnIndex);
        initScan(startVLSN);
    }

    /**
     * Set up the FeederSyncupReader to start scanning from this VLSN. If we
     * find a mapping for this VLSN, we'll start precisely at its LSN, else
     * we'll have to start from an earlier location.
     *
     * @throws InterruptedException
     * @throws IOException
     * @throws DatabaseException
     */
    private void initScan(VLSN startVLSN)
        throws DatabaseException, IOException {

        if (startVLSN.equals(VLSN.NULL_VLSN)) {
            throw EnvironmentFailureException.unexpectedState
                ("FeederSyncupReader start can't be NULL_VLSN");
        }

        VLSN startPoint = startVLSN;
        startLsn = scanner.getStartingLsn(startPoint);
        assert startLsn != NULL_LSN;

        /*
         * Flush the log so that syncup can assume that all log entries that
         * are represented in the VLSNIndex  are safely out of the log buffers
         * and on disk. Simplifies this reader, so it can use the regular
         * ReadWindow, which only works on a file.
         */
        envImpl.getLogManager().flushNoSync();

        window.initAtFileStart(startLsn);
        currentEntryPrevOffset = window.getEndOffset();
        currentEntryOffset = window.getEndOffset();
        currentVLSN = startVLSN;
    }

    /**
     * Backward scanning for records for the feeder's part in syncup.
     * @throws ChecksumException 
     * @throws FileNotFoundException 
     */
    public OutputWireRecord scanBackwards(VLSN vlsn)
        throws FileNotFoundException, ChecksumException {

        VLSNRange range = vlsnIndex.getRange();
        if (vlsn.compareTo(range.getFirst()) < 0) {
            /*
             * The requested VLSN is before the start of our range, we don't
             * have this record.
             */
            return null;
        }

        currentVLSN = vlsn;

        /*
         * If repositionLsn is not NULL_LSN, the reader will seek to that
         * position when calling readNextEntry instead of scanning.
         * setPosition() is a noop if repositionLsn is null.
         */
        long repositionLsn = scanner.getPreciseLsn(vlsn);
        setPosition(repositionLsn);

        if (readNextEntry()) {
            return currentFeedRecord;
        }

        return null;
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

    @Override
    protected boolean isTargetEntry()
        throws DatabaseException {

        nScanned++;

        /* Skip invisible entries. */
        if (currentEntryHeader.isInvisible()) {
            return false;
        }

        /* 
         * Return true if this entry is replicated and its VLSN is currentVLSN.
         */
        if (entryIsReplicated()) {
            VLSN entryVLSN = currentEntryHeader.getVLSN();
            int compareResult = entryVLSN.compareTo(currentVLSN);
            checkForPassingTarget(compareResult);

            /* return true if this is the entry we want. */
            return (compareResult == 0);
        }

        return false;
    }

    /**
     * Instantiate a WireRecord to house this log entry.
     */
    @Override
    protected boolean processEntry(ByteBuffer entryBuffer) {

        ByteBuffer buffer = entryBuffer.slice();
        buffer.limit(currentEntryHeader.getItemSize());
        currentFeedRecord = new OutputWireRecord(currentEntryHeader, buffer);

        entryBuffer.position(entryBuffer.position() +
                             currentEntryHeader.getItemSize());
        return true;
    }
}
