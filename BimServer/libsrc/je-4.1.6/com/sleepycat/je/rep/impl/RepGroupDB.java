/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl;

import static com.sleepycat.je.rep.NoConsistencyRequiredPolicy.NO_CONSISTENCY;
import static com.sleepycat.je.rep.impl.RepParams.GROUP_NAME;
import static com.sleepycat.je.rep.impl.RepParams.NODE_NAME;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import com.sleepycat.bind.tuple.StringBinding;
import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DatabaseNotFoundException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Durability;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.Durability.ReplicaAckPolicy;
import com.sleepycat.je.Durability.SyncPolicy;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.rep.InsufficientAcksException;
import com.sleepycat.je.rep.InsufficientReplicasException;
import com.sleepycat.je.rep.NodeType;
import com.sleepycat.je.rep.impl.RepGroupImpl.BarrierState;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.monitor.GroupChangeEvent.GroupChangeType;
import com.sleepycat.je.rep.stream.Protocol;
import com.sleepycat.je.rep.txn.MasterTxn;
import com.sleepycat.je.rep.txn.ReadonlyTxn;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.VLSN;

/**
 * This class is used to encapsulate all access to the rep group data that is
 * present in every replicated JE environment. The rep group data exists
 * primarily to support dynamic group membership. Both read and update access
 * must be done through the APIs provided by this class.
 *
 * The database is simply a representation of the RepGroup. Each entry in the
 * database represents a node in RepGroup; the key is the String node name, and
 * the data is the serialized ReplicationNode.  There is a special entry keyed
 * by GROUP_KEY that holds the contents of the RepGroup (excluding the nodes)
 * itself.
 *
 * The database may be modified concurrently by multiple transactions as a
 * master processes requests to update it. It may also be accessed by multiple
 * overlapping transactions as a Replica replays the rep stream. These updates
 * need to be interleaved with operations like getGroup() that create copies of
 * the RepGroup instance. To avoid deadlocks, entries in the database are
 * accessed in order of ascending key. GROUP_KEY in particular is associated
 * with the lowest key value so that it's locked first implicitly as part of
 * any iteration and any other modifications to the database must first lock it
 * before making changes to the group itself.
 *
 * An instance of this class is created as part of a replication node and is
 * retained for the entire lifetime of that node.
 */
public class RepGroupDB {

    private final RepImpl repImpl;

    /* A convenient, cached empty group. */
    public final RepGroupImpl emptyGroup;

    private final Logger logger;

    /* The key used to store group-wide information in the database. It must
     * be the lowest key in the database, so that it's locked first during
     * database iteration.
     */
    public final static String GROUP_KEY = "$$GROUP_KEY$$";
    public final static DatabaseEntry groupKeyEntry = new DatabaseEntry();

    /* Initialize the entry. */
    static {
        StringBinding.stringToEntry(GROUP_KEY, groupKeyEntry);
    }

    /* The fixed DB ID associated with the internal rep group database. */
    public final static int DB_ID = DbTree.NEG_DB_ID_START - 1;

    /*
     * Number of times to retry for ACKs on the master before returning to
     * to the Replica, which will then again retry on some periodic basis.
     */
    private final static int QUORUM_ACK_RETRIES = 5;

    /* Convenience Durability and Config constants. */
    private final static Durability QUORUM_ACK_DURABILITY =
        new Durability(SyncPolicy.SYNC,
                       SyncPolicy.SYNC,
                       ReplicaAckPolicy.SIMPLE_MAJORITY);

    private final static TransactionConfig QUORUM_ACK =
        new TransactionConfig();

    private final static TransactionConfig NO_ACK = new TransactionConfig();

    /*
     * TODO: Change this when we support true read only transactions.
     */
    final static TransactionConfig READ_ONLY = NO_ACK;

    private final static Durability NO_ACK_DURABILITY =
        new Durability(SyncPolicy.SYNC,
                       SyncPolicy.SYNC,
                       ReplicaAckPolicy.NONE);

    private final static Durability NO_ACK_NO_SYNC_DURABILITY =
        new Durability(SyncPolicy.NO_SYNC,
                       SyncPolicy.NO_SYNC,
                       ReplicaAckPolicy.NONE);

    private final static TransactionConfig NO_ACK_NO_SYNC =
        new TransactionConfig();

    static {
        /* Initialize config constants. */
        QUORUM_ACK.setDurability(QUORUM_ACK_DURABILITY);
        NO_ACK.setDurability(NO_ACK_DURABILITY);
        NO_ACK_NO_SYNC.setDurability(NO_ACK_NO_SYNC_DURABILITY);
    }

    /**
     * Create an instance. Note that the database handle is not initialized at
     * this time, since the state of the node master/replica is not known
     * at the time the replication node (and consequently this instance) is
     * created.
     * @throws IOException
     * @throws DatabaseException
     */
    public RepGroupDB(RepImpl repImpl)
        throws DatabaseException, IOException {

        this.repImpl = repImpl;

        DbConfigManager configManager = repImpl.getConfigManager();
        emptyGroup = new RepGroupImpl(configManager.get(GROUP_NAME));
        logger = LoggerUtils.getLogger(getClass());
    }

    /**
     * Returns all the members that are currently part of the replication
     * group. This method can read the database directly, and can be used when
     * the replicated environment is detached and the RepNode is null. It's for
     * the latter reason that the method reads uncommitted data. In detached
     * mode, there may be transactions on the database that were in progress
     * when the node was last shutdown. These transactions may have locks which
     * will not be released until after the node is re-attached and the
     * replication stream is resumed. Using uncommitted reads avoids use of
     * locks in this circumstance. It's safe to read these records, since the
     * database will eventually be updated with these changes.
     *
     * @param policy determines how current the information must be if it's
     * invoked on a Replica.
     *
     * @return the group object
     * @throws DatabaseException if the object could not be obtained
     */
    public static RepGroupImpl getGroup(RepImpl rImpl,
                                        String groupName,
                                        ReplicaConsistencyPolicy policy)
        throws DatabaseException {

        DatabaseImpl dbImpl = null;
        try {
            dbImpl = rImpl.getGroupDb(policy);
        } catch (DatabaseNotFoundException e) {
            /* Creates a temporary placeholder group for use until the real
             * definition comes over the replication stream as part of the
             * replicated group database.
             */
            return new RepGroupImpl(groupName, true);
        }

        TransactionConfig txnConfig = new TransactionConfig();
        txnConfig.setDurability(READ_ONLY.getDurability());
        txnConfig.setConsistencyPolicy(policy);
        txnConfig.setReadUncommitted(true);

        Txn txn = null;
        try {
            txn = new ReadonlyTxn(rImpl, txnConfig);
            RepGroupImpl group = fetchGroup(groupName, dbImpl, txn);
            /* Correct summary info since we are reading uncommitted data */
            group.makeConsistent();
            txn.commit();
            txn = null;

            return group;
        } finally {
            if (txn != null) {
                txn.abort();
            }
        }
    }

    public RepGroupImpl getGroup(ReplicaConsistencyPolicy policy)
        throws DatabaseException {

        return getGroup(repImpl,
                        repImpl.getConfigManager().get(GROUP_NAME),
                        policy);
    }

    /**
     * All rep group db access uses cursors with eviction disabled.
     */
    static private Cursor makeCursor(DatabaseImpl dbImpl,
                                     Txn txn,
                                     CursorConfig cursorConfig) {
        Cursor cursor = DbInternal.makeCursor(dbImpl,
                                              txn,
                                              cursorConfig);
        DbInternal.getCursorImpl(cursor).setAllowEviction(false);
        return cursor;
    }

    /**
     * Returns a representation of the nodes of the group stored in the
     * database, using the txn and handles that were passed in.
     */
    private static RepGroupImpl fetchGroup(String groupName,
                                           DatabaseImpl dbImpl,
                                           Txn txn)
        throws DatabaseException {

        final DatabaseEntry keyEntry = new DatabaseEntry();
        final DatabaseEntry value = new DatabaseEntry();
        final NodeBinding miBinding = new NodeBinding();
        final GroupBinding groupBinding = new GroupBinding();

        RepGroupImpl group = null;
        Map <Integer, RepNodeImpl> nodes =
            new HashMap<Integer, RepNodeImpl>();
        final CursorConfig cursorConfig = new CursorConfig();
        cursorConfig.setReadCommitted(true);

        Cursor mcursor = null;

        try {
            mcursor = makeCursor(dbImpl, txn, cursorConfig);
            while (mcursor.getNext(keyEntry, value, LockMode.DEFAULT) ==
                   OperationStatus.SUCCESS) {

                final String key = StringBinding.entryToString(keyEntry);

                if (GROUP_KEY.equals(key)) {
                    group = groupBinding.entryToObject(value);
                    if (!group.getName().equals(groupName)) {
                        throw EnvironmentFailureException.unexpectedState
                            ("The argument: " + groupName +
                             " does not match the expected group name: " +
                             group.getName());
                    }
                } else {
                    final RepNodeImpl mi = miBinding.entryToObject(value);
                    nodes.put(mi.getNameIdPair().getId(), mi);
                }
            }
            if (group == null) {
                throw EnvironmentFailureException.unexpectedState
                    ("Group key: " + GROUP_KEY + " is missing");
            }
            group.setNodes(nodes);
            return group;
        } finally {
            if (mcursor != null) {
                mcursor.close();
            }
        }
    }

    /**
     * Ensures that information about this node, the current master is in the
     * member database. If it isn't, enter it into the database. If the
     * database does not exist, create it as well.
     *
     * Note that this overloading is only used by a node that is the master.
     *
     * @throws DatabaseException
     */
    public void addFirstNode()
        throws DatabaseException {

        DbConfigManager configManager = repImpl.getConfigManager();
        String groupName = configManager.get(GROUP_NAME);
        String nodeName = configManager.get(NODE_NAME);

        DatabaseImpl groupDbImpl = repImpl.createGroupDb();

        /* setup the group information as data. */
        GroupBinding groupBinding = new GroupBinding();
        RepGroupImpl repGroup =  new RepGroupImpl(groupName);
        DatabaseEntry groupEntry = new DatabaseEntry();
        groupBinding.objectToEntry(repGroup, groupEntry);

        /* Create the common group entry. */
        TransactionConfig txnConfig = new TransactionConfig();
        txnConfig.setDurability(NO_ACK.getDurability());
        txnConfig.setConsistencyPolicy(NO_CONSISTENCY);
        Txn txn = null;
        Cursor cursor = null;
        try {
            txn = new MasterTxn(repImpl,
                                txnConfig,
                                repImpl.getNameIdPair());

            cursor = makeCursor(groupDbImpl, txn, CursorConfig.DEFAULT);
            OperationStatus status = cursor.put(groupKeyEntry, groupEntry);
            if (status != OperationStatus.SUCCESS) {
                throw EnvironmentFailureException.unexpectedState
                    ("Couldn't write first group entry " + status);
            }
            cursor.close();
            cursor = null;
            txn.commit();
            txn = null;
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            if (txn != null) {
                txn.abort();
            }
        }

        ensureMember(new RepNodeImpl(nodeName,
                                     repImpl.getHostName(),
                                     repImpl.getPort()));
    }

    /**
     * Ensures that the membership info for the replica is in the database. A
     * call to this method is initiated by the master as part of the
     * feeder/replica handshake, where the replica provides membership
     * information as part of the handshake protocol. The membership database
     * must already exist, with the master in it, when this method is invoked.
     *
     * @param membershipInfo provided by the replica
     *
     * @throws InsufficientReplicasException upon failure of 2p member update
     * @throw  InsufficientAcksException upon failure of 2p member update
     * @throws DatabaseException when the membership info could not be entered
     * into the membership database.
     */
    public void ensureMember(Protocol.NodeGroupInfo membershipInfo)
        throws InsufficientReplicasException,
               InsufficientAcksException,
               DatabaseException {

        ensureMember(new RepNodeImpl(membershipInfo));
    }

    void ensureMember(RepNodeImpl ensureNode)
        throws DatabaseException {

        DatabaseImpl groupDbImpl;
        try {
            groupDbImpl = repImpl.getGroupDb();
        } catch (DatabaseNotFoundException e) {
            /* Should never happen. */
            throw EnvironmentFailureException.unexpectedException(e);
        }

        DatabaseEntry nodeNameKey = new DatabaseEntry();
        StringBinding.stringToEntry(ensureNode.getName(), nodeNameKey);

        DatabaseEntry value = new DatabaseEntry();
        final RepGroupDB.NodeBinding mib = new RepGroupDB.NodeBinding();

        Txn txn = null;
        Cursor cursor = null;
        try {
            txn = new ReadonlyTxn(repImpl, NO_ACK);
            CursorConfig config = new CursorConfig();
            config.setReadCommitted(true);
            cursor = makeCursor(groupDbImpl, txn, config);

            OperationStatus status =
                cursor.getSearchKey(nodeNameKey, value, null);
            if (status == OperationStatus.SUCCESS) {
                /* Let's see if the entry needs updating. */
                RepNodeImpl miInDb = mib.entryToObject(value);
                if (miInDb.equivalent(ensureNode)) {
                    if (miInDb.isQuorumAck()) {
                        /* Present, matched and acknowledged. */
                        return;
                    }
                    ensureNode.getNameIdPair().update(miInDb.getNameIdPair());
                    /* Not acknowledged, retry the update. */
                } else {
                    /* Present but not equivalent. */
                    LoggerUtils.warning(logger, repImpl,
                                        "Incompatible node descriptions. " +
                                        "Membership database definition: " +
                                        miInDb.toString() +
                                        " Transient definition: " +
                                        ensureNode.toString());
                    throw EnvironmentFailureException.unexpectedState
                        ("Incompatible node descriptions for node id: " +
                         ensureNode.getNodeId());
                }
                LoggerUtils.info(logger, repImpl,
                                 "Present but not ack'd node: " +
                                 ensureNode.getNodeId() +
                                 " ack status: " + miInDb.isQuorumAck());
            }
            cursor.close();
            cursor = null;
            txn.commit();
            txn = null;
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            if (txn != null) {
                txn.abort();
            }

        }
        twoPhaseMemberUpdate(ensureNode);

        /* Refresh group and Fire an ADD GroupChangeEvent. */
        refreshGroupAndNotifyGroupChange
            (ensureNode.getName(), GroupChangeType.ADD);
    }

    private void refreshGroupAndNotifyGroupChange(String nodeName,
                                                  GroupChangeType opType) {
        repImpl.getRepNode().refreshCachedGroup();
        repImpl.getRepNode().getMonitorEventManager().notifyGroupChange
            (nodeName, opType);
    }

    /**
     * Deletes a node from the replication group by marking it as such in the
     * rep group db.
     */
    public void removeMember(RepNodeImpl removeNode) {
        LoggerUtils.info
            (logger, repImpl, "Deleting node: " + removeNode.getName());

        TwoPhaseUpdate twoPhaseUpdate = new TwoPhaseUpdate(removeNode) {

            @Override
            void phase1Body() {
                RepGroupImpl repGroup = fetchGroupObject(txn, groupDbImpl);
                int changeVersion = repGroup.incrementChangeVersion();
                saveGroupObject(txn, repGroup, groupDbImpl);
                node.setChangeVersion(changeVersion);
                node.setRemoved(true);
                saveNodeObject(txn, node, groupDbImpl);
            }
        };

        twoPhaseUpdate.execute();

        /* Refresh group and fire a REMOVE GroupChangeEvent. */
        refreshGroupAndNotifyGroupChange
            (removeNode.getName(), GroupChangeType.REMOVE);

        LoggerUtils.info(logger, repImpl,
                         "Successfully deleted node: " + removeNode.getName());
    }

    /**
     * Implements the two phase update of membership information.
     *
     * In the first phase the master repeatedly tries to commit the "put"
     * operation until it gets a Quorum of acks, ensuring that the operation
     * has been made durable. Nodes that obtain this entry will start using it
     * in elections. However, the node itself will not participate in elections
     * until it has successfully completed phase 2.
     *
     * In the second phase, the entry for the member is updated the to note
     * that a quorum of acks was received.
     *
     * Failure leaves the database with the member info absent, or present but
     * with the update to quorumAcks indicating that a quorum has acknowledged
     * the change.
     *
     * @param node the member info for the node.
     *
     * @throws DatabaseException upon failure.
     */
    private void twoPhaseMemberUpdate(final RepNodeImpl node)
        throws InsufficientReplicasException,
               InsufficientAcksException,
               DatabaseException {

        LoggerUtils.fine
            (logger, repImpl, "Adding node: " + node.getNameIdPair());

        TwoPhaseUpdate twoPhaseUpdate = new TwoPhaseUpdate(node) {

            @Override
            void phase1Body() {
                RepGroupImpl repGroup = fetchGroupObject(txn, groupDbImpl);
                fetchGroup(repGroup.getName(), groupDbImpl, txn).
                    checkForConflicts(node);
                int changeVersion = repGroup.incrementChangeVersion();
                if (node.getNameIdPair().hasNullId()) {
                    node.getNameIdPair().setId(repGroup.getNextNodeId());
                }
                saveGroupObject(txn, repGroup, groupDbImpl);
                node.setChangeVersion(changeVersion);
                saveNodeObject(txn, node, groupDbImpl);
            }

            @Override
            void deadlockHandler() {
                node.getNameIdPair().revertToNull();
            }

            @Override
            void insufficientReplicasHandler() {
                node.getNameIdPair().revertToNull();
            }
        };

        twoPhaseUpdate.execute();

        LoggerUtils.info(logger, repImpl,
                         "Successfully added node: " + node.getNameIdPair() +
                         " HostPort=" + node.getHostName() + ":" +
                         node.getPort() + " [" + node.getType() + "]");
    }

    /**
     * Updates the database entry associated with the node with the new local
     * CBVLSN, if it can do so without encountering lock contention. If it
     * encounters contention, it returns false, and the caller must retry at
     * some later point in time.
     *
     * Note that changes to the local CBVLSN do not update the group version
     * number since they do not impact group membership.
     *
     * @param nameIdPair identifies the node being updated
     * @param newCBVLSN the new local CBVLSN to be associated with the node.
     * @return true if the update succeeded.
     * @throws DatabaseException
     */
    public boolean updateLocalCBVLSN(final NameIdPair nameIdPair,
                                     final VLSN newCBVLSN)
        throws DatabaseException {

        DatabaseImpl groupDbImpl = null;
        try {
            groupDbImpl = repImpl.probeGroupDb();
        } catch (DatabaseException e) {
            /* Contention on the groupDbImpl, try later. */
            return false;
        }

        if (groupDbImpl == null) {
            /* Contention on the groupDbImpl, try later. */
            return false;
        }

        DatabaseEntry nodeNameKey = new DatabaseEntry();
        StringBinding.stringToEntry(nameIdPair.getName(), nodeNameKey);
        DatabaseEntry value = new DatabaseEntry();
        final RepGroupDB.NodeBinding mib = new RepGroupDB.NodeBinding();
        final RepGroupImpl.BarrierState barrierState =
            new RepGroupImpl.BarrierState(newCBVLSN,
                                          System.currentTimeMillis());
        Txn txn = null;
        Cursor cursor = null;
        boolean ok = false;
        try {
            txn = new MasterTxn(repImpl,
                                NO_ACK_NO_SYNC,
                                repImpl.getNameIdPair());
            cursor = makeCursor(groupDbImpl, txn, CursorConfig.DEFAULT);

            OperationStatus status =
                    cursor.getSearchKey(nodeNameKey, value, LockMode.RMW);
            if (status != OperationStatus.SUCCESS) {
                throw EnvironmentFailureException.unexpectedState
                    ("Node id: " + nameIdPair + " not present in group db");
            }

            /* Let's see if the entry needs updating. */
            RepNodeImpl node = mib.entryToObject(value);
            final VLSN lastCBVLSN = node.getBarrierState().getLastCBVLSN();
            if (lastCBVLSN.equals(newCBVLSN)) {
                ok = true;
                return true;
            }

            node.setBarrierState(barrierState);
            mib.objectToEntry(node, value);
            status = cursor.putCurrent(value);
            if (status != OperationStatus.SUCCESS) {
                throw EnvironmentFailureException.unexpectedState
                    ("Node id: " + nameIdPair +
                     " stored localCBVLSN could not be updated. Status: " +
                     status);
            }
            LoggerUtils.fine(logger, repImpl,
                             "Local CBVLSN updated to " + newCBVLSN +
                             " for node " + nameIdPair);
            ok = true;
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            if (txn != null) {
                if (ok) {
                    txn.commit(NO_ACK_NO_SYNC_DURABILITY);
                } else {
                    txn.abort();
                }
                txn = null;
            }
            if (ok) {
                /* RepNode may be null during shutdown. [#17424] */
                RepNode repNode = repImpl.getRepNode();
                if (repNode != null) {
                    repNode.updateGroupInfo(nameIdPair, barrierState);
                }
            }
        }

        return true;
    }

    /*
     * Returns just the de-serialized special rep group object from the
     * database, while ensuring that it's locked for update.
     */
    private RepGroupImpl fetchGroupObject(Txn txn,
                                              DatabaseImpl groupDbImpl)
        throws DatabaseException {

        RepGroupDB.GroupBinding groupBinding = new RepGroupDB.GroupBinding();
        DatabaseEntry groupEntry = new DatabaseEntry();

        Cursor cursor = null;
        try {
            cursor = makeCursor(groupDbImpl, txn, CursorConfig.DEFAULT);

            OperationStatus status = cursor.getSearchKey(groupKeyEntry,
                                                         groupEntry,
                                                         LockMode.RMW);
            if (status != OperationStatus.SUCCESS) {
                throw EnvironmentFailureException.unexpectedState
                    ("Group entry key: " + GROUP_KEY +
                     " missing from group database");
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return groupBinding.entryToObject(groupEntry);
    }

    /*
     * Saves the rep group in the database.
     */
    private void saveGroupObject(Txn txn,
                                 RepGroupImpl repGroup,
                                 DatabaseImpl groupDbImpl)
        throws DatabaseException {

        RepGroupDB.GroupBinding groupBinding = new RepGroupDB.GroupBinding();
        DatabaseEntry groupEntry = new DatabaseEntry();
        groupBinding.objectToEntry(repGroup, groupEntry);

        Cursor cursor = null;
        try {
            cursor = makeCursor(groupDbImpl, txn, CursorConfig.DEFAULT);

            OperationStatus status =  cursor.put(groupKeyEntry, groupEntry);
            if (status != OperationStatus.SUCCESS) {
                throw EnvironmentFailureException.unexpectedState
                    ("Group entry save failed");
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /*
     * Save a ReplicationNode in the database.
     */
    private void saveNodeObject(Txn txn,
                                RepNodeImpl node,
                                DatabaseImpl groupDbImpl)
        throws DatabaseException {

        DatabaseEntry nodeNameKey = new DatabaseEntry();
        StringBinding.stringToEntry(node.getName(), nodeNameKey);

        final RepGroupDB.NodeBinding nodeBinding =
            new RepGroupDB.NodeBinding();
        DatabaseEntry memberInfoEntry = new DatabaseEntry();
        nodeBinding.objectToEntry(node, memberInfoEntry);

        Cursor cursor = null;
        try {
            cursor = makeCursor(groupDbImpl, txn, CursorConfig.DEFAULT);

            OperationStatus status =  cursor.put(nodeNameKey, memberInfoEntry);
            if (status != OperationStatus.SUCCESS) {
                throw EnvironmentFailureException.unexpectedState
                    ("Group entry save failed");
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static class GroupBinding extends TupleBinding<RepGroupImpl>  {

        @Override
        public RepGroupImpl entryToObject(TupleInput input) {
            return new RepGroupImpl(input.readString(),
                                          new UUID(input.readLong(),
                                                   input.readLong()),
                                          input.readInt(),
                                          input.readInt(),
                                          input.readInt(),
                                          null);
        }

        @Override
        public void objectToEntry(RepGroupImpl group, TupleOutput output) {
          output.writeString(group.getName());
          output.writeLong(group.getUUID().getMostSignificantBits());
          output.writeLong(group.getUUID().getLeastSignificantBits());
          output.writeInt(group.getVersion());
          output.writeInt(group.getChangeVersion());
          output.writeInt(group.getNodeIdSequence());
        }
    }

    /**
     * Supports the serialization/deserialization of node info into and out of
     * the database.
     */
    public static class NodeBinding extends TupleBinding<RepNodeImpl> {

        @Override
        public RepNodeImpl entryToObject(TupleInput input) {
            RepNodeImpl mi =
                new RepNodeImpl(NameIdPair.deserialize(input),
                                  NodeType.values()[input.readByte()],
                                  input.readBoolean(),
                                  input.readBoolean(),
                                  input.readString(),
                                  input.readInt(),
                                  new BarrierState(new VLSN(input.readLong()),
                                                  input.readLong()),
                                                  input.readInt());
            return mi;
        }

        @Override
        public void objectToEntry(RepNodeImpl mi, TupleOutput output) {
            final BarrierState syncState = mi.getBarrierState();
            mi.getNameIdPair().serialize(output);
            output.writeByte(mi.getType().ordinal());
            output.writeBoolean(mi.isQuorumAck());
            output.writeBoolean(mi.isRemoved());
            output.writeString(mi.getHostName());
            output.writeInt(mi.getPort());
            output.writeLong(syncState.getLastCBVLSN().getSequence());
            output.writeLong(syncState.getBarrierTime());
            output.writeInt(mi.getChangeVersion());
        }
    }

    /**
     * Implements two phase updates for membership changes to the group
     * database. It compartmentalizes the retry operations and exception
     * handling so that it's independent of the core logic.
     */
    private abstract class TwoPhaseUpdate {

        final RepNodeImpl node;
        final DatabaseImpl groupDbImpl;

        protected Txn txn;
        private DatabaseException phase1Exception = null;

        private TwoPhaseUpdate(RepNodeImpl node) {
            super();
            this.node = node;
            try {
                groupDbImpl = repImpl.getGroupDb();
            } catch (DatabaseNotFoundException e) {
                /* Should never happen. */
                throw EnvironmentFailureException.unexpectedException(e);
            }
        }

        /* Phase1 exception handlers for phase1Body-specific cleanup */
        void insufficientReplicasHandler() {}

        void deadlockHandler() {}

        /* The changes to be made in phase1 */
        abstract void phase1Body();

        /* The changes to be made in phase2. */
        void phase2Body() {
            node.setQuorumAck(true);
            saveNodeObject(txn, node, groupDbImpl);
        }

        private void phase1()
            throws DatabaseException {

            for (int i=0; i < QUORUM_ACK_RETRIES; i++ ) {
                txn = null;
                try {
                    txn = new MasterTxn(repImpl,
                                        QUORUM_ACK,
                                        repImpl.getNameIdPair());
                    phase1Body();
                    txn.commit(QUORUM_ACK_DURABILITY);
                    txn = null;
                    return;
                } catch (InsufficientReplicasException e) {
                    phase1Exception = e;
                    insufficientReplicasHandler();
                    /* Commit was aborted. */
                    LoggerUtils.warning(logger, repImpl,
                                        "Phase 1 retry; for node: " +
                                        node.getName() +
                                        " insufficient active replicas: " +
                                        e.getMessage());
                    continue;
                } catch (InsufficientAcksException e) {
                    phase1Exception = e;
                    /* Local commit completed but did not get enough acks. */
                    LoggerUtils.warning(logger, repImpl,
                                        "Phase 1 retry; for node: " +
                                        node.getName() +
                                        " insufficient acks: " +
                                        e.getMessage());
                    continue;
                } catch (LockConflictException e) {
                    /* Likely a timeout, can't distinguish between them. */
                    phase1Exception = e;
                    deadlockHandler();
                    LoggerUtils.warning(logger, repImpl,
                                        "Phase 1 retry; for node: " +
                                        node.getName() +
                                        " deadlock exception: " +
                                        e.getMessage());
                    continue;
                } catch (DatabaseException e) {
                    LoggerUtils.severe(logger, repImpl,
                                       "Phase 1 failed unexpectedly: " +
                                       e.getMessage());
                    if (txn != null) {
                        txn.abort();
                    }
                    throw e;
                } finally {
                    if (txn != null) {
                        txn.abort();
                    }
                }
            }
            LoggerUtils.warning(logger,
                                repImpl,
                                "Phase 1 failed: " +
                                phase1Exception.getMessage());
            throw phase1Exception;
        }

        private void phase2() {
            try {
                txn = new MasterTxn(repImpl, NO_ACK, repImpl.getNameIdPair());
                phase2Body();
                txn.commit();
                txn = null;
            } catch (DatabaseException e) {
                LoggerUtils.severe(logger, repImpl,
                                   "Unexpected failure in Phase 2: " +
                                   e.getMessage());
                throw e;
            } finally {
                if (txn != null) {
                    txn.abort();
                }
            }
        }

        void execute() {
            phase1();
            /* Only executed if phase 1 succeeds. */
            phase2();
        }
    }

    /**
     * An internal API used to obtain group information by opening a stand
     * alone environment handle and reading the RepGroupDB. Used for debugging
     * and utilities.
     *
     * @param envDir the directory containing the environment log files
     *
     * @return the group as currently defined by the environment
     */
    public static RepGroupImpl getGroup(final File envDir) {

        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setReadOnly(true);
        envConfig.setTransactional(true);
        envConfig.setAllowCreate(false);
        Environment env = new Environment(envDir, envConfig);
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setReadOnly(true);
        dbConfig.setTransactional(true);
        dbConfig.setAllowCreate(false);
        Transaction txn = env.beginTransaction(null, null);
        Database db = env.openDatabase(txn, DbTree.REP_GROUP_DB_NAME, dbConfig);

        DatabaseEntry groupEntry = new DatabaseEntry();
        OperationStatus status =
            db.get(txn, groupKeyEntry, groupEntry, LockMode.READ_COMMITTED);
        if (status != OperationStatus.SUCCESS) {
            throw new IllegalStateException
                ("Group entry not found " + status);
        }
        GroupBinding groupBinding = new GroupBinding();
        RepGroupImpl group = groupBinding.entryToObject(groupEntry);

        group = fetchGroup(group.getName(), DbInternal.getDatabaseImpl(db),
                   DbInternal.getTxn(txn));
        txn.commit();
        db.close();
        env.close();
        return group;
    }
}
