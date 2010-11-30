/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.evictor;

import java.util.Iterator;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.utilint.StatGroup;

/**
 * The standard eviction selector that operates on the INList for a single
 * environment.  A single iterator over the INList is used to implement
 * getNextIN.
 */
class PrivateSelector extends TargetSelector {

    private final EnvironmentImpl envImpl;

    private Iterator<IN> scanIter;

    public PrivateSelector(EnvironmentImpl envImpl) 
        throws DatabaseException {

        super(envImpl);
        this.envImpl = envImpl;
        scanIter = null;
    }

    @Override
    public StatGroup loadStats(StatsConfig config) {
        return super.loadStats(config);
    }

    /**
     * Do nothing.
     */
    @Override
    public void noteINListChange(int nINs) {
    }

    /**
     * Initializes the iterator, and performs special eviction once per batch.
     */
    @Override
    synchronized SetupInfo startBatch(boolean doSpecialEviction)
        throws DatabaseException {

        SetupInfo setupInfo = new SetupInfo();

        if (scanIter == null) {
            scanIter = envImpl.getInMemoryINs().iterator();
        }

        /* Perform special eviction without holding any latches. */
        if (doSpecialEviction){
            setupInfo.specialEvictionBytes = envImpl.specialEviction();
        }

        setupInfo.maxINsPerBatch = envImpl.getInMemoryINs().getSize();
        return setupInfo;
    }

    /**
     * Returns the next IN, wrapping if necessary.
     */
    @Override
    IN getNextIN() {
        if (envImpl.getMemoryBudget().isTreeUsageAboveMinimum()) {
            if (!scanIter.hasNext()) {
                scanIter = envImpl.getInMemoryINs().iterator();
            }
            return scanIter.hasNext() ? scanIter.next() : null;
        } 
        
        return null;
    }

    /**
     * Return stats for the single INList covered by this evictor.
     */
    @Override
    StatGroup getINListStats(StatsConfig config) {
        return envImpl.getInMemoryINs().loadStats();
    }

    /* For unit testing only. */
    @Override
    Iterator<IN> getScanIterator() {
        return scanIter;
    }

    /* For unit testing only. */
    @Override
    void setScanIterator(Iterator<IN> iter) {
        scanIter = iter;
    }

    /**
     * Only supported by SharedSelector.
     */
    @Override
    public void addEnvironment(EnvironmentImpl unused) {
        throw EnvironmentFailureException.unexpectedState();
    }

    /**
     * Only supported by SharedSelector.
     */
    @Override
    public void removeEnvironment(EnvironmentImpl unused) {
        throw EnvironmentFailureException.unexpectedState();
    }

    /**
     * Only supported by SharedSelector.
     */
    @Override
    public boolean checkEnv(EnvironmentImpl env) {
        throw EnvironmentFailureException.unexpectedState();
    }
}
