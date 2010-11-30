/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.jmx;

import javax.management.MBeanException;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.jmx.JEMonitor;
import com.sleepycat.je.rep.ReplicatedEnvironment;
import com.sleepycat.je.rep.RepInternal;

/**
 * A concrete MBean for monitoring a replicated open JE Environment.
 *
 * It not only has the same attributes and operations as the standalone 
 * JEMonitor, but also has some special replicated related operations.
 */
public class RepJEMonitor extends JEMonitor {

    /**
     * @hidden
     *
     *  Name for dumping rep stats operation. 
     */
    public static final String OP_DUMP_REPSTATS = "getReplicationStats";

    /** 
     * @hidden
     *
     * Name for getting rep stats tips. 
     */
    public static final String OP_GET_REP_TIPS = "getRepTips";

    /* Name for getting RepImpl state. */
    static final String OP_DUMP_STATE = "dumpReplicationState";

    /* Define the dumping rep stats operation. */
    private static final MBeanOperationInfo OP_DUMP_REPSTATS_INFO =
        new MBeanOperationInfo
        (OP_DUMP_REPSTATS,
         "Dump environment's replicated stats.",
         statParams, "java.lang.String", MBeanOperationInfo.INFO);

    private static final MBeanOperationInfo OP_DUMP_STATE_INFO =
        new MBeanOperationInfo
        (OP_DUMP_STATE,
         "Dump replicated environment state, including current position in " +
         "replication stream and replication group database.", 
         new MBeanParameterInfo[0],
         "java.lang.String", MBeanOperationInfo.INFO);

    protected RepJEMonitor(Environment env) {
        super(env);
    }

    public RepJEMonitor() {
        super();
    }

    @Override
    protected void initClassFields() {
        currentClass = RepJEMonitor.class;
        className = "RepJEMonitor";
        DESCRIPTION = "Monitor an open replicated Berkeley DB, " +
                      "Java Edition environment.";
    }

    @Override
    public Object invoke(String actionName,
                         Object[] params,
                         String[] signature)
        throws MBeanException {

        if (actionName == null) {
            throw new IllegalArgumentException("ActionName can't be null.");
        }

        try {
            if (actionName.equals(OP_DUMP_REPSTATS)) {
                return ((ReplicatedEnvironment) env).
                    getRepStats(getStatsConfig(params)).toString();
            } else if (actionName.equals(OP_GET_REP_TIPS)) {
                return ((ReplicatedEnvironment) env).getRepStats
                    (getStatsConfig(new Object[] {false, true})).getTips();
            } else if (actionName.equals(OP_DUMP_STATE)) {
                return RepInternal.getRepImpl
                    ((ReplicatedEnvironment) env).dumpState();
            }
        } catch (DatabaseException e) {
            throw new MBeanException(new RuntimeException(e.getMessage()));
        }

        return super.invoke(actionName, params, signature);
    }

    @Override
    protected void doRegisterMBean(Environment useEnv) 
        throws Exception {

        server.registerMBean(new RepJEMonitor(useEnv), jeName);
    }

    @Override
    protected void addOperations() {
        super.addOperations();
        operationList.add(OP_DUMP_REPSTATS_INFO);
        operationList.add(OP_DUMP_STATE_INFO);
    }
}
