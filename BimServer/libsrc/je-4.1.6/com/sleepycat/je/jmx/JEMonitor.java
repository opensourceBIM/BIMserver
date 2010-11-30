/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jmx;

import java.util.ArrayList;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;

import com.sleepycat.je.CheckpointConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DatabaseStats;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * <p>
 * JEMonitor is a JMX MBean which makes statistics and basic administrative
 * operations available.  The MBean is registered and enabled when the system
 * property JEMonitor is set. It only works on an active JE Environment, and
 * an Environment can only register one instance of JEMonitor.
 *
 * @see <a href="{@docRoot}/../jconsole/JConsole-plugin.html">Monitoring
 * JE with JConsole and JMX</a>
 */
public class JEMonitor extends JEMBean implements DynamicMBean {

    /* Attributes and operations' definition for JEMonitor concrete MBean. */

    /* Attribute names. */
    public static final String ATT_ENV_HOME = "environmentHome";
    public static final String ATT_IS_READ_ONLY = "isReadOnly";
    public static final String ATT_IS_TRANSACTIONAL = "isTransactional";
    public static final String ATT_CACHE_SIZE = "cacheSize";
    public static final String ATT_CACHE_PERCENT = "cachePercent";
    public static final String ATT_LOCK_TIMEOUT = "lockTimeout";
    public static final String ATT_IS_SERIALIZABLE = "isSerializableIsolation";
    public static final String ATT_TXN_TIMEOUT = "transactionTimeout";

    /* Attributes available for any Environments. */
    private static final MBeanAttributeInfo[] COMMON_ATTR = {

        new MBeanAttributeInfo
            (ATT_ENV_HOME, "java.lang.String", "Environment home directory.",
             true, false , false )
    };

    /* Available attributes for an open Environment. */
    private static final MBeanAttributeInfo[] OPEN_ATTR = {

        new MBeanAttributeInfo
            (ATT_IS_READ_ONLY, "java.lang.Boolean", 
             "true if this Environment is read only.", true, false, true),

        new MBeanAttributeInfo
            (ATT_IS_TRANSACTIONAL, "java.lang.Boolean", 
             "true if this Environment supports transactions.", 
             true, false, true), 

        new MBeanAttributeInfo
            (ATT_CACHE_SIZE, "java.lang.Long", "Cache size, in bytes.",
             true, true, false), 

        new MBeanAttributeInfo
            (ATT_CACHE_PERCENT, "java.lang.Integer",
             "By default, cache size is (cachePercent * JVM maximum " +
             "memory). To change the cache size using a percentage of the " + 
             "heap size, set the cache size to 0 and cachePercent to the " +
             "desired percentage value.",
             true, true, false), 

        new MBeanAttributeInfo
            (ATT_LOCK_TIMEOUT, "java.lang.Long", 
             "Lock timeout, in microseconds.", true, false, false) 
    };

    /* Attributes available only for an open transactional Environment. */
    private static final MBeanAttributeInfo[] TRANSACTIONAL_ATTR = {

        new MBeanAttributeInfo
            (ATT_IS_SERIALIZABLE, "java.lang.Boolean",
             "true if this environment provides Serializable (degree 3) " +
             "isolation. The default is RepeatableRead isolation.", 
             true, false, true),  

        new MBeanAttributeInfo
            (ATT_TXN_TIMEOUT, "java.lang.Long",
             "Transaction timeout, in seconds. A value of 0 means there is " +
             "no timeout.", true, false, false)
    };

    /* --------------------- Operations  -------------------------- */

    /* Operation names. */
    static final String OP_CLEAN = "cleanLog";
    static final String OP_EVICT = "evictMemory";
    static final String OP_CHECKPOINT = "checkpoint";
    static final String OP_SYNC = "sync";
    static final String OP_TXN_STAT = "getTxnStats";
    static final String OP_DB_NAMES = "getDatabaseNames";
    static final String OP_DB_STAT = "getDatabaseStats";
    static final String OP_ENV_CONFIG = "getEnvConfig";

    /**
     * @hidden
     */
    public static final String OP_ENV_STAT = "getEnvironmentStats";

    /**
     * @hidden
     */
    public static final String OP_GET_TIPS = "getTips";

    private static final MBeanOperationInfo OP_CLEAN_INFO =
        new MBeanOperationInfo
        (OP_CLEAN, 
         "Remove obsolete environment log files. Zero or more log files " + 
         "will be cleaned as necessary to bring the disk space utilization " +
         "of the environment above the configured minimum utilization " +
         "threshold as determined by the setting je.cleaner.minUtilization. " +
         "Returns the number of files cleaned. These will be deleted at the " +
         "next qualifying checkpoint.",
         new MBeanParameterInfo[0], "java.lang.Integer", 
         MBeanOperationInfo.UNKNOWN);

    private static final MBeanOperationInfo OP_EVICT_INFO =
        new MBeanOperationInfo
        (OP_EVICT,
         "Reduce cache usage to the threshold determined by the setting " +
         "je.evictor.useMemoryFloor. ",
         new MBeanParameterInfo[0], "void", MBeanOperationInfo.UNKNOWN);

    /* Parameter for checkpoint operation. */
    private static final MBeanParameterInfo[] checkpointParams = {
        new MBeanParameterInfo("force", "java.lang.Boolean",
                               "If true, force a checkpoint even if " +
                               "there has been no activity since the last " +
                               "checkpoint. Returns true if a checkpoint " +
                               "executed.")
    };

    private static final MBeanOperationInfo OP_CHECKPOINT_INFO =
        new MBeanOperationInfo
        (OP_CHECKPOINT, "Checkpoint the environment.", checkpointParams, 
         "void", MBeanOperationInfo.UNKNOWN);

    private static final MBeanOperationInfo OP_SYNC_INFO =
        new MBeanOperationInfo
        (OP_SYNC, "Flush the environment to stable storage.",
         new MBeanParameterInfo[0], "void", MBeanOperationInfo.UNKNOWN);

    private static final MBeanOperationInfo OP_ENV_STAT_INFO =
        new MBeanOperationInfo
        (OP_ENV_STAT, "Get environment statistics.",
         statParams, "java.lang.String", MBeanOperationInfo.INFO);

    private static final MBeanOperationInfo OP_TXN_STAT_INFO =
        new MBeanOperationInfo
        (OP_TXN_STAT, "Get transactional statistics.",
         statParams, "java.lang.String", MBeanOperationInfo.INFO);

    private static final MBeanOperationInfo OP_DB_NAMES_INFO =
        new MBeanOperationInfo
        (OP_DB_NAMES, "Get the names of databases in the environment.",
         new MBeanParameterInfo[0], "java.util.ArrayList", 
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
        new MBeanOperationInfo
        (OP_DB_STAT, "Get database statistics.",
         dbStatParams, "java.lang.String", MBeanOperationInfo.INFO);

    private static final MBeanOperationInfo OP_ENV_CONFIG_INFO =
        new MBeanOperationInfo
        (OP_ENV_CONFIG, "Get environment configuration.",
         new MBeanParameterInfo[0], "java.lang.String", 
         MBeanOperationInfo.INFO);

    protected JEMonitor(Environment env) {
        super(env);
    }

    public JEMonitor() {
        super();
    }

    @Override
    protected void initClassFields() {
        currentClass = JEMonitor.class;
        className = "JEMonitor";
        DESCRIPTION = "Monitor an open Berkeley DB, Java Edition Environment.";
    }

    /**
     * @see DynamicMBean#getAttribute
     */
    @SuppressWarnings("deprecation")
    public Object getAttribute(String attributeName)
        throws AttributeNotFoundException,
               MBeanException {

        if (attributeName == null) {
            throw new AttributeNotFoundException
                ("Attribute name can't be null.");
        }

        try {
            EnvironmentConfig envConfig = env.getConfig();
            if (attributeName.equals(ATT_ENV_HOME)) {
                return env.getHome().getCanonicalPath();
            } else if (attributeName.equals(ATT_IS_READ_ONLY)) {
                return new Boolean(envConfig.getReadOnly());
            } else if (attributeName.equals(ATT_IS_TRANSACTIONAL)) {
                return new Boolean(envConfig.getTransactional());
            } else if (attributeName.equals(ATT_CACHE_SIZE)) {
                return new Long(envConfig.getCacheSize());
            } else if (attributeName.equals(ATT_CACHE_PERCENT)) {
                return new Integer(envConfig.getCachePercent());
            } else if (attributeName.equals(ATT_LOCK_TIMEOUT)) {
                return new Long(envConfig.getLockTimeout());
            } else if (attributeName.equals(ATT_IS_SERIALIZABLE)) {
                return new
                    Boolean(envConfig.getTxnSerializableIsolation());
            } else if (attributeName.equals(ATT_TXN_TIMEOUT)) {
                return new Long(envConfig.getTxnTimeout());
            } else {
                throw new AttributeNotFoundException
                    ("Attribute " + attributeName + " is not valid.");
            }
        } catch (DatabaseException e) {
            /* Do not pass JE exceptions to the mbean client. */
            throw new MBeanException(new RuntimeException(e.getMessage()));
        } catch (Exception e) {
            /* Ok to pass general Java exception to the mbean client. */
            throw new MBeanException(e, e.getMessage());
        }
    }

    /**
     * @see DynamicMBean#setAttribute
     */
    public void setAttribute(Attribute attribute)
        throws AttributeNotFoundException,
               InvalidAttributeValueException,
               MBeanException {

        if (attribute == null) {
            throw new AttributeNotFoundException("Attribute can't be null.");
        }

        /* Sanity check parameters. */
        String name = attribute.getName();
        Object value = attribute.getValue();

        if (name == null) {
            throw new AttributeNotFoundException
                ("Attribute name can't be null.");
        }

        if (value == null) {
            throw new InvalidAttributeValueException
                ("Attribute value for attribute " + name + " can't be null");
        }

        try {
            EnvironmentMutableConfig mutableConfig = env.getMutableConfig();

            if (name.equals(ATT_CACHE_SIZE)) {
                mutableConfig.setCacheSize(((Long) value).longValue());
                env.setMutableConfig(mutableConfig);
            } else if (name.equals(ATT_CACHE_PERCENT)) {
                mutableConfig.setCachePercent(((Integer) value).intValue());
                env.setMutableConfig(mutableConfig);
            } else {
                throw new AttributeNotFoundException
                    ("Attribute " + name + " is not valid.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidAttributeValueException
                ("Attribute value for attribute " + name + " is not valid.");
        } catch (DatabaseException e) {
            throw new InvalidAttributeValueException
                ("Setting value for attribute " + name + 
                 "is invalid because of " + e.getMessage());
        }
    }

    /**
     * @see DynamicMBean#getAttributes
     */
    public AttributeList getAttributes(String[] attributes) {

        /* Sanity checking. */
        if (attributes == null) {
            throw new IllegalArgumentException("Attributes can't be null");
        }

        /* Get each requested attribute. */
        AttributeList results = new AttributeList();

        for (int i = 0; i < attributes.length; i++) {
            try {
                Object value = getAttribute(attributes[i]);
                results.add(new Attribute(attributes[i], value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return results;
    }

    /**
     * @see DynamicMBean#setAttributes
     */
    public AttributeList setAttributes(AttributeList attributes) {

        /* Sanity checking. */
        if (attributes == null) {
            throw new IllegalArgumentException("Attribute list can't be null");
        }

        /* Set each attribute specified. */
        AttributeList results = new AttributeList();

        for (int i = 0; i < attributes.size(); i++) {
            Attribute attr = (Attribute) attributes.get(i);
            try {
                setAttribute(attr);

                /*
                 * Add the name and new value to the result list. Be sure to
                 * ask the MBean for the new value, rather than simply using
                 * attr.getValue(), because the new value may not be same if it
                 * is modified according to the JE implementation.
                 */
                String name = attr.getName();
                Object newValue = getAttribute(name);
                results.add(new Attribute(name, newValue));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return results;
    }

    /**
     * @see DynamicMBean#invoke
     */
    public Object invoke(String actionName,
                         Object[] params,
                         String[] signature)
        throws MBeanException {

        /* Sanity checking. */
        if (actionName == null) {
            throw new IllegalArgumentException("ActionName can't be null.");
        }

        try {
            if (actionName.equals(OP_CLEAN)) {
                int numFiles = env.cleanLog();
                return new Integer(numFiles);
            } else if (actionName.equals(OP_EVICT)) {
                env.evictMemory();
                return null;
            } else if (actionName.equals(OP_CHECKPOINT)) {
                CheckpointConfig ckptConfig = new CheckpointConfig();
                if ((params != null) && (params.length > 0)) {
                    Boolean force = (Boolean) params[0];
                    ckptConfig.setForce(force.booleanValue());
                }
                env.checkpoint(ckptConfig);
                return null;
            } else if (actionName.equals(OP_SYNC)) {
                env.sync();
                return null;
            } else if (actionName.equals(OP_ENV_STAT)) {
                return env.getStats(getStatsConfig(params)).toString();
            } else if (actionName.equals(OP_TXN_STAT)) {
                return env.getTransactionStats
                    (getStatsConfig(params)).toString();
            } else if (actionName.equals(OP_DB_NAMES)) {
                return env.getDatabaseNames();
            } else if (actionName.equals(OP_DB_STAT)) {
                DatabaseStats stats = getDatabaseStats(params);
                return stats != null ? stats.toString() : null;
            } else if (actionName.equals(OP_GET_TIPS)) {
                return env.getStats
                    (getStatsConfig(new Object[] {false, true})).getTips();
            } else if (actionName.equals(OP_ENV_CONFIG)) {
                return env.getConfig().toString();
            }

            return new IllegalArgumentException
                ("ActionName: " + actionName + " is not valid.");
        } catch (DatabaseException e) {

            /*
             * Add the message for easiest deciphering of the problem. Since 
             * the original exception cannot be transferred, send the exception 
             * stack.
             */
            throw new MBeanException(new RuntimeException
                                     (e.getMessage() +
                                      LoggerUtils.getStackTrace(e)));
        }
    }

    /**
     * Helper to get statistics for a given database.
     *
     * @param params operation parameters
     * @return DatabaseStats object
     */
    private DatabaseStats getDatabaseStats(Object[] params)
        throws IllegalArgumentException, 
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
            db = env.openDatabase(null, dbName, dbConfig);

            return db.getStats(getStatsConfig(params));
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    @Override
    protected void doRegisterMBean(Environment env) 
        throws Exception {

        server.registerMBean(new JEMonitor(env), jeName);
    }

    @Override
    protected MBeanAttributeInfo[] getAttributeList() {
        ArrayList<MBeanAttributeInfo> attrList =
            new ArrayList<MBeanAttributeInfo>();

        if (env == null) {
            return null;
        }

        /* Add attributes for all JE Environments. */
        for (int i = 0; i < COMMON_ATTR.length; i++) {
            attrList.add(COMMON_ATTR[i]);
        }

        /* Add attributes for an open Environment. */
        for (int i = 0; i < OPEN_ATTR.length; i++) {
            attrList.add(OPEN_ATTR[i]);
        }

        /* Add attributes for an open, transactional Environment. */
        try {
            EnvironmentConfig config = env.getConfig();
            if (config.getTransactional()) {
                for (int i = 0; i < TRANSACTIONAL_ATTR.length; i++) {
                    attrList.add(TRANSACTIONAL_ATTR[i]);
                }
            }
        } catch (DatabaseException ignore) {
            /* ignore */
        }

        return attrList.toArray(new MBeanAttributeInfo[attrList.size()]);
    }

    @Override
    protected void addOperations() {
        if (env == null) {
            return;
        }

        operationList.add(OP_CLEAN_INFO);
        operationList.add(OP_EVICT_INFO);
        operationList.add(OP_ENV_STAT_INFO);
        operationList.add(OP_DB_NAMES_INFO);
        operationList.add(OP_DB_STAT_INFO);
        operationList.add(OP_ENV_CONFIG_INFO);

        /* Add checkpoint only for transactional Environments. */
        try {
            if (env.getConfig().getTransactional()) {
                operationList.add(OP_CHECKPOINT_INFO);
                operationList.add(OP_TXN_STAT_INFO);
            } else {
                operationList.add(OP_SYNC_INFO);
            }
        } catch (DatabaseException e) {
             /* Don't make any operations available. */
             operationList = new ArrayList<MBeanOperationInfo>();
             return;
        }
    }
}
