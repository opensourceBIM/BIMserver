/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import static com.sleepycat.je.log.LogStatDefinition.FSYNCMGR_FSYNCS;
import static com.sleepycat.je.log.LogStatDefinition.FSYNCMGR_FSYNC_REQUESTS;
import static com.sleepycat.je.log.LogStatDefinition.FSYNCMGR_FSYNC_TIMEOUTS;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.ThreadInterruptedException;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.latch.Latch;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;

/*
 * The FsyncManager ensures that only one file fsync is issued at a time, for
 * performance optimization. The goal is to reduce the number of fsyncs issued
 * by the system by issuing 1 fsync on behalf of a number of threads.
 *
 * For example, suppose these writes happen which all need to be fsynced to
 * disk:
 *
 *  thread 1 writes a commit record
 *  thread 2 writes a checkpoint
 *  thread 3 writes a commit record
 *  thread 4 writes a commit record
 *  thread 5 writes a checkpoint
 *
 * Rather than executing 5 fsyncs, which all must happen synchronously, we hope
 * to issue fewer. How many fewer depend on timing. Note that the writes
 * themselves are serialized and are guaranteed to run in order.
 *
 * For example:
 *    thread 1 wants to fsync first, no other fsync going on, will issue fsync
 *    thread 2 waits
 *    thread 3 waits
 *    thread 4 waits
 *     - before thread 5 comes, thread 1 finishes fsyncing and returns to
 *     the caller. Now another fsync can be issued that will cover threads
 *     2,3,4. One of those threads (2, 3, 4} issues the fsync, the others
 *     block.
 *    thread 5 wants to fsync, but sees one going on, so will wait.
 *     - the fsync issued for 2,3,4 can't cover thread 5 because we're not sure
 *      if thread 5's write finished before that fsync call. Thread 5 will have
 *      to issue its own fsync.
 *
 * Target file
 * -----------
 * Note that when the buffer pool starts a new file, we fsync the previous file
 * under the log write latch. Therefore, at any time we only have one target
 * file to fsync, which is the current write buffer. We do this so that we
 * don't have to coordinate between files.  For example, suppose log files have
 * 1000 bytes and a commit record is 10 bytes.  An LSN of value 6/990 is in
 * file 6 at offset 990.
 *
 * thread 1: logWriteLatch.acquire()
 *         write commit record to LSN 6/980
 *         logWriteLatch.release()
 * thread 2: logWriteLatch.acquire()
 *         write commit record to LSN 6/990
 *         logWriteLatch.release
 * thread 3: logWriteLatch.acquire()
 *         gets 7/000 as the next LSN to use
 *          see that we flipped to a new file, so call fsync on file 6
 *         write commit record to LSN 7/000
 *         logWriteLatch.release()
 *
 * Thread 3 will fsync file 6 within the log write latch. That way, at any
 * time, any non-latched fsyncs should only fsync the latest file.  If we
 * didn't do, there's the chance that thread 3 would fsync file 7 and return to
 * its caller before the thread 1 and 2 got an fsync for file 6. That wouldn't
 * be correct, because thread 3's commit might depend on file 6.
 *
 * Note that the FileManager keeps a file descriptor that corresponds to the
 * current end of file, and that is what we fsync.
 */
class FSyncManager {
    private EnvironmentImpl envImpl;
    private long timeout;

    /* Use as the target for a synchronization block. */
    private Latch fsyncLatch;

    private volatile boolean fsyncInProgress;
    private FSyncGroup nextFSyncWaiters;

    /* stats */
    private StatGroup stats;
    private LongStat nFSyncRequests;
    private LongStat nFSyncs;
    private LongStat nTimeouts;

    FSyncManager(EnvironmentImpl envImpl) {
        timeout = envImpl.getConfigManager().getDuration
            (EnvironmentParams.LOG_FSYNC_TIMEOUT);
        this.envImpl = envImpl;

        fsyncLatch = new Latch("fsyncLatch");
        fsyncInProgress = false;
        nextFSyncWaiters = new FSyncGroup(timeout, envImpl);

        stats = new StatGroup(LogStatDefinition.FSYNCMGR_GROUP_NAME,
                              LogStatDefinition.FSYNCMGR_GROUP_DESC);
        nFSyncRequests = new LongStat(stats, FSYNCMGR_FSYNC_REQUESTS);
        nFSyncs = new LongStat(stats, FSYNCMGR_FSYNCS);
        nTimeouts = new LongStat(stats, FSYNCMGR_FSYNC_TIMEOUTS);
    }

    /**
     * Request that this file be fsynced to disk. This thread may or may not
     * actually execute the fsync, but will not return until a fsync has been
     * issued and executed on behalf of its write. There is a timeout period
     * specified by EnvironmentParam.LOG_FSYNC_TIMEOUT that ensures that no
     * thread gets stuck here indefinitely.
     *
     * When a thread comes in, it will find one of two things.
     * 1. There is no fsync going on right now. This thread should go
     *    ahead and fsync.
     * 2. There is an active fsync, wait until it's over before
     *    starting a new fsync.
     *
     * When a fsync is going on, all those threads that come along are grouped
     * together as the nextFsyncWaiters. When the current fsync is finished,
     * one of those nextFsyncWaiters will be selected as a leader to issue the
     * next fsync. The other members of the group will merely wait until the
     * fsync done on their behalf is finished.
     *
     * When a thread finishes a fsync, it has to:
     * 1. wake up all the threads that were waiting for its fsync call.
     * 2. wake up one member of the next group of waiting threads (the
     *    nextFsyncWaiters) so that thread can become the new leader
     *    and issue the next fysnc call.
     *
     * If a non-leader member of the nextFsyncWaiters times out, it will issue
     * its own fsync anyway, in case something happened to the leader.
     */
    void fsync()
        throws DatabaseException {

        boolean doFsync = false;
        boolean isLeader = false;
        boolean needToWait = false;
        FSyncGroup inProgressGroup = null;
        FSyncGroup myGroup = null;

        synchronized (fsyncLatch) {
            nFSyncRequests.increment();

            /* Figure out if we're calling fsync or waiting. */
            if (fsyncInProgress) {
                needToWait = true;
                myGroup = nextFSyncWaiters;
            } else {
                isLeader = true;
                doFsync = true;
                fsyncInProgress = true;
                inProgressGroup = nextFSyncWaiters;
                nextFSyncWaiters = new FSyncGroup(timeout, envImpl);
            }
        }

        if (needToWait) {

            /*
             * Note that there's no problem if we miss the notify on this set
             * of waiters. We can check state in the FSyncGroup before we begin
             * to wait.
             *
             * All members of the group may return from their waitForFSync()
             * call with the need to do a fsync, because of timeout. Only one
             * will return as the leader.
             */
            int waitStatus = myGroup.waitForFsync();

            if (waitStatus == FSyncGroup.DO_LEADER_FSYNC) {
                synchronized (fsyncLatch) {

                    /*
                     * Check if there's a fsync in progress; this might happen
                     * even if you were designated the leader if a new thread
                     * came in between the point when the old leader woke you
                     * up and now. This new thread may have found that there
                     * was no fsync in progress, and may have started a fsync.
                     */
                    if (!fsyncInProgress) {
                        isLeader = true;
                        doFsync = true;
                        fsyncInProgress = true;
                        inProgressGroup = myGroup;
                        nextFSyncWaiters = new FSyncGroup(timeout, envImpl);
                    }
                }
            } else if (waitStatus == FSyncGroup.DO_TIMEOUT_FSYNC) {
                doFsync = true;
                synchronized (fsyncLatch) {
                    nTimeouts.increment();
                }
            }
        }

        if (doFsync) {

            /*
             * There are 3 ways that this fsync gets called:
             *
             * 1. A thread calls sync and there is not a sync call already in
             * progress.  That thread executes fsync for itself only.  Other
             * threads requesting sync form a group of waiters.
             *
             * 2. A sync finishes and wakes up a group of waiters.  The first
             * waiter in the group to wake up becomes the leader.  It executes
             * sync for it's group of waiters.  As above, other threads
             * requesting sync form a new group of waiters.
             *
             * 3. If members of a group of waiters have timed out, they'll all
             * just go and do their own sync for themselves.
             */
            executeFSync();

            synchronized (fsyncLatch) {
                nFSyncs.increment();
                if (isLeader) {

                    /*
                     * Wake up the group that requested the fsync before you
                     * started. They've piggybacked off your fsync.
                     */
                    inProgressGroup.wakeupAll();

                    /*
                     * Wake up a single waiter, who will become the next
                     * leader.
                     */
                    nextFSyncWaiters.wakeupOne();
                    fsyncInProgress = false;
                }
            }
        }
    }

    /*
     * Stats.
     */
    long getNFSyncRequests() {
        return nFSyncRequests.get();
    }

    long getNFSyncs() {
        return nFSyncs.get();
    }

    long getNTimeouts() {
        return nTimeouts.get();
    }

    StatGroup loadStats(StatsConfig config) {
        return stats.cloneGroup(config.getClear());
    }

    /**
     * Put the fsync execution into this method so it can be overridden for
     * testing purposes.
     */
    protected void executeFSync()
        throws DatabaseException {

        envImpl.getFileManager().syncLogEnd();
    }

    /*
     * Embodies a group of threads waiting for a common fsync. Note that
     * there's no collection here; group membership is merely that the threads
     * are all waiting on the same monitor.
     */
    static class FSyncGroup {
        static int DO_TIMEOUT_FSYNC = 0;
        static int DO_LEADER_FSYNC = 1;
        static int NO_FSYNC_NEEDED = 2;

        private volatile boolean fsyncDone;
        private long fsyncTimeout;
        private boolean leaderExists;
        private EnvironmentImpl envImpl;

        FSyncGroup(long fsyncTimeout, EnvironmentImpl envImpl) {
            this.fsyncTimeout = fsyncTimeout;
            fsyncDone = false;
            leaderExists = false;
            this.envImpl = envImpl;
        }

        synchronized boolean getLeader() {
            if (fsyncDone) {
                return false;
            } else {
                if (leaderExists) {
                    return false;
                } else {
                    leaderExists = true;
                    return true;
                }
            }
        }

        /**
         * Wait for either a turn to execute a fsync, or to find out that a
         * fsync was done on your behalf.
         *
         * @return true if the fsync wasn't done, and this thread needs to
         * execute a fsync when it wakes up. This may be true because it's the
         * leader of its group, or because the wait timed out.
         */
        synchronized int waitForFsync()
            throws ThreadInterruptedException {

            int status = 0;

            if (!fsyncDone) {
                long startTime = System.currentTimeMillis();
                while (true) {

                    try {
                        wait(fsyncTimeout);
                    } catch (InterruptedException e) {
                        throw new ThreadInterruptedException(envImpl,
                           "Unexpected interrupt while waiting for fsync", e);
                    }

                    /*
                     * This thread was awoken either by a timeout, by a notify,
                     * or by an interrupt. Is the fsync done?
                     */
                    if (fsyncDone) {
                        /* The fsync we're waiting on is done, leave. */
                        status = NO_FSYNC_NEEDED;
                        break;
                    } else {

                        /*
                         * The fsync is not done -- were we woken up to become
                         * the leader?
                         */
                        if (!leaderExists) {
                            leaderExists = true;
                            status = DO_LEADER_FSYNC;
                            break;
                        } else {

                            /*
                             * We're just a waiter. See if we're timed out or
                             * have more to wait.
                             */
                            long now = System.currentTimeMillis();
                            if ((now - startTime) > fsyncTimeout) {
                                /* we timed out. */
                                status = DO_TIMEOUT_FSYNC;
                                break;
                            }
                        }
                    }
                }
            }

            return status;
        }

        synchronized void wakeupAll() {
            fsyncDone = true;
            notifyAll();
        }

        synchronized void wakeupOne() {
            /* FindBugs whines here. */
            notify();
        }
    }
}
