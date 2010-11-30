/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.io.Serializable;

/**
 * Statistics for a single database.
 */
public abstract class DatabaseStats implements Serializable {
    private static final long serialVersionUID = 1L;

    // no public constructor
    protected DatabaseStats() {}
}
