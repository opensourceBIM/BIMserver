/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

/**
 * The configuration properties of a <code>JoinCursor</code>. The join cursor
 * configuration is specified when calling {@link Database#join Database.join}.
 *
 * <p>To create a configuration object with default attributes:</p>
 *
 * <pre>
 *     JoinConfig config = new JoinConfig();
 * </pre>
 *
 * <p>To set custom attributes:</p>
 *
 * <pre>
 *     JoinConfig config = new JoinConfig();
 *     config.setNoSort(true);
 * </pre>
 *
 * @see Database#join Database.join
 * @see JoinCursor
 */
public class JoinConfig implements Cloneable {

    /**
     * Default configuration used if null is passed to {@link
     * com.sleepycat.je.Database#join Database.join}.
     */
    public static final JoinConfig DEFAULT = new JoinConfig();

    private boolean noSort;

    /**
     * Creates an instance with the system's default settings.
     */
    public JoinConfig() {
    }

    /**
     * Specifies whether automatic sorting of the input cursors is disabled.
     *
     * <p>Joined values are retrieved by doing a sequential iteration over the
     * first cursor in the cursor array, and a nested iteration over each
     * following cursor in the order they are specified in the array. This
     * requires database traversals to search for the current datum in all the
     * cursors after the first. For this reason, the best join performance
     * normally results from sorting the cursors from the one that refers to
     * the least number of data items to the one that refers to the
     * most. Unless this method is called with true, <code>Database.join</code>
     * does this sort on behalf of its caller.</p>
     *
     * <p>If the data are structured so that cursors with many data items also
     * share many common elements, higher performance will result from listing
     * those cursors before cursors with fewer data items; that is, a sort
     * order other than the default. Calling this method permits applications
     * to perform join optimization prior to calling
     * <code>Database.join</code>.</p>
     *
     * @param noSort whether automatic sorting of the input cursors is
     * disabled.
     *
     * @see Database#join Database.join
     *
     * @return this
     */
    public JoinConfig setNoSort(boolean noSort) {
        this.noSort = noSort;
        return this;
    }

    /**
     * Returns whether automatic sorting of the input cursors is disabled.
     *
     * @return whether automatic sorting of the input cursors is disabled.
     *
     * @see #setNoSort
     */
    public boolean getNoSort() {
        return noSort;
    }

    /**
     * Returns a copy of this configuration object.
     */
    @Override
    public JoinConfig clone() {
        try {
            return (JoinConfig) super.clone();
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
        return "noSort=" + noSort +
            "\n";
    }
}
