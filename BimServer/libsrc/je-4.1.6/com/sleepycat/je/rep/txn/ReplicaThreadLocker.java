/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.txn;

import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.rep.ReplicaConsistencyException;
import com.sleepycat.je.rep.ReplicaWriteException;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.ThreadLocker;

/**
 * A ReplicaThreadLocker is used with a user initiated non-transactional
 * operation on a Replica.  Like ReadonlyTxn, it enforces read-only semantics
 * and implements the ReplicaConsistencyPolicy.  Unlike ReadonlyTxn, the
 * environment default ReplicaConsistencyPolicy is enforced rather than the
 * policy specified via TransactionConfig, and this policy is enforced via the
 * openCursorHook rather than the txnBeginHook.
 */
public class ReplicaThreadLocker extends ThreadLocker {
    
    private final RepImpl repImpl;

    public ReplicaThreadLocker(final RepImpl repImpl) {
        super(repImpl);
        this.repImpl = repImpl;
    }

    /**
     * This overridden method prevents writes on a replica.  This check is
     * redundant because Cursor won't allow writes to a transactional database
     * when no Transaction is specified.  But we check here also for safety and
     * for consistency with ReadonlyTxn.
     */
    @Override
    public LockResult lockInternal(final long nodeId,
                                   final LockType lockType,
                                   final boolean noWait,
                                   final DatabaseImpl database) {
        if (lockType.isWriteLock()) {
            throw new ReplicaWriteException(this,
                                            repImpl.getStateChangeEvent());
        }
        return super.lockInternal(nodeId, lockType, noWait, database);
    }

    /**
     * Verifies that consistency requirements are met before allowing the
     * cursor to be opened.
     */
    @Override
    public void openCursorHook()
        throws ReplicaConsistencyException {

        ReadonlyTxn.checkConsistency(repImpl,
                                     repImpl.getDefaultConsistencyPolicy());
    }

    @Override
    public boolean isReplicationDefined() {
        return true;
    }
}
