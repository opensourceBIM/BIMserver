/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util.ldiff;

import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.HashSet;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.WholeEntry;
import com.sleepycat.je.rep.util.ldiff.Protocol.RemoteDiffRequest;
import com.sleepycat.je.rep.utilint.BinaryProtocol.Message;
import com.sleepycat.je.rep.utilint.BinaryProtocol.ProtocolException;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.utilint.VLSN;

/*
 * Class used for figuring out the difference on local and remote databases, 
 * also getting the VLSN number for different records.
 *
 * This class only needs to traverse the local and remote databases once and
 * do the check, this is because the different areas are sequential on the 
 * database. 
 *
 * It uses a hash set to save the records on the local different area, and
 * another hash set to save the records on the remote different area. Then
 * traverse the records in local set to see whether it exists in the remote
 * set, and do the same thing on records in remote set.
 */
public class DiffRecordAnalyzer {
    public static final long DATABASE_END = -1;

    /* The analysis method used by network LDiff. */
    public static void doAnalysis(Database localDb,
                                  Protocol protocol,
                                  SocketChannel channel,
                                  DiffTracker tracker,
                                  boolean doPrint) 
        throws Exception {

        List<MismatchedRegion> regions = tracker.getDiffRegions();
        Cursor localCursor = null;
        try {
            localCursor = localDb.openCursor(null, null);

            for (MismatchedRegion region : regions) {
                if (region.isLocalAdditional()) {
                    printLocalAdditional(localCursor, region, doPrint);
                    continue;
                }

                if (region.isRemoteAdditional()) {
                     HashSet<Record> records = 
                         getDiffArea(protocol, channel, region);
                     if (doPrint) {
                         printAdditional(records, true);
                     }
                     records.clear();
                     continue;
                }

                HashSet<Record> localRecords = 
                    getDiffArea(localCursor, region.getLocalBeginKey(), 
                                region.getLocalBeginData(), 
                                region.getLocalDiffSize());
                HashSet<Record> remoteRecords = 
                    getDiffArea(protocol, channel, region);
                if (doPrint) {
                printDiffs(localRecords, remoteRecords);
            }
                localRecords.clear();
                remoteRecords.clear();
            }
        } finally {
            if (localCursor != null) {
                localCursor.close();
            }
        }
    }
    
    /* The analysis method used by two local databases. */
    public static void doAnalysis(Database localDb, 
                                  Database remoteDb, 
                                  DiffTracker tracker,
                                  boolean doPrint) 
        throws Exception {

        List<MismatchedRegion> regions = tracker.getDiffRegions();
        Cursor localCursor = null;
        Cursor remoteCursor = null;
        try {
            localCursor = localDb.openCursor(null, null);
            remoteCursor = remoteDb.openCursor(null, null);

            for (MismatchedRegion region : regions) {
                if (region.isLocalAdditional()) {
                    printLocalAdditional(localCursor, region, doPrint);
                    continue;
                }
             
                if (region.isRemoteAdditional()) {
                    HashSet<Record> records = 
                        getDiffArea(remoteCursor, region.getRemoteBeginKey(),
                                    region.getRemoteBeginData(),
                                    region.getRemoteDiffSize());
                    if (doPrint) {
                        printAdditional(records, true);
                    }
                    records.clear();
                    continue;
                }

                HashSet<Record> localRecords =
                    getDiffArea(localCursor, region.getLocalBeginKey(),
                                region.getLocalBeginData(), 
                                region.getLocalDiffSize());
                HashSet<Record> remoteRecords =
                    getDiffArea(remoteCursor, region.getRemoteBeginKey(), 
                                region.getRemoteBeginData(),
                                region.getRemoteDiffSize());
                if (doPrint) {
                printDiffs(localRecords, remoteRecords);
            }
                localRecords.clear();
                remoteRecords.clear();
            }
        } finally {
            if (localCursor != null) {
                localCursor.close();
            }
            if (remoteCursor != null) {
                remoteCursor.close();
            }
        }
    }

    /* Print local additional records. */
    private static void printLocalAdditional(Cursor cursor,
                                             MismatchedRegion region,
                                             boolean doPrint) 
        throws Exception {

        HashSet<Record> records = getDiffArea(cursor, 
                                              region.getLocalBeginKey(), 
                                    region.getLocalBeginData(),
                                              region.getLocalDiffSize());
        if (doPrint) {
            printAdditional(records, false);
    }
        records.clear();
    }

    private static void printAdditional(HashSet<Record> diffRecords, 
                                        boolean remote) {
        String side = remote ? "Remote" : "Local";
        System.err.println("************************************************");
        System.err.println(side + " database has additional records, the " + 
                           "additional range as following:");
        side = remote ? "remote" : "local";
        for (Record record : diffRecords) {
            printRecord(record, side, false);
        }
        System.err.println("************************************************");
    }

    /* 
     * Print out the VLSN (if this record has) and the key's context of this 
     * record. 
     */
    private static void printRecord(Record record,
                                    String side,
                                    boolean different) {
        System.err.print("Record with Key: [");
        byte[] keys = record.getKey();
        for (int i = 0; i < keys.length; i++) {
            System.err.print(keys[i]);
            if (i < (keys.length - 1)) {
                System.err.print(" ");
            }
        }
        System.err.print("]");
        if (record.getVLSN().getSequence() != -1) {
            System.err.print(", VLSN: " + record.getVLSN());
        }
        if (different) {
            System.err.print(" does not exist on " + side + " database");
        }
        System.err.println();
    }

    /* Return a different area on local database in a hash set. */
    private static HashSet<Record> getDiffArea(Cursor cursor,
                                               byte[] beginKey,
                                               byte[] beginData,
                                               long diffSize) 
        throws Exception {

        HashSet<Record> records = new HashSet<Record>();
        LogManager logManager = DbInternal.getEnvironmentImpl
            (cursor.getDatabase().getEnvironment()).getLogManager();

        DatabaseEntry key = new DatabaseEntry(beginKey);
        DatabaseEntry data = new DatabaseEntry(beginData);
        boolean scanToEnd = (diffSize == DATABASE_END ? true : false);
        long count = 1;

        for (OperationStatus status = 
             cursor.getSearchBoth(key, data, LockMode.DEFAULT); 
             status == OperationStatus.SUCCESS;
             status = cursor.getNext(key, data, LockMode.DEFAULT)) {

            if (!scanToEnd && count > diffSize) {
                break;
            }
            records.add(new Record(key.getData(), data.getData(),
                                   getVLSN(cursor, logManager)));
            count++;
        }

        return records;
    }

    /* Used by LDiffService. */
    public static HashSet<Record> getDiffArea(Cursor cursor, 
                                              RemoteDiffRequest request) 
        throws Exception {

        return getDiffArea(cursor, request.getKey(), 
                           request.getData(), request.getDiffSize());
    }

    /* Get the records of a different area on remote database in a HashSet. */
    private static HashSet<Record> getDiffArea(Protocol protocol,
                                               SocketChannel channel,
                                               MismatchedRegion region) 
        throws Exception {

        protocol.write(protocol.new RemoteDiffRequest(region), channel);

        /* Check whether getting records on remote database is successful. */
        Message message = protocol.read(channel);
        if (message.getOp() == Protocol.ERROR) {
            throw new LDiffRecordRequestException
                (((Protocol.Error) message).getErrorMessage());
        }
        
        if (message.getOp() != Protocol.DIFF_AREA_START) {
            throw new ProtocolException
                (message, Protocol.DiffAreaStart.class);
        }

        /* Add those different records until protocol sees an end signal. */
        HashSet<Record> records = new HashSet<Record>();
        while (true) {
            try {
                Protocol.RemoteRecord record = 
                    protocol.read(channel, Protocol.RemoteRecord.class);
                records.add(new Record(record.getKey(),
                                       record.getData(),
                                       record.getVLSN()));
            } catch (ProtocolException pe) {
                if (pe.getUnexpectedMessage().getOp() != 
                    Protocol.DIFF_AREA_END) {
                    throw pe;
                }
                break;
            }
        }

        return records;
    }

    /* Compare the differences between two sets. */
    private static void printDiffs(HashSet<Record> localDiffs,
                                     HashSet<Record> remoteDiffs) {
        System.err.println("************************************************");
        System.err.println("Different records between local and remote database " +
                           "in a specific different area.");
        for (Record record : localDiffs) {
            if (!remoteDiffs.contains(record)) {
                printRecord(record, "remote", true);
            }
        }

        for (Record record : remoteDiffs) {
            if (!localDiffs.contains(record)) {
                printRecord(record, "local", true);
            }
        }
        System.err.println("************************************************");
    }

    /* 
     * Get the LSN that the cursor currently points to, there are two cases 
     * that a record doesn't have a VLSN:
     * 1. compare between two local databases.
     * 2. compare between two converted environments.
     *
     * In the above two cases, we actually return NULL_VLSN instead of null, so
     * that the message doesn't complain about a null value. 
     */
    private static VLSN getVLSN(Cursor cursor, LogManager logManager) 
        throws Exception {

        CursorImpl cursorImpl = DbInternal.getCursorImpl(cursor);
        BIN bin = cursorImpl.getBIN();
        int index = cursorImpl.getIndex();
        DBIN dbin = cursorImpl.getDupBIN();
        int dupIndex = cursorImpl.getDupIndex();

        final long lsn = 
            (dbin != null) ? dbin.getLsn(dupIndex) : bin.getLsn(index);

        WholeEntry entry = logManager.getLogEntryAllowInvisible(lsn);

        VLSN vlsn = entry.getHeader().getVLSN();
        if (vlsn == null) {
            vlsn = VLSN.NULL_VLSN;
        }

        return vlsn;
    }
}
