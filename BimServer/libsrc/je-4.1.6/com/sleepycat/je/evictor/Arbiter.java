/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.evictor;

import static com.sleepycat.je.evictor.EvictorStatDefinition.EVICTOR_REQUIRED_EVICT_BYTES;
import static com.sleepycat.je.evictor.EvictorStatDefinition.GROUP_DESC;
import static com.sleepycat.je.evictor.EvictorStatDefinition.GROUP_NAME;

import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.TestHook;

/**
 * The Arbiter determines whether eviction should occur, by consulting the
 * memory budget.
 */
class Arbiter {

    private final MemoryBudget.Totals memBudgetTotals;

    /* Debugging and unit test support. */
    private TestHook<Boolean> runnableHook;

    /* je.evictor.evictBytes */
    private final long evictBytesSetting;
    
    /* Whether isCacheFull ever returned true. */
    private volatile boolean everFull;

    private final StatGroup stats;
    private final LongStat requiredEvictBytesStat;

    Arbiter(EnvironmentImpl envImpl) {

        DbConfigManager configManager = envImpl.getConfigManager();
        evictBytesSetting = configManager.getLong
            (EnvironmentParams.EVICTOR_EVICT_BYTES);

        stats = new StatGroup(GROUP_NAME, GROUP_DESC);
        requiredEvictBytesStat = new LongStat(stats, 
                                              EVICTOR_REQUIRED_EVICT_BYTES);

        memBudgetTotals = envImpl.getMemoryBudget().getTotals();
    }

    public StatGroup loadStats(StatsConfig config) {

        /* 
         * The current amount of bytes to evict should never be shown as a 
         * negative number.
         */
        long overBudget = memBudgetTotals.getCacheUsage() - 
            memBudgetTotals.getMaxMemory();
        requiredEvictBytesStat.set(Math.max(0L, overBudget));

        return stats.cloneGroup(config.getClear());
    }
    
    /**
     * Return true if the memory budget is overspent.
     */
    boolean isOverBudget() {

        return memBudgetTotals.getCacheUsage() >
            memBudgetTotals.getMaxMemory();
    }

    /**
     * Do a check on whether synchronous eviction is needed.
     *
     * Note that this method is intentionally not synchronized in order to
     * minimize overhead when checking for critical eviction.  This method is
     * called from application threads for every cursor operation.
     */
    boolean needCriticalEviction() {

        final long over = memBudgetTotals.getCacheUsage() -
            memBudgetTotals.getMaxMemory();

        return (over > memBudgetTotals.getCriticalThreshold());
    }

    /**
     * Do a check on whether the cache should still be subject to eviction.
     *
     * Note that this method is intentionally not synchronized in order to
     * minimize overhead, because it's checked on every iteration of the
     * evict batch loop.
     */
    boolean stillNeedsEviction() {

        return (memBudgetTotals.getCacheUsage() + evictBytesSetting) >
            memBudgetTotals.getMaxMemory();
    }

    /**
     * Returns true if the JE cache level is above the point where it is likely
     * that the cache has filled, and is staying full.  This is not guaranteed,
     * since the level does not stay at a constant value.  But it is a good
     * enough indication to drive activities such as cache mode determination.
     * This method errs on the side of returning true sooner than the point
     * where the cache is actually full, as described below.
     */
    public boolean isCacheFull() {

        /*
         * When eviction occurs, normally the cache level goes down to roughly
         * MaxMemory minus evictBytesSetting.  However, because this is only an
         * approximation, we double the evictBytesSetting as a fudge factor.
         *
         * The idea is to return false from this method only when we're
         * relatively sure that the cache has not yet filled.  This will
         * prevent the return value from alternating between true and false
         * repeatedly as the result of normal eviction.
         */
        boolean isNowFull = memBudgetTotals.getCacheUsage() +
                (2 * evictBytesSetting) >=
                memBudgetTotals.getMaxMemory();
        if (isNowFull) {
            everFull = true;
        }
        return isNowFull;
    }

    /**
     * Returns whether eviction has ever occurred, i.e., whether the cache has
     * ever filled.
     */
    public boolean wasCacheEverFull() {
        return everFull;
    }

    /**
     * Return non zero number of bytes if eviction should happen. Caps the 
     * number of bytes a single thread will try to evict.
     */
    long getEvictionPledge() {

        long currentUsage  = memBudgetTotals.getCacheUsage();
        long maxMem = memBudgetTotals.getMaxMemory();

        long overBudget = currentUsage - maxMem;
        boolean doRun = (overBudget > 0);

        long requiredEvictBytes = 0;

        /* If running, figure out how much to evict. */
        if (doRun) {
            requiredEvictBytes = overBudget + evictBytesSetting;
            /* Don't evict more than 50% of the cache. */
            if (currentUsage - requiredEvictBytes < maxMem / 2) {
                requiredEvictBytes = overBudget + (maxMem / 2);
            }
        }

        /* Unit testing, force eviction. */
        if (runnableHook != null) {
            doRun = runnableHook.getHookValue();
            if (doRun) {
                requiredEvictBytes = maxMem;
            } else {
                requiredEvictBytes = 0;
            }
        }
        return requiredEvictBytes;
    }

    /* For unit testing only. */
    void setRunnableHook(TestHook<Boolean> hook) {
        runnableHook = hook;
    }
}