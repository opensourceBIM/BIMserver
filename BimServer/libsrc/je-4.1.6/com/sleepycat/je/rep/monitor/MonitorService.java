/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.monitor;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.rep.ReplicationGroup;
import com.sleepycat.je.rep.impl.TextProtocol.RequestMessage;
import com.sleepycat.je.rep.impl.TextProtocol.ResponseMessage;
import com.sleepycat.je.rep.monitor.Protocol.GroupChange;
import com.sleepycat.je.rep.monitor.Protocol.JoinGroup;
import com.sleepycat.je.rep.monitor.Protocol.LeaveGroup;
import com.sleepycat.je.rep.utilint.ReplicationFormatter;
import com.sleepycat.je.rep.utilint.ServiceDispatcher;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ExecutingService;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ExecutingRunnable;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * @hidden
 * For internal use only.
 */
public class MonitorService extends ExecutingService {
    private final Monitor monitor;
    private final Protocol protocol;
    private final Logger logger;
    private final Formatter formatter;

    /* Identifies the Group Service. */
    public static final String SERVICE_NAME = "Monitor";

    public MonitorService(Monitor monitor,
                          ServiceDispatcher dispatcher) {
        super(SERVICE_NAME, dispatcher);
        this.monitor = monitor;
        protocol = new Protocol(monitor.getGroupName(),
                                monitor.getMonitorNameIdPair(),
                                null);
        logger = LoggerUtils.getLoggerFormatterNeeded(getClass());
        formatter = new ReplicationFormatter(monitor.getMonitorNameIdPair());
    }

    /* Dynamically invoked process methods */

    /**
     * Notify the monitor about the group change (add/remove a node) event.
     */
    public ResponseMessage process(GroupChange groupChange) {
        GroupChangeEvent event = 
            new GroupChangeEvent(new ReplicationGroup(groupChange.getGroup()),
                                 groupChange.getNodeName(), 
                                 groupChange.getOpType());
        monitor.notify(event);
        return null;
    }

    /**
     * Notify the monitor about a node has joined the group.
     */
    public ResponseMessage process(JoinGroup joinGroup) {
        monitor.notify(new JoinGroupEvent(joinGroup.getNodeName(),
                                          joinGroup.getMasterName(),
                                          joinGroup.getJoinTime())); 
        return null;
    }

    /**
     * Notify the monitor about a node has left the group. 
     */
    public ResponseMessage process(LeaveGroup leaveGroup) {
        monitor.notify(new LeaveGroupEvent(leaveGroup.getNodeName(), 
                                           leaveGroup.getMasterName(),
                                           leaveGroup.getLeaveReason(),
                                           leaveGroup.getJoinTime(),
                                           leaveGroup.getLeaveTime()));
        return null;
    }

    @Override
    public Runnable getRunnable(SocketChannel socketChannel) {
        return new MonitorServiceRunnable(socketChannel, protocol);
    }

    class MonitorServiceRunnable extends ExecutingRunnable {
        MonitorServiceRunnable(SocketChannel socketChannel, 
                               Protocol protocol) { 
            super(socketChannel, protocol, false);
        }

        @Override
        protected ResponseMessage getResponse(RequestMessage request)
            throws IOException {
                
            return protocol.process(MonitorService.this, request);
        }

        @Override
        protected void logMessage(String message) {
            LoggerUtils.logMsg(logger, formatter, Level.WARNING, message);
        }
    }
}
