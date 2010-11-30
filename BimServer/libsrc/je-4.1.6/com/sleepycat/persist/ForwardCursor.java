/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.persist;

import java.util.Iterator;

import com.sleepycat.je.DatabaseException;
/* <!-- begin JE only --> */
import com.sleepycat.je.EnvironmentFailureException ; // for javadoc
/* <!-- end JE only --> */
import com.sleepycat.je.LockMode;
/* <!-- begin JE only --> */
import com.sleepycat.je.OperationFailureException ; // for javadoc
/* <!-- end JE only --> */

/**
 * Cursor operations limited to traversing forward.  See {@link EntityCursor}
 * for general information on cursors.
 *
 * <p>{@code ForwardCursor} objects are <em>not</em> thread-safe.  Cursors
 * should be opened, used and closed by a single thread.</p>
 *
 * <p><em>WARNING:</em> Cursors must always be closed to prevent resource leaks
 * which could lead to the index becoming unusable or cause an
 * <code>OutOfMemoryError</code>.  To ensure that a cursor is closed in the
 * face of exceptions, close it in a finally block.</p>
 *
 * @author Mark Hayes
 */
public interface ForwardCursor<V> extends Iterable<V> {

    /**
     * Moves the cursor to the next value and returns it, or returns null
     * if there are no more values in the cursor range.  If the cursor is
     * uninitialized, this method returns the first value.
     *
     * <p>{@link LockMode#DEFAULT} is used implicitly.</p>
     *
     * @return the next value, or null if there are no more values in the
     * cursor range.
     *
     * <!-- begin JE only -->
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     * <!-- end JE only -->
     *
     * @throws DatabaseException the base class for all BDB exceptions.
     */
    V next()
        throws DatabaseException;

    /**
     * Moves the cursor to the next value and returns it, or returns null
     * if there are no more values in the cursor range.  If the cursor is
     * uninitialized, this method returns the first value.
     *
     * @param lockMode the lock mode to use for this operation, or null to
     * use {@link LockMode#DEFAULT}.
     *
     * @return the next value, or null if there are no more values in the
     * cursor range.
     *
     * <!-- begin JE only -->
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     * <!-- end JE only -->
     *
     * @throws DatabaseException the base class for all BDB exceptions.
     */
    V next(LockMode lockMode)
        throws DatabaseException;

    /**
     * Returns an iterator over the key range, starting with the value
     * following the current position or at the first value if the cursor is
     * uninitialized.
     *
     * <p>{@link LockMode#DEFAULT} is used implicitly.</p>
     *
     * @return the iterator.
     */
    Iterator<V> iterator();

    /**
     * Returns an iterator over the key range, starting with the value
     * following the current position or at the first value if the cursor is
     * uninitialized.
     *
     * @param lockMode the lock mode to use for all operations performed
     * using the iterator, or null to use {@link LockMode#DEFAULT}.
     *
     * @return the iterator.
     */
    Iterator<V> iterator(LockMode lockMode);

    /**
     * Closes the cursor.
     *
     * @throws DatabaseException the base class for all BDB exceptions.
     */
    void close()
        throws DatabaseException;
}
