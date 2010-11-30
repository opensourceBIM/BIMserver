/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.TestHookExecute;

/**
 * DbBackup is a helper class for stopping and restarting JE background
 * activity in an open environment in order to simplify backup operations. It
 * also lets the application create a backup which can support restoring the
 * environment to a specific point in time.
 * <p>
 * <b>Backing up without DbBackup:</b>
 * Because JE has an append only log file architecture, it is always possible
 * to do a hot backup without the use of DbBackup by copying all log files
 * (.jdb files) to your archival location. As long as the log files are copied
 * in alphabetical order, (numerical in effect) <i>and</i> all log files are
 * copied, the environment can be successfully backed up without any need to
 * stop database operations or background activity. This means that your
 * backup operation must do a loop to check for the creation of new log files
 * before deciding that the backup is finished. For example:
 * <pre>
 * time    files in                    activity
 *         environment
 *
 *  t0     000000001.jdb     Backup starts copying file 1
 *         000000003.jdb
 *         000000004.jdb
 *
 *  t1     000000001.jdb     JE log cleaner migrates portion of file 3 to newly
 *         000000004.jdb     created file 5 and deletes file 3. Backup finishes
 *         000000005.jdb     file 1, starts copying file 4. Backup MUST include
 *                           file 5 for a consistent backup!
 *
 *  t2     000000001.jdb     Backup finishes copying file 4, starts and
 *         000000004.jdb     finishes file 5, has caught up. Backup ends.
 *         000000005.jdb
 *</pre>
 * <p>
 * In the example above, the backup operation must be sure to copy file 5,
 * which came into existence after the backup had started. If the backup
 * stopped operations at file 4, the backup set would include only file 1 and
 * 4, omitting file 3, which would be an inconsistent set.
 * <p>
 * Also note that log file 5 may not have filled up before it was copied to
 * archival storage. On the next backup, there might be a newer, larger version
 * of file 5, and that newer version should replace the older file 5 in archive
 * storage.
 * <p>
 * <b>Backup up with DbBackup</b>
 * <p>
 * DbBackup helps simplify application backup by defining the set of files that
 * must be copied for each backup operation. If the environment directory has
 * read/write protection, the application must pass DbBackup an open,
 * read/write environment handle.
 * <p>
 * When entering backup mode, JE
 * determines the set of log files needed for a consistent backup, and freezes
 * all changes to those files. The application can copy that defined set of
 * files and finish operation without checking for the ongoing creation of new
 * files. Also, there will be no need to check for a newer version of the last
 * file on the next backup.
 * <p>
 * In the example above, if DbBackup was used at t0, the application would only
 * have to copy files 1, 3 and 4 to back up. On a subsequent backup, the
 * application could start its copying at file 5. There would be no need to
 * check for a newer version of file 4.
 * <p>
 * An example usage:
 * <pre>
 *
 *    Environment env = new Environment(...);
 *    DbBackup backupHelper = new DbBackup(env);
 *
 *    // Find the file number of the last file in the previous backup
 *    // persistently, by either checking the backup archive, or saving
 *    // state in a persistent file.
 *    long lastFileInPrevBackup =  ...
 *
 *    // Start backup, find out what needs to be copied.
 *    backupHelper.startBackup();
 *    try {
 *        String[] filesForBackup =
 *             backupHelper.getLogFilesInBackupSet(lastFileInPrevBackup);
 *
 *        // Copy the files to archival storage.
 *        myApplicationCopyMethod(filesForBackup)

 *        // Update our knowledge of the last file saved in the backup set,
 *        // so we can copy less on the next backup
 *        lastFileInPrevBackup = backupHelper.getLastFileInBackupSet();
 *        myApplicationSaveLastFile(lastFileInPrevBackup);
 *    } finally {
 *        // Remember to exit backup mode, or all log files won't be cleaned
 *        // and disk usage will bloat.
 *       backupHelper.endBackup();
 *   }
 * </pre>
 */
public class DbBackup {

    private EnvironmentImpl envImpl;
    private boolean backupStarted;
    private long lastFileInBackup = -1;
    private long firstFileInBackup;
    private boolean envIsReadOnly;
    /* Status presents whether this back up is invalid because of roll back. */
    private boolean invalid;
    /* The rollback start file number. */
    private long rollbackStartedFileNumber;
    /* For unit tests. */
    private TestHook testHook;

    /**
     * Creates a DbBackup helper for a full backup.
     *
     * <p>This is equivalent to using {@link #DbBackup(Environment,long)} and
     * passing {@code -1} for the {@code lastFileInPrevBackup} parameter.</p>
     *
     * @param env with an open, valid environment handle.  If the environment
     * directory has read/write permissions, the environment handle must be
     * configured for read/write.
     *
     * @throws IllegalArgumentException if the environment directory has
     * read/write permissions, but the environment handle is not configured for
     * read/write.
     */
    public DbBackup(Environment env)
        throws DatabaseException {

        this(env, -1);
    }

    /**
     * Creates a DbBackup helper for an incremental backup.
     *
     * @param env with an open, valid environment handle.  If the environment
     * directory has read/write permissions, the environment handle must be
     * configured for read/write.
     *
     * @param lastFileInPrevBackup the last file in the previous backup set
     * when performing an incremental backup, or {@code -1} to perform a full
     * backup.  The first file in this backup set will be the file following
     * {@code lastFileInPrevBackup}.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalArgumentException if the environment directory has
     * read/write permissions, but the environment handle is not configured for
     * read/write.
     */
    public DbBackup(Environment env, long lastFileInPrevBackup)
        throws DatabaseException {

        /* Check that the Environment is open. */
        env.checkHandleIsValid();
        init(DbInternal.getEnvironmentImpl(env), lastFileInPrevBackup);
    }

    /**
     * @hidden
     * For internal use only.
     */
    public DbBackup(EnvironmentImpl envImpl)
        throws DatabaseException {

        init(envImpl, -1);
    }

    /**
     * This is the true body of the DbBackup constructor. It's implemented
     * as an init method rather than a constructor so that other overloadings
     * can check the env handle validity first.
     */
    private void init(EnvironmentImpl envImpl, long lastFileInPrevBackup)
        throws DatabaseException {

        this.envImpl = envImpl;
        FileManager fileManager = envImpl.getFileManager();

        /*
         * If the environment is writable, we need a r/w environment handle
         * in order to flip the file.
         */
        envIsReadOnly = fileManager.checkEnvHomePermissions(true);
        if ((!envIsReadOnly) && envImpl.isReadOnly()) {
            throw new IllegalArgumentException
                ("Environment handle may not be read-only when directory " +
                 "is read-write");
        }

        firstFileInBackup = lastFileInPrevBackup + 1;
    }

    /**
     * Start backup mode in order to determine the definitive backup set needed
     * at this point in time.
     *
     * <p>This method determines the last file in the backup set, which is the
     * last log file in the environment at this point in time.  Following this
     * method call, all new data will be written to other, new log files.  In
     * other words, the last file in the backup set will not be modified after
     * this method returns.</p>
     *
     * <p><em>WARNING:</em> After calling this method, deletion of log files in
     * the backup set by the JE log cleaner will be disabled until {@link
     * #endBackup()} is called.  To prevent unbounded growth of disk usage, be
     * sure to call {@link #endBackup()} to re-enable log file deletion.</p>
     *
     * @throws com.sleepycat.je.rep.LogOverwriteException if a replication
     * operation is overwriting log files. The backup can not proceed because
     * files may be invalid. The backup may be attempted at a later time.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if a backup is already in progress
     */
    public synchronized void startBackup()
        throws DatabaseException {

        if (backupStarted) {
            throw new IllegalStateException("startBackup was already called");
        }

        /* Throw a LogOverwriteException if the Environment is rolling back. */
        if (!envImpl.addDbBackup(this)) {
            throw envImpl.createLogOverwriteException
                ("A replication operation is overwriting log files. The " +
                 "backup can not proceed because files may be invalid. The " +
                 "backup may be attempted at a later time.");
        }

        /* Prevent files in the backup set from being deleted. */
        envImpl.getCleaner().addProtectedFileRange(firstFileInBackup);

        /*
         * At this point, endBackup must be called to undo the protected file
         * range.
         */
        backupStarted = true;

        /*
         * Flip the log so that we can know that the list of files
         * corresponds to a given point.
         */
        if (envIsReadOnly) {
            FileManager fileManager = envImpl.getFileManager();
            lastFileInBackup = fileManager.getLastFileNum();
        } else {
            long newFileLsn = envImpl.forceLogFileFlip();
            lastFileInBackup = DbLsn.getFileNumber(newFileLsn) - 1;
        }
    }

    /**
     * End backup mode, thereby re-enabling normal deletion of log files by the
     * JE log cleaner.
     *
     * @throws com.sleepycat.je.rep.LogOverwriteException if a replication
     * operation has overwritten log files. Any copied files should be
     * considered invalid and discarded.  The backup may be attempted at a
     * later time.
     *
     * @throws com.sleepycat.je.EnvironmentFailureException if an unexpected,
     * internal or environment-wide failure occurs.
     *
     * @throws IllegalStateException if a backup has not been started.
     */
    public synchronized void endBackup() {
        checkBackupStarted();
        backupStarted = false;

        assert TestHookExecute.doHookIfSet(testHook);

        envImpl.getCleaner().removeProtectedFileRange(firstFileInBackup);

        envImpl.removeDbBackup(this);
        /* If this back up is invalid, throw a LogOverwriteException. */
        if (invalid) {
            invalid = false;
            throw envImpl.createLogOverwriteException
                ("A replication operation has overwritten log files from " +
                 "file " + rollbackStartedFileNumber + ". Any copied files " +
                 "should be considered invalid and discarded. The backup " +
                 "may be attempted at a later time.");
        }
    }

    /**
     * Can only be called in backup mode, after startBackup() has been called.
     *
     * @return the file number of the last file in the current backup set.
     * Save this value to reduce the number of files that must be copied at
     * the next backup session.
     *
     * @throws IllegalStateException if a backup has not been started.
     */
    public synchronized long getLastFileInBackupSet() {
        checkBackupStarted();
        return lastFileInBackup;
    }

    /**
     * Get the list of all files that are needed for the environment at the
     * point of time when backup mode started.  Can only be called in backup
     * mode, after startBackup() has been called.
     *
     * <p>The file numbers returned are in the range from the constructor
     * parameter {@code lastFileInPrevBackup + 1} to the last log file at the
     * time that {@link #startBackup} was called.</p>
     *
     * @return the names of all files in the backup set, sorted in alphabetical
     * order.  The return values are simple file names, not full paths.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if a backup has not been started.
     */
    public synchronized String[] getLogFilesInBackupSet() {
        checkBackupStarted();
        return envImpl.getFileManager().listFiles(firstFileInBackup,
                                                  lastFileInBackup);
    }

    /**
     * Get the minimum list of files that must be copied for this backup. This
     * consists of the set of backup files that are greater than the last file
     * copied in the previous backup session.  Can only be called in backup
     * mode, after startBackup() has been called.
     *
     * @param lastFileInPrevBackup file number of last file copied in the last
     * backup session, obtained from getLastFileInBackupSet().
     *
     * @return the names of all the files in the backup set that come after
     * lastFileInPrevBackup.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if a backup has not been started.
     *
     * @deprecated replaced by {@link #getLogFilesInBackupSet()}; pass
     * lastFileInPrevBackup to the {@link #DbBackup(Environment,long)}
     * constructor.
     */
    public synchronized
        String[] getLogFilesInBackupSet(long lastFileInPrevBackup) {
        checkBackupStarted();
        FileManager fileManager = envImpl.getFileManager();
        return fileManager.listFiles(lastFileInPrevBackup + 1,
                                     lastFileInBackup);
    }

    private void checkBackupStarted() {
        if (!backupStarted) {
            throw new IllegalStateException("startBackup was not called");
        }
    }

    /**
     * @hidden
     * Returns true if a backup has been started and is in progress.
     */
    public synchronized boolean backupIsOpen() {
        return backupStarted;
    }

    /**
     * @hidden
     *
     * Invalidate this backup if replication overwrites the log.
     */
    public void invalidate(long fileNumber) {
        invalid = true;
        this.rollbackStartedFileNumber = fileNumber;
    }

    /**
     * @hidden
     *
     * A test entry point used to simulate the environment is now rolling back,
     * and this TestHook would invalidate the in progress DbBackups. 
     */
    public void setTestHook(TestHook testHook) {
        this.testHook = testHook;
    }
}
