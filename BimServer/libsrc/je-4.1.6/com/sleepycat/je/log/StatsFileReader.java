/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.utilint.DbLsn;

/**
 * The StatsFileReader generates stats about the log entries read, such as the
 * count of each type of entry, the number of bytes, minimum and maximum sized
 * log entry.
 */
public class StatsFileReader extends DumpFileReader {

    private final Map<LogEntryType,EntryInfo> entryInfoMap;
    private long totalLogBytes;
    private long totalCount;

    /* Keep stats on log composition in terms of ckpt intervals. */
    private final ArrayList<CheckpointCounter> ckptList;
    private CheckpointCounter ckptCounter;
    private long firstLsnRead;

    private long realTotalKeyBytes = 0;
    private long realTotalDataBytes = 0;

    /**
     * Create this reader to start at a given LSN.
     */
    public StatsFileReader(EnvironmentImpl envImpl,
                           int readBufferSize,
                           long startLsn,
                           long finishLsn,
                           String entryTypes,
                           String txnIds,
                           boolean verbose,
                           boolean repEntriesOnly)
        throws DatabaseException {

        super(envImpl, readBufferSize, startLsn, finishLsn,
              entryTypes, txnIds, verbose, repEntriesOnly);
        entryInfoMap =
            new TreeMap<LogEntryType, EntryInfo>(new LogEntryTypeComparator());

        totalLogBytes = 0;
        totalCount = 0;

        ckptCounter = new CheckpointCounter();
        ckptList = new ArrayList<CheckpointCounter>();
        if (verbose) {
            ckptList.add(ckptCounter);
        }
    }

    /**
     * This reader collects stats about the log entry.
     */
    @Override
    protected boolean processEntry(ByteBuffer entryBuffer) {
        byte currentType = currentEntryHeader.getType();
        int itemSize = currentEntryHeader.getItemSize();
        int headerSize = currentEntryHeader.getSize();

        /*
         * Record various stats based on the entry header, then move the buffer
         * forward to skip ahead.
         */
        LogEntryType lastEntryType = LogEntryType.findType(currentType);
        int nextEntryPosition = entryBuffer.position() + itemSize;

        /*
         * Get the info object for it, if this is the first time it's seen,
         * create an info object and insert it.
         */
        EntryInfo info = entryInfoMap.get(lastEntryType);
        if (info == null) {
            info = new EntryInfo();
            entryInfoMap.put(lastEntryType, info);
        }

        /* Update counts. */
        info.count++;
        totalCount++;
        if (currentEntryHeader.getProvisional() == Provisional.YES) {
            info.provisionalCount++;
        }
        int size = itemSize + headerSize;
        info.totalBytes += size;
        info.headerBytes += headerSize;
        totalLogBytes += size;

        if ((info.minBytes==0) || (info.minBytes > size)) {
            info.minBytes = size;
        }
        if (info.maxBytes < size) {
            info.maxBytes = size;
        }

        if (verbose) {
            if (firstLsnRead == DbLsn.NULL_LSN) {
                firstLsnRead = getLastLsn();
            }

            if (currentType == LogEntryType.LOG_CKPT_END.getTypeNum()) {
                /* Start counting a new interval. */
                ckptCounter.endCkptLsn = getLastLsn();
                ckptCounter = new CheckpointCounter();
                ckptList.add(ckptCounter);
            } else {
                ckptCounter.increment(this, currentType);
            }
        }

        if (lastEntryType == LogEntryType.LOG_LN_TRANSACTIONAL ||
            lastEntryType == LogEntryType.LOG_LN) {
            /* Read the entry into the ByteBuffer. */
            LNLogEntry entry = (LNLogEntry) lastEntryType.getSharedLogEntry();
            entry.readEntry(currentEntryHeader,
                            entryBuffer, true /*readFullItem*/);
            int keyLen = entry.getKey().length;
            realTotalKeyBytes += keyLen;
            if (!entry.isDeleted()) {
                int dataLen = entry.getLN().getData().length;
                realTotalDataBytes += dataLen;
            }
        }

        entryBuffer.position(nextEntryPosition);
        return true;
    }

    @Override
    public void summarize(boolean csvFormat) {
        if (csvFormat) {
            summarizeCSV();
        } else {
            summarizeText();
        }
    }

    class CheckpointInfoTextFormatter {
        private NumberFormat form;

        CheckpointInfoTextFormatter() {
        }

        CheckpointInfoTextFormatter(NumberFormat form) {
            this.form = form;
        }

        String format(String value) {
            return pad(value);
        }

        String format(int value) {
            return pad(form.format(value));
        }

        String format(long value) {
            return pad(form.format(value));
        }
    }

    class CheckpointInfoCSVFormatter
        extends CheckpointInfoTextFormatter {

        CheckpointInfoCSVFormatter() {
        }

        @Override
        String format(String value) {
            return value + ",";
        }

        @Override
        String format(int value) {
            return value + ",";
        }

        @Override
        String format(long value) {
            return value + ",";
        }
    }

    private void summarizeCSV() {
        Iterator<Map.Entry<LogEntryType,EntryInfo>> iter =
            entryInfoMap.entrySet().iterator();

        NumberFormat form = NumberFormat.getIntegerInstance();
        NumberFormat percentForm = NumberFormat.getInstance();
        percentForm.setMaximumFractionDigits(1);
        System.out.println
            ("type,total count,provisional count,total bytes," +
             "min bytes,max bytes,avg bytes,entries as % of log");

        while (iter.hasNext()) {
            Map.Entry<LogEntryType, EntryInfo> m = iter.next();
            EntryInfo info = m.getValue();
            StringBuilder sb = new StringBuilder();
            LogEntryType entryType = m.getKey();
            sb.append(entryType.toString()).append(',');
            sb.append(info.count).append(',');
            sb.append(info.provisionalCount).append(',');
            sb.append(info.totalBytes).append(',');
            sb.append(info.minBytes).append(',');
            sb.append(info.maxBytes).append(',');
            sb.append((info.totalBytes / info.count)).append(',');
            double entryPercent =
                ((double) (info.totalBytes * 100) / totalLogBytes);
            sb.append(entryPercent);
            System.out.println(sb.toString());
        }

        /* Print special line for key/data */
        StringBuilder sb = new StringBuilder();
        sb.append("key bytes,");
        sb.append(",");
        sb.append(",");
        sb.append(realTotalKeyBytes).append(',');
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(((double) (realTotalKeyBytes * 100) /
                   totalLogBytes));
        System.out.println(sb.toString());

        sb = new StringBuilder();
        sb.append("data bytes,");
        sb.append(",");
        sb.append(",");
        sb.append(realTotalDataBytes).append(',');
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append((double) (realTotalDataBytes * 100) /
                      totalLogBytes);
        System.out.println(sb.toString());

        System.out.println("\nTotal bytes in portion of log read: " +
                           form.format(totalLogBytes));
        System.out.println("Total number of entries: " +
                           form.format(totalCount));

        if (verbose) {
            summarizeCheckpointInfo(new CheckpointInfoCSVFormatter());
        }
    }

    private void summarizeText() {
        System.out.println("Log statistics:");
        Iterator<Map.Entry<LogEntryType,EntryInfo>> iter =
            entryInfoMap.entrySet().iterator();

        NumberFormat form = NumberFormat.getIntegerInstance();
        NumberFormat percentForm = NumberFormat.getInstance();
        percentForm.setMaximumFractionDigits(1);
        System.out.println(pad("type") +
                           pad("total") +
                           pad("provisional") +
                           pad("total") +
                           pad("min") +
                           pad("max") +
                           pad("avg") +
                           pad("entries"));

        System.out.println(pad("") +
                           pad("count") +
                           pad("count") +
                           pad("bytes") +
                           pad("bytes") +
                           pad("bytes") +
                           pad("bytes") +
                           pad("as % of log"));

        while (iter.hasNext()) {
            Map.Entry<LogEntryType, EntryInfo> m = iter.next();
            EntryInfo info = m.getValue();
            StringBuilder sb = new StringBuilder();
            LogEntryType entryType = m.getKey();
            sb.append(pad(entryType.toString()));
            sb.append(pad(form.format(info.count)));
            sb.append(pad(form.format(info.provisionalCount)));
            sb.append(pad(form.format(info.totalBytes)));
            sb.append(pad(form.format(info.minBytes)));
            sb.append(pad(form.format(info.maxBytes)));
            sb.append(pad(form.format((info.totalBytes / info.count))));
            double entryPercent =
                ((double) (info.totalBytes * 100) / totalLogBytes);
            sb.append(pad(percentForm.format(entryPercent)));
            System.out.println(sb.toString());
        }

        /* Print special line for key/data */
        StringBuilder sb = new StringBuilder();
        sb.append(pad("key bytes"));
        sb.append(pad(""));
        sb.append(pad(""));
        sb.append(pad(form.format(realTotalKeyBytes)));
        sb.append(pad(""));
        sb.append(pad(""));
        sb.append(pad(""));
        String realSize = "(" +
            percentForm.format((double) (realTotalKeyBytes * 100) /
                               totalLogBytes) +
            ")";
        sb.append(pad(realSize));
        System.out.println(sb.toString());

        sb = new StringBuilder();
        sb.append(pad("data bytes"));
        sb.append(pad(""));
        sb.append(pad(""));
        sb.append(pad(form.format(realTotalDataBytes)));
        sb.append(pad(""));
        sb.append(pad(""));
        sb.append(pad(""));
        realSize = "(" +
            percentForm.format((double) (realTotalDataBytes * 100) /
                               totalLogBytes) +
            ")";
        sb.append(pad(realSize));
        System.out.println(sb.toString());

        System.out.println("\nTotal bytes in portion of log read: " +
                           form.format(totalLogBytes));
        System.out.println("Total number of entries: " +
                           form.format(totalCount));

        if (verbose) {
            summarizeCheckpointInfo(new CheckpointInfoTextFormatter(form));
        }
    }

    private String pad(String result) {
        int spaces = 20 - result.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
        sb.append(result);
        return sb.toString();
    }

    private void summarizeCheckpointInfo(CheckpointInfoTextFormatter f) {
        System.out.println("\nPer checkpoint interval info:");

        /*
         * Print out checkpoint interval info.
         * If the log looks like this:
         *
         * start of log
         * ckpt1 start
         * ckpt1 end
         * ckpt2 start
         * ckpt2 end
         * end of log
         *
         * There are 3 ckpt intervals
         * start of log->ckpt1 end
         * ckpt1 end -> ckpt2 end
         * ckpt2 end -> end of log
         */
        System.out.println
            (f.format("lnTxn") +
             f.format("ln") +
             f.format("mapLNTxn") +
             f.format("mapLN") +
             f.format("end to end") +  // ckpt n-1 end -> ckpt n end
             f.format("end to start") +// ckpt n-1 end -> ckpt n start
             f.format("start to end") +// ckpt n start -> ckpt n end
             f.format("maxLNReplay") +
             f.format("ckptEnd"));

        long logFileMax =
            envImpl.getConfigManager().getLong(EnvironmentParams.LOG_FILE_MAX);

        Iterator<CheckpointCounter> iter = ckptList.iterator();
        CheckpointCounter prevCounter = null;
        while (iter.hasNext()) {
            CheckpointCounter c = iter.next();
            StringBuilder sb = new StringBuilder();

            /* Entry type counts. */
            int maxTxnLNs = c.preStartLNTxnCount + c.postStartLNTxnCount;
            sb.append(f.format(maxTxnLNs));
            int maxLNs = c.preStartLNCount + c.postStartLNCount;
            sb.append(f.format(maxLNs));
            sb.append(f.format(c.preStartMapLNTxnCount +
                               c.postStartMapLNTxnCount));
            sb.append(f.format(c.preStartMapLNCount +
                               c.postStartMapLNCount));

            /* Checkpoint interval distance. */
            long end = (c.endCkptLsn == DbLsn.NULL_LSN) ?
                getLastLsn() :
                c.endCkptLsn;
            long endToEndDistance = 0;

            FileManager fileMgr = envImpl.getFileManager();
            if (prevCounter == null) {
                endToEndDistance =
                    DbLsn.getWithCleaningDistance(end,
                                                  fileMgr,
                                                  firstLsnRead,
                                                  logFileMax);
            } else {
                endToEndDistance =
                    DbLsn.getWithCleaningDistance(end,
                                                  fileMgr,
                                                  prevCounter.endCkptLsn,
                                                  logFileMax);
            }
            sb.append(f.format(endToEndDistance));

            /*
             * Interval between last checkpoint end and this checkpoint start.
             */
            long start = (c.startCkptLsn == DbLsn.NULL_LSN) ? getLastLsn() :
                c.startCkptLsn;
            long endToStartDistance = 0;

            if (prevCounter == null) {
                endToStartDistance =
                    DbLsn.getWithCleaningDistance(start,
                                                  fileMgr,
                                                  firstLsnRead,
                                                  logFileMax);
            } else {
                endToStartDistance =
                    DbLsn.getWithCleaningDistance(start,
                                                  fileMgr,
                                                  prevCounter.endCkptLsn,
                                                  logFileMax);
            }
            sb.append(f.format(endToStartDistance));

            /*
             * Interval between ckpt start and ckpt end.
             */
            long startToEndDistance = 0;
            if ((c.startCkptLsn != DbLsn.NULL_LSN)  &&
                (c.endCkptLsn != DbLsn.NULL_LSN)) {
                startToEndDistance =
                    DbLsn.getWithCleaningDistance(c.endCkptLsn,
                                                  fileMgr,
                                                  c.startCkptLsn,
                                                  logFileMax);
            }
            sb.append(f.format(startToEndDistance));

            /*
             * The maximum number of LNs to replay includes the portion of LNs
             * from checkpoint start to checkpoint end of the previous
             * interval.
             */
            int maxReplay = maxLNs + maxTxnLNs;
            if (prevCounter != null) {
                maxReplay += prevCounter.postStartLNTxnCount;
                maxReplay += prevCounter.postStartLNCount;
            }
            sb.append(f.format(maxReplay));

            if (c.endCkptLsn == DbLsn.NULL_LSN) {
                sb.append("   ").append(DbLsn.getNoFormatString(getLastLsn()));
            } else {
                sb.append("   ").append(DbLsn.getNoFormatString(c.endCkptLsn));
            }

            System.out.println(sb.toString());
            prevCounter = c;
        }
    }

    static class EntryInfo {
        public int count;
        public int provisionalCount;
        public long totalBytes;
        public int headerBytes;
        public int minBytes;
        public int maxBytes;

        EntryInfo() {
            count = 0;
            provisionalCount = 0;
            totalBytes = 0;
            headerBytes = 0;
            minBytes = 0;
            maxBytes = 0;
        }
    }

    static class LogEntryTypeComparator implements Comparator<LogEntryType> {
        public int compare(LogEntryType o1, LogEntryType o2) {
            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return 1;
            }

            Byte t1 = Byte.valueOf(o1.getTypeNum());
            Byte t2 = Byte.valueOf(o2.getTypeNum());
            return t1.compareTo(t2);
        }
    }

    /*
     * Accumulate the count of items from checkpoint end->checkpoint end.
     */
    static class CheckpointCounter {
        public long startCkptLsn = DbLsn.NULL_LSN;
        public long endCkptLsn = DbLsn.NULL_LSN;
        public int preStartLNTxnCount;
        public int preStartLNCount;
        public int preStartMapLNTxnCount;
        public int preStartMapLNCount;
        public int postStartLNTxnCount;
        public int postStartLNCount;
        public int postStartMapLNTxnCount;
        public int postStartMapLNCount;

        public void increment(FileReader reader,  byte currentEntryTypeNum) {
            if (currentEntryTypeNum ==
                LogEntryType.LOG_CKPT_START.getTypeNum()) {
                startCkptLsn = reader.getLastLsn();
            } else if (currentEntryTypeNum ==
                       LogEntryType.LOG_LN_TRANSACTIONAL.getTypeNum()) {
                if (startCkptLsn == DbLsn.NULL_LSN) {
                    preStartLNTxnCount++;
                } else {
                    postStartLNTxnCount++;
                }
            } else if (currentEntryTypeNum ==
                       LogEntryType.LOG_LN.getTypeNum()) {
                if (startCkptLsn == DbLsn.NULL_LSN) {
                    preStartLNCount++;
                } else {
                    postStartLNCount++;
                }
            } else if (currentEntryTypeNum ==
                       LogEntryType.LOG_MAPLN.getTypeNum()) {
                if (startCkptLsn == DbLsn.NULL_LSN) {
                    preStartMapLNCount++;
                } else {
                    postStartMapLNCount++;
                }
            } else if (currentEntryTypeNum ==
                       LogEntryType.LOG_MAPLN_TRANSACTIONAL.getTypeNum()) {
                if (startCkptLsn == DbLsn.NULL_LSN) {
                    preStartMapLNTxnCount++;
                } else {
                    postStartMapLNTxnCount++;
                }
            }
        }
    }
}
