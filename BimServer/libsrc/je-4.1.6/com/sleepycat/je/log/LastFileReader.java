/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * LastFileReader traverses the last log file, doing checksums and looking for
 * the end of the log. Different log types can be registered with it and it
 * will remember the last occurrence of targeted entry types.
 */
public class LastFileReader extends FileReader {

    /* Log entry types to track. */
    private Set<LogEntryType> trackableEntries;

    private long nextUnprovenOffset;
    private long lastValidOffset;
    private LogEntryType entryType;

    /*
     * Last lsn seen for tracked types. Key = LogEntryType, data is the offset
     * (Long).
     */
    private Map<LogEntryType, Long> lastOffsetSeen;

    /**
     * This file reader is always positioned at the last file.
     *
     * If no valid files exist (and invalid files do not contain data and can
     * be moved away), we will not throw an exception.  We will return false
     * from the first call (all calls) to readNextEntry.
     *
     * @throws DatabaseException if the last file contains data and is invalid.
     */
    public LastFileReader(EnvironmentImpl envImpl,
                          int readBufferSize)
        throws DatabaseException {

        super(envImpl, readBufferSize, true, DbLsn.NULL_LSN, Long.valueOf(-1),
              DbLsn.NULL_LSN, DbLsn.NULL_LSN);

        try {
            startAtLastGoodFile(null /*singleFileNum*/);
        } catch (ChecksumException e) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_CHECKSUM, e);
        }

        trackableEntries = new HashSet<LogEntryType>();
        lastOffsetSeen = new HashMap<LogEntryType, Long>();

        lastValidOffset = 0;
        nextUnprovenOffset = nextEntryOffset;
    }

    /**
     * Ctor which allows passing in the file number we want to read to the end
     * of.  This is used by the ScavengerFileReader when it encounters a bad
     * log record in the middle of a file.
     *
     * @throws ChecksumException rather than wrapping it, to allow
     * ScavengerFileReader to handle it specially -- we should not invalidate
     * the environment with EnvironmentFailureException.
     */
    LastFileReader(EnvironmentImpl envImpl,
                   int readBufferSize,
                   Long specificFileNumber)
        throws ChecksumException, DatabaseException {

        super(envImpl, readBufferSize, true, DbLsn.NULL_LSN,
              specificFileNumber, DbLsn.NULL_LSN, DbLsn.NULL_LSN);

        startAtLastGoodFile(specificFileNumber);

        trackableEntries = new HashSet<LogEntryType>();
        lastOffsetSeen = new HashMap<LogEntryType, Long>();

        lastValidOffset = 0;
        nextUnprovenOffset = nextEntryOffset;
    }

    /**
     * Initialize starting position to the last file with a complete header
     * with a valid checksum.
     */
    private void startAtLastGoodFile(Long singleFileNum)
        throws ChecksumException {

        eof = false;
        window.initAtFileStart(DbLsn.makeLsn(0, 0));

        /*
         * Start at what seems like the last file. If it doesn't exist, we're
         * done.
         */
        Long lastNum = ((singleFileNum != null) &&
                        (singleFileNum.longValue() >= 0)) ?
            singleFileNum :
            fileManager.getLastFileNum();
        FileHandle fileHandle = null;

        long fileLen = 0;
        while ((fileHandle == null) && !eof) {
            if (lastNum == null) {
                eof = true;
            } else {
                try {
                    try {
                        window.initAtFileStart(DbLsn.makeLsn(lastNum, 0));
                        fileHandle = fileManager.getFileHandle(lastNum);

                        /*
                         * Check the size of this file. If it opened
                         * successfully but only held a header or is 0 length,
                         * backup to the next "last" file unless this is the
                         * only file in the log. Note that an incomplete header
                         * will end up throwing a checksum exception, but a 0
                         * length file will open successfully in read only
                         * mode.
                         */
                        fileLen = fileHandle.getFile().length();
                        if (fileLen <= FileManager.firstLogEntryOffset()) {
                            lastNum = fileManager.getFollowingFileNum
                                (lastNum, false);
                            if (lastNum != null) {
                                fileHandle.release();
                                fileHandle = null;
                            }
                        }
                    } catch (DatabaseException e) {
                        lastNum = attemptToMoveBadFile(e);
                        fileHandle = null;
                    } catch (ChecksumException e) {
                        lastNum = attemptToMoveBadFile(e);
                        fileHandle = null;
                    } finally {
                        if (fileHandle != null) {
                            fileHandle.release();
                        }
                    }
                } catch (IOException e) {
                    throw new EnvironmentFailureException
                        (envImpl, EnvironmentFailureReason.LOG_READ, e);
                }
            }
        }

        nextEntryOffset = 0;
    }

    /**
     * Something is wrong with this file. If there is no data in this file (the
     * header is <= the file header size) then move this last file aside and
     * search the next "last" file. If the last file does have data in it,
     * return null and throw an exception back to the application, since we're
     * not sure what to do now.
     *
     * @param cause is a DatabaseException or ChecksumException.
     */
    private Long attemptToMoveBadFile(Exception cause)
        throws IOException, ChecksumException, DatabaseException {

        String fileName = 
            fileManager.getFullFileNames(window.currentFileNum())[0];
        File problemFile = new File(fileName);

        if (problemFile.length() <= FileManager.firstLogEntryOffset()) {
            fileManager.clear(); // close all existing files
            /* Move this file aside. */
            Long lastNum = fileManager.getFollowingFileNum
                (window.currentFileNum(), false);
            if (!fileManager.renameFile(window.currentFileNum(),
                                        FileManager.BAD_SUFFIX)) {
                throw EnvironmentFailureException.unexpectedState
                    ("Could not rename file: 0x" +
                      Long.toHexString(window.currentFileNum()));
            }

            return lastNum;
        }
        /* There's data in this file, throw up to the app. */
        if (cause instanceof DatabaseException) {
            throw (DatabaseException) cause;
        }
        if (cause instanceof ChecksumException) {
            throw (ChecksumException) cause;
        }
        throw EnvironmentFailureException.unexpectedException(cause);
    }

    public void setEndOfFile()
        throws IOException, DatabaseException {

        fileManager.truncateLog(window.currentFileNum(), nextUnprovenOffset);
    }

    /**
     * @return The LSN to be used for the next log entry.
     */
    public long getEndOfLog() {
        return DbLsn.makeLsn(window.currentFileNum(), nextUnprovenOffset);
    }

    public long getLastValidLsn() {
        return DbLsn.makeLsn(window.currentFileNum(), lastValidOffset);
    }

    public long getPrevOffset() {
        return lastValidOffset;
    }

    public LogEntryType getEntryType() {
        return entryType;
    }

    /**
     * Tell the reader that we are interested in these kind of entries.
     */
    public void setTargetType(LogEntryType type) {
        trackableEntries.add(type);
    }

    /**
     * @return The last LSN seen in the log for this kind of entry, or null.
     */
    public long getLastSeen(LogEntryType type) {
        Long typeNumber =lastOffsetSeen.get(type);
        if (typeNumber != null) {
            return DbLsn.makeLsn(window.currentFileNum(), 
                                 typeNumber.longValue());
        } else {
            return DbLsn.NULL_LSN;
        }
    }

    /**
     * Validate the checksum on each entry, see if we should remember the LSN
     * of this entry.
     */
    protected boolean processEntry(ByteBuffer entryBuffer) {

        /* Skip over the data, we're not doing anything with it. */
        entryBuffer.position(entryBuffer.position() +
                             currentEntryHeader.getItemSize());

        /* If we're supposed to remember this lsn, record it. */
        entryType = new LogEntryType(currentEntryHeader.getType());
        if (trackableEntries.contains(entryType)) {
            lastOffsetSeen.put(entryType, Long.valueOf(currentEntryOffset));
        }

        return true;
    }

    /**
     * readNextEntry will stop at a bad entry.
     * @return true if an element has been read.
     */
    @Override
    public boolean readNextEntry() {

        boolean foundEntry = false;

        try {

            /*
             * At this point,
             *  currentEntryOffset is the entry we just read.
             *  nextEntryOffset is the entry we're about to read.
             *  currentEntryPrevOffset is 2 entries ago.
             * Note that readNextEntry() moves all the offset pointers up.
             */

            foundEntry = super.readNextEntryAllowExceptions();

            /*
             * Note that initStartingPosition() makes sure that the file header
             * entry is valid.  So by the time we get to this method, we know
             * we're at a file with a valid file header entry.
             */
            lastValidOffset = currentEntryOffset;
            nextUnprovenOffset = nextEntryOffset;
        } catch (FileNotFoundException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_FILE_NOT_FOUND, e);
        } catch (ChecksumException e) {
            LoggerUtils.fine
                (logger, envImpl,  
                 "Found checksum exception while searching for end of log. " +
                 "Last valid entry is at " + DbLsn.toString
                 (DbLsn.makeLsn(window.currentFileNum(), lastValidOffset)) +
                 " Bad entry is at " +
                 DbLsn.makeLsn(window.currentFileNum(), nextUnprovenOffset));
        }
        return foundEntry;
    }
}
