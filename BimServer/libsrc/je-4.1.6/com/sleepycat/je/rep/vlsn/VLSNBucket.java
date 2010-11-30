/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.vlsn;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

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
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.FileReader;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.VLSN;

/**
 * A VLSNBucket instance represents a set of VLSN->LSN mappings. Buckets are
 * usually not updated, except at times when the replication stream may have
 * been reduced in size, by log cleaning or syncup. The VLSNBuckets in the
 * VLSNIndex's VLSNTracker are written to disk and are persistent. There are
 * also VLSNBuckets in the temporary recovery-time tracker that are used for
 * collecting mappings found in the log during recovery.
 *
 * VLSNBuckets only hold mappings from a single log file. A single log file
 * may be mapped by multiple VLSNBuckets though.
 *
 * As a tradeoff in space vs time, a VLSNBucket only stores a sparse set of
 * mappings and the caller must use a VLSNReader to scan the log file and
 * find any log entries not mapped directly by the bucket. In addition,
 * the VLSN is not actually stored. Only the offset portion of the LSN is
 * stored, and the VLSN is intuited by a stride field. Each VLSNBucket
 * only maps a single file, though a single file may be mapped by several
 * VLSNBuckets.
 *
 * For example, suppose a node had these VLSN->LSN mappings:
 *
 * VLSN            LSN (file/offset)
 * 9               10/100
 * 10              10/110
 * 11              10/120
 * 12              10/130
 * 13              10/140
 * 14              11/100
 * 15              11/120
 *
 * The mappings in file 10 could be represented by a VLSNBucket with
 * a stride of 4. That means the bucket would hold the mappings for
 *  9              10/100,
 * 13              10/140
 *
 * And since the target log file number and the stride is known, the mappings
 * can be represented in by the offset alone in this array: {100, 140}, rather
 * than storing the whole lsn.
 *
 * Each bucket can also provide the mapping for the first and last VLSN it
 * covers, even if the lastVLSN is not divisible by the stride. This is done to
 * support forward and backward scanning. From the example above, the completed
 * bucket can provide 9->10/100, 13->10/140, 15 -> 10/160 even though 15 is not
 * a stride's worth away from 13.
 *
 * Because registering a VLSN->LSN mapping is done outside the log write latch,
 * any inserts into the VLSNBucket may not be in order. However, when any
 * VLSN is registered, we can assume that all VLSNs < that value do exist in
 * the log. It's just an accident of timing that they haven't yet been
 * registered. Note that out of order inserts into the buckets can create holes
 * in the bucket's offset array, or cause the array to be shorter than
 * anticipated.
 *
 * For example, if the insertion order into the bucket is vlsns 9, 15, we'll
 * actually only keep an offset array of size 1. We have to be able to handle
 * holes in the bucket, and can't count on filling them in when the lagging
 * vlsn arrives, because it is possible that a reading thread will access the
 * bucket before the laggard inserter arrives, or that the bucket might be
 * flushed to disk, and become immutable.
 */
public class VLSNBucket {

    /* On-disk version. */
    private static final int VERSION = 1;

    /* File number for target file. */
    private final long fileNumber;

    /* Interval between VLSN values that are mapped. */
    private final int stride;

    protected VLSN firstVLSN = VLSN.NULL_VLSN;
    protected VLSN lastVLSN = VLSN.NULL_VLSN;
    private long lastLsn = DbLsn.NULL_LSN;

    /*
     * The file offsets are really unsigned ints. The calls to put() are
     * implemented to let us assume that the list is fully populated.  A
     * subclass of truncateableList has been used in order to provide access to
     * the ArrayList.removeFromRange method.
     */
    private TruncateableList<Integer> fileOffsets;

    /*
     * The max number of offsets and maxDistance help guide when to close the
     * bucket and start a new one. Not persistent.
     */
    private int maxMappings;
    private int maxDistance;

    private static final int NO_OFFSET = 0;

    /* True if there are changes to the bucket that are not on disk. */
    boolean dirty;

    /*
     * True if the VLSNBucket will not accept any more modifications; used to
     * safeguard the bucket while the index is being written to disk.
     */
    private boolean closed = false;

    VLSNBucket(long fileNumber,
               int stride,
               int maxMappings,
               int maxDistance,
               VLSN firstVLSN) {
        this.fileNumber = fileNumber;
        this.stride = stride;
        this.maxMappings = maxMappings;
        this.maxDistance = maxDistance;

        /*
         * The VLSNs in the bucket are initialized to indicate what range
         * should be covered by this bucket. But there may not be any offsets
         * recorded either in the lastLsn or the fileOffset.
         */
        this.firstVLSN = firstVLSN;
        this.lastVLSN = firstVLSN;

        /*
         * Initialize the file offsets with a -1 value to correspond to
         * firstVLSN.
         */
        fileOffsets = new TruncateableList<Integer>();
        fileOffsets.add(0, NO_OFFSET);
    }

    /* For reading from disk. */
    private VLSNBucket(TupleInput ti) {
        fileNumber = ti.readPackedLong();
        stride = ti.readPackedInt();
        firstVLSN = new VLSN(ti.readPackedLong());
        lastVLSN = new VLSN(ti.readPackedLong());
        lastLsn = ti.readPackedLong();
        int size = ti.readPackedInt();
        fileOffsets = new TruncateableList<Integer>(size);
        for (int i = 0; i < size; i++) {
            fileOffsets.add(i, DbLsn.getFileOffsetAsInt(ti.readUnsignedInt()));
        }
    }

    /**
     * Record the LSN location for this VLSN.
     *
     * One key issue is that puts() are not synchronized, and the VLSNs may
     * arrive out of order. If an out of order VLSN does arrive, we can still
     * assume that the earlier VLSNs have been successfully logged. If a VLSN
     * arrives that is divisible by the stride, and should be recorded in the
     * fileOffsets, but is not the next VLSN that should be recorded, we'll pad
     * out the fileOffsets list with placeholders.
     *
     * For example, suppose the stride is 3, and the first VLSN is 2. Then this
     * bucket should record VLSN 2, 5, 8, ... etc.  If VLSN 8 arrives before
     * VLSN 5, VLSN 8 will be recorded, and VLSN 5 will have an offset
     * placeholder of NO_OFFSET. It is a non-issue if VLSNs 3, 4, 6, 7 arrive
     * out of order, because they would not have been recorded anyway. This
     * should not happen often, because the stride should be fairly large, and
     * the calls to put() should be close together. If the insertion order is
     * vlsn 2, 5, 9, then the file offsets array will be a little short, and
     * will only have 2 elements, instead of 3.
     *
     * We follow this policy because we must always have a valid begin and end
     * point for the range. We must handle placeholders in all cases, and can't
     * count of later vlsn inserts, because a bucket can become immutable at
     * any time if it is flushed to disk.
     *
     * @return false if this bucket will not accept this VLSN. Generally, a
     * refusal might happen because the bucket was full or the mapping is too
     * large a distance away from the previous mapping. In that case, the
     * tracker will start another bucket.
     */
    synchronized boolean put(VLSN vlsn, long lsn) {

        if (closed) {
            return false;
        }

        if (!belongs(vlsn, lsn)) {
            return false;
        }

        /*
         * Add it to the fileOffset if it's on a stride boundary and is the
         * next mapping in the fileOffset list.
         */
        if (isModulo(vlsn)) {
            int index = getIndex(vlsn);
            int listLen = fileOffsets.size();
            if (index < listLen) {
                fileOffsets.set(index, DbLsn.getFileOffsetAsInt(lsn));
            } else if (index == listLen) {
                fileOffsets.add(DbLsn.getFileOffsetAsInt(lsn));
            } else {
                for (int i = listLen; i < index; i++) {
                    fileOffsets.add(NO_OFFSET);
                }
                fileOffsets.add(DbLsn.getFileOffsetAsInt(lsn));
            }
            dirty = true;
        }

        /* If the lastLsn is less, or not initialized, set it to this VLSN. */
        if ((lastVLSN.compareTo(vlsn) < 0) ||
            (lastLsn == DbLsn.NULL_LSN)) {
            lastVLSN = vlsn;
            lastLsn = lsn;
            dirty = true;
        }

        return true;
    }

    /*
     * Return true if this VLSN is on a stride boundary.  Assumes
     * !firstVLSN.isNull()
     */
    private boolean isModulo(VLSN vlsn) {
        return (((vlsn.getSequence() - firstVLSN.getSequence()) % stride) ==
                0);
    }

    private int getIndex(VLSN vlsn) {
        assert isModulo(vlsn) : "Don't call getIndex on non-modulo VLSN " +
            vlsn + " bucket=" + this;

        return (int) ((vlsn.getSequence() - firstVLSN.getSequence()) / stride);
    }

    /**
     * @return true if this VLSN->LSN mapping should go into this bucket.
     */
    private boolean belongs(VLSN vlsn, long lsn) {
        assert vlsn.compareTo(firstVLSN) >= 0 :
            "firstVLSN = " + firstVLSN + " should not be greater than " + vlsn;

        if (DbLsn.getFileNumber(lsn) != fileNumber) {
            /* Mappings must be for same file. */
            return false;
        }

        if (emptyInternal()) {
            return true;
        }

        /*
         * Some other thread beat us to the put() call and inserted a later
         * mapping, so we know for sure that we fit in this bucket
         */
        if (lastVLSN.compareTo(vlsn) > 0) {
            return true;
        }

        boolean onStrideBoundary = isModulo(vlsn);
        if (onStrideBoundary && (fileOffsets.size() >= maxMappings)) {
            /* Too full. */
            return false;
        }

        /*
         * Will this VLSN be next one recorded in the fileOffsets? If so,
         * calculate the scan distance.
         */
        if ((onStrideBoundary && (getIndex(vlsn) == fileOffsets.size())) ||
            lastVLSN.compareTo(vlsn) < 0) {
            /* This VLSN is going in at the tail of the bucket. */
            int lastOffset = fileOffsets.get(fileOffsets.size() - 1);
            if ((DbLsn.getFileOffset(lsn) -
                 DbLsn.convertIntFileOffsetToLong(lastOffset)) >
                maxDistance) {
                /* The scan distance is exceeded. */
                return false;
            }
        }

        return true;
    }

    /**
     * @return true if this bucket contains this mapping.
     */
    synchronized boolean owns(VLSN vlsn) {
        if (vlsn.equals(VLSN.NULL_VLSN)) {
            return false;
        } else if (firstVLSN.equals(VLSN.NULL_VLSN)) {
            return false;
        } else {
            return (firstVLSN.compareTo(vlsn) <= 0) &&
                (lastVLSN.compareTo(vlsn) >= 0);
        }
    }

    synchronized VLSN getFirst() {
        return firstVLSN;
    }

    synchronized VLSN getLast() {
        return lastVLSN;
    }

    /**
     * Return a file number that is less or equal to the first lsn mapped
     * by this bucket. In standard VLSNBuckets, only one file is covered, so
     * there is only one possible value. In GhostBuckets, multiple files could
     * be covered.
     * @return
     */
    long getLTEFileNumber() {
        return fileNumber;
    }

    synchronized boolean empty() {
        return emptyInternal();
    }

    private boolean emptyInternal() {
        return (firstVLSN.equals(lastVLSN) &&
                (lastLsn == DbLsn.NULL_LSN));
    }

    boolean follows(VLSN vlsn) {
        return (firstVLSN.compareTo(vlsn) > 0);
    }

    boolean precedes(VLSN vlsn) {
        return (!lastVLSN.equals(VLSN.NULL_VLSN) &&
                (lastVLSN.compareTo(vlsn) < 0));
    }

    /**
     * Returns the mapping whose VLSN is >= the VLSN parameter. For example, if
     * the bucket holds mappings for vlsn 10, 13, 16,
     *
     *  - the greater than or equal mapping for VLSN 10 is 10/lsn
     *  - the greater than or equal mapping for VLSN 11 is 13/lsn
     *  - the greater than or equal mapping for VLSN 13 is 13/lsn
     *
     * File offsets may be null in the middle of the file offsets array because
     * of out of order mappings. This method must return a non-null lsn, and
     * must account for null offsets.
     *
     * @return the mapping whose VLSN is >= the VLSN parameter. Will never
     * return NULL_LSN, because the VLSNRange begin and end point are always
     * mapped.
     */
    synchronized long getGTELsn(VLSN vlsn) {

        if (lastVLSN.equals(vlsn)) {
            return lastLsn;
        }

        int index;
        if (firstVLSN.compareTo(vlsn) >= 0) {
            
            /* 
             * It's possible for vlsn to be < the firstVLSN if vlsn
             * falls between two buckets. For example, if the buckets are:
             *    bucketA = vlsn 10-> 20
             *    bucketB = vlsn 22->30
             * then vlsn 21 will fall between two buckets, and will get bucketB
             */
            index = 0;
        } else {
            index = getGTEIndex(vlsn);
        }

        /* 
         * This should never happen. Throw this exception to make debugging
         * info available.
         */
        if (index < 0) {
            throw EnvironmentFailureException.unexpectedState
                ("index=" + index +
                 " vlsn=" + vlsn +
                 " bucket=" + this);
        }

        if (index >= fileOffsets.size()) {
            return lastLsn;
        }
        int useIndex = findPopulatedIndex(index, true /* forward */);
        int offset = fileOffsets.get(useIndex);
        return offset == NO_OFFSET ?
            lastLsn : DbLsn.makeLsn(fileNumber, offset);
    }

    /**
     * Return the index for the mapping >= this VLSN.
     */
    private int getGTEIndex(VLSN vlsn) {
        long diff = vlsn.getSequence() - firstVLSN.getSequence();
        return (int) ((diff + (stride - 1)) / stride);
    }

    /**
     * We'd like to return the mapping at startIndex for the get{LTE, GTE}
     * Mapping methods, but the offsets may not be populated if put() calls
     * have come out of order. Search for the next populated offset.
     */
    private int findPopulatedIndex(int startIndex, boolean forward) {
        if (forward) {
            for (int i = startIndex; i < fileOffsets.size(); i++) {
                if (fileOffsets.get(i) != NO_OFFSET) {
                    return i;
                }
            }
        } else {
            for (int i = startIndex; i >= 0; i--) {
                if (fileOffsets.get(i) != NO_OFFSET) {
                    return i;
                }
            }
        }
        return startIndex;
    }

    /**
     * Returns the lsn whose VLSN is <= the VLSN parameter. For example, if
     * the bucket holds mappings for vlsn 10, 13, 16,
     *
     *  - the less than or equal mapping for VLSN 10 is 10/lsn
     *  - the less than or equal mapping for VLSN 11 is 10/lsn
     *  - the less than or equal mapping for VLSN 13 is 13/lsn
     *
     * File offsets may be null in the middle of the file offsets array because
     * of out of order mappings. This method must return a non-null lsn, and
     * must account for null offsets.
     *
     * @return the lsn whose VLSN is <= the VLSN parameter. Will never return
     * NULL_LSN, because the VLSNRange begin and end points are always mapped.
     */
    synchronized long getLTELsn(VLSN vlsn) {

        /*
         * It's possible for vlsn to be greater than lastVLSN if vlsn falls
         * between two buckets.
         * For example, if the buckets are:
         *    bucketA = vlsn 10-> 20
         *    bucketB = vlsn 22->30
         * then vlsn 21 will fall between two buckets, and will get bucketA
         */
        if (lastVLSN.compareTo(vlsn) <= 0) {
            return lastLsn;
        }

        long diff = vlsn.getSequence() - firstVLSN.getSequence();

        /*
         * Make sure that the file offset array isn't unexpectedly short due to
         * out of order inserts.
         */
        int index = (int)(diff / stride);
        if (index >= fileOffsets.size()) {
            index = fileOffsets.size() - 1;
        }

        int useIndex = findPopulatedIndex(index, false /* forward */);
        int offset = fileOffsets.get(useIndex);

        assert offset != NO_OFFSET : "bucket should always have a non-null " +
            "first offset. vlsn= " + vlsn + " bucket=" + this;

        return (DbLsn.makeLsn(fileNumber, offset));
    }

    /**
     * @return the lsn whose VLSN is == the VLSN parameter or DbLsn.NULL_LSN if
     * there is no mapping. Note that because of out of order puts, there may
     * be missing mappings that appear later on.
     */
    public synchronized long getLsn(VLSN vlsn) {
        assert owns(vlsn) : "vlsn=" + vlsn + " " + this;

        if (lastVLSN.equals(vlsn)) {
            return lastLsn;
        }

        if (!isModulo(vlsn)) {
            return DbLsn.NULL_LSN;
        }

        int index = getIndex(vlsn);
        if (index >= fileOffsets.size()) {
            return DbLsn.NULL_LSN;
        }

        int offset = fileOffsets.get(index);
        if (offset == NO_OFFSET) {
            return DbLsn.NULL_LSN;
        }

        return DbLsn.makeLsn(fileNumber, offset);
    }

    synchronized long getLastLsn() {
        return lastLsn;
    }

    /**
     * Remove the mappings from this bucket that are for VLSNs <=
     * lastDuplicate.  If this results in a broken stride interval, package all
     * those mappings into their own bucket and return it as a remainder
     * bucket.
     *
     * For example, suppose this bucket has a stride of 5 and maps VLSN 10-23.
     * Then it has mappings for 10, 15, 20, 23.
     *
     * If we need to remove mappings <= 16, we'll end up without a bucket that
     * serves as a home base for vlsns 17,18,19. Those will be spun out into
     * their own bucket, and this bucket will be adjusted to start at VLSN 20.
     * This bucket should end up with
     *
     *  - firstVLSN = 20
     *  - fileOffset is an array of size 1, for the LSN for VLSN 20
     *  - lastVLSN = 23
     *  - lastLsn = the same as before
     *
     * The spun-off bucket should be:
     *  - firstVLSN = 17
     *  - fileOffset is an array of size 1, for the LSN for VLSN 17
     *  - lastVLSN = 19
     *  - lastLsn = lsn for 19
     *
     * @return the newly created bucket that holds mappings from a broken
     * stride interval, or null if there was no need to create such a bucket.
     * @throws IOException
     */
    VLSNBucket removeFromHead(EnvironmentImpl envImpl, VLSN lastDuplicate)
        throws IOException {

        if (empty()) {
            return null;
        }

        /*
         * No overlap, this bucket owns mappngs that follow the duplicate
         * range.
         */
        if (lastDuplicate.compareTo(firstVLSN) < 0) {
            return null;
        }

        /*
         * This whole bucket is to be deleted, all its mappings are <= the
         * lastDuplicate.
         */
        if (lastVLSN.compareTo(lastDuplicate) <= 0) {
            fileOffsets = null;
            firstVLSN = VLSN.NULL_VLSN;
            lastVLSN = VLSN.NULL_VLSN;
            lastLsn = DbLsn.NULL_LSN;
            return null;
        }

        VLSN indexVLSN = firstVLSN;
        int newFirstIndex = -1;

        /*
         * Find the mappings that still belong. Using the example above, we
         * should find that we can delete fileOffset[0] and fileOffset[1] and
         * preserve fileOffset[2]
         */
        for (int i = 0; i < fileOffsets.size(); i++) {
            if ((indexVLSN.compareTo(lastDuplicate) > 0) &&
                (fileOffsets.get(i) != NO_OFFSET)) {
                newFirstIndex = i;
                break;
            }
            indexVLSN = new VLSN(indexVLSN.getSequence() + stride);
        }

        VLSNBucket remainder = null;
        int lastOffset;
        if (newFirstIndex == -1) {

            /*
             * None of the VLSNs represented by the strided file offsets are
             * needed anymore. This bucket consists solely of the last
             * VLSN->LSN pair.
             */
            lastOffset = fileOffsets.get(fileOffsets.size() - 1);
            fileOffsets = new TruncateableList<Integer>();
            fileOffsets.add(DbLsn.getFileOffsetAsInt(lastLsn));
            firstVLSN = lastVLSN;
        } else {
            /* Move the still-valid mappings to a new list. */
            assert (newFirstIndex > 0);
            lastOffset = fileOffsets.get(newFirstIndex - 1);
            TruncateableList<Integer> newFileOffsets =
                new TruncateableList<Integer>
                (fileOffsets.subList(newFirstIndex, fileOffsets.size()));
            fileOffsets = newFileOffsets;
            firstVLSN =  new VLSN((newFirstIndex * stride) +
                                  firstVLSN.getSequence());
        }

        if (!firstVLSN.equals(lastDuplicate.getNext())) {

            /*
             * If lastDuplicate was not on the same stride boundary as our old
             * bucket, we may have a broken bucket of mappings to preserve.
             * Using our example numbers above, we still need to make sure
             * there's a bucket that matches VLSNs 17, 18 19.
             */
            long scanStart =  DbLsn.makeLsn(fileNumber, lastOffset);
            remainder = scanForNewBucket(envImpl,
                                         lastDuplicate.getNext(),
                                         firstVLSN.getPrev(),
                                         scanStart);
        }

        dirty = true;
        return remainder;
    }

    /**
     * Scan the log fle for VLSN->LSN mappings for creating a new bucket.
     *
     * @throws IOException
     */
    private VLSNBucket scanForNewBucket(EnvironmentImpl envImpl,
                                        VLSN first,
                                        VLSN last,
                                        long startLsn)
        throws IOException {

        VLSNBucket newBucket = new VLSNBucket(fileNumber, stride,
                                              maxMappings, maxDistance,
                                              first);
        int readBufferSize =
            envImpl.getConfigManager().getInt
            (EnvironmentParams.LOG_ITERATOR_MAX_SIZE);

        NewBucketReader scanner =
            new NewBucketReader(newBucket, envImpl, readBufferSize, first,
                                last, startLsn);

        while (!scanner.isDone() && (scanner.readNextEntry())) {
        }

        assert scanner.isDone();

        return newBucket;
    }

    /**
     * Remove the mappings from this bucket that are for VLSNs >=
     * startOfDelete.  Unlike removing from the head, we need not worry about
     * breaking a bucket stride interval.
     *
     * If prevLsn is NULL_VLSN, we don't have a good value to cap the bucket.
     * Instead, we'll have to delete the bucket back to whatever was the next
     * available lsn. For example, suppose the bucket has these mappings and
     * startOfDelete is 17:
     *   10 -> 101
     *   15 -> 201
     *   18 -> 250
     *
     * if we have a prevLsn, then we can create bucket
     *   10 -> 101
     *   15 -> 201
     *   16 -> prevLsn
     *
     * if we don't have a prevLsn, then we know that we have to cut the bucket
     * back to this and lose vlsn 16
     *   10 -> 101
     *   15 -> 201
     *
     * @param startOfDelete is the VLSN that begins the range to delete,
     *        inclusive
     * @param prevLsn is the lsn of startOfDelete.getPrev(). We'll be using it
     * to cap off the end of the bucket, by assigning it to the lastLsn field.
     */
    void removeFromTail(VLSN startOfDelete, long prevLsn) {

        if (empty()) {
            return;
        }

        if (lastVLSN.compareTo(startOfDelete) < 0) {
            return;
        }

        /* Delete all the mappings. */
        if (firstVLSN.compareTo(startOfDelete) >= 0) {
            lastVLSN = firstVLSN;
            lastLsn = DbLsn.NULL_LSN;
            fileOffsets.clear();
            return;
        }

        /* Delete some of the mappings. */
        int deleteIndex = getGTEIndex(startOfDelete);
        if (prevLsn == DbLsn.NULL_LSN) {
            assert deleteIndex != 0 : "startOfDelete=" + startOfDelete +
                " bucket=" + this;

            int lastPopulatedIndex = findPopulatedIndex(deleteIndex-1, false);
            if (lastPopulatedIndex != (deleteIndex -1)) {
                deleteIndex = lastPopulatedIndex + 1;
            }
        }

        fileOffsets.truncate(deleteIndex);

        if (prevLsn == DbLsn.NULL_LSN) {
            lastVLSN = new VLSN(((fileOffsets.size()-1) * stride) +
                                firstVLSN.getSequence());
            Integer lastOffset = fileOffsets.get(fileOffsets.size() - 1);
            assert lastOffset != null;
            lastLsn = DbLsn.makeLsn(fileNumber,  lastOffset);
        } else {
            lastVLSN = startOfDelete.getPrev();
            lastLsn = prevLsn;
        }
        dirty = true;
    }

    /* For unit tests */
    int getNumOffsets() {
        return fileOffsets.size();
    }

    void close() {
        closed = true;
    }

    /**
     * Write this bucket to the mapping database. 
     */
    void writeToDatabase(EnvironmentImpl envImpl,
                         DatabaseImpl bucketDbImpl,
                         Txn txn) {

        if (!dirty) {
            return;
        }

        Cursor c = null;
        try {
            c = DbInternal.makeCursor(bucketDbImpl,
                                      txn,
                                      CursorConfig.DEFAULT);
            writeToDatabase(envImpl, c);
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    /**
     * Write this bucket to the mapping database using a cursor.  Note that
     * this method must disable critical eviction. Critical eviction makes the
     * calling thread search for a target IN node to evict. That target IN node
     * may or may not be in the internal VLSN db.
     * 
     * For example, when a new, replicated LN is inserted or modified, a
     * new VLSN is allocated. To do so, the app thread that is executing the
     * operation 
     *  A1. Takes a BIN latch on a BIN in a replicated db
     *  A2. Takes the VLSNINdex mutex
     *
     * Anyone calling writeDatabase() has to take these steps:
     *  B1. Take the VLSNIndex mutex
     *  B2. Get a BIN latch for a BIN in the internal vlsn db.
     *
     * This difference in locking hierarchy could cause a deadlock except for
     * the fact that A1 and B2 are guaranteed to be in different databases.  If
     * writeDatabase() also did critical eviction, it would have a step where
     * it tried to get a BIN latch on a replicated db, and we'd have a
     * deadlock. [#18475]
     */
    void writeToDatabase(EnvironmentImpl envImpl, Cursor cursor) {

        if (!dirty) {
            return;
        }

        DatabaseEntry key = new DatabaseEntry();
        DatabaseEntry data = new DatabaseEntry();

        LongBinding.longToEntry(firstVLSN.getSequence(), key);
        VLSNBucketBinding bucketBinding = new VLSNBucketBinding();
        bucketBinding.objectToEntry(this, data);

        DbInternal.getCursorImpl(cursor).setAllowEviction(false);
        OperationStatus status = cursor.put(key, data);

        if (status != OperationStatus.SUCCESS) {
            throw EnvironmentFailureException.unexpectedState
                 (envImpl, "Unable to write VLSNBucket for file " +
                 fileNumber + " status=" + status);
        }
        dirty = false;
    }

    /**
     * Instantiate this from the database. Assumes that this bucket will not be
     * used for insertion in the future.
     */
    public static VLSNBucket readFromDatabase(DatabaseEntry data) {

        VLSNBucketBinding mapperBinding = new VLSNBucketBinding();
        VLSNBucket bucket = mapperBinding.entryToObject(data);
        return bucket;
    }

    void fillDataEntry(DatabaseEntry data) {
        VLSNBucketBinding binding = new VLSNBucketBinding();
        binding.objectToEntry(this, data);
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("<VLSNBucket fileNum=%d(0x%x) numOffsets=%d " +
                             "stride=%d firstVLSN=%s lastVLSN=%s lastLsn=%s/>",
                             fileNumber, fileNumber,
                             (fileOffsets == null) ? 0 : fileOffsets.size(),
                             stride, firstVLSN, lastVLSN,
                             DbLsn.getNoFormatString(lastLsn));
    }

    /**
     * For debugging and tracing.
     */
    public void dump(PrintStream out) {
        if (fileOffsets == null) {
            return;
        }

        long vlsnVal = firstVLSN.getSequence();
        int newlineCounter = 0;
        for (Integer offset : fileOffsets) {
            out.printf(" [%d 0x%x]", vlsnVal, 
                       DbLsn.convertIntFileOffsetToLong(offset));

            vlsnVal += stride;
            if (++newlineCounter > 6) {
                out.println("\n");
                newlineCounter = 0;
            }
        }

        out.printf("\n---------Last: VLSN=%s LSN=%s", lastVLSN,
                   DbLsn.getNoFormatString(lastLsn));
    }

    boolean isGhost() {
        return false;
    }

    void writeToTupleOutput(TupleOutput to) {

        to.writePackedLong(fileNumber);
        to.writePackedInt(stride);
        to.writePackedLong(firstVLSN.getSequence());
        to.writePackedLong(lastVLSN.getSequence());
        to.writePackedLong(lastLsn);
        to.writePackedInt(fileOffsets.size());
        for (Integer offset: fileOffsets) {
            to.writeUnsignedInt(DbLsn.convertIntFileOffsetToLong(offset));
        }
    }

    /**
     * Marshals a VLSNBucket to a byte buffer to store in the database.
     * Doesn't persist the file number, because that's the key of the database.
     * A number of the fields are transient and are also not stored.
     */
    private static class VLSNBucketBinding extends TupleBinding<VLSNBucket> {

        @Override
        public VLSNBucket entryToObject(TupleInput ti) {

            int onDiskVersion = ti.readPackedInt();
            if (onDiskVersion != VLSNBucket.VERSION) {
                throw EnvironmentFailureException.unexpectedState
                    ("Don't expect version diff on_disk=" + onDiskVersion +
                     " source=" + VLSNBucket.VERSION);
            }
            boolean isGhost = ti.readBoolean();
            VLSNBucket bucket = null;
            if (isGhost) {
                bucket = GhostBucket.makeNewInstance(ti);
            } else {
                bucket = new VLSNBucket(ti);
            }
            return bucket;
        }

        @Override
        public void objectToEntry(VLSNBucket bucket, TupleOutput to) {
            to.writePackedInt(VLSNBucket.VERSION);
            to.writeBoolean(bucket.isGhost());
            bucket.writeToTupleOutput(to);
        }
    }

    /**
     * Scan a specific section of log and generate a new VLSNBucket for
     * this section.
     */
    private static class NewBucketReader extends FileReader {
        private final VLSNBucket remainderBucket;
        private boolean done = false;
        private final VLSN first;
        private final VLSN last;

        public NewBucketReader(VLSNBucket remainderBucket,
                               EnvironmentImpl envImpl,
                               int readBufferSize,
                               VLSN first,
                               VLSN last,
                               long startLsn) {
            super(envImpl,
                  readBufferSize,
                  true,            // forward
                  startLsn,
                  null,            // singleFileNumber
                  DbLsn.NULL_LSN,  // endOfFileLsn
                  DbLsn.NULL_LSN); // finishLsn

            this.remainderBucket = remainderBucket;
            this.first = first;
            this.last = last;
        }

        /**
         * Return true if this entry is replicated and its VLSN >= the
         * firstVLSN and the entry is not invisible. These entries will
         * be used to bring the VLSNIndex up to speed.
         */
        @Override
        protected boolean isTargetEntry()  {
            return (!currentEntryHeader.isInvisible() &&
                     entryIsReplicated() &&
                    (currentEntryHeader.getVLSN().compareTo(first) >= 0));
        }

        @Override
        protected boolean processEntry(ByteBuffer entryBuffer) {
            if (currentEntryHeader.getVLSN().compareTo(last) > 0) {
                done = true;
            } else {
                remainderBucket.put(currentEntryHeader.getVLSN(),
                                    getLastLsn());
            }

            entryBuffer.position(entryBuffer.position() +
                                 currentEntryHeader.getItemSize());
            return true;
        }

        boolean isDone() {
            return done;
        }
    }

    @SuppressWarnings("serial")
    private static class TruncateableList<T> extends ArrayList<T> {

        TruncateableList() {
            super();
        }

        TruncateableList(int capacity) {
            super(capacity);
        }

        TruncateableList(List<T> list) {
            super(list);
        }

        void truncate(int fromIndex) {
            removeRange(fromIndex, size());
        }
    }
}
