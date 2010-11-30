/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.io.File;

import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.EnvironmentNotFoundException;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.DumpFileReader;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.log.PrintFileReader;
import com.sleepycat.je.log.StatsFileReader;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.tree.Key.DumpType;
import com.sleepycat.je.utilint.CmdUtil;
import com.sleepycat.je.utilint.DbLsn;

/**
 * Dumps the contents of the log in XML format to System.out.
 *
 * <p>To print an environment log:</p>
 *
 * <pre>
 *      DbPrintLog.main(argv);
 * </pre>
 */
public class DbPrintLog {

    /**
     * Dump a JE log into human readable form.
     */
    public void dump(File envHome,
                      String entryTypes,
                      String txnIds,
                      long startLsn,
                      long endLsn,
                      boolean verbose,
                      boolean stats,
                      boolean repEntriesOnly,
                      boolean csvFormat)
        throws EnvironmentNotFoundException,
               EnvironmentLockedException {

        EnvironmentImpl env =
            CmdUtil.makeUtilityEnvironment(envHome, true);
        FileManager fileManager = env.getFileManager();
        fileManager.setIncludeDeletedFiles(true);
        int readBufferSize =
            env.getConfigManager().getInt
            (EnvironmentParams.LOG_ITERATOR_READ_SIZE);

        try {
            /* Make a reader. */
            DumpFileReader reader;
            if (stats) {
                reader = new StatsFileReader
                    (env, readBufferSize, startLsn, endLsn, entryTypes,
                     txnIds, verbose, repEntriesOnly);
            } else {
                reader = new PrintFileReader
                    (env, readBufferSize, startLsn, endLsn, entryTypes,
                     txnIds, verbose, repEntriesOnly);
            }

            /* Enclose the output in a tag to keep proper XML syntax. */
            if (!csvFormat) {
                System.out.println("<DbPrintLog>");
            }

            while (reader.readNextEntry()) {
            }

            reader.summarize(csvFormat);
            if (!csvFormat) {
                System.out.println("</DbPrintLog>");
            }
        } finally {
            env.close();
        }
    }

    /**
     * The main used by the DbPrintLog utility.
     *
     * @param argv An array of command line arguments to the DbPrintLog
     * utility.
     *
     * <pre>
     * usage: java { com.sleepycat.je.util.DbPrintLog | -jar
     * je-&lt;version&gt;.jar DbPrintLog }
     *  -h &lt;envHomeDir&gt;
     *  -s  &lt;start file number or LSN, in hex&gt;
     *  -e  &lt;end file number or LSN, in hex&gt;
     *  -k  &lt;binary|hex|text|obfuscate&gt; (format for dumping the key)

     *  -tx &lt;targeted txn ids, comma separated&gt;
     *  -ty &lt;targeted entry types, comma separated&gt;
     *  -S  show summary of log entries
     *  -SC show summary of log entries in CSV format
     *  -r  only print replicated log entries
     *  -q  if specified, concise version is printed,
     *      default is verbose version
     * </pre>
     *
     * <p>All arguments are optional.  The current directory is used if {@code
     * -h} is not specified.</p>
     */
    public static void main(String[] argv) {
        try {
            int whichArg = 0;
            String entryTypes = null;
            String txnIds = null;
            long startLsn = DbLsn.NULL_LSN;
            long endLsn = DbLsn.NULL_LSN;
            boolean verbose = true;
            boolean stats = false;
            boolean csvFormat = false;
            boolean repEntriesOnly = false;

            /* Default to looking in current directory. */
            File envHome = new File(".");
            Key.DUMP_TYPE = DumpType.BINARY;

            while (whichArg < argv.length) {
                String nextArg = argv[whichArg];
                if (nextArg.equals("-h")) {
                    whichArg++;
                    envHome = new File(CmdUtil.getArg(argv, whichArg));
                } else if (nextArg.equals("-ty")) {
                    whichArg++;
                    entryTypes = CmdUtil.getArg(argv, whichArg);
                } else if (nextArg.equals("-tx")) {
                    whichArg++;
                    txnIds = CmdUtil.getArg(argv, whichArg);
                } else if (nextArg.equals("-s")) {
                    whichArg++;
                    startLsn = CmdUtil.readLsn(CmdUtil.getArg(argv, whichArg));
                } else if (nextArg.equals("-e")) {
                    whichArg++;
                    endLsn = CmdUtil.readLsn(CmdUtil.getArg(argv, whichArg));
                } else if (nextArg.equals("-k")) {
                    whichArg++;
                    String dumpType = CmdUtil.getArg(argv, whichArg);
                    if (dumpType.equalsIgnoreCase("text")) {
                        Key.DUMP_TYPE = DumpType.TEXT;
                    } else if (dumpType.equalsIgnoreCase("hex")) {
                        Key.DUMP_TYPE = DumpType.HEX;
                    } else if (dumpType.equalsIgnoreCase("binary")) {
                        Key.DUMP_TYPE = DumpType.BINARY;
                    } else if (dumpType.equalsIgnoreCase("obfuscate")) {
                        Key.DUMP_TYPE = DumpType.OBFUSCATE;
                    } else {
                        System.err.println
                            (dumpType +
                             " is not a supported dump format type.");
                    }
                } else if (nextArg.equals("-q")) {
                    verbose = false;
                } else if (nextArg.equals("-S")) {
                    stats = true;
                } else if (nextArg.equals("-SC")) {
                    stats = true;
                    csvFormat = true;
                } else if (nextArg.equals("-r")) {
                    repEntriesOnly = true;
                } else {
                    System.err.println
                        (nextArg + " is not a supported option.");
                    usage();
                    System.exit(-1);
                }
                whichArg++;
            }

            DbPrintLog printer = new DbPrintLog();
            printer.dump(envHome, entryTypes, txnIds, startLsn, endLsn, 
                         verbose, stats, repEntriesOnly, csvFormat);

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            usage();
            System.exit(1);
        }
    }

    private static void usage() {
        System.out.println("Usage: " +
                           CmdUtil.getJavaCommand(DbPrintLog.class));
        System.out.println(" -h  <envHomeDir>");
        System.out.println(" -s  <start file number or LSN, in hex>");
        System.out.println(" -e  <end file number or LSN, in hex>");
        System.out.println(" -k  <binary|text|hex|obfuscate> " +
                           "(format for dumping the key)");
        System.out.println(" -tx <targeted txn ids, comma separated>");
        System.out.println(" -ty <targeted entry types, comma separated>");
        System.out.println(" -S  show Summary of log entries");
        System.out.println(" -SC show Summary of log entries in CSV format");
        System.out.println(" -r  only print replicated log entries");
        System.out.println(" -q  if specified, concise version is printed");
        System.out.println("     Default is verbose version.)");
        System.out.println("All arguments are optional");
    }
}
