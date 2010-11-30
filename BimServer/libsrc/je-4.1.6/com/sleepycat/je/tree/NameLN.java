/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.nio.ByteBuffer;

import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.log.entry.NameLNLogEntry;
import com.sleepycat.je.txn.Txn;

/**
 * A NameLN represents a Leaf Node in the name->database id mapping tree.
 */
public final class NameLN extends LN {

    private static final String BEGIN_TAG = "<nameLN>";
    private static final String END_TAG = "</nameLN>";

    private DatabaseId id;
    private boolean deleted;

    /**
     * In the ideal world, we'd have a base LN class so that this NameLN
     * doesn't have a superfluous data field, but we want to optimize the LN
     * class for size and speed right now.
     */
    public NameLN(DatabaseId id, EnvironmentImpl envImpl, boolean replicate) {
        super(new byte[0], envImpl, replicate);
        this.id = id;
        deleted = false;
    }

    /**
     * Create an empty NameLN, to be filled in from the log.
     */
    public NameLN() {
        super();
        id = new DatabaseId();
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    void makeDeleted() {
        deleted = true;
    }

    public DatabaseId getId() {
        return id;
    }

    public void setId(DatabaseId id) {
        this.id = id;
    }

    /*
     * Dumping
     */

    @Override
    public String toString() {
        return dumpString(0, true);
    }

    @Override
    public String beginTag() {
        return BEGIN_TAG;
    }

    @Override
    public String endTag() {
        return END_TAG;
    }

    @Override
    public String dumpString(int nSpaces, boolean dumpTags) {
        StringBuffer sb = new StringBuffer();
        sb.append(super.dumpString(nSpaces, dumpTags));
        sb.append('\n');
        sb.append(TreeUtils.indent(nSpaces));
        sb.append("<deleted val=\"").append(Boolean.toString(deleted));
        sb.append("\">");
        sb.append('\n');
        sb.append(TreeUtils.indent(nSpaces));
        sb.append("<id val=\"").append(id);
        sb.append("\">");
        sb.append('\n');
        return sb.toString();
    }

    /*
     * Logging
     */

    /**
     * Log type for transactional entries.
     */
    @Override
    protected LogEntryType getTransactionalLogType() {
        return LogEntryType.LOG_NAMELN_TRANSACTIONAL;
    }

    /**
     * @see Node#getLogType
     */
    @Override
    public LogEntryType getLogType() {
        return LogEntryType.LOG_NAMELN;
    }

    /**
     * @see LN#getLogSize
     */
    @Override
    public int getLogSize() {
        return
            super.getLogSize() +                     // superclass
            id.getLogSize() +                        // id
            1;                                       // deleted flag
    }

    /**
     * @see LN#writeToLog
     */
    @Override
    public void writeToLog(ByteBuffer logBuffer) {
        /* Ask ancestors to write to log. */
        super.writeToLog(logBuffer);         // super class
        id.writeToLog(logBuffer);            // id
        byte booleans = (byte) (deleted ? 1 : 0);
        logBuffer.put(booleans);
    }

    /**
     * @see LN#readFromLog
     */
    @Override
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {

        super.readFromLog(itemBuffer, entryVersion); // super class
        id.readFromLog(itemBuffer, entryVersion); // id
        byte booleans = itemBuffer.get();
        deleted = (booleans & 1) != 0;
    }

    /**
     * @see Loggable#logicalEquals
     */
    @Override
    public boolean logicalEquals(Loggable other) {

        if (!(other instanceof NameLN))
            return false;

        NameLN otherLN = (NameLN) other;

        if (getNodeId() != otherLN.getNodeId())
            return false;

        if (!(id.equals(otherLN.id)))
            return false;

        if (deleted != otherLN.deleted)
            return false;

        return true;
    }

    /**
     * Dump additional fields. Done this way so the additional info can be
     * within the XML tags defining the dumped log entry.
     */
    @Override
    protected void dumpLogAdditional(StringBuilder sb, boolean verbose) {
        id.dumpLog(sb, true);
    }

    /*
     * Each LN knows what kind of log entry it uses to log itself. Overridden
     * by subclasses.
     */
    @Override
    LNLogEntry createLogEntry(LogEntryType entryType,
                              DatabaseImpl dbImpl,
                              byte[] key,
                              byte[] delDupKey,
                              long logAbortLsn,
                              boolean logAbortKnownDeleted,
                              Txn logTxn,
                              ReplicationContext repContext) {

        return new NameLNLogEntry(entryType,
                                  this,
                                  dbImpl.getId(),
                                  key,
                                  logAbortLsn,
                                  logAbortKnownDeleted,
                                  logTxn,
                                  repContext);
    }
}
