/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2000-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.collections;

import java.util.Set;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
/* <!-- begin JE only --> */
import com.sleepycat.je.EnvironmentFailureException; // for javadoc
import com.sleepycat.je.OperationFailureException; // for javadoc
/* <!-- end JE only --> */
import com.sleepycat.je.OperationStatus;
import com.sleepycat.util.RuntimeExceptionWrapper;

/**
 * The Set returned by Map.keySet() and which can also be constructed directly
 * if a Map is not needed.
 * Since this collection is a set it only contains one element for each key,
 * even when duplicates are allowed.  Key set iterators are therefore
 * particularly useful for enumerating the unique keys of a store or index that
 * allows duplicates.
 *
 * @author Mark Hayes
 */
public class StoredKeySet<K> extends StoredCollection<K> implements Set<K> {

    /**
     * Creates a key set view of a {@link Database}.
     *
     * @param database is the Database underlying the new collection.
     *
     * @param keyBinding is the binding used to translate between key buffers
     * and key objects.
     *
     * @param writeAllowed is true to create a read-write collection or false
     * to create a read-only collection.
     *
     * @throws IllegalArgumentException if formats are not consistently
     * defined or a parameter is invalid.
     *
     * @throws RuntimeExceptionWrapper if a checked exception is thrown,
     * including a {@code DatabaseException} on BDB (C Edition).
     */
    public StoredKeySet(Database database,
                        EntryBinding<K> keyBinding,
                        boolean writeAllowed) {

        super(new DataView(database, keyBinding, null, null,
                           writeAllowed, null));
    }

    StoredKeySet(DataView keySetView) {

        super(keySetView);
    }

    /**
     * Adds the specified key to this set if it is not already present
     * (optional operation).
     * When a key is added the value in the underlying data store will be
     * empty.
     * This method conforms to the {@link Set#add} interface.
     *
     * <!-- begin JE only -->
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     * <!-- end JE only -->
     *
     * @throws UnsupportedOperationException if the collection is indexed, or
     * if the collection is read-only.
     *
     * @throws RuntimeExceptionWrapper if a checked exception is thrown,
     * including a {@code DatabaseException} on BDB (C Edition).
     */
    public boolean add(K key) {

        DataCursor cursor = null;
        boolean doAutoCommit = beginAutoCommit();
        try {
            cursor = new DataCursor(view, true);
            OperationStatus status = cursor.putNoOverwrite(key, null, false);
            closeCursor(cursor);
            commitAutoCommit(doAutoCommit);
            return (status == OperationStatus.SUCCESS);
        } catch (Exception e) {
            closeCursor(cursor);
            throw handleException(e, doAutoCommit);
        }
    }

    /**
     * Removes the specified key from this set if it is present (optional
     * operation).
     * If duplicates are allowed, this method removes all duplicates for the
     * given key.
     * This method conforms to the {@link Set#remove} interface.
     *
     * <!-- begin JE only -->
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#writeFailures">Write
     * Operation Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     * <!-- end JE only -->
     *
     * @throws UnsupportedOperationException if the collection is read-only.
     *
     * @throws RuntimeExceptionWrapper if a checked exception is thrown,
     * including a {@code DatabaseException} on BDB (C Edition).
     */
    public boolean remove(Object key) {

        return removeKey(key, null);
    }

    /**
     * Returns true if this set contains the specified key.
     * This method conforms to the {@link Set#contains} interface.
     *
     * <!-- begin JE only -->
     * @throws OperationFailureException if one of the <a
     * href="../je/OperationFailureException.html#readFailures">Read Operation
     * Failures</a> occurs.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     * <!-- end JE only -->
     *
     * @throws RuntimeExceptionWrapper if a checked exception is thrown,
     * including a {@code DatabaseException} on BDB (C Edition).
     */
    public boolean contains(Object key) {

        return containsKey(key);
    }

    boolean hasValues() {

        return false;
    }

    K makeIteratorData(BaseIterator iterator,
                       DatabaseEntry keyEntry,
                       DatabaseEntry priKeyEntry,
                       DatabaseEntry valueEntry) {

        return (K) view.makeKey(keyEntry, priKeyEntry);
    }

    boolean iterateDuplicates() {

        return false;
    }
}
