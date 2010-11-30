/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for each SizeAwaitMap statistics.
 */
public class SizeAwaitMapStatDefinition {

    public static final String GROUP_NAME = "SizeAwaitMap";
    public static final String GROUP_DESC = "SizeAwaitMap statistics";

    public static StatDefinition N_NO_WAITS = 
        new StatDefinition
        ("nNoWaits", 
         "Number of times the map size requirement was met, and the thread " +
         "did not need to wait.");

    public static StatDefinition N_REAL_WAITS = 
        new StatDefinition
        ("nRealWaits", 
         "Number of times the map size was less than the required size, and " +
         "the thread had to wait to reach the map size.");

    public static StatDefinition N_WAIT_TIME = 
        new StatDefinition
        ("nWaitTime", 
         "Totla time (in ms) spent waiting for the map to reach the " +
         "required size.");
}
