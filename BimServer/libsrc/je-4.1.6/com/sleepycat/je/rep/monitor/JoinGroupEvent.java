/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.monitor;

import java.util.Date;

/**
 * The event generated when a node joins the group. A new instance of this 
 * event is generated each time a node joins the group.
 *
 * The event is generated on a "best effort" basis. It may not be generated,
 * for example, if the joining node was unable to communicate with the monitor
 * due to a network problem. The application must be resilient in the face of
 * such missing events.
 */
public class JoinGroupEvent extends MemberChangeEvent {

    /**
     * The time when this node joins the group. 
     */
    private final long joinTime;

    JoinGroupEvent(String nodeName, String masterName, long joinTime) {
        super(nodeName, masterName);
        this.joinTime = joinTime;
    }

    /**
     * Returns the time at which the node joined the group.
     */
    public Date getJoinTime() {
        return new Date(joinTime);
    }
}
