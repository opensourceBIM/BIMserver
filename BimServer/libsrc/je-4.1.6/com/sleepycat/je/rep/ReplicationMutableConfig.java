/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.util.Enumeration;
import java.util.Properties;

import com.sleepycat.je.Durability;
import com.sleepycat.je.config.ConfigParam;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.RepParams;

/**
 * Specifies the attributes that may be changed after a {@link
 * ReplicatedEnvironment} has been created. {@code ReplicationMutableConfig} is
 * a parameter to {@link ReplicatedEnvironment#setMutableConfig} and is
 * returned by {@link ReplicatedEnvironment#getMutableConfig}.
 */
public class ReplicationMutableConfig implements Cloneable {

    /**
     * Identifies the Primary node in a two node group. See the discussion of
     * issues when
     * {@link <a href= "{@docRoot}/../ReplicationGuide/lifecycle.html#twonode">
     * configuring two node groups</a>}
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>False</td>
     * </tr>
     * </table></p>
     */
    public static final String DESIGNATED_PRIMARY = "je.rep.designatedPrimary";

    /**
     * An escape mechanism to modify the way in which the number of electable
     * nodes, and consequently the quorum requirements for elections and commit
     * acknowledgments, is calculated. The override is accomplished by
     * specifying the quorum size via this mutable configuration parameter.
     * <p>
     * When this parameter is set to a non-zero value at a member node, the
     * member will use this value as the electable group size, instead of using
     * the metadata stored in the RepGroup database for its quorum
     * calculations.  This parameter's value should be set to the number of
     * nodes known to be available. The default value is zero, which indicates
     * normal operation with the electable group size being calculated from the
     * metadata.
     *<p>
     * Please keep in mind that this is an escape mechanism, only for use in
     * exceptional circumstances, to be used with care. Since JE HA is no
     * longer maintaining quorum requirements automatically, there is the
     * possibility that the simple majority of unavailable nodes could elect
     * their own Master, which would result in a diverging set of changes to
     * the same environment being made by multiple Masters. It is essential to
     * ensure that the problematic nodes are in fact down before making this
     * temporary configuration change.
     *
     * See the discussion in {@link <a href=
     * "{@docRoot}/../ReplicationGuide/election-override.html">Appendix:
     * Managing a Failure of the Majority</a>}.
     * <p>
     * <table border="1">
     * <tr>
     * <td>Name</td>
     * <td>Type</td>
     * <td>Mutable</td>
     * <td>Default</td>
     * </tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>0</td>
     * </tr>
     * </table>
     * </p>
     *
     * @see QuorumPolicy
     * @see com.sleepycat.je.Durability.ReplicaAckPolicy
     */
    public static final String ELECTABLE_GROUP_SIZE_OVERRIDE =
        "je.rep.electableGroupSizeOverride";

    /**
     * The election priority associated with this node. The election algorithm
     * for choosing a new master will pick the participating node that has the
     * most current set of log files. When there is a tie, the election
     * priority is used as a tie-breaker to select amongst these nodes.
     * <p>
     * A priority of zero is used to ensure that this node is never elected
     * master, even if it has the most up to date log files. Note that the node
     * still votes for a Master and participates in quorum requirements. Please
     * use this option with care, since it means that some node with less
     * current log files could be elected master. As a result, this node would
     * be forced to rollback committed data and must be prepared to handle any
     * {@link RollbackException} exceptions that might be thrown.
     *
     * <p>
     * <table border="1">
     * <tr>
     * <td>Name</td>
     * <td>Type</td>
     * <td>Mutable</td>
     * <td>Default</td>
     * <td>Minimum</td>
     * <td>Maximum</td>
     * </tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>1</td>
     * <td>0</td>
     * <td>Integer.MAX_VALUE</td>
     * </tr>
     * </table>
     * </p>
     *
     * @see RollbackException
     */
    public static final String NODE_PRIORITY = "je.rep.node.priority";

    /**
     * If true, JE HA (replication) will flush all committed transactions to
     * disk at the specified time interval. This is of interest because the
     * default durability for replicated transactions of {@link
     * Durability#COMMIT_NO_SYNC}. The default for this behavior is true.
     * <p>
     * When using {@link Durability#COMMIT_NO_SYNC}, continued activity will
     * naturally cause the steady flush of committed transactions, but a pause
     * in activity may cause the latest commits to stay in memory. In such a
     * case, it is unlikely but possible that all members of the replication
     * group have these last transactions in memory and that no members have
     * persisted them to disk. A catastrophic failure of all nodes in the
     * replication group would cause a loss of these transactions, in this
     * unlikely scenario. This background flush task will reduce such a
     * possibility.
     * <P>
     * Note that enabling this feature when using {@link
     * Durability#COMMIT_NO_SYNC}, does not constitute a guarantee that
     * updates made by a transaction are persisted. For an explicit guarantee,
     * transactions should use {@link Durability#COMMIT_SYNC} or {@link
     * Durability#COMMIT_WRITE_NO_SYNC}. These more stringent, persistent
     * Durability options can be set at the environment or per-transaction
     * scope. Using one of these Durability settings for a given transaction
     * will also flush all commits that occurred earlier in time.
     * <p>
     * <table border="1">
     * <tr>
     * <td>Name</td>
     * <td>Type</td>
     * <td>Mutable</td>
     * <td>Default</td>
     * </tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>true</td>
     * </tr>
     * </table>
     * </p>
     */
    public static final String RUN_LOG_FLUSH_TASK = "je.rep.runLogFlushTask";

    /**
     * The interval that JE HA will do a log buffer flush.
     * <p>
     * <table border="1">
     * <tr>
     * <td>Name</td>
     * <td>Type</td>
     * <td>Mutable</td>
     * <td>Default</td>
     * <td>Minimum</td>
     * <td>Maximum</td>
     * </tr>
     * <tr>
     * <td>{@value}</td>
     * <td>
     * {@link <a href="../EnvironmentConfig.html#timeDuration">Duration</a>}
     * </td>
     * <td>Yes</td>
     * <td>5 min</td>
     * <td>1 s</td>
     * <td>-none-</td>
     * </tr>
     * </table>
     * </p>
     *
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String LOG_FLUSH_TASK_INTERVAL =
        "je.rep.logFlushTaskInterval";

    static {
        /*
         * Force loading when a ReplicationConfig is used with strings and
         * an environment has not been created.
         */

        @SuppressWarnings("unused")
            ConfigParam forceLoad = RepParams.GROUP_NAME;
    }

    /**
     * @hidden
     * Storage for replication related properties.
     */
    protected Properties props;

    /* For unit testing only: only ever set false when testing. */
    boolean validateParams = true;

    /**
     * Create a ReplicationMutableConfig initialized with the system
     * default settings. Parameter defaults are documented with the string
     * constants in this class.
     */
    public ReplicationMutableConfig() {
        props = new Properties();
    }

    /**
     * Used by ReplicationConfig to support construction from a property file.
     * @param properties Hold replication related properties
     */
    ReplicationMutableConfig(Properties properties, boolean validateParams)
        throws IllegalArgumentException {

        this.validateParams = validateParams;
        validateProperties(properties);
        /* For safety, copy the passed in properties. */
        props = new Properties();
        props.putAll(properties);
    }

    /**
     * Fills in the properties calculated by the environment to the given
     * config object.
     */
    void fillInEnvironmentGeneratedProps(RepImpl repImpl) {
        props.put(RepParams.DESIGNATED_PRIMARY.getName(),
                  Boolean.toString(repImpl.isDesignatedPrimary()));
        props.put(RepParams.NODE_PRIORITY.getName(),
                  Integer.toString(getNodePriority()));
    }

    /**
     * @hidden
     * For internal use only
     */
    public void copyMutablePropsTo(ReplicationMutableConfig toConfig) {

        Properties toProps = toConfig.props;
        Enumeration<?> propNames = props.propertyNames();
        while (propNames.hasMoreElements()) {
            String paramName = (String) propNames.nextElement();
            ConfigParam param =
                EnvironmentParams.SUPPORTED_PARAMS.get(paramName);
            assert param != null;
            if (param.isForReplication() &&
                param.isMutable()) {
                String newVal = props.getProperty(paramName);
                toProps.setProperty(paramName, newVal);
            }
        }
    }

    /**
     * If {@code isPrimary} is true, designate this node as a Primary. The
     * application must ensure that exactly one node is designated to be a
     * Primary at any given time. Primary node configuration is only a concern
     * when the group has two nodes, and there cannot be a simple majority. See
     * the overview on {@link <a href=
     * "{@docRoot}/../ReplicationGuide/lifecycle.html#twonode"> configuring two
     * node groups</a>}
     *
     * @param isPrimary true if this node is to be made the Primary.
     *
     * @return this;
     */
    public ReplicationMutableConfig setDesignatedPrimary(boolean isPrimary) {
        DbConfigManager.setBooleanVal(props, RepParams.DESIGNATED_PRIMARY,
                                      isPrimary, validateParams);
        return this;
    }

    /**
     * Determines whether this node is the currently designated Primary.  See
     * the overview on {@link <a href=
     * "{@docRoot}/../ReplicationGuide/lifecycle.html#twonode"> issues around
     * two node groups</a>}
     * @return true if this node is a Primary, false otherwise.
     */
    public boolean getDesignatedPrimary() {
        return DbConfigManager.getBooleanVal(props,
                                             RepParams.DESIGNATED_PRIMARY);
    }

    /**
     * Returns the value associated with the override. A value of zero means
     * that the number of electable nodes is determined as usual, that is, from
     * the contents of the group metadata.
     *
     * @return the number of electable nodes as specified by the override
     *
     * @see #ELECTABLE_GROUP_SIZE_OVERRIDE
     */
    public int getElectableGroupSizeOverride() {
        return DbConfigManager.
            getIntVal(props, RepParams.ELECTABLE_GROUP_SIZE_OVERRIDE);
    }

    /**
     * Sets the size used to determine the number of electable nodes.
     *
     * @param override the number of electable nodes. A value of zero means
     * that the number of electable nodes is determined as usual, that is, from
     * the contents of the group metadata.
     *
     * @return this
     *
     * @see #ELECTABLE_GROUP_SIZE_OVERRIDE
     */
    public ReplicationMutableConfig
        setElectableGroupSizeOverride(int override) {

        DbConfigManager.
            setIntVal(props, RepParams.ELECTABLE_GROUP_SIZE_OVERRIDE, override,
                      validateParams);
        return this;
    }

    /**
     * Returns the election priority associated with the node.
     *
     * @return the priority for this node
     *
     * @see #NODE_PRIORITY
     */
    public int getNodePriority() {
        return DbConfigManager.getIntVal(props, RepParams.NODE_PRIORITY);
    }

    /**
     * Sets the election priority for the node. The algorithm for choosing a
     * new master will pick the participating node that has the most current
     * set of log files. When there is a tie, the priority is used as a
     * tie-breaker to select amongst these nodes.
     * <p>
     * A priority of zero is used to ensure that a node is never elected
     * master, even if it has the most current set of files. Please use this
     * option with caution, since it means that a node with less current log
     * files could be elected master potentially forcing this node to rollback
     * data that had been committed.
     *
     * @param priority the priority to be associated with the node. It must be
     * zero, or a positive number.
     *
     * @see #NODE_PRIORITY
     */
    public ReplicationMutableConfig setNodePriority(int priority) {
        DbConfigManager.setIntVal(props, RepParams.NODE_PRIORITY, priority,
                                  validateParams);
        return this;
    }

    /**
     * Set this configuration parameter with this value. Values are validated
     * before setting the parameter.
     *
     * @param paramName the configuration parameter name, one of the String
     * constants in this class
     * @param value the configuration value.
     *
     * @return this;
     *
     * @throws IllegalArgumentException if the paramName or value is invalid.
     */
    public ReplicationMutableConfig setConfigParam(String paramName,
                                                   String value)
        throws IllegalArgumentException {

        DbConfigManager.setConfigParam(props,
                                       paramName,
                                       value,
                                       true,   /* require mutability. */
                                       validateParams,
                                       true,   /* forReplication */
                                       true);  /* verifyForReplication */
        return this;
    }

    /**
     * Return the value for this parameter.
     * @param paramName a valid configuration parameter, one of the String
     * constants in this class.
     * @return the configuration value.
     *
     * @throws IllegalArgumentException if the paramName is invalid.
     */
    public String getConfigParam(String paramName)
        throws IllegalArgumentException {

        return DbConfigManager.getConfigParam(props, paramName);
    }

    /**
     * Validate a property bag passed in a construction time.
     */
    void validateProperties(Properties checkProps)
        throws IllegalArgumentException {

        /* Check that the properties have valid names and values */
        Enumeration<?> propNames = checkProps.propertyNames();
        while (propNames.hasMoreElements()) {
            String name = (String) propNames.nextElement();
            /* Is this a valid property name? */
            ConfigParam param =
                EnvironmentParams.SUPPORTED_PARAMS.get(name);
            if (param == null) {
                throw new IllegalArgumentException
                (name + " is not a valid JE environment configuration");
            }
            /* Is this a valid property value? */
            if (validateParams) {
                param.validateValue(checkProps.getProperty(name));
            }
        }
    }

    /**
     * @hidden
     * For internal use only.
     * Access the internal property bag, used during startup.
     */
    public Properties getProps() {
        return props;
    }

    /**
     * List the configuration parameters and values that have been set
     * in this configuration object.
     */
    @Override
    public String toString() {
        return props.toString();
    }

    /**
     * For unit testing only
     */
    void setOverrideValidateParams(boolean validateParams) {
        this.validateParams = validateParams;
    }

    /**
     * @hidden
     * For testing only
     */
    public boolean  getValidateParams() {
        return validateParams;
    }

    /**
     * @hidden
     * For internal use only.
     * Overrides Object.clone() to clone all properties, used by this class and
     * ReplicationConfig.
     */
    @Override
    protected Object clone()
        throws CloneNotSupportedException {

        ReplicationMutableConfig copy =
            (ReplicationMutableConfig) super.clone();
        copy.props = (Properties) props.clone();
        return copy;
    }
}
