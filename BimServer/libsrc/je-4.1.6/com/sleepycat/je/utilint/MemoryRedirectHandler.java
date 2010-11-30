/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Redirects logging messages to the the owning environment's memory handler,
 * so that messages can be prefixed with an environment name and collected in
 * an per-environment memory buffer.
 */
public class MemoryRedirectHandler extends Handler {

    public MemoryRedirectHandler() {
        /* 
         * No need to invoke super(), this is only a pass-thru class which will
         * not actually do any logging.
         */
    }

    @Override
    public void publish(LogRecord record) {
        EnvironmentImpl envImpl = 
            LoggerUtils.envMap.get(Thread.currentThread());

        /* 
         * Prefer to lose logging output, rather than risk a
         * NullPointerException if the caller forgets to set and release state.
         */
        if (envImpl == null) {
            return;
        }

        envImpl.getMemoryHandler().publish(record);
    }

    @Override
    public void close() throws SecurityException {
        /* nothing to do. */
        
    }

    @Override
    public void flush() {
        /* nothing to do. */
    }
}
