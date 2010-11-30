/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.io.File;
import java.util.Properties;

import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.dbi.PutMode;
import com.sleepycat.je.dbi.CursorImpl.SearchMode;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.Txn;

/**
 * @hidden
 * For internal use only. It serves to shelter methods that must be public to
 * be used by other BDB JE packages but that are not part of the public API
 * available to applications.
 */
public class DbInternal {

    /**
     * Proxy to Database.invalidate()
     */
    public static void invalidate(final Database db) {
        db.invalidate();
    }

    /**
     * Proxy to Database.setPreempted()
     */
    public static void setPreempted(final Database db,
                                    final String dbName,
                                    final String msg) {
        db.setPreempted(dbName, msg);
    }

    /**
     * Proxy to Database.setHandleLockOwnerTxn
     */
    public static void setHandleLocker(final Database db,
                                       final Locker locker) {
        db.setHandleLocker(locker);
    }

    /**
     * Proxy to Environment.getEnvironmentImpl
     */
    public static EnvironmentImpl getEnvironmentImpl(final Environment env) {
        return env.getEnvironmentImpl();
    }

    /**
     * Proxy to Cursor.position().
     */
    public static OperationStatus position(final Cursor cursor,
                                           final DatabaseEntry key,
                                           final DatabaseEntry data,
                                           final LockMode lockMode,
                                           final boolean first) {
        return cursor.position(key, data, lockMode, first);
    }

    /**
     * Proxy to Cursor.search().
     */
    public static OperationStatus search(final Cursor cursor,
                                         final DatabaseEntry key,
                                         final DatabaseEntry data,
                                         final LockMode lockMode,
                                         final SearchMode searchMode) {
        return cursor.search(key, data, lockMode, searchMode);
    }

    /**
     * Proxy to Cursor.retrieveNext().
     */
    public static OperationStatus retrieveNext(final Cursor cursor,
                                               final DatabaseEntry key,
                                               final DatabaseEntry data,
                                               final LockMode lockMode,
                                               final GetMode getMode)
        throws DatabaseException {

        return cursor.retrieveNext(key, data, lockMode, getMode);
    }

    /**
     * Proxy to Cursor.advanceCursor()
     */
    public static boolean advanceCursor(final Cursor cursor,
                                        final DatabaseEntry key,
                                        final DatabaseEntry data) {
        return cursor.advanceCursor(key, data);
    }

    /**
     * Proxy to Cursor.deleteInternal()
     */
    public static OperationStatus
        deleteInternal(final Cursor cursor,
                       final ReplicationContext repContext) {
        return cursor.deleteInternal(repContext);
    }

    /**
     * Proxy to Cursor.putLN()
     */
    public static OperationStatus putLN(final Cursor cursor,
                                        final byte[] key,
                                        final LN ln,
                                        final PutMode putMode,
                                        final ReplicationContext repContext) {
        return cursor.putLN(key, ln, putMode, repContext);
    }

    /**
     * Proxy to Cursor.getCursorImpl()
     */
    public static CursorImpl getCursorImpl(Cursor cursor) {
        return cursor.getCursorImpl();
    }

    /**
     * Create a Cursor for internal use from a DatabaseImpl.
     */
    public static Cursor makeCursor(final DatabaseImpl databaseImpl,
                                    final Locker locker,
                                    final CursorConfig cursorConfig) {
        final Cursor cursor = new Cursor(databaseImpl, locker, cursorConfig, 
                                         true /* retainNonTxnLocks */);
        /* Internal cursors don't need cloning. */
        cursor.setNonCloning(true);
        return cursor;
    }

    /**
     * Proxy to Database.getDatabaseImpl()
     */
    public static DatabaseImpl getDatabaseImpl(final Database db) {
        return db.getDatabaseImpl();
    }

    /**
     * Proxy to JoinCursor.getSortedCursors()
     */
    public static Cursor[] getSortedCursors(final JoinCursor cursor) {
        return cursor.getSortedCursors();
    }

    /**
     * Proxy to EnvironmentConfig.setLoadPropertyFile()
     */
    public static void setLoadPropertyFile(final EnvironmentConfig config,
                                           final boolean loadProperties) {
        config.setLoadPropertyFile(loadProperties);
    }

    /**
     * Proxy to EnvironmentConfig.setCreateUP()
     */
    public static void setCreateUP(final EnvironmentConfig config,
                                   final boolean checkpointUP) {
        config.setCreateUP(checkpointUP);
    }

    /**
     * Proxy to EnvironmentConfig.getCreateUP()
     */
    public static boolean getCreateUP(final EnvironmentConfig config) {
        return config.getCreateUP();
    }

    /**
     * Proxy to EnvironmentConfig.setCheckpointUP()
     */
    public static void setCheckpointUP(final EnvironmentConfig config,
                                       final boolean checkpointUP) {
        config.setCheckpointUP(checkpointUP);
    }

    /**
     * Proxy to EnvironmentConfig.getCheckpointUP()
     */
    public static boolean getCheckpointUP(final EnvironmentConfig config) {
        return config.getCheckpointUP();
    }

    /**
     * Proxy to EnvironmentConfig.setTxnReadCommitted()
     */
    public static void setTxnReadCommitted(final EnvironmentConfig config,
                                           final boolean txnReadCommitted) {
        config.setTxnReadCommitted(txnReadCommitted);
    }

    /**
     * Proxy to EnvironmentConfig.setTxnReadCommitted()
     */
    public static boolean getTxnReadCommitted(final EnvironmentConfig config) {
        return config.getTxnReadCommitted();
    }

    /**
     * Proxy to EnvironmentMutableConfig.cloneMutableConfig()
     */
    public static EnvironmentMutableConfig
        cloneMutableConfig(final EnvironmentMutableConfig config) {
        return config.cloneMutableConfig();
    }

    /**
     * Proxy to EnvironmentMutableConfig.checkImmutablePropsForEquality()
     */
    public static void
        checkImmutablePropsForEquality(final EnvironmentMutableConfig config,
                                       final Properties handleConfigProps)
        throws IllegalArgumentException {

        config.checkImmutablePropsForEquality(handleConfigProps);
    }

    /**
     * Proxy to EnvironmentMutableConfig.copyMutablePropsTo()
     */
    public static void
        copyMutablePropsTo(final EnvironmentMutableConfig config,
                           final EnvironmentMutableConfig toConfig) {
        config.copyMutablePropsTo(toConfig);
    }

    /**
     * Proxy to EnvironmentMutableConfig.validateParams.
     */
    public static void
        disableParameterValidation(final EnvironmentMutableConfig config) {
        config.setValidateParams(false);
    }

    /**
     * Proxy to EnvironmentMutableConfig.getProps
     */
    public static Properties getProps(final EnvironmentMutableConfig config) {
        return config.getProps();
    }

    /**
     * Proxy to DatabaseConfig.setUseExistingConfig()
     */
    public static void setUseExistingConfig(final DatabaseConfig config,
                                            final boolean useExistingConfig) {
        config.setUseExistingConfig(useExistingConfig);
    }

    /**
     * Proxy to DatabaseConfig.validate(DatabaseConfig()
     */
    public static void validate(final DatabaseConfig config1,
                                final DatabaseConfig config2)
        throws DatabaseException {

        config1.validate(config2);
    }

    /**
     * Proxy to Transaction.getLocker()
     */
    public static Locker getLocker(final Transaction txn)
        throws DatabaseException {

        return txn.getLocker();
    }

    /**
     * Proxy to Environment.getDefaultTxnConfig()
     */
    public static TransactionConfig
        getDefaultTxnConfig(final Environment env) {
        return env.getDefaultTxnConfig();
    }

    /**
     * Get an Environment only if the environment is already open. This
     * will register this Environment in the EnvironmentImpl's reference count,
     * but will not configure the environment.
     * @return null if the environment is not already open.
     */
    public static Environment getEnvironmentShell(final File environmentHome) {
        Environment env = null;
        try {
            env = new Environment(environmentHome);

            /* If the environment is not already open, return a null. */
            if (env.getEnvironmentImpl() == null) {
                env = null;
            }
        } catch (Exception e) {

            /*
             * Klockwork - ok
             * the environment is not valid.
             */
        }
        return env;
    }

    public static ExceptionEvent makeExceptionEvent(final Exception e,
                                                    final String n) {
        return new ExceptionEvent(e, n);
    }

    public static void setReplicated(final DatabaseConfig dbConfig,
                                     final boolean replicated) {
        dbConfig.setReplicated(replicated);
    }

    public static boolean getReplicated(final DatabaseConfig dbConfig) {

        return dbConfig.getReplicated();
    }

    public static Txn getTxn(final Transaction transaction) {
        return transaction.getTxn();
    }
}
