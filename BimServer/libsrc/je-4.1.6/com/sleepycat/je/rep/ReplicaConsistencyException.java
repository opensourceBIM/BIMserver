/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.util.concurrent.TimeUnit;

import com.sleepycat.je.OperationFailureException;
import com.sleepycat.je.ReplicaConsistencyPolicy;

/**
 * This exception is thrown by a Replica to indicate it could not meet the
 * consistency requirements as defined by the
 * <code>ReplicaConsistencyPolicy</code> in effect for the transaction, within
 * the allowed timeout period.
 * <p>
 * A Replica will typically keep current with its Master. However, network
 * problems, excessive load on the Master, or Replica, may prevent the Replica
 * from keeping up and the Replica may fall further behind than is permitted by
 * its consistency policy. If the Replica cannot catch up in the time defined
 * by its <code>ReplicaConsistencyPolicy</code>, it will throw this exception
 * from the {@link com.sleepycat.je.Environment#beginTransaction
 * Environment.beginTransaction} method, thus preventing the transaction from
 * accessing data that does not meet its consistency requirements.
 * <p>
 * If this exception is encountered frequently, it indicates that the
 * consistency policy requirements are too strict and cannot be met routinely
 * given the load being placed on the system and the hardware resources that
 * are available to service the load. The exception may also indicate that
 * there is a network related issue that is preventing the Replica from
 * communicating with the master and keeping up with the replication stream. 
 * <p>
 * The application can choose to retry the transaction, until the underlying
 * system problem has been resolved. Or it can try relaxing the consistency
 * constraints, or choose the {@link NoConsistencyRequiredPolicy} so that the
 * constraints can be satisfied more easily.
 * For example, in a {@link <a href=
 * "{@docRoot}/../ReplicationGuide/lifecycle.html#twonode"> two node
 * replication group</a>}, if the primary goes down, the application may want
 * the secondary node to continue to service read requests, and will lower the
 * consistency requirement on that node in order to maintain read availability.
 *
 * @see ReplicaConsistencyPolicy
 * @see <a href="{@docRoot}/../ReplicationGuide/consistency.html"
 * target="_top">Managing Consistency</a>
 */
public class ReplicaConsistencyException extends OperationFailureException {
    private static final long serialVersionUID = 1;

    final ReplicaConsistencyPolicy consistencyPolicy;

    /**
     * @hidden
     * For internal use only.
     */
    public ReplicaConsistencyException(ReplicaConsistencyPolicy
                                       consistencyPolicy,
                                       boolean unknownMaster) {
        /* No need to set abortOnly, beginTransaction will fail. */
        super(null /*locker*/, false /*abortOnly*/,
              "Unable to achieve consistency despite waiting for " +
              consistencyPolicy.getTimeout(TimeUnit.MILLISECONDS) + " ms." +
              (unknownMaster ?
               " The node is not currently in contact with a master." :
               ""),
              null /*cause*/);
        this.consistencyPolicy = consistencyPolicy;
    }

    public ReplicaConsistencyException(String message,
                                       ReplicaConsistencyPolicy
                                       consistencyPolicy) {
        /* No need to set abortOnly, beginTransaction will fail. */
        super(null /*locker*/, false /*abortOnly*/,
              message,
              null /*cause*/);
        this.consistencyPolicy = consistencyPolicy;
    }

    /**
     * For internal use only.
     * @hidden
     */
    private ReplicaConsistencyException(String message,
                                        ReplicaConsistencyException cause) {
        super(message, cause);
        this.consistencyPolicy = cause.consistencyPolicy;
    }

    /**
     * For internal use only.
     * @hidden
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new ReplicaConsistencyException(msg, this);
    }

    /**
     * Returns the Replica consistency policy that could not be satisfied.
     *
     * @return the Replica consistency policy
     */
    public ReplicaConsistencyPolicy getConsistencyPolicy() {
        return  consistencyPolicy;
    }
}
