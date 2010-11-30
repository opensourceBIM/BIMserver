/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.tree.LN;

/**
 * The information necessary to lookup an LN.  Used for pending LNs that are
 * locked and must be migrated later, or cannot be migrated immediately during
 * a split.  Also used in a look ahead cache in FileProcessor.
 *
 * Is public for Sizeof only.
 */
public final class LNInfo {

    private LN ln;
    private DatabaseId dbId;
    private byte[] key;
    private byte[] dupKey;

    public LNInfo(LN ln, DatabaseId dbId, byte[] key, byte[] dupKey) {
        this.ln = ln;
        this.dbId = dbId;
        this.key = key;
        this.dupKey = dupKey;
    }

    LN getLN() {
        return ln;
    }

    DatabaseId getDbId() {
        return dbId;
    }

    byte[] getKey() {
        return key;
    }

    byte[] getDupKey() {
        return dupKey;
    }

    int getMemorySize() {
        int size = MemoryBudget.LN_INFO_OVERHEAD;
        if (ln != null) {
            size += ln.getMemorySizeIncludedByParent();
        }
        if (key != null) {
            size += MemoryBudget.byteArraySize(key.length);
        }
        if (dupKey != null) {
            size += MemoryBudget.byteArraySize(dupKey.length);
        }
        return size;
    }
}
