/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jca.ra;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.XAEnvironment;

public class JELocalTransaction
    implements javax.resource.cci.LocalTransaction,
               javax.resource.spi.LocalTransaction {

    private static boolean DEBUG = false;

    private transient XAEnvironment env;
    private transient TransactionConfig transConfig;
    private transient JEManagedConnection mgdConn;

    JELocalTransaction(XAEnvironment env,
                       TransactionConfig transConfig,
                       JEManagedConnection mgdConn) {
        this.env = env;
        this.transConfig = transConfig;
        this.mgdConn = mgdConn;
    }

    public Transaction getTransaction()
        throws DatabaseException {

        return env.getThreadTransaction();
    }

    protected XAEnvironment getEnv() {
        return env;
    }

    private void checkEnv(String methodName)
        throws ResourceException {

        if (env == null) {
            throw new ResourceException("env is null in " + methodName);
        }
    }

    /*
     * Methods for LocalTransaction.
     */

    public void begin()
        throws ResourceException {

        checkEnv("begin");
        long id = -1;
        try {
            Transaction txn = env.beginTransaction(null, transConfig);
            env.setThreadTransaction(txn);
            id = txn.getId();
        } catch (DatabaseException DE) {
            throw new ResourceException("During begin: " + DE.toString());
        }

        ConnectionEvent connEvent = new ConnectionEvent
            (mgdConn, ConnectionEvent.LOCAL_TRANSACTION_STARTED);
        connEvent.setConnectionHandle(mgdConn);
        mgdConn.sendConnectionEvent(connEvent);

        if (DEBUG) {
            System.out.println("JELocalTransaction.begin " + id);
        }
    }

    public void commit()
        throws ResourceException {

        checkEnv("commit");
        try {
            env.getThreadTransaction().commit();
        } catch (DatabaseException DE) {
            ResourceException ret = new ResourceException(DE.toString());
            ret.initCause(DE);
            throw ret;
        } finally {
            env.setThreadTransaction(null);
        }

        ConnectionEvent connEvent = new ConnectionEvent
            (mgdConn, ConnectionEvent.LOCAL_TRANSACTION_COMMITTED);
        connEvent.setConnectionHandle(mgdConn);
        mgdConn.sendConnectionEvent(connEvent);

        if (DEBUG) {
            System.out.println("JELocalTransaction.commit");
        }
    }

    public void rollback()
        throws ResourceException {

        checkEnv("rollback");
        try {
            env.getThreadTransaction().abort();
        } catch (DatabaseException DE) {
            ResourceException ret = new ResourceException(DE.toString());
            ret.initCause(DE);
            throw ret;
        } finally {
            env.setThreadTransaction(null);
        }

        ConnectionEvent connEvent = new ConnectionEvent
            (mgdConn, ConnectionEvent.LOCAL_TRANSACTION_ROLLEDBACK);
        connEvent.setConnectionHandle(mgdConn);
        mgdConn.sendConnectionEvent(connEvent);

        if (DEBUG) {
            System.out.println("JELocalTransaction.rollback");
        }
    }
}
