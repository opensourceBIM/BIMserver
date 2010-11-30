/**
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.net.InetSocketAddress;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.RepConfigProxy;
import com.sleepycat.je.rep.impl.RepParams;
import com.sleepycat.je.rep.utilint.HostPortPair;
import com.sleepycat.je.rep.utilint.RepUtils;

/**
 * Specifies the immutable attributes of a replicated environment.
 * <p>
 * To change the default settings for a replicated environment, an application
 * creates a configuration object, customizes settings and uses it for {@link
 * ReplicatedEnvironment} construction. The set methods of this class validate
 * the configuration values when the method is invoked.  An
 * IllegalArgumentException is thrown if the value is not valid for that
 * attribute.
 * <p>
 * Note that ReplicationConfig only describes those attributes which must be
 * set at {@code ReplicatedEnvironment} construction time, while its superclass
 * {@link ReplicationMutableConfig} describes attributes that may be modified
 * during the life of the replication group.
 * <p>
 * ReplicationConfig follows precedence rules similar to those of
 * {@link EnvironmentConfig}.
 * <ol>
 * <li>Configuration parameters specified
 * in {@literal <environmentHome>/je.properties} take first precedence.</li>
 * <li>Configuration parameters set in the ReplicationConfig object used
 * at {@code ReplicatedEnvironment} construction are next.</li>
 * <li>Any configuration parameters not set by the application are set to
 * system defaults, described along with the parameter name String constants
 * in this class.</li>
 *</ol>
 * <p>
 * After a {@code ReplicatedEnvironment} has been constructed, its mutable
 * properties may be changed using {@code
 * ReplicatedEnvironment#setMutableConfig}.  See {@code
 * ReplicationMutableConfig} for a list of mutable properties; all other
 * properties are immutable.  Whether a property is mutable or immutable is
 * also described along with the parameter name String constants in this class.
 *
 * <h4>Getting the Current ReplicatedEnvironment Properties</h4>
 *
 * To get the current "live" properties of a replicated environment after
 * constructing it or changing its properties, you must call {@link
 * ReplicatedEnvironment#getRepConfig} or {@link
 * ReplicatedEnvironment#getRepMutableConfig}.  The original ReplicationConfig
 * or ReplicationMutableConfig object used to set the properties is not kept up
 * to date as properties are changed, and does not reflect property validation
 * or properties that are computed.
 */
public class ReplicationConfig extends ReplicationMutableConfig
    implements RepConfigProxy {

    /**
     * The name for the replication group. The name must be made up of just
     * alpha numeric characters and must not be zero length.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"DefaultGroup"</td>
     * </tr>
     * </table></p>
     * @see ReplicationConfig#setGroupName
     * @see ReplicationConfig#getGroupName
     */
    public static final String GROUP_NAME = "je.rep.groupName";

    /**
     * The node name uniquely identifies this node within the replication group.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"DefaultRepNodeName"</td>
     * </tr>
     * </table></p>
     * @see ReplicationConfig#setNodeName
     * @see ReplicationConfig#getNodeName
     */
    public static final String NODE_NAME = "je.rep.nodeName";

    /**
     * The type of this node.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link NodeType}</td>
     * <td>No</td>
     * <td>ELECTABLE</td>
     * </tr>
     * </table></p>
     * @see ReplicationConfig#setNodeType
     * @see ReplicationConfig#getNodeType
     */
    public static final String NODE_TYPE= "je.rep.nodeType";

    /**
     * The string identifying one or more helper host and port pairs in
     * this format:
     * <pre>
     * hostname[:port][,hostname[:port]]*
     * </pre>
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>""</td>
     * </tr>
     * </table></p>
     * @see ReplicationConfig#setHelperHosts
     * @see ReplicationConfig#getHelperHosts
     */
    public static final String HELPER_HOSTS = "je.rep.helperHosts";

    /**
     * The default port used for replication.
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>5001</td>
     * <td>1024</td>
     * <td>Short.MAX_VALUE</td>
     * </tr>
     * </table></p>
     */
    public static final String DEFAULT_PORT = "je.rep.defaultPort";

    /**
     * Names the hostname and port associated with this node in the
     * replication group, e.g. je.rep.nodeHostPort=foo.com:5001.
     * <p>
     * The hostname is defaulted to "localhost" to make it easy to prototype
     * and to execute the examples, but the user should be very sure to set a
     * specific hostname before starting nodes on multiple machines. The value
     * of je.rep.nodeHostPort is saved persistently in replication group metadata
     * and is expected to be a unique address, and a value of "localhost" in
     * the replication metadata will cause severe communication confusion.
     * <p>
     * The port portion of the host value is optional. If it's not specified,
     * the value of "je.rep.defaultPort" is used.
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"localhost"</td>
     * </tr>
     * </table></p>
     * @see ReplicationConfig#setNodeHostPort
     * @see ReplicationConfig#getNodeHostPort
     */
    public static final String NODE_HOST_PORT = "je.rep.nodeHostPort";

    /**
     * The default consistency policy used by a replica. Only two
     * policies are meaningful as properties denoting environment level default
     * policies: {@link NoConsistencyRequiredPolicy} and
     * {@link TimeConsistencyPolicy}.  They
     * can be specified as:
     * <pre>  NoConsistencyRequiredPolicy</pre>
     * or
     * <pre>  {@code TimeConsistencyPolicy(<permissibleLag>,<timeout>)}</pre>
     * where {@code <permissibleLag>} and {@code <timeout>} are {@link <a
     * href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>}.
     * <p>
     * For example, a time based consistency policy with a lag of one second
     * and a timeout of one hour is denoted by the string:
     * {@code TimeConsistencyPolicy(1 s,1 h)}
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"TimeConsistencyPolicy(1 s,1 h)"</td>
     * </tr>
     * </table></p>
     *
     * @see ReplicationConfig#setConsistencyPolicy
     * @see ReplicationConfig#getConsistencyPolicy
     * @see com.sleepycat.je.TransactionConfig#setConsistencyPolicy
     * @see com.sleepycat.je.TransactionConfig#getConsistencyPolicy
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String CONSISTENCY_POLICY = "je.rep.consistencyPolicy";

    /**
     * The maximum amount of time the replication group guarantees preservation
     * of the log files constituting the replication stream. After this period
     * of time, nodes are free to do log cleaning and to remove log files
     * earlier than this period. If a node has crashed and does not re-join the
     * group within this timeout period it may need to perform a network
     * restore operation to catch up.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>
     * {@link <a href="../EnvironmentConfig.html#timeDuration">Duration</a>}
     * </td>
     * <td>No</td>
     * <td>24 h</td>
     * <td>0</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     *
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String REP_STREAM_TIMEOUT = "je.rep.repStreamTimeout";

    /**
     * The maximum amount of time for a replay transaction to wait for a lock.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>
     * {@link <a href="../EnvironmentConfig.html#timeDuration">Duration</a>}
     * </td>
     * <td>No</td>
     * <td>500 ms</td>
     * <td>1 ms</td>
     * <td>75 min</td>
     * </tr>
     * </table></p>
     *
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String REPLAY_TXN_LOCK_TIMEOUT =
        "je.rep.replayTxnLockTimeout";

    /**
     * The amount of time to wait for a Replica to become consistent with the
     * Master, when a <code>ReplicatedEnvironment</code> handle is created and
     * no <code>ConsistencyPolicy</code> is specified. If the Replica does not
     * become consistent within this period, a
     * <code>ReplicaConsistencyException</code> is thrown by the
     * <code>ReplicatedEnvironment</code> constructor.
     * <p>
     * If an explicit <code>ConsistencyPolicy</code> is specified via a
     * constructor argument, then the timeout defined by the
     * <code>ConsistencyPolicy</code> argument is used instead of this default.
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
     * <td>No</td>
     * <td>5 min</td>
     * <td>10 ms</td>
     * <td>-none-</td>
     * </tr>
     * </table>
     * </p>
     *
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String ENV_CONSISTENCY_TIMEOUT =
        "je.rep.envConsistencyTimeout";

    /**
     * The amount of time that the
     * {@link com.sleepycat.je.Transaction#commit(com.sleepycat.je.Durability)}
     * on the Master will wait for a sufficient number of acknowledgments from
     * the Replicas. If the Master does not receive a sufficient number of
     * acknowledgments within this timeout period, the <code>commit()</code>
     * will throw {@link InsufficientAcksException}. In the special case of a
     * two node group, if this node is the designated <code>Primary</code>,
     * the <code>Primary</code> will be <code>activated</code>, and the
     * <code>commit()</code> will proceed normally instead of throwing an
     * exception.
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
     * <td>No</td>
     * <td>5 s</td>
     * <td>10 ms</td>
     * <td>-none-</td>
     * </tr>
     * </table>
     * </p>
     *
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     * @see ReplicationMutableConfig#DESIGNATED_PRIMARY
     */
    public static final String REPLICA_ACK_TIMEOUT =
        "je.rep.replicaAckTimeout";

    /**
     * The amount of time that a
     * {@link ReplicatedEnvironment#beginTransaction(com.sleepycat.je.Transaction, com.sleepycat.je.TransactionConfig)}
     * on the Master will wait for a sufficient number of Replicas, as
     * determined by the default <code>Durability</code> policy, to contact the
     * Master. If the timeout period expires before a sufficient number of
     * Replicas contact the Master, the
     * {@link ReplicatedEnvironment#beginTransaction(com.sleepycat.je.Transaction, com.sleepycat.je.TransactionConfig)}
     * will throw {@link InsufficientReplicasException}. In the special case of
     * a two node group, if this node is the designated <code>Primary</code>,
     * the <code>Primary</code> will be <code>activated</code>, and the
     * <code>beginTransaction()</code> will proceed normally instead of
     * throwing an exception.
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
     * <td>No</td>
     * <td>10 s</td>
     * <td>10 ms</td>
     * <td>-none-</td>
     * </tr>
     * </table>
     * </p>
     *
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     * @see ReplicationMutableConfig#DESIGNATED_PRIMARY
     */
    public static final String INSUFFICIENT_REPLICAS_TIMEOUT =
        "je.rep.insufficientReplicasTimeout";

    /**
     * The maximum message size which will be accepted by a node (to prevent
     * DOS attacks).  While the default shown here is 0, it dynamically
     * calculated when the node is created and is set to the half of the
     * environment cache size. The cache size is mutable, but changing the
     * cache size at run time (after environment initialization) will not
     * change the value of this parameter.  If a value other than cache size /
     * 2 is desired, this non-mutable parameter should be specified at
     * initialization time.
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>No</td>
     * <td>half of cache size</td>
     * <td>256KB</td>
     * <td>Long.MAX_VALUE</td>
     * </tr>
     * </table></p>
     */
    public static final String MAX_MESSAGE_SIZE = "je.rep.maxMessageSize";

    /**
     * Sets the maximum acceptable clock skew between this Replica and its
     * Feeder, which is the node that is the source of its replication stream.
     * This value is checked whenever a Replica establishes a connection to its
     * replication stream source. The connection is abandoned if the clock skew
     * is larger than this value.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>
     * {@link <a href="../EnvironmentConfig.html#timeDuration">Duration</a>}
     * </td>
     * <td>No</td>
     * <td>2 s</td>
     * <td>0 s</td>
     * <td>1 min</td>
     * </tr>
     * </table></p>
     *
     * @see ReplicationConfig#setMaxClockDelta
     * @see ReplicationConfig#getMaxClockDelta
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String MAX_CLOCK_DELTA = "je.rep.maxClockDelta";

    /**
     * The number of times an unsuccessful election will be retried by a
     * designated <code>Primary</code> in a two node group before it is
     * activated and becomes the Master.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>2</td>
     * <td>0</td>
     * <td>Integer.MAX_VALUE</td>
     * </tr>
     * </table></p>
     *
     * @see ReplicationMutableConfig#DESIGNATED_PRIMARY
     */
    public static final String ELECTIONS_PRIMARY_RETRIES =
        "je.rep.electionsPrimaryRetries";

    /**
     * In rare cases, a node may need to rollback committed transactions in
     * order to rejoin a replication group. This parameter limits the
     * number of transactions that may be rolled back. If the number of
     * committed transactions targeted for rollback exceeds this parameter,
     * a {@link RollbackProhibitedException} will be thrown.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>10</td>
     * <td>0</td>
     * <td>Integer.MAX_VALUE</td>
     * </tr>
     * </table></p>
     *
     * @see RollbackProhibitedException
     */
    public static final String TXN_ROLLBACK_LIMIT =
        "je.rep.txnRollbackLimit";

    /**
     * A heartbeat is exchanged between the feeder and replica to ensure they
     * are alive. This is the timeout associated with the heartbeat on the
     * feeder side of the connection.
     * <p>
     * Reducing this value enables the master to discover failed Replicas, and
     * recycle feeder connections, faster. However, it increases the chances of
     * false timeouts, if the network is experiencing transient problems, or
     * the Java GC is responsible for long pauses. In the latter case, it's
     * generally better to tune the GC to avoid such pauses.
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
     * <td>
     * {@link <a href="../EnvironmentConfig.html#timeDuration">Duration</a>}
     * </td>
     * <td>No</td>
     * <td>30 s</td>
     * <td>2 s</td>
     * <td>-none-</td>
     * </tr>
     * </table>
     * </p>
     *
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     * @since 4.0.100
     */
    public static final String FEEDER_TIMEOUT = "je.rep.feederTimeout";

    /**
     * A heartbeat is exchanged between the feeder and replica to ensure they
     * are alive. This is the timeout associated with the heartbeat on the
     * replica side of the connection.
     * <p>
     * Reducing the value means that a master failure will be discovered more
     * promptly in some circumstances and the overall time needed to failover
     * to a new master will be reduced. However, it increases the chances of
     * false timeouts, if the network is experiencing transient problems, or
     * the Java GC is responsible for long pauses. In the latter case, it's
     * generally better to tune the GC to avoid such pauses.
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
     * <td>No</td>
     * <td>30 s</td>
     * <td>2 s</td>
     * <td>-none-</td>
     * </tr>
     * </table>
     * </p>
     *
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     * @since 4.0.100
     */
    public static final String REPLICA_TIMEOUT = "je.rep.replicaTimeout";

    /**
     * The max amount of time for the internal housekeeping, like elections, to
     * be accomplished when opening a new handle to an environment.
     * <p>
     * This timeout does not encompass the time spent making the node
     * consistent with the master, if it is a Replica.
     * <p>
     * Note that the default value (10 hours) is a long time to allow for cases
     * where elections may take a long time when other nodes are not available.
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
     * <td>Duration</td>
     * <td>No</td>
     * <td>10 h</td>
     * <td>-none-</td>
     * <td>-none-</td>
     * </tr>
     * </table>
     * </p>
     *
     * @see <a href="../EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String ENV_SETUP_TIMEOUT = "je.rep.envSetupTimeout";

    /**
     * @hidden
     * For internal use, to allow null as a valid value for the config
     * parameter.
     */
    public static final ReplicationConfig DEFAULT =  new ReplicationConfig();

    /* Support conversion of a non-replicated environment to replicated. */
    private boolean allowConvert = false;

    /**
     * Creates a ReplicationConfig initialized with the system default
     * settings. Defaults are documented with the string constants in this
     * class.
     */
    public ReplicationConfig() {
        super();
    }

    /**
     * Creates a ReplicationConfig initialized with the system default
     * settings and the specified group name, node name, and hostname/port
     * values.
     * @param groupName the name for the replication group
     * @param nodeName the name for this node
     * @param hostPort the hostname and port for this node
     */
    public ReplicationConfig(String groupName,
                             String nodeName,
                             String hostPort) {
        super();
        setGroupName(groupName);
        setNodeName(nodeName);
        setNodeHostPort(hostPort);
    }

    /**
     * Creates a ReplicationConfig which includes the properties specified in
     * the properties parameter.
     *
     * @param properties Supported properties are described as the string
     * constants in this class.
     *
     * @throws IllegalArgumentException If any properties read from the
     * properties parameter are invalid.
     */
    public ReplicationConfig(Properties properties)
        throws IllegalArgumentException {

        super(properties, true /* validateParams */);
    }

    /**
     * Internal use only, from RepConfigManager.
     */
    ReplicationConfig(Properties properties, boolean validateParams)
        throws IllegalArgumentException {

        super(properties, validateParams);
    }

    /**
     * Gets the name associated with the replication group.
     *
     * @return the name of this replication group.
     */
    public String getGroupName() {
        return DbConfigManager.getVal(props, RepParams.GROUP_NAME);
    }

    /**
     * Sets the name for the replication group. The name must be made up of
     * just alpha numeric characters and must not be zero length.
     *
     * @param groupName the alpha numeric string representing the name
     *
     * @return this
     *
     * @throws IllegalArgumentException If the string name is not valid
     */
    public ReplicationConfig setGroupName(String groupName)
        throws IllegalArgumentException {

        DbConfigManager.setVal(props, RepParams.GROUP_NAME, groupName,
                               validateParams);
        return this;
    }

    /**
     * For internal use only.
     *
     * Returns a boolean that specifies if we need to convert the existing logs
     * to replicated format.
     *
     * @return true if we want to convert the existing logs to replicated
     * format
     */
    boolean getAllowConvert() {
        return allowConvert;
    }

    /**
     * For internal use only.
     *
     * If set to true, this environment should be converted to replicated
     * format.
     *
     * @param allowConvert if true, this environment should be converted to
     * replicated format.
     */
    void setAllowConvert(boolean allowConvert) {
        this.allowConvert = allowConvert;
    }

    /**
     * Returns the unique name associated with this node.
     *
     * @return the node name
     */
    public String getNodeName() {
        return DbConfigManager.getVal(props, RepParams.NODE_NAME);
    }

    /**
     * Sets the name to be associated with this node. It must be unique within
     * the group.  When the node is instantiated and joins the replication
     * group, a check is done to ensure that the name is unique, and a {@link
     * RestartRequiredException} is thrown if it is not.
     *
     * @param nodeName the node name for this replicated environment.
     *
     * @return this
     */
    public ReplicationConfig setNodeName(String nodeName)
        throws IllegalArgumentException {

        DbConfigManager.setVal(props, RepParams.NODE_NAME, nodeName,
                               validateParams);
        return this;
    }

    /**
     * Returns the type ({@link NodeType#ELECTABLE ELECTABLE}, {@link
     * NodeType#MONITOR MONITOR}) of this node.
     *
     * @return the node type
     */
    public NodeType getNodeType() {
        return RepParams.NODE_TYPE.getEnumerator
            (DbConfigManager.getVal(props, RepParams.NODE_TYPE));
    }

    /**
     * Sets the type of this node.
     *
     * @param nodeType the node type
     *
     * @return this
     */
    public ReplicationConfig setNodeType(NodeType nodeType){
        DbConfigManager.setVal
            (props, RepParams.NODE_TYPE, nodeType.name(), validateParams);
        return this;
    }

    /**
     * Returns the hostname and port associated with this node. The hostname
     * and port combination are denoted by a string of the form:
     * <pre>
     *   hostname:port
     * </pre>
     * @return the hostname and port string.
     *
     * @see ReplicationConfig#NODE_HOST_PORT
     */
    public String getNodeHostPort() {
        return DbConfigManager.getVal(props, RepParams.NODE_HOST_PORT);
    }

    /**
     * Sets the hostname and port associated with this node. The hostname
     * and port combination are denoted by a string of the form:
     * <pre>
     *  hostname[:port]
     * </pre>
     * The port must be outside the range of "Well Known Ports"
     * (zero through 1023).
     *
     * @param hostPort the string containing the hostname and port as above.
     *
     * @return this
     *
     * @see ReplicationConfig#NODE_HOST_PORT
     */
    public ReplicationConfig setNodeHostPort(String hostPort) {
        DbConfigManager.setVal(props, RepParams.NODE_HOST_PORT, hostPort,
                               validateParams);
        return this;
    }

    /**
     * Returns the configured replica timeout value.
     *
     * @return the timeout in milliseconds
     */
    public long getReplicaAckTimeout(TimeUnit unit) {
        return DbConfigManager.getDurationVal
            (props, RepParams.REPLICA_ACK_TIMEOUT, unit);
    }

    /**
     * Set the replica commit timeout.
     *
     * @param replicaCommitTimeout time in milliseconds
     *
     * @return this
     */
    public ReplicationConfig setReplicaAckTimeout(long replicaCommitTimeout,
                                                  TimeUnit unit) {
        DbConfigManager.setDurationVal
            (props, RepParams.REPLICA_ACK_TIMEOUT, replicaCommitTimeout, unit,
             validateParams);
        return this;
    }

    /**
     * Returns the maximum acceptable clock skew between this Replica and its
     * Feeder, which is the node that is the source of its replication stream.
     *
     * @return the max permissible clock skew
     */
    public long getMaxClockDelta(TimeUnit unit) {
        return DbConfigManager.getDurationVal(props, RepParams.MAX_CLOCK_DELTA,
                                              unit);
    }

    /**
     * Sets the maximum acceptable clock skew between this Replica and its
     * Feeder, which is the node that is the source of its replication
     * stream. This value is checked whenever a Replica establishes a
     * connection to its replication stream source. The connection is abandoned
     * if the clock skew is larger than this value.
     *
     * @param maxClockDelta the maximum acceptable clock skew
     *
     * @return this
     *
     * @throws IllegalArgumentException if the value is not a positive integer
     */
    public ReplicationConfig setMaxClockDelta(long maxClockDelta,
                                              TimeUnit unit)
        throws IllegalArgumentException {

        DbConfigManager.setDurationVal(props, RepParams.MAX_CLOCK_DELTA,
                                       maxClockDelta, unit, validateParams);
        return this;
    }

    /**
     * Returns the string identifying one or more helper host and port pairs in
     * this format:
     * <pre>
     * hostname[:port][,hostname[:port]]*
     * </pre>
     * The port name may be omitted if it's the default port.
     *
     * @return the string representing the host port pairs
     */
    public String getHelperHosts() {
        return DbConfigManager.getVal(props, RepParams.HELPER_HOSTS);
    }

    /**
     * Identify one or more helpers nodes by their host and port pairs in this
     * format:
     * <pre>
     * hostname[:port][,hostname[:port]]*
     * </pre>
     * If the port is omitted, the default port defined by XXX is used.
     *
     * @param hostsAndPorts the string representing the host and port pairs.
     *
     * @return this
     */
    public ReplicationConfig setHelperHosts(String hostsAndPorts) {
        DbConfigManager.setVal
            (props, RepParams.HELPER_HOSTS, hostsAndPorts, validateParams);
        return this;
    }

    /**
     * Sets the consistency policy to be associated with the configuration.
     * This policy acts as the default policy used to govern the consistency
     * requirements when starting new transactions. See the {@link <a
     * href="{@docRoot}../ReplicationGuide/consistency.html">overview on
     * consistency in replicated systems</a>} for more background.
     * <p>
     * @param policy the consistency policy to be set for this config.
     *
     * @return this
     */
    public ReplicationConfig
        setConsistencyPolicy(ReplicaConsistencyPolicy policy) {

        DbConfigManager.setVal(props,
                               RepParams.CONSISTENCY_POLICY,
                               RepUtils.getPropertyString(policy),
                               validateParams);
        return this;
    }

    /**
     * Returns the default consistency policy associated with the
     * configuration.
     * <p>
     * If the user does not set the default consistency policy through {@link
     * ReplicationConfig#setConsistencyPolicy}, the system will use the policy
     * defined by {@link ReplicationConfig#CONSISTENCY_POLICY}.
     *
     * @return the consistency policy currently associated with this config.
     */
   public ReplicaConsistencyPolicy getConsistencyPolicy () {
        String propertyValue =
            DbConfigManager.getVal(props,
                                   RepParams.CONSISTENCY_POLICY);
        return RepUtils.getReplicaConsistencyPolicy(propertyValue);
    }

    @Override
    public ReplicationConfig setConfigParam(String paramName, String value)
        throws IllegalArgumentException {

        DbConfigManager.setConfigParam(props,
                                       paramName,
                                       value,
                                       false,   /* require mutability. */
                                       validateParams,
                                       true,   /* forReplication */
                                       true);  /* verifyForReplication */
        return this;
    }

    /**
     * Returns a copy of this configuration object.
     */
    @Override
    public ReplicationConfig clone() {
        try {
            return (ReplicationConfig) super.clone();
        } catch (CloneNotSupportedException willNeverOccur) {
            return null;
        }
    }

    /**
     * @hidden
     *
     * For internal use only: Internal convenience method.
     *
     * Returns the set of sockets associated with helper nodes. This method
     * should only be used when the configuration object is known to have an
     * authoritative value for the helper hosts values. In a replication node,
     * the je.properties file may override the values in this configuration
     * object.
     *
     * @return the set of helper sockets, returns an empty set if there are no
     * helpers.
     */
    public Set<InetSocketAddress> getHelperSockets() {
        return HostPortPair.getSockets(getHelperHosts());
    }

    /**
     * @hidden
     * Internal convenience methods for returning replication sockets.
     *
     * This method should only be used when the configuration object is known
     * to have an authoritative value for its socket value. In a replication
     * node, the je.properties file may override the values in this
     * configuration object.
     */
    public InetSocketAddress getNodeSocketAddress() {

        return new InetSocketAddress(getNodeHostname(), getNodePort());
    }

    /**
     * Returns the hostname component of the nodeHost property.
     *
     * @return the hostname string
     */
    public String getNodeHostname() {
        String hostAndPort =
            DbConfigManager.getVal(props, RepParams.NODE_HOST_PORT);
        int colonToken = hostAndPort.indexOf(":");

        return (colonToken >= 0) ?
                hostAndPort.substring(0,colonToken) : hostAndPort;
    }

    /**
     * Returns the port component of the nodeHost property.
     *
     * @return the port number
     */
    public int getNodePort() {
        String hostAndPort =
            DbConfigManager.getVal(props, RepParams.NODE_HOST_PORT);
        int colonToken = hostAndPort.indexOf(":");

        String portString = (colonToken >= 0) ?
            hostAndPort.substring(colonToken+1) :
            DbConfigManager.getVal(props, RepParams.DEFAULT_PORT);

        return Integer.parseInt(portString) ;
    }

    /**
     * @hidden
     * For internal use only.
     *
     * Performs the checks need to ensure that this is a valid replicated
     * environment configuration. This method must only be invoked after all
     * the appropriate fields are set.
     */
    public void verify() throws IllegalArgumentException {
        if ((getGroupName() == null) || "".equals(getGroupName())) {
            throw new IllegalArgumentException("Missing group name");
        }

        if ((getNodeName() == null) || "".equals(getNodeName())){
            throw new IllegalArgumentException("Missing node name");
        }

        if ((getNodeHostPort() == null) || "".equals(getNodeHostPort())) {
            throw new IllegalArgumentException("Missing node host");
        }
    }
}
