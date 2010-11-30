/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.io.FileNotFoundException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * A FileReader is an abstract class that traverses the log files, reading in
 * chunks of the file at a time. Concrete subclasses perform a particular
 * action to each entry.
 */
public abstract class FileReader {

    protected final EnvironmentImpl envImpl;
    protected final FileManager fileManager;

    /*
     * The ReadWindow is a data buffer that acts as a sliding window view
     * of the log. It is positioned against the log and filled up with data.
     */
    protected final ReadWindow window;

    /* 
     * For piecing together a log entry that is read from multiple read buffer
     * calls.
     */
    private ByteBuffer saveBuffer;   

    private final boolean singleFile;// if true, do not read across files

    protected boolean eof;           // true if at end of the log.
                                     // TODO: assess whether this is redundant 
                                     // with the EOFException, and could be
                                     // streamlined.

    protected final boolean forward;   // if true, we're reading forward

    /* stats */
    private int nRead;           // num entries we've seen

    /* The log entry header for the entry that was just read. */
    protected LogEntryHeader currentEntryHeader;

    /*
     * The log entry before the current entry. In general,
     * currentEntryPrevOffset is the same as
     * currentEntryHeader.getPrevOffset(), but it's initialized and used before
     * a header is read. Only used for backward scanning.
     */
    protected long currentEntryPrevOffset;

    /*
     * nextEntryOffset is used to set the currentEntryOffset after we've read
     * an entry. Only used for forward scanning.
     */
    protected long currentEntryOffset;
    protected long nextEntryOffset;
    protected long startLsn;  // We start reading from this LSN.
    private final long finishLsn; // If going backwards, read up to this LSN.

    /* For checking checksum on the read. */
    protected ChecksumValidator cksumValidator;
    private boolean doChecksumOnRead;       // Validate checksums
    private boolean alwaysValidateChecksum; // Validate for all entry types

    protected final Logger logger;

    /**
     * A FileReader just needs to know what size chunks to read in.
     * @param endOfFileLsn indicates the end of the log file
     */
    public FileReader(EnvironmentImpl envImpl,
                      int readBufferSize,
                      boolean forward,
                      long startLsn,
                      Long singleFileNumber,
                      long endOfFileLsn,
                      long finishLsn)
        throws DatabaseException {

        this.envImpl = envImpl;
        this.fileManager = envImpl.getFileManager();
        this.singleFile = (singleFileNumber != null);
        this.forward = forward;

        this.doChecksumOnRead = envImpl.getLogManager().getChecksumOnRead();
        if (this.doChecksumOnRead) {
            cksumValidator = new ChecksumValidator();
        }

        window = makeWindow(readBufferSize);
        saveBuffer = ByteBuffer.allocate(readBufferSize);

        /* stats */
        nRead = 0;

        /* Determine the starting position. */
        this.startLsn = startLsn;
        this.finishLsn = finishLsn;

        logger = envImpl.getLogger();

        initStartingPosition(endOfFileLsn, singleFileNumber);
    }

    /**
     * May be overridden by other FileReaders.
     * @throws DatabaseException 
     */
    protected ReadWindow makeWindow(int readBufferSize) 
        throws DatabaseException {
        
        return new ReadWindow(readBufferSize, envImpl);
    }

    /**
     * Helper for determining the starting position and opening up a file at
     * the desired location.
     */
    protected void initStartingPosition(long endOfFileLsn,
                                        Long ignoreSingleFileNumber) {
        eof = false;
        if (forward) {

            /*
             * Start off at the startLsn. If that's null, start at the
             * beginning of the log. If there are no log files, set eof.
             */
            if (startLsn != DbLsn.NULL_LSN) {
                window.initAtFileStart(startLsn);
            } else {
                Long firstNum = fileManager.getFirstFileNum();
                if (firstNum == null) {
                    eof = true;
                } else {
                    window.initAtFileStart(DbLsn.makeLsn(firstNum, 0));
                }
            }

            /*
             * After we read the first entry, the currentEntry will point here.
             */
            nextEntryOffset = window.getEndOffset();
        } else {

            /*
             * Make the read buffer look like it's positioned off the end of
             * the file. Initialize the first LSN we want to read. When
             * traversing the log backwards, we always start at the very end.
             */
            assert startLsn != DbLsn.NULL_LSN;
            window.initAtFileStart(endOfFileLsn);

            /*
             * currentEntryPrevOffset points to the entry we want to start out
             * reading when going backwards. If it's 0, the entry we want to
             * read is in a different file.
             */
            if (DbLsn.getFileNumber(startLsn) ==
                DbLsn.getFileNumber(endOfFileLsn)) {
                currentEntryPrevOffset = DbLsn.getFileOffset(startLsn);
            } else {
                currentEntryPrevOffset = 0;
            }
            currentEntryOffset = DbLsn.getFileOffset(endOfFileLsn);
        }
    }

    /**
     * Whether to always validate the checksum, even for non-target entries.
     */
    public void setAlwaysValidateChecksum(boolean validate) {
        alwaysValidateChecksum = validate;
    }

    /**
     * @return the number of entries processed by this reader.
     */
    public int getNumRead() {
        return nRead;
    }

    public long getNRepeatIteratorReads() {
        return window.getNRepeatIteratorReads();
    }

    /**
     * Get LSN of the last entry read.
     */
    public long getLastLsn() {
        return DbLsn.makeLsn(window.currentFileNum(), currentEntryOffset);
    }

    /**
     * Returns the total size (including header) of the last entry read.
     */
    public int getLastEntrySize() {
        return currentEntryHeader.getSize() + currentEntryHeader.getItemSize();
    }

    /**
     * Scans the log files until either it has reached the end of the log or
     * has hit an invalid portion.
     *
     * @return true if an element has been read, false at end-of-log.
     *
     * @throws EnvironmentFailureException if a ChecksumException,
     * FileNotFoundException, or another internal problem occurs.
     */
    public boolean readNextEntry() {
        try {
            return readNextEntryAllowExceptions();
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
     * Variant of readNextEntry that throws FileNotFoundException and
     * ChecksumException, rather than wrapping them in an
     * EnvironmentFailureException and invalidating the enviornment.  This
     * allows users of this class (see cleaner.FileProcessor), and subclasses
     * that override readNextEntry (see ScavengerFileReader and
     * LastFileReader), to handle these exceptions specially.
     */
    public final boolean readNextEntryAllowExceptions()
        throws FileNotFoundException, ChecksumException {

        boolean foundEntry = false;
        try {
            while ((!eof) && (!foundEntry)) {

                /* Read the invariant portion of the next header. */
                getLogEntryInReadBuffer();
                ByteBuffer dataBuffer =
                    readData(LogEntryHeader.MIN_HEADER_SIZE,
                             true); // collectData

                readBasicHeader(dataBuffer);

                boolean isTarget;
                boolean isChecksumTarget;

                if (currentEntryHeader.isVariableLength()) {

                    /*
                     * For all variable length entries, init the checksum w/the
                     * invariant portion of the header, before we know whether
                     * the entry is a target for this reader.  This has
                     * to be done before we read the variable portion of the
                     * header, because readData() only guarantees that it
                     * returns a dataBuffer that contains the next bytes that
                     * are needed, and has no guarantee that it holds any bytes
                     * that were previously read. The act of calling
                     * readData() to obtain the optional portion may reset the
                     * dataBuffer, and nudge the invariant part of the header
                     * out of the buffer returned by readData()
                     */
                    startChecksum(dataBuffer);

                    int optionalPortionLen =
                        currentEntryHeader.getVariablePortionSize();
                    /* Load the optional part of the header into a buffer. */
                    dataBuffer = readData(optionalPortionLen, true);

                    /*
                     * Add to checksum while the buffer is positioned at
                     * the start of the new bytes.
                     */
                    addToChecksum(dataBuffer, optionalPortionLen);

                    /* Now read the optional bytes. */
                    currentEntryHeader.readVariablePortion(dataBuffer);

                    isTarget = isTargetEntry();
                    isChecksumTarget = (isTarget || alwaysValidateChecksum);
                } else {
                    isTarget = isTargetEntry();
                    isChecksumTarget = (isTarget || alwaysValidateChecksum);
                    startChecksum(dataBuffer, isChecksumTarget);
                }

                boolean collectData = (isChecksumTarget && doChecksumOnRead) ||
                    isTarget;

                /*
                 * Read in the body of the next entry. Note that even if this
                 * isn't a targeted entry, we have to move the buffer position
                 * along.
                 */
                dataBuffer = readData(currentEntryHeader.getItemSize(),
                                      collectData);

                /*
                 * We've read an entry. Move up our offsets if we're moving
                 * forward. If we're moving backwards, we set our offset before
                 * we read the header, because we knew where the entry started.
                 */
                if (forward) {
                    currentEntryOffset = nextEntryOffset;
                    nextEntryOffset +=
                        currentEntryHeader.getSize() +       // header size
                        currentEntryHeader.getItemSize();    // item size
                }

                /* Validate the log entry checksum. */
                validateChecksum(dataBuffer, isChecksumTarget);
                
                if (isTarget) {

                    /*
                     * For a target entry, call the subclass reader's
                     * processEntry method to do whatever we need with the
                     * entry.  It returns true if this entry is one that should
                     * be returned.  Note that some entries, although targeted
                     * and read, are not returned.
                     */
                    if (processEntry(dataBuffer)) {
                        foundEntry = true;
                        nRead++;
                    }
                } else if (collectData) {

                    /*
                     * For a non-target entry that was validated, the buffer is
                     * positioned at the start of the entry; skip over it.
                     */
                    threadSafeBufferPosition
                        (dataBuffer,
                         threadSafeBufferPosition(dataBuffer) +
                         currentEntryHeader.getItemSize());
                }
            }
        } catch (EOFException e) {
            eof = true;
        } catch (DatabaseException e) {
            eof = true;
            /* Report on error. */
            reportProblem(e);
            throw e;
        }

        return foundEntry;
    }

    private void reportProblem(Exception e) {

        StringBuilder sb = new StringBuilder();
        sb.append("Halted log file reading at file 0x").
            append(Long.toHexString(window.currentFileNum())).
            append(" offset 0x").
            append(Long.toHexString(nextEntryOffset)).
            append(" offset(decimal)=").
            append(nextEntryOffset).
            append(" prev=0x").
            append(Long.toHexString(currentEntryPrevOffset));

            if (currentEntryHeader != null) {
                LogEntryType problemType =
                    LogEntryType.findType(currentEntryHeader.getType());
            sb.append(":\nentry=").
                append(problemType).
                append("type=").
                append(currentEntryHeader.getType()).
                append(",version=").
                append(currentEntryHeader.getVersion()).
                append(")\nprev=0x").
                append(Long.toHexString(currentEntryPrevOffset)).
                append("\nsize=").
                append(currentEntryHeader.getItemSize()).
                append("\nNext entry should be at 0x").
                append(Long.toHexString(nextEntryOffset +
                                               currentEntryHeader.getSize() +
                                        currentEntryHeader.getItemSize()));
        }

        LoggerUtils.traceAndLogException
            (envImpl, "FileReader", "readNextEntry", sb.toString(), e);
    }

    protected boolean resyncReader(long nextGoodRecordPostCorruption,
                                   boolean dumpCorruptedBounds)
        throws DatabaseException {

        /* Resync not allowed for straight FileReader runs. */
        return false;
    }

    /**
     * Make sure that the start of the target log entry is in the header. 
     */
    private void getLogEntryInReadBuffer()
        throws ChecksumException,
               EOFException,
               FileNotFoundException,
               DatabaseException {

        /*
         * If we're going forward, because we read every byte sequentially,
         * we're always sure the read buffer is positioned at the right spot.
         * If we go backwards, we need to jump the buffer position. These
         * methods may be overridden by subclasses.
         */
        if (forward) {
            setForwardPosition();
        } else {
            setBackwardPosition();
        }
    }

    /**
     * Ensure that the next target is in the window. The default behavior is
     * that the next target is the next, following entry, so we can assume that
     * it's in the window.  All we have to do is to check if we've gone past
     * the specified end point.
     * @throws DatabaseException 
     * @throws FileNotFoundException 
     * @throws ChecksumException 
     */
    protected void setForwardPosition() 
        throws EOFException,
               DatabaseException, 
               ChecksumException, 
               FileNotFoundException {

        if (finishLsn != DbLsn.NULL_LSN) {
            /* The next log entry has passed the end LSN. */
            long nextLsn = DbLsn.makeLsn(window.currentFileNum(),
                                         nextEntryOffset);
            if (DbLsn.compareTo(nextLsn, finishLsn) >= 0) {
                throw new EOFException();
            }
        }
    }

    /**
     * Ensure that the next target is in the window. The default behavior is
     * that the next target is the next previous entry.
     * @throws DatabaseException 
     */
    protected void setBackwardPosition() 
        throws ChecksumException,
               FileNotFoundException,
               EOFException,
               DatabaseException {

        /*
         * currentEntryPrevOffset is the entry before the current entry.
         * currentEntryOffset is the entry we just read (or the end of the
         * file if we're starting out.
         */
        if ((currentEntryPrevOffset != 0) &&
            window.containsOffset(currentEntryPrevOffset)) {

            /* The next log entry has passed the start LSN. */
            long nextLsn = DbLsn.makeLsn(window.currentFileNum(),
                                         currentEntryPrevOffset);
            if (finishLsn != DbLsn.NULL_LSN) {
                if (DbLsn.compareTo(nextLsn, finishLsn) == -1) {
                    throw new EOFException("finish=" + 
                                           DbLsn.getNoFormatString(finishLsn) +
                                           "next=" + 
                                           DbLsn.getNoFormatString(nextLsn));
                }
            }

            /* This log entry starts in this buffer, just reposition. */
            window.positionBuffer(currentEntryPrevOffset);
        } else {

            /*
             * The start of the log entry is not in this read buffer so
             * we must fill the buffer again. 
             *
             * 1) The target log entry is in a different file from the
             * current window's file. Move the window to the previous
             * file and start the read from the target LSN.
             *
             * 2) The target log entry is the same file but the log entry
             * is larger than the read chunk size. Start the next read
             * buffer from the target LSN. It's going to take multiple
             * reads to get the log entry, and we might as well get as
             * much as possible.
             *
             * 3) In the same file, and the log entry fits within one
             * read buffer. Try to position the next buffer chunk so the
             * target entry is held within the buffer, all the way at the
             * end. That way, since we're reading backwards, there will be
             * more buffered data available for following reads.
             */
            long nextFile;
            long nextWindowStart;
            long nextTarget;

            if (currentEntryPrevOffset == 0) {
                /* Case 1: Go to another file. */
                currentEntryPrevOffset = fileManager.getFileHeaderPrevOffset
                    (window.currentFileNum());

                Long prevFileNum =
                    fileManager.getFollowingFileNum(window.currentFileNum(),
                                                    false);
                if (prevFileNum == null) {
                    throw new EOFException("No file following " +
                                           window.currentFileNum());
                }

                if (window.currentFileNum() - 
                    prevFileNum.longValue() != 1) {

                    if (!resyncReader(DbLsn.makeLsn
                                      (prevFileNum.longValue(),
                                       DbLsn.MAX_FILE_OFFSET),
                                      false)) {
                        throw new EnvironmentFailureException
                            (envImpl,
                             EnvironmentFailureReason.LOG_INTEGRITY,
                             "Cannot read backward over cleaned file" +
                             " from " + window.currentFileNum() +
                             " to " + prevFileNum);
                    }
                }

                nextFile = prevFileNum;
                nextWindowStart = currentEntryPrevOffset;
                nextTarget = currentEntryPrevOffset;
            } else if ((currentEntryOffset - currentEntryPrevOffset) >
                       window.capacity()) {

                /*
                 * Case 2: The entry is in the same file, but is bigger
                 * than one buffer. Position it at the front of the buffer.
                 */
                nextFile = window.currentFileNum();
                nextWindowStart = currentEntryPrevOffset;
                nextTarget = currentEntryPrevOffset;
            } else {

                /* 
                 * Case 3: In same file, but not in this buffer. The target
                 * entry will fit in one buffer.
                 */
                nextFile = window.currentFileNum();
                long newPosition = currentEntryOffset -
                    window.capacity();
                nextWindowStart = (newPosition < 0) ? 0 : newPosition;
                nextTarget = currentEntryPrevOffset;
            }

            /* The next log entry has passed the start LSN. */
            long nextLsn = DbLsn.makeLsn(nextFile,
                                         currentEntryPrevOffset);
            if (finishLsn != DbLsn.NULL_LSN) {
                if (DbLsn.compareTo(nextLsn, finishLsn) == -1) {
                    throw new EOFException("finish=" + 
                                           DbLsn.getNoFormatString(finishLsn) +
                                           " next=" +
                                           DbLsn.getNoFormatString(nextLsn));
                }
            }

            window.slideAndFill(nextFile, nextWindowStart, nextTarget);
        }

        /* The current entry will start at this offset. */
        currentEntryOffset = currentEntryPrevOffset;
    }

    /**
     * Read the basic log entry header, leaving the buffer mark at the
     * beginning of the checksummed header data.
     */
    private void readBasicHeader(ByteBuffer dataBuffer)
        throws ChecksumException, DatabaseException  {

        /* Read the header for this entry. */
        currentEntryHeader = new LogEntryHeader(dataBuffer, window.logVersion);

        /*
         * currentEntryPrevOffset is a separate field, and is not obtained
         * directly from the currentEntryHeader, because it is initialized and
         * used before any log entry was read.
         */
        currentEntryPrevOffset = currentEntryHeader.getPrevOffset();
    }

    /**
     * Reset the checksum validator and add the new header bytes. Assumes that
     * the data buffer is positioned just past the end of the invariant
     * portion of the log entry header.
     * @throws DatabaseException 
     */
    private void startChecksum(ByteBuffer dataBuffer) 
        throws ChecksumException {

        startChecksum(dataBuffer, true  /* isChecksumTarget */);
    }

    private void startChecksum(ByteBuffer dataBuffer, 
                               boolean isChecksumTarget)
        throws ChecksumException {

        if (!doChecksumOnRead) {
            return;
        }

        if (!isChecksumTarget) {
            return;
        }

        /* Clear out any previous data. */
        cksumValidator.reset();

        int originalPosition = threadSafeBufferPosition(dataBuffer);
        if (currentEntryHeader.isInvisible()) {

            /* 
             * Turn off invisibility so that the checksum will succeed. When
             * entries are made invisible, the checksum is not adjusted. Note
             * that the dataBuffer can leave the invisible bit transformed,
             * because the header has already been initialized, and this data
             * will never be read again.
             */
            LogEntryHeader.turnOffInvisible(dataBuffer, originalPosition -
                                            LogEntryHeader.MIN_HEADER_SIZE);
        }

        /* Position the buffer at the start of the data, after the checksum. */
        int headerSizeMinusChecksum =
            currentEntryHeader.getInvariantSizeMinusChecksum();
        int entryTypeStart = originalPosition - headerSizeMinusChecksum;
        threadSafeBufferPosition(dataBuffer, entryTypeStart);

        /* Load the validate with the header bytes. */
        cksumValidator.update(dataBuffer, headerSizeMinusChecksum);

        /* Move the data buffer back to the original position. */
        threadSafeBufferPosition(dataBuffer, originalPosition);
    }

    private void addToChecksum(ByteBuffer dataBuffer, int length) 
        throws ChecksumException {

        if (!doChecksumOnRead) {
            return;
        }

        cksumValidator.update(dataBuffer, length);
    }

    /**
     * Add the entry bytes to the checksum and check the value.  This method
     * must be called with the buffer positioned at the start of the entry.
     */
    private void validateChecksum(ByteBuffer dataBuffer, 
                                  boolean isChecksumTarget)
        throws ChecksumException {

        if (!doChecksumOnRead) {
            return;
        }

        if (!isChecksumTarget) {
            return;
        }

        cksumValidator.update(dataBuffer, currentEntryHeader.getItemSize());
        cksumValidator.validate(currentEntryHeader.getChecksum(),
                                window.currentFileNum(),
                                currentEntryOffset);
    }

    /**
     * Try to read a specified number of bytes.
     * @param amountToRead is the number of bytes we need
     * @param collectData is true if we need to actually look at the data.
     *  If false, we know we're skipping this entry, and all we need to
     *  do is to count until we get to the right spot.
     * @return a byte buffer positioned at the head of the desired portion,
     * or null if we reached eof.
     */
    private ByteBuffer readData(int amountToRead, boolean collectData)
        throws ChecksumException,
               EOFException,
               FileNotFoundException,
               DatabaseException {

        int alreadyRead = 0;
        ByteBuffer completeBuffer = null;
        saveBuffer.clear();

        while ((alreadyRead < amountToRead) && !eof) {

            int bytesNeeded = amountToRead - alreadyRead;
            if (window.hasRemaining()) {

                /* There's data in the window, process it. */
                if (collectData) {

                    /*
                     * Save data in a buffer for processing.
                     */
                    if ((alreadyRead > 0) ||
                        (window.remaining() < bytesNeeded)) {

                        /* We need to piece an entry together. */
                        copyToSaveBuffer(bytesNeeded);
                        alreadyRead = threadSafeBufferPosition(saveBuffer);
                        completeBuffer = saveBuffer;
                    } else {

                        /* A complete entry is available in this buffer. */
                        completeBuffer = window.getBuffer();
                        alreadyRead = amountToRead;
                    }
                } else {

                    /*
                     * We're not processing the data, so need to save it. just
                     * move buffer positions.
                     */
                    int positionIncrement =
                        (window.remaining() > bytesNeeded) ?
                        bytesNeeded : window.remaining();

                    alreadyRead += positionIncrement;
                    window.incrementBufferPosition(positionIncrement);
                    completeBuffer = window.getBuffer();
                }
            } else {

                /*
                 * Look for more data.
                 */
                if (window.fillNext(singleFile, bytesNeeded)) {
                    /* This call to fillNext slid the window to a new file. */
                    nextEntryOffset = 0;
                }
            }
        }

        /* Flip the save buffer just in case we've been accumulating in it. */
        threadSafeBufferFlip(saveBuffer);

        return completeBuffer;
    }

    /**
     * Copy the required number of bytes into the save buffer.
     */
    private void copyToSaveBuffer(int bytesNeeded) {
        /* How much can we get from this current read buffer? */
        int bytesFromThisBuffer;

        if (bytesNeeded <= window.remaining()) {
            bytesFromThisBuffer = bytesNeeded;
        } else {
            bytesFromThisBuffer = window.remaining();
        }

        /* Gather it all into this save buffer. */
        ByteBuffer temp;

        /* Make sure the save buffer is big enough. */
        if (saveBuffer.capacity() - threadSafeBufferPosition(saveBuffer) <
            bytesFromThisBuffer) {
            /* Grow the save buffer. */
            temp = ByteBuffer.allocate(saveBuffer.capacity() +
                                       bytesFromThisBuffer);
            threadSafeBufferFlip(saveBuffer);
            temp.put(saveBuffer);
            saveBuffer = temp;
        }

        /*
         * Bulk copy only the required section from the read buffer into the
         * save buffer. We need from readBuffer.position() to
         * readBuffer.position() + bytesFromThisBuffer
         */
        temp = window.getBuffer().slice();
        temp.limit(bytesFromThisBuffer);
        saveBuffer.put(temp);
        window.incrementBufferPosition(bytesFromThisBuffer);
    }

    /**
     * Returns the number of reads since the last time this method was called.
     */
    public int getAndResetNReads() {
        return window.getAndResetNReads();
    }

    /**
     * @return true if this reader should process this entry, or just
     * skip over it.
     * @throws DatabaseException from subclasses.
     */
    protected boolean isTargetEntry()
        throws DatabaseException {

        return true;
    }

    /**
     * Each file reader implements this method to process the entry data.
     * @param entryBuffer contains the entry data and is positioned at the
     * data
     * @return true if this entry should be returned
     */
    protected abstract boolean processEntry(ByteBuffer entryBuffer)
        throws DatabaseException;

    /**
     * Never seen by user, used to indicate that the file reader should stop.
     */
    @SuppressWarnings("serial")
    public static class EOFException extends Exception {
        public EOFException() {
            super();
        }

        /* 
         * @param message The message is used to hold debugging 
         * information.
         */
        public EOFException(String message) {
            super(message);
        }
    }

    /**
     * @return true if the current entry has a VLSN 
     */
    public boolean entryIsReplicated() {

        if (currentEntryHeader == null) {
            throw EnvironmentFailureException.unexpectedState
                ("entryIsReplicated should not be used before reader is " +
                 "initialized");
        } 
        return currentEntryHeader.getReplicated();
    }

    /**
     * Note that we catch Exception here because it is possible that
     * another thread is modifying the state of buffer simultaneously.
     * Specifically, this can happen if another thread is writing this log
     * buffer out and it does (e.g.) a flip operation on it.  The actual
     * mark/pos of the buffer may be caught in an unpredictable state.  We
     * could add another latch to protect this buffer, but that's heavier
     * weight than we need.  So the easiest thing to do is to just retry
     * the duplicate operation.  See [#9822].
     */
    static Buffer threadSafeBufferFlip(ByteBuffer buffer) {
        while (true) {
            try {
                return buffer.flip();
            } catch (IllegalArgumentException IAE) {
                continue;
            }
        }
    }

    static int threadSafeBufferPosition(ByteBuffer buffer) {
        while (true) {
            try {
                return buffer.position();
            } catch (IllegalArgumentException IAE) {
                continue;
            }
        }
    }

    static Buffer threadSafeBufferPosition(ByteBuffer buffer,
                                           int newPosition) {
        assert (newPosition >= 0) : "illegal new position=" + newPosition;
        while (true) {
            try {
                return buffer.position(newPosition);
            } catch (IllegalArgumentException IAE) {
                if (newPosition > buffer.capacity()) {
                    throw IAE;
                }
                continue;
            }
        }
    }

    /**
     * A ReadWindow provides a swathe of data read from the JE log. 
     */
    protected static class ReadWindow {

        /*
         * fileNum, startOffset and endOffset indicate how the read buffer maps
         * to the JE log. For example, if the read buffer size is 200 and the
         * read buffer was filled from file 9, starting at byte 100, then:
         *          fileNum = 9
         *          startOffset = 100
         *          endOffset = 300
         * Note that the end point is not inclusive; endOffset is > the
         * readBuffer's end.
         */
        private long fileNum;      // file number we're pointing to
        private int logVersion;    // log version for fileNum/readBuffer
        protected long startOffset;// file offset that maps to buf start
        protected long endOffset;  // file offset that maps to buf end
        protected ByteBuffer readBuffer;   // buffer for reading from the file

        /* read buffer can't grow larger than this */
        private final int maxReadBufferSize;   

        protected final EnvironmentImpl envImpl;
        protected final FileManager fileManager;

        /*
         * The number of times we've tried to read in a log entry that was too
         * large for the read buffer.
         */
        private long nRepeatIteratorReads;

        /* Number of reads since the last time getAndResetNReads was called. */
        private int nReadOperations;

        protected ReadWindow(int readBufferSize, EnvironmentImpl envImpl) {
            DbConfigManager configManager = envImpl.getConfigManager();
            maxReadBufferSize =
                configManager.getInt(EnvironmentParams.LOG_ITERATOR_MAX_SIZE);
            this.envImpl = envImpl;
            fileManager = envImpl.getFileManager();

            readBuffer = ByteBuffer.allocate(readBufferSize);
            threadSafeBufferFlip(readBuffer);
        }

        /* 
         * Position this window at this LSN, but leave it empty, it has no data
         * yet.
         */
        public void initAtFileStart(long startLsn) {
            setFileNum(DbLsn.getFileNumber(startLsn),
                       LogEntryType.UNKNOWN_FILE_HEADER_VERSION);
            startOffset = DbLsn.getFileOffset(startLsn);
            endOffset = startOffset;
        }

        public long getEndOffset() {
            return endOffset;
        }        

        /**
         * Ensure that whenever we change the fileNum, the logVersion is also
         * updated.  The fileNum and logVersion fields should be kept private.
         */
        protected void setFileNum(final long fileNum, final int logVersion) {
            this.fileNum = fileNum;
            this.logVersion = logVersion;
        }

        public long currentFileNum() {
            return fileNum;
        }

        /* Return true if this offset is contained with the readBuffer. */
        boolean containsOffset(long targetOffset) {
            return (targetOffset >= startOffset) &&
                (targetOffset < endOffset);
        }

        /* Return true if this lsn  is contained with the readBuffer. */
        public boolean containsLsn(long targetFileNumber, long targetOffset) {
            return ((fileNum == targetFileNumber) &&
                    containsOffset(targetOffset));
        }

        /* Position the readBuffer to the targetOffset. */
        public void positionBuffer(long targetOffset) {

            assert containsOffset(targetOffset) : this + " doesn't contain " +
                DbLsn.getNoFormatString(targetOffset);

            threadSafeBufferPosition(readBuffer,
                                     (int) (targetOffset - startOffset));
        }

        /* Move the readBuffer position up by the given increment. */
        void incrementBufferPosition(int increment) {
            int currentPosition = threadSafeBufferPosition(readBuffer);
            threadSafeBufferPosition(readBuffer,
                                     currentPosition + increment);
        }

        /* 
         * Reposition to the specified file, and fill starting at
         * startOffset. Position the window's buffer to point at the log entry
         * indicated by targetOffset
         */
        public void slideAndFill(long windowfileNum, 
                                 long windowStartOffset, 
                                 long targetOffset)
            throws ChecksumException,
                   FileNotFoundException,
                   DatabaseException {

            FileHandle fileHandle = fileManager.getFileHandle(windowfileNum);
            try {
                startOffset = windowStartOffset;
                setFileNum(windowfileNum, fileHandle.getLogVersion());
                fillFromFile(fileHandle, targetOffset);
            } finally {
                fileHandle.release();
            }
        }

        /**
         * Fill up the read buffer with more data, moving along to the
         * following file (next largest number) if needed.
         * @return true if the fill moved us to a new file.
         */
        protected boolean fillNext(boolean singleFile, int bytesNeeded)
            throws ChecksumException,
                   FileNotFoundException,
                   EOFException,
                   DatabaseException {

            adjustReadBufferSize(bytesNeeded);

            FileHandle fileHandle = null;
            try {
                /* Get a file handle to read in more log. */
                fileHandle = fileManager.getFileHandle(fileNum);

                /*
                 * Check to see if we've come to the end of the file.  If so,
                 * get the next file.
                 */
                startOffset = endOffset;
                if (fillFromFile(fileHandle, startOffset)) {
                    /* 
                     * Successfully filled the read buffer, but didn't move to 
                     * a new file. 
                     */
                    return false; 
                }

                /* This file is done -- can we read in the next file? */
                if (singleFile) {
                    throw new EOFException("Single file only");
                }

                Long nextFile = 
                    fileManager.getFollowingFileNum(fileNum, 
                                                    true /* forward */);

                if (nextFile == null) {
                    throw new EOFException();
                }
                    
                fileHandle.release();
                fileHandle = null;
                fileHandle = fileManager.getFileHandle(nextFile);
                setFileNum(nextFile, fileHandle.getLogVersion());
                startOffset = 0;
                fillFromFile(fileHandle, 0);
                return true;
            } finally {
                if (fileHandle != null) {
                    fileHandle.release();
                }
            }
        }

        /* 
         * Assume that the window is properly positioned. Try to fill the read
         * buffer with data from this file handle, starting at the location
         * indicated by the starting offset field. If this file contains more
         * data, return true. If this file doesn't contain more data, return
         * false.
         *
         * In all cases, leave the the read buffer pointing at the target
         * offset and in a state that's ready to support reads, even if there
         * is nothing in the buffer. Note that the target offset, which may not
         * be the same as starting offset.
         * @return true if more data was read, false if not.         
         */
        protected boolean fillFromFile(FileHandle fileHandle, 
                                       long targetOffset) 
            throws DatabaseException {

            boolean foundData = false;
            readBuffer.clear();
            if (fileManager.readFromFile(fileHandle.getFile(), 
                                         readBuffer,
                                         startOffset,
                                         fileHandle.getFileNum(),
                                         false /* dataKnownToBeInFile */)) {
                foundData = true;
                nReadOperations += 1;
                /*
                 * Ensure that fileNum and logVersion are in sync.  setFileNum
                 * handles changes in the file number.  But we must also update
                 * the logVersion here to handle the first read after we
                 * initialize fileNum and logVersion is unknown.
                 */
                logVersion = fileHandle.getLogVersion();
            }

            /* 
             * In all cases, setup read buffer for valid reading. If the buffer
             * has no data, it will be positioned at the beginning, and will be
             * able to correctly return the fact that there is no data present.
             */

            endOffset = startOffset + threadSafeBufferPosition(readBuffer);
            threadSafeBufferFlip(readBuffer);
            threadSafeBufferPosition(readBuffer, 
                                     (int) (targetOffset - startOffset));
            return foundData;
        }

        /**
         * Change the read buffer size if we start hitting large log entries so
         * we don't get into an expensive cycle of multiple reads and piecing
         * together of log entries.  
         */
        protected void adjustReadBufferSize(int amountToRead) {

            int readBufferSize = readBuffer.capacity();

            /* 
             * We need to read something larger than the current buffer
             * size. 
             */
            if (amountToRead > readBufferSize) {

                /* We're not at the max yet. */
                if (readBufferSize < maxReadBufferSize) {

                    /*
                     * Make the buffer the minimum of amountToRead or a
                     * maxReadBufferSize.
                     */
                    if (amountToRead < maxReadBufferSize) {
                        readBufferSize = amountToRead;
                        /* Make it a multiple of 1K. */
                        int remainder = readBufferSize % 1024;
                        readBufferSize += 1024 - remainder;
                        readBufferSize = Math.min(readBufferSize,
                                                  maxReadBufferSize);
                    } else {
                        readBufferSize = maxReadBufferSize;
                    }
                    readBuffer = ByteBuffer.allocate(readBufferSize);
                }

                if (amountToRead > readBuffer.capacity()) {
                    nRepeatIteratorReads++;
                }
            }
        }

        int capacity() {
            return readBuffer.capacity();
        }

        int remaining() {
            return readBuffer.remaining();
        }

        boolean hasRemaining() {
            return readBuffer.hasRemaining();
        }

        ByteBuffer getBuffer() {
            return readBuffer;
        }

        /**
         * Returns the number of reads since the last time this method was
         * called.
         */
        int getAndResetNReads() {
            int tmp = nReadOperations;
            nReadOperations = 0;
            return tmp;
        }

        long getNRepeatIteratorReads() {
            return nRepeatIteratorReads;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            long start = DbLsn.makeLsn(fileNum, startOffset);
            long end = DbLsn.makeLsn(fileNum, endOffset);
            sb.append("window covers ");
            sb.append(DbLsn.getNoFormatString(start)).append(" to ");
            sb.append(DbLsn.getNoFormatString(end));
            sb.append(" positioned at ");
            long target = DbLsn.makeLsn(fileNum, startOffset +
                                        readBuffer.position());
            sb.append(DbLsn.getNoFormatString(target));
            return sb.toString();
        }
    }
}
