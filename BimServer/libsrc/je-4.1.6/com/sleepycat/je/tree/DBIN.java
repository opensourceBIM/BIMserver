/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.nio.ByteBuffer;
import java.util.Comparator;

import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;

/**
 * A DBIN represents an Duplicate Bottom Internal Node in the JE tree.
 */
public final class DBIN extends BIN implements Loggable {
    private static final String BEGIN_TAG = "<dbin>";
    private static final String END_TAG = "</dbin>";

    /**
     * Full key for this set of duplicates.
     */
    private byte[] dupKey;

    public DBIN() {
        super();
    }

    public DBIN(DatabaseImpl db,
                byte[] identifierKey,
                int maxEntriesPerNode,
                byte[] dupKey,
                int level) {
        super(db, identifierKey, maxEntriesPerNode, level);
        this.dupKey = dupKey;
    }

    /**
     * Create a new DBIN.  Need this because we can't call newInstance()
     * without getting a 0 node.
     */
    @Override
    protected IN createNewInstance(byte[] identifierKey,
                                   int maxEntries,
                                   int level) {
        return new DBIN(getDatabase(),
                        identifierKey,
                        maxEntries,
                        dupKey,
                        level);
    }

    /*
     * Return whether the shared latch for this kind of node should be of the
     * "always exclusive" variety.  Presently, only IN's are actually latched
     * shared.  BINs, DINs, and DBINs are all latched exclusive only.
     */
    @Override
    boolean isAlwaysLatchedExclusively() {
        return true;
    }

    @Override
    boolean isBottomMostNode() {
        return true;
    }

    /* Duplicates have no mask on their levels. */
    @Override
    protected int generateLevel(DatabaseId dbId, int newLevel) {
        return newLevel;
    }

    /**
     * Return the comparator function to be used for DBINs.  This is
     * the user defined duplicate comparison function, if defined.
     */
    @Override
    public final Comparator<byte[]> getKeyComparator() {
        return getDatabase().getDuplicateComparator();
    }

    /**
     * Return the key for this duplicate set.
     */
    @Override
    public byte[] getDupKey() {
        return dupKey;
    }

    /**
     * Get the key (dupe or identifier) in child that is used to locate
     * it in 'this' node.
     */
    @Override
    public byte[] getChildKey(IN child) {
        return child.getIdentifierKey();
    }

    /*
     * A DBIN uses the dupTree key in its searches.
     */
    @Override
    public byte[] selectKey(byte[] mainTreeKey, byte[] dupTreeKey) {
        return dupTreeKey;
    }

    /**
     * Return the key for navigating through the duplicate tree.
     */
    @Override
    public byte[] getDupTreeKey() {
        return getIdentifierKey();
    }

    /**
     * Return the key for navigating through the main tree.
     */
    @Override
    public byte[] getMainTreeKey() {
        return dupKey;
    }

    /**
     * @return true if this node is a duplicate-bearing node type, false
     * if otherwise.
     */
    @Override
    public boolean containsDuplicates() {
        return true;
    }

    /**
     * @return the log entry type to use for bin delta log entries.
     */
    @Override
    LogEntryType getBINDeltaType() {
        return LogEntryType.LOG_DUP_BIN_DELTA;
    }

    @Override
    public BINReference createReference() {
        return new DBINReference(getNodeId(), getDatabase().getId(),
                                 getIdentifierKey(), dupKey);
    }

    /**
     * Count up the memory usage attributable to this node alone.
     */
    @Override
    protected long computeMemorySize() {
        long size = super.computeMemorySize();
        return size;
    }

    /* Called once at environment startup by MemoryBudget. */
    public static long computeOverhead(DbConfigManager configManager) {

        /*
         * Overhead consists of all the fields in this class plus the
         * entry arrays in the IN class.
         */
        return MemoryBudget.DBIN_FIXED_OVERHEAD +
            IN.computeArraysOverhead(configManager);
    }

    @Override
    protected long getMemoryOverhead(MemoryBudget mb) {
        return mb.getDBINOverhead();
    }

    /*
     * A DBIN cannot be the ancestor of any IN.
     */
    @Override
    protected boolean canBeAncestor(boolean targetContainsDuplicates) {
        return false;
    }

    /**
     * Note that the IN may or may not be latched when this method is called.
     * Returning the wrong answer is OK in that case (it will be called again
     * later when latched), but an exception should not occur.
     */
    @Override
    boolean hasPinnedChildren() {
        return false;
    }

    /**
     * The following four methods access the correct fields in a
     * cursor depending on whether "this" is a BIN or DBIN.  For
     * BIN's, the CursorImpl.index and CursorImpl.bin fields should be
     * used.  For DBIN's, the CursorImpl.dupIndex and CursorImpl.dupBin
     * fields should be used.
     */
    @Override
    BIN getCursorBIN(CursorImpl cursor) {
        return cursor.getDupBIN();
    }

    @Override
    BIN getCursorBINToBeRemoved(CursorImpl cursor) {
        return cursor.getDupBINToBeRemoved();
    }

    @Override
    int getCursorIndex(CursorImpl cursor) {
        return cursor.getDupIndex();
    }

    @Override
    void setCursorBIN(CursorImpl cursor, BIN bin) {
        cursor.setDupBIN((DBIN) bin);
    }

    @Override
    void setCursorIndex(CursorImpl cursor, int index) {
        cursor.setDupIndex(index);
    }

    /*
     * Depth first search through a duplicate tree looking for an LN that
     * has nodeId.  When we find it, set location.bin and index and return
     * true.  If we don't find it, return false.
     *
     * No latching is performed.
     */
    @Override
    boolean matchLNByNodeId(TreeLocation location,
                            long nodeId,
                            CacheMode cacheMode)
        throws DatabaseException {

        latch();
        try {
            for (int i = 0; i < getNEntries(); i++) {
                LN ln = (LN) fetchTarget(i);
                if (ln != null) {
                    if (ln.getNodeId() == nodeId) {
                        location.bin = this;
                        location.index = i;
                        location.lnKey = getKey(i);
                        location.childLsn = getLsn(i);
                        return true;
                    }
                }
            }

            return false;
        } finally {
            releaseLatch();
        }
    }

    /*
     * DbStat support.
     */
    @Override
    void accumulateStats(TreeWalkerStatsAccumulator acc) {
        acc.processDBIN(this, Long.valueOf(getNodeId()), getLevel());
    }

    @Override
    public String beginTag() {
        return BEGIN_TAG;
    }

    @Override
    public String endTag() {
        return END_TAG;
    }

    /**
     * For unit test support:
     * @return a string that dumps information about this IN, without
     */
    @Override
    public String dumpString(int nSpaces, boolean dumpTags) {
        StringBuffer sb = new StringBuffer();
        sb.append(TreeUtils.indent(nSpaces));
        sb.append(beginTag());
        sb.append('\n');

        sb.append(TreeUtils.indent(nSpaces+2));
        sb.append("<dupkey>");
        sb.append(dupKey == null ? "" : Key.dumpString(dupKey, 0));
        sb.append("</dupkey>");
        sb.append('\n');

        sb.append(super.dumpString(nSpaces, false));

        sb.append(TreeUtils.indent(nSpaces));
        sb.append(endTag());
        return sb.toString();
    }

    /**
     * @see Node#getLogType()
     */
    @Override
    public LogEntryType getLogType() {
        return LogEntryType.LOG_DBIN;
    }

    /*
     * Logging support
     */

    /**
     * @see Loggable#getLogSize
     */
    @Override
    public int getLogSize() {
        int size = super.getLogSize(); // ancestors
        size += LogUtils.getByteArrayLogSize(dupKey);  // identifier key
        return size;
    }

    /**
     * @see Loggable#writeToLog
     */
    @Override
    public void writeToLog(ByteBuffer logBuffer) {

        super.writeToLog(logBuffer);
        LogUtils.writeByteArray(logBuffer, dupKey);
    }

    /**
     * @see BIN#readFromLog
     */
    @Override
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {

        super.readFromLog(itemBuffer, entryVersion);
        dupKey = LogUtils.readByteArray(itemBuffer, (entryVersion < 6));
    }

    /**
     * DBINS need to dump their dup key
     */
    @Override
    protected void dumpLogAdditional(StringBuilder sb) {
        super.dumpLogAdditional(sb);
        sb.append(Key.dumpString(dupKey, 0));
    }

    @Override
    public String shortClassName() {
        return "DBIN";
    }
}
