/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Set;

import com.sleepycat.je.rep.impl.RepGroupImpl;
import com.sleepycat.je.rep.impl.RepNodeImpl;
import com.sleepycat.je.rep.utilint.HostPortPair;
import com.sleepycat.je.utilint.CmdUtil;

/**
 * DbGroupAdmin supplies the functionality of the administrative class {@link
 * ReplicationGroupAdmin} in a convenient command line utility. For example, it
 * can be used to display replication group information, or to remove a node
 * from the replication group.
 * <p>
 * Note: This utility does not handle security and authorization. It is left
 * to the user to ensure that the utility is invoked with proper authorization.
 * <p>
 * See {@link DbGroupAdmin#main} for a full description of the command line
 * arguments. 
 */
public class DbGroupAdmin {

    enum Command { DUMP, REMOVE };

    private String groupName;
    private Set<InetSocketAddress> helperSockets;
    private String nodeName;
    private ReplicationGroupAdmin groupAdmin;
    private final ArrayList<Command> actions = new ArrayList<Command>();

    private static final String usageString =
        "Usage: " + CmdUtil.getJavaCommand(DbGroupAdmin.class) + "\n" +
        "  -groupName <group name>   # name of replication group\n" +
        "  -helperHosts <host:port>  # identifier for one or more members\n" +
        "                            # of the replication group which can\n"+
        "                            # be contacted for group information,\n"+
        "                            # in this format:\n" +
        "                            # hostname[:port][,hostname[:port]]\n" +
        "  -dumpGroup                # dump group information\n" +
        "  -removeMember <node name> # node to be removed\n";


    /**
     * Usage:
     * <pre>
     * java {com.sleepycat.je.rep.util.DbGroupAdmin |
     *       -jar je-&lt;version&gt;.jar DbGroupAdmin}
     *   -groupName &lt;group name&gt;  # name of replication group
     *   -helperHosts &lt;host:port&gt; # identifier for one or more members
     *                            # of the replication group which can be
     *                            # contacted for group information, in
     *                            # this format:
     *                            # hostname[:port][,hostname[:port]]*
     *   -dumpGroup               # dump group information   
     *   -removeMember &lt;node name&gt;# node to be removed
     * </pre>
     */
    public static void main(String args[]) 
        throws Exception {

        DbGroupAdmin admin = new DbGroupAdmin();
        admin.parseArgs(args);
        admin.run();
    }

    /**
     * Print usage information for this utility.
     *
     * @param message
     */
    private void printUsage(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }

        System.out.println(usageString);
        System.exit(-1);
    }


    /**
     * Parse the command line parameters.
     *
     * @param argv Input command line parameters.
     */
    private void parseArgs(String argv[]) {
        int argc = 0;
        int nArgs = argv.length;

        if (nArgs == 0) {
            printUsage(null);
            System.exit(0);
        }

        while (argc < nArgs) {
            String thisArg = argv[argc++];
            if (thisArg.equals("-groupName")) {
                if (argc < nArgs) {
                    groupName = argv[argc++];
                } else {
                    printUsage("-groupName requires an argument");
                }
            } else if (thisArg.equals("-helperHosts")) {
                if (argc < nArgs) {
                    helperSockets = HostPortPair.getSockets(argv[argc++]);
                } else {
                    printUsage("-helperHosts requires an argument");
                }
            } else if (thisArg.equals("-dumpGroup")) {
                actions.add(Command.DUMP);
            } else if (thisArg.equals("-removeMember")) {
                if (argc < nArgs) {
                    nodeName = argv[argc++];
                    actions.add(Command.REMOVE);
                } else {
                    printUsage("-removeMember requires an argument");
                }
            } else {
                printUsage(thisArg + " is not a valid argument");
            }
        }
    }

    /* Execute commands */
    private void run()
        throws Exception {

        createGroupAdmin();

        if (actions.size() == 0) {
            return;
        }

        for (Command action : actions) {
            /* Dump the group information. */
            if (action == Command.DUMP) {
                dumpGroup();
            }

            /* Remove a member. */
            if (action == Command.REMOVE) {
                removeMember(nodeName);
            }
        }
    }

    private DbGroupAdmin() {
    }

    /**
     * Create a DbGroupAdmin instance for programmatic use.
     *
     * @param groupName replication group name
     * @param helperSockets set of host and port pairs for group members which
     * can be queried to obtain group information.
     */
    public DbGroupAdmin(String groupName,
                        Set<InetSocketAddress> helperSockets) {
        this.groupName = groupName;
        this.helperSockets = helperSockets;
        createGroupAdmin();
    }

    /* Create the ReplicationGroupAdmin object. */
    private void createGroupAdmin() {
        if (groupName == null) {
            printUsage("Group name must be specified");
        }

        if ((helperSockets == null) || (helperSockets.size() == 0)) {
            printUsage("Host and ports of helper nodes must be specified");
        }

        groupAdmin = new ReplicationGroupAdmin(groupName, helperSockets);
    }

    /**
     * Display group information. Lists all members and the group master.  Can
     * be used when reviewing the <a
     * href="http://www.oracle.com/technology/products/berkeley-db/faq/je_faq.html#HAChecklist>group configuration. </a> 
     */
    public void dumpGroup() {
        System.out.println(getFormattedOutput());
    }

    /**
     * Remove a node from the replication group. Once removed, a
     * node cannot be added again to the group under the same node name.
     *
     * @param name name of the node to be removed
     * @see ReplicationGroupAdmin#removeMember
     */
    public void removeMember(String name) {
        if (name == null) {
            printUsage("Node name must be specified");
        }

        groupAdmin.removeMember(name);
    }

    /*
     * This method presents group information in a user friendly way. Internal
     * fields are hidden.
     */
    private String getFormattedOutput() {
        StringBuilder sb = new StringBuilder();
        RepGroupImpl repGroupImpl = groupAdmin.getGroup().getRepGroupImpl();

        /* Get the master node name. */
        String masterName = groupAdmin.getMasterNodeName(); 

        /* Get the electable nodes information. */
        sb.append("\nGroup: " + repGroupImpl.getName() + "\n");
        sb.append("Electable Members:\n");
        Set<RepNodeImpl> nodes = repGroupImpl.getAllElectableMembers();
        if (nodes.size() == 0) {
            sb.append("    No electable members\n");
        } else {
            for (RepNodeImpl node : nodes) {
                String type = 
                    masterName.equals(node.getName()) ? "master, " : "";
                sb.append("    " + node.getName() + " (" + type +
                          node.getHostName() + ":" + node.getPort() + ", " +
                          node.getBarrierState() + ")\n");
            }
        }

        /* Get the monitors information. */
        sb.append("\nMonitor Members:\n");
        nodes = repGroupImpl.getMonitorNodes();
        if (nodes.size() == 0) {
            sb.append("    No monitors\n");
        } else {
            for (RepNodeImpl node : nodes) {
                sb.append("    " + node.getName() + " (" + node.getHostName() +
                          ":" + node.getPort() + ")\n");
            }
        }

        return sb.toString();
    }
}
