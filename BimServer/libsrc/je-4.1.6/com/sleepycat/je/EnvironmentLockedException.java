/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Thrown by the {@link Environment} constructor when an environment cannot be
 * opened for write access because another process has the same environment
 * open for write access.
 *
 * <p><strong>Warning:</strong> This exception should be handled when an
 * environment is opened by more than one process.</p>
 */
public class EnvironmentLockedException extends EnvironmentFailureException {

    private static final long serialVersionUID = 629594964L;

    /** 
     * For internal use only.
     * @hidden 
     */
    public EnvironmentLockedException(EnvironmentImpl envImpl,
                                      String message) {
        super(envImpl, EnvironmentFailureReason.ENV_LOCKED, message);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    private EnvironmentLockedException(String message,
                                       EnvironmentLockedException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public EnvironmentFailureException wrapSelf(String msg) {
        return new EnvironmentLockedException(msg, this);
    }
}
