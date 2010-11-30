/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * Thrown by {@link Cursor#putCurrent Cursor.putCurrent} if the old and new
 * data are not equal according to the configured duplicate comparator or
 * default comparator.
 *
 * <p>If the old and new data are unequal according to the comparator, this
 * would change the sort order of the record, which would change the cursor
 * position, and this is not allowed.  To change the sort order of a record,
 * delete it and then re-insert it.</p>
 *
 * <p>The {@link Transaction} handle is <em>not</em> invalidated as a result of
 * this exception.</p>
 *
 * @since 4.0
 */
public class DuplicateDataException extends OperationFailureException {

    private static final long serialVersionUID = 1;

    /** 
     * For internal use only.
     * @hidden 
     */
    public DuplicateDataException(String message) {
        super(null /*locker*/, false /*abortOnly*/, message, null /*cause*/);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    private DuplicateDataException(String message,
                                   DuplicateDataException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden 
     */
    @Override
    public OperationFailureException wrapSelf(String msg) {
        return new DuplicateDataException(msg, this);
    }
}
