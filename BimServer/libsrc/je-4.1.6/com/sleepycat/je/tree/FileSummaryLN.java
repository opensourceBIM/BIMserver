/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.cleaner.FileSummary;
import com.sleepycat.je.cleaner.PackedOffsets;
import com.sleepycat.je.cleaner.TrackedFileSummary;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;

/**
 * A FileSummaryLN represents a Leaf Node in the UtilizationProfile database.
 *
 * <p>The contents of the FileSummaryLN are not fixed until the moment at which
 * the LN is added to the log.  A base summary object contains the summary last
 * added to the log.  A tracked summary object contains live summary info being
 * updated in real time.  The tracked summary is added to the base summary just
 * before logging it, and then the tracked summary is reset.  This ensures that
 * the logged summary will accurately reflect the totals calculated at the
 * point in the log where the LN is added.</p>
 *
 * <p>This is all done in the writeToLog method, which operates under the log
 * write latch.  All utilization tracking must be done under the log write
 * latch.</p>
 *
 * <p>In record version 1, obsolete offset tracking was added and multiple
 * records are stored for a single file rather than a single record.  Each
 * record contains the offsets that were tracked since the last record was
 * written.
 *
 * <p>The key is 8 bytes: 4 bytes for the file number followed by 4 bytes for
 * the sequence number.  The lowest valued key for a given file contains the
 * most recent summary information, while to get a complete list of obsolete
 * offsets all records for the file must be read.  A range search using just
 * the first 4 bytes can be used to find the most recent record -- this is
 * possible because the sequence number values are decreasing over time for a
 * given file.  Here are example keys for three summary records in file 1:</p>
 *
 * <pre>
 * (file=1, sequence=Integer.MAX_VALUE - 300)
 * (file=1, sequence=Integer.MAX_VALUE - 200)
 * (file=1, sequence=Integer.MAX_VALUE - 100)
 * </pre>
 *
 * <p>The sequence number is the number of obsolete entries counted so far,
 * subtracted from Integer.MAX_VALUE to cause the latest written record to have
 * the lowest key.</p>
 *
 * <h3>Log version information</h3>
 * <p>Version 0: Keys are old format strings. No obsolete detail is
 * present.</p>
 * <p>Version 1: Keys are two 4 byte integers: {file, sequence}.  Obsolete
 * detail is present.  Some offsets may be invalid if RMW was used.</p>
 * <p>Version 2: The RMW problem with invalid offsets was corrected.  There is
 * no data format change; all versions of JE 2.0.x can read version 1.</p>
 *
 * @see com.sleepycat.je.cleaner.UtilizationProfile
 */
public final class FileSummaryLN extends LN {

    private static final String BEGIN_TAG = "<fileSummaryLN>";
    private static final String END_TAG = "</fileSummaryLN>";

    private int extraMarshaledMemorySize;
    private final FileSummary baseSummary;
    private TrackedFileSummary trackedSummary;
    private PackedOffsets obsoleteOffsets;
    private boolean needOffsets;
    private int entryVersion;

    /**
     * Creates a new LN with a given base summary.
     */
    public FileSummaryLN(EnvironmentImpl envImpl,
                         FileSummary baseSummary) {
        super(new byte[0],
              envImpl,   // envImpl
              false); // replicate
        assert baseSummary != null;
        this.baseSummary = baseSummary;
        obsoleteOffsets = new PackedOffsets();
        entryVersion = -1;
    }

    /**
     * Creates an empty LN to be filled in from the log.
     */
    public FileSummaryLN() {
        baseSummary = new FileSummary();
        obsoleteOffsets = new PackedOffsets();
    }

    /**
     * Sets the live summary object that will be added to the base summary at
     * the time the LN is logged.
     */
    public void setTrackedSummary(TrackedFileSummary trackedSummary) {
        this.trackedSummary = trackedSummary;
        needOffsets = true;
    }

    /**
     * Returns the tracked summary, or null if setTrackedSummary was not
     * called.
     */
    public TrackedFileSummary getTrackedSummary() {
        return trackedSummary;
    }

    /**
     * Returns the base summary for the file that is stored in the LN.
     */
    public FileSummary getBaseSummary() {
        return baseSummary;
    }

    /**
     * Returns the obsolete offsets for the file.
     */
    public PackedOffsets getObsoleteOffsets() {
        return obsoleteOffsets;
    }

    /**
     * Returns true if the given key for this LN is a String file number key.
     * For the old version of the LN there will be a single record per file.
     *
     * If this is a version 0 log entry, the key is a string.  However, such an
     * LN may be migrated by the cleaner, in which case the version will be 1
     * or greater [#13061].  In the latter case, we can distinguish a string
     * key by:
     *
     * 1) If the key is not 8 bytes long, it has to be a string key.
     *
     * 2) If the key is 8 bytes long, but bytes[4] is ascii "0" to "9", then it
     * must be a string key.  bytes[4] to bytes[7] are a sequence number that
     * is the number of log entries counted.  For this number to be greater
     * than 0x30000000, the binary value of 4 digits starting with ascii "0",
     * over 400 million log entries would have to occur in a single file; this
     * should never happen.
     *
     * Note that having to rely on method (2) is unlikely.  A string key will
     * only be 8 bytes if the file number reach 8 decimal digits (10,000,000 to
     * 99,999,999).  This is a very large file number and unlikely to have
     * occurred using JE 1.7.1 or earlier.
     *
     * In summary, the only time the algorithm here could fail is if there were
     * more than 400 million log entries per file, and more than 10 million
     * were written with JE 1.7.1 or earlier.
     */
    public boolean hasStringKey(byte[] bytes) {

        if (entryVersion == 0 || bytes.length != 8) {
            return true;
        } else {
           return (bytes[4] >= '0' && bytes[4] <= '9');
        }
    }

    /**
     * Convert a FileSummaryLN key from a byte array to a long.  The file
     * number is the first 4 bytes of the key.
     */
    public long getFileNumber(byte[] bytes) {

        if (hasStringKey(bytes)) {
            try {
                return Long.valueOf(new String(bytes, "UTF-8")).longValue();
            } catch (UnsupportedEncodingException shouldNeverHappen) {
                assert false: shouldNeverHappen;
                return 0;
            }
        } else {
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            return LogUtils.readIntMSB(buf) & 0xFFFFFFFFL;
        }
    }

    /**
     * Get the sequence number from the byte array. The sequence number is the
     * last 4 bytes of the key.
     */
    private long getSequence(byte[] bytes) {
        if (hasStringKey(bytes)) {
            return 0;
        } else {
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            LogUtils.readIntMSB(buf);
            return 
                (Integer.MAX_VALUE - LogUtils.readIntMSB(buf)) & 0xFFFFFFFFL;
        }
    }

    /**
     * Returns the first 4 bytes of the key for the given file number.  This
     * can be used to do a range search to find the first LN for the file.
     */
    public static byte[] makePartialKey(long fileNum) {

        byte[] bytes = new byte[4];
        ByteBuffer buf = ByteBuffer.wrap(bytes);

        LogUtils.writeIntMSB(buf, (int) fileNum);

        return bytes;
    }

    /**
     * Returns the full two-part key for a given file number and unique
     * sequence.  This can be used to insert a new LN.
     *
     * @param sequence is a unique identifier for the LN for the given file,
     * and must be greater than the last sequence.
     */
    public static byte[] makeFullKey(long fileNum, int sequence) {

        assert sequence >= 0;

        byte[] bytes = new byte[8];
        ByteBuffer buf = ByteBuffer.wrap(bytes);

        /*
         * The sequence is subtracted from MAX_VALUE so that increasing values
         * will be sorted first.  This allows a simple range search to find the
         * most recent value.
         */
        LogUtils.writeIntMSB(buf, (int) fileNum);
        LogUtils.writeIntMSB(buf, Integer.MAX_VALUE - sequence);

        return bytes;
    }

    /**
     * Initialize a node that has been faulted in from the log.  If this FSLN
     * contains version 1 offsets that can be incorrect when RMW was used, and
     * if je.cleaner.rmwFix is enabled, discard the offsets.  [#13158]
     */
    @Override
    public void postFetchInit(DatabaseImpl db, long sourceLsn)
        throws DatabaseException {

        super.postFetchInit(db, sourceLsn);

        if (entryVersion == 1 &&
            db.getDbEnvironment().getUtilizationProfile().isRMWFixEnabled()) {
            obsoleteOffsets = new PackedOffsets();
        }
    }

    /*
     * Dumping
     */

    @Override
    public String toString() {
        return dumpString(0, true);
    }

    @Override
    public String beginTag() {
        return BEGIN_TAG;
    }

    @Override
    public String endTag() {
        return END_TAG;
    }

    @Override
    public String dumpString(int nSpaces, boolean dumpTags) {
        StringBuffer sb = new StringBuffer();
        sb.append(super.dumpString(nSpaces, dumpTags));
        sb.append('\n');
        if (!isDeleted()) {
            sb.append(baseSummary.toString());
            sb.append(obsoleteOffsets.toString());
        }
        return sb.toString();
    }

    /**
     * Dump additional fields. Done this way so the additional info can
     * be within the XML tags defining the dumped log entry.
     */
    @Override
    protected void dumpLogAdditional(StringBuilder sb, boolean verbose) {
        if (!isDeleted()) {
            baseSummary.dumpLog(sb, true);
            if (verbose) {
               obsoleteOffsets.dumpLog(sb, true);
            }
        }
    }

    /*
     * Logging
     */

    /**
     * Log type for transactional entries.
     */
    @Override
    protected LogEntryType getTransactionalLogType() {
        assert false : "Txnl access to UP db not allowed";
        return LogEntryType.LOG_FILESUMMARYLN;
    }

    /**
     * @see Node#getLogType
     */
    @Override
    public LogEntryType getLogType() {
        return LogEntryType.LOG_FILESUMMARYLN;
    }

    /**
     * This log entry type is configured to perform marshaling (getLogSize and
     * writeToLog) under the write log mutex.  Otherwise, the size could change
     * in between calls to these two methods as the result of utilizaton
     * tracking.
     *
     * @see LN#getLogSize
     */
    @Override
    public int getLogSize() {
        int size = super.getLogSize();
        if (!isDeleted()) {
            size += baseSummary.getLogSize();
            getOffsets();
            size += obsoleteOffsets.getLogSize();
        }
        return size;
    }

    /**
     * @see LN#writeToLog
     */
    @Override
    public void writeToLog(ByteBuffer logBuffer) {

        /*
         * Add the tracked (live) summary to the base summary before writing it
         * to the log, and reset the tracked summary.  Do this even when
         * deleting the LN, so that the tracked summary is cleared.
         */
        if (trackedSummary != null) {

            baseSummary.add(trackedSummary);

            if (!isDeleted()) {
                getOffsets();
            }

            /* Reset the totals to zero and clear the tracked offsets. */
            trackedSummary.reset();
        }

        super.writeToLog(logBuffer);

        if (!isDeleted()) {
            baseSummary.writeToLog(logBuffer);
            obsoleteOffsets.writeToLog(logBuffer);
        }
    }

    /**
     * @see LN#readFromLog
     */
    @Override
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {

        this.entryVersion = entryVersion;

        super.readFromLog(itemBuffer, entryVersion);

        if (!isDeleted()) {
            baseSummary.readFromLog(itemBuffer, entryVersion);
            if (entryVersion > 0) {
                obsoleteOffsets.readFromLog(itemBuffer, entryVersion);
            }
        }
    }

    /**
     * @see Loggable#logicalEquals
     * Should never be replicated.
     */
    @Override
    public boolean logicalEquals(Loggable other) {

        return false;
    }

    /**
     * If tracked offsets may be present, get them so they are ready to be
     * written to the log.
     */
    private void getOffsets() {
        assert !isDeleted();
        if (needOffsets) {
            long[] offsets = trackedSummary.getObsoleteOffsets();
            if (offsets != null) {
                int oldSize = obsoleteOffsets.getExtraMemorySize();
                obsoleteOffsets.pack(offsets);
                int newSize = obsoleteOffsets.getExtraMemorySize();
                extraMarshaledMemorySize = newSize - oldSize;
            }
            needOffsets = false;
        }
    }

    /**
     * Overrides this method to add space occupied by this object's fields.
     */
    @Override
    public long getMemorySizeIncludedByParent() {
        return super.getMemorySizeIncludedByParent() +
               (MemoryBudget.FILESUMMARYLN_OVERHEAD -
                MemoryBudget.LN_OVERHEAD) +
               obsoleteOffsets.getExtraMemorySize();
    }

    /**
     * Clear out the obsoleteOffsets to save memory when the LN is deleted.
     */
    @Override
    void makeDeleted() {
        super.makeDeleted();
        obsoleteOffsets = new PackedOffsets();
    }

    /**
     * Adds the extra memory used by obsoleteOffsets to the parent BIN memory
     * size. Must be called after LN is inserted into the BIN and logged,
     * while the cursor is still positioned on the inserted LN.  The BIN must
     * be latched.  [#17462]
     *
     * <p>The obsoleteOffsets memory size is not intially budgeted in the usual
     * way because PackedOffsets.pack (which changes the memory size) is called
     * during marshalling (see getOffset).  This amount is not counted in the
     * parent IN size in the usual way, because LN logging / marshalling occurs
     * after the LN is inserted in the BIN and its memory size has been counted
     * (see Tree.insert).</p>
     * 
     * <p>Note that the tree memory usage cannot be updated directly in
     * getOffsets because the tree memory usage must always be the sum of all
     * IN sizes, and it is reset to this sum each checkpoint.</p>
     */
    public void addExtraMarshaledMemorySize(BIN parentBIN) {
        if (extraMarshaledMemorySize != 0) {
            assert trackedSummary != null; /* Must be set during the insert. */
            assert parentBIN.isLatchOwnerForWrite();
            parentBIN.updateMemorySize(0, extraMarshaledMemorySize);
            extraMarshaledMemorySize = 0;
        }
    }

    @Override
    public void dumpKey(StringBuilder sb, byte[] key) {
        sb.append("<fileSummaryLNKey fileNumber=\"0x" + 
                  Long.toHexString(getFileNumber(key)) + "\" ");
        sb.append("sequence=\"0x" + 
                  Long.toHexString(getSequence(key)) + "\"/>");
        super.dumpKey(sb, key);
    }
}
