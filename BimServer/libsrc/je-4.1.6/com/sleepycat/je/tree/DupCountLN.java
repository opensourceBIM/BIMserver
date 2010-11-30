/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.nio.ByteBuffer;

import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;

/**
 * A DupCountLN represents the transactional part of the root of a
 * duplicate tree, specifically the count of dupes in the tree.
 */
public final class DupCountLN extends LN {

    private static final String BEGIN_TAG = "<dupCountLN>";
    private static final String END_TAG = "</dupCountLN>";

    private int dupCount;

    /**
     * Create a new DupCountLn to hold a new DIN.
     */
    public DupCountLN(EnvironmentImpl envImpl, int count) {
        /*
         * Never replicate DupCountLNs, they are generated on the client
         * side.
         */
        super(new byte[0], envImpl, false /* replicate */);

        /*
         * This ctor is always called from Tree.createDuplicateEntry
         * where there will be one existing LN and a new dup LN being
         * inserted to create the new duplicate tree.  So the minimum
         * starting point for a duplicate tree is 2 entries.
         */
        this.dupCount = count;
    }

    /**
     * Create an empty DupCountLN, to be filled in from the log.
     */
    public DupCountLN() {
        super();
        dupCount = 0;
    }

    public int getDupCount() {
        return dupCount;
    }

    public int incDupCount() {
        dupCount++;
        setDirty();
        assert dupCount >= 0;
        return dupCount;
    }

    public int decDupCount() {
        dupCount--;
        setDirty();
        assert dupCount >= 0;
        return dupCount;
    }

    void setDupCount(int dupCount) {
        this.dupCount = dupCount;
        setDirty();
    }

    /**
     * @return true if this node is a duplicate-bearing node type, false
     * if otherwise.
     */
    @Override
    public boolean containsDuplicates() {
        return true;
    }

    @Override
    public boolean isDeleted() {
        return false;
    }

    /**
     * Compute the approximate size of this node in memory for evictor
     * invocation purposes.
     */
    @Override
    public long getMemorySizeIncludedByParent() {
        return MemoryBudget.DUPCOUNTLN_OVERHEAD;
    }

    /*
     * DbStat support.
     */
    public void accumulateStats(TreeWalkerStatsAccumulator acc) {
        acc.processDupCountLN(this, Long.valueOf(getNodeId()));
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
        if (dumpTags) {
            sb.append(TreeUtils.indent(nSpaces));
            sb.append(beginTag());
            sb.append('\n');
        }
        sb.append(TreeUtils.indent(nSpaces+2));
        sb.append("<count v=\"").append(dupCount).append("\"/>").append('\n');
        sb.append(super.dumpString(nSpaces, false));
        if (dumpTags) {
            sb.append(TreeUtils.indent(nSpaces));
            sb.append(endTag());
        }
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
        return LogEntryType.LOG_DUPCOUNTLN_TRANSACTIONAL;
    }

    /**
     * @see Node#getLogType
     */
    @Override
    public LogEntryType getLogType() {
        return LogEntryType.LOG_DUPCOUNTLN;
    }

    /**
     * @see LN#getLogSize
     */
    @Override
    public int getLogSize() {
        return super.getLogSize() +
            LogUtils.getPackedIntLogSize(dupCount);
    }

    /**
     * @see LN#writeToLog
     */
    @Override
    public void writeToLog(ByteBuffer logBuffer) {
        // Ask ancestors to write to log
        super.writeToLog(logBuffer);
        LogUtils.writePackedInt(logBuffer, dupCount);
    }

    /**
     * @see LN#readFromLog
     */
    @Override
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {

        super.readFromLog(itemBuffer, entryVersion);
        dupCount = LogUtils.readInt(itemBuffer, (entryVersion < 6));
    }

    /**
     * @see Loggable#logicalEquals
     * DupCountLNs are never replicated.
     */
    @Override
    public boolean logicalEquals(Loggable other) {

        return false;
    }

    /**
     * Dump additional fields
     */
    @Override
    protected void dumpLogAdditional(StringBuilder sb, boolean verbose) {
        super.dumpLogAdditional(sb, verbose);
        sb.append("<count v=\"").append(dupCount).append("\"/>");
    }
}
