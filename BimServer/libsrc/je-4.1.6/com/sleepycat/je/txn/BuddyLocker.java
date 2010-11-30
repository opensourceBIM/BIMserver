/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.OperationFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Extends BasicLocker to share locks with another specific locker.
 *
 * <p>In general, a BuddyLocker can be used whenever the primary (API) locker
 * is in use, and we need to lock a node and release that lock before the
 * primary locker transaction ends.  In other words, for this particular lock
 * we don't want to use two-phase locking.  To accomplish that we use a
 * separate BuddyLocker instance to hold the lock, while sharing locks with the
 * primary locker.  The BuddyLocker can be closed to release this particular
 * lock, without releasing the other locks held by the primary locker.</p>
 *
 * <p>In particular, a BuddyLocker is used when acquiring a RANGE_INSERT lock.
 * RANGE_INSERT only needs to be held until the point we have inserted the new
 * node into the BIN.  A separate locker is therefore used so we can release
 * that lock separately when the insertion into the BIN is complete.  But the
 * RANGE_INSERT lock must not conflict with locks held by the primary locker.
 * So a BuddyLocker is used that shares locks with the primary locker.</p>
 */
public class BuddyLocker extends BasicLocker {

    private final Locker buddy;

    /**
     * Creates a BuddyLocker.
     */
    protected BuddyLocker(EnvironmentImpl env, Locker buddy) {
        super(env);
        this.buddy = buddy;
        buddy.addBuddy(this);
    }

    public static BuddyLocker createBuddyLocker(EnvironmentImpl env,
                                                Locker buddy)
        throws DatabaseException {

        BuddyLocker ret = null;
        try {
            ret = new BuddyLocker(env, buddy);
        } catch (DatabaseException DE) {
            ret.operationEnd(false);
            throw DE;
        }
        return ret;
    }

    @Override
    void close() {
        super.close();
        buddy.removeBuddy(this);
    }

    /**
     * Returns the buddy locker.
     */
    Locker getBuddy() {
        return buddy;
    }

    /**
     * Forwards this call to the buddy locker.  This object itself is never
     * transactional but the buddy may be.
     */
    @Override
    public Txn getTxnLocker() {
        return buddy.getTxnLocker();
    }

    /**
     * Forwards this call to the base class and to the buddy locker.
     */
    @Override
    public void releaseNonTxnLocks()
        throws DatabaseException {

        super.releaseNonTxnLocks();
        buddy.releaseNonTxnLocks();
    }

    /**
     * Returns whether this locker can share locks with the given locker.
     */
    @Override
    public boolean sharesLocksWith(Locker other) {

        if (super.sharesLocksWith(other)) {
            return true;
        } else {
            return buddy == other;
        }
    }

    /**
     * Returns the lock timeout of the buddy locker, since this locker has no
     * independent timeout.
     */
    @Override
    public long getLockTimeout() {
        return buddy.getLockTimeout();
    }

    /**
     * Returns the transaction timeout of the buddy locker, since this locker
     * has no independent timeout.
     */
    @Override
    public long getTxnTimeout() {
        return buddy.getTxnTimeout();
    }

    /**
     * Sets the lock timeout of the buddy locker, since this locker has no
     * independent timeout.
     */
    @Override
    public void setLockTimeout(long timeout) {
        buddy.setLockTimeout(timeout);
    }

    /**
     * Sets the transaction timeout of the buddy locker, since this locker has
     * no independent timeout.
     */
    @Override
    public void setTxnTimeout(long timeout) {
        buddy.setTxnTimeout(timeout);
    }

    /**
     * Returns whether the buddy locker is timed out, since this locker has no
     * independent timeout.
     */
    @Override
    public boolean isTimedOut() {
        return buddy.isTimedOut();
    }

    /**
     * Forwards to the buddy locker, since the buddy may be transactional.
     */
    @Override
    public void setOnlyAbortable(OperationFailureException cause) {
        buddy.setOnlyAbortable(cause);
    }

    /**
     * Forwards to the parent buddy locker, so the buddy can check itself and
     * all of its child buddies.
     */
    @Override
    void checkPreempted(final Locker allowPreemptedLocker) 
        throws OperationFailureException {

        buddy.checkPreempted(allowPreemptedLocker);
    }

    /**
     * Consider this locker replication-defined if its buddy (Txn) is
     * replication-defined.
     */
    @Override
    public boolean isReplicationDefined() {
        return buddy.isReplicationDefined();
    }
}
