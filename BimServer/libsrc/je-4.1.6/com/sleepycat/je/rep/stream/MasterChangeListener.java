/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.stream;

import java.net.InetSocketAddress;
import java.util.logging.Logger;

import com.sleepycat.je.rep.elections.Learner;
import com.sleepycat.je.rep.elections.MasterValue;
import com.sleepycat.je.rep.elections.Proposer.Proposal;
import com.sleepycat.je.rep.elections.Protocol.Value;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * The Listener registered with Elections to learn about new Masters
 */
public class MasterChangeListener implements Learner.Listener {

    /* The Value that is "current" for this Node. */
    private Value currentValue = null;

    private final RepNode repNode;
    private final Logger logger;

    public MasterChangeListener(RepNode repNode) {
        this.repNode = repNode;
        logger = LoggerUtils.getLogger(getClass());
    }

    /**
     * Implements the Listener protocol. The method should not have any
     * operations that might wait, since notifications are single threaded.
     */
    public void notify(Proposal proposal, Value value) {

        try {
            repNode.getVLSNFreezeLatch().vlsnEvent(proposal);
            /* We have a new proposal, is it truly different? */
            if (value.equals(currentValue)) {
                LoggerUtils.fine(logger, repNode.getRepImpl(), 
                                 "Master change listener -- no value change." +
                                 "Proposal: " + proposal + " Value: " + value);
                return;
            }
            
            MasterValue masterValue = ((MasterValue) value);
            
            LoggerUtils.fine(logger, repNode.getRepImpl(), 
                    "Master change listener notified. Proposal:" + 
                    proposal + " Value: " + value);
            LoggerUtils.info(logger, repNode.getRepImpl(), 
                    "Master changed to " + 
                     masterValue.getNameId().getName());
            
            repNode.getMasterStatus().setGroupMaster
                (new InetSocketAddress(masterValue.getHostName(),
                                       masterValue.getPort()),
                 masterValue.getNameId());
            
            /* Propagate the information to any monitors. */
            repNode.getElections().asyncInformMonitors(proposal, value);
        } finally {
            currentValue = value;
        }
    }
}
