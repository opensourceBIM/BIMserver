/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.util.HashSet;
import java.util.Set;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.log.entry.BINDeltaLogEntry;
import com.sleepycat.je.log.entry.DeletedDupLNLogEntry;
import com.sleepycat.je.log.entry.FileHeaderEntry;
import com.sleepycat.je.log.entry.INLogEntry;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.log.entry.NameLNLogEntry;
import com.sleepycat.je.log.entry.SingleItemEntry;

/**
 * LogEntryType is an  enumeration of all log entry types.
 *
 * <p>Log entries are versioned. When changing the persistent form of a log
 * entry in any way that is incompatible with prior releases, make sure the
 * LogEntry instance is capable of reading in older versions from the log and
 * be sure to increment LOG_VERSION.  The LogEntry.readEntry and
 * Loggable.readFromLog methods should check the actual version of the entry.
 * If it is less than LOG_VERSION, the old version should be converted to the
 * current version.
 *
 * <p>Prior to LOG_VERSION 6, each log entry type had a separate version number
 * that was incremented only when that log version changed.  From LOG_VERSION 6
 * onward, all types use the same version, the LOG_VERSION constant.  For
 * versions prior to 6, the readEntry and readFromLog methods will be checking
 * the old per-type version.  There is no overlap between the old per-type
 * versions and the LOG_VERSION values, because the per-type values are all
 * below 6. [#15365]</p>

 * <p>The LogEntry instance must be sure that older versions are converted in
 * memory into a correct instance of the newest version, so when that LogEntry
 * object is written again as the result of migration, eviction, the resulting
 * new log entry conforms to the requirements of the new version.  If context
 * objects are required for data conversion, the conversion can be done in the
 * Node.postFetchInit method.</p>
 */
public class LogEntryType {

    /**
     * Version of the file header, which identifies the version of all entries
     * in that file.
     *
     * Changes to log entries for each version are:
     *
     * Version 3
     * ---------
     * [12328] Add main and dupe tree fanout values for DatabaseImpl.
     * [12557] Add IN LSN array compression.
     * [11597] Add a change to FileSummaryLNs: obsolete offset tracking was
     * added and multiple records are stored for a single file rather than a
     * single record.  Each record contains the offsets that were tracked since
     * the last record was written.
     * [11597] Add the full obsolete LSN in LNLogEntry.
     *
     * Version 4
     * ---------
     * [#14422] Bump MapLN version from 1 to 2.  Instead of a String for the
     * comparator class name, store either a serialized string or Comparator.
     *
     * Version 5
     * ---------
     * [#15195] FileSummaryLN version 3.  Add FileSummary.obsoleteLNSize and
     * obsoleteLNSizeCounted fields.
     *
     * Version 6 (in JE 3.3.X)
     * ---------
     * [#15365] From this point onward, all log entries have the same version,
     * LOG_VERSION, rather than using per-type versions.
     * [#15365] DatabaseImpl stores a map of DbFileSummaries.
     *
     * [#13467] Convert duplicatesAllowed boolean to DUPS_ALLOWED_BIT flag in
     * DatabaseImpl. Add REPLICATED_BIT flag to DatabaseImpl.
     * [#13467] Add REPLICATED_BIT to DbTree.
     * [#13467] Add ReplicatedDatabaseConfig to NameLN_TX to support
     * replication of database operations.
     *
     * [#15581] Add lastAllocateReplicatedDbId to DbTree
     * [#16083] Add replication master node id to txn commit/abort
     *
     * Version 7 (in JE 4.0)
     * ---------------------
     * Add the invisible bit in the entry header version field.
     * Add the RollbackStart log entry type
     * Add the RollbackEnd log entry type
     * Add the Matchpoint log entry type.
     */
    public static final int LOG_VERSION = 7;

    public static final int FIRST_LOG_VERSION = 1;

    /**
     * Should be used for reading the entry header of the file header, since
     * the actual version is not known until the FileHeader item is read.
     */
    public static final int UNKNOWN_FILE_HEADER_VERSION = -1;

    /*
     * Collection of log entry type classes, used to read the log.  Note that
     * this must be declared before any instances of LogEntryType, since the
     * constructor uses this map. Each statically defined LogEntryType should
     * register itself with this collection.
     */
    private static final int MAX_TYPE_NUM = 30;
    private static LogEntryType[] LOG_TYPES = new LogEntryType[MAX_TYPE_NUM];

    /*
     * Enumeration of log entry types. The log entry type represents the 2 byte
     * field that starts every log entry. The top byte is the log type, the
     * bottom byte holds the version value, provisional bit, replicated bit,
     * and invisible bit.
     *
     * Log type(8 bits)
     * Provisional(2 bits) Replicated(1 bit) Invisible(1 bit) Version(5 bits)
     *
     * The top byte (log type) identifies the type and can be used to lookup
     * the LogEntryType object, while the bottom byte has information about the
     * entry (instance) of this type.  The bottom byte is effectively entry
     * header information that is common to all types and is managed by methods
     * in LogEntryHeader. See LogEntryHeader.java
     */

    /*  Node types */
    public static final LogEntryType LOG_LN_TRANSACTIONAL =
        new LogEntryType
        ((byte) 1, "LN_TX",
         new LNLogEntry(com.sleepycat.je.tree.LN.class),
         Txnal.TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_NO_MATCH);

    public static final LogEntryType LOG_LN =
        new LogEntryType
        ((byte) 2, "LN",
         new LNLogEntry(com.sleepycat.je.tree.LN.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_NO_MATCH);

    public static final LogEntryType LOG_MAPLN_TRANSACTIONAL =
        new LogEntryType
        ((byte) 3, "MapLN_TX",
         new LNLogEntry(com.sleepycat.je.tree.MapLN.class),
         Txnal.TXNAL,
         Marshall.INSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_MAPLN =
        new LogEntryType
        ((byte) 4, "MapLN",
         new LNLogEntry(com.sleepycat.je.tree.MapLN.class),
         Txnal.NON_TXNAL,
         Marshall.INSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_NAMELN_TRANSACTIONAL =
        new LogEntryType
        ((byte) 5, "NameLN_TX",
         new NameLNLogEntry(),
         Txnal.TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_NO_MATCH);

    public static final LogEntryType LOG_NAMELN =
        new LogEntryType
        ((byte) 6, "NameLN",
         new NameLNLogEntry(),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_NO_MATCH);

    public static final LogEntryType LOG_DEL_DUPLN_TRANSACTIONAL =
        new LogEntryType
        ((byte) 7, "DelDupLN_TX",
         new DeletedDupLNLogEntry(),
         Txnal.TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_NO_MATCH);

    public static final LogEntryType LOG_DEL_DUPLN =
        new LogEntryType
        ((byte) 8, "DelDupLN",
         new DeletedDupLNLogEntry(),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_NO_MATCH);

    public static final LogEntryType LOG_DUPCOUNTLN_TRANSACTIONAL =
        new LogEntryType
        ((byte) 9, "DupCountLN_TX",
         new LNLogEntry(com.sleepycat.je.tree.DupCountLN.class),
         Txnal.TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_DUPCOUNTLN =
        new LogEntryType
        ((byte) 10, "DupCountLN",
         new LNLogEntry(com.sleepycat.je.tree.DupCountLN.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_FILESUMMARYLN =
        new LogEntryType
        ((byte) 11, "FileSummaryLN",
         new LNLogEntry(com.sleepycat.je.tree.FileSummaryLN.class),
         Txnal.NON_TXNAL,
         Marshall.INSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_IN =
        new LogEntryType
        ((byte) 12, "IN",
         new INLogEntry(com.sleepycat.je.tree.IN.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_BIN =
        new LogEntryType
        ((byte) 13, "BIN",
         new INLogEntry(com.sleepycat.je.tree.BIN.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_DIN =
        new LogEntryType
        ((byte) 14, "DIN",
         new INLogEntry(com.sleepycat.je.tree.DIN.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_DBIN =
        new LogEntryType
        ((byte) 15, "DBIN",
         new INLogEntry(com.sleepycat.je.tree.DBIN.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType[] IN_TYPES = {
        LogEntryType.LOG_IN,
        LogEntryType.LOG_BIN,
        LogEntryType.LOG_DIN,
        LogEntryType.LOG_DBIN,
    };

    /*** If you add new types, be sure to update MAX_TYPE_NUM at the top.***/

    private static final int MAX_NODE_TYPE_NUM = 15;

    public static boolean isNodeType(byte typeNum) {
        return (typeNum <= MAX_NODE_TYPE_NUM);
    }

    /* Root */
    public static final LogEntryType LOG_ROOT =
        new LogEntryType
        ((byte) 16, "Root",
         new SingleItemEntry
         (com.sleepycat.je.dbi.DbTree.class),
         Txnal.NON_TXNAL,
         Marshall.INSIDE_LATCH,
         Replicable.LOCAL);

    /* Transactional entries */
    public static final LogEntryType LOG_TXN_COMMIT =
        new LogEntryType
        ((byte) 17, "Commit",
         new SingleItemEntry
         (com.sleepycat.je.txn.TxnCommit.class),
         Txnal.TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_MATCH);

    public static final LogEntryType LOG_TXN_ABORT =
        new LogEntryType
        ((byte) 18, "Abort",
         new SingleItemEntry
         (com.sleepycat.je.txn.TxnAbort.class),
         Txnal.TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_MATCH);

    public static final LogEntryType LOG_CKPT_START =
        new LogEntryType
        ((byte) 19, "CkptStart",
         new SingleItemEntry
         (com.sleepycat.je.recovery.CheckpointStart.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_CKPT_END =
        new LogEntryType
        ((byte) 20, "CkptEnd",
         new SingleItemEntry
         (com.sleepycat.je.recovery.CheckpointEnd.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_IN_DELETE_INFO =
        new LogEntryType
        ((byte) 21, "INDelete",
         new SingleItemEntry
         (com.sleepycat.je.tree.INDeleteInfo.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_BIN_DELTA =
        new LogEntryType
        ((byte) 22, "BINDelta",
         new BINDeltaLogEntry
         (com.sleepycat.je.tree.BINDelta.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_DUP_BIN_DELTA =
        new LogEntryType
        ((byte) 23, "DupBINDelta",
         new BINDeltaLogEntry
         (com.sleepycat.je.tree.BINDelta.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    /* Administrative entries */
    public static final LogEntryType LOG_TRACE =
        new LogEntryType
        ((byte) 24, "Trace",
         new SingleItemEntry
         (com.sleepycat.je.log.Trace.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_NO_MATCH);

    /* File header */
    public static final LogEntryType LOG_FILE_HEADER =
        new LogEntryType
        ((byte) 25, "FileHeader",
         new FileHeaderEntry
         (com.sleepycat.je.log.FileHeader.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_IN_DUPDELETE_INFO =
        new LogEntryType
        ((byte) 26, "INDupDelete",
         new SingleItemEntry
         (com.sleepycat.je.tree.INDupDeleteInfo.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_TXN_PREPARE =
        new LogEntryType
        ((byte) 27, "Prepare",
         new SingleItemEntry
         (com.sleepycat.je.txn.TxnPrepare.class),
         Txnal.TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_ROLLBACK_START =
        new LogEntryType
        ((byte) 28, "RollbackStart",
         new SingleItemEntry
         (com.sleepycat.je.txn.RollbackStart.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_ROLLBACK_END =
        new LogEntryType
        ((byte) 29, "RollbackEnd",
         new SingleItemEntry
         (com.sleepycat.je.txn.RollbackEnd.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.LOCAL);

    public static final LogEntryType LOG_MATCHPOINT =
        new LogEntryType
        ((byte) 30, "Matchpoint",
         new SingleItemEntry
         (com.sleepycat.je.utilint.Matchpoint.class),
         Txnal.NON_TXNAL,
         Marshall.OUTSIDE_LATCH,
         Replicable.REPLICABLE_MATCH);

    /*** If you add new types, be sure to update MAX_TYPE_NUM at the top.***/

    /* Persistent fields */
    final private byte typeNum; // persistent value for this entry type

    /* Transient fields */
    final private String displayName;
    final private LogEntry logEntry;

    /*
     * Attributes
     */

    /* Whether the log entry holds a transactional information. */
    private Txnal isTransactional;

    /*
     * Does this log entry be marshalled outside or inside the log write
     * latch.
     */
    private Marshall marshallBehavior;

    /* Can this log entry be put in the replication stream? */
    private Replicable replicationPossible;

    /*
     * Constructors
     */

    /**
     * For base class support.
     */

    /*
     * This constructor only used when the LogEntryType is being used as a key
     * for a map. No log types can be defined outside this package.
     */
    LogEntryType(byte typeNum) {
        this.typeNum = typeNum;
        displayName = null;
        logEntry = null;
    }

    /**
     * Create the static log types.
     * @param isTransactional true if this type of log entry holds data
     * involved in a transaction. For example, transaction commit and LN data
     * records are transactional, but INs are not.
     * @param marshallOutsideLatch true if this type of log entry may be
     * serialized outside the log write latch. This is true of the majority of
     * types. Certain types like the FileSummaryLN rely on the log write latch
     * to enforce serial semantics.
     * @param replicationPossible true if this type of log entry can be shared
     * with a replication group.
     */
    private LogEntryType(byte typeNum,
                         String displayName,
                         LogEntry logEntry,
                         Txnal isTransactional,
                         Marshall marshallBehavior,
                         Replicable replicationPossible) {

        this.typeNum = typeNum;
        this.displayName = displayName;
        this.logEntry = logEntry;
        this.isTransactional = isTransactional;
        this.marshallBehavior = marshallBehavior;
        this.replicationPossible = replicationPossible;
        logEntry.setLogType(this);
        LOG_TYPES[typeNum - 1] = this;
    }

    public boolean isNodeType() {
        return (typeNum <= MAX_NODE_TYPE_NUM);
    }

    /**
     * @return the static version of this type
     */
    public static LogEntryType findType(byte typeNum) {
        if (typeNum <= 0 || typeNum > MAX_TYPE_NUM) {
            return null;
        }
        return LOG_TYPES[typeNum - 1];
    }

    /**
     * Get a copy of all types for unit testing.
     */
    public static Set<LogEntryType> getAllTypes() {
        HashSet<LogEntryType> ret = new HashSet<LogEntryType>();

        for (int i = 0; i < MAX_TYPE_NUM; i++) {
            ret.add(LOG_TYPES[i]);
        }
        return ret;
    }

    /**
     * @return the log entry type owned by the shared, static version
     */
    public LogEntry getSharedLogEntry() {
        return logEntry;
    }

    /**
     * @return a clone of the log entry type for a given log type.
     */
    public LogEntry getNewLogEntry()
        throws DatabaseException {

        try {
            return (LogEntry) logEntry.clone();
        } catch (CloneNotSupportedException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
    }

    public byte getTypeNum() {
        return typeNum;
    }

    /**
     * @return true if type number is valid.
     */
    static boolean isValidType(byte typeNum) {
        return typeNum > 0 && typeNum <= MAX_TYPE_NUM;
    }

    public String toStringNoVersion() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    /**
     * Check for equality without making a new object.
     */
    public boolean equalsType(byte type) {
        return (this.typeNum == type);
    }

    /*
     * Override Object.equals. Ignore provisional bit when checking for
     * equality.
     */
    @Override
    public boolean equals(Object obj) {
        // Same instance?
        if (this == obj) {
            return true;
        }

        // Is it the right type of object?
        if (!(obj instanceof LogEntryType)) {
            return false;
        }

        return typeNum == ((LogEntryType) obj).typeNum;
    }

    /**
     * This is used as a hash key.
     */
    @Override
    public int hashCode() {
        return typeNum;
    }
    static enum Txnal {
        TXNAL(true),
        NON_TXNAL(false);

        private final boolean isTxnal;

        Txnal(boolean isTxnal) {
            this.isTxnal = isTxnal;
        }

        boolean isTransactional() {
            return isTxnal;
        }
    }
    /**
     * Return true if this log entry has transactional information in it,
     * like a commit or abort record, or a transactional LN.
     */
    public boolean isTransactional() {
        return isTransactional.isTransactional();
    }

    static enum Marshall {
        OUTSIDE_LATCH(true),
        INSIDE_LATCH(false);

        private final boolean marshallOutsideLatch;

        Marshall(boolean marshallOutsideLatch) {
            this.marshallOutsideLatch = marshallOutsideLatch;
        }

        boolean marshallOutsideLatch() {
            return marshallOutsideLatch;
        }
    }

    /**
     * Return true if this log entry should be marshalled into a buffer outside
     * the log write latch. Currently, only the FileSummaryLN and MapLN (which
     * contains DbFileSummary objects) need to be logged inside the log write
     * latch.
     */
    public boolean marshallOutsideLatch() {
        return marshallBehavior.marshallOutsideLatch();
    }

    /**
     * Return true if the type of this LogEntryType is equivalent to typeB.
     * Version is used as a factor in the comparison when new log entry types
     * are introduced in one release, which supercede existing types.
     */
    public boolean compareTypeAndVersion(int versionA, 
                                         int versionB, 
                                         byte typeB) {
        return typeNum == typeB;
    }

    /*
     * Indicates whether this type of log entry is shared in a replicated
     * environment or not, and whether it can be used as a replication
     * matchpoint.
     */
    static enum Replicable {
        REPLICABLE_MATCH(true, true),
        REPLICABLE_NO_MATCH(true, false),
        LOCAL(false, false);

        private final boolean isReplicable;
        private final boolean isMatchable;

        Replicable(boolean isReplicable, boolean isMatchable) {
            this.isReplicable = isReplicable;
            this.isMatchable = isMatchable;
        }

        boolean isReplicable() {
            return isReplicable;
        }

        boolean isMatchable() {
            return isMatchable;
        }
    }

    /**
     * Return true if this type of log entry can be part of the replication
     * stream. For example, INs can never be replicated, while LNs are
     * replicated only if their owning database is replicated.
     */
    public boolean isReplicationPossible() {
        return replicationPossible.isReplicable();
    }

    /**
     * Return true if this type of log entry can serve as the synchronization
     * matchpoint for the replication stream. That generally means that this
     * log entry contains an replication node id.
     */
    public boolean isSyncPoint() {
        return replicationPossible.isMatchable();
    }

    /**
     * Return true if this type of log entry can serve as the synchronization
     * matchpoint for the replication stream.
     */
    public static boolean isSyncPoint(byte entryType) {
        return findType(entryType).isSyncPoint();
    }

    /**
     * Return true if the two types are equal. Handles the situation where new
     * log entry types were introduced in one release, that are actually 
     * equivalent to old, deprecated types.
     */
    public static boolean compareTypeAndVersion(int versionA,
                                                byte typeA,
                                                int versionB,
                                                byte typeB) {
        LogEntryType entryA = findType(typeA);
        return entryA.compareTypeAndVersion(versionA, versionB, typeB);
    }
}
