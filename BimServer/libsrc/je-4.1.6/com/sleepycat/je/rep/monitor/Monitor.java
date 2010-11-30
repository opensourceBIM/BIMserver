/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.monitor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.NodeType;
import com.sleepycat.je.rep.RepInternal;
import com.sleepycat.je.rep.ReplicationConfig;
import com.sleepycat.je.rep.ReplicationGroup;
import com.sleepycat.je.rep.ReplicationNode;
import com.sleepycat.je.rep.UnknownMasterException;
import com.sleepycat.je.rep.elections.Learner;
import com.sleepycat.je.rep.elections.MasterValue;
import com.sleepycat.je.rep.elections.Protocol;
import com.sleepycat.je.rep.elections.TimebasedProposalGenerator;
import com.sleepycat.je.rep.elections.Proposer.Proposal;
import com.sleepycat.je.rep.elections.Protocol.Value;
import com.sleepycat.je.rep.impl.NodeStateProtocol;
import com.sleepycat.je.rep.impl.NodeStateService;
import com.sleepycat.je.rep.impl.RepGroupImpl;
import com.sleepycat.je.rep.impl.RepNodeImpl;
import com.sleepycat.je.rep.impl.NodeStateProtocol.NodeStateResponse;
import com.sleepycat.je.rep.impl.TextProtocol.MessageExchange;
import com.sleepycat.je.rep.impl.TextProtocol.ResponseMessage;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.util.ReplicationGroupAdmin;
import com.sleepycat.je.rep.utilint.ReplicationFormatter;
import com.sleepycat.je.rep.utilint.ServiceDispatcher;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * Provides a lightweight mechanism to track the current master node and the
 * members of the replication group. The information provided by the monitor
 * can be used to route update requests to the node that is currently the
 * master and distribute read requests across the other members of the group.
 * <p>
 * The Monitor is typically run on a machine that participates in load
 * balancing, request routing or is simply serving as a basis for application
 * level monitoring and does not have a replicated environment. To avoid
 * creating a single point of failure, an application may need to create
 * multiple monitor instances, with each monitor running on a distinct machine.
 * <p>
 * Applications with direct access to a {@link com.sleepycat.je.rep.ReplicatedEnvironment ReplicatedEnvironment} can use
 * its 
 * {@link <a href="{@docRoot}/../ReplicationGuide/replicawrites.html">
 * synchronous and asynchronous mechanisms</a>} for determining the master node
 * and group composition changes. The Monitor class is not needed by such
 * applications. 
 * <p>
 * The following code excerpt illustrates the typical code sequence used to
 * initiate a Monitor. Exception handling has been omitted to simplify the
 * example.
 *
 * <pre class="code">
 * ReplicationConfig monConfig = new ReplicationConfig();
 * monConfig.setGroupName("PlanetaryRepGroup");
 * monConfig.setNodeName("mon1");
 * monConfig.setNodeType(NodeType.MONITOR);
 * monConfig.setNodeHostPort("monhost1.acme.com:7000");
 * monConfig.setHelperHosts("mars.acme.com:5000,jupiter.acme.com:5000");
 *
 * Monitor monitor = new Monitor(monConfig);
 *
 * // If the monitor has not been registered as a member of the group,
 * // register it now. register() returns the current node that is the
 * // master.
 *
 * ReplicationNode currentMaster = monitor.register();
 *
 * // Start up the listener, so that it can be used to track changes
 * // in the master node, or group composition. It can also be used to help
 * // determine the electable nodes that are currently active and participating
 * // in the replication group.
 * monitor.startListener(new MyChangeListener());
 * </pre>
 *
 * @see MonitorChangeListener
 * @see <a href="{@docRoot}../ReplicationGuide/monitors.html">Writing Monitor Nodes</a>
 * @see NodeType#MONITOR
 * @see <a href="{@docRoot}../examples/je/rep/quote/package-summary.html">je.rep.quote Examples</a>
 */
public class Monitor {

    /* The Monitor Id */
    private final NameIdPair nameIdPair;

    /* The configuration in use by this Monitor. */
    private final ReplicationConfig monitorConfig;

    /* Provides the admin functionality for the monitor. */
    private final ReplicationGroupAdmin repGroupAdmin;

    /* The underlying learner that drives the Monitor. */
    private Learner learner;

    /* The Master change listener used by the Learner agent */
    private MasterChangeListener masterChangeListener;

    /* The Monitor's logger. */
    private final Logger logger;
    private final Formatter formatter;

    /* The user designated monitor change listener to be invoked. */
    private MonitorChangeListener monitorChangeListener;

    /* The service dispatcher used by the Learner Agent and the Monitor. */
    private ServiceDispatcher serviceDispatcher;

    /* Set to true to force a shutdown of this monitor. */
    AtomicBoolean shutdown = new AtomicBoolean(false);

    /**
     * Creates a monitor instance using the config object. The
     * <code>monitorConfig</code> must be initialized with the following
     * configuration properties:
     * <ul>
     * <li>The <code>GroupName</code> of the replication group being monitored.
     * </li>
     * <li>The (group wide) unique <code>NodeName</code> associated with this
     * monitor node.</li>
     * <li> The <code>NodeType</code> must be set to
     * <code>NodeType.Monitor</code>
     * <li>The <code>NodeHost</code> identifying the hostname and port on which
     * the monitor can be contacted. </li>
     * <li>The <code>HelperHosts</code> identifying the list of helpers the
     * monitor can contact to register itself so it can receive notifications
     * from the group when there is a change in masters.
     * </ul>
     * @param monitorConfig contains the monitor configuration initialized as
     * described above.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     */
    public Monitor(ReplicationConfig monitorConfig) {
        if (!monitorConfig.getNodeType().equals(NodeType.MONITOR)) {
            throw new IllegalArgumentException
                ("The configured node type was: " +
                 monitorConfig.getNodeType() +
                 " instead of: " + NodeType.MONITOR);
        }
        String groupName = monitorConfig.getGroupName();
        if (groupName == null) {
            throw new IllegalArgumentException("Missing group name");
        }
        nameIdPair = new NameIdPair(monitorConfig.getNodeName());
        String nodeHost = monitorConfig.getNodeHostPort();
        if (nodeHost == null) {
            throw new IllegalArgumentException("Missing nodeHost");
        }
        this.monitorConfig = monitorConfig.clone();
        repGroupAdmin =
            new ReplicationGroupAdmin(groupName,
                                        monitorConfig.getHelperSockets());
        logger = LoggerUtils.getLoggerFormatterNeeded(getClass());
        formatter = new ReplicationFormatter(nameIdPair);
    }

    /**
     * Returns the name of the group associated with the Monitor.
     *
     * @return the group name
     */
    public String getGroupName() {
        return monitorConfig.getGroupName();
    }

    /**
     * @hidden
     * Returns the group-wide unique id associated with the monitor
     *
     * @return the monitor id
     */
    public NameIdPair getMonitorNameIdPair() {
        return nameIdPair;
    }

    /**
     * Returns the group-wide unique name associated with the monitor
     *
     * @return the monitor name
     */
    public String getNodeName() {
        return nameIdPair.getName();
    }

    /**
     * Returns the sock used by this monitor to listen for group changes
     *
     * @return the monitor socket address
     */
    public InetSocketAddress getMonitorSocketAddress() {
        return monitorConfig.getNodeSocketAddress();
    }

    /**
     * Registers the monitor with the group so that it can be kept informed
     * about the outcome of elections and group membership changes. The
     * monitor, just like a replication node, is identified by its nodeName.
     * The Monitor uses the helper nodes to locate a master with which it can
     * register itself. If the helper nodes are not available the registration
     * will fail.
     * <p>
     * A monitor must be registered at least once, if it needs to be kept up to
     * date about ongoing election results and group changes. Attempts to
     * re-register the same monitor are ignored. Registration, once it has
     * been completed successfully persists beyond the lifetime of the Monitor
     * instance and does not need to be repeated. Repeated registrations are
     * benign and merely confirm that the current monitor configuration is
     * consistent with earlier registrations of this monitor.
     *
     * @return the node that is the current master
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the monitor has been shutdown, or no
     * helper sockets were specified at Monitor initialization.
     */
    public ReplicationNode register()
        throws EnvironmentFailureException {

        if (shutdown.get()) {
            throw new IllegalStateException("The monitor has been shutdown");
        }

        if (repGroupAdmin.getHelperSockets().size() == 0) {
            throw new IllegalStateException
                ("No helper sockets were specified at Monitor initialization");
        }
        RepNodeImpl monitorNode =
            new RepNodeImpl(nameIdPair,
                            NodeType.MONITOR,
                            monitorConfig.getNodeHostname(),
                            monitorConfig.getNodePort());
        /* Ensure that the monitor is part of the group. */
        return repGroupAdmin.ensureMonitor(monitorNode);
    }

    /**
     * Starts the Listener so it's actively listening for election results and
     * broadcasts of replication group changes.
     * <p>
     * The Monitor must have been previously registered with the replication
     * group via the <code>register()</code> method so that other nodes in the
     * group are aware of it and can keep it current. If the monitor has not
     * been registered, it will not be updated, that is, its listener will not
     * be invoked. The registration needs to be done exactly once.
     * <p>
     * Once the registration has been completed, the Monitor can start
     * listening even when none of the other nodes in the group are available.
     * It will be contacted automatically by the other nodes when they come up
     * and hold a successful election.
     * <p>
     * Invoking <code>startListener</code> results in a synchronous callback to
     * the application via the
     * {@link MonitorChangeListener#notify(NewMasterEvent)} method, if there is
     * a current Master. If there is no Master at this time then the callback
     * takes place asynchronously, after the method returns, when a Master is
     * eventually elected.
     *
     * @param newListener the listener used to monitor events of interest.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IOException if the monitor socket could not be set up
     *
     * @throws IllegalArgumentException if an invalid parameter is specified.
     *
     * @throws IllegalStateException if the monitor has been shutdown, or a
     * listener has already been established.
     */
    public void startListener(MonitorChangeListener newListener)
        throws DatabaseException, IOException {

        if (shutdown.get()) {
            throw new IllegalStateException("The monitor has been shutdown");
        }
        if (newListener == null) {
            throw new IllegalArgumentException
                ("A MonitorChangeListener must be associated with "  +
                 " this Monitor when invoking this method");
        }
        if (this.monitorChangeListener != null) {
            throw new IllegalStateException
                ("A Listener has already been established");
        }

        this.monitorChangeListener = newListener;

        serviceDispatcher =
            new ServiceDispatcher(monitorConfig.getNodeSocketAddress());
        serviceDispatcher.start();
        Protocol electionProtocol =
            new Protocol(TimebasedProposalGenerator.getParser(),
                         MasterValue.getParser(),
                         monitorConfig.getGroupName(),
                         nameIdPair,
                         null);
        learner = new Learner(electionProtocol, serviceDispatcher, nameIdPair);
        serviceDispatcher.register(new MonitorService(this, 
                                                      serviceDispatcher));
        masterChangeListener = new MasterChangeListener();
        learner.addListener(masterChangeListener);
        learner.start();
        try {
            /* Notify the listener about the current master. */
            final ReplicationGroup repGroup = repGroupAdmin.getGroup();
            final RepGroupImpl group = RepInternal.getRepGroupImpl(repGroup);

            /*
             * In the absence of a network failure, the query should result in
             * a call to the notify method of MonitorChanegListener.
             */
            learner.queryForMaster(group.getLearnerSockets());

            /* Notify JoinGroupEvents for those current active nodes. */
            notifyJoinGroupEventsForActiveNodes(repGroup);
        } catch (UnknownMasterException ume) {
            /* The Listener will be informed when a Master is elected. */
            LoggerUtils.logMsg
                (logger, formatter, Level.INFO, "No current master.");
        }
    }

    /**
     * Notify JoinGroupEvents for currently active nodes in replication group.
     */
    private void notifyJoinGroupEventsForActiveNodes(ReplicationGroup group) {
        NodeStateProtocol stateProtocol =
            new NodeStateProtocol(group.getName(),
                                  NameIdPair.NOCHECK,
                                  null);
        for (ReplicationNode repNode : group.getElectableNodes()) {
            /* Send out a NodeState request message for this electable node. */
            MessageExchange me = stateProtocol.new MessageExchange
                (repNode.getSocketAddress(),
                 NodeStateService.SERVICE_NAME,
                 stateProtocol.new NodeStateRequest(repNode.getName()));
            me.run();
            ResponseMessage resp = me.getResponseMessage();
            if (resp instanceof NodeStateResponse) {
                NodeStateResponse response = (NodeStateResponse) resp;
                notify(new JoinGroupEvent(response.getNodeName(),
                                          response.getMasterName(),
                                          response.getJoinTime()));
            }
        }
    }

    /**
     * Identifies the master of the replication group, resulting from the last
     * successful election. This method relies on the helper nodes supplied
     * to the monitor and queries them for the master.
     *
     * This method is useful when a Monitor first starts up and the Master
     * needs to be determined. Once a Monitor is registered and the Listener
     * has been started, it's kept up to date via events that are delivered
     * to the Listener.
     *
     * @return the id associated with the master replication node.
     *
     * @throws UnknownMasterException if the master could not be determined
     * from the set of helpers made available to the Monitor.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the monitor has been shutdown.
     */
    public String getMasterNodeName()
        throws UnknownMasterException {

        if (shutdown.get()) {
            throw new IllegalStateException("The monitor has been shutdown");
        }
        return repGroupAdmin.getMasterNodeName();
    }

    /**
     * Returns the current composition of the group. It does so by first
     * querying the helpers to determine the master and then obtaining the
     * group information from the master.
     *
     * @return an instance of RepGroup denoting the current composition of the
     * group
     *
     * @throws UnknownMasterException if the master could not be determined
     * from the set of helpers made available to the Monitor.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalStateException if the monitor has been shutdown.
     */
    public ReplicationGroup getGroup()
        throws UnknownMasterException, DatabaseException {

        if (shutdown.get()) {
            throw new IllegalStateException("The monitor has been shutdown");
        }

        /*
         * TODO: Should we use this information to update the helper set as an
         * optimization?
         */
        return repGroupAdmin.getGroup();
    }

    /**
     * Release monitor resources and shut down the monitor.
     * @throws InterruptedException
     */
    public synchronized void shutdown() 
        throws InterruptedException {

        boolean changed = shutdown.compareAndSet(false, true);
        if (!changed) {
            return;
        }
        LoggerUtils.logMsg(logger, formatter, Level.INFO, 
                           "Shutting down monitor " + nameIdPair);
        if (learner != null) {
            learner.shutdown();
        }
        if (serviceDispatcher != null) {
            serviceDispatcher.shutdown();
        }
    }

    /**
     * Notify the MonitorChangeListener that a GroupChangeEvent happens.
     */
    void notify(GroupChangeEvent event) {
        monitorChangeListener.notify(event);
    }

    /**
     * Notify the MonitorChangeListener that a JoinGroupEvent happens.
     */
    void notify(JoinGroupEvent event) {
        monitorChangeListener.notify(event);
    }

    /**
     * Notify the MonitorChangeListener that a LeaveGroupEvent happens.
     */
    void notify(LeaveGroupEvent event) {
        monitorChangeListener.notify(event);
    }

    /**
     * The Listener used to learn about new Masters
     */
    private class MasterChangeListener implements Learner.Listener {
        /* The current learned value. */
        private MasterValue currentValue = null;

        /**
         * Implements the Listener protocol.
         */
        @SuppressWarnings("unused")
        public void notify(Proposal proposal, Value value) {
            /* We have a winning new proposal, is it truly different? */
            if (value.equals(currentValue)) {
                return;
            }
            currentValue = (MasterValue) value;
            try {
                String currentMasterName = currentValue.getNodeName();
                LoggerUtils.logMsg(logger, formatter, Level.INFO,
                                   "Monitor notified of new Master: " +
                                   currentMasterName);
                if (monitorChangeListener == null) {
                    /* No interest */
                    return;
                }
                monitorChangeListener.notify
                    (new NewMasterEvent(currentValue));
            } catch (Exception e) {
                LoggerUtils.logMsg
                    (logger, formatter, Level.SEVERE,
                     "Monitor change event processing exception: " + 
                     e.getMessage());
            }
        }
    }
}
