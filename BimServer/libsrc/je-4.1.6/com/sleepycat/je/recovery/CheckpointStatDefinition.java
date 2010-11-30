/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.recovery;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for JE checkpointer statistics.
 */
public class CheckpointStatDefinition {
    public static final String GROUP_NAME = "Checkpoints";
    public static final String GROUP_DESC = 
        "Frequency and extent of checkpointing activity.";

    public static final StatDefinition CKPT_CHECKPOINTS =
        new StatDefinition("nCheckpoints", 
                           "Total number of checkpints run so far.");

    public static final StatDefinition CKPT_LAST_CKPTID =
        new StatDefinition("lastCheckpointId", "Id of the last checkpoint.");

    public static final StatDefinition CKPT_FULL_IN_FLUSH =
        new StatDefinition("nFullINFlush",
                           "Accumulated number of full INs flushed to the "+
                           "log."); 

    public static final StatDefinition CKPT_FULL_BIN_FLUSH =
        new StatDefinition("nFullBINFlush",
                           "Accumulated number of full BINs flushed to the " +
                           "log.");

    public static final StatDefinition CKPT_DELTA_IN_FLUSH =
        new StatDefinition("nDeltaINFlush", 
                           "Accumulated number of Delta INs flushed to the " +
                           "log.");

    public static final StatDefinition CKPT_LAST_CKPT_START =
        new StatDefinition("lastCheckpointStart",
                           "Location in the log of the last checkpont start.");

    public static final StatDefinition CKPT_LAST_CKPT_END =
        new StatDefinition("lastCheckpointEnd",
                           "Location in the log of the last checkpoint end.");
}
