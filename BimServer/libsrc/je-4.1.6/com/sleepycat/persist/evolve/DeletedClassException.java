/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.persist.evolve;

import com.sleepycat.je.OperationFailureException;

/**
 * While reading from an index, an instance of a deleted class version was
 * encountered.
 *
 * @see com.sleepycat.persist.evolve Class Evolution
 * @author Mark Hayes
 */
public class DeletedClassException extends OperationFailureException {

    private static final long serialVersionUID = 518500929L;

    /** 
     * For internal use only.
     * @hidden 
     */
    public DeletedClassException(String message) {
        super(null /*locker*/, false /*abortOnly*/, message, null /*cause*/);
    }

    /* <!-- begin JE only --> */

    /** 
     * For internal use only.
     * @hidden 
     */
    private DeletedClassException(String message,
                                  OperationFailureException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new DeletedClassException(msg, this);
    }

    /* <!-- end JE only --> */
}
