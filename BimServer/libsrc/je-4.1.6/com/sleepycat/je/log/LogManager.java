/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import static com.sleepycat.je.log.LogStatDefinition.GROUP_DESC;
import static com.sleepycat.je.log.LogStatDefinition.GROUP_NAME;
import static com.sleepycat.je.log.LogStatDefinition.LOGMGR_END_OF_LOG;
import static com.sleepycat.je.log.LogStatDefinition.LOGMGR_REPEAT_FAULT_READS;
import static com.sleepycat.je.log.LogStatDefinition.LOGMGR_TEMP_BUFFER_WRITES;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.ThreadInterruptedException;
import com.sleepycat.je.cleaner.LocalUtilizationTracker;
import com.sleepycat.je.cleaner.TrackedFileSummary;
import com.sleepycat.je.cleaner.UtilizationTracker;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.latch.Latch;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.txn.WriteLockInfo;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LSNStat;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.TestHook;

/**
 * The LogManager supports reading and writing to the JE log.
 */
public abstract class LogManager {

    /* No-op loggable object. */
    private static final String DEBUG_NAME = LogManager.class.getName();

    protected LogBufferPool logBufferPool; // log buffers
    protected Latch logWriteLatch;           // synchronizes log writes
    private final boolean doChecksumOnRead;      // if true, do checksum on read
    private final FileManager fileManager;       // access to files
    protected EnvironmentImpl envImpl;
    private final boolean readOnly;

    /* How many bytes to read when faulting in. */
    private final int readBufferSize;

    /* The last LSN in the log during recovery. */
    private long lastLsnAtRecovery = DbLsn.NULL_LSN;

    /* Stats */
    private final StatGroup stats;

    /*
     * Number of times we have to repeat a read when we fault in an object
     * because the initial read was too small.
     */
    private final LongStat nRepeatFaultReads;

    /*
     * Number of times we have to use the temporary marshalling buffer to
     * write to the log.
     */
    private final LongStat nTempBufferWrites;

    /* The location of the next entry to be written to the log. */
    private final LSNStat endOfLog;

    /* For unit tests */
    private TestHook readHook; // used for generating exceptions on log reads

    /* A queue to hold log entries which are to be logged lazily. */
    private final Queue<LazyQueueEntry> lazyLogQueue =
        new ConcurrentLinkedQueue<LazyQueueEntry>();

    /*
     * An entry in the lazyLogQueue. A struct to hold the entry and repContext.
     */
    private static class LazyQueueEntry {
        private final LogEntry entry;
        private final ReplicationContext repContext;

        private LazyQueueEntry(LogEntry entry, ReplicationContext repContext) {
            this.entry = entry;
            this.repContext = repContext;
        }
    }

    /**
     * There is a single log manager per database environment.
     */
    public LogManager(EnvironmentImpl envImpl,
                      boolean readOnly)
        throws DatabaseException {

        /* Set up log buffers. */
        this.envImpl = envImpl;
        this.fileManager = envImpl.getFileManager();
        DbConfigManager configManager = envImpl.getConfigManager();
        this.readOnly = readOnly;
        logBufferPool = new LogBufferPool(fileManager, envImpl);

        /* See if we're configured to do a checksum when reading in objects. */
        doChecksumOnRead =
            configManager.getBoolean(EnvironmentParams.LOG_CHECKSUM_READ);

        logWriteLatch = new Latch(DEBUG_NAME);
        readBufferSize =
            configManager.getInt(EnvironmentParams.LOG_FAULT_READ_SIZE);

        /* Do the stats definitions. */
        stats = new StatGroup(GROUP_NAME, GROUP_DESC);
        nRepeatFaultReads = new LongStat(stats, LOGMGR_REPEAT_FAULT_READS);
        nTempBufferWrites = new LongStat(stats, LOGMGR_TEMP_BUFFER_WRITES);
        endOfLog = new LSNStat(stats, LOGMGR_END_OF_LOG);
    }

    public boolean getChecksumOnRead() {
        return doChecksumOnRead;
    }

    public long getLastLsnAtRecovery() {
        return lastLsnAtRecovery;
    }

    public void setLastLsnAtRecovery(long lastLsnAtRecovery) {
        this.lastLsnAtRecovery = lastLsnAtRecovery;
    }

    /**
     * Reset the pool when the cache is resized.  This method is called after
     * the memory budget has been calculated.
     */
    public void resetPool(DbConfigManager configManager)
        throws DatabaseException {

        logBufferPool.reset(configManager);
    }

    /*
     * Writing to the log
     */

    /**
     * Log this single object and force a write of the log files.
     * @param entry object to be logged
     * @param fsyncRequired if true, log files should also be fsynced.
     * @return LSN of the new log entry
     */
    public long logForceFlush(LogEntry entry,
                              boolean fsyncRequired,
                              ReplicationContext repContext)
        throws DatabaseException {

        return log(entry,
                   Provisional.NO,
                   true,           // flush required
                   fsyncRequired,
                   false,          // forceNewLogFile
                   false,          // backgroundIO
                   DbLsn.NULL_LSN, // old lsn
                   null,           // nodeDb
                   repContext);    // repContext
    }

    /**
     * Log this single object and force a flip of the log files.
     * @param entry object to be logged
     * @return LSN of the new log entry
     */
    public long logForceFlip(LogEntry entry)
        throws DatabaseException {

        return log(entry,
                   Provisional.NO,
                   true,           // flush required
                   false,          // fsync required
                   true,           // forceNewLogFile
                   false,          // backgroundIO
                   DbLsn.NULL_LSN, // old lsn
                   null,           // nodeDb
                   ReplicationContext.NO_REPLICATE);
    }

    /**
     * Write a log entry.
     * @param entry object to be logged
     * @return LSN of the new log entry
     */
    public long log(LogEntry entry, ReplicationContext repContext)
        throws DatabaseException {

        return log(entry,
                   Provisional.NO,
                   false,           // flush required
                   false,           // fsync required
                   false,           // forceNewLogFile
                   false,           // backgroundIO
                   DbLsn.NULL_LSN,  // old lsn
                   null,            // nodeDb
                   repContext);
    }

    /**
     * Write a log entry lazily.
     * @param entry object to be logged
     */
    public void logLazily(LogEntry entry, ReplicationContext repContext) {

        lazyLogQueue.add(new LazyQueueEntry(entry, repContext));
    }

    /**
     * Write a log entry.
     * @param entry object to be logged
     * @param isProvisional true if this entry should not be read during
     * recovery.
     * @param backgroundIO if true, sleep when the backgroundIOLimit is
     * exceeded.
     * @param oldNodeLsn is the previous version of the node to be counted as
     * obsolete, or NULL_LSN if the entry is not a node or has no old LSN.
     * @param nodeDb database of the node, or null if entry is not a node.
     * @return LSN of the new log entry
     */
    public long log(LogEntry entry,
                    boolean isProvisional,
                    boolean backgroundIO,
                    long oldNodeLsn,
                    DatabaseImpl nodeDb,
                    ReplicationContext repContext)
        throws DatabaseException {

        return log(entry,
                   isProvisional ? Provisional.YES : Provisional.NO,
                   false,          // flush required
                   false,          // fsync required
                   false,          // forceNewLogFile
                   backgroundIO,
                   oldNodeLsn,
                   nodeDb,
                   repContext);
    }

    /**
     * Write a log entry.
     * @param entry object to be logged
     * @param provisional whether this entry should be processed during
     * recovery.
     * @param backgroundIO if true, sleep when the backgroundIOLimit is
     * exceeded.
     * @param oldNodeLsn is the previous version of the node to be counted as
     * obsolete, or NULL_LSN if the entry is not a node or has no old LSN.
     * @param nodeDb database of the node, or null if entry is not a node.
     * @return LSN of the new log entry
     */
    public long log(LogEntry entry,
                    Provisional provisional,
                    boolean backgroundIO,
                    long oldNodeLsn,
                    DatabaseImpl nodeDb,
                    ReplicationContext repContext)
        throws DatabaseException {

        return log(entry,
                   provisional,
                   false,          // flush required
                   false,          // fsync required
                   false,          // forceNewLogFile
                   backgroundIO,
                   oldNodeLsn,
                   nodeDb,
                   repContext);
    }

    /**
     * Translates individual log params to LogItem and LogContext fields.
     */
    private long log(LogEntry entry,
                     Provisional provisional,
                     boolean flushRequired,
                     boolean fsyncRequired,
                     boolean forceNewLogFile,
                     boolean backgroundIO,
                     long oldNodeLsn,
                     DatabaseImpl nodeDb,
                     ReplicationContext repContext)
        throws DatabaseException {

        LogItem item = new LogItem();
        item.entry = entry;
        item.provisional = provisional;
        item.oldLsn = oldNodeLsn;
        item.repContext = repContext;

        LogContext context = new LogContext();
        context.flushRequired = flushRequired;
        context.fsyncRequired = fsyncRequired;
        context.forceNewLogFile = forceNewLogFile;
        context.backgroundIO = backgroundIO;
        context.nodeDb = nodeDb;

        log(item, context);

        return item.newLsn;
    }

    /**
     * Convenience method for logging a single entry.
     */
    public void log(LogItem item, LogContext context)
        throws DatabaseException {

        multiLog(new LogItem[] { item }, context);
    }

    public void multiLog(LogItem[] itemArray, LogContext context)
        throws DatabaseException {

        if (readOnly || itemArray.length == 0) {
            return;
        }

        try {
            /* Flush any pending lazy entries. */
            LazyQueueEntry lqe = lazyLogQueue.poll();
            while (lqe != null) {
                LogItem item = new LogItem();
                item.entry = lqe.entry;
                item.provisional = Provisional.NO;
                item.oldLsn = DbLsn.NULL_LSN;
                item.repContext = lqe.repContext;

                LogContext lqeContext = new LogContext();
                lqeContext.flushRequired = false;
                lqeContext.fsyncRequired = false;
                lqeContext.forceNewLogFile = false;
                lqeContext.backgroundIO = false;
                lqeContext.nodeDb = null;

                serialLog(new LogItem[] { item }, lqeContext);
                lqe = lazyLogQueue.poll();
            }

            for (LogItem item : itemArray) {
                LogEntry logEntry = item.entry;

                /*
                 * Get the old size before marshaling, which updates it.
                 * Holding the log write latch is not necessary, because the
                 * parent IN latch prevents other threads from logging this
                 * node.
                 */
                item.oldSize = logEntry.getLastLoggedSize();

                /*
                 * If possible, marshall this entry outside the log write latch
                 * to allow greater concurrency by shortening the write
                 * critical section.  Note that the header may only be created
                 * during marshalling because it calls entry.getSize().
                 */
                if (logEntry.getLogType().marshallOutsideLatch()) {
                    item.header = new LogEntryHeader
                        (logEntry, item.provisional, item.repContext);
                    item.buffer = marshallIntoBuffer(item.header, logEntry);
                }
            }

            /*
             * Perform the serial portion of the log operation, including
             * appending to the log buffer.
             */
            serialLog(itemArray, context);

        } catch (BufferOverflowException e) {

            /*
             * A BufferOverflowException may be seen when a thread is
             * interrupted in the middle of the log and the nio direct buffer
             * is mangled is some way by the NIO libraries. JE applications
             * should refrain from using thread interrupt as a thread
             * communications mechanism because nio behavior in the face of
             * interrupts is uncertain. See SR [#10463].
             *
             * One way or another, this type of io exception leaves us in an
             * unworkable state, so throw a run recovery exception.
             */
            throw new ThreadInterruptedException(envImpl, e);
        } catch (IOException e) {

            /*
             * IOExceptions from true file I/O should not occur here, since
             * they are converted to DatabaseException by FileManager.
             */
            throw EnvironmentFailureException.unexpectedException(e);
        }

        /*
         * Finish up business outside of the log write latch critical section.
         */

        /*
         * If this logged object needs to be fsynced, do so now using the group
         * commit mechanism.
         */
        if (context.fsyncRequired) {
            fileManager.groupSync();
        }

        for (LogItem item : itemArray) {

            /*
             * We've logged this log entry from the replication stream. Let
             * the Replicator know, so this node can create a VLSN->LSN
             * mapping.  Do this before the ckpt so we have a better chance
             * of writing this mapping to disk.
             */
            if (item.repContext.inReplicationStream()) {
                assert (item.header.getVLSN() != null) :
                    "Unexpected null vlsn: " + item.header + " " +
                    item.repContext;
                envImpl.registerVLSN(item);
            }
        }

        /*
         * Periodically, as a function of how much data is written, ask the
         * checkpointer or the cleaner to wake up.
         */
        envImpl.getCheckpointer().wakeupAfterWrite();
        if (context.wakeupCleaner) {
            envImpl.getUtilizationTracker().activateCleaner();
        }

        /* Update background writes. */
        if (context.backgroundIO) {
            envImpl.updateBackgroundWrites
                (context.totalNewSize, logBufferPool.getLogBufferSize());
        }
    }

    /**
     * Log one or more items while latched or synchronized in order to
     * serialize log output.  Implementations of this method call
     * serialLogInternal.
     */
    abstract void serialLog(LogItem[] itemArray, LogContext context)
        throws IOException, DatabaseException;

    /**
     * Called within the log write critical section.
     */
    void serialLogInternal(LogItem[] itemArray, LogContext context)
        throws IOException, DatabaseException {

        UtilizationTracker tracker = envImpl.getUtilizationTracker();
        LogItem firstItem = itemArray[0];
        LogItem lastItem = itemArray[itemArray.length - 1];

        for (LogItem item : itemArray) {
            boolean marshallOutsideLatch = (item.buffer != null);
            boolean isFirstItem = (item == firstItem);
            boolean isLastItem = (item == lastItem);

            /*
             * Do obsolete tracking before marshalling a FileSummaryLN into the
             * log buffer so that a FileSummaryLN counts itself.
             * countObsoleteNode must be called before computing the entry
             * size, since it can change the size of a FileSummaryLN entry that
             * we're logging
             */
            LogEntryType entryType = item.entry.getLogType();
            if (item.oldLsn != DbLsn.NULL_LSN) {
                if (context.obsoleteDupsAllowed) {
                    tracker.countObsoleteNodeDupsAllowed
                        (item.oldLsn, entryType, item.oldSize, context.nodeDb);
                } else {
                    tracker.countObsoleteNode
                        (item.oldLsn, entryType, item.oldSize, context.nodeDb);
                }
            }

            /*
             * If an entry must be protected within the log write latch for
             * marshalling, take care to also calculate its size in the
             * protected section. Note that we have to get the size *before*
             * marshalling so that the currentLsn and size are correct for
             * utilization tracking.
             */
            int entrySize;
            if (marshallOutsideLatch) {
                entrySize = item.buffer.limit();
                assert item.header != null;
            } else {
                assert item.header == null;
                item.header = new LogEntryHeader
                    (item.entry, item.provisional, item.repContext);
                entrySize = item.header.getSize() + item.header.getItemSize();
            }

            /*
             * Get the next free slot in the log, under the log write latch.
             * Bump the LSN values, which gives us a valid previous pointer,
             * which is part of the log entry header. That's why doing the
             * checksum must be in the log write latch -- we need to bump the
             * LSN first, and bumping the LSN must be done within the log write
             * latch.
             */
            if (isFirstItem && context.forceNewLogFile) {
                fileManager.forceNewLogFile();
            }

            boolean flippedFile = fileManager.bumpLsn(entrySize);
            long currentLsn = DbLsn.NULL_LSN;
            boolean usedTemporaryBuffer = false;
            boolean success = false;
            try {
                currentLsn = fileManager.getLastUsedLsn();

                /*
                 * countNewLogEntry and countObsoleteNodeInexact cannot change
                 * a FileSummaryLN size, so they are safe to call after
                 * getSizeForWrite.
                 */
                if (tracker.countNewLogEntry
                    (currentLsn, entryType, entrySize, context.nodeDb)) {
                    context.wakeupCleaner = true;
                }

                /*
                 * LN deletions are obsolete immediately.  Inexact counting is
                 * used to save resources because the cleaner knows that all
                 * deleted LNs are obsolete.
                 */
                if (item.entry.isDeleted()) {
                    tracker.countObsoleteNodeInexact
                        (currentLsn, entryType, entrySize, context.nodeDb);
                }

                /*
                 * This entry must be marshalled within the log write latch.
                 */
                if (!marshallOutsideLatch) {
                    assert item.buffer == null;
                    item.buffer = marshallIntoBuffer(item.header, item.entry);
                }

                /* Sanity check */
                if (entrySize != item.buffer.limit()) {
                    throw EnvironmentFailureException.unexpectedState
                        ("Logged entry entrySize= " + entrySize +
                         " but marshalledSize=" + item.buffer.limit() +
                         " type=" + entryType + " currentLsn=" +
                         DbLsn.getNoFormatString(currentLsn));
                }

                /*
                 * Ask for a log buffer suitable for holding this new entry.
                 * If the current log buffer is full, or if we flipped into a
                 * new file, write it to disk and get a new, empty log buffer
                 * to use. The returned buffer will be latched for write.
                 */
                LogBuffer useLogBuffer =
                    logBufferPool.getWriteBuffer(entrySize, flippedFile);

                /* Add checksum, prev offset, and VLSN to the entry. */
                item.buffer = item.header.addPostMarshallingInfo
                    (envImpl, item.buffer, fileManager.getPrevEntryOffset(),
                     item.repContext);

                /*
                 * If the LogBufferPool buffer (useBuffer) doesn't have
                 * sufficient space (since they're fixed size), just use the
                 * temporary buffer and throw it away when we're done.  That
                 * way we don't grow the LogBuffers in the pool permanently.
                 * We risk an OOME on this temporary usage, but we'll risk it.
                 * [#12674]
                 */
                useLogBuffer.latchForWrite();
                try {
                    ByteBuffer useBuffer = useLogBuffer.getDataBuffer();
                    if (useBuffer.capacity() - useBuffer.position() <
                        entrySize) {
                        fileManager.writeLogBuffer
                            (new LogBuffer(item.buffer, currentLsn),
                             false /* flushRequired */);
                        usedTemporaryBuffer = true;
                        assert useBuffer.position() == 0;
                        nTempBufferWrites.increment();
                    } else {
                        /* Copy marshalled object into write buffer. */
                        useBuffer.put(item.buffer);
                    }
                } finally {
                    useLogBuffer.release();
                }

                success = true;
            } finally {
                if (!success) {

                    /*
                     * The LSN pointer, log buffer position, and corresponding
                     * file position march in lockstep.
                     *
                     * 1. We bump the LSN.
                     * 2. We copy loggable entry into the log buffer.
                     * 3. We may try to write the log buffer.
                     *
                     * If we've failed to put the entry into the log buffer
                     * (2), we need to restore old LSN state so that the log
                     * buffer doesn't have a hole. [SR #12638] If we fail after
                     * (2), we don't need to restore state, because log buffers
                     * will still match file positions.
                     *
                     * This assumes that the last possible activity was the
                     * write of the log buffers.
                     */
                    fileManager.restoreLastPosition();

                    /*
                     * If the entry was not written to the log, it will not be
                     * part of the replication stream, and we should reuse the
                     * vlsn.
                     */
                    if (item.header.getVLSN() != null) {
                        envImpl.decrementVLSN();
                    }
                }
            }

            /*
             * Tell the log buffer pool that we finished the write.  Record the
             * LSN against this logbuffer, and write the buffer to disk if
             * needed.
             */
            if (!usedTemporaryBuffer) {
                logBufferPool.writeCompleted
                    (currentLsn, isLastItem && context.flushRequired,
                     context.fsyncRequired);
            }

            /*
             * If the txn is not null, the first entry is an LN. Update the txn
             * with info about the latest LSN. Note that this has to happen
             * within the log write latch.
             */
            item.entry.postLogWork(currentLsn);

            item.newLsn = currentLsn;
            context.totalNewSize += entrySize;
        }

        /* Count other obsolete info under the log write latch. */
        if (context.packedObsoleteInfo != null) {
            context.packedObsoleteInfo.countObsoleteInfo
                (tracker, context.nodeDb);
        }
        if (context.obsoleteWriteLockInfo != null) {
            for (WriteLockInfo info : context.obsoleteWriteLockInfo) {
                tracker.countObsoleteNode(info.getAbortLsn(),
                                          null /*type*/,
                                          info.getAbortLogSize(),
                                          info.getAbortDb());
            }
        }
    }

    /**
     * Serialize a loggable object into this buffer. (public for
     * unit tests.
     */
    private ByteBuffer marshallIntoBuffer(LogEntryHeader header,
                                          LogEntry entry) {
        int entrySize = header.getSize() + header.getItemSize();

        ByteBuffer destBuffer = ByteBuffer.allocate(entrySize);
        header.writeToLog(destBuffer);

        /* Put the entry in. */
        entry.writeEntry(header, destBuffer);

        /* Set the limit so it can be used as the size of the entry. */
        destBuffer.flip();

        return destBuffer;
    }

    /**
     * Serialize a log entry into this buffer with proper entry header. Return
     * it ready for a copy.
     */
    ByteBuffer putIntoBuffer(LogEntry entry,
                             long prevLogEntryOffset) {
        LogEntryHeader header = new LogEntryHeader
            (entry, Provisional.NO, ReplicationContext.NO_REPLICATE);

        /* Assert that we're not in a situation demanding Txn mutex. */
        assert entry.getLogType() != LogEntryType.LOG_LN_TRANSACTIONAL;

        ByteBuffer destBuffer = marshallIntoBuffer(header, entry);

        return header.addPostMarshallingInfo(envImpl,
                                             destBuffer,
                                             prevLogEntryOffset,
                                             ReplicationContext.NO_REPLICATE);
    }

    /*
     * Reading from the log.
     */
    /**
     * Instantiate all the objects in the log entry at this LSN.
     */
    public LogEntry getLogEntry(long lsn)
        throws FileNotFoundException {

        return getLogEntry(lsn, false /*invisibleReadAllowed*/).getEntry();
    }

    /**
     * Instantiate all the objects in the log entry at this LSN. Allow the
     * fetch of invisible log entries if we are in recovery.
     */
    public LogEntry getLogEntryAllowInvisibleAtRecovery(long lsn)
        throws FileNotFoundException {

        return getLogEntry(lsn, envImpl.isInInit() /*invisibleReadAllowed*/).
            getEntry();
    }

    /**
     * Instantiate all the objects in the log entry at this LSN. The entry
     * may be marked invisible.
     */
    public WholeEntry getLogEntryAllowInvisible(long lsn)
        throws FileNotFoundException {

        return getLogEntry(lsn, true);
    }

    /**
     * Instantiate all the objects in the log entry at this LSN.
     * @param lsn location of entry in log.
     * @param invisibleReadAllowed true if it's expected that the target log
     * entry might be invisible. Correct the known-to-be-bad checksum before
     * proceeding.
     * @return log entry that embodies all the objects in the log entry.
     */
    private WholeEntry getLogEntry(long lsn, boolean invisibleReadAllowed)
        throws FileNotFoundException {

        /* Fail loudly if the environment is invalid. */
        envImpl.checkIfInvalid();

        try {

            /*
             * Get a log source for the log entry which provides an abstraction
             * that hides whether the entry is in a buffer or on disk. Will
             * register as a reader for the buffer or the file, which will take
             * a latch if necessary.
             */
            LogSource logSource = getLogSource(lsn);

            /* Read the log entry from the log source. */
            return getLogEntryFromLogSource(lsn, logSource,
                                            invisibleReadAllowed);
        } catch (ChecksumException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_CHECKSUM, e);
        }
    }

    public LogEntry getLogEntryHandleFileNotFound(long lsn)
        throws DatabaseException {

        try {
            return getLogEntry(lsn);
        } catch (FileNotFoundException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_FILE_NOT_FOUND, e);
        }
    }

    /**
     * Throws ChecksumException rather than translating it to
     * EnvironmentFailureException and invalidating the environment.  Used
     * instead of getLogEntry when a ChecksumException is handled specially.
     */
    LogEntry getLogEntryAllowChecksumException(long lsn)
        throws ChecksumException, FileNotFoundException, DatabaseException {

        return getLogEntryFromLogSource
            (lsn,
             getLogSource(lsn),
             false /*invisibleReadAllowed*/).getEntry();
    }

    LogEntry getLogEntryAllowChecksumException(long lsn,
                                               RandomAccessFile file,
                                               int logVersion)
        throws ChecksumException, DatabaseException {

        return getLogEntryFromLogSource
            (lsn,
             new FileSource(file, readBufferSize, fileManager,
                            DbLsn.getFileNumber(lsn), logVersion),
             false /*invisibleReadAllowed*/).getEntry();
    }

    /**
     * Instantiate all the objects in the log entry at this LSN. This will
     * release the log source at the first opportunity.
     *
     * Is non-private for unit testing.
     *
     * @param lsn location of entry in log
     * @param invisibleReadAllowed if true, we will permit the read of invisible
     * log entries, and we will adjust the invisible bit so that the checksum
     * will validate
     * @return log entry that embodies all the objects in the log entry
     */
    WholeEntry getLogEntryFromLogSource(long lsn,
                                        LogSource logSource,
                                        boolean invisibleReadAllowed)
        throws ChecksumException, DatabaseException {

        try {

            /*
             * Read the log entry header into a byte buffer. This assumes
             * that the minimum size of this byte buffer (determined by
             * je.log.faultReadSize) is always >= the maximum log entry header.
             */
            long fileOffset = DbLsn.getFileOffset(lsn);
            ByteBuffer entryBuffer = logSource.getBytes(fileOffset);
            if (entryBuffer.remaining() < LogEntryHeader.MIN_HEADER_SIZE) {
                throw new ChecksumException
                    ("Incomplete log entry header, size=" +
                     entryBuffer.remaining() + " lsn=" +
                     DbLsn.getNoFormatString(lsn));
            }

            /* Read the header. */
            LogEntryHeader header =
                new LogEntryHeader(entryBuffer, logSource.getLogVersion());
            if (header.isVariableLength()) {
                if (entryBuffer.remaining() <
                    header.getVariablePortionSize()) {
                    throw new ChecksumException
                        ("Incomplete log entry header, size=" +
                         entryBuffer.remaining() + " varSize=" +
                         header.getVariablePortionSize() + " lsn=" +
                         DbLsn.getNoFormatString(lsn));
                }
                header.readVariablePortion(entryBuffer);
            }

            ChecksumValidator validator = null;
            if (doChecksumOnRead) {
                int itemStart = entryBuffer.position();

                /*
                 * We're about to read an invisible log entry, which has
                 * knowingly been left on disk with a bad checksum. Flip the
                 * invisible bit in the backing byte buffer now, so the
                 * checksum will be valid. The LogEntryHeader object itself
                 * still has the invisible bit set, which is useful for
                 * debugging.
                 */
                if (header.isInvisible()) {
                    LogEntryHeader.turnOffInvisible
                        (entryBuffer, itemStart - header.getSize());
                }

                /* Add header to checksum bytes */
                validator = new ChecksumValidator();
                int headerSizeMinusChecksum = header.getSizeMinusChecksum();
                entryBuffer.position(itemStart -
                                     headerSizeMinusChecksum);
                validator.update(entryBuffer, headerSizeMinusChecksum);
                entryBuffer.position(itemStart);
            }

            /*
             * Now that we know the size, read the rest of the entry
             * if the first read didn't get enough.
             */
            int itemSize = header.getItemSize();
            if (entryBuffer.remaining() < itemSize) {
                entryBuffer = logSource.getBytes(fileOffset + header.getSize(),
                                                 itemSize);
                nRepeatFaultReads.increment();
            }

            /*
             * Do entry validation. Run checksum before checking the entry
             * type, it will be the more encompassing error.
             */
            if (doChecksumOnRead) {
                /* Check the checksum first. */
                validator.update(entryBuffer, itemSize);
                validator.validate(header.getChecksum(), lsn);
            }

            /*
             * If invisibleReadAllowed == false, we should not be fetching
             * an invisible log entry.
             */
            if (header.isInvisible() && !invisibleReadAllowed) {
                throw new EnvironmentFailureException
                    (envImpl, EnvironmentFailureReason.LOG_INTEGRITY,
                     "Read invisible log entry at " +
                     DbLsn.getNoFormatString(lsn) + " " + header);
            }

            assert LogEntryType.isValidType(header.getType()):
                "Read non-valid log entry type: " + header.getType();

            /* Read the entry. */
            LogEntry logEntry =
                LogEntryType.findType(header.getType()).getNewLogEntry();
            logEntry.readEntry(header,
                               entryBuffer,
                               true);  // readFullItem

            /* For testing only; generate a read io exception. */
            if (readHook != null) {
                try {
                    readHook.doIOHook();
                } catch (IOException e) {
                    /* Simulate what the FileManager would do. */
                    throw new EnvironmentFailureException
                        (envImpl, EnvironmentFailureReason.LOG_READ, e);
                }
            }

            /*
             * Done with the log source, release in the finally clause.  Note
             * that the buffer we get back from logSource is just a duplicated
             * buffer, where the position and state are copied but not the
             * actual data. So we must not release the logSource until we are
             * done marshalling the data from the buffer into the object
             * itself.
             */
            return new WholeEntry(header, logEntry);
        } finally {
            if (logSource != null) {
                logSource.release();
            }
        }
    }

    /**
     * Return a ByteBuffer holding the log entry at this LSN. The log entry
     * must begin at position 0, to mimic the marshalledBuffer used in
     * logInternal().
     *
     * @param lsn location of entry in log
     * @return log entry that embodies all the objects in the log entry
     */
    public ByteBuffer getByteBufferFromLog(long lsn)
        throws DatabaseException {

        /* Fail loudly if the environment is invalid. */
        envImpl.checkIfInvalid();

        /*
         * Get a log source for the log entry which provides an abstraction
         * that hides whether the entry is in a buffer or on disk. Will
         * register as a reader for the buffer or the file, which will take a
         * latch if necessary.
         */
        LogSource logSource = null;
        try {
            logSource = getLogSource(lsn);

            /*
             * Read the log entry header into a byte buffer. This assumes
             * that the minimum size of this byte buffer (determined by
             * je.log.faultReadSize) is always >= the maximum log entry header.
             */
            long fileOffset = DbLsn.getFileOffset(lsn);
            ByteBuffer entryBuffer = logSource.getBytes(fileOffset);
            int startingPosition = entryBuffer.position();
            int amountRemaining = entryBuffer.remaining();
            assert (amountRemaining >= LogEntryHeader.MAX_HEADER_SIZE);

            /* Read the header, find out how large this buffer needs to be */
            LogEntryHeader header =
                new LogEntryHeader(entryBuffer, logSource.getLogVersion());
            int totalSize = header.getSize() + header.getItemSize();

            /*
             * Now that we know the size, read in the rest of the entry
             * if the first read didn't get enough.
             */
            if (amountRemaining < totalSize) {
                entryBuffer = logSource.getBytes(fileOffset, totalSize);
                nRepeatFaultReads.increment();
            }

            /*
             * The log entry must be positioned at the start of the returned
             * buffer, to mimic the normal logging path.
             */
            entryBuffer.position(startingPosition);
            ByteBuffer singleEntryBuffer = ByteBuffer.allocate(totalSize);
            entryBuffer.limit(startingPosition + totalSize);
            singleEntryBuffer.put(entryBuffer);
            singleEntryBuffer.position(0);
            return singleEntryBuffer;
        } catch (FileNotFoundException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_FILE_NOT_FOUND, e);
        } catch (ChecksumException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_CHECKSUM, e);
        } finally {
            logSource.release();
        }
    }

    /**
     * Fault in the first object in the log entry log entry at this LSN.
     * @param lsn location of object in log
     * @return the object in the log
     */
    public Object getEntry(long lsn)
        throws FileNotFoundException, DatabaseException {

        LogEntry entry = getLogEntry(lsn);
        return entry.getMainItem();
    }

    public Object getEntryHandleFileNotFound(long lsn) {
        LogEntry entry = getLogEntryHandleFileNotFound(lsn);
        return entry.getMainItem();
    }

    /**
     * Find the LSN, whether in a file or still in the log buffers.
     * Is public for unit testing.
     */
    public LogSource getLogSource(long lsn)
        throws FileNotFoundException, ChecksumException, DatabaseException {

        /*
         * First look in log to see if this LSN is still in memory.
         */
        LogBuffer logBuffer = logBufferPool.getReadBufferByLsn(lsn);

        if (logBuffer == null) {
            try {
                /* Not in the in-memory log -- read it off disk. */
                long fileNum = DbLsn.getFileNumber(lsn);
                return new FileHandleSource
                    (fileManager.getFileHandle(fileNum),
                     readBufferSize, fileManager);
            } catch (DatabaseException e) {
                /* Add LSN to exception message. */
                e.addErrorMessage("lsn= " + DbLsn.getNoFormatString(lsn));
                throw e;
            }
        }
        return logBuffer;
    }

    /**
     * Return a log buffer locked for reading, or null if no log buffer
     * holds this LSN location.
     */
    public LogBuffer getReadBufferByLsn(long lsn) {

        assert DbLsn.getFileOffset(lsn) != 0 :
             "Read of lsn " + DbLsn.getNoFormatString(lsn)  +
            " is illegal because file header entry is not in the log buffer";

        return logBufferPool.getReadBufferByLsn(lsn);
    }

    /**
     * Flush all log entries, fsync the log file.
     */
    public void flush()
        throws DatabaseException {

        if (!readOnly) {
            flushInternal();
            fileManager.syncLogEnd();
        }
    }

    /**
     * May be used to avoid sync, for unit tests and for rep syncup.
     */
    public void flushNoSync()
        throws DatabaseException {

        if (!readOnly) {
            flushInternal();
        }
    }

    abstract void flushInternal()
        throws DatabaseException;

    public StatGroup loadStats(StatsConfig config)
        throws DatabaseException {

        if (!config.getFast()) {
            loadEndOfLogStat();
        }

        StatGroup copyStats = stats.cloneGroup(config.getClear());
        /* Add all the LogBufferPool's stats to the LogManager's stat group. */
        copyStats.addAll(logBufferPool.loadStats(config));
        /* Add all the FileManager's stats to the LogManager's stat group. */
        copyStats.addAll(fileManager.loadStats(config));

        return copyStats;
    }

    /**
     * Returns a tracked summary for the given file which will not be flushed.
     * Used for watching changes that occur while a file is being cleaned.
     */
    public abstract TrackedFileSummary getUnflushableTrackedSummary(long file)
        throws DatabaseException;

    TrackedFileSummary getUnflushableTrackedSummaryInternal(long file) {
        return envImpl.getUtilizationTracker().
                       getUnflushableTrackedSummary(file);
    }

    /**
     * Removes the tracked summary for the given file.
     */
    abstract public void removeTrackedFile(TrackedFileSummary tfs)
        throws DatabaseException;

    protected void removeTrackedFileInternal(TrackedFileSummary tfs) {
        tfs.reset();
    }

    /**
     * Count node as obsolete under the log write latch.  This is done here
     * because the log write latch is managed here, and all utilization
     * counting must be performed under the log write latch.
     */
    public abstract void countObsoleteNode(long lsn,
                                           LogEntryType type,
                                           int size,
                                           DatabaseImpl nodeDb,
                                           boolean countExact)
        throws DatabaseException;

    void countObsoleteNodeInternal(long lsn,
                                   LogEntryType type,
                                   int size,
                                   DatabaseImpl nodeDb,
                                   boolean countExact) {
        UtilizationTracker tracker = envImpl.getUtilizationTracker();
        if (countExact) {
            tracker.countObsoleteNode(lsn, type, size, nodeDb);
        } else {
            tracker.countObsoleteNodeInexact(lsn, type, size, nodeDb);
        }
    }

    /**
     * A flavor of countObsoleteNode which does not fire an assert if the
     * offset has already been counted. Called through the LogManager so that
     * this incidence of all utilization counting can be performed under the
     * log write latch.
     */
    public abstract void countObsoleteNodeDupsAllowed(long lsn,
                                                      LogEntryType type,
                                                      int size,
                                                      DatabaseImpl nodeDb)
        throws DatabaseException;

    void countObsoleteNodeDupsAllowedInternal(long lsn,
                                              LogEntryType type,
                                              int size,
                                              DatabaseImpl nodeDb) {
        UtilizationTracker tracker = envImpl.getUtilizationTracker();
        tracker.countObsoleteNodeDupsAllowed(lsn, type, size, nodeDb);
    }

    /**
     * @see LocalUtilizationTracker#transferToUtilizationTracker
     */
    public abstract void transferToUtilizationTracker(LocalUtilizationTracker
                                                      localTracker)
        throws DatabaseException;

    void transferToUtilizationTrackerInternal(LocalUtilizationTracker
                                              localTracker)
        throws DatabaseException {

        UtilizationTracker tracker = envImpl.getUtilizationTracker();
        localTracker.transferToUtilizationTracker(tracker);
    }

    /**
     * @see DatabaseImpl#countObsoleteDb
     */
    public abstract void countObsoleteDb(DatabaseImpl db)
        throws DatabaseException;

    void countObsoleteDbInternal(DatabaseImpl db) {
        db.countObsoleteDb(envImpl.getUtilizationTracker(),
                           DbLsn.NULL_LSN /*mapLnLsn*/);
    }

    public abstract boolean removeDbFileSummary(DatabaseImpl db, Long fileNum)
        throws DatabaseException;

    boolean removeDbFileSummaryInternal(DatabaseImpl db, Long fileNum) {
        return db.removeDbFileSummary(fileNum);
    }

    public abstract void loadEndOfLogStat()
        throws DatabaseException;

    void loadEndOfLogStatInternal() {
        endOfLog.set(fileManager.getLastUsedLsn());
    }

    /* For unit testing only. */
    public void setReadHook(TestHook hook) {
        readHook = hook;
    }
}
