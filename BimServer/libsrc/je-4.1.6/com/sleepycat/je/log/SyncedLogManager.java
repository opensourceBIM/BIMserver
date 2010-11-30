/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.io.IOException;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.cleaner.LocalUtilizationTracker;
import com.sleepycat.je.cleaner.TrackedFileSummary;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * The SyncedLogManager uses the synchronized keyword to implement protected
 * regions.
 */
public class SyncedLogManager extends LogManager {

    /**
     * There is a single log manager per database environment.
     */
    public SyncedLogManager(EnvironmentImpl envImpl,
                            boolean readOnly)
        throws DatabaseException {

        super(envImpl, readOnly);
    }

    @Override
    void serialLog(LogItem[] itemArray, LogContext context)
        throws IOException, DatabaseException {

        synchronized (logWriteLatch) {
            serialLogInternal(itemArray, context);
        }
    }

    @Override
    protected void flushInternal()
        throws DatabaseException {

        synchronized (logWriteLatch) {
            logBufferPool.writeBufferToFile(0, false /* flushRequired */);
        }
    }

    /**
     * @see LogManager#getUnflushableTrackedSummary
     */
    @Override
    public TrackedFileSummary getUnflushableTrackedSummary(long file) {
        synchronized (logWriteLatch) {
            return getUnflushableTrackedSummaryInternal(file);
        }
    }

    /**
     * @see LogManager#removeTrackedFile
     */
    @Override
    public void removeTrackedFile(TrackedFileSummary tfs) {
        synchronized (logWriteLatch) {
            removeTrackedFileInternal(tfs);
        }
    }

    /**
     * @see LogManager#countObsoleteNode
     */
    @Override
    public void countObsoleteNode(long lsn,
                                  LogEntryType type,
                                  int size,
                                  DatabaseImpl nodeDb,
                                  boolean countExact) {
        synchronized (logWriteLatch) {
            countObsoleteNodeInternal(lsn, type, size, nodeDb, countExact);
        }
    }

    /**
     * @see LogManager#countObsoleteNodeDupsAllowed
     */
    @Override
    public void countObsoleteNodeDupsAllowed(long lsn,
                                             LogEntryType type,
                                             int size,
                                             DatabaseImpl nodeDb) {
        synchronized (logWriteLatch) {
            countObsoleteNodeDupsAllowedInternal(lsn, type, size, nodeDb);
        }
    }

    /**
     * @see LogManager#transferToUtilizationTracker
     */
    @Override
    public void transferToUtilizationTracker(LocalUtilizationTracker
                                             localTracker)
        throws DatabaseException {

        synchronized (logWriteLatch) {
            transferToUtilizationTrackerInternal(localTracker);
        }
    }

    /**
     * @see LogManager#countObsoleteDb
     */
    @Override
    public void countObsoleteDb(DatabaseImpl db) {
        synchronized (logWriteLatch) {
            countObsoleteDbInternal(db);
        }
    }

    /**
     * @see LogManager#removeDbFileSummary
     */
    @Override
    public boolean removeDbFileSummary(DatabaseImpl db, Long fileNum) {
        synchronized (logWriteLatch) {
            return removeDbFileSummaryInternal(db, fileNum);
        }
    }

    /**
     * @see LogManager#loadEndOfLogStat
     */
    @Override
    public void loadEndOfLogStat() {
        synchronized (logWriteLatch) {
            loadEndOfLogStatInternal();
        }
    }
}
