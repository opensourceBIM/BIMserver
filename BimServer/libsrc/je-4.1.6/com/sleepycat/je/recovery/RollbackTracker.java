/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.recovery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.cleaner.RecoveryUtilizationTracker;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.log.LNFileReader;
import com.sleepycat.je.tree.TreeLocation;
import com.sleepycat.je.txn.RollbackEnd;
import com.sleepycat.je.txn.RollbackStart;
import com.sleepycat.je.txn.TxnChain;
import com.sleepycat.je.txn.TxnManager;
import com.sleepycat.je.txn.UndoReader;
import com.sleepycat.je.txn.TxnChain.RevertInfo;
import com.sleepycat.je.utilint.DbLsn;

/**
 * RollbackTracker is used to detect rollback periods in the log that are the
 * result of HA replica syncups. These rollback periods affect how LNs should
 * be processed at recovery. Rollbacks differ from aborts in that a rollback
 * returns a LN to its previous version, whether intra or inter-txnal, while an
 * abort always returns an LN to its pre-txn version.
 * 
 * What is a Rollback Period?
 * --------------------------
 * The rollback represents the logical truncation of the log. Any transactional
 * LNs in that rollback period should be undone, even if they are ultimately
 * part of a committed transaction. See the wiki page on Syncup Recovery for
 * the full design. See com.sleepycat.je.rep.impl.node.Replay.rollback for the
 * steps taken at the time of the rollback.
 * 
 * A RollbackStart record is logged at the start of any rollback, and a
 * RollbackEnd is logged at the completion of a rollback. RollbackStarts refer
 * to a matchpoint and the area between the matchpoint and the RollbackStart is
 * the rollback period.The RollbackTracker peruses RollbackStarts and Ends and
 * generates a map of the rollback periods.
 *
 * RollbackStarts and their starting Matchpoints can be nested or can be
 * distinct, but several invariants are in place and can be enforced. For
 * example:
 *
 *  LSN
 *  ---
 *  100  txnA commit
 *  
 *  200  txnB abort
 *  250  LN for txnC
 *  300  txnC abort
 *  ..
 *  400  RollbackStart A (starting matchpoint = 200)
 *  500  RollbackEnd A
 *  ...
 *  600  RollbackStart B (starting matchpoint = 200)
 *  700  RollbackStart C (starting matchpoint = 100)
 *  800  RollbackEnd C
 *  900  txnD abort
 * 1000  RollbackStart D (starting matchpoint = 900)
 *
 * This log creates four rollback periods 
 *   1) LSN 100 -> 700 (defined by RollbackStart C). This has two rollback
 *      periods nested within.
 *   2) LSN 200 -> 400, (defined by RollbackStart A) nested within B
 *   3) LSN 200 -> 600, (defined by RollbackStart B) nested within C
 *   4) LSN 1000 -> 900 (defined by RolbackStart D)

 * - There can be no commits or aborts within a rollback period, because we
 * shouldn't have executed a soft recovery that undid a commit or abort.  in
 * the rollback period.
 *
 * - There can be no LN_TXs between a RollbackStart and its matching
 * RollbackEnd (should be no LN write operations happening during the syncup.)
 * However, there might be INs written by a checkpoint, and eviction.
 *
 * - The recovery period should never see a RollbackEnd without its matching
 * RollbackStart record, though it is possible to see a RollbackStart that has
 * no RollbackEnd.
 *
 *  - There can never be any overlapping, or intersection of periods, because a
 * rollback period is supposed to be like a truncation of the log. Since that
 * log is "gone", a subsequent rollback shouldn't find a matchpoint inside
 * another rollback period.
 *
 * - A child period must be wholly contained between the parent's matchpoint
 * and RollbackStart. This is simply due to the way rollbacks occur.  A parent
 * rollback has a Matchpoint <= the child's Matchpoint or it wouldn't be
 * nested.  The parent's RollbackStart > the child's RollbackEnd, since the
 * parent occurs after the child in time.
 *
 * The Rollback tracker keeps a list of all the rollback periods. Some are
 * distinct, some are nested. 
 *
 * Recovery processing and rollback periods
 * ----------------------------------------
 * The actions taken at a rollback may not have been made persistent to the
 * log, so at recovery, we literally mimic and replay these two steps: (a) make
 * sure invisible log entries have their invisible bit on and (b) make sure all
 * INs reflect the correct LNs. All use of the rollback periods and tracker
 * take place on the backwards scans. The RollbackStart and End entries are
 * read during the first recovery undo pass When a rollback period is found, a
 * transaction chain is constructed for each transaction that was active in the
 * period, to support a repeat of the actions taken originally.
 * 
 * The first undo pass, for the mapping tree, has to construct a map of
 * recovery periods. Since the mapping tree only has MapLNs, and we never write
 * any txnal MapLNs, that first pass does not encounter any txnal LNs.  The
 * next two undo passes consult the rollback period map to determine if an LN
 * needs to be rolledback, or just treated like other LNs.
 *
 * Rollback periods that precede the checkpoint start can be ignored, because
 * we can be assured that all the INs and LNs modified by that rollback were
 * made persistent by the checkpoint.  Ignoring such periods is required, and
 * is not just an optimization, because it guarantees that we will not need to
 * create a transaction chain that needs to traverse the log beyond the first
 * active lsn. A rollback period precedes the checkpoint if its RollbackEnd is
 * before the checkpoint start.
 *
 * When a rollback period overlaps CkptStart and we recover, we are guaranteed
 * that the undo passes will process all LNs in the rollback period, because
 * they are >= to the firstActiveLEnd of the checkpoint.
 *
 * The lastActiveLSN for the checkpoint will be <= the LSN of the first LN of
 * any transaction that is being rolled back at the time of CkptStart, since
 * these transactions were still active at that time.
 *
 * No file containing a transaction rolled back in the recovery interval, or a
 * file containing the abortLSN of such a transaction, will be deleted by the
 * cleaner. An active transaction prevents cleaning of its first logged entry
 * and beyond. The LN of the abortLSN will be locked, which prevents it from
 * being cleaned.
 *
 * All the work lies on the undo side. Recovery redo only needs to ignore
 * invisible log entries, because we know that the undo pass applied the
 * invisible bit where needed. Note that the undo pass must be sure to write 
 * the invisible bits after the pass, before redo attempts to read the log.
 *
 * Each rollback LN_TX belongs to a single rollback period. When periods are
 * nested, the LN_TX belongs to the closest rollback period that encompasses
 * it.  
 * Using the example above,
 *    a LN at lsn 350 belongs to rollback period A
 *    a LN at lsn 550 belongs to rollback period B
 *    a LN at lsn 650 belongs to rollback period C
 * It uses its rollback period's txn chain to find its previous version.
 */
public class RollbackTracker {

    private final EnvironmentImpl envImpl;
    private long checkpointStart;

    /* for assertions. */
    private boolean firstUndoPass; 

    /* 
     * List of lsns that were made invisible and need to be fsynced, from
     * this recovery. 
     *
     * singlePassLsns are collected for a single recovery pass. After that
     * pass, the lsns must be written to the log, so that the next redo
     * recovery pass properly skips over invisible lsns, but it need not
     * do a fsync. After each pass, the file numbers involved are added to 
     * recoveryFilesToSync.
     *
     * After recovery is finished, all file that have re-flipped invisible bits
     * are fsynced. Hopefully, the OS may have fsynced some, and waiting until
     * the end to fsync will be an optimization.
     */
    private final Set<Long> recoveryFilesToSync;
    private List<Long> singlePassInvisibleLsns;

    /* 
     * Used only for the first construction pass. This is the rollback 
     * period that we have just found.
     */
    private RollbackPeriod underConstructionPeriod;

    /* Top level list of rollback periods */
    private final List<RollbackPeriod> periodList;

    RollbackTracker(EnvironmentImpl envImpl) {
        this.envImpl = envImpl;
        periodList = new ArrayList<RollbackPeriod>();
        checkpointStart = DbLsn.NULL_LSN;
        recoveryFilesToSync = new HashSet<Long>();
        singlePassInvisibleLsns = new ArrayList<Long>();
    }

    /**
     * Construction Pass: A RollbackEnd is seen, make new period.
     */
    void register(RollbackEnd rollbackEnd, long rollbackEndLSN) {
        assertFirstPass(rollbackEndLSN);

        if ((underConstructionPeriod != null) &&
            (underConstructionPeriod.makeNestedPeriod(rollbackEnd,
                                                      rollbackEndLSN))) {
            return;
        }

        underConstructionPeriod = new RollbackPeriod(this,
                                                     rollbackEnd,
                                                     rollbackEndLSN);
        periodList.add(underConstructionPeriod);
    } 

    /**
     * Construction Pass: A RollbackStart is seen. Might be the matching
     * one for the current period, or it might be a new period.
     */
    void register(RollbackStart rollbackStart, long rollbackStartLSN) {
        assertFirstPass(rollbackStartLSN);

        /* There's no rollback period going on, start a new one. */
        if ((underConstructionPeriod != null) &&
            (underConstructionPeriod.makeNestedPeriod(rollbackStart, 
                                                      rollbackStartLSN))) {
            return;
        }
            
        underConstructionPeriod = new RollbackPeriod(this,
                                                     rollbackStart,
                                                     rollbackStartLSN);
        periodList.add(underConstructionPeriod);
    } 

    /**
     * A TxnCommit showed up on the construction pass. If it's a replicated
     * txn, check if it's in a valid place. It should not be within the
     * rollback period.
     *
     * Omit commits for internal, non-replicated transactions from this check.
     */
    void checkCommit(long commitLSN, long txnId) {
        assertFirstPass(commitLSN);

        if (!TxnManager.isReplicatedTxn(txnId)) {
            return;
        }
        
        if (underConstructionPeriod == null) {
            return;
        }

        if (underConstructionPeriod.contains(commitLSN)) {
            underConstructionPeriod.fail("Commit at " + 
                                         DbLsn.getNoFormatString(commitLSN) +
                                         " is within rollback period.");
        }
    }

    /* 
     * Set the checkpoint start before we begin marking rollback periods, so we
     * know that we can ignore periods that are before the checkpoint start.
     */
    void setCheckpointStart(long lsn) {
        checkpointStart = lsn;
    }

    long getCheckpointStart() {
        return checkpointStart;
    }

    EnvironmentImpl getEnvImpl() {
        return envImpl;
    }

    /* For unit tests */
    List<RollbackPeriod> getPeriodList() {
        return periodList;
    }

    void setFirstPass(boolean firstUndoPass) {
        this.firstUndoPass = firstUndoPass;
    }

    /** 
     * A Scanner is a cursor over the tracker's rollback periods.
     */
    Scanner getScanner() {
        if (firstUndoPass) {

            /* 
             * The RollbackTracker is being built, and we need a special
             * scanner that can use the rollback period map while it is in an
             * incomplete state. This is only needed for JE log versions that
             * use MapLN_TXNAL, which are 2.0 and earlier.
             */
            return new UnderConstructionScanner();
        }

        return new BackwardScanner();
    }

    /**
     * Flip the invisible bit for each lsn in rollbackLsns. Collect the 
     * corresponding unique set of file numbers and add them to fileNums.
     */
    private static void setInvisible(EnvironmentImpl envImpl,
                                     List<Long> rollbackLsns,
                                     Set<Long> filesToFsync) {
        if (rollbackLsns.size() == 0) {
            return;
        }

        /* 
         * Sort so that the entries are made invisible in disk order for better
         * efficiency.
         */
        FileManager fileManager = envImpl.getFileManager();

        Collections.sort(rollbackLsns);
        List<Long> perFileLsns = new ArrayList<Long>();
        long currentFileNum = -1;

        for (Long lsn : rollbackLsns) {

            /* See if we have moved to a new file. */
            if (DbLsn.getFileNumber(lsn) != currentFileNum) {
        	/* 
        	 * We've moved on to a new file. Make the previous set of
        	 * lsns invisible.
        	 */
        	fileManager.makeInvisible(currentFileNum, perFileLsns);

                currentFileNum = DbLsn.getFileNumber(lsn);
                filesToFsync.add(currentFileNum);

                /* make a new set to house the lsns for the next file. */
                perFileLsns = new ArrayList<Long>();
            }
            perFileLsns.add(lsn);
        }

        /* Take care of the last set. */
        if (perFileLsns != null) {
            fileManager.makeInvisible(currentFileNum, perFileLsns);
        }
    }

    /* 
     * Flip the invisible bit for the rollback set of lsns, in lsn order.
     * Fsync the set of files represented in this collection of lsns. Used by
     * syncup rollback.
     */
    public static void makeInvisible(EnvironmentImpl targetEnvImpl,
                                     List<Long> rollbackLsns) {

        Set<Long> fsyncFiles = new HashSet<Long>();
        setInvisible(targetEnvImpl, rollbackLsns, fsyncFiles);
        targetEnvImpl.getFileManager().force(fsyncFiles);
    }

    /**
     * At the end of a recovery pass, write out all invisible bits, save
     * a set of file numbers to fsync, and reinitialize the per-pass list
     * for the next round.
     */
    void singlePassSetInvisible() {
        if (envImpl.isReadOnly()) {
            return;
        }

        setInvisible(envImpl, 
                     singlePassInvisibleLsns, 
                     recoveryFilesToSync);
        singlePassInvisibleLsns = new ArrayList<Long>();
    }

    void recoveryEndFsyncInvisible() {
        if (envImpl.isReadOnly()) {
            return;
        }

        envImpl.getFileManager().force(recoveryFilesToSync);
    }

    /**
     * Count an LN obsolete that is being made invisble by rollback.
     *
     * Use inexact counting.  Since invisible entries are not processed by the
     * cleaner, recording the obsolete offset would be a waste of resources.
     * Since we don't count offsets, we don't need to worry about duplicate
     * offsets.
     *
     * Some entries may be double counted if they were previously counted
     * obsolete, for example, when multiple versions of an LN were logged.
     * This is tolerated for an exceptional situation like rollback.
     */
    private void countObsolete(long undoLsn,
                               UndoReader undo,
                               RecoveryUtilizationTracker tracker) {
        tracker.countObsoleteUnconditional
            (undoLsn,
             null /*type*/,
             undo.ln.getLastLoggedSize(),
             undo.db.getId(),
             false /*countExact*/);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (RollbackPeriod period : periodList) {
            sb.append(period).append("\n");
        }
        return sb.toString();
    }

    private void assertFirstPass(long logLSN) {
        if (!firstUndoPass) {
            throw new EnvironmentFailureException
                (envImpl,
                 EnvironmentFailureReason.UNEXPECTED_STATE,
                 "Saw entry at " + DbLsn.getNoFormatString(logLSN) +
                 "Should only be building the tracker on the first pass");
        }
    }

    /**
     * A Scanner is to process LNs during a recovery pass. It determines
     * whether this log entry is within the rollback period, and should be
     * accordingly undone or ignored. It serves as a sort of cursor or iterator
     * that works with the rollback tracker.
     */
    abstract class Scanner {

        /* 
         * The target period is the one which houses the LNs that will be
         * rolled back. 
         */
        RollbackPeriod target;

        /**
         * Return true if this transactional log entry is something that should
         * be rolled back in this rollback period. The Scanner's position can
         * be changed by this call. Update the target field if necessary.
         */
        abstract boolean positionAndCheck(long lsn, long txnId);

        /**
         * Rollback the filereader's current LN_TX. This assumes that the the
         * caller has ascertained that the LN is contained within this rollback
         * period.
         */
        public void rollback(Long txnId,
                             LNFileReader reader,
                             RecoveryUtilizationTracker tracker) {

            /* 
             * If this period is before the checkpoint start, we need not
             * repeat the partial rollback. 
             */
            if (target.beforeCheckpointStart()) {
                return;
            }

            long undoLsn = reader.getLastLsn();

            TreeLocation location = new TreeLocation();
        
            /* Get the TxnChain for this log entry. */
            TxnChain chain = target.getChain(txnId, undoLsn, envImpl);
            UndoReader undo = new UndoReader(reader, envImpl.getDbTree());

            try {
                RevertInfo revertTo = chain.pop();

                /*
                 * When we undo this log entry, we've logically truncated it
                 * from the log. Remove it from the btree and mark it obsolete.
                 */
                RecoveryManager.rollbackUndo(envImpl.getLogger(),
                                             Level.FINER,
                                             undo,
                                             revertTo,
                                             location,
                                             undoLsn);

                if (!target.hasRollbackEnd()) {

                    /* 
                     * We're not positive that the fsync of the invisible log
                     * entries happened. Make it invisible again.  
                     */
                    if (!reader.isInvisible()) {
                        singlePassInvisibleLsns.add(undoLsn);
                    }
                }
            } finally {
                undo.releaseDb();
            }

            countObsolete(undoLsn, undo, tracker);
        }

        /* For unit tests */
        boolean needsRollback() {
            if (target == null) {
                return false;
            }

            return !target.beforeCheckpointStart();
        }
    }

    class UnderConstructionScanner extends Scanner {

        public boolean positionAndCheck(long lsn, long txnId) {

            if (underConstructionPeriod == null) {
                return false;
            }

            assert underConstructionPeriod.notInRollbackStartAndEnd
                (lsn, txnId) :
               underConstructionPeriod.bracketFailure(lsn);

            target = underConstructionPeriod.getScannerTarget(lsn);
            if ((target != null) && (target.containsLN(lsn, txnId))) {
                return true;
            }

            return false;
        }
    }

    /**
     * In a backward scanner, the currentPeriod field is always pointing to the
     * period that contains this lsn. If the lsn is not in a period, the
     * currentPeriod is the period that is just before this lsn. If there is no
     * period before this lsn, the currentPeriod field is null.
     */
    class BackwardScanner extends Scanner {
        private final Iterator<RollbackPeriod> iter;

        /* 
         * The current period is the period where the scanner is currently
         * posed. It is one of the top level periods in the scanner.  When
         * rollback periods are nested, currentPeriod may not equal target.
         */
        private RollbackPeriod currentPeriod;

        BackwardScanner() {
            this.iter = periodList.iterator();
            if (iter.hasNext()) {
                currentPeriod = iter.next();
                currentPeriod.initChildIter();
            } else {
                currentPeriod = null;
            }
        }

        public boolean positionAndCheck(long lsn, long txnId) {
            if (currentPeriod == null) {
                return false;
            }

            if (currentPeriod.follows(lsn)) {

                /* 
                 * We've passed out of the currentPeriod. Look for a new one
                 * that might cover this lsn.
                 */
                if (iter.hasNext()) {
                    currentPeriod = iter.next();
                    currentPeriod.initChildIter();
                } else {
                    currentPeriod = null;
                    return false;
                }
            }

            assert currentPeriod.notInRollbackStartAndEnd(lsn, txnId) :
               currentPeriod.bracketFailure(lsn);

            if (currentPeriod.contains(lsn)) {

                /* 
                 * Make the stack of periods point to the one that contains
                 * this lsn, or which precedes this lsn.
                 */
                currentPeriod.positionChildren(lsn);

                /* 
                 * See if any period contains this lsn. There might not be a
                 * target if the lsn was aborted or committed already at the
                 * time of rollback.
                 */
                target = currentPeriod.findTarget(lsn, txnId);
                return (target != null);
            } 

            return false;
        }
    }
 
    /**
     * A RollbackPeriod describes a section of the log that is logically
     * truncated.
     */
    static class RollbackPeriod {
        private final RollbackTracker tracker;
        private final long matchpointLSN;    // start of period
        private final long rollbackStartLSN; // end of period
        private final long rollbackEndLSN;   // for debugging and sanity checks

        /* 
         * lsn of the checkpoint start, to  determine if this rollback period
         * needs to be used.
         */
        private final boolean beforeCheckpointStart;

        /* 
         * The transactions that were rolled back for this rollback period,
         * which were logged in the RollbackStart entry.
         */
        private Set<Long> activeTxnIds;

        /*
         * The txn chain constructed to support rollback to an earlier version.
         */
        private final Map<Long, TxnChain> txnChainMap;

        /* Nested rollbacks. */
        private final List<RollbackPeriod> children;
        private RollbackPeriod currentChild = null;
        private Iterator<RollbackPeriod> childIter;

        RollbackPeriod(RollbackTracker tracker,
                       RollbackEnd rollbackEnd, 
                       long rollbackEndLSN) {
            this(tracker,
                 rollbackEnd.getMatchpoint(),
                 rollbackEnd.getRollbackStart(),
                 rollbackEndLSN,
                 tracker.getCheckpointStart(),
                 null);   // activeTxnIds
        }

        RollbackPeriod(RollbackTracker tracker,
                       RollbackStart rollbackStart, 
                       long rollbackStartLSN) {
            this(tracker,
                 rollbackStart.getMatchpoint(),
                 rollbackStartLSN,
                 DbLsn.NULL_LSN,     // rollbackendLSN;
                 tracker.getCheckpointStart(),
                 rollbackStart.getActiveTxnIds());
        }

        /* For unit testing only. */
        RollbackPeriod(long matchpointLSN,
                       long rollbackStartLSN,
                       long rollbackEndLSN,
                       long checkpointStart) {
            this(null, matchpointLSN, rollbackStartLSN, rollbackEndLSN, 
                 checkpointStart, null /*activeTxnIds*/);
        }


        private RollbackPeriod(RollbackTracker tracker,
                               long matchpointLSN,
                               long rollbackStartLSN,
                               long rollbackEndLSN,
                               long checkpointStart,
                               Set<Long> activeTxnIds) {
            this.tracker = tracker;
            this.matchpointLSN = matchpointLSN;
            this.rollbackStartLSN = rollbackStartLSN;
            this.rollbackEndLSN = rollbackEndLSN;
            this.beforeCheckpointStart = calcBeforeCheckpoint(checkpointStart);
            txnChainMap = new HashMap<Long, TxnChain>();
            children = new ArrayList<RollbackPeriod>();
            this.activeTxnIds = activeTxnIds;
        }

        private boolean calcBeforeCheckpoint(long checkpointStart) {
            return ((checkpointStart != DbLsn.NULL_LSN) &&
                    (rollbackEndLSN != DbLsn.NULL_LSN) &&
                    (DbLsn.compareTo(rollbackEndLSN, checkpointStart) < 0));
        }

        /**
         * A new RollbackEnd has been seen.
         *
         * @return true if the RollbackEnd belongs to a period nested within
         * the current period. Return false if the RollbackEnd belongs to new,
         * distinct, different period, and the current period is closed.
         */
        boolean makeNestedPeriod(RollbackEnd foundRBEnd, long foundLSN) {
            RollbackPeriod target = getNewPeriodTarget(foundRBEnd, foundLSN);
            if (target != null) {
                target.makeChild(foundRBEnd, foundLSN);
                return true;
            }
            return false;
        }

        /**
         * A new RollbackStart has been seen.
         *
         * @return true if the RollbackStart belongs to a period nested within
         * the current period, or if it is the current period. Return false if
         * the RollbackStart belongs to new, distinct, different period, and
         * this current period is closed.
         */
        boolean makeNestedPeriod(RollbackStart foundRBStart, long foundLSN) {
            RollbackPeriod target = getNewPeriodTarget(foundRBStart, foundLSN);
            if (target != null) {
                if (target.isMatchingRollbackStart(foundLSN)) {
                    assert target.activeTxnIds == null;
                    target.activeTxnIds = foundRBStart.getActiveTxnIds();
                } else {
                    target.makeChild(foundRBStart, foundLSN);
                }

                /* 
                 * Retrun true to let the caller know that it doesn't have to
                 * make a new Rollback period. Either the RBStart did not
                 * initiate a new period, or we made a nested child.
                 */
                return true;
            }
            /* This period is closed. */
            return false;
        }

        private boolean contained(RollbackEnd foundRBEnd, long foundLSN) {

            /* 
             * This RollbackEnd must either
             * 1 - precede this period, in which case this period is closed, or
             * 2 - be wholly contained within this period.
             */

            /* case 1 */
            if (DbLsn.compareTo(foundLSN, matchpointLSN) < 0) {
                /* The found rollback end precedes this period. */
                return false;
            }

            if (DbLsn.compareTo(foundLSN, rollbackStartLSN) >= 0) {
                fail("Should not be two RollbackEnds in a row. " +
                     "New RollbackEnd at " +
                     DbLsn.getNoFormatString(foundLSN) +
                     " " + foundRBEnd); 
            }

            /* 
             * Check for compliance to the rule that this RollbackEnd does not
             * intersect this rollback period.
             */
            if (!((DbLsn.compareTo(foundRBEnd.getMatchpoint(), 
                                   matchpointLSN) >= 0) &&
                  (DbLsn.compareTo(foundRBEnd.getRollbackStart(),
                                   rollbackStartLSN) < 0))) {
                fail("RollbackEnd intersects current rollback period " +
                     foundRBEnd + " at " + DbLsn.getNoFormatString(foundLSN));
            }

            /* case 2 */
            return true;
        }

        /**
         * @return true if the current rollback period is still open
         */
        private boolean contained(RollbackStart foundRBStart, long foundLSN) {

            /* 
             * This RollbackStart must:
             *  1 - precede the current period, indicating the end of this
             *      period.
             *  2 - is the rolblack start that belongs to this period.
             *  3 - be wholly contained within this period.
             */

            /* case 1 */
            if (DbLsn.compareTo(foundLSN, matchpointLSN) < 0) {
                /* The found rollback start precedes this period. */
                return false;
            }

            if (isMatchingRollbackStart(foundLSN)) {
                return true;
            }

            /* Check for compliance with case 3. */
            if (!((DbLsn.compareTo(foundRBStart.getMatchpoint(), 
                                   matchpointLSN) >= 0) &&
                  (DbLsn.compareTo(foundLSN, rollbackStartLSN) < 0))) {
                fail("RollbackStart intersects current rollback period " +
                     foundRBStart + " at " +
                     DbLsn.getNoFormatString(foundLSN));
            }

            /* case 3. */
            return true;
        }

        /**
         * @return true if this RollbackStart entry is the one that is the
         * RollbackStart for this open period.
         */
        private boolean isMatchingRollbackStart(long foundLSN) {
            return (DbLsn.compareTo(foundLSN, rollbackStartLSN) == 0);
        }

        private void makeChild(RollbackEnd foundRBEnd, long foundLSN) {
            currentChild = new RollbackPeriod(tracker,
                                              foundRBEnd,  
                                              foundLSN);
            children.add(currentChild);
        }

        private void makeChild(RollbackStart foundRBStart, long foundLSN) {
            currentChild = new RollbackPeriod(tracker,
                                              foundRBStart,
                                              foundLSN);
            children.add(currentChild);
        }

        /**
         * Return the period that should own this foundRBEnd. That may be
         * either a nested period, or this period.
         */
        RollbackPeriod getNewPeriodTarget(RollbackEnd foundRBEnd,
                                          long foundLSN) {
            if (currentChild != null) {
                final RollbackPeriod target =
                    currentChild.getNewPeriodTarget(foundRBEnd, foundLSN);
                if (target != null) {
                    return target;
                }
            }

            if (contained(foundRBEnd, foundLSN)) {
                return this;
            } 
            return null;
        }

        /**
         * Return the period that should own this foundRBStart. That may be
         * either a nested period, or this period.
         */
        RollbackPeriod getNewPeriodTarget(RollbackStart foundRBStart,
                                          long foundLSN) {
            if (currentChild != null) {
                final RollbackPeriod target =
                    currentChild.getNewPeriodTarget(foundRBStart, foundLSN);
                if (target != null) {
                    return target;
                }
            }

            if (contained(foundRBStart, foundLSN)) {
                return this;
            } 
            return null;
        }

        RollbackPeriod getScannerTarget(long lsn) {
            if (currentChild != null)  {
                RollbackPeriod target = currentChild.getScannerTarget(lsn);
                if (target != null) {
                    return target;
                }
            }

            if (DbLsn.compareTo(lsn, matchpointLSN) > 0) {
                return this;
            } 
            return null;
        }

        void initChildIter() {
            childIter = children.iterator();
            if (childIter.hasNext()) {
                currentChild = childIter.next();
                currentChild.initChildIter();
            } else {
                currentChild = null;
            }
        }

        void fail(String errorMessage) {
            throw new EnvironmentFailureException
                (tracker.getEnvImpl(), 
                 EnvironmentFailureReason.LOG_INTEGRITY,
                 errorMessage + "\ntracker contents=" + tracker);
        }

        /**
         * This log entry belongs to this rollback period if it lies between
         * the matchpoint and the RollbackStart. We don't use RollbackEnd,
         * because there may not be a RollbackEnd. Also, by definition,
         * anything whose rollback fate is define by this period must have
         * happened before the RollbackStart.
         */
        boolean contains(long lsn) {
            return (DbLsn.compareTo(matchpointLSN, lsn) < 0) &&
                (DbLsn.compareTo(rollbackStartLSN, lsn) > 0);
        }

        boolean containsLN(long lsn, long txnId) {
            return contains(lsn) && activeTxnIds.contains(txnId);
        }

        void positionChildren(long lsn) {
            if (currentChild == null)
                return;

            if (currentChild.follows(lsn)) {
                if (childIter.hasNext()) {
                    currentChild = childIter.next();
                    currentChild.initChildIter();
                } else {
                    currentChild = null;
                    return;
                }
            } 

            currentChild.positionChildren(lsn);
        }

        RollbackPeriod findTarget(long lsn, long txnId) {
            
            if (currentChild != null) {
                final RollbackPeriod candidate = 
                    currentChild.findTarget(lsn, txnId);
                if (candidate != null) {
                    return candidate;
                }
            } 
             
            if (containsLN(lsn, txnId)) {
                return this;
            } 
            return null;
        }

        /**
         * There should not be any txnal LNs between a rollback start and
         * rollback end log entry.
         */
        boolean notInRollbackStartAndEnd(long lsn, long txnId) {
            if (!TxnManager.isReplicatedTxn(txnId)) {
                /* Don't bother checking a non-replicated txn. */
                return true;
            }

            if (rollbackEndLSN == DbLsn.NULL_LSN)
                return true;
            
            return (!((DbLsn.compareTo(rollbackStartLSN, lsn) < 0) &&
                      (DbLsn.compareTo(rollbackEndLSN, lsn) > 0)));
        }

        String bracketFailure(long lsn) {
            return lsn + " [" + DbLsn.getNoFormatString(lsn) + 
                "] should not be within rollbackStart " + rollbackStartLSN +
                " [" + DbLsn.getNoFormatString(rollbackStartLSN) +
                "] and rollbackEnd " + rollbackEndLSN + " [" +
                DbLsn.getNoFormatString(rollbackEndLSN) + "]";
        }

        /**
         * @return true if this rollback period is after, and does not contain
         * the lsn.
         */
        boolean follows(long lsn) {
            return DbLsn.compareTo(matchpointLSN, lsn) > 0;
        }

        /**
         * @return true if this rollback period is before, and does not contain
         * the lsn.
         */
        boolean precedes(long lsn) {
            return DbLsn.compareTo(rollbackStartLSN, lsn) < 0;
        }

        TxnChain getChain(long txnId, long undoLsn, EnvironmentImpl envImpl) {
            TxnChain chain = txnChainMap.get(txnId);
            if (chain == null) {
                chain = new TxnChain(undoLsn,
                                     txnId,
                                     matchpointLSN,
                                     envImpl);
                txnChainMap.put(txnId, chain);
            }
            return chain;
        }

        boolean hasRollbackEnd() {
            return rollbackEndLSN != DbLsn.NULL_LSN;
        }

        @Override
        public String toString() {
            return "matchpoint=" + matchpointLSN + " [" +
                DbLsn.getNoFormatString(matchpointLSN) +
                "] rollbackStart=" + rollbackStartLSN + " [" +
                DbLsn.getNoFormatString(rollbackStartLSN) +
                "] rollbackEnd=" + rollbackEndLSN + " [" +
                DbLsn.getNoFormatString(rollbackEndLSN) + "]";
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof RollbackPeriod)) {
                return false;
            }

            RollbackPeriod otherPeriod = (RollbackPeriod) other;
            return ((matchpointLSN == otherPeriod.matchpointLSN) &&
                    (rollbackStartLSN == otherPeriod.rollbackStartLSN) &&
                    (rollbackEndLSN == otherPeriod.rollbackEndLSN));
        }

        boolean beforeCheckpointStart() {
            return beforeCheckpointStart;
        }
    }
}
