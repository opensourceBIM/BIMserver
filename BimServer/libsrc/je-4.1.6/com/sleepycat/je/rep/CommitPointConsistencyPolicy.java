/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.util.concurrent.TimeUnit;

import com.sleepycat.je.CommitToken;
import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.node.Replica;
import com.sleepycat.je.utilint.PropUtil;

/**
 * A consistency policy which ensures that the environment on a Replica node is
 * at least as current as denoted by the specified {@link CommitToken}. This
 * token represents a point in the serialized transaction schedule created by
 * the master. In other words, this token is like a bookmark, representing a
 * particular transaction commit in the replication stream. The Replica ensures
 * that the commit identified by the {@link CommitToken} has been executed on
 * this node before allowing the application's {@link
 * com.sleepycat.je.Environment#beginTransaction(com.sleepycat.je.Transaction,
 * com.sleepycat.je.TransactionConfig) Environment.beginTransaction()}
 * operation on the Replica to proceed.
 * <p>
 * For example, suppose the application is a web application where a replicated
 * group is implemented within a load balanced web server group. Each request
 * to the web server consists of an update operation followed by read
 * operations (say from the same client), The read operations naturally expect
 * to see the data from the updates executed by the same request. However, the
 * read operations might have been routed to a node that did not execute the
 * update.
 * <p>
 * In such a case, the update request would generate a {@link CommitToken},
 * which would be resubmitted by the browser, along with subsequent read
 * requests. The read request could be directed at any one of the available web
 * servers by a load balancer. The node which executes the read request would
 * create a CommitPointConsistencyPolicy with that {@link CommitToken} and use
 * it at transaction begin. If the environment at the web server was already
 * current (wrt the commit token), it could immediately execute the transaction
 * and satisfy the request. If not, the "transaction begin" would stall until
 * the Replica replay had caught up and the change was available at that web
 * server.
 * <p>
 * Consistency policies are specified at either a per-transaction level through
 * {@link com.sleepycat.je.TransactionConfig#setConsistencyPolicy} or as an
 * replication node wide default through {@link
 * com.sleepycat.je.rep.ReplicationConfig#setConsistencyPolicy}
 *
 * @see com.sleepycat.je.CommitToken
 * @see <a href="{@docRoot}/../ReplicationGuide/consistency.html"
 * target="_top">Managing Consistency</a>
 */
public class CommitPointConsistencyPolicy implements ReplicaConsistencyPolicy {

    /**
     * The name:{@value} associated with this policy. The name can be used when
     * constructing policy property values for use in je.properties files.
     */
    public static final String NAME = "CommitPointConsistencyPolicy";

    /*
     * Identifies the commit of interest in a serialized transaction schedule.
     */
    private final CommitToken commitToken;

    /*
     * Amount of time (in milliseconds) to wait for consistency to be
     * reached.
     */
    private final int timeout;

    /**
     * Defines how current a Replica needs to be in terms of a specific
     * transaction that was committed on the Master. A transaction on the
     * Replica that uses this consistency policy is allowed to start only
     * after the transaction identified by the <code>commitToken</code> has
     * been committed on the Replica. The {@link
     * com.sleepycat.je.Environment#beginTransaction(
     * com.sleepycat.je.Transaction, com.sleepycat.je.TransactionConfig)
     * Environment.beginTransaction()} will wait for at most
     * <code>timeout</code> for the Replica to catch up. If the Replica has
     * not caught up in this period, the <code>beginTransaction()</code>
     * method will throw a {@link ReplicaConsistencyException}.
     *
     * @param commitToken the token identifying the transaction
     *
     * @param timeout the maximum amount of time that the transaction start
     * will wait to allow the Replica to catch up.
     *
     * @param timeoutUnit the {@code TimeUnit} for the timeout parameter.
     *
     * @throws IllegalArgumentException if the commitToken or timeoutUnit is
     * null.
     */
    public CommitPointConsistencyPolicy(CommitToken commitToken,
                                        long timeout,
                                        TimeUnit timeoutUnit) {
        if (commitToken == null) {
            throw new IllegalArgumentException("commitToken must not be null");
        }
        this.commitToken = commitToken;
        this.timeout = PropUtil.durationToMillis(timeout, timeoutUnit);
    }

    /**
     * Returns the name:{@value #NAME}, associated with this policy.
     * @see #NAME
     */
    public String getName() {
        return NAME;
    }

    /**
     * @hidden
     * For internal use only.
     * Ensures that the replica has replayed the replication stream to the
     * point identified by the commit token or past it. If it has not, the
     * method waits until the constraint is satisfied, or the timeout period
     * has expired, whichever event takes place first.
     */
    public void ensureConsistency(EnvironmentImpl envImpl)
        throws InterruptedException,
               ReplicaConsistencyException {

        /*
         * Cast is done to preserve replication/non replication code
         * boundaries.
         */
        RepImpl repImpl = (RepImpl) envImpl;
        if (!commitToken.getRepenvUUID().equals
                (repImpl.getRepNode().getUUID())) {
            throw new IllegalArgumentException
                ("Replication environment mismatch. " +
                 "The UUID associated with the commit token is: " +
                 commitToken.getRepenvUUID() +
                 " but this replica environment has the UUID: " +
                 repImpl.getRepNode().getUUID());
        }
        Replica replica = repImpl.getRepNode().replica();
        replica.getConsistencyTracker().commitVLSNAwait
            (commitToken.getVLSN(), this);
    }

    /**
     * Return the <code>CommitToken</code> used to create this consistency
     * policy.
     * @return the <code>CommitToken</code> used to create this consistency
     * policy.
     */
    public CommitToken getCommitToken() {
        return commitToken;
    }

    /**
     * Return the timeout specified when creating this consistency policy.
     *
     * @param unit the {@code TimeUnit} of the returned value.
     *
     * @return the timeout specified when creating this consistency policy
     */
    public long getTimeout(TimeUnit unit) {
        return PropUtil.millisToDuration(timeout, unit);
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((commitToken == null) ? 0 : commitToken.hashCode());
        result = prime * result + timeout;
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CommitPointConsistencyPolicy)) {
            return false;
        }
        CommitPointConsistencyPolicy other =
            (CommitPointConsistencyPolicy) obj;
        if (commitToken == null) {
            if (other.commitToken != null) {
                return false;
            }
        } else if (!commitToken.equals(other.commitToken)) {
            return false;
        }
        if (timeout != other.timeout) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getName() + " commitToken=" + commitToken;
    }
}
