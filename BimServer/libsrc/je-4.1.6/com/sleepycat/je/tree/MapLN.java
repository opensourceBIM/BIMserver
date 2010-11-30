/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;

/**
 * A MapLN represents a Leaf Node in the JE Db Mapping Tree.
 *
 * MapLNs contain a DatabaseImpl, which in turn contain three categories of
 * information - database configuration information, the per-database File
 * Summary utilization information, and each database's btree root. While LNs
 * are written to the log as the result of API operations which create new data
 * records, MapLNs are written to the log as a result of configuration changes,
 * utilization information changes, or updates to the btree which cascade up
 * the tree and result in a new root. Because they serve as a bridge between
 * the application data btree and the db mapping tree, MapLNs must be written
 * with special rules, and should only be written from DbTree.modifyDbRoot.
 * The basic rule is that in order to ensure that the MapLN contains the
 * proper btree root, the btree root latch is used to protect both any logging
 * of the MapLN, and any updates to the root lsn.
 *
 * Updates to the internal btree nodes obey a strict bottom up approach, in
 * accordance with the log semantics which require that later log entries are
 * known to supercede earlier log entries. In other words, for a btree that
 * looks like
 *      MapLN
 *        |
 *       IN
 *        |
 *       BIN
 *        |
 *       LN
 * we know that update operations cause the btree nodes must be logged in this
 * order: LN, BIN, IN, MapLN, so that the reference to each on disk node is
 * correct. (Note that logging order is special and different when the btree
 * is initially created.)
 *
 * However, MapLNs may need to be written to disk at arbitrary points in time
 * in order to save database config or utilization data. Those writes don't
 * have the time and context to be done in a cascading-upwards fashion.  We
 * ensure that MapLNs are not erroneously written with an out of sync root by
 * requiring that DbTree.modifyDbRoot takes the root latch for the application
 * data btree. RootINs are also written with the root latch, so it serves to
 * ensure that the root doesn't change during the time when the MapLN is
 * written. For example, suppose thread 1 is doing a cascading-up MapLN write,
 * and thread 2 is doing an arbitrary-point MapLN write:
 *
 * Thread 1                   Thread 2
 * --------                   --------
 * latch root                 latch BIN parent of MapLN
 * log root IN
 * log MapLN (Tree root)       wants to log MapLN too -- but has to take
 *  to refer to new root IN    root latch, so we'll get the right rootIN
 *
 * Without latching the root this could produce the following, incorrect log
 *  30 LNa
 *  40 BIN
 *  50 IN (first version of root)
 *  60 MapLN, refers to IN(50)
 *  ...
 *  90 LNb
 *  100 BIN
 *  110 IN (second version of root)
 *  120 CkptStart (the tree is not dirty, no IN will be logged during the
 *   ckpt interval))
 *   ..  something arbirarily writes out the MapLN
 *  130 MapLN refers to first root, IN(50)    <------ impossible
 *
 * While a MapLN can't be written out with the wrong root, it's possible
 * for a rootIN to be logged without the MapLN, and for that rootIN not
 * to be processed at recovery. Suppose a checkpoint begins and ends
 * in the window between when a rootIN is written, and DbTree.modifyDbRoot is
 * called:
 *   300 log new root IN,
 *   update root reference in tree
 *   unlatch root
 *
 *   310 Checkpoint starts
 *   320 Checkpoint ends
 *   ...if we crash here, before the MapLN is logged, , we won't see the new
 *   root IN at lsn 300. However, the IN is non-txnal and will be * recreated
 *   during reply of txnal * information (LNs) by normal recovery processing.
 */
public final class MapLN extends LN {

    private static final String BEGIN_TAG = "<mapLN>";
    private static final String END_TAG = "</mapLN>";

    private final DatabaseImpl databaseImpl;
    private boolean deleted;

    /**
     * Create a new MapLn to hold a new databaseImpl. In the ideal world, we'd
     * have a base LN class so that this MapLN doesn't have a superfluous data
     * field, but we want to optimize the LN class for size and speed right
     * now.
     */
    public MapLN(DatabaseImpl db) {
        super(new byte[0], db.getDbEnvironment(), false /* replicate */ );
        databaseImpl = db;
        deleted = false;
    }

    /**
     * Create an empty MapLN, to be filled in from the log.
     */
    public MapLN() {
        super();
        databaseImpl = new DatabaseImpl();
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    void makeDeleted() {
        deleted = true;

        /* Release all references to nodes held by this database. */
        databaseImpl.getTree().setRoot(null, true);
    }

    public DatabaseImpl getDatabase() {
        return databaseImpl;
    }

    /**
     * Does a fast check without acquiring the MapLN write-lock.  This is
     * important because the overhead of requesting the lock is significant and
     * unnecessary if this DB is open or the root IN is resident.  When there
     * are lots of databases open, this method will be called often during
     * selection of BINs for eviction.  [#13415]
     */
    @Override
    boolean isEvictableInexact() {
        /* Always prohibit eviction when je.env.dbEviction=false. */
        return databaseImpl.getDbEnvironment().getDbEviction() &&
               !databaseImpl.isInUse() &&
               !databaseImpl.getTree().isRootResident();
    }

    /**
     * Does a guaranteed check by acquiring the write-lock and then calling
     * isEvictableInexact.  [#13415] Be sure to use the idDatabaseImpl, which
     * owns this MapLN, rather than the databaseImpl housed within the MapLN
     * for the lock call. The databaseImpl field refers to the database that
     * the MapLN is representing. [#18524]
     */
    @Override
    boolean isEvictable()
        throws DatabaseException {

        boolean evictable = false;

        /* To prevent DB open, get a write-lock on the MapLN. */
        EnvironmentImpl envImpl = databaseImpl.getDbEnvironment();
        BasicLocker locker = BasicLocker.createBasicLocker(envImpl);
        DatabaseImpl idDatabaseImpl = envImpl.getDbTree().getIdDatabaseImpl();
        try {
            LockResult lockResult = locker.nonBlockingLock
                (getNodeId(), LockType.WRITE, idDatabaseImpl);

            /*
             * The isEvictableInexact result is guaranteed to hold true during
             * LN stripping if it is still true after acquiring the write-lock.
             */
            if (lockResult.getLockGrant() != LockGrantType.DENIED &&
                isEvictableInexact()) {

                /*
                 * While holding both a write-lock on the MapLN, we are
                 * guaranteed that the DB is not currently open.  It cannot be
                 * subsequently opened until the BIN latch is released, since
                 * the BIN latch will block DbTree.getDb (called during DB
                 * open).  We will evict the LN before releasing the BIN latch.
                 * After releasing the BIN latch, if a DB open is waiting on
                 * getDb, then it will proceed, fetch the evicted LN and open
                 * the DB normally.
                 */
                evictable = true;
            }
        } finally {
            /* Release the write-lock.  The BIN latch is still held. */
            locker.operationEnd();
        }

        return evictable;
    }

    /**
     * Initialize a node that has been faulted in from the log.
     */
    @Override
    public void postFetchInit(DatabaseImpl db, long sourceLsn) {
        databaseImpl.setEnvironmentImpl(db.getDbEnvironment());
    }

    /**
     * Compute the approximate size of this node in memory for evictor
     * invocation purposes. Don't count the treeAdmin memory, because
     * that goes into a different bucket.
     */
    @Override
    public long getMemorySizeIncludedByParent() {
        return MemoryBudget.MAPLN_OVERHEAD;
    }

    /**
     * @see LN#releaseMemoryBudget
     */
    @Override
    public void releaseMemoryBudget() {
        databaseImpl.releaseTreeAdminMemory();
    }

    /*
     * Dumping
     */

    @Override
    public String toString() {
        return dumpString(0, true);
    }

    @Override
    public String beginTag() {
        return BEGIN_TAG;
    }

    @Override
    public String endTag() {
        return END_TAG;
    }

    @Override
    public String dumpString(int nSpaces, boolean dumpTags) {
        StringBuffer sb = new StringBuffer();
        sb.append(super.dumpString(nSpaces, dumpTags));
        sb.append('\n');
        sb.append(TreeUtils.indent(nSpaces));
        sb.append("<deleted val=\"").append(Boolean.toString(deleted));
        sb.append("\">");
        sb.append('\n');
        sb.append(databaseImpl.dumpString(nSpaces));
        return sb.toString();
    }

    /*
     * Logging
     */

    /**
     * Log type for transactional entries.
     */
    @Override
    protected LogEntryType getTransactionalLogType() {
        return LogEntryType.LOG_MAPLN_TRANSACTIONAL;
    }

    /**
     * @see Node#getLogType
     */
    @Override
    public LogEntryType getLogType() {
        return LogEntryType.LOG_MAPLN;
    }

    /**
     * @see LN#getLogSize
     */
    @Override
    public int getLogSize() {
        return super.getLogSize() +
            databaseImpl.getLogSize() +
            1;                                 // deleted
    }

    /**
     * @see LN#writeToLog
     */
    @Override
    public void writeToLog(ByteBuffer logBuffer) {
        /* Ask ancestors to write to log. */
        super.writeToLog(logBuffer);
        databaseImpl.writeToLog(logBuffer);
        byte booleans = (byte) (deleted ? 1 : 0);
        logBuffer.put(booleans);
    }

    /**
     * @see LN#readFromLog
     */
    @Override
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {

        super.readFromLog(itemBuffer, entryVersion);
        databaseImpl.readFromLog(itemBuffer, entryVersion);
        byte booleans = itemBuffer.get();
        deleted = (booleans & 1) != 0;
    }

    /**
     * @see Loggable#logicalEquals
     * Should never be replicated.
     */
    @Override
    public boolean logicalEquals(Loggable other) {

        return false;
    }

    /**
     * Dump additional fields. Done this way so the additional info can be
     * within the XML tags defining the dumped log entry.
     */
    @Override
    protected void dumpLogAdditional(StringBuilder sb, boolean verbose) {
        databaseImpl.dumpLog(sb, verbose);
    }
}
