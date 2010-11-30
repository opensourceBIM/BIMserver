/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.vlsn;

import static com.sleepycat.je.utilint.VLSN.NULL_VLSN;

import com.sleepycat.bind.tuple.LongBinding;
import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.VLSN;

public class VLSNRange {

    /* On-disk version. */
    private static final int VERSION = 1;
    public static final long RANGE_KEY = -1L;
    static final VLSNRange EMPTY = new VLSNRange(NULL_VLSN, NULL_VLSN,
                                                 NULL_VLSN, NULL_VLSN);

    /*
     * Information about the range of contiguous VLSN entries on this node.
     * All the range values must be viewed together, to ensure a consistent set
     * of values.
     */
    private final VLSN first;
    private final VLSN last;
    private final byte commitType = LogEntryType.LOG_TXN_COMMIT.getTypeNum();
    private final byte abortType = LogEntryType.LOG_TXN_ABORT.getTypeNum();

    /*
     * VLSN of the last log entry in our VLSN range that can serve as a sync
     * matchpoint.
     */
    private final VLSN lastSync;
    private final VLSN lastTxnEnd;

    private VLSNRange(VLSN first,
                      VLSN last,
                      VLSN lastSync,
                      VLSN lastTxnEnd) {
        this.first = first;
        this.last = last;
        this.lastSync = lastSync;
        this.lastTxnEnd = lastTxnEnd;
    }

    /**
     * When the range is written out by the VLSNTracker, we must always be sure
     * to update the tracker's lastVSLNOnDisk field. Return the last VLSN in 
     * the range as part of this method, to help ensure that update.
     * @param envImpl
     * @param dbImpl
     * @param txn
     */
    VLSN writeToDatabase(final EnvironmentImpl envImpl,
                         final DatabaseImpl dbImpl,
                         Txn txn) {

        VLSNRangeBinding binding = new VLSNRangeBinding();
        DatabaseEntry key = new DatabaseEntry();
        DatabaseEntry data = new DatabaseEntry();

        LongBinding.longToEntry(RANGE_KEY, key);
        binding.objectToEntry(this, data);

        Cursor c = null;
        try {
            c = DbInternal.makeCursor(dbImpl, 
                                      txn,
                                      CursorConfig.DEFAULT);
            DbInternal.getCursorImpl(c).setAllowEviction(false);

            OperationStatus status = c.put(key, data);
            if (status != OperationStatus.SUCCESS) {
                throw EnvironmentFailureException.unexpectedState
                    (envImpl, "Unable to write VLSNRange, status = " + status);
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return last;
    }

    public static VLSNRange readFromDatabase(DatabaseEntry data) {
        VLSNRangeBinding binding = new VLSNRangeBinding();
        VLSNRange range = binding.entryToObject(data);

        return range;
    }

    public VLSN getFirst() {
        return first;
    }

    public VLSN getLast() {
        return last;
    }

    public VLSN getLastSync() {
        return lastSync;
    }

    public VLSN getLastTxnEnd() {
        return lastTxnEnd;
    }

    /**
     * Return the VLSN that should come after the lastVLSN.
     */
    VLSN getUpcomingVLSN() {
        return last.getNext();
    }

    /**
     * @return true if this VLSN is within the range described by this class.
     */
    public boolean contains(final VLSN vlsn) {
        if (first.equals(NULL_VLSN)) {
            return false;
        }

        if ((first.compareTo(vlsn) <= 0) && (last.compareTo(vlsn) >= 0)) {
            return true;
        }

        return false;
    }

    /**
     * A new VLSN->LSN mapping has been registered in a bucket. Update the
     * range accordingly.
     */
    VLSNRange getUpdateForNewMapping(final VLSN newValue,
                                     final byte entryTypeNum) {
        VLSN newFirst = first;
        VLSN newLast = last;
        VLSN newLastSync = lastSync;
        VLSN newLastTxnEnd = lastTxnEnd;

        if (first.equals(NULL_VLSN) || first.compareTo(newValue) > 0) {
            newFirst = newValue;
        }

        if (last.compareTo(newValue) < 0) {
            newLast = newValue;
        }

        if (LogEntryType.isSyncPoint(entryTypeNum)) {
            if (lastSync.compareTo(newValue) < 0) {
                newLastSync = newValue;
            }
        }

        if ((entryTypeNum == commitType) || (entryTypeNum == abortType)) {
            if (lastTxnEnd.compareTo(newValue) < 0) {
                newLastTxnEnd = newValue;
            }
        }

        return new VLSNRange(newFirst, newLast, newLastSync, newLastTxnEnd);
    }

    /**
     * Incorporate the information in "other" in this range.
     */
    VLSNRange getUpdate(final VLSNRange other) {
        VLSN newFirst = getComparison(first, other.first,
                                      other.first.compareTo(first) < 0);
        VLSN newLast = getComparison(last, other.last,
                                     other.last.compareTo(last) > 0);
        VLSN newLastSync =
            getComparison(lastSync, other.lastSync,
                          other.lastSync.compareTo(lastSync) > 0);
        VLSN newLastTxnEnd =
            getComparison(lastTxnEnd, other.lastTxnEnd,
                          other.lastTxnEnd.compareTo(lastTxnEnd) > 0);
        return new VLSNRange(newFirst, newLast, newLastSync, newLastTxnEnd);
    }

    /**
     * The "other" range is going to be appended to this range.
     */
    VLSNRange merge(final VLSNRange other) {
        VLSN newLast = getComparison(last, other.last, true);
        VLSN newLastSync = getComparison(lastSync, other.lastSync, true);
        VLSN newLastTxnEnd = getComparison(lastTxnEnd, other.lastTxnEnd, true);
        return new VLSNRange(first, newLast, newLastSync, newLastTxnEnd);
    }

    /*
     * We can assume that deleteStart.getPrev() is either NULL_VLSN or is
     * on a sync-able boundary. We can also assume that lastTxnEnd has not
     * been changed. And lastly, we can assume that this range is not empty,
     * since that was checked earlier on.
     */
    VLSNRange shortenFromEnd(final VLSN deleteStart) {
        VLSN newLast = deleteStart.getPrev();

        assert newLast.compareTo(lastTxnEnd) >= 0 :
        "Can't truncate at " + newLast +
            " because it overwrites a commit at " +  lastTxnEnd;

        if (newLast.equals(NULL_VLSN)) {
            return new VLSNRange(NULL_VLSN, NULL_VLSN, NULL_VLSN, NULL_VLSN);
        }
        return new VLSNRange(first, newLast, newLast, lastTxnEnd);
    }

    /*
     * @return an new VLSNRange which starts at deleteEnd.getNext()
     */
    VLSNRange shortenFromHead(final VLSN deleteEnd) {
        /* We shouldn't be truncating the last sync */

        VLSN newFirst = null;
        VLSN newLast = last;
        if (deleteEnd.compareTo(last) == 0) {
            newFirst = NULL_VLSN;
            newLast = NULL_VLSN;
        } else {
            newFirst = deleteEnd.getNext();
        }

        assert (lastSync.equals(NULL_VLSN) ||
                lastSync.compareTo(newFirst) >= 0 ) :
            "Can't truncate lastSync= " + lastSync + " deleteEnd=" + deleteEnd;

        VLSN newTxnEnd = lastTxnEnd.compareTo(newFirst) > 0 ?
            lastTxnEnd : NULL_VLSN;

        return new VLSNRange(newFirst, newLast, lastSync, newTxnEnd);
    }

    /**
     * Compare two VLSNs, normalizing for NULL_VLSN. If one of them is
     * NULL_VLSN, return the other one. If neither are NULL_VLSN, use the
     * result of the comparison, expressed as the value of "better" to decide
     * which one to return. If "better" is true, return "otherVLSN".
     */
    private VLSN getComparison(final VLSN thisVLSN,
                               final VLSN otherVLSN,
                               final boolean better) {
        if (thisVLSN.equals(NULL_VLSN)) {
            return otherVLSN;
        }

        if (otherVLSN.equals(NULL_VLSN)) {
            return thisVLSN;
        }

        if (better) {
            return otherVLSN;
        }

        return thisVLSN;
    }

    boolean isEmpty() {
        return first.equals(NULL_VLSN);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("first=").append(first);
        sb.append(" last=").append(last);
        sb.append(" sync=").append(lastSync);
        sb.append(" txnEnd=").append(lastTxnEnd);
        return sb.toString();
    }

    /**
     * Marshals a VLSNRange to a byte buffer to store in the database.
     */
    static class VLSNRangeBinding extends TupleBinding<VLSNRange> {

        @Override
        public VLSNRange entryToObject(final TupleInput ti) {
            int onDiskVersion = ti.readPackedInt();
            if (onDiskVersion != VERSION) {
                throw EnvironmentFailureException.unexpectedState
                    ("Don't expect version diff " +
                     "on_disk=" + onDiskVersion +
                     " source=" +
                     VERSION);
            }

            VLSNRange range =
                new VLSNRange(new VLSN(ti.readPackedLong()), // first
                              new VLSN(ti.readPackedLong()), // last
                              new VLSN(ti.readPackedLong()), // lastSync
                              new VLSN(ti.readPackedLong())); // lastTxnEnd
            return range;
        }

        @Override
        public void objectToEntry(final VLSNRange range,
                                  final TupleOutput to) {
            /* No need to store the file number -- that's the key */
            to.writePackedInt(VERSION);
            to.writePackedLong(range.getFirst().getSequence());
            to.writePackedLong(range.getLast().getSequence());
            to.writePackedLong(range.getLastSync().getSequence());
            to.writePackedLong(range.getLastTxnEnd().getSequence());
        }
    }

    boolean verify(final boolean verbose) {
        if (first.equals(NULL_VLSN)) {
            if (!(last.equals(NULL_VLSN) &&
                  (lastSync.equals(NULL_VLSN)) &&
                  (lastTxnEnd.equals(NULL_VLSN)))) {
                if (verbose) {
                    System.out.println("Range: All need to be NULL_VLSN " +
                                       this);
                }
                return false;
            }
        } else {
            if (first.compareTo(last) > 0) {
                if (verbose) {
                    System.out.println("Range: first > last " + this);
                }
                return false;
            }

            if (!lastSync.equals(NULL_VLSN)) {
                if (lastSync.compareTo(last) > 0) {
                    if (verbose) {
                        System.out.println("Range: lastSync > last " + this);
                    }
                    return false;
                }
            }

            if (!lastTxnEnd.equals(NULL_VLSN)) {
                if (lastTxnEnd.compareTo(last) > 0) {
                    if (verbose) {
                        System.out.println("Range: lastTxnEnd > last " + this);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return true if subsetRange is a subset of this range.
     */
    boolean verifySubset(final boolean verbose, final VLSNRange subsetRange) {
        if (subsetRange == null) {
            return true;
        }

        if ((subsetRange.getFirst().equals(NULL_VLSN)) &&
            (subsetRange.getLast().equals(NULL_VLSN)) &&
            (subsetRange.getLastSync().equals(NULL_VLSN)) &&
            (subsetRange.getLastTxnEnd().equals(NULL_VLSN))) {
            return true;
        }
    
        if (first.compareTo(subsetRange.getFirst()) >  0) {
            if (verbose) {
                System.out.println("Range: subset must be LTE: this=" + this +
                                   " subset=" + subsetRange);
            }
            return false;
        }

        if (first.equals(NULL_VLSN)) {
            return true;
        }

        if (last.compareTo(subsetRange.getLast()) < 0) {
            if (verbose) {
                System.out.println("Range: last must be GTE: this=" + this +
                                   " subsetRange=" + subsetRange);
            }
            return false;
        }
        return true;
    }
}
