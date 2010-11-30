/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;


/*
 * Singleton class to indicate that something needs to be relatched for
 * exclusive access due to a fetch occurring.
 */
@SuppressWarnings("serial")
public class RelatchRequiredException extends Exception {
    public static RelatchRequiredException relatchRequiredException =
        new RelatchRequiredException();

    private RelatchRequiredException() {
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
