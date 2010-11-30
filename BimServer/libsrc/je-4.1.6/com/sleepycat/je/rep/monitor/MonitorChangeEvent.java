/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.monitor;

/**
 * MonitorChangeEvent is the base class for all Monitor events. Its subclasses
 * provide additional event-specific information.
 * <p>
 * See {@link <a href="{@docRoot}/../ReplicationGuide/monitors.html"
 * target="_blank">Replication Guide, Writing Monitor Nodes</a>}
 */
public abstract class MonitorChangeEvent {

    /**
     * The name of the node associated with the event
     */
    private final String nodeName;

    MonitorChangeEvent(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * Returns the name of the node associated with the event.
     */
    public String getNodeName() {
        return nodeName;
    }
}
