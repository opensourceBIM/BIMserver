/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.utilint.DbLsn;

/*
 * Lock and abort LSN kept for each write locked node. Allows us to log with
 * the correct abort LSN.
 */
public class WriteLockInfo {

    /*
     * The original LSN. This is stored in the LN log entry.  May be null if
     * the node was created by this transaction.
     */
    private long abortLsn = DbLsn.NULL_LSN;

    /*
     * The original setting of the knownDeleted flag.  It parallels abortLsn.
     */
    private boolean abortKnownDeleted;

    /*
     * Size of the original log entry, or zero if abortLsn is NULL_LSN or if
     * the size is not known.  Used for obsolete counting during a commit.
     */
    private int abortLogSize;

    /*
     * The database of the node, or null if abortLsn is NULL_LSN.  Used for
     * obsolete counting during a commit.
     */
    private DatabaseImpl abortDb;

    /*
     * True if the node has never been locked before. Used so we can determine
     * when to set abortLsn.
     */
    private boolean neverLocked;

    /*
     * True if the node was created this transaction.
     */
    private boolean createdThisTxn;

    static final WriteLockInfo basicWriteLockInfo =
        new WriteLockInfo();

    public // for Sizeof
    WriteLockInfo() {
        abortLsn = DbLsn.NULL_LSN;
        abortKnownDeleted = false;
        neverLocked = true;
        createdThisTxn = false;
    }

    public boolean getAbortKnownDeleted() {
        return abortKnownDeleted;
    }

    public void setAbortKnownDeleted(boolean abortKnownDeleted) {
        this.abortKnownDeleted = abortKnownDeleted;
    }

    public long getAbortLsn() {
        return abortLsn;
    }

    public void setAbortLsn(long abortLsn) {
        this.abortLsn = abortLsn;
    }

    public DatabaseImpl getAbortDb() {
        return abortDb;
    }

    public int getAbortLogSize() {
        return abortLogSize;
    }

    public void setAbortInfo(DatabaseImpl db, int logSize) {
        abortDb = db;
        abortLogSize = logSize;
    }

    public boolean getNeverLocked() {
        return neverLocked;
    }

    public void setNeverLocked(boolean neverLocked) {
        this.neverLocked = neverLocked;
    }

    public boolean getCreatedThisTxn() {
        return createdThisTxn;
    }

    public void setCreatedThisTxn(boolean createdThisTxn) {
        this.createdThisTxn = createdThisTxn;
    }

    public void copyAbortInfo(WriteLockInfo fromInfo) {
        abortDb = fromInfo.abortDb;
        abortLogSize = fromInfo.abortLogSize;
    }

    @Override
    public String toString() {
        return "abortLsn=" +
            DbLsn.getNoFormatString(abortLsn) +
            " abortKnownDeleted=" + abortKnownDeleted +
            " neverLocked=" + neverLocked +
            " createdThisTxn=" + createdThisTxn +
            " abortLogSize=" + abortLogSize;
    }
}
