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

/**
 * CheckpointFileReader searches for root and checkpoint entries.
 */
public class CheckpointFileReader extends FileReader {
    /* Status about the last entry. */
    private boolean isRoot;
    private boolean isCheckpointEnd;
    private boolean isCheckpointStart;

    /**
     * Create this reader to start at a given LSN.
     */
    public CheckpointFileReader(EnvironmentImpl env,
                                int readBufferSize,
                                boolean forward,
                                long startLsn,
                                long finishLsn,
                                long endOfFileLsn)
        throws DatabaseException {

        super(env, readBufferSize, forward, startLsn,
              null, endOfFileLsn, finishLsn);
    }

    /**
     * @return true if this is a targeted entry.
     */
    @Override
    protected boolean isTargetEntry() {
        byte logEntryTypeNumber = currentEntryHeader.getType();
        boolean isTarget = false;
        isRoot = false;
        isCheckpointEnd = false;
        isCheckpointStart = false;
        if (LogEntryType.LOG_CKPT_END.equalsType(logEntryTypeNumber)) {
            isTarget = true;
            isCheckpointEnd = true;
        } else if (LogEntryType.LOG_CKPT_START.equalsType
            (logEntryTypeNumber)) {
            isTarget = true;
            isCheckpointStart = true;
        } else if (LogEntryType.LOG_ROOT.equalsType(logEntryTypeNumber)) {
            isTarget = true;
            isRoot = true;
        }
        return isTarget;
    }

    /**
     * This reader instantiates the first object of a given log entry
     */
    @Override
    protected boolean processEntry(ByteBuffer entryBuffer) {
        /* Don't need to read the entry, since we just use the LSN. */
        return true;
    }

    /**
     * @return true if last entry was a root entry.
     */
    public boolean isRoot() {
        return isRoot;
    }

    /**
     * @return true if last entry was a checkpoint end entry.
     */
    public boolean isCheckpointEnd() {
        return isCheckpointEnd;
    }

    /**
     * @return true if last entry was a checkpoint start entry.
     */
    public boolean isCheckpointStart() {
        return isCheckpointStart;
    }
}
