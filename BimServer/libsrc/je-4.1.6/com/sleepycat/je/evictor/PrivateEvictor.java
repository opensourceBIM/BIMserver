/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.evictor;

import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * An evictor for a private cache.
 */
public class PrivateEvictor extends Evictor {

    public PrivateEvictor(EnvironmentImpl envImpl) {
        super(envImpl);
    }

    @Override
    TargetSelector makeSelector() {
        return new PrivateSelector(envImpl);
    }
}
