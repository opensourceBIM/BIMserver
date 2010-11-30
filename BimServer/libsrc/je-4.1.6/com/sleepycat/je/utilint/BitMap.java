/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sleepycat.je.EnvironmentFailureException;

/**
 * Bitmap which supports indexing with long arguments. java.util.BitSet
 * provides all the functionality and performance we need, but requires integer
 * indexing.
 *
 * Long indexing is implemented by keeping a Map of java.util.BitSets, where
 * each bitset covers 2^16 bits worth of values. The Bitmap may be sparse, in
 * that each segment is only instantiated when needed.
 *
 * Note that this class is currently not thread safe; adding a new bitset
 * segment is not protected.
 */
public class BitMap {

    private static final int SEGMENT_SIZE = 16;
    private static final int SEGMENT_MASK = 0xffff;

    /*
     * Map of segment value -> bitset, where the segment value is index >>16
     */
    private Map<Long, BitSet> bitSegments;

    public BitMap() {
        bitSegments = new HashMap<Long, BitSet>();
    }

    /*
     * @throws IndexOutOfBoundsException if index is negative.
     */
    public void set(long index)
        throws IndexOutOfBoundsException {

        if (index < 0) {
            throw new IndexOutOfBoundsException(index + " is negative.");
        }

        BitSet bitset = getBitSet(index, true);
        if (bitset == null) {
            throw EnvironmentFailureException.unexpectedState
                (index + " is out of bounds");
        }
        int useIndex = getIntIndex(index);
        bitset.set(useIndex);
    }

    /*
     * @throws IndexOutOfBoundsException if index is negative.
     */
    public boolean get(long index)
        throws IndexOutOfBoundsException {

        if (index < 0) {
            throw new IndexOutOfBoundsException(index + " is negative.");
        }

        BitSet bitset = getBitSet(index, false);
        if (bitset == null) {
            return false;
        }

        int useIndex = getIntIndex(index);
        return bitset.get(useIndex);
    }

    /*
     * Since the BitMap is implemented by a collection of BitSets, return
     * the one which covers the numeric range for this index.
     *
     * @param index the bit we want to access
     * @param allowCreate if true, return the BitSet that would hold this
     * index even if it wasn't previously set. If false, return null
     * if the bit has not been set.
     */
    private BitSet getBitSet(long index, boolean allowCreate) {

        Long segmentId = Long.valueOf(index >> SEGMENT_SIZE);

        BitSet bitset = bitSegments.get(segmentId);
        if (allowCreate) {
            if (bitset == null) {
                bitset = new BitSet();
                bitSegments.put(segmentId, bitset);
            }
        }

        return bitset;
    }

    private int getIntIndex(long index) {
        return (int) (index & SEGMENT_MASK);
    }

    /* For unit testing. */
    int getNumSegments() {
        return bitSegments.size();
    }

    /*
     * Currently for unit testing, though note that java.util.BitSet does
     * support cardinality().
     */
    int cardinality() {
        int count = 0;
        Iterator<BitSet> iter = bitSegments.values().iterator();
        while (iter.hasNext()) {
            BitSet b = iter.next();
            count += b.cardinality();
        }
        return count;
    }
}
