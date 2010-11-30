 /*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.utilint;

import java.io.Serializable;
import java.nio.ByteBuffer;

import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;

public class VLSN implements Loggable, Comparable<VLSN>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final int LOG_SIZE = 8;

    public static final VLSN NULL_VLSN = new VLSN(-1);
    public static final VLSN FIRST_VLSN = new VLSN(1);

    /*
     * A replicated log entry is identified by a sequence id. We may change the
     * VLSN implementation so it's not a first-class object, in order to reduce
     * its in-memory footprint. In that case, the VLSN value would be a long,
     * and this class would provide static utility methods.
     */
    private long sequence;   // sequence number

    public VLSN(long sequence) {
        this.sequence = sequence;
    }

    /**
     * Constructor for VLSNs that are read from disk.
     */
    public VLSN() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof VLSN)) {
            return false;
        }

        VLSN otherVLSN = (VLSN) obj;
        return (otherVLSN.sequence == sequence);
    }

    final public boolean equals(VLSN otherVLSN) {
        return (otherVLSN != null) && (otherVLSN.sequence == sequence);
    }

    @Override
    public int hashCode() {
        return Long.valueOf(sequence).hashCode();
    }

    public long getSequence() {
        return sequence;
    }

    public final boolean isNull() {
        return sequence == NULL_VLSN.sequence;
    }

    static public boolean isNull(long sequence) {
        return sequence == NULL_VLSN.sequence;
    }

    /**
     * Return a VLSN which would follow this one.
     */
    public VLSN getNext() {
        return isNull()  ? FIRST_VLSN : new VLSN(sequence + 1);
    }

    /**
     * Return a VLSN which would precede this one.
     */
    public VLSN getPrev() {
        return (isNull() || (sequence == 1)) ?
                NULL_VLSN :
                new VLSN(sequence - 1);
    }

    /**
     * Return true if this VLSN's sequence directly follows the "other"
     * VLSN. This handles the case where "other" is a NULL_VLSN.
     */
    public boolean follows(VLSN other) {
        return ((other.isNull() && sequence == 1) ||
                ((!other.isNull()) &&
                 (other.getSequence() == (sequence - 1))));
    }

    /**
     * Compares this VLSN's sequence with the specified VLSN's sequence for
     * order. Returns a negative integer, zero, or a positive integer as this
     * sequence is less than, equal to, or greater than the specified sequence.
     */
    public int compareTo(VLSN other) {

        if (this.equals(NULL_VLSN) &&  other.equals(NULL_VLSN)) {
            return 0;
        }

        if (this.equals(NULL_VLSN)) {
            /* If "this" is null, the other VLSN is always greater. */
            return -1;
        }

        if (other.equals(NULL_VLSN)) {
            /* If the "other" is null, this VLSN is always greater. */
            return 1;
        }

        long otherSequence = other.getSequence();
        if ((sequence - otherSequence) > 0) {
            return 1;
        } else if (sequence == otherSequence) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * @see Loggable#getLogSize
     */
    public int getLogSize() {
        return LOG_SIZE;
    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer buffer) {
        LogUtils.writeLong(buffer, sequence);
    }

    /*
     *  Reading from a byte buffer
     */

    /**
     * @see Loggable#readFromLog
     */
    @SuppressWarnings("unused")
    public void readFromLog(ByteBuffer buffer, int entryVersion) {
        sequence = LogUtils.readLong(buffer);
    }

    /**
     * @see Loggable#dumpLog
     */
    @SuppressWarnings("unused")
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<vlsn v=\"").append(this).append("\">");
    }

    /**
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return 0;
    }

    /**
     * @see Loggable#logicalEquals
     */
    public boolean logicalEquals(Loggable other) {

        if (!(other instanceof VLSN)) {
            return false;
        }

        return sequence == ((VLSN) other).sequence;
    }

    @Override
    public String toString() {
        return String.format("%,d", sequence);
    }
}
