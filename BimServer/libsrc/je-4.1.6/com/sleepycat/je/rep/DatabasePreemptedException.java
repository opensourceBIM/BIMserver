/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import com.sleepycat.je.Database;
import com.sleepycat.je.OperationFailureException;

/**
 * Thrown when attempting to use a Database handle that was forcibly closed by
 * replication.  This exception only occurs in a replicated environment and
 * normally only occurs on a Replica node.  In the case of a DPL schema upgrade
 * where an entity class or secondary key is renamed, it may also occur on a
 * Master node, as described below.
 *
 * <p>This exception occurs when accessing a database or store and one of the
 * following methods was recently executed on the master node and then replayed
 * on a replica node:
 * {@link com.sleepycat.je.Environment#truncateDatabase truncateDatabase},
 * {@link com.sleepycat.je.Environment#removeDatabase removeDatabase} and
 * {@link com.sleepycat.je.Environment#renameDatabase renameDatabase}.</p>
 *
 * <p>When using the {@link com.sleepycat.persist DPL}, this occurs only in two
 * circumstances:</p>
 * <ol>
 * <li>This exception is thrown on a Replica node when the {@link
 * com.sleepycat.persist.EntityStore#truncateClass truncateClass} method has
 * been called on the Master node.</li>
 * <li>This exception is thrown on a Replica or Master node when an entity
 * class or secondary key has been renamed and the application has been
 * upgraded. See
 * <a href="../../persist/evolve/package-summary.html#repUpgrade">Upgrading
 * a Replication Group</a>.</li>
 * </ol>
 *
 * <p>When this exception occurs, the application must close any open cursors
 * and abort any open transactions that are using the database or store, and
 * then close the database or store handle.  If the application wishes, it may
 * then reopen the database (if it still exists) or store.</p>
 *
 * <p>Some applications may wish to coordinate the Master and Replica sites to
 * prevent a Replica from accessing a database that is being truncated, removed
 * or renamed, and thereby prevent this exception.  Such coordination is not
 * directly supported by JE.  The DatabasePreemptedException is provided to
 * allow an application to handle database truncation, removal and renaming
 * without such coordination between nodes.</p>
 *
 * <p>The {@link com.sleepycat.je.Transaction} handle is <em>not</em>
 * invalidated as a result of this exception.</p>
 *
 * @since 4.0
 */
public class DatabasePreemptedException extends OperationFailureException {

    private static final long serialVersionUID = 1;

    private final String dbName;
    private final Database dbHandle;

    /** 
     * For internal use only.
     * @hidden 
     */
    public DatabasePreemptedException(final String message,
                                      final String dbName,
                                      final Database dbHandle) {
        super(null /*locker*/, false /*abortOnly*/, message, null /*cause*/);
        this.dbName = dbName;
        this.dbHandle = dbHandle;
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    private DatabasePreemptedException(String message,
                                       DatabasePreemptedException cause) {
        super(message, cause);
        dbName = cause.dbName;
        dbHandle = cause.dbHandle;
    }

    /**
     * Returns the database handle that was forcibly closed.
     */
    public Database getDatabase() {
        return dbHandle;
    }

    /**
     * Returns the name of the database that was forcibly closed.
     */
    public String getDatabaseName() {
        return dbName;
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new DatabasePreemptedException(msg, this);
    }
}
