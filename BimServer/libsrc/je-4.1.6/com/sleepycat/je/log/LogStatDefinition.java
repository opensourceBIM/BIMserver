/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for JE FileManager, FSyncManager, LogManager and 
 * LogBufferPool statistics.
 */
public class LogStatDefinition {

    /* Group definition for all log statistics. */
    public static final String GROUP_NAME = "I/O";
    public static final String GROUP_DESC = 
        "Log file opens, fsyncs, reads, writes, cache misses.";

    /* Group definition for LogBufferPool statistics. */
    public static final String LBF_GROUP_NAME = "LogBufferPool";
    public static final String LBF_GROUP_DESC = "LogBufferPool statistics";

    /* Group definition for FileManager statistics. */
    public static final String FILEMGR_GROUP_NAME = "FileManager";
    public static final String FILEMGR_GROUP_DESC = "FileManager statistics";

    /* Group definition for FSyncManager statistics. */
    public static final String FSYNCMGR_GROUP_NAME = "FSyncManager";
    public static final String FSYNCMGR_GROUP_DESC = "FSyncManager statistics";

    /* The following stat definitions are used in FileManager. */
    public static final StatDefinition FILEMGR_RANDOM_READS =
        new StatDefinition("nRandomReads", 
                           "Number of disk reads which required " +
                           "respositioning the disk head more than 1MB " +
                           "from the previous file position.");

    public static final StatDefinition FILEMGR_RANDOM_WRITES =
        new StatDefinition("nRandomWrites", 
                           "Number of disk writes which required " +
                           "respositioning the disk head by more than 1MB " +
                           "from the previous file position.");

    public static final StatDefinition FILEMGR_SEQUENTIAL_READS =
        new StatDefinition("nSequentialReads",
                           "Number of disk reads which did not require " +
                           "respositioning the disk head more than 1MB from " +
                           "the previous file position.");

    public static final StatDefinition FILEMGR_SEQUENTIAL_WRITES =
        new StatDefinition("nSequentialWrites",
                           "Number of disk writes which did not require " +
                           "respositioning the disk head by more than 1MB " +
                           "from the previous file position.");

    public static final StatDefinition FILEMGR_RANDOM_READ_BYTES =
        new StatDefinition("nRandomReadBytes", 
                           "Number of bytes read which required " +
                           "respositioning the disk head more than 1MB from " +
                           "the previous file position.");

    public static final StatDefinition FILEMGR_RANDOM_WRITE_BYTES =
        new StatDefinition("nRandomWriteBytes", 
                           "Number of bytes written which required " +
                           "respositioning the disk head more than 1MB from " +
                           "the previous file position.");

    public static final StatDefinition FILEMGR_SEQUENTIAL_READ_BYTES =
        new StatDefinition("nSequentialReadBytes", 
                           "Number of bytes read which did not require " +
                           "respositioning the disk head more than 1MB from " +
                           "the previous file position.");
    
    public static final StatDefinition FILEMGR_SEQUENTIAL_WRITE_BYTES =
        new StatDefinition("nSequentialWriteBytes", 
                           "Number of bytes written which did not require " +
                           "respositioning the disk head more than 1MB from " +
                           "the previous file position.");

    public static final StatDefinition FILEMGR_FILE_OPENS =
        new StatDefinition("nFileOpens",
                           "Number of times a log file has been opened.");

    public static final StatDefinition FILEMGR_OPEN_FILES =
        new StatDefinition("nOpenFiles",
                           "Number of files currently open in the file " +
                           "cache.");

    public static final StatDefinition FILEMGR_BYTES_READ_FROM_WRITEQUEUE =
        new StatDefinition("nBytesReadFromWriteQueue",
                           "Number of bytes read to fulfill file read " +
                           "operations by reading out of the pending write " +
                           "queue.");

    public static final StatDefinition FILEMGR_BYTES_WRITTEN_FROM_WRITEQUEUE =
        new StatDefinition("nBytesWrittenFromWriteQueue",
                           "Number of bytes written from the pending write " +
                           "queue.");

    public static final StatDefinition FILEMGR_READS_FROM_WRITEQUEUE =
        new StatDefinition("nReadsFromWriteQueue",
                           "Number of file read operations which were " +
                           "fulfilled by reading out of the pending write " +
                           "queue."); 

    public static final StatDefinition FILEMGR_WRITES_FROM_WRITEQUEUE =
        new StatDefinition("nWritesFromWriteQueue",
                           "Number of file write operations executed from " +
                           "the pending write queue.");

    public static final StatDefinition FILEMGR_WRITEQUEUE_OVERFLOW =
        new StatDefinition("nWriteQueueOverflow",
                           "Number of write operations which would overflow " +
                           "the Write Queue.");

    public static final StatDefinition FILEMGR_WRITEQUEUE_OVERFLOW_FAILURES =
        new StatDefinition("nWriteQueueOverflowFailures",
                           "Number of write operations which would overflow " +
                           "the Write Queue and could not be queued.");

    /* The following stat definitions are used in FSyncManager. */
    public static final StatDefinition FSYNCMGR_FSYNCS =
        new StatDefinition("nFSyncs",
                           "Number of fsyncs issued through the group " +
                           "commit manager for actions such as transaction " +
                           "commits and checkpoints. A subset " +
                           "of nLogFsyncs.");

    public static final StatDefinition FSYNCMGR_FSYNC_REQUESTS =
        new StatDefinition("nFSyncRequests",
                           "Number of fsyncs requested through the group " +
                           "commit manager for actions such as transaction " +
                           "commits and checkpoints.");

    public static final StatDefinition FSYNCMGR_FSYNC_TIMEOUTS =
        new StatDefinition("nFSyncTimeouts",
                           "Number of fsyncs requests submitted to the " +
                           "group commit manager for actions such as " +
                           "transaction commmits and checkpoints " +
                           "which timed out.");

    public static final StatDefinition FILEMGR_LOG_FSYNCS = 
        new StatDefinition("nLogFSyncs",
                           "Total number of fsyncs of the JE log. This " +
                           "includes those fsyncs recorded under the nFsyncs " +
                           "stat");

    /* The following stat definitions are used in LogManager. */
    public static final StatDefinition LOGMGR_REPEAT_FAULT_READS=
        new StatDefinition("nRepeatFaultReads",
                           "Number of reads which had to be repeated when " +
                           "faulting in an object from disk because the " +
                           "read chunk size controlled by " +
                           "je.log.faultReadSize is too small.");

    public static final StatDefinition LOGMGR_TEMP_BUFFER_WRITES =
        new StatDefinition("nTempBufferWrites",
                           "Number of writes which had to be completed " +
                           "using the temporary marshalling buffer because " +
                           "the fixed size log buffers specified by " +
                           "je.log.totalBufferBytes and je.log.numBuffers " +
                           "were not large enough.");

    public static final StatDefinition LOGMGR_END_OF_LOG =
        new StatDefinition("endOfLog",
                           "The location of the next entry to be written to " +
                           "the log.");

    /* The following stat definitions are used in LogBufferPool. */
    public static final StatDefinition LBFP_NOT_RESIDENT =
        new StatDefinition("nNotResident",
                           "Number of request for database objects not " +
                           "contained within the in memory data structure.");

    public static final StatDefinition LBFP_MISS =
        new StatDefinition("nCacheMiss",
                           "Total number of requests for database objects " +
                           "which were not in memory.");

    public static final StatDefinition LBFP_LOG_BUFFERS =
        new StatDefinition("nLogBuffers",
                           "Number of log buffers currently instantiated.");

    public static final StatDefinition LBFP_BUFFER_BYTES =
        new StatDefinition("bufferBytes",
                           "Total memory currently consumed by log buffers, " +
                           "in bytes."); 
}
