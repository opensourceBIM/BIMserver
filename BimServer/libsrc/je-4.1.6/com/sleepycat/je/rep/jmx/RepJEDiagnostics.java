/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.jmx;

import com.sleepycat.je.Environment;
import com.sleepycat.je.jmx.JEDiagnostics;

/*
 * This concrete MBean is a logging monitor on a replicated JE Environment.
 *
 * It not only has the same attributes and operations as the standalone 
 * JEDiagnostics, but also has some specific replicated related operations.
 */
public class RepJEDiagnostics extends JEDiagnostics {
    protected RepJEDiagnostics(Environment env) {
        super(env);
    }

    public RepJEDiagnostics() {
        super();
    }

    @Override
    protected void initClassFields() {
        currentClass = RepJEDiagnostics.class;
        className = "RepJEDiagnostics";
        DESCRIPTION = "Logging Monitor on an open replicated Environment.";
    }

    @Override
    protected void doRegisterMBean(Environment useEnv)
        throws Exception {

        server.registerMBean(new RepJEDiagnostics(useEnv), jeName);
    }
}
