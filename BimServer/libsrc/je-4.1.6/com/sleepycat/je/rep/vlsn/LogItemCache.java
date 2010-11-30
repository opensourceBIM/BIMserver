/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.vlsn;

import java.lang.ref.SoftReference;
import java.util.concurrent.atomic.AtomicReference;

import com.sleepycat.je.log.LogItem;
import com.sleepycat.je.utilint.VLSN;

/**
 * A no-wait cache used to retain the most recent VLSNs. The Feeders check this
 * cache first for log entries to send out to the Replicas. Feeders that are
 * feeding at the most up to date portion of the replication stream will likely
 * hit in the cache, preventing a lookup in the log buffers or log files.
 *
 * The log item cache is made up of weak references so there is never any
 * guarantee that even the most recent 32 entries are in there.
 */
class LogItemCache {

    /*
     * Must be a power of 2 and small, typically around 32 entries. Increasing
     * sizes typically yield diminishing returns.
     */
    private final int cacheSize;
    private final int sizeMask;

    /*
     * Soft reference to array, so that the LogItems can be released when
     * under GC pressure.
     */
    private volatile SoftReference<AtomicReference<LogItem>[]> cacheReference =
        new SoftReference<AtomicReference<LogItem>[]>(null);

    /**
     * @throws IllegalArgumentException via ReplicatedEnvironment ctor.
     */
    LogItemCache(int cacheSize) {
        if (Integer.bitCount(cacheSize) != 1) {
            throw new IllegalArgumentException
                ("Bad cache size: " + cacheSize + "; it must be a power of 2");
        }
        this.cacheSize = cacheSize;
        sizeMask = cacheSize - 1;
    }

    void put(VLSN vlsn, LogItem logItem) {
        getArray()[(int)vlsn.getSequence() & sizeMask].set(logItem);
    }

    LogItem get(VLSN vlsn) {
        LogItem item =  getArray()[(int)vlsn.getSequence() & sizeMask].get();
        return (item != null) && item.getHeader().getVLSN().equals(vlsn) ?
                item : null;
    }

    /**
     * For explicit release of references.
     */
    void clear() {
        for (AtomicReference<LogItem> element : getArray()) {
            element.set(null);
        }
    }

    /**
     * Returns the cache array, creating a new one, if the GC had cleared the
     * reference to the earlier one.
     * <p>
     *
     * Note that there may be a slight inefficiency if getArray is called
     * concurrently, and it had been cleared earlier, since it would be
     * allocated twice and introduce a cache miss. This occurrence is
     * infrequent enough that it's not worth the overhead of a sync mechanism.
     *
     * @return the underlying array, allocating a new one, if the previous one
     * had been GC'd
     */
    @SuppressWarnings("unchecked")
    private final AtomicReference<LogItem>[] getArray() {
        AtomicReference<LogItem>[] array = cacheReference.get();
        if (array == null) {
            array = new AtomicReference[cacheSize];
            for (int i=0; i < array.length; i++) {
                array[i] = new AtomicReference<LogItem>();
            }
            cacheReference =
                new SoftReference<AtomicReference<LogItem>[]>(array);
        }
        return array;
    }
}
