/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.StringTokenizer;

/**
 * Durability defines the overall durability characteristics associated with a
 * transaction. When operating on a local environment the durability of a
 * transaction is completely determined by the local {@link SyncPolicy} that is
 * in effect. When using replication, the overall durability is a function of
 * the local {@link SyncPolicy} plus the {@link ReplicaAckPolicy} used by the
 * master and the {@link SyncPolicy} in effect at each Replica.
 */
public class Durability {

    /**
     * A convenience constant that defines a durability policy with COMMIT_SYNC
     * for local commit synchronization.
     *
     * The replicated environment policies default to COMMIT_NO_SYNC for
     * commits of replicated transactions that need acknowledgment and
     * SIMPLE_MAJORITY for the acknowledgment policy.
     */
    public static final Durability COMMIT_SYNC =
        new Durability(SyncPolicy.SYNC,                // localSync
                       SyncPolicy.NO_SYNC,             // replicaSync
                       ReplicaAckPolicy.SIMPLE_MAJORITY);       // replicaAck

    /**
     * A convenience constant that defines a durability policy with
     * COMMIT_NO_SYNC for local commit synchronization.
     *
     * The replicated environment policies default to COMMIT_NO_SYNC for
     * commits of replicated transactions that need acknowledgment and
     * SIMPLE_MAJORITY for the acknowledgment policy.
     */
    public static final Durability COMMIT_NO_SYNC =
        new Durability(SyncPolicy.NO_SYNC,      // localSync
                       SyncPolicy.NO_SYNC,      // replicaSync
                       ReplicaAckPolicy.SIMPLE_MAJORITY);       // replicaAck

    /**
     * A convenience constant that defines a durability policy with
     * COMMIT_WRITE_NO_SYNC for local commit synchronization.
     *
     * The replicated environment policies default to COMMIT_NO_SYNC for
     * commits of replicated transactions that need acknowledgment and
     * SIMPLE_MAJORITY for the acknowledgment policy.
     */
    public static final Durability COMMIT_WRITE_NO_SYNC =
        new Durability(SyncPolicy.WRITE_NO_SYNC,// localSync
                       SyncPolicy.NO_SYNC,      // replicaSync
                       ReplicaAckPolicy.SIMPLE_MAJORITY);       // replicaAck

    /**
     * A convenience constant that defines a durability policy, with
     * <code>ReplicaAckPolicy.NONE</code> for use with a read only transaction.
     * A read only transaction on a Master, using this Durability, will thus
     * not be held up, or throw <code>InsufficientReplicasException</code>, if
     * the Master is not in contact with a sufficient number of Replicas at the
     * time the transaction was initiated. </p>
     *
     * It's worth noting that since the transaction is read only, the sync
     * policies, although specified as <code>NO_SYNC</code>, do not really
     * matter.
     */
    public static final Durability READ_ONLY_TXN =
        new Durability(SyncPolicy.NO_SYNC,      // localSync
                       SyncPolicy.NO_SYNC,      // replicaSync
                       ReplicaAckPolicy.NONE);  // replicaAck

    /**
     * Defines the synchronization policy to be used when committing a
     * transaction. High levels of synchronization offer a greater guarantee
     * that the transaction is persistent to disk, but trade that off for
     * lower performance.
     */
    public enum SyncPolicy {

        /**
         *  Write and synchronously flush the log on transaction commit.
         *  Transactions exhibit all the ACID (atomicity, consistency,
         *  isolation, and durability) properties.
         *  <p>
         *  This is the default.
         */
        SYNC,

        /**
         * Do not write or synchronously flush the log on transaction commit.
         * Transactions exhibit the ACI (atomicity, consistency, and isolation)
         * properties, but not D (durability); that is, database integrity will
         * be maintained, but if the application or system fails, it is
         * possible some number of the most recently committed transactions may
         * be undone during recovery. The number of transactions at risk is
         * governed by how many log updates can fit into the log buffer, how
         * often the operating system flushes dirty buffers to disk, and how
         * often the log is checkpointed.
         */
        NO_SYNC,

        /**
         * Write but do not synchronously flush the log on transaction commit.
         * Transactions exhibit the ACI (atomicity, consistency, and isolation)
         * properties, but not D (durability); that is, database integrity will
         * be maintained, but if the operating system fails, it is possible
         * some number of the most recently committed transactions may be
         * undone during recovery. The number of transactions at risk is
         * governed by how often the operating system flushes dirty buffers to
         * disk, and how often the log is checkpointed.
         */
        WRITE_NO_SYNC
    };

    /**
     * A replicated environment makes it possible to increase an application's
     * transaction commit guarantees by committing changes to its replicas on
     * the network. ReplicaAckPolicy defines the policy for how such network
     * commits are handled.
     * <p>
     * The choice of a ReplicaAckPolicy must be consistent across all the
     * replicas in a replication group, to ensure that the policy is
     * consistently enforced in the event of an election.
     */
    public enum ReplicaAckPolicy {

        /**
         * All replicas must acknowledge that they have committed the
         * transaction. This policy should be selected only if your replication
         * group has a small number of replicas, and those replicas are on
         * extremely reliable networks and servers.
         */
        ALL,

        /**
         * No transaction commit acknowledgments are required and the master
         * will never wait for replica acknowledgments. In this case,
         * transaction durability is determined entirely by the type of commit
         * that is being performed on the master.
         */
        NONE,

        /**
         * A simple majority of replicas must acknowledge that they have
         * committed the transaction. This acknowledgment policy, in
         * conjunction with an election policy which requires at least a simple
         * majority, ensures that the changes made by the transaction remains
         * durable if a new election is held.
         * <p>
         * This is the default.
         */
        SIMPLE_MAJORITY;

        /**
         * Returns the minimum number of replication nodes required to
         * implement the ReplicaAckPolicy for a given group size.
         *
         * @param groupSize the size of the replication group.
         *
         * @return the number of nodes that are needed
         */
        public int minAckNodes(int groupSize) {
            switch (this) {
            case ALL:
                return groupSize;
            case NONE:
                return 1;
            case SIMPLE_MAJORITY:
                return (groupSize / 2 + 1);
            default:
                throw EnvironmentFailureException.unexpectedState
                    ("Unknown ack policy: " + this);
            }
        }
    }

    /* The sync policy in effect on the local node. */
    private final SyncPolicy localSync;

    /* The sync policy in effect on a replica. */
    final private SyncPolicy replicaSync;

    /* The replica acknowledgment policy to be used. */
    final private ReplicaAckPolicy replicaAck;

    /**
     * Creates an instance of a Durability specification.
     *
     * @param localSync the SyncPolicy to be used when committing the
     * transaction locally.
     * @param replicaSync the SyncPolicy to be used remotely, as part of a
     * transaction acknowledgment, at a Replica node.
     * @param replicaAck the acknowledgment policy used when obtaining
     * transaction acknowledgments from Replicas.
     */
    public Durability(SyncPolicy localSync,
                      SyncPolicy replicaSync,
                      ReplicaAckPolicy replicaAck) {
        this.localSync = localSync;
        this.replicaSync = replicaSync;
        this.replicaAck = replicaAck;
    }

    /**
     * Parses the string and returns the durability it represents. The string
     * must have the following format:
     * <p>
     * <code>
     * <i>SyncPolicy</i>[,<i>SyncPolicy</i>[,<i>ReplicaAckPolicy</i>]]
     * </code>
     * <p>
     * The first SyncPolicy in the above format applies to the Master, and the
     * optional second SyncPolicy to the replica. Specific SyncPolicy or
     * ReplicaAckPolicy values are denoted by the name of the enumeration
     * value.
     * <p>
     * For example, the string:<i>sync,sync,quorum</i> describes a durability
     * policy where the master and replica both use {@link SyncPolicy#SYNC}
     * to commit transactions and {@link ReplicaAckPolicy#SIMPLE_MAJORITY} to
     * acknowledge a transaction commit.
     * <p>
     * {@link SyncPolicy#NO_SYNC}, is the default value for a node's
     * SyncPolicy.
     * <p>
     * {@link ReplicaAckPolicy#SIMPLE_MAJORITY} is the default for the
     * ReplicaAckPolicy.
     *
     * @param durabilityString the durability string in the above format
     *
     * @return the Durability resulting from the parse, or null if the
     * <code>durabilityString</code> argument was itself null.
     *
     * @throws IllegalArgumentException if the durabilityString is invalid.
     */
    public static Durability parse(String durabilityString) {
        if (durabilityString == null) {
            return null;
        }
        StringTokenizer tokenizer =
            new StringTokenizer(durabilityString.toUpperCase(), ",");

        if (!tokenizer.hasMoreTokens()) {
            throw new IllegalArgumentException
                ("Bad string format: " + '"' +  durabilityString + '"');
        }
        SyncPolicy localSync =
                SyncPolicy.valueOf(tokenizer.nextToken());
        SyncPolicy replicaSync = tokenizer.hasMoreTokens() ?
                SyncPolicy.valueOf(tokenizer.nextToken()) :
                SyncPolicy.NO_SYNC;
        ReplicaAckPolicy replicaAck = tokenizer.hasMoreTokens() ?
                ReplicaAckPolicy.valueOf(tokenizer.nextToken()) :
                ReplicaAckPolicy.SIMPLE_MAJORITY;
        return new Durability(localSync, replicaSync, replicaAck);
    }

    /**
     * Returns the string representation of durability in the format defined
     * by string form of the Durability constructor.
     *
     * @see #parse(String)
     */
    @Override
    public String toString() {
        return localSync.toString() + "," +
               replicaSync.toString() + "," +
               replicaAck.toString();
    }

    /**
     * Returns the transaction synchronization policy to be used locally when
     * committing a transaction.
     */
    public SyncPolicy getLocalSync() {
        return localSync;
    }

    /**
     * Returns the transaction synchronization policy to be used by the replica
     * as it replays a transaction that needs an acknowledgment.
     */
    public SyncPolicy getReplicaSync() {
        return replicaSync;
    }

    /**
     * Returns the replica acknowledgment policy used by the master when
     * committing changes to a replicated environment.
     */
    public ReplicaAckPolicy getReplicaAck() {
        return replicaAck;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((localSync == null) ? 0 : localSync.hashCode());
        result = prime * result
                + ((replicaAck == null) ? 0 : replicaAck.hashCode());
        result = prime * result
                + ((replicaSync == null) ? 0 : replicaSync.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Durability)) {
            return false;
        }
        Durability other = (Durability) obj;
        if (localSync == null) {
            if (other.localSync != null) {
                return false;
            }
        } else if (!localSync.equals(other.localSync)) {
            return false;
        }
        if (replicaAck == null) {
            if (other.replicaAck != null) {
                return false;
            }
        } else if (!replicaAck.equals(other.replicaAck)) {
            return false;
        }
        if (replicaSync == null) {
            if (other.replicaSync != null) {
                return false;
            }
        } else if (!replicaSync.equals(other.replicaSync)) {
            return false;
        }
        return true;
    }
}
