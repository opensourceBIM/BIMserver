/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.cleaner.FileSummary;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.entry.INLogEntry;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.log.entry.SingleItemEntry;
import com.sleepycat.je.tree.INDeleteInfo;
import com.sleepycat.je.tree.INDupDeleteInfo;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.txn.TxnCommit;
import com.sleepycat.je.txn.TxnEnd;
import com.sleepycat.je.utilint.DbLsn;

/**
 * Summarizes the utilized and unutilized portion of each log file by examining
 * each log entry.  Does not use the Cleaner UtilizationProfile information in
 * order to provide a second measure against which to evaluation the
 * UtilizationProfile accuracy.
 */
public class UtilizationFileReader extends FileReader {

    private static final boolean DEBUG = true;

    private Map<Long,FileSummary> summaries;     // Long file -> FileSummary
    private Map<Long,NodeInfo> activeNodes;   // Long node ID -> NodeInfo
    private Map<Long,List<Object>> txns;     // Long txn ID -> List of pairs, 
                                     // where each pair
                                     // is [ExtendedFileSummary, LNLogEntry]

    /* holds one [ExtendedFileSummary, LNLogEntry] */
    private List<Object> twoEntryList;

    private UtilizationFileReader(EnvironmentImpl env, int readBufferSize)
        throws DatabaseException {

        super(env,
              readBufferSize,
              true,            // read forward
              DbLsn.NULL_LSN,  // start LSN
              null,            // single file number
              DbLsn.NULL_LSN,  // end of file LSN
              DbLsn.NULL_LSN); // finish LSN

        summaries = new HashMap<Long,FileSummary>();
        activeNodes = new HashMap<Long,NodeInfo>();
        txns = new HashMap<Long,List<Object>>();

        twoEntryList = new ArrayList<Object>();
        twoEntryList.add(null);
        twoEntryList.add(null);
    }

    @Override
    protected boolean isTargetEntry() {

        /* 
         * UtilizationTracker is supposed to mimic the UtilizationProfile. 
         * Accordingly it does not count the file header or invisible log 
         * entries because those entries are not covered by the U.P.
         */
        return ((currentEntryHeader.getType() !=
                 LogEntryType.LOG_FILE_HEADER.getTypeNum()) &&
                !currentEntryHeader.isInvisible());
    }

    protected boolean processEntry(ByteBuffer entryBuffer)
        throws DatabaseException {

        LogEntryType lastEntryType =
            LogEntryType.findType(currentEntryHeader.getType());
        LogEntry entry = lastEntryType.getNewLogEntry();
        entry.readEntry(currentEntryHeader, entryBuffer, true); // readFullItem

        ExtendedFileSummary summary = 
                (ExtendedFileSummary) summaries.get(window.currentFileNum());
        if (summary == null) {
            summary = new ExtendedFileSummary();
            summaries.put(window.currentFileNum(), summary);
        }

        int size = getLastEntrySize();

        summary.totalCount += 1;
        summary.totalSize += size;

        if (entry instanceof LNLogEntry) {
            LNLogEntry lnEntry = (LNLogEntry) entry;
            if (DEBUG) {
                int otherSize = lnEntry.getLN().getLastLoggedSize();
                if (size != otherSize) {
                    System.out.println
                        ("LogReader.getLastEntrySize=" + size +
                         " LN.getLastLoggedSize=" + otherSize +
                         " " + lnEntry.getLogType());
                }
            }
            if (lastEntryType.isTransactional()) {
                Long txnId = Long.valueOf(lnEntry.getTransactionId());
                List<Object> txnEntries = txns.get(txnId);
                if (txnEntries == null) {
                    txnEntries = new ArrayList<Object>();
                    txns.put(txnId, txnEntries);
                }
                txnEntries.add(summary);
                txnEntries.add(lnEntry);
            } else {
                twoEntryList.set(0, summary);
                twoEntryList.set(1, lnEntry);
                applyTxn(twoEntryList, true);
            }
        } else if (entry instanceof INLogEntry) {
            INLogEntry inEntry = (INLogEntry) entry;
            Long nodeId = Long.valueOf(inEntry.getNodeId());
            summary.totalINCount += 1;
            summary.totalINSize += size;
            countObsoleteNode(nodeId);
            putActiveNode(nodeId, size, summary,
                          inEntry.getDbId().getId(),
                          false);
        } else if (entry instanceof SingleItemEntry) {
            Object item = ((SingleItemEntry) entry).getMainItem();
            long deletedNodeId = Node.NULL_NODE_ID;
            if (item instanceof INDeleteInfo) {
                deletedNodeId = ((INDeleteInfo) item).getDeletedNodeId();
            } else if (item instanceof INDupDeleteInfo) {
                deletedNodeId = ((INDupDeleteInfo) item).getDeletedNodeId();
            }
            if (deletedNodeId != Node.NULL_NODE_ID) {
                Long nodeId = Long.valueOf(deletedNodeId);
                countObsoleteNode(nodeId);
                activeNodes.remove(nodeId);
            }
            if (item instanceof TxnEnd) {
                Long txnId = Long.valueOf(((TxnEnd) item).getTransactionId());
                List<Object> txnEntries = txns.remove(txnId);
                if (txnEntries != null) {
                    applyTxn(txnEntries, item instanceof TxnCommit);
                }
            }
        }

        return true;
    }

    private void applyTxn(List<Object> entries, boolean commit) {
        for (int i = 0; i < entries.size(); i += 2) {
            ExtendedFileSummary summary = (ExtendedFileSummary) entries.get(i);
            LNLogEntry lnEntry = (LNLogEntry) entries.get(i + 1);
            LN ln = lnEntry.getLN();
            int size = ln.getLastLoggedSize();

            summary.totalLNCount += 1;
            summary.totalLNSize += size;

            if (!commit || ln.isDeleted()) {
                summary.obsoleteLNCount += 1;
                summary.recalcObsoleteLNSize += size;
            }

            if (commit) {
                Long nodeId = Long.valueOf(lnEntry.getNodeId());
                countObsoleteNode(nodeId);
                if (ln.isDeleted()) {
                    activeNodes.remove(nodeId);
                } else {
                    putActiveNode(nodeId, size, summary,
                                  lnEntry.getDbId().getId(),
                                  true);
                }
            }

            /* Process Database truncate or remove. */
            if (commit && ln.isDeleted() && ln instanceof MapLN) {
                int dbId = ((MapLN) ln).getDatabase().getId().getId();
                Iterator<Map.Entry<Long,NodeInfo>> iter = 
                    activeNodes.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<Long,NodeInfo> iEntry = iter.next();
                    NodeInfo info = iEntry.getValue();
                    if (info.dbId == dbId) {
                        Long nodeId = iEntry.getKey();
                        countObsoleteNode(nodeId);
                        iter.remove();
                    }
                }
            }
        }
    }

    private void finishProcessing() {

        /* Apply uncomitted transactions. */
        Iterator<List<Object>> txnIter = txns.values().iterator();
        while (txnIter.hasNext()) {
            List<Object> txnEntries = txnIter.next();
            applyTxn(txnEntries, false);
        }
    }

    private void putActiveNode(Long nodeId,
                               int size,
                               ExtendedFileSummary summary,
                               int dbId,
                               boolean isLN) {
        NodeInfo info = activeNodes.get(nodeId);
        if (info == null) {
            info = new NodeInfo();
            activeNodes.put(nodeId, info);
        }
        info.size = size;
        info.summary = summary;
        info.dbId = dbId;
        info.isLN = isLN;
    }

    private void countObsoleteNode(Long nodeId) {
        NodeInfo info = activeNodes.get(nodeId);
        if (info != null) {
            ExtendedFileSummary summary = info.summary;
            if (info.isLN) {
                summary.obsoleteLNCount += 1;
                summary.recalcObsoleteLNSize += info.size;
            } else {
                summary.obsoleteINCount += 1;
                summary.recalcObsoleteINSize += info.size;
            }
        }
    }

    /**
     * Creates a UtilizationReader, reads the log, and returns the resulting
     * Map of Long file number to FileSummary.
     */
    public static Map<Long,FileSummary> calcFileSummaryMap(EnvironmentImpl env)
        throws DatabaseException {

        int readBufferSize = env.getConfigManager().getInt
            (EnvironmentParams.LOG_ITERATOR_READ_SIZE);

        UtilizationFileReader reader =
            new UtilizationFileReader(env, readBufferSize);
        while (reader.readNextEntry()) {
            /* All the work is done in processEntry. */
        }

        reader.finishProcessing();
        return reader.summaries;
    }

    private static class ExtendedFileSummary extends FileSummary {
        private int recalcObsoleteINSize;
        private int recalcObsoleteLNSize;

        /**
         * Overrides the LN size calculation to return the recalculated number
         * of obsolete LN bytes.
         */
        @Override
        public int getObsoleteLNSize() {
            return recalcObsoleteLNSize;
        }

        /**
         * Overrides the IN size calculation to return the recalculated number
         * of obsolete IN bytes.
         */
        @Override
        public int getObsoleteINSize() {
            return recalcObsoleteINSize;
        }

        /**
         * Overrides to add the extended data fields.
         */
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder();
            buf.append(super.toString());
            buf.append("<extended-info recalcObosleteINSize=\"");
            buf.append(recalcObsoleteINSize);
            buf.append("\" recalcObosletedLNSize=\"");
            buf.append(recalcObsoleteLNSize);
            buf.append("\"/>");
            return buf.toString();
        }
    }

    private static class NodeInfo {
        ExtendedFileSummary summary;
        int size;
        int dbId;
        boolean isLN;
    }
}
