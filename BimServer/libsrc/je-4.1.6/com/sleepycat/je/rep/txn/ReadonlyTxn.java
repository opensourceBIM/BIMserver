/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.txn;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.LockNotAvailableException;
import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.ThreadInterruptedException;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.rep.MasterStateException;
import com.sleepycat.je.rep.ReplicaConsistencyException;
import com.sleepycat.je.rep.ReplicaWriteException;
import com.sleepycat.je.rep.ReplicatedEnvironment.State;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Txn;

/**
 * A ReadonlyTxn represents a user initiated transaction on a Replica. As its
 * name implies it is used to implement the read-only semantics for access to
 * the replicated environment on the Replica. In addition, it uses the
 * transaction hooks defined on Txn to implement the ReplicaConsistencyPolicy.
 */
public class ReadonlyTxn extends Txn {

    public ReadonlyTxn(EnvironmentImpl envImpl, TransactionConfig config)
        throws DatabaseException {

        super(envImpl, config, ReplicationContext.NO_REPLICATE);
    }

    /**
     * Provides a wrapper to screen for write locks. The use of write locks is
     * used to infer that an attempt is being made to modify a replicated
     * database. Note that this technique misses "conditional" updates, for
     * example a delete operation using a non-existent key, but we are ok with
     * that since the primary intent here is to ensure the integrity of the
     * replicated stream that is being played back at that replica and these
     * checks prevent such mishaps.
     */
    @Override
    public LockResult lockInternal(long nodeId,
                                   LockType lockType,
                                   boolean noWait,
                                   DatabaseImpl database)
        throws LockNotAvailableException, LockConflictException,
               DatabaseException {

        if (lockType.isWriteLock()) {
            final RepImpl repImpl = (RepImpl)envImpl;
            throw new ReplicaWriteException(this,
                                            repImpl.getStateChangeEvent());
        }
        return super.lockInternal(nodeId, lockType, noWait, database);
    }

    /**
     * Verifies that consistency requirements are met before allowing the
     * transaction to proceed.
     */
    @Override
    protected void txnBeginHook(TransactionConfig config)
        throws ReplicaConsistencyException, DatabaseException {

        if (!envImpl.isReplicated()) {
            return;
        }
        checkConsistency((RepImpl) envImpl, config.getConsistencyPolicy());
    }

    /**
     * Utility method used here and by ReplicaThreadLocker.
     */
    static void checkConsistency(final RepImpl repImpl,
                                 final ReplicaConsistencyPolicy policy) {
        if (State.DETACHED.equals(repImpl.getState()) ||
            State.MASTER.equals(repImpl.getState())) {
            /* Detached state, permit read-only access to the environment. */
            return;
        }
        assert (policy != null) : "Missing default consistency policy";
        try {
            policy.ensureConsistency(repImpl);
        } catch (InterruptedException e) {
            throw new ThreadInterruptedException(repImpl, e);
        } catch (MasterStateException e) {
            /*
             * Transitioned to master, while waiting for consistency, so the
             * txn is free to go ahead on the master.
             */
            return;
        }
    }

    @Override
    public boolean isReplicationDefined() {
        return true;
    }
}
