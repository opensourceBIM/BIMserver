/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.MemberNotFoundException;
import com.sleepycat.je.rep.NodeType;
import com.sleepycat.je.rep.impl.RepGroupDB.NodeBinding;
import com.sleepycat.je.utilint.VLSN;

/**
 * Represents a snapshot of the Replication Group as a whole. Note that
 * membership associated with a group is dynamic and its constituents can
 * change at any time. It's useful to keep in mind that due to the distributed
 * nature of the Replication Group all the nodes in a replication group may not
 * have the same consistent picture of the replication group at a single point
 * in time, but will converge to become consistent eventually.
 */
public class RepGroupImpl {

    /* The name of the Replication Group. */
    private final String groupName;

    /*
     * The universally unique UUID associated with the replicated environment.
     */
    private UUID uuid;

    /*
     * The version number associated with this group's representation in the
     * database.
     */
    private final int version;

    /*
     * Tracks the change version level. It's updated with every change to the
     * member set in the membership database.
     */
    private int changeVersion = 0;

    /*
     * It's the sequence used for assigning unique node ids. Node Ids are never
     * reused. It represents the highest sequence number currently in use.
     */
    private int nodeIdSequence;
    private static final int NODE_SEQUENCE_START = 0;

    /*
     * The following maps represent the set of nodes in the group indexed in
     * two different ways: by user-defined node name and by internal id. Note
     * that both maps contain nodes that are no longer members of the group.
     */
    /* All the nodes that form the replication group, indexed by Id */
    private Map<Integer, RepNodeImpl> nodesById;

    /*
     * All the nodes that form the replication group, indexed by node name.
     * This map is used exclusively for efficient lookups by name. The map
     * nodesById, it does all the heavy lifting.
     */
    private Map<String, RepNodeImpl> nodesByName;

    /*
     * The version of the node used for its representation. It's used to
     * manage schema evolution of the node's representation.
     */
    private final static int VERSION = 2;
    private final static int CHANGE_VERSION_START = 0;

    /*
     * The special UUID associated with a group, when the group UUID is unknown
     * because a node is still in the process of joining the group. This value
     * cannot be created by UUID.randomUUID
     */
    private final static UUID UNKNOWN_UUID = new UUID(0, 0);

    /**
     * Constructor to create a new empty repGroup, typically as part of
     * environment initialization.
     *
     * @param groupName
     */
    public RepGroupImpl(String groupName) {
        this(groupName, false);
    }

    public RepGroupImpl(String groupName, boolean unknownUUID) {
        this(groupName,
             unknownUUID ? UNKNOWN_UUID : UUID.randomUUID(),
             VERSION,
             CHANGE_VERSION_START,
             NODE_SEQUENCE_START,
             new HashMap<Integer, RepNodeImpl>());
    }


    /**
     * Constructor used to recreate an existing RepGroup, typically as part of
     * a deserialization operation.
     *
     * @param groupName
     * @param uuid
     * @param version
     * @param changeVersion
     * @param nodes
     */
    public RepGroupImpl(String groupName,
                        UUID uuid,
                        int version,
                        int changeVersion,
                        int nodeIdSequence,
                        Map<Integer, RepNodeImpl> nodes) {
        this.groupName = groupName;
        this.uuid = uuid;
        this.version = version;
        this.changeVersion = changeVersion;
        this.nodeIdSequence = nodeIdSequence;

        if (VERSION != version) {
            throw new IllegalStateException
                ("Expected membership database version: " + VERSION +
                 " Encountered unsupported version: " + version);
        }
        setNodes(nodes);
    }

    /*
     * Returns true if the UUID has not as yet been established at this node.
     * This is the case when a knew node first joins a group, and it has not
     * as yet replicated the group database via the replication stream.
     */
    public boolean hasUnknownUUID() {
        return UNKNOWN_UUID.equals(uuid);
    }

    /**
     * Predicate to help determine whether the UUID is the canonical unknown
     * UUID.
     */
    public static boolean isUnknownUUID(UUID uuid) {
        return UNKNOWN_UUID.equals(uuid);
    }

    /**
     * Sets the UUID. The UUID can only be set if it's currently unknown.
     */
    public void setUUID(UUID uuid) {
        if (!hasUnknownUUID()) {
            throw EnvironmentFailureException.unexpectedState
                ("Expected placeholder UUID, not " + uuid);
        }
        this.uuid = uuid;
    }

    /**
     * Removes a member transiently from the rep group by marking it as being
     * deleted. This action is usually a precursor to making the change
     * persistent on disk. Note that the node is simply marked as being removed
     * it's not actually deleted from the representation.
     *
     * @param nodeName identifies the node being removed
     *
     * @return the node that was removed
     *
     * @throws EnvironmentFailureException if the node is not part of the group
     */
    public RepNodeImpl removeMember(String nodeName) {
        final RepNodeImpl node = getMember(nodeName);
        if (node == null) {
            throw EnvironmentFailureException.unexpectedState
                ("Node:" + nodeName + " is not a member of the group.");
        }
        node.setRemoved(true);
        return node;
    }

    /**
     * Checks for whether a new node definition is in conflict with the current
     * members of the group. This check must be done before adding a new
     * member to the group and must be done with the rep group entry in the
     * database locked for write to prevent race conditions.
     *
     * @param node the new node that is being checked for conflicts
     * @throws NodeConflictException if there is a conflict
     */
    public void checkForConflicts(RepNodeImpl node)
        throws DatabaseException, NodeConflictException {

        for (RepNodeImpl n : getAllMembers(null)) {
            if (n.getSocketAddress().equals(node.getSocketAddress())) {
                throw new NodeConflictException
                    ("New node:" + node.getName() +
                     ", is configured with the socket address: " +
                     n.getSocketAddress() +
                     ". It conflicts with the socket already " +
                     "used by the member: " + n.getName());
            }
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + changeVersion;
        result = prime * result
                + ((groupName == null) ? 0 : groupName.hashCode());
        result = prime * result + ((nodesById == null) ? 0 :
                                    nodesById.hashCode());
        /* Don't bother with nodesByName */
        result = prime * result
                + ((uuid == null) ? 0 : uuid.hashCode());
        result = prime * result + version;
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
        if (!(obj instanceof RepGroupImpl)) {
            return false;
        }
        RepGroupImpl other = (RepGroupImpl) obj;
        if (changeVersion != other.changeVersion) {
            return false;
        }
        if (groupName == null) {
            if (other.groupName != null) {
                return false;
            }
        } else if (!groupName.equals(other.groupName)) {
            return false;
        }
        if (nodesById == null) {
            if (other.nodesById != null) {
                return false;
            }
        } else if (!nodesById.equals(other.nodesById)) {
            return false;
        }
        /* Don't bother with nodesByName, since nodesById equality covers it */
        if (uuid == null) {
            if (other.uuid != null) {
                return false;
            }
        } else if (!uuid.equals(other.uuid)) {
            return false;
        }
        if (version != other.version) {
            return false;
        }
        return true;
    }

    /**
     * Sets the nodes associated with the Rep group. Note that both nodesById
     * and nodesByIndex are initialized.
     */
    public void setNodes(Map<Integer, RepNodeImpl> nodes) {
        this.nodesById = nodes;
        if (nodes == null) {
            nodesByName = null;
            return;
        }
        nodesByName = new HashMap<String, RepNodeImpl>();
        for (RepNodeImpl node : nodes.values()) {
            nodesByName.put(node.getName(), node);
        }
    }

    /**
     * returns the unique UUID associated with the replicated environment.
     *
     * @return the UUID
     */
    public UUID getUUID() {
        return uuid;
    }

    /**
     * Returns the version of the representation (the schema) in use by this
     * group instance in the database.
     *
     * @return the representation version number
     */
    public int getVersion() {
        return version;
    }

    /**
     * Returns the version of the instance as represented by changes to the
     * members constituting the group.
     *
     * @return the object change version
     */
    public int getChangeVersion() {
        return changeVersion;
    }

    /**
     * Increments the object change version. It must be called with the group
     * entry locked in the group database.
     *
     * @return the incremented change version
     */
    public int incrementChangeVersion() {
        return ++changeVersion;
    }

    /**
     * Returns the current highest node id currently in use by the group.
     *
     * @return the highest node id in use
     */
    public int getNodeIdSequence() {
        return nodeIdSequence;
    }

    /**
     * Increments the node id sequence and returns it.
     *
     * @return the next node id for use in a new node
     */
    public int getNextNodeId() {
        return ++nodeIdSequence;
    }

    /**
     * Returns the node id that is associated with the very first node in the
     * replication group.
     */
    public static int getFirstNodeId() {
        return NODE_SEQUENCE_START+1;
    }

    /**
     * Used to ensure that the ReplicationGroup value is consistent after it
     * has been fetched via a readUncommitted access to the rep group database.
     * It does so by ensuring that the summarized values match the nodes that
     * were actually read.
     */
    public void makeConsistent() {
        if (nodesById.size() == 0) {
            return;
        }
        int computedNodeId = NODE_SEQUENCE_START-1;
        int computedChangeVersion = -1;
        for (RepNodeImpl mi : nodesById.values()) {
            /* Get the highest node id */
            if (computedNodeId < mi.getNodeId()) {
                computedNodeId = mi.getNodeId();
            }
            /* Get the highest change version. */
            if (computedChangeVersion < mi.getChangeVersion()) {
                computedChangeVersion = mi.getChangeVersion();
            }
        }
        nodeIdSequence = computedNodeId;
        changeVersion = computedChangeVersion;
    }

    /**
     * Serializes an object by converting its TupleBinding byte based
     * representation into the hex characters deonoting the bytes.
     *
     * @param <T> the type of the object being serialized
     * @param binding the tuble binding used to convert it into its byte form
     * @param object the object being serialized
     * @return the hex string containing the serialized hex form of the object
     */
    static <T> String objectToHex(TupleBinding<T> binding, T object) {
        StringBuffer buffer = new StringBuffer();
        TupleOutput tuple = new TupleOutput(new byte[100]);
        binding.objectToEntry(object, tuple);
        byte[] bytes = tuple.getBufferBytes();
        int size = tuple.getBufferLength();

        for (int i=0; i < size; i++) {
            int lowNibble = (bytes[i] & 0xf);
            int highNibble = ((bytes[i]>>4) & 0xf);
            buffer.append(Character.forDigit(lowNibble,16));
            buffer.append(Character.forDigit(highNibble,16));
        }
        return buffer.toString();
    }

    /**
     * Returns a serialized character based form of the group suitable for use
     * in subclasses of SimpleProtocol. The serialized form is a multi-token
     * string. The first token represents the RepGroup object itself with each
     * subsequent node representing a node in the group. Tokens are separated
     * by '|', the protocol separator character. The number of tokens is thus
     * equal to the number of nodes in the group + 1. Each token is itself a
     * hex character based representation of the binding used to serialize a
     * RepGroup and store it into the database.
     *
     * @return the string encoded as above.
     */
    public String serializeHex() {
        final RepGroupDB.GroupBinding groupBinding =
            new RepGroupDB.GroupBinding();
        StringBuffer buffer = new StringBuffer();
        buffer.append(objectToHex(groupBinding, this));
        for (RepNodeImpl mi : nodesById.values()) {
            buffer.append(TextProtocol.SEPARATOR);
            buffer.append(serializeHex(mi));
        }
        return buffer.toString();
    }

    /**
     * Returns the serialized form of the node as a sequence of hex characters
     * suitable for use by the text based protocols.
     *
     * @param node the node to be serialized.
     *
     * @return the string containing the serialized form of the node.
     */
    static public String serializeHex(RepNodeImpl node) {
        final NodeBinding nodeBinding = new NodeBinding();
        return objectToHex(nodeBinding, node);
    }

    /**
     * Serialize the node into its byte representation.
     *
     * @param node the node to be serialized
     *
     * @return the serailized byte array
     */
    static public byte[] serializeBytes(RepNodeImpl node) {
        final NodeBinding binding = new NodeBinding();
        TupleOutput tuple = new TupleOutput(new byte[100]);
        binding.objectToEntry(node, tuple);
        return tuple.getBufferBytes();
    }

    /**
     * Deserializes the object serialized by {@link #serializeHex}
     *
     * @param hex the string containing the serialized form of the node
     *
     * @return the de-serialized object
     */
    static public RepNodeImpl hexDeserializeNode(String hex) {
        final NodeBinding nodeBinding = new NodeBinding();
        return hexToObject(nodeBinding, hex);
    }

    /**
     * Deserialize the mode from its byte representation.
     *
     * @param bytes the byte representation of the node.
     *
     * @return the deserialized object
     */
    static public RepNodeImpl deserializeNode(byte[] bytes) {
        final NodeBinding binding = new NodeBinding();
        TupleInput tuple = new TupleInput(bytes);
        return binding.entryToObject(tuple);
    }

    /**
     * Carries out the two step de-serialization from hex string into a byte
     * buffer and subsequently into its object representation.
     *
     * @return the object representation
     */
    private static <T> T hexToObject(TupleBinding<T> binding, String hex) {
        byte buffer[] = new byte[(hex.length()/2)];
        for (int i=0; i < hex.length(); i+=2) {
            int value = Character.digit(hex.charAt(i),16);
            value |= Character.digit(hex.charAt(i+1),16) << 4;
            buffer[i >> 1] = (byte)value;
        }
        TupleInput tuple = new TupleInput(buffer);
        return binding.entryToObject(tuple);
    }

    /**
     * De-serializes an array of tokens into a Rep group object and its nodes.
     * the token at <code>start</code>represents the group object and each
     * subsequent token represents a node in the group.
     *
     * @param tokens the array representing the group and its nodes
     * @param start the position in the array at which to start the
     * de-serialization.
     *
     * @return the de-serialized RepGroup
     */
    static public RepGroupImpl deserializeHex(String[] tokens, int start) {
        final RepGroupDB.GroupBinding groupBinding =
            new RepGroupDB.GroupBinding();
        RepGroupImpl group = hexToObject(groupBinding, tokens[start++]);
        Map<Integer,RepNodeImpl> nodeMap =
            new HashMap<Integer,RepNodeImpl>();
        while (start < tokens.length) {
            RepNodeImpl n = hexDeserializeNode(tokens[start++]);
            RepNodeImpl old = nodeMap.put(n.getNameIdPair().getId(), n);
            assert(old == null);
        }
        group.setNodes(nodeMap);
        return group;
    }

    /**
     * Returns the nodes ids associated with all the nodes that are members
     * of the group.
     */
    public Set<Integer> getAllMemberIds() {
        Set<Integer> ret = new HashSet<Integer>();
        for (RepNodeImpl mi : nodesById.values()) {
            if (!mi.isRemoved()) {
                ret.add(mi.getNodeId());
            }
        }
        return ret;
    }

    /*
     * Returns all nodes that are currently members of the group. Note
     * that monitors are considered members of the group for this purpose.
     */
    public Set<RepNodeImpl> getAllMembers(Predicate p) {
        Set<RepNodeImpl> ret = new HashSet<RepNodeImpl>();
        for (RepNodeImpl mi : nodesById.values()) {
            if (!mi.isRemoved() && ((p == null) || p.include(mi))) {
                ret.add(mi);
            }
        }
        return ret;
    }

    abstract class Predicate {
        abstract boolean include(RepNodeImpl n);
    }

    /**
     * Returns the subset of Electable nodes in the group. Includes nodes
     * that may not yet have been acknowledged.
     */
    public Set<RepNodeImpl> getAllElectableMembers() {
        return getAllMembers(new Predicate() {
                @Override
                boolean include(RepNodeImpl n) {
                    return (n.getType() == NodeType.ELECTABLE);
                }
            });
    }

    public Set<RepNodeImpl> getElectableNodes() {
        return getAllMembers(new Predicate() {
                @Override
                boolean include(RepNodeImpl n) {
                    return (n.getType() == NodeType.ELECTABLE) &&
                    n.isQuorumAck();
                }
            });
    }

    /**
     * Returns the monitor nodes that are members of the group.
     *
     * @return the set of monitor nodes
     */
    public Set<RepNodeImpl> getMonitorNodes() {
        return getAllMembers(new Predicate() {
            @Override
            boolean include(RepNodeImpl n) {
                return (n.getType() == NodeType.MONITOR);
            }
        });
    }

    private Set<InetSocketAddress> getAllMemberSockets(Predicate p) {
        Set<InetSocketAddress> sockets = new HashSet<InetSocketAddress>();
        for (RepNodeImpl mi : nodesById.values()) {
            if (!mi.isRemoved() && ((p == null) || p.include(mi))) {
                sockets.add(mi.getSocketAddress());
            }
        }
        return sockets;
    }

    /**
     * Return all learner sockets. Every node electable, non-electable and
     * peer has a learner socket so it can track elections. All nodes in the
     * group have Learner agents associated with them.
     *
     * @return set of learner sockets for the group
     */
    public Set<InetSocketAddress> getLearnerSockets() {
        return getAllMemberSockets(null);
    }

    /**
     * Returns the sockets used by just the Monitor nodes in the group
     *
     * @return the set of Monitor sockets
     */
    public Set<InetSocketAddress> getMonitorSockets() {
        return getAllMemberSockets(new Predicate() {
            @Override
            boolean include(RepNodeImpl n) {
                return (n.getType() == NodeType.MONITOR);
            }
        });
    }

    /**
     * Returns the sockets used by nodes running Acceptor agents, that is,
     * just nodes which participate in elections and can become Masters.
     *
     * @return the set of Monitor sockets
     */
    public Set<InetSocketAddress> getAcceptorSockets() {
        return getAllMemberSockets(new Predicate() {
            @Override
            boolean include(RepNodeImpl n) {
                return (n.getType() == NodeType.ELECTABLE);
            }
        });
    }

    /*
     * Lookup for existing members. Nodes that are no longer members are
     * not returned.
     */
    public RepNodeImpl getMember(int nodeId) {
        RepNodeImpl node = getNode(nodeId);
        if (node == null) {
            return null;
        }
        if (node.isRemoved()) {
            throw EnvironmentFailureException.unexpectedState
                ("No longer a member:" + nodeId);
        }
        return node;
    }

    /**
     * Lookup for existing members. Nodes that are no longer members are
     * not returned.
     */
    public RepNodeImpl getMember(String name)
        throws MemberNotFoundException {

        RepNodeImpl node = getNode(name);
        if (node == null) {
            return null;
        }
        if (node.isRemoved()) {
            throw new MemberNotFoundException
                ("Node no longer a member:" + name);
        }
        return node;
    }

    /**
     *  Get the node, if it's present, regardless of its membership state. Use
     *  getMember() to retrieve a current member.
     *
     *  @return the node if it's still present in the group, null otherwise.
     */
    public RepNodeImpl getNode(int nodeId) {

        RepNodeImpl node = nodesById.get(nodeId);
        return node;
    }

    /**
     *  Get the node, if it's present, regardless of its membership state. Use
     *  getMember() to retrieve a current member.
     *
     *  @return the node if it's still present in the group, null otherwise.
     */
    public RepNodeImpl getNode(String name) {

        RepNodeImpl node = nodesByName.get(name);
        return node;
    }

    /**
     * Note that even unACKed nodes are considered part of the group for
     * group size/durability considerations.
     *
     * @return the size of the group for durability considerations
     */
    public int getElectableGroupSize() {
        return getAllElectableMembers().size();
    }

    public String getName() {
        return groupName;
    }

    /**
     * Encapsulates the last known syncup state associated with a node.
     */
    public static class BarrierState {

        /*
         * The latest sync position of this node in the replication stream.
         * This position is approximate and is updated on some regular basis.
         * It is conservative in that the node is likely to have a newer sync
         * point. So it represents a lower bound for its sync point.
         */
        private final VLSN lastLocalCBVLSN;

        /*
         * The time that the sync point was last recorded. Note that clocks
         * should be reasonably synchronized.
         */
        private final long barrierTime;

        public BarrierState(VLSN lastLocalCBVLSN, long barrierTime) {
            super();
            this.lastLocalCBVLSN = lastLocalCBVLSN;
            this.barrierTime = barrierTime;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result +
                    (lastLocalCBVLSN == null ? 0 : lastLocalCBVLSN.hashCode());
            result = prime * result +
                     (int) (barrierTime ^ (barrierTime >>> 32));
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
            if (getClass() != obj.getClass()) {
                return false;
            }
            BarrierState other = (BarrierState) obj;
            if (lastLocalCBVLSN == null) {
                if (other.lastLocalCBVLSN != null) {
                    return false;
                }
            } else if (!lastLocalCBVLSN.equals(other.lastLocalCBVLSN)) {
                return false;
            }
            if (barrierTime != other.barrierTime) {
                return false;
            }
            return true;
        }

        public VLSN getLastCBVLSN() {
            return lastLocalCBVLSN;
        }

        public long getBarrierTime() {
            return barrierTime;
        }

        @Override
        public String toString() {
            return String.format("LocalCBVLSN:%,d at:%tc",
                                 lastLocalCBVLSN.getSequence(), barrierTime);
        }
    }

    /*
     * An internal exception indicating that two nodes have conflicting
     * configurations. For example, they both use the same hostname and port.
     */
    @SuppressWarnings("serial")
    public static class NodeConflictException extends DatabaseException {
        public NodeConflictException(String message) {
            super(message);
        }
    }

    /**
     * Return information to the user, format nicely for ease of reading.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group info [").append(groupName).append("] ");
        sb.append(getUUID()).
            append("\n Representation version: ").append(getVersion()).
            append("\n Change version: ").append(getChangeVersion()).
            append("\n Max rep node id: ").append(getNodeIdSequence()).
            append("\n");

        if (nodesByName != null) {
            for (Map.Entry<String, RepNodeImpl> entry : 
                     nodesByName.entrySet()) {
                sb.append(" ").append(entry.getValue());
            }
        }
        return sb.toString();
    }
}
