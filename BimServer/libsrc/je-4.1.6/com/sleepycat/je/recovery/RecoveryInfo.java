/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.recovery;

import java.util.HashMap;
import java.util.Map;

import com.sleepycat.je.txn.Txn;
import com.sleepycat.je.utilint.DbLsn;

/**
 * RecoveryInfo keeps information about recovery processing.
 */
public class RecoveryInfo {

    /* Locations found during recovery. */
    public long lastUsedLsn = DbLsn.NULL_LSN;      // location of last entry
    /*  EOF, location of first unused spot. */
    public long nextAvailableLsn = DbLsn.NULL_LSN;
    public long firstActiveLsn = DbLsn.NULL_LSN;
    public long checkpointStartLsn = DbLsn.NULL_LSN;
    public long checkpointEndLsn = DbLsn.NULL_LSN;
    public long useRootLsn = DbLsn.NULL_LSN;

    /*
     * Represents the first CkptStart following the CkptEnd.  It is a CkptStart
     * with no CkptEnd, and is used for counting provisional INs obsolete.
     */
    public long partialCheckpointStartLsn = DbLsn.NULL_LSN;

    /* Checkpoint record used for this recovery. */
    public CheckpointEnd checkpointEnd;

    /* Ids */
    public long useMinReplicatedNodeId;
    public long useMaxNodeId;
    public int useMinReplicatedDbId;
    public int useMaxDbId;
    public long useMinReplicatedTxnId;
    public long useMaxTxnId;

    /* num nodes read */
    public int numMapINs;
    public int numOtherINs;
    public int numBinDeltas;
    public int numDuplicateINs;

    /* LN processing */
    public int lnFound;
    public int lnNotFound;
    public int lnInserted;
    public int lnReplaced;

    /* FileReader behavior. */
    public int nRepeatIteratorReads;

    /* VLSN mappings seen during recovery processing, for replication. */
    public VLSNRecoveryProxy vlsnProxy;

    /**
     * ReplayTxns that are resurrected during recovery processing, for
     * replication. Txnid -> replayTxn
     */
    public final Map<Long, Txn> replayTxns = new HashMap<Long, Txn>();

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Recovery Info ");
        appendLsn(sb, " lastUsed=", lastUsedLsn);
        appendLsn(sb, " nextAvail=", nextAvailableLsn);
        appendLsn(sb, " ckptStart=", checkpointStartLsn);
        appendLsn(sb, " firstActive=", firstActiveLsn);
        appendLsn(sb, " ckptEnd=", checkpointEndLsn);
        appendLsn(sb, " useRoot=", useRootLsn);
        sb.append(checkpointEnd);
        sb.append(">");
        sb.append(" useMinReplicatedNodeId=").append(useMinReplicatedNodeId);
        sb.append(" useMaxNodeId=").append(useMaxNodeId);
        sb.append(" useMinReplicatedDbId=").append(useMinReplicatedDbId);
        sb.append(" useMaxDbId=").append(useMaxDbId);
        sb.append(" useMinReplicatedTxnId=").append(useMinReplicatedTxnId);
        sb.append(" useMaxTxnId=").append(useMaxTxnId);
        sb.append(" numMapINs=").append(numMapINs);
        sb.append(" numOtherINs=").append(numOtherINs);
        sb.append(" numBinDeltas=").append(numBinDeltas);
        sb.append(" numDuplicateINs=").append(numDuplicateINs);
        sb.append(" lnFound=").append(lnFound);
        sb.append(" lnNotFound=").append(lnNotFound);
        sb.append(" lnInserted=").append(lnInserted);
        sb.append(" lnReplaced=").append(lnReplaced);
        sb.append(" nRepeatIteratorReads=").append(nRepeatIteratorReads);
        return sb.toString();
    }

    private void appendLsn(StringBuffer sb, String name, long lsn) {
        if (lsn != DbLsn.NULL_LSN) {
            sb.append(name).append(DbLsn.getNoFormatString(lsn));
        }
    }
}
