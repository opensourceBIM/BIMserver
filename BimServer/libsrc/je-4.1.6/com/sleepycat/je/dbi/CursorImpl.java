/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import java.util.logging.Level;

import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DuplicateDataException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.evictor.Evictor.EvictionSource;
import com.sleepycat.je.latch.LatchSupport;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.BINBoundary;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.LockerFactory;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.TestHookExecute;

/**
 * A CursorImpl is the internal implementation of the cursor.
 */
public class CursorImpl implements Cloneable {

    private static final boolean DEBUG = false;

    private static final byte CURSOR_NOT_INITIALIZED = 1;
    private static final byte CURSOR_INITIALIZED = 2;
    private static final byte CURSOR_CLOSED = 3;
    private static final String TRACE_DELETE = "Delete";
    private static final String TRACE_MOD = "Mod:";

    /*
     * Cursor location in the databaseImpl, represented by a BIN and an index
     * in the BIN.  bin/index must have a non-null/non-negative value if dupBin
     * is set to non-null.
     */
    volatile private BIN bin;
    volatile private int index;

    /*
     * Cursor location in a given duplicate set.  If the cursor is not
     * referencing a duplicate set then these are null.
     */
    volatile private DBIN dupBin;
    volatile private int dupIndex;

    /*
     * BIN and DBIN that are no longer referenced by this cursor but have not
     * yet been removed.  If non-null, the BIN/DBIN will be removed soon.
     * BIN.adjustCursors should ignore cursors that are to be removed.
     */
    volatile private BIN binToBeRemoved;
    volatile private DBIN dupBinToBeRemoved;

    /*
     * The cursor location used for a given operation.
     */
    private BIN targetBin;
    private int targetIndex;
    private byte[] dupKey;

    /* The databaseImpl behind the handle. */
    private final DatabaseImpl databaseImpl;

    /* Owning transaction. */
    private Locker locker;
    private final boolean retainNonTxnLocks;

    /* State of the cursor. See CURSOR_XXX above. */
    private byte status;

    private CacheMode cacheMode;
    private boolean allowEviction;
    private TestHook testHook;

    /*
     * Unique id that we can return as a hashCode to prevent calls to
     * Object.hashCode(). [#13896]
     */
    private final int thisId;

    /*
     * Allocate hashCode ids from this. [#13896]
     */
    private static long lastAllocatedId = 0;

    private ThreadLocal<TreeWalkerStatsAccumulator> treeStatsAccumulatorTL;

    /**
     * public for Cursor et al
     */
    public static class SearchMode {
        public static final SearchMode SET =
            new SearchMode(true, false, "SET");
        public static final SearchMode BOTH =
            new SearchMode(true, true, "BOTH");
        public static final SearchMode SET_RANGE =
            new SearchMode(false, false, "SET_RANGE");
        public static final SearchMode BOTH_RANGE =
            new SearchMode(false, true, "BOTH_RANGE");

        private final boolean exactSearch;
        private final boolean dataSearch;
        private final String name;

        private SearchMode(boolean exactSearch,
                           boolean dataSearch,
                           String name) {
            this.exactSearch = exactSearch;
            this.dataSearch = dataSearch;
            this.name = "SearchMode." + name;
        }

        /**
         * Returns true when the key or key/data search is exact, i.e., for SET
         * and BOTH.
         */
        public final boolean isExactSearch() {
            return exactSearch;
        }

        /**
         * Returns true when the data value is included in the search, i.e.,
         * for BOTH and BOTH_RANGE.
         */
        public final boolean isDataSearch() {
            return dataSearch;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Holder for an OperationStatus and a keyChange flag.  Is used for search
     * and getNextWithKeyChangeStatus operations.
     */
    public static class KeyChangeStatus {

        /**
         * Operation status;
         */
        public OperationStatus status;

        /**
         * Whether the operation moved to a new key.
         */
        public boolean keyChange;

        public KeyChangeStatus(OperationStatus status, boolean keyChange) {
            this.status = status;
            this.keyChange = keyChange;
        }
    }

    /**
     * Creates a cursor with retainNonTxnLocks=true.
     */
    public CursorImpl(DatabaseImpl database, Locker locker) {
        this(database, locker, true);
    }

    /**
     * Creates a cursor.
     *
     * A cursor always retains transactional locks when it is reset or closed.
     * Non-transaction locks may be retained or not, depending on the
     * retainNonTxnLocks parameter value.
     *
     * Normally a user-created non-transactional Cursor releases locks on reset
     * and close, and a ThreadLocker is normally used.  However, by passing
     * true for retainNonTxnLocks a ThreadLocker can be made to retain locks;
     * this capability is used by SecondaryCursor.readPrimaryAfterGet.
     *
     * For internal (non-user) cursors, a BasicLocker is often used and locks
     * are retained.  BasicLocker does not currently support releasing locks
     * per cursor operation, so true must be passed for retainNonTxnLocks. In
     * addition, in these internal use cases the caller explicitly calls
     * BasicLocker.operationEnd, and retainNonTxnLocks is set to true to
     * prevent operationEnd from being called when the cursor is closed.
     *
     * BasicLocker is also used for NameLN operations while opening a Database
     * handle.  Database handle locks must be retained, even if the Database is
     * opened non-transactionally.
     *
     * @param retainNonTxnLocks is true if non-transactional locks should be
     * retained (not released automatically) when the cursor is reset or
     * closed.
     */
    public CursorImpl(DatabaseImpl databaseImpl,
                      Locker locker,
                      boolean retainNonTxnLocks) {

        thisId = (int) getNextCursorId();
        bin = null;
        index = -1;
        dupBin = null;
        dupIndex = -1;

        this.retainNonTxnLocks = retainNonTxnLocks;

        /* Associate this cursor with the databaseImpl. */
        this.databaseImpl = databaseImpl;
        this.locker = locker;
        this.locker.registerCursor(this);

        /*
         * This default value is used only when the CursorImpl is used directly
         * (mainly for internal databases).  When the CursorImpl is created by
         * a Cursor, CursorImpl.setCacheMode will be called.
         */
        this.cacheMode = CacheMode.DEFAULT;

        status = CURSOR_NOT_INITIALIZED;

        /*
         * Do not perform eviction here because we may be synchronized on the
         * Database instance. For example, this happens when we call
         * Database.openCursor().  Also eviction may be disabled after the
         * cursor is constructed.
         */
    }

    /*
     * Allocate a new hashCode id.  Doesn't need to be synchronized since it's
     * ok for two objects to have the same hashcode.
     */
    private static long getNextCursorId() {
        return ++lastAllocatedId;
    }

    @Override
    public int hashCode() {
        return thisId;
    }

    private void maybeInitTreeStatsAccumulator() {
        if (treeStatsAccumulatorTL == null) {
            treeStatsAccumulatorTL =
                new ThreadLocal<TreeWalkerStatsAccumulator>();
        }
    }

    private TreeWalkerStatsAccumulator getTreeStatsAccumulator() {
        if (EnvironmentImpl.getThreadLocalReferenceCount() > 0) {
            maybeInitTreeStatsAccumulator();
            return treeStatsAccumulatorTL.get();
        } else {
            return null;
        }
    }

    public void incrementLNCount() {
        TreeWalkerStatsAccumulator treeStatsAccumulator =
            getTreeStatsAccumulator();
        if (treeStatsAccumulator != null) {
            treeStatsAccumulator.incrementLNCount();
        }
    }

    /**
     * Disables or enables eviction during cursor operations.  For example, a
     * cursor used to implement eviction (e.g., in some UtilizationProfile and
     * most DbTree and VLSNIndex methods) should not itself perform eviction,
     * but eviction should be enabled for user cursors.  Eviction is disabled
     * by default.
     */
    public void setAllowEviction(boolean allowed) {
        allowEviction = allowed;
    }

    public void criticalEviction() {

        /*
         * In addition to disabling critical eviction for internal cursors (see
         * setAllowEviction above), we do not perform critical eviction when
         * EVICT_BIN or MAKE_COLD is used.  Operations using MAKE_COLD and
         * EVICT_BIN generally do not add any net memory to the cache, so they
         * shouldn't have to perform critical eviction or block while another
         * thread performs eviction.
         */
        if (allowEviction &&
            cacheMode != CacheMode.MAKE_COLD &&
            cacheMode != CacheMode.EVICT_BIN) {
            databaseImpl.getDbEnvironment().
                criticalEviction(false /*backgroundIO*/);
        }
    }

    /**
     * Shallow copy.  addCursor() is optionally called.
     */
    public CursorImpl cloneCursor(boolean addCursor, CacheMode cacheMode)
        throws DatabaseException {

        return cloneCursor(addCursor, cacheMode, null /*usePosition*/);
    }

    /**
     * Performs a shallow copy.
     *
     * @param addCursor If true, addCursor() is called to register the new
     * cursor with the BINs.  This is done after the usePosition parameter is
     * applied, if any.  There are two cases where you may not want addCursor()
     * to be called: 1) When creating a fresh uninitialized cursor as in when
     * Cursor.dup(false) is called, or 2) when the caller will call addCursor()
     * as part of a larger operation.
     *
     * @param usePosition Is null to duplicate the position of this cursor, or
     * non-null to duplicate the position of the given cursor.
     */
    public CursorImpl cloneCursor(final boolean addCursor,
                                  final CacheMode cacheMode,
                                  final CursorImpl usePosition)
        throws DatabaseException {

        CursorImpl ret = null;
        try {
            latchBINs();
            ret = (CursorImpl) super.clone();
            /* Must set cache mode before calling criticalEviction. */
            ret.setCacheMode(cacheMode);

            if (!retainNonTxnLocks) {
                ret.locker = locker.newNonTxnLocker();
            }

            ret.locker.registerCursor(ret);
            if (usePosition != null &&
                usePosition.status == CURSOR_INITIALIZED) {
                ret.bin = usePosition.bin;
                ret.index = usePosition.index;
                ret.dupBin = usePosition.dupBin;
                ret.dupIndex = usePosition.dupIndex;
            }

            if (addCursor) {
                ret.addCursor();
            }
        } catch (CloneNotSupportedException cannotOccur) {
            return null;
        } finally {
            releaseBINs();
        }

        /* Perform eviction before and after each cursor operation. */
        criticalEviction();

        return ret;
    }

    /**
     * Called when a cursor has been duplicated prior to being moved.  The new
     * locker is informed of the old locker, so that a preempted lock taken by
     * the old locker can be ignored. [#16513]
     *
     * @param closingCursor the old cursor that will be closed if the new
     * cursor is moved successfully.
     */
    public void setClosingLocker(CursorImpl closingCursor) {

        /*
         * If the two lockers are different, then the old locker will be closed
         * when the operation is complete.  This is currently the case only for
         * ReadCommitted cursors and non-transactional cursors that do not
         * retain locks.
         */
        if (!retainNonTxnLocks && locker != closingCursor.locker) {
            locker.setClosingLocker(closingCursor.locker);
        }
    }

    /**
     * Called when a cursor move operation is complete.  Clears the
     * closingLocker so that a reference to the old closed locker is not held.
     */
    public void clearClosingLocker() {
        locker.setClosingLocker(null);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int idx) {
        index = idx;
    }

    public BIN getBIN() {
        return bin;
    }

    public void setBIN(BIN newBin) {
        /* Ensure that cursor was removed for the prior BIN. [#16280] */
        assert (bin == newBin) ||
               (bin == binToBeRemoved) ||
               (!bin.containsCursor(this));
        bin = newBin;
    }

    public BIN getBINToBeRemoved() {
        return binToBeRemoved;
    }

    public int getDupIndex() {
        return dupIndex;
    }

    public void setDupIndex(int dupIdx) {
        dupIndex = dupIdx;
    }

    public DBIN getDupBIN() {
        return dupBin;
    }

    public void setDupBIN(DBIN newDupBin) {
        /* Ensure that cursor was removed for the prior DBIN. [#16280] */
        assert (dupBin == newDupBin) ||
               (dupBin == dupBinToBeRemoved) ||
               (!dupBin.containsCursor(this));
        dupBin = newDupBin;
    }

    public DBIN getDupBINToBeRemoved() {
        return dupBinToBeRemoved;
    }

    public CacheMode getCacheMode() {
        return cacheMode;
    }

    /**
     * Sets the effective cache mode to use for the next operation.  The
     * cacheMode field will never be set to null or DYNAMIC, and can be passed
     * directly to latching methods.
     *
     * @see #performCacheEviction
     */
    public void setCacheMode(final CacheMode mode) {
        cacheMode = databaseImpl.getEffectiveCacheMode(mode);
    }

    public void setTreeStatsAccumulator(TreeWalkerStatsAccumulator tSA) {
        maybeInitTreeStatsAccumulator();
        treeStatsAccumulatorTL.set(tSA);
    }

    /**
     * Figure out which BIN/index set to use.
     */
    private boolean setTargetBin() {
        targetBin = null;
        targetIndex = 0;
        boolean isDup = (dupBin != null);
        dupKey = null;
        if (isDup) {
            targetBin = dupBin;
            targetIndex = dupIndex;
            dupKey = dupBin.getDupKey();
        } else {
            targetBin = bin;
            targetIndex = index;
        }
        return isDup;
    }

    /**
     * Advance a cursor.  Used so that verify can advance a cursor even in the
     * face of an exception [12932].
     * @param key on return contains the key if available, or null.
     * @param data on return contains the data if available, or null.
     */
    public boolean advanceCursor(DatabaseEntry key, DatabaseEntry data) {

        BIN oldBin = bin;
        BIN oldDupBin = dupBin;
        int oldIndex = index;
        int oldDupIndex = dupIndex;

        key.setData(null);
        data.setData(null);

        try {
            getNext(key, data, LockType.NONE,
                    true /* forward */,
                    false /* alreadyLatched */);
        } catch (DatabaseException ignored) {
            /* Klockwork - ok */
        }

        /*
         * If the position changed, regardless of an exception, then we believe
         * that we have advanced the cursor.
         */
        if (bin != oldBin ||
            dupBin != oldDupBin ||
            index != oldIndex ||
            dupIndex != oldDupIndex) {

            /*
             * Return the key and data from the BIN entries, if we were not
             * able to read it above.
             */
            if (key.getData() == null &&
                bin != null &&
                index > 0) {
                setDbt(key, bin.getKey(index));
            }
            if (data.getData() == null &&
                dupBin != null &&
                dupIndex > 0) {
                setDbt(data, dupBin.getKey(dupIndex));
            }
            return true;
        } else {
            return false;
        }
    }

    public BIN latchBIN()
        throws DatabaseException {

        while (bin != null) {
            BIN waitingOn = bin;
            waitingOn.latch(cacheMode);
            if (bin == waitingOn) {
                return bin;
            }
            waitingOn.releaseLatch();
        }

        return null;
    }

    public void releaseBIN() {
        if (bin != null) {
            bin.releaseLatchIfOwner();
        }
    }

    public void latchBINs()
        throws DatabaseException {

        latchBIN();
        latchDBIN();
    }

    public void releaseBINs() {
        releaseBIN();
        releaseDBIN();
    }

    public DBIN latchDBIN()
        throws DatabaseException {

        while (dupBin != null) {
            BIN waitingOn = dupBin;
            waitingOn.latch(cacheMode);
            if (dupBin == waitingOn) {
                return dupBin;
            }
            waitingOn.releaseLatch();
        }
        return null;
    }

    public void releaseDBIN() {
        if (dupBin != null) {
            dupBin.releaseLatchIfOwner();
        }
    }

    public Locker getLocker() {
        return locker;
    }

    public void addCursor(BIN bin) {
        if (bin != null) {
            assert bin.isLatchOwnerForWrite();
            bin.addCursor(this);
        }
    }

    /**
     * Add to the current cursor. (For dups)
     */
    public void addCursor() {
        if (dupBin != null) {
            addCursor(dupBin);
        }
        if (bin != null) {
            addCursor(bin);
        }
    }

    /*
     * Update a cursor to refer to a new BIN or DBin following an insert.
     * Don't bother removing this cursor from the previous bin.  Cursor will do
     * that with a cursor swap thereby preventing latch deadlocks down here.
     */
    public void updateBin(BIN bin, int index)
        throws DatabaseException {

        removeCursorDBIN();
        setDupIndex(-1);
        setDupBIN(null);
        setIndex(index);
        setBIN(bin);
        addCursor(bin);
    }

    public void updateDBin(DBIN dupBin, int dupIndex) {
        setDupIndex(dupIndex);
        setDupBIN(dupBin);
        addCursor(dupBin);
    }

    private void removeCursor()
        throws DatabaseException {

        removeCursorBIN();
        removeCursorDBIN();
    }

    private void removeCursorBIN()
        throws DatabaseException {

        BIN abin = latchBIN();
        if (abin != null) {
            abin.removeCursor(this);
            abin.releaseLatch();
        }
    }

    private void removeCursorDBIN()
        throws DatabaseException {

        DBIN abin = latchDBIN();
        if (abin != null) {
            abin.removeCursor(this);
            abin.releaseLatch();
        }
    }

    /**
     * Clear the reference to the dup tree, if any.
     */
    public void clearDupBIN(boolean alreadyLatched)
        throws DatabaseException {

        if (dupBin != null) {
            if (alreadyLatched) {
                dupBin.removeCursor(this);
                dupBin.releaseLatch();
            } else {
                removeCursorDBIN();
            }
            dupBin = null;
            dupIndex = -1;
        }
    }

    public void dumpTree() {
        databaseImpl.getTree().dump();
    }

    /**
     * @return true if this cursor is closed
     */
    public boolean isClosed() {
        return (status == CURSOR_CLOSED);
    }

    /**
     * @return true if this cursor is not initialized
     */
    public boolean isNotInitialized() {
        return (status == CURSOR_NOT_INITIALIZED);
    }

    public boolean isInternalDbCursor() {
        return databaseImpl.isInternalDb();
    }

    /**
     * Reset a cursor to an uninitialized state, but unlike close(), allow it
     * to be used further.
     */
    public void reset()
        throws DatabaseException {

        /* Must remove cursor before evicting BIN. */
        removeCursor();
        performCacheEviction(null /*newCursor*/);

        if (!retainNonTxnLocks) {
            locker.releaseNonTxnLocks();
        }

        bin = null;
        index = -1;
        dupBin = null;
        dupIndex = -1;

        status = CURSOR_NOT_INITIALIZED;

        /* Perform eviction before and after each cursor operation. */
        criticalEviction();
    }

    public void close()
        throws DatabaseException {

        close(null);
    }

    /**
     * Close a cursor.
     *
     * @param newCursor is another cursor that is kept open by the parent
     * Cursor object, or null if no other cursor is kept open.
     *
     * @throws DatabaseException if the cursor was previously closed.
     */
    public void close(final CursorImpl newCursor)
        throws DatabaseException {

        assert assertCursorState(false) : dumpToString(true);

        /* Must remove cursor before evicting BIN. */
        removeCursor();
        performCacheEviction(newCursor);

        locker.unRegisterCursor(this);

        if (!retainNonTxnLocks) {
            locker.nonTxnOperationEnd();
        }

        status = CURSOR_CLOSED;

        /* Perform eviction before and after each cursor operation. */
        criticalEviction();
    }

    /**
     * When multiple operations are performed, CacheMode-based eviction is
     * performed for a given operation at the end of the next operation, which
     * calls close() or reset() on the CursorImpl of the previous operation.
     * Eviction for the last operation (including when only one operation is
     * performed) also occurs during Cursor.close(), which calls
     * CursorImpl.close().
     *
     * By default, the CacheMode returned by DatabaseImpl.getCacheMode is used,
     * and the defaults specified by the user for the Database or Environment
     * are applied.  However, the default mode can be overridden by the user by
     * calling Cursor.setCacheMode, and the mode may be changed prior to each
     * operation, if desired.
     *
     * To implement a per-operation CacheMode, two CacheMode fields are
     * maintained.  Cursor.cacheMode is the mode to use for the next operation.
     * CursorImpl.cacheMode is the mode that was used for the previous
     * operation, and that is used for eviction when that CursorImpl is closed
     * or reset.
     */
    private void performCacheEviction(final CursorImpl newCursor) {
        EnvironmentImpl envImpl = databaseImpl.getDbEnvironment();
        if (cacheMode != CacheMode.EVICT_LN &&
            cacheMode != CacheMode.EVICT_BIN &&
            (cacheMode != CacheMode.MAKE_COLD ||
             !(envImpl.isCacheFull() || envImpl.wasCacheEverFull()))) {
            /* Eviction not configured, or for MAKE_COLD, cache never full. */
            return;
        }
        setTargetBin();
        if (targetBin == null) {
            /* Nothing to evict. */
            return;
        }
        final BIN nextBin;
        final int nextIndex;
        if (newCursor != null) {
            newCursor.setTargetBin();
            nextBin = newCursor.targetBin;
            nextIndex = newCursor.targetIndex;
        } else {
            nextBin = null;
            nextIndex = -1;
        }
        switch (cacheMode) {
        case EVICT_LN:
            /* Evict the LN if we've moved to a new record. */
            if (targetBin != nextBin || targetIndex != nextIndex) {
                evict();
            }
            break;
        case EVICT_BIN:
            if (targetBin == nextBin) {
                /* BIN has not changed, do not evict it.  May evict the LN. */
                if (targetIndex != nextIndex) {
                    evict();
                }
            } else {
                /* BIN has changed, evict it. */
                envImpl.getEvictor().doEvictOneIN
                    (targetBin, EvictionSource.CACHEMODE);
            }
            break;
        case MAKE_COLD:
            if (targetBin == nextBin || !envImpl.isCacheFull()) {

                /*
                 * If BIN has not changed, do not evict it, but may still evict
                 * the LN. If cache not full, use LN eviction instead.
                 */
                if (targetIndex != nextIndex) {
                    evict();
                }
            } else {
                /* BIN has changed, evict it. */
                envImpl.getEvictor().doEvictOneIN
                    (targetBin, EvictionSource.CACHEMODE);
            }
            break;
        default:
            assert false;
        }
    }

    public int count(LockType lockType)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);

        if (!databaseImpl.getSortedDuplicates()) {
            return 1;
        }

        if (bin == null) {
            return 0;
        }

        latchBIN();
        try {
            if (bin.getNEntries() <= index) {
                return 0;
            }

            /* If fetchTarget returns null, a deleted LN was cleaned. */
            Node n = bin.fetchTarget(index);
            if (n != null && n.containsDuplicates()) {
                DIN dupRoot = (DIN) n;

                /* Latch couple down the tree. */
                dupRoot.latch(cacheMode);
                releaseBIN();
                DupCountLN dupCountLN = (DupCountLN)
                    dupRoot.getDupCountLNRef().fetchTarget(databaseImpl,
                                                           dupRoot);

                /* We can't hold latches when we acquire locks. */
                dupRoot.releaseLatch();

                /*
                 * Call lock directly.  There is no need to call lockLN because
                 * the node ID cannot change (a slot cannot be reused) for a
                 * DupCountLN.
                 */
                locker.lock
                    (dupCountLN.getNodeId(), lockType, false /*noWait*/,
                     databaseImpl);
                return dupCountLN.getDupCount();
            } else {
                /* If an LN is in the slot, the count is one. */
                return 1;
            }
        } finally {
            releaseBIN();
        }
    }

    /**
     * Delete the item pointed to by the cursor. If cursor is not initialized
     * or item is already deleted, return appropriate codes. Returns with
     * nothing latched.  bin and dupBin are latched as appropriate.
     *
     * @return 0 on success, appropriate error code otherwise.
     */
    public OperationStatus delete(ReplicationContext repContext)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);
        boolean isDup = setTargetBin();

        /* If nothing at current position, return. */
        if (targetBin == null) {
            return OperationStatus.KEYEMPTY;
        }

        /*
         * Check if this is already deleted. We may know that the record is
         * deleted w/out seeing the LN.
         */
        if (targetBin.isEntryKnownDeleted(targetIndex)) {
            releaseBINs();
            return OperationStatus.KEYEMPTY;
        }

        /* If fetchTarget returns null, a deleted LN was cleaned. */
        LN ln = (LN) targetBin.fetchTarget(targetIndex);
        if (ln == null) {
            releaseBINs();
            return OperationStatus.KEYEMPTY;
        }

        /* Get a write lock. */
        LockResult lockResult = lockLN(ln, LockType.WRITE);
        ln = lockResult.getLN();

        /* Check LN deleted status under the protection of a write lock. */
        if (ln == null) {
            releaseBINs();
            return OperationStatus.KEYEMPTY;
        }

        /* Lock the DupCountLN before logging any LNs. */
        LockResult dclLockResult = null;
        DIN dupRoot = null;
        boolean dupRootIsLatched = false;
        try {
            isDup = (dupBin != null);
            if (isDup) {
                dupRoot = getLatchedDupRoot(true /*isDBINLatched*/);
                dclLockResult = lockDupCountLN(dupRoot, LockType.WRITE);
                /* Don't mark latched until after locked. */
                dupRootIsLatched = true;

                /*
                 * Refresh the dupRoot variable because it may have changed
                 * during locking, but is sure to be resident and latched by
                 * lockDupCountLN.
                 */
                dupRoot = (DIN) bin.getTarget(index);
                /* Release BIN to increase concurrency. */
                releaseBIN();
            }

            /*
             * Between the release of the BIN latch and acquiring the write
             * lock any number of operations may have executed which would
             * result in a new abort LSN for this record. Therefore, wait until
             * now to get the abort LSN.
             */
            setTargetBin();
            long oldLsn = targetBin.getLsn(targetIndex);
            byte[] lnKey = targetBin.getKey(targetIndex);
            lockResult.setAbortLsn
                (oldLsn, targetBin.isEntryKnownDeleted(targetIndex));

            /* Log the LN. */
            long oldLNSize = ln.getMemorySizeIncludedByParent();
            long newLsn = ln.delete(databaseImpl, lnKey,
                                    dupKey, oldLsn, locker,
                                    repContext);

            /*
             * Now update the parent of the LN (be it BIN or DBIN) to correctly
             * reference the LN and adjust the memory sizing.  Be sure to do
             * this update of the LSN before updating the dup count LN. In case
             * we encounter problems there we need the LSN to match the latest
             * version to ensure that undo works.
             */
            targetBin.updateNode
                (targetIndex, ln, oldLNSize, newLsn, null /*lnSlotKey*/);
            targetBin.setPendingDeleted(targetIndex);
            releaseBINs();

            if (isDup) {
                dupRoot.incrementDuplicateCount
                    (dclLockResult, dupKey, locker, false /*increment*/);
                dupRoot.releaseLatch();
                dupRootIsLatched = false;
                dupRoot = null;

                locker.addDeleteInfo(dupBin, new Key(lnKey));
            } else {
                locker.addDeleteInfo(bin, new Key(lnKey));
            }

            trace(Level.FINER, TRACE_DELETE, targetBin,
                  ln, targetIndex, oldLsn, newLsn);
        } finally {
            if (dupRoot != null &&
                dupRootIsLatched) {
                dupRoot.releaseLatch();
            }
        }

        return OperationStatus.SUCCESS;
    }

    /**
     * Return a new copy of the cursor.
     *
     * @param samePosition If true, position the returned cursor at the same
     * position as this cursor; if false, return a new uninitialized cursor.
     */
    public CursorImpl dup(boolean samePosition)
        throws DatabaseException {

        assert assertCursorState(false) : dumpToString(true);

        CursorImpl ret = cloneCursor(samePosition /*addCursor*/, cacheMode);

        if (!samePosition) {
            ret.bin = null;
            ret.index = -1;
            ret.dupBin = null;
            ret.dupIndex = -1;

            ret.status = CURSOR_NOT_INITIALIZED;
        }

        return ret;
    }

    /**
     * Evict the LN node at the cursor position.
     */
    public void evict()
        throws DatabaseException {

        evict(false); // alreadyLatched
    }

    /**
     * Evict the LN node at the cursor position.
     */
    public void evict(boolean alreadyLatched)
        throws DatabaseException {

        try {
            if (!alreadyLatched) {
                latchBINs();
            }
            setTargetBin();
            if (targetIndex >= 0) {
                targetBin.evictLN(targetIndex);
            }
        } finally {
            if (!alreadyLatched) {
                releaseBINs();
            }
        }
    }

    /*
     * Puts
     */

    /**
     * Search for the next key (or duplicate) following the given key (and
     * datum), and acquire a range insert lock on it.  If there are no more
     * records following the given key and datum, lock the special EOF node
     * for the databaseImpl.
     */
    public void lockNextKeyForInsert(DatabaseEntry key, DatabaseEntry data)
        throws DatabaseException {

        DatabaseEntry tempKey = new DatabaseEntry
            (key.getData(), key.getOffset(), key.getSize());
        DatabaseEntry tempData = new DatabaseEntry
            (data.getData(), data.getOffset(), data.getSize());
        tempKey.setPartial(0, 0, true);
        tempData.setPartial(0, 0, true);
        boolean lockedNextKey = false;

        /* Don't search for data if duplicates are not configured. */
        SearchMode searchMode = databaseImpl.getSortedDuplicates() ?
            SearchMode.BOTH_RANGE : SearchMode.SET_RANGE;
        boolean latched = true;
        try {
            /* Search. */
            int searchResult = searchAndPosition
                (tempKey, tempData, searchMode, LockType.RANGE_INSERT);
            if ((searchResult & FOUND) != 0 &&
                (searchResult & FOUND_LAST) == 0) {

                /*
                 * If searchAndPosition found a record (other than the last
                 * one), in all cases we should advance to the next record:
                 *
                 * 1- found a deleted record,
                 * 2- found an exact match, or
                 * 3- found the record prior to the given key/data.
                 *
                 * If we didn't match the key, skip over duplicates to the next
                 * key with getNextNoDup.
                 */
                OperationStatus status;
                if ((searchResult & EXACT_KEY) != 0) {
                    status = getNext
                        (tempKey, tempData, LockType.RANGE_INSERT, true, true);
                } else {
                    status = getNextNoDup
                        (tempKey, tempData, LockType.RANGE_INSERT, true, true);
                }
                if (status == OperationStatus.SUCCESS) {
                    lockedNextKey = true;
                }
                latched = false;
            }
        } finally {
            if (latched) {
                releaseBINs();
            }
        }

        /* Lock the EOF node if no next key was found. */
        if (!lockedNextKey) {
            lockEofNode(LockType.RANGE_INSERT);
        }
    }

    /**
     * Performs all put operations except for CURRENT (use putCurrent instead).
     */
    public OperationStatus put(final DatabaseEntry key,
                               final DatabaseEntry data,
                               final LN ln,
                               final PutMode putMode,
                               final DatabaseEntry returnOldData,
                               final DatabaseEntry returnNewData,
                               final ReplicationContext repContext) {
        assert key != null;
        assert data != null;
        assert ln != null;
        assert putMode != null;
        assert assertCursorState(false) : dumpToString(true);
        assert LatchSupport.countLatchesHeld() == 0;

        final boolean allowDups;
        final boolean allowOverwrite;
        final boolean overwriteKnownNodeId;

        switch (putMode) {
        case NO_OVERWRITE:
            allowDups = false;
            allowOverwrite = false;
            overwriteKnownNodeId = false;
            break;
        case NO_DUP_DATA:
            assert databaseImpl.getSortedDuplicates();
            allowDups = true;
            allowOverwrite = false;
            overwriteKnownNodeId = false;
            break;
        case OVERWRITE:
            allowDups = databaseImpl.getSortedDuplicates();
            allowOverwrite = true;
            overwriteKnownNodeId = false;
            break;
        case OVERWRITE_KNOWN:
            allowDups = databaseImpl.getSortedDuplicates();
            allowOverwrite = true;
            overwriteKnownNodeId = true;
            break;
        default:
            throw EnvironmentFailureException.unexpectedState
                (putMode.toString());
        }

        LockResult lockResult = locker.lock
            (ln.getNodeId(), LockType.WRITE, false /*noWait*/, databaseImpl);

        /*
         * We'll set abortLsn down in Tree.insert when we know whether we're
         * re-using a BIN entry or not.
         */
        if (databaseImpl.getTree().insert(ln, Key.makeKey(key), allowDups,
                                          this, lockResult, repContext)) {
            status = CURSOR_INITIALIZED;
            /* Return a copy of resulting data, if requested. [#16932] */
            if (returnNewData != null) {
                returnNewData.setData(ln.copyData());
            }
            return OperationStatus.SUCCESS;
        } else {
            final long checkNodeId;
            if (overwriteKnownNodeId) {
                checkNodeId = ln.getNodeId();
            } else {
                checkNodeId = Node.NULL_NODE_ID;
                locker.releaseLock(ln.getNodeId());
            }
            if (allowOverwrite) {
                status = CURSOR_INITIALIZED;

                /*
                 * In addition to overwriting the existing value, putCurrent
                 * will get a write lock on the existing node.  We already have
                 * a write lock only when using OVERWRITE_KNOWN; in other cases
                 * we released the lock on the new LN.
                 */
                return putCurrent(data, null /*foundKey*/, returnOldData,
                                  returnNewData, checkNodeId, repContext);
            } else {
                return OperationStatus.KEYEXIST;
            }
        }
    }

    /**
     * Insert the given LN in the tree or return KEYEXIST if the key is already
     * present.
     *
     * <p>This method is called directly internally for putting tree map LNs
     * and file summary LNs.  It should not be used otherwise, and in the
     * future we should find a way to remove this special case.</p>
     *
     * @param returnNewData if non-null, is used to return a complete copy of
     * the resulting data after any partial data has been resolved.
     */
    public OperationStatus putLN(byte[] key,
                                 LN ln,
                                 DatabaseEntry returnNewData,
                                 boolean allowDuplicates,
                                 ReplicationContext repContext)
        throws DatabaseException {

        assert assertCursorState(false) : dumpToString(true);

        assert LatchSupport.countLatchesHeld() == 0;
        LockResult lockResult = locker.lock
            (ln.getNodeId(), LockType.WRITE, false /*noWait*/, databaseImpl);

        /*
         * We'll set abortLsn down in Tree.insert when we know whether we're
         * re-using a BIN entry or not.
         */
        if (databaseImpl.getTree().insert
            (ln, key, allowDuplicates, this, lockResult, repContext)) {
            status = CURSOR_INITIALIZED;
            /* Return a copy of resulting data, if requested. [#16932] */
            if (returnNewData != null) {
                returnNewData.setData(ln.copyData());
            }
            return OperationStatus.SUCCESS;
        } else {
            locker.releaseLock(ln.getNodeId());
            return OperationStatus.KEYEXIST;
        }
    }

    /**
     * Modify the current record with this data.
     *
     * @param data to overwrite, may be partial.
     *
     * @param foundKey if non-null, is used to return a copy of the existing
     * key, may be partial.
     *
     * @param foundData if non-null, is used to return a copy of the existing
     * data, may be partial.
     *
     * @param returnNewData if non-null, is used to return a complete copy of
     * the resulting data after any partial data has been resolved.
     *
     * @param checkNodeId if not Node.NULL_NODE_ID, is the node ID to be
     * overwritten.  If the given node ID is not equal to the node ID at the
     * current position, an EnvironmentFailureExcepion UNEXPECTED_STATE is
     * thrown.
     */
    public OperationStatus putCurrent(DatabaseEntry data,
                                      DatabaseEntry foundKey,
                                      DatabaseEntry foundData,
                                      DatabaseEntry returnNewData,
                                      long checkNodeId,
                                      ReplicationContext repContext)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);

        if (foundKey != null) {
            foundKey.setData(null);
        }
        if (foundData != null) {
            foundData.setData(null);
        }
        if (returnNewData != null) {
            returnNewData.setData(null);
        }

        if (bin == null) {
            return OperationStatus.KEYEMPTY;
        }

        latchBINs();
        boolean isDup = setTargetBin();

        /* Variables for tracing. */
        final long oldLsn;
        final long newLsn;
        LN ln;

        try {

            /*
             * Find the existing entry and get a reference to all BIN fields
             * while latched.
             */
            ln = (LN) targetBin.fetchTarget(targetIndex);
            byte[] lnKey = targetBin.getKey(targetIndex);

            /* If fetchTarget returned null, a deleted LN was cleaned. */
            if (targetBin.isEntryKnownDeleted(targetIndex) ||
                ln == null) {
                return OperationStatus.NOTFOUND;
            }

            /* Get a write lock. */
            LockResult lockResult = lockLN(ln, LockType.WRITE);
            ln = lockResult.getLN();

            /* Check LN deleted status under the protection of a write lock. */
            if (ln == null) {
                return OperationStatus.NOTFOUND;
            }

            if (checkNodeId != Node.NULL_NODE_ID &&
                checkNodeId != ln.getNodeId()) {
                EnvironmentFailureException.unexpectedState
                    ("Overwrite node ID expected = " + checkNodeId +
                     " but in Btree = " + ln.getNodeId());
            }

            /*
             * If cursor points at a dup, then we can only replace the entry
             * with a new entry that is "equal" to the old one.  Since a user
             * defined comparison function may actually compare equal for two
             * byte sequences that are actually different we still have to do
             * the replace.  Arguably we could skip the replacement if there is
             * no user defined comparison function and the new data is the
             * same.
             */
            byte[] foundDataBytes;
            byte[] foundKeyBytes;
            isDup = setTargetBin();
            if (isDup) {
                foundDataBytes = lnKey;
                foundKeyBytes = targetBin.getDupKey();
            } else {
                foundDataBytes = ln.getData();
                foundKeyBytes = lnKey;
            }
            byte[] newData;

            /* Resolve partial puts. */
            if (data.getPartial()) {
                int dlen = data.getPartialLength();
                int doff = data.getPartialOffset();
                int origlen = (foundDataBytes != null) ?
                    foundDataBytes.length : 0;
                int oldlen = (doff + dlen > origlen) ? doff + dlen : origlen;
                int len = oldlen - dlen + data.getSize();

                if (len == 0) {
                    newData = LogUtils.ZERO_LENGTH_BYTE_ARRAY;
                } else {
                    newData = new byte[len];
                }
                int pos = 0;

                /*
                 * Keep 0..doff of the old data (truncating if doff > length).
                 */
                int slicelen = (doff < origlen) ? doff : origlen;
                if (slicelen > 0) {
                    System.arraycopy(foundDataBytes, 0, newData,
                                     pos, slicelen);
                }
                pos += doff;

                /* Copy in the new data. */
                slicelen = data.getSize();
                System.arraycopy(data.getData(), data.getOffset(),
                                 newData, pos, slicelen);
                pos += slicelen;

                /* Append the rest of the old data (if any). */
                slicelen = origlen - (doff + dlen);
                if (slicelen > 0) {
                    System.arraycopy(foundDataBytes, doff + dlen, newData, pos,
                                     slicelen);
                }
            } else {
                int len = data.getSize();
                if (len == 0) {
                    newData = LogUtils.ZERO_LENGTH_BYTE_ARRAY;
                } else {
                    newData = new byte[len];
                }
                System.arraycopy(data.getData(), data.getOffset(),
                                 newData, 0, len);
            }

            if (databaseImpl.getSortedDuplicates()) {
                /* Check that data compares equal before replacing it. */
                boolean keysEqual = false;
                if (foundDataBytes != null) {
                    keysEqual = Key.compareKeys
                        (foundDataBytes, newData,
                         databaseImpl.getDuplicateComparator()) == 0;

                }

                if (!keysEqual) {
                    revertLock(ln, lockResult);
                    throw new DuplicateDataException
                        ("Can't replace a duplicate with data that is " +
                         "unequal according to the duplicate comparator.");
                }
            }

            if (foundData != null) {
                setDbt(foundData, foundDataBytes);
            }
            if (foundKey != null) {
                setDbt(foundKey, foundKeyBytes);
            }

            /*
             * Between the release of the BIN latch and acquiring the write
             * lock any number of operations may have executed which would
             * result in a new abort LSN for this record. Therefore, wait until
             * now to get the abort LSN.
             */
            oldLsn = targetBin.getLsn(targetIndex);
            lockResult.setAbortLsn
                (oldLsn, targetBin.isEntryKnownDeleted(targetIndex));

            /*
             * The modify has to be inside the latch so that the BIN is updated
             * inside the latch.
             */
            long oldLNSize = ln.getMemorySizeIncludedByParent();
            byte[] newKey = (isDup ? targetBin.getDupKey() : lnKey);
            newLsn = ln.modify(newData, databaseImpl, newKey, oldLsn, locker,
                               repContext);

            /* Return a copy of resulting data, if requested. [#16932] */
            if (returnNewData != null) {
                returnNewData.setData(ln.copyData());
            }

            /*
             * Update the parent BIN.  Update the data-as-key, if changed, for
             * a DBIN. [#15704]
             */
            targetBin.updateNode
                (targetIndex, ln, oldLNSize, newLsn, isDup ? newData : null);
        } finally {
            releaseBINs();
        }

        /* Trace after releasing latches. */
        trace(Level.FINER, TRACE_MOD, targetBin, ln, targetIndex, oldLsn,
              newLsn);

        status = CURSOR_INITIALIZED;
        return OperationStatus.SUCCESS;
    }

    /*
     * Gets
     */

    /**
     * Retrieve the current record.
     */
    public OperationStatus getCurrent(DatabaseEntry foundKey,
                                      DatabaseEntry foundData,
                                      LockType lockType)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);

        // If not pointing at valid entry, return failure
        if (bin == null) {
            return OperationStatus.KEYEMPTY;
        }

        if (dupBin == null) {
            latchBIN();
        } else {
            latchDBIN();
        }

        return getCurrentAlreadyLatched(foundKey, foundData, lockType, true);
    }

    /**
     * Retrieve the current record. Assume the bin is already latched.  Return
     * with the target bin unlatched.
     */
    public OperationStatus getCurrentAlreadyLatched(DatabaseEntry foundKey,
                                                    DatabaseEntry foundData,
                                                    LockType lockType,
                                                    boolean first)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);
        assert checkAlreadyLatched(true) : dumpToString(true);

        try {
            return fetchCurrent(foundKey, foundData, lockType, first);
        } finally {
            releaseBINs();
        }
    }

    /**
     * Retrieve the current LN, return with the target bin unlatched.
     */
    public LN getCurrentLN(LockType lockType)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);

        if (bin == null) {
            return null;
        } else {
            latchBIN();
            return getCurrentLNAlreadyLatched(lockType);
        }
    }

    /**
     * Retrieve the current LN, assuming the BIN is already latched.  Return
     * with the target BIN unlatched.
     */
    public LN getCurrentLNAlreadyLatched(LockType lockType)
        throws DatabaseException {

        try {
            assert assertCursorState(true) : dumpToString(true);
            assert checkAlreadyLatched(true) : dumpToString(true);

            if (bin == null) {
                return null;
            }

            /*
             * Get a reference to the LN under the latch.  Check the deleted
             * flag in the BIN.  If fetchTarget returns null, a deleted LN was
             * cleaned.
             */
            LN ln = null;
            if (!bin.isEntryKnownDeleted(index)) {
                ln = (LN) bin.fetchTarget(index);
            }
            if (ln == null) {
                releaseBIN();
                return null;
            }

            addCursor(bin);

            /* Lock LN.  */
            LockResult lockResult = lockLN(ln, lockType);
            ln = lockResult.getLN();

            /* Don't set abort LSN for a read operation! */
            return ln;

        } finally {
            releaseBINs();
        }
    }

    public OperationStatus getNext(DatabaseEntry foundKey,
                                   DatabaseEntry foundData,
                                   LockType lockType,
                                   boolean forward,
                                   boolean alreadyLatched)
        throws DatabaseException {

        return getNextWithKeyChangeStatus
            (foundKey, foundData, lockType, forward, alreadyLatched).status;
    }

    /**
     * Move the cursor forward and return the next record. This will cross BIN
     * boundaries and dip into duplicate sets.
     *
     * @param foundKey DatabaseEntry to use for returning key
     *
     * @param foundData DatabaseEntry to use for returning data
     *
     * @param forward if true, move forward, else move backwards
     *
     * @param alreadyLatched if true, the bin that we're on is already
     * latched.
     *
     * @return the status and an indication of whether we advanced to a new
     * key during the operation.
     */
    public KeyChangeStatus
        getNextWithKeyChangeStatus(DatabaseEntry foundKey,
                                   DatabaseEntry foundData,
                                   LockType lockType,
                                   boolean forward,
                                   boolean alreadyLatched)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);
        assert checkAlreadyLatched(alreadyLatched) : dumpToString(true);

        KeyChangeStatus result =
            new KeyChangeStatus(OperationStatus.NOTFOUND, false);

        try {
            while (bin != null) {

                /* Are we positioned on a DBIN? */
                if (dupBin != null) {
                    if (DEBUG) {
                        verifyCursor(dupBin);
                    }
                    if (getNextDuplicate(foundKey, foundData, lockType,
                                         forward, alreadyLatched) ==
                        OperationStatus.SUCCESS) {
                        result.status = OperationStatus.SUCCESS;
                        break;
                    } else {
                        removeCursorDBIN();
                        alreadyLatched = false;
                        dupBin = null;
                        dupIndex = -1;
                        continue;
                    }
                }

                /* If we are moving within a BIN, the key changes. [#19026] */
                result.keyChange = true;

                assert checkAlreadyLatched(alreadyLatched) :
                    dumpToString(true);
                if (!alreadyLatched) {
                    latchBIN();
                } else {
                    alreadyLatched = false;
                }

                if (DEBUG) {
                    verifyCursor(bin);
                }

                /* Is there anything left on this BIN? */
                if ((forward && ++index < bin.getNEntries()) ||
                    (!forward && --index > -1)) {

                    OperationStatus ret =
                        getCurrentAlreadyLatched(foundKey, foundData,
                                                 lockType, forward);
                    if (ret == OperationStatus.SUCCESS) {
                        incrementLNCount();
                        result.status = OperationStatus.SUCCESS;
                        break;
                    } else {
                        assert LatchSupport.countLatchesHeld() == 0;

                        if (binToBeRemoved != null) {
                            flushBINToBeRemoved();
                        }

                        continue;
                    }

                } else {

                    /*
                     * binToBeRemoved is used to release a BIN earlier in the
                     * traversal chain when we move onto the next BIN. When
                     * we traverse across BINs, there is a point when two BINs
                     * point to the same cursor.
                     *
                     * Example:  BINa(empty) BINb(empty) BINc(populated)
                     *           Cursor (C) is traversing
                     * loop, leaving BINa:
                     *   binToBeRemoved is null, C points to BINa, and
                     *     BINa points to C
                     *   set binToBeRemoved to BINa
                     *   find BINb, make BINb point to C
                     *   note that BINa and BINb point to C.
                     * loop, leaving BINb:
                     *   binToBeRemoved == BINa, remove C from BINa
                     *   set binToBeRemoved to BINb
                     *   find BINc, make BINc point to C
                     *   note that BINb and BINc point to C
                     * finally, when leaving this method, remove C from BINb.
                     */
                    if (binToBeRemoved != null) {
                        releaseBIN();
                        flushBINToBeRemoved();
                        latchBIN();
                    }
                    binToBeRemoved = bin;
                    bin = null;

                    BIN newBin;

                    /*
                     * SR #12736
                     * Prune away oldBin. Assert has intentional side effect
                     */
                    assert TestHookExecute.doHookIfSet(testHook);

                    if (forward) {
                        newBin = databaseImpl.getTree().getNextBin
                            (binToBeRemoved,
                             false /*traverseWithinDupTree*/,
                             cacheMode);
                    } else {
                        newBin = databaseImpl.getTree().getPrevBin
                            (binToBeRemoved,
                             false /*traverseWithinDupTree*/,
                             cacheMode);
                    }
                    if (newBin == null) {
                        result.status = OperationStatus.NOTFOUND;
                        break;
                    } else {
                        if (forward) {
                            index = -1;
                        } else {
                            index = newBin.getNEntries();
                        }
                        addCursor(newBin);
                        /* Ensure that setting bin is under newBin's latch */
                        bin = newBin;
                        alreadyLatched = true;
                    }
                }
            }
        } finally {
            assert LatchSupport.countLatchesHeld() == 0 :
                LatchSupport.latchesHeldToString();
            if (binToBeRemoved != null) {
                flushBINToBeRemoved();
            }
        }
        
        return result;
    }

    private void flushBINToBeRemoved()
        throws DatabaseException {

        binToBeRemoved.latch(cacheMode);
        binToBeRemoved.removeCursor(this);
        binToBeRemoved.releaseLatch();
        binToBeRemoved = null;
    }

    public OperationStatus getNextNoDup(DatabaseEntry foundKey,
                                        DatabaseEntry foundData,
                                        LockType lockType,
                                        boolean forward,
                                        boolean alreadyLatched)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);

        if (dupBin != null) {
            clearDupBIN(alreadyLatched);
            alreadyLatched = false;
        }

        return getNext(foundKey, foundData, lockType, forward, alreadyLatched);
    }

    /**
     * Retrieve the first duplicate at the current cursor position.
     */
    public OperationStatus getFirstDuplicate(DatabaseEntry foundKey,
                                             DatabaseEntry foundData,
                                             LockType lockType)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);

        /*
         * By clearing the dupBin, the next call to fetchCurrent will move to
         * the first duplicate.
         */
        if (dupBin != null) {
            removeCursorDBIN();
            dupBin = null;
            dupIndex = -1;
        }

        return getCurrent(foundKey, foundData, lockType);
    }

    /**
     * Enter with dupBin unlatched.  Pass foundKey == null to just advance
     * cursor to next duplicate without fetching data.
     */
    public OperationStatus getNextDuplicate(DatabaseEntry foundKey,
                                            DatabaseEntry foundData,
                                            LockType lockType,
                                            boolean forward,
                                            boolean alreadyLatched)
        throws DatabaseException {

        assert assertCursorState(true) : dumpToString(true);
        assert checkAlreadyLatched(alreadyLatched) : dumpToString(true);
        try {
            while (dupBin != null) {
                if (!alreadyLatched) {
                    latchDBIN();
                } else {
                    alreadyLatched = false;
                }

                if (DEBUG) {
                    verifyCursor(dupBin);
                }

                /* Are we still on this DBIN? */
                if ((forward && ++dupIndex < dupBin.getNEntries()) ||
                    (!forward && --dupIndex > -1)) {

                    OperationStatus ret = OperationStatus.SUCCESS;
                    if (foundKey != null) {
                        ret = getCurrentAlreadyLatched(foundKey, foundData,
                                                       lockType, forward);
                    } else {
                        releaseDBIN();
                    }
                    if (ret == OperationStatus.SUCCESS) {
                        incrementLNCount();
                        return ret;
                    } else {
                        assert LatchSupport.countLatchesHeld() == 0;

                        if (dupBinToBeRemoved != null) {
                            flushDBINToBeRemoved();
                        }

                        continue;
                    }

                } else {

                    /*
                     * We need to go to the next DBIN.  Remove the cursor and
                     * be sure to change the dupBin field after removing the
                     * cursor.
                     */
                    if (dupBinToBeRemoved != null) {
                        flushDBINToBeRemoved();
                    }
                    dupBinToBeRemoved = dupBin;

                    dupBin = null;
                    dupBinToBeRemoved.releaseLatch();

                    TreeWalkerStatsAccumulator treeStatsAccumulator =
                        getTreeStatsAccumulator();
                    if (treeStatsAccumulator != null) {
                        latchBIN();
                        try {
                            if (index < 0) {
                                /* This duplicate tree has been deleted. */
                                return OperationStatus.NOTFOUND;
                            }

                            DIN duplicateRoot = (DIN) bin.fetchTarget(index);
                            duplicateRoot.latch(cacheMode);
                            try {
                                DupCountLN dcl = duplicateRoot.getDupCountLN();
                                if (dcl != null) {
                                    dcl.accumulateStats(treeStatsAccumulator);
                                }
                            } finally {
                                duplicateRoot.releaseLatch();
                            }
                        } finally {
                            releaseBIN();
                        }
                    }
                    assert (LatchSupport.countLatchesHeld() == 0);

                    dupBinToBeRemoved.latch(cacheMode);
                    DBIN newDupBin;

                    if (forward) {
                        newDupBin = (DBIN) databaseImpl.getTree().getNextBin
                            (dupBinToBeRemoved,
                             true /*traverseWithinDupTree*/,
                             cacheMode);
                    } else {
                        newDupBin = (DBIN) databaseImpl.getTree().getPrevBin
                            (dupBinToBeRemoved,
                             true /*traverseWithinDupTree*/,
                             cacheMode);
                    }

                    if (newDupBin == null) {
                        return OperationStatus.NOTFOUND;
                    } else {
                        if (forward) {
                            dupIndex = -1;
                        } else {
                            dupIndex = newDupBin.getNEntries();
                        }
                        addCursor(newDupBin);

                        /*
                         * Ensure that setting dupBin is under newDupBin's
                         * latch.
                         */
                        dupBin = newDupBin;
                        alreadyLatched = true;
                    }
                }
            }
        } finally {
            assert LatchSupport.countLatchesHeld() == 0;
            if (dupBinToBeRemoved != null) {
                flushDBINToBeRemoved();
            }
        }

        return OperationStatus.NOTFOUND;
    }

    private void flushDBINToBeRemoved()
        throws DatabaseException {

        dupBinToBeRemoved.latch(cacheMode);
        dupBinToBeRemoved.removeCursor(this);
        dupBinToBeRemoved.releaseLatch();
        dupBinToBeRemoved = null;
    }

    /**
     * Position the cursor at the first or last record of the databaseImpl.
     * It's okay if this record is deleted. Returns with the target BIN
     * latched.
     *
     * @return true if a first or last position is found, false if the
     * tree being searched is empty.
     */
    public boolean positionFirstOrLast(boolean first, DIN duplicateRoot)
        throws DatabaseException {

        assert assertCursorState(false) : dumpToString(true);

        IN in = null;
        boolean found = false;
        try {
            if (duplicateRoot == null) {
                removeCursorBIN();
                if (first) {
                    in = databaseImpl.getTree().getFirstNode(cacheMode);
                } else {
                    in = databaseImpl.getTree().getLastNode(cacheMode);
                }

                if (in != null) {

                    assert (in instanceof BIN);

                    dupBin = null;
                    dupIndex = -1;
                    bin = (BIN) in;
                    index = (first ? 0 : (bin.getNEntries() - 1));
                    addCursor(bin);

                    TreeWalkerStatsAccumulator treeStatsAccumulator =
                        getTreeStatsAccumulator();

                    if (bin.getNEntries() == 0) {

                        /*
                         * An IN was found. Even if it's empty, let Cursor
                         * handle moving to the first non-deleted entry.
                         */
                        found = true;
                    } else {

                        /*
                         * See if we need to descend further.  If fetchTarget
                         * returns null, a deleted LN was cleaned.
                         *
                         * We do not need to fetch a known deleted entry.  We
                         * do need to fetch to determine if this is a dup
                         * database into which we will descend further.
                         */
                        Node n = null;
                        if (!bin.isEntryKnownDeleted(index) &&
                            duplicateRoot == null &&
                            databaseImpl.getSortedDuplicates()) {
                            n = bin.fetchTarget(index);
                        }

                        if (n != null && n.containsDuplicates()) {
                            DIN dupRoot = (DIN) n;
                            dupRoot.latch(cacheMode);
                            in.releaseLatch();
                            in = null;
                            found = positionFirstOrLast(first, dupRoot);
                        } else {

                            /*
                             * Even if the entry is deleted, just leave our
                             * position here and return.
                             */
                            if (treeStatsAccumulator != null) {
                                if (bin.isEntryKnownDeleted(index) ||
                                    bin.isEntryPendingDeleted(index) ||
                                    (n != null && ((LN) n).isDeleted())) {
                                    treeStatsAccumulator.
                                        incrementDeletedLNCount();
                                } else {
                                    treeStatsAccumulator.
                                        incrementLNCount();
                                }
                            }
                            found = true;
                        }
                    }
                }
            } else {
                removeCursorDBIN();
                if (first) {
                    in = databaseImpl.getTree().
                        getFirstNode(duplicateRoot, cacheMode);
                } else {
                    in = databaseImpl.getTree().
                        getLastNode(duplicateRoot, cacheMode);
                }

                if (in != null) {

                    /*
                     * An IN was found. Even if it's empty, let Cursor handle
                     * moving to the first non-deleted entry.
                     */
                    /*
                     * assert (in instanceof DBIN);
                     * Will always be true since Tree.getFirst/LastNode always
                     * returns a DBIN.
                     */

                    dupBin = (DBIN) in;
                    dupIndex = (first ? 0 : (dupBin.getNEntries() - 1));
                    addCursor(dupBin);
                    found = true;
                }
            }
            status = CURSOR_INITIALIZED;
            return found;
        } catch (DatabaseException e) {
            /* Release latch on error. */
            if (in != null) {
                in.releaseLatch();
            }
            throw e;
        }
    }

    public static final int FOUND = 0x1;
    /* Exact match on the key portion. */
    public static final int EXACT_KEY = 0x2;
    /* Exact match on the DATA portion when searchAndPositionBoth used. */
    public static final int EXACT_DATA = 0x4;
    /* Record found is the last one in the databaseImpl. */
    public static final int FOUND_LAST = 0x8;

    /**
     * Position the cursor at the key. This returns a three part value that's
     * bitwise or'ed into the int. We find out if there was any kind of match
     * and if the match was exact. Note that this match focuses on whether the
     * searching criteria (key, or key and data, depending on the search type)
     * is met.
     *
     * <p>Note this returns with the BIN latched!</p>
     *
     * <p>If this method returns without the FOUND bit set, the caller can
     * assume that no match is possible.  Otherwise, if the FOUND bit is set,
     * the caller should check the EXACT_KEY and EXACT_DATA bits.  If EXACT_KEY
     * is not set (or for BOTH and BOTH_RANGE, if EXACT_DATA is not set), an
     * approximate match was found.  In an approximate match, the cursor is
     * always positioned before the target key/data.  This allows the caller to
     * perform a 'next' operation to advance to the value that is equal or
     * higher than the target key/data.</p>
     *
     * <p>Even if the search returns an exact result, the record may be
     * deleted.  The caller must therefore check for both an approximate match
     * and for whether the cursor is positioned on a deleted record.</p>
     *
     * <p>If SET or BOTH is specified, the FOUND bit will only be returned if
     * an exact match is found.  However, the record found may be deleted.</p>
     *
     * <p>There is one special case where this method may be called without
     * checking the EXACT_KEY (and EXACT_DATA) bits and without checking for a
     * deleted record:  If SearchMode.SET is specified then only the FOUND bit
     * need be checked.  When SET is specified and FOUND is returned, it is
     * guaranteed to be an exact match on a non-deleted record.  It is for this
     * case only that this method is public.</p>
     *
     * <p>If FOUND is set, FOUND_LAST may also be set if the cursor is
     * positioned on the last record in the databaseImpl.  Note that this state
     * can only be counted on as long as the BIN is latched, so it is not set
     * if this method must release the latch to lock the record.  Therefore, it
     * should only be used for optimizations.  If FOUND_LAST is set, the cursor
     * is positioned on the last record and the BIN is latched.  If FOUND_LAST
     * is not set, the cursor may or may not be positioned on the last record.
     * Note that exact searches always perform an unlatch and a lock, so
     * FOUND_LAST will only be set for inexact (range) searches.</p>
     *
     * <p>Be aware that when an approximate match is returned, the index or
     * dupIndex may be set to -1.  This is done intentionally so that a 'next'
     * operation will increment it.</p>
     */
    public int searchAndPosition(DatabaseEntry matchKey,
                                 DatabaseEntry matchData,
                                 SearchMode searchMode,
                                 LockType lockType)
        throws DatabaseException {

        assert assertCursorState(false) : dumpToString(true);

        removeCursor();

        /* Reset the cursor. */
        bin = null;
        dupBin = null;
        dupIndex = -1;

        boolean foundSomething = false;
        boolean foundExactKey = false;
        boolean foundExactData = false;
        boolean foundLast = false;
        boolean exactSearch = searchMode.isExactSearch();
        BINBoundary binBoundary = new BINBoundary();

        try {
            byte[] key = Key.makeKey(matchKey);
            bin = (BIN) databaseImpl.getTree().search
                (key, Tree.SearchType.NORMAL, -1, binBoundary, cacheMode);

            if (bin != null) {
                addCursor(bin);

                /*
                 * If we're doing an exact search, tell bin.findEntry we
                 * require an exact match. If it's a range search, we don't
                 * need that exact match.
                 */
                index = bin.findEntry(key, true, exactSearch);

                /*
                 * If we're doing an exact search, as a starting point, we'll
                 * assume that we haven't found anything. If this is a range
                 * search, we'll assume the opposite, that we have found a
                 * record. That's because for a range search, the higher level
                 * will take care of sorting out whether anything is really
                 * there or not.
                 */
                foundSomething = !exactSearch;
                boolean containsDuplicates = false;

                if (index >= 0) {
                    if ((index & IN.EXACT_MATCH) != 0) {

                        /*
                         * The binary search told us we had an exact match.
                         * Note that this really only tells us that the key
                         * matched. The underlying LN may be deleted or the
                         * reference may be knownDeleted, or maybe there's a
                         * dup tree w/no entries, but the next layer up will
                         * find these cases.
                         */
                        foundExactKey = true;

                        /*
                         * Now turn off the exact match bit so the index will
                         * be a valid value, before we use it to retrieve the
                         * child reference from the bin.
                         */
                        index &= ~IN.EXACT_MATCH;
                    }

                    if (bin.isEntryKnownDeleted(index)) {
                        /* Do not fetch. */
                    } else if (!searchMode.isDataSearch() &&
                               lockType == LockType.NONE &&
                               !databaseImpl.getSortedDuplicates()) {

                        /*
                         * No need to fetch if we don't need the data for
                         * searching, don't need to lock, and will not descend
                         * into a dup tree.
                         */
                        if (!bin.isEntryKnownDeleted(index)) {
                            foundSomething = true;
                        }
                    } else {

                        /*
                         * If fetchTarget returns null, a deleted LN was
                         * cleaned.
                         */
                        Node n = bin.fetchTarget(index);
                        if (n != null) {
                            containsDuplicates = n.containsDuplicates();
                            if (searchMode.isDataSearch()) {
                                if (foundExactKey) {
                                    /* If the key matches, try the data. */
                                    int searchResult = searchAndPositionBoth
                                        (containsDuplicates, n, matchData,
                                         exactSearch, lockType);
                                    foundSomething =
                                        (searchResult & FOUND) != 0;
                                    foundExactData =
                                        (searchResult & EXACT_DATA) != 0;
                                }
                            } else {
                                foundSomething = true;
                                if (!containsDuplicates && exactSearch) {
                                    /* Lock LN, check if deleted. */
                                    LN ln = (LN) n;
                                    LockResult lockResult =
                                        lockLN(ln, lockType);
                                    ln = lockResult.getLN();

                                    if (ln == null) {
                                        foundSomething = false;
                                    }

                                    /*
                                     * Note that we must not set the abort LSN
                                     * for a read operation, lest false
                                     * obsoletes are set. [13158]
                                     */
                                }
                            }
                        }
                    }

                    /*
                     * Determine whether the last record was found.  This is
                     * only possible when we don't lock the record, and when
                     * there are no duplicates.
                     */
                    foundLast = (searchMode == SearchMode.SET_RANGE &&
                                 foundSomething &&
                                 !containsDuplicates &&
                                 binBoundary.isLastBin &&
                                 index == bin.getNEntries() - 1);
                }
            }
            status = CURSOR_INITIALIZED;

            /* Return a multi-part status value */
            return (foundSomething ? FOUND : 0) |
                (foundExactKey ? EXACT_KEY : 0) |
                (foundExactData ? EXACT_DATA : 0) |
                (foundLast ? FOUND_LAST : 0);
        } catch (DatabaseException e) {
            /* Release latch on error. */
            releaseBIN();
            throw e;
        }
    }

    /**
     * For this type of search, we need to match both key and data.  This
     * method is called after the key is matched to perform the data portion of
     * the match. We may be matching just against an LN, or doing further
     * searching into the dup tree.  See searchAndPosition for more details.
     */
    private int searchAndPositionBoth(boolean containsDuplicates,
                                      Node n,
                                      DatabaseEntry matchData,
                                      boolean exactSearch,
                                      LockType lockType)
        throws DatabaseException {

        assert assertCursorState(false) : dumpToString(true);

        boolean found = false;
        boolean exact = false;
        assert (matchData != null);
        byte[] data = Key.makeKey(matchData);

        if (containsDuplicates) {
            /* It's a duplicate tree. */
            DIN duplicateRoot = (DIN) n;
            duplicateRoot.latch(cacheMode);
            releaseBIN();
            dupBin = (DBIN) databaseImpl.getTree().searchSubTree
                (duplicateRoot, data, Tree.SearchType.NORMAL,
                 -1, null, cacheMode);
            if (dupBin != null) {
                /* Find an exact match. */
                addCursor(dupBin);
                dupIndex = dupBin.findEntry(data, true, exactSearch);
                if (dupIndex >= 0) {
                    if ((dupIndex & IN.EXACT_MATCH) != 0) {
                        exact = true;
                    }
                    dupIndex &= ~IN.EXACT_MATCH;
                    found = true;
                } else {

                    /*
                     * The first duplicate is greater than the target data.
                     * Set index so that a 'next' operation moves to the first
                     * duplicate.
                     */
                    dupIndex = -1;
                    found = !exactSearch;
                }
            }
        } else {
            /* Not a duplicate, but checking for both key and data match. */
            LN ln = (LN) n;

            /* Lock LN, check if deleted. */
            LockResult lockResult = lockLN(ln, lockType);

            /*
             * Note that during the lockLN call, this cursor may have been
             * adjusted to refer to an LN in a duplicate tree.  This happens in
             * the case where we entered with a non-duplicate tree LN and
             * during the lock call it was mutated to a duplicate tree.  The LN
             * is still the correct LN, but our cursor is now down in a
             * duplicate tree. [#14230].
             */

            ln = lockResult.getLN();

            if (ln == null) {
                found = !exactSearch;
            } else {

                /* Don't set abort LSN for read operation. [#13158] */

                /*
                 * The comparison logic below mimics IN.findEntry as used above
                 * for duplicates.
                 */
                int cmp = Key.compareKeys
                    (ln.getData(), data, databaseImpl.getDuplicateComparator());
                if (cmp == 0 || (cmp <= 0 && !exactSearch)) {
                    if (cmp == 0) {
                        exact = true;
                    }
                    found = true;
                } else {

                    /*
                     * The current record's data is greater than the target
                     * data.  Set index so that a 'next' operation moves to the
                     * current record.
                     */
                    if (dupBin == null) {
                        index--;
                    } else {
                        /* We may now be pointing at a dup tree. [#14230]. */
                        dupIndex--;
                    }
                    found = !exactSearch;
                }
            }
        }

        return (found ? FOUND : 0) |
            (exact ? EXACT_DATA : 0);
    }

    /*
     * Lock and copy current record into the key and data DatabaseEntry. Enter
     * with the BIN/DBIN latched.
     */
    private OperationStatus fetchCurrent(DatabaseEntry foundKey,
                                         DatabaseEntry foundData,
                                         LockType lockType,
                                         boolean first)
        throws DatabaseException {

        TreeWalkerStatsAccumulator treeStatsAccumulator =
            getTreeStatsAccumulator();

        boolean duplicateFetch = setTargetBin();
        if (targetBin == null) {
            return OperationStatus.NOTFOUND;
        }

        assert targetBin.isLatchOwnerForWrite();

        /*
         * Check the deleted flag in the BIN and make sure this isn't an empty
         * BIN.  The BIN could be empty by virtue of the compressor running the
         * size of this BIN to 0 but not having yet deleted it from the tree.
         *
         * The index may be negative if we're at an intermediate stage in an
         * higher level operation, and we expect a higher level method to do a
         * next or prev operation after this returns KEYEMPTY. [#11700]
         */
        if (targetIndex < 0 ||
            targetIndex >= targetBin.getNEntries() ||
            targetBin.isEntryKnownDeleted(targetIndex)) {
            /* Node is no longer present. */
            if (treeStatsAccumulator != null) {
                treeStatsAccumulator.incrementDeletedLNCount();
            }
            targetBin.releaseLatch();
            return OperationStatus.KEYEMPTY;
        }

        /*
         * If we encounter a pendingDeleted entry, add it to the compressor
         * queue.
         */
        if (targetBin.isEntryPendingDeleted(targetIndex)) {
            EnvironmentImpl envImpl = databaseImpl.getDbEnvironment();
            envImpl.addToCompressorQueue
                (targetBin, new Key(targetBin.getKey(targetIndex)), false);
        }

        /*
         * We don't need to fetch the LN if all these conditions are true:
         * 1. No locking is needed.
         * 2. The user has not requested that we return the data -- only the
         *    key may be returned, and it is available in the BIN.
         * 3. We don't need to fetch the node in order to determine whether to
         *    descend into the dup tree.
         */
        if (lockType == LockType.NONE &&
            (foundData == null ||
             (foundData.getPartial() &&
              foundData.getPartialLength() == 0)) &&
            (duplicateFetch ||
             !databaseImpl.getSortedDuplicates())) {
            if (targetBin.isEntryPendingDeleted(targetIndex)) {
                if (treeStatsAccumulator != null) {
                    treeStatsAccumulator.incrementDeletedLNCount();
                }
                return OperationStatus.KEYEMPTY;
            }
            if (foundKey != null) {
                setDbt(foundKey,
                       duplicateFetch ?
                       dupKey :
                       targetBin.getKey(targetIndex));
            }
            return OperationStatus.SUCCESS;
        }

        /* If fetchTarget returns null, a deleted LN was cleaned. */
        Node n;
        try {
            n = targetBin.fetchTarget(targetIndex);
        } catch (DatabaseException DE) {
            targetBin.releaseLatch();
            throw DE;
        }
        if (n == null) {
            if (treeStatsAccumulator != null) {
                treeStatsAccumulator.incrementDeletedLNCount();
            }
            targetBin.releaseLatch();
            return OperationStatus.KEYEMPTY;
        }

        /*
         * Note that since we have the BIN/DBIN latched, we can safely check
         * the node type. Any conversions from an LN to a dup tree must have
         * the bin latched.
         */
        addCursor(targetBin);
        if (n.containsDuplicates()) {
            assert !duplicateFetch;
            /* Descend down duplicate tree, doing latch coupling. */
            DIN duplicateRoot = (DIN) n;
            duplicateRoot.latch(cacheMode);
            targetBin.releaseLatch();
            if (positionFirstOrLast(first, duplicateRoot)) {
                try {
                    return fetchCurrent(foundKey, foundData, lockType, first);
                } catch (DatabaseException DE) {
                    releaseBINs();
                    throw DE;
                }
            } else {
                return OperationStatus.NOTFOUND;
            }
        }

        LN ln = (LN) n;

        assert TestHookExecute.doHookIfSet(testHook);

        /*
         * Lock the LN.  For dirty-read, the data of the LN can be set to null
         * at any time.  Cache the data in a local variable so its state does
         * not change before calling setDbt further below.
         */
        LockResult lockResult = lockLN(ln, lockType);
        try {
            ln = lockResult.getLN();
            byte[] lnData = (ln != null) ? ln.getData() : null;
            if (ln == null || lnData == null) {
                if (treeStatsAccumulator != null) {
                    treeStatsAccumulator.incrementDeletedLNCount();
                }
                return OperationStatus.KEYEMPTY;
            }

            /*
             * Don't set the abort LSN here since we are not logging yet, even
             * if this is a write lock.  Tree.insert depends on the fact that
             * the abortLSN is not already set for deleted items.
             */

            /*
             * Return the key from the targetBin because only the targetBin is
             * guaranteed to be latched by lockLN above, and the key is not
             * available as part of the LN.  [#15704]
             */
            if (foundKey != null) {
                duplicateFetch = setTargetBin();
                setDbt(foundKey, duplicateFetch ? dupKey :
                       targetBin.getKey(targetIndex));
            }

            /*
             * With a duplicate comparator configured, data values may also be
             * non-identical but compare as equal.  For the data parameter, we
             * return the LN data.  Although DBIN.getKey is guaranteed to be
             * transactionally correct, we return the LN data instead because
             * that works for duplicates and non-duplicates, and because the LN
             * is the source of truth.  [#15704]
             */
            if (foundData != null) {
                setDbt(foundData, lnData);
            }

            return OperationStatus.SUCCESS;
        } finally {
            releaseBINs();
        }
    }

    /**
     * Locks the given LN's node ID; a deleted LN will not be locked or
     * returned.  Attempts to use a non-blocking lock to avoid
     * unlatching/relatching.  Retries if necessary, to handle the case where
     * the LN is changed while the BIN is unlatched.
     *
     * Preconditions: The target BIN must be latched.  When positioned in a dup
     * tree, the BIN may be latched on entry also and if so it will be latched
     * on exit.
     *
     * Postconditions: The target BIN is latched.  When positioned in a dup
     * tree, the DBIN will be latched if it was latched on entry or a blocking
     * lock was needed.  Therefore, when positioned in a dup tree, releaseDBIN
     * should be called.
     *
     * @param ln the LN to be locked.
     * @param lockType the type of lock requested.
     * @return the LockResult containing the LN that was locked, or containing
     * a null LN if the LN was deleted or cleaned.  If the LN is deleted, a
     * lock will not be held.
     */
    private LockResult lockLN(LN ln, LockType lockType)
        throws DatabaseException {

        LockResult lockResult = lockLNDeletedAllowed(ln, lockType);
        ln = lockResult.getLN();
        if (ln != null) {
            setTargetBin();
            if (targetBin.isEntryKnownDeleted(targetIndex) ||
                ln.isDeleted()) {
                revertLock(ln.getNodeId(), lockResult.getLockGrant());
                lockResult.setLN(null);
            }
        }
        return lockResult;
    }

    /**
     * Locks the given LN's node ID; a deleted LN will be locked and returned.
     * Attempts to use a non-blocking lock to avoid unlatching/relatching.
     * Retries if necessary, to handle the case where the LN is changed while
     * the BIN is unlatched.
     *
     * Preconditions: The target BIN must be latched.  When positioned in a dup
     * tree, the BIN may be latched on entry also and if so it will be latched
     * on exit.
     *
     * Postconditions: The target BIN is latched.  When positioned in a dup
     * tree, the DBIN will be latched if it was latched on entry or a blocking
     * lock was needed.  Therefore, when positioned in a dup tree, releaseDBIN
     * should be called.
     *
     * @param ln the LN to be locked.
     * @param lockType the type of lock requested.
     * @return the LockResult containing the LN that was locked, or containing
     * a null LN if the LN was cleaned.
     */
    public LockResult lockLNDeletedAllowed(LN ln, LockType lockType)
        throws DatabaseException {

        LockResult lockResult;

        /*
         * Try a non-blocking lock first, to avoid unlatching.  If the default
         * is no-wait, use the standard lock method so
         * LockNotAvailableException is thrown; there is no need to try a
         * non-blocking lock twice.
         *
         * Even for dirty-read (LockType.NONE) we must call Locker.lock() since
         * it checks the locker state and may throw LockPreemptedException.
         */
        if (locker.getDefaultNoWait()) {
            try {
                lockResult = locker.lock
                    (ln.getNodeId(), lockType, true /*noWait*/, databaseImpl);
            } catch (LockConflictException e) {

                /*
                 * Release all latches.  Note that we catch
                 * LockConflictException for simplicity but we expect either
                 * LockNotAvailableException or LockNotGrantedException.
                 */
                releaseBINs();
                throw e;
            }
        } else {
            lockResult = locker.nonBlockingLock
                (ln.getNodeId(), lockType, databaseImpl);
        }
        if (lockResult.getLockGrant() != LockGrantType.DENIED) {
            lockResult.setLN(ln);
            assert verifyPendingDeleted(ln, lockType);
            return lockResult;
        }

        /*
         * Unlatch, get a blocking lock, latch, and get the current node from
         * the slot.  If the node ID changed while unlatched, revert the lock
         * and repeat.
         */
        while (true) {

            /* Save the node ID we're locking and request a lock. */
            long nodeId = ln.getNodeId();
            releaseBINs();
            lockResult = locker.lock
                (nodeId, lockType, false /*noWait*/, databaseImpl);

            /* Fetch the current node after locking. */
            latchBINs();
            setTargetBin();
            ln = (LN) targetBin.fetchTarget(targetIndex);

            if (ln != null && nodeId != ln.getNodeId()) {
                /* If the node ID changed, revert the lock and try again. */
                revertLock(nodeId, lockResult.getLockGrant());
                continue;
            } else {
                /* If null (cleaned) or locked correctly, return the LN. */
                lockResult.setLN(ln);
                assert verifyPendingDeleted(ln, lockType);
                return lockResult;
            }
        }
    }

    /**
     * Locks the DupCountLN for the given duplicate root.  Attempts to use a
     * non-blocking lock to avoid unlatching/relatching.
     *
     * Preconditions: The dupRoot, BIN and DBIN are latched.
     * Postconditions: The dupRoot, BIN and DBIN are latched.
     *
     * Note that the dupRoot may change during locking and should be refetched
     * if needed.
     *
     * @param dupRoot the duplicate root containing the DupCountLN to be
     * locked.
     * @param lockType the type of lock requested.
     * @return the LockResult containing the LN that was locked.
     */
    public LockResult lockDupCountLN(DIN dupRoot, LockType lockType)
        throws DatabaseException {

        DupCountLN ln = dupRoot.getDupCountLN();
        LockResult lockResult;

        /*
         * Try a non-blocking lock first, to avoid unlatching.  If the default
         * is no-wait, use the standard lock method so
         * LockNotAvailableException is thrown; there is no need to try a
         * non-blocking lock twice.
         */
        if (locker.getDefaultNoWait()) {
            try {
                lockResult = locker.lock
                    (ln.getNodeId(), lockType, true /*noWait*/, databaseImpl);
            } catch (LockConflictException e) {
                /*
                 * Release all latches.  Note that we catch
                 * LockConflictException for simplicity but we expect either
                 * LockNotAvailableException or LockNotGrantedException.
                 */
                dupRoot.releaseLatch();
                releaseBINs();
                throw e;
            }
        } else {
            lockResult = locker.nonBlockingLock
                (ln.getNodeId(), lockType, databaseImpl);
        }

        if (lockResult.getLockGrant() == LockGrantType.DENIED) {
            /* Release all latches. */
            dupRoot.releaseLatch();
            releaseBINs();
            /* Request a blocking lock. */
            lockResult = locker.lock
                (ln.getNodeId(), lockType, false /*noWait*/, databaseImpl);
            /* Reacquire all latches. */
            latchBIN();
            dupRoot = (DIN) bin.fetchTarget(index);
            dupRoot.latch(cacheMode);
            latchDBIN();
            ln = dupRoot.getDupCountLN();
        }
        lockResult.setLN(ln);
        return lockResult;
    }

    /**
     * Fetch, latch and return the DIN root of the duplicate tree at the cursor
     * position.
     *
     * Preconditions: The BIN must be latched and the current BIN entry must
     * contain a DIN.
     *
     * Postconditions: The BIN and DIN will be latched.  The DBIN will remain
     * latched if isDBINLatched is true.
     *
     * @param isDBINLatched is true if the DBIN is currently latched.
     */
    public DIN getLatchedDupRoot(boolean isDBINLatched)
        throws DatabaseException {

        assert bin != null;
        assert bin.isLatchOwnerForWrite();
        assert index >= 0;

        DIN dupRoot = (DIN) bin.fetchTarget(index);

        if (isDBINLatched) {

            /*
             * The BIN and DBIN are currently latched and we need to latch the
             * dupRoot, which is between the BIN and DBIN in the tree.  First
             * try latching the dupRoot no-wait; if this works, we have latched
             * out of order, but in a way that does not cause deadlocks.  If we
             * don't get the no-wait latch, then release the DBIN latch and
             * latch in the proper order down the tree.
             */
            if (!dupRoot.latchNoWait(cacheMode)) {
                releaseDBIN();
                dupRoot.latch(cacheMode);
                latchDBIN();
            }
        } else {
            dupRoot.latch(cacheMode);
        }

        return dupRoot;
    }

    /**
     * Helper to return a Data DBT from a BIN.
     */
    public static void setDbt(DatabaseEntry data, byte[] bytes) {

        if (bytes != null) {
            boolean partial = data.getPartial();
            int off = partial ? data.getPartialOffset() : 0;
            int len = partial ? data.getPartialLength() : bytes.length;
            if (off + len > bytes.length) {
                len = (off > bytes.length) ? 0 : bytes.length  - off;
            }

            byte[] newdata = null;
            if (len == 0) {
                newdata = LogUtils.ZERO_LENGTH_BYTE_ARRAY;
            } else {
                newdata = new byte[len];
                System.arraycopy(bytes, off, newdata, 0, len);
            }
            data.setData(newdata);
            data.setOffset(0);
            data.setSize(len);
        } else {
            data.setData(null);
            data.setOffset(0);
            data.setSize(0);
        }
    }

    /*
     * For debugging. Verify that a BINs cursor set refers to the BIN.
     */
    private void verifyCursor(BIN bin)
        throws DatabaseException {

        if (!bin.getCursorSet().contains(this)) {
            throw new EnvironmentFailureException
                (databaseImpl.getDbEnvironment(),
                 EnvironmentFailureReason.UNEXPECTED_STATE,
                 "BIN cursorSet is inconsistent");
        }
    }

    /**
     * Calls checkCursorState and returns false is an exception is thrown.
     */
    private boolean assertCursorState(boolean mustBeInitialized) {
        try {
            checkCursorState(mustBeInitialized);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    /**
     * Check that the cursor is open and optionally if it is initialized.
     *
     * @throws IllegalStateException via all Cursor methods that call
     * Cursor.checkState (all get and put methods, plus more).
     */
    public void checkCursorState(boolean mustBeInitialized) {
        switch (status) {
        case CURSOR_NOT_INITIALIZED:
            if (mustBeInitialized) {
                throw new IllegalStateException("Cursor not initialized.");
            }
            break;
        case CURSOR_INITIALIZED:
            if (DEBUG) {
                if (bin != null) {
                    verifyCursor(bin);
                }
                if (dupBin != null) {
                    verifyCursor(dupBin);
                }
            }
            break;
        case CURSOR_CLOSED:
            throw new IllegalStateException("Cursor has been closed.");
        default:
            throw EnvironmentFailureException.unexpectedState
                ("Unknown cursor status: " + status);
        }
    }

    /**
     * Checks that LN deletedness matches KD/PD flag state, at least when the
     * LN is resident.  Should only be called under an assertion.
     */
    private boolean verifyPendingDeleted(LN ln, LockType lockType) {

        /* Cannot verify deletedness if LN is not resident and locked. */
        if (ln == null || lockType == LockType.NONE) {
            return true;
        }

        /* Get PD and KD. */
        final boolean kd;
        final boolean pd;
        if (dupBin != null) {
            if (dupIndex < 0) {
                return true;
            }
            kd = dupBin.isEntryKnownDeleted(dupIndex);
            pd = dupBin.isEntryPendingDeleted(dupIndex);
        } else if (bin != null) {
            if (index < 0) {
                return true;
            }
            kd = bin.isEntryKnownDeleted(index);
            pd = bin.isEntryPendingDeleted(index);
        } else {
            return true;
        }

        /*
         * If the LN is deleted then KD or PD must be set.  If the LN is not
         * deleted then PD must not be set, but KD may or may not be set since
         * it used for various purposes (see IN.java).
         */
        final boolean lnDeleted = ln.isDeleted();
        assert ((lnDeleted && (kd || pd)) || (!lnDeleted && !pd)) :
               "Deleted state mismatch LNDeleted = " + lnDeleted +
               " PD = " + pd + " KD = " + kd;
        return true;
    }

    /**
     * Return this lock to its prior status. If the lock was just obtained,
     * release it. If it was promoted, demote it.
     */
    private void revertLock(LN ln, LockResult lockResult)
        throws DatabaseException {

        revertLock(ln.getNodeId(), lockResult.getLockGrant());
    }

    /**
     * Return this lock to its prior status. If the lock was just obtained,
     * release it. If it was promoted, demote it.
     */
    private void revertLock(long nodeId, LockGrantType lockStatus)
        throws DatabaseException {

        if ((lockStatus == LockGrantType.NEW) ||
            (lockStatus == LockGrantType.WAIT_NEW)) {
            locker.releaseLock(nodeId);
        } else if ((lockStatus == LockGrantType.PROMOTION) ||
                   (lockStatus == LockGrantType.WAIT_PROMOTION)){
            locker.demoteLock(nodeId);
        }
    }

    /**
     * Locks the logical EOF node for the databaseImpl.
     */
    public void lockEofNode(LockType lockType)
        throws DatabaseException {

        locker.lock(databaseImpl.getEofNodeId(), lockType,
                    false /*noWait*/, databaseImpl);
    }

    /**
     * @throws EnvironmentFailureException if the underlying environment is
     * invalid.
     */
    public void checkEnv() {
        databaseImpl.getDbEnvironment().checkIfInvalid();
    }

    /**
     * Callback object for traverseDbWithCursor.
     */
    public interface WithCursor {

        /**
         * Called for each record in the databaseImpl.
         * @return true to continue or false to stop the enumeration.
         */
        boolean withCursor(CursorImpl cursor,
                           DatabaseEntry key,
                           DatabaseEntry data)
            throws DatabaseException;
    }

    /**
     * Enumerates all records in a databaseImpl non-transactionally and calls
     * the withCursor method for each record.  Stops the enumeration if the
     * callback returns false.
     *
     * @param db DatabaseImpl to traverse.
     *
     * @param lockType non-null LockType for reading records.
     *
     * @param allowEviction should normally be true to evict when performing
     * multiple operations, but may be false if eviction is disallowed in a
     * particular context.
     *
     * @param withCursor callback object.
     */
    public static void traverseDbWithCursor(DatabaseImpl db,
                                            LockType lockType,
                                            boolean allowEviction,
                                            WithCursor withCursor)
        throws DatabaseException {

        DatabaseEntry key = new DatabaseEntry();
        DatabaseEntry data = new DatabaseEntry();
        Locker locker = null;
        CursorImpl cursor = null;
        try {
            EnvironmentImpl envImpl = db.getDbEnvironment();
            locker = LockerFactory.getInternalReadOperationLocker(envImpl);
            cursor = new CursorImpl(db, locker);
            cursor.setAllowEviction(allowEviction);
            if (cursor.positionFirstOrLast(true,    // first
                                           null)) { // duplicateRoot
                OperationStatus status = cursor.getCurrentAlreadyLatched
                    (key, data, lockType, true); // first
                boolean done = false;
                while (!done) {

                    /*
                     * getCurrentAlreadyLatched may have returned non-SUCCESS
                     * if the first record is deleted, but we can call getNext
                     * below to move forward.
                     */
                    if (status == OperationStatus.SUCCESS) {
                        if (!withCursor.withCursor(cursor, key, data)) {
                            done = true;
                        }
                    }
                    if (!done) {
                        status = cursor.getNext(key, data, lockType,
                                                true,   // forward
                                                false); // alreadyLatched
                        if (status != OperationStatus.SUCCESS) {
                            done = true;
                        }
                    }
                }
            }
        } finally {
            if (cursor != null) {
                cursor.releaseBINs();
                cursor.close();
            }
            if (locker != null) {
                locker.operationEnd();
            }
        }
    }

    /**
     * Dump the cursor for debugging purposes.  Dump the bin and dbin that the
     * cursor refers to if verbose is true.
     */
    public void dump(boolean verbose) {
        System.out.println(dumpToString(verbose));
    }

    /**
     * dump the cursor for debugging purposes.
     */
    public void dump() {
        System.out.println(dumpToString(true));
    }

    /*
     * dumper
     */
    private String statusToString(byte status) {
        switch(status) {
        case CURSOR_NOT_INITIALIZED:
            return "CURSOR_NOT_INITIALIZED";
        case CURSOR_INITIALIZED:
            return "CURSOR_INITIALIZED";
        case CURSOR_CLOSED:
            return "CURSOR_CLOSED";
        default:
            return "UNKNOWN (" + Byte.toString(status) + ")";
        }
    }

    /*
     * dumper
     */
    public String dumpToString(boolean verbose) {
        StringBuffer sb = new StringBuffer();

        sb.append("<Cursor idx=\"").append(index).append("\"");
        if (dupBin != null) {
            sb.append(" dupIdx=\"").append(dupIndex).append("\"");
        }
        sb.append(" status=\"").append(statusToString(status)).append("\"");
        sb.append(">\n");
        if (verbose) {
            sb.append((bin == null) ? "" : bin.dumpString(2, true));
            sb.append((dupBin == null) ? "" : dupBin.dumpString(2, true));
        }
        sb.append("\n</Cursor>");

        return sb.toString();
    }

    /*
     * For unit tests
     */
    public StatGroup getLockStats()
        throws DatabaseException {

        return locker.collectStats();
    }

    /**
     * Send trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    private void trace(Level level,
                       String changeType,
                       BIN theBin,
                       LN ln,
                       int lnIndex,
                       long oldLsn,
                       long newLsn) {
        EnvironmentImpl envImpl = databaseImpl.getDbEnvironment();
        if (envImpl.getLogger().isLoggable(level)) {
            StringBuffer sb = new StringBuffer();
            sb.append(changeType);
            sb.append(" bin=");
            sb.append(theBin.getNodeId());
            sb.append(" ln=");
            sb.append(ln.getNodeId());
            sb.append(" lnIdx=");
            sb.append(lnIndex);
            sb.append(" oldLnLsn=");
            sb.append(DbLsn.getNoFormatString(oldLsn));
            sb.append(" newLnLsn=");
            sb.append(DbLsn.getNoFormatString(newLsn));

            LoggerUtils.logMsg
                (envImpl.getLogger(), envImpl, level, sb.toString());
        }
    }

    /* For unit testing only. */
    public void setTestHook(TestHook hook) {
        testHook = hook;
    }

    /* Check that the target bin is latched. For use in assertions. */
    private boolean checkAlreadyLatched(boolean alreadyLatched) {
        if (alreadyLatched) {
            if (dupBin != null) {
                return dupBin.isLatchOwnerForWrite();
            } else if (bin != null) {
                return bin.isLatchOwnerForWrite();
            }
        }
        return true;
    }
}
