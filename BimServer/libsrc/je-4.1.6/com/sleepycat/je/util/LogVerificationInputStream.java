/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.ChecksumException;
import com.sleepycat.je.log.ChecksumValidator;
import com.sleepycat.je.log.FileHeader;
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.LogEntry;

/**
 * Verifies the checksums in an {@code InputStream} for a log file in a JE
 * {@code Environment}.
 *
 * <p>This {@code InputStream} reads input from some other given {@code
 * InputStream}, and verifies checksums while reading.  Its primary intended
 * use is to verify log files that are being copied as part of a programmatic
 * backup.  It is critical that invalid files are not added to a backup set,
 * since then both the live environment and the backup will be invalid.</p>
 *
 * <p>The following example verifies log files as they are being copied.  The
 * {@link DbBackup} class should normally be used to obtain the array of files
 * to be copied.</p>
 *
 * <!-- NOTE: Whenever the method below is changed, update the copy in
 * VerifyLogTest to match, so that it will be tested. -->
 *
 * <pre>
 *  void copyFiles(final Environment env,
 *                 final String[] fileNames,
 *                 final File destDir,
 *                 final int bufSize)
 *      throws IOException, DatabaseException {
 *
 *      final File srcDir = env.getHome();
 *
 *      for (final String fileName : fileNames) {
 *
 *          final File destFile = new File(destDir, fileName);
 *          final FileOutputStream fos = new FileOutputStream(destFile);
 *
 *          final File srcFile = new File(srcDir, fileName);
 *          final FileInputStream fis = new FileInputStream(srcFile);
 *          final LogVerificationInputStream vis =
 *              new LogVerificationInputStream(env, fis, fileName);
 *
 *          final byte[] buf = new byte[bufSize];
 *
 *          try {
 *              while (true) {
 *                  final int len = vis.read(buf);
 *                  if (len &lt; 0) {
 *                      break;
 *                  }
 *                  fos.write(buf, 0, len);
 *              }
 *          } finally {
 *              fos.close();
 *              vis.close();
 *          }
 *      }
 *  }
 * </pre>
 *
 * <p>It is important to call the {@link #close} method of the {@code
 * LogVerificationInputStream} to detect incomplete entries at the end of the
 * log file.</p>
 *
 * <p>Note that {@code mark} and {@code reset} are not supported and {@code
 * markSupported} returns false.  The default {@link InputStream}
 * implementation of these methods is used.</p>
 *
 * @see DbBackup
 * @see DbVerifyLog
 */
public class LogVerificationInputStream extends InputStream {

    private static final int SKIP_BUF_SIZE = 2048;

    private static final byte FILE_HEADER_TYPE_NUM =
                              LogEntryType.LOG_FILE_HEADER.getTypeNum();

    private final InputStream in;
    private final String fileName;
    private final long fileNum;
    private byte[] skipBuf;

    /* Stream verification state information. */
    private enum State {
        INIT, FIXED_HEADER, VARIABLE_HEADER, ITEM, FILE_HEADER_ITEM, INVALID
    }
    private State state;
    private long entryStart;
    private final ChecksumValidator validator;
    private final ByteBuffer headerBuf;
    private LogEntryHeader header;
    private int itemPosition;
    private int logVersion;

    /**
     * Creates a verification input stream.
     *
     * @param env the {@code Environment} associated with the log.
     *
     * @param in the underlying {@code InputStream} for the log to be read.
     *
     * @param fileName the file name of the input stream, for reporting in the
     * {@code LogVerificationException}.  This should be a simple file name of
     * the form {@code NNNNNNNN.jdb}, where NNNNNNNN is the file number in
     * hexidecimal format.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public LogVerificationInputStream(final Environment env,
                                      final InputStream in,
                                      final String fileName) {
        this(DbInternal.getEnvironmentImpl(env), in, fileName, -1L);
    }

    /**
     * Internal constructor.  If fileNum is less than zero, it is derived from
     * fileName.
     */
    LogVerificationInputStream(final EnvironmentImpl envImpl,
                               final InputStream in,
                               final String fileName,
                               final long fileNum) {
        this.in = in;
        this.fileName = fileName;
        this.fileNum = (fileNum >= 0) ?
            fileNum : envImpl.getFileManager().getNumFromName(fileName);
        state = State.INIT;
        entryStart = 0L;
        validator = new ChecksumValidator();

        /*
         * The headerBuf is used to hold the fixed entry header, variable entry
         * header portion, and file header entry.
         */
        headerBuf = ByteBuffer.allocate
            (Math.max(LogEntryHeader.MAX_HEADER_SIZE, FileHeader.entrySize()));

        /* Initial log version for reading the file header. */
        logVersion = LogEntryType.UNKNOWN_FILE_HEADER_VERSION;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method reads the underlying {@code InputStream} and verifies the
     * contents of the stream.</p>
     *
     * @throws LogVerificationException if a checksum cannot be verified or a
     * log entry is determined to be invalid by examining its contents.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    @Override
    public int read()
        throws IOException {

        final int c = read();
        if (c < 0) {
            verifyAtEof();
            return c;
        }

        /*
         * This method will rarely, if ever, be called when reading a file, so
         * allocating a new byte array is not a performance issue and is the
         * simplest approach.
         */
        verify(new byte[] {(byte) c}, 0, 1);

        return c;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method reads the underlying {@code InputStream} and verifies the
     * contents of the stream.</p>
     *
     * @throws LogVerificationException if a checksum cannot be verified or a
     * log entry is determined to be invalid by examining its contents.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    @Override
    public int read(final byte b[])
        throws IOException {

        return read(b, 0, b.length);
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method reads the underlying {@code InputStream} and verifies the
     * contents of the stream.</p>
     *
     * @throws LogVerificationException if a checksum cannot be verified or a
     * log entry is determined to be invalid by examining its contents.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    @Override
    public int read(final byte b[], final int off, final int len)
        throws IOException {

        final int lenRead = in.read(b, off, len);
        if (lenRead <= 0) {
            if (lenRead < 0) {
                verifyAtEof();
            }
            return lenRead;
        }

        verify(b, off, lenRead);

        return lenRead;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method reads the underlying {@code InputStream} in order to
     * skip the required number of bytes and verifies the contents of the
     * stream.  A temporary buffer is allocated lazily for reading.</p>
     *
     * @throws LogVerificationException if a checksum cannot be verified or a
     * log entry is determined to be invalid by examining its contents.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    @Override
    public long skip(final long bytesToSkip)
        throws IOException {

        if (bytesToSkip <= 0) {
            return 0;
        }

        /*
         * Like InputStream.skip, we lazily allocate a skip buffer.  We must
         * read the data in order to validate the checksum.  Unlike the
         * InputStream.skip implementation, we cannot use a static buffer
         * because we do process the data and cannot allow multiple threads to
         * share the same buffer.
         */
        if (skipBuf == null) {
            skipBuf = new byte[SKIP_BUF_SIZE];
        }

        long remaining = bytesToSkip;
        while (remaining > 0) {
            final int lenRead = read
                (skipBuf, 0, (int) Math.min(SKIP_BUF_SIZE, remaining));
            if (lenRead < 0) {
                break;
            }
            remaining -= lenRead;
        }

        return bytesToSkip - remaining;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method simply performs <code>in.available()</code>.
     */
    @Override
    public int available()
        throws IOException {

        return in.available();
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method closes the underlying {@code InputStream} and verifies
     * that the stream ends with a complete log entry.</p>
     *
     * @throws LogVerificationException if the stream does not end with a
     * complete log entry.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    @Override
    public void close()
        throws IOException {

        /*
         * Close the underlying stream before we (potentially) throw an
         * exception.
         */
        in.close();

        /*
         * Do not throw an exception if the state is already INVALID, to allow
         * closing the stream without getting an exception after an exception
         * has already been thrown.
         */
        if (state != State.INVALID) {
            verifyAtEof();
        }
    }

    /**
     * Verifies the portion of the underlying stream that has just been read.
     */
    private void verify(final byte[] buf,
                        final int readOffset,
                        final int readLen)
        throws LogVerificationException {

        final int endOffset = readOffset + readLen;
        int curOffset = readOffset;
        while (curOffset < endOffset) {
            final int remaining = endOffset - curOffset;
            switch (state) {
            case INIT:
                processInit();
                break;
            case FIXED_HEADER:
                curOffset = processFixedHeader(buf, curOffset, remaining);
                break;
            case VARIABLE_HEADER:
                curOffset = processVariableHeader(buf, curOffset, remaining);
                break;
            case FILE_HEADER_ITEM:
                curOffset = processFileHeaderItem(buf, curOffset, remaining);
                break;
            case ITEM:
                curOffset = processItem(buf, curOffset, remaining);
                break;
            case INVALID:
                throw newVerifyException
                    ("May not read after LogVerificationException is thrown");
            default:
                assert false;
            }
        }
    }

    /**
     * Checks that the stream ends with a complete log entry, after a read of
     * the underlying stream returns EOF or the close method is called.
     */
    private void verifyAtEof()
        throws LogVerificationException {

        if (state != State.INIT) {
            throw newVerifyException("entry is incomplete");
        }
    }

    /**
     * Initializes all state variables before the start of a log entry.  Moves
     * the state to FIXED_HEADER, the first part of a log entry.
     */
    private void processInit() {
        validator.reset();
        headerBuf.clear();
        header = null;
        itemPosition = 0;
        state = State.FIXED_HEADER;
    }

    /**
     * Processes the fixed initial portion of a log entry.  After all bytes for
     * the fixed portion are read, moves the state to VARIABLE_HEADER if the
     * header contains a variable portion, or to ITEM if it does not.
     */
    private int processFixedHeader(final byte[] buf,
                                   final int curOffset,
                                   final int remaining)
        throws LogVerificationException {

        assert header == null;

        final int maxSize = LogEntryHeader.MIN_HEADER_SIZE;
        final int processSize =
            Math.min(remaining, maxSize - headerBuf.position());

        headerBuf.put(buf, curOffset, processSize);
        assert headerBuf.position() <= maxSize;

        if (headerBuf.position() == maxSize) {
            headerBuf.flip();
            try {
                header = new LogEntryHeader(headerBuf, logVersion);
            } catch (ChecksumException e) {
                throw newVerifyException(e);
            }

            /* If the header is invisible, turn off the invisible bit. */
            if (header.isInvisible()) {
                LogEntryHeader.turnOffInvisible(headerBuf, 0);
            } 
            
            /* Do not validate the bytes of the checksum itself. */
            validator.update(headerBuf.array(),
                             LogEntryHeader.CHECKSUM_BYTES,
                             maxSize - LogEntryHeader.CHECKSUM_BYTES);

            if (header.isVariableLength()) {
                headerBuf.clear();
                state = State.VARIABLE_HEADER;
            } else if (header.getType() == FILE_HEADER_TYPE_NUM) {
                headerBuf.clear();
                state = State.FILE_HEADER_ITEM;
            } else {
                state = State.ITEM;
            }
        }

        return curOffset + processSize;
    }

    /**
     * Processes the variable portion of a log entry.  After all bytes for the
     * variable portion are read, moves the state to ITEM.
     */
    private int processVariableHeader(final byte[] buf,
                                      final int curOffset,
                                      final int remaining) {
        assert header != null;
        assert header.isVariableLength();

        final int maxSize = header.getVariablePortionSize();
        final int processSize =
            Math.min(remaining, maxSize - headerBuf.position());

        headerBuf.put(buf, curOffset, processSize);
        assert headerBuf.position() <= maxSize;

        if (headerBuf.position() == maxSize) {
            headerBuf.flip();
            header.readVariablePortion(headerBuf);
            validator.update(headerBuf.array(), 0, maxSize);

            if (header.getType() == FILE_HEADER_TYPE_NUM) {
                headerBuf.clear();
                state = State.FILE_HEADER_ITEM;
            } else {
                state = State.ITEM;
            }
        }

        return curOffset + processSize;
    }

    private int processFileHeaderItem(final byte[] buf,
                                      final int curOffset,
                                      final int remaining)
        throws LogVerificationException {

        assert header != null;
        assert logVersion == LogEntryType.UNKNOWN_FILE_HEADER_VERSION;

        final int maxSize = FileHeader.entrySize();
        final int processSize =
            Math.min(remaining, maxSize - headerBuf.position());

        headerBuf.put(buf, curOffset, processSize);
        assert headerBuf.position() <= maxSize;

        if (headerBuf.position() == maxSize) {
            validator.update(headerBuf.array(), 0, maxSize);
            try {
                validator.validate(header.getChecksum(), fileNum, entryStart);
            } catch (ChecksumException e) {
                throw newVerifyException(e);
            }

            headerBuf.flip();
            LogEntry fileHeaderEntry =
                LogEntryType.LOG_FILE_HEADER.getNewLogEntry();
            fileHeaderEntry.readEntry(header, headerBuf,
                                      true /*readFullItem*/);
            FileHeader fileHeaderItem =
                (FileHeader) fileHeaderEntry.getMainItem();

            /* Log version in the file header applies to all other entries. */
            logVersion = fileHeaderItem.getLogVersion();

            entryStart += header.getSize() + maxSize;
            state = State.INIT;
        }

        return curOffset + processSize;
    }

    /**
     * Processes the item portion of a log entry.  After all bytes for the item
     * are read, moves the state back to INIT and bumps the entryStart.
     */
    private int processItem(final byte[] buf,
                            final int curOffset,
                            final int remaining)
        throws LogVerificationException {

        assert header != null;

        final int maxSize = header.getItemSize();
        final int processSize = Math.min(remaining, maxSize - itemPosition);

        validator.update(buf, curOffset, processSize);
        itemPosition += processSize;
        assert itemPosition <= maxSize;

        if (itemPosition == maxSize) {
            try {
                validator.validate(header.getChecksum(), fileNum, entryStart);
            } catch (ChecksumException e) {
                throw newVerifyException(e);
            }

            entryStart += header.getSize() + maxSize;
            state = State.INIT;
        }

        return curOffset + processSize;
    }

    private LogVerificationException newVerifyException(String reason) {
        return newVerifyException(reason, null);
    }

    private LogVerificationException newVerifyException(Throwable cause) {
        return newVerifyException(cause.toString(), cause);
    }

    private LogVerificationException newVerifyException(String reason,
                                                        Throwable cause) {
        state = State.INVALID;

        return new LogVerificationException
            ("Log is invalid, fileName: " + fileName +
             " fileNumber: 0x" + Long.toHexString(fileNum) +
             " logEntryOffset: 0x" + Long.toHexString(entryStart) +
             " verifyState: " + state +
             " reason: " + reason,
             cause);
    }
}
