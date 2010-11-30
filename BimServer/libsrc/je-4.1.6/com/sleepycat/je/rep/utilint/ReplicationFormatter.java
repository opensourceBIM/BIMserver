/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.utilint.TracerFormatter;

/**
 * Formatter for replication log messages
 */
public class ReplicationFormatter extends TracerFormatter {
    private final NameIdPair nameIdPair;

    public ReplicationFormatter(NameIdPair nameIdPair) {
        super();
        this.nameIdPair = nameIdPair;
    }

    @Override
    protected void appendEnvironmentName(StringBuilder sb) {
        sb.append(" [" + nameIdPair.getName() + "] ");
    }
}
