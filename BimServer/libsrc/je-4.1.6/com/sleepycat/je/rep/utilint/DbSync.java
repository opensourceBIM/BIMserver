/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import static com.sleepycat.je.rep.impl.RepParams.NODE_HOST_PORT;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.Durability;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.rep.GroupShutdownException;
import com.sleepycat.je.rep.QuorumPolicy;
import com.sleepycat.je.rep.ReplicatedEnvironment;
import com.sleepycat.je.rep.ReplicationConfig;
import com.sleepycat.je.rep.StateChangeEvent;
import com.sleepycat.je.rep.StateChangeListener;
import com.sleepycat.je.utilint.CmdUtil;

/**
 * DbSync is a utility for ensuring that a group of replication nodes have
 * fully caught up on the replication stream. The target use case is
 * testing. If a replication group has crashed abruptly, nodes may have closed
 * without finishing the full replay of the replication stream and the
 * environments might not have the same contents. This makes it impossible to
 * compare the contents of the environments for correctness.
 * <p>
 * DbSync assumes that all nodes are down. The utility is invoked for each node
 * in the group. The node will come up and rejoin the group, causing the whole
 * group to reach the same point in the replication stream. If the node becomes
 * the master, it will issue a shutdown request. Otherwise, a node is a
 * replica, and will wait for the shutdown message to come, and will then
 * close.
 */
public class DbSync {
    public static final String DBSYNC_ENV = "-env";
    public static final String DBSYNC_GROUP_NAME = "-groupName";
    public static final String DBSYNC_NODE_NAME = "-nodeName";
    public static final String DBSYNC_NODE_HOST = "-nodeHost";
    public static final String DBSYNC_HELPER_HOST = "-helperHost";
    public static final String DBSYNC_TIMEOUT = "-timeout";
    private static final String FORMAT = "%1$-15s";

    private String envHome;
    private String groupName;
    private String nodeName;
    private String nodeHost;
    private String helperHost;
    /* The group shutdown timeout value, in milliseconds. */
    private long timeout;

    private static final String usageString =
        "usage: " + CmdUtil.getJavaCommand(DbSync.class) + "\n" +
        String.format(FORMAT, DBSYNC_ENV) + 
        "# environment home directory for the node\n" +
        String.format(FORMAT, DBSYNC_GROUP_NAME) +
        "# name of the replication group\n" +
        String.format(FORMAT, DBSYNC_NODE_NAME) +
        "# name of the node in the group\n" + 
        String.format(FORMAT, DBSYNC_NODE_HOST) +
        "# host name or IP address and port number for the node\n" +
        String.format(FORMAT, DBSYNC_HELPER_HOST) +
        "# helperHost for the node\n" +
        String.format(FORMAT, DBSYNC_TIMEOUT) +
        "# time for the node to catch up with master, in milliseconds\n";

    public static void main(String[] args) 
        throws Exception {

        DbSync syncup = new DbSync();
        syncup.parseArgs(args);
        syncup.sync();
    }

    private void printUsage(String msg) {
        System.err.println(msg);
        System.err.println(usageString);
        System.exit(-1);
    }

    private void parseArgs(String[] args) 
        throws Exception {

        int argc = 0;
        int nArgs = args.length;

        while (argc < nArgs) {
            String thisArg = args[argc++].trim();
            if (thisArg.equals(DBSYNC_ENV)) {
                if (argc < nArgs) {
                    envHome = args[argc++];
                } else {
                    printUsage(DBSYNC_ENV + " requires an argument");
                }
            } else if (thisArg.equals(DBSYNC_GROUP_NAME)) {
                if (argc < nArgs) {
                    groupName = args[argc++];
                } else {
                    printUsage(DBSYNC_GROUP_NAME + " requires an argument");
                }
            } else if (thisArg.equals(DBSYNC_NODE_NAME)) {
                if (argc < nArgs) {
                    nodeName = args[argc++];
                } else {
                    printUsage(DBSYNC_NODE_NAME + " requires an argument");
                }
            } else if (thisArg.equals(DBSYNC_NODE_HOST)) {
                if (argc < nArgs) {
                    nodeHost = args[argc++];
                } else {
                    printUsage(DBSYNC_NODE_HOST + " requires an argument");
                }
            } else if (thisArg.equals(DBSYNC_HELPER_HOST)) {
                if (argc < nArgs) {
                    helperHost = args[argc++];
                } else {
                    printUsage(DBSYNC_HELPER_HOST + " requires an argument");
                }
            } else if (thisArg.equals(DBSYNC_TIMEOUT)) {
                if (argc < nArgs) {
                    timeout = Long.parseLong(args[argc++]);
                } else {
                    printUsage(DBSYNC_TIMEOUT + " requires an argument");
                }
            }
        }

        if (envHome == null) {
            printUsage(DBSYNC_ENV + " is a required argument.");
        }

        if (groupName == null) {
            printUsage(DBSYNC_GROUP_NAME + " is a required argument.");
        }

        if (nodeName == null) {
            printUsage(DBSYNC_NODE_NAME + " is a required argument.");
        }

        if (nodeHost == null) {
            printUsage(DBSYNC_NODE_HOST + " is a required argument.");
        }

        if (helperHost == null) {
            printUsage(DBSYNC_HELPER_HOST + " is a required argument.");
        }

        if (timeout <= 0) {
            printUsage(DBSYNC_TIMEOUT + " should be a positive long number.");
        }

        try {
            NODE_HOST_PORT.validateValue(nodeHost);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            printUsage("Host and Port pair for this node is illegal.");
        }
    }

    private DbSync() {
    }

    /**
     * Create a DbSync object for the purposed of syncing up a specific
     * replication group.
     *
     * @param envHome The Environment home directories of this replica.
     * @param groupName The replication group name that replicas would join in.
     * @param nodeName The name of this replica.
     * @param nodeHost The host name and port for this replica.
     * @param helperHost The helper host for this replica.
     * @param timeout The permitted time period, in milliseconds, for the
     * replica to catch up with master.
     */
    public DbSync(String envHome, 
                  String groupName, 
                  String nodeName, 
                  String nodeHost,
                  String helperHost,
                  long timeout) {
        this.envHome = envHome;
        this.groupName = groupName;
        this.nodeName = nodeName;
        this.nodeHost = nodeHost;
        this.helperHost = helperHost;
        this.timeout = timeout;
    }

    /**
     * Open this replication node. Block until the node has opened, synced up,
     * and closed.
     */
    public void sync() 
        throws Exception {

        /* 
         * Set the ReplicaAckPolicy to ALL, so that all the replicas can get 
         * into a same sync point.
         */ 
        Durability durability =
            new Durability(Durability.SyncPolicy.WRITE_NO_SYNC,
                           Durability.SyncPolicy.WRITE_NO_SYNC,
                           Durability.ReplicaAckPolicy.ALL);

        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setAllowCreate(true);
        envConfig.setTransactional(true);
        envConfig.setDurability(durability);

        ReplicationConfig repConfig = new ReplicationConfig();
        repConfig.setNodeName(nodeName);
        repConfig.setGroupName(groupName);
        repConfig.setNodeHostPort(nodeHost);
        repConfig.setHelperHosts(helperHost);

        /* Exit if can't create a replicated Environment successfully. */
        StatusListener listener = new StatusListener();
        ReplicatedEnvironment repEnv = null;
        try {
            repEnv = new ReplicatedEnvironment(new File(envHome), 
                                               repConfig, 
                                               envConfig,
                                               null,
                                               QuorumPolicy.ALL);
            repEnv.setStateChangeListener(listener);
        } catch (Exception e) {
            System.err.println("Can't successfully initialize " + 
                               nodeName + " because of " + e);
            System.exit(-1);
        }

        /* Wait until the node becomes active. */
        listener.awaitActiveState();

        if (repEnv.getState().isMaster()) {

            /*
             * If master, start a transaction as a way of ascertaining whether
             * all nodes are up. Since the ReplicaAckPolicy is ALL, the
             * transaction will only begin when all the nodes are available.
             */
            Transaction txn = repEnv.beginTransaction(null, null);
            txn.abort();

            /* Invoke the group shutdown API. */
            repEnv.shutdownGroup(timeout, TimeUnit.SECONDS);
        } else if (repEnv.getState().isReplica()) {
            for (long i = 0; i < timeout; i++) {
                try {

                    /* 
                     * The replica will throw a GroupShutdownException if it
                     * has received and processed the group close command from
                     * the master.
                     */
                    repEnv.getState();
                    Thread.sleep(1000);
                } catch (GroupShutdownException e) {
                    break;
                }
            }
        }
        
        /* Shutdown the replica. */
        repEnv.close();
    }

    /**
     * Wait for this node to become either a master or a replica.
     */
    private class StatusListener implements StateChangeListener {
        CountDownLatch activeLatch = new CountDownLatch(1);

        public void stateChange(StateChangeEvent stateChangeEvent) 
            throws RuntimeException {

            switch (stateChangeEvent.getState()) {
                case MASTER:
                case REPLICA:
                    activeLatch.countDown();
                    break;
                default:
                    System.err.println
                        (nodeName + " is disconnected from group.");
                    break;
            }
        }

        public void awaitActiveState() 
            throws InterruptedException {

            activeLatch.await();
        }
    }
}
