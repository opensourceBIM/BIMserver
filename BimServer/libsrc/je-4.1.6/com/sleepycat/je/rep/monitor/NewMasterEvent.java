/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.monitor;

import java.net.InetSocketAddress;

import com.sleepycat.je.rep.elections.MasterValue;

/**
 * The event generated upon detecting a new Master. A new instance of this
 * event is generated each time a new master is elected for the group.
 */
public class NewMasterEvent extends MemberChangeEvent {
    /* The node id identifying the master node. */
    private final MasterValue masterValue;

    NewMasterEvent(MasterValue masterValue) {
        super(masterValue.getNodeName(), masterValue.getNodeName());
        this.masterValue = masterValue;
    }

    /**
     * Returns the socket address associated with the new master
     */
    public InetSocketAddress getSocketAddress() {
        return new InetSocketAddress(masterValue.getHostName(),
                                     masterValue.getPort());
    }
}
