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
 * Per-file utilization counters.  The UtilizationProfile stores a persistent
 * map of file number to FileSummary.
 */
public class FileSummary implements Loggable {

    /* Persistent fields. */
    public int totalCount;      // Total # of log entries
    public int totalSize;       // Total bytes in log file
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
    public FileSummary() {
    }

    /**
     * Returns whether this summary contains any non-zero totals.
     */
    public boolean isEmpty() {

        return totalCount == 0 &&
               totalSize == 0 &&
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
        if (totalSize > 0) {
            /* Leftover (non-IN non-LN) space is considered obsolete. */
            int leftoverSize = totalSize - (totalINSize + totalLNSize);
            int obsoleteSize = getObsoleteLNSize() +
                               getObsoleteINSize() +
                               leftoverSize;

            /*
             * Don't report more obsolete bytes than the total.  We may
             * calculate more than the total because of (intentional)
             * double-counting during recovery.
             */
            if (obsoleteSize > totalSize) {
                obsoleteSize = totalSize;
            }
            return obsoleteSize;
        } else {
            return 0;
        }
    }

    /**
     * Returns the total number of entries counted.  This value is guaranted
     * to increase whenever the tracking information about a file changes.  It
     * is used a key discriminator for FileSummaryLN records.
     */
    public int getEntriesCounted() {
        return totalCount + obsoleteLNCount + obsoleteINCount;
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

        totalCount = 0;
        totalSize = 0;
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
    public void add(FileSummary o) {

        totalCount += o.totalCount;
        totalSize += o.totalSize;
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

        return 10 * LogUtils.getIntLogSize();
    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer buf) {

        LogUtils.writeInt(buf, totalCount);
        LogUtils.writeInt(buf, totalSize);
        LogUtils.writeInt(buf, totalINCount);
        LogUtils.writeInt(buf, totalINSize);
        LogUtils.writeInt(buf, totalLNCount);
        LogUtils.writeInt(buf, totalLNSize);
        LogUtils.writeInt(buf, obsoleteINCount);
        LogUtils.writeInt(buf, obsoleteLNCount);
        LogUtils.writeInt(buf, obsoleteLNSize);
        LogUtils.writeInt(buf, obsoleteLNSizeCounted);
    }

    /**
     * @see Loggable#readFromLog
     */
    public void readFromLog(ByteBuffer buf, int entryVersion) {

        totalCount = LogUtils.readInt(buf);
        totalSize = LogUtils.readInt(buf);
        totalINCount = LogUtils.readInt(buf);
        totalINSize = LogUtils.readInt(buf);
        totalLNCount = LogUtils.readInt(buf);
        totalLNSize = LogUtils.readInt(buf);
        obsoleteINCount = LogUtils.readInt(buf);
        if (obsoleteINCount == -1) {

            /*
             * If INs were not counted in an older log file written by 1.5.3 or
             * earlier, consider all INs to be obsolete.  This causes the file
             * to be cleaned, and then IN counting will be accurate.
             */
            obsoleteINCount = totalINCount;
        }
        obsoleteLNCount = LogUtils.readInt(buf);

        /*
         * obsoleteLNSize and obsoleteLNSizeCounted were added in FileSummaryLN
         * version 3.
         */
        if (entryVersion >= 3) {
            obsoleteLNSize = LogUtils.readInt(buf);
            obsoleteLNSizeCounted = LogUtils.readInt(buf);
        } else {
            obsoleteLNSize = 0;
            obsoleteLNSizeCounted = 0;
        }
    }

    /**
     * @see Loggable#dumpLog
     */
    public void dumpLog(StringBuilder buf, boolean verbose) {

        buf.append("<summary totalCount=\"");
        buf.append(totalCount);
        buf.append("\" totalSize=\"");
        buf.append(totalSize);
        buf.append("\" totalINCount=\"");
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
