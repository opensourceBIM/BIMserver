/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.config;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import com.sleepycat.je.Durability;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 */
public class EnvironmentParams {

    /*
     * The map of supported environment parameters where the key is parameter
     * name and the data is the configuration parameter object. Put first,
     * before any declarations of ConfigParams.
     */
    public final static Map<String,ConfigParam> SUPPORTED_PARAMS =
        new HashMap<String,ConfigParam>();

    /*
     * Only environment parameters that are part of the public API are
     * represented by String constants in EnvironmentConfig.
     */
    public static final LongConfigParam MAX_MEMORY =
        new LongConfigParam(EnvironmentConfig.MAX_MEMORY,
                            null,           // min
                            null,           // max
                            Long.valueOf(0),// default uses je.maxMemoryPercent
                            true,           // mutable
                            false);         // forReplication

    public static final IntConfigParam MAX_MEMORY_PERCENT =
        new IntConfigParam(EnvironmentConfig.MAX_MEMORY_PERCENT,
                           Integer.valueOf(1),  // min
                           Integer.valueOf(90), // max
                           Integer.valueOf(60), // default
                           true,                // mutable
                           false);              // forReplication

    public static final BooleanConfigParam ENV_SHARED_CACHE =
        new BooleanConfigParam(EnvironmentConfig.SHARED_CACHE,
                               false,         // default
                               false,         // mutable
                               false);        // forReplication

    /**
     * Used by utilities, not exposed in the API.
     *
     * If true, an environment is created with recovery and the related daemon
     * threads are enabled.
     */
    public static final BooleanConfigParam ENV_RECOVERY =
        new BooleanConfigParam("je.env.recovery",
                               true,          // default
                               false,         // mutable
                               false);        // forReplication

    public static final BooleanConfigParam ENV_RECOVERY_FORCE_CHECKPOINT =
        new BooleanConfigParam(EnvironmentConfig.ENV_RECOVERY_FORCE_CHECKPOINT,
                               false,         // default
                               false,         // mutable
                               false);        // forReplication

    public static final BooleanConfigParam ENV_RUN_INCOMPRESSOR =
        new BooleanConfigParam(EnvironmentConfig.ENV_RUN_IN_COMPRESSOR,
                               true,          // default
                               true,          // mutable
                               false);        // forReplication

    /**
     * If true, eviction is also done by a pool of evictor threads, as well as
     * being done inline by application threads. If false, the evictor pool
     * is not used, regardless of the values of je.evictor.coreThreads and
     * je.evictor.maxThreads.
     */
    public static final BooleanConfigParam ENV_RUN_EVICTOR =
        new BooleanConfigParam(EnvironmentConfig.ENV_RUN_EVICTOR,
                               true,         // default
                               true,         // mutable
                               false);       // forReplication

    /**
     * @deprecated as of JE 4.1
     */
    public static final DurationConfigParam EVICTOR_WAKEUP_INTERVAL =
        new DurationConfigParam("je.evictor.wakeupInterval",
                                "1 s",                 // min
                                "75 min",              // max
                                "5 s",                 // default
                                false,                 // mutable
                                false);

    public static final IntConfigParam EVICTOR_CORE_THREADS =
        new IntConfigParam(EnvironmentConfig.EVICTOR_CORE_THREADS,
                            Integer.valueOf(0),             // min
                            Integer.valueOf(Integer.MAX_VALUE), // max
                            Integer.valueOf(1),             // default
                            true,                           // mutable
                            false);                         // forReplication

    public static final IntConfigParam EVICTOR_MAX_THREADS =
        new IntConfigParam(EnvironmentConfig.EVICTOR_MAX_THREADS,
                            Integer.valueOf(1),             // min
                            Integer.valueOf(Integer.MAX_VALUE), // max
                            Integer.valueOf(10),             // default
                            true,                           // mutable
                            false);                         // forReplication

    public static final DurationConfigParam EVICTOR_KEEP_ALIVE =
        new DurationConfigParam(EnvironmentConfig.EVICTOR_KEEP_ALIVE,
                                "1 s",          // min
                                "24 h",         // max
                                "10 min",       // default
                                true,           // mutable
                                false);         // forReplication

    /**
     * The amount of time to wait for the eviction pool to terminate, in order
     * to create a clean shutdown. An intentionally unadvertised parameter, of
     * use mainly for unit test cleanup.
     */
    public static final DurationConfigParam EVICTOR_TERMINATE_TIMEOUT =
        new DurationConfigParam("je.env.terminateTimeout",
                                "1 ms",         // min
                                "60 s",         // max
                                "10 s",         // default
                                true,           // mutable
                                false);         // forReplication

    public static final BooleanConfigParam ENV_RUN_CHECKPOINTER =
        new BooleanConfigParam(EnvironmentConfig.ENV_RUN_CHECKPOINTER,
                               true,        // default
                               true,        // mutable
                               false);      // forReplication

    public static final BooleanConfigParam ENV_RUN_CLEANER =
        new BooleanConfigParam(EnvironmentConfig.ENV_RUN_CLEANER,
                               true,        // default
                               true,        // mutable
                               false);      // forReplication

    public static final IntConfigParam ENV_BACKGROUND_READ_LIMIT =
        new IntConfigParam(EnvironmentConfig.ENV_BACKGROUND_READ_LIMIT,
                            Integer.valueOf(0),                 // min
                            Integer.valueOf(Integer.MAX_VALUE), // max
                            Integer.valueOf(0),                 // default
                            true,                           // mutable
                            false);                         // forReplication

    public static final IntConfigParam ENV_BACKGROUND_WRITE_LIMIT =
        new IntConfigParam(EnvironmentConfig.ENV_BACKGROUND_WRITE_LIMIT,
                            Integer.valueOf(0),                 // min
                            Integer.valueOf(Integer.MAX_VALUE), // max
                            Integer.valueOf(0),                 // default
                            true,                           // mutable
                            false);                         // forReplication

    public static final DurationConfigParam ENV_BACKGROUND_SLEEP_INTERVAL =
        new DurationConfigParam
            (EnvironmentConfig.ENV_BACKGROUND_SLEEP_INTERVAL,
                               "1 ms",          // min
                               null,            // max
                               "1 ms",          // default
                               true,            // mutable
                               false);          // forReplication

    public static final BooleanConfigParam ENV_CHECK_LEAKS =
        new BooleanConfigParam(EnvironmentConfig.ENV_CHECK_LEAKS,
                               true,              // default
                               false,             // mutable
                               false);            // forReplication

    public static final BooleanConfigParam ENV_FORCED_YIELD =
        new BooleanConfigParam(EnvironmentConfig.ENV_FORCED_YIELD,
                               false,             // default
                               false,             // mutable
                               false);            // forReplication

    public static final BooleanConfigParam ENV_INIT_TXN =
        new BooleanConfigParam(EnvironmentConfig.ENV_IS_TRANSACTIONAL,
                               false,             // default
                               false,             // mutable
                               false);            // forReplication

    public static final BooleanConfigParam ENV_INIT_LOCKING =
        new BooleanConfigParam(EnvironmentConfig.ENV_IS_LOCKING,
                               true,              // default
                               false,             // mutable
                               false);            // forReplication

    public static final BooleanConfigParam ENV_RDONLY =
        new BooleanConfigParam(EnvironmentConfig.ENV_READ_ONLY,
                               false,             // default
                               false,             // mutable
                               false);            // forReplication

    public static final BooleanConfigParam ENV_FAIR_LATCHES =
        new BooleanConfigParam(EnvironmentConfig.ENV_FAIR_LATCHES,
                               false,             // default
                               false,             // mutable
                               false);            // forReplication

    /**
     * Not part of the public API. As of 3.3, is true by default.
     *
     * If true (the default), use shared latches for Btree Internal Nodes (INs)
     * to improve concurrency.
     */
    public static final BooleanConfigParam ENV_SHARED_LATCHES =
        new BooleanConfigParam("je.env.sharedLatches",
                               true,             // default
                               false,            // mutable
                               false);           // forReplication

    public static final BooleanConfigParam ENV_DB_EVICTION =
        new BooleanConfigParam(EnvironmentConfig.ENV_DB_EVICTION,
                               true,             // default
                               false,            // mutable
                               false);           // forReplication

    public static final IntConfigParam ADLER32_CHUNK_SIZE =
        new IntConfigParam(EnvironmentConfig.ADLER32_CHUNK_SIZE,
                           Integer.valueOf(0),       // min
                           Integer.valueOf(1 << 20), // max
                           Integer.valueOf(0),       // default
                           true,                 // mutable
                           false);               // forReplication

    /*
     * Database Logs
     */
    /* default: 2k * NUM_LOG_BUFFERS */
    public static final int MIN_LOG_BUFFER_SIZE = 2048;
    public static final int NUM_LOG_BUFFERS_DEFAULT = 3;
    public static final long LOG_MEM_SIZE_MIN =
        NUM_LOG_BUFFERS_DEFAULT * MIN_LOG_BUFFER_SIZE;
    public static final String LOG_MEM_SIZE_MIN_STRING =
        Long.toString(LOG_MEM_SIZE_MIN);

    public static final LongConfigParam LOG_MEM_SIZE =
        new LongConfigParam(EnvironmentConfig.LOG_TOTAL_BUFFER_BYTES,
                            Long.valueOf(LOG_MEM_SIZE_MIN),// min
                            null,              // max
                            Long.valueOf(0),       // by default computed
                                               // from je.maxMemory
                            false,             // mutable
                            false);            // forReplication

    public static final IntConfigParam NUM_LOG_BUFFERS =
        new IntConfigParam(EnvironmentConfig.LOG_NUM_BUFFERS,
                           Integer.valueOf(2),     // min
                           null,               // max
                           Integer.valueOf(NUM_LOG_BUFFERS_DEFAULT), // default
                           false,              // mutable
                           false);             // forReplication

    public static final IntConfigParam LOG_BUFFER_MAX_SIZE =
        new IntConfigParam(EnvironmentConfig.LOG_BUFFER_SIZE,
                           Integer.valueOf(1<<10),  // min
                           null,                // max
                           Integer.valueOf(1<<20),  // default
                           false,               // mutable
                           false);              // forReplication

    public static final IntConfigParam LOG_FAULT_READ_SIZE =
        new IntConfigParam(EnvironmentConfig.LOG_FAULT_READ_SIZE,
                           Integer.valueOf(32),   // min
                           null,              // max
                           Integer.valueOf(2048), // default
                           false,             // mutable
                           false);            // forReplication

    public static final IntConfigParam LOG_ITERATOR_READ_SIZE =
        new IntConfigParam(EnvironmentConfig.LOG_ITERATOR_READ_SIZE,
                           Integer.valueOf(128),  // min
                           null,              // max
                           Integer.valueOf(8192), // default
                           false,             // mutable
                           false);            // forReplication

    public static final IntConfigParam LOG_ITERATOR_MAX_SIZE =
        new IntConfigParam(EnvironmentConfig.LOG_ITERATOR_MAX_SIZE,
                           Integer.valueOf(128),  // min
                           null,              // max
                           Integer.valueOf(16777216), // default
                           false,             // mutable
                           false);            // forReplication

    public static final LongConfigParam LOG_FILE_MAX =
        (EnvironmentImpl.IS_DALVIK ?
        new LongConfigParam(EnvironmentConfig.LOG_FILE_MAX,
                            Long.valueOf(10000),       // min
                            Long.valueOf(10000000),    // max
                            Long.valueOf(100000),      // default
                            false,                 // mutable
                            false) :               // forReplication
        new LongConfigParam(EnvironmentConfig.LOG_FILE_MAX,
                            Long.valueOf(1000000),      // min
                            Long.valueOf(1073741824L), // max
                            Long.valueOf(10000000),    // default
                            false,                 // mutable
                            false));               // forReplication

    public static final BooleanConfigParam LOG_CHECKSUM_READ =
        new BooleanConfigParam(EnvironmentConfig.LOG_CHECKSUM_READ,
                               true,               // default
                               false,              // mutable
                               false);             // forReplication

    public static final BooleanConfigParam LOG_VERIFY_CHECKSUMS =
        new BooleanConfigParam(EnvironmentConfig.LOG_VERIFY_CHECKSUMS,
                               false,              // default
                               false,              // mutable
                               false);             // forReplication

    public static final BooleanConfigParam LOG_MEMORY_ONLY =
        new BooleanConfigParam(EnvironmentConfig.LOG_MEM_ONLY,
                               false,              // default
                               false,              // mutable
                               false);             // forReplication

    public static final IntConfigParam LOG_FILE_CACHE_SIZE =
        new IntConfigParam(EnvironmentConfig.LOG_FILE_CACHE_SIZE,
                           Integer.valueOf(3),    // min
                           null,                  // max
                           Integer.valueOf(100),  // default
                           false,                 // mutable
                           false);                // forReplication

    public static final DurationConfigParam LOG_FSYNC_TIMEOUT =
        new DurationConfigParam(EnvironmentConfig.LOG_FSYNC_TIMEOUT,
                                "10 ms",           // min
                                null,              // max
                                "500 ms",          // default
                                false,             // mutable
                                false);            // forReplication

    public static final BooleanConfigParam LOG_USE_ODSYNC =
        new BooleanConfigParam(EnvironmentConfig.LOG_USE_ODSYNC,
                               false,          // default
                               false,          // mutable
                               false);         // forReplication

    public static final BooleanConfigParam LOG_USE_NIO =
        new BooleanConfigParam(EnvironmentConfig.LOG_USE_NIO,
                               false,          // default
                               false,          // mutable
                               false);         // forReplication

    public static final BooleanConfigParam LOG_USE_WRITE_QUEUE =
        (EnvironmentImpl.IS_DALVIK ?
        new BooleanConfigParam(EnvironmentConfig.LOG_USE_WRITE_QUEUE,
                               false,          // default
                               false,          // mutable
                               false) :        // forReplication
        new BooleanConfigParam(EnvironmentConfig.LOG_USE_WRITE_QUEUE,
                               true,           // default
                               false,          // mutable
                               false));        // forReplication

    public static final IntConfigParam LOG_WRITE_QUEUE_SIZE =
        new IntConfigParam(EnvironmentConfig.LOG_WRITE_QUEUE_SIZE,
                           Integer.valueOf(1 << 12),    // min (4KB)
                           Integer.valueOf(1 << 28),    // max (32MB)
                           Integer.valueOf(1 << 20),    // default (1MB)
                           false,             // mutable
                           false);            // forReplication

    public static final BooleanConfigParam LOG_DIRECT_NIO =
        new BooleanConfigParam(EnvironmentConfig.LOG_DIRECT_NIO,
                               false,          // default
                               false,          // mutable
                               false);         // forReplication

    public static final LongConfigParam LOG_CHUNKED_NIO =
        new LongConfigParam(EnvironmentConfig.LOG_CHUNKED_NIO,
                            Long.valueOf(0L),      // min
                            Long.valueOf(1 << 26), // max (64M)
                            Long.valueOf(0L),      // default (no chunks)
                            false,             // mutable
                            false);            // forReplication

    /**
     * @deprecated As of 3.3, no longer used
     *
     * Optimize cleaner operation for temporary deferred write DBs.
     */
    public static final BooleanConfigParam LOG_DEFERREDWRITE_TEMP =
        new BooleanConfigParam("je.deferredWrite.temp",
                               false,          // default
                               false,          // mutable
                               false);         // forReplication

    /*
     * Tree
     */
    public static final IntConfigParam NODE_MAX =
        new IntConfigParam(EnvironmentConfig.NODE_MAX_ENTRIES,
                           Integer.valueOf(4),     // min
                           Integer.valueOf(32767), // max
                           Integer.valueOf(128),   // default
                           false,              // mutable
                           false);             // forReplication

    public static final IntConfigParam NODE_MAX_DUPTREE =
        new IntConfigParam(EnvironmentConfig.NODE_DUP_TREE_MAX_ENTRIES,
                           Integer.valueOf(4),     // min
                           Integer.valueOf(32767), // max
                           Integer.valueOf(128),   // default
                           false,              // mutable
                           false);             // forReplication

    public static final IntConfigParam BIN_MAX_DELTAS =
        new IntConfigParam(EnvironmentConfig.TREE_MAX_DELTA,
                           Integer.valueOf(0),     // min
                           Integer.valueOf(100),   // max
                           Integer.valueOf(10),    // default
                           false,              // mutable
                           false);             // forReplication

    public static final IntConfigParam BIN_DELTA_PERCENT =
        new IntConfigParam(EnvironmentConfig.TREE_BIN_DELTA,
                           Integer.valueOf(0),     // min
                           Integer.valueOf(75),    // max
                           Integer.valueOf(25),    // default
                           false,              // mutable
                           false);             // forReplication

    public static final LongConfigParam MIN_TREE_MEMORY =
        new LongConfigParam(EnvironmentConfig.TREE_MIN_MEMORY,
                            Long.valueOf(50 * 1024),   // min
                            null,                  // max
                            Long.valueOf(500 * 1024),  // default
                            true,                  // mutable
                            false);                // forReplication

    /*
     * IN Compressor
     */
    public static final DurationConfigParam COMPRESSOR_WAKEUP_INTERVAL =
        new DurationConfigParam(EnvironmentConfig.COMPRESSOR_WAKEUP_INTERVAL,
                                "1 s",                 // min
                                "75 min",              // max
                                "5 s",                 // default
                                false,                 // mutable
                                false);                // forReplication

    public static final IntConfigParam COMPRESSOR_RETRY =
        new IntConfigParam(EnvironmentConfig.COMPRESSOR_DEADLOCK_RETRY,
                           Integer.valueOf(0),                // min
                           Integer.valueOf(Integer.MAX_VALUE),// max
                           Integer.valueOf(3),                // default
                           false,                         // mutable
                           false);                        // forReplication

    public static final DurationConfigParam COMPRESSOR_LOCK_TIMEOUT =
        new DurationConfigParam(EnvironmentConfig.COMPRESSOR_LOCK_TIMEOUT,
                                null,                  // min
                                "75 min",              // max
                                "500 ms",              // default
                                false,                 // mutable
                                false);                // forReplication

    /*
     * Evictor
     */
    public static final LongConfigParam EVICTOR_EVICT_BYTES =
        new LongConfigParam(EnvironmentConfig.EVICTOR_EVICT_BYTES,
                             Long.valueOf(1024),       // min
                             null,                 // max
                             Long.valueOf(524288),     // default
                             false,                // mutable
                             false);               // forReplication

    /**
     * @deprecated As of 2.0, this is replaced by je.evictor.evictBytes
     *
     * When eviction happens, the evictor will push memory usage to this
     * percentage of je.maxMemory.
     */
    public static final IntConfigParam EVICTOR_USEMEM_FLOOR =
        new IntConfigParam("je.evictor.useMemoryFloor",
                           Integer.valueOf(50),        // min
                           Integer.valueOf(100),       // max
                           Integer.valueOf(95),        // default
                           false,                  // mutable
                           false);                 // forReplication

    /**
     * @deprecated As of 1.7.2, this is replaced by je.evictor.nodesPerScan
     *
     * The evictor percentage of total nodes to scan per wakeup.
     */
    public static final IntConfigParam EVICTOR_NODE_SCAN_PERCENTAGE =
        new IntConfigParam("je.evictor.nodeScanPercentage",
                           Integer.valueOf(1),          // min
                           Integer.valueOf(100),        // max
                           Integer.valueOf(10),         // default
                           false,                   // mutable
                           false);                  // forReplication

    /**
     * @deprecated As of 1.7.2, 1 node is chosen per scan.
     *
     * The evictor percentage of scanned nodes to evict per wakeup.
     */
    public static final
        IntConfigParam EVICTOR_EVICTION_BATCH_PERCENTAGE =
        new IntConfigParam("je.evictor.evictionBatchPercentage",
                           Integer.valueOf(1),          // min
                           Integer.valueOf(100),        // max
                           Integer.valueOf(10),         // default
                           false,                   // mutable
                           false);                  // forReplication

    public static final IntConfigParam EVICTOR_NODES_PER_SCAN =
        new IntConfigParam(EnvironmentConfig.EVICTOR_NODES_PER_SCAN,
                           Integer.valueOf(1),           // min
                           Integer.valueOf(1000),        // max
                           Integer.valueOf(10),          // default
                           false,                    // mutable
                           false);                   // forReplication

    /**
     * Not part of public API. As of 2.0, eviction is performed in-line.
     *
     * At this percentage over the allotted cache, critical eviction will
     * start.
     */
    public static final IntConfigParam EVICTOR_CRITICAL_PERCENTAGE =
        new IntConfigParam("je.evictor.criticalPercentage",
                           Integer.valueOf(0),           // min
                           Integer.valueOf(1000),        // max
                           Integer.valueOf(0),           // default
                           false,                    // mutable
                           false);                   // forReplication

    /**
     * @deprecated as of JE 4.1
     */
    public static final IntConfigParam EVICTOR_RETRY =
        new IntConfigParam(EnvironmentConfig.EVICTOR_DEADLOCK_RETRY,
                           Integer.valueOf(0),                // min
                           Integer.valueOf(Integer.MAX_VALUE),// max
                           Integer.valueOf(3),                // default
                           false,                         // mutable
                           false);                        // forReplication

    public static final BooleanConfigParam EVICTOR_LRU_ONLY =
        new BooleanConfigParam(EnvironmentConfig.EVICTOR_LRU_ONLY,
                               true,                  // default
                               false,                 // mutable
                               false);                // forReplication

    public static final BooleanConfigParam EVICTOR_FORCED_YIELD =
        new BooleanConfigParam(EnvironmentConfig.EVICTOR_FORCED_YIELD,
                               false,             // default
                               false,             // mutable
                               false);            // forReplication

    /*
     * Checkpointer
     */
    public static final LongConfigParam CHECKPOINTER_BYTES_INTERVAL =
        new LongConfigParam(EnvironmentConfig.CHECKPOINTER_BYTES_INTERVAL,
                            Long.valueOf(0),               // min
                            Long.valueOf(Long.MAX_VALUE),  // max
                            (EnvironmentImpl.IS_DALVIK ?
                             Long.valueOf(200000) :
                             Long.valueOf(20000000)),      // default
                            false,                     // mutable
                            false);                    // forReplication

    public static final DurationConfigParam CHECKPOINTER_WAKEUP_INTERVAL =
        new DurationConfigParam(EnvironmentConfig.CHECKPOINTER_WAKEUP_INTERVAL,
                                "1 s",                 // min
                                "75 min",              // max
                                "0",                   // default
                                false,                 // mutable
                                false);                // forReplication

    public static final IntConfigParam CHECKPOINTER_RETRY =
        new IntConfigParam(EnvironmentConfig.CHECKPOINTER_DEADLOCK_RETRY,
                           Integer.valueOf(0),                 // min
                           Integer.valueOf(Integer.MAX_VALUE), // max
                           Integer.valueOf(3),                 // default
                           false,                          // mutable
                           false);                         // forReplication

    public static final BooleanConfigParam CHECKPOINTER_HIGH_PRIORITY =
        new BooleanConfigParam(EnvironmentConfig.CHECKPOINTER_HIGH_PRIORITY,
                               false, // default
                               true,  // mutable
                               false);// forReplication

    /*
     * Cleaner
     */
    public static final IntConfigParam CLEANER_MIN_UTILIZATION =
        new IntConfigParam(EnvironmentConfig.CLEANER_MIN_UTILIZATION,
                           Integer.valueOf(0),           // min
                           Integer.valueOf(90),          // max
                           Integer.valueOf(50),          // default
                           true,                     // mutable
                           false);                   // forReplication

    public static final IntConfigParam CLEANER_MIN_FILE_UTILIZATION =
        new IntConfigParam(EnvironmentConfig.CLEANER_MIN_FILE_UTILIZATION,
                           Integer.valueOf(0),           // min
                           Integer.valueOf(50),          // max
                           Integer.valueOf(5),           // default
                           true,                     // mutable
                           false);                   // forReplication

    public static final LongConfigParam CLEANER_BYTES_INTERVAL =
        new LongConfigParam(EnvironmentConfig.CLEANER_BYTES_INTERVAL,
                            Long.valueOf(0),              // min
                            Long.valueOf(Long.MAX_VALUE), // max
                            Long.valueOf(0),              // default
                            true,                     // mutable
                            false);                   // forReplication

    public static final BooleanConfigParam CLEANER_FETCH_OBSOLETE_SIZE =
        new BooleanConfigParam(EnvironmentConfig.CLEANER_FETCH_OBSOLETE_SIZE,
                               false, // default
                               true,  // mutable
                               false);// forReplication

    public static final IntConfigParam CLEANER_DEADLOCK_RETRY =
        new IntConfigParam(EnvironmentConfig.CLEANER_DEADLOCK_RETRY,
                           Integer.valueOf(0),                // min
                           Integer.valueOf(Integer.MAX_VALUE),// max
                           Integer.valueOf(3),                // default
                           true,                          // mutable
                           false);                        // forReplication

    public static final DurationConfigParam CLEANER_LOCK_TIMEOUT =
        new DurationConfigParam(EnvironmentConfig.CLEANER_LOCK_TIMEOUT,
                                "0",                // min
                                "75 min",           // max
                                "500 ms",           // default
                                true,               // mutable
                                false);             // forReplication

    public static final BooleanConfigParam CLEANER_REMOVE =
        new BooleanConfigParam(EnvironmentConfig.CLEANER_EXPUNGE,
                               true,                 // default
                               true,                 // mutable
                               false);               // forReplication

    /**
     * @deprecated As of 1.7.1, no longer used.
     */
    public static final IntConfigParam CLEANER_MIN_FILES_TO_DELETE =
        new IntConfigParam("je.cleaner.minFilesToDelete",
                           Integer.valueOf(1),           // min
                           Integer.valueOf(1000000),     // max
                           Integer.valueOf(5),           // default
                           false,                    // mutable
                           false);        // forReplication

    /**
     * @deprecated As of 2.0, no longer used.
     */
    public static final IntConfigParam CLEANER_RETRIES =
        new IntConfigParam("je.cleaner.retries",
                           Integer.valueOf(0),           // min
                           Integer.valueOf(1000),        // max
                           Integer.valueOf(10),          // default
                           false,                    // mutable
                           false);        // forReplication

    /**
     * @deprecated As of 2.0, no longer used.
     */
    public static final IntConfigParam CLEANER_RESTART_RETRIES =
        new IntConfigParam("je.cleaner.restartRetries",
                           Integer.valueOf(0),           // min
                           Integer.valueOf(1000),        // max
                           Integer.valueOf(5),           // default
                           false,                    // mutable
                           false);        // forReplication

    public static final IntConfigParam CLEANER_MIN_AGE =
        new IntConfigParam(EnvironmentConfig.CLEANER_MIN_AGE,
                           Integer.valueOf(1),           // min
                           Integer.valueOf(1000),        // max
                           Integer.valueOf(2),           // default
                           true,                     // mutable
                           false);                   // forReplication

    /**
     * Experimental and may be removed in a future release -- not exposed in
     * the public API.
     *
     * If true, eviction and checkpointing will cluster records by key
     * value, migrating them from low utilization files if they are
     * resident.
     * The cluster and clusterAll properties may not both be set to true.
     */
    public static final BooleanConfigParam CLEANER_CLUSTER =
        new BooleanConfigParam("je.cleaner.cluster",
                               false,               // default
                               true,                // mutable
                               false);              // forReplication

    /**
     * Experimental and may be removed in a future release -- not exposed in
     * the public API.
     *
     * If true, eviction and checkpointing will cluster records by key
     * value, migrating them from low utilization files whether or not
     * they are resident.
     * The cluster and clusterAll properties may not both be set to true.
     */
    public static final BooleanConfigParam CLEANER_CLUSTER_ALL =
        new BooleanConfigParam("je.cleaner.clusterAll",
                               false,              // default
                               true,               // mutable
                               false);             // forReplication

    public static final IntConfigParam CLEANER_MAX_BATCH_FILES =
        new IntConfigParam(EnvironmentConfig.CLEANER_MAX_BATCH_FILES,
                           Integer.valueOf(0),         // min
                           Integer.valueOf(100000),    // max
                           Integer.valueOf(0),         // default
                           true,                   // mutable
                           false);                 // forReplication

    public static final IntConfigParam CLEANER_READ_SIZE =
        new IntConfigParam(EnvironmentConfig.CLEANER_READ_SIZE,
                           Integer.valueOf(128),  // min
                           null,              // max
                           Integer.valueOf(0),    // default
                           true,              // mutable
                           false);            // forReplication

    /**
     * Not part of public API.
     *
     * If true, the cleaner tracks and stores detailed information that is used
     * to decrease the cost of cleaning.
     */
    public static final BooleanConfigParam CLEANER_TRACK_DETAIL =
        new BooleanConfigParam("je.cleaner.trackDetail",
                               true,          // default
                               false,         // mutable
                               false);        // forReplication

    public static final IntConfigParam CLEANER_DETAIL_MAX_MEMORY_PERCENTAGE =
    new IntConfigParam(EnvironmentConfig.CLEANER_DETAIL_MAX_MEMORY_PERCENTAGE,
                           Integer.valueOf(1),    // min
                           Integer.valueOf(90),   // max
                           Integer.valueOf(2),    // default
                           true,              // mutable
                           false);            // forReplication

    /**
     * Not part of public API, since it applies to a very old bug.
     *
     * If true, detail information is discarded that was added by earlier
     * versions of JE (specifically 2.0.42 and 2.0.54) if it may be invalid.
     * This may be set to false for increased performance when those version of
     * JE were used but LockMode.RMW was never used.
     */
    public static final BooleanConfigParam CLEANER_RMW_FIX =
        new BooleanConfigParam("je.cleaner.rmwFix",
                               true,          // default
                               false,         // mutable
                               false);        // forReplication

    public static final ConfigParam CLEANER_FORCE_CLEAN_FILES =
        new ConfigParam(EnvironmentConfig.CLEANER_FORCE_CLEAN_FILES,
                        "",                  // default
                        false,               // mutable
                        false);              // forReplication

    public static final IntConfigParam CLEANER_UPGRADE_TO_LOG_VERSION =
        new IntConfigParam(EnvironmentConfig.CLEANER_UPGRADE_TO_LOG_VERSION,
                           Integer.valueOf(-1),  // min
                           null,             // max
                           Integer.valueOf(0),   // default
                           false,            // mutable
                           false);           // forReplication

    public static final IntConfigParam CLEANER_THREADS =
        new IntConfigParam(EnvironmentConfig.CLEANER_THREADS,
                           Integer.valueOf(1),   // min
                           null,             // max
                           Integer.valueOf(1),   // default
                           true,             // mutable
                           false);           // forReplication

    public static final IntConfigParam CLEANER_LOOK_AHEAD_CACHE_SIZE =
        new IntConfigParam(EnvironmentConfig.CLEANER_LOOK_AHEAD_CACHE_SIZE,
                           Integer.valueOf(0),    // min
                           null,              // max
                           Integer.valueOf(8192), // default
                           true,              // mutable
                           false);            // forReplication

    public static final BooleanConfigParam
        CLEANER_FOREGROUND_PROACTIVE_MIGRATION = new BooleanConfigParam
            (EnvironmentConfig.CLEANER_FOREGROUND_PROACTIVE_MIGRATION,
                           false,                // default
                           true,                 // mutable
                           false);               // forReplication

    public static final BooleanConfigParam
        CLEANER_BACKGROUND_PROACTIVE_MIGRATION = new BooleanConfigParam
            (EnvironmentConfig.CLEANER_BACKGROUND_PROACTIVE_MIGRATION,
                           false,                // default
                           true,                 // mutable
                           false);               // forReplication

    public static final BooleanConfigParam CLEANER_LAZY_MIGRATION =
        new BooleanConfigParam(EnvironmentConfig.CLEANER_LAZY_MIGRATION,
                           true,              // default
                           true,              // mutable
                           false);            // forReplication

    /*
     * Transactions
     */
    public static final IntConfigParam N_LOCK_TABLES =
        new IntConfigParam(EnvironmentConfig.LOCK_N_LOCK_TABLES,
                           Integer.valueOf(1),    // min
                           Integer.valueOf(32767),// max
                           Integer.valueOf(1),    // default
                           false,             // mutable
                           false);            // forReplication

    public static final DurationConfigParam LOCK_TIMEOUT =
        new DurationConfigParam(EnvironmentConfig.LOCK_TIMEOUT,
                                null,              // min
                                "75 min",          // max
                                "500 ms",          // default
                                false,             // mutable
                                false);            // forReplication

    public static final BooleanConfigParam LOCK_OLD_LOCK_EXCEPTIONS =
        new BooleanConfigParam(EnvironmentConfig.LOCK_OLD_LOCK_EXCEPTIONS,
                               false,              // default
                               false,              // mutable
                               false);             // forReplication

    public static final DurationConfigParam TXN_TIMEOUT =
        new DurationConfigParam(EnvironmentConfig.TXN_TIMEOUT,
                                null,              // min
                                "75 min",          // max
                                "0",               // default
                                false,             // mutable
                                false);            // forReplication

    public static final BooleanConfigParam TXN_SERIALIZABLE_ISOLATION =
        new BooleanConfigParam(EnvironmentConfig.TXN_SERIALIZABLE_ISOLATION,
                               false,              // default
                               false,              // mutable
                               false);             // forReplication

    public static final BooleanConfigParam TXN_DEADLOCK_STACK_TRACE =
        new BooleanConfigParam(EnvironmentConfig.TXN_DEADLOCK_STACK_TRACE,
                               false,              // default
                               true,               // mutable
                               false);             // forReplication

    public static final BooleanConfigParam TXN_DUMPLOCKS =
        new BooleanConfigParam(EnvironmentConfig.TXN_DUMP_LOCKS,
                               false,              // default
                               true,               // mutable
                               false);             // forReplication

    /*
     * If true, exceptions and critical cleaner and recovery event tracing
     * is written into the .jdb files.
     */
    public static final BooleanConfigParam JE_LOGGING_DBLOG =
        new BooleanConfigParam("je.env.logTrace",
                               true,               // default
                               false,              // mutable
                               false);             // forReplication

    /*
     * The level for JE ConsoleHandler.
     */
    public static final ConfigParam JE_CONSOLE_LEVEL =
        new ConfigParam(EnvironmentConfig.CONSOLE_LOGGING_LEVEL,
                        "OFF",                     // default
                        true,                      // mutable
                        false) {                   // for Replication

            @Override
            public void validateValue(String level)
                throws NullPointerException, IllegalArgumentException {

                /* Parse the level. */
                Level.parse(level);
            }
    };

    /*
     * The level for JE FileHandler.
     */
    public static final ConfigParam JE_FILE_LEVEL =
        new ConfigParam(EnvironmentConfig.FILE_LOGGING_LEVEL,
                        "INFO",                    // default
                        true,                      // mutable
                        false) {                   // for Replication

            @Override
            public void validateValue(String level)
                throws NullPointerException, IllegalArgumentException {

                /* Parse the level. */
                Level.parse(level);
            }
    };

    /*
     * The default below for JE_DURABILITY is currently null to avoid mixed
     * mode durability API exceptions. Once the "sync" API has been removed, we
     * can provide a default like: sync,sync,simple majority that's compatible
     * with the current sync default stand alone behavior and is safe, though
     * not the best performing setup, wrt HA.
     */
    public static final ConfigParam JE_DURABILITY =
        new ConfigParam(EnvironmentConfig.TXN_DURABILITY,
                        null,                  // default
                        true,                  // mutable
                        false) {               // forReplication

        @Override
        public void validateValue(String durabilityString)
            throws IllegalArgumentException {
            // Parse the string to determine whether it's valid
            Durability.parse(durabilityString);
        }
    };

    /*
     * Replication params are in com.sleepycat.je.rep.impl.ReplicatorParams
     */

    /*
     * Add a configuration parameter to the set supported by an environment.
     */
    public static void addSupportedParam(ConfigParam param) {
        SUPPORTED_PARAMS.put(param.getName(), param);
    }
}
