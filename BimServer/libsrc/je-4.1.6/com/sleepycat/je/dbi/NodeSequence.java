/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import java.util.concurrent.atomic.AtomicLong;

import com.sleepycat.je.EnvironmentFailureException;

/**
 * NodeSequence encapsulates the generation and maintenance of a sequence for
 * generating node ids.
 */
public class NodeSequence {

    public static final int FIRST_LOCAL_NODE_ID = 1;
    public static final int FIRST_REPLICATED_NODE_ID = -10;

    /*
     * Node Ids: We need to ensure that local and replicated nodes use
     * different number spaces for their ids, so there can't be any possible
     * conflicts.  Local, non replicated nodes use positive values starting
     * with 1, replicated nodes use negative values starting with -10. On top
     * of that, there is the notion of transient node ids, which are used for
     * cases like the eof node used for Serializable isolation. Transient node
     * ids are used to provide unique locks, and are only used during the life
     * of an environment, for non-persistent objects. We use the descending
     * sequence of positive values, starting from Long.MAX_VALUE.
     *
     * Node ID values from 0 to -9 are reserved.  0 is not used and should be
     * avoided.  -1 is used to mean null or none, and should be used via the
     * Node.NULL_NODE_ID constant.  -2 through -9 are reserved for future use.
     *
     * The transient node sequence must be initialized before the DbTree
     * uber-tree is created, because they are used at DatabaseImpl
     * construction.  The local and replicated node id sequences are
     * initialized by the first pass of recovery, after the log has been
     * scanned for the latest used node id.
     */
    private AtomicLong lastAllocatedLocalNodeId = null;
    private AtomicLong lastAllocatedReplicatedNodeId = null;
    private AtomicLong lastAllocatedTransientNodeId = null;

    public final EnvironmentImpl envImpl;

    public NodeSequence(EnvironmentImpl envImpl) {
        this.envImpl = envImpl;
    }

    /**
     * Initialize the counters in these methods rather than a constructor
     * so we can control the initialization more precisely.
     */
    void initTransientNodeId() {
        lastAllocatedTransientNodeId = new AtomicLong(Long.MAX_VALUE);
    }

    /**
     * Initialize the counters in these methods rather than a constructor
     * so we can control the initialization more precisely.
     */
    void initRealNodeId() {
        lastAllocatedLocalNodeId = new AtomicLong(FIRST_LOCAL_NODE_ID - 1);
        lastAllocatedReplicatedNodeId =
            new AtomicLong(FIRST_REPLICATED_NODE_ID + 1);
    }

    /**
     * The last allocated local and replicated node ids are used for ckpts.
     */
    public long getLastLocalNodeId() {
        return lastAllocatedLocalNodeId.get();
    }

    public long getLastReplicatedNodeId() {
        return lastAllocatedReplicatedNodeId.get();
    }

    /**
     * We get a new node id of the appropriate kind when creating a new node.
     */
    public long getNextLocalNodeId() {
        return lastAllocatedLocalNodeId.incrementAndGet();
    }

    public long getNextReplicatedNodeId() {
        return lastAllocatedReplicatedNodeId.decrementAndGet();
    }

    public long getNextTransientNodeId() {
        /* Assert that the two sequences haven't overlapped. */
        assert (noOverlap()) : "transient=" +
            lastAllocatedTransientNodeId.get();
        return lastAllocatedTransientNodeId.decrementAndGet();
    }

    private boolean noOverlap() {
        return (lastAllocatedLocalNodeId != null) ?
               (lastAllocatedTransientNodeId.get() - 1) >
                        lastAllocatedLocalNodeId.get() :
               true;
    }

    /**
     * Initialize the node ids, from recovery. No need to initialize
     * the transient node ids, since those can be reused each time the
     * environment is recreated.
     */
    public void setLastNodeId(long lastReplicatedNodeId,
                              long lastLocalNodeId) {
        lastAllocatedReplicatedNodeId.set(lastReplicatedNodeId);
        lastAllocatedLocalNodeId.set(lastLocalNodeId);
    }

    /*
     * Tracks the lowest replicated node id used during a replay of the
     * replication stream, so that it's available as the starting point if this
     * replica transitions to being the master.
     */
    public void updateFromReplay(long replayNodeId) {
        assert !envImpl.isMaster();
        if (replayNodeId > 0 && !envImpl.isConverted()) {
           throw EnvironmentFailureException.unexpectedState
               ("replay node id is unexpectedly positive " + replayNodeId);
        }

        if (replayNodeId < lastAllocatedReplicatedNodeId.get()) {
            lastAllocatedReplicatedNodeId.set(replayNodeId);
        }
    }
}
