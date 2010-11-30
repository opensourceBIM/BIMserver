/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_BYTES_READ_FROM_WRITEQUEUE;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_BYTES_WRITTEN_FROM_WRITEQUEUE;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_FILE_OPENS;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_LOG_FSYNCS;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_OPEN_FILES;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_RANDOM_READS;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_RANDOM_READ_BYTES;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_RANDOM_WRITES;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_RANDOM_WRITE_BYTES;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_READS_FROM_WRITEQUEUE;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_SEQUENTIAL_READS;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_SEQUENTIAL_READ_BYTES;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_SEQUENTIAL_WRITES;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_SEQUENTIAL_WRITE_BYTES;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_WRITEQUEUE_OVERFLOW;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_WRITEQUEUE_OVERFLOW_FAILURES;
import static com.sleepycat.je.log.LogStatDefinition.FILEMGR_WRITES_FROM_WRITEQUEUE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.LogWriteException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.ThreadInterruptedException;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.latch.Latch;
import com.sleepycat.je.log.entry.FileHeaderEntry;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.HexFormatter;
import com.sleepycat.je.utilint.IntStat;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.RelatchRequiredException;
import com.sleepycat.je.utilint.StatGroup;

/**
 * The FileManager presents the abstraction of one contiguous file.  It doles
 * out LSNs.
 */
public class FileManager {

    public enum FileMode {
        READ_MODE("r", false),
        READWRITE_MODE("rw", true),
        READWRITE_ODSYNC_MODE("rwd", true),
        READWRITE_OSYNC_MODE("rws", true);

        private String fileModeValue;
        private boolean isWritable;

        private FileMode(String fileModeValue, boolean isWritable) {
            this.fileModeValue = fileModeValue;
            this.isWritable = isWritable;
        }

        public String getModeValue() {
            return fileModeValue;
        }

        public boolean isWritable() {
            return isWritable;
        }
    }

    static boolean IO_EXCEPTION_TESTING_ON_WRITE = false;
    static boolean IO_EXCEPTION_TESTING_ON_READ = false;
    static boolean THROW_RRE_FOR_UNIT_TESTS = false;
    private static final String DEBUG_NAME = FileManager.class.getName();
    private static final boolean DEBUG = false;

    /**
     * Returns whether we are in a test mode where we attempt to continue
     * after a write IOException.  This method will never return true in
     * production use.
     */
    public static boolean continueAfterWriteException() {
        return IO_EXCEPTION_TESTING_ON_WRITE && !THROW_RRE_FOR_UNIT_TESTS;
    }

    /*
     * The number of writes that have been performed.
     *
     * public so that unit tests can diddle them.
     */
    public static long WRITE_COUNT = 0;

    /*
     * The write count value where we should stop or throw.
     */
    public static long STOP_ON_WRITE_COUNT = Long.MAX_VALUE;

    /*
     * If we're throwing, then throw on write #'s WRITE_COUNT through
     * WRITE_COUNT + N_BAD_WRITES - 1 (inclusive).
     */
    public static long N_BAD_WRITES = Long.MAX_VALUE;

    /*
     * If true, then throw an IOException on write #'s WRITE_COUNT through
     * WRITE_COUNT + N_BAD_WRITES - 1 (inclusive).
     */
    public static boolean THROW_ON_WRITE = false;

    public static final String JE_SUFFIX = ".jdb";  // regular log files
    public static final String DEL_SUFFIX = ".del";  // cleaned files
    public static final String BAD_SUFFIX = ".bad";  // corrupt files
    private static final String LOCK_FILE = "je.lck";// lock file
    static final String[] DEL_SUFFIXES = { DEL_SUFFIX };
    static final String[] JE_SUFFIXES = { JE_SUFFIX };
    private static final String[] JE_AND_DEL_SUFFIXES =
    { JE_SUFFIX, DEL_SUFFIX };

    /*
     * The suffix used to denote a file that is in the process of being
     * transferred during a network backup. The file may not have been
     * completely transferred, or its digest verified.
     */
    public static final String TMP_SUFFIX = ".tmp";

    /*
     * The suffix used to rename files out of the way, if they are being
     * retained during a backup. Note that the suffix is used in conjunction
     * with a backup number as described in <code>NetworkBackup</code>
     */
    public static final String BUP_SUFFIX = ".bup";

    /* May be set to false to speed unit tests. */
    private boolean syncAtFileEnd = true;

    private final EnvironmentImpl envImpl;
    private long maxFileSize;
    private final File dbEnvHome;

    /* True if .del files should be included in the list of log files. */
    private boolean includeDeletedFiles = false;

    /* File cache */
    private FileCache fileCache;
    private Latch fileCacheLatch;

    /* The channel and lock for the je.lck file. */
    private RandomAccessFile lockFile;
    private FileChannel channel;
    private FileLock envLock;
    private FileLock exclLock;

    /* True if all files should be opened readonly. */
    private final boolean readOnly;

    /* Handles onto log position */
    private long currentFileNum;     // number of the current file
    private long nextAvailableLsn;   // nextLSN is the next one available
    private long lastUsedLsn;        // last LSN used in the current log file
    private long prevOffset;         // Offset to use for the previous pointer
    private boolean forceNewFile;    // Force new file on next write

    /*
     * Saved versions of above.  Save this in case a write causes an
     * IOException, we can back the log up to the last known good LSN.
     */
    private long savedCurrentFileNum;
    private long savedNextAvailableLsn; // nextLSN is the next one available
    private long savedLastUsedLsn;   // last LSN used in the current log file
    private long savedPrevOffset;    // Offset to use for the previous pointer
    private boolean savedForceNewFile;

    /* endOfLog is used for writes and fsyncs to the end of the log. */
    private final LogEndFileDescriptor endOfLog;

    /* group commit sync */
    private FSyncManager syncManager;

    /*
     * When we bump the LSNs over to a new file, we must remember the last LSN
     * of the previous file so we can set the prevOffset field of the file
     * header appropriately. We have to save it in a map because there's a time
     * lag between when we know what the last LSN is and when we actually do
     * the file write, because LSN bumping is done before we get a write
     * buffer.  This map is keyed by file num->last LSN.
     */
    private Map<Long, Long> perFileLastUsedLsn;

    /*
     * True if we should use the Write Queue.  This queue is enabled by default
     * and contains any write() operations which were attempted but would have
     * blocked because an fsync() or another write() was in progress at the
     * time.  The operations on the Write Queue are later executed by the next
     * operation that is able to grab the fsync latch.  File systems like ext3
     * need this queue in order to achieve reasonable throughput since it
     * acquires an exclusive mutex on the inode during any IO operation
     * (seek/read/write/fsync).  OS's like Windows and Solaris do not since
     * they are able to handle concurrent IO operations on a single file.
     */
    private boolean useWriteQueue;

    /* The starting size of the Write Queue. */
    private int writeQueueSize;

    /*
     * Use O_DSYNC to open JE log files.
     */
    private final boolean useODSYNC;

    /* public for unit tests. */
    public boolean VERIFY_CHECKSUMS = false;

    /*
     * Last file to which any IO was done.
     */
    long lastFileNumberTouched = -1;

    /*
     * Current file offset of lastFile.
     */
    long lastFileTouchedOffset = 0;

    /*
     * For IO stats, this is a measure of what is "close enough" to constitute
     * a sequential IO vs a random IO. 1MB for now.  Generally a seek within a
     * few tracks of the current disk track is "fast" and only requires a
     * single rotational latency.
     */
    private static final long ADJACENT_TRACK_SEEK_DELTA = 1 << 20;

    /*
     * Stats
     */
    final StatGroup stats;
    final LongStat nRandomReads;
    final LongStat nRandomWrites;
    final LongStat nSequentialReads;
    final LongStat nSequentialWrites;
    final LongStat nRandomReadBytes;
    final LongStat nRandomWriteBytes;
    final LongStat nSequentialReadBytes;
    final LongStat nSequentialWriteBytes;
    final IntStat nFileOpens;
    final IntStat nOpenFiles;
    final LongStat nBytesReadFromWriteQueue;
    final LongStat nBytesWrittenFromWriteQueue;
    final LongStat nReadsFromWriteQueue;
    final LongStat nWritesFromWriteQueue;
    final LongStat nWriteQueueOverflow;
    final LongStat nWriteQueueOverflowFailures;
    /* all fsyncs, includes those issued for group commit */
    final LongStat nLogFSyncs;

    /**
     * Set up the file cache and initialize the file manager to point to the
     * beginning of the log.
     *
     * @param configManager
     * @param dbEnvHome environment home directory
     *
     * @throws IllegalArgumentException via Environment ctor
     *
     * @throws EnvironmentLockedException via Environment ctor
     */
    public FileManager(EnvironmentImpl envImpl,
                       File dbEnvHome,
                       boolean readOnly)
        throws EnvironmentLockedException {

        this.envImpl = envImpl;
        this.dbEnvHome = dbEnvHome;
        this.readOnly = readOnly;

        boolean success = false;

        stats = new StatGroup(LogStatDefinition.FILEMGR_GROUP_NAME,
                              LogStatDefinition.FILEMGR_GROUP_DESC);
        nRandomReads = new LongStat(stats, FILEMGR_RANDOM_READS);
        nRandomWrites = new LongStat(stats, FILEMGR_RANDOM_WRITES);
        nSequentialReads = new LongStat(stats, FILEMGR_SEQUENTIAL_READS);
        nSequentialWrites = new LongStat(stats, FILEMGR_SEQUENTIAL_WRITES);
        nRandomReadBytes = new LongStat(stats, FILEMGR_RANDOM_READ_BYTES);
        nRandomWriteBytes = new LongStat(stats, FILEMGR_RANDOM_WRITE_BYTES);
        nSequentialReadBytes =
            new LongStat(stats, FILEMGR_SEQUENTIAL_READ_BYTES);
        nSequentialWriteBytes =
            new LongStat(stats, FILEMGR_SEQUENTIAL_WRITE_BYTES);
        nFileOpens = new IntStat(stats, FILEMGR_FILE_OPENS);
        nOpenFiles = new IntStat(stats, FILEMGR_OPEN_FILES);
        nBytesReadFromWriteQueue =
            new LongStat(stats, FILEMGR_BYTES_READ_FROM_WRITEQUEUE);
        nBytesWrittenFromWriteQueue =
            new LongStat(stats, FILEMGR_BYTES_WRITTEN_FROM_WRITEQUEUE);
        nReadsFromWriteQueue =
            new LongStat(stats, FILEMGR_READS_FROM_WRITEQUEUE);
        nWritesFromWriteQueue =
            new LongStat(stats, FILEMGR_WRITES_FROM_WRITEQUEUE);
        nWriteQueueOverflow = new LongStat(stats, FILEMGR_WRITEQUEUE_OVERFLOW);
        nWriteQueueOverflowFailures =
            new LongStat(stats, FILEMGR_WRITEQUEUE_OVERFLOW_FAILURES);
        nLogFSyncs = new LongStat(stats, FILEMGR_LOG_FSYNCS);

        try {
            /* Read configurations. */
            DbConfigManager configManager = envImpl.getConfigManager();
            maxFileSize =
                configManager.getLong(EnvironmentParams.LOG_FILE_MAX);

            useWriteQueue = configManager.getBoolean
                (EnvironmentParams.LOG_USE_WRITE_QUEUE);
            writeQueueSize = configManager.getInt
                (EnvironmentParams.LOG_WRITE_QUEUE_SIZE);
            useODSYNC = configManager.getBoolean
                (EnvironmentParams.LOG_USE_ODSYNC);
            VERIFY_CHECKSUMS = configManager.getBoolean
                (EnvironmentParams.LOG_VERIFY_CHECKSUMS);

            if (!envImpl.isMemOnly()) {
                if (!dbEnvHome.exists()) {
                    throw new IllegalArgumentException
                        ("Environment home " + dbEnvHome + " doesn't exist");
                }
                if (!lockEnvironment(readOnly, false)) {
                    throw new EnvironmentLockedException
                        (envImpl,
                         "The environment cannot be locked for " +
                         (readOnly ? "shared" : "single writer") + " access.");
                }
            }

            /* Cache of files. */
            fileCache = new FileCache(configManager);
            fileCacheLatch = new Latch(DEBUG_NAME + "_fileCache");

            /* Start out as if no log existed. */
            currentFileNum = 0L;
            nextAvailableLsn =
                DbLsn.makeLsn(currentFileNum, firstLogEntryOffset());
            lastUsedLsn = DbLsn.NULL_LSN;
            perFileLastUsedLsn = new HashMap<Long, Long>();
            prevOffset = 0L;
            endOfLog = new LogEndFileDescriptor();
            forceNewFile = false;
            saveLastPosition();

            final String stopOnWriteCountName = "je.debug.stopOnWriteCount";
            final String stopOnWriteCountProp =
                System.getProperty(stopOnWriteCountName);
            if (stopOnWriteCountProp != null) {
                try {
                    STOP_ON_WRITE_COUNT = Long.parseLong(stopOnWriteCountProp);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException
                        ("Could not parse: " + stopOnWriteCountName, e);
                }
            }

            final String stopOnWriteActionName = "je.debug.stopOnWriteAction";
            final String stopOnWriteActionProp =
                System.getProperty(stopOnWriteActionName);
            if (stopOnWriteActionProp != null) {
                if (stopOnWriteActionProp.compareToIgnoreCase("throw") == 0) {
                    THROW_ON_WRITE = true;
                } else if (stopOnWriteActionProp.
                           compareToIgnoreCase("stop") == 0) {
                    THROW_ON_WRITE = false;
                } else {
                    throw new IllegalArgumentException
                        ("Unknown value for: " + stopOnWriteActionName  +
                         stopOnWriteActionProp);
                }
            }

            syncManager = new FSyncManager(envImpl);
            success = true;
        } finally {
            if (!success) {
                try {
                    close();
                } catch (IOException e) {

                    /*
                     * Klockwork - ok
                     * Eat it, we want to throw the original exception.
                     */
                }
            }
        }
    }

    /**
     * Set the file manager's "end of log".
     *
     * @param nextAvailableLsn LSN to be used for the next log entry
     * @param lastUsedLsn last LSN to have a valid entry, may be null
     * @param prevOffset value to use for the prevOffset of the next entry.
     *  If the beginning of the file, this is 0.
     */
    public void setLastPosition(long nextAvailableLsn,
                                long lastUsedLsn,
                                long prevOffset) {
        this.lastUsedLsn = lastUsedLsn;
        perFileLastUsedLsn.put(Long.valueOf(DbLsn.getFileNumber(lastUsedLsn)),
                               Long.valueOf(lastUsedLsn));
        this.nextAvailableLsn = nextAvailableLsn;
        currentFileNum = DbLsn.getFileNumber(this.nextAvailableLsn);
        this.prevOffset = prevOffset;
        saveLastPosition();
    }

    /*
     * Cause the current LSN state to be saved in case we fail after we have
     * bumped the LSN pointer but before we've successfully marshalled into the
     * log buffer.
     */
    void saveLastPosition() {
        savedNextAvailableLsn = nextAvailableLsn;
        savedLastUsedLsn = lastUsedLsn;
        savedPrevOffset = prevOffset;
        savedForceNewFile = forceNewFile;
        savedCurrentFileNum = currentFileNum;
    }

    void restoreLastPosition() {
        nextAvailableLsn = savedNextAvailableLsn;
        lastUsedLsn = savedLastUsedLsn;
        prevOffset = savedPrevOffset;
        forceNewFile = savedForceNewFile;
        currentFileNum = savedCurrentFileNum;
    }

    /**
     * May be used to disable sync at file end to speed unit tests.
     * Must only be used for unit testing, since log corruption may result.
     */
    public void setSyncAtFileEnd(boolean sync) {
        syncAtFileEnd = sync;
    }

    /*
     * File management
     */

    /**
     * public for cleaner.
     *
     * @return the number of the first file in this environment.
     */
    public Long getFirstFileNum() {
        return getFileNum(true);
    }

    public boolean getReadOnly() {
        return readOnly;
    }

    /**
     * @return the number of the last file in this environment.
     */
    public Long getLastFileNum() {
        return getFileNum(false);
    }

    /**
     * Returns the highest (current) file number.  Because a long value cannot
     * be read atomically without synchronization, this method should be called
     * while holding the log write latch.
     */
    public long getCurrentFileNum() {
        return currentFileNum;
    }

    /**
     * For unit tests.
     */
    boolean getUseWriteQueue() {
        return useWriteQueue;
    }

    /**
     * For assertions that check whether a file is valid or has been deleted
     * via log cleaning.
     */
    public boolean isFileValid(long fileNum) {

        /*
         * If the file is the current file, it may be buffered and not yet
         * created.  If the env is memory-only, we will never create or delete
         * log files.
         */
        if (fileNum == currentFileNum || envImpl.isMemOnly()) {
            return true;
        }

        /* Check for file existence. */
        String fileName = getFullFileName(fileNum, FileManager.JE_SUFFIX);
        File file = new File(fileName);
        return file.exists();
    }

    public void setIncludeDeletedFiles(boolean includeDeletedFiles) {
        this.includeDeletedFiles = includeDeletedFiles;
    }

    /**
     * Get all JE file numbers.
     * @return an array of all JE file numbers.
     */
    public Long[] getAllFileNumbers() {
        /* Get all the names in sorted order. */
        String[] names = listFiles(JE_SUFFIXES);
        Long[] nums = new Long[names.length];
        for (int i = 0; i < nums.length; i += 1) {
            nums[i] = getNumFromName(names[i]);
        }
        return nums;
    }

    /**
     * Get the next file number before/after currentFileNum.
     * @param currentFileNum1 the file we're at right now. Note that
     * it may not exist, if it's been cleaned and renamed.
     * @param forward if true, we want the next larger file, if false
     * we want the previous file
     * @return null if there is no following file, or if filenum doesn't exist
     */
    public Long getFollowingFileNum(long currentFileNum1, boolean forward) {
        /* Get all the names in sorted order. */
        String[] names = listFiles(JE_SUFFIXES);

        /* Search for the current file. */
        String searchName = getFileName(currentFileNum1, JE_SUFFIX);
        int foundIdx = Arrays.binarySearch(names, searchName);

        boolean foundTarget = false;
        if (foundIdx >= 0) {
            if (forward) {
                foundIdx++;
            } else {
                foundIdx --;
            }
        } else {

            /*
             * currentFileNum not found (might have been cleaned). FoundIdx
             * will be (-insertionPoint - 1).
             */
            foundIdx = Math.abs(foundIdx + 1);
            if (!forward) {
                foundIdx--;
            }
        }

        /* The current fileNum is found, return the next or prev file. */
        if (forward && (foundIdx < names.length)) {
            foundTarget = true;
        } else if (!forward && (foundIdx > -1)) {
            foundTarget = true;
        }

        if (foundTarget) {
            return getNumFromName(names[foundIdx]);
        }
        return null;
    }

    /**
     * @return true if there are any files at all.
     */
    public boolean filesExist() {
        String[] names = listFiles(JE_SUFFIXES);
        return (names.length != 0);
    }

    /**
     * Get the first or last file number in the set of JE files.
     *
     * @param first if true, get the first file, else get the last file
     * @return the file number or null if no files exist
     */
    private Long getFileNum(boolean first) {
        String[] names = listFiles(JE_SUFFIXES);
        if (names.length == 0) {
            return null;
        }
        int index = 0;
        if (!first) {
            index = names.length - 1;
        }
        return getNumFromName(names[index]);
    }

    /**
     * Get the file number from a file name.
     *
     * @param the file name
     * @return the file number
     */
    public Long getNumFromName(String fileName) {
        String fileNumber = fileName.substring(0, fileName.indexOf("."));
        return Long.valueOf(Long.parseLong(fileNumber, 16));
    }

    /**
     * Find JE files. Return names sorted in ascending fashion.
     * @param suffix which type of file we're looking for
     * @return array of file names
     */
    public String[] listFiles(String[] suffixes) {
        String[] fileNames = dbEnvHome.list(new JEFileFilter(suffixes));
        if (fileNames != null) {
            Arrays.sort(fileNames);
        } else {
            fileNames = new String[0];
        }
        return fileNames;
    }

    /**
     * Find .jdb files which are >= the minimimum file number and
     * <= the maximum file number.
     * Return names sorted in ascending fashion.
     *
     * @return array of file names
     */
    public String[] listFiles(long minFileNumber, long maxFileNumber) {

        String[] fileNames = dbEnvHome.list(new JEFileFilter(JE_SUFFIXES,
                                                             minFileNumber,
                                                             maxFileNumber));
        Arrays.sort(fileNames);
        return fileNames;
    }

   /**
     * Find JE files, flavor for unit test support.
     *
     * @param suffix which type of file we're looking for
     * @return array of file names
     */
    public static String[] listFiles(File envDirFile, String[] suffixes) {
        String[] fileNames = envDirFile.list(new JEFileFilter(suffixes));
        if (fileNames != null) {
            Arrays.sort(fileNames);
        } else {
            fileNames = new String[0];
        }
        return fileNames;
    }

    /**
     * @return the full file name and path for the nth JE file.
     */
    String[] getFullFileNames(long fileNum) {
        if (includeDeletedFiles) {
            int nSuffixes = JE_AND_DEL_SUFFIXES.length;
            String[] ret = new String[nSuffixes];
            for (int i = 0; i < nSuffixes; i++) {
                ret[i] = getFullFileName(getFileName(fileNum,
                                                     JE_AND_DEL_SUFFIXES[i]));
            }
            return ret;
        }
        return new String[]
            { getFullFileName(getFileName(fileNum, JE_SUFFIX)) };
    }

    /**
     * Remove files from the environment home directory.
     * @param envFile environment directory
     */
    public static void removeFiles(File envFile) {
        File[] targetFiles = envFile.listFiles();

        /* Clean up any target files in this directory. */
        for (File f : targetFiles) {
            if (f.isDirectory() ||
                f.getName().equals("je.properties")) {
                continue;
            }
            boolean done = f.delete();
            if (!done) {
                System.out.println
                    ("Warning, couldn't delete " + f +
                     " out of " + targetFiles[targetFiles.length - 1]);
            }
        }
    }

    /**
     * @return the full file name and path for the given file number and
     * suffix.
     */
    public String getFullFileName(long fileNum, String suffix) {
        return getFullFileName(getFileName(fileNum, suffix));
    }

    /**
     * @return the full file name and path for this file name.
     */
    private String getFullFileName(String fileName) {
        return dbEnvHome + File.separator + fileName;
    }

    /**
     * @return the file name for the nth file.
     */
    public static String getFileName(long fileNum, String suffix) {

        return (getFileNumberString(fileNum) + suffix);
    }

    /**
     * HexFormatter generates a 0 padded string starting with 0x.  We want
     * the right most 8 digits, so start at 10.
     */
    private static String getFileNumberString(long fileNum) {
        return HexFormatter.formatLong(fileNum).substring(10);
    }

    /**
     * Rename this file to NNNNNNNN.suffix. If that file already exists, try
     * NNNNNNNN.suffix.1, etc. Used for deleting files or moving corrupt files
     * aside.
     *
     * @param fileNum the file we want to move
     *
     * @param newSuffix the new file suffix
     *
     * @return true if successful, false if File.renameTo returns false, which
     * can occur on Windows if the file was recently closed.
     */
    public boolean renameFile(final long fileNum, final String newSuffix)
        throws IOException, DatabaseException {

        String generation = "";
        int repeatNum = 0;
        while (true) {
            final String newName =
                getFullFileName(getFileName(fileNum, newSuffix) + generation);
            final File targetFile = new File(newName);
            if (!targetFile.exists()) {
                final String oldFileName = getFullFileNames(fileNum)[0];
                clearFileCache(fileNum);
                final File oldFile = new File(oldFileName);
                return oldFile.renameTo(targetFile);
            }
            repeatNum++;
            generation = "." + repeatNum;
        }
    }

    /**
     * Delete log file NNNNNNNN.
     *
     * @param fileNum the file we want to move
     *
     * @return true if successful, false if File.delete returns false, which
     * can occur on Windows if the file was recently closed.
     */
    public boolean deleteFile(final long fileNum)
        throws IOException, DatabaseException {

        final String fileName = getFullFileNames(fileNum)[0];
        clearFileCache(fileNum);
        final File file = new File(fileName);
        return file.delete();
    }

    /**
     * Returns the log version for the given file.
     */
    public int getFileLogVersion(long fileNum)
        throws DatabaseException  {

        try {
            FileHandle handle = getFileHandle(fileNum);
            int logVersion = handle.getLogVersion();
            handle.release();
            return logVersion;
        } catch (FileNotFoundException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_FILE_NOT_FOUND, e);
        } catch (ChecksumException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_CHECKSUM, e);
        }
    }

    /**
     * Return a read only file handle that corresponds to this file number.
     * Retrieve it from the cache or open it anew and validate the file header.
     * This method takes a latch on this file, so that the file descriptor will
     * be held in the cache as long as it's in use.  When the user is done with
     * the file, the latch must be released.
     *
     * @param fileNum which file
     * @return the file handle for the existing or newly created file
     */
    public FileHandle getFileHandle(long fileNum)
        throws FileNotFoundException, ChecksumException, DatabaseException  {

        /* Check the file cache for this file. */
        Long fileId = Long.valueOf(fileNum);
        FileHandle fileHandle = null;

        /**
         * Loop until we get an open FileHandle.
         */
        try {
            while (true) {

                /*
                 * The file cache is intentionally not latched here so that
                 * it's not a bottleneck in the fast path.  We check that the
                 * file handle that we get back is really still open after we
                 * latch it down below.
                 */
                fileHandle = fileCache.get(fileId);

                /*
                 * If the file isn't in the cache, latch the cache and check
                 * again.  Under the latch, if the file is not in the cache we
                 * add it to the cache but do not open the file yet.  We latch
                 * the handle here, and open the file further below after
                 * releasing the cache latch.  This prevents blocking other
                 * threads that are opening other files while we open this
                 * file.  The latch on the handle blocks other threads waiting
                 * to open the same file, which is necessary.
                 */
                boolean newHandle = false;
                if (fileHandle == null) {
                    if (EnvironmentImpl.getFairLatches()) {
                        fileCacheLatch.acquire();
                        try {
                            fileHandle = fileCache.get(fileId);
                            if (fileHandle == null) {
                                newHandle = true;
                                fileHandle = addFileHandle(fileId);
                            }
                        } finally {
                            fileCacheLatch.release();
                        }
                    } else {
                        synchronized (fileCacheLatch) {
                            fileHandle = fileCache.get(fileId);
                            if (fileHandle == null) {
                                newHandle = true;
                                fileHandle = addFileHandle(fileId);
                            }
                        }
                    }
                }

                if (newHandle) {

                    /*
                     * Open the file with the fileHandle latched.  It was
                     * latched by addFileHandle above.
                     */
                    boolean success = false;
                    try {
                        openFileHandle(fileHandle, FileMode.READ_MODE);
                        success = true;
                    } finally {
                        if (!success) {
                            /* An exception is in flight -- clean up. */
                            fileHandle.release();
                            clearFileCache(fileNum);
                        }
                    }
                } else {

                    /*
                     * The handle was found in the cache.  Latch the fileHandle
                     * before checking getFile below and returning.
                     */
                    fileHandle.latch();
                }

                /*
                 * We may have obtained this file handle outside the file cache
                 * latch, so we have to test that the handle is still valid.
                 * If it's not, then loop back and try again.
                 */
                if (fileHandle.getFile() == null) {
                    fileHandle.release();
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            /* Handle at higher levels. */
            throw e;
        } catch (IOException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_READ, e);
        }

        return fileHandle;
    }

    /**
     * Creates a new FileHandle and adds it to the cache, but does not open
     * the file.
     * @return the latched FileHandle.
     */
    private FileHandle addFileHandle(Long fileNum)
        throws IOException, DatabaseException {

        FileHandle fileHandle =
            new FileHandle(fileNum, getFileNumberString(fileNum));
        fileCache.add(fileNum, fileHandle);
        fileHandle.latch();
        return fileHandle;
    }

    private FileMode getAppropriateReadWriteMode() {
        if (useODSYNC) {
            return FileMode.READWRITE_ODSYNC_MODE;
        }
        return FileMode.READWRITE_MODE;
    }

    /**
     * Creates a new handle and opens it.  Does not add the handle to the
     * cache.
     */
    private FileHandle makeFileHandle(long fileNum, FileMode mode)
        throws FileNotFoundException, ChecksumException {

        FileHandle fileHandle =
            new FileHandle(fileNum, getFileNumberString(fileNum));
        openFileHandle(fileHandle, mode);
        return fileHandle;
    }

    /**
     * Opens the file for the given handle and initializes it.
     */
    private void openFileHandle(FileHandle fileHandle, FileMode mode)
        throws FileNotFoundException, ChecksumException {

        nFileOpens.increment();
        long fileNum = fileHandle.getFileNum();
        String[] fileNames = getFullFileNames(fileNum);
        RandomAccessFile newFile = null;
        String fileName = null;
        boolean success = false;
        try {

            /*
             * Open the file. Note that we are going to try a few names to open
             * this file -- we'll try for N.jdb, and if that doesn't exist and
             * we're configured to look for all types, we'll look for N.del.
             */
            FileNotFoundException FNFE = null;
            for (String fileName2 : fileNames) {
                fileName = fileName2;
                try {

                    /*
                     * RandomAccessFile.length() is not thread safe and
                     * side-effects the file pointer if interrupted in the
                     * middle.
                     */
                    newFile =
                        new RandomAccessFile(fileName, mode.getModeValue()) {
                            @Override
                            public synchronized long length()
                                throws IOException {

                                return super.length();
                            }
                        };
                    break;
                } catch (FileNotFoundException e) {
                    /* Save the first exception thrown. */
                    if (FNFE == null) {
                        FNFE = e;
                    }
                }
            }

            /*
             * If we didn't find the file or couldn't create it, rethrow the
             * exception.
             */
            if (newFile == null) {
        	assert FNFE != null;
                throw FNFE;
            }

            int logVersion = LogEntryType.LOG_VERSION;

            if (newFile.length() == 0) {

                /*
                 * If the file is empty, reinitialize it if we can. If not,
                 * send the file handle back up; the calling code will deal
                 * with the fact that there's nothing there.
                 */
                if (mode.isWritable()) {
                    /* An empty file, write a header. */
                    long lastLsn = DbLsn.longToLsn(perFileLastUsedLsn.remove
                       (Long.valueOf(fileNum - 1)));
                    long headerPrevOffset = 0;
                    if (lastLsn != DbLsn.NULL_LSN) {
                        headerPrevOffset = DbLsn.getFileOffset(lastLsn);
                    }
                    FileHeader fileHeader =
                        new FileHeader(fileNum, headerPrevOffset);
                    writeFileHeader(newFile, fileName, fileHeader, fileNum);
                }
            } else {
                /* A non-empty file, check the header */
                logVersion =
                    readAndValidateFileHeader(newFile, fileName, fileNum);
            }
            fileHandle.init(newFile, logVersion);
            success = true;
        } catch (FileNotFoundException e) {
            /* Handle at higher levels. */
            throw e;
        } catch (IOException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_READ,
                 "Couldn't open file " + fileName, e);
        } catch (DatabaseException e) {

            /*
             * Let this exception go as a checksum exception, so it sets the
             * run recovery state correctly.
             */
            closeFileInErrorCase(newFile);
            e.addErrorMessage("Couldn't open file " + fileName);
            throw e;
        } finally {
            if (!success) {
                closeFileInErrorCase(newFile);
            }
        }
    }

    /**
     * Close this file and eat any exceptions. Used in catch clauses.
     */
    private void closeFileInErrorCase(RandomAccessFile file) {
        try {
            if (file != null) {
                file.close();
            }
        } catch (Exception e) {
        }
    }

    /**
     * Read the given JE log file and validate the header.
     *
     * @throws DatabaseException if the file header isn't valid
     *
     * @return file header log version.
     */
    private int readAndValidateFileHeader(RandomAccessFile file,
                                          String fileName,
                                          long fileNum)
        throws ChecksumException, DatabaseException {

        /*
         * Read the file header from this file. It's always the first log
         * entry.
         *
         * The special UNKNOWN_FILE_HEADER_VERSION value is passed for reading
         * the entry header.  The actual log version is read as part of the
         * FileHeader entry.  [#16939]
         */
        LogManager logManager = envImpl.getLogManager();
        LogEntry headerEntry = logManager.getLogEntryAllowChecksumException
            (DbLsn.makeLsn(fileNum, 0), file,
             LogEntryType.UNKNOWN_FILE_HEADER_VERSION);
        FileHeader header = (FileHeader) headerEntry.getMainItem();
        return header.validate(envImpl, fileName, fileNum);
    }

    /**
     * Write a proper file header to the given file.
     */
    private void writeFileHeader(RandomAccessFile file,
                                 String fileName,
                                 FileHeader header,
                                 long fileNum)
        throws DatabaseException {

        /* Fail loudly if the environment is invalid. */
        envImpl.checkIfInvalid();

        /*
         * Fail silent if the environment is not open.
         */
        if (envImpl.mayNotWrite()) {
            return;
        }

        /* Write file header into this buffer in the usual log entry format. */
        LogEntry headerLogEntry =
            new FileHeaderEntry(LogEntryType.LOG_FILE_HEADER, header);
        ByteBuffer headerBuf = envImpl.getLogManager().
            putIntoBuffer(headerLogEntry,
                          0); // prevLogEntryOffset

        /* Write the buffer into the channel. */
        int bytesWritten;
        try {
            if (LOGWRITE_EXCEPTION_TESTING) {
                generateLogWriteException(file, headerBuf, 0, fileNum);
            }
            bytesWritten = writeToFile(file, headerBuf, 0, fileNum,
                                       false /*flushRequired*/);

            if (fileNum > savedCurrentFileNum) {

                /*
                 * Writing the new file header succeeded without an IOE.  This
                 * can not be undone in the event of another IOE (Out Of Disk
                 * Space) on the next write so update the saved LSN state with
                 * the new info. Do not update the nextAvailableLsn with a
                 * smaller (earlier) LSN in case there's already something in a
                 * buffer that is after the new header. [#15754]
                 */
                long lsnAfterHeader = DbLsn.makeLsn(fileNum, bytesWritten);
                if (DbLsn.compareTo(nextAvailableLsn, lsnAfterHeader) < 0) {
                    nextAvailableLsn = lsnAfterHeader;
                }

                lastUsedLsn = DbLsn.makeLsn(fileNum, bytesWritten);
                prevOffset = bytesWritten;
                forceNewFile = false;
                currentFileNum = fileNum;
                saveLastPosition();
            }
        } catch (ClosedChannelException e) {

            /*
             * The channel should never be closed. It may be closed because
             * of an interrupt received by another thread. See SR [#10463]
             */
            throw new ThreadInterruptedException
                (envImpl, "Channel closed, may be due to thread interrupt", e);
        } catch (IOException e) {
            /* Possibly an out of disk exception. */
            throw new LogWriteException(envImpl, e);
        }

        if (bytesWritten != headerLogEntry.getSize() +
            LogEntryHeader.MIN_HEADER_SIZE) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_INTEGRITY,
                 "File " + fileName +
                 " was created with an incomplete header. Only " +
                 bytesWritten + " bytes were written.");
        }
    }

    /**
     * @return the prevOffset field stored in the file header.
     */
    long getFileHeaderPrevOffset(long fileNum)
        throws ChecksumException, DatabaseException {

        try {
            LogEntry headerEntry =
                envImpl.getLogManager().getLogEntryAllowChecksumException
                    (DbLsn.makeLsn(fileNum, 0));
            FileHeader header = (FileHeader) headerEntry.getMainItem();
            return header.getLastEntryInPrevFileOffset();
        } catch (FileNotFoundException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_FILE_NOT_FOUND, e);
        }
    }

    /*
     * Support for writing new log entries
     */

    /**
     * @return the file offset of the last LSN that was used. For constructing
     * the headers of log entries. If the last LSN that was used was in a
     * previous file, or this is the very first LSN of the whole system, return
     * 0.
     */
    long getPrevEntryOffset() {
        return prevOffset;
    }

    /**
     * Increase the current log position by "size" bytes. Move the prevOffset
     * pointer along.
     *
     * @param size is an unsigned int
     * @return true if we flipped to the next log file.
     */
    boolean bumpLsn(long size) {

        /* Save copy of initial LSN state. */
        saveLastPosition();

        boolean flippedFiles = false;

        if (forceNewFile ||
            (DbLsn.getFileOffset(nextAvailableLsn) + size) > maxFileSize) {

            forceNewFile = false;

            /* Move to another file. */
            currentFileNum++;

            /* Remember the last used LSN of the previous file. */
            if (lastUsedLsn != DbLsn.NULL_LSN) {
                perFileLastUsedLsn.put
                    (Long.valueOf(DbLsn.getFileNumber(lastUsedLsn)),
                     Long.valueOf(lastUsedLsn));
            }
            prevOffset = 0;
            lastUsedLsn =
                DbLsn.makeLsn(currentFileNum, firstLogEntryOffset());
            flippedFiles = true;
        } else {
            if (lastUsedLsn == DbLsn.NULL_LSN) {
                prevOffset = 0;
            } else {
                prevOffset = DbLsn.getFileOffset(lastUsedLsn);
            }
            lastUsedLsn = nextAvailableLsn;
        }
        nextAvailableLsn =
            DbLsn.makeLsn(DbLsn.getFileNumber(lastUsedLsn),
                          (DbLsn.getFileOffset(lastUsedLsn) + size));

        return flippedFiles;
    }

    /**
     * Write out a log buffer to the file.
     * @param fullBuffer buffer to write
     * @param flushRequired true if this write can not be queued on the
     * Write Queue.
     */
    void writeLogBuffer(LogBuffer fullBuffer, boolean flushRequired)
        throws DatabaseException {

        /* Fail loudly if the environment is invalid. */
        envImpl.checkIfInvalid();

        /*
         * Fail silent if the environment is not open.
         */
        if (envImpl.mayNotWrite()) {
            return;
        }

        /* Use the LSN to figure out what file to write this buffer to. */
        long firstLsn = fullBuffer.getFirstLsn();

        /*
         * Is there anything in this write buffer? We could have been called by
         * the environment shutdown, and nothing is actually in the buffer.
         */
        if (firstLsn != DbLsn.NULL_LSN) {

            RandomAccessFile file =
                endOfLog.getWritableFile(DbLsn.getFileNumber(firstLsn), true);
            ByteBuffer data = fullBuffer.getDataBuffer();

            try {

                /*
                 * Check that we do not overwrite unless the file only contains
                 * a header [#11915] [#12616].
                 */
                assert fullBuffer.getRewriteAllowed() ||
                    (DbLsn.getFileOffset(firstLsn) >= file.length() ||
                     file.length() == firstLogEntryOffset()) :
                        "FileManager would overwrite non-empty file 0x" +
                        Long.toHexString(DbLsn.getFileNumber(firstLsn)) +
                        " lsnOffset=0x" +
                        Long.toHexString(DbLsn.getFileOffset(firstLsn)) +
                        " fileLength=0x" +
                        Long.toHexString(file.length());

                if (IO_EXCEPTION_TESTING_ON_WRITE) {
                    throw new IOException("generated for testing (write)");
                }
                if (LOGWRITE_EXCEPTION_TESTING) {
                    generateLogWriteException
                        (file, data, DbLsn.getFileOffset(firstLsn),
                         DbLsn.getFileNumber(firstLsn));
                }
                writeToFile(file, data, DbLsn.getFileOffset(firstLsn),
                            DbLsn.getFileNumber(firstLsn),
                            flushRequired);
            } catch (ClosedChannelException e) {

                /*
                 * The file should never be closed. It may be closed because
                 * of an interrupt received by another thread. See SR [#10463].
                 */
                throw new ThreadInterruptedException
                    (envImpl, "File closed, may be due to thread interrupt",
                     e);
            } catch (IOException e) {

                if (!continueAfterWriteException()) {
                    throw new LogWriteException(envImpl, e);
                }

                /*
                 * Possibly an out of disk exception, but java.io will only
                 * tell us IOException with no indication of whether it's out
                 * of disk or something else. Better support may exist in
                 * Java6.
                 *
                 * Since we can't tell what sectors were actually written to
                 * disk, we need to change any commit records that might have
                 * made it out to disk to abort records. If they made it to
                 * disk on the write, then rewriting should allow them to be
                 * rewritten. See [11271].
                 *
                 * Rewriting committed transactions in replication is highly
                 * problematic, and can lead to divergence between the replica
                 * and master. If this path is re-enabled, we must assess its
                 * impact in replication, since the log entries may already
                 * be sent to other nodes.
                 */
                abortCommittedTxns(data);
                try {
                    if (IO_EXCEPTION_TESTING_ON_WRITE) {
                        throw new IOException
                            ("generated for testing (write)");
                    }
                    writeToFile(file, data, DbLsn.getFileOffset(firstLsn),
                                DbLsn.getFileNumber(firstLsn), flushRequired);
                } catch (IOException e2) {
                    fullBuffer.setRewriteAllowed();
                    /* Use an exception that does not invalidate the env. */
                    throw EnvironmentFailureException.unexpectedException(e2);
                }
            }

            assert EnvironmentImpl.maybeForceYield();
        }
    }

    /**
     * Write a buffer to a file at a given offset.
     */
    private int writeToFile(RandomAccessFile file,
                            ByteBuffer data,
                            long destOffset,
                            long fileNum,
                            boolean flushRequired)
        throws IOException, DatabaseException {

        int totalBytesWritten = 0;

        bumpWriteCount("write");

        int pos = data.position();
        int size = data.limit() - pos;

        if (lastFileNumberTouched == fileNum &&
            (Math.abs(destOffset - lastFileTouchedOffset) <
             ADJACENT_TRACK_SEEK_DELTA)) {
            nSequentialWrites.increment();
            nSequentialWriteBytes.add(size);
        } else {
            nRandomWrites.increment();
            nRandomWriteBytes.add(size);
        }

        if (VERIFY_CHECKSUMS) {
            verifyChecksums(data, destOffset, "pre-write");
        }

        /*
         * Perform a RandomAccessFile write and update the buffer position.
         * ByteBuffer.array() is safe to use since all non-direct ByteBuffers
         * have a backing array.
         *
         * Synchronization on the file object is needed because two threads may
         * call seek() on the same file object.
         *
         * If the Write Queue is enabled, attempt to get the fsync latch.  If
         * we can't get it, then an fsync or write is in progress and we'd
         * block anyway.  In that case, queue the write operation.
         */
        boolean fsyncLatchAcquired =
            endOfLog.fsyncFileSynchronizer.tryLock();
        boolean enqueueSuccess = false;
        if (!fsyncLatchAcquired &&
            useWriteQueue &&
            !flushRequired) {
            enqueueSuccess =
                endOfLog.enqueueWrite(fileNum, data.array(), destOffset,
                                      pos + data.arrayOffset(), size);
        }

        if (!enqueueSuccess) {
            if (!fsyncLatchAcquired) {
                endOfLog.fsyncFileSynchronizer.lock();
            }
            try {
                if (useWriteQueue) {
                    endOfLog.dequeuePendingWrites1();
                }

                synchronized (file) {
                    file.seek(destOffset);
                    file.write
                        (data.array(), pos + data.arrayOffset(), size);
                    if (VERIFY_CHECKSUMS) {
                        file.seek(destOffset);
                        file.read
                            (data.array(), pos + data.arrayOffset(), size);
                        verifyChecksums(data, destOffset, "post-write");
                    }
                }
            } finally {
                endOfLog.fsyncFileSynchronizer.unlock();
            }
        }
        data.position(pos + size);
        totalBytesWritten = size;

        lastFileNumberTouched = fileNum;
        lastFileTouchedOffset = destOffset + size;
        return totalBytesWritten;
    }

    private void bumpWriteCount(final String debugMsg)
        throws IOException {

        if (DEBUG) {
            System.out.println("Write: " + WRITE_COUNT + " " + debugMsg);
        }

        if (++WRITE_COUNT >= STOP_ON_WRITE_COUNT &&
            WRITE_COUNT < (STOP_ON_WRITE_COUNT + N_BAD_WRITES)) {
            if (THROW_ON_WRITE) {
                throw new IOException
                    ("IOException generated for testing: " + WRITE_COUNT +
                     " " + debugMsg);
            }
            Runtime.getRuntime().halt(0xff);
        }
    }

    /**
     * Read a buffer from a file at a given offset. We know that the desired
     * data exists in this file. There's no need to incur extra costs
     * such as checks of the file length, nor to return status as to whether
     * this file contains the data.
     */
    void readFromFile(RandomAccessFile file,
                      ByteBuffer readBuffer,
                      long offset,
                      long fileNo)
        throws DatabaseException {
        readFromFile(file, readBuffer, offset, fileNo,
                     true /* dataKnownToBeInFile */);
    }

    /**
     * Read a buffer from a file at a given offset.
     *
     * @return true if the read buffer is filled, false, if there is nothing
     * left in the file to read
     */
    boolean readFromFile(RandomAccessFile file,
                         ByteBuffer readBuffer,
                         long offset,
                         long fileNo,
                         boolean dataKnownToBeInFile)
        throws DatabaseException {

        /*
         * All IOExceptions on read turn into EnvironmentFailureExceptions
         * [#15768].
         */
        try {

            /*
             * Check if there's a pending write(s) in the write queue for this
             * fileNo/offset and if so, use it to fulfill this read request.
             */
            if (useWriteQueue &&
                endOfLog.checkWriteCache(readBuffer, offset, fileNo)) {
                return true;
            }

            /*
             * Nothing queued, all data for this file must be in the file.
             * Note that there's no synchronization between the check of the
             * write queue above, and this check of file length. It's possible
             * that a newly written log entry could show up between the
             * statements, and enter the write queue just after we finish the
             * check.
             *
             * Because of this, callers of this method must abide by one of
             * three conditions:
             * 1. They guarantee that the attempt to read a chunk of new data
             *   comes after the new data has been logged by the LogManager.
             * 2. The files are quiescent when the read is going on.
             * 3. The caller is sure the data is in this file.
             *
             * The replication feeder reader abides by (1) while all other file
             * readers abide by (2). Callers which are fetching specific log
             * entries fall under (3).
             */
            boolean readThisFile = true;
            if (!dataKnownToBeInFile) {
                /*
                 * Callers who are not sure whether the desired data is in this
                 * file or the next incur the cost of a check of file.length(),
                 * which is a system call.
                 */
                readThisFile = (offset < file.length());
            }

            if (readThisFile) {
                readFromFileInternal(file, readBuffer, offset, fileNo);
                return true;
            }

            return false;
        } catch (ClosedChannelException e) {

            /*
             * The channel should never be closed. It may be closed because
             * of an interrupt received by another thread. See SR [#10463]
             */
            throw new ThreadInterruptedException
                (envImpl, "Channel closed, may be due to thread interrupt", e);
        } catch (IOException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_READ, e);
        }
    }

    private void readFromFileInternal(RandomAccessFile file,
                                      ByteBuffer readBuffer,
                                      long offset,
                                      long fileNum)
        throws IOException {

        /*
         * Perform a RandomAccessFile read and update the buffer position.
         * ByteBuffer.array() is safe to use since all non-direct ByteBuffers
         * have a backing array.  Synchronization on the file object is needed
         * because two threads may call seek() on the same file object.
         */
        synchronized (file) {
            int pos = readBuffer.position();
            int size = readBuffer.limit() - pos;

            if (lastFileNumberTouched == fileNum &&
                (Math.abs(offset - lastFileTouchedOffset) <
                 ADJACENT_TRACK_SEEK_DELTA)) {
                nSequentialReads.increment();
                nSequentialReadBytes.add(size);
            } else {
                nRandomReads.increment();
                nRandomReadBytes.add(size);
            }

            file.seek(offset);
            if (IO_EXCEPTION_TESTING_ON_READ) {
                throw new IOException("generated for testing (read)");
            }
            int bytesRead = file.read(readBuffer.array(),
                                      pos + readBuffer.arrayOffset(),
                                      size);
            if (bytesRead > 0) {
                readBuffer.position(pos + bytesRead);
            }

            lastFileNumberTouched = fileNum;
            lastFileTouchedOffset = offset + bytesRead;
        }
    }

    private void verifyChecksums(ByteBuffer entryBuffer,
                                 long lsn,
                                 String comment) {
        int curPos = entryBuffer.position();
        try {
            while (entryBuffer.remaining() > 0) {
                int recStartPos = entryBuffer.position();
                /* Write buffer contains current log version entries. */
                LogEntryHeader header =
                    new LogEntryHeader(entryBuffer, LogEntryType.LOG_VERSION);
                verifyChecksum(entryBuffer, header, lsn, comment);
                entryBuffer.position(recStartPos + header.getSize() +
                                     header.getItemSize());
            }
        } catch (ChecksumException e) {
            System.err.println("ChecksumException: (" + comment + ") " + e);
            System.err.println("start stack trace");
            e.printStackTrace(System.err);
            System.err.println("end stack trace");
        }
        entryBuffer.position(curPos);
    }

    private void verifyChecksum(ByteBuffer entryBuffer,
                                LogEntryHeader header,
                                long lsn,
                                String comment)
        throws ChecksumException {

        ChecksumValidator validator = null;
        /* Add header to checksum bytes */
        validator = new ChecksumValidator();
        int headerSizeMinusChecksum = header.getSizeMinusChecksum();
        int itemStart = entryBuffer.position();
        entryBuffer.position(itemStart - headerSizeMinusChecksum);
        validator.update(entryBuffer, headerSizeMinusChecksum);
        entryBuffer.position(itemStart);

        /*
         * Now that we know the size, read the rest of the entry if the first
         * read didn't get enough.
         */
        int itemSize = header.getItemSize();
        if (entryBuffer.remaining() < itemSize) {
            System.err.println("Couldn't verify checksum (" + comment + ")");
            return;
        }

        /*
         * Do entry validation. Run checksum before checking the entry
         * type, it will be the more encompassing error.
         */
        validator.update(entryBuffer, itemSize);
        validator.validate(header.getChecksum(), lsn);
    }

    /*
     * Iterate through a buffer looking for commit records.  Change all commit
     * records to abort records.
     */
    private void abortCommittedTxns(ByteBuffer data)
        throws DatabaseException {

        final byte commitType = LogEntryType.LOG_TXN_COMMIT.getTypeNum();
        data.position(0);

        while (data.remaining() > 0) {
            int recStartPos = data.position();
            LogEntryHeader header;
            try {
                /* Write buffer contains current log version entries. */
                header = new LogEntryHeader(data, LogEntryType.LOG_VERSION);
            } catch (ChecksumException e) {
                throw EnvironmentFailureException.unexpectedException(e);
            }
            if (header.getType() == commitType) {
                /* Change the log entry type, and recalculate the checksum. */
                header.convertCommitToAbort(data);
            }
            data.position(recStartPos + header.getSize() +
                          header.getItemSize());
        }
        data.position(0);
    }

    /**
     * FSync the end of the log.
     */
    void syncLogEnd()
        throws DatabaseException {

        try {
            endOfLog.force();
        } catch (IOException e) {
            throw new LogWriteException
                (envImpl, "IOException during fsync", e);
        }
    }

    /**
     * Sync the end of the log, close off this log file. Should only be called
     * under the log write latch.
     */
    void syncLogEndAndFinishFile()
        throws DatabaseException, IOException {

        if (syncAtFileEnd) {
            syncLogEnd();
        }
        endOfLog.close();
    }

    /**
     * Flush a file using the group sync mechanism, trying to amortize off
     * other syncs.
     */
    void groupSync()
        throws DatabaseException {

        syncManager.fsync();
    }

    /**
     * Close all file handles and empty the cache.
     */
    public void clear()
        throws IOException, DatabaseException {

        if (EnvironmentImpl.getFairLatches()) {
            fileCacheLatch.acquire();
            try {
                fileCache.clear();
            } finally {
                fileCacheLatch.release();
            }
        } else {
            synchronized (fileCacheLatch) {
                fileCache.clear();
            }
        }

        endOfLog.close();
    }

    /**
     * Clear the file lock.
     */
    public void close()
        throws IOException {

        if (envLock != null) {
            envLock.release();
        }

        if (exclLock != null) {
            exclLock.release();
        }

        if (channel != null) {
            channel.close();
        }

        if (lockFile != null) {
            lockFile.close();
            lockFile = null;
        }
    }

    /**
     * Lock the environment.  Return true if the lock was acquired.  If
     * exclusive is false, then this implements a single writer, multiple
     * reader lock.  If exclusive is true, then implement an exclusive lock.
     *
     * There is a lock file and there are two regions of the lock file: byte 0,
     * and byte 1.  Byte 0 is the exclusive writer process area of the lock
     * file.  If an environment is opened for write, then it attempts to take
     * an exclusive write lock on byte 0.  Byte 1 is the shared reader process
     * area of the lock file.  If an environment is opened for read-only, then
     * it attempts to take a shared lock on byte 1.  This is how we implement
     * single writer, multi reader semantics.
     *
     * The cleaner, each time it is invoked, attempts to take an exclusive lock
     * on byte 1.  The owning process already either has an exclusive lock on
     * byte 0, or a shared lock on byte 1.  This will necessarily conflict with
     * any shared locks on byte 1, even if it's in the same process and there
     * are no other holders of that shared lock.  So if there is only one
     * read-only process, it will have byte 1 for shared access, and the
     * cleaner can not run in it because it will attempt to get an exclusive
     * lock on byte 1 (which is already locked for shared access by itself).
     * If a write process comes along and tries to run the cleaner, it will
     * attempt to get an exclusive lock on byte 1.  If there are no other
     * reader processes (with shared locks on byte 1), and no other writers
     * (which are running cleaners on with exclusive locks on byte 1), then the
     * cleaner will run.
     */
    public boolean lockEnvironment(boolean rdOnly, boolean exclusive) {
        try {
            if (checkEnvHomePermissions(rdOnly)) {
                return true;
            }

            if (lockFile == null) {
                lockFile =
                    new RandomAccessFile
                    (new File(dbEnvHome, LOCK_FILE),
                     FileMode.READWRITE_MODE.getModeValue());
            }

            channel = lockFile.getChannel();

            try {
                if (exclusive) {

                    /*
                     * To lock exclusive, must have exclusive on
                     * shared reader area (byte 1).
                     */
                    exclLock = channel.tryLock(1, 1, false);
                    if (exclLock == null) {
                        return false;
                    }
                    return true;
                }
                if (rdOnly) {
                    envLock = channel.tryLock(1, 1, true);
                } else {
                    envLock = channel.tryLock(0, 1, false);
                }
                if (envLock == null) {
                    return false;
                }
                return true;
            } catch (OverlappingFileLockException e) {
                return false;
            }
        } catch (IOException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_INTEGRITY, e);
        }
    }

    public void releaseExclusiveLock()
        throws DatabaseException {

        try {
            if (exclLock != null) {
                exclLock.release();
            }
        } catch (IOException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_INTEGRITY, e);
        }
    }

    /**
     * Ensure that if the environment home dir is on readonly media or in a
     * readonly directory that the environment has been opened for readonly
     * access.
     *
     * @return true if the environment home dir is readonly.
     *
     * @throws IllegalArgumentException via Environment ctor
     */
    public boolean checkEnvHomePermissions(boolean rdOnly)
        throws DatabaseException {

        boolean envDirIsReadOnly = !dbEnvHome.canWrite();
        if (envDirIsReadOnly && !rdOnly) {

            /*
             * Use the absolute path in the exception message, to
             * make a mis-specified relative path problem more obvious.
             */
            throw new IllegalArgumentException
                ("The Environment directory " +
                 dbEnvHome.getAbsolutePath() +
                 " is not writable, but the " +
                 "Environment was opened for read-write access.");
        }

        return envDirIsReadOnly;
    }

    /**
     * Truncate a log at this position. Used by recovery to a timestamp
     * utilities and by recovery to set the end-of-log position.
     *
     * <p>This method forces a new log file to be written next, if the last
     * file (the file truncated to) has an old version in its header.  This
     * ensures that when the log is opened by an old version of JE, a version
     * incompatibility will be detected.  [#11243]</p>
     */
    public void truncateLog(long fileNum, long offset)
        throws IOException, DatabaseException  {

        try {
            FileHandle handle =
                makeFileHandle(fileNum, getAppropriateReadWriteMode());
            RandomAccessFile file = handle.getFile();

            try {
                file.getChannel().truncate(offset);
            } finally {
                file.close();
            }

            if (handle.isOldHeaderVersion()) {
                forceNewFile = true;
            }
        } catch (ChecksumException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_CHECKSUM, e);
        }
    }

    /**
     * Mark the specified log entries as invisible and obsolete. The entries
     * are written here, but are fsync'ed later. If there is any problem or
     * exception during the setting, the method will throw an
     * EnvironmentFailureException.
     *
     * These changes are made directly to the file, but recently logged log
     * entries may also be resident in the log buffers. The caller must take
     * care to call LogManager.flush() before this method, to ensure that all
     * entries are on disk.
     *
     * In addition, we must ensure that after this step, the affected log
     * entries will only be read via a FileReader, and will not be faulted in
     * by the LogManager. Entries may be present in the log and in the log
     * buffers, but only the on disk version is modified by this method. The
     * LogManager can read directly from the log buffers and may read the
     * incorrect, non-invisible version of the log entry, rather than the
     * invisible version from the file. This should not be an issue, because
     * invisible log entries should be detached from the in-memory tree before
     * they are made invisible.
     *
     * @param fileNum target file.
     * @param lsns The list of LSNs to make invisible, must be sorted in
     * ascending order.
     */
    public void makeInvisible(long fileNum, List<Long> lsns) {
        if (lsns.size() == 0) {
            return;
        }

        /* Open this file. */
        FileHandle handle = null;
        try {

            /*
             * Note that we are getting a new, non-cached file handle for
             * specific use by this method.
             */
            handle = makeFileHandle(fileNum, getAppropriateReadWriteMode());
        } catch (ChecksumException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_CHECKSUM,
                 "Opening file " + fileNum +  " for invisible marking ",
                 e);
        } catch (FileNotFoundException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_FILE_NOT_FOUND,
                 "Opening file " + fileNum +  " for invisible marking ",
                 e);
        }
        RandomAccessFile file = handle.getFile();

        /* Set the invisible bit for each entry. */
        try {
            for (Long lsn : lsns) {
                if (DbLsn.getFileNumber(lsn) != fileNum) {

                    /*
                     * This failure will not invalidate the environment right
                     * away. But since it causes replication syncup to fail,
                     * the environment will shutdown, which is the effect we
                     * want.
                     */
                    throw new EnvironmentFailureException
                        (envImpl,
                         EnvironmentFailureReason.UNEXPECTED_STATE,
                         "LSN of " + DbLsn.getNoFormatString(lsn) +
                         " did not match file number" + fileNum);
                }

                int entryFlagsOffset = (int) (DbLsn.getFileOffset(lsn) +
                                              LogEntryHeader.FLAGS_OFFSET);
                file.seek(entryFlagsOffset);
                byte flags = file.readByte();
                byte newFlags = LogEntryHeader.makeInvisible(flags);
                file.seek(entryFlagsOffset);
                file.writeByte(newFlags);
            }
        } catch (IOException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_WRITE,
                 "Flipping invisibility in file " + fileNum,
                 e);
        } finally {
            /*
             * Just close the file. Fsyncs will be done later on, in the hope
             * that the OS has already synced asynchronously.
             */
            try {
                file.close();
            } catch (IOException e) {
                throw new EnvironmentFailureException
                    (envImpl,
                     EnvironmentFailureReason.LOG_WRITE,
                     "Closing after invisibility cloaking: file " + fileNum,
                     e);
            }
        }
    }

    /**
     * Fsync this set of log files. Used for replication syncup rollback.
     */
    public void force(Set<Long> fileNums) {
        for (long fileNum : fileNums) {
            RandomAccessFile file = null;
            try {
                FileHandle handle =
                    makeFileHandle(fileNum,
                                   getAppropriateReadWriteMode());
                file = handle.getFile();
                file.getChannel().force(false);
                nLogFSyncs.increment();
            } catch (FileNotFoundException e) {
                throw new EnvironmentFailureException
                    (envImpl,
                     EnvironmentFailureReason.LOG_FILE_NOT_FOUND,
                     "Invisible fsyncing file " + fileNum,
                     e);
            } catch (ChecksumException e) {
                throw new EnvironmentFailureException
                    (envImpl,
                     EnvironmentFailureReason.LOG_CHECKSUM,
                     "Invisible fsyncing file " + fileNum,
                     e);
            } catch (IOException e) {
                throw new EnvironmentFailureException
                    (envImpl,
                     EnvironmentFailureReason.LOG_WRITE,
                     "Invisible fsyncing file " + fileNum,
                     e);
            } finally {
                if (file != null) {
                    try {
                        file.close();
                    } catch (IOException e) {
                        throw new EnvironmentFailureException
                            (envImpl,
                             EnvironmentFailureReason.LOG_WRITE,
                             "Invisible fsyncing file " + fileNum,
                             e);
                    }
                }
            }
        }
    }

    /**
     * Set the flag that causes a new file to be written before the next write.
     */
    void forceNewLogFile() {
        forceNewFile = true;
    }

    /**
     * Return the offset of the first log entry after the file header.
     */

    /**
     * @return the size in bytes of the file header log entry.
     */
    public static int firstLogEntryOffset() {
        return FileHeader.entrySize() + LogEntryHeader.MIN_HEADER_SIZE;
    }

    /**
     * Return the next available LSN in the log. Note that this is
     * unsynchronized, so is only valid as an approximation of log size.
     */
    public long getNextLsn() {
        return nextAvailableLsn;
    }

    /**
     * Return the last allocated LSN in the log. Note that this is
     * unsynchronized, so if it is called outside the log write latch it is
     * only valid as an approximation of log size.
     */
    public long getLastUsedLsn() {
        return lastUsedLsn;
    }

    /*
     * fsync stats.
     */
    public long getNFSyncs() {
        return syncManager.getNFSyncs();
    }

    public long getNFSyncRequests() {
        return syncManager.getNFSyncRequests();
    }

    public long getNFSyncTimeouts() {
        return syncManager.getNTimeouts();
    }

    StatGroup loadStats(StatsConfig config) {
        nOpenFiles.set(fileCache.size());
        StatGroup copyStats = stats.cloneGroup(config.getClear());
        copyStats.addAll(syncManager.loadStats(config));

        return copyStats;
    }

    /*
     * Unit test support
     */

    /*
     * @return ids of files in cache
     */
    Set<Long> getCacheKeys() {
        return fileCache.getCacheKeys();
    }

    /**
     * Clear a file out of the file cache regardless of mode type.
     */
    private void clearFileCache(long fileNum)
        throws IOException, DatabaseException {

        if (EnvironmentImpl.getFairLatches()) {
            fileCacheLatch.acquire();
            try {
                fileCache.remove(fileNum);
            } finally {
                fileCacheLatch.release();
            }
        } else {
            synchronized (fileCacheLatch) {
                fileCache.remove(fileNum);
            }
        }
    }

    /*
     * The file cache keeps N RandomAccessFile objects cached for file
     * access. The cache consists of two parts: a Hashtable that doesn't
     * require extra synchronization, for the most common access, and a linked
     * list of files to support cache administration. Looking up a file from
     * the hash table doesn't require extra latching, but adding or deleting a
     * file does.
     */
    private static class FileCache {
        private final Map<Long, FileHandle> fileMap;            // Long->file
        private final List<Long> fileList;    // list of file numbers
        private final int fileCacheSize;

        FileCache(DbConfigManager configManager) {

            /*
             * A fileMap maps the file number to FileHandles (RandomAccessFile,
             * latch). The fileList is a list of Longs to determine which files
             * to eject out of the file cache if it's too small.
             */
            fileMap = new Hashtable<Long, FileHandle>();
            fileList = new LinkedList<Long>();
            fileCacheSize =
                configManager.getInt(EnvironmentParams.LOG_FILE_CACHE_SIZE);
        }

        private FileHandle get(Long fileId) {
            return fileMap.get(fileId);
        }

        private void add(Long fileId, FileHandle fileHandle)
            throws IOException, DatabaseException {

            /*
             * Does the cache have any room or do we have to evict?  Hunt down
             * the file list for an unused file. Note that the file cache might
             * actually grow past the prescribed size if there is nothing
             * evictable. Should we try to shrink the file cache? Presently if
             * it grows, it doesn't shrink.
             */
            if (fileList.size() >= fileCacheSize) {
                Iterator<Long> iter = fileList.iterator();
                while (iter.hasNext()) {
                    Long evictId = iter.next();
                    FileHandle evictTarget = fileMap.get(evictId);

                    /*
                     * Try to latch. If latchNoWait returns false, then another
                     * thread owns this latch. Note that a thread that's trying
                     * to get a new file handle should never already own the
                     * latch on another file handle, because these latches are
                     * meant to be short lived and only held over the i/o out
                     * of the file.
                     */
                    if (evictTarget.latchNoWait()) {
                        try {
                            fileMap.remove(evictId);
                            iter.remove();
                            evictTarget.close();
                        } finally {
                            evictTarget.release();
                        }
                        break;
                    }
                }
            }

            /*
             * We've done our best to evict. Add the file the the cache now
             * whether or not we did evict.
             */
            fileList.add(fileId);
            fileMap.put(fileId, fileHandle);
        }

        /**
         * Take any file handles corresponding to this file name out of the
         * cache. A file handle could be there twice, in rd only and in r/w
         * mode.
         */
        private void remove(long fileNum)
            throws IOException, DatabaseException {

            Iterator<Long> iter = fileList.iterator();
            while (iter.hasNext()) {
                Long evictId = iter.next();
                if (evictId.longValue() == fileNum) {
                    FileHandle evictTarget = fileMap.get(evictId);
                    try {
                        evictTarget.latch();
                        fileMap.remove(evictId);
                        iter.remove();
                        evictTarget.close();
                    } finally {
                        evictTarget.release();
                    }
                }
            }
        }

        private void clear()
            throws IOException, DatabaseException {

            Iterator<FileHandle> iter = fileMap.values().iterator();
            while (iter.hasNext()) {
                FileHandle fileHandle = iter.next();
                try {
                    fileHandle.latch();
                    fileHandle.close();
                    iter.remove();
                } finally {
                    fileHandle.release();
                }
            }
            fileMap.clear();
            fileList.clear();
        }

        private Set<Long> getCacheKeys() {
            return fileMap.keySet();
        }

        private int size() {
            return fileMap.size();
        }
    }

    /**
     * The LogEndFileDescriptor is used to write and fsync the end of the log.
     * Because the JE log is append only, there is only one logical R/W file
     * descriptor for the whole environment. This class actually implements two
     * RandomAccessFile instances, one for writing and one for fsyncing, so the
     * two types of operations don't block each other.
     *
     * The write file descriptor is considered the master.  Manipulation of
     * this class is done under the log write latch. Here's an explanation of
     * why the log write latch is sufficient to safeguard all operations.
     *
     * There are two types of callers who may use this file descriptor: the
     * thread that is currently writing to the end of the log and any threads
     * that are fsyncing on behalf of the FSyncManager.
     *
     * The writing thread appends data to the file and fsyncs the file when we
     * flip over to a new log file.  The file is only instantiated at the point
     * that it must do so -- which is either when the first fsync is required
     * by JE or when the log file is full and we flip files.  Therefore, the
     * writing thread has two actions that change this descriptor -- we
     * initialize the file descriptor for the given log file at the first write
     * to the file, and we close the file descriptor when the log file is full.
     * Therefore is a period when there is no log descriptor -- when we have
     * not yet written a log buffer into a given log file.
     *
     * The fsyncing threads ask for the log end file descriptor asynchronously,
     * but will never modify it.  These threads may arrive at the point when
     * the file descriptor is null, and therefore skip their fysnc, but that is
     * fine because it means a writing thread already flipped that target file
     * and has moved on to the next file.
     *
     * Time     Activity
     * 10       thread 1 writes log entry A into file 0x0, issues fsync
     *          outside of log write latch, yields the processor
     * 20       thread 2 writes log entry B, piggybacks off thread 1
     * 30       thread 3 writes log entry C, but no room left in that file,
     *          so it flips the log, and fsyncs file 0x0, all under the log
     *          write latch. It nulls out endOfLogRWFile, moves onto file
     *          0x1, but doesn't create the file yet.
     * 40       thread 1 finally comes along, but endOfLogRWFile is null--
     *          no need to fsync in that case, 0x0 got fsynced.
     *
     * If a write is attempted and an fsync is already in progress, then the
     * information pertaining to the data to be written (data, offset, length)
     * is saved away in the "queuedWrites" array.  When the fsync completes,
     * the queuedWrites buffer is emptied.  This ensures that writes continue
     * to execute on file systems which block all IO calls during an fsync()
     * call (e.g. ext3).
     */
    class LogEndFileDescriptor {
        private RandomAccessFile endOfLogRWFile = null;
        private RandomAccessFile endOfLogSyncFile = null;
        private final ReentrantLock fsyncFileSynchronizer = new ReentrantLock();

        /*
         * Holds all data for writes which have been queued due to their
         * being blocked by an fsync when the original write was attempted.
         * The next thread to execute an fsync or write will execute any
         * queued writes in this buffer.
         * Latch order is fsyncFileSynchronizer, followed by the queuedWrites
         * mutex [ synchronized (queuedWrites) {} ].
         *
         * Default protection for unit tests.
         */
        private final byte[] queuedWrites =
            useWriteQueue ? new byte[writeQueueSize] : null;

        /* Current position in the queuedWrites array. */
        private int queuedWritesPosition = 0;

        /* The starting offset on disk of the first byte in queuedWrites. */
        private long qwStartingOffset;

        /* The file number that the queuedWrites are destined for. */
        private long qwFileNum = -1;

        /* For unit tests. */
        void setQueueFileNum(final long qwFileNum) {
            this.qwFileNum = qwFileNum;
        }

        /*
         * Check if fileNo/offset is present in queuedWrites, and if so, fill
         * readBuffer with those bytes.  We theorize that this is needed
         * because HA will be reading at the very end of the log and those
         * writes, if enqueued, may no longer be in LogBuffers in the
         * LogBufferPool.  This might happen in the case of lots of concurrent
         * non-synchronous writes (with synchronous commits) which become
         * enqueued in the queuedWrites cache, but cycle out of the LBP.  In
         * general, using synchronous commits with HA is a bad idea.
         *
         * Default protection for unit tests.
         * @return true if more data was available. If so, the read buffer
         * will be filled up.
         */
        /* private */
        boolean checkWriteCache(final ByteBuffer readBuffer,
                                final long requestedOffset,
                                final long fileNum) {

            int pos = readBuffer.position();
            int targetBufSize = readBuffer.limit() - pos;
            synchronized (queuedWrites) {
                if (qwFileNum != fileNum) {
                    return false;
                }

                if (queuedWritesPosition == 0) {
                    return false;
                }

                if (requestedOffset < qwStartingOffset ||
                    (qwStartingOffset + queuedWritesPosition) <=
                    requestedOffset) {
                    return false;
                }

                /* We have the bytes available. */
                int nBytesToCopy = (int)
                    (queuedWritesPosition -
                     (requestedOffset - qwStartingOffset));
                nBytesToCopy = Math.min(nBytesToCopy, targetBufSize);
                readBuffer.put(queuedWrites,
                               (int) (requestedOffset - qwStartingOffset),
                               nBytesToCopy);
                nBytesReadFromWriteQueue.add(nBytesToCopy);
                nReadsFromWriteQueue.increment();
                return true;
            }
        }

        /*
         * Enqueue a blocked write call for later execution by the next thread
         * to do either an fsync or write call. fsyncFileSynchronizer is not
         * held when this is called.
         *
         * Default protection for unit tests.
         */
        /* private */
        boolean enqueueWrite(final long fileNum,
                             final byte[] data,
                             final long destOffset,
                             final int arrayOffset,
                             final int size)
            throws DatabaseException {

            assert !fsyncFileSynchronizer.isHeldByCurrentThread();

            for (int i = 0; i < 2; i++) {
                try {
                    enqueueWrite1(fileNum, data, destOffset,
                                  arrayOffset, size);
                    return true;
                } catch (RelatchRequiredException RE) {
                    dequeuePendingWrites();
                }
            }

            /* Give up after two tries. */
            nWriteQueueOverflowFailures.increment();
            return false;
        }

        private void enqueueWrite1(final long fileNum,
                                   final byte[] data,
                                   final long destOffset,
                                   final int arrayOffset,
                                   final int size)
            throws RelatchRequiredException, DatabaseException {

            /*
             * The queuedWrites queue only ever holds writes for a single file.
             *
             * This check is safe because qwFileNum can only ever change inside
             * enqueueWrite which can only ever be called while the Log Write
             * Latch is held.
             *
             * NOTE: We believe the commented out second condition is safe
             * to add to the code if we ever see contention with this call to
             * dequeuePendingWrites against an fsync.  Here is the reasoning:
             *
             * queuedWritesPosition is changed in two places: (1) enqueueWrite1
             * where it is incremented, and (2) dequeuePendingWrites1 where it
             * is zeroed. Both of these places are proected by the queuedWrites
             * mutex.  The zero'ing (2) will only make the dequeue unnecessary
             * so the extra commented out check below is safe since it will
             * only result in eliminating an unnecessary dequeuePendingWrites
             * call.
             */
            if (qwFileNum < fileNum /*&& queuedWritesPosition > 0*/) {
                dequeuePendingWrites();
                qwFileNum = fileNum;
            }

            synchronized (queuedWrites) {
                boolean overflow =
                    (writeQueueSize - queuedWritesPosition) < size;
                if (overflow) {
                    nWriteQueueOverflow.increment();

                    /*
                     * Since we can't write this "write call" into the
                     * ByteBuffer without overflowing, we will try to dequeue
                     * all current writes in the buffer.  But that requires
                     * holding the fsyncFileSynchronizer latch first which
                     * would be latching out of order relative to the
                     * queuedWrites mutex.
                     */
                    throw RelatchRequiredException.relatchRequiredException;
                }

                assert qwFileNum == fileNum;
                int curPos = queuedWritesPosition;
                if (curPos == 0) {

                    /*
                     * This is the first entry in queue.  Set qwStartingOffset.
                     */
                    qwStartingOffset = destOffset;
                }

                if (curPos + qwStartingOffset != destOffset) {
                    throw new EnvironmentFailureException
                        (envImpl,
                         EnvironmentFailureReason.LOG_INTEGRITY,
                         "non-consecutive writes queued. " +
                         "qwPos=" + queuedWritesPosition +
                         " write destOffset=" +
                         destOffset);
                }

                System.arraycopy(data, arrayOffset,
                                 queuedWrites, queuedWritesPosition,
                                 size);
                queuedWritesPosition += size;
            }
        }

        /*
         * Execute pending writes.  Assumes fsyncFileSynchronizer is not held.
         */
        private void dequeuePendingWrites()
            throws DatabaseException {

            assert !fsyncFileSynchronizer.isHeldByCurrentThread();

            fsyncFileSynchronizer.lock();
            try {
                dequeuePendingWrites1();
            } finally {
                fsyncFileSynchronizer.unlock();
            }
        }

        /*
         * Execute pending writes.  Assumes fsyncFileSynchronizer is held.
         */
        private void dequeuePendingWrites1()
            throws DatabaseException {

            assert fsyncFileSynchronizer.isHeldByCurrentThread();

            try {
                synchronized (queuedWrites) {
                    /* Nothing to see here.  Move along. */
                    if (queuedWritesPosition == 0) {
                        return;
                    }

                    RandomAccessFile file = getWritableFile(qwFileNum, false);
                    synchronized (file) {
                        file.seek(qwStartingOffset);
                        file.write(queuedWrites, 0, queuedWritesPosition);
                        nBytesWrittenFromWriteQueue.add(queuedWritesPosition);
                        nWritesFromWriteQueue.increment();
                        if (VERIFY_CHECKSUMS) {
                            file.seek(qwStartingOffset);
                            file.read(queuedWrites, 0, queuedWritesPosition);
                            ByteBuffer bb =
                                ByteBuffer.allocate(queuedWritesPosition);
                            bb.put(queuedWrites, 0, queuedWritesPosition);
                            bb.position(0);
                            verifyChecksums
                                (bb, qwStartingOffset, "post-write");
                        }
                    }

                    /* We flushed the queue.  Reset the buffer. */
                    queuedWritesPosition = 0;
                }
            } catch (IOException e) {
                throw new LogWriteException
                    (envImpl, "IOException during fsync", e);
            }
        }

        /**
         * getWritableFile must be called under the log write latch.
         */
        private RandomAccessFile getWritableFile(final long fileNumber,
                                                 final boolean doLock) {
            try {
                if (endOfLogRWFile == null) {

                    /*
                     * We need to make a file descriptor for the end of the
                     * log.  This is guaranteed to be called under the log
                     * write latch.
                     */
                    endOfLogRWFile =
                        makeFileHandle(fileNumber,
                                       getAppropriateReadWriteMode()).
                        getFile();
                    if (doLock) {
                        fsyncFileSynchronizer.lock();
                    }
                    try {
                        endOfLogSyncFile =
                            makeFileHandle(fileNumber,
                                           getAppropriateReadWriteMode()).
                            getFile();
                    } finally {
                        if (doLock) {
                            fsyncFileSynchronizer.unlock();
                        }
                    }
                }

                return endOfLogRWFile;
            } catch (Exception e) {

                /*
                 * If we can't get a write channel, we need to invalidate the
                 * environment.
                 */
                throw new EnvironmentFailureException
                    (envImpl,
                     EnvironmentFailureReason.LOG_INTEGRITY,
                     e);
            }
        }

        /**
         * FSync the log file that makes up the end of the log.
         */
        private void force()
            throws DatabaseException, IOException {

            /*
             * Get a local copy of the end of the log file descriptor, it could
             * change. No need to latch, no harm done if we get an old file
             * descriptor, because we forcibly fsync under the log write latch
             * when we switch files.
             *
             * If there is no current end file descriptor, we know that the log
             * file has flipped to a new file since the fsync was issued.
             */
            fsyncFileSynchronizer.lock();
            try {

                /* Flush any queued writes. */
                if (useWriteQueue) {
                    dequeuePendingWrites1();
                }

                RandomAccessFile file = endOfLogSyncFile;
                if (file != null) {
                    bumpWriteCount("fsync");
                    FileChannel ch = file.getChannel();
                    try {
                        ch.force(false);
                        nLogFSyncs.increment();
                    } catch (ClosedChannelException e) {

                        /*
                         * The channel should never be closed. It may be closed
                         * because of an interrupt received by another
                         * thread. See SR [#10463]
                         */
                        throw new ThreadInterruptedException
                            (envImpl,
                             "Channel closed, may be due to thread interrupt",
                             e);
                    }

                    assert EnvironmentImpl.maybeForceYield();
                }

                /* Flush any writes which were queued while fsync'ing. */
                if (useWriteQueue) {
                    dequeuePendingWrites1();
                }
            } finally {
                fsyncFileSynchronizer.unlock();
            }
        }

        /**
         * Close the end of the log file descriptor. Use atomic assignment to
         * ensure that we won't force and close on the same descriptor.
         */
        void close()
            throws IOException {

            IOException firstException = null;
            if (endOfLogRWFile != null) {
                RandomAccessFile file = endOfLogRWFile;

                /*
                 * Null out so that other threads know endOfLogRWFile is no
                 * longer available.
                 */
                endOfLogRWFile = null;
                try {
                    file.close();
                } catch (IOException e) {
                    /* Save this exception, so we can try the second close. */
                    firstException = e;
                }
            }
            fsyncFileSynchronizer.lock();
            try {
                if (endOfLogSyncFile != null) {
                    RandomAccessFile file = endOfLogSyncFile;

                    /*
                     * Null out so that other threads know endOfLogSyncFile is
                     * no longer available.
                     */
                    endOfLogSyncFile = null;
                    file.close();
                }

                if (firstException != null) {
                    throw firstException;
                }
            } finally {
                fsyncFileSynchronizer.unlock();
            }
        }
    }

    /*
     * Generate IOExceptions for testing.
     */

    /* Testing switch. public so others can read the value. */
    public static final boolean LOGWRITE_EXCEPTION_TESTING;
    private static String RRET_PROPERTY_NAME = "je.logwrite.exception.testing";

    static {
        LOGWRITE_EXCEPTION_TESTING =
            (System.getProperty(RRET_PROPERTY_NAME) != null);
    }

    /* Max write counter value. */
    private static final int LOGWRITE_EXCEPTION_MAX = 100;
    /* Current write counter value. */
    private int logWriteExceptionCounter = 0;
    /* Whether an exception has been thrown. */
    private boolean logWriteExceptionThrown = false;
    /* Random number generator. */
    private Random logWriteExceptionRandom = null;

    private void generateLogWriteException(RandomAccessFile file,
                                           ByteBuffer data,
                                           long destOffset,
                                           long fileNum)
        throws DatabaseException, IOException {

        if (logWriteExceptionThrown) {
            (new Exception("Write after LogWriteException")).
                printStackTrace();
        }
        logWriteExceptionCounter += 1;
        if (logWriteExceptionCounter >= LOGWRITE_EXCEPTION_MAX) {
            logWriteExceptionCounter = 0;
        }
        if (logWriteExceptionRandom == null) {
            logWriteExceptionRandom = new Random(System.currentTimeMillis());
        }
        if (logWriteExceptionCounter ==
            logWriteExceptionRandom.nextInt(LOGWRITE_EXCEPTION_MAX)) {
            int len = logWriteExceptionRandom.nextInt(data.remaining());
            if (len > 0) {
                byte[] a = new byte[len];
                data.get(a, 0, len);
                ByteBuffer buf = ByteBuffer.wrap(a);
                writeToFile(file, buf, destOffset, fileNum,
                            false /*flushRequired*/);
            }
            logWriteExceptionThrown = true;
            throw new IOException("Randomly generated for testing");
        }
    }
}
