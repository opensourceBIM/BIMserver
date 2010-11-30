/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * The interface implemented for extracting single-valued secondary keys from
 * primary records.
 *
 * <p>The key creator object is specified by calling {@link
 * SecondaryConfig#setKeyCreator SecondaryConfig.setKeyCreator}. The secondary
 * database configuration is specified when calling {@link
 * Environment#openSecondaryDatabase Environment.openSecondaryDatabase}.</p>
 *
 * <p>For example:</p>
 *
 * <pre>
 *     class MyKeyCreator implements SecondaryKeyCreator {
 *         public boolean createSecondaryKey(SecondaryDatabase secondary,
 *                                             DatabaseEntry key,
 *                                             DatabaseEntry data,
 *                                             DatabaseEntry result) {
 *             //
 *             // DO HERE: Extract the secondary key from the primary key and
 *             // data, and set the secondary key into the result parameter.
 *             //
 *             return true;
 *         }
 *     }
 *     ...
 *     SecondaryConfig secConfig = new SecondaryConfig();
 *     secConfig.setKeyCreator(new MyKeyCreator());
 *     // Now pass secConfig to Environment.openSecondaryDatabase
 * </pre>
 *
 * <p>Use this interface when zero or one secondary key is present in a single
 * primary record, in other words, for many-to-one and one-to-one
 * relationships. When more than one secondary key may be present (for
 * many-to-many and one-to-many relationships), use the {@link
 * SecondaryMultiKeyCreator} interface instead.  The table below summarizes how
 * to create all four variations of relationships.</p>
 * <div>
 * <table border="yes">
 *     <tr><th>Relationship</th>
 *         <th>Interface</th>
 *         <th>Duplicates</th>
 *         <th>Example</th>
 *     </tr>
 *     <tr><td>One-to-one</td>
 *         <td>{@link SecondaryKeyCreator}</td>
 *         <td>No</td>
 *         <td>A person record with a unique social security number key.</td>
 *     </tr>
 *     <tr><td>Many-to-one</td>
 *         <td>{@link SecondaryKeyCreator}</td>
 *         <td>Yes</td>
 *         <td>A person record with a non-unique employer key.</td>
 *     </tr>
 *     <tr><td>One-to-many</td>
 *         <td>{@link SecondaryMultiKeyCreator}</td>
 *         <td>No</td>
 *         <td>A person record with multiple unique email address keys.</td>
 *     </tr>
 *     <tr><td>Many-to-many</td>
 *         <td>{@link SecondaryMultiKeyCreator}</td>
 *         <td>Yes</td>
 *         <td>A person record with multiple non-unique organization keys.</td>
 *     </tr>
 * </table>
 *
 * </div>
 *
 * <p>To configure a database for duplicates. pass true to {@link
 * DatabaseConfig#setSortedDuplicates}.</p>
 *
 * <p><em>WARNING:</em> Key creator instances are shared by multiple threads
 * and key creator methods are called without any special synchronization.
 * Therefore, key creators must be thread safe.  In general no shared state
 * should be used and any caching of computed values must be done with proper
 * synchronization.</p>
 */
public interface SecondaryKeyCreator {

    /**
     * Creates a secondary key entry, given a primary key and data entry.
     *
     * <p>A secondary key may be derived from the primary key, primary data, or
     * a combination of the primary key and data.  For secondary keys that are
     * optional, the key creator method may return false and the key/data pair
     * will not be indexed.  To ensure the integrity of a secondary database
     * the key creator method must always return the same result for a given
     * set of input parameters.</p>
     *
     * <p>A {@code RuntimeException} may be thrown by this method if an error
     * occurs attempting to create the secondary key.  This exception will be
     * thrown by the API method currently in progress, for example, a {@link
     * Database#put put} method.  However, this will cause the write operation
     * to be incomplete.  When databases are not configured to be
     * transactional, caution should be used to avoid integrity problems.  See
     * <a href="SecondaryDatabase.html#transactions">Special considerations for
     * using Secondary Databases with and without Transactions</a>.</p>
     *
     * @param secondary the database to which the secondary key will be
     * added. This parameter is passed for informational purposes but is not
     * commonly used.
     *
     * @param key the primary key entry.  This parameter must not be modified
     * by this method.
     *
     * @param data the primary data entry.  This parameter must not be modified
     * by this method.
     *
     * @param result the secondary key created by this method.
     *
     * @return true if a key was created, or false to indicate that the key is
     * not present.
     */
    public boolean createSecondaryKey(SecondaryDatabase secondary,
                                      DatabaseEntry key,
                                      DatabaseEntry data,
                                      DatabaseEntry result);
}
