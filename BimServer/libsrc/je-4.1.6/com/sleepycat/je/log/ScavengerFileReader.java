/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.utilint.DbLsn;

/**
 * A ScavengerFileReader reads the log backwards.  If it encounters a checksum
 * error, it goes to the start of that log file and reads forward until it
 * encounters a checksum error.  It then continues the reading backwards in the
 * log.
 *
 * The caller may set "dumpCorruptedBounds" to true if information about the
 * start and finish of the corrupted portion should be displayed on stderr.
 *
 * The caller is expected to implement processEntryCallback. This method is
 * called once for each entry that the ScavengerFileReader finds in the log.
 */
abstract public class ScavengerFileReader extends FileReader {

    /* A Set of the entry type numbers that this FileReader should dump. */
    private Set<Byte> targetEntryTypes;

    private int readBufferSize;

    /* True if reader should write corrupted boundaries to System.err. */
    private boolean dumpCorruptedBounds;

    /**
     * Create this reader to start at a given LSN.
     */
    public ScavengerFileReader(EnvironmentImpl env,
                               int readBufferSize,
                               long startLsn,
                               long finishLsn,
                               long endOfFileLsn)
        throws DatabaseException {

        super(env,
              readBufferSize,
              false,
              startLsn,
              null, // single file number
              endOfFileLsn,
              finishLsn);

        this.readBufferSize = readBufferSize;

        /*
         * Indicate that a checksum error should not shutdown the whole
         * environment.
         */
        targetEntryTypes = new HashSet<Byte>();
        dumpCorruptedBounds = false;
    }

    /**
     * Set to true if corrupted boundaries should be dumped to stderr.
     */
    public void setDumpCorruptedBounds(boolean dumpCorruptedBounds) {
        this.dumpCorruptedBounds = dumpCorruptedBounds;
    }

    /**
     * Tell the reader that we are interested in these kind of entries.
     */
    public void setTargetType(LogEntryType type) {
        targetEntryTypes.add(Byte.valueOf(type.getTypeNum()));
    }

    /*
     * For each entry that is selected, just call processEntryCallback.
     */
    protected boolean processEntry(ByteBuffer entryBuffer)
        throws DatabaseException {

        LogEntryType lastEntryType =
            LogEntryType.findType(currentEntryHeader.getType());
        LogEntry entry = lastEntryType.getSharedLogEntry();
        entry.readEntry(currentEntryHeader, entryBuffer, true); // readFullItem
        processEntryCallback(entry, lastEntryType);
        return true;
    }

    /*
     * Method overriden by the caller.  Each entry of the types selected
     * is passed to this method.
     */
    abstract protected void processEntryCallback(LogEntry entry,
                                                 LogEntryType entryType)
        throws DatabaseException;

    /*
     * Read the next entry.  If a checksum exception is encountered, attempt
     * to find the other side of the corrupted area and try to re-read this
     * file.
     */
    @Override
    public boolean readNextEntry() {
        long saveCurrentEntryOffset = currentEntryOffset;
        try {
            return super.readNextEntryAllowExceptions();
        } catch (FileNotFoundException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_FILE_NOT_FOUND, e);
        } catch (ChecksumException e) {
            resyncReader(DbLsn.makeLsn(window.currentFileNum(),
                                       saveCurrentEntryOffset),
                         dumpCorruptedBounds);
            return super.readNextEntry();
        }
    }

    /*
     * A checksum error has been encountered.  Go to the start of this log file
     * and read forward until the lower side of the corrupted area has been
     * found.
     */
    @Override
    protected boolean resyncReader(long nextGoodRecordPostCorruption,
                                   boolean showCorruptedBounds)
        throws DatabaseException {

        LastFileReader reader = null;
        long tryReadBufferFileNum =
            DbLsn.getFileNumber(nextGoodRecordPostCorruption);

        while (tryReadBufferFileNum >= 0) {
            try {
                reader =
                    new LastFileReader(envImpl, readBufferSize,
                                       Long.valueOf(tryReadBufferFileNum));
                break;
            } catch (ChecksumException e) {

                /*
                 * We encountered a problem opening this file so skip to an
                 * earlier file.
                 */
                tryReadBufferFileNum--;
                continue;
            }
        }

        boolean switchedFiles = tryReadBufferFileNum !=
            DbLsn.getFileNumber(nextGoodRecordPostCorruption);

        if (!switchedFiles) {

            /*
             * Read forward until a checksum fails.  This reader will not throw
             * an exception if a checksum error is hit -- it will just return
             * false.
             */
            while (reader.readNextEntry()) {
            }
        }

        long lastUsedLsn = reader.getLastValidLsn();
        long nextAvailableLsn = reader.getEndOfLog();
        if (showCorruptedBounds) {
            System.err.println("A checksum error was found in the log.");
            System.err.println
                ("Corruption begins at LSN:\n   " +
                 DbLsn.toString(nextAvailableLsn));
            System.err.println
                ("Last known good record before corruption is at LSN:\n   " +
                 DbLsn.toString(lastUsedLsn));
            System.err.println
                ("Next known good record after corruption is at LSN:\n   " +
                 DbLsn.toString(nextGoodRecordPostCorruption));
        }

        startLsn = lastUsedLsn;
        initStartingPosition(nextAvailableLsn, null);
        if (switchedFiles) {
            currentEntryPrevOffset = 0;
        }
        /* Indicate resync is permitted so don't throw exception. */
        return true;
    }

    /**
     * @return true if this reader should process this entry, or just skip
     * over it.
     */
    @Override
    protected boolean isTargetEntry() {
        if (currentEntryHeader.isInvisible()) {

            /* 
             * This log entry is supposed to be effectivly truncated, so we
             * know this data is not alive.
             */
            return false;
        }

        if (targetEntryTypes.size() == 0) {
            /* We want to dump all entry types. */
            return true;
        } else {
            return targetEntryTypes.contains
                (Byte.valueOf(currentEntryHeader.getType()));
        }
    }
}
