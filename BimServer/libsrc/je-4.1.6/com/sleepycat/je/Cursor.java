/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.dbi.PutMode;
import com.sleepycat.je.dbi.RangeRestartException;
import com.sleepycat.je.dbi.CursorImpl.KeyChangeStatus;
import com.sleepycat.je.dbi.CursorImpl.SearchMode;
import com.sleepycat.je.latch.LatchSupport;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.txn.BuddyLocker;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.LockerFactory;
import com.sleepycat.je.utilint.DatabaseUtil;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * A database cursor. Cursors are used for operating on collections of records,
 * for iterating over a database, and for saving handles to individual records,
 * so that they can be modified after they have been read.
 *
 * <p>Cursors which are opened with a transaction instance are transactional
 * cursors and may be used by multiple threads, but only serially.  That is,
 * the application must serialize access to the handle. Non-transactional
 * cursors, opened with a null transaction instance, may not be used by
 * multiple threads.</p>
 *
 * <p>If the cursor is to be used to perform operations on behalf of a
 * transaction, the cursor must be opened and closed within the context of that
 * single transaction.</p>
 *
 * <p>Once the cursor {@link #close} method has been called, the handle may not
 * be accessed again, regardless of the {@code close} method's success or
 * failure, with one exception:  the {@code close} method itself may be called
 * any number of times to simplify error handling.</p>
 *
 * <p>To obtain a cursor with default attributes:</p>
 *
 * <blockquote><pre>
 *     Cursor cursor = myDatabase.openCursor(txn, null);
 * </pre></blockquote>
 *
 * <p>To customize the attributes of a cursor, use a CursorConfig object.</p>
 *
 * <blockquote><pre>
 *     CursorConfig config = new CursorConfig();
 *     config.setReadUncommitted(true);
 *     Cursor cursor = myDatabase.openCursor(txn, config);
 * </pre></blockquote>
 *
 * <p>Modifications to the database during a sequential scan will be reflected
 * in the scan; that is, records inserted behind a cursor will not be returned
 * while records inserted in front of a cursor will be returned.</p>
 *
 * <a name="partialEntry"><h3>Using Partial DatabaseEntry Parameters</h3></a>
 *
 * <p>The {@link DatabaseEntry#setPartial DatabaseEntry Partial} property can
 * be used to optimize in certain cases.  This provides varying degrees of
 * performance benefits that depend on the specific operation and use of {@code
 * READ_UNCOMMITTED} isolation, as described below.</p>
 *
 * <p>When retrieving a record with a {@link Database} or {@link Cursor}
 * method, if only the key is needed by the application then the retrieval of
 * the data item can be suppressed using the Partial property. If {@code
 * setPartial(0, 0, true)} is called for the {@code DatabaseEntry} passed as
 * the data parameter, the data item will not be returned by the {@code
 * Database} or {@code Cursor} method.</p>
 *
 * <p>Suppressing the return of the data item potentially has a large
 * performance benefit when the {@code READ_UNCOMMITTED} isolation mode is
 * used.  In this case, if the record data is not in the JE cache, it will not
 * be read from disk.  The performance benefit is potentially large because
 * random access disk reads may be reduced.  Examples are:</p>
 * <ul>
 * <li>Scanning all records in key order, when the data is not needed and
 * {@code READ_UNCOMMITTED} isolation is acceptable.</li>
 * <li>Skipping over records quickly to perform approximate pagination with
 * {@code READ_UNCOMMITTED} isolation.</li>
 * </ul>
 *
 * <p>For other isolation modes ({@code READ_COMMITTED}, {@code
 * REPEATABLE_READ} and {@code SERIALIZABLE}), the performance benefit is
 * not as significant.  In this case, the data item must be read into the JE
 * cache if it is not already present, in order to lock the record.  The only
 * performance benefit is that the data will not be copied from the JE cache to
 * the application's entry parameter.</p>
 *
 * <p>For information on specifying isolation modes, see {@link LockMode},
 * {@link CursorConfig} and {@link TransactionConfig}.</p>
 *
 * <p>The Partial property may also be used to retrieve or update only a
 * portion of a data item.  This avoids copying the entire record between the
 * JE cache and the application data parameter. However, this feature is not
 * currently fully optimized, since the entire record is always read or written
 * to the database, and the entire record is cached.  A partial update may
 * be performed only with {@link Cursor#putCurrent Cursor.putCurrent}.</p>
 *
 * <p>In limited cases, the Partial property may also be used to retrieve a
 * partial key item.  For example, a {@code DatabaseEntry} with a Partial
 * property may be passed to {@link #getNext getNext}.  However, in practice
 * this has limited value since the entire key is usually needed by the
 * application, and the benefit of copying a portion of the key is generally
 * very small.  Partial key items may not be passed to methods that use the key
 * as an input parameter, for example, {@link #getSearchKey getSearchKey}.  In
 * general, the usefulness of partial key items is very limited.</p>
 */
public class Cursor {

    /**
     * The underlying cursor.
     */
    CursorImpl cursorImpl; // Used by subclasses.

    /**
     * The CursorConfig used to configure this cursor.
     */
    CursorConfig config;

    /**
     * True if update operations are prohibited through this cursor.  Update
     * operations are prohibited if the database is read-only or:
     *
     * (1) The database is transactional,
     *
     * and
     *
     * (2) The user did not supply a txn to the cursor ctor (meaning, the
     * locker is non-transactional).
     */
    private boolean updateOperationsProhibited;

    /**
     * Handle under which this cursor was created; may be null when the cursor
     * is used internally.
     */
    private Database dbHandle;

    /**
     * Database implementation.
     */
    private DatabaseImpl dbImpl;

    /* Attributes */
    private boolean readUncommittedDefault;
    private boolean serializableIsolationDefault;

    private Logger logger;

    private boolean nonCloning = false;

    private CacheMode cacheMode;
    private boolean cacheModeOverridden;

    /**
     * Creates a cursor for a given user transaction with
     * retainNonTxnLocks=false.
     *
     * <p>If txn is null, a non-transactional cursor will be created that
     * releases locks for the prior operation when the next operation
     * succeeds.</p>
     */
    Cursor(final Database dbHandle,
           final Transaction txn,
           CursorConfig cursorConfig) {
        if (cursorConfig == null) {
            cursorConfig = CursorConfig.DEFAULT;
        }

        /* Check that Database is open for internal Cursor usage. */
        if (dbHandle != null) {
            dbHandle.checkOpen("Can't access Database:");
        }

        /* Do not allow auto-commit when creating a user cursor. */
        Locker locker = LockerFactory.getReadableLocker
            (dbHandle.getEnvironment(),
             txn,
             dbHandle.isTransactional(),
             false /*retainNonTxnLocks*/,
             cursorConfig.getReadCommitted());

        init(dbHandle, dbHandle.getDatabaseImpl(), locker, cursorConfig,
             false /*retainNonTxnLocks*/);
    }

    /**
     * Creates a cursor for a given locker with retainNonTxnLocks=false.
     *
     * <p>If locker is null or is non-transactional, a non-transactional cursor
     * will be created that releases locks for the prior operation when the
     * next operation succeeds.</p>
     */
    Cursor(final Database dbHandle, Locker locker, CursorConfig cursorConfig) {
        if (cursorConfig == null) {
            cursorConfig = CursorConfig.DEFAULT;
        }

        /* Check that Database is open for internal Cursor usage. */
        if (dbHandle != null) {
            dbHandle.checkOpen("Can't access Database:");
        }

        locker = LockerFactory.getReadableLocker
            (dbHandle.getEnvironment(),
             dbHandle,
             locker,
             cursorConfig.getReadCommitted());

        init(dbHandle, dbHandle.getDatabaseImpl(), locker, cursorConfig,
             false /*retainNonTxnLocks*/);
    }

    /**
     * Creates a cursor for a given locker and retainNonTxnLocks parameter.
     *
     * <p>The locker parameter must be non-null.  With this constructor, we use
     * the given locker and retainNonTxnLocks parameter without applying any
     * special rules for different lockers -- the caller must supply the
     * correct locker and retainNonTxnLocks combination.</p>
     */
    Cursor(final Database dbHandle,
           final Locker locker,
           CursorConfig cursorConfig,
           final boolean retainNonTxnLocks) {
        if (cursorConfig == null) {
            cursorConfig = CursorConfig.DEFAULT;
        }

        /* Check that Database is open for internal Cursor usage. */
        if (dbHandle != null) {
            dbHandle.checkOpen("Can't access Database:");
        }

        init(dbHandle, dbHandle.getDatabaseImpl(), locker, cursorConfig,
             retainNonTxnLocks);
    }

    /**
     * Creates a cursor for internal use, without a Database handle.
     */
    Cursor(final DatabaseImpl databaseImpl,
           final Locker locker,
           CursorConfig cursorConfig,
           final boolean retainNonTxnLocks) {
        if (cursorConfig == null) {
            cursorConfig = CursorConfig.DEFAULT;
        }

        /* Check that Database is open for internal Cursor usage. */
        if (dbHandle != null) {
            dbHandle.checkOpen("Can't access Database:");
        }

        init(null /*dbHandle*/, databaseImpl, locker, cursorConfig,
             retainNonTxnLocks);
    }

    private void init(final Database dbHandle,
                      final DatabaseImpl databaseImpl,
                      final Locker locker,
                      final CursorConfig cursorConfig,
                      final boolean retainNonTxnLocks) {
        assert locker != null;

        /*
         * Allow locker to perform "open cursor" actions, such as consistency
         * checks for a non-transactional locker on a Replica.
         */
        try {
            locker.openCursorHook();
        } catch (RuntimeException e) {
            locker.operationEnd();
            throw e;
        }

        cursorImpl = new CursorImpl(databaseImpl, locker, retainNonTxnLocks);

        cacheMode = databaseImpl.getDefaultCacheMode();

        /* Perform eviction for user cursors. */
        cursorImpl.setAllowEviction(true);

        readUncommittedDefault =
            cursorConfig.getReadUncommitted() ||
            locker.isReadUncommittedDefault();

        serializableIsolationDefault =
            cursorImpl.getLocker().isSerializableIsolation();

        updateOperationsProhibited =
            (databaseImpl.isTransactional() && !locker.isTransactional()) ||
            (dbHandle != null && !dbHandle.isWritable());

        this.dbImpl = databaseImpl;
        if (dbHandle != null) {
            this.dbHandle = dbHandle;
            dbHandle.addCursor(this);
        }
        this.config = cursorConfig;
        this.logger = databaseImpl.getDbEnvironment().getLogger();
    }

    /**
     * Copy constructor.
     */
    Cursor(final Cursor cursor, final boolean samePosition) {
        readUncommittedDefault = cursor.readUncommittedDefault;
        serializableIsolationDefault = cursor.serializableIsolationDefault;
        updateOperationsProhibited = cursor.updateOperationsProhibited;

        cursorImpl = cursor.cursorImpl.dup(samePosition);
        dbImpl = cursor.dbImpl;
        dbHandle = cursor.dbHandle;
        if (dbHandle != null) {
            dbHandle.addCursor(this);
        }
        config = cursor.config;
        logger = dbImpl.getDbEnvironment().getLogger();
        cacheMode = cursor.cacheMode;
        cacheModeOverridden = cursor.cacheModeOverridden;
    }

    /**
     * Prevents this cursor from being cloned to perform an operation that
     * changes the cursor position.  [#13879]
     *
     * NonCloning is an optimization used for Database.get/put operations.
     * Normally cloning is used before an operation to allow use of the old
     * cursor position after the operation fails.  With the Database
     * operations, if an operation fails the cursor is simply discarded.
     * NonCloning cursors are also used for internal operations.
     */
    void setNonCloning(final boolean nonCloning) {
        this.nonCloning = nonCloning;
    }

    /**
     * Internal entrypoint.
     */
    CursorImpl getCursorImpl() {
        return cursorImpl;
    }

    /**
     * Returns the Database handle associated with this Cursor.
     *
     * @return The Database handle associated with this Cursor.
     */
    public Database getDatabase() {
        return dbHandle;
    }

    /**
     * Always returns non-null, while getDatabase() returns null if no handle
     * is associated with this cursor.
     */
    DatabaseImpl getDatabaseImpl() {
        return dbImpl;
    }

    /**
     * Returns this cursor's configuration.
     *
     * <p>This may differ from the configuration used to open this object if
     * the cursor existed previously.</p>
     *
     * @return This cursor's configuration.
     */
    public CursorConfig getConfig() {
        try {
            return config.clone();
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * Returns the {@code CacheMode} used for subsequent operations performed
     * using this cursor.  If {@link #setCacheMode} has not been called with a
     * non-null value, the configured Database or Environment default is
     * returned.
     *
     * @return the {@code CacheMode} used for subsequent operations using
     * this cursor.
     *
     * @see #setCacheMode
     */
    public CacheMode getCacheMode() {
        return cacheMode;
    }

    /**
     * Sets the {@code CacheMode} used for subsequent operations performed
     * using this cursor.  This method may be used to override the defaults
     * specified using {@link DatabaseConfig#setCacheMode} and {@link
     * EnvironmentConfig#setCacheMode}.
     *
     * @param cacheMode is the {@code CacheMode} used for subsequent operations
     * using this cursor, or null to configure the Database or Environment
     * default.
     *
     * @see CacheMode for further details.
     */
    public void setCacheMode(final CacheMode cacheMode) {
        cacheModeOverridden = (cacheMode != null);
        this.cacheMode =
            (cacheMode != null) ? cacheMode : dbImpl.getDefaultCacheMode();
    }

    /**
     * Discards the cursor.
     *
     * <p>The cursor handle may not be used again after this method has been
     * called, regardless of the method's success or failure.</p>
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public void close()
        throws DatabaseException {

        try {
            if (cursorImpl.isClosed()) {
                return;
            }

            /*
             * Do not call checkState here, to allow closing a cursor after an
             * operation failure.  [#17015]
             */
            checkEnv();
            cursorImpl.close();
            if (dbHandle != null) {
                dbHandle.removeCursor(this);
                dbHandle = null;
            }
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * Returns a count of the number of data items for the key to which the
     * cursor refers.
     *
     * @return A count of the number of data items for the key to which the
     * cursor refers.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the cursor is uninitialized (not positioned on a record), or the
     * non-transactional cursor was created in a different thread.
     */
    public int count()
        throws DatabaseException {

        checkState(true);
        trace(Level.FINEST, "Cursor.count: ", null);

        /*
         * Specify a null LockMode to use default locking.  The API doesn't
         * allow specifying a lock mode, but we should at least honor the
         * configured default.
         */
        return countInternal(null);
    }

    /**
     * Returns a new cursor with the same transaction and locker ID as the
     * original cursor.
     *
     * <p>This is useful when an application is using locking and requires
     * two or more cursors in the same thread of control.</p>
     *
     * @param samePosition If true, the newly created cursor is initialized
     * to refer to the same position in the database as the original cursor
     * (if any) and hold the same locks (if any). If false, or the original
     * cursor does not hold a database position and locks, the returned
     * cursor is uninitialized and will behave like a newly created cursor.
     *
     * @return A new cursor with the same transaction and locker ID as the
     * original cursor.
     *
     * @throws com.sleepycat.je.rep.DatabasePreemptedException in a replicated
     * environment if the master has truncated, removed or renamed the
     * database.
     *
     * @throws OperationFailureException if this exception occurred earlier and
     * caused the transaction to be invalidated.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed.
     */
    public Cursor dup(final boolean samePosition)
        throws DatabaseException {

        try {
            checkState(false);
            return new Cursor(this, samePosition);
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * Deletes the key/data pair to which the cursor refers.
     *
     * <p>When called on a cursor opened on a database that has been made into
     * a secondary index, this method the key/data pair from the primary
     * database and all secondary indices.</p>
     *
     * <p>The cursor position is unchanged after a delete, and subsequent calls
     * to cursor functions expecting the cursor to refer to an existing key
     * will fail.</p>
     *
     * @return {@link com.sleepycat.je.OperationStatus#KEYEMPTY
     * OperationStatus.KEYEMPTY} if the key/pair at the cursor position has
     * been deleted; otherwise, {@link
     * com.sleepycat.je.OperationStatus#SUCCESS OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if the database is transactional
     * but this cursor was not opened with a non-null transaction parameter,
     * or the database is read-only.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the cursor is uninitialized (not positioned on a record), or the
     * non-transactional cursor was created in a different thread.
     */
    public OperationStatus delete()
        throws LockConflictException,
               DatabaseException,
               UnsupportedOperationException  {

        checkState(true);
        checkUpdatesAllowed("delete");
        trace(Level.FINEST, "Cursor.delete: ", null);

        return deleteInternal(dbImpl.getRepContext());
    }

    /**
     * Stores a key/data pair into the database.
     *
     * <p>If the put method succeeds, the cursor is always positioned to refer
     * to the newly inserted item.  If the put method fails for any reason, the
     * state of the cursor will be unchanged.</p>
     *
     * <p>If the key already appears in the database and duplicates are
     * supported, the new data value is inserted at the correct sorted
     * location.  If the key already appears in the database and duplicates are
     * not supported, the data associated with the key will be replaced.</p>
     *
     * @param key the key {@link com.sleepycat.je.DatabaseEntry
     * DatabaseEntry} operated on.
     *
     * @param data the data {@link com.sleepycat.je.DatabaseEntry
     * DatabaseEntry} stored.
     *
     * @return an OperationStatus for the operation.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if the database is transactional
     * but this cursor was not opened with a non-null transaction parameter,
     * or the database is read-only.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus put(final DatabaseEntry key,
                               final DatabaseEntry data)
        throws DatabaseException, UnsupportedOperationException {

        checkState(false);
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(data, "data", true);
        DatabaseUtil.checkForPartialKey(key);
        checkUpdatesAllowed("put");
        trace(Level.FINEST, "Cursor.put: ", key, data, null);

        return putInternal(key, data, PutMode.OVERWRITE);
    }

    /**
     * Stores a key/data pair into the database.
     *
     * <p>If the putNoOverwrite method succeeds, the cursor is always
     * positioned to refer to the newly inserted item.  If the putNoOverwrite
     * method fails for any reason, the state of the cursor will be
     * unchanged.</p>
     *
     * <p>If the key already appears in the database, putNoOverwrite will
     * return {@link com.sleepycat.je.OperationStatus#KEYEXIST
     * OperationStatus.KEYEXIST}.</p>
     *
     * @param key the key {@link com.sleepycat.je.DatabaseEntry
     * DatabaseEntry} operated on.
     *
     * @param data the data {@link com.sleepycat.je.DatabaseEntry
     * DatabaseEntry} stored.
     *
     * @return an OperationStatus for the operation.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if the database is transactional
     * but this cursor was not opened with a non-null transaction parameter,
     * or the database is read-only.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus putNoOverwrite(final DatabaseEntry key,
                                          final DatabaseEntry data)
        throws DatabaseException, UnsupportedOperationException {

        checkState(false);
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(data, "data", true);
        DatabaseUtil.checkForPartialKey(key);
        checkUpdatesAllowed("putNoOverwrite");
        trace(Level.FINEST, "Cursor.putNoOverwrite: ", key, data, null);

        return putInternal(key, data, PutMode.NO_OVERWRITE);
    }

    /**
     * Stores a key/data pair into the database.
     *
     * <p>If the putNoDupData method succeeds, the cursor is always positioned
     * to refer to the newly inserted item.  If the putNoDupData method fails
     * for any reason, the state of the cursor will be unchanged.</p>
     *
     * <p>Insert the specified key/data pair into the database, unless a
     * key/data pair comparing equally to it already exists in the database.
     * If a matching key/data pair already exists in the database, {@link
     * com.sleepycat.je.OperationStatus#KEYEXIST OperationStatus.KEYEXIST} is
     * returned.</p>
     *
     * @param key the key {@link com.sleepycat.je.DatabaseEntry DatabaseEntry}
     * operated on.
     *
     * @param data the data {@link com.sleepycat.je.DatabaseEntry
     * DatabaseEntry} stored.
     *
     * @return an OperationStatus for the operation.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if the database is transactional
     * but this cursor was not opened with a non-null transaction parameter, or
     * the database is read-only, or the database is not configured for
     * duplicates.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus putNoDupData(final DatabaseEntry key,
                                        final DatabaseEntry data)
        throws DatabaseException, UnsupportedOperationException {

        checkState(false);
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(data, "data", true);
        DatabaseUtil.checkForPartialKey(key);
        checkUpdatesAllowed("putNoDupData");
        if (!dbImpl.getSortedDuplicates()) {
            throw new UnsupportedOperationException
                ("Database is not configured for duplicate data.");
        }
        trace(Level.FINEST, "Cursor.putNoDupData: ", key, data, null);

        return putInternal(key, data, PutMode.NO_DUP_DATA);
    }

    /**
     * Replaces the data in the key/data pair at the current cursor position.
     *
     * <p>Whether the putCurrent method succeeds or fails for any reason, the
     * state of the cursor will be unchanged.</p>
     *
     * <p>Overwrite the data of the key/data pair to which the cursor refers
     * with the specified data item. This method will return
     * OperationStatus.KEYEMPTY if the cursor currently refers to an
     * already-deleted key/data pair.</p>
     *
     * <p>For a database that does not support duplicates, the data may be
     * changed by this method.  If duplicates are supported, the data may be
     * changed only if a custom partial comparator is configured and the
     * comparator considers the old and new data to be equal (that is, the
     * comparator returns zero).  For more information on partial comparators
     * see {@link DatabaseConfig#setDuplicateComparator}.</p>
     *
     * <p>If the old and new data are unequal according to the comparator, a
     * {@link DuplicateDataException} is thrown.  Changing the data in this
     * case would change the sort order of the record, which would change the
     * cursor position, and this is not allowed.  To change the sort order of a
     * record, delete it and then re-insert it.</p>
     *
     * @param data - the data DatabaseEntry stored.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for partial data update.
     *
     * @return {@link com.sleepycat.je.OperationStatus#KEYEMPTY
     * OperationStatus.KEYEMPTY} if the key/pair at the cursor position has
     * been deleted; otherwise, {@link
     * com.sleepycat.je.OperationStatus#SUCCESS OperationStatus.SUCCESS}.
     *
     * @throws DuplicateDataException if the old and new data are not equal
     * according to the configured duplicate comparator or default comparator.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if the database is transactional
     * but this cursor was not opened with a non-null transaction parameter,
     * or the database is read-only.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the cursor is uninitialized (not positioned on a record), or the
     * non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus putCurrent(final DatabaseEntry data)
        throws DatabaseException, UnsupportedOperationException {

        checkState(true);
        DatabaseUtil.checkForNullDbt(data, "data", true);
        checkUpdatesAllowed("putCurrent");
        trace(Level.FINEST, "Cursor.putCurrent: ", null, data, null);

        return putInternal(null /*key*/, data, PutMode.CURRENT);
    }

    /**
     * Returns the key/data pair to which the cursor refers.
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key returned as output.  Its byte array does not need to
     * be initialized by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#KEYEMPTY
     * OperationStatus.KEYEMPTY} if the key/pair at the cursor position has
     * been deleted; otherwise, {@link
     * com.sleepycat.je.OperationStatus#SUCCESS OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the cursor is uninitialized (not positioned on a record), or the
     * non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getCurrent(final DatabaseEntry key,
                                      final DatabaseEntry data,
                                      final LockMode lockMode)
        throws DatabaseException {

        try {
            checkState(true);
            checkArgsNoValRequired(key, data);
            trace(Level.FINEST, "Cursor.getCurrent: ", lockMode);

            return getCurrentInternal(key, data, lockMode);
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * Moves the cursor to the first key/data pair of the database, and returns
     * that pair.  If the first key has duplicate values, the first data item
     * in the set of duplicates is returned.
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key returned as output.  Its byte array does not need to
     * be initialized by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getFirst(final DatabaseEntry key,
                                    final DatabaseEntry data,
                                    final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        checkArgsNoValRequired(key, data);
        trace(Level.FINEST, "Cursor.getFirst: ",lockMode);

        return position(key, data, lockMode, true);
    }

    /**
     * Moves the cursor to the last key/data pair of the database, and returns
     * that pair.  If the last key has duplicate values, the last data item in
     * the set of duplicates is returned.
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key returned as output.  Its byte array does not need to
     * be initialized by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getLast(final DatabaseEntry key,
                                   final DatabaseEntry data,
                                   final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        checkArgsNoValRequired(key, data);
        trace(Level.FINEST, "Cursor.getLast: ", lockMode);

        return position(key, data, lockMode, false);
    }

    /**
     * Moves the cursor to the next key/data pair and returns that pair.
     *
     * <p>If the cursor is not yet initialized, move the cursor to the first
     * key/data pair of the database, and return that pair.  Otherwise, the
     * cursor is moved to the next key/data pair of the database, and that pair
     * is returned.  In the presence of duplicate key values, the value of the
     * key may not change.</p>
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key returned as output.  Its byte array does not need to
     * be initialized by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getNext(final DatabaseEntry key,
                                   final DatabaseEntry data,
                                   final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        checkArgsNoValRequired(key, data);
        trace(Level.FINEST, "Cursor.getNext: ", lockMode);

        if (cursorImpl.isNotInitialized()) {
            return position(key, data, lockMode, true);
        } else {
            return retrieveNext(key, data, lockMode, GetMode.NEXT);
        }
    }

    /**
     * If the next key/data pair of the database is a duplicate data record for
     * the current key/data pair, moves the cursor to the next key/data pair of
     * the database and returns that pair.
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key returned as output.  Its byte array does not need to
     * be initialized by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the cursor is uninitialized (not positioned on a record), or the
     * non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getNextDup(final DatabaseEntry key,
                                      final DatabaseEntry data,
                                      final LockMode lockMode)
        throws DatabaseException {

        checkState(true);
        checkArgsNoValRequired(key, data);
        trace(Level.FINEST, "Cursor.getNextDup: ", lockMode);

        return retrieveNext(key, data, lockMode, GetMode.NEXT_DUP);
    }

    /**
     * Moves the cursor to the next non-duplicate key/data pair and returns
     * that pair.  If the matching key has duplicate values, the first data
     * item in the set of duplicates is returned.
     *
     * <p>If the cursor is not yet initialized, move the cursor to the first
     * key/data pair of the database, and return that pair.  Otherwise, the
     * cursor is moved to the next non-duplicate key of the database, and that
     * key/data pair is returned.</p>
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key returned as output.  Its byte array does not need to
     * be initialized by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getNextNoDup(final DatabaseEntry key,
                                        final DatabaseEntry data,
                                        final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        checkArgsNoValRequired(key, data);
        trace(Level.FINEST, "Cursor.getNextNoDup: ", lockMode);

        if (cursorImpl.isNotInitialized()) {
            return position(key, data, lockMode, true);
        } else {
            return retrieveNext(key, data, lockMode, GetMode.NEXT_NODUP);
        }
    }

    /**
     * Moves the cursor to the previous key/data pair and returns that pair.
     *
     * <p>If the cursor is not yet initialized, move the cursor to the last
     * key/data pair of the database, and return that pair.  Otherwise, the
     * cursor is moved to the previous key/data pair of the database, and that
     * pair is returned. In the presence of duplicate key values, the value of
     * the key may not change.</p>
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key returned as output.  Its byte array does not need to
     * be initialized by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getPrev(final DatabaseEntry key,
                                   final DatabaseEntry data,
                                   final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        checkArgsNoValRequired(key, data);
        trace(Level.FINEST, "Cursor.getPrev: ", lockMode);

        if (cursorImpl.isNotInitialized()) {
            return position(key, data, lockMode, false);
        } else {
            return retrieveNext(key, data, lockMode, GetMode.PREV);
        }
    }

    /**
     * If the previous key/data pair of the database is a duplicate data record
     * for the current key/data pair, moves the cursor to the previous key/data
     * pair of the database and returns that pair.
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key returned as output.  Its byte array does not need to
     * be initialized by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the cursor is uninitialized (not positioned on a record), or the
     * non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getPrevDup(final DatabaseEntry key,
                                      final DatabaseEntry data,
                                      final LockMode lockMode)
        throws DatabaseException {

        checkState(true);
        checkArgsNoValRequired(key, data);
        trace(Level.FINEST, "Cursor.getPrevDup: ", lockMode);

        return retrieveNext(key, data, lockMode, GetMode.PREV_DUP);
    }

    /**
     * Moves the cursor to the previous non-duplicate key/data pair and returns
     * that pair.  If the matching key has duplicate values, the last data item
     * in the set of duplicates is returned.
     *
     * <p>If the cursor is not yet initialized, move the cursor to the last
     * key/data pair of the database, and return that pair.  Otherwise, the
     * cursor is moved to the previous non-duplicate key of the database, and
     * that key/data pair is returned.</p>
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key returned as output.  Its byte array does not need to
     * be initialized by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getPrevNoDup(final DatabaseEntry key,
                                        final DatabaseEntry data,
                                        final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        checkArgsNoValRequired(key, data);
        trace(Level.FINEST, "Cursor.getPrevNoDup: ", lockMode);

        if (cursorImpl.isNotInitialized()) {
            return position(key, data, lockMode, false);
        } else {
            return retrieveNext(key, data, lockMode, GetMode.PREV_NODUP);
        }
    }

    /**
     * Moves the cursor to the given key of the database, and returns the datum
     * associated with the given key.  If the matching key has duplicate
     * values, the first data item in the set of duplicates is returned.
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key used as input.  It must be initialized with a
     * non-null byte array by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getSearchKey(final DatabaseEntry key,
                                        final DatabaseEntry data,
                                        final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(data, "data", false);
        trace(Level.FINEST, "Cursor.getSearchKey: ", key, null, lockMode);

        return search(key, data, lockMode, SearchMode.SET);
    }

    /**
     * Moves the cursor to the closest matching key of the database, and
     * returns the data item associated with the matching key.  If the matching
     * key has duplicate values, the first data item in the set of duplicates
     * is returned.
     *
     * <p>The returned key/data pair is for the smallest key greater than or
     * equal to the specified key (as determined by the key comparison
     * function), permitting partial key matches and range searches.</p>
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key used as input and returned as output.  It must be
     * initialized with a non-null byte array by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     *
     * @param lockMode the locking attributes; if null, default attributes
     * are used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getSearchKeyRange(final DatabaseEntry key,
                                             final DatabaseEntry data,
                                             final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(data, "data", false);
        trace(Level.FINEST, "Cursor.getSearchKeyRange: ", key, null, lockMode);

        return search(key, data, lockMode, SearchMode.SET_RANGE);
    }

    /**
     * Moves the cursor to the specified key/data pair, where both the key and
     * data items must match.
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key used as input.  It must be initialized with a
     * non-null byte array by the caller.
     *
     * @param data the data used as input.  It must be initialized with a
     * non-null byte array by the caller.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getSearchBoth(final DatabaseEntry key,
                                         final DatabaseEntry data,
                                         final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        checkArgsValRequired(key, data);
        trace(Level.FINEST, "Cursor.getSearchBoth: ", key, data, lockMode);

        return search(key, data, lockMode, SearchMode.BOTH);
    }

    /**
     * Moves the cursor to the specified key and closest matching data item of
     * the database.
     *
     * <p>In the case of any database supporting sorted duplicate sets, the
     * returned key/data pair is for the smallest data item greater than or
     * equal to the specified data item (as determined by the duplicate
     * comparison function), permitting partial matches and range searches in
     * duplicate data sets.</p>
     *
     * <p>If this method fails for any reason, the position of the cursor will
     * be unchanged.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening the cursor, unless read-uncommitted isolation is
     * specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.</p>
     *
     * @param key the key used as input and returned as output.  It must be
     * initialized with a non-null byte array by the caller.
     *
     * @param data the data used as input and returned as output.  It must be
     * initialized with a non-null byte array by the caller.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used. {@link LockMode#READ_COMMITTED} is not allowed.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the cursor or database has been closed,
     * or the non-transactional cursor was created in a different thread.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getSearchBothRange(final DatabaseEntry key,
                                              final DatabaseEntry data,
                                              final LockMode lockMode)
        throws DatabaseException {

        checkState(false);
        checkArgsValRequired(key, data);
        trace(Level.FINEST, "Cursor.getSearchBothRange: ", key, data,
              lockMode);

        return search(key, data, lockMode, SearchMode.BOTH_RANGE);
    }

    /**
     * Counts duplicates without parameter checking.
     */
    int countInternal(final LockMode lockMode) {
        try {

            /*
             * We depart from the usual beginMoveCursor/endMoveCursor sequence
             * because count() should not retain locks unless transactions are
             * used.  Therefore we always close the dup cursor after using it.
             */
            final CursorImpl dup =
                cursorImpl.cloneCursor(true /*addCursor*/, cacheMode);
            try {
                return dup.count(getLockType(lockMode, false));
            } finally {
                dup.close(cursorImpl);
            }
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * Internal version of delete() that does no parameter checking.  Calls
     * deleteNoNotify() and notifies triggers (performs secondary updates).
     */
    OperationStatus deleteInternal(final ReplicationContext repContext) {
        try {
            /* Get existing data if updating secondaries. */
            DatabaseEntry oldKey = null;
            DatabaseEntry oldData = null;
            final boolean doNotifyTriggers =
                dbHandle != null && dbHandle.hasTriggers();
            if (doNotifyTriggers) {
                oldKey = new DatabaseEntry();
                oldData = new DatabaseEntry();
                final OperationStatus status =
                    getCurrentInternal(oldKey, oldData, LockMode.RMW);
                if (status != OperationStatus.SUCCESS) {
                    return OperationStatus.KEYEMPTY;
                }
            }

            /*
             * Notify triggers before the actual deletion so that a primary
             * record never exists while secondary keys refer to it.  This is
             * relied on by secondary read-uncommitted.
             */
            if (doNotifyTriggers) {
                dbHandle.notifyTriggers(cursorImpl.getLocker(),
                                        oldKey, oldData, null);
            }

            /* The actual deletion. */
            return deleteNoNotify(repContext);
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * Delete at current position.   Does not notify triggers (does not perform
     * secondary updates).
     */
    OperationStatus deleteNoNotify(final ReplicationContext repContext) {

        /*
         * No need to use a dup cursor, since this operation does not change
         * the cursor position. 
         */
        try {
            beginUseExistingCursor();
            cursorImpl.latchBINs();
            final OperationStatus status = cursorImpl.delete(repContext);
            endUseExistingCursor();
            return status;
        } finally {
            cursorImpl.releaseBINs();
        }
    }

    /**
     * Internal version of put that does no parameter checking.  This single
     * method is used for all put operations in order to notify triggers
     * (perform secondary updates) in one place.  Prevents phantoms.
     */
    OperationStatus putInternal(final DatabaseEntry key,
                                final DatabaseEntry data,
                                final PutMode putMode) {
        final LN ln = (putMode == PutMode.CURRENT) ?
                       null :
                       (new LN(data, dbImpl.getDbEnvironment(),
                               dbImpl.isReplicated()));
        return putNotify(key, data, ln, putMode, dbImpl.getRepContext());
    }

    /**
     * Internal version of put that does no parameter checking.  This single
     * method is used for all put operations in order to notify triggers
     * (perform secondary updates) in one place.  Prevents phantoms.
     */
    OperationStatus putLN(final byte[] key,
                          final LN ln,
                          final PutMode putMode,
                          final ReplicationContext repContext) {
        assert putMode != PutMode.CURRENT;
        return putNotify(new DatabaseEntry(key),
                         new DatabaseEntry(ln.getData()),
                         ln, putMode, repContext);
    }

    /**
     * This single method is used for all put operations in order to notify
     * triggers (perform secondary updates) in one place.  Prevents phantoms.
     *
     * @param data must be null if putMode is not CURRENT and vice versa.
     *
     * @param ln must be null if putMode is CURRENT and vice versa.
     */
    private OperationStatus putNotify(DatabaseEntry key,
                                      final DatabaseEntry data,
                                      final LN ln,
                                      final PutMode putMode,
                                      final ReplicationContext repContext) {
        try {
            /* Need to get old and new data if updating secondaries. */
            DatabaseEntry oldData = null;
            DatabaseEntry newData = null;
            DatabaseEntry returnNewData = null;
            final boolean doNotifyTriggers =
                dbHandle != null && dbHandle.hasTriggers();
            if (doNotifyTriggers) {
                if (data.getPartial()) {
                    /* Return a copy after resolving partial data. [#16932] */
                    returnNewData = new DatabaseEntry();
                    newData = returnNewData;
                } else {
                    /* No copy needed if partial data is not used. */
                    newData = data;
                }
                /* Data is returned for an existing record. */
                oldData = new DatabaseEntry();
            }

            /* Perform the put operation. */
            final OperationStatus commitStatus;
            if (putMode == PutMode.CURRENT) {
                assert ln == null;
                if (doNotifyTriggers && key == null) {
                    /* Key is returned by CursorImpl.putCurrent. */
                    key = new DatabaseEntry();
                }
                commitStatus = putCurrentNoNotify(data, key, oldData,
                                                  returnNewData, repContext);
            } else {
                assert ln != null;
                commitStatus = putNoNotify(key, data, ln, putMode, oldData,
                                           returnNewData, repContext);
            }

            /* Notify triggers (update secondaries). */
            if (doNotifyTriggers && commitStatus == OperationStatus.SUCCESS) {
                if (oldData != null && oldData.getData() == null) {
                    oldData = null;
                }
                if (newData != null && newData.getData() == null) {
                    newData = null;
                }
                /* Pass newData, since data may be partial. */
                dbHandle.notifyTriggers(cursorImpl.getLocker(), key,
                                        oldData, newData);
            }
            return commitStatus;
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * Performs the put operation but does not notify triggers (does not
     * perform secondary updates).  Prevents phantoms.
     *
     * @param data is a separate param only to support partial data for user
     * operations.
     *
     * @param ln is normally a new LN node that is created for insertion, and
     * will be discarded if an update occurs.  However, HA will pass an
     * existing node for the OVERWRITE_KNOWN operation, and the node passed is
     * used for the update.
     *
     * @param putMode is required. PutMode.CURRENT is not allowed -- use
     * putCurrentNoNotify instead.
     */
    private OperationStatus putNoNotify(final DatabaseEntry key,
                                        final DatabaseEntry data,
                                        final LN ln,
                                        final PutMode putMode,
                                        final DatabaseEntry returnOldData,
                                        final DatabaseEntry returnNewData,
                                        final ReplicationContext repContext) {
        assert key != null;
        assert ln != null;
        assert putMode != null;
        assert putMode != PutMode.CURRENT;

        Locker nextKeyLocker = null;
        CursorImpl nextKeyCursor = null;
        try {
            /* If other transactions are serializable, lock the next key. */
            Locker cursorLocker = cursorImpl.getLocker();
            if (dbImpl.getDbEnvironment().
                getTxnManager().
                areOtherSerializableTransactionsActive(cursorLocker)) {
                nextKeyLocker = BuddyLocker.createBuddyLocker
                    (dbImpl.getDbEnvironment(), cursorLocker);
                nextKeyCursor = new CursorImpl(dbImpl, nextKeyLocker);
                /* Perform eviction for user cursors. */
                nextKeyCursor.setAllowEviction(true);
                nextKeyCursor.lockNextKeyForInsert(key, data);
            }

            /* Perform the put operation. */
            return putAllowPhantoms
                (key, data, ln, putMode, returnOldData, returnNewData,
                 nextKeyCursor, repContext);
        } finally {
            /* Release the next-key lock. */
            if (nextKeyCursor != null) {
                nextKeyCursor.close();
            }
            if (nextKeyLocker != null) {
                nextKeyLocker.operationEnd();
            }
        }
    }

    /**
     * Clones the cursor, put key/data according to PutMode, and if successful,
     * swap cursors.  Does not notify triggers (does not perform secondary
     * updates).  Does not prevent phantoms.
     *
     * @param nextKeyCursor is the cursor used to lock the next key during
     * phantom prevention.  If this cursor is non-null and initialized, it's
     * BIN will be used to initialize the dup cursor used to perform insertion.
     * This enables an optimization in Tree.findBinForInsert that skips the
     * search for the BIN.
     */
    private OperationStatus
        putAllowPhantoms(final DatabaseEntry key,
                         final DatabaseEntry data,
                         final LN ln,
                         final PutMode putMode,
                         final DatabaseEntry returnOldData,
                         final DatabaseEntry returnNewData,
                         final CursorImpl nextKeyCursor,
                         final ReplicationContext repContext) {
        OperationStatus status = OperationStatus.NOTFOUND;

        /*
         * Do not call addCursor when inserting.  Copy the position of
         * nextKeyCursor if available.
         */
        final CursorImpl dup = beginMoveCursor(false, nextKeyCursor);
        try {
            /* Perform operation. */
            status = dup.put(key, data, ln, putMode, returnOldData,
                             returnNewData, repContext);
            /* Note that status is used in the finally. */
            return status;
        } finally {
            endMoveCursor(dup, status == OperationStatus.SUCCESS);
        }
    }

    /**
     * Update the data at the current position.  No new LN, dup cursor, or
     * phantom handling is needed. 
     */
    private OperationStatus
        putCurrentNoNotify(final DatabaseEntry data,
                           final DatabaseEntry returnKey,
                           final DatabaseEntry returnOldData,
                           final DatabaseEntry returnNewData,
                           final ReplicationContext repContext) {
        assert data != null;
        beginUseExistingCursor();
        final OperationStatus status = cursorImpl.putCurrent
            (data, returnKey, returnOldData, returnNewData,
             Node.NULL_NODE_ID /*checkNodeId*/, repContext);
        endUseExistingCursor();
        return status;
    }

    /**
     * Positions the cursor at the first or last record of the database.
     * Prevents phantoms.
     */
    OperationStatus position(final DatabaseEntry key,
                             final DatabaseEntry data,
                             final LockMode lockMode,
                             final boolean first) {
        try {
            if (!isSerializableIsolation(lockMode)) {
                return positionAllowPhantoms
                    (key, data, getLockType(lockMode, false), first);
            }

            /*
             * Perform range locking to prevent phantoms and handle restarts.
             */
            while (true) {
                try {
                    /* Range lock the EOF node before getLast. */
                    if (!first) {
                        cursorImpl.lockEofNode(LockType.RANGE_READ);
                    }

                    /* Use a range lock for getFirst. */
                    final LockType lockType = getLockType(lockMode, first);

                    /* Perform operation. */
                    final OperationStatus status =
                        positionAllowPhantoms(key, data, lockType, first);

                    /*
                     * Range lock the EOF node when getFirst returns NOTFOUND.
                     */
                    if (first && status != OperationStatus.SUCCESS) {
                        cursorImpl.lockEofNode(LockType.RANGE_READ);
                    }

                    return status;
                } catch (RangeRestartException e) {
                    continue;
                }
            }
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * Positions without preventing phantoms.
     */
    private OperationStatus positionAllowPhantoms(final DatabaseEntry key,
                                                  final DatabaseEntry data,
                                                  final LockType lockType,
                                                  final boolean first) {
        assert (key != null && data != null);

        OperationStatus status = OperationStatus.NOTFOUND;

        /*
         * Pass false: no need to call addCursor here because
         * CursorImpl.position will be adding it after it finds the bin.
         */
        final CursorImpl dup = beginMoveCursor(false);
        try {
            /* Search for first or last. */
            if (!dup.positionFirstOrLast(first, null)) {
                /* Tree is empty. */
                status = OperationStatus.NOTFOUND;
                assert LatchSupport.countLatchesHeld() == 0:
                    LatchSupport.latchesHeldToString();
            } else {
                /* Found something in this tree. */
                assert LatchSupport.countLatchesHeld() == 1:
                    LatchSupport.latchesHeldToString();

                status = dup.getCurrentAlreadyLatched
                    (key, data, lockType, first);

                if (status != OperationStatus.SUCCESS) {
                    /* The record we're pointing at may be deleted. */
                    status = dup.getNext(key, data, lockType, first, false);
                }
            }
        } finally {

            /*
             * positionFirstOrLast returns with the target BIN latched, so it
             * is the responsibility of this method to make sure the latches
             * are released.
             */
            cursorImpl.releaseBINs();
            endMoveCursor(dup, status == OperationStatus.SUCCESS);
        }
        return status;
    }

    /**
     * Performs search by key, data, or both.  Prevents phantoms.
     */
    OperationStatus search(final DatabaseEntry key,
                           final DatabaseEntry data,
                           final LockMode lockMode,
                           final SearchMode searchMode) {
        try {
            if (!isSerializableIsolation(lockMode)) {
                final LockType lockType = getLockType(lockMode, false);
                final KeyChangeStatus result = searchAllowPhantoms
                    (key, data, lockType, lockType, searchMode);
                return result.status;
            }

            /*
             * Perform range locking to prevent phantoms and handle restarts.
             */
            while (true) {
                try {
                    /* Do not use a range lock for the initial search. */
                    final LockType searchLockType =
                        getLockType(lockMode, false);

                    /* Switch to a range lock when advancing forward. */
                    final LockType advanceLockType =
                        getLockType(lockMode, true);

                    /* Do not modify key/data params until SUCCESS. */
                    final DatabaseEntry tryKey = new DatabaseEntry
                        (key.getData(), key.getOffset(), key.getSize());
                    final DatabaseEntry tryData = new DatabaseEntry
                        (data.getData(), data.getOffset(), data.getSize());
                    final KeyChangeStatus result;

                    if (searchMode.isExactSearch()) {

                        /*
                         * Artificial range search to range lock the next key.
                         */
                        result = searchExactAndRangeLock
                            (tryKey, tryData, searchLockType, advanceLockType,
                             searchMode);
                    } else {
                        /* Normal range search. */
                        result = searchAllowPhantoms
                            (tryKey, tryData, searchLockType, advanceLockType,
                             searchMode);

                        /* Lock the EOF node if no records follow the key. */
                        if (result.status != OperationStatus.SUCCESS) {
                            cursorImpl.lockEofNode(LockType.RANGE_READ);
                        }
                    }

                    /*
                     * Only overwrite key/data on SUCCESS, after all locking.
                     */
                    if (result.status == OperationStatus.SUCCESS) {
                        key.setData(tryKey.getData(), 0, tryKey.getSize());
                        data.setData(tryData.getData(), 0, tryData.getSize());
                    }

                    return result.status;
                } catch (RangeRestartException e) {
                    continue;
                }
            }
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * For an exact search, performs a range search and returns NOTFOUND if the
     * key changes (or if the data changes for BOTH) during the search.
     * If no exact match is found the range search will range lock the
     * following key for phantom prevention.  Importantly, the cursor position
     * is not changed if an exact match is not found, even though we advance to
     * the following key in order to range lock it.
     */
    private KeyChangeStatus
        searchExactAndRangeLock(final DatabaseEntry key,
                                final DatabaseEntry data,
                                final LockType searchLockType,
                                final LockType advanceLockType,
                                SearchMode searchMode) {
        /* Convert exact search to range search. */
        searchMode = (searchMode == SearchMode.SET) ?
            SearchMode.SET_RANGE : SearchMode.BOTH_RANGE;

        KeyChangeStatus result = null;

        final CursorImpl dup =
            beginMoveCursor(false /* searchAndPosition will add cursor */);

        try {

            /*
             * Perform a range search and return NOTFOUND if an exact match is
             * not found.  Pass advanceAfterRangeSearch=true to advance even if
             * the key is not matched, to lock the following key.
             */
            result = searchInternal
                (dup, key, data, searchLockType, advanceLockType, searchMode,
                 true /*advanceAfterRangeSearch*/);

            /* If the key changed, then we do not have an exact match. */
            if (result.keyChange && result.status == OperationStatus.SUCCESS) {
                result.status = OperationStatus.NOTFOUND;
            }
        } finally {
            endMoveCursor(dup, result != null &&
                               result.status == OperationStatus.SUCCESS);
        }

        /*
         * Lock the EOF node if there was no exact match and we did not
         * range-lock the next record.
         */
        if (result.status != OperationStatus.SUCCESS && !result.keyChange) {
            cursorImpl.lockEofNode(LockType.RANGE_READ);
        }

        return result;
    }

    /**
     * Performs search without preventing phantoms.
     */
    private KeyChangeStatus searchAllowPhantoms(final DatabaseEntry key,
                                                final DatabaseEntry data,
                                                final LockType searchLockType,
                                                final LockType advanceLockType,
                                                final SearchMode searchMode) {
        OperationStatus status = OperationStatus.NOTFOUND;

        final CursorImpl dup =
            beginMoveCursor(false /* searchAndPosition will add cursor */);

        try {
            final KeyChangeStatus result = searchInternal
                (dup, key, data, searchLockType, advanceLockType, searchMode,
                 false /*advanceAfterRangeSearch*/);

            status = result.status;
            /* Note that status is used in the finally. */
            return result;
        } finally {
            endMoveCursor(dup, status == OperationStatus.SUCCESS);
        }
    }

    /**
     * Performs search for a given CursorImpl.
     */
    private KeyChangeStatus searchInternal(final CursorImpl dup,
                                           final DatabaseEntry key,
                                           final DatabaseEntry data,
                                           final LockType searchLockType,
                                           final LockType advanceLockType,
                                           final SearchMode searchMode,
                                           final boolean
                                                 advanceAfterRangeSearch) {
        assert key != null && data != null;

        OperationStatus status = OperationStatus.NOTFOUND;
        boolean keyChange = false;

        try {
            /* search */
            final int searchResult =
                dup.searchAndPosition(key, data, searchMode, searchLockType);
            if ((searchResult & CursorImpl.FOUND) != 0) {

                /*
                 * The search found a possibly valid record.
                 * CursorImpl.searchAndPosition's job is to settle the cursor
                 * at a particular location on a BIN. In some cases, the
                 * current position may not actually hold a valid record, so
                 * it's this layer's responsiblity to judge if it might need to
                 * bump the cursor along and search more. For example, we might
                 * have to do so if the position holds a deleted record.
                 *
                 * Advance the cursor if:
                 *
                 * 1. This is a range type search and there was no match on the
                 * search criteria (the key or key and data depending on the
                 * type of search). Then we search forward until there's a
                 * match.
                 *
                 * 2. If this is not a range type search, check the record at
                 * the current position. If this is not a duplicate set,
                 * CursorImpl.searchAndPosition gave us an exact answer.
                 * However since it doesn't peer into the duplicate set, we may
                 * need to probe further in if there are deleted records in the
                 * duplicate set. i.e, we have to be able to find k1/d2 even if
                 * there's k1/d1(deleted), k1/d2, k1/d3, etc in a duplicate
                 * set.
                 *
                 * Note that searchResult has four bits possibly set:
                 *
                 * FOUND has already been checked above.
                 *
                 * EXACT_KEY means an exact match on the key portion was made.
                 *
                 * EXACT_DATA means that if searchMode was BOTH or BOTH_RANGE
                 * then an exact match was made on the data (in addition to the
                 * key).
                 *
                 * FOUND_LAST means that the cursor is positioned at the last
                 * record in the database.
                 */
                final boolean exactKeyMatch =
                    ((searchResult & CursorImpl.EXACT_KEY) != 0);
                final boolean exactDataMatch =
                    ((searchResult & CursorImpl.EXACT_DATA) != 0);
                final boolean foundLast =
                    ((searchResult & CursorImpl.FOUND_LAST) != 0);

                /*
                 * rangeMatch means that a range match of some sort (either
                 * SET_RANGE or BOTH_RANGE) was specified and there wasn't a
                 * complete match.  If SET_RANGE was spec'd and EXACT_KEY was
                 * not returned as set, then the key didn't match exactly.  If
                 * BOTH_RANGE was spec'd and EXACT_DATA was not returned as
                 * set, then the data didn't match exactly.
                 */
                boolean rangeMatch = false;
                if (searchMode == SearchMode.SET_RANGE &&
                    !exactKeyMatch) {
                    rangeMatch = true;
                }

                if (searchMode == SearchMode.BOTH_RANGE &&
                    (!exactKeyMatch || !exactDataMatch)) {
                    rangeMatch = true;
                }

                /*
                 * Pass null for key to getCurrentAlreadyLatched if searchMode
                 * is SET since the key is not supposed to be set in that case.
                 */
                final DatabaseEntry useKey =
                    (searchMode == SearchMode.SET) ?
                    null : key;

                /*
                 * rangeMatch => an exact match was not found so we need to
                 * advance the cursor to a real item using getNextXXX.  If
                 * rangeMatch is true, then cursor is currently on some entry,
                 * but that entry is either deleted or is prior to the target
                 * key/data.  It is also possible that rangeMatch is false (we
                 * have an exact match) but the entry is deleted.  So we test
                 * for rangeMatch or a deleted entry, and if either is true
                 * then we advance to the next non-deleted entry.
                 */
                if (rangeMatch ||
                    (status = dup.getCurrentAlreadyLatched
                     (useKey, data, searchLockType, true)) ==
                    OperationStatus.KEYEMPTY) {

                    if (foundLast) {
                        status = OperationStatus.NOTFOUND;
                    } else if (searchMode == SearchMode.SET) {

                        /*
                         * SET is an exact operation, so this isn't a
                         * rangeMatch, it's a deleted record.  We should
                         * advance, but only to duplicates for the same key.
                         */
                        status = dup.getNextDuplicate
                            (key, data, advanceLockType, true, rangeMatch);
                    } else if (searchMode == SearchMode.BOTH) {

                        /*
                         * BOTH is also an exact operation, but we should not
                         * advance past a deleted record because the data match
                         * is exact.  However, this API should return NOTFOUND
                         * instead of KEYEMPTY (which may be been set above).
                         */
                        if (status == OperationStatus.KEYEMPTY) {
                            status = OperationStatus.NOTFOUND;
                        }
                    } else {
                        assert !searchMode.isExactSearch();

                        /* Save the search key for a BOTH_RANGE search. */
                        byte[] searchKey = null;
                        if (searchMode.isDataSearch()) {
                            searchKey = Key.makeKey(key);
                        }

                        /*
                         * This may be a deleted record or a rangeMatch, and in
                         * either case we should advance.  We must determine
                         * whether the key changes when we advance.
                         */
                        if (exactKeyMatch) {
                            final KeyChangeStatus result =
                                dup.getNextWithKeyChangeStatus
                                (key, data, advanceLockType, true, rangeMatch);
                            status = result.status;

                            /*
                             * For BOTH_RANGE, advancing always causes a data
                             * change, which is considered a key change.  For
                             * SET_RANGE, getNextWithKeyChangeStatus determined
                             * the key change status.
                             */
                            keyChange = searchMode.isDataSearch() ?
                                (status == OperationStatus.SUCCESS) :
                                result.keyChange;

                        } else if (searchMode.isDataSearch() &&
                                   !advanceAfterRangeSearch) {

                            /*
                             * If we did not match the key (exactly) for
                             * BOTH_RANGE, and advanceAfterRangeSearch is
                             * false, then return NOTFOUND.
                             */
                             status = OperationStatus.NOTFOUND;
                        } else {

                            /*
                             * If we didn't match the key, skip over duplicates
                             * to the next key with getNextNoDup.
                             */
                            status = dup.getNextNoDup
                                (key, data, advanceLockType, true, rangeMatch);

                            /* getNextNoDup always causes a key change. */
                            keyChange = (status == OperationStatus.SUCCESS);
                        }

                        /*
                         * If we moved past the search key after a BOTH_RANGE
                         * search, return NOTFOUND.  Leave the keyChange value
                         * intact, since we want to return this accurately
                         * regardless of the status return.
                         */
                        if (status == OperationStatus.SUCCESS &&
                            searchMode.isDataSearch()) {
                            if (Key.compareKeys
                                (key.getData(), searchKey,
                                 dbImpl.getBtreeComparator()) != 0) {
                                status = OperationStatus.NOTFOUND;
                            }
                        }
                    }
                }
            }
        } finally {

            /*
             * searchAndPosition returns with the target BIN latched, so it is
             * the responsibility of this method to make sure the latches are
             * released.
             */
            cursorImpl.releaseBINs();
            if (status != OperationStatus.SUCCESS && dup != cursorImpl) {
                dup.releaseBINs();
            }
        }

        return new KeyChangeStatus(status, keyChange);
    }

    /**
     * Retrieves the next or previous record.  Prevents phantoms.
     */
    OperationStatus retrieveNext(final DatabaseEntry key,
                                 final DatabaseEntry data,
                                 final LockMode lockMode,
                                 final GetMode getMode) {
        try {
            if (!isSerializableIsolation(lockMode)) {
                return retrieveNextAllowPhantoms
                    (key, data, getLockType(lockMode, false), getMode);
            }

            /*
             * Perform range locking to prevent phantoms and handle restarts.
             */
            while (true) {
                try {
                    final OperationStatus status;
                    if (getMode == GetMode.NEXT_DUP) {

                        /*
                         * Special case to lock the next key if no more dups.
                         */
                        status = getNextDupAndRangeLock(key, data, lockMode);
                    } else {

                        /* Get a range lock for 'prev' operations. */
                        if (!getMode.isForward()) {
                            rangeLockCurrentPosition(getMode);
                        }

                        /*
                         * Use a range lock if performing a 'next' operation.
                         */
                        final LockType lockType =
                            getLockType(lockMode, getMode.isForward());

                        /* Perform the operation. */
                        status = retrieveNextAllowPhantoms
                            (key, data, lockType, getMode);

                        if (getMode.isForward() &&
                            status != OperationStatus.SUCCESS) {
                            /* NEXT, NEXT_NODUP: lock the EOF node. */
                            cursorImpl.lockEofNode(LockType.RANGE_READ);
                        }
                    }

                    return status;
                } catch (RangeRestartException e) {
                    continue;
                }
            }
        } catch (Error E) {
            dbImpl.getDbEnvironment().invalidate(E);
            throw E;
        }
    }

    /**
     * Retrieves the next dup; if no next dup is found then range lock the
     * following key for phantom prevention.  Importantly, the cursor position
     * is not changed if there are no more dups, even though we advance to the
     * following key in order to range lock it.
     */
    private OperationStatus getNextDupAndRangeLock(final DatabaseEntry key,
                                                   final DatabaseEntry data,
                                                   final LockMode lockMode) {
        /* Do not modify key/data params until SUCCESS. */
        DatabaseEntry tryKey = new DatabaseEntry();
        DatabaseEntry tryData = new DatabaseEntry();

        /* Get a range lock. */
        final LockType lockType = getLockType(lockMode, true);
        OperationStatus status;
        boolean noNextKeyFound;

        /*
         * Perform a NEXT and return NOTFOUND if the key changes
         * during the search.
         */
        while (true) {
            assert LatchSupport.countLatchesHeld() == 0;
            CursorImpl dup = beginMoveCursor(true);

            try {
                KeyChangeStatus result = dup.getNextWithKeyChangeStatus
                    (tryKey, tryData, lockType, true, false);
                status = result.status;
                noNextKeyFound = (status != OperationStatus.SUCCESS);
                if (result.keyChange && status == OperationStatus.SUCCESS) {
                    status = OperationStatus.NOTFOUND;
                }
            } catch (DatabaseException DBE) {
                endMoveCursor(dup, false);
                throw DBE;
            }

            if (checkForInsertion(GetMode.NEXT, cursorImpl, dup)) {
                endMoveCursor(dup, false);
                continue;
            } else {
                endMoveCursor(dup, status == OperationStatus.SUCCESS);
                assert LatchSupport.countLatchesHeld() == 0;
                break;
            }
        }

        /* Lock the EOF node if no more records, whether or not more dups. */
        if (noNextKeyFound) {
            cursorImpl.lockEofNode(LockType.RANGE_READ);
        }

        /* Only overwrite key/data on SUCCESS. */
        if (status == OperationStatus.SUCCESS) {
            key.setData(tryKey.getData(), 0, tryKey.getSize());
            data.setData(tryData.getData(), 0, tryData.getSize());
        }

        return status;
    }

    /**
     * For 'prev' operations, upgrades to a range lock at the current position.
     * For PREV_NODUP, range locks the first duplicate instead.  If there are
     * no records at the current position, get a range lock on the next record
     * or, if not found, on the logical EOF node.  Do not modify the current
     * cursor position, use a separate cursor.
     */
    private void rangeLockCurrentPosition(final GetMode getMode) {
        final DatabaseEntry tempKey = new DatabaseEntry();
        final DatabaseEntry tempData = new DatabaseEntry();
        tempKey.setPartial(0, 0, true);
        tempData.setPartial(0, 0, true);

        OperationStatus status;
        CursorImpl dup = cursorImpl.cloneCursor(true /*addCursor*/, cacheMode);
        try {
            if (getMode == GetMode.PREV_NODUP) {
                status = dup.getFirstDuplicate
                    (tempKey, tempData, LockType.RANGE_READ);
            } else {
                status = dup.getCurrent
                    (tempKey, tempData, LockType.RANGE_READ);
            }
            if (status != OperationStatus.SUCCESS) {
                while (true) {
                    assert LatchSupport.countLatchesHeld() == 0;

                    status = dup.getNext
                        (tempKey, tempData, LockType.RANGE_READ, true, false);

                    if (checkForInsertion(GetMode.NEXT, cursorImpl, dup)) {
                        dup.close(cursorImpl);
                        dup = cursorImpl.cloneCursor(true /*addCursor*/,
                                                     cacheMode);
                        continue;
                    } else {
                        assert LatchSupport.countLatchesHeld() == 0;
                        break;
                    }
                }
            }
        } finally {
            dup.close(cursorImpl);
        }

        if (status != OperationStatus.SUCCESS) {
            cursorImpl.lockEofNode(LockType.RANGE_READ);
        }
    }

    /**
     * Retrieves without preventing phantoms.
     */
    private OperationStatus retrieveNextAllowPhantoms(final DatabaseEntry key,
                                                      final DatabaseEntry data,
                                                      final LockType lockType,
                                                      final GetMode getMode) {
        assert (key != null && data != null);

        OperationStatus status;

        while (true) {
            assert LatchSupport.countLatchesHeld() == 0;
            final CursorImpl dup = beginMoveCursor(true);

            try {
                if (getMode == GetMode.NEXT) {
                    status = dup.getNext
                        (key, data, lockType, true, false);
                } else if (getMode == GetMode.PREV) {
                    status = dup.getNext
                        (key, data, lockType, false, false);
                } else if (getMode == GetMode.NEXT_DUP) {
                    status = dup.getNextDuplicate
                        (key, data, lockType, true, false);
                } else if (getMode == GetMode.PREV_DUP) {
                    status = dup.getNextDuplicate
                        (key, data, lockType, false, false);
                } else if (getMode == GetMode.NEXT_NODUP) {
                    status = dup.getNextNoDup
                        (key, data, lockType, true, false);
                } else if (getMode == GetMode.PREV_NODUP) {
                    status = dup.getNextNoDup
                        (key, data, lockType, false, false);
                } else {
                    throw EnvironmentFailureException.unexpectedState
                        ("unknown GetMode: " + getMode);
                }
            } catch (DatabaseException DBE) {
                endMoveCursor(dup, false);
                throw DBE;
            }

            if (checkForInsertion(getMode, cursorImpl, dup)) {
                endMoveCursor(dup, false);
                continue;
            } else {
                endMoveCursor(dup, status == OperationStatus.SUCCESS);
                assert LatchSupport.countLatchesHeld() == 0;
                break;
            }
        }
        return status;
    }

    /**
     * Returns the current key and data.  There is no need to use a dup cursor
     * or prevent phantoms.
     */
    OperationStatus getCurrentInternal(final DatabaseEntry key,
                                       final DatabaseEntry data,
                                       final LockMode lockMode) {
        /* Do not use a range lock. */
        final LockType lockType = getLockType(lockMode, false);

        beginUseExistingCursor();
        final OperationStatus status =
            cursorImpl.getCurrent(key, data, lockType);
        endUseExistingCursor();
        return status;
    }

    /*
     * Something may have been added to the original cursor (cursorImpl) while
     * we were getting the next BIN.  cursorImpl would have been adjusted
     * properly but we would have skipped a BIN in the process.
     *
     * Note that when we call LN.isDeleted(), we do not need to lock the LN.
     * If we see a non-committed deleted entry, we'll just iterate around in
     * the caller.  So a false positive is ok.
     *
     * @return true if an unaccounted for insertion happened.
     */
    private boolean checkForInsertion(final GetMode getMode,
                                      final CursorImpl origCursor,
                                      final CursorImpl dupCursor) {
        final BIN origBIN = origCursor.getBIN();
        final BIN dupBIN = dupCursor.getBIN();
        final DBIN origDBIN = origCursor.getDupBIN();

        /* If fetchTarget returns null below, a deleted LN was cleaned. */

        boolean forward = true;
        if (getMode == GetMode.PREV ||
            getMode == GetMode.PREV_DUP ||
            getMode == GetMode.PREV_NODUP) {
            forward = false;
        }
        boolean ret = false;
        if (origBIN != dupBIN) {
            /* We jumped to the next BIN during getNext(). */
            origCursor.latchBINs();

            try {
                if (origDBIN == null) {
                    if (forward) {
                        if (origBIN.getNEntries() - 1 >
                            origCursor.getIndex()) {

                            /*
                             * We were adjusted to something other than the
                             * last entry so some insertion happened.
                             */
                            for (int i = origCursor.getIndex() + 1;
                                 i < origBIN.getNEntries();
                                 i++) {
                                if (!origBIN.isEntryKnownDeleted(i)) {
                                    final Node n = origBIN.fetchTarget(i);
                                    if (n != null && !n.containsDuplicates()) {
                                        final LN ln = (LN) n;
                                        /* See comment above about locking. */
                                        if (!ln.isDeleted()) {
                                            ret = true;
                                            break;
                                        }
                                    }
                                } else {
                                    /* Need to check the DupCountLN. */
                                }
                            }
                        }
                    } else {
                        if (origCursor.getIndex() > 0) {

                            /*
                             * We were adjusted to something other than the
                             * first entry so some insertion happened.
                             */
                            for (int i = 0; i < origCursor.getIndex(); i++) {
                                if (!origBIN.isEntryKnownDeleted(i)) {
                                    final Node n = origBIN.fetchTarget(i);
                                    if (n != null && !n.containsDuplicates()) {
                                        final LN ln = (LN) n;
                                        /* See comment above about locking. */
                                        if (!ln.isDeleted()) {
                                            ret = true;
                                            break;
                                        }
                                    } else {
                                        /* Need to check the DupCountLN. */
                                    }
                                }
                            }
                        }
                    }
                }
            } finally {
                origCursor.releaseBINs();
            }
            return ret;
        }

        if (origDBIN != dupCursor.getDupBIN() &&
            origCursor.getIndex() == dupCursor.getIndex() &&
            getMode != GetMode.NEXT_NODUP &&
            getMode != GetMode.PREV_NODUP) {
            /* Same as above, only for the dupBIN. */
            origCursor.latchBINs();
            try {
                if (forward) {
                    if (origDBIN.getNEntries() - 1 >
                        origCursor.getDupIndex()) {

                        /*
                         * We were adjusted to something other than the last
                         * entry so some insertion happened.
                         */
                        for (int i = origCursor.getDupIndex() + 1;
                             i < origDBIN.getNEntries();
                             i++) {
                            if (!origDBIN.isEntryKnownDeleted(i)) {
                                final Node n = origDBIN.fetchTarget(i);
                                final LN ln = (LN) n;
                                /* See comment above about locking. */
                                if (n != null && !ln.isDeleted()) {
                                    ret = true;
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    if (origCursor.getDupIndex() > 0) {

                        /*
                         * We were adjusted to something other than the first
                         * entry so some insertion happened.
                         */
                        for (int i = 0; i < origCursor.getDupIndex(); i++) {
                            if (!origDBIN.isEntryKnownDeleted(i)) {
                                final Node n = origDBIN.fetchTarget(i);
                                final LN ln = (LN) n;
                                /* See comment above about locking. */
                                if (n != null && !ln.isDeleted()) {
                                    ret = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            } finally {
                origCursor.releaseBINs();
            }
            return ret;
        }
        return false;
    }

    /**
     * Called to start an operation that potentially moves the cursor.
     *
     * If the cursor is initialized and cloning is enabled, dups it and returns
     * the dup; otherwise, return the original.  This avoids the overhead of
     * duping when the original is uninitialized or cloning is not needed.  The
     * cursor returned must be passed to endMoveCursor() to close the correct
     * cursor.
     *
     * Perform eviction before each cursor operation.  This is done by
     * CursorImpl.cloneCursor()/reset(), or is done here explicitly when the
     * cursor is not cloned or reset.
     *
     * @param addCursor is true to add the current position (BIN/DBIN) to the
     * duplicated cursor.  If false, the caller will not remove the cursor from
     * the current position when moving it to a new position.  Therefore, if
     * this param is false, and cloning is disabled, and the cursor is
     * intialized, we must reset the cursor [#16280].
     *
     * @param usePosition copy this cursor position when duplicating, to
     * enable an optimization that uses the current position for an insert
     * after a search.  This optimization currently only applies when cloning
     * is enabled and the cursor is already initialized.
     *
     * @see CursorImpl#performCacheEviction for a description of how the
     * cacheMode field is used.  This method ensures that the correct cache
     * mode is used before each operation.
     */
    private CursorImpl beginMoveCursor(final boolean addCursor,
                                       final CursorImpl usePosition) {
        /* Must set cache mode before calling criticalEviction or reset. */
        if (cursorImpl.isNotInitialized()) {
            cursorImpl.setCacheMode(cacheMode);
            cursorImpl.criticalEviction();
            return cursorImpl;
        }
        if (nonCloning) {
            cursorImpl.setCacheMode(cacheMode);
            if (addCursor) {
                cursorImpl.criticalEviction();
            } else {
                cursorImpl.reset();
            }
            return cursorImpl;
        }
        CursorImpl dup =
            cursorImpl.cloneCursor(addCursor, cacheMode, usePosition);
        dup.setClosingLocker(cursorImpl);
        return dup;
    }

    private CursorImpl beginMoveCursor(final boolean addCursor) {
        return beginMoveCursor(addCursor, null);
    }

    /**
     * Called to end an operation that potentially moves the cursor.
     *
     * If the operation is successful, swaps cursors and closes the original
     * cursor; otherwise, closes the duped cursor.  In the case where the
     * original cursor was not duped by beginMoveCursor because it was
     * uninitialized, just resets the original cursor if the operation did not
     * succeed.
     *
     * Perform eviction after each cursor operation.  This is done by
     * CursorImpl.reset() and close(), or is done here explicitly when the
     * cursor is not cloned.
     */
    private void endMoveCursor(final CursorImpl dup, final boolean success) {
        dup.clearClosingLocker();
        if (dup == cursorImpl) {
            if (success) {
                cursorImpl.criticalEviction();
            } else {
                cursorImpl.reset();
            }

            /*
             * Do not refresh the default CacheMode here to avoid calling
             * dbImpl.getDefaultCacheMode() twice when a cursor is only used
             * for a single operation.
             */
        } else {
            if (success) {
                cursorImpl.close(dup);
                cursorImpl = dup;
            } else {
                dup.close(cursorImpl);
            }

            /*
             * In case the default CacheMode is changed when a cursor is used
             * for many operations, get a fresh default CacheMode for the next
             * operation.
             */
            if (!cacheModeOverridden) {
                cacheMode = dbImpl.getDefaultCacheMode();
            }
        }
    }

    /**
     * Called to start an operation that does not move the cursor, and
     * therefore does not clone the cursor.  Either beginUseExistingCursor /
     * endUseExistingCursor or beginMoveCursor / endMoveCursor must be used for
     * each operation.
     */
    private void beginUseExistingCursor() {
        /* Must set cache mode before calling criticalEviction. */
        cursorImpl.setCacheMode(cacheMode);
        cursorImpl.criticalEviction();
    }

    /**
     * Called to end an operation that does not move the cursor.
     */
    private void endUseExistingCursor() {
        cursorImpl.criticalEviction();
    }

    boolean advanceCursor(final DatabaseEntry key, final DatabaseEntry data) {
        return cursorImpl.advanceCursor(key, data);
    }

    private LockType getLockType(final LockMode lockMode,
                                 final boolean rangeLock) {

        if (isReadUncommittedMode(lockMode)) {
            return LockType.NONE;
        } else if (lockMode == null || lockMode == LockMode.DEFAULT) {
            return rangeLock ? LockType.RANGE_READ: LockType.READ;
        } else if (lockMode == LockMode.RMW) {
            return rangeLock ? LockType.RANGE_WRITE: LockType.WRITE;
        } else if (lockMode == LockMode.READ_COMMITTED) {
            throw new IllegalArgumentException
                (lockMode.toString() + " not allowed with Cursor methods, " +
                 "use CursorConfig.setReadCommitted instead.");
        } else {
            assert false : lockMode;
            return LockType.NONE;
        }
    }

    /**
     * Returns whether the given lock mode will cause a read-uncommitted when
     * used with this cursor, taking into account the default cursor
     * configuration.
     */
    boolean isReadUncommittedMode(final LockMode lockMode) {

        return (lockMode == LockMode.READ_UNCOMMITTED ||
                (readUncommittedDefault &&
                 (lockMode == null || lockMode == LockMode.DEFAULT)));
    }

    private boolean isSerializableIsolation(final LockMode lockMode) {

        return serializableIsolationDefault &&
               !isReadUncommittedMode(lockMode);
    }

    /**
     * @hidden
     * For internal use only.
     *
     * @throws UnsupportedOperationException via all Cursor write methods.
     */
    protected void checkUpdatesAllowed(final String operation) {
        if (updateOperationsProhibited) {
            throw new UnsupportedOperationException
                ("A transaction was not supplied when opening this cursor: " +
                 operation);
        }
    }

    /**
     * Note that this flavor of checkArgs doesn't require that the key and data
     * are not null.
     */
    private void checkArgsNoValRequired(final DatabaseEntry key,
                                        final DatabaseEntry data) {
        DatabaseUtil.checkForNullDbt(key, "key", false);
        DatabaseUtil.checkForNullDbt(data, "data", false);
    }

    /**
     * Note that this flavor of checkArgs requires that the key and data are
     * not null.
     */
    private void checkArgsValRequired(final DatabaseEntry key,
                                      final DatabaseEntry data) {
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(data, "data", true);
    }

    /**
     * Checks the environment and cursor state.
     */
    void checkState(final boolean mustBeInitialized) {
        checkEnv();
        if (dbHandle != null) {
            dbHandle.checkOpen("Can't call Cursor method:");
        }
        cursorImpl.checkCursorState(mustBeInitialized);
    }

    /**
     * @throws EnvironmentFailureException if the underlying environment is
     * invalid.
     */
    void checkEnv() {
        cursorImpl.checkEnv();
    }

    /**
     * Sends trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    void trace(final Level level,
               final String methodName,
               final DatabaseEntry key,
               final DatabaseEntry data,
               final LockMode lockMode) {
        if (logger.isLoggable(level)) {
            final StringBuffer sb = new StringBuffer();
            sb.append(methodName);
            traceCursorImpl(sb);
            if (key != null) {
                sb.append(" key=").append(key.dumpData());
            }
            if (data != null) {
                sb.append(" data=").append(data.dumpData());
            }
            if (lockMode != null) {
                sb.append(" lockMode=").append(lockMode);
            }
            LoggerUtils.logMsg
                (logger, dbImpl.getDbEnvironment(), level, sb.toString());
        }
    }
    /**
     * Sends trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    void trace(final Level level,
               final String methodName,
               final LockMode lockMode) {
        if (logger.isLoggable(level)) {
            final StringBuffer sb = new StringBuffer();
            sb.append(methodName);
            traceCursorImpl(sb);
            if (lockMode != null) {
                sb.append(" lockMode=").append(lockMode);
            }
            LoggerUtils.logMsg
                (logger, dbImpl.getDbEnvironment(), level, sb.toString());
        }
    }

    private void traceCursorImpl(final StringBuffer sb) {
        sb.append(" locker=").append(cursorImpl.getLocker().getId());
        if (cursorImpl.getBIN() != null) {
            sb.append(" bin=").append(cursorImpl.getBIN().getNodeId());
        }
        sb.append(" idx=").append(cursorImpl.getIndex());

        if (cursorImpl.getDupBIN() != null) {
            sb.append(" Dbin=").append(cursorImpl.getDupBIN().getNodeId());
        }
        sb.append(" dupIdx=").append(cursorImpl.getDupIndex());
    }
}
