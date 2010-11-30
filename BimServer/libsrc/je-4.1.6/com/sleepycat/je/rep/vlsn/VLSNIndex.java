/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.vlsn;

import static com.sleepycat.je.utilint.VLSN.NULL_VLSN;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.bind.tuple.LongBinding;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Durability;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.TransactionConfig;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogItem;
import com.sleepycat.je.recovery.RecoveryInfo;
import com.sleepycat.je.rep.impl.RepParams;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.vlsn.VLSNRange.VLSNRangeBinding;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.VLSN;

/**
 * A VLSN (Virtual LSN) is used to identify every log entry shared between
 * members of the replication group. Since a JE log is identified by LSNs, we
 * must have a way to map VLSN->LSNs in order to fetch a replicated log record
 * from the local log, using the VLSN.  The VLSNIndex implements those
 * mappings. The VLSNIndex has these responsibilities:
 *
 * Generating new VLSNs.
 *   Only masters need to generate VLSNs, but any node may have the potential
 *   to be a master. The VLSN sequence must ascend over time and across
 *   recoveries, so the VSLN id must be preserved much like the database, node
 *   and txn ids.
 * Maintaining the VLSN range.
 *   Although each node needs to receive and store each log entry from the
 *   replication stream, over time the part of the stream that is stored can be
 *   reduced, either by log cleaning, or by syncups which can truncate the
 *   replication stream. A node always holds a contiguous portion of the
 *   replication stream. The VLSN range identifies that portion by having the
 *   start and end VLSNs, as well as key landmarks such as the lastSync-able
 *   log entry and the last commit log entry. VLSN range information is used by
 *   elections and syncup.
 * Gatekeeper for waiting for the most recently logged entries.
 *   Feeders block upon the VLSNIndex when they are trying to fetch the most
 *   recently logged entries. These recent log entries are held in a two level
 *   cache within the VLSNIndex. A call to VLSNIndex.waitForLsn() goes through
 *   this sequence:
 *   1) check the log item stored in the vlsn wait latch, if the call did wait.
 *   2) check the log item cache
 *   If both fail, the FeederReader will fetch the required log entry from log
 *   buffers or disk
 * Providing the LSN mapping for a log record identified by its VLSN.
 *   The Feeders and the syncup protocol both need to retrieve log records
 *   by VLSN. To do that, we need an LSN mapping.
 *
 * Mappings are added to VLSNIndex when replicated log entries are written into
 * the local log.  Although all mappings are registered, the VLSNIndex does not
 * keep every one, in order to save on disk and in-memory storage. Only a
 * sparse set is kept. When searching for a log entry by VLSN, the caller uses
 * the closest available mapping and then scans the log looking for that entry.
 *
 * The VLSNIndex relies on the assumption that VLSN tagged log entries are
 * ordered and contiguous in the log. That is, the LSN for VLSN 1 is < the LSN
 * for VLSN 2 < LSN for VLSN 3, and there is never a gap in the VLSNs. However,
 * at node syncup, the replication stream may need to be truncated when rolling
 * back a non-committed log entry. We can't literally truncate the log files
 * because the JE logs contain intermingled transactional and non transactional
 * information. Instead, the truncation is done both logically by amending the
 * VLSNIndex, and physically by overmarking those entries in the JE
 * logs. Because of that, a physical dump of the log may show some VLSN tagged
 * entries as duplicate and/or out of order because they're abandoned log
 * entries that are not logically part of the replication stream any more
 * For example, the log can look like this:
 *  LSN 100, VLSN 1
 *  LSN 200, VLSN 2  <- overmarked
 *  LSN 300, VLSN 3  <- overmarked
 *   --- syncup, rollback to VLSN 1, restart at VLSN 2
 *  LSN 400, VLSN 2
 *  LSN 500, VLSN 3
 *
 * VLSN->LSN mappings are created under the log write latch, which ensures that
 * all VLSN tagged log entries are ordered in the logical replication stream in
 * the log. However, the mapping is added to the VLSNIndex outside the log
 * write latch, so the VLSNIndex database may have a momentary gap. For
 * example,
 *
 *  t0- thread 1 logs entry at VLSN=1, LSN=100, within log write latch
 *  t1- thread 2 logs entry at VLSN=2, LSN=150, within log write latch
 *  t2- thread 3 logs entry at VLSN=3, LSN=200, within log write latch
 *  t3- thread 1 calls VLSNIndex.put(VLSN=1/LSN=100)
 *  t4- thread 3 calls VLSNIndex.put(VLSN=3/LSN=200)
 *  t5- thread 2 calls VLSNIndex.put(VLSN=2/LSN=150)
 *
 * At t4, the VLSNIndex contains 1/100, 3/200, but not 2/150. However, we know
 * that the VLSNIndex always represents a contiguous range of VLSNs, so the
 * fact that 2/150 is not yet is handled, and is just like the case where
 * the VLSNIndex optimized away the mapping in order to keep the index sparse.
 *
 * We do guarantee that the start and end VLSNs in the range have mappings, in
 * order to always be able to provide a LTE and GTE mapping for all valid
 * VLSNs. Because of that, if a VLSN comes out of order, it does not update the
 * range.
 *
 * Persistent storage:
 *
 *  The VLSN->LSN mappings in the range are grouped into instances of
 *  com.sleepycat.je.util.VLSNBucket. Each bucket knows the first and last VLSN
 *  within its mini-range. We observe these invariants
 *    - buckets are ordered by VLSN in the database and the bucket cache,
 *    - only the last bucket is the target of updates at any time,
 *    - a single bucket corresponds to a single file, but a single file may
 *  have multiple buckets covering it.
 *
 *  While it would be nice to also guarantee that there are no gaps between
 *  buckets, ie:
 *    bucket(N-1).last == bucket(N).first - 1
 *    bucket(N).last  ==  bucket(N-1).first - 1
 *  it is not possible to do so because we the put() call is not serialized
 *  because we don't want to add overhead to the log write latch. In order
 *  to permit out of order puts(), and to require that only the last bucket
 *  is updated, we must permit gaps between buckets.
 *
 *  Buckets are both cached in memory by the VLSNIndex and are stored
 *  persistently in a internal, non-replicated database. The database holds
 *  key/value pairs where
 *
 *    key = bucket.first
 *    data = bucket
 *
 * Since the first valid VLSN is 1, key = -1 is reserved for storage of the
 * VLSNRange.
 *
 * Buckets are filled up as new VLSNs arrive (either because they've been
 * generated by write operations on the master, or because they're incoming
 * operations on the replica). They're flushed to disk periodically rather than
 * with every new VLSN, because the update rate would have too much of a
 * performance impact. Since there is this level of caching happening, we must
 * be careful to write in-memory buckets to disk at well known points to
 * support recoverability. The flushing must be instigated by a third party
 * activity, such as checkpointing, rather than by the action of adding a new
 * mapping. That's because mappings are registered by the logging system, and
 * although we are not holding the log write latch at that point, it seems
 * inadvisable to recursively generate another logging call on behalf of the
 * flush.  Currently the VLSNIndex is flushed to disk at every checkpoint.  It
 * can also optionally happen more often, and (TODO) we may want to do so
 * because we've seen cases where checkpoints take a very long time. Perhaps we
 * should flush when we flip to a new log file?
 *
 * Once written to disk, the buckets are generally not updated. Updates can
 * happen when the range is truncated, such as for syncup rollback, but the
 * system is quiescent at that time. Log cleaning can delete buckets, but will
 * not modify them. The VLSNRange does naturally change often, and that data
 * record does get updated.
 *
 * Recovery:
 *
 * The VLSN database is restored at recovery time just as all other databases
 * are. However, there may be a portion of the VLSN range that was not flushed
 * to disk. At recovery, we piggyback onto the log scanning done and re-track
 * the any mappings found within the recovery range. Those mappings are merged
 * into those stored on disk, so that the VLSNIndex correctly reflects the
 * entire replication stream at startup. For example, suppose a log has:
 *
 * LSN
 * 100      firstActiveLSN
 * 200      Checkpoint start
 * 300      VLSN 78
 * 400      VLSNIndex flushed here
 * 500      Checkpoint end
 * 600      VLSN 79
 *
 * The VLSNIndex is initially populated with the version of the index found
 * at LSN 400. That doesn't include VLSN 79. A tracking pass is done from
 * checkpoint start -> end of log, which sweeps up VLSN 78 and VLSN 79 into
 * a temporary tracker. That tracker is merged in the VLSNIndex, to update
 * its mappings to VLSN 79.
 *
 * Retrieving mappings:
 *
 * Callers who need to retrieve mappings obtain a VLSNScanner, which acts as a
 * cursor over the VLSNIndex. A VLSNScanner finds and saves the applicable
 * VLSNBucket, and queries the bucket directly as long as it can provide
 * mappings. This reduces the level of contention between multiple readers
 * (feeders) and writers (application threads, or the replay thread)
 *
 * Synchronization hierarchy:
 *
 * To write a new mapping, you must have the mutex on the VLSIndex, and then
 * the tracker, which lets you obtain the correct bucket, and then you must
 * have a mutex on the bucket. To read a mapping, you must have the tracker
 * mutex to obtain the right bucket. If you already have the right bucket in
 * hand, you only need the bucket mutex.
 *
 * In truth, buckets which are not the "currentBucket" are not modified again,
 * so a future optimization would allow for reading a mapping on a finished
 * bucket without synchronization.
 *
 * The VLSNRange is updated as an atomic assignment to a volatile field after
 * taking the mutex on the current bucket. It is read without a mutex, by
 * looking at it as a volatile field.
 *
 * The hierarchy is
 *   VLSNIndex -> VLSNTracker -> VLSNBucket
 *   VLSNIndex -> VLSNTracker -> VLSNRange
 *   VLSNIndex -> VLSNIndex.mappingSynchronizer
 *   VLSNIndex.flushSynchronizer -> VLSNTracker
 *
 * Removing mappings vs reading mappings - sync on the range.
 *
 * We also need to consider that fact that callers of the VLSNIndex may be
 * holding other mutex, or IN latches, and that the VLSNIndex methods may do
 * database operations to read or write to the internal VLSN database. That can
 * result in a nested database operation, and we need to be careful to avoid
 * deadlocks. To be safe, we disable critical eviction [#18475]
 * VLSNBucket.writeDatabase().
 *
 * Writers
 * -------
 *
 * Adding a mapping: put()
 *   - sync on VLSNIndex
 *        -sync on VLSNTracker to access the right bucket, and possibly
 *         create a new bucket. Atomically modify the VLSNRange.
 *
 * Flushing mappings to disk: writeToDatabase()
 *    - sync on VLSNIndex.flushSyncrhonizer -> VLSNTracker
 *
 * Replica side syncup truncates the VLSNIndex from the end:
 *    - no synchronization needed, the system is quiescent, and we can assume
 *      that VLSNs are neither read nor written by other threads.
 *
 * Log cleaning truncates the VLSNIndex from the beginning:
 *    We assume that the log cleaner is prohibited from deleting files that are
 *    being used for current feeding. We can also assume that the end of the
 *    log is not being deleted, and that we're not conflict with put(). We do
 *    have to worry about conflicting with backwards scans when executing
 *    syncup as a feeder, and with flushing mappings to disk. Shall we
 *    disable log file deletion at this point?
 *
 *   Steps to take:
 *
 *    First change the VLSNRange:
 *    - sync on VLSNIndex
 *           - atomically modify the VLSNRange to ensure that no readers or
 *             writers touch the buckets that will be deleted.
 *           - sync on VLSNTracker to delete any dead buckets. Do that before
 *             updating the on-disk database, so that we don't lose any
 *             buckets to writeToDatabase().
 *     - without synchronization, scan the database and non-transactionally
 *       delete any on-disk buckets that are <= the log cleaned file.
 *
 * Readers
 * -------
 * Active forward feeder checks if a mapping exists, and waits if necessary
 *    - read the current VLSNRange w/out a mutex. If not satisfactory
 *        - sync on VLSNIndex
 *              - sync on VLSNIndex.mappingSyncrhonizer
 *
 * Active forward feeder reads a mapping:
 *  first - getBucket()
 *     - sync on VLSNTracker to access the right bucket
 *  if bucket is in hand
 *    - sync on target bucket to read bucket
 */
public class VLSNIndex {

    private final EnvironmentImpl envImpl;

    /*
     * VLSN waiting: A Feeder may block waiting for the next available record
     * in the replication stream.

     * vlsnPutLatch -      Latch used to wait for the next VLSN put operation.
     * putWaitVLSN -       The VLSN associated with the vlsnPutLatch, it's only
     *                     meaningful in the presence of a latch.
     */
    private VLSNAwaitLatch vlsnPutLatch = null;
    private VLSN putWaitVLSN = null;

    /*
     * Consider replacing the mapping synchronizer with a lower overhead and
     * multi-processor friendly CAS style nowait code sequence.
     */
    private final Object mappingSynchronizer = new Object();
    private final Object flushSynchronizer = new Object();
    private final Logger logger;

    /*
     * nextVLSNCounter is incremented under the log write latch, when used on
     * the master. If this node transitions from replica to master, this
     * counter must be initialized before write operations begin.
     */
    private AtomicLong nextVLSNCounter;

    /*
     * For storing the persistent version of the VLSNIndex. For keys > 0,
     * the key is the VLSN sequence number, data = VLSNBucket. Key = -1 has
     * a special data item, which is the VLSNRange.
     */
    private DatabaseImpl mappingDbImpl;

    /*
     * The tracker handles the real mechanics of maintaining the VLSN range
     * and mappings.
     */
    private VLSNTracker tracker;

    /*
     * A wait-free cache of the most recent log items in the VLSN index. These
     * items are important since they are the ones needed by the feeders that
     * are responsible for supplying timely commit acknowledgments.
     */
    private final LogItemCache logItemCache;

    /**
     * The mapping db's name is passed in as a parameter instead of the more
     * intuitive approach of defining it within the class to facilitate unit
     * testing of the VLSNIndex.
     */
    public VLSNIndex(EnvironmentImpl envImpl,
                     String mappingDbName,
                     NameIdPair nameIdPair,
                     int vlsnStride,
                     int vlsnMaxMappings,
                     int vlsnMaxDistance,
                     RecoveryInfo recoveryInfo)
        throws DatabaseException {

        this.envImpl = envImpl;

        /*
         * initialize the logger early so it can be used by the following
         * methods. 
         */
        logger = LoggerUtils.getLogger(getClass());

        init(mappingDbName,
             vlsnStride,
             vlsnMaxMappings,
             vlsnMaxDistance,
             recoveryInfo);

        logItemCache = new LogItemCache(envImpl.getConfigManager().
                                        getInt(RepParams.VLSN_LOG_CACHE_SIZE));
    }

    /**
     * Initialize before this node begins working as a master. This node may
     * become a Master directly after recovery, or it may transition to the
     * master state after running for some time as a Replica.
     * <p>
     * Reset the vlsnIndex so the VLSN sequence corresponds to what this node
     * thinks is the next VLSN.
     */
    public void initAsMaster() {
        VLSN last = tracker.getRange().getLast();
        if (last.equals(VLSN.NULL_VLSN)) {

            /*
             * If the master does the conversion, the started VLSN should start
             * from 2 so that Replica would throw a LogRefreshRequiredException
             * and do a NetworkRestore to copy the master logs.
             */
            nextVLSNCounter =
                envImpl.needConvert() ? new AtomicLong(1) : new AtomicLong(0);
        } else {
            nextVLSNCounter = new AtomicLong(last.getSequence());
        }
    }

    /*
     * Return the VLSN to use for tagging the next replicated log entry. Must
     * be called within the log write latch.
     */
    public VLSN bump() {
        return new VLSN(nextVLSNCounter.incrementAndGet());
    }

    /*
     * Restore the VLSN if the target log entry couldn't be logged. Must
     * be called within the log write latch. If decrement is called, the i/o
     * to log the entry failed, and put() was not called, so there is no
     * need to update the range or bucket.
     */
    public void decrement() {
        nextVLSNCounter.decrementAndGet();
    }

    /*
     * Register a new VLSN->LSN mapping.  This is called outside the log write
     * latch, but within the LogManager log() call. It must not cause any
     * logging of its own and should not cause I/O.
     */
    public void put(LogItem logItem) {

        final VLSN vlsn  = logItem.getHeader().getVLSN();
        final long lsn = logItem.getNewLsn();
        final byte entryType = logItem.getHeader().getType();

        logItemCache.put(vlsn, logItem);

        synchronized (this) {
            tracker.track(vlsn, lsn, entryType);

            synchronized (mappingSynchronizer) {

                /*
                 * Put() calls may come out of order, so free the wait latch if
                 * the incoming VLSN >= the waiting VLSN. For example, a feeder
                 * may be awaiting VLSN 100, but the call to put(101) comes in
                 * before the call to put(100).
                 */
                if ((vlsnPutLatch != null) &&
                    vlsn.compareTo(putWaitVLSN) >= 0) {
                    vlsnPutLatch.setLogItem(logItem);
                    vlsnPutLatch.countDown();
                    vlsnPutLatch = null;
                    putWaitVLSN = null;
                }
            }
        }

        if (logger.isLoggable(Level.FINEST)) {
            LoggerUtils.finest(logger, envImpl, "vlsnIndex put " + vlsn);
        }
    }

    /**
     * Wait for the vlsn, or a higher numbered vlsn, to make its appearance in
     * the VLSN index.
     *
     * @throws InterruptedException
     * @throws WaitTimeOutException if the VLSN did not appear within waitTime
     * or the latch was explicitly terminated.
     *
     * @return the LogItem associated with the vlsn, or null if the entry is
     * now present in the log, but is not available in the LogItemCache.
     */
    public LogItem waitForVLSN(VLSN vlsn, int waitTime)
        throws InterruptedException, WaitTimeOutException {

        /* First check the volatile range field, without synchronizing. */
        VLSNRange useRange = tracker.getRange();
        if (useRange.getLast().compareTo(vlsn) >= 0) {
            return logItemCache.get(vlsn);
        }

        VLSNAwaitLatch waitLatch = null;
        synchronized (this) {
            useRange = tracker.getRange();
            if (useRange.getLast().compareTo(vlsn) >= 0) {
                return logItemCache.get(vlsn);
            }

            synchronized (mappingSynchronizer) {
                /* The target VLSN hasn't arrived yet, we'll wait. */
                setupWait(vlsn);

                /* Copy the latch while synchronized. */
                waitLatch = vlsnPutLatch;
            }
        }

        /*
         * Do any waiting outside the synchronization section. If the
         * waited-for VLSN has already arrived, the waitLatch will have been
         * counted down, and we'll go through.
         */
        if (!waitLatch.await(waitTime, TimeUnit.MILLISECONDS) ||
            waitLatch.isTerminated()) {
            /* Timed out waiting for an incoming VLSN, or was terminated. */
            throw new WaitTimeOutException();
        }

        if (! (tracker.getRange().getLast().compareTo(vlsn) >= 0)) {
            throw EnvironmentFailureException.
            unexpectedState(envImpl, "Waited for vlsn:" + vlsn + 
                            " should be greater than last in range:" + tracker.getRange().getLast());
        }
        LogItem logItem = waitLatch.getLogItem();
        /* If we waited successfully, logItem can't be null. */
        return logItem.getHeader().getVLSN().equals(vlsn) ?
               logItem :
               /*
                * An out-of-order vlsn put, that is, a later VLSN arrived at
                * the index before this one. We could look for it in the log
                * item cache, but due to the very nature of the out of order
                * put it's unlikely to be there and we would rather not incur
                * the overhead of a failed lookup.
                */
               null;
    }

    /**
     * Setup the context for waiting for a not-yet-registered VLSN.
     */
    private void setupWait(VLSN vlsn) {
        if (vlsnPutLatch == null) {
            putWaitVLSN = vlsn;
            vlsnPutLatch = new VLSNAwaitLatch();
        } else {
            /* There can only be on possible VLSN to wait on. */
            if (!vlsn.equals(putWaitVLSN)) {
                throw EnvironmentFailureException.unexpectedState
                    (envImpl, "unexpected get for VLSN: " + vlsn +
                     "already waiting for VLSN: " + putWaitVLSN);
            }
        }
    }

    /**
     * Remove all information from the VLSNIndex for VLSNs <= deleteEndpoint.
     * Used by log cleaning. To properly coordinate with readers of the
     * VLSNIndex, we need to update the range before updating the buckets.
     *
     * We assume that deleteEnd is always the last vlsn in a file, and because
     * of that, truncations will never split a bucket.
     *
     * A truncation may leave a gap at the head of the vlsn index though.
     * This could occur if the buckets have a gap, due to out of order VLSNs.
     * For example, it's possible that the index has these buckets:
     *
     * bucket A: firstVLSN = 10, lastVLSN = 20
     * bucket B: firstVLSN = 22, lastVLSN = 30
     *
     * If we truncate the index at 20 (deleteEnd == 20), then the resulting
     * start of the range is 21, but the first bucket value is 22. In this
     * case, we need to insert a ghost bucket.
     *
     * @throws DatabaseException
     */
    public synchronized void truncateFromHead(VLSN deleteEnd,
                                              long deleteFileNum)
        throws DatabaseException {

        LoggerUtils.fine(logger, envImpl, 
                         "head truncate called with " + deleteEnd +
                         " delete file#:" + deleteFileNum);

        logItemCache.clear();

        if (deleteEnd.equals(VLSN.NULL_VLSN)) {
            return;
        }

        /*
         * Check the VLSN found in the deleted file against the existing
         * mappings. The range should not be empty, and doing the truncation
         * should not remove the last sync pont. We assume that once this
         * environment has received any portion of the replication stream, it
         * will maintain a minimum set of VLSNs.
         */
        VLSNRange currentRange = tracker.getRange();
        if (currentRange.getFirst().compareTo(deleteEnd) > 0) {
            /* deleteEnd has already been cast out of the index. */
            return;
        }

        if (currentRange.isEmpty()) {
            throw EnvironmentFailureException.unexpectedState
                (envImpl, "Didn't expect current range to be empty. " +
                 " End of delete range = " +  deleteEnd);
        }

        if (!currentRange.getLastSync().equals(NULL_VLSN) &&
            (deleteEnd.compareTo(currentRange.getLastSync()) > 0)) {
            throw EnvironmentFailureException.unexpectedState
                (envImpl, "Can't log clean away last matchpoint. DeleteEnd= " +
                 deleteEnd + " lastSync=" + currentRange.getLastSync());
        }

        /*
         * Now that the sanity checks are over, update the in-memory, cached
         * portion of the index. Since the range is the gatekeeper, update
         * the tracker cache before the database, so that the range is
         * adjusted first.
         */
        tracker.truncateFromHead(deleteEnd, deleteFileNum);

        TransactionConfig config = new TransactionConfig();
        config.setDurability(Durability.COMMIT_NO_SYNC);
        Txn txn = Txn.createLocalTxn(envImpl, config);
        boolean success = false;
        try {
            synchronized (flushSynchronizer) {
                pruneDatabaseHead(deleteEnd, deleteFileNum, txn);
                flushToDatabase(txn);
            }
            txn.commit();
            success = true;
        } finally {
            if (!success) {
                txn.abort();
            }
        }
    }

    /**
     * Remove all information from the VLSNIndex for VLSNs >= deleteStart
     * Used by replica side syncup, when the log is truncated. Assumes that the
     * vlsnIndex is quiescent.
     * @throws DatabaseException
     */
    public synchronized void truncateFromTail(VLSN deleteStart, long lastLsn)
        throws DatabaseException {

        logItemCache.clear();
        VLSNRange currentRange = tracker.getRange();
        if (currentRange.getLast().getNext().equals(deleteStart)) {

            /*
             * deleteStart directly follows what's in this range, no need to
             * delete anything.
             */
            return;
        }

        tracker.truncateFromTail(deleteStart, lastLsn);

        TransactionConfig config = new TransactionConfig();
        config.setDurability(Durability.COMMIT_NO_SYNC);
        Txn txn = Txn.createLocalTxn(envImpl, config);
        boolean success = false;
        try {
            pruneDatabaseTail(deleteStart, lastLsn, txn);
            flushToDatabase(txn);
            txn.commit();
            success = true;
        } finally {
            if (!success) {
                txn.abort();
            }
        }
    }

    /**
     * All range points (first, last, etc) ought to be seen as one consistent
     * group. Because of that, VLSNIndex doesn't offer getLastVLSN,
     * getFirstVLSN type methods, to discourage the possibility of retrieving
     * range points across two different range sets.
     */
    public VLSNRange getRange() {
        return tracker.getRange();
    }

    /**
     * Return the nearest file number <= the log file that houses this VLSN.
     * This method is meant to be efficient and will not incur I/O. If
     * there is no available, it does an approximation. The requested VLSN
     * must be within the VLSNIndex range.
     * @throws DatabaseException
     */
    public long getLTEFileNumber(VLSN vlsn)
        throws DatabaseException {

        VLSNBucket bucket = getLTEBucket(vlsn);
        return bucket.getLTEFileNumber();
    }

    /**
     * Get the vlsnBucket that owns this VLSN. If there is no such bucket, get
     * the bucket that follows this VLSN. Must always return a bucket.
     * @throws DatabaseException
     */
    private VLSNBucket getGTEBucket(VLSN vlsn)
        throws DatabaseException {

        VLSNBucket bucket = tracker.getGTEBucket(vlsn);

        if (bucket == null) {
            return getGTEBucketFromDatabase(vlsn);
        }

        return bucket;
    }

    /**
     * Get the vlsnBucket that owns this VLSN. If there is no such bucket, get
     * the bucket that precedes this VLSN. Must always return a bucket.
     * @throws DatabaseException
     */
    private VLSNBucket getLTEBucket(VLSN vlsn)
        throws DatabaseException {

        VLSNBucket bucket = tracker.getLTEBucket(vlsn);
        if (bucket == null) {
            return getLTEBucketFromDatabase(vlsn);
        }
        return bucket;
    }

    /**
     * @return true if the status and key value indicate that this
     * cursor is pointing at a valid bucket. Recall that the VLSNRange is
     * stored in the same database at entry -1.
     */
    private boolean isValidBucket(OperationStatus status,
                                  DatabaseEntry key) {

        return ((status == OperationStatus.SUCCESS)  &&
                (LongBinding.entryToLong(key) != VLSNRange.RANGE_KEY));
    }

    /*
     * Get the bucket that matches this VLSN. If this vlsn is Y, then we want
     * bucket at key X where X <= Y. If this method is called, we guarantee
     * that a non-null bucket will be returned.
     */
    public VLSNBucket getLTEBucketFromDatabase(VLSN vlsn)
        throws DatabaseException {

        Cursor cursor = null;
        Locker locker = null;
        DatabaseEntry key = new DatabaseEntry();
        DatabaseEntry data= new DatabaseEntry();
        try {
            locker = BasicLocker.createBasicLocker(envImpl);
            cursor = makeCursor(locker);

            if (positionBeforeOrEqual(cursor, vlsn, key, data)) {
                return VLSNBucket.readFromDatabase(data);
            }

            /* Shouldn't get here. */
            throw EnvironmentFailureException.unexpectedState
                (envImpl, "Couldn't find bucket for LTE VLSN " + vlsn +
                 "in database. tracker=" + tracker);
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            if (locker != null) {
                locker.operationEnd(true);
            }
        }
    }

    /**
     * Return the bucket that hold a mapping >= this VLSN. If this method
     * is called, we guarantee that a non-null bucket will be returned.
     */
    private VLSNBucket getGTEBucketFromDatabase(VLSN vlsn)
        throws DatabaseException {

        Cursor cursor = null;
        Locker locker = null;
        DatabaseEntry key = new DatabaseEntry();
        DatabaseEntry data = new DatabaseEntry();
        LongBinding.longToEntry(vlsn.getSequence(), key);

        try {
            locker = BasicLocker.createBasicLocker(envImpl);
            cursor = makeCursor(locker);

            /* getSearchKeyRange will give us a bucket >= VLSN. */
            OperationStatus status =
                cursor.getSearchKeyRange(key, data, LockMode.DEFAULT);

            if (status == OperationStatus.SUCCESS) {
                VLSNBucket bucket = VLSNBucket.readFromDatabase(data);
                if (bucket.owns(vlsn)) {
                    return bucket;
                }

                /*
                 * The bucket we found is > than our VLSN. Look at the previous
                 * one.
                 */
                status = cursor.getPrev(key, data, LockMode.DEFAULT);
                if (isValidBucket(status, key)) {
                    VLSNBucket prevBucket = VLSNBucket.readFromDatabase(data);
                    if (prevBucket.owns(vlsn)) {
                        return prevBucket;
                    }
                }

                /*
                 * There is no bucket that owns this VLSN, return the greater
                 * one.
                 */
                return bucket;
            }
            /*
             * There was no bucket >= VLSN. Let's find the last bucket in
             * this database then. It should be a bucket that's < VLSN, but
             * might own it.
             */
            VLSNBucket endBucket = null;
            status =  cursor.getLast(key, data, LockMode.DEFAULT);
            if (isValidBucket(status, key)) {
                endBucket = VLSNBucket.readFromDatabase(data);
                if (endBucket.owns(vlsn)) {
                    return endBucket;
                }
            }

            /*
             * There should have been something in this database >=
             * this VLSN .
             */
            throw EnvironmentFailureException.unexpectedState
                (envImpl, "Couldn't find bucket for GTE VLSN " + vlsn +
                 " in database. EndBucket = " + endBucket + " tracker = " +
                 tracker);
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            if (locker != null) {
                locker.operationEnd(true);
            }
        }
    }

   /*
    * Position this cursor at the largest value bucket which is <= the
    * target VLSN.
    * @return true if there is a bucket that fits this criteria,
    */
    private boolean positionBeforeOrEqual(Cursor cursor,
                                          VLSN vlsn,
                                          DatabaseEntry key,
                                          DatabaseEntry data)
        throws DatabaseException {

        LongBinding.longToEntry(vlsn.getSequence(), key);
        VLSNBucket bucket = null;

        /* getSearchKeyRange will give us a bucket >= Y. */
        OperationStatus status =
            cursor.getSearchKeyRange(key, data, LockMode.DEFAULT);

        if (status == OperationStatus.SUCCESS) {
            bucket = VLSNBucket.readFromDatabase(data);
            if (bucket.owns(vlsn)) {
                return true;
            }

            /* The bucket we found is > than our VLSN. Get the previous one. */
            status = cursor.getPrev(key, data, LockMode.DEFAULT);
            if (isValidBucket(status, key)) {
                return true;
            }

            /* Hey, nothing else in the database. */
            return false;
        }
        /*
         * There was no bucket >= Y. Let's find the last bucket in this
         * database then. It should be a bucket that's < Y.
         */
        status =  cursor.getLast(key, data, LockMode.DEFAULT);
        if (isValidBucket(status, key)) {
            return true;
        }

        return false;
    }

   /*
    * Position this cursor at the smallest value bucket which is >= the
    * target VLSN.
    * @return true if there is a bucket that fits this criteria,
    */
    private boolean positionAfterOrEqual(Cursor cursor,
                                         VLSN vlsn,
                                         DatabaseEntry key,
                                         DatabaseEntry data)
        throws DatabaseException {

        LongBinding.longToEntry(vlsn.getSequence(), key);
        VLSNBucket bucket = null;

        /* getSearchKeyRange will give us a bucket >= Y. */
        OperationStatus status =
            cursor.getSearchKeyRange(key, data, LockMode.DEFAULT);

        if (status == OperationStatus.SUCCESS) {
            bucket = VLSNBucket.readFromDatabase(data);
            if (bucket.owns(vlsn)) {
                return true;
            }

            /*
             * This bucket is > our VLSN. Check the bucket before.
             *  - It might be a bucket that owns this VLSN
             *  - the prevbucket might precede this VLSN.
             *  - the record before might be the range.
             * One way or another, there should always be a record before
             * any bucket -- it's the range.
             */
            status = cursor.getPrev(key, data, LockMode.DEFAULT);
            assert status == OperationStatus.SUCCESS;

            if (isValidBucket(status, key)) {
                bucket = VLSNBucket.readFromDatabase(data);
                if (bucket.owns(vlsn)) {
                    return true;
                }
            }

            /*
             * Move back to the original bucket, all those preceding buckets
             * were unsatifactory.
             */
            status = cursor.getNext(key, data, LockMode.DEFAULT);
            return true;
        }
        /*
         * There was no bucket >= Y. Let's find the last bucket in this
         * database then. It should be a bucket that's < Y.
         */
        status =  cursor.getLast(key, data, LockMode.DEFAULT);
        if (isValidBucket(status, key)) {
            bucket = VLSNBucket.readFromDatabase(data);
            if (bucket.owns(vlsn)) {
                return true;
            }
        }

        return false;
    }

    /*
     * Remove all VLSN->LSN mappings <= deleteEnd
     */
    private void pruneDatabaseHead(VLSN deleteEnd,
                                   long deleteFileNum,
                                   Txn txn)
        throws DatabaseException {
        Cursor cursor = null;

        try {
            cursor = makeCursor(txn);

            DatabaseEntry key = new DatabaseEntry();
            DatabaseEntry data = new DatabaseEntry();
            if (!positionBeforeOrEqual(cursor, deleteEnd, key, data)) {
                /* Nothing to do. */
                return;
            }

            /* Delete this bucket and everything before this bucket. */
            do {
                long keyValue = LongBinding.entryToLong(key);
                if (keyValue == VLSNRange.RANGE_KEY) {
                    break;
                }

                OperationStatus status = cursor.delete();
                if (status != OperationStatus.SUCCESS) {
                    throw EnvironmentFailureException.unexpectedState
                        (envImpl, "Couldn't delete, got status of " + status +
                         "for delete of bucket " + keyValue + " deleteEnd=" +
                         deleteEnd);
                }
            } while (cursor.getPrev(key, data, LockMode.DEFAULT) ==
                     OperationStatus.SUCCESS);

            /*
             * Check the first real bucket, and see if we need to insert
             * a ghost bucket.
             */
            VLSN newStart = deleteEnd.getNext();
            LongBinding.longToEntry(1, key);
            OperationStatus status =
                cursor.getSearchKeyRange(key, data, LockMode.DEFAULT);

            /* No real buckets, nothing to adjust. */
            if (status != OperationStatus.SUCCESS) {
                return;
            }

            VLSNBucket firstBucket = VLSNBucket.readFromDatabase(data);
            /* First bucket matches the range, nothing to adjust. */
            if (firstBucket.getFirst().equals(newStart)) {
                return;
            }

            if (firstBucket.getFirst().compareTo(newStart) < 0) {
                throw EnvironmentFailureException.unexpectedState
                    (envImpl, "newStart " + newStart +
                     " should be < first bucket:" + firstBucket);
            }

            /*
             * Add a ghost bucket so that there is a bucket to match the
             * first item in the range.
             */
            long nextFile = envImpl.getFileManager().
                getFollowingFileNum(deleteFileNum,
                                    true /* forward */);
            long lastPossibleLsn = firstBucket.getLsn(firstBucket.getFirst());
            VLSNBucket placeholder =
                new GhostBucket(newStart, DbLsn.makeLsn(nextFile, 0),
                                                     lastPossibleLsn);
            placeholder.writeToDatabase(envImpl, cursor);

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /*
     * Remove all VLSN->LSN mappings >= deleteStart.  Recall that the
     * mappingDb is keyed by the first VLSN in the bucket. The replication
     * stream will be quiescent when this is called. The caller must be
     * sure that there are buckets in the database that cover deleteStart.
     *
     * @param lastLsn if NULL_LSN, the pruning may need to delete mappings <
     * deleteSTart, in order to keep the bucket capped with a legitimate
     * lastLSN. If lastLsn is not NULL_LSN, then the deletion can precisely
     * delete only mappings >= deleteStart.
     * @param lastVLSN left on disk.
     */
    private VLSN pruneDatabaseTail(VLSN deleteStart, long lastLsn, Txn txn)
        throws DatabaseException {

        VLSN lastOnDiskVLSN = deleteStart.getPrev();
        Cursor cursor = null;

        try {
            cursor = makeCursor(txn);

            DatabaseEntry key = new DatabaseEntry();
            DatabaseEntry data = new DatabaseEntry();
            if (!positionAfterOrEqual(cursor, deleteStart, key, data)) {
                return tracker.getLastOnDisk();
            }

            /*
             * Does this bucket straddle deleteStart? Then prune off part of
             * the bucket.
             */
            VLSNBucket bucket = VLSNBucket.readFromDatabase(data);
            if (bucket.getFirst().compareTo(deleteStart) < 0) {
                bucket.removeFromTail(deleteStart, lastLsn);
                lastOnDiskVLSN = bucket.getLast();
                bucket.fillDataEntry(data);
                OperationStatus status = cursor.putCurrent(data);
                if (status != OperationStatus.SUCCESS) {
                    throw EnvironmentFailureException.unexpectedState
                        (envImpl, "Couldn't update " + bucket);
                }

                status = cursor.getNext(key, data, LockMode.DEFAULT);
                if (status != OperationStatus.SUCCESS) {
                    return lastOnDiskVLSN;
                }
            }

            /* Delete everything after this bucket. */
            do {
                OperationStatus status = cursor.delete();
                if (status != OperationStatus.SUCCESS) {
                    throw EnvironmentFailureException.unexpectedState
                        (envImpl, "Couldn't delete after vlsn " + deleteStart +
                         " status=" + status);
                }
            } while (cursor.getNext(key, data, LockMode.DEFAULT) ==
                     OperationStatus.SUCCESS);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return lastOnDiskVLSN;
    }

    /**
     * At startup, we need to
     * - get a handle onto the internal database which stores the VLSN index
     * - read the latest on-disk version to initialize the tracker
     * - find any VLSN->LSN mappings which were not saved in the on-disk
     *   version, and merge them in. Thse mappings weren't flushed because
     *   they occurred after the checkpoint end. They're found by the recovery
     *   procedure, and are added in now.
     *
     * This method will execute when the map is quiescent, and needs no
     * synchronization.
     */
    private void init(String mappingDbName,
                      int vlsnStride,
                      int vlsnMaxMappings,
                      int vlsnMaxDistance,
                      RecoveryInfo recoveryInfo)
        throws DatabaseException {

        openMappingDatabase(mappingDbName);
        tracker = new VLSNTracker(envImpl, mappingDbImpl, vlsnStride,
                                  vlsnMaxMappings, vlsnMaxDistance);

        /*
         * Put any in-memory mappings discovered during the recovery process
         * into the fileMapperDb. That way, we'll preserve mappings that
         * precede this recovery's checkpoint.
         *
         * For example, suppose the log looks like this:
         *
         * VLSN1
         * VLSN2
         * checkpoint start for this recovery, for the instantiation of the
         *          replicator
         * checkpoint end for this recovery
         * <- at this point in time, after the env comes up, we'll create
         * the VLSN index. VLSN1 and VLSN2 were discovered during recovery and
         * are recorded in memory. Normally a checkpoint flushes the VLSNIndex
         * but the VLSNIndex isn't instantiated yet, because the VLSNIndex
         * needs an initialized environment.
         */
        merge((VLSNRecoveryTracker) recoveryInfo.vlsnProxy);
    }

    /*
     * Update this index, which was initialized with what's on disk, with
     * mappings found during recovery. These mappings ought to either overlap
     * what's on disk, or cover the range immediately after what's on disk.  If
     * it doesn't, the recovery mechanism, which flushes the mapping db at
     * checkpoint is faulty and we've lost mappings.
     *
     * In other words, if this tracker holds the VLSN range a -> c, then the
     * recovery tracker will have the VLSN range b -> d, where
     *
     *   a <= b
     *   c <= d
     *   if c < b, then b == c+1
     *
     * This method must be called when the index and tracker are quiescent, and
     * there are no calls to track().
     *
     * The recoveryTracker is the authoritative voice on what should be in the
     * VLSN index.
     */
    void merge(VLSNRecoveryTracker recoveryTracker) {

        if (recoveryTracker == null) {
            flushToDatabase();
            return;
        }

        if (recoveryTracker.isEmpty()) {

            /*
             * Even though the recovery tracker has no mappings, it may have
             * seen a rollback start that indicates that the VLSNIndex should
             * be truncated. Setup the recovery tracker so it looks like
             * it has a single mapping -- the matchpoint VLSN and LSN and
             * proceed. Take this approach, rather than truncating the index,
             * because we may need that matchpoint mapping to cap off the
             * VLSN range.
             *
             * For example, suppose an index has mappings for VLSN 1, 5, 10,
             * and the rollback is going to matchpoint 7. A pure truncation
             * would lop off VLSN 10, making VLSN 5 the last mapping. We
             * would then need to add on VLSN 7.
             */
            VLSN lastMatchpointVLSN = recoveryTracker.getLastMatchpointVLSN();
            if (lastMatchpointVLSN.isNull()) {
                return;
            }

            /*
             * Use a MATCHPOINT log entry to indicate that this is a syncable
             * entry. This purposefully leaves the recovery tracker's range's
             * lastTxnEnd null, so it will not overwrite the on disk
             * tracker. This assumes that we will never rollback past the last
             * txn end.
             */
            recoveryTracker.track(lastMatchpointVLSN,
                                  recoveryTracker.getLastMatchpointLsn(),
                                  LogEntryType.LOG_MATCHPOINT.getTypeNum());
        }

        /*
         * The mappings held in the recoveryTracker must either overlap what's
         * on disk or immediately follow the last mapping on disk. If there
         * is a gap between what is on disk and the recovery tracker, something
         * went awry with the checkpoint scheme, which flushes the VLSN index
         * at each checkpoint. We're in danger of losing some mappings. Most
         * importantly, the last txnEnd VLSN in the range might not be right.
         *
         * The one exception is when the Environment has been converted from
         * non-replicated and there are no VLSN entries in the VLSNIndex. In
         * that case, it's valid that the entries seen from the recovery
         * tracker may have a gap in VLSNs. For example, in a newly converted
         * environment, the VLSN index range has NULL_VLSN as its last entry,
         * but the first replicated log entry will start with 2.
         *
         * Note: EnvironmentImpl.needConvert() would more accurately convey the
         * fact that this is the very first recovery following a conversion.
         * But needConvert() on a replica is never true, and we need to disable
         * this check on the replica's first recovery too.
         */
        VLSN persistentLast = tracker.getRange().getLast();
        VLSN recoveryFirst = recoveryTracker.getRange().getFirst();
        if ((!(envImpl.isConverted() && persistentLast.isNull()) ||
             !envImpl.isConverted()) &&
            recoveryFirst.compareTo(persistentLast.getNext()) > 0) {

            throw EnvironmentFailureException.unexpectedState
                (envImpl, "recoveryTracker should overlap or follow on disk " +
                 "last VLSN of " + persistentLast + " recoveryFirst= " +
                 recoveryFirst);
        }

        VLSNRange currentRange = tracker.getRange();
        if (currentRange.getLast().getNext().equals(recoveryFirst)) {
            /* No overlap, just append mappings found at recovery. */
            tracker.append(recoveryTracker);
            flushToDatabase();
            return;
        }

        /*
         * The mappings in the recovery tracker should overwrite those in the
         * VLSN index.
         */
        TransactionConfig config = new TransactionConfig();
        config.setDurability(Durability.COMMIT_NO_SYNC);
        Txn txn = Txn.createLocalTxn(envImpl, config);
        boolean success = false;
        VLSN lastOnDiskVLSN;
        try {
            lastOnDiskVLSN = pruneDatabaseTail(recoveryFirst, DbLsn.NULL_LSN,
                                               txn);
            tracker.merge(lastOnDiskVLSN, recoveryTracker);
            flushToDatabase(txn);
            txn.commit();
            success = true;
        } finally {
            if (!success) {
                txn.abort();
            }
        }
    }

    private void openMappingDatabase(String mappingDbName)
        throws DatabaseException {

        final Locker locker =
            Txn.createLocalAutoTxn(envImpl, new TransactionConfig());

        try {
            DbTree dbTree = envImpl.getDbTree();
            DatabaseImpl db = dbTree.getDb(locker,
                                           mappingDbName,
                                           null /* databaseHandle */);
            if (db == null) {
                if (envImpl.isReadOnly()) {
                    /* This should have been caught earlier. */
                    throw EnvironmentFailureException.unexpectedState
                       ("A replicated environment can't be opened read only.");
                }
                DatabaseConfig dbConfig = new DatabaseConfig();
                DbInternal.setReplicated(dbConfig, false);
                db = dbTree.createInternalDb(locker, mappingDbName, dbConfig);
            }
            mappingDbImpl = db;
        } finally {
            locker.operationEnd(true);
        }
    }

    public synchronized void close() {
        close(true);
    }

    public synchronized void abnormalClose() {
        close(false);
    }

    public void close(boolean doFlush)
        throws DatabaseException {

        try {
            if (doFlush) {
                flushToDatabase();
            }

            if (vlsnPutLatch != null) {

                /*
                 * This should be harmless because the feeders using the latch
                 * should all have been interrupted and shutdown. So just log
                 * this fact.
                 */
                vlsnPutLatch.terminate();
                LoggerUtils.fine
                    (logger, envImpl, 
                     "Outstanding VLSN put latch cleared at close");
            }
        } finally {
            if (mappingDbImpl != null) {
                envImpl.getDbTree().releaseDb(mappingDbImpl);
                mappingDbImpl = null;
            }
        }
    }

    /**
     * Mappings are flushed to disk at close, and at checkpoints.
     */
    public void flushToDatabase() {

        TransactionConfig config = new TransactionConfig();
        config.setDurability(Durability.COMMIT_NO_SYNC);
        Txn txn = Txn.createLocalTxn(envImpl, config);
        boolean success = false;
        try {
            flushToDatabase(txn);
            txn.commit();
            success = true;
        } finally {
            if (!success) {
                txn.abort();
            }
        }
    }

    /**
     * Mappings are flushed to disk at close, and at checkpoints.
     */
    private void flushToDatabase(Txn txn)
        throws DatabaseException {
        synchronized (flushSynchronizer) {
            tracker.flushToDatabase(mappingDbImpl, txn);
        }
    }

    /**
     * For debugging and unit tests
     * @throws DatabaseException
     */
    public Map<VLSN, Long> dumpDb(boolean display) {

        Cursor cursor = null;
        Locker locker = null;
        if (display) {
            System.out.println(tracker);
        }

        Map<VLSN, Long> mappings = new HashMap<VLSN, Long>();

        try {
            locker = BasicLocker.createBasicLocker(envImpl);
            cursor = makeCursor(locker);

            DatabaseEntry key = new DatabaseEntry();
            DatabaseEntry data = new DatabaseEntry();

            /*
             * The first item in the database is the VLSNRange. All subsequent
             * items are VLSNBuckets.
             */
            int count = 0;
            while (cursor.getNext(key, data, LockMode.DEFAULT) ==
                   OperationStatus.SUCCESS) {

                Long keyValue = LongBinding.entryToLong(key);

                if (display) {
                    System.out.println("key => " + keyValue);
                }
                if (count == 0) {
                    VLSNRange range = VLSNRange.readFromDatabase(data);
                    if (display) {
                        System.out.println("range =>");
                        System.out.println(range);
                    }
                } else {
                    VLSNBucket bucket = VLSNBucket.readFromDatabase(data);
                    for (long i = bucket.getFirst().getSequence();
                         i <= bucket.getLast().getSequence();
                         i++) {
                        VLSN v = new VLSN(i);
                        long lsn = bucket.getLsn(v);

                        if (lsn != DbLsn.NULL_LSN) {
                            mappings.put(v, lsn);
                        }
                    }
                    if (display) {
                        System.out.println("bucket =>");
                        System.out.println(bucket);
                    }
                }
                count++;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }

            if (locker != null) {
                locker.operationEnd(true);
            }
        }

        return mappings;
    }

    /**
     * For DbStreamVerify utility. Verify the on-disk database, disregarding
     * the cached tracker.
     * @throws DatabaseException
     */
    @SuppressWarnings("null")
    public static void verifyDb(Environment env,
                                PrintStream out,
                                boolean verbose)
        throws DatabaseException {

        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setReadOnly(true);
        Database db =
            env.openDatabase(null, DbTree.VLSN_MAP_DB_NAME, dbConfig);
        Cursor cursor = null;
        try {
            if (verbose) {
                System.out.println("Verifying VLSN index");
            }

            cursor = db.openCursor(null, CursorConfig.READ_COMMITTED);

            DatabaseEntry key = new DatabaseEntry();
            DatabaseEntry data = new DatabaseEntry();

            /*
             * The first item in the database is the VLSNRange. All subsequent
             * items are VLSNBuckets.
             */
            int count = 0;
            VLSNRange range = null;
            VLSNBucket lastBucket = null;
            Long lastKey = null;
            VLSN firstVLSNSeen = VLSN.NULL_VLSN;
            VLSN lastVLSNSeen = VLSN.NULL_VLSN;
            while (cursor.getNext(key, data, null) ==
                   OperationStatus.SUCCESS) {

                Long keyValue = LongBinding.entryToLong(key);

                if (count == 0) {
                    if (keyValue != VLSNRange.RANGE_KEY) {
                        out.println("Wrong key value for range! " + range);
                    }
                    range = VLSNRange.readFromDatabase(data);
                    if (verbose) {
                        out.println("range=>" + range);
                    }
                } else {
                    VLSNBucket bucket = VLSNBucket.readFromDatabase(data);
                    if (verbose) {
                        out.print("key=> " + keyValue);
                        out.println(" bucket=>" + bucket);
                    }

                    if (lastBucket != null) {
                        if (lastBucket.getLast().compareTo(bucket.getFirst())
                            >= 0) {
                            out.println("Buckets out of order.");
                            out.println("Last = " + lastKey + "/" +
                                        lastBucket);
                            out.println("Current = " + keyValue + "/" +
                                        bucket);
                        }
                    }

                    lastBucket = bucket;
                    lastKey = keyValue;
                    if ((firstVLSNSeen != null) && firstVLSNSeen.isNull()) {
                        firstVLSNSeen = bucket.getFirst();
                    }
                    lastVLSNSeen = bucket.getLast();
                }
                count++;
            }

            if (count == 0) {
                out.println("VLSNIndex not on disk");
                return;
            }

            if (firstVLSNSeen.compareTo(range.getFirst()) != 0) {
                out.println("First VLSN in bucket = " + firstVLSNSeen +
                            " and doesn't match range " + range.getFirst());
            }

            if (lastVLSNSeen.compareTo(range.getLast()) != 0) {
                out.println("Last VLSN in bucket = " + lastVLSNSeen +
                            " and doesn't match range " + range.getLast());
            }

        } finally {
            if (cursor != null) {
                cursor.close();
            }

            db.close();
        }
    }

    /* For unit test support. Index needs to be quiescent */
    @SuppressWarnings("null")
    public synchronized boolean verify(boolean verbose)
        throws DatabaseException {

        if (!tracker.verify(verbose)) {
            return false;
        }

     
        VLSNRange dbRange = null;
        ArrayList<VLSN> firstVLSN = new ArrayList<VLSN>();
        ArrayList<VLSN> lastVLSN = new ArrayList<VLSN>();
        final Locker locker = BasicLocker.createBasicLocker(envImpl);
        Cursor cursor = null;
        
        /* 
         * Synchronize so we don't try to verify while the checkpointer
         * thread is calling flushToDatabase on the vlsnIndex.
         */
        synchronized (flushSynchronizer) {
            /*
             * Read the on-disk range and buckets.
             * -The tracker and the database buckets should not intersect.
             * -The on-disk range should be a subset of the tracker range.
             */
            try {
                cursor = makeCursor(locker); 

                DatabaseEntry key = new DatabaseEntry();
                DatabaseEntry data = new DatabaseEntry();

                /*
                 * Read the on-disk range and all the buckets.
                 */
                OperationStatus status =
                    cursor.getFirst(key, data, LockMode.DEFAULT);
                if (status == OperationStatus.SUCCESS) {
                    VLSNRangeBinding rangeBinding = new VLSNRangeBinding();
                    dbRange = rangeBinding.entryToObject(data);

                    /* Collect info about the  buckets. */
                    while (cursor.getNext(key, data, LockMode.DEFAULT) ==
                           OperationStatus.SUCCESS) {

                        VLSNBucket bucket = VLSNBucket.readFromDatabase(data);

                        Long keyValue = LongBinding.entryToLong(key);
                        if (bucket.getFirst().getSequence() != keyValue) {
                            return false;
                        }

                        firstVLSN.add(bucket.getFirst());
                        lastVLSN.add(bucket.getLast());
                    }
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }

                locker.operationEnd(true);
            }

            /*
             * Verify range.
             */
            VLSNRange trackerRange = tracker.getRange();
            if (!trackerRange.verifySubset(verbose, dbRange)) {
                return false;
            }
        }

        VLSN firstTracked = tracker.getFirstTracked();

        /* The db range and the buckets need to be consistent. */
        VLSN firstOnDisk = null;
        VLSN lastOnDisk = null;
        if (firstVLSN.size() > 0) {
            /* There are buckets in the database. */
            lastOnDisk =  lastVLSN.get(lastVLSN.size()-1);
            firstOnDisk = firstVLSN.get(0);

            if (!VLSNTracker.verifyBucketBoundaries(firstVLSN, lastVLSN)) {
                return false;
            }

            /*
             * A VLSNIndex invariant is that there is always a mapping for the
             * first and last VLSN in the range.  However, if the log cleaner
             * lops off the head of the index, leaving a bucket gap at the
             * beginning of the index, we break this invariant. For example,
             * suppose the index has
             *
             * bucketA - VLSNs 10
             * no bucket, due to out of order mapping - VLSN 11, 12
             * bucket B - VLSNs 13-15
             *
             * If the cleaner deletes VLSN 10->11, VLSN 12 will be the start
             * of the range, and needs a bucket. We'll do this by adding a
             * bucket placeholder.
             */
            if (dbRange.getFirst().compareTo(firstOnDisk) != 0) {
                dump(verbose, "Range doesn't match buckets " +
                     dbRange + " firstOnDisk = " + firstOnDisk);
                return false;
            }

            /* The tracker should know what the last VLSN on disk is. */
            if (!lastOnDisk.equals(tracker.getLastOnDisk())) {
                dump(verbose, "lastOnDisk=" + lastOnDisk +
                     " tracker=" + tracker.getLastOnDisk());
                return false;
            }

            if (!firstTracked.equals(NULL_VLSN)) {

                /*
                 * The last bucket VLSN should precede the first tracker VLSN.
                 */
                if (firstTracked.compareTo(lastOnDisk.getNext()) < 0) {
                    dump(verbose, "lastOnDisk=" + lastOnDisk +
                         " firstTracked=" + firstTracked);
                    return false;
                }
            }
        }
        return true;
    }

    private void dump(boolean verbose, String msg) {
        if (verbose) {
            System.out.println(msg);
        }
    }

    /*
     * For unit test support only. Can only be called when replication stream
     * is quiescent.
     */
    public boolean isFlushedToDisk() {
        return tracker.isFlushedToDisk();
    }

    /**
     * A cursor over the VLSNIndex.
     */
    private abstract static class VLSNScanner {
        VLSNBucket currentBucket;
        final VLSNIndex vlsnIndex;

        /*
         * This is purely for assertions. The VLSNScanner assumes that
         * getStartingLsn() is called once before getLsn() is called.
         */
        int startingLsnInvocations;

        VLSNScanner(VLSNIndex vlsnIndex) {
            this.vlsnIndex = vlsnIndex;
            startingLsnInvocations = 0;
        }

        public abstract long getStartingLsn(VLSN vlsn);

        /**
         * @param vlsn We're requesting a LSN mapping for this vlsn
         * @return If there is a mapping for this VLSN, return it, else return
         * NULL_LSN. We assume that we checked that this VLSN is in the
         * VLSNIndex's range.
         */
        public abstract long getPreciseLsn(VLSN vlsn);
    }

    /**
     * Assumes that VLSNs are scanned backwards. May be used by syncup to
     * optimally search for matchpoints.
     */
    public static class BackwardVLSNScanner extends VLSNScanner {

        public BackwardVLSNScanner(VLSNIndex vlsnIndex) {
            super(vlsnIndex);
        }

        /*
         * Use the >= mapping for the requested VLSN to find the starting lsn
         * to use for a scan. This can only be used on a VLSN that is known to
         * be in the range.
         */
        @Override
        public long getStartingLsn(VLSN vlsn) {

            startingLsnInvocations++;
            currentBucket = vlsnIndex.getGTEBucket(vlsn);
            return currentBucket.getGTELsn(vlsn);
        }

        /**
         * @see VLSNScanner#getPreciseLsn
         */
        @Override
        public long getPreciseLsn(VLSN vlsn) {
            assert startingLsnInvocations == 1 : "startingLsns() called " +
                startingLsnInvocations + " times";

            /*
             * Ideally, we have a bucket that has the mappings for this VLSN.
             * If we don't, we attempt to get the next applicable bucket.
             */
            if (currentBucket != null)  {
                if (!currentBucket.owns(vlsn)) {

                    /*
                     * This bucket doesn't own the VLSN. Is it because (a)
                     * there's a gap and two buckets don't abut, or (b) because
                     * we walked off the end of the current bucket, and we need
                     * a new one? Distinguish case (a) by seeing if the current
                     * bucket will be needed for an upcoming VLSN.
                     */
                    if (currentBucket.precedes(vlsn)) {
                        return DbLsn.NULL_LSN;
                    }

                    /*
                     * Case B: We've walked off the end of the current
                     * bucket.
                     */
                    currentBucket = null;
                }
            }

            /*
             * We walked off the end of the currentBucket. Get a new bucket,
             * finding the closest bucket that would hold this mapping.
             */
            if (currentBucket == null) {
                currentBucket = vlsnIndex.getLTEBucket(vlsn);

                /*
                 * The next bucket doesn't own this vlsn, which means that
                 * we're in a gap between two buckets.  Note:
                 * vlsnIndex.LTEBucket guards against returning null.
                 */
                if (!currentBucket.owns(vlsn)) {
                    return DbLsn.NULL_LSN;
                }
            }

            assert currentBucket.owns(vlsn) : "vlsn = " + vlsn +
                " currentBucket=" + currentBucket;

            /* We're in the right bucket. */
            return currentBucket.getLsn(vlsn);
        }
    }

    /**
     * Disable critical eviction for all VLSNIndex cursors. [#18475] An
     * improvement would be to enable eviction, and do all database operations
     * that are in a loop asynchronously.
     */
    private Cursor makeCursor(Locker locker) {
        Cursor cursor = DbInternal.makeCursor(mappingDbImpl, 
                                              locker, 
                                              CursorConfig.DEFAULT);
        DbInternal.getCursorImpl(cursor).setAllowEviction(false);
        return cursor;
    }

    /**
     * Scans VLSNs in a forward direction, used by feeders.
     */
    public static class ForwardVLSNScanner extends VLSNScanner {


        public ForwardVLSNScanner(VLSNIndex vlsnIndex) {
            super(vlsnIndex);
        }

        /**
         * Use the <= mapping to the requested VLSN to find the starting lsn to
         * use for a scan.  This can only be used on a VLSN that is known to be
         * in the range.
         */
        @Override
        public long getStartingLsn(VLSN vlsn) {

            startingLsnInvocations++;
            currentBucket = vlsnIndex.getLTEBucket(vlsn);
            return currentBucket.getLTELsn(vlsn);
        }


        /**
         * @see VLSNScanner#getPreciseLsn
         */
        @Override
        public long getPreciseLsn(VLSN vlsn) {
            return getLsn(vlsn, false /* approximate */);
        }

        /**
         * When doing an approximate search, the target vlsn may be a non-mapped
         * vlsn within a bucket, or it may be between two different buckets.
         * For example, suppose we have two buckets:
         *
         * vlsn 1 -> lsn 10
         * vlsn 5 -> lsn 50
         * vlsn 7 -> lsn 70
         *
         * vlsn 20 -> lsn 120
         * vlsn 25 -> lsn 125
         *
         * If the vlsn we are looking for is 4, the LTE lsn for an approximate
         * return value will be vlsn 1-> lsn 10, in the same bucket. If we are
         * looking for vlsn 9, the LTE lsn for an approximate return value will
         * be vlsn 7->lsn 70, which is the last mapping in an earlier bucket.
         *
         * @param vlsn We're requesting a LSN mapping for this vlsn
         * @return If there is a mapping for this VLSN, return it. If it does
         * not exist, return the nearest non-null mapping, where nearest the
         * <= LSN. We assume that we checked that this VLSN is in the
         * VLSNIndex's range.
         */
        public long getApproximateLsn(VLSN vlsn) {
            return getLsn(vlsn, true /* approximate */);
        }

        private long getLsn(VLSN vlsn, boolean approximate) {

            assert startingLsnInvocations == 1 : "startingLsns() called " +
                startingLsnInvocations + " times";

            /*
             * Ideally, we have a bucket that has the mappings for this VLSN.
             * If we don't, we attempt to get the next applicable bucket.
             */
            if (currentBucket != null)  {
                if (!currentBucket.owns(vlsn)) {

                    /*
                     * This bucket doesn't own the VLSN. Is it because (a)
                     * there's a gap and two buckets don't abut, or (b) because
                     * we walked off the end of the current bucket, and we need
                     * a new one? Distinguish case (a) by seeing if the current
                     * bucket will be needed for an upcoming VLSN.
                     */
                    if (currentBucket.follows(vlsn)) {
                        /* Case A: No bucket available for this VLSN. */
                        return approximate ?
                                findPrevLsn(vlsn) : DbLsn.NULL_LSN;
                    }

                    /* Case B: We've walked off the end of the bucket. */
                    currentBucket = null;
                }
            }

            /*
             * We walked off the end of the currentBucket. Get a new bucket,
             * finding the closest bucket that would hold this mapping.
             */
            if (currentBucket == null) {
                currentBucket = vlsnIndex.getGTEBucket(vlsn);

                /*
                 * The next bucket doesn't own this vlsn, which means that
                 * we're in a gap between two buckets. Note:
                 * vlsnIndex.getGTEBucket guards against returning null.
                 */
                if (!currentBucket.owns(vlsn)) {
                    return approximate ? findPrevLsn(vlsn) : DbLsn.NULL_LSN;
                }
            }

            assert currentBucket.owns(vlsn) : "vlsn = " + vlsn +
                " currentBucket=" + currentBucket;

            if (approximate) {

                /*
                 * We're in the right bucket, and it owns this
                 * VLSN. Nevertheless, the bucket may or may not contain a
                 * mapping for this VLSN, so return the LTE version mapping.
                 */
                return currentBucket.getLTELsn(vlsn);
            }

            return currentBucket.getLsn(vlsn);
        }

        /*
         * Find the lsn mapping that precedes the target. This assumes that
         * no bucket owns the target vlsn -- that it's a vlsn that falls
         * between buckets.
         */
        private long findPrevLsn(VLSN target) {
            VLSNBucket prevBucket = vlsnIndex.getLTEBucket(target);
            assert !prevBucket.owns(target) : "target=" + target +
              "prevBucket=" + prevBucket + " currentBucket=" + currentBucket;
            return prevBucket.getLastLsn();
        }
    }

    /**
     * Associates the logItem with the latch, so that it's readily available
     * when the latch is released.
     */
    public static class VLSNAwaitLatch extends CountDownLatch {
        /* The LogItem whose addition to the VLSN released the latch. */
        private LogItem logItem = null;
        private boolean terminated = false;

        public VLSNAwaitLatch() {
            super(1);
        }

        public long getTriggerLSN() {
            return logItem.getNewLsn();
        }

        public VLSN getTriggerVLSN() {
            return logItem.getHeader().getVLSN();
        }

        public void setLogItem(LogItem logItem) {
            this.logItem = logItem;
        }

        /**
         * Returns the log item that caused the latch to be released. It's only
         * meaningful after the latch has been released.
         *
         * @return log item or null if the latch timed out or it's wait was
         * terminated
         */
        public LogItem getLogItem() {
            return logItem;
        }

        /* Free up any waiters on this latch and shutdown. */
        public void terminate() {
            terminated = true;
            countDown();
        }

        public boolean isTerminated() {
            return terminated;
        }
    }

    /*
     * An exception primarily intended to implement non-local control flow
     * upon a vlsn wait latch timeout.
     */
    @SuppressWarnings("serial")
    static public class WaitTimeOutException extends Exception {

        @Override
        /* Eliminate unnecessary overhead. */
        public Throwable fillInStackTrace(){return null;}
    }
}
