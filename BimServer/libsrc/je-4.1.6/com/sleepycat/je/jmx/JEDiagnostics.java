/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jmx;

import java.util.ArrayList;
import java.util.logging.Level;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * <p>
 * JEDiagnostics is a debugging mbean for a non replicated JE Environment.
 * This is intended as a locus of field support functionality. While it may be
 * used by the application developer, the primary use case is for a support
 * situation. Currently much of this functionality is also available through
 * the standard java.util.logging MBean.
 * <p>
 * It is a concrete MBean created by registering a JE Environment as an MBean
 * through setting the JEDiagnostics system property. It only works on an
 * active JE Environment, and one Environment can only have on JEDiagnostics
 * instance. There are three attributes and two operations:
 * <p>
 * <u>Attributes:</u>
 * <ul>
 * <li> memoryHandlerLevel: which sets the memory handler push level. </li>
 * <li> consoleHandlerLevel: which sets the console handler level.
 * <li> fileHandlerLevel: which sets the file handler level.
 * </ul>
 * <u>Operations:</u>
 * <ul>
 * <li> resetLoggingLevel: which sets the level for the current loggers in
 *      the LogManager.
 * <li> pushMemoryHandler: which pushes all the logging information in the 
 *      memory handler to the console handler.
 * </ul>
 * <p>
 * We can use these attributes and operations to dynamically change the
 * logger's level and dump logging information in the memory handler for
 * debugging purposes.
 */
public class JEDiagnostics extends JEMBean implements DynamicMBean {

    /* --------------------- Attributes -------------------------- */
    protected static final String MEMORYHANDLER_LEVEL = "memoryHandlerLevel";
    protected static final String CONSOLEHANDLER_LEVEL = "consoleHandlerLevel";
    protected static final String FILEHANDLER_LEVEL = "fileHandlerLevel";

    /* MemoryHandler. */
    protected static final MBeanAttributeInfo ATT_MEMORYHANDLER_LEVEL = 
        new MBeanAttributeInfo
        (MEMORYHANDLER_LEVEL, "java.lang.String", "MemoryHandler level.",
         true, true, false);

    /* ConsoleHandler. */
    protected static final MBeanAttributeInfo ATT_CONSOLEHANDLER_LEVEL =
        new MBeanAttributeInfo
        (CONSOLEHANDLER_LEVEL, "java.lang.String", "ConsoleHandler level.",
         true, true, false);

    /* FileHandler. */
    protected static final MBeanAttributeInfo ATT_FILEHANDLER_LEVEL =
        new MBeanAttributeInfo
        (FILEHANDLER_LEVEL, "java.lang.String", "FileHandler level.",
         true, true, false);

    /* --------------------- Operations -------------------------- */

    /* Operation names */
    protected static final String OP_RESET_LOGGING = "resetLoggerLevel";
    protected static final String OP_PUSH_MEMORYHANDLER = "pushMemoryHandler";

    /* Set the parameters and operation info for resetting logger's level. */
    protected static final MBeanParameterInfo[] resetLoggingParams = {
        new MBeanParameterInfo("Logger Name", "java.lang.String",
                               "Specify the target logger."),
        new MBeanParameterInfo("Logging Level", "java.lang.String",
                               "The new logging level for the target logger.")
    };

    /* Reset logger's level operation. */
    protected static final MBeanOperationInfo OP_RESET_LOGGING_LEVEL = 
        new MBeanOperationInfo
        (OP_RESET_LOGGING,
         "Change the logging level for the specified logger.",
         resetLoggingParams, "void", MBeanOperationInfo.UNKNOWN);

    /* Push out the logging information in the MemoryHandler. */
    protected static final MBeanOperationInfo OP_PUSH_MEMORYHANDLER_INFO = 
        new MBeanOperationInfo
        (OP_PUSH_MEMORYHANDLER,
         "Push out logging information in memory hanlder.",
         new MBeanParameterInfo[0], "void", MBeanOperationInfo.UNKNOWN);

    protected JEDiagnostics(Environment env) {
        super(env);
    }

    public JEDiagnostics() {
        super();
    }

    @Override
    protected void initClassFields() {
        currentClass = JEDiagnostics.class;
        className = "JEDiagnostics";
        DESCRIPTION = "Logging Monitor on an open Environment.";
    }

    /**
     * @see DynamicMBean#getAttribute
     */
    public Object getAttribute(String attributeName)
        throws AttributeNotFoundException,
               MBeanException {

        if (attributeName == null) {
            throw new AttributeNotFoundException
                ("Attribute name can't be null.");
        }

        try {
            EnvironmentImpl envImpl = DbInternal.getEnvironmentImpl(env);

            if (attributeName.equals(MEMORYHANDLER_LEVEL)) {
                return (envImpl.getMemoryHandler().getPushLevel().toString());
            } else if (attributeName.equals(CONSOLEHANDLER_LEVEL)) {
                return envImpl.getConsoleHandler().getLevel().toString();
            } else if (attributeName.equals(FILEHANDLER_LEVEL)) {
                return envImpl.getFileHandler().getLevel().toString();
            } else {
                throw new AttributeNotFoundException
                    ("Attributes " + attributeName + " is not valid.");
            }
        } catch (DatabaseException e) {
            throw new MBeanException(new RuntimeException(e.getMessage()));
        }
    }

    /**
     * @see DynamicMBean#setAttribute
     */
    public void setAttribute(Attribute attribute)
        throws AttributeNotFoundException,
               InvalidAttributeValueException,
               MBeanException {

        if (attribute == null) {
            throw new AttributeNotFoundException("Attribute can't be null.");
        }

        /* Sanity check parameters. */
        String name = attribute.getName();
        Object value = attribute.getValue();

        if (name == null) {
            throw new AttributeNotFoundException
                ("Attribute name can't be null.");
        }

        if (value == null) {
            throw new InvalidAttributeValueException
                ("Attribute value for attribute " + name + " can't be null");
        }

        try {
            EnvironmentImpl envImpl = DbInternal.getEnvironmentImpl(env);
            Level level = Level.parse((String) value);

            if (name.equals(MEMORYHANDLER_LEVEL)) {
                envImpl.getMemoryHandler().setPushLevel(level);
            } else if (name.equals(CONSOLEHANDLER_LEVEL)) {
                envImpl.getConsoleHandler().setLevel(level);
            } else if (name.equals(FILEHANDLER_LEVEL)) {
                envImpl.getFileHandler().setLevel(level);
            } else {
                throw new AttributeNotFoundException
                    ("Attribute " + name + " is not valid.");
            }
        } catch (NullPointerException e) {
            throw new InvalidAttributeValueException
                ("Setting value for attribute " + name + 
                 "is invalid because of " + e.getMessage());
        } catch (SecurityException e) {
            throw new MBeanException(e, e.getMessage());
        }
    }

    /* Parse and return the level represented by an object. */
    private Level getLevel(Object level) {
        try {
            return Level.parse((String) level);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException
                ("Can't use null for level value.", e);
        }
    }

    /**
     * @see DynamicMBean#getAttributes
     */
    public AttributeList getAttributes(String[] attributes) {

        /* Sanity checking. */
        if (attributes == null) {
            throw new IllegalArgumentException("Attributes can't be null");
        }

        AttributeList results = new AttributeList();

        for (int i = 0; i < attributes.length; i++) {
            try {
                Object value = getAttribute(attributes[i]);
                results.add(new Attribute(attributes[i], value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return results;
    }

    /**
     * @see DynamicMBean#setAttributes
     */
    public AttributeList setAttributes(AttributeList attributes) {

        /* Sanity checking. */
        if (attributes == null) {
            throw new IllegalArgumentException("Attribute list can't be null");
        }

        AttributeList results = new AttributeList();

        for (int i = 0; i < attributes.size(); i++) {
            Attribute attr = (Attribute) attributes.get(i);
            try {
                setAttribute(attr);
                String name = attr.getName();
                Object newValue = getAttribute(name);
                results.add(new Attribute(name, newValue));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return results;
    }

    /**
     * @see DynamicMBean#invoke
     */
    public Object invoke(String actionName,
                         Object[] params,
                         String[] signature)
        throws MBeanException {

        /* Sanity checking. */
        if (actionName == null) {
            throw new IllegalArgumentException("ActionName can't be null.");
        }

        try {
            EnvironmentImpl envImpl = DbInternal.getEnvironmentImpl(env);

            if (actionName.equals(OP_RESET_LOGGING)) {
                if (params == null || params.length != 2) {
                    return new IllegalArgumentException
                        ("Parameter is not valid");
                }
                envImpl.resetLoggingLevel(((String) params[0]).trim(), 
                                          Level.parse((String) params[1]));
                return null;
            } else if (actionName.equals(OP_PUSH_MEMORYHANDLER)) {
                envImpl.pushMemoryHandler();
                return null;
            }

            return new IllegalArgumentException
                ("ActionName: " + actionName + " is not valid.");
        } catch (DatabaseException e) {

            /*
             * Add the message for easiest deciphering of the problem. Since 
             * the original exception cannot be transferred, send the exception
             * stack.
             */
             throw new MBeanException(new RuntimeException
                                      (e.getMessage() +
                                       LoggerUtils.getStackTrace(e)));
        } catch (NullPointerException e) {
            throw new MBeanException(e, e.getMessage());
        }
    }

    @Override
    protected void doRegisterMBean(Environment env)
        throws Exception {

        server.registerMBean(new JEDiagnostics(env), jeName);
    }

    @Override
    protected MBeanAttributeInfo[] getAttributeList() {
        ArrayList<MBeanAttributeInfo> attrList =
            new ArrayList<MBeanAttributeInfo>();

        attrList.add(ATT_MEMORYHANDLER_LEVEL);
        attrList.add(ATT_CONSOLEHANDLER_LEVEL);
        if (DbInternal.getEnvironmentImpl(env).getFileHandler() != null) {
            attrList.add(ATT_FILEHANDLER_LEVEL);
        }

        return attrList.toArray(new MBeanAttributeInfo[attrList.size()]);
    }

    @Override
    protected void addOperations() {
        operationList.add(OP_RESET_LOGGING_LEVEL);
        operationList.add(OP_PUSH_MEMORYHANDLER_INFO);
    }
}
