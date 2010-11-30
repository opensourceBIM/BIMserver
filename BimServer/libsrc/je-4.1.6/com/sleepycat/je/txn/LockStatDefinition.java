/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for JE lock statistics.
 */
public class LockStatDefinition {

    public static final String GROUP_NAME = "Locks";
    public static final String GROUP_DESC = 
        "Locks held by data operations, latching contention on lock table.";

    public static final StatDefinition LOCK_READ_LOCKS =
        new StatDefinition("nReadLocks",
                           "Number of read locks currently held.");

    public static final StatDefinition LOCK_WRITE_LOCKS =
        new StatDefinition("nWriteLocks",
                           "Number of write locks currently held.");

    public static final StatDefinition LOCK_OWNERS =
        new StatDefinition("nOwners",
                           "Number of lock owners in lock table.");

    public static final StatDefinition LOCK_REQUESTS =
        new StatDefinition("nRequests",
                           "Number of times a lock request was made.");

    public static final StatDefinition LOCK_TOTAL =
        new StatDefinition("nTotalLocks",
                           "Number of locks current in lock table.");

    public static final StatDefinition LOCK_WAITS =
        new StatDefinition("nWaits",
                           "Number of times a lock request blocked.");

    public static final StatDefinition LOCK_WAITERS =
        new StatDefinition("nWaiters",
                           "Number of transactions waiting for a lock.");
}
