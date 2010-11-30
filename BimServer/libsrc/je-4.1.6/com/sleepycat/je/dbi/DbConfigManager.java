/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2000-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.DbInternal;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.config.BooleanConfigParam;
import com.sleepycat.je.config.ConfigParam;
import com.sleepycat.je.config.DurationConfigParam;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.config.IntConfigParam;
import com.sleepycat.je.config.LongConfigParam;
import com.sleepycat.je.config.ShortConfigParam;
import com.sleepycat.je.utilint.PropUtil;

/**
 * DbConfigManager holds the configuration parameters for an environment.
 *
 * In general, all configuration parameters are represented by a ConfigParam
 * defined in com.sleepycat.je.config.EnvironmentParams and can be represented
 * by a property described by the EnvironmentConfig String constants.
 * Environment parameters have some interesting twists because there are some
 * attributes that are scoped by handle, such as the commit durability
 * (txnSync, txnNoSync, etc) parameters.
 *
 * DbConfigManager is instantiated first by the EnvironmentImpl, and is loaded
 * with the base configuration parameters. If replication is enabled,
 * additional properties are added when the ReplicatedEnvironment is
 * instantiated. In order to keep replication code out of the base code,
 * replication parameters are loaded by way of the addConfigurations method.
 */
public class DbConfigManager {

    /*
     * The name of the JE properties file, to be found in the environment
     * directory.
     */
    private static final String PROPFILE_NAME = "je.properties";

    /*
     * All properties in effect for this JE instance, both environment
     * and replication environment scoped, are stored in this Properties field.
     */
    protected Properties props;

    /*
     * Save a reference to the environment config to access debug properties
     * that are fields in EnvironmentConfig, must be set before the
     * environment is created, and are not represented as JE properties.
     */
    private final EnvironmentConfig environmentConfig;

    public DbConfigManager(EnvironmentConfig config) {

        this.environmentConfig = config;

        if (config == null) {
            props = new Properties();
        } else {
            props = DbInternal.getProps(config);
        }
    }

    public EnvironmentConfig getEnvironmentConfig() {
        return environmentConfig;
    }

    /*
     * Parameter Access
     */

    /**
     * Get this parameter from the environment wide configuration settings.
     * @param configParam
     *
     * @return default for param if param wasn't explicitly set
     */
    public synchronized String get(ConfigParam configParam) {
        return getConfigParam(props, configParam.getName());
    }

    /**
     * Get this parameter from the environment wide configuration settings.
     *
     * @param configParam
     *
     * @return default for param if param wasn't explicitly set
     */
    public synchronized String get(String configParamName) {
        return getConfigParam(props, configParamName);
    }

    /**
     * Get this parameter from the environment wide configuration settings.
     *
     * @param configParam
     *
     * @return default for param if it wasn't explicitly set.
     */
    public boolean getBoolean(BooleanConfigParam configParam) {

        /* See if it's specified. */
        String val = get(configParam);
        return Boolean.valueOf(val).booleanValue();
    }

    /**
     * Get this parameter from the environment wide configuration settings.
     *
     * @param configParam
     * @return default for param if it wasn't explicitly set.
     */
    public short getShort(ShortConfigParam configParam) {

        /* See if it's specified. */
        String val = get(configParam);
        short shortValue = 0;
        if (val != null) {
            try {
                shortValue = Short.parseShort(val);
            } catch (NumberFormatException e) {

                /*
                 * This should never happen if we put error checking into
                 * the loading of config values.
                 */
                assert false: e.getMessage();
            }
        }
        return shortValue;
    }

    /**
     * Get this parameter from the environment wide configuration settings.
     *
     * @param configParam
     * @return default for param if it wasn't explicitly set.
     */
    public int getInt(IntConfigParam configParam) {

        /* See if it's specified. */
        String val = get(configParam);
        int intValue = 0;
        if (val != null) {
            try {
                intValue = Integer.parseInt(val);
            } catch (NumberFormatException e) {

                /*
                 * This should never happen if we put error checking into
                 * the loading of config values.
                 */
                assert false: e.getMessage();
            }
        }
        return intValue;
    }

    /**
     * Get this parameter from the environment wide configuration settings.
     *
     * @param configParam
     * @return default for param if it wasn't explicitly set
     */
    public long getLong(LongConfigParam configParam) {

        /* See if it's specified. */
        String val = get(configParam);
        long longValue = 0;
        if (val != null) {
            try {
                longValue = Long.parseLong(val);
            } catch (NumberFormatException e) {
                /*
                 * This should never happen if we put error checking
                 * into the loading of config values.
                 */
                assert false : e.getMessage();
            }
        }
        return longValue;
    }

    /**
     * Get this parameter from the environment wide configuration settings.
     *
     * @param configParam
     * @return default for param if it wasn't explicitly set.
     */
    public int getDuration(DurationConfigParam configParam) {
        String val = get(configParam);
        int millis = 0;
        if (val != null) {
            try {
                millis = PropUtil.parseDuration(val);
            } catch (IllegalArgumentException e) {

                /*
                 * This should never happen if we put error checking into
                 * the loading of config values.
                 */
                assert false: e.getMessage();
            }
        }
        return millis;
    }

    /*
     * Helper methods used by EnvironmentConfig and ReplicationConfig.
     */

    /**
     * Validate a collection of configurations, checking that
     *   - the name and value are valid
     *   - a replication param is not being set through an EnvironmentConfig
     * class, and a non-rep param is not set through a ReplicationConfig
     * instance.
     *
     * This may happen at Environment start time, or when configurations have
     * been mutated. The configurations have been collected from a file, or
     * from a Properties object, and haven't gone through the usual validation
     * path that occurs when XXXConfig.setConfigParam is called.
     *
     * SuppressWarnings is used here because Enumeration doesn't work well with
     * Properties in Java 1.5
     *
     * @throws IllegalArgumentException via XxxConfig(Properties) ctor.
     */
    @SuppressWarnings("unchecked")
    public static void validateProperties(Properties props,
                                          boolean isRepConfigInstance,
                                          String configClassName)
        throws IllegalArgumentException {

        /* Check that the properties have valid names and values. */
        Enumeration propNames = props.propertyNames();
        while (propNames.hasMoreElements()) {
            String name = (String) propNames.nextElement();
            /* Is this a valid property name? */
            ConfigParam param =
                EnvironmentParams.SUPPORTED_PARAMS.get(name);

            if (param == null) {

                /* See if the parameter is an multi-value parameter. */
                String mvParamName = ConfigParam.multiValueParamName(name);
                param = EnvironmentParams.SUPPORTED_PARAMS.get(mvParamName);
                if (param == null) {
                    throw new IllegalArgumentException
                        (name +
                         " is not a valid BDBJE environment configuration");
                }
            }

            /*
             * Only verify that the parameter is "for replication" if this is
             * being validated on behalf of a FooConfig class, not a
             * je.properties file.
             */
            if (configClassName != null) {
                /* We're validating a config instance, not a file. */
                if (isRepConfigInstance) {
                    if (!param.isForReplication()) {
                        throw new IllegalArgumentException
                            (name +
                             " is not a replication parameter and cannot " +
                             " be set through " + configClassName);
                    }
                } else {
                    if (param.isForReplication()) {
                        throw new IllegalArgumentException
                            (name +
                             " is a replication parameter and cannot be set " +
                             " through " + configClassName);
                    }
                }
            }

            /* Is this a valid property value? */
            param.validateValue(props.getProperty(name));
        }
    }

    /**
     * Apply the configurations specified in the je.properties file to override
     * the programmatically set configuration values held in the property bag.
     *
     * @throws IllegalArgumentException via XxxConfig(Properties) ctor.
     */
    @SuppressWarnings("unchecked")
    public static void applyFileConfig(File envHome,
                                       Properties props,
                                       boolean forReplication)
        throws IllegalArgumentException {

        File paramFile = null;
        try {
            Properties fileProps = new Properties();
            if (envHome != null) {
                if (envHome.isFile()) {
                    paramFile = envHome;
                } else {
                    paramFile = new File(envHome, PROPFILE_NAME);
                }
                FileInputStream fis = new FileInputStream(paramFile);
                fileProps.load(fis);
                fis.close();
            }

            /*
             * Validate the existing file. No config instance name is used
             * because we're validating a je.properties file.
             */
            validateProperties(fileProps,
                               false,
                               null); /* config instance name, don't use. */

            /* Add them to the configuration object. */
            Iterator iter = fileProps.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry propPair = (Map.Entry) iter.next();
                String name = (String) propPair.getKey();
                String value = (String) propPair.getValue();
                setConfigParam(props,
                               name,
                               value,
                               false, /* don't need mutability, we're
                                         initializing */
                               false, /* value already validated when set in
                                         config object */
                               forReplication,
                               false); /* verifyForReplication */
            }
        } catch (FileNotFoundException e) {

            /*
             * Klockwork - ok
             * Eat the exception, okay if the file doesn't exist.
             */
        } catch (IOException e) {
            IllegalArgumentException e2 = new IllegalArgumentException
                ("An error occurred when reading " + paramFile);
            e2.initCause(e);
            throw e2;
        }
    }

    /**
     * Helper method for environment and replication configuration classes.
     * Set a configuration parameter. Check that the name is valid.
     * If specified, also check that the value is valid.Value checking
     * may be disabled for unit testing.
     *
     * @param props Property bag held within the configuration object.
     *
     * @throws IllegalArgumentException via XxxConfig.setXxx methods and
     * XxxConfig(Properties) ctor.
     */
    public static void setConfigParam(Properties props,
                                      String paramName,
                                      String value,
                                      boolean requireMutability,
                                      boolean validateValue,
                                      boolean forReplication,
                                      boolean verifyForReplication)
        throws IllegalArgumentException {

        boolean isMVParam = false;

        /* Is this a valid property name? */
        ConfigParam param =
            EnvironmentParams.SUPPORTED_PARAMS.get(paramName);

        if (param == null) {
            /* See if the parameter is an multi-value parameter. */
            String mvParamName = ConfigParam.multiValueParamName(paramName);
            param = EnvironmentParams.SUPPORTED_PARAMS.get(mvParamName);
            if (param == null ||
                !param.isMultiValueParam()) {
                throw new IllegalArgumentException
                    (paramName +
                     " is not a valid BDBJE environment parameter");
            }
            isMVParam = true;
            assert param.isMultiValueParam();
        }

        /*
         * Only verify that the parameter is "for replication" if this is
         * being validated on behalf of a FooConfig class, not a
         * je.properties file.
         */
        if (verifyForReplication) {
            if (forReplication) {
                if (!param.isForReplication()) {
                    throw new IllegalArgumentException
                        (paramName +
                         " is not a replication parameter.");
                }
            } else {
                if (param.isForReplication()) {
                    throw new IllegalArgumentException
                        (paramName +
                         " is a replication parameter and cannot be " +
                         " set through this configuration class.");
                }
            }
        }

        /* Is this a mutable property? */
        if (requireMutability && !param.isMutable()) {
            throw new IllegalArgumentException
                (paramName +
                 " is not a mutable BDBJE environment configuration");
        }

        if (isMVParam) {
            setVal(props, param, paramName, value, validateValue);
        } else {
            setVal(props, param, value, validateValue);
        }
    }

    /**
     * Helper method for environment and replication configuration classes.
     * Get the configuration value for the specified parameter, checking
     * that the parameter name is valid.
     *
     * @param props Property bag held within the configuration object.
     *
     * @throws IllegalArgumentException via XxxConfig.getConfigParam.
     */
    public static String getConfigParam(Properties props, String paramName)
        throws IllegalArgumentException {

        boolean isMVParam = false;

        /* Is this a valid property name? */
        ConfigParam param = EnvironmentParams.SUPPORTED_PARAMS.get(paramName);

        if (param == null) {

            /* See if the parameter is an multi-value parameter. */
            String mvParamName = ConfigParam.multiValueParamName(paramName);
            param = EnvironmentParams.SUPPORTED_PARAMS.get(mvParamName);
            if (param == null) {
                throw new IllegalArgumentException
                    (paramName +
                     " is not a valid BDBJE environment configuration");
            }
            isMVParam = true;
            assert param.isMultiValueParam();
        } else if (param.isMultiValueParam()) {
            throw new IllegalArgumentException
                ("Use getMultiValueValues() to retrieve Multi-Value " +
                 "parameter values.");
        }

        if (isMVParam) {
            return DbConfigManager.getVal(props, param, paramName);
        }
        return DbConfigManager.getVal(props, param);
    }

    /**
     * Helper method for environment and replication configuration classes.
     * Gets either the value stored in this configuration or the
     * default value for this param.
     */
    public static String getVal(Properties props,
                                ConfigParam param) {
        String val = props.getProperty(param.getName());
        if (val == null) {
            val = param.getDefault();
        }
        return val;
    }

    /**
     * Helper method for environment and replication configuration classes.
     * Gets either the value stored in this configuration or the
     * default value for this param.
     */
    public static String getVal(Properties props,
                                ConfigParam param,
                                String paramName) {
        String val = props.getProperty(paramName);
        if (val == null) {
            val = param.getDefault();
        }
        return val;
    }

    /**
     * Helper method for environment and replication configuration classes.
     * Set and validate the value for the specified parameter.
     */
    public static void setVal(Properties props,
                              ConfigParam param,
                              String val,
                              boolean validateValue)
        throws IllegalArgumentException {

        if (validateValue) {
            param.validateValue(val);
        }
        props.setProperty(param.getName(), val);
    }

    /**
     * Helper method for environment and replication configuration classes.
     * Set and validate the value for the specified parameter.
     */
    public static void setVal(Properties props,
                              ConfigParam param,
                              String paramName,
                              String val,
                              boolean validateValue)
        throws IllegalArgumentException {

        if (validateValue) {
            param.validateValue(val);
        }
        props.setProperty(paramName, val);
    }

    /**
     * Helper method for getting integer values.
     */
    public static int getIntVal(Properties props, IntConfigParam param) {
        String val = DbConfigManager.getVal(props, param);
        if (val == null) {
            throw EnvironmentFailureException.unexpectedState
                ("No value for " + param.getName());
        }
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw EnvironmentFailureException.unexpectedState
                ("Bad value for " + param.getName()+ ": " + e.getMessage());
        }
    }

    /**
     * Helper method for setting integer values.
     */
    public static void setIntVal(Properties props,
                                 IntConfigParam param,
                                 int val,
                                 boolean validateValue) {
        setVal(props, param, Integer.toString(val), validateValue);
    }

    /**
     * Helper method for getting boolean values.
     */
    public static boolean getBooleanVal(Properties props,
                                        BooleanConfigParam param) {
        String val = DbConfigManager.getVal(props, param);
        if (val == null) {
            throw EnvironmentFailureException.unexpectedState
                ("No value for " + param.getName());
        }
        return Boolean.parseBoolean(val);
    }

    /**
     * Helper method for setting boolean values.
     */
    public static void setBooleanVal(Properties props,
                                     BooleanConfigParam param,
                                     boolean val,
                                     boolean validateValue) {
        setVal(props, param, Boolean.toString(val), validateValue);
    }

    /**
     * Helper method for getting duration values.
     */
    public static long getDurationVal(Properties props,
                                      DurationConfigParam param,
                                      TimeUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException
                ("TimeUnit argument may not be null");
        }
        String val = DbConfigManager.getVal(props, param);
        if (val == null) {
            throw EnvironmentFailureException.unexpectedState
                ("No value for " + param.getName());
        }
        try {
            return unit.convert(PropUtil.parseDuration(val),
                                TimeUnit.MILLISECONDS);
        } catch (IllegalArgumentException e) {
            throw EnvironmentFailureException.unexpectedState
                ("Bad value for " + param.getName()+ ": " + e.getMessage());
        }
    }

    /**
     * Helper method for setting duration values.
     */
    public static void setDurationVal(Properties props,
                                      DurationConfigParam param,
                                      long val,
                                      TimeUnit unit,
                                      boolean validateValue) {
        setVal(props, param, PropUtil.formatDuration(val, unit),
               validateValue);
    }
}
