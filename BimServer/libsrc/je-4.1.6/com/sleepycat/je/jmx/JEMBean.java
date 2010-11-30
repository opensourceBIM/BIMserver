/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jmx;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.management.DynamicMBean;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.sleepycat.je.Environment;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.dbi.EnvironmentImpl.MBeanRegistrar;

/*
 * Base class for all JE concrete MBeans. 
 *
 * It implements the MBeanRegistrar interface and defines the common part of
 * those concrete MBeans.
 *
 * It defines the abstract methods which must be implemented in concrete
 * MBeans.
 *
 * Subclasses of JEMBean must avoid passing JE exceptions across the network to
 * the client side, since the client side will not have the proper JE exception
 * class. For example, a method which does this:
 *  
 *  catch (DatabaseException databaseEx) {
 *     new MBeanException(databaseEx);
 *  }
 *
 * will result in a ClassNotFoundException on the client side when it receives
 * the MBeanException, since it does not have DatabaseException.
 */
public abstract class JEMBean implements MBeanRegistrar {

    /*
     * Parameters for getting JE database, environment stats, etc.
     */
    public static final MBeanParameterInfo[] statParams = {
        new MBeanParameterInfo("clear", "java.lang.Boolean",
                               "If true, reset statistics after reading."),
        new MBeanParameterInfo("fast", "java.lang.Boolean",
                               "If true, only return statistics which do " +
                               "not require expensive computation.")
    };

    /* Concrete MBean's visible interface. */
    private MBeanInfo mbeanInfo;

    /* Fields used to register this concrete MBean. */
    protected MBeanServer server;
    protected ObjectName jeName;
    
    /* Name for this class. */
    protected String className;

    protected String DESCRIPTION;
    
    /* Class type for the MBean. */
    protected Class<?> currentClass;

    /* Environment used in this MBean. */
    protected Environment env;

    protected ArrayList<MBeanOperationInfo> operationList = 
        new ArrayList<MBeanOperationInfo>();

    protected JEMBean(Environment env) {
        this.env = env;
        initClassFields();
        resetMBeanInfo();
    }

    public JEMBean() {
        initClassFields();
    }

    /* Initiate the class fields used in this MBean. */
    protected abstract void initClassFields();
    
    /**
     * Create the available management interface for this environment.  The
     * attributes and operations available vary according to environment
     * configuration.
     */
    protected void resetMBeanInfo() {
        /* Generate the MBean description. */
        mbeanInfo = new MBeanInfo(currentClass.getName(),
                                  DESCRIPTION,
                                  getAttributeList(),
                                  getConstructors(),
                                  getOperationList(),
                                  getNotificationInfo());
    }

    /**
     * Get attribute metadata for this MBean.
     *
     * @return array of MBeanAttributeInfo objects describing the available
     * attributes.
     */
    protected abstract MBeanAttributeInfo[] getAttributeList();

    /**
     * Add MBean operations into the list.
     */
    protected abstract void addOperations();

    /**
     * Get constructor metadata for this MBean.
     *
     * Since the process of getting constructors is the same for each concrete
     * MBean, define it here to reduce coding work.
     *
     * @return array of MBeanConstructorInfo objects describing the constructor
     * attributes.
     */
    @SuppressWarnings("unchecked")
    protected MBeanConstructorInfo[] getConstructors() {

        Constructor[] constructors = currentClass.getConstructors();
        MBeanConstructorInfo[] constructorInfo =
            new MBeanConstructorInfo[constructors.length];
        for (int i = 0; i < constructors.length; i++) {
            constructorInfo[i] =
                new MBeanConstructorInfo(currentClass.getName(),
                                         constructors[i]);
        }

        return constructorInfo;
    }

    /**
     * Get operation metadata for this MBean.
     *
     * @return array of MBeanOperationInfo describing available operations.
     */
    private MBeanOperationInfo[] getOperationList() {
        addOperations();

        return operationList.toArray
            (new MBeanOperationInfo[operationList.size()]);
    }

    /**
     * Get notification metadata for this MBean.
     *
     * @return array of MBeanNotificationInfo describing notifications.
     */
    protected MBeanNotificationInfo[] getNotificationInfo() {
        return null;
    }

    /**
     * For EnvironmentImpl.MBeanRegistrar interface.
     *
     * Register this MBean with the MBeanServer.
     */
    public void doRegister(Environment env)
        throws Exception {

        server = ManagementFactory.getPlatformMBeanServer();

        StringBuilder sb = new StringBuilder("com.sleepycat.je.jmx:name=");
        sb.append(className).append("(");
        String noColonPathname = 
            env.getHome().getPath().replaceAll(":", "<colon>");
        sb.append(noColonPathname).append(")");
        jeName = new ObjectName(sb.toString());
        doRegisterMBean(env);
    }

    /* Register the MBean with the server. */
    protected abstract void doRegisterMBean(Environment env)
        throws Exception;

    /**
     * For EnvironmentImpl.MBeanRegistrar interface.
     *
     * Remove this MBean from the MBeanServer.
     */
    public void doUnregister()
        throws Exception {

        if (server != null) {
            server.unregisterMBean(jeName);
        }
    }

    /**
     * @see DynamicMBean#getMBeanInfo
     *
     * Implement the getMBeanInfo method of DynamicMBean.
     */
    public MBeanInfo getMBeanInfo() {
        return mbeanInfo;
    }

    /**
     * Helper for creating a StatsConfig object to use as an operation
     * parameter.
     */
    protected StatsConfig getStatsConfig(Object[] params) {
        StatsConfig statsConfig = new StatsConfig();
        if ((params != null) && (params.length > 0) && (params[0] != null)) {
            Boolean clear = (Boolean) params[0];
            statsConfig.setClear(clear.booleanValue());
        }
        if ((params != null) && (params.length > 1) && (params[1] != null)) {
            Boolean fast = (Boolean) params[1];
            statsConfig.setFast(fast.booleanValue());
        }

        return statsConfig;
    }
}
