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

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.rep.MasterStateException;
import com.sleepycat.je.rep.MemberNotFoundException;
import com.sleepycat.je.rep.impl.RepGroupProtocol.EnsureNode;
import com.sleepycat.je.rep.impl.RepGroupProtocol.FailReason;
import com.sleepycat.je.rep.impl.RepGroupProtocol.GroupRequest;
import com.sleepycat.je.rep.impl.RepGroupProtocol.RemoveMember;
import com.sleepycat.je.rep.impl.TextProtocol.RequestMessage;
import com.sleepycat.je.rep.impl.TextProtocol.ResponseMessage;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.utilint.ServiceDispatcher;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ExecutingService;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ExecutingRunnable;
import com.sleepycat.je.utilint.LoggerUtils;

public class GroupService extends ExecutingService {

    /* The replication node */
    final RepNode repNode;
    final RepGroupProtocol protocol;

    private final Logger logger;

    /* Identifies the Group Service. */
    public static final String SERVICE_NAME = "Group";

    public GroupService(ServiceDispatcher dispatcher, RepNode repNode) {
        super(SERVICE_NAME, dispatcher);
        this.repNode = repNode;

        protocol = new RepGroupProtocol(repNode.getGroup().getName(),
                                        repNode.getNameIdPair(),
                                        repNode.getRepImpl());
        logger = LoggerUtils.getLogger(getClass());
    }

    /* Dynamically invoked process methods */

    /**
     * Wraps the replication group as currently cached on this node in
     * a Response message and returns it.
     */
    @SuppressWarnings("unused")
    public ResponseMessage process(GroupRequest groupRequest) {
        return protocol.new GroupResponse(repNode.getGroup());
    }

    /**
     * Ensures that the Monitor node, as described in the request, is a member
     * of the group.
     *
     * @param ensureNode the request message describing the monitor node
     *
     * @return EnsureOK message if the monitor node is already part of the rep
     * group, or was just made a part of the replication group. It returns a
     * Fail message if it could not be made part of the group. The message
     * associated with the response provides further details.
     */
    public ResponseMessage process(EnsureNode ensureNode) {
        RepNodeImpl node = ensureNode.getNode();
        try {
            repNode.getRepGroupDB().ensureMember(node);
            RepNodeImpl enode =
                repNode.getGroup().getMember(node.getName());
            return protocol.new EnsureOK(enode.getNameIdPair());
        } catch (DatabaseException e) {
            return protocol.new Fail(FailReason.DEFAULT, e.getMessage());
        }
    }

    /**
     * Removes a current member from the group.
     *
     * @param removeMember the request identifying the member to be removed.
     *
     * @return OK message if the member was removed from the group.
     */
    public ResponseMessage process(RemoveMember removeMember) {
        final String nodeName = removeMember.getNodeName();
        try {
            repNode.removeMember(nodeName);
            return protocol.new OK();
        } catch (MemberNotFoundException e) {
            return protocol.new Fail(FailReason.MEMBER_NOT_FOUND,
                                     e.getMessage());
        } catch (MasterStateException e) {
            return protocol.new Fail(FailReason.IS_MASTER, e.getMessage());
        }  catch (DatabaseException e) {
            return protocol.new Fail(FailReason.DEFAULT, e.getMessage());
        }
    }

    @Override
    public Runnable getRunnable(SocketChannel socketChannel) {
        return new GroupServiceRunnable(socketChannel, protocol);
    }

    class GroupServiceRunnable extends ExecutingRunnable {
        GroupServiceRunnable(SocketChannel socketChannel, 
                             RepGroupProtocol protocol) {
            super(socketChannel, protocol, true);
        }

        @Override
        protected ResponseMessage getResponse(RequestMessage request)  
            throws IOException {

            return protocol.process(GroupService.this, request);
        }

        @Override
        protected void logMessage(String message) {
            LoggerUtils.warning(logger, repNode.getRepImpl(), message);
        }
    }
}
