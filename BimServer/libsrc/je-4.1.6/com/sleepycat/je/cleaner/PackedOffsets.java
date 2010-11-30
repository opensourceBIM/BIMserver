/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import java.nio.ByteBuffer;
import java.util.Arrays;

import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;

/**
 * Stores a sorted list of LSN offsets in a packed short representation.  Each
 * stored value is the difference between two consecutive offsets.  The stored
 * values are stored as one or more shorts where each short holds 0x7fff
 * values.  Shorts are in LSB order.  The value is negated if more shorts for
 * the same offset follow; this works because offsets are always positive
 * values.
 */
public class PackedOffsets implements Loggable {

    private short[] data;
    private int size;

    /**
     * Creates an empty object.
     */
    public PackedOffsets() {

        /*
         * Verify assumption in FileSummaryLN that a new PackedOffsets instance
         * has no extra extra memory that must be budgeted.
         */
        assert getExtraMemorySize() == 0;
    }

    /**
     * Returns an iterator over all offsets.
     */
    Iterator iterator() {
        return new Iterator();
    }

    /**
     * Packs the given offsets, replacing any offsets stored in this object.
     */
    public void pack(long[] offsets) {

        /* Allocate a maximum sized new data array. */
        short[] newData = new short[offsets.length * 3];

        /* Pack the sorted offsets. */
        Arrays.sort(offsets);
        int dataIndex = 0;
        long priorVal = 0;
        for (int i = 0; i < offsets.length; i += 1) {
            long val = offsets[i];
            dataIndex = append(newData, dataIndex, val - priorVal);
            priorVal = val;
        }

        /* Copy in the exact sized new data. */
        data = new short[dataIndex];
        System.arraycopy(newData, 0, data, 0, dataIndex);
        size = offsets.length;
    }

    /**
     * Returns the unpacked offsets.
     */
    long[] toArray() {
        long[] offsets = new long[size];
        int index = 0;
        Iterator iter = iterator();
        while (iter.hasNext()) {
            offsets[index++] = iter.next();
        }
        assert index == size;
        return offsets;
    }

    /**
     * Copies the given value as a packed long to the array starting at the
     * given index.  Returns the index of the next position in the array.
     */
    private int append(short[] to, int index, long val) {

        assert val >= 0;

        while (true) {
            short s = (short) (val & 0x7fff);
            val >>>= 15;
            if (val > 0) {
                to[index++] = (short) (-1 - s);
            } else {
                to[index++] = s;
                break;
            }
        }
        return index;
    }

    /**
     * An iterator over all offsets.
     */
    class Iterator {

        private int index;
        private long priorVal;

        private Iterator() {
        }

        boolean hasNext() {
            return data != null && index < data.length;
        }

        long next() {
            long val = priorVal;
            for (int shift = 0;; shift += 15) {
                long s = data[index++];
                if (s < 0) {
                    val += (-1 - s) << shift;
                } else {
                    val += s << shift;
                    break;
                }
            }
            priorVal = val;
            return val;
        }
    }

    /**
     * Return the extra memory used by this object when the pack() method has
     * been called to allocate the data array.
     */
    public int getExtraMemorySize() {
        if (data != null) {
            return MemoryBudget.shortArraySize(data.length);
        } else {
            return 0;
        }
    }

    /**
     * @see Loggable#getLogSize
     */
    public int getLogSize() {

        int len = (data != null) ? data.length : 0;
        return  (LogUtils.getPackedIntLogSize(size) +
                 LogUtils.getPackedIntLogSize(len) +
                 (len * LogUtils.SHORT_BYTES));
    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer buf) {

        LogUtils.writePackedInt(buf, size);
        if (data != null) {
            LogUtils.writePackedInt(buf, data.length);
            for (int i = 0; i < data.length; i += 1) {
                LogUtils.writeShort(buf, data[i]);
            }
        } else {
            LogUtils.writePackedInt(buf, 0);
        }
    }

    /**
     * @see Loggable#readFromLog
     */
    public void readFromLog(ByteBuffer buf, int entryVersion) {

        boolean unpacked = (entryVersion < 6);
        size = LogUtils.readInt(buf, unpacked);
        int len = LogUtils.readInt(buf, unpacked);
        if (len > 0) {
            data = new short[len];
            for (int i = 0; i < len; i += 1) {
                data[i] = LogUtils.readShort(buf);
            }
        }
    }

    /**
     * @see Loggable#dumpLog
     */
    public void dumpLog(StringBuilder buf, boolean verbose) {

        if (size > 0) {
            Iterator i = iterator();
            buf.append("<offsets size=\"");
            buf.append(size);
            buf.append("\">");
            while (i.hasNext()) {
                buf.append("0x");
                buf.append(Long.toHexString(i.next()));
                buf.append(' ');
            }
            buf.append("</offsets>");
        } else {
            buf.append("<offsets size=\"0\"/>");
        }
    }

    /**
     * Never called.
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return -1;
    }

    /**
     * @see Loggable#logicalEquals
     * Always return false, this item should never be compared.
     */
    public boolean logicalEquals(Loggable other) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        dumpLog(buf, true);
        return buf.toString();
    }
}
