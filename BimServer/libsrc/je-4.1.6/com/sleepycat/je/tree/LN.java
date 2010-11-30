/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.nio.ByteBuffer;
import java.util.Arrays;

import com.sleepycat.je.CacheMode;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.OperationFailureException;
import com.sleepycat.je.cleaner.LocalUtilizationTracker;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.log.LogContext;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogItem;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.log.Provisional;
import com.sleepycat.je.log.ReplicationContext;
import com.sleepycat.je.log.entry.DeletedDupLNLogEntry;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.txn.WriteLockInfo;
import com.sleepycat.je.utilint.DbLsn;

/**
 * An LN represents a Leaf Node in the JE tree.
 */
public class LN extends Node implements Loggable {
    private static final String BEGIN_TAG = "<ln>";
    private static final String END_TAG = "</ln>";

    private byte[] data;

    /*
     * Flags: bit fields
     *
     * -Dirty means that the in-memory version is not present on disk.
     * -The last logged bits store the total size of the last logged entry.
     */
    private static final int DIRTY_BIT = 0x80000000;
    private static final int CLEAR_DIRTY_BIT = ~DIRTY_BIT;
    private static final int LAST_LOGGED_SIZE_MASK = 0x7FFFFFFF;
    private static final int CLEAR_LAST_LOGGED_SIZE = ~LAST_LOGGED_SIZE_MASK;
    private int flags; // not persistent

    /**
     * Create an empty LN, to be filled in from the log.
     */
    public LN() {
        this.data = null;
    }

    /**
     * Create a new LN from a byte array.
     */
    public LN(byte[] data, EnvironmentImpl envImpl, boolean replicated) {
        super(envImpl, replicated);
        if (data == null) {
            this.data = null;
        } else {
            init(data, 0, data.length);
        }
        setDirty();
    }

    /**
     * Create a new LN from a DatabaseEntry.
     */
    public LN(DatabaseEntry dbt, EnvironmentImpl envImpl, boolean replicated) {
        super(envImpl, replicated);

        byte[] dat = dbt.getData();
        if (dat == null) {
            data = null;
        } else if (dbt.getPartial()) {
            init(dat,
                 dbt.getOffset(),
                 dbt.getPartialOffset() + dbt.getSize(),
                 dbt.getPartialOffset(),
                 dbt.getSize());
        } else {
            init(dat, dbt.getOffset(), dbt.getSize());
        }
        setDirty();
    }

    private void init(byte[] data, int off, int len, int doff, int dlen) {
        if (len == 0) {
            this.data = LogUtils.ZERO_LENGTH_BYTE_ARRAY;
        } else {
            this.data = new byte[len];
            System.arraycopy(data, off, this.data, doff, dlen);
        }
    }

    private void init(byte[] data, int off, int len) {
        init(data, off, len, 0, len);
    }

    public byte[] getData() {
        return data;
    }

    public byte[] copyData() {
        int len = data.length;
        byte[] ret = new byte[len];
        System.arraycopy(data, 0, ret, 0, len);
        return ret;
    }

    public boolean isDeleted() {
        return (data == null);
    }

    void makeDeleted() {
        data = null;
    }

    public boolean isDirty() {
        return ((flags & DIRTY_BIT) != 0);
    }

    public void setDirty() {
        flags |= DIRTY_BIT;
    }

    private void clearDirty() {
        flags &= CLEAR_DIRTY_BIT;
    }

    /*
     * If you get to an LN, this subtree isn't valid for delete. True, the LN
     * may have been deleted, but you can't be sure without taking a lock, and
     * the validate -subtree-for-delete process assumes that bin compressing
     * has happened and there are no committed, deleted LNS hanging off the
     * BIN.
     */
    @Override
    boolean isValidForDelete() {
        return false;
    }

    /**
     * Returns true by default, but is overridden by MapLN to prevent eviction
     * of open databases.  This method is meant to be a fast but not guaranteed
     * check and is used during selection of BINs for LN stripping.  [#13415]
     */
    boolean isEvictableInexact() {
        return true;
    }

    /**
     * Returns true by default, but is overridden by MapLN to prevent eviction
     * of open databases.  This method is meant to be a guaranteed check and is
     * used after a BIN has been selected for LN stripping but before actually
     * stripping an LN. [#13415]
     * @throws DatabaseException from subclasses.
     */
    boolean isEvictable()
        throws DatabaseException {

        return true;
    }

    /**
     * A LN can never be a child in the search chain.
     */
    @Override
    protected boolean isSoughtNode(long nid,
                                   CacheMode cacheMode,
                                   boolean ignore/*doFetch*/) {
        return false;
    }

    /**
     * A LN can never be the ancestor of another node.
     */
    @Override
    protected boolean canBeAncestor(boolean targetContainsDuplicates) {
        return false;
    }

    /**
     * Delete this LN's data and log the new version.
     *
     * @param lnKey is the key of the BIN/DBIN parent of the LN.
     *
     * @param dupKey is null if the LN parent is a BIN, or is the main tree key
     * if the LN parent is a DBIN.
     */
    public long delete(DatabaseImpl database,
                       byte[] lnKey,
                       byte[] dupKey,
                       long oldLsn,
                       Locker locker,
                       ReplicationContext repContext)
        throws DatabaseException {

        /*
         * For a duplicates database, we always log a DeletedDupLNLogEntry.
         * When dupKey is null (because the parent is a BIN), we artificially
         * set dupKey and lnKey as if the parent were a DBIN.  Note that we
         * must use the data before calling makeDeleted, which sets the data to
         * null.  [#16940]
         */
        if (database.getSortedDuplicates() && dupKey == null) {
            dupKey = lnKey;
            lnKey = data;
        }

        makeDeleted();
        setDirty();

        /* Log if necessary */
        EnvironmentImpl env = database.getDbEnvironment();
        long newLsn = DbLsn.NULL_LSN;
        if (dupKey != null) {

            /*
             * If this is a deferred write database, and the LN has
             * never been logged, we don't need to log the delete either,
             * since we are currently running in non-txnal mode. This
             * will have to be adapted when we support txnal mode.
             */
            if (database.isDeferredWriteMode() &&
                oldLsn == DbLsn.NULL_LSN) {
                clearDirty();
            } else {

                /*
                 * Log as a deleted duplicate LN by passing dupKey.  Note that
                 * we log a deleted duplicate LN even in Deferred Write mode,
                 * because the data (dupKey) is set to null when it is deleted,
                 * so logging it later is not possible.
                 */
                newLsn = log(env, database, lnKey, dupKey, oldLsn, locker,
                             false,  // isProvisional
                             false, // backgroundIO
                             repContext);
            }
        } else {

            /*
             * Non duplicate LN, just log the normal way.
             */
            newLsn = optionalLog(env, database, lnKey, oldLsn,
                                 locker, repContext);
        }
        return newLsn;
    }

    /**
     * Modify the LN's data and log the new version.
     * @param repContext indicates whether this LN is part of the replication
     * stream. If this environment is a client node, repContext has the VLSN to
     * be used when logging the LN. If this environment is a master, it
     * indicates that the LN should be broadcast.
     */
    public long modify(byte[] newData,
                       DatabaseImpl database,
                       byte[] lnKey,
                       long oldLsn,
                       Locker locker,
                       ReplicationContext repContext)
        throws DatabaseException {

        data = newData;
        setDirty();

        /* Log the new LN. */
        EnvironmentImpl env = database.getDbEnvironment();
        long newLsn = optionalLog(env, database,
                                  lnKey, oldLsn, locker,
                                  repContext);
        return newLsn;
    }

    /**
     * Add yourself to the in memory list if you're a type of node that should
     * belong.
     */
    @Override
    void rebuildINList(INList inList) {
        /*
         * Don't add, LNs don't belong on the list.
         */
    }

    /**
     * No need to do anything, stop the search.
     */
    @Override
    void accountForSubtreeRemoval(INList inList,
                                  LocalUtilizationTracker localTracker) {
        /* Don't remove, LNs not on this list. */
    }

    /**
     * Compute the approximate size of this node in memory for evictor
     * invocation purposes.
     */
    @Override
    public long getMemorySizeIncludedByParent() {
        int size = MemoryBudget.LN_OVERHEAD;
        if (data != null) {
            size += MemoryBudget.byteArraySize(data.length);
        }
        return size;
    }

    /**
     * Release the memory budget for any objects referenced by this
     * LN. For now, only release treeAdmin memory, because treeMemory
     * is handled in aggregate at the IN level. Over time, transition
     * all of the LN's memory budget to this, so we update the memory
     * budget counters more locally. Called when we are releasing a LN
     * for garbage collection.
     */
    public void releaseMemoryBudget() {
        // nothing to do for now, no treeAdmin memory
    }

    /*
     * Dumping
     */

    public String beginTag() {
        return BEGIN_TAG;
    }

    public String endTag() {
        return END_TAG;
    }

    @Override
    public String dumpString(int nSpaces, boolean dumpTags) {
        StringBuffer self = new StringBuffer();
        if (dumpTags) {
            self.append(TreeUtils.indent(nSpaces));
            self.append(beginTag());
            self.append('\n');
        }

        self.append(super.dumpString(nSpaces + 2, true));
        self.append('\n');
        if (data != null) {
            self.append(TreeUtils.indent(nSpaces+2));
            self.append("<data>");
            self.append(Key.DUMP_TYPE.dumpByteArray(data));
            self.append("</data>");
            self.append('\n');
        }
        if (dumpTags) {
            self.append(TreeUtils.indent(nSpaces));
            self.append(endTag());
        }
        return self.toString();
    }

    /*
     * Logging Support
     */

    /**
     * Log this LN and clear the dirty flag. Whether it's logged as a
     * transactional entry or not depends on the type of locker.
     * @param env the environment.
     * @param dbId database id of this node. (Not stored in LN)
     * @param key key of this node. (Not stored in LN)
     * @param oldLsn is the LSN of the previous version or null.
     * @param locker owning locker.
     * @param repContext indicates whether this LN is part of the replication
     * stream. If this environment is a client node, repContext has the VLSN to
     * be used when logging the LN. If this environment is a master, it
     * indicates that the LN should be broadcast.
     */
    public long log(EnvironmentImpl env,
                    DatabaseImpl databaseImpl,
                    byte[] key,
                    long oldLsn,
                    Locker locker,
                    boolean backgroundIO,
                    ReplicationContext repContext)
        throws DatabaseException {

        return log(env, databaseImpl, key, null, /* delDupKey */
                   oldLsn, locker, backgroundIO, false, /* provisional */
                   repContext);
    }

    /**
     * Log this LN if it's not part of a deferred-write db.  Whether it's
     * logged as a transactional entry or not depends on the type of locker.
     * @param env the environment.
     * @param dbId database id of this node. (Not stored in LN)
     * @param key key of this node. (Not stored in LN)
     * @param oldLsn is the LSN of the previous version or NULL_LSN.
     * @param locker owning locker.
     * @param repContext indicates whether this LN is part of the replication
     * stream. If this environment is a client node, repContext has the VLSN to
     * be used when logging the LN. If this environment is a master, it
     * indicates that the LN should be broadcast.
     */
    public long optionalLog(EnvironmentImpl env,
                            DatabaseImpl databaseImpl,
                            byte[] key,
                            long oldLsn,
                            Locker locker,
                            ReplicationContext repContext)
        throws DatabaseException {

        if (databaseImpl.isDeferredWriteMode()) {
            return DbLsn.NULL_LSN;
        } else {
            return log(env,
                       databaseImpl,
                       key,
                       null,   // delDupKey
                       oldLsn,
                       locker,
                       false,  // backgroundIO
                       false,  // provisional
                       repContext);
        }
    }

    /**
     * Log a provisional, non-txnal version of an LN.
     * @param env the environment.
     * @param dbId database id of this node. (Not stored in LN)
     * @param key key of this node. (Not stored in LN)
     * @param oldLsn is the LSN of the previous version or NULL_LSN.
     */
    public long optionalLogProvisional(EnvironmentImpl env,
                                       DatabaseImpl databaseImpl,
                                       byte[] key,
                                       long oldLsn,
                                       ReplicationContext repContext)
        throws DatabaseException {

        if (databaseImpl.isDeferredWriteMode()) {
            return DbLsn.NULL_LSN;
        } else {
            return log(env, databaseImpl, key,
                       null,   // delDupKey
                       oldLsn,
                       null,   // locker
                       false,  // backgroundIO
                       true,   // provisional
                       repContext);
        }
    }

    /**
     * Log this LN. Clear dirty bit. Whether it's logged as a transactional
     * entry or not depends on the type of locker.
     * @param env the environment.
     * @param dbId database id of this node. (Not stored in LN)
     * @param key key of this node. (Not stored in LN)
     * @param delDupKey if non-null, the dupKey for deleting the LN.
     * @param oldLsn is the LSN of the previous version or NULL_LSN.
     * @param locker owning locker.
     */
    long log(EnvironmentImpl env,
             DatabaseImpl dbImpl,
             byte[] key,
             byte[] delDupKey,
             long oldLsn,
             Locker locker,
             boolean backgroundIO,
             boolean isProvisional,
             ReplicationContext repContext)
        throws DatabaseException {

        boolean isDelDup = (delDupKey != null);
        LogEntryType entryType;
        long logAbortLsn;
        boolean logAbortKnownDeleted;
        Txn logTxn;
        LogContext context = new LogContext();

        if (locker != null && locker.isTransactional()) {
            entryType = isDelDup ?
                LogEntryType.LOG_DEL_DUPLN_TRANSACTIONAL :
                getTransactionalLogType();
            WriteLockInfo info = locker.getWriteLockInfo(getNodeId());
            logAbortLsn = info.getAbortLsn();
            logAbortKnownDeleted = info.getAbortKnownDeleted();
            logTxn = locker.getTxnLocker();
            assert logTxn != null;
            if (oldLsn == logAbortLsn) {
                info.setAbortInfo(dbImpl, getLastLoggedSize());
            }
            context.obsoleteDupsAllowed = locker.isRolledBack();
        } else {
            entryType = isDelDup ? LogEntryType.LOG_DEL_DUPLN : getLogType();
            logAbortLsn = DbLsn.NULL_LSN;
            logAbortKnownDeleted = false;
            logTxn = null;
        }

        /* Don't count abortLsn as obsolete, this is done during commit. */
        if (oldLsn == logAbortLsn) {
            oldLsn = DbLsn.NULL_LSN;
        }

        /*
         * Always log temporary DB LNs as provisional.  This prevents the
         * possibility of a FileNotFoundException during recovery, since
         * temporary DBs are not checkpointed.  And it speeds recovery --
         * temporary DBs are removed during recovery anyway.
         */
        if (dbImpl.isTemporary()) {
            isProvisional = true;
        }

        LogItem item = new LogItem();
        item.entry = createLogEntry(entryType,
                                    dbImpl,
                                    key,
                                    delDupKey,
                                    logAbortLsn,
                                    logAbortKnownDeleted,
                                    logTxn,
                                    repContext);

        item.provisional =  isProvisional ? Provisional.YES : Provisional.NO;
        item.oldLsn = oldLsn;
        item.repContext = repContext;
        context.backgroundIO = backgroundIO;
        context.nodeDb = dbImpl;

        try {
            if (logTxn != null) {

                /*
                 * Writing an LN_TX entry requires looking at the Txn's
                 * lastLoggedTxn.  The Txn may be used by multiple threads so
                 * ensure that the view we get is consistent. [#17204]
                 */
                synchronized (logTxn) {
                    env.getLogManager().log(item, context);
                }
            } else {
                env.getLogManager().log(item, context);
            }
        } catch (DatabaseException e) {
            if (FileManager.continueAfterWriteException()) {

                /*
                 * Test mode.  Ensure txn is aborted. Use an
                 * OperationFailureException that is not exposed in the API.
                 * Create exception to invalidate the txn.  [#15768]
                 */
                if (locker != null) {
                    new LNWriteFailureException(locker, e);
                }
                throw e;
            } else {

                /*
                 * In production mode, if any exception occurs while logging an
                 * LN, ensure that the environment is invalidated.  This will
                 * also ensure that the txn cannot be committed.
                 */
                if (env.isValid()) {
                    throw new EnvironmentFailureException
                        (env,
                         EnvironmentFailureReason.LOG_INCOMPLETE,
                         "LN could not be logged", e);
                } else {
                    throw e;
                }
            }
        }
        clearDirty();
        return item.newLsn;
    }

    static class LNWriteFailureException
        extends OperationFailureException {

        LNWriteFailureException(Locker locker, Exception cause) {
            super(locker, true /*abortOnly*/, null /*message*/, cause);
        }

        private LNWriteFailureException(String message,
                                        LNWriteFailureException cause) {
            super(message, cause);
        }

        @Override
        public OperationFailureException wrapSelf(String msg) {
            return new LNWriteFailureException(msg, this);
        }
    }

    /*
     * Each LN knows what kind of log entry it uses to log itself. Overridden
     * by subclasses.
     */
    LNLogEntry createLogEntry(LogEntryType entryType,
                              DatabaseImpl dbImpl,
                              byte[] key,
                              byte[] delDupKey,
                              long logAbortLsn,
                              boolean logAbortKnownDeleted,
                              Txn logTxn,
                              ReplicationContext repContext) {

        DatabaseId dbId = dbImpl.getId();
        boolean isDelDup = (delDupKey != null);
        if (isDelDup) {

            /*
             * Deleted Duplicate LNs are logged with two keys -- the one
             * that identifies the main tree (the dup key) and the one that
             * places them in the duplicate tree (really the data) since we
             * can't recreate the latter because the data field has been
             * nulled. Note that the dupKey is passed to the log manager
             * FIRST, because the dup key is the one that navigates us in
             * the main tree. The "key" is the one that navigates us in the
             * duplicate tree.
             */
            return new DeletedDupLNLogEntry(entryType,
                                            this,
                                            dbId,
                                            delDupKey,
                                            key,
                                            logAbortLsn,
                                            logAbortKnownDeleted,
                                            logTxn);
        } else {
            /* Not a deleted duplicate LN -- use a regular LNLogEntry. */
            return new LNLogEntry(entryType,
                                  this,
                                  dbId,
                                  key,
                                  logAbortLsn,
                                  logAbortKnownDeleted,
                                  logTxn);
        }
    }

    /**
     * @see Node#incFetchStats
     */
    @Override
    public void incFetchStats(EnvironmentImpl envImpl, boolean isMiss) {
        envImpl.getEvictor().incLNFetchStats(isMiss);
    }

    /**
     * Log type for transactional entries
     */
    protected LogEntryType getTransactionalLogType() {
        return LogEntryType.LOG_LN_TRANSACTIONAL;
    }

    /**
     * @see Node#getLogType()
     */
    @Override
    public LogEntryType getLogType() {
        return LogEntryType.LOG_LN;
    }

    /**
     * Returns the total last logged log size, including the LNLogEntry
     * overhead of this LN when it was last logged and the log entry
     * header.  Used for computing obsolete size when an LNLogEntry is not in
     * hand.
     */
    public int getLastLoggedSize() {
        return flags & LAST_LOGGED_SIZE_MASK;
    }

    /**
     * Saves the last logged size.
     */
    public void setLastLoggedSize(int size) {
        /* Clear the old size and OR in the new size. */
        flags = (flags & CLEAR_LAST_LOGGED_SIZE) | size;
    }

    /**
     * @see Loggable#getLogSize
     */
    @Override
    public int getLogSize() {
        int size = super.getLogSize();

        if (isDeleted()) {
            size += LogUtils.getPackedIntLogSize(-1);
        } else {
            int len = data.length;
            size += LogUtils.getPackedIntLogSize(len);
            size += len;
        }

        return size;
    }

    /**
     * @see Loggable#writeToLog
     */
    @Override
    public void writeToLog(ByteBuffer logBuffer) {
        super.writeToLog(logBuffer);

        if (isDeleted()) {
            LogUtils.writePackedInt(logBuffer, -1);
        } else {
            LogUtils.writePackedInt(logBuffer, data.length);
            LogUtils.writeBytesNoLength(logBuffer, data);
        }
    }

    /**
     * @see Loggable#readFromLog
     */
    @Override
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {

        super.readFromLog(itemBuffer, entryVersion);

        if (entryVersion < 6) {
            boolean dataExists = LogUtils.readBoolean(itemBuffer);
            if (dataExists) {
                data = LogUtils.readByteArray(itemBuffer, true/*unpacked*/);
            }
        } else {
            int size = LogUtils.readInt(itemBuffer, false/*unpacked*/);
            if (size >= 0) {
                data = LogUtils.readBytesNoLength(itemBuffer, size);
            }
        }
    }

    /**
     * @see Loggable#logicalEquals
     */
    public boolean logicalEquals(Loggable other) {

        if (!(other instanceof LN))
            return false;

        LN otherLN = (LN) other;

        if (getNodeId() != otherLN.getNodeId())
            return false;

        if (!Arrays.equals(getData(), otherLN.getData()))
            return false;

        return true;
    }

    /**
     * @see Loggable#dumpLog
     */
    @Override
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append(beginTag());
        super.dumpLog(sb, verbose);

        if (data != null) {
            sb.append("<data>");
            if (verbose) {
                sb.append(Key.DUMP_TYPE.dumpByteArray(data));
            } else {
                sb.append("hidden");
            }
            sb.append("</data>");
        }

        dumpLogAdditional(sb, verbose);

        sb.append(endTag());
    }

    public void dumpKey(StringBuilder sb, byte[] key) {
        sb.append(Key.dumpString(key, 0));
    }

    /*
     * Allows subclasses to add additional fields before the end tag.
     */
    protected void dumpLogAdditional(StringBuilder sb, 
                                     @SuppressWarnings("unused") boolean verbose) {
    }
}
