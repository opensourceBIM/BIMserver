/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

import com.sleepycat.je.rep.impl.NodeStateProtocol.NodeStateRequest;
import com.sleepycat.je.rep.impl.TextProtocol.RequestMessage;
import com.sleepycat.je.rep.impl.TextProtocol.ResponseMessage;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.utilint.ServiceDispatcher;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ExecutingService;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ExecutingRunnable;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * The service registered by a RepNode to answer the state request from 
 * another node. It can also be extended to be used by "Ping" command.
 */
public class NodeStateService extends ExecutingService {

    private final RepNode repNode;
    private final NodeStateProtocol protocol;
    private final Logger logger;

    /* Identifies the Node State querying Service. */
    public static final String SERVICE_NAME = "NodeState";

    public NodeStateService(ServiceDispatcher dispatcher, RepNode repNode) {
        super(SERVICE_NAME, dispatcher);
        this.repNode = repNode;

        String groupName = 
            repNode.getRepImpl().cloneRepConfig().getGroupName();
        protocol = new NodeStateProtocol
            (groupName, repNode.getNameIdPair(), repNode.getRepImpl());
        logger = LoggerUtils.getLogger(getClass());
    }

    /**
     * Process a node state querying request.
     */
    @SuppressWarnings("unused")
    public ResponseMessage process(NodeStateRequest stateRequest) {
        long joinTime = repNode.getMonitorEventManager().getJoinTime();
        return protocol.new NodeStateResponse(repNode.getNodeName(), 
                                              repNode.getMasterName(), 
                                              joinTime,
                                              repNode.getRepImpl().getState());
    }

    @Override
    public Runnable getRunnable(SocketChannel socketChannel) {
        return new NodeStateServiceRunnable(socketChannel, protocol);
    }

    class NodeStateServiceRunnable extends ExecutingRunnable {
        NodeStateServiceRunnable(SocketChannel socketChannel,
                                 NodeStateProtocol protocol) {
            super(socketChannel, protocol, true);
        }

        @Override
        protected ResponseMessage getResponse(RequestMessage request)
            throws IOException {

            return protocol.process(NodeStateService.this, request);
        }

        @Override
        protected void logMessage(String message) {
            LoggerUtils.warning(logger, repNode.getRepImpl(), message);
        }
    }
}
