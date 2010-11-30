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
import com.sleepycat.je.utilint.StatGroup;

/**
 * SyncedLockManager uses the synchronized keyword to implement its critical
 * sections.
 */
public class SyncedLockManager extends LockManager {

    public SyncedLockManager(EnvironmentImpl envImpl) {
        super(envImpl);
    }

    /**
     * @see LockManager#attemptLock
     */
    @Override
    Lock lookupLock(Long nodeId) {
        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            return lookupLockInternal(nodeId, lockTableIndex);
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
        synchronized(lockTableLatches[lockTableIndex]) {
            return attemptLockInternal
                (nodeId, locker, type, nonBlockingRequest,
                 lockTableIndex);
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
                                         DatabaseImpl database) {

        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            return makeTimeoutMsgInternal
                (isLockNotTxnTimeout, locker, nodeId, type, grantType, useLock,
                 timeout, start, now, database);
        }
    }

    /**
     * @see LockManager#releaseAndNotifyTargets
     */
    @Override
    Set<Locker> releaseAndFindNotifyTargets(long nodeId, Locker locker) {
        long nid = nodeId;
        int lockTableIndex = getLockTableIndex(nid);
        synchronized(lockTableLatches[lockTableIndex]) {
            return releaseAndFindNotifyTargetsInternal
                (nodeId, locker, lockTableIndex);
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
        synchronized(lockTableLatches[lockTableIndex]) {
            transferInternal(nodeId, owningLocker, destLocker,
                             demoteToRead, lockTableIndex);
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
        synchronized(lockTableLatches[lockTableIndex]) {
            transferMultipleInternal(nodeId, owningLocker,
                                     destLockers, lockTableIndex);
        }
    }

    /**
     * @see LockManager#demote
     */
    @Override
    void demote(long nodeId, Locker locker) {
        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            demoteInternal(nodeId, locker, lockTableIndex);
        }
    }

    /**
     * @see LockManager#isLocked
     */
    @Override
    boolean isLocked(Long nodeId) {

        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            return isLockedInternal(nodeId, lockTableIndex);
        }
    }

    /**
     * @see LockManager#isOwner
     */
    @Override
    boolean isOwner(Long nodeId, Locker locker, LockType type) {

        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            return isOwnerInternal(nodeId, locker, type, lockTableIndex);
        }
    }

    /**
     * @see LockManager#isWaiter
     */
    @Override
    boolean isWaiter(Long nodeId, Locker locker) {

        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            return isWaiterInternal(nodeId, locker, lockTableIndex);
        }
    }

    /**
     * @see LockManager#nWaiters
     */
    @Override
    int nWaiters(Long nodeId) {

        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            return nWaitersInternal(nodeId, lockTableIndex);
        }
    }

    /**
     * @see LockManager#nOwners
     */
    @Override
    int nOwners(Long nodeId) {

        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            return nOwnersInternal(nodeId, lockTableIndex);
        }
    }

    /**
     * @see LockManager#getWriterOwnerLocker
     */
    @Override
    Locker getWriteOwnerLocker(Long nodeId) {
        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            return getWriteOwnerLockerInternal(nodeId, lockTableIndex);
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
                              MemoryBudget mb) {
        int lockTableIndex = getLockTableIndex(nodeId);
        synchronized(lockTableLatches[lockTableIndex]) {
            return validateOwnershipInternal
                (nodeId, locker, type, flushFromWaiters, mb, lockTableIndex);
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
        synchronized(lockTableLatches[lockTableIndex]) {
            return stealLockInternal(nodeId, locker, lockType,
                                     mb, lockTableIndex);
        }
    }

    /**
     * @see LockManager#dumpLockTable
     */
    @Override
    void dumpLockTable(StatGroup stats, boolean clear) {
        for (int i = 0; i < nLockTables; i++) {
            synchronized(lockTableLatches[i]) {
                dumpLockTableInternal(stats, i, clear);
            }
        }
    }
}
