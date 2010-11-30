/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.txn.Locker;

/**
 * Thrown when a non-blocking operation fails to get a lock.  Non-blocking
 * transactions are configured using {@link TransactionConfig#setNoWait}.
 *
 * <p>The {@link Transaction} handle is <em>not</em> invalidated as a result of
 * this exception.</p>
 *
 * <p>For compatibility with prior releases, {@link LockNotGrantedException} is
 * thrown instead of {@link LockNotAvailableException} when {@link
 * EnvironmentConfig#LOCK_OLD_LOCK_EXCEPTIONS} is set to true.  This
 * configuration parameter is false by default.  See {@link
 * EnvironmentConfig#LOCK_OLD_LOCK_EXCEPTIONS} for information on the changes
 * that should be made to all JE applications.</p>
 *
 * <p>Normally, applications should catch the base class {@link
 * LockConflictException} rather than catching one of its subclasses.  All lock
 * conflicts are typically handled in the same way, which is normally to abort
 * and retry the transaction.  See {@link LockConflictException} for more
 * information.</p>
 *
 * @since 4.0
 */
public class LockNotAvailableException extends LockConflictException {

    private static final long serialVersionUID = 1;

    /** 
     * For internal use only.
     * @hidden 
     */
    public LockNotAvailableException(Locker locker, String message) {
        /* Do not set abort-only for a no-wait lock failure. */
        super(message);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    private LockNotAvailableException(String message,
                                      LockNotAvailableException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new LockNotAvailableException(msg, this);
    }
}
