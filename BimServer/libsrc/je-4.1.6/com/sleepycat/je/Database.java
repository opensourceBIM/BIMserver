/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.dbi.PutMode;
import com.sleepycat.je.dbi.CursorImpl.SearchMode;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.LockerFactory;
import com.sleepycat.je.utilint.DatabaseUtil;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * A database handle.
 *
 * <p>Database attributes are specified in the {@link
 * com.sleepycat.je.DatabaseConfig DatabaseConfig} class. Database handles are
 * free-threaded and may be used concurrently by multiple threads.</p>
 *
 * <p>To open an existing database with default attributes:</p>
 *
 * <blockquote><pre>
 *     Environment env = new Environment(home, null);
 *     Database myDatabase = env.openDatabase(null, "mydatabase", null);
 * </pre></blockquote>
 *
 * <p>To create a transactional database that supports duplicates:</p>
 *
 * <blockquote><pre>
 *     DatabaseConfig dbConfig = new DatabaseConfig();
 *     dbConfig.setTransactional(true);
 *     dbConfig.setAllowCreate(true);
 *     dbConfig.setSortedDuplicates(true);
 *     Database db = env.openDatabase(txn, "mydatabase", dbConfig);
 * </pre></blockquote>
 */
public class Database {

    /*
     * DbState embodies the Database handle state.
     */
    enum DbState {
        OPEN, CLOSED, INVALID, PREEMPTED
    }

    /* The current state of the handle. */
    private volatile DbState state;
    /* The DatabasePreemptedException cause when state == PREEMPTED. */
    private OperationFailureException preemptedCause;

    /* Handles onto the owning environment and the databaseImpl object. */
    Environment envHandle;            // used by subclasses
    private DatabaseImpl databaseImpl;

    DatabaseConfig configuration;     // properties used at execution

    /* True if this handle permits write operations; */
    private boolean isWritable;

    /* Record how many open cursors on this database. */
    private AtomicInteger openCursors = new AtomicInteger();

    /* Transaction that owns the db lock held while the Database is open. */
    Locker handleLocker;

    /*
     * DatabaseTrigger list.  The list is null if empty, and is checked for
     * null to avoiding read locking overhead when no triggers are present.
     * Access to this list is protected by the shared trigger latch in
     * EnvironmentImpl.
     */
    private List<DatabaseTrigger> triggerList;

    protected final Logger logger;

    /**
     * Creates a database but does not open or fully initialize it.  Is
     * protected for use in compat package.
     * @param env
     */
    protected Database(final Environment env) {
        this.envHandle = env;
        handleLocker = null;
        logger = envHandle.getEnvironmentImpl().getLogger();
    }

    /**
     * Creates a database, called by Environment.
     */
    void initNew(final Environment env,
                 final Locker locker,
                 final String databaseName,
                 final DatabaseConfig dbConfig)
        throws DatabaseException {

        dbConfig.validateForNewDb();

        init(env, dbConfig);

        /* Make the databaseImpl. */
        EnvironmentImpl environmentImpl =
            DbInternal.getEnvironmentImpl(envHandle);
        databaseImpl = environmentImpl.getDbTree().createDb
            (locker, databaseName, dbConfig, this);
        databaseImpl.addReferringHandle(this);

        /*
         * Copy the replicated setting into the cloned handle configuration.
         */
        configuration.setReplicated(databaseImpl.isReplicated());
    }

    /**
     * Opens a database, called by Environment.
     */
    void initExisting(final Environment env,
                      final Locker locker,
                      final DatabaseImpl dbImpl,
                      final DatabaseConfig dbConfig)
        throws DatabaseException {

        /*
         * Make sure the configuration used for the open is compatible with the
         * existing databaseImpl.
         */
        validateConfigAgainstExistingDb(dbConfig, dbImpl);

        init(env, dbConfig);
        this.databaseImpl = dbImpl;
        dbImpl.addReferringHandle(this);

        /*
         * Copy the duplicates, transactional and replicated properties of the
         * underlying database, in case the useExistingConfig property is set.
         */
        configuration.setSortedDuplicates(dbImpl.getSortedDuplicates());
        configuration.setTransactional(dbImpl.isTransactional());
        configuration.setReplicated(dbImpl.isReplicated());
    }

    private void init(final Environment env, final DatabaseConfig config) {
        handleLocker = null;
        envHandle = env;
        configuration = config.cloneConfig();
        isWritable = !configuration.getReadOnly();
        state = DbState.OPEN;
    }

    /**
     * Sees if this new handle's configuration is compatible with the
     * pre-existing database.
     */
    private void validateConfigAgainstExistingDb(final DatabaseConfig config,
                                                 final DatabaseImpl dbImpl)
        throws DatabaseException {

        /*
         * The sortedDuplicates, temporary, and replicated properties are
         * persistent and immutable.  But they do not need to be specified if
         * the useExistingConfig property is set.
         */
        if (!config.getUseExistingConfig()) {
            validatePropertyMatches
                ("sortedDuplicates", dbImpl.getSortedDuplicates(),
                 config.getSortedDuplicates());
            validatePropertyMatches
                ("temporary", dbImpl.isTemporary(),
                 config.getTemporary());
            /* Only check replicated if the environment is replicated. */
            if (envHandle.getEnvironmentImpl().isReplicated()) {
                if (dbImpl.unknownReplicated()) {
                    throw new UnsupportedOperationException
                        ("Conversion of standalone environments to " +
                          "replicated environments isn't supported yet");
                }
                validatePropertyMatches
                    ("replicated", dbImpl.isReplicated(),
                     DbInternal.getReplicated(config));
            }
        }

        /*
         * The transactional and deferredWrite properties are kept constant
         * while any handles are open, and set when the first handle is opened.
         * But if an existing handle is open and the useExistingConfig property
         * is set, then they do not need to be specified.
         */
        if (dbImpl.hasOpenHandles()) {
            if (!config.getUseExistingConfig()) {
                validatePropertyMatches
                    ("transactional", dbImpl.isTransactional(),
                     config.getTransactional());
                validatePropertyMatches
                    ("deferredWrite", dbImpl.isDurableDeferredWrite(),
                     config.getDeferredWrite());
            }
        } else {
            dbImpl.setTransactional(config.getTransactional());
            dbImpl.setDeferredWrite(config.getDeferredWrite());
        }

        /*
         * Only re-set the comparators if the override is allowed.
         */
        boolean dbImplModified = false;
        if (config.getOverrideBtreeComparator()) {
            dbImplModified |= dbImpl.setBtreeComparator
                (config.getBtreeComparator(),
                 config.getBtreeComparatorByClassName());
        }

        if (config.getOverrideDuplicateComparator()) {
            dbImplModified |= dbImpl.setDuplicateComparator
                (config.getDuplicateComparator(),
                 config.getDuplicateComparatorByClassName());
        }

        boolean newKeyPrefixing = config.getKeyPrefixing();
        if (newKeyPrefixing != dbImpl.getKeyPrefixing()) {
            dbImplModified = true;
            if (newKeyPrefixing) {
                dbImpl.setKeyPrefixing();
            } else {
                dbImpl.clearKeyPrefixing();
            }
        }

        /* [#15743] */
        if (dbImplModified) {
            EnvironmentImpl envImpl = envHandle.getEnvironmentImpl();

            /* Dirty the root. */
            envImpl.getDbTree().modifyDbRoot(dbImpl);
        }

        /*
         * CacheMode and Strategy are changed for all handles, but are not
         * persistent.
         */
        dbImpl.setCacheMode(config.getCacheMode());
        dbImpl.setCacheModeStrategy(config.getCacheModeStrategy());
    }

    /**
     * @throws IllegalArgumentException via Environment.openDatabase and
     * openSecondaryDatabase.
     */
    private void validatePropertyMatches(final String propName,
                                         final boolean existingValue,
                                         final boolean newValue)
        throws IllegalArgumentException {

        if (newValue != existingValue) {
            throw new IllegalArgumentException
                ("You can't open a Database with a " + propName +
                 " configuration of " + newValue +
                 " if the underlying database was created with a " +
                 propName + " setting of " + existingValue + '.');
        }
    }

    /**
     * Discards the database handle.
     * <p>
     * When closing the last open handle for a deferred-write database, any
     * cached database information is flushed to disk as if {@link #sync} were
     * called.
     * <p>
     * The database handle should not be closed while any other handle that
     * refers to it is not yet closed; for example, database handles should not
     * be closed while cursor handles into the database remain open, or
     * transactions that include operations on the database have not yet been
     * committed or aborted.  Specifically, this includes {@link
     * com.sleepycat.je.Cursor Cursor} and {@link com.sleepycat.je.Transaction
     * Transaction} handles.
     * <p>
     * When multiple threads are using the {@link com.sleepycat.je.Database
     * Database} handle concurrently, only a single thread may call this
     * method.
     * <p>
     * The database handle may not be accessed again after this method is
     * called, regardless of the method's success or failure.
     * <p>
     * When called on a database that is the primary database for a secondary
     * index, the primary database should be closed only after all secondary
     * indices which reference it have been closed.
     *
     * @see DatabaseConfig#setDeferredWrite DatabaseConfig.setDeferredWrite
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if cursors associated with this database
     * are still open.
     */
    public void close()
        throws DatabaseException {

        try {
            closeInternal(true /*doSyncDw*/, true /*deleteTempDb*/,
                          DbState.CLOSED, null /*preemptedException*/);
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /*
     * This method is private for now because it is incomplete.  To fully
     * implement it we must clear all dirty nodes for the database that is
     * closed, since otherwise they will be flushed during the next checkpoint.
     */
    @SuppressWarnings("unused")
    private void closeNoSync()
        throws DatabaseException {

        try {
            closeInternal(false /*doSyncDw*/, true /*deleteTempDb*/,
                          DbState.CLOSED, null /*preemptedException*/);
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Marks the handle as preempted when the handle lock is stolen by the HA
     * replayer, during replay of a naming operation (remove, truncate or
     * rename).  This causes DatabasePreemtpedException to be thrown on all
     * subsequent use of the handle or cursors opened on this handle.  [#17015]
     */
    synchronized void setPreempted(final String dbName, final String msg) {
        OperationFailureException preemptedException =
            databaseImpl.getDbEnvironment().createDatabasePreemptedException
                (msg, dbName, this);
        closeInternal(false /*doSyncDw*/, false /*deleteTempDb*/,
                      DbState.PREEMPTED, preemptedException);
    }

    /**
     * Invalidates the handle when the transaction used to open the database
     * is aborted.
     *
     * Note that this method (unlike close) does not perform sync and removal
     * of DW DBs.  A DW DB cannot be transactional.
     */
    synchronized void invalidate() {
        closeInternal(false /*doSyncDw*/, false /*deleteTempDb*/,
                      DbState.INVALID, null /*preemptedException*/);
    }

    private void
        closeInternal(final boolean doSyncDw,
                      final boolean deleteTempDb,
                      final DbState newState,
                      final OperationFailureException preemptedException)
        throws DatabaseException {

        StringBuffer errors = null;
        DatabaseImpl dbClosed = null;

        synchronized (this) {
            checkEnv();

            /* Do nothing if handle was previously closed. */
            if (state != DbState.OPEN) {
                return;
            }

            /*
             * The state should be changed ASAP during close, so that
             * addCursor and removeCursor will see the updated state ASAP.
             */
            state = newState;
            preemptedCause = preemptedException;

            /*
             * Throw a DatabaseException if there are open cursors while
             * closing a Database.
             */
            if (newState == DbState.CLOSED &&
                openCursors.get() != 0) {
                errors = new StringBuffer();
                errors.append("Database still has " + openCursors.get() +
                              " open cursors while trying to close.");
            }

            trace(Level.FINEST, "Database.close: ", null, null);

            /* Disassociate triggers before closing. */
            removeAllTriggers();

            envHandle.removeReferringHandle(this);

            if (databaseImpl != null) {
                dbClosed = databaseImpl;
                databaseImpl.removeReferringHandle(this);
                envHandle.getEnvironmentImpl().
                    getDbTree().releaseDb(databaseImpl);

                /*
                 * Database.close may be called after an abort.  By setting the
                 * databaseImpl field to null we ensure that close won't call
                 * releaseDb or endOperation. [#13415]
                 */
                databaseImpl = null;

                if (handleLocker != null) {

                    /*
                     * If the handle was preempted, we mark the locker as
                     * only-abortable with the DatabasePreemptedException.  If
                     * the handle locker is a user txn, this causes the
                     * DatabasePreemptedException to be thrown if the user
                     * attempts to commit, or continue to use, the txn, rather
                     * than throwing a LockConflictException.  [#17015]
                     */
                    if (newState == DbState.PREEMPTED) {
                        handleLocker.setOnlyAbortable(preemptedException);
                    }

                    /*
                     * Tell our protecting txn that we're closing. If this type
                     * of transaction doesn't live beyond the life of the
                     * handle, it will release the db handle lock.
                     */
                    if (newState == DbState.CLOSED) {
                        handleLocker.setHandleLockOwner(true, this, true);
                        handleLocker.operationEnd(true);
                    } else {
                        handleLocker.operationEnd(false);
                    }
                }
            }
        }

        /*
         * Notify the database when a handle is closed.  This should not be
         * done while synchronized since it may perform database removal or
         * sync.  Statements above are synchronized but this section must not
         * be.
         */
        if (dbClosed != null) {
            dbClosed.handleClosed(doSyncDw, deleteTempDb);
        }

        if (errors != null) {
            throw new IllegalStateException(errors.toString());
        }
    }

    /**
     * Flushes any cached information for this database to disk; only
     * applicable for deferred-write databases.
     * <p> Note that deferred-write databases are automatically flushed to disk
     * when the {@link #close} method is called.
     *
     * @see DatabaseConfig#setDeferredWrite DatabaseConfig.setDeferredWrite
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
     * @throws UnsupportedOperationException if this is not a deferred-write
     * database, or this database is read-only.
     *
     * @throws IllegalStateException if the database has been closed.
     */
    public void sync()
        throws DatabaseException, UnsupportedOperationException {

        checkEnv();
        checkOpen("Can't call Database.sync:");
        checkWritable("sync");
        trace(Level.FINEST, "Database.sync", null, null, null, null);

        databaseImpl.sync(true);
    }

    /**
     * Opens a sequence in the database.
     *
     * @param txn For a transactional database, an explicit transaction may
     * be specified, or null may be specified to use auto-commit.  For a
     * non-transactional database, null must be specified.
     *
     * @param key The key {@link DatabaseEntry} of the sequence.
     *
     * @param config The sequence attributes.  If null, default attributes are
     * used.
     *
     * @return a new Sequence handle.
     *
     * @throws SequenceExistsException if the sequence record already exists
     * and the {@code SequenceConfig ExclusiveCreate} parameter is true.
     *
     * @throws SequenceNotFoundException if the sequence record does not exist
     * and the {@code SequenceConfig AllowCreate} parameter is false.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs. If the sequence does not exist and the {@link
     * SequenceConfig#setAllowCreate AllowCreate} parameter is true, then one
     * of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> may also occur.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this database is read-only, or
     * this database is configured for duplicates.
     *
     * @throws IllegalStateException if the Sequence record is deleted by
     * another thread during this method invocation, or the database has been
     * closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, an invalid {@code SequenceConfig} parameter.
     */
    public Sequence openSequence(final Transaction txn,
                                 final DatabaseEntry key,
                                 final SequenceConfig config)
        throws SequenceNotFoundException, SequenceExistsException {

        try {
            checkEnv();
            DatabaseUtil.checkForNullDbt(key, "key", true);
            checkOpen("Can't call Database.openSequence:");
            checkWritable("openSequence");
            trace(Level.FINEST, "Database.openSequence", txn, key, null, null);

            return new Sequence(this, txn, key, config);
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Removes the sequence from the database.  This method should not be
     * called if there are open handles on this sequence.
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified, or null may be specified to use auto-commit.  For a
     * non-transactional database, null must be specified.
     *
     * @param key The key {@link com.sleepycat.je.DatabaseEntry
     * DatabaseEntry} of the sequence.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this database is read-only.
     */
    public void removeSequence(final Transaction txn, final DatabaseEntry key)
        throws DatabaseException {

        try {
            delete(txn, key);
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Returns a cursor into the database.
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
     * @return A database cursor.
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
     * @throws IllegalStateException if the database has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, an invalid {@code CursorConfig} parameter.
     */
    public Cursor openCursor(final Transaction txn,
                             final CursorConfig cursorConfig)
        throws DatabaseException, IllegalArgumentException {

        try {
            checkEnv();
            checkOpen("Can't open a cursor");
            CursorConfig useConfig =
                (cursorConfig == null) ? CursorConfig.DEFAULT : cursorConfig;

            if (useConfig.getReadUncommitted() &&
                useConfig.getReadCommitted()) {
                throw new IllegalArgumentException
                    ("Only one may be specified: " +
                     "ReadCommitted or ReadUncommitted");
            }

            trace(Level.FINEST, "Database.openCursor", txn, cursorConfig);
            Cursor ret = newDbcInstance(txn, useConfig);

            return ret;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Is overridden by SecondaryDatabase.
     */
    Cursor newDbcInstance(final Transaction txn,
                          final CursorConfig cursorConfig)
        throws DatabaseException {

        return new Cursor(this, txn, cursorConfig);
    }

    /**
     * Removes key/data pairs from the database.
     *
     * <p>The key/data pair associated with the specified key is discarded
     * from the database.  In the presence of duplicate key values, all
     * records associated with the designated key will be discarded.</p>
     *
     * <p>The key/data pair is also deleted from any associated secondary
     * databases.</p>
     *
     * @param txn For a transactional database, an explicit transaction may
     * be specified, or null may be specified to use auto-commit.  For a
     * non-transactional database, null must be specified.
     *
     * @param key the key {@link com.sleepycat.je.DatabaseEntry DatabaseEntry}
     * operated on.
     *
     * @return The method will return {@link
     * com.sleepycat.je.OperationStatus#NOTFOUND OperationStatus.NOTFOUND} if
     * the specified key is not found in the database; otherwise the method
     * will return {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this database is read-only.
     *
     * @throws IllegalStateException if the database has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public OperationStatus delete(final Transaction txn,
                                  final DatabaseEntry key)
        throws DeleteConstraintException,
               LockConflictException,
               DatabaseException,
               UnsupportedOperationException,
               IllegalArgumentException {

        try {
            checkEnv();
            DatabaseUtil.checkForNullDbt(key, "key", true);
            checkOpen("Can't call Database.delete:");
            checkWritable("delete");
            trace(Level.FINEST, "Database.delete", txn, key, null, null);

            OperationStatus commitStatus = OperationStatus.NOTFOUND;
            Locker locker = null;
            try {
                locker = LockerFactory.getWritableLocker
                    (envHandle, txn, isTransactional(),
                     databaseImpl.isReplicated()); // autoTxnIsReplicated
                commitStatus = deleteInternal(locker, key, null);
                return commitStatus;
            } finally {
                if (locker != null) {
                    locker.operationEnd(commitStatus);
                }
            }
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /*
     * This is commented out until we agree on whether this should even be in
     * the API.  See [14264].
    private OperationStatus delete(Transaction txn,
                                   DatabaseEntry key,
                                   DatabaseEntry data)
        throws DatabaseException {

        try {
            checkEnv();
            DatabaseUtil.checkForNullDbt(key, "key", true);
            DatabaseUtil.checkForNullDbt(data, "data", true);
            checkOpen("Can't call Database.delete:");
            checkWritable("delete");
            trace(Level.FINEST, "Database.delete", txn, key, data, null);

            OperationStatus commitStatus = OperationStatus.NOTFOUND;
            Locker locker = null;
            try {
                locker = LockerFactory.getWritableLocker
                    (envHandle, txn, isTransactional());
                commitStatus = deleteInternal(locker, key, data);
                return commitStatus;
            } finally {
                if (locker != null) {
                    locker.operationEnd(commitStatus);
                }
            }
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }
    */

    /**
     * Internal version of delete() that does no parameter checking.  Notify
     * triggers.  Deletes all duplicates.
     */
    OperationStatus deleteInternal(final Locker locker,
                                   final DatabaseEntry key,
                                   final DatabaseEntry data)
        throws DatabaseException {

        Cursor cursor = null;
        try {
            cursor = new Cursor(this, locker, null);
            cursor.setNonCloning(true);
            OperationStatus commitStatus = OperationStatus.NOTFOUND;

            /* Position a cursor at the specified data record. */
            DatabaseEntry oldData;
            OperationStatus searchStatus;
            if (data == null) {
                oldData = new DatabaseEntry();
                searchStatus =
                    cursor.search(key, oldData, LockMode.RMW, SearchMode.SET);
            } else {
                oldData = data;
                searchStatus =
                    cursor.search(key, oldData, LockMode.RMW, SearchMode.BOTH);
            }

            /* Delete all records with that key. */
            if (searchStatus == OperationStatus.SUCCESS) {
                do {

                    /*
                     * Notify triggers before the actual deletion so that a
                     * primary record never exists while secondary keys refer
                     * to it.  This is relied on by secondary read-uncommitted.
                     */
                    if (hasTriggers()) {
                        notifyTriggers(locker, key, oldData, null);
                    }
                    /* The actual deletion. */
                    commitStatus =
                        cursor.deleteNoNotify(databaseImpl.getRepContext());
                    if (commitStatus != OperationStatus.SUCCESS) {
                        return commitStatus;
                    }

                    if (data != null) {
                        /* delete(key, data) called so only delete one item. */
                        break;
                    }

                    /* Get another duplicate. */
                    if (databaseImpl.getSortedDuplicates()) {
                        searchStatus =
                            cursor.retrieveNext(key, oldData,
                                                LockMode.RMW,
                                                GetMode.NEXT_DUP);
                    } else {
                        searchStatus = OperationStatus.NOTFOUND;
                    }
                } while (searchStatus == OperationStatus.SUCCESS);
                commitStatus = OperationStatus.SUCCESS;
            }
            return commitStatus;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
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
     * @param key the key used as input.  It must be initialized with a
     * non-null byte array by the caller.
     *
     * @param data the data returned as output.  Its byte array does not need
     * to be initialized by the caller.
     * A <a href="Cursor.html#partialEntry">partial data item</a> may be
     * specified to optimize for key only or partial data retrieval.
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
                               final DatabaseEntry data,
                               LockMode lockMode)
        throws LockConflictException,
               DatabaseException,
               IllegalArgumentException {

        try {
            checkEnv();
            DatabaseUtil.checkForNullDbt(key, "key", true);
            DatabaseUtil.checkForNullDbt(data, "data", false);
            checkOpen("Can't call Database.get:");
            trace(Level.FINEST, "Database.get", txn, key, null, lockMode);

            CursorConfig cursorConfig = CursorConfig.DEFAULT;
            if (lockMode == LockMode.READ_COMMITTED) {
                cursorConfig = CursorConfig.READ_COMMITTED;
                lockMode = null;
            }
            checkLockModeWithoutTxn(txn, lockMode);

            Locker locker = null;
            Cursor cursor = null;
            OperationStatus commitStatus = null;
            try {
                locker = LockerFactory.getReadableLocker
                    (envHandle, txn, isTransactional(),
                     false /*retainNonTxnLocks*/,
                     cursorConfig.getReadCommitted());

                cursor = new Cursor(this, locker, cursorConfig);
                cursor.setNonCloning(true);
                commitStatus =
                    cursor.search(key, data, lockMode, SearchMode.SET);
                return commitStatus;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }

                if (locker != null) {
                    locker.operationEnd(commitStatus);
                }
            }
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Retrieves the key/data pair with the given key and data value, that is,
     * both the key and data items must match.
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified to transaction-protect the operation, or null may be specified
     * to perform the operation without transaction protection.  For a
     * non-transactional database, null must be specified.
     *
     * @param key the key used as input. It must be initialized with a non-null
     * byte array by the caller.
     *
     * @param data the data used as input. It must be initialized with a
     * non-null byte array by the caller.
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
                                         final DatabaseEntry data,
                                         LockMode lockMode)
        throws LockConflictException,
               DatabaseException,
               IllegalArgumentException {

        try {
            checkEnv();
            DatabaseUtil.checkForNullDbt(key, "key", true);
            DatabaseUtil.checkForNullDbt(data, "data", true);
            checkOpen("Can't call Database.getSearchBoth:");
            trace(Level.FINEST, "Database.getSearchBoth", txn, key, data,
                  lockMode);

            CursorConfig cursorConfig = CursorConfig.DEFAULT;
            if (lockMode == LockMode.READ_COMMITTED) {
                cursorConfig = CursorConfig.READ_COMMITTED;
                lockMode = null;
            }
            checkLockModeWithoutTxn(txn, lockMode);

            Locker locker = null;
            Cursor cursor = null;
            OperationStatus commitStatus = null;
            try {
                locker = LockerFactory.getReadableLocker
                    (envHandle, txn, isTransactional(),
                     false /*retainNonTxnLocks*/,
                     cursorConfig.getReadCommitted());

                cursor = new Cursor(this, locker, cursorConfig);
                cursor.setNonCloning(true);
                commitStatus =
                    cursor.search(key, data, lockMode, SearchMode.BOTH);
                return commitStatus;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }

                if (locker != null) {
                    locker.operationEnd(commitStatus);
                }
            }
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Stores the key/data pair into the database.
     *
     * <p>If the key already appears in the database and duplicates are not
     * configured, the data associated with the key will be replaced.  If the
     * key already appears in the database and sorted duplicates are
     * configured, the new data value is inserted at the correct sorted
     * location.</p>
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified, or null may be specified to use auto-commit.  For a
     * non-transactional database, null must be specified.
     *
     * @param key the key {@link com.sleepycat.je.DatabaseEntry DatabaseEntry}
     * operated on.
     *
     * @param data the data {@link com.sleepycat.je.DatabaseEntry
     * DatabaseEntry} stored.
     *
     * @return {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS} if the operation succeeds.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws OperationFailureException if this exception occurred earlier and
     * caused the transaction to be invalidated.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this database is read-only.
     *
     * @throws IllegalStateException if the database has been closed.
     */
    public OperationStatus put(final Transaction txn,
                               final DatabaseEntry key,
                               final DatabaseEntry data)
        throws DatabaseException {

        checkEnv();
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(data, "data", true);
        DatabaseUtil.checkForPartialKey(key);
        checkOpen("Can't call Database.put");
        checkWritable("put");
        trace(Level.FINEST, "Database.put", txn, key, data, null);

        return putInternal(txn, key, data, PutMode.OVERWRITE);
    }

    /**
     * Stores the key/data pair into the database if the key does not already
     * appear in the database.
     *
     * <p>This method will return {@link
     * com.sleepycat.je.OperationStatus#KEYEXIST OpeationStatus.KEYEXIST} if
     * the key already exists in the database, even if the database supports
     * duplicates.</p>
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified, or null may be specified to use auto-commit.  For a
     * non-transactional database, null must be specified.
     *
     * @param key the key {@link com.sleepycat.je.DatabaseEntry DatabaseEntry}
     * operated on.
     *
     * @param data the data {@link com.sleepycat.je.DatabaseEntry
     * DatabaseEntry} stored.
     *
     * @return {@link com.sleepycat.je.OperationStatus#KEYEXIST
     * OperationStatus.KEYEXIST} if the key already appears in the database,
     * else {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this database is read-only.
     *
     * @throws IllegalStateException if the database has been closed.
     */
    public OperationStatus putNoOverwrite(final Transaction txn,
                                          final DatabaseEntry key,
                                          final DatabaseEntry data)
        throws DatabaseException {

        checkEnv();
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(data, "data", true);
        DatabaseUtil.checkForPartialKey(key);
        checkOpen("Can't call Database.putNoOverWrite");
        checkWritable("putNoOverwrite");
        trace(Level.FINEST, "Database.putNoOverwrite", txn, key, data, null);

        return putInternal(txn, key, data, PutMode.NO_OVERWRITE);
    }

    /**
     * Stores the key/data pair into the database if it does not already appear
     * in the database.
     *
     * <p>This method may only be called if the underlying database has been
     * configured to support sorted duplicates.</p>
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified, or null may be specified to use auto-commit.  For a
     * non-transactional database, null must be specified.
     *
     * @param key the key {@link com.sleepycat.je.DatabaseEntry DatabaseEntry}
     * operated on.
     *
     * @param data the data {@link com.sleepycat.je.DatabaseEntry
     * DatabaseEntry} stored.
     *
     * @return {@link com.sleepycat.je.OperationStatus#KEYEXIST
     * OperationStatus.KEYEXIST} if the key/data pair already appears in the
     * database, else {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this database is not configured
     * for duplicates, or this database is read-only.
     *
     * @throws IllegalStateException if the database has been closed.
     */
    public OperationStatus putNoDupData(final Transaction txn,
                                        final DatabaseEntry key,
                                        final DatabaseEntry data)
        throws DatabaseException {

        checkEnv();
        DatabaseUtil.checkForNullDbt(key, "key", true);
        DatabaseUtil.checkForNullDbt(data, "data", true);
        DatabaseUtil.checkForPartialKey(key);
        checkOpen("Can't call Database.putNoDupData");
        if (!databaseImpl.getSortedDuplicates()) {
            throw new UnsupportedOperationException
                ("Database is not configured for duplicate data.");
        }
        checkWritable("putNoDupData");
        trace(Level.FINEST, "Database.putNoDupData", txn, key, data, null);

        return putInternal(txn, key, data, PutMode.NO_DUP_DATA);
    }

    /**
     * Internal version of put() that does no parameter checking.
     */
    OperationStatus putInternal(final Transaction txn,
                                final DatabaseEntry key,
                                final DatabaseEntry data,
                                final PutMode putMode)
        throws DatabaseException {

        try {
            Locker locker = null;
            Cursor cursor = null;
            OperationStatus commitStatus = OperationStatus.KEYEXIST;
            try {
                locker = LockerFactory.getWritableLocker
                    (envHandle, txn, isTransactional(),
                     databaseImpl.isReplicated()); // autoTxnIsReplicated

                cursor = new Cursor(this, locker, null);
                cursor.setNonCloning(true);
                commitStatus = cursor.putInternal(key, data, putMode);
                return commitStatus;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                if (locker != null) {
                    locker.operationEnd(commitStatus);
                }
            }
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Creates a specialized join cursor for use in performing equality or
     * natural joins on secondary indices.
     *
     * <p>Each cursor in the <code>cursors</code> array must have been
     * initialized to refer to the key on which the underlying database should
     * be joined.  Typically, this initialization is done by calling {@link
     * Cursor#getSearchKey Cursor.getSearchKey}.</p>
     *
     * <p>Once the cursors have been passed to this method, they should not be
     * accessed or modified until the newly created join cursor has been
     * closed, or else inconsistent results may be returned.  However, the
     * position of the cursors will not be changed by this method or by the
     * methods of the join cursor.</p>
     *
     * @param cursors an array of cursors associated with this primary
     * database.  In a replicated environment, an explicit transaction must be
     * specified when opening each cursor, unless read-uncommitted isolation is
     * isolation is specified via the {@link CursorConfig} or {@link LockMode}
     * parameter.
     *
     * @param config The join attributes.  If null, default attributes are
     * used.
     *
     * @return a specialized cursor that returns the results of the equality
     * join operation.
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
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, an invalid {@code JoinConfig} parameter.
     *
     * @see JoinCursor
     */
    public JoinCursor join(final Cursor[] cursors, final JoinConfig config)
        throws DatabaseException, IllegalArgumentException {

        try {
            checkEnv();
            checkOpen("Can't call Database.join");
            DatabaseUtil.checkForNullParam(cursors, "cursors");
            if (cursors.length == 0) {
                throw new IllegalArgumentException
                    ("At least one cursor is required.");
            }

            /*
             * Check that all cursors use the same locker, if any cursor is
             * transactional.  And if non-transactional, that all databases are
             * in the same environment.
             */
            Locker locker = cursors[0].getCursorImpl().getLocker();
            if (!locker.isTransactional()) {
                EnvironmentImpl env = envHandle.getEnvironmentImpl();
                for (int i = 1; i < cursors.length; i += 1) {
                    Locker locker2 = cursors[i].getCursorImpl().getLocker();
                    if (locker2.isTransactional()) {
                        throw new IllegalArgumentException
                            ("All cursors must use the same transaction.");
                    }
                    EnvironmentImpl env2 = cursors[i].getDatabaseImpl()
                        .getDbEnvironment();
                    if (env != env2) {
                        throw new IllegalArgumentException
                            ("All cursors must use the same environment.");
                    }
                }
                locker = null; /* Don't reuse a non-transactional locker. */
            } else {
                for (int i = 1; i < cursors.length; i += 1) {
                    Locker locker2 = cursors[i].getCursorImpl().getLocker();
                    if (locker.getTxnLocker() != locker2.getTxnLocker()) {
                        throw new IllegalArgumentException
                            ("All cursors must use the same transaction.");
                    }
                }
            }

            /* Create the join cursor. */
            return new JoinCursor(locker, this, cursors, config);
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Preloads the cache.  This method should only be called when there are no
     * operations being performed on the database in other threads.  Executing
     * preload during concurrent updates may result in some or all of the tree
     * being loaded into the JE cache.  Executing preload during any other
     * types of operations may result in JE exceeding its allocated cache
     * size. preload() effectively locks the entire database and therefore will
     * lock out the checkpointer, cleaner, and compressor, as well as not allow
     * eviction to occur.
     *
     * @deprecated As of JE 2.0.83, replaced by {@link
     * Database#preload(PreloadConfig)}.</p>
     *
     * @param maxBytes The maximum number of bytes to load.  If maxBytes is 0,
     * je.evictor.maxMemory is used.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the database has been closed.
     */
    public void preload(final long maxBytes)
        throws DatabaseException {

        checkEnv();
        checkOpen("Can't call Database.preload");

        PreloadConfig config = new PreloadConfig();
        config.setMaxBytes(maxBytes);
        databaseImpl.preload(config);
    }

    /**
     * Preloads the cache.  This method should only be called when there are no
     * operations being performed on the database in other threads.  Executing
     * preload during concurrent updates may result in some or all of the tree
     * being loaded into the JE cache.  Executing preload during any other
     * types of operations may result in JE exceeding its allocated cache
     * size. preload() effectively locks the entire database and therefore will
     * lock out the checkpointer, cleaner, and compressor, as well as not allow
     * eviction to occur.
     *
     * @deprecated As of JE 2.0.101, replaced by {@link
     * Database#preload(PreloadConfig)}.</p>
     *
     * @param maxBytes The maximum number of bytes to load.  If maxBytes is 0,
     * je.evictor.maxMemory is used.
     *
     * @param maxMillisecs The maximum time in milliseconds to use when
     * preloading.  Preloading stops once this limit has been reached.  If
     * maxMillisecs is 0, preloading can go on indefinitely or until maxBytes
     * (if non-0) is reached.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the database has been closed.
     */
    public void preload(final long maxBytes, final long maxMillisecs)
        throws DatabaseException {

        checkEnv();
        checkOpen("Can't call Database.preload");

        PreloadConfig config = new PreloadConfig();
        config.setMaxBytes(maxBytes);
        config.setMaxMillisecs(maxMillisecs);
        databaseImpl.preload(config);
    }

    /**
     * Preloads the cache.  This method should only be called when there are no
     * operations being performed on the database in other threads.  Executing
     * preload during concurrent updates may result in some or all of the tree
     * being loaded into the JE cache.  Executing preload during any other
     * types of operations may result in JE exceeding its allocated cache
     * size. preload() effectively locks the entire database and therefore will
     * lock out the checkpointer, cleaner, and compressor, as well as not allow
     * eviction to occur.
     *
     * @param config The PreloadConfig object that specifies the parameters
     * of the preload.
     *
     * @return A PreloadStats object with various statistics about the
     * preload() operation.
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
     * @throws IllegalArgumentException if {@code PreloadConfig.getMaxBytes} is
     * greater than size of the JE cache.
     */
    public PreloadStats preload(final PreloadConfig config)
        throws DatabaseException {

        checkEnv();
        checkOpen("Can't call Database.preload");

        PreloadConfig useConfig =
            (config == null) ? new PreloadConfig() : config;
        return databaseImpl.preload(useConfig);
    }

    /**
     * Counts the key/data pairs in the database. This operation is faster than
     * obtaining a count from a cursor based scan of the database, and will not
     * perturb the current contents of the cache. However, the count is not
     * guaranteed to be accurate if there are concurrent updates.
     *
     * <p>A count of the key/data pairs in the database is returned without
     * adding to the cache.  The count may not be accurate in the face of
     * concurrent update operations in the database.</p>
     *
     * @return The count of key/data pairs in the database.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the database has been closed.
     */
    public long count()
        throws DatabaseException {

        checkEnv();
        checkOpen("Can't call Database.count");

        return databaseImpl.count();
    }

    /**
     * Returns database statistics.
     *
     * <p>If this method has not been configured to avoid expensive operations
     * (using the {@link com.sleepycat.je.StatsConfig#setFast
     * StatsConfig.setFast} method), it will access some of or all the pages in
     * the database, incurring a severe performance penalty as well as possibly
     * flushing the underlying cache.</p>
     *
     * <p>In the presence of multiple threads or processes accessing an active
     * database, the information returned by this method may be
     * out-of-date.</p>
     *
     * @param config The statistics returned; if null, default statistics are
     * returned.
     *
     * @return Database statistics.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the database has been closed.
     */
    public DatabaseStats getStats(final StatsConfig config)
        throws DatabaseException {

        checkEnv();
        checkOpen("Can't call Database.stat");
        StatsConfig useConfig =
            (config == null) ? StatsConfig.DEFAULT : config;

        if (databaseImpl != null) {
            return databaseImpl.stat(useConfig);
        }
        return null;
    }

    /**
     * Verifies the integrity of the database.
     *
     * <p>Verification is an expensive operation that should normally only be
     * used for troubleshooting and debugging.</p>
     *
     * @param config Configures the verify operation; if null, the default
     * operation is performed.
     *
     * @return Database statistics.
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
    public DatabaseStats verify(final VerifyConfig config)
        throws DatabaseException {

        try {
            checkEnv();
            checkOpen("Can't call Database.verify");
            VerifyConfig useConfig =
                (config == null) ? VerifyConfig.DEFAULT : config;

            DatabaseStats stats = databaseImpl.getEmptyStats();
            databaseImpl.verify(useConfig, stats);
            return stats;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Returns the database name.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return The database name.
     */
    public String getDatabaseName()
        throws DatabaseException {

        try {
            checkEnv();
            if (databaseImpl != null) {
                return databaseImpl.getName();
            }
            return null;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /*
     * Non-transactional database name, safe to access when creating error
     * messages.
     */
    String getDebugName() {
        if (databaseImpl != null) {
            return databaseImpl.getDebugName();
        }
        return null;
    }

    /**
     * Returns this Database object's configuration.
     *
     * <p>This may differ from the configuration used to open this object if
     * the database existed previously.</p>
     *
     * @return This Database object's configuration.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public DatabaseConfig getConfig()
        throws DatabaseException {

        try {
            DatabaseConfig showConfig = configuration.cloneConfig();

            /*
             * Set the comparators from the database impl, they might have
             * changed from another handle.
             */
            Comparator<byte[]> btComp = null;
            Comparator<byte[]> dupComp = null;
            boolean btCompByClass = false;
            boolean dupCompByClass = false;
            if (databaseImpl != null) {
                btComp = databaseImpl.getBtreeComparator();
                dupComp = databaseImpl.getDuplicateComparator();
                btCompByClass = databaseImpl.getBtreeComparatorByClass();
                dupCompByClass = databaseImpl.getDuplicateComparatorByClass();
            }
            showConfig.setBtreeComparatorInternal(btComp, btCompByClass);
            showConfig.setDuplicateComparatorInternal(dupComp, dupCompByClass);
            return showConfig;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Equivalent to getConfig().getTransactional() but cheaper.
     */
    boolean isTransactional() {
        return databaseImpl.isTransactional();
    }

    /**
     * Returns the {@link com.sleepycat.je.Environment Environment} handle for
     * the database environment underlying the {@link
     * com.sleepycat.je.Database Database}.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return The {@link com.sleepycat.je.Environment Environment} handle
     * for the database environment underlying the {@link
     * com.sleepycat.je.Database Database}.
     */
    public Environment getEnvironment() {
        return envHandle;
    }

    /**
     * Returns a list of all {@link com.sleepycat.je.SecondaryDatabase
     * SecondaryDatabase} objects associated with a primary database.
     *
     * <p>If no secondaries are associated or this is itself a secondary
     * database, an empty list is returned.</p>
     *
     * @return A list of all {@link com.sleepycat.je.SecondaryDatabase
     * SecondaryDatabase} objects associated with a primary database.
     */
    public List<SecondaryDatabase> getSecondaryDatabases()
        throws DatabaseException {

        try {
            List<SecondaryDatabase> list = new ArrayList<SecondaryDatabase>();
            if (hasTriggers()) {
                acquireTriggerListReadLock();
                try {
                    for (int i = 0; i < triggerList.size(); i += 1) {
                        DatabaseTrigger t = triggerList.get(i);
                        if (t instanceof SecondaryTrigger) {
                            list.add(((SecondaryTrigger) t).getDb());
                        }
                    }
                } finally {
                    releaseTriggerListReadLock();
                }
            }
            return list;
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /**
     * Compares two keys using either the default comparator if no BTree
     * comparator has been set or the BTree comparator if one has been set.
     *
     * @return -1 if entry1 compares less than entry2,
     *          0 if entry1 compares equal to entry2,
     *          1 if entry1 compares greater than entry2
     *
     * @throws IllegalArgumentException if either entry is a partial
     * DatabaseEntry, or is null.
     */
    public int compareKeys(final DatabaseEntry entry1,
                           final DatabaseEntry entry2) {
        return doCompareKeys(entry1, entry2, false/*duplicates*/);
    }

    /**
     * Compares two data elements using either the default comparator if no
     * duplicate comparator has been set or the duplicate comparator if one has
     * been set.
     *
     * @return -1 if entry1 compares less than entry2,
     *          0 if entry1 compares equal to entry2,
     *          1 if entry1 compares greater than entry2
     *
     * @throws IllegalArgumentException if either entry is a partial
     * DatabaseEntry, or is null.
     */
    public int compareDuplicates(final DatabaseEntry entry1,
                                 final DatabaseEntry entry2) {
        return doCompareKeys(entry1, entry2, true/*duplicates*/);
    }

    private int doCompareKeys(final DatabaseEntry entry1,
                              final DatabaseEntry entry2,
                              final boolean duplicates) {

        try {
            checkEnv();
            DatabaseUtil.checkForNullDbt(entry1, "entry1", true);
            DatabaseUtil.checkForNullDbt(entry2, "entry2", true);
            DatabaseUtil.checkForPartialKey(entry1);
            DatabaseUtil.checkForPartialKey(entry2);
            return databaseImpl.compareEntries(entry1, entry2, duplicates);
        } catch (Error E) {
            DbInternal.getEnvironmentImpl(envHandle).invalidate(E);
            throw E;
        }
    }

    /*
     * Helpers, not part of the public API
     */

    /**
     * Returns true if the Database was opened read/write.
     *
     * @return true if the Database was opened read/write.
     */
    boolean isWritable() {
        return isWritable;
    }

    /**
     * Returns the databaseImpl object instance.
     */
    DatabaseImpl getDatabaseImpl() {
        return databaseImpl;
    }

    /**
     * The handleLocker is the one that holds the db handle lock.
     */
    void setHandleLocker(final Locker locker) {
        handleLocker = locker;
    }

    void removeCursor(final Cursor dbc)
        throws DatabaseException {

        /*
         * Do not call checkOpen if the handle was preempted, to allow closing
         * a cursor after an operation failure.  [#17015]
         */
        if (state != DbState.PREEMPTED) {
            checkOpen("Database was closed while still in use:");
        }
        openCursors.getAndDecrement();
    }

    void addCursor(final Cursor dbc)
        throws DatabaseException {

        checkOpen("Database was closed while still in use:");
        openCursors.getAndIncrement();
    }

    void checkOpen(final String msg) {
        switch (state) {
        case OPEN:
            break;
        case CLOSED:
            throw new IllegalStateException(msg + " Database was closed.");
        case INVALID:
            throw new IllegalStateException
                (msg +
                 " The Transaction used to open the Database was aborted.");
        case PREEMPTED:
            throw preemptedCause.wrapSelf(msg);
        default:
            assert false : state;
        }
    }

    /**
     * @throws EnvironmentFailureException if the underlying environment is
     * invalid
     */
    void checkEnv()
        throws EnvironmentFailureException {

        EnvironmentImpl env = envHandle.getEnvironmentImpl();
        if (env != null) {
            env.checkIfInvalid();
        }
    }

    /**
     * Checks that write operations aren't used on a readonly Database.
     */
    private void checkWritable(final String operation) {
        if (!isWritable) {
            throw new UnsupportedOperationException
                ("Database is Read Only: " + operation);
        }
    }

    void checkLockModeWithoutTxn(final Transaction userTxn,
                                 final LockMode lockMode) {
        if (userTxn == null && LockMode.RMW.equals(lockMode)) {
            throw new IllegalArgumentException
                (lockMode + " is meaningless and can not be specified " +
                 "when a null (autocommit) transaction is used. There " +
                 "will never be a follow on operation which will promote " +
                 "the lock to WRITE.");
        }
    }

    /**
     * Sends trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    void trace(final Level level,
               final String methodName,
               final Transaction txn,
               final DatabaseEntry key,
               final DatabaseEntry data,
               final LockMode lockMode)
        throws DatabaseException {

        if (logger.isLoggable(level)) {
            StringBuffer sb = new StringBuffer();
            sb.append(methodName);
            if (txn != null) {
                sb.append(" txnId=").append(txn.getId());
            }
            sb.append(" key=").append(key.dumpData());
            if (data != null) {
                sb.append(" data=").append(data.dumpData());
            }
            if (lockMode != null) {
                sb.append(" lockMode=").append(lockMode);
            }
            LoggerUtils.logMsg
                (logger, envHandle.getEnvironmentImpl(), level, sb.toString());
        }
    }

    /**
     * Sends trace messages to the java.util.logger. Don't rely on the logger
     * alone to conditionalize whether we send this message, we don't even want
     * to construct the message if the level is not enabled.
     */
    void trace(final Level level,
               final String methodName,
               final Transaction txn,
               final CursorConfig config)
        throws DatabaseException {

        if (logger.isLoggable(level)) {
            StringBuffer sb = new StringBuffer();
            sb.append(methodName);
            sb.append(" name=" + getDebugName());
            if (txn != null) {
                sb.append(" txnId=").append(txn.getId());
            }
            if (config != null) {
                sb.append(" config=").append(config);
            }
            LoggerUtils.logMsg
                (logger, envHandle.getEnvironmentImpl(), level, sb.toString());
        }
    }

    /*
     * Manage triggers.
     */

    /**
     * Returns whether any triggers are currently associated with this primary.
     * Note that an update of the trigger list may be in progress and this
     * method does not wait for that update to be completed.
     */
    boolean hasTriggers() {

        return triggerList != null;
    }

    /**
     * Gets a read-lock on the list of triggers.  releaseTriggerListReadLock()
     * must be called to release the lock.  Called by all primary put and
     * delete operations.
     */
    private void acquireTriggerListReadLock()
        throws DatabaseException {

        EnvironmentImpl env = envHandle.getEnvironmentImpl();
        env.getTriggerLatch().acquireShared();
        if (triggerList == null) {
            triggerList = new ArrayList<DatabaseTrigger>();
        }
    }

    /**
     * Releases a lock acquired by calling acquireTriggerListReadLock().
     */
    private void releaseTriggerListReadLock()
        throws DatabaseException {

        EnvironmentImpl env = envHandle.getEnvironmentImpl();
        env.getTriggerLatch().release();
    }

    /**
     * Gets a write lock on the list of triggers.  An empty list is created if
     * necessary, so null is never returned.  releaseTriggerListWriteLock()
     * must always be called to release the lock.
     */
    private void acquireTriggerListWriteLock()
        throws DatabaseException {

        EnvironmentImpl env = envHandle.getEnvironmentImpl();
        env.getTriggerLatch().acquireExclusive();
        if (triggerList == null) {
            triggerList = new ArrayList<DatabaseTrigger>();
        }
    }

    /**
     * Releases a lock acquired by calling acquireTriggerListWriteLock().  If
     * the list is now empty then it is set to null, that is, hasTriggers()
     * will subsequently return false.
     */
    private void releaseTriggerListWriteLock()
        throws DatabaseException {

        if (triggerList.size() == 0) {
            triggerList = null;
        }
        EnvironmentImpl env = envHandle.getEnvironmentImpl();
        env.getTriggerLatch().release();
    }

    /**
     * Adds a given trigger to the list of triggers.  Called while opening
     * a SecondaryDatabase.
     *
     * @param insertAtFront true to insert at the front, or false to append.
     */
    void addTrigger(final DatabaseTrigger trigger, final boolean insertAtFront)
        throws DatabaseException {

        acquireTriggerListWriteLock();
        try {
            if (insertAtFront) {
                triggerList.add(0, trigger);
            } else {
                triggerList.add(trigger);
            }
            trigger.triggerAdded(this);
        } finally {
            releaseTriggerListWriteLock();
        }
    }

    /**
     * Removes a given trigger from the list of triggers.  Called by
     * SecondaryDatabase.close().
     */
    void removeTrigger(final DatabaseTrigger trigger)
        throws DatabaseException {

        acquireTriggerListWriteLock();
        try {
            triggerList.remove(trigger);
            trigger.triggerRemoved(this);
        } finally {
            releaseTriggerListWriteLock();
        }
    }

    /**
     * Clears the list of triggers.  Called by close(), this allows closing the
     * primary before its secondaries, although we document that secondaries
     * should be closed first.
     */
    private void removeAllTriggers()
        throws DatabaseException {

        acquireTriggerListWriteLock();
        try {
            for (int i = 0; i < triggerList.size(); i += 1) {
                DatabaseTrigger trigger = triggerList.get(i);
                trigger.triggerRemoved(this);
            }
            triggerList.clear();
        } finally {
            releaseTriggerListWriteLock();
        }
    }

    /**
     * Notifies associated triggers when a put() or delete() is performed on
     * the primary.  This method is normally called only if hasTriggers() has
     * returned true earlier.  This avoids acquiring a shared latch for
     * primaries with no triggers.  If a trigger is added during the update
     * process, there is no requirement to immediately start updating it.
     *
     * @param locker the internal locker.
     *
     * @param priKey the primary key.
     *
     * @param oldData the primary data before the change, or null if the record
     * did not previously exist.
     *
     * @param newData the primary data after the change, or null if the record
     * has been deleted.
     */
    void notifyTriggers(final Locker locker,
                        final DatabaseEntry priKey,
                        final DatabaseEntry oldData,
                        final DatabaseEntry newData)
        throws DatabaseException {

        acquireTriggerListReadLock();
        try {
            for (int i = 0; i < triggerList.size(); i += 1) {
                DatabaseTrigger trigger = triggerList.get(i);

                /* Notify trigger. */
                trigger.databaseUpdated
                    (this, locker, priKey, oldData, newData);
            }
        } finally {
            releaseTriggerListReadLock();
        }
    }
}
