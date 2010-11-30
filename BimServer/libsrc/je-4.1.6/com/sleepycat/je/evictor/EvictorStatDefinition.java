/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.evictor;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for JE evictor statistics.
 */
public class EvictorStatDefinition {
    public static final String GROUP_NAME = "Cache";
    public static final String GROUP_DESC = 
        "Current size, allocations, and eviction activity.";

    /* 
     * The StatDefinitions for the nBINsEvicted* stats are generated, but 
     * share a common description.
     */
    public static final String BIN_EVICTION_TYPE_DESC =
        "Number of BINs evicted from the cache, using the specified " +
        "eviction source. As a subset of nNodesEvicted, it is an indicator " +
        "of what eviction is targeting and the activity that is instigating " +
        "eviction";

    public static final String UPPER_IN_EVICTION_TYPE_DESC =
        "Number of upper INs evicted from the cache, using the specified " +
        "eviction source. As a subset of nNodesEvicted, it is an indicator " +
        "of what eviction is targeting and the activity that is instigating " +
        "eviction";

    public static final String NUM_BATCHES_DESC = 
        "Number of attempts to evict, by type of evictor. Along with average " +
        "batch size, it serves as an indicator of what part of the system is " +
        "doing eviction work.";

    public static final String AVG_BATCH_DESC = 
        "Average units of work done by one eviction pass. Along with " +
        "the number of  batch size, it serves as an indicator of what part " +
        "of the system is doing eviction work.";

    public static final StatDefinition EVICTOR_EVICT_PASSES =
        new StatDefinition("nEvictPasses", 
                           "Number of eviction passes, an indicator of the " +
                           "eviction activity level.");

    public static final StatDefinition EVICTOR_NODES_SELECTED =
        new StatDefinition("nNodesSelected", 
                           "Number of nodes which pass the first criteria for "+
                           "eviction, an indicator of eviction efficiency. " +
                           "nNodesExplicitlyEvicted plus nBINsStripped will " +
                           "roughly equal nNodesSelected.  nNodesSelected " +
                           "will be somewhat larger than the sum because " +
                           "some selected nodes don't pass a final " +
                           "screening.");

    public static final StatDefinition EVICTOR_NODES_SCANNED =
        new StatDefinition("nNodesScanned",
                           "Number of nodes scanned in order to select the " +
                           "eviction set, an indicator of eviction overhead."); 

    public static final StatDefinition EVICTOR_NODES_EVICTED =
        new StatDefinition("nNodesEvicted",
                           "Number of nodes selected and removed from the " +
                           "cache.");

    public static final StatDefinition EVICTOR_ROOT_NODES_EVICTED =
        new StatDefinition("nRootNodesEvicted", 
                           "Number of database root nodes " +
                           "evicted.");

    public static final StatDefinition EVICTOR_BINS_STRIPPED =
        new StatDefinition("nBINsStripped",
                           "The number of BINs for which the child LNs have " +
                           "been removed (stripped) and are no longer in " +
                           "the cache. BIN stripping is the most efficient " +
                           "form of eviction.");

    public static final StatDefinition EVICTOR_REQUIRED_EVICT_BYTES =
        new StatDefinition("requiredEvictBytes",
                           "Number of bytes we need to evict in order to " +
                           "get under budget.");

    public static final StatDefinition EVICTOR_SHARED_CACHE_ENVS =
        new StatDefinition("nSharedCacheEnvironments",
                           "Number of Environments sharing the cache.");

    public static final StatDefinition LN_FETCH =
        new StatDefinition("nLNsFetch",
                           "Number of LNs (data records) requested by " +
                           "btree operations. Can be used to gauge cache " +
                           "hit/miss ratios.");

    public static final StatDefinition UPPER_IN_FETCH =
        new StatDefinition("nUpperINsFetch",
                           "Number of Upper INs (non-bottom internal nodes) " +
                           "requested by btree operations. Can be used to " +
                           "gauge cache hit/miss ratios.");

    public static final StatDefinition BIN_FETCH =
        new StatDefinition("nBINsFetch",
                           "Number of BINs (bottom internal nodes) requested "+
                           "by btree operations. Can be used to gauge cache " +
                           "hit/miss ratios.");

    public static final StatDefinition LN_FETCH_MISS =
        new StatDefinition("nLNsFetchMiss",
                           "Number of LNs (data records) requested by " +
                           "btree operations that were not in cache. Can be " +
                           "used to gauge cache hit/miss ratios.");

    public static final StatDefinition UPPER_IN_FETCH_MISS =
        new StatDefinition("nUpperINsFetchMiss",
                           "Number of Upper INs (non-bottom internal nodes) " +
                           "requested by btree operations that were not in " +
                           "cache. Can be used to gauge cache hit/miss ratios.");
    public static final StatDefinition BIN_FETCH_MISS =
        new StatDefinition("nBINsFetchMiss",
                           "Number of BINs (bottom internal nodes) requested " +
                           "by btree operations that were not in cache. Can " +
                           "be used to gauge cache hit/miss ratios.");

    public static final StatDefinition CACHED_UPPER_INS =
        new StatDefinition("nCachedUpperINs",
                           "Number of upper INs (non-bottom internal nodes) " +
                           "in cache. The cache holds INs and BINS, so this " +
                           "indicates the proportion used by each type of " +
                           "node. When used on shared environment caches, " +
                           "will only be visible via " +
                           "StatConfig.setFast(false)");
                         
    public static final StatDefinition CACHED_BINS =
        new StatDefinition("nCachedBINs",
                           "Number of BINs (bottom internal nodes) in cache. "+
                           "The cache holds INs and BINS, so this indicates " +
                           "the proportion used by each type of node. When " +
                           "used on shared environment caches, will only be " +
                           "visible via StatConfig.setFast(false)");

    public static final StatDefinition THREAD_UNAVAILABLE =
        new StatDefinition("nThreadUnavailable", 
                           "Number of eviction tasks that were submitted " +
                           "to the background evictor pool, " +
                           "but were refused because all eviction threads " +
                           "were busy. The user may want to change the size " +
                           "of the evictor pool through the " +
                           "je.evictor.*threads properties.");
                           
    public static final StatDefinition CACHED_IN_SPARSE_TARGET =
        new StatDefinition("nINSparseTarget",
                           "Number of INs that use a compact sparse array " +
                           "representation to point to child nodes " +
                           "in the cache.");

    public static final StatDefinition CACHED_IN_NO_TARGET =
        new StatDefinition("nINNoTarget",
                           "Number of INs that use a compact " +
                           "representation when none of its child nodes are" +
                           "in the cache.");

    public static final StatDefinition CACHED_IN_COMPACT_KEY =
        new StatDefinition("nINCompactKey",
                           "Number of INs that use a compact key " +
                           "representation to minimize the key object " +
                           "representation overhead.");
}
