/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je;

/**
 * Modes that can be specified for control over caching of records in the JE
 * in-memory cache.  When a record is stored or retrieved, the cache mode
 * determines how long the record is subsequently retained in the JE in-memory
 * cache, relative to other records in the cache.
 *
 * <p>When the cache overflows, JE must evict some records from the cache.  By
 * default, JE uses a Least Recently Used (LRU) algorithm for determining which
 * records to evict.  With the LRU algorithm, JE makes a best effort to evict
 * the "coldest" (least recently used or accessed) records and to retain the
 * "hottest" records in the cache for as long as possible.</p>
 *
 * <p>Note that JE makes a best effort to implement an approximation of an LRU
 * algorithm, and the very coldest record is not always evicted from the cache
 * first.  In addition, hotness and coldness are applied to the portion of the
 * in-memory BTree that is accessed to perform the operation, not just to the
 * record itself.</p>
 *
 * <p>A non-default cache mode may be explicitly specified to override the
 * default behavior of the LRU algorithm.  When no cache mode is explicitly
 * specified, the default cache mode is {@link #DEFAULT}.  The default mode
 * causes the normal LRU algorithm to be used.</p>
 *
 * <p>An explicit cache mode may be specified as an {@link
 * EnvironmentConfig#setCacheMode Environment property}, a {@link
 * DatabaseConfig#setCacheMode Database property}, or a {@link
 * Cursor#setCacheMode Cursor property}.  If none are specified, {@link
 * #DEFAULT} is used.  If more than one non-null property is specified, the
 * Cursor property overrides the Database and Environment properties, and the
 * Database property overrides the Environment property.</p>
 *
 * <p>When all records in a given Database, or all Databases, should be treated
 * the same with respect to caching, using the Database and/or Environment
 * cache mode properties is sufficient. For applications that need finer
 * grained control, the Cursor cache mode property can be used to provide a
 * specific cache mode for individual records or operations.  The Cursor cache
 * mode property can be changed at any time, and the cache mode specified will
 * apply to subsequent operations performed with that Cursor.</p>
 *
 * <p>In a Replicated Environment where a non-default cache mode is desired,
 * the cache mode can be configured on the Master node as described above.
 * However, it is important to configure the cache mode on the Replica nodes
 * using an Environment property.  That way, the cache mode will apply to
 * <em>write</em> operations that are replayed on the Replica for all
 * Databases, even if the Databases are not open by the application on the
 * Replica.  Since all nodes may be Replicas at some point in their life cycle,
 * it is recommended to configure the desired cache mode as an Environment
 * property on all nodes in a Replicated Environment.</p>
 *
 * <p>On a Replica, per-Database control over the cache mode for <em>write</em>
 * operations is possible by opening the Database on the Replica and
 * configuring the cache mode.  Per-Cursor control (meaning per-record or
 * per-operation) control of the cache mode is not possible on a Replica for
 * <em>write</em> operations.  For <em>read</em> operations, both per-Database
 * and per-Cursor control is possible on the Replica, as described above.</p>
 * <p> 
 * The cache related stats in {@link EnvironmentStats} can provide some measure
 * of the effectiveness of the cache mode choice.
 */
public enum CacheMode {

    /**
     * The record's hotness is changed to "most recently used" by the operation
     * where this cache mode is specified.
     *
     * <p>The record will always be colder than other records accessed with a
     * {@code KEEP_HOT} cache mode, and hotter than other records accessed with
     * a {@code MAKE_COLD} cache mode.  Among records accessed with the {@code
     * DEFAULT} cache mode, the record will be hotter than other records
     * accessed at an earlier time and colder then other records accessed at a
     * later time.</p>
     *
     * <p>This cache mode is used when the application does not need explicit
     * control over the cache and a standard LRU implementation is
     * sufficient.</p>
     */
    DEFAULT,

    /**
     * The record is assigned "maximum hotness" by the operation where this
     * cache mode is specified.
     *
     * <p>The record will have the same hotness as other records accessed with
     * this cache mode.  Its relative hotness will not be reduced over time as
     * other records are accessed.  It can only become colder over time if it
     * is subsequently accessed with the {@code DEFAULT} or {@code MAKE_COLD}
     * cache mode.</p>
     *
     * <p>This cache mode is normally used when the application intends to
     * access this record again soon.</p>
     */
    KEEP_HOT,

    /**
     * The record's hotness or coldness is unchanged by the operation where
     * this cache mode is specified.
     *
     * <p>If the record was present in the cache prior to this operation, then
     * its pre-existing hotness or coldness will not be changed.  If the record
     * was added to the cache by this operation, it will have "maximum
     * coldness" and will therefore be colder than other records.</p>
     *
     * <p>This cache mode is normally used when the application prefers that
     * the record be evicted from the cache when space is needed, but only if
     * the record has not been accessed using {@code DEFAULT} or {@code
     * KEEP_HOT} recently.</p>
     */
    UNCHANGED,

    /**
     * The record is assigned "maximum coldness" by the operation where this
     * cache mode is specified.  When the JE cache is full, operations using
     * this cache mode will opportunistically perform explicit eviction of the
     * the record LN (leaf node) and/or its parent BIN (bottom internal node).
     *
     * <p>If the record is not evicted (because the JE cache is not full), the
     * record will have the same hotness as other records accessed with this
     * cache mode.  It is very likely that this record will be evicted from the
     * cache when the cache fills.  It can only become warmer over time if it
     * is subsequently accessed with the {@code DEFAULT} or {@code KEEP_HOT}
     * cache mode.</p>
     *
     * <p>This cache mode is normally used when the application prefers that
     * the record be evicted from the cache when space is needed, regardless of
     * whether the record has been accessed using {@code DEFAULT} or
     * {@code KEEP_HOT} recently.</p>
     *
     * <p>A potential advantage of this cache mode is that blocking between
     * threads may be reduced when eviction is a dominant performance factor,
     * and throughput may be increased as a result.  Unlike most other cache
     * modes, eviction performed during the operation will not block other
     * threads, and the operation will not be blocked by eviction in other
     * threads.</p>
     *
     * @since 3.3.98
     */
    MAKE_COLD,

    /**
     * The record LN (leaf node) is evicted as soon as possible after the
     * operation where this cache mode is specified.  The parent BIN (bottom
     * internal node) for the record is assigned "maximum coldness" as if
     * {@code MAKE_COLD} were used.
     *
     * <p>When a cursor is used, the LN is evicted only when the cursor is
     * moved to a different record or is closed.</p>
     *
     * <p>This cache mode is normally used when not all LNs will fit into the
     * JE cache, and the application prefers to read the LN from the log file
     * when the record is accessed again, rather than have it take up space in
     * the JE cache and potentially cause expensive Java GC.</p>
     *
     * <p>Note that using this mode for all operations will prevent the cache
     * from filling, if all internal nodes fit in cache.</p>
     *
     * @since 3.3.98
     */
    EVICT_LN,

    /**
     * The record LN (leaf node) and its parent BIN (bottom internal node)
     * are evicted as soon as possible after the operation where this cache
     * mode is specified.  Note that when the BIN is evicted, all record LNs
     * (leaf nodes) in that BIN are also evicted.  If the BIN cannot be evicted
     * immediately, it is assigned "maximum coldness" as if {@code MAKE_COLD}
     * were used.
     *
     * <p>When a cursor is used, the LN is evicted when the cursor is moved to
     * a different record or is closed.  The BIN is evicted when the cursor
     * moves to a different BIN or is closed.</p>

     * <p>This cache mode is normally used when not all BINs will fit into the
     * JE cache, and the application prefers to read the LN and BIN from the
     * log file when the record is accessed again, rather than have them take
     * up space in the JE cache and potentially cause expensive Java GC.</p>
     *
     * <p>A potential advantage of this cache mode is that blocking between
     * threads may be reduced when eviction is a dominant performance factor,
     * and throughput may be increased as a result.  Unlike most other cache
     * modes, eviction performed during the operation will not block other
     * threads, and the operation will not be blocked by eviction in other
     * threads.</p>
     *
     * <p>Note that using this mode for all operations will prevent the cache
     * from filling, if all non-bottom internal nodes fit in cache.</p>
     *
     * @since 4.0.97
     */
    EVICT_BIN,

    /**
     * @hidden
     * For internal use only.
     *
     * The {@code CacheMode} is determined dynamically by a {@link
     * CacheModeStrategy} object.  The {@link CacheModeStrategy#getCacheMode}
     * method is called for every database operation to obtain the cache mode.
     * The strategy implementation may use any algorithm desired to determine
     * the cache mode to be used.
     *
     * <p>When using this cache mode, a {@link CacheModeStrategy} must be
     * configured using a {@link DatabaseConfig#setCacheModeStrategy Database
     * property} or an {@link EnvironmentConfig#setCacheModeStrategy
     * Environment property}.  If both are specified, the Database property
     * overrides the Environment property.</p>
     *
     * <p>Note that the strategy object and the {@code DYNAMIC} cache mode need
     * not both be configured at the same level (Environment or Database).
     * These two properties may be independently configured.  The {@code
     * DYNAMIC} cache mode may be configured for a Cursor, Database or
     * Environment, and the strategy object may be configured for a Database or
     * Environment.</p>
     *
     * @since 4.0.97
     */
    DYNAMIC
}
