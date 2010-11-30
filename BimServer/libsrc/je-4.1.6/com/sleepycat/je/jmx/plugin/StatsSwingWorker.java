/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jmx.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

/* 
 * The class takes the responsibility for updating the tabs in JConsole plugin.
 */
public class StatsSwingWorker extends 
    SwingWorker<List<List<Map.Entry<String, String>>>, Object> {

    private final ArrayList<Stats> list;

    public StatsSwingWorker(ArrayList<Stats> list) {
        this.list = list;
    }

    @Override
    public List<List<Map.Entry<String, String>>> doInBackground() {
        ArrayList<List<Map.Entry<String, String>>> statsList= 
            new ArrayList<List<Map.Entry<String, String>>>();
        for (Stats status: list) {
            statsList.add(status.getResultsList());
        }

        return statsList;
    }

    @Override
    protected void done() {
        try {
            if (get() != null) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).getTModel().setList(get().get(i));
                    list.get(i).getTModel().fireTableDataChanged();
                }
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
    }
}
