/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2005-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.io.File;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Random;

import com.sleepycat.je.CheckpointConfig;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentStats;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.PreloadConfig;
import com.sleepycat.je.PreloadStats;
import com.sleepycat.je.PreloadStatus;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.utilint.CmdUtil;

/**
 * Estimating JE in-memory sizes as a function of key and data size is not
 * straightforward for two reasons. There is some fixed overhead for each btree
 * internal node, so tree fanout and degree of node sparseness impacts memory
 * consumption. In addition, JE compresses some of the internal nodes where
 * possible, but compression depends on on-disk layouts. For these reasons,
 * this utility will may output inaccurate values, and most commonly it will
 * output a larger cache size than is actually needed.
 * <p>
 * DbCacheSize is an aid for estimating cache sizes. To get an estimate of the
 * in-memory footprint for a given database, specify the number of records and
 * record characteristics and DbCacheSize will return a minimum and maximum
 * estimate of the cache size required for holding the database in memory.
 * If the user specifies the record's data size, the utility will return both
 * values for holding just the internal nodes of the btree, and for holding the
 * entire database in cache.
 * <p>
 * Note that "cache size" is a percentage more than "btree size", to cover
 * general environment resources like log buffers. Each invocation of the
 * utility returns an estimate for a single database in an environment.  For an
 * environment with multiple databases, run the utility for each database, add
 * up the btree sizes, and then add 10 percent.
 * <p>
 * The utility does not yet cover duplicate records and the API is subject to
 * change release to release.
 * <p>
 * The only required parameters are the number of records and key size.
 * Data size, non-tree cache overhead, btree fanout, and other parameters
 * can also be provided. For example:
 * <p>
 * You should run DbCacheSize on the same target platform and JVM for which you
 * are sizing the cache, as cache sizes will vary.  You should also specify
 * -d32 or -d64 depending on your target as this also figures into the
 * computation.
 * <pre>
 * $ java DbCacheSize -jar je-X.Y.Z.jar -records 554719 -key 16 -data 100
 * Inputs: records=554719 keySize=16 dataSize=100 nodeMax=128 density=80%
 * overhead=10%
 *
 *     Cache Size      Btree Size  Description
 * --------------  --------------  -----------
 *     30,547,440      27,492,696  Minimum, internal nodes only
 *     41,460,720      37,314,648  Maximum, internal nodes only
 *    114,371,644     102,934,480  Minimum, internal nodes and leaf nodes
 *    125,284,924     112,756,432  Maximum, internal nodes and leaf nodes
 *
 * Btree levels: 3
 * </pre>
 *
 * <p>
 * This says that the minimum cache size to hold only the internal nodes of the
 * btree in cache is approximately 30MB. The maximum size to hold the entire
 * database in cache, both internal nodes and datarecords, is 125Mb.
 * See {@link DbCacheSize#main} for full parameter descriptions.
 */
public class DbCacheSize {

    private static final NumberFormat INT_FORMAT =
        NumberFormat.getIntegerInstance();

    private static final String MAIN_HEADER =
        "   Cache Size       Btree Size    Description\n" +
        "---------------  ---------------  -----------";
    //   123456789012345  123456789012345
    //                  12
    private static final String LEVELS_HEADER =
        " Minimum Bytes    Maximum Bytes      Nodes    Level\n" +
        "---------------  ---------------  ----------  -----";
    private static final int COLUMN_WIDTH = 15;
    private static final String COLUMN_SEPARATOR = "  ";
    private static final int MAX_LEVELS = 9;

    private final long records;
    private final int keySize;
    private final int dataSize;
    private final int nodeMax;
    private int binMax;
    private final int density;
    private final long overhead;
    private long minInBtreeSize;
    private long maxInBtreeSize;
    private long minInCacheSize;
    private long maxInCacheSize;
    private long maxInBtreeSizeWithData;
    private long maxInCacheSizeWithData;
    private long minInBtreeSizeWithData;
    private long minInCacheSizeWithData;
    private int nLevels;
    private final long[] numLevel = new long[MAX_LEVELS];
    private final long[] minLevel = new long[MAX_LEVELS];
    private final long[] maxLevel = new long[MAX_LEVELS];
    private long totalNum;

    /**
     * DbCacheSize is an aid for estimating cache sizes. To get an estimate of
     * the in-memory footprint for a given database, specify the number of
     * records and record characteristics and DbCacheSize will return a minimum
     * and maximum estimate of the cache size required for holding the database
     * in memory. If the user specifies the record's data size, the utility
     * will return both values for holding just the internal nodes of the
     * btree, and for holding the entire database in cache.
     * @param records Total records (key/data pairs)
     * @param keySize Average key bytes per record
     * @param dataSize Average data bytes per record; if omitted no leaf
     *                  node sizes are included in the output
     * @param nodeMax Number of entries per Btree node
     * @param density Percentage of node entries occupied
     * @param overhead Overhead of non-Btree objects (log buffers, locks,
     * default: 10% of total cache size)
     */
    public DbCacheSize(final long records,
                       final int keySize,
                       final int dataSize,
                       final int nodeMax,
                       final int density,
                       final long overhead) {
        this.records = records;
        this.keySize = keySize;
        this.dataSize = dataSize;
        this.nodeMax = nodeMax;
        this.density = density;
        this.overhead = overhead;
    }

    /* Hidden property, for now. */
    private void setBinMax(final int binMax) {
        this.binMax = binMax;
    }

    public long getMinCacheSizeInternalNodesOnly() {
        return minInCacheSize;
    }

    public long getMaxCacheSizeInternalNodesOnly() {
        return maxInCacheSize;
    }

    public long getMinBtreeSizeInternalNodesOnly() {
        return minInBtreeSize;
    }

    public long getMaxBtreeSizeInternalNodesOnly() {
        return maxInBtreeSize;
    }

    public long getMinCacheSizeWithData() {
        return minInCacheSizeWithData;
    }

    public long getMaxCacheSizeWithData() {
        return maxInCacheSizeWithData;
    }

    public long getMinBtreeSizeWithData() {
        return minInBtreeSizeWithData;
    }

    public long getMaxBtreeSizeWithData() {
        return maxInBtreeSizeWithData;
    }

    public int getNLevels() {
        return nLevels;
    }

    /**
     * Usage:
     * <pre>
     * java { com.sleepycat.je.util.DbCacheSize |
     *         -jar je-<version>.jar DbCacheSize }
     *  -records <count>
     *    # Total records (key/data pairs); required
     *  -key <bytes>
     *    # Average key bytes per record; required
     *  [-data <bytes>]
     *    # Average data bytes per record; if omitted no leaf
     *    # node sizes are included in the output
     *  [-nodemax <entries>]
     *    # Number of entries per Btree node; default: 128
     *  [-density <percentage>]
     *    # Percentage of node entries occupied; default: 80
     *  [-overhead <bytes>]
     *    # Overhead of non-Btree objects (log buffers, locks,
     *    # etc); default: 10% of total cache size
     *  [-measure <environmentHomeDirectory>]
     *    # An empty directory used to write a database to find
     *    # the actual cache size; default: do not measure;
     *    # without -data, measures internal nodes only
     *  [-measurerandom
     *    # With -measure insert randomly generated keys;
     *    # default: insert sequential keys
     * </pre>
     */
    public static void main(final String[] args) {

        try {
            long records = 0;
            int keySize = 0;
            int dataSize = -1;
            int nodeMax = 128;
            int binMax = -1;
            int density = 80;
            long overhead = 0;
            File measureDir = null;
            boolean measureRandom = false;

            for (int i = 0; i < args.length; i += 1) {
                String name = args[i];
                String val = null;
                if (i < args.length - 1 && !args[i + 1].startsWith("-")) {
                    i += 1;
                    val = args[i];
                }
                if (name.equals("-records")) {
                    if (val == null) {
                        usage("No value after -records");
                    }
                    try {
                        records = Long.parseLong(val);
                    } catch (NumberFormatException e) {
                        usage(val + " is not a number");
                    }
                    if (records <= 0) {
                        usage(val + " is not a positive integer");
                    }
                } else if (name.equals("-key")) {
                    if (val == null) {
                        usage("No value after -key");
                    }
                    try {
                        keySize = Integer.parseInt(val);
                    } catch (NumberFormatException e) {
                        usage(val + " is not a number");
                    }
                    if (keySize <= 0) {
                        usage(val + " is not a positive integer");
                    }
                } else if (name.equals("-data")) {
                    if (val == null) {
                        usage("No value after -data");
                    }
                    try {
                        dataSize = Integer.parseInt(val);
                    } catch (NumberFormatException e) {
                        usage(val + " is not a number");
                    }
                    if (dataSize < 0) {
                        usage(val + " is not a non-negative integer");
                    }
                } else if (name.equals("-nodemax")) {
                    if (val == null) {
                        usage("No value after -nodemax");
                    }
                    try {
                        nodeMax = Integer.parseInt(val);
                    } catch (NumberFormatException e) {
                        usage(val + " is not a number");
                    }
                    if (nodeMax <= 0) {
                        usage(val + " is not a positive integer");
                    }
                } else if (name.equals("-binmax")) {
                    if (val == null) {
                        usage("No value after -binmax");
                    }
                    try {
                        binMax = Integer.parseInt(val);
                    } catch (NumberFormatException e) {
                        usage(val + " is not a number");
                    }
                    if (binMax <= 0) {
                        usage(val + " is not a positive integer");
                    }
                } else if (name.equals("-density")) {
                    if (val == null) {
                        usage("No value after -density");
                    }
                    try {
                        density = Integer.parseInt(val);
                    } catch (NumberFormatException e) {
                        usage(val + " is not a number");
                    }
                    if (density < 1 || density > 100) {
                        usage(val + " is not betwen 1 and 100");
                    }
                } else if (name.equals("-overhead")) {
                    if (val == null) {
                        usage("No value after -overhead");
                    }
                    try {
                        overhead = Long.parseLong(val);
                    } catch (NumberFormatException e) {
                        usage(val + " is not a number");
                    }
                    if (overhead < 0) {
                        usage(val + " is not a non-negative integer");
                    }
                } else if (name.equals("-measure")) {
                    if (val == null) {
                        usage("No value after -measure");
                    }
                    measureDir = new File(val);
                } else if (name.equals("-measurerandom")) {
                    measureRandom = true;
                } else {
                    usage("Unknown arg: " + name);
                }
            }

            if (records == 0) {
                usage("-records not specified");
            }

            if (keySize == 0) {
                usage("-key not specified");
            }

            final DbCacheSize dbCacheSize = new DbCacheSize
                (records, keySize, dataSize, nodeMax, density, overhead);
            dbCacheSize.setBinMax(binMax > 0 ? binMax : nodeMax);
            dbCacheSize.caclulateCacheSizes();
            dbCacheSize.printCacheSizes(System.out);

            if (measureDir != null) {
                dbCacheSize.measure(System.out, measureDir, measureRandom);
            }
        } catch (Throwable e) {
            e.printStackTrace(System.out);
        }
    }

    private static void usage(final String msg) {

        if (msg != null) {
            System.out.println(msg);
        }

        System.out.println
            ("usage:" +
             "\njava "  + CmdUtil.getJavaCommand(DbCacheSize.class) +
             "\n   -records <count>" +
             "\n      # Total records (key/data pairs); required" +
             "\n   -key <bytes> " +
             "\n      # Average key bytes per record; required" +
             "\n  [-data <bytes>]" +
             "\n      # Average data bytes per record; if omitted no leaf" +
             "\n      # node sizes are included in the output" +
             "\n  [-nodemax <entries>]" +
             "\n      # Number of entries per Btree node; default: 128" +
             "\n  [-density <percentage>]" +
             "\n      # Percentage of node entries occupied; default: 80" +
             "\n  [-overhead <bytes>]" +
             "\n      # Overhead of non-Btree objects (log buffers, locks," +
             "\n      # etc); default: 10% of total cache size" +
             "\n  [-measure <environmentHomeDirectory>]" +
             "\n      # An empty directory used to write a database to find" +
             "\n      # the actual cache size; default: do not measure;" +
             "\n      # without -data, measures internal nodes only" +
             "\n  [-measurerandom" +
             "\n      # With -measure insert randomly generated keys;" +
             "\n      # default: insert sequential keys");

        System.exit(2);
    }

    private void caclulateCacheSizes() {
        final double nodeAvg = (nodeMax * density) / 100.0;
        final double binAvg = (binMax * density) / 100.0;
        final long nBinNodes = (long) (records / binAvg);

        /* Bottom level. */
        numLevel[0] = nBinNodes;
        minLevel[0] = nBinNodes * calcInSize(binMax, binAvg, keySize, true);
        maxLevel[0] = nBinNodes * calcInSize(binMax, binAvg, keySize, false);
        nLevels = 1;

        /* Upper levels. */
        for (long nodes = (long) (nBinNodes / nodeAvg);; nodes /= nodeAvg) {
            if (nLevels >= MAX_LEVELS) {
                throw new IllegalArgumentException
                    ("Maximum levels (" + MAX_LEVELS + ") exceeded.");
            }
            if (nodes == 0) {
                nodes = 1; // root
            }
            numLevel[nLevels] = nodes;
            minLevel[nLevels] =
                nodes * calcInSize(nodeMax, nodeAvg, keySize, true);
            maxLevel[nLevels] =
                nodes * calcInSize(nodeMax, nodeAvg, keySize, false);
            nLevels += 1;
            if (nodes == 1) {
                break;
            }
        }

        /* Totals. */
        for (int level = 0; level < nLevels; level += 1) {
            totalNum += numLevel[level];
            minInBtreeSize += minLevel[level];
            maxInBtreeSize += maxLevel[level];
        }

        minInCacheSize = calculateOverhead(minInBtreeSize, overhead);
        maxInCacheSize = calculateOverhead(maxInBtreeSize, overhead);

        long lnSize = 0;
        if (dataSize >= 0) {
            lnSize = records * calcLnSize(dataSize);
        }

        maxInBtreeSizeWithData = maxInBtreeSize + lnSize;
        maxInCacheSizeWithData = calculateOverhead(maxInBtreeSizeWithData,
                                                    overhead);
        minInBtreeSizeWithData = minInBtreeSize + lnSize;
        minInCacheSizeWithData = calculateOverhead(minInBtreeSizeWithData,
                                                    overhead);
    }

    private void printCacheSizes(final PrintStream out) {

        out.println("Inputs:" +
                    " records=" + records +
                    " keySize=" + keySize +
                    " dataSize=" + dataSize +
                    " nodeMax=" + nodeMax +
                    " binMax=" + binMax +
                    " density=" + density + '%' +
                    " overhead=" + ((overhead > 0) ? overhead : 10) + "%");

        out.println();
        out.println("=== Cache Sizing Summary ===");
        out.println();
        out.println(MAIN_HEADER);
        out.println(line(minInBtreeSize, minInCacheSize,
                         "Minimum, internal nodes only"));
        out.println(line(maxInBtreeSize, maxInCacheSize,
                         "Maximum, internal nodes only"));
        if (dataSize >= 0) {
            out.println(line(minInBtreeSizeWithData,
                             minInCacheSizeWithData,
                             "Minimum, internal nodes and leaf nodes"));
            out.println(line(maxInBtreeSizeWithData,
                             maxInCacheSizeWithData,
                        "Maximum, internal nodes and leaf nodes"));
        } else {
            out.println("\nTo get leaf node sizing specify -data");
        }

        out.println();
        out.println("=== Memory Usage by Btree Level ===");
        out.println();
        out.println(LEVELS_HEADER);

        for (int level = 0; level < nLevels; level += 1) {
            /* 3rd column is Nodes + Level. */
            StringBuffer buf = new StringBuffer();
            buf.append(INT_FORMAT.format(numLevel[level]));
            buf.append("    ");
            buf.append(level + 1);
            String lastCol = buf.toString();
            out.println(line(maxLevel[level], minLevel[level], lastCol));
        }
    }

    private int calcInSize(final int nodeMax,
                           final double nodeAvg,
                           final int keySize,
                           final boolean lsnCompression) {

        /* Fixed overhead */
        int size = MemoryBudget.IN_FIXED_OVERHEAD;

        /* Byte state array plus keys and nodes arrays */
        size += MemoryBudget.byteArraySize(nodeMax) +
                (nodeMax * (2 * MemoryBudget.OBJECT_ARRAY_ITEM_OVERHEAD));

        /* LSN array */
        if (lsnCompression) {
            size += MemoryBudget.byteArraySize(nodeMax * 2);
        } else {
            size += MemoryBudget.ARRAY_OVERHEAD +
                    (nodeMax * MemoryBudget.PRIMITIVE_LONG_ARRAY_ITEM_OVERHEAD);
        }

        /* Keys for populated entries plus the identifier key */
        size += (int) (nodeAvg * MemoryBudget.byteArraySize(keySize));

        return size;
    }

    private int calcLnSize(final int dataSize) {

        return MemoryBudget.LN_OVERHEAD +
               MemoryBudget.byteArraySize(dataSize);
    }

    private long calculateOverhead(final long btreeSize, final long overhead) {
        final long cacheSize;
        if (overhead == 0) {
            cacheSize = (100 * btreeSize) / 90;
        } else {
            cacheSize = btreeSize + overhead;
        }
        return cacheSize;
    }

    private String line(final long btreeSize,
                        final long cacheSize,
                        final String comment) {

        final StringBuffer buf = new StringBuffer(100);

        column(buf, INT_FORMAT.format(cacheSize));
        buf.append(COLUMN_SEPARATOR);
        column(buf, INT_FORMAT.format(btreeSize));
        buf.append(COLUMN_SEPARATOR);
        column(buf, comment);

        return buf.toString();
    }

    private void column(final StringBuffer buf, final String str) {

        int start = buf.length();

        while (buf.length() - start + str.length() < COLUMN_WIDTH) {
            buf.append(' ');
        }

        buf.append(str);
    }

    private void measure(final PrintStream out,
                         final File dir,
                         final boolean randomKeys)
        throws Exception {

        final String[] fileNames = dir.list();
        if (fileNames != null && fileNames.length > 0) {
            usage("Directory is not empty: " + dir);
        }

        Environment env = openEnvironment(dir, true);
        Database db = openDatabase(env, nodeMax, true);

        try {
            out.println("\nMeasuring with cache size: " +
                        INT_FORMAT.format(env.getConfig().getCacheSize()));
            insertRecords(out, env, db, randomKeys);
            printStats(out, env, "Stats after insert");

            db.close();
            db = null;
            env.close();
            env = null;

            env = openEnvironment(dir, false);
            db = openDatabase(env, nodeMax, false);

            out.println("\nPreloading with cache size: " +
                        INT_FORMAT.format(env.getConfig().getCacheSize()));
            PreloadStatus status = preloadRecords(out, db, false /*loadLNs*/);
            printStats(out, env,
                       "Stats for internal nodes only after preload (" +
                       status + ")");
            if (dataSize >= 0) {
                status = preloadRecords(out, db, true /*loadLNs*/);
                printStats(out, env, "Stats for all nodes after preload (" +
                           status + ")");
            }
        } finally {
            try {
                if (db != null) {
                    db.close();
                }
                if (env != null) {
                    env.close();
                }
            } catch (Exception e) {
                out.println("During close: " + e);
            }
        }
    }

    private static Environment openEnvironment(final File dir,
                                               final boolean allowCreate)
        throws Exception {

        final EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setAllowCreate(allowCreate);
        envConfig.setCachePercent(90);
        /* Cleaner and checkpointer interfere with cache size measurements. */
        envConfig.setConfigParam(EnvironmentConfig.ENV_RUN_CLEANER, "false");
        envConfig.setConfigParam(EnvironmentConfig.ENV_RUN_CHECKPOINTER,
                                 "false");
        return new Environment(dir, envConfig);
    }

    private static Database openDatabase(final Environment env,
                                         final int nodeMax,
                                         final boolean allowCreate)
        throws Exception {

        final DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setAllowCreate(allowCreate);
        dbConfig.setNodeMaxEntries(nodeMax);
        return env.openDatabase(null, "foo", dbConfig);
    }

    private void insertRecords(final PrintStream out,
                               final Environment env,
                               final Database db,
                               final boolean randomKeys)
        throws Exception {

        final DatabaseEntry key = new DatabaseEntry();
        final DatabaseEntry data =
            new DatabaseEntry(new byte[Math.max(0, dataSize)]);
        BigInteger bigInt = BigInteger.ZERO;
        final Random rnd = new Random(123);

        final Cursor cursor = db.openCursor(null, null);
        try {
            for (int i = 0; i < records; i += 1) {

                if (randomKeys) {
                    final byte[] a = new byte[keySize];
                    rnd.nextBytes(a);
                    key.setData(a);
                } else {
                    bigInt = bigInt.add(BigInteger.ONE);
                    byte[] a = bigInt.toByteArray();
                    if (a.length < keySize) {
                        final byte[] a2 = new byte[keySize];
                        System.arraycopy(a, 0, a2, a2.length - a.length,
                                         a.length);
                        a = a2;
                    } else if (a.length > keySize) {
                        out.println("*** Key doesn't fit value=" + bigInt +
                                    " byte length=" + a.length);
                        return;
                    }
                    key.setData(a);
                }

                final OperationStatus status =
                    cursor.putNoOverwrite(key, data);
                if (status == OperationStatus.KEYEXIST && randomKeys) {
                    i -= 1;
                    out.println("Random key already exists -- retrying");
                    continue;
                }
                if (status != OperationStatus.SUCCESS) {
                    out.println("*** " + status);
                    return;
                }

                /* If no data size specified, evict the LN. */
                if (dataSize < 0) {
                    DbInternal.getCursorImpl(cursor).evict();
                }

                if (i % 10000 == 0) {
                    final EnvironmentStats stats = env.getStats(null);
                    if (stats.getNNodesScanned() > 0) {
                        out.println("*** Ran out of cache memory at record " +
                                    i +
                                    " -- try increasing Java heap size ***");
                        return;
                    }
                    out.print(".");
                    out.flush();
                }
            }
        } finally {
            cursor.close();
        }

        /* Checkpoint to reset the memory budget. */
        env.checkpoint(new CheckpointConfig().setForce(true));
    }

    private static PreloadStatus preloadRecords(final PrintStream out,
                                                final Database db,
                                                final boolean loadLNs)
        throws Exception {

        final Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        out.print(".");
                        out.flush();
                        Thread.sleep(5 * 1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        };
        thread.start();
        final PreloadStats stats =
            db.preload(new PreloadConfig().setLoadLNs(loadLNs));
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace(out);
        }

        /* Checkpoint to reset the memory budget. */
        db.getEnvironment().checkpoint(new CheckpointConfig().setForce(true));

        return stats.getStatus();
    }

    private static void printStats(final PrintStream out,
                                   final Environment env,
                                   final String msg)
        throws Exception {

        out.println();
        out.println(msg + ':');

        final EnvironmentStats stats = env.getStats(null);
        final long btreeSize = DbInternal.getEnvironmentImpl(env).
            getMemoryBudget().getTreeMemoryUsage();

        out.println("CacheSize=" +
                    INT_FORMAT.format(stats.getCacheTotalBytes()) +
                    " BtreeSize=" + INT_FORMAT.format(btreeSize)  +
                    " NCacheMiss=" + INT_FORMAT.format(stats.getNCacheMiss()));

        if (stats.getNNodesScanned() > 0) {
            out.println("*** All records did not fit in the cache ***");
        }
    }
}
