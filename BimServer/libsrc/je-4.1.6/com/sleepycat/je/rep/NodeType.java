/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep;

/**
 * The different types of nodes that can be in a replication group.
 */
public enum NodeType {

    /**
     * A node that passively listens for the results of elections, but does not
     * participate in them. It does not have a replicated environment
     * associated with it.
     * @see com.sleepycat.je.rep.monitor.Monitor
     */
    MONITOR,

    /**
     * A full fledged member of the replication group with an associated
     * replicated environment that can serve as both a Master and a Replica.
     */
    ELECTABLE;
}
