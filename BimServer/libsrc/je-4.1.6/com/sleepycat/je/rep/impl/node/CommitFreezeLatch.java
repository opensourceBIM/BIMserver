/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.impl.node;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.rep.elections.Proposer.Proposal;

/**
 * Ensures that a VLSN is not advanced at this node while an election is in
 * progress. Note that this is difficult, if not impossible to achieve
 * efficiently in a distributed environment across the entire group, when
 * communications may not always be reliable. So, the implementation really
 * represents a good faith effort to freeze the VLSN. JE HA itself should be
 * able to make forward progress in the event of such a failure.
 *
 * The class coordinates three threads: the acceptor, the learner, and the
 * replay thread. There is exactly one instance of each thread per replication
 * node, so it coordinates the activity of these three threads.
 *
 * The typical serialized sequence of calls is therefore:
 *
 * latch.freeze() -- invoked in response to a Promise by an Acceptor
 * latch.vlsnEvent() -- one or more of them in response to ongoing election
 * latch.awaitThaw() -- by the replica thread waiting for the freeze to lift
 *
 * Both vlsnEvent() and awaitThaw() are NOPs in the absence of a freeze.
 *
 * @see <a href="https://sleepycat.oracle.com/trac/wiki/ElectionsImplementation#FreezingVLSNs">Freezing VLSNs</a>
 */
public class CommitFreezeLatch {

    /* The current frozen promise/vlsn pair */
    private Proposal proposal = null;

    /* Statistics */
    private int freezeCount = 0;
    private int awaitTimeoutCount = 0;
    private int awaitElectionCount = 0;

    /* The latch used internally. */
    private CountDownLatch latch = null;
    /* The end time of the freeze. */
    private long freezeEnd = 0;
    private long timeOut = DEFAULT_LATCH_TIMEOUT;

    private static long DEFAULT_LATCH_TIMEOUT = 5000; // ms

    public int getAwaitTimeoutCount() {
        return awaitTimeoutCount;
    }

    public int getAwaitElectionCount() {
        return awaitElectionCount;
    }

    public int getFreezeCount() {
        return freezeCount;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * Initiates or extends a freeze on a VLSN in response to a new election
     * that is in progress. It's invoked by the Acceptor thread.
     *
     * @param freezeProposal identifies the election that is provoking the freeze
     */
    public synchronized void freeze(Proposal freezeProposal) {
        if ((proposal != null) && (freezeProposal.compareTo(proposal) <= 0)) {
            // Older proposal ignore it.
            return;
        }
        if (latch != null) {
            /* Enable waiters who will reacquire the new latch below. */
            latch.countDown();
        }
        latch = new CountDownLatch(1);
        proposal = freezeProposal;
        freezeEnd = System.currentTimeMillis() + timeOut;
        return;
    }

    /**
     * Invoked by the Learner thread whenever it receives an election result.
     * The freeze on the VLSN is only lifted if the proposal associated with
     * the event is current, that is, it represents a proposal that is newer
     * than the one used to establish the freeze.
     *
     * @param listenerProposal identifies the election that just concluded
     */
    public synchronized void vlsnEvent(Proposal listenerProposal) {
        if (proposal == null) {
            // No VLSN to unfreeze
            return;
        }
        if (listenerProposal.compareTo(this.proposal) >= 0) {
            latch.countDown();
        }
    }

    /**
     * Clears the latch freeing any waiters.
     */
    public synchronized void clearLatch() {
        if (latch != null) {
            latch.countDown();
        }
        latch = null;
        proposal = null;
        freezeEnd = 0;
    }

    /**
     * Used to wait for an event that unfreezes the VLSN. In our case this
     * event is a message to the Learner agent announcing the result of an
     * election. Note that the latch must be re-initialized after a return from
     * this await method.
     *
     * This method is invoked by the Replay thread. Completion of an awaitThaw
     * always results in the freeze being lifted.
     *
     * @return true if the await was satisfied due to completion of an
     * election, false if no freeze was in effect, or the latch was timed out.
     *
     * @throws InterruptedException
     */
    public boolean awaitThaw()
        throws InterruptedException {

        CountDownLatch awaitLatch;
        long awaitTimeout;

        synchronized (this) {
            /* Copy out the values of interest  */
            awaitLatch = latch;
            if (awaitLatch == null) {
                return false;
            }
            awaitTimeout = this.freezeEnd - System.currentTimeMillis();
        }
        freezeCount++;

        boolean done = awaitLatch.await(awaitTimeout, TimeUnit.MILLISECONDS);

        synchronized (this) {
            if (done) {
                awaitElectionCount++;
                clearLatch();
                return true;
            }
            if (this.freezeEnd - System.currentTimeMillis() <= 0) {
                awaitTimeoutCount++;
                /* freeze end was not extended, election completed. */
                clearLatch();
                return false;
            }
        }
        /* Re-acquire the new latch and wait for the extended timeout. */
        return awaitThaw();
    }
}
