/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.latch;

import static com.sleepycat.je.latch.LatchStatDefinition.LATCH_CONTENTION;
import static com.sleepycat.je.latch.LatchStatDefinition.LATCH_NOWAIT_SUCCESS;
import static com.sleepycat.je.latch.LatchStatDefinition.LATCH_NOWAIT_UNSUCCESS;
import static com.sleepycat.je.latch.LatchStatDefinition.LATCH_NO_WAITERS;
import static com.sleepycat.je.latch.LatchStatDefinition.LATCH_RELEASES;
import static com.sleepycat.je.latch.LatchStatDefinition.LATCH_SELF_OWNED;

import java.util.concurrent.locks.ReentrantLock;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.utilint.IntStat;
import com.sleepycat.je.utilint.StatGroup;

public class Latch {

    /*
     * Required because getOwner() is protected (for unknown reasons) and can't
     * be accessed except by a subclass of ReentrantLock.
     */
    @SuppressWarnings("serial")
    private static class JEReentrantLock extends ReentrantLock {
        JEReentrantLock(boolean fair) {
            super(fair);
        }

        @Override
        protected Thread getOwner() {
            return super.getOwner();
        }
    }

    private final JEReentrantLock lock;
    private String name;
    private final StatGroup stats;
    private final IntStat nAcquiresNoWaiters;
    private final IntStat nAcquiresSelfOwned;
    private final IntStat nAcquiresWithContention;
    private final IntStat nAcquiresNoWaitSuccessful;
    private final IntStat nAcquiresNoWaitUnsuccessful;
    private final IntStat nReleases;

    public Latch(String name) {
        lock = new JEReentrantLock(EnvironmentImpl.getFairLatches());
        this.name = name;

        stats = new StatGroup(LatchStatDefinition.GROUP_NAME, 
                              LatchStatDefinition.GROUP_DESC);
        nAcquiresNoWaiters = new IntStat(stats, LATCH_NO_WAITERS);
        nAcquiresSelfOwned = new IntStat(stats, LATCH_SELF_OWNED);
        nAcquiresWithContention = new IntStat(stats, LATCH_CONTENTION);
        nAcquiresNoWaitSuccessful = new IntStat(stats, LATCH_NOWAIT_SUCCESS);
        nAcquiresNoWaitUnsuccessful = new IntStat(stats, 
                                                  LATCH_NOWAIT_UNSUCCESS);
        nReleases = new IntStat(stats, LATCH_RELEASES);
    }

    /**
     * Set the latch name, used for latches in objects instantiated from
     * the log.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Used by com.sleepycat.je.utilint.TimingLatch.
     */
    public String getName() {
        return name;
    }

    /**
     * Acquire a latch for exclusive/write access.
     *
     * <p>Wait for the latch if some other thread is holding it.  If there are
     * threads waiting for access, they will be granted the latch on a FIFO
     * basis.  When the method returns, the latch is held for exclusive
     * access.</p>
     *
     * @throws EnvironmentFailureException if the latch is already held by the
     * calling thread.
     */
    public void acquire() {
        try {
            if (lock.isHeldByCurrentThread()) {
                nAcquiresSelfOwned.increment();
                throw EnvironmentFailureException.unexpectedState
                    ("Latch already held: " + name);
            }

            if (lock.isLocked()) {
                nAcquiresWithContention.increment();
            } else {
                nAcquiresNoWaiters.increment();
            }

            lock.lock();

            assert noteLatch(); // intentional side effect;
        } finally {
            assert EnvironmentImpl.maybeForceYield();
        }
    }

    /**
     * Acquire a latch for exclusive/write access, but do not block if it's not
     * available.
     *
     * @return true if the latch was acquired, false if it is not available.
     *
     * @throws EnvironmentFailureException if the latch is already held by the
     * calling thread.
     */
    public boolean acquireNoWait() {
        try {
            if (lock.isHeldByCurrentThread()) {
                nAcquiresSelfOwned.increment();
                throw EnvironmentFailureException.unexpectedState
                    ("Latch already held: " + name);
            }

            boolean ret = lock.tryLock();
            if (ret) {
                assert noteLatch();
                nAcquiresNoWaitSuccessful.increment();
            } else {
                nAcquiresNoWaitUnsuccessful.increment();
            }
            return ret;
        } finally {
            assert EnvironmentImpl.maybeForceYield();
        }
    }

    /**
     * Release the latch.  If there are other thread(s) waiting for the latch,
     * one is woken up and granted the latch. If the latch was not owned by
     * the caller, just return;
     */
    public void releaseIfOwner() {
        doRelease(false);
    }

    /**
     * Release the latch.  If there are other thread(s) waiting for the latch,
     * they are woken up and granted the latch.
     *
     * @throws EnvironmentFailureException if the latch is not currently held.
     */
    public void release() {
        if (doRelease(true)) {
            throw EnvironmentFailureException.unexpectedState
                ("Latch not held: " + name);
        }
    }

    /**
     * Do the work of releasing the latch. Wake up any waiters.
     *
     * @returns true if this latch was not owned by the caller.
     */
    private boolean doRelease(boolean checkHeld) {

        try {
            if (!lock.isHeldByCurrentThread()) {
                return true;
            }
            lock.unlock();
            nReleases.increment();
            assert unNoteLatch(checkHeld); // intentional side effect.
        } catch (IllegalMonitorStateException IMSE) {
            return true;
        }
        return false;
    }

    /**
     * Return true if the current thread holds this latch.
     *
     * @return true if we hold this latch.  False otherwise.
     */
    public boolean isOwner() {
        return lock.isHeldByCurrentThread();
    }

    /**
     * Used only for unit tests.
     *
     * @return the thread that currently holds the latch for exclusive access.
     */
    public Thread owner() {
        return lock.getOwner();
    }

    /**
     * Return the number of threads waiting.
     *
     * @return the number of threads waiting for the latch.
     */
    public int nWaiters() {
        return lock.getQueueLength();
    }

    /**
     * @return a LatchStats object with information about this latch.
     */
    public StatGroup getLatchStats() {
        return stats;
    }

    public void clear() {
        stats.clear();
    }

    /**
     * Formats a latch owner and waiters.
     */
    @Override
    public String toString() {
        return lock.toString();
    }

    /**
     * Only call under the assert system. This records latching by thread.
     */
    private boolean noteLatch() {
        return LatchSupport.latchTable.noteLatch(this);
    }

    /**
     * Only call under the assert system. This records latching by thread.
     */
    private boolean unNoteLatch(boolean checkHeld) {

        /* Only return a false status if we are checking for latch ownership.*/
        if (checkHeld) {
            return LatchSupport.latchTable.unNoteLatch(this, name);
        } else {
            LatchSupport.latchTable.unNoteLatch(this, name);
            return true;
        }
    }
}
