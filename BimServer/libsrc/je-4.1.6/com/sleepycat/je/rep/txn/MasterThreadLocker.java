/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.txn;

import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.txn.ThreadLocker;

/**
 * A MasterThreadLocker is used with a user initiated non-transactional
 * operation on a Master.  The only purpose of this class is to enforce the
 * use of replication-defined lockers for replicated operations by defining
 * the isReplicationDefined method.
 */
public class MasterThreadLocker extends ThreadLocker {

    public MasterThreadLocker(final RepImpl repImpl) {
        super(repImpl);
    }

    @Override
    public boolean isReplicationDefined() {
        return true;
    }
}
