/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.txn.Locker;

/**
 * Thrown when a lock has been "stolen", or preempted, from a transaction in a
 * replicated environment.
 *
 * <p>The {@link com.sleepycat.je.Transaction} handle is invalidated as a
 * result of this exception.</p>
 * 
 * <p>Locks may be preempted in a JE HA environment on a Replica system when
 * the HA write operation needs a lock that an application reader transaction
 * or cursor holds.  This exception is thrown by a reader transaction or cursor
 * method that is called after a lock has been preempted.</p>
 *
 * <p>Normally, applications should catch the base class {@link
 * LockConflictException} rather than catching one of its subclasses.  All lock
 * conflicts are typically handled in the same way, which is normally to abort
 * and retry the transaction.  See {@link LockConflictException} for more
 * information.</p>
 *
 * @since 4.0
 */
public class LockPreemptedException extends LockConflictException {

    private static final long serialVersionUID = 1;

    /** 
     * For internal use only.
     * @hidden 
     */
    public LockPreemptedException(Locker locker, Throwable cause) {
        super(locker, "Lock was preempted by a replication stream replay " +
              "write operation", cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    private LockPreemptedException(String message,
                                   LockPreemptedException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public LockPreemptedException wrapSelf(String msg) {
        return new LockPreemptedException(msg, this);
    }
}
