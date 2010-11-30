/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * RestartRequiredException serves as the base class for all exceptions which
 * makes it impossible for HA to proceed without some form of corrective action
 * on the part of the user, followed by a restart of the application. The
 * corrective action may involve an increase in resources used by the
 * application, a JE configurations change, discarding cached state, etc. The
 * error message details the nature of the problem.
 */
public abstract class RestartRequiredException 
    extends EnvironmentFailureException {

    private static final long serialVersionUID = 1;

    public RestartRequiredException(EnvironmentImpl envImpl,
                                    EnvironmentFailureReason reason) {
        super(envImpl, reason);
    }

    public RestartRequiredException(EnvironmentImpl envImpl,
                                    EnvironmentFailureReason reason,
                                    Exception cause) {
        super(envImpl, reason, cause);
    }

    /**
     * For internal use only.
     */
    protected RestartRequiredException(String message,
                                       RestartRequiredException cause) {
        super(message, cause);
    }

    /**
     * For internal use only.
     * @hidden
     */
    @Override
    public abstract EnvironmentFailureException wrapSelf(String msg) ;
}
