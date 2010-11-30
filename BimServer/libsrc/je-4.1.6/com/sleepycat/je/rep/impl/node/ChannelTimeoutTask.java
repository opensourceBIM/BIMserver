/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.impl.node;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.sleepycat.je.rep.utilint.NamedChannelWithTimeout;

/**
 * The ChannelTimeoutTask ensures that all channels registered with it are
 * periodically checked to ensure that they are active. The period roughly
 * corresponds to a second, although intervening GC activity may expand this
 * period considerably. Note that elapsedMs used for timeouts is always ticked
 * up in 1 second increments. Thus multiple seconds of real time may correspond
 * to a single second of "timer time" if the system is paricularly busy, or the
 * gc has been particularly active.
 *
 * This property allows the underlying timeout implementation to compensate for
 * GC pauses in which activity on the channel at the java level would have been
 * suspended and thus reduces the number of false timeouts.
 */
public class ChannelTimeoutTask extends TimerTask {

    private final long ONE_SECOND_MS = 1000l;

    /* Elapsed time as measured by the timer task. It's always incremented
     * in one second intervals.
     */
    private long elapsedMs = 0;

    private final List<NamedChannelWithTimeout> channels =
        Collections.synchronizedList(new LinkedList<NamedChannelWithTimeout>());

    /**
     * Creates and schedules the timer task.
     * @param timer the timer associated with this task
     */
    ChannelTimeoutTask(Timer timer) {
        timer.schedule(this, ONE_SECOND_MS, ONE_SECOND_MS);
    }

    /**
     * Runs once a second checking to see if a channel is still active. Each
     * channel establishes its own timeout period using elapsedMs to check for
     * timeouts. Inactive channels are removed from the list of registered
     * channels.
     */
    @Override
    public void run() {
        elapsedMs += ONE_SECOND_MS;
        synchronized (channels) {
            for (Iterator<NamedChannelWithTimeout> i = channels.iterator();
                 i.hasNext();) {
                if (!i.next().isActive(elapsedMs)) {
                   i.remove();
                }
            }
        }
    }

    /**
     * Registers a channel so that the timer can make periodic calls to
     * isActive(). Note that closing a channel renders it inactive and causes
     * it to be removed from the list by the run() method. Consequently, there
     * is no corresponding unregister operation.
     *
     * @param channel the channel being registered.
     */
    public void register(NamedChannelWithTimeout channel) {
        channels.add(channel);
    }
}
