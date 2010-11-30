/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import java.io.File;
import java.io.IOException;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Durability;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.EnvironmentNotFoundException;
import com.sleepycat.je.Durability.ReplicaAckPolicy;
import com.sleepycat.je.Durability.SyncPolicy;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.ChecksumException;
import com.sleepycat.je.rep.RepInternal;
import com.sleepycat.je.rep.ReplicatedEnvironment;
import com.sleepycat.je.rep.ReplicationConfig;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.RepParams;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.stream.FeederReader;
import com.sleepycat.je.rep.stream.FeederSyncupReader;
import com.sleepycat.je.rep.stream.OutputWireRecord;
import com.sleepycat.je.rep.vlsn.VLSNIndex;
import com.sleepycat.je.rep.vlsn.VLSNRange;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.tree.Key.DumpType;
import com.sleepycat.je.util.DbPrintLog;
import com.sleepycat.je.utilint.CmdUtil;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.VLSN;

/**
 * @hidden
 * Dumps the log using VLSNReaders. These are special FileReaders which use the
 * vlsnIndex to optimize their traversal of the log. Most common use for this
 * utility is as a debugging device for the VLSNReaders, because it mimics the
 * way feeders and syncup search the log.
 */
public class DbFeederPrintLog {

    /**
     * Dump a JE log into human readable form.
     * @throws InterruptedException
     */
    private void dump(File envHome,
                      String groupName,
                      String nodeName,
                      String host,
                      boolean forward,
                      long startLsn,
                      VLSN startVLSN,
                      @SuppressWarnings("unused") boolean verbose)
        throws IOException,
               EnvironmentNotFoundException,
               EnvironmentLockedException,
               DatabaseException,
               InterruptedException,
               ChecksumException {

        /* Create a single replicator */
        Durability durability = new Durability(SyncPolicy.NO_SYNC,
                                               SyncPolicy.NO_SYNC,
                                               ReplicaAckPolicy.NONE);

        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setAllowCreate(false);
        envConfig.setTransactional(true);
        envConfig.setDurability(durability);

        ReplicationConfig repConfig = new ReplicationConfig();
        repConfig.setConfigParam
            (ReplicationConfig.ENV_CONSISTENCY_TIMEOUT, "1 min");
        repConfig.setGroupName(groupName);
        repConfig.setNodeName(nodeName);
        int port = Integer.parseInt(RepParams.DEFAULT_PORT.getDefault());
        String hostName = host + ":" + port;
        repConfig.setNodeHostPort(hostName);
        repConfig.setHelperHosts(hostName);
        final ReplicatedEnvironment rep =
            RepInternal.createDetachedEnv(envHome, repConfig, envConfig);
        try {
            ReplicatedEnvironment.State state = rep.getState();
            if (state != ReplicatedEnvironment.State.DETACHED) {
                throw EnvironmentFailureException.unexpectedState
                    ("joinState=" + state);
            }

            EnvironmentImpl envImpl =
                DbInternal.getEnvironmentImpl(rep);
            VLSNIndex vlsnIndex =
                RepInternal.getRepImpl(rep).getVLSNIndex();
            if (forward) {
                startLsn = DbLsn.NULL_LSN;
            } else {
                startLsn = envImpl.getFileManager().getLastUsedLsn();
            }

            int readBufferSize =
                envImpl.getConfigManager().getInt
                (EnvironmentParams.LOG_ITERATOR_READ_SIZE);
            FeederReader feederReader = null;
            FeederSyncupReader backwardsReader = null;

            VLSN scanVLSN = startVLSN;
            if (startVLSN.equals(VLSN.NULL_VLSN)) {
                RepImpl repImpl = RepInternal.getRepImpl(rep);
                VLSNRange range = repImpl.getVLSNIndex().getRange();
                if (forward) {
                    scanVLSN = range.getFirst();
                } else {
                    scanVLSN = range.getLast();
                }
            }
            if (scanVLSN.equals(VLSN.NULL_VLSN)) {
                /* Give up, no VLSN entries in the index. */
                System.out.println("<DbPrintLog>");
                System.out.println("</DbPrintLog>");
                return;
            }

            if (forward) {
                feederReader = new FeederReader(envImpl, vlsnIndex, startLsn,
                                                readBufferSize,
                                                new NameIdPair("n0", 0));
                feederReader.initScan(scanVLSN);
            } else {
                backwardsReader = new FeederSyncupReader
                    (envImpl, vlsnIndex,
                     startLsn, readBufferSize,
                     new NameIdPair("n0", 0),
                     scanVLSN,
                     DbLsn.NULL_LSN);
            }

            OutputWireRecord record = null;
            System.out.println("<DbPrintLog>");
            long lastLsn = 0;
            do  {
                if (forward) {
                    record = feederReader.scanForwards(scanVLSN, 0);
                    scanVLSN = scanVLSN.getNext();
                    lastLsn = feederReader.getLastLsn();
                } else {
                    record = backwardsReader.scanBackwards(scanVLSN);
                    scanVLSN = scanVLSN.getPrev();
                    lastLsn = backwardsReader.getLastLsn();
                }
                if (record != null) {
                    System.out.println
                    ("lsn=" + DbLsn.getNoFormatString(lastLsn) + " " + record);
                }
            } while (record != null);

            System.out.println("</DbPrintLog>");
        } finally {
            rep.close();
        }
    }

    public static void main(String[] argv) {
        try {
            int whichArg = 0;
            String groupName = "repGroup";
            String host = "localHost";
            String nodeName = "node8";
            long startLsn = DbLsn.NULL_LSN;
            VLSN startVLSN = VLSN.NULL_VLSN;
            boolean verbose = true;
            boolean forward = true;

            /* Default to looking in current directory. */
            File envHome = new File(".");
            Key.DUMP_TYPE = DumpType.BINARY;

            while (whichArg < argv.length) {
                String nextArg = argv[whichArg];
                if (nextArg.equals("-h")) {
                    whichArg++;
                    envHome = new File(CmdUtil.getArg(argv, whichArg));
                } else if (nextArg.equals("-s")) {
                    whichArg++;
                    String arg = CmdUtil.getArg(argv, whichArg);
                    int slashOff = arg.indexOf("/");
                    if (slashOff < 0) {
                        long startFileNum = CmdUtil.readLongNumber(arg);
                        startLsn = DbLsn.makeLsn(startFileNum, 0);
                    } else {
                        long startFileNum =
                            CmdUtil.readLongNumber(arg.substring(0, slashOff));
                        long startOffset = CmdUtil.readLongNumber
                            (arg.substring(slashOff + 1));
                        startLsn = DbLsn.makeLsn(startFileNum, startOffset);
                    }
                } else if (nextArg.equals("-e")) {
                    whichArg++;
                    String arg = CmdUtil.getArg(argv, whichArg);
                    int slashOff = arg.indexOf("/");
                    /* SuppressWarnings because -e is not yet implemented.*/
                    if (slashOff < 0) {
                        @SuppressWarnings("unused")
                        long endFileNum = CmdUtil.readLongNumber(arg);
                    } else {
                        @SuppressWarnings("unused")
                        long endFileNum =
                            CmdUtil.readLongNumber(arg.substring(0, slashOff));
                        @SuppressWarnings("unused")
                        long endOffset = CmdUtil.readLongNumber
                            (arg.substring(slashOff + 1));
                    }
                } else if (nextArg.equals("-q")) {
                    verbose = false;
                } else if (nextArg.equals("-backward")) {
                    forward = false;
                } else if (nextArg.equals("-vlsn")) {
                    whichArg++;
                    String arg = CmdUtil.getArg(argv, whichArg);
                    startVLSN = new VLSN(CmdUtil.readLongNumber(arg));
                } else {
                    System.err.println
                        (nextArg + " is not a supported option.");
                    usage();
                    System.exit(-1);
                }
                whichArg++;
            }

            DbFeederPrintLog printer = new DbFeederPrintLog();
            printer.dump(envHome, groupName, nodeName, host, forward, startLsn,
                         startVLSN, verbose);

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
        System.out.println(" -e  <end file number or LSN, in hex>");
        System.out.println(" -s  <start file number or LSN, in hex>");
        System.out.println(" -backward if specified, scan is backwards");
        System.out.println("  -vlsn <startVLSN>");
        System.out.println(" -tx <targeted txn ids, comma separated>");
        System.out.println(" -q  if specified, concise version is printed");
        System.out.println("     Default is verbose version.)");
        System.out.println("All arguments are optional");
    }
}
