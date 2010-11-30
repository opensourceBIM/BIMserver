/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.stream;

import static com.sleepycat.je.rep.impl.RepParams.GROUP_NAME;
import static com.sleepycat.je.rep.impl.RepParams.MAX_CLOCK_DELTA;
import static com.sleepycat.je.rep.impl.RepParams.NODE_TYPE;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.JEVersion;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.rep.NodeType;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.stream.Protocol.DuplicateNodeReject;
import com.sleepycat.je.rep.stream.Protocol.FeederJEVersions;
import com.sleepycat.je.rep.stream.Protocol.FeederProtocolVersion;
import com.sleepycat.je.rep.stream.Protocol.JEVersionsReject;
import com.sleepycat.je.rep.stream.Protocol.NodeGroupInfoOK;
import com.sleepycat.je.rep.stream.Protocol.NodeGroupInfoReject;
import com.sleepycat.je.rep.stream.Protocol.SNTPResponse;
import com.sleepycat.je.rep.utilint.NamedChannel;
import com.sleepycat.je.rep.utilint.BinaryProtocol.Message;
import com.sleepycat.je.rep.utilint.BinaryProtocol.ProtocolException;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * Implements the Replica side of the handshake protocol between the Replica
 * and the Feeder. The FeederReplicaHandshake class takes care of the other
 * side.
 *
 * @see <a href="https://sleepycat.oracle.com/pmwiki/pmwiki.php?n=JEHomePage.ReplicaFeederHandshake">FeederReplicaHandshake</a>
 */
public class ReplicaFeederHandshake {

    /* The rep node (server or replica) */
    private final RepNode repNode;
    private final NamedChannel namedChannel;
    private final NameIdPair replicaNameIdPair;
    private NameIdPair feederNameIdPair;

    private Protocol protocol = null;

    /* The JE software versions in use by the Feeder */
    @SuppressWarnings("unused")
    private  FeederJEVersions feederJEVersions;

    /*
     * The time to wait between retries to establish node info in the master.
     */
    static final int MEMBERSHIP_RETRY_SLEEP_MS = 60*1000;
    static final int MEMBERSHIP_RETRIES = 0;

    /* Fields used to track clock skew wrt the feeder. */
    private long clockDelay = Long.MAX_VALUE;
    private long clockDelta = Long.MAX_VALUE;
    private static int CLOCK_SKEW_MAX_SAMPLE_SIZE = 5;
    private static final long CLOCK_SKEW_MIN_DELAY_MS = 2;
    private final int maxClockDelta;

    private final Logger logger;

    /**
     * An instance of this class is created with each new handshake preceding
     * the setting up of a connection.
     *
     * @param repNode the replication node
     * @param namedChannel the channel to be used for the handshake
     */
    public ReplicaFeederHandshake(RepNode repNode, NamedChannel namedChannel) {
        this.repNode = repNode;
        this.namedChannel = namedChannel;

        RepImpl repImpl = repNode.getRepImpl();
        replicaNameIdPair = repNode.getNameIdPair();
        maxClockDelta =
            repImpl.getConfigManager().getDuration(MAX_CLOCK_DELTA);
        logger = LoggerUtils.getLogger(getClass());
    }

    /**
     * Negotiates a protocol that both the replica and feeder can support.
     *
     * @return the common protocol
     *
     * @throws IOException
     * @throws DuplicateReplicaException
     * @throws IncompatibleFeederException if a common protocol was
     *                                     not available
     */
    private Protocol negotiateProtocol()
        throws IOException {

        final Protocol defaultProtocol = Protocol.getProtocol(repNode);
        /* Send over the latest version protocol this replica can support. */
        defaultProtocol.write(defaultProtocol.new ReplicaProtocolVersion(),
                              namedChannel);

        /*
         * Returns the highest level the feeder can support, or the version we
         * just sent, if it can support that version
         */
        Message message = defaultProtocol.read(namedChannel);
        if (message instanceof DuplicateNodeReject) {
            throw new EnvironmentFailureException
                (repNode.getRepImpl(),
                 EnvironmentFailureReason.HANDSHAKE_ERROR,
                 "A replica with the name: " +  replicaNameIdPair +
                 " is already active with the Feeder:" + feederNameIdPair);
        }

        FeederProtocolVersion feederVersion =
            ((FeederProtocolVersion) message);
        feederNameIdPair = feederVersion.getNameIdPair();
        Protocol configuredProtocol =
            Protocol.get(repNode, feederVersion.getVersion());
        LoggerUtils.fine(logger, repNode.getRepImpl(),
                         "Feeder id: " + feederVersion.getNameIdPair() +
                         "Response message: " + feederVersion.getVersion());
        namedChannel.setNameIdPair(feederNameIdPair);
        LoggerUtils.fine(logger, repNode.getRepImpl(),
                         "Channel Mapping: " + feederNameIdPair + " is at " +
                         namedChannel.getChannel());

        if (configuredProtocol == null) {
            throw new EnvironmentFailureException
                (repNode.getRepImpl(),
                 EnvironmentFailureReason.PROTOCOL_VERSION_MISMATCH,
                 "Incompatible protocol versions. " +
                 "Version: " + feederVersion.getVersion() +
                 " requested by the Feeder: " + feederNameIdPair +
                 " is not supported by this Replica: " + replicaNameIdPair +
                 ", which is at version: " + defaultProtocol.getVersion());
        }
        return configuredProtocol;
    }

    /**
     * Executes the replica side of the handshake.
     * @throws ProtocolException
     */
    public Protocol execute()
        throws IOException,
               ProtocolException {

        LoggerUtils.info(logger, repNode.getRepImpl(),
                         "Replica-feeder handshake start");

        /* First negotiate the protocol, then use it. */
        protocol = negotiateProtocol();

        /* Ensure that software versions are compatible. */
        verifyVersions();

        /*
         * Now perform the membership information validation part of the
         * handshake
         */
        verifyMembership();

        checkClockSkew();

        LoggerUtils.info(logger, repNode.getRepImpl(),
                         "Replica-feeder " + feederNameIdPair.getName() +
                         " handshake completed.");
        return protocol;
    }

    /**
     * Checks software and log version compatibility.
     */
    private void verifyVersions()
        throws IOException {

        protocol.write(protocol.new
                       ReplicaJEVersions(JEVersion.CURRENT_VERSION,
                                         LogEntryType.LOG_VERSION),
                       namedChannel);
        Message message = protocol.read(namedChannel);
        if (message instanceof JEVersionsReject) {
            /* The software version is not compatible with the Feeder. */
            throw new EnvironmentFailureException
                (repNode.getRepImpl(),
                 EnvironmentFailureReason.HANDSHAKE_ERROR,
                 " Feeder: " + feederNameIdPair + ". " +
                 ((JEVersionsReject) message).getErrorMessage());
        }
        /*
         * Just save it for now. Use it as the basis for compatibility checking
         * in future.
         */
        feederJEVersions = (FeederJEVersions)message;
    }

    /**
     * Exchange membership information messages.
     */
    private void verifyMembership()
        throws IOException {

        final RepImpl repImpl = repNode.getRepImpl();
        DbConfigManager configManager = repImpl.getConfigManager();
        String groupName = configManager.get(GROUP_NAME);
        NodeType nodeType =
            NODE_TYPE.getEnumerator(configManager.get(NODE_TYPE));

        Message message = protocol.new
            NodeGroupInfo(groupName,
                          repNode.getGroup().getUUID(),
                          replicaNameIdPair,
                          repImpl.getHostName(),
                          repImpl.getPort(),
                          nodeType,
                          repImpl.isDesignatedPrimary());
        protocol.write(message, namedChannel);

        message = protocol.read(namedChannel);

        if (message instanceof NodeGroupInfoReject) {
            NodeGroupInfoReject reject = (NodeGroupInfoReject) message;
            throw new EnvironmentFailureException
                (repImpl,
                 EnvironmentFailureReason.HANDSHAKE_ERROR,
                 " Feeder: " + feederNameIdPair + ". " +
                 reject.getErrorMessage());
        }

        if (!(message instanceof NodeGroupInfoOK)) {
            throw new EnvironmentFailureException
                (repImpl,
                 EnvironmentFailureReason.HANDSHAKE_ERROR,
                 " Feeder: " + feederNameIdPair + ". " +
                 "Protcol error. Unexpected response " + message);
        } else if (repNode.getGroup().hasUnknownUUID()) {
            /* Correct the initial UUID */
            repNode.getGroup().setUUID(((NodeGroupInfoOK)message).getUUID());
        }
    }

    /**
     * Checks for clock skew wrt the current feeder. It's important that the
     * clock skew be within an acceptable range so that replica can meet any
     * time based consistency requirements requested by transactions. The
     * intent of this check is to draw the attention of the application or the
     * administrators to the skew, not correct it.
     * <p>
     * The scheme implemented below is a variation on the scheme used by <a
     * href="http://tools.ietf.org/html/rfc2030">SNTP</a> protocol. The Feeder
     * plays the role of the SNTP server and the replica the role of the client
     * in this situation. The mechanism used here is rough and does not
     * guarantee the detection of a clock skew, especially since it's a one
     * time check done each time a connection is re-established with the
     * Feeder. The clocks could be in sync at the time of this check and drift
     * apart over the lifetime of the connection. It's also for this reason
     * that we do not store the skew value and make compensations using it when
     * determining replica consistency.
     * <p>
     * Replications nodes should therefore ensure that they are using NTP or a
     * similar time synchronization service to keep time on all the replication
     * nodes in a group in sync.
     * <p>
     *
     * @throws IOException
     * @throws EnvironmentFailureException
     * @throws ProtocolException
     */
    private void checkClockSkew()
        throws IOException,
               ProtocolException {

        boolean isLast = false;
        int sampleCount = 0;
        do {
            /* Iterate until we have a value that's good enough. */
            isLast = (++sampleCount >= CLOCK_SKEW_MAX_SAMPLE_SIZE) ||
                     (clockDelay <= CLOCK_SKEW_MIN_DELAY_MS);

            protocol.write(protocol.new SNTPRequest(isLast), namedChannel);
            SNTPResponse response = protocol.read(namedChannel,
                                                  SNTPResponse.class);
            if (response.getDelay() < clockDelay) {
                clockDelay = response.getDelay();
                clockDelta = response.getDelta();
            }

        } while (!isLast);

        LoggerUtils.logMsg
            (logger, repNode.getRepImpl(),
             (Math.abs(clockDelta) >= maxClockDelta) ?
             Level.SEVERE : Level.FINE,
             "Round trip delay: " + clockDelay + " ms. " + "Clock delta: " +
             clockDelta + " ms. " + "Max permissible delta: " +
             maxClockDelta + " ms.");

        if (Math.abs(clockDelta) >= maxClockDelta) {
            throw new EnvironmentFailureException
                (repNode.getRepImpl(),
                 EnvironmentFailureReason.HANDSHAKE_ERROR,
                 "Clock delta: " + clockDelta + " ms. " +
                 "between Feeder: " + feederNameIdPair.getName() +
                 " and this Replica exceeds max permissible delta: " +
                 maxClockDelta + " ms.");
        }
    }
}
