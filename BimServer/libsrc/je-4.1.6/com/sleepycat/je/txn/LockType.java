/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

/**
 * LockType is a type safe enumeration of all lock types.  Methods on LockType
 * objects can be used to determine whether a type conflicts with another
 * type or can be upgraded to another type.
 */
public class LockType {

    /**
     * Lock types.  Indexes must be kept manually synchronized in the matrixes
     * below.
     */
    public static final LockType READ =
        new LockType(0, false, "READ");
    public static final LockType WRITE =
        new LockType(1, true, "WRITE");
    public static final LockType RANGE_READ =
        new LockType(2, false, "RANGE_READ");
    public static final LockType RANGE_WRITE =
        new LockType(3, true, "RANGE_WRITE");
    public static final LockType RANGE_INSERT =
        new LockType(4, false, "RANGE_INSERT");

    /**
     * NONE is used for requesting a dirty read and does not appear in the
     * conflict or upgrade matrices.
     */
    public static final LockType NONE =
        new LockType(5, false, "NONE");

    /**
     * RESTART is used for waiting for a restart and does not appear in the
     * conflict or upgrade matrices.
     */
    public static final LockType RESTART =
        new LockType(6, false, "RESTART");

    /**
     * Whenever the conflict matrix is changed be sure to update this.  For
     * every type that can cause a RESTART result call setCausesRestart.  This
     * could have been determined programmatically but I chose to maintain it
     * manually to avoid extra code size.
     */
    static {
        RANGE_READ.setCausesRestart();
        RANGE_WRITE.setCausesRestart();
    }

    /**
     * Lock conflict matrix.
     * @see #getConflict
     */
    private static LockConflict[][] conflictMatrix = {
        { // READ is held and there is a request for:
            LockConflict.ALLOW,   // READ
            LockConflict.BLOCK,   // WRITE
            LockConflict.ALLOW,   // RANGE_READ
            LockConflict.BLOCK,   // RANGE_WRITE
            LockConflict.ALLOW,   // RANGE_INSERT
        },
        { // WRITE is held and there is a request for:
            LockConflict.BLOCK,   // READ
            LockConflict.BLOCK,   // WRITE
            LockConflict.BLOCK,   // RANGE_READ
            LockConflict.BLOCK,   // RANGE_WRITE
            LockConflict.ALLOW,   // RANGE_INSERT
        },
        { // RANGE_READ is held and there is a request for:
            LockConflict.ALLOW,   // READ
            LockConflict.BLOCK,   // WRITE
            LockConflict.ALLOW,   // RANGE_READ
            LockConflict.BLOCK,   // RANGE_WRITE
            LockConflict.BLOCK,   // RANGE_INSERT
        },
        { // RANGE_WRITE is held and there is a request for:
            LockConflict.BLOCK,   // READ
            LockConflict.BLOCK,   // WRITE
            LockConflict.BLOCK,   // RANGE_READ
            LockConflict.BLOCK,   // RANGE_WRITE
            LockConflict.BLOCK,   // RANGE_INSERT
        },
        { // RANGE_INSERT is held and there is a request for:
            LockConflict.ALLOW,   // READ
            LockConflict.ALLOW,   // WRITE
            LockConflict.RESTART, // RANGE_READ
            LockConflict.RESTART, // RANGE_WRITE
            LockConflict.ALLOW,   // RANGE_INSERT
        },
    };

    /**
     * Lock upgrade matrix.
     * @see #getUpgrade
     */
    private static LockUpgrade[][] upgradeMatrix = {
        { // READ is held and there is a request for:
            LockUpgrade.EXISTING,                  // READ
            LockUpgrade.WRITE_PROMOTE,             // WRITE
            LockUpgrade.RANGE_READ_IMMED,          // RANGE_READ
            LockUpgrade.RANGE_WRITE_PROMOTE,       // RANGE_WRITE
            LockUpgrade.ILLEGAL,                   // RANGE_INSERT
        },
        { // WRITE is held and there is a request for:
            LockUpgrade.EXISTING,                  // READ
            LockUpgrade.EXISTING,                  // WRITE
            LockUpgrade.RANGE_WRITE_IMMED,         // RANGE_READ
            LockUpgrade.RANGE_WRITE_IMMED,         // RANGE_WRITE
            LockUpgrade.ILLEGAL,                   // RANGE_INSERT
        },
        { // RANGE_READ is held and there is a request for:
            LockUpgrade.EXISTING,                  // READ
            LockUpgrade.RANGE_WRITE_PROMOTE,       // WRITE
            LockUpgrade.EXISTING,                  // RANGE_READ
            LockUpgrade.RANGE_WRITE_PROMOTE,       // RANGE_WRITE
            LockUpgrade.ILLEGAL,                   // RANGE_INSERT
        },
        { // RANGE_WRITE is held and there is a request for:
            LockUpgrade.EXISTING,                  // READ
            LockUpgrade.EXISTING,                  // WRITE
            LockUpgrade.EXISTING,                  // RANGE_READ
            LockUpgrade.EXISTING,                  // RANGE_WRITE
            LockUpgrade.ILLEGAL,                   // RANGE_INSERT
        },
        { // RANGE_INSERT is held and there is a request for:
            LockUpgrade.ILLEGAL,                   // READ
            LockUpgrade.ILLEGAL,                   // WRITE
            LockUpgrade.ILLEGAL,                   // RANGE_READ
            LockUpgrade.ILLEGAL,                   // RANGE_WRITE
            LockUpgrade.EXISTING,                  // RANGE_INSERT
        },
    };

    private int index;
    private boolean write;
    private String name;
    private boolean causesRestart;

    /**
     * No lock types can be defined outside this class.
     */
    private LockType(int index, boolean write, String name) {
        this.index = index;
        this.write = write;
        this.name = name;
    }

    /**
     * Returns true if this is a WRITE or RANGE_WRITE lock.  For RANGE_INSERT,
     * false is returned because RANGE_INSERT is used to lock the key following
     * the insertion key, not the insertion key itself.
     */
    public final boolean isWriteLock() {
        return write;
    }

    /**
     * Specifies that when this type is requested it can result in
     * LockGrantType.RESTART.
     */
    private void setCausesRestart() {
        causesRestart = true;
    }

    /**
     * Returns whether when this type is requested it can result in
     * LockGrantType.RESTART.
     */
    final boolean getCausesRestart() {
        return causesRestart;
    }

    /**
     * Returns the LockConfict that results when this lock type is held and the
     * given lock type is requested by another locker.
     */
    LockConflict getConflict(LockType requestedType) {
        return conflictMatrix[index][requestedType.index];
    }

    /**
     * Returns the LockUpgrade that results when this lock type is held and the
     * given lock type is requested by the same locker.
     *
     * <p>For the returned LockUpgrade object, getIllegal will never return
     * true because this method fires an assertion if getIllegal returns true.
     */
    LockUpgrade getUpgrade(LockType requestedType) {
        LockUpgrade upgrade = upgradeMatrix[index][requestedType.index];
        assert !upgrade.getIllegal() : toString() + " to " + requestedType;
        return upgrade;
    }

    @Override
    public String toString() {
        return name;
    }
}
