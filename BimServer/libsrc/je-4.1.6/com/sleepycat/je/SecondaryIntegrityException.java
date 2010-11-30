/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.txn.Locker;

/**
 * Thrown when an integrity problem is detected while accessing a secondary
 * database, including access to secondaries while writing to a primary
 * database. Secondary integrity problems are normally caused by the use of
 * secondaries without transactions.
 *
 * <p>The {@link Transaction} handle is invalidated as a result of this
 * exception.</p>
 *
 * <p>Some possible causes of a secondary integrity exception are listed
 * below.  Note that only the first item -- the use of a non-transactional
 * store -- is applicable when using the {@link com.sleepycat.persist DPL}.
 * All other items below do not apply to the use of the DPL, because the DPL
 * ensures that secondary databases are configured and managed correctly.</p>
 * <ol>
 *  <li>The use of non-transactional databases or stores can cause secondary
 *  corruption as described in <a
 *  href="SecondaryDatabase.html#transactions">Special considerations for using
 *  Secondary Databases with and without Transactions</a>.  Secondary databases
 *  and indexes should always be used in conjunction with transactional
 *  databases and stores.</li>
 *
 *  <li>Secondary corruption can be caused by an incorrectly implemented
 *  secondary key creator method, for example, one which uses mutable state
 *  information or is not properly synchronized.  When the DPL is not used, the
 *  application is responsible for correctly implementing the key creator.</li>
 *
 *  <li>Secondary corruption can be caused by failing to open a secondary
 *  database before writing to the primary database, by writing to a secondary
 *  database directly using a {@link Database} handle, or by truncating or
 *  removing primary database without also truncating or removing all secondary
 *  databases.  When the DPL is not used, the application is responsible for
 *  managing associated databases correctly.</p>
 * </ol>
 *
 * @since 4.0
 */
public class SecondaryIntegrityException extends SecondaryReferenceException {
    private static final long serialVersionUID = 1L;

    /** 
     * For internal use only.
     * @hidden 
     */
    public SecondaryIntegrityException(Locker locker,
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
    private SecondaryIntegrityException(String message,
                                        SecondaryIntegrityException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new SecondaryIntegrityException(msg, this);
    }
}
