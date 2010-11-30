/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jca.ra;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.SecondaryConfig;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.XAEnvironment;

public class JEManagedConnection implements ManagedConnection {
    private final ArrayList<ConnectionEventListener> listeners;
    private JEConnection conn;
    private XAEnvironment env;
    private JELocalTransaction savedLT;
    private TransactionConfig savedTransConfig;
    private final Map<String,Database> rwDatabaseHandleCache;
    private final Map<String,Database> roDatabaseHandleCache;
    private final Map<String,Database> rwSecondaryDatabaseHandleCache;
    private final Map<String,Database> roSecondaryDatabaseHandleCache;

    JEManagedConnection(Subject subject, JERequestInfo jeInfo)
        throws ResourceException {

        try {
            savedTransConfig = jeInfo.getTransactionConfig();
            this.env = new XAEnvironment(jeInfo.getJERootDir(),
                                         jeInfo.getEnvConfig());
        } catch (DatabaseException DE) {
            throw new ResourceException(DE.toString());
        }
          listeners = new ArrayList<ConnectionEventListener>();
        savedLT = null;
        rwDatabaseHandleCache = new HashMap<String,Database>();
        roDatabaseHandleCache = new HashMap<String,Database>();
        rwSecondaryDatabaseHandleCache = new HashMap<String,Database>();
        roSecondaryDatabaseHandleCache = new HashMap<String,Database>();
    }

    public Object getConnection(Subject subject,
                                ConnectionRequestInfo connectionRequestInfo) {
        if (conn == null) {
            conn = new JEConnection(this);
        }
        return conn;
    }

    protected XAEnvironment getEnvironment() {
        return env;
    }

    public LocalTransaction getLocalTransaction() {

        /*
         * If there is no JEConnection associated with this ManagedConnection
         * yet, then the ManagedConnection holds on to the JELocalTransaction.
         * Once a JEConnection is associated (it may not ever happen), we hand
         * off the JELocalTransaction to the JEConnection and forget about it
         * in the ManagedConnection.
         */
        if (conn == null) {
            savedLT = new JELocalTransaction(env, savedTransConfig, this);
            return savedLT;
        }

        JELocalTransaction lt = conn.getLocalTransaction();
        if (lt == null) {
            if (savedLT == null) {
                lt = new JELocalTransaction(env, savedTransConfig, this);
            } else {
                lt = savedLT;
            }
            conn.setLocalTransaction(lt);
            savedLT = null;
        }
        return lt;
    }

    public XAResource getXAResource() {
        return env;
    }

    public void associateConnection(Object connection) {
        conn = (JEConnection) connection;
        conn.setManagedConnection(this, savedLT);
        savedLT = null;
    }

    public void addConnectionEventListener(ConnectionEventListener listener) {
        listeners.add(listener);
    }

    public void
        removeConnectionEventListener(ConnectionEventListener listener) {

        listeners.remove(listener);
    }

    public ManagedConnectionMetaData getMetaData() {
        return new JEConnectionMetaData();
    }

    public void setLogWriter(PrintWriter out) {
    }

    public PrintWriter getLogWriter() {
        return null;
    }

    protected void close() {
        ConnectionEvent connEvent =
            new ConnectionEvent(this, ConnectionEvent.CONNECTION_CLOSED);
        connEvent.setConnectionHandle(conn);
        sendConnectionEvent(connEvent);
    }

    protected void sendConnectionEvent(ConnectionEvent connEvent) {
        for (int i = listeners.size() - 1; i >= 0; i--) {
            ConnectionEventListener listener =
                listeners.get(i);
            if (connEvent.getId() == ConnectionEvent.CONNECTION_CLOSED) {
                listener.connectionClosed(connEvent);
            } else if (connEvent.getId() ==
                       ConnectionEvent.CONNECTION_ERROR_OCCURRED) {
                listener.connectionErrorOccurred(connEvent);
            } else if (connEvent.getId() ==
                       ConnectionEvent.LOCAL_TRANSACTION_STARTED) {
                listener.localTransactionStarted(connEvent);
            } else if (connEvent.getId() ==
                       ConnectionEvent.LOCAL_TRANSACTION_COMMITTED) {
                listener.localTransactionCommitted(connEvent);
            } else if (connEvent.getId() ==
                       ConnectionEvent.LOCAL_TRANSACTION_ROLLEDBACK) {
                listener.localTransactionRolledback(connEvent);
            }
        }
    }

    public void destroy()
        throws ResourceException {

        try {
            cleanupDatabaseHandleCache(roDatabaseHandleCache);
            cleanupDatabaseHandleCache(rwDatabaseHandleCache);
            cleanupDatabaseHandleCache(roSecondaryDatabaseHandleCache);
            cleanupDatabaseHandleCache(rwSecondaryDatabaseHandleCache);
            env.close();
        } catch (DatabaseException DE) {
            throw new ResourceException(DE.toString());
        }
    }

    public void cleanup() {
    }

    void removeDatabase(String dbName)
        throws DatabaseException {

        removeDatabaseFromCache(roDatabaseHandleCache, dbName);
        removeDatabaseFromCache(rwDatabaseHandleCache, dbName);
        removeDatabaseFromCache(roSecondaryDatabaseHandleCache, dbName);
        removeDatabaseFromCache(rwSecondaryDatabaseHandleCache, dbName);
        env.removeDatabase(null, dbName);
    }

    long truncateDatabase(String dbName, boolean returnCount)
        throws DatabaseException {

        removeDatabaseFromCache(roDatabaseHandleCache, dbName);
        removeDatabaseFromCache(rwDatabaseHandleCache, dbName);
        removeDatabaseFromCache(roSecondaryDatabaseHandleCache, dbName);
        removeDatabaseFromCache(rwSecondaryDatabaseHandleCache, dbName);
        return env.truncateDatabase(null, dbName, returnCount);
    }

    Database openDatabase(String dbName, DatabaseConfig config)
        throws DatabaseException {

        if (config.getReadOnly()) {
            synchronized (roDatabaseHandleCache) {
                return openDatabaseInternal
                    (roDatabaseHandleCache, dbName, config);
            }
        } else {
            synchronized (rwDatabaseHandleCache) {
                return openDatabaseInternal
                    (rwDatabaseHandleCache, dbName, config);
            }
        }
    }

    SecondaryDatabase openSecondaryDatabase(String dbName,
                                            Database primaryDatabase,
                                            SecondaryConfig config)
        throws DatabaseException {

        if (config.getReadOnly()) {
            synchronized (roSecondaryDatabaseHandleCache) {
                return openSecondaryDatabaseInternal
                    (roSecondaryDatabaseHandleCache, dbName,
                     primaryDatabase, config);
            }
        } else {
            synchronized (rwSecondaryDatabaseHandleCache) {
                return openSecondaryDatabaseInternal
                    (rwSecondaryDatabaseHandleCache, dbName,
                     primaryDatabase, config);
            }
        }
    }

    private Database
        openDatabaseInternal(Map<String,Database> databaseHandleCache,
                             String dbName,
                             DatabaseConfig config)
        throws DatabaseException {

        Database db;
        if (config.getExclusiveCreate()) {
            db = env.openDatabase(null, dbName, config);
            databaseHandleCache.put(dbName, db);
        } else {
            db = databaseHandleCache.get(dbName);
            if (db == null) {
                db = env.openDatabase(null, dbName, config);
                databaseHandleCache.put(dbName, db);
            } else {
                DbInternal.validate(config, db.getConfig());
            }
        }
        return db;
    }

    private SecondaryDatabase
        openSecondaryDatabaseInternal(Map<String,Database> databaseHandleCache,
                                      String dbName,
                                      Database primaryDatabase,
                                      SecondaryConfig config)
        throws DatabaseException {

        SecondaryDatabase db;
        if (config.getExclusiveCreate()) {
            db = env.openSecondaryDatabase(null, dbName,
                                           primaryDatabase, config);
            databaseHandleCache.put(dbName, db);
        } else {
            db = (SecondaryDatabase) databaseHandleCache.get(dbName);
            if (db == null) {
                db = env.openSecondaryDatabase(null, dbName,
                                               primaryDatabase, config);
                databaseHandleCache.put(dbName, db);
            } else {
                DbInternal.validate(config, db.getConfig());
            }
        }
        return db;
    }

    private void removeDatabaseFromCache(Map<String,Database> cache,
                                         String dbName)
        throws DatabaseException {

        synchronized (cache) {
            Database db = cache.get(dbName);
            if (db == null) {
                return;
            }
            db.close();
            cache.remove(dbName);
        }
    }

    private void cleanupDatabaseHandleCache(Map<String,Database> cache)
        throws DatabaseException {

        synchronized (cache) {
            Iterator<Database> iter = cache.values().iterator();

            while (iter.hasNext()) {
                Database db = iter.next();
                db.close();
            }
        }
    }
}
