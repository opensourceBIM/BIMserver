/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.txn;

import static com.sleepycat.je.utilint.DbLsn.NULL_LSN;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Durability;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.Durability.SyncPolicy;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.recovery.RecoveryManager;
import com.sleepycat.je.tree.TreeLocation;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.txn.TxnChain;
import com.sleepycat.je.txn.TxnManager;
import com.sleepycat.je.txn.UndoReader;
import com.sleepycat.je.txn.TxnChain.RevertInfo;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.VLSN;

/**
 * Used for replaying replicated operations at replica nodes.
 */
final public class ReplayTxn extends Txn {

    /* The time the Txn was initiated. */
    private final long startTime = System.currentTimeMillis();

    /* The time the txn was committed or aborted. Zero if in progress */
    private long endTime = 0;

    /*
     * The last VLSN applied by this txn. Used for sanity checking.
     * This field is currently not precisely set when a transaction is
     * resurrected. The sanity check could be made more robust by setting
     * this field at resurrection.
     */
    private VLSN lastApplied = VLSN.NULL_VLSN;

    /* Tracks whether the rep group db was changed by the transaction */
    private boolean repGroupDbChange = false;

    /* NodeId of the master which initiated the commit or abort. */
    private int masterNodeId;

    private Map<Long, ReplayTxn> activeTxns;

    /*
     * ReplayTxns are frequently constructed. Don't create its own logger;
     * instead, use the Replay's logger.
     */
    private Logger logger;

    /**
     * Used when creating ReplayTxns for Replay. The ReplayTxn adds itself to
     * the activeTxns map.
     */
    public ReplayTxn(EnvironmentImpl envImpl,
                     TransactionConfig config,
                     long txnId,
                     Map<Long, ReplayTxn> activeTxns,
                     Logger logger)
        throws DatabaseException {

        this(envImpl, config, txnId, logger);
        registerWithActiveTxns(activeTxns);
    }

    /**
     * Used when creating ReplayTxns at recovery. No ActiveTxns map is
     * available.
     */
    public ReplayTxn(EnvironmentImpl envImpl,
                     TransactionConfig config,
                     long txnId,
                     Logger logger)
        throws DatabaseException {

        super(envImpl,
              config,
              null,      // ReplicationContext set later
              txnId);    // mandatedId
        /* Preempt reader transactions when a lock conflict occurs. */
        setImportunate(true);
        this.logger = logger;
    }

    /**
     * Don't let the ReplayTxn have a timeout of 0. If it did, it could be
     * deadlocked against a reader txn. As long as there is a non zero timeout,
     * any conflicts will be adjugated by the LockManager in its favor.
     */
    @Override
    protected long getInitialLockTimeout() {
        return envImpl.getReplayTxnTimeout();
    }

    public boolean getRepGroupDbChange() {
        return repGroupDbChange;
    }

    public void noteRepGroupDbChange() {
        repGroupDbChange = true;
    }

    public void registerWithActiveTxns(Map<Long, ReplayTxn> newActiveTxns) {
        assert activeTxns == null;
        activeTxns = newActiveTxns;
        activeTxns.put(getId(), this);
    }

    /**
     * Replay transactions always use the txn id that is included in its
     * replicated operation.
     */
    @Override
    protected long generateId(TxnManager txnManager,
                              long mandatedId) {
        return mandatedId;
    }

    /*
     * A ReplayTxn always writes the node id of the master which generated
     * the commit or abort.
     */
    @Override
    protected int getReplicatorNodeId() {
        return masterNodeId;
    }

    /**
     * Commits the txn being replayed.
     *
     * @param syncPolicy to be used for the commit.
     * @param clientRepContext the replication context it encapsulates the VLSN
     * associated with the txn.
     *
     * @return the commit LSN
     * @throws DatabaseException
     */
    public long commit(SyncPolicy syncPolicy,
                       ReplicationContext clientRepContext,
                       int commitMasterNodeId)
        throws DatabaseException {

        LoggerUtils.fine(logger, envImpl, "commit called for " + getId());
        setRepContext(clientRepContext);
        Durability durability = null;
        if (syncPolicy == SyncPolicy.SYNC) {
            durability = Durability.COMMIT_SYNC;
        } else if (syncPolicy == SyncPolicy.NO_SYNC) {
            durability = Durability.COMMIT_NO_SYNC;
        } else if (syncPolicy == SyncPolicy.WRITE_NO_SYNC) {
            durability = Durability.COMMIT_WRITE_NO_SYNC;
        } else {
            throw EnvironmentFailureException.unexpectedState
                ("Unknown sync policy: " + syncPolicy);
        }

        /*
         * Set the master id before commit is called, so getReplicatorNodeId()
         * will return this value and write the originating node's id into
         * the commit record on this log.
         */
        this.masterNodeId = commitMasterNodeId;
        long lsn = super.commit(durability);
        endTime = System.currentTimeMillis();

        return lsn;
    }

    @Override
    public long commit() {
        throw EnvironmentFailureException.unexpectedState
            ("Replay Txn abort semantics require use of internal commit api");
    }

    @Override
    @SuppressWarnings("unused")
    public long commit(Durability durability) {
        throw EnvironmentFailureException.unexpectedState
            ("Replay Txn abort semantics require use of internal commit api");
    }

    @Override
    public void abort() {
        throw EnvironmentFailureException.unexpectedState
            ("Replay Txn abort semantics require use of internal abort api");
    }

    @Override
    @SuppressWarnings("unused")
    public long abort(boolean forceFlush) {
        throw EnvironmentFailureException.unexpectedState
            ("Replay Txn abort semantics require use of internal abort api");
    }

    public long abort(ReplicationContext clientRepContext,
                      int abortMasterNodeId)
        throws DatabaseException {

        setRepContext(clientRepContext);

        /*
         * Set the master id before abort is called, so getReplicatorNodeId()
         * will return this value and write the originating node's id into
         * the abort record on this log.
         */
        this.masterNodeId = abortMasterNodeId;
        long lsn = super.abort(false /* forceFlush */);
        endTime = System.currentTimeMillis();

        return lsn;
    }

    @Override
    protected void close(boolean isCommit)
        throws DatabaseException {

        super.close(isCommit);

        if (activeTxns != null) {
            Txn removed = activeTxns.remove(getId());
            assert removed != null : "txn was not in map " + this + " " +
                LoggerUtils.getStackTrace();
        }
    }

    /**
     * Invoked when a ReplayTxn is being abandoned on shutdown.
     */
    public void cleanup()
        throws DatabaseException {
        releaseWriteLocks();
        /* Close the transaction thus causing it to be unregistered. */
        close(false);
    }

    /**
     * Rollback all write operations that are logged with an LSN > the
     * matchpointLsn parameter. This is logically a truncation of the log
     * entries written by this transaction. Any log entries created by this
     * transaction are marked obsolete.
     *
     * Note that this is by no means a complete implementation of what would be
     * needed to support user visible savepoints. This method only rolls back
     * write operations and doesn't handle other types of state, like read
     * locks and open cursors.
     *
     * There are several key assumptions:
     * - the transaction does not hold read locks.
     * - the transaction will either be resumed, and any rolled back
     * operations will be repeated, or the transaction will be aborted
     * in its entirety.
     *
     * If all operations in the transaction are rolled back, this transaction
     * is also unregistered and closed.
     *
     * Rolling back a log entry through rollback is akin to truncating the
     * transactional log. The on-disk entries should not be referred to by
     * anything in the in-memory tree or the transaction chain. JE's append
     * only storage and the fact that the transactional log entries are
     * intertwined through the physical log prohibits any log truncation. To
     * mimic log truncation, any rolled back log entry is marked as
     * obsolete. Since only the last version of any data record is alive,
     * any future uses of this transaction must use the obsoleteDupsAllowed
     * option (see Txn.countObsoleteExact) to prevent asserts about duplicate
     * obsolete offsets. For example, suppose the transaction logs this:
     *
     * 100 LNa (version1)
     * 200 LNa (version2)
     * 300 LNa (version3)
     *
     * At this point in time, LSN 100 and 200 are obsolete.
     *
     * Now, suppose we roll back to LSN 100. LSNs 200 and 300 are marked
     * obsolete by the rollback.(although LSN 200 was already obsolete).  It is
     * true that for an instance in time LSN 100 is incorrectly marked as
     * obsolete, when it's really alive. But this transaction is going to
     * either abort or resume exactly as it was before, so LSN 100 is going to
     * be obsolete again.
     *
     * Suppose txn.abort() is called. The abort() logic will mark LSN 100 as
     * obsolete, since it is the latest version of the record in the
     * transaction. Using the obsoleteDupsAllowed option avoids an assertion on
     * the double recording of LSN 100.
     *
     * Alternatively, suppose LNa (version2) is retransmitted and logged as LSN
     * 400. Normal execution of LN.log() marks LSN 100 as obsolete, which would
     * trigger the assertion were it not for obsoleteDupsAllowed.
     *
     * @return list of LSNs that were rolled back
     */
    public Collection<Long> rollback(long matchpointLsn)
        throws DatabaseException {

        List<Long> rollbackLsns = new ArrayList<Long>();
        LoggerUtils.finest(logger, envImpl, "Partial Rollback of " + this);
        synchronized (this) {
            checkState(true);

            /* This transaction didn't log anything, nothing to rollback. */
            if (lastLoggedLsn == NULL_LSN) {
                return rollbackLsns;
            }

            /*
             * This transaction doesn't include any operations that are after
             * the matchpointLsn. There is nothing to rollback.
             */
            if (DbLsn.compareTo(lastLoggedLsn, matchpointLsn) <= 0) {
                return rollbackLsns;
            }

            setRollback();
            undoWrites(matchpointLsn, rollbackLsns);
        }

        /*
         * The call to undoWrites() may have rolled everything back, and set
         * lastLoggedLsn to NULL_LSN.
         */
        if (lastLoggedLsn == NULL_LSN) {
            /* Everything was rolled back. */
            try {

                /*
                 * Purge any databaseImpls not needed as a result of the abort.
                 * Be sure to do this outside the synchronization block, to
                 * avoid conflict w/checkpointer.
                 */
                cleanupDatabaseImpls(false);
            } finally {
                close(false /* isCommit */);
            }
        }

        /*
         * We don't expect there to be any database handles associated with
         * a ReplayTxn, because only DatabaseImpls are used. Because of that,
         * there should be no cleanup needed.
         */
        if (handleToHandleLockMap != null) {
            throw EnvironmentFailureException.unexpectedState
                ("Replay Txn " + getId() + " has a handleToHandleLockMap");
        }

        /* 
         * There is no need to call cleanupDatabaseImpls if the txn still holds
         * locks. The operations in this txn will either be entirely aborted,
         * or will be repeated, so any cleanup will happen when the txn ends.
         */
        return rollbackLsns;
    }

    /**
     * Rollback the changes to this txn's write locked nodes up to but not
     * including the entry at the specified matchpoint. When we log a
     * transactional entry, we record the LSN of the original,
     * before-this-transaction version as the abort LSN. This means that if
     * there are multiple updates to a given record in a single transaction,
     * each update only references that original version and its true
     * predecessor.
     *
     * This was done to streamline abort processing, so that an undo reverts
     * directly to the original version rather than stepping through all the
     * intermediates. The intermediates are skipped.  However, undo to a
     * matchpoint may need to stop at an intermediate point, so we need to
     * create a true chain of versions.
     *
     * To do so, we read the transaction backwards from the last logged LSN
     * to reconstruct a transaction chain that links intermediate versions
     * of records. For example, suppose our transaction looks like this and
     * that we are undoing up to LSN 250
     *
     * lsn=100 node=A (version 1)
     * lsn=200 node=B (version 1)
     *                        <-- matchpointLsn
     * lsn=300 node=C (version 1)
     * lsn=400 node=A (version 2)
     * lsn=500 node=B (version 2)
     * lsn=600 node=A (version 3)
     * lsn=700 node=A (version 4)
     *
     * To setup the old versions, We walk from LSN 700 -> 100
     *   700 (A) rolls back to 600
     *   600 (A) rolls back to 400
     *   500 (B) rolls back to 200
     *   400 (A) rolls back to 100
     *   300 (C) rolls back to an empty slot (NULL_LSN).
     *
     * A partial rollback also requires resetting the lastLoggedLsn field,
     * because these operations are no longer in the btree and their on-disk
     * entries are no longer valid.
     *
     * Lastly, the appropriate write locks must be released.
     * @param matchpointLsn the rollback should go up to but not include this
     * LSN.
     */
    private void undoWrites(long matchpointLsn, List<Long> rollbackLsns)
        throws DatabaseException {

        /*
         * Generate a map of nodeId->List of intermediate LSNs for this node.
         * to re-create the transaction chain.
         */
        TreeLocation location = new TreeLocation();
        Long undoLsn = lastLoggedLsn;
        TxnChain chain = 
            new TxnChain(undoLsn, id, matchpointLsn, undoDatabases, envImpl);

        try {
            while ((undoLsn != DbLsn.NULL_LSN) &&
                    DbLsn.compareTo(undoLsn, matchpointLsn) > 0) {

                UndoReader undo = 
                    new UndoReader(envImpl, undoLsn, undoDatabases);

                RevertInfo revertTo = chain.pop();

                logFinest(undoLsn, undo, revertTo);

                /*
                 * When we undo this log entry, we've logically truncated
                 * it from the log. Remove it from the btree and mark it
                 * obsolete.
                 */
                RecoveryManager.rollbackUndo
                    (logger, Level.FINER, undo, revertTo, location, undoLsn);

                countObsoleteInexact(undoLsn, undo);
                rollbackLsns.add(undoLsn);

                /*
                 * Move on to the previous log entry for this txn and update
                 * what is considered to be the end of the transaction chain.
                 */
                undoLsn = undo.logEntry.getUserTxn().getLastLsn();
                lastLoggedLsn = undoLsn;
            }

            /*
             * Correct the fields which hold LSN and VLSN state that may
             * now be changed.
             */
            lastApplied = chain.getLastValidVLSN();
            if (!updateLoggedForTxn()) {
                firstLoggedLsn = NULL_LSN;
            }

        } catch (DatabaseException e) {
            LoggerUtils.traceAndLogException(envImpl, "Txn", "undo",
                                     "For LSN=" +
                                     DbLsn.getNoFormatString(undoLsn), e);
            throw e;
        } catch (RuntimeException e) {
            throw EnvironmentFailureException.unexpectedException
                ("Txn undo for LSN=" + DbLsn.getNoFormatString(undoLsn), e);
        }

        if (lastLoggedLsn == DbLsn.NULL_LSN) {
            /* 
             * The whole txn is rolled back, and it may not appear again. This
             * is the equivalent of an abort. Do any delete processing for an
             * abort which is needed.
             *
             * Set database state for deletes before releasing any write
             * locks. 
             */
            setDeletedDatabaseState(false);
        }

        /* Clear any write locks that are no longer needed. */
        clearWriteLocks(chain.getRemainingLockedNodes());
    }

    /**
     * Count an LN obsolete that is being made invisble by rollback.
     *
     * Use inexact counting.  Since invisible entries are not processed by the
     * cleaner, recording the obsolete offset would be a waste of resources.
     * Since we don't count offsets, we don't need to worry about duplicate
     * offsets.
     *
     * Some entries may be double counted if they were previously counted
     * obsolete, for example, when multiple versions of an LN were logged.
     * This is tolerated for an exceptional situation like rollback.
     */
    private void countObsoleteInexact(long undoLsn, UndoReader undo) {

        /*
         * Deleted LNs are counted as obsolete when they are logged, so no
         * need to repeat here.
         */
        if (undo.ln.isDeleted())
            return;

        envImpl.getLogManager().countObsoleteNode(undoLsn,
                                                  null, /*type*/
                                                  undo.ln.getLastLoggedSize(),
                                                  undo.db,
                                                  false /*countExact*/);
    }

    /**
     * Returns the elapsed time associated with this transaction. If the
     * transaction is in progress, it returns the running elapsed time.
     *
     * @return the elapsed time as above.
     */
    public long elapsedTime() {
        return ((endTime > 0) ? endTime : System.currentTimeMillis()) -
            startTime;
    }

    public void setLastAppliedVLSN(VLSN justApplied) {
        if (justApplied.compareTo(lastApplied) <= 0) {
            throw EnvironmentFailureException.unexpectedState
                ("Txn " + getId() + " attempted VLSN = " + justApplied +
                 " txnLastApplied = " +  lastApplied);
        }
        this.lastApplied = justApplied;
    }

    /**
     * ReplicatedTxns set it when the txn commit
     * or abort arrives.
     */
    public void setRepContext(ReplicationContext repContext) {
        this.repContext = repContext;
    }

    /* Wrap the call to logger to reduce runtime overhead. */
    private void logFinest(long lsn, UndoReader undo, RevertInfo revertTo) {
        if ((logger != null) && (logger.isLoggable(Level.FINEST))) {
            LoggerUtils.finest(logger, envImpl,
                               "undoLsn=" + DbLsn.getNoFormatString(lsn) +
                               " undo=" + undo + " revertInfo=" + revertTo);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<ReplayTxn id=\"");
        sb.append(id);
        sb.append("\">");
        sb.append(super.toString());
        return sb.toString();
    }

    @Override
    public boolean isReplicationDefined() {
        return true;
    }
}
