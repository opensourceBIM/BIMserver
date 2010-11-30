/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for JE EnvironmentImpl and MemoryBudget statistics.
 */
public class DbiStatDefinition {

    public static final String MB_GROUP_NAME = "Cache Layout";
    public static final String MB_GROUP_DESC = 
        "Allocation of resources in the cache.";

    public static final String ENV_GROUP_NAME = "Environment";
    public static final String ENV_GROUP_DESC = 
        "General environment wide statistics.";

    /* The following stat definitions are used in MemoryBudget. */
    public static final StatDefinition MB_SHARED_CACHE_TOTAL_BYTES =
        new StatDefinition("sharedCacheTotalBytes", 
                           "Total amount of the shared JE cache in use, in " +
                           "bytes."); 

    public static final StatDefinition MB_TOTAL_BYTES =
        new StatDefinition("cacheTotalBytes", 
                           "Total amount of JE cache in use, in bytes.");

    public static final StatDefinition MB_DATA_BYTES =
        new StatDefinition("dataBytes",
                           "Amount of JE cache used for holding data, keys " + 
                           "and internal Btree nodes, in bytes.");

    public static final StatDefinition MB_ADMIN_BYTES =
        new StatDefinition("adminBytes", 
                           "Number of bytes of JE cache used for log " +
                           "cleaning metadata and other administrative " +
                           "structure, in bytes.");

    public static final StatDefinition MB_LOCK_BYTES =
        new StatDefinition("lockBytes", 
                           "Number of bytes of JE cache used for holding " +
                           "locks and transactions, in bytes.");

    /* The following stat definitions are used in EnvironmentImpl. */
    public static final StatDefinition ENVIMPL_RELATCHES_REQUIRED =
        new StatDefinition("btreeRelatchesRequired",
                           "Returns the number of btree latch upgrades " +
                           "required while operating on this " +
                           "Environment. A measurement of contention.");
}
