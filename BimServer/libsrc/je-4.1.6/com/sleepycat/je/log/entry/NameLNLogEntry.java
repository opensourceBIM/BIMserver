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
import com.sleepycat.je.dbi.ReplicatedDatabaseConfig;
import com.sleepycat.je.log.DbOpReplicationContext;
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.txn.Txn;

/**
 * NameLNLogEntry contains all the regular LNLogEntry fields and additional
 * information about the database operation which instigated the logging of
 * this NameLN. This additional information is used to support replication of
 * database operations in a replication group.
 *
 * Database operations pose a special problem for replication because unlike
 * data record put and get calls, they can result in multiple log entries that
 * are not all members of a single transaction.  Create and truncate are the
 * problem operations because they end up logging new MapLNs, and our
 * implementation does not treat MapLNs as transactional.  Database operations
 * challenge two replication assumptions: (a) that all logical operations can
 * be repeated on the client node based on the contents of a single log entry,
 * and (b) that non-txnal log entries like MapLNs need not be replicated.
 *
 * Specifically, here's what is logged for database operations.
 *
 * create:
 *
 *  1. new NameLN_TX
 *  2. new MapLN, which has the database config info.
 *  3. txn commit of autocommit or user txn.
 *
 * rename:
 *
 *  1. deleted NameLN_TX
 *  2. new NameLN_TX
 *  3. txn commit from autocommit or user txn
 *
 * truncate:
 *
 *  1. new MapLN w/new id
 *  2. modify the existing NameLN with new id (old database is deleted by
 *     usual commit-time processing)
 *  3. txn commit from autocommit or user txn
 *
 * delete
 *
 *  1. deleted NameLN_TX (old database gets deleted by usual commit-time
 *     processing)
 *  2. txn commit from autocommit or user txn
 *
 * Extra information is needed for create and truncate, which both log
 * information within the MapLN. Rename and delete only log NameLNs, so they
 * can be replicated on the client using the normal replication messages.  The
 * extra fields which follow the usual LNLogEntry fields are:
 *
 * operationType - the type of database operation. In a single node system,
 *                 this is local information implicit in the code path.
 * databaseConfig (optional) - For creates, database configuration info
 * databaseId (optional)- For truncates, the old db id, so we know which
 *                        MapLN to delete.
 */
public class NameLNLogEntry extends LNLogEntry {

    /*
     * operationType, truncateOldDbId and replicatedCreateConfig are
     * logged as part of the entry.
     */
    private DbOperationType operationType;
    private DatabaseId truncateOldDbId;
    private ReplicatedDatabaseConfig replicatedCreateConfig;

    /**
     * Constructor to read an entry.
     */
    public NameLNLogEntry() {
        super(com.sleepycat.je.tree.NameLN.class);
    }

    /**
     * Constructor to write this entry.
     */
    public NameLNLogEntry(LogEntryType entryType,
                          NameLN nameLN,
                          DatabaseId dbId,
                          byte[] key,
                          long abortLsn,
                          boolean abortKnownDeleted,
                          Txn txn,
                          ReplicationContext repContext) {

        super(entryType, nameLN, dbId, key, abortLsn, abortKnownDeleted, txn);
        ReplicationContext operationContext = repContext;

        operationType = repContext.getDbOperationType();
        if (operationType == DbOperationType.CREATE) {
            replicatedCreateConfig =
                ((DbOpReplicationContext) operationContext).getCreateConfig();
        } else if (operationType == DbOperationType.TRUNCATE) {
            truncateOldDbId =
              ((DbOpReplicationContext) operationContext).getTruncateOldDbId();
        }
    }

    /**
     * Extends its super class to read in database operation information.
     * @see LNLogEntry#readEntry
     */
    @Override
    public void readEntry(LogEntryHeader header,
                          ByteBuffer entryBuffer,
                          boolean readFullItem)
        throws DatabaseException {

        super.readEntry(header, entryBuffer, readFullItem);

        /*
         * The NameLNLogEntry was introduced in version 6. Before, a LNLogEntry
         * was used for NameLNs, and there is no extra information in the log
         * entry.
         */
        int version = header.getVersion();
        if (version >= 6) {
            if (readFullItem) {
                operationType = DbOperationType.readTypeFromLog(entryBuffer,
                                                                version);
                if (operationType == DbOperationType.CREATE) {
                    replicatedCreateConfig = new ReplicatedDatabaseConfig();
                    replicatedCreateConfig.readFromLog(entryBuffer, version);
                } else if (operationType == DbOperationType.TRUNCATE) {
                    truncateOldDbId = new DatabaseId();
                    truncateOldDbId.readFromLog(entryBuffer, version);
                }
            }

            /*
             * If readFullItem is false, the LNLogEntry base class has already
             * positioned to the end, so nothing more to do.
             */
        } else {
            operationType = DbOperationType.NONE;
        }
    }

    /**
     * Extends its super class to dump database operation information.
     * @see LNLogEntry#dumpEntry
     */
    @Override
    public StringBuilder dumpEntry(StringBuilder sb, boolean verbose) {

        super.dumpEntry(sb, verbose);

        operationType.dumpLog(sb, verbose);
        if (replicatedCreateConfig != null ) {
            replicatedCreateConfig.dumpLog(sb, verbose);
        }
        if (truncateOldDbId != null) {
            truncateOldDbId.dumpLog(sb, verbose);
        }

        return sb;
    }

    /**
     * Extends its super class to add in database operation information.
     * @see LNLogEntry#getSize
     */
    @Override
    public int getSize() {
        int size = super.getSize() + operationType.getLogSize();

        if (operationType == DbOperationType.CREATE) {
            size += replicatedCreateConfig.getLogSize();
        }
        if (operationType == DbOperationType.TRUNCATE) {
            size += truncateOldDbId.getLogSize();
        }
        return size;
    }

    /**
     * Extends its super class to add in database operation information.
     * @see LogEntry#writeToLog
     */
    @Override
    public void writeEntry(LogEntryHeader header, ByteBuffer destBuffer) {

        super.writeEntry(header, destBuffer);

        operationType.writeToLog(destBuffer);
        if (operationType == DbOperationType.CREATE) {
            replicatedCreateConfig.writeToLog(destBuffer);
        } else if (operationType == DbOperationType.TRUNCATE) {
            truncateOldDbId.writeToLog(destBuffer);
        }
    }

    /**
     * @see LogEntry#logicalEquals
     */
    @Override
    public boolean logicalEquals(LogEntry other) {

        if (!super.logicalEquals(other))
            return false;

        NameLNLogEntry otherEntry = (NameLNLogEntry) other;
        if (!operationType.logicalEquals(otherEntry.operationType)) {
            return false;
        }

        if ((truncateOldDbId != null) &&
            (!truncateOldDbId.logicalEquals(otherEntry.truncateOldDbId))) {
                return false;
        }

        if (replicatedCreateConfig != null) {
            if (!replicatedCreateConfig.logicalEquals
                (otherEntry.replicatedCreateConfig))
                return false;
        }
        return true;
    }

    /**
     * @return the operationType
     */
    public DbOperationType getOperationType() {
        return operationType;
    }

    /**
     * @return the replicatedCreateConfig
     */
    public ReplicatedDatabaseConfig getReplicatedCreateConfig() {
        return replicatedCreateConfig;
    }

    /**
     * @return the truncateOldDbId
     */
    public DatabaseId getTruncateOldDbId() {
        return truncateOldDbId;
    }

    /**
     * @see LogEntry#dumpRep
     */
    public void dumpRep(StringBuilder sb) {
        super.dumpRep(sb);
        sb.append(" dbop=").append(operationType);
    }
}
