/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for JE sequence statistics.
 */
public class SequenceStatDefinition {

    public static final String GROUP_NAME = "Sequence";
    public static final String GROUP_DESC = "Sequence statistics";

    public static final StatDefinition SEQUENCE_GETS =
        new StatDefinition("nGets", 
                           "Number of times that Sequence.get was called " +
                           "successfully.");

    public static final StatDefinition SEQUENCE_CACHED_GETS =
        new StatDefinition("nCachedGets",
                           "Number of times that Sequence.get was called " +
                           "and a cached value was returned.");

    public static final StatDefinition SEQUENCE_STORED_VALUE =
        new StatDefinition("current",
                           "The current value of the sequence in the " +
                           "database.");

    public static final StatDefinition SEQUENCE_CACHE_VALUE =
        new StatDefinition("value",
                           "The current cached value of the sequence.");

    public static final StatDefinition SEQUENCE_CACHE_LAST =
        new StatDefinition("lastValue", 
                           "The last cached value of the sequence.");

    public static final StatDefinition SEQUENCE_RANGE_MIN =
        new StatDefinition("min", 
                           "The minimum permitted value of the sequence.");

    public static final StatDefinition SEQUENCE_RANGE_MAX =
        new StatDefinition("max", 
                           "The maximum permitted value of the sequence.");
    
    public static final StatDefinition SEQUENCE_CACHE_SIZE =
        new StatDefinition("cacheSize", 
                           "The mumber of values that will be cached in " +
                           "this handle.");
}
