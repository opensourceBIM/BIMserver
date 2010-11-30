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

/**
 * The PrintFileReader prints out the target log entries.
 */
public class PrintFileReader extends DumpFileReader {

    /**
     * Create this reader to start at a given LSN.
     */
    public PrintFileReader(EnvironmentImpl env,
                           int readBufferSize,
                           long startLsn,
                           long finishLsn,
                           String entryTypes,
                           String txnIds,
                           boolean verbose,
                           boolean repEntriesOnly)
        throws DatabaseException {

        super(env,
              readBufferSize,
              startLsn,
              finishLsn,
              entryTypes,
              txnIds,
              verbose,
              repEntriesOnly);
    }

    /**
     * This reader prints the log entry item.
     */
    protected boolean processEntry(ByteBuffer entryBuffer)
        throws DatabaseException {

        /* Figure out what kind of log entry this is */
        byte curType = currentEntryHeader.getType();
        LogEntryType lastEntryType = LogEntryType.findType(curType);

        /* Print out a common header for each log item */
        StringBuilder sb = new StringBuilder();
        sb.append("<entry lsn=\"0x").append
            (Long.toHexString(window.currentFileNum()));
        sb.append("/0x").append(Long.toHexString(currentEntryOffset));
        sb.append("\" ");
        currentEntryHeader.dumpLogNoTag(sb, verbose);
        sb.append("\">");

        /* Read the entry and dump it into a string buffer. */
        LogEntry entry = lastEntryType.getSharedLogEntry();
        entry.readEntry(currentEntryHeader, entryBuffer, true); // readFullItem
        boolean dumpIt = true;
        if (targetTxnIds.size() > 0) {
            if (lastEntryType.isTransactional()) {
                if (!targetTxnIds.contains
                    (Long.valueOf(entry.getTransactionId()))) {
                    /* Not in the list of txn ids. */
                    dumpIt = false;
                }
            } else {
                /* If -tx spec'd and not a transactional entry, don't dump. */
                dumpIt = false;
            }
        }

        if (dumpIt) {
            entry.dumpEntry(sb, verbose);
            sb.append("</entry>");
            System.out.println(sb.toString());
        }

        return true;
    }
}
