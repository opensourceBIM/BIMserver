/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.log.entry.SingleItemEntry;

/**
 * INDeleteInfo encapsulates the information logged about the removal of a
 * child from an IN during IN compression.
 *
 * As of JE 3.3.87, INDelete is no longer logged becaue the root compression
 * feature has been removed.  However, INDelete must still be processed in log
 * files created with 3.3.87 and earlier. [#17546]
 */
public class INDeleteInfo implements Loggable {

    private long deletedNodeId;
    private byte[] deletedIdKey;
    private final DatabaseId dbId;

    /**
     * Create a new delete info entry.
     */
    public INDeleteInfo(long deletedNodeId,
                        byte[] deletedIdKey,
                        DatabaseId dbId) {
        this.deletedNodeId = deletedNodeId;
        this.deletedIdKey = deletedIdKey;
        this.dbId = dbId;
    }

    /**
     * Used by logging system only.
     */
    public INDeleteInfo() {
        dbId = new DatabaseId();
    }

    /*
     * Accessors.
     */
    public long getDeletedNodeId() {
        return deletedNodeId;
    }

    public byte[] getDeletedIdKey() {
        return deletedIdKey;
    }

    public DatabaseId getDatabaseId() {
        return dbId;
    }

    /*
     * Logging support for writing.
     */
    public void optionalLog(LogManager logManager,
                            DatabaseImpl dbImpl)
        throws DatabaseException {

        if (!dbImpl.isDeferredWriteMode()) {
            logManager.log
                (new SingleItemEntry(LogEntryType.LOG_IN_DELETE_INFO,
                                     this),
                 ReplicationContext.NO_REPLICATE);
        }
    }

    /**
     * @see Loggable#getLogSize
     */
    public int getLogSize() {
        return LogUtils.getPackedLongLogSize(deletedNodeId) +
            LogUtils.getByteArrayLogSize(deletedIdKey) +
            dbId.getLogSize();
    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer logBuffer) {

        LogUtils.writePackedLong(logBuffer, deletedNodeId);
        LogUtils.writeByteArray(logBuffer, deletedIdKey);
        dbId.writeToLog(logBuffer);
    }

    /**
     * @see Loggable#readFromLog
     */
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {
        boolean unpacked = (entryVersion < 6);
        deletedNodeId = LogUtils.readLong(itemBuffer, unpacked);
        deletedIdKey = LogUtils.readByteArray(itemBuffer, unpacked);
        dbId.readFromLog(itemBuffer, entryVersion);
    }

    /**
     * @see Loggable#dumpLog
     */
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<INDeleteEntry node=\"").append(deletedNodeId);
        sb.append("\">");
        sb.append(Key.dumpString(deletedIdKey, 0));
        dbId.dumpLog(sb, verbose);
        sb.append("</INDeleteEntry>");
    }

    /**
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return 0;
    }

    /**
     * @see Loggable#logicalEquals
     * Always return false, this item should never be compared.
     */
    public boolean logicalEquals(Loggable other) {
        return false;
    }
}
