/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * Record lock modes for read operations. Lock mode parameters may be specified
 * for all operations that retrieve data.
 *
 * <p><strong>Locking Rules</strong></p>
 *
 * <p>Together with {@link CursorConfig}, {@link TransactionConfig} and {@link
 * EnvironmentConfig} settings, lock mode parameters determine how records are
 * locked during read operations.  Record locking is used to enforce the
 * isolation modes that are configured.  Record locking is summarized below for
 * read and write operations.  For more information on isolation levels and
 * transactions, see <a
 * href="{@docRoot}/../TransactionGettingStarted/index.html"
 * target="_top">Writing Transactional Applications</a>.</p>
 *
 * <p>With one exception, a record lock is always acquired when a record is
 * read or written, and a cursor will always hold the lock as long as it is
 * positioned on the record.  The exception is when {@link #READ_UNCOMMITTED}
 * is specified, which allows a record to be read without any locking.</p>
 *
 * <p>Both read (shared) and write (exclusive) locks are used.  Read locks are
 * normally acquired on read ({@code get} method} operations and write locks on
 * write ({@code put} method) operations.  However, a write lock will be
 * acquired on a read operation if {@link #RMW} is specified.</p>
 *
 * <p>Because read locks are shared, multiple accessors may read the same
 * record.  Because write locks are exclusive, if a record is written by one
 * accessor it may not be read or written by another accessor.  An accessor is
 * either a transaction or a thread (for non-transactional operations).</p>
 *
 * <p>Whether additional locking is performed and how locks are released depend
 * on whether the operation is transactional and other configuration
 * settings.</p>
 *
 * <p><strong>Transactional Locking</strong></p>
 *
 * <p>Transactional operations include all write operations for a transactional
 * database, and read operations when a non-null {@link Transaction} parameter
 * is passed.  When a null transaction parameter is passed for a write
 * operation for a transactional database, an auto-commit transaction is
 * automatically used.</p>
 *
 * <p>With transactions, read and write locks are normally held until the end
 * of the transaction (commit or abort).  Write locks are always held until the
 * end of the transaction.  However, if {@link #READ_COMMITTED} is configured,
 * then read locks for cursor operations are only held during the operation and
 * while the cursor is positioned on the record.  The read lock is released
 * when the cursor is moved to a different record or closed.  When {@link
 * #READ_COMMITTED} is used for a database (non-cursor) operation, the read
 * lock is released before the method returns.</p>
 *
 * <p>When neither {@link #READ_UNCOMMITTED} nor {@link #READ_COMMITTED} is
 * specified, read and write locking as described above provide Repeatable Read
 * isolation, which is the default transactional isolation level.  If
 * Serializable isolation is configured, additional "next key" locking is
 * performed to prevent "phantoms" -- records that are not visible at one point
 * in a transaction but that become visible at a later point after being
 * inserted by another transaction.  Serializable isolation is configured via
 * {@link TransactionConfig#setSerializableIsolation} or {@link
 * EnvironmentConfig#setTxnSerializableIsolation}.</p>
 *
 * <p><strong>Non-Transactional Locking</strong></p>
 *
 * <p>Non-transactional operations include all operations for a
 * non-transactional database (including a Deferred Write database), and read
 * operations for a transactional database when a null {@link Transaction}
 * parameter is passed.</p>
 *
 * <p>For non-transactional operations, both read and write locks are only held
 * while a cursor is positioned on the record, and are released when the cursor
 * is moved to a different record or closed.  For database (non-cursor)
 * operations, the read or write lock is released before the method
 * returns.</p>
 * 
 * <p>This behavior is similar to {@link #READ_COMMITTED}, except that both
 * read and write locks are released.  Configuring {@link #READ_COMMITTED} for
 * a non-transactional database cursor has no effect.</p>
 *
 * <p>Because the current thread is the accessor (locker) for non-transactional
 * operations, a single thread may have multiple cursors open without locking
 * conflicts.  Two non-transactional cursors in the same thread may access the
 * same record via write or read operations without conflicts, and the changes
 * make by one cursor will be visible to the other cursor.</p>
 *
 * <p>However, a non-transactional operation will conflict with a transactional
 * operation for the same record even when performed in the same thread.  When
 * using a transaction in a particular thread for a particular database, to
 * avoid conflicts you should use that transaction for all access to that
 * database in that thread.  In other words, to avoid conflicts always pass the
 * transction parameter, not null, for all operations.  If you don't wish to
 * hold the read lock for the duration of the transaction, specify {@link
 * #READ_COMMITTED}.</p>
 */
public enum LockMode {

    /**
     * Uses the default lock mode and is equivalent to passing {@code null} for
     * the lock mode parameter.
     *
     * <p>The default lock mode is {@link #READ_UNCOMMITTED} when this lock
     * mode is configured via {@link CursorConfig#setReadUncommitted} or {@link
     * TransactionConfig#setReadUncommitted}.  The Read Uncommitted mode
     * overrides any other configuration settings.</p>
     *
     * <p>Otherwise, the default lock mode is {@link #READ_COMMITTED} when this
     * lock mode is configured via {@link CursorConfig#setReadCommitted} or
     * {@link TransactionConfig#setReadCommitted}.  The Read Committed mode
     * overrides other configuration settings except for {@link
     * #READ_UNCOMMITTED}.</p>
     *
     * <p>Otherwise, the default lock mode is to acquire read locks and release
     * them according to the {@link LockMode default locking rules} for
     * transactional and non-transactional operations.</p>
     */
    DEFAULT,

    /**
     * Reads modified but not yet committed data.
     *
     * <p>The Read Uncommitted mode is used if this lock mode is explicitly
     * passed for the lock mode parameter, or if null or {@link #DEFAULT} is
     * passed and Read Uncommitted is the default -- see {@link #DEFAULT} for
     * details.</p>
     *
     * <p>See the {@link LockMode locking rules} for information on how Read
     * Uncommitted impacts transactional and non-transactional locking.</p>
     */
    READ_UNCOMMITTED,

    /**
     * Read committed isolation provides for cursor stability but not
     * repeatable reads.  Data items which have been previously read by this
     * transaction may be deleted or modified by other transactions before the
     * cursor is closed or the transaction completes.
     *
     * Note that this LockMode may only be passed to {@link Database} get
     * methods, not to {@link Cursor} methods.  To configure a cursor for Read
     * Committed isolation, use {@link CursorConfig#setReadCommitted}.
     *
     * <p>See the {@link LockMode locking rules} for information on how Read
     * Committed impacts transactional and non-transactional locking.</p>
     */
    READ_COMMITTED,

    /**
     * Acquire write locks instead of read locks when doing the retrieval.
     *
     * <p>Because it causes a write lock to be acquired, specifying this lock
     * mode as a {@link Cursor} or {@link Database} {@code get} (read) method
     * parameter will override the Read Committed or Read Uncommitted isolation
     * mode that is configured using {@link CursorConfig} or {@link
     * TransactionConfig}.  The write lock will acquired and held until the end
     * of the transaction.  For non-transactional use, the write lock will be
     * released when the cursor is moved to a new position or closed.</p>
     *
     * <p>Setting this flag can eliminate deadlock during a read-modify-write
     * cycle by acquiring the write lock during the read part of the cycle so
     * that another thread of control acquiring a read lock for the same item,
     * in its own read-modify-write cycle, will not result in deadlock.</p>
     */
    RMW;

    public String toString() {
        return "LockMode." + name();
    }
}
