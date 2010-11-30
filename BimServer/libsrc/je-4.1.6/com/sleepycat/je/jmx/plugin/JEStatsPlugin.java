/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jmx.plugin;

import java.util.LinkedHashMap;

import javax.management.ObjectName;
import javax.swing.JPanel;

public class JEStatsPlugin extends StatsPlugin {
    public static String mBeanNamePrefix = 
        "com.sleepycat.je.jmx:name=*JEMonitor(*";

    @Override
    protected void initTabs() {
        if (tabs == null) {
            tabs = new LinkedHashMap<String, JPanel>();
            try {
                ObjectName name = new ObjectName(mBeanNamePrefix);
                int count = getContext().getMBeanServerConnection().
                    queryNames(name, null).size();

                if (count > 0) {
                    Stats status =
                        new JEStats(getContext().getMBeanServerConnection());
                    tabs.put("JE Statistics", status);
                    stats.add(status);
                } else {
                    tabs.put("JE Statistics", new JPanel());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
