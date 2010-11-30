/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jca.ra;

import javax.resource.ResourceException;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.SecondaryConfig;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.je.Transaction;

/**
 * A JEConnection provides access to JE services. See
 * &lt;JEHOME&gt;/examples/jca/HOWTO-**.txt and
 * &lt;JEHOME&gt;/examples/jca/simple/SimpleBean.java for more information on
 * how to build the resource adaptor and use a JEConnection.
 */
public class JEConnection {

    private JEManagedConnection mc;
    private JELocalTransaction txn;

    public JEConnection(JEManagedConnection mc) {
        this.mc = mc;
    }

    protected void setManagedConnection(JEManagedConnection mc,
                                        JELocalTransaction lt) {
        this.mc = mc;
        if (txn == null) {
            txn = lt;
        }
    }

    JELocalTransaction getLocalTransaction() {
        return txn;
    }

    void setLocalTransaction(JELocalTransaction txn) {
        this.txn = txn;
    }

    public Environment getEnvironment() {
        return mc.getEnvironment();
    }

    public Database openDatabase(String name, DatabaseConfig config)
        throws DatabaseException {

        return mc.openDatabase(name, config);
    }

    public SecondaryDatabase openSecondaryDatabase(String name,
                                                   Database primaryDatabase,
                                                   SecondaryConfig config)
        throws DatabaseException {

        return mc.openSecondaryDatabase(name, primaryDatabase, config);
    }

    public void removeDatabase(String databaseName)
        throws DatabaseException {

        mc.removeDatabase(databaseName);
    }

    public long truncateDatabase(String databaseName, boolean returnCount)
        throws DatabaseException {

        return mc.truncateDatabase(databaseName, returnCount);
    }

    public Transaction getTransaction()
        throws ResourceException {

        if (txn == null) {
            return null;
        }

        try {
            return txn.getTransaction();
        } catch (DatabaseException DE) {
            ResourceException ret = new ResourceException(DE.toString());
            ret.initCause(DE);
            throw ret;
        }
    }

    public void close() {
        mc.close();
    }
}
