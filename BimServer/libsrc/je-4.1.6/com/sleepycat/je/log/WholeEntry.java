/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import com.sleepycat.je.log.entry.LogEntry;

/**
 * This class packages the log entry header and the log entry "contents"
 * together for the use of components that need information from both parts.
 */
public class WholeEntry {
    private final LogEntryHeader header;
    private final LogEntry entry;

    WholeEntry(LogEntryHeader header, LogEntry entry) {
        this.header = header;
        this.entry = entry;
    }

    public LogEntryHeader getHeader() {
        return header;
    }

    public LogEntry getEntry() {
        return entry;
    }
}
