/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.evictor;

import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Create an evictor for a shared cache.
 */
public class SharedEvictor extends Evictor {

    public SharedEvictor(EnvironmentImpl envImpl) {
        super(envImpl);
    }

    @Override
    TargetSelector makeSelector() {
        return new SharedSelector(envImpl);
    }
}
