/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jmx.plugin;

import java.util.HashMap;

import javax.management.MBeanServerConnection;

import com.sleepycat.je.EnvironmentStats;
import com.sleepycat.je.jmx.JEMonitor;

public class JEStats extends Stats {
    private static final long serialVersionUID = 2327923744424679603L;

    public JEStats(MBeanServerConnection connection) {
        super(connection);
    }

    @Override
    protected void initVariables() {
        statsTitles = EnvironmentStats.getStatGroupTitles();
        opName = JEMonitor.OP_ENV_STAT;
        mBeanNamePrefix = JEStatsPlugin.mBeanNamePrefix;
    }
   
    @SuppressWarnings("unchecked") 
    @Override
    protected void generateTips() {
        try {
            tips = (HashMap) connection.invoke
                (objName, JEMonitor.OP_GET_TIPS, 
                 new Object[] {}, new String[] {});
            updateTips();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
