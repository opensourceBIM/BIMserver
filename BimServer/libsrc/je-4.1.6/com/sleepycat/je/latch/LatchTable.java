/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.latch;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Table of latches by thread for debugging.
 */
class LatchTable {

    private Map<Thread,Set<Object>> latchesByThread;

    LatchTable() {

        latchesByThread = Collections.synchronizedMap
            (new WeakHashMap<Thread, Set<Object>>());
    }

    /**
     * Only call under the assert system. This records latching by thread.
     */
    boolean noteLatch(Object latch) {
        Thread cur = Thread.currentThread();

        Set<Object> threadLatches = latchesByThread.get(cur);
        if (threadLatches == null) {
            threadLatches = new HashSet<Object>();
            latchesByThread.put(cur, threadLatches);
        }
        threadLatches.add(latch);
        return true;
    }

    /**
     * Only call under the assert system. This records latching by thread.
     * @return true if unnoted successfully.
     */
    boolean unNoteLatch(Object latch, String name) {

        Thread cur = Thread.currentThread();

        Set<Object> threadLatches = latchesByThread.get(cur);

        if (threadLatches == null) {
            return false;
        } else {
            return threadLatches.remove(latch);
        }
    }

    /**
     * Only call under the assert system. This counts held latches.
     */
    int countLatchesHeld() {

        Thread cur = Thread.currentThread();
        Set<Object> threadLatches = latchesByThread.get(cur);
        if (threadLatches != null) {
            return threadLatches.size();
        } else {
            return 0;
        }
    }

    String latchesHeldToString() {

        Thread cur = Thread.currentThread();
        Set<Object> threadLatches = latchesByThread.get(cur);
        StringBuilder sb = new StringBuilder();
        if (threadLatches != null) {
            Iterator<Object> i = threadLatches.iterator();
            while (i.hasNext()) {
                sb.append(i.next()).append('\n');
            }
        }
        return sb.toString();
    }

    void clearNotes() {
        latchesByThread.clear();
    }
}
