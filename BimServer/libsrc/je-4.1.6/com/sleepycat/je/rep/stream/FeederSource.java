/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.stream;

import java.io.IOException;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.utilint.VLSN;

/**
 * Provides the next log record, blocking if one is not available. It
 * encapsulates the source of the Log records, which can be a real Master or a
 * Replica in a Replica chain that is replaying log records it received from
 * some other source.
 */
public interface FeederSource {

    public void init(VLSN startVLSN) 
        throws DatabaseException, IOException, InterruptedException;

    public OutputWireRecord getWireRecord(VLSN vlsn, int waitTime)
        throws DatabaseException, InterruptedException, IOException;

    public String dumpState();
}
