/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

import static com.sleepycat.je.dbi.TxnStatDefinition.TXN_ABORTS;
import static com.sleepycat.je.dbi.TxnStatDefinition.TXN_ACTIVE;
import static com.sleepycat.je.dbi.TxnStatDefinition.TXN_ACTIVE_TXNS;
import static com.sleepycat.je.dbi.TxnStatDefinition.TXN_BEGINS;
import static com.sleepycat.je.dbi.TxnStatDefinition.TXN_COMMITS;
import static com.sleepycat.je.dbi.TxnStatDefinition.TXN_XAABORTS;
import static com.sleepycat.je.dbi.TxnStatDefinition.TXN_XACOMMITS;
import static com.sleepycat.je.dbi.TxnStatDefinition.TXN_XAPREPARES;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicInteger;

import javax.transaction.xa.Xid;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockStats;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.TransactionStats;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.latch.SharedLatch;
import com.sleepycat.je.utilint.ActiveTxnArrayStat;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.IntStat;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;

/**
 * Class to manage transactions.  Basically a Set of all transactions with add
 * and remove methods and a latch around the set.
 */
public class TxnManager {

    /*
     * All NullTxns share the same id so as not to eat from the id number
     * space.
     *
     * Negative transaction ids are used by the master node of a replication
     * group. That sequence begins at -10 to avoid conflict with the
     * NULL_TXN_ID and leave room for other special purpose ids.
     */
    static final long NULL_TXN_ID = -1;
    private static final long FIRST_NEGATIVE_ID = -10;
    private LockManager lockManager;
    private final EnvironmentImpl envImpl;
    private final SharedLatch allTxnsLatch;
    private final Map<Txn, Txn> allTxns;

    /* Maps Xids to Txns. */
    private final Map<Xid, Txn> allXATxns;

    /* Maps Threads to Txns when there are thread implied transactions. */
    private final Map<Thread, Transaction> thread2Txn;

    /*
     * Positive and negative transaction ids are used in a replicated system,
     * to let replicated transactions intermingle with local transactions.
     */
    private final AtomicLong lastUsedLocalTxnId;
    private final AtomicLong lastUsedReplicatedTxnId;
    private final AtomicInteger nActiveSerializable;

    /* Locker Stats */
    private StatGroup stats;
    private IntStat nActive;
    private LongStat numBegins;
    private LongStat numCommits;
    private LongStat numAborts;
    private LongStat numXAPrepares;
    private LongStat numXACommits;
    private LongStat numXAAborts;
    private ActiveTxnArrayStat activeTxns;

    public TxnManager(EnvironmentImpl envImpl) {
        if (EnvironmentImpl.getFairLatches()) {
            lockManager = new LatchedLockManager(envImpl);
        } else {
            lockManager = new SyncedLockManager(envImpl);
        }

        if (envImpl.isNoLocking()) {
            lockManager = new DummyLockManager(envImpl, lockManager);
        }

        this.envImpl = envImpl;
        allTxnsLatch = new SharedLatch("TxnManager.allTxns");
        allTxns = new ConcurrentHashMap<Txn, Txn>();
        allXATxns = Collections.synchronizedMap(new HashMap<Xid, Txn>());
        thread2Txn = new ConcurrentHashMap<Thread, Transaction>();

        lastUsedLocalTxnId = new AtomicLong(0);
        lastUsedReplicatedTxnId = new AtomicLong(FIRST_NEGATIVE_ID);
        nActiveSerializable = new AtomicInteger(0);

        /* Do the stats definition. */
        stats = new StatGroup("Transaction", "Transaction statistics");
        nActive = new IntStat(stats, TXN_ACTIVE);
        numBegins = new LongStat(stats, TXN_BEGINS);
        numCommits = new LongStat(stats, TXN_COMMITS);
        numAborts = new LongStat(stats, TXN_ABORTS);
        numXAPrepares = new LongStat(stats, TXN_XAPREPARES);
        numXACommits = new LongStat(stats, TXN_XACOMMITS);
        numXAAborts = new LongStat(stats, TXN_XAABORTS);
        activeTxns = new ActiveTxnArrayStat(stats, TXN_ACTIVE_TXNS);
    }

    /**
     * Set the txn id sequence.
     */
    public void setLastTxnId(long lastReplicatedTxnId, long lastLocalId) {
        lastUsedReplicatedTxnId.set(lastReplicatedTxnId);
        lastUsedLocalTxnId.set(lastLocalId);
    }

    /**
     * Get the last used id, for checkpoint info.
     */
    public long getLastLocalTxnId() {
        return lastUsedLocalTxnId.get();
    }

    public long getLastReplicatedTxnId() {
        return lastUsedReplicatedTxnId.get();
    }

    public long getNextReplicatedTxnId() {
        return lastUsedReplicatedTxnId.decrementAndGet();
    }

    /* @return true if this id is for a replicated txn. */
    public static boolean isReplicatedTxn(long txnId) {
        return (txnId <= FIRST_NEGATIVE_ID);
    }

    /**
     * Get the next transaction id for a non-replicated transaction. Note
     * than in the future, a replicated node could conceivable issue an
     * application level, non-replicated transaction.
     */
    long getNextTxnId() {
        return lastUsedLocalTxnId.incrementAndGet();
    }

    /*
     * Tracks the lowest replicated transaction id used during a replay of the
     * replication stream, so that it's available as the starting point if this
     * replica transitions to being the master.
     */
    public void updateFromReplay(long replayTxnId) {
        assert !envImpl.isMaster();
        assert replayTxnId < 0 :
            "replay txn id is unexpectedly positive " + replayTxnId;

        if (replayTxnId < lastUsedReplicatedTxnId.get()) {
            lastUsedReplicatedTxnId.set(replayTxnId);
        }
    }

    /**
     * Create a new transaction.
     * @param parent for nested transactions, not yet supported
     * @param txnConfig specifies txn attributes
     * @return the new txn
     */
    public Txn txnBegin(Transaction parent, TransactionConfig txnConfig)
        throws DatabaseException {

        return Txn.createUserTxn(envImpl, txnConfig);
    }

    /**
     * Give transactions and environment access to lock manager.
     */
    public LockManager getLockManager() {
        return lockManager;
    }

    /**
     * Called when txn is created.
     */
    void registerTxn(Txn txn) {
        allTxnsLatch.acquireShared();
        try {
            allTxns.put(txn, txn);
            if (txn.isSerializableIsolation()) {
                nActiveSerializable.incrementAndGet();
            }
            numBegins.increment();
        } finally {
            allTxnsLatch.release();
        }
    }

    /**
     * Called when txn ends.
     */
    void unRegisterTxn(Txn txn, boolean isCommit) {
        allTxnsLatch.acquireShared();
        try {
            allTxns.remove(txn);

            /* Remove any accumulated MemoryBudget delta for the Txn. */
            envImpl.getMemoryBudget().
                updateTxnMemoryUsage(0 - txn.getBudgetedMemorySize());
            if (isCommit) {
                numCommits.increment();
            } else {
                numAborts.increment();
            }
            if (txn.isSerializableIsolation()) {
                nActiveSerializable.decrementAndGet();
            }
        } finally {
            allTxnsLatch.release();
        }
    }

    /**
     * Called when txn is created.
     */
    public void registerXATxn(Xid xid, Txn txn, boolean isPrepare) {
        if (!allXATxns.containsKey(xid)) {
            allXATxns.put(xid, txn);
            envImpl.getMemoryBudget().updateTxnMemoryUsage
                (MemoryBudget.HASHMAP_ENTRY_OVERHEAD);
        }

        if (isPrepare) {
            numXAPrepares.increment();
        }
    }

    /**
     * Called when XATransaction is prepared.
     */
    public void notePrepare() {
        numXAPrepares.increment();
    }

    /**
     * Called when txn ends.
     *
     * @throws IllegalStateException via XAResource
     */
    void unRegisterXATxn(Xid xid, boolean isCommit)
        throws DatabaseException {

        if (allXATxns.remove(xid) == null) {
            throw new IllegalStateException
                ("XA Transaction " + xid + " is not registered.");
        }
        envImpl.getMemoryBudget().updateTxnMemoryUsage
            (0 - MemoryBudget.HASHMAP_ENTRY_OVERHEAD);
        if (isCommit) {
            numXACommits.increment();
        } else {
            numXAAborts.increment();
        }
    }

    /**
     * Retrieve a Txn object from an Xid.
     */
    public Txn getTxnFromXid(Xid xid) {
        return allXATxns.get(xid);
    }

    /**
     * Called when txn is assoc'd with this thread.
     */
    public void setTxnForThread(Transaction txn) {

        Thread curThread = Thread.currentThread();
        thread2Txn.put(curThread, txn);
    }

    /**
     * Called when txn is assoc'd with this thread.
     */
    public Transaction unsetTxnForThread() {
        Thread curThread = Thread.currentThread();
        return thread2Txn.remove(curThread);
    }

    /**
     * Retrieve a Txn object for this Thread.
     */
    public Transaction getTxnForThread() {
        return thread2Txn.get(Thread.currentThread());
    }

    public Xid[] XARecover() {
        Set<Xid> xidSet = allXATxns.keySet();
        Xid[] ret = new Xid[xidSet.size()];
        ret = xidSet.toArray(ret);

        return ret;
    }

    /**
     * Returns whether there are any active serializable transactions,
     * excluding the transaction given (if non-null).  This is intentionally
     * returned without latching, since latching would not make the act of
     * reading an integer more atomic than it already is.
     */
    public boolean
        areOtherSerializableTransactionsActive(Locker excludeLocker) {
        int exclude =
            (excludeLocker != null &&
             excludeLocker.isSerializableIsolation()) ?
            1 : 0;
        return (nActiveSerializable.get() - exclude > 0);
    }

    /**
     * Get the earliest LSN of all the active transactions, for checkpoint.
     * Returns NULL_LSN is no transaction is currently active.
     */
    public long getFirstActiveLsn() {

        /*
         * Note that the latching hierarchy calls for synchroninzing on
         * allTxns first, then synchronizing on individual txns.
         */
        long firstActive = DbLsn.NULL_LSN;
        allTxnsLatch.acquireExclusive();
        try {
            Iterator<Txn> iter = allTxns.keySet().iterator();
            while (iter.hasNext()) {
                long txnFirstActive = iter.next().getFirstActiveLsn();
                if (firstActive == DbLsn.NULL_LSN) {
                    firstActive = txnFirstActive;
                } else if (txnFirstActive != DbLsn.NULL_LSN) {
                    if (DbLsn.compareTo(txnFirstActive, firstActive) < 0) {
                        firstActive = txnFirstActive;
                    }
                }
            }
        } finally {
            allTxnsLatch.release();
        }

        return firstActive;
    }

    /*
     * Statistics
     */

    /**
     * Collect transaction related stats.
     */
    public TransactionStats txnStat(StatsConfig config) {
        TransactionStats txnStats = null;
        allTxnsLatch.acquireShared();
        try {
            nActive.set(allTxns.size());
            TransactionStats.Active[] activeSet =
                new TransactionStats.Active[nActive.get()];
            Iterator<Txn> iter = allTxns.keySet().iterator();
            int i = 0;
            while (iter.hasNext() && i < activeSet.length) {
                Locker txn = iter.next();
                activeSet[i] = new TransactionStats.Active
                    (txn.toString(), txn.getId(), 0);
                i++;
            }
            activeTxns.set(activeSet);
            txnStats = new TransactionStats(stats.cloneGroup(false));
            if (config.getClear()) {
                numCommits.clear();
                numAborts.clear();
                numXACommits.clear();
                numXAAborts.clear();
            }
        } finally {
            allTxnsLatch.release();
        }

        return txnStats;
    }

    public StatGroup loadStats(StatsConfig config) {
        return lockManager.loadStats(config);
    }

    /**
     * Collect lock related stats.
     */
    public LockStats lockStat(StatsConfig config)
        throws DatabaseException {

        return lockManager.lockStat(config);
    }
}
