/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import java.util.List;
import java.util.Set;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.MemoryBudget;

/**
 * A Lock embodies the lock state of a NodeId.  It includes a set of owners and
 * a list of waiters.
 */
interface Lock {

    /**
     * Get a list of waiters for debugging and error messages.
     */
    public List<LockInfo> getWaitersListClone();

    /**
     * Remove this locker from the waiter list.
     */
    public void flushWaiter(Locker locker,
                            MemoryBudget mb,
                            int lockTableIndex);

    /**
     * Get a new Set of the owners.
     */
    public Set<LockInfo> getOwnersClone();

    /**
     * Return true if locker is an owner of this Lock for lockType,
     * false otherwise.
     *
     * This method is only used by unit tests.
     */
    public boolean isOwner(Locker locker, LockType lockType);

    /**
     * Return true if locker is an owner of this Lock and this is a write
     * lock.
     */
    public boolean isOwnedWriteLock(Locker locker);

    /**
     * Return true if locker is a waiter on this Lock.
     *
     * This method is only used by unit tests.
     */
    public boolean isWaiter(Locker locker);

    public int nWaiters();

    public int nOwners();

    /**
     * Attempts to acquire the lock and returns the LockGrantType.
     *
     * Assumes we hold the lockTableLatch when entering this method.
     */
    public LockAttemptResult lock(LockType requestType,
                                  Locker locker,
                                  boolean nonBlockingRequest,
                                  MemoryBudget mb,
                                  int lockTableIndex)
        throws DatabaseException;

    /**
     * Releases a lock and moves the next waiter(s) to the owners.
     * @return
     *  - null if we were not the owner,
     *  - a non-empty set if owners should be notified after releasing,
     *  - an empty set if no notification is required.
     */
    public Set<Locker> release(Locker locker, 
                               MemoryBudget mb, 
                               int lockTableIndex);

    /**
     * Removes all owners except for the given owner, and sets the Preempted
     * property on the removed owners.
     */
    public void stealLock(Locker locker, MemoryBudget mb, int lockTableIndex)
        throws DatabaseException;

    /**
     * Downgrade a write lock to a read lock.
     */
    public void demote(Locker locker);

    /**
     * Transfer a lock from one transaction to another. Make sure that this
     * destination locker is only present as a single reader or writer.
     */
    public Lock transfer(Long nodeId,
                         Locker currentLocker,
                         Locker destLocker,
                         MemoryBudget mb,
                         int lockTableIndex)
        throws DatabaseException;

    /**
     * Transfer a lock from one transaction to many others. Only really needed
     * for case where a write handle lock is being transferred to multiple read
     * handles.
     */
    public Lock transferMultiple(Long nodeId,
                                 Locker currentLocker,
                                 Locker[] destLockers,
                                 MemoryBudget mb,
                                 int lockTableIndex)
        throws DatabaseException;

    /**
     * Return the locker that has a write ownership on this lock. If no
     * write owner exists, return null.
     */
    public Locker getWriteOwnerLocker();

    public boolean isThin();

    /**
     * Debug dumper.
     */
    public String toString();
}
