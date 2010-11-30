/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Specifies the attributes of a database environment transaction.
 */
public class TransactionConfig implements Cloneable {

    /**
     * Default configuration used if null is passed to methods that create a
     * transaction.
     */
    public static final TransactionConfig DEFAULT = new TransactionConfig();

    private boolean sync = false;
    private boolean noSync = false;
    private boolean writeNoSync = false;
    private Durability durability = null;
    private ReplicaConsistencyPolicy consistencyPolicy;

    private boolean noWait = false;
    private boolean readUncommitted = false;
    private boolean readCommitted = false;
    private boolean serializableIsolation = false;

    /**
     * An instance created using the default constructor is initialized with
     * the system's default settings.
     */
    public TransactionConfig() {
    }

    /**
     * @hidden
     * For internal use only.
     *
     * Maps the existing sync settings to the equivalent durability settings.
     * Figure out what we should do on commit. TransactionConfig could be
     * set with conflicting values; take the most stringent ones first.
     * All environment level defaults were applied by the caller.
     *
     * ConfigSync  ConfigWriteNoSync ConfigNoSync   default
     *    0                 0             0         sync
     *    0                 0             1         nosync
     *    0                 1             0         write nosync
     *    0                 1             1         write nosync
     *    1                 0             0         sync
     *    1                 0             1         sync
     *    1                 1             0         sync
     *    1                 1             1         sync
     *
     * @return the equivalent durability
     */
    public Durability getDurabilityFromSync(EnvironmentImpl envImpl) {
        if (sync) {
            return Durability.COMMIT_SYNC;
        } else if (writeNoSync) {
            return Durability.COMMIT_WRITE_NO_SYNC;
        } else if (noSync) {
            return Durability.COMMIT_NO_SYNC;
        }

        /*
         * Replicated environments default to commitNoSync, while standalone
         * default to commitSync.
         */
        if (envImpl.isReplicated()) {
            return Durability.COMMIT_NO_SYNC;
        } else {
            return Durability.COMMIT_SYNC;
        }
    }

    /**
     * Configures the transaction to write and synchronously flush the log it
     * when commits.
     *
     * <p>This behavior may be set for a database environment using the
     * Environment.setMutableConfig method. Any value specified to this method
     * overrides that setting.</p>
     *
     * <p>The default is false for this class and true for the database
     * environment.</p>
     *
     * <p>If true is passed to both setSync and setNoSync, setSync will take
     * precedence.</p>
     *
     * @param sync If true, transactions exhibit all the ACID (atomicity,
     * consistency, isolation, and durability) properties.
     *
     * @return this
     */
    public TransactionConfig setSync(boolean sync) {
        checkMixedMode(sync, noSync, writeNoSync, durability);
        this.sync = sync;
        return this;
    }

    /**
     * Returns true if the transaction is configured to write and synchronously
     * flush the log it when commits.
     *
     * @return true if the transaction is configured to write and synchronously
     * flush the log it when commits.
     */
    public boolean getSync() {
        return sync;
    }

    /**
     * Configures the transaction to not write or synchronously flush the log
     * it when commits.
     *
     * <p>This behavior may be set for a database environment using the
     * Environment.setMutableConfig method. Any value specified to this method
     * overrides that setting.</p>
     *
     * <p>The default is false for this class and the database environment.</p>
     *
     * @param noSync If true, transactions exhibit the ACI (atomicity,
     * consistency, and isolation) properties, but not D (durability); that is,
     * database integrity will be maintained, but if the application or system
     * fails, it is possible some number of the most recently committed
     * transactions may be undone during recovery. The number of transactions
     * at risk is governed by how many log updates can fit into the log buffer,
     * how often the operating system flushes dirty buffers to disk, and how
     * often the log is checkpointed.
     *
     * @deprecated replaced by {@link #setDurability}
     *
     * @return this
     */
    public TransactionConfig setNoSync(boolean noSync) {
        checkMixedMode(sync, noSync, writeNoSync, durability);
        this.noSync = noSync;
        return this;
    }

    /**
     * Returns true if the transaction is configured to not write or
     * synchronously flush the log it when commits.
     *
     * @return true if the transaction is configured to not write or
     * synchronously flush the log it when commits.
     *
     * @deprecated replaced by {@link #getDurability}
     */
    public boolean getNoSync() {
        return noSync;
    }

    /**
     * Configures the transaction to write but not synchronously flush the log
     * it when commits.
     *
     * <p>This behavior may be set for a database environment using the
     * Environment.setMutableConfig method. Any value specified to this method
     * overrides that setting.</p>
     *
     * <p>The default is false for this class and the database environment.</p>
     *
     * @param writeNoSync If true, transactions exhibit the ACI (atomicity,
     * consistency, and isolation) properties, but not D (durability); that is,
     * database integrity will be maintained, but if the operating system
     * fails, it is possible some number of the most recently committed
     * transactions may be undone during recovery. The number of transactions
     * at risk is governed by how often the operating system flushes dirty
     * buffers to disk, and how often the log is checkpointed.
     *
     * @deprecated replaced by {@link #setDurability}
     *
     * @return this
     */
    public TransactionConfig setWriteNoSync(boolean writeNoSync) {
        checkMixedMode(sync, noSync, writeNoSync, durability);
        this.writeNoSync = writeNoSync;
        return this;
    }

    /**
     * Returns true if the transaction is configured to write but not
     * synchronously flush the log it when commits.
     *
     * @return true if the transaction is configured to not write or
     * synchronously flush the log it when commits.
     *
     * @deprecated replaced by {@link #getDurability}
     */
    public boolean getWriteNoSync() {
        return writeNoSync;
    }

    /**
     * Configures the durability associated with a transaction when it commits.
     * Changes to durability are not reflected back to the "sync" booleans --
     * there isn't a one to one mapping.
     *
     * Note that you should not use both the durability and the XXXSync() apis
     * on the same config object.
     *
     * @param durability the durability definition
     *
     * @return this
     */
    public TransactionConfig setDurability(Durability durability) {
        checkMixedMode(sync, noSync, writeNoSync, durability);
        this.durability = durability;
        return this;
    }

    /**
     * Returns the durability associated with the configuration. As a
     * compatibility hack, it currently returns the local durability
     * computed from the current "sync" settings, if the durability has not
     * been explicitly set by the application.
     *
     * @return the durability setting currently associated with this config.
     */
    public Durability getDurability() {
        return durability;
    }

    /**
     * Used internally to configure Durability, modifying the existing
     * Durability or explicit sync configuration.  This method is used to avoid
     * a mixed mode exception, since the existing config may be in either mode.
     */
    void overrideDurability(Durability durability) {
        sync = false;
        noSync = false;
        writeNoSync = false;
        this.durability = durability;
    }

    /**
     * Associates a consistency policy with this configuration.
     *
     * @param consistencyPolicy the consistency definition
     *
     * @return this
     */
    public TransactionConfig
        setConsistencyPolicy(ReplicaConsistencyPolicy consistencyPolicy) {

        this.consistencyPolicy = consistencyPolicy;
        return this;
    }

    /**
     * Returns the consistency policy associated with the configuration.
     *
     * @return the consistency policy currently associated with this config.
     */
    public ReplicaConsistencyPolicy getConsistencyPolicy() {
        return consistencyPolicy;
    }

    /**
     * Configures the transaction to not wait if a lock request cannot be
     * immediately granted.
     *
     * <p>The default is false for this class and the database environment.</p>
     *
     * @param noWait If true, transactions will not wait if a lock request
     * cannot be immediately granted, instead {@link
     * com.sleepycat.je.LockNotAvailableException LockNotAvailableException}
     * will be thrown.
     *
     * @return this
     */
    public TransactionConfig setNoWait(boolean noWait) {
        this.noWait = noWait;
        return this;
    }

    /**
     * Returns true if the transaction is configured to not wait if a lock
     * request cannot be immediately granted.
     *
     * @return true if the transaction is configured to not wait if a lock
     * request cannot be immediately granted.
     */
    public boolean getNoWait() {
        return noWait;
    }

    /**
     * Configures read operations performed by the transaction to return
     * modified but not yet committed data.
     *
     * @param readUncommitted If true, configure read operations performed by
     * the transaction to return modified but not yet committed data.
     *
     * @see LockMode#READ_UNCOMMITTED
     *
     * @return this
     */
    public TransactionConfig setReadUncommitted(boolean readUncommitted) {
        this.readUncommitted = readUncommitted;
        return this;
    }

    /**
     * Returns true if read operations performed by the transaction are
     * configured to return modified but not yet committed data.
     *
     * @return true if read operations performed by the transaction are
     * configured to return modified but not yet committed data.
     *
     * @see LockMode#READ_UNCOMMITTED
     */
    public boolean getReadUncommitted() {
        return readUncommitted;
    }

    /**
     * Configures the transaction for read committed isolation.
     *
     * <p>This ensures the stability of the current data item read by the
     * cursor but permits data read by this transaction to be modified or
     * deleted prior to the commit of the transaction.</p>
     *
     * @param readCommitted If true, configure the transaction for read
     * committed isolation.
     *
     * @see LockMode#READ_COMMITTED
     *
     * @return this
     */
    public TransactionConfig setReadCommitted(boolean readCommitted) {
        this.readCommitted = readCommitted;
        return this;
    }

    /**
     * Returns true if the transaction is configured for read committed
     * isolation.
     *
     * @return true if the transaction is configured for read committed
     * isolation.
     *
     * @see LockMode#READ_COMMITTED
     */
    public boolean getReadCommitted() {
        return readCommitted;
    }

    /**
     * Configures this transaction to have serializable (degree 3) isolation.
     * By setting serializable isolation, phantoms will be prevented.
     *
     * <p>By default a transaction provides Repeatable Read isolation; {@link
     * EnvironmentConfig#setTxnSerializableIsolation} may be called to override
     * the default.  If the environment is configured for serializable
     * isolation, all transactions will be serializable regardless of whether
     * this method is called; calling {@link #setSerializableIsolation} with a
     * false parameter will not disable serializable isolation.</p>
     *
     * The default is false for this class and the database environment.
     *
     * @see LockMode
     *
     * @return this
     */
    public TransactionConfig
        setSerializableIsolation(boolean serializableIsolation) {

        this.serializableIsolation = serializableIsolation;
        return this;
    }

    /**
     * Returns true if the transaction has been explicitly configured to have
     * serializable (degree 3) isolation.
     *
     * @return true if the transaction has been configured to have serializable
     * isolation.
     *
     * @see LockMode
     */
    public boolean getSerializableIsolation() {
        return serializableIsolation;
    }

    /**
     * Returns a copy of this configuration object.
     */
    @Override
    public TransactionConfig clone() {
        try {
            return (TransactionConfig) super.clone();
        } catch (CloneNotSupportedException willNeverOccur) {
            return null;
        }
    }

    /**
     *
     * Checks to catch mixing of deprecated and non-deprecated forms of the
     * API. It's invoked before setting any of the config parameters. The
     * arguments represent the new state of the durability configuration,
     * before it has been changed.
     *
     * @throws IllegalArgumentException via TransactionConfig and
     * EnvironmentMutableConfig setters
     */
    static void checkMixedMode(boolean sync,
                               boolean noSync,
                               boolean writeNoSync,
                               Durability durability)
        throws IllegalArgumentException {

        if ((sync || noSync || writeNoSync) && (durability != null)) {
            throw new IllegalArgumentException
                ("Mixed use of deprecated and current durability APIs is " +
                 "not supported");
        }

        if ((sync && noSync) ||
            (sync && writeNoSync) ||
            (noSync && writeNoSync)) {
            throw new IllegalArgumentException
                ("Only one of TxnSync, TxnNoSync, and TxnWriteNoSync " +
                 "can be set.");
        }
    }

    /**
     * Returns the values for each configuration attribute.
     *
     * @return the values for each configuration attribute.
     */
    @Override
    public String toString() {
        return "sync=" + sync +
            "\nnoSync=" + noSync +
            "\nwriteNoSync=" + writeNoSync +
            "\ndurability=" + durability +
            "\nconsistencyPolicy=" + consistencyPolicy +
            "\nnoWait=" + noWait +
            "\nreadUncommitted=" + readUncommitted +
            "\nreadCommitted=" + readCommitted +
            "\nSerializableIsolation=" + serializableIsolation +
            "\n";
    }
}
