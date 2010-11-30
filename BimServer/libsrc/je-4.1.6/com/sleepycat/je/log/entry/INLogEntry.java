/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log.entry;

import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.utilint.DbLsn;

/**
 * INLogEntry embodies all IN log entries.
 * On disk, an IN log entry contains:
 * <pre>
 *        IN
 *        database id
 *        obsolete LSN  -- in version 2
 * </pre>
 */
public class INLogEntry extends BaseEntry
    implements LogEntry, NodeLogEntry, INContainingEntry {

    /*
     * Persistent fields in an IN entry.
     */
    private IN in;
    private DatabaseId dbId;

    /*
     * obsoleteFile was added in version 1, and changed to obsoleteLsn in
     * version 2.  If the offset is zero in the LSN, we read a version 1 entry
     * since only the file number was stored.
     */
    private long obsoleteLsn;

    /*
     * Transient fields
     *
     * Save the node id when we read the log entry from disk. Do so explicitly
     * instead of merely returning in.getNodeId(), because we don't always
     * instantiate the IN.
     */
    private long nodeId;

    /**
     * Construct a log entry for reading.
     */
    public INLogEntry(Class<? extends IN> INClass) {
        super(INClass);
    }

    /**
     * Construct a log entry for writing to the log.
     */
    public INLogEntry(IN in) {
        setLogType(in.getLogType());
        this.in = in;
        this.dbId = in.getDatabase().getId();
        this.nodeId = in.getNodeId();
        this.obsoleteLsn = in.getLastFullVersion();
    }

    /*
     * Read support
     */

    /**
     * Read in an IN entry.
     */
    public void readEntry(LogEntryHeader header,
                          ByteBuffer entryBuffer,
                          boolean readFullItem)
        throws DatabaseException {

        int logVersion = header.getVersion();
        boolean version6OrLater = (logVersion >= 6);
        if (version6OrLater) {
            dbId = new DatabaseId();
            dbId.readFromLog(entryBuffer, logVersion);
            obsoleteLsn =
                LogUtils.readLong(entryBuffer, false/*unpacked*/);
        }
        if (readFullItem) {
            /* Read IN and get node ID. */
            in = (IN) newInstanceOfType();
            in.readFromLog(entryBuffer, logVersion);
            nodeId = in.getNodeId();
        } else {
            /* Calculate position following IN. */
            int position = entryBuffer.position() + header.getItemSize();
            if (logVersion == 1) {
                /* Subtract size of obsoleteLsn */
                position -= LogUtils.UNSIGNED_INT_BYTES;
            } else if (logVersion >= 2) {
                /* Subtract size of obsoleteLsn */
                if (version6OrLater) {
                    position -= LogUtils.getPackedLongLogSize(obsoleteLsn);
                } else {
                    position -= LogUtils.LONG_BYTES;
                }
            }
            /* Subtract size of dbId */
            if (!version6OrLater) {
                position -= LogUtils.INT_BYTES;
            } else {
                position -= LogUtils.getPackedIntLogSize(dbId.getId());
            }
            /* Read node ID and position after IN. */
            nodeId = LogUtils.readLong(entryBuffer, !version6OrLater);
            entryBuffer.position(position);
            in = null;
        }
        if (!version6OrLater) {
            dbId = new DatabaseId();
            dbId.readFromLog(entryBuffer, logVersion);
        }
        if (logVersion < 1) {
            obsoleteLsn = DbLsn.NULL_LSN;
        } else if (logVersion == 1) {
            long fileNum = LogUtils.readUnsignedInt(entryBuffer);
            if (fileNum == 0xffffffffL) {
                obsoleteLsn = DbLsn.NULL_LSN;
            } else {
                obsoleteLsn = DbLsn.makeLsn(fileNum, 0);
            }
        } else if (!version6OrLater) {
            obsoleteLsn = LogUtils.readLong(entryBuffer, true/*unpacked*/);
        }
    }

    /**
     * Returns the LSN of the prior version of this node.  Used for counting
     * the prior version as obsolete.  If the offset of the LSN is zero, only
     * the file number is known because we read a version 1 log entry.
     */
    public long getObsoleteLsn() {

        return obsoleteLsn;
    }

    /**
     * Print out the contents of an entry.
     */
    @Override
    public StringBuilder dumpEntry(StringBuilder sb, boolean verbose) {
        in.dumpLog(sb, verbose);
        dbId.dumpLog(sb, verbose);
        return sb;
    }

    /** Never replicated. */
    public void dumpRep(@SuppressWarnings("unused") StringBuilder sb) {
    }

    /**
     * @return the item in the log entry
     */
    public Object getMainItem() {
        return in;
    }

    @Override
    public Object clone()
        throws CloneNotSupportedException {

        return super.clone();
    }

    /**
     * @see LogEntry#getTransactionId
     */
    public long getTransactionId() {
        return 0;
    }

    /*
     * Writing support
     */

    /**
     */
    public int getSize() {
        return (in.getLogSize() +
                dbId.getLogSize() +
                LogUtils.getPackedLongLogSize(obsoleteLsn));
    }

    /**
     * @see LogEntry#writeEntry
     */
    public void writeEntry(@SuppressWarnings("unused") LogEntryHeader header,
                           ByteBuffer destBuffer) {
        dbId.writeToLog(destBuffer);
        LogUtils.writePackedLong(destBuffer, obsoleteLsn);
        in.writeToLog(destBuffer);
    }

    /*
     * Access the in held within the entry.
     * @see INContainingEntry#getIN()
     */
    public IN getIN(@SuppressWarnings("unused") EnvironmentImpl env) {
        return in;
    }

    /**
     * @see NodeLogEntry#getNodeId
     */
    public long getNodeId() {
        return nodeId;
    }

    /**
     * @see INContainingEntry#getDbId()
     */
    public DatabaseId getDbId() {

        return dbId;
    }

    /**
     * @return the LSN that represents this IN. For a vanilla IN entry, it's
     * the last lsn read by the log reader.
     */
    public long getLsnOfIN(long lastReadLsn) {
        return lastReadLsn;
    }

    /**
     * @see LogEntry#logicalEquals
     *
     * INs from two different environments are never considered equal,
     * because they have lsns that are environment-specific.
     */
    public boolean logicalEquals(@SuppressWarnings("unused") LogEntry other) {
        return false;
    }
}
