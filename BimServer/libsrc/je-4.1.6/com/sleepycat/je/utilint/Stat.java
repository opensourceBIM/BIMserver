/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.io.Serializable;
import java.text.DecimalFormat;

import com.sleepycat.je.EnvironmentFailureException;

/**
 * Base class for all JE statistics. A single Stat embodies a value and
 * definition. See StatGroup for a description of how to create and display
 * statistics.
 *
 * Note that Stat intentionally does not contain the statistics value itself.
 * Instead, the concrete subclass will implement the value as the appropriate
 * primitive type. That's done to avoid wrapper classes like Integer and Long,
 * and to  keep the overhead of statistics low.
 */
public abstract class Stat<T> implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    public static final DecimalFormat FORMAT = 
        new DecimalFormat("###,###,###,###,###,###,###");

    protected final StatDefinition definition;

    /**
     * A stat registers itself with an owning group.
     */
    Stat(StatGroup group, StatDefinition definition) {
        this.definition = definition;
        group.register(this);
    }
    
    /**
     * @return the stat value.
     */
    public abstract T get();

    /**
     * Set the stat value.
     */
    public abstract void set(T newValue);

    /**
     * Add the value of "other" to this stat.
     */
    public abstract void add(Stat<T> other);

    /**
     * Initialize the stat to the proper value at startup, or reset the
     * stat when copyAndClear() is called.
     */
    public abstract void clear();

    @SuppressWarnings("unchecked")
    public Stat<T> copy() {
        Object o;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException unexpected) {
            throw EnvironmentFailureException.unexpectedException(unexpected);
        }
        return (Stat<T>) o;
    }

    /**
     * Return a copy of this stat, and clear the stat's value.
     */
    public Stat<T> copyAndClear() {
        Stat<T> newCopy = copy();
        clear();
        return newCopy;
    }

    public StatDefinition getDefinition() {
        return definition;
    }

    /**
     * Return a string with the stat value formatted as appropriate for 
     * its type.
     */
    abstract String getFormattedValue();

    @Override
    public String toString() {
        return definition.getName() + "=" + getFormattedValue();
    }

    /**
     * Includes the per-stat description in the output string.
     */
    public String toStringVerbose() {
        return definition.getName() + "=" + getFormattedValue() +
            "\n\t\t" + definition.getDescription();
    }
}
