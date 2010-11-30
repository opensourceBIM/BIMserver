/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.txn.Locker;

/**
 * Thrown when an attempt to write a primary database record would insert a
 * secondary record with a duplicate key, for secondaries that represent
 * one-to-one and one-to-many relationships.
 *
 * <p>When using the base API ({@code com.sleepycat.je}), this can occur when a
 * {@link SecondaryDatabase} is not configured to allow duplicate keys (which
 * is the default, see {@link DatabaseConfig#setSortedDuplicates}). This
 * implies the use of a one-to-one or one-to-many relationship.</p>
 *
 * <p>When using the DPL ({@code com.sleepycat.persist}), this can occur when a
 * {@link com.sleepycat.persist.model.SecondaryKey} is defined with a {@link
 * com.sleepycat.persist.model.Relationship#ONE_TO_ONE} or {@link
 * com.sleepycat.persist.model.Relationship#ONE_TO_MANY} relationship.</p>
 *
 * <p>The {@link Transaction} handle is invalidated as a result of this
 * exception.</p>
 *
 * @see <a href="SecondaryDatabase.html#transactions">Special considerations
 * for using Secondary Databases with and without Transactions</a>
 *
 * @since 4.0
 */
public class UniqueConstraintException extends SecondaryConstraintException {

    private static final long serialVersionUID = 1;

    /** 
     * For internal use only.
     * @hidden 
     */
    public UniqueConstraintException(Locker locker,
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
    private UniqueConstraintException(String message,
                                      UniqueConstraintException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new UniqueConstraintException(msg, this);
    }
}
