/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import java.nio.ByteBuffer;

import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;

/**
 * Per-DB-per-file utilization counters.  The DatabaseImpl stores a persistent
 * map of file number to DbFileSummary.
 */
public class DbFileSummary implements Loggable {

    /* Persistent fields. */
    public int totalINCount;    // Number of IN log entries
    public int totalINSize;     // Byte size of IN log entries
    public int totalLNCount;    // Number of LN log entries
    public int totalLNSize;     // Byte size of LN log entries
    public int obsoleteINCount; // Number of obsolete IN log entries
    public int obsoleteLNCount; // Number of obsolete LN log entries
    public int obsoleteLNSize;  // Byte size of obsolete LN log entries
    public int obsoleteLNSizeCounted;  // Number obsolete LNs with size counted

    /**
     * Creates an empty summary.
     */
    public DbFileSummary() {
    }

    /**
     * Returns whether this summary contains any non-zero totals.
     */
    public boolean isEmpty() {

        return totalLNCount == 0 &&
               totalINCount == 0 &&
               obsoleteINCount == 0 &&
               obsoleteLNCount == 0;
    }

    /**
     * Returns the approximate byte size of all obsolete LN entries.  In
     * FileSummaryLN version 3 and greater the exact tracked size is used.
     */
    public int getObsoleteLNSize() {

        if (totalLNCount == 0) {
            return 0;
        }

        /*
         * Use the tracked obsolete size for all entries for which the size was
         * counted, plus the average size for all obsolete entries whose size
         * was not counted.
         */
        int obsolete = obsoleteLNSize;
        int notCounted = obsoleteLNCount - obsoleteLNSizeCounted;
        if (notCounted > 0) {
            /* Use long arithmetic. */
            long total = totalLNSize;
            /* Scale by 255 to reduce integer truncation error. */
            total <<= 8;
            long avgSizePerLN = total / totalLNCount;
            obsolete += (int) ((notCounted * avgSizePerLN) >> 8);
        }
        return obsolete;
    }

    /**
     * Returns the approximate byte size of all obsolete IN entries.
     */
    public int getObsoleteINSize() {

        if (totalINCount == 0) {
            return 0;
        }
        /* Use long arithmetic. */
        long size = totalINSize;
        /* Scale by 255 to reduce integer truncation error. */
        size <<= 8;
        long avgSizePerIN = size / totalINCount;
        return (int) ((obsoleteINCount * avgSizePerIN) >> 8);
    }

    /**
     * Returns an estimate of the total bytes that are obsolete.
     */
    public int getObsoleteSize() {
        return getObsoleteLNSize() + getObsoleteINSize();
    }

    /**
     * Returns the number of non-obsolete LN and IN entries.
     */
    public int getNonObsoleteCount() {
        return totalLNCount +
               totalINCount -
               obsoleteLNCount -
               obsoleteINCount;
    }

    /**
     * Reset all totals to zero.
     */
    public void reset() {

        totalINCount = 0;
        totalINSize = 0;
        totalLNCount = 0;
        totalLNSize = 0;
        obsoleteINCount = 0;
        obsoleteLNCount = 0;
        obsoleteLNSize = 0;
        obsoleteLNSizeCounted = 0;
    }

    /**
     * Add the totals of the given summary object to the totals of this object.
     */
    public void add(DbFileSummary o) {

        totalINCount += o.totalINCount;
        totalINSize += o.totalINSize;
        totalLNCount += o.totalLNCount;
        totalLNSize += o.totalLNSize;
        obsoleteINCount += o.obsoleteINCount;
        obsoleteLNCount += o.obsoleteLNCount;
        obsoleteLNSize += o.obsoleteLNSize;
        obsoleteLNSizeCounted += o.obsoleteLNSizeCounted;
    }

    /**
     * @see Loggable#getLogSize
     */
    public int getLogSize() {
        return
            LogUtils.getPackedIntLogSize(totalINCount) +
            LogUtils.getPackedIntLogSize(totalINSize) +
            LogUtils.getPackedIntLogSize(totalLNCount) +
            LogUtils.getPackedIntLogSize(totalLNSize) +
            LogUtils.getPackedIntLogSize(obsoleteINCount) +
            LogUtils.getPackedIntLogSize(obsoleteLNCount) +
            LogUtils.getPackedIntLogSize(obsoleteLNSize) +
            LogUtils.getPackedIntLogSize(obsoleteLNSizeCounted);
    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer buf) {

        LogUtils.writePackedInt(buf, totalINCount);
        LogUtils.writePackedInt(buf, totalINSize);
        LogUtils.writePackedInt(buf, totalLNCount);
        LogUtils.writePackedInt(buf, totalLNSize);
        LogUtils.writePackedInt(buf, obsoleteINCount);
        LogUtils.writePackedInt(buf, obsoleteLNCount);
        LogUtils.writePackedInt(buf, obsoleteLNSize);
        LogUtils.writePackedInt(buf, obsoleteLNSizeCounted);
    }

    /**
     * @see Loggable#readFromLog
     */
    public void readFromLog(ByteBuffer buf, int entryTypeVersion) {

        totalINCount = LogUtils.readPackedInt(buf);
        totalINSize = LogUtils.readPackedInt(buf);
        totalLNCount = LogUtils.readPackedInt(buf);
        totalLNSize = LogUtils.readPackedInt(buf);
        obsoleteINCount = LogUtils.readPackedInt(buf);
        obsoleteLNCount = LogUtils.readPackedInt(buf);
        obsoleteLNSize = LogUtils.readPackedInt(buf);
        obsoleteLNSizeCounted = LogUtils.readPackedInt(buf);
    }

    /**
     * @see Loggable#dumpLog
     */
    public void dumpLog(StringBuilder buf, boolean verbose) {

        buf.append("<summary totalINCount=\"");
        buf.append(totalINCount);
        buf.append("\" totalINSize=\"");
        buf.append(totalINSize);
        buf.append("\" totalLNCount=\"");
        buf.append(totalLNCount);
        buf.append("\" totalLNSize=\"");
        buf.append(totalLNSize);
        buf.append("\" obsoleteINCount=\"");
        buf.append(obsoleteINCount);
        buf.append("\" obsoleteLNCount=\"");
        buf.append(obsoleteLNCount);
        buf.append("\" obsoleteLNSize=\"");
        buf.append(obsoleteLNSize);
        buf.append("\" obsoleteLNSizeCounted=\"");
        buf.append(obsoleteLNSizeCounted);
        buf.append("\"/>");
    }

    /**
     * Never called.
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return 0;
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
