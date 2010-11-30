/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * Specifies the attributes of database cursor.  An instance created with the
 * default constructor is initialized with the system's default settings.
 */
public class CursorConfig implements Cloneable {

    /**
     * Default configuration used if null is passed to methods that create a
     * cursor.
     */
    public static final CursorConfig DEFAULT = new CursorConfig();

    /**
     * A convenience instance to configure read operations performed by the
     * cursor to return modified but not yet committed data.
     */
    public static final CursorConfig READ_UNCOMMITTED = new CursorConfig();

    /**
     * A convenience instance to configure a cursor for read committed
     * isolation.
     *
     * This ensures the stability of the current data item read by the cursor
     * but permits data read by this cursor to be modified or deleted prior to
     * the commit of the transaction.
     */
    public static final CursorConfig READ_COMMITTED = new CursorConfig();

    static {
        READ_UNCOMMITTED.setReadUncommitted(true);
        READ_COMMITTED.setReadCommitted(true);
    }

    private boolean readUncommitted = false;
    private boolean readCommitted = false;

    /**
     * An instance created using the default constructor is initialized with
     * the system's default settings.
     */
    public CursorConfig() {
    }

    /**
     * Configures read operations performed by the cursor to return modified
     * but not yet committed data.
     *
     * @param readUncommitted If true, configure read operations performed by
     * the cursor to return modified but not yet committed data.
     *
     * @see LockMode#READ_UNCOMMITTED
     *
     * @return this
     */
    public CursorConfig setReadUncommitted(boolean readUncommitted) {
        this.readUncommitted = readUncommitted;
        return this;
    }

    /**
     * Returns true if read operations performed by the cursor are configured
     * to return modified but not yet committed data.
     *
     * @return true if read operations performed by the cursor are configured
     * to return modified but not yet committed data.
     *
     * @see LockMode#READ_UNCOMMITTED
     */
    public boolean getReadUncommitted() {
        return readUncommitted;
    }

    /**
     * Configures read operations performed by the cursor to obey read
     * committed isolation. Read committed isolation provides for cursor
     * stability but not repeatable reads. Data items which have been
     * previously read by this transaction may be deleted or modified by other
     * transactions before the cursor is closed or the transaction completes.
     *
     * @param readCommitted If true, configure read operations performed by
     * the cursor to obey read committed isolation.
     *
     * @see LockMode#READ_COMMITTED
     *
     * @return this
     */
    public CursorConfig setReadCommitted(boolean readCommitted) {
        this.readCommitted = readCommitted;
        return this;
    }


   /**
     * Returns true if read operations performed by the cursor are configured
     * to obey read committed isolation.
     *
     * @return true if read operations performed by the cursor are configured
     * to obey read committed isolation.
     *
     * @see LockMode#READ_COMMITTED
     */
    public boolean getReadCommitted() {
        return readCommitted;
    }

    /**
     * Returns a copy of this configuration object.
     */
    @Override
    public CursorConfig clone() {
        try {
            return (CursorConfig) super.clone();
        } catch (CloneNotSupportedException willNeverOccur) {
            return null;
        }
    }

    /**
     * Returns the values for each configuration attribute.
     *
     * @return the values for each configuration attribute.
     */
    @Override
    public String toString() {
        return "readUncommitted=" + readUncommitted +
            "\nreadCommitted=" + readCommitted +
            "\n";
    }
}
