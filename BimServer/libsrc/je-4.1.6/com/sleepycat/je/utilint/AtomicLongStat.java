/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.util.concurrent.atomic.AtomicLong;

import com.sleepycat.je.EnvironmentFailureException;

/**
 * A long JE stat.
 */
public class AtomicLongStat extends Stat<Long> implements Cloneable {
    private static final long serialVersionUID = 1L;

    private AtomicLong counter = new AtomicLong(0L);

    public AtomicLongStat(StatGroup group, StatDefinition definition) {
        super(group, definition);
    }

    @Override
    public Long get() {
        return counter.get();
    }

    @Override
    public void set(Long newValue) {
        counter.set(newValue);
    }

    public void increment() {
        counter.incrementAndGet();
    }

    public void decrement() {
        counter.decrementAndGet();
    }

    public void add(long count) {
        counter.addAndGet(count);
    }

    @Override
    public void add(Stat<Long> other) {
        counter.addAndGet(other.get());
    }

    @Override
    public void clear() {
        counter.set(0L);
    }

    @Override
    public AtomicLongStat copy() {
        try {
            AtomicLongStat ret = (AtomicLongStat) super.clone();
            ret.counter = new AtomicLong(counter.get());
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
