/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import com.sleepycat.je.tree.LN;
import com.sleepycat.je.utilint.DbLsn;

/**
 * This class is a container to encapsulate a LockGrantType and a WriteLockInfo
 * so that they can both be returned from writeLock.
 */
public class LockResult {
    private LockGrantType grant;
    private WriteLockInfo info;
    private LN ln;

    /* Made public for unittests */
    public LockResult(LockGrantType grant, WriteLockInfo info) {
        this.grant = grant;
        this.info = info;
    }

    public LN getLN() {
        return ln;
    }

    public void setLN(LN ln) {
        this.ln = ln;
    }

    public LockGrantType getLockGrant() {
        return grant;
    }

    public void setAbortLsn(long abortLsn, boolean abortKnownDeleted) {
        setAbortLsnInternal(abortLsn, abortKnownDeleted, false);
    }

    public void setAbortLsn(long abortLsn,
                            boolean abortKnownDeleted,
                            boolean createdThisTxn) {
        setAbortLsnInternal(abortLsn, abortKnownDeleted, createdThisTxn);
    }

    private void setAbortLsnInternal(long abortLsn,
                                     boolean abortKnownDeleted,
                                     boolean createdThisTxn) {
        /* info can be null if this is called on behalf of a BasicLocker. */
        if (info != null &&
            info.getNeverLocked()) {
            /* Only set if not null, otherwise keep NULL_LSN as abortLsn. */
            if (abortLsn != DbLsn.NULL_LSN) {
                info.setAbortLsn(abortLsn);
                info.setAbortKnownDeleted(abortKnownDeleted);
            }
            info.setCreatedThisTxn(createdThisTxn);
            info.setNeverLocked(false);
        }
    }

    public void copyAbortInfo(WriteLockInfo fromInfo) {
        if (info != null) {
            info.copyAbortInfo(fromInfo);
        }
    }
}
