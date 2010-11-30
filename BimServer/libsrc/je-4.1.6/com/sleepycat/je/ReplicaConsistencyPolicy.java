/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.concurrent.TimeUnit;

import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * The interface for Consistency policies used to provide consistency
 * guarantees at a Replica. ReplicaConsistencyPolicies are only used by
 * Berkeley DB JE High Availability.
 * <p>
 * A transaction initiated at a Replica will wait in
 * the {@link com.sleepycat.je.Environment#beginTransaction} method until the
 * consistency policy is satisfied.
 * Consistency policies are specified at either a per-transaction level through
 * {@link TransactionConfig#setConsistencyPolicy} or as an replication node
 * wide default through {@link
 * com.sleepycat.je.rep.ReplicationConfig#setConsistencyPolicy}
 *
 * @see <a href="{@docRoot}/../ReplicationGuide/consistency.html"
 * target="_top">Managing Consistency</a>
 */
public interface ReplicaConsistencyPolicy {

    /**
     * @hidden
     * For internal use only.
     *
     * Ensures that the replica is within the constraints specified by this
     * policy. If it isn't the method waits until the constraint is satisfied
     * by the replica.
     *
     * @param repInstance identifies the replicated environment that must meet
     * this consistency requirement.
     */
    public void ensureConsistency(EnvironmentImpl repInstance)
        throws InterruptedException;

    /**
     * Returns the name used to identify the policy. The name is used when
     * constructing policy property values for use in je.properties files.
     */
    public String getName();

    /**
     * The timeout associated with the consistency policy. If consistency
     * cannot be established by the Replica within the timeout period, a {@link
     * com.sleepycat.je.rep.ReplicaConsistencyException} is thrown by {@link
     * com.sleepycat.je.Environment#beginTransaction}.
     *
     * @return the timeout associated with the policy
     */
    public long getTimeout(TimeUnit unit);
}
