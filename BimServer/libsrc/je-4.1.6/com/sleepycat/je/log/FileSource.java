/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * FileSource is used as a channel to a log file when faulting in objects
 * from the log.
 */
class FileSource implements LogSource {

    private final RandomAccessFile file;
    private final int readBufferSize;
    private final FileManager fileManager;
    private final long fileNum;
    private final int logVersion;

    FileSource(RandomAccessFile file,
               int readBufferSize,
               FileManager fileManager,
               long fileNum,
               int logVersion) {
        this.file = file;
        this.readBufferSize = readBufferSize;
        this.fileManager = fileManager;
        this.fileNum = fileNum;
        this.logVersion = logVersion;
    }

    /**
     * @throws DatabaseException in subclasses.
     * @see LogSource#release
     */
    public void release()
        throws DatabaseException {
    }

    /**
     * @see LogSource#getBytes
     */
    public ByteBuffer getBytes(long fileOffset)
        throws DatabaseException {

        /* Fill up buffer from file. */
        ByteBuffer destBuf = ByteBuffer.allocate(readBufferSize);
        fileManager.readFromFile(file, destBuf, fileOffset, fileNum);

        assert EnvironmentImpl.maybeForceYield();

        destBuf.flip();
        return destBuf;
    }

    /**
     * @see LogSource#getBytes
     */
    public ByteBuffer getBytes(long fileOffset, int numBytes)
        throws ChecksumException, DatabaseException {

        /* Fill up buffer from file. */
        ByteBuffer destBuf = ByteBuffer.allocate(numBytes);
        fileManager.readFromFile(file, destBuf, fileOffset, fileNum);

        assert EnvironmentImpl.maybeForceYield();

        destBuf.flip();

        if (destBuf.remaining() < numBytes) {
            throw new ChecksumException("remaining=" + destBuf.remaining() +
                                        " numBytes=" + numBytes);
        }
        return destBuf;
    }

    public int getLogVersion() {
        return logVersion;
    }
}
