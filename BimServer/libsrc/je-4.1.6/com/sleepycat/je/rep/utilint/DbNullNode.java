/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.utilint;

import java.io.File;
import java.util.Date;

import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentNotFoundException;
import com.sleepycat.je.rep.InsufficientLogException;
import com.sleepycat.je.rep.NetworkRestore;
import com.sleepycat.je.rep.NetworkRestoreConfig;
import com.sleepycat.je.rep.RepInternal;
import com.sleepycat.je.rep.ReplicatedEnvironment;
import com.sleepycat.je.rep.ReplicationConfig;
import com.sleepycat.je.rep.impl.RepGroupDB;
import com.sleepycat.je.rep.impl.RepGroupImpl;
import com.sleepycat.je.rep.impl.RepNodeImpl;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.utilint.CmdUtil;

/**
 * @hidden
 *
 * DbNullNode is an internal debugging aid that simply starts up a node as part
 * of a group. It's primarily useful for diagnosing node start up bugs, since
 * it enables you to start up the nodes in a group if you have the associated
 * log files.
 * <p>
 * If the environment does not exist, and the -createEnv is specified it will
 * create the environment (with the aid of helpers), using network restore to
 * initialize it. This behavior can be used to advantage at a Replica node if
 * the log files have been damaged for example and the Replica cannot proceed.
 * It effectively restores the environment for the Replica, which can then
 * proceed with the restored files using the actual application.
 * <p>
 * Similarly, if a node does not exist in the environment and -createNode is
 * specified, it will create a new node in either the existing environment, or
 * if -createEnv is specified in a new environment.
 * <p>
 * Note that the hostnames mentioned in the member database must be resolveable
 * before the group can start up. The hostnames can be obtained by running
 * DbDumpGroup. The hostnames can be "faked" on Linux, by adding appropriate
 * entries to /etc/hosts or cnames to the DNS.
 * <p>
 * If the hosts all use the same port, you will need to make provisions for
 * virtual ip addresses that are then associated with the host. On Linux this
 * can be done by adding an entry of the following type for each virtual ip in
 * /etc/network/interfaces:
 *<p>
 * iface eth0:1 inet static
 * address 192.168.1.201
 * netmask 255.255.255.0
 * gateway 192.168.2.1
 * hwaddress ether XX:YY:ZZ:AA:BB:CC
 * <p>
 * Use eth0:2, eth0:3, etc for each new virtual ip that is needed. Also,
 * substitute the real NIC address for XX:YY:ZZ:AA:BB:CC in the iface stanza.
 *
 * Be careful when modifying your machine's configuration information since it
 * can have unintended side-effects. So back up the above config files before
 * making any changes.
 */
public class DbNullNode {
    private static final String USAGE =

        "usage: " + CmdUtil.getJavaCommand(DbNullNode.class) + "\n" +
        "       -h <env home dir>\n" +
        "       -nodeName <nodeName>\n" +
        "       [-groupName <groupName>]\n" +
        "       [-hostPort <hostPort>]\n" +
        "       [-createEnv]\n" +
        "       [-createNode]\n" +
        "       [-helpers <hostPort>,<hostPort> ...]\n";

    private File envHome;
    private String nodeName;
    private String hostPort;
    private String groupName;
    public  String helpers;

    /* Permit creation of a new environment. */
    private boolean createNode = false;
    private boolean createEnv = false;

    private final int pollIntervalMs = 60*1000;

    public static void main(String[] argv) {

        DbNullNode runAction = new DbNullNode();
        runAction.parseArgs(argv);

        try {
            runAction.run();
            System.exit(0);
        } catch (Throwable e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private void parseArgs(String argv[]) {

        int argc = 0;
        int nArgs = argv.length;

        if (nArgs < 4) {
            printUsage(null);
            System.exit(0);
        }

        while (argc < nArgs) {
            String thisArg = argv[argc++];
            if (thisArg.equals("-h")) {
                if (argc < nArgs) {
                    envHome = new File(argv[argc++]);
                } else {
                    printUsage("-h requires an argument");
                }
            } else if (thisArg.equals("-nodeName")) {
                if (argc < nArgs) {
                    nodeName = argv[argc++];
                } else {
                    printUsage("-nodeName requires an argument");
                }
            } else if (thisArg.equals("-hostPort")) {
                if (argc < nArgs) {
                    hostPort = argv[argc++];
                } else {
                    printUsage("-hostPort requires an argument");
                }
            } else if (thisArg.equals("-groupName")) {
                if (argc < nArgs) {
                    groupName = argv[argc++];
                } else {
                    printUsage("-groupName requires an argument");
                }
            } else if (thisArg.equals("-createNode")) {
                createNode  = true;
            } else if (thisArg.equals("-createEnv")) {
                createEnv  = true;
            }else if (thisArg.equals("-helpers")) {
                if (argc < nArgs) {
                    helpers = argv[argc++];
                } else {
                    printUsage("-helpers requires an argument");
                }
            } else {
                printUsage(thisArg + " is not a valid argument");
            }
        }
        if (createNode) {
            /* Verify that the create arguments are all specified. */
            if ((nodeName == null) ||
                (hostPort == null) ||
                (groupName == null) ||
                (helpers  == null)) {
                printUsage("groupName, nodeName, nodeHost and helpers " +
                           "must all be specified when using -createNode");
            }
        }
        if (createEnv) {
            if ((groupName == null) || (helpers  == null)) {
                printUsage("groupName and helpers " +
                    "must all be specified when using -createEnv");
            }
        }
    }


    private void run() {
        while (true) {
            try {
                checkParameters();
                openAndIdle();
                break;
            }  catch (InsufficientLogException ile) {
                System.err.println("Restoring environment:" + envHome);
                NetworkRestore networkRestore = new NetworkRestore();
                NetworkRestoreConfig config = new NetworkRestoreConfig();
                networkRestore.execute(ile, config);
                System.err.println("Restored environment:" + envHome);
                createEnv = false; /* The environment has been created. */
                continue;
            }
        }
    }

    /*
     * Verifies that the parameters supplied on the command line are consistent
     * with any stored state in the environment.
     */
    private void checkParameters() {
        try {
            if (!envHome.exists()) {
                printUsage("Directory:" + envHome + " does not exist.");
            }
            final RepGroupImpl group = RepGroupDB.getGroup(envHome);
            if (createEnv) {
                printUsage("Environment exists:" + envHome +
                           "but -createEnv was specified.");
            }
            final RepNodeImpl node = group.getNode(nodeName);
            if (node == null) {
                if (! createNode) {
                    printUsage("The node:" + nodeName +
                               " is not a member of the group:" + group +
                               ". Use -createNode to create a new one.");
                }
            } else {
                /* Node exists, check arguments if any. */
                if (groupName == null) {
                    groupName = group.getName();
                } else if (!groupName.equals(group.getName())) {
                    printUsage("-groupname:" + groupName +
                               ", does match the name:" + group.getName() +
                               " in the environment.");
                }

                if (hostPort == null) {
                    hostPort = node.getHostPortPair();
                } else if (!hostPort.equals(node.getHostPortPair())) {
                    printUsage("-hostPort:" + hostPort +
                               ", does match the hostPort:" +
                               node.getHostPortPair() +
                               " in the environment.");
                }
            }
        } catch (EnvironmentNotFoundException enf) {
            if (!createEnv) {
                printUsage("No existing environment:" + envHome +
                           ". Use -createEnv to create one");
            }
        }
    }

    /**
     * Opens a replicated environment and idles in a loop printing out its
     * state periodically.
     *
     * @throws InsufficientLogException so that the log files can be restored
     * if necessary
     */
    private void openAndIdle()
        throws InsufficientLogException {

        ReplicationConfig repConfig = new ReplicationConfig();
        repConfig.setNodeName(nodeName);
        repConfig.setGroupName(groupName);
        repConfig.setNodeHostPort(hostPort);
        if (helpers != null) {
            repConfig.setHelperHosts(helpers);
        }

        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setTransactional(true);
        envConfig.setAllowCreate(createEnv);
        ReplicatedEnvironment repEnv =
            new ReplicatedEnvironment(envHome, repConfig, envConfig);
        RepNode repNode = RepInternal.getRepImpl(repEnv).getRepNode();

        System.err.println("Handle created:" + repEnv +
                           "  Node idling indefinitely...");
        try {
            while (true) {
                System.out.println(new Date() +
                                   " State:" + repEnv.getState() + " " +
                                   " VLSN range:" +
                                   repNode.getVLSNIndex().getRange() +
                                   repNode.dumpState());
                Thread.sleep(pollIntervalMs);
            }
        } catch (InterruptedException e) {
            System.err.println("Exiting");
        }
    }

    private void printUsage(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }
        System.out.println(USAGE);
        System.exit(-1);
    }
}
