/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2008 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl;

import java.net.InetSocketAddress;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.NodeType;
import com.sleepycat.je.rep.ReplicationConfig;
import com.sleepycat.je.rep.ReplicationNode;
import com.sleepycat.je.rep.impl.RepGroupImpl.BarrierState;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.stream.Protocol;
import com.sleepycat.je.rep.utilint.HostPortPair;
import com.sleepycat.je.utilint.VLSN;

/**
 * Describes a node that is a member of the replication group.
 */
public class RepNodeImpl implements ReplicationNode {

    /* Identifies the node both by external name and internal node id. */
    private final NameIdPair nameIdPair;

    /* The node type, electable, monitor, etc. */
    private final NodeType type;

    /*
     * True if the node was acknowledged by a quorum and its entry is therefore
     * considered durable.
     */
    private boolean quorumAck;

    /*
     * True if the node has been removed and is no longer an active part of the
     * group
     */
    private boolean isRemoved;

    /* The hostname used for communications with the node. */
    private final String hostName;

    /* The port used by a node. */
    private final int port;

    /* The Cleaner Barrier state associated with the node. */
    private BarrierState barrierState;

    /*
     * This version is used in conjunction with the group level change
     * version to identify the incremental changes made to individual
     * changes made to a group.
     */
    private int changeVersion = NULL_CHANGE;

    static final int NULL_CHANGE = -1;

    /**
     * @hidden
     *
     * Constructor used to de-serialize a Node. All other convenience
     * constructors funnel through this one so that argument checks can
     * be systematically enforced.
     */
    public RepNodeImpl(NameIdPair nameIdPair,
                       NodeType type,
                       boolean quorumAck,
                       boolean isRemoved,
                       String hostName,
                       int port,
                       BarrierState barrierState,
                       int changeVersion) {

        if (nameIdPair.getName().equals(RepGroupDB.GROUP_KEY)) {
            throw EnvironmentFailureException.unexpectedState
            ("Member node id is the reserved key value: " + nameIdPair);
        }

        if (hostName == null) {
            throw EnvironmentFailureException.unexpectedState
            ("The hostname argument must not be null");
        }

        if (type == null) {
            throw EnvironmentFailureException.unexpectedState
            ("The nodeType argument must not be null");
        }

        this.nameIdPair = nameIdPair;
        this.type = type;
        this.quorumAck = quorumAck;
        this.hostName = hostName;
        this.port = port;
        this.isRemoved = isRemoved;
        this.changeVersion = changeVersion;
        this.barrierState = barrierState;
    }

    /**
     * @hidden
     *
     * Convenience constructor for the above.
     */
    public RepNodeImpl(NameIdPair nameIdPair,
                       NodeType type,
                       boolean quorumAck,
                       boolean isRemoved,
                       String hostName,
                       int port,
                       int changeVersion) {
        this(nameIdPair, type, quorumAck, isRemoved, hostName, port,
             new BarrierState(VLSN.NULL_VLSN,
                              System.currentTimeMillis()), changeVersion);
    }

    /**
     * @hidden
     * Convenience constructor for transient nodes
     */
    public RepNodeImpl(NameIdPair nameIdPair,
                       NodeType type,
                       String hostName,
                       int port) {
        this(nameIdPair, type, false, false, hostName, port,
             NULL_CHANGE);
    }

    /**
     * @hidden
     * Convenience constructor for transient nodes during unit tests.
     */
    public RepNodeImpl(ReplicationConfig repConfig) {
        this(new NameIdPair(repConfig.getNodeName(), NameIdPair.NULL_NODE_ID),
             repConfig.getNodeType(),
             repConfig.getNodeHostname(),
             repConfig.getNodePort());
    }

    /**
     * @hidden
     *
     * Convenience constructor for the above.
     */
    public RepNodeImpl(String nodeName, String hostName, int port) {
        this(new NameIdPair(nodeName, NameIdPair.NULL.getId()),
             NodeType.ELECTABLE, hostName, port);
    }

    /**
     * @hidden
     *
     * Convenience constructor for the above.
     */
    public RepNodeImpl(Protocol.NodeGroupInfo mi) {
        this(mi.getNameIdPair(),
             NodeType.ELECTABLE,
             mi.getHostName(),
             mi.port());
    }

    /* (non-Javadoc)
     * @see com.sleepycat.je.rep.ReplicationNode#getSocketAddress()
     */
    public InetSocketAddress getSocketAddress() {
        return new InetSocketAddress(hostName, port);
    }

    public boolean isQuorumAck() {
        return quorumAck;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setChangeVersion(int changeVersion) {
        this.changeVersion = changeVersion;
    }

    public int getChangeVersion() {
        return changeVersion;
    }

    public NameIdPair getNameIdPair() {
        return nameIdPair;
    }

    /* (non-Javadoc)
     * @see com.sleepycat.je.rep.ReplicationNode#getName()
     */
    public String getName() {
        return nameIdPair.getName();
    }

    public int getNodeId() {
        return nameIdPair.getId();
    }

    /* (non-Javadoc)
     * @see com.sleepycat.je.rep.ReplicationNode#getNodeType()
     */
    public NodeType getType() {
        return type;
    }

    /* (non-Javadoc)
     * @see com.sleepycat.je.rep.ReplicationNode#getHostName()
     */
    public String getHostName() {
        return hostName;
    }

    /* (non-Javadoc)
     * @see com.sleepycat.je.rep.ReplicationNode#getPort()
     */
    public int getPort() {
        return port;
    }

    /* (non-Javadoc)
     * @see com.sleepycat.je.rep.ReplicationNode#getHostPortPair()
     */
    public String getHostPortPair() {
        return HostPortPair.getString(hostName, port);
    }

    public BarrierState getBarrierState() {
        return barrierState;
    }

    public BarrierState setBarrierState(BarrierState barrierState) {
        return this.barrierState = barrierState;
    }

    public void setQuorumAck(boolean quorumAck) {
        this.quorumAck = quorumAck;
    }

    public void setRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    @Override
    public String toString() {

        String acked = "(is member)";

        if (!quorumAck) {
            acked = " (not yet a durable member)";
        } 

        if (isRemoved) {
            acked = " (is removed)";
        }

        String info = String.format("Node:%s %s:%d %s changeVersion:%d %s\n",
                                    getName(), getHostName(), getPort(),
                                    acked,
                                    getChangeVersion(),
                                    barrierState);
        return info;

    }

    /**
     * Like the equals method. It considers all fields except for the
     * quorumAck field and the nodeId (since it may not have been resolved
     * as yet)
     *
     * @param mi the other object in the comparison
     *
     * @return true if the two are equivalent
     */
    public boolean equivalent(RepNodeImpl mi) {
        if (this == mi) {
            return true;
        }

        if (mi == null) {
            return false;
        }

        if (port != mi.port) {
            return false;
        }

        if (hostName == null) {
            if (mi.hostName != null) {
                return false;
            }
        } else if (!hostName.equals(mi.hostName)) {
            return false;
        }

        /* Ignore the id. */
        if (!nameIdPair.getName().equals(mi.nameIdPair.getName())) {
            return false;
        }

        if (getType() != mi.getType()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((hostName == null) ? 0 : hostName.hashCode());
        result = prime * result + nameIdPair.hashCode();
        result = prime * result + port;
        result = prime * result + (isQuorumAck() ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof RepNodeImpl)) {
            return false;
        }
        final RepNodeImpl other = (RepNodeImpl) obj;
        if (hostName == null) {
            if (other.hostName != null) {
                return false;
            }
        } else if (!hostName.equals(other.hostName)) {
            return false;
        }
        if (!nameIdPair.equals(other.nameIdPair)) {
            return false;
        }
        if (getType() != other.getType()) {
            return false;
        }
        if (port != other.port) {
            return false;
        }
        if (isQuorumAck() != other.isQuorumAck()) {
            return false;
        }
        return true;
    }
}
