/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log.entry;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.tree.BINDelta;
import com.sleepycat.je.tree.IN;

/**
 * A BINDeltaLogEntry knows how to create a whole BIN from a delta entry.
 */
public class BINDeltaLogEntry extends SingleItemEntry
    implements INContainingEntry {

    /**
     * @param logClass
     */
    public BINDeltaLogEntry(Class<BINDelta> logClass) {
        super(logClass);
    }

    /*
     * @see com.sleepycat.je.log.entry.INContainingEntry#getIN()
     */
    public IN getIN(EnvironmentImpl env)
            throws DatabaseException {

        BINDelta delta = (BINDelta) getMainItem();
        return delta.reconstituteBIN(env);
    }

    /*
     * @see com.sleepycat.je.log.entry.INContainingEntry#getDbId()
     */
    public DatabaseId getDbId() {

        BINDelta delta = (BINDelta) getMainItem();
        return delta.getDbId();        
    }

    /**
     * @return the LSN that represents this IN. For this BINDelta, it's
     * the last full version.
     */
    public long getLsnOfIN(long lastReadLsn) {

        BINDelta delta = (BINDelta) getMainItem();
        return delta.getLastFullLsn();
    }
}
