/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;

/**
 * JE instances of java.util.logging.Logger are configured to use this
 * implementation of java.util.logging.MemoryHandler. By default, the handler's
 * level is {@link Level#INFO}. To enable the memory handler, use the standard
 * java.util.logging configuration to set the desired level:
 * <pre>
 * com.sleepycat.je.util.MemoryHandler.level=WARNING
 * </pre>
 * 
 * This handler is mainly meant for diagnostic use.
 */
public class MemoryHandler extends java.util.logging.MemoryHandler {
    
    /* 
     * Using a JE specific handler lets us enable and disable output for the
     * entire library, and specify an environment specific format.
     */
    public MemoryHandler(Handler target, 
                         int size, 
                         Level pushLevel,
                         Formatter formatter) {
        super(target, size, pushLevel);

        /* Messages may be formatted with an environment specific tag. */
        setFormatter(formatter);

        /* The default level is INFO. */
        LogManager mgr = LogManager.getLogManager();
        String levelName = this.getClass().getName() + ".level";
        String levelProperty = mgr.getProperty(levelName);
        if (levelProperty == null) {
            setLevel(Level.INFO);
        }
    }
}

