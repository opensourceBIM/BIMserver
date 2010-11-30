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
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.txn.Txn;

/**
 * DupDeletedLNEntry encapsulates a deleted dupe LN entry. This contains all
 * the regular transactional LN log entry fields and an extra key, which is the
 * nulled out data field of the LN (which becomes the key in the duplicate
 * tree.
 */
public class DeletedDupLNLogEntry extends LNLogEntry {

    /*
     * Deleted duplicate LN must log an entra key in their log entries,
     * because the data field that is the "key" in a dup tree has been
     * nulled out because the LN is deleted.
     */
    private byte[] dataAsKey;

    /**
     * Constructor to read an entry.
     */
    public DeletedDupLNLogEntry() {
        super(com.sleepycat.je.tree.LN.class);
    }

    /**
     * Constructor to make an object that can write this entry.
     */
    public DeletedDupLNLogEntry(LogEntryType entryType,
                                LN ln,
                                DatabaseId dbId,
                                byte[] key,
                                byte[] dataAsKey,
                                long abortLsn,
                                boolean abortKnownDeleted,
                                Txn txn) {
        super(entryType, ln, dbId, key, abortLsn, abortKnownDeleted, txn);
        this.dataAsKey = dataAsKey;
    }

    /**
     * Extends its super class to read in the extra dup key.
     * @see LNLogEntry#readEntry
     */
    @Override
    public void readEntry(LogEntryHeader header,
                          ByteBuffer entryBuffer,
                          boolean readFullItem)
        throws DatabaseException {

        super.readEntry(header, entryBuffer, readFullItem);

        /* Key */
        if (readFullItem) {
            int logVersion = header.getVersion();
            dataAsKey = LogUtils.readByteArray(entryBuffer, (logVersion < 6));
        } else {
            /* The LNLogEntry base class has already positioned to the end. */
            dataAsKey = null;
        }
    }

    /**
     * Extends super class to dump out extra key.
     * @see LNLogEntry#dumpEntry
     */
    @Override
    public StringBuilder dumpEntry(StringBuilder sb, boolean verbose) {
        super.dumpEntry(sb, verbose);
        sb.append(Key.dumpString(dataAsKey, 0));
        return sb;
    }

    /*
     * Writing support
     */

    /**
     * Extend super class to add in extra key.
     * @see LNLogEntry#getSize
     */
    @Override
    public int getSize() {
        return super.getSize() +
            LogUtils.getByteArrayLogSize(dataAsKey);
    }

    /**
     * @see LogEntry#writeToLog
     */
    @Override
    public void writeEntry(LogEntryHeader header,
                           ByteBuffer destBuffer) {
        super.writeEntry(header, destBuffer);
        LogUtils.writeByteArray(destBuffer, dataAsKey);
    }

    /*
     * Accessors
     */

    /**
     * Get the data-as-key out of the entry.
     */
    @Override
    public byte[] getDupKey() {
        return dataAsKey;
    }
}
