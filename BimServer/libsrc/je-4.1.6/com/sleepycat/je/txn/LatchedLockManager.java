/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import java.util.Set;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.latch.Latch;
import com.sleepycat.je.utilint.StatGroup;

/**
 * LatchedLockManager uses latches to implement its critical sections.
 */
public class LatchedLockManager extends LockManager {

    public LatchedLockManager(EnvironmentImpl envImpl) {
        super(envImpl);
    }

    /**
     * @see LockManager#lookupLock
     */
    @Override
    Lock lookupLock(Long nodeId)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return lookupLockInternal(nodeId, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#attemptLock
     */
    @Override
    LockAttemptResult attemptLock(Long nodeId,
                                  Locker locker,
                                  LockType type,
                                  boolean nonBlockingRequest)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return attemptLockInternal(nodeId, locker, type,
                                       nonBlockingRequest, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#makeTimeoutMsg
     */
    @Override
    LockConflictException makeTimeoutMsg(boolean isLockNotTxnTimeout,
                                         Locker locker,
                                         long nodeId,
                                         LockType type,
                                         LockGrantType grantType,
                                         Lock useLock,
                                         long timeout,
                                         long start,
                                         long now,
                                         DatabaseImpl database)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return makeTimeoutMsgInternal
                (isLockNotTxnTimeout, locker, nodeId, type, grantType, useLock,
                 timeout, start, now, database);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#releaseAndNotifyTargets
     */
    @Override
    Set<Locker> releaseAndFindNotifyTargets(long nodeId, Locker locker)
        throws DatabaseException {

        long nid = nodeId;
        int lockTableIndex = getLockTableIndex(nid);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return releaseAndFindNotifyTargetsInternal
                (nodeId, locker, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#transfer
     */
    @Override
    void transfer(long nodeId,
                  Locker owningLocker,
                  Locker destLocker,
                  boolean demoteToRead)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            transferInternal(nodeId, owningLocker, destLocker,
                             demoteToRead, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#transferMultiple
     */
    @Override
    void transferMultiple(long nodeId,
                          Locker owningLocker,
                          Locker[] destLockers)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            transferMultipleInternal(nodeId, owningLocker,
                                     destLockers, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#demote
     */
    @Override
    void demote(long nodeId, Locker locker)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            demoteInternal(nodeId, locker, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#isLocked
     */
    @Override
    boolean isLocked(Long nodeId)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return isLockedInternal(nodeId, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#isOwner
     */
    @Override
    boolean isOwner(Long nodeId, Locker locker, LockType type)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return isOwnerInternal(nodeId, locker, type, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#isWaiter
     */
    @Override
    boolean isWaiter(Long nodeId, Locker locker)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return isWaiterInternal(nodeId, locker, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#nWaiters
     */
    @Override
    int nWaiters(Long nodeId)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return nWaitersInternal(nodeId, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#nOwners
     */
    @Override
    int nOwners(Long nodeId)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return nOwnersInternal(nodeId, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#getWriterOwnerLocker
     */
    @Override
    Locker getWriteOwnerLocker(Long nodeId)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return getWriteOwnerLockerInternal(nodeId, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#validateOwnership
     */
    @Override
    boolean validateOwnership(Long nodeId,
                              Locker locker,
                              LockType type,
                              boolean flushFromWaiters,
                              MemoryBudget mb)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return validateOwnershipInternal
                (nodeId, locker, type, flushFromWaiters, mb, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#stealLock
     */
    @Override
    protected LockAttemptResult stealLock(Long nodeId,
                                          Locker locker,
                                          LockType lockType,
                                          MemoryBudget mb)
        throws DatabaseException {

        int lockTableIndex = getLockTableIndex(nodeId);
        Latch latch = lockTableLatches[lockTableIndex];
        latch.acquire();
        try {
            return stealLockInternal(nodeId, locker, lockType,
                                     mb, lockTableIndex);
        } finally {
            latch.release();
        }
    }

    /**
     * @see LockManager#dumpLockTable
     */
    @Override
    void dumpLockTable(StatGroup stats, boolean clear) 
        throws DatabaseException {

        for (int i = 0; i < nLockTables; i++) {
            lockTableLatches[i].acquire();
            try {
                dumpLockTableInternal(stats, i, clear);
            } finally {
                lockTableLatches[i].release();
            }
        }
    }
}
