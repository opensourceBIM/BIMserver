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
 * The LatchedLogManager uses the latches to implement critical sections.
 */
public class LatchedLogManager extends LogManager {

    /**
     * There is a single log manager per database environment.
     */
    public LatchedLogManager(EnvironmentImpl envImpl,
                             boolean readOnly)
        throws DatabaseException {

        super(envImpl, readOnly);
    }

    private boolean acquireLogWriteLatch()
        throws DatabaseException {

        if (logWriteLatch.isOwner()) {
            return false;
        }
        logWriteLatch.acquire();
        return true;
    }

    void serialLog(LogItem[] itemArray, LogContext context)
        throws IOException, DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            serialLogInternal(itemArray, context);
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }

    protected void flushInternal()
        throws DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            logBufferPool.writeBufferToFile(0, false /* flushRequired */);
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }

    /**
     * @see LogManager#getUnflusableTrackedSummary
     */
    public TrackedFileSummary getUnflushableTrackedSummary(long file)
        throws DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            return getUnflushableTrackedSummaryInternal(file);
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }

    /**
     * @see LogManager#removeTrackedFile
     */
    public void removeTrackedFile(TrackedFileSummary tfs)
        throws DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            removeTrackedFileInternal(tfs);
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }

    /**
     * @see LogManager#countObsoleteNode
     */
    public void countObsoleteNode(long lsn,
                                  LogEntryType type,
                                  int size,
                                  DatabaseImpl nodeDb,
                                  boolean countExact)
        throws DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            countObsoleteNodeInternal(lsn, type, size, nodeDb, countExact);
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }

    /**
     * @see LogManager#countObsoleteNodeDupsAllowed
     */
    public void countObsoleteNodeDupsAllowed(long lsn,
                                             LogEntryType type,
                                             int size,
                                             DatabaseImpl nodeDb)
        throws DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            countObsoleteNodeDupsAllowedInternal(lsn, type, size, nodeDb);
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }

    /**
     * @see LogManager#transferToUtilizationTracker
     */
    public void transferToUtilizationTracker(LocalUtilizationTracker
                                             localTracker)
        throws DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            transferToUtilizationTrackerInternal(localTracker);
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }

    /**
     * @see LogManager#countObsoleteDb
     */
    public void countObsoleteDb(DatabaseImpl db)
        throws DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            countObsoleteDbInternal(db);
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }

    /**
     * @see LogManager#removeDbFileSummary
     */
    public boolean removeDbFileSummary(DatabaseImpl db, Long fileNum)
        throws DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            return removeDbFileSummaryInternal(db, fileNum);
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }

    /**
     * @see LogManager#loadEndOfLogStat
     */
    @Override
    public void loadEndOfLogStat()
        throws DatabaseException {

        boolean releaseLogWriteLatch = acquireLogWriteLatch();
        try {
            loadEndOfLogStatInternal();
        } finally {
            if (releaseLogWriteLatch) {
                logWriteLatch.release();
            }
        }
    }
}
