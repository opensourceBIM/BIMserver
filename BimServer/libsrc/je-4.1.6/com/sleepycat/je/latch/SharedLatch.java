/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.latch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Simple thread-based non-transactional reader-writer/shared-exclusive latch.
 *
 * Latches provide simple exclusive or shared transient locks on objects.
 * Latches are expected to be held for short, defined periods of time.  No
 * deadlock detection is provided so it is the caller's responsibility to
 * sequence latch acquisition in an ordered fashion to avoid deadlocks.
 */
@SuppressWarnings("serial")
public class SharedLatch
    extends ReentrantReadWriteLock {

    private String name;
    private boolean noteLatch;
    private List<Thread> readers;

    /**
     * If true, this shared latch is only ever latched exclusively.  Used for
     * BINs.
     */
    private boolean exclusiveOnly;

    public SharedLatch(String name) {
        super(EnvironmentImpl.getFairLatches());
        assert (readers = Collections.synchronizedList
                (new ArrayList<Thread>())) != null;
        exclusiveOnly = false;
        this.name = name;
    }

    /**
     * Set the latch name, used for latches in objects instantiated from the
     * log.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Indicate whether this latch should be tracked in the debugging
     * LatchSupport.latchTable.
     * Always return true so this can be called under an assert.
     */
    public boolean setNoteLatch(boolean noteLatch) {
        this.noteLatch = noteLatch;
        return true;
    }

    /**
     * Indicate whether this latch can only be set exclusively (not shared).
     * Used for BIN latches that are Shared, but should only be latched
     * exclusively.
     */
    public void setExclusiveOnly(boolean exclusiveOnly) {
        this.exclusiveOnly = exclusiveOnly;
    }

    /**
     * Acquire a latch for exclusive/write access.  If the thread already holds
     * the latch for shared access, it cannot be upgraded and
     * EnvironmentFailureException will be thrown.
     *
     * Wait for the latch if some other thread is holding it.  If there are
     * threads waiting for access, they will be granted the latch on a FIFO
     * basis if fair latches are enabled.  When the method returns, the latch
     * is held for exclusive access.
     *
     * @throws EnvironmentFailureException if the latch is already held by the
     * current thread for shared access.
     */
    public void acquireExclusive() {
        try {
            if (isWriteLockedByCurrentThread()) {
                throw EnvironmentFailureException.unexpectedState
                    ("Latch already held: " + name);
            }

            writeLock().lock();

            assert (noteLatch ? noteLatch() : true);// intentional side effect;
        } finally {
            assert EnvironmentImpl.maybeForceYield();
        }
    }

    /**
     * Probe a latch for exclusive access, but don't block if it's not
     * available.
     *
     * @return true if the latch was acquired, false if it is not available.
     *
     * @throws EnvironmentFailureException if the latch is already held by the
     * calling thread.
     */
    public boolean acquireExclusiveNoWait() {
        try {
            if (isWriteLockedByCurrentThread()) {
                throw EnvironmentFailureException.unexpectedState
                    ("Latch already held: " + name);
            }

            boolean ret = writeLock().tryLock();

            /* Intentional side effect. */
            assert ((noteLatch & ret) ? noteLatch() : true);
            return ret;
        } finally {
            assert EnvironmentImpl.maybeForceYield();
        }
    }

    /**
     * Acquire a latch for shared/read access.  Nesting is allowed, that is,
     * the latch may be acquired more than once by the same thread.
     */
    public void acquireShared() {
        if (exclusiveOnly) {
            acquireExclusive();
            return;
        }

        try {
            boolean assertionsEnabled = false;
            assert assertionsEnabled = true;
            if (assertionsEnabled) {
                if (readers.add(Thread.currentThread())) {
                    readLock().lock();
                } else {
                    /* Already latched, do nothing. */
                }
            } else {
                readLock().lock();
            }

            assert (noteLatch ?  noteLatch() : true);// intentional side effect
        } finally {
            assert EnvironmentImpl.maybeForceYield();
        }
    }

    /**
     * Release an exclusive or shared latch.  If there are other thread(s)
     * waiting for the latch, they are woken up and granted the latch.
     */
    public void release() {
        try {
            if (isWriteLockedByCurrentThread()) {
                writeLock().unlock();
                /* Intentional side effect. */
                assert (noteLatch ? unNoteLatch() : true);
                return;
            }

            if (exclusiveOnly) {
                return;
            }

            boolean assertionsEnabled = false;
            assert assertionsEnabled = true;
            if (assertionsEnabled) {
                if (readers.remove(Thread.currentThread())) {
                    readLock().unlock();
                } else {
                    throw EnvironmentFailureException.unexpectedState
                        ("Latch not held: " + name);
                }
            } else {

                /*
                 * There's no way to tell if a readlock is held by the current
                 * thread so just try unlocking it.
                 */
                readLock().unlock();
            }
            /* Intentional side effect. */
            assert (noteLatch ? unNoteLatch() : true);
        } catch (IllegalMonitorStateException IMSE) {
            IMSE.printStackTrace();
            return;
        }
    }

    /**
     * Release the latch. If there are other thread(s) waiting for the latch,
     * one is woken up and granted the latch.  If the latch was not owned by
     * the caller, just return.
     */
    public void releaseIfOwner() {
        if (isWriteLockedByCurrentThread()) {
            writeLock().unlock();
            assert (noteLatch ? unNoteLatch() : true);
            return;
        }

        if (exclusiveOnly) {
            return;
        }

        assert (getReadLockCount() > 0);
        boolean assertionsEnabled = false;
        assert assertionsEnabled = true;
        if (assertionsEnabled) {
            if (readers.contains(Thread.currentThread())) {
                readLock().unlock();
                readers.remove(Thread.currentThread());
                assert (noteLatch ? unNoteLatch() : true);
            }
        } else {

            /*
             * There's no way to tell if a readlock is held by the current
             * thread so just try unlocking it.
             */
            readLock().unlock();
        }
    }

    /**
     * Return true if this thread is an owner, reader, or write.
     */
    public boolean isOwner() {
        boolean assertionsEnabled = false;
        assert assertionsEnabled = true;
        if (assertionsEnabled && !exclusiveOnly) {
            return readers.contains(Thread.currentThread()) ||
                isWriteLockedByCurrentThread();
        } else {
            return isWriteLockedByCurrentThread();
        }
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
    private boolean unNoteLatch() {

        return LatchSupport.latchTable.unNoteLatch(this, name);
    }
}
