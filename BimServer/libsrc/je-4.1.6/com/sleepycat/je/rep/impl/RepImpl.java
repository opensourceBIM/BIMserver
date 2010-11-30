/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl;

import static com.sleepycat.je.rep.NoConsistencyRequiredPolicy.NO_CONSISTENCY;
import static com.sleepycat.je.rep.impl.RepParams.NODE_NAME;
import static com.sleepycat.je.rep.impl.RepParams.VLSN_MAX_DIST;
import static com.sleepycat.je.rep.impl.RepParams.VLSN_MAX_MAP;
import static com.sleepycat.je.rep.impl.RepParams.VLSN_STRIDE;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Formatter;
import java.util.logging.Level;

import com.sleepycat.je.CheckpointConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DatabaseNotFoundException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Durability;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.EnvironmentNotFoundException;
import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.Durability.ReplicaAckPolicy;
import com.sleepycat.je.Durability.SyncPolicy;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.RepConfigProxy;
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogItem;
import com.sleepycat.je.recovery.RecoveryInfo;
import com.sleepycat.je.recovery.VLSNRecoveryProxy;
import com.sleepycat.je.rep.DatabasePreemptedException;
import com.sleepycat.je.rep.InsufficientAcksException;
import com.sleepycat.je.rep.InsufficientReplicasException;
import com.sleepycat.je.rep.LockPreemptedException;
import com.sleepycat.je.rep.LogOverwriteException;
import com.sleepycat.je.rep.QuorumPolicy;
import com.sleepycat.je.rep.RepInternal;
import com.sleepycat.je.rep.ReplicaConsistencyException;
import com.sleepycat.je.rep.ReplicaWriteException;
import com.sleepycat.je.rep.ReplicatedEnvironment;
import com.sleepycat.je.rep.ReplicatedEnvironmentStats;
import com.sleepycat.je.rep.ReplicationConfig;
import com.sleepycat.je.rep.ReplicationMutableConfig;
import com.sleepycat.je.rep.RestartRequiredException;
import com.sleepycat.je.rep.RollbackException;
import com.sleepycat.je.rep.StateChangeEvent;
import com.sleepycat.je.rep.StateChangeListener;
import com.sleepycat.je.rep.UnknownMasterException;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.impl.node.NodeState;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.impl.node.Replay;
import com.sleepycat.je.rep.stream.FeederTxns;
import com.sleepycat.je.rep.txn.MasterThreadLocker;
import com.sleepycat.je.rep.txn.MasterTxn;
import com.sleepycat.je.rep.txn.ReadonlyTxn;
import com.sleepycat.je.rep.txn.ReplayTxn;
import com.sleepycat.je.rep.txn.ReplicaThreadLocker;
import com.sleepycat.je.rep.utilint.HostPortPair;
import com.sleepycat.je.rep.utilint.RepUtils;
import com.sleepycat.je.rep.utilint.ReplicationFormatter;
import com.sleepycat.je.rep.vlsn.VLSNIndex;
import com.sleepycat.je.rep.vlsn.VLSNRecoveryTracker;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.ThreadLocker;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.util.DbBackup;
import com.sleepycat.je.utilint.BooleanStat;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.StringStat;
import com.sleepycat.je.utilint.VLSN;

public class RepImpl
    extends EnvironmentImpl
    implements RepEnvConfigObserver {

    private VLSNIndex vlsnIndex;
    private final FeederTxns feederTxns;

    /*
     * The repNode is only non-null when the replicated environment has joined
     * a group. It's null otherwise.
     */
    private volatile RepNode repNode;
    private Replay replay;

    /*
     * This is the canonical nameIdPair instance used by the node. The internal
     * Id part of the pair will be updated when the node actually joins the
     * group.
     */
    private NameIdPair nameIdPair;

    private final NodeState nodeState;

    /*
     * The clockskew used by this environment in ms. It's only used by testing
     * to inject clock skew between ReplicatedEnvironments.
     */
    private static int clockSkewMs = 0;

    /*
     * A handle to the group database. This handle is initialized lazily when
     * the contents of the database are first required. It's set to null upon
     * shutdown. The handle must be initialized lazily because the database is
     * created by the master, and we only know master identity later.  The
     * RepImpl manages the rep group database, so that the lifetime of the
     * databaseImpl handle can be managed more easily to mesh with the opening
     * and closing of the RepImpl.
     */
    private DatabaseImpl groupDbImpl = null;

    /* The status presents whether this replica is doing rollback. */
    private boolean backupProhibited = false;

    /*
     * Represents whether this Environment is allowed to convert a
     * non-replicated Environment to replicated.
     */
    private boolean allowConvert = false;

    /* Keep an eye on the ongoing DbBackups. */
    private final Set<DbBackup> backups = new HashSet<DbBackup>();

    /*
     * The list of observers who are notified when a mutable rep param changes.
     */
    private final List<RepEnvConfigObserver> repConfigObservers;

    /*
     * Lock used to control access and lazy initialization of groupDbImpl,
     * ensuring that there is exactly one database made. A mutex is used rather
     * than synchronization to allow us to probe for contention on the
     * groupDbImpl.
     */
    private final ReentrantLock groupDbLock = new ReentrantLock();

    private final int replicaAckTimeout;
    private final int insufficientReplicasTimeout;
    private final int replayTxnTimeout;
    private final ReplicaConsistencyPolicy defaultConsistencyPolicy;

    /* 
     * NodeStats are currently not public, but we may want to evaluate
     * and decide if they would be useful, perhaps as a debugging aid.
     */
    private final StatGroup nodeStats;
    private final BooleanStat hardRecoveryStat;
    private final StringStat hardRecoveryInfoStat;

    public RepImpl(File envHome,
                   EnvironmentConfig envConfig,
                   EnvironmentImpl sharedCacheEnv,
                   RepConfigProxy repConfigProxy)
        throws EnvironmentNotFoundException, EnvironmentLockedException {

        super(envHome, envConfig, sharedCacheEnv, repConfigProxy);

        allowConvert =
            RepInternal.getAllowConvert(((ReplicationConfig) repConfigProxy));
        feederTxns = new FeederTxns(this);
        replay = new Replay(this, nameIdPair);
        nodeState = new NodeState(nameIdPair, this);
        repConfigObservers = new ArrayList<RepEnvConfigObserver>();
        replicaAckTimeout =
            configManager.getDuration(RepParams.REPLICA_ACK_TIMEOUT);
        insufficientReplicasTimeout =
            configManager.getDuration(RepParams.INSUFFICIENT_REPLICAS_TIMEOUT);
        replayTxnTimeout =
            configManager.getDuration(RepParams.REPLAY_TXN_LOCK_TIMEOUT);
        defaultConsistencyPolicy = RepUtils.getReplicaConsistencyPolicy
            (configManager.get(RepParams.CONSISTENCY_POLICY));
        addRepConfigObserver(this);

        nodeStats = new StatGroup(RepImplStatDefinition.GROUP_NAME,
                                  RepImplStatDefinition.GROUP_DESC);
        hardRecoveryStat = new BooleanStat(nodeStats,
                                           RepImplStatDefinition.HARD_RECOVERY);
        hardRecoveryInfoStat = 
            new StringStat(nodeStats, RepImplStatDefinition.HARD_RECOVERY_INFO,
                           "This node did not incur a hard recovery.");
    }

    @Override
    protected Formatter initFormatter() {

        /*
         * The nameIdPair field is assigned here rather than in the constructor
         * because of base class/subclass dependencies. initFormatter() is
         * called by the base class constructor, and nameIdPair must be
         * available at that time.
         */
        nameIdPair = new NameIdPair(configManager.get(NODE_NAME));
        return new ReplicationFormatter(nameIdPair);
    }

    @Override
    public String getMonitorClassName() {
        return "com.sleepycat.je.rep.jmx.RepJEMonitor";
    }

    @Override
    public String getDiagnosticsClassName() {
        return "com.sleepycat.je.rep.jmx.RepJEDiagnostics";
    }

    /**
     * @see super#initConfigManager
     */
    @Override
    protected DbConfigManager
        initConfigManager(EnvironmentConfig envConfig,
                          RepConfigProxy repConfigProxy) {
        return new RepConfigManager(envConfig, repConfigProxy);
    }

    @Override
    public boolean getAllowConvert() {
        return allowConvert;
    }

    /**
     * @see super#resetConfigManager
     */
    @Override
    protected DbConfigManager resetConfigManager(EnvironmentConfig newConfig) {
        /* Save all the replication related properties. */
        RepConfigManager repConfigManager = (RepConfigManager) configManager;
        ReplicationConfig repConfig = repConfigManager.makeReplicationConfig();
        return new RepConfigManager(newConfig, repConfig);
    }

    public ReplicationConfig cloneRepConfig() {
        RepConfigManager repConfigManager = (RepConfigManager) configManager;
        return repConfigManager.makeReplicationConfig();
    }

    /* Make an ReplicatedEnvironment handle for this RepImpl. */
    public ReplicatedEnvironment makeEnvironment() {
        return new ReplicatedEnvironment(getEnvironmentHome(),
                                         cloneRepConfig(),
                                         cloneConfig());
    }

    public ReplicationMutableConfig cloneRepMutableConfig() {
        RepConfigManager repConfigManager = (RepConfigManager) configManager;
        return repConfigManager.makeReplicationConfig();
    }

    public void setRepMutableConfig(ReplicationMutableConfig config)
        throws DatabaseException {

        /* Clone the current config. */
        RepConfigManager repConfigManager = (RepConfigManager) configManager;
        ReplicationConfig newConfig = repConfigManager.makeReplicationConfig();

        /* Copy in the mutable props. */
        config.copyMutablePropsTo(newConfig);
        repConfigManager = new RepConfigManager
            (configManager.getEnvironmentConfig(), newConfig);

        /*
         * Update the current config and notify observers.  The config manager
         * is replaced with a new instance that uses the new configuration.
         * This avoids synchronization issues: other threads that have a
         * reference to the old configuration object are not impacted.
         *
         * Notify listeners in reverse order of registration so that the
         * environment listener is notified last and can start daemon threads
         * after they are configured.
         */
        for (int i = repConfigObservers.size() - 1; i >= 0; i -= 1) {
            RepEnvConfigObserver o = repConfigObservers.get(i);
            o.repEnvConfigUpdate(repConfigManager, newConfig);
        }
    }

    public void repEnvConfigUpdate(@SuppressWarnings("unused")
                                   RepConfigManager configMgr,
                                   ReplicationMutableConfig newConfig)
        throws DatabaseException {

        if (!newConfig.getDesignatedPrimary()) {
            repNode.passivatePrimary();
        }
        repNode.setElectableGroupSizeOverride
            (newConfig.getElectableGroupSizeOverride());
        repNode.configLogFlusher(configMgr);
    }

    public synchronized void addRepConfigObserver(RepEnvConfigObserver o) {
        repConfigObservers.add(o);
    }

    /**
     * The VLSNIndex must be created, merged and flushed before the recovery
     * checkpoint. This method should be called even if there is no recovery
     * checkpoint, because it sets up needed data structures.
     *
     * On the face of it, it seems that one could flush the VLSNIndex cache
     * after the recovery checkpoint, before the Replicator constructor returns
     * and before any user level HA operations can start. That's not sufficient
     * because the recovery checkpoint is shortening the recovery interval for
     * future recoveries, and any information that has been garnered must be
     * persisted. Here's an example of what might happen after a series of
     * recoveries if we fail to flush VLSNIndex as part of the recovery
     * checkpoint:
     *
     * Environment recovers for first time, brand new environment
     *    recovery did not find any VLSNs in log, because log is brand new
     *    recovery logs ckpt 1start
     *    recovery logs ckpt 1 end
     *
     *    VLSN 1 logged
     *    VLSN 2 logged
     *    VLSN 3 logged
     *
     *  crash .... Environment recovers
     *  recovery crawls log from ckpt 1 start onward, finds VLSNs 1-3
     *  recovery logs ckpt 2 start
     *  recovery logs ckpt 2 end
     *  VLSN index instantiated, VLSNs 1-3 added in but not written too disk
     *
     *  crash ... Environment recovers
     *  recovery crawls log from ckpt start 2 start onward, finds no VLSNs.
     *
     * Instead, the flushed VLSN has to be logged before the checkpoint end
     * record that is used for the next recovery.
     */
    @Override
    public void preRecoveryCheckpointInit(RecoveryInfo recoveryInfo) {

        int stride = configManager.getInt(VLSN_STRIDE);
        int maxMappings = configManager.getInt(VLSN_MAX_MAP);
        int maxDist = configManager.getInt(VLSN_MAX_DIST);

        /*
         * Our local nameIdPair field isn't set yet because we haven't finished
         * our initialization, so get it from the config manager.
         */
        NameIdPair useNameIdPair =
            new NameIdPair(configManager.get(NODE_NAME));

        vlsnIndex = new VLSNIndex(this, DbTree.VLSN_MAP_DB_NAME, useNameIdPair,
                                  stride, maxMappings, maxDist, recoveryInfo);
        replay.preRecoveryCheckpointInit(recoveryInfo);
    }

    /**
     * Returns the current state associated with this ReplicatedEnvironment
     *
     * @return the externally visible ReplicatedEnvironment state
     */
    public ReplicatedEnvironment.State getState() {
        return nodeState.getRepEnvState();
    }

    /**
     * Returns the state change event that transitioned the
     * ReplicatedEnviroment to its current state.
     */
    public StateChangeEvent getStateChangeEvent() {
        return nodeState.getStateChangeEvent();
    }

    /**
     * Wait for this node to join a replication group and return whether it is
     * a MASTER or REPLICA. Note that any method that creates or clears the
     * repNode field must be synchronized.
     */
    public synchronized ReplicatedEnvironment.State
        joinGroup(ReplicaConsistencyPolicy consistency,
                  QuorumPolicy initialElectionPolicy)
        throws ReplicaConsistencyException, DatabaseException {

        try {
            if (repNode == null) {
                repNode = new RepNode(this, replay, nodeState);
            }
            return repNode.joinGroup(consistency, initialElectionPolicy);
        }  catch (IOException ioe) {
            throw EnvironmentFailureException.unexpectedException
                (this, "Problem attempting to join on " + getSocket(), ioe);
        }
    }

    /**
     * @see EnvironmentImpl#setupClose
     * Release all replication resources that can be released before the
     * checkpoint. Note that any method that creates or clears the repNode
     * field must be called from a synchronized caller.
     *
     * Note that the vlsnIndex is closed as a callback, from
     * postCheckpointPreEnvClose()
     * @throws DatabaseException
     *
     */
    @Override
    protected synchronized void setupClose(PrintWriter errors)
        throws DatabaseException {

        if (groupDbImpl != null) {
            getDbTree().releaseDb(groupDbImpl);
            groupDbImpl = null;
            LoggerUtils.fine
                (envLogger, this, "Group member database shutdown");
        }

        try {
            if (repNode != null) {
                repNode.shutdown();
                repNode = null;
            }
        } catch (InterruptedException e) {
            errors.append("\nException shutting down node " +  nameIdPair);
            e.printStackTrace(errors);
            errors.println();
        }
    }

    /**
     * Close any resources that need to be closed after the closing checkpoint.
     * Note that since Replay.close closes open transactions, it must be
     * invoked after the checkpoint has been completed, so that the checkpoint
     * operation can correctly account for the open transactions.
     */
    @Override
    protected synchronized void postCheckpointClose(boolean checkpointed)
        throws DatabaseException {

        if (replay != null) {
            replay.close();
            replay = null;
        }

        if (vlsnIndex != null) {
            vlsnIndex.close(checkpointed);
            vlsnIndex = null;
        }
    }

    /**
     * @see EnvironmentImpl#setupClose
     *
     * Note: this conversion process will iterator over all user created
     * databases in the environment, which could be potentially be a costly
     * affair. However, let's opt for simplicity and defer any optimizations
     * until we see whether this is an important use case.
     */
    @Override
    protected void postRecoveryConversion()
        throws DatabaseException {

        if (needConvert) {
            /* Set NameDb to replicated. */
            DatabaseImpl nameDb = null;
            try {
                nameDb = dbMapTree.getDb(DbTree.NAME_DB_ID);
                if (!nameDb.isReplicated()) {
                    nameDb.setIsReplicatedBit();
                    nameDb.setDirtyUtilization();
                }
            } finally {
                if (nameDb != null) {
                    dbMapTree.releaseDb(nameDb);
                }
            }

            /* Set user defined databases to replicated. */
            Map<DatabaseId, String> idNameMap = dbMapTree.getDbNamesAndIds();
            for (DatabaseId id : idNameMap.keySet()) {
                DatabaseImpl db = null;
                try {
                    db = dbMapTree.getDb(id);
                    if (db != null &&
                        !DbTree.isReservedDbName(idNameMap.get(id))) {

                        db.setIsReplicatedBit();
                        db.setDirtyUtilization();
                    }
                } finally {
                    if (db != null) {
                        dbMapTree.releaseDb(db);
                    }
                }
            }

            /*
             * Do a checkpointer to flush dirty datbaseImpls that are converted
             * to replicated and write the current VLSNRange to the log.
             */
            CheckpointConfig ckptConfig = new CheckpointConfig();
            ckptConfig.setForce(true);
            invokeCheckpoint(ckptConfig, true, "Environment conversion");
        }
    }

    /*
     * Close enough resources to support reopening the environment in the same
     * JVM.
     * @see EnvironmentImpl#doCloseAfterInvalid()
     */
    @Override
    public synchronized void doCloseAfterInvalid() {

        try {
            /* Release the repNode, in order to release sockets. */
            if (repNode != null) {
                repNode.shutdown();
                repNode = null;
            }
        } catch (Exception ignore) {
        }

        super.doCloseAfterInvalid();
    }

    /**
     * Used by error handling to forcibly close an environment, and by tests to
     * close an environment to simulate a crash.  Database handles do not have
     * to be closed before calling this method.  A checkpoint is not performed.
     * The various thread pools will be shutdown abruptly.
     *
     * @throws DatabaseException
     */
    @Override
    public void abnormalClose()
        throws DatabaseException {

        /*
         * Shutdown the daemons, and the checkpointer in particular, before
         * nulling out the vlsnIndex.
         */
        shutdownDaemons();

        try {
            if (repNode != null) {

                /* 
                 * Don't fire a LeaveGroupEvent if it's an abnormal close, 
                 * otherwise an EnvironmentFailureException would be thrown 
                 * because daemons of this Environment have been shutdown. 
                 */
                repNode.getMonitorEventManager().disableLeaveGroupEvent();
                repNode.shutdown();
                repNode = null;
            }
        } catch (InterruptedException ignore) {
            /* ignore */
        }

        try {
            if (vlsnIndex != null) {
                vlsnIndex.abnormalClose();
                vlsnIndex = null;
            }
        } catch (DatabaseException ignore) {
            /* ignore */
        }

        try {
            super.abnormalClose();
        } catch (DatabaseException ignore) {
            /* ignore */
        }
    }

    /**
     * A replicated log entry has been written on this node. Update the
     * VLSN->LSN mapping. Called outside the log write latch.
     * @throws DatabaseException
     */
    @Override
    public void registerVLSN(LogItem logItem) {
        LogEntryHeader header = logItem.getHeader();
        VLSN vlsn = header.getVLSN();

        if (LogEntryType.LOG_TXN_COMMIT.getTypeNum() ==
            header.getType()) {
            /* Track commit VLSNs */
            repNode.currentCommitVLSN(vlsn);
        }

        /*
         * Although the very first replicated entry of the system is never a
         * syncable log entry type, the first GlobalCBVLSN of the system must
         * start at 1. If we only track the first syncable entry, the
         * GlobalCBVLSN will start a a value > 1, and replicas that are
         * starting up from VLSN 1 will be caught in spurious network restores
         * because VLSN 1 < the GlobalCBVLSN. Therefore treat the VLSN 1 as a
         * syncable entry for the sake of the GlobalCBVLSN.
         */
        if (LogEntryType.isSyncPoint(header.getType()) ||
            VLSN.FIRST_VLSN.equals(vlsn)) {
            repNode.trackSyncableVLSN(vlsn, logItem.getNewLsn());
        }
        vlsnIndex.put(logItem);
    }

    /**
     * Generate the next VLSN.
     */
    @Override
    public VLSN bumpVLSN() {
        return vlsnIndex.bump();
    }

    /**
     * If the log entry wasn't successfully logged, decrement the VLSN to
     * reclaim the slot.
     */
    @Override
    public void decrementVLSN() {
        vlsnIndex.decrement();
    }

    /**
     * Flush any information that needs to go out at checkpoint.  Specifically,
     * write any in-memory VLSN->LSN mappings to the VLSNIndex database so we
     * are guaranteed that the VLSNIndex database will recover properly.
     */
    @Override
    public void preCheckpointEndFlush()
        throws DatabaseException {

        if (vlsnIndex != null) {
            vlsnIndex.flushToDatabase();
        }
    }

    @Override
    public boolean isMaster() {

        /*
         * The volatile repNode field might be modified by joinGroup(),
         * leaveGroup, or close(), which are synchronized. Keep this method
         * unsynchronized, assign to a temporary field to guard against a
         * change.
         */
        RepNode useNode = repNode;
        if (useNode == null) {
            return false;
        }
        return useNode.isMaster();
    }

    public void setChangeListener(StateChangeListener listener) {
        StateChangeListener prevListener = nodeState.getChangeListener();
        nodeState.setChangeListener(listener);

        /*
         * Call back so that it's aware of the last state change event and
         * the application can initialize itself correctly as a master or
         * replica.
         */
        final StateChangeEvent stateChangeEvent =
            nodeState.getStateChangeEvent();
        try {
            /* Invoke application code and handle any app exceptions. */
            listener.stateChange(stateChangeEvent);
        } catch (Exception e) {
            /* Revert the change. */
            nodeState.setChangeListener(prevListener);
            LoggerUtils.severe
                (envLogger, this,
                 "State Change listener exception: " + e.getMessage());
            /* An application error. */
            throw new EnvironmentFailureException
                (this, EnvironmentFailureReason.LISTENER_EXCEPTION, e);
        }
    }

    public StateChangeListener getChangeListener() {
        return nodeState.getChangeListener();
    }

    public VLSNIndex getVLSNIndex() {
        return vlsnIndex;
    }

    public FeederTxns getFeederTxns() {
        return feederTxns;
    }

    public ReplicatedEnvironmentStats getStats(StatsConfig config) {
        return repNode.getStats(config);
    }

    public Replay getReplay() {
        return replay;
    }

    /**
     * Ensures that the environment is currently a Master before proceeding
     * with an operation that requires it to be the master.
     *
     * @throws UnknownMasterException if the node is disconnected
     * @throws ReplicaWriteException if the node is currently a replica
     */
    private void checkIfMaster(Locker locker)
        throws UnknownMasterException, ReplicaWriteException {

        final StateChangeEvent event = nodeState.getStateChangeEvent();

        switch (nodeState.getRepEnvState()) {
            case MASTER:
                break;

            case REPLICA:
                throw new ReplicaWriteException(locker, event);

            case UNKNOWN:
                throw new UnknownMasterException(locker, event);

            case DETACHED:
                throw new UnknownMasterException(locker, event);

            default:
                throw EnvironmentFailureException.unexpectedState
                    ("Unexpected state: " + nodeState.getRepEnvState());
        }
    }

    /**
     * @return the repNode. May return null.
     */
    public RepNode getRepNode() {
        return repNode;
    }

    /**
     * Create an appropriate type of ThreadLocker. Specifically, it creates an
     * MasterThreadLocker if the node is currently a Master, and a
     * ReplicaThreadLocker otherwise, that is, if the node is a Replica, or
     * it's currently in a DETACHED state.
     *
     * @return an instance of MasterThreadLocker or ReplicaThreadLocker
     */
    @Override
    public ThreadLocker createRepThreadLocker() {
        return (isMaster() ?
                new MasterThreadLocker(this) :
                new ReplicaThreadLocker(this));
    }

    /**
     * Create an appropriate type of Replicated transaction. Specifically,
     * it creates a MasterTxn, if the node is currently a Master, a ReadonlyTxn
     * otherwise, that is, if the node is a Replica, or it's currently in a
     * DETACHED state.
     *
     * Note that a ReplicaTxn, used for transaction replay on a Replica is not
     * created on this path. It's created explicitly in the Replay loop by a
     * Replica.
     *
     * @param config  the transaction configuration
     *
     * @return an instance of MasterTxn or ReadonlyTxn
     * @throws DatabaseException
     */
    @Override
    public Txn createRepUserTxn(TransactionConfig config)
        throws DatabaseException {

        return (isMaster() ?
                MasterTxn.create(this, config, nameIdPair) :
                new ReadonlyTxn(this, config));
    }

    /**
     * Ensure that a  sufficient number of feeders are available before
     * proceeding with a master transaction begin.
     *
     * @param txn the master transaction being initiated.
     *
     * @throws InterruptedException
     * @throws DatabaseException if there were insufficient Replicas after the
     * timeout period.
     */
    public void txnBeginHook(MasterTxn txn)
        throws InterruptedException,
               DatabaseException {

        checkIfInvalid();
        ReplicaAckPolicy ackPolicy =
            txn.getDefaultDurability().getReplicaAck();
        int requiredNodeCount =
            repNode.minAckNodes(txn.getDefaultDurability());
        /*
         * TODO: Read only transactions on the master should not have to wait.
         * In the future, introduce either a read-only attribute as part of
         * TransactionConfig or a read only transaction class to optimize this.
         */
        repNode.feederManager().
            ensureReplicasForCommit(txn, ackPolicy, requiredNodeCount,
                                    insufficientReplicasTimeout);
    }

    /**
     * This hook is used primarily to perform the final checks before allowing
     * the commit operation to proceed. The following checks are performed
     * here:
     *
     * 1) Check for master
     * 2) Check for sufficient Feeder connections to ensure that the commit
     *    policy could be implemented. There is no guarantee that they will all
     *    ack the commit request.
     *
     * The method also associates a latch with the transaction. The latch is
     * used to delay the commit operation until a sufficient number of commits
     * have been received.
     *
     * @param txn the master transaction being committed
     *
     * @throws InsufficientReplicasException if the feeder is not in contact
     * with enough replicas.
     * @throws RestartRequiredException if the environment is invalid.
     * @throws UnknownMasterException if the current master is unknown.
     * @throws ReplicaWriteException if the node transitioned to a Replica
     * after the transaction was initiated.
     */
    public void preLogCommitHook(MasterTxn txn)
        throws InsufficientReplicasException,
               RestartRequiredException,
               UnknownMasterException,
               ReplicaWriteException,
               EnvironmentFailureException {

        checkIfInvalid();
        checkIfMaster(txn);

        /* Still a master, check for a sufficient number of connections */
        int activeReplicaCount =
            repNode.feederManager().activeReplicaCount();
        ReplicaAckPolicy ackPolicy =
            txn.getCommitDurability().getReplicaAck();
        int requiredAckCount = txn.getRequiredAckCount();
        if (envLogger.isLoggable(Level.FINE)) {
            LoggerUtils.fine(envLogger, this,
                             "Txn " + txn.getId() + " requires: " +
                             requiredAckCount + " active: " +
                             activeReplicaCount +
                             " replica acks. Commit Policy: " + ackPolicy);
        }
        if (requiredAckCount > activeReplicaCount) {
            /* Check for possible activation of Primary */
            if (repNode.tryActivatePrimary()) {
                txn.resetRequiredAckCount();
            } else {
                InsufficientReplicasException ire =
                    new InsufficientReplicasException
                        (txn, ackPolicy, requiredAckCount,
                         repNode.feederManager().activeReplicas());
                LoggerUtils.info(envLogger, this, ire.getMessage());
                throw ire;
            }
        }
        feederTxns.setupForAcks(txn);
    }

    /**
     * It ensures that the feeder obtains the requisite number of
     * acknowledgments required for a successful commit.
     *
     * @param txn The MasterTxn that was committed locally.
     *
     * @throws InterruptedException if the thread was interrupted while
     * waiting for acknowledgments.
     * @throws InsufficientAcksException if the master received an insufficient
     * number of commit acknowledgments within the replica commit timeout
     * period.
     * @throws EnvironmentFailureException
     */
    public void postLogCommitHook(MasterTxn txn)
       throws InsufficientAcksException,
              InterruptedException,
              EnvironmentFailureException {

        checkIfInvalid();
        /* Don't do master check, the transaction has already been committed */
        try {
            feederTxns.awaitReplicaAcks(txn, replicaAckTimeout);
        } catch (InsufficientAcksException e)  {
            LoggerUtils.info(envLogger, this, e.getMessage());
            throw e;
        }
    }

    /**
     * Removes any pending acknowledgments that were registered by the
     * preLogCommitHook.
     */
    public void postLogAbortHook(MasterTxn txn) {
        LoggerUtils.info(envLogger, this,
                         "post log abort hook for txn: " + txn.getId());
        feederTxns.clearTransactionAcks(txn);
    }

    /**
     * Create a ReplayTxn for recovery processing.
     */
    @Override
    public Txn createReplayTxn(long txnId)
        throws DatabaseException {

        return
            new ReplayTxn(this, TransactionConfig.DEFAULT, txnId, envLogger);
    }

    /**
     * Used by environment recovery to get a tracker to collect VLSN-LSN
     * mappings that are within the recovery part of the log. These might
     * not be reflected in the persistent mapping db.
     */
    @Override
    public VLSNRecoveryProxy getVLSNProxy() {
        int stride = configManager.getInt(RepParams.VLSN_STRIDE);
        int maxMappings = configManager.getInt(RepParams.VLSN_MAX_MAP);
        int maxDist = configManager.getInt(RepParams.VLSN_MAX_DIST);

        return new VLSNRecoveryTracker(this, stride, maxMappings, maxDist);
    }

    public UUID getUUID() {
        return repNode.getUUID();
    }

    /**
     * Used during testing to introduce artificial clock skews.
     */
    public static void setSkewMs(int skewMs) {
        clockSkewMs = skewMs;
    }

    public static int getClockSkewMs() {
        return clockSkewMs;
    }

    /**
     * Delete from the first VLSN in the range to lastVLSN, inclusive.
     * @param lastVLSN was cleaned by the cleaner
     * @param deleteFileNum was the file that was deleted by the cleaner.
     */
    @Override
    public void vlsnHeadTruncate(VLSN lastVLSN, long deleteFileNum) {

        vlsnIndex.truncateFromHead(lastVLSN, deleteFileNum);
    }

    public int getNodeId() {
        return nameIdPair.getId();
    }

    public NameIdPair getNameIdPair() {
        return nameIdPair;
    }

    @Override
    public long getReplayTxnTimeout() {
        return replayTxnTimeout;
    }

    public ReplicaConsistencyPolicy getDefaultConsistencyPolicy() {
        return defaultConsistencyPolicy;
    }

    /**
     * @see EnvironmentImpl#getName
     */
    @Override
    public String getName() {
        return nameIdPair + ":" + super.getName();
    }

    /**
     * Return true if this environment is part of a replication group.
     */
    @Override
    public boolean isReplicated() {
        return true;
    }

    /**
     * Check whether this environment can be opened on an existing environment
     * directory.
     */
    @Override
    public void checkRulesForExistingEnv(boolean dbTreeReplicatedBit)
        throws UnsupportedOperationException {

        if (!dbTreeReplicatedBit) {
            /*
             * We are attempting to open an existing, non-replicated
             * environment.
             */
            throw new UnsupportedOperationException
                ("This environment must be converted for replication." +
                 " using com.sleepycat.je.rep.util.DbEnableReplication.");
        }
    }


    /**
     * Returns the hostname associated with this node.
     *
     * @return the hostname
     */
    public String getHostName() {
        String hostAndPort = configManager.get(RepParams.NODE_HOST_PORT);
        int colonToken = hostAndPort.indexOf(":");
        return (colonToken >= 0) ?
               hostAndPort.substring(0,colonToken) :
               hostAndPort;
    }

    /**
     * Returns the  port used by the replication node.
     *
     * @return the port number
     */
    public int getPort() {
        String hostAndPort = configManager.get(RepParams.NODE_HOST_PORT);
        int colonToken = hostAndPort.indexOf(":");
        return (colonToken >= 0) ?
                Integer.parseInt(hostAndPort.substring(colonToken+1)) :
                configManager.getInt(RepParams.DEFAULT_PORT);
    }

    /* Convenience method for returning replication sockets. */
    public InetSocketAddress getSocket() {
        return new InetSocketAddress(getHostName(), getPort());
    }

    /**
     * Returns the set of sockets associated with helper nodes.
     *
     * @return the set of helper sockets, returns an empty set if there
     * are no helpers.
     */
    public Set<InetSocketAddress> getHelperSockets() {
        Set<InetSocketAddress> helpers = new HashSet<InetSocketAddress>();
        String helperHosts = configManager.get(RepParams.HELPER_HOSTS);
        if (helperHosts == null) {
            return helpers;
        }
        for (StringTokenizer tokenizer =
             new StringTokenizer(helperHosts,",");
             tokenizer.hasMoreTokens();) {
            String hostPortPair = tokenizer.nextToken();
            helpers.add(HostPortPair.getSocket(hostPortPair));
        }
        return helpers;
    }

    /**
     * Called when a node has identified itself as the master, which is when
     * the RepNode.selfElect is called. The database should not exist at
     * this point.
     *
     * Lock hierarchy: GroupDbLock -> sync on EnvironmentImpl
     * @throws DatabaseException
     */
    public DatabaseImpl createGroupDb()
        throws DatabaseException {

        assert isMaster();

        try {
            groupDbLock.lockInterruptibly();
        } catch (InterruptedException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }

        try {
            if (groupDbImpl != null) {
                throw EnvironmentFailureException.unexpectedState
                    ("GroupDb should not exist.");
            }

            DatabaseImpl newDbImpl = null;
            Txn txn = null;
            try {
                TransactionConfig txnConfig = new TransactionConfig();
                txnConfig.setDurability(new Durability(SyncPolicy.SYNC,
                                                       SyncPolicy.SYNC,
                                                       ReplicaAckPolicy.NONE));
                txnConfig.setConsistencyPolicy(NO_CONSISTENCY);
                txn = new MasterTxn(this,
                                    txnConfig,
                                    getNameIdPair());

                /* Database should not exist yet, create it now */
                DatabaseConfig dbConfig = new DatabaseConfig();
                dbConfig.setAllowCreate(true);
                dbConfig.setTransactional(true);
                dbConfig.setExclusiveCreate(true);
                DbInternal.setReplicated(dbConfig, true);

                newDbImpl =
                    getDbTree().createInternalDb(txn,
                                                 DbTree.REP_GROUP_DB_NAME,
                                                 dbConfig);
                txn.commit();
                txn = null;
            } finally {
                if (txn!= null) {
                    txn.abort();
                }
            }

            groupDbImpl = newDbImpl;
        } finally {
            groupDbLock.unlock();
        }
        return groupDbImpl;
    }

    /**
     * @see EnvironmentImpl#getCleanerBarrierStartFile
     * @returns -1 if file deletion is prohibited.
     */
    @Override
    public long getCleanerBarrierStartFile() {
        if (repNode == null) {
            return -1;
        }
        return repNode.getCleanerBarrierFile();
    }


    /**
     * Open the group db, which should exist already.
     */
    public DatabaseImpl getGroupDb()
        throws DatabaseNotFoundException,
               DatabaseException {
            return getGroupDb(NO_CONSISTENCY);
    }

    public DatabaseImpl getGroupDb(ReplicaConsistencyPolicy policy)
        throws DatabaseNotFoundException,
               DatabaseException {

        return openGroupDb(policy, false /* doLockProbe */);
    }

    /**
     * Open the group db, which should exist already. Do not wait on the
     * group db lock, return null if the databaseImpl hasn't been created and
     * we can't obtain it.
     *
     * Lock hierarchy: GroupDbLock -> sync on EnvironmentImpl
     */
    public DatabaseImpl probeGroupDb()
        throws DatabaseException {

        try {
            return openGroupDb(NO_CONSISTENCY, true /* doLockProbe */);
        } catch (DatabaseNotFoundException e) {
            /* Should never happen, DB should exist. */
            throw EnvironmentFailureException.unexpectedException(e);
        }
    }

    /**
     * Do the work of creating the lock and then assigning the groupDbImpl
     * field.
     *
     * @throws DatabaseException
     * @throws DatabaseNotFoundException
     */
    private DatabaseImpl openGroupDb(ReplicaConsistencyPolicy policy,
                                     boolean doLockProbe)
        throws DatabaseNotFoundException, DatabaseException {

        /* Acquire the lock. */
        try {
            if (doLockProbe) {
                if (!groupDbLock.tryLock(1, TimeUnit.MILLISECONDS)) {
                    /* Contention, try later. */
                    return null;
                }
            } else {
                groupDbLock.lockInterruptibly();
            }
        } catch(InterruptedException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }

        Txn txn = null;
        try {
            if (groupDbImpl != null) {
                return groupDbImpl;
            }

            DatabaseImpl newDbImpl = null;
            TransactionConfig txnConfig = new TransactionConfig();
            txnConfig.setConsistencyPolicy(policy);
            txn = new ReadonlyTxn(this, txnConfig);

            newDbImpl = getDbTree().getDb(txn,
                                          DbTree.REP_GROUP_DB_NAME,
                                          null /* databaseHandle */);
            if (newDbImpl == null) {
                throw new
                    DatabaseNotFoundException(DbTree.REP_GROUP_DB_NAME);
            }
            txn.commit();
            txn = null;

            groupDbImpl = newDbImpl;
            return groupDbImpl;
        } finally {
            if (txn != null) {
                txn.abort();
            }
            groupDbLock.unlock();
        }
    }

    /**
     *  Returns true, if the node has been designated a Primary.
     */
    public boolean isDesignatedPrimary() {
        return getConfigManager().getBoolean(RepParams.DESIGNATED_PRIMARY);
    }

    @Override
    public boolean addDbBackup(DbBackup backup) {
        synchronized (backups) {
            if (backupProhibited) {
                return false;
            }
            assert backups.add(backup);
        }

        return true;
    }

    @Override
    public void removeDbBackup(DbBackup backup) {
        synchronized (backups) {
            assert backups.remove(backup);
        }
    }

    /* Invalidate all the on going DbBackups, used in Replay.rollback(). */
    public void invalidateBackups(long fileNumber) {
        synchronized (backups) {
            for (DbBackup backup : backups) {
                backup.invalidate(fileNumber);
            }
        }
    }

    /* Set the backupProhibited status, used in Replay.rollback(). */
    public void setBackupProhibited(boolean backupProhibited) {
        synchronized (backups) {
            this.backupProhibited = backupProhibited;
        }
    }

    /* For creating a rep exception from standalone code. */
    @Override
    public LockPreemptedException
        createLockPreemptedException(Locker locker, Throwable cause) {
        return new LockPreemptedException(locker, cause);
    }

    /* For creating a rep exception from standalone code. */
    @Override
    public DatabasePreemptedException
        createDatabasePreemptedException(String msg,
                                         String dbName,
                                         Database db) {
        return new DatabasePreemptedException(msg, dbName, db);
    }

    /* For creating a rep exception from standalone code. */
    @Override
    public LogOverwriteException createLogOverwriteException(String msg) {
        return new LogOverwriteException(msg);
    }

    /**
     * Sets up the environment for group shutdown when the environment is
     * closed.
     *
     * @see ReplicatedEnvironment#shutdownGroup(long, TimeUnit)
     */
    public void shutdownGroupSetup(long timeoutMs) {
        final int openCount = getReferenceCount();
        if (openCount > 1) {
            throw new IllegalStateException
                ("Environment has " + (openCount - 1) +
                 " additional open handles.");
        }
       repNode.shutdownGroupOnClose(timeoutMs);
    }

    /**
     * Dump interesting aspects of the node's state. Currently for debugging
     * use, possibly useful for field support.
     */
    public String dumpState() {
        StringBuilder sb = new StringBuilder();

        sb.append(getNameIdPair());
        sb.append("[").append(getState()).append("] " );

        if (repNode != null) {
            sb.append(repNode.dumpState());
        }

        if (vlsnIndex != null) {
            sb.append("vlsnRange=");
            sb.append(vlsnIndex.getRange()).append("\n");
        }

        if (replay != null) {
            sb.append(replay.dumpState());
        }

        return sb.toString();
    }

    /**
     * If this node was started with a hard recovery, preserve that
     * information.
     */
    public void setHardRecoveryInfo(RollbackException e) {
        hardRecoveryStat.set(true);
        hardRecoveryInfoStat.set(e.getMessage());
    }

    public StatGroup getNodeStats() {
        return nodeStats;
    }
}
