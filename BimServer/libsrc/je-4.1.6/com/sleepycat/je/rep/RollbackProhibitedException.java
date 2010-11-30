/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.stream.MatchpointSearchResults;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.VLSN;

/**
 * This exception may be thrown by a Replica during the {@link <a
 * href="{@docRoot}/../ReplicationGuide/lifecycle.html#lifecycle-nodestartup">
 * replication stream sync-up</a>} phase of startup. It indicates that a syncup
 * cannot proceed without undoing a number of committed transactions that
 * exceeds the limit defined by {@link ReplicationConfig#TXN_ROLLBACK_LIMIT}.
 * <p>
 * It is rare for committed transactions to be rolled back during a
 * sync-up. One way this can happen is if a replication group has been
 * executing with a {@link com.sleepycat.je.Durability} policy that specifies a
 * {@link com.sleepycat.je.Durability.ReplicaAckPolicy ReplicaAckPolicy} of
 * NONE.
 * <p>
 * When ReplicaAckPolicy.NONE is specified, transactions can commit on the
 * master without receiving any acknowledgments from replica nodes. Using that
 * policy, it is possible that if the master node crashes at a given time, and
 * the group fails over and continues on with a new master, the old master's
 * environment will have transactions on disk that were never replicated and
 * received by other nodes. When this old master comes back up and rejoins the
 * group as a replica, it will have committed transactions that need to be
 * rolled back.
 * <p>
 * If the number of committed transactions to be rolled back is less than or
 * equal to the limit specified by {@link
 * ReplicationConfig#TXN_ROLLBACK_LIMIT}, JE will automatically truncate the
 * environment log to remove the unreplicated transactions, and will throw a
 * {@link RollbackException}. The application only needs to reinstantiate the
 * ReplicatedEnvironment and proceed on. If the limit specified by {@link
 * ReplicationConfig#TXN_ROLLBACK_LIMIT} is exceeded, the application will
 * receive a RollbackProhibitedException to indicate that manual intervention is
 * required.
 * <p>
 * The RollbackProhibitedException lets the user interject application specific
 * processing before the log is truncated. The exception message and getter
 * methods indicate the number of transactions that must be rolled back, and
 * the time and id of the earliest targeted transaction, and the user can use
 * this information to make any desired application adjustments. The
 * application may then manually truncate the log using {@link
 * com.sleepycat.je.util.DbTruncateLog}.
 */

public class RollbackProhibitedException extends RestartRequiredException {
    private static final long serialVersionUID = 1L;

    private final MatchpointSearchResults searchResults;
    private final String nodeName;
    private final int rollbackTxnLimit;
    private final VLSN matchpointVLSN;

    /**
     * For internal use only.
     * @hidden
     */
    public RollbackProhibitedException(RepImpl repImpl,
                                       int rollbackTxnLimit,
                                       VLSN matchpointVLSN,
                                       MatchpointSearchResults searchResults) {

        super(repImpl, EnvironmentFailureReason.ROLLBACK_PROHIBITED);
        this.rollbackTxnLimit = rollbackTxnLimit;
        this.searchResults = searchResults;
        this.nodeName = repImpl.getName();
        this.matchpointVLSN = matchpointVLSN;
    }

    @Override
    public String getMessage() {
        long matchpointLSN = searchResults.getMatchpointLSN();
        long fileNumber = DbLsn.getFileNumber(matchpointLSN);
        long fileOffset = DbLsn.getFileOffset(matchpointLSN);
        return
            "Node " + nodeName + " must rollback" +
            searchResults.getRollbackMsg() + 
            " in order to rejoin the replication group, but the transaction " +
            "rollback limit of " + rollbackTxnLimit + " prohibits this. " + 
            "Either increase the property je.rep.txnRollbackLimit to a value " +
            "larger than " + rollbackTxnLimit + " to permit automatic " + 
            "rollback, or manually remove the problematic transactions. " + 
            "To do a manual removal, truncate the log to file " + 
            FileManager.getFileName(fileNumber, FileManager.JE_SUFFIX) + 
            ", offset 0x" + 
            Long.toHexString(fileOffset) + ", vlsn " + 
            matchpointVLSN + 
            " using the directions in com.sleepycat.je.util.DbTruncateLog.";
    }

    /**
     * For internal use only.
     * @hidden
     */
    public RollbackProhibitedException(String message,
                                       RollbackProhibitedException cause) {
        super(message, cause);
        this.rollbackTxnLimit = cause.rollbackTxnLimit;
        this.searchResults = cause.searchResults;
        this.nodeName = cause.nodeName;
        this.matchpointVLSN = cause.matchpointVLSN;
    }

    /**
     * For internal use only.
     * @hidden
     */
    @Override
    public RollbackProhibitedException wrapSelf(String msg) {
        return new RollbackProhibitedException(msg, this);
    }

    /*
     * The JE log must be truncated to this file in order for this node to
     * rejoin the group.
     */
    public long getTruncationFileNumber() {
        return DbLsn.getFileNumber(searchResults.getMatchpointLSN());
    }

    /**
     * The JE log must be truncated to this offset in the specified
     * file in order for this node to rejoin the group.
     */
    public long getTruncationFileOffset() {
        return DbLsn.getFileOffset(searchResults.getMatchpointLSN());
    }

    /**
     * Return the time in milliseconds of the earliest transaction commit that 
     * will be rolled back if the log is truncated to the location specified by
     * {@link #getTruncationFileNumber} and {@link #getTruncationFileOffset}
     */
    public Long getEarliestTransactionCommitTime() {
        return searchResults.getEarliestPassedTxn().time.getTime();
    }

    /**
     * Return the id of the earliest transaction commit that will be
     * rolled back if the log is truncated to the location specified by
     * {@link #getTruncationFileNumber} and {@link #getTruncationFileOffset}
     */
    public long getEarliestTransactionId() {
        return searchResults.getEarliestPassedTxn().id;
    }
}
