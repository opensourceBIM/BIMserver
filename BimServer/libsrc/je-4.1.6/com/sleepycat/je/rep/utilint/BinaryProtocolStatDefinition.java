/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for each BinaryProtocol statistics.
 */
public class BinaryProtocolStatDefinition {

    public static final String GROUP_NAME = "BinaryProtocol";
    public static final String GROUP_DESC = 
        "Network traffic due to the replication stream.";

    public static StatDefinition N_READ_NANOS =
        new StatDefinition
        ("nReadNanos",
         "The number of nanoseconds spent reading from the network channel.");

    public static StatDefinition N_WRITE_NANOS =
        new StatDefinition
        ("nWriteNanos",
         "The number of nanoseconds spent writing to the network channel.");

    public static StatDefinition N_BYTES_READ =
        new StatDefinition
        ("nBytesRead",
         "The number of bytes of Replication Stream read over the network. " +
         "It does not include the TCP/IP overhead.");

    public static StatDefinition N_MESSAGES_READ =
        new StatDefinition
        ("nMessagesRead",
         "The number of Replication Stream messages read over the network.");

    public static StatDefinition N_BYTES_WRITTEN =
        new StatDefinition
        ("nBytesWritten", 
         "The number of Replication Stream bytes written over the network.");

    public static StatDefinition N_MESSAGES_WRITTEN =
        new StatDefinition
        ("nMessagesWritten", 
         "The number of Replication Stream messages written over the " +
         "network.");

    public static StatDefinition MESSAGE_READ_RATE = 
        new StatDefinition
        ("messagesReadPerSecond", "Incoming message throughput.");

    public static StatDefinition MESSAGE_WRITE_RATE =
        new StatDefinition
        ("messagesWrittenPerSecond", "Outgoing message throughput.");

    public static StatDefinition BYTES_READ_RATE =
        new StatDefinition
        ("bytesReadPerSecond", "Bytes read throughput.");

    public static StatDefinition BYTES_WRITE_RATE =
        new StatDefinition
        ("bytesWrittenPerSecond", "Bytes written throughput.");
}
