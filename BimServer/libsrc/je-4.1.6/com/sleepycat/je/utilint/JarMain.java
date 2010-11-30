/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Used as the main class for the manifest of the je.jar file, and so it is
 * executed when running: java -jar je.jar.  The first argument must be the
 * final part of the class name of a utility in the com.sleepycat.je.util
 * package, e.g., DbDump.  All following parameters are passed to the main
 * method of the utility and are processed as usual.
 *
 * Apart from the package, this class is ambivalent about the name of the
 * utility specified; the only requirement is that it must be a public static
 * class and must contain a public static main method.
 */
public class JarMain {

    private static final String USAGE = "usage: java <utility> [options...]";

    /* Use a HashMap to allow the utilities to live in multiple packages. */
    private static HashMap<String, String> utilPrefixMap =
        new HashMap<String, String>();

    /* Map each utility name to its package. */
    static {
        /* The utilities in directory com/sleepycat/je/util. */
        utilPrefixMap.put("DbCacheSize", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbDump", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbLoad", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbPrintLog", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbTruncateLog", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbRunAction", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbScavenger", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbSpace", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbStat", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbVerify", "com.sleepycat.je.util.");
        utilPrefixMap.put("DbVerifyLog", "com.sleepycat.je.util.");

        /* The utilities in directory com/sleepycat/je/rep/util. */
        utilPrefixMap.put("DbEnableReplication",
                          "com.sleepycat.je.rep.util.");
        utilPrefixMap.put("DbGroupAdmin", "com.sleepycat.je.rep.util.");
        utilPrefixMap.put("LDiff", "com.sleepycat.je.rep.util.ldiff.");

        /* The utilities in directory com/sleepycat/je/rep/utilint. */
        utilPrefixMap.put("DbDumpGroup", "com.sleepycat.je.rep.utilint.");
        utilPrefixMap.put("DbFeederPrintLog",
                          "com.sleepycat.je.rep.utilint.");
        utilPrefixMap.put("DbStreamVerify", "com.sleepycat.je.rep.utilint.");
        utilPrefixMap.put("DbSync", "com.sleepycat.je.rep.utilint.");
        utilPrefixMap.put("DbRepRunAction", "com.sleepycat.je.rep.utilint.");
        utilPrefixMap.put("DbNullNode", "com.sleepycat.je.rep.utilint.");
    }

    /* List all the available utilities. */
    private static String availableUtilities() {
        StringBuffer sbuf = new StringBuffer();
        for (String util : utilPrefixMap.keySet()) {
            sbuf.append(utilPrefixMap.get(util));
            sbuf.append(util);
            sbuf.append("\n");
        }

        return sbuf.toString();
    }

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                usage("Missing utility name");
            }

            String utilPrefix = utilPrefixMap.get(args[0]);
            if (utilPrefix == null) {
                System.out.println("Available utilities are: ");
                System.out.println(availableUtilities());
                usage("No such utility");
            }

            Class<?> cls = Class.forName(utilPrefix + args[0]);

            Method mainMethod = cls.getMethod
                ("main", new Class[] { String[].class });

            String[] mainArgs = new String[args.length - 1];
            System.arraycopy(args, 1, mainArgs, 0, mainArgs.length);

            mainMethod.invoke(null, new Object[] { mainArgs });
        } catch (InvocationTargetException ITE) {
            if (ITE.getCause() != null) {
                usage(ITE.getCause().toString());
            } else {
                System.err.println("Problem invoking main method:");
                ITE.printStackTrace(System.err);
            }
        } catch (Throwable e) {
            usage(e.toString());
        }
    }

    private static void usage(String msg) {
        System.err.println(msg);
        System.err.println(USAGE);
        System.exit(-1);
    }
}
