/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DbConfigManager;

/**
 * Specifies the attributes of an environment.
 *
 * <p>To change the default settings for a database environment, an application
 * creates a configuration object, customizes settings and uses it for
 * environment construction. The set methods of this class validate the
 * configuration values when the method is invoked.  An
 * IllegalArgumentException is thrown if the value is not valid for that
 * attribute.</p>
 *
 * <p>All commonly used environment attributes have convenience setter/getter
 * methods defined in this class.  For example, to change the default
 * transaction timeout setting for an environment, the application should do
 * the following:</p>
 * <pre class=code>
 *     // customize an environment configuration
 *     EnvironmentConfig envConfig = new EnvironmentConfig();
 *     // will throw if timeout value is invalid
 *     envConfig.setLockTimeout(250, TimeUnit.MILLISECONDS);
 *     // Open the environment using this configuration.
 *     Environment myEnvironment = new Environment(home, envConfig);
 * </pre>
 *
 * <p>Additional parameters are described by the parameter name String
 * constants in this class. These additional parameters will not be needed by
 * most applications. This category of properties can be specified for the
 * EnvironmentConfig object through a Properties object read by
 * EnvironmentConfig(Properties), or individually through
 * EnvironmentConfig.setConfigParam().</p>
 *
 * <p>For example, an application can change the default btree node size
 * with:</p>
 *
 * <pre>
 *     envConfig.setConfigParam(EnvironmentConfig.NODE_MAX_ENTRIES, "256");
 * </pre>
 *
 * <p>Environment configuration follows this order of precedence:</p>
 * <ol>
 * <li>Configuration parameters specified in
 * &lt;environment home&gt;/je.properties take first precedence.
 * <li>Configuration parameters set in the EnvironmentConfig object used at
 * Environment construction are next.
 * <li>Any configuration parameters not set by the application are set to
 * system defaults, described along with the parameter name String constants
 * in this class.</li>
 * </ol>
 *
 * <p>An EnvironmentConfig can be used to specify both mutable and immutable
 * environment properties.  Immutable properties may be specified when the
 * first Environment handle (instance) is opened for a given physical
 * environment.  When more handles are opened for the same environment, the
 * following rules apply:</p>
 *
 * <ol> <li>Immutable properties must equal the original values specified when
 * constructing an Environment handle for an already open environment.  When a
 * mismatch occurs, an exception is thrown.
 *
 * <li>Mutable properties are ignored when constructing an Environment handle
 * for an already open environment.  </ol>
 *
 * <p>After an Environment has been constructed, its mutable properties may be
 * changed using {@link Environment#setMutableConfig}.  See {@link
 * EnvironmentMutableConfig} for a list of mutable properties; all other
 * properties are immutable.  Whether a property is mutable or immutable is
 * also described along with the parameter name String constants in this
 * class.</p>
 *
 * <h4>Getting the Current Environment Properties</h4>
 *
 * To get the current "live" properties of an environment after constructing it
 * or changing its properties, you must call {@link Environment#getConfig} or
 * {@link Environment#getMutableConfig}.  The original EnvironmentConfig or
 * EnvironmentMutableConfig object used to set the properties is not kept up to
 * date as properties are changed, and does not reflect property validation or
 * properties that are computed.
 *
 * <h4><a name="timeDuration">Time Duration Properties</a></h4>
 *
 * <p>Several environment and transaction configuration properties are time
 * durations.  For these properties, a time unit is specified along with an
 * integer duration value.</p>
 *
 * <p>When specific setter and getter methods exist for a time duration
 * property, these methods have a {@link TimeUnit} argument.  Examples are
 * {@link #setLockTimeout(long,TimeUnit)} and {@link
 * #getLockTimeout(TimeUnit)}.  Note that the {@link TimeUnit} argument may
 * be null only when the duration value is zero; there is no default unit that
 * is used when null is specified.</p>
 *
 * <p>When a time duration is specified as a string value, the following format
 * is used.</p>
 *
 * <pre>   {@code <value> [ <whitespace> <unit> ]}</pre>
 *
 * <p>The {@code <value>} is an integer.  The {@code <unit>} name, if present,
 * must be preceded by one or more spaces or tabs.</p>
 *
 * <p>The following {@code <unit>} names are allowed.  Both {@link TimeUnit}
 * names and IEEE standard abbreviations are allowed.  Unit names are case
 * insensitive.</p>
 *
 * <table border="true">
 * <tr><th>IEEE abbreviation</th>
 *     <th>TimeUnit name</td>
 *     <th>Definition</th>
 * </tr>
 * <tr><td>{@code ns}</td>
 *     <td>{@code NANOSECONDS}</td>
 *     <td>one billionth (10<sup>-9</sup>) of a second</td>
 * </tr>
 * <tr><td>{@code us}</td>
 *     <td>{@code MICROSECONDS}</td>
 *     <td>one millionth (10<sup>-6</sup>) of a second</td>
 * </tr>
 * <tr><td>{@code ms}</td>
 *     <td>{@code MILLISECONDS}</td>
 *     <td>one thousandth (10<sup>-3</sup>) of a second</td>
 * </tr>
 * <tr><td>{@code s}</td>
 *     <td>{@code SECONDS}</td>
 *     <td>1 second</td>
 * </tr>
 * <tr><td>{@code min}</td>
 *     <td>&nbsp;</td>
 *     <td>60 seconds</td>
 * </tr>
 * <tr><td>{@code h}</td>
 *     <td>&nbsp;</td>
 *     <td>3600 seconds</td>
 * </tr>
 * </table>
 *
 * <p>Examples are:</p>
 * <pre>
 * 3 seconds
 * 3 s
 * 500 ms
 * 1000000 (microseconds is implied)
 * </pre>
 *
 * <p>Note that when the {@code <unit>} is omitted, microseconds is implied.
 * This default is supported for compatibility with JE 3.3 and earlier.  In JE
 * 3.3 and earlier, explicit time units were not used and durations were always
 * implicitly specified in microseconds.  The older methods that do not have a
 * {@link TimeUnit} argument, such as {@link #setLockTimeout(long)} and {@link
 * #getLockTimeout()}, use microsecond durations and have been deprecated.</p>
 */
public class EnvironmentConfig extends EnvironmentMutableConfig {

    /**
     * @hidden
     * For internal use, to allow null as a valid value for the config
     * parameter.
     */
    public static final EnvironmentConfig DEFAULT = new EnvironmentConfig();

    /**
     * The {@link #setCacheSize CacheSize} property.
     * <p> 
     * When using the shared cache feature, new environments that join the
     * cache may alter the cache size setting if their configuration is set to
     * a different value.
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>Yes</td>
     * <td>0</td>
     * <td>-none-</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     *
     * @see #setCacheSize
     */
    public static final String MAX_MEMORY = "je.maxMemory";

    /**
     * The {@link #setCachePercent CachePercent} property.
     * <p> 
     * When using the shared cache feature, new environments that join the
     * cache may alter the cache percent setting if their configuration is set
     * to a different value.
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>60</td>
     * <td>1</td>
     * <td>90</td>
     * </tr>
     * </table></p>
     *
     * @see #setCachePercent
     */
    public static final String MAX_MEMORY_PERCENT = "je.maxMemoryPercent";

    /**
     * The {@link #setSharedCache SharedCache} property.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String SHARED_CACHE = "je.sharedCache";

    /**
     * If true, a checkpoint is forced following recovery, even if the
     * log ends with a checkpoint.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_RECOVERY_FORCE_CHECKPOINT =
        "je.env.recoveryForceCheckpoint";

    /**
     * If true, starts up the INCompressor thread.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_RUN_IN_COMPRESSOR =
        "je.env.runINCompressor";

    /**
     * If true, starts up the checkpointer thread.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_RUN_CHECKPOINTER = "je.env.runCheckpointer";

    /**
     * If true, starts up the cleaner thread.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_RUN_CLEANER = "je.env.runCleaner";

    /**
     * If true, eviction is also done by a pool of evictor threads, as well as
     * being done inline by application threads. If false, the evictor pool is
     * not used, regardless of the values of je.evictor.coreThreads and
     * je.evictor.maxThreads.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_RUN_EVICTOR =
        "je.env.runEvictor";

    /**
     * The maximum number of read operations performed by JE background
     * activities (e.g., cleaning) before sleeping to ensure that application
     * threads can perform I/O.  If zero (the default) then no limitation on
     * I/O is enforced.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>0</td>
     * <td>0</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     *
     * @see #ENV_BACKGROUND_SLEEP_INTERVAL
     */
    public static final String ENV_BACKGROUND_READ_LIMIT =
        "je.env.backgroundReadLimit";

    /**
     * The maximum number of write operations performed by JE background
     * activities (e.g., checkpointing and eviction) before sleeping to ensure
     * that application threads can perform I/O.  If zero (the default) then no
     * limitation on I/O is enforced.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>0</td>
     * <td>0</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     *
     * @see #ENV_BACKGROUND_SLEEP_INTERVAL
     */
    public static final String ENV_BACKGROUND_WRITE_LIMIT =
        "je.env.backgroundWriteLimit";

    /**
     * The duration that JE background activities will sleep when the {@link
     * #ENV_BACKGROUND_WRITE_LIMIT} or {@link #ENV_BACKGROUND_WRITE_LIMIT} is
     * reached.  If {@link #ENV_BACKGROUND_WRITE_LIMIT} and {@link
     * #ENV_BACKGROUND_WRITE_LIMIT} are zero, this setting is not used.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link <a href="#timeDuration">Duration</a>}</td>
     * <td>Yes</td>
     * <td>1 ms</td>
     * <td>1 ms</td>
     * <td>24 d</td>
     * </tr>
     * </table></p>
     *
     * @see <a href="EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String ENV_BACKGROUND_SLEEP_INTERVAL =
        "je.env.backgroundSleepInterval";

    /**
     * Debugging support: check leaked locks and txns at env close.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_CHECK_LEAKS = "je.env.checkLeaks";

    /**
     * Debugging support: call Thread.yield() at strategic points.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_FORCED_YIELD = "je.env.forcedYield";

    /**
     * If true, create an environment that is capable of performing
     * transactions.  If true is not passed, transactions may not be used.  For
     * licensing purposes, the use of this method distinguishes the use of the
     * Transactional product.  Note that if transactions are not used,
     * specifying true does not create additional overhead in the environment.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_IS_TRANSACTIONAL = "je.env.isTransactional";

    /**
     * If true, create the environment with record locking.  This property
     * should be set to false only in special circumstances when it is safe to
     * run without record locking.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_IS_LOCKING = "je.env.isLocking";

    /**
     * If true, open the environment read-only.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_READ_ONLY = "je.env.isReadOnly";

    /**
     * If true, use latches instead of synchronized blocks to implement the
     * lock table and log write mutexes. Latches require that threads queue to
     * obtain the mutex in question and therefore guarantee that there will be
     * no mutex starvation, but do incur a performance penalty. Latches should
     * not be necessary in most cases, so synchronized blocks are the default.
     * An application that puts heavy load on JE with threads with different
     * thread priorities might find it useful to use latches.  In a Java 5 JVM,
     * where java.util.concurrent.locks.ReentrantLock is used for the latch
     * implementation, this parameter will determine whether they are 'fair' or
     * not.  This parameter is 'static' across all environments.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_FAIR_LATCHES = "je.env.fairLatches";

    /**
     * If true, enable eviction of metadata for closed databases.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String ENV_DB_EVICTION = "je.env.dbEviction";

    /**
     * By default, JE passes an entire log record to the Adler32 class for
     * checksumming.  This can cause problems with the GC in some cases if the
     * records are large and there is concurrency.  Setting this parameter will
     * cause JE to pass chunks of the log record to the checksumming class so
     * that the GC does not block.  0 means do not chunk.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>0</td>
     * <td>0</td>
     * <td>1048576 (1M)</td>
     * </tr>
     * </table></p>
     */
    public static final String ADLER32_CHUNK_SIZE = "je.adler32.chunkSize";

    /**
     * The total memory taken by log buffers, in bytes. If 0, use 7% of
     * je.maxMemory. If 0 and je.sharedCache=true, use 7% divided by N where N
     * is the number of environments sharing the global cache.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>No</td>
     * <td>0</td>
     * <td>{@value
     * com.sleepycat.je.config.EnvironmentParams#LOG_MEM_SIZE_MIN}</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_TOTAL_BUFFER_BYTES =
        "je.log.totalBufferBytes";

    /**
     * The number of JE log buffers.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>{@value
     * com.sleepycat.je.config.EnvironmentParams#NUM_LOG_BUFFERS_DEFAULT}</td>
     * <td>2</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_NUM_BUFFERS = "je.log.numBuffers";

    /**
     * The maximum starting size of a JE log buffer.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>1048576 (1M)</td>
     * <td>1024 (1K)</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_BUFFER_SIZE = "je.log.bufferSize";

    /**
     * The buffer size for faulting in objects from disk, in bytes.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>2048 (2K)</td>
     * <td>32</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_FAULT_READ_SIZE = "je.log.faultReadSize";

    /**
     * The read buffer size for log iterators, which are used when scanning the
     * log during activities like log cleaning and environment open, in bytes.
     * This may grow as the system encounters larger log entries.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>8192 (8K)</td>
     * <td>128</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_ITERATOR_READ_SIZE =
        "je.log.iteratorReadSize";

    /**
     * The maximum read buffer size for log iterators, which are used when
     * scanning the log during activities like log cleaning and environment
     * open, in bytes.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>16777216 (16M)</td>
     * <td>128</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_ITERATOR_MAX_SIZE =
        "je.log.iteratorMaxSize";

    /**
     * The maximum size of each individual JE log file, in bytes.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td><td>JVM</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>No</td>
     * <td>10000000 (10M)</td>
     * <td>1000000 (1M)</td>
     * <td>1073741824 (1G)</td>
     * <td>Conventional JVM</td>
     * </tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>No</td>
     * <td>100000 (100K)</td>
     * <td>10000 (10K)</td>
     * <td>1048576 (1M)</td>
     * <td>Dalvik JVM</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_FILE_MAX = "je.log.fileMax";

    /**
     * If true, perform a checksum check when reading entries from log.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_CHECKSUM_READ = "je.log.checksumRead";

    /**
     * If true, perform a checksum verification just before and after writing
     * to the log.  This is primarily used for debugging.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_VERIFY_CHECKSUMS = "je.log.verifyChecksums";

    /**
     * If true, operates in an in-memory test mode without flushing the log to
     * disk. An environment directory must be specified, but it need not exist
     * and no files are written.  The system operates until it runs out of
     * memory, at which time an OutOfMemoryError is thrown.  Because the entire
     * log is kept in memory, this mode is normally useful only for testing.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_MEM_ONLY = "je.log.memOnly";

    /**
     * The size of the file handle cache.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>100</td>
     * <td>3</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_FILE_CACHE_SIZE = "je.log.fileCacheSize";

    /**
     * The timeout limit for group file sync, in microseconds.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link <a href="#timeDuration">Duration</a>}</td>
     * <td>No</td>
     * <td>500 ms</td>
     * <td>10 ms</td>
     * <td>24 d</td>
     * </tr>
     * </table></p>
     *
     * @see <a href="EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String LOG_FSYNC_TIMEOUT = "je.log.fsyncTimeout";

    /**
     * If true (default is false) O_DSYNC is used to open JE log files.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_USE_ODSYNC = "je.log.useODSYNC";

    /**
     * If true (default is false) NIO is used for all file I/O.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     * @deprecated NIO is no longer used by JE and this parameter has no
     * effect.
     */
    public static final String LOG_USE_NIO = "je.log.useNIO";

    /**
     * If true (default is true) the Write Queue is used for file I/O
     * operations which are blocked by concurrent I/O operations.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_USE_WRITE_QUEUE = "je.log.useWriteQueue";

    /**
     * The size of the Write Queue.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>1MB</td>
     * <td>4KB</td>
     * <td>32MB-</td>
     * </tr>
     * </table></p>
     */
    public static final String LOG_WRITE_QUEUE_SIZE = "je.log.writeQueueSize";

    /**
     * If true (default is false) direct NIO buffers are used.  This setting is
     * only used if {@link #LOG_USE_NIO} is true.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     * @deprecated NIO is no longer used by JE and this parameter has no
     * effect.
     */
    public static final String LOG_DIRECT_NIO = "je.log.directNIO";

    /**
     * If non-0 (default is 0) break all IO into chunks of this size.  This
     * setting is only used if {@link #LOG_USE_NIO} is true.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>No</td>
     * <td>0</td>
     * <td>0</td>
     * <td>67108864 (64M)</td>
     * </tr>
     * </table></p>
     * @deprecated NIO is no longer used by JE and this parameter has no
     * effect.
     */
    public static final String LOG_CHUNKED_NIO = "je.log.chunkedNIO";

    /**
     * The maximum number of entries in an internal btree node.  This can be
     * set per-database using the DatabaseConfig object.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>128</td>
     * <td>4</td>
     * <td>32767 (32K)</td>
     * </tr>
     * </table></p>
     */
    public static final String NODE_MAX_ENTRIES = "je.nodeMaxEntries";

    /**
     * The maximum number of entries in an internal dup btree node.  This can
     * be set per-database using the DatabaseConfig object.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>128</td>
     * <td>4</td>
     * <td>32767 (32K)</td>
     * </tr>
     * </table></p>
     */
    public static final String NODE_DUP_TREE_MAX_ENTRIES =
        "je.nodeDupTreeMaxEntries";

    /**
     * After this many deltas, log a full version.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>10</td>
     * <td>0</td>
     * <td>100</td>
     * </tr>
     * </table></p>
     */
    public static final String TREE_MAX_DELTA = "je.tree.maxDelta";

    /**
     * If less than this percentage of entries are changed on a BIN, log a
     * delta instead of a full version.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>25</td>
     * <td>0</td>
     * <td>75</td>
     * </tr>
     * </table></p>
     */
    public static final String TREE_BIN_DELTA = "je.tree.binDelta";

    /**
     * The minimum bytes allocated out of the memory cache to hold Btree data
     * including internal nodes and record keys and data.  If the specified
     * value is larger than the size initially available in the cache, it will
     * be truncated to the amount available.
     *
     * <p>{@link #TREE_MIN_MEMORY} is the minimum for a single environment.  By
     * default, 500 KB or the size initially available in the cache is used,
     * whichever is smaller.</p>
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>Yes</td>
     * <td>512000 (500K)</td>
     * <td>51200 (50K)</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String TREE_MIN_MEMORY = "je.tree.minMemory";

    /**
     * The compressor thread wakeup interval in microseconds.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link <a href="#timeDuration">Duration</a>}</td>
     * <td>No</td>
     * <td>5 s</td>
     * <td>1 s</td>
     * <td>75 min</td>
     * </tr>
     * </table></p>
     *
     * @see <a href="EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String COMPRESSOR_WAKEUP_INTERVAL =
        "je.compressor.wakeupInterval";

    /**
     * The number of times to retry a compression run if a deadlock occurs.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>3</td>
     * <td>0</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String COMPRESSOR_DEADLOCK_RETRY =
        "je.compressor.deadlockRetry";

    /**
     * The lock timeout for compressor transactions in microseconds.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link <a href="#timeDuration">Duration</a>}</td>
     * <td>No</td>
     * <td>500 ms</td>
     * <td>0</td>
     * <td>75 min</td>
     * </tr>
     * </table></p>
     *
     * @see <a href="EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String COMPRESSOR_LOCK_TIMEOUT =
        "je.compressor.lockTimeout";

    /**
     * If true, when the compressor encounters an empty database, the root node
     * of the Btree is deleted.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     *
     * @deprecated as of 3.3.87.  Compression of the root node no longer has
     * any benefit and this feature has been removed.  This parameter has no
     * effect.
     */
    public static final String COMPRESSOR_PURGE_ROOT =
        "je.compressor.purgeRoot";

    /**
     * When eviction occurs, the evictor will push memory usage to this number
     * of bytes below {@link #MAX_MEMORY}.  No more than 50% of je.maxMemory
     * will be evicted per eviction cycle, regardless of this setting.
     * <p>
     * When using the shared cache feature, the value of this property is
     * applied the first time the cache is set up. New environments that
     * join the cache do not alter the cache setting.
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>No</td>
     * <td>524288 (512K)</td>
     * <td>1024 (1K)</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String EVICTOR_EVICT_BYTES = "je.evictor.evictBytes";

    /**
     * The number of nodes in one evictor scan.
     * <p>
     * When using the shared cache feature, the value of this property is
     * applied the first time the cache is set up. New environments that
     * join the cache do not alter the cache setting.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>10</td>
     * <td>1</td>
     * <td>1000</td>
     * </tr>
     * </table></p>
     */
    public static final String EVICTOR_NODES_PER_SCAN =
        "je.evictor.nodesPerScan";

    /**
     * @deprecated as of JE 4.1, since the single evictor thread has
     * been replaced be a more robust thread pool.
     * The number of times to retry the evictor if it runs into a deadlock.
     * <p>
     * When using the shared cache feature, the value of this property is
     * applied the first time the cache is set up. New environments that
     * join the cache do not alter the cache setting.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>3</td>
     * <td>0</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String EVICTOR_DEADLOCK_RETRY =
        "je.evictor.deadlockRetry";

    /**
     * If true (the default), use an LRU-only policy to select nodes for
     * eviction.  If false, select by Btree level first, and then by LRU.
     * <p>
     * When using the shared cache feature, the value of this property is
     * applied the first time the cache is set up. New environments that
     * join the cache do not alter the cache setting.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String EVICTOR_LRU_ONLY = "je.evictor.lruOnly";

    /**
     * Call Thread.yield() at each check for cache overflow. This improves GC
     * performance on some systems.
     * <p>
     * When using the shared cache feature, the value of this property is
     * applied the first time the cache is set up. New environments that
     * join the cache do not alter the cache setting.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String EVICTOR_FORCED_YIELD = "je.evictor.forcedYield";

    /**
     * The minimum number of threads in the eviction thread pool. These threads
     * help keep memory usage within cache bounds, offloading work from 
     * application threads.
     *
     * je.evictor.coreThreads, je.evictor.maxThreads and je.evictor.keepAlive
     * are used to configure the core, max and keepalive attributes for the
     * ThreadPoolExecutor which implements the eviction thread pool.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>yes</td>
     * <td>1</td>
     * <td>0</td>
     * <td>Integer.MAX_VALUE</td>
     * </tr>
     * </table></p>
     */
    public static final String EVICTOR_CORE_THREADS = "je.evictor.coreThreads";

    /**
     * The maximum number of threads in the eviction thread pool. These threads
     * help keep memory usage within cache bound, offloading work from
     * application threads. If the eviction thread pool receives more work, it
     * will allocate up to this number of threads. These threads will terminate
     * if they are idle for more than the time indicated by je.evictor.keepAlive
     *
     * je.evictor.coreThreads, je.evictor.maxThreads and je.evictor.keepAlive
     * are used to configure the core, max and keepalive attributes for the
     * ThreadPoolExecutor which implements the eviction thread pool.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>yes</td>
     * <td>10</td>
     * <td>1</td>
     * <td>Integer.MAX_VALUE</td>
     * </tr>
     * </table></p>
     */
    public static final String EVICTOR_MAX_THREADS = "je.evictor.maxThreads";

    /**
     * The duration that excess threads in the eviction thread pool will stay
     * idle. After this period, idle threads will terminate.
     *
     * je.evictor.coreThreads, je.evictor.maxThreads and je.evictor.keepAlive
     * are used to configure the core, max and keepalive attributes for the
     * ThreadPoolExecutor which implements the eviction thread pool.
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link <a href="#timeDuration">Duration</a>}</td>
     * <td>Yes</td>
     * <td>10 min</td>
     * <td>1 s</td>
     * <td>1 d</td>
     * </tr>
     * </table></p>
     *
     * @see <a href="EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String EVICTOR_KEEP_ALIVE = "je.evictor.keepAlive";

    /**
     * Ask the checkpointer to run every time we write this many bytes to the
     * log. If set, supercedes {@link #CHECKPOINTER_WAKEUP_INTERVAL}. To use
     * time based checkpointing, set this to 0.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td><td>JVM</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>No</td>
     * <td>20000000 (20M)</td>
     * <td>0</td>
     * <td>-none-</td>
     * <td>Conventional JVM</td>
     * </tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>No</td>
     * <td>200000 (200K)</td>
     * <td>0</td>
     * <td>-none-</td>
     * <td>Dalvik JVM</td>
     * </tr>
     * </table></p>
     */
    public static final String CHECKPOINTER_BYTES_INTERVAL =
        "je.checkpointer.bytesInterval";

    /**
     * The checkpointer wakeup interval in microseconds. By default, this
     * is inactive and we wakeup the checkpointer as a function of the
     * number of bytes written to the log ({@link
     * #CHECKPOINTER_BYTES_INTERVAL}).
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link <a href="#timeDuration">Duration</a>}</td>
     * <td>No</td>
     * <td>0</td>
     * <td>1 s</td>
     * <td>75 min</td>
     * </tr>
     * </table></p>
     *
     * @see <a href="EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String CHECKPOINTER_WAKEUP_INTERVAL =
        "je.checkpointer.wakeupInterval";

    /**
     * The number of times to retry a checkpoint if it runs into a deadlock.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>3</td>
     * <td>0</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String CHECKPOINTER_DEADLOCK_RETRY =
        "je.checkpointer.deadlockRetry";

    /**
     * If true, the checkpointer uses more resources in order to complete the
     * checkpoint in a shorter time interval.  Btree latches are held and other
     * threads are blocked for a longer period.  Log cleaner record migration
     * is performed by cleaner threads instead of lazily during eviction and
     * checkpoints (see {@link #CLEANER_LAZY_MIGRATION}).  When set to true,
     * application response time may be longer during a checkpoint, and more
     * cleaner threads may be required to maintain the configured log
     * utilization.
     *
     * <p>Note that lazy migration is disabled when the {@link
     * #CHECKPOINTER_HIGH_PRIORITY} parameter is set to true, regardless of the
     * {@link #CLEANER_LAZY_MIGRATION} setting.</p>
     *
     * <p><table border"1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String CHECKPOINTER_HIGH_PRIORITY =
        "je.checkpointer.highPriority";

    /**
     * The cleaner will keep the total disk space utilization percentage above
     * this value.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>50</td>
     * <td>0</td>
     * <td>90</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_MIN_UTILIZATION =
        "je.cleaner.minUtilization";

    /**
     * A log file will be cleaned if its utilization percentage is below this
     * value, irrespective of total utilization.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>5</td>
     * <td>0</td>
     * <td>50</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_MIN_FILE_UTILIZATION =
        "je.cleaner.minFileUtilization";

    /**
     * The cleaner checks disk utilization every time we write this many bytes
     * to the log.  If zero (and by default) it is set to the {@link
     * #LOG_FILE_MAX} value divided by four.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Long</td>
     * <td>Yes</td>
     * <td>0</td>
     * <td>0</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_BYTES_INTERVAL =
        "je.cleaner.bytesInterval";

    /**
     * If true, the cleaner will fetch records to determine their size to more
     * accurately calculate log utilization.  This setting is used during DB
     * truncation/removal and during recovery, and will cause more I/O during
     * those operations when set to true.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_FETCH_OBSOLETE_SIZE =
        "je.cleaner.fetchObsoleteSize";

    /**
     * The number of times to retry cleaning if a deadlock occurs.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>3</td>
     * <td>0</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_DEADLOCK_RETRY =
        "je.cleaner.deadlockRetry";

    /**
     * The lock timeout for cleaner transactions in microseconds.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link <a href="#timeDuration">Duration</a>}</td>
     * <td>Yes</td>
     * <td>500 ms</td>
     * <td>0</td>
     * <td>75 min</td>
     * </tr>
     * </table></p>
     *
     * @see <a href="EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String CLEANER_LOCK_TIMEOUT = "je.cleaner.lockTimeout";

    /**
     * If true, the cleaner deletes log files after successful cleaning.  If
     * false, the cleaner changes log file extensions to .DEL instead of
     * deleting them.  The latter is useful for diagnosing log cleaning
     * problems.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_EXPUNGE = "je.cleaner.expunge";

    /**
     * The minimum age of a file (number of files between it and the active
     * file) to qualify it for cleaning under any conditions.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>2</td>
     * <td>1</td>
     * <td>1000</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_MIN_AGE = "je.cleaner.minAge";

    /**
     * The maximum number of log files in the cleaner's backlog, or zero if
     * there is no limit.  Changing this property can impact the performance of
     * some out-of-memory applications.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>0</td>
     * <td>0</td>
     * <td>100000</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_MAX_BATCH_FILES =
        "je.cleaner.maxBatchFiles";

    /**
     * The read buffer size for cleaning.  If zero (the default), then {@link
     * #LOG_ITERATOR_READ_SIZE} value is used.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>0</td>
     * <td>128</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_READ_SIZE = "je.cleaner.readSize";

    /**
     * Tracking of detailed cleaning information will use no more than this
     * percentage of the cache.  The default value is 2% of {@link
     * #MAX_MEMORY}. If 0 and {@link #SHARED_CACHE} is true, use 2% divided by
     * N where N is the number of environments sharing the global cache.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>2</td>
     * <td>1</td>
     * <td>90</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_DETAIL_MAX_MEMORY_PERCENTAGE =
        "je.cleaner.detailMaxMemoryPercentage";

    /**
     * Specifies a list of files or file ranges to be cleaned at a time when no
     * other log cleaning is necessary.  This parameter is intended for use in
     * forcing the cleaning of a large number of log files.  File numbers are
     * in hex and are comma separated or hyphen separated to specify ranges,
     * e.g.: '9,a,b-d' will clean 5 files.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>""</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_FORCE_CLEAN_FILES =
        "je.cleaner.forceCleanFiles";

    /**
     * All log files having a log version prior to the specified version will
     * be cleaned at a time when no other log cleaning is necessary.  Intended
     * for use in upgrading old format log files forward to the current log
     * format version, e.g., to take advantage of format improvements; note
     * that log upgrading is optional.  The default value zero (0) specifies
     * that no upgrading will occur.  The value negative one (-1) specifies
     * upgrading to the current log version.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>0</td>
     * <td>-1</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_UPGRADE_TO_LOG_VERSION =
        "je.cleaner.upgradeToLogVersion";

    /**
     * The number of threads allocated by the cleaner for log file processing.
     * If the cleaner backlog becomes large, try increasing this value.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>1</td>
     * <td>1</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_THREADS = "je.cleaner.threads";

    /**
     * The look ahead cache size for cleaning in bytes.  Increasing this value
     * can reduce the number of Btree lookups.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>Yes</td>
     * <td>8192 (8K)</td>
     * <td>0</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_LOOK_AHEAD_CACHE_SIZE =
        "je.cleaner.lookAheadCacheSize";

    /**
     * If true, the cleaner will fetch log entries (incurring the cost of
     * random I/O) during eviction, Btree splits, and other application
     * foreground thread activities, in order to migrate log entries and reduce
     * the cleaner backlog.
     *
     * <p>This parameter is false by default in order to avoid database
     * operation delays caused by random I/O during eviction and Btree splits.
     * This parameter may be set to true to keep the cleaner backlog from
     * growing when the number of cleaner threads is not sufficient to prevent
     * a backlog.  This should be done only when database operation delays are
     * acceptable. By database operations we mean ordinary record reads and
     * writes ({@code get()} and {@code put()} method calls).</p>
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     *
     * @since 4.0
     */
    public static final String CLEANER_FOREGROUND_PROACTIVE_MIGRATION =
        "je.cleaner.foregroundProactiveMigration";

    /**
     * If true, the cleaner will fetch log entries (incurring the cost of
     * random I/O) during checkpoints and other JE background thread
     * activities, in order to migrate log entries and reduce the cleaner
     * backlog.
     *
     * <p>This parameter is false by default in order to avoid long checkpoint
     * durations caused by random I/O during the checkpoint.  This parameter
     * may be set to true to keep the cleaner backlog from growing when the
     * number of cleaner threads is not sufficient to prevent a backlog.  This
     * should be done only when the resulting duration of the checkpoint is
     * acceptable.</p>
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     *
     * @since 4.0
     */
    public static final String CLEANER_BACKGROUND_PROACTIVE_MIGRATION =
        "je.cleaner.backgroundProactiveMigration";

    /**
     * Controls whether log cleaner threads perform LN (leaf node or record)
     * migration immediately when processing a log file, or lazily during
     * eviction and checkpointing.  LN migration is the copying of active
     * records from the log file being cleaned to the end of the log, prior to
     * deletion of the log file.
     *
     * <p>By default this parameter is true, and LN migration is performed
     * lazily during eviction (when the cache fills) and checkpointing.  
     * LNs are placed into the JE cache by the log cleaner threads as the LNs
     * are read sequentially from the log file, but the LNs are not logged
     * until their parent BIN (Bottom Internal Node) is evicted or
     * checkpointed.  Lazy migration has two potential advantages:</p>
     *
     *   <ul>
     *   <li>Because records are logged when their parent BIN in the Btree is
     *   logged, records are clustered together by key as they are migrated,
     *   even when those records were not originally written in key order.
     *   This has a performance benefit if records with adjacent keys are
     *   frequently accessed together, i.e., locality of reference. However, it
     *   may be undesirable if records are frequently accessed in the order
     *   they were originally written, rather than in key order.</li>
     *
     *   <li>Lazy migration off-loads work from the log cleaner threads to the
     *   application threads (which perform eviction) and the checkpointer
     *   thread, making it easier for the log cleaner to "keep up" with heavy
     *   write activity and maintain the configured log utilization.</li>
     *   </ul>
     *
     * <p>If this parameter is set to false, LN migration will be performed
     * immediately by the log cleaner threads, or by an application thread
     * calling {@link Environment#cleanLog}.  Immediate migration has three
     * potential advantages:<p>
     *
     *   <ul>
     *   <li>Eviction and checkpointing will do less work, because they will
     *   not perform LN migration.  This may result in shorter response times
     *   for application operations, and will definitely result in faster
     *   checkpoints (see {@link #CHECKPOINTER_HIGH_PRIORITY}).  However, more
     *   cleaner threads may be required to maintain the configured log
     *   utilization.</li>
     *
     *   <li>When records are frequently accessed in the order they are written
     *   rather than in key order, immediate migration will preserve their
     *   order in the log.</li>
     *
     *   <li>Migrated LNs will not occupy space in the cache, avoiding possible
     *   interference with an application caching policy.</li>
     *   </ul>
     *
     * <p>Note that lazy migration is disabled when the {@link
     * #CHECKPOINTER_HIGH_PRIORITY} parameter is set to true, regardless of the
     * {@link #CLEANER_LAZY_MIGRATION} setting.</p>
     *
     * <p><table border"1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     */
    public static final String CLEANER_LAZY_MIGRATION =
        "je.cleaner.lazyMigration";

    /**
     * Number of Lock Tables.  Set this to a value other than 1 when an
     * application has multiple threads performing concurrent JE operations.
     * It should be set to a prime number, and in general not higher than the
     * number of application threads performing JE operations.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>1</td>
     * <td>1</td>
     * <td>32767 (32K)</td>
     * </tr>
     * </table></p>
     */
    public static final String LOCK_N_LOCK_TABLES = "je.lock.nLockTables";

    /**
     * The {@link #setLockTimeout(long,TimeUnit) LockTimeout} property.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link <a href="#timeDuration">Duration</a>}</td>
     * <td>No</td>
     * <td>500 ms</td>
     * <td>0</td>
     * <td>75 min</td>
     * </tr>
     * </table></p>
     *
     * @see #setLockTimeout(long,TimeUnit)
     * @see <a href="EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String LOCK_TIMEOUT = "je.lock.timeout";

    /**
     * Whether to throw old-style lock exceptions for compatibility with older
     * JE releases.
     *
     * <p>In JE 3.3 and earlier, {@link DeadlockException} or a subclass of it
     * was always thrown when a lock conflict occurred.  Applications typically
     * caught {@link DeadlockException} in order to detect lock conflicts and
     * determine whether to retry a transaction.  {@link DeadlockException}
     * itself was thrown when a lock or transaction timeout occurred and {@link
     * LockNotGrantedException} (a subclass of {@link DeadlockException}) was
     * thrown when a lock conflict occurred for a no-wait transaction (see
     * {@link TransactionConfig#setNoWait}).</p>
     *
     * <p>In all releases after JE 3.3, new exceptions and the new base class
     * {@link LockConflictException} are available.  Now, {@link
     * LockConflictException} should be caught to handle lock conflicts in a
     * general manner, instead of catching {@link DeadlockException}.  New
     * exceptions are now thrown as follows:
     * <ul>
     * <li>{@link LockTimeoutException} is now thrown when a lock timeout
     * occurs, rather than {@link DeadlockException}.</li>
     * <li>{@link TransactionTimeoutException} is now thrown when a transaction
     * timeout occurs, rather than {@link DeadlockException}.</li>
     * <li>{@link LockNotAvailableException} is now thrown when a lock conflict
     * occurs for a no-wait transaction, rather than {@link
     * LockNotGrantedException}.</li>
     * </ul>
     * <p>These three new exceptions are subclasses of {@link
     * LockConflictException}.  {@link DeadlockException} is also now a
     * subclass of {@link LockConflictException}, but is not currently thrown
     * by JE because true deadlock detection is not used in JE.  Currently,
     * lock timeouts are used instead.  When true deadlock detection is added
     * to JE in the future, {@link DeadlockException} will be thrown. {@link
     * LockNotGrantedException} has been deprecated and replaced by {@link
     * LockNotAvailableException}.</p>
     *
     * <li>The {@link EnvironmentConfig#LOCK_OLD_LOCK_EXCEPTIONS} configuraton
     * parameter may be explicitly set to true to enable the old exception
     * behavior.  By default, this parameter is false.</li>
     *
     * <p>Unless {@link EnvironmentConfig#LOCK_OLD_LOCK_EXCEPTIONS} is set to
     * true, the following changes must be made to JE applications that upgrade
     * from JE 3.3 or earlier.</p>
     * <ol>
     * <li>All occurrences of {@link DeadlockException} must be replaced with
     * {@link LockConflictException} or one of its non-deprecated subclasses
     * ({@link LockTimeoutException}, {@link TransactionTimeoutException}, or
     * {@link LockNotAvailableException}).  It is strongly recommended to
     * replace it with {@link LockConflictException}, since catching this
     * exception will catch true deadlocks in the future and other types of
     * lock conflicts.  All lock conflicts all typically handled in the same
     * way, which is normally to abort and retry the transaction.</li>
     * <li>All occurances of {@link LockNotGrantedException} must be replaced
     * with {@link LockNotAvailableException}.  {@link LockNotGrantedException}
     * has been deprecated because it misleadingly extends {@link
     * DeadlockException}.</li>
     * </ol>
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String LOCK_OLD_LOCK_EXCEPTIONS =
        "je.lock.oldLockExceptions";

    /**
     * The {@link #setTxnTimeout TxnTimeout} property.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>{@link <a href="#timeDuration">Duration</a>}</td>
     * <td>No</td>
     * <td>0</td>
     * <td>0</td>
     * <td>75 min</td>
     * </tr>
     * </table></p>
     *
     * @see #setTxnTimeout
     * @see <a href="EnvironmentConfig.html#timeDuration">Time Duration
     * Properties</a>
     */
    public static final String TXN_TIMEOUT = "je.txn.timeout";

    /**
     * The {@link #setTxnSerializableIsolation TxnSerializableIsolation}
     * property.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     *
     * @see #setTxnSerializableIsolation
     */
    public static final String TXN_SERIALIZABLE_ISOLATION =
        "je.txn.serializableIsolation";

    /**
     * @hidden
     * The {@link #setDurability durability} property.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
      * <td>String</td>
     * <td>Yes</td>
     * <td>null</td>
     * </tr>
     * </table></p>
     *
     * The format of the durability string is described at
     * {@link Durability#parse(String)}
     *
     * @see Durability
     */
    public static final String TXN_DURABILITY = "je.txn.durability";

    /**
     * Set this parameter to true to add stacktrace information to deadlock
     * (lock timeout) exception messages.  The stack trace will show where each
     * lock was taken.  The default is false, and true should only be used
     * during debugging because of the added memory/processing cost.  This
     * parameter is 'static' across all environments.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String TXN_DEADLOCK_STACK_TRACE =
        "je.txn.deadlockStackTrace";

    /**
     * Dump the lock table when a lock timeout is encountered, for debugging
     * assistance.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>Yes</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     */
    public static final String TXN_DUMP_LOCKS = "je.txn.dumpLocks";

    /**
     * Use FileHandler in logging system.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     * @deprecated in favor of <code>FILE_LOGGING_LEVEL</code> As of JE 4.0,
     * use the standard java.util.logging configuration methodologies. To
     * enable logging output to the je.info files, set
     * com.sleepycat.je.util.FileHandler.level = {@literal <LEVEL>} through the
     * java.util.logging configuration file, or through the
     * java.util.logging.LogManager. To set the handler level programmatically,
     * set "com.sleepycat.je.util.FileHandler.level" in the EnvironmentConfig
     * object.
     */
    public static final String TRACE_FILE = "java.util.logging.FileHandler.on";

    /**
     * Enable ConsoleHandler in logging system.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>false</td>
     * </tr>
     * </table></p>
     * @deprecated in favor of <code>CONSOLE_LOGGING_LEVEL</code> As of JE
     * 4.0, use the standard java.util.logging configuration
     * methodologies. To enable console output, set
     * com.sleepycat.je.util.ConsoleHandler.level = {@literal <LEVEL>} through
     * the java.util.logging configuration file, or through the
     * java.util.logging.LogManager. To set the handler level programmatically,
     * set "com.sleepycat.je.util.ConsoleHandler.level" in the
     * EnvironmentConfig object.
     */
    public static final String TRACE_CONSOLE =
        "java.util.logging.ConsoleHandler.on";

    /**
     * Use DbLogHandler in logging system.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Boolean</td>
     * <td>No</td>
     * <td>true</td>
     * </tr>
     * </table></p>
     * @deprecated As of JE 4.0, event tracing to the .jdb files has been
     * separated from the java.util.logging mechanism. This parameter has
     * no effect.
     */
    public static final String TRACE_DB = "java.util.logging.DbLogHandler.on";

    /**
     * Log file limit for FileHandler.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>10000000 (10M)</td>
     * <td>1000</td>
     * <td>1000000000 (1G)</td>
     * </tr>
     * </table></p>
     * @deprecated As of JE 4.0, use the standard java.util.logging
     * configuration methodologies. To set the FileHandler output file size,
     * set com.sleepycat.je.util.FileHandler.limit = {@literal <NUMBER>}
     * through the java.util.logging configuration file, or through the
     * java.util.logging.LogManager.
     */
    public static final String TRACE_FILE_LIMIT =
        "java.util.logging.FileHandler.limit";

    /**
     * Log file count for FileHandler.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td>
     * <td>Default</td><td>Minimum</td><td>Maximum</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>Integer</td>
     * <td>No</td>
     * <td>10</td>
     * <td>1</td>
     * <td>-none-</td>
     * </tr>
     * </table></p>
     * @deprecated As of JE 4.0, use the standard java.util.logging
     * configuration methodologies. To set the FileHandler output file count,
     * set com.sleepycat.je.util.FileHandler.count = {@literal <NUMBER>}
     * through the java.util.logging configuration file, or through the
     * java.util.logging.LogManager.
     */
    public static final String TRACE_FILE_COUNT =
        "java.util.logging.FileHandler.count";

    /**
     * Trace messages equal and above this level will be logged.  Value should
     * be one of the predefined java.util.logging.Level values.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"INFO"</td>
     * </tr>
     * </table></p>
     * @deprecated As of JE 4.0, use the standard java.util.logging
     * configuration methodologies. Set logging levels using class names
     * through the java.util.logging configuration file, or through the
     * java.util.logging.LogManager.
     */
    public static final String TRACE_LEVEL = "java.util.logging.level";

    /**
     * Trace messages equal and above this level will be logged to the 
     * console. Value should be one of the predefined 
     * java.util.logging.Level values.
     * <p>
     * Setting this parameter in the je.properties file or through {@link
     * EnvironmentConfig#setConfigParam} is analogous to setting
     * the property in the java.util.logging properties file or MBean.
     * It is preferred to use the standard java.util.logging mechanisms for
     * configuring java.util.logging.Handler, but this JE parameter is provided
     * because the java.util.logging API doesn't provide a method to set
     * handler levels programmatically.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"OFF"</td>
     * </tr>
     * </table></p>
     * @see <a href="{@docRoot}/../GettingStartedGuide/managelogging.html" 
     * target="_top">Chapter 12. Logging</a>
     */
    public static final String CONSOLE_LOGGING_LEVEL = 
        "com.sleepycat.je.util.ConsoleHandler.level";

    /**
     * Trace messages equal and above this level will be logged to the je.info
     * file, which is in the Environment home directory.  Value should
     * be one of the predefined java.util.logging.Level values.
     * <p>
     * Setting this parameter in the je.properties file or through {@link
     * EnvironmentConfig#setConfigParam} is analogous to setting
     * the property in the java.util.logging properties file or MBean.
     * It is preferred to use the standard java.util.logging mechanisms for
     * configuring java.util.logging.Handler, but this JE parameter is provided
     * because the java.util.logging APIs doesn't provide a method to set
     * handler levels programmatically.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"INFO"</td>
     * </tr>
     * </table></p>
     * @see <a href="{@docRoot}/../GettingStartedGuide/managelogging.html" 
     * target="_top">Chapter 12. Logging</a>
     */
    public static final String FILE_LOGGING_LEVEL = 
        "com.sleepycat.je.util.FileHandler.level";

    /**
     * Lock manager specific trace messages will be issued at this level.
     * Value should be one of the predefined java.util.logging.Level values.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"FINE"</td>
     * </tr>
     * </table></p>
     * @deprecated As of JE 4.0, use the standard java.util.logging
     * configuration methodologies. To see locking logging, set
     * com.sleepycat.je.txn.level = {@literal <LEVEL>} through the
     * java.util.logging configuration file, or through the
     * java.util.logging.LogManager.
     */
    public static final String TRACE_LEVEL_LOCK_MANAGER =
        "java.util.logging.level.lockMgr";

    /**
     * Recovery specific trace messages will be issued at this level.  Value
     * should be one of the predefined java.util.logging.Level values.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"FINE"</td>
     * </tr>
     * </table></p>
     * @deprecated As of JE 4.0, use the standard java.util.logging
     * configuration methodologies. To see recovery logging, set
     * com.sleepycat.je.recovery.level = {@literal <LEVEL>} through the
     * java.util.logging configuration file, or through the
     * java.util.logging.LogManager.
     */
    public static final String TRACE_LEVEL_RECOVERY =
        "java.util.logging.level.recovery";

    /**
     * Evictor specific trace messages will be issued at this level.  Value
     * should be one of the predefined java.util.logging.Level values.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>No</td>
     * <td>"FINE"</td>
     * </tr>
     * </table></p>
     * @deprecated As of JE 4.0, use the standard java.util.logging
     * configuration methodologies. To see evictor logging, set
     * com.sleepycat.je.evictor.level = {@literal <LEVEL>} through the
     * java.util.logging configuration file, or through the
     * java.util.logging.LogManager.
     */
    public static final String TRACE_LEVEL_EVICTOR =
        "java.util.logging.level.evictor";

    /**
     * Cleaner specific detailed trace messages will be issued at this level.
     * Value should be one of the predefined java.util.logging.Level values.
     *
     * <p><table border="1">
     * <tr><td>Name</td><td>Type</td><td>Mutable</td><td>Default</td></tr>
     * <tr>
     * <td>{@value}</td>
     * <td>String</td>
     * <td>Yes</td>
     * <td>"FINE"</td>
     * </tr>
     * </table></p>
     * @deprecated As of JE 4.0, use the standard java.util.logging
     * configuration methodologies. To see cleaner logging, set
     * com.sleepycat.je.cleaner.level = {@literal <LEVEL>} through the
     * java.util.logging configuration file, or through the
     * java.util.logging.LogManager.
     */
    public static final String TRACE_LEVEL_CLEANER =
        "java.util.logging.level.cleaner";

    /**
     * For unit testing, to prevent creating the utilization profile DB.
     */
    private boolean createUP = true;

    /**
     * For unit testing, to prevent writing utilization data during checkpoint.
     */
    private boolean checkpointUP = true;

    private boolean allowCreate = false;

    /**
     * For unit testing, to set readCommitted as the default.
     */
    private boolean txnReadCommitted = false;

    private String nodeName = null;

    /**
     * Creates an EnvironmentConfig initialized with the system default
     * settings.
     */
    public EnvironmentConfig() {
        super();
    }

    /**
     * Creates an EnvironmentConfig which includes the properties specified in
     * the properties parameter.
     *
     * @param properties Supported properties are described in this class
     *
     * @throws IllegalArgumentException If any properties read from the
     * properties param are invalid.
     */
    public EnvironmentConfig(Properties properties)
        throws IllegalArgumentException {

        super(properties);
    }

    /**
     * If true, creates the database environment if it doesn't already exist.
     *
     * @param allowCreate If true, the database environment is created if it
     * doesn't already exist.
     *
     * @return this
     */
    public EnvironmentConfig setAllowCreate(boolean allowCreate) {

        this.allowCreate = allowCreate;
        return this;
    }

    /**
     * Returns a flag that specifies if we may create this environment.
     *
     * @return true if we may create this environment.
     */
    public boolean getAllowCreate() {

        return allowCreate;
    }

    /**
     * Configures the lock timeout.
     *
     * <p>Equivalent to setting the je.lock.timeout parameter in the
     * je.properties file.</p>
     *
     * @param timeout The lock timeout for all transactional and
     * non-transactional operations.  A value of zero disables lock timeouts,
     * meaning that no lock wait time limit is enforced and a deadlocked
     * operation will block indefinitely.  We strongly recommend that a large
     * timeout value, rather than zero, is used when deadlocks are not
     * expected.  That way, a timeout exception will be thrown when an
     * unexpected deadlock occurs.
     *
     * @param unit the {@code TimeUnit} of the timeout value. May be null only
     * if timeout is zero.
     *
     * @return this
     *
     * @throws IllegalArgumentException if the value of timeout is invalid
     *
     * @see Transaction#setLockTimeout(long,TimeUnit)
     */
    public EnvironmentConfig setLockTimeout(long timeout, TimeUnit unit)
        throws IllegalArgumentException {

        DbConfigManager.setDurationVal(props, EnvironmentParams.LOCK_TIMEOUT,
                                       timeout, unit, validateParams);
        return this;
    }

    /**
     * Configures the lock timeout, in microseconds.  This method is equivalent
     * to:
     *
     * <pre>setLockTimeout(long, TimeUnit.MICROSECONDS);</pre>
     *
     * @deprecated as of 4.0, replaced by {@link #setLockTimeout(long,
     * TimeUnit)}.
     */
    public void setLockTimeout(long timeout)
        throws IllegalArgumentException {

        setLockTimeout(timeout, TimeUnit.MICROSECONDS);
    }

    /**
     * Returns the lock timeout setting.
     *
     * @param unit the {@code TimeUnit} of the returned value. May not be null.
     *
     * A value of 0 means no timeout is set.
     */
    public long getLockTimeout(TimeUnit unit) {

        return DbConfigManager.getDurationVal
            (props, EnvironmentParams.LOCK_TIMEOUT, unit);
    }

    /**
     * Returns the lock timeout setting, in microseconds.  This method is
     * equivalent to:
     *
     * <pre>getLockTimeout(TimeUnit.MICROSECONDS);</pre>
     *
     * @deprecated as of 4.0, replaced by {@link #getLockTimeout(TimeUnit)}.
     */
    public long getLockTimeout() {
        return getLockTimeout(TimeUnit.MICROSECONDS);
    }

    /**
     * Configures the database environment to be read only, and any attempt to
     * modify a database will fail.
     *
     * @param readOnly If true, configure the database environment to be read
     * only, and any attempt to modify a database will fail.
     *
     * @return this
     */
    public EnvironmentConfig setReadOnly(boolean readOnly) {

        DbConfigManager.setBooleanVal(props, EnvironmentParams.ENV_RDONLY,
                                      readOnly, validateParams);
        return this;
    }

    /**
     * Returns true if the database environment is configured to be read only.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return true if the database environment is configured to be read only.
     */
    public boolean getReadOnly() {

        return DbConfigManager.getBooleanVal(props,
                                             EnvironmentParams.ENV_RDONLY);
    }

    /**
     * Configures the database environment for transactions.
     *
     * <p>This configuration option should be used when transactional
     * guarantees such as atomicity of multiple operations and durability are
     * important.</p>
     *
     * @param transactional If true, configure the database environment for
     * transactions.
     *
     * @return this
     */
    public EnvironmentConfig setTransactional(boolean transactional) {

        DbConfigManager.setBooleanVal(props, EnvironmentParams.ENV_INIT_TXN,
                                      transactional, validateParams);
        return this;
    }

    /**
     * Returns true if the database environment is configured for transactions.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return true if the database environment is configured for transactions.
     */
    public boolean getTransactional() {

        return DbConfigManager.getBooleanVal(props,
                                             EnvironmentParams.ENV_INIT_TXN);
    }

    /**
     * Configures the database environment for no locking.
     *
     * <p>This configuration option should be used when locking guarantees such
     * as consistency and isolation are not important.  If locking mode is
     * disabled (it is enabled by default), the cleaner is automatically
     * disabled.  The user is responsible for invoking the cleaner and ensuring
     * that there are no concurrent operations while the cleaner is
     * running.</p>
     *
     * @param locking If false, configure the database environment for no
     * locking.  The default is true.
     *
     * @return this
     */
    public EnvironmentConfig setLocking(boolean locking) {

        DbConfigManager.setBooleanVal(props,
                                      EnvironmentParams.ENV_INIT_LOCKING,
                                      locking, validateParams);
        return this;
    }

    /**
     * Returns true if the database environment is configured for locking.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return true if the database environment is configured for locking.
     */
    public boolean getLocking() {

        return DbConfigManager.getBooleanVal
            (props, EnvironmentParams.ENV_INIT_LOCKING);
    }

    /**
     * Configures the transaction timeout.
     *
     * <p>Equivalent to setting the je.txn.timeout parameter in the
     * je.properties file.</p>
     *
     * @param timeout The transaction timeout. A value of 0 turns off
     * transaction timeouts.
     *
     * @param unit the {@code TimeUnit} of the timeout value. May be null only
     * if timeout is zero.
     *
     * @return this
     *
     * @throws IllegalArgumentException If the value of timeout is negative
     *
     * @see Transaction#setTxnTimeout
     */
    public EnvironmentConfig setTxnTimeout(long timeout, TimeUnit unit)
        throws IllegalArgumentException {

        DbConfigManager.setDurationVal(props, EnvironmentParams.TXN_TIMEOUT,
                                       timeout, unit, validateParams);
        return this;
    }

    /**
     * Configures the transaction timeout, in microseconds.  This method is
     * equivalent to:
     *
     * <pre>setTxnTimeout(long, TimeUnit.MICROSECONDS);</pre>
     *
     * @deprecated as of 4.0, replaced by {@link #setTxnTimeout(long,
     * TimeUnit)}.
     */
    public void setTxnTimeout(long timeout)
        throws IllegalArgumentException {

        setTxnTimeout(timeout, TimeUnit.MICROSECONDS);
    }

    /**
     * Returns the transaction timeout.
     *
     * <p>A value of 0 means transaction timeouts are not configured.</p>
     *
     * @param unit the {@code TimeUnit} of the returned value. May not be null.
     *
     * @return The transaction timeout.
     */
    public long getTxnTimeout(TimeUnit unit) {
        return DbConfigManager.getDurationVal
            (props, EnvironmentParams.TXN_TIMEOUT, unit);
    }

    /**
     * Returns the transaction timeout, in microseconds.  This method is
     * equivalent to:
     *
     * <pre>getTxnTimeout(TimeUnit.MICROSECONDS);</pre>
     *
     * @deprecated as of 4.0, replaced by {@link #getTxnTimeout(TimeUnit)}.
     */
    public long getTxnTimeout() {
        return getTxnTimeout(TimeUnit.MICROSECONDS);
    }

    /**
     * Configures all transactions for this environment to have Serializable
     * (Degree 3) isolation.  By setting Serializable isolation, phantoms will
     * be prevented.  By default transactions provide Repeatable Read
     * isolation.
     *
     * The default is false for the database environment.
     *
     * @see LockMode
     *
     * @return this
     */
    public EnvironmentConfig
        setTxnSerializableIsolation(boolean txnSerializableIsolation) {

        DbConfigManager.setBooleanVal
            (props, EnvironmentParams.TXN_SERIALIZABLE_ISOLATION,
             txnSerializableIsolation, validateParams);
        return this;
    }

    /**
     * Returns true if all transactions for this environment has been
     * configured to have Serializable (Degree 3) isolation.
     *
     * @return true if the environment has been configured to have repeatable
     * read isolation.
     *
     * @see LockMode
     */
    public boolean getTxnSerializableIsolation() {

        return DbConfigManager.getBooleanVal
            (props, EnvironmentParams.TXN_SERIALIZABLE_ISOLATION);
    }

    /**
     * For unit testing, sets readCommitted as the default.
     */
    void setTxnReadCommitted(boolean txnReadCommitted) {

        this.txnReadCommitted = txnReadCommitted;
    }

    /**
     * For unit testing, to set readCommitted as the default.
     */
    boolean getTxnReadCommitted() {

        return txnReadCommitted;
    }

    /**
     * If true, the shared cache is used by this environment.
     *
     * <p>By default this parameter is false and this environment uses a
     * private cache.  If this parameter is set to true, this environment will
     * use a cache that is shared with all other open environments in this
     * process that also set this parameter to true.  There is a single shared
     * cache per process.</p>
     *
     * <p>By using the shared cache, multiple open environments will make
     * better use of memory because the cache LRU algorithm is applied across
     * all information in all environments sharing the cache.  For example, if
     * one environment is open but not recently used, then it will only use a
     * small portion of the cache, leaving the rest of the cache for
     * environments that have been recently used.</p>
     *
     * @param sharedCache If true, the shared cache is used by this
     * environment.
     *
     * @return this
     */
    public EnvironmentConfig setSharedCache(boolean sharedCache) {

        DbConfigManager.setBooleanVal
            (props, EnvironmentParams.ENV_SHARED_CACHE, sharedCache,
             validateParams);
        return this;
    }

    /**
     * Returns true if the shared cache is used by this environment.
     *
     * @return true if the shared cache is used by this environment. @see
     * #setSharedCache
     */
    public boolean getSharedCache() {
        return DbConfigManager.getBooleanVal
            (props, EnvironmentParams.ENV_SHARED_CACHE);
    }

    /**
     * Sets the user defined nodeName for the Environment.  If set, exception
     * messages, logging messages, and thread names will have this nodeName
     * included in them.  If a user has multiple Environments in a single JVM,
     * setting this to a string unique to each Environment may make it easier
     * to diagnose certain exception conditions as well as thread dumps.
     *
     * @return this
     */
    public EnvironmentConfig setNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }

    /*
     * Returns the user defined nodeName for the Environment.
     */
    public String getNodeName() {
        return nodeName;
    }

    /* Documentation inherited from EnvironmentMutableConfig.setConfigParam. */
    @Override
    public EnvironmentConfig setConfigParam(String paramName, String value)
        throws IllegalArgumentException {

        DbConfigManager.setConfigParam(props,
                                       paramName,
                                       value,
                                       false, /* requireMutablity */
                                       validateParams,
                                       false  /* forReplication */,
                                       true   /* verifyForReplication */);
        return this;
    }

    /**
     * For unit testing, to prevent creating the utilization profile DB.
     */
    void setCreateUP(boolean createUP) {
        this.createUP = createUP;
    }

    /**
     * For unit testing, to prevent creating the utilization profile DB.
     */
    boolean getCreateUP() {
        return createUP;
    }

    /**
     * For unit testing, to prevent writing utilization data during checkpoint.
     */
    void setCheckpointUP(boolean checkpointUP) {
        this.checkpointUP = checkpointUP;
    }

    /**
     * For unit testing, to prevent writing utilization data during checkpoint.
     */
    boolean getCheckpointUP() {
        return checkpointUP;
    }

    /**
     * Returns a copy of this configuration object.
     */
    @Override
    public EnvironmentConfig clone() {
        return (EnvironmentConfig) super.clone();
    }

    /**
     * Display configuration values.
     */
    @Override
    public String toString() {
        return ("allowCreate=" + allowCreate + "\n" + super.toString());
    }
}
