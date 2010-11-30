/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.txn.Locker;

/**
 * Base class for exceptions thrown when a write operation fails because of a
 * secondary constraint.  See subclasses for more information.
 *
 * <p>The {@link Transaction} handle is invalidated as a result of this
 * exception.</p>
 *
 * @see <a href="SecondaryDatabase.html#transactions">Special considerations
 * for using Secondary Databases with and without Transactions</a>
 *
 * @since 4.0
 */
public abstract class SecondaryConstraintException
    extends SecondaryReferenceException {

    private static final long serialVersionUID = 1L;

    /** 
     * For internal use only.
     * @hidden 
     */
    public SecondaryConstraintException(Locker locker,
                                        String message,
                                        String secDbName,
                                        DatabaseEntry secKey,
                                        DatabaseEntry priKey) {
        super(locker, message, secDbName, secKey, priKey);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    SecondaryConstraintException(String message,
                                 SecondaryReferenceException cause) {
        super(message, cause);
    }
}
