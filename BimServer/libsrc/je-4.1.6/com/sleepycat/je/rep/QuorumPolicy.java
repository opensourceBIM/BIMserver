/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import com.sleepycat.je.EnvironmentFailureException;

/**
 * The quorum policy determine the number of nodes that must participate to 
 * pick the winner of an election, and therefore the master of the group. 
 * The default quorum policy during the lifetime of the group is
 * QuorumPolicy.SIMPLE_MAJORITY. The only time that the application needs to
 * specify a specific quorum policy is at node startup time, by passing one
 * to the {@link ReplicatedEnvironment} constructor.
 */
public enum QuorumPolicy {

    /**
     * All participants are required to vote.
     */
    ALL,

     /**
      *  A simple majority of participants is required to vote.
      */
    SIMPLE_MAJORITY;

    /**
     * Returns the minimum number of nodes to needed meet the quorum policy.
     *
     * @param groupSize the size of the replication group.
     *
     * @return the number of nodes that are needed for a quorum for a group 
     * with groupSize number of nodes.
     */
    public int quorumSize(int groupSize) {
        switch (this) {
            case ALL:
                return groupSize;

            case SIMPLE_MAJORITY:
                return (groupSize / 2 + 1);

            default:
                throw EnvironmentFailureException.unexpectedState
                    ("Unknown quorum:" + this);
        }
    }
}
