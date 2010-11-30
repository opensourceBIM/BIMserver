/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.txn.Locker;

/**
 * Base class for exceptions thrown when a read or write operation fails
 * because of a secondary constraint or integrity problem.  Provides accessors
 * for getting further information about the database and keys involved in the
 * failure.  See subclasses for more information.
 *
 * <p>The {@link Transaction} handle is invalidated as a result of this
 * exception.</p>
 *
 * @see <a href="SecondaryDatabase.html#transactions">Special considerations
 * for using Secondary Databases with and without Transactions</a>
 *
 * @since 4.0
 */
public abstract class SecondaryReferenceException
    extends OperationFailureException {

    private static final long serialVersionUID = 1;

    private final String secDbName;
    private final DatabaseEntry secKey;
    private final DatabaseEntry priKey;

    /** 
     * For internal use only.
     * @hidden 
     */
    public SecondaryReferenceException(Locker locker,
                                       String message,
                                       String secDbName,
                                       DatabaseEntry secKey,
                                       DatabaseEntry priKey) {
        super(locker, true /*abortOnly*/, message, null /*cause*/);
        this.secDbName = secDbName;
        this.secKey = secKey;
        this.priKey = priKey;
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    SecondaryReferenceException(String message,
                                SecondaryReferenceException cause) {
        super(message, cause);
        this.secDbName = cause.secDbName;
        this.secKey = cause.secKey;
        this.priKey = cause.priKey;
    }

    /**
     * Returns the name of the secondary database being access during the
     * failure.
     */
    public String getSecondaryDatabaseName() {
        return secDbName;
    }

    /**
     * Returns the secondary key being access during the failure.
     */
    public DatabaseEntry getSecondaryKey() {
        return secKey;
    }

    /**
     * Returns the primary key being access during the failure.
     */
    public DatabaseEntry getPrimaryKey() {
        return priKey;
    }
}
