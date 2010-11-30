/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jmx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;

import com.sleepycat.je.CheckpointConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DatabaseExistsException;
import com.sleepycat.je.DatabaseNotFoundException;
import com.sleepycat.je.DatabaseStats;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.StatsConfig;

/**
 * @deprecated As of JE 4, JEMBeanHelper is deprecated in favor of the concrete
 * MBeans available by default with a JE environment. These MBeans can be 
 * registered and enabled by the environment by setting the following JVM
 * property:
 *     JEMonitor: 
 *         This MBean provides general stats monitoring and access to basic 
 *         environment level operations.
 *
 * JEMBeanHelper is a utility class for the MBean implementation which wants to
 * add management of a JE environment to its capabilities. MBean
 * implementations can contain a JEMBeanHelper instance to get MBean metadata
 * for JE and to set attributes, get attributes, and invoke operations.
 * <p>
 * com.sleepycat.je.jmx.JEMonitor and the example program
 * jmx.JEApplicationMBean are two MBean implementations which provide support
 * different application use cases. See those classes for examples of how to
 * use JEMBeanHelper.
 */
public class JEMBeanHelper {

    /*
     * A note to JE developers: all available JE attributes and operations are
     * described in the following static info arrays. New management
     * functionality can be added to the helper by adding to the appropriate
     * set of static definitions. For example, if we want to add a new JE
     * attribute called "foo", which is available for open environments, we
     * need to define a new MBeanAttributeInfo in the OPEN_ATTR array. The
     * helper then needs to provide an implementation in set/getAttribute.
     */

    /* Attribute names. */
    public static final String ATT_ENV_HOME = "environmentHome";
    public static final String ATT_OPEN = "isOpen";
    public static final String ATT_IS_READ_ONLY = "isReadOnly";
    public static final String ATT_IS_TRANSACTIONAL = "isTransactional";
    public static final String ATT_CACHE_SIZE = "cacheSize";
    public static final String ATT_CACHE_PERCENT = "cachePercent";
    public static final String ATT_LOCK_TIMEOUT = "lockTimeout";
    public static final String ATT_IS_SERIALIZABLE = "isSerializableIsolation";
    public static final String ATT_TXN_TIMEOUT = "transactionTimeout";
    public static final String ATT_SET_READ_ONLY = "openReadOnly";
    public static final String ATT_SET_TRANSACTIONAL = "openTransactional";
    public static final String ATT_SET_SERIALIZABLE =
        "openSerializableIsolation";

    /* COMMON_ATTR attributes are available for any environment. */
    private static final MBeanAttributeInfo[] COMMON_ATTR = {

        new MBeanAttributeInfo(ATT_ENV_HOME,
                               "java.lang.String",
                               "Environment home directory.",
                               true,   // readable
                               false,  // writable
                               false), // isIs
        new MBeanAttributeInfo(ATT_OPEN,
                               "java.lang.Boolean",
                               "True if this environment is open.",
                               true,   // readable
                               false,  // writable
                               true)   // isIs
    };

    /* OPEN_ATTR attributes are available for all open environments. */
    private static final MBeanAttributeInfo[] OPEN_ATTR = {

        new MBeanAttributeInfo(ATT_IS_READ_ONLY,
                               "java.lang.Boolean",
                               "True if this environment is read only.",
                               true,   // readable
                               false,  // writable
                               true),  // isIs
        new MBeanAttributeInfo(ATT_IS_TRANSACTIONAL,
                               "java.lang.Boolean",
                             "True if this environment supports transactions.",
                               true,   // readable
                               false,  // writable
                               true),  // isIs
        new MBeanAttributeInfo(ATT_CACHE_SIZE,
                               "java.lang.Long",
                               "Cache size, in bytes.",
                               true,   // readable
                               true,   // writable
                               false), // isIs
        new MBeanAttributeInfo(ATT_CACHE_PERCENT,
                               "java.lang.Integer",
                               "By default, cache size is (cachePercent * " +
                               "JVM maximum memory. To change the cache size "+
                               "using a percentage of the heap size, set " +
                               "the cache size to 0 and cachePercent to the "+
                               "desired percentage value.",
                               true,   // readable
                               true,   // writable
                               false), // isIs
        new MBeanAttributeInfo(ATT_LOCK_TIMEOUT,
                               "java.lang.Long",
                               "Lock timeout, in microseconds.",
                               true,   // readable
                               false,  // writable
                               false), // isIs
    };

    /*
     * TRANSACTIONAL_ATTR attributes are available only for open, transactional
     * environments.
     */
    private static final MBeanAttributeInfo[] TRANSACTIONAL_ATTR = {

        new MBeanAttributeInfo(ATT_IS_SERIALIZABLE,
                               "java.lang.Boolean",
                               "True if this environment provides " +
                               "Serializable (degree 3) isolation. The " +
                               "default is RepeatableRead isolation.",
                               true,   // readable
                               false,  // writable
                               true),  // isIs
        new MBeanAttributeInfo(ATT_TXN_TIMEOUT,
                               "java.lang.Long",
                               "Transaction timeout, in seconds. A value " +
                               "of 0 means there is no timeout.",
                               true,   // readable
                               false,  // writable
                               false)  // isIs
    };

    /*
     * CREATE_ATTR attributes are available when the mbean is configured to
     * support configuration and opening by the mbean. They express the
     * configuration settings.
     */
    private static final MBeanAttributeInfo[] CREATE_ATTR = {

        new MBeanAttributeInfo(ATT_SET_READ_ONLY,
                               "java.lang.Boolean",
                               "True if this environment should be opened " +
                               "in readonly mode.",
                               true,   // readable
                               true,   // writable
                               false), // isIs
        new MBeanAttributeInfo(ATT_SET_TRANSACTIONAL,
                               "java.lang.Boolean",
                               "True if this environment should be opened " +
                               "in transactional mode.",
                               true,   // readable
                               true,   // writable
                               false), // isIs
        new MBeanAttributeInfo(ATT_SET_SERIALIZABLE,
                               "java.lang.Boolean",
                               "True if this environment should be opened " +
                               "with serializableIsolation. The default is "+
                               "false.",
                               true,   // readable
                               true,   // writable
                               false), // isIs
    };

    /* Operation names */
    static final String OP_CLEAN = "cleanLog";
    static final String OP_EVICT = "evictMemory";
    static final String OP_CHECKPOINT = "checkpoint";
    static final String OP_SYNC = "sync";
    static final String OP_ENV_STAT = "getEnvironmentStats";
    static final String OP_TXN_STAT = "getTxnStats";
    static final String OP_DB_NAMES = "getDatabaseNames";
    static final String OP_DB_STAT = "getDatabaseStats";

    private static final MBeanOperationInfo OP_CLEAN_INFO =
        new MBeanOperationInfo(OP_CLEAN,
                               "Remove obsolete environment log files. " +
                               "Zero or more log files will be cleaned as " +
                               "necessary to bring the disk space " +
                               "utilization of the environment above the " +
                               "configured minimum utilization threshold " +
                               "as determined by the setting " +
                               "je.cleaner.minUtilization. Returns the " +
                               "number of files cleaned, that will be " +
                               "deleted at the next qualifying checkpoint.",
                               new MBeanParameterInfo[0], // no params
                               "java.lang.Integer",
                               MBeanOperationInfo.UNKNOWN);

    private static final MBeanOperationInfo OP_EVICT_INFO =
        new MBeanOperationInfo(OP_EVICT,
                               "Reduce cache usage to the threshold " +
                               "determined by the setting " +
                               "je.evictor.useMemoryFloor. ",
                               new MBeanParameterInfo[0], // no params
                               "void",
                               MBeanOperationInfo.UNKNOWN);

    /* parameter for checkpoint operation. */
    private static final MBeanParameterInfo[] checkpointParams = {
        new MBeanParameterInfo("force", "java.lang.Boolean",
                               "If true, force a checkpoint even if " +
                               "there has been no activity since the last " +
                               "checkpoint. Returns true if a checkpoint " +
                               "executed.")
    };

    private static final MBeanOperationInfo OP_CHECKPOINT_INFO =
        new MBeanOperationInfo(OP_CHECKPOINT,
                               "Checkpoint the environment.",
                               checkpointParams,
                               "void",
                               MBeanOperationInfo.UNKNOWN);

    private static final MBeanOperationInfo OP_SYNC_INFO =
        new MBeanOperationInfo(OP_SYNC,
                               "Flush the environment to stable storage.",
                               new MBeanParameterInfo[0], // no params
                               "void",
                               MBeanOperationInfo.UNKNOWN);

    private static final MBeanParameterInfo[] statParams = {
        new MBeanParameterInfo("clear", "java.lang.Boolean",
                               "If true, reset statistics after reading."),
        new MBeanParameterInfo("fast", "java.lang.Boolean",
                               "If true, only return statistics which do " +
                               "not require expensive computation.")
    };

    private static final MBeanOperationInfo OP_ENV_STAT_INFO =
        new MBeanOperationInfo(OP_ENV_STAT,
                               "Get environment statistics.",
                               statParams,
                               "java.lang.String",
                               MBeanOperationInfo.INFO);

    private static final MBeanOperationInfo OP_TXN_STAT_INFO =
        new MBeanOperationInfo(OP_TXN_STAT,
                               "Get transactional statistics.",
                               statParams,
                               "java.lang.String",
                               MBeanOperationInfo.INFO);

    private static final MBeanOperationInfo OP_DB_NAMES_INFO =
        new MBeanOperationInfo(OP_DB_NAMES,
                              "Get the names of databases in the environment.",
                               new MBeanParameterInfo[0], // no params
                               "java.util.ArrayList",
                               MBeanOperationInfo.INFO);

    private static final MBeanParameterInfo[] dbStatParams = {
        new MBeanParameterInfo("clear", "java.lang.Boolean",
                               "If true, reset statistics after reading."),
        new MBeanParameterInfo("fast", "java.lang.Boolean",
                               "If true, only return statistics which do " +
                               "not require expensive computation. " +
                               "Currently all database stats are not fast."),
        new MBeanParameterInfo("databaseName", "java.lang.String",
                               "database name")
    };

    private static final MBeanOperationInfo OP_DB_STAT_INFO =
        new MBeanOperationInfo(OP_DB_STAT,
                               "Get database statistics.",
                               dbStatParams,
                               "java.lang.String",
                               MBeanOperationInfo.INFO);

    /* target JE environment home directory. */
    private File environmentHome;

    /*
     * If canConfigure is true, this helper will make environment configuration
     * attributes available in the mbean metadata. Configuration attributes
     * will be saved in the openConfig instance.
     */
    private boolean canConfigure;
    private EnvironmentConfig openConfig;

    /* true if the mbean metadata needs to be refreshed. */
    private boolean needReset;

    /*
     * Save whether the environment was open the last time we fetched mbean
     * attributes. Use to detect a change in environment status.
     */
    private boolean envWasOpen;

    /**
     * Instantiate a helper, specifying environment home and open capabilities.
     *
     * @param environmentHome home directory of the target JE environment.
     * @param canConfigure If true, the helper will show environment
     * configuration attributes.
     */
    public JEMBeanHelper(File environmentHome, boolean canConfigure) {

        if (environmentHome == null) {
            throw new IllegalArgumentException
                ("Environment home cannot be null");
        }
        this.environmentHome = environmentHome;
        this.canConfigure = canConfigure;
        if (canConfigure) {
            openConfig = new EnvironmentConfig();
        }
    }

    /**
     * Return the target environment directory.
     *
     * @return the environment directory.
     */
    public File getEnvironmentHome() {
        return environmentHome;
    }

    /**
     * If the helper was instantiated with canConfigure==true, it shows
     * environment configuration attributes. Those attributes are returned
     * within this EnvironmentConfig object for use in opening environments.
     *
     * @return EnvironmentConfig object which saves configuration attributes
     * recorded through MBean attributes.
     */
    public EnvironmentConfig getEnvironmentOpenConfig() {
        return openConfig;
    }

    /**
     * Return an Environment only if the environment has already been opened
     * in this process. A helper method for MBeans which want to only access
     * open environments.
     *
     * @return Environment if already open, null if not open.
     */
    public Environment getEnvironmentIfOpen() {
        if (environmentHome == null) {
            return null;
        }

        return DbInternal.getEnvironmentShell(environmentHome);
    }

    /**
     * Tell the MBean if the available set of functionality has changed.
     *
     * @return true if the MBean should regenerate its JE metadata.
     */
    public synchronized boolean getNeedReset() {
        return needReset;
    }

    /**
     * Get MBean attribute metadata for this environment.
     * @param targetEnv The target JE environment. May be null if the
     * environment is not open.
     * @return list of MBeanAttributeInfo objects describing the available
     * attributes.
     */
    public List<MBeanAttributeInfo> getAttributeList(Environment targetEnv) {

        /* Turn off reset because the mbean metadata is being refreshed. */
        setNeedReset(false);

        ArrayList<MBeanAttributeInfo> attrList = 
            new ArrayList<MBeanAttributeInfo>();

        /* Add attributes for all JE environments. */
        for (int i = 0; i < COMMON_ATTR.length; i++) {
            attrList.add(COMMON_ATTR[i]);
        }

        if (targetEnv == null) {
            if (canConfigure) {
                /* Add attributes for configuring an environment. */
                for (int i = 0; i < CREATE_ATTR.length; i++) {
                    attrList.add(CREATE_ATTR[i]);
                }
            }
        } else {
            /* Add attributes for an open environment. */
            for (int i = 0; i < OPEN_ATTR.length; i++) {
                attrList.add(OPEN_ATTR[i]);
            }

            /* Add attributes for an open, transactional environment. */
            try {
                EnvironmentConfig config = targetEnv.getConfig();
                if (config.getTransactional()) {
                    for (int i = 0; i < TRANSACTIONAL_ATTR.length; i++) {
                        attrList.add(TRANSACTIONAL_ATTR[i]);
                    }
                }
            } catch (DatabaseException ignore) {
                    /* ignore */
            }
        }

        return attrList;
    }

    /**
     * Get an attribute value for the given environment. Check
     * JEMBeanHelper.getNeedReset() after this call because the helper may
     * detect that the environment has changed and that the MBean metadata
     * should be reset.
     *
     * @param targetEnv The target JE environment. May be null if the
     * environment is not open.
     * @param attributeName attribute name.
     * @return attribute value.
     */
    public Object getAttribute(Environment targetEnv, String attributeName)
        throws AttributeNotFoundException,
               MBeanException {

        /* Sanity check. */
        if (attributeName == null) {
            throw new AttributeNotFoundException
                ("Attribute name cannot be null");
        }

        /* These attributes are available regardless of environment state. */
        try {
            if (attributeName.equals(ATT_ENV_HOME)) {
                return environmentHome.getCanonicalPath();
            } else if (attributeName.equals(ATT_OPEN)) {
                boolean envIsOpen = (targetEnv != null);
                resetIfOpenStateChanged(envIsOpen);
                return new Boolean(envIsOpen);
            } else if (attributeName.equals(ATT_SET_READ_ONLY)) {
                return new Boolean(openConfig.getReadOnly());
            } else if (attributeName.equals(ATT_SET_TRANSACTIONAL)) {
                return new Boolean(openConfig.getTransactional());
            } else if (attributeName.equals(ATT_SET_SERIALIZABLE)) {
                return new Boolean(openConfig.getTxnSerializableIsolation());
            } else {
                /* The rest are JE environment attributes. */
                if (targetEnv != null) {

                    EnvironmentConfig config = targetEnv.getConfig();

                    if (attributeName.equals(ATT_IS_READ_ONLY)) {
                        return new Boolean(config.getReadOnly());
                    } else if (attributeName.equals(ATT_IS_TRANSACTIONAL)) {
                        return new Boolean(config.getTransactional());
                    } else if (attributeName.equals(ATT_CACHE_SIZE)) {
                        return new Long(config.getCacheSize());
                    } else if (attributeName.equals(ATT_CACHE_PERCENT)) {
                        return new Integer(config.getCachePercent());
                    } else if (attributeName.equals(ATT_LOCK_TIMEOUT)) {
                        return new Long(config.getLockTimeout());
                    } else if (attributeName.equals(ATT_IS_SERIALIZABLE)) {
                        return new
                            Boolean(config.getTxnSerializableIsolation());
                    } else if (attributeName.equals(ATT_TXN_TIMEOUT)) {
                        return new Long(config.getTxnTimeout());
                    } else {
                        throw new AttributeNotFoundException
                            ("attribute " + attributeName + " is not valid.");
                    }
                }
                return null;
            }
        } catch (Exception e) {

            /*
             * Add both the message and the exception for easiest deciphering
             * of the problem. Sometimes the original exception stacktrace gets
             * hidden in server logs.
             */
            throw new MBeanException(e, e.getMessage());
        }
    }

    /**
     * Set an attribute value for the given environment.
     *
     * @param targetEnv The target JE environment. May be null if the
     * environment is not open.
     * @param attribute name/value pair
     */
    public void setAttribute(Environment targetEnv, Attribute attribute)
        throws AttributeNotFoundException,
               InvalidAttributeValueException {

        if (attribute == null) {
            throw new AttributeNotFoundException("Attribute cannot be null");
        }

        /* Sanity check parameters. */
        String name = attribute.getName();
        Object value = attribute.getValue();

        if (name == null) {
            throw new AttributeNotFoundException
                ("Attribute name cannot be null");
        }

        if (value == null) {
            throw new InvalidAttributeValueException
                ("Attribute value for attribute " + name + " cannot be null");
        }

        try {
            if (name.equals(ATT_SET_READ_ONLY)) {
                openConfig.setReadOnly(((Boolean) value).booleanValue());
            } else if (name.equals(ATT_SET_TRANSACTIONAL)) {
                openConfig.setTransactional(((Boolean) value).booleanValue());
            } else if (name.equals(ATT_SET_SERIALIZABLE)) {
                openConfig.setTxnSerializableIsolation
                    (((Boolean) value).booleanValue());
            } else {
                /* Set the specified attribute if the environment is open. */
                if (targetEnv != null) {

                    EnvironmentMutableConfig config =
                        targetEnv.getMutableConfig();

                    if (name.equals(ATT_CACHE_SIZE)) {
                        config.setCacheSize(((Long) value).longValue());
                        targetEnv.setMutableConfig(config);
                    } else if (name.equals(ATT_CACHE_PERCENT)) {
                        config.setCachePercent(((Integer) value).intValue());
                        targetEnv.setMutableConfig(config);
                    } else {
                        throw new AttributeNotFoundException
                            ("attribute " + name + " is not valid.");
                    }
                } else {
                    throw new AttributeNotFoundException
                        ("attribute " + name + " is not valid.");
                }
            }
        } catch (NumberFormatException e) {
            throw new InvalidAttributeValueException("attribute name=" + name);
        } catch (DatabaseException e) {
            throw new InvalidAttributeValueException
                ("attribute name=" + name + e.getMessage());
        }
    }

    /********************************************************************/
    /* JE Operations                                                    */
    /********************************************************************/

    /**
     * Get mbean operation metadata for this environment.
     *
     * @param targetEnv The target JE environment. May be null if the
     * environment is not open.
     * @return List of MBeanOperationInfo describing available operations.
     */
    public List<MBeanOperationInfo> getOperationList(Environment targetEnv) {
        setNeedReset(false);

        List<MBeanOperationInfo> operationList = 
            new ArrayList<MBeanOperationInfo>();

        if (targetEnv != null) {

            /*
             * These operations are only available if the environment is open.
             */
            operationList.add(OP_CLEAN_INFO);
            operationList.add(OP_EVICT_INFO);
            operationList.add(OP_ENV_STAT_INFO);
            operationList.add(OP_DB_NAMES_INFO);
            operationList.add(OP_DB_STAT_INFO);

            /* Add checkpoint only for transactional environments. */
            boolean isTransactional = false;
            try {
                EnvironmentConfig config = targetEnv.getConfig();
                isTransactional = config.getTransactional();
            } catch (DatabaseException e) {
                /* Don't make any operations available. */
                return new ArrayList<MBeanOperationInfo>();
            }

            if (isTransactional) {
                operationList.add(OP_CHECKPOINT_INFO);
                operationList.add(OP_TXN_STAT_INFO);
            } else {
                operationList.add(OP_SYNC_INFO);
            }
        }

        return operationList;
    }

    /**
     * Invoke an operation for the given environment.
     *
     * @param targetEnv The target JE environment. May be null if the
     * environment is not open.
     * @param actionName operation name.
     * @param params operation parameters. May be null.
     * @param signature operation signature. May be null.
     * @return the operation result
     */
    public Object invoke(Environment targetEnv,
                         String actionName,
                         Object[] params,
                         String[] signature)
        throws MBeanException {

        /* Sanity checking. */
        if (actionName == null) {
            throw new IllegalArgumentException("actionName cannot be null");
        }

        try {
            if (targetEnv != null) {
                if (actionName.equals(OP_CLEAN)) {
                    int numFiles = targetEnv.cleanLog();
                    return new Integer(numFiles);
                } else if (actionName.equals(OP_EVICT)) {
                    targetEnv.evictMemory();
                    return null;
                } else if (actionName.equals(OP_CHECKPOINT)) {
                    CheckpointConfig config = new CheckpointConfig();
                    if ((params != null) && (params.length > 0)) {
                        Boolean force = (Boolean) params[0];
                        config.setForce(force.booleanValue());
                    }
                    targetEnv.checkpoint(config);
                    return null;
                } else if (actionName.equals(OP_SYNC)) {
                    targetEnv.sync();
                    return null;
                } else if (actionName.equals(OP_ENV_STAT)) {
                    return targetEnv.getStats
                        (getStatsConfig(params)).toString();
                } else if (actionName.equals(OP_TXN_STAT)) {
                    return targetEnv.getTransactionStats
                        (getStatsConfig(params)).toString();
                } else if (actionName.equals(OP_DB_NAMES)) {
                    return targetEnv.getDatabaseNames();
                } else if (actionName.equals(OP_DB_STAT)) {
                    DatabaseStats stats = getDatabaseStats(targetEnv, params);
                    return stats != null ? stats.toString() : null;
                }
            }

            return new IllegalArgumentException
                ("actionName: " + actionName + " is not valid");
        } catch (Exception e) {

            /*
             * Add both the message and the exception for easiest deciphering
             * of the problem. Sometimes the original exception stacktrace gets
             * hidden in server logs.
             */
            throw new MBeanException(e, e.getMessage());
        }
    }

    /**
     * Helper for creating a StatsConfig object to use as an operation
     * parameter.
     */
    private StatsConfig getStatsConfig(Object[] params) {
        StatsConfig statsConfig = new StatsConfig();
        if ((params != null) && (params.length > 0) && (params[0] != null)) {
            Boolean clear = (Boolean) params[0];
            statsConfig.setClear(clear.booleanValue());
        }
        if ((params != null) && (params.length > 1) && (params[1] != null)) {
            Boolean fast = (Boolean) params[1];
            statsConfig.setFast(fast.booleanValue());
        }
        return statsConfig;
    }

    /**
     * Helper to get statistics for a given database.
     * @param params operation parameters
     * @return DatabaseStats object
     */
    private DatabaseStats getDatabaseStats(Environment targetEnv,
                                           Object[] params)
        throws IllegalArgumentException,
               DatabaseNotFoundException,
               DatabaseException {

        if ((params == null) || (params.length < 3)) {
            return null;
        }
        String dbName = (String)params[2];

        Database db = null;
        try {
            DatabaseConfig dbConfig = new DatabaseConfig();
            dbConfig.setReadOnly(true);
            DbInternal.setUseExistingConfig(dbConfig, true);
            try {
                db = targetEnv.openDatabase(null, dbName, dbConfig);
            } catch (DatabaseExistsException e) {
                /* Should never happen, ExlcusiveCreate is false. */
                throw EnvironmentFailureException.unexpectedException(e);
            }
            return db.getStats(getStatsConfig(params));
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    /**
     * No notifications are supported.
     * @return List of MBeanNotificationInfo for available notifications.
     */
    public MBeanNotificationInfo[]
        getNotificationInfo(Environment targetEnv) {
        return null;
    }

    private synchronized void setNeedReset(boolean reset) {
        needReset = reset;
    }

    private synchronized void resetIfOpenStateChanged(boolean isOpen) {
        if (isOpen != envWasOpen) {
            setNeedReset(true);
            envWasOpen = isOpen;
        }
    }
}
