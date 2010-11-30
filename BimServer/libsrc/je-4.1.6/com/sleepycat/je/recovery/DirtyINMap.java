/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.recovery;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.recovery.Checkpointer.CheckpointReference;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.utilint.IdentityHashMap;

/**
 * Map of Integer->Set
 * level->Set of checkpoint references
 */
class DirtyINMap {

    private EnvironmentImpl envImpl;
    private SortedMap<Integer,Map<Long,CheckpointReference>> levelMap;
    private int numEntries;
    private Set<DatabaseId> mapLNsToFlush;

    DirtyINMap(EnvironmentImpl envImpl) {
        this.envImpl = envImpl;
        levelMap = new TreeMap<Integer,Map<Long,CheckpointReference>>();
        numEntries = 0;
        mapLNsToFlush = new HashSet<DatabaseId>();
    }

    /**
     * Scan the INList for all dirty INs, excluding temp DB INs.  Save them in
     * a tree-level ordered map for level ordered flushing.
     *
     * Take this opportunity to reset the memory budget tree value.
     *
     * @return highestFlushLevels, map of DatabaseImpl to Integer.
     */
    Map<DatabaseImpl,Integer>
        selectDirtyINsForCheckpoint(boolean flushAll, boolean flushExtraLevel)
        throws DatabaseException {

        Map<DatabaseImpl,Integer> highestLevelSeenMap =
            new IdentityHashMap<DatabaseImpl,Integer>();
        DbTree dbTree = envImpl.getDbTree();

        INList inMemINs = envImpl.getInMemoryINs();

        /*
         * Opportunistically recalculate the INList memory budget while
         * traversing the entire INList.
         */
        inMemINs.memRecalcBegin();
        boolean completed = false;

        try {
            for (IN in : inMemINs) {
                in.latchShared(CacheMode.UNCHANGED);
                DatabaseImpl db = in.getDatabase();

                try {
                    inMemINs.memRecalcIterate(in);

                    /* Do not checkpoint temporary databases. */
                    if (db.isTemporary()) {
                        continue;
                    }

                    Integer level =
                        addDirtyIN(in, false /*updateMemoryBudget*/);
                    if (level != null) {

                        /*
                         * IN was added to the dirty map.  Update the highest
                         * level seen for the database.  Use one level higher
                         * when flushExtraLevel is set.  When flushAll is set,
                         * use the maximum level for the database.  Durable
                         * deferred-write databases must be synced, so also use
                         * the maximum level.
                         */
                        if (flushAll || db.isDurableDeferredWrite()) {
                            if (!highestLevelSeenMap.containsKey(db)) {

                                /*
                                 * Null is used as an indicator that
                                 * getHighestLevel should be called below, when
                                 * no latches are held.
                                 */
                                highestLevelSeenMap.put(db, null);
                            }
                        } else {
                            int levelVal = level.intValue();
                            if (flushExtraLevel) {
                                if (in.isRoot()) {
                                    /* No reason to go above DB root. */
                                    if (!in.isDbRoot()) {
                                        /* The level above DIN root is BIN. */
                                        levelVal = IN.BIN_LEVEL;
                                    }
                                } else {
                                    /* Next level up in the same tree. */
                                    levelVal += 1;
                                }
                            }
                            Integer highestLevelSeen =
                                highestLevelSeenMap.get(db);
                            if (highestLevelSeen == null ||
                                levelVal > highestLevelSeen.intValue()) {
                                if (flushExtraLevel) {
                                    level = Integer.valueOf(levelVal);
                                }
                                highestLevelSeenMap.put(db, level);
                            }
                        }
                    }

                    /* Save dirty/temp DBs for later. */
                    saveMapLNsToFlush(in);
                } finally {
                    in.releaseLatch();
                }
            }
            completed = true;
        } finally {
            inMemINs.memRecalcEnd(completed);
        }

        /* Call getHighestLevel only when no latches are held. */
        for (DatabaseImpl db : highestLevelSeenMap.keySet()) {
            if (highestLevelSeenMap.get(db) == null) {
                highestLevelSeenMap.put
                    (db, Integer.valueOf(dbTree.getHighestLevel(db)));
            }
        }
        return highestLevelSeenMap;
    }

    /**
     * Scan the INList for all dirty INs for a given database.  Arrange them in
     * level sorted map for level ordered flushing.
     *
     * @return highestFlushLevels, map of DatabaseImpl to Integer.
     */
    Map<DatabaseImpl, Integer> selectDirtyINsForDbSync(DatabaseImpl dbImpl)
        throws DatabaseException {

        DatabaseId dbId = dbImpl.getId();

        for (IN in : envImpl.getInMemoryINs()) {
            if (in.getDatabaseId().equals(dbId)) {
                in.latch(CacheMode.UNCHANGED);
                try {
                    addDirtyIN(in, false /*updateMemoryBudget*/);
                } finally {
                    in.releaseLatch();
                }
            }
        }

        /*
         * Create a single entry map that forces all levels of this DB to
         * be flushed.
         */
        Map<DatabaseImpl, Integer> highestFlushLevels =
            new IdentityHashMap<DatabaseImpl, Integer>();
        highestFlushLevels.put
            (dbImpl,
             Integer.valueOf(envImpl.getDbTree().getHighestLevel(dbImpl)));
        return highestFlushLevels;
    }

    int getNumLevels() {
        return levelMap.size();
    }

    void addCostToMemoryBudget() {
        MemoryBudget mb = envImpl.getMemoryBudget();
        int cost = numEntries * MemoryBudget.CHECKPOINT_REFERENCE_SIZE;
        mb.updateAdminMemoryUsage(cost);
    }

    void removeCostFromMemoryBudget() {
        MemoryBudget mb = envImpl.getMemoryBudget();
        int cost = numEntries * MemoryBudget.CHECKPOINT_REFERENCE_SIZE;
        mb.updateAdminMemoryUsage(0 - cost);
    }

    /**
     * Adds the IN if dirty, otherwise returns null.  See addIN.
     */
    private Integer addDirtyIN(IN in, boolean updateMemoryBudget) {

        if (in.getDirty()) {
            return addIN(in, updateMemoryBudget);
        } else {
            return null;
        }
    }

    /**
     * Add a node unconditionally to the dirty map. The dirty map is keyed by
     * level (Integers) and holds sets of IN references.
     *
     * @param updateMemoryBudget if true then update the memory budget as the
     * map is changed; if false then addCostToMemoryBudget must be called
     * later.
     *
     * @return level of IN added to the dirty map.  The level is returned
     * rather than a boolean simply to avoid allocating another Integer in the
     * caller.
     */
    Integer addIN(IN in, boolean updateMemoryBudget) {

        Integer level = Integer.valueOf(in.getLevel());
        Map<Long,CheckpointReference> nodeMap;
        if (levelMap.containsKey(level)) {
            nodeMap = levelMap.get(level);
        } else {
            nodeMap = new HashMap<Long,CheckpointReference>();
            levelMap.put(level, nodeMap);
        }

        nodeMap.put(in.getNodeId(),
                    new CheckpointReference(in.getDatabase().getId(),
                                            in.getNodeId(),
                                            in.containsDuplicates(),
                                            in.isDbRoot(),
                                            in.getMainTreeKey(),
                                            in.getDupTreeKey()));
        numEntries++;

        if (updateMemoryBudget) {
            MemoryBudget mb = envImpl.getMemoryBudget();
            mb.updateAdminMemoryUsage
                (MemoryBudget.CHECKPOINT_REFERENCE_SIZE);
        }

        return level;
    }

    /**
     * Get the lowest level currently stored in the map.
     */
    Integer getLowestLevelSet() {
        return levelMap.firstKey();
    }

    /**
     * Get an iterator over the references corresponding to the given level.
     */
    Iterator<CheckpointReference> getIterator(Integer level) {
        return levelMap.get(level).values().iterator();
    }

    /**
     * Removes the set corresponding to the given level.
     */
    void removeLevel(Integer level) {
        levelMap.remove(level);
    }

    boolean containsNode(Integer level, Long nodeId) {
        Map<Long,CheckpointReference> nodeMap = levelMap.get(level);
        if (nodeMap != null) {
            return nodeMap.containsKey(nodeId);
        }
        return false;
    }

    CheckpointReference removeNode(Integer level, Long nodeId) {
        Map<Long,CheckpointReference> nodeMap = levelMap.get(level);
        if (nodeMap != null) {
            return nodeMap.remove(nodeId);
        }
        return null;
    }

    CheckpointReference removeNextNode(Integer level) {
        Map<Long,CheckpointReference> nodeMap = levelMap.get(level);
        if (nodeMap != null) {
            Iterator<Map.Entry<Long,CheckpointReference>> iter =
                nodeMap.entrySet().iterator();
            if (iter.hasNext()) {
                CheckpointReference ref = iter.next().getValue();
                iter.remove();
                return ref;
            }
        }
        return null;
    }

    /**
     * If the given IN is a BIN for the ID mapping database, saves all
     * dirty/temp MapLNs contained in it.
     */
    private void saveMapLNsToFlush(IN in) {
        if (in instanceof BIN &&
            in.getDatabase().getId().equals(DbTree.ID_DB_ID)) {
            for (int i = 0; i < in.getNEntries(); i += 1) {
                MapLN ln = (MapLN) in.getTarget(i);
                if (ln != null && ln.getDatabase().isCheckpointNeeded()) {
                    mapLNsToFlush.add(ln.getDatabase().getId());
                }
            }
        }
    }

    /**
     * Flushes all saved dirty/temp MapLNs and clears the saved set.
     *
     * <p>If dirty, a MapLN must be flushed at each checkpoint to record
     * updated utilization info in the checkpoint interval.  If it is a
     * temporary DB, the MapLN must be flushed because all temp DBs must be
     * encountered by recovery so they can be removed if they were not closed
     * (and removed) by the user.</p>
     *
     * @param checkpointStart start LSN of the checkpoint in progress.  To
     * reduce unnecessary logging, the MapLN is only flushed if it has not been
     * written since that LSN.
     */
    void flushMapLNs(long checkpointStart)
        throws DatabaseException {

        if (!mapLNsToFlush.isEmpty()) {
            DbTree dbTree = envImpl.getDbTree();
            Iterator<DatabaseId> i = mapLNsToFlush.iterator();
            while (i.hasNext()) {
                DatabaseId dbId = i.next();
                DatabaseImpl db = null;
                try {
                    db = dbTree.getDb(dbId);
                    if (db != null &&
                        !db.isDeleted() &&
                        db.isCheckpointNeeded()) {
                        dbTree.modifyDbRoot
                            (db, checkpointStart /*ifBeforeLsn*/,
                             true /*mustExist*/);
                    }
                } finally {
                    dbTree.releaseDb(db);
                }
            }
            mapLNsToFlush.clear();
        }
    }

    /**
     * Flushes the DB mapping tree root at the end of the checkpoint, if either
     * mapping DB is dirty and the root was not flushed previously during the
     * checkpoint.
     *
     * @param checkpointStart start LSN of the checkpoint in progress.  To
     * reduce unnecessary logging, the Root is only flushed if it has not been
     * written since that LSN.
     */
    void flushRoot(long checkpointStart)
        throws DatabaseException {

        DbTree dbTree = envImpl.getDbTree();
        if (dbTree.getDb(DbTree.ID_DB_ID).isCheckpointNeeded() ||
            dbTree.getDb(DbTree.NAME_DB_ID).isCheckpointNeeded()) {
            envImpl.logMapTreeRoot(checkpointStart);
        }
    }

    int getNumEntries() {
        return numEntries;
    }
}
