/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import java.io.File;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.rep.impl.RepGroupDB;
import com.sleepycat.je.rep.impl.RepGroupImpl;

/**
 * @hidden Dumps the contents of the replication group database. Reads the
 * database directly, using a read only Environment.
 *
 * For internal use only. JE users should now use
 * com.sleepycat.je.rep.DbGroupAdmin to display group information.
 *
 * <pre>
 *   DbDumpGroup -h &lt;envHome&gt;
 * </pre>
 */
public class DbDumpGroup {
    private final PrintStream out;
    private File envHome = null;
    private boolean dumpCount = false;

    private DbDumpGroup(PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args) throws Exception {
        DbDumpGroup dumper = new DbDumpGroup(System.out);
        dumper.parseArgs(args);
        try {
            dumper.run();
        } catch (Throwable e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    public void run() {
        out.println("For internal use only. Consider using the public " +
                    "utility com.sleepycat.je.rep.DbGroupAdmin when " +
                    "displaying group information.");
                    
        out.println("Environment: " + envHome);
        if (dumpCount) {
            dumpCount();
        }
        dumpGroup();
    }

    /**
     * Dumps the data item count of each database in the specified environment.
     */
    private void dumpCount() {

        /*
         * Initialize an environment configuration, and create an environment.
         */
        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setReadOnly(true);
        envConfig.setAllowCreate(false);
        Environment env = new Environment(envHome, envConfig);

        List<String> databaseNames = new LinkedList<String>();
        databaseNames.addAll(env.getDatabaseNames());
        for (String dbName : databaseNames) {

            DatabaseConfig dbCfg = new DatabaseConfig();
            dbCfg.setAllowCreate(false);
            dbCfg.setReadOnly(true);
            DbInternal.setUseExistingConfig(dbCfg, true);

            Database db = env.openDatabase(null, dbName, dbCfg);
            out.println("Database: " + dbName + ", Count: " + db.count());
            db.close();
        }

        env.close();
    }

    /**
     * Dumps the contents of the replication group database.
     */
    private void dumpGroup() {
        RepGroupImpl group = RepGroupDB.getGroup(envHome);
        out.println(group);
    }

    /**
     * Parse the command line parameters.
     *
     * @param argv Input command line parameters.
     */
    public void parseArgs(String argv[]) {

        int argc = 0;
        int nArgs = argv.length;

        if (nArgs == 0) {
            printUsage(null);
            System.exit(0);
        }

        while (argc < nArgs) {
            String thisArg = argv[argc++];
            if (thisArg.equals("-h")) {
                if (argc < nArgs) {
                    envHome = new File(argv[argc++]);
                } else {
                    printUsage("-h requires an argument");
                }
            } else if (thisArg.equals("-dumpCount")) {
                dumpCount = true;
            } else {
                printUsage(thisArg + " is not a valid argument");
            }
        }

        if (envHome == null) {
            printUsage("-h is a required argument");
        }
    }

    /**
     * Print the usage of this utility.
     *
     * @param message
     */
    private void printUsage(String msg) {
        if (msg != null) {
            out.println(msg);
        }

        out.println("Usage: " + DbDumpGroup.class.getName());
        out.println("       -h <dir>   # environment home directory");
        out.println("       -dumpCount # dump all databases' count in\n" +
                    "                    this Environment");
        System.exit(-1);
    }
}
