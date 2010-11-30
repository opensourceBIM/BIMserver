/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.stream;

import static com.sleepycat.je.rep.stream.FeederTxnStatDefinition.ACK_WAIT_MS;
import static com.sleepycat.je.rep.stream.FeederTxnStatDefinition.TXNS_ACKED;
import static com.sleepycat.je.rep.stream.FeederTxnStatDefinition.TXNS_NOT_ACKED;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.rep.InsufficientAcksException;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.txn.MasterTxn;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.AtomicLongStat;
import com.sleepycat.je.utilint.StatGroup;

/**
 * FeederTxns manages transactions that need acknowledgments.
 */
public class FeederTxns {

    /*
     * Tracks transactions that have not yet been acknowledged for the entire
     * replication node.
     */
    private final Map<Long, TxnInfo> txnMap;

    private final RepImpl repImpl;
    private final StatGroup statistics;
    private final AtomicLongStat txnsAcked;
    private final AtomicLongStat txnsNotAcked;
    private final AtomicLongStat ackWaitMs;

    public FeederTxns(RepImpl repImpl) {

        txnMap = new ConcurrentHashMap<Long, TxnInfo>();
        this.repImpl = repImpl;
        statistics = new StatGroup(FeederTxnStatDefinition.GROUP_NAME,
                                   FeederTxnStatDefinition.GROUP_DESC);
        txnsAcked = new AtomicLongStat(statistics, TXNS_ACKED);
        txnsNotAcked = new AtomicLongStat(statistics, TXNS_NOT_ACKED);
        ackWaitMs = new AtomicLongStat(statistics, ACK_WAIT_MS);
    }

    /**
     * Create a new TxnInfo so that transaction commit can wait onthe latch it
     * sets up.
     *
     * @param txn identifies the transaction.
     */
    public void setupForAcks(MasterTxn txn) {
        if (txn.getRequiredAckCount() == 0) {
            /* No acks called for, no setup needed. */
            return;
        }
        TxnInfo txnInfo = new TxnInfo(txn);
        TxnInfo  prevInfo = txnMap.put(txn.getId(), txnInfo);
        assert(prevInfo == null);
    }

    /**
     * Returns the transaction if it's waiting for acknowledgments. Returns
     * null otherwise.
     */
    public MasterTxn getAckTxn(long txnId) {
        TxnInfo txnInfo = txnMap.get(txnId);
        return (txnInfo == null) ? null : txnInfo.txn;
    }

    /*
     * Clears any ack requirements associated with the transaction. It's
     * typically invoked on a transaction abort.
     */
    public void clearTransactionAcks(Txn txn) {
        txnMap.remove(txn.getId());
    }

    /**
     * Notes that an acknowledgment was received from a replica.
     *
     * @param txnId the transaction that was acknowledged.
     */
    public void noteReplicaAck(long txnId) {
        TxnInfo txnInfo =  txnMap.get(txnId);
        if (txnInfo != null) {
            txnInfo.countDown();
        }
    }

    /**
     * Waits for the required number of replica acks to come through.
     *
     * @param txn identifies the transaction to wait for.
     *
     * @param timeoutMs the amount of time to wait for the acknowledgments
     * before giving up.
     *
     * @throws InsufficientAcksException if the ack requirements were not met
     */
    public void awaitReplicaAcks(MasterTxn txn, int timeoutMs)
        throws InterruptedException {

        TxnInfo txnInfo = txnMap.get(txn.getId());
        if (txnInfo == null) {
            return;
        }
        txnInfo.await(timeoutMs);
        txnMap.remove(txn.getId());
        int pendingAcks = txnInfo.getPendingAcks();

        if (pendingAcks > 0) {
            int requiredAckDelta = txn.getRequiredAckCount() -
                txn.getCurrentRequiredAckCount();
            if (requiredAckDelta >= pendingAcks) {

                /*
                 * The group size was reduced while waiting for acks and the
                 * acks received are sufficient given the new reduced group
                 * size.
                 */
                return;
            }
            throw new InsufficientAcksException
                (txn, pendingAcks, timeoutMs, repImpl.dumpState());
        }
    }

    /*
     * @see com.sleepycat.je.rep.stream.FeederSource#close()
     */
    public void close() {
        /* Free any blocked commits. */

        for (TxnInfo txnInfo : txnMap.values()) {
            long remaining = txnInfo.getPendingAcks();
            for (long i = 0; i < remaining; i++) {
                txnInfo.countDown();
            }
        }
    }

    /**
     * Used to track the latch and the transaction information associated with
     * a transaction needing an acknowledgment.
     */
    private class TxnInfo {
        /* The latch used to track transaction acknowledgments. */
        final private CountDownLatch latch;
        final MasterTxn txn;

        private TxnInfo(MasterTxn txn) {
            assert(txn != null);
            final int numRequiredAcks = txn.getRequiredAckCount();
            this.latch = (numRequiredAcks == 0) ?
                null :
                new CountDownLatch(numRequiredAcks);
            this.txn = txn;
        }

        private final boolean await(int timeoutMs)
            throws InterruptedException {

            final long start = System.currentTimeMillis();
            boolean isZero = (latch == null) ||
                latch.await(timeoutMs, TimeUnit.MILLISECONDS);
            if (isZero) {
                txnsAcked.increment();
                ackWaitMs.add(System.currentTimeMillis() - start);
            } else {
                txnsNotAcked.increment();
            }
            return isZero;
        }

        private final void countDown() {
            if (latch == null) {
                return;
            }

            latch.countDown();
        }

        private final int getPendingAcks() {
            if (latch == null) {
                return 0;
            }

            return (int) latch.getCount();
        }
    }

    public StatGroup getStats() {
        StatGroup ret = statistics.cloneGroup(false);

        return ret;
    }

    public void resetStats() {
        statistics.clear();
    }
}
