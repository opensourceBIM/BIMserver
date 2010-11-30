/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jmx.plugin;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import com.sun.tools.jconsole.JConsolePlugin;
import com.sun.tools.jconsole.JConsoleContext;
import com.sun.tools.jconsole.JConsoleContext.ConnectionState;

public abstract class StatsPlugin extends JConsolePlugin
    implements PropertyChangeListener {

    protected ArrayList<Stats> stats = new ArrayList<Stats>();
    protected StatsSwingWorker worker;
    protected Map<String, JPanel> tabs = null;
    protected int mBeanCount = 0;

    public StatsPlugin() {
        /* Register as a listener. */
        addContextPropertyChangeListener(this);
    }

    /*
     * Returns JEStats tabs to be added in JConsole.
     */
    @Override
    public synchronized Map<String, JPanel> getTabs() {
        initTabs();

        return tabs;
    }

    protected abstract void initTabs();

    /*
     * Returns a SwingWorker which is responsible for updating the JEStats tab.
     */
    @Override
    public SwingWorker<?,?> newSwingWorker() {
        if (stats.size() > 0) {
            return new StatsSwingWorker(stats);
        }
        return null;
    }

    @Override
    public void dispose() {
    }

    /*
     * Property listener to reset the MBeanServerConnection at reconnection
     * time.
     */
    public void propertyChange(PropertyChangeEvent ev) {
        String prop = ev.getPropertyName();
        if (prop == JConsoleContext.CONNECTION_STATE_PROPERTY) {
            ConnectionState newState = (ConnectionState) ev.getNewValue();
            if (newState == ConnectionState.CONNECTED && stats.size() != 0) {
                for (Stats status : stats) {
                    status.setConnection(
                            getContext().getMBeanServerConnection());
                }
            } else if (newState == ConnectionState.DISCONNECTED &&
                       stats.size() != 0) {
                for (int i = 0; i < stats.size(); i++) {
                    Stats status = stats.remove(i);
                    status.setConnection(null);
                    status = null;
                }
            }
        }
    }
}
