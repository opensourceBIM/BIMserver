/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2005-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.io.Serializable;

import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_CACHED_GETS;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_CACHE_LAST;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_CACHE_SIZE;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_CACHE_VALUE;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_GETS;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_RANGE_MAX;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_RANGE_MIN;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_STORED_VALUE;

import com.sleepycat.je.utilint.StatGroup;

/**
 * A SequenceStats object is used to return sequence statistics.
 */
public class SequenceStats implements Serializable {
    private static final long serialVersionUID = 1L;

    private StatGroup stats;

    /**
     * @hidden
     * Internal use only.
     */
    public SequenceStats(StatGroup stats) {
        this.stats = stats;
    }

    /**
     * Returns the number of times that Sequence.get was called successfully.
     *
     * @return number of times that Sequence.get was called successfully.
     */
    public int getNGets() {
        return stats.getInt(SEQUENCE_GETS);
    }

    /**
     * Returns the number of times that Sequence.get was called and a cached
     * value was returned.
     *
     * @return number of times that Sequence.get was called and a cached
     * value was returned.
     */
    public int getNCachedGets() {
        return stats.getInt(SEQUENCE_CACHED_GETS);
    }

    /**
     * Returns the current value of the sequence in the database.
     *
     * @return current value of the sequence in the database.
     */
    public long getCurrent() {
        return stats.getLong(SEQUENCE_STORED_VALUE);
    }

    /**
     * Returns the current cached value of the sequence.
     *
     * @return current cached value of the sequence.
     */
    public long getValue() {
        return stats.getLong(SEQUENCE_CACHE_VALUE);
    }

    /**
     * Returns the last cached value of the sequence.
     *
     * @return last cached value of the sequence.
     */
    public long getLastValue() {
        return stats.getLong(SEQUENCE_CACHE_LAST);
    }

    /**
     * Returns the minimum permitted value of the sequence.
     *
     * @return minimum permitted value of the sequence.
     */
    public long getMin() {
        return stats.getLong(SEQUENCE_RANGE_MIN);
    }

    /**
     * Returns the maximum permitted value of the sequence.
     *
     * @return maximum permitted value of the sequence.
     */
    public long getMax() {
        return stats.getLong(SEQUENCE_RANGE_MAX);
    }

    /**
     * Returns the number of values that will be cached in this handle.
     *
     * @return number of values that will be cached in this handle.
     */
    public int getCacheSize() {
        return stats.getInt(SEQUENCE_CACHE_SIZE);
    }

    @Override
    public String toString() {
        return stats.toString();
    }

    public String toStringVerbose() {
        return stats.toStringVerbose();
    }
}
