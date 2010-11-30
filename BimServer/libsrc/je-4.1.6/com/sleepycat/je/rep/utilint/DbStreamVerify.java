/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import java.io.File;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import com.sleepycat.bind.tuple.LongBinding;
import com.sleepycat.bind.tuple.StringBinding;
import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.FileReader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.rep.impl.RepGroupDB;
import com.sleepycat.je.rep.impl.RepGroupDB.GroupBinding;
import com.sleepycat.je.rep.impl.RepGroupDB.NodeBinding;
import com.sleepycat.je.rep.vlsn.VLSNBucket;
import com.sleepycat.je.rep.vlsn.VLSNIndex;
import com.sleepycat.je.rep.vlsn.VLSNRange;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.utilint.CmdUtil;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.VLSN;

/**
 * For internal use only.
 * Utility to verify the replication stream and VLSN index. Used file readers
 * to traverse the log and check that VLSNs are sequential and that the VLSN
 * index is consistent.
 */
public class DbStreamVerify {

    private static final String USAGE =
        "usage: " + CmdUtil.getJavaCommand(DbStreamVerify.class) + "\n" +
        " -h <dir>      # environment home directory\n" +
        " -s <hex>      # start file\n" +
        " -e <hex>      # end file\n" +
        " -verifyStream # check that replication stream is ascending\n" +
        " -dumpVLSN     # scan log file for log entries that make up the" +
                        " VLSN index, don't run verify.\n" +
        " -dumpRepGroup # scan log file for log entries that make up the" +
                        " rep group db, don't run verify.\n" +
        " -i            # show invisible. If true, print invisible entries"+
                        " when running verify mode.\n" +
        " -v            # verbose\n";

    public static void main(String argv[])
        throws Exception {

        DbStreamVerify verify = new DbStreamVerify(System.out);
        verify.parseArgs(argv);

        try {
            verify.run();
            System.exit(0);
        } catch (Throwable e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private File envHome = null;
    private boolean showInvisible = false;
    private boolean verbose = false;
    private boolean vlsnDump = false;
    private boolean repGroupDump = false;
    private boolean verifyStream = false;
    private long startLsn = DbLsn.NULL_LSN;
    private long endLsn = DbLsn.NULL_LSN;

    private final PrintStream out;

    private DbStreamVerify(PrintStream out) {
        this.out = out;
    }

    private void printUsage(String msg) {
        if (msg != null) {
            out.println(msg);
        }
        out.println(USAGE);
        System.exit(-1);
    }

    private void parseArgs(String argv[]) {

        int argc = 0;
        int nArgs = argv.length;

        if (nArgs == 0) {
            printUsage(null);
            System.exit(0);
        }

        while (argc < nArgs) {
            String thisArg = argv[argc++];
            if (thisArg.equals("-i")) {
                showInvisible = true;
            } else if (thisArg.equals("-v")) {
                verbose = true;
            } else if (thisArg.equals("-verifyStream")) {
                verifyStream = true;
            } else if (thisArg.equals("-dumpVLSN")) {
                vlsnDump = true;
            } else if (thisArg.equals("-dumpRepGroup")) {
                repGroupDump = true;
            } else if (thisArg.equals("-s")) {
                startLsn = CmdUtil.readLsn(CmdUtil.getArg(argv, argc++));
            } else if (thisArg.equals("-e")) {
                endLsn = CmdUtil.readLsn(CmdUtil.getArg(argv, argc++));
            } else if (thisArg.equals("-h")) {
                if (argc < nArgs) {
                    envHome = new File(argv[argc++]);
                } else {
                    printUsage("-h requires an argument");
                }
            } else {
                printUsage(thisArg + " is not a valid argument");
            }
        }

        if (envHome == null) {
            printUsage("-h is a required argument");
        }

        if (!(vlsnDump || repGroupDump || verifyStream)) {
            printUsage("Must specify -dumpVLSN, -dumpRepGroup or " +
                       "-verifyStream");
        }
    }

    public void run() {
        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setReadOnly(true);
        Environment env = new Environment(envHome, envConfig);
        EnvironmentImpl envImpl = DbInternal.getEnvironmentImpl(env);

        try {
            FileReader reader;
            if (vlsnDump) {
                out.println("Dump VLSNIndex LNs");
                reader = new VLSNIndexReader(env, out, startLsn, endLsn);
            } else if (repGroupDump) {
                out.println("Dump RepGroup LNs");
                reader = new RepGroupReader(env, out, startLsn, endLsn);
            } else if (verifyStream) {
                out.println("Replication stream: check that vlsns ascend");
                reader = new VerifyReader(envImpl, out, startLsn, endLsn);
            } else {
                out.println("No action specified.");
                return;
            }

            while (reader.readNextEntry()) {
            }

            if ((!vlsnDump) && (!repGroupDump)) {
                ((VerifyReader) reader).displayLast();
                VLSNIndex.verifyDb(env, out, verbose);
            }

            System.exit(0);
        } catch (Throwable e) {
            e.printStackTrace(out);
            System.exit(1);
        } finally {
            try {
                env.close();
            } catch (Throwable e) {
                e.printStackTrace(out);
                System.exit(1);
            }
        }
    }

    private class VerifyReader extends FileReader {
        private VLSN lastVLSN = VLSN.NULL_VLSN;
        private long lastLSN = DbLsn.NULL_LSN;
        private final PrintStream out1;

        VerifyReader(EnvironmentImpl envImpl, PrintStream out, long startLsn,
                     long endLsn) {
            super(envImpl,
                  10000,
                  true,              // forward
                  startLsn,
                  null,              // singleFileNumber,
                  DbLsn.NULL_LSN,
                  endLsn);
            this.out1 = out;
        }

        @Override
        protected boolean isTargetEntry() {
            return (currentEntryHeader.getReplicated());
        }

        @Override
        protected boolean processEntry(ByteBuffer entryBuffer) {
            VLSN currentVLSN = currentEntryHeader.getVLSN();
            long currentLSN = getLastLsn();
            
            if (currentVLSN == null) {
                throw new RuntimeException
                     (DbLsn.getNoFormatString(currentLSN) +
                      "Should be a replicated entry");
            }

            if ((currentVLSN != null) && currentVLSN.isNull()) {
                out1.println("unexpected LSN " +
                            DbLsn.getNoFormatString(getLastLsn()) +
                            " has vlsn " + currentVLSN);
            }

            if ((lastVLSN != null) && lastVLSN.isNull()) {

                /* First entry seen */
                out1.println("first VLSN = " + currentVLSN + " at lsn " +
                            DbLsn.getNoFormatString(getLastLsn()));
            } else if (!currentEntryHeader.isInvisible() &&
                       !currentVLSN.follows(lastVLSN)) {

                /* Note the first entry, check for a gap. */
                out1.println("gap of " +
                            (currentVLSN.getSequence() -
                            lastVLSN.getSequence()) +
                            " Last=" + lastVLSN + " at lsn " +
                            DbLsn.getNoFormatString(lastLSN) +
                            " next=" + currentVLSN + " at lsn " +
                            DbLsn.getNoFormatString(currentLSN));

            }

            /* Note the invisible log entries. */
            if (showInvisible && currentEntryHeader.isInvisible()) {
                out1.println("VLSN " + currentVLSN + " at lsn " +
                            DbLsn.getNoFormatString(currentLSN) +
                            " is invisible.");
            }

            if (!currentEntryHeader.isInvisible()) {
                lastVLSN = currentVLSN;
                lastLSN = currentLSN;
            }
            entryBuffer.position(entryBuffer.position() +
                                 currentEntryHeader.getItemSize());
            return true;
        }

        void displayLast() {
            out1.println("LastVLSN = " + lastVLSN + " at " +
                         DbLsn.getNoFormatString(lastLSN));
        }
    }

    /**
     * A Decoder reader can dump the LNs from one of the JE internal databases
     * and display the LNs in a deserialized format, for easy debugging. The
     * target internal databases are the VLSNIndex and the RepGroup. We could
     * add FileSummaryLNs later.
     */
    private abstract class DecoderReader extends FileReader {
        protected final PrintStream outStream;
        private final Map<Byte, LNLogEntry> targetMap;
        protected LNLogEntry targetEntry;
        private final DatabaseId targetDbId;

        DecoderReader(Environment env, 
                      PrintStream out,
                      long startLsn, 
                      long endLsn,
                      String dbName,
                      LogEntryType ... logEntryTypes) {
            super(DbInternal.getEnvironmentImpl(env),
                  10000,
                  true,              // forward
                  startLsn,
                  null,              // singleFileNumber,
                  DbLsn.NULL_LSN,
                  endLsn);
            this.outStream = out;

            targetMap = new HashMap<Byte, LNLogEntry>();

            for (LogEntryType entryType : logEntryTypes) {
                targetMap.put(entryType.getTypeNum(),
                              (LNLogEntry) entryType.getNewLogEntry());
            }

            DatabaseConfig dbConfig = new DatabaseConfig();
            dbConfig.setReadOnly(true);
            DbInternal.setUseExistingConfig(dbConfig, true);
            Database db = env.openDatabase(null, dbName, dbConfig);
            targetDbId = DbInternal.getDatabaseImpl(db).getId();
            db.close();
        }

        @Override
        protected boolean isTargetEntry() {
            /* Is it a target entry? */
            targetEntry = targetMap.get(currentEntryHeader.getType());
            return targetEntry != null;
        }

        @Override
        protected boolean processEntry(ByteBuffer entryBuffer) {
            targetEntry.readEntry
                (currentEntryHeader, entryBuffer, true); // readFullItem

            if (!targetEntry.getDbId().equals(targetDbId)) {
                return false;
            }

            outStream.print("LSN=" + DbLsn.getNoFormatString(getLastLsn()));

            display();
            return true;
        }

        protected abstract void display();
    }

    /*
     * Read the LNs that compose the VLSNIndex. Displays the contents of each
     * LN in VLSNBucket form.
     */
    private class VLSNIndexReader extends DecoderReader {

        VLSNIndexReader(Environment env, 
                        PrintStream out,
                        long startLsn, 
                        long endLsn) {
            super(env, out, startLsn, endLsn, 
                  DbTree.VLSN_MAP_DB_NAME,
                  new LogEntryType[] {
                      LogEntryType.LOG_LN_TRANSACTIONAL,
                      LogEntryType.LOG_LN});
        }

        @Override
        protected void display() {
            DatabaseEntry key = new DatabaseEntry(targetEntry.getKey());
            long keyVal = LongBinding.entryToLong(key);
            LN ln = targetEntry.getLN();
            if (ln.isDeleted()) {
                outStream.print("<deleted>");
            } else {
                DatabaseEntry data = new DatabaseEntry(ln.getData());

                if (keyVal == VLSNRange.RANGE_KEY) {
                    outStream.print(" range: ");
                    VLSNRange range = VLSNRange.readFromDatabase(data);
                    outStream.println(range);
                } else {
                    outStream.print(" key=" + keyVal);
                    VLSNBucket bucket = VLSNBucket.readFromDatabase(data);
                    outStream.println(" " + bucket);
                    if (verbose) {
                        outStream.println("-------------------------------");
                        bucket.dump(outStream);
                        outStream.println("-------------------------------\n");
                    }
                }
            }
        }
    }

    /**
     * Display the LNs that compose the RepGroupDb. 
     */
    private class RepGroupReader extends DecoderReader {

        RepGroupReader(Environment env, PrintStream out,
                       long startLsn, long endLsn) {
            super(env, out, startLsn, endLsn,
                  DbTree.REP_GROUP_DB_NAME,
                  new LogEntryType[] {
                      LogEntryType.LOG_LN_TRANSACTIONAL,
                      LogEntryType.LOG_LN});
        }

        @Override
        protected void display() {
            out.print(" VLSN=" + currentEntryHeader.getVLSN());

            DatabaseEntry key = new DatabaseEntry(targetEntry.getKey());

            LN ln = targetEntry.getLN();
            if (ln.isDeleted()) {
                outStream.print("<deleted>");
            } else {
                DatabaseEntry data = new DatabaseEntry(ln.getData());
                String keyVal = StringBinding.entryToString(key);
                TupleBinding<?> binding = null;
                if (keyVal.equals(RepGroupDB.GROUP_KEY)) {
                    outStream.print(" GroupInfo: ");
                    binding = new GroupBinding();
                } else {
                    outStream.print(" NodeInfo: " + keyVal);
                    binding = new NodeBinding();
                }
                outStream.print(binding.entryToObject(data));     
            }
        }
    }
}
