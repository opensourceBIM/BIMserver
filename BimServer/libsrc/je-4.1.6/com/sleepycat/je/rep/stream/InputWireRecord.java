/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.stream;

import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.utilint.VLSN;

/**
 * Format for messages received at across the wire for replication. Instead of
 * sending a direct copy of the log entry as it is stored on the JE log files
 * (LogEntryHeader + LogEntry), select parts of the header are sent.
 *
 * An InputWireRecord de-serializes the logEntry from the message bytes and
 * releases any claim on the backing ByteBuffer.
 */
public class InputWireRecord extends WireRecord {

    private final LogEntry logEntry;

    /**
     * Make a InputWireRecord from an incoming replication message buffer for
     * applying at a replica.
     * @throws DatabaseException
     */
    InputWireRecord(ByteBuffer msgBuffer)
        throws DatabaseException {

        byte entryType = msgBuffer.get();
        int entryVersion = LogUtils.readInt(msgBuffer);
        int itemSize = LogUtils.readInt(msgBuffer);
        VLSN vlsn = new VLSN(LogUtils.readLong(msgBuffer));

        this.header = new LogEntryHeader(entryType, entryVersion,
                                         itemSize, vlsn);

        /* The entryBuffer is positioned at 0, and is limited to this entry. */
        ByteBuffer entryBuffer = msgBuffer.slice();
        entryBuffer.limit(itemSize);

        logEntry = instantiateEntry(entryBuffer);
    }

    /**
     * Unit test support.
     * @throws DatabaseException
     */
    InputWireRecord(byte entryType,
                    int entryVersion,
                    int itemSize,
                    VLSN vlsn,
                    ByteBuffer entryBuffer)
        throws DatabaseException {

        header = new LogEntryHeader(entryType, entryVersion, itemSize, vlsn);
        logEntry = LogEntryType.findType(header.getType()).
            getNewLogEntry();
        logEntry.readEntry(header, entryBuffer, true /* readFullItem */);

    }

    public VLSN getVLSN() {
        return header.getVLSN();
    }

    public byte getEntryType() {
        return header.getType();
    }

    public LogEntry getLogEntry() {
        return logEntry;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        header.dumpRep(sb);
        sb.append(" ");
        logEntry.dumpRep(sb);
        return sb.toString();
    }

    /**
     * Convert the full version of the log entry to a string.
     */
    public String dumpLogEntry() {
        StringBuilder sb = new StringBuilder();
        sb.append(header);
        sb.append(" ").append(logEntry);
        return sb.toString();
    }
}
