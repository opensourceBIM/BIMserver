/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.util.logging.Formatter;
import java.util.logging.Level;

import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * JE instances of java.util.logging.Logger are configured to use this
 * implementation of java.util.logging.ConsoleHandler. By default, the
 * handler's level is {@link Level#OFF}. To enable the console output, use the
 * standard java.util.logging.LogManager configuration to set the desired
 * level:
 * <pre>
 * com.sleepycat.je.util.ConsoleHandler.level=ALL
 * </pre>
 * JE augments the java.util.logging API with a JE environment parameter for
 * setting handler levels. This is described in greater detail in 
 * {@link <a href="{@docRoot}/../GettingStartedGuide/managelogging.html">
 * Chapter 12.Administering Berkeley DB Java Edition Applications</a>}
 *
 * @see <a href="{@docRoot}/../GettingStartedGuide/managelogging.html">
 *     Chapter 12. Logging</a> 
 * @see <a href="{@docRoot}/../traceLogging.html">Using JE Trace Logging</a>
 */
public class ConsoleHandler extends java.util.logging.ConsoleHandler {
    
    /* 
     * Using a JE specific handler lets us enable and disable output for the
     * entire library, and specify an environment specific format.
     */
    public ConsoleHandler(Formatter formatter, EnvironmentImpl envImpl) {
        super();

        /* Messages may be formatted with an environment specific tag. */
        setFormatter(formatter);

        Level level = null;
        String propertyName = getClass().getName() + ".level";

        if (envImpl != null) {
            level = 
                LoggerUtils.getHandlerLevel(envImpl.getConfigManager(), 
                                            EnvironmentParams.JE_CONSOLE_LEVEL,
                                            propertyName);
        } else {
            /* If envImpl instance is null, level is decided by properties. */
            String levelProperty = LoggerUtils.getLoggerProperty(propertyName);
            if (levelProperty == null) {
                level = Level.OFF;
            } else {
                level = Level.parse(levelProperty);
            }
        }

        setLevel(level);
    }
}

