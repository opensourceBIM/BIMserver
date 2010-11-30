/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.stream;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.ChecksumException;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.node.Feeder;
import com.sleepycat.je.rep.impl.node.LocalCBVLSNUpdater;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.stream.Protocol.EntryRequest;
import com.sleepycat.je.rep.stream.Protocol.RestoreRequest;
import com.sleepycat.je.rep.stream.Protocol.StartStream;
import com.sleepycat.je.rep.utilint.NamedChannel;
import com.sleepycat.je.rep.utilint.BinaryProtocol.Message;
import com.sleepycat.je.rep.vlsn.VLSNIndex;
import com.sleepycat.je.rep.vlsn.VLSNRange;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.VLSN;

/**
 * Establish where the replication stream should start for a feeder and replica
 * pair. The Feeder's job is to send the replica the parts of the replication
 * stream it needs, so that the two can determine a common matchpoint.
 *
 * If a successful matchpoint is found the feeder learns where to start the
 * replication stream for this replica.
 */
public class FeederReplicaSyncup {

    private final Feeder feeder;
    private final RepNode repNode;
    private final NamedChannel namedChannel;
    private final Protocol protocol;
    private final VLSNIndex vlsnIndex;
    private final Logger logger;
    private FeederSyncupReader backwardsReader;

    public FeederReplicaSyncup(Feeder feeder,
                               NamedChannel namedChannel,
                               Protocol protocol) {
        this.feeder = feeder;
        this.repNode = feeder.getRepNode();
        logger = LoggerUtils.getLogger(getClass());
        this.namedChannel = namedChannel;
        this.protocol = protocol;
        this.vlsnIndex = repNode.getVLSNIndex();
    }

    /**
     * The feeder's side of the protocol. Find out where to start the
     * replication stream.
     * @return the VLSN to start the replication stream
     * @throws InterruptedException
     * @throws NetworkRestoreException
     * @throws ChecksumException
     */
    public VLSN execute(LocalCBVLSNUpdater replicaCBVLSN)
        throws DatabaseException,
               IOException,
               InterruptedException,
               NetworkRestoreException, ChecksumException {

        final long startTime = System.currentTimeMillis();
        RepImpl repImpl = repNode.getRepImpl();
        LoggerUtils.info(logger, repImpl,
                         "Feeder-replica " +
                         feeder.getReplicaNameIdPair().getName() + 
                         " syncup started. Feeder range: " + 
                         repNode.getVLSNIndex().getRange());

        repNode.syncupStarted();
        try {

            /*
             * Wait for the replica to start the syncup message exchange. The
             * first message will always be an EntryRequest. This relies on the
             * fact that a brand new group always begins with a master that has
             * a few vlsns from creating the nameDb that exist before a replica
             * syncup. The replica will never issue a StartStream before doing
             * an EntryRequest.
             *
             * The first entry request has three possible types of message
             * responses - EntryNotFound, AlternateMatchpoint, or Entry.
             */
            VLSNRange range = vlsnIndex.getRange();
            EntryRequest firstRequest =
                (EntryRequest) protocol.read(namedChannel);
            Message response = makeResponseToEntryRequest(range,
                                                          firstRequest,
                                                          true);

            protocol.write(response, namedChannel);

            /*
             * Now the replica may send one of three messages:
             * - a StartStream message indicating that the replica wants to
             * start normal operations
             * - a EntryRequest message if it's still hunting for a
             * matchpoint. There's the possiblity that the new EntryRequest
             * asks for a VLSN that has been log cleaned, so check that we can
             * supply it.
             * - a RestoreRequest message that indicates that the replica
             * has given up, and will want a network restore.
             */

            VLSN startVLSN = null;
            while (true) {
                Message message = protocol.read(namedChannel);
                if (logger.isLoggable(Level.FINEST)) {
                    LoggerUtils.finest(logger, repImpl,
                                       "Replica " +
                                       feeder.getReplicaNameIdPair() +
                                       " message op: " + message.getOp());
                }
                if (message instanceof StartStream) {
                    startVLSN = ((StartStream) message).getVLSN();
                    break;
                } else if (message instanceof EntryRequest) {
                    response = makeResponseToEntryRequest
                        (range, (EntryRequest)message, false);
                    protocol.write(response, namedChannel);
                } else if (message instanceof RestoreRequest) {
                    throw answerRestore(range,
                                        ((RestoreRequest) message).getVLSN());
                } else {
                    throw EnvironmentFailureException.unexpectedState
                        (repImpl,
                         "Expected StartStream or EntryRequest but got " +
                         message);
                }
            }

            LoggerUtils.info(logger, repImpl,
                             "Feeder-replica " +  
                             feeder.getReplicaNameIdPair().getName() +
                             " start stream at VLSN: " + startVLSN );

            return startVLSN;
        } catch (NetworkRestoreException e) {
            /*
             * The replica will retry after a network restore starting at 
             * least the current group CBVLSN.
             */
            replicaCBVLSN.updateForReplica(repNode.getGroupCBVLSN());
            throw e;
        } finally {
            repNode.syncupEnded();
            LoggerUtils.info
                (logger, repImpl,
                 String.format("Feeder-replica " + 
                               feeder.getReplicaNameIdPair().getName() + 
                               " syncup ended. Elapsed time: %,dms",
                               (System.currentTimeMillis() - startTime)));

        }
    }

    private FeederSyncupReader setupReader(VLSN startVLSN)
        throws DatabaseException, IOException {

        EnvironmentImpl envImpl = repNode.getRepImpl();
        int readBufferSize = envImpl.getConfigManager().
            getInt(EnvironmentParams.LOG_ITERATOR_READ_SIZE);

        /*
         * A BackwardsReader for scanning the log file backwards. It must not
         * go past the global CBVLSN, because the log cleaner is allowed to
         * delete anything < the global CBVLSN, even during syncup.
         */
        long lastUsedLsn = envImpl.getFileManager().getLastUsedLsn();
        long finishLsn = DbLsn.makeLsn(repNode.getCleanerBarrierFile(), 0);
        return new FeederSyncupReader(envImpl,
                                      vlsnIndex,
                                      lastUsedLsn,
                                      readBufferSize,
                                      repNode.getNameIdPair(),
                                      startVLSN,
                                      finishLsn);
    }

    private Message makeResponseToEntryRequest(VLSNRange range,
                                               EntryRequest request,
                                               boolean isFirstResponse)
        throws IOException, ChecksumException {

        VLSN requestMatchpoint = request.getVLSN();

        /*
         * We need to guarantee that we will be able to service the replication
         * stream after a matchpoint is chosen. Because of that, the matchpoint
         * must be >= the first in the rep stream, for obvious reasons (we
         * wouldn't have the log record), and also >= the global CBVLSN (the
         * log cleaner is allowed to delete anything < the global CBVLSN.
         */

        VLSN globalCBVLSN = repNode.getGroupCBVLSN();
        if (globalCBVLSN.isNull()) {
            if (range.getFirst().compareTo(requestMatchpoint) > 0) {
                /*
                 * This case can only happen if the node's log was created as
                 * the result of a network restore or a standalone
                 * conversion. The global CBVLSN is not set yet, and the range
                 * does not start with 1. If the node had been populated the
                 * usual way, the global CBVLSN would be set.
                 */
                return protocol.new EntryNotFound();
            }
        } else {
            if (globalCBVLSN.compareTo(requestMatchpoint) > 0) {
                return protocol.new EntryNotFound();
            }
        }

        /*
         * The global CBVLSN should have throttle log cleaning, so the first
         * value in the range should always be <= the global CBVLSN.
         */
        if (!globalCBVLSN.isNull() &&
            range.getFirst().compareTo(globalCBVLSN) > 0) {
            throw EnvironmentFailureException.unexpectedState
                ("Range " + range + " precedes globalCBVLSN " + globalCBVLSN);
        }

        if (range.getLast().compareTo(requestMatchpoint) < 0) {

            /*
             * The matchpoint is after the last one in the range. We have to
             * suggest the lastSync entry on this node as an alternative.
             */
            assert backwardsReader == null : " should be the first response";
            if (range.getLastSync().equals(VLSN.NULL_VLSN)) {
                /*
                 * We have no syncable entry at all. The replica will have to
                 * do a network restore.
                 */
                return protocol.new EntryNotFound();
            }

            if (isFirstResponse) {
                backwardsReader = setupReader(range.getLastSync());
                OutputWireRecord lastSync =
                    backwardsReader.scanBackwards(range.getLastSync());
                assert lastSync != null :
                "Look for alternative, range=" + range;
                return protocol.new AlternateMatchpoint(lastSync);
            }

            throw EnvironmentFailureException.unexpectedState
                (repNode.getRepImpl(), "RequestMatchpoint=" +
                 requestMatchpoint + " range=" + range +
                 "should only happen on first response");
        }

        /* The matchpoint is within the range. Find it. */
        if (backwardsReader == null) {
            backwardsReader = setupReader(requestMatchpoint);
        }

        OutputWireRecord matchRecord =
            backwardsReader.scanBackwards(requestMatchpoint);
        if (matchRecord == null) {
            throw EnvironmentFailureException.unexpectedState
                (repNode.getRepImpl(),
                 "Couldn't find matchpoint " + requestMatchpoint +
                 " in log. VLSN range=" + range + " globalCBVLSN=" +
                 globalCBVLSN);
        }
        return protocol.new Entry(matchRecord);
    }

    private NetworkRestoreException answerRestore(VLSNRange range,
                                                  VLSN failedMatchpoint)
        throws IOException {

        Message response = protocol.new
            RestoreResponse(repNode.getGroupCBVLSN(),
                            repNode.getLogProviders());
        protocol.write(response, namedChannel);

        return new NetworkRestoreException(failedMatchpoint,
                                           range.getFirst(),
                                           range.getLast(),
                                           feeder.getReplicaNameIdPair());
    }

    @SuppressWarnings("serial")
    static public class NetworkRestoreException extends Exception {
        /* The out-of-range vlsn that provoked the exception */
        private final VLSN vlsn;
        private final VLSN firstVLSN;
        private final VLSN lastVLSN;

        /* The replica that made the request. */
        private final NameIdPair replicaNameIdPair;

        public NetworkRestoreException(VLSN vlsn,
                                       VLSN firstVLSN,
                                       VLSN lastVLSN,
                                       NameIdPair replicaNameIdPair) {
            this.vlsn = vlsn;
            this.firstVLSN = firstVLSN;
            this.lastVLSN = lastVLSN;
            this.replicaNameIdPair = replicaNameIdPair;
        }

        @Override
        public String getMessage() {
            return "Matchpoint vlsn " + vlsn + " requested by node: " +
                   replicaNameIdPair + " was outside the VLSN range: " +
                   "[" + firstVLSN + "-" + lastVLSN + "]";
        }

        public VLSN getVlsn() {
            return vlsn;
        }

        public NameIdPair getReplicaNameIdPair() {
            return replicaNameIdPair;
        }
    }
}
