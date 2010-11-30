/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

/**
 * LockConflict is a type safe enumeration of lock conflict types.  Methods on
 * LockConflict objects are used to determine whether a conflict exists and, if
 * so, how it should be handled.
 */
class LockConflict {

    static final LockConflict ALLOW   = new LockConflict(true, false);
    static final LockConflict BLOCK   = new LockConflict(false, false);
    static final LockConflict RESTART = new LockConflict(false, true);

    private boolean allowed;
    private boolean restart;

    /**
     * No conflict types can be defined outside this class.
     */
    private LockConflict(boolean allowed, boolean restart) {
        this.allowed = allowed;
        this.restart= restart;
    }

    /**
     * This method is called first to determine whether the locks is allowed.
     * If true, there is no conflict.  If false, there is a conflict and the
     * requester must wait for or be denied the lock, or (if getRestart returns
     * true) an exception should be thrown to cause the requester's operation
     * to be restarted.
     */
    boolean getAllowed() {
        return allowed;
    }

    /**
     * This method is called when getAllowed returns false to determine whether
     * an exception should be thrown to cause the requester's operation to be
     * restarted.  If getAllowed returns false and this method returns false,
     * the requester should wait for or be denied the lock, depending on the
     * request mode.  If getAllowed returns true, this method will always
     * return false.
     */
    boolean getRestart() {
        return restart;
    }
}
