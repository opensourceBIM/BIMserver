/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvConfigObserver;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.dbi.CursorImpl.SearchMode;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.FileSummaryLN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeLocation;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * The UP tracks utilization summary information for all log files.
 *
 * <p>Unlike the UtilizationTracker, the UP is not accessed under the log write
 * latch and is instead synchronized on itself for protecting the cache.  It is
 * not accessed during the primary data access path, except for when flushing
 * (writing) file summary LNs.  This occurs in the following cases:
 * <ol>
 * <li>The summary information is flushed at the end of a checkpoint.  This
 * allows tracking to occur in memory in between checkpoints, and replayed
 * during recovery.</li>
 * <li>When committing the truncateDatabase and removeDatabase operations, the
 * summary information is flushed because detail tracking for those operations
 * is not replayed during recovery</li>
 * <li>The evictor will ask the UtilizationTracker to flush the largest summary
 * if the memory taken by the tracker exeeds its budget.</li>
 * </ol>
 *
 * <p>The cache is populated by the RecoveryManager just before performing the
 * initial checkpoint.  The UP must be open and populated in order to respond
 * to requests to flush summaries and to evict tracked detail, even if the
 * cleaner is disabled.</p>
 *
 * <p>WARNING: While synchronized on this object, eviction is not permitted.
 * If it were, this could cause deadlocks because the order of locking would be
 * the UP object and then the evictor.  During normal eviction the order is to
 * first lock the evictor and then the UP, when evicting tracked detail.</p>
 *
 * <p>The methods in this class synchronize to protect the cached summary
 * information.  Some methods also access the UP database.  However, because
 * eviction must not occur while synchronized, UP database access is not
 * performed while synchronized except in one case: when inserting a new
 * summary record.  In that case we disallow eviction during the database
 * operation.</p>
 */
public class UtilizationProfile implements EnvConfigObserver {

    /*
     * Note that age is a distance between files not a number of files, that
     * is, deleted files are counted in the age.
     */
    private final EnvironmentImpl env;
    private final UtilizationTracker tracker;
    private DatabaseImpl fileSummaryDb;
    private SortedMap<Long, FileSummary> fileSummaryMap;
    private boolean cachePopulated;
    private final boolean rmwFixEnabled;
    private final FilesToMigrate filesToMigrate;

    /**
     * Minimum overall utilization threshold that triggers cleaning.  Is
     * non-private for unit tests.
     */
    int minUtilization;

    /**
     * Minimum utilization threshold for an individual log file that triggers
     * cleaning.  Is non-private for unit tests.
     */
    int minFileUtilization;

    /**
     * Minumum age to qualify for cleaning.  If the first active LSN file is 5
     * and the mininum age is 2, file 4 won't qualify but file 3 will.  Must be
     * greater than zero because we never clean the first active LSN file.  Is
     * non-private for unit tests.
     */
    int minAge;

    private final Logger logger;

    /**
     * Creates an empty UP.
     */
    public UtilizationProfile(EnvironmentImpl env,
                              UtilizationTracker tracker) {
        this.env = env;
        this.tracker = tracker;
        fileSummaryMap = new TreeMap<Long, FileSummary>();
        filesToMigrate = new FilesToMigrate();

        rmwFixEnabled = env.getConfigManager().getBoolean
            (EnvironmentParams.CLEANER_RMW_FIX);
        logger = LoggerUtils.getLogger(getClass());

        /* Initialize mutable properties and register for notifications. */
        envConfigUpdate(env.getConfigManager(), null);
        env.addConfigObserver(this);
    }

    /**
     * Process notifications of mutable property changes.
     */
    public void envConfigUpdate(DbConfigManager cm,
                                EnvironmentMutableConfig ignore) {
        minAge = cm.getInt(EnvironmentParams.CLEANER_MIN_AGE);
        minUtilization = cm.getInt(EnvironmentParams.CLEANER_MIN_UTILIZATION);
        minFileUtilization = cm.getInt
            (EnvironmentParams.CLEANER_MIN_FILE_UTILIZATION);
    }

    /**
     * @see EnvironmentParams#CLEANER_RMW_FIX
     * @see FileSummaryLN#postFetchInit
     */
    public boolean isRMWFixEnabled() {
        return rmwFixEnabled;
    }

    /**
     * Returns the number of files in the profile.
     */
    synchronized int getNumberOfFiles() {
        return fileSummaryMap.size();
    }

    /**
     * Returns an approximation of the total log size.  Used for stats.
     */
    long getTotalLogSize() {

        /* Start with the size from the profile. */
        long size = 0;
        synchronized (this) {
            for (FileSummary summary : fileSummaryMap.values()) {
                size += summary.totalSize;
            }
        }

        /*
         * Add sizes that are known to the tracker but are not yet in the
         * profile.  The FileSummary.totalSize field is the delta for new
         * log entries added.  Typically the last log file is only one that
         * will have a delta, but previous files may also not have been added
         * to the profile yet.
         */
        for (TrackedFileSummary summary : tracker.getTrackedFiles()) {
            size += summary.totalSize;
        }

        return size;
    }

    /**
     * Returns the cheapest file to clean from the given list of files.  This
     * method is used to select the first file to be cleaned in the batch of
     * to-be-cleaned files.
     */
    synchronized Long getCheapestFileToClean(SortedSet<Long> files) {
        if (files.size() == 1) {
            return files.first();
        }

        assert cachePopulated;

        Long bestFile = null;
        int bestCost = Integer.MAX_VALUE;

        final SortedMap<Long, FileSummary> currentFileSummaryMap =
            getFileSummaryMap(true /*includeTrackedFiles*/);

        for (Iterator<Long> iter = files.iterator(); iter.hasNext();) {
            Long file = iter.next();
            FileSummary summary = currentFileSummaryMap.get(file);

            /*
             * Return a file in the given set if it does not exist.  Deleted
             * files should be selected ASAP to remove them from the backlog.
             * [#18179] For details, see where FileProcessor.doClean handles
             * LogFileNotFoundException.
             */
            if (summary == null) {
                return file;
            }

            /* Calculate this file's cost to clean. */
            int thisCost = summary.getNonObsoleteCount();

            /* Select this file if it has the lowest cost so far. */
            if (bestFile == null || thisCost < bestCost) {
                bestFile = file;
                bestCost = thisCost;
            }
        }

        return bestFile;
    }

    /**
     * Returns the best file that qualifies for cleaning, or null if no file
     * qualifies.
     *
     * @param fileSelector is used to determine valid cleaning candidates.
     *
     * @param forceCleaning is true to always select a file, even if its
     * utilization is above the minimum utilization threshold.
     *
     * @param lowUtilizationFiles is a returned set of files that are below the
     * minimum utilization threshold.
     */
     Long getBestFileForCleaning(FileSelector fileSelector,
                                 boolean forceCleaning,
                                 Set<Long> lowUtilizationFiles,
                                 boolean isBacklog)
         throws DatabaseException {


         /*
          * Do not clean files protected from deletion by HA, for three reasons:
          * 1. Unlike the files protected by a DbBackup, files may be protected
          *    by HA for an extended period when a node is down.  The maximum
          *    interval is user configurable,
          * 2. It may be wasteful to clean a file before it can be deleted.  The
          *    file will normally become obsolete naturally over time, saving
          *    the work of migrating log entries during log cleaning later.
          * 3. If we clean files we cannot delete, the backlog will consume
          *    memory in the FileSelector.  By not cleaning them, we guard
          *    against excessive memory usage for a large cleaner backlog, when
          *    many files are protected.  (However, all existing files consume
          *    memory in the UtilizationProfile and DatabaseImpl.)
          * Note that the drawback of this approach is when a large number of
          * files become unprotected at once, a large amount of log cleaning may
          * suddenly be necessary.
          * [#16643]
          */

         /* 
          * Getting the cleaner barrier file may cause eviction, so do it 
          * outside the UtilizationProfile mutex. [#18475]
          */
         long minProtectedFile = env.getCleanerBarrierStartFile();
         if (minProtectedFile == -1) {

             /* 
              * The replicated node is not available, so the cleaner barrier can
              * not be read. Don't clean any files.
              */
             return null;
         }

         synchronized (this) {

             /* Start with an empty set.*/
             if (lowUtilizationFiles != null) {
                 lowUtilizationFiles.clear();
             }

             assert cachePopulated;

             /*
              * Get all file summaries including tracked files.  Tracked files
              * may be ready for cleaning if there is a large cache and many
              * files have not yet been flushed and do not yet appear in the
              * profile map.
              */
             SortedMap<Long, FileSummary> currentFileSummaryMap =
                 getFileSummaryMap(true /*includeTrackedFiles*/);

             /* Paranoia.  There should always be 1 file. */
             if (currentFileSummaryMap.size() == 0) {
                 return null;
             }

             /*
              * Use local variables for mutable properties.  Using values that
              * are changing during a single file selection pass would not
              * produce a well defined result.
              */
             final int useMinUtilization = minUtilization;
             final int useMinFileUtilization = minFileUtilization;
             final int useMinAge = minAge;

             /*
              * Cleaning must refrain from rearranging the portion of log
              * processed as recovery time. Do not clean a file greater or
              * equal to the first active file used in recovery, which is
              * either the last log file or the file of the first active LSN in
              * an active transaction, whichever is earlier.
              *
              * TxnManager.getFirstActiveLsn() (firstActiveTxnLsn below) is
              * guaranteed to be earlier or equal to the first active LSN of
              * the checkpoint that will be performed before deleting the
              * selected log file. By selecting a file prior to this point we
              * ensure that will not clean any entry that may be replayed by
              * recovery.
              *
              * For example:
              * 200 ckptA start, determines that ckpt's firstActiveLsn = 100
              * 400 ckptA end
              * 600 ckptB start, determines that ckpt's firstActiveLsn = 300
              * 800 ckptB end
              *
              * Any cleaning that executes before ckpt A start will be
              * constrained to files <= lsn 100, because it will have checked
              * the TxnManager.  If cleaning executes after ckptA start, it may
              * indeed clean after ckptA's firstActiveLsn, but the cleaning run
              * will wait to ckptB end to delete files.
              */
             long firstActiveFile = currentFileSummaryMap.lastKey().longValue();
             long firstActiveTxnLsn = env.getTxnManager().getFirstActiveLsn();
             if (firstActiveTxnLsn != DbLsn.NULL_LSN) {
                 long firstActiveTxnFile = 
                     DbLsn.getFileNumber(firstActiveTxnLsn);
                 if (firstActiveFile > firstActiveTxnFile) {
                     firstActiveFile = firstActiveTxnFile;
                 }
             }

             /*
              * Note that minAge is at least one and may be configured to a
              * higher value to prevent cleaning recently active files.
              */
             long lastFileToClean = firstActiveFile - useMinAge;

             /* Calculate totals and find the best file. */
             Iterator <Map.Entry<Long, FileSummary>> iter =
                 currentFileSummaryMap.entrySet().iterator();
             Long bestFile = null;
             int bestUtilization = 101;
             long totalSize = 0;
             long totalObsoleteSize = 0;

             while (iter.hasNext()) {
                 Map.Entry<Long, FileSummary> entry = iter.next();
                 Long file = entry.getKey();
                 long fileNum = file.longValue();

                 /*
                  * For files protected by HA, do not allow them to be selected
                  * and calculate the total utilization as if they do not
                  * exist.  When many files are protected and have low
                  * utilization, if we were to count them in the total then we
                  * may clean other unprotected files with higher utilization,
                  * which is expensive.  OTOH, with the current approach we may
                  * clean more unprotected files than necessary when the
                  * protected files have high utilization.  Overall, counting
                  * only the files that we can clean gives the best results
                  * from the selection algorithm.  [#16643]
                  */
                 if (fileNum >= minProtectedFile) {
                     continue;
                 }

                 /* Calculate this file's utilization. */
                 FileSummary summary = entry.getValue();
                 int obsoleteSize = summary.getObsoleteSize();

                 /*
                  * If the file is already being cleaned, only total the
                  * non-obsolete amount.  This is an optimistic prediction of
                  * the results of cleaning, and is used to prevent
                  * over-cleaning.  Update the total obsolete size to include
                  * the utilization DB records that will be deleted when the
                  * log file is deleted.
                  */
                 if (fileSelector.isFileCleaningInProgress(file)) {
                     totalSize += summary.totalSize - obsoleteSize;
                     totalObsoleteSize += estimateUPObsoleteSize(summary);
                     continue;
                 }

                 /* Add this file's value to the totals. */
                 totalSize += summary.totalSize;
                 totalObsoleteSize += obsoleteSize;

                 /* Skip files that are too young to be cleaned. */
                 if (fileNum > lastFileToClean) {
                     continue;
                 }

                 /* Select this file if it has the lowest utilization so far. */
                 int thisUtilization = utilization(obsoleteSize, 
                                                   summary.totalSize);
                 if (bestFile == null || thisUtilization < bestUtilization) {
                     bestFile = file;
                     bestUtilization = thisUtilization;
                 }

                 /* Return all low utilization files. */
                 if (lowUtilizationFiles != null &&
                     thisUtilization < useMinUtilization) {
                     lowUtilizationFiles.add(file);
                 }
             }

             /*
              * The first priority is to clean the log up to the minimum
              * utilization level, so if we're below the minimum (or an
              * individual file is below the minimum for any file), then we
              * clean the lowest utilization (best) file.  Otherwise, if there
              * are more files to migrate, we clean the next file to be
              * migrated.  Otherwise, if cleaning is forced (for unit testing),
              * we clean the lowest utilization file.
              */
             int totalUtilization = utilization(totalObsoleteSize, totalSize);
             if (totalUtilization < useMinUtilization ||
                 bestUtilization < useMinFileUtilization) {
                 return bestFile;
             } else if (!isBacklog &&
                        filesToMigrate.hasNext(currentFileSummaryMap)) {
                 return filesToMigrate.next(currentFileSummaryMap);
             } else if (forceCleaning) {
                 return bestFile;
             } else {
                 return null;
             }
         }
     }

    /**
     * Calculate the utilization percentage.
     */
    public static int utilization(long obsoleteSize, long totalSize) {
        if (totalSize != 0) {
            return (int) (((totalSize - obsoleteSize) * 100) / totalSize);
        } else {
            return 0;
        }
    }

    /**
     * Estimate the log size that will be made obsolete when a log file is
     * deleted and we delete its UP records.
     *
     * Note that we do not count the space taken by the deleted FileSummaryLN
     * records written during log file deletion.  These add the same amount to
     * the total log size and the obsolete log size, and therefore have a small
     * impact on total utilization.
     */
    private int estimateUPObsoleteSize(FileSummary summary) {

        /* Disabled for now; needs more testing. */
        if (true) {
            return 0;
        }

        /*
         * FileSummaryLN overhead:
         *  14 Header
         *   8 Node
         *   1 Deleted
         *   4 Data Length (0)
         *  32 Base Summary (8 X 4)
         *   8 PackedOffsets size and length (2 * 4)
         *   8 PackedOffsets first offset
         */
        final int OVERHEAD = 75;

        /*
         * Make an arbitrary estimate of the number of offsets per
         * FileSummaryLN.  Then estimate the total byte size, assuming all
         * short (2 byte) offsets.  Round up the total number of log entries.
         */
        int OFFSETS_PER_LN = 1000;
        int BYTES_PER_LN = OVERHEAD + (OFFSETS_PER_LN * 2 /* Size of short */);
        int totalNodes = summary.totalLNCount + summary.totalINCount;
        int logEntries = (totalNodes / OFFSETS_PER_LN) + 1 /* Round up */;
        return logEntries * BYTES_PER_LN;
    }

    /**
     * Gets the base summary from the cached map.  Add the tracked summary, if
     * one exists, to the base summary.  Sets all entries obsolete, if the file
     * is in the migrateFiles set.
     */
    private synchronized FileSummary getFileSummary(Long file) {

        /* Get base summary. */
        FileSummary summary = fileSummaryMap.get(file);

        /* Add tracked summary */
        TrackedFileSummary trackedSummary = tracker.getTrackedFile(file);
        if (trackedSummary != null) {
            FileSummary totals = new FileSummary();
            totals.add(summary);
            totals.add(trackedSummary);
            summary = totals;
        }

        return summary;
    }

    /**
     * Count the given locally tracked info as obsolete and then log the file
     * and database info..
     */
    public void flushLocalTracker(LocalUtilizationTracker localTracker)
        throws DatabaseException {

        /* Count tracked info under the log write latch. */
        env.getLogManager().transferToUtilizationTracker(localTracker);

        /* Write out the modified file and database info. */
        flushFileUtilization(localTracker.getTrackedFiles());
        flushDbUtilization(localTracker);
    }

    /**
     * Flush a FileSummaryLN node for each TrackedFileSummary that is currently
     * active in the given tracker.
     */
    public void flushFileUtilization(Collection<TrackedFileSummary>
                                     activeFiles)
        throws DatabaseException {

        /* Utilization flushing may be disabled for unittests. */
        if (!DbInternal.getCheckpointUP
            (env.getConfigManager().getEnvironmentConfig())) {
            return;
        }

        /* Write out the modified file summaries. */
        for (TrackedFileSummary activeFile : activeFiles) {
            long fileNum = activeFile.getFileNumber();
            TrackedFileSummary tfs = tracker.getTrackedFile(fileNum);
            if (tfs != null) {
                flushFileSummary(tfs);
            }
        }
    }

    /**
     * Flush a MapLN for each database that has dirty utilization in the given
     * tracker.
     */
    private void flushDbUtilization(LocalUtilizationTracker localTracker)
        throws DatabaseException {

        /* Utilization flushing may be disabled for unittests. */
        if (!DbInternal.getCheckpointUP
            (env.getConfigManager().getEnvironmentConfig())) {
            return;
        }

        /* Write out the modified MapLNs. */
        Iterator<Object> dbs = localTracker.getTrackedDbs().iterator();
        while (dbs.hasNext()) {
            DatabaseImpl db = (DatabaseImpl) dbs.next();
            if (!db.isDeleted() && db.isDirtyUtilization()) {
                env.getDbTree().modifyDbRoot(db);
            }
        }
    }

    /**
     * Returns a copy of the current file summary map, optionally including
     * tracked summary information, for use by the DbSpace utility and by unit
     * tests.  The returned map's key is a Long file number and its value is a
     * FileSummary.
     */
    public synchronized SortedMap<Long, FileSummary>
        getFileSummaryMap(boolean includeTrackedFiles) {

        assert cachePopulated;

        if (includeTrackedFiles) {

            /*
             * Copy the fileSummaryMap to a new map, adding in the tracked
             * summary information for each entry.
             */
            TreeMap<Long, FileSummary> map = new TreeMap<Long, FileSummary>();
            for (Long file : fileSummaryMap.keySet()) {
                FileSummary summary = getFileSummary(file);
                map.put(file, summary);
            }

            /* Add tracked files that are not in fileSummaryMap yet. */
            for (TrackedFileSummary summary : tracker.getTrackedFiles()) {
                Long fileNum = Long.valueOf(summary.getFileNumber());
                if (!map.containsKey(fileNum)) {
                    map.put(fileNum, summary);
                }
            }
            return map;
        } else {
            return new TreeMap<Long, FileSummary>(fileSummaryMap);
        }
    }

    /**
     * Clears the cache of file summary info.  The cache starts out unpopulated
     * and is populated on the first call to getBestFileForCleaning.
     */
    public synchronized void clearCache() {

        int memorySize = fileSummaryMap.size() *
            MemoryBudget.UTILIZATION_PROFILE_ENTRY;
        MemoryBudget mb = env.getMemoryBudget();
        mb.updateAdminMemoryUsage(0 - memorySize);

        fileSummaryMap = new TreeMap<Long, FileSummary>();
        cachePopulated = false;
    }

    /**
     * Removes a file from the utilization database and the profile, after it
     * has been deleted by the cleaner.
     */
    void removeFile(Long fileNum, Set<DatabaseId> databases)
        throws DatabaseException {

        /* Synchronize to update the cache. */
        synchronized (this) {
            assert cachePopulated;

            /* Remove from the cache. */
            FileSummary oldSummary = fileSummaryMap.remove(fileNum);
            if (oldSummary != null) {
                MemoryBudget mb = env.getMemoryBudget();
                mb.updateAdminMemoryUsage
                    (0 - MemoryBudget.UTILIZATION_PROFILE_ENTRY);
            }
        }

        /* Do not synchronize during LN deletion, to permit eviction. */
        deleteFileSummary(fileNum, databases);
    }

    /**
     * Deletes all FileSummaryLNs for the file and updates all MapLNs to remove
     * the DbFileSummary for the file.  This method performs eviction and is
     * not synchronized.
     */
    private void deleteFileSummary(final Long fileNum,
                                   Set<DatabaseId> databases)
        throws DatabaseException {

        /*
         * Update the MapLNs before deleting FileSummaryLNs in case there is an
         * error during this process.  If a FileSummaryLN exists, we will redo
         * this process during the next recovery (populateCache).
         */
        final LogManager logManager = env.getLogManager();
        final DbTree dbTree = env.getDbTree();
        /* Only call logMapTreeRoot once for ID and NAME DBs. */
        DatabaseImpl idDatabase = dbTree.getDb(DbTree.ID_DB_ID);
        DatabaseImpl nameDatabase = dbTree.getDb(DbTree.NAME_DB_ID);
        boolean logRoot = false;
        if (logManager.removeDbFileSummary(idDatabase, fileNum)) {
            logRoot = true;
        }
        if (logManager.removeDbFileSummary(nameDatabase, fileNum)) {
            logRoot = true;
        }
        if (logRoot) {
            env.logMapTreeRoot();
        }
        /* Use DB ID set if available to avoid full scan of ID DB. */
        if (databases != null) {
            for (DatabaseId dbId : databases) {
                if (!dbId.equals(DbTree.ID_DB_ID) &&
                    !dbId.equals(DbTree.NAME_DB_ID)) {
                    DatabaseImpl db = dbTree.getDb(dbId);
                    try {
                        if (db != null &&
                            logManager.removeDbFileSummary(db, fileNum)) {
                            dbTree.modifyDbRoot(db);
                        }
                    } finally {
                        dbTree.releaseDb(db);
                    }
                }
            }
        } else {

            /*
             * Use LockType.NONE for traversing the ID DB so that a lock is not
             * held when calling modifyDbRoot, which must release locks to
             * handle deadlocks.
             */
            CursorImpl.traverseDbWithCursor(idDatabase,
                                            LockType.NONE,
                                            true /*allowEviction*/,
                                            new CursorImpl.WithCursor() {
                public boolean withCursor(CursorImpl cursor,
                                          DatabaseEntry key,
                                          DatabaseEntry data)
                    throws DatabaseException {

                    MapLN mapLN = (MapLN) cursor.getCurrentLN(LockType.NONE);
                    if (mapLN != null) {
                        DatabaseImpl db = mapLN.getDatabase();
                        if (logManager.removeDbFileSummary(db, fileNum)) {

                            /*
                             * Because we're using dirty-read, silently do
                             * nothing if the DB does not exist
                             * (mustExist=false).
                             */
                            dbTree.modifyDbRoot
                                (db, DbLsn.NULL_LSN /*ifBeforeLsn*/,
                                 false /*mustExist*/);
                        }
                    }
                    return true;
                }
            });
        }

        /* Now delete all FileSummaryLNs. */
        Locker locker = null;
        CursorImpl cursor = null;
        boolean clearedTrackedFile = false;
        try {
            locker = BasicLocker.createBasicLocker(env, false /*noWait*/);
            cursor = new CursorImpl(fileSummaryDb, locker);
            /* Perform eviction in unsynchronized methods. */
            cursor.setAllowEviction(true);

            DatabaseEntry keyEntry = new DatabaseEntry();
            DatabaseEntry dataEntry = new DatabaseEntry();
            long fileNumVal = fileNum.longValue();

            /* Search by file number. */
            OperationStatus status = OperationStatus.SUCCESS;
            if (getFirstFSLN
                (cursor, fileNumVal, keyEntry, dataEntry, LockType.WRITE)) {
                status = OperationStatus.SUCCESS;
            } else {
                status = OperationStatus.NOTFOUND;
            }

            /* Delete all LNs for this file number. */
            while (status == OperationStatus.SUCCESS) {

                /* Perform eviction once per operation. */
                env.daemonEviction(true /*backgroundIO*/);

                FileSummaryLN ln = (FileSummaryLN)
                    cursor.getCurrentLN(LockType.NONE);

                if (ln != null) {
                    /* Stop if the file number changes. */
                    if (fileNumVal != ln.getFileNumber(keyEntry.getData())) {
                        break;
                    }

                    TrackedFileSummary tfs =
                        tracker.getTrackedFile(fileNumVal);
                    /* Associate the tracked summary so it will be cleared. */
                    if (tfs != null) {
                        ln.setTrackedSummary(tfs);
                        clearedTrackedFile = true;
                    }

                    /*
                     * Do not evict after deleting since the compressor would
                     * have to fetch it again.
                     */
                    cursor.latchBIN();
                    cursor.delete(ReplicationContext.NO_REPLICATE);
                }

                status = cursor.getNext
                    (keyEntry, dataEntry, LockType.WRITE,
                     true,    // forward
                     false);  // alreadyLatched
            }
        } finally {
            if (cursor != null) {
                cursor.releaseBINs();
                cursor.close();
            }
            if (locker != null) {
                locker.operationEnd();
            }
        }

        /*
         * If LN.setTrackedSummary was not called above, the file will not be
         * removed from the UtilizationTracker.  This can happen if a file is
         * resurrected in the tracker after being cleaned, deleted and removed
         * from the profile.  We'll end up here because FileProcessor.doClean
         * calls removeFile when it gets a LogFileNotFoundException.  For this
         * case we explicitly remove the file from the tracker below. [#16928]
         */
        if (!clearedTrackedFile) {
            TrackedFileSummary tfs = tracker.getTrackedFile(fileNum);
            if (tfs != null) {
                env.getLogManager().removeTrackedFile(tfs);
            }
        }
    }

    /**
     * Updates and stores the FileSummary for a given tracked file, if flushing
     * of the summary is allowed.
     */
    public void flushFileSummary(TrackedFileSummary tfs)
        throws DatabaseException {

        if (tfs.getAllowFlush()) {
            putFileSummary(tfs);
        }
    }

    /**
     * Updates and stores the FileSummary for a given tracked file.  This
     * method is synchronized and may not perform eviction.
     */
    private synchronized PackedOffsets putFileSummary(TrackedFileSummary tfs)
        throws DatabaseException {

        if (env.isReadOnly()) {
            throw EnvironmentFailureException.unexpectedState
                ("Cannot write file summary in a read-only environment");
        }

        if (tfs.isEmpty()) {
            return null; // no delta
        }

        if (!cachePopulated) {
            /* Db does not exist and this is a read-only environment. */
            return null;
        }

        long fileNum = tfs.getFileNumber();
        Long fileNumLong = Long.valueOf(fileNum);

        /* Get existing file summary or create an empty one. */
        FileSummary summary = fileSummaryMap.get(fileNumLong);
        if (summary == null) {

            /*
             * An obsolete node may have been counted after its file was
             * deleted, for example, when compressing a BIN.  Do not insert a
             * new profile record if no corresponding log file exists.  But if
             * the file number is greater than the last known file, this is a
             * new file that has been buffered but not yet flushed to disk; in
             * that case we should insert a new profile record.
             */
            if (!fileSummaryMap.isEmpty() &&
                fileNum < fileSummaryMap.lastKey() &&
                !env.getFileManager().isFileValid(fileNum)) {

                /*
                 * File was deleted by the cleaner.  Remove it from the
                 * UtilizationTracker and return.  Note that a file is normally
                 * removed from the tracker by FileSummaryLN.writeToLog method
                 * when it is called via insertFileSummary below. [#15512]
                 */
                env.getLogManager().removeTrackedFile(tfs);
                return null;
            }

            summary = new FileSummary();
        }

        /*
         * The key discriminator is a sequence that must be increasing over the
         * life of the file.  We use the sum of all entries counted.  We must
         * add the tracked and current summaries here to calculate the key.
         */
        FileSummary tmp = new FileSummary();
        tmp.add(summary);
        tmp.add(tfs);
        int sequence = tmp.getEntriesCounted();

        /* Insert an LN with the existing and tracked summary info. */
        FileSummaryLN ln = new FileSummaryLN(env, summary);
        ln.setTrackedSummary(tfs);
        insertFileSummary(ln, fileNum, sequence);

        /* Cache the updated summary object.  */
        summary = ln.getBaseSummary();
        if (fileSummaryMap.put(fileNumLong, summary) == null) {
            MemoryBudget mb = env.getMemoryBudget();
            mb.updateAdminMemoryUsage
                (MemoryBudget.UTILIZATION_PROFILE_ENTRY);
        }

        return ln.getObsoleteOffsets();
    }

    /**
     * Returns the stored/packed obsolete offsets and the tracked obsolete
     * offsets for the given file.  The tracked summary object returned can be
     * used to test for obsolete offsets that are being added during cleaning
     * by other threads participating in lazy migration.  The caller must call
     * TrackedFileSummary.setAllowFlush(true) when cleaning is complete.
     * This method performs eviction and is not synchronized.
     * @param logUpdate if true, log any updates to the utilization profile. If
     * false, only retrieve the new information.
     */
    TrackedFileSummary getObsoleteDetail(Long fileNum,
                                         PackedOffsets packedOffsets,
                                         boolean logUpdate)
        throws DatabaseException {

        /* Return if no detail is being tracked. */
        if (!env.getCleaner().trackDetail) {
            return null;
        }

        assert cachePopulated;

        long fileNumVal = fileNum.longValue();
        List<long[]> list = new ArrayList<long[]>();

        /*
         * Get an unflushable summary that will remain valid for the duration
         * of file cleaning.
         */
        TrackedFileSummary tfs =
            env.getLogManager().getUnflushableTrackedSummary(fileNumVal);

        /* Read the summary db. */
        Locker locker = null;
        CursorImpl cursor = null;
        try {
            locker = BasicLocker.createBasicLocker(env, false /*noWait*/);
            cursor = new CursorImpl(fileSummaryDb, locker);
            /* Perform eviction in unsynchronized methods. */
            cursor.setAllowEviction(true);

            DatabaseEntry keyEntry = new DatabaseEntry();
            DatabaseEntry dataEntry = new DatabaseEntry();

            /* Search by file number. */
            OperationStatus status = OperationStatus.SUCCESS;
            if (!getFirstFSLN
                (cursor, fileNumVal, keyEntry, dataEntry, LockType.NONE)) {
                status = OperationStatus.NOTFOUND;
            }

            /* Read all LNs for this file number. */
            while (status == OperationStatus.SUCCESS) {

                /* Perform eviction once per operation. */
                env.daemonEviction(true /*backgroundIO*/);

                FileSummaryLN ln = (FileSummaryLN)
                    cursor.getCurrentLN(LockType.NONE);
                if (ln != null) {
                    /* Stop if the file number changes. */
                    if (fileNumVal != ln.getFileNumber(keyEntry.getData())) {
                        break;
                    }

                    PackedOffsets offsets = ln.getObsoleteOffsets();
                    if (offsets != null) {
                        list.add(offsets.toArray());
                    }

                    /* Always evict after using a file summary LN. */
                    cursor.evict();
                }

                status = cursor.getNext
                    (keyEntry, dataEntry, LockType.NONE,
                     true,    // forward
                     false);  // alreadyLatched
            }
        } finally {
            if (cursor != null) {
                cursor.releaseBINs();
                cursor.close();
            }
            if (locker != null) {
                locker.operationEnd();
            }
        }

        /*
         * Write out tracked detail, if any, and add its offsets to the list.
         */
        if (!tfs.isEmpty()) {
            PackedOffsets offsets = null;
            if (logUpdate) {
                offsets = putFileSummary(tfs);
                if (offsets != null) {
                    list.add(offsets.toArray());
                }
            } else {
                long[] offsetList = tfs.getObsoleteOffsets();
                if (offsetList != null) {
                    list.add(offsetList);
                }
            }
        }

        /* Merge all offsets into a single array and pack the result. */
        int size = 0;
        for (int i = 0; i < list.size(); i += 1) {
            long[] a = list.get(i);
            size += a.length;
        }
        long[] offsets = new long[size];
        int index = 0;
        for (int i = 0; i < list.size(); i += 1) {
            long[] a = list.get(i);
            System.arraycopy(a, 0, offsets, index, a.length);
            index += a.length;
        }
        assert index == offsets.length;

        packedOffsets.pack(offsets);

        return tfs;
    }

    /**
     * Populate the profile for file selection.  This method performs eviction
     * and is not synchronized.  It must be called before recovery is complete
     * so that synchronization is unnecessary.  It must be called before the
     * recovery checkpoint so that the checkpoint can flush file summary
     * information.
     */
    public boolean populateCache()
        throws DatabaseException {

        assert !cachePopulated;

        /* Open the file summary db on first use. */
        if (!openFileSummaryDatabase()) {
            /* Db does not exist and this is a read-only environment. */
            return false;
        }

        int oldMemorySize = fileSummaryMap.size() *
            MemoryBudget.UTILIZATION_PROFILE_ENTRY;

        /*
         * It is possible to have an undeleted FileSummaryLN in the database
         * for a deleted log file if we crash after deleting a file but before
         * deleting the FileSummaryLN.  Iterate through all FileSummaryLNs and
         * add them to the cache if their corresponding log file exists.  But
         * delete those records that have no corresponding log file.
         */
        Long[] existingFiles = env.getFileManager().getAllFileNumbers();
        Locker locker = null;
        CursorImpl cursor = null;
        try {
            locker = BasicLocker.createBasicLocker(env, false /*noWait*/);
            cursor = new CursorImpl(fileSummaryDb, locker);
            /* Perform eviction in unsynchronized methods. */
            cursor.setAllowEviction(true);

            DatabaseEntry keyEntry = new DatabaseEntry();
            DatabaseEntry dataEntry = new DatabaseEntry();

            if (cursor.positionFirstOrLast(true, null)) {

                /* Retrieve the first record. */
                OperationStatus status =
                    cursor.getCurrentAlreadyLatched(keyEntry, dataEntry,
                                                    LockType.NONE, true);
                if (status != OperationStatus.SUCCESS) {
                    /* The record we're pointing at may be deleted. */
                    status = cursor.getNext(keyEntry, dataEntry, LockType.NONE,
                                            true,   // go forward
                                            false); // do need to latch
                }

                while (status == OperationStatus.SUCCESS) {

                    /*
                     * Perform eviction once per operation.  Pass false for
                     * backgroundIO because this is done during recovery and
                     * there is no reason to sleep.
                     */
                    env.daemonEviction(false /*backgroundIO*/);

                    FileSummaryLN ln = (FileSummaryLN)
                        cursor.getCurrentLN(LockType.NONE);

                    if (ln == null) {
                        /* Advance past a cleaned record. */
                        status = cursor.getNext
                            (keyEntry, dataEntry, LockType.NONE,
                             true,   // go forward
                             false); // do need to latch
                        continue;
                    }

                    byte[] keyBytes = keyEntry.getData();
                    boolean isOldVersion = ln.hasStringKey(keyBytes);
                    long fileNum = ln.getFileNumber(keyBytes);
                    Long fileNumLong = Long.valueOf(fileNum);

                    if (Arrays.binarySearch(existingFiles, fileNumLong) >= 0) {

                        /* File exists, cache the FileSummaryLN. */
                        FileSummary summary = ln.getBaseSummary();
                        fileSummaryMap.put(fileNumLong, summary);

                        /*
                         * Update old version records to the new version.  A
                         * zero sequence number is used to distinguish the
                         * converted records and to ensure that later records
                         * will have a greater sequence number.
                         */
                        if (isOldVersion && !env.isReadOnly()) {
                            insertFileSummary(ln, fileNum, 0);
                            cursor.latchBIN();
                            cursor.delete(ReplicationContext.NO_REPLICATE);
                        } else {
                            /* Always evict after using a file summary LN. */
                            cursor.evict();
                        }
                    } else {

                        /*
                         * File does not exist, remove the summary from the map
                         * and delete all FileSummaryLN records.
                         */
                        fileSummaryMap.remove(fileNumLong);

                        if (!env.isReadOnly()) {
                            if (isOldVersion) {
                                cursor.latchBIN();
                                cursor.delete(ReplicationContext.NO_REPLICATE);
                            } else {
                                deleteFileSummary(fileNumLong,
                                                  null /*databases*/);
                            }
                        }

                        /*
                         * Do not evict after deleting since the compressor
                         * would have to fetch it again.
                         */
                    }

                    /* Go on to the next entry. */
                    if (isOldVersion) {

                        /* Advance past the single old version record. */
                        status = cursor.getNext
                            (keyEntry, dataEntry, LockType.NONE,
                             true,   // go forward
                             false); // do need to latch
                    } else {

                        /*
                         * Skip over other records for this file by adding one
                         * to the file number and doing a range search.
                         */
                        if (!getFirstFSLN
                            (cursor,
                             fileNum + 1,
                             keyEntry, dataEntry,
                             LockType.NONE)) {
                            status = OperationStatus.NOTFOUND;
                        }
                    }
                }
            }
        } finally {
            if (cursor != null) {
                cursor.releaseBINs();
                cursor.close();
            }
            if (locker != null) {
                locker.operationEnd();
            }

            int newMemorySize = fileSummaryMap.size() *
                MemoryBudget.UTILIZATION_PROFILE_ENTRY;
            MemoryBudget mb = env.getMemoryBudget();
            mb.updateAdminMemoryUsage(newMemorySize - oldMemorySize);
        }

        cachePopulated = true;
        return true;
    }

    /**
     * Positions at the most recent LN for the given file number.
     */
    private boolean getFirstFSLN(CursorImpl cursor,
                                 long fileNum,
                                 DatabaseEntry keyEntry,
                                 DatabaseEntry dataEntry,
                                 LockType lockType)
        throws DatabaseException {

        byte[] keyBytes = FileSummaryLN.makePartialKey(fileNum);
        keyEntry.setData(keyBytes);

        int result = cursor.searchAndPosition(keyEntry,
                                              dataEntry,
                                              SearchMode.SET_RANGE,
                                              lockType);
        if ((result & CursorImpl.FOUND) == 0) {
            return false;
        }

        boolean exactKeyMatch = ((result & CursorImpl.EXACT_KEY) != 0);

        if (exactKeyMatch &&
            cursor.getCurrentAlreadyLatched
                 (keyEntry, dataEntry, lockType, true) !=
                    OperationStatus.KEYEMPTY) {
            return true;
        }

        /* Always evict after using a file summary LN. */
        cursor.evict(!exactKeyMatch); // alreadyLatched

        OperationStatus status = cursor.getNext
            (keyEntry, dataEntry, lockType,
             true,             // forward
             !exactKeyMatch);  // alreadyLatched

        return status == OperationStatus.SUCCESS;
    }

    /**
     * If the file summary db is already open, return, otherwise attempt to
     * open it.  If the environment is read-only and the database doesn't
     * exist, return false.  If the environment is read-write the database will
     * be created if it doesn't exist.
     */
    private boolean openFileSummaryDatabase()
        throws DatabaseException {

        if (fileSummaryDb != null) {
            return true;
        }
        DbTree dbTree = env.getDbTree();
        Locker autoTxn = null;
        boolean operationOk = false;
        try {
            autoTxn = Txn.createLocalAutoTxn(env, new TransactionConfig());

            /*
             * releaseDb is not called after this getDb or createDb because we
             * want to prohibit eviction of this database until the environment
             * is closed.
             */
            DatabaseImpl db = dbTree.getDb
                (autoTxn, DbTree.UTILIZATION_DB_NAME, null);
            if (db == null) {
                if (env.isReadOnly()) {
                    return false;
                }
                DatabaseConfig dbConfig = new DatabaseConfig();
                DbInternal.setReplicated(dbConfig, false);
                db = dbTree.createInternalDb
                    (autoTxn, DbTree.UTILIZATION_DB_NAME,
                     dbConfig);
            }
            fileSummaryDb = db;
            operationOk = true;
            return true;
        } finally {
            if (autoTxn != null) {
                autoTxn.operationEnd(operationOk);
            }
        }
    }

    /**
     * For unit testing.
     */
    public DatabaseImpl getFileSummaryDb() {
        return fileSummaryDb;
    }

    /**
     * Insert the given LN with the given key values.  This method is
     * synchronized and may not perform eviction.
     * 
     * Is public only for unit testing.
     */
    public synchronized boolean insertFileSummary(FileSummaryLN ln,
                                                  long fileNum,
                                                  int sequence)
        throws DatabaseException {

        byte[] keyBytes = FileSummaryLN.makeFullKey(fileNum, sequence);

        Locker locker = null;
        CursorImpl cursor = null;
        try {
            locker = BasicLocker.createBasicLocker(env, false /*noWait*/);
            cursor = new CursorImpl(fileSummaryDb, locker);

            /* Insert the LN. */
            OperationStatus status = cursor.putLN
                (keyBytes,
                 ln,
                 null,  // returnNewData
                 false, // allowDuplicates
                 ReplicationContext.NO_REPLICATE);

            if (status == OperationStatus.KEYEXIST) {
                LoggerUtils.traceAndLog
                    (logger, env, Level.SEVERE,
                     "Cleaner duplicate key sequence file=0x" +
                     Long.toHexString(fileNum) + " sequence=0x" +
                     Long.toHexString(sequence));
                return false;
            }

            /* Account for FileSummaryLN's extra marshaled memory. [#17462] */
            BIN bin = cursor.latchBIN();
            ln.addExtraMarshaledMemorySize(bin);
            cursor.releaseBIN();

            /* Always evict after using a file summary LN. */
            cursor.evict();
            return true;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (locker != null) {
                locker.operationEnd();
            }
        }
    }

    /**
     * Checks that all FSLN offsets are indeed obsolete.  Assumes that the
     * system is quiesent (does not lock LNs).  This method is not synchronized
     * (because it doesn't access fileSummaryMap) and eviction is allowed.
     *
     * @return true if no verification failures.
     */
    public boolean verifyFileSummaryDatabase()
        throws DatabaseException {

        DatabaseEntry key = new DatabaseEntry();
        DatabaseEntry data = new DatabaseEntry();

        openFileSummaryDatabase();
        Locker locker = null;
        CursorImpl cursor = null;
        boolean ok = true;

        try {
            locker = BasicLocker.createBasicLocker(env, false /*noWait*/);
            cursor = new CursorImpl(fileSummaryDb, locker);
            cursor.setAllowEviction(true);

            if (cursor.positionFirstOrLast(true, null)) {

                OperationStatus status = cursor.getCurrentAlreadyLatched
                    (key, data, LockType.NONE, true);

                /* Iterate over all file summary lns. */
                while (status == OperationStatus.SUCCESS) {

                    /* Perform eviction once per operation. */
                    env.daemonEviction(true /*backgroundIO*/);

                    FileSummaryLN ln = (FileSummaryLN)
                        cursor.getCurrentLN(LockType.NONE);

                    if (ln != null) {
                        long fileNumVal = ln.getFileNumber(key.getData());
                        PackedOffsets offsets = ln.getObsoleteOffsets();

                        /*
                         * Check every offset in the fsln to make sure it's
                         * truely obsolete.
                         */
                        if (offsets != null) {
                            long[] vals = offsets.toArray();
                            for (int i = 0; i < vals.length; i++) {
                                long lsn = DbLsn.makeLsn(fileNumVal, vals[i]);
                                if (!verifyLsnIsObsolete(lsn)) {
                                    ok = false;
                                }
                            }
                        }

                        cursor.evict();
                        status = cursor.getNext(key, data, LockType.NONE,
                                                true,   // forward
                                                false); // already latched
                    }
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (locker != null) {
                locker.operationEnd();
            }
        }

        return ok;
    }

    /*
     * Return true if the LN at this lsn is obsolete.
     */
    private boolean verifyLsnIsObsolete(long lsn)
        throws DatabaseException {

        /* Read the whole entry out of the log. */
        Object o = env.getLogManager().getLogEntryHandleFileNotFound(lsn);
        if (!(o instanceof LNLogEntry)) {
            return true;
        }
        LNLogEntry entry = (LNLogEntry)o;

        /* All deleted LNs are obsolete. */
        if (entry.getLN().isDeleted()) {
            return true;
        }

        /* Find the owning database. */
        DatabaseId dbId = entry.getDbId();
        DatabaseImpl db = env.getDbTree().getDb(dbId);

        /*
         * Search down to the bottom most level for the parent of this LN.
         */
        BIN bin = null;
        try {

            /*
             * The whole database is gone, so this LN is obsolete. No need
             * to worry about delete cleanup; this is just verification and
             * no cleaning is done.
             */
            if (db == null || db.isDeleted()) {
                return true;
            }

            Tree tree = db.getTree();
            TreeLocation location = new TreeLocation();
            boolean parentFound = tree.getParentBINForChildLN
                (location,
                 entry.getKey(),
                 entry.getDupKey(),
                 entry.getLN(),
                 false,  // splitsAllowed
                 true,   // findDeletedEntries
                 false,  // searchDupTree ???
                 CacheMode.UNCHANGED);
            bin = location.bin;
            int index = location.index;

            /* Is bin latched ? */
            if (!parentFound) {
                return true;
            }

            /*
             * Now we're at the parent for this LN, whether BIN, DBIN or DIN.
             * If knownDeleted, LN is deleted and can be purged.
             */
            if (bin.isEntryKnownDeleted(index)) {
                return true;
            }

            if (bin.getLsn(index) != lsn) {
                return true;
            }

            /* Oh no -- this lsn is in the tree. */
            /* should print, or trace? */
            System.err.println("lsn " + DbLsn.getNoFormatString(lsn)+
                               " was found in tree.");
            return false;
        } finally {
            env.getDbTree().releaseDb(db);
            if (bin != null) {
                bin.releaseLatch();
            }
        }
    }

    /**
     * Update memory budgets when this profile is closed and will never be
     * accessed again.
     */
    void close() {
        clearCache();
        if (fileSummaryDb != null) {
            fileSummaryDb.releaseTreeAdminMemory();
        }
    }

    /**
     * Iterator over files that should be migrated by cleaning them, even if
     * they don't need to be cleaned for other reasons.
     *
     * Files are migrated either because they are named in the
     * CLEANER_FORCE_CLEAN_FILES parameter or their log version is prior to the
     * CLEANER_UPGRADE_TO_LOG_VERSION parameter.
     *
     * An iterator is used rather than finding the entire set at startup to
     * avoid opening a large number of files to examine their log version.  For
     * example, if all files are being migrated in a very large data set, this
     * would involve opening a very large number of files in order to read
     * their header.  This could significantly delay application startup.
     *
     * Because we don't have the entire set at startup, we can't select the
     * lowest utilization file from the set to clean next.  Inteaad we iterate
     * in file number order to increase the odds of cleaning lower utilization
     * files first.
     */
    private class FilesToMigrate {

        /**
         * An array of pairs of file numbers, where each pair is a range of
         * files to be force cleaned.  Index i is the from value and i+1 is the
         * to value, both inclusive.
         */
        private long[] forceCleanFiles;

        /** Log version to upgrade to, or zero if none. */
        private int upgradeToVersion;

        /** Whether to continue checking the log version. */
        private boolean checkLogVersion;

        /** Whether hasNext() has prepared a valid nextFile. */
        private boolean nextAvailable;

        /** File to return; set by hasNext() and returned by next(). */
        private long nextFile;

        FilesToMigrate() {
            String forceCleanProp = env.getConfigManager().get
                (EnvironmentParams.CLEANER_FORCE_CLEAN_FILES);
            parseForceCleanFiles(forceCleanProp);

            upgradeToVersion = env.getConfigManager().getInt
                (EnvironmentParams.CLEANER_UPGRADE_TO_LOG_VERSION);
            if (upgradeToVersion == -1) {
                upgradeToVersion = LogEntryType.LOG_VERSION;
            }

            checkLogVersion = (upgradeToVersion != 0);
            nextAvailable = false;
            nextFile = -1;
        }

        /**
         * Returns whether there are more files to be migrated.  Must be called
         * while synchronized on the UtilizationProfile.
         */
        boolean hasNext(SortedMap<Long, FileSummary> currentFileSummaryMap)
            throws DatabaseException {

            if (nextAvailable) {
                /* hasNext() has returned true since the last next(). */
                return true;
            }
            long foundFile = -1;
            for (long file :
                 currentFileSummaryMap.tailMap(nextFile + 1).keySet()) {
                if (isForceCleanFile(file)) {
                    /* Found a file to force clean. */
                    foundFile = file;
                    break;
                } else if (checkLogVersion) {
                    try {
                        int logVersion =
                            env.getFileManager().getFileLogVersion(file);
                        if (logVersion < upgradeToVersion) {
                            /* Found a file to migrate. */
                            foundFile = file;
                            break;
                        } else {

                            /*
                             * All following files have a log version greater
                             * or equal to this one; stop checking.
                             */
                            checkLogVersion = false;
                        }
                    } catch (DatabaseException e) {
                        /* Throw exception but allow iterator to continue. */
                        nextFile = file;
                        throw e;
                    }
                }
            }
            if (foundFile != -1) {
                nextFile = foundFile;
                nextAvailable = true;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Returns the next file file to be migrated.  Must be called while
         * synchronized on the UtilizationProfile.
         */
        long next(SortedMap<Long, FileSummary> currentFileSummaryMap)
            throws NoSuchElementException, DatabaseException {

            if (hasNext(currentFileSummaryMap)) {
                nextAvailable = false;
                return nextFile;
            } else {
                throw new NoSuchElementException();
            }
        }

        /**
         * Returns whether the given file is in the forceCleanFiles set.
         */
        private boolean isForceCleanFile(long file) {

            if (forceCleanFiles != null) {
                for (int i = 0; i < forceCleanFiles.length; i += 2) {
                    long from = forceCleanFiles[i];
                    long to = forceCleanFiles[i + 1];
                    if (file >= from && file <= to) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Parses the je.cleaner.forceCleanFiles property value and initializes
         * the forceCleanFiles field.
         *
         * @throws IllegalArgumentException via Environment ctor and
         * setMutableConfig.
         */
        private void parseForceCleanFiles(String propValue)
            throws IllegalArgumentException {

            if (propValue == null || propValue.length() == 0) {
                forceCleanFiles = null;
            } else {
                String errPrefix = "Error in " +
                    EnvironmentParams.CLEANER_FORCE_CLEAN_FILES.getName() +
                    "=" + propValue + ": ";

                StringTokenizer tokens = new StringTokenizer
                    (propValue, ",-", true /*returnDelims*/);

                /* Resulting list of Long file numbers. */
                List<Long> list = new ArrayList<Long>();

                while (tokens.hasMoreTokens()) {

                    /* Get "from" file number. */
                    String fromStr = tokens.nextToken();
                    long fromNum;
                    try {
                        fromNum = Long.parseLong(fromStr, 16);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException
                            (errPrefix + "Invalid hex file number: " +
                             fromStr);
                    }

                    long toNum = -1;
                    if (tokens.hasMoreTokens()) {

                        /* Get delimiter. */
                        String delim = tokens.nextToken();
                        if (",".equals(delim)) {
                            toNum = fromNum;
                        } else if ("-".equals(delim)) {

                            /* Get "to" file number." */
                            if (tokens.hasMoreTokens()) {
                                String toStr = tokens.nextToken();
                                try {
                                    toNum = Long.parseLong(toStr, 16);
                                } catch (NumberFormatException e) {
                                    throw new IllegalArgumentException
                                        (errPrefix +
                                         "Invalid hex file number: " +
                                         toStr);
                                }
                            } else {
                                throw new IllegalArgumentException
                                    (errPrefix + "Expected file number: " +
                                     delim);
                            }
                        } else {
                            throw new IllegalArgumentException
                                (errPrefix + "Expected '-' or ',': " + delim);
                        }
                    } else {
                        toNum = fromNum;
                    }

                    assert toNum != -1;
                    list.add(Long.valueOf(fromNum));
                    list.add(Long.valueOf(toNum));
                }

                forceCleanFiles = new long[list.size()];
                for (int i = 0; i < forceCleanFiles.length; i += 1) {
                    forceCleanFiles[i] = list.get(i).longValue();
                }
            }
        }
    }
}
