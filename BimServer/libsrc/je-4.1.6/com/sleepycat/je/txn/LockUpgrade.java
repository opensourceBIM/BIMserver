/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.txn;

/**
 * LockUpgrade is a type safe enumeration of lock upgrade types.  Methods on
 * LockUpgrade objects are used to determine whether an upgrade is needed and,
 * if so, how it should be handled.
 */
public class LockUpgrade {

    /*
     * Due to static initialization circularities between LockUpgrade and
     * LockType, the LockUpgrade.upgrade field of each of these LockUpgrades
     * will get filled in by a piece of static code in EnvironmentImpl.
     * [#16496]
     */
    public static final LockUpgrade ILLEGAL =
        new LockUpgrade(null, false, true);
    public static final LockUpgrade EXISTING =
        new LockUpgrade(null, false, false);
    public static final LockUpgrade WRITE_PROMOTE =
        new LockUpgrade(null /*LockType.WRITE*/, true, false);
    public static final LockUpgrade RANGE_READ_IMMED =
        new LockUpgrade(null /*LockType.RANGE_READ*/, false, false);
    public static final LockUpgrade RANGE_WRITE_IMMED =
        new LockUpgrade(null /*LockType.RANGE_WRITE*/, false, false);
    public static final LockUpgrade RANGE_WRITE_PROMOTE =
        new LockUpgrade(null /*LockType.RANGE_WRITE*/, true, false);

    private LockType upgrade;
    private boolean promotion;
    private boolean illegal;

    /**
     * No upgrade types can be defined outside this class.
     */
    private LockUpgrade(LockType upgrade, boolean promotion, boolean illegal) {
        this.upgrade = upgrade;
        this.promotion = promotion;
        this.illegal = illegal;
    }

    /**
     * This method is called to determine whether the upgrade is illegal.
     * If true is returned, an internal error has occurred.  This should never
     * happen since RANGE_INSERT should never be requested along with other
     * locks by the same locker; a separate locker is used for RANGE_INSERT
     * locks.
     */
    boolean getIllegal() {
        return illegal;
    }

    /**
     * This method is called first to determine whether an upgrade to a new
     * lock type is needed, and what the new lock type should be.  If null is
     * returned, the existing lock should be unchanged and no upgrade is
     * needed.  If non-null is returned, an upgrade to the returned type should
     * be performed; in this case, call getPromotion to determine how to do the
     * upgrade.
     */
    LockType getUpgrade() {
        return upgrade;
    }

    /**
     * @hidden
     */
    public void setUpgrade(LockType upgrade) {
        this.upgrade = upgrade;
    }

    /**
     * This method is called when getUpgrade returns non-null to determine
     * whether the upgrade is a true promotion or can be granted immediately.
     * A true promotion is a change from read to write locking, and may require
     * waiting if the write lock conflicts with a lock held by another locker.
     * An upgrade that is not a promotion is just a type change, and never
     * causes a lock conflict.
     */
    boolean getPromotion() {
        return promotion;
    }
}
