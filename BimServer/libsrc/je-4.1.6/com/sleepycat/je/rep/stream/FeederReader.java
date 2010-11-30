/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.ChecksumException;
import com.sleepycat.je.log.FileHandle;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.log.LogBuffer;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogItem;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.vlsn.VLSNIndex;
import com.sleepycat.je.rep.vlsn.VLSNRange;
import com.sleepycat.je.rep.vlsn.VLSNIndex.ForwardVLSNScanner;
import com.sleepycat.je.rep.vlsn.VLSNIndex.WaitTimeOutException;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.VLSN;

/**
 * The FeederReader is a flavor of VLSNReader which supports replication
 * stream feeding. It assumes that reading will always go forward in the log.
 * Special features are:
 *
 * - The reader can read either from a log buffer or from the file. Sometimes
 *   log entries are logged but are not yet available on disk. In general, it's
 *   better to read from the log buffers rather then the file.
 *
 * - The reader can block for a given time period, waiting for the next vlsn to
 *    appear
 */
public class FeederReader extends VLSNReader {

    /* The scanner is a cursor over the VLSNIndex. */
    private final ForwardVLSNScanner scanner;

    /* The reader has never been used before, it needs to be initialized. */
    private boolean initDone = false;

    /* 
     * A constantly resetting counter of hits in the log item cache. This
     * serves as state that lets the FeederReader know that its position in the
     * log files might have become stale, due to cache hits. Because it's reset
     * midstream, it is not an accurate statistics for cache hits.
     */
    private long prevCacheHits = 0;

    /*
     * If true, the FeederReader will always read directly from the log, and
     * will not use the vlsnIndex LogItem cache. Should only be used for
     * unit tests!
     */
    private final boolean bypassCache;

    public FeederReader(EnvironmentImpl envImpl,
                        VLSNIndex vlsnIndex,
                        long startLsn,
                        int readBufferSize,
                        NameIdPair nameIdPair) {

        this(envImpl, vlsnIndex, startLsn, readBufferSize, nameIdPair, 
             false /*bypassCache*/);
    }
    
    /**
     * For unit testing only!! Bypass the VLSNIndex cache, provide a node name.
     */
    FeederReader(EnvironmentImpl envImpl,
                 VLSNIndex vlsnIndex,
                 long startLsn,
                 int readBufferSize) {

        this(envImpl, vlsnIndex, startLsn, readBufferSize, 
             new NameIdPair("test Node", 0),
             true /*bypassCache*/);
    }

    private FeederReader(EnvironmentImpl envImpl,
                         VLSNIndex vlsnIndex,
                         long startLsn,
                         int readBufferSize,
                         NameIdPair nameIdPair,
                         boolean bypassCache) {
        super(envImpl,
              vlsnIndex,
              true,            // forward
              startLsn,
              readBufferSize,
              nameIdPair,
              DbLsn.NULL_LSN); // finishLsn

        scanner = new ForwardVLSNScanner(vlsnIndex);
        this.bypassCache = bypassCache;
    }

    /**
     * Use a ReadWindow which can read from LogBuffers as well as the physical
     * file.
     * @throws DatabaseException
     */
    @Override
    protected ReadWindow makeWindow(int readBufferSize) {

        return new SwitchWindow(readBufferSize, envImpl);
    }

    /**
     * Set up the FeederReader to start scanning from this VLSN. If we find a
     * mapping for this VLSN, we'll start precisely at its LSN, else we'll have
     * to start from an earlier location. This initialization can't be done in
     * the constructor, because the Feeder is set up to require the
     * construction of the source before we know where to start.
     *
     * @throws IOException
     */
    public void initScan(VLSN startVLSN)
        throws IOException {

        if (startVLSN.equals(VLSN.NULL_VLSN)) {
            throw EnvironmentFailureException.unexpectedState
                ("startVLSN can't be null");
        }

        VLSNRange currentRange = vlsnIndex.getRange();
        VLSN startPoint = startVLSN;
        if (currentRange.getLast().compareTo(startVLSN) < 0) {
            /*
             * When feeding, we may be starting at the VLSN following the last
             * VLSN in the node.
             */
            startPoint = currentRange.getLast();
        }

        startLsn = scanner.getStartingLsn(startPoint);
        assert startLsn != DbLsn.NULL_LSN;

        window.initAtFileStart(startLsn);
        nextEntryOffset = window.getEndOffset();
        currentVLSN = startVLSN;

        initDone = true;
    }

    /**
     * Forward scanning for feeding the replica: get the log record for this
     * VLSN. If the log record hasn't been created yet, wait for a period
     * specified by "waitTime".
     *
     * Where possible, the FeederReader fetches the log record from the cache
     * within the VLSNIndex. (See the VLSNIndex for a description of this two
     * level cache). If the requested VLSN is not available from the cache, the
     * reader fetches the item from the JE log -- either from the log buffers
     * or from disk.
     *
     * The FeederReader is like a cursor on the log, and retains a position
     * in the log.  When there are log item cache hits, the FeederReader's 
     * position can fall behind, because it is being bypassed. It is possible
     * for log cleaning to take place between the point of the FeederReader's
     * stale position and the end of the log. If so, the FeederReader must
     * not attempt to scan from its current position, because it might
     * run afoul of gap created by the cleaned and delete log files. When
     * there have been log item cache hits, the FeederReader must jump its
     * position forward using the vlsnIndex mappings to safely skip over 
     * any cleaned gaps in the log.
     */
    public OutputWireRecord scanForwards(VLSN vlsn, int waitTime)
        throws InterruptedException {

        assert initDone;

        LogItem logItem = null;

        try {
            logItem = vlsnIndex.waitForVLSN(vlsn, waitTime);
        } catch (WaitTimeOutException e) {
            /* This vlsn not yet available */
            return null;
        }

        currentVLSN = vlsn;

        if ((logItem != null) && (!bypassCache)) {

            /* We've found the requested log item in the cache. */
            assert logItem.getHeader().getVLSN().equals(vlsn);
            prevCacheHits++;
            return new OutputWireRecord(logItem);
        }

        /*
         * We must go to the log for this requested VLSN. Use the VLSNIndex for
         * the closest position in the log file to find the next replicated log
         * entry.
         *
         * If there are no cache hits and the reader has been supplying log
         * entries sequentially, we know that it is already positioned at the
         * immediately preceding log entry and that we can scan from there to
         * the current requested record. In that case, we are only hoping that
         * the VLSNIndex can supply the exact location of the current requested
         * record in order to reduce the scanning.
         * 
         * If there have been cache hits, the reader's current position is some
         * unknown distance back. In that case, scanning from the current
         * position could run into a cleaned gap in the log files, and could
         * fail. Because of that, we must reposition to a VLSN that is <= to
         * the current requested VLSN. We know that such a VLSN must exist and
         * have a valid lsn mapping, because the begin and end point in the
         * vlsn range always exists.
         */
        long repositionLsn;
        if (prevCacheHits > 0) {
            repositionLsn = scanner.getApproximateLsn(vlsn);

            /* 
             * Guard against sliding the window backwards. This could happen if
             * by dint of previous scans, the reader is fortuitously positioned
             * at a point in the log that is before the current target VLSN,
             * but after any available mappings. For example, suppose the
             * VLSNIndex has VLSNs 10, 50, 100. Suppose the reader is
             * positioned at VLSN 20, and we have supplied VLSNs 21->40 from
             * the cache.  VLSN 41 has not hit in the cache, and we must fetch
             * the log record from disk. We do not want to slide the
             * FeederReader from its current position at 21 back to VLSN 10.
             */
            if (DbLsn.compareTo(getLastLsn(), repositionLsn) >= 0) {
                repositionLsn = DbLsn.NULL_LSN;
            }
        } else {
            repositionLsn = scanner.getPreciseLsn(vlsn);
        }

        /* 
         * We're going to start scanning, so reset the prevCacheHits field, and
         * position the reader at the optimal spot.
         */
        prevCacheHits = 0;
        try {
            /* setPosition is a noop if repositionLsn is false. */
            setPosition(repositionLsn);
        } catch (ChecksumException e) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.LOG_CHECKSUM,
                 "trying to reposition FeederReader to " +
                 DbLsn.getNoFormatString(repositionLsn) + " prevWindow=" +
                 window, e);
        } catch (FileNotFoundException e) {

            /* 
             * This is not necessarily a durable error. This could be a
             * problem with the feeder reader state, and therefore it could
             * be transient. Do not invalidate the environment.
             */
            throw EnvironmentFailureException.unexpectedException
                ("Trying to reposition FeederReader to " +
                 DbLsn.getNoFormatString(repositionLsn) + " prevWindow=" +
                 window, e);
        }
            
        if (readNextEntry()) {
            return currentFeedRecord;
        }

        throw EnvironmentFailureException.unexpectedState
            (envImpl, "VLSN=" + vlsn + " repositionLsn = " + 
             DbLsn.getNoFormatString(repositionLsn) + window);
    }

    /**
     * @throw an EnvironmentFailureException if we were scanning for a
     * particular VLSN and we have passed it by.
     */
    private void checkForPassingTarget(int compareResult) {
        if (compareResult > 0) {
            /* Hey, we passed the VLSN we wanted. */
            throw EnvironmentFailureException.unexpectedState
                ("want to read " + currentVLSN + " but reader at " +
                 currentEntryHeader.getVLSN());
        }
    }

    /**
     * Return true if this entry is replicated and its VLSN is currentVLSN.
     */
    @Override
    protected boolean isTargetEntry() {
        nScanned++;

        if (currentEntryHeader.isInvisible()) {
            return false;
        }

        if (entryIsReplicated()) {
            VLSN entryVLSN = currentEntryHeader.getVLSN();

            int compareResult = entryVLSN.compareTo(currentVLSN);
            checkForPassingTarget(compareResult);

            /* return true if this is the entry we want. */
            return (compareResult == 0);
        }

        return false;
    }

    /**
     * The SwitchWindow can fill itself from either the log file or the log
     * buffers.
     */
    static class SwitchWindow extends ReadWindow {

        private final LogManager logManager;

        SwitchWindow(int readBufferSize, EnvironmentImpl envImpl) {
            super(readBufferSize, envImpl);

            logManager = envImpl.getLogManager();
        }

        /*
         * Reposition to the specified file, and fill starting at
         * targetOffset. For this use case, we are always going forwards, and
         * windowStartOffset should == targetOffset. Position the window's
         * buffer to point at the log entry indicated by targetOffset
         */
        @Override
            public void slideAndFill(long windowFileNum,
                                     long windowStartOffset,
                                     long targetOffset)
            throws ChecksumException,
                   FileNotFoundException,
                   DatabaseException {

            if (!fillFromLogBuffer(windowFileNum, targetOffset)) {
                /* The entry was not in the LogBufferPool. */
                super.slideAndFill(windowFileNum,
                                   windowStartOffset,
                                   targetOffset);
            }
        }

        /**
         * Fill the read window's buffer from a LogBuffer.
         * @return true if the read window was filled.
         * @throws DatabaseException
         */
        private boolean fillFromLogBuffer(long windowFileNum,
                                          long targetOffset)
            throws DatabaseException {

            LogBuffer logBuffer = null;

            try {
                long fileLocation = DbLsn.makeLsn(windowFileNum, targetOffset);
                logBuffer = logManager.getReadBufferByLsn(fileLocation);
                if (logBuffer == null) {
                    return false;
                }

                /*
                 * Copy at much as we can of the logBuffer into the window's
                 * readBuffer. We don't call ByteBuffer.put(ByteBuffer) because
                 * the logBuffer may be larger than the window readBuffer, and
                 * we don't want to get an overflow. Instead, we convert to an
                 * array and carefully size the copy. A LogBuffer is positioned
                 * for writing, and hasn't yet been flipped.  LogManager.get()
                 * does an absolute retrieval of bytes from the buffer, because
                 * it knows that the log entry exists, and is only reading one
                 * entry. We need to flip the buffer, because we don't know
                 * apriori how much is in the buffer, and we want to scan it.
                 */

                /*
                 * Put the logBuffer's contents into wholeContents, and
                 * position wholeContents at the desired target offset. If
                 * this logBuffer had been the currentWriteBuffer, it's
                 * positioned for writing and must be flipped for reading.
                 */
                ByteBuffer wholeContents =
                    logBuffer.getDataBuffer().duplicate();
                if (wholeContents.position() != 0) {
                    wholeContents.flip();
                }
                long firstOffset =
                    DbLsn.getFileOffset(logBuffer.getFirstLsn());
                wholeContents.position((int) (targetOffset - firstOffset));

                /* Make a buffer which starts at target. */
                ByteBuffer startAtTarget = wholeContents.slice();
                byte[] data = startAtTarget.array();
                int availableContentLen = startAtTarget.limit();
                int copyLength =
                    (availableContentLen > readBuffer.capacity()) ?
                    readBuffer.capacity() : availableContentLen;

                readBuffer.clear();
                readBuffer.put(data, startAtTarget.arrayOffset(), copyLength);
                readBuffer.flip();

                /* LogBuffers were just written and use the current version. */
                setFileNum(windowFileNum, LogEntryType.LOG_VERSION);
                startOffset = targetOffset;
                endOffset = startOffset + readBuffer.limit();
                readBuffer.position(0);
                return true;
            } finally {
                if (logBuffer != null) {
                    logBuffer.release();
                }
            }
        }

        /**
         * Fill up the read buffer with more data, moving along to the
         * following file (next largest number) if needed. Unlike other file
         * readers, we are reading log files that are concurrently growing, so
         * this read window must also know to look in the log buffers. 
         *
         * The contract between the feeder reader and the VLSNIndex lets us
         * assume that the feeder reader is only active when it is sure that
         * there is more data available somewhere -- whether it's in the log
         * buffers, write queue, or on disk.
         *
         * @return true if the fill moved us to a new file.
         * @see ReadWindow#fillNext
         */
        @Override
            protected boolean fillNext(boolean singleFile, int bytesNeeded)
            throws ChecksumException, DatabaseException, EOFException {

            /*
             * The SwitchReadWindow should only be used for feeding, and
             * singleFile should never be true.
             */
            assert !singleFile;

            adjustReadBufferSize(bytesNeeded);

            /*
             * Try to fill the window by asking for the next offset from
             * the log buffers.
             */
            if (fillFromLogBuffer(currentFileNum(), endOffset)) {
                /* Didn't move to a new file. */
                return false;
            }

            /*
             * If that didn't work, there are these possible reasons why:
             * a - it's a valid offset, but it's no longer in a log buffer, it
             *     was written to disk.
             * b - it's not a valid offset, because the log file flipped.
             * In both cases, go to the FileManager and see if there's more log
             * to be found.
             */

            FileHandle fileHandle = null;
            try {

                /* Get a file handle to read in more log. */
                fileHandle = fileManager.getFileHandle(currentFileNum());

                /* Attempt to read more from this file. */
                startOffset = endOffset;
                if (fillFromFile(fileHandle, startOffset)) {
                    /* 
                     * Successfully filled the read buffer, but didn't move to 
                     * a new file. 
                     */
                    return false; 
                } 

                fileHandle.release();
                fileHandle = null;

                /* This file is done -- can we read in the next file? */
                if (singleFile) {
                    throw new EOFException();
                }

                /*
                 * Remember that the nextFile may not be fileNum + 1 if
                 * there has been log cleaning.
                 */
                Long nextFile =
                    fileManager.getFollowingFileNum(currentFileNum(),
                                                    true /* forward */);

                /*
                 * But if there's no next file, let's assume that the desired
                 * data is still in the log buffers, and the next lsn is the
                 * first entry in the subsequent file number.  Start the read
                 * from the first real log entry, because the file header entry
                 * is not in the log buffers.
                 */
                if (nextFile == null) {
                    nextFile = currentFileNum() + 1;
                }

                if (fillFromLogBuffer(nextFile,
                                      FileManager.firstLogEntryOffset())) {
                    /*
                     * We filled the read buffer, and jumped to a new
                     * file.
                     */
                    return true;
                }

                /*
                 * Didn't find the next bytes in the log buffer, go look on
                 * disk.
                 */
                fileHandle = fileManager.getFileHandle(nextFile);
                setFileNum(nextFile, fileHandle.getLogVersion());
                startOffset = 0;
                boolean moreData = fillFromFile(fileHandle, 0);
                assert moreData : 
                   "FeederReader should find more data in next file";
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                throw EnvironmentFailureException.unexpectedException
                    ("Problem in ReadWindow.fill, reading from  = " +
                     currentFileNum(), e);

            } finally {
                if (fileHandle != null) {
                    fileHandle.release();
                }
            }
        }
    }

    /* For debugging */
    String dumpState() {
        return "prevCacheHits=" + prevCacheHits + " " + window;
    }
}
