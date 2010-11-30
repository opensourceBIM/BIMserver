/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.txn.Locker;

/**
 * Indicates that a failure has occurred that impacts the current operation
 * and/or transaction.  For failures that impact the environment as a whole,
 * see {@link EnvironmentFailureException}.  For an overview of all exceptions
 * thrown by JE, see {@link DatabaseException}.
 *
 * <p>If an explicit transaction applies to a method which threw this
 * exception, the exception may indicate that {@link Transaction#abort} must be
 * called, depending on the nature of the failure.  A transaction is applicable
 * to a method call in two cases.</p>
 * <ol>
 * <li>When an explicit (non-null) {@code Transaction} instance is specified.
 * This applies when the {@code Transaction} is passed as a parameter to the
 * method that throws the exception, or when the {@code Transaction} is passed
 * to {@link Database#openCursor} and a {@code Cursor} method throws the
 * exception.
 * </li>
 * <li>When a per-thread {@code Transaction} applies to the method that throws
 * the exception.  Per-thread transactions apply when using {@link
 * com.sleepycat.collections persistent collections} with {@link
 * com.sleepycat.collections.CurrentTransaction} or {@link 
 * com.sleepycat.collections.TransactionRunner}, or when using XA transactions 
 * with {@link XAEnvironment}.
 * </li>
 * </ol>
 *
 * <p>When a transaction is applicable to a method call, the application should
 * catch {@code OperationFailureException} and then call {@link
 * Transaction#isValid}.  If {@code false} is returned, all {@code Cursor}
 * instances that were created with the transaction must be closed and then
 * {@link Transaction#abort} must be called.  Also note that {@link
 * Transaction#isValid} may be called at any time, not just during exception
 * handling.</p>
 *
 * <p>The use of the {@link Transaction#isValid} method allows JE to determine
 * dynamically whether the failure requires an abort or not, and allows for
 * this determination to change in future releases. Over time, internal
 * improvements to error handling may allow more error conditions to be handled
 * without invalidating the {@code Transaction}.</p>
 *
 * <p>The specific handling that is necessary for an {@code
 * OperationFailureException} depends on the specific subclass thrown.  See the
 * javadoc for each method for information on which methods thrown which {@code
 * OperationFailureException}s and why.</p>
 *
 * <p>If {@link Transaction#abort} is not called after an {@code
 * OperationFailureException} invalidates the {@code Transaction}, all
 * subsequent method calls using the {@code Transaction} will throw the same
 * exception.  This provides more than one opportunity to catch and handle the
 * specific exception subclass that caused the failure.</p>
 *
 * <p>{@code OperationFailureException} is also thrown by methods where no
 * transaction applies. In most cases the action required to handle the
 * exception is the same as with a transaction, although of course no abort is
 * necessary.</p>
 *
 * <p>However, please be aware that for some operations on a non-transactional
 * {@code Database} or {@code EntityStore}, an {@code
 * OperationFailureException} may cause data corruption.  For example, see
 * {@link SecondaryReferenceException}.</p>
 *
 * <p>There are two groups of operation failure subclasses worth noting since
 * they apply to many methods: read operation failures and write operation
 * failures.  These are described below.</p>
 *
 * <a name="readFailures"><h3>Read Operation Failures</h3></a>
 *
 * <p>Read operations are all those performed by the {@code get} family of
 * methods, for example, {@link Database#get Database.get}, {@link
 * Cursor#getNext Cursor.getNext}, {@link com.sleepycat.persist.EntityIndex#get
 * EntityIndex.get}, {@link com.sleepycat.persist.EntityCursor#next
 * EntityCursor.next} and {@link com.sleepycat.collections.StoredMap#get
 * StoredMap.get}.  These methods may cause the following operation
 * failures.</p>
 *
 * <ul>
 * <li>{@link OperationFailureException} is the superclass of all read
 * operation failures.</li>
 *   <ul>
 *   <li>{@link LockConflictException} is thrown if a lock conflict prevents
 *   the operation from completing.  A read operation may be blocked by another
 *   locker (transaction or non-transactional cursor) that holds a write lock
 *   on the record.</li>
 *
 *     <ul>
 *     <li>{@link com.sleepycat.je.rep.LockPreemptedException} is a subclass
 *     of {@code LockConflictException} that is thrown in a replicated
 *     environment on the Replica node, when the Master node has changed a
 *     record that was previously locked by the reading transaction or
 *     cursor.</li>
 *     </ul>
 *   
 *   <li>{@link SecondaryIntegrityException} is thrown if a primary-secondary
 *   relationship integrity problem is detected while reading a primary
 *   database record via a secondary index.</li>
 *   
 *   <li>{@link com.sleepycat.je.rep.DatabasePreemptedException} is thrown in a
 *   replicated environment on the Replica node, when the Master node has
 *   truncated, removed or renamed the database.</li>
 *   
 *   <li>Other {@link OperationFailureException} subclasses may be thrown if
 *   such an exception was thrown earlier and caused the transaction to be
 *   invalidated.</li>
 *   </ul>
 * </ul>
 *
 * <a name="writeFailures"><h3>Write Operation Failures</h3></a>
 *
 * <p>Write operations are all those performed by the {@code put} and {@code
 * delete} families of methods, for example, {@link Database#put Database.put},
 * {@link Cursor#delete Cursor.delete}, {@link
 * com.sleepycat.persist.PrimaryIndex#put PrimaryIndex.put}, {@link
 * com.sleepycat.persist.EntityCursor#delete EntityCursor.delete} and {@link
 * com.sleepycat.collections.StoredMap#put StoredMap.put}.  These methods may
 * cause the following operation failures, although certain failures are only
 * caused by {@code put} methods and others only by {@code delete} methods, as
 * noted below.</p>
 *
 * <ul>
 * <li>{@link OperationFailureException} is the superclass of all write
 * operation failures.</li>
 *
 *   <ul>
 *   <li>{@link LockConflictException} is thrown if a lock conflict prevents
 *   the operation from completing.  A write operation may be blocked by
 *   another locker (transaction or non-transactional cursor) that holds a read
 *   or write lock on the record.</li>
 *
 *   <li>{@link SecondaryConstraintException} is the superclass of all
 *   exceptions thrown when a write operation fails because of a secondary
 *   constraint.</li>
 *
 *     <ul>
 *     <li>{@link ForeignConstraintException} is thrown when an attempt to
 *     write a primary database record would insert a secondary record with a
 *     key that does not exist in a foreign key database, when the secondary
 *     key is configured as a foreign key.  This exception is only thrown by
 *     {@code put} methods.</li>
 *
 *     <li>{@link UniqueConstraintException} is thrown when an attempt to write
 *     a primary database record would insert a secondary record with a
 *     duplicate key, for secondaries that represent one-to-one and one-to-many
 *     relationships.  This exception is only thrown by {@code put}
 *     methods.</li>
 *
 *     <li>{@link DeleteConstraintException} is thrown when an attempt is made
 *     to delete a key from a foreign key database, when that key is referenced
 *     by a secondary database, and the secondary is configured to cause an
 *     abort in this situation.  This exception is only thrown by {@code
 *     delete} methods.</li>
 *     </ul>
 *
 *   <li>{@link SecondaryIntegrityException} is thrown if a primary-secondary
 *   relationship integrity problem is detected while writing a record in a
 *   primary database that has one or more secondary indices.
 *   
 *   <li>{@link com.sleepycat.je.rep.DatabasePreemptedException} is thrown in a
 *   replicated environment on a Replica node, when the Master node has
 *   truncated, removed or renamed the database.</li>
 *
 *   <li>{@link com.sleepycat.je.rep.ReplicaWriteException} is always thrown in
 *   a replicated environment on a Replica node, since write operations are not
 *   allowed on a Replica.</li>
 *
 *   <li>Other {@link OperationFailureException} subclasses may be thrown if
 *   such an exception was thrown earlier and caused the transaction to be
 *   invalidated.</li>
 *   </ul>
 * </ul>
 *
 * @since 4.0
 */
public abstract class OperationFailureException extends DatabaseException {

    private static final long serialVersionUID = 1;

    /** 
     * For internal use only.
     * @hidden 
     */
    public OperationFailureException(Locker locker,
                                     boolean abortOnly,
                                     String message,
                                     Throwable cause) {
        super(message, cause);
        if (abortOnly) {
            assert locker != null;
            locker.setOnlyAbortable(this);
        }
    }

    /** 
     * For internal use only.
     * @hidden 
     * Only for use by wrapSelf methods.
     */
    protected OperationFailureException(String message,
                                        OperationFailureException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     * Must be implemented by every concrete subclass to return an instance of
     * its own class, constructed with the given msg and this exception as
     * parameters, e.g.: return new MyClass(msg, this);
     */
    public abstract OperationFailureException wrapSelf(String msg);
}
