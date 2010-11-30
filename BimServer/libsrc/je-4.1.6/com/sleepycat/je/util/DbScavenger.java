/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.EnvironmentNotFoundException;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.log.LastFileReader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.ScavengerFileReader;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.utilint.BitMap;
import com.sleepycat.je.utilint.DbLsn;

/**
 * Used to retrieve as much data as possible from a corrupted environment. 
 * This utility is meant to be used programmatically, and is the equivalent
 * to the -R or -r options for {@link DbDump}.
 * <p>
 * To scavenge a database:
 *<pre>
 *  DbScavenger scavenger =
 *      new DbScavenger(env, outputDirectory, <boolean>, <boolean>, <boolean>);
 *  scavenger.dump();
 *</pre> 
 *
 *<p>
 * The recovered databases will put placed in the outputDirectory with ".dump"
 * file suffixes.  The format of the .dump files will be suitable for use with
 * DbLoad.
 */

public class DbScavenger extends DbDump {
    private static final int FLUSH_INTERVAL = 100;
    private int readBufferSize;
    private EnvironmentImpl envImpl;

    /*
     * Set of committed txn ids that have been seen so far.
     */
    private BitMap committedTxnIdsSeen;

    /*
     * Set of LN Node Ids that have been seen so far.
     */
    private BitMap nodeIdsSeen;

    /*
     * Map of database id to database names.
     */
    private Map<Integer, String> dbIdToName;

    /*
     * Map of database id to Boolean (dupSort).
     */
    private Map<Integer, Boolean> dbIdToDupSort;

    /*
     * Map of database id to the .dump file output stream for that database.
     */
    private Map<Integer, PrintStream> dbIdToOutputStream;

    private boolean dumpCorruptedBounds = false;

    private int flushCounter = 0;
    private long lastTime;

    /**
     * Create a DbScavenger object for a specific environment.
     * <p>
     * @param env The Environment containing the database to dump.
     * @param outputDirectory The directory to create the .dump files in.
     * @param formatUsingPrintable true if the dump should use printable 
     * characters.
     * @param doAggressiveScavengerRun true if true, then all data records are
     *  dumped, regardless of whether they are the latest version or not.
     * @param verbose true if status output should be written to System.out
     * during scavenging.
     */
    public DbScavenger(Environment env,
                       String outputDirectory,
                       boolean formatUsingPrintable,
                       boolean doAggressiveScavengerRun,
                       boolean verbose) {
        super(env, null, null, formatUsingPrintable);

        this.doAggressiveScavengerRun = doAggressiveScavengerRun;
        this.dbIdToName = new HashMap<Integer, String>();
        this.dbIdToDupSort = new HashMap<Integer, Boolean>();
        this.dbIdToOutputStream = new HashMap<Integer, PrintStream>();
        this.verbose = verbose;
        this.outputDirectory = outputDirectory;
    }

    /**
     * Set to true if corrupted boundaries should be dumped out.
     */
    public void setDumpCorruptedBounds(boolean dumpCorruptedBounds) {
        this.dumpCorruptedBounds = dumpCorruptedBounds;
    }

    /**
     * Start the scavenger run.
     */
    @Override
    public void dump()
        throws EnvironmentNotFoundException,
               EnvironmentLockedException,
               IOException {

        openEnv(false);

        envImpl = DbInternal.getEnvironmentImpl(env);
        DbConfigManager cm = envImpl.getConfigManager();
        readBufferSize = cm.getInt(EnvironmentParams.LOG_ITERATOR_READ_SIZE);

        /*
         * Find the end of the log.
         */
        LastFileReader reader = new LastFileReader(envImpl, readBufferSize);
        while (reader.readNextEntry()) {
        }

        /* Tell the fileManager where the end of the log is. */
        long lastUsedLsn = reader.getLastValidLsn();
        long nextAvailableLsn = reader.getEndOfLog();
        envImpl.getFileManager().setLastPosition(nextAvailableLsn,
                                                 lastUsedLsn,
                                                 reader.getPrevOffset());

        try {
            /* Pass 1: Scavenge the dbtree. */
            if (verbose) {
                System.out.println("Pass 1: " + new Date());
            }
            scavengeDbTree(lastUsedLsn, nextAvailableLsn);

            /* Pass 2: Scavenge the databases. */
            if (verbose) {
                System.out.println("Pass 2: " + new Date());
            }
            scavenge(lastUsedLsn, nextAvailableLsn);

            if (verbose) {
                System.out.println("End: " + new Date());
            }
        } finally {
            closeOutputStreams();
        }
    }

    /*
     * Scan the log looking for records that are relevant for scavenging the db
     * tree.
     */
    private void scavengeDbTree(long lastUsedLsn, long nextAvailableLsn)
        throws DatabaseException {

        committedTxnIdsSeen = new BitMap();
        nodeIdsSeen = new BitMap();

        final ScavengerFileReader scavengerReader =
            new ScavengerFileReader(envImpl, readBufferSize, lastUsedLsn,
                                    DbLsn.NULL_LSN, nextAvailableLsn) {
                protected void processEntryCallback(LogEntry entry,
                                                    LogEntryType entryType)
                    throws DatabaseException {

                    processDbTreeEntry(entry, entryType);
                }
            };

        scavengerReader.setTargetType(LogEntryType.LOG_MAPLN_TRANSACTIONAL);
        scavengerReader.setTargetType(LogEntryType.LOG_MAPLN);
        scavengerReader.setTargetType(LogEntryType.LOG_NAMELN_TRANSACTIONAL);
        scavengerReader.setTargetType(LogEntryType.LOG_NAMELN);
        scavengerReader.setTargetType(LogEntryType.LOG_TXN_COMMIT);
        scavengerReader.setTargetType(LogEntryType.LOG_TXN_ABORT);
        lastTime = System.currentTimeMillis();
        long fileNum = -1;
        while (scavengerReader.readNextEntry()) {
            fileNum = reportProgress(fileNum,
                                     scavengerReader.getLastLsn());
        }
    }

    private long reportProgress(long fileNum, long lastLsn) {

        long currentFile = DbLsn.getFileNumber(lastLsn);
        if (verbose) {
            if (currentFile != fileNum) {
                long now = System.currentTimeMillis();
                System.out.println("processing file " +
                                   FileManager.getFileName(currentFile,
                                                           ".jdb  ") +
                                   (now-lastTime) + " ms");
                lastTime = now;
            }
        }

        return currentFile;
    }

    /*
     * Look at an entry and determine if it should be processed for scavenging.
     */
    private boolean checkProcessEntry(LogEntry entry,
                                      LogEntryType entryType,
                                      boolean pass2) {
        boolean isTransactional = entryType.isTransactional();

        /*
         * If entry is txnal...
         *  if a commit record, add to committed txn id set
         *  if an abort record, ignore it and don't process.
         *  if an LN, check if it's in the committed txn id set.
         *     If it is, continue processing, otherwise ignore it.
         */
        if (isTransactional) {
            long txnId = entry.getTransactionId();
            if (entryType.equals(LogEntryType.LOG_TXN_COMMIT)) {
                committedTxnIdsSeen.set(txnId);
                /* No need to process this entry further. */
                return false;
            }

            if (entryType.equals(LogEntryType.LOG_TXN_ABORT)) {
                /* No need to process this entry further. */
                return false;
            }

            if (!committedTxnIdsSeen.get(txnId)) {
                return false;
            }
        }

        /*
         * Check the nodeid to see if we've already seen it or not.
         */
        if (entry instanceof LNLogEntry) {
            LNLogEntry lnEntry = (LNLogEntry) entry;
            LN ln = lnEntry.getLN();
            long nodeId = ln.getNodeId();

            /*
             * If aggressive, don't worry about whether this node has been
             * dumped already.
             */
            if (pass2 && doAggressiveScavengerRun) {
                return true;
            }
            if (nodeIdsSeen.get(nodeId)) {
                return false;
            } else {
                nodeIdsSeen.set(nodeId);
                return true;
            }
        }

        return false;
    }

    /*
     * Called once for each log entry during the pass 1 (scavenging the dbtree.
     */
    private void processDbTreeEntry(LogEntry entry, LogEntryType entryType)
        throws DatabaseException {

        boolean processThisEntry =
            checkProcessEntry(entry, entryType, false);

        if (processThisEntry &&
            (entry instanceof LNLogEntry)) {
            LNLogEntry lnEntry = (LNLogEntry) entry;
            LN ln = lnEntry.getLN();
            if (ln instanceof NameLN) {
                String name = new String(lnEntry.getKey());
                Integer dbId = Integer.valueOf(((NameLN) ln).getId().getId());
                if (dbIdToName.containsKey(dbId) &&
                    !dbIdToName.get(dbId).equals(name)) {
                    throw EnvironmentFailureException.unexpectedState
                        ("Already name mapped for dbId: " + dbId +
                         " changed from " + dbIdToName.get(dbId) +
                         " to " + name);
                } else {
                    dbIdToName.put(dbId, name);
                }
            }

            if (ln instanceof MapLN) {
                DatabaseImpl db = ((MapLN) ln).getDatabase();
                Integer dbId = Integer.valueOf(db.getId().getId());
                Boolean dupSort = Boolean.valueOf(db.getSortedDuplicates());
                if (dbIdToDupSort.containsKey(dbId)) {
                    throw EnvironmentFailureException.unexpectedState
                        ("Already saw dupSort entry for dbId: " + dbId);
                } else {
                    dbIdToDupSort.put(dbId, dupSort);
                }
            }
        }
    }

    /*
     * Pass 2: scavenge the regular (non-dbtree) environment.
     */
    private void scavenge(long lastUsedLsn, long nextAvailableLsn)
        throws DatabaseException {

        final ScavengerFileReader scavengerReader =
            new ScavengerFileReader(envImpl, readBufferSize, lastUsedLsn,
                                    DbLsn.NULL_LSN, nextAvailableLsn) {
                protected void processEntryCallback(LogEntry entry,
                                                    LogEntryType entryType)
                    throws DatabaseException {

                    processRegularEntry(entry, entryType);
                }
            };

        /*
         * Note: committed transaction id map has been created already, no
         * need to read TXN_COMMITS on this pass.
         */
        scavengerReader.setTargetType(LogEntryType.LOG_LN_TRANSACTIONAL);
        scavengerReader.setTargetType(LogEntryType.LOG_LN);
        scavengerReader.setTargetType
            (LogEntryType.LOG_DEL_DUPLN_TRANSACTIONAL);
        scavengerReader.setTargetType(LogEntryType.LOG_DEL_DUPLN);
        scavengerReader.setDumpCorruptedBounds(dumpCorruptedBounds);

        long progressFileNum = -1;
        while (scavengerReader.readNextEntry()) {
            progressFileNum = reportProgress(progressFileNum,
                                             scavengerReader.getLastLsn());
        }
    }

    /*
     * Process an entry during pass 2.
     */
    private void processRegularEntry(LogEntry entry, LogEntryType entryType)
        throws DatabaseException {

        boolean processThisEntry =
            checkProcessEntry(entry, entryType, true);

        if (processThisEntry) {
            LNLogEntry lnEntry = (LNLogEntry) entry;
            Integer dbId = Integer.valueOf(lnEntry.getDbId().getId());
            LN ln = lnEntry.getLN();

            /* Create output file even if we don't process a deleted entry. */
            PrintStream out = getOutputStream(dbId);

            if (!ln.isDeleted()) {
                byte[] keyData = lnEntry.getKey();
                byte[] data = ln.getData();
                dumpOne(out, keyData, formatUsingPrintable);
                dumpOne(out, data, formatUsingPrintable);
                if ((++flushCounter % FLUSH_INTERVAL) == 0) {
                    out.flush();
                    flushCounter = 0;
                }
            }
        }
    }

    /*
     * Return the output stream for the .dump file for database with id dbId.
     * If an output stream has not already been created, then create one.
     */
    private PrintStream getOutputStream(Integer dbId)
        throws DatabaseException {

        PrintStream ret = dbIdToOutputStream.get(dbId);
        if (ret != null) {
            return ret;
        }
        String name = dbIdToName.get(dbId);
        if (name == null) {
            name = "db" + dbId;
        }
        File file = new File(outputDirectory, name + ".dump");
        try {
            ret = new PrintStream(new FileOutputStream(file), false);
        } catch (FileNotFoundException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
        dbIdToOutputStream.put(dbId, ret);
        Boolean dupSort = dbIdToDupSort.get(dbId);
        if (dupSort == null) {
            dupSort = Boolean.valueOf(false);
        }
        printHeader(ret, dupSort.booleanValue(), formatUsingPrintable);
        return ret;
    }

    private void closeOutputStreams() {

        Iterator<PrintStream> iter = dbIdToOutputStream.values().iterator();
        while (iter.hasNext()) {
            PrintStream s = iter.next();
            s.println("DATA=END");
            s.close();
        }
    }
}
