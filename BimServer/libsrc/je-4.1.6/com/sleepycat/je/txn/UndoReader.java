/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import java.util.Map;

import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LNFileReader;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.tree.LN;

/**
 * Convenience class to package together the different steps and fields needed
 * for reading a log entry for undoing. Is used for both txn aborts and 
 * recovery undos.
 */
public class UndoReader {

    public final LNLogEntry logEntry;
    public final LN ln;
    final long nodeId;
    public final DatabaseImpl db;
    private final DbTree dbMapTree;

    /* 
     * Set up an UndoReader when doing a txn partial rollback.
     */
    public UndoReader(EnvironmentImpl envImpl,
                      long undoLsn,
                      Map<DatabaseId, DatabaseImpl> undoDatabases) {

        logEntry = (LNLogEntry) envImpl.getLogManager().
            getLogEntryHandleFileNotFound(undoLsn);
        ln = logEntry.getLN();
        nodeId = ln.getNodeId();
        DatabaseId dbId = logEntry.getDbId();
        db = undoDatabases.get(dbId);
        ln.postFetchInit(db, undoLsn);
        
        /* DbImpls are obtained from the txn's cache. */
        dbMapTree = null;
    }

    /* 
     * Set up an UndoReader when doing a recovery partial rollback. In
     * that case, we have a file reader positioned at the pertinent 
     * log entry.
     */
    public UndoReader(LNFileReader reader, DbTree dbMapTree) {
        logEntry = reader.getLogEntry();
        ln = reader.getLN();
        nodeId = ln.getNodeId();
        DatabaseId dbId = logEntry.getDbId();
        this.dbMapTree = dbMapTree;
        db = dbMapTree.getDb(dbId);
        ln.postFetchInit(db, reader.getLastLsn());
    }

    public void releaseDb() {
        dbMapTree.releaseDb(db);
    }

    @Override
    public String toString() {
        return ln + " nodeId=" + nodeId;
    }
}
