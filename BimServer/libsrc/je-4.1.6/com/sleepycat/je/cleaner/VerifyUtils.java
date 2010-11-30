/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2006-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.cleaner;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.SortedLSNTreeWalker;
import com.sleepycat.je.dbi.SortedLSNTreeWalker.TreeNodeProcessor;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.UtilizationFileReader;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.utilint.DbLsn;

/**
 * Verify cleaner data structures
 */
public class VerifyUtils {

    private static final boolean DEBUG = false;

    /**
     * Compare the LSNs referenced by a given Database to the lsns held
     * in the utilization profile. Assumes that the database and
     * environment is quiescent, and that there is no current cleaner
     * activity.
     */
    public static void checkLsns(Database db)
        throws DatabaseException {

        checkLsns(DbInternal.getDatabaseImpl(db), System.out);
    }

    /**
     * Compare the lsns referenced by a given Database to the lsns held
     * in the utilization profile. Assumes that the database and
     * environment is quiescent, and that there is no current cleaner
     * activity.
     */
    public static void checkLsns(DatabaseImpl dbImpl,
                                 PrintStream out)
        throws DatabaseException {

        /* Get all the LSNs in the database. */
        GatherLSNs gatherLsns = new GatherLSNs();
        long rootLsn = dbImpl.getTree().getRootLsn();
        List<DatabaseException> savedExceptions =
            new ArrayList<DatabaseException>();

        SortedLSNTreeWalker walker =
            new SortedLSNTreeWalker(dbImpl,
                                    false, // don't set db state
                                    rootLsn,
                                    gatherLsns,
                                    savedExceptions,
                                    null);
        walker.walk();

        /* Print out any exceptions seen during the walk. */
        if (savedExceptions.size() > 0) {
            out.println(savedExceptions.size() +
                        " problems seen during tree walk for checkLsns");
            Iterator<DatabaseException> iter = savedExceptions.iterator();
            while (iter.hasNext()) {
                out.println("  " + iter.next());
            }
        }

        Set<Long> lsnsInTree = gatherLsns.getLsns();
        if (rootLsn != DbLsn.NULL_LSN) {
            lsnsInTree.add(rootLsn);
        }

        /* Get all the files used by this database. */
        Iterator<Long> iter = lsnsInTree.iterator();
        Set<Long> fileNums = new HashSet<Long>();

        while (iter.hasNext()) {
            long lsn = iter.next();
            fileNums.add(DbLsn.getFileNumber(lsn));
        }

        /* Gather up the obsolete lsns in these file summary lns */
        iter = fileNums.iterator();
        Set<Long> obsoleteLsns = new HashSet<Long>();
        EnvironmentImpl envImpl = dbImpl.getDbEnvironment();
        UtilizationProfile profile = envImpl.getUtilizationProfile();

        while (iter.hasNext()) {
            Long fileNum = iter.next();

            PackedOffsets obsoleteOffsets = new PackedOffsets();
            @SuppressWarnings("unused")
            TrackedFileSummary tfs =
                profile.getObsoleteDetail(fileNum,
                                          obsoleteOffsets,
                                          false /* logUpdate */);
            PackedOffsets.Iterator obsoleteIter = obsoleteOffsets.iterator();
            while (obsoleteIter.hasNext()) {
                long offset = obsoleteIter.next();
                Long oneLsn = Long.valueOf(DbLsn.makeLsn(fileNum.longValue(),
                                                         offset));
                obsoleteLsns.add(oneLsn);
                if (DEBUG) {
                    out.println("Adding 0x" +
                                Long.toHexString(oneLsn.longValue()));
                }
            }
        }

        /* Check than none the lsns in the tree is in the UP. */
        boolean error = false;
        iter = lsnsInTree.iterator();
        while (iter.hasNext()) {
            Long lsn = iter.next();
            if (obsoleteLsns.contains(lsn)) {
                out.println("Obsolete LSN set contains valid LSN " +
                            DbLsn.getNoFormatString(lsn.longValue()));
                error = true;
            }
        }

        /*
         * Check that none of the lsns in the file summary ln is in the
         * tree.
         */
        iter = obsoleteLsns.iterator();
        while (iter.hasNext()) {
            Long lsn = iter.next();
            if (lsnsInTree.contains(lsn)) {
                out.println("Tree contains obsolete LSN " +
                            DbLsn.getNoFormatString(lsn.longValue()));
                error = true;
            }
        }

        if (error) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_INTEGRITY,
                 "Lsn mismatch");
        }

        if (savedExceptions.size() > 0) {
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.LOG_INTEGRITY,
                 "Sorted LSN Walk problem");
        }
    }

    private static class GatherLSNs implements TreeNodeProcessor {
        private final Set<Long> lsns = new HashSet<Long>();

        public void processLSN(long childLSN,
                               LogEntryType childType,
                               Node ignore,
                               byte[] ignore2) {
            lsns.add(childLSN);
        }

        /* ignore */
        public void processDirtyDeletedLN(long childLsn, LN ln, byte[] lnKey) {
        }

        /* ignore */
        public void processDupCount(int ignore) {
        }

        public Set<Long> getLsns() {
            return lsns;
        }
    }

    /**
     * Compare utilization as calculated by UtilizationProfile to utilization
     * as calculated by UtilizationFileReader.  Also check that per-database
     * and per-file utilization match.
     *
     * @throws EnvironmentFailureException if there are mismatches
     */
    public static void verifyUtilization(EnvironmentImpl envImpl,
                                         boolean expectAccurateObsoleteLNCount,
                                         boolean expectAccurateObsoleteLNSize,
                                         boolean expectAccurateDbUtilization)
        throws DatabaseException {

        Map<Long,FileSummary> profileMap = envImpl.getCleaner()
            .getUtilizationProfile()
            .getFileSummaryMap(true);

        /* Flush the log before reading. */
        envImpl.getLogManager().flushNoSync();

        /* Create per-file map of recalculated utilization info. */
        Map<Long,FileSummary> recalcMap =
            UtilizationFileReader.calcFileSummaryMap(envImpl);
        /* Create per-file map derived from per-database utilization. */
        Map<Long,DbFileSummary> dbDerivedMap = null;
        if (expectAccurateDbUtilization) {
            dbDerivedMap = calcDbDerivedUtilization(envImpl);
        }

        /*
         * Loop through each file in the per-file profile, checking it against
         * the recalculated map and database derived maps.
         */
        Iterator<Map.Entry<Long,FileSummary>> i =
            profileMap.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<Long,FileSummary> entry = i.next();
            Long file = entry.getKey();
            String fileStr = file.toString();
            FileSummary profileSummary = entry.getValue();
            FileSummary recalcSummary = recalcMap.remove(file);
            check(fileStr, recalcSummary != null);
            /*
            if (expectAccurateObsoleteLNCount &&
                profileSummary.obsoleteLNCount !=
                recalcSummary.obsoleteLNCount) {
                System.out.println("file=" + file);
                System.out.println("profile=" + profileSummary);
                System.out.println("recalc=" + recalcSummary);
            }
            //*/
            check(fileStr,
                  recalcSummary.totalCount == profileSummary.totalCount);
            check(fileStr,
                  recalcSummary.totalSize == profileSummary.totalSize);
            check(fileStr,
                  recalcSummary.totalINCount == profileSummary.totalINCount);
            check(fileStr,
                  recalcSummary.totalINSize == profileSummary.totalINSize);
            check(fileStr,
                  recalcSummary.totalLNCount == profileSummary.totalLNCount);
            check(fileStr,
                  recalcSummary.totalLNSize == profileSummary.totalLNSize);

            /*
             * Currently we cannot verify obsolete INs because
             * UtilizationFileReader does not count them accurately.
             */
            if (false) {
                check(fileStr,
                      recalcSummary.obsoleteINCount ==
                      profileSummary.obsoleteINCount);
            }

            /*
             * The obsolete LN count/size is inaccurate when a deleted LN is
             * not counted properly by recovery because its parent INs were
             * flushed and the obsolete LN was not found in the tree.
             */
            if (expectAccurateObsoleteLNCount) {
                check(fileStr,
                      recalcSummary.obsoleteLNCount ==
                      profileSummary.obsoleteLNCount);

                /*
                 * The obsoletely LN size is inaccurate when a tree walk is
                 * performed for truncate/remove or an abortLsn is counted by
                 * recovery
                 */
                if (expectAccurateObsoleteLNSize) {
                    check(fileStr,
                          recalcSummary.getObsoleteLNSize() ==
                          profileSummary.obsoleteLNSize);
                }
            }

            /*
             * The per-database and per-file info normally match.  It does not
             * match, and expectAccurateDbUtilization is false, when we have
             * truncated or removed a database, since that database information
             * is now gone.
             */
            if (expectAccurateDbUtilization) {
                DbFileSummary dbSummary =
                    dbDerivedMap.remove(file);
                if (dbSummary == null) {
                    dbSummary = new DbFileSummary();
                }
                check(fileStr,
                      profileSummary.totalINCount == dbSummary.totalINCount);
                check(fileStr,
                      profileSummary.totalLNCount == dbSummary.totalLNCount);
                check(fileStr,
                      profileSummary.totalINSize == dbSummary.totalINSize);
                check(fileStr,
                      profileSummary.totalLNSize == dbSummary.totalLNSize);
                check(fileStr,
                      profileSummary.obsoleteINCount ==
                      dbSummary.obsoleteINCount);
                if (expectAccurateObsoleteLNCount) {
                    check(fileStr,
                          profileSummary.obsoleteLNCount ==
                          dbSummary.obsoleteLNCount);
                    if (expectAccurateObsoleteLNSize) {
                        check(fileStr,
                              profileSummary.obsoleteLNSize ==
                              dbSummary.obsoleteLNSize);
                        check(fileStr,
                              profileSummary.obsoleteLNSizeCounted ==
                              dbSummary.obsoleteLNSizeCounted);
                    }
                }
            }
        }
        check(recalcMap.toString(), recalcMap.isEmpty());
        if (expectAccurateDbUtilization) {
            check(dbDerivedMap.toString(), dbDerivedMap.isEmpty());
        }
    }

    private static void check(String errorMessage, boolean checkIsTrue) {
        if (!checkIsTrue) {
            throw EnvironmentFailureException.unexpectedState(errorMessage);
        }
    }

    /**
     * Adds up the per-file totals from the utilization information for each
     * database to make a total per-file count.
     *
     * @return aggregation of per-file information.
     */
    private static Map<Long,DbFileSummary> calcDbDerivedUtilization
                                               (EnvironmentImpl envImpl)
        throws DatabaseException {

        final Map<Long,DbFileSummary> grandTotalsMap =
            new HashMap<Long,DbFileSummary>();

        DbTree dbTree = envImpl.getDbTree();

        /* Add in the special id and name database. */
        addDbDerivedTotals(dbTree.getDb(DbTree.ID_DB_ID), grandTotalsMap);
        addDbDerivedTotals(dbTree.getDb(DbTree.NAME_DB_ID), grandTotalsMap);

        /* Walk through all the regular databases. */
        CursorImpl.traverseDbWithCursor(dbTree.getDb(DbTree.ID_DB_ID),
                                        LockType.NONE,
                                        true /*allowEviction*/,
                                        new CursorImpl.WithCursor() {
            public boolean withCursor(CursorImpl cursor,
                                      DatabaseEntry key,
                                      DatabaseEntry data)
                throws DatabaseException {

                MapLN mapLN = (MapLN) cursor.getCurrentLN(LockType.NONE);
                addDbDerivedTotals(mapLN.getDatabase(), grandTotalsMap);
                return true;
            }
        });
        return grandTotalsMap;
    }

    /**
     * Walk through the DbFileSummaryMap associated with a single database and
     * aggregate all the per-file/per db information into a single per-file
     * grandTotals map.
     */
    private static void addDbDerivedTotals
        (DatabaseImpl dbImpl,
         Map<Long,DbFileSummary> grandTotalsMap) {
        Iterator<Map.Entry<Long,DbFileSummary>> entries =
            dbImpl.getDbFileSummaries().entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Long,DbFileSummary> entry = entries.next();
            Long fileNum = entry.getKey();
            DbFileSummary dbTotals = entry.getValue();
            DbFileSummary grandTotals = grandTotalsMap.get(fileNum);
            if (grandTotals == null) {
                grandTotals = new DbFileSummary();
                grandTotalsMap.put(fileNum, grandTotals);
            }
            grandTotals.add(dbTotals);
        }
    }

}
