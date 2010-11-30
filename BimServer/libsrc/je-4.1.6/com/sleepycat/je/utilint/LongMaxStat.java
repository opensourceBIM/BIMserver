/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

/**
 * A long stat which maintains a maximum value. It is initialized to 
 * Long.MIN_VALUE. The setMax() methods assigns the counter to 
 * MAX(counter, new value). 
 */
public class LongMaxStat extends LongStat {
    private static final long serialVersionUID = 1L;

    public LongMaxStat(StatGroup group, StatDefinition definition) {
        super(group, definition);
        clear();
    }

    public LongMaxStat(StatGroup group, 
                       StatDefinition definition, 
                       long counter) {
        super(group, definition);
        this.counter = counter;
    }

    @Override
    public void clear() {
        set(Long.MIN_VALUE);
    }

    /**
     * Set stat to MAX(current stat value, newValue).
     */
    public void setMax(long newValue) {
        counter = (counter < newValue) ? newValue : counter;
    }

    @Override
    String getFormattedValue() {
        if (counter == Long.MIN_VALUE) {
            return "NONE";
        }

        return Stat.FORMAT.format(counter);
    }
}

