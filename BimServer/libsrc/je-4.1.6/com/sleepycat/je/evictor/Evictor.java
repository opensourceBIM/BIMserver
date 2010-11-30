/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.evictor;

import static com.sleepycat.je.evictor.EvictorStatDefinition.AVG_BATCH_DESC;
import static com.sleepycat.je.evictor.EvictorStatDefinition.BIN_EVICTION_TYPE_DESC;
import static com.sleepycat.je.evictor.EvictorStatDefinition.BIN_FETCH;
import static com.sleepycat.je.evictor.EvictorStatDefinition.BIN_FETCH_MISS;
import static com.sleepycat.je.evictor.EvictorStatDefinition.CACHED_IN_COMPACT_KEY;
import static com.sleepycat.je.evictor.EvictorStatDefinition.CACHED_IN_NO_TARGET;
import static com.sleepycat.je.evictor.EvictorStatDefinition.CACHED_IN_SPARSE_TARGET;
import static com.sleepycat.je.evictor.EvictorStatDefinition.EVICTOR_BINS_STRIPPED;
import static com.sleepycat.je.evictor.EvictorStatDefinition.EVICTOR_EVICT_PASSES;
import static com.sleepycat.je.evictor.EvictorStatDefinition.EVICTOR_NODES_EVICTED;
import static com.sleepycat.je.evictor.EvictorStatDefinition.EVICTOR_NODES_SCANNED;
import static com.sleepycat.je.evictor.EvictorStatDefinition.EVICTOR_ROOT_NODES_EVICTED;
import static com.sleepycat.je.evictor.EvictorStatDefinition.GROUP_DESC;
import static com.sleepycat.je.evictor.EvictorStatDefinition.GROUP_NAME;
import static com.sleepycat.je.evictor.EvictorStatDefinition.LN_FETCH;
import static com.sleepycat.je.evictor.EvictorStatDefinition.LN_FETCH_MISS;
import static com.sleepycat.je.evictor.EvictorStatDefinition.NUM_BATCHES_DESC;
import static com.sleepycat.je.evictor.EvictorStatDefinition.THREAD_UNAVAILABLE;
import static com.sleepycat.je.evictor.EvictorStatDefinition.UPPER_IN_EVICTION_TYPE_DESC;
import static com.sleepycat.je.evictor.EvictorStatDefinition.UPPER_IN_FETCH;
import static com.sleepycat.je.evictor.EvictorStatDefinition.UPPER_IN_FETCH_MISS;

import java.util.EnumSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.cleaner.LocalUtilizationTracker;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvConfigObserver;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.evictor.TargetSelector.ScanInfo;
import com.sleepycat.je.evictor.TargetSelector.SetupInfo;
import com.sleepycat.je.recovery.Checkpointer;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.SearchResult;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.WithRootLatched;
import com.sleepycat.je.utilint.AtomicLongStat;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatDefinition;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.StoppableThreadFactory;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.TestHookExecute;

/**
 * The Evictor is responsible for maintaining the JE cache. Since object sizes
 * are not directly manipulated in a Java application, the cache is actually a
 * collection of in-memory btree nodes, implemented by
 * com.sleepycat.je.dbi.INList. Nodes are selected from the INList for removal,
 * which is done by detaching them from the in-memory tree, and by removing
 * them from the INList. Once all references to them are removed, they can be
 * GC'd by the JVM.
 *
 * There are three main components. 
 *
 * Arbiter: queries the memory budget to decide whether eviction is needed
 * TargetSelector : chooses a target node
 * Evictor: does the work of detaching the node.
 *
 * The TargetSelector and Evictor classes are subclassed to provide
 * private/shared cache implementations. A shared cache is used by multiple
 * environments within a single JVM, and is seen logically as a single INList
 * collection, although it is implemented by an umbrella over multiple INLists.
 *
 * The Evictor owns a thread pool which is available to handle eviction tasks. 
 * Eviction is carried out by three types of threads:
 * 1. The application thread, in the course of doing critical eviction
 * 2. Daemon threads, such as the cleaner or INCompressor, in the course of
 *    doing their respective duties
 * 3. Eviction pool threads
 *
 * We prefer that the eviction pool threads do as much of the eviction as 
 * possible, and that the application threads do as little, because eviction 
 * adds latency to the perceived application response time. To date, it has
 * been impossible to completely remove eviction responsiblities from the 
 * application threads, because the process doesn't have sufficient feedback,
 * and can incur an OutOfMemoryException.
 *
 * The eviction pool is a standard java.util.concurrent thread pool, and can
 * be mutably configured in terms of core threads, max threads, and keepalive
 * times.
 *
 * Since three types of threads can concurrently do eviction, it's important
 * that eviction is both thread safe and as parallel as possible.  Memory
 * thresholds are generally accounted for in an unsynchronized fashion, and are
 * seen as advisory. The only point of true synchronization is around the
 * selection of a node for eviction. The act of eviction itself can be done
 * concurrently.
 *
 * The eviction method is not reentrant, and a simple concurrent hash map
 * of threads is used to prevent recursive calls.
 */
public abstract class Evictor implements EnvConfigObserver {
    
    /*
     * If new eviction source enums are added, a new stat is created, and 
     * EnvironmentStats must be updated to add a getter method.
     * 
     * CRITICAL eviction is called by operations executed app or daemon
     *   threads which detect that the cache has reached its limits
     * CACHE_MODE eviction is called by operations that use a specific
     *   Cursor.
     * EVICTORThread is the eviction pool
     * MANUAL is the call to Environment.evictMemory, called by recovery or
     *   application code.
     */
    public enum EvictionSource {
        /* Using ordinal for array values! */
        EVICTORTHREAD, MANUAL, CRITICAL, CACHEMODE, DAEMON;

        public StatDefinition getBINStatDef() {
            return new StatDefinition("nBINsEvicted" + toString(),
                                      BIN_EVICTION_TYPE_DESC);
        }

        public StatDefinition getUpperINStatDef() {
            return new StatDefinition("nUpperINsEvicted" + toString(),
                                      UPPER_IN_EVICTION_TYPE_DESC);
        }

        public StatDefinition getNumBatchesStatDef() {
            return new StatDefinition("nBatches" + toString(),
                                      NUM_BATCHES_DESC);
        }

        public StatDefinition getAvgBatchStatDef() {
            return new StatDefinition("avgBatch" + toString(),
                                      AVG_BATCH_DESC);
        }
    }

    final EnvironmentImpl envImpl;
    private final TargetSelector selector;
    private final Arbiter arbiter;

    /* The thread pool used to manage the background evictor threads. */
    private final ThreadPoolExecutor evictionPool;
    private int terminateMillis;

    /* 
     * runEvictor is needed as a distinct flag, rather than setting maxThreads
     * to 0, because the ThreadPoolExecutor does not permit  maxThreads to be 0.
     */
    private boolean runEvictor;

    /* Prevent endless eviction loops under extreme resource constraints. */
    private static final int MAX_BATCHES_PER_RUN = 100;

    /*
     * Stats
     */
    private final StatGroup stats;

    /* Number of passes made to the evictor. */
    private final LongStat nEvictPasses;
    /* Number of nodes scanned in order to select the eviction set */
    private final LongStat nNodesScanned;

    /*
     * Number of nodes evicted on this run. This could be understated, as a
     * whole subtree may have gone out with a single node.
     */
    private final LongStat nNodesEvicted;
    /* Number of closed database root nodes evicted on this run. */
    private final LongStat nRootNodesEvicted;
    /* Number of BINs stripped. */
    private final LongStat nBINsStripped;

    /*
     * Tree related cache hit/miss stats. A subset of the cache misses recorded
     * by the log manager, in that these only record tree node hits and misses.
     * Recorded by IN.fetchTarget, but grouped with evictor stats. Use
     * AtomicLongStat for multithreading safety.
     */
    private final AtomicLongStat nLNFetch;
    private final AtomicLongStat nBINFetch;
    private final AtomicLongStat nUpperINFetch;
    private final AtomicLongStat nLNFetchMiss;
    private final AtomicLongStat nBINFetchMiss;
    private final AtomicLongStat nUpperINFetchMiss;

    private final AtomicLongStat nThreadUnavailable;
    
     /* Stats for IN compact array representations currently in cache. */
    private final AtomicLong nINSparseTarget;
    private final AtomicLong nINNoTarget;
    private final AtomicLong nINCompactKey;

    /*
     * Array of stats is indexed into by the EvictionSource ordinal value.
     * A EnumMap could have been an alternative, but would be heavier weight.
     */
    private final AtomicLongStat[] binEvictSources;
    private final AtomicLongStat[] inEvictSources;
    private final LongStat[] batchesPerSource;
    private final LongStat[] avgBatchPerSource;
    private final AtomicLong[] numBatchTargets;
    private final AtomicLong[] numBatches;

    /* Debugging and unit test support. */
    private TestHook<Object> preEvictINHook;
    private TestHook<IN> evictProfile;

    /* Eviction calls cannot be recursive. */
    private final ReentrancyGuard reentrancyGuard;

    /* Flag to help shutdown launched eviction tasks. */
    private final AtomicBoolean shutdownRequested;

    private final Logger logger;

    Evictor(EnvironmentImpl envImpl)
        throws DatabaseException {

        this.envImpl = envImpl;

        /* Do the stats definitions. */
        stats = new StatGroup(GROUP_NAME, GROUP_DESC);
        nEvictPasses = new LongStat(stats, EVICTOR_EVICT_PASSES);
        nNodesScanned = new LongStat(stats, EVICTOR_NODES_SCANNED);
        nNodesEvicted = new LongStat(stats, EVICTOR_NODES_EVICTED);
        nRootNodesEvicted = new LongStat(stats, EVICTOR_ROOT_NODES_EVICTED);
        nBINsStripped = new LongStat(stats, EVICTOR_BINS_STRIPPED);

        nLNFetch = new AtomicLongStat(stats, LN_FETCH);
        nBINFetch = new AtomicLongStat(stats, BIN_FETCH);
        nUpperINFetch = new AtomicLongStat(stats, UPPER_IN_FETCH);
        nLNFetchMiss = new AtomicLongStat(stats, LN_FETCH_MISS);
        nBINFetchMiss = new AtomicLongStat(stats, BIN_FETCH_MISS);
        nUpperINFetchMiss = new AtomicLongStat(stats, UPPER_IN_FETCH_MISS);
        nThreadUnavailable = new AtomicLongStat(stats, THREAD_UNAVAILABLE);

        nINSparseTarget =  new AtomicLong(0);
        nINNoTarget = new AtomicLong(0);
        nINCompactKey = new AtomicLong(0);

        EnumSet<EvictionSource> allSources = 
            EnumSet.allOf(EvictionSource.class);
        int numSources = allSources.size();
            
        binEvictSources = new AtomicLongStat[numSources];
        inEvictSources = new AtomicLongStat[numSources];
        numBatches = new AtomicLong[numSources];    
        numBatchTargets = new AtomicLong[numSources];
        batchesPerSource = new LongStat[numSources];
        avgBatchPerSource = new LongStat[numSources];
            
        for (EvictionSource source : allSources) {
            int index = source.ordinal();
            binEvictSources[index] = 
                new AtomicLongStat(stats, source.getBINStatDef());
            inEvictSources[index] = 
                new AtomicLongStat(stats, source.getUpperINStatDef());
            numBatches[index] = new AtomicLong();
            numBatchTargets[index] = new AtomicLong();
            batchesPerSource[index] = 
                new LongStat(stats, source.getNumBatchesStatDef());
            avgBatchPerSource[index] = 
                new LongStat(stats, source.getAvgBatchStatDef());
        }

        selector = makeSelector();
        arbiter = new Arbiter(envImpl);

        logger = LoggerUtils.getLogger(getClass());
        reentrancyGuard = new ReentrancyGuard(envImpl, logger);
        shutdownRequested = new AtomicBoolean(false);

        DbConfigManager configManager = envImpl.getConfigManager();

        int corePoolSize = 
            configManager.getInt(EnvironmentParams.EVICTOR_CORE_THREADS);
        int maxPoolSize = 
            configManager.getInt(EnvironmentParams.EVICTOR_MAX_THREADS);
        long keepAliveTime =
            configManager.getDuration(EnvironmentParams.EVICTOR_KEEP_ALIVE);
        terminateMillis = configManager.getDuration
            (EnvironmentParams.EVICTOR_TERMINATE_TIMEOUT);

        RejectedExecutionHandler rejectHandler = 
            new RejectEvictHandler(nThreadUnavailable);
        
        evictionPool = 
            new ThreadPoolExecutor(corePoolSize,
                                   maxPoolSize,
                                   keepAliveTime,
                                   TimeUnit.MILLISECONDS,
                                   new ArrayBlockingQueue<Runnable>(1),
                                   new StoppableThreadFactory(envImpl,
                                                              "JEEvictor",
                                                              logger),
                                   rejectHandler);


        runEvictor = 
            configManager.getBoolean(EnvironmentParams.ENV_RUN_EVICTOR);

        /* 
         * Request notification of mutable property changes. Do this after all
         * fields in the evictor have been initialized, in case this is called
         * quite soon. 
         */
         envImpl.addConfigObserver(this);
        }

    /**
     * Respond to config updates.
     */
    public void envConfigUpdate(DbConfigManager configManager,
                                EnvironmentMutableConfig ignore)
        throws DatabaseException {

        int corePoolSize = 
            configManager.getInt(EnvironmentParams.EVICTOR_CORE_THREADS);
        int maxPoolSize = 
            configManager.getInt(EnvironmentParams.EVICTOR_MAX_THREADS);
        long keepAliveTime =
            configManager.getDuration(EnvironmentParams.EVICTOR_KEEP_ALIVE);

        terminateMillis = configManager.getDuration
            (EnvironmentParams.EVICTOR_TERMINATE_TIMEOUT);

        evictionPool.setCorePoolSize(corePoolSize);
        evictionPool.setMaximumPoolSize(maxPoolSize);
        evictionPool.setKeepAliveTime(keepAliveTime, TimeUnit.MILLISECONDS);
        runEvictor = 
            configManager.getBoolean(EnvironmentParams.ENV_RUN_EVICTOR);
    }

    /* 
     * Node selection varies based on whether this is a private or shared
     * cache.
     */
    abstract TargetSelector makeSelector();

    /**
     * Load stats.
     */
    public StatGroup loadStats(StatsConfig config) {
        
        StatGroup copy = stats.cloneGroup(config.getClear());

        /*
         * These stats are not cleared. They represent the current state of
         * the cache.
         */
        new LongStat(copy, CACHED_IN_SPARSE_TARGET, nINSparseTarget.get());
        new LongStat(copy, CACHED_IN_NO_TARGET, nINNoTarget.get());
        new LongStat(copy, CACHED_IN_COMPACT_KEY, nINCompactKey.get());
        copy.addAll(selector.loadStats(config));
        copy.addAll(arbiter.loadStats(config));

        /* 
         * The number and average size of batches, by type of caller, is
         * calculated each time we collect stats.
         */
        EnumSet<EvictionSource> allSources = 
            EnumSet.allOf(EvictionSource.class);
        for (EvictionSource source : allSources) {
            int index = source.ordinal();

            long nBatches = numBatches[index].getAndSet(0);

            /* Guard against dividing by 0 */
            long avg = (nBatches == 0) ? 0 :
                (numBatchTargets[index].getAndSet(0)/nBatches);

            batchesPerSource[index].set(nBatches);
            avgBatchPerSource[index].set(avg);
        }

        return copy;
    }

    /**
     * Do some eviction before proceeding on with another operation.
     *
     * Note that this method is intentionally not synchronized in order to
     * minimize overhead when checking for critical eviction.  This method is
     * called from application threads for every cursor operation, and by many
     * daemon threads.
     */
    public void doCriticalEviction(boolean backgroundIO) {

        if (arbiter.isOverBudget()) {

            /* 
             * Any time there's excessive cache usage, let the thread pool know
             * there's work to do. 
             */
            alert();

            /* 
             * If this is an application thread, only do eviction if the
             * memory budget overage fulfills the critical eviction
             * requirements. We want to avoid having application thread do
             * eviction.
             */
            if (arbiter.needCriticalEviction()) {
                doEvict(EvictionSource.CRITICAL, backgroundIO);
            }
        }
    }

    /**
     * Do a check on whether synchronous eviction is needed.
     *
     * Note that this method is intentionally not synchronized in order to
     * minimize overhead when checking for critical eviction.  This method is
     * called from application threads for every cursor operation.
     */
    public void doDaemonEviction(boolean backgroundIO) {

        if (arbiter.isOverBudget()) {

            /* 
             * Any time there's excessive cache usage, let the thread pool know
             * there's work to do. 
             */
            alert();

            /* 
             * JE daemon threads should do synchronous eviction any time
             * the memory budget is over.
             */
            doEvict(EvictionSource.DAEMON, backgroundIO);
        }
    }

    /*
     * Eviction invoked by the API
     */
    public void doManualEvict() 
        throws DatabaseException {

        doEvict(EvictionSource.MANUAL, true); // backgroundIO
    }

    /**
     * Evict a specific IN, used by cache modes.
     */
    public void doEvictOneIN(IN target, EvictionSource source) {
        if (!reentrancyGuard.enter()) {
            return;
        }

        try {
            evictIN(target, false /* backgroundIO */, source);
        } finally {
            reentrancyGuard.leave();
        }
    }

    /**
     * Let the eviction pool know there's work to do. 
     */
    public void alert() {
        if (!runEvictor) {
            return;
        }

        evictionPool.execute
            (new BackgroundEvictTask(this, true /* backgroundIO */));
    }

    /**
     * @hidden
     * Return the ThreadPool, used by unit testing only.
     */
    public ThreadPoolExecutor getThreadPool() {
        return evictionPool;
    }

    /**
     * Can execute concurrently, called by app threads or by background evictor
     */
    void doEvict(EvictionSource source, boolean backgroundIO)
        throws DatabaseException {

        if (!reentrancyGuard.enter()) {
            return;
        }

        try {

            /*
             * Repeat as necessary to keep up with allocations.  Stop if no
             * progress is made, to prevent an infinite loop.
             */
            boolean progress = true;
            int nBatches = 0;
            long bytesEvicted = 0;
            numBatches[source.ordinal()].incrementAndGet();
            while (progress && (nBatches < MAX_BATCHES_PER_RUN) && 
                   !shutdownRequested.get()) { 

                /* Get some work from the arbiter. */
                long maxEvictBytes = arbiter.getEvictionPledge();

                /* Nothing to do. */
                if (maxEvictBytes == 0) {
                    break;
                }

                bytesEvicted = evictBatch(source, backgroundIO, maxEvictBytes);
                if (bytesEvicted == 0) {
                    progress = false;
                }

                nBatches += 1;
            }

            /* Really for debugging. */
            if (source == EvictionSource.EVICTORTHREAD) {
                if (logger.isLoggable(Level.FINEST)) {
                    LoggerUtils.finest(logger, envImpl, 
                                       "Thread evicted " + bytesEvicted +
                                       " bytes in " + nBatches + " batches");
                }
            }
        } finally  {
            reentrancyGuard.leave();
        }
    }

    /**
     * Each iteration will attempt to evict maxEvictBytes, but will give up
     * after a complete pass over the INList, or if there is nothing more to
     * evict, due to actions by concurrently executing threads. This method is
     * thread safe and may be called concurrently.
     *
     * @return the number of bytes evicted, or zero if no progress was made.
     * Note that if the INList is completely empty, it's still possible to 
     * return a non-zero number of bytes due to special eviction of items such
     * as utilization info, even though no IN eviction happened.
     */
    long evictBatch(Evictor.EvictionSource source,
                    boolean backgroundIO,
                    long maxEvictBytes)
        throws DatabaseException {

        int numNodesScannedThisBatch = 0;
        nEvictPasses.increment();

        assert TestHookExecute.doHookSetupIfSet(evictProfile);

        /* 
         * Perform class-specific per-batch processing, in advance of getting a
         * batch. This is done under the TargetSelector mutex. TODO: 
         * special eviction is done serially. We may want to absolve
         * application threads of that responsibility, to avoid blocking, and
         * only have evictor threads do special eviction.
         */
        SetupInfo setupInfo = selector.startBatch(true /* doSpecialEviction */);
        long evictBytes = setupInfo.specialEvictionBytes;
        int maxINsPerBatch = setupInfo.maxINsPerBatch;
        if (maxINsPerBatch == 0) {
            return evictBytes; // The INList(s) are empty.
        }

        try {

            /*
             * Keep evicting until we've freed enough memory or we've visited
             * the maximum number of nodes allowed. Each iteration of the while
             * loop is called an eviction batch.
             *
             * In order to prevent endless evicting, limit this run to one pass
             * over the IN list(s).
             */
            while ((evictBytes < maxEvictBytes) &&
                   (numNodesScannedThisBatch <= maxINsPerBatch) &&
                   arbiter.stillNeedsEviction()) {
                
                ScanInfo scanInfo = selector.selectIN(maxINsPerBatch);
                IN target = scanInfo.target;
                numNodesScannedThisBatch += scanInfo.numNodesScanned;

                if (target == null) {
                    break;
                } 

                numBatchTargets[source.ordinal()].incrementAndGet();

                assert TestHookExecute.doHookIfSet(evictProfile, target);

                /*
                 * Check to make sure the DB was not deleted after selecting
                 * it, and prevent the DB from being deleted while we're
                 * working with it.
                 */
                DatabaseImpl targetDb = target.getDatabase();
                DbTree dbTree = targetDb.getDbEnvironment().getDbTree();
                DatabaseImpl refreshedDb = null;
                try {
                    refreshedDb = dbTree.getDb(targetDb.getId());
                    if (refreshedDb != null && !refreshedDb.isDeleted()) {
                        if (target.isDbRoot()) {
                            evictBytes += evictRoot(target, backgroundIO);
                        } else {
                            evictBytes += 
                                evictIN(target, backgroundIO, source);
                        }
                    } else {

                        /*
                         * We don't expect to see an IN that is resident on
                         * the INList with a database that has finished
                         * delete processing, because it should have been
                         * removed from the INList during post-delete
                         * cleanup. It may have been returned by the
                         * INList iterator after being removed from the
                         * INList (because we're using ConcurrentHashMap),
                         * but then IN.getInListResident should return
                         * false.
                         */
                        if (targetDb.isDeleteFinished() &&
                            target.getInListResident()) {
                            String inInfo =
                                " IN type=" + target.getLogType() + " id=" +
                                target.getNodeId() + " not expected on INList";
                            String errMsg = (refreshedDb == null) ?
                                inInfo :
                                ("Database " + refreshedDb.getDebugName() +
                                 " id=" + refreshedDb.getId() + " rootLsn=" +
                                 DbLsn.getNoFormatString
                                 (refreshedDb.getTree().getRootLsn()) +
                                  ' ' + inInfo);
                            throw EnvironmentFailureException.
                                unexpectedState(errMsg);
                        }
                    }
                } finally {
                    dbTree.releaseDb(refreshedDb);
                }
            }
        } finally {
            nNodesScanned.add(numNodesScannedThisBatch);
        }

        return evictBytes;
    }

    /**
     * Evict this DB root node.  [#13415] Must be thread safe, executes
     * concurrently.
     *
     * @return number of bytes evicted.
     */
    private long evictRoot(final IN target,
                           final boolean backgroundIO)
        throws DatabaseException {

        final DatabaseImpl db = target.getDatabase();
        /* SharedEvictor uses multiple envs, do not use superclass envImpl. */ 
        final EnvironmentImpl useEnvImpl = db.getDbEnvironment();
        final INList inList = useEnvImpl.getInMemoryINs();

        class RootEvictor implements WithRootLatched {

            boolean flushed = false;
            long evictBytes = 0;

            public IN doWork(ChildReference root)
                throws DatabaseException {

                IN rootIN = (IN) root.fetchTarget(db, null);
                rootIN.latch(CacheMode.UNCHANGED);
                try {
                    /* Re-check that all conditions still hold. */
                    boolean isDirty = rootIN.getDirty();
                    if (rootIN == target &&
                        rootIN.isDbRoot() &&
                        rootIN.isEvictable() &&
                        !(useEnvImpl.isReadOnly() && isDirty)) {

                        /* Flush if dirty. */
                        if (isDirty) {
                            long newLsn = rootIN.log
                                (useEnvImpl.getLogManager(),
                                 false, // allowDeltas
                                 isProvisionalRequired(rootIN),
                                 backgroundIO,
                                 null); // parent
                            root.setLsn(newLsn);
                            flushed = true;
                        }

                        /* Take off the INList and adjust memory budget. */
                        inList.remove(rootIN);
                        evictBytes = rootIN.getBudgetedMemorySize();

                        /* Evict IN. */
                        root.clearTarget();

                        /* Stats */
                        nRootNodesEvicted.increment();
                    }
                } finally {
                    rootIN.releaseLatch();
                }
                return null;
            }
        }

        /* Attempt to evict the DB root IN. */
        RootEvictor evictor = new RootEvictor();
        db.getTree().withRootLatchedExclusive(evictor);

        /* If the root IN was flushed, write the dirtied MapLN. */
        if (evictor.flushed) {
            useEnvImpl.getDbTree().modifyDbRoot(db);
        }

        return evictor.evictBytes;
    }

    /**
     * Strip or evict this node. Must be thread safe, executes concurrently.
     *
     * @param source is EvictSource.CRITICAL or EVICTORTHREAD when this
     * operation is invoked by the evictor (either critical eviction or the
     * evictor background thread), and is EvictSource.CACHEMODE if invoked by a
     * user operation using CacheMode.EVICT_BIN.  If CACHEMODE, we will perform
     * the eviction regardless of whether:
     *  1) we have to wait for a latch, or
     *  2) the IN generation changes, or
     *  3) we are able to strip LNs.
     *
     * If not CACHEMODE, any of the above conditions will prevent eviction.
     *
     * @return number of bytes evicted.
     */
    private long evictIN(IN target, boolean backgroundIO, EvictionSource source)
        throws DatabaseException {

        DatabaseImpl db = target.getDatabase();
        /* SharedEvictor uses multiple envs, do not use superclass envImpl. */ 
        EnvironmentImpl useEnvImpl = db.getDbEnvironment();
        long evictedBytes = 0;

        /*
         * Use a tracker to count lazily compressed, deferred write, LNs as
         * obsolete.  A local tracker is used to accumulate tracked obsolete
         * info so it can be added in a single call under the log write latch.
         * [#15365]
         */
        LocalUtilizationTracker localTracker = null;

        /*
         * Non-BIN INs are evicted by detaching them from their parent.  For
         * BINS, the first step is to remove deleted entries by compressing
         * the BIN. The evictor indicates that we shouldn't fault in
         * non-resident children during compression. After compression,
         * LN logging and LN stripping may be performed.
         *
         * If LN stripping is used, first we strip the BIN by logging any dirty
         * LN children and detaching all its resident LN targets.  If we make
         * progress doing that, we stop and will not evict the BIN itself until
         * possibly later.  If it has no resident LNs then we evict the BIN
         * itself using the "regular" detach-from-parent routine.
         *
         * If the cleaner is doing clustering, we don't do BIN stripping if we
         * can write out the BIN.  Specifically LN stripping is not performed
         * if the BIN is dirty AND the BIN is evictable AND cleaner
         * clustering is enabled.  In this case the BIN is going to be written
         * out soon, and with clustering we want to be sure to write out the
         * LNs with the BIN; therefore we don't do stripping.
         */

        /*
         * Use latchNoWait because if it's latched we don't want the cleaner
         * to hold up eviction while it migrates an entire BIN.  Latched INs
         * have a high generation value, so not evicting makes sense.  Pass
         * false because we don't want to change the generation during the
         * eviction process.
         */
        boolean inline = (source == EvictionSource.CACHEMODE);
        if (inline) {
            target.latch(CacheMode.UNCHANGED);
        } else {
            if (!target.latchNoWait(CacheMode.UNCHANGED)) {
                return evictedBytes;
            }
        }
        boolean targetIsLatched = true;
        try {
            if (target instanceof BIN) {
                /* First attempt to compress deleted, resident children. */
                localTracker = new LocalUtilizationTracker(useEnvImpl);
                useEnvImpl.lazyCompress(target, localTracker);

                /*
                 * Strip any resident LN targets right now. This may dirty
                 * the BIN if dirty LNs were written out. Note that
                 * migrated BIN entries cannot be stripped.
                 */
                evictedBytes = ((BIN) target).evictLNs();
                if (evictedBytes > 0) {
                    nBINsStripped.increment();
                }
            }

            /*
             * If we were able to free any memory by LN stripping above,
             * then we postpone eviction of the BIN until a later pass.
             * The presence of migrated entries would have inhibited LN
             * stripping. In that case, the BIN can still be evicted,
             * but the marked entries will have to be migrated. That would
             * happen when the target is logged in evictIN.
             */
            if (!inline && evictedBytes != 0) {
                return evictedBytes;
            }
            if (!target.isEvictable()) {
                return evictedBytes;
            }
            /* Regular eviction. */
            Tree tree = db.getTree();

            /*
             * Unit testing.  The target is latched and we are about to
             * release that latch and search for the parent.  Make sure
             * that other operations, such as dirtying an LN in the
             * target BIN, can occur safely in this window.  [#18227]
             */
            assert TestHookExecute.doHookIfSet(preEvictINHook);

            /* getParentINForChildIN unlatches target. */
            targetIsLatched = false;
            SearchResult result =
                tree.getParentINForChildIN
                (target,
                 true,   // requireExactMatch
                 CacheMode.UNCHANGED);

            if (result.exactParentFound) {
                evictedBytes = evictIN(target, result.parent,
                                       result.index, backgroundIO, source);
            }
        } finally {
            if (targetIsLatched) {
                target.releaseLatch();
            }
        }

        /*
         * Count obsolete nodes and write out modified file summaries for
         * recovery.  All latches must have been released. [#15365]
         */
        if (localTracker != null) {
            useEnvImpl.getUtilizationProfile().flushLocalTracker(localTracker);
        }

        return evictedBytes;
    }

    /**
     * Evict an IN. Dirty nodes are logged before they're evicted.
     */
    private long evictIN(IN child,
                         IN parent,
                         int index,
                         boolean backgroundIO,
                         EvictionSource source)
        throws DatabaseException {

        long evictBytes = 0;
        try {
            assert parent.isLatchOwnerForWrite();

            long oldGenerationCount = child.getGeneration();

            /*
             * Get a new reference to the child, in case the reference
             * saved in the selection list became out of date because of
             * changes to that parent.
             */
            IN renewedChild = (IN) parent.getTarget(index);

            if (renewedChild == null) {
                return evictBytes;
            }
            
            boolean inline = (source == EvictionSource.CACHEMODE);
            if (!inline && renewedChild.getGeneration() > oldGenerationCount) {
                return evictBytes;
            }

            /*
             * See the evictIN() method in this class for an explanation for
             * calling latchNoWait().
             */
            if (inline) {
                renewedChild.latch(CacheMode.UNCHANGED);
            } else {
                if (!renewedChild.latchNoWait(CacheMode.UNCHANGED)) {
                    return evictBytes;
                }
            }
            try {
                if (!renewedChild.isEvictable()) {
                    return evictBytes;
                }

                DatabaseImpl db = renewedChild.getDatabase();
                /* Do not use superclass envImpl. */ 
                EnvironmentImpl useEnvImpl = db.getDbEnvironment();

                /*
                 * Log the child if dirty and env is not r/o. Remove
                 * from IN list.
                 */
                long renewedChildLsn = DbLsn.NULL_LSN;
                boolean newChildLsn = false;
                if (renewedChild.getDirty()) {
                    if (!useEnvImpl.isReadOnly()) {
                        boolean logProvisional =
                            isProvisionalRequired(renewedChild);

                        /*
                         * Log a full version (no deltas) and with
                         * cleaner migration allowed.
                         */
                        renewedChildLsn = renewedChild.log
                            (useEnvImpl.getLogManager(),
                             false, // allowDeltas
                             logProvisional,
                             backgroundIO,
                             parent);
                        newChildLsn = true;
                    }
                } else {
                    renewedChildLsn = parent.getLsn(index);
                }

                if (renewedChildLsn != DbLsn.NULL_LSN) {
                    /* Take this off the inlist. */
                    useEnvImpl.getInMemoryINs().remove(renewedChild);

                    evictBytes = renewedChild.getBudgetedMemorySize();
                    if (newChildLsn) {

                        /*
                         * Update the parent so its reference is
                         * null and it has the proper LSN.
                         */
                        parent.updateNode
                            (index, null /*node*/, renewedChildLsn,
                             null /*lnSlotKey*/);
                    } else {

                        /*
                         * Null out the reference, but don't dirty
                         * the node since only the reference
                         * changed.
                         */
                        parent.updateNode
                            (index, (Node) null /*node*/,
                             null /*lnSlotKey*/);
                    }

                    /* Stats */
                    nNodesEvicted.increment();
                    renewedChild.incEvictStats(source);
                }
            } finally {
                renewedChild.releaseLatch();
            }
        } finally {
            parent.releaseLatch();
        }

        return evictBytes;
    }

    public void incBINEvictStats(EvictionSource source) {
        binEvictSources[source.ordinal()].increment();
    }

    public void incINEvictStats(EvictionSource source) {
        inEvictSources[source.ordinal()].increment();
    }

    /**
     * Update the appropriate fetch stat, based on node type.
     */
    public void incLNFetchStats(boolean isMiss) {
        nLNFetch.increment();
        if (isMiss) {
            nLNFetchMiss.increment();
        }
    }

    public void incBINFetchStats(boolean isMiss) {
        nBINFetch.increment();
        if (isMiss) {
            nBINFetchMiss.increment();
        }
    }

    public void incINFetchStats(boolean isMiss) {
        nUpperINFetch.increment();
        if (isMiss) {
            nUpperINFetchMiss.increment();
        }
    }

    public AtomicLong getNINSparseTarget() {
        return nINSparseTarget;
    }

    public AtomicLong getNINNoTarget() {
        return nINNoTarget;
    }

    public AtomicLong getNINCompactKey() {
        return nINCompactKey;
    }

    /*
     * @return true if the node must be logged provisionally.
     */
    private boolean isProvisionalRequired(IN target) {

        DatabaseImpl db = target.getDatabase();
        /* SharedEvictor uses multiple envs, do not use superclass envImpl. */ 
        EnvironmentImpl useEnvImpl = db.getDbEnvironment();

        /*
         * The evictor has to log provisionally in two cases:
         * a - the checkpointer is in progress, and is at a level above the
         * target eviction victim. We don't want the evictor's actions to
         * introduce an IN that has not cascaded up properly.
         * b - the eviction target is part of a deferred write database.
         */
        if (db.isDeferredWriteMode()) {
            return true;
        }

        /*
         * The checkpointer could be null if it was shutdown or never
         * started.
         */
        Checkpointer ckpter = useEnvImpl.getCheckpointer();
        if ((ckpter != null) &&
            (target.getLevel() < ckpter.getHighestFlushLevel(db))) {
            return true;
        }

        return false;
    }

    public void addEnvironment(EnvironmentImpl additionalEnvImpl) {
        selector.addEnvironment(additionalEnvImpl);
    }

    public void removeEnvironment(EnvironmentImpl targetEnvImpl) {
        selector.removeEnvironment(targetEnvImpl);
    }

    /* For unit testing only. */
    public void setPreEvictINHook(TestHook<Object> hook) {
        preEvictINHook = hook;
    }

    /* For unit testing only. */
    public void setEvictProfileHook(TestHook<IN> hook) {
        evictProfile = hook;
    }

    /**
     * Called whenever INs are added to, or removed from, the INList.
     */
    public void noteINListChange(int nINs) {
        selector.noteINListChange(nINs);
    }

    /**
     * Only supported by SharedEvictor.
     */
    public boolean checkEnv(EnvironmentImpl env) {
        return selector.checkEnv(env);
    }

    public StatGroup getStatsGroup() {
        return stats;
    }

    /* For unit testing only. */
    public void setRunnableHook(TestHook<Boolean> hook) {
        arbiter.setRunnableHook(hook);
    }

    public boolean isCacheFull() {
        return arbiter.isCacheFull();
    }

    public boolean wasCacheEverFull() {
        return arbiter.wasCacheEverFull();
    }

    /* For unit test only */
    TargetSelector getSelector() {
       return selector;
    }

    /**
     * Request and wait for a shutdown of all running eviction tasks.
     */
    public void shutdown() {
        /* 
         * Set the shutdown flag so that outstanding eviction tasks end
         * early. The call to evictionPool.shutdown is a ThreadPoolExecutor
         * call, and is an orderly shutdown that waits for and in flight tasks 
         * to end.
         */
        shutdownRequested.set(true);
        evictionPool.shutdown();

        /* 
         * AwaitTermination will wait for the timeout period, or will be
         * interrupted, but we don't really care which it is. The evictor
         * shouldn't be interrupted, but if it is, something urgent is
         * happening.
         */
        boolean shutdownFinished = false;
        try {
            shutdownFinished = 
                evictionPool.awaitTermination(terminateMillis, 
                                              TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            /* We've been interrupted, just give up and end. */
        } finally {
            if (!shutdownFinished) {
        evictionPool.shutdownNow();
    }
        }
    }

    public void requestShutdownPool() {
        shutdownRequested.set(true);
        evictionPool.shutdown();
    }

    private static class ReentrancyGuard {
        private final ConcurrentHashMap<Thread, Thread> activeThreads;
        private final EnvironmentImpl envImpl;
        private final Logger logger;

        ReentrancyGuard(EnvironmentImpl envImpl, Logger logger) {
            this.envImpl = envImpl;
            this.logger = logger;
            activeThreads = new ConcurrentHashMap<Thread, Thread>();
        }

        boolean enter() {
            Thread thisThread = Thread.currentThread();
            if (activeThreads.containsKey(thisThread)) {
                /* We don't really expect a reentrant call. */
                LoggerUtils.severe(logger, envImpl, 
                                   "reentrant call to eviction from " +
                                   LoggerUtils.getStackTrace());

                /* If running w/assertions, in testing mode, assert here. */
                assert false: "reentrant call to eviction from " +
                    LoggerUtils.getStackTrace();
                return false;
        }

            activeThreads.put(thisThread, thisThread);
            return true;
        }

        void leave() {
            assert activeThreads.contains(Thread.currentThread());
            activeThreads.remove(Thread.currentThread());
        }
    }

    static class BackgroundEvictTask implements Runnable {

        private final Evictor evictor;
        private final boolean backgroundIO;

        BackgroundEvictTask(Evictor evictor, 
                            boolean backgroundIO) {
            this.evictor = evictor;
            this.backgroundIO = backgroundIO;
        }
        
        public void run() {
            evictor.doEvict(EvictionSource.EVICTORTHREAD, backgroundIO); 
        }
    }

    static class RejectEvictHandler implements RejectedExecutionHandler {
        private final AtomicLongStat threadUnavailableStat;

        RejectEvictHandler(AtomicLongStat threadUnavailableStat) {
            this.threadUnavailableStat = threadUnavailableStat;
        }
        
        public void rejectedExecution(Runnable r, 
                                      ThreadPoolExecutor executor) {
            threadUnavailableStat.increment();
        }
    }
}
