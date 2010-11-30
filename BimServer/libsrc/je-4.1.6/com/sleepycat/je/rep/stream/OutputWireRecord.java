/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.stream;

import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogItem;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.log.entry.NodeLogEntry;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.txn.TxnEnd;
import com.sleepycat.je.utilint.VLSN;

/**
 * Format for log entries sent across the wire for replication. In most
 * cases, the bytes are read directly from the log and never need to be
 * serialized into the backing object.
 *
 * Note that the ByteBuffer held within the OutputWireRecord has a limited
 * lifetime. Often it's just sliced, rather than copied from the underlying
 * buffer.
 */
public class OutputWireRecord extends WireRecord {

    protected final ByteBuffer entryBuffer;

    /**
     * Make a OutputWireRecord from FileReader output for sending out.
     */
    OutputWireRecord(LogEntryHeader header, ByteBuffer readerBuffer) {
        this.header = header;
        this.entryBuffer = readerBuffer.slice();
        this.entryBuffer.limit(header.getItemSize());
    }

    /**
     * Creates an OutputWireRecord from a log item. This constructor is used
     * when a Feeder can bypass access to the log because the log item is
     * available in the log item cache associated with the VLSNIndex.
     */
    OutputWireRecord(LogItem logItem) {
        header = logItem.getHeader();
        ByteBuffer buffer = logItem.getBuffer();
        buffer.position(header.getSize());
        entryBuffer = buffer.slice();
        assert entryBuffer.limit() == header.getItemSize() :
            "Limit:" + entryBuffer.limit() + " size:" + header.getItemSize();
    }

    /* For unit test support. */
    OutputWireRecord(InputWireRecord input) {
        this.header = input.header;
        LogEntry entry = input.getLogEntry();
        this.entryBuffer = ByteBuffer.allocate(entry.getSize());
        entry.writeEntry(header, entryBuffer);
        entryBuffer.flip();
    }

    /**
     * @return the log entry type for this record.
     */
    public byte getEntryType() {
        return header.getType();
    }

    /**
     * Used at syncup, when comparing records received from the feeder against
     * local records.
     *
     * @return true if this OutputWireRecord has the same logical contents as
     * the InputWireRecord.  The comparison will disregard portions of the
     * logEntry that may be different, such at timestamps on a Commit
     * entry. Must be called before the entryBuffer that backs this
     * OutputWireRecord is reused.
     * @throws DatabaseException
     */
    public boolean match(InputWireRecord input)
        throws DatabaseException {

        /*
         * Ignore the log version check if the log versions on the feeder and
         * replica don't match. This would happen if the group is doing an 
         * upgrade that requires a log version change. 
         */
        if (!header.logicalEqualsIgnoreVersion(input.header)) {
            return false;
        }

        LogEntry entry = instantiateEntry(entryBuffer);
        return entry.logicalEquals(input.getLogEntry());
    }

    /**
     * For unit tests.
     * @return true if this OutputWireRecord has the same logical contents as
     * "other".
     * @throws DatabaseException
     */
    public boolean match(OutputWireRecord otherRecord)
        throws DatabaseException {

        if (!header.logicalEqualsIgnoreVersion(otherRecord.header)) {
            return false;
        }

        LogEntry entry = instantiateEntry(entryBuffer);
        LogEntry otherEntry =
            otherRecord.instantiateEntry(otherRecord.entryBuffer);
        return entry.logicalEquals(otherEntry);
    }

    public VLSN getVLSN() {
        return header.getVLSN();
    }

    /**
     * Dump the contents.
     * @throws DatabaseException
     */
    public String dump()
        throws DatabaseException {

        StringBuilder sb = new StringBuilder();
        header.dumpRep(sb);
        LogEntry logEntry = instantiateEntry(entryBuffer);
        logEntry.dumpRep(sb);
        return sb.toString();
    }

    @Override
    public String toString() {
        try {
           return dump();
        } catch (DatabaseException e) {
           e.printStackTrace();
           return "";
        }
    }

    /**
     * Support for reading and writing FeedRecords to network.
     */
    int getWireSize() {
        return 1 + 4 + 4 + VLSN.LOG_SIZE +
            entryBuffer.limit() - entryBuffer.position();
    }

    void writeToWire(ByteBuffer messageBuffer) {
        messageBuffer.put(header.getType());
        LogUtils.writeInt(messageBuffer, header.getVersion());
        LogUtils.writeInt(messageBuffer, header.getItemSize());
        LogUtils.writeLong(messageBuffer, header.getVLSN().getSequence());
        entryBuffer.mark();
        messageBuffer.put(entryBuffer);
        entryBuffer.reset();
    }

    /*
     * Returns the transaction id associated with a commit log entry.
     * @return the transaction id, if it's a commit record, zero otherwise.
     */
    public long getCommitTxnId()
        throws DatabaseException {

        if (!LogEntryType.LOG_TXN_COMMIT.equalsType(header.getType())) {
            return 0;
        }

        LogEntry commitEntry = instantiateEntry(entryBuffer);
        return commitEntry.getTransactionId();
    }

    /*
     * Returns the timestamp associated with the entry that we sync'ed on.
     */
    public long getTimeStamp()
        throws DatabaseException {

        LogEntry txnEndEntry = instantiateEntry(entryBuffer);
        if (txnEndEntry instanceof TxnEnd) {
            return ((TxnEnd) txnEndEntry.getMainItem()).getTime().getTime();
        }
        return 0L;
    }

    /*
     * Unit test and assertion support: Transaction, database and node ids in
     * the replication sequences are supposed to occupy the negative
     * numberspace.
     *
     * It seems a little fragile to test this here, using instanceof to decide
     * what to test. It would be cleaner to put this validity check as part of
     * the implementation of a log entry. But this is a HA related check, and
     * we want to keep the core code as independent as possible. The check is
     * here rather than in some other test code because it needs to access the
     * deserialized log entry. We don't want to provide a method which returns
     * a logEntry, because in general an OutputWireRecord should not
     * instantiate the log entry.
     *
     * @throws RuntimeException if there are any sequences that are not
     * negative.
     */
    public boolean verifyNegativeSequences(String debugTag) {

        LogEntry entry = null;
        try {
            entry = instantiateEntry(entryBuffer);
        } catch (DatabaseException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }

        if (entry.getTransactionId() >= 0) {
            throw EnvironmentFailureException.unexpectedState
                (debugTag + " txn id should be negative: " + entry);
        }

        if (entry instanceof LNLogEntry) {
            NodeLogEntry n = (NodeLogEntry) entry;
            if (n.getNodeId() >= 0) {
                throw EnvironmentFailureException.unexpectedState
                    (debugTag + " node id should be negative: " + entry);
            }

            if (LogEntryType.LOG_NAMELN_TRANSACTIONAL.equalsType
                (getEntryType())) {
                NameLN nameLN = (NameLN) ((LNLogEntry) entry).getLN();
                if (nameLN.getId().getId() >= 0) {
                    throw EnvironmentFailureException.unexpectedState
                        (debugTag + " db id should be negative: " + entry);
                }
            } else {
                if (n.getDbId().getId() >= 0) {
                    throw EnvironmentFailureException.unexpectedState
                        (debugTag + " db id should be negative: " + entry);
                }
            }
        }

        return true;
    }
}
