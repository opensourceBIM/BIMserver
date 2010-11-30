/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.persist.impl;

/**
 * Thrown and handled internally when metadata must be refreshed on a Replica.
 * See the refresh() method below.
 */
public class RefreshException extends RuntimeException {

    private final Store store;
    private final PersistCatalog catalog;
    private final int formatId;

    RefreshException(final Store store,
                     final PersistCatalog catalog,
                     final int formatId) {
        this.store = store;
        this.catalog = catalog;
        this.formatId = formatId;
    }

    /**
     * This method must be called to handle this exception in the binding
     * methods, after the stack has rewound.  The binding methods should retry
     * the operation once after calling this method.  If the operation fails
     * again, then corruption rather than stale metadata is the likely cause
     * of the problem, and an exception will be thrown to that effect.
     * [#16655]
     */
    PersistCatalog refresh() {
        return store.refresh(catalog, formatId, this);
    }

    @Override
    public String getMessage() {
        return "formatId=" + formatId;
    }
}
