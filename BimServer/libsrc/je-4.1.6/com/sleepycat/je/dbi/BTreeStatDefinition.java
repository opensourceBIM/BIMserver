/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for JE Btree statistics.
 */
public class BTreeStatDefinition {

    public static final String GROUP_NAME = "BTree";
    public static final String GROUP_DESC = 
        "Composition of btree, types and counts of nodes.";

    public static final StatDefinition BTREE_BIN_COUNT =
        new StatDefinition("binCount", 
                           "Number of bottom internal nodes in " + 
                           "the database's btree.");

    public static final StatDefinition BTREE_DBIN_COUNT =
        new StatDefinition("dbinCount", 
                           "Number of duplicate bottom internal nodes in " +
                           "the database's btree.");

    public static final StatDefinition BTREE_DELETED_LN_COUNT =
        new StatDefinition("deletedLNCount",
                           "Number of deleted leaf nodes in the database's " +
                           "btree.");

    public static final StatDefinition BTREE_DUPCOUNT_LN_COUNT =
        new StatDefinition("dupCountLNCount",
                           "Number of duplicated leaf nodes in the " +
                           "database's btree.");

    public static final StatDefinition BTREE_IN_COUNT =
        new StatDefinition("inCount", 
                           "Number of internal nodes in database's btree. " +
                           "BINs are not included.");

    public static final StatDefinition BTREE_DIN_COUNT =
        new StatDefinition("dinCount", 
                           "Number of duplicated internal nodes in " +
                           "database's btree. BINs are not included.");

    public static final StatDefinition BTREE_LN_COUNT =
        new StatDefinition("lnCount", 
                           "Number of leaf nodes in the database's btree.");
    
    public static final StatDefinition BTREE_MAINTREE_MAXDEPTH =
        new StatDefinition("mainTreeMaxDepth", 
                           "Maximum depth of the in-memory tree.");

    public static final StatDefinition BTREE_DUPTREE_MAXDEPTH =
        new StatDefinition("duplicateTreeMaxDepth",
                           "Maximum depth of the duplicate memory trees.");

    public static final StatDefinition BTREE_INS_BYLEVEL =
        new StatDefinition("insByLevel",
                           "Histogram of internal nodes by level.");

    public static final StatDefinition BTREE_BINS_BYLEVEL =
        new StatDefinition("binsByLevel",
                           "Histogram of bottom internal nodes by level.");

    public static final StatDefinition BTREE_DINS_BYLEVEL =
        new StatDefinition("dinsByLevel",
                           "Histogram of duplidate internal nodes by level.");

    public static final StatDefinition BTREE_DBINS_BYLEVEL =
        new StatDefinition("dbinsByLevel",
                           "Histogram of duplicate bottom internal nodes " + 
                           "by level.");

    public static final StatDefinition BTREE_RELATCHES_REQUIRED =
        new StatDefinition("relatchesRequired",
                           "Number of latch upgrades (relatches) required.");

    public static final StatDefinition BTREE_ROOT_SPLITS =
        new StatDefinition("nRootSplits",
                           "Number of times the root was split.");
}
