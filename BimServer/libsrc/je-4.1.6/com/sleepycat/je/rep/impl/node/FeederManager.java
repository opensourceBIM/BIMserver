/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.node;

import static com.sleepycat.je.rep.impl.node.FeederManagerStatDefinition.N_FEEDERS_CREATED;
import static com.sleepycat.je.rep.impl.node.FeederManagerStatDefinition.N_FEEDERS_SHUTDOWN;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.Durability.ReplicaAckPolicy;
import com.sleepycat.je.rep.InsufficientReplicasException;
import com.sleepycat.je.rep.MasterReplicaTransitionException;
import com.sleepycat.je.rep.impl.RepNodeImpl;
import com.sleepycat.je.rep.stream.MasterStatus.MasterSyncException;
import com.sleepycat.je.rep.txn.MasterTxn;
import com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition;
import com.sleepycat.je.rep.utilint.RepUtils;
import com.sleepycat.je.rep.utilint.SizeAwaitMap;
import com.sleepycat.je.rep.vlsn.VLSNRange;
import com.sleepycat.je.utilint.IntStat;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StatGroup;

/**
 * FeedManager is responsible for the creation and management of the Feeders
 * used to respond to connections initiated by a Replica. runfeeders() is the
 * central loop that listens for replica connections and manages the lifecycle
 * of individual Feeders. It's re-entered each time the node becomes a Master
 * and is exited when its status changes.
 *
 * There is a single instance of FeederManager that is created for a
 * replication node. There are many instances of Feeders per FeederManager.
 * Each Feeder instance represents an instance of a connection between the node
 * serving as the feeder and the replica.
 *
 * Note that the FeederManager and the Replica currently reuse the Replication
 * node's thread of control. When we implement r2r we will need to revisit the
 * thread management to provide for concurrent operation of the FeederManger
 * and the Replica.
 */
final public class FeederManager {

    private final RepNode repNode;

    /*
     * The queue into which the ServiceDispatcher queues socket channels for
     * new Feeder instances.
     */
    private final BlockingQueue<SocketChannel> channelQueue =
        new LinkedBlockingQueue<SocketChannel>();

    /*
     * The collection of active feeders currently feeding replicas. The map is
     * indexed by the Replica's node id. Access to this map must be
     * synchronized, since it's updated concurrently by the Feeders that share
     * it.
     *
     * A feeder is considered to be active after it has completed the handshake
     * sequence with its associated Replica.
     */
    private final SizeAwaitMap<String, Feeder> activeFeeders =
        new SizeAwaitMap<String, Feeder>
            (Collections.synchronizedMap(new HashMap<String, Feeder>()));

    /*
     * Nascent feeders that are starting up and are not yet active. They have
     * network connections but have not synched up or completed handshakes.
     * They are moved into the feeder map, once they become active.
     */
    private final Set<Feeder> nascentFeeders =
        Collections.synchronizedSet(new HashSet<Feeder>());

    /*
     * A test delay introduced in the feeder loop to simulate a loaded master.
     * The feeder waits this amount of time after each message is sent.
     */
    private int testDelayMs=0;

    /* Set to true to force a shutdown of the FeederManager. */
    AtomicBoolean shutdown = new AtomicBoolean(false);

    /*
     * Non null if the replication node must be shutdown as well. This is
     * typically the result of an unexpected exception in the feeder.
     */
    private RuntimeException repNodeShutdownException;
    private final Logger logger;

    /* FeederManager statistics. */
    private final StatGroup stats;
    private final IntStat nFeedersCreated;
    private final IntStat nFeedersShutdown;

    /* The frequency with which the Feeder checks for a master change */
    private static final int MASTER_CHANGE_CHECK_TIMEOUT = 1000;

    /* Identifies the Feeder Service. */
    public static final String FEEDER_SERVICE = "Feeder";

    FeederManager(RepNode repNode) {
        this.repNode = repNode;
        logger = LoggerUtils.getLogger(getClass());
        stats = new StatGroup(FeederManagerStatDefinition.GROUP_NAME,
                              FeederManagerStatDefinition.GROUP_DESC);
        nFeedersCreated = new IntStat(stats, N_FEEDERS_CREATED);
        nFeedersShutdown = new IntStat(stats, N_FEEDERS_SHUTDOWN);
    }

    /**
     * Returns the statistics associated with the FeederManager.
     *
     * @return the statistics
     */
    public StatGroup getFeederManagerStats(StatsConfig config) {
        StatGroup cloneStats = stats.cloneGroup(false);

        return cloneStats;
    }

    /* Get the protocol stats for this FeederManager. */
    public StatGroup getProtocolStats(StatsConfig config) {
        /* Aggregate stats that have not yet been aggregated. */
        StatGroup protocolStats =
            new StatGroup(BinaryProtocolStatDefinition.GROUP_NAME,
                          BinaryProtocolStatDefinition.GROUP_DESC);
        synchronized (activeFeeders) {
            for (Feeder feeder : activeFeeders.values()) {
                protocolStats.addAll(feeder.getProtocolStats(config));
            }
        }

        return protocolStats;
    }

    /* Reset the feeders' stats of this FeederManager. */
    public void resetStats() {
        synchronized (activeFeeders) {
            stats.clear();
            for (Feeder feeder : activeFeeders.values()) {
                feeder.resetStats();
            }
        }
    }

    /**
     * Accumulates statistics from a terminating feeder.
     * @param stats
     */
    void incStats(StatGroup feederStats) {
        stats.addAll(feederStats);
    }

    public int getTestDelayMs() {
        return testDelayMs;
    }

    public void setTestDelayMs(int testDelayMs) {
        this.testDelayMs = testDelayMs;
    }

    /**
     * Returns the RepNode associated with the FeederManager
     * @return
     */
    RepNode repNode() {
        return repNode;
    }

    /**
     * Returns the Feeder associated with the node, if such a feeder is
     * currently active.
     */
    public Feeder getFeeder(String nodeName) {
        return activeFeeders.get(nodeName);
    }

    /*
     * For test use only.
     */
    public Feeder putFeeder(String nodeName, Feeder feeder) {
        return activeFeeders.put(nodeName, feeder);
    }

    void setRepNodeShutdownException(RuntimeException rNSE) {
        this.repNodeShutdownException = rNSE;
    }

    /**
     * The numbers of Replicas currently "active" with this feeder. Active
     * currently means they are connected. It does not make any guarantees
     * about where they are in the replication stream. They may, for example,
     * be too far behind to participate in timely acks.
     *
     * @return the active replica count
     */
    public int activeReplicaCount() {
        return activeFeeders.size();
    }

    /**
     * Returns the set of Replicas that are currently active with this feeder.
     * A replica is active if it has completed the handshake sequence.
     *
     * @return the set of replica node ids.
     */
    public Set<String> activeReplicas() {
        synchronized (activeFeeders) {

            /*
             * Create a copy to avoid inadvertent concurrency conflicts,
             * since the keySet is a view of the underlying map.
             */
            return new HashSet<String>(activeFeeders.keySet());
        }
    }

    /**
     * Transitions a Feeder to being active, so that it can be used in
     * considerations relating to commit acknowledgments.
     *
     * @param feeder the feeder being transitioned.
     *
     * @throws DuplicateReplicaException if the Feeder is already active.
     * @throws InterruptedException
     */
    void activateFeeder(Feeder feeder)
        throws InterruptedException {

        synchronized (nascentFeeders) {
            synchronized(activeFeeders) {
                boolean removed = nascentFeeders.remove(feeder);
                if (feeder.isShutdown()) {
                    return;
                }
                assert(removed);
                String replicaName = feeder.getReplicaNameIdPair().getName();
                assert(!feeder.getReplicaNameIdPair().equals(NameIdPair.NULL));
                Feeder dup = activeFeeders.get(replicaName);
                if ((dup != null) && !dup.isShutdown()) {
                    throw EnvironmentFailureException.
                        unexpectedState(repNode.getRepImpl(),
                                        feeder.getReplicaNameIdPair() +
                                        " is present in both nascent and " +
                                        "active feeder sets");
                }
                activeFeeders.put(replicaName, feeder);
            }
        }
    }

    /**
     * Remove the feeder from the sets used to track it. Invoked when a feeder
     * is shutdown.
     *
     * @param feeder
     */
    void removeFeeder(Feeder feeder) {
        assert(feeder.isShutdown());
        synchronized (nascentFeeders) {
            synchronized(activeFeeders) {
                nascentFeeders.remove(feeder);
                String replicaName = feeder.getReplicaNameIdPair().getName();

                activeFeeders.remove(replicaName);
            }
        }
    }

    /**
     * Clears and shuts down the runFeeders by inserting a special EOF marker
     *  value into the queue.
     */
    void shutdownQueue() {
        if (!repNode.isShutdown()) {
            throw EnvironmentFailureException.unexpectedState
                ("Rep node is still active");
        }
        channelQueue.clear();
        /* Add special entry so that the channelQueue.poll operation exits. */
        channelQueue.add(RepUtils.CHANNEL_EOF_MARKER);
    }

    /**
     * The core feeder listener loop that is run either in a Master node, or in
     * a Replica that is serving as a Feeder to other Replica nodes. The core
     * loop accepts connections from Replicas as they come in and establishes a
     * Feeder on that connection.
     *
     * The loop can be terminated for one of the following reasons:
     *
     *  1) A change in Masters.
     *
     *  2) A forced shutdown, via a thread interrupt.
     *
     *  3) A server socket level exception.
     *
     * The timeout on the accept is used to ensure that the check is done at
     * least once per timeout period.
     */
    void runFeeders()
        throws DatabaseException {

        if (shutdown.get()) {
            throw EnvironmentFailureException.unexpectedState
                ("Feeder manager was shutdown");
        }
        Exception feederShutdownException = null;
        LoggerUtils.info(logger, repNode.getRepImpl(),
                         "Feeder manager accepting requests.");

        /*
         * Note that LastVLSN may not be a commit VLSN, but it's good enough
         * for the purposes of the heartbeat to get the ball rolling. It means
         * that transactions initiated on the Replica will wait until they at
         * least get to this point in the replication stream. Any new
         * transactions on the master will replace it with a VLSN truly
         * representing a newly committed transaction.
         */
        VLSNRange range = repNode.getVLSNIndex().getRange();
        repNode.currentCommitVLSN(range.getLast());

        /* This updater represents the masters's local cbvlsn, which the master
           updates directly. */
        final LocalCBVLSNUpdater updater =
            new LocalCBVLSNUpdater(repNode.getNameIdPair(), repNode);
        final LocalCBVLSNTracker tracker = repNode.getCBVLSNTracker();

        try {
            repNode.getServiceDispatcher().
                register(FEEDER_SERVICE, channelQueue);

            /*
             * The Feeder is ready for business, indicate that the node is
             * ready by counting down the latch and releasing any waiters.
             */
            repNode.getReadyLatch().countDown();

            while (true) {
                final SocketChannel feederReplicaChannel =
                    channelQueue.poll(MASTER_CHANGE_CHECK_TIMEOUT,
                                      TimeUnit.MILLISECONDS);

                if (feederReplicaChannel == RepUtils.CHANNEL_EOF_MARKER) {
                    LoggerUtils.info(logger, repNode.getRepImpl(),
                                     "Feeder manager soft shutdown.");
                    return;
                }

                repNode.getMasterStatus().assertSync();
                if (feederReplicaChannel == null) {
                    if (repNode.isShutdown()) {
                        /* Timeout and shutdown request */
                        LoggerUtils.info(logger, repNode.getRepImpl(),
                                         "Feeder manager forced shutdown.");
                        return;
                    }

                    /*
                     * Take this opportunity to update this node's CBVLSN The
                     * replicas are sending in their CBVLSNs through the
                     * heartbeat responses, but a master does not send any
                     * heartbeat responses, and needs a different path to
                     * update its local CBVLSN.
                     */
                    updater.updateForMaster(tracker);
                    continue;
                }

                nFeedersCreated.increment();
                try {
                    Feeder feeder = new Feeder(this, feederReplicaChannel);
                    nascentFeeders.add(feeder);
                    feeder.startFeederThreads();
                } catch (IOException e) {

                    /*
                     * Indicates a feeder socket level exception.
                     */
                    LoggerUtils.fine
                        (logger, repNode.getRepImpl(),
                         "Feeder I/O exception: " + e.getMessage());
                    try {
                        feederReplicaChannel.close();
                    } catch (IOException e1) {
                        LoggerUtils.fine
                            (logger, repNode.getRepImpl(),
                             "Exception during cleanup." + e.getMessage());
                    }
                    continue;
                }
            }
        } catch (MasterSyncException e) {
            feederShutdownException = e;
            LoggerUtils.info(logger, repNode.getRepImpl(),
                             "Master change: " + e.getMessage());

            /*
             * Currently, a Master cannot change from Master to Replica state
             * without going through recovery. The problem is that in order to
             * have the proper locking and transactional state as a replica,
             * active MasterTxns must be shut down, and replaced with
             * ReplayTxns. A MasterReplicaException is a
             * RestartRequiredException and will make the environment go
             * through recovery.  
             *
             * An alternative would have been to go through the transaction
             * manager to find and convert active transactions to the proper
             * ReplayTxn.Another option is to permit a state conversion without
             * recovery when there are no active transactions. The added
             * complexity did not seem worth the benefit of reducing the need
             * to reopen the environment handle in limited situations. [#19177]
             */
            throw new MasterReplicaTransitionException(repNode.getRepImpl(), e);
        } catch (InterruptedException e) {
            if (this.repNodeShutdownException != null) {

                /*
                 * The interrupt was issued to propagate an exception from one
                 * of the Feeder threads. It's not a normal exit.
                 */
                LoggerUtils.warning(logger, repNode.getRepImpl(),
                                    "Feeder manager unexpected interrupt");
                throw repNodeShutdownException; /* Terminate the rep node */
            }
            if (repNode.isShutdown()) {
                LoggerUtils.info(logger, repNode.getRepImpl(),
                                 "Feeder manager interrupted for shutdown");
                return;
            }
            feederShutdownException = e;
            LoggerUtils.warning(logger, repNode.getRepImpl(),
                                "Feeder manager unexpected interrupt");
        } finally {
            repNode.resetReadyLatch(feederShutdownException);
            repNode.getServiceDispatcher().cancel(FEEDER_SERVICE);
            shutdownFeeders(feederShutdownException);
            LoggerUtils.info(logger, repNode.getRepImpl(),
                             "Feeder manager exited. CurrentCommit VLSN: " +
                             repNode.getCurrentCommitVLSN());
        }
    }

    /**
     * Shuts down all the feeders managed by the FeederManager
     *
     * @param feederShutdownException the exception provoking the shutdown.
     */
    private void shutdownFeeders(Exception feederShutdownException) {

        boolean changed = shutdown.compareAndSet(false, true);
        if (!changed) {
            return;
        }

        try {
            /* Copy sets for safe iteration in the presence of deletes.*/
            Set<Feeder> feederSet = null;
            synchronized (activeFeeders) {
                feederSet = new HashSet<Feeder>(activeFeeders.values());
            }

            synchronized (nascentFeeders) {
                feederSet.addAll(nascentFeeders);
            }

            for (Feeder feeder : feederSet) {
                nFeedersShutdown.increment();
                feeder.shutdown(feederShutdownException);
            }
        } finally {
            activeFeeders.clear();
            nascentFeeders.clear();
        }
    }

    /**
     * Shuts down a specific feeder. It's typically done in response to the
     * removal of a member from the group.
     */
    public void shutdownFeeder(RepNodeImpl node) {
        Feeder feeder = activeFeeders.get(node.getName());
        if (feeder == null) {
            return;
        }
        nFeedersShutdown.increment();
        feeder.shutdown(null);
    }

    /**
     * Ensures that the required number of replicas are active if the node is
     * currently the master. If the node is not the master it simply returns.
     *
     * @param requiredReplicaCount the total nodes required by the transaction
     * @param insufficientReplicasTimeout the amount of time (in ms) that the
     * Feeder will wait for the requiredReplicaCount
     * @throws InterruptedException
     * @throws DatabaseException if the wait timed out.
     */
    public void ensureReplicasForCommit(MasterTxn txn,
                                        ReplicaAckPolicy ackPolicy,
                                        int requiredReplicaCount,
                                        int insufficientReplicasTimeout)
        throws InterruptedException, DatabaseException {

        assert(requiredReplicaCount > 0);
        if (!repNode.isMaster()) {
            return;
        }
        if (activeFeeders.sizeAwait(requiredReplicaCount-1,
                                    insufficientReplicasTimeout,
                                    TimeUnit.MILLISECONDS)) {
            /* Wait was successful */
            return;
        }
        if (!repNode.isMaster()) {

            /*
             *  Continue if we are no longer the master after the wait. The
             *  transaction will fail if it tries to acquire write locks, or
             *  at commit.
             */
            return;
        }
        if (repNode.tryActivatePrimary()) {
            return;
        }

        throw new InsufficientReplicasException
            (txn, ackPolicy, requiredReplicaCount, activeReplicas());
    }

    /*
     * For debugging help, and for expanded exception messages, dump feeder
     * related state.
     */
    public String dumpState() {
        StringBuilder sb = new StringBuilder();
        synchronized(activeFeeders) {
            Set<Map.Entry<String, Feeder>> feeds = activeFeeders.entrySet();
            if (feeds.size() == 0) {
                sb.append("No feeders.");
            } else {
                sb.append("Current feeds:");
                for (Map.Entry<String, Feeder> feedEntry : feeds) {
                    sb.append("\n ").append(feedEntry.getKey()).append(": ").
                        append(feedEntry.getValue().dumpState());
                }
            }
        }
        return sb.toString();
    }
}
