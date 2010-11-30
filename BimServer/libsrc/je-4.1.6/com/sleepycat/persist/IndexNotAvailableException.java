/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.persist;

import com.sleepycat.je.OperationFailureException;

/**
 * Thrown by the {@link EntityStore#getPrimaryIndex getPrimaryIndex}, {@link
 * EntityStore#getSecondaryIndex getSecondaryIndex} and {@link
 * EntityStore#getSubclassIndex getSubclassIndex} when an index has not yet
 * been created.
 *
 * This exception can be thrown in two circumstances.
 * <ol>
 *
 * <li>It can be thrown in a replicated environment when the Replica has been
 * upgraded to contain new persistent classes that define a new primary or
 * secondary index, but the Master has not yet been upgraded.  The index does
 * not exist because the Master has not yet been upgraded with the new classes.
 * If the application is aware of when the Master is upgraded, it can wait for
 * that to occur and then open the index. Or, the application may repeatedly
 * try to open the index until it becomes available.</li>
 *
 * <li>It can be thrown when opening an environment read-only with new
 * persistent classes that define a new primary or secondary index.  The index
 * does not exist because the environment has not yet been opened read-write
 * with the new classes.  When the index is created by a read-write
 * application, the read-only application must close and re-open the
 * environment in order to open the new index.</li>
 *
 * </ol>
 *
 * @author Mark Hayes
 */
public class IndexNotAvailableException extends OperationFailureException {

    private static final long serialVersionUID = 1L;

    /** 
     * For internal use only.
     * @hidden 
     */
    public IndexNotAvailableException(String message) {
        super(null /*locker*/, false /*abortOnly*/, message, null /*cause*/);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    private IndexNotAvailableException(String message,
                                   OperationFailureException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new IndexNotAvailableException(msg, this);
    }
}
