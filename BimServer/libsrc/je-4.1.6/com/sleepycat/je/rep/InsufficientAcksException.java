/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import com.sleepycat.je.Durability;
import com.sleepycat.je.OperationFailureException;
import com.sleepycat.je.Durability.ReplicaAckPolicy;
import com.sleepycat.je.rep.txn.MasterTxn;

/**
 * <p>
 * This exception is thrown at the time of a commit in a Master, if the Master
 * could not obtain transaction commit acknowledgments from its Replicas in
 * accordance with the {@link ReplicaAckPolicy} currently in effect. This
 * exception will never be thrown when the ReplicaAckPolicy of NONE is in
 * effect.
 * <p>
 * Note that a InsufficientAcksException does not indicate there was a failure
 * to commit the transaction on the master. The transaction has in fact been
 * successfully committed on the master at the time of the exception.
 * <p>
 * The application can handle the exception and use it to take some form of
 * administrative action. For example, it may log messages to have the
 * operations staff look into the health of the replicas or the network. Or it
 * may decide to increase the durability of the transaction on the Master by
 * ensuring that the changes are flushed to the operating system's buffers or
 * to the disk itself.
 * <p>
 * The application may additionally choose to continue to create new
 * transactions, which may succeed or fail depending on whether the underlying
 * problems have been resolved.
 *
 * @see Durability
 */
public class InsufficientAcksException extends OperationFailureException {
    private static final long serialVersionUID = 1L;

    private final int acksPending;
    private final int acksRequired;
    private final int ackTimeoutMs;
    private final String feederState;

    /**
     * @hidden
     * Creates a InsufficientAcksException.
     *
     * @param acksPending the number of missing acknowledgments
     * @param ackTimeoutMs the current acknowledgment timeout value in
     * milliseconds
     */
    public InsufficientAcksException(MasterTxn txn,
                                     int acksPending,
                                     int ackTimeoutMs,
                                     String feederState) {
        super(txn, true /*abortOnly*/,
              "Transaction: " + txn.getId() +
              "  VLSN: " + txn.getCommitVLSN() +
              ", initiated at: " + String.format("%1tT. ", txn.getStartMs()) +
              " Insufficient acks for policy:" +
              txn.getCommitDurability().getReplicaAck() + ". " +
              "Need replica acks: " + txn.getRequiredAckCount() + ". " +
              "Missing replica acks: " + acksPending + ". " +
              "Timeout: " + ackTimeoutMs + "ms. " +
              "FeederState=" + feederState,
              null /*cause*/);
        assert(acksPending <= txn.getRequiredAckCount());
        this.acksPending = acksPending;
        this.acksRequired = txn.getRequiredAckCount();
        this.ackTimeoutMs = ackTimeoutMs;
        this.feederState = feederState;
    }

    /**
     * For internal use only.
     * @hidden
     */
    private InsufficientAcksException(String message,
                                      InsufficientAcksException cause) {
        super(message, cause);
        this.acksPending = cause.acksPending;
        this.acksRequired = cause.acksRequired;
        this.ackTimeoutMs = cause.ackTimeoutMs;
        this.feederState = cause.feederState;
    }

    /**
     * For internal use only.
     * @hidden
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new InsufficientAcksException(msg, this);
    }

    /**
     * It returns the number of Replicas that did not respond with an
     * acknowledgment within the Replica commit timeout period.
     *
     * @return the number of missing acknowledgments
     */
    public int acksPending() {
        return acksPending;
    }

    /**
     * It returns the number of acknowledgments required by the commit policy.
     *
     * @return the number of acknowledgments required
     */
    public int acksRequired() {
        return acksRequired;
    }

    /**
     * Returns the acknowledgment timeout that was in effect at the time of the
     * exception.
     *
     * @return the acknowledgment timeout in milliseconds
     */
    public int ackTimeout() {
        return ackTimeoutMs;
    }
}
