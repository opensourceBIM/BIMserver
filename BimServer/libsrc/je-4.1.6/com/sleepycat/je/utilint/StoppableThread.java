/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.DbInternal;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.ExceptionListener;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * A StoppableThread is a daemon that obeys the following mandates:
 * - it sets the daemon property for the thread
 * - an uncaught exception handler is always registered
 * - the thread registers with the JE exception listener mechanism.
 * - its shutdown method can only be executed once. StoppableThreads are not
 *   required to implement shutdown() methods, because in some cases their
 *   shutdown processing must be coordinated by an owning, parent thread.
 *
 * StoppableThread is an alternative to the DaemonThread. It also assumes that
 * the thread's run() method may be more complex that that of the work-queue,
 * task oriented DaemonThread.
 *
 * A StoppableThread's run method should catch and handle all exceptions. By
 * default, unhandled exceptions are considered programming errors, and
 * invalidate the environment, but StoppableThreads may supply alternative
 * uncaught exception handling.
 *
 * StoppableThreads usually are created with an EnvironmentImpl, but on
 * occasion an environment may not be available (for components that can
 * execute without an environment). In that case, the thread obviously does not
 * invalidate the environment.
 *
 * Note that the StoppableThread.cleanup must be invoked upon, or soon after,
 * thread exit.
 */
public abstract class StoppableThread extends Thread
    implements ExceptionListenerUser {

    private ExceptionListener exceptionListener;

    /* The environment, if any, that's associated with this thread. */
    protected final EnvironmentImpl envImpl;

    /*
     * Shutdown can only be executed once. The shutdown field protects against
     * multiple invocations.
     */
    private final AtomicBoolean shutdown = new AtomicBoolean(false);

    /* The exception (if any) that forced this node to shut down. */
    private Exception savedShutdownException = null;

    /* Total cpu time used by thread */
    private long totalCpuTime = -1;

    /* Total user time used by thread */
    private long totalUserTime = -1;

    protected StoppableThread(final String threadName) {
        this(null, null, null, threadName);
    }

    protected StoppableThread(final EnvironmentImpl envImpl,
                              final String threadName) {
        this(envImpl, null /* handler */, null /* runnable */,threadName);
    }

    protected StoppableThread(final EnvironmentImpl envImpl,
                              final UncaughtExceptionHandler handler,
                              final String threadName) {
        this(envImpl, handler, null /* runnable */, threadName);
    }

    protected StoppableThread(final EnvironmentImpl envImpl,
                              final UncaughtExceptionHandler handler,
                              final Runnable runnable,
                              final String threadName) {
        super(null, runnable, threadName);
        this.envImpl = envImpl;

        /*
         * Set the daemon property so this thread will not hang up the
         * application.
         */
        setDaemon(true);

        /*
         * Register for updates to the exception listener mechanism. Check if
         * the environmentImpl is null, because there are a few cases where a
         * StoppableThread is created for components that work both in
         * replicated nodes and independently.
         */
        if (envImpl != null) {
            envImpl.registerExceptionListenerUser(this);
        }
        setUncaughtExceptionHandler
            ((handler == null) ? new UncaughtHandler() : handler);
    }

    /**
     * @return a logger to use when logging uncaught exceptions.
     */
    abstract protected Logger getLogger();

    /**
     * Returns the exception if any that provoked the shutdown
     *
     * @return the exception, or null if it was a normal shutdown
     */
    public Exception getSavedShutdownException() {
        return savedShutdownException;
    }

    public void saveShutdownException(Exception shutdownException) {
        savedShutdownException = shutdownException;
    }

    public boolean isShutdown() {
        return shutdown.get();
    }

    /**
     * Set every time a new exception listener is registered.
     */
    public void setExceptionListener(ExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
    }

    /**
     * Shutdown methods should only be executed once.
     *
     * @return true if shutdown is already set.
     */
    protected boolean shutdownDone() {
        return (!shutdown.compareAndSet(false, true));
    }

    /**
     * Must be invoked upon, or soon after, exit from the thread to perform
     * any cleanup, and ensure that any allocated resources are freed.
     */
    protected void cleanup() {
        if (envImpl != null) {
            envImpl.unregisterExceptionListenerUser(this);
        }
    }

    /**
     * An uncaught exception should invalidate the environment. Check if the
     * environmentImpl is null, because there are a few cases where a
     * StoppableThread is created for components that work both in replicated
     * nodes and independently.
     */
    private class UncaughtHandler implements UncaughtExceptionHandler {

        /**
         * When an uncaught exception occurs, log it, publish it to the
         * exception handler, and invalidate the environment.
         */
        public void uncaughtException(Thread t, Throwable e) {
            Logger useLogger = getLogger();
            if (useLogger != null) {
                String envName = (envImpl == null)? "" : envImpl.getName();
                String message = envName + ":" + t.getName() +
                    " exited unexpectedly with exception " + e;
                if (e != null) {
                    message += LoggerUtils.getStackTrace(e);
                }

                if (envImpl != null) {
                    /*
                     * If we have an environment, log this to all three
                     * handlers.
                     */
                    LoggerUtils.severe(useLogger, envImpl, message);
                } else {
                    /*
                     * We don't have an environment, but at least log this
                     * to the console.
                     */
                    useLogger.log(Level.SEVERE, message);
                }
            }

            if ((exceptionListener != null) && (e instanceof Exception)) {
                exceptionListener.exceptionThrown
                    (DbInternal.makeExceptionEvent((Exception) e,
                                                   t.getName()));
            }

            if (envImpl == null) {
                return;
            }

            /*
             * If not already invalid, invalidate environment by creating an
             * EnvironmentFailureException.
             */
            if (envImpl.isValid()) {

                /*
                 * Create the exception to invalidate the environment, but do
                 * not throw it since the handle is invoked in some internal
                 * JVM thread and the exception is not meaningful to the
                 * invoker.
                 */
                new EnvironmentFailureException
                    (envImpl, EnvironmentFailureReason.UNCAUGHT_EXCEPTION, e);
            }
        }
    }

    /**
     * This method is invoked from another thread of control to shutdown this
     * thread. It first tries a "soft" shutdown by invoking
     * <code>initiateSoftShutdown()</code>. If the thread does not exit on its
     * own in <code>waitMs</code> the thread is interrupted.
     * <code>waitMs</code> is determined by the technique used for the soft
     * shutdown. For example, if the thread polls on a periodic basis, it could
     * span one or more polling periods.
     *
     * All Stoppable threads are expected to catch an interrupt, clean up and
     * then exit.
     *
     * @param logger the logger on which to log messages
     */
    public void shutdownThread(Logger logger) {

        /*
         * Save resource usage, since it will not be available once the
         * thread has exited.
         */
        //ONEJAVA/*
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        totalCpuTime = threadBean.getThreadCpuTime(getId());
        totalUserTime = threadBean.getThreadUserTime(getId());
        //ONEJAVA*/

        if (Thread.currentThread() == this) {
            return;
        }

        try {
            int waitMs = initiateSoftShutdown();

            /* Wait for a soft shutdown to take effect */
            if (waitMs >= 0) {
                join(waitMs);
            }

            if (isAlive()) {
                LoggerUtils.warning(logger, envImpl,
                                    "Soft shutdown failed for thread:" +
                                    this + " resorting to interrupt.");
                interrupt();

                /*
                 * Wait indefinitely for this join operation, since the thread
                 * must make provision to handle and exit on an interrupt.
                 */
                join();
                LoggerUtils.warning
                    (logger, envImpl, this + " shutdown via interrupt.");
            } else {
                LoggerUtils.fine(logger, envImpl, this + " has exited.");
            }
        } catch (InterruptedException e1) {
            LoggerUtils.warning(logger, envImpl,
                                "Interrupted while waiting to join thread:" +
                                this);
        }
    }

    /**
     * Threads that use shutdownThread() must define this method. It's invoked
     * by shutdownThread as an attempt at a soft shutdown.
     *
     * This method makes provisions for this thread to exit on its own. The
     * technique used to make the thread exit can vary based upon the nature of
     * the service being provided by the thread. For example, the thread may be
     * known to poll some shutdown flag on a periodic basis, or it may detect
     * that a channel that it waits on has been closed by this method.
     *
     * @return the amount of time in ms that the shutdownThread method will
     * wait for the thread to exit. A -ve value means that the method will not
     * wait. A zero value means it will wait indefinitely.
     */
    protected int initiateSoftShutdown() {
        return -1;
    }

    /**
     * Returns the total cpu time associated with the thread, after the thread
     * has been shutdown.
     */
    public long getTotalCpuTime() {
        return totalCpuTime;
    }

    /**
     * Returns the total cpu time associated with the thread, after the thread
     * has been shutdown.
     */
    public long getTotalUserTime() {
        return totalUserTime;
    }
}
