/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import com.sleepycat.je.OperationFailureException;

/**
 * Thrown when one or more log files are modified (overwritten) as the result 
 * of a replication operation. This occurs when a replication operation must
 * change existing data in a log file in order to synchronize with other nodes
 * in a replication group. Any previously copied log files may be invalid and 
 * should be discarded.
 *
 * <p>This exception is thrown by {@link
 * com.sleepycat.je.util.DbBackup}. Backups and similar operations that copy
 * log files should discard any copied files when this exception occurs, and
 * may retry the operation at a later time. The time interval during which
 * backups are not possible will be fairly short (less than a minute).</p>
 *
 * <p>Note that this exception is never thrown in a standalone (non-replicated)
 * environment.</p>
 *
 * <p>The {@link com.sleepycat.je.Transaction} handle is <em>not</em>
 * invalidated as a result of this exception.</p>
 *
 * @since 4.0
 */
public class LogOverwriteException extends OperationFailureException {

    private static final long serialVersionUID = 19238344223L;

    /**
     * For internal use only.
     * @hidden
     */
    public LogOverwriteException(String message) {
        super(null /*locker*/, false /*abortOnly*/, message, null /*cause*/);
    }

    /**
     * For internal use only.
     * @hidden
     */
    private LogOverwriteException(String message,
                                  LogOverwriteException cause) {
        super(message, cause);
    }

    /** 
     * For internal use only.
     * @hidden
     */
    @Override
    public OperationFailureException wrapSelf(String message) {
        return new LogOverwriteException(message, this);
    }
}
