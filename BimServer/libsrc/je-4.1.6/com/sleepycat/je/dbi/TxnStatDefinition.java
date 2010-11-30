/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for JE transaction statistics.
 */
public class TxnStatDefinition {

    public static final StatDefinition TXN_ACTIVE =
        new StatDefinition("nActive", 
                           "Number of transactions that are currently " + 
                           "active.");

    public static final StatDefinition TXN_BEGINS =
        new StatDefinition("nBegins", 
                           "Number of transactions that have begun.");

    public static final StatDefinition TXN_ABORTS =
        new StatDefinition("nAborts",
                           "Number of transactions that have aborted.");

    public static final StatDefinition TXN_COMMITS =
        new StatDefinition("nCommits",
                           "Number of transactions that have committed.");

    public static final StatDefinition TXN_XAABORTS =
        new StatDefinition("nXAAborts", 
                           "Number of XA transactions that have aborted.");

    public static final StatDefinition TXN_XAPREPARES =
        new StatDefinition("nXAPrepares", 
                           "Number of XA transactions that have been " +
                           "prepared.");

    public static final StatDefinition TXN_XACOMMITS =
        new StatDefinition("nXACommits", 
                           "Number of XA transactions that have committed.");
    
    public static final StatDefinition TXN_ACTIVE_TXNS =
        new StatDefinition("activeTxns", 
                           "Array of active transactions. Each element of " +
                           "the array is an object of type " +
                           "Transaction.Active.");
}
