/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.latch;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for JE latch statistics.
 */
public class LatchStatDefinition {

    public static final String GROUP_NAME = "Latch";
    public static final String GROUP_DESC = "Latch characteristics";

    public static final StatDefinition LATCH_NO_WAITERS =
        new StatDefinition("nLatchAcquiresNoWaiters",
                           "Number of times the latch was acquired without " +
                           "contention.");

    public static final StatDefinition LATCH_SELF_OWNED =
        new StatDefinition("nLatchAcquiresSelfOwned",
                           "Number of times the latch was acquired it " +
                           "was already owned by the caller.");

    public static final StatDefinition LATCH_CONTENTION =
        new StatDefinition("nLatchAcquiresWithContention",
                           "Number of times the latch was acquired when it " +
                           "was already owned by another thread.");

    public static final StatDefinition LATCH_NOWAIT_SUCCESS =
        new StatDefinition("nLatchAcquiresNoWaitSuccessful",
                           "Number of times acquireNoWait() was called when " +
                           "the latch was successfully acquired.");

    public static final StatDefinition LATCH_NOWAIT_UNSUCCESS =
        new StatDefinition("nLatchAcquireNoWaitUnsuccessful",
                           "Number of unsuccessful acquireNoWait() calls.");

    public static final StatDefinition LATCH_RELEASES =
        new StatDefinition("nLatchReleases", "Number of latch releases.");
}
