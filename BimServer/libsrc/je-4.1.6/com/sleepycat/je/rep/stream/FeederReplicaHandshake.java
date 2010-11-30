/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.stream;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.JEVersion;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.rep.InsufficientAcksException;
import com.sleepycat.je.rep.InsufficientReplicasException;
import com.sleepycat.je.rep.NodeType;
import com.sleepycat.je.rep.impl.RepGroupImpl;
import com.sleepycat.je.rep.impl.RepNodeImpl;
import com.sleepycat.je.rep.impl.RepGroupImpl.NodeConflictException;
import com.sleepycat.je.rep.impl.node.Feeder;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.impl.node.Feeder.ExitException;
import com.sleepycat.je.rep.stream.Protocol.JEVersions;
import com.sleepycat.je.rep.stream.Protocol.JEVersionsReject;
import com.sleepycat.je.rep.stream.Protocol.NodeGroupInfo;
import com.sleepycat.je.rep.stream.Protocol.ReplicaJEVersions;
import com.sleepycat.je.rep.stream.Protocol.ReplicaProtocolVersion;
import com.sleepycat.je.rep.stream.Protocol.SNTPRequest;
import com.sleepycat.je.rep.utilint.NamedChannel;
import com.sleepycat.je.rep.utilint.BinaryProtocol.ProtocolException;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * Implements the Feeder side of the handshake between the Feeder and the
 * Replica. The ReplicaFeederHandshake class takes care of the other side.
 *
 * @see <a href="https://sleepycat.oracle.com/pmwiki/pmwiki.php?n=JEHomePage.ReplicaFeederHandshake">FeederReplicaHandshake</a>
 */
public class FeederReplicaHandshake {
    /* The rep node (server or replica) */
    private final RepNode repNode;
    private final NamedChannel namedChannel;

    private final NameIdPair feederNameIdPair;

    /* Established during the first message. */
    private NameIdPair replicaNameIdPair = null;

    private ReplicaJEVersions replicaJEVersions;

    private final Logger logger;

    /*
     * Used during testing: A non-zero value overrides the actual log
     * version.
     */
    private static int testCurrentLogVersion = 0;

    /**
     * An instance of this class is created with each new handshake preceding
     * the setting up of a connection.
     *
     * @param repNode the replication node
     * @param feeder the feeder instance
     * @param namedChannel the channel to be used for the handshake
     */
    public FeederReplicaHandshake(RepNode repNode,
                                  Feeder feeder,
                                  NamedChannel namedChannel) {
        this.repNode = repNode;
        this.namedChannel = namedChannel;
        feederNameIdPair = repNode.getNameIdPair();
        logger = LoggerUtils.getLogger(getClass());
    }

    /**
     * Returns the replica node id. The returned value is only valid after
     * the handshake has been executed.
     *
     * @return the replica node name id pair
     */
    public NameIdPair getReplicaNameIdPair() {
        return replicaNameIdPair;
    }


    private int getCurrentLogVersion() {
        return (testCurrentLogVersion != 0) ?
               testCurrentLogVersion : LogEntryType.LOG_VERSION;
    }

    static public void setTestLogVersion(int testLogVersion) {
        testCurrentLogVersion = testLogVersion;
    }

    /**
     * Determines log compatibility. Returns null if they are compatible or the
     * server would like to defer the rejection to the replica. Return a
     * JEVersionsReject message if the server does not wish to communicate with
     * the replica.
     *
     * This check currently requires the log version of the replicas should be
     * larger than or equal to the log version on the feeder.
     */
    private JEVersionsReject checkJECompatibility(Protocol protocol,
                                                  JEVersions jeVersions) {

        return ((jeVersions.getLogVersion() >= getCurrentLogVersion()) ?
                null :
                protocol.new JEVersionsReject
                    ("Incompatible log versions. " +
                     "Feeder version: " + LogEntryType.LOG_VERSION +
                     ", Feeder JE version: " + JEVersion.CURRENT_VERSION +
                     ", Replica log version: " + jeVersions.getLogVersion() +
                     ", Replica JE version: " + jeVersions.getVersion()));
    }

    /**
     * Executes the feeder side of the handshake.
     * @throws ProtocolException
     * @throws ExitException
     */
    public Protocol execute()
        throws DatabaseException,
               IOException,
               ProtocolException,
               ExitException {

        LoggerUtils.info(logger, repNode.getRepImpl(),
                         "Feeder-replica handshake start");

        /* First negotiate a compatible protocol */
        Protocol protocol = negotiateProtocol();

        /* Now exchange JE version information using the negotiated protocol */
        replicaJEVersions = (ReplicaJEVersions) protocol.read(namedChannel);
        LoggerUtils.fine(logger, repNode.getRepImpl(),
                         " Replica " + replicaNameIdPair.getName() +
                         " JE version: " +
                         replicaJEVersions.getVersion().getVersionString() +
                         " Log version: " +
                         replicaJEVersions.getLogVersion());
        JEVersionsReject reject =
            checkJECompatibility(protocol, replicaJEVersions);

        if (reject != null) {
            LoggerUtils.warning(logger, repNode.getRepImpl(),
                                "Version incompatibility: " +
                                reject.getErrorMessage() +
                                " with replica " + replicaNameIdPair.getName());
            protocol.write(reject, namedChannel);
            return protocol;
        }
        protocol.write(protocol.new
                       FeederJEVersions(JEVersion.CURRENT_VERSION,
                                        LogEntryType.LOG_VERSION),
                       namedChannel);
        /* Verify replica membership info */
        verifyMembershipInfo(protocol);

        checkClockSkew(protocol);
        LoggerUtils.info
            (logger, repNode.getRepImpl(),
             "Feeder-replica " + replicaNameIdPair.getName() +
             " handshake completed.");

        return protocol;
    }

    /**
     * Responds to message exchanges used to establish clock skew.
     * @throws ProtocolException
     */
    private void checkClockSkew(Protocol protocol)
        throws IOException,
               ProtocolException {
        SNTPRequest request = null;
        do {
            request = protocol.read(namedChannel.getChannel(),
                                    SNTPRequest.class);
            protocol.write(protocol.new SNTPResponse(request), namedChannel);
        } while (!request.isLast());
    }

    /**
     * Verifies that the group as configured here at the Feeder matches the
     * configuration of the replica.
     *
     * @param protocol the protocol to use for this verification
     *
     * @throws IOException
     * @throws DatabaseException
     */
    private void verifyMembershipInfo(Protocol protocol)
        throws IOException,
               DatabaseException,
               ExitException {

        NodeGroupInfo nodeGroup =
            (Protocol.NodeGroupInfo)(protocol.read(namedChannel));
        final RepGroupImpl group = repNode.getGroup();
        RepNodeImpl node = group.getNode(nodeGroup.getNodeName());

        try {

            if (nodeGroup.getNodeId() != replicaNameIdPair.getId()) {
                throw new ExitException
                    ("The replica node id sent during protocol negotiation: " +
                     replicaNameIdPair +
                     " differs from the one sent in the MembershipInfo " +
                     "request: " + nodeGroup.getNodeId());
            }

            if (node == null) {
                /* Not currently a member. */
                try {
                    repNode.getRepGroupDB().ensureMember(nodeGroup);
                    node = 
                        repNode.getGroup().getMember(nodeGroup.getNodeName());
                    if (node == null) {
                        throw EnvironmentFailureException.unexpectedState
                            ("Node: " + nodeGroup.getNameIdPair() +
                             " not found");
                    }
                } catch (InsufficientReplicasException e) {
                    throw new ExitException(e);
                } catch (InsufficientAcksException e) {
                    throw new ExitException(e);
                } catch (NodeConflictException e) {
                    throw new ExitException(e);
                }
            } else if (node.isRemoved()) {
                throw new ExitException
                    ("Node: " + nodeGroup.getNameIdPair() +
                     " is no longer a member of the group." +
                     " It was explicitly removed.");
            }

            doGroupChecks(nodeGroup, group);
            doNodeChecks(nodeGroup, node);
        } catch (ExitException exception) {
            LoggerUtils.info
                (logger, repNode.getRepImpl(), exception.getMessage());
            protocol.write(protocol.new NodeGroupInfoReject
                           (exception.getMessage()), namedChannel);
            throw exception;
        }

        /* Id is now established for sure, update the pair. */
        replicaNameIdPair.update(node.getNameIdPair());
        namedChannel.setNameIdPair(replicaNameIdPair);
        LoggerUtils.fine(logger, repNode.getRepImpl(),
                         "Channel Mapping: " + replicaNameIdPair + " is at " +
                         namedChannel.getChannel());
        protocol.write(protocol.new NodeGroupInfoOK(group.getUUID(),
                                                    replicaNameIdPair),
                       namedChannel);
    }

    /**
     * Verifies that the group related information is consistent.
     *
     * @throws ExitException if the configuration in the group db differs
     * from the supplied config
     */
    private void doGroupChecks(NodeGroupInfo nodeGroup,
                                            final RepGroupImpl group)
        throws ExitException {

        if (nodeGroup.isDesignatedPrimary() &&
                repNode.getRepImpl().isDesignatedPrimary()) {
            throw new ExitException
            ("Conflicting Primary designations. Feeder node: " +
             repNode.getNodeName() +
             " and replica node: " + nodeGroup.getNodeName() +
            " cannot simultaneously be designated primaries");
        }

        if (!nodeGroup.getGroupName().equals(group.getName())) {
            throw new ExitException
                ("The feeder belongs to the group: " +
                 group.getName() + " but replica id" + replicaNameIdPair +
                 " belongs to the group: " + nodeGroup.getGroupName());
        }

        if (!RepGroupImpl.isUnknownUUID(nodeGroup.getUUID()) &&
            !nodeGroup.getUUID().equals(group.getUUID())) {
            throw new ExitException
                ("The environments have the same name: " +
                 group.getName() +
                 " but represent different environment instances." +
                 " The environment at the master has UUID " +
                 group.getUUID() +
                 ", while the replica " + replicaNameIdPair.getName() +
                 " has UUID: " + nodeGroup.getUUID());
        }
    }

    /**
     * Verifies that the old and new node configurations are the same.
     *
     * @throws ExitException if the configuration in the group db differs
     * from the supplied config
     */
    private void doNodeChecks(NodeGroupInfo nodeGroup,
                                           RepNodeImpl node)
        throws ExitException {

        if (!nodeGroup.getHostName().equals(node.getHostName())) {
            throw new ExitException
                ("Conflicting hostnames for replica id: " +
                 replicaNameIdPair +
                 " Feeder thinks it is: " + node.getHostName() +
                 " Replica is configured to use: " +
                 nodeGroup.getHostName());
        }

        if (nodeGroup.port() != node.getPort()) {
            throw new ExitException
                ("Conflicting ports for replica id: " + replicaNameIdPair +
                 " Feeder thinks it uses: " + node.getPort() +
                 " Replica is configured to use: " + nodeGroup.port());
        }

        if (!((NodeType.ELECTABLE == node.getType()) ||
              (NodeType.MONITOR == node.getType()))) {
            throw new ExitException
                ("The replica node: " + replicaNameIdPair +
                 " is of type: " + node.getType());
        }

        if (!nodeGroup.getNodeType().equals(node.getType())) {
            throw new ExitException
                ("Conflicting node types for: " + replicaNameIdPair +
                 " Feeder thinks it uses: " + node.getType() +
                 " Replica is configured as type: " + nodeGroup.getNodeType());
        }
    }

    /**
     * Negotiates and returns the protocol that will be used in all subsequent
     * interactions with the Replica, if the replica accepts to it.
     *
     * @return the protocol instance to be used for subsequent interactions
     *
     * @throws IOException
     * @throws DuplicateReplicaException if the nodeId is already in use by
     * some other feeder
     * @throws ExitException
     */
    private Protocol negotiateProtocol()
        throws IOException, ExitException {

        Protocol defaultProtocol = Protocol.getProtocol(repNode);

        /*
         * Wait to receive the replica's version, decide which protocol version
         * to use ourselves, and then reply with our version.
         */
        ReplicaProtocolVersion message =
            (ReplicaProtocolVersion) defaultProtocol.read(namedChannel);

        replicaNameIdPair = message.getNameIdPair();

        Feeder dup =
            repNode.feederManager().getFeeder(replicaNameIdPair.getName());
        if ((dup != null) ||
            (message.getNameIdPair().getName().
                    equals(feederNameIdPair.getName()))) {
            /* Reject the connection. */
            defaultProtocol.write(defaultProtocol.new DuplicateNodeReject
                                  ("This node: " + replicaNameIdPair +
                                   " is already in active use at the feeder "),
                                  namedChannel);
            SocketAddress dupAddress =
                namedChannel.getChannel().socket().getRemoteSocketAddress();
            throw new ExitException
                ("A replica with the id: " + replicaNameIdPair +
                 " is already active with this feeder. " +
                 " The duplicate replica resides at: " +
                 dupAddress);
        }

        /*
         * If the Replica's version is acceptable, use it, otherwise return the
         * default protocol at this node, in case the Replica can support it.
         */
        final int replicaVersion = message.getVersion();
        Protocol protocol = Protocol.get(repNode, replicaVersion);

        /*
         * If no suitable protocol was found, simply use the default protocol
         * at the feeder, it will be rejected by the Replica.
         */
        protocol = (protocol == null) ? defaultProtocol : protocol;
        defaultProtocol.write
             (defaultProtocol.new FeederProtocolVersion(protocol.getVersion()),
              namedChannel);
        return  protocol;
    }
}
