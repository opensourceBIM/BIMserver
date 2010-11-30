/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.nio.ByteBuffer;

import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.utilint.DbLsn;

/**
 * Item parameters that apply to a single logged item.  Passed to LogManager
 * log methods and to beforeLog and afterLog methods.
 */
public class LogItem {

    /**
     * Object to be marshaled and logged.
     *
     * Set by caller or beforeLog method.
     */
    public LogEntry entry = null;

    /**
     * The previous version of the node to be counted as obsolete, or NULL_LSN
     * if the entry is not a node or has no old LSN.
     *
     * Set by caller or beforeLog method.
     */
    public long oldLsn = DbLsn.NULL_LSN;

    /**
     * LSN of the new log entry.  Is NULL_LSN if a BINDelta is logged.  If
     * not NULL_LSN for a tree node, is typically used to update the slot in
     * the parent IN.
     *
     * Set by log or afterLog method.
     */
    public long newLsn = DbLsn.NULL_LSN;

    /**
     * Whether the logged entry should be processed during recovery.
     *
     * Set by caller or beforeLog method.
     */
    public Provisional provisional = null;

    /**
     * Whether the logged entry should be replicated.
     *
     * Set by caller or beforeLog method.
     */
    public ReplicationContext repContext = null;

    /* Fields used internally by log method. */
    public LogEntryHeader header = null;
    protected ByteBuffer buffer = null;

    int oldSize = 0;

    final public LogEntryHeader getHeader() {
        return header;
    }

    final public ByteBuffer getBuffer() {
        return buffer;
    }

    final public long getNewLsn() {
        return newLsn;
    }
}
