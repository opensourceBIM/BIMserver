/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.monitor;

/**
 * MemberChangeEvent is the base class for all member status changed events. 
 * Its subclasses provide additional event-specific information.
 */
public abstract class MemberChangeEvent extends MonitorChangeEvent {

    /**
     * The master name when this event happens.
     */
    private final String masterName;

    MemberChangeEvent(String nodeName, String masterName) {
        super(nodeName);
        this.masterName = masterName;
    }

    /**
     * Returns the name of the master at the time of this event. The return
     * value may be null if there is no current master.
     */
    public String getMasterName() {
        return masterName;
    }
}
