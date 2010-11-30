/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.nio.ByteBuffer;
import java.util.zip.Checksum;

import com.sleepycat.je.utilint.Adler32;
import com.sleepycat.je.utilint.DbLsn;

/**
 * Checksum validator is used to check checksums on log entries.
 */
public class ChecksumValidator {
    private static final boolean DEBUG = false;

    private Checksum cksum;

    public ChecksumValidator() {
        cksum = Adler32.makeChecksum();
    }

    public void reset() {
        cksum.reset();
    }

    /**
     * Add this byte buffer to the checksum. Assume the byte buffer is already
     * positioned at the data.
     * @param buf target buffer
     * @param length of data
     */
    public void update(ByteBuffer buf, int length)
        throws ChecksumException {

        if (buf == null) {
            throw new ChecksumException
                ("null buffer given to checksum validation, probably " +
                 " result of 0's in log file.");
        }

        int bufStart = buf.position();

        if (DEBUG) {
            System.out.println("bufStart = " + bufStart +
                               " length = " + length);
        }

        update(buf.array(), bufStart + buf.arrayOffset(), length);
    }

    public void update(byte[] buf, int offset, int length) {
        cksum.update(buf, offset, length);
    }

    void validate(long expectedChecksum, long lsn)
        throws ChecksumException {

        if (expectedChecksum != cksum.getValue()) {
            throw new ChecksumException
                ("Location " + DbLsn.getNoFormatString(lsn) +
                 " expected " + expectedChecksum + " got " + cksum.getValue());
        }
    }

    public void validate(long expectedChecksum, long fileNum, long fileOffset)
        throws ChecksumException {

        if (expectedChecksum != cksum.getValue()) {
            long problemLsn = DbLsn.makeLsn(fileNum, fileOffset);

            throw new ChecksumException
                ("Location " + DbLsn.getNoFormatString(problemLsn) +
                 " expected " + expectedChecksum + " got " +
                 cksum.getValue());
        }
    }
}
