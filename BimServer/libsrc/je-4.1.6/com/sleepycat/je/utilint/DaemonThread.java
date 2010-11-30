/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.ExceptionListener;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * A daemon thread. Also see StoppableThread for an alternative daemon
 * construct.
 */
public abstract class DaemonThread
    implements DaemonRunner, Runnable, ExceptionListenerUser {

    private static final int JOIN_MILLIS = 10;
    private long waitTime;
    private Object synchronizer = new Object();
    private Thread thread;
    private ExceptionListener exceptionListener;
    protected String name;
    protected int nWakeupRequests;
    protected boolean stifleExceptionChatter = false;

    /* Fields shared between threads must be 'volatile'. */
    private volatile boolean shutdownRequest = false;
    private volatile boolean paused = false;

    /* This is not volatile because it is only an approximation. */
    private boolean running = false;

    /* Fields for DaemonErrorListener, enabled only during testing. */
    protected EnvironmentImpl envImpl;
    private static final String ERROR_LISTENER = "setErrorListener";
    /* Logger used in DaemonThread's subclasses. */
    protected final Logger logger;

    public DaemonThread(final long waitTime,
                        final String name,
                        final EnvironmentImpl envImpl) {
        this.waitTime = waitTime;
        String nodeName = envImpl.getNodeName();
        if (nodeName == null) {
            this.name = name;
        } else {
            this.name = name + " (" + nodeName + ")";
        }
        this.envImpl = envImpl;
        this.logger = createLogger();
        envImpl.registerExceptionListenerUser(this);
    }

    public void setExceptionListener(ExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
    }

    protected Logger createLogger() {
        return LoggerUtils.getLogger(getClass());
    }

    /**
     * For testing.
     */
    public ExceptionListener getExceptionListener() {
        return exceptionListener;
    }

    /**
     * For testing.
     */
    public Thread getThread() {
        return thread;
    }

    /**
     * If run is true, starts the thread if not started or unpauses it
     * if already started; if run is false, pauses the thread if
     * started or does nothing if not started.
     */
    public void runOrPause(boolean run) {
        if (run) {
            paused = false;
            if (thread != null) {
                wakeup();
            } else {
                thread = new Thread(this, name);
                thread.setDaemon(true);
                thread.start();
            }
        } else {
            paused = true;
        }
    }

    public void requestShutdown() {
        shutdownRequest = true;
    }

    /**
     * Requests shutdown and calls join() to wait for the thread to stop.
     */
    public void shutdown() {
        if (thread != null) {
            shutdownRequest = true;
            while (thread.isAlive()) {
                synchronized (synchronizer) {
                    synchronizer.notifyAll();
                }
                try {
                    thread.join(JOIN_MILLIS);
                } catch (InterruptedException e) {

                    /*
                     * Klockwork - ok
                     * Don't say anything about exceptions here.
                     */
                }
            }
            thread = null;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<DaemonThread name=\"").append(name).append("\"/>");
        return sb.toString();
    }

    public void wakeup() {
        if (!paused) {
            synchronized (synchronizer) {
                synchronizer.notifyAll();
            }
        }
    }

    public void run() {
        while (!shutdownRequest) {
            try {
                /* Do a unit of work. */
                int numTries = 0;
                long maxRetries = nDeadlockRetries();
                while (numTries <= maxRetries &&
                       !shutdownRequest &&
                       !paused) {
                    try {
                        nWakeupRequests++;
                        running = true;
                        onWakeup();
                        break;
                    } catch (LockConflictException e) {
                    } finally {
                        running = false;
                    }
                    numTries++;
                }
                /* Wait for notify, timeout or interrupt. */
                if (!shutdownRequest) {
                    synchronized (synchronizer) {
                        if (waitTime == 0 || paused) {
                            synchronizer.wait();
                        } else {
                            synchronizer.wait(waitTime);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (exceptionListener != null) {
                    exceptionListener.exceptionThrown
                        (DbInternal.makeExceptionEvent(e, name));
                }
                if (!stifleExceptionChatter) {
                    System.err.println
                        ("Shutting down " + this + " due to exception: " + e);
                }
                shutdownRequest = true;

                assert checkErrorListener(e);
            } catch (Exception e) {
                if (exceptionListener != null) {
                    exceptionListener.exceptionThrown
                        (DbInternal.makeExceptionEvent(e, name));
                }
                if (!stifleExceptionChatter) {
                    System.err.println(this + " caught exception: " + e);
                    e.printStackTrace(System.err);

                    /*
                     * If the exception caused the environment to become
                     * invalid, then shutdownRequest will have been set to true
                     * by EnvironmentImpl.invalidate, which is called by the
                     * EnvironmentFailureException ctor.
                     */
                    System.err.println
                        (shutdownRequest ? "Exiting" : "Continuing");
                }

                assert checkErrorListener(e);
            } catch (Error e) {
                assert checkErrorListener(e);
                throw e;
            }
        }
    }

    /**
     * If Daemon Thread throws errors and exceptions, this function will catch
     * it and throw a EnvironmentFailureException, and fail the test.
     *
     * Only used during testing.
     */
    public boolean checkErrorListener(Throwable e) {
        if (Boolean.getBoolean(ERROR_LISTENER)) {
            if (!stifleExceptionChatter) {
                System.err.println(name + " " + LoggerUtils.getStackTrace(e));
            }
            new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.TEST_INVALIDATE,
                 "Daemon thread failed during testing", e);
        }

        return true;
    }

    /**
     * Returns the number of retries to perform when Deadlock Exceptions
     * occur.
     */
    protected long nDeadlockRetries() {
        return 0;
    }

    /**
     * onWakeup is synchronized to ensure that multiple invocations of the
     * DaemonThread aren't made.
     */
    abstract protected void onWakeup()
        throws DatabaseException;

    /**
     * Returns whether shutdown has been requested.  This method should be
     * used to to terminate daemon loops.
     */
    protected boolean isShutdownRequested() {
        return shutdownRequest;
    }

    /**
     * Returns whether the daemon is currently paused/disabled.  This method
     * should be used to to terminate daemon loops.
     */
    protected boolean isPaused() {
        return paused;
    }

    /**
     * Returns whether the onWakeup method is currently executing.  This is
     * only an approximation and is used to avoid unnecessary wakeups.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * For unit testing.
     */
    public int getNWakeupRequests() {
        return nWakeupRequests;
    }
}
