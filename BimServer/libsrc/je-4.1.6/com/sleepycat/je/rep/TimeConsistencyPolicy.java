/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.util.concurrent.TimeUnit;

import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.node.Replica;
import com.sleepycat.je.utilint.PropUtil;

/**
 * A consistency policy which describes the amount of time the Replica is
 * allowed to lag the Master. The application can use this policy to ensure
 * that this node sees all transactions that were committed on the Master
 * before the lag interval.
 * <p>
 * Effective use of this policy requires that the clocks on the Master and
 * Replica are synchronized by using a protocol like NTP
 * <p>
 * Consistency policies are specified at either a per-transaction level through
 * {@link com.sleepycat.je.TransactionConfig#setConsistencyPolicy} or as an replication node
 * wide default through {@link
 * com.sleepycat.je.rep.ReplicationConfig#setConsistencyPolicy}
 *
 * @see <a href="{@docRoot}/../ReplicationGuide/consistency.html"
 * target="_top">Managing Consistency</a>
 */
public class TimeConsistencyPolicy implements ReplicaConsistencyPolicy {

    /**
     * The name:{@value} associated with this policy. The name can be used when
     * constructing policy property values for use in je.properties files.
     */
    public static final String NAME = "TimeConsistencyPolicy";

    private final int permissibleLag;

    /* Amount of time to wait (in ms) for the consistency to be reached. */
    private final int timeout;

    /**
     * Specifies the amount of time by which the Replica is allowed to lag the
     * master when initiating a transaction. The Replica ensures that all
     * transactions that were committed on the Master before this lag interval
     * are available at the Replica before allowing a transaction to proceed
     * with Environment.beginTransaction.
     *
     * Effective use of this policy requires that the clocks on the Master and
     * Replica are synchronized by using a protocol like NTP.
     *
     * @param permissibleLag the time interval by which the Replica may be out
     * of date with respect to the Master when a transaction is initiated on
     * the Replica.
     *
     * @param permissibleLagUnit the {@code TimeUnit} for the permissibleLag
     * parameter.
     *
     * @param timeout the amount of time to wait for the consistency to be
     * reached.
     *
     * @param timeoutUnit the {@code TimeUnit} for the timeout parameter.
     *
     * @throws IllegalArgumentException if the permissibleLagUnit or
     * timeoutUnit is null.
     */
    public TimeConsistencyPolicy(long permissibleLag,
                                 TimeUnit permissibleLagUnit,
                                 long timeout,
                                 TimeUnit timeoutUnit) {
        this.permissibleLag = PropUtil.durationToMillis(permissibleLag,
                                                        permissibleLagUnit);
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
     * Returns the allowed time lag associated with this policy.
     *
     * @param unit the {@code TimeUnit} of the returned value.
     *
     * @return the permissible lag time in the specified unit.
     */
    public long getPermissibleLag(TimeUnit unit) {
        return PropUtil.millisToDuration(permissibleLag, unit);
    }

    /**
     * Returns the consistency timeout associated with this policy.
     *
     * @param unit the {@code TimeUnit} of the returned value.
     *
     * @return the consistency timeout in the specified unit.
     */
    public long getTimeout(TimeUnit unit) {
        return PropUtil.millisToDuration(timeout, unit);
    }

    /**
     * @hidden
     * For internal use only.
     * Ensures that the replica has replayed the replication stream to the
     * point identified by the lag period. If it isn't the method waits until
     * the constraint is satisfied by the replica.
     */
    public void ensureConsistency(EnvironmentImpl replicatorImpl)
        throws InterruptedException,
               ReplicaConsistencyException{

        /*
         * Cast is done to preserve replication/non replication code
         * boundaries.
         */
        RepImpl repImpl = (RepImpl) replicatorImpl;
        Replica replica = repImpl.getRepNode().replica();
        replica.getConsistencyTracker().lagAwait(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + permissibleLag;
        result = prime * result + timeout;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        TimeConsistencyPolicy other =
            (TimeConsistencyPolicy) obj;
        if (permissibleLag != other.permissibleLag) {
            return false;
        }
        if (timeout != other.timeout) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return getName() + " permissibleLag=" + permissibleLag;
    }
}
