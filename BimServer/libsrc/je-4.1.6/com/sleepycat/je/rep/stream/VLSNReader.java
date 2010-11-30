/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.stream;

import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.ChecksumException;
import com.sleepycat.je.log.FileReader;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.vlsn.VLSNIndex;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.VLSN;

/**
 * The VLSNReader returns picks out replicated log entries from the log. It
 * works in tandem with the VLSNIndex, using vlsn->lsn mappings if those are
 * available, and otherwise scanning the log for replicated entries.
 *
 * A VLSNReader is not thread safe, and can only be used serially.
 */
abstract class VLSNReader extends FileReader {

    final VLSNIndex vlsnIndex;

    /*
     * currentVLSN is the target VLSN that the reader is looking for. It is
     * set if the reader is scanning vlsn sequentially, either forwards or
     * backwards.
     */
    VLSN currentVLSN;

    /*
     * The current log entry that the reader is positioned at, in wire record
     * format.
     */
    OutputWireRecord currentFeedRecord;

    /*
     * True if the reader has been positioned at a point in the file. Forward
     * scanning readers may read from either the log buffer or the log files.
     * It's preferable to read first from the log buffers, in case the log
     * entry is cached (or the log entry hasn't been written to disk).
     */

    /* stats */
    long nScanned;    // Num log entries seen by the reader
    long nReposition; // Number of times the reader has used a vlsn->lsn
                      // mapping and have reset the read window

    VLSNReader(EnvironmentImpl envImpl,
               VLSNIndex vlsnIndex,
               boolean forward,
               long startLsn,
               int readBufferSize,
               NameIdPair nameIdPair,
               long finishLsn)
        throws DatabaseException {

        /*
         * If we go backwards, endOfFileLsn and startLsn must not be null.
         * Make them the same, so we always start at the same very end.
         */
        super(envImpl,
              readBufferSize,
              forward,
              startLsn,
              null,            // singleFileNumber
              startLsn,        // endOfFileLsn
              finishLsn); 

        this.vlsnIndex = vlsnIndex;
        currentVLSN = VLSN.NULL_VLSN;
    }

    void setPosition(long startLsn)
        throws ChecksumException, FileNotFoundException, DatabaseException {

        if (startLsn == DbLsn.NULL_LSN) {
            return;
        }

        /*
         * An assertion: a reposition should never make the reader lose ground.
         */
        if (forward) {
            if (DbLsn.compareTo(getLastLsn(), startLsn) > 0) {
                throw EnvironmentFailureException.unexpectedState
                    ("Feeder forward scanning should not be repositioned to " +
                     " a position earlier than the current position. Current" +
                     " lsn = " + DbLsn.getNoFormatString(getLastLsn()) + 
                     " reposition = " + DbLsn.getNoFormatString(startLsn));
            }
        } else {
            if (DbLsn.compareTo(getLastLsn(), startLsn) < 0) {
                throw EnvironmentFailureException.unexpectedState
                    ("Feeder backward scanning should not be repositioned to " +
                     " a position later than the current position. Current" +
                     " lsn = " + DbLsn.getNoFormatString(getLastLsn()) + 
                     " reposition = " + DbLsn.getNoFormatString(startLsn));
            }
        }

        long fileNum = DbLsn.getFileNumber(startLsn);
        long offset = DbLsn.getFileOffset(startLsn);

        if (window.containsLsn(fileNum, offset)) {
            window.positionBuffer(offset);
        } else {
            window.slideAndFill(fileNum, offset, offset);
        }

        if (forward) {
            nextEntryOffset = offset;
        } else {
            currentEntryPrevOffset = offset;
        }
        nReposition++;
    }

    /**
     * Instantiate a WireRecord to house this log entry.
     */
    @Override
    protected boolean processEntry(ByteBuffer entryBuffer) {
        ByteBuffer buffer = entryBuffer.slice();
        buffer.limit(currentEntryHeader.getItemSize());
        currentFeedRecord = new OutputWireRecord(currentEntryHeader, buffer);

        entryBuffer.position(entryBuffer.position() +
                             currentEntryHeader.getItemSize());
        return true;
    }

    /* For unittests */
    long getNReposition() {
        return nReposition;
    }

    /* For unit tests. */
    long getNScanned() {
        return nScanned;
    }

    /* For unit tests. */
    void resetStats() {
        nReposition = 0;
        nScanned = 0;
    }
}
