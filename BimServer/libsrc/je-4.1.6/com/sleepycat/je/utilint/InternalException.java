/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;


/**
 * Some internal inconsistency exception.
 */
public class InternalException extends RuntimeException {

    private static final long serialVersionUID = 1584673689L;

    public InternalException() {
        super();
    }

    public InternalException(String message) {
        super(message);
    }
}
