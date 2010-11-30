/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import com.sleepycat.je.utilint.DbLsn;

/**
 * Specifies whether to log an entry provisionally.
 *
 * Provisional log entries:
 * 
 * What are provisional log entries?
 *
 *    Provisional log entries are those tagged with the provisional attribute
 *    in the log entry header. The provisional attribute can be applied to any
 *    type of log entry, and is implemented in
 *    com.sleepycat.je.log.LogEntryHeader as two stolen bits in the 8 bit
 *    version field.
 *
 * When is the provisional attribute used?
 * 
 *    The provisional attribute is used only during recovery. It very simply
 *    indicates that recovery will ignore and skip over this log entry.
 * 
 * When is the provisional attribute set?
 * 
 *    The provisional attribute started out as a way to create atomicity among
 *    different log entries. Child pointers in the JE Btree are physical LSNs,
 *    so each Btree node's children must be logged before it in the log. On
 *    the other hand, one fundamental assumption of the JE log is that each
 *    Btree node found in the log can be replayed and placed in the in-memory
 *    tree. To do so, each Btree node must have a parent node that will house
 *    it. The grouping of multiple log entries into one atomic group is often
 *    used to fulfiil this requirement.
 * 
 *     * Atomic log entries:
 *
 *           + When a btree is first created, we bootstrap tree creation by
 *           logging the first BIN provisionally, then creating a parent IN
 *           which is the Btree root IN, which points to this first BIN.
 *
 *           + When we split a Btree node, we create a new IN, which is the
 *           sibling of the split node. We log the old sibling and the new
 *           sibling provisionally, and then log the parent, so that any
 *           crashes in the middle of this triumvirate which result in the
 *           failure to log the parent will skip over the orphaned siblings.
 *
 *           + Splitting the Btree root is just a special case of a split.
 *
 *           + Creating a duplicate subtree to hang in the middle of a btree is
 *           just a special case of a split and btree first creation.
 *
 *     * Entries not meant to be recovered
 *
 *           Temp DBs are not meant to be recovered and we log their LN
 *           and IN nodes in a very lax fashion, purely as a way of evicting
 *           them out of the cache temporarily. There is no guarantee that a
 *           consistent set has been logged to disk. We skip over them for both
 *           recovery performance and the "each-node-must-have-a-parent" rule.
 *
 *     * Durable deferred-write entries
 *
 *           Deferred-write INs are logged provisionally for the same reasons
 *           as for temp DBs (above): for recovery performance and the
 *           "each-node-must-have-a-parent" rule.
 *
 *           Deferred-write LNs are logged non-provisionally to support
 *           obsolete LSN counting.  It would be nice to log them provisionally
 *           for recovery performance and to allow LN deletion without logging;
 *           however, that is not currently practical if obsolete counting is
 *           to be supported.  See [#16864].
 *
 *     * Checkpoint performance
 *
 *           When we flush a series of nodes, it's a waste to replay nodes
 *           which are referenced by higher levels. For example, if we
 *           checkpoint this btree:
 * 
 *           INA -> INb -> BINc (dirty)-> LNd
 * 
 *           we log them in this order:
 * 
 *           BINc
 *           INb
 * 
 *           And there's no point to replaying BINc, because it's referenced by
 *           INb.  We skip over BINc, which we do by logging it provisionally.
 * 
 *     * Log cleaning - removing references to deleted files.
 * 
 *       When we delete a file for log cleaning we guarantee that no active log
 *       entries refer to any log entry in the deleted file. Suppose our
 *       checkpoint looks like this:
 * 
 *         5/100 LNa
 *         5/200 Ckpt start
 *         5/300 INs
 *         ...
 *         5/500 Ckpt end
 *         ...
 *         5/800 last entry in log
 * 
 *       Because we do not delete a file until the Ckpt end after processing
 *       (cleaning) it, nothing from 5/500 to 5/800 can refer to a file deleted
 *       due to the Ckpt end in 5/500.
 *
 *       BEFORE_CKPT_END is motivated by the fact that while log entries
 *       between 5/100 (first active lsn) and 5/500 (ckpt end) will not in of
 *       themselves contain a LSN for a cleaned, deleted file, the act of
 *       processing them during recovery could require fetching a node from a
 *       deleted file. For example, the IN at 5/300 could have an in-memory
 *       parent which has a reference to an older, cleaned version of that IN.
 *       Treating the span between 5/200 and 5/500 as provisional is both
 *       optimal, because only the high level INs need to be processed, and
 *       required, in order not to fetch from a cleaned file. See [#16037].
 */
public enum Provisional {

    /**
     * The entry is non-provisional and is always processed by recovery.
     */
    NO,
    
    /**
     * The entry is provisional and is never processed by recovery.
     */
    YES,
    
    /**
     * The entry is provisional (not processed by recovery) if it occurs before
     * the CkptEnd in the recovery interval, or is non-provisional (is
     * processed) if it occurs after CkptEnd.
     */
    BEFORE_CKPT_END;

    /**
     * Determines whether a given log entry should be processed during
     * recovery.
     */
    public boolean isProvisional(long logEntryLsn, long ckptEndLsn) {
        assert logEntryLsn != DbLsn.NULL_LSN;
        switch (this) {
        case NO:
            return false;
        case YES:
            return true;
        case BEFORE_CKPT_END:
            return ckptEndLsn != DbLsn.NULL_LSN &&
                   DbLsn.compareTo(logEntryLsn, ckptEndLsn) < 0;
        default:
            assert false;
            return false;
        }
    }
}
