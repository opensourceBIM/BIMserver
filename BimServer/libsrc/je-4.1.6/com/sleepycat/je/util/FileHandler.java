/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.io.IOException;
import java.util.logging.Formatter;
import java.util.logging.Level;

import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * JE instances of java.util.logging.Logger are configured to use this
 * implementation of java.util.logging.FileHandler. By default, the handler's
 * level is {@link Level#INFO} To enable the console output, use the standard
 * java.util.logging.LogManager configuration to set the desired level:
 * <pre>
 * com.sleepycat.je.util.FileHandler.level=INFO
 * </pre>
 * <p>
 * The default destination for this output is a circular set of files named
 * &lt;environmentHome&gt;/je.info.# The logging file size can be configured
 * with standard java.util.logging.FileHandler configuration.
 * <p>
 * JE augments the java.util.logging API with a JE environment parameter for
 * setting handler levels. This is described in greater detail in 
 * {@link <a href="{@docRoot}/../GettingStartedGuide/managelogging.html">
 * Chapter 12.Administering Berkeley DB Java Edition Applications</a>}
 *
 * @see <a href="{@docRoot}/../GettingStartedGuide/managelogging.html">
 * Chapter 12. Logging</a> 
 * @see <a href="{@docRoot}/../traceLogging.html">Using JE Trace Logging</a> 
 */
public class FileHandler extends java.util.logging.FileHandler {
    
    /* 
     * Using a JE specific handler lets us enable and disable output for the
     * entire library, and specify an environment specific format and level
     * default.
     */
    public FileHandler(String pattern, 
                       int limit, 
                       int count,
                       Formatter formatter, 
                       EnvironmentImpl envImpl)
        throws SecurityException, IOException {

        super(pattern, limit, count, true /* append */);

        /* Messages may be formatted with an environment specific tag. */
        setFormatter(formatter);

        Level level = LoggerUtils.getHandlerLevel
            (envImpl.getConfigManager(), EnvironmentParams.JE_FILE_LEVEL,
             getClass().getName() + ".level");

        setLevel(level);
    }
}
