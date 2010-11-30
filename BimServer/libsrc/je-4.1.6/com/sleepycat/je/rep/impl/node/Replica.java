/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.node;

import static com.sleepycat.je.rep.impl.node.ReplicaStatDefinition.N_LAG_CONSISTENCY_WAITS;
import static com.sleepycat.je.rep.impl.node.ReplicaStatDefinition.N_LAG_CONSISTENCY_WAIT_MS;
import static com.sleepycat.je.rep.impl.node.ReplicaStatDefinition.N_VLSN_CONSISTENCY_WAITS;
import static com.sleepycat.je.rep.impl.node.ReplicaStatDefinition.N_VLSN_CONSISTENCY_WAIT_MS;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.CheckpointConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.rep.CommitPointConsistencyPolicy;
import com.sleepycat.je.rep.GroupShutdownException;
import com.sleepycat.je.rep.InsufficientLogException;
import com.sleepycat.je.rep.MasterStateException;
import com.sleepycat.je.rep.ReplicaConsistencyException;
import com.sleepycat.je.rep.RestartRequiredException;
import com.sleepycat.je.rep.TimeConsistencyPolicy;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.RepParams;
import com.sleepycat.je.rep.stream.Protocol;
import com.sleepycat.je.rep.stream.ReplicaFeederHandshake;
import com.sleepycat.je.rep.stream.ReplicaFeederSyncup;
import com.sleepycat.je.rep.stream.MasterStatus.MasterSyncException;
import com.sleepycat.je.rep.stream.Protocol.Heartbeat;
import com.sleepycat.je.rep.stream.Protocol.ShutdownRequest;
import com.sleepycat.je.rep.stream.ReplicaFeederSyncup.TestHook;
import com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition;
import com.sleepycat.je.rep.utilint.NamedChannel;
import com.sleepycat.je.rep.utilint.NamedChannelWithTimeout;
import com.sleepycat.je.rep.utilint.RepUtils;
import com.sleepycat.je.rep.utilint.ServiceDispatcher;
import com.sleepycat.je.rep.utilint.BinaryProtocol.Message;
import com.sleepycat.je.rep.utilint.BinaryProtocol.MessageOp;
import com.sleepycat.je.rep.utilint.BinaryProtocol.ProtocolException;
import com.sleepycat.je.rep.utilint.RepUtils.ExceptionAwareCountDownLatch;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.Response;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ServiceConnectFailedException;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.VLSN;

/**
 * The Replica class is the locus of the replay operations and replica
 * transaction consistency tracking and management operations at a replica
 * node.
 *
 * A single instance of this class is created when the replication node is
 * created and exists for the lifetime of the replication node, although it is
 * only really used when the node is operating as a Replica.
 *
 * Note that the Replica (like the FeederManager) does not have its own
 * independent thread of control; it runs in the RepNode's thread.
 */
public class Replica {

    /* The Node to which the Replica belongs. */
    private final RepNode repNode;
    private final RepImpl repImpl;

    /* The replay component of the Replica */
    private final Replay replay;

    /* The exception that provoked the replica exit. */
    private Exception shutdownException = null;

    /* It's non null when the loop is active. */
    private NamedChannelWithTimeout replicaFeederChannel = null;

    /* The consistency component. */
    private final ConsistencyTracker consistencyTracker;

    /*
     * A test delay introduced in the replica loop to simulate a loaded
     * replica. The replica waits this amount of time before processing each
     * message.
     */
    private int testDelayMs = 0;

    /* For testing only - mimic a network partition. */
    private boolean dontProcessStream = false;

    /* Number of times to retry on a network connection failure. */
    private static final int NETWORK_RETRIES = 2 ;

    /*
     * Service unavailable retries. These are typically the result of service
     * request being made before the node is ready to provide them. For
     * example, the feeder service is only available after a node has
     * transitioned to becoming the master.
     */
    private static final int SERVICE_UNAVAILABLE_RETRIES = 10;

    /*
     * The number of ms to wait between above retries, allowing time for the
     * master to assume its role, and start listening on its port.
     */
    private static final int CONNECT_RETRY_SLEEP_MS = 1000;

    /* The protocol instance if one is currently in use by the Replica. */
    private Protocol protocol = null;

    /*
     * Protocol statistics aggregated across all past protocol instantiations.
     * It does not include the statistics for the current Protocol object in
     * use. A node can potentially go through the Replica state multiple time
     * during it's lifetime. This instance aggregates replica statistics
     * across all transitions into and out of the Replica state.
     */
    private final StatGroup aggProtoStats;

    private final Logger logger;

    /* For testing only. */
    private TestHook<Object> replicaFeederSyncupHook;

    /*
     * A cache of DatabaseImpls for the Replay to speed up DbTree.getId().
     * Cleared/invalidated by a heartbeat or if je.rep.dbIdCacheOpCount
     * operations have gone by, or if any replay operations on Name LNs are
     * executed.
     */
    private final Map<DatabaseId, DatabaseImpl> dbCache =
        new HashMap<DatabaseId, DatabaseImpl>();

    Replica(RepNode repNode, Replay replay) {
        this.repNode = repNode;
        this.repImpl = repNode.getRepImpl();
        consistencyTracker = new ConsistencyTracker();
        this.replay = replay;
        logger = LoggerUtils.getLogger(getClass());
        aggProtoStats =
            new StatGroup(BinaryProtocolStatDefinition.GROUP_NAME,
                          BinaryProtocolStatDefinition.GROUP_DESC);
        testDelayMs =
            repNode.getConfigManager().getInt(RepParams.TEST_REPLICA_DELAY);
    }

    /**
     * Shutdown the Replica, free any threads that may have been waiting for
     * the replica to reach some degree of consistency. This method is only
     * invoked as part of the repnode shutdown.
     *
     * If the shutdown is being executed from a different thread, it attempts
     * to interrupt the thread by first shutting down the channel it may be
     * waiting on for input from the feeder. The replica thread should notice
     * the channel shutdown and/or the shutdown state of the rep node itself.
     * The caller will use harsher methods, like an interrupt, if the rep node
     * thread (Replica or Feeder) is still active.
     */
    public void shutdown() {
        if (!repNode.isShutdown()) {
            throw EnvironmentFailureException.unexpectedState
                ("Rep node must have initiated the shutdown.");
        }
        consistencyTracker.shutdown();
        if (Thread.currentThread() == repNode) {
            return;
        }

        /*
         * Perform the actions to provoke a "soft" shutdown.
         *
         * Since the replica shares the RepNode thread, it will take care of
         * the actual thread shutdown itself.
         */

        /*
         * Shutdown the channel as an attempt to interrupt just the socket
         * read/write operation.
         */
        RepUtils.shutdownChannel(replicaFeederChannel);

        /*
         * Clear the latch in case the replica loop is waiting for the outcome
         * of an election.
         */
        repNode.getVLSNFreezeLatch().clearLatch();
    }

    /**
     * For unit testing only!
     */
    public void setTestDelayMs(int testDelayMs) {
        this.testDelayMs = testDelayMs;
    }

    /**
     * For unit testing only!
     */
    public void setDontProcessStream() {
        dontProcessStream = true;
    }

    public Replay replay() {
        return replay;
    }

    Map<DatabaseId, DatabaseImpl> getDbCache() {
        return dbCache;
    }

    public ConsistencyTracker getConsistencyTracker() {
        return consistencyTracker;
    }

    SocketChannel getReplicaFeederChannel() {
        return replicaFeederChannel.getChannel();
    }

    Protocol getProtocol() {
        return protocol;
    }

    /**
     * Returns the last commit VLSN at the master, as known at the replica.
     *
     * @return the commit VLSN
     */
    long getMasterCommitVLSN() {
        return consistencyTracker.getMasterCommitVLSN();
    }

    /**
     * The core control loop when the node is serving as a Replica. Note that
     * if a Replica is also serving the role of a feeder, it will run
     * additional feeder loops in separate threads. The loop exits when it
     * encounters one of the following possible conditions:
     *
     * 1) The connection to the master can no longer be maintained, due to
     * connectivity issues, or because the master has explicitly shutdown its
     * connections due to an election.
     *
     * 2) The node becomes aware of a change in master, that is, assertSync()
     * fails.
     *
     * 3) The loop is interrupted, which is interpreted as a request to
     * shutdown the replication node as a whole.
     *
     * 4) It fails to establish its node information in the master as it
     * attempts to join the replication group for the first time.
     *
     * Normal exit from this run loop results in the rep node retrying an
     * election and continuing in its new role as determined by the outcome of
     * the election. A thrown exception, on the other hand, results in the rep
     * node as a whole terminating its operation and no longer participating in
     * the replication group, that is, it enters the DETACHED state.
     *
     * Note that the in/out streams are handles synchronously on the replica,
     * while they are handled asynchronously by the Feeder.
     *
     * @throws InterruptedException
     * @throws RestoreFailedException
     * @throws DatabaseException if the environment cannot be closed/for a
     * re-init
     * @throws GroupShutdownException
     */
    void runReplicaLoop()
        throws InterruptedException,
               DatabaseException,
               GroupShutdownException {

        Class<? extends RetryException> retryExceptionClass = null;
        int retryCount = 0;
        try {

            while (true) {
                try {
                    runReplicaLoopInternal();
                    /* Normal exit */
                    break;
                } catch (RetryException e) {
                    if (!repNode.getMasterStatus().inSync()) {
                        LoggerUtils.fine(logger, repImpl,
                                         "Retry terminated, out of sync.");
                        break;
                    }
                    if ((e.getClass() == retryExceptionClass) ||
                        (e.retries == 0)) {
                        if (++retryCount >= e.retries) {
                            /* Exit replica retry elections */
                            LoggerUtils.info
                                (logger, repImpl,
                                 "Failed to recover from exception: " +
                                 e.getMessage() + ", despite " + e.retries +
                                 " retries.\n" +
                                 LoggerUtils.getStackTrace(e));
                            break;
                        }
                    } else {
                        retryCount = 0;
                        retryExceptionClass = e.getClass();
                    }
                    LoggerUtils.info(logger, repImpl, "Retry #: " +
                                     retryCount + "/" + e.retries +
                                     " Will retry replica loop after " +
                                     e.retrySleepMs + "ms. ");
                    Thread.sleep(e.retrySleepMs);
                    if (!repNode.getMasterStatus().inSync()) {
                        break;
                    }
                }
            }
        } finally {
            repNode.resetReadyLatch(shutdownException);
        }
        /* Exit use elections to try a different master. */
    }

    private void runReplicaLoopInternal()
        throws RestartRequiredException,
               InterruptedException,
               RetryException,
               InsufficientLogException {

        shutdownException = null;
        LoggerUtils.info(logger, repImpl,
                         "Replica loop started with master: " +
                         repNode.getMasterStatus().getNodeMasterNameId());
        if (testDelayMs > 0) {
            LoggerUtils.info(logger, repImpl,
                             "Test delay of: " + testDelayMs + "ms." +
                             " after each message sent");
        }
        try {
            initReplicaLoop();
            doRunReplicaLoopInternalWork();
        } catch (RestartRequiredException rre) {
            shutdownException = rre;
            throw rre;
        } catch (ClosedByInterruptException closedByInterruptException) {
            if (repNode.isShutdown()) {
                LoggerUtils.info(logger, repImpl,
                                 "Replica loop interrupted for shutdown.");
                return;
            }
            LoggerUtils.warning(logger, repImpl,
                                "Replica loop unexpected interrupt.");
            throw new InterruptedException
                (closedByInterruptException.getMessage());
        } catch (IOException e) {

            /*
             * Master may have changed with the master shutting down its
             * connection as a result. Normal course of events, log it and
             * return to the outer node level loop.
             */
            LoggerUtils.info(logger, repImpl,
                             "Replica IO exception: " + e.getMessage() +
                             "\n" + LoggerUtils.getStackTrace(e));
        } catch (RetryException e) {
            /* Propagate it outwards. Node does not need to shutdown. */
            throw e;
        } catch (GroupShutdownException e) {
            shutdownException = e;
            throw e;
        } catch (RuntimeException e) {
            shutdownException = e;
            LoggerUtils.severe(logger, repImpl,
                               "Replica unexpected exception " + e +
                                " " + LoggerUtils.getStackTrace(e));
            throw e;
        } catch (MasterSyncException e) {
            /* expected change in masters from an election. */
            LoggerUtils.info(logger, repImpl, e.getMessage());
        } catch (Exception e) {
            shutdownException = e;
            LoggerUtils.severe(logger, repImpl,
                               "Replica unexpected exception " + e +
                               " " + LoggerUtils.getStackTrace(e));
            throw EnvironmentFailureException.unexpectedException(e);
        } finally {
            loopExitCleanup();
        }
    }

    protected void doRunReplicaLoopInternalWork()
        throws Exception {

        final int dbTreeCacheClearingOpCount =
            repNode.getDbTreeCacheClearingOpCount();
        long opCount = 0;

        final int timeoutMs = repNode.getConfigManager().
            getDuration(RepParams.REPLICA_TIMEOUT);
        replicaFeederChannel.setTimeoutMs(timeoutMs);

        while (true) {
            Message message = protocol.read(replicaFeederChannel);

            if (repNode.isShutdown() || (message == null)) {
                return;
            }
            repNode.getMasterStatus().assertSync();
            MessageOp messageOps = message.getOp();
            if (messageOps == Protocol.SHUTDOWN_REQUEST) {
                throw processShutdown((ShutdownRequest) message);
            }
            if (messageOps == Protocol.HEARTBEAT) {
                processHeartbeat(replicaFeederChannel,
                                 (Protocol.Heartbeat) message);
                /* For HA, periodically flush the Replay's dbid cache. */
                clearDbTreeCache();
            } else {
                /* For testing only! */
                if (dontProcessStream) {
                    LoggerUtils.info(logger, repImpl, "Not processing " +
                                     message);
                    continue;
                }

                replay.replayEntry(replicaFeederChannel,
                                   protocol,
                                   (Protocol.Entry) message);

                /*
                 * Note: the consistency tracking is more obscure than it needs
                 * to be, because the commit VLSN is set in
                 * Replay.replayEntry() and is then used below. An alternative
                 * would be to promote the following conditional to a level
                 * above, so commit operations get their own replay method
                 * which does the commit tracking.
                 */

                if (messageOps == Protocol.COMMIT) {
                    consistencyTracker.trackCommit();
                }
                consistencyTracker.trackVLSN();
            }

            if (testDelayMs > 0) {
                Thread.sleep(testDelayMs);
            }

            if (opCount++ % dbTreeCacheClearingOpCount == 0) {
                clearDbTreeCache();
            }
        }
    }

    /**
     * Process the shutdown message from the master and return the
     * GroupShutdownException that must be thrown to exit the Replica loop.
     *
     * @return the GroupShutdownException
     */
    private GroupShutdownException processShutdown(ShutdownRequest shutdown)
        throws IOException {

        CheckpointConfig config = new CheckpointConfig();
        config.setForce(true);
        repNode.getRepImpl().invokeCheckpoint(config, false, "Group Shutdown");
        repNode.getRepImpl().shutdownDaemons();
        protocol.write(protocol.new ShutdownResponse(), replicaFeederChannel);

        return new GroupShutdownException(logger,
                                          repNode,
                                          shutdown.getShutdownTimeMs());
    }

    /**
     * Initialize for replica loop entry, which involves completing the
     * following steps successfully:
     *
     * 1) The replica feeder handshake.
     * 2) The replica feeder syncup.
     * 3) Processing the first heartbeat request from the feeder.
     */
    private void initReplicaLoop()
        throws IOException,
               ConnectRetryException,
               DatabaseException,
               ProtocolException,
               InterruptedException {

        createReplicaFeederChannel();
        ReplicaFeederHandshake handshake =
            new ReplicaFeederHandshake(repNode, replicaFeederChannel);
        protocol = handshake.execute();
        ReplicaFeederSyncup syncup =
            new ReplicaFeederSyncup(repNode, replay, replicaFeederChannel,
                                    protocol);
        syncup.execute(repNode.getCBVLSNTracker());
        VLSN matchedTxnVLSN = syncup.getMatchedVLSN();
        long matchedTxnCommitTime = syncup.getMatchedVLSNTime();
        consistencyTracker.reinit(matchedTxnVLSN.getSequence(),
                                  matchedTxnCommitTime);
        Protocol.Heartbeat heartbeat =
            protocol.read(replicaFeederChannel.getChannel(),
                          Protocol.Heartbeat.class);
        processHeartbeat(replicaFeederChannel, heartbeat);
        long replicaDelta = consistencyTracker.getMasterCommitVLSN() -
            consistencyTracker.lastReplayedVLSN.getSequence();
        LoggerUtils.info(logger, repImpl, String.format
                         ("Replica initialization completed. Replica VLSN: %s "
                          + " Heartbeat master commit VLSN: %,d " +
                          "VLSN delta: %,d",
                          consistencyTracker.lastReplayedVLSN,
                          consistencyTracker.getMasterCommitVLSN(),
                          replicaDelta));

        /*
         * The replica is ready for business, indicate that the node is
         * ready by counting down the latch and releasing any waiters.
         */
        repNode.getReadyLatch().countDown();
    }

    /**
     * Process a heartbeat message. It sends back a response and updates
     * the consistency tracker with the information in the heartbeat.
     *
     * @param channel
     * @param heartbeat
     * @throws IOException
     */
    private void processHeartbeat(NamedChannel namedChannel,
                                  Heartbeat heartbeat)
        throws IOException {

        protocol.write(protocol.new HeartbeatResponse
                       (repNode.getCBVLSNTracker().getBroadcastCBVLSN()),
                       namedChannel);
        consistencyTracker.trackHeartbeat(heartbeat);
    }

    /**
     * Performs the cleanup actions upon exit from the internal replica loop.
     *
     * @param replicaFeederChannel
     */
    private void loopExitCleanup() {

        if (shutdownException != null) {
            if (shutdownException instanceof RetryException) {
                LoggerUtils.info(logger, repImpl,
                                 "Retrying connection to feeder. Message: " +
                                 shutdownException.getMessage());
            } else if (shutdownException instanceof GroupShutdownException) {
                LoggerUtils.info(logger, repImpl,
                                 "Exiting inner Replica loop." +
                                 " Master requested shutdown.");
            } else {
                LoggerUtils.warning
                    (logger, repImpl,
                     "Exiting inner Replica loop with exception " +
                     shutdownException + "\n" +
                     LoggerUtils.getStackTrace(shutdownException));
            }
        } else {
            LoggerUtils.info(logger, repImpl, "Exiting inner Replica loop." );
        }

        clearDbTreeCache();
        RepUtils.shutdownChannel(replicaFeederChannel);

        if (consistencyTracker != null) {
            consistencyTracker.logStats();
        }

        /* Sum up statistics for the loop. */
        if (protocol != null) {
            aggProtoStats.addAll(protocol.getStats(StatsConfig.DEFAULT));
        }
        protocol = null;
    }

    /*
     * Clear the DatabaseId -> DatabaseImpl cache used to speed up DbTree
     * lookup operations.  Called during heartbeats and operations on the
     * DbTree (truncate, remove, rename).
     */
    void clearDbTreeCache() {
        repNode.getRepImpl().getDbTree().releaseDbs(dbCache);
        dbCache.clear();
    }

    /**
     * Invoked when this node transitions to the master state. Aborts all
     * inflight replay transactions outstanding from a previous state as a
     * Replica, because they were initiated by a different master and will
     * never complete. Also, release any Replica transactions that were waiting
     * on consistency policy requirements.
     */
    void masterTransitionCleanup()
        throws DatabaseException {

        replay.abortOldTxns();
        consistencyTracker.forceTripLatches
            (new MasterStateException(repNode.getRepImpl().
                                      getStateChangeEvent()));
    }

    /**
     * Returns a channel used by the Replica to connect to the Feeder. The
     * socket is configured with a read timeout that's a multiple of the
     * heartbeat interval to help detect, or initiate a change in master.
     *
     * @throws IOException
     * @throws ConnectRetryException
     */
    private void createReplicaFeederChannel()
        throws IOException, ConnectRetryException {

        SocketChannel channel = SocketChannel.open();

        final DbConfigManager configManager = repNode.getConfigManager();
        final int timeoutMs = repNode.getConfigManager().
            getDuration(RepParams.PRE_HEARTBEAT_TIMEOUT);

        replicaFeederChannel =
            new NamedChannelWithTimeout(repNode, channel, timeoutMs);

        Socket socket = channel.socket();
        /*
         * Note that soTimeout is not set since it's a blocking channel and
         * setSoTimeout has no effect on a blocking nio channel.
         */
        channel.configureBlocking(true);

        /*
         * Push responses out rapidly, they are small (heart beat or commit
         * response) and need timely delivery to the master.
         */
        socket.setTcpNoDelay(true);

        try {
            final int openTimeout = configManager.
                getDuration(RepParams.REPSTREAM_OPEN_TIMEOUT);
            socket.connect(repNode.getMasterStatus().getNodeMaster(),
                           openTimeout);
            ServiceDispatcher.doServiceHandshake
                (channel, FeederManager.FEEDER_SERVICE);
        } catch (ConnectException e) {

            /*
             * A network problem, or the node went down between the time we
             * learned it was the master and we tried to connect.
             */
            throw new ConnectRetryException(e.getMessage(),
                                            NETWORK_RETRIES,
                                            CONNECT_RETRY_SLEEP_MS);
        } catch (ServiceConnectFailedException e) {

            /*
             * The feeder may not have established the Feeder Service
             * as yet. For example, the transition to the master may not have
             * been completed. Wait longer.
             */
           if (e.getResponse() == Response.UNKNOWN_SERVICE) {
               throw new ConnectRetryException(e.getMessage(),
                                               SERVICE_UNAVAILABLE_RETRIES,
                                               CONNECT_RETRY_SLEEP_MS);
           }
           throw EnvironmentFailureException.unexpectedException(e);
        }
   }

    /**
     * Returns the replay statistics associated with the Replica.
     *
     * @return the statistics.
     */
    public StatGroup getReplayStats(StatsConfig config) {
        return replay.getStats(config);
    }

    /* Get the protocl statistics for this replica. */
    public StatGroup getProtocolStats(StatsConfig config) {
        StatGroup protoStats = aggProtoStats.cloneGroup(config.getClear());

        /* Guard against concurrent modification. */
        Protocol prot = this.protocol;
        if (prot != null) {
            /* These statistics are not ye a part of the agg statistics. */
            protoStats.addAll(prot.getStats(config));
        }

        return protoStats;
    }

    /* Get the consistency tracker stats for this replica. */
    public StatGroup getTrackerStats(StatsConfig config) {
        return consistencyTracker.getStats(config);
    }

    /* Reset the stats associated with this Replica. */
    public void resetStats() {
        replay.resetStats();
        aggProtoStats.clear();
        if (protocol != null) {
            protocol.resetStats();
        }
        consistencyTracker.resetStats();
    }

    /**
     * Tracks the consistency of this replica wrt the Master. It provides the
     * mechanisms that will cause a beginTransaction() or a joinGroup() to wait
     * until the specified consistency policy is satisfied.
     */
    public class ConsistencyTracker {
        private final long NULL_VLSN_SEQUENCE = VLSN.NULL_VLSN.getSequence();

        /*
         * Initialized by the Feeder handshake and updated by commit replays.
         * All access to lastReplayedXXXX must be synchronized on the
         * ConsistencyTracker itself.
         */
        private long lastReplayedTxnVLSN = NULL_VLSN_SEQUENCE;
        private VLSN lastReplayedVLSN = VLSN.NULL_VLSN;
        private long txnMasterCommitTime = 0l;

        /* Updated by heartbeats */
        private long masterCommitVLSN;
        private long masterNow = 0l;

        private final StatGroup stats =
            new StatGroup(ReplicaStatDefinition.GROUP_NAME,
                          ReplicaStatDefinition.GROUP_DESC);

        private final LongStat nLagConsistencyWaits =
            new LongStat(stats, N_LAG_CONSISTENCY_WAITS);

        private final LongStat nLagConsistencyWaitMs =
            new LongStat(stats, N_LAG_CONSISTENCY_WAIT_MS);

        private final LongStat nVLSNConsistencyWaits =
            new LongStat(stats, N_VLSN_CONSISTENCY_WAITS);

        private final LongStat nVLSNConsistencyWaitMs =
            new LongStat(stats, N_VLSN_CONSISTENCY_WAIT_MS);

        private final OrderedLatches vlsnLatches =
            new OrderedLatches(repNode.getRepImpl()) {
                /*
                 * Note that this assumes that NULL_VLSN is -1, and that
                 * the vlsns ascend.
                 */
                @Override
                    boolean tripPredicate(long keyVLSN, long tripVLSN) {
                    return keyVLSN <= tripVLSN;
                }
            };

        private final OrderedLatches lagLatches =
            new OrderedLatches(repNode.getRepImpl()) {
                @Override
                boolean tripPredicate(long keyLag, long currentLag) {
                    return currentLag <= keyLag;
                }
            };

        /**
         * Invoked each time after a replica syncup so that the Replica
         * can re-establish it's consistency vis a vis the master and what
         * part of the replication stream it considers as having been replayed.
         *
         * @param matchedTxnVLSN the replica state corresponds to this txn
         * @param matchedCommitTime the time at which this txn was committed
         * on the master
         */
        void reinit(long matchedTxnVLSN, long matchedCommitTime) {
            this.lastReplayedVLSN = new VLSN(matchedTxnVLSN);
            this.lastReplayedTxnVLSN = matchedTxnVLSN;
            this.txnMasterCommitTime = matchedCommitTime;
        }

        public long getMasterCommitVLSN() {
            return masterCommitVLSN;
        }

        void close() {
            logStats();
        }

        void logStats() {
            if (logger.isLoggable(Level.INFO)) {
                LoggerUtils.info
                    (logger, repImpl,
                    "Replica stats - Lag waits: " + nLagConsistencyWaits.get() +
                     " Lag wait time: " + nLagConsistencyWaitMs.get()
                     + "ms. " +
                     " VLSN waits: " + nVLSNConsistencyWaits.get() +
                     " Lag wait time: " +  nVLSNConsistencyWaitMs.get() +
                     "ms.");
            }
        }

        /**
         * Calculates the time lag in ms at the Replica.
         */
        private long currentLag() {
            if (masterNow == 0l) {

                /*
                 * Have not seen a heartbeat, can't determine the time lag in
                 * its absence. It's the first message sent by the feeder after
                 * completion of the handshake.
                 */
                return Integer.MAX_VALUE;
            }

            long lag;
            if (lastReplayedTxnVLSN < masterCommitVLSN) {
                lag = System.currentTimeMillis() - txnMasterCommitTime;
            } else if (lastReplayedTxnVLSN == masterCommitVLSN) {

                /*
                 * The lag is determined by the transactions (if any) that are
                 * further downstream, assume the worst.
                 */
                lag = System.currentTimeMillis() - masterNow;
            } else {
               /* commit leapfrogged the heartbeat */
               lag = System.currentTimeMillis() - masterNow;
            }
            return lag;
        }

        /**
         * Frees all the threads that are waiting on latches.
         *
         * @param exception the exception to be thrown to explain the reason
         * behind the latches being forced.
         */
        synchronized void forceTripLatches(DatabaseException exception) {
            assert (exception != null);
            vlsnLatches.trip(Long.MAX_VALUE, exception);
            lagLatches.trip(0, exception);
        }

        synchronized void trackCommit() {
            Replay.TxnInfo lastReplayedTxn = replay.getLastReplayedTxn();
            lastReplayedTxnVLSN = lastReplayedTxn.getTxnVLSN().getSequence();
            txnMasterCommitTime = lastReplayedTxn.getMasterCommitTime();

            if ((lastReplayedTxnVLSN > masterCommitVLSN) &&
                (txnMasterCommitTime >= masterNow)) {
                masterCommitVLSN = lastReplayedTxnVLSN;
                masterNow = txnMasterCommitTime;
            }

            /*
             * Advances both replica VLSN and commit time, trip qualifying
             * latches in both sets.
             */
            vlsnLatches.trip(lastReplayedTxnVLSN, null);
            lagLatches.trip(currentLag(), null);
        }

        synchronized void trackVLSN() {
            lastReplayedVLSN = replay.getLastReplayedVLSN();
            vlsnLatches.trip(lastReplayedVLSN.getSequence(), null);
        }

        synchronized void trackHeartbeat(Protocol.Heartbeat heartbeat) {
            masterCommitVLSN = heartbeat.getCurrentCommitVLSN();
            masterNow = heartbeat.getMasterNow();
            /* Trip just the time lag latches. */
            lagLatches.trip(currentLag(), null);
        }

        public void lagAwait(TimeConsistencyPolicy consistencyPolicy)
            throws InterruptedException,
                   ReplicaConsistencyException,
                   DatabaseException {

            long currentLag = currentLag();
            long lag =
                consistencyPolicy.getPermissibleLag(TimeUnit.MILLISECONDS);
            if (currentLag <= lag) {
                return;
            }
            long waitStart = System.currentTimeMillis();
            ExceptionAwareCountDownLatch waitLagLatch =
                lagLatches.getOrCreate(lag);
            await(waitLagLatch, consistencyPolicy);
            nLagConsistencyWaits.increment();
            nLagConsistencyWaitMs.add(System.currentTimeMillis() - waitStart);
        }

        /**
         * Wait until the commit log record identified by VLSN has gone by.
         */
        public void commitVLSNAwait(long vlsn,
                                    ReplicaConsistencyPolicy consistencyPolicy)
            throws InterruptedException,
                   ReplicaConsistencyException,
                   DatabaseException {

            VLSNAwait(vlsn, consistencyPolicy);
        }

        /**
         * Wait until the log record identified by VLSN has gone by.
         */
        public void anyVLSNAwait(long vlsn,
                                 ReplicaConsistencyPolicy consistencyPolicy)
            throws InterruptedException,
                   ReplicaConsistencyException,
                   DatabaseException {

            VLSNAwait(vlsn, consistencyPolicy);
        }

        /**
         * The implementation of the VLSN wait.
         */
        private void VLSNAwait(long vlsn,
                               ReplicaConsistencyPolicy consistencyPolicy)
            throws InterruptedException,
                   ReplicaConsistencyException,
                   DatabaseException {

            long waitStart = System.currentTimeMillis();

            ExceptionAwareCountDownLatch waitVLSNLatch = null;

            synchronized(this) {
                final long compareVLSN =
                   (consistencyPolicy instanceof CommitPointConsistencyPolicy)?
                    lastReplayedTxnVLSN :
                    lastReplayedVLSN.getSequence();
                if (vlsn <= compareVLSN) {
                    return;
                }
                waitVLSNLatch = vlsnLatches.getOrCreate(vlsn);
            }
            await(waitVLSNLatch, consistencyPolicy);
            /* Stats after the await, so the counts and times are related. */
            nVLSNConsistencyWaits.increment();
            nVLSNConsistencyWaitMs.add(System.currentTimeMillis() - waitStart);
        }

        /**
         * Wait on the given countdown latch and generate the appropriate
         * exception upon timeout.
         *
         * @throws InterruptedException
         */
        private void await(ExceptionAwareCountDownLatch consistencyLatch,
                           ReplicaConsistencyPolicy consistencyPolicy)
            throws ReplicaConsistencyException,
                   DatabaseException,
                   InterruptedException {

            if (!consistencyLatch.awaitOrException
                 (consistencyPolicy.getTimeout(TimeUnit.MILLISECONDS),
                  TimeUnit.MILLISECONDS)) {
                /* Timed out. */
                final boolean detached =
                    repNode.getRepImpl().getState().isDetached();
                throw new ReplicaConsistencyException(consistencyPolicy,
                                                      detached);
            }
        }

        private StatGroup getStats(StatsConfig config) {
            if (config.getClear()) {
                stats.clear();
            }
            StatGroup ret = stats.cloneGroup(false);

            return ret;
        }

        private void resetStats() {
            stats.clear();
        }

        /**
         * Shutdown the consistency tracker. This is typically done as part
         * of the shutdown of a replication node. It counts down all open
         * latches, so the threads waiting on them can make progress. It's
         * the responsibility of the waiting threads to check whether the
         * latch countdown was due to a shutdown, and take appropriate action.
         */
        public void shutdown() {
            forceTripLatches(EnvironmentFailureException.unexpectedException
                             ("Node: " + repNode.getNameIdPair() +
                              " was shut down.",
                              repNode.getSavedShutdownException()));
        }
    }

    /**
     * Manages a set of ordered latches. They are ordered by the key value.
     */
    private abstract class OrderedLatches {

        final EnvironmentImpl envImpl;

        final SortedMap<Long, ExceptionAwareCountDownLatch> latchMap =
            new TreeMap<Long, ExceptionAwareCountDownLatch>();

        abstract boolean tripPredicate(long key, long tripValue);

        OrderedLatches(EnvironmentImpl envImpl) {
            this.envImpl = envImpl;
        }

        synchronized ExceptionAwareCountDownLatch getOrCreate(Long key) {
            ExceptionAwareCountDownLatch latch = latchMap.get(key);
            if (latch == null) {
                latch = new ExceptionAwareCountDownLatch(envImpl, 1);
                latchMap.put(key, latch);
            }
            return latch;
        }

        /**
         * Trip all latches until the first latch that will not trip.
         *
         * @param tripValue
         * @param exception the exception to be thrown by the waiter upon
         * exit from the await. It can be null if no exception need be thrown.
         */
        synchronized void trip(long tripValue,
                               DatabaseException exception) {
            while (latchMap.size() > 0) {
                Long key = latchMap.firstKey();
                if (!tripPredicate(key, tripValue)) {
                    /* It will fail on the rest as well. */
                    return;
                }
                /* Set the waiters free. */
                ExceptionAwareCountDownLatch latch = latchMap.remove(key);
                latch.releaseAwait(exception);
            }
        }
    }

    /**
     * Thrown to indicate that the Replica must retry connecting to the same
     * master, after some period of time.
     */
    @SuppressWarnings("serial")
    static class RetryException extends Exception {
        final int retries;
        final int retrySleepMs;

        RetryException(String message,
                       int retries,
                       int retrySleepMs) {
            super(message);
            this.retries = retries;
            this.retrySleepMs = retrySleepMs;
        }

        @Override
        public String getMessage() {
          return "Failed after retries: " + retries +
                 " with retry interval: " + retrySleepMs + "ms.";
        }
    }


    @SuppressWarnings("serial")
    static class ConnectRetryException extends RetryException {

        ConnectRetryException(String message,
                              int retries,
                              int retrySleepMs) {
            super(message, retries, retrySleepMs);
        }
    }

    /**
     * Set a test hook which is executed when the ReplicaFeederSyncup
     * finishes. This differs from the static method
     * ReplicaFeederSyncup.setGlobalSyncupHook in that it sets the hook for a
     * specific node, whereas the other method is static and sets it globally.
     *
     * This method is required when a test is trying to set the hook for only
     * one node, and the node already exists. The other method is useful when a
     * test is trying to set the hook before a node exists.
     */
    public void setReplicaFeederSyncupHook(TestHook<Object> syncupHook) {
        replicaFeederSyncupHook = syncupHook;
    }

    public TestHook<Object> getReplicaFeederSyncupHook() {
        return replicaFeederSyncupHook;
    }
}
