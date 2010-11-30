/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.node;

import java.util.Timer;
import java.util.TimerTask;

import com.sleepycat.je.utilint.VLSN;

/**
 * We decide to move the default durability for replication to NO_SYNC, which
 * requires flushing the write buffer periodically to make sure those updates
 * are durable on the disk. LogFlusher will use the LogFlushTask, which extends
 * TimerTask to do this work.
 *
 * The period roughly corresponds to the interval specified by
 * {@link com.sleepycat.je.rep.ReplicationMutableConfig#LOG_FLUSH_TASK_INTERVAL 
 * LOG_FLUSH_TASK_INTERVAL}, although heavy GC activity or the busy system may 
 * expand this period considerably.
 */
class LogFlusher {
    private final RepNode repNode;
    private final Timer timer;
    private int flushInterval;
    private LogFlushTask flushTask;

    public LogFlusher(RepNode repNode, Timer timer) {
        this.repNode = repNode;
        this.timer = timer;
    }

    /* Config the log flushing task. */
    public void configFlushTask(int interval) {
        /* Do nothing if the configuration doesn't change. */
        if (flushInterval == interval && flushTask != null) {
            return;
        }

        /* Cancel and restart the task according to the configuration. */
        flushInterval = interval;
        cancelTask();
        flushTask = new LogFlushTask(repNode);
        timer.schedule(flushTask, 0, flushInterval);
    }

    /* Cancel the log buffer flush task. */
    public void cancelTask() {
        if (flushTask != null) {
            flushTask.cancel();
            flushTask = null;
        }
    }

    /* Used by unit tests only. */
    public int getFlushInterval() {
        return flushInterval;
    } 

    /* Used by unit tests only. */
    public LogFlushTask getFlushTask() {
        return flushTask;
    }

    /* TimerTask used to flush the log buffer periodically. */
    static class LogFlushTask extends TimerTask {
        private final RepNode repNode;
        /* The commitVLSN of the nodes when flushing the buffer last time. */
        private VLSN lastCommitVLSN;

        public LogFlushTask(RepNode repNode) {
            this.repNode = repNode;
            this.lastCommitVLSN = repNode.getCurrentCommitVLSN();
        }

        /**
         * Check the RepNode.currentCommitVLSN difference to see if there is 
         * any dirty data between two actions. We only do the flush when there 
         * exists dirty data. 
         *
         * The reason that why we only cares about the commit VLSN is those 
         * unlogged uncommitted/abort transaction will be aborted during 
         * recovery. It's useless to keep track of those VLSNs.
        */
        @Override
        public void run() {
            final VLSN newCommitVLSN = repNode.getCurrentCommitVLSN();

            /* Do nothing if no updates. */
            if (newCommitVLSN == null) {
                return;
            }

            if (lastCommitVLSN == null || 
                newCommitVLSN.compareTo(lastCommitVLSN) == 1) {
                lastCommitVLSN = newCommitVLSN;
                repNode.getRepImpl().getLogManager().flush();
            }
        }
    }
}
