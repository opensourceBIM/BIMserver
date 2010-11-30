/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseExistsException;
import com.sleepycat.je.DatabaseNotFoundException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.EnvironmentNotFoundException;
import com.sleepycat.je.JEVersion;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.utilint.CmdUtil;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * Dump the contents of a database. This utility may be used programmatically
 * or from the command line.
 *<pre>
 * java com.sleepycat.je.util.DbDump
 *   -h &lt;dir&gt;           # environment home directory
 *  [-f &lt;fileName&gt;]     # output file, for non -rR dumps
 *  [-l]                # list databases in the environment
 *  [-p]                # output printable characters
 *  [-r]                # salvage mode
 *  [-R]                # aggressive salvage mode
 *  [-d] &lt;directory&gt;    # directory for *.dump files (salvage mode)
 *  [-s &lt;databaseName&gt;] # database to dump
 *  [-v]                # verbose in salvage mode
 *  [-V]                # print JE version number
 *</pre>
 * See {@link DbDump#main} for a full description of the
 * command line arguments. To dump a database to a stream from code:
 *
 * <pre>
 *    DbDump dump = new DbDump(env, databaseName, outputStream, boolean);
 *    dump.dump();
 * </pre>
 *
 *<p>
 * Because a <code>DATA=END</code> marker is used to terminate the dump of
 * each database, multiple databases can be dumped and loaded using a single
 * stream. The {@link DbDump#dump} method leaves the stream positioned after
 * the last line written and the {@link DbLoad#load} method leaves the stream
 * positioned after the last line read.</p>
 */
public class DbDump {
    private static final int VERSION = 3;

    protected File envHome = null;
    protected Environment env;
    protected String dbName = null;
    protected boolean formatUsingPrintable;
    private boolean dupSort;
    private String outputFileName = null;
    protected String outputDirectory = null;
    protected PrintStream outputFile = null;
    protected boolean doScavengerRun = false;
    protected boolean doAggressiveScavengerRun = false;
    protected boolean verbose = false;

    private static final String usageString =
        "usage: " + CmdUtil.getJavaCommand(DbDump.class) + "\n" +
        "  -h <dir> # environment home directory\n" +
        "  [-f <fileName>]     # output file, for non -rR dumps\n" +
        "  [-l]                # list databases in the environment\n" +
        "  [-p]                # output printable characters\n" +
        "  [-r]                # salvage mode\n" +
        "  [-R]                # aggressive salvage mode\n" +
        "  [-d] <directory>    # directory for *.dump files (salvage mode)\n" +
        "  [-s <databaseName>] # database to dump\n" +
        "  [-v]                # verbose in salvage mode\n" +
        "  [-V]                # print JE version number\n";

    private DbDump() {
    }

    /**
     * @deprecated Please use the 4-arg ctor without outputDirectory instead.
     */
    @Deprecated
    public DbDump(Environment env,
                  String dbName,
                  PrintStream outputFile,
                  String outputDirectory,
                  boolean formatUsingPrintable) {
        init(env, dbName, outputFile, formatUsingPrintable);
    }

    /**
     * Create a DbDump object for a specific environment and database.
     *
     * @param env The Environment containing the database to dump.
     * @param dbName The name of the database to dump.
     * @param outputFile The output stream to dump the database to.
     * @param formatUsingPrintable true if the dump should use printable
     * characters.
     */
    public DbDump(Environment env,
                  String dbName,
                  PrintStream outputFile,
                  boolean formatUsingPrintable) {
        init(env, dbName, outputFile, formatUsingPrintable);
    }

    private void init(Environment env,
                      String dbName,
                      PrintStream outputFile,
                      boolean formatUsingPrintable) {
        this.envHome = env.getHome();
        this.env = env;
        this.dbName = dbName;
        this.outputFile = outputFile;
        this.formatUsingPrintable = formatUsingPrintable;
    }

    /**
     * The main used by the DbDump utility.
     *
     * @param argv The arguments accepted by the DbDump utility.
     *
     * <pre>
     * usage: java { com.sleepycat.je.util.DbDump | -jar
     * je-&lt;version&gt;.jar DbDump }
     *             [-f output-file] [-l] [-p] [-V]
     *             [-s database] -h dbEnvHome [-rR] [-v]
     *             [-d directory]
     * </pre>
     *
     * <p>
     * -f - the file to dump to.<br>
     * -l - list the databases in the environment.<br>
     * -p - If characters in either the key or data items
     * are printing characters (as defined by isprint(3)), use printing
     * characters in file to represent them. This option permits users to use
     * standard text editors and tools to modify the contents of
     * databases.<br>
     * -V - display the version of the JE library.<br>
     * -s database - the database to dump.<br>
     * -h dbEnvHome - the directory containing the database environment.<br>
     * -r - Salvage data from a possibly corrupt file. When used on a
     * uncorrupted database, this option should return equivalent data to a
     * normal dump, but most likely in a different order. The data for each
     * database is saved into &lt;databaseName&gt;.dump files in the current
     * directory. <br>
     * -d directory - the output directory for *.dump files (salvage mode)
     * <br>
     * -R - Aggressively salvage data from a possibly corrupt file. The -R flag
     * differs from the -r option in that it will return all possible data
     * from the file at the risk of also returning already deleted or
     * otherwise nonsensical items. Data dumped in this fashion will almost
     * certainly have to be edited by hand or other means before the data is
     * ready for reload into another database. The data for each database is
     * saved into &lt;databaseName&gt;.dump files in the current directory.
     * <br>
     * -v - print progress information to stdout for -r or -R mode. <br></p>
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public static void main(String argv[])
        throws Exception {

        DbDump dumper = new DbDump();
        boolean listDbs = dumper.parseArgs(argv);
        if (dumper.doScavengerRun) {
            dumper.openEnv(false);
            dumper = new DbScavenger(dumper.env,
                                     dumper.outputDirectory,
                                     dumper.formatUsingPrintable,
                                     dumper.doAggressiveScavengerRun,
                                     dumper.verbose);
            ((DbScavenger) dumper).setDumpCorruptedBounds(true);
        }

        if (listDbs) {
            dumper.listDbs();
            System.exit(0);
        }

        try {
            dumper.dump();
        } catch (Throwable T) {
            T.printStackTrace();
        } finally {
            dumper.env.close();
            if (dumper.outputFile != null &&
                dumper.outputFile != System.out) {
                dumper.outputFile.close();
            }
        }
    }

    private void listDbs()
        throws EnvironmentNotFoundException, EnvironmentLockedException {

        openEnv(true);

        List<String> dbNames = env.getDatabaseNames();
        Iterator<String> iter = dbNames.iterator();
        while (iter.hasNext()) {
            String name = iter.next();
            System.out.println(name);
        }
    }

    protected void printUsage(String msg) {
        System.err.println(msg);
        System.err.println(usageString);
        System.exit(-1);
    }

    protected boolean parseArgs(String argv[])
        throws IOException {

        int argc = 0;
        int nArgs = argv.length;
        boolean listDbs = false;
        while (argc < nArgs) {
            String thisArg = argv[argc++];
            if (thisArg.equals("-p")) {
                formatUsingPrintable = true;
            } else if (thisArg.equals("-V")) {
                System.out.println(JEVersion.CURRENT_VERSION);
                System.exit(0);
            } else if (thisArg.equals("-l")) {
                listDbs = true;
            } else if (thisArg.equals("-r")) {
                doScavengerRun = true;
            } else if (thisArg.equals("-R")) {
                doScavengerRun = true;
                doAggressiveScavengerRun = true;
            } else if (thisArg.equals("-f")) {
                if (argc < nArgs) {
                    outputFileName = argv[argc++];
                } else {
                    printUsage("-f requires an argument");
                }
            } else if (thisArg.equals("-h")) {
                if (argc < nArgs) {
                    String envDir = argv[argc++];
                    envHome = new File(envDir);
                } else {
                    printUsage("-h requires an argument");
                }
            } else if (thisArg.equals("-d")) {
                if (argc < nArgs) {
                    outputDirectory = argv[argc++];
                } else {
                    printUsage("-d requires an argument");
                }
            } else if (thisArg.equals("-s")) {
                if (argc < nArgs) {
                    dbName = argv[argc++];
                } else {
                    printUsage("-s requires an argument");
                }
            } else if (thisArg.equals("-v")) {
                verbose = true;
            } else {
                printUsage(thisArg + " is not a valid option.");
            }
        }

        if (envHome == null) {
            printUsage("-h is a required argument");
        }

        if (!listDbs &&
            !doScavengerRun) {
            if (dbName == null) {
                printUsage("Must supply a database name if -l not supplied.");
            }
        }

        if (outputFileName == null) {
            outputFile = System.out;
        } else {
            outputFile = new PrintStream(new FileOutputStream(outputFileName));
        }

        return listDbs;
    }

    /*
     * Begin DbDump API.  From here on there should be no calls to printUsage,
     * System.xxx.print, or System.exit.
     */
    protected void openEnv(boolean doRecovery)
        throws EnvironmentNotFoundException, EnvironmentLockedException {

        if (env == null) {
            EnvironmentConfig envConfiguration = new EnvironmentConfig();
            envConfiguration.setReadOnly(true);
            /* Don't run recovery. */
            envConfiguration.setConfigParam
                (EnvironmentParams.ENV_RECOVERY.getName(),
                 doRecovery ? "true" : "false");
            env = new Environment(envHome, envConfiguration);
        }
    }

    /**
     * Perform the dump.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IOException in subclasses.
     */
    public void dump()
        throws EnvironmentNotFoundException,
               EnvironmentLockedException,
               DatabaseNotFoundException,
               IOException {

        openEnv(true);

        LoggerUtils.envLogMsg(Level.INFO, DbInternal.getEnvironmentImpl(env),
                              "DbDump.dump of " + dbName + " starting");

        DatabaseEntry foundKey = new DatabaseEntry();
        DatabaseEntry foundData = new DatabaseEntry();

        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setReadOnly(true);
        DbInternal.setUseExistingConfig(dbConfig, true);
        Database db;
        try {
            db = env.openDatabase(null, dbName, dbConfig);
        } catch (DatabaseExistsException e) {
            /* Should never happen, ExclusiveCreate is false. */
            throw EnvironmentFailureException.unexpectedException(e);
        }
        dupSort = db.getConfig().getSortedDuplicates();

        printHeader(outputFile, dupSort, formatUsingPrintable);

        Cursor cursor = db.openCursor(null, null);
        while (cursor.getNext(foundKey, foundData, LockMode.DEFAULT) ==
               OperationStatus.SUCCESS) {
            dumpOne(outputFile, foundKey.getData(), formatUsingPrintable);
            dumpOne(outputFile, foundData.getData(), formatUsingPrintable);
        }
        cursor.close();
        db.close();
        outputFile.println("DATA=END");

        LoggerUtils.envLogMsg(Level.INFO, DbInternal.getEnvironmentImpl(env),
                              "DbDump.dump of " + dbName + " ending");
    }

    protected void printHeader(PrintStream o,
                               boolean dupSort,
                               boolean formatUsingPrintable) {
        o.println("VERSION=" + VERSION);
        if (formatUsingPrintable) {
            o.println("format=print");
        } else {
            o.println("format=bytevalue");
        }
        o.println("type=btree");
        o.println("dupsort=" + (dupSort ? "1" : "0"));
        o.println("HEADER=END");
    }

    protected void dumpOne(PrintStream o, byte[] ba,
                           boolean formatUsingPrintable) {
        StringBuilder sb = new StringBuilder();
        sb.append(' ');
        CmdUtil.formatEntry(sb, ba, formatUsingPrintable);
        o.println(sb.toString());
    }
}
