/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.latch;

/**
 * Class used to hold the debugging latchTable.
 */
public class LatchSupport {

    /* Used for debugging */
    static LatchTable latchTable = new LatchTable();

    /**
     * Only call under the assert system. This records and counts held latches.
     */
    static public int countLatchesHeld() {

        return latchTable.countLatchesHeld();
    }

    static public void dumpLatchesHeld() {

        System.out.println(latchesHeldToString());
    }

    static public String latchesHeldToString() {

        return latchTable.latchesHeldToString();
    }

    static public void clearNotes() {

        latchTable.clearNotes();
    }
}
