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
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.utilint.RelatchRequiredException;

/**
 * An DIN represents an Duplicate Internal Node in the JE tree.
 */
public final class DIN extends IN {

    private static final String BEGIN_TAG = "<din>";
    private static final String END_TAG = "</din>";

    /**
     * Full key for this set of duplicates. For example, if the tree
     * contains k1/d1, k1/d2, k1/d3, the dupKey = k1.
     */
    private byte[] dupKey;

    /**
     * Reference to DupCountLN which stores the count.
     */
    private ChildReference dupCountLNRef;

    /**
     * Create an empty DIN, with no node id, to be filled in from the log.
     */
    public DIN() {
        super();

        dupCountLNRef = new ChildReference();
        init(null, Key.EMPTY_KEY, 0, 0);
    }

    /**
     * Create a new DIN.
     */
    public DIN(DatabaseImpl db,
               byte[] identifierKey,
               int capacity,
               byte[] dupKey,
               ChildReference dupCountLNRef,
               int level) {
        super(db, identifierKey, capacity, level);

        this.dupKey = dupKey;
        this.dupCountLNRef = dupCountLNRef;
        initMemorySize(); // init after adding Dup Count LN. */
    }

    /* Duplicates have no mask on their levels. */
    @Override
    protected int generateLevel(DatabaseId dbId, int newLevel) {
        return newLevel;
    }

    /**
     * Create a new DIN.  Need this because we can't call newInstance()
     * without getting a 0 node.
     */
    @Override
    protected IN createNewInstance(byte[] identifierKey,
                                   int maxEntries,
                                   int level) {
        return new DIN(getDatabase(),
                       identifierKey,
                       maxEntries,
                       dupKey,
                       dupCountLNRef,
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
     * A DIN uses the dupTree key in its searches.
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

    public ChildReference getDupCountLNRef() {
        return dupCountLNRef;
    }

    public DupCountLN getDupCountLN()
        throws DatabaseException {

        return (DupCountLN) dupCountLNRef.fetchTarget(getDatabase(), this);
    }

    /*
     * All methods that modify the dup count LN must adjust memory sizing.
     */

    /**
     * Assign the Dup Count LN.
     */
    void setDupCountLN(ChildReference dupCountLNRef) {
        updateMemorySize(this.dupCountLNRef, dupCountLNRef);
        this.dupCountLNRef = dupCountLNRef;
    }

    /**
     * Assign the Dup Count LN node.  Does not dirty the DIN.
     */
    public void updateDupCountLN(Node target) {
        long oldSize = getEntryInMemorySize(dupCountLNRef.getKey(),
                                            dupCountLNRef.getTarget());
        dupCountLNRef.setTarget(target);
        long newSize = getEntryInMemorySize(dupCountLNRef.getKey(),
                                            dupCountLNRef.getTarget());
        updateMemorySize(oldSize, newSize);
    }

    /**
     * Update Dup Count LN.
     */
    public void updateDupCountLNRefAndNullTarget(long newLsn) {
        setDirty(true);
        long oldSize = getEntryInMemorySize(dupCountLNRef.getKey(),
                                            dupCountLNRef.getTarget());
        dupCountLNRef.setTarget(null);
        if (notOverwritingDeferredWriteEntry(newLsn)) {
            dupCountLNRef.setLsn(newLsn);
        }
        long newSize = getEntryInMemorySize(dupCountLNRef.getKey(),
                                            dupCountLNRef.getTarget());
        updateMemorySize(oldSize, newSize);
    }

    /**
     * Update dup count LSN.
     */
    public void updateDupCountLNRef(long newLsn) {
        setDirty(true);
        if (notOverwritingDeferredWriteEntry(newLsn)) {
            dupCountLNRef.setLsn(newLsn);
        }
    }

    /**
     * @return true if this node is a duplicate-bearing node type, false
     * if otherwise.
     */
    @Override
    public boolean containsDuplicates() {
        return true;
    }

    /* Never true for a DIN. */
    @Override
    public boolean isDbRoot() {
        return false;
    }

    /**
     * Return the comparator function to be used for DINs.  This is
     * the user defined duplicate comparison function, if defined.
     */
    @Override
    public final Comparator<byte[]> getKeyComparator() {
        return getDatabase().getDuplicateComparator();
    }

    /**
     * Increment or decrement the DupCountLN, log the updated LN, and update
     * the lock result.
     *
     * Preconditions: This DIN is latched and the DupCountLN is write locked.
     * Postconditions: Same as preconditions.
     */
    public void incrementDuplicateCount(LockResult lockResult,
                                        byte[] key,
                                        Locker locker,
                                        boolean increment)
        throws DatabaseException {

        /* Increment/decrement the dup count and update its owning DIN. */
        long oldLsn = dupCountLNRef.getLsn();
        lockResult.setAbortLsn(oldLsn, dupCountLNRef.isKnownDeleted());
        DupCountLN dupCountLN = getDupCountLN();
        if (increment) {
            dupCountLN.incDupCount();
        } else {
            dupCountLN.decDupCount();
            assert dupCountLN.getDupCount() >= 0;
        }
        DatabaseImpl db = getDatabase();
        long newCountLSN = dupCountLN.optionalLog
            (db.getDbEnvironment(), db, key,
             oldLsn, locker, ReplicationContext.NO_REPLICATE);
        updateDupCountLNRef(newCountLSN);
    }

    /**
     * Count up the memory usage attributable to this node alone. LNs children
     * are counted by their BIN/DIN parents, but INs are not counted by
     * their parents because they are resident on the IN list.
     */
    @Override
    protected long computeMemorySize() {
        long size = super.computeMemorySize();
        if (dupCountLNRef != null) {
            size += MemoryBudget.byteArraySize(dupCountLNRef.getKey().length);
            if (dupCountLNRef.getTarget() != null) {
                size += dupCountLNRef.getTarget().
                    getMemorySizeIncludedByParent();
            }
        }
        return size;
    }

    @Override
    /* Utility method used during unit testing. */
    protected long printMemorySize() {
        final long inTotal = super.printMemorySize();
        long dupKeySize = 0;
        long dupLNSize = 0;

        if (dupCountLNRef != null) {
            dupKeySize = MemoryBudget.
                byteArraySize(dupCountLNRef.getKey().length);
            if (dupCountLNRef.getTarget() != null) {
                dupLNSize =
                    dupCountLNRef.getTarget().getMemorySizeIncludedByParent();
            }
        }

        final long dupTotal = inTotal + dupKeySize + dupLNSize;
        System.out.format("DIN: %d dkey: % dln: %\n",
                          inTotal, dupKeySize, dupLNSize);
        return dupTotal;
    }

    /* Called once at environment startup by MemoryBudget. */
    public static long computeOverhead(DbConfigManager configManager) {

        /*
         * Overhead consists of all the fields in this class plus the
         * entry arrays in the IN class.
         */
        return MemoryBudget.DIN_FIXED_OVERHEAD +
            IN.computeArraysOverhead(configManager);
    }

    @Override
    protected long getMemoryOverhead(MemoryBudget mb) {
        return mb.getDINOverhead();
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
                Node n = fetchTarget(i);
                if (n != null) {
                    boolean ret =
                        n.matchLNByNodeId(location, nodeId, cacheMode);
                    if (ret) {
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
        acc.processDIN(this, Long.valueOf(getNodeId()), getLevel());
    }

    /*
     * Logging Support
     */

    /**
     * @see Node#getLogType
     */
    @Override
    public LogEntryType getLogType() {
        return LogEntryType.LOG_DIN;
    }

    /**
     * Handles lazy migration of DupCountLNs prior to logging a DIN.
     */
    @Override
    public void beforeLog(LogManager logManager,
                          INLogItem item,
                          INLogContext context)
        throws DatabaseException {

        if (dupCountLNRef != null) {
            EnvironmentImpl envImpl = getDatabase().getDbEnvironment();
            DupCountLN dupCntLN = (DupCountLN) dupCountLNRef.getTarget();

            if ((dupCntLN != null) && (dupCntLN.isDirty())) {

                /* If deferred write, write any dirty LNs now. */
                long newLsn = dupCntLN.log(envImpl,
                                           getDatabase(),
                                           dupKey,
                                           dupCountLNRef.getLsn(),
                                           null,          // locker
                                           context.backgroundIO,
                                           // dupCountLNS  are never replicated
                                           ReplicationContext.NO_REPLICATE);

                updateDupCountLNRef(newLsn);
            } else {

                /*
                 * Allow the cleaner to migrate the DupCountLN before logging.
                 */
                envImpl.getCleaner().lazyMigrateDupCountLN
                    (this, dupCountLNRef, context.backgroundIO);
            }
        }

        super.beforeLog(logManager, item, context);
    }

    /**
     * @see IN#getLogSize
     */
    @Override
    public int getLogSize() {
        int size = super.getLogSize();               // ancestors
        size += LogUtils.getByteArrayLogSize(dupKey);// identifier key
        size += 1;                                   // dupCountLNRef null flag
        if (dupCountLNRef != null) {
            size += dupCountLNRef.getLogSize();
        }
        return size;
    }

    /**
     * @see IN#writeToLog
     */
    @Override
    public void writeToLog(ByteBuffer logBuffer) {

        // ancestors
        super.writeToLog(logBuffer);

        // identifier key
        LogUtils.writeByteArray(logBuffer, dupKey);

        /* DupCountLN */
        boolean dupCountLNRefExists = (dupCountLNRef != null);
        byte booleans = (byte) (dupCountLNRefExists ? 1 : 0);
        logBuffer.put(booleans);
        if (dupCountLNRefExists) {
            dupCountLNRef.writeToLog(logBuffer);
        }
    }

    /**
     * @see IN#readFromLog
     */
    @Override
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {

        boolean unpacked = (entryVersion < 6);
        super.readFromLog(itemBuffer, entryVersion);
        dupKey = LogUtils.readByteArray(itemBuffer, unpacked);

        /* DupCountLN */
        boolean dupCountLNRefExists = false;
        byte booleans = itemBuffer.get();
        dupCountLNRefExists = (booleans & 1) != 0;
        if (dupCountLNRefExists) {
            dupCountLNRef.readFromLog(itemBuffer, entryVersion);
        } else {
            dupCountLNRef = null;
        }
    }

    /**
     * DINS need to dump their dup key
     */
    @Override
    protected void dumpLogAdditional(StringBuilder sb) {
        super.dumpLogAdditional(sb);
        sb.append(Key.dumpString(dupKey, 0));
        if (dupCountLNRef != null) {
            dupCountLNRef.dumpLog(sb, true);
        }
    }

    /*
     * Dumping
     */

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
     * @return a string that dumps information about this DIN, without
     */
    @Override
    public String dumpString(int nSpaces, boolean dumpTags) {
        StringBuffer sb = new StringBuffer();
        if (dumpTags) {
            sb.append(TreeUtils.indent(nSpaces));
            sb.append(beginTag());
            sb.append('\n');
        }

        sb.append(TreeUtils.indent(nSpaces+2));
        sb.append("<dupkey>");
        sb.append(dupKey == null ? "" :
                  Key.dumpString(dupKey, 0));
        sb.append("</dupkey>");
        sb.append('\n');
        if (dupCountLNRef == null) {
            sb.append(TreeUtils.indent(nSpaces+2));
            sb.append("<dupCountLN/>");
        } else {
            sb.append(dupCountLNRef.dumpString(nSpaces + 4, true));
        }
        sb.append('\n');
        sb.append(super.dumpString(nSpaces, false));

        if (dumpTags) {
            sb.append(TreeUtils.indent(nSpaces));
            sb.append(endTag());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return dumpString(0, true);
    }

    @Override
    public String shortClassName() {
        return "DIN";
    }

    /**
     * We require exclusive latches on a DIN, so this method does not need to
     * declare that it throws RelatchRequiredException.
     */
    @Override
    public Node fetchTarget(int idx)
        throws DatabaseException {

        try {
            return super.fetchTarget(idx);
        } catch (RelatchRequiredException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
    }
}
