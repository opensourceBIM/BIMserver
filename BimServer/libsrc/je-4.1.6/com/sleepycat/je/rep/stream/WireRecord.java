/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.stream;

import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.LogEntry;

/**
 * Format for log entries sent across the wire for replication. Instead of
 * sending a direct copy of the log entry as it is stored on the JE log files
 * (LogEntryHeader + LogEntry), select parts of the header are sent.
 *
 * @see InputWireRecord
 * @see OutputWireRecord
 */
abstract class WireRecord {

    protected LogEntryHeader header;

    protected LogEntry instantiateEntry(ByteBuffer buffer)
        throws DatabaseException {

        LogEntryType type = LogEntryType.findType(header.getType());
        if (type == null) {
            throw EnvironmentFailureException.unexpectedState
                ("Unknown header type:" + header.getType());
        }
        LogEntry entry = type.getNewLogEntry();
        buffer.mark();
        entry.readEntry(header, buffer, true /* readFullItem */);
        buffer.reset();
        return entry;
    }
}
