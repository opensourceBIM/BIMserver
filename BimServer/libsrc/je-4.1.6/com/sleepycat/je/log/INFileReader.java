/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.cleaner.RecoveryUtilizationTracker;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.entry.INContainingEntry;
import com.sleepycat.je.log.entry.INLogEntry;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.log.entry.NodeLogEntry;
import com.sleepycat.je.recovery.VLSNRecoveryProxy;
import com.sleepycat.je.tree.FileSummaryLN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.INDeleteInfo;
import com.sleepycat.je.tree.INDupDeleteInfo;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.utilint.DbLsn;

/**
 * INFileReader supports recovery by scanning log files during the IN rebuild
 * pass. It looks for internal nodes (all types), segregated by whether they
 * belong to the main tree or the duplicate trees.
 *
 * <p>This file reader can also be run in tracking mode to keep track of the
 * maximum node id, database id and txn id seen so those sequences can be
 * updated properly at recovery.  In this mode it also performs utilization
 * counting.  It is only run once in tracking mode per recovery, in the first
 * phase of recovery.</p>
 */
public class INFileReader extends FileReader {

    /* Information about the last entry seen. */
    private boolean lastEntryWasDelete;
    private boolean lastEntryWasDupDelete;
    private LogEntryType fromLogType;
    private boolean isProvisional;

    /*
     * targetEntryMap maps DbLogEntryTypes to log entries. We use this
     * collection to find the right LogEntry instance to read in the current
     * entry.
     */
    private Map<LogEntryType, LogEntry> targetEntryMap;
    private LogEntry targetLogEntry;

    /*
     * For tracking non-target log entries.  Note that dbIdTrackingEntry and
     * txnIdTrackingEntry do not overlap with targetLogEntry, since the former
     * are LNs and the latter are INs.  But nodeTrackingEntry and
     * inTrackingEntry can overlap with the others, and we only load one of
     * them when they do overlap.
     */
    private Map<LogEntryType, LogEntry> dbIdTrackingMap;
    private LNLogEntry dbIdTrackingEntry;
    private Map<LogEntryType, LogEntry> txnIdTrackingMap;
    private LNLogEntry txnIdTrackingEntry;
    private Map<LogEntryType, NodeLogEntry> otherNodeTrackingMap;
    private NodeLogEntry nodeTrackingEntry;
    private INLogEntry inTrackingEntry;
    private LNLogEntry fsTrackingEntry;

    /*
     * If trackIds is true, peruse all node entries for the maximum node id,
     * check all MapLNs for the maximum db id, and check all LNs for the
     * maximum txn id
     */
    private boolean trackIds;
    private long minReplicatedNodeId;
    private long maxNodeId;
    private int minReplicatedDbId;
    private int maxDbId;
    private long minReplicatedTxnId;
    private long maxTxnId;
    private boolean mapDbOnly;
    private long ckptEnd;

    /* Used for utilization tracking. */
    private long partialCkptStart;
    private RecoveryUtilizationTracker tracker;

    /* Used for replication. */
    private VLSNRecoveryProxy vlsnProxy;

    /**
     * Create this reader to start at a given LSN.
     */
    public INFileReader(EnvironmentImpl env,
                        int readBufferSize,
                        long startLsn,
                        long finishLsn,
                        boolean trackIds,
                        boolean mapDbOnly,
                        long partialCkptStart,
                        long ckptEnd,
                        RecoveryUtilizationTracker tracker)
        throws DatabaseException {

        super(env, readBufferSize, true, startLsn, null,
              DbLsn.NULL_LSN, finishLsn);

        this.trackIds = trackIds;
        this.mapDbOnly = mapDbOnly;
        this.ckptEnd = ckptEnd;
        targetEntryMap = new HashMap<LogEntryType, LogEntry>();

        if (trackIds) {
            maxNodeId = 0;
            maxDbId = 0;
            maxTxnId = 0;
            minReplicatedNodeId = 0;
            minReplicatedDbId = DbTree.NEG_DB_ID_START;
            minReplicatedTxnId = 0;
            this.tracker = tracker;
            this.partialCkptStart = partialCkptStart;

            dbIdTrackingMap = new HashMap<LogEntryType, LogEntry>();
            txnIdTrackingMap = new HashMap<LogEntryType, LogEntry>();
            otherNodeTrackingMap = new HashMap<LogEntryType, NodeLogEntry>();

            dbIdTrackingMap.put(LogEntryType.LOG_MAPLN_TRANSACTIONAL,
                                LogEntryType.LOG_MAPLN_TRANSACTIONAL.
                                getNewLogEntry());
            dbIdTrackingMap.put(LogEntryType.LOG_MAPLN,
                                LogEntryType.LOG_MAPLN.getNewLogEntry());
            txnIdTrackingMap.put(LogEntryType.LOG_LN_TRANSACTIONAL,
                                 LogEntryType.LOG_LN_TRANSACTIONAL.
                                 getNewLogEntry());
            txnIdTrackingMap.put(LogEntryType.LOG_MAPLN_TRANSACTIONAL,
                                 LogEntryType.LOG_MAPLN_TRANSACTIONAL.
                                 getNewLogEntry());
            txnIdTrackingMap.put(LogEntryType.LOG_NAMELN_TRANSACTIONAL,
                                 LogEntryType.LOG_NAMELN_TRANSACTIONAL.
                                 getNewLogEntry());
            txnIdTrackingMap.put(LogEntryType.LOG_DEL_DUPLN_TRANSACTIONAL,
                                 LogEntryType.LOG_DEL_DUPLN_TRANSACTIONAL.
                                 getNewLogEntry());
            txnIdTrackingMap.put(LogEntryType.LOG_DUPCOUNTLN_TRANSACTIONAL,
                                 LogEntryType.LOG_DUPCOUNTLN_TRANSACTIONAL.
                                 getNewLogEntry());

            vlsnProxy = envImpl.getVLSNProxy();
            addTargetType(LogEntryType.LOG_ROLLBACK_START);
        }
    }

    /**
     * Configure this reader to target this kind of entry.
     */
    public void addTargetType(LogEntryType entryType)
        throws DatabaseException {

        targetEntryMap.put(entryType, entryType.getNewLogEntry());
    }

    /*
     * Utilization Tracking
     * --------------------
     * This class counts all new log entries and obsolete INs.  Obsolete LNs,
     * on the other hand, are counted by RecoveryManager undo/redo.
     *
     * Utilization counting is done in the first recovery pass where IDs are
     * tracked (trackIds=true).  Processing is split between isTargetEntry
     * and processEntry as follows.
     *
     * isTargetEntry counts only new non-node entries; this can be done very
     * efficiently using only the LSN and entry type, without reading and
     * unmarshalling the entry.  isTargetEntry also sets up several
     * xxxTrackingEntry fields for utilization counting in processEntry.
     *
     * processEntry counts new node entries and obsolete INs.  processEntry is
     * optimized to do a partial load (readEntry with readFullItem=false) of
     * entries that are not the target entry and only need to be scanned for a
     * transaction id, node id, or its owning database id.  In these cases it
     * returns false, so that getNextEntry will not return a partially loaded
     * entry to the RecoveryManager.  For example, a provisional IN will be
     * partially loaded since only the node ID, database ID and obsolete LSN
     * properties are needed for tracking.
     *
     * processEntry also resets (sets all counters to zero and clears obsolete
     * offsets) the tracked summary for a file or database when a FileSummaryLN
     * or MapLN is encountered.  This clears the totals that have accumulated
     * during this recovery pass for entries prior to that point.  We only want
     * to count utilization for entries after that point.
     *
     * In addition, when processEntry encounters a FileSummaryLN or MapLN, its
     * LSN is recorded in the tracker.  This information is used during IN and
     * LN utilization counting.  For each file, knowing the LSN of the last
     * logged FileSummaryLN for that file allows the undo/redo code to know
     * whether to perform obsolete countng.  If the LSN of the FileSummaryLN is
     * less than (to the left of) the LN's LSN, obsolete counting should be
     * performed.  If it is greater, obsolete counting is already included in
     * the logged FileSummaryLN and should not be repeated to prevent double
     * counting.  The same thing is true of counting per-database utilization
     * relative to the LSN of the last logged MapLN.
     */

    /**
     * If we're tracking node, database and txn ids, we want to see all node
     * log entries. If not, we only want to see IN entries.
     * @return true if this is an IN entry.
     */
    @Override
    protected boolean isTargetEntry()
        throws DatabaseException {

        lastEntryWasDelete = false;
        lastEntryWasDupDelete = false;
        targetLogEntry = null;
        dbIdTrackingEntry = null;
        txnIdTrackingEntry = null;
        nodeTrackingEntry = null;
        inTrackingEntry = null;
        fsTrackingEntry = null;
        isProvisional = currentEntryHeader.getProvisional().isProvisional
            (getLastLsn(), ckptEnd);

        /* Get the log entry type instance we need to read the entry. */
        fromLogType = LogEntryType.findType(currentEntryHeader.getType());
        LogEntry possibleTarget = targetEntryMap.get(fromLogType);

        /*
         * If the entry is provisional, we won't be reading it in its entirety;
         * otherwise, we try to establish targetLogEntry.
         */
        if (!isProvisional) {
            targetLogEntry = possibleTarget;
        }

        /* Was the log entry an IN deletion? */
        if (LogEntryType.LOG_IN_DELETE_INFO.equals(fromLogType)) {
            lastEntryWasDelete = true;
        }

        if (LogEntryType.LOG_IN_DUPDELETE_INFO.equals(fromLogType)) {
            lastEntryWasDupDelete = true;
        }

        if (!trackIds) {

            /*
             * Return true if this entry should be passed on to processEntry.
             * If we're not tracking ids, only return true if it's a targeted
             * entry.
             */
            return (targetLogEntry != null);
        }

        /* This processing below applies if we are going to track ids. */

        /*
         * Check if it's a db or txn id tracking entry.  Note that these
         * entries do not overlap with targetLogEntry.
         */
        if (!isProvisional) {
            dbIdTrackingEntry = (LNLogEntry) dbIdTrackingMap.get(fromLogType);
            txnIdTrackingEntry = (LNLogEntry) txnIdTrackingMap.get(fromLogType);
        }

        /*
         * Determine nodeTrackingEntry, inTrackingEntry, fsTrackingEntry.  Note
         * that these entries do overlap with targetLogEntry.
         */
        if (fromLogType.isNodeType()) {
            if (possibleTarget != null) {
                nodeTrackingEntry = (NodeLogEntry) possibleTarget;
            } else if (dbIdTrackingEntry != null) {
                nodeTrackingEntry = dbIdTrackingEntry;
            } else if (txnIdTrackingEntry != null) {
                nodeTrackingEntry = txnIdTrackingEntry;
            } else {
                nodeTrackingEntry = otherNodeTrackingMap.get(fromLogType);
                if (nodeTrackingEntry == null) {
                    nodeTrackingEntry = (NodeLogEntry)
                        fromLogType.getNewLogEntry();
                    otherNodeTrackingMap.put(fromLogType, nodeTrackingEntry);
                }
            }
            if (nodeTrackingEntry instanceof INLogEntry) {
                inTrackingEntry = (INLogEntry) nodeTrackingEntry;
            }
            if (LogEntryType.LOG_FILESUMMARYLN.equals(fromLogType)) {
                fsTrackingEntry = (LNLogEntry) nodeTrackingEntry;
            }
        } else {

            /*
             * Count all non-node entries except for the file header as new.
             * UtilizationTracker does not count the file header.  Node entries
             * will be counted in processEntry.  Null is passed for the
             * database ID; it is only needed for node entries.
             */
            if (!LogEntryType.LOG_FILE_HEADER.equals(fromLogType)) {
                tracker.countNewLogEntry(getLastLsn(),
                                         fromLogType,
                                         currentEntryHeader.getSize() +
                                         currentEntryHeader.getItemSize(),
                                         null); // DatabaseId
            }

            /*
             * When the Root is encountered, reset the tracked summary for the
             * ID and Name mapping DBs.  This clears what we accummulated
             * previously for these databases during this recovery pass.  Save
             * the LSN for these databases for use by undo/redo.
             */
            if (LogEntryType.LOG_ROOT.equals(fromLogType)) {
                tracker.saveLastLoggedMapLN(DbTree.ID_DB_ID, getLastLsn());
                tracker.saveLastLoggedMapLN(DbTree.NAME_DB_ID, getLastLsn());
                tracker.resetDbInfo(DbTree.ID_DB_ID);
                tracker.resetDbInfo(DbTree.NAME_DB_ID);
            }
        }

        /*
         * Return true if this entry should be passed on to processEntry.  If
         * we're tracking ids, return if this is a targeted entry or if it's
         * any kind of tracked entry or node. If it's a replicated log entry,
         * we'll want to track the VLSN in the optional portion of the
         * header. We don't need a tracking log entry to do that, but we can
         * only do it when the log entry header has been fully read, which is
         * not true yet.
         */
        return (targetLogEntry != null) ||
            (dbIdTrackingEntry != null) ||
            (txnIdTrackingEntry != null) ||
            (nodeTrackingEntry != null) ||
            currentEntryHeader.getReplicated();
    }

    /**
     * This reader returns non-provisional INs and IN delete entries.
     * In tracking mode, it may also scan log entries that aren't returned:
     *  -to set the sequences for txn, node, and database id.
     *  -to update utilization and obsolete offset information.
     *  -for VLSN mappings for recovery
     */
    protected boolean processEntry(ByteBuffer entryBuffer)
        throws DatabaseException {

        boolean useEntry = false;
        boolean entryLoaded = false;

        /* If this is a targeted entry, read the entire log entry. */
        if (targetLogEntry != null) {
            targetLogEntry.readEntry(currentEntryHeader,
                                     entryBuffer,
                                     true); // readFullItem
            entryLoaded = true;
            if (currentEntryHeader.getType() !=
                LogEntryType.LOG_ROLLBACK_START.getTypeNum()) {
                DatabaseId dbId = getDatabaseId();
                boolean isMapDb = dbId.equals(DbTree.ID_DB_ID);
                useEntry = (!mapDbOnly || isMapDb);
            }
        }

        /* Do a partial load during tracking if necessary. */
        if (!trackIds) {
            return useEntry;
        }

        DatabaseId dbIdToReset = null;
        long fileNumToReset = -1;

        /*
         * Process db and txn id tracking entries.  Note that these entries do
         * not overlap with targetLogEntry.
         */
        LNLogEntry lnEntry = null;
        if (dbIdTrackingEntry != null) {
            /* This entry has a db id */
            lnEntry = dbIdTrackingEntry;

            /*
             * Do a full load to get DB ID from DatabaseImpl. Note that while a
             * partial read gets the database id for the database that owns
             * this LN, it doesn't get the database id for the database
             * contained by a MapLN. That's what we're trying to track.
             */
            lnEntry.readEntry(currentEntryHeader,
                              entryBuffer,
                              true); // readFullItem
            entryLoaded = true;
            MapLN mapLN = (MapLN) lnEntry.getMainItem();
            DatabaseId dbId = mapLN.getDatabase().getId();
            int dbIdVal = dbId.getId();
            maxDbId = (dbIdVal > maxDbId) ? dbIdVal : maxDbId;
            minReplicatedDbId = (dbIdVal < minReplicatedDbId) ?
                dbIdVal : minReplicatedDbId;

            /*
             * When a MapLN is encountered, reset the tracked information for
             * that database.  This clears what we accummulated previously for
             * the database during this recovery pass.
             */
            dbIdToReset = dbId;

            /* Save the LSN of the MapLN for use by undo/redo. */
            tracker.saveLastLoggedMapLN(dbId, getLastLsn());
        }

        if (txnIdTrackingEntry != null) {
            /* This entry has a txn id */
            if (lnEntry == null) {
                /* Do a partial load since we only need the txn ID. */
                lnEntry = txnIdTrackingEntry;
                lnEntry.readEntry(currentEntryHeader,
                                  entryBuffer,
                                  false); // readFullItem
                entryLoaded = true;
            }
            long txnId = lnEntry.getTxnId().longValue();
            maxTxnId = (txnId > maxTxnId) ? txnId : maxTxnId;
            minReplicatedTxnId = (txnId < minReplicatedTxnId) ?
                txnId : minReplicatedTxnId;
        }

        /*
         * Perform utilization counting under trackIds to prevent
         * double-counting.
         */
        if (fsTrackingEntry != null) {

            if (!entryLoaded) {
                /* Do full load to get file number from FileSummaryLN. */
                nodeTrackingEntry.readEntry(currentEntryHeader,
                                            entryBuffer,
                                            true); // readFullItem
                entryLoaded = true;
            }

            /*
             * When a FileSummaryLN is encountered, reset the tracked summary
             * for that file.  This clears what we accummulated previously for
             * the file during this recovery pass.
             */
            byte[] keyBytes = fsTrackingEntry.getKey();
            FileSummaryLN fsln =
                (FileSummaryLN) fsTrackingEntry.getMainItem();
            long fileNum = fsln.getFileNumber(keyBytes);
            fileNumToReset = fileNum;

            /* Save the LSN of the FileSummaryLN for use by undo/redo. */
            tracker.saveLastLoggedFileSummaryLN(fileNum, getLastLsn());

            /*
             * Do not cache the file summary in the UtilizationProfile here,
             * since it may be for a deleted log file. [#10395]
             */
        }

        /* Process the nodeTrackingEntry (and inTrackingEntry). */
        if (nodeTrackingEntry != null) {
            if (!entryLoaded) {
                /* Do a partial load; we only need the node and DB IDs. */
                nodeTrackingEntry.readEntry(currentEntryHeader,
                                            entryBuffer,
                                            false); // readFullItem
                entryLoaded = true;
            }
            /* Keep track of the largest node id seen. */
            long nodeId = nodeTrackingEntry.getNodeId();
            maxNodeId = (nodeId > maxNodeId) ? nodeId : maxNodeId;
            minReplicatedNodeId = (nodeId < minReplicatedNodeId) ?
                nodeId : minReplicatedNodeId;

            /*
             * Count node entries as new.  Non-node entries are counted in
             * isTargetEntry.
             */
            tracker.countNewLogEntry(getLastLsn(), fromLogType,
                                     currentEntryHeader.getSize() +
                                     currentEntryHeader.getItemSize(),
                                     nodeTrackingEntry.getDbId());
        }

        if (inTrackingEntry != null) {
            assert entryLoaded : "All nodes should have been loaded";

            /*
             * Count the obsolete LSN of the previous version, if available and
             * if not already counted.  Use inexact counting for two reasons:
             * 1) we don't always have the full LSN because earlier log
             * versions only had the file number, and 2) we can't guarantee
             * obsoleteness for provisional INs.
             */
            long oldLsn = inTrackingEntry.getObsoleteLsn();
            if (oldLsn != DbLsn.NULL_LSN) {
                long newLsn = getLastLsn();
                tracker.countObsoleteIfUncounted
                    (oldLsn, newLsn, fromLogType, 0,
                     inTrackingEntry.getDbId(),
                     false); // countExact
            }

            /*
             * Count a provisional IN as obsolete if it follows
             * partialCkptStart.  It cannot have been already counted, because
             * provisional INs are not normally counted as obsolete; they are
             * only considered obsolete when they are part of a partial
             * checkpoint.
             *
             * Depending on the exact point at which the checkpoint was
             * aborted, this technique is not always accurate; therefore
             * inexact counting must be used.
             */
            if (isProvisional && partialCkptStart != DbLsn.NULL_LSN) {
                oldLsn = getLastLsn();
                if (DbLsn.compareTo(partialCkptStart, oldLsn) < 0) {
                    tracker.countObsoleteUnconditional
                        (oldLsn, fromLogType, 0,
                         inTrackingEntry.getDbId(),
                         false); // countExact
                }
            }
        }

        /*
         * Reset file and database utilization info only after counting a new
         * or obsolete node.  The MapLN itself is a node and will be counted as
         * new above, and we must reset that count as well.
         */
        if (fileNumToReset != -1) {
            tracker.resetFileInfo(fileNumToReset);
        }
        if (dbIdToReset != null) {
            tracker.resetDbInfo(dbIdToReset);
        }

        /*
         * Look for VLSNs in the log entry header. If this log entry was
         * processed only to find its VLSN, entryBuffer was not advanced yet
         * because we didn't need to use the rest of the entry. Position it to
         * the end of the entry.
         */
        vlsnProxy.trackMapping(getLastLsn(),
                               currentEntryHeader,
                               targetLogEntry);

        if (!entryLoaded) {
            int endPosition = threadSafeBufferPosition(entryBuffer) +
                currentEntryHeader.getItemSize();
            threadSafeBufferPosition(entryBuffer, endPosition);
        }

        /* Return true if this entry should be processed */
        return useEntry;
    }

    /**
     * Get the last IN seen by the reader.
     */
    public IN getIN()
        throws DatabaseException {

        return ((INContainingEntry) targetLogEntry).getIN(envImpl);
    }

    /**
     * Get the last databaseId seen by the reader.
     */
    public DatabaseId getDatabaseId() {
        if (lastEntryWasDelete) {
            return ((INDeleteInfo) targetLogEntry.getMainItem()).
                getDatabaseId();
        } else if (lastEntryWasDupDelete) {
            return ((INDupDeleteInfo) targetLogEntry.getMainItem()).
                getDatabaseId();
        } else {
            return ((INContainingEntry) targetLogEntry).getDbId();
        }
    }

    /**
     * Get the maximum node id seen by the reader.
     */
    public long getMaxNodeId() {
        return maxNodeId;
    }

    public long getMinReplicatedNodeId() {
        return minReplicatedNodeId;
    }

    /**
     * Get the maximum db id seen by the reader.
     */
    public int getMaxDbId() {
        return maxDbId;
    }

    public int getMinReplicatedDbId() {
        return minReplicatedDbId;
    }

    /**
     * Get the maximum txn id seen by the reader.
     */
    public long getMaxTxnId() {
        return maxTxnId;
    }

    public long getMinReplicatedTxnId() {
        return minReplicatedTxnId;
    }

    /**
     * @return true if the last entry was a delete info entry.
     */
    public boolean isDeleteInfo() {
        return lastEntryWasDelete;
    }

    /**
     * @return true if the last entry was a dup delete info entry.
     */
    public boolean isDupDeleteInfo() {
        return lastEntryWasDupDelete;
    }

    /**
     * Get the deleted node id stored in the last delete info log entry.
     */
    public long getDeletedNodeId() {
        return ((INDeleteInfo)
                targetLogEntry.getMainItem()).getDeletedNodeId();
    }

    /**
     * Get the deleted id key stored in the last delete info log entry.
     */
    public byte[] getDeletedIdKey() {
        return ((INDeleteInfo)
                targetLogEntry.getMainItem()).getDeletedIdKey();
    }

    /**
     * Get the deleted node id stored in the last delete info log entry.
     */
    public long getDupDeletedNodeId() {
        return ((INDupDeleteInfo)
                targetLogEntry.getMainItem()).getDeletedNodeId();
    }

    /**
     * Returns true if we are certain that this log entry reflects deletion of
     * a DIN root.  Returns false if it may or may not be a DIN root.  [#18663]
     */
    public boolean isDupRootDeletion() {
        return ((INDupDeleteInfo)
                targetLogEntry.getMainItem()).isDupRootDeletion();
    }

    /**
     * Get the deleted main key stored in the last delete info log entry.
     */
    public byte[] getDupDeletedMainKey() {
        return ((INDupDeleteInfo)
                targetLogEntry.getMainItem()).getDeletedMainKey();
    }

    /**
     * Get the deleted main key stored in the last delete info log entry.
     */
    public byte[] getDupDeletedDupKey() {
        return ((INDupDeleteInfo)
                targetLogEntry.getMainItem()).getDeletedDupKey();
    }

    /**
     * Get the LSN that should represent this IN. For most INs, it's the LSN
     * that was just read. For BINDelta entries, it's the LSN of the last
     * full version.
     */
    public long getLsnOfIN() {
        return ((INContainingEntry) targetLogEntry).getLsnOfIN(getLastLsn());
    }

    public VLSNRecoveryProxy getVLSNProxy() {
        return vlsnProxy;
    }
}
