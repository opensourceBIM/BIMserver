/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.io.File;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.EnvironmentNotFoundException;
import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.VersionMismatchException;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.RepConfigProxy;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.utilint.DatabaseUtil;

/**
 * A replicated database environment that is a node in a replication
 * group. Please read the {@link <a
 * href="{@docRoot}/../ReplicationGuide/introduction.html">Berkeley DB JE High
 * Availability Overview</a>} for an introduction to basic concepts and key
 * terminology. 
 * <p>
 * Berkeley DB JE High Availability (JE HA) is a replicated, embedded database
 * management system which provides fast, reliable, and scalable data
 * management. JE HA enables replication of an environment across a Replication
 * Group. A ReplicatedEnvironment is a single node in the replication group.
 * <p>
 * ReplicatedEnvironment extends {@link Environment}. All database operations
 * are executed in the same fashion in both replicated and non replicated
 * applications, using {@link Environment} methods.  A ReplicatedEnvironment
 * must be transactional. All databases created in the replicated environment
 * must be transactional as well.
 * <p>
 * ReplicatedEnvironment handles are analogous to {@link Environment}
 * handles. A replicated environment handle is a ReplicatedEnvironment
 * instance; multiple ReplicatedEnvironment instances may be created for the
 * same physical directory. In other words, more than one ReplicatedEnvironment
 * handle may be open at a time for a given environment.
 * </p>
 * <p>
 * A ReplicatedEnvironment joins its replication group when it is instantiated.
 * When the constructor returns, the node will have established contact with
 * the other members of the group and will be ready to service operations. The
 * {@link <a href="{@docRoot}/../ReplicationGuide/lifecycle.html">life
 * cycle</a>} overview is useful for understanding replication group creation.
 * <p>
 * The membership of a replication group is dynamically defined. The group
 * comes into being when ReplicatedEnvironments that are configured as members
 * of a group are created and discover each other. ReplicatedEnvironments are
 * identified by a group name, a node name, and a hostname:port
 * value. Membership information is stored in an internal, replicated database
 * available to all nodes.
 * <p>
 * To start a node and join a group, instantiate a ReplicatedEnvironment. The
 * very first instantiation of a node differs slightly from all future
 * instantiations. A brand new, empty node does not yet have access to the
 * membership database, so it must discover the group with with the aid of a
 * helper node, which is a fellow member. If this is the very first node of the
 * entire group, there is no available helper. Instead, the helper host address
 * to use is the node's own address. The example below takes the simple
 * approach of creating a replication group by starting up a node that will act
 * as the first master, though it is not necessary to follow this order.
 * {@link <a
 * href="{@docRoot}/../ReplicationGuide/progoverview.html#configrepenv">
 * Configuring Replicated Environments</a>} describes group startup in greater
 * detail.
 * <p>
 * To create the <b>the master node in a brand new group</b>, instantiate a
 * ReplicatedEnvironment this way:
 * <pre class="code">
 * EnvironmentConfig envConfig = new EnvironmentConfig();
 * envConfig.setAllowCreate(true);
 * envConfig.setTransactional(true);
 *
 * // Identify the node
 * ReplicationConfig repConfig = new ReplicationConfig();
 * repConfig.setGroupName("PlanetaryRepGroup");
 * repConfig.setNodeName("Mercury");
 * repConfig.setNodeHostPort("mercury.acme.com:5001");
 *
 * // This is the first node, so its helper is itself
 * repConfig.setHelperHosts("mercury.acme.com:5001");
 *
 * ReplicatedEnvironment repEnv =
 *     new ReplicatedEnvironment(envHome, repConfig, envConfig);
 * </pre>
 * <p>
 * To create a new node when there are <b>other existing group members</b>,
 * set a helper address which points to an existing node in the group. A simple
 * way to bring up a new group is to "chain" the new nodes by having the
 * helpers reference a previously created node.
 * <pre class="code">
 * EnvironmentConfig envConfig = new EnvironmentConfig();
 * envConfig.setAllowCreate(true);
 * envConfig.setTransactional(true);
 *
 * // Identify the node
 * ReplicationConfig repConfig = 
 *     new ReplicationConfig("PlanetaryRepGroup", "Jupiter", "jupiter.acme.com:5002");
 *
 * // Use the node at mercury.acme.com:5001 as a helper to find the rest
 * // of the group.
 * repConfig.setHelperHosts("mercury.acme.com:5001");
 *
 * ReplicatedEnvironment repEnv =
 *     new ReplicatedEnvironment(envHome, repConfig, envConfig);
 * </pre>
 * <p>
 * In these examples, node Mercury was configured as its own helper, and
 * becomes the first master. The next nodes were configured to use Mercury as
 * their helper, and became replicas. It is also possible to start these in
 * reverse order, bringing mercury up last. In that case, the earlier nodes
 * will block until a helper is awake and can service their requests for group
 * metadata.
 * <p>
 * Creating a ReplicatedEnvironment for an <b>existing environment</b> requires
 * less configuration. The call
 * to {@code EnvironmentConfig.setAllowCreate()} is eliminated to guard
 * against the unintentional creation of a new environment. Also, there is no
 * need to set a helper host address, because the environment exists and has
 * access to the shared, persistent membership information.
 * <pre class="code">
 * EnvironmentConfig envConfig = new EnvironmentConfig();
 * envConfig.setTransactional(true);
 * ReplicationConfig repConfig = 
 *     new ReplicationConfig("PlanetaryRepGroup", "Mercury", "mercury.acme.com:5001");
 *
 * ReplicatedEnvironment repEnv =
 *     new ReplicatedEnvironment(envHome, repConfig, envConfig);
 * </pre>
 * </p>
 * {@literal See} {@link com.sleepycat.je.rep.util.ReplicationGroupAdmin
 * ReplicationGroupAdmin} for information on how to remove nodes from the
 * replication group.
 *
 * <p>
 * ReplicatedEnvironment properties can be set via the the {@literal
 * <environmentHome>/}je.properties file, just like {@link Environment}
 * properties. They follow the same property value precedence rules.
 *
 * <p>
 * A replicated environment directory can only be accessed by a read write
 * ReplicatedEnvironment handle or a read only {@link Environment} handle.  In
 * the current release, there is an additional restriction that a read only
 * {@link Environment} is only permitted when the directory is not also
 * accessed from a different process by a read/write ReplicatedEnvironment. If
 * a read/write ReplicatedEnvironment and a read only {@link Environment} from
 * two different processes concurrently access an environment directory, there
 * is the small possibility that the read only {@link Environment} may see
 * see exceptions thrown about an inconsistent log if the ReplicatedEnvironment
 * executes certain kinds of failover. There is no problem if the {@link
 * Environment} and ReplicatedEnvironment are in the same process, or are not
 * concurrent.
 * <p>
 * JE HA prohibits opening a replicated environment directory with a read/write
 * {@link Environment} handle, because from the group's perspective,
 * unreplicated updates to a single node would cause data inconsistency.  To
 * use an existing, non-replicated environment to bootstrap a replication
 * group, use {@link com.sleepycat.je.rep.util.DbEnableReplication} to do a one
 * time conversion of the directory.
 * <p>
 * All other database objects, such as {@link com.sleepycat.je.Database} or
 * {@link com.sleepycat.je.Cursor} (when using the Base API) or {@link
 * com.sleepycat.persist.EntityStore} or {@link
 * com.sleepycat.persist.PrimaryIndex} (when using the Direct Persistence
 * Layer) should be created, used and closed before calling {@link
 * ReplicatedEnvironment#close}.
 *
 * @see Environment
 * @see <a href="{@docRoot}/../ReplicationGuide/progoverview.html" 
 * target="_top">Replication First Steps</a>
 * @since 4.0
 */
public class ReplicatedEnvironment extends Environment {

    /*
     * The canonical RepImpl associated with the environment directory,
     * accessed by different handles. Null if the handle has been closed.
     */
    private RepImpl repImpl;

    /* The unique name and id associated with the node. */
    private final NameIdPair nameIdPair;

    /*
     * The replication configuration that has been used to create this
     * handle. This is derived from the original configuration argument, after
     * cloning a copy to keep it distinct from the user's instance, applying
     * je.properties settings, and validating against the underlying node.
     */
    private ReplicationConfig handleRepConfig;

    /**
     * Creates a replicated environment handle and starts participating in the
     * replication group as either a Master or a Replica. The node's state is
     * determined when it joins the group, and mastership is not preconfigured.
     * If the group has no current master, creation of a handle will trigger
     * an election to determine whether this node is a Master or a Replica.
     * <p>
     * If the node participates as a Master, the constructor will return after
     * a sufficient number of Replicas, in accordance with the {@code
     * initialElectionPolicy} argument, have established contact with the
     * Master.
     * <p>
     * If the node participates as a Replica, it will become consistent in
     * accordance with the <code>consistencyPolicy</code> argument before
     * returning from the constructor.
     * <p>
     * A brand new node will always join an existing group as a Replica, unless
     * it is the very first node that is creating the group. In that case it
     * joins as the Master of the newly formed singleton group. A brand new
     * node must always specify one or more active helper nodes via the {@link
     * ReplicationConfig#setHelperHosts(String)} method or via the the
     * <code>&lt;environment home&gt;/je.properties</code> file. If this is the
     * very first member of a nascent group, it must specify just itself as the
     * helper.
     * <p>
     * There are special considerations to keep in mind when a replication
     * group is started and elections are first held to determine a master. The
     * default {@link com.sleepycat.je.rep.QuorumPolicy#SIMPLE_MAJORITY} calls
     * for a simple majority vote. If the group members were previously created
     * and populated, the default election policy may result in the election of
     * a master that may not have the most up to date copy of the environment.
     * This could happen if the best qualified node is slow to start up; it's
     * possible that by the time it's ready to participate in an election, the
     * election has already have completed with a simple majority.
     * <p>
     * To avoid this possibility, the method has a parameter
     * initialElectionPolicy, which can be used to specify {@link
     * com.sleepycat.je.rep.QuorumPolicy#ALL}, which will cause the elections
     * to wait until all nodes can vote. By ensuring that all the nodes can
     * vote, the best possible node is chosen to be the master at group
     * startup.
     * <p>
     * Note that it is the application's responsibility to ensure that all
     * nodes coordinate their choice of initialElectionPolicy so that the very
     * first elections held when a group is brought up use the same value for
     * this parameter. This parameter is only used for the first election.
     * After the first election has been held and the group is functioning,
     * subsequent elections do not require participation of all the nodes. A
     * simple majority is sufficient to elect the node with the most up to date
     * environment as the master.
     * <p>
     * @param envHome The environment's home directory.
     *
     * @param repConfig replication configurations. If null, the default
     * replication configurations are used.
     *
     * @param envConfig environment configurations for this node. If null, the
     * default environment configurations are used.
     *
     * @param consistencyPolicy the consistencyPolicy used by the Replica at
     * startup to make its environment current with respect to the master. This
     * differs from the consistency policy specified {@link
     * ReplicationConfig#setConsistencyPolicy} because it is used only at
     * construction, when the node joins the group for the first time. The
     * consistency oolicy set in {@link ReplicationConfig} is used any time a
     * policy is used after node startup, such as at transaction begins.
     *
     * @param initialElectionPolicy the policy to use when holding the initial
     * election.
     *
     * @throws RestartRequiredException
     *
     * @throws ReplicaConsistencyException if it is a Replica and cannot
     * satisfy the specified consistency policy within the <code>
     * joinGroupTimeout</code> period.
     *
     * @throws UnknownMasterException if the node cannot join the group in the
     * time period specified by the {@link ReplicationConfig#ENV_SETUP_TIMEOUT}
     * property.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws EnvironmentLockedException when an environment cannot be opened
     * for write access because another process has the same environment open
     * for write access.  <strong>Warning:</strong> This exception should be
     * handled when an environment is opened by more than one process.
     *
     * @throws VersionMismatchException when the existing log is not compatible
     * with the version of JE that is running.  This occurs when a later
     * version of JE was used to create the log.  <strong>Warning:</strong>
     * This exception should be handled when more than one version of JE may be
     * used to access an environment.
     *
     * @throws UnsupportedOperationException if the environment exists and has
     * not been enabled for replication.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, an invalid {@code EnvironmentConfig} parameter.
     */
    public ReplicatedEnvironment(File envHome,
                                 ReplicationConfig repConfig,
                                 EnvironmentConfig envConfig,
                                 ReplicaConsistencyPolicy consistencyPolicy,
                                 QuorumPolicy initialElectionPolicy)
        throws EnvironmentNotFoundException,
               EnvironmentLockedException,
               InsufficientLogException,
               ReplicaConsistencyException,
               IllegalArgumentException {

        this(envHome,
             repConfig,
             envConfig,
             consistencyPolicy,
             initialElectionPolicy,
             true /*joinGroup*/);
    }

    /**
     * A convenience constructor that defaults the replica consistency policy
     * and the initial election policy to be used.
     *
     * <p>The default replica consistency policy results in the replica being
     * consistent with the master as of the time the handle was is created.</p>
     *
     * <p>The default initial election policy is
     * {@link QuorumPolicy#SIMPLE_MAJORITY}</p>
     *
     * @throws RestartRequiredException
     *
     * @throws ReplicaConsistencyException if it is a Replica and cannot
     * satisfy the default consistency policy within the <code>
     * joinGroupTimeout</code> period.
     *
     * @throws UnknownMasterException if the node cannot join the group in the
     * time period specified by the {@link ReplicationConfig#ENV_SETUP_TIMEOUT}
     * property.
     *
     * @throws EnvironmentLockedException when an environment cannot be opened
     * for write access because another process has the same environment open
     * for write access.  <strong>Warning:</strong> This exception should be
     * handled when an environment is opened by more than one process.
     *
     * @throws VersionMismatchException when the existing log is not compatible
     * with the version of JE that is running.  This occurs when a later
     * version of JE was used to create the log.  <strong>Warning:</strong>
     * This exception should be handled when more than one version of JE may be
     * used to access an environment.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws UnsupportedOperationException if the environment exists and has
     * not been enabled for replication.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, an invalid {@code EnvironmentConfig} parameter.
     *
     * @see #ReplicatedEnvironment(File, ReplicationConfig, EnvironmentConfig,
     * ReplicaConsistencyPolicy, QuorumPolicy)
     */
    public ReplicatedEnvironment(File envHome,
                                 ReplicationConfig repConfig,
                                 EnvironmentConfig envConfig)
        throws EnvironmentNotFoundException,
               EnvironmentLockedException,
               ReplicaConsistencyException,
               InsufficientLogException,
               RollbackException,
               IllegalArgumentException {

        this(envHome, repConfig, envConfig, null /*consistencyPolicy*/,
             QuorumPolicy.SIMPLE_MAJORITY);
    }

    /*
     * Joins the replication group as part of the creation of a handle.
     */
    private void joinGroup(ReplicaConsistencyPolicy consistencyPolicy,
                           QuorumPolicy initialElectionPolicy)
        throws DatabaseException {

        State state = null;
        try {
            state =
                repImpl.joinGroup(consistencyPolicy, initialElectionPolicy);
            if (state == State.UNKNOWN) {
                throw new UnknownMasterException
                    (null, repImpl.getStateChangeEvent());
            }
        } finally {
            if (state == null) {

                /*
                 * Something bad happened, close the environment down with
                 * minimal activity. The environment may not actually be
                 * invalidated, but the constructor did not succeed, so it's
                 * logically invalid. We don't go to the effort of invalidating
                 * the environment, to avoid masking the original problem. Use
                 * abnormalClose() because it will remove the
                 * environment from the environment pool.
                 */
                repImpl.abnormalClose();
            }
        }
    }

    /**
     * Constructor motivated primarily by testing to create a replicated
     * environment handle but not join the group. For internal use only.  Note
     * that repImpl.joinGroup is a synchronized method, and therefore protected
     * against multiple concurrent attempts to create a handle.
     */
    ReplicatedEnvironment(File envHome,
                          ReplicationConfig repConfig,
                          EnvironmentConfig envConfig,
                          ReplicaConsistencyPolicy consistencyPolicy,
                          QuorumPolicy initialElectionPolicy,
                          boolean joinGroup)
        throws EnvironmentNotFoundException,
               EnvironmentLockedException,
               ReplicaConsistencyException {

        super(envHome, envConfig, repConfig);

        repImpl = (RepImpl) envImpl;
        nameIdPair = repImpl.getNameIdPair();
        if (joinGroup) {
            try {
                joinGroup(consistencyPolicy, initialElectionPolicy);
            } catch (RollbackException e) {

                /*
                 * Syncup failed, a hard recovery is needed. Throwing the
                 * RollbackException closed the RepImpl and the EnvironmentImpl
                 * Redo the creation of RepImpl and retry the join once. If the
                 * second joinGroup fails, let the exception throw out to the
                 * user.
                 */
                envImpl = makeEnvironmentImpl(envHome, envConfig,
                                              true /*createIfNeeded*/,
                                              repConfig);
                repImpl = (RepImpl) envImpl;
                joinGroup(consistencyPolicy, initialElectionPolicy);
                repImpl.setHardRecoveryInfo(e);
            }

            /*
             * Fire a JoinGroupEvent only when the ReplicatedEnvironment is 
             * successfully created for the first time.
             */
            repImpl.getRepNode().getMonitorEventManager().notifyJoinGroup();
        } else {
            /* For testing only */
            if (repImpl.getRepNode() != null) {
                throw EnvironmentFailureException.unexpectedState
                    ("An earlier handle creation had resulted in the node" +
                     "joining the group");
            }
        }
    }

    /**
     * @hidden
     * For internal use only.
     *
     * Validate and resolve replication configuration params, and extract a
     * ReplicationConfig with those params for passing into environment
     * creation. Note that a copy of the ReplicationConfig argument is created
     * to insulate the application from changes made by the replication
     * implementation and vice versa.
     */
    @Override
    protected RepConfigProxy setupRepConfig(File envHome,
                                            RepConfigProxy repConfigProxy,
                                            EnvironmentConfig envConfig) {

        /**
         * If the user specified a null object, use the default. Apply the
         * je.properties file to the replication config object.
         */
        if (envConfig.getReadOnly()) {
            throw new IllegalArgumentException
                ("A replicated environment may not be opened read-only");
        }

        ReplicationConfig repConfig = (ReplicationConfig) repConfigProxy;
        ReplicationConfig baseConfig =
            (repConfig == null) ? ReplicationConfig.DEFAULT : repConfig;
        ReplicationConfig useConfig = baseConfig.clone();
        DbConfigManager.applyFileConfig(envHome,
                                        useConfig.getProps(),
                                        true); /* forReplication */
        this.handleRepConfig = useConfig;
        return handleRepConfig;
    }

    /**
     * Returns the unique name used to identify this replicated environment.
     * @see ReplicationConfig#setNodeName
     *
     * @return the node name
     */
    public String getNodeName() {
        return nameIdPair.getName();
    }

    /**
     * Returns the current state of the node associated with this replication
     * environment. See {@link State} for a desciption of node states.
     * <p>
     * If the caller's intent is to track the state of the node,
     * {@link StateChangeListener} may be a more convenient and efficient
     * approach, rather than using getState() directly.
     *
     * @return the current replication state associated with this node
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has already been closed.
     */
    public State getState()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            return repImpl.getState();
        } catch (Error E) {
            repImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * Returns a description of the replication group as known by this node.
     * The replicated group metadata is stored in a replicated database and
     * updates are propagated by the current master node to all replicas. If
     * this node is not the master, it is possible for its description of the
     * group to be out of date.
     *
     * @return the group description
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has already been closed.
     */
    public ReplicationGroup getGroup()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            return new ReplicationGroup(repImpl.getRepNode().getGroup());
        } catch (Error E) {
            repImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * Close this ReplicatedEnvironment and release any resources used by the
     * handle.
     *
     * <p>
     * When the last handle is closed, allocated resources are freed, and
     * daemon threads are stopped, even if they are performing work. The node
     * ceases participation in the replication group. If the node was currently
     * the master, the rest of the group will hold an election. If a quorum of
     * nodes can participate in the election, a new master will be chosen.
     * <p>
     * The ReplicatedEnvironment should not be closed while any other type of
     * handle that refers to it is not yet closed. For example, the
     * ReplicatedEnvironment should not be close while there are open Database
     * instances, or or while transactions in the environment have not yet
     * committed or aborted. Specifically, this includes {@link
     * com.sleepycat.je.Database Database}, {@link com.sleepycat.je.Cursor
     * Cursor} and {@link com.sleepycat.je.Transaction Transaction} handles.
     * </p>
     */
    @Override
    synchronized public void close()
        throws DatabaseException {

        try {
            super.close();
        } catch (DatabaseException e) {
            /* Add this node's address to the exception message for clarity. */
            e.addErrorMessage("Problem closing handle " + nameIdPair);
            throw e;
        } catch (Exception e) {
            /* Add this node's address to the exception message for clarity. */
            throw new EnvironmentFailureException
                (repImpl,
                 EnvironmentFailureReason.UNEXPECTED_EXCEPTION,
                 "Problem closing handle " + nameIdPair, e);
        } catch (Error E) {
            repImpl.invalidate(E);
            throw E;
        } finally {
            repImpl = null;
        }
    }

    /**
     * Determines if this replicated environment handle has been closed. For
     * testing purposes.
     *
     * @return true if this handle has been closed.
     */
    boolean isClosed() {
        return (repImpl == null) || (repImpl.isInvalid());
    }

    /**
     * Sets the listener used to receive asynchronous replication node state
     * change events. Note that there is one listener per replication node, not
     * one per handle. Invoking this method replaces the previous Listener.
     *
     * Invoking this method typically results in an immediate callback to the
     * application via the {@link StateChangeListener#stateChange} method, so
     * that the application is made aware of the existing state of the
     * node at the time <code>StateChangeListener</code> is first established.
     *
     * @param listener the state change listener.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has already been closed.
     */
    public void setStateChangeListener(StateChangeListener listener)
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            repImpl.setChangeListener(listener);
        } catch (Error E) {
            repImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * Returns the listener used to receive asynchronous replication node state
     * change events. A StateChangeListener provides the replication
     * application with an asynchronous mechanism for tracking the {@link
     * ReplicatedEnvironment.State State} of the replicated environment.
     * <p>
     * Note that there is one listener per replication node, not one per
     * ReplicatedEnvironment handle.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has already been closed.
     */
    public StateChangeListener getStateChangeListener()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            return repImpl.getChangeListener();
        } catch (Error E) {
            repImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has already been closed.
     */
    public void setRepMutableConfig(ReplicationMutableConfig mutableConfig)
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();
            DatabaseUtil.checkForNullParam(mutableConfig, "mutableConfig");
            repImpl.setRepMutableConfig(mutableConfig);
        } catch (Error E) {
            repImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has already been closed.
     */
    public ReplicationMutableConfig getRepMutableConfig()
        throws DatabaseException {

        try {
            checkHandleIsValid();
            checkEnv();

            final ReplicationMutableConfig config =
                repImpl.cloneRepMutableConfig();
            config.fillInEnvironmentGeneratedProps(repImpl);
            return config;
        } catch (Error E) {
            repImpl.invalidate(E);
            throw E;
        }
    }

    /**
     * Return the replication configuration that has been used to create this
     * handle. This is derived from the original configuration argument, after
     * cloning a copy to keep it distinct from the user's instance, applying
     * je.properties settings, and validating against the underlying
     * node.
     *
     * @return this handle's configuration.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has already been closed.
     */
    public ReplicationConfig getRepConfig()
        throws DatabaseException {

        checkHandleIsValid();
        checkEnv();

        return handleRepConfig;
    }

    /**
     * Returns statistics associated with this environment. See {@link
     * ReplicatedEnvironmentStats} for the kind of information available.
     *
     * @param config is used to specify attributes such as whether the stats
     * should be cleared, whether the complete set of stats should be obtained,
     * etc.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if this handle or the underlying
     * environment has already been closed.
     */
    public ReplicatedEnvironmentStats getRepStats(StatsConfig config)
        throws DatabaseException {

        checkHandleIsValid();
        checkEnv();
        final StatsConfig useConfig =
            (config == null) ? StatsConfig.DEFAULT : config;
        return repImpl.getStats(useConfig);
    }

    /*
     * Get the underlying shared repImpl. For internal access
     * only. Intentionally non-public; non package access must use the
     * RepInternal proxy.
     */
    RepImpl getRepImpl() {
        return repImpl;
    }

    /**
     * The replication node state determines the operations that the
     * application can perform against its replicated environment.
     * The method {@link #getState} returns the current state.
     * <p>
     * When the first handle to a {@link ReplicatedEnvironment} is instantiated
     * and the node is bought up, it always starts out in the
     * <code>DETACHED</code> state and then transitions to the
     * <code>MASTER</code> or <code>REPLICA</code> state before returning from
     * the constructor.
     * <p>
     * When nodes in the group become unavailable and elections are held, the
     * node may transition between <code>MASTER</code> and <code>REPLICA</code>
     * states.
     * <p>
     * When the last handle to the environment is closed, the node transitions
     * back to the <code>DETACHED</code> state.
     * <p>
     * The state transitions for a node can be summarized by the regular
     * expression:
     * <blockquote>
     * <code> DETACHED [ MASTER | REPLICA | UNKNOWN ]+ DETACHED</code>, with
     * the following caveats:
     * </blockquote>
     * <ul>
     * <li>
     * A <code>MASTER</code> state never follows a <code>MASTER</code> state,
     * since that would represent a redundant transition.
     * <li>
     * Similarly, an <code>UNKNOWN</code> state never follows an
     * <code>UNKNOWN</code> state, since that would be redundant transition.
     * <li>
     * A <code>REPLICA</code> state can follow a <code>REPLICA</code> state, as
     * long as this node is not the <code>MASTER</code>.
     * </ul>
     * <p>
     * The initial <code>DETACHED</code> state is internal to the JE HA
     * implementation and is not visible to the application.
     */
    public static enum State {

        /**
         * The node is not associated with the group. Its handle has been
         * closed. No operations can be performed on the environment when it is
         * in this state.
         */
        DETACHED,

        /**
         * The node is not currently in contact with its group, but is actively
         * trying to establish contact and decide upon a master. While in
         * this state the node is restricted to performing just read operations
         * on its environment. In a functioning group, this state is
         * transitory.
         */
        UNKNOWN,

        /**
         * The node is the unique master of the group and can both read and
         * write to its environment. When the node transitions to the
         * state, the application running on the node must make provisions to
         * start processing application level write requests in addition to
         * read requests.
         */
        MASTER,

        /**
         * The node is a replica that is being updated by the master. It is
         * restricted to reading its environment. When the node
         * transitions to this state, the application running on the node must
         * make provisions to ensure that it does not write to the
         * environment. It must arrange for all write requests to be routed to
         * the master.
         */
        REPLICA;

        /**
         * @return true if the node is a Master when in this state
         */
        final public boolean isMaster() {
            return this == MASTER;
        }

        /**
         * @return true if the node is a Replica when in this state
         */
        final public boolean isReplica() {
            return this == REPLICA;
        }

        /**
         * @return true if the node is disconnected from the replication
         * group when in this state.
         */
        final public boolean isDetached() {
            return this == DETACHED;
        }

        /**
         * @return true if the node's state is unknown, and it is attempting
         * to transition to Master or Replica.
         */
        final public boolean isUnknown() {
            return this == UNKNOWN;
        }

        /**
         * @return true if the node is currently participating in the group as
         * a Replica or a Master
         */
        final public boolean isActive() {
            return (this == MASTER) || (this == REPLICA);
        }
    }

    /**
     * Closes this handle and shuts down the Replication Group by forcing all
     * active Replicas to exit.
     * <p>
     * This method must be invoked on the node that's currently the Master
     * after all other outstanding handles have been closed.
     * <p>
     * The Master waits for all active Replicas to catch up so that they have a
     * current set of logs, and then shuts them down. The Master will wait for
     * a maximum of <code>replicaShutdownTimeout</code> for a Replica to catch
     * up. If the Replica has not caught up in this time period it will force
     * the Replica to shut down before it is completely caught up. A negative
     * or zero <code>replicaShutdownTimeout</code> value will result in an
     * immediate shutdown without waiting for lagging Replicas to catch up.
     * Nodes that are currently inactive cannot be contacted by the Master, as
     * a consequence, their state is not impacted by the shutdown.
     * <p>
     * The shutdown operation will close this handle on the Master node. The
     * environments on Replica nodes will be invalidated, and attempts to use
     * those handles will result in a {@link GroupShutdownException} being
     * thrown. The application is responsible for closing the remaining handles
     * on the Replica.
     *
     * @param replicaShutdownTimeout the maximum amount of time the Master
     * waits for a Replica to shutdown.
     *
     * @param unit the time unit associated with the
     * <code>replicaShutdownTimeout</code>
     *
     * @throws IllegalStateException if the method is invoked on a node that's
     * not currently the Master, or there are other open handles to this
     * Environment.
     */
    synchronized public void shutdownGroup(long replicaShutdownTimeout,
                                           TimeUnit unit)
        throws IllegalStateException {

        checkHandleIsValid();
        checkEnv();

        synchronized (repImpl) {
            /* Hold repImpl stable, across the setup and close. */
            repImpl.shutdownGroupSetup(unit.toMillis(replicaShutdownTimeout));
            close();
        }
    }
}
