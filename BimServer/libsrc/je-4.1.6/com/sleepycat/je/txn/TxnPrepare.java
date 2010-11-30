/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import java.nio.ByteBuffer;

import javax.transaction.xa.Xid;

import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.utilint.DbLsn;

/**
 * This class writes out a transaction prepare record.
 */
public class TxnPrepare extends TxnEnd implements Loggable {

    private Xid xid;

    public TxnPrepare(long id, Xid xid) {
        /* LastLSN is never used. */
        super(id, DbLsn.NULL_LSN, 0 /* masterNodeId, never replicated. */);
        this.xid = xid;
    }

    /**
     * For constructing from the log.
     */
    public TxnPrepare() {
    }

    public Xid getXid() {
        return xid;
    }

    /*
     * Log support
     */

    protected String getTagName() {
        return "TxnPrepare";
    }

    /**
     * @see Loggable#getLogSize
     */
    @Override
    public int getLogSize() {
        return LogUtils.getPackedLongLogSize(id) +
            LogUtils.getTimestampLogSize(time) +
            LogUtils.getXidSize(xid);
    }

    /**
     * @see Loggable#writeToLog
     */
    @Override
    public void writeToLog(ByteBuffer logBuffer) {
        LogUtils.writePackedLong(logBuffer, id);
        LogUtils.writeTimestamp(logBuffer, time);
        LogUtils.writeXid(logBuffer, xid);
    }

    /**
     * @see Loggable#readFromLog
     */
    @Override
    public void readFromLog(ByteBuffer logBuffer, int entryVersion) {
        boolean unpacked = (entryVersion < 6);
        id = LogUtils.readLong(logBuffer, unpacked);
        time = LogUtils.readTimestamp(logBuffer, unpacked);
        xid = LogUtils.readXid(logBuffer);
    }

    /**
     * @see Loggable#dumpLog
     */
    @Override
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<").append(getTagName());
        sb.append(" id=\"").append(id);
        sb.append("\" time=\"").append(time);
        sb.append("\">");
        sb.append(xid); // xid already formatted as xml
        sb.append("</").append(getTagName()).append(">");
    }

    /**
     * @see Loggable#logicalEquals
     * Always return false, this item should never be compared.
     */
    public boolean logicalEquals(Loggable other) {
        return false;
    }
}
