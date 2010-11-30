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
 * DummyLockManager performs no locking for DS mode.
 */
public class DummyLockManager extends LockManager {

    /*
     * Even though a user may specify isNoLocking for performance reasons, JE
     * will sometimes still need to use locking internally (e.g. handle locks,
     * and transactional access to internal db's).  So we can not completely
     * eliminate the Lock Manager. Instead, when isNoLocking is specified, we
     * keep a standard Lock Manager around for use by cursors that access
     * internal databases.  Delegate to that as needed.
     * [#16453]
     */
    private final LockManager superiorLockManager;

    public DummyLockManager(EnvironmentImpl envImpl,
                            LockManager superiorLockManager) {
        super(envImpl);
        this.superiorLockManager = superiorLockManager;
    }

    /**
     * @see LockManager#lookupLock
     */
    @Override
    Lock lookupLock(Long nodeId)
        throws DatabaseException {

        Lock ret = superiorLockManager.lookupLock(nodeId);
        return ret;
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

        if (locker.lockingRequired()) {
            return superiorLockManager.attemptLock
                (nodeId, locker, type, nonBlockingRequest);
        } else {
            return new LockAttemptResult(null, LockGrantType.NEW, true);
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

        if (locker.lockingRequired()) {
            return superiorLockManager.makeTimeoutMsg
                (isLockNotTxnTimeout, locker, nodeId, type, grantType, useLock,
                 timeout, start, now, database);
        } else {
            return null;
        }
    }

    /**
     * @see LockManager#releaseAndFindNotifyTargets
     */
    @Override
    Set<Locker> releaseAndFindNotifyTargets(long nodeId, Locker locker)
        throws DatabaseException {

        /*
         * Unconditionally release the lock.  This does not detract from the
         * performance benefit of disabled locking, since this method is only
         * called if a lock was previously acquired, i.e., it is held by a
         * Locker.
         *
         * If the release of the lock were conditional, a lock transferred
         * between Lockers (as we do with Database handle locks) would never be
         * released, since the destination Locker's lockingRequired property
         * is not set to true.  In general, it is safer to unconditionally
         * release locks than to rely on the lockingRequired property. [#17985]
         */
        return superiorLockManager.releaseAndFindNotifyTargets(nodeId, locker);
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

        if (owningLocker.lockingRequired()) {
            superiorLockManager.transfer
                (nodeId, owningLocker, destLocker, demoteToRead);
        } else {
            return;
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

        if (owningLocker.lockingRequired()) {
            superiorLockManager.transferMultiple
                (nodeId, owningLocker, destLockers);
        } else {
            return;
        }
    }

    /**
     * @see LockManager#demote
     */
    @Override
    void demote(long nodeId, Locker locker)
        throws DatabaseException {

        if (locker.lockingRequired()) {
            superiorLockManager.demote(nodeId, locker);
        } else {
            return;
        }
    }

    /**
     * @see LockManager#isLocked
     */
    @Override
    boolean isLocked(Long nodeId)
        throws DatabaseException {

        return superiorLockManager.isLocked(nodeId);
    }

    /**
     * @see LockManager#isOwner
     */
    @Override
    boolean isOwner(Long nodeId, Locker locker, LockType type)
        throws DatabaseException {

        return superiorLockManager.isOwner(nodeId, locker, type);
    }

    /**
     * @see LockManager#isWaiter
     */
    @Override
    boolean isWaiter(Long nodeId, Locker locker)
        throws DatabaseException {

        return superiorLockManager.isWaiter(nodeId, locker);
    }

    /**
     * @see LockManager#nWaiters
     */
    @Override
    int nWaiters(Long nodeId)
        throws DatabaseException {

        return superiorLockManager.nWaiters(nodeId);
    }

    /**
     * @see LockManager#nOwners
     */
    @Override
    int nOwners(Long nodeId)
        throws DatabaseException {

        return superiorLockManager.nOwners(nodeId);
    }

    /**
     * @see LockManager#getWriterOwnerLocker
     */
    @Override
    Locker getWriteOwnerLocker(Long nodeId)
        throws DatabaseException {

        return superiorLockManager.getWriteOwnerLocker(nodeId);
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

        if (locker.lockingRequired()) {
            return superiorLockManager.validateOwnership
                (nodeId, locker, type, flushFromWaiters, mb);
        } else {
            return true;
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

        if (locker.lockingRequired()) {
            return superiorLockManager.stealLock
                (nodeId, locker, lockType, mb);
        } else {
            return null;
        }
    }

    /**
     * @see LockManager#dumpLockTable
     */
    @Override
    void dumpLockTable(StatGroup stats, boolean clear)
        throws DatabaseException {

        superiorLockManager.dumpLockTable(stats, clear);
    }
}
