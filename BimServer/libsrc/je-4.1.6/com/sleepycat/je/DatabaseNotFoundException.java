/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * Thrown when an operation requires a database and that database does not
 * exist.
 *
 * <p>The {@link Transaction} handle is <em>not</em> invalidated as a result of
 * this exception.</p>
 */
public class DatabaseNotFoundException extends OperationFailureException {

    private static final long serialVersionUID = 1895430616L;

    /** 
     * For internal use only.
     * @hidden 
     */
    public DatabaseNotFoundException(String message) {
        super(null /*locker*/, false /*abortOnly*/, message, null /*cause*/);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    private DatabaseNotFoundException(String message,
                                      DatabaseNotFoundException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new DatabaseNotFoundException(msg, this);
    }
}
