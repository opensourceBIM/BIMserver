/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.utilint.DbLsn;

/**
 * SearchFileReader searches for the a given entry type.
 */
public class SearchFileReader extends FileReader {

    private LogEntryType targetType;
    private LogEntry logEntry;

    /**
     * Create this reader to start at a given LSN.
     */
    public SearchFileReader(EnvironmentImpl env,
                            int readBufferSize,
                            boolean forward,
                            long startLsn,
                            long endOfFileLsn,
                            LogEntryType targetType)
        throws DatabaseException {

        super(env, readBufferSize, forward, startLsn, null,
              endOfFileLsn, DbLsn.NULL_LSN);

        this.targetType = targetType;
        logEntry = targetType.getNewLogEntry();
    }

    /**
     * @return true if this is a targeted entry.
     */
    @Override
    protected boolean isTargetEntry() {
        return (targetType.equalsType(currentEntryHeader.getType()));
    }

    /**
     * This reader instantiate the first object of a given log entry.
     */
    protected boolean processEntry(ByteBuffer entryBuffer)
        throws DatabaseException {

        logEntry.readEntry
            (currentEntryHeader, entryBuffer, true); // readFullItem
        return true;
    }

    /**
     * @return the last object read.
     */
    public Object getLastObject() {
        return logEntry.getMainItem();
    }
}
