/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.stream;

import java.util.ArrayList;
import java.util.List;

import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.rep.impl.RepParams;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.Timestamp;
import com.sleepycat.je.utilint.VLSN;

/**
 * Holds information seen by the ReplicaSyncupReader when
 * scanning a replica's log for a matchpoint.
 */
public class MatchpointSearchResults {
    private long matchpointLSN;
    private boolean passedCheckpointEnd;

    /*
     * We save a set number of passed transactions for debugging information.
     * The list is limited in size in case we end up passing a large number
     * of transactions on our hunt for a matchpoint.
     */
    private final List<PassedTxnInfo> passedTxns;
    private final int passedTxnLimit;

    /*
     * We need to keep the penultimate passed txn so we can readjust the
     * passed transaction information when the matchpoint is found. For
     * example, suppose the log contains:
     *   txn A commit
     *   txn B commit
     *   txn C commit
     * and txn A commit is the matchpoint. The way the loop works, we'll
     * have earliestPassedTxn = txnA, and penultimate = txn B. If the
     * matchpoint is txnA, the log will be truncated at txnB, and we
     * should reset earliestPassedTxn = txnB.
     */
    private PassedTxnInfo earliestPassedTxn;
    private PassedTxnInfo penultimatePassedTxn;
    private int numPassedCommits;

    MatchpointSearchResults(EnvironmentImpl envImpl) {

        /*
         * The matchpointLSN should be a non-null value, because we always have
         * to provide a valid truncation point.
         */
        matchpointLSN = DbLsn.makeLsn(0, 0);

        passedTxnLimit =
            envImpl.getConfigManager().getInt(RepParams.TXN_ROLLBACK_LIMIT);
        passedTxns = new ArrayList<PassedTxnInfo>();
        numPassedCommits = 0;
    }

    /**
     * If we see a checkpoint end record, see if it is a barrier to
     * rolling back, and advance the file reader position.
     */
    void notePassedCheckpointEnd() {
        passedCheckpointEnd = true;
    }

    /**
     * At the end of the search for a matchpoint, set the matchpointLSN and
     * adjust the debugging list of passed transactions. The matchpoint entry
     * is just before the truncation point, and does not get truncated.
     */
    void setMatchpoint(long match) {
        matchpointLSN = match;
        if ((earliestPassedTxn != null) &&
            (earliestPassedTxn.lsn == matchpointLSN)) {
            numPassedCommits--;

            if (passedTxns.size() > 0) {
               int lastSavedTxn = passedTxns.size() - 1;
               if (passedTxns.get(lastSavedTxn).lsn == match) {
                  passedTxns.remove(lastSavedTxn);
               }
               earliestPassedTxn = penultimatePassedTxn;
            }
        }
    }

    /** The reader saw a transaction commit. Record that information. */
    void notePassedCommits(Timestamp commitTime,
                           long txnId,
                           VLSN vlsn,
                           long lsn) {
        numPassedCommits++;
        if (earliestPassedTxn != null) {
            penultimatePassedTxn = earliestPassedTxn;
        }
        earliestPassedTxn = new PassedTxnInfo(commitTime, txnId, vlsn, lsn);

        /*
         * Save only a limited number of passed txns, for displaying to the log
         */
        if (numPassedCommits <= passedTxnLimit) {
            passedTxns.add(earliestPassedTxn);
        }
    }

    boolean getPassedCheckpointEnd() {
        return passedCheckpointEnd;
    }

    public long getMatchpointLSN() {
        return matchpointLSN;
    }

    public int getNumPassedCommits() {
        return numPassedCommits;
    }

    public PassedTxnInfo getEarliestPassedTxn() {
        return earliestPassedTxn;
    }

    /**
     * Display the saved transaction information.
     */
    public String dumpPassedTxns() {
        StringBuilder sb = new StringBuilder();
        for (PassedTxnInfo info : passedTxns) {
            sb.append(info);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "matchpointLSN=" + DbLsn.getNoFormatString(matchpointLSN) +
            " passedCkpt=" + passedCheckpointEnd +
            " passedTxnLimit=" + passedTxnLimit +
            " passedTxns=" + passedTxns +
            " earliestTxn=" + earliestPassedTxn +
            " penultimateTxn=" + penultimatePassedTxn +
            " numPassedCommits=" + numPassedCommits;
    }

    /**
     * If 1 or more commits was passed, construct a message that can
     * be used by RollbackException and RollbackProhibitedException.
     */
    public String getRollbackMsg() {
        if (numPassedCommits == 0) {
            return " uncommitted operations";
        }

        return " " + numPassedCommits +
            " commits to the earliest point indicated by transaction " +
            earliestPassedTxn;
    }

    /* Struct to hold information about passed txns. */
    public static class PassedTxnInfo {
        public final Timestamp time;
        public final long id;
        public final VLSN vlsn;
        public final long lsn;

        PassedTxnInfo(Timestamp time, long id, VLSN vlsn, long lsn) {
            this.time = time;
            this.id = id;
            this.vlsn = vlsn;
            this.lsn = lsn;
        }

        @Override
        public String toString() {
            return "id=" + id +
                " time=" + time +
                " vlsn=" + vlsn +
                " lsn=" + DbLsn.getNoFormatString(lsn);
        }
    }
}
