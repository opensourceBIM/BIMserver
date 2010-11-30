/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.nio.ByteBuffer;

import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.utilint.Timestamp;

/**
 * This class writes out a log entry that can be used for replication syncup.
 * It can be issued arbitrarily by the master at any point, in order to bound
 * the syncup interval in much the way that a checkpoint bounds the recovery
 * interval. The entry will a replicated one, which means that it will be
 * tagged with a VLSN.
 *
 * Although this is a replication class, it resides in the utilint package
 * because it is referenced in LogEntryType.java.
 *
 * TODO: This is currently not used. When it is used, it will be the first
 * replicated log entry that does not have a real txn id. All replicated
 * entries are expected to have negative ids, and the matchpoint should be
 * exempt from Replay.updateSequences, or it should pass in a special reserved
 * negative id, so as not to incur the assertion in Replay.updateSequences,
 * that the txn id is <0.
 */
public class Matchpoint implements Loggable {

    /* Time of issue. */
    private Timestamp time;

    /* For replication - master node which wrote this record. */
    private int repMasterNodeId;

    public Matchpoint(int repMasterNodeId) {
        this.repMasterNodeId = repMasterNodeId;
        time = new Timestamp(System.currentTimeMillis());
    }

    /**
     * For constructing from the log.
     */
    public Matchpoint() {
    }

    public int getMasterNodeId() {
        return repMasterNodeId;
    }

    /**
     * @see Loggable#getLogSize
     */
    public int getLogSize() {
        return LogUtils.getTimestampLogSize(time) +
            LogUtils.getPackedIntLogSize(repMasterNodeId);
    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer logBuffer) {
        LogUtils.writeTimestamp(logBuffer, time);
        LogUtils.writePackedInt(logBuffer, repMasterNodeId);
    }

    /**
     * @see Loggable#readFromLog
     */
    public void readFromLog(ByteBuffer logBuffer, int entryVersion) {
        time = LogUtils.readTimestamp(logBuffer, false /* isUnpacked. */);
        repMasterNodeId = LogUtils.readInt(logBuffer, false /* unpacked */);
    }

    /**
     * @see Loggable#dumpLog
     */
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<Matchpoint");
        sb.append("\" time=\"").append(time);
        sb.append("\" master=\"").append(repMasterNodeId);
        sb.append("\">");
    }

    /**
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return 0;
    }

    public boolean logicalEquals(Loggable other) {
        if (!(other instanceof Matchpoint)) {
            return false;
        }

        Matchpoint otherMatchpoint = (Matchpoint) other;
        return (otherMatchpoint.time.equals(time) &&
                (otherMatchpoint.repMasterNodeId == repMasterNodeId));
    }
}
