/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.txn.Locker;

/**
 * Thrown when an attempt is made to delete a key from a foreign key database,
 * when that key is referenced by a secondary database, and the secondary is
 * configured to cause an abort in this situation.
 *
 * <p>When using the base API ({@code com.sleepycat.je}), this can occur when a
 * {@link SecondaryDatabase} is configured to be associated with a foreign key
 * database (see {@link SecondaryConfig#setForeignKeyDatabase}), and is also
 * configured with the {@link ForeignKeyDeleteAction#ABORT} delete action (see
 * {@link SecondaryConfig#setForeignKeyDeleteAction}).  Note that {@code ABORT}
 * is the default setting.</p>
 *
 * <p>When using the DPL ({@code com.sleepycat.persist}), this can occur when a
 * {@link com.sleepycat.persist.model.SecondaryKey} is defined with a {@link
 * com.sleepycat.persist.model.SecondaryKey#relatedEntity}, and {@link
 * com.sleepycat.persist.model.SecondaryKey#onRelatedEntityDelete} is {@link
 * com.sleepycat.persist.model.DeleteAction#ABORT} (which is the default).</p>
 *
 * <p>The {@link Transaction} handle is invalidated as a result of this
 * exception.</p>
 *
 * @see <a href="SecondaryDatabase.html#transactions">Special considerations
 * for using Secondary Databases with and without Transactions</a>
 *
 * @since 4.0
 */
public class DeleteConstraintException extends SecondaryConstraintException {

    private static final long serialVersionUID = 1;

    /** 
     * For internal use only.
     * @hidden 
     */
    public DeleteConstraintException(Locker locker,
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
    private DeleteConstraintException(String message,
                                      DeleteConstraintException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new DeleteConstraintException(msg, this);
    }
}
