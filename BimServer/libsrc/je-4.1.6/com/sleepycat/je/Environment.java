/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.io.File;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.transaction.xa.Xid;

import com.sleepycat.je.Durability.ReplicaAckPolicy;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbEnvPool;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.RepConfigProxy;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.LockerFactory;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.DatabaseUtil;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * A database environment.  Environments include support for some or all of
 * caching, locking, logging and transactions.
 *
 * <p>To open an existing environment with default attributes the application
 * may use a default environment configuration object or null:
 * <blockquote>
 *     <pre>
 *      // Open an environment handle with default attributes.
 *     Environment env = new Environment(home, new EnvironmentConfig());
 *     </pre>
 * </blockquote>
 * or
 * <blockquote><pre>
 *     Environment env = new Environment(home, null);
 * </pre></blockquote>
 * <p>Note that many Environment objects may access a single environment.</p>
 * <p>To create an environment or customize attributes, the application should
 * customize the configuration class. For example:</p>
 * <blockquote><pre>
 *     EnvironmentConfig envConfig = new EnvironmentConfig();
 *     envConfig.setTransactional(true);
 *     envConfig.setAllowCreate(true);
 *     envConfig.setCacheSize(1000000);
 *     Environment newlyCreatedEnv = new Environment(home, envConfig);
 * </pre></blockquote>
 *
 * <p>Note that environment configuration parameters can also be set through
 * the &lt;environment home&gt;/je.properties file. This file takes precedence
 * over any programmatically specified configuration parameters so that
 * configuration changes can be made without recompiling. Environment
 * configuration follows this order of precedence:</p>
 *
 * <ol>
 * <li>Configuration parameters specified in
 * &lt;environment home&gt;/je.properties take first precedence.
 * <li> Configuration parameters set in the EnvironmentConfig object used at
 * Environment construction are next.
 * <li>Any configuration parameters not set by the application are set to
 * system defaults, described along with the parameter name String constants
 * in the EnvironmentConfig class.
 * </ol>
 *
 * <p>An <em>environment handle</em> is an Environment instance.  More than one
 * Environment instance may be created for the same physical directory, which
 * is the same as saying that more than one Environment handle may be open at
 * one time for a given environment.</p>
 *
 * The Environment handle should not be closed while any other handle remains
 * open that is using it as a reference (for example, {@link
 * com.sleepycat.je.Database Database} or {@link com.sleepycat.je.Transaction
 * Transaction}.  Once {@link com.sleepycat.je.Environment#close
 * Environment.close} is called, this object may not be accessed again.
 */
public class Environment {

    /**
     * @hidden
     * envImpl is a reference to the shared underlying environment.
     */
    protected EnvironmentImpl envImpl;
    private TransactionConfig defaultTxnConfig;
    private EnvironmentMutableConfig handleConfig;
    private final EnvironmentConfig appliedFinalConfig;

    private final Set<Database> referringDbs;
    private final Set<Transaction> referringDbTxns;

    /**
     * @hidden
     * The name of the cleaner daemon thread.  This constant is passed to an
     * ExceptionEvent's threadName argument when an exception is thrown in the
     * cleaner daemon thread.
     */
    public static final String CLEANER_NAME = "Cleaner";

    /**
     * @hidden
     * The name of the IN Compressor daemon thread.  This constant is passed to
     * an ExceptionEvent's threadName argument when an exception is thrown in
     * the IN Compressor daemon thread.
     */
    public static final String INCOMP_NAME = "INCompressor";

    /**
     * @hidden
     * The name of the Checkpointer daemon thread.  This constant is passed to
     * an ExceptionEvent's threadName argument when an exception is thrown in
     * the Checkpointer daemon thread.
     */
    public static final String CHECKPOINTER_NAME = "Checkpointer";

    /**
     * Creates a database environment handle.
     *
     * @param envHome The database environment's home directory.
     *
     * @param configuration The database environment attributes.  If null,
     * default attributes are used.
     *
     * @throws EnvironmentNotFoundException if the environment does not exist
     * (does not contain at least one log file) and the {@code
     * EnvironmentConfig AllowCreate} parameter is false.
     *
     * @throws EnvironmentLockedException when an environment cannot be opened
     * for write access because another process has the same environment open
     * for write access.  <strong>Warning:</strong> This exception should be
     * handled when an environment is opened by more than one process.
     *
     * @throws VersionMismatchException when the existing log is not compatible
     * with the version of JE that is running.  This occurs when a later
     * version of JE was used to create the log.  <strong>Warning:</strong>
     * This exception should be handled when more than one version of JE may be
     * used to access an environment.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this environment was previously
     * opened for replication and is not being opened read-only.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, an invalid {@code EnvironmentConfig} parameter.
     */
    public Environment(File envHome, EnvironmentConfig configuration)
        throws EnvironmentNotFoundException,
               EnvironmentLockedException,
               VersionMismatchException,
               DatabaseException,
               IllegalArgumentException {

        this(envHome, configuration, true /*openIfNeeded*/,
             null /* rep config */);
    }

    /**
     * @hidden
     * Replication support.
     */
    protected Environment(File envHome,
                          EnvironmentConfig configuration,
                          RepConfigProxy repConfigProxy) {
        this(envHome, configuration, true /*openIfNeeded*/, repConfigProxy);
    }

    /**
     * Gets an Environment for an existing EnvironmentImpl. Used by utilities
     * such as the JMX MBean which don't want to open the environment or be
     * reference counted. The calling application must take care not to retain
     */
    Environment(File envHome) {
        this(envHome, null /*configuration*/, false /*openIfNeeded*/,
             null /* not replicated */);
    }

    /**
     * Internal common constructor.
     */
    private Environment(File envHome,
                        EnvironmentConfig envConfig,
                        boolean openIfNeeded,
                        RepConfigProxy repConfigProxy) {

        /* If openIfNeeded is false, then envConfig must be null. */
        assert openIfNeeded || envConfig == null;

        envImpl = null;
        referringDbs = Collections.synchronizedSet(new HashSet<Database>());
        referringDbTxns =
            Collections.synchronizedSet(new HashSet<Transaction>());

        DatabaseUtil.checkForNullParam(envHome, "envHome");

        appliedFinalConfig =
            setupHandleConfig(envHome, envConfig, repConfigProxy);

        /* Open a new or existing environment in the shared pool. */
        envImpl = makeEnvironmentImpl(envHome,
                                      envConfig,
                                      openIfNeeded,
                                      repConfigProxy);
    }

    /**
     * @hidden
     * MakeEnvironmentImpl is called both by the Environment constructor and
     * by the ReplicatedEnvironment constructor when recreating the environment
     * for a hard recovery.
     */
    protected EnvironmentImpl makeEnvironmentImpl
        (File envHome,
         EnvironmentConfig envConfig,
         boolean openIfNeeded,
         RepConfigProxy repConfigProxy) {

        envImpl = DbEnvPool.getInstance().getEnvironment
            (envHome,
             appliedFinalConfig,
             envConfig != null /*checkImmutableParams*/,
             openIfNeeded,
             setupRepConfig(envHome, repConfigProxy, envConfig));

        if (envImpl != null) {
            envImpl.registerMBean(this);
        }

        return envImpl;
    }

    /**
     * Validate the parameters specified in the environment config.  Applies
     * the configurations specified in the je.properties file to override any
     * programmatically set configurations.  Create a copy to save in this
     * handle. The main reason to return a config instead of using the
     * handleConfig field is to return an EnvironmentConfig instead of a
     * EnvironmentMutableConfig.
     */
    private EnvironmentConfig setupHandleConfig(File envHome,
                                                EnvironmentConfig envConfig,
                                                RepConfigProxy repConfig)
        throws IllegalArgumentException {

        /* If the user specified a null object, use the default */
        EnvironmentConfig baseConfig = (envConfig == null) ?
            EnvironmentConfig.DEFAULT : envConfig;

        /* Make a copy, apply je.properties, and init the handle config. */
        EnvironmentConfig useConfig = baseConfig.clone();

        /* Apply the je.properties file. */
        if (useConfig.getLoadPropertyFile()) {
            DbConfigManager.applyFileConfig(envHome,
                                            DbInternal.getProps(useConfig),
                                            false);       // forReplication
        }
        copyToHandleConfig(useConfig, useConfig, repConfig);
        return useConfig;
    }

    /**
     * @hidden
     * Obtain a validated replication configuration. In a non-HA environment,
     * return null.
     */
    protected RepConfigProxy
        setupRepConfig(final File envHome,
                       final RepConfigProxy repConfigProxy,
                       final EnvironmentConfig envConfig) {

        return null;
    }

    /**
     * The Environment.close method closes the Berkeley DB environment.
     *
     * <p>When the last environment handle is closed, allocated resources are
     * freed, and daemon threads are stopped, even if they are performing work.
     * For example, if the cleaner is still cleaning the log, it will be
     * stopped at the next reasonable opportunity and perform no more cleaning
     * operations.</p>
     *
     * <p>The Environment handle should not be closed while any other handle
     * that refers to it is not yet closed; for example, database environment
     * handles must not be closed while database handles remain open, or
     * transactions in the environment have not yet committed or aborted.
     * Specifically, this includes {@link com.sleepycat.je.Database Database},
     * {@link com.sleepycat.je.Cursor Cursor} and {@link
     * com.sleepycat.je.Transaction Transaction} handles.</p>
     *
     * <p>In multithreaded applications, only a single thread should call
     * Environment.close.</p>
     *
     * <p>After this method has been called, regardless of its return, this
     * Berkeley DB environment handle may not be accessed again, with one
     * exception:  the {@code close} method itself may be called any number of
     * times to simplify error handling.</p>
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the underlying environment has already
     * been closed, or if any open databases or transactions refer to this
     * handle.
     */
    public synchronized void close()
        throws DatabaseException {

        closeInternal(true); // A user initiated close
    }

    /**
     * As documented above. The userInitiatedClose argument is used to
     * determine whether an exception should be thrown when the operation is
     * invoked on a replicated environment. It's permissible for the Replicator
     * to close the environment internally, as part of a close operation on
     * the Replicator, but it's an error if the operation is attempted by the
     * user via Environment.close.
     *
     * @param userInitiatedClose true if user initiated the close operation
     */
    synchronized void closeInternal(final boolean userInitiatedClose) {

        if (envImpl == null) {
            return;
        }

        if (!envImpl.isValid()) {

            /*
             * We're trying to close on an environment that has seen a fatal
             * exception. Try to do the minimum, such as closing file
             * descriptors, to support re-opening the environment in the same
             * JVM.
             */
            try {
                envImpl.closeAfterInvalid();
            } finally {
                envImpl = null;
            }
            return;
        }

        final StringBuffer errors = new StringBuffer();
        try {
            if (referringDbs != null) {
                final int nDbs = referringDbs.size();
                if (nDbs != 0) {
                    errors.append("There ");
                    if (nDbs == 1) {
                        errors.append
                            ("is 1 open Database in the Environment.\n");
                    } else {
                        errors.append("are ");
                        errors.append(nDbs);
                        errors.append
                            (" open Databases in the Environment.\n");
                    }
                    errors.append("Closing the following databases:\n");

                    /*
                     * Copy the referringDbs Set because db.close() below
                     * modifies this Set, potentially causing a
                     * ConcurrentModificationException.
                     */
                    final Iterator<Database> iter =
                        new HashSet<Database>(referringDbs).iterator();
                    while (iter.hasNext()) {
                        String dbName = "";
                        try {
                            Database db = iter.next();

                            /*
                             * Save the db name before we attempt the close,
                             * it's unavailable after the close.
                             */
                            dbName = db.getDebugName();
                            errors.append(dbName).append(" ");
                            db.close();
                        } catch (RuntimeException e) {
                            if (!envImpl.isValid()) {
                                /* Propagate if env is invalidated. */
                                throw e;
                            }
                            errors.append("\nWhile closing Database ");
                            errors.append(dbName);
                            errors.append(" encountered exception: ");
                            errors.append(e).append("\n");
                        }
                    }
                }
            }

            if (referringDbTxns != null) {
                int nTxns = referringDbTxns.size();
                if (nTxns != 0) {
                    Iterator<Transaction> iter = referringDbTxns.iterator();
                    errors.append("There ");
                    if (nTxns == 1) {
                        errors.append("is 1 existing transaction opened");
                        errors.append(" against the Environment.\n");
                    } else {
                        errors.append("are ");
                        errors.append(nTxns);
                        errors.append(" existing transactions opened against");
                        errors.append(" the Environment.\n");
                    }
                    errors.append("Aborting open transactions ...\n");

                    while (iter.hasNext()) {
                        Transaction txn = iter.next();
                        try {
                            errors.append("aborting " + txn);
                            txn.abort();
                        } catch (RuntimeException e) {
                            if (!envImpl.isValid()) {
                                /* Propagate if env is invalidated. */
                                throw e;
                            }
                            errors.append("\nWhile aborting transaction ");
                            errors.append(txn.getId());
                            errors.append(" encountered exception: ");
                            errors.append(e).append("\n");
                        }
                    }
                }
            }

            Xid[] openXids = envImpl.getTxnManager().XARecover();
            if (openXids != null && openXids.length > 0) {
                errors.append("There ");
                int nXATxns = openXids.length;
                if (nXATxns == 1) {
                    errors.append("is 1 existing XA transaction opened");
                    errors.append(" in the Environment.\n");
                    errors.append("It");
                } else {
                    errors.append("are ");
                    errors.append(nXATxns);
                    errors.append(" existing transactions opened in");
                    errors.append(" the Environment.\n");
                    errors.append("They");
                }
                errors.append(" will be left open ...\n");
            }

            try {
                envImpl.close();
            } catch (RuntimeException e) {
                if (!envImpl.isValid()) {
                    /* Propagate if env is invalidated. */
                    throw e;
                }
                errors.append
                    ("\nWhile closing Environment encountered exception: ");
                errors.append(e).append("\n");
            }

            if (errors.length() > 0) {
                throw new IllegalStateException(errors.toString());
            }
        } finally {
            envImpl = null;
        }
    }

    /**
     * Opens, and optionally creates, a <code>Database</code>.
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified, or null may be specified to use auto-commit.  For a
     * non-transactional database, null must be specified.
     *
     * @param databaseName The name of the database.
     *
     * @param dbConfig The database attributes.  If null, default attributes
     * are used.
     *
     * @return Database handle.
     *
     * @throws DatabaseExistsException if the database already exists and the
     * {@code DatabaseConfig ExclusiveCreate} parameter is true.
     *
     * @throws DatabaseNotFoundException if the database does not exist and the
     * {@code DatabaseConfig AllowCreate} parameter is false.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs. If the database does not exist and the {@link
     * DatabaseConfig#setAllowCreate AllowCreate} parameter is true, then one
     * of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> may also occur.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, an invalid {@code DatabaseConfig} property.
     */
    public synchronized Database openDatabase(Transaction txn,
                                              String databaseName,
                                              DatabaseConfig dbConfig)
        throws DatabaseNotFoundException,
               DatabaseExistsException,
               IllegalArgumentException {

        checkHandleIsValid();
        checkEnv();

        /*
         * Currently all user-created databases are replicated in a replicated
         * environment.
         */
        try {
            if (dbConfig == null) {
                dbConfig = DatabaseConfig.DEFAULT;
            }

            Database db = new Database(this);
            setupDatabase(txn, db, databaseName, dbConfig,
                          false,                  // needWritableLockerForInit,
                          false,                   // allowReservedName,
                          envImpl.isReplicated()); // autoTxnIsReplicated
            return db;
        } catch (Error E) {
            envImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * Creates a database for internal JE use. Used in situations when the user
     * needs a Database handle; some internal uses go directly to the
     * DatabaseImpl. DbConfig should not be null. Note that the dbConfig
     * argument determines whether the database that is created is to be
     * replicated or is standalone. The current default is for dbConfig to be
     * replicated, so use DatabaseConfig.setReplicated(false) to create a local
     * internal database.
     *
     *  - permits use of reserved names.
     *  - the Locker used is non-transactional or an auto commit txn
     */
    synchronized Database openInternalDatabase(String databaseName,
                                               DatabaseConfig dbConfig,
                                               Transaction txn)
        throws DatabaseNotFoundException, DatabaseExistsException {

        boolean isReplicated = DbInternal.getReplicated(dbConfig);
        assert (DbInternal.getReplicated(dbConfig) ?
                envImpl.isReplicated() :
                true) :
               databaseName + " needs a replicated environment";
        try {
            Database db = new Database(this);
            setupDatabase(txn,
                          db, databaseName, dbConfig,
                          false,  // needWritableLockerForInit,
                          true,   // allowReservedName
                          isReplicated);
            return db;
        } catch (Error E) {
            envImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * Opens and optionally creates a <code>SecondaryDatabase</code>.
     *
     * <p>Note that the associations between primary and secondary databases
     * are not stored persistently.  Whenever a primary database is opened for
     * write access by the application, the appropriate associated secondary
     * databases should also be opened by the application.  This is necessary
     * to ensure data integrity when changes are made to the primary
     * database.</p>
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified, or null may be specified to use auto-commit.  For a
     * non-transactional database, null must be specified.
     *
     * @param databaseName The name of the database.
     *
     * @param primaryDatabase the primary database with which the secondary
     * database will be associated.  The primary database must not be
     * configured for duplicates.
     *
     * @param dbConfig The secondary database attributes.  If null, default
     * attributes are used.
     *
     * @return Database handle.
     *
     * @throws DatabaseExistsException if the database already exists and the
     * {@code DatabaseConfig ExclusiveCreate} parameter is true.
     *
     * @throws DatabaseNotFoundException if the database does not exist and the
     * {@code DatabaseConfig AllowCreate} parameter is false.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs. If the database does not exist and the {@link
     * DatabaseConfig#setAllowCreate AllowCreate} parameter is true, then one
     * of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> may also occur.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, an invalid {@code SecondaryConfig} property.
     */
    public synchronized
        SecondaryDatabase openSecondaryDatabase(Transaction txn,
                                                String databaseName,
                                                Database primaryDatabase,
                                                SecondaryConfig dbConfig)
        throws DatabaseNotFoundException,
               DatabaseExistsException,
               DatabaseException,
               IllegalArgumentException {

        checkHandleIsValid();
        checkEnv();
        try {
            if (dbConfig == null) {
                dbConfig = SecondaryConfig.DEFAULT;
            }
            SecondaryDatabase db =
                new SecondaryDatabase(this, dbConfig, primaryDatabase);

            /*
             * If we're populating the secondary, we should own with
             * a writable Locker.
             */
            boolean needWritableLockerForInit = dbConfig.getAllowPopulate();
            setupDatabase(txn, db, databaseName, dbConfig,
                          needWritableLockerForInit,
                          false,                   // allowReservedName
                          envImpl.isReplicated()); // autoTxnIsReplicated
            return db;
        } catch (Error E) {
            envImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * @param txn may be null
     * @param newDb is the Database handle which houses this database
     * @param allowReserveName true if this database may use one of the
     * names reserved for JE internal databases.
     * @param autoTxnIsReplicated true if this setupDatabase is going to set
     * up a replicated database.
     *
     * @throws IllegalArgumentException via openDatabase and
     * openSecondaryDatabase
     */
    private void setupDatabase(Transaction txn,
                               Database newDb,
                               String databaseName,
                               DatabaseConfig dbConfig,
                               boolean needWritableLockerForInit,
                               boolean allowReservedName,
                               boolean autoTxnIsReplicated)
        throws DatabaseNotFoundException, DatabaseExistsException {

        checkEnv();
        DatabaseUtil.checkForNullParam(databaseName, "databaseName");

        LoggerUtils.envLogMsg(Level.FINEST, envImpl,
                              "Environment.open: " + " name=" + databaseName +
                              " dbConfig=" + dbConfig);

        /*
         * Check that the open configuration is valid and doesn't conflict with
         * the envImpl configuration.
         */
        validateDbConfig(dbConfig, databaseName);
        validateDbConfigAgainstEnv(dbConfig, databaseName);

        /* Perform eviction before each operation that allocates memory. */
        envImpl.criticalEviction(false /*backgroundIO*/);

        Locker locker = null;
        DatabaseImpl database = null;
        boolean operationOk = false;
        boolean dbIsClosing = false;
        try {

            /*
             * Does this database exist? Get a transaction to use. If the
             * database exists already, we really only need a readable locker.
             * If the database must be created, we need a writable one.
             * Unfortunately, we have to get the readable one first before we
             * know whether we have to create.  However, if we need to write
             * during initialization (to populate a secondary for example),
             * then just create a writable locker now.
             */
            boolean isWritableLocker;
            if (needWritableLockerForInit) {
                locker = LockerFactory.getWritableLocker
                    (this,
                     txn,
                     dbConfig.getTransactional(),
                     true /*retainNonTxnLocks*/,
                     autoTxnIsReplicated,
                     null);
                isWritableLocker = true;
            } else {
                locker = LockerFactory.getReadableLocker
                    (this, txn,
                     dbConfig.getTransactional(),
                     true /*retainNonTxnLocks*/,
                     false /*readCommittedIsolation*/);

                isWritableLocker = !dbConfig.getTransactional() ||
                    (locker.isTransactional() &&
                     !envImpl.isReplicated());
            }

            database = envImpl.getDbTree().getDb(locker, databaseName, newDb);
            boolean databaseExists =
                (database != null) && !database.isDeleted();

            if (databaseExists) {
                if (dbConfig.getAllowCreate() &&
                    dbConfig.getExclusiveCreate()) {
                    /* We intended to create this, but it already exists. */
                    dbIsClosing = true;
                    throw new DatabaseExistsException
                        ("Database " + databaseName + " already exists");
                }

                newDb.initExisting(this, locker, database, dbConfig);
            } else {
                /* Release deleted DB. [#13415] */
                envImpl.getDbTree().releaseDb(database);
                database = null;

                if (!allowReservedName &&
                    DbTree.isReservedDbName(databaseName)) {
                    throw new IllegalArgumentException
                        (databaseName + " is a reserved database name.");
                }

                /* No database. Create if we're allowed to. */
                if (dbConfig.getAllowCreate()) {

                    /*
                     * We're going to have to do some writing. Switch to a
                     * writable locker if we don't already have one.  Note
                     * that the existing locker does not hold the handle lock
                     * we need, since the database was not found; therefore it
                     * is OK to call operationEnd on the existing locker.
                     */
                    if (!isWritableLocker) {
                        locker.operationEnd(OperationStatus.SUCCESS);
                        locker = LockerFactory.getWritableLocker
                            (this,
                             txn,
                             dbConfig.getTransactional(),
                             true,  // retainNonTxnLocks
                             autoTxnIsReplicated,
                             null);
                        isWritableLocker  = true;
                    }

                    newDb.initNew(this, locker, databaseName, dbConfig);
                } else {
                    /* We aren't allowed to create this database. */
                    throw new DatabaseNotFoundException("Database " +
                                                        databaseName +
                                                        " not found.");
                }
            }

            operationOk = true;
            addReferringHandle(newDb);
        } finally {

            /*
             * Tell the transaction that this operation is over. Some types of
             * transactions (BasicLocker and auto Txn) will actually
             * finish. The transaction can decide if it is finishing and if it
             * needs to transfer the db handle lock it owns to someone else.
             */
            if (locker != null) {
                locker.setHandleLockOwner(operationOk, newDb, dbIsClosing);
                locker.operationEnd(operationOk);
            }

            /*
             * Normally releaseDb will be called when the DB is closed, or by
             * abort if a transaction is used, or by setHandleLockOwner if a
             * non-transactional locker is used.  But when the open operation
             * fails and the Database.databaseImpl field was not initialized,
             * we must call releaseDb here. [#13415]
             */
            if ((!operationOk || dbIsClosing) &&
                newDb.getDatabaseImpl() == null) {
                envImpl.getDbTree().releaseDb(database);
            }
        }
    }

    /**
     * @throws IllegalArgumentException via openDatabase and
     * openSecondaryDatabase
     */
    private void validateDbConfig(DatabaseConfig dbConfig, String databaseName)
        throws IllegalArgumentException {

        if ((dbConfig.getDeferredWrite() && dbConfig.getTemporary()) ||
            (dbConfig.getDeferredWrite() && dbConfig.getTransactional()) ||
            (dbConfig.getTemporary() && dbConfig.getTransactional())) {
            throw new IllegalArgumentException
                ("Attempted to open Database " + databaseName +
                 " and two ore more of the following exclusive properties" +
                 " are true: deferredWrite, temporary, transactional");
        }

        /*
         * R/W database handles on a replicated database must be transactional,
         * for now. In the future we may support non-transactional database
         * handles.
         */
        if (envImpl.isReplicated() &&
            dbConfig.getReplicated() &&
            !dbConfig.getReadOnly()) {
            if (!dbConfig.getTransactional()) {
                throw new IllegalArgumentException
                ("Read/Write Database instances for replicated " +
                 "database " + databaseName + " must be transactional.");
            }
        }
    }

    /**
     * @throws IllegalArgumentException via openDatabase and
     * openSecondaryDatabase
     */
    private void validateDbConfigAgainstEnv(DatabaseConfig dbConfig,
                                            String databaseName)
        throws IllegalArgumentException {

        /* Check operation's transactional status against the Environment */
        if (dbConfig.getTransactional() &&
            !(envImpl.isTransactional())) {
            throw new IllegalArgumentException
                ("Attempted to open Database " + databaseName +
                 " transactionally, but parent Environment is" +
                 " not transactional");
        }

        /* Check read/write status */
        if (envImpl.isReadOnly() && (!dbConfig.getReadOnly())) {
            throw new IllegalArgumentException
                ("Attempted to open Database " + databaseName +
                 " as writable but parent Environment is read only ");
        }
    }

    /**
     * Removes a database from the environment, discarding all records in the
     * database and removing the database name itself.
     *
     * <p>Compared to deleting all the records in a database individually,
     * {@code removeDatabase} is a very efficient operation.  Some internal
     * housekeeping information is updated, but the database records are not
     * read or written, and very little I/O is needed.</p>
     *
     * <p>When called on a database configured with secondary indices, the
     * application is responsible for also removing all associated secondary
     * indices.  To guarantee integrity, a primary database and all of its
     * secondary databases should be removed atomically using a single
     * transaction.</p>
     *
     * <p>Applications should not remove a database with open {@link Database
     * Database} handles.  If the database is open with the same transaction as
     * passed in the {@code txn} parameter, {@link IllegalStateException} is
     * thrown by this method.  If the database is open using a different
     * transaction, this method will block until all database handles are
     * closed, or until the conflict is resolved by throwing {@link
     * LockConflictException}.</p>
     *
     * @param txn For a transactional environment, an explicit transaction
     * may be specified or null may be specified to use auto-commit.  For a
     * non-transactional environment, null must be specified.
     *
     * @param databaseName The database to be removed.
     *
     * @throws DatabaseNotFoundException if the database does not exist.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this is a read-only
     * environment.
     *
     * @throws IllegalStateException if the database is currently open using
     * the transaction passed in the {@code txn} parameter, or if this handle
     * or the underlying environment has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public void removeDatabase(Transaction txn, String databaseName)
        throws DatabaseNotFoundException {

        checkHandleIsValid();
        DatabaseUtil.checkForNullParam(databaseName, "databaseName");
        checkEnv();
        checkWritable();

        final boolean autoTxnIsReplicated = envImpl.isReplicated();
        Locker locker = null;
        boolean operationOk = false;
        try {

            /*
             * Note: use env level isTransactional as proxy for the db
             * isTransactional.
             */
            locker = LockerFactory.getWritableLocker
                (this,
                 txn,
                 envImpl.isTransactional(),
                 true,  // retainNonTxnLocks,
                 autoTxnIsReplicated,
                 null);
            envImpl.getDbTree().dbRemove(locker,
                                         databaseName,
                                         null /*checkId*/);
            operationOk = true;
        } catch (Error E) {
            envImpl.invalidate(E);
            throw E;
        } finally {
            if (locker != null) {
                locker.operationEnd(operationOk);
            }
        }
    }

    /**
     * Renames a database, without removing the records it contains.
     *
     * <p>Applications should not rename a database with open {@link Database
     * Database} handles.  If the database is open with the same transaction as
     * passed in the {@code txn} parameter, {@link IllegalStateException} is
     * thrown by this method.  If the database is open using a different
     * transaction, this method will block until all database handles are
     * closed, or until the conflict is resolved by throwing {@link
     * LockConflictException}.</p>
     *
     * @param txn For a transactional environment, an explicit transaction
     * may be specified or null may be specified to use auto-commit.  For a
     * non-transactional environment, null must be specified.
     *
     * @param databaseName The new name of the database.
     *
     * @throws DatabaseNotFoundException if the database does not exist.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this is a read-only
     * environment.
     *
     * @throws IllegalStateException if the database is currently open using
     * the transaction passed in the {@code txn} parameter, or if this handle
     * or the underlying environment has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public void renameDatabase(Transaction txn,
                               String databaseName,
                               String newName)
        throws DatabaseNotFoundException {

        DatabaseUtil.checkForNullParam(databaseName, "databaseName");
        DatabaseUtil.checkForNullParam(newName, "newName");

        checkHandleIsValid();
        checkEnv();
        checkWritable();

        Locker locker = null;
        boolean operationOk = false;
        try {

            /*
             * Note: use env level isTransactional as proxy for the db
             * isTransactional.
             */
            locker = LockerFactory.getWritableLocker
                (this, txn,
                 envImpl.isTransactional(),
                 true /*retainNonTxnLocks*/,
                 envImpl.isReplicated(),  // autoTxnIsReplicated
                 null);
            envImpl.getDbTree().dbRename(locker, databaseName, newName);
            operationOk = true;
        } catch (Error E) {
            envImpl.invalidate(E);
            throw E;
        } finally {
            if (locker != null) {
                locker.operationEnd(operationOk);
            }
        }
    }

    /**
     * Empties the database, discarding all the records it contains, without
     * removing the database name.
     *
     * <p>Compared to deleting all the records in a database individually,
     * {@code truncateDatabase} is a very efficient operation.  Some internal
     * housekeeping information is updated, but the database records are not
     * read or written, and very little I/O is needed.</p>
     *
     * <p>When called on a database configured with secondary indices, the
     * application is responsible for also truncating all associated secondary
     * indices.  To guarantee integrity, a primary database and all of its
     * secondary databases should be truncated atomically using a single
     * transaction.</p>
     *
     * <p>Applications should not truncate a database with open {@link Database
     * Database} handles.  If the database is open with the same transaction as
     * passed in the {@code txn} parameter, {@link IllegalStateException} is
     * thrown by this method.  If the database is open using a different
     * transaction, this method will block until all database handles are
     * closed, or until the conflict is resolved by throwing {@link
     * LockConflictException}.</p>
     *
     * @param txn For a transactional environment, an explicit transaction may
     * be specified or null may be specified to use auto-commit.  For a
     * non-transactional environment, null must be specified.
     *
     * @param databaseName The database to be truncated.
     *
     * @param returnCount If true, count and return the number of records
     * discarded.
     *
     * @return The number of records discarded, or -1 if returnCount is false.
     *
     * @throws DatabaseNotFoundException if the database does not exist.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this is a read-only
     * environment.
     *
     * @throws IllegalStateException if the database is currently open using
     * the transaction passed in the {@code txn} parameter, or if this handle
     * or the underlying environment has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public long truncateDatabase(Transaction txn,
                                 String databaseName,
                                 boolean returnCount)
        throws DatabaseNotFoundException {

        checkHandleIsValid();
        DatabaseUtil.checkForNullParam(databaseName, "databaseName");
        checkEnv();
        checkWritable();

        final boolean autoTxnIsReplicated = envImpl.isReplicated();
        Locker locker = null;
        boolean operationOk = false;
        long count = 0;
        try {

            /*
             * Note: use env level isTransactional as proxy for the db
             * isTransactional.
             */
            locker = LockerFactory.getWritableLocker
                (this, txn,
                 envImpl.isTransactional(),
                 true /*retainNonTxnLocks*/,
                 autoTxnIsReplicated,
                 null);

            count = envImpl.getDbTree().truncate(locker,
                                                 databaseName,
                                                 returnCount);

            operationOk = true;
        } catch (Error E) {
            envImpl.invalidate(E);
            throw E;
        } finally {
            if (locker != null) {
                locker.operationEnd(operationOk);
            }
        }
        return count;
    }

    /**
     * For unit testing.  Returns the current memory usage in bytes for all
     * btrees in the envImpl.
     */
    long getMemoryUsage()
        throws DatabaseException {

        checkHandleIsValid();
        checkEnv();

        return envImpl.getMemoryBudget().getCacheMemoryUsage();
    }

    /**
     * Returns the database environment's home directory.
     *
     * @return The database environment's home directory.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public File getHome()
        throws DatabaseException {

        checkHandleIsValid();

        return envImpl.getEnvironmentHome();
    }

    /*
     * Transaction management
     */

    /**
     * Returns the default txn config for this environment handle.
     */
    TransactionConfig getDefaultTxnConfig() {
        return defaultTxnConfig;
    }

    /**
     * Copies the handle properties out of the config properties, and
     * initializes the default transaction config.
     */
    private void copyToHandleConfig(EnvironmentMutableConfig useConfig,
                                    EnvironmentConfig initStaticConfig,
                                    RepConfigProxy    initRepConfig) {

        /*
         * Create the new objects, initialize them, then change the instance
         * fields.  This avoids synchronization issues.
         */
        EnvironmentMutableConfig newHandleConfig =
            new EnvironmentMutableConfig();
        useConfig.copyHandlePropsTo(newHandleConfig);
        this.handleConfig = newHandleConfig;

        TransactionConfig newTxnConfig =
            TransactionConfig.DEFAULT.clone();
        newTxnConfig.setNoSync(handleConfig.getTxnNoSync());
        newTxnConfig.setWriteNoSync(handleConfig.getTxnWriteNoSync());
        newTxnConfig.setDurability(handleConfig.getDurability());

        if (initStaticConfig != null) {
            newTxnConfig.setSerializableIsolation
                (initStaticConfig.getTxnSerializableIsolation());
            newTxnConfig.setReadCommitted
                (initStaticConfig.getTxnReadCommitted());
        } else {
            newTxnConfig.setSerializableIsolation
                (defaultTxnConfig.getSerializableIsolation());
            newTxnConfig.setReadCommitted
                (defaultTxnConfig.getReadCommitted());
            newTxnConfig.setConsistencyPolicy
                (defaultTxnConfig.getConsistencyPolicy());
        }
        if (initRepConfig != null) {
            newTxnConfig.setConsistencyPolicy
                (initRepConfig.getConsistencyPolicy());
        }
        this.defaultTxnConfig = newTxnConfig;
    }

    /**
     * Creates a new transaction in the database environment.
     *
     * <p>Transaction handles are free-threaded; transactions handles may be
     * used concurrently by multiple threads.</p>
     *
     * <p>Cursors may not span transactions; that is, each cursor must be
     * opened and closed within a single transaction. The parent parameter is a
     * placeholder for nested transactions, and must currently be null.</p>
     *
     * @param txnConfig The transaction attributes.  If null, default
     * attributes are used.
     *
     * @return The newly created transaction's handle.
     *
     * @throws com.sleepycat.je.rep.InsufficientReplicasException if the Master
     * in a replicated environment could not contact a quorum of replicas as
     * determined by the {@link ReplicaAckPolicy}.
     *
     * @throws com.sleepycat.je.rep.ReplicaConsistencyException if a replica
     * in a replicated environment cannot become consistent within the timeout
     * period.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this is not a transactional
     * environment.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, an invalid {@code TransactionConfig} parameter.
     */
    public Transaction beginTransaction(Transaction parent,
                                        TransactionConfig txnConfig)
        throws DatabaseException,
               IllegalArgumentException {

        try {
            return beginTransactionInternal(parent, txnConfig);
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * @throws IllegalArgumentException via beginTransaction.
     * @throws UnsupportedOperationException via beginTransaction.
     */
    private Transaction beginTransactionInternal(Transaction parent,
                                                 TransactionConfig txnConfig)
        throws DatabaseException {

        checkHandleIsValid();
        checkEnv();

        if (parent != null) {
            throw new IllegalArgumentException
                ("Parent txn is non-null. " +
                 "Nested transactions are not supported.");
        }

        if (!envImpl.isTransactional()) {
            throw new UnsupportedOperationException
                ("Transactions can not be used in a non-transactional " +
                 "environment");
        }

        checkTxnConfig(txnConfig);

        /*
         * Apply txn config defaults.  We don't need to clone unless we have to
         * apply the env default, since we don't hold onto a txn config
         * reference.
         */
        TransactionConfig useConfig = null;
        if (txnConfig == null) {
            useConfig = defaultTxnConfig;
        } else {
            if (defaultTxnConfig.getNoSync() ||
                defaultTxnConfig.getWriteNoSync()) {

                /*
                 * The environment sync settings have been set, check if any
                 * were set in the user's txn config. If none were set in the
                 * user's config, apply the environment defaults
                 */
                if (!txnConfig.getNoSync() &&
                    !txnConfig.getSync() &&
                    !txnConfig.getWriteNoSync()) {
                    useConfig = txnConfig.clone();
                    if (defaultTxnConfig.getWriteNoSync()) {
                        useConfig.setWriteNoSync(true);
                    } else {
                        useConfig.setNoSync(true);
                    }
                }
            }

            if ((defaultTxnConfig.getDurability() != null) &&
                 (txnConfig.getDurability() == null)) {

                /*
                 * Inherit transaction durability from the environment in the
                 * absence of an explicit transaction config durability.
                 */
                if (useConfig == null) {
                    useConfig = txnConfig.clone();
                }
                useConfig.setDurability(defaultTxnConfig.getDurability());
            }

            if ((defaultTxnConfig.getConsistencyPolicy() != null) &&
                (txnConfig.getConsistencyPolicy() == null)) {
                   if (useConfig == null) {
                       useConfig = txnConfig.clone();
                   }
                   useConfig.setConsistencyPolicy
                       (defaultTxnConfig.getConsistencyPolicy());
            }

            /* Apply isolation level default. */
            if (!txnConfig.getSerializableIsolation() &&
                !txnConfig.getReadCommitted() &&
                !txnConfig.getReadUncommitted()) {
                if (defaultTxnConfig.getSerializableIsolation()) {
                    if (useConfig == null) {
                        useConfig = txnConfig.clone();
                    }
                    useConfig.setSerializableIsolation(true);
                } else if (defaultTxnConfig.getReadCommitted()) {
                    if (useConfig == null) {
                        useConfig = txnConfig.clone();
                    }
                    useConfig.setReadCommitted(true);
                }
            }

            /* No environment level defaults applied. */
            if (useConfig == null) {
                useConfig = txnConfig;
            }
        }
        Txn internalTxn = envImpl.txnBegin(parent, useConfig);
        Transaction txn = new Transaction(this, internalTxn);
        addReferringHandle(txn);
        return txn;
    }

    /**
     * Checks the txnConfig object to ensure that its correctly configured and
     * is compatible with the configuration of the Environment.
     *
     * @param txnConfig the configuration being checked.
     *
     * @throws IllegalArgumentException via beginTransaction
     */
    private void checkTxnConfig(TransactionConfig txnConfig)
        throws IllegalArgumentException {

        if (txnConfig == null) {
            return;
        }
        if ((txnConfig.getSerializableIsolation() &&
             txnConfig.getReadUncommitted()) ||
            (txnConfig.getSerializableIsolation() &&
             txnConfig.getReadCommitted()) ||
            (txnConfig.getReadUncommitted() &&
             txnConfig.getReadCommitted())) {
            throw new IllegalArgumentException
                ("Only one may be specified: SerializableIsolation, " +
                "ReadCommitted or ReadUncommitted");
        }
        if ((txnConfig.getDurability() != null) &&
            ((defaultTxnConfig.getSync() ||
              defaultTxnConfig.getNoSync() ||
              defaultTxnConfig.getWriteNoSync()))) {
           throw new IllegalArgumentException
               ("Mixed use of deprecated durability API for the " +
                "Environment with the new durability API for " +
                "TransactionConfig.setDurability()");
        }
        if ((defaultTxnConfig.getDurability() != null) &&
            ((txnConfig.getSync() ||
              txnConfig.getNoSync() ||
              txnConfig.getWriteNoSync()))) {
            throw new IllegalArgumentException
                   ("Mixed use of new durability API for the " +
                    "Environment with the deprecated durability API for " +
                    "TransactionConfig.");
        }
    }

    /**
     * Synchronously checkpoint the database environment.
     *
     * <p>This is an optional action for the application since this activity
     * is, by default, handled by a database environment owned background
     * thread.</p>
     *
     * @param ckptConfig The checkpoint attributes.  If null, default
     * attributes are used.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public void checkpoint(CheckpointConfig ckptConfig)
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            CheckpointConfig useConfig =
                (ckptConfig == null) ? CheckpointConfig.DEFAULT : ckptConfig;

            envImpl.invokeCheckpoint(useConfig,
                                     false, // flushAll
                                     "api");
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Synchronously flushes database environment databases to stable storage.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public void sync()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            CheckpointConfig config = new CheckpointConfig();
            config.setForce(true);
            envImpl.invokeCheckpoint(config,
                                     true,  // flushAll
                                     "sync");
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Synchronously invokes database environment log cleaning.  This method is
     * called periodically by the cleaner daemon thread.
     *
     * <p>Zero or more log files will be cleaned as necessary to bring the disk
     * space utilization of the environment above the configured minimum
     * utilization threshold.  The threshold is determined by the {@link
     * EnvironmentConfig#CLEANER_MIN_UTILIZATION} configuration setting.</p>
     *
     * <p>Note that <code>cleanLog</code> does not perform the complete task of
     * cleaning a log file.  Eviction and checkpointing migrate records that
     * are marked by the cleaner, and a full checkpoint is necessary following
     * cleaning before cleaned files will be deleted (or renamed).  Checkpoints
     * normally occur periodically and when the environment is closed.</p>
     *
     * <p>This is an optional action for the application since this activity
     * is, by default, handled by one or more database environment owned
     * background threads.</p>
     *
     * <p>There are two intended use cases for the <code>cleanLog</code>
     * method.  The first case is where the application wishes to disable the
     * built-in cleaner threads using the {@link
     * EnvironmentConfig#ENV_RUN_CLEANER} property.  To replace the
     * functionality of the cleaner threads, the application should call
     * <code>cleanLog</code> periodically.</p>
     *
     * <p>In the second use case, "batch cleaning", the application disables
     * the cleaner threads for maximum performance during active periods, and
     * calls <code>cleanLog</code> during periods when the application is
     * quiescent or less active than usual.  If the cleaner has a large number
     * of files to clean, <code>cleanLog</code> may stop without reaching the
     * target utilization; to ensure that the target utilization is reached,
     * <code>cleanLog</code> should be called in a loop until it returns
     * zero. And to complete the work of cleaning, a checkpoint is necessary.
     * An example of performing batch cleaning follows.</p>
     *
     * <pre>
     *       Environment env;
     *       boolean anyCleaned = false;
     *       while (env.cleanLog() &gt; 0) {
     *           anyCleaned = true;
     *       }
     *       if (anyCleaned) {
     *           CheckpointConfig force = new CheckpointConfig();
     *           force.setForce(true);
     *           env.checkpoint(force);
     *       }
     * </pre>
     *
     * <p><em>WARNING:</em>If batch cleaning (shown above) is performed
     * immediately before closing the environment, then the built-in cleaner
     * threads should normally be disabled using {@link
     * EnvironmentConfig#ENV_RUN_CLEANER} during the batch cleaning process.
     * If the built-in cleaner threads are actively working on one or more log
     * files, then those files will not be processed by the {@code cleanLog}
     * method.  Closing the environment will abort the work being done by the
     * built-in cleaner threads, and log cleaning may be incomplete.</p>
     *
     * @return The number of log files that were cleaned, and that will be
     * deleted (or renamed) when a qualifying checkpoint occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if this is a read-only or
     * memory-only environment.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public int cleanLog()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            return envImpl.invokeCleaner();
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Synchronously invokes the mechanism for keeping memory usage within the
     * cache size boundaries.
     *
     * <p>This is an optional action for the application since this activity
     * is, by default, handled by a database environment owned background
     * thread.</p>
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public void evictMemory()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            envImpl.invokeEvictor();
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Synchronously invokes the compressor mechanism which compacts in memory
     * data structures after delete operations.
     *
     * <p>This is an optional action for the application since this activity
     * is, by default, handled by a database environment owned background
     * thread.</p>
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public void compress()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            envImpl.invokeCompressor();
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Returns this object's configuration.
     *
     * @return This object's configuration.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle has been closed.
     */
    public EnvironmentConfig getConfig()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            EnvironmentConfig config = envImpl.cloneConfig();
            handleConfig.copyHandlePropsTo(config);
            config.fillInEnvironmentGeneratedProps(envImpl);
            return config;
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Sets database environment attributes.
     *
     * <p>Attributes only apply to a specific Environment object and are not
     * necessarily shared by other Environment objects accessing this
     * database environment.</p>
     *
     * @param mutableConfig The database environment attributes.  If null,
     * default attributes are used.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle has been closed.
     */
    public synchronized
        void setMutableConfig(EnvironmentMutableConfig mutableConfig)
        throws DatabaseException {

        /*
         * This method is synchronized so that we atomically call both
         * EnvironmentImpl.setMutableConfig and copyToHandleConfig. This
         * ensures that the handle and the EnvironmentImpl properties match.
         */
        try {
            checkHandleIsValid();
            DatabaseUtil.checkForNullParam(mutableConfig, "mutableConfig");

            /*
             * Change the mutable properties specified in the given
             * configuration.
             */
            envImpl.setMutableConfig(mutableConfig);

            /* Reset the handle config properties. */
            copyToHandleConfig(mutableConfig, null, null);
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Returns database environment attributes.
     *
     * @return Environment attributes.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle has been closed.
     */
    public EnvironmentMutableConfig getMutableConfig()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            EnvironmentMutableConfig config =
                envImpl.cloneMutableConfig();
            handleConfig.copyHandlePropsTo(config);
            config.fillInEnvironmentGeneratedProps(envImpl);
            return config;
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Returns the general database environment statistics.
     *
     * @param config The general statistics attributes.  If null, default
     * attributes are used.
     *
     * @return The general database environment statistics.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public EnvironmentStats getStats(StatsConfig config)
        throws DatabaseException {

        checkHandleIsValid();
        checkEnv();
        try {
            StatsConfig useConfig =
                (config == null) ? StatsConfig.DEFAULT : config;

            if (envImpl != null) {
                return envImpl.loadStats(useConfig);
            }
            return new EnvironmentStats();
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Returns the database environment's locking statistics.
     *
     * @param config The locking statistics attributes.  If null, default
     * attributes are used.
     *
     * @return The database environment's locking statistics.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     *
     * @deprecated as of 4.0.10, replaced by {@link
     * Environment#getStats(StatsConfig)}.</p>
     */
    public LockStats getLockStats(StatsConfig config)
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            StatsConfig useConfig =
                (config == null) ? StatsConfig.DEFAULT : config;

            return envImpl.lockStat(useConfig);
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Returns the database environment's transactional statistics.
     *
     * @param config The transactional statistics attributes.  If null,
     * default attributes are used.
     *
     * @return The database environment's transactional statistics.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public TransactionStats getTransactionStats(StatsConfig config)
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            StatsConfig useConfig =
                (config == null) ? StatsConfig.DEFAULT : config;
            return envImpl.txnStat(useConfig);
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Returns a List of database names for the database environment.
     *
     * <p>Each element in the list is a String.</p>
     *
     * @return A List of database names for the database environment.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public List<String> getDatabaseNames()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            return envImpl.getDbTree().getDbNames();
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * For internal use only.
     * @hidden
     * Scans raw log entries in the JE log between two given points, passing
     * all records for a given set of databases to the scanRecord method of the
     * given LogScanner object.
     *
     * <p>EnvironmentStats.getEndOfLog should be used to get the end-of-log at
     * a particular point in time.  Values returned by that method can be
     * passed for the startPostion and endPosition parameters.</p>
     *
     * <p><em>WARNING:</em> This interface is meant for low level processing of
     * log records, not for application level queries. See LogScanner for
     * further restrictions!</p>
     *
     * @param startPosition the log position at which to start scanning. If no
     * such log position exists, the first existing position greater or less
     * (if forward is true or false) is used.
     *
     * @param endPosition the log position at which to stop scanning. If no
     * such log position exists, the first existing position less or greater
     * (if forward is true or false) is used.
     *
     * @param config the parameters for this scanLog invocation.
     *
     * @param scanner is an object of a class that implements the LogScanner
     * interface, to process scanned records.
     *
     * @return true if the scan was completed, or false if the scan was
     * canceled because LogScanner.scanRecord returned false.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public boolean scanLog(long startPosition,
                           long endPosition,
                           LogScanConfig config,
                           LogScanner scanner)
        throws DatabaseException, IllegalArgumentException {

        try {
            checkHandleIsValid();
            checkEnv();

            if (startPosition < 0 ||
                endPosition < 0) {
                throw new IllegalArgumentException
                    ("The start or end position argument is negative.");
            }

            if (config.getForwards()) {
                if (startPosition >= endPosition) {
                    throw new IllegalArgumentException
                        ("The startPosition (" + startPosition +
                        ") is not before the endPosition (" +
                        endPosition + ") on a forward scan.");
                }
            } else {
                if (startPosition < endPosition) {
                    throw new IllegalArgumentException
                        ("The startPosition (" +
                         startPosition +
                         ") is not after the endPosition (" +
                         endPosition + ") on a backward scan.");
                }
            }

            return envImpl.scanLog(startPosition, endPosition,
                                   config, scanner);
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Returns if the database environment is consistent and correct.
     *
     * <p>Verification is an expensive operation that should normally only be
     * used for troubleshooting and debugging.</p>
     *
     * @param config The verification attributes.  If null, default
     * attributes are used.
     *
     * @param out The stream to which verification debugging information is
     * written.
     *
     * @return true if the database environment is consistent and correct.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public boolean verify(VerifyConfig config, PrintStream out)
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            VerifyConfig useConfig =
                (config == null) ? VerifyConfig.DEFAULT : config;
            return envImpl.verify(useConfig, out);
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Returns the transaction associated with this thread if implied
     * transactions are being used.  Implied transactions are used in an XA or
     * JCA "Local Transaction" environment.  In an XA environment the
     * XAEnvironment.start() entrypoint causes a transaction to be created and
     * become associated with the calling thread.  Subsequent API calls
     * implicitly use that transaction.  XAEnvironment.end() causes the
     * transaction to be disassociated with the thread.  In a JCA Local
     * Transaction environment, the call to JEConnectionFactory.getConnection()
     * causes a new transaction to be created and associated with the calling
     * thread.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public Transaction getThreadTransaction()
        throws DatabaseException {

        checkHandleIsValid();
        checkEnv();
        try {
            return envImpl.getTxnManager().getTxnForThread();
        } catch (Error E) {
            if (envImpl != null) {
                envImpl.invalidate(E);
            }
            throw E;
        }
    }

    /**
     * Sets the transaction associated with this thread if implied transactions
     * are being used.  Implied transactions are used in an XA or JCA "Local
     * Transaction" environment.  In an XA environment the
     * XAEnvironment.start() entrypoint causes a transaction to be created and
     * become associated with the calling thread.  Subsequent API calls
     * implicitly use that transaction.  XAEnvironment.end() causes the
     * transaction to be disassociated with the thread.  In a JCA Local
     * Transaction environment, the call to JEConnectionFactory.getConnection()
     * causes a new transaction to be created and associated with the calling
     * thread.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has been closed.
     */
    public void setThreadTransaction(Transaction txn) {

        checkHandleIsValid();
        checkEnv();
        try {
            envImpl.getTxnManager().setTxnForThread(txn);
        } catch (Error E) {
            envImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * Returns whether this {@code Environment} is open, valid and can be used.
     * If this method returns false, {@link #close} should be called as soon as
     * possible.
     *
     * <p>When an {@link EnvironmentFailureException}, or one of its
     * subclasses, is caught, the {@code isValid} method should be called to
     * determine whether the {@code Environment} can continue to be used, or
     * should be closed.</p>
     */
    public boolean isValid() {
        return envImpl != null &&
               envImpl.isValid();
    }

    /*
     * Non public api -- helpers
     */

    /*
     * Let the Environment remember what's opened against it.
     */
    void addReferringHandle(Database db) {
        referringDbs.add(db);
    }

    /**
     * Lets the Environment remember what's opened against it.
     */
    void addReferringHandle(Transaction txn) {
        referringDbTxns.add(txn);
    }

    /**
     * The referring db has been closed.
     */
    void removeReferringHandle(Database db) {
        referringDbs.remove(db);
    }

    /**
     * The referring Transaction has been closed.
     */
    void removeReferringHandle(Transaction txn) {
        referringDbTxns.remove(txn);
    }

    /**
     * For internal use only.
     * @hidden
     * @throws IllegalStateException if the environment is not open.
     */
    public void checkHandleIsValid()
        throws DatabaseException {

        if (envImpl == null) {
            throw new IllegalStateException
                ("Attempt to use non-open Environment object().");
        }
    }

    /*
     * Debugging aids.
     */

    /**
     * Internal entrypoint.
     */
    EnvironmentImpl getEnvironmentImpl() {
        return envImpl;
    }

    /**
     * For internal use only.
     * @hidden
     * Throws if the envImpl is invalid.
     */
    protected void checkEnv()
        throws DatabaseException, EnvironmentFailureException {

        if (envImpl == null) {
            return;
        }
        envImpl.checkIfInvalid();
        envImpl.checkNotClosed();
    }

    /**
     * @throws UnsupportedOperationException via the database operation methods
     * (remove, truncate, rename) and potentially other methods that require a
     * writable environment.
     */
    private void checkWritable() {
        if (envImpl.isReadOnly()) {
            throw new UnsupportedOperationException
                ("Environment is Read-Only.");
        }
    }
}
