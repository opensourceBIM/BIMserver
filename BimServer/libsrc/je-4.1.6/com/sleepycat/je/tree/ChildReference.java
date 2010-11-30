/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.utilint.DbLsn;

/**
 * A ChildReference is a reference in the tree from parent to child.  It
 * contains a node reference, key, and LSN.
 */
public class ChildReference implements Loggable {

    private Node target;
    private long lsn;
    private byte[] key;

    /*
     * The state byte holds knownDeleted state in bit 0 and dirty state in bit
     * 1. Bit flags are used here because of the desire to keep the child
     * reference compact. State is persistent because knownDeleted is
     * persistent, but the dirty bit is cleared when read in from the log.
     *
     * -- KnownDeleted is a way of indicating that the reference is invalid
     * without logging new data. This happens in aborts and recoveries. If
     * knownDeleted is true, this entry is surely deleted. If knownDeleted is
     * false, this entry may or may not be deleted. Future space optimizations:
     * store as a separate bit array in the BIN, or subclass ChildReference and
     * make a special reference only used by BINs and not by INs.
     *
     * -- Dirty is true if the LSN or key has been changed since the last time
     * the ownign node was logged. This supports the calculation of BIN deltas.
     */
    private byte state;
    private static final byte KNOWN_DELETED_BIT = 0x1;
    private static final byte DIRTY_BIT = 0x2;
    private static final byte CLEAR_DIRTY_BIT = ~0x2;
    private static final byte MIGRATE_BIT = 0x4;
    private static final byte CLEAR_MIGRATE_BIT = ~0x4;
    private static final byte PENDING_DELETED_BIT = 0x8;

    /**
     * Construct an empty child reference, for reading from the log.
     */
    ChildReference() {
        init(null, Key.EMPTY_KEY, DbLsn.NULL_LSN, 0);
    }

    /**
     * Construct a ChildReference for inserting a new entry.
     */
    public ChildReference(Node target, byte[] key, long lsn) {
        init(target, key, lsn, DIRTY_BIT);
    }

    /**
     * Construct a ChildReference for inserting an existing entry.
     */
    public ChildReference(Node target,
                          byte[] key,
                          long lsn,
                          byte existingState) {
        init(target, key, lsn, existingState | DIRTY_BIT);
    }

    private void init(Node target,
                      byte[] key,
                      long lsn,
                      int state) {
        this.target = target;
        this.key = key;
        this.lsn = lsn;
        this.state = (byte) state;
    }

    /**
     * Return the key for this ChildReference.
     */
    public byte[] getKey() {
        return key;
    }

    /**
     * Set the key for this ChildReference.
     */
    public void setKey(byte[] key) {
        this.key = key;
        setDirty();
    }

    /**
     * Fetch the target object that this ChildReference refers to.  If the
     * object is already in VM, then just return the reference to it.  If the
     * object is not in VM, then read the object from the log.  If the object
     * has been faulted in and the in arg is supplied, then the total memory
     * size cache in the IN is invalidated.
     *
     * @param database The database that this ChildReference resides in.
     * @param in The IN that this ChildReference lives in.  If
     * the target is fetched (i.e. it is null on entry), then the
     * total in memory count is invalidated in the IN. May be null.
     * For example, the root is a ChildReference and there is no parent IN
     * when the rootIN is fetched in.
     * @return the Node object representing the target node in the tree, or
     * null if there is no target of this ChildReference, or null if a
     * pendingDelete or knownDeleted entry has been cleaned.
     */
    public Node fetchTarget(DatabaseImpl database, IN in)
        throws DatabaseException {

        if (target == null) {
            /* fault object in from log */
            if (lsn == DbLsn.NULL_LSN) {
                if (!isKnownDeleted()) {
                    throw EnvironmentFailureException.unexpectedState
                        (IN.makeFetchErrorMsg("NULL_LSN without KnownDeleted",
                                              in, lsn, state));
                }
                /* Ignore a NULL_LSN (return null) if KnownDeleted is set. */
            } else {
                EnvironmentImpl envImpl = database.getDbEnvironment();
                try {
                    Node node = (Node) envImpl.getLogManager().getEntry(lsn);
                    node.postFetchInit(database, lsn);
                    target = node;
                    if (in != null) {
                        in.updateMemorySize(null, target);
                    }
                } catch (FileNotFoundException e) {
                    if (!isKnownDeleted() &&
                        !isPendingDeleted()) {
                        throw new EnvironmentFailureException
                            (envImpl,
                             EnvironmentFailureReason.LOG_FILE_NOT_FOUND,
                             IN.makeFetchErrorMsg
                                (e.toString(), in, lsn, state),
                             e);
                    }

                    /*
                     * This is a LOG_FILE_NOT_FOUND for a KD or PD entry.
                     *
                     * Ignore. Cleaner got to it, so just return null.
                     */
                } catch (EnvironmentFailureException e) {
                    e.addErrorMessage
                        (IN.makeFetchErrorMsg(null, in, lsn, state));
                    throw e;
                } catch (RuntimeException e) {
                    throw new EnvironmentFailureException
                        (envImpl,
                         EnvironmentFailureReason.LOG_INTEGRITY,
                         IN.makeFetchErrorMsg(e.toString(), in, lsn, state),
                         e);
                }
            }
        }

        return target;
    }

    /*
     * Return the state byte for this ChildReference.
     */
    byte getState() {
        return state;
    }

    /**
     * Return the target for this ChildReference.
     */
    public Node getTarget() {
        return target;
    }

    /**
     * Sets the target for this ChildReference. No need to make dirty, that
     * state only applies to key and LSN.
     */
    public void setTarget(Node target) {
        this.target = target;
    }

    /**
     * Clear the target for this ChildReference. No need to make dirty, that
     * state only applies to key and LSN. This method is public because it's
     * safe and used by RecoveryManager. This can't corrupt the tree.
     */
    public void clearTarget() {
        this.target = null;
    }

    /**
     * Return the LSN for this ChildReference.
     *
     * @return the LSN for this ChildReference.
     */
    public long getLsn() {
        return lsn;
    }

    /**
     * Sets the target LSN for this ChildReference.
     *
     * @param the target LSN.
     */
    public void setLsn(long lsn) {
        this.lsn = lsn;
        setDirty();
    }

    /**
     * Do deferredWrite optional logging check.
     */
    void updateLsnAfterOptionalLog(DatabaseImpl dbImpl, long lsn) {
        if ((lsn == DbLsn.NULL_LSN) &&
            dbImpl.isDeferredWriteMode()) {
            /*
             * Don't update the lsn -- we don't want to overwrite a
             * non-null lsn.
             */
            setDirty();
        } else {
            setLsn(lsn);
        }
    }

    private void setDirty() {
        state |= DIRTY_BIT;
    }

    /**
     * @return true if the entry has been deleted, although the transaction the
     * performed the deletion may not be committed.
     */
    private boolean isPendingDeleted() {
        return ((state & PENDING_DELETED_BIT) != 0);
    }

    /**
     * @return true if entry is deleted for sure.
     */
    public boolean isKnownDeleted() {
        return ((state & KNOWN_DELETED_BIT) != 0);
    }

    /**
     * @return true if the object is dirty.
     */
    private boolean isDirty() {
        return ((state & DIRTY_BIT) != 0);
    }

    /**
     * Get the entry migrate status.
     */
    public boolean getMigrate() {
        return (state & MIGRATE_BIT) != 0;
    }

    /**
     * Set the entry migrate status.
     */
    public void setMigrate(boolean migrate) {
        if (migrate) {
            state |= MIGRATE_BIT;
        } else {
            state &= CLEAR_MIGRATE_BIT;
        }
    }

    /*
     * Support for logging.
     */

    /**
     * @see Loggable#getLogSize
     */
    public int getLogSize() {
        return
            LogUtils.getByteArrayLogSize(key) +   // key
            LogUtils.getPackedLongLogSize(lsn) +  // LSN
            1;                                    // state
    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer logBuffer) {
        LogUtils.writeByteArray(logBuffer, key);  // key
        LogUtils.writePackedLong(logBuffer, lsn);
        logBuffer.put(state);                     // state
        state &= CLEAR_DIRTY_BIT;
    }

    /**
     * @see Loggable#readFromLog
     */
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {
        boolean unpacked = (entryVersion < 6);
        key = LogUtils.readByteArray(itemBuffer, unpacked);      // key
        lsn = LogUtils.readLong(itemBuffer, unpacked);           // LSN
        state = itemBuffer.get();                                // state
        state &= CLEAR_DIRTY_BIT;
    }

    /**
     * @see Loggable#dumpLog
     */
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<ref kd=\"").append(isKnownDeleted());
        sb.append("\" pd=\"").append(isPendingDeleted());
        sb.append("\">");
        sb.append(Key.dumpString(key, 0));
        sb.append(DbLsn.toString(lsn));
        sb.append("</ref>");
    }

    /**
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return 0;
    }

    /**
     * @see Loggable#logicalEquals
     * Always return false, this item should never be compared.
     */
    public boolean logicalEquals(Loggable other) {
        return false;
    }

    /*
     * Dumping
     */
    String dumpString(int nspaces, boolean dumpTags) {
        StringBuffer sb = new StringBuffer();
        if (lsn == DbLsn.NULL_LSN) {
            sb.append(TreeUtils.indent(nspaces));
            sb.append("<lsn/>");
        } else {
            sb.append(DbLsn.dumpString(lsn, nspaces));
        }
        sb.append('\n');
        if (key == null) {
            sb.append(TreeUtils.indent(nspaces));
            sb.append("<key/>");
        } else {
            sb.append(Key.dumpString(key, nspaces));
        }
        sb.append('\n');
        if (target == null) {
            sb.append(TreeUtils.indent(nspaces));
            sb.append("<target/>");
        } else {
            sb.append(target.dumpString(nspaces, true));
        }
        sb.append('\n');
        sb.append(TreeUtils.indent(nspaces));
        sb.append("<knownDeleted val=\"");
        sb.append(isKnownDeleted()).append("\"/>");
        sb.append("<pendingDeleted val=\"");
        sb.append(isPendingDeleted()).append("\"/>");
        sb.append("<dirty val=\"").append(isDirty()).append("\"/>");
        return sb.toString();
    }

    @Override
    public String toString() {
        return dumpString(0, false);
    }
}
