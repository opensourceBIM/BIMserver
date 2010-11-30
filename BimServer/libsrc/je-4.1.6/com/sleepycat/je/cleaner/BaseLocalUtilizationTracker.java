/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import java.util.Iterator;
import java.util.Map;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Shared implementation for all local utilization trackers.  Per-database
 * utilization info is tracked in a local map rather than in the live
 * DatabaseImpl objects.  The transferToUtilizationTracker method is called to
 * transfer per-file and per-database info to the (global) UtilizationTracker.
 */
abstract class BaseLocalUtilizationTracker extends BaseUtilizationTracker {

    /**
     * Map of per-database utilization info.
     *
     * In LocalUtilizationTracker:
     *    IdentityHashMap of DatabaseImpl to DbFileSummaryMap
     *
     * In RecoveryUtilizationTracker:
     *    HashMap of DatabaseId to DbFileSummaryMap
     */
    private Map<Object, DbFileSummaryMap> dbMap;

    /**
     * Creates a local tracker with a map keyed by DatabaseId or DatabaseImpl.
     *
     * When used by this class dbMap is an IdentityHashMap keyed by
     * DatabaseImpl. When used by RecoveryUtilizationTracker dbMap is a HashMap
     * keyed by DatabaseId.
     */
    BaseLocalUtilizationTracker(EnvironmentImpl env,
                                Map<Object, DbFileSummaryMap> dbMap) {
        super(env, env.getCleaner());
        this.dbMap = dbMap;
    }

    /**
     * Returns the map of databases; for use by subclasses.
     */
    Map<Object, DbFileSummaryMap> getDatabaseMap() {
        return dbMap;
    }

    /**
     * Transfers counts and offsets from this local tracker to the given
     * (global) UtilizationTracker and to the live DatabaseImpl objects.
     *
     * <p>When called after recovery has finished, must be called under the log
     * write latch.</p>
     */
    public void transferToUtilizationTracker(UtilizationTracker tracker)
        throws DatabaseException {

        /* Add file summary information, including obsolete offsets. */
        for (TrackedFileSummary localSummary : getTrackedFiles()) {
            TrackedFileSummary fileSummary =
                tracker.getFileSummary(localSummary.getFileNumber());
            fileSummary.addTrackedSummary(localSummary);
        }

        /* Add DbFileSummary information. */
        Iterator<Object> dbMapKeys = dbMap.keySet().iterator();
        while (dbMapKeys.hasNext()) {
            Object key = dbMapKeys.next();
            DatabaseImpl db = databaseKeyToDatabaseImpl(key);
            /* If db is null, it was deleted. */
            DbFileSummaryMap fileMap = dbMap.get(key);

            if (db != null) {
                Iterator<Map.Entry<Long, DbFileSummary>> fileEntries =
                    fileMap.entrySet().iterator();

                while (fileEntries.hasNext()) {
                    Map.Entry<Long, DbFileSummary> fileEntry =
                        fileEntries.next();

                    Long fileNum = fileEntry.getKey();
                    DbFileSummary dbFileSummary =
                        db.getDbFileSummary(fileNum, true /*willModify*/);
                    if (dbFileSummary != null) {
                        DbFileSummary localSummary = fileEntry.getValue();
                        dbFileSummary.add(localSummary);
                    }
                }
            }
            /* Ensure that DbTree.releaseDb is called. [#16329] */
            releaseDatabaseImpl(db);
            /* This object is being discarded, subtract it from the budget. */
            fileMap.subtractFromMemoryBudget();
        }
    }

    /**
     * Returns the DatabaseImpl from the database key, which is either the
     * DatabaseId or DatabaseImpl.  The releaseDatabaseImpl must be called
     * with the DatabaseImpl returned by this method.
     */
    abstract DatabaseImpl databaseKeyToDatabaseImpl(Object databaseKey)
        throws DatabaseException;

    /**
     * Must be called after calling databaseKeyToDatabaseImpl.  The db
     * parameter may be null, in which case no action is taken.
     *
     * If DbTree.getDb is called by the implementation of
     * databaseKeyToDatabaseImpl, then DbTree.releaseDb must be called by the
     * implementation of this method.
     */
    abstract void releaseDatabaseImpl(DatabaseImpl db);

    /**
     * Allocates DbFileSummary information locally in this object rather than
     * in the DatabaseImpl.
     *
     * @param databaseKey is either a DatabaseId or DatabaseImpl depending on
     * whether called from the RecoveryUtilizationTracker or
     * LocalUtilizationTracker, respectively.
     *
     * @return the summary, or null if the databaseKey param is null.
     */
    DbFileSummary getDbFileSummary(Object databaseKey, long fileNum) {
        if (databaseKey != null) {
            DbFileSummaryMap fileMap = dbMap.get(databaseKey);
            if (fileMap == null) {
                fileMap = new DbFileSummaryMap(true /* countParentMapEntry */);
                fileMap.init(env);
                dbMap.put(databaseKey, fileMap);
            }

            /*
             * Pass false for checkResurrected since a log file can be deleted
             * at any time when counting with a local tracker.
             */
            return fileMap.get
                (Long.valueOf(fileNum), true /*adjustMemBudget*/,
                 false /*checkResurrected*/, env.getFileManager());
        } else {
            return null;
        }
    }

    /**
     * Deallocates all DbFileSummary objects for the given database key.
     * For use by subclasses.
     */
    void removeDbFileSummaries(Object databaseKey) {
        /* The dbMap entry is budgeted by the DbFileSummaryMap. */
        DbFileSummaryMap fileMap =
            dbMap.remove(databaseKey);
        if (fileMap != null) {
            fileMap.subtractFromMemoryBudget();
        }
    }
}
