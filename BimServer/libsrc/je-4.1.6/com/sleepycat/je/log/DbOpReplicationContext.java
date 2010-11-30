/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.ReplicatedDatabaseConfig;
import com.sleepycat.je.log.entry.DbOperationType;
import com.sleepycat.je.log.entry.NameLNLogEntry;
import com.sleepycat.je.utilint.VLSN;

/**
 * This subclass of ReplicationContext adds information specific to database
 * operations to the replication context passed from operation-aware code down
 * the the logging layer. It's a way to transport enough information though the
 * NameLNLogEntry to logically replicate database operations.
 */
public class DbOpReplicationContext extends ReplicationContext {

    /*
     * Convenience static instance used when you know this database operation
     * will not be replicated, either because it's executing on a
     * non-replicated node or it's a local operation for a local database.
     */
    public static DbOpReplicationContext NO_REPLICATE =
        new DbOpReplicationContext(false, // inReplicationStream
                                   DbOperationType.NONE);

    final private DbOperationType opType;
    private ReplicatedDatabaseConfig createConfig = null;
    private DatabaseId truncateOldDbId = null;

    /**
     * Create a replication context for logging a database operation NameLN on
     * the master.
     */
    public DbOpReplicationContext(boolean inReplicationStream,
                                  DbOperationType opType) {
        super(inReplicationStream);
        this.opType = opType;
    }

    /**
     * Create a repContext for executing a databaseOperation on the client.
     */
    public DbOpReplicationContext(VLSN vlsn,
                                  NameLNLogEntry nameLNEntry) {

        /*
         * Initialize the context with the VLSN that was shipped with the
         * replicated log entry.
         */

        super(vlsn);
        opType = nameLNEntry.getOperationType();

        if (opType == DbOperationType.CREATE) {
            createConfig = nameLNEntry.getReplicatedCreateConfig();
        } else if (opType == DbOperationType.TRUNCATE) {
            truncateOldDbId = nameLNEntry.getTruncateOldDbId();
        }
    }

    @Override
    public DbOperationType getDbOperationType() {
        return opType;
    }

    public void setCreateConfig(ReplicatedDatabaseConfig createConfig) {
        assert(opType == DbOperationType.CREATE);
            this.createConfig = createConfig;
    }

    public ReplicatedDatabaseConfig getCreateConfig() {
        assert(opType == DbOperationType.CREATE);
        return createConfig;
    }

    public void setTruncateOldDbId(DatabaseId truncateOldDbId) {
        assert(opType == DbOperationType.TRUNCATE);
        this.truncateOldDbId = truncateOldDbId;
    }

    public DatabaseId getTruncateOldDbId() {
        assert(opType == DbOperationType.TRUNCATE);
        return truncateOldDbId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("opType=").append(opType);
        sb.append("truncDbId=").append(truncateOldDbId);
        return sb.toString();
    }
}
