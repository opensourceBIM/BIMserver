/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.txn.Locker;

/**
 * Implemented to receive database update notifications.
 *
 * <p>The databaseUpdated() method may perform additional database operations
 * using the transaction passed to it, or by starting a new transaction.
 * The transaction passed may not be explicitly committed or aborted.</p>
 */
interface DatabaseTrigger {

    /**
     * Notifies the trigger that it has been added and will start receiving
     * update notifications.
     *
     * @param db the database to which the trigger was added.
     */
    void triggerAdded(Database db);

    /**
     * Notifies the trigger that it has been removed and will stop receiving
     * update notifications.
     *
     * @param db the database from which the trigger was removed.
     */
    void triggerRemoved(Database db);

    /**
     * Notifies the trigger that a put or delete operation has been performed
     * on the database.
     *
     * <p>When a new entry is inserted, oldData will be null and newData will
     * be non-null.</p>
     *
     * <p>When an existing entry is updated, oldData and newData will be
     * non-null.</p>
     *
     * <p>When an existing entry is deleted, oldData will be non-null and
     * newData will be null.</p>
     *
     * @param db the database that was modified.
     *
     * @param locker the internal locker.
     *
     * @param priKey the primary key, which is never null.
     *
     * @param oldData the primary data before the change, or null if the record
     * did not previously exist.
     *
     * @param newData the primary data after the change, or null if the record
     * has been deleted.
     */
    void databaseUpdated(Database db,
                         Locker locker,
                         DatabaseEntry priKey,
                         DatabaseEntry oldData,
                         DatabaseEntry newData)
        throws DatabaseException;
}
