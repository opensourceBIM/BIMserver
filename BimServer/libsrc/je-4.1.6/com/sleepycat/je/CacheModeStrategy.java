/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * @hidden
 * For internal use only.
 *
 * Implemented to provide the cache mode dynamically, and used along with
 * {@link CacheMode#DYNAMIC}.
 *
 * <p>An instance of a class implementing this interface may be configured
 * using {@link EnvironmentConfig#setCacheModeStrategy} or {@link
 * DatabaseConfig#setCacheModeStrategy}.  See {@link CacheMode#DYNAMIC} for
 * more information.</p>
 *
 * @since 4.0.97
 */
public interface CacheModeStrategy {

    /**
     * Returns the cache mode to be used for an operation where {@link
     * CacheMode#DYNAMIC} is the configured cache mode.
     *
     * <p>This method is called prior to every operation where {@link
     * CacheMode#DYNAMIC} applies.  The returned value is then used as the
     * effective cache mode for the operation.</p>
     *
     * <p>This method may not return {@code null} or {@link CacheMode#DYNAMIC}.
     * If it does, an {@link IllegalArgumentException} will be thrown by the
     * operation where {@link CacheMode#DYNAMIC} is used.</p>
     *
     * @return the cache mode to be used.
     */
    public CacheMode getCacheMode();
}
