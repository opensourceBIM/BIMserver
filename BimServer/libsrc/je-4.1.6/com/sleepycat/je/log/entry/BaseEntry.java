/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log.entry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.log.LogEntryType;

/**
 * A Log entry allows you to read, write and dump a database log entry.  Each
 * entry may be made up of one or more loggable items.
 *
 * The log entry on disk consists of
 *  a. a log header defined by LogManager
 *  b. a VLSN, if this entry type requires it, and replication is on.
 *  c. the specific contents of the log entry.
 *
 * This class encompasses (b & c).
 */
abstract class BaseEntry {

    /*
     * These fields are transient and are not persisted to the log
     */

    /*
     * Constructor used to create log entries when reading.
     */
    final private Constructor<?> noargsConstructor;

    /*
     * Attributes of the entry type may be used to conditionalizing the reading
     * and writing of the entry.
     */
    LogEntryType entryType;

    /**
     * Constructor to read an entry. The logEntryType must be set later,
     * through setLogType().
     */
    BaseEntry(Class<?> logClass) {
        try {
            noargsConstructor = logClass.getConstructor((Class<?>[]) null);
        } catch (SecurityException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        } catch (NoSuchMethodException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
    }

    /**
     * @return a new instance of the class used to create the log entry.
     */
    Object newInstanceOfType() {
        try {
            return noargsConstructor.newInstance((Object[]) null);
        } catch (IllegalAccessException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        } catch (InstantiationException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        } catch (IllegalArgumentException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        } catch (InvocationTargetException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
    }

    /**
     * Constructor to write an entry.
     */
    BaseEntry() {
        noargsConstructor = null;
    }

    /**
     * Inform a BaseEntry instance of its corresponding LogEntryType.
     */
    public void setLogType(LogEntryType entryType) {
        this.entryType = entryType;
    }

    /**
     * @return the type of log entry
     */
    public LogEntryType getLogType() {
        return entryType;
    }

    /**
     * By default, return zero because the last logged size is unknown.  This
     * method is overridden by LNLogEntry.
     */
    public int getLastLoggedSize() {
        return 0;
    }

    /**
     * Returns true if this item should be counted as obsoleted when logged.
     * This currently applies to deleted LNs only.
     */
    public boolean isDeleted() {
        return false;
    }

    /**
     * Do any processing we need to do after logging, while under the logging
     * latch.
     * @throws DatabaseException from subclasses.
     */
    public void postLogWork(@SuppressWarnings("unused") long justLoggedLsn)
        throws DatabaseException {

        /* by default, do nothing. */
    }

    public abstract StringBuilder dumpEntry(StringBuilder sb, boolean verbose);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        dumpEntry(sb, true);
        return sb.toString();
    }
}
