/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import com.sleepycat.je.utilint.DbLsn;

/*
 * TreeLocation is a cursor like object that keeps track of a location
 * in a tree. It's used during recovery.
 */
public class TreeLocation {
    public BIN bin;         // parent BIN for the target LN
    public int index;       // index of where the LN is or should go
    public byte[] lnKey;    // the key that represents this LN in this BIN
    public long childLsn = DbLsn.NULL_LSN; // current LSN value in that slot.

    public void reset() {
        bin = null;
        index = -1;
        lnKey = null;
        childLsn = DbLsn.NULL_LSN;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("<TreeLocation bin=\"");
        if (bin == null) {
            sb.append("null");
        } else {
            sb.append(bin.getNodeId());
        }
        sb.append("\" index=\"");
        sb.append(index);
        sb.append("\" lnKey=\"");
        sb.append(Key.dumpString(lnKey,0));
        sb.append("\" childLsn=\"");
        sb.append(DbLsn.toString(childLsn));
        sb.append("\">");
        return sb.toString();
    }
}
