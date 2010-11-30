/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util;

import static com.sleepycat.je.rep.impl.RepParams.NODE_HOST_PORT;

import java.io.File;

import com.sleepycat.je.Durability;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.rep.RepInternal;
import com.sleepycat.je.rep.ReplicatedEnvironment;
import com.sleepycat.je.rep.ReplicationConfig;

/**
 * A utility to convert an existing, non replicated JE environment for
 * replication. This is useful when the user wants to initially prototype and
 * develop a standalone transactional application, and then add replication as
 * a second stage.
 * <p>
 * JE HA environment log files contain types of log records and metadata used
 * only by replication. Non replicated environments are lacking that
 * information and must undergo a one time conversion process to add that
 * metadata and enable replication. The conversion process is one way. Once an
 * environment directory is converted, the rules that govern {@link
 * ReplicatedEnvironment} apply; namely, the directory cannot be opened by a
 * read/write standalone {@link com.sleepycat.je.Environment}. Only a minimum
 * amount of replication metadata is added, and the conversion process is not
 * dependent on the size of the existing directory.
 * <p>
 * The conversion process takes these steps:
 * <ol>
 * <li> Use {@code DbEnableReplication} to convert an existing environment
 * directory. {@code DbEnableReplication} can be used as a command line
 * utility, and must be executed locally on the host which houses the
 * environment directory. Alternatively, {@code DbEnableReplication} may be
 * used programmatically through the provided APIs.
 * </li>
 * <li> Once converted, the environment directory may be treated as an existing
 * master node, and can be opened with a {@code ReplicatedEnvironment}. No
 * helper host configuration is needed.
 * <li> Additional nodes may be created and can join the group as newly created
 * replicas, as described in {@code ReplicatedEnvironment}.  Since these new
 * nodes are empty, they should be configured to use the converted master as
 * their helper node, and will go through the {@link <a
 * href="{@docRoot}/../ReplicationGuide/lifecycle.html#lifecycle-nodestartup">
 * replication node lifecycle</a>} to populate their environment
 * directories. In this case, there will be data in the converted master that
 * can only be transferred to the replica through a file copy executed with the
 * help of a {@link com.sleepycat.je.rep.NetworkRestore}
 * </li>
 * </ol>
 * <p>
 * For example:
 * <pre class="code">
 * // Create the first node using an existing environment 
 * DbEnableReplication converter = 
 *     new DbEnableReplication(envDirMars,          // env home dir
 *                             "UniversalRepGroup", // group name
 *                             "nodeMars",          // node name
 *                             "mars:5001");        // node host,port
 * converter.convert();
 *
 * ReplicatedEnvironment nodeMars = new ReplicatedEnvironment(envDirMars, ...);
 * 
 * // Bring up additional nodes, which will be initialized from 
 * // nodeMars.
 * ReplicationConfig repConfig = null;
 * try {
 *     repConfig = new ReplicationConfig("UniversalRepGroup", // groupName
 *                                       "nodeVenus",         // nodeName
 *                                       "venus:5008");       // nodeHostPort
 *     repConfig.setHelperHosts("mars:5001");
 * 
 *     nodeVenus = new ReplicatedEnvironment(envDirB, repConfig, envConfig);
 * } catch (InsufficientLogException insufficientLogEx) {
 * 
 *     // log files will be copied from another node in the group
 *     NetworkRestore restore = new NetworkRestore();
 *     restore.execute(insufficientLogEx, new NetworkRestoreConfig());
 *     
 *     // try opening the node now
 *     nodeVenus = new ReplicatedEnvironment(envDirVenus, 
 *                                           repConfig,
 *                                           envConfig);
 * }
 * ...
 * </pre>
 */
public class DbEnableReplication {

    /* 
     * The code snippet in the header comment is tested in 
     * com.sleepycat.je.rep.util.EnvConvertTest.
     * testJavadocForDbEnableReplication(). Please update this test case
     * when the example is changed.
     */
    private File envHome;
    private String groupName;
    private String nodeName;
    private String nodeHostPort;

    private static final String usageString =
        "usage: java -cp je.jar " +
        "com.sleepycat.je.rep.util.DbEnableReplication\n" + 
        " -h <dir>                              # environment home directory\n" +
        " -groupName <group name>               # replication group name\n" +
        " -nodeName <node name>                 # replicated node name\n" +
        " -nodeHostPort <host name:port number> # host name or IP address\n" +
        "                                          and port number to use\n" +
        "                                          for this node\n";

    /**
     * Usage:
     * <pre>
     * java -cp je.jar com.sleepycat.je.rep.util.DbEnableReplication
     *   -h &lt;dir&gt;                          # environment home directory
     *   -groupName &lt;group name&gt;           # replication group name
     *   -nodeName &lt;node name&gt;             # replicated node name
     *   -nodeHostPort &lt;host name:port number&gt; # host name or IP address
     *                                             and port number to use
     *                                             for this node
     * </pre>
     */
    public static void main(String[] args) {
        DbEnableReplication converter = new DbEnableReplication();
        converter.parseArgs(args);

        try {
            converter.convert();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void printUsage(String msg) {
        System.err.println(msg);
        System.err.println(usageString);
        System.exit(-1);
    }

    private void parseArgs(String[] args) {
        int argc = 0;
        int nArgs = args.length;

        while (argc < nArgs) {
            String thisArg = args[argc++].trim();
            if (thisArg.equals("-h")) {
                if (argc < nArgs) {
                    envHome = new File(args[argc++]);
                } else {
                    printUsage("-h requires an argument");
                }
            } else if (thisArg.equals("-groupName")) {
                if (argc < nArgs) {
                    groupName = args[argc++];
                } else {
                    printUsage("-groupName requires an argument");
                }
            } else if (thisArg.equals("-nodeName")) {
                if (argc < nArgs) {
                    nodeName = args[argc++];
                } else {
                    printUsage("-nodeName requires an argument");
                }
            } else if (thisArg.equals("-nodeHostPort")) {
                if (argc < nArgs) {
                    nodeHostPort = args[argc++];
                    try {
                        NODE_HOST_PORT.validateValue(nodeHostPort);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        printUsage("-nodeHostPort is illegal!");
                    }
                } else {
                    printUsage("-nodeHostPort requires an argument");
                }
            }
        }

        if (envHome == null) {
            printUsage("-h is a required argument.");
        }

        if (groupName == null) {
            printUsage("-groupName is a required argument.");
        }

        if (nodeName == null) {
            printUsage("-nodeName is a required argument.");
        }

        if (nodeHostPort == null) {
            printUsage("-nodeHostPort is a required argument.");
        }
    }

    private DbEnableReplication() {
    }

    /**
     * Create a DbEnableReplication object for this node.
     *
     * @param envHome The node's environment directory
     * @param groupName The name of the new replication group
     * @param nodeName The node's name
     * @param nodeHostPort The host and port for this node
     */
    public DbEnableReplication(File envHome, 
                               String groupName, 
                               String nodeName, 
                               String nodeHostPort) {
        this.envHome = envHome;
        this.groupName = groupName;
        this.nodeName = nodeName;
        this.nodeHostPort = nodeHostPort;
    }

     /**
     * Modify the log files in the environment directory to add a modicum of
     * replication required metadata.
     */
     public void convert() {

        Durability durability =
            new Durability(Durability.SyncPolicy.WRITE_NO_SYNC,
                           Durability.SyncPolicy.WRITE_NO_SYNC,
                           Durability.ReplicaAckPolicy.SIMPLE_MAJORITY);

        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setAllowCreate(true);
        envConfig.setTransactional(true);
        envConfig.setDurability(durability);

        ReplicationConfig repConfig = 
            new ReplicationConfig(groupName, nodeName, nodeHostPort);
        repConfig.setHelperHosts(repConfig.getNodeHostPort());
        RepInternal.setAllowConvert(repConfig, true);

        ReplicatedEnvironment repEnv = 
            new ReplicatedEnvironment(envHome, repConfig, envConfig);

        repEnv.close();
    }
}
