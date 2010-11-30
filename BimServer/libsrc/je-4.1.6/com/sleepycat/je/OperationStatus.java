/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * Status values from database operations.
 */
public enum OperationStatus {

    /**
     * The operation was successful.
     */
    SUCCESS,

    /**
     * The operation to insert data was configured to not allow overwrite and
     * the key already exists in the database.
     */
    KEYEXIST,

    /**
     * The cursor operation was unsuccessful because the current record was
     * deleted. This can only occur if a Cursor is positioned to an existing
     * record, then the record is deleted, and then the getCurrent, putCurrent,
     * or delete methods is called.
     */
    KEYEMPTY,

    /**
     * The requested key/data pair was not found.
     */
    NOTFOUND;

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "OperationStatus." + name();
    }
}
