/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * This base class of {@link EnvironmentFailureException} is deprecated but
 * exists for API backward compatibility.
 *
 * <p>Prior to JE 4.0, {@code RunRecoveryException} is thrown to indicate that
 * the JE environment is invalid and cannot continue on safely.  Applications
 * catching {@code RunRecoveryException} prior to JE 4.0 were required to close
 * and re-open the {@code Environment}.</p>
 *
 * <p>When using JE 4.0 or later, the application should catch {@link
 * EnvironmentFailureException}. The application should then call {@link
 * Environment#isValid} to determine whether the {@code Environment} must be
 * closed and re-opened, or can continue operating without being closed.  See
 * {@link EnvironmentFailureException}.</p>
 *
 * @deprecated replaced by {@link EnvironmentFailureException} and {@link
 * Environment#isValid}.
 */
public abstract class RunRecoveryException extends DatabaseException {

    private static final long serialVersionUID = 1913208269L;

    /** 
     * For internal use only.
     * @hidden 
     */
    public RunRecoveryException(String message) {
        super(message);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    public RunRecoveryException(String message, Throwable e) {
        super(message, e);
    }
}
