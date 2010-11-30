/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import static com.sleepycat.je.cleaner.CleanerStatDefinition.GROUP_NAME;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.GROUP_DESC;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_CLUSTER_LNS_PROCESSED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_DELETIONS;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_ENTRIES_READ;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_INS_CLEANED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_INS_DEAD;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_INS_MIGRATED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_INS_OBSOLETE;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_LNQUEUE_HITS;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_LNS_CLEANED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_LNS_DEAD;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_LNS_LOCKED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_LNS_MARKED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_LNS_MIGRATED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_LNS_OBSOLETE;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_MARKED_LNS_PROCESSED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_PENDING_LNS_LOCKED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_PENDING_LNS_PROCESSED;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_REPEAT_ITERATOR_READS;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_RUNS;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_TOTAL_LOG_SIZE;
import static com.sleepycat.je.cleaner.CleanerStatDefinition.CLEANER_TO_BE_CLEANED_LNS_PROCESSED;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.ExceptionListener;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.cleaner.FileSelector.CheckpointStartCleanerState;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvConfigObserver;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeLocation;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.utilint.DaemonRunner;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.ExceptionListenerUser;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.VLSN;

/**
 * The Cleaner is responsible for effectively garbage collecting the JE log.
 * It looks through log files and locates log records (IN's and LN's of all
 * flavors) that are superceded by later versions.  Those that are "current"
 * are propagated to a newer log file so that older log files can be deleted.
 */
public class Cleaner implements DaemonRunner,
                                EnvConfigObserver,
                                ExceptionListenerUser {
    /* From cleaner */
    static final String CLEAN_IN = "CleanIN:";
    static final String CLEAN_LN = "CleanLN:";
    static final String CLEAN_MIGRATE_LN = "CleanMigrateLN:";
    static final String CLEAN_PENDING_LN = "CleanPendingLN:";

    /**
     * Whether to update the IN generation count during searches.  This is
     * currently disabled because 1) we update the generation of the BIN when
     * we set a MIGRATE flag and 2) if the BIN is not evicted its parents will
     * not be, so not updating the generation during the search has no benefit.
     * By not updating the generation during searches for which we do NOT set
     * the MIGRATE flag, we avoid holding INs in the cache that are not needed
     * for lazy migration.  However, we do very few searches for obsolete LNs
     * because the obsolete tracking info prevents this, so the benefit of not
     * updating the generation during searches is questionable.  In other
     * words, changing this setting will have little effect.
     */
    static final CacheMode UPDATE_GENERATION = CacheMode.UNCHANGED;

    /**
     * Whether the cleaner should participate in critical eviction.  Ideally
     * the cleaner would not participate in eviction, since that would reduce
     * the cost of cleaning.  However, the cleaner can add large numbers of
     * nodes to the cache.  By not participating in eviction, other threads
     * could be kept in a constant state of eviction and would effectively
     * starve.  Therefore, this setting is currently enabled.
     */
    static final boolean DO_CRITICAL_EVICTION = true;

    /*
     * Cumulative counters.  Updates to these counters occur in multiple
     * threads, including FileProcessor threads,  and are not synchronized.
     * This could produce errors in counting, but avoids contention around stat
     * updates.
     */
    StatGroup stats;
    LongStat nCleanerRuns;
    LongStat nCleanerDeletions;
    LongStat nINsObsolete;
    LongStat nINsCleaned;
    LongStat nINsDead;
    LongStat nINsMigrated;
    LongStat nLNsObsolete;
    LongStat nLNsCleaned;
    LongStat nLNsDead;
    LongStat nLNsLocked;
    LongStat nLNsMigrated;
    LongStat nLNsMarked;
    LongStat nLNQueueHits;
    LongStat nPendingLNsProcessed;
    LongStat nMarkedLNsProcessed;
    LongStat nToBeCleanedLNsProcessed;
    LongStat nClusterLNsProcessed;
    LongStat nPendingLNsLocked;
    LongStat nEntriesRead;
    LongStat nRepeatIteratorReads;
    LongStat totalLogSize;

    /*
     * Configuration parameters are non-private for use by FileProcessor,
     * UtilizationTracker.
     */
    long lockTimeout;
    int readBufferSize;
    int lookAheadCacheSize;
    long nDeadlockRetries;
    boolean expunge;
    boolean clusterResident;
    boolean clusterAll;
    int maxBatchFiles;
    long cleanerBytesInterval;
    boolean trackDetail;
    boolean fetchObsoleteSize;
    boolean lazyMigration;
    private boolean foregroundProactiveMigration;
    private boolean backgroundProactiveMigration;

    /**
     * All files that are to-be-cleaned.  Used to perform proactive migration.
     * Is read-only after assignment, so no synchronization is needed.
     */
    private Set<Long> toBeCleanedFiles = Collections.emptySet();

    /**
     * All files that are below the minUtilization threshold.  Used to perform
     * clustering migration.  Is read-only after assignment, so no
     * synchronization is needed.
     */
    private Set<Long> lowUtilizationFiles = Collections.emptySet();

    private final String name;
    private final EnvironmentImpl env;
    private final UtilizationProfile profile;
    private final UtilizationTracker tracker;
    private final FileSelector fileSelector;
    private FileProcessor[] threads;

    /*
     * Log file deletion must check for ongoing backups and other procedures
     * that rely on a set log files remaining stable (no deletions).  Multiple
     * ranges of file numbers may be protected from deletion, where each range
     * is from a given file number to the end of the log.
     *
     * protectedFileRanges is a list that contains the starting file number for
     * each protected range.  All files from the mininum of these values to the
     * end of the log are protected from deletion.  This field is accessed only
     * while synchronizing on protectedFileRanges.
     */
    private final List<Long> protectedFileRanges;
    private long lastCleanerBarrierStartFile; /* For debugging. */
    private final Logger logger;

    public Cleaner(EnvironmentImpl env, String name)
        throws DatabaseException {

        this.env = env;
        this.name = name;

        /* Initiate the stats definitions. */
        stats = new StatGroup(GROUP_NAME, GROUP_DESC);
        nCleanerRuns = new LongStat(stats, CLEANER_RUNS);
        nCleanerDeletions = new LongStat(stats, CLEANER_DELETIONS);
        nINsObsolete = new LongStat(stats, CLEANER_INS_OBSOLETE);
        nINsCleaned = new LongStat(stats, CLEANER_INS_CLEANED);
        nINsDead = new LongStat(stats, CLEANER_INS_DEAD);
        nINsMigrated = new LongStat(stats, CLEANER_INS_MIGRATED);
        nLNsObsolete = new LongStat(stats, CLEANER_LNS_OBSOLETE);
        nLNsCleaned = new LongStat(stats, CLEANER_LNS_CLEANED);
        nLNsDead = new LongStat(stats, CLEANER_LNS_DEAD);
        nLNsLocked = new LongStat(stats, CLEANER_LNS_LOCKED);
        nLNsMigrated = new LongStat(stats, CLEANER_LNS_MIGRATED);
        nLNsMarked = new LongStat(stats, CLEANER_LNS_MARKED);
        nLNQueueHits = new LongStat(stats, CLEANER_LNQUEUE_HITS);
        nPendingLNsProcessed =
            new LongStat(stats, CLEANER_PENDING_LNS_PROCESSED);
        nMarkedLNsProcessed = new LongStat(stats, CLEANER_MARKED_LNS_PROCESSED);
        nToBeCleanedLNsProcessed =
            new LongStat(stats, CLEANER_TO_BE_CLEANED_LNS_PROCESSED);
        nClusterLNsProcessed =
            new LongStat(stats, CLEANER_CLUSTER_LNS_PROCESSED);
        nPendingLNsLocked = new LongStat(stats, CLEANER_PENDING_LNS_LOCKED);
        nEntriesRead = new LongStat(stats, CLEANER_ENTRIES_READ);
        nRepeatIteratorReads =
            new LongStat(stats, CLEANER_REPEAT_ITERATOR_READS);
        totalLogSize = new LongStat(stats, CLEANER_TOTAL_LOG_SIZE);

        tracker = new UtilizationTracker(env, this);
        profile = new UtilizationProfile(env, tracker);
        fileSelector = new FileSelector();
        threads = new FileProcessor[0];
        protectedFileRanges = new LinkedList<Long>();
        logger = LoggerUtils.getLogger(getClass());

        /*
         * The trackDetail property is immutable because of the complexity (if
         * it were mutable) in determining whether to update the memory budget
         * and perform eviction.
         */
        trackDetail = env.getConfigManager().getBoolean
            (EnvironmentParams.CLEANER_TRACK_DETAIL);

        /* Initialize mutable properties and register for notifications. */
        envConfigUpdate(env.getConfigManager(), null);
        env.addConfigObserver(this);
        env.registerExceptionListenerUser(this);
    }

    /**
     * Process notifications of mutable property changes.
     *
     * @throws IllegalArgumentException via Environment ctor and
     * setMutableConfig.
     */
    public void envConfigUpdate(DbConfigManager cm,
                                EnvironmentMutableConfig ignore)
        throws DatabaseException {

        lockTimeout = cm.getDuration(EnvironmentParams.CLEANER_LOCK_TIMEOUT);

        readBufferSize = cm.getInt(EnvironmentParams.CLEANER_READ_SIZE);
        if (readBufferSize <= 0) {
            readBufferSize = cm.getInt
                (EnvironmentParams.LOG_ITERATOR_READ_SIZE);
        }

        lookAheadCacheSize = cm.getInt
            (EnvironmentParams.CLEANER_LOOK_AHEAD_CACHE_SIZE);

        foregroundProactiveMigration = cm.getBoolean
            (EnvironmentParams.CLEANER_FOREGROUND_PROACTIVE_MIGRATION);

        backgroundProactiveMigration = cm.getBoolean
            (EnvironmentParams.CLEANER_BACKGROUND_PROACTIVE_MIGRATION);

        nDeadlockRetries = cm.getInt(EnvironmentParams.CLEANER_DEADLOCK_RETRY);

        expunge = cm.getBoolean(EnvironmentParams.CLEANER_REMOVE);

        clusterResident = cm.getBoolean(EnvironmentParams.CLEANER_CLUSTER);

        clusterAll = cm.getBoolean(EnvironmentParams.CLEANER_CLUSTER_ALL);

        maxBatchFiles = cm.getInt(EnvironmentParams.CLEANER_MAX_BATCH_FILES);

        if (clusterResident && clusterAll) {
            throw new IllegalArgumentException
                ("Both " + EnvironmentParams.CLEANER_CLUSTER +
                 " and " + EnvironmentParams.CLEANER_CLUSTER_ALL +
                 " may not be set to true.");
        }

        int nThreads = cm.getInt(EnvironmentParams.CLEANER_THREADS);
        assert nThreads > 0;

        if (nThreads != threads.length) {

            /* Shutdown threads when reducing their number. */
            for (int i = nThreads; i < threads.length; i += 1) {
                if (threads[i] != null) {
                    threads[i].shutdown();
                    threads[i] = null;
                }
            }

            /* Copy existing threads that are still used. */
            FileProcessor[] newThreads = new FileProcessor[nThreads];
            for (int i = 0; i < nThreads && i < threads.length; i += 1) {
                newThreads[i] = threads[i];
            }

            /* Don't lose track of new threads if an exception occurs. */
            threads = newThreads;

            /* Start new threads when increasing their number. */
            for (int i = 0; i < nThreads; i += 1) {
                if (threads[i] == null) {
                    threads[i] = new FileProcessor
                        (name + '-' + (i + 1),
                         env, this, profile, fileSelector);
                }
            }
        }

        cleanerBytesInterval = cm.getLong
            (EnvironmentParams.CLEANER_BYTES_INTERVAL);
        if (cleanerBytesInterval == 0) {
            cleanerBytesInterval = cm.getLong
                (EnvironmentParams.LOG_FILE_MAX) / 4;
        }

        fetchObsoleteSize = cm.getBoolean
            (EnvironmentParams.CLEANER_FETCH_OBSOLETE_SIZE);

        /*
         * In addition to honoring the CLEANER_LAZY_MIGRATION, lazy migration
         * of LNs is disabled if CHECKPOINTER_HIGH_PRIORITY is true.  LN
         * migration slows down the checkpoint and so LNs are migrated by
         * FileProcessor when high priority checkpoints are configured.
         */
        lazyMigration =
            cm.getBoolean(EnvironmentParams.CLEANER_LAZY_MIGRATION) &&
            !cm.getBoolean(EnvironmentParams.CHECKPOINTER_HIGH_PRIORITY);
    }

    public UtilizationTracker getUtilizationTracker() {
        return tracker;
    }

    public UtilizationProfile getUtilizationProfile() {
        return profile;
    }

    /** For unit testing. */
    public FileSelector getFileSelector() {
        return fileSelector;
    }

    public boolean getFetchObsoleteSize() {
        return fetchObsoleteSize;
    }

    /*
     * Delegate the run/pause/wakeup/shutdown DaemonRunner operations.  We
     * always check for null to account for the possibility of exceptions
     * during thread creation.  Cleaner daemon can't ever be run if No Locking
     * mode is enabled.
     */
    public void runOrPause(boolean run) {
        if (!env.isNoLocking()) {
            for (FileProcessor processor : threads) {
                if (processor != null) {
                    processor.runOrPause(run);
                }
            }
        }
    }

    public void wakeup() {
        for (FileProcessor thread : threads) {
            if (thread != null) {
                thread.wakeup();
            }
        }
    }

    public void requestShutdown() {
        for (FileProcessor thread : threads) {
            if (thread != null) {
                thread.requestShutdown();
            }
        }
    }

    public void shutdown() {
        for (int i = 0; i < threads.length; i += 1) {
            if (threads[i] != null) {
                threads[i].shutdown();
                threads[i].clearEnv();
                threads[i] = null;
            }
        }
    }

    public int getNWakeupRequests() {
        int count = 0;
        for (FileProcessor thread : threads) {
            if (thread != null) {
                count += thread.getNWakeupRequests();
            }
        }
        return count;
    }

    private boolean areThreadsRunning() {
        for (FileProcessor thread : threads) {
            if (thread != null) {
                return thread.isRunning();
            }
        }
        return false;
    }

    /**
     * @see ExceptionListenerUser#setExceptionListener(ExceptionListener)
     */
    public void setExceptionListener(ExceptionListener exceptionListener) {
        for (FileProcessor thread : threads) {
            if (thread != null) {
                thread.setExceptionListener(exceptionListener);
            }
        }
    }

    /**
     * Cleans selected files and returns the number of files cleaned.  This
     * method is not invoked by a deamon thread, it is programatically.
     *
     * @param cleanMultipleFiles is true to clean until we're under budget,
     * or false to clean at most one file.
     *
     * @param forceCleaning is true to clean even if we're not under the
     * utilization threshold.
     *
     * @return the number of files cleaned, not including files cleaned
     * unsuccessfully.
     */
    public int doClean(boolean cleanMultipleFiles, boolean forceCleaning)
        throws DatabaseException {

        FileProcessor processor = new FileProcessor
            ("", env, this, profile, fileSelector);
        return processor.doClean
            (false /*invokedFromDaemon*/, cleanMultipleFiles, forceCleaning);
    }

    /**
     * Load stats.
     */
    public StatGroup loadStats(StatsConfig config) {
        if (!config.getFast()) {
            totalLogSize.set(profile.getTotalLogSize());
        }

        StatGroup copyStats = stats.cloneGroup(config.getClear());
        /* Add the FileSelector's stats to the cleaner stat group. */
        copyStats.addAll(fileSelector.loadStats());

        return copyStats;
    }

    /**
     * Deletes all files that are safe-to-delete and which are not protected by
     * a DbBackup or replication. Files are deleted only if there are no
     * read-only processes.
     *
     * Log file deletion is coordinated by the use of three mechanisms:
     *
     * 1) To guard against read/only processes, the would-be deleter tries to
     * get an exclusive lock on the environment. This will not be possible if a
     * read/only process exists.  File locks must be used for inter-process
     * coordination. But note that file locks are not supported intra-process.
     *
     * 2) Synchronization on the protectedFileRanges field.  Elements are added
     * to and removed from the protectedFileRanges collection by DbBackup.
     * More than one backup may be occuring at once, hence a collection of
     * protectedFileRanges is maintained, and the files protected are the range
     * starting with the minimum value returned by the objects in that
     * collection.
     *
     * 3) In a replicated environment, files are protected from deletion by the
     * CBVLSN (CleanerBarrier VLSN). No file greater or equal to the CBVLSN
     * file may be deleted.
     *
     * For case (2) and (3), all coordinated activities -- replication, backup
     * and file deletion -- can only be carried out by a read-write process, so
     * we know that all activities are occurring in the same process because
     * there can only be one JE read-write process per environment.
     *
     * This method is synchronized to prevent multiple threads from requesting
     * the environment lock or deleting the same files.
     */
    synchronized void deleteSafeToDeleteFiles()
        throws DatabaseException {

        /* Fail loudly if the environment is invalid. */
        env.checkIfInvalid();

        /* Fail silently if the environment is not open. */
        if (env.mayNotWrite()) {
            return;
        }

        SortedSet<Long> safeToDeleteFiles =
            fileSelector.copySafeToDeleteFiles();
        if (safeToDeleteFiles == null) {
            return; /* Nothing to do. */
        }

        /*
         * Get the protected file range from HA for the CBVLSN.  This value
         * cannot move backward, only forward over time.  We can safely use
         * this value as a pessimistic minimum without synchronization.
         * [#16820]
         */
        long minProtectedFile = env.getCleanerBarrierStartFile();
        if (minProtectedFile == -1) {

            /*
             * The replicated node is not available, so the cleaner barrier can
             * not be read. Don't delete any files.
             */
            return;
        }
        if (lastCleanerBarrierStartFile > minProtectedFile) {
            throw EnvironmentFailureException.unexpectedState
                ("CBVLSN file has moved backward, prevValue=" +
                 lastCleanerBarrierStartFile + " newValue=" +
                 minProtectedFile);
        }
        lastCleanerBarrierStartFile = minProtectedFile;

        SortedSet<Long> unprotectedFiles =
            safeToDeleteFiles.headSet(minProtectedFile);
        if (unprotectedFiles.isEmpty()) {
            /* Leave a clue for analyzing log file deletion problems. */
            LoggerUtils.traceAndLog(logger, env, Level.WARNING,
                                    "Cleaner has " + safeToDeleteFiles.size() +
                                    " files not deleted because they are " +
                                    "protected by replication.");
            return; /* Nothing to do. */
        }

        /*
         * Truncate the entries in the VLSNIndex that reference VLSNs in the
         * files to be deleted.  [#16566]
         *
         * This is done prior to deleting the files to ensure that the
         * replicator removes the files from the VLSNIndex.  If we were to
         * truncate after deleting a file, we may crash before the truncation
         * and would have to "replay" the truncation later in
         * UtilizationProfile.populateCache.  This would be more complex and
         * the lastVLSN for the files would not be available.
         *
         * OTOH, if we crash after the truncation and before deleting a file,
         * it is very likely that we will re-clean the zero utilization file
         * and delete it later.  This will only cause a redundant truncation.
         *
         * This is done before locking the environment to minimize the interval
         * during which the environment is locked and read-only processes are
         * blocked.  We may unnecessarily truncate the VLSNIndex if we can't
         * lock the environment, but that is a lesser priority.
         *
         * We intentionally do not honor the protected file ranges specified by
         * DbBackups when truncating, because the VLSNIndex is protected only
         * by the CBVLSN.  Luckily, this also means we do not need to
         * synchronize on protectedFileRanges while truncating, and DbBackups
         * will not be blocked by this potentially expensive operation.
         */
        Long[] unprotectedFilesArray = unprotectedFiles.toArray(new Long[0]);
        for (int i = unprotectedFilesArray.length - 1; i >= 0; i -= 1) {
            Long fileNum = unprotectedFilesArray[i];

            /*
             * Truncate VLSNIndex for the highest numbered file with a VLSN. We
             * search from high to low because some files may not contain a
             * VLSN.
             */
            VLSN lastVlsn = fileSelector.getLastVLSN(fileNum);
            if ((lastVlsn != null) && !lastVlsn.isNull()) {
                env.vlsnHeadTruncate(lastVlsn, fileNum);
                break;
            }
        }

        /*
         * If we can't get an exclusive lock, then there are other processes
         * with the environment open read-only and we can't delete any files.
         */
        final FileManager fileManager = env.getFileManager();
        if (!fileManager.lockEnvironment(false, true)) {
            LoggerUtils.traceAndLog(logger, env, Level.WARNING,
                                    "Cleaner has " + safeToDeleteFiles.size() +
                                    " files not deleted because of read-only" +
                                    " processes.");
            return;
        }

        /* Be sure to release the environment lock in the finally block. */
        try {
            /* Sychronize while deleting files to block DbBackup.start. */
            synchronized (protectedFileRanges) {

                /* Intersect the protected ranges for active DbBackups. */
                if (!protectedFileRanges.isEmpty()) {
                    unprotectedFiles = unprotectedFiles.headSet
                        (Collections.min(protectedFileRanges));
                }

                /* Delete the unprotected files. */
                for (final Iterator<Long> iter = unprotectedFiles.iterator();
                     iter.hasNext();) {
                    final Long fileNum = iter.next();
                    final boolean deleted;
                    try {
                        if (expunge) {
                            deleted = fileManager.deleteFile(fileNum);
                        } else {
                            deleted = fileManager.renameFile
                                (fileNum, FileManager.DEL_SUFFIX);
                        }
                    } catch (IOException e) {
                        throw new EnvironmentFailureException
                            (env, EnvironmentFailureReason.LOG_WRITE,
                             "Unable to delete or rename " + fileNum, e);
                    }
                    if (deleted) {

                        /*
                         * Deletion was successful.  Log a trace message for
                         * debugging of log cleaning behavior.
                         */
                        LoggerUtils.traceAndLog(logger, env, Level.FINE,
                                                "Cleaner deleted file 0x" +
                                                Long.toHexString(fileNum));
                    } else if (!fileManager.isFileValid(fileNum)) {

                        /*
                         * Somehow the file was previously deleted.  This could
                         * indicate an internal state error, and therefore we
                         * output a trace message.  But we should not
                         * repeatedly attempt to delete it, so we do remove it
                         * from the profile below.
                         */
                        LoggerUtils.traceAndLog
                            (logger, env, Level.SEVERE, 
                             "Cleaner deleteSafeToDeleteFiles Log file 0x" +
                             Long.toHexString(fileNum) + " was previously " +
                             (expunge ? "deleted" : "renamed") + ".  State: " +
                             fileSelector);
                    } else {

                        /*
                         * We will retry the deletion later if file still
                         * exists.  The deletion could have failed on Windows
                         * if the file was recently closed.  Remove the file
                         * from unprotectedFiles. That way, we won't remove it
                         * from the FileSelector's safe-to-delete set or the UP
                         * below, and we will retry the file deletion later.
                         */
                        iter.remove();

                        LoggerUtils.traceAndLog
                            (logger, env, Level.WARNING,
                             "Cleaner deleteSafeToDeleteFiles Log file 0x" +
                             Long.toHexString(fileNum) + " could not be " +
                             (expunge ? "deleted" : "renamed") + ". This " +
                             "operation will be retried at the next " +
                             "checkpoint. State: " + fileSelector);
                    }
                }
            }
        } finally {
            fileManager.releaseExclusiveLock();
        }

        /*
         * Now unprotectedFiles contains only the files we deleted above.  We
         * can update the UP (and FileSelector) here outside of the
         * synchronization block and without the environment locked.  That way,
         * DbBackups and read-only processes will not be blocked by the
         * expensive UP operation.
         *
         * We do not retry if an error occurs deleting the UP database entries
         * below.  Retrying (when file deletion fails) is intended only to
         * solve a problem on Windows where deleting a log file isn't always
         * possible immediately after closing it.
         *
         * Remove the file from the UP before removing it from the
         * FileSelector's safe-to-delete set.  If we remove in the reverse
         * order, it may be selected for cleaning.  Always remove the file from
         * the safe-to-delete set (in a finally block) so that we don't attempt
         * to delete the file again.
         */
        for (Long fileNum : unprotectedFiles) {
            try {
                profile.removeFile
                    (fileNum, fileSelector.getCleanedDatabases(fileNum));
            } finally {
                fileSelector.removeDeletedFile
                    (fileNum, env.getMemoryBudget());
            }
            nCleanerDeletions.increment();
        }

        /* Leave a clue for analyzing log file deletion problems. */
        if (safeToDeleteFiles.size() > unprotectedFiles.size()) {
            LoggerUtils.traceAndLog
                (logger, env, Level.WARNING,
                 "Cleaner has " + 
                 (safeToDeleteFiles.size() - unprotectedFiles.size()) +
                 " files not deleted because they are protected by DbBackup " +
                 "or replication.");
        }
    }

    /**
     * Adds a range of log files to be protected from deletion during a backup
     * or similar procedures where log files must not be deleted.
     *
     * <p>This method is called automatically by the {@link
     * com.sleepycat.je.util.DbBackup} utility and is provided here as a
     * separate API for advanced applications that may implement a custom
     * backup procedure.</p>
     *
     * <p><em>WARNING:</em> After calling this method, deletion of log files in
     * the file range by the JE log cleaner will be disabled until {@link
     * #removeProtectedFileRange} is called.  To prevent unbounded growth of
     * disk usage, be sure to call {@link #removeProtectedFileRange} to
     * re-enable log file deletion.</p>
     *
     * @param firstProtectedFile the number of the first file to be protected.
     * The protected range is from this file number to the last (highest
     * numbered) file in the log.
     *
     * @since 4.0
     */
    public void addProtectedFileRange(long firstProtectedFile) {
        synchronized (protectedFileRanges) {
            protectedFileRanges.add(firstProtectedFile);
        }
    }

    /**
     * Removes a range of log files to be protected after calling {@link
     * #addProtectedFileRange}.
     *
     * @param firstProtectedFile the value previously passed to {@link
     * #addProtectedFileRange}.
     *
     * @throws EnvironmentFailureException if {@code firstProtectedFile} is not
     * currently the start of a protected range.
     *
     * @since 4.0
     */
    public void removeProtectedFileRange(long firstProtectedFile) {
        synchronized (protectedFileRanges) {
            if (!protectedFileRanges.remove(firstProtectedFile)) {
                throw EnvironmentFailureException.unexpectedState
                    ("File range starting with 0x" +
                     Long.toHexString(firstProtectedFile) +
                     " is not currently protected");
            }
        }
    }

    /**
     * Returns a copy of the cleaned and processed files at the time a
     * checkpoint starts.
     *
     * <p>If non-null is returned, the checkpoint should flush an extra level,
     * and addCheckpointedFiles() should be called when the checkpoint is
     * complete.</p>
     */
    public CheckpointStartCleanerState getFilesAtCheckpointStart()
        throws DatabaseException {

        /* Pending LNs can prevent file deletion. */
        processPending();

        return fileSelector.getFilesAtCheckpointStart();
    }

    /**
     * When a checkpoint is complete, update the files that were returned at
     * the beginning of the checkpoint.
     */
    public void updateFilesAtCheckpointEnd(CheckpointStartCleanerState info)
        throws DatabaseException {

        fileSelector.updateFilesAtCheckpointEnd(info);
        deleteSafeToDeleteFiles();
    }

    /**
     * Update the lowUtilizationFiles and toBeCleanedFiles fields with new
     * read-only collections.
     */
    public void updateReadOnlyFileCollections() {
        toBeCleanedFiles = fileSelector.getToBeCleanedFiles();
        lowUtilizationFiles = fileSelector.getLowUtilizationFiles();
    }

    /**
     * If any LNs are pending, process them.  This method should be called
     * often enough to prevent the pending LN set from growing too large.
     */
    void processPending()
        throws DatabaseException {

        DbTree dbMapTree = env.getDbTree();

        LNInfo[] pendingLNs = fileSelector.getPendingLNs();
        if (pendingLNs != null) {
            TreeLocation location = new TreeLocation();

            for (LNInfo info : pendingLNs) {
                DatabaseId dbId = info.getDbId();
                DatabaseImpl db = dbMapTree.getDb(dbId, lockTimeout);
                try {
                    byte[] key = info.getKey();
                    byte[] dupKey = info.getDupKey();
                    LN ln = info.getLN();

                    /* Evict before processing each entry. */
                    if (DO_CRITICAL_EVICTION) {
                        env.daemonEviction(true /*backgroundIO*/);
                    }

                    processPendingLN
                        (ln, db, key, dupKey, location);
                } finally {
                    dbMapTree.releaseDb(db);
                }

                /* Sleep if background read/write limit was exceeded. */
                env.sleepAfterBackgroundIO();
            }
        }

        DatabaseId[] pendingDBs = fileSelector.getPendingDBs();
        if (pendingDBs != null) {
            for (DatabaseId dbId : pendingDBs) {
                DatabaseImpl db = dbMapTree.getDb(dbId, lockTimeout);
                try {
                    if (db == null || db.isDeleteFinished()) {
                        fileSelector.removePendingDB(dbId);
                    }
                } finally {
                    dbMapTree.releaseDb(db);
                }
            }
        }
    }

    /**
     * Processes a pending LN, getting the lock first to ensure that the
     * overhead of retries is mimimal.
     */
    private void processPendingLN(LN ln,
                                  DatabaseImpl db,
                                  byte[] key,
                                  byte[] dupKey,
                                  TreeLocation location)
        throws DatabaseException {

        boolean parentFound = false;  // We found the parent BIN.
        boolean processedHere = true; // The LN was cleaned here.
        boolean lockDenied = false;   // The LN lock was denied.
        boolean obsolete = false;     // The LN is no longer in use.
        boolean completed = false;    // This method completed.

        BasicLocker locker = null;
        BIN bin = null;
        DIN parentDIN = null;
        try {
            nPendingLNsProcessed.increment();

            /*
             * If the DB is gone, this LN is obsolete.  If delete cleanup is in
             * progress, put the DB into the DB pending set; this LN will be
             * declared deleted after the delete cleanup is finished.
             */
            if (db == null || db.isDeleted()) {
                addPendingDB(db);
                nLNsDead.increment();
                obsolete = true;
                completed = true;
                return;
            }

            Tree tree = db.getTree();
            assert tree != null;

            /* Get a non-blocking lock on the original node ID. */

            locker = BasicLocker.createBasicLocker(env, false /*noWait*/);
            /* Don't allow this short-lived lock to be preempted/stolen. */
            locker.setPreemptable(false);
            LockResult lockRet = locker.nonBlockingLock
                (ln.getNodeId(), LockType.READ, db);
            if (lockRet.getLockGrant() == LockGrantType.DENIED) {
                /* Try again later. */
                nPendingLNsLocked.increment();
                lockDenied = true;
                completed = true;
                return;
            }

            /*
             * Search down to the bottom most level for the parent of this LN.
             *
             * We pass searchDupTree=true to search the dup tree by nodeID if
             * necessary.  This handles the case where dupKey is null because
             * the pending entry was a deleted single-duplicate in a BIN.
             */
            parentFound = tree.getParentBINForChildLN
                (location, key, dupKey, ln,
                 false,  // splitsAllowed
                 true,   // findDeletedEntries
                 true,   // searchDupTree
                 UPDATE_GENERATION);
            bin = location.bin;
            int index = location.index;

            if (!parentFound) {
                nLNsDead.increment();
                obsolete = true;
                completed = true;
                return;
            }

            if (ln.containsDuplicates()) {
                /* Migrate a DupCountLN. */
                parentDIN = (DIN) bin.fetchTarget(index);
                parentDIN.latch(UPDATE_GENERATION);
                ChildReference dclRef = parentDIN.getDupCountLNRef();
                processedHere = false;
                migrateDupCountLN
                    (db, dclRef.getLsn(), parentDIN, dclRef,
                     true,           // wasCleaned
                     true,           // isPending
                     ln.getNodeId(), // lockedPendingNodeId
                     CLEAN_PENDING_LN);
            } else {
                /* Migrate a plain LN. */
                processedHere = false;
                migrateLN
                    (db, bin.getLsn(index), bin, index,
                     true,           // wasCleaned
                     true,           // isPending
                     ln.getNodeId(), // lockedPendingNodeId
                     true,           // backgroundIO
                     CLEAN_PENDING_LN);
            }
            completed = true;
        } catch (DatabaseException DBE) {
            DBE.printStackTrace();
            LoggerUtils.traceAndLogException
                (env, "com.sleepycat.je.cleaner.Cleaner",
                 "processLN", "Exception thrown: ", DBE);
            throw DBE;
        } finally {
            if (parentDIN != null) {
                parentDIN.releaseLatch();
            }

            if (bin != null) {
                bin.releaseLatch();
            }

            if (locker != null) {
                locker.operationEnd();
            }

            /*
             * If migrateLN was not called above, remove the pending LN and
             * perform tracing in this method.
             */
            if (processedHere) {
                if (completed && !lockDenied) {
                    fileSelector.removePendingLN(ln.getNodeId());
                }
                logFine(CLEAN_PENDING_LN, ln, DbLsn.NULL_LSN,
                        completed, obsolete, false /*migrated*/);
            }
        }
    }

    /**
     * Returns whether the given BIN entry may be stripped by the evictor.
     * True is always returned if the BIN is not dirty.  False is returned if
     * the BIN is dirty and the entry will be migrated soon.
     *
     * Note that the BIN may or may not be latched when this method is called.
     * Returning the wrong answer is OK in that case (it will be called again
     * later when latched), but an exception should not occur.
     */
    public boolean isEvictable(final BIN bin, final int index) {

        if (bin.getDirty()) {

            if (bin.getMigrate(index)) {
                return false;
            }

            final long lsn = bin.getLsn(index);
            if (lsn == DbLsn.NULL_LSN) {

                /*
                 * LN is resident but never logged, no cleaning restrictions
                 * apply.
                 */
                return true;
            }

            final boolean isResident = (bin.getTarget(index) != null);
            final Long fileNum = Long.valueOf(DbLsn.getFileNumber(lsn));

            /*
             * Assume foreground eviction for now.  If we resurrect the
             * background eviction thread, the backgroundIO parameter should be
             * passed down and used here.
             */
            if ((foregroundProactiveMigration || isResident) &&
                toBeCleanedFiles.contains(fileNum)) {
                return false;
            }

            if ((clusterAll || (clusterResident && isResident)) &&
                lowUtilizationFiles.contains(fileNum)) {
                return false;
            }
        }

        return true;
    }

    /**
     * This method should be called just before logging a BIN.  LNs will be
     * migrated if the MIGRATE flag is set, or if they are in a file to be
     * cleaned, or if the LNs qualify according to the rules for cluster and
     * clusterAll.
     *
     * <p>On return this method guarantees that no MIGRATE flag will be set on
     * any child entry.  If this method is *not* called before logging a BIN,
     * then the addPendingLNs method must be called.</p>
     *
     * @param bin is the latched BIN.  The latch will not be released by this
     * method.
     */
    public void lazyMigrateLNs(final BIN bin, final boolean backgroundIO)
        throws DatabaseException {

        DatabaseImpl db = bin.getDatabase();

        boolean isBinInDupDb = db.getSortedDuplicates() &&
            !bin.containsDuplicates();

        /*
         * For non-resident LNs, sort them by LSN before migrating them.
         * Fetching in LSN order reduces physical disk I/O.
         */
        Integer[] sortedIndices = null;
        int nSortedIndices = 0;
        int nEntries = bin.getNEntries();

        for (int index = 0; index < nEntries; index += 1) {

            boolean migrateFlag = bin.getMigrate(index);
            boolean isResident = (bin.getTarget(index) != null);
            long childLsn = bin.getLsn(index);

            if (childLsn != DbLsn.NULL_LSN) {
                /* LSN could be NULL_LSN if deferred-write mode */

                if (shouldMigrateLN
                    (migrateFlag, isResident, backgroundIO, isBinInDupDb,
                     childLsn)) {

                     if (isResident) {
                         migrateLN
                         (db, childLsn, bin, index,
                          migrateFlag, // wasCleaned
                          false,       // isPending
                          0,           // lockedPendingNodeId
                          backgroundIO,
                          CLEAN_MIGRATE_LN);
                     } else {
                         if (sortedIndices == null) {
                             sortedIndices = new Integer[nEntries];
                         }
                         sortedIndices[nSortedIndices++] =
                             Integer.valueOf(index);
                     }
                }
            }
        }

        if (sortedIndices != null) {
            Arrays.sort(sortedIndices,
                        0,
                        nSortedIndices,
                        new Comparator<Integer>() {
                public int compare( Integer int1, Integer int2) {
                    return DbLsn.compareTo(bin.getLsn(int1), bin.getLsn(int2));
                }
            });
            for (int i = 0; i < nSortedIndices; i += 1) {
                int index = sortedIndices[i].intValue();
                long childLsn = bin.getLsn(index);
                boolean migrateFlag = bin.getMigrate(index);
                migrateLN
                    (db, childLsn, bin, index,
                     migrateFlag, // wasCleaned
                     false,       // isPending
                     0,           // lockedPendingNodeId
                     backgroundIO,
                     CLEAN_MIGRATE_LN);
            }
        }
    }

    /**
     * This method should be called just before logging a root DIN.  The
     * DupCountLN will be migrated if the MIGRATE flag is set, or if it is in a
     * file to be cleaned, or if the LN qualifies according to the rules for
     * cluster and clusterAll.
     *
     * <p>On return this method guarantees that the MIGRATE flag will not be
     * set on the child entry.  If this method is *not* called before logging a
     * root DIN, then the addPendingDupCountLN method must be called.</p>
     *
     * @param din is the latched DIN.  The latch will not be released by this
     * method.
     *
     * @param dclRef is the reference to the DupCountLN.
     */
    public void lazyMigrateDupCountLN(final DIN din,
                                      final ChildReference dclRef,
                                      final boolean backgroundIO)
        throws DatabaseException {

        DatabaseImpl db = din.getDatabase();

        boolean migrateFlag = dclRef.getMigrate();
        boolean isResident = (dclRef.getTarget() != null);
        boolean isBinInDupDb = false;
        long childLsn = dclRef.getLsn();

        if (shouldMigrateLN
            (migrateFlag, isResident, backgroundIO, isBinInDupDb, childLsn)) {

            migrateDupCountLN
                (db, childLsn, din, dclRef,
                 migrateFlag, // wasCleaned
                 false,       // isPending
                 0,           // lockedPendingNodeId
                 CLEAN_MIGRATE_LN);
        }
    }

    /**
     * Returns whether an LN entry should be migrated.  Updates stats.
     *
     * @param migrateFlag is whether the MIGRATE flag is set on the entry.
     *
     * @param isResident is whether the LN is currently resident.
     *
     * @param isBinInDupDb is whether this is a BIN entry in a database with
     * duplicates enabled.
     *
     * @param childLsn is the LSN of the LN.
     *
     * @return whether to migrate the LN.
     */
    private boolean shouldMigrateLN(final boolean migrateFlag,
                                    final boolean isResident,
                                    final boolean backgroundIO,
                                    final boolean isBinInDupDb,
                                    final long childLsn) {
        if (migrateFlag) {

            /*
             * Always try to migrate if the MIGRATE flag is set, since the LN
             * has been processed.  If we did not migrate it, we would have to
             * add it to pending LN set.
             */
            nMarkedLNsProcessed.increment();
            return true;
        }

        if (isBinInDupDb || env.isClosing()) {

            /*
             * Do nothing if this is a BIN in a duplicate database.  We
             * must not fetch DINs, since this BIN may be about to be
             * evicted.  Fetching a DIN would add it as an orphan to the
             * INList, plus an IN with non-LN children is not evictable.
             *
             * Do nothing if the environment is shutting down and the
             * MIGRATE flag is not set.  Proactive migration during
             * shutdown is counterproductive -- it prevents a short final
             * checkpoint, and it does not allow more files to be deleted.
             */
            return false;
        }


        final Long fileNum = Long.valueOf(DbLsn.getFileNumber(childLsn));

        if ((isResident || (backgroundIO ?
                            backgroundProactiveMigration :
                            foregroundProactiveMigration)) &&
            toBeCleanedFiles.contains(fileNum)) {
            /* Migrate because it will be cleaned soon. */
            nToBeCleanedLNsProcessed.increment();
            return true;
        }
        
        if ((clusterAll || (clusterResident && isResident)) &&
            lowUtilizationFiles.contains(fileNum)) {
            /* Migrate for clustering. */
            nClusterLNsProcessed.increment();
            return true;
        }
        
        return false;
    }

    /**
     * Migrate an LN in the given BIN entry, if it is not obsolete.  The BIN is
     * latched on entry to this method and is left latched when it returns.
     */
    private void migrateLN(DatabaseImpl db,
                           long lsn,
                           BIN bin,
                           int index,
                           boolean wasCleaned,
                           boolean isPending,
                           long lockedPendingNodeId,
                           boolean backgroundIO,
                           String cleanAction)
        throws DatabaseException {

        /* Status variables are used to generate debug tracing info. */
        boolean obsolete = false;    // The LN is no longer in use.
        boolean migrated = false;    // The LN was in use and is migrated.
        boolean lockDenied = false;  // The LN lock was denied.
        boolean completed = false;   // This method completed.
        boolean clearTarget = false; // Node was non-resident when called.

        /*
         * If wasCleaned is false we don't count statistics unless we migrate
         * the LN.  This avoids double counting.
         */
        BasicLocker locker = null;
        LN ln = null;

        try {
            if (lsn == DbLsn.NULL_LSN) {
                /* This node was never written, no need to migrate. */
                completed = true;
                return;
            }

            /*
             * Fetch the node, if necessary.  If it was not resident and it is
             * an evictable LN, we will clear it after we migrate it.
             */
            if (!bin.isEntryKnownDeleted(index)) {
                ln = (LN) bin.getTarget(index);
                if (ln == null) {
                    /* If fetchTarget returns null, a deleted LN was cleaned.*/
                    ln = (LN) bin.fetchTarget(index);
                    clearTarget = !db.getId().equals(DbTree.ID_DB_ID);
                }
            }

            /* Don't migrate knownDeleted or deleted cleaned LNs.  */
            if (ln == null) {
                if (wasCleaned) {
                    nLNsDead.increment();
                }
                obsolete = true;
                completed = true;
                return;
            }

            /*
             * Get a non-blocking read lock on the LN.  A pending node is
             * already locked, but that node ID may be different than the
             * current LN's node if a slot is reused.  We must lock the current
             * node to guard against aborts.
             */
            if (lockedPendingNodeId != ln.getNodeId()) {
                locker = BasicLocker.createBasicLocker(env, false /*noWait*/);
                /* Don't allow this short-lived lock to be preempted/stolen. */
                locker.setPreemptable(false);
                LockResult lockRet = locker.nonBlockingLock
                    (ln.getNodeId(), LockType.READ, db);
                if (lockRet.getLockGrant() == LockGrantType.DENIED) {

                    /*
                     * LN is currently locked by another Locker, so we can't
                     * assume anything about the value of the LSN in the bin.
                     */
                    if (wasCleaned) {
                        nLNsLocked.increment();
                    }
                    lockDenied = true;
                    completed = true;
                    return;
                }
            }

            /* Don't migrate deleted LNs.  */
            if (ln.isDeleted()) {
                bin.setKnownDeletedLeaveTarget(index);
                if (wasCleaned) {
                    nLNsDead.increment();
                }
                obsolete = true;
                completed = true;
                return;
            }

            /*
             * Once we have a lock, check whether the current LSN needs to be
             * migrated.  There is no need to migrate it if the LSN no longer
             * qualifies for cleaning.  The LSN could have been changed by an
             * update or delete after we set the MIGRATE flag.
             *
             * Note that we do not perform this optimization if the MIGRATE
             * flag is not set, i.e, for clustering and proactive migration of
             * resident LNs.  For these cases, we checked the conditions for
             * migration immediately before calling this method.  Although the
             * condition could change after locking, the window is small and
             * a second check is not worthwhile.
             */
            if (bin.getMigrate(index)) {
                Long fileNum = Long.valueOf(DbLsn.getFileNumber(lsn));
                if (!fileSelector.isFileCleaningInProgress(fileNum)) {
                    obsolete = true;
                    completed = true;
                    if (wasCleaned) {
                        nLNsDead.increment();
                    }
                    return;
                }
            }

            /* Migrate the LN. */
            byte[] key = getLNMainKey(bin, index);
            long newLNLsn = ln.log(env, db, key, lsn, locker, backgroundIO,
                                   ReplicationContext.NO_REPLICATE);
            bin.updateEntry(index, newLNLsn);
            nLNsMigrated.increment();
            migrated = true;
            completed = true;
            return;
        } finally {
            if (isPending) {
                if (completed && !lockDenied) {
                    fileSelector.removePendingLN(lockedPendingNodeId);
                }
            } else {

                /*
                 * If a to-be-migrated LN was not processed successfully, we
                 * must guarantee that the file will not be deleted and that we
                 * will retry the LN later.  The retry information must be
                 * complete or we may delete a file later without processing
                 * all of its LNs.
                 *
                 * Note that the LN may be null if fetchTarget threw an
                 * exception above. [#16039]
                 */
                if (bin.getMigrate(index) &&
                    (!completed || lockDenied) &&
                    (ln != null)) {

                    byte[] key = getLNMainKey(bin, index);
                    byte[] dupKey = getLNDupKey(bin, index, ln);
                    fileSelector.addPendingLN(ln, db.getId(), key, dupKey);

                    /* Wake up the cleaner thread to process pending LNs. */
                    if (!areThreadsRunning()) {
                        env.getUtilizationTracker().activateCleaner();
                    }

                    /*
                     * If we need to retry, don't clear the target since we
                     * would only have to fetch it again soon.
                     */
                    clearTarget = false;
                }
            }

            /*
             * Always clear the migrate flag.  If the LN could not be locked
             * and the migrate flag was set, the LN will have been added to the
             * pending LN set above.
             */
            bin.setMigrate(index, false);

            /*
             * If the node was originally non-resident, clear it now so that we
             * don't create more work for the evictor and reduce the cache
             * memory available to the application.
             */
            if (clearTarget) {
                bin.updateNode(index, null /*node*/, null /*lnSlotKey*/);
            }

            if (locker != null) {
                locker.operationEnd();
            }

            logFine(cleanAction, ln, lsn, completed, obsolete, migrated);
        }
    }

    /**
     * Migrate the DupCountLN for the given DIN.  The DIN is latched on entry
     * to this method and is left latched when it returns.
     */
    private void migrateDupCountLN(DatabaseImpl db,
                                   long lsn,
                                   DIN parentDIN,
                                   ChildReference dclRef,
                                   boolean wasCleaned,
                                   boolean isPending,
                                   long lockedPendingNodeId,
                                   String cleanAction)
        throws DatabaseException {

        /* Status variables are used to generate debug tracing info. */
        boolean obsolete = false;    // The LN is no longer in use.
        boolean migrated = false;    // The LN was in use and is migrated.
        boolean lockDenied = false;  // The LN lock was denied.
        boolean completed = false;   // This method completed.
        boolean clearTarget = false; // Node was non-resident when called.

        /*
         * If wasCleaned is false we don't count statistics unless we migrate
         * the LN.  This avoids double counting.
         */
        BasicLocker locker = null;
        LN ln = null;

        try {
            if (lsn == DbLsn.NULL_LSN) {
                /* This node was never written, no need to migrate. */
                completed = true;
                return;
            }

            /*
             * Fetch the node, if necessary.  If it was not resident and it is
             * an evictable LN, we will clear it after we migrate it.
             */
            ln = (LN) dclRef.getTarget();
            if (ln == null) {
                ln = (LN) dclRef.fetchTarget(db, parentDIN);
                assert ln != null;
                clearTarget = !db.getId().equals(DbTree.ID_DB_ID);
            }

            /*
             * Get a non-blocking read lock on the LN, if this is not an
             * already locked pending node.
             */
            if (lockedPendingNodeId != ln.getNodeId()) {
                locker = BasicLocker.createBasicLocker(env, false /*noWait*/);
                /* Don't allow this short-lived lock to be preempted/stolen. */
                locker.setPreemptable(false);
                LockResult lockRet = locker.nonBlockingLock
                    (ln.getNodeId(), LockType.READ, db);
                if (lockRet.getLockGrant() == LockGrantType.DENIED) {

                    /*
                     * LN is currently locked by another Locker, so we can't
                     * assume anything about the value of the LSN in the bin.
                     */
                    if (wasCleaned) {
                        nLNsLocked.increment();
                    }
                    lockDenied = true;
                    completed = true;
                    return;
                }
            }

            /*
             * Once we have a lock, check whether the current LSN needs to be
             * migrated.  There is no need to migrate it if the LSN no longer
             * qualifies for cleaning.
             */
            Long fileNum = Long.valueOf(DbLsn.getFileNumber(lsn));
            if (!fileSelector.isFileCleaningInProgress(fileNum)) {
                obsolete = true;
                completed = true;
                if (wasCleaned) {
                    nLNsDead.increment();
                }
                return;
            }

            /* Migrate the LN. */
            byte[] key = parentDIN.getDupKey();
            long newLNLsn = ln.log(env, db, key, lsn, locker,
                                   false, /* backgroundIO */
                                   ReplicationContext.NO_REPLICATE);
            parentDIN.updateDupCountLNRef(newLNLsn);
            nLNsMigrated.increment();
            migrated = true;
            completed = true;
            return;
        } finally {
            if (isPending) {
                if (completed && !lockDenied) {
                    fileSelector.removePendingLN(lockedPendingNodeId);
                }
            } else {

                /*
                 * If a to-be-migrated LN was not processed successfully, we
                 * must guarantee that the file will not be deleted and that we
                 * will retry the LN later.  The retry information must be
                 * complete or we may delete a file later without processing
                 * all of its LNs.
                 *
                 * Note that the LN may be null if fetchTarget threw an
                 * exception above. [#16039]
                 */
                if (dclRef.getMigrate() &&
                    (!completed || lockDenied) &&
                    (ln != null)) {

                    byte[] key = parentDIN.getDupKey();
                    byte[] dupKey = null;
                    fileSelector.addPendingLN(ln, db.getId(), key, dupKey);

                    /* Wake up the cleaner thread to process pending LNs. */
                    if (!areThreadsRunning()) {
                        env.getUtilizationTracker().activateCleaner();
                    }

                    /*
                     * If we need to retry, don't clear the target since we
                     * would only have to fetch it again soon.
                     */
                    clearTarget = false;
                }
            }

            /*
             * Always clear the migrate flag.  If the LN could not be locked
             * and the migrate flag was set, the LN will have been added to the
             * pending LN set above.
             */
            dclRef.setMigrate(false);

            /*
             * If the node was originally non-resident, clear it now so that we
             * don't create more work for the evictor and reduce the cache
             * memory available to the application.
             */
            if (clearTarget) {
                parentDIN.updateDupCountLN(null);
            }

            if (locker != null) {
                locker.operationEnd();
            }

            logFine(cleanAction, ln, lsn, completed, obsolete, migrated);
        }
    }

    /**
     * Returns the main key for a given BIN entry.
     */
    byte[] getLNMainKey(BIN bin, int index) {
        if (bin.containsDuplicates()) {
            return bin.getDupKey();
        }
	return bin.getKey(index);
    }

    /**
     * Returns the duplicate key for a given BIN entry.
     */
    private byte[] getLNDupKey(BIN bin, int index, LN ln) {
        DatabaseImpl db = bin.getDatabase();

        if (!db.getSortedDuplicates() || ln.containsDuplicates()) {

            /*
             * The dup key is not needed for a non-duplicate DB or for a
             * DupCountLN.
             */
            return null;

        } else if (bin.containsDuplicates()) {

            /* The DBIN entry key is the dup key. */
            return bin.getKey(index);

        } else {

            /*
             * The data is the dup key if the LN is not deleted.  If the LN is
             * deleted, this method will return null and we will do a node ID
             * search later when processing the pending LN.
             */
            return ln.getData();
        }
    }

    /**
     * Adds the DB ID to the pending DB set if it is being deleted but deletion
     * is not yet complete.
     */
    void addPendingDB(DatabaseImpl db) {
        if (db != null && db.isDeleted() && !db.isDeleteFinished()) {
            DatabaseId id = db.getId();
            if (fileSelector.addPendingDB(id)) {
                LoggerUtils.logMsg(logger, env, Level.FINE,
                                   "CleanAddPendingDB " + id);
            }
        }
    }

    /**
     * Send trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    void logFine(String action,
               Node node,
               long logLsn,
               boolean completed,
               boolean obsolete,
               boolean dirtiedMigrated) {

        if (logger.isLoggable(Level.FINE)) {
            StringBuffer sb = new StringBuffer();
            sb.append(action);
            if (node != null) {
                sb.append(" node=");
                sb.append(node.getNodeId());
            }
            sb.append(" logLsn=");
            sb.append(DbLsn.getNoFormatString(logLsn));
            sb.append(" complete=").append(completed);
            sb.append(" obsolete=").append(obsolete);
            sb.append(" dirtiedOrMigrated=").append(dirtiedMigrated);

            LoggerUtils.logMsg(logger, env, Level.FINE, sb.toString());
        }
    }

    /**
     * Release resources and update memory budget. Should only be called
     * when this environment is closed and will never be accessed again.
     */
    public void close() {
        profile.close();
        tracker.close();
        fileSelector.close(env.getMemoryBudget());
    }
}
