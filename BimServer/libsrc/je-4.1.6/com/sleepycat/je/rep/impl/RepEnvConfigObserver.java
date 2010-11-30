/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2000-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.rep.ReplicationMutableConfig;

/**
 * Implemented by observers of mutable rep config changes.
 */
public interface RepEnvConfigObserver {

    /**
     * Notifies the observer that one or more mutable rep properties have been
     * changed.
     */
    void repEnvConfigUpdate(RepConfigManager configMgr,
                            ReplicationMutableConfig newConfig)
        throws DatabaseException;
}
