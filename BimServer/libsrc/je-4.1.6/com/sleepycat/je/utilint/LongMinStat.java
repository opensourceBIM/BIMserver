/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

/**
 * A long stat which maintains a minimum value. It is intialized to 
 * Long.MAX_VALUE. The setMin() method assigns the counter to 
 * MIN(counter, new value).
 */
public class LongMinStat extends LongStat {
    private static final long serialVersionUID = 1L;

    public LongMinStat(StatGroup group, StatDefinition definition) {
        super(group, definition);
        clear();
    }

    public LongMinStat(StatGroup group, 
                       StatDefinition definition, 
                       long counter) {
        super(group, definition);
        this.counter = counter;
    }

    @Override
    public void clear() {
        set(Long.MAX_VALUE);
    }

    /**
     * Set stat to MIN(current stat value, newValue).
     */
    public void setMin(long newValue) {
        counter = (counter > newValue) ? newValue : counter;
    }

    @Override
    String getFormattedValue() {
        if (counter == Long.MAX_VALUE) {
            return "NONE";
        }

        return Stat.FORMAT.format(counter);
    }
}
