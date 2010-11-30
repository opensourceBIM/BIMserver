/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import java.util.Set;

import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.utilint.IdentityHashMap;

/**
 * Accumulates changes to the utilization profile locally in a single thread.
 *
 * <p>Per-database information is keyed by DatabaseImpl so that no tree lookup
 * of a database is required (as when a DatabaseId is used).</p>
 *
 * <p>The countNewLogEntry, countObsoleteNode and countObsoleteNodeInexact
 * methods may be called without taking the log write latch.  Totals and offset
 * are accumulated locally in this object only, not in DatabaseImpl
 * objects.</p>
 *
 * <p>When finished with this object, its information should be added to the
 * Environment's UtilizationTracker and DatabaseImpl objects by calling
 * transferToUtilizationTracker under the log write latch.  This is done in the
 * Checkpointer, Evictor and INCompressor by calling
 * UtilizationProfile.flushLocalTracker which calls
 * LogManager.transferToUtilizationTracker which calls
 * BaseLocalUtilizationTracker.transferToUtilizationTracker.</p>
 */
public class LocalUtilizationTracker extends BaseLocalUtilizationTracker {

    public LocalUtilizationTracker(EnvironmentImpl env) {
        super(env, new IdentityHashMap<Object, DbFileSummaryMap>());
    }

    /**
     * Counts the addition of all new log entries including LNs.
     */
    public void countNewLogEntry(long lsn,
                                 LogEntryType type,
                                 int size,
                                 DatabaseImpl db) {
        countNew(lsn, db, type, size);
    }

    /**
     * Counts a node that has become obsolete and tracks the LSN offset, if
     * non-zero, to avoid a lookup during cleaning.
     *
     * <p>A zero LSN offset is used as a special value when obsolete offset
     * tracking is not desired. [#15365]  The file header entry (at offset
     * zero) is never counted as obsolete, it is assumed to be obsolete by the
     * cleaner.</p>
     *
     * <p>This method should only be called for LNs and INs (i.e, only for
     * nodes).  If type is null we assume it is an LN.</p>
     */
    public void countObsoleteNode(long lsn,
                                  LogEntryType type,
                                  int size,
                                  DatabaseImpl db) {
        countObsolete
            (lsn, db, type, size,
             true,   // countPerFile
             true,   // countPerDb
             true,   // trackOffset
             true);  // checkDupOffsets
    }

    /**
     * Counts as countObsoleteNode does, but since the LSN may be inexact, does
     * not track the obsolete LSN offset.
     *
     * <p>This method should only be called for LNs and INs (i.e, only for
     * nodes).  If type is null we assume it is an LN.</p>
     */
    public void countObsoleteNodeInexact(long lsn,
                                         LogEntryType type,
                                         int size,
                                         DatabaseImpl db) {
        countObsolete
            (lsn, db, type, size,
             true,   // countPerFile
             true,   // countPerDb
             false,  // trackOffset
             false); // checkDupOffsets
    }

    public Set<Object> getTrackedDbs() {
        return getDatabaseMap().keySet();
    }

    /**
     * Returns the DatabaseImpl from the database key, which in this case is
     * the DatabaseImpl.
     */
    @Override
    DatabaseImpl databaseKeyToDatabaseImpl(Object databaseKey) {
        return (DatabaseImpl) databaseKey;
    }

    /**
     * Do nothing, since DbTree.getDb was not called by
     * databaseKeyToDatabaseImpl.
     */
    @Override
    void releaseDatabaseImpl(DatabaseImpl db) {
    }
}
