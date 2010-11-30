/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.txn.Locker;

/**
 * Thrown if an attempt is made to use a {@link Transaction} after it has been
 * invalidated as the result of an XA failure.  The invalidation occurs when
 * {@code XAResource.end} is called by the resource manager with a {@code
 * XAResource.TMFAIL} flag.
 *
 * <p>The {@link Transaction} handle is invalidated as a result of this
 * exception.</p>
 *
 * @since 4.0
 */
public class XAFailureException extends OperationFailureException {

    private static final long serialVersionUID = 1;

    /** 
     * For internal use only.
     * @hidden 
     */
    public XAFailureException(Locker locker) {
        super(locker, true /*abortOnly*/,
              "The TM_FAIL flag was passed to XAEnvironment.end().",
              null /*cause*/);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    private XAFailureException(String message,
                               XAFailureException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new XAFailureException(msg, this);
    }
}
