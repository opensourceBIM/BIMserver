/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.recovery;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sleepycat.je.dbi.DatabaseId;

/**
 * LevelRecorder is used to determine when an extra read-IN pass is needed
 * during recovery. See SR [#14424]
 *
 * Splits and compression require logging up to the root of the tree, to ensure
 * that all INs are properly returned to the correct position at recovery. In
 * other words, splits and compression ensure that the creation and deletion of
 * all nodes is promptly logged.
 *
 * However, checkpoints are not propagated to the top of the tree, in order to
 * conserve on logging. Because of that, a great-aunt situation can occur,
 * where an ancestor of a given node can be logged without referring to the
 * latest on-disk position of the node, because that ancestor was part of a
 * split or compression.
 *
 * Take this scenario:
 *     Root-A
 *      /    \
 *    IN-B   IN-C
 *   /      / | \
 *  BIN-D
 *  /
 * LN-E
 *
 * 1) LN-E  is logged, BIN-D is dirtied
 * 2) BIN-D is logged during a checkpoint, IN-B is dirtied
 * 3) IN-C  is split and Root-A is logged
 * 4) We recover using Root-A and the BIN-D logged at (2) is lost
 *
 * At (3) when Root-A is logged, it points to an IN-B on disk that does not
 * point to the most recent BIN-D
 *
 * At (4) when we recover, although we will process the BIN-D logged at (2) and
 * splice it into the tree, the Root-A logged at (3) is processed last and
 * overrides the entire subtree containing BIN-D
 *
 * This could be addressed by always logging to the root at every checkpoint.
 * Barring that, we address it by replaying INs a second time at recovery
 * if we can detect that a split or compression occurred -- if there are
 * multiple level of non-provisional IN entries for the given database.
 *
 * In the ideal case, this would occur infrequently. If there were a checkpoint
 * and no splits/compressions, one should only see the checkpoint top level as
 * non-provisional log entries.
 *
 * One issue that may make this extra read pass occur more than it should is
 * that cascading updates for splits and compressions are logging all entries
 * non-provisionally, when in theory, only the root need be logged
 * non-provisionally. This makes splits and compressions more expensive to
 * process at recovery than they should be, and may cause unnecessary extra
 * passes. We'll leave that implementation now for stability, and will return
 * to this optimization.
 */
class LevelRecorder {

    private Map<DatabaseId,LevelInfo> dbLevels;

    LevelRecorder() {
        dbLevels = new HashMap<DatabaseId,LevelInfo>();
    }

    /*
     * Record whether the level seen for the current IN is the highest or
     * lowest.
     */
    void record(DatabaseId dbId, int level) {
        LevelInfo info = dbLevels.get(dbId);
        if (info == null) {
            info = new LevelInfo();
            dbLevels.put(dbId, info);
        }
        info.recordLevel(level);
    }

    /*
     * Get the set of databases that were logged non-provisionally with
     * different levels in the ckpt set. These databases must be redone.
     */
    Set<DatabaseId> getDbsWithDifferentLevels() {
        Set<DatabaseId> reprocessDbs = new HashSet<DatabaseId>();
        Iterator<Map.Entry<DatabaseId,LevelInfo>> iter = 
            dbLevels.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<DatabaseId,LevelInfo> oneEntry = iter.next();
            LevelInfo levelInfo = oneEntry.getValue();
            if (levelInfo.getDifferenceSeen()) {
                reprocessDbs.add(oneEntry.getKey());
            }
        }
        return reprocessDbs;
    }

    /**
     * Remember the highest and lowest level seen for a given database.
     */
    private static class LevelInfo {
        private int highest = Integer.MIN_VALUE;
        private int lowest = Integer.MAX_VALUE;
        private boolean differenceSeen = false;

        void recordLevel(int level) {
            if (!differenceSeen) {
                if (level < lowest) {
                    lowest = level;
                }
                if (level > highest) {
                    highest = level;
                }
                differenceSeen = highest > lowest;
            }
        }

        /*
         * @return true if there is a difference between the highest and
         * lowest.
         */
        boolean getDifferenceSeen() {
            return differenceSeen;
        }
    }
}
