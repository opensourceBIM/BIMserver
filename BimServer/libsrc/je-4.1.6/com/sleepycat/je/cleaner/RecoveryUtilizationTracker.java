/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.utilint.DbLsn;

/**
 * Accumulates changes to the utilization profile during recovery.
 *
 * <p>Per-database information is keyed by DatabaseId because the DatabaseImpl
 * is not always available during recovery.  In fact this is the only reason
 * that a "local" tracker is used during recovery -- to avoid requiring that
 * the DatabaseImpl is available, which is necessary to use the "global"
 * UtilizationTracker.  There is no requirement to accumulate totals locally,
 * since recovery is single threaded.</p>
 *
 * <p>When finished with this object, its information should be added to the
 * Environment's UtilizationTracker and DatabaseImpl objects by calling
 * transferToUtilizationTracker.  This is done at the end of recovery, just
 * prior to the checkpoint.  It does not have to be done under the log write
 * latch, since recovery is single threaded.</p>
 */
public class RecoveryUtilizationTracker extends BaseLocalUtilizationTracker {

    /* File number -> LSN of FileSummaryLN */
    private final Map<Long, Long> fileSummaryLsns;
    /* DatabaseId  -> LSN of MapLN */
    private final Map<DatabaseId, Long> databaseLsns;

    public RecoveryUtilizationTracker(EnvironmentImpl env) {
        super(env, new HashMap<Object,DbFileSummaryMap>());
        fileSummaryLsns = new HashMap<Long, Long>();
        databaseLsns = new HashMap<DatabaseId, Long>();
    }

    /**
     * Saves the LSN of the last logged FileSummaryLN.
     */
    public void saveLastLoggedFileSummaryLN(long fileNum, long lsn) {
        fileSummaryLsns.put(Long.valueOf(fileNum), Long.valueOf(lsn));
    }

    /**
     * Saves the LSN of the last logged MapLN.
     */
    public void saveLastLoggedMapLN(DatabaseId dbId, long lsn) {
        databaseLsns.put(dbId, Long.valueOf(lsn));
    }

    /**
     * Counts the addition of all new log entries including LNs.
     */
    public void countNewLogEntry(long lsn,
                                 LogEntryType type,
                                 int size,
                                 DatabaseId dbId) {
        countNew(lsn, dbId, type, size);
    }

    /**
     * Counts the LSN of a node obsolete unconditionally.
     *
     * <p>Even when countExact is true, duplicate offsets are not checked (no
     * assertion is fired) because recovery is known to count the same LSN
     * offset twice in certain circumstances.</p>
     */
    public void countObsoleteUnconditional(long lsn,
                                           LogEntryType type,
                                           int size,
                                           DatabaseId dbId,
                                           boolean countExact) {
        countObsolete
            (lsn, dbId, type, size,
             true,       // countPerFile
             true,       // countPerDb
             countExact, // trackOffset
             false);     // checkDupOffsets
    }

    /**
     * Counts the oldLsn of a node obsolete if it has not already been counted
     * at the point of newLsn in the log.
     *
     * <p>Even when countExact is true, duplicate offsets are not checked (no
     * assertion is fired) because recovery is known to count the same LSN
     * offset twice in certain circumstances.</p>
     *
     * @return whether the file was previously uncounted.
     */
    public boolean countObsoleteIfUncounted(long oldLsn,
                                            long newLsn,
                                            LogEntryType type,
                                            int size,
                                            DatabaseId dbId,
                                            boolean countExact) {
        Long fileNum = Long.valueOf(DbLsn.getFileNumber(oldLsn));
        boolean fileUncounted = isFileUncounted(fileNum, newLsn);
        boolean dbUncounted = isDbUncounted(dbId, newLsn);
        countObsolete
            (oldLsn, dbId, type, size,
             fileUncounted, // countPerFile
             dbUncounted,   // countPerDb
             countExact,    // trackOffset
             false);        // checkDupOffsets
        return fileUncounted;
    }

    /**
     * Fetches the LN to get its size only if necessary and so configured.
     */
    public int fetchLNSize(int size, long lsn)
        throws DatabaseException {

        if (size == 0 && env.getCleaner().getFetchObsoleteSize()) {
            try {
                LN ln = (LN) env.getLogManager().getEntry(lsn);
                size = ln.getLastLoggedSize();
            } catch (FileNotFoundException e) {
                /* Ignore errors if the file was cleaned. */
            }
        }
        return size;
    }

    /**
     * Overrides this method for recovery and returns whether the FileSummaryLN
     * for the given file is prior to the given LSN.
     */
    @Override
    boolean isFileUncounted(Long fileNum, long lsn) {
        long fsLsn = DbLsn.longToLsn(fileSummaryLsns.get(fileNum));
        int cmpFsLsnToNewLsn = (fsLsn != DbLsn.NULL_LSN) ?
            DbLsn.compareTo(fsLsn, lsn) : -1;
        return cmpFsLsnToNewLsn < 0;
    }

    /**
     * Returns whether the MapLN for the given database ID is prior to the
     * given LSN.
     */
    private boolean isDbUncounted(DatabaseId dbId, long lsn) {
        long dbLsn = DbLsn.longToLsn(databaseLsns.get(dbId));
        int cmpDbLsnToLsn = (dbLsn != DbLsn.NULL_LSN) ?
            DbLsn.compareTo(dbLsn, lsn) : -1;
        return cmpDbLsnToLsn < 0;
    }

    /**
     * Clears all accmulated utilization info for the given file.
     */
    public void resetFileInfo(long fileNum) {
        TrackedFileSummary trackedSummary = getTrackedFile(fileNum);
        if (trackedSummary != null) {
            trackedSummary.reset();
        }
    }

    /**
     * Clears all accmulated utilization info for the given database.
     */
    public void resetDbInfo(DatabaseId dbId) {
        removeDbFileSummaries(dbId);
    }

    /**
     * Returns the DatabaseImpl from the database key, which in this case is
     * the DatabaseId.
     */
    @Override
    DatabaseImpl databaseKeyToDatabaseImpl(Object databaseKey)
        throws DatabaseException {

        DatabaseId dbId = (DatabaseId) databaseKey;
        return env.getDbTree().getDb(dbId);
    }

    /**
     * Must release the database, since DbTree.getDb was called by
     * databaseKeyToDatabaseImpl.
     */
    @Override
    void releaseDatabaseImpl(DatabaseImpl db) {
        env.getDbTree().releaseDb(db);
    }
}
