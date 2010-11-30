/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.incomp;

import static com.sleepycat.je.incomp.INCompStatDefinition.GROUP_NAME;
import static com.sleepycat.je.incomp.INCompStatDefinition.GROUP_DESC;
import static com.sleepycat.je.incomp.INCompStatDefinition.INCOMP_CURSORS_BINS;
import static com.sleepycat.je.incomp.INCompStatDefinition.INCOMP_DBCLOSED_BINS;
import static com.sleepycat.je.incomp.INCompStatDefinition.INCOMP_NON_EMPTY_BINS;
import static com.sleepycat.je.incomp.INCompStatDefinition.INCOMP_PROCESSED_BINS;
import static com.sleepycat.je.incomp.INCompStatDefinition.INCOMP_QUEUE_SIZE;
import static com.sleepycat.je.incomp.INCompStatDefinition.INCOMP_SPLIT_BINS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.cleaner.LocalUtilizationTracker;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.latch.LatchSupport;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.BINReference;
import com.sleepycat.je.tree.CursorsExistException;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.NodeNotEmptyException;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.Tree.SearchType;
import com.sleepycat.je.utilint.DaemonThread;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.TestHookExecute;

/**
 * The IN Compressor.  JE compression consist of removing delete entries from
 * BINs, and pruning empty IN/BINs from the tree. Compression is carried out by
 * either a daemon thread or lazily by operations (namely checkpointing and
 * eviction) that are writing INS.
 */
public class INCompressor extends DaemonThread {
    private static final boolean DEBUG = false;

    private EnvironmentImpl env;
    private final long lockTimeout;

    /* stats */
    private StatGroup stats;
    private LongStat splitBins;
    private LongStat dbClosedBins;
    private LongStat cursorsBins;
    private LongStat nonEmptyBins;
    private LongStat processedBins;
    private LongStat compQueueSize;

    /* per-run stats */
    private int splitBinsThisRun = 0;
    private int dbClosedBinsThisRun = 0;
    private int cursorsBinsThisRun = 0;
    private int nonEmptyBinsThisRun = 0;
    private int processedBinsThisRun = 0;

    /*
     * The following stats are not kept per run, because they're set by
     * multiple threads doing lazy compression. They are debugging aids; it
     * didn't seem like a good idea to add synchronization to the general path.
     */
    private int lazyProcessed = 0;
    private int lazyEmpty = 0;
    private int lazySplit = 0;
    private int wokenUp = 0;

    /*
     * Store logical references to BINs that have deleted entries and are
     * candidates for compaction.
     */
    private Map<Long, BINReference> binRefQueue;
    private final Object binRefQueueSync;

    /* For unit tests */
    private TestHook beforeFlushTrackerHook; // [#15528]

    public INCompressor(EnvironmentImpl env, long waitTime, String name) {
        super(waitTime, name, env);
        this.env = env;
        lockTimeout = env.getConfigManager().getDuration
            (EnvironmentParams.COMPRESSOR_LOCK_TIMEOUT);
        binRefQueue = new HashMap<Long, BINReference>();
        binRefQueueSync = new Object();
 
        /* Do the stats definitions. */
        stats = new StatGroup(GROUP_NAME, GROUP_DESC);
        splitBins = new LongStat(stats, INCOMP_SPLIT_BINS);
        dbClosedBins = new LongStat(stats, INCOMP_DBCLOSED_BINS);
        cursorsBins = new LongStat(stats, INCOMP_CURSORS_BINS);
        nonEmptyBins = new LongStat(stats, INCOMP_NON_EMPTY_BINS);
        processedBins = new LongStat(stats, INCOMP_PROCESSED_BINS);
        compQueueSize = new LongStat(stats, INCOMP_QUEUE_SIZE);
    }

    synchronized public void clearEnv() {
        env = null;
    }

    /* For unit testing only. */
    public void setBeforeFlushTrackerHook(TestHook hook) {
        beforeFlushTrackerHook = hook;
    }

    public synchronized void verifyCursors()
        throws DatabaseException {

        /*
         * Environment may have been closed.  If so, then our job here is done.
         */
        if (env.isClosed()) {
            return;
        }

        /*
         * Use a snapshot to verify the cursors.  This way we don't have to
         * hold a latch while verify takes locks.
         */
        List<BINReference> queueSnapshot = null;
        synchronized (binRefQueueSync) {
            queueSnapshot = new ArrayList<BINReference>(binRefQueue.values());
        }

        /*
         * Use local caching to reduce DbTree.getDb overhead.  Do not call
         * releaseDb after each getDb, since the entire dbCache will be
         * released at the end.
         */
        DbTree dbTree = env.getDbTree();
        Map<DatabaseId, DatabaseImpl> dbCache =
            new HashMap<DatabaseId, DatabaseImpl>();
        try {
            Iterator<BINReference> it = queueSnapshot.iterator();
            while (it.hasNext()) {
                BINReference binRef = it.next();
                DatabaseImpl db = dbTree.getDb
                    (binRef.getDatabaseId(), lockTimeout, dbCache);
                BIN bin = searchForBIN(db, binRef);
                if (bin != null) {
                    bin.verifyCursors();
                    bin.releaseLatch();
                }
            }
        } finally {
            dbTree.releaseDbs(dbCache);
        }
    }

    public int getBinRefQueueSize() {
        int size = 0;
        synchronized (binRefQueueSync) {
            size = binRefQueue.size();
        }

        return size;
    }

    /*
     * There are multiple flavors of the addBin*ToQueue methods. All allow
     * the caller to specify whether the daemon should be notified. Currently
     * no callers proactively notify, and we rely on lazy compression and
     * the daemon timebased wakeup to process the queue.
     */

    /**
     * Adds the BIN and deleted Key to the queue if the BIN is not already in
     * the queue, or adds the deleted key to an existing entry if one exists.
     */
    public void addBinKeyToQueue(BIN bin, Key deletedKey, boolean doWakeup) {
        synchronized (binRefQueueSync) {
            addBinKeyToQueueAlreadyLatched(bin, deletedKey);
        }
        if (doWakeup) {
            wakeup();
        }
    }

    /**
     * Adds the BINReference to the queue if the BIN is not already in the
     * queue, or adds the deleted keys to an existing entry if one exists.
     */
    public void addBinRefToQueue(BINReference binRef, boolean doWakeup) {
        synchronized (binRefQueueSync) {
            addBinRefToQueueAlreadyLatched(binRef);
        }

        if (doWakeup) {
            wakeup();
        }
    }

    /**
     * Adds an entire collection of BINReferences to the queue at once.  Use
     * this to avoid latching for each add.
     */
    public void addMultipleBinRefsToQueue(Collection<BINReference> binRefs,
                                          boolean doWakeup) {
        synchronized (binRefQueueSync) {
            Iterator<BINReference> it = binRefs.iterator();
            while (it.hasNext()) {
                BINReference binRef = it.next();
                addBinRefToQueueAlreadyLatched(binRef);
            }
        }

        if (doWakeup) {
            wakeup();
        }
    }

    /**
     * Adds the BINReference with the latch held.
     */
    private void addBinRefToQueueAlreadyLatched(BINReference binRef) {

        Long node = Long.valueOf(binRef.getNodeId());
        BINReference existingRef = binRefQueue.get(node);
        if (existingRef != null) {
            existingRef.addDeletedKeys(binRef);
        } else {
            binRefQueue.put(node, binRef);
        }
    }

    /**
     * Adds the BIN and deleted Key with the latch held.
     */
    private void addBinKeyToQueueAlreadyLatched(BIN bin, Key deletedKey) {

        Long node = Long.valueOf(bin.getNodeId());
        BINReference existingRef = binRefQueue.get(node);
        if (existingRef != null) {
            if (deletedKey != null) {
                existingRef.addDeletedKey(deletedKey);
            }
        } else {
            BINReference binRef = bin.createReference();
            if (deletedKey != null) {
                binRef.addDeletedKey(deletedKey);
            }
            binRefQueue.put(node, binRef);
        }
    }

    public boolean exists(long nodeId) {
        Long node = Long.valueOf(nodeId);
        synchronized (binRefQueueSync) {
            return (binRefQueue.get(node) != null);
        }
    }

    /*
     * Return a bin reference for this node if it exists and has a set of
     * deletable keys.
     */
    private BINReference removeCompressibleBinReference(long nodeId) {
        Long node = Long.valueOf(nodeId);
        BINReference foundRef = null;
        synchronized (binRefQueueSync) {
            BINReference target = binRefQueue.remove(node);
            if (target != null) {
                if (target.deletedKeysExist()) {
                    foundRef = target;
                } else {

                    /*
                     * This is an entry that needs to be pruned. Put it back
                     * to be dealt with by the daemon.
                     */
                    binRefQueue.put(node, target);
                }
            }
        }
        return foundRef;
    }

    /**
     * Return stats
     */
    public StatGroup loadStats(StatsConfig config) {
        compQueueSize.set((long) getBinRefQueueSize());

        if (DEBUG) {
            System.out.println("lazyProcessed = " + lazyProcessed);
            System.out.println("lazyEmpty = " + lazyEmpty);
            System.out.println("lazySplit = " + lazySplit);
            System.out.println("wokenUp=" + wokenUp);
        }

        if (config.getClear()) {
            lazyProcessed = 0;
            lazyEmpty = 0;
            lazySplit = 0;
            wokenUp = 0;
        }

        return stats.cloneGroup(config.getClear());
    }

    /**
     * Return the number of retries when a deadlock exception occurs.
     */
    @Override
    protected long nDeadlockRetries() {
        return env.getConfigManager().getInt
            (EnvironmentParams.COMPRESSOR_RETRY);
    }

    @Override
    public synchronized void onWakeup()
        throws DatabaseException {

        if (env.isClosed()) {
            return;
        }
        wokenUp++;
        doCompress();
    }

    /**
     * The real work to doing a compress. This may be called by the compressor
     * thread or programatically.
     */
    public synchronized void doCompress()
        throws DatabaseException {

        /*
         * Make a snapshot of the current work queue so the compressor thread
         * can safely iterate over the queue. Note that this impacts lazy
         * compression, because it lazy compressors will not see BINReferences
         * that have been moved to the snapshot.
         */
        Map<Long, BINReference> queueSnapshot = null;
        int binQueueSize = 0;
        synchronized (binRefQueueSync) {
            binQueueSize = binRefQueue.size();
            if (binQueueSize > 0) {
                queueSnapshot = binRefQueue;
                binRefQueue = new HashMap<Long, BINReference>();
            }
        }

        /* There is work to be done. */
        if (binQueueSize > 0) {
            resetPerRunCounters();
            LoggerUtils.fine(logger, envImpl, 
                             "InCompress.doCompress called, queue size: " +
                             binQueueSize);
            assert LatchSupport.countLatchesHeld() == 0;

            /*
             * Compressed entries must be counted as obsoleted.  A separate
             * tracker is used to accumulate tracked obsolete info so it can be
             * added in a single call under the log write latch.  We log the
             * info for deleted subtrees immediately because we don't process
             * deleted IN entries during recovery; this reduces the chance of
             * lost info.
             */
            LocalUtilizationTracker localTracker =
                new LocalUtilizationTracker(env);

            /* Use local caching to reduce DbTree.getDb overhead. */
            Map<DatabaseId, DatabaseImpl> dbCache =
                new HashMap<DatabaseId, DatabaseImpl>();

            DbTree dbTree = env.getDbTree();
            BINSearch binSearch = new BINSearch();
            try {
                Iterator<BINReference> it = queueSnapshot.values().iterator();
                while (it.hasNext()) {
                    if (env.isClosed()) {
                        return;
                    }

                    BINReference binRef = it.next();
                    if (!findDBAndBIN(binSearch, binRef, dbTree, dbCache)) {

                        /*
                         * Either the db is closed, or the BIN doesn't
                         * exist. Don't process this BINReference.
                         */
                        continue;
                    }

                    if (binRef.deletedKeysExist()) {
                        /* Compress deleted slots. */
                        boolean requeued = compressBin
                            (binSearch.db, binSearch.bin, binRef,
                             localTracker);

                        if (!requeued) {

                            /*
                             * This BINReference was fully processed, but there
                             * may still be deleted slots. If there are still
                             * deleted keys in the binref, they were relocated
                             * by a split.
                             */
                            checkForRelocatedSlots
                                (binSearch.db, binRef, localTracker);
                        }
                    } else {

                        /*
                         * An empty BINReference on the queue was put there by
                         * a lazy compressor to indicate that we should try to
                         * prune an empty BIN.
                         */
                        BIN foundBin = binSearch.bin;

                        byte[] idKey = foundBin.getIdentifierKey();
                        boolean isDBIN = foundBin.containsDuplicates();
                        byte[] dupKey = null;
                        if (isDBIN) {
                            dupKey = ((DBIN) foundBin).getDupKey();
                        }

                        /*
                         * Release the BIN latch taken by the initial
                         * search. Pruning starts from the top of the tree and
                         * requires that no latches are held.
                         */
                        foundBin.releaseLatch();

                        pruneBIN(binSearch.db,  binRef, idKey, isDBIN,
                                 dupKey, localTracker);
                    }
                }

                /* SR [#11144]*/
                assert TestHookExecute.doHookIfSet(beforeFlushTrackerHook);

                /*
                 * Count obsolete nodes and write out modified file summaries
                 * for recovery.  All latches must have been released.
                 */
                env.getUtilizationProfile().flushLocalTracker(localTracker);

            } finally {
                dbTree.releaseDbs(dbCache);
                assert LatchSupport.countLatchesHeld() == 0;
                accumulatePerRunCounters();
            }
        }
    }

    /**
     * Compresses a single BIN and then deletes the BIN if it is empty.
     * @param bin is latched when this method is called, and unlatched when it
     * returns.
     * @return true if the BINReference was requeued by this method.
     */
    private boolean compressBin(DatabaseImpl db,
                                BIN bin,
                                BINReference binRef,
                                LocalUtilizationTracker localTracker)
        throws DatabaseException {

        /* Safe to get identifier keys; bin is latched. */
        boolean empty = false;
        boolean requeued = false;
        byte[] idKey = bin.getIdentifierKey();
        byte[] dupKey = null;
        boolean isDBIN = bin.containsDuplicates();

        try {
            int nCursors = bin.nCursors();
            if (nCursors > 0) {

                /*
                 * There are cursors pointing to the BIN, so try again later.
                 */
                addBinRefToQueue(binRef, false);
                requeued = true;
                cursorsBinsThisRun++;
            } else {
                requeued = bin.compress
                    (binRef, true /* canFetch */, localTracker);
                if (!requeued) {

                    /*
                     * Only check for emptiness if this BINRef is in play and
                     * not on the queue.
                     */
                    empty = (bin.getNEntries() == 0);

                    if (empty) {

                        /*
                         * While we have the BIN latched, prepare a dup key if
                         * needed for navigating the tree while pruning.
                         */
                        if (isDBIN) {
                            dupKey = ((DBIN) bin).getDupKey();
                        }
                    }
                }
            }
        } finally {
            bin.releaseLatch();
        }

        /* Prune if the bin is empty and there has been no requeuing. */
        if (empty) {
            requeued = pruneBIN
                (db, binRef, idKey, isDBIN, dupKey, localTracker);
        }

        return requeued;
    }

    /**
     * If the target BIN is empty, attempt to remove the empty branch of the
     * tree.
     * @return true if the pruning was unable to proceed and the BINReference
     * was requeued.
     */
    private boolean pruneBIN(DatabaseImpl dbImpl,
                             BINReference binRef,
                             byte[] idKey,
                             boolean containsDups,
                             byte[] dupKey,
                             LocalUtilizationTracker localTracker)
        throws DatabaseException {

        boolean requeued = false;
        try {
            Tree tree = dbImpl.getTree();

            if (containsDups) {
                tree.deleteDup(idKey, dupKey, localTracker);
            } else {
                tree.delete(idKey, localTracker);
            }
            processedBinsThisRun++;
        } catch (NodeNotEmptyException NNEE) {

            /*
             * Something was added to the node since the point when the
             * deletion occurred; we can't prune, and we can throw away this
             * BINReference.
             */
             nonEmptyBinsThisRun++;
        } catch (CursorsExistException e) {

            /*
             * If there are cursors in the way of the delete, retry later.
             * For example, When we delete a BIN or DBIN, we're guaranteed that
             * there are no cursors at that node. (otherwise, we wouldn't be
             * able to remove all the entries. However, there's the possibility
             * that the BIN that is the parent of the duplicate tree has
             * resident cursors, and in that case, we would not be able to
             * remove the whole duplicate tree and DIN root. In that case, we'd
             * requeue.
             */
            addBinRefToQueue(binRef, false);
            cursorsBinsThisRun++;
            requeued = true;
        }
        return requeued;
    }

    /*
     * When we do not requeue the BINRef but there are deleted keys remaining,
     * those keys were not found in the BIN and therefore must have been moved
     * to another BIN during a split.
     */
    private void checkForRelocatedSlots(DatabaseImpl db,
                                        BINReference binRef,
                                        LocalUtilizationTracker localTracker)
        throws DatabaseException {

        Iterator<Key> iter = binRef.getDeletedKeyIterator();
        if (iter != null) {

            /* mainKey is only used for dups. */
            byte[] mainKey = binRef.getKey();
            boolean isDup = (binRef.getData() != null);

            while (iter.hasNext()) {
                Key key = iter.next();

                /*
                 * Lookup the BIN for each deleted key, and compress that BIN
                 * separately.
                 */
                BIN splitBin = isDup ?
                    searchForBIN(db, mainKey, key.getKey()) :
                    searchForBIN(db, key.getKey(), null);
                if (splitBin != null) {
                    BINReference splitBinRef = splitBin.createReference();
                    splitBinRef.addDeletedKey(key);
                    compressBin(db, splitBin, splitBinRef, localTracker);
                }
            }
        }
    }

    /**
     * Search the tree for the BIN or DBIN that corresponds to this
     * BINReference.
     *
     * @param binRef the BINReference that indicates the bin we want.
     * @return the BIN or DBIN that corresponds to this BINReference. The
     * node is latched upon return. Returns null if the BIN can't be found.
     */
    public BIN searchForBIN(DatabaseImpl db, BINReference binRef)
        throws DatabaseException {

        return searchForBIN(db, binRef.getKey(), binRef.getData());
    }

    private BIN searchForBIN(DatabaseImpl db, byte[] mainKey, byte[] dupKey)
        throws DatabaseException {

        /* Search for this IN */
        Tree tree = db.getTree();
        IN in = tree.search
            (mainKey, SearchType.NORMAL, -1, null, CacheMode.UNCHANGED);

        /* Couldn't find a BIN, return null */
        if (in == null) {
            return null;
        }

        /* This is not a duplicate, we're done. */
        if (dupKey == null) {
            return (BIN) in;
        }

        /* We need to descend down into a duplicate tree. */
        DIN duplicateRoot = null;
        boolean duplicateRootIsLatched = false;
        DBIN duplicateBin = null;
        BIN bin = (BIN) in;
        boolean binIsLatched = true;
        try {
            int index = bin.findEntry(mainKey, false, true);
            if (index >= 0) {
                Node node = null;
                if (!bin.isEntryKnownDeleted(index)) {

                    /*
                     * If fetchTarget returns null, a deleted LN was cleaned.
                     */
                    node = bin.fetchTarget(index);
                }
                if (node == null) {
                    bin.releaseLatch();
                    binIsLatched = false;
                    return null;
                }
                if (node.containsDuplicates()) {
                    /* It's a duplicate tree. */
                    duplicateRoot = (DIN) node;
                    duplicateRoot.latch(CacheMode.UNCHANGED);
                    duplicateRootIsLatched = true;
                    bin.releaseLatch();
                    binIsLatched = false;
                    duplicateBin = (DBIN) tree.searchSubTree
                        (duplicateRoot, dupKey, SearchType.NORMAL, -1, null,
                         CacheMode.UNCHANGED);
                    duplicateRootIsLatched = false;

                    return duplicateBin;
                } else {
                    /* We haven't migrated to a duplicate tree yet. */
                    return bin;
                }
            } else {
                bin.releaseLatch();
                binIsLatched = false;
                return null;
            }
        } catch (DatabaseException DBE) {
            if (bin != null &&
                binIsLatched) {
                bin.releaseLatch();
            }

            if (duplicateRoot != null &&
                duplicateRootIsLatched) {
                duplicateRoot.releaseLatch();
            }

            /*
             * FindBugs whines about Redundent comparison to null below, but
             * for stylistic purposes we'll leave it in.
             */
            if (duplicateBin != null) {
                duplicateBin.releaseLatch();
            }
            throw DBE;
        }
    }

    /**
     * Reset per-run counters.
     */
    private void resetPerRunCounters() {
        splitBinsThisRun = 0;
        dbClosedBinsThisRun = 0;
        cursorsBinsThisRun = 0;
        nonEmptyBinsThisRun = 0;
        processedBinsThisRun = 0;
    }

    private void accumulatePerRunCounters() {
        splitBins.add(splitBinsThisRun);
        dbClosedBins.add(dbClosedBinsThisRun);
        cursorsBins.add(cursorsBinsThisRun);
        nonEmptyBins.add(nonEmptyBinsThisRun);
        processedBins.add(processedBinsThisRun);
    }

    /**
     * Lazily compress a single BIN. Do not do any pruning. The target IN
     * should be latched when we enter, and it will be remain latched.
     */
    public void lazyCompress(IN in, LocalUtilizationTracker localTracker)
        throws DatabaseException {

        if (!in.isCompressible()) {
            return;
        }

        assert in.isLatchOwnerForWrite();

        /* BIN is latched. */
        BIN bin = (BIN) in;
        int nCursors = bin.nCursors();
        if (nCursors > 0) {
            /* Cursor prohibit compression. */
            return;
        } else {
            BINReference binRef =
                removeCompressibleBinReference(bin.getNodeId());
            if ((binRef == null) || (!binRef.deletedKeysExist())) {
                return;
            } else {

                boolean requeued =
                    bin.compress(binRef, false /* canFetch */, localTracker);
                lazyProcessed++;

                /*
                 * If this wasn't requeued, but there were deleted keys
                 * remaining, requeue, so the daemon can handle this.  Either
                 * we must have shuffled some items because of a split, or a
                 * child was not resident and we couldn't process that entry.
                 */
                if (!requeued && binRef.deletedKeysExist()) {
                    addBinRefToQueue(binRef, false);
                    lazySplit++;
                } else {
                    if (bin.getNEntries() == 0) {
                        addBinRefToQueue(binRef, false);
                        lazyEmpty++;
                    }
                }
            }
        }
    }

    /*
     * Find the db and bin for a BINReference.
     * @return true if the db is open and the target bin is found.
     */
    private boolean findDBAndBIN(BINSearch binSearch,
                                 BINReference binRef,
                                 DbTree dbTree,
                                 Map<DatabaseId, DatabaseImpl> dbCache)
        throws DatabaseException {

        /*
         * Find the database.  Do not call releaseDb after this getDb, since
         * the entire dbCache will be released later.
         */
        binSearch.db = dbTree.getDb
            (binRef.getDatabaseId(), lockTimeout, dbCache);
        if ((binSearch.db == null) ||(binSearch.db.isDeleted())) {
          /* The db was deleted. Ignore this BIN Ref. */
            dbClosedBinsThisRun++;
            return false;
        }

        /* Perform eviction before each operation. */
        env.daemonEviction(true /*backgroundIO*/);

        /* Find the BIN. */
        binSearch.bin = searchForBIN(binSearch.db, binRef);
        if ((binSearch.bin == null) ||
            binSearch.bin.getNodeId() != binRef.getNodeId()) {
            /* The BIN may have been split. */
            if (binSearch.bin != null) {
                binSearch.bin.releaseLatch();
            }
            splitBinsThisRun++;
            return false;
        }

        return true;
    }

    /* Struct to return multiple values from findDBAndBIN. */
    private static class BINSearch {
        public DatabaseImpl db;
        public BIN bin;
    }
}
