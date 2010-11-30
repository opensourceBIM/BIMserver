/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import java.util.Iterator;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.OperationFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Extends BasicLocker to share locks among all lockers for the same thread.
 * This locker is used when a JE entry point is called with a null transaction
 * parameter.
 */
public class ThreadLocker extends BasicLocker {

    /**
     * Creates a ThreadLocker.
     */
    public ThreadLocker(EnvironmentImpl env) {
        super(env);
        lockManager.registerThreadLocker(this);
    }

    public static ThreadLocker createThreadLocker(EnvironmentImpl env)
        throws DatabaseException {

        ThreadLocker ret = null;
        try {
            ret = env.isReplicated() ?
                  env.createRepThreadLocker() :
                  new ThreadLocker(env);
        } catch (DatabaseException DE) {
            ret.operationEnd(false);
            throw DE;
        }
        return ret;
    }

    @Override
    void close() {
        super.close();
        lockManager.unregisterThreadLocker(this);
    }

    /**
     * Checks for preemption in all thread lockers for this thread.
     */
    @Override
    void checkPreempted(final Locker allowPreemptedLocker) 
        throws OperationFailureException {

        final Iterator<ThreadLocker> iter =
            lockManager.getThreadLockers(thread);
        while (iter.hasNext()) {
            final ThreadLocker locker = iter.next();
            locker.throwIfPreempted(allowPreemptedLocker);
        }
    }

    /**
     * Check that this locker is not used in the wrong thread.
     *
     * @throws IllegalStateException via all Cursor methods that use a
     * non-transactional locker.
     */
    @Override
    protected void checkState(boolean ignoreCalledByAbort) {
        if (thread != Thread.currentThread()) {
            throw new IllegalStateException
                ("Non-transactional Cursors may not be used in multiple " +
                 "threads; Cursor was created in " + thread +
                 " but used in " + Thread.currentThread());
        }
    }

    /**
     * Returns a new non-transactional locker that shares locks with this
     * locker by virtue of being a ThreadLocker for the same thread.
     */
    @Override
    public Locker newNonTxnLocker()
        throws DatabaseException {

        checkState(false);
        return ThreadLocker.createThreadLocker(envImpl);
    }

    /**
     * Returns whether this locker can share locks with the given locker.
     * Locks are shared when both lockers are ThreadLocker instances for the
     * same thread.
     */
    @Override
    public boolean sharesLocksWith(Locker other) {

        if (super.sharesLocksWith(other)) {
            return true;
        } else if (other instanceof ThreadLocker) {
            return thread == ((ThreadLocker) other).thread;
        } else {
            return false;
        }
    }
}
