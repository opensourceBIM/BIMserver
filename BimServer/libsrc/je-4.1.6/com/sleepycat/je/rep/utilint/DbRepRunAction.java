/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import java.io.File;

import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.rep.RepInternal;
import com.sleepycat.je.rep.ReplicatedEnvironment;
import com.sleepycat.je.rep.ReplicationConfig;
import com.sleepycat.je.utilint.CmdUtil;

/**
 * @hidden
 * RepRunAction is a debugging aid that invokes a ReplicatedEnvironment recovery
 * from the command line.
 */
public class DbRepRunAction {
    private static final String USAGE =

        "usage: " + CmdUtil.getJavaCommand(DbRepRunAction.class) + "\n" +
        "       -h <dir> # environment home directory\n" +
        "       -group <name> # groupName\n" +
        "       -name <name> # nodeName\n" +
        "       -host <host> # nodeHost\n";

    private File envHome;
    private String nodeName;
    private String nodeHost;
    private String groupName;

    public static void main(String[] argv) {

        DbRepRunAction runAction = new DbRepRunAction();
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
            } else if (thisArg.equals("-name")) {
                if (argc < nArgs) {
                    nodeName = argv[argc++];
                } else {
                    printUsage("-name requires an argument");
                }
            } else if (thisArg.equals("-host")) {
                if (argc < nArgs) {
                    nodeHost = argv[argc++];
                } else {
                    printUsage("-host requires an argument");
                }
            } else if (thisArg.equals("-group")) {
                if (argc < nArgs) {
                    groupName = argv[argc++];
                } else {
                    printUsage("-group requires an argument");
                }
            } else {
                printUsage(thisArg + " is not a valid argument");
            }
        }
    }

    private void run() {
        ReplicatedEnvironment repEnv = recover();
        repEnv.close();
    }

    private ReplicatedEnvironment recover() {
        ReplicationConfig repConfig = new ReplicationConfig();
        repConfig.setNodeName(nodeName);
        repConfig.setGroupName(groupName);
        repConfig.setNodeHostPort(nodeHost);

        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setTransactional(true);

        return RepInternal.createDetachedEnv(envHome,
                                             repConfig,
                                             envConfig);

    }

    private void printUsage(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }
        System.out.println(USAGE);
        System.exit(-1);
    }
}
