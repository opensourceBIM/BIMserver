/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_BACKLOG;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_FILE_DELETION_BACKLOG;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.utilint.IntStat;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.TestHookExecute;
import com.sleepycat.je.utilint.VLSN;

/**
 * Keeps track of the status of files for which cleaning is in progres.
 */
public class FileSelector {

    /**
     * Each file for which cleaning is in progress has one of the following
     * status values.  Files numbers migrate from one status to another, in
     * the order declared below.
     */
    private enum FileStatus {

        /**
         * A file's status is initially TO_BE_CLEANED when it is selected as
         * part of a batch of files that, when deleted, will bring total
         * utilization down to the minimum configured value.  All files with
         * this status will be cleaned in lowest-cost-to-clean order.  For two
         * files of equal cost to clean, the lower numbered (oldest) files is
         * selected; this is why the fileInfoMap is sorted by key (file
         * number).
         */
        TO_BE_CLEANED,

        /**
         * When a TO_BE_CLEANED file is selected for processing by
         * FileProcessor, it is moved to the BEING_CLEANED status.  This
         * distinction is used to prevent a file from being processed by more
         * than one thread.
         */
        BEING_CLEANED,

        /**
         * A file is moved to the CLEANED status when all its log entries have
         * been read and processed.  However, entries needing migration will be
         * marked with the BIN entry MIGRATE flag, entries that could not be
         * locked will be in the pending LN set, and the DBs that were pending
         * deletion will be in the pending DB set.
         */
        CLEANED,

        /**
         * A file is moved to the CHECKPOINTED status at the end of a
         * checkpoint if it was CLEANED at the beginning of the checkpoint.
         * Because all dirty BINs are flushed during the checkpoints, no files
         * in this set will have entries with the MIGRATE flag set.  However,
         * some entries may be in the pending LN set and some DBs may be in the
         * pending DB set.
         */
        CHECKPOINTED,

        /**
         * A file is moved from the CHECKPOINTED status to the FULLY_PROCESSED
         * status when the pending LN/DB sets become empty.  Since a pending LN
         * was not locked successfully, we don't know its original file.  But
         * we do know that when no pending LNs are present for any file, all
         * log entries in CHECKPOINTED files are either obsolete or have been
         * migrated.  Note, however, that the parent BINs of the migrated
         * entries may not have been logged yet.
         *
         * No special handling is required to coordinate syncing of deferred
         * write databases for pending, deferred write LNs, because
         * non-temporary deferred write DBs are always synced during
         * checkpoints, and temporary deferred write DBs are not recovered.
         * Note that although DW databases are non-txnal, their LNs may be
         * pended because of lock collisions.
         */
        FULLY_PROCESSED,

        /**
         * A file is moved to the SAFE_TO_DELETE status at the end of a
         * checkpoint if it was FULLY_PROCESSED at the beginning of the
         * checkpoint.  All parent BINs of migrated entries have now been
         * logged.
         */
        SAFE_TO_DELETE;
    }

    /**
     * Information about a file being cleaned.
     */
    private static class FileInfo {
        FileStatus status;
        Set<DatabaseId> dbIds;
        VLSN lastVlsn = VLSN.NULL_VLSN;

        @Override
        public String toString() {
            return "status = " + status +
                   " dbIds = " + dbIds +
                   " lastVlsn = " + lastVlsn;
        }
    }

    /**
     * Information about files being cleaned, keyed by file number.  The map is
     * sorted by file number to clean older files before newer files.
     */
    private SortedMap<Long, FileInfo> fileInfoMap;

    /**
     * Pending LN info, keyed by node ID.  These are LNs that could not be
     * locked, either during processing or during migration.
     */
    private Map<Long, LNInfo> pendingLNs;

    /**
     * For processed entries with DBs that are pending deletion, we consider
     * them to be obsolete but we store their DatabaseIds in a set.  Until the
     * DB deletion is complete, we can't delete the log files containing those
     * entries.
     */
    private Set<DatabaseId> pendingDBs;

    /**
     * If during a checkpoint there are no pending LNs or DBs added, we can
     * move CLEANED files to SAFE_TO_DELETE files at the end of the checkpoint.
     * This is an optimization that allows deleting files more quickly when
     * possible. In particular this impacts the checkpoint during environment
     * close, since no user operations are active during that checkpoint; this
     * optimization allows us to delete all cleaned files after the final
     * checkpoint.
     */
    private boolean anyPendingDuringCheckpoint;

    /**
     * As a side effect of file selection a set of low utilization files is
     * determined.  This set is guaranteed to be non-null and read-only, so no
     * synchronization is needed when accessing it.
     */
    private Set<Long> lowUtilizationFiles;

    /* For unit tests */
    private TestHook fileChosenHook;

    FileSelector() {
        fileInfoMap = new TreeMap<Long, FileInfo>();
        pendingLNs = new HashMap<Long, LNInfo>();
        pendingDBs = new HashSet<DatabaseId>();
        lowUtilizationFiles = Collections.emptySet();
    }

    /* For unit testing only. */
    public void setFileChosenHook(TestHook hook) {
        fileChosenHook = hook;
    }

    /**
     * Returns the best file that qualifies for cleaning, or null if no file
     * qualifies.
     *
     * @param forceCleaning is true to always select a file, even if its
     * utilization is above the minimum utilization threshold.
     *
     * @param calcLowUtilizationFiles whether to recalculate the set of files
     * that are below the minimum utilization threshold.
     *
     * @param maxBatchFiles is the maximum number of files to be selected at
     * one time, or zero if there is no limit.
     *
     * @return the next file to be cleaned, or null if no file needs cleaning.
     */
    Long selectFileForCleaning(UtilizationProfile profile,
                               boolean forceCleaning,
                               boolean calcLowUtilizationFiles,
                               int maxBatchFiles)
        throws DatabaseException {

        /*
         * Note that because it calls UtilizationProfile methods, this method
         * itself cannot be synchronized.  Synchronization is done elsewhere in
         * the order [UtilizationProfile, FileSelector], so this method can't
         * synchronize first on FileSelector and then call a UtilizationProfile
         * method without causing a deadlock.  However, it must synchronize
         * while accessing private fields.  Retries are performed when
         * necessary to work around the lack of synchronization.  See below.
         */
        Set<Long> newLowUtilizationFiles = calcLowUtilizationFiles ?
            (new HashSet<Long>()) : null;

        /*
         * Add files until we reach the theoretical minimum utilization
         * threshold.
         */
        while (true) {

            int toBeCleanedSize = getNumberOfFiles(FileStatus.TO_BE_CLEANED);
            if (maxBatchFiles > 0 &&
                toBeCleanedSize >= maxBatchFiles) {
                break;
            }

            Long fileNum = profile.getBestFileForCleaning
                (this, forceCleaning, newLowUtilizationFiles,
                 toBeCleanedSize > 0 /*isBacklog*/);

            if (fileNum == null) {
                break;
            }

            assert TestHookExecute.doHookIfSet(fileChosenHook);

            /*
             * Because we don't synchronize on the FileSelector while calling
             * UtilizationProfile.getBestFileForCleaning, another thread may
             * have selected this file.  Add the file only if not already being
             * cleaned.  [#17079]
             *
             * There is also a possibility that another thread will have
             * already cleaned and deleted the file.  In that case, we will
             * return it and attempt to clean it again, but
             * FileProcessor.doClean will detect this situation and recover.
             */
            synchronized (this) {
                if (!isFileCleaningInProgress(fileNum)) {
                    setStatus(fileNum, FileStatus.TO_BE_CLEANED);
                }
            }
        }

        /* Update the read-only set. */
        if (newLowUtilizationFiles != null) {
            lowUtilizationFiles = newLowUtilizationFiles;
        }

        /*
         * Select the cheapest file to clean from a copy of the TO_BE_CLEANED
         * files.  Then move the file from the TO_BE_CLEANED status to the
         * BEING_CLEANED status.
         *
         * Because we don't synchronize on the FileSelector while calling
         * UtilizationProfile.getCheapestFileToClean, another thread may have
         * selected this file.  Select the file only if it is waiting
         * TO_BE_CLEANED.  [#17079]
         */
        SortedSet<Long> availableFiles = getFiles(FileStatus.TO_BE_CLEANED);
        while (availableFiles.size() > 0) {
            Long fileNum = profile.getCheapestFileToClean(availableFiles);
            if (fileNum == null) {
                return null;
            }
            synchronized (this) {
                FileInfo info = fileInfoMap.get(fileNum);
                if (info != null && info.status == FileStatus.TO_BE_CLEANED) {
                    setStatus(fileNum, FileStatus.BEING_CLEANED);
                    return fileNum;
                }
                availableFiles.remove(fileNum);
            }
        }
        return null;
    }

    /**
     * Returns the number of files having the given status.
     */
    private synchronized int getNumberOfFiles(FileStatus status) {
        int count = 0;
        for (FileInfo info : fileInfoMap.values()) {
            if (info.status == status) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Returns a sorted set of files having the given status.
     */
    private synchronized SortedSet<Long> getFiles(FileStatus status) {
        SortedSet<Long> set = new TreeSet<Long>();
        for (Map.Entry<Long, FileInfo> entry : fileInfoMap.entrySet()) {
            if (entry.getValue().status == status) {
                set.add(entry.getKey());
            }
        }
        return set;
    }

    /**
     * Moves a file to a given status, adding the file to the fileInfoMap if
     * necessary.
     *
     * This method must be called while synchronized.
     */
    private FileInfo setStatus(Long fileNum, FileStatus newStatus) {
        FileInfo info = fileInfoMap.get(fileNum);
        if (info == null) {
            info = new FileInfo();
            fileInfoMap.put(fileNum, info);
        }
        info.status = newStatus;
        return info;
    }

    /**
     * Moves a collection of files to a given status, adding the files to the
     * fileInfoMap if necessary.
     *
     * This method must be called while synchronized.
     */
    private void setStatus(Collection<Long> files, FileStatus newStatus) {
        for (Long fileNum : files) {
            setStatus(fileNum, newStatus);
        }
    }

    /**
     * Moves all files with oldStatus to newStatus.
     *
     * This method must be called while synchronized.
     */
    private void setStatus(FileStatus oldStatus, FileStatus newStatus) {
        for (FileInfo info : fileInfoMap.values()) {
            if (info.status == oldStatus) {
                info.status = newStatus;
            }
        }
    }

    /**
     * Asserts that a file has a given status.  Should only be called under an
     * assertion to avoid the overhead of the method call and synchronization.
     * Always returns true to enable calling it under an assertion.
     *
     * This method must be called while synchronized.
     */
    private boolean checkStatus(Long fileNum, FileStatus expectStatus) {
        final FileInfo info = fileInfoMap.get(fileNum);
        assert info != null : "Expected " + expectStatus + " but was missing";
        assert info.status == expectStatus :
            "Expected " + expectStatus + " but was " + info.status;
        return true;
    }

    /**
     * Calls checkStatus(Long, FileStatus) for a collection of files.
     *
     * This method must be called while synchronized.
     */
    private boolean checkStatus(final Collection<Long> files,
                                final FileStatus expectStatus) {
        for (Long fileNum : files) {
            checkStatus(fileNum, expectStatus);
        }
        return true;
    }

    /**
     * Returns whether the file is in any stage of the cleaning process.
     */
    synchronized boolean isFileCleaningInProgress(Long fileNum) {
        return fileInfoMap.containsKey(fileNum);
    }

    private boolean isFileCleaningInProgress(Collection<Long> files) {
        for (Long file : files) {
            if (isFileCleaningInProgress(file)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all references to a file.
     */
    synchronized void removeAllFileReferences(Long fileNum,
                                              MemoryBudget budget) {
        FileInfo info = fileInfoMap.get(fileNum);
        if (info != null) {
            adjustMemoryBudget(budget, info.dbIds, null /*newDatabases*/);
            fileInfoMap.remove(fileNum);
        }
    }

    /**
     * When file cleaning is aborted, move the file back from BEING_CLEANED to
     * TO_BE_CLEANED.
     */
    synchronized void putBackFileForCleaning(Long fileNum) {
        assert checkStatus(fileNum, FileStatus.BEING_CLEANED);
        setStatus(fileNum, FileStatus.TO_BE_CLEANED);
    }

    /**
     * For unit testing.
     */
    public synchronized void injectFileForCleaning(Long fileNum) {
        if (!isFileCleaningInProgress(fileNum)) {
            setStatus(fileNum, FileStatus.TO_BE_CLEANED);
        }
    }

    /**
     * When cleaning is complete, move the file from the BEING_CLEANED to
     * CLEANED.
     */
    synchronized void addCleanedFile(Long fileNum,
                                     Set<DatabaseId> databases,
                                     VLSN lastVlsn,
                                     MemoryBudget budget) {
        assert checkStatus(fileNum, FileStatus.BEING_CLEANED);
        FileInfo info = setStatus(fileNum, FileStatus.CLEANED);
        adjustMemoryBudget(budget, info.dbIds, databases);
        info.dbIds = databases;
        info.lastVlsn = lastVlsn;
    }

    /**
     * Returns a read-only set of low utilization files that can be accessed
     * without synchronization.
     */
    Set<Long> getLowUtilizationFiles() {
        /* This set is read-only, so there is no need to make a copy. */
        return lowUtilizationFiles;
    }

    /**
     * Returns a read-only copy of TO_BE_CLEANED files that can be accessed
     * without synchronization.
     */
    synchronized Set<Long> getToBeCleanedFiles() {
        return getFiles(FileStatus.TO_BE_CLEANED);
    }

    /**
     * Returns the number of files waiting TO_BE_CLEANED.
     */
    int getBacklog() {
        return getNumberOfFiles(FileStatus.TO_BE_CLEANED);
    }

    /**
     * Returns a copy of the CLEANED and FULLY_PROCESSED files at the time a
     * checkpoint starts.
     */
    synchronized CheckpointStartCleanerState getFilesAtCheckpointStart() {

        anyPendingDuringCheckpoint = !pendingLNs.isEmpty() ||
            !pendingDBs.isEmpty();

        CheckpointStartCleanerState info = new CheckpointStartCleanerState
            (getFiles(FileStatus.CLEANED),
             getFiles(FileStatus.FULLY_PROCESSED));
        return info;
    }

    /**
     * When a checkpoint is complete, move the previously CLEANED and
     * FULLY_PROCESSED files to the CHECKPOINTED and SAFE_TO_DELETE status.
     */
    synchronized void
        updateFilesAtCheckpointEnd(CheckpointStartCleanerState info) {

        if (!info.isEmpty()) {

            Set<Long> previouslyCleanedFiles = info.getCleanedFiles();
            if (previouslyCleanedFiles != null) {
                assert checkStatus(previouslyCleanedFiles, FileStatus.CLEANED);
                setStatus(previouslyCleanedFiles, anyPendingDuringCheckpoint ?
                                                  FileStatus.CHECKPOINTED :
                                                  FileStatus.SAFE_TO_DELETE);
            }

            Set<Long> previouslyProcessedFiles = info.getFullyProcessedFiles();
            if (previouslyProcessedFiles != null) {
                assert checkStatus(previouslyProcessedFiles,
                                   FileStatus.FULLY_PROCESSED);
                setStatus(previouslyProcessedFiles, FileStatus.SAFE_TO_DELETE);
            }

            updateProcessedFiles();
        }
    }

    /**
     * Adds the given LN info to the pending LN set.
     */
    synchronized boolean addPendingLN(LN ln,
                                      DatabaseId dbId,
                                      byte[] key,
                                      byte[] dupKey) {
        assert ln != null;

        boolean added = pendingLNs.put
            (Long.valueOf(ln.getNodeId()),
             new LNInfo(ln, dbId, key, dupKey)) != null;

        anyPendingDuringCheckpoint = true;
        return added;
    }

    /**
     * Returns an array of LNInfo for LNs that could not be migrated in a
     * prior cleaning attempt, or null if no LNs are pending.
     */
    synchronized LNInfo[] getPendingLNs() {

        if (pendingLNs.size() > 0) {
            LNInfo[] lns = new LNInfo[pendingLNs.size()];
            pendingLNs.values().toArray(lns);
            return lns;
        } else {
            return null;
        }
    }

    /**
     * Removes the LN for the given node ID from the pending LN set.
     */
    synchronized void removePendingLN(long nodeId) {

        pendingLNs.remove(nodeId);
        updateProcessedFiles();
    }

    /**
     * Adds the given DatabaseId to the pending DB set.
     */
    synchronized boolean addPendingDB(DatabaseId dbId) {

        boolean added = pendingDBs.add(dbId);

        anyPendingDuringCheckpoint = true;
        return added;
    }

    /**
     * Returns an array of DatabaseIds for DBs that were pending deletion in a
     * prior cleaning attempt, or null if no DBs are pending.
     */
    synchronized DatabaseId[] getPendingDBs() {

        if (pendingDBs.size() > 0) {
            DatabaseId[] dbs = new DatabaseId[pendingDBs.size()];
            pendingDBs.toArray(dbs);
            return dbs;
        } else {
            return null;
        }
    }

    /**
     * Removes the DatabaseId from the pending DB set.
     */
    synchronized void removePendingDB(DatabaseId dbId) {

        pendingDBs.remove(dbId);
        updateProcessedFiles();
    }

    /**
     * Returns a copy of the SAFE_TO_DELETE files, or null if there are none.
     */
    synchronized SortedSet<Long> copySafeToDeleteFiles() {
        SortedSet<Long> set = getFiles(FileStatus.SAFE_TO_DELETE);
        return (set.size() > 0) ? set : null;
    }

    /**
     * Returns a copy of the databases for a cleaned file, or null if there are
     * none.
     */
    synchronized Set<DatabaseId> getCleanedDatabases(Long fileNum) {
        FileInfo info = fileInfoMap.get(fileNum);
        return (info != null) ? new HashSet<DatabaseId>(info.dbIds) : null;
    }

    /**
     * Returns the last VLSN for a cleaned file.
     */
    synchronized VLSN getLastVLSN(Long fileNum) {
        FileInfo info = fileInfoMap.get(fileNum);
        return (info != null) ? info.lastVlsn : null;
    }

    /**
     * Removes file information after the log file itself has finally been
     * deleted.
     */
    synchronized void removeDeletedFile(Long fileNum, MemoryBudget budget) {
        assert checkStatus(fileNum, FileStatus.SAFE_TO_DELETE);
        FileInfo info = fileInfoMap.remove(fileNum);
        if (info != null) {
            adjustMemoryBudget(budget, info.dbIds, null /*newDatabases*/);
        }
    }

    /**
     * Update memory budgets when the environment is closed and will never be
     * accessed again.
     */
    synchronized void close(MemoryBudget budget) {
        for (FileInfo info : fileInfoMap.values()) {
            adjustMemoryBudget(budget, info.dbIds, null /*newDatabases*/);
        }
    }

    /**
     * If there are no pending LNs or DBs outstanding, move the CHECKPOINTED
     * files to FULLY_PROCESSED.  The check for pending LNs/DBs and the copying
     * of the CHECKPOINTED files must be done atomically in a synchronized
     * block.  All methods that call this method are synchronized.
     */
    private void updateProcessedFiles() {
        if (pendingLNs.isEmpty() && pendingDBs.isEmpty()) {
            setStatus(FileStatus.CHECKPOINTED, FileStatus.FULLY_PROCESSED);
        }
    }

    /**
     * Adjust the memory budget when an entry is added to or removed from the
     * cleanedFilesDatabases map.
     */
    private void adjustMemoryBudget(MemoryBudget budget,
                                    Set<DatabaseId> oldDatabases,
                                    Set<DatabaseId> newDatabases) {
        long adjustMem = 0;
        if (oldDatabases != null) {
            adjustMem -= getCleanedFilesDatabaseEntrySize(oldDatabases);
        }
        if (newDatabases != null) {
            adjustMem += getCleanedFilesDatabaseEntrySize(newDatabases);
        }
        budget.updateAdminMemoryUsage(adjustMem);
    }

    /**
     * Returns the size of a HashMap entry that contains the given set of
     * DatabaseIds.  We don't count the DatabaseId size because it is likely
     * that it is also stored (and budgeted) in the DatabaseImpl.
     */
    private long getCleanedFilesDatabaseEntrySize(Set<DatabaseId> databases) {
        return MemoryBudget.HASHMAP_ENTRY_OVERHEAD +
               MemoryBudget.HASHSET_OVERHEAD +
               (databases.size() * MemoryBudget.HASHSET_ENTRY_OVERHEAD);
    }

    /**
     * Loads file selection stats.
     */
    synchronized StatGroup loadStats() {
        StatGroup stats = new StatGroup(CleanerStatDefinition.FS_GROUP_NAME,
                                        CleanerStatDefinition.FS_GROUP_DESC);
        new IntStat(stats, CLEANER_BACKLOG, getBacklog());
        new IntStat(stats, CLEANER_FILE_DELETION_BACKLOG, 
                    getNumberOfFiles(FileStatus.SAFE_TO_DELETE));

        return stats;
    }

    /**
     * Holds copy of all checkpoint-dependent cleaner state.
     */
    public static class CheckpointStartCleanerState {

        /* A snapshot of the cleaner collections at the checkpoint start. */
        private Set<Long> cleanedFiles;
        private Set<Long> fullyProcessedFiles;

        private CheckpointStartCleanerState(Set<Long> cleanedFiles,
                                            Set<Long> fullyProcessedFiles) {

            /*
             * Save snapshots of the collections of various files at the
             * beginning of the checkpoint.
             */
            this.cleanedFiles = cleanedFiles;
            this.fullyProcessedFiles = fullyProcessedFiles;
        }

        public boolean isEmpty() {
            return ((cleanedFiles.size() == 0) &&
                    (fullyProcessedFiles.size() == 0));
        }

        public Set<Long> getCleanedFiles() {
            return cleanedFiles;
        }

        public Set<Long> getFullyProcessedFiles() {
            return fullyProcessedFiles;
        }
    }

    @Override
    public synchronized String toString() {
        return "files = " + fileInfoMap +
               " pendingLNs = " + pendingLNs +
               " pendingDBs = " + pendingDBs +
               " anyPendingDuringCheckpoint = " + anyPendingDuringCheckpoint +
               " lowUtilizationFiles = " + lowUtilizationFiles;
    }
}
