/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * General information for replicated nodes.
 */
public class RepImplStatDefinition {

    public static final String GROUP_NAME = "ReplicatedEnvironment";
    public static final String GROUP_DESC = 
        "General information about a replication node";

    public static final StatDefinition HARD_RECOVERY =
        new StatDefinition("hardRecoveryIncurred", 
                           "If true, this node had to truncate committed " +
                           "transactions which differed from the group's " +
                           "version of the replication stream from its log " +
                           "in order to come up.");

    public static final StatDefinition HARD_RECOVERY_INFO =
        new StatDefinition("hardRecoveryInfo",
                           "Description of the amount of log truncated " +
                           " in order to do a hard recovery.");
}