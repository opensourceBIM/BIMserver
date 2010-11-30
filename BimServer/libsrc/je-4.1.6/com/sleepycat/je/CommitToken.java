/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.io.Serializable;
import java.util.UUID;

import com.sleepycat.je.utilint.VLSN;

/**
 * Defines an opaque token that can be used to identify a specific transaction
 * commit in a replicated environment. It's unique relative to its environment.
 * <p>
 * Since CommitTokens identify a point in the serialized transaction schedule
 * created on the master, it's meaningful to compare commit tokens,
 * as described in the {@link #compareTo(CommitToken)} method below.
 * CommitTokens are obtained from {@link Transaction#getCommitToken()}
 *
 * @see com.sleepycat.je.rep.CommitPointConsistencyPolicy
 */
public class CommitToken implements Serializable, Comparable<CommitToken> {

    private static final long serialVersionUID = 1L;
    private final UUID repenvUUID;
    private final long vlsn;

    /**
     * @hidden
     * For internal use only.
     * Creates a CommitToken suitable for use in a consistency policy.
     *
     * @param repenvUUID identifies the replicated environment associated with
     * the <code>vlsn</code>
     * @param vlsn the vlsn representing the state of the database.
     */
    public CommitToken(UUID repenvUUID, long vlsn) {
        if (repenvUUID == null) {
            throw EnvironmentFailureException.unexpectedState
                ("The UUID must not be null");
        }

        if (vlsn == VLSN.NULL_VLSN.getSequence()) {
            throw EnvironmentFailureException.unexpectedState
                ("The vlsn must not be null");
        }

        this.repenvUUID = repenvUUID;
        this.vlsn = vlsn;
    }

    public UUID getRepenvUUID() {
        return repenvUUID;
    }

    public long getVLSN() {
        return vlsn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((repenvUUID == null) ? 0 : repenvUUID.hashCode());
        result = prime * result + (int) (vlsn ^ (vlsn >>> 32));
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
        if (!(obj instanceof CommitToken)) {
            return false;
        }
        CommitToken other = (CommitToken) obj;
        if (repenvUUID == null) {
            if (other.repenvUUID != null) {
                return false;
            }
        } else if (!repenvUUID.equals(other.repenvUUID)) {
            return false;
        }
        if (vlsn != other.vlsn) {
            return false;
        }
        return true;
    }

    /**
     * Implements the Comparable interface. Note that it's not meaningful to
     * compare commit tokens across environments, since they represent
     * states in unrelated serialized transaction streams.
     * <p>
     * CommitToken(1) < CommitToken(2) implies that CommitToken(1) represents
     * a state of the database that preceded the state defined by
     * CommitToken(2).
     * @throws IllegalArgumentException if two tokens from different
     * environments are compared.
     */
    public int compareTo(CommitToken other) {
        if (! repenvUUID.equals(other.repenvUUID)) {
            throw new IllegalArgumentException
            ("Comparisons across environments are not meaningful. " +
             "This environment: " + repenvUUID +
             " other environment: " + other.getRepenvUUID());
        }
        final long compare = vlsn - other.vlsn;
        return (compare < 0) ? -1 : ((compare == 0) ? 0 : 1);
    }

    @Override
    public String toString() {
        return "UUID: " + repenvUUID + " VLSN: " + vlsn;
    }
}
