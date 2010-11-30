/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2008 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.util.Set;

import com.sleepycat.je.rep.impl.RepGroupImpl;

/**
 * An administrative view of the collection of nodes that form the replication
 * group. Can be obtained from a {@link ReplicatedEnvironment} or a {@link 
 * com.sleepycat.je.rep.util.ReplicationGroupAdmin}
 */
public class ReplicationGroup {

    /* All methods delegate to the group implementation. */
    final RepGroupImpl repGroupImpl;

    /**
     * @hidden
     * For internal use only
     * Used to wrap the actual group object implementation.
     */
    public ReplicationGroup(RepGroupImpl repGroupImpl) {
        this.repGroupImpl = repGroupImpl;
    }

    /**
     * Returns the name associated with the group.
     *
     * @return the name of the replication group.
     */
    public String getName() {
        return repGroupImpl.getName();
    }

    /**
     * Returns administrative information for all the nodes in the group. This
     * includes both MONITOR and ELECTABLE nodes.
     * @see NodeType
     * @return the set of nodes comprising the group.
     */
    @SuppressWarnings("unchecked")
    public Set<ReplicationNode> getNodes() {
        return (Set<ReplicationNode>)(Set<?>)repGroupImpl.getAllMembers(null);
    }

    /**
     * Returns the subset of ELECTABLE nodes with replicated environments that
     * can be elected and become masters. This specifically excludes MONITOR
     * nodes.
     * @see NodeType
     * @return the set of electable nodes.
     */
    @SuppressWarnings("unchecked")
    public Set<ReplicationNode> getElectableNodes() {
        return (Set<ReplicationNode>)(Set<?>)repGroupImpl.getElectableNodes();
    }

    /**
     * Returns the subset of monitor nodes.
     * @see NodeType
     * @return the set of monitor nodes.
     */
    @SuppressWarnings("unchecked")
    public Set<ReplicationNode> getMonitorNodes() {
        return (Set<ReplicationNode>)(Set<?>)repGroupImpl.getMonitorNodes();
    }

    /**
     * Get administrative information about a node by its node name.
     *
     * @param nodeName the node name to be used in the lookup.
     *
     * @return an administrative view of the node associated with nodeName, or
     * null if there isn't such a node currently in the group.
     */
    public ReplicationNode getMember(String nodeName) {
        return repGroupImpl.getMember(nodeName);
    }

    /**
     * @hidden
     * Internal use only.
     *   
     * Returns the underlying group implementation object.
     */
    public RepGroupImpl getRepGroupImpl() {
        return repGroupImpl;
    }

    /**
     * Returns a formatted version of the information held in a
     * ReplicationGroup.  
     */
    @Override
    public String toString() {
        return repGroupImpl.toString();
    }
}
