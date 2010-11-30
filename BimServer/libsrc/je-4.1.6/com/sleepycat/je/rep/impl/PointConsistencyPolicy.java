/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl;

import java.util.concurrent.TimeUnit;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.rep.ReplicaConsistencyException;
import com.sleepycat.je.rep.impl.node.Replica;
import com.sleepycat.je.utilint.PropUtil;
import com.sleepycat.je.utilint.VLSN;

/**
 * This is used to ensure that the Replica has finished replaying or proceeded
 * past the vlsn specified by the policy. It's like the externally visible
 * CommitPointConsistencyPolicy, except that the latter restricts consistency
 * points to commit vlsns, whereas this policy lets you sync at uncommitted log
 * entries.
 *
 * This class is not public intentionally; it should only be used by unittests
 * and not be replication source code, because it lives in the test packages.
 */
public class PointConsistencyPolicy
    implements ReplicaConsistencyPolicy {

    /**
     * The name:{@value} associated with this policy. The name can be used when
     * constructing policy property values for use in je.properties files.
     */
    public static final String NAME = "PointConsistencyPolicy";

    private final VLSN targetVLSN;

    /*
     * Amount of time (in milliseconds) to wait for consistency to be
     * reached.
     */
    private final int timeout;

    public PointConsistencyPolicy(VLSN targetVLSN) {
        this(targetVLSN, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    public PointConsistencyPolicy(VLSN targetVLSN,
                                  long timeout,
                                  TimeUnit timeoutUnit) {
        this.targetVLSN = targetVLSN;
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
     * Ensures that the replica has replayed the replication stream to the
     * point identified by the commit token. If it isn't the method waits until
     * the constraint is satisfied by the replica.
     */
    public void ensureConsistency(EnvironmentImpl replicatorImpl)
        throws InterruptedException,
               ReplicaConsistencyException,
               DatabaseException {

        /*
         * Cast is done to preserve replication/non replication code
         * boundaries.
         */
        RepImpl repImpl = (RepImpl) replicatorImpl;
        Replica replica = repImpl.getRepNode().replica();
        replica.getConsistencyTracker().anyVLSNAwait(targetVLSN.getSequence(),
                                                     this);
    }

    public long getTimeout(TimeUnit unit) {
        return PropUtil.millisToDuration(timeout, unit);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((targetVLSN == null) ? 0 : targetVLSN.hashCode());
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
        PointConsistencyPolicy other = (PointConsistencyPolicy) obj;
        if (targetVLSN == null) {
            if (other.targetVLSN != null) {
                return false;
            }
        } else if (!targetVLSN.equals(other.targetVLSN)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getName() + " targetVLSN=" + targetVLSN;
    }
}
