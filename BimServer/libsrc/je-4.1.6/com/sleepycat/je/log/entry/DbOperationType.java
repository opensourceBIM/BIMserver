/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log.entry;

import java.nio.ByteBuffer;

import com.sleepycat.je.log.Loggable;

/**
 * DbOperationType is a persistent enum used in NameLNLogEntries. It supports
 * replication of database operations by documenting the type of api operation
 * which instigated the logging of a NameLN.
 */
public enum DbOperationType implements Loggable {

    NONE((byte) 0),
    CREATE((byte) 1),
    REMOVE((byte) 2),
    TRUNCATE((byte) 3),
    RENAME((byte) 4);
        
    private byte value;

    private DbOperationType(byte value) {
        this.value = value;
    }
        
    public static DbOperationType readTypeFromLog(ByteBuffer entryBuffer,
                                                  int entryVersion) {
        byte opVal = entryBuffer.get();
        switch (opVal) {
        case 1:
            return CREATE;

        case 2:
            return REMOVE;

        case 3:
            return TRUNCATE;

        case 4:
            return RENAME;

        case 0:
        default:
            return NONE;

        }
    }
        
    /** @see Loggable#getLogSize */
    public int getLogSize() {
        return 1;
    }
        
    /** @see Loggable#writeToLog */
    public void writeToLog(ByteBuffer logBuffer) {
        logBuffer.put(value);
    }
        
    /** @see Loggable#readFromLog */
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {
        value = itemBuffer.get();
    }
        
    /** @see Loggable#dumpLog */
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<DbOp val=\"").append(this).append("\"/>");
    }
        
    /** @see Loggable#getTransactionId */
    public long getTransactionId() {
        return 0;
    }
        
    /** @see Loggable#logicalEquals */
    public boolean logicalEquals(Loggable other) {
        if (!(other instanceof DbOperationType))
            return false;
        
        return value == ((DbOperationType) other).value;
    }
}
