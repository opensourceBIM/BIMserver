/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * Thrown by {@link Environment#openDatabase Environment.openDatabase} and
 * {@link Environment#openSecondaryDatabase Environment.openSecondaryDatabase}
 * if the database already exists and the {@code DatabaseConfig
 * ExclusiveCreate} parameter is true.
 *
 * <p>The {@link Transaction} handle is <em>not</em> invalidated as a result of
 * this exception.</p>
 *
 * @since 4.0
 */
public class DatabaseExistsException extends OperationFailureException {

    private static final long serialVersionUID = 1;

    /** 
     * For internal use only.
     * @hidden 
     */
    public DatabaseExistsException(String message) {
        super(null /*locker*/, false /*abortOnly*/, message, null /*cause*/);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    private DatabaseExistsException(String message,
                                    DatabaseExistsException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new DatabaseExistsException(msg, this);
    }
}
