/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

/**
 * Error to indicate that a bottom level BIN has cursors on it during a
 * delete subtree operation.
 */
public class CursorsExistException extends Exception {

    private static final long serialVersionUID = 1051296202L;

    /*
     * Throw this static instance, in order to reduce the cost of
     * fill in the stack trace.
     */
    public static final CursorsExistException CURSORS_EXIST =
        new CursorsExistException();

    /* Make the constructor public for serializability testing. */
    public CursorsExistException() {
    }
}
