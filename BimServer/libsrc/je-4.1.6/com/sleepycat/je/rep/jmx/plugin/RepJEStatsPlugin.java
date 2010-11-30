/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.jmx.plugin;

import java.util.LinkedHashMap;

import javax.management.ObjectName;
import javax.swing.JPanel;

import com.sleepycat.je.jmx.plugin.JEStats;
import com.sleepycat.je.jmx.plugin.Stats;
import com.sleepycat.je.jmx.plugin.StatsPlugin;

public class RepJEStatsPlugin extends StatsPlugin {
    public static final String mBeanNamePrefix = 
        "com.sleepycat.je.jmx:name=RepJEMonitor(*";

    @Override
    protected void initTabs() {
        if (tabs == null) {
            tabs = new LinkedHashMap<String, JPanel>();
            try {
                ObjectName name = new ObjectName(mBeanNamePrefix);
                mBeanCount = getContext().getMBeanServerConnection().
                    queryNames(name, null).size();

                if (mBeanCount > 0) {
                    Stats status =
                        new JEStats(getContext().getMBeanServerConnection());
                    tabs.put("JE Statistics", status);
                    stats.add(status);
                    status =
                        new RepJEStats(getContext().getMBeanServerConnection());
                    tabs.put("JE Replicated Statistics", status);
                    stats.add(status);
                } else {
                    tabs.put("JE Statistics", new JPanel());
                    tabs.put("JE Replicated Statistics", new JPanel());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
