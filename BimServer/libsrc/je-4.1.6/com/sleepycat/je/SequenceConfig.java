/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2005-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * Specifies the attributes of a sequence.
 */
public class SequenceConfig implements Cloneable {

    /**
     * Default configuration used if null is passed to methods that create a
     * cursor.
     */
    public static final SequenceConfig DEFAULT = new SequenceConfig();

    /* Parameters */
    private int cacheSize = 0;
    private long rangeMin = Long.MIN_VALUE;
    private long rangeMax = Long.MAX_VALUE;
    private long initialValue = 0L;

    /* Flags */
    private boolean allowCreate;
    private boolean decrement;
    private boolean exclusiveCreate;
    private boolean autoCommitNoSync;
    private boolean wrap;

    /**
     * An instance created using the default constructor is initialized with
     * the system's default settings.
     */
    public SequenceConfig() {
    }

    /**
     * Configures the {@link com.sleepycat.je.Database#openSequence
     * Database.openSequence} method to create the sequence if it does not
     * already exist.
     *
     * <p>The default value is false.</p>
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @param allowCreate If true, configure the {@link
     * com.sleepycat.je.Database#openSequence Database.openSequence} method to
     * create the sequence if it does not already exist.
     *
     * @return this
     */
    public SequenceConfig setAllowCreate(boolean allowCreate) {
        this.allowCreate = allowCreate;
        return this;
    }

    /**
     * Returns true if the {@link com.sleepycat.je.Database#openSequence
     * Database.openSequence} method is configured to create the sequence if it
     * does not already exist.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return true if the {@link com.sleepycat.je.Database#openSequence
     * Database.openSequence} method is configured to create the sequence if it
     * does not already exist.
     */
    public boolean getAllowCreate() {
        return allowCreate;
    }

    /**
     * Set the Configure the number of elements cached by a sequence handle.
     *
     * <p>The default value is zero.</p>
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @param cacheSize The number of elements cached by a sequence handle.
     * May not be larger than the size of the range defined by {@link
     * #setRange}.
     *
     * @return this
     */
    public SequenceConfig setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
        return this;
    }

    /**
     * Returns the number of elements cached by a sequence handle..
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return The number of elements cached by a sequence handle..
     */
    public int getCacheSize() {
        return cacheSize;
    }

    /**
     * Specifies that the sequence should be decremented.
     *
     * <p>The default value is false.</p>
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @param decrement If true, specify that the sequence should be
     * decremented.
     *
     * @return this
     */
    public SequenceConfig setDecrement(boolean decrement) {
        this.decrement = decrement;
        return this;
    }

    /**
     * Returns true if the sequence is configured to decrement.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return true if the sequence is configured to decrement.
     */
    public boolean getDecrement() {
         return decrement;
    }

    /**
     * Configures the {@link com.sleepycat.je.Database#openSequence
     * Database.openSequence} method to fail if the database already exists.
     *
     * <p>The default value is false.</p>
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @param exclusiveCreate If true, configure the {@link
     * com.sleepycat.je.Database#openSequence Database.openSequence} method to
     * fail if the database already exists.
     *
     * @return this
     */
    public SequenceConfig setExclusiveCreate(boolean exclusiveCreate) {
        this.exclusiveCreate = exclusiveCreate;
        return this;
    }

    /**
     * Returns true if the {@link com.sleepycat.je.Database#openSequence
     * Database.openSequence} method is configured to fail if the database
     * already exists.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return true if the {@link com.sleepycat.je.Database#openSequence
     * Database.openSequence} method is configured to fail if the database
     * already exists.
     */
    public boolean getExclusiveCreate() {
        return exclusiveCreate;
    }

    /**
     * Sets the initial value for a sequence.
     *
     * <p>The default initial value is zero.</p>
     *
     * <p>This call is only effective when the sequence is being created.</p>
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @param initialValue The initial value for a sequence.  Must be within
     * the range minimum and maximum values, inclusive.
     *
     * @return this
     */
    public SequenceConfig setInitialValue(long initialValue) {
        this.initialValue = initialValue;
        return this;
    }

    /**
     * Returns the initial value for a sequence..
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return The initial value for a sequence..
     */
    public long getInitialValue() {
        return initialValue;
    }

    /**
     * Configures auto-commit operations on the sequence to not flush the
     * transaction log.
     *
     * <p>The default value is false.</p>
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @param autoCommitNoSync If true, configure auto-commit operations on
     * the sequence to not flush the transaction log.
     *
     * @return this
     */
    public SequenceConfig setAutoCommitNoSync(boolean autoCommitNoSync) {
        this.autoCommitNoSync = autoCommitNoSync;
        return this;
    }

    /**
     * Returns true if the auto-commit operations on the sequence are configure
     * to not flush the transaction log..
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return true if the auto-commit operations on the sequence are configure
     * to not flush the transaction log..
     */
    public boolean getAutoCommitNoSync() {
        return autoCommitNoSync;
    }

    /**
     * Configures a sequence range.  This call is only effective when the
     * sequence is being created.
     *
     * <p>The default minimum is {@code Long.MIN_VALUE} and the default maximum
     * is {@code Long.MAX_VALUE}.</p>
     *
     * @param min The minimum value for the sequence.  Must be less than max.
     *
     * @param max The maximum value for the sequence.  Must be greater than
     * min.
     *
     * @return this
     */
    public SequenceConfig setRange(long min, long max) {
        this.rangeMin = min;
        this.rangeMax = max;
        return this;
    }

    /**
     * Returns the minimum value for the sequence.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return The minimum value for the sequence.
     */
    public long getRangeMin() {
        return rangeMin;
    }

    /**
     * Returns the maximum value for the sequence.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return The maximum value for the sequence.
     */
    public long getRangeMax() {
        return rangeMax;
    }

    /**
     * Specifies that the sequence should wrap around when it is incremented
     * (decremented) past the specified maximum (minimum) value.
     *
     * <p>The default value is false.</p>
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @param wrap If true, specify that the sequence should wrap around when
     * it is incremented (decremented) past the specified maximum (minimum)
     * value.
     *
     * @return this
     */
    public SequenceConfig setWrap(boolean wrap) {
        this.wrap = wrap;
        return this;
    }

    /**
     * Returns true if the sequence will wrap around when it is incremented
     * (decremented) past the specified maximum (minimum) value.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return true if the sequence will wrap around when it is incremented
     * (decremented) past the specified maximum (minimum) value.
     */
    public boolean getWrap() {
        return wrap;
    }

    /**
     * Returns a copy of this configuration object.
     */
    @Override
    public SequenceConfig clone() {
        try {
            return (SequenceConfig) super.clone();
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
        return "allowCreate=" + allowCreate +
            "\ncacheSize=" + cacheSize +
            "\ndecrement=" + decrement +
            "\nexclusiveCreate=" + exclusiveCreate +
            "\ninitialValue=" + initialValue +
            "\nautoCommitNoSync=" + autoCommitNoSync +
            "\nrangeMin=" + rangeMin +
            "\nrangeMax=" + rangeMax +
            "\nwrap=" + wrap +
            "\n";
    }
}
