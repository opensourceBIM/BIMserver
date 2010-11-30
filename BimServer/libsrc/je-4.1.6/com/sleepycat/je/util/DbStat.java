/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.io.File;
import java.io.PrintStream;
import java.util.logging.Level;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DatabaseExistsException;
import com.sleepycat.je.DatabaseNotFoundException;
import com.sleepycat.je.DatabaseStats;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.JEVersion;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.utilint.LoggerUtils;

class DbStat extends DbVerify {
    /*
    private String usageString =
        "usage: " + CmdUtil.getJavaCommand(DbStat.class) + "\n" +
        "               [-V] -s database -h dbEnvHome [-v progressInterval]\n";
    */

    private int progressInterval = 0;

    public static void main(String argv[])
        throws DatabaseException {

        DbStat stat = new DbStat();
        stat.parseArgs(argv);

        int ret = 0;
        try {
            stat.openEnv();
            if (!stat.stats(System.err)) {
                ret = 1;
            }
        } catch (Throwable T) {
            ret = 1;
            T.printStackTrace(System.err);
        }

        try {
            stat.closeEnv();
        } catch (Throwable ignored) {

            /*
             * Klockwork - ok
             * Don't say anything about exceptions here.
             */
        }
        System.exit(ret);
    }

    DbStat() {
    }

    public DbStat(Environment env, String dbName) {
        super(env, dbName, false);
    }

    @Override
    void parseArgs(String argv[]) {

        int argc = 0;
        int nArgs = argv.length;
        while (argc < nArgs) {
            String thisArg = argv[argc++];
            if (thisArg.equals("-V")) {
                System.out.println(JEVersion.CURRENT_VERSION);
                System.exit(0);
            } else if (thisArg.equals("-h")) {
                if (argc < nArgs) {
                    envHome = new File(argv[argc++]);
                } else {
                    printUsage("-h requires an argument");
                }
            } else if (thisArg.equals("-s")) {
                if (argc < nArgs) {
                    dbName = argv[argc++];
                } else {
                    printUsage("-s requires an argument");
                }
            } else if (thisArg.equals("-v")) {
                if (argc < nArgs) {
                    progressInterval = Integer.parseInt(argv[argc++]);
                    if (progressInterval <= 0) {
                        printUsage("-v requires a positive argument");
                    }
                } else {
                    printUsage("-v requires an argument");
                }
            }
        }

        if (envHome == null) {
            printUsage("-h is a required argument");
        }

        if (dbName == null) {
            printUsage("-s is a required argument");
        }
    }

    public boolean stats(PrintStream out)
        throws DatabaseNotFoundException {

        try {
            LoggerUtils.envLogMsg(Level.INFO, DbInternal.getEnvironmentImpl(env),
                                  "DbStat.stats of " + dbName + " starting");

            DatabaseConfig dbConfig = new DatabaseConfig();
            dbConfig.setReadOnly(true);
            dbConfig.setAllowCreate(false);
            DbInternal.setUseExistingConfig(dbConfig, true);
            Database db;
            try {
                db = env.openDatabase(null, dbName, dbConfig);
            } catch (DatabaseExistsException e) {
                /* Should never happen, ExclusiveCreate is false. */
                throw EnvironmentFailureException.unexpectedException(e);
            }

            StatsConfig statsConfig = new StatsConfig();
            if (progressInterval > 0) {
                statsConfig.setShowProgressInterval(progressInterval);
                statsConfig.setShowProgressStream(out);
            }

            DatabaseStats stats = db.getStats(statsConfig);
            out.println(stats);

            db.close();
            LoggerUtils.envLogMsg(Level.INFO, DbInternal.getEnvironmentImpl(env),
                               "DbStat.stats of " + dbName + " ending");
        } catch (DatabaseException DE) {
            return false;
        }

        return true;
    }
}
