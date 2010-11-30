/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.util;

import java.net.InetSocketAddress;
import java.util.Set;
import java.util.logging.Formatter;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.MasterStateException;
import com.sleepycat.je.rep.MemberNotFoundException;
import com.sleepycat.je.rep.NodeType;
import com.sleepycat.je.rep.ReplicationGroup;
import com.sleepycat.je.rep.ReplicationNode;
import com.sleepycat.je.rep.UnknownMasterException;
import com.sleepycat.je.rep.elections.Learner;
import com.sleepycat.je.rep.elections.MasterValue;
import com.sleepycat.je.rep.elections.Protocol;
import com.sleepycat.je.rep.elections.TimebasedProposalGenerator;
import com.sleepycat.je.rep.impl.GroupService;
import com.sleepycat.je.rep.impl.RepGroupProtocol;
import com.sleepycat.je.rep.impl.RepNodeImpl;
import com.sleepycat.je.rep.impl.RepGroupProtocol.EnsureOK;
import com.sleepycat.je.rep.impl.RepGroupProtocol.Fail;
import com.sleepycat.je.rep.impl.RepGroupProtocol.GroupResponse;
import com.sleepycat.je.rep.impl.TextProtocol.MessageExchange;
import com.sleepycat.je.rep.impl.TextProtocol.OK;
import com.sleepycat.je.rep.impl.TextProtocol.ProtocolError;
import com.sleepycat.je.rep.impl.TextProtocol.ResponseMessage;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.utilint.ReplicationFormatter;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * Administrative APIs for use by applications which do not have direct access
 * to a replicated environment. The class supplies methods that can be
 * used to list group members, remove members, and find the current master.
 * The information is found by querying nodes in the group. Because of that,
 * ReplicationGroupAdmin can only obtain information when there is at least
 * one node alive in the replication group.
 */
public class ReplicationGroupAdmin {

    private final String groupName;
    private final Set<InetSocketAddress> helperSockets;
    private final Protocol electionsProtocol;
    private final RepGroupProtocol groupProtocol;
    private final Logger logger;
    private final Formatter formatter;

    /**
     * Constructs a group admin object.
     *
     * @param groupName the name of the group to be administered
     * @param helperSockets the sockets on which it can contact helper nodes
     * in the replication group to carry out admin services.
     */
    public ReplicationGroupAdmin(String groupName,
                                 Set<InetSocketAddress> helperSockets) {
        this.groupName = groupName;
        this.helperSockets = helperSockets;

        electionsProtocol =
            new Protocol(TimebasedProposalGenerator.getParser(),
                         MasterValue.getParser(),
                         groupName,
                         NameIdPair.NOCHECK,
                         null /* repImpl */);
        groupProtocol =
            new RepGroupProtocol(groupName, NameIdPair.NOCHECK, null);
        logger = LoggerUtils.getLoggerFixedPrefix
            (getClass(), NameIdPair.NOCHECK.toString());
        formatter = new ReplicationFormatter(NameIdPair.NOCHECK);
    }

    /**
     * Returns the helper sockets being used to contact a replication group
     * member, in order to query for the information.
     *
     * @return the set of helper sockets.
     */
    public Set<InetSocketAddress> getHelperSockets() {
        return helperSockets;
    }

    /**
     * Returns the name of the replication group.
     *
     * @return the group name.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Returns the socket address associated with the node that's currently
     * the master.
     *
     * @return the socket address associated with the master
     *
     * @throws UnknownMasterException if the master was not found
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    private InetSocketAddress getMasterSocket()
        throws UnknownMasterException,
               EnvironmentFailureException {

        MasterValue masterValue = Learner.findMaster(electionsProtocol,
                                                     helperSockets,
                                                     logger,
                                                     null,
                                                     formatter);
        return new InetSocketAddress(masterValue.getHostName(),
                                     masterValue.getPort());
    }

    /**
     * Returns the node name associated with the master
     *
     * @return the master node id
     *
     * @throws UnknownMasterException if the master was not found
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public String getMasterNodeName()
        throws UnknownMasterException,
               EnvironmentFailureException {
        MasterValue masterValue = Learner.findMaster(electionsProtocol,
                                                     helperSockets,
                                                     logger,
                                                     null,
                                                     formatter);
        return masterValue.getNodeName();
    }

    /**
     * @hidden
     * Internal implementation class.
     *
     * Ensures that this monitor node is a member of the replication group,
     * adding it to the group if it isn't already.
     *
     * @param monitor the monitor node
     *
     * @return the master node that was contacted to ensure the monitor
     *
     * @throws UnknownMasterException if the master was not found
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public ReplicationNode ensureMonitor(RepNodeImpl monitor)
        throws UnknownMasterException,
               EnvironmentFailureException  {

        if (monitor.getType() != NodeType.MONITOR) {
            throw EnvironmentFailureException.unexpectedState
                ("Node type must be Monitor not: " + monitor.getType());
        }

        MasterValue masterValue = Learner.findMaster(electionsProtocol,
                                                     helperSockets,
                                                     logger,
                                                     null,
                                                     formatter);

        InetSocketAddress masterAddress =
            new InetSocketAddress(masterValue.getHostName(),
                                  masterValue.getPort());
        MessageExchange me = groupProtocol.new MessageExchange
            (masterAddress,
             GroupService.SERVICE_NAME,
             groupProtocol.new EnsureNode(monitor));
        me.run();
        ResponseMessage resp = me.getResponseMessage();
        if (resp instanceof EnsureOK) {
            EnsureOK okResp = (EnsureOK) resp;
            monitor.getNameIdPair().update(okResp.getNameIdPair());
            return new RepNodeImpl(new NameIdPair(masterValue.getNodeName()),
                                   NodeType.ELECTABLE,
                                   masterValue.getHostName(),
                                   masterValue.getPort());
        }
        throw getException(resp);
    }


    /**
     * Removes this node from the group, so that it is no longer a member of
     * the group. When removed, it will no longer be able to connect to a
     * master, nor can it participate in elections. If the node is a {@link
     * com.sleepycat.je.rep.monitor.Monitor} it will no longer be informed of
     * election results. Once removed, a node cannot be added again to the
     * group under the same node name.
     * <p>
     * Ideally, the node being removed should be shut down before this call is
     * issued.
     * <p>
     * If the node is an active <code>Replica</code> the master will terminate
     * its connection with the node and will not allow the replica to reconnect
     * with the group, since it's no longer a member of the group. If the node
     * wishes to re-join it should do so with a different node name.
     * <p>
     * An active Master cannot be removed. It must first be shutdown, or
     * transition to the <code>Replica</code> state before it can be removed
     * from the group.
     * <p>
     * @param nodeName identifies the node being removed from the group
     *
     * @throws UnknownMasterException if the master was not found
     *
     * @throws MemberNotFoundException if the node denoted by
     * <code>nodeName</code> is not a member of the replication group
     *
     * @throws MasterStateException if the member being removed is currently
     * the Master
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     * @see <a
     * href="{@docRoot}/../ReplicationGuide/utilities.html#node-addremove"
     * target="_top">Adding and Removing Nodes From the Group</a>
     */
    public void removeMember(String nodeName)
        throws UnknownMasterException,
               MemberNotFoundException,
               MasterStateException,
               EnvironmentFailureException {

        final ReplicationGroup group = getGroup();
        final RepNodeImpl node = (RepNodeImpl) group.getMember(nodeName);

        if (node == null) {
            throw new MemberNotFoundException("Node:" + nodeName +
                                              "is not a member of the group:" +
                                              groupName);
        }
        if (node.isRemoved() && node.isQuorumAck()) {
            throw new MemberNotFoundException("Node:" + nodeName +
                                              "is not currently a member of " +
                                              "the group:" + groupName +
                                              " It had been removed.");
        }
        final InetSocketAddress masterAddress= getMasterSocket();
        /* Check if the node is itself the master. */
        if (masterAddress.equals(node.getSocketAddress())) {
            throw new MasterStateException("Cannot remove an active master");
        }
        final MessageExchange me = groupProtocol.new MessageExchange
            (masterAddress,
             GroupService.SERVICE_NAME,
             groupProtocol.new RemoveMember(nodeName));
        me.run();
        ResponseMessage resp = me.getResponseMessage();
        if (resp instanceof OK) {
            return;
        }
        throw getException(resp);
    }

    /**
     * Returns the current composition of the group from the Master.
     *
     * @return the group description
     *
     * @throws UnknownMasterException if the master was not found
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs
     */
    public ReplicationGroup getGroup()
        throws UnknownMasterException,
               EnvironmentFailureException {

        InetSocketAddress masterSocket = getMasterSocket();

        MessageExchange me = groupProtocol.new MessageExchange
        (masterSocket,
         GroupService.SERVICE_NAME,
         groupProtocol.new GroupRequest());
        me.run();
        ResponseMessage resp = me.getResponseMessage();
        if (resp instanceof GroupResponse) {
            return new ReplicationGroup(((GroupResponse)resp).getGroup());
        }
        throw getException(resp);
    }

    /**
     * Examines the response and generates a meaningful error exception.
     */
    private DatabaseException getException(ResponseMessage resp) {

        if (resp == null) {
            return EnvironmentFailureException.unexpectedState
                ("No response to request");
        }
        if (resp instanceof Fail) {
            Fail fail = (Fail)resp;
            switch (fail.getReason()) {
                case MEMBER_NOT_FOUND:
                    return new MemberNotFoundException(fail.getMessage());

                case IS_MASTER:
                    return new MasterStateException(fail.getMessage());

                default:
                    EnvironmentFailureException.
                        unexpectedState(fail.getMessage());
            }
        }
        if (resp instanceof ProtocolError) {
            return EnvironmentFailureException.unexpectedState
                (((ProtocolError)resp).getMessage());
        }
        return EnvironmentFailureException.unexpectedState
            ("Response not recognized: " + resp);
    }
}
