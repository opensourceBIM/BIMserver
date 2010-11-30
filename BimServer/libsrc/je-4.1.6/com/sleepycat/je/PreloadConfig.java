/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * Specifies the attributes of an application invoked preload operation.
 */
public class PreloadConfig implements Cloneable {

    private long maxBytes;
    private long maxMillisecs;
    private boolean loadLNs;

    /**
     * Default configuration used if null is passed to {@link
     * com.sleepycat.je.Database#preload Database.preload}.
     */
    public PreloadConfig() {
    }

    /**
     * Configure the maximum number of bytes to preload.
     *
     * <p>The default is 0 for this class.</p>
     *
     * @param maxBytes If the maxBytes parameter is non-zero, a preload will
     * stop when the cache contains this number of bytes.
     *
     * @return this
     */
    public PreloadConfig setMaxBytes(final long maxBytes) {
        this.maxBytes = maxBytes;
        return this;
    }

    /**
     * Return the number of bytes in the cache to stop the preload at.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return The number of bytes in the cache to stop the preload at.
     */
    public long getMaxBytes() {
        return maxBytes;
    }

    /**
     * Configure the maximum number of milliseconds to execute preload.
     *
     * <p>The default is 0 for this class.</p>
     *
     * @param maxMillisecs If the maxMillisecs parameter is non-zero, a preload
     * will stop when this amount of time has passed.
     *
     * @return this
     */
    public PreloadConfig setMaxMillisecs(final long maxMillisecs) {
        this.maxMillisecs = maxMillisecs;
        return this;
    }

    /**
     * Return the number of millisecs to stop the preload after.
     *
     * <p>This method may be called at any time during the life of the
     * application.</p>
     *
     * @return The number of millisecs to stop the preload after.
     */
    public long getMaxMillisecs() {
        return maxMillisecs;
    }

    /**
     * Configure the preload load LNs option.
     *
     * <p>The default is false for this class.</p>
     *
     * @param loadLNs If set to true, the preload will load Leaf Nodes (LNs)
     * containing the data values.
     *
     * @return this
     */
    public PreloadConfig setLoadLNs(final boolean loadLNs) {
        this.loadLNs = loadLNs;
        return this;
    }

    /**
     * Return the configuration of the preload load LNs option.
     *
     * @return The configuration of the preload load LNs option.
     */
    public boolean getLoadLNs() {
        return loadLNs;
    }

    /**
     * Returns a copy of this configuration object.
     */
    @Override
    public PreloadConfig clone() {
        try {
            return (PreloadConfig) super.clone();
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
        return "maxBytes=" + maxBytes +
            "\nmaxMillisecs=" + maxMillisecs +
            "\nloadLNs=" + loadLNs +
            "\n";
    }
}
