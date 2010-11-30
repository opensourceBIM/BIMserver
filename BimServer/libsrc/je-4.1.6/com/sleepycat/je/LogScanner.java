/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * For internal use only.
 * @hidden
 * Used with Environment.scanLog to scan raw log entries.  An instance of a
 * class that implements this interface should be passed to
 * Environment.scanLog.
 *
 * <p><em>WARNING:</em> This interface is meant for low level processing of log
 * records, not for application level queries.  See the following
 * restrictions!</p>
 *
 * <p>Please be aware that raw log entries are passed to the scanRecord method.
 * It is the responsibility of the caller to ensure that these records
 * represent valid records in a Database by performing queries such as
 * Database.get.  Be sure to take into account the following information about
 * records that are passed to the scanRecord method:</p>
 * 
 * <ul> <li>Records may be part of transactions that were aborted or never
 * committed, as well as part of committed transactions or not part of any
 * transaction (written non-transactionally).</li>
 * 
 * <li>Records may be part of the interval specified when calling scanLog
 * because they were written by the log cleaner as it migrates records forward,
 * and not written by the application itself in the specified interval.</li>
 * 
 * <li>For a given record, there may be multiple versions of the record passed
 * to scanRecord because multiple versions of that record were written to the
 * log.</li>
 * 
 * <li>For a given record, a deleted version of the record may appear before or
 * after a non-deleted version of the record.</li>
 *
 * <li>The cleaner must be disabled while this method is running.</li>
 *
 * <li>This method should only be invoked immediately after recovery and prior
 * to any updates to the Environment.</li> </ul>
 */

public interface LogScanner {

    /**
     * Called for each record scanned.
     *
     * @param key is the key entry of the record scanned.  This parameter will
     * not be null.
     *
     * @param data is the data entry of the record scanned. This parameter may
     * be null for deleted records.
     *
     * @param deleted is true if the given record is deleted at this point in
     * the log.  Note that it may also appear earlier or later in the log.
     *
     * @param databaseName the name of the database in which the record
     * appears.  Note that if the database was renamed, this is the last known
     * name of the database at the time scanLog is called.
     */
    public boolean scanRecord(DatabaseEntry key,
                              DatabaseEntry data,
                              boolean deleted,
                              String databaseName);
}
