/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.util.Set;

import com.sleepycat.je.Environment;
import com.sleepycat.je.OperationFailureException;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.Durability.ReplicaAckPolicy;
import com.sleepycat.je.txn.Locker;

/**
 * Thrown by {@link Environment#beginTransaction} and {@link
 * Transaction#commit} when these operations are initiated at a Master which is
 * not in contact with a quorum of Replicas as determined by the {@link
 * ReplicaAckPolicy} that is in effect for the operation.
 */
public class InsufficientReplicasException extends OperationFailureException {
    private static final long serialVersionUID = 1;

    private final ReplicaAckPolicy commitPolicy;
    private final int requiredAckCount;
    private final Set<String> availableReplicas;

    /**
     * Creates a Commit exception.
     *
     * @param ackPolicy the ack policy that could not be implemented
     * @param requiredAckCount the replica acks required to satisfy the policy
     * @param availableReplicas the set of available Replicas
     */
    public InsufficientReplicasException(Locker locker,
                                         ReplicaAckPolicy ackPolicy,
                                         int requiredAckCount,
                                         Set<String> availableReplicas) {
        super(locker, true /*abortOnly*/,
              makeMsg(ackPolicy, requiredAckCount, availableReplicas),
              null /*cause*/);
        this.commitPolicy = ackPolicy;
        this.requiredAckCount = requiredAckCount;
        this.availableReplicas = availableReplicas;
    }

    /**
     * For internal use only.
     * @hidden
     */
    private InsufficientReplicasException(String message,
                                          InsufficientReplicasException
                                          cause) {
        super(message, cause);
        this.commitPolicy = cause.commitPolicy;
        this.requiredAckCount = cause.requiredAckCount;
        this.availableReplicas = cause.availableReplicas;
    }

    /**
     * For internal use only.
     * @hidden
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new InsufficientReplicasException(msg, this);
    }

    /**
     * Returns the Replica ack policy that was in effect for the transaction.
     *
     * @return the Replica ack policy
     */
    public ReplicaAckPolicy getCommitPolicy() {
        return commitPolicy;
    }

    /**
     * Returns the number of nodes that were required to be active in order to
     * satisfy the Replica ack policy.
     *
     * @return the required number of nodes
     */
    public int getRequiredNodeCount() {
        return requiredAckCount + 1;
    }

    /**
     * Returns the set of Replicas that were in contact with the master at the
     * time of the commit operation.
     *
     * @return a set of Replica node names
     */
    public Set<String> getAvailableReplicas() {
        return availableReplicas;
    }

    private static String makeMsg(ReplicaAckPolicy commitPolicy,
                                  int requiredAckCount,
                                  Set<String> availableReplicas) {

        String errorPrefix = "Commit policy: " + commitPolicy.name() +
            " required " + requiredAckCount + " replica" +
            (requiredAckCount > 1 ? "s. " : ". ");

        switch (availableReplicas.size()) {
        case 0:
            return errorPrefix + "But none were active with this master.";

        case 1:
            return errorPrefix + "Only replica: " + availableReplicas +
                " was available.";

        default:
            return errorPrefix + " Only the following " +
                availableReplicas.size() +
                " replicas listed here were available: " +
                availableReplicas;
        }
    }
}
