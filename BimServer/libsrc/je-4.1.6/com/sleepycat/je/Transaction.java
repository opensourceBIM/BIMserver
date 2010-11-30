/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.concurrent.TimeUnit;

import com.sleepycat.je.Durability.ReplicaAckPolicy;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.PropUtil;

/**
 * The Transaction object is the handle for a transaction.  Methods off the
 * transaction handle are used to configure, abort and commit the transaction.
 * Transaction handles are provided to other Berkeley DB methods in order to
 * transactionally protect those operations.
 *
 * <p>A single Transaction may be used to protect operations for any number of
 * Databases in a given environment.  However, a single Transaction may not be
 * used for operations in more than one distinct environment.</p>
 *
 * <p>Transaction handles are free-threaded; transactions handles may be used
 * concurrently by multiple threads. Once the {@link Transaction#abort
 * Transaction.abort} or {@link Transaction#commit Transaction.commit} method
 * is called, the handle may not be accessed again, regardless of the success
 * or failure of the method, with one exception:  the {@code abort} method may
 * be called any number of times to simplify error handling.</p>
 *
 * <p>To obtain a transaction with default attributes:</p>
 *
 * <blockquote><pre>
 *     Transaction txn = myEnvironment.beginTransaction(null, null);
 * </pre></blockquote>
 *
 * <p>To customize the attributes of a transaction:</p>
 *
 * <blockquote><pre>
 *     TransactionConfig config = new TransactionConfig();
 *     config.setReadUncommitted(true);
 *     Transaction txn = myEnvironment.beginTransaction(null, config);
 * </pre></blockquote>
 */
public class Transaction {

    private Txn txn;
    private final Environment env;
    private final long id;
    private String name;

    /*
     * It's set upon a successful updating replicated commit and identifies the
     * VLSN associated with the commit entry.
     */
    private CommitToken commitToken = null;

    /**
     * Creates a transaction.
     */
    protected Transaction(Environment env, Txn txn) {
        this.env = env;
        this.txn = txn;

        /*
         * Copy the id to this wrapper object so the id will be available
         * after the transaction is closed and the txn field is nulled.
         */
        this.id = txn.getId();
    }

    /**
     * Cause an abnormal termination of the transaction.
     *
     * <p>The log is played backward, and any necessary undo operations are
     * done. Before Transaction.abort returns, any locks held by the
     * transaction will have been released.</p>
     *
     * <p>In the case of nested transactions, aborting a parent transaction
     * causes all children (unresolved or not) of the parent transaction to be
     * aborted.</p>
     *
     * <p>All cursors opened within the transaction must be closed before the
     * transaction is aborted.</p>
     *
     * <p>After this method has been called, regardless of its return, the
     * {@link Transaction} handle may not be accessed again, with one
     * exception:  the {@code abort} method itself may be called any number of
     * times to simplify error handling.</p>
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the environment has been closed, or
     * cursors associated with the transaction are still open.
     */
    public void abort()
        throws DatabaseException {

        try {
            checkEnv();

            /*
             * If the transaction is already closed, do nothing.  Do not call
             * checkOpen in order to support any number of calls to abort().
             */
            if (txn == null) {
                return;
            }

            env.removeReferringHandle(this);
            txn.abort();

            /* Remove reference to internal txn, so we can reclaim memory. */
            txn = null;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(env).invalidate(E);
            throw E;
        }
    }

    /**
     * Return the transaction's unique ID.
     *
     * @return The transaction's unique ID.
     */
    public long getId() {
        return id;
    }

    /**
     * This method is intended for use with a replicated environment.
     * <p>
     * It returns the commitToken associated with a successful replicated
     * commit. A null value is returned if the txn was not associated with a
     * replicated environment, or the txn did not result in any changes to the
     * environment. This method should only be called after the transaction
     * has finished.
     * <p>
     * This method is typically used in conjunction with the <code>
     * CommitPointConsistencyPolicy</code>.
     *
     * @return the token used to identify the replicated commit. Return null if
     * the transaction has aborted, or has committed without making any
     * updates.
     *
     * @throws IllegalStateException if the method is called before the
     * transaction has committed or aborted.
     *
     * @see com.sleepycat.je.rep.CommitPointConsistencyPolicy
     */
    public CommitToken getCommitToken() 
        throws IllegalStateException {

        if (txn == null) {

            /* 
             * The commit token is only legitimate after the transaction is
             * closed. A null txn field means the transaction is closed.
             */
            return commitToken; 
        }
        
        throw new IllegalStateException
           ("This transaction is still in progress and a commit token " +
            "is not available");
    }

    /**
     * End the transaction.  If the environment is configured for synchronous
     * commit, the transaction will be committed synchronously to stable
     * storage before the call returns.  This means the transaction will
     * exhibit all of the ACID (atomicity, consistency, isolation, and
     * durability) properties.
     *
     * <p>If the environment is not configured for synchronous commit, the
     * commit will not necessarily have been committed to stable storage before
     * the call returns.  This means the transaction will exhibit the ACI
     * (atomicity, consistency, and isolation) properties, but not D
     * (durability); that is, database integrity will be maintained, but it is
     * possible this transaction may be undone during recovery.</p>
     *
     * <p>All cursors opened within the transaction must be closed before the
     * transaction is committed.</p>
     *
     * <p>If the method encounters an error, the transaction <!-- and all child
     * transactions of the transaction --> will have been aborted when the call
     * returns.</p>
     *
     * <p>After this method has been called, regardless of its return, the
     * {@link Transaction} handle may not be accessed again, with one
     * exception:  the {@code abort} method may be called any number of times
     * to simplify error handling.</p>
     *
     * @throws com.sleepycat.je.rep.InsufficientReplicasException if the master
     * in a replicated environment could not contact a quorum of replicas as
     * determined by the {@link ReplicaAckPolicy}. The application must abort
     * the transaction and can choose to retry it.
     *
     * @throws com.sleepycat.je.rep.InsufficientAcksException if the master in
     * a replicated environment did not receive enough replica acknowledgments,
     * although the commit succeeded locally.
     *
     * @throws com.sleepycat.je.rep.ReplicaWriteException if a write operation
     * was performed with this transaction, but this node is now a Replica.
     *
     * @throws OperationFailureException if this exception occurred earlier and
     * caused the transaction to be invalidated.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the transaction or environment has been
     * closed, or cursors associated with the transaction are still open.
     */
    public void commit()
        throws DatabaseException {

        try {
            checkEnv();
            checkOpen();
            env.removeReferringHandle(this);
            txn.commit();
            commitToken = txn.getCommitToken();
            /* Remove reference to internal txn, so we can reclaim memory. */
            txn = null;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(env).invalidate(E);
            throw E;
        }
    }

    /**
     * End the transaction using the specified durability requirements. This
     * requirement overrides any default durability requirements associated
     * with the environment. If the durability requirements cannot be satisfied,
     * an exception is thrown to describe the problem. Please see
     * {@link Durability} for specific exceptions that could result when the
     * durability requirements cannot be satisfied.
     *
     * <p>All cursors opened within the transaction must be closed before the
     * transaction is committed.</p>
     *
     * <p>If the method encounters an error, the transaction <!-- and all child
     * transactions of the transaction --> will have been aborted when the call
     * returns.</p>
     *
     * <p>After this method has been called, regardless of its return, the
     * {@link Transaction} handle may not be accessed again, with one
     * exception:  the {@code abort} method may be called any number of times
     * to simplify error handling.</p>
     *
     * @param durability the durability requirements for this transaction
     *
     * @throws com.sleepycat.je.rep.InsufficientReplicasException if the master
     * in a replicated environment could not contact enough replicas to
     * initiate the commit.
     *
     * @throws com.sleepycat.je.rep.InsufficientAcksException if the master in
     * a replicated environment did not receive enough replica acknowledgments,
     * althought the commit succeeded locally.
     *
     * @throws com.sleepycat.je.rep.ReplicaWriteException if a write operation
     * was performed with this transaction, but this node is now a Replica.
     *
     * @throws OperationFailureException if this exception occurred earlier and
     * caused the transaction to be invalidated.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the transaction or environment has been
     * closed, or cursors associated with the transaction are still open.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public void commit(Durability durability)
        throws DatabaseException {

        doCommit(durability, false /* explicitSync */);
    }

    /**
     * End the transaction, writing to stable storage and committing
     * synchronously.  This means the transaction will exhibit all of the ACID
     * (atomicity, consistency, isolation, and durability) properties.
     *
     * <p>This behavior is the default for database environments unless
     * otherwise configured using the {@link
     * com.sleepycat.je.EnvironmentConfig#setTxnNoSync
     * EnvironmentConfig.setTxnNoSync} method.  This behavior may also be set
     * for a single transaction using the {@link
     * com.sleepycat.je.Environment#beginTransaction
     * Environment.beginTransaction} method.  Any value specified to this
     * method overrides both of those settings.</p>
     *
     * <p>All cursors opened within the transaction must be closed before the
     * transaction is committed.</p>
     *
     * <p>If the method encounters an error, the transaction <!-- and all child
     * transactions of the transaction --> will have been aborted when the call
     * returns.</p>
     *
     * <p>After this method has been called, regardless of its return, the
     * {@link Transaction} handle may not be accessed again, with one
     * exception:  the {@code abort} method may be called any number of times
     * to simplify error handling.</p>
     *
     * @throws com.sleepycat.je.rep.InsufficientReplicasException if the master
     * in a replicated environment could not contact enough replicas to
     * initiate the commit.
     *
     * @throws com.sleepycat.je.rep.InsufficientAcksException if the master in
     * a replicated environment did not receive enough replica acknowledgments,
     * althought the commit succeeded locally.
     *
     * @throws com.sleepycat.je.rep.ReplicaWriteException if a write operation
     * was performed with this transaction, but this node is now a Replica.
     *
     * @throws OperationFailureException if this exception occurred earlier and
     * caused the transaction to be invalidated.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the transaction or environment has been
     * closed, or cursors associated with the transaction are still open.
     */
    public void commitSync()
        throws DatabaseException {

        doCommit(Durability.COMMIT_SYNC, true /* explicitSync */);
    }

    /**
     * End the transaction, not writing to stable storage and not committing
     * synchronously. This means the transaction will exhibit the ACI
     * (atomicity, consistency, and isolation) properties, but not D
     * (durability); that is, database integrity will be maintained, but it is
     * possible this transaction may be undone during recovery.
     *
     * <p>This behavior may be set for a database environment using the {@link
     * com.sleepycat.je.EnvironmentConfig#setTxnNoSync
     * EnvironmentConfig.setTxnNoSync} method or for a single transaction using
     * the {@link com.sleepycat.je.Environment#beginTransaction
     * Environment.beginTransaction} method.  Any value specified to this
     * method overrides both of those settings.</p>
     *
     * <p>All cursors opened within the transaction must be closed before the
     * transaction is committed.</p>
     *
     * <p>If the method encounters an error, the transaction <!-- and all child
     * transactions of the transaction --> will have been aborted when the call
     * returns.</p>
     *
     * <p>After this method has been called, regardless of its return, the
     * {@link Transaction} handle may not be accessed again, with one
     * exception:  the {@code abort} method may be called any number of times
     * to simplify error handling.</p>
     *
     * @throws com.sleepycat.je.rep.InsufficientReplicasException if the master
     * in a replicated environment could not contact enough replicas to
     * initiate the commit.
     *
     * @throws com.sleepycat.je.rep.InsufficientAcksException if the master in
     * a replicated environment did not receive enough replica acknowledgments,
     * althought the commit succeeded locally.
     *
     * @throws com.sleepycat.je.rep.ReplicaWriteException if a write operation
     * was performed with this transaction, but this node is now a Replica.
     *
     * @throws OperationFailureException if this exception occurred earlier and
     * caused the transaction to be invalidated.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the transaction or environment has been
     * closed, or cursors associated with the transaction are still open.
     */
    public void commitNoSync()
        throws DatabaseException {

        doCommit(Durability.COMMIT_NO_SYNC, true /* explicitSync */);
    }

    /**
     * End the transaction, writing to stable storage but not committing
     * synchronously.  This means the transaction will exhibit the ACI
     * (atomicity, consistency, and isolation) properties, but not D
     * (durability); that is, database integrity will be maintained, but it is
     * possible this transaction may be undone during recovery.
     *
     * <p>This behavior is the default for database environments unless
     * otherwise configured using the {@link
     * com.sleepycat.je.EnvironmentConfig#setTxnNoSync
     * EnvironmentConfig.setTxnNoSync} method.  This behavior may also be set
     * for a single transaction using the {@link
     * com.sleepycat.je.Environment#beginTransaction
     * Environment.beginTransaction} method.  Any value specified to this
     * method overrides both of those settings.</p>
     *
     * <p>All cursors opened within the transaction must be closed before the
     * transaction is committed.</p>
     *
     * <p>If the method encounters an error, the transaction <!-- and all child
     * transactions of the transaction --> will have been aborted when the call
     * returns.</p>
     *
     * <p>After this method has been called, regardless of its return, the
     * {@link Transaction} handle may not be accessed again, with one
     * exception:  the {@code abort} method may be called any number of times
     * to simplify error handling.</p>
     *
     * @throws com.sleepycat.je.rep.InsufficientReplicasException if the master
     * in a replicated environment could not contact enough replicas to
     * initiate the commit.
     *
     * @throws com.sleepycat.je.rep.InsufficientAcksException if the master in
     * a replicated environment did not receive enough replica acknowledgments,
     * althought the commit succeeded locally.
     *
     * @throws com.sleepycat.je.rep.ReplicaWriteException if a write operation
     * was performed with this transaction, but this node is now a Replica.
     *
     * @throws OperationFailureException if this exception occurred earlier and
     * caused the transaction to be invalidated.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the transaction or environment has been
     * closed, or cursors associated with the transaction are still open.
     */
    public void commitWriteNoSync()
        throws DatabaseException {

        doCommit(Durability.COMMIT_WRITE_NO_SYNC, true /* explicitSync */);
    }

    /**
     * For internal use.
     * @hidden
     */
    public boolean getPrepared() {
        return txn.getPrepared();
    }

    /**
     * Perform error checking and invoke the commit on Txn.
     *
     * @param durability the durability to use for the commit
     * @param explicitSync true if the method was invoked from one of the
     * sync-specific APIs, false if durability was used explicitly. This
     * parameter exists solely to support mixed mode api usage checks.
     *
     * @throws IllegalArgumentException via commit(Durability)
     */
    private void doCommit(Durability durability, boolean explicitSync) {
        try {
            checkEnv();
            checkOpen();
            env.removeReferringHandle(this);
            if (explicitSync) {
                /* A sync-specific api was invoked. */
                if (txn.getExplicitDurabilityConfigured()) {
                    throw new IllegalArgumentException
                        ("Mixed use of deprecated durability API for the " +
                         "transaction commit with the new durability API for" +
                         " TransactionConfig or MutableEnvironmentConfig");
                }
            } else if (txn.getExplicitSyncConfigured()) {
                /* Durability was explicitly configured for commit */
                throw new IllegalArgumentException
                    ("Mixed use of new durability API for the " +
                      "transaction commit with deprecated durability API for" +
                      " TransactionConfig or MutableEnvironmentConfig");
            }
            txn.commit(durability);
            commitToken = txn.getCommitToken();
            /* Remove reference to internal txn, so we can reclaim memory. */
            txn = null;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(env).invalidate(E);
            throw E;
        }
    }

    /**
     * Returns the timeout value for the transaction lifetime.
     *
     * <p>If {@link #setTxnTimeout(long,TimeUnit)} has not been called to
     * configure the timeout, the environment configuration value ({@link
     * EnvironmentConfig#TXN_TIMEOUT} )is returned.</p>
     *
     * @param unit the {@code TimeUnit} of the returned value. May not be null.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the transaction or environment has been
     * closed.
     *
     * @throws IllegalArgumentException if the unit is null.
     *
     * @since 4.0
     */
    public long getTxnTimeout(TimeUnit unit)
        throws EnvironmentFailureException,
               IllegalStateException,
               IllegalArgumentException {

        checkEnv();
        checkOpen();
        return PropUtil.millisToDuration((int) txn.getTxnTimeout(), unit);
    }

    /**
     * Configures the timeout value for the transaction lifetime.
     *
     * <p>If the transaction runs longer than this time, the transaction may
     * throw {@link com.sleepycat.je.TransactionTimeoutException
     * TransactionTimeoutException}.</p>
     *
     * <p>Transaction timeouts are checked whenever a thread of control blocks
     * on a lock or when deadlock detection is performed.  For this reason, the
     * accuracy of the timeout depends on the length of the lock timeout and
     * how often deadlock detection is performed.</p>
     *
     * @param timeOut The timeout value for the transaction lifetime. A value
     * of 0 disables timeouts for the transaction, meaning that no limit on the
     * duration of the transaction is enforced.
     *
     * @param unit the {@code TimeUnit} of the timeOut value. May be null only
     * if timeOut is zero.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the transaction or environment has been
     * closed.
     *
     * @throws IllegalArgumentException if timeOut or unit is invalid.
     *
     * @since 4.0
     */
    public void setTxnTimeout(long timeOut, TimeUnit unit)
        throws IllegalArgumentException, DatabaseException {

        checkEnv();
        checkOpen();
        txn.setTxnTimeout(PropUtil.durationToMillis(timeOut, unit));
    }

    /**
     * Configures the timeout value for the transaction lifetime, with the
     * timeout value specified in microseconds.  This method is equivalent to:
     *
     * <pre>setTxnTimeout(long, TimeUnit.MICROSECONDS);</pre>
     *
     * @deprecated as of 4.0, replaced by {@link #setTxnTimeout(long,
     * TimeUnit)}.
     */
    public void setTxnTimeout(long timeOut)
        throws IllegalArgumentException, DatabaseException {

        setTxnTimeout(timeOut, TimeUnit.MICROSECONDS);
    }

    /**
     * Returns the lock request timeout value for the transaction.
     *
     * <p>If {@link #setLockTimeout(long,TimeUnit)} has not been called to
     * configure the timeout, the environment configuration value ({@link
     * EnvironmentConfig#LOCK_TIMEOUT}) is returned.</p>
     *
     * @param unit the {@code TimeUnit} of the returned value. May not be null.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the transaction or environment has been
     * closed.
     *
     * @throws IllegalArgumentException if the unit is null.
     *
     * @since 4.0
     */
    public long getLockTimeout(TimeUnit unit)
        throws EnvironmentFailureException,
               IllegalStateException,
               IllegalArgumentException {

        checkEnv();
        checkOpen();
        return PropUtil.millisToDuration((int) txn.getLockTimeout(), unit);
    }

    /**
     * Configures the lock request timeout value for the transaction.
     *
     * <p>If a lock request cannot be granted in this time, the transaction may
     * throw {@link com.sleepycat.je.LockTimeoutException
     * LockTimeoutException}.</p>
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @param timeOut The lock request timeout value for this transaction.  A
     * value of zero turns off transaction timeouts, meaning that no lock wait
     * time limit is enforced and a deadlocked operation will block
     * indefinitely.  We strongly recommend that a large timeout value, rather
     * than a zero value, is used when deadlocks are not expected.  That way, a
     * timeout exception will be thrown when an unexpected deadlock occurs.
     *
     * @param unit the {@code TimeUnit} of the timeOut value. May be null only
     * if timeOut is zero.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the transaction or environment has been
     * closed.
     *
     * @throws IllegalArgumentException if timeOut or unit is invalid.
     *
     * @since 4.0
     */
    public void setLockTimeout(long timeOut, TimeUnit unit)
        throws IllegalArgumentException, DatabaseException {

        checkEnv();
        checkOpen();
        txn.setLockTimeout(PropUtil.durationToMillis(timeOut, unit));
    }

    /**
     * Configures the lock request timeout value for the transaction, with the
     * timeout value specified in microseconds.  This method is equivalent to:
     *
     * <pre>setLockTimeout(long, TimeUnit.MICROSECONDS);</pre>
     *
     * @deprecated as of 4.0, replaced by {@link #setLockTimeout(long,
     * TimeUnit)}.
     */
    public void setLockTimeout(long timeOut)
        throws IllegalArgumentException, DatabaseException {

        setLockTimeout(timeOut, TimeUnit.MICROSECONDS);
    }

    /**
     * Set the user visible name for the transaction.
     *
     * @param name The user visible name for the transaction.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the user visible name for the transaction.
     *
     * @return The user visible name for the transaction.
     */
    public String getName() {
        return name;
    }

    /**
     * For internal use.
     * @hidden
     */
    @Override
    public int hashCode() {
        return (int) id;
    }

    /**
     * For internal use.
     * @hidden
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Transaction)) {
            return false;
        }

        if (((Transaction) o).id == id) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<Transaction id=\"");
        sb.append(id).append("\"");
        if (name != null) {
            sb.append(" name=\"");
            sb.append(name).append("\"");
            }
        sb.append(">");
        return sb.toString();
    }

    /**
     * This method should only be called by the LockerFactory.getReadableLocker
     * and getWritableLocker methods.  The locker returned does not enforce the
     * readCommitted isolation setting.
     *
     * @throws IllegalArgumentException via all API methods with a txn param
     */
    Locker getLocker()
        throws DatabaseException {

        if (txn == null) {
            throw new IllegalArgumentException
                ("Transaction " + id +
                 " has been closed and is no longer usable.");
        }
        return txn;
    }

    /*
     * Helpers
     */

    Txn getTxn() {
        return txn;
    }

    /**
     * @throws EnvironmentFailureException if the underlying environment is
     * invalid, via all methods.
     *
     * @throws IllegalStateException via all methods.
     */
    private void checkEnv() {
        EnvironmentImpl envImpl =  env.getEnvironmentImpl();
        if (envImpl == null) {
            throw new IllegalStateException
                ("The environment has been closed. " +
                 "This transaction is no longer usable.");
        }
        envImpl.checkIfInvalid();
    }

    /**
     * @throws IllegalStateException via all methods except abort.
     */
    private void checkOpen() {
        if (txn == null) {
            throw new IllegalStateException("Transaction Id " + id +
                                            " has been closed.");
        }
    }

    /**
     * Returns whether this {@code Transaction} is open, valid and can be used.
     * If this method returns false, {@link #abort} should be called as soon as
     * possible.
     *
     * <p>When an {@link OperationFailureException}, or one of its
     * subclasses, is caught, the {@code isValid} method should be called to
     * determine whether the {@code Transaction} can continue to be used, or
     * should be aborted.</p>
     */
    public boolean isValid() {
        return txn != null &&
               txn.isValid();
    }
}
