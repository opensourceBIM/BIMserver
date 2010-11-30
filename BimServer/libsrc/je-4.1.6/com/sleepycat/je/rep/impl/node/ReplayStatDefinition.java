/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.node;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for HA Replay statistics.
 */
public class ReplayStatDefinition {

    public static final String GROUP_NAME = "Replay";
    public static final String GROUP_DESC = "The Replay unit applies the " +
        "incoming replication stream at a Replica. These stats show the " +
        "load the Replica incurs when processing updates.";

    public static StatDefinition N_COMMITS =
        new StatDefinition("nCommits",
                           "Number of Commits replayed by the Replica.");

    public static StatDefinition N_COMMIT_ACKS =
        new StatDefinition("nCommitAcks",
                           "Number of Commits for which the Master " +
                           "requested an ack.");

    public static StatDefinition N_COMMIT_SYNCS =
        new StatDefinition("nCommitSyncs",
                           "Number of CommitSyncs used to satisfy " +
                           "ack requests.");

    public static StatDefinition N_COMMIT_NO_SYNCS =
        new StatDefinition("nCommitNoSyncs",
                           "Number of CommitNoSyncs used to satisfy " +
                           "ack requests.");

    public static StatDefinition N_COMMIT_WRITE_NO_SYNCS =
        new StatDefinition("nCommitWriteNoSyncs",
                           "Number of CommitWriteNoSyncs used to satisfy " +
                           "ack requests.");

    public static StatDefinition N_ABORTS =
        new StatDefinition("nAborts",
                           "Number of Aborts replayed by the Replica.");

    public static StatDefinition N_LNS =
        new StatDefinition("nLNs", "Number of LNs.");

    public static StatDefinition N_NAME_LNS =
        new StatDefinition("nNameLNs", "Number of Name LNs.");

    public static StatDefinition N_ELAPSED_TXN_TIME =
        new StatDefinition("nElapsedTxnTime",
                           "The elapsed time in ms, spent" +
                           " replaying all transactions.");

    public static StatDefinition MIN_COMMIT_PROCESSING_NANOS =
        new StatDefinition("minCommitProcessingNanos",
                           "Minimum nanosecs for commit processing");

    public static StatDefinition MAX_COMMIT_PROCESSING_NANOS =
        new StatDefinition("maxCommitProcessingNanos",
                           "Maximum nanosecs for commit processing");

    public static StatDefinition TOTAL_COMMIT_PROCESSING_NANOS =
        new StatDefinition("totalCommitProcessingNanos",
                           "Total nanosecs for commit processing");

}
