/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;
import com.sleepycat.je.utilint.DbLsn;

/**
 * BINDelta contains the information needed to create a partial (delta) BIN log
 * entry. It also knows how to combine a full BIN log entry and a delta to
 * generate a new BIN.
 */
public class BINDelta implements Loggable {

    private final DatabaseId dbId;    // owning db for this bin.
    private long lastFullLsn;   // location of last full version
    private final List<DeltaInfo> deltas;        // list of key/action changes

    /**
     * Read a BIN and create the deltas.
     */
    public BINDelta(BIN bin) {
        lastFullLsn = bin.getLastFullVersion();
        dbId = bin.getDatabaseId();
        deltas = new ArrayList<DeltaInfo>();

        /*
         * Save every entry that has been modified since the last full version.
         * Note that we must rely on the dirty bit, and we can't infer any
         * dirtiness by comparing the last full version LSN and the child
         * reference LSN. That's because the ChildReference LSN may be earlier
         * than the full version LSN because of aborts.
         */
        for (int i = 0; i < bin.getNEntries(); i++) {
            if (bin.isDirty(i)) {
                deltas.add(new DeltaInfo(bin.getKey(i),
                                         bin.getLsn(i),
                                         bin.getState(i)));
            }
        }
    }

    /**
     * For instantiating from the log.
     */
    public BINDelta() {
        dbId = new DatabaseId();
        lastFullLsn = DbLsn.NULL_LSN;
        deltas = new ArrayList<DeltaInfo>();
    }

    /**
     * @return a count of deltas for this BIN.
     */
    int getNumDeltas() {
        return deltas.size();
    }

    /**
     * @return the dbId for this BIN.
     */
    public DatabaseId getDbId() {
        return dbId;
    }

    /**
     * @return the last full version of this BIN
     */
    public long getLastFullLsn() {
        return lastFullLsn;
    }

    /**
     * Create a BIN by starting with the full version and applying the deltas.
     */
    public BIN reconstituteBIN(EnvironmentImpl env)
        throws DatabaseException {

        /* Get the last full version of this BIN. */
        BIN fullBIN =
            (BIN) env.getLogManager().getEntryHandleFileNotFound(lastFullLsn);
        DatabaseImpl db = env.getDbTree().getDb(dbId);
        try {

            /*
             * In effect, call fullBIN.postFetchInit(db) here.  But we don't
             * want to do that since it will put fullBIN on the INList.  Since
             * this is either recovery or during the Cleaner run, we don't want
             * it on the INList.
             */
            fullBIN.setDatabase(db);
            fullBIN.setLastFullLsn(lastFullLsn);

            /* Process each delta. */
            fullBIN.latch();
            for (int i = 0; i < deltas.size(); i++) {
                DeltaInfo info = deltas.get(i);

                /*
                 * The BINDelta holds the authoritative version of each entry.
                 * In all cases, its entry should supersede the entry in the
                 * full BIN.  This is true even if the BIN Delta's entry is
                 * knownDeleted or if the full BIN's version is knownDeleted.
                 * Therefore we use the flavor of findEntry that will return a
                 * knownDeleted entry if the entry key matches (i.e. true,
                 * false) but still indicates exact matches with the return
                 * index.  findEntry only returns deleted entries if third arg
                 * is false, but we still need to know if it's an exact match
                 * or not so indicateExact is true.
                 */
                int foundIndex = fullBIN.findEntry(info.getKey(), true, false);
                if (foundIndex >= 0 &&
                    (foundIndex & IN.EXACT_MATCH) != 0) {
                    foundIndex &= ~IN.EXACT_MATCH;

                    /*
                     * The entry exists in the full version, update it with the
                     * delta info.
                     */
                    if (info.isKnownDeleted()) {
                        fullBIN.setKnownDeleted(foundIndex);
                    } else {
                        fullBIN.updateEntry
                            (foundIndex, info.getLsn(), info.getState());
                    }
                } else {

                    /*
                     * The entry doesn't exist, add a new entry from the delta.
                     */
                    if (!info.isKnownDeleted()) {
                        ChildReference entry =
                            new ChildReference(null,
                                               info.getKey(),
                                               info.getLsn(),
                                               info.getState());
                        boolean insertOk = fullBIN.insertEntry(entry);
                        assert insertOk;
                    }
                }
            }
        } finally {
            env.getDbTree().releaseDb(db);
        }

        /*
         * Reset the generation to 0, all this manipulation might have driven
         * it up.
         */
        fullBIN.setGeneration(0);
        fullBIN.releaseLatch();
        return fullBIN;
    }

    /*
     * Logging support
     */

    /*
     * @see Loggable#getLogSize()
     */
    public int getLogSize() {
        int numDeltas = deltas.size();
        int size =
            dbId.getLogSize() + // database id
            LogUtils.getPackedLongLogSize(lastFullLsn) +
            LogUtils.getPackedIntLogSize(numDeltas);

        for (int i = 0; i < numDeltas; i++) {    // deltas
            DeltaInfo info = deltas.get(i);
            size += info.getLogSize();
        }

        return size;
    }

    /*
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer logBuffer) {
        dbId.writeToLog(logBuffer);                     // database id
        LogUtils.writePackedLong(logBuffer, lastFullLsn);     // last version
        LogUtils.writePackedInt(logBuffer, deltas.size());  // num deltas

        for (int i = 0; i < deltas.size(); i++) {              // deltas
            DeltaInfo info = deltas.get(i);
            info.writeToLog(logBuffer);
        }
    }

    /*
     * @see Loggable#readFromLog()
     */
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {
        dbId.readFromLog(itemBuffer, entryVersion); // database id
        lastFullLsn = LogUtils.readLong(itemBuffer, (entryVersion < 6));
        int numDeltas = LogUtils.readInt(itemBuffer, (entryVersion < 6));

        for (int i=0; i < numDeltas; i++) {      // deltas
            DeltaInfo info = new DeltaInfo();
            info.readFromLog(itemBuffer, entryVersion);
            deltas.add(info);
        }
    }

    /*
     * @see Loggable#dumpLog
     */
    public void dumpLog(StringBuilder sb, boolean verbose) {
        dbId.dumpLog(sb, verbose);
        sb.append("<lastFullLsn>");
        sb.append(DbLsn.toString(lastFullLsn));
        sb.append("</lastFullLsn>");
        sb.append("<deltas size=\"").append(deltas.size()).append("\"/>");
        for (int i = 0; i < deltas.size(); i++) {    // deltas
            DeltaInfo info = deltas.get(i);
            info.dumpLog(sb, verbose);
        }
    }

    /**
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return 0;
    }

    /**
     * @see Loggable#logicalEquals
     * Always return false, this item should never be compared.
     */
    public boolean logicalEquals(Loggable other) {
        return false;
    }
}
