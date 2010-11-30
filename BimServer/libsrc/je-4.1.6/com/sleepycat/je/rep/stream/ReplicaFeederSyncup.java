/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.stream;

import static com.sleepycat.je.utilint.VLSN.NULL_VLSN;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.rep.InsufficientLogException;
import com.sleepycat.je.rep.ReplicationNode;
import com.sleepycat.je.rep.RollbackException;
import com.sleepycat.je.rep.RollbackProhibitedException;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.RepParams;
import com.sleepycat.je.rep.impl.node.LocalCBVLSNTracker;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.impl.node.Replay;
import com.sleepycat.je.rep.stream.Protocol.AlternateMatchpoint;
import com.sleepycat.je.rep.stream.Protocol.Entry;
import com.sleepycat.je.rep.stream.Protocol.EntryNotFound;
import com.sleepycat.je.rep.stream.Protocol.RestoreResponse;
import com.sleepycat.je.rep.utilint.NamedChannel;
import com.sleepycat.je.rep.utilint.BinaryProtocol.Message;
import com.sleepycat.je.rep.vlsn.VLSNIndex;
import com.sleepycat.je.rep.vlsn.VLSNRange;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.VLSN;

/**
 * Establish where the replication stream should start for a replica and feeder
 * pair. The replica compares what is in its log with what the feeder has, to
 * determine the latest common log entry matchpoint
 *
 * - If the replica has applied log entries after that matchpoint, roll them
 *   back
 * - If a common matchpoint can't be found, the replica will need to do
 *   a network restore.
 */
public class ReplicaFeederSyncup {

    private final Logger logger;

    private final NamedChannel namedChannel;
    private final Protocol protocol;
    private final RepNode repNode;
    private final VLSNIndex vlsnIndex;
    private final Replay replay;
    private final RepImpl repImpl;

    /* The VLSN, lsn and log entry at which a match was made. */
    private VLSN matchpointVLSN = NULL_VLSN;
    private Long matchedVLSNTime = 0L;

    /* 
     * searchResults are the bundled outputs from the backwards scan by the
     * ReplicaSyncReader during its search for a matchpoint.
     */
    private final MatchpointSearchResults searchResults;

    /**
     * For unit tests only. 
     */
    private static TestHook<Object> globalSyncupEndHook;
    private TestHook<Object> syncupEndHook;

    public ReplicaFeederSyncup(RepNode repNode,
                               Replay replay,
                               NamedChannel namedChannel,
                               Protocol protocol) {
        this.replay = replay;
        logger = LoggerUtils.getLogger(getClass());
        this.repNode = repNode;
        this.vlsnIndex = repNode.getVLSNIndex();
        this.namedChannel = namedChannel;
        this.protocol = protocol;
        this.repImpl = repNode.getRepImpl();
        searchResults = new MatchpointSearchResults(repNode.getRepImpl());
        syncupEndHook = repNode.replica().getReplicaFeederSyncupHook();
    }

    public long getMatchedVLSNTime() {
        return matchedVLSNTime;
    }

    public VLSN getMatchedVLSN() {
        return matchpointVLSN;
    }

    /**
     * The replica's side of the protocol.
     * @throws InterruptedException
     * @throws InsufficientLogException
     */
    public void execute(LocalCBVLSNTracker cbvlsnTracker)
        throws IOException,
               DatabaseException,
               InterruptedException,
               InsufficientLogException {

        final long startTime = System.currentTimeMillis();
        String feederName = namedChannel.getNameIdPair().getName();
        LoggerUtils.info(logger, repImpl,
                         "Replica-feeder " + feederName + 
                         " syncup started. Replica range: " +
                         repNode.getVLSNIndex().getRange());

        /* Prohibit global CBVLSN update. */
        repNode.syncupStarted();
        try {

            /*
             * Find a replication stream matchpoint and a place to start
             * the replication stream. If the feeder cannot service this
             * protocol because it has run out of replication stream,
             * findMatchpoint will throw a InsufficientLogException. If the
             */
            VLSNRange range = vlsnIndex.getRange();
            findMatchpoint(range);

            /*
             * If we can't rollback to the found matchpoint, verifyRollback
             * will throw the appropriate exception.
             */
            verifyRollback(range);

            replay.rollback(matchpointVLSN, searchResults.getMatchpointLSN());

            /* Update the vlsnIndex. */
            VLSN startVLSN = matchpointVLSN.getNext();
            vlsnIndex.truncateFromTail(startVLSN, 
                                       searchResults.getMatchpointLSN());

            protocol.write(protocol.new StartStream(startVLSN), namedChannel);
            LoggerUtils.info(logger, repImpl,
                             "Replica-feeder " + feederName + 
                             " start stream at VLSN: " + startVLSN);

            /*
             * Initialize this node's local CBVLSN while global CBVLSN updates
             * are prohibited.
             */
            cbvlsnTracker.registerMatchpoint(startVLSN);
        } finally {

            /* For unit test support only. */
            assert runHook(); 

            repNode.syncupEnded();
            LoggerUtils.info
                (logger, repImpl,
                 String.format
                 ("Replica-feeder " + feederName + 
                  " syncup ended. Elapsed time: %,dms",
                  (System.currentTimeMillis() - startTime)));
        }
    }

    /**
     * A matchpoint has been found. What happens next depends on the position
     * of the matchpoint and its relationship to the last transaction end
     * record.
     *
     * In following table,
     *    M = some non-null matchpoint VLSN value,
     *    T = some non-null last txn end value
     *    S = some non-null last sync value
     *
     * txn end                last sync   found        action
     *  VLSN                  VLSN        matchpoint
     * ----------             ---------   ---------    ------------------------
     * NULL_VLSN              NULL_VLSN   NULL_VLSN    rollback everything
     * NULL_VLSN              NULL_VLSN      M         can't occur
     * NULL_VLSN                 S        NULL_VLSN    rollback everything
     * NULL_VLSN                 S           M         rollback to M
     *   T                    NULL_VLSN   NULL_VLSN    can't occur
     *   T                    NULL_VLSN      M         can't occur
     *   T                       S        NULL_VLSN    network restore, though
     *                                                 could also do hard recov
     *   T <= M                  S           M         rollback to matchpoint
     *   T > M, truncate not ok  S           M         network restore
     *   T > M, truncation limit 
     *          exceeded         S           M         throw RollbackProhibited
     *   T > M, truncate ok      S           M         hard recovery
     * @throws IOException
     */
    private void verifyRollback(VLSNRange range)
        throws RollbackException, InsufficientLogException, IOException {

        VLSN lastTxnEnd = range.getLastTxnEnd();
        VLSN lastSync = range.getLastSync();

        LoggerUtils.finest(logger, repImpl, "verify rollback" +
                           " vlsn range=" + range +
                           " searchResults=" + searchResults);
        /*
         * If the lastTxnEnd VLSN is null, we don't have to worry about hard
         * recovery. See truth table above.
         */
        if (lastTxnEnd.isNull()) {
            if (range.getLastSync().isNull() && !matchpointVLSN.isNull()) {
                throw EnvironmentFailureException.unexpectedState
                    (repNode.getRepImpl(), "Shouldn't be possible to find a "+
                     "matchpoint of " + matchpointVLSN +
                     " when the sync VLSN is null. Range=" + range);
            }

            /* We'll be doing a normal rollback. */
            LoggerUtils.fine(logger, repImpl, "normal rollback, no txn end");
            return;
        }

        if (lastSync.isNull()) {
            throw EnvironmentFailureException.unexpectedState
                (repNode.getRepImpl(),
                 "Shouldn't be possible to have a null sync VLSN when the "
                 + " lastTxnVLSN " + lastTxnEnd + " is not null. Range=" + 
                 range);
        }

        /*
         * There is a non-null lastTxnEnd VLSN, so check if the found
         * matchpoint precedes it. If it doesn't, we can't rollback.
         */
        if (matchpointVLSN.isNull()) {

            /*
             * We could actually also try to do a hard recovery and truncate
             * all committed txns, but for now, let's assume that it will cost
             * less to copy the log files.
             */
            LoggerUtils.info(logger, repImpl, 
                             "This node had a txn end at vlsn = " + lastTxnEnd +
                             "but no matchpoint found.");
            throw setupLogRefresh(matchpointVLSN);
        }

        /*
         * The matchpoint is after or equal to the last txn end, no problem
         * with doing a normal rollback.
         */
        if ((lastTxnEnd.compareTo(matchpointVLSN) <= 0) &&
            (searchResults.getNumPassedCommits() == 0)) {
            LoggerUtils.fine(logger, repImpl, "txn end vlsn of " + lastTxnEnd +
                             "<= matchpointVLSN of " + matchpointVLSN +
                             ", normal rollback");
            return;
        }

        /*
         * We're planning on rolling back past a commit or abort. The more
         * optimal course of action is to truncate the log and run a hard
         * recovery, but if the matchpoint precedes a checkpoint which deleted
         * log files, the truncation is not permissible because the resulting
         * log might be missing needed files. Instead, we have to do a network
         * restore.
         */
        if (searchResults.getPassedCheckpointEnd()) {
            LoggerUtils.info(logger, repImpl, "matchpointVLSN of " +
                             matchpointVLSN + " precedes a checkpoint end, " +
                             "needs network restore.");
            throw setupLogRefresh(matchpointVLSN);
        }

        /*
         * We're planning on rolling back past a commit or abort, and we know
         * that we have not passed a barrier checkpoint. See if we have
         * exceeded the number of rolledback commits limit.
         */
        EnvironmentImpl envImpl = repNode.getRepImpl();
        int rollbackTxnLimit  = 
            envImpl.getConfigManager().getInt(RepParams.TXN_ROLLBACK_LIMIT);

        if (searchResults.getNumPassedCommits() > rollbackTxnLimit) {

            LoggerUtils.severe(logger, repImpl,
                               "Limited list of transactions that would " +
                               " be truncated for hard recovery:\n" +
                               searchResults.dumpPassedTxns());

            throw new RollbackProhibitedException(repNode.getRepImpl(),
                                                  rollbackTxnLimit,
                                                  matchpointVLSN,
                                                  searchResults);
        }  

        /* 
         * After passing all the earlier qualifications, do a truncation and
         * hard recovery .
         */
        throw setupHardRecovery(range);
    }

    /**
     * Find a matchpoint, which is a log entry in the replication stream which
     * is the same on feeder and replica. Assign the matchpointVLSN field. The
     * matchpoint log entry must be be tagged with an environment id. If no
     * matching entry is found, the matchpoint is effectively the NULL_VLSN.
     *
     * To determine the matchpoint, exchange messages with the feeder and
     * compare log entries. If the feeder does not have enough log entries,
     * throw InsufficientLogException.
     * @throws InterruptedException
     * @throws InsufficientLogException
     */
    private void findMatchpoint(VLSNRange range)
        throws IOException,
               InterruptedException,
               InsufficientLogException {

        VLSN candidateMatchpoint = range.getLastSync();
        if (candidateMatchpoint.equals(NULL_VLSN)) {

            /*
             * If the replica has no sync-able log entries at all, the
             * matchpoint is the NULL_VLSN, and we should start the replication
             * stream at VLSN 1. Check if the feeder has the VLSN 1. If it
             * doesn't, getFeederRecord() will throw a
             * InsufficientLogException. We can assume that a non-cleaned
             * feeder always has VLSN 1, because a ReplicatedEnvironment always
             * creates a few replicated vlsns, such as the name db, at
             * initial startup.
             */
            getFeederRecord(range, VLSN.FIRST_VLSN,
                            false /*acceptAlternative*/);
            return;
        }

        /*
         * CandidateMatchpoint is not null, so ask the feeder for the log
         * record at that vlsn.
         */
        InputWireRecord feederRecord =
            getFeederRecord(range, candidateMatchpoint,
                            true /*acceptAlternative*/);

        /*
         * The feeder may have suggested an alternative matchpoint, so reset
         * candidate matchpoint.
         */
        candidateMatchpoint = feederRecord.getVLSN();
        if (logger.isLoggable(Level.FINE)) {
            LoggerUtils.fine(logger, repImpl,
                             "first candidate matchpoint: " + 
                             candidateMatchpoint);
        }
        /* Start comparing feeder records to replica records. */
        ReplicaSyncupReader backwardsReader =
            setupBackwardsReader(candidateMatchpoint);
        OutputWireRecord replicaRecord =
            backwardsReader.scanBackwards(candidateMatchpoint);

        if (!replicaRecord.match(feederRecord)) {

            while (true) {

                replicaRecord = backwardsReader.findPrevSyncEntry();

                if (replicaRecord == null) {

                    /*
                     * The search for the previous sync log entry went past our
                     * available contiguous VLSN range, so there is no
                     * matchpoint.
                     */
                    LoggerUtils.info(logger, repImpl,
                                     "Looking at candidate matchpoint vlsn " +
                                     candidateMatchpoint + 
                                     " but this node went past its available" +
                                     " contiguous VLSN range, need network" +
                                     " restore.");
                    throw setupLogRefresh(candidateMatchpoint);
                }

                /*
                 * Ask the feeder for the record. If the feeder doesn't have
                 * it, we'll throw out and do a network restore.
                 */
                candidateMatchpoint = replicaRecord.getVLSN();
                if (logger.isLoggable(Level.FINE)) {
                    LoggerUtils.fine(logger, repImpl, 
                                     "Next candidate matchpoint: " + 
                                     candidateMatchpoint);
                }
                feederRecord = getFeederRecord(range, candidateMatchpoint,
                                               false);

                if (replicaRecord.match(feederRecord)) {
                    break;
                }
            }
        }

        /* We've found the matchpoint. */
        matchedVLSNTime = replicaRecord.getTimeStamp();
        matchpointVLSN = candidateMatchpoint;
        searchResults.setMatchpoint(backwardsReader.getLastLsn());
        LoggerUtils.finest(logger, repImpl,
                           "after setting  matchpoint, searchResults=" +
                           searchResults);
    }

    private ReplicaSyncupReader setupBackwardsReader(VLSN candidateMatchpoint)
        throws IOException {

        EnvironmentImpl envImpl = repNode.getRepImpl();
        int readBufferSize = envImpl.getConfigManager().
            getInt(EnvironmentParams.LOG_ITERATOR_READ_SIZE);
        return new ReplicaSyncupReader
            (envImpl,
             repNode.getVLSNIndex(),
             envImpl.getFileManager().getLastUsedLsn(),
             readBufferSize,
             repNode.getNameIdPair(),
             candidateMatchpoint,
             DbLsn.makeLsn(repNode.getCleanerBarrierFile(),  0),
             searchResults);
    }

    /**
     * Ask the feeder for information to add to InsufficientLogException,
     * and then throw the exception.
     *
     * The endVLSN marks the last VLSN that this node will want from
     * the network restore. That information helps ensure that the restore
     * source has enough vlsns to satisfy this replica.
     *
     * The replication node list identifies possible log provider members.
     * @throws IOException
     */
    private InsufficientLogException setupLogRefresh(VLSN failedMatchpoint)
        throws IOException {

        protocol.write(protocol.new RestoreRequest(failedMatchpoint),
                       namedChannel);
        RestoreResponse response =
            (RestoreResponse) protocol.read(namedChannel);

        return new InsufficientLogException
            (repNode,
             response.getCBVLSN(),
             new HashSet<ReplicationNode>(Arrays.asList
                                          (response.getLogProviders())));
    }


    /**
     * Hard recovery:  truncate the files, repeat recovery.
     * If this hard recovery came about before the ReplicatedEnvironment was
     * fully instantiated, we will recreate the environment under the
     * covers. If this came while the replica was up and supporting existing
     * Environment handles, we must invalidate the environment, and ask the
     * application to reopen.
     * @throws IOException
     */
    public RollbackException setupHardRecovery(VLSNRange range)
        throws IOException {


        /* Creating the exception invalidates the environment. */
        RollbackException r = new RollbackException(repImpl,
                                                    range.getLastTxnEnd(),
                                                    matchpointVLSN,
                                                    searchResults);
        LoggerUtils.severe(logger, repImpl,
                           "Limited list of transactions truncated for " +
                           "hard recovery:\n" +
                           searchResults.dumpPassedTxns());

        /* 
         * Truncate after the environment is invalidated, which happens
         * when we instantiate RollbackException.
         */
        long matchpointLSN = searchResults.getMatchpointLSN();
        repImpl.getFileManager().truncateLog
            (DbLsn.getFileNumber(matchpointLSN),
             DbLsn.getFileOffset(matchpointLSN));

        return r;
    }

    /**
     * Request a log entry from the feeder at this VLSN. The Feeder will only
     * return the log record or say that it isn't available.
     *
     * @throws InsufficientLogException
     */
    private InputWireRecord getFeederRecord(VLSNRange range,
                                            VLSN requestVLSN,
                                            boolean acceptAlternative)
        throws IOException, InsufficientLogException {

        /* Ask the feeder for the matchpoint log record. */
        protocol.write(protocol.new EntryRequest(requestVLSN), namedChannel);

        /*
         * Expect
         *  a) the requested log record
         *  b) message that says this feeder doesn't have RequestVLSN
         *  c) if acceptAlternative == true and the feeder didn't have
         *     requestVLSN, but had an earlier entry, the feeder may send an
         *      earlier, alternative matchpoint
         */
        Message message = protocol.read(namedChannel);
        if (message instanceof Entry) {
            Entry entry = (Entry) message;
            return entry.getWireRecord();
        }

        if (message instanceof EntryNotFound) {
            LoggerUtils.info(logger, repImpl, "Requested " + requestVLSN +
                             " from " + namedChannel.getNameIdPair() + 
                             " but that node did not have that vlsn.");
            throw setupLogRefresh(requestVLSN);
        }

        if ((acceptAlternative) &&
            (message instanceof AlternateMatchpoint)) {

            AlternateMatchpoint alt = (AlternateMatchpoint) message;
            InputWireRecord feederRecord = alt.getAlternateWireRecord();
            VLSN altMatchpoint = feederRecord.getVLSN();
            if (range.getFirst().compareTo(altMatchpoint) > 0) {

                /*
                 * The feeder suggest a different matchpoint, but it's outside
                 * the replica's range. Give up and do a network restore.
                 */
                throw setupLogRefresh(altMatchpoint);
            }
            return feederRecord;
        }

        throw EnvironmentFailureException.unexpectedState
            (repNode.getRepImpl(),
             "Sent EntryRequest, got unexpected response of " + message);
    }

    

    public static void setGlobalSyncupEndHook(TestHook<Object> syncupEndHook) {
        ReplicaFeederSyncup.globalSyncupEndHook = syncupEndHook;
    }

    private boolean runHook() 
        throws InterruptedException {
        
        if (syncupEndHook != null) {
            syncupEndHook.doHook();
        }

        if (globalSyncupEndHook != null) {
            globalSyncupEndHook.doHook();
        }
        return true;
    }
    
    /** 
     * This interface is used instead of com.sleepycat.je.utilint.TestHook
     * because the doHook method needs to throw InterruptedException.
     */
     public interface TestHook<T> {
        public void doHook() throws InterruptedException;
     }
}
