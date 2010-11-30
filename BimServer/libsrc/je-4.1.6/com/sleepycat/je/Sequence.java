/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2005-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_CACHED_GETS;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_CACHE_LAST;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_CACHE_SIZE;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_CACHE_VALUE;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_GETS;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_RANGE_MAX;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_RANGE_MIN;
import static com.sleepycat.je.dbi.SequenceStatDefinition.SEQUENCE_STORED_VALUE;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.dbi.SequenceStatDefinition;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.LockerFactory;
import com.sleepycat.je.utilint.IntStat;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;

/**
 * A Sequence handle is used to manipulate a sequence record in a
 * database. Sequence handles are opened using the {@link
 * com.sleepycat.je.Database#openSequence Database.openSequence} method.
 */
public class Sequence {

    private static final byte FLAG_INCR = ((byte) 0x1);
    private static final byte FLAG_WRAP = ((byte) 0x2);
    private static final byte FLAG_OVER = ((byte) 0x4);

    /* Allocation size for the record data. */
    private static final int MAX_DATA_SIZE = 50;

    /* Version of the format for fields stored in the sequence record. */
    private static final byte CURRENT_VERSION = 1;

    /* A sequence is a unique record in a database. */
    private final Database db;
    private final DatabaseEntry key;

    /* Persistent fields. */
    private boolean wrapAllowed;
    private boolean increment;
    private boolean overflow;
    private long rangeMin;
    private long rangeMax;
    private long storedValue;

    /* Handle-specific fields. */
    private final int cacheSize;
    private long cacheValue;
    private long cacheLast;
    private int nGets;
    private int nCachedGets;
    private TransactionConfig autoCommitConfig;
    private final Logger logger;

    /*
     * The cache holds the range of values [cacheValue, cacheLast], which is
     * the same as [cacheValue, storedValue) at the time the record is written.
     * At store time, cacheLast is set to one before (after) storedValue.
     *
     * storedValue may be used by other Sequence handles with separate caches.
     * storedValue is always the next value to be returned by any handle that
     * runs out of cached values.
     */

    /**
     * Opens a sequence handle, adding the sequence record if appropriate.
     *
     * @throws IllegalArgumentException via Database.openSequence.
     *
     * @throws IllegalStateException via Database.openSequence.
     */
    Sequence(Database db,
             Transaction txn,
             DatabaseEntry key,
             SequenceConfig config)
        throws SequenceNotFoundException, SequenceExistsException {

        if (db.getDatabaseImpl().getSortedDuplicates()) {
            throw new UnsupportedOperationException
                ("Sequences not supported in databases configured for " +
                 "duplicates");
        }

        SequenceConfig useConfig = (config != null) ?
            config : SequenceConfig.DEFAULT;

        if (useConfig.getRangeMin() >= useConfig.getRangeMax()) {
            throw new IllegalArgumentException
                ("Minimum sequence value must be less than the maximum");
        }

        if (useConfig.getInitialValue() > useConfig.getRangeMax() ||
            useConfig.getInitialValue() < useConfig.getRangeMin()) {
            throw new IllegalArgumentException
                ("Initial sequence value is out of range");
        }

        if (useConfig.getRangeMin() >
            useConfig.getRangeMax() - useConfig.getCacheSize()) {
            throw new IllegalArgumentException
                ("The cache size is larger than the sequence range");
        }

        if (useConfig.getAutoCommitNoSync()) {
            autoCommitConfig =
                DbInternal.getDefaultTxnConfig(db.getEnvironment()).clone();
            autoCommitConfig.overrideDurability(Durability.COMMIT_NO_SYNC);
        } else {
            /* Use the environment's default transaction config. */
            autoCommitConfig = null;
        }

        this.db = db;
        this.key = copyEntry(key);
        logger = db.getEnvironment().getEnvironmentImpl().getLogger();

        /* Perform an auto-commit transaction to create the sequence. */
        Locker locker = null;
        Cursor cursor = null;
        OperationStatus status = OperationStatus.NOTFOUND;
        try {
            locker = LockerFactory.getReadableLocker
                (db.getEnvironment(), txn,
                 db.isTransactional(),
                 false /*retainNonTxnLocks*/,
                 false /*readCommitedIsolation*/);

            cursor = new Cursor(db, locker, null);

            boolean sequenceExists = readData(cursor, null);
            boolean isWritableLocker = !db.getConfig().getTransactional() ||
                (locker.isTransactional() &&
                 !DbInternal.getEnvironmentImpl(db.getEnvironment()).
                 isReplicated());

            if (sequenceExists) {
                if (useConfig.getAllowCreate() &&
                    useConfig.getExclusiveCreate()) {
                    throw new SequenceExistsException
                       ("ExclusiveCreate=true and the sequence record " +
                        "already exists.");
                }
            } else {
                if (useConfig.getAllowCreate()) {
                    if (!isWritableLocker) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        locker.operationEnd(OperationStatus.SUCCESS);

                        locker = LockerFactory.getWritableLocker
                            (db.getEnvironment(),
                             txn,
                             db.isTransactional(),
                             false,
                             db.getDatabaseImpl().isReplicated(),
                             autoCommitConfig);
                        cursor = new Cursor(db, locker, null);
                    }

                    /* Get the persistent fields from the config. */
                    rangeMin = useConfig.getRangeMin();
                    rangeMax = useConfig.getRangeMax();
                    increment = !useConfig.getDecrement();
                    wrapAllowed = useConfig.getWrap();
                    storedValue = useConfig.getInitialValue();

                    /*
                     * To avoid dependence on SerializableIsolation, try
                     * putNoOverwrite first.  If it fails, then try to get an
                     * existing record.
                     */
                    status = cursor.putNoOverwrite(key, makeData());

                    if (!readData(cursor, null)) {
                        /* A retry loop should be performed here. */
                        throw new IllegalStateException
                            ("Sequence record removed during openSequence.");
                    }
                    status = OperationStatus.SUCCESS;
                } else {
                    throw new SequenceNotFoundException
                        ("AllowCreate=false and the sequence record " +
                         "does not exist.");
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (locker != null) {
                locker.operationEnd(status);
            }
        }

        /*
         * cacheLast is initialized such that the cache will be considered
         * empty the first time get() is called.
         */
        cacheSize = useConfig.getCacheSize();
        cacheValue = storedValue;
        cacheLast = increment ? (storedValue - 1) : (storedValue + 1);
    }

    /**
     * Closes a sequence.  Any unused cached values are lost.
     *
     * <p>The sequence handle may not be used again after this method has
     * been called, regardless of the method's success or failure.</p>
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public void close()
        throws DatabaseException {

        /* Defined only for DB compatibility and possible future use. */
    }

    /**
     * Returns the next available element in the sequence and changes the
     * sequence value by <code>delta</code>.  The value of <code>delta</code>
     * must be greater than zero.  If there are enough cached values in the
     * sequence handle then they will be returned.  Otherwise the next value
     * will be fetched from the database and incremented (decremented) by
     * enough to cover the <code>delta</code> and the next batch of cached
     * values.
     *
     * This method is synchronized to protect updating of the cached value,
     * since multiple threads may share a single handle.  Multiple handles for
     * the same database/key may be used to increase concurrency.</p>
     *
     * <p>The <code>txn</code> handle must be null if the sequence handle was
     * opened with a non-zero cache size.</p>
     *
     * <p>For maximum concurrency, a non-zero cache size should be specified
     * prior to opening the sequence handle, the <code>txn</code> handle should
     * be <code>null</code>, and {@link
     * com.sleepycat.je.SequenceConfig#setAutoCommitNoSync
     * SequenceConfig.setAutoCommitNoSync} should be called to disable log
     * flushes.</p>
     *
     * @param txn For a transactional database, an explicit transaction may be
     * specified, or null may be specified to use auto-commit.  For a
     * non-transactional database, null must be specified.
     *
     * @param delta the amount by which to increment or decrement the sequence
     *
     * @return the next available element in the sequence
     *
     * @throws SequenceOverflowException if the end of the sequence is reached
     * and wrapping is not configured.
     *
     * @throws SequenceIntegrityException if the sequence record has been
     * deleted.
     *
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalArgumentException if the delta is less than or equal to
     * zero, or larger than the size of the sequence's range.
     */
    public synchronized long get(Transaction txn, int delta)
        throws DatabaseException {

        /* Check parameters, being careful of overflow. */
        if (delta <= 0) {
            throw new IllegalArgumentException
                ("Sequence delta must be greater than zero");
        }
        if (rangeMin > rangeMax - delta) {
            throw new IllegalArgumentException
                ("Sequence delta is larger than the range");
        }

        /* Status variables for tracing. */
        boolean cached = true;
        boolean wrapped = false;

        /*
         * Determine whether we have exceeded the cache.  The cache size is
         * always <= Integer.MAX_VALUE, so we don't have to worry about
         * overflow here as long as we subtract the two long values first.
         */
        if ((increment && delta > ((cacheLast - cacheValue) + 1)) ||
            (!increment && delta > ((cacheValue - cacheLast) + 1))) {

            cached = false;

            /*
             * We need to allocate delta or cacheSize values, whichever is
             * larger, by incrementing or decrementing the stored value by
             * adjust.
             */
            int adjust = (delta > cacheSize) ? delta : cacheSize;

            /* Perform an auto-commit transaction to update the sequence. */
            Locker locker = null;
            Cursor cursor = null;
            OperationStatus status = OperationStatus.NOTFOUND;
            try {
                locker = LockerFactory.getWritableLocker
                    (db.getEnvironment(),
                     txn,
                     db.isTransactional(),
                     false,                  // retainNonTxnLocks
                     db.getDatabaseImpl().isReplicated(),
                                             // autoTxnIsReplicated
                     autoCommitConfig);

                cursor = new Cursor(db, locker, null);

                /* Get the existing record. */
                readDataRequired(cursor, LockMode.RMW);

                /* If we would have wrapped when not allowed, overflow. */
                if (overflow) {
                    throw new SequenceOverflowException
                        ("Sequence overflow " + storedValue);
                }

                /*
                 * Handle wrapping.  The range size can be larger than a long
                 * can hold, so to avoid arithmetic overflow we use BigInteger
                 * arithmetic.  Since we are going to write, the BigInteger
                 * overhead is acceptable.
                 */
                BigInteger availBig;
                if (increment) {
                    /* Available amount: rangeMax - storedValue */
                    availBig = BigInteger.valueOf(rangeMax).
                        subtract(BigInteger.valueOf(storedValue));
                } else {
                    /* Available amount: storedValue - rangeMin */
                    availBig = BigInteger.valueOf(storedValue).
                        subtract(BigInteger.valueOf(rangeMin));
                }

                if (availBig.compareTo(BigInteger.valueOf(adjust)) < 0) {
                    /* If availBig < adjust then availBig fits in an int. */
                    int availInt = (int) availBig.longValue();
                    if (availInt < delta) {
                        if (wrapAllowed) {
                            /* Wrap to the opposite range end point. */
                            storedValue = increment ? rangeMin : rangeMax;
                            wrapped = true;
                        } else {
                            /* Signal an overflow next time. */
                            overflow = true;
                            adjust = 0;
                        }
                    } else {

                        /*
                         * If the delta fits in the cache available, don't wrap
                         * just to allocate the full cacheSize; instead,
                         * allocate as much as is available.
                         */
                        adjust = availInt;
                    }
                }

                /* Negate the adjustment for decrementing. */
                if (!increment) {
                    adjust = -adjust;
                }

                /* Set the stored value one past the cached amount. */
                storedValue += adjust;

                /* Write the new stored value. */
                cursor.put(key, makeData());
                status = OperationStatus.SUCCESS;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                if (locker != null) {
                    locker.operationEnd(status);
                }
            }

            /* The cache now contains the range: [cacheValue, storedValue) */
            cacheValue = storedValue - adjust;
            cacheLast = storedValue + (increment ? (-1) : 1);
        }

        /* Return the current value and increment/decrement it by delta. */
        long retVal = cacheValue;
        if (increment) {
            cacheValue += delta;
        } else {
            cacheValue -= delta;
        }

        /* Increment stats. */
        nGets += 1;
        if (cached) {
            nCachedGets += 1;
        }

        /* Trace this method at the FINEST level. */
        if (logger.isLoggable(Level.FINEST)) {
            LoggerUtils.finest(logger,
                               db.getEnvironment().getEnvironmentImpl(),
                               "Sequence.get" + " value=" + retVal +
                               " cached=" + cached + " wrapped=" + wrapped);
        }

        return retVal;
    }

    /**
     * Returns the Database handle associated with this sequence.
     *
     * @return The Database handle associated with this sequence.
     */
    public Database getDatabase() {
        return db;
    }

    /**
     * Returns the DatabaseEntry used to open this sequence.
     *
     * @return The DatabaseEntry used to open this sequence.
     */
    public DatabaseEntry getKey() {
        return copyEntry(key);
    }

    /**
     * Returns statistical information about the sequence.
     *
     * <p>In the presence of multiple threads or processes accessing an active
     * sequence, the information returned by this method may be
     * out-of-date.</p>
     *
     * <p>The getStats method cannot be transaction-protected. For this reason,
     * it should be called in a thread of control that has no open cursors or
     * active transactions.</p>
     *
     * @param config The statistics returned; if null, default statistics are
     * returned.
     *
     * @return Sequence statistics.
     *
     * @throws SequenceIntegrityException if the sequence record has been
     * deleted.
     */
    public SequenceStats getStats(StatsConfig config)
        throws DatabaseException {

        if (config == null) {
            config = StatsConfig.DEFAULT;
        }

        if (!config.getFast()) {

            /*
             * storedValue may have been updated by another handle since it
             * was last read by this handle.  Fetch the last written value.
             * READ_UNCOMMITTED must be used to avoid lock conflicts.
             */
            Cursor cursor = db.openCursor(null, null);
            try {
                readDataRequired(cursor, LockMode.READ_UNCOMMITTED);
            } finally {
                cursor.close();
            }
        }

        StatGroup stats = new StatGroup(SequenceStatDefinition.GROUP_NAME,
                                        SequenceStatDefinition.GROUP_DESC);
        new IntStat(stats, SEQUENCE_GETS, nGets);
        new IntStat(stats, SEQUENCE_CACHED_GETS, nCachedGets);
        new IntStat(stats, SEQUENCE_CACHE_SIZE, cacheSize);
        new LongStat(stats, SEQUENCE_STORED_VALUE, storedValue);
        new LongStat(stats, SEQUENCE_CACHE_VALUE, cacheValue);
        new LongStat(stats, SEQUENCE_CACHE_LAST, cacheLast);
        new LongStat(stats, SEQUENCE_RANGE_MIN, rangeMin);
        new LongStat(stats, SEQUENCE_RANGE_MAX, rangeMax);

        SequenceStats seqStats = new SequenceStats(stats);

        if (config.getClear()) {
            nGets = 0;
            nCachedGets = 0;
        }

        return seqStats;
    }

    /**
     * Reads persistent fields from the sequence record.  Throws an exception
     * if the key is not present in the database.
     */
    private void readDataRequired(Cursor cursor, LockMode lockMode)
        throws DatabaseException {

        if (!readData(cursor, lockMode)) {
            throw new SequenceIntegrityException
                ("The sequence record has been deleted while it is open.");
        }
    }

    /**
     * Reads persistent fields from the sequence record.  Returns false if the
     * key is not present in the database.
     */
    private boolean readData(Cursor cursor, LockMode lockMode)
        throws DatabaseException {

        /* Fetch the sequence record. */
        DatabaseEntry data = new DatabaseEntry();
        OperationStatus status = cursor.getSearchKey(key, data, lockMode);
        if (status != OperationStatus.SUCCESS) {
            return false;
        }
        ByteBuffer buf = ByteBuffer.wrap(data.getData());

        /* Get the persistent fields from the record data. */
        byte version = buf.get();
        byte flags = buf.get();
        boolean unpacked = (version < 1);
        rangeMin = LogUtils.readLong(buf, unpacked);
        rangeMax = LogUtils.readLong(buf, unpacked);
        storedValue = LogUtils.readLong(buf, unpacked);

        increment = (flags & FLAG_INCR) != 0;
        wrapAllowed = (flags & FLAG_WRAP) != 0;
        overflow = (flags & FLAG_OVER) != 0;

        return true;
    }

    /**
     * Makes a storable database entry from the persistent fields.
     */
    private DatabaseEntry makeData() {

        byte[] data = new byte[MAX_DATA_SIZE];
        ByteBuffer buf = ByteBuffer.wrap(data);

        byte flags = 0;
        if (increment) {
            flags |= FLAG_INCR;
        }
        if (wrapAllowed) {
            flags |= FLAG_WRAP;
        }
        if (overflow) {
            flags |= FLAG_OVER;
        }

        buf.put(CURRENT_VERSION);
        buf.put(flags);
        LogUtils.writePackedLong(buf, rangeMin);
        LogUtils.writePackedLong(buf, rangeMax);
        LogUtils.writePackedLong(buf, storedValue);

        return new DatabaseEntry(data, 0, buf.position());
    }

    /**
     * Returns a deep copy of the given database entry.
     */
    private DatabaseEntry copyEntry(DatabaseEntry entry) {

        int len = entry.getSize();
        byte[] data;
        if (len == 0) {
            data = LogUtils.ZERO_LENGTH_BYTE_ARRAY;
        } else {
            data = new byte[len];
            System.arraycopy
                (entry.getData(), entry.getOffset(), data, 0, data.length);
        }

        return new DatabaseEntry(data);
    }
}
