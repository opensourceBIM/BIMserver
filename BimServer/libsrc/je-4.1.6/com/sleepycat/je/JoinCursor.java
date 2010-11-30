/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;

import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.dbi.CursorImpl.SearchMode;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.utilint.DatabaseUtil;

/**
 * A specialized join cursor for use in performing equality or natural joins on
 * secondary indices.
 *
 * <p>A join cursor is returned when calling {@link Database#join
 * Database.join}.</p>
 *
 * <p>To open a join cursor using two secondary cursors:</p>
 *
 * <pre>
 *     Transaction txn = ...
 *     Database primaryDb = ...
 *     SecondaryDatabase secondaryDb1 = ...
 *     SecondaryDatabase secondaryDb2 = ...
 *     <p>
 *     SecondaryCursor cursor1 = null;
 *     SecondaryCursor cursor2 = null;
 *     JoinCursor joinCursor = null;
 *     try {
 *         DatabaseEntry key = new DatabaseEntry();
 *         DatabaseEntry data = new DatabaseEntry();
 *         <p>
 *         cursor1 = secondaryDb1.openSecondaryCursor(txn, null);
 *         cursor2 = secondaryDb2.openSecondaryCursor(txn, null);
 *         <p>
 *         key.setData(...); // initialize key for secondary index 1
 *         OperationStatus status1 =
 *         cursor1.getSearchKey(key, data, LockMode.DEFAULT);
 *         key.setData(...); // initialize key for secondary index 2
 *         OperationStatus status2 =
 *         cursor2.getSearchKey(key, data, LockMode.DEFAULT);
 *         <p>
 *         if (status1 == OperationStatus.SUCCESS &amp;&amp;
 *                 status2 == OperationStatus.SUCCESS) {
 *             <p>
 *             SecondaryCursor[] cursors = {cursor1, cursor2};
 *             joinCursor = primaryDb.join(cursors, null);
 *             <p>
 *             while (true) {
 *                 OperationStatus joinStatus = joinCursor.getNext(key, data,
 *                     LockMode.DEFAULT);
 *                 if (joinStatus == OperationStatus.SUCCESS) {
 *                      // Do something with the key and data.
 *                 } else {
 *                     break;
 *                 }
 *             }
 *         }
 *     } finally {
 *         if (cursor1 != null) {
 *             cursor1.close();
 *         }
 *         if (cursor2 != null) {
 *             cursor2.close();
 *         }
 *         if (joinCursor != null) {
 *             joinCursor.close();
 *         }
 *     }
 * </pre>
 *
 * <p>The join algorithm is described here so that its cost can be estimated and
 * compared to other approaches for performing a query.  Say that N cursors are
 * provided for the join operation. According to the order they appear in the
 * array the cursors are labeled C(1) through C(n), and the keys at each cursor
 * position are labeled K(1) through K(n).</p>
 *
 * <ol>
 *
 * <li>Using C(1), the join algorithm iterates sequentially through all records
 * having K(1).  This iteration is equivalent to a {@link Cursor#getNextDup
 * Cursor.getNextDup} operation on the secondary index.  The primary key of a
 * candidate record is determined in this manner.  The primary record itself is
 * not retrieved and the primary database is not accessed.</li>
 *
 * <li>For each candidate primary key found in step 1, a Btree lookup is
 * performed using C(2) through C(n), in that order.  The Btree lookups are
 * exact searches to determine whether the candidate record also contains
 * secondary keys K(2) through K(n).  The lookups are equivalent to a {@link
 * Cursor#getSearchBoth Cursor.getSearchBoth} operation on the secondary index.
 * The primary record itself is not retrieved and the primary database is not
 * accessed.</li>
 *
 * <li>If any lookup in step 2 fails, the algorithm advances to the next
 * candidate record using C(1).  Lookups are performed in the order of the
 * cursor array, and the algorithm proceeds to the next C(1) candidate key as
 * soon as a single lookup fails.</li>
 *
 * <li>If all lookups in step 2 succeed, then the matching key and/or data is
 * returned by the {@code getNext} method.  If the {@link
 * #getNext(DatabaseEntry,DatabaseEntry,LockMode)} method signature is used,
 * then the primary database is read to obtain the record data, as if {@link
 * Cursor#getSearchKey Cursor.getSearchKey} were called for the primary
 * database.  If the {@link #getNext(DatabaseEntry,LockMode)} method signature
 * is used, then only the primary key is returned and the primary database is
 * not accessed.</li>
 *
 * <li>The algorithm ends when C(1) has no more candidate records with K(1),
 * and the {@code getNext} method will then return {@link
 * com.sleepycat.je.OperationStatus#NOTFOUND OperationStatus.NOTFOUND}.</li>
 *
 * </ol>
 */
public class JoinCursor {

    private JoinConfig config;
    private Database priDb;
    private Cursor priCursor;
    private Cursor[] secCursors;
    private DatabaseEntry[] cursorScratchEntries;
    private DatabaseEntry scratchEntry;

    /**
     * Creates a join cursor without parameter checking.
     */
    JoinCursor(Locker locker,
               Database primaryDb,
               final Cursor[] cursors,
               JoinConfig configParam)
        throws DatabaseException {

        priDb = primaryDb;
        config = (configParam != null) ? configParam.clone()
                                       : JoinConfig.DEFAULT;
        scratchEntry = new DatabaseEntry();
        cursorScratchEntries = new DatabaseEntry[cursors.length];
        Cursor[] sortedCursors = new Cursor[cursors.length];
        System.arraycopy(cursors, 0, sortedCursors, 0, cursors.length);

        if (!config.getNoSort()) {

            /*
             * Sort ascending by duplicate count.  Collect counts before
             * sorting so that countInternal() is called only once per cursor.
             * Use READ_UNCOMMITTED to avoid blocking writers.
             */
            final int[] counts = new int[cursors.length];
            for (int i = 0; i < cursors.length; i += 1) {
                counts[i] = cursors[i].countInternal
                    (LockMode.READ_UNCOMMITTED);
                assert counts[i] >= 0;
            }
            Arrays.sort(sortedCursors, new Comparator<Cursor>() {
                public int compare(Cursor o1, Cursor o2) {
                    int count1 = -1;
                    int count2 = -1;

                    /*
                     * Scan for objects in cursors not sortedCursors since
                     * sortedCursors is being sorted in place.
                     */
                    for (int i = 0; i < cursors.length &&
                                    (count1 < 0 || count2 < 0); i += 1) {
                        if (cursors[i] == o1) {
                            count1 = counts[i];
                        } else if (cursors[i] == o2) {
                            count2 = counts[i];
                        }
                    }
                    assert count1 >= 0 && count2 >= 0;
                    return (count1 - count2);
                }
            });
        }

        /*
         * Open and dup cursors last.  If an error occurs before the
         * constructor is complete, close them and ignore exceptions during
         * close.
         */
        try {
            priCursor = new Cursor(priDb, locker, null);
            secCursors = new Cursor[cursors.length];
            for (int i = 0; i < cursors.length; i += 1) {
                secCursors[i] = new Cursor(sortedCursors[i], true);
            }
        } catch (DatabaseException e) {
            close(e); /* will throw e */
        }
    }

    /**
     * Closes the cursors that have been opened by this join cursor.
     *
     * <p>The cursors passed to {@link Database#join Database.join} are not
     * closed by this method, and should be closed by the caller.</p>
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public void close()
        throws DatabaseException {

        if (priCursor == null) {
            return;
        }
        close(null);
    }

    /**
     * Close all cursors we own, throwing only the first exception that occurs.
     *
     * @param firstException an exception that has already occured, or null.
     */
    private void close(DatabaseException firstException)
        throws DatabaseException {

        if (priCursor != null) {
            try {
                priCursor.close();
            } catch (DatabaseException e) {
                if (firstException == null) {
                    firstException = e;
                }
            }
            priCursor = null;
        }
        for (int i = 0; i < secCursors.length; i += 1) {
            if (secCursors[i] != null) {
                try {
                    secCursors[i].close();
                } catch (DatabaseException e) {
                    if (firstException == null) {
                        firstException = e;
                    }
                }
                secCursors[i] = null;
            }
        }
        if (firstException != null) {
            throw firstException;
        }
    }

    /**
     * For unit testing.
     */
    Cursor[] getSortedCursors() {
        return secCursors;
    }

    /**
     * Returns the primary database handle associated with this cursor.
     *
     * @return the primary database handle associated with this cursor.
     */
    public Database getDatabase() {

        return priDb;
    }

    /**
     * Returns this object's configuration.
     *
     * @return this object's configuration.
     */
    public JoinConfig getConfig() {

        return config.clone();
    }

    /**
     * Returns the next primary key resulting from the join operation.
     *
     * <p>An entry is returned by the join cursor for each primary key/data
     * pair having all secondary key values that were specified using the array
     * of secondary cursors passed to {@link Database#join Database.join}.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening each cursor, unless read-uncommitted isolation is
     * specified via the {@code CursorConfig} or {@code LockMode}
     * parameters.</p>
     *
     * @param key the primary key returned as output.  Its byte array does not
     * need to be initialized by the caller.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @param lockMode the locking attributes; if null, default attributes
     * are used.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, if a DatabaseEntry parameter is null or does not contain a
     * required non-null byte array.
     */
    public OperationStatus getNext(DatabaseEntry key,
                                   LockMode lockMode)
        throws DatabaseException {

        priCursor.checkEnv();
        DatabaseUtil.checkForNullDbt(key, "key", false);
        priCursor.trace(Level.FINEST, "JoinCursor.getNext(key): ", lockMode);

        return retrieveNext(key, null, lockMode);
    }

    /**
     * Returns the next primary key and data resulting from the join operation.
     *
     * <p>An entry is returned by the join cursor for each primary key/data
     * pair having all secondary key values that were specified using the array
     * of secondary cursors passed to {@link Database#join Database.join}.</p>
     *
     * <p>In a replicated environment, an explicit transaction must have been
     * specified when opening each cursor, unless read-uncommitted isolation is
     * specified via the {@code CursorConfig} or {@code LockMode}
     * parameters.</p>
     *
     * @param key the primary key returned as output.  Its byte array does not
     * need to be initialized by the caller.
     *
     * @param data the primary data returned as output.  Its byte array does
     * not need to be initialized by the caller.
     *
     * @return {@link com.sleepycat.je.OperationStatus#NOTFOUND
     * OperationStatus.NOTFOUND} if no matching key/data pair is found;
     * otherwise, {@link com.sleepycat.je.OperationStatus#SUCCESS
     * OperationStatus.SUCCESS}.
     *
     * @param lockMode the locking attributes; if null, default attributes
     * are used.
     *
     * @throws OperationFailureException if one of the <a
     * href="OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     *
     * @throws IllegalArgumentException if an invalid parameter is specified,
     * for example, if a DatabaseEntry parameter is null or does not contain a
     * required non-null byte array.
     */
    public OperationStatus getNext(DatabaseEntry key,
                                   DatabaseEntry data,
                                   LockMode lockMode)
        throws DatabaseException {

        priCursor.checkEnv();
        DatabaseUtil.checkForNullDbt(key, "key", false);
        DatabaseUtil.checkForNullDbt(data, "data", false);
        priCursor.trace(Level.FINEST, "JoinCursor.getNext(key,data): ",
                        lockMode);

        return retrieveNext(key, data, lockMode);
    }

    /**
     * Internal version of getNext(), with an optional data param.
     * <p>
     * Since duplicates are always sorted and duplicate-duplicates are not
     * allowed, a natural join can be implemented by simply traversing through
     * the duplicates of the first cursor to find candidate keys, and then
     * looking for each candidate key in the duplicate set of the other
     * cursors, without ever reseting a cursor to the beginning of the
     * duplicate set.
     * <p>
     * This only works when the same duplicate comparison method is used for
     * all cursors.  We don't check for that, we just assume the user won't
     * violate that rule.
     * <p>
     * A future optimization would be to add a SearchMode.BOTH_DUPS operation
     * and use it instead of using SearchMode.BOTH.  This would be the
     * equivalent of the undocumented DB_GET_BOTHC operation used by DB core's
     * join() implementation.
     */
    private OperationStatus retrieveNext(DatabaseEntry keyParam,
                                         DatabaseEntry dataParam,
                                         LockMode lockMode)
        throws DatabaseException {

        outerLoop: while (true) {

            /* Process the first cursor to get a candidate key. */
            Cursor secCursor = secCursors[0];
            DatabaseEntry candidateKey = cursorScratchEntries[0];
            OperationStatus status;
            if (candidateKey == null) {
                /* Get first duplicate at initial cursor position. */
                candidateKey = new DatabaseEntry();
                cursorScratchEntries[0] = candidateKey;
                status = secCursor.getCurrentInternal(scratchEntry,
                                                      candidateKey,
                                                      lockMode);
            } else {
                /* Already initialized, move to the next candidate key. */
                status = secCursor.retrieveNext(scratchEntry, candidateKey,
                                                lockMode,
                                                GetMode.NEXT_DUP);
            }
            if (status != OperationStatus.SUCCESS) {
                /* No more candidate keys. */
                return status;
            }

            /* Process the second and following cursors. */
            for (int i = 1; i < secCursors.length; i += 1) {
                secCursor = secCursors[i];
                DatabaseEntry secKey = cursorScratchEntries[i];
                if (secKey == null) {
                    secKey = new DatabaseEntry();
                    cursorScratchEntries[i] = secKey;
                    status = secCursor.getCurrentInternal(secKey, scratchEntry,
                                                          lockMode);
                    assert status == OperationStatus.SUCCESS;
                }
                scratchEntry.setData(secKey.getData(), secKey.getOffset(),
                                     secKey.getSize());
                status = secCursor.search(scratchEntry, candidateKey, lockMode,
                                          SearchMode.BOTH);
                if (status != OperationStatus.SUCCESS) {
                    /* No match, get another candidate key. */
                    continue outerLoop;
                }
            }

            /* The candidate key was found for all cursors. */
            if (dataParam != null) {
                status = priCursor.search(candidateKey, dataParam,
                                          lockMode, SearchMode.SET);
                if (status != OperationStatus.SUCCESS) {
                    Database secDb =
                        secCursors[secCursors.length - 1].getDatabase();
                    throw new SecondaryIntegrityException
                        (priCursor.getCursorImpl().getLocker(),
                         "Join secondary cursors refer to a missing key in " +
                         "the primary database",
                         secDb.getDebugName(), scratchEntry, candidateKey);
                }
            }
            keyParam.setData(candidateKey.getData(), candidateKey.getOffset(),
                             candidateKey.getSize());
            return OperationStatus.SUCCESS;
        }
    }
}
