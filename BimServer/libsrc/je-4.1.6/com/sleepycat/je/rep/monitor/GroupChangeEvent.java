/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

/**
 * The event used to track changes to the composition and status of the
 * group. An instance of this event is created each time there is any change to
 * the group.
 */
package com.sleepycat.je.rep.monitor;

import com.sleepycat.je.rep.ReplicationGroup;

/**
 * The event generated when the group composition changes. A new instance of
 * this event is generated each time a node is added or removed from the group.
 */
public class GroupChangeEvent extends MonitorChangeEvent {

    /**
     * The kind of GroupChangeEvent.
     */
    public static enum GroupChangeType {
        
        /**
         * A new node was <code>added</code> to the replication group.
         */
        ADD,

        /**
         * A node was <code>removed</code> from the replication group.
         */
        REMOVE
    };

    /** 
     * The latest information about the replication group.
     */
    private final ReplicationGroup repGroup;

    /**
     * The type of this change.
     */
    private final GroupChangeType opType;

    GroupChangeEvent(ReplicationGroup repGroup, 
                     String nodeName, 
                     GroupChangeType opType) {
        super(nodeName);
        this.repGroup = repGroup;
        this.opType = opType;
    }

    /**
     * Returns the current description of the replication group.
     */
    public ReplicationGroup getRepGroup() {
        return repGroup;
    }

    /**
     * Returns the type of the change (the addition of a new member or the
     * removal of an existing member) made to the group. The method
     * {@link MonitorChangeEvent#getNodeName() MonitorChangeEvent.getNodeName}
     * can be used to identify the node that triggered the event.
     *
     * @return the group change type.
     */
    public GroupChangeType getChangeType() {
        return opType;
    }
}
