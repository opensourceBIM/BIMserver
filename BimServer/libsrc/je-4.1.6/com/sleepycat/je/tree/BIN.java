/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.cleaner.Cleaner;
import com.sleepycat.je.cleaner.LocalUtilizationTracker;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.evictor.Evictor.EvictionSource;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.log.Provisional;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.log.entry.SingleItemEntry;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.RelatchRequiredException;
import com.sleepycat.je.utilint.TinyHashSet;

/**
 * A BIN represents a Bottom Internal Node in the JE tree.
 */
public class BIN extends IN implements Loggable {

    private static final String BEGIN_TAG = "<bin>";
    private static final String END_TAG = "</bin>";

    /*
     * The set of cursors that are currently referring to this BIN.
     */
    private final TinyHashSet<CursorImpl> cursorSet;

    /*
     * Support for logging BIN deltas. (Partial BIN logging)
     */

    /* Location of last delta, for cleaning. */
    private long lastDeltaVersion = DbLsn.NULL_LSN;
    private int numDeltasSinceLastFull; // num deltas logged
    private boolean prohibitNextDelta;  // disallow delta on next log

    public BIN() {
        cursorSet = new TinyHashSet<CursorImpl>();
        numDeltasSinceLastFull = 0;
        prohibitNextDelta = false;
    }

    public BIN(DatabaseImpl db,
               byte[] identifierKey,
               int maxEntriesPerNode,
               int level) {
        super(db, identifierKey, maxEntriesPerNode, level);

        cursorSet = new TinyHashSet<CursorImpl>();
        numDeltasSinceLastFull = 0;
        prohibitNextDelta = false;
    }

    /**
     * Create a holder object that encapsulates information about this BIN for
     * the INCompressor.
     */
    public BINReference createReference() {
      return new BINReference(getNodeId(), getDatabase().getId(),
                              getIdentifierKey());
    }

    /**
     * Create a new BIN.  Need this because we can't call newInstance()
     * without getting a 0 for nodeid.
     */
    @Override
    protected IN createNewInstance(byte[] identifierKey,
                                   int maxEntries,
                                   int level) {
        return new BIN(getDatabase(), identifierKey, maxEntries, level);
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
        return !getDatabase().getSortedDuplicates();
    }

    /**
     * Get the key (dupe or identifier) in child that is used to locate it in
     * 'this' node.  For BIN's, the child node has to be a DIN so we use the
     * Dup Key to cross the main-tree/dupe-tree boundary.
     */
    @Override
    public byte[] getChildKey(IN child) {
        return child.getDupKey();
    }

    /**
     * @return the log entry type to use for bin delta log entries.
     */
    LogEntryType getBINDeltaType() {
        return LogEntryType.LOG_BIN_DELTA;
    }

    /**
     * @return location of last logged delta version. If never set,
     * return null.
     */
    public long getLastDeltaVersion() {
        return lastDeltaVersion;
    }

    /**
     * If cleaned or compressed, must log full version.
     */
    @Override
    public void setProhibitNextDelta() {
        prohibitNextDelta = true;
    }

    /*
     * If this search can go further, return the child. If it can't, and you
     * are a possible new parent to this child, return this IN. If the search
     * can't go further and this IN can't be a parent to this child, return
     * null.
     */
    @Override
    protected void descendOnParentSearch(SearchResult result,
                                         boolean targetContainsDuplicates,
                                         boolean targetIsRoot,
                                         long targetNodeId,
                                         Node child,
                                         boolean requireExactMatch)
        throws DatabaseException {

        if (child.canBeAncestor(targetContainsDuplicates)) {
            if (targetContainsDuplicates && targetIsRoot) {

                /*
                 * Don't go further -- the target is a root of a dup tree, so
                 * this BIN will have to be the parent.
                 */
                long childNid = child.getNodeId();
                ((IN) child).releaseLatch();

                result.keepSearching = false;           // stop searching

                if (childNid  == targetNodeId) {        // set if exact find
                    result.exactParentFound = true;
                } else {
                    result.exactParentFound = false;
                }

                /*
                 * Return a reference to this node unless we need an exact
                 * match and this isn't exact.
                 */
                if (requireExactMatch && ! result.exactParentFound) {
                    result.parent = null;
                    releaseLatch();
                } else {
                    result.parent = this;
                }

            } else {
                /*
                 * Go further down into the dup tree.
                 */
                releaseLatch();
                result.parent = (IN) child;
            }
        } else {

            /*
             * Our search ends, we didn't find it. If we need an exact match,
             * give up, if we only need a potential match, keep this node
             * latched and return it.
             */
            result.exactParentFound = false;
            result.keepSearching = false;
            if (!requireExactMatch && targetContainsDuplicates) {
                result.parent = this;
            } else {
                releaseLatch();
                result.parent = null;
            }
        }
    }

    /*
     * A BIN can be the ancestor of an internal node of the duplicate tree. It
     * can't be the parent of an IN or another BIN.
     */
    @Override
    protected boolean canBeAncestor(boolean targetContainsDuplicates) {
        /* True if the target is a DIN or DBIN */
        return targetContainsDuplicates;
    }

    /**
     * Note that the IN may or may not be latched when this method is called.
     * Returning the wrong answer is OK in that case (it will be called again
     * later when latched), but an exception should not occur.
     */
    @Override
    boolean isEvictionProhibited() {
        return (nCursors() > 0);
    }

    /**
     * Note that the IN may or may not be latched when this method is called.
     * Returning the wrong answer is OK in that case (it will be called again
     * later when latched), but an exception should not occur.
     */
    @Override
    boolean hasPinnedChildren() {

        DatabaseImpl db = getDatabase();

        /*
         * For the mapping DB, if any MapLN is resident we cannot evict this
         * BIN.  If a MapLN was not previously stripped, then the DB may be
         * open.  [#13415]
         */
        if (db.getId().equals(DbTree.ID_DB_ID)) {
            return hasResidentChildren();

        /*
         * For other DBs, if there are no duplicates allowed we can always
         * evict this BIN because its children are limited to LNs.  When
         * logging the BIN, any dirty LNs will be logged and non-dirty LNs can
         * be discarded.
         */
        } else if (!db.getSortedDuplicates()) {
            return false;

        /*
         * If duplicates are allowed, we disallow eviction of this BIN if it
         * has any non-LN (DIN) children.
         */
        } else {
            for (int i = 0; i < getNEntries(); i++) {
                Node node = getTarget(i);
                if (node != null) {
                    if (!(node instanceof LN)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Note that the IN may or may not be latched when this method is called.
     * Returning the wrong answer is OK in that case (it will be called again
     * later when latched), but an exception should not occur.
     */
    @Override
    int getChildEvictionType() {

        Cleaner cleaner = getDatabase().getDbEnvironment().getCleaner();

        for (int i = 0; i < getNEntries(); i++) {
            Node node = getTarget(i);
            if (node != null) {
                if (node instanceof LN) {
                    LN ln = (LN) node;

                    /*
                     * If the LN is not evictable, we may neither strip the LN
                     * nor evict the node.  isEvictableInexact is used here as
                     * a fast check, to avoid the overhead of acquiring a
                     * handle lock while selecting an IN for eviction.   See
                     * evictInternal which will call LN.isEvictable to acquire
                     * an handle lock and guarantee that another thread cannot
                     * open the MapLN.  [#13415]
                     */
                    if (!ln.isEvictableInexact()) {
                        return MAY_NOT_EVICT;
                    }

                    /*
                     * If the cleaner allows eviction, then this LN may be
                     * stripped.
                     */
                    if (cleaner.isEvictable(this, i)) {
                        return MAY_EVICT_LNS;
                    }
                } else {
                    return MAY_NOT_EVICT;
                }
            }
        }
        return MAY_EVICT_NODE;
    }

    /**
     * Indicates whether entry 0's key is "special" in that it always compares
     * less than any other key.  BIN's don't have the special key, but IN's do.
     */
    @Override
    boolean entryZeroKeyComparesLow() {
        return false;
    }

    /**
     * Mark this entry as deleted, using the delete flag. Only BINS may do
     * this.
     *
     * @param index indicates target entry
     */
    @Override
    public void setKnownDeleted(int index) {

        /*
         * The target is cleared to save memory, since a known deleted entry
         * will never be fetched.  The migrate flag is also cleared since
         * migration is never needed for known deleted entries either.
         */
        super.setKnownDeleted(index);

        /*
         * We know it's an LN because we never call setKnownDeleted for
         * an IN.
         */
        LN oldLN = (LN) getTarget(index);
        updateMemorySize(oldLN, null /* newNode */);
        if (oldLN != null) {
            oldLN.releaseMemoryBudget();
        }
        setMigrate(index, false);
        super.setTarget(index, null);
        setDirty(true);
    }

    /**
     * Mark this entry as deleted, using the delete flag. Only BINS may do
     * this.  Don't null the target field.
     *
     * This is used so that an LN can still be locked by the compressor even if
     * the entry is knownDeleted.  See BIN.compress.
     *
     * @param index indicates target entry
     */
    public void setKnownDeletedLeaveTarget(int index) {

        /*
         * The migrate flag is cleared since migration is never needed for
         * known deleted entries.
         */
        setMigrate(index, false);
        super.setKnownDeleted(index);
        setDirty(true);
    }

    public void setKnownDeletedClearAll(int index) {
        setKnownDeleted(index);
        setLsnElement(index, DbLsn.NULL_LSN);
    }

    /**
     * Clear the known deleted flag. Only BINS may do this.
     * @param index indicates target entry
     */
    @Override
    public void clearKnownDeleted(int index) {
        super.clearKnownDeleted(index);
        setDirty(true);
    }

    /* Called once at environment startup by MemoryBudget */
    public static long computeOverhead(DbConfigManager configManager) {

        /*
         * Overhead consists of all the fields in this class plus the
         * entry arrays in the IN class.
         */
        return MemoryBudget.BIN_FIXED_OVERHEAD +
            IN.computeArraysOverhead(configManager);
    }

    @Override
    protected long getMemoryOverhead(MemoryBudget mb) {
        return mb.getBINOverhead();
    }

    /**
     * Returns the treeAdmin memory in objects referenced by this BIN.
     * Specifically, this refers to the DbFileSummaryMap held by
     * MapLNs
     */
    @Override
    public long getTreeAdminMemorySize() {

        if (getDatabase().getId().equals(DbTree.ID_DB_ID)) {
            long treeAdminMem = 0;
            for (int i = 0; i < getMaxEntries(); i++) {
                Node n = getTarget(i);
                if (n != null) {
                    MapLN mapLN = (MapLN) n;
                    treeAdminMem += mapLN.getDatabase().getTreeAdminMemory();
                }
            }
            return treeAdminMem;
        } else {
            return 0;
        }
    }

    /*
     * Cursors
     */

    /* public for the test suite. */
    public Set<CursorImpl> getCursorSet() {
        return cursorSet.copy();
    }

    /**
     * Register a cursor with this BIN.  Caller has this BIN already latched.
     * @param cursor Cursor to register.
     */
    public void addCursor(CursorImpl cursor) {
        assert isLatchOwnerForWrite();
        cursorSet.add(cursor);
    }

    /**
     * Unregister a cursor with this bin.  Caller has this BIN already
     * latched.
     *
     * @param cursor Cursor to unregister.
     */
    public void removeCursor(CursorImpl cursor) {
        assert isLatchOwnerForWrite();
        cursorSet.remove(cursor);
    }

    /**
     * For assertions in CursorImpl.
     */
    public boolean containsCursor(CursorImpl cursor) {
        if (isLatchOwnerForWrite()) {
            return cursorSet.contains(cursor);
        }
        try {
            latch();
            return cursorSet.contains(cursor);
        } finally {
            releaseLatch();
        }
    }

    /**
     * @return the number of cursors currently referring to this BIN.
     */
    public int nCursors() {
        return cursorSet.size();
    }

    /**
     * The following four methods access the correct fields in a cursor
     * depending on whether "this" is a BIN or DBIN.  For BIN's, the
     * CursorImpl.index and CursorImpl.bin fields should be used.  For DBIN's,
     * the CursorImpl.dupIndex and CursorImpl.dupBin fields should be used.
     */
    BIN getCursorBIN(CursorImpl cursor) {
        return cursor.getBIN();
    }

    BIN getCursorBINToBeRemoved(CursorImpl cursor) {
        return cursor.getBINToBeRemoved();
    }

    int getCursorIndex(CursorImpl cursor) {
        return cursor.getIndex();
    }

    void setCursorBIN(CursorImpl cursor, BIN bin) {
        cursor.setBIN(bin);
    }

    void setCursorIndex(CursorImpl cursor, int index) {
        cursor.setIndex(index);
    }

    /**
     * Called when we know we are about to split on behalf of a key that is the
     * minimum (leftSide) or maximum (!leftSide) of this node.  This is
     * achieved by just forcing the split to occur either one element in from
     * the left or the right (i.e. splitIndex is 1 or nEntries - 1).
     */
    @Override
    void splitSpecial(IN parent,
                      int parentIndex,
                      int maxEntriesPerNode,
                      byte[] key,
                      boolean leftSide,
                      CacheMode cacheMode)
        throws DatabaseException {

        int index = findEntry(key, true, false);
        int nEntries = getNEntries();
        boolean exact = (index & IN.EXACT_MATCH) != 0;
        index &= ~IN.EXACT_MATCH;
        if (leftSide &&
            index < 0) {
            splitInternal(parent, parentIndex, maxEntriesPerNode,
                          1, cacheMode);
        } else if (!leftSide &&
                   !exact &&
                   index == (nEntries - 1)) {
            splitInternal(parent, parentIndex, maxEntriesPerNode,
                          nEntries - 1, cacheMode);
        } else {
            split(parent, parentIndex, maxEntriesPerNode, cacheMode);
        }
    }

    /**
     * Adjust any cursors that are referring to this BIN.  This method is
     * called during a split operation.  "this" is the BIN being split.
     * newSibling is the new BIN into which the entries from "this" between
     * newSiblingLow and newSiblingHigh have been copied.
     *
     * @param newSibling - the newSibling into which "this" has been split.
     * @param newSiblingLow, newSiblingHigh - the low and high entry of
     * "this" that were moved into newSibling.
     */
    @Override
    void adjustCursors(IN newSibling,
                       int newSiblingLow,
                       int newSiblingHigh) {
        assert newSibling.isLatchOwnerForWrite();
        assert this.isLatchOwnerForWrite();
        int adjustmentDelta = (newSiblingHigh - newSiblingLow);
        Iterator<CursorImpl> iter = cursorSet.iterator();
        while (iter.hasNext()) {
            CursorImpl cursor = iter.next();
            if (getCursorBINToBeRemoved(cursor) == this) {

                /*
                 * This BIN will be removed from the cursor by CursorImpl
                 * following advance to next BIN; ignore it.
                 */
                continue;
            }
            int cIdx = getCursorIndex(cursor);
            BIN cBin = getCursorBIN(cursor);
            assert cBin == this :
                "nodeId=" + getNodeId() +
                " cursor=" + cursor.dumpToString(true);
            assert newSibling instanceof BIN;

            /*
             * There are four cases to consider for cursor adjustments,
             * depending on (1) how the existing node gets split, and (2) where
             * the cursor points to currently.  In cases 1 and 2, the id key of
             * the node being split is to the right of the splitindex so the
             * new sibling gets the node entries to the left of that index.
             * This is indicated by "new sibling" to the left of the vertical
             * split line below.  The right side of the node contains entries
             * that will remain in the existing node (although they've been
             * shifted to the left).  The vertical bar (^) indicates where the
             * cursor currently points.
             *
             * case 1:
             *
             *   We need to set the cursor's "bin" reference to point at the
             *   new sibling, but we don't need to adjust its index since that
             *   continues to be correct post-split.
             *
             *   +=======================================+
             *   |  new sibling        |  existing node  |
             *   +=======================================+
             *         cursor ^
             *
             * case 2:
             *
             *   We only need to adjust the cursor's index since it continues
             *   to point to the current BIN post-split.
             *
             *   +=======================================+
             *   |  new sibling        |  existing node  |
             *   +=======================================+
             *                              cursor ^
             *
             * case 3:
             *
             *   Do nothing.  The cursor continues to point at the correct BIN
             *   and index.
             *
             *   +=======================================+
             *   |  existing Node        |  new sibling  |
             *   +=======================================+
             *         cursor ^
             *
             * case 4:
             *
             *   Adjust the "bin" pointer to point at the new sibling BIN and
             *   also adjust the index.
             *
             *   +=======================================+
             *   |  existing Node        |  new sibling  |
             *   +=======================================+
             *                                 cursor ^
             */
            BIN ns = (BIN) newSibling;
            if (newSiblingLow == 0) {
                if (cIdx < newSiblingHigh) {
                    /* case 1 */
                    iter.remove();
                    setCursorBIN(cursor, ns);
                    ns.addCursor(cursor);
                } else {
                    /* case 2 */
                    setCursorIndex(cursor, cIdx - adjustmentDelta);
                }
            } else {
                if (cIdx >= newSiblingLow) {
                    /* case 4 */
                    setCursorIndex(cursor, cIdx - newSiblingLow);
                    iter.remove();
                    setCursorBIN(cursor, ns);
                    ns.addCursor(cursor);
                }
            }
        }
    }

    /**
     * For each cursor in this BIN's cursor set, ensure that the cursor is
     * actually referring to this BIN.
     */
    public void verifyCursors() {
        if (cursorSet != null) {
            Iterator<CursorImpl> iter = cursorSet.iterator();
            while (iter.hasNext()) {
                CursorImpl cursor = iter.next();
                if (getCursorBINToBeRemoved(cursor) != this) {
                    BIN cBin = getCursorBIN(cursor);
                    assert cBin == this;
                }
            }
        }
    }

    /**
     * Adjust cursors referring to this BIN following an insert.
     *
     * @param insertIndex - The index of the new entry.
     */
    @Override
    void adjustCursorsForInsert(int insertIndex) {
        assert this.isLatchOwnerForWrite();
        /* cursorSet may be null if this is being created through
           createFromLog() */
        if (cursorSet != null) {
            Iterator<CursorImpl> iter = cursorSet.iterator();
            while (iter.hasNext()) {
                CursorImpl cursor = iter.next();
                if (getCursorBINToBeRemoved(cursor) != this) {
                    int cIdx = getCursorIndex(cursor);
                    if (insertIndex <= cIdx) {
                        setCursorIndex(cursor, cIdx + 1);
                    }
                }
            }
        }
    }

    /**
     * Adjust cursors referring to the given binIndex in this BIN following a
     * mutation of the entry from an LN to a DIN.  The entry was moved from a
     * BIN to a newly created DBIN so each cursor must be added to the new
     * DBIN.
     *
     * @param binIndex - The index of the DIN (previously LN) entry in the BIN.
     *
     * @param dupBin - The DBIN into which the LN entry was moved.
     *
     * @param dupBinIndex - The index of the moved LN entry in the DBIN.
     *
     * @param excludeCursor - The cursor being used for insertion and that
     * should not be updated.
     */
    void adjustCursorsForMutation(int binIndex,
                                  DBIN dupBin,
                                  int dupBinIndex,
                                  CursorImpl excludeCursor) {
        assert this.isLatchOwnerForWrite();
        /* cursorSet may be null if this is being created through
           createFromLog() */
        if (cursorSet != null) {
            Iterator<CursorImpl> iter = cursorSet.iterator();
            while (iter.hasNext()) {
                CursorImpl cursor = iter.next();
                if (getCursorBINToBeRemoved(cursor) != this &&
                    cursor != excludeCursor &&
                    cursor.getIndex() == binIndex) {
                    assert cursor.getDupBIN() == null;
                    cursor.addCursor(dupBin);
                    cursor.updateDBin(dupBin, dupBinIndex);
                }
            }
        }
    }

    /**
     * Compress this BIN by removing any entries that are deleted.  Deleted
     * entries are those that have LN's marked deleted or if the knownDeleted
     * flag is set. Caller is responsible for latching and unlatching this
     * node.
     *
     * @param binRef is used to determine the set of keys to be checked for
     * deletedness, or is null to check all keys.
     *
     * @param canFetch if false, don't fetch any non-resident children. We
     * don't want some callers of compress, such as the evictor, to fault in
     * other nodes.
     *
     * @return true if we had to requeue the entry because we were unable to
     * get locks, false if all entries were processed and therefore any
     * remaining deleted keys in the BINReference must now be in some other BIN
     * because of a split.
     */
    @Override
    public boolean compress(BINReference binRef,
                            boolean canFetch,
                            LocalUtilizationTracker localTracker)
        throws DatabaseException {

        boolean ret = false;
        boolean setNewIdKey = false;
        boolean anyLocksDenied = false;
        DatabaseImpl db = getDatabase();
        EnvironmentImpl envImpl = db.getDbEnvironment();

        for (int i = 0; i < getNEntries(); i++) {
            final BasicLocker lockingTxn =
                BasicLocker.createBasicLocker(envImpl);
            /* Don't allow this short-lived lock to be preempted/stolen. */
            lockingTxn.setPreemptable(false);
            try {

                /*
                 * We have to be able to lock the LN before we can compress the
                 * entry.  If we can't, then, skip over it.
                 *
                 * We must lock the LN even if isKnownDeleted is true, because
                 * locks protect the aborts. (Aborts may execute multiple
                 * operations, where each operation latches and unlatches. It's
                 * the LN lock that protects the integrity of the whole
                 * multi-step process.)
                 *
                 * For example, during abort, there may be cases where we have
                 * deleted and then added an LN during the same txn.  This
                 * means that to undo/abort it, we first delete the LN (leaving
                 * knownDeleted set), and then add it back into the tree.  We
                 * want to make sure the entry is in the BIN when we do the
                 * insert back in.
                 */
                boolean deleteEntry = false;
                Node n = null;

                if (binRef == null ||
                    isEntryPendingDeleted(i) ||
                    isEntryKnownDeleted(i) ||
                    binRef.hasDeletedKey(new Key(getKey(i)))) {

                    if (canFetch) {
                        if (db.isDeferredWriteMode() &&
                            getLsn(i) == DbLsn.NULL_LSN) {
                            /* Null LSNs are ok in DW. [#15588] */
                            n = getTarget(i);
                        } else {
                            try {
                                n = fetchTarget(i);
                            } catch (EnvironmentFailureException e) {
                                if (failureNotAcceptable
                                    (e, 
                                     isEntryPendingDeleted(i),
                                     isEntryKnownDeleted(i))) {
                                    throw e;
                                }
                            }
                        }
                    } else {
                        n = getTarget(i);
                        if (n == null) {
                            /* Punt, we don't know the state of this child. */
                            continue;
                        }
                    }

                    if (n == null) {
                        /* Cleaner deleted the log file.  Compress this LN. */
                        deleteEntry = true;
                    } else if (isEntryKnownDeleted(i)) {
                        LockResult lockRet = lockingTxn.nonBlockingLock
                            (n.getNodeId(), LockType.READ, db);
                        if (lockRet.getLockGrant() == LockGrantType.DENIED) {
                            anyLocksDenied = true;
                            continue;
                        }

                        deleteEntry = true;
                    } else {
                        if (!n.containsDuplicates()) {
                            LN ln = (LN) n;
                            LockResult lockRet = lockingTxn.nonBlockingLock
                                (ln.getNodeId(), LockType.READ, db);
                            if (lockRet.getLockGrant() ==
                                LockGrantType.DENIED) {
                                anyLocksDenied = true;
                                continue;
                            }

                            if (ln.isDeleted()) {
                                deleteEntry = true;
                            }
                        }
                    }

                    /* Remove key from BINReference in case we requeue it. */
                    if (binRef != null) {
                        binRef.removeDeletedKey(new Key(getKey(i)));
                    }
                }

                /* At this point, we know we can delete. */
                if (deleteEntry) {
                    boolean entryIsIdentifierKey = Key.compareKeys
                        (getKey(i), getIdentifierKey(),
                         getKeyComparator()) == 0;
                    if (entryIsIdentifierKey) {

                        /*
                         * We're about to remove the entry with the idKey so
                         * the node will need a new idkey.
                         */
                        setNewIdKey = true;
                    }

                    if (db.isDeferredWriteMode() &&
                        n instanceof LN) {
                        LN ln = (LN) n;
                        long lsn = getLsn(i);
                        if (ln.isDirty() && lsn != DbLsn.NULL_LSN) {
                            if (db.isTemporary()) {

                                /*
                                 * When a previously logged LN in a temporary
                                 * DB is dirty, we can count the LSN of the
                                 * last logged LN as obsolete without logging.
                                 * There it no requirement for the dirty
                                 * deleted LN to be durable past recovery.
                                 * There is no danger of the last logged LN
                                 * being accessed again (after log cleaning,
                                 * for example), since temporary DBs do not
                                 * survive recovery.
                                 */
                                if (localTracker != null) {
                                    localTracker.countObsoleteNode
                                        (lsn, ln.getLogType(),
                                         ln.getLastLoggedSize(), db);
                                }
                            } else {

                                /*
                                 * When a previously logged deferred-write LN
                                 * is dirty, we log the dirty deleted LN to
                                 * make the deletion durable.  The act of
                                 * logging will also count the last logged LSN
                                 * as obsolete.
                                 */
                                logDirtyLN(i, ln, false /*force*/);
                            }
                        }
                    }

                    boolean deleteSuccess = deleteEntry(i, true);
                    assert deleteSuccess;

                    /*
                     * Since we're deleting the current entry, bump the current
                     * index back down one.
                     */
                    i--;
                }
            } finally {
                lockingTxn.operationEnd();
            }
        }

        if (anyLocksDenied && binRef != null) {
            db.getDbEnvironment().addToCompressorQueue(binRef, false);
            ret = true;
        }

        if (getNEntries() != 0 && setNewIdKey) {
            setIdentifierKey(getKey(0));
        }

        /* This BIN is empty and expendable. */
        if (getNEntries() == 0) {
            setGeneration(0);
        }

        return ret;
    }

    /**
     * This is a 4.1 only check to account for SR #19033. In this case, a
     * LogIntegrity exception is received on the behalf of an pending deleted
     * or known deleted invisible entry. Since these items are deleted, it's
     * actually okay if the entry is invisible, and the item may be ignored;
     * the item is meant to be truncated from the log, so the exception is
     * spurious and can be ignored.
     *
     * In 4.2, we do the more robust practice of not fetching pending deleted
     * or known deleted log entries, and this problem cannot occur.
     */
    private boolean failureNotAcceptable(EnvironmentFailureException e,
                                         boolean isPendingDeleted,
                                         boolean isKnownDeleted) {

        /* An exception is permissible only if either KD or PD is set.*/
        if (!(isPendingDeleted || isKnownDeleted)) {
            return true;
        }

        /* 
         * In this one case, KD or PD is set, and we can ignore a LOG_INTEGRITY
         */
        if (e.getReason().equals(EnvironmentFailureReason.LOG_INTEGRITY)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isCompressible() {
        return true;
    }

    /**
     * Reduce memory consumption by evicting all LN targets. Note that this may
     * cause LNs to be logged, which would require marking this BIN dirty.
     *
     * The BIN should be latched by the caller.
     *
     * @return number of evicted bytes. Note that a 0 return does not
     * necessarily mean that the BIN had no evictable LNs. It's possible that
     * resident, dirty LNs were not lockable.
     */
    public long evictLNs()
        throws DatabaseException {

        assert isLatchOwnerForWrite() :
            "BIN must be latched before evicting LNs";

        Cleaner cleaner = getDatabase().getDbEnvironment().getCleaner();

        /*
         * We can't evict an LN which is pointed to by a cursor, in case that
         * cursor has a reference to the LN object. We'll take the cheap choice
         * and avoid evicting any LNs if there are cursors on this BIN. We
         * could do a more expensive, precise check to see entries have which
         * cursors. (We'd have to be careful to use the right field, index vs
         * dupIndex). This is something we might move to later.
         */
        long removed = 0;
        if (nCursors() == 0) {
            for (int i = 0; i < getNEntries(); i++) {
                removed += evictInternal(i, cleaner);
            }
            updateMemorySize(removed, 0);

            /*
             * Compact representations if possible to futher decrease the
             * memory footprint.
             */
            compactMemory();
        }
        return removed;
    }

    /**
     * Evict a single LN if allowed and adjust the memory budget.
     */
    public void evictLN(int index)
        throws DatabaseException {

        Cleaner cleaner = getDatabase().getDbEnvironment().getCleaner();
        long removed = evictInternal(index, cleaner);
        updateMemorySize(removed, 0);
    }

    /**
     * Evict a single LN if allowed.  The amount of memory freed is returned
     * and must be subtracted from the memory budget by the caller.
     *
     * @return number of evicted bytes. Note that a 0 return does not
     * necessarily mean there was no eviction because the targetLN was not
     * resident. It's possible that resident, dirty LNs were not lockable.
     */
    private long evictInternal(int index, Cleaner cleaner)
        throws DatabaseException {

        Node n = getTarget(index);

        if (n instanceof LN) {
            LN ln = (LN) n;

            /*
             * Don't evict MapLNs for open databases (LN.isEvictable) [#13415].
             * And don't strip LNs that the cleaner will be migrating
             * (Cleaner.isEvictable).
             */
            if (ln.isEvictable() &&
                cleaner.isEvictable(this, index)) {

                boolean force = getDatabase().isDeferredWriteMode() &&
                    getLsn(index) == DbLsn.NULL_LSN;
                /* Log target if necessary. */
                logDirtyLN(index, (LN) n, force);

                /* Clear target. */
                setTarget(index, null);
                ln.releaseMemoryBudget();

                return n.getMemorySizeIncludedByParent();
            }
        }
        return 0;
    }

    /**
     * Logs the LN at the given index if it is dirty.
     */
    private void logDirtyLN(int index, LN ln, boolean force)
        throws DatabaseException {

        if (ln.isDirty() || force) {
            DatabaseImpl dbImpl = getDatabase();

            /* Only deferred write databases should have dirty LNs. */
            assert dbImpl.isDeferredWriteMode();

            /* Log the LN with the main tree key. */
            byte[] key = containsDuplicates() ? getDupKey() : getKey(index);

            /*
             * No need to lock, this is non-txnal. This should never be part
             * of the replication stream, because this is a deferred-write DB.
             */
            long lsn = ln.log(dbImpl.getDbEnvironment(),
                              dbImpl,
                              key,
                              getLsn(index), // obsoleteLsn
                              null,          // locker
                              true,          // backgroundIO
                              ReplicationContext.NO_REPLICATE);
            updateEntry(index, lsn);
        }
    }

    /* For debugging.  Overrides method in IN. */
    @Override
    boolean validateSubtreeBeforeDelete(int index) {
        return true;
    }

    /**
     * Check if this node fits the qualifications for being part of a deletable
     * subtree. It can only have one IN child and no LN children.
     *
     * We assume that this is only called under an assert.
     */
    @Override
    boolean isValidForDelete()
        throws DatabaseException {

        /*
         * Can only have one valid child, and that child should be deletable.
         */
        int validIndex = 0;
        int numValidEntries = 0;
        boolean needToLatch = !isLatchOwnerForWrite();
        try {
            if (needToLatch) {
                latch();
            }
            for (int i = 0; i < getNEntries(); i++) {
                if (!isEntryKnownDeleted(i)) {
                    numValidEntries++;
                    validIndex = i;
                }
            }

            if (numValidEntries > 1) {      // more than 1 entry
                return false;
            } else {
                if (nCursors() > 0) {        // cursors on BIN, not eligable
                    return false;
                }
                if (numValidEntries == 1) {  // need to check child (DIN or LN)
                    Node child = fetchTarget(validIndex);
                    if (child == null) {
                        return false;
                    }
                    child.latchShared();
                    boolean ret = child.isValidForDelete();
                    child.releaseLatch();
                    return ret;
                } else {
                    return true;             // 0 entries.
                }
            }
        } finally {
            if (needToLatch &&
                isLatchOwnerForWrite()) {
                releaseLatch();
            }
        }
    }

    /*
     * DbStat support.
     */
    @Override
    void accumulateStats(TreeWalkerStatsAccumulator acc) {
        acc.processBIN(this, Long.valueOf(getNodeId()), getLevel());
    }

    /**
     * Return the relevant user defined comparison function for this type of
     * node.  For IN's and BIN's, this is the BTree Comparison function.
     * Overriden by DBIN.
     */
    @Override
    public Comparator<byte[]> getKeyComparator() {
        return getDatabase().getBtreeComparator();
    }

    @Override
    public String beginTag() {
        return BEGIN_TAG;
    }

    @Override
    public String endTag() {
        return END_TAG;
    }

    /*
     * Logging support
     */

    /**
     * @see IN.logDirtyChildren();
     */
    @Override
    public void logDirtyChildren()
        throws DatabaseException {

        /* Look for targets that are dirty. */
        EnvironmentImpl envImpl = getDatabase().getDbEnvironment();
        for (int i = 0; i < getNEntries(); i++) {
            Node node = getTarget(i);
            if (node != null) {

                if (node instanceof LN) {
                    logDirtyLN(i, (LN) node, false);
                } else {
                    DIN din = (DIN) node;
                    din.latch(CacheMode.UNCHANGED);
                    try {
                        if (din.getDirty()) {
                            din.logDirtyChildren();
                            /* Logging the DIN will log the DupCountLN. */
                            long childLsn =
                                din.log(envImpl.getLogManager(),
                                        false, // allow deltas
                                        true,  // is provisional
                                        true,  // backgroundIO
                                        this); // provisional parent
                            updateEntry(i, childLsn);
                        }
                    } finally {
                        din.releaseLatch();
                    }
                }
            }
        }
    }

    /**
     * @see IN#incEvictStats
     */
    @Override
    public void incEvictStats(EvictionSource source) {
        databaseImpl.getDbEnvironment().getEvictor().incBINEvictStats(source);
    }

    /**
     * @see Node#incFetchStats
     */
    @Override
    public void incFetchStats(EnvironmentImpl envImpl, boolean isMiss) {
        envImpl.getEvictor().incBINFetchStats(isMiss);
    }

    /**
     * @see Node#getLogType
     */
    @Override
    public LogEntryType getLogType() {
        return LogEntryType.LOG_BIN;
    }

    @Override
    public String shortClassName() {
        return "BIN";
    }

    @Override
    public void beforeLog(LogManager logManager,
                          INLogItem item,
                          INLogContext context)
        throws DatabaseException {

        EnvironmentImpl envImpl = getDatabase().getDbEnvironment();

        /* Allow the cleaner to migrate LNs before logging. */
        envImpl.getCleaner().lazyMigrateLNs(this, context.backgroundIO);

        /* Check for dirty LNs in deferred-write databases. */
        if (getDatabase().isDeferredWriteMode()) {
            logDirtyLNs();
        }

        /*
         * We can log a delta rather than full version of this BIN if
         * - this has been called from the checkpointer with allowDeltas=true
         * - there is a full version on disk
         * - we meet the percentage heuristics defined by environment params.
         * - this delta is not prohibited because of cleaning or compression
         * - this is not a deferred write db
         * All other logging should be of the full version.
         */
        boolean doDeltaLog = false;
        BINDelta deltaInfo = null;
        if (context.allowDeltas &&
            getLastFullVersion() != DbLsn.NULL_LSN &&
            !prohibitNextDelta &&
            !getDatabase().isDeferredWriteMode()) {
            deltaInfo = new BINDelta(this);
            doDeltaLog = doDeltaLog(deltaInfo);
        }

        if (doDeltaLog) {
            item.provisional = Provisional.NO;
            item.oldLsn = DbLsn.NULL_LSN;
            item.entry = new SingleItemEntry(getBINDeltaType(), deltaInfo);
            item.isDelta = true;
        } else {
            /* Log a full version of the IN. */
            super.beforeLog(logManager, item, context);
        }
    }

    @Override
    public void afterLog(LogManager logManager,
                         INLogItem item,
                         INLogContext context)
        throws DatabaseException {

        if (item.isDelta) {

            /*
             * Don't change the dirtiness of the node -- leave it dirty. Deltas
             * are never provisional, they must be processed at recovery time.
             */
            lastDeltaVersion = item.newLsn;
            item.newLsn = DbLsn.NULL_LSN;
            numDeltasSinceLastFull++;
        } else {
            super.afterLog(logManager, item, context);
            lastDeltaVersion = DbLsn.NULL_LSN;
            numDeltasSinceLastFull = 0;
        }
        prohibitNextDelta = false;
    }

    private void logDirtyLNs()
        throws DatabaseException {

        boolean isDeferredWrite = getDatabase().isDeferredWriteMode();

        for (int i = 0; i < getNEntries(); i++) {
            Node node = getTarget(i);
            if ((node != null) && (node instanceof LN)) {
                logDirtyLN(i, (LN) node,
                           (getLsn(i) == DbLsn.NULL_LSN && isDeferredWrite));
            }
        }
    }

    /**
     * Decide whether to log a full or partial BIN, depending on the ratio of
     * the delta size to full BIN size, and the number of deltas that have been
     * logged since the last full.
     *
     * @return true if we should log the deltas of this BIN
     */
    private boolean doDeltaLog(BINDelta deltaInfo) {
        int maxDiffs = (getNEntries() *
                        getDatabase().getBinDeltaPercent())/100;
        if ((deltaInfo.getNumDeltas() <= maxDiffs) &&
            (numDeltasSinceLastFull < getDatabase().getBinMaxDeltas())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * We require exclusive latches on a BIN, so this method does not need to
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
