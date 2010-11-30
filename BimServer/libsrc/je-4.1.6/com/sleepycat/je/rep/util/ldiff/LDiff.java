/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util.ldiff;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseNotFoundException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.utilint.RepUtils;
import com.sleepycat.je.rep.utilint.ServiceDispatcher;
import com.sleepycat.je.rep.utilint.BinaryProtocol.ProtocolException;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ServiceConnectFailedException;
import com.sleepycat.je.utilint.CmdUtil;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * LDiff provides a mechanism for efficiently comparing two quiescent
 * databases, typically residing on different machines connected by a
 * network. The comparison is done at the logical level rather than the
 * physical level, so that we can compare the contents of replicated databases
 * where the logical contents may be identical, but the physical logs may be
 * very different. If the databases are found to be different, it provides
 * information that would help identify the specific nature of the differences.
 *
 * This class provides the external API used to initiate a comparison.
 *
 * For details, please review the document at:
 *
 * @see <a href="https://sleepycat.oracle.com/trac/wiki/JEDatabaseLogicalDiff">
 *      LDiff </a>
 */
public class LDiff {

    private LDiffConfig cfg;
    private File home1, home2;
    private String file1, file2;
    private DiffTracker tracker;

    private static final String usageString = "usage: " +
        CmdUtil.getJavaCommand(LDiff.class) +
        "\n" +
        "  -h <dir>[,<dir2>]   # environment home directory\n" +
        "  [-a]                # analyze diff\n" +
        "  [-b <blockSize>]    # number of records to put in each block\n" +
        "  [-m <maxErrors>]    # abort diff after a number of errors\n" +
        "  [-s <databaseName>,<databaseName>] # database(s) to compare\n" +
        "  [-q]                # be quiet, do not print to stdout";

    private static final int SOCKET_TIMEOUT_MS = 10000;

    /**
     * The main used by the LDiff utility.
     *
     * @param args The arguments accepted by the LDiff utility.
     *
     * <pre>
     * usage: java com.sleepycat.je.rep.util.ldiff.LDiff
     *             [-s database1,database2] -h dbEnvHome1[,dbEnvHome2]
     *             [-a] [-b blockSize] [-m maxErrors] [-q]
     * </pre>
     *
     * <p>
     * -a - generate an analysis of the differences<br>
     * -b blockSize - the number of records to compare at one time<br>
     * -h dbEnvHome - the directory or directories containing environment(s) in
     * which to perform the ldiff<br>
     * -m maxErrors - the maximum number of errors to detect before declaring
     * the databases different and ending the operation.<br>
     * -s database1,database2 - the databases to ldiff.<br>
     * -q - be quiet, do not write to stdout
     * </p>
     * <p>
     * If ldiff-ing a specific database, two database names must be specified.
     * If no database names are given, two environments must be specified.  If
     * two database names and two environments are specified, the first
     * database is opened in the first environment and the second database is
     * opened in the second environment.
     * </p>
     */
    public static void main(String[] args) {
        LDiff differ = new LDiff();
        differ.parseArgs(args);
        try {
            if (differ.diff()) {
                System.exit(0);
            } else {
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void parseArgs(String[] argv) {
        cfg = new LDiffConfig();
        cfg.setVerbose(true);

        int argc = 0;
        int nArgs = argv.length;
        while (argc < nArgs) {
            String thisArg = argv[argc++];
            if (thisArg.equals("-a")) {
                cfg.setDiffAnalysis(true);
            } else if (thisArg.equals("-b")) {
                if (argc < nArgs) {
                    try {
                        cfg.setBlockSize(Integer.parseInt(argv[argc++]));
                    } catch (NumberFormatException nfe) {
                        printUsage("-b requires an integer argument");
                    }
                } else {
                    printUsage("-b requires an argument");
                }
            } else if (thisArg.equals("-h")) {
                if (argc < nArgs) {
                    String[] envDirs = argv[argc++].split(",");
                    if (envDirs.length > 2) {
                        printUsage("Only 2 environments supported");
                    }

                    home1 = new File(envDirs[0]);
                    if (envDirs.length == 2) {
                        home2 = new File(envDirs[1]);
                    }
                } else {
                    printUsage("-h requires an argument");
                }
            } else if (thisArg.equals("-m")) {
                if (argc < nArgs) {
                    try {
                        cfg.setMaxErrors(Integer.parseInt(argv[argc++]));
                    } catch (NumberFormatException nfe) {
                        printUsage("-m requires an integer argument");
                    }
                } else {
                    printUsage("-m requires an argument");
                }
            } else if (thisArg.equals("-s")) {
                if (argc < nArgs) {
                    String[] dbNames = argv[argc++].split(",");
                    if (dbNames.length != 2) {
                        printUsage("-s requires two database names");
                    }
                    file1 = dbNames[0];
                    file2 = dbNames[1];
                } else {
                    printUsage("-s requires an argument");
                }
            } else if (thisArg.equals("-q")) {
                cfg.setVerbose(false);
            } else {
                printUsage(thisArg + " is not a valid option.");
            }
        }

        if (home1 == null) {
            printUsage("-h is a required argument");
        }

        if (home2 == null && file1 == null) {
            printUsage("2 databases must be specified with 1 environment");
        }
    }

    private void printUsage(String msg) {
        System.err.println(msg);
        System.err.println(usageString);
        System.exit(-1);
    }

    private LDiff() {
    }

    /**
     * Configure a new object with which to compare two databases.
     *
     * @param cfg the configuration parameters for the new object.
     */
    public LDiff(LDiffConfig cfg) {
        super();
        this.cfg = cfg;
    }

    /*
     * Run an LDiff called from the command line.  What actually gets diffed
     * depends upon the args passed in, either 2 environments, databases in two
     * separate environments or databases in the same environment.
     */
    private boolean diff()
        throws Exception {

        EnvironmentConfig envConfiguration = new EnvironmentConfig();
        envConfiguration.setReadOnly(true);
        envConfiguration.setCachePercent(40);
        Environment env1 = new Environment(home1, envConfiguration);

        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setReadOnly(true);
        DbInternal.setUseExistingConfig(dbConfig, true);

        Database db2;
        if (home2 != null) {
            Environment env2 = new Environment(home2, envConfiguration);
            if (file1 == null) {
                /* No dbs given, ldiff the environments. */
                boolean ret = diff(env1, env2);
                env1.close();
                env2.close();
                return ret;
            }
            db2 = env2.openDatabase(null, file2, dbConfig);
        } else {
            db2 = env1.openDatabase(null, file2, dbConfig);
        }
        Database db1 = env1.openDatabase(null, file1, dbConfig);

        boolean ret = diff(db1, db2);
        db1.close();
        db2.close();
        env1.close();

        return ret;
    }

    /**
     * A mechanism for efficiently comparing all databases in two quiescent
     * environments.
     *
     * @param env1 a valid, open Environment handle
     * @param env2 a valid, open Environment handle
     * @return true if all databases in env1 and env2 are identical
     * @throws Exception
     */
    public boolean diff(Environment env1, Environment env2)
        throws Exception {

        List<String> env1names = env1.getDatabaseNames();
        List<String> env2names = env2.getDatabaseNames();
        boolean ret = (env1names.size() == env2names.size());
        if (!ret) {
            output("Environments have different number of databases.");
        }
        for (String dbName : env1names) {
            DatabaseConfig dbConfig = new DatabaseConfig();
            dbConfig.setReadOnly(true);
            DbInternal.setUseExistingConfig(dbConfig, true);
            Database db1, db2;
            try {
                db1 = env1.openDatabase(null, dbName, dbConfig);
            } catch (DatabaseNotFoundException e) {
                /* Should never happen, ExclusiveCreate is false. */
                throw EnvironmentFailureException.unexpectedException(e);
            }
            try {
                db2 = env2.openDatabase(null, dbName, dbConfig);
            } catch (DatabaseNotFoundException e) {
                /* There's a database in env1 that's not in env2. */
                db1.close();
                output(dbName +
                       " does not exist in " + env2.getHome().getName());
                ret = false;
                continue;
            }

            if (!diff(db1, db2)) {
                ret = false;
            }
            db1.close();
            db2.close();
        }
        if (ret) {
            output("No differences exist between the two environments.");
        } else {
            output("Differences exist between the two environments.");
        }
        return ret;
    }

    /**
     * A mechanism for efficiently comparing two quiescent databases.
     *
     * @param db1 a valid, open Database handle
     * @param db2 a valid, open Database handle
     * @return true if the db1 and db2 are identical
     * @throws Exception
     */
    public boolean diff(Database db1, Database db2)
        throws Exception {

        BlockBag bag = createBlockBag(db2);
        final boolean ret = diff(db1, bag);
        if (cfg.getVerbose()) {
            final String db1Name = db1.getDatabaseName();
            final String db2Name = db2.getDatabaseName();
            final boolean namesMatch = db1Name.equals(db2Name);
            if (ret) {
                if (namesMatch) {
                    output("No differences in " + db1Name);
                } else {
                    output(db1Name + " matches " + db2Name);
                }
            } else {
                if (namesMatch) {
                    output("Differences in " + db1Name);
                } else {
                    output(db1Name + " does not match " + db2Name);
                }
            }
        }

        /* Do the analysis for these two databases. */
        if (cfg.getDiffAnalysis() && tracker.getDiffRegions().size() != 0) {
            DiffRecordAnalyzer.doAnalysis(db1, db2, tracker, cfg.getVerbose());
        }

        return ret;
    }

    /**
     * A mechanism for efficiently comparing two quiescent environments, one
     * local and one on a remote machine.
     *
     * @param env a valid, open Environment handle
     * @param addr the address of the remote machine
     * @return true if all the databases in both environments are the same
     * @throws IOException if a network error occurs
     * @throws ProtocolException if an unexpected message is received
     * @throws ServiceConnectFailedException if the remote service was busy
     * @throws Exception
     */
    public boolean diff(Environment env, InetSocketAddress addr)
        throws IOException,
               ProtocolException,
               ServiceConnectFailedException,
               Exception {

        List<String> envNames = env.getDatabaseNames();
        boolean ret = true;

        SocketChannel channel = connect(addr);

        final Protocol protocol = new Protocol(
                new NameIdPair("Ldiff", -1),
                DbInternal.getEnvironmentImpl(env));
        protocol.write(protocol.new EnvDiff(), channel);

        /*
         * Check that the number of local databases matches the number of
         * remote databases.  This is how we detect a remote db that doesn't
         * exist locally.
         */
        Protocol.EnvInfo msg = protocol.read(channel, Protocol.EnvInfo.class);
        ret = (envNames.size() == msg.getNumberOfDBs());
        if (!ret) {
            output("Number of databases in local and remote environments " +
                   "does not match.");
        }
        channel.close();

        /*
         * Run LDiff for every database in the local environment.  If they all
         * succeed, the environments match.
         */
        for (String dbName : envNames) {
            channel = connect(addr);

            DatabaseConfig dbConfig = new DatabaseConfig();
            dbConfig.setReadOnly(true);
            DbInternal.setUseExistingConfig(dbConfig, true);
            Database db;
            try {
                db = env.openDatabase(null, dbName, dbConfig);
            } catch (DatabaseNotFoundException e) {
                /* Should never happen, ExclusiveCreate is false. */
                throw EnvironmentFailureException.unexpectedException(e);
            }

            try {
                if (!diff(db, channel)) {
                    ret = false;
                }
            } catch (ProtocolException pe) {
                output(dbName + " does not exist in remote environment.");
                ret = false;
            } finally {
                db.close();
                if (channel.isOpen()) {
                    channel.close();
                }
            }
        }
        if (ret) {
            output("Local environment matches remote.");
        } else {
            output("Local environment does not match remote.");
        }
        return ret;
    }

    /**
     * A mechanism for efficiently comparing two quiescent databases, one of
     * which resides on a remote machine.
     *
     * @param db a valid, open Database handle
     * @param addr the address of the remote host
     * @return true if the local Database and the remote Database are identical
     * @throws IOException if a network error occurs
     * @throws ProtocolException if the remote database does not exist
     * @throws ServiceConnectFailedException if the remote service is busy
     * @throws Exception
     */
    public boolean diff(Database db, InetSocketAddress addr)
        throws IOException,
               ProtocolException,
               ServiceConnectFailedException,
               Exception {

        final SocketChannel channel = connect(addr);
        boolean ret;
        try {
            ret = diff(db, channel);
        } finally {
            channel.close();
        }

        return ret;
    }

    private boolean diff(Database db, SocketChannel channel)
        throws IOException, ProtocolException, Exception {

        final Protocol protocol = new Protocol(
                new NameIdPair("Ldiff", -1),
                DbInternal.getEnvironmentImpl(db.getEnvironment()));
        protocol.write(protocol.new DbBlocks
                       (db.getDatabaseName(), cfg.getBlockSize()), channel);

        /*
         * A protocol exception will be thrown here if the remote env does not
         * have a database of the same name.
         */
        protocol.read(channel, Protocol.BlockListStart.class);

        BlockBag bag = new BlockBag();
        Protocol.BlockInfo blockMsg;
        while (true) {
            try {
                blockMsg = protocol.read(channel, Protocol.BlockInfo.class);
                bag.add(blockMsg.getBlock());
            } catch (ProtocolException pe) {
                if (pe.getUnexpectedMessage().getOp() !=
                    Protocol.BLOCK_LIST_END) {
                    throw pe;
                }
                break;
            }

        }

        boolean match = diff(db, bag);
        if (match) {
            output(db.getDatabaseName() + " matches remote database.");
        } else {
            output(db.getDatabaseName() + "does not match remote database.");
        }

        if (cfg.getDiffAnalysis() && tracker.getDiffRegions().size() != 0) {
            DiffRecordAnalyzer.doAnalysis
                (db, protocol, channel, tracker, cfg.getVerbose());
        }
        protocol.write(protocol.new Done(), channel);

        return match;
    }

    /**
     * A mechanism for efficiently comparing two quiescent databases, typically
     * residing on different machines connected by a network.
     *
     * @param db a valid, open Database handle
     * @param blkBag a bag of blocks to diff against db.
     *
     * @return true if the two comparing databases are identical.
     * @throws Exception
     */
    public boolean diff(Database db, BlockBag blkBag)
        throws Exception {

        /* Suppose the two comparing databases are identical, by default. */
        boolean identical = true;
        
        /*
         * window represents a BlockSize window into db. Initialize it to
         * represent the block starting at the first key in db.
         */
        Cursor cursor = db.openCursor(null, null);

        long pos = 1;
        int numKeys = cfg.getBlockSize();
        Window window = new Window(cursor, numKeys);

        int errors = 0;
        int maxerrors = cfg.getMaxErrors();
        tracker = new DiffTracker(numKeys);
        while (window.getChecksum() != 0 && blkBag.size() > 0) {

            /*
             * Find the block in the bag whose checksum and md5 match the
             * current window. This block, if it exists, is match.
             */
            Block match = findMatch(db.getEnvironment(), blkBag, window);
            if (match != null) {
                tracker.setBlockDiffBegin
                    (blkBag.getBlock(), blkBag.getBlockIndex());
                /* Remove match and any earlier blocks from the bag. */
                List<Block> removed = blkBag.remove(match);
                if (removed != null) {
                    identical = false;
                    errors += removed.size();
                    tracker.calBlockDiffSize(blkBag.getBlockIndex());
                    if (maxerrors > 0 && errors >= maxerrors) {
                        break;
                    }
                }

                tracker.addDiffRegion(window);

                /* Advance the window beyond the just matched block. */
                window.nextWindow();
                pos += window.size();

                continue;
            }

            identical = false;
            LoggerUtils.envLogMsg
                (Level.FINE,
                 DbInternal.getEnvironmentImpl(db.getEnvironment()),
                 "Unmatched block at position " + pos);
            errors++;
            if (maxerrors > 0 && errors >= maxerrors) {
                break;
            }

            /* Roll the window forward by one key. */
            window.rollWindow();

            if (window.getChecksum() != 0) {
                pos++;
            }
        }

        cursor.close();

        if (window.getChecksum() != 0) {

            /*
             * We ran out of blocks in blkBag before we got to the end of db.
             * Update the unmatched key range.
             */
            LoggerUtils.envLogMsg
                (Level.FINE,
                 DbInternal.getEnvironmentImpl(db.getEnvironment()),
                 "Local Db has addtional records starting at " + pos + ".");
            identical = false;
            tracker.addWindowAdditionalDiffs(window);
        }

        if (blkBag.size() > 0) {
            /* All remaining blocks in the bag are unmatched. */
            for (Block b : blkBag) {
                LoggerUtils.envLogMsg
                    (Level.FINE,
                     DbInternal.getEnvironmentImpl(db.getEnvironment()),
                     "Unmatched remote block: " + b);
            }
            identical = false;
            tracker.addBlockBagAdditionalDiffs(window, blkBag);
        }

        return identical;
    }

    /* For unit test only. */
    public List<MismatchedRegion> getDiffRegions() {
        if (tracker == null) {
            return null;
        }

        return tracker.getDiffRegions();
    }

    /**
     * Find the block in the bag whose rolling checksum and md5 match the given
     * window. The md5 for the window is computed lazily, since it's more
     * expensive to compute. There is a slight chance that multiple blocks in
     * the bag will match the checksum and the md5 hash, return the first such
     * block added to the bag in that case.
     *
     * @param blkBag a bag of blocks to search for a match
     * @param window the block sized window of the db we're diffing
     * @return A block which matches the window's checksum and the window's md5
     * hash, or null if no block matches.
     */
    private Block findMatch(Environment env, BlockBag blkBag, Window window) {
        List<Block> matches = blkBag.get(window.getChecksum());
        if (matches == null) {
            return null;
        }

        /* Delay the computation of the hash until we know we need it. */
        byte[] md5 = window.getMd5Hash();
        for (Block b : matches) {
            if (Arrays.equals(b.getMd5Hash(), md5)) {
                return b;
            }
            LoggerUtils.envLogMsg
                (Level.FINE,
                 DbInternal.getEnvironmentImpl(env),
                 "Found a remote block whose rolling checksum " +
                 "matches LB but md5 hash doesn't:" + b);
        }
        /* No matches. */
        return null;
    }

    /**
     * Create a bag of blocks from the records in a given database, using the
     * configuration parameters specified when the LDiff object was created.
     *
     * @param db the database from which to create the bag of blocks
     * @return a bag of blocks built from the records in db
     */
    public BlockBag createBlockBag(Database db) {
        BlockBag bag = new BlockBag();

        /* Retrieve the key/data pairs and fill into blocks. */
        long start = System.currentTimeMillis();
        Iterator<Block> iter = iterator(db);
        while (iter.hasNext()) {
            bag.add(iter.next());
        }
        long end = System.currentTimeMillis();
        LoggerUtils.envLogMsg
            (Level.FINE,
             DbInternal.getEnvironmentImpl(db.getEnvironment()),
             "Block bag created in : " + (end - start) + " ms.");
        return bag;
    }

    public Iterator<Block> iterator(Database db) {
        return new LDiffIterator(db);
    }

    /**
     * Connect to addr and perform a service handshake.  Retry as specified by
     * the config object.
     *
     * @param addr the remote address to connect to
     * @return an open SocketChannel
     * @throws IOException if an exception occurs with the SocketChannel
     * @throws ServiceConnectFailedException if the remote service is busy
     */
    private SocketChannel connect(InetSocketAddress addr)
        throws IOException, ServiceConnectFailedException {

        int triesLeft = cfg.getMaxConnectionAttempts();
        SocketChannel ret = null;
        while (true) {
            try {
                ret = RepUtils.openBlockingChannel(addr, true,
                                                   SOCKET_TIMEOUT_MS);
                ServiceDispatcher.doServiceHandshake(ret, LDiffService.NAME);
                break;
            } catch (ServiceConnectFailedException scfe) {
                if ((ret != null) && ret.isOpen()) {
                    ret.close();
                }

                /*
                 * Unable to connect because the remote service is busy.  If
                 * the user requested it, keep re-trying.  triesLeft == -1
                 * means never abort.
                 */
                if (triesLeft > 0) {
                    triesLeft--;
                }

                if (!cfg.getWaitIfBusy() || triesLeft == 0) {
                    throw scfe;
                }
            }
        }

        return ret;
    }

    private void output(String msg) {
        if (cfg.getVerbose()) {
            System.out.println(msg);
        }
    }

    /**
     * The exception that is thrown when a database diff detects differences.
     *
     * TODO: we start simple, by just using it as a boolean indicator and
     * perhaps a block id for unit test purposes? As as the local processing
     * gains in sophistication will provide block and key (insert, update,
     * delete) granularity identification of differences.
     */
    @SuppressWarnings("serial")
    class MismatchException extends Exception {

        public MismatchException(String message) {
            super(message);
        }
    }

    private class LDiffIterator implements Iterator<Block> {
        private Block cached;
        private Cursor cursor;
        private final Database db;
        private DatabaseEntry lastKey, lastData;
        private boolean more;
        private int i;
        private final int numKeys;

        public LDiffIterator(Database db) {
            i = 0;
            numKeys = LDiff.this.cfg.getBlockSize();
            cached = null;
            more = true;
            this.db = db;

            /* Prime the pump, get the first block in cached and set more. */
            next();
        }

        public boolean hasNext() {
            return more;
        }

        public void remove() {

        }

        public Block next() {
            if (!more) {
                throw new NoSuchElementException();
            }

            /*
             * We don't want to return a block with 0 keys, but we can't know
             * ahead of time whether the block will have any keys and the user
             * likely called hasNext() already.  So when asked for block i, we
             * cache block i+1, check whether it's empty and return the
             * previously cached block i.  If block i+1 is empty, the next call
             * to hasNext() will return false and the empty block won't be
             * returned.
             */
            cursor = db.openCursor(null, null);
            if (lastKey == null) {
                lastKey = new DatabaseEntry();
                lastData = new DatabaseEntry();
            } else {
                cursor.getSearchBoth(lastKey, lastData, null);
            }
            Block ret = cached;
            cached = LDiffUtil.readBlock(i++, cursor, numKeys);
            if (cached.numRecords == 0) {
                more = false;
            } else {
                cursor.getCurrent(lastKey, lastData, null);
            }
            cursor.close();
            return ret;
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                cursor.close();
            } finally {
                super.finalize();
            }
        }
    }
}
