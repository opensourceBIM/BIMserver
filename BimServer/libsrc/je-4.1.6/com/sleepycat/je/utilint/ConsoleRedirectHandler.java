/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.util.logging.LogRecord;

import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Redirects logging messages to the owning environment's console handler, so
 * that messages can be prefixed with an environment name.
 * 
 * In rare cases, this ConsoleHandler may be used to actually publish on its
 * own.
 */
public class ConsoleRedirectHandler extends java.util.logging.ConsoleHandler {

    public ConsoleRedirectHandler() {
        super();
    }

    @Override
    public void publish(LogRecord record) {
        EnvironmentImpl envImpl = 
            LoggerUtils.envMap.get(Thread.currentThread());

        /* 
         * If the caller forgets to set and release the envImpl so there is no
         * envImpl, log to the generic ConsoleHandler without an identifying
         * prefix. That way, we get a message, but don't risk a
         * NullPoniterException.
         */
        if (envImpl == null) {
            super.publish(record);
            return;
        }
        envImpl.getConsoleHandler().publish(record);
    }
}
