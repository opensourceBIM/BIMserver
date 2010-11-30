/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.latch.Latch;
import com.sleepycat.je.utilint.DbLsn;

/**
 * LogBuffers hold outgoing, newly written log entries.
 */
public class LogBuffer implements LogSource {

    private static final String DEBUG_NAME = LogBuffer.class.getName();

    /* Storage */
    private final ByteBuffer buffer;

    /* Information about what log entries are held here. */
    private long firstLsn;
    private long lastLsn;

    /* The read latch serializes access to and modification of the LSN info. */
    private Latch readLatch;

    /*
     * Buffer may be rewritten because an IOException previously occurred.
     */
    private boolean rewriteAllowed;

    LogBuffer(int capacity, EnvironmentImpl env)
        throws DatabaseException {

        buffer = ByteBuffer.allocate(capacity);
        readLatch = new Latch(DEBUG_NAME);
        reinit();
    }

    /*
     * Used by LogManager for the case when we have a temporary buffer in hand
     * and no LogBuffers in the LogBufferPool are large enough to hold the
     * current entry being written.  We just wrap the temporary ByteBuffer
     * in a LogBuffer and pass it to FileManager. [#12674].
     */
    LogBuffer(ByteBuffer buffer, long firstLsn) {
        this.buffer = buffer;
        this.firstLsn = firstLsn;
        this.lastLsn = firstLsn;
        rewriteAllowed = false;
    }

    void reinit()
        throws DatabaseException {

        readLatch.acquire();
        buffer.clear();
        firstLsn = DbLsn.NULL_LSN;
        lastLsn = DbLsn.NULL_LSN;
        rewriteAllowed = false;
        readLatch.release();
    }

    /*
     * Write support
     */

    /**
     * Return first LSN held in this buffer. Assumes the log write latch is
     * held.
     */
    public long getFirstLsn() {
        return firstLsn;
    }

    /**
     * This LSN has been written to the log.
     */
    void registerLsn(long lsn)
        throws DatabaseException {

        readLatch.acquire();
        try {
            if (lastLsn != DbLsn.NULL_LSN) {
                assert (DbLsn.compareTo(lsn, lastLsn) > 0):
                    "lsn=" + lsn + " lastlsn=" + lastLsn;
            }
            lastLsn = lsn;
            if (firstLsn == DbLsn.NULL_LSN) {
                firstLsn = lsn;
            }
        } finally {
            readLatch.release();
        }
    }

    /**
     * Check capacity of buffer. Assumes that the log write latch is held.
     * @return true if this buffer can hold this many more bytes.
     */
    boolean hasRoom(int numBytes) {
        return (numBytes <= (buffer.capacity() - buffer.position()));
    }

    /**
     * @return the actual data buffer.
     */
    public ByteBuffer getDataBuffer() {
        return buffer;
    }

    /**
     * @return capacity in bytes
     */
    int getCapacity() {
        return buffer.capacity();
    }

    /*
     * Read support
     */

    /**
     * Support for reading out of a still-in-memory log.  Can be used to
     * determine if a log entry with a given LSN is contained in this buffer,
     * or whether an arbitrary LSN location is present in the buffer.
     *
     * @return true if this buffer holds the data at this LSN location. If true
     * is returned, the buffer will be latched for read. Returns false if LSN
     * is not here, and releases the read latch.
     */
    boolean containsLsn(long lsn) {
        assert lsn != DbLsn.NULL_LSN;

        /* Latch before we look at the LSNs. */
        readLatch.acquire();
        boolean found = false;

        if ((firstLsn != DbLsn.NULL_LSN) &&
            (DbLsn.getFileNumber(firstLsn) == DbLsn.getFileNumber(lsn))) {

            final long fileOffset = DbLsn.getFileOffset(lsn);
            final int contentSize;
            if (buffer.position() == 0) {
                /* Buffer was flipped for reading. */
                contentSize = buffer.limit();
            } else {
                /* Buffer is still being written into. */
                contentSize = buffer.position();
            }
            final long firstLsnOffset = DbLsn.getFileOffset(firstLsn);
            final long lastContentOffset = firstLsnOffset + contentSize;

            if ((firstLsnOffset <= fileOffset) &&
                (lastContentOffset > fileOffset)) {
                found = true;
            }
        }

        if (found) {
            return true;
        } else {
            readLatch.release();
            return false;
        }
    }

    /**
     * When modifying the buffer, acquire the readLatch.  Call release() to
     * release the latch.  Note that containsLsn() acquires the latch for
     * reading.
     */
    public void latchForWrite()
        throws DatabaseException  {

        readLatch.acquire();
    }

    /*
     * LogSource support
     */

    /**
     * @see LogSource#release
     */
    public void release()  {
        readLatch.releaseIfOwner();
    }

    boolean getRewriteAllowed() {
        return rewriteAllowed;
    }

    void setRewriteAllowed() {
        rewriteAllowed = true;
    }

    /**
     * @see LogSource#getBytes
     */
    public ByteBuffer getBytes(long fileOffset) {

        /*
         * Make a copy of this buffer (doesn't copy data, only buffer state)
         * and position it to read the requested data.
         *
         * Note that we catch Exception here because it is possible that
         * another thread is modifying the state of buffer simultaneously.
         * Specifically, this can happen if another thread is writing this log
         * buffer out and it does (e.g.) a flip operation on it.  The actual
         * mark/pos of the buffer may be caught in an unpredictable state.  We
         * could add another latch to protect this buffer, but that's heavier
         * weight than we need.  So the easiest thing to do is to just retry
         * the duplicate operation.  See [#9822].
         */
        ByteBuffer copy = null;
        while (true) {
            try {
                copy = buffer.duplicate();
                copy.position((int)
                              (fileOffset - DbLsn.getFileOffset(firstLsn)));
                break;
            } catch (IllegalArgumentException IAE) {
                continue;
            }
        }
        return copy;
    }

    /**
     * @see LogSource#getBytes
     */
    public ByteBuffer getBytes(long fileOffset, int numBytes)
        throws ChecksumException {

        ByteBuffer copy = getBytes(fileOffset);
        /* Log Buffer should always hold a whole entry. */
        if (copy.remaining() < numBytes) {
            throw new ChecksumException("copy.remaining=" + copy.remaining() +
                                        " numBytes=" + numBytes);
        }
        return copy;
    }

    /**
     * Entries in write buffers are always the current version.
     */
    public int getLogVersion() {
        return LogEntryType.LOG_VERSION;
    }
}
