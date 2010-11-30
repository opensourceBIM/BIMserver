/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

/**
 * Indicates that a checksum validation failed.  A checked exception is used so
 * it can be caught and handled internally in some cases.  When not handled
 * internally, it is wrapped with an EnvironmentFailureException with
 * EnvironmentFailureReason.LOG_CHECKSUM before being propagated through the
 * public API.
 */
public class ChecksumException extends Exception {

    private static final long serialVersionUID = 1;

    public ChecksumException(String message) {
        super(message);
    }

    public ChecksumException(String message, Exception e) {
        super(message, e);
    }
}
