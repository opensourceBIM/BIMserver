/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

import com.sleepycat.je.config.ConfigParam;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Specifies the environment attributes that may be changed after the
 * environment has been opened.  EnvironmentMutableConfig is a parameter to
 * {@link Environment#setMutableConfig} and is returned by {@link
 * Environment#getMutableConfig}.
 *
 * <p>There are two types of mutable environment properties: per-environment
 * handle properties, and environment wide properties.</p>
 *
 * <h4>Per-Environment Handle Properties</h4>
 *
 * <p>Per-environment handle properties apply only to a single Environment
 * instance.  For example, to change the default transaction commit behavior
 * for a single environment handle, do this:</p>
 *
 * <blockquote><pre>
 *     // Specify no-sync behavior for a given handle.
 *     EnvironmentMutableConfig mutableConfig = myEnvHandle.getMutableConfig();
 *     mutableConfig.setTxnNoSync(true);
 *     myEnvHandle.setMutableConfig(mutableConfig);
 * </pre></blockquote>
 *
 * <p>The per-environment handle properties are listed below.  These properties
 * are accessed using the setter and getter methods listed, as shown in the
 * example above.</p>
 *
 * <ul>
 * <li>{@link #setDurability}, {@link #getDurability}</li>
 * <li>{@link #setTxnNoSync}, {@link #getTxnNoSync} <em>deprecated</em></li>
 * <li>{@link #setTxnWriteNoSync}, {@link #getTxnWriteNoSync} <em>deprecated</em></li>
 * </ul>
 *
 * <h4>Environment-Wide Mutable Properties</h4>
 *
 * <p>Environment-wide mutable properties are those that can be changed for an
 * environment as a whole, irrespective of which environment instance (for the
 * same physical environment) is used.  For example, to stop the cleaner daemon
 * thread, do this:</p>
 *
 * <blockquote><pre>
 *     // Stop the cleaner daemon thread for the environment.
 *     EnvironmentMutableConfig mutableConfig = myEnvHandle.getMutableConfig();
 *     mutableConfig.setConfigParam("je.env.runCleaner", "false");
 *     myEnvHandle.setMutableConfig(mutableConfig);
 * </pre></blockquote>
 *
 * <p>The environment-wide mutable properties are listed below.  These
 * properties are accessed using the {@link #setConfigParam} and {@link
 * #getConfigParam} methods, as shown in the example above, using the property
 * names listed below.  In some cases setter and getter methods are also
 * available.</p>
 *
 * <ul>
 * <li>je.maxMemory ({@link #setCacheSize}, {@link #getCacheSize})</li>
 * <li>je.maxMemoryPercent ({@link #setCachePercent},
 * {@link #getCachePercent})</li>
 * <li>je.env.runINCompressor</li>
 * <li>je.env.runEvictor</li>
 * <li>je.env.runCheckpointer</li>
 * <li>je.env.runCleaner</li>
 * </ul>
 *
 * <h4>Getting the Current Environment Properties</h4>
 *
 * To get the current "live" properties of an environment after constructing it
 * or changing its properties, you must call {@link Environment#getConfig} or
 * {@link Environment#getMutableConfig}.  The original EnvironmentConfig or
 * EnvironmentMutableConfig object used to set the properties is not kept up to
 * date as properties are changed, and does not reflect property validation or
 * properties that are computed. @see EnvironmentConfig
 */
public class EnvironmentMutableConfig implements Cloneable {

    /*
     * Change copyHandlePropsTo and Environment.copyToHandleConfig when adding
     * fields here.
     */
    private boolean txnNoSync = false;
    private boolean txnWriteNoSync = false;

    /**
     * @hidden
     * Cache size is a category of property that is calculated within the
     * environment.  It is only supplied when returning the cache size to the
     * application and never used internally; internal code directly checks
     * with the MemoryBudget class;
     */
    protected long cacheSize;

    /**
     * @hidden
     * Note that in the implementation we choose not to extend Properties in
     * order to keep the configuration type safe.
     */
    protected Properties props;

    /**
     * For unit testing, to prevent loading of je.properties.
     */
    private boolean loadPropertyFile = true;

    /**
     * Internal boolean that says whether or not to validate params.  Setting
     * it to false means that parameter value validatation won't be performed
     * during setVal() calls.  Only should be set to false by unit tests using
     * DbInternal.
     */
    boolean validateParams = true;

    private ExceptionListener exceptionListener = null;
    private CacheMode cacheMode;
    private CacheModeStrategy cacheModeStrategy;

    /**
     * An instance created using the default constructor is initialized with
     * the system's default settings.
     */
    public EnvironmentMutableConfig() {
        props = new Properties();
    }

    /**
     * Used by EnvironmentConfig to construct from properties.
     */
    EnvironmentMutableConfig(Properties properties)
        throws IllegalArgumentException {

        DbConfigManager.validateProperties(properties,
                                           false,  // isRepConfigInstance
                                           getClass().getName());
        /* For safety, copy the passed in properties. */
        props = new Properties();
        props.putAll(properties);
    }

    /**
     * Configures the database environment for asynchronous transactions.
     *
     * @param noSync If true, do not write or synchronously flush the log on
     * transaction commit. This means that transactions exhibit the ACI
     * (Atomicity, Consistency, and Isolation) properties, but not D
     * (Durability); that is, database integrity is maintained, but if the JVM
     * or operating system fails, it is possible some number of the most
     * recently committed transactions may be undone during recovery. The
     * number of transactions at risk is governed by how many updates fit into
     * a log buffer, how often the operating system flushes dirty buffers to
     * disk, and how often the database environment is checkpointed.
     *
     * <p>This attribute is false by default for this class and for the
     * database environment.</p>
     *
     * @deprecated replaced by {@link #setDurability}
     */
    public void setTxnNoSync(boolean noSync) {
        TransactionConfig.checkMixedMode
            (false, noSync, txnWriteNoSync, getDurability());
        txnNoSync = noSync;
    }

    /**
     * Returns true if the database environment is configured for asynchronous
     * transactions.
     *
     * @return true if the database environment is configured for asynchronous
     * transactions.
     *
     * @deprecated replaced by {@link #getDurability}
     */
    public boolean getTxnNoSync() {
        return txnNoSync;
    }

    /**
     * Configures the database environment for transactions which write but do
     * not flush the log.
     *
     * @param writeNoSync If true, write but do not synchronously flush the log
     * on transaction commit. This means that transactions exhibit the ACI
     * (Atomicity, Consistency, and Isolation) properties, but not D
     * (Durability); that is, database integrity is maintained, but if the
     * operating system fails, it is possible some number of the most recently
     * committed transactions may be undone during recovery. The number of
     * transactions at risk is governed by how often the operating system
     * flushes dirty buffers to disk, and how often the database environment is
     * checkpointed.
     *
     * <p>The motivation for this attribute is to provide a transaction that
     * has more durability than asynchronous (nosync) transactions, but has
     * higher performance than synchronous transactions.</p>
     *
     * <p>This attribute is false by default for this class and for the
     * database environment.</p>
     *
     * @deprecated replaced by {@link #setDurability}
     */
    public void setTxnWriteNoSync(boolean writeNoSync) {
        TransactionConfig.checkMixedMode
            (false, txnNoSync, writeNoSync, getDurability());
        txnWriteNoSync = writeNoSync;
    }

    /**
     * Returns true if the database environment is configured for transactions
     * which write but do not flush the log.
     *
     * @return true if the database environment is configured for transactions
     * which write but do not flush the log.
     *
     * @deprecated replaced by {@link #getDurability}
     */
    public boolean getTxnWriteNoSync() {
        return txnWriteNoSync;
    }

    /**
     * Configures the durability associated with transactions.
     * <p>
     * Equivalent to setting the je.txn.durability property in the
     * je.properties file.
     * </p>
     * @see Durability
     *
     * @param durability the new durability definition
     *
     * @return this
     */
    public EnvironmentMutableConfig setDurability(Durability durability) {
        TransactionConfig.checkMixedMode
            (false, txnNoSync, txnWriteNoSync, durability);

        if (durability == null) {
            props.remove(EnvironmentParams.JE_DURABILITY);
            return this;
        }
        DbConfigManager.setVal(props, EnvironmentParams.JE_DURABILITY,
                               durability.toString(),
                               validateParams);
        return this;
    }

    /**
     * Returns the durability associated with the configuration.
     *
     * @return the durability setting currently associated with this config.
     */
    public Durability getDurability() {
        String value = DbConfigManager.getVal(props,
                                              EnvironmentParams.JE_DURABILITY);
        return Durability.parse(value);
    }

    /**
     * Configures the memory available to the database system, in bytes.
     *
     * <p>Equivalent to setting the je.maxMemory property in the je.properties
     * file. The system will evict database objects when it comes within a
     * prescribed margin of the limit.</p>
     *
     * <p>By default, JE sets the cache size to:</p>
     *
     * <pre><blockquote>
     *         je.maxMemoryPercent *  JVM maximum memory
     * </pre></blockquote>
     *
     * <p>where JVM maximum memory is specified by the JVM -Xmx flag. However,
     * calling setCacheSize() with a non-zero value overrides the percentage
     * based calculation and sets the cache size explicitly.</p>
     *
     * <p>Note that the log buffer cache may be cleared if the cache size is
     * changed after the environment has been opened.</p>
     *
     * <p>If setSharedCache(true) is called, setCacheSize and setCachePercent
     * specify the total size of the shared cache, and changing these
     * parameters will change the size of the shared cache.</p>
     *
     * @param totalBytes The memory available to the database system, in bytes.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     *
     * @return this
     */
    public EnvironmentMutableConfig setCacheSize(long totalBytes)
        throws IllegalArgumentException {

        DbConfigManager.setVal(props, EnvironmentParams.MAX_MEMORY,
                               Long.toString(totalBytes), validateParams);
        return this;
    }

    /**
     * Returns the memory available to the database system, in bytes. A valid
     * value is only available if this EnvironmentConfig object has been
     * returned from Environment.getConfig();
     *
     * @return The memory available to the database system, in bytes.
     */
    public long getCacheSize() {

        /*
         * CacheSize is filled in from the EnvironmentImpl by way of
         * fillInEnvironmentGeneratedProps.
         */
        return cacheSize;
    }

    /**
     * <p>By default, JE sets its cache size proportionally to the JVM
     * memory. This formula is used:</p>
     *
     * <blockquote><pre>
     *         je.maxMemoryPercent *  JVM maximum memory
     * </pre></blockquote>
     *
     * <p>where JVM maximum memory is specified by the JVM -Xmx flag.
     * setCachePercent() specifies the percentage used and is equivalent to
     * setting the je.maxMemoryPercent property in the je.properties file.</p>
     *
     * <p>Calling setCacheSize() with a non-zero value overrides the percentage
     * based calculation and sets the cache size explicitly.</p>
     *
     * <p>Note that the log buffer cache may be cleared if the cache size is
     * changed after the environment has been opened.</p>
     *
     * <p>If setSharedCache(true) is called, setCacheSize and setCachePercent
     * specify the total size of the shared cache, and changing these
     * parameters will change the size of the shared cache.</p>
     *
     * @param percent The percent of JVM memory to allocate to the JE cache.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     *
     * @return this
     */
    public EnvironmentMutableConfig setCachePercent(int percent)
        throws IllegalArgumentException {

        DbConfigManager.setIntVal(props, EnvironmentParams.MAX_MEMORY_PERCENT,
                                  percent, validateParams);
        return this;
    }

    /**
     * Returns the percentage value used in the JE cache size calculation.
     *
     * @return the percentage value used in the JE cache size calculation.
     */
    public int getCachePercent() {

        return DbConfigManager.getIntVal(props,
                                         EnvironmentParams.MAX_MEMORY_PERCENT);
    }

    /**
     * Sets the exception listener for an Environment.  The listener is called
     * when a daemon thread throws an exception, in order to provide a
     * notification mechanism for these otherwise asynchronous exceptions.
     * Daemon thread exceptions are also printed through stderr.
     * <p>
     * Not all daemon exceptions are fatal, and the application bears
     * responsibility for choosing how to respond to the notification. Since
     * exceptions may repeat, the application should also choose how to handle
     * a spate of exceptions. For example, the application may choose to act
     * upon each notification, or it may choose to batch up its responses
     * by implementing the listener so it stores exceptions, and only acts
     * when a certain number have been received.
     * @param exceptionListener the callback to be executed when an exception
     * occurs.
     *
     * @return this
     */
    public EnvironmentMutableConfig
        setExceptionListener(ExceptionListener exceptionListener) {

        this.exceptionListener = exceptionListener;
        return this;
    }

    /**
     * Returns the exception listener, if set.
     */
    public ExceptionListener getExceptionListener() {
        return exceptionListener;
    }

    /**
     * Sets the default {@code CacheMode} used for operations performed in this
     * environment.  The default cache mode may be overridden on a per-database
     * basis using {@link DatabaseConfig#setCacheMode}, and on a per-record or
     * per-operation basis using {@link Cursor#setCacheMode}.
     *
     * @param cacheMode is the default {@code CacheMode} used for operations
     * performed in this environment.  If {@code null} is specified, {@link
     * CacheMode#DEFAULT} will be used.
     *
     * @see CacheMode for further details.
     *
     * @since 4.0.97
     */
    public void setCacheMode(final CacheMode cacheMode) {
        this.cacheMode = cacheMode;
    }

    /**
     * Returns the default {@code CacheMode} used for operations performed in
     * this environment, or null if {@link CacheMode#DEFAULT} is used.
     *
     * @return the default {@code CacheMode} used for operations performed on
     * this database, or null if {@link CacheMode#DEFAULT} is used.
     *
     * @see #setCacheMode
     *
     * @since 4.0.97
     */
    public CacheMode getCacheMode() {
        return cacheMode;
    }

    /**
     * @hidden
     * For internal use only.
     *
     * Sets the default {@code CacheModeStrategy} used for operations performed
     * in this environment.
     *
     * @param strategy is the {@code CacheModeStrategy} used for operations
     * performed in this environment.  If {@code null} is specified, then no
     * environment default will be available.
     *
     * @see CacheModeStrategy for further details.
     *
     * @since 4.0.97
     */
    public void setCacheModeStrategy(final CacheModeStrategy strategy) {
        cacheModeStrategy = strategy;
    }

    /**
     * @hidden
     * For internal use only.
     *
     * Returns the default {@code CacheModeStrategy} used for operations
     * performed in this environment, or null if the no environment default is
     * available.
     *
     * @return the default {@code CacheModeStrategy} used for operations
     * performed in this environment, or null if the no environment default is
     * available.
     *
     * @see #setCacheModeStrategy
     *
     * @since 4.0.97
     */
    public CacheModeStrategy getCacheModeStrategy() {
        return cacheModeStrategy;
    }

    /**
     * Set this configuration parameter. First validate the value specified for
     * the configuration parameter; if it is valid, the value is set in the
     * configuration.
     *
     * @param paramName the configuration parameter name, one of the String
     * constants in this class
     *
     * @param value The configuration value
     *
     * @return this
     *
     * @throws IllegalArgumentException if the paramName or value is invalid.
     */
    public EnvironmentMutableConfig setConfigParam(String paramName,
                                                   String value)
        throws IllegalArgumentException {

        DbConfigManager.setConfigParam(props,
                                       paramName,
                                       value,
                                       true, /* require mutability. */
                                       validateParams,
                                       false /* forReplication */,
                                       true  /* verifyForReplication */);
        return this;
    }

    /**
     * Returns the value for this configuration parameter.
     *
     * @param paramName a valid configuration parameter, one of the String
     * constants in this class.
     * @return the configuration value.
     * @throws IllegalArgumentException if the paramName is invalid.
     */
    public String getConfigParam(String paramName)
        throws IllegalArgumentException {

       return DbConfigManager.getConfigParam(props, paramName);
    }

    /**
     * @hidden
     * For internal use only.
     */
    public boolean isConfigParamSet(String paramName) {
        return props.containsKey(paramName);
    }

    /*
     * Helpers
     */
    void setValidateParams(boolean validateParams) {
        this.validateParams = validateParams;
    }

    /**
     * Checks that the immutable values in the environment config used to open
     * an environment match those in the config object saved by the underlying
     * shared EnvironmentImpl.
     * @param handleConfigProps are the config property values that were
     * specified by configuration object from the Environment.
     */
    void checkImmutablePropsForEquality(Properties handleConfigProps)
        throws IllegalArgumentException {

        Iterator<String> iter =
            EnvironmentParams.SUPPORTED_PARAMS.keySet().iterator();
        while (iter.hasNext()) {
            String paramName = iter.next();
            ConfigParam param =
                EnvironmentParams.SUPPORTED_PARAMS.get(paramName);
            assert param != null;
            if (!param.isMutable() && !param.isForReplication()) {
                String paramVal = props.getProperty(paramName);
                String useParamVal = handleConfigProps.getProperty(paramName);
                if ((paramVal != null) ?
                    (!paramVal.equals(useParamVal)) :
                    (useParamVal != null)) {
                    throw new IllegalArgumentException
                        (paramName + " is set to " +
                         useParamVal +
                         " in the config parameter" +
                         " which is incompatible" +
                         " with the value of " +
                         paramVal + " in the" +
                         " underlying environment");
                }
            }
        }
    }

    /**
     * @hidden
     * For internal use only.
     * Overrides Object.clone() to clone all properties, used by this class and
     * EnvironmentConfig.
     */
    @Override
    protected EnvironmentMutableConfig clone() {

        try {
            EnvironmentMutableConfig copy =
                (EnvironmentMutableConfig) super.clone();
            copy.props = (Properties) props.clone();
            return copy;
        } catch (CloneNotSupportedException willNeverOccur) {
            return null;
        }
    }

    /**
     * Used by Environment to create a copy of the application supplied
     * configuration. Done this way to provide non-public cloning.
     */
    EnvironmentMutableConfig cloneMutableConfig() {
        EnvironmentMutableConfig copy = (EnvironmentMutableConfig) clone();
        /* Remove all immutable properties. */
        copy.clearImmutableProps();
        return copy;
    }

    /**
     * Copies the per-handle properties of this object to the given config
     * object.
     */
    void copyHandlePropsTo(EnvironmentMutableConfig other) {
        other.txnNoSync = txnNoSync;
        other.txnWriteNoSync = txnWriteNoSync;
        other.setDurability(getDurability());
    }

    /**
     * Copies all mutable props to the given config object.
     * Unchecked suppress here because Properties don't play well with
     * generics in Java 1.5
     */
    @SuppressWarnings("unchecked")
    void copyMutablePropsTo(EnvironmentMutableConfig toConfig) {

        Properties toProps = toConfig.props;
        Enumeration propNames = props.propertyNames();
        while (propNames.hasMoreElements()) {
            String paramName = (String) propNames.nextElement();
            ConfigParam param =
                EnvironmentParams.SUPPORTED_PARAMS.get(paramName);
            assert param != null;
            if (param.isMutable()) {
                String newVal = props.getProperty(paramName);
                toProps.setProperty(paramName, newVal);
            }
        }
        toConfig.exceptionListener = this.exceptionListener;
        toConfig.cacheMode = this.cacheMode;
        toConfig.cacheModeStrategy = this.cacheModeStrategy;
    }

    /**
     * Fills in the properties calculated by the environment to the given
     * config object.
     */
    void fillInEnvironmentGeneratedProps(EnvironmentImpl envImpl) {
        cacheSize = envImpl.getMemoryBudget().getMaxMemory();
    }

   /**
    * Removes all immutable props.
    * Unchecked suppress here because Properties don't play well with
    * generics in Java 1.5
    */
    @SuppressWarnings("unchecked")
    private void clearImmutableProps() {
        Enumeration propNames = props.propertyNames();
        while (propNames.hasMoreElements()) {
            String paramName = (String) propNames.nextElement();
            ConfigParam param =
                EnvironmentParams.SUPPORTED_PARAMS.get(paramName);
            assert param != null;
            if (!param.isMutable()) {
                props.remove(paramName);
            }
        }
    }

    Properties getProps() {
        return props;
    }

    /**
     * For unit testing, to prevent loading of je.properties.
     */
    void setLoadPropertyFile(boolean loadPropertyFile) {
        this.loadPropertyFile = loadPropertyFile;
    }

    /**
     * For unit testing, to prevent loading of je.properties.
     */
    boolean getLoadPropertyFile() {
        return loadPropertyFile;
    }

    /**
     * Testing support
     * @hidden
     */
    public int getNumExplicitlySetParams() {
        return props.size();
    }

    /**
     * Display configuration values.
     */
    @Override
    public String toString() {
        return ("cacheSize=" + cacheSize + "\n" +
                "txnNoSync=" + txnNoSync + "\n" +
                "txnWriteNoSync=" + txnWriteNoSync + "\n" +
                props.toString() + "\n");
    }
}
