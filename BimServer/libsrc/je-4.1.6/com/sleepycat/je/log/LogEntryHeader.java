/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.nio.ByteBuffer;
import java.util.zip.Checksum;

import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.utilint.Adler32;
import com.sleepycat.je.utilint.VLSN;

/**
 * A LogEntryHeader embodies the header information at the beginning of each
 * log entry file.
 */
public class LogEntryHeader {

    /**
     * Persistent fields. Layout on disk is
     * (invariant) checksum - 4 bytes
     * (invariant) entry type - 1 byte
     * (invariant) entry flags - 1 byte
     * (invariant) offset of previous log entry - 4 bytes
     * (invariant) item size (not counting header size) - 4 bytes
     * (optional) vlsn - 8 bytes
     *
     * Flags:
     * The provisional bit can be set for any log type in the log. It's an
     * indication to recovery that the entry shouldn't be processed when
     * rebuilding the tree. See com.sleepycat.je.log.Provisional.java for
     * the reasons why it's set.
     *
     * The replicated bit is set when this particular log entry is
     * part of the replication stream and contains a VLSN in the header.
     *
     * The invisible bit is set when this log entry has been rolled back as
     * part of replication syncup. The ensuing log entry has not been
     * checksum-corrected, and to read it, the invisible bit must be cloaked.
     */

    /* The invariant size of the log entry header. */
    public static final int MIN_HEADER_SIZE = 14;

    /* Only used for tests and asserts. */
    public static final int MAX_HEADER_SIZE = MIN_HEADER_SIZE + VLSN.LOG_SIZE;

    public static final int CHECKSUM_BYTES = 4;

    static final int ENTRYTYPE_OFFSET = 4;
    static final int FLAGS_OFFSET = 5;
    private static final int PREV_OFFSET = 6;
    private static final int ITEMSIZE_OFFSET = 10;
    public static final int VLSN_OFFSET = MIN_HEADER_SIZE;

    /*
     * Flags defined in the entry header.
     *
     * WARNING: Flags may not be defined or used in the entry header of the
     * FileHeader.  All flags defined here may only be used in log entries
     * other then the FileHeader. [#16939]
     */
    private static final byte PROVISIONAL_ALWAYS_MASK = (byte) 0x80;
    private static final byte PROVISIONAL_BEFORE_CKPT_END_MASK = (byte) 0x40;
    private static final byte REPLICATED_MASK = (byte) 0x20;
    private static final byte INVISIBLE = (byte) 0x10;
    private static final byte IGNORE_INVISIBLE = ~INVISIBLE;
    /* Flags stored in version byte for logVersion 6 and below.*/
    private static final byte VERSION_6_FLAGS =
        PROVISIONAL_ALWAYS_MASK |
        PROVISIONAL_BEFORE_CKPT_END_MASK |
        REPLICATED_MASK;
    private static final byte IGNORE_VERSION_6_FLAGS = ~VERSION_6_FLAGS;

    private static final byte FILE_HEADER_TYPE_NUM =
                              LogEntryType.LOG_FILE_HEADER.getTypeNum();

    private long checksumVal;   // stored in 4 bytes as an unsigned int
    private final byte entryType;
    private long prevOffset;
    private final int itemSize;
    private VLSN vlsn;

    /*
     * Prior to log version 6, a type-specific version was stored in each
     * entry, and was packed together with the flags in a single byte.
     *
     * For version 6, we changed to use a global version (not type specific),
     * but it was stored in each entry, packed with the flags as in earlier
     * versions, as well as being stored redundantly in the FileHeader.  The
     * entry header and file header versions are always the same for all
     * entries in a file.  We flip the log file to guarantee this, when running
     * for the first time with an upgraded JE with a new log version.
     *
     * For version 7 and above, the version is stored only in the FileHeader,
     * freeing the space formerly taken by the version in each entry for use
     * by flag bits.  The version is not stored in each entry; however, the
     * version is still maintained in this in-memory object for two reasons:
     *
     * 1. When reading log files prior to version 6, each entry potentially has
     *    a different version.
     * 2. Convenience of access to the version when processing log entries.
     *
     * [#16939]
     */
    private int entryVersion;

    /* Version flag fields */
    private Provisional provisional;
    private boolean replicated;
    private boolean invisible;

    /**
     * For reading a log entry.
     *
     * @param entryBuffer the buffer containing at least the first
     * MIN_HEADER_SIZE bytes of the entry header.
     *
     * @param logVersion is the log version of the file that contains the given
     * buffer, and is obtained from the file header.  Note that for the file
     * header entry itself, UNKNOWN_FILE_HEADER_VERSION may be passed.
     */
    public LogEntryHeader(ByteBuffer entryBuffer, int logVersion)
        throws ChecksumException {

        assert logVersion == LogEntryType.UNKNOWN_FILE_HEADER_VERSION ||
               (logVersion >= LogEntryType.FIRST_LOG_VERSION &&
                logVersion <= LogEntryType.LOG_VERSION) : logVersion;

        checksumVal = LogUtils.readUnsignedInt(entryBuffer);
        entryType = entryBuffer.get();
        if (!LogEntryType.isValidType(entryType)) {
            throw new ChecksumException("Read invalid log entry type: " +
                                        entryType);
        }

        if (entryType == FILE_HEADER_TYPE_NUM) {
            /* Actual version will be set by setFileHeaderVersion. */
            entryVersion = LogEntryType.UNKNOWN_FILE_HEADER_VERSION;
            /* Discard flags byte: none are allowed for the file header. */
            entryBuffer.get();
            initFlags(0);
        } else {
            assert logVersion != LogEntryType.UNKNOWN_FILE_HEADER_VERSION :
                   logVersion;
            if (logVersion <= 6) {
                /* Before version 7, flags and version were packed together. */
                entryVersion = entryBuffer.get();
                initFlags(entryVersion & VERSION_6_FLAGS);
                entryVersion &= IGNORE_VERSION_6_FLAGS;
                /* For log version 6, the entry version should always match. */
                assert (logVersion == 6) ? (entryVersion == 6) : true;
            } else {
                /* For log version 7+, only flags are stored in the entry. */
                entryVersion = logVersion;
                initFlags(entryBuffer.get());
            }
        }
        prevOffset = LogUtils.readUnsignedInt(entryBuffer);
        itemSize = LogUtils.readInt(entryBuffer);
        if (itemSize < 0) {
            throw new ChecksumException("Read invalid item size: " + itemSize);
        }
    }

    /**
     * For writing a log header. public for unit tests.
     */
    public LogEntryHeader(LogEntry entry,
                          Provisional provisional,
                          ReplicationContext repContext) {

        LogEntryType logEntryType = entry.getLogType();
        entryType = logEntryType.getTypeNum();
        entryVersion = LogEntryType.LOG_VERSION;
        this.itemSize = entry.getSize();
        this.provisional = provisional;

        assert (!((!logEntryType.isReplicationPossible()) &&
                  repContext.inReplicationStream())) :
            logEntryType + " should never be replicated.";

        if (logEntryType.isReplicationPossible()) {
            this.replicated = repContext.inReplicationStream();
        } else {
            this.replicated = false;
        }
        invisible = false;
    }

    /**
     * For reading a replication message. The node-specific parts of the header
     * are not needed.
     */
    public LogEntryHeader(byte entryType,
                          int entryVersion,
                          int itemSize,
                          VLSN vlsn) {

        assert ((vlsn != null) && !vlsn.isNull()) :
        "vlsn = " + vlsn;

        this.entryType = entryType;
        this.entryVersion = entryVersion;
        this.itemSize = itemSize;
        this.vlsn = vlsn;
        replicated = true;
        provisional = Provisional.NO;
    }

    private void initFlags(int entryFlags) {
        if ((entryFlags & PROVISIONAL_ALWAYS_MASK) != 0) {
            provisional = Provisional.YES;
        } else if ((entryFlags & PROVISIONAL_BEFORE_CKPT_END_MASK) != 0) {
            provisional = Provisional.BEFORE_CKPT_END;
        } else {
            provisional = Provisional.NO;
        }
        replicated = ((entryFlags & REPLICATED_MASK) != 0);
        invisible = ((entryFlags & INVISIBLE) != 0);
    }

    /**
     * Called to set the version for a file header entry after reading the
     * version from the item data.  See FileHeaderEntry.readEntry.  [#16939]
     */
    public void setFileHeaderVersion(final int logVersion) {
        entryVersion = logVersion;
    }

    public long getChecksum() {
        return checksumVal;
    }

    public byte getType() {
        return entryType;
    }

    public int getVersion() {
        return entryVersion;
    }

    public long getPrevOffset() {
        return prevOffset;
    }

    public int getItemSize() {
        return itemSize;
    }

    public VLSN getVLSN() {
        return vlsn;
    }

    public boolean getReplicated() {
        return replicated;
    }

    public Provisional getProvisional() {
        return provisional;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public int getVariablePortionSize() {
        return VLSN.LOG_SIZE;
    }

    /**
     * @return number of bytes used to store this header
     */
    public int getSize() {
        if (replicated) {
            return MIN_HEADER_SIZE + VLSN.LOG_SIZE;
        }
        return MIN_HEADER_SIZE;
    }

    /**
     * @return the number of bytes used to store the header, excepting
     * the checksum field.
     */
    int getSizeMinusChecksum() {
        return getSize()- CHECKSUM_BYTES;
    }

    /**
     * @return the number of bytes used to store the header, excepting
     * the checksum field.
     */
    int getInvariantSizeMinusChecksum() {
        return MIN_HEADER_SIZE - CHECKSUM_BYTES;
    }

    /**
     * Assumes this is called directly after the constructor, and that the
     * entryBuffer is positioned right before the VLSN.
     */
    public void readVariablePortion(ByteBuffer entryBuffer) {
        if (replicated) {
            vlsn = new VLSN();
            vlsn.readFromLog(entryBuffer, entryVersion);
        }
    }

    /**
     * Serialize this object into the buffer and leave the buffer positioned in
     * the right place to write the following item.  The checksum, prevEntry,
     * and vlsn values will filled in later on.
     *
     * public for unit tests.
     */
    public void writeToLog(ByteBuffer entryBuffer) {

        /* Skip over the checksumVal, proceed to the entry type. */
        entryBuffer.position(ENTRYTYPE_OFFSET);
        entryBuffer.put(entryType);

        /* Flags */
        byte flags = 0;
        if (provisional == Provisional.YES) {
            flags |= PROVISIONAL_ALWAYS_MASK;
        } else if (provisional == Provisional.BEFORE_CKPT_END) {
            flags |= PROVISIONAL_BEFORE_CKPT_END_MASK;
        }
        if (replicated) {
            flags |= REPLICATED_MASK;
        }
        entryBuffer.put(flags);

        /*
         * Leave room for the prev offset, which must be added under
         * the log write latch. Proceed to write the item size.
         */
        entryBuffer.position(ITEMSIZE_OFFSET);
        LogUtils.writeInt(entryBuffer, itemSize);

        /*
         * Leave room for a VLSN if needed, must also be generated
         * under the log write latch.
         */
        if (replicated) {
            entryBuffer.position(entryBuffer.position() + VLSN.LOG_SIZE);
        }
    }

    /**
     * Add those parts of the header that must be calculated later to the
     * entryBuffer, and also assign the fields in this class.
     * That's
     * - the prev offset, which must be done within the log write latch to
     *   be sure what that lsn is
     * - the VLSN, for the same reason
     * - the checksumVal, which must be added last, after all other
     *   fields are marshalled.
     * (public for unit tests)
     */
    public ByteBuffer addPostMarshallingInfo(EnvironmentImpl envImpl,
                                             ByteBuffer entryBuffer,
                                             long lastOffset,
                                             ReplicationContext repContext) {

        /* Add the prev pointer */
        prevOffset = lastOffset;
        entryBuffer.position(PREV_OFFSET);
        LogUtils.writeUnsignedInt(entryBuffer, prevOffset);

        /* Add the optional VLSN */
        if (repContext.inReplicationStream()) {
            entryBuffer.position(VLSN_OFFSET);

            if (repContext.mustGenerateVLSN()) {
                vlsn = envImpl.bumpVLSN();
            } else {
                vlsn = repContext.getClientVLSN();
            }
            vlsn.writeToLog(entryBuffer);
        }

        /*
         * Now calculate the checksumVal and write it into the buffer.  Be sure
         * to set the field in this instance, for use later when printing or
         * debugging the header.
         */
        Checksum checksum = Adler32.makeChecksum();
        checksum.update(entryBuffer.array(),
                        entryBuffer.arrayOffset() + CHECKSUM_BYTES,
                        entryBuffer.limit() - CHECKSUM_BYTES);
        entryBuffer.position(0);
        checksumVal = checksum.getValue();
        LogUtils.writeUnsignedInt(entryBuffer, checksumVal);

        /* Leave this buffer ready for copying into another buffer. */
        entryBuffer.position(0);

        return entryBuffer;
    }

    /**
     * @param sb destination string buffer
     * @param verbose if true, dump the full, verbose version
     */
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<hdr ");
        dumpLogNoTag(sb, verbose);
        sb.append("\"/>");
    }

    /**
     * Dump the header without enclosing <header> tags. Used for
     * DbPrintLog, to make the header attributes in the <entry> tag, for
     * a more compact rendering.
     * @param sb destination string buffer
     * @param verbose if true, dump the full, verbose version
     */
    void dumpLogNoTag(StringBuilder sb, boolean verbose) {
        LogEntryType lastEntryType = LogEntryType.findType(entryType);

        sb.append("type=\"").append(lastEntryType.toStringNoVersion()).
            append("/").append(entryVersion);
        if (provisional != Provisional.NO) {
            sb.append("\" prov=\"");
            sb.append(provisional);
        }

        /*
         * No need to show isReplicated bit; the presence of a VLSN indicates
         * that the entry is replicated.
         */
        if (vlsn != null) {
            sb.append("\" ");
            vlsn.dumpLog(sb, verbose);
        } else {
            sb.append("\"");
        }

        if (isInvisible()) {
            sb.append(" isInvisible=\"1\"");
        }

        sb.append(" prev=\"0x").append(Long.toHexString(prevOffset));
        if (verbose) {
            sb.append("\" size=\"").append(itemSize);
            sb.append("\" cksum=\"").append(checksumVal);
        }
    }

    /**
     * For use in special case where commits are transformed to aborts because
     * of i/o errors during a logBuffer flush. See [11271].
     * Assumes that the entryBuffer is positioned at the start of the item.
     * Return with the entryBuffer positioned to the end of the log entry.
     */
    void convertCommitToAbort(ByteBuffer entryBuffer) {
        assert (entryType == LogEntryType.LOG_TXN_COMMIT.getTypeNum());

        /* Remember the start of the entry item. */
        int itemStart = entryBuffer.position();

        /* Back up to where the type is stored and change the type. */
        int entryTypePosition =
            itemStart - (getSize() - ENTRYTYPE_OFFSET);
        entryBuffer.position(entryTypePosition);
        entryBuffer.put(LogEntryType.LOG_TXN_ABORT.getTypeNum());

        /*
         * Recalculate the checksum. This byte buffer could be large,
         * so don't just turn the whole buffer into an array to pass
         * into the checksum object.
         */
        Checksum checksum = Adler32.makeChecksum();
        int checksumSize = itemSize + (getSize() - CHECKSUM_BYTES);
        checksum.update(entryBuffer.array(),
                        entryTypePosition + entryBuffer.arrayOffset(),
                        checksumSize);
        entryBuffer.position(itemStart - getSize());
        checksumVal = checksum.getValue();
        LogUtils.writeUnsignedInt(entryBuffer, checksumVal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        dumpLog(sb, true /* verbose */);
        return sb.toString();
    }

    /*
     * Dump only the parts of the header that apply for replicated entries.
     */
    public void dumpRep(StringBuilder sb) {

        LogEntryType lastEntryType = LogEntryType.findType(entryType);

        sb.append(lastEntryType.toStringNoVersion()).
            append("/").append(entryVersion);

        if (vlsn != null) {
            sb.append(" vlsn=" ).append(vlsn);
        } else {
            sb.append("\"");
        }
        if (isInvisible()) {
            sb.append( "invisible=1");
        }
    }

    /**
     * @return true if two log headers are logically the same. This check will
     * ignore the log version.
     *
     * Used for replication.
     */
    public boolean logicalEqualsIgnoreVersion(LogEntryHeader other) {

        /*
         * Note that item size is not part of the logical equality, because
         * on-disk compression can make itemSize vary if the entry has VLSNs
         * that were packed differently.
         */
        return ((getVLSN().equals(other.getVLSN())) &&
                (getReplicated() == other.getReplicated()) &&
                (isInvisible() == other.isInvisible()) &&
                (LogEntryType.compareTypeAndVersion(getVersion(), getType(),
                                                    other.getVersion(),
                                                    other.getType())));
    }

    /**
     * May be called after reading MIN_HEADER_SIZE bytes to determine
     * whether more bytes (getVariablePortionSize) should be read.
     */
    public boolean isVariableLength() {
        /* Currently only replicated entries are variable length. */
        return replicated;
    }

    /**
     * Set the invisible bit in the given log entry flags.
     */
    static byte makeInvisible(byte flags) {
        return flags |= INVISIBLE;
    }

    /**
     * Turn off the invisible bit in the byte buffer which backs this log entry
     * header.
     * @param logHeaderStartPosition the byte position of the start of the log
     * entry header.
     */
    public static void turnOffInvisible(ByteBuffer buffer,
                                        int logHeaderStartPosition) {

        int flagsPosition = logHeaderStartPosition + FLAGS_OFFSET;
        byte flags = buffer.get(flagsPosition);
        flags &= IGNORE_INVISIBLE;
        buffer.put(flagsPosition, flags);
    }
}
