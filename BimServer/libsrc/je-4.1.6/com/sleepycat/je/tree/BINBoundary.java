/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

/**
 * Contains information about the BIN returned by a search.
 */
public class BINBoundary {
    /** The last BIN was returned. */
    public boolean isLastBin;
    /** The first BIN was returned. */
    public boolean isFirstBin;
}
