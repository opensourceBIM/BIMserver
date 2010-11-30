/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import com.sleepycat.je.log.Loggable;

/**
 * This class writes out a transaction commit or transaction end record.
 */
public class TxnCommit extends TxnEnd {
    public TxnCommit(long id, long lastLsn, int masterId) {
        super(id, lastLsn, masterId);
    }

    /**
     * For constructing from the log.
     */
    public TxnCommit() {
    }

    /*
     * Log support
     */

    protected String getTagName() {
        return "TxnCommit";
    }

    /**
     * @see Loggable#logicalEquals
     */
    public boolean logicalEquals(Loggable other) {

        if (!(other instanceof TxnCommit))
            return false;

        TxnCommit otherCommit = (TxnCommit) other;

        return ((id == otherCommit.id) && 
                (repMasterNodeId == otherCommit.repMasterNodeId));
    }
}
