/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.stream;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for HA Feeder Transaction statistics.
 */
public class FeederTxnStatDefinition {

    public static final String GROUP_NAME = "FeederTxns";
    public static final String GROUP_DESC = "FeederTxns statistics";

    public static StatDefinition TXNS_ACKED =
        new StatDefinition("txnsAcked", "Number of Transaction ack'd.");

    public static StatDefinition TXNS_NOT_ACKED =
        new StatDefinition("txnsNotAcked",
                           "Number of Transactions not Ack'd.");

    public static StatDefinition ACK_WAIT_MS =
        new StatDefinition("ackWaitMS", "Total MS waited for acks.");
}
