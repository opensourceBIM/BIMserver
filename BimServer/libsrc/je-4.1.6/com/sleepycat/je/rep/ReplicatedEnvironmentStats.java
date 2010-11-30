/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.io.Serializable;

import static com.sleepycat.je.rep.impl.node.FeederManagerStatDefinition.N_FEEDERS_CREATED;
import static com.sleepycat.je.rep.impl.node.FeederManagerStatDefinition.N_FEEDERS_SHUTDOWN;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.MAX_COMMIT_PROCESSING_NANOS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.MIN_COMMIT_PROCESSING_NANOS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.N_ABORTS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.N_COMMITS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.N_COMMIT_ACKS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.N_COMMIT_NO_SYNCS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.N_COMMIT_SYNCS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.N_COMMIT_WRITE_NO_SYNCS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.N_ELAPSED_TXN_TIME;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.N_LNS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.N_NAME_LNS;
import static com.sleepycat.je.rep.impl.node.ReplayStatDefinition.TOTAL_COMMIT_PROCESSING_NANOS;
import static com.sleepycat.je.rep.impl.node.ReplicaStatDefinition.N_LAG_CONSISTENCY_WAITS;
import static com.sleepycat.je.rep.impl.node.ReplicaStatDefinition.N_LAG_CONSISTENCY_WAIT_MS;
import static com.sleepycat.je.rep.impl.node.ReplicaStatDefinition.N_VLSN_CONSISTENCY_WAITS;
import static com.sleepycat.je.rep.impl.node.ReplicaStatDefinition.N_VLSN_CONSISTENCY_WAIT_MS;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.BYTES_READ_RATE;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.BYTES_WRITE_RATE;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.MESSAGE_READ_RATE;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.MESSAGE_WRITE_RATE;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_BYTES_READ;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_BYTES_WRITTEN;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_MESSAGES_READ;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_MESSAGES_WRITTEN;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_READ_NANOS;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_WRITE_NANOS;

import java.util.HashMap;
import java.util.Map;

import com.sleepycat.je.Environment;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.rep.impl.node.FeederManager;
import com.sleepycat.je.rep.impl.node.FeederManagerStatDefinition;
import com.sleepycat.je.rep.impl.node.ReplayStatDefinition;
import com.sleepycat.je.rep.impl.node.Replica;
import com.sleepycat.je.rep.impl.node.ReplicaStatDefinition;
import com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition;
import com.sleepycat.je.utilint.IntegralRateStat;
import com.sleepycat.je.utilint.StatGroup;

/**
 * Statistics for a replicated environment.
 * <p>
 * The statistics are logically grouped into four categories. Viewing the
 * statistics through {@link ReplicatedEnvironmentStats#toString()} displays
 * the values in these categories, as does viewing the stats through the {@link
 * <a href="{@docRoot}/../jconsole/JConsole-plugin.html">RepJEMonitor
 * mbean</a>}.  Viewing the stats with {@link
 * ReplicatedEnvironmentStats#toStringVerbose()} will provide more detailed
 * descriptions of the stats and stat categories.
 * <p>
 * The current categories are:
 * <ul>
 *  <li><b>FeederManager</b>: A feed is the {@link <a
 * href="{@docRoot}/../ReplicationGuide/introduction.html#replicationstreams">replication
 * stream</a>} between a master and replica. The current number of feeders
 * gives a sense of the connectivity of the replication group.
 *  </li>
 *  <li><b>BinaryProtocol</b>: These statistics center on the network traffic
 *   engendered by the replication stream, and provide a sense of the network
 *   bandwidth seen by the replication group.
 *  </li>
 *  <li><b>Replay</b>: The act of receiving and applying the replication stream
 *  at the Replica node is called Replay. These stats give a sense of how much
 *  load the replica node is experiencing when processing the traffic from the
 *  replication group.
 *  </li>
 *  <li><b>ConsistencyTracker</b>: The tracker is invoked when consistency
 *  policies are used at a replica node. This provides a measure of delays
 *  experienced by read requests at a replica, in order to conform with the
 *  consistency specified by the application.
 *  </li>
 * </ul>
 *
 * @see <a href="{@docRoot}/../jconsole/JConsole-plugin.html">Viewing
 * Statistics with JConsole</a>
 */
public class ReplicatedEnvironmentStats implements Serializable {
    private static final long serialVersionUID = 1L;

    private final StatGroup feederManagerStats;
    private final StatGroup replayStats;
    private final StatGroup trackerStats;
    private final StatGroup protocolStats;
    private final Map<String, String> tipsMap = new HashMap<String, String>();

    ReplicatedEnvironmentStats(FeederManager feederManager, 
                                      Replica replica, 
                                      StatsConfig config) {
        this.feederManagerStats = feederManager.getFeederManagerStats(config);
        this.replayStats = replica.getReplayStats(config);
        this.trackerStats = replica.getTrackerStats(config);
        this.protocolStats = feederManager.getProtocolStats(config);

        protocolStats.addAll(replica.getProtocolStats(config));
        addMessageRateStats();
        addBytesRateStats();
    }

    /**
     * @hidden
     * Internal use only
     * 
     * For JConsole plugin support.
     */
    public static String[] getStatGroupTitles() {
        return new String[] {
            FeederManagerStatDefinition.GROUP_NAME,
            BinaryProtocolStatDefinition.GROUP_NAME,
            ReplayStatDefinition.GROUP_NAME,
            ReplicaStatDefinition.GROUP_NAME};
    }

    private void addMessageRateStats() {
        IntegralRateStat msgReadRate = 
            new IntegralRateStat(protocolStats, MESSAGE_READ_RATE, 
                                 protocolStats.getLongStat(N_MESSAGES_READ),
                                 protocolStats.getLongStat(N_READ_NANOS), 
                                 1000000000);

        IntegralRateStat msgWriteRate = 
            new IntegralRateStat(protocolStats, 
                                 MESSAGE_WRITE_RATE, 
                                 protocolStats.getLongStat(N_MESSAGES_WRITTEN),
                                 protocolStats.getLongStat(N_WRITE_NANOS),
                                 1000000000);
    }

    private void addBytesRateStats() {
        IntegralRateStat bytesReadRate = 
            new IntegralRateStat(protocolStats,
                                 BYTES_READ_RATE, 
                                 protocolStats.getLongStat(N_BYTES_READ),
                                 protocolStats.getLongStat(N_READ_NANOS),
                                 1000000000);

        IntegralRateStat bytesWriteRate =
            new IntegralRateStat(protocolStats, 
                                 BYTES_WRITE_RATE, 
                                 protocolStats.getLongStat(N_BYTES_WRITTEN),
                                 protocolStats.getLongStat(N_WRITE_NANOS),
                                 1000000000);
    }

    /* Feeder Stats. */

    /**
     * The number of Feeder threads since this node was started. A Master
     * supplies the Replication Stream to a Replica via a Feeder thread. The
     * Feeder thread is created when a Replica connects to the node and is
     * shutdown when the connection is terminated.
     */
    public int getNFeedersCreated() {
        return feederManagerStats.getInt(N_FEEDERS_CREATED);
    }

    /**
     * The number of Feeder threads that were shut down, either because this
     * node, or the Replica terminated the connection.
     *
     * @see #getNFeedersCreated()
     */
    public int getNFeedersShutdown() {
        return feederManagerStats.getInt(N_FEEDERS_SHUTDOWN);
    }

    /* Replay Stats. */

    /**
     * The number of commit log records that were replayed by this node when
     * it was a Replica. There is one commit record record for each actual
     * commit on the Master.
     */
    public long getNReplayCommits() {
        return replayStats.getLong(N_COMMITS);
    }

    /**
     * The number of commit log records that needed to be acknowledged to the
     * Master by this node when it was a Replica. The rate of change of this
     * statistic, will show a strong correlation with that of
     * <code>NReplayCommits</code> statistic, if the <code>Durability</code>
     * policy used by transactions on the master calls for transaction commit
     * acknowledgments and the Replica is current with respect to the Master.
     */
    public long getNReplayCommitAcks() {
        return replayStats.getLong(N_COMMIT_ACKS);
    }

    /**
     * The number of commitSync() calls executed when satisfying transaction
     * commit acknowledgment requests from the Master.
     */
    public long getNReplayCommitSyncs() {
        return replayStats.getLong(N_COMMIT_SYNCS);
    }

    /**
     * The number of commitNoSync() calls executed when satisfying transaction
     * commit acknowledgment requests from the Master.
     */
    public long getNReplayCommitNoSyncs() {
        return replayStats.getLong(N_COMMIT_NO_SYNCS);
    }

    /**
     * The number of commitNoSync() calls executed when satisfying transaction
     * commit acknowledgment requests from the Master.
     */
    public long getNReplayCommitWriteNoSyncs() {
        return replayStats.getLong(N_COMMIT_WRITE_NO_SYNCS);
    }

    /**
     * The number of abort records which were replayed while the node was in
     * the Replica state.
     */
    public long getNReplayAborts() {
        return replayStats.getLong(N_ABORTS);
    }

    /**
     * The number of NameLN records which were replayed while the node was in
     * the Replica state.
     */
    public long getNReplayNameLNs() {
        return replayStats.getLong(N_NAME_LNS);
    }

    /**
     * The number of data records (creation, update, deletion) which were
     * replayed while the node was in the Replica state.
     */
    public long getNReplayLNs() {
        return replayStats.getLong(N_LNS);
    }

    /**
     * The total elapsed time in milliseconds spent replaying committed and
     * aborted transactions.
     */
    public long getReplayElapsedTxnTime() {
        return replayStats.getLong(N_ELAPSED_TXN_TIME);
    }

    /**
     * The minimum time taken to replay a transaction commit operation.
     */
    public long getReplayMinCommitProcessingNanos() {
        return replayStats.getLong(MIN_COMMIT_PROCESSING_NANOS);
    }

    /**
     * The maximum time taken to replay a transaction commit operation.
     */
    public long getReplayMaxCommitProcessingNanos() {
        return replayStats.getLong(MAX_COMMIT_PROCESSING_NANOS);
    }

    /**
     * The total time spent to replay all commit operations.
     */
    public long getReplayTotalCommitProcessingNanos() {
        return replayStats.getLong(TOTAL_COMMIT_PROCESSING_NANOS);
    }

    /* Protocol Stats. */

    /**
     * The number of bytes of Replication Stream read over the network. It does
     * not include the TCP/IP overhead.
     * <p>
     * If the node has served as both a Replica and Master since it was first
     * started, the number represents the sum total of all Feeder related
     * network activity, as well as Replica network activity.
     */
    public long getNProtocolBytesRead() {
        return protocolStats.getLong(N_BYTES_READ);
    }

    /**
     * The number of Replication Stream messages read over the network.
     * <p>
     * If the node has served as both a Replica and Master since it was first
     * started, the number represents the sum total of all Feeder related
     * network activity, as well as Replica network activity.
     */
    public long getNProtocolMessagesRead() {
        return protocolStats.getLong(N_MESSAGES_READ);
    }

    /**
     * The number of Replication Stream bytes written over the network.
     * <p>
     * If the node has served as both a Replica and Master since it was first
     * started, the number represents the sum total of all Feeder related
     * network activity, as well as Replica network activity.
     */
    public long getNProtocolBytesWritten() {
        return protocolStats.getLong(N_BYTES_WRITTEN);
    }

    /**
     * The number of Replication Stream messages written over the network.
     * <p>
     * If the node has served as both a Replica and Master since it was first
     * started, the number represents the sum total of all Feeder related
     * network activity, as well as Replica network activity.
     */
    public long getNProtocolMessagesWritten() {
        return protocolStats.getLong(N_MESSAGES_WRITTEN);
    }

    /**
     * The number of nanoseconds spent reading from the network channel.
     * <p>
     * If the node has served as both a Replica and Master since it was first
     * started, the number represents the sum total of all Feeder related
     * network activity, as well as Replica network activity.
     */
    public long getProtocolReadNanos() {
        return protocolStats.getLong(N_READ_NANOS);
    }

    /**
     * The number of nanoseconds spent writing to the network channel.
     * <p>
     * If the node has served as both a Replica and Master since it was first
     * started, the number represents the sum total of all Feeder related
     * network activity, as well as Replica network activity.
     */
    public long getProtocolWriteNanos() {
        return protocolStats.getLong(N_WRITE_NANOS);
    }

    /**
     * Incoming replication message throughput, in terms of messages received
     * from the replication network channels per second.
     * <p> If the node has served as both a Replica and Master since
     * it was first started, the number represents the message reading rate
     * over all Feeder related network activity, as well as Replica network
     * activity.
     */
    public long getProtocolMessageReadRate() {
        return protocolStats.getLong(MESSAGE_READ_RATE);
    }

    /**
     * Outgoing message throughput, in terms of message written to the
     * replication network channels per second.
     * <p>
     * If the node has served as both a Replica and Master since it was first
     * started, the number represents the message writing rate over all Feeder 
     * related network activity, as well as Replica network activity.
     */
    public long getProtocolMessageWriteRate() {
        return protocolStats.getLong(MESSAGE_WRITE_RATE);
    }

    /**
     * Bytes read throughput, in terms of bytes received from the replication
     * network channels per second.
     * <p>
     * If the node has served as both a Replica and Master since it was first
     * started, the number represents the bytes reading rate over all Feeder
     * related network activity, as well as Replica network activity.
     */
    public long getProtocolBytesReadRate() {
        return protocolStats.getLong(BYTES_READ_RATE);
    }

    /**
     * Bytes written throughput, in terms of bytes written to the replication
     * network channels per second.
     * <p>
     * If the node has served as both a Replica and Master since it was first
     * started, the number represents the bytes writing rate over all Feeder
     * related network activity, as well as Replica network activity.
     */
    public long getProtocolBytesWriteRate() {
        return protocolStats.getLong(BYTES_WRITE_RATE);
    }

    /* ConsistencyTracker Stats. */

    /**
     * The number of times a Replica held back a
     * {@link Environment#beginTransaction(Transaction,TransactionConfig)}
     * operation to satisfy the {@link TimeConsistencyPolicy}.
     */
    public long getTrackerLagConsistencyWaits() {
        return trackerStats.getLong(N_LAG_CONSISTENCY_WAITS);
    }

    /**
     * The total time (in msec) for which a Replica held back a
     * {@link Environment#beginTransaction(Transaction,TransactionConfig)}
     * operation to satisfy the {@link TimeConsistencyPolicy}.
     */
    public long getTrackerLagConsistencyWaitMs() {
        return trackerStats.getLong(N_LAG_CONSISTENCY_WAIT_MS);
    }

    /**
     * The number of times a Replica held back a
     * {@link Environment#beginTransaction(Transaction,TransactionConfig)}
     * operation to satisfy the {@link CommitPointConsistencyPolicy}.
     */
    public long getTrackerVLSNConsistencyWaits() {
        return trackerStats.getLong(N_VLSN_CONSISTENCY_WAITS);
    }

    /**
     * The total time (in msec) for which a Replica held back a
     * {@link Environment#beginTransaction(Transaction,TransactionConfig)}
     * operation to satisfy the {@link CommitPointConsistencyPolicy}.
     */
    public long getTrackerVLSNConsistencyWaitMs() {
        return trackerStats.getLong(N_VLSN_CONSISTENCY_WAIT_MS);
    }

    /**
     * Returns a string representation of the statistics.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        /* FeederManager Statistics. */
        sb.append(feederManagerStats.toString());

        /* Protocol Statistics. */
        sb.append(protocolStats.toString());

        /* Replay Statistics. */
        sb.append(replayStats.toString());

        /* Tracker Statistics. */
        sb.append(trackerStats.toString());

        return sb.toString();
    }

    public String toStringVerbose() {
        StringBuilder sb = new StringBuilder();
        
        /* FeederManager Statistics. */
        sb.append(feederManagerStats.toStringVerbose());

        /* Protocol Statistics. */
        sb.append(protocolStats.toStringVerbose());

        /* Replay Statistics. */
        sb.append(replayStats.toStringVerbose());

        /* Tracker Statistics. */
        sb.append(trackerStats.toStringVerbose());

        return sb.toString();
    }

    public Map<String, String> getTips() {
        /* Add FeederManager stats definition. */
        tipsMap.put(feederManagerStats.getName(),
                    feederManagerStats.getDescription());
        tipsMap.put(N_FEEDERS_CREATED.getName(),
                    N_FEEDERS_CREATED.getDescription());
        tipsMap.put(N_FEEDERS_SHUTDOWN.getName(),
                    N_FEEDERS_SHUTDOWN.getDescription());

        /* Add Protocol stats definition. */
        tipsMap.put(protocolStats.getName(), protocolStats.getDescription());
        tipsMap.put(BYTES_READ_RATE.getName(), 
                    BYTES_READ_RATE.getDescription());
        tipsMap.put(BYTES_WRITE_RATE.getName(),
                    BYTES_WRITE_RATE.getDescription());
        tipsMap.put(MESSAGE_READ_RATE.getName(),
                    MESSAGE_READ_RATE.getDescription());
        tipsMap.put(MESSAGE_WRITE_RATE.getName(),
                    MESSAGE_WRITE_RATE.getDescription());
        tipsMap.put(N_BYTES_READ.getName(), N_BYTES_READ.getDescription());
        tipsMap.put(N_BYTES_WRITTEN.getName(),
                    N_BYTES_WRITTEN.getDescription());
        tipsMap.put(N_MESSAGES_READ.getName(),
                    N_MESSAGES_READ.getDescription());
        tipsMap.put(N_MESSAGES_WRITTEN.getName(),
                    N_MESSAGES_WRITTEN.getDescription());
        tipsMap.put(N_READ_NANOS.getName(), N_READ_NANOS.getDescription());
        tipsMap.put(N_WRITE_NANOS.getName(), N_WRITE_NANOS.getDescription());

        /* Add Replay stats definition. */
        tipsMap.put(replayStats.getName(), replayStats.getDescription());
        tipsMap.put(MAX_COMMIT_PROCESSING_NANOS.getName(),
                    MAX_COMMIT_PROCESSING_NANOS.getDescription());
        tipsMap.put(MIN_COMMIT_PROCESSING_NANOS.getName(),
                    MIN_COMMIT_PROCESSING_NANOS.getDescription());
        tipsMap.put(N_ABORTS.getName(), N_ABORTS.getDescription());
        tipsMap.put(N_COMMITS.getName(), N_COMMITS.getDescription());
        tipsMap.put(N_COMMIT_ACKS.getName(), N_COMMIT_ACKS.getDescription());
        tipsMap.put(N_COMMIT_NO_SYNCS.getName(),
                    N_COMMIT_NO_SYNCS.getDescription());
        tipsMap.put(N_COMMIT_SYNCS.getName(), N_COMMIT_SYNCS.getDescription());
        tipsMap.put(N_COMMIT_WRITE_NO_SYNCS.getName(),
                    N_COMMIT_WRITE_NO_SYNCS.getDescription());
        tipsMap.put(N_ELAPSED_TXN_TIME.getName(),
                    N_ELAPSED_TXN_TIME.getDescription());
        tipsMap.put(N_LNS.getName(), N_LNS.getDescription());
        tipsMap.put(N_NAME_LNS.getName(), N_NAME_LNS.getDescription());
        tipsMap.put(TOTAL_COMMIT_PROCESSING_NANOS.getName(),
                    TOTAL_COMMIT_PROCESSING_NANOS.getDescription());

        /* Add Tracker stats definition. */
        tipsMap.put(trackerStats.getName(), trackerStats.getDescription());
        tipsMap.put(N_LAG_CONSISTENCY_WAITS.getName(),
                    N_LAG_CONSISTENCY_WAITS.getDescription());
        tipsMap.put(N_LAG_CONSISTENCY_WAIT_MS.getName(),
                    N_LAG_CONSISTENCY_WAIT_MS.getDescription());
        tipsMap.put(N_VLSN_CONSISTENCY_WAITS.getName(),
                    N_VLSN_CONSISTENCY_WAITS.getDescription());
        tipsMap.put(N_VLSN_CONSISTENCY_WAIT_MS.getName(),
                    N_VLSN_CONSISTENCY_WAIT_MS.getDescription());

        return tipsMap;
    }
}
