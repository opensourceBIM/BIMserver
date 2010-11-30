/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.txn;

import com.sleepycat.je.CommitToken;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.ThreadInterruptedException;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogItem;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.rep.InsufficientAcksException;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.txn.TxnManager;
import com.sleepycat.je.utilint.VLSN;

/**
 * A MasterTxn represents a user initiated Txn executed on the Master node.
 * This class uses the hooks defined by Txn to support the durability
 * requirements of a replicated transaction on the Master.
 */
public class MasterTxn extends Txn {

    /* Holds the commit VLSN after a successful commit. */
    private VLSN commitVLSN = VLSN.NULL_VLSN;
    private final NameIdPair nameIdPair;

    /* The number of acks required by this txn commit. */
    private int requiredAckCount = -1;

    /*
     * Used to measure replicated transaction commit performance. All deltas
     * are measured relative to the start time, to minimize storage overhead.
     */

    /* The time the transaction was started. */
    private final long startMs = System.currentTimeMillis();

    /* The start relative delta time when the commit pre hook exited. */
    private int preLogCommitEndDeltaMs = 0;

    /*
     * The start relative delta time when the commit message was written to
     * the rep stream.
     */
    private int repWriteStartDeltaMs = 0;

    /* The default factory used to create MasterTxns */
    private static final MasterTxnFactory DEFAULT_FACTORY =
        new MasterTxnFactory() {

            public MasterTxn create(EnvironmentImpl envImpl,
                                    TransactionConfig config,
                                    NameIdPair nameIdPair) {
                return new MasterTxn(envImpl, config, nameIdPair);
            }
    };

    /* The current Txn Factory. */
    private static MasterTxnFactory factory = DEFAULT_FACTORY;

    public MasterTxn(EnvironmentImpl envImpl,
                     TransactionConfig config,
                     NameIdPair nameIdPair)
        throws DatabaseException {

        super(envImpl, config, ReplicationContext.MASTER);
        this.nameIdPair = nameIdPair;
    }

    /**
     * Returns the transaction commit token used to identify the transaction.
     *
     * @see com.sleepycat.je.txn.Txn#getCommitToken()
     */
    @Override
    public CommitToken getCommitToken() {
        if (commitVLSN.isNull()) {
            return null;
        }
        RepImpl repImpl = (RepImpl) envImpl;
        return new CommitToken(repImpl.getUUID(), commitVLSN.getSequence());
    }

    public VLSN getCommitVLSN() {
        return commitVLSN;
    }

    /**
     * MasterTxns use txn ids from a reserved negative space. So override
     * the default generation of ids.
     */
    @Override
    protected long generateId(TxnManager txnManager,
                              long ignore /* mandatedId */) {
        assert(ignore == 0);
        return txnManager.getNextReplicatedTxnId();
    }

    /**
     * Causes the transaction to wait until we have sufficient replicas to
     * acknowledge the commit.
     */
    @Override
    @SuppressWarnings("unused")
    protected void txnBeginHook(TransactionConfig config)
        throws DatabaseException {

        RepImpl repImpl = (RepImpl) envImpl;
        try {
            repImpl.txnBeginHook(this);
        } catch (InterruptedException e) {
            throw new ThreadInterruptedException(envImpl, e);
        }
    }

    @Override
    protected void preLogCommitHook()
        throws DatabaseException {

        requiredAckCount = getCurrentRequiredAckCount();

        /*
         * TODO: An optimization we'd like to do is to identify transactions
         * that only modify non-replicated databases, so they can avoid waiting
         * for Replica commit acks and avoid checks like the one that requires
         * that the node be a master before proceeding with the transaction.
         */
        RepImpl repImpl = (RepImpl) envImpl;
        repImpl.preLogCommitHook(this);
        preLogCommitEndDeltaMs = (int) (System.currentTimeMillis() - startMs);
    }

    @Override
    protected void postLogCommitHook(LogItem commitItem)
        throws DatabaseException {

        commitVLSN = commitItem.getHeader().getVLSN();
        try {
            RepImpl repImpl = (RepImpl) envImpl;
            repImpl.postLogCommitHook(this);
        } catch (InterruptedException e) {
            throw new ThreadInterruptedException(envImpl, e);
        }
    }

    @Override
    protected void postLogAbortHook() {

        RepImpl repImpl = (RepImpl) envImpl;
        repImpl.postLogAbortHook(this);
    }

    public int getRequiredAckCount() {
        return requiredAckCount;
    }

    public int getCurrentRequiredAckCount() {
        RepNode repNode = ((RepImpl)envImpl).getRepNode();
        return repNode.minAckNodes(getCommitDurability()) - 1;
    }

    public void resetRequiredAckCount() {
        requiredAckCount = 0;
    }

    /** A masterTxn always writes its own id into the commit or abort. */
    @Override
    protected int getReplicatorNodeId() {
        return nameIdPair.getId();
    }

    public long getStartMs() {
        return startMs;
    }

    public void stampRepWriteTime() {
        this.repWriteStartDeltaMs =
            (int)(System.currentTimeMillis() - startMs);
    }

    /**
     * Returns the amount of time it took to copy the commit record from the
     * log buffer to the rep stream. It's measured as the time interval
     * starting with the time the preCommit hook completed, to the time the
     * message write to the replication stream was initiated.
     */
    public long messageTransferMs() {
        return repWriteStartDeltaMs > 0 ?

                (repWriteStartDeltaMs - preLogCommitEndDeltaMs) :

                /*
                 * The message was invoked before the post commit hook fired.
                 */
                0;
    }

    @Override
    protected boolean
        propagatePostCommitException(DatabaseException postCommitException) {
        return (postCommitException instanceof InsufficientAcksException) ?
                true :
                super.propagatePostCommitException(postCommitException);
    }

    /* The Txn factory interface. */
    public interface MasterTxnFactory  {
        MasterTxn create(EnvironmentImpl envImpl,
                         TransactionConfig config,
                         NameIdPair nameIdPair);
    }

    /* The method used to create user Master Txns via the factory. */
    public static MasterTxn create(EnvironmentImpl envImpl,
                                   TransactionConfig config,
                                   NameIdPair nameIdPair) {
        return factory.create(envImpl, config, nameIdPair);
    }

    /**
     * Method used for unit testing.
     *
     * Sets the factory to the one supplied. If the argument is null it
     * restores the factory to the original default value.
     */
    public static void setFactory(MasterTxnFactory factory) {
        MasterTxn.factory = (factory == null) ? DEFAULT_FACTORY : factory;
    }

    @Override
    public boolean isReplicationDefined() {
        return true;
    }
}
