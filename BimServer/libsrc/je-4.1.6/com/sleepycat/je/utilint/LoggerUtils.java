/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.config.ConfigParam;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.Trace;

/**
 * <b>Logging Architecture</b>
 * ===========================
 * JE uses the java.util.logging package. The ability to dynamically specify
 * logging levels per component is important functionality for the system.
 * Logging output is directed to the console, to the je.info files, and in
 * special cases, to a MemoryHandler. The latter is meant for debugging and
 * field support.
 *
 * Logging output from multiple environments may end up going to the same
 * handler, either because a single process is executing multiple environments,
 * or because the output of multiple environments, such as a replication group,
 * is combined in a single display. Because of that, it's important for logging
 * output to be prefixed with an environment id so it can be distinguished by
 * environment.
 *
 * Loggers managed by java.util.logging.LogManager are supposed to be
 * maintained with a weak reference by the LogManager. In our experience,
 * loggers do not seem to be released, and seem to accumulate in
 * memory. Because of that, we create a single logger per JE class, rather than
 * a logger per class instance.
 *
 * The latter would be more convenient, because we wish to use environment
 * specific information, such as the environment name as a prefix, or the
 * location of the je.info file, when creating output. Restricting ourselves to
 * a single per-class logger requires that we keep the logger and its
 * associated handlers and formatters stateless, because the logger may be
 * shared by multiple environments. To compensate for that, we use per-thread
 * state to permit per-environment customization of the logging output (that is
 * the logging prefix) and file handler location. Because we've seen some
 * performance issues with ThreadLocals, we elected instead to maintain a
 * per-thread map to store state information needed by the logger.
 *
 * This state information is:
 *
 * - the enviroment impl from the envMap(from which one can obtain the prefix
 * and the console, file and memory handlers to use)
 *
 * - or if the environment impl is null because the component executes without
 * an environment, the output will go to only a console handler. It will use a
 * particular formatter to prefix the output with a useful id. This is obtained
 * from the formatter map.
 *
 *
 * With this scheme, a JE process has a maximum of
 *  - N loggers, where N is the number of classes which get loggers
 *  - 3 handlers * number of environments, because each environment creates
 * a Console, File and Memory handler.
 *
 * <b>How To Use Logging in a JE Class</b>
 * =======================================
 * Creating a Logger: There are three kinds of loggers that a class may chose
 * to use.
 *
 * 1. A class with a reference to EnvironmentImpl or RepImpl should use
 * LoggerUtils.getLogger(Class<?>) to create a logger which prefixes its output
 * with an environment id. When a logger is obtained this way, the logger
 * should not be used directly. Instead, LoggerUtils provides several methods
 * like this:
 * LoggerUtils.severe() equals to logger.severe
 * LoggerUtils.warning() equals to logger.warning
 *  etc
 * LoggerUtils.logMsg(Logger, EnvironmentImpl, Level, String) equals to
 * logger.log(Level, String)
 *
 * 2. A class without an EnvironmentImpl which still has some kind of custom
 * information to prepend to the logging output should use
 * LoggerUtils.getFormatterNeeded(). For example,
 * com.sleepycat.je.rep.monitor.Monitor does not have an environment, but does
 * have a NameIdPair, and it can insert that information via a specific
 * Formatter. When using this logger, the class must create and maintain a
 * Formatter instance to pass as a logging parameter. When using this flavor,
 * use:
 * LoggerUtils.logMsg(Logger, Formatter, Level, String) where the
 * formatter is the one created by the using class.
 *
 * 3. A logger without an EnvironmentImpl does not prefix or customize the
 * logging output, and uses LoggerUtils.getLoggerFixedPrefix to create a
 * logger. In this case, use the usual java.util.logging.Logger logging
 * methods.
 *
 * Note: there are some JE classes which only conditionally reference an
 * environment. In that case, the environment must also conditionally create
 * a logger, and then use the wrapper methods which use both an environmentImpl
 * and a formatter. For example:
 *
 *   if (envImpl != null) {
 *       logger = LoggerUtils.getLogger(getClass());
 *   } else {
 *       logger = LoggerUtils.getLoggerFormatterNeeded();
 *   }
 *   formatter = new Formatter(.....);
 *
 * Then use LoggerUtils.logMsg(Logger, EnvironmentImpl, Formatter, Level,
 * String) instead of Logger.log(Level, String)
 */
public class LoggerUtils {

    /*
     * Environment state to be used by a logger. Must be set and released
     * per logger call.
     */
    static Map<Thread, EnvironmentImpl> envMap =
        new ConcurrentHashMap<Thread, EnvironmentImpl>();

    /*
     * Formatter state to be used by a logger. Must be set and released
     * per logger call. Used by logging calls that do not have an available
     * environment.
     */
    static Map<Thread, Formatter> formatterMap =
        new ConcurrentHashMap<Thread, Formatter>();

    public static final String NO_ENV = ".noEnv";
    public static final String FIXED_PREFIX = ".fixedPrefix";
    private static final String PUSH_LEVEL = ".push.level";

    /**
     * Get a logger which is configured to use the shared console, memory, and
     * file handlers of an EnvironmentImpl and prefixes all messages with an
     * environment identifier. Use this for classes which have a reference
     * to an EnvironmentImpl (or RepImpl).
     *
     * When a logger is obtained this way, the logger should not be used
     * directly. Instead, the wrapper methods in LoggerUtils which put and
     * remove the environment from the envMap must be used, so that the logging
     * output can be properly prefixed and redirected to the correct
     * environment.
     */
    public static Logger getLogger(Class<?> cl) {

        Logger logger = createLogger(cl.getName());

        /* Check whether the logger already has existing handlers. */
        boolean hasConsoleHandler = false;
        boolean hasMemoryHandler = false;
        boolean hasFileHandler = false;

        /* 
         * [#18277] Add null check of logger.getHandlers() because the Resin
         * app server's implementation of logging can return null instead of an
         * empty array.
         */
        Handler[] handlers = logger.getHandlers();
        if (handlers != null) {
            for (Handler h : handlers) {

                /*
                 * Intentionally check for java.util.logging.ConsoleHandler
                 * rather than ConsoleRedirectHandler, because the loggers that
                 * do not have a custom prefix use the ConsoleHandler
                 * directly. Having ConsoleRedirectHandler extend
                 * ConsoleHandler lets us have a model where the user only have
                 * to set com.sleepycat.je.util.ConsoleHandler in their logging
                 * properties file.
                 */
                if (h instanceof java.util.logging.ConsoleHandler) {
                    hasConsoleHandler = true;
                }
                if (h instanceof MemoryRedirectHandler) {
                    hasMemoryHandler = true;
                }
                if (h instanceof FileRedirectHandler) {
                    hasFileHandler = true;
                }
            }
        }

        if (!hasConsoleHandler) {
            logger.addHandler(new ConsoleRedirectHandler());
        }

        if (!hasMemoryHandler) {
            logger.addHandler(new MemoryRedirectHandler());
        }

        if (!hasFileHandler) {
            logger.addHandler(new FileRedirectHandler());
        }

        return logger;
    }

    /**
     * Get a logger which only publishes to a console handler. The logging
     * output is prefixed in a custom way, using the formatter map to access
     * the proper state. This should be used by a class that does not have
     * an EnvironmentImpl, but still wishes to prepend some kind of custom
     * prefix to the logging output.
     *
     * When a logger is obtained this way, the logger should not be used
     * directly. Instead, the wrapper methods in LoggerUtils which use a
     * Formatter parameter, and put and remove the environment from the
     * formatterMap must be used, so that the logging output can be properly
     * prefixed and redirected to the correct environment.
     */
    public static Logger getLoggerFormatterNeeded(Class<?> cl) {
        /*
         * By convention, loggers that use redirect handlers are named with the
         * class name. Name logger that don't use redirecting differently, in
         * order to avoid conflicts when a single class uses both redirecting
         * and fixed prefix loggers.
         */
        Logger logger = createLogger(cl.getName() + NO_ENV);

        /* Add a new handler if a console handler does not already exist. */
        if (!hasConsoleHandler(logger)) {
            logger.addHandler(new FormatterRedirectHandler());
        }

        return logger;
    }

    /* Convenience method for getLoggerFixedPrefix. */
    public static Logger getLoggerFixedPrefix(Class<?> cl,
                                              String prefix) {
        return getLoggerFixedPrefix(cl, prefix, null);
    }

    /**
     * Get a logger that uses the generic console handler, with no attempt to
     * use thread local state to customize the message prefix.
     */
    public static Logger getLoggerFixedPrefix(Class<?> cl,
                                              String prefix,
                                              EnvironmentImpl envImpl) {

        /*
         * By convention, loggers that use redirect handlers are named with the
         * class name. Name logger that don't use redirecting differently, in
         * order to avoid conflicts when a single class uses both redirecting
         * and fixed prefix loggers.
         */
        Logger logger = createLogger(cl.getName() + FIXED_PREFIX);

        /* Check whether the logger already has this handler. */
        if (!hasConsoleHandler(logger)) {
            logger.addHandler(new com.sleepycat.je.util.ConsoleHandler
                              (new TracerFormatter(prefix), envImpl));
        }

        return logger;
    }

    /*
     * Return true if this logger already has a console handler. 
     */
    private static boolean hasConsoleHandler(Logger logger) {

        /* 
         * [#18277] Add null check of logger.getHandlers() because the Resin
         * app server's implementation of logging can return null instead of an
         * empty array.
         */
        Handler[] handlers = logger.getHandlers();
        if (handlers == null) {
            return false;
        }

        for (Handler h : handlers) {
            if (h instanceof java.util.logging.ConsoleHandler) {
                return true;
            }
        }

        return false;
    }

    /* Create a logger for the specified class name. */
    private static Logger createLogger(String className) {

        /*
         * No need to set level values explicitly. This is managed in the
         * standard way by java.util.logging.LogManager.
         */
        Logger logger = Logger.getLogger(className);
        logger.setUseParentHandlers(false);

        return logger;
    }

    /* Get the value of a specified Logger property. */
    public static String getLoggerProperty(String property) {
        java.util.logging.LogManager mgr =
            java.util.logging.LogManager.getLogManager();

        return mgr.getProperty(property);
    }

    /**
     * Get the push level for the MemoryHandler.
     */
    public static Level getPushLevel(String name) {
        String propertyValue = getLoggerProperty(name + PUSH_LEVEL);

        Level level = Level.OFF;
        if (propertyValue != null) {
            level = Level.parse(propertyValue);
        }

        return level;
    }

    /**
     * Log a message using this logger. We expect that this logger is one that
     * has been configured to expect an environment. This utility method should
     * be used to ensure that the thread specific context is pushed before
     * logging, and cleared afterwards.
     */
    public static void logMsg(Logger useLogger,
                              EnvironmentImpl envImpl,
                              Level logLevel,
                              String msg) {
        /* Set thread specific context. */
        if (envImpl != null) {
            envMap.put(Thread.currentThread(), envImpl);
        }
        try {
            useLogger.log(logLevel, msg);
        } finally {
            /* Clear thread specific context. */
            envMap.remove(Thread.currentThread());
        }
    }

    /**
     * Use the environment logger.
     */
    public static void envLogMsg(Level logLevel,
                                 EnvironmentImpl envImpl,
                                 String msg) {
        logMsg(envImpl.getLogger(), envImpl, logLevel, msg);
    }

    /**
     * Log a message using this logger. The logger may be either one that
     * expects to use the state in the envMap (obtained via getLogger(), or it
     * may be one that expects to use the state in the formatter map (obtained
     * via getLoggerFormatterNeeded(). This method checks whether the
     * EnvironmentImpl is null or not and choses the appropriate state type to
     * use.
     */
    public static void logMsg(Logger useLogger,
                              EnvironmentImpl envImpl,
                              Formatter formatter,
                              Level logLevel,
                              String msg) {
        if (envImpl != null) {
            logMsg(useLogger, envImpl, logLevel, msg);
        } else {
            logMsg(useLogger, formatter, logLevel, msg);
        }
    }

    /* Some convenience methods. */
    public static void severe(Logger useLogger,
                              EnvironmentImpl envImpl,
                              String msg) {
        logMsg(useLogger, envImpl, Level.SEVERE, msg);
    }

    public static void warning(Logger useLogger,
                               EnvironmentImpl envImpl,
                               String msg) {
        logMsg(useLogger, envImpl, Level.WARNING, msg);
    }

    public static void info(Logger useLogger,
                            EnvironmentImpl envImpl,
                            String msg) {
        logMsg(useLogger, envImpl, Level.INFO, msg);
    }

    public static void fine(Logger useLogger,
                            EnvironmentImpl envImpl,
                            String msg) {
        logMsg(useLogger, envImpl, Level.FINE, msg);
    }

    public static void finer(Logger useLogger,
                             EnvironmentImpl envImpl,
                             String msg) {
        logMsg(useLogger, envImpl, Level.FINER, msg);
    }

    public static void finest(Logger useLogger,
                              EnvironmentImpl envImpl,
                              String msg) {
        logMsg(useLogger, envImpl, Level.FINEST, msg);
    }

    /**
     * Log a message with this logger. This utility method should be used in
     * tandem with loggers obtained via getLoggerFormatterNeeded() to ensure
     * that the thread specific Formatter is pushed before logging, and cleared
     * afterwards.
     */
    public static void logMsg(Logger useLogger,
                              Formatter formatter,
                              Level logLevel,
                              String msg) {
        /* Set thread specific Formatter. */
        if (formatter != null) {
            formatterMap.put(Thread.currentThread(), formatter);
        }
        try {
            useLogger.log(logLevel, msg);
        } finally {
            /* Clear thread specific Formatter. */
            formatterMap.remove(Thread.currentThread());
        }
    }

    /**
     * Logger method for recording an exception and stacktrace to both the
     * java.util.logging system and the .jdb files.
     */
    public static void traceAndLogException(EnvironmentImpl envImpl,
                                            String sourceClass,
                                            String sourceMethod,
                                            String msg,
                                            Throwable t) {
        String traceMsg = msg + "\n" + getStackTrace(t);

        envMap.put(Thread.currentThread(), envImpl);
        try {
            envImpl.getLogger().logp
                (Level.SEVERE, sourceClass, sourceMethod, traceMsg);
        } finally {
            envMap.remove(Thread.currentThread());
        }
        Trace.trace(envImpl, traceMsg);
    }

    /**
     * Records a message both to the java.util.logging loggers and through
     * the trace system which writes to the .jdb files. The logLevel parameter
     * only applies to the java.util.logging system. Trace messages are
     * unconditionally written to the .jdb files.
     *
     * Because of that, this method should be used sparingly, for critical
     * messages.
     */
    public static void traceAndLog(Logger logger,
                                   EnvironmentImpl envImpl,
                                   Level logLevel,
                                   String msg) {
        logMsg(logger, envImpl, logLevel, msg);
        Trace.trace(envImpl, msg);
    }

    /** Return a String version of a stack trace */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        String stackTrace = sw.toString();
        stackTrace = stackTrace.replaceAll("&lt", "<");
        stackTrace = stackTrace.replaceAll("&gt", ">");

        return stackTrace;
    }

    /** Return the stack trace of the caller, for debugging. */
    public static String getStackTrace() {
        Exception e = new Exception();
        return getStackTrace(e);
    }

    /* Get the level for ConsoleHandler and FileHandler. */
    public static Level getHandlerLevel(DbConfigManager configManager,
                                        ConfigParam param,
                                        String levelName) {
        boolean changed = false;

        /* Check if the level params are set. */
        String level = configManager.get(param);
        if (!param.getDefault().equals(level)) {
            changed = true;
        }

        /* Get the level from the java.util.logging configuration system. */
        String propertyLevel = getLoggerProperty(levelName);

        /*
         * If the params are not set, and levels are set in the properties
         * file, then set the level from properties file.
         */
        if (!changed && propertyLevel != null) {
            level = propertyLevel;
        }

        return Level.parse(level);
    }
}
