/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.util.Collection;

import com.sleepycat.je.cleaner.PackedObsoleteInfo;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.txn.WriteLockInfo;

/**
 * Context parameters that apply to all logged items when multiple items are
 * logged in one log operation.  Passed to LogManager log methods and to
 * beforeLog and afterLog methods.
 */
public class LogContext {

    /**
     * Database of the node(s), or null if entry is not a node.  Used for per-
     * database utilization tracking.
     *
     * Set by caller.
     */
    public DatabaseImpl nodeDb = null;

    /**
     * Whether the log buffer(s) must be written to the file system.
     *
     * Set by caller.
     */
    public boolean flushRequired = false;

    /**
     * Whether a new log file must be created for containing the logged
     * item(s).
     *
     * Set by caller.
     */
    public boolean forceNewLogFile = false;

    /**
     * Whether an fsync must be performed after writing the item(s) to the log.
     *
     * Set by caller.
     */
    public boolean fsyncRequired = false;

    /**
     * Whether the write should be counted as background IO when throttling of
     * background IO is configured.
     *
     * Set by caller.
     */
    public boolean backgroundIO = false;

    /**
     * Set of obsolete LSNs which are counted when logging a commit entry.
     * This information includes the DatabaseImpl for each LSN, and the nodeDb
     * field does not apply.
     */
    public Collection<WriteLockInfo> obsoleteWriteLockInfo = null;

    /**
     * Sequence of packed obsolete info which is counted when logging a
     * non-provisional IN.  This information is for a single database, the
     * nodeDb.  The nodeDb is passed as a parameter to countObosoleteNode when
     * adding this information to the global tracker.
     */
    public PackedObsoleteInfo packedObsoleteInfo = null;

    /**
     * Whether it is possible that the previous version of this log
     * entry is already marked obsolete. In general, the latest version
     * of any IN or LN is alive, so that logging a new version requires making
     * the last version obsolete. Utilization tracking generally asserts
     * that this last version is not already obsolete.
     * 
     * When partial rollbacks are used, some of the original intermediate
     * versions may have been pruned away, leaving a current previous that
     * was already marked obsolete. For example, a transaction might have
     * done:
     * 
     * LNA (version 1)
     * LNA (version 2)
     *  -- now version 1 is obsolete
     *  -- if we do a partial rollback to version1, verison 2 is removed
     *  -- we start retransmitting
     * LNA (version 2) 
     *
     * When we log this LNA/version2, this previous LNA (version1) is 
     * already obsolete. obsoleteDupsAllowed supports this case.
     */
    public boolean obsoleteDupsAllowed = false;

    /* Fields used internally by log method. */
    boolean wakeupCleaner = false;
    int totalNewSize = 0;
}
