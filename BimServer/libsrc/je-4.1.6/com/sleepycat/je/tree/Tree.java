/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import static com.sleepycat.je.dbi.BTreeStatDefinition.BTREE_RELATCHES_REQUIRED;
import static com.sleepycat.je.dbi.BTreeStatDefinition.BTREE_ROOT_SPLITS;
import static com.sleepycat.je.dbi.BTreeStatDefinition.GROUP_NAME;
import static com.sleepycat.je.dbi.BTreeStatDefinition.GROUP_DESC;

import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.BtreeStats;
import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.cleaner.LocalUtilizationTracker;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.latch.LatchSupport;
import com.sleepycat.je.latch.SharedLatch;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.recovery.RecoveryManager;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.WriteLockInfo;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.IntStat;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.RelatchRequiredException;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.TestHookExecute;

/**
 * Tree implements the JE B+Tree.
 *
 * A note on tree search patterns:
 * There's a set of Tree.search* methods. Some clients of the tree use
 * those search methods directly, whereas other clients of the tree
 * tend to use methods built on top of search.
 *
 * The semantics of search* are
 *   they leave you pointing at a BIN or IN
 *   they don't tell you where the reference of interest is.
 *   they traverse a single tree, to jump into the duplicate tree, the
 *   caller has to take explicit action.
 * The semantics of the get* methods are:
 *   they leave you pointing at a BIN or IN
 *   they return the index of the slot of interest
 *   they traverse down to whatever level is needed -- they'll take care of
 *   jumping into the duplicate tree.
 *   they are built on top of search* methods.
 * For the future:
 * Over time, we need to clarify which methods are to be used by clients
 * of the tree. Preferably clients that call the tree use get*, although
 * their are cases where they need visibility into the tree structure. For
 * example, tee cursors use search* because they want to add themselves to
 * BIN before jumping into the duplicate tree.
 *
 * Also, search* should return the location of the slot to save us a
 * second binary search.
 */
public final class Tree implements Loggable {

    /* For debug tracing */
    private static final String TRACE_ROOT_SPLIT = "RootSplit:";
    private static final String TRACE_DUP_ROOT_SPLIT = "DupRootSplit:";
    private static final String TRACE_MUTATE = "Mut:";
    private static final String TRACE_INSERT = "Ins:";
    private static final String TRACE_INSERT_DUPLICATE = "InsD:";

    private DatabaseImpl database;
    private ChildReference root;
    private int maxMainTreeEntriesPerNode;
    private int maxDupTreeEntriesPerNode;

    /* Stats */
    private StatGroup stats;

    /* The number of tree root splited. */
    private IntStat rootSplits;
    /* The number of latch upgrades from shared to exclusive required. */
    private LongStat relatchesRequired;

    /*
     * Latch that must be held when using/accessing the root node.  Protects
     * against the root being changed out from underneath us by splitRoot.
     */
    private SharedLatch rootLatch;

    private ThreadLocal<TreeWalkerStatsAccumulator> treeStatsAccumulatorTL =
        new ThreadLocal<TreeWalkerStatsAccumulator>();

    /*
     * We don't need the stack trace on this so always throw a static and
     * avoid the cost of Throwable.fillInStack() every time it's thrown.
     * [#13354].
     */
    private static SplitRequiredException splitRequiredException =
        new SplitRequiredException();

    /**
     * Embodies an enum for the type of search being performed.  NORMAL means
     * do a regular search down the tree.  LEFT/RIGHT means search down the
     * left/right side to find the first/last node in the tree.
     */
    public static class SearchType {
        /* Search types */
        public static final SearchType NORMAL = new SearchType();
        public static final SearchType LEFT   = new SearchType();
        public static final SearchType RIGHT  = new SearchType();

        /* No lock types can be defined outside this class. */
        private SearchType() {
        }
    }

    /* For unit tests */
    private TestHook waitHook; // used for generating race conditions
    private TestHook searchHook; // [#12736]
    private TestHook ckptHook; // [#13897]

    /**
     * Create a new tree.
     */
    public Tree(DatabaseImpl database) {
        init(database);
        setDatabase(database);
    }

    /**
     * Create a tree that's being read in from the log.
     */
    public Tree() {
        init(null);
        maxMainTreeEntriesPerNode = 0;
        maxDupTreeEntriesPerNode = 0;
    }

    /**
     * constructor helper
     */
    private void init(DatabaseImpl database) {
        rootLatch = new SharedLatch("RootLatch");
        this.root = null;
        this.database = database;

        /* Do the stats definitions. */
        stats = new StatGroup(GROUP_NAME, GROUP_DESC);
        relatchesRequired = new LongStat(stats, BTREE_RELATCHES_REQUIRED);
        rootSplits = new IntStat(stats, BTREE_ROOT_SPLITS);
    }

    /**
     * Set the database for this tree. Used by recovery when recreating an
     * existing tree.
     */
    public void setDatabase(DatabaseImpl database) {
        this.database = database;
        maxMainTreeEntriesPerNode = database.getNodeMaxEntries();
        maxDupTreeEntriesPerNode = database.getNodeMaxDupTreeEntries();
        DbConfigManager configManager =
            database.getDbEnvironment().getConfigManager();
    }

    /**
     * @return the database for this Tree.
     */
    public DatabaseImpl getDatabase() {
        return database;
    }

    /**
     * Set the root for the tree. Should only be called within the root latch.
     */
    public void setRoot(ChildReference newRoot, boolean notLatched) {
        assert (notLatched || rootLatch.isWriteLockedByCurrentThread());
        root = newRoot;
    }

    public ChildReference makeRootChildReference(Node target,
                                                 byte[] key,
                                                 long lsn) {
        return new RootChildReference(target, key, lsn);
    }

    private ChildReference makeRootChildReference() {
        return new RootChildReference();
    }

    /*
     * A tree doesn't have a root if (a) the root field is null, or (b)
     * the root is non-null, but has neither a valid target nor a valid
     * LSN. Case (b) can happen if the dataabase is or was previously opened in
     * deferred write mode.
     * @return false if there is no real root.
     */
    public boolean rootExists() {
        if (root == null) {
            return false;
        }

        if ((root.getTarget() == null) &&
            (root.getLsn() == DbLsn.NULL_LSN)) {
            return false;
        }

        return true;
    }

    /**
     * Perform a fast check to see if the root IN is resident.  No latching is
     * performed.  To ensure that the root IN is not loaded by another thread,
     * this method should be called while holding a write lock on the MapLN.
     * That will prevent opening the DB in another thread, and potentially
     * loading the root IN. [#13415]
     */
    public boolean isRootResident() {
        return root != null && root.getTarget() != null;
    }

    /*
     * Class that overrides fetchTarget() so that if the rootLatch is not
     * held exclusively when the root is fetched, we upgrade it to exclusive.
     */
    private class RootChildReference extends ChildReference {

        private RootChildReference() {
            super();
        }

        private RootChildReference(Node target, byte[] key, long lsn) {
            super(target, key, lsn);
        }

        /* Caller is responsible for releasing rootLatch. */
        @Override
        public Node fetchTarget(DatabaseImpl database, IN in)
            throws DatabaseException {

            if (getTarget() == null &&
                !rootLatch.isWriteLockedByCurrentThread()) {
                rootLatch.release();
                rootLatch.acquireExclusive();
            }

            return super.fetchTarget(database, in);
        }

        @Override
        public void setTarget(Node target) {
            assert rootLatch.isWriteLockedByCurrentThread();
            super.setTarget(target);
        }

        @Override
        public void clearTarget() {
            assert rootLatch.isWriteLockedByCurrentThread();
            super.clearTarget();
        }

        @Override
        public void setLsn(long lsn) {
            assert rootLatch.isWriteLockedByCurrentThread();
            super.setLsn(lsn);
        }

        @Override
        void updateLsnAfterOptionalLog(DatabaseImpl dbImpl, long lsn) {
            assert rootLatch.isWriteLockedByCurrentThread();
            super.updateLsnAfterOptionalLog(dbImpl, lsn);
        }
    }

    /**
     * Get LSN of the rootIN. Obtained without latching, should only be
     * accessed while quiescent.
     */
    public long getRootLsn() {
        if (root == null) {
            return DbLsn.NULL_LSN;
        } else {
            return root.getLsn();
        }
    }

    /**
     * @return the TreeStats for this tree.
     */
    int getTreeStats() {
        return rootSplits.get();
    }

    private TreeWalkerStatsAccumulator getTreeStatsAccumulator() {
        if (EnvironmentImpl.getThreadLocalReferenceCount() > 0) {
            return treeStatsAccumulatorTL.get();
        } else {
            return null;
        }
    }

    public void setTreeStatsAccumulator(TreeWalkerStatsAccumulator tSA) {
        treeStatsAccumulatorTL.set(tSA);
    }

    public IN withRootLatchedExclusive(WithRootLatched wrl)
        throws DatabaseException {

        try {
            rootLatch.acquireExclusive();
            return wrl.doWork(root);
        } finally {
            rootLatch.release();
        }
    }

    public IN withRootLatchedShared(WithRootLatched wrl)
        throws DatabaseException {

        try {
            rootLatch.acquireShared();
            return wrl.doWork(root);
        } finally {
            rootLatch.release();
        }
    }

    /**
     * Deletes a BIN specified by key from the tree. If the BIN resides in a
     * subtree that can be pruned away, prune as much as possible, so we
     * don't leave a branch that has no BINs.
     *
     * It's possible that the targeted BIN will now have entries, or will
     * have resident cursors. Either will prevent deletion.
     *
     * @param idKey - the identifier key of the node to delete.
     * @param localTracker is used for tracking obsolete node info.
     */
    public void delete(byte[] idKey,
                       LocalUtilizationTracker localTracker)
        throws DatabaseException,
               NodeNotEmptyException,
               CursorsExistException {

        IN subtreeRootIN = null;

        /*
         * A delete is a reverse split that must be propagated up to the root.
         * [#13501] Keep all nodes from the rootIN to the parent of the
         * deletable subtree latched as we descend so we can log the
         * IN deletion and cascade the logging up the tree. The latched
         * nodes are kept in order in the nodeLadder.
         */
        ArrayList<SplitInfo> nodeLadder = new ArrayList<SplitInfo>();

        IN rootIN = null;
        boolean rootNeedsUpdating = false;
        rootLatch.acquireExclusive();
        try {
            if (!rootExists()) {
                /* no action, tree is deleted or was never persisted. */
                return;
            }

            rootIN = (IN) root.fetchTarget(database, null);
            rootIN.latch(CacheMode.UNCHANGED);

            searchDeletableSubTree(rootIN, idKey, nodeLadder);
            if (nodeLadder.size() == 0) {

                /*
                 * The tree is empty, so do nothing.  Root compression is no
                 * longer supported.  Root compression has no impact on memory
                 * usage now that we evict the root IN.  It reduces log space
                 * taken by INs for empty (but not removed) databases, yet
                 * requires logging an INDelete and MapLN; this provides very
                 * little benefit, if any.  Because it requires extensive
                 * testing (which has not been done), this minor benefit is not
                 * worth the cost.  And by removing it we no longer log
                 * INDelete, which reduces complexity going forward. [#17546]
                 */
            } else {
                /* Detach this subtree. */
                SplitInfo detachPoint =
                    nodeLadder.get(nodeLadder.size() - 1);
                boolean deleteOk =
                    detachPoint.parent.deleteEntry(detachPoint.index,
                                                   true);
                assert deleteOk;

                /* Cascade updates upward, including writing the root IN. */
                rootNeedsUpdating = cascadeUpdates(nodeLadder, null, -1);
                subtreeRootIN = detachPoint.child;
            }
        } finally {
            releaseNodeLadderLatches(nodeLadder);

            if (rootIN != null) {
                rootIN.releaseLatch();
            }

            rootLatch.release();
        }

        if (subtreeRootIN != null) {

            EnvironmentImpl envImpl = database.getDbEnvironment();
            if (rootNeedsUpdating) {

                /*
                 * modifyDbRoot will grab locks and we can't have the INList
                 * latches or root latch held while it tries to acquire locks.
                 */
                DbTree dbTree = envImpl.getDbTree();
                dbTree.optionalModifyDbRoot(database);
                RecoveryManager.traceRootDeletion
                    (envImpl.getLogger(), database);
            }

            /*
             * Count obsolete nodes after logging the delete. We can do
             * this without having the nodes of the subtree latched because the
             * subtree has been detached from the tree.
             */
            INList inList = envImpl.getInMemoryINs();
            accountForSubtreeRemoval(inList, subtreeRootIN, localTracker);
        }
    }

    private void releaseNodeLadderLatches(ArrayList<SplitInfo> nodeLadder)
        throws DatabaseException {

        /*
         * Clear any latches left in the node ladder. Release from the
         * bottom up.
         */
        ListIterator<SplitInfo> iter =
            nodeLadder.listIterator(nodeLadder.size());
        while (iter.hasPrevious()) {
            SplitInfo info = iter.previous();
            info.child.releaseLatch();
        }
    }

    /**
     * Update nodes for a delete, going upwards. For example, suppose a
     * node ladder holds:
     * INa, INb, index for INb in INa
     * INb, INc, index for INc in INb
     * INc, BINd, index for BINd in INc
     *
     * When we enter this method, BINd has already been removed from INc. We
     * need to
     *  - log INc
     *  - update INb, log INb
     *  - update INa, log INa
     *
     * @param nodeLadder List of SplitInfos describing each node pair on the
     * downward path
     * @param binRoot parent of the dup tree, or null if this is not for
     * dups.
     * @param index slot occupied by this din tree.
     * @return whether the DB root needs updating.
     */
    private boolean cascadeUpdates(ArrayList<SplitInfo> nodeLadder,
                                   BIN binRoot,
                                   int index)
        throws DatabaseException {

        ListIterator<SplitInfo> iter =
            nodeLadder.listIterator(nodeLadder.size());
        EnvironmentImpl envImpl = database.getDbEnvironment();
        LogManager logManager = envImpl.getLogManager();

        long newLsn = DbLsn.NULL_LSN;
        SplitInfo info = null;
        while (iter.hasPrevious()) {
            info = iter.previous();

            if (newLsn != DbLsn.NULL_LSN) {
                info.parent.updateEntry(info.index, newLsn);
            }
            newLsn = info.parent.optionalLog(logManager);
        }

        boolean rootNeedsUpdating = false;
        if (info != null) {
            /* We've logged the top of this subtree, record it properly. */
            if (info.parent.isDbRoot()) {
                /* We updated the rootIN of the database. */
                assert rootLatch.isWriteLockedByCurrentThread();
                root.updateLsnAfterOptionalLog(database, newLsn);
                rootNeedsUpdating = true;
            } else if ((binRoot != null) && info.parent.isRoot()) {
                /* We updated the DIN root of the database. */
                binRoot.updateEntry(index, newLsn);
            } else {
                assert false;
            }
        }
        return rootNeedsUpdating;
    }

    /**
     * Delete a subtree of a duplicate tree.  Find the duplicate tree using
     * mainKey in the top part of the tree and idKey in the duplicate tree.
     *
     * @param idKey the identifier key to be used in the duplicate subtree to
     * find the duplicate path.
     * @param mainKey the key to be used in the main tree to find the
     * duplicate subtree.
     * @param localTracker is used for tracking obsolete node info.
     *
     * @return true if the delete succeeded, false if there were still cursors
     * present on the leaf DBIN of the subtree that was located.
     */
    public void deleteDup(byte[] idKey,
                          byte[] mainKey,
                          LocalUtilizationTracker localTracker)
        throws DatabaseException,
               NodeNotEmptyException,
               CursorsExistException {

        /* Find the BIN that is the parent of this duplicate tree. */
        IN in = search(mainKey, SearchType.NORMAL, Node.NULL_NODE_ID, null,
                       CacheMode.UNCHANGED);

        IN deletedSubtreeRoot = null;
        try {
            assert in.isLatchOwnerForWrite();
            assert in instanceof BIN;
            assert in.getNEntries() > 0;

            /* Find the appropriate entry in this BIN. */
            int index = in.findEntry(mainKey, false, true);
            if (index >= 0) {
                deletedSubtreeRoot = deleteDupSubtree(idKey, (BIN) in, index);
            }
        } finally {
            in.releaseLatch();
        }

        if (deletedSubtreeRoot != null) {
            EnvironmentImpl envImpl = database.getDbEnvironment();
            accountForSubtreeRemoval(envImpl.getInMemoryINs(),
                                     deletedSubtreeRoot, localTracker);
        }
    }

    /**
     * We enter and leave this method with 'bin' latched.
     * @return the root of the subtree we have deleted, so it can be
     * properly accounted for. May be null if nothing was deleted.
     */
    private IN deleteDupSubtree(byte[] idKey,
                                BIN bin,
                                int index)
        throws DatabaseException,
               NodeNotEmptyException,
               CursorsExistException {

        EnvironmentImpl envImpl = database.getDbEnvironment();
        DupCountLN dcl = null;
        BasicLocker locker = BasicLocker.createBasicLocker(envImpl);
        /* Don't allow this short-lived lock to be preempted/stolen. */
        locker.setPreemptable(false);

        /*  Latch the DIN root. */
        DIN duplicateRoot = (DIN) bin.fetchTarget(index);
        duplicateRoot.latch(CacheMode.UNCHANGED);

        ArrayList<SplitInfo> nodeLadder = new ArrayList<SplitInfo>();
        IN subtreeRootIN = null;

        try {

            /*
             * Read lock the dup count LN to ascertain whether there are any
             * writers in the tree. TODO: This seems unnecessary now, revisit.
             */
            ChildReference dclRef = duplicateRoot.getDupCountLNRef();
            dcl = (DupCountLN) dclRef.fetchTarget(database, duplicateRoot);

            LockResult lockResult = locker.nonBlockingLock(dcl.getNodeId(),
                                                           LockType.READ,
                                                           database);
            if (lockResult.getLockGrant() == LockGrantType.DENIED) {
                throw CursorsExistException.CURSORS_EXIST;
            }

            /*
             * We don't release the latch on bin before we search the
             * duplicate tree below because we might be deleting the whole
             * subtree from the IN and we want to keep it latched until we
             * know.
             */
            searchDeletableSubTree(duplicateRoot, idKey, nodeLadder);

            if (nodeLadder.size() == 0) {
                /* We're deleting the duplicate root. */
                if (bin.nCursors() == 0) {
                    boolean deleteOk = bin.deleteEntry(index, true);
                    assert deleteOk;

                    /*
                     * Use an INDupDeleteInfo to make it clear that this
                     * duplicate tree has been eradicated. This is analagous to
                     * deleting a root; we must be sure that we can overlay
                     * another subtree onto this slot at recovery redo.
                     */
                    INDupDeleteInfo info =
                        new INDupDeleteInfo(duplicateRoot.getNodeId(),
                                            duplicateRoot.getMainTreeKey(),
                                            duplicateRoot.getDupTreeKey(),
                                            database.getId());
                    info.optionalLog(envImpl.getLogManager(), database);

                    subtreeRootIN = duplicateRoot;

                    if (bin.getNEntries() == 0) {
                        database.getDbEnvironment().
                            addToCompressorQueue(bin, null, false);
                    }
                } else {

                    /*
                     * Cursors prevent us from deleting this dup tree, we'll
                     * have to retry.
                     */
                    throw CursorsExistException.CURSORS_EXIST;
                }
            } else {

                /* We're deleting a portion of the duplicate tree. */
                SplitInfo detachPoint =
                    nodeLadder.get(nodeLadder.size() - 1);
                boolean deleteOk =
                    detachPoint.parent.deleteEntry(detachPoint.index,
                                                   true);
                assert deleteOk;

                /*
                 * Cascade updates upward, including writing the root
                 * DIN and parent BIN.
                 */
                cascadeUpdates(nodeLadder, bin, index);
                subtreeRootIN = detachPoint.child;
            }
        } finally {
            releaseNodeLadderLatches(nodeLadder);

            locker.operationEnd(true);
            duplicateRoot.releaseLatch();
        }

        return subtreeRootIN;
    }

    /**
     * Find the leftmost node (IN or BIN) in the tree.  Do not descend into a
     * duplicate tree if the leftmost entry of the first BIN refers to one.
     *
     * @return the leftmost node in the tree, null if the tree is empty.  The
     * returned node is latched and the caller must release it.
     */
    public IN getFirstNode(CacheMode cacheMode)
        throws DatabaseException {

        return search(null, SearchType.LEFT, Node.NULL_NODE_ID, null,
                      cacheMode);
    }

    /**
     * Find the rightmost node (IN or BIN) in the tree.  Do not descend into a
     * duplicate tree if the rightmost entry of the last BIN refers to one.
     *
     * @return the rightmost node in the tree, null if the tree is empty.  The
     * returned node is latched and the caller must release it.
     */
    public IN getLastNode(CacheMode cacheMode)
        throws DatabaseException {

        return search(null, SearchType.RIGHT, Node.NULL_NODE_ID, null,
                      cacheMode);
    }

    /**
     * Find the leftmost node (DBIN) in a duplicate tree.
     *
     * @return the leftmost node in the tree, null if the tree is empty.  The
     * returned node is latched and the caller must release it.
     */
    public DBIN getFirstNode(DIN dupRoot, CacheMode cacheMode)
        throws DatabaseException {

        if (dupRoot == null) {
            throw EnvironmentFailureException.unexpectedState
                ("getFirstNode passed null root");
        }

        assert dupRoot.isLatchOwnerForWrite();

        IN ret = searchSubTree(dupRoot, null, SearchType.LEFT,
                               Node.NULL_NODE_ID, null, cacheMode);
        return (DBIN) ret;
    }

    /**
     * Find the rightmost node (DBIN) in a duplicate tree.
     *
     * @return the rightmost node in the tree, null if the tree is empty.  The
     * returned node is latched and the caller must release it.
     */
    public DBIN getLastNode(DIN dupRoot, CacheMode cacheMode)
        throws DatabaseException {

        if (dupRoot == null) {
            throw EnvironmentFailureException.unexpectedState
                ("getLastNode passed null root");
        }

        assert dupRoot.isLatchOwnerForWrite();

        IN ret = searchSubTree(dupRoot, null, SearchType.RIGHT,
                               Node.NULL_NODE_ID, null, cacheMode);
        return (DBIN) ret;
    }

    /**
     * GetParentNode without optional tracking.
     */
    public SearchResult getParentINForChildIN(IN child,
                                              boolean requireExactMatch,
                                              CacheMode cacheMode)
        throws DatabaseException {

        return getParentINForChildIN
            (child, requireExactMatch, cacheMode, -1 /*targetLevel*/, null);
    }

    /**
     * Return a reference to the parent or possible parent of the child.  Used
     * by objects that need to take a standalone node and find it in the tree,
     * like the evictor, checkpointer, and recovery.
     *
     * @param child The child node for which to find the parent.  This node is
     * latched by the caller and is released by this function before returning
     * to the caller.
     *
     * @param requireExactMatch if true, we must find the exact parent, not a
     * potential parent.
     *
     * @param cacheMode The CacheMode for affecting the hotness of the tree.
     *
     * @param trackingList if not null, add the LSNs of the parents visited
     * along the way, as a debug tracing mechanism. This is meant to stay in
     * production, to add information to the log.
     *
     * @return a SearchResult object. If the parent has been found,
     * result.foundExactMatch is true. If any parent, exact or potential has
     * been found, result.parent refers to that node.
     */
    public SearchResult getParentINForChildIN(IN child,
                                              boolean requireExactMatch,
                                              CacheMode cacheMode,
                                              int targetLevel,
                                              List<TrackingInfo> trackingList)
        throws DatabaseException {

        /* Sanity checks */
        if (child == null) {
            throw EnvironmentFailureException.unexpectedState
                ("getParentNode passed null");
        }

        assert child.isLatchOwnerForWrite();

        /*
         * Get information from child before releasing latch.
         */
        byte[] mainTreeKey = child.getMainTreeKey();
        byte[] dupTreeKey = child.getDupTreeKey();
        boolean isRoot = child.isRoot();
        child.releaseLatch();

        return getParentINForChildIN(child.getNodeId(),
                                     child.containsDuplicates(),
                                     isRoot,
                                     mainTreeKey,
                                     dupTreeKey,
                                     requireExactMatch,
                                     cacheMode,
                                     targetLevel,
                                     trackingList,
                                     true);
    }

    /**
     * Return a reference to the parent or possible parent of the child.  Used
     * by objects that need to take a node id and find it in the tree,
     * like the evictor, checkpointer, and recovery.
     *
     * @param requireExactMatch if true, we must find the exact parent, not a
     * potential parent.
     *
     * @param cacheMode The CacheMode for affecting the hotness of the tree.
     *
     * @param trackingList if not null, add the LSNs of the parents visited
     * along the way, as a debug tracing mechanism. This is meant to stay in
     * production, to add information to the log.
     *
     * @param doFetch if false, stop the search if we run into a non-resident
     * child. Used by the checkpointer to avoid conflicting with work done
     * by the evictor.
     *
     * @return a SearchResult object. If the parent has been found,
     * result.foundExactMatch is true. If any parent, exact or potential has
     * been found, result.parent refers to that node.
     */
    public SearchResult getParentINForChildIN(long targetNodeId,
                                              boolean targetContainsDuplicates,
                                              boolean targetIsRoot,
                                              byte[] targetMainTreeKey,
                                              byte[] targetDupTreeKey,
                                              boolean requireExactMatch,
                                              CacheMode cacheMode,
                                              int targetLevel,
                                              List<TrackingInfo> trackingList,
                                              boolean doFetch)
        throws DatabaseException {

        /*
         * Use exclusive latching. Since the caller will be logging the child
         * IN, the parent IN must be latched exclusively. [#18567]
         */
        IN rootIN = getRootINLatchedExclusive(cacheMode);

        SearchResult result = new SearchResult();
        if (rootIN != null) {
            /* The tracking list is a permanent tracing aid. */
            if (trackingList != null) {
                trackingList.add(new TrackingInfo(root.getLsn(),
                                                  rootIN.getNodeId()));
            }

            IN potentialParent = rootIN;
            boolean success = false;

            try {
                while (result.keepSearching) {

                    /*
                     * [12736] Prune away oldBin.  Assert has intentional
                     * side effect.
                     */
                    assert TestHookExecute.doHookIfSet(searchHook);

                    potentialParent.findParent(SearchType.NORMAL,
                                               targetNodeId,
                                               targetContainsDuplicates,
                                               targetIsRoot,
                                               targetMainTreeKey,
                                               targetDupTreeKey,
                                               result,
                                               requireExactMatch,
                                               cacheMode,
                                               targetLevel,
                                               trackingList,
                                               doFetch);
                    potentialParent = result.parent;
                }
                success = true;

            } catch (RelatchRequiredException e) {
                /* Should never happen because we use exclusive latches. */
                throw EnvironmentFailureException.unexpectedException(e);
            } finally {

                /*
                 * The only thing that can be latched at this point is
                 * potentialParent.
                 */
                if (!success) {
                    potentialParent.releaseLatch();
                }
            }
        }
        return result;
    }

    /**
     * Return a reference to the parent of this LN. This searches through the
     * main and duplicate tree and allows splits. Set the tree location to the
     * proper BIN parent whether or not the LN child is found. That's because
     * if the LN is not found, recovery or abort will need to place it within
     * the tree, and so we must point at the appropriate position.
     *
     * <p>When this method returns with location.bin non-null, the BIN is
     * latched and must be unlatched by the caller.  Note that location.bin may
     * be non-null even if this method returns false.</p>
     *
     * @param location a holder class to hold state about the location
     * of our search. Sort of an internal cursor.
     *
     * @param mainKey key to navigate through main key
     *
     * @param dupKey key to navigate through duplicate tree. May be null, since
     * deleted lns have no data.
     *
     * @param ln the node instantiated from the log
     *
     * @param splitsAllowed true if this method is allowed to cause tree splits
     * as a side effect. In practice, recovery can cause splits, but abort
     * can't.
     *
     * @param searchDupTree true if a search through the dup tree looking for
     * a match on the ln's node id should be made (only in the case where
     * dupKey == null).  See SR 8984.
     *
     * @param cacheMode The CacheMode for affecting the hotness of the tree.
     *
     * @return true if node found in tree.
     * If false is returned and there is the possibility that we can insert
     * the record into a plausible parent we must also set
     * - location.bin (may be null if no possible parent found)
     * - location.lnKey (don't need to set if no possible parent).
     */
    public boolean getParentBINForChildLN(TreeLocation location,
                                          byte[] mainKey,
                                          byte[] dupKey,
                                          LN ln,
                                          boolean splitsAllowed,
                                          boolean findDeletedEntries,
                                          boolean searchDupTree,
                                          CacheMode cacheMode)
        throws DatabaseException {

        /*
         * Find the BIN that either points to this LN or could be its
         * ancestor.
         */
        IN searchResult = null;
        if (splitsAllowed) {
            searchResult = searchSplitsAllowed(mainKey, Node.NULL_NODE_ID,
                                               cacheMode);
        } else {
            searchResult = search(mainKey, SearchType.NORMAL,
                                  Node.NULL_NODE_ID, null, cacheMode);
        }
        location.bin = (BIN) searchResult;

        if (location.bin == null) {
            return false;
        }

        /*
         * If caller wants us to consider knownDeleted entries then do an
         * inexact search in findEntry since that will find knownDeleted
         * entries.  If caller doesn't want us to consider knownDeleted entries
         * then do an exact search in findEntry since that will not return
         * knownDeleted entries.
         */
        boolean exactSearch = false;
        boolean indicateIfExact = true;
        if (!findDeletedEntries) {
            exactSearch = true;
            indicateIfExact = false;
        }
        location.index =
            location.bin.findEntry(mainKey, indicateIfExact, exactSearch);

        boolean match = false;
        if (findDeletedEntries) {
            match = (location.index >= 0 &&
                     (location.index & IN.EXACT_MATCH) != 0);
            location.index &= ~IN.EXACT_MATCH;
        } else {
            match = (location.index >= 0);
        }

        if (match) {

            /*
             * A BIN parent was found and a slot matches the key. See if we
             * have to search further into what may be a dup tree.
             *
             * If this database doesn't support duplicates, no point in
             * incurring the potentially large cost of fetching in the child to
             * check for dup trees. In the future, we could optimize further by
             * storing state per slot as to whether a dup tree hangs below.
             */
            if (!location.bin.isEntryKnownDeleted(location.index) &&
                database.getSortedDuplicates()) {
                Node childNode = location.bin.fetchTarget(location.index);
                try {
                    /* Is our target LN a regular record or a dup count? */
                    if (childNode == null) {
                        /* Child is a deleted cleaned LN. */
                    } else if (ln.containsDuplicates()) {
                        /* This is a duplicate count LN. */
                        return searchDupTreeForDupCountLNParent
                            (location, mainKey, childNode);
                    } else {

                        /*
                         * This is a regular LN. If this is a dup tree, descend
                         * and search. If not, we've found the parent.
                         */
                        if (childNode.containsDuplicates()) {
                            if (dupKey == null) {

                                /*
                                 * We are at a dup tree but our target LN has
                                 * no dup key because it's a deleted LN.  We've
                                 * encountered the case of SR 8984 where we are
                                 * searching for an LN that was deleted before
                                 * the conversion to a duplicate tree.
                                 */
                                return searchDupTreeByNodeId
                                    (location, childNode, ln, searchDupTree,
                                     cacheMode);
                            } else {
                                return searchDupTreeForDBIN
                                    (location, dupKey, (DIN) childNode, ln,
                                     findDeletedEntries, indicateIfExact,
                                     exactSearch, splitsAllowed, cacheMode);
                            }
                        }
                    }
                } catch (DatabaseException e) {
                    location.bin.releaseLatchIfOwner();
                    throw e;
                }
            }

            /* We had a match, we didn't need to search the duplicate tree. */
            location.childLsn = location.bin.getLsn(location.index);
            return true;
        } else {
            location.lnKey = mainKey;
            return false;
        }
    }

    /**
     * For SR [#8984]: our prospective child is a deleted LN, and we're facing
     * a dup tree. Alas, the deleted LN has no data, and therefore nothing to
     * guide the search in the dup tree. Instead, we search by node id.  This
     * is very expensive, but this situation is a very rare case.
     */
    private boolean searchDupTreeByNodeId(TreeLocation location,
                                          Node childNode,
                                          LN ln,
                                          boolean searchDupTree,
                                          CacheMode cacheMode)
        throws DatabaseException {

        if (searchDupTree) {
            BIN oldBIN = location.bin;
            if (childNode.matchLNByNodeId
                (location, ln.getNodeId(), cacheMode)) {
                location.index &= ~IN.EXACT_MATCH;
                if (oldBIN != null) {
                    oldBIN.releaseLatch();
                }
                location.bin.latch(cacheMode);
                return true;
            } else {
                return false;
            }
        } else {

            /*
             * This is called from undo() so this LN can
             * just be ignored.
             */
            return false;
        }
    }

    /**
     * @return true if childNode is the DIN parent of this DupCountLN
     */
    private boolean searchDupTreeForDupCountLNParent(TreeLocation location,
                                                     byte[] mainKey,
                                                     Node childNode) {

        location.lnKey = mainKey;
        if (childNode instanceof DIN) {
            DIN dupRoot = (DIN) childNode;
            location.childLsn = dupRoot.getDupCountLNRef().getLsn();
            return true;
        } else {

            /*
             * If we're looking for a DupCountLN but don't find a duplicate
             * tree, then the key now refers to a single datum.  This can
             * happen when all dups for a key are deleted, the compressor runs,
             * and then a single datum is inserted.  [#10597]
             */
            return false;
        }
    }

    /**
     * Search the dup tree for the DBIN parent of this LN.
     */
    private boolean searchDupTreeForDBIN(TreeLocation location,
                                         byte[] dupKey,
                                         DIN dupRoot,
                                         LN ln,
                                         boolean findDeletedEntries,
                                         boolean indicateIfExact,
                                         boolean exactSearch,
                                         boolean splitsAllowed,
                                         CacheMode cacheMode)
        throws DatabaseException {

        assert dupKey != null;

        dupRoot.latch(cacheMode);

        /* Make sure there's room for inserts. */
        if (maybeSplitDuplicateRoot(location.bin, location.index, cacheMode)) {
            dupRoot = (DIN) location.bin.fetchTarget(location.index);
        }

        /*
         * Wait until after any duplicate root splitting to unlatch the BIN.
         */
        location.bin.releaseLatch();

        /*
         * The dupKey is going to be the key that represents the LN in this BIN
         * parent.
         */
        location.lnKey = dupKey;

        /* Search the dup tree */
        if (splitsAllowed) {
            try {
                location.bin = (BIN) searchSubTreeSplitsAllowed
                    (dupRoot, location.lnKey, ln.getNodeId(), cacheMode);
            } catch (RelatchRequiredException e) {
                /* Should never happen, we use exclusive latches on DINs. */
                throw EnvironmentFailureException.unexpectedException(e);
            } catch (SplitRequiredException e) {

                /*
                 * Shouldn't happen; the only caller of this method which
                 * allows splits is from recovery, which is single
                 * threaded.
                 */
                throw EnvironmentFailureException.unexpectedException(e);
            }
        } else {
            location.bin = (BIN) searchSubTree
                (dupRoot, location.lnKey, SearchType.NORMAL,
                 ln.getNodeId(), null, cacheMode);
        }

        /* Search for LN w/exact key. */
        location.index = location.bin.findEntry
            (location.lnKey, indicateIfExact, exactSearch);
        boolean match;
        if (findDeletedEntries) {
            match = (location.index >= 0 &&
                     (location.index & IN.EXACT_MATCH) != 0);
            location.index &= ~IN.EXACT_MATCH;
        } else {
            match = (location.index >= 0);
        }

        if (match) {
            location.childLsn = location.bin.getLsn(location.index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return a reference to the adjacent BIN.
     *
     * @param bin The BIN to find the next BIN for.  This BIN is latched.
     * @param traverseWithinDupTree if true, only search within the dup tree
     * and return null when the traversal runs out of duplicates.
     *
     * @return The next BIN, or null if there are no more.  The returned node
     * is latched and the caller must release it.  If null is returned, the
     * argument BIN remains latched.
     */
    public BIN getNextBin(BIN bin,
                          boolean traverseWithinDupTree,
                          CacheMode cacheMode)
        throws DatabaseException {

        return getNextBinInternal(traverseWithinDupTree, bin, true, cacheMode);
    }

    /**
     * Return a reference to the previous BIN.
     *
     * @param bin The BIN to find the next BIN for.  This BIN is latched.
     * @param traverseWithinDupTree if true, only search within the dup tree
     * and return null when the traversal runs out of duplicates.
     *
     * @return The previous BIN, or null if there are no more.  The returned
     * node is latched and the caller must release it.  If null is returned,
     * the argument bin remains latched.
     */
    public BIN getPrevBin(BIN bin,
                          boolean traverseWithinDupTree,
                          CacheMode cacheMode)
        throws DatabaseException {

        return getNextBinInternal(traverseWithinDupTree, bin,
                                  false, cacheMode);
    }

    /**
     * Helper routine for above two routines to iterate through BIN's.
     */
    private BIN getNextBinInternal(boolean traverseWithinDupTree,
                                   BIN bin,
                                   boolean forward,
                                   CacheMode cacheMode)
        throws DatabaseException {

        /*
         * Use the right most key (for a forward progressing cursor) or the
         * left most key (for a backward progressing cursor) as the idkey.  The
         * reason is that the BIN may get split while finding the next BIN so
         * it's not safe to take the BIN's identifierKey entry.  If the BIN
         * gets splits, then the right (left) most key will still be on the
         * resultant node.  The exception to this is that if there are no
         * entries, we just use the identifier key.
         */
        byte[] idKey = null;

        if (bin.getNEntries() == 0) {
            idKey = bin.getIdentifierKey();
        } else if (forward) {
            idKey = bin.getKey(bin.getNEntries() - 1);
        } else {
            idKey = bin.getKey(0);
        }

        IN next = bin;
        boolean nextIsLatched = false;

        assert LatchSupport.countLatchesHeld() == 1:
            LatchSupport.latchesHeldToString();

        /*
         * Ascend the tree until we find a level that still has nodes to the
         * right (or left if !forward) of the path that we're on.  If we reach
         * the root level, we're done. If we're searching within a duplicate
         * tree, stay within the tree.
         */
        IN parent = null;
        IN nextIN = null;
        boolean nextINIsLatched = false;
        try {
            while (true) {

                /*
                 * Move up a level from where we are now and check to see if we
                 * reached the top of the tree.
                 */
                SearchResult result = null;
                if (!traverseWithinDupTree) {
                    /* Operating on a regular tree -- get the parent. */
                    nextIsLatched = false;
                    result = getParentINForChildIN
                        (next, true /*requireExactMatch*/, cacheMode);
                    if (result.exactParentFound) {
                        parent = result.parent;
                    } else {
                        /* We've reached the root of the tree. */
                        assert (LatchSupport.countLatchesHeld() == 0):
                            LatchSupport.latchesHeldToString();
                        return null;
                    }
                } else {
                    /* This is a duplicate tree, stay within the tree.*/
                    if (next.isRoot()) {
                        /* We've reached the top of the dup tree. */
                        next.releaseLatch();
                        nextIsLatched = false;
                        return null;
                    } else {
                        nextIsLatched = false;
                        result = getParentINForChildIN
                            (next, true /*requireExactMatch*/, cacheMode);
                        if (result.exactParentFound) {
                            parent = result.parent;
                        } else {
                            return null;
                        }
                    }
                }

                assert (LatchSupport.countLatchesHeld() == 1) :
                    LatchSupport.latchesHeldToString();

                /*
                 * Figure out which entry we are in the parent.  Add (subtract)
                 * 1 to move to the next (previous) one and check that we're
                 * still pointing to a valid child.  Don't just use the result
                 * of the parent.findEntry call in getParentNode, because we
                 * want to use our explicitly chosen idKey.
                 */
                int index = parent.findEntry(idKey, false, false);
                boolean moreEntriesThisBin = false;
                if (forward) {
                    index++;
                    if (index < parent.getNEntries()) {
                        moreEntriesThisBin = true;
                    }
                } else {
                    if (index > 0) {
                        moreEntriesThisBin = true;
                    }
                    index--;
                }

                if (moreEntriesThisBin) {

                    /*
                     * There are more entries to the right of the current path
                     * in parent.  Get the entry, and then descend down the
                     * left most path to a BIN.
                     */
                    nextIN = (IN) parent.fetchTargetWithExclusiveLatch(index);
                    nextIN.latch(cacheMode);
                    nextINIsLatched = true;

                    assert (LatchSupport.countLatchesHeld() == 2):
                        LatchSupport.latchesHeldToString();

                    if (nextIN instanceof BIN) {
                        /* We landed at a leaf (i.e. a BIN). */
                        parent.releaseLatch();
                        parent = null; // to avoid falsely unlatching parent
                        TreeWalkerStatsAccumulator treeStatsAccumulator =
                            getTreeStatsAccumulator();
                        if (treeStatsAccumulator != null) {
                            nextIN.accumulateStats(treeStatsAccumulator);
                        }

                        return (BIN) nextIN;
                    } else {

                        /*
                         * We landed at an IN.  Descend down to the appropriate
                         * leaf (i.e. BIN) node.
                         */
                        IN ret = searchSubTree(nextIN, null,
                                               (forward ?
                                                SearchType.LEFT :
                                                SearchType.RIGHT),
                                               Node.NULL_NODE_ID,
                                               null,
                                               cacheMode);
                        nextINIsLatched = false;
                        parent.releaseLatch();
                        parent = null; // to avoid falsely unlatching parent

                        assert LatchSupport.countLatchesHeld() == 1:
                            LatchSupport.latchesHeldToString();

                        if (ret instanceof BIN) {
                            return (BIN) ret;
                        } else {
                            throw EnvironmentFailureException.unexpectedState
                                ("subtree did not have a BIN for leaf");
                        }
                    }
                }

                /* Nothing at this level.  Ascend to a higher level. */
                next = parent;
                nextIsLatched = true;
                parent = null; // to avoid falsely unlatching parent below
            }
        } catch (DatabaseException e) {

            if (next != null &&
                nextIsLatched) {
                next.releaseLatch();
            }

            if (parent != null) {
                parent.releaseLatch();
            }

            if (nextIN != null &&
                nextINIsLatched) {
                nextIN.releaseLatch();
            }

            throw e;
        }
    }

    /**
     * Split the root of the tree.
     */
    private void splitRoot(CacheMode cacheMode)
        throws DatabaseException {

        /*
         * Create a new root IN, insert the current root IN into it, and then
         * call split.
         */
        EnvironmentImpl env = database.getDbEnvironment();
        LogManager logManager = env.getLogManager();
        INList inMemoryINs = env.getInMemoryINs();

        IN curRoot = null;
        curRoot = (IN) root.fetchTarget(database, null);
        curRoot.latch(cacheMode);
        long curRootLsn = 0;
        long logLsn = 0;
        IN newRoot = null;
        try {

            /*
             * Make a new root IN, giving it an id key from the previous root.
             */
            byte[] rootIdKey = curRoot.getKey(0);
            newRoot = new IN(database, rootIdKey, maxMainTreeEntriesPerNode,
                             curRoot.getLevel() + 1);
            newRoot.latch(cacheMode);
            newRoot.setIsRoot(true);
            curRoot.setIsRoot(false);

            /*
             * Make the new root IN point to the old root IN. Log the old root
             * provisionally, because we modified it so it's not the root
             * anymore, then log the new root. We are guaranteed to be able to
             * insert entries, since we just made this root.
             */
            try {
                curRootLsn =
                    curRoot.optionalLogProvisional(logManager, newRoot);
                boolean insertOk = newRoot.insertEntry
                    (new ChildReference(curRoot, rootIdKey, curRootLsn));
                assert insertOk;

                logLsn = newRoot.optionalLog(logManager);
            } catch (DatabaseException e) {
                /* Something went wrong when we tried to log. */
                curRoot.setIsRoot(true);
                throw e;
            }
            inMemoryINs.add(newRoot);

            /*
             * Make the tree's root reference point to this new node. Now the
             * MapLN is logically dirty, but the change hasn't been logged.  Be
             * sure to flush the MapLN if we ever evict the root.
             */
            root.setTarget(newRoot);
            root.updateLsnAfterOptionalLog(database, logLsn);
            curRoot.split(newRoot, 0, maxMainTreeEntriesPerNode, cacheMode);
            root.setLsn(newRoot.getLastFullVersion());

        } finally {
            /* FindBugs ignore possible null pointer dereference of newRoot. */
            newRoot.releaseLatch();
            curRoot.releaseLatch();
        }
        rootSplits.increment();
        traceSplitRoot(Level.FINE, TRACE_ROOT_SPLIT, newRoot, logLsn,
                       curRoot, curRootLsn);
    }

    /**
     * Search the tree, starting at the root.  Depending on search type either
     * search using key, or search all the way down the right or left sides.
     * Stop the search either when the bottom of the tree is reached, or a node
     * matching nid is found (see below) in which case that node's parent is
     * returned.
     *
     * Preemptive splitting is not done during the search.
     *
     * @param key - the key to search for, or null if searchType is LEFT or
     * RIGHT.
     *
     * @param searchType - The type of tree search to perform.  NORMAL means
     * we're searching for key in the tree.  LEFT/RIGHT means we're descending
     * down the left or right side, resp.  DELETE means we're descending the
     * tree and will return the lowest node in the path that has > 1 entries.
     *
     * @param nid - The nodeid to search for in the tree.  If found, returns
     * its parent.  If the nodeid of the root is passed, null is returned.
     *
     * @param binBoundary - If non-null, information is returned about whether
     * the BIN found is the first or last BIN in the database.
     *
     * @return - the Node that matches the criteria, if any.  This is the node
     * that is farthest down the tree with a match.  Returns null if the root
     * is null.  Node is latched (unless it's null) and must be unlatched by
     * the caller.  Only IN's and BIN's are returned, not LN's.  In a NORMAL
     * search, It is the caller's responsibility to do the findEntry() call on
     * the key and BIN to locate the entry that matches key.  The return value
     * node is latched upon return and it is the caller's responsibility to
     * unlatch it.
     */
    public IN search(byte[] key,
                     SearchType searchType,
                     long nid,
                     BINBoundary binBoundary,
                     CacheMode cacheMode)
        throws DatabaseException {

        IN rootIN = getRootIN(cacheMode);

        if (rootIN != null) {
            return searchSubTree
                (rootIN, key, searchType, nid, binBoundary, cacheMode);
        } else {
            return null;
        }
    }

    /**
     * Do a key based search, permitting pre-emptive splits. Returns the
     * target node's parent.
     */
    public IN searchSplitsAllowed(byte[] key, long nid, CacheMode cacheMode)
        throws DatabaseException {

        IN insertTarget = null;
        while (insertTarget == null) {
            rootLatch.acquireShared();
            boolean rootLatched = true;
            boolean rootLatchedExclusive = false;
            boolean rootINLatched = false;
            boolean success = false;
            IN rootIN = null;
            try {
                while (true) {
                    if (rootExists()) {
                        rootIN = (IN) root.fetchTarget(database, null);

                        /* Check if root needs splitting. */
                        if (rootIN.needsSplitting()) {
                            if (!rootLatchedExclusive) {
                                rootIN = null;
                                rootLatch.release();
                                rootLatch.acquireExclusive();
                                rootLatchedExclusive = true;
                                continue;
                            }
                            splitRoot(cacheMode);

                            /*
                             * We can't hold any latches while we lock.  If the
                             * root splits again between latch release and
                             * DbTree.db lock, no problem.  The latest root
                             * will still get written out.
                             */
                            rootLatch.release();
                            rootLatched = false;
                            EnvironmentImpl env = database.getDbEnvironment();
                            env.getDbTree().optionalModifyDbRoot(database);
                            rootLatched = true;
                            rootLatch.acquireExclusive();
                            rootIN = (IN) root.fetchTarget(database, null);
                            rootIN.latch(cacheMode);
                        } else {
                            rootIN.latchShared(cacheMode);
                        }
                        rootINLatched = true;
                    }
                    break;
                }
                success = true;
            } finally {
                if (!success && rootINLatched) {
                    rootIN.releaseLatch();
                }
                if (rootLatched) {
                    rootLatch.release();
                }
            }

            /* Don't loop forever if the root is null. [#13897] */
            if (rootIN == null) {
                break;
            }

            try {
                assert rootINLatched;
                while (true) {
                    try {
                        insertTarget =
                            searchSubTreeSplitsAllowed(rootIN, key,
                                                       nid, cacheMode);
                        break;
                    } catch (RelatchRequiredException RRE) {
                        relatchesRequired.increment();
                        database.getDbEnvironment().incRelatchesRequired();
                        rootLatch.acquireExclusive();
                        rootIN = (IN) root.fetchTarget(database, null);
                        rootIN.latch(cacheMode);
                        rootLatch.release();
                        continue;
                    }
                }
            } catch (SplitRequiredException e) {

                /*
                 * The last slot in the root was used at the point when this
                 * thread released the rootIN latch in order to force splits.
                 * Retry. SR [#11147].
                 */
                continue;
            }
        }

        return insertTarget;
    }

    public void loadStats(StatsConfig config, BtreeStats btreeStats) {
        /* Add the tree statistics to BtreeStats. */
        btreeStats.setTreeStats(stats.cloneGroup(false));

        if (config.getClear()) {
            relatchesRequired.clear();
        }
    }

    /**
     * Wrapper for searchSubTreeInternal that does a restart if a
     * RelatchRequiredException is thrown (i.e. a relatch of the root is
     * needed).
     */
    public IN searchSubTree(IN parent,
                            byte[] key,
                            SearchType searchType,
                            long nid,
                            BINBoundary binBoundary,
                            CacheMode cacheMode)
        throws DatabaseException {

        /*
         * Max of two iterations required.  First is root latched shared, and
         * second is root latched exclusive.
         */
        for (int i = 0; i < 2; i++) {
            try {
                return searchSubTreeInternal(parent, key, searchType, nid,
                                             binBoundary, cacheMode);
            } catch (RelatchRequiredException RRE) {

                /*
                 * The original parent param was the DB root IN if this
                 * exception occurs, so latch it exclusively and retry.  If a
                 * DIN root or an intermediate IN (from getNextBinInternal) was
                 * originally passed, it was latched exclusively and this can't
                 * happen.  However, we cannot assert here that the original
                 * parent is the root IN because no latches are held and a
                 * split can happen concurrently.
                 */
                parent = getRootINLatchedExclusive(cacheMode);
            }
        }

        throw EnvironmentFailureException.unexpectedState
            ("searchSubTreeInternal should have completed in two tries");
    }

    /**
     * Searches a portion of the tree starting at parent using key.  If during
     * the search a node matching a non-null nid argument is found, its parent
     * is returned.  If searchType is NORMAL, then key must be supplied to
     * guide the search.  If searchType is LEFT (or RIGHT), then the tree is
     * searched down the left (or right) side to find the first (or last) leaf,
     * respectively.
     * <p>
     * Enters with parent latched, assuming it's not null.  Exits with the
     * return value latched, assuming it's not null.
     * <p>
     * @param parent - the root of the subtree to start the search at.  This
     * node should be latched by the caller and will be unlatched prior to
     * return.
     *
     * @param key - the key to search for, unless searchType is LEFT or RIGHT
     *
     * @param searchType - NORMAL means search using key and, optionally, nid.
     *                     LEFT means find the first (leftmost) leaf
     *                     RIGHT means find the last (rightmost) leaf
     *
     * @param nid - The nodeid to search for in the tree.  If found, returns
     * its parent.  If the nodeid of the root is passed, null is returned.
     * Pass Node.NULL_NODE_ID if no nodeid based search is desired.
     *
     * @return - the node matching the argument criteria, or null.  The node is
     * latched and must be unlatched by the caller.  The parent argument and
     * any other nodes that are latched during the search are unlatched prior
     * to return.
     *
     * @throws RelatchRequiredException if the root node (parent) must be
     * relatched exclusively because a null target was encountered (i.e. a
     * fetch must be performed on parent's child and the parent is latched
     * shared.
     */
    private IN searchSubTreeInternal(IN parent,
                                     byte[] key,
                                     SearchType searchType,
                                     long nid,
                                     BINBoundary binBoundary,
                                     CacheMode cacheMode)
        throws RelatchRequiredException, DatabaseException {

        /* Return null if we're passed a null arg. */
        if (parent == null) {
            return null;
        }

        if ((searchType == SearchType.LEFT ||
             searchType == SearchType.RIGHT) &&
            key != null) {

            /*
             * If caller is asking for a right or left search, they shouldn't
             * be passing us a key.
             */
            throw EnvironmentFailureException.unexpectedState
                ("searchSubTree passed key and left/right search");
        }

        assert parent.isLatchOwnerForRead();

        if (parent.getNodeId() == nid) {
            parent.releaseLatch();
            return null;
        }

        if (binBoundary != null) {
            binBoundary.isLastBin = true;
            binBoundary.isFirstBin = true;
        }

        int index;
        IN child = null;
        IN grandParent = null;
        boolean childIsLatched = false;
        boolean grandParentIsLatched = false;
        boolean maintainGrandParentLatches = !parent.isLatchOwnerForWrite();

        TreeWalkerStatsAccumulator treeStatsAccumulator =
            getTreeStatsAccumulator();

        boolean success = false;
        try {
            do {
                if (treeStatsAccumulator != null) {
                    parent.accumulateStats(treeStatsAccumulator);
                }

                if (parent.getNEntries() == 0) {
                    /* No more children, can't descend anymore. */
                    success = true;
                    return parent;
                } else if (searchType == SearchType.NORMAL) {
                    /* Look for the entry matching key in the current node. */
                    index = parent.findEntry(key, false, false);
                } else if (searchType == SearchType.LEFT) {
                    /* Left search, always take the 0th entry. */
                    index = 0;
                } else if (searchType == SearchType.RIGHT) {
                    /* Right search, always take the highest entry. */
                    index = parent.getNEntries() - 1;
                } else {
                    throw EnvironmentFailureException.unexpectedState
                        ("Invalid value of searchType: " + searchType);
                }

                assert index >= 0;

                if (binBoundary != null) {
                    if (index != parent.getNEntries() - 1) {
                        binBoundary.isLastBin = false;
                    }
                    if (index != 0) {
                        binBoundary.isFirstBin = false;
                    }
                }

                /*
                 * Get the child node.  If target is null, and we don't have
                 * parent latched exclusively, then we need to relatch this
                 * parent so that we can fill in the target.  Fetching a target
                 * is a write to a node so it must be exclusively latched.
                 * Once we have the parent relatched exclusively, then we can
                 * release the grand parent.
                 */
                if (maintainGrandParentLatches &&
                    parent.getTarget(index) == null &&
                    !parent.isAlwaysLatchedExclusively()) {

                    if (grandParent == null) {

                        /*
                         * grandParent is null which implies parent is the root
                         * so throw RelatchRequiredException.
                         */
                        throw
                            RelatchRequiredException.relatchRequiredException;
                    } else {
                        /* Release parent shared and relatch exclusive. */
                        parent.releaseLatch();
                        parent.latch(cacheMode);
                    }

                    /*
                     * Once parent has been re-latched exclusive we can release
                     * grandParent now (sooner), rather than after the
                     * fetchTarget (later).
                     */
                    if (grandParent != null) {
                        grandParent.releaseLatch();
                        grandParentIsLatched = false;
                        grandParent = null;
                    }
                }
                child = (IN) parent.fetchTarget(index);

                /*
                 * We know we're done with grandParent for sure, so release
                 * now.
                 */
                if (grandParent != null) {
                    grandParent.releaseLatch();
                    grandParentIsLatched = false;
                }

                /* See if we're even using shared latches. */
                if (maintainGrandParentLatches) {
                    child.latchShared(cacheMode);
                } else {
                    child.latch(cacheMode);
                }
                childIsLatched = true;

                if (treeStatsAccumulator != null) {
                    child.accumulateStats(treeStatsAccumulator);
                }

                /*
                 * If this child matches nid, then stop the search and return
                 * the parent.
                 */
                if (child.getNodeId() == nid) {
                    child.releaseLatch();
                    childIsLatched = false;
                    success = true;
                    return parent;
                }

                /* Continue down a level */
                if (maintainGrandParentLatches) {
                    grandParent = parent;
                    grandParentIsLatched = true;
                } else {
                    parent.releaseLatch();
                }
                parent = child;
            } while (!(parent instanceof BIN));

            success = true;
            return child;
        } finally {
            if (!success) {

                /*
                 * In [#14903] we encountered a latch exception below and the
                 * original exception was lost.  Print the stack trace and
                 * allow the original exception to be thrown if this happens
                 * again, to get more information about the problem.
                 */
                try {
                    if (child != null &&
                        childIsLatched) {
                        child.releaseLatch();
                    }

                    if (parent != child) {
                        parent.releaseLatch();
                    }
                } catch (Exception t2) {
                    t2.printStackTrace();
                }
            }

            if (grandParent != null &&
                grandParentIsLatched) {
                grandParent.releaseLatch();
                grandParentIsLatched = false;
            }
        }
    }

    /**
     * Search down the tree using a key, but instead of returning the BIN that
     * houses that key, find the point where we can detach a deletable
     * subtree. A deletable subtree is a branch where each IN has one child,
     * and the bottom BIN has no entries and no resident cursors. That point
     * can be found by saving a pointer to the lowest node in the path with
     * more than one entry.
     *
     *              INa
     *             /   \
     *          INb    INc
     *          |       |
     *         INd     ..
     *         / \
     *      INe  ..
     *       |
     *     BINx (suspected of being empty)
     *
     * In this case, we'd like to prune off the subtree headed by INe. INd
     * is the parent of this deletable subtree. As we descend, we must keep
     * latches for all the nodes that will be logged. In this case, we
     * will need to keep INa, INb and INd latched when we return from this
     * method.
     *
     * The method returns a list of parent/child/index structures. In this
     * example, the list will hold:
     *  INa/INb/index
     *  INb/INd/index
     *  INd/INe/index
     * Every node is latched, and every node except for the bottom most child
     * (INe) must be logged.
     */
    public void searchDeletableSubTree(IN parent,
                                       byte[] key,
                                       ArrayList<SplitInfo> nodeLadder)
        throws DatabaseException,
               NodeNotEmptyException,
               CursorsExistException {

        assert (parent!=null);
        assert (key!= null);
        assert parent.isLatchOwnerForWrite();

        int index;
        IN child = null;

        /* Save the lowest IN in the path that has multiple entries. */
        IN lowestMultipleEntryIN = null;

        do {
            if (parent.getNEntries() == 0) {
                break;
            }

            /* Remember if this is the lowest multiple point. */
            if (parent.getNEntries() > 1) {
                lowestMultipleEntryIN = parent;
            }

            index = parent.findEntry(key, false, false);
            assert index >= 0;

            /* Get the child node that matches. */
            child = (IN) parent.fetchTargetWithExclusiveLatch(index);
            child.latch(CacheMode.UNCHANGED);
            nodeLadder.add(new SplitInfo(parent, child, index));

            /* Continue down a level */
            parent = child;
        } while (!(parent instanceof BIN));

        /*
         * See if there is a reason we can't delete this BIN -- i.e.
         * new items have been inserted, or a cursor exists on it.
         */
        if ((child != null) && (child instanceof BIN)) {
            if (child.getNEntries() != 0) {
                throw NodeNotEmptyException.NODE_NOT_EMPTY;
            }

            /*
             * This case can happen if we are keeping a BIN on an empty
             * cursor as we traverse.
             */
            if (((BIN) child).nCursors() > 0) {
                throw CursorsExistException.CURSORS_EXIST;
            }
        }

        if (lowestMultipleEntryIN != null) {

            /*
             * Release all nodes up to the pair that holds the detach
             * point. We won't be needing those nodes, since they'll be
             * pruned and won't need to be updated.
             */
            ListIterator<SplitInfo> iter =
                nodeLadder.listIterator(nodeLadder.size());
            while (iter.hasPrevious()) {
                SplitInfo info = iter.previous();
                if (info.parent == lowestMultipleEntryIN) {
                    break;
                } else {
                    info.child.releaseLatch();
                    iter.remove();
                }
            }
        } else {

            /*
             * We actually have to prune off the entire tree. Release
             * all latches, and clear the node ladder.
             */
            releaseNodeLadderLatches(nodeLadder);
            nodeLadder.clear();
        }
    }

    /**
     * Search the portion of the tree starting at the parent, permitting
     * preemptive splits.
     *
     * When this returns, parent will be unlatched unless parent is the
     * returned IN.
     */
    private IN searchSubTreeSplitsAllowed(IN parent,
                                          byte[] key,
                                          long nid,
                                          CacheMode cacheMode)
        throws RelatchRequiredException,
               DatabaseException,
               SplitRequiredException {

        if (parent != null) {

            /*
             * Search downward until we hit a node that needs a split. In that
             * case, retreat to the top of the tree and force splits downward.
             */
            while (true) {
                try {
                    return searchSubTreeUntilSplit
                        (parent, key, nid, cacheMode);
                } catch (SplitRequiredException e) {
                    /* SR [#11144]*/
                    assert TestHookExecute.doHookIfSet(waitHook);

                    /*
                     * ForceSplit may itself throw SplitRequiredException if it
                     * finds that the parent doesn't have room to hold an extra
                     * entry. Allow the exception to propagate up to a place
                     * where it's safe to split the parent. We do this rather
                     * than
                     */
                    parent = forceSplit(parent, key, cacheMode);
                }
            }
        } else {
            return null;
        }
    }

    /**
     * Search the subtree, but throw an exception when we see a node
     * that has to be split.
     *
     * When this returns, parent will be unlatched unless parent is the
     * returned IN.
     */
    private IN searchSubTreeUntilSplit(IN parent,
                                       byte[] key,
                                       long nid,
                                       CacheMode cacheMode)
        throws RelatchRequiredException,
               DatabaseException,
               SplitRequiredException {

        boolean latchingIsExclusive = parent.isLatchOwnerForWrite();

        if (parent.getNodeId() == nid) {
            parent.releaseLatch();
            return null;
        }

        int index;
        IN child = null;
        boolean childIsLatched = false;
        boolean success = false;

        try {
            do {
                if (parent.getNEntries() == 0) {
                    /* No more children, can't descend anymore. */
                    success = true;
                    return parent;
                } else {
                    /* Look for the entry matching key in the current node. */
                    index = parent.findEntry(key, false, false);
                }

                assert index >= 0;

                /* Get the child node that matches. */
                child = (IN) parent.fetchTarget(index);
                if (latchingIsExclusive ||
                    child.isAlwaysLatchedExclusively()) {
                    child.latch(cacheMode);
                } else {
                    child.latchShared(cacheMode);
                }
                childIsLatched = true;

                /* Throw if we need to split. */
                if (child.needsSplitting()) {
                    /* Let the finally clean up child and parent latches. */
                    throw splitRequiredException;
                }

                /*
                 * If this child matches nid, then stop the search and return
                 * the parent.
                 */
                if (child.getNodeId() == nid) {
                    child.releaseLatch();
                    childIsLatched = false;
                    success = true;
                    return parent;
                }

                /* Continue down a level */
                parent.releaseLatch();
                parent = child;
            } while (!(parent instanceof BIN));
            success = true;
            return parent;
        } finally {
            if (!success) {
                if (child != null &&
                    childIsLatched) {
                    child.releaseLatch();
                }
                if (parent != child) {
                    parent.releaseLatch();
                }
            }
        }
    }

    /**
     * Do pre-emptive splitting in the subtree topped by the "parent" node.
     * Search down the tree until we get to the BIN level, and split any nodes
     * that fit the splittable requirement.
     *
     * Note that more than one node in the path may be splittable. For example,
     * a tree might have a level2 IN and a BIN that are both splittable, and
     * would be encountered by the same insert operation.
     *
     * @return the parent to use for retrying the search, which may be
     * different than the parent parameter passed if the root IN has been
     * evicted.
     */
    private IN forceSplit(IN parent, byte[] key, CacheMode cacheMode)
        throws DatabaseException, SplitRequiredException {

        ArrayList<SplitInfo> nodeLadder = new ArrayList<SplitInfo>();

        boolean allLeftSideDescent = true;
        boolean allRightSideDescent = true;
        int index;
        IN child = null;
        IN originalParent = parent;
        ListIterator<SplitInfo> iter = null;

        boolean isRootLatched = false;
        boolean success = false;
        try {

            /*
             * Latch the root in order to update the root LSN when we're done.
             * Latch order must be: root, root IN.  We'll leave this method
             * with the original parent latched.
             *
             * Although we are checking isDbRoot without latching, if it
             * changes (if the root is split) we'll detect this below and throw
             * splitRequiredException.  Note that this property can change from
             * true to false, but never from false to true.
             */
            if (originalParent.isDbRoot()) {
                rootLatch.acquireExclusive();
                isRootLatched = true;
                /* The root IN may have been evicted. [#16173] */
                parent = (IN) root.fetchTarget(database, null);
                originalParent = parent;
            }
            originalParent.latch(cacheMode);

            /*
             * Another thread may have crept in and
             *  - used the last free slot in the parent, making it impossible
             *    to correctly progagate the split.
             *  - actually split the root, in which case we may be looking at
             *    the wrong subtree for this search.
             * If so, throw and retry from above. SR [#11144]
             */
            if (originalParent.needsSplitting() || !originalParent.isRoot()) {
                throw splitRequiredException;
            }

            /*
             * Search downward to the BIN level, saving the information
             * needed to do a split if necessary.
             */
            do {
                if (parent.getNEntries() == 0) {
                    /* No more children, can't descend anymore. */
                    break;
                } else {
                    /* Look for the entry matching key in the current node. */
                    index = parent.findEntry(key, false, false);
                    if (index != 0) {
                        allLeftSideDescent = false;
                    }
                    if (index != (parent.getNEntries() - 1)) {
                        allRightSideDescent = false;
                    }
                }

                assert index >= 0;

                /*
                 * Get the child node that matches. We only need to work on
                 * nodes in residence.
                 */
                child = (IN) parent.getTarget(index);
                if (child == null) {
                    break;
                } else {
                    child.latch(cacheMode);
                    nodeLadder.add(new SplitInfo(parent, child, index));
                }

                /* Continue down a level */
                parent = child;
            } while (!(parent instanceof BIN));

            boolean startedSplits = false;
            LogManager logManager =
                database.getDbEnvironment().getLogManager();

            /*
             * Process the accumulated nodes from the bottom up. Split each
             * node if required. If the node should not split, we check if
             * there have been any splits on the ladder yet. If there are none,
             * we merely release the node, since there is no update.  If splits
             * have started, we need to propagate new LSNs upward, so we log
             * the node and update its parent.
             *
             * Start this iterator at the end of the list.
             */
            iter = nodeLadder.listIterator(nodeLadder.size());
            long lastParentForSplit = Node.NULL_NODE_ID;
            while (iter.hasPrevious()) {
                SplitInfo info = iter.previous();

                /*
                 * Get rid of current entry on nodeLadder so it doesn't get
                 * unlatched in the finally clause.
                 */
                iter.remove();
                child = info.child;
                parent = info.parent;
                index = info.index;

                /* Opportunistically split the node if it is full. */
                if (child.needsSplitting()) {
                    int maxEntriesPerNode = (child.containsDuplicates() ?
                                             maxDupTreeEntriesPerNode :
                                             maxMainTreeEntriesPerNode);
                    if (allLeftSideDescent || allRightSideDescent) {
                        child.splitSpecial(parent,
                                           index,
                                           maxEntriesPerNode,
                                           key,
                                           allLeftSideDescent,
                                           cacheMode);
                    } else {
                        child.split(parent, index, maxEntriesPerNode,
                                    cacheMode);
                    }
                    lastParentForSplit = parent.getNodeId();
                    startedSplits = true;

                    /*
                     * If the DB root IN was logged, update the DB tree's child
                     * reference.  Now the MapLN is logically dirty, but the
                     * change hasn't been logged. Set the rootIN to be dirty
                     * again, to force flushing the rootIN and mapLN in the
                     * next checkpoint. Be sure to flush the MapLN
                     * if we ever evict the root.
                     */
                    if (parent.isDbRoot()) {
                        assert isRootLatched;
                        root.setLsn(parent.getLastFullVersion());
                        parent.setDirty(true);
                    }
                } else {
                    if (startedSplits) {
                        long newLsn = 0;

                        /*
                         * If this child was the parent of a split, it's
                         * already logged by the split call. We just need to
                         * propagate the logging upwards. If this child is just
                         * a link in the chain upwards, log it.
                         */
                        if (lastParentForSplit == child.getNodeId()) {
                            newLsn = child.getLastFullVersion();
                        } else {
                            newLsn = child.optionalLog(logManager);
                        }
                        parent.updateEntry(index, newLsn);
                    }
                }
                child.releaseLatch();
                child = null;
            }
            success = true;
        } finally {
            if (!success) {

                /*
                 * This will only happen if an exception is thrown and we leave
                 * things in an intermediate state.
                 */
                if (child != null) {
                    child.releaseLatch();
                }

                if (nodeLadder.size() > 0) {
                    iter = nodeLadder.listIterator(nodeLadder.size());
                    while (iter.hasPrevious()) {
                        SplitInfo info = iter.previous();
                        info.child.releaseLatch();
                    }
                }

                originalParent.releaseLatch();
            }

            if (isRootLatched) {
                rootLatch.release();
            }
        }
        return originalParent;
    }

    /**
     * Helper to obtain the root IN with shared root latching.  Optionally
     * updates the generation of the root when latching it.
     */
    public IN getRootIN(CacheMode cacheMode)
        throws DatabaseException {

        return getRootINInternal(cacheMode, false/*exclusive*/);
    }

    /**
     * Helper to obtain the root IN with exclusive root latching.  Optionally
     * updates the generation of the root when latching it.
     */
    public IN getRootINLatchedExclusive(CacheMode cacheMode)
        throws DatabaseException {

        return getRootINInternal(cacheMode, true/*exclusive*/);
    }

    private IN getRootINInternal(CacheMode cacheMode, boolean exclusive)
        throws DatabaseException {

        rootLatch.acquireShared();
        IN rootIN = null;
        try {
            if (rootExists()) {
                rootIN = (IN) root.fetchTarget(database, null);
                if (exclusive) {
                    rootIN.latch(cacheMode);
                } else {
                    rootIN.latchShared(cacheMode);
                }
            }
            return rootIN;
        } finally {
            rootLatch.release();
        }
    }

    public IN getResidentRootIN(boolean latched)
        throws DatabaseException {

        IN rootIN = null;
        if (rootExists()) {
            rootIN = (IN) root.getTarget();
            if (rootIN != null && latched) {
                rootIN.latchShared(CacheMode.UNCHANGED);
            }
        }
        return rootIN;
    }

    /**
     * Inserts a new LN into the tree.
     * @param ln The LN to insert into the tree.
     * @param key Key value for the node
     * @param allowDuplicates whether to allow duplicates to be inserted
     * @param cursor the cursor to update to point to the newly inserted
     * key/data pair, or null if no cursor should be updated.
     * @return true if LN was inserted, false if it was a duplicate
     * duplicate or if an attempt was made to insert a duplicate when
     * allowDuplicates was false.
     *
     * @throws IllegalArgumentException via db/cursor put methods
     */
    public boolean insert(LN ln,
                          byte[] key,
                          boolean allowDuplicates,
                          CursorImpl cursor,
                          LockResult lnLock,
                          ReplicationContext repContext) {

        try {
            /* Find, latch and move cursor to the relevant BIN. */
            findBinForInsert(key, cursor);
            assert cursor.getBIN().isLatchOwnerForWrite();

            /* If we can insert the LN in a new slot in the BIN, we're done. */
            if (insertNewSlot(ln, key, cursor, lnLock, repContext)) {
                return true;
            }

            /*
             * Now get enough info to decide whether to reuse an existing slot
             * containing a deleted entry.
             */
            SlotReuseInfo slotInfo = getSlotReuseInfo(ln, key, cursor);

            /* If we can reuse an existing slot, we're done. */
            if (slotInfo.slotReuseAllowed) {
                reuseExistingSlot(ln, key, cursor, lnLock, repContext,
                                  slotInfo);
                return true;
            }

            /*
             * Insert a duplicate in an existing dup tree, or create a dup tree
             * if none exists.
             */
            return insertDuplicate(ln, key, allowDuplicates, cursor, lnLock,
                                   repContext, slotInfo.originalLNData);
        } finally {
            cursor.releaseBIN();
        }
    }

    /**
     * Attempt to insert a new slot (meaning a new key) in the BIN and return
     * true if successful.  If false is returned, then an existing slot with
     * the new LN's key was found, and the cursor will be set to the index of
     * that slot.
     */
    private boolean insertNewSlot(final LN ln,
                                  final byte[] key,
                                  final CursorImpl cursor,
                                  final LockResult lnLock,
                                  final ReplicationContext repContext) {
        final EnvironmentImpl env = database.getDbEnvironment();
        
        /* Make a child reference as a candidate for insertion. */
        final ChildReference newLNRef =
            new ChildReference(ln, key, DbLsn.NULL_LSN);

        final BIN bin = cursor.getBIN();
        int index = bin.insertEntry1(newLNRef);
        if ((index & IN.INSERT_SUCCESS) == 0) {

            /*
             * Entry may have been a duplicate. Insertion was not successful.
             * Move cursor to potential duplicate index before returning.
             */
            cursor.updateBin(bin, index & ~IN.EXACT_MATCH);
            return false;
        }

        /*
         * Update the cursor to point to the entry that has been successfully
         * inserted.
         */
        index &= ~IN.INSERT_SUCCESS;
        cursor.updateBin(bin, index);

        /* Log the new LN. */
        long newLsn = DbLsn.NULL_LSN;
        try {
            newLsn = ln.optionalLog
                (env, database, key, DbLsn.NULL_LSN,
                 cursor.getLocker(), repContext);
        } finally {
            if ((newLsn == DbLsn.NULL_LSN) &&
                !database.isDeferredWriteMode()) {

                /*
                 * Possible buffer overflow, out-of-memory, or I/O exception
                 * during logging.  The BIN entry will contain a NULL_LSN.  To
                 * prevent an exception during a fetch, we set the KnownDeleted
                 * flag.  We do not call BIN.deleteEntry because cursors will
                 * not be adjusted.  We do not add this entry to the compressor
                 * queue to avoid complexity (this is rare).
                 * [13126, 12605, 11271]
                 */
                bin.setKnownDeleted(index);
            }
        }
        lnLock.setAbortLsn(DbLsn.NULL_LSN, true, true);
        bin.updateEntry(index, newLsn);

        traceInsert(Level.FINER, env, bin, ln, newLsn, index);
        return true;
    }

    /**
     * Replaces the contents of the existing slot (at the cursor position) with
     * the new LN.
     */
    private void reuseExistingSlot(final LN ln,
                                   final byte[] key,
                                   final CursorImpl cursor,
                                   final LockResult lnLock,
                                   final ReplicationContext repContext,
                                   final SlotReuseInfo slotInfo) {
        final EnvironmentImpl env = database.getDbEnvironment();

        if (slotInfo.isExistingLock) {
            /* Copy the size/DatabaseImpl of the existing lock. */
            lnLock.copyAbortInfo(slotInfo.existingLockInfo);
        }
        lnLock.setAbortLsn(slotInfo.abortLsn, slotInfo.abortKnownDeleted);

        /*
         * Current entry is a deleted entry. Replace it with LN.  Pass NULL_LSN
         * for the oldLsn parameter of the log() method because the old LN was
         * counted obsolete when it was deleted.
         */
        final long newLsn = ln.optionalLog(env,
                                           database,
                                           key,
                                           DbLsn.NULL_LSN,
                                           cursor.getLocker(),
                                           repContext);

        /*
         * When reusing a slot, the key is replaced in the BIN slot.  This
         * ensures that the correct key value is used when the new key is
         * non-identical to the key in the slot but is considered equal by the
         * btree comparator.
         * [#15704]
         */
        final BIN bin = cursor.getBIN();
        final int index = cursor.getIndex();
        bin.updateEntry(index, ln, newLsn, key);
        bin.clearKnownDeleted(index);
        bin.clearPendingDeleted(index);

        traceInsert(Level.FINER, env, bin, ln, newLsn, index);
    }

    /* Holds information during insert to evaluate potential slot reuse. */
    private class SlotReuseInfo {

        /* Slot can be reused for new LN. */
        boolean slotReuseAllowed;

        /* Lock on deleted/existing LN is held by current locker. */
        boolean isExistingLock;

        /* If isExistingLock, contains info for existing write lock. */
        WriteLockInfo existingLockInfo;

        /* Abort information for LN in existing slot. */
        long abortLsn;
        boolean abortKnownDeleted;

        /* Data (DBIN key) for original version, if not deleted. */
        byte[] originalLNData;
    }

    /**
     * Returns information about whether the slot at the cursor position can be
     * reused for a new LN.  When called, the slot at the cursor position has
     * the same key as the new LN.  On return, the cursor BIN and index may be
     * update if they changed while attempting to lock the LN.
     *
     * Returns true if the existing slot contains a deleted LN, or the remnant
     * of a cleaned LN or DIN, and the slot may be used for the new LN.
     * Returns false if the slot contains a non-deleted LN or a live DIN.
     *
     * If SlotReuseInfo.slotReuseAllowed is true on return, then abort info for
     * the deleted LN is also returned (SlotReuseInfo.abortLsn and
     * abortKnownDeleted).  In this case the isExistingLock and
     * existingLockInfo fields are also returned.
     *
     * If slotReuseAllowed is false on return, SlotReuseInfo.originalLNData is
     * also returned in spite of the fact that the current LN in the slot is
     * deleted (and has no data).  originalLNData must be used as the DBIN key
     * for the existing LN when creating a dup tree.  Note that if the original
     * version is deleted or there is none, and the current LN is deleted, then
     * originalLNData cannot be determined; but in this case slotReuseAllowed
     * will be true and therefore creation of a DIN/DBIN is not needed.
     */
    private SlotReuseInfo getSlotReuseInfo(final LN ln,
                                           final byte[] key,
                                           final CursorImpl cursor) {
        final EnvironmentImpl env = database.getDbEnvironment();
        BIN bin = cursor.getBIN();
        int index = cursor.getIndex();

        /*
         * The key in the BIN slot and the key of the new LN may be
         * non-identical but compare as equal by the btree comparator.
         * This is disallowed for databases with duplicates configured.
         * [#15704]
         */
        if (database.getSortedDuplicates() &&
            database.getBtreeComparator() != null &&
            !Arrays.equals(key, bin.getKey(index))) {
            throw new IllegalArgumentException
                ("Custom Btree comparator matches two non-identical " +
                 "keys in a Database with duplicates configured");
        }

        LN currentLN = null;
        boolean isDup = false;
        final Node node = bin.fetchTarget(index);
        if (node == null || node instanceof LN) {
            currentLN = (LN) node;
        } else {
            isDup = true;
        }

        /* If an LN is present, lock it and check deleted-ness. */
        boolean isDeleted = false;
        LockResult currentLock = null;

        if (!isDup) {
            if (currentLN == null) {
                /* The LN was cleaned. */
                isDeleted = true;
            } else {
                currentLock = cursor.lockLNDeletedAllowed
                    (currentLN, LockType.WRITE);
                currentLN = currentLock.getLN();
                /* The BIN/index may have changed while locking. */
                bin = cursor.getBIN();
                index = cursor.getIndex();
                if (cursor.getDupBIN() != null) {

                    /*
                     * A dup tree appeared during locking.  We will
                     * position to a different dup tree entry later in
                     * insertDuplicate, so we must remove the cursor
                     * from this dup tree entry.  This is a rare case
                     * so performance is not an issue.
                     */
                    cursor.clearDupBIN(true /*alreadyLatched*/);
                    isDup = true;
                } else if (bin.isEntryKnownDeleted(index) ||
                           currentLN == null ||
                           currentLN.isDeleted()) {
                    /* The current LN is deleted/cleaned. */
                    isDeleted = true;
                }
            }
        }

        /* Initialize slot info. */
        final SlotReuseInfo slotInfo = new SlotReuseInfo();
        slotInfo.slotReuseAllowed = false;
        slotInfo.isExistingLock = false;
        slotInfo.existingLockInfo = null;
        slotInfo.abortLsn = DbLsn.NULL_LSN;
        slotInfo.abortKnownDeleted = false;
        slotInfo.originalLNData =
            (currentLN != null) ? currentLN.getData() : null;

        /* If the slot is in use, we're done. */
        if (!isDeleted) {
            return slotInfo;
        }

        slotInfo.slotReuseAllowed = true;
        slotInfo.isExistingLock = (currentLN != null &&
            currentLock.getLockGrant() == LockGrantType.EXISTING);

        /*
         * Set the abort LSN to that of the lock held on the
         * current LN, if the current LN was previously locked by
         * this txn.  This is needed when we change the node ID of
         * this slot.
         *
         * If reusing a slot with a deleted LN deleted in a prior
         * transaction (the LockGrantType is NEW or UPGRADE),
         * always set abortKnownDeleted=true.  It may be that the
         * existing slot is PENDING_DELETED, but we restore to
         * KNOWN_DELETED in the event of an abort.
         */
        slotInfo.abortLsn = bin.getLsn(index);
        slotInfo.abortKnownDeleted = true;
        if (slotInfo.isExistingLock) {
            final long nodeId = currentLN.getNodeId();
            final Locker locker = cursor.getLocker();
            slotInfo.existingLockInfo = locker.getWriteLockInfo(nodeId);
            slotInfo.abortLsn = slotInfo.existingLockInfo.getAbortLsn();
            slotInfo.abortKnownDeleted =
                slotInfo.existingLockInfo.getAbortKnownDeleted();
        }

        /*
         * For a deleted/cleaned LN, we can always reuse the slot (by
         * setting isDeleted to true) if the database does not contain
         * dups, because only the key identifies the record/slot.
         * Otherwise (for a dups DB), one of the following must be true to
         * reuse the slot:
         * 1. The data (dup key) of the prior committed version is equal to the
         *    data of the new LN.  If the deleted LN has different data, it is
         *    considered a different record and reusing the slot would
         *    incorrectly set the abortLsn.  Because the current LN is deleted,
         *    we must get its data by fetching the LN at the abort LSN.
         * 2. The last committed version of the record is deleted. In this case
         *    it may be impossible to get the data (the prior version may be
         *    cleaned), so no comparison is possible.  Fortunately, reusing a
         *    slot when the prior committed version is deleted won't cause a
         *    problem if the txn aborts.  Even though the abortLsn may belong
         *    to a different dup key, the residual slot will have knownDeleted
         *    set, i.e., will be ignored.
         * FOR DETAILS SEE: DupSlotReuseTest [#18937]
         */
        if (database.getSortedDuplicates() &&
            !slotInfo.abortKnownDeleted &&
            slotInfo.abortLsn != DbLsn.NULL_LSN) {
            final LN originalLN;
            try {
                originalLN = (LN)
                    env.getLogManager().getEntry(slotInfo.abortLsn);
            } catch (FileNotFoundException e) {
                throw
                    EnvironmentFailureException.unexpectedException
                    ("Prior non-deleted version was cleaned", e);
            }
            if (originalLN.isDeleted()) {
                throw EnvironmentFailureException.unexpectedState
                    ("Prior version is deleted, abortLsn=" +
                     DbLsn.getNoFormatString(slotInfo.abortLsn));
            }
            slotInfo.originalLNData = originalLN.getData();
            if (Key.compareKeys
                 (ln.getData(), slotInfo.originalLNData,
                  database.getDuplicateComparator()) != 0) {
                slotInfo.slotReuseAllowed = false;
            }
        }

        return slotInfo;
    }

    /**
     * Attempts to insert a duplicate at the current cursor BIN position.  If
     * an existing dup tree exists, insert into it; otherwise, create a new
     * dup tree and place the new LN and the existing LN into it.  If the
     * current BIN entry contains an LN, the caller guarantees that it is not
     * deleted.
     *
     * @return true if duplicate inserted successfully, false if it was a
     * duplicate duplicate, false if a there is an existing LN and
     * allowDuplicates is false.
     */
    private boolean insertDuplicate(final LN newLN,
                                    final byte[] key,
                                    final boolean allowDuplicates,
                                    final CursorImpl cursor,
                                    final LockResult lnLock,
                                    final ReplicationContext repContext,
                                    final byte[] originalLNData) {
        final EnvironmentImpl env = database.getDbEnvironment();
        final LogManager logManager = env.getLogManager();
        final INList inMemoryINs = env.getInMemoryINs();

        BIN bin = cursor.getBIN();
        int index = cursor.getIndex();
        boolean successfulInsert = false;

        DIN dupRoot = null;
        Node n = bin.fetchTarget(index);
        long binNid = bin.getNodeId();

        if (n instanceof DIN) {
            DBIN dupBin = null;

            /*
             * A duplicate tree exists.  Find the relevant DBIN and insert the
             * new entry into it.
             */
            try {
                CacheMode cacheMode = cursor.getCacheMode();
                dupRoot = (DIN) n;
                dupRoot.latch(cacheMode);

                /* Lock the DupCountLN before logging any LNs. */
                LockResult dclLockResult =
                    cursor.lockDupCountLN(dupRoot, LockType.WRITE);
                /* The BIN/index may have changed during locking. */
                bin = cursor.getBIN();
                index = cursor.getIndex();

                /*
                 * Do not proceed if duplicates are not allowed and there are
                 * one or more duplicates already present.  Note that if the
                 * dup count is zero, we allow the insert.
                 */
                if (!allowDuplicates) {

                    /*
                     * dupRoot could have been changed during the dcl lock so
                     * we need to grab it again here so that we release the
                     * latch on the correct dupRoot in the finally below.
                     */
                    dupRoot = (DIN) bin.fetchTarget(index);
                    DupCountLN dcl = (DupCountLN) dclLockResult.getLN();
                    if (dcl.getDupCount() > 0) {
                        return false;
                    }
                }

                /*
                 * Split the dup root if necessary.  The dup root may have
                 * changed during locking above or by the split, so refetch it.
                 * In either case it will be latched.
                 */
                maybeSplitDuplicateRoot(bin, index, cacheMode);
                dupRoot = (DIN) bin.fetchTarget(index);

                /*
                 * Search the duplicate tree for the right place to insert this
                 * new record. Releases the latch on duplicateRoot. If the
                 * duplicateRoot got logged as a result of some splitting,
                 * update the BIN's LSN information. The SortedLSNTreeWalker
                 * relies on accurate LSNs in the in-memory tree.
                 */
                byte[] newLNKey = newLN.getData();
                long previousLsn = dupRoot.getLastFullVersion();
                try {
                    dupBin = (DBIN) searchSubTreeSplitsAllowed
                        (dupRoot, newLNKey, Node.NULL_NODE_ID, cacheMode);
                } catch (RelatchRequiredException e) {
                    /* Should never happen, we use exclusive latches on DINs.*/
                    throw EnvironmentFailureException.unexpectedException(e);
                } catch (SplitRequiredException e) {

                    /*
                     * Shouldn't happen -- we have the DIN in the root of the
                     * dup tree latched during this insert, so there should be
                     * no possibility of being unable to insert a new entry
                     * into the DIN root of the dup tree.
                     */
                    throw EnvironmentFailureException.unexpectedException(e);
                }

                long currentLsn = dupRoot.getLastFullVersion();
                if (currentLsn != previousLsn) {
                    bin.updateEntry(index, currentLsn);
                }

                /* Release the BIN latch to increase concurrency. */
                cursor.releaseBIN();
                bin = null;

                /* The search above released the dup root latch. */
                dupRoot = null;

                /*
                 * Try to insert a new reference object. If successful, we'll
                 * log the LN and update the LSN in the reference.
                 */
                ChildReference newLNRef =
                    new ChildReference(newLN, newLNKey, DbLsn.NULL_LSN);

                int dupIndex = dupBin.insertEntry1(newLNRef);
                if ((dupIndex & IN.INSERT_SUCCESS) != 0) {

                    /*
                     * Update the cursor to point to the entry that has been
                     * successfully inserted.
                     */
                    dupIndex &= ~IN.INSERT_SUCCESS;
                    cursor.updateDBin(dupBin, dupIndex);

                    /* Log the new LN. */
                    long newLsn = DbLsn.NULL_LSN;
                    try {
                        newLsn = newLN.optionalLog
                            (env, database, key, DbLsn.NULL_LSN,
                             cursor.getLocker(), repContext);
                    } finally {
                        if ((newLsn == DbLsn.NULL_LSN) &&
                            (!database.isDeferredWriteMode())) {

                            /*
                             * See Tree.insert for an explanation of handling
                             * of IOException and OOME.
                             */
                            dupBin.setKnownDeleted(dupIndex);
                        }
                    }

                    lnLock.setAbortLsn(DbLsn.NULL_LSN, true, true);

                    /*
                     * Use updateEntry to be sure to mark the dupBin as dirty.
                     */
                    dupBin.updateEntry(dupIndex, newLsn);

                    traceInsertDuplicate(Level.FINER,
                                         database.getDbEnvironment(),
                                         dupBin, newLN, newLsn, binNid);
                    successfulInsert = true;
                } else {

                    /*
                     * The insert was not successful. Either this is a
                     * duplicate duplicate or there is an existing entry but
                     * that entry is deleted.
                     */
                    dupIndex &= ~IN.EXACT_MATCH;
                    cursor.updateDBin(dupBin, dupIndex);
                    LN currentLN = (LN) dupBin.fetchTarget(dupIndex);

                    /* If an LN is present, lock it and check deleted-ness. */
                    boolean isDeleted = false;
                    LockResult currentLock = null;
                    if (currentLN == null) {
                        /* The LN was cleaned. */
                        isDeleted = true;
                    } else {
                        currentLock = cursor.lockLNDeletedAllowed
                            (currentLN, LockType.WRITE);
                        currentLN = currentLock.getLN();

                        /*
                         * The BIN may have been latched while locking above.
                         * Release the latch here because we released it above
                         * to improve concurrency, and we will latch it again
                         * below to increment the duplicate count. [#15574]
                         */
                        cursor.releaseBIN();

                        /* The DBIN/index may have changed while locking. */
                        dupBin = cursor.getDupBIN();
                        dupIndex = cursor.getDupIndex();
                        if (dupBin.isEntryKnownDeleted(dupIndex) ||
                            currentLN == null ||
                            currentLN.isDeleted()) {
                            /* The current LN is deleted/cleaned. */
                            isDeleted = true;
                        }
                    }

                    if (isDeleted) {
                        /* See Tree.insert for an explanation. */
                        long abortLsn = dupBin.getLsn(dupIndex);
                        boolean abortKnownDeleted = true;
                        if (currentLN != null &&
                            currentLock.getLockGrant() ==
                            LockGrantType.EXISTING) {
                            long nodeId = currentLN.getNodeId();
                            Locker locker = cursor.getLocker();
                            WriteLockInfo info =
                                locker.getWriteLockInfo(nodeId);
                            abortLsn = info.getAbortLsn();
                            abortKnownDeleted = info.getAbortKnownDeleted();
                            /* Copy size/DatabaseImpl of the existing lock. */
                            lnLock.copyAbortInfo(info);
                        }
                        lnLock.setAbortLsn(abortLsn, abortKnownDeleted);

                        /*
                         * Current entry is a deleted entry. Replace it with
                         * LN.  Pass NULL_LSN for the oldLsn parameter of the
                         * log() method because the old LN was counted obsolete
                         * when it was deleted.
                         */
                        long newLsn = newLN.optionalLog
                            (env, database, key, DbLsn.NULL_LSN,
                             cursor.getLocker(), repContext);

                        /*
                         * When reusing a slot, the key is replaced in the DBIN
                         * slot.  This ensures that the correct key value is
                         * used when the new key is non-identical to the key in
                         * the slot but is considered equal by the duplicate
                         * comparator.  [#15704]
                         */
                        dupBin.updateEntry(dupIndex, newLN, newLsn, newLNKey);
                        dupBin.clearKnownDeleted(dupIndex);
                        dupBin.clearPendingDeleted(dupIndex);

                        traceInsertDuplicate(Level.FINER,
                                             database.getDbEnvironment(),
                                             dupBin, newLN, newLsn, binNid);
                        successfulInsert = true;
                    } else {
                        /* Duplicate duplicate. */
                        successfulInsert = false;
                    }
                }

                /*
                 * To avoid latching out of order (up the tree), release the
                 * DBIN latch before latching the BIN and dup root.
                 */
                dupBin.releaseLatch();
                dupBin = null;

                if (successfulInsert) {
                    cursor.latchBIN();
                    dupRoot =
                        cursor.getLatchedDupRoot(false /*isDBINLatched*/);
                    cursor.releaseBIN();
                    dupRoot.incrementDuplicateCount
                        (dclLockResult, key, cursor.getLocker(),
                         true /*increment*/);
                }
            } finally {
                if (dupBin != null) {
                    dupBin.releaseLatch();
                }

                if (dupRoot != null) {
                    dupRoot.releaseLatch();
                }
            }
        } else if (n instanceof LN) {

            /*
             * There is no duplicate tree yet.  The existing LN slot cannot be
             * reused, so to insert we must create a dup tree.
             */
            if (!allowDuplicates && !((LN) n).isDeleted()) {
                return false;
            }

            /*
             * Mutate the current BIN/LN pair into a BIN/DupCountLN/DIN/DBIN/LN
             * duplicate tree.  Log the new entries.
             */
            try {
                lnLock.setAbortLsn(DbLsn.NULL_LSN, true, true);
                dupRoot = createDuplicateTree
                    (newLN, key, cursor, repContext, originalLNData);
            } finally {
                if (dupRoot != null) {
                    dupRoot.releaseLatch();
                    successfulInsert = true;
                } else {
                    successfulInsert = false;
                }
            }
        } else {
            throw EnvironmentFailureException.unexpectedState
                ("neither LN or DIN found in BIN");
        }

        return successfulInsert;
    }

    /**
     * Check if the duplicate root needs to be split.  The current duplicate
     * root is latched.  Exit with the new root (even if it's unchanged)
     * latched and the old root (unless the root is unchanged) unlatched.
     *
     * @param bin the BIN containing the duplicate root.
     * @param index the index of the duplicate root in bin.
     * @return true if the duplicate root was split.
     */
    private boolean maybeSplitDuplicateRoot(BIN bin,
                                            int index,
                                            CacheMode cacheMode)
        throws DatabaseException {

        DIN curRoot = (DIN) bin.fetchTarget(index);

        if (curRoot.needsSplitting()) {

            EnvironmentImpl env = database.getDbEnvironment();
            LogManager logManager = env.getLogManager();
            INList inMemoryINs = env.getInMemoryINs();

            /*
             * Make a new root DIN, giving it an id key from the previous root.
             */
            byte[] rootIdKey = curRoot.getKey(0);
            DIN newRoot = new DIN(database,
                                  rootIdKey,
                                  maxDupTreeEntriesPerNode,
                                  curRoot.getDupKey(),
                                  curRoot.getDupCountLNRef(),
                                  curRoot.getLevel() + 1);

            newRoot.latch(cacheMode);
            long curRootLsn = 0;
            long logLsn = 0;
            try {
                newRoot.setIsRoot(true);
                curRoot.setDupCountLN(null);
                curRoot.setIsRoot(false);

                /*
                 * Make the new root DIN point to the old root DIN, and then
                 * log. We should be able to insert into the root because the
                 * root is newly created.
                 */
                try {
                    curRootLsn =
                        curRoot.optionalLogProvisional(logManager, newRoot);
                    boolean insertOk = newRoot.insertEntry
                        (new ChildReference(curRoot, rootIdKey,
                                            bin.getLsn(index)));
                    assert insertOk;

                    logLsn = newRoot.optionalLog(logManager);
                } catch (DatabaseException e) {

                    /* Something went wrong when we tried to log. */
                    curRoot.setIsRoot(true);
                    throw e;
                }

                inMemoryINs.add(newRoot);
                bin.updateNode(index, newRoot, logLsn, null /*lnSlotKey*/);
                curRoot.split(newRoot, 0, maxDupTreeEntriesPerNode, cacheMode);
            } finally {
                curRoot.releaseLatch();
            }
            traceSplitRoot(Level.FINE, TRACE_DUP_ROOT_SPLIT,
                           newRoot, logLsn, curRoot, curRootLsn);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Convert an existing BIN entry from a single (non-duplicate) LN to a new
     * DIN/DupCountLN->DBIN->LN subtree.
     *
     * @param key the key of the entry which will become the duplicate key
     * for the duplicate subtree.
     * @param logManager the logManager
     * @param inMemoryINs the in memory IN list
     * @param newLN the new record to be inserted
     * @param originalLNData is the original data of the existing LN, and is
     * guaranteed to be non-null even when the existing LN is deleted (and has
     * null data).
     * @param cursor points to the target position for this new dup tree.
     * @return the new duplicate subtree root (a DIN).  It is latched
     * when it is returned and the caller should unlatch it.  If new entry
     * to be inserted is a duplicate of the existing LN, null is returned.
     */
    private DIN createDuplicateTree(LN newLN,
                                    byte[] key,
                                    CursorImpl cursor,
                                    ReplicationContext repContext,
                                    byte[] originalLNData)
        throws DatabaseException {

        final EnvironmentImpl env = database.getDbEnvironment();
        final LogManager logManager = env.getLogManager();
        final INList inMemoryINs = env.getInMemoryINs();

        DIN dupRoot = null;
        DBIN dupBin = null;
        boolean dupBinIsLatched = false;
        BIN bin = cursor.getBIN();
        int index = cursor.getIndex();

        /*
         * fetchTarget returned an LN before this method was called, and we're
         * still latched, so the target should never be null here.
         */
        LN existingLN = (LN) bin.fetchTarget(index);
        boolean existingLNIsDeleted = bin.isEntryKnownDeleted(index) ||
            existingLN.isDeleted();
        assert existingLN != null;

        byte[] existingKey = originalLNData;
        byte[] newLNKey = newLN.getData();

        /* Check for duplicate duplicates. */
        boolean keysEqual = Key.compareKeys
            (newLNKey, existingKey, database.getDuplicateComparator()) == 0;
        if (keysEqual) {
            return null;
        }

        /*
         * Replace the existing LN with a duplicate tree.
         *
         * Once we create a dup tree, we don't revert back to the LN.  Create
         * a DupCountLN to hold the count for this dup tree. Since we don't
         * roll back the internal nodes of a duplicate tree, we need to create
         * a pre-transaction version of the DupCountLN. This version must hold
         * a count of either 0 or 1, depending on whether the existing lN will
         * be rolled back to a non-deleted LN.
         *
         * Note that we are logging a sequence of nodes and must make sure the
         * log can be correctly recovered even if the entire sequence doesn't
         * make it to the log. We need to make all children provisional to the
         * DIN. This works:
         *
         * Entry 1: (provisional) DupCountLN (first version)
         * Entry 2: (provisional) DupBIN
         * Entry 3: DIN
         * Entry 4: DupCountLN (second version, incorporating the new count.
         *           This can't be provisional because we need to possibly
         *            roll it back.)
         * Entry 5: new LN.
         * See [SR #10203] for a description of the bug that existed before
         * this change.
         */

        /* Create the first version of DupCountLN and log it. (Entry 1). */
        Locker locker = cursor.getLocker();
        long nodeId = existingLN.getNodeId();

        /*
         * If the existing entry is known to be deleted or was created by this
         * transaction, then the DCL should get rolled back to 0, not 1.
         * [13726].
         */
        int startingCount =
            (locker.createdNode(nodeId) || 
             locker.getWriteLockInfo(nodeId).getAbortKnownDeleted()) ?
            0 :
            1;

        DupCountLN dupCountLN = new DupCountLN(database.getDbEnvironment(),
                                               startingCount);
        long firstDupCountLNLsn = dupCountLN.optionalLogProvisional
            (env, database, key, DbLsn.NULL_LSN,
             ReplicationContext.NO_REPLICATE);

        /* Make the duplicate root and DBIN. */
        dupRoot = new DIN(database,
                          existingKey,                   // idkey
                          maxDupTreeEntriesPerNode,
                          key,                           // dup key
                          new ChildReference
                          (dupCountLN, key, firstDupCountLNLsn),
                          2);                            // level
        CacheMode cacheMode = cursor.getCacheMode();
        dupRoot.latch(cacheMode);
        dupRoot.setIsRoot(true);

        dupBin = new DBIN(database,
                          existingKey,                   // idkey
                          maxDupTreeEntriesPerNode,
                          key,                           // dup key
                          1);                            // level
        dupBin.latch(cacheMode);
        dupBinIsLatched = true;

        /*
         * Attach the existing LN child to the duplicate BIN. Since this is a
         * newly created BIN, insertEntry will be successful.
         */
        ChildReference newExistingLNRef = new ChildReference
            (existingLN, existingKey, bin.getLsn(index), bin.getState(index));

        boolean insertOk = dupBin.insertEntry(newExistingLNRef);
        assert insertOk;

        try {

            /* Entry 2: DBIN. */
            long dbinLsn = dupBin.optionalLogProvisional(logManager, dupRoot);
            inMemoryINs.add(dupBin);

            /* Attach the duplicate BIN to the duplicate IN root. */
            dupRoot.setEntry(0, dupBin, dupBin.getKey(0),
                             dbinLsn, dupBin.getState(0));
            /* Do not copy MIGRATE/KD/PD state flags from DBIN slot. */
            bin.setMigrate(index, false);
            dupRoot.clearKnownDeleted(0);
            dupRoot.clearPendingDeleted(0);

            /* Entry 3:  DIN */
            long dinLsn = dupRoot.optionalLog(logManager);
            inMemoryINs.add(dupRoot);

            /*
             * Now that the DIN is logged, we've created a duplicate tree that
             * holds the single, preexisting LN. We can safely create the non
             * provisional LNs that pertain to this insert -- the new LN and
             * the new DupCountLN.
             *
             * We request a lock while holding latches which is usually
             * forbidden, but safe in this case since we know it will be
             * immediately granted (we just created dupCountLN above).
             */
            LockResult lockResult = locker.lock
                (dupCountLN.getNodeId(), LockType.WRITE, false /*noWait*/,
                 database);
            lockResult.setAbortLsn(firstDupCountLNLsn, false);

            dupCountLN.setDupCount(existingLNIsDeleted ? 1 : 2);
            long dupCountLsn = dupCountLN.optionalLog
                (env, database, key, firstDupCountLNLsn, locker,
                 ReplicationContext.NO_REPLICATE);
            dupRoot.updateDupCountLNRef(dupCountLsn);

            /* Add the newly created LN. */
            long newLsn = newLN.optionalLog
                (env, database, key, DbLsn.NULL_LSN, locker, repContext);
            int dupIndex = dupBin.insertEntry1
                (new ChildReference(newLN, newLNKey, newLsn));
            dupIndex &= ~IN.INSERT_SUCCESS;
            cursor.updateDBin(dupBin, dupIndex);

            /*
             * Adjust any cursors positioned on the mutated BIN entry to point
             * to the DBIN at the location of the entry we moved there.  The
             * index of the moved entry is 1 or 0, the XOR of the index of the
             * new entry.
             */
            bin.adjustCursorsForMutation(index, dupBin, dupIndex ^ 1, cursor);
            dupBin.releaseLatch();
            dupBinIsLatched = false;

            /*
             * Update the "regular" BIN to point to the new duplicate tree
             * instead of the existing LN.  Clear the MIGRATE, KD and PD flags
             * since they apply only to the original LN.
             */
            bin.updateNode(index, dupRoot, dinLsn, null /*lnSlotKey*/);
            bin.setMigrate(index, false);
            bin.clearKnownDeleted(index);
            bin.clearPendingDeleted(index);

            traceMutate(Level.FINE, bin, existingLN, newLN, newLsn,
                        dupCountLN, dupCountLsn, dupRoot, dinLsn,
                        dupBin, dbinLsn);
        } catch (DatabaseException e) {

            /*
             * Strictly speaking, it's not necessary to release latches,
             * because if we fail to log the entries, we just throw them away,
             * but our unit tests check for 0 latches held in the event of a
             * logging error.
             */
            if (dupBinIsLatched) {
                dupBin.releaseLatch();
            }
            dupRoot.releaseLatch();
            throw e;
        }
        return dupRoot;
    }

    /**
     * Find the BIN that is relevant to the insert.  If the tree doesn't exist
     * yet, then create the first IN and BIN.  On return, the cursor is set to
     * the BIN that is found or created, and the BIN is latched.
     */
    private void findBinForInsert(final byte[] key, final CursorImpl cursor) {

        /* First try using the BIN at the cursor position to avoid a search. */
        BIN bin = cursor.latchBIN();
        if (bin != null) {
            if (!bin.needsSplitting() && bin.isKeyInBounds(key)) {
                return;
            } else {
                bin.releaseLatch();
            }
        }

        boolean rootLatchIsHeld = false;
        try {
            long logLsn;

            /*
             * We may have to try several times because of a small
             * timing window, explained below.
             */
            while (true) {
                rootLatchIsHeld = true;
                rootLatch.acquireShared();
                if (!rootExists()) {
                    rootLatch.release();
                    rootLatch.acquireExclusive();
                    if (rootExists()) {
                        rootLatch.release();
                        rootLatchIsHeld = false;
                        continue;
                    }

                    final CacheMode cacheMode = cursor.getCacheMode();
                    final EnvironmentImpl env = database.getDbEnvironment();
                    final LogManager logManager = env.getLogManager();
                    final INList inMemoryINs = env.getInMemoryINs();

                    /*
                     * This is an empty tree, either because it's brand new
                     * tree or because everything in it was deleted. Create an
                     * IN and a BIN.  We could latch the rootIN here, but
                     * there's no reason to since we're just creating the
                     * initial tree and we have the rootLatch held. Log the
                     * nodes as soon as they're created, but remember that
                     * referred-to children must come before any references to
                     * their LSNs.
                     */
                    /* First BIN in the tree, log provisionally right away. */
                    bin = new BIN(database, key, maxMainTreeEntriesPerNode, 1);
                    bin.latch(cacheMode);
                    logLsn = bin.optionalLogProvisional(logManager, null);

                    /*
                     * Log the root right away. Leave the root dirty, because
                     * the MapLN is not being updated, and we want to avoid
                     * this scenario from [#13897], where the LN has no
                     * possible parent.
                     *  provisional BIN
                     *  root IN
                     *  checkpoint start
                     *  LN is logged
                     *  checkpoint end
                     *  BIN is dirtied, but is not part of checkpoint
                     */

                    IN rootIN =
                        new IN(database, key, maxMainTreeEntriesPerNode, 2);

                    /*
                     * OK to latch the root after a child BIN because it's
                     * during creation.
                     */
                    rootIN.latch(cacheMode);
                    rootIN.setIsRoot(true);

                    boolean insertOk = rootIN.insertEntry
                        (new ChildReference(bin, key, logLsn));
                    assert insertOk;

                    logLsn = rootIN.optionalLog(logManager);
                    rootIN.setDirty(true);  /*force re-logging, see [#13897]*/

                    root = makeRootChildReference(rootIN,
                                                  new byte[0],
                                                  logLsn);

                    rootIN.releaseLatch();

                    /* Add the new nodes to the in memory list. */
                    inMemoryINs.add(bin);
                    inMemoryINs.add(rootIN);
                    rootLatch.release();
                    rootLatchIsHeld = false;

                    break;
                } else {
                    rootLatch.release();
                    rootLatchIsHeld = false;

                    /*
                     * There's a tree here, so search for where we should
                     * insert. However, note that a window exists after we
                     * release the root latch. We release the latch because the
                     * search method expects to take the latch. After the
                     * release and before search, the INCompressor may come in
                     * and delete the entire tree, so search may return with a
                     * null.
                     */
                    IN in = searchSplitsAllowed(key, Node.NULL_NODE_ID,
                                                cursor.getCacheMode());
                    if (in == null) {
                        /* The tree was deleted by the INCompressor. */
                        continue;
                    } else {
                        /* search() found a BIN where this key belongs. */
                        bin = (BIN) in;
                        break;
                    }
                }
            }
        } finally {
            if (rootLatchIsHeld) {
                rootLatch.release();
            }
        }

        /* testing hook to insert item into log. */
        assert TestHookExecute.doHookIfSet(ckptHook);

        cursor.setBIN(bin);
    }

    /*
     * Given a subtree root (an IN), remove it and all of its children from the
     * in memory IN list. Also count removed nodes as obsolete and gather the
     * set of file summaries that should be logged. The localTracker will be
     * flushed to the log later.
     */
    private void accountForSubtreeRemoval(INList inList,
                                          IN subtreeRoot,
                                          LocalUtilizationTracker localTracker)
        throws DatabaseException {

        subtreeRoot.accountForSubtreeRemoval(inList, localTracker);

        LoggerUtils.envLogMsg(Level.FINE, database.getDbEnvironment(),
                           "SubtreeRemoval: subtreeRoot = " + 
                           subtreeRoot.getNodeId());
    }

    /*
     * Logging support
     */

    /**
     * @see Loggable#getLogSize
     */
    public int getLogSize() {
        int size = 1;                          // rootExists
        if (root != null) {
            size += root.getLogSize();
        }
        return size;
    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer logBuffer) {
        byte booleans = (byte) ((root != null) ? 1 : 0);
        logBuffer.put(booleans);
        if (root != null) {
            root.writeToLog(logBuffer);
        }
    }

    /**
     * @see Loggable#readFromLog
     */
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {
        boolean rootExists = false;
        byte booleans = itemBuffer.get();
        rootExists = (booleans & 1) != 0;
        if (rootExists) {
            root = makeRootChildReference();
            root.readFromLog(itemBuffer, entryVersion);
        }
    }

    /**
     * @see Loggable#dumpLog
     */
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<root>");
        if (root != null) {
            root.dumpLog(sb, verbose);
        }
        sb.append("</root>");
    }

    /**
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return 0;
    }

    /**
     * @see Loggable#logicalEquals
     * Always return false, this item should never be compared.
     */
    public boolean logicalEquals(Loggable other) {
        return false;
    }

    /**
     * rebuildINList is used by recovery to add all the resident nodes to the
     * IN list.
     */
    public void rebuildINList()
        throws DatabaseException {

        INList inMemoryList = database.getDbEnvironment().getInMemoryINs();

        if (root != null) {
            rootLatch.acquireShared();
            try {
                Node rootIN = root.getTarget();
                if (rootIN != null) {
                    rootIN.rebuildINList(inMemoryList);
                }
            } finally {
                rootLatch.release();
            }
        }
    }

    /*
     * Debugging stuff.
     */
    public void dump() {
        System.out.println(dumpString(0));
    }

    public String dumpString(int nSpaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(TreeUtils.indent(nSpaces));
        sb.append("<tree>");
        sb.append('\n');
        if (root != null) {
            sb.append(DbLsn.dumpString(root.getLsn(), nSpaces));
            sb.append('\n');
            IN rootIN = (IN) root.getTarget();
            if (rootIN == null) {
                sb.append("<in/>");
            } else {
                sb.append(rootIN.toString());
            }
            sb.append('\n');
        }
        sb.append(TreeUtils.indent(nSpaces));
        sb.append("</tree>");
        return sb.toString();
    }

    /**
     * Unit test support to validate subtree pruning. Didn't want to make root
     * access public.
     */
    boolean validateDelete(int index)
        throws DatabaseException {

        rootLatch.acquireShared();
        try {
            IN rootIN = (IN) root.fetchTarget(database, null);
            return rootIN.validateSubtreeBeforeDelete(index);
        } finally {
            rootLatch.release();
        }
    }

    /**
     * Debugging check that all resident nodes are on the INList and no stray
     * nodes are present in the unused portion of the IN arrays.
     */
    public void validateINList(IN parent)
        throws DatabaseException {

        if (parent == null) {
            parent = (IN) root.getTarget();
        }
        if (parent != null) {
            INList inList = database.getDbEnvironment().getInMemoryINs();
            if (!inList.contains(parent)) {
                throw EnvironmentFailureException.unexpectedState
                    ("IN " + parent.getNodeId() + " missing from INList");
            }
            for (int i = 0;; i += 1) {
                try {
                    Node node = parent.getTarget(i);
                    if (i >= parent.getNEntries()) {
                        if (node != null) {
                            throw EnvironmentFailureException.unexpectedState
                                ("IN " + parent.getNodeId() +
                                 " has stray node " + node.getNodeId() +
                                 " at index " + i);
                        }
                        byte[] key = parent.getKey(i);
                        if (key != null) {
                            throw EnvironmentFailureException.unexpectedState
                                ("IN " + parent.getNodeId() +
                                 " has stray key " + key +
                                 " at index " + i);
                        }
                    }
                    if (node instanceof IN) {
                        validateINList((IN) node);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }
    }

    /* For unit testing only. */
    public void setWaitHook(TestHook hook) {
        waitHook = hook;
    }

    /* For unit testing only. */
    public void setSearchHook(TestHook hook) {
        searchHook = hook;
    }

    /* For unit testing only. */
    public void setCkptHook(TestHook hook) {
        ckptHook = hook;
    }

    /**
     * Send trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    private void traceSplitRoot(Level level,
                                String splitType,
                                IN newRoot,
                                long newRootLsn,
                                IN oldRoot,
                                long oldRootLsn) {
        Logger logger = database.getDbEnvironment().getLogger();
        if (logger.isLoggable(level)) {
            StringBuffer sb = new StringBuffer();
            sb.append(splitType);
            sb.append(" newRoot=").append(newRoot.getNodeId());
            sb.append(" newRootLsn=").
                append(DbLsn.getNoFormatString(newRootLsn));
            sb.append(" oldRoot=").append(oldRoot.getNodeId());
            sb.append(" oldRootLsn=").
                append(DbLsn.getNoFormatString(oldRootLsn));
            LoggerUtils.logMsg
                (logger, database.getDbEnvironment(), level, sb.toString());
        }
    }

    /**
     * Send trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    private void traceMutate(Level level,
                             BIN theBin,
                             LN existingLn,
                             LN newLn,
                             long newLsn,
                             DupCountLN dupCountLN,
                             long dupRootLsn,
                             DIN dupRoot,
                             long ddinLsn,
                             DBIN dupBin,
                             long dbinLsn) {
        Logger logger = database.getDbEnvironment().getLogger();
        if (logger.isLoggable(level)) {
            StringBuffer sb = new StringBuffer();
            sb.append(TRACE_MUTATE);
            sb.append(" existingLn=");
            sb.append(existingLn.getNodeId());
            sb.append(" newLn=");
            sb.append(newLn.getNodeId());
            sb.append(" newLnLsn=");
            sb.append(DbLsn.getNoFormatString(newLsn));
            sb.append(" dupCountLN=");
            sb.append(dupCountLN.getNodeId());
            sb.append(" dupRootLsn=");
            sb.append(DbLsn.getNoFormatString(dupRootLsn));
            sb.append(" rootdin=");
            sb.append(dupRoot.getNodeId());
            sb.append(" ddinLsn=");
            sb.append(DbLsn.getNoFormatString(ddinLsn));
            sb.append(" dbin=");
            sb.append(dupBin.getNodeId());
            sb.append(" dbinLsn=");
            sb.append(DbLsn.getNoFormatString(dbinLsn));
            sb.append(" bin=");
            sb.append(theBin.getNodeId());

            LoggerUtils.logMsg
                (logger, database.getDbEnvironment(), level, sb.toString());
        }
    }

    /**
     * Send trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    private void traceInsert(Level level,
                             EnvironmentImpl env,
                             BIN insertingBin,
                             LN ln,
                             long lnLsn,
                             int index) {
        Logger logger = env.getLogger();
        if (logger.isLoggable(level)) {
            StringBuffer sb = new StringBuffer();
            sb.append(TRACE_INSERT);
            sb.append(" bin=");
            sb.append(insertingBin.getNodeId());
            sb.append(" ln=");
            sb.append(ln.getNodeId());
            sb.append(" lnLsn=");
            sb.append(DbLsn.getNoFormatString(lnLsn));
            sb.append(" index=");
            sb.append(index);

            LoggerUtils.logMsg(logger, env, level, sb.toString());
        }
    }

    /**
     * Send trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    private void traceInsertDuplicate(Level level,
                                      EnvironmentImpl env,
                                      BIN insertingDBin,
                                      LN ln,
                                      long lnLsn,
                                      long binNid) {
        Logger logger = env.getLogger();
        if (logger.isLoggable(level)) {
            StringBuffer sb = new StringBuffer();
            sb.append(TRACE_INSERT_DUPLICATE);
            sb.append(" dbin=");
            sb.append(insertingDBin.getNodeId());
            sb.append(" bin=");
            sb.append(binNid);
            sb.append(" ln=");
            sb.append(ln.getNodeId());
            sb.append(" lnLsn=");
            sb.append(DbLsn.getNoFormatString(lnLsn));

            LoggerUtils.logMsg(logger, env, level, sb.toString());
        }
    }

    private static class SplitInfo {
        IN parent;
        IN child;
        int index;

        SplitInfo(IN parent, IN child, int index) {
            this.parent = parent;
            this.child = child;
            this.index = index;
        }
    }
}
