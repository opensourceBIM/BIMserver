/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

/**
 * This is just a struct to hold a multi-value return.
 */
class LockAttemptResult {
    boolean success;
    Lock useLock;
    LockGrantType lockGrant;

    LockAttemptResult(Lock useLock,
                      LockGrantType lockGrant,
                      boolean success) {

        this.useLock = useLock;
        this.lockGrant = lockGrant;
        this.success = success;
    }
}
