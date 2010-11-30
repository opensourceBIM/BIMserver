/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import com.sleepycat.je.latch.Latch;

/**
 * A subclass of Latch that may be used for debugging performance issues.  This
 * latch can be used in place of an exclusive latch or object mutex in order to
 * see who is waiting for a latch acquisition, how long they're waiting, and
 * who the previous holder was.  It crudely writes to System.out, but this can
 * easily be changed to a java.util.Log or EventTrace as desired.  You can
 * specify a threshold for the wait and previous holder time (nanos).
 */
public class TimingLatch extends Latch {
    private static final int WAIT_THRESHOLD_NANOS = 50000;
    private static final int PREV_HOLD_THRESHOLD_NANOS = 50000;

    private long acquireTime;
    private long releaseTime;
    private Thread lastThread;
    private final boolean debug;
    private final int waitThreshold;
    private final int holdThreshold;

    public TimingLatch(String name, boolean debug) {
        super(name);
        this.debug = debug;
        this.waitThreshold = WAIT_THRESHOLD_NANOS;
        this.holdThreshold = PREV_HOLD_THRESHOLD_NANOS;
    }

    public TimingLatch(String name,
                       boolean debug,
                       int waitThreshold,
                       int holdThreshold) {
        super(name);
        this.debug = debug;
        this.waitThreshold = waitThreshold;
        this.holdThreshold = holdThreshold;
    }

    public class AcquireRequestEvent extends EventTrace {
        private long startTime;
        private String name;
        Thread us;

        public AcquireRequestEvent() {
            super();
            startTime = System.nanoTime();
            name = getName();
            us = Thread.currentThread();
        }

        public String toString() {
            StringBuffer sb =
                new StringBuffer("AcquireRequestEvent for " + name + " ");
            sb.append(us).append(" at ").
                append(String.format("%,d", startTime));
            return sb.toString();
        }
    }

    public class AcquireCompleteEvent extends EventTrace {
        private long startTime;
        private long waitTime;
        private String name;
        Thread us;

        public AcquireCompleteEvent(long startTime, long waitTime) {
            super();
            this.startTime = startTime;
            this.waitTime = waitTime;
            name = getName();
            us = Thread.currentThread();
        }

        public String toString() {
            StringBuffer sb =
                new StringBuffer("AcquireCompleteEvent for " + name + " ");
            sb.append(us).append(" at ").
                append(String.format("%,d", startTime)).
                append(" Took: ").append(String.format("%,d", waitTime));
            return sb.toString();
        }
    }

    public class ReleaseEvent extends EventTrace {
        private long startTime;
        private String name;
        Thread us;

        public ReleaseEvent(long time) {
            super();
            startTime = time;
            name = getName();
            us = Thread.currentThread();
        }

        public String toString() {
            StringBuffer sb =
                new StringBuffer("ReleaseEvent for " + name + " ");
            sb.append(us).append(" at ").
                append(String.format("%,d", startTime));
            return sb.toString();
        }
    }

    public void release() {
        releaseTime = System.nanoTime();
        EventTrace.addEvent(new ReleaseEvent(releaseTime));
        super.release();
    }

    public void acquire() {
        if (!debug) {
            super.acquire();
            return;
        }

        try {
            EventTrace.addEvent(new AcquireRequestEvent());
            if (acquireNoWait()) {
                EventTrace.addEvent
                    (new AcquireCompleteEvent(System.nanoTime(), 0));
                return;
            }

            long startWait = System.nanoTime();
            super.acquire();
            long endWait = System.nanoTime();
            long ourWaitTime = endWait - startWait;
            EventTrace.addEvent
                (new AcquireCompleteEvent(System.nanoTime(), ourWaitTime));
            long previousHoldTime = releaseTime - acquireTime;
            if (previousHoldTime > holdThreshold ||
                ourWaitTime > waitThreshold) {
                System.out.println
                    (String.format("%1tT %s waited %,d nanosec for %s\n" +
                                   " Previous held by %s for %,d nanosec.",
                                   System.currentTimeMillis(),
                                   Thread.currentThread(), ourWaitTime,
                                   getName(), lastThread, previousHoldTime));
                EventTrace.dumpEvents(System.out);
                EventTrace.disableEvents = false;
            }
        } finally {
            acquireTime = System.nanoTime();
            lastThread = Thread.currentThread();
        }
    }
}

