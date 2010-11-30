/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.elections;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for each Proposer statistics.
 */
public class ProposerStatDefinition {

    public static final String GROUP_NAME = "Election Proposer";
    public static final String GROUP_DESC =
        "Proposals are the first stage of a replication group election.";

    public static StatDefinition PHASE1_NO_QUORUM =
        new StatDefinition
        ("phase1NoQuorum",
         "Number of times Phase 1 ended with insufficient votes for a " +
         "quorum.");

    public static StatDefinition PHASE1_NO_NON_ZERO_PRIO =
        new StatDefinition
        ("phase1NoNonZeroPrio",
         "Number of times Phase 1 ended due to the absence of " +
         "participating electable nodes with non-zero priority");

    public static StatDefinition PHASE1_HIGHER_PROPOSAL =
        new StatDefinition
        ("phase1HigherProposal",
         "Number of times Phase 1 was terminated because one of the " +
         "Acceptor agents already had a higher numbered proposal.");

    public static StatDefinition PHASE2_NO_QUORUM =
        new StatDefinition
        ("phase2NoQuorum",
         "Number of times Phase 2 ended with insufficient votes for a " +
         "quorum.");

    public static StatDefinition PHASE2_HIGHER_PROPOSAL =
        new StatDefinition
        ("phase2HigherProposal",
         "Number of times Phase 2 was terminated because one of the " +
         "Acceptor agents already had a higher numbered proposal.");

    public static StatDefinition PROMISE_COUNT =
        new StatDefinition
        ("promiseCount",
         "Number of promises made by Acceptors in phase 1.");
}
