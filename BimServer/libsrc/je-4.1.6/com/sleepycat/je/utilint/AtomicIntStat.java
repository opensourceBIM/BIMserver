/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.util.concurrent.atomic.AtomicInteger;

import com.sleepycat.je.EnvironmentFailureException;

/**
 * A int JE stat.
 */
public class AtomicIntStat extends Stat<Integer> implements Cloneable {
    private static final long serialVersionUID = 1L;

    private AtomicInteger counter = new AtomicInteger(0);

    public AtomicIntStat(StatGroup group, StatDefinition definition) {
        super(group, definition);
    }

    @Override
    public Integer get() {
        return counter.get();
    }

    @Override
    public void set(Integer newValue) {
        counter.set(newValue);
    }

    public void increment() {
        counter.incrementAndGet();
    }

    public void add(int count) {
        counter.addAndGet(count);
    }

    @Override
    public void add(Stat<Integer> other) {
        counter.addAndGet(other.get());
    }

    @Override
    public void clear() {
        counter.set(0);
    }

    @Override
    public AtomicIntStat copy() {
        try {
            AtomicIntStat ret = (AtomicIntStat) super.clone();
            ret.counter = new AtomicInteger(counter.get());
            return ret;
        } catch (CloneNotSupportedException unexpected) {
            throw EnvironmentFailureException.unexpectedException(unexpected);
        }
    }

    @Override
    String getFormattedValue() {
        return Stat.FORMAT.format(counter.get());
    }
}
