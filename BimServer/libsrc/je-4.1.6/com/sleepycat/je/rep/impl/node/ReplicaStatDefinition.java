/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.node;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for HA Replica statistics.
 */
public class ReplicaStatDefinition {

    public static final String GROUP_NAME = "ConsistencyTracker";
    public static final String GROUP_DESC = "Statistics on the delays " +
        "experienced by read requests at the replica in order to conform " +
        "to the specified ReplicaConsistencyPolicy.";

    public static StatDefinition N_LAG_CONSISTENCY_WAITS =
        new StatDefinition
        ("nLagConsistencyWaits",
         "Number of Transaction waits while the replica catches up in order" +
         " to meet a transaction's consistency requirement.");

    public static StatDefinition N_LAG_CONSISTENCY_WAIT_MS =
        new StatDefinition
        ("nLagConsistencyWaitMS",
         "Number of msec waited while the replica catches up in order" +
         " to meet a transaction's consistency requirement.");

    public static StatDefinition N_VLSN_CONSISTENCY_WAITS =
        new StatDefinition
        ("nVLSNConsistencyWaits",
         "Number of Transaction waits while the replica catches up in order" +
         " to receive a VLSN.");

    public static StatDefinition N_VLSN_CONSISTENCY_WAIT_MS =
        new StatDefinition
        ("nVLSNConsistencyWaitMS",
         "Number of msec waited while the replica catches up in order" +
         " to receive a VLSN.");
}
