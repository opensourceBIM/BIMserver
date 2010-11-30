/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;

import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.dbi.PutMode;
import com.sleepycat.je.dbi.CursorImpl.SearchMode;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.LockerFactory;
import com.sleepycat.je.utilint.DatabaseUtil;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * A secondary database handle.
 *
 * <p>Secondary databases are opened with {@link
 * Environment#openSecondaryDatabase Environment.openSecondaryDatabase} and are
 * always associated with a single primary database.  The distinguishing
 * characteristics of a secondary database are:</p>
 *
 * <ul> <li>Records are automatically added to a secondary database when
 * records are added, modified and deleted in the primary database.  Direct
 * calls to <code>put()</code> methods on a secondary database are
 * prohibited.</li>
 * <li>The {@link #delete delete} method of a secondary database will delete
 * the primary record and as well as all its associated secondary records.</li>
 * <li>Calls to all <code>get()</code> methods will return the data from the
 * associated primary database.</li>
 * <li>Additional <code>get()</code> method signatures are provided to return
 * the primary key in an additional <code>pKey</code> parameter.</li>
 * <li>Calls to {@link #openCursor openCursor} will return a {@link
 * SecondaryCursor}, which itself has <code>get()</code> methods that return
 * the data of the primary database and additional <code>get()</code> method
 * signatures for returning the primary key.</li>
 * </ul>
 * <p>Before opening or creating a secondary database you must implement
 * the {@link SecondaryKeyCreator} or {@link SecondaryMultiKeyCreator}
 * interface.</p>
 *
 * <p>For example, to create a secondary database that supports duplicates:</p>
 *
 * <pre>
 *     Database primaryDb; // The primary database must already be open.
 *     SecondaryKeyCreator keyCreator; // Your key creator implementation.
 *     SecondaryConfig secConfig = new SecondaryConfig();
 *     secConfig.setAllowCreate(true);
 *     secConfig.setSortedDuplicates(true);
 *     secConfig.setKeyCreator(keyCreator);
 *     SecondaryDatabase newDb = env.openSecondaryDatabase(transaction,
 *                                                         "myDatabaseName",
 *                                                         primaryDb,
 *                                                         secConfig)
 * </pre>
 *
 * <p>If a primary database is to be associated with one or more secondary
 * databases, it may not be configured for duplicates.</p>
 *
 * <p><b>WARNING:</b> The associations between primary and secondary databases
 * are not stored persistently.  Whenever a primary database is opened for
 * write access by the application, the appropriate associated secondary
 * databases should also be opened by the application.  This is necessary to
 * ensure data integrity when changes are made to the primary database.  If the
 * secondary database is not opened, it will not be updated when the primary is
 * updated, and the references between the databases will become invalid.
 * (Note that this warning does not apply when using the {@link
 * com.sleepycat.persist DPL}, which does store secondary relationships
 * persistently.)</p>
 *
 * <h3><a name="transactions">Special considerations for using Secondary
 * Databases with and without Transactions</a></h3>
 *
 * <p>Normally, during a primary database write operation (insert, update or
 * delete), all associated secondary databases are also updated.  However, when
 * an exception occurs during the write operation, the updates may be
 * incomplete.  If the databases are transactional, this is handled by aborting
 * the transaction to undo the incomplete operation.  If an auto-commit
 * transaction is used (null is passed for the transaction), the transaction
 * will be aborted automatically.  If an explicit transaction is used, it
 * must be aborted by the application caller after the exception is caught.</p>
 *
 * <p>However, if the databases are non-transactional, integrity problems can
 * result when an exception occurs during the write operation.  Because the
 * write operation is not made atomic by a transaction, references between the
 * databases will become invalid if the operation is incomplete.  This results
 * in a {@link SecondaryIntegrityException} when attempting to access the
 * databases later.</p>
 *
 * <p>A secondary integrity problem is persistent; it cannot be resolved by
 * reopening the databases or the environment.  The only way to resolve the
 * problem is to restore the environment from a valid backup, or, if the
 * integrity of the primary database is assumed, to remove and recreate all
 * secondary databases.</p>
 *
 * <p>Therefore, secondary databases and indexes should always be used in
 * conjunction with transactional databases and stores. Without transactions,
 * it is the responsibility of the application to handle the results of the
 * incomplete write operation or to take steps to prevent this situation from
 * happening in the first place.</p>
 *
 * <p>The following exceptions may be thrown during a write operation, and may
 * cause an integrity problem in the absence of transactions.</p>
 * <ul>
 * <li>{@link SecondaryConstraintException}, see its subclasses for more
 * information.</li>
 * <li>{@link LockConflictException}, when more than one thread is accessing
 * the databases.</li>
 * <li>{@link EnvironmentFailureException}, if an unexpected or system failure
 * occurs.</li>
 * <li>There is always the possibility of an {@link Error} or an unintended
 * {@link RuntimeException}.</li>
 * </ul>
 */
public class SecondaryDatabase extends Database {

    /* For type-safe check against EMPTY_SET */
    private static final Set<DatabaseEntry> EMPTY_SET =
        Collections.emptySet();

    private Database primaryDb;
    private SecondaryConfig secondaryConfig;
    private SecondaryTrigger secondaryTrigger;
    private ForeignKeyTrigger foreignKeyTrigger;

    /**
     * Creates a secondary database but does not open or fully initialize it.
     *
     * @throws IllegalArgumentException via Environment.openSecondaryDatabase.
     */
    SecondaryDatabase(final Environment env,
                      final SecondaryConfig secConfig,
                      final Database primaryDatabase)
        throws DatabaseException {

        super(env);
        DatabaseUtil.checkForNullParam(primaryDatabase, "primaryDatabase");
        primaryDatabase.checkOpen("Can't use as primary:");
        if (primaryDatabase.configuration.getSortedDuplicates()) {
            throw new IllegalArgumentException
                ("Duplicates must not be allowed for a primary database: " +
                 primaryDatabase.getDebugName());
        }
        if (env.getEnvironmentImpl() !=
                primaryDatabase.getEnvironment().getEnvironmentImpl()) {
            throw new IllegalArgumentException
                ("Primary and secondary databases must be in the same" +
                 " environment");
        }
        if (secConfig.getKeyCreator() != null &&
            secConfig.getMultiKeyCreator() != null) {
            throw new IllegalArgumentException
                ("secConfig.getKeyCreator() and getMultiKeyCreator() may not" +
                 " both be non-null");
        }
        if (!primaryDatabase.configuration.getReadOnly() &&
            secConfig.getKeyCreator() == null &&
            secConfig.getMultiKeyCreator() == null) {
            throw new IllegalArgumentException
                ("secConfig and getKeyCreator()/getMultiKeyCreator()" +
                 " may be null only if the primary database is read-only");
        }
        if (secConfig.getForeignKeyNullifier() != null &&
            secConfig.getForeignMultiKeyNullifier() != null) {
            throw new IllegalArgumentException
                ("secConfig.getForeignKeyNullifier() and" +
                 " getForeignMultiKeyNullifier() may not both be non-null");
        }
        if (secConfig.getForeignKeyDeleteAction() ==
                         ForeignKeyDeleteAction.NULLIFY &&
            secConfig.getForeignKeyNullifier() == null &&
            secConfig.getForeignMultiKeyNullifier() == null) {
            throw new IllegalArgumentException
                ("ForeignKeyNullifier or ForeignMultiKeyNullifier must be" +
                 " non-null when ForeignKeyDeleteAction is NULLIFY");
        }
        if (secConfig.getForeignKeyNullifier() != null &&
            secConfig.getMultiKeyCreator() != null) {
            throw new IllegalArgumentException
                ("ForeignKeyNullifier may not be used with" +
                 " SecondaryMultiKeyCreator -- use" +
                 " ForeignMultiKeyNullifier instead");
        }
        if (secConfig.getForeignKeyDatabase() != null) {
            Database foreignDb = secConfig.getForeignKeyDatabase();
            if (foreignDb.getDatabaseImpl().getSortedDuplicates()) {
                throw new IllegalArgumentException
                    ("Duplicates must not be allowed for a foreign key " +
                     " database: " + foreignDb.getDebugName());
            }
        }
        primaryDb = primaryDatabase;
        secondaryTrigger = new SecondaryTrigger(this);
        if (secConfig.getForeignKeyDatabase() != null) {
            foreignKeyTrigger = new ForeignKeyTrigger(this);
        }
    }

    /**
     * Create a database, called by Environment
     */
    @Override
    void initNew(final Environment env,
                 final Locker locker,
                 final String databaseName,
                 final DatabaseConfig dbConfig)
        throws DatabaseException {

        super.initNew(env, locker, databaseName, dbConfig);
        init(locker);
    }

    /**
     * Open a database, called by Environment
     *
     * @throws IllegalArgumentException via Environment.openSecondaryDatabase.
     */
    @Override
    void initExisting(final Environment env,
                      final Locker locker,
                      final DatabaseImpl database,
                      final DatabaseConfig dbConfig)
        throws DatabaseException {

        /* Disallow one secondary associated with two different primaries. */
        Database otherPriDb = database.findPrimaryDatabase();
        if (otherPriDb != null &&
            otherPriDb.getDatabaseImpl() != primaryDb.getDatabaseImpl()) {
            throw new IllegalArgumentException
                ("Secondary is already associated with a different primary: " +
                 otherPriDb.getDebugName());
        }

        super.initExisting(env, locker, database, dbConfig);
        init(locker);
    }

    /**
     * Adds secondary to primary's list, and populates the secondary if needed.
     *
     * @param locker should be the locker used to open the database.  If a
     * transactional locker, the population operations will occur in the same
     * transaction; this may result in a large number of retained locks.  If a
     * non-transactional locker, the Cursor will create a ThreadLocker (even if
     * a BasicLocker used for handle locking is passed), and locks will not be
     * retained.
     */
    private void init(final Locker locker)
        throws DatabaseException {

        trace(Level.FINEST, "SecondaryDatabase open");

        secondaryConfig = (SecondaryConfig) configuration;

        /*
         * Insert foreign key triggers at the front of the list and append
         * secondary triggers at the end, so that ForeignKeyDeleteAction.ABORT
         * is applied before deleting the secondary keys.
         */
        primaryDb.addTrigger(secondaryTrigger, false);

        Database foreignDb = secondaryConfig.getForeignKeyDatabase();
        if (foreignDb != null) {
            foreignDb.addTrigger(foreignKeyTrigger, true);
        }

        /* Populate secondary if requested and secondary is empty. */
        if (secondaryConfig.getAllowPopulate()) {
            Cursor secCursor = null;
            Cursor priCursor = null;
            try {
                secCursor = new Cursor(this, locker, null);
                DatabaseEntry key = new DatabaseEntry();
                DatabaseEntry data = new DatabaseEntry();
                OperationStatus status = secCursor.position(key, data,
                                                            LockMode.DEFAULT,
                                                            true);
                if (status == OperationStatus.NOTFOUND) {
                    /* Is empty, so populate */
                    priCursor = new Cursor(primaryDb, locker, null);
                    status = priCursor.position(key, data, LockMode.DEFAULT,
                                                true);
                    while (status == OperationStatus.SUCCESS) {
                        updateSecondary(locker, secCursor, key, null, data);
                        status = priCursor.retrieveNext(key, data,
                                                        LockMode.DEFAULT,
                                                        GetMode.NEXT);
                    }
                }
            } finally {
                if (secCursor != null) {
                    secCursor.close();
                }
                if (priCursor != null) {
                    priCursor.close();
                }
            }
        }
    }

    /**
     * Closes a secondary database and dis-associates it from its primary
     * database. A secondary database should be closed before closing its
     * associated primary database.
     *
     * {@inheritDoc}
     *
     * <!-- inherit other javadoc from overridden method -->
     */
    @Override
    public synchronized void close()
        throws DatabaseException {

        if (primaryDb != null && secondaryTrigger != null) {
            primaryDb.removeTrigger(secondaryTrigger);
        }
        Database foreignDb = secondaryConfig.getForeignKeyDatabase();
        if (foreignDb != null && foreignKeyTrigger != null) {
            foreignDb.removeTrigger(foreignKeyTrigger);
        }
        super.close();
    }

    /**
     * Should be called by the secondaryTrigger while holding a write lock on
     * the trigger list.
     */
    void clearPrimary() {
        primaryDb = null;
        secondaryTrigger  = null;
    }

    /**
     * Should be called by the foreignKeyTrigger while holding a write lock on
     * the trigger list.
     */
    void clearForeignKeyTrigger() {
        foreignKeyTrigger = null;
    }

    /**
     * Returns the primary database associated with this secondary database.
     *
     * @return the primary database associated with this secondary database.
     */
    public Database getPrimaryDatabase() {
        return primaryDb;
    }

    /**
     * Returns a copy of the secondary configuration of this database.
     *
     * @return a copy of the secondary configuration of this database.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @deprecated As of JE 4.0.13, replaced by {@link
     * SecondaryDatabase#getConfig()}.</p>
     */
    public SecondaryConfig getSecondaryConfig()
        throws DatabaseException {

        return (SecondaryConfig) getConfig();
    }

    /**
     * Returns a copy of the secondary configuration of this database.
     *
     * @return a copy of the secondary configuration of this database.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public SecondaryConfig getConfig()
        throws DatabaseException {

        return (SecondaryConfig) super.getConfig();
    }

    /**
     * Returns the secondary config without cloning, for internal use.
     */
    public SecondaryConfig getPrivateSecondaryConfig() {
        return secondaryConfig;
    }

    /**
     * Obtain a cursor on a database, returning a
     * <code>SecondaryCursor</code>. Calling this method is the equivalent of
     * calling {@link #openCursor} and casting the result to {@link
     * SecondaryCursor}.
     *
     * @param txn the transaction used to protect all operations performed with
     * the cursor, or null if the operations should not be transaction
     * protected.  If the database is non-transactional, null must be
     * specified.  For a transactional database, the transaction is optional
     * for read-only access and required for read-write access.
     *
     * @param cursorConfig The cursor attributes.  If null, default attributes
     * are used.
     *
     * @return A secondary database cursor.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @deprecated As of JE 4.0.13, replaced by {@link
     * SecondaryDatabase#openCursor}.</p>
     */
    public SecondaryCursor openSecondaryCursor(final Transaction txn,
                                               final CursorConfig cursorConfig)
        throws DatabaseException {

        return (SecondaryCursor) openCursor(txn, cursorConfig);
    }

    /**
     * Obtain a cursor on a database, returning a <code>SecondaryCursor</code>.
     */
    @Override
    public SecondaryCursor openCursor(final Transaction txn,
                                      final CursorConfig cursorConfig)
        throws DatabaseException {

        return (SecondaryCursor) super.openCursor(txn, cursorConfig);
    }

    /**
     * Overrides Database method.
     */
    @Override
    Cursor newDbcInstance(final Transaction txn,
                          final CursorConfig cursorConfig)
        throws DatabaseException {

        return new SecondaryCursor(this, txn, cursorConfig);
    }

    /**
     * Deletes the primary key/data pair associated with the specified
     * secondary key.  In the presence of duplicate key values, all primary
     * records associated with the designated secondary key will be deleted.
     *
     * When the primary records are deleted, their associated secondary records
     * are deleted as if {@link Database#delete} were called.  This includes,
     * but is not limited to, the secondary record referenced by the given key.
     *
     * @param key the secondary key used as input.  It must be initialized with
     * a non-null byte array by the caller.
     *
     * <!-- inherit other javadoc from overridden method -->
     */
    @Override
    public OperationStatus delete(final Transaction txn,
                                  final DatabaseEntry key)
        throws DeleteConstraintException,
               LockConflictException,
               DatabaseException,
               UnsupportedOperationException,
               IllegalArgumentException {

        checkEnv();
        DatabaseUtil.checkForNullDbt(key, "key", true);
        checkOpen("Can't call SecondaryDatabase.delete:");
        trace(Level.FINEST, "SecondaryDatabase.delete", txn,
              key, null, null);

        Locker locker = null;
        Cursor cursor = null;

        OperationStatus commitStatus = OperationStatus.NOTFOUND;
        try {
            locker = LockerFactory.getWritableLocker
                (envHandle,
                 txn,
                 isTransactional(),
                 getDatabaseImpl().isReplicated()); // autoTxnIsReplicated

            /* Read the primary key (the data of a secondary). */
            cursor = new Cursor(this, locker, null);
            DatabaseEntry pKey = new DatabaseEntry();
            OperationStatus searchStatus =
                cursor.search(key, pKey, LockMode.RMW, SearchMode.SET);

            /*
             * For each duplicate secondary key, delete the primary record and
             * all its associated secondary records, including the one
             * referenced by this secondary cursor.
             */
            while (searchStatus == OperationStatus.SUCCESS) {
                commitStatus = primaryDb.deleteInternal(locker, pKey, null);
                if (commitStatus != OperationStatus.SUCCESS) {
                    throw secondaryRefersToMissingPrimaryKey
                        (locker, key, pKey);
                }
                searchStatus = cursor.retrieveNext
                    (key, pKey, LockMode.RMW, GetMode.NEXT_DUP);
            }
            return commitStatus;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (locker != null) {
                locker.operationEnd(commitStatus);
            }
        }
    }

    /**
     * @param key the secondary key used as input.  It must be initialized with
     * a non-null byte array by the caller.
     *
     * @param data the primary data returned as output.  Its byte array does
     * not need to be initialized by the caller.
     *
     * <!-- inherit other javadoc from overridden method -->
     */
    @Override
    public OperationStatus get(final Transaction txn,
                               final DatabaseEntry key,
                               final DatabaseEntry data,
                               final LockMode lockMode)
        throws DatabaseException {

        return get(txn, key, new DatabaseEntry(), data, lockMode);
    }

    /**
     * Retrieves the key/data pair with the given key.  If the matching key has
     * duplicate values, the first data item in the set of duplicates is
     * returned. Retrieval of duplicates requires the use of {@link Cursor}
     * operations.
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified to transaction-protect the operation, or null may be specified
     * to perform the operation without transaction protection.  For a
     * non-transactional database, null must be specified.
     *
     * @param key the secondary key used as input.  It must be initialized with
     * a non-null byte array by the caller.
     *
     * @param pKey the primary key returned as output.  Its byte array does not
     * need to be initialized by the caller.
     *
     * @param data the primary data returned as output.  Its byte array does
     * not need to be initialized by the caller.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used.
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
     * @throws IllegalStateException if the database has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus get(final Transaction txn,
                               final DatabaseEntry key,
                               final DatabaseEntry pKey,
                               final DatabaseEntry data,
                               LockMode lockMode)
        throws DatabaseException {

        checkEnv();
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(pKey, "pKey", false);
        DatabaseUtil.checkForNullDbt(data, "data", false);
        checkOpen("Can't call SecondaryDatabase.get:");
        trace(Level.FINEST, "SecondaryDatabase.get", txn, key, null, lockMode);

        CursorConfig cursorConfig = CursorConfig.DEFAULT;
        if (lockMode == LockMode.READ_COMMITTED) {
            cursorConfig = CursorConfig.READ_COMMITTED;
            lockMode = null;
        }
        checkLockModeWithoutTxn(txn, lockMode);

        Locker locker = null;
        SecondaryCursor cursor = null;
        OperationStatus commitStatus = null;
        try {
            locker = LockerFactory.getReadableLocker
                (envHandle, txn, isTransactional(),
                 false /*retainNonTxnLocks*/,
                 cursorConfig.getReadCommitted());
            cursor = new SecondaryCursor(this, locker, cursorConfig);
            commitStatus =
                cursor.search(key, pKey, data, lockMode, SearchMode.SET);
            return commitStatus;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            if (locker != null) {
                locker.operationEnd(commitStatus);
            }
        }
    }

    /**
     * This operation is not allowed with this method signature. {@link
     * UnsupportedOperationException} will always be thrown by this method.
     * The corresponding method with the <code>pKey</code> parameter should be
     * used instead.
     */
    @Override
    public OperationStatus getSearchBoth(final Transaction txn,
                                         final DatabaseEntry key,
                                         final DatabaseEntry data,
                                         final LockMode lockMode)
        throws UnsupportedOperationException {

        throw notAllowedException();
    }

    /**
     * Retrieves the key/data pair with the specified secondary and primary
     * key, that is, both the primary and secondary key items must match.
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified to transaction-protect the operation, or null may be specified
     * to perform the operation without transaction protection.  For a
     * non-transactional database, null must be specified.
     *
     * @param key the secondary key used as input.  It must be initialized with
     * a non-null byte array by the caller.
     *
     * @param pKey the primary key used as input.  It must be initialized with a
     * non-null byte array by the caller.
     *
     * @param data the primary data returned as output.  Its byte array does not
     * need to be initialized by the caller.
     *
     * @param lockMode the locking attributes; if null, default attributes are
     * used.
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
     * @throws IllegalStateException if the database has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus getSearchBoth(final Transaction txn,
                                         final DatabaseEntry key,
                                         final DatabaseEntry pKey,
                                         final DatabaseEntry data,
                                         LockMode lockMode)
        throws DatabaseException {

        checkEnv();
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(pKey, "pKey", true);
        DatabaseUtil.checkForNullDbt(data, "data", false);
        checkOpen("Can't call SecondaryDatabase.getSearchBoth:");
        trace(Level.FINEST, "SecondaryDatabase.getSearchBoth", txn, key, data,
              lockMode);

        CursorConfig cursorConfig = CursorConfig.DEFAULT;
        if (lockMode == LockMode.READ_COMMITTED) {
            cursorConfig = CursorConfig.READ_COMMITTED;
            lockMode = null;
        }
        checkLockModeWithoutTxn(txn, lockMode);

        Locker locker = null;
        SecondaryCursor cursor = null;
        OperationStatus commitStatus = null;
        try {
            locker = LockerFactory.getReadableLocker
                (envHandle, txn, isTransactional(),
                 false /*retainNonTxnLocks*/,
                 cursorConfig.getReadCommitted());
            cursor = new SecondaryCursor(this, locker, cursorConfig);
            commitStatus =
                cursor.search(key, pKey, data, lockMode, SearchMode.BOTH);
            return commitStatus;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            if (locker != null) {
                locker.operationEnd(commitStatus);
            }
        }
    }

    /**
     * This operation is not allowed on a secondary database. {@link
     * UnsupportedOperationException} will always be thrown by this method.
     * The corresponding method on the primary database should be used instead.
     */
    @Override
    public OperationStatus put(final Transaction txn,
                               final DatabaseEntry key,
                               final DatabaseEntry data)
        throws UnsupportedOperationException {

        throw notAllowedException();
    }

    /**
     * This operation is not allowed on a secondary database. {@link
     * UnsupportedOperationException} will always be thrown by this method.
     * The corresponding method on the primary database should be used instead.
     */
    @Override
    public OperationStatus putNoOverwrite(final Transaction txn,
                                          final DatabaseEntry key,
                                          final DatabaseEntry data)
        throws UnsupportedOperationException {

        throw notAllowedException();
    }

    /**
     * This operation is not allowed on a secondary database. {@link
     * UnsupportedOperationException} will always be thrown by this method.
     * The corresponding method on the primary database should be used instead.
     */
    @Override
    public OperationStatus putNoDupData(final Transaction txn,
                                        final DatabaseEntry key,
                                        final DatabaseEntry data)
        throws UnsupportedOperationException {

        throw notAllowedException();
    }

    /**
     * This operation is not allowed on a secondary database. {@link
     * UnsupportedOperationException} will always be thrown by this method.
     * The corresponding method on the primary database should be used instead.
     */
    @Override
    public JoinCursor join(final Cursor[] cursors, final JoinConfig config)
        throws UnsupportedOperationException {

        throw notAllowedException();
    }

    /**
     * Updates a single secondary when a put() or delete() is performed on the
     * primary.
     *
     * @param locker the internal locker.
     *
     * @param cursor secondary cursor to use, or null if this method should
     * open and close a cursor if one is needed.
     *
     * @param priKey the primary key.
     *
     * @param oldData the primary data before the change, or null if the record
     * did not previously exist.
     *
     * @param newData the primary data after the change, or null if the record
     * has been deleted.
     */
    void updateSecondary(final Locker locker,
                         Cursor cursor,
                         final DatabaseEntry priKey,
                         final DatabaseEntry oldData,
                         final DatabaseEntry newData)
        throws DatabaseException {

        /*
         * If we're updating the primary and the secondary key cannot be
         * changed, optimize for that case by doing nothing.
         */
        if (secondaryConfig.getImmutableSecondaryKey() &&
            oldData != null && newData != null) {
            return;
        }

        SecondaryKeyCreator keyCreator = secondaryConfig.getKeyCreator();
        if (keyCreator != null) {
            /* Each primary record may have a single secondary key. */
            assert secondaryConfig.getMultiKeyCreator() == null;

            /* Get old and new secondary keys. */
            DatabaseEntry oldSecKey = null;
            if (oldData != null) {
                oldSecKey = new DatabaseEntry();
                if (!keyCreator.createSecondaryKey(this, priKey, oldData,
                                                   oldSecKey)) {
                    oldSecKey = null;
                }
            }
            DatabaseEntry newSecKey = null;
            if (newData != null) {
                newSecKey = new DatabaseEntry();
                if (!keyCreator.createSecondaryKey(this, priKey, newData,
                                                   newSecKey)) {
                    newSecKey = null;
                }
            }

            /* Update secondary if old and new keys are unequal. */
            if ((oldSecKey != null && !oldSecKey.equals(newSecKey)) ||
                (newSecKey != null && !newSecKey.equals(oldSecKey))) {

                boolean localCursor = (cursor == null);
                if (localCursor) {
                    cursor = new Cursor(this, locker, null);
                }
                try {
                    /* Delete the old key. */
                    if (oldSecKey != null) {
                        deleteKey(cursor, priKey, oldSecKey);
                    }
                    /* Insert the new key. */
                    if (newSecKey != null) {
                        insertKey(locker, cursor, priKey, newSecKey);
                    }
                } finally {
                    if (localCursor && cursor != null) {
                        cursor.close();
                    }
                }
            }
        } else {
            /* Each primary record may have multiple secondary keys. */
            SecondaryMultiKeyCreator multiKeyCreator =
                secondaryConfig.getMultiKeyCreator();
            assert multiKeyCreator != null;

            /* Get old and new secondary keys. */
            Set<DatabaseEntry> oldKeys = EMPTY_SET;
            Set<DatabaseEntry> newKeys = EMPTY_SET;
            if (oldData != null) {
                oldKeys = new HashSet<DatabaseEntry>();
                multiKeyCreator.createSecondaryKeys(this, priKey,
                                                    oldData, oldKeys);
            }
            if (newData != null) {
                newKeys = new HashSet<DatabaseEntry>();
                multiKeyCreator.createSecondaryKeys(this, priKey,
                                                    newData, newKeys);
            }

            /* Update the secondary if there is a difference. */
            if (!oldKeys.equals(newKeys)) {

                boolean localCursor = (cursor == null);
                if (localCursor) {
                    cursor = new Cursor(this, locker, null);
                }
                try {
                    /* Delete old keys that are no longer present. */
                    Set<DatabaseEntry> oldKeysCopy = oldKeys;
                    if (oldKeys != EMPTY_SET) {
                        oldKeysCopy = new HashSet<DatabaseEntry>(oldKeys);
                        oldKeys.removeAll(newKeys);
                        for (Iterator<DatabaseEntry> i = oldKeys.iterator();
                             i.hasNext();) {
                            DatabaseEntry oldKey = i.next();
                            deleteKey(cursor, priKey, oldKey);
                        }
                    }

                    /* Insert new keys that were not present before. */
                    if (newKeys != EMPTY_SET) {
                        newKeys.removeAll(oldKeysCopy);
                        for (Iterator<DatabaseEntry> i = newKeys.iterator();
                             i.hasNext();) {
                            DatabaseEntry newKey = i.next();
                            insertKey(locker, cursor, priKey, newKey);
                        }
                    }
                } finally {
                    if (localCursor && cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
    }

    /**
     * Deletes an old secondary key.
     */
    private void deleteKey(final Cursor cursor,
                           final DatabaseEntry priKey,
                           final DatabaseEntry oldSecKey)
        throws DatabaseException {

        OperationStatus status =
            cursor.search(oldSecKey, priKey,
                          LockMode.RMW,
                          SearchMode.BOTH);
        if (status == OperationStatus.SUCCESS) {
            cursor.deleteInternal(getDatabaseImpl().getRepContext());
        } else {
            throw new SecondaryIntegrityException
                (cursor.getCursorImpl().getLocker(),
                 "Secondary is corrupt: the primary record contains a key " +
                 "that is not present in the secondary",
                getDebugName(), oldSecKey, priKey);
        }
    }

    /**
     * Inserts a new secondary key.
     */
    private void insertKey(final Locker locker,
                           final Cursor cursor,
                           final DatabaseEntry priKey,
                           final DatabaseEntry newSecKey)
        throws DatabaseException {

        /* Check for the existence of a foreign key. */
        Database foreignDb =
            secondaryConfig.getForeignKeyDatabase();
        if (foreignDb != null) {
            Cursor foreignCursor = null;
            try {
                foreignCursor = new Cursor(foreignDb, locker,
                                           null);
                DatabaseEntry tmpData = new DatabaseEntry();
                OperationStatus status =
                    foreignCursor.search(newSecKey, tmpData,
                                         LockMode.DEFAULT,
                                         SearchMode.SET);
                if (status != OperationStatus.SUCCESS) {
                    throw new ForeignConstraintException
                        (locker,
                         "Secondary " + getDebugName() +
                         " foreign key not allowed: it is not" +
                         " present in the foreign database " +
                         foreignDb.getDebugName(), getDebugName(),
                         newSecKey, priKey);
                }
            } finally {
                if (foreignCursor != null) {
                    foreignCursor.close();
                }
            }
        }

        /* Insert the new key. */
        if (configuration.getSortedDuplicates()) {
            OperationStatus status = cursor.putInternal(newSecKey, priKey,
                                                        PutMode.NO_DUP_DATA);
            if (status != OperationStatus.SUCCESS) {
                throw new SecondaryIntegrityException
                    (locker, "Secondary/primary record already present",
                     getDebugName(), newSecKey, priKey);
            }
        } else {
            OperationStatus status = cursor.putInternal(newSecKey, priKey,
                                                        PutMode.NO_OVERWRITE);
            if (status != OperationStatus.SUCCESS) {
                throw new UniqueConstraintException
                    (locker, "Unique secondary key is already present",
                     getDebugName(), newSecKey, priKey);
            }
        }
    }

    /**
     * Called by the ForeignKeyTrigger when a record in the foreign database is
     * deleted.
     *
     * @param secKey is the primary key of the foreign database, which is the
     * secondary key (ordinary key) of this secondary database.
     */
    void onForeignKeyDelete(final Locker locker, final DatabaseEntry secKey)
        throws DatabaseException {

        ForeignKeyDeleteAction deleteAction =
            secondaryConfig.getForeignKeyDeleteAction();

        /* Use RMW if we're going to be deleting the secondary records. */
        LockMode lockMode = (deleteAction == ForeignKeyDeleteAction.ABORT) ?
            LockMode.DEFAULT :
            LockMode.RMW;

        /*
         * Use the deleted foreign primary key to read the data of this
         * database, which is the associated primary's key.
         */
        DatabaseEntry priKey = new DatabaseEntry();
        Cursor cursor = null;
        OperationStatus status;
        try {
            cursor = new Cursor(this, locker, null);
            status = cursor.search(secKey, priKey, lockMode,
                                   SearchMode.SET);
            while (status == OperationStatus.SUCCESS) {

                if (deleteAction == ForeignKeyDeleteAction.ABORT) {

                    /*
                     * ABORT - throw an exception to cause the user to abort
                     * the transaction.
                     */
                    throw new DeleteConstraintException
                        (locker, "Secondary refers to a deleted foreign key",
                         getDebugName(), secKey, priKey);

                } else if (deleteAction == ForeignKeyDeleteAction.CASCADE) {

                    /*
                     * CASCADE - delete the associated primary record.
                     */
                    Cursor priCursor = null;
                    try {
                        DatabaseEntry data = new DatabaseEntry();
                        priCursor = new Cursor(primaryDb, locker, null);
                        status = priCursor.search(priKey, data, LockMode.RMW,
                                                  SearchMode.SET);
                        if (status == OperationStatus.SUCCESS) {
                            priCursor.delete();
                        } else {
                            throw secondaryRefersToMissingPrimaryKey
                                (locker, secKey, priKey);
                        }
                    } finally {
                        if (priCursor != null) {
                            priCursor.close();
                        }
                    }

                } else if (deleteAction == ForeignKeyDeleteAction.NULLIFY) {

                    /*
                     * NULLIFY - set the secondary key to null in the
                     * associated primary record.
                     */
                    Cursor priCursor = null;
                    try {
                        DatabaseEntry data = new DatabaseEntry();
                        priCursor = new Cursor(primaryDb, locker, null);
                        status = priCursor.search(priKey, data, LockMode.RMW,
                                                  SearchMode.SET);
                        if (status == OperationStatus.SUCCESS) {
                            ForeignMultiKeyNullifier multiNullifier =
                                secondaryConfig.getForeignMultiKeyNullifier();
                            if (multiNullifier != null) {
                                if (multiNullifier.nullifyForeignKey
                                        (this, priKey, data, secKey)) {
                                    priCursor.putCurrent(data);
                                }
                            } else {
                                ForeignKeyNullifier nullifier =
                                    secondaryConfig.getForeignKeyNullifier();
                                if (nullifier.nullifyForeignKey
                                        (this, data)) {
                                    priCursor.putCurrent(data);
                                }
                            }
                        } else {
                            throw secondaryRefersToMissingPrimaryKey
                                (locker, secKey, priKey);
                        }
                    } finally {
                        if (priCursor != null) {
                            priCursor.close();
                        }
                    }
                } else {
                    /* Should never occur. */
                    throw EnvironmentFailureException.unexpectedState();
                }

                status = cursor.retrieveNext(secKey, priKey, LockMode.DEFAULT,
                                             GetMode.NEXT_DUP);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    SecondaryIntegrityException
        secondaryRefersToMissingPrimaryKey(final Locker locker,
                                           final DatabaseEntry secKey,
                                           final DatabaseEntry priKey)
        throws DatabaseException {

        return new SecondaryIntegrityException
            (locker,
             "Secondary refers to a missing key in the primary database",
             getDebugName(), secKey, priKey);
    }

    static UnsupportedOperationException notAllowedException() {

        return new UnsupportedOperationException
            ("Operation not allowed on a secondary");
    }

    /**
     * Send trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    void trace(final Level level, final String methodName) {
        if (logger.isLoggable(level)) {
            StringBuffer sb = new StringBuffer();
            sb.append(methodName);
            sb.append(" name=").append(getDebugName());
            sb.append(" primary=").append(primaryDb.getDebugName());

            LoggerUtils.logMsg
                (logger, envHandle.getEnvironmentImpl(), level, sb.toString());
        }
    }
}
