/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.recovery;

import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.entry.LogEntry;

/**
 * The VLSNRecoveryProxy is a handle for invoking VLSN tracking at recovery time.
 */
public interface VLSNRecoveryProxy {

    public void trackMapping(long lsn, 
                             LogEntryHeader currentEntryHeader,
                             LogEntry logEntry);
}
