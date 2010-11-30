/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import java.nio.ByteBuffer;

import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.Timestamp;

/**
 * This class indicates the end of a partial rollback at syncup. This is a
 * non-replicated entry.  Although this is a replication class, it resides in
 * the utilint package because it is referenced in LogEntryType.java and is
 * used in a general way at recovery.
 */
public class RollbackEnd implements Loggable {

    private long matchpointLSN;
    private long rollbackStartLSN;
    /* For debugging in the field */
    private Timestamp time;

    public RollbackEnd(long matchpointLSN, long rollbackStartLSN) {
        this.matchpointLSN = matchpointLSN;
        this.rollbackStartLSN = rollbackStartLSN;
        time = new Timestamp(System.currentTimeMillis());
    }

    /**
     * For constructing from the log.
     */
    public RollbackEnd() {
    }

    public long getMatchpoint() {
        return matchpointLSN;
    }

    public long getRollbackStart() {
        return rollbackStartLSN;
    }

    /**
     * @see Loggable#getLogSize
     */
    public int getLogSize() {
        return  LogUtils.getPackedLongLogSize(matchpointLSN) +
            LogUtils.getPackedLongLogSize(rollbackStartLSN) +
            LogUtils.getTimestampLogSize(time);

    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer buffer) {
        LogUtils.writePackedLong(buffer, matchpointLSN);
        LogUtils.writePackedLong(buffer, rollbackStartLSN);
        LogUtils.writeTimestamp(buffer, time);
    }

    /**
     * @see Loggable#readFromLog
     */
    @SuppressWarnings("unused")
    public void readFromLog(ByteBuffer buffer, int entryVersion) {
        matchpointLSN = LogUtils.readPackedLong(buffer);
        rollbackStartLSN = LogUtils.readPackedLong(buffer);
        /* the timestamp is packed -- double negative, unpacked == false */
        time = LogUtils.readTimestamp(buffer, false /* unpacked. */);
    }

    /**
     * @see Loggable#dumpLog
     */
    @SuppressWarnings("unused")
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append(" matchpointLSN=");
        sb.append(DbLsn.getNoFormatString(matchpointLSN));
        sb.append(" rollbackStartLSN=");
        sb.append(DbLsn.getNoFormatString(rollbackStartLSN));
        sb.append(" time=").append(time);
    }

    /**
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return 0;
    }

    /**
     * @see Loggable#logicalEquals
     */
    public boolean logicalEquals(Loggable other) {

        if (!(other instanceof RollbackEnd)) {
            return false;
        }

        RollbackEnd otherRE = (RollbackEnd) other;
        return (rollbackStartLSN == otherRE.rollbackStartLSN) &&
            (matchpointLSN == otherRE.matchpointLSN) &&
            (time.equals(otherRE.time));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        dumpLog(sb, true);
        return sb.toString();
    }
}
