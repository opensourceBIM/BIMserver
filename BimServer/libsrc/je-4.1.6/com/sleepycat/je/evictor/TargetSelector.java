/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.evictor;

import static com.sleepycat.je.evictor.EvictorStatDefinition.EVICTOR_NODES_SELECTED;
import static com.sleepycat.je.evictor.EvictorStatDefinition.GROUP_DESC;
import static com.sleepycat.je.evictor.EvictorStatDefinition.GROUP_NAME;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;

/**
 * The TargetSelect choses an IN for eviction. This is the main point of
 * synchronization in the eviction path. There are other points of
 * synchronization when executing the body of the eviction itself, such as when
 * a btree node latch is taken, or log cleaning utilization information is
 * transferred.
 *
 * The implementation of the target selector is different for a private vs.
 * shared cache, because the underlying cache data structures are different.
 * This difference in implementation embodies the difference between private 
 * and shared caches.
 */
abstract class TargetSelector {

    /* Number of nodes selected to evict. */
    private final LongStat nNodesSelected;

    /* 1 node out of <nodesPerScan> are chosen for eviction. */
    private final int nodesPerScan;

    /* je.evictor.lruOnly */
    private final boolean evictByLruOnly;

    final StatGroup stats;

    TargetSelector(EnvironmentImpl envImpl) {
        DbConfigManager configManager = envImpl.getConfigManager();
        nodesPerScan = configManager.getInt
            (EnvironmentParams.EVICTOR_NODES_PER_SCAN);
        evictByLruOnly = configManager.getBoolean
            (EnvironmentParams.EVICTOR_LRU_ONLY);
        stats = new StatGroup(GROUP_NAME, GROUP_DESC);
        nNodesSelected = new LongStat(stats, EVICTOR_NODES_SELECTED);
    }

    /**
     * Select a single node to evict. Not synchronized! Instead, getNextIN is
     * the main point of synchronization. Note that it is possible that 
     * multiple threads will end up perusing the same INs, if the INList
     * is small enough so that the iterator wraps around. Because of that,
     * this method must be thread safe.
     */
    ScanInfo selectIN(int maxNodesToIterate) {
        /* Find the best target in the next <nodesPerScan> nodes. */
        
        ScanInfo scanInfo = new ScanInfo();

        long targetGeneration = Long.MAX_VALUE;
        int targetLevel = Integer.MAX_VALUE;
        boolean targetDirty = true;

        /* The nodesPerScan limit is on nodes that qualify for eviction. */
        int nCandidates = 0;

        /* The limit on iterated nodes is to prevent an infinite loop. */
        int nIterated = 0;

        while (nIterated <  maxNodesToIterate && nCandidates < nodesPerScan) {
            IN in = null;
            synchronized (this) {
                in = getNextIN();
            }

            if (in == null) {

                /*
                 * INList is empty or we've detected that there's no more
                 * need to evict.
                 */
                break; 
                
            }
            nIterated++;
            scanInfo.numNodesScanned++;

            DatabaseImpl db = in.getDatabase();

            /*
             * Ignore the IN if its database is deleted.  We have not called
             * getDb, so we can't guarantee that the DB is valid; get Db is
             * called and this is checked again after an IN is selected for
             * eviction.
             */
            if (db == null || db.isDeleted()) {
                continue;
            }

            /*
             * If this is a read-only environment, skip any dirty INs (recovery
             * dirties INs even in a read-only environment).
             */
            if (db.getDbEnvironment().isReadOnly() &&
                in.getDirty()) {
                continue;
            }

            /*
             * Only scan evictable or strippable INs.  This prevents higher
             * level INs from being selected for eviction, unless they are
             * part of an unused tree.
             */
            int evictType = in.getEvictionType();
            if (evictType == IN.MAY_NOT_EVICT) {
                continue;
            }

            /*
             * This node is eligible.  Select according to the configured
             * eviction policy.
             */
            if (evictByLruOnly) {

                /*
                 * Select the node with the lowest generation number,
                 * irrespective of tree level or dirtyness.
                 */
                if (targetGeneration > in.getGeneration()) {
                    targetGeneration = in.getGeneration();
                    scanInfo.target = in;
                }
            } else {

                /*
                 * Select first by tree level, then by dirtyness, then by
                 * generation/LRU.
                 */
                int level = normalizeLevel(in, evictType);
                if (targetLevel != level) {
                    if (targetLevel > level) {
                        targetLevel = level;
                        targetDirty = in.getDirty();
                        targetGeneration = in.getGeneration();
                        scanInfo.target = in;
                    }
                } else if (targetDirty != in.getDirty()) {
                    if (targetDirty) {
                        targetDirty = false;
                        targetGeneration = in.getGeneration();
                        scanInfo.target = in;
                    }
                } else {
                    if (targetGeneration > in.getGeneration()) {
                        targetGeneration = in.getGeneration();
                        scanInfo.target = in;
                    }
                }
            }
            nCandidates++;
        }

        if (scanInfo.target != null) {
            nNodesSelected.increment();
        }
        return scanInfo;
    }

    /**
     * Normalize the tree level of the given IN.
     *
     * Is public for unit testing.
     *
     * A BIN containing evictable LNs is given level 0, so it will be stripped
     * first.  For non-duplicate and DBMAP trees, the high order bits are
     * cleared to make their levels correspond; that way, all bottom level
     * nodes (BINs and DBINs) are given the same eviction priority.
     *
     * Note that BINs in a duplicate tree are assigned the same level as BINs
     * in a non-duplicate tree.  This isn't always optimal, but is the best
     * we can do considering that BINs in duplicate trees may contain a mix of
     * LNs and DINs.
     *
     * BINs in the mapping tree are also assigned the same level as user DB
     * BINs.  When doing by-level eviction (lruOnly=false), this seems
     * counter-intuitive since we should evict user DB nodes before mapping DB
     * nodes.  But that does occur because mapping DB INs referencing an open
     * DB are unevictable.  The level is only used for selecting among
     * evictable nodes.
     *
     * If we did NOT normalize the level for the mapping DB, then INs for
     * closed evictable DBs would not be evicted until after all nodes in all
     * user DBs were evicted.  If there were large numbers of closed DBs, this
     * would have a negative performance impact.
     */
    static int normalizeLevel(IN in, int evictType) {

        int level = in.getLevel() & IN.LEVEL_MASK;

        if (level == 1 && evictType == IN.MAY_EVICT_LNS) {
            level = 0;
        }

        return level;
    }

    /**
     * Must be synchronized!
     * Perform class-specific batch pre-batch processing: Initialize iterator,
     * and do special eviction (UtilizationTracker eviction) if suitable. No
     * tree latches may be held when this method is called.
     *
     * Returns the approximate number of total INs in the INList(s), to bound
     * the size of one batch. One eviction batch will scan at most this number
     * of INs.  If zero is returned, selectIN should not be called.
     * 
     * @param doSpecialEviction Do non-tree eviction, such as flushing the
     * UtilizationProfile. Since special eviction is serialized, and does 
     * require I/O, some callers may not want to be blocked doing this
     */
    abstract SetupInfo startBatch(boolean doSpecialEviction)
        throws DatabaseException;

    /**
     * Returns the next IN in the INList(s), wrapping if necessary.
     * This must be called serially, and must be synchronized.
     */
    abstract IN getNextIN();

    abstract StatGroup getINListStats(StatsConfig config);

    /**
     * Called whenever INs are added to, or removed from, the INList.
     */
    public abstract void noteINListChange(int nINs);

    public StatGroup loadStats(StatsConfig config) {
        StatGroup copy = stats.cloneGroup(config.getClear());
        copy.addAll(getINListStats(config));
        return copy;
    }

    /**
     * Only supported by SharedEvictor.
     */
    public abstract void addEnvironment(EnvironmentImpl additionalEnvImpl);

    /**
     * Only supported by SharedEvictor.
     */
    public abstract void removeEnvironment(EnvironmentImpl targetEnvImpl);

    /*
     * For assertion purposes, only implemented by SharedEvictor. 
     */
    public abstract boolean checkEnv(EnvironmentImpl targetEnvImpl);

    /* For unit testing only.  Supported only by PrivateEvictor. */
    abstract Iterator<IN> getScanIterator();

    /* For unit testing only.  Supported only by PrivateEvictor. */
    abstract void setScanIterator(Iterator<IN> iter);

    /* For debugging and unit tests. */
    static class EvictProfile {
        /* Keep a list of candidate nodes. */
        private final List<Long> candidates = new ArrayList<Long>();

        /* Remember that this node was targeted. */
        public boolean count(IN target) {
            candidates.add(Long.valueOf(target.getNodeId()));
            return true;
        }

        public List<Long> getCandidates() {
            return candidates;
        }

        public boolean clear() {
            candidates.clear();
            return true;
        }
    }

    /**
     * Struct returned when setting up an eviction batch.
     */
    static class SetupInfo {
        long specialEvictionBytes;
        int maxINsPerBatch;
    }

    /**
     * Struct returned when selecting a single IN for eviction.
     */
    class ScanInfo {
        IN target;
        int numNodesScanned;
    }
}
