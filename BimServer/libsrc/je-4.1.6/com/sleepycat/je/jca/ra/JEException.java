/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jca.ra;

public class JEException extends Exception {

    private static final long serialVersionUID = 329949514L;

    public JEException(String message) {
        super(message);
    }
}
