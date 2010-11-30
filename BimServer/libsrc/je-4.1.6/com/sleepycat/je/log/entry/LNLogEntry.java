/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log.entry;

import java.nio.ByteBuffer;
import java.util.Arrays;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.DbLsn;

/**
 * LNLogEntry embodies all LN transactional log entries.
 * On disk, an LN log entry contains (pre version 6)
 * <pre>
 *   LN
 *   databaseid
 *   key
 *   abortLsn          -- if transactional
 *   abortKnownDeleted -- if transactional
 *   txn               -- if transactional
 *
 * (version 6)
 *   databaseid
 *   abortLsn          -- if transactional
 *   abortKnownDeleted -- if transactional
 *   txn               -- if transactional
 *   LN
 *   key
 * </pre>
 * Before version 6, a non-full-item read of a log entry only retrieved
 * the node id. After version 6, the database id, transaction id and node id
 * are all available.
 */
public class LNLogEntry extends BaseEntry implements LogEntry, NodeLogEntry {
    private static final byte ABORT_KNOWN_DELETED_MASK = (byte) 1;

    /*
     * Persistent fields in an LN entry.
     */
    private LN ln;
    private DatabaseId dbId;
    private byte[] key;
    private long abortLsn = DbLsn.NULL_LSN;
    private boolean abortKnownDeleted;
    private Txn txn;     // conditional

    /*
     * Transient fields used by the entry.
     *
     * Save the node id when we read the log entry from disk. Do so explicitly
     * instead of merely returning ln.getNodeId(), because we don't always
     * instantiate the LN.
     */
    private long nodeId;

    /* Constructor to read an entry. */
    public LNLogEntry(Class<? extends LN> LNClass) {
        super(LNClass);
    }

    /* Constructor to write an entry. */
    public LNLogEntry(LogEntryType entryType,
                      LN ln,
                      DatabaseId dbId,
                      byte[] key,
                      long abortLsn,
                      boolean abortKnownDeleted,
                      Txn txn) {
        setLogType(entryType);
        this.ln = ln;
        this.dbId = dbId;
        this.key = key;
        this.abortLsn = abortLsn;
        this.abortKnownDeleted = abortKnownDeleted;
        this.txn = txn;
        this.nodeId = ln.getNodeId();

        /* A txn should only be provided for transactional entry types. */
        assert(entryType.isTransactional() == (txn!=null));
    }

    /**
     * @see LogEntry#readEntry
     */
    public void readEntry(LogEntryHeader header,
                          ByteBuffer entryBuffer,
                          boolean readFullItem)
        throws DatabaseException {

        int logVersion = header.getVersion();
        boolean unpacked = (logVersion < 6);
        int recStartPosition = entryBuffer.position();

        /*
         * For log version 6 and above we store the key last so that we can
         * avoid storing the key size. Instead, we derive it from the LN size
         * and the total entry size. The DatabaseId is also packed.  For older
         * log versions the LN is first, which let us optimize better for to
         * read the node id in a partial read, but didn't let us save on the
         * key size.
         *
         * Since log version 6 now requires the read of the database id and
         * transaction id before getting the node id, we're taking advantage of
         * that and are changing the semantics of readFullItem == false to
         * assume that. This helps because we'd like to do utilization tracking
         * with partial log entry reads. If we run into entries < version 6,
         * we'll just always do a full read.
         */
        if (unpacked) {
            /* LN is first for log versions prior to 6. */
            ln = (LN) newInstanceOfType();
            ln.readFromLog(entryBuffer, logVersion);
            nodeId = ln.getNodeId();
        }

        /* DatabaseImpl Id. */
        dbId = new DatabaseId();
        dbId.readFromLog(entryBuffer, logVersion);

        /* Key. */
        if (unpacked) {
            key = LogUtils.readByteArray(entryBuffer, true/*unpacked*/);
        } else {
            /* Read later. */
        }

        if (entryType.isTransactional()) {

            /*
             * AbortLsn. If it was a marker LSN that was used to fill in a
             * create, mark it null.
             */
            abortLsn = LogUtils.readLong(entryBuffer, unpacked);
            if (DbLsn.getFileNumber(abortLsn) ==
                DbLsn.getFileNumber(DbLsn.NULL_LSN)) {
                abortLsn = DbLsn.NULL_LSN;
            }

            abortKnownDeleted =
                ((entryBuffer.get() & ABORT_KNOWN_DELETED_MASK) != 0) ?
                true : false;

            /* Locker. */
            txn = new Txn();
            txn.readFromLog(entryBuffer, logVersion);
        }

        if (unpacked) {
            if (!readFullItem) {

                /*
                 * Position this buffer to its end, for the sake of any
                 * subclasses.
                 */
                int endPosition = recStartPosition + header.getItemSize();
                entryBuffer.position(endPosition);
            }
        } else {
            if (readFullItem) {
                /* LN is next for log version 6 and above. */
                ln = (LN) newInstanceOfType();
                ln.readFromLog(entryBuffer, logVersion);
                nodeId = ln.getNodeId();
                int bytesWritten =
                    entryBuffer.position() - recStartPosition;
                if (isLNType()) {
                    int keySize = header.getItemSize() - bytesWritten;
                    key = LogUtils.readBytesNoLength(entryBuffer, keySize);
                } else {
                    int keySize =
                        LogUtils.readInt(entryBuffer, false/*unpacked*/);
                    key = LogUtils.readBytesNoLength(entryBuffer, keySize);
                }
            } else {

                /*
                 * Read node ID and then set buffer position to end. This takes
                 * advantage of the fact that the node id is in a known spot,
                 * at the beginning of the LN.  We currently do not support
                 * getting the db and txn ID in this mode, and we may want to
                 * change the log format to do that efficiently.
                 */
                int endPosition = recStartPosition + header.getItemSize();
                nodeId = LogUtils.readPackedLong(entryBuffer);
                entryBuffer.position(endPosition);
                ln = null;
            }
        }

        /* LNs save the last logged size. */
        if (ln != null) {
            ln.setLastLoggedSize(header.getSize() + header.getItemSize());
        }
    }

    /**
     * @see LogEntry#dumpEntry
     */
    @Override
    public StringBuilder dumpEntry(StringBuilder sb, boolean verbose) {
        ln.dumpLog(sb, verbose);
        dbId.dumpLog(sb, verbose);
        ln.dumpKey(sb, key);
        if (entryType.isTransactional()) {
            if (abortLsn != DbLsn.NULL_LSN) {
                sb.append(DbLsn.toString(abortLsn));
            }
            sb.append("<knownDeleted val=\"");
            sb.append(abortKnownDeleted ? "true" : "false");
            sb.append("\"/>");
            txn.dumpLog(sb, verbose);
        }
        return sb;
    }

    /**
     * @see LogEntry#dumpRep
     */
    public void dumpRep(StringBuilder sb) {
        if (entryType.isTransactional()) {
            sb.append(" txn=").append(txn.getId());
        }
    }

    /**
     * @see LogEntry#getMainItem
     */
    public Object getMainItem() {
        return ln;
    }

    /**
     * @see LogEntry#clone
     */
    @Override
    public Object clone()
        throws CloneNotSupportedException {

        return super.clone();
    }

    /**
     * @see LogEntry#getTransactionId
     */
    public long getTransactionId() {
        if (entryType.isTransactional()) {
            return txn.getId();
        } else {
            return 0;
        }
    }

    /**
     * @see NodeLogEntry#getNodeId
     */
    public long getNodeId() {
        return nodeId;
    }

    /*
     * Writing support.
     */

    /**
     * #see LogEntry#getSize
     */
    public int getSize() {
        int len = key.length;
        int size = ln.getLogSize() +
            dbId.getLogSize() +
            len;
        if (!isLNType()) {
            size += LogUtils.getPackedIntLogSize(len);
        }
        if (entryType.isTransactional()) {
            size += LogUtils.getPackedLongLogSize(abortLsn);
            size++;   // abortKnownDeleted
            size += txn.getLogSize();
        }
        return size;
    }

    /**
     * Returns the last logged size, saved by readEntry and writeEntry.
     */
    @Override
    public int getLastLoggedSize() {
        return ln.getLastLoggedSize();
    }

    private boolean isLNType() {
        return entryType == LogEntryType.LOG_LN ||
            entryType == LogEntryType.LOG_LN_TRANSACTIONAL;
    }

    /**
     * @see LogEntry#writeEntry
     */
    public void writeEntry(LogEntryHeader header, ByteBuffer destBuffer) {
        dbId.writeToLog(destBuffer);

        if (entryType.isTransactional()) {
            LogUtils.writePackedLong(destBuffer, abortLsn);
            byte aKD = 0;
            if (abortKnownDeleted) {
                aKD |= ABORT_KNOWN_DELETED_MASK;
            }
            destBuffer.put(aKD);
            txn.writeToLog(destBuffer);
        }

        ln.writeToLog(destBuffer);
        if (isLNType()) {
            LogUtils.writeBytesNoLength(destBuffer, key);
        } else {
            LogUtils.writePackedInt(destBuffer, key.length);
            LogUtils.writeBytesNoLength(destBuffer, key);
        }

        /* LNs save the last logged size. */
        ln.setLastLoggedSize(header.getSize() + header.getItemSize());
    }

    /**
     * Returns true for a deleted LN to count it immediately as obsolete.
     * @see LogEntry#isDeleted
     */
    @Override
    public boolean isDeleted() {
        return ln.isDeleted();
    }

    /**
     * For LN entries, we need to record the latest LSN for that node with the
     * owning transaction, within the protection of the log latch. This is a
     * callback for the log manager to do that recording.
     *
     * @see LogEntry#postLogWork
     */
    @Override
    public void postLogWork(long justLoggedLsn) {
        if (entryType.isTransactional()) {
            txn.addLogInfo(justLoggedLsn);
        }
    }

    /*
     * Accessors.
     */
    public LN getLN() {
        return ln;
    }

    public DatabaseId getDbId() {
        return dbId;
    }

    public byte[] getKey() {
        return key;
    }

    public byte[] getDupKey() {
        if (ln.isDeleted()) {
            return null;
        } else {
            return ln.getData();
        }
    }

    public long getAbortLsn() {
        return abortLsn;
    }

    public boolean getAbortKnownDeleted() {
        return abortKnownDeleted;
    }

    public Long getTxnId() {
        if (entryType.isTransactional()) {
            return Long.valueOf(txn.getId());
        } else {
            return null;
        }
    }

    public Txn getUserTxn() {
        if (entryType.isTransactional()) {
            return txn;
        } else {
            return null;
        }
    }

    /**
     * @see LogEntry#logicalEquals
     */
    public boolean logicalEquals(LogEntry other) {
        if (!(other instanceof LNLogEntry)) {
            return false;
        }

        LNLogEntry otherEntry = (LNLogEntry) other;

        if (!dbId.logicalEquals(otherEntry.dbId)) {
            return false;
        }

        if (txn != null) {
            if (!txn.logicalEquals(otherEntry.txn)) {
                return false;
            }
        } else {
            if (otherEntry.txn != null) {
                return false;
            }
        }

        if (!Arrays.equals(key, otherEntry.key)) {
            return false;
        }

        if (!ln.logicalEquals(otherEntry.ln)) {
            return false;
        }

        return true;
    }
}
