/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jmx.plugin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.ToolTipManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import sun.tools.jconsole.PlotterPanel;
import sun.tools.jconsole.TimeComboBox;
import sun.tools.jconsole.Plotter.Unit;

public abstract class Stats extends JPanel {

    private static final long serialVersionUID = 6041540234044035106L;
    private static final String STATS_COLLECTOR = "JEMonitor Stats Collector";

    private boolean hideZeroValue = false;
    private boolean doLog = false;
    private int mBeansNum;
    private int selectedRow = -1;

    private long statsIntervalMillis = 10000;

    /* Collection variables used in this file. */
    private Map<ObjectName, LogObject> logMap;
    private Map<String, Boolean> shownStats;
    private Map<ObjectName, Map<String, String>> valueStore;
    private List<GraphFrame> frameList;
    protected TreeMap<String, ObjectName> comboToObjects;

    /*
     * Collections used to save Stats and ObjectNames for showing in tab. 
     * These values are set by the statsCollector Timer thread, and may
     * be concurrently read by other threads, such as the JConsole refresh
     * thread.
     */
    private Map<ObjectName, Map<String, String>> savedStats; 
    private volatile List<ObjectName> savedObjectNames;

    /* Combo box for selecting a MBean. */
    private final int mBeanComboBoxLength = 50;
    private JComboBox mBeansComboBox;
    private ActionListener mBeanComboBoxListener;

    /* Stats table settings. */
    private JCheckBox hideZeroValueBox;
    private JCheckBox cumulativeStatsBox;
    private JTextField statsIntervalText;

    /* Stats logging settings. */
    private JButton saveLogButton;
    private JButton startLogButton;
    private JButton stopLogButton;
    private SaveLogFileChooser fileChooser;

    /* Stats table components. */
    private JTable statsTable;
    private StatsTableModel statsModel;
    private JPopupMenu popup;
    private JCheckBoxMenuItem logMenuItem;
    private JMenuItem graphMenuItem;

    /* MBean related parameters, customized in subclasses. */
    private final Object[] envStatParams = 
        new Object[] {true /* setClear */, true /* setFast */ };
    private final String[] signature =
        new String[] {"java.lang.boolean", "java.lang.boolean" };
    protected static MBeanServerConnection connection;
    protected String[] statsTitles;
    protected String opName;
    protected String mBeanNamePrefix;
    protected ObjectName objName;
    protected Map<String, String> tips;

    private Timer statsCollector;
    private final TimerTask drawNewStats = new StatsCollectionTask(false);

    public Stats(MBeanServerConnection connection) {
        Stats.connection = connection;

        setLayout(new FlowLayout());
        ToolTipManager.sharedInstance().setDismissDelay(10000);

        initVariables();

        /* Initiate those containers. */
        initContainers();

        /* Create GUI components. */
        initGUIs();

        /* Start collecting stats. */
        statsCollector = new Timer(STATS_COLLECTOR);
        statsCollector.scheduleAtFixedRate(new StatsCollectionTask(),
                                           0, statsIntervalMillis);

        /* Draw the stats tab when the plugin is first started. */
        drawNewStats.run();
    }

    public StatsTableModel getTModel() {
        return statsModel;
    }

    protected abstract void initVariables();

    protected abstract void generateTips();

    private void initContainers() {
        valueStore = new HashMap<ObjectName, Map<String, String>>();
        logMap = new HashMap<ObjectName, LogObject>();
        shownStats = new HashMap<String, Boolean>();
        comboToObjects = new TreeMap<String, ObjectName>();
        frameList = new ArrayList<GraphFrame>();

        savedStats = new ConcurrentHashMap<ObjectName, Map<String, String>>();
        savedObjectNames = new ArrayList<ObjectName>();

        for (ObjectName name : getBeansNames()) {
            Map<String, String> storeMap =
                new LinkedHashMap<String, String>();
            Map<String, String> map = generateStats(name);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key.contains(":")) {
                    storeMap.put(key.substring(0, key.indexOf(":")), "0");
                } else {
                    storeMap.put(key, "0");
                }
            }
            valueStore.put(name, storeMap);
            logMap.put(name, new LogObject());
            comboToObjects.put(getMBeanComboBoxString(name), name);
        }

        for (int i = 0; i < statsTitles.length; i++) {
            shownStats.put(statsTitles[i], true);
        }

        this.objName = getFirstObjectName();
        this.mBeansNum = logMap.size();

        generateTips();
    }

    private ObjectName getFirstObjectName() {
        return comboToObjects.firstEntry().getValue();
    }

    /* Update the tips to html format suitable. */
    protected void updateTips() {
        for (Map.Entry<String, String> entry : tips.entrySet()) {
            String value = entry.getValue();
            String formatStr = new String();
            boolean stop = false;
            while (!stop) {
                if (value.length() <= 80) {
                    stop = true;
                    formatStr += value;
                } else {
                    int endIndex = 79;
                    String phrase = value.substring(0, endIndex);
                    if (!phrase.endsWith(" ")) {
                        endIndex = phrase.lastIndexOf(" ");
                    }
                    formatStr += value.substring(0, endIndex) + "<br>";
                    value = value.substring(endIndex, value.length());
                }
            }
            formatStr = "<html>" + formatStr + "</html>";
            tips.put(entry.getKey(), formatStr);
        }
    }

    private void initGUIs() {
        /* panel for selecting a specific environment. */
        JPanel mBeanPanel = createMBeanPanel();
        /* panel for stat settings. */
        JPanel setPanel = createSettingPanel();
        /* controls for logging stats to a file. */
        JPanel logPanel = createLogPanel();
        /* display of stats values. */
        JPanel statsPanel = createStatsPanel();

        createMenu();

        add(mBeanPanel);
        add(setPanel);
        add(logPanel);
        add(statsPanel);
    }

    /* Create the GUI Setting part. */
    private JPanel createMBeanPanel() {
        mBeansComboBox = new JComboBox();
        mBeansComboBox.setPrototypeDisplayValue(generateString());
        mBeanComboBoxListener = new BeanComboBoxListener();
        initMBeanComboBox(getBeansNames());

        return generatePanel(new JComponent[] {
            new JLabel("Choose JE Environment:"), mBeansComboBox }, 
            new FlowLayout(), "Choose JE MBean");
    }

    /* Fill MBeanComboBox with blank spaces if MBean name is too short. */
    private String generateString() {
        String length = new String();
        for (int i = 0; i < mBeanComboBoxLength; i++) {
            length += "X";
        }

        return length;
    }

    /* Initialize the contents of the mbean combobox. */
    private void initMBeanComboBox(List<ObjectName> names) {
        /* If the number of MBeans changes, update the map also. */
        if (names.size() != comboToObjects.size()) {
            comboToObjects = new TreeMap<String, ObjectName>();
            for (ObjectName name : names) {
                comboToObjects.put(getMBeanComboBoxString(name), name);
            }
        }

        for (Map.Entry<String, ObjectName> entry : comboToObjects.entrySet()) {
            mBeansComboBox.addItem(entry.getKey());
        }
        mBeansComboBox.setSelectedIndex(0);
        mBeansComboBox.addActionListener(mBeanComboBoxListener);
    }

    /* Return the MBean name to display in the mBeanComboBox. */
    private String getMBeanComboBoxString(ObjectName name) {
        String envHome = name.toString().substring
            (name.toString().indexOf("(") + 1, name.toString().length() - 1);
        if (envHome.length() > 40) {
            envHome = envHome.substring(0, 19) + "..." +
                envHome.substring(envHome.length() - 20, envHome.length());
        }

        return envHome;
    }

    /* Create the stats setting panel. */
    private JPanel createSettingPanel() {
        cumulativeStatsBox = new JCheckBox("Display cumulative stats", false);
        cumulativeStatsBox.addActionListener(new ClearStatsBoxListener());

        hideZeroValueBox = new JCheckBox("Hide zero values", false);
        hideZeroValueBox.addActionListener(new HideZeroValueBoxListener());

        statsIntervalText = new JTextField("10", 4);
        statsIntervalText.addKeyListener(new StatsIntervalListener());

        return generatePanel(new JComponent[] {
                new JLabel("Collection interval (secs):"),
                statsIntervalText,
                cumulativeStatsBox, 
                hideZeroValueBox} ,
                new FlowLayout(), "Settings");
    }

    /* Create the log setting panel. */
    private JPanel createLogPanel() {
        startLogButton =
            createButton("Start Recording", new StartLogListener());
        startLogButton.setEnabled(false);
        stopLogButton = createButton("Stop Recording", new StopLogListener());
        stopLogButton.setEnabled(false);
        saveLogButton = createButton("Record Statistics To ...",
                                     new SaveLogListener(this));

        return generatePanel(new JComponent[] {
            startLogButton, stopLogButton, saveLogButton },
                new FlowLayout(), "Record Statistics");
    }

    /* Create Table Panel. */
    private JPanel createStatsPanel() {
        /* Create the stats type choosen panel. */
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(15, 1));
        leftPanel.add(new JLabel("  Stats to Display"));
        for (int i = 0; i < statsTitles.length; i++) {
            createCheckBox(statsTitles[i], leftPanel);
        }
        JScrollPane left = new JScrollPane(leftPanel);

        /* Add JE stats table. */
        statsModel = new StatsTableModel();
        statsTable = new JTable(statsModel);
        statsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        statsTable.setDefaultRenderer(String.class, new StringRenderer());
        statsTable.setIntercellSpacing(new Dimension(6, 3));
        statsTable.setRowHeight(statsTable.getRowHeight() + 4);
        statsTable.addMouseListener(new TableMouseListener());
        statsTable.addMouseMotionListener(new TableMouseMotionListener());
        JScrollPane right = new JScrollPane(statsTable);
        right.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSplitPane splitPane =
            new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.3);

        /* Add table to a panel and set the layout. */
        return generatePanel(new JComponent[] { splitPane },
                             new FlowLayout(), "JE Stats Table");
    }

    /* Create the pop up menu for the stats shown table. */
    private void createMenu() {
        popup = new JPopupMenu();
        logMenuItem = new JCheckBoxMenuItem("Log This Stat");
        logMenuItem.addActionListener(new LogMenuListener());
        popup.add(logMenuItem);
        graphMenuItem = new JMenuItem("Graph This Stat");
        graphMenuItem.addActionListener(new GraphMenuListener());
        popup.add(graphMenuItem);
    }

    /* Create CheckBox for choosing shown stats. */
    private void createCheckBox(String title, JPanel container) {
        JCheckBox checkBox = new JCheckBox(title, true);
        checkBox.addActionListener(new StatsTypeListener());
        container.add(checkBox);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);

        return button;
    }

    /*
     * Add provided components to a panel using assigned layout
     * with a broder surrounded.
     */
    private JPanel generatePanel(JComponent[] components,
                                 LayoutManager layout,
                                 String panelName) {
        JPanel panel = new JPanel(layout);
        for (JComponent component : components) {
            panel.add(component);
        }

        /* If the panelName is none, then no border would be added. */
        if (!"none".equals(panelName)) {
            panel.setBorder
                (BorderFactory.createCompoundBorder
                 (BorderFactory.createTitledBorder(panelName),
                  BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        }

        return panel;
    }

    /* Set the connection for this plugin. */
    public void setConnection(MBeanServerConnection connection) {
        Stats.connection = connection;
    }

    /* Get the connection to the MBeanServer. */
    public static MBeanServerConnection getConnection() {
        return connection;
    }

    /* Remove a GraphFrame from the list and release the resouces. */
    public void removeGraphFrame(ObjectName beanName,
                                 String graphStats) {
        CopyOnWriteArrayList<GraphFrame> list =
            new CopyOnWriteArrayList<GraphFrame>(frameList);
        for (GraphFrame frame : list) {
            if (frame.getBeanName().equals(beanName) &&
                frame.getStatsName().equals(graphStats)) {
                frameList.remove(frame);
                frame = null;
            }
        }
    }

    /* Get results for table stats. */
    public synchronized List<Map.Entry<String, String>> getResultsList() {

        if (savedObjectNames == null || savedObjectNames.size() == 0) {
            return null;
        }

        /* Refresh the table if there is an MBean change. */
        repaintComboBox(savedObjectNames);

        Map<String, String> displayStats = savedStats.get(objName);

        if (displayStats == null || displayStats.size() == 0) {
            return null;
        }

        /* Remove the those stats we don't want to show on table. */
        removeUnShownTypeStats(displayStats);

        /* Hide zero values if we choose to hide them. */
        if (hideZeroValue) {
            hideZeroValues(displayStats);
        }

        /* If no stats are removed from shown, add a null stats on table. */
        if (displayStats.size() == 0) {
            displayStats.put("No Stats", "");
        }

        List<Map.Entry<String, String>> list =
            new ArrayList<Map.Entry<String, String>>(displayStats.entrySet());

        return list;
    }

    /*
     * Go through the stats map to remove those stats which belongs to the
     * unshown types chosen by users.
     */
    private void removeUnShownTypeStats(Map<String, String> map) {
        Object[] keys = map.keySet().toArray();
        for (Map.Entry<String, Boolean> stats : shownStats.entrySet()) {

            /* If the stats is not chosen, remove it from map. */
            if (!stats.getValue()) {
                for (Object key : keys) {
                    if (key.toString().contains(stats.getKey())) {
                        map.remove(key.toString());
                    }
                }
            }
        }
        emptyArray(keys);
        keys = null;
    }

    /* Empty the array to release the resources it requires. */
    private static void emptyArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    /*
     * Hide zero values from the stats table, if all stats belongs to a type
     * are all zero values, then the whole type would remove from table,
     * including the stats title, like: Compression stats, etc.
     */
    private void hideZeroValues(Map<String, String> map) {
        Object[] keys = map.keySet().toArray();
        for (Map.Entry<String, Boolean> entry : shownStats.entrySet()) {
            boolean deleteAll = true;
            for (Object key : keys) {
                String value = map.get(key.toString());
                /* Ensure we are operating on a non-deleted stat. */
                if (key.toString().contains(entry.getKey()) && value != null) {
                    if (!(value.equals(""))) {
                        if (value.equals("0")) {
                            map.remove(key.toString());
                        } else {
                            deleteAll = false;
                        }
                    }
                }
            }
            if (deleteAll) {
                map.remove(entry.getKey());
            }
        }
        emptyArray(keys);
        keys = null;
    }

    /* Get results of the invoked MBean operation. */
    private synchronized Map<String, String> generateStats(ObjectName name) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        try {
            if (connection != null &&
                connection.queryNames(name, null) != null) {
                String status = (String)
                    connection.invoke(name, opName, envStatParams, signature);
                StringTokenizer st1 = new StringTokenizer(status, "\n");
                String title = null;
                while (st1.hasMoreTokens()) {
                    String expression = st1.nextToken();
                    if (expression != null) {
                        if (expression.indexOf("=") < 0) {
                            StringTokenizer st2 =
                                new StringTokenizer(expression, ":");
                            title = st2.nextToken();
                            map.put(title, "");
                        } else {
                            StringTokenizer st2 =
                                new StringTokenizer(expression, "=");
                            String stats = "    " + st2.nextToken();
                            String value = st2.nextToken().trim();
                            map.put(stats + ":" + title, value);
                        }
                    }
                }
            }
        } catch (javax.management.InstanceNotFoundException e) {

            /*
             * If the connection is broken while it is trying to invoke, close
             * and release all resources.
             */
            forceClose();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    /* Stop and null the log and graph thread, close all the file writers. */
    private void forceClose() {
        setConnection(null);
        for (Map.Entry<ObjectName, LogObject> item : logMap.entrySet()) {
            item.getValue().closeFileWriter();
        }
    }

    /* Return the JEMonitor MBean names in this application. */
    private synchronized ArrayList<ObjectName> getBeansNames() {
        if (connection == null) {
            return null;
        }

        ArrayList<ObjectName> names = null;
        try {
            ObjectName name = new ObjectName(mBeanNamePrefix);

            if (connection.queryNames(name, null).size() != 0) {
                names = new ArrayList<ObjectName>
                    (connection.queryNames(name, null));
            }
        } catch (java.rmi.RemoteException e) {

            /*
             * Because the interval of plugin and the logging thread is not the
             * same, sometimes logging thread would try to invoke a non-active
             * connection and throws out RemoteException.  We need to stop the
             * thread and release the resources.
             */
            forceClose();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return names;
    }

    /* Repaint mbeans combobox if the number of MBeans changes. */
    private void repaintComboBox(List<ObjectName> names) {
        if (names == null) {
            return;
        }

        try {
            if (names.size() != mBeansNum && names.size() != 0) {
                mBeansComboBox.removeActionListener(mBeanComboBoxListener);
                mBeansComboBox.removeAllItems();
                initMBeanComboBox(names);

                /*
                 * Remove it from the logging map, release the resources
                 * acquired by this MBean.  
                 */
                for (Map.Entry<ObjectName, LogObject> entry :
                        logMap.entrySet()) {
                    boolean find = false;
                    for (ObjectName name : names) {
                        if (name.equals(entry.getKey())) {
                            find = true;
                            break;
                        }
                    }
                    if (!find) {
                        logMap.get(entry.getKey()).closeFileWriter();
                        logMap.remove(entry.getKey());
                        valueStore.remove(entry.getKey());
                        break;
                    }
                }
                objName = getFirstObjectName();
                mBeansNum = names.size();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Write chosen stats to the log. */
    private void writeToLog(Map<String, String> map,
                            ObjectName currentName) {
        try {
            if (map == null)
                return;

            /* If the log name is not set, return. */
            LogObject item = logMap.get(currentName);
            if (item.getLogName() == null)
                return;

            StringBuffer buffer = new StringBuffer();
            getCSVOutput(buffer, map, false, currentName);
            buffer.append("\n");
            item.writeLog(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Make the stats output in CSV format. */
    private void getCSVOutput(StringBuffer buffer,
                              Map<String, String> map,
                              boolean init,
                              ObjectName name) {
        LogObject item = logMap.get(name);

        if (map == null || map.size() == 0) {
            return;
        }

        /* Before write to log, remove those unlog stats. */
        if (item != null) {
            Object[] keys = map.keySet().toArray();
            for (String title : item.getTurnOff()) {
                for (Object key : keys) {
                    if (key.toString().contains(title)) {
                        map.remove(key.toString());
                    }
                }
            }
            emptyArray(keys);
            keys = null;
        }
        item = null;

        if (!init) {
            buffer.append(System.currentTimeMillis());
        } else {
            buffer.append("TIME");
        }
        for (int i = 0; i < statsTitles.length; i++) {
            map.remove(statsTitles[i]);
        }
        if (map.size() > 0) {
            buffer.append(",");
            int count = 1;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String title = entry.getKey().substring
                    (0, entry.getKey().indexOf(":")).trim();
                if (!init) {
                    title = "\"" + entry.getValue() + "\"";
                }
                if (count < map.size())
                    title = title + ",";
                buffer.append(title);
                count++;
            }
        }
    }

    /* Return a new SwingWorker for UI update. */
    private SwingWorker<?,?> newSwingWorker() {
        ArrayList<Stats> list = new ArrayList<Stats>();
        list.add(this);

        return new StatsSwingWorker(list);
    }

    /* Writing and graphing stats according to the specified interval. */
    private void writeLogAndGraphing(ObjectName objectName,
                                     Map<String, String> values) {
        if ((values == null) || (values.size() == 0)) {
            return;
        }

        /* Graphing stats. */
        if (frameList.size() > 0) {
            for (GraphFrame frame : frameList) {
                if (frame.getBeanName().equals(objectName)) {
                    frame.writeData(values);
                }
            }
        }

        /* Write stats to csv file. */
        if (doLog) {
            writeToLog(values, objectName);
        }
    }

    /* A utility class for recording the environment-related information. */
    private class LogObject {
        private String logName;
        private FileWriter csvOutput = null;
        private ArrayList<String> turnOffIndex = new ArrayList<String>();

        public void setLogName(String logName) {
            if (logName.contains(".csv")) {
                this.logName = logName;
            } else {
                this.logName = logName + ".csv";
            }
        }

        public String getLogName() {
            return logName;
        }

        public void addTurnOff(String title) {
            turnOffIndex.add(title);
        }

        public ArrayList<String> getTurnOff() {
            return turnOffIndex;
        }

        /* Paint the CSV file header. */
        public void initCSVOutput(ObjectName objectName) {
            if (logName != null) {
                try {
                    csvOutput = new FileWriter(new File(logName), true);
                    StringBuffer buffer = new StringBuffer();
                    Map<String, String> map = generateStats(objectName);
                    getCSVOutput(buffer, map, true, objectName);
                    csvOutput.append(buffer.toString() + "\n");
                    csvOutput.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /* Write stats to log. */
        public void writeLog(String stats) {
            try {
                if (csvOutput != null) {
                    csvOutput.append(stats);
                    csvOutput.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* Close the file writer. */
        public void closeFileWriter() {
            try {
                if (csvOutput != null)
                    csvOutput.close();
                csvOutput = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* The table model for stats table. */
    public class StatsTableModel extends AbstractTableModel {
        private static final long serialVersionUID = -2478788160419123718L;

        private String[] columnNames = { "Stat Name", "Value" };

        private List<Map.Entry<String, String>> list =
            new ArrayList<Map.Entry<String, String>>();

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return (list == null) ? 0 : list.size();
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            Map.Entry<String, String> value = list.get(row);
            switch (col) {
                case 0 :
                    /* Column 0 shows the stats name.*/
                    if (value.getKey().indexOf(":") < 0) {
                        return value.getKey().trim();
                    } else {
                        return value.getKey().
                            substring(0, value.getKey().indexOf(":"));
                    }
                case 1 :
                    return value.getValue();
                default:
                    return null;
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public void setList(List<Map.Entry<String, String>> list) {
            this.list = list;
        }
    }

    /*
     * If a stat's value has changed since last time, then marked it in red.
     */
    private class StringRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 480362177240428265L;

        public StringRenderer() {
            super();
            setHorizontalAlignment(JLabel.LEFT);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
                                                       Object value,
                                                       boolean isSelected,
                                                       boolean hasFocus,
                                                       int row,
                                                       int column) {
            Component cell =
                super.getTableCellRendererComponent(table, value, isSelected,
                                                    hasFocus, row, column);

            /*
             * If the value is the same, the font color is black, if the value
             * is different, then change the color to red, and replace the
             * value in the valueStore to the new one.
             */
            if (column == 1) {
                String newValue =
                    valueStore.get(objName).get(table.getValueAt(row, 0));
                if (newValue != null &&
                    !newValue.equals(table.getValueAt(row, 1))) {

                    valueStore.get(objName).
                        put(table.getValueAt(row, 0).toString(),
                            table.getValueAt(row, 1).toString().trim());
                    cell.setForeground(Color.RED);
                }
            } else {
                cell.setForeground(Color.BLACK);
            }

            return cell;
        }
    }

    /* The file chooser for setting log file. */
    private class SaveLogFileChooser extends JFileChooser {
        private static final long serialVersionUID = -3035086973026766211L;

        public SaveLogFileChooser() {
            setFileFilter(new FileNameExtensionFilter("CSV files", "csv"));
        }

        @Override
        public void approveSelection() {
            File file = getSelectedFile();
            if (file != null) {
                FileFilter filter = getFileFilter();
                if (filter != null &&
                    filter instanceof FileNameExtensionFilter) {
                    String[] extensions =
                        ((FileNameExtensionFilter) filter).getExtensions();

                    boolean goodExt = (extensions.length > 0) ? true: false;

                    if (!goodExt) {
                        file = new File(file.getParent(), file.getName() +
                               "." + extensions[0]);
                    }
                }

                if (file.exists()) {
                    String okStr = "ok";
                    String cancelStr = "cancel";
                    int ret =
                        JOptionPane.showOptionDialog(this,
                               "File " + file.getName() + " already exists!",
                               "Save File",
                               JOptionPane.OK_CANCEL_OPTION,
                               JOptionPane.WARNING_MESSAGE,
                               null,
                               new Object[] {okStr, cancelStr}, okStr);
                    if (ret != JOptionPane.OK_OPTION) {
                        return;
                    }
                }

                setSelectedFile(file);
            }
            super.approveSelection();
        }
    }

    /* Following classes are listeners for GUI events. */

    /* Listener for clear stats button. */
    private class ClearStatsBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            envStatParams[0] = !(cumulativeStatsBox.isSelected());
            /* Repain the tab. */
            drawNewStats.run();
        }
    }

    /* Listener for display non-zero checkbox. */
    private class HideZeroValueBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            hideZeroValue = hideZeroValueBox.isSelected();
            /* Repaint the tab. */
            drawNewStats.run();
        }
    }

    /* Listener for start logging button. */
    private class StartLogListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /* Paint the CSV file header for each MBean. */
            for (Map.Entry<ObjectName, LogObject> entry : logMap.entrySet()) {
                entry.getValue().initCSVOutput(entry.getKey());
            }
            enableComponent(new JComponent[] { saveLogButton,
                                               startLogButton,
                                               logMenuItem },
                            false);
            doLog = true;
        }
    }

    /* Listener for stop logging button. */
    private class StopLogListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            enableComponent
                (new JComponent[] { saveLogButton, logMenuItem }, true);
            doLog = false;
            startLogButton.setEnabled(false);
            stopLogButton.setEnabled(false);
            saveLogButton.setEnabled(true);
        }
    }

    /* Set provided component enabled or not. */
    private void enableComponent(JComponent[] components, boolean enabled) {
        for (JComponent component : components) {
            component.setEnabled(enabled);
        }
    }

    /* Listener for save log files button. */
    private class SaveLogListener implements ActionListener {
        JPanel shownPanel;

        public SaveLogListener(JPanel shownPanel) {
            this.shownPanel = shownPanel;
        }

        public void actionPerformed(ActionEvent e) {
            if (fileChooser == null) {
                fileChooser = new SaveLogFileChooser();
            }
            int ret = fileChooser.showSaveDialog(shownPanel);
            if (ret == JFileChooser.APPROVE_OPTION) {
                logMap.get(objName).setLogName
                    (fileChooser.getSelectedFile().getAbsolutePath());
                startLogButton.setEnabled(true);
                stopLogButton.setEnabled(true);
            }
        }
    }

    /* Listener for choosing a MBean ComboBox. */
    private class BeanComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /* If choose another environment, need to update the table. */
            objName =
                comboToObjects.get(mBeansComboBox.getSelectedItem());
            /* Repaint the tab. */
            drawNewStats.run();
        }
    }

    /* Listener for stats type checkbox. */
    private class StatsTypeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            shownStats.put(((JCheckBox) e.getSource()).getText(),
                           ((JCheckBox) e.getSource()).isSelected());
            /* Repaint the tab. */
            drawNewStats.run();
        }
    }

    /* Listener for log menu item on JEStats table. */
    private class LogMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LogObject currentBean = logMap.get(objName);

            if (selectedRow > -1) {
                String title =
                    statsTable.getValueAt(selectedRow, 0).toString().trim();

                if (!logMenuItem.getState() &&
                    !currentBean.getTurnOff().contains(title)) {
                    currentBean.addTurnOff(title);
                }
                if (logMenuItem.getState() &&
                    currentBean.getTurnOff().contains(title)) {
                    currentBean.getTurnOff().remove(title);
                }
            }
        }
    }

    /* Listener for graph menu item on JEStats table. */
    private class GraphMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (selectedRow > -1) {
                String graphStats =
                    statsTable.getValueAt(selectedRow, 0).toString().trim();
                if (!isTitleEqual(graphStats)) {
                        boolean initialized = false;
                        for (GraphFrame frame : frameList) {
                            if (frame.getBeanName().equals(objName) &&
                                frame.getStatsName().equals(graphStats)) {
                                initialized = true;
                                break;
                            }
                        }
                        if (!initialized) {
                            frameList.add(new GraphFrame(objName, graphStats));
                        }
                    }
                }
            }
        }

    /* If the string equals to one of those stats types. */
    private boolean isTitleEqual(String title) {
        boolean equal = false;
        for (int i = 0; i < statsTitles.length; i++) {
            if (statsTitles[i].equals(title)) {
                equal = true;
                break;
            }
        }

        return equal;
    }

    /* These two classes are listeners for mouse actions on the Stats table. */
    private class TableMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                int row = statsTable.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    statsTable.setRowSelectionInterval(row, row);
                    final String statName =
                        statsTable.getValueAt(row, 0).toString().trim();
                    if (logMap.get(objName).getTurnOff().contains(statName)) {
                        logMenuItem.setState(false);
                    } else {
                        logMenuItem.setState(true);
                    }

                    /* Check which stats shouldn't be graphed. */
                    try {
                        String statValue = getParsedValue
                            (statsTable.getValueAt(row, 1).toString().trim());

                        /* 
                         * If the stats value can't be converted to a number, 
                         * disable graphing.
                         */
                        Long.parseLong(statValue);
                        graphMenuItem.setEnabled(true);
                    } catch (NumberFormatException exception) {

                        /* If the value can't be converted to long, disable the
                         * graphing menu. 
                         */
                        graphMenuItem.setEnabled(false);
                    }
                    selectedRow = row;
                }
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }
    }
    
    /* 
     * Parse the number format ***,***,*** to *********. 
     */
    private String getParsedValue(String value) {
        if (value.indexOf(",") > 0) {
            StringTokenizer st = new StringTokenizer(value, ",");
            value = new String();
            while (st.hasMoreTokens()) {
                value = value + st.nextToken();
            }
        }

        return value;
    }

    /* The MouseMotionListener to the table. */
    private class TableMouseMotionListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
            int row = statsTable.rowAtPoint(e.getPoint());
            if (row >= 0) {
                String stats = ((String) statsTable.getValueAt(row, 0)).trim();
                statsTable.setToolTipText(tips.get(stats));
            }
        }
    }

    /* KeyListener for setting graph interval text field. */
    private class StatsIntervalListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String newIntervalText = statsIntervalText.getText();
                try {
                    long statsIntervalSeconds = new Long(newIntervalText);
                    statsIntervalMillis = statsIntervalSeconds * 1000;
                } catch (Exception exception) {
                    System.err.println("\"" + newIntervalText + 
                                       "\" is not a valid interval. " + 
                                       exception);
                }

                statsCollector.cancel();
                statsCollector = new Timer(STATS_COLLECTOR);
                statsCollector.scheduleAtFixedRate(new StatsCollectionTask(),
                                                   0, 
                                                   statsIntervalMillis);
            }
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    /**
     * Frame for showing stats.
     *
     * Note: stats whose type is float are not supported currently.
     */
    private class GraphFrame extends JFrame {
        private static final long serialVersionUID = 8921577524698094123L;

        /* Set the color of line in graphing. */
        private final Color statsColor = Color.blue.darker();
        /* The panel doing the graphing work. */
        private PlotterPanel plotterPanel;

        private final ObjectName bean;
        private final String stats;

        public GraphFrame(ObjectName beanName, String statsName) {
            super(statsName.trim() + " for " + beanName.toString());
            bean = beanName;
            stats = statsName.trim();
            setLayout(new BorderLayout(0, 0));
            setSize(800, 400);

            /* Add TimeComboBox and PlotterPanel to the frame. */
            JPanel topPanel = new JPanel(new BorderLayout());
            JPanel controlPanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
            controlPanel.add(new JLabel("Time Range:"));
            plotterPanel = new PlotterPanel(stats, Unit.NONE, false);
            plotterPanel.getPlotter().createSequence
                (stats, stats, statsColor, true);
            TimeComboBox timeComboBox =
                new TimeComboBox(plotterPanel.getPlotter());
            controlPanel.add(timeComboBox);
            topPanel.add(controlPanel, BorderLayout.CENTER);
            add(topPanel, BorderLayout.NORTH);
            add(plotterPanel, BorderLayout.CENTER);

            /*
             * When we click the close button, it would dispose the frame and
             * if the connection is alive, remove the frame in the frame list.
             */
            addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    setVisible(false);
                    dispose();
                    if (JEStats.getConnection() != null) {
                        removeGraphFrame(bean, stats);
                    }
                }
            });
            setVisible(true);
        }

        public ObjectName getBeanName() {
            return bean;
        }

        public String getStatsName() {
            return stats;
        }

        /*
         * When use the PlotterPanel, we only need to write data into it.
         */
        public void writeData(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().indexOf(":") > 0) {
                    String realKey = entry.getKey().substring
                        (0, entry.getKey().indexOf(":")).trim();

                    /*
                     * The following three stats can't convert to long, so
                     * ignore them. Also, some values have "," inside, need to
                     * remove it away.
                     */
                    if (stats.equals(realKey)) {
                        String value = getParsedValue(entry.getValue());
                        plotterPanel.getPlotter().addValues
                            (System.currentTimeMillis(), Long.valueOf(value));
                    }
                }
            }
        }
    }

    private class StatsCollectionTask extends TimerTask {
        private final boolean writeLogAndGraphing;

        public StatsCollectionTask() {
            this(true);
        }

        public StatsCollectionTask(boolean writeLogAndGraphing) {
            this.writeLogAndGraphing = writeLogAndGraphing;
        }

        @Override
        public void run() {
            List<ObjectName> objectNames = getBeansNames();

            if (objectNames == null || objectNames.size() == 0) {
                return;
            }

            /* 
             * Reset the object names. Make sure to do ths assignment
             * atomically, because other threads may read savedObjectNames.
             */
            savedObjectNames = objectNames;

            for (ObjectName objectName : objectNames) {
                Map<String, String> statValues = generateStats(objectName); 

                /* Copy and save stats and ObjectNames for tab refreshing. */
                Map<String, String> copiedStats = 
                    new LinkedHashMap<String, String>();
                copiedStats.putAll(statValues);
                savedStats.put(objectName, copiedStats);
                
                /* Write log and update graphing for this MBean. */
                if (writeLogAndGraphing) {
                    writeLogAndGraphing(objectName, statValues);
                }
            }
            newSwingWorker().execute();
        }
    }
}
