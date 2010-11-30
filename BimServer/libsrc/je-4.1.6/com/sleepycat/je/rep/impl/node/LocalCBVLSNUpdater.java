/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002,2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.node;

import static com.sleepycat.je.utilint.VLSN.NULL_VLSN;

import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.stream.Protocol;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.VLSN;

/**
 * Supports updating the group database with each node's local CBVLSN when it
 * is in the Master state. There is one instance per feeder connection, plus
 * one for the Master. There is, logically, a LocalCBVLSNTracker instance
 * associated with each instance of the updater. The instance is local for an
 * update associated with a node in the Master state and is remote for each
 * Replica.
 *
 * The nodeCBVLSN can only increase during the lifetime of the
 * LocalCBVLSNUpdater instance. Note however that the value of the node's
 * CBVLSN as stored in the database, which represents the values from multiple
 * updaters associated, with a node over its lifetime may both decrease and
 * increase over its lifetime. The decreases are due primarily to rollbacks,
 * and should be relatively rare.
 *
 * The updaters used to maintain the Replica's local CBVLSNs are stored in the
 * Feeder.InputThread. The lifetime of such a LocalCBVLSNUpdater is therefore
 * determined by the lifetime of the connection between the Master and the
 * Replica. The node CBVLSN is updated each time a heart beat response is
 * processed by the FeederInput thread. It's also updated when the Master
 * detects that a Replica needs a network restore. In this case, it updates
 * cbvlsn to the value expected from the node after a network restore so that
 * the global CBVLSN can continue to make forward progress and not hold up the
 * cleaner.
 *
 * The Master maintains an updater for its own CBVLSN in the FeederManager.
 * This updater exists as long as the node retains its Master state.
 *
 * Local CBVLSNs are used only to contribute to the calculation of the global
 * CBVLSN. The global CBVLSN acts as the cleaner throttle. Any invariants, such
 * as the rule that the cleaner throttle cannot regress, are applied when doing
 * the global calculation.
 */
public class LocalCBVLSNUpdater {

    private static final String VLSN_SOURCE = "vlsn";
    private static final String MASTER_SOURCE = "master";
    private static final String HEARTBEAT_SOURCE = "heartbeat";

    /*
     * The node id of the node whose CBLVLSN is being tracked. If this updater
     * is working on the behalf o a replica node, the nameIdPair is not the
     * name of this node.
     */
    private final NameIdPair nameIdPair;

    /* This node; note that its node id may be different from nodeId above. */
    private final RepNode repNode;

    /*
     * The node's local CBVLSN is cached here, for use without reading the
     * group db.
     */
    private VLSN nodeCBVLSN;

    /*
     * True if this node's local CBVLSN  has changed, but the new value
     * has not been stored into the group db yet.
     */
    private boolean updatePending;

    /* Used to suppress database updates during unit testing. */
    private static boolean suppressGroupDBUpdates = false;

    private final Logger logger;

    LocalCBVLSNUpdater(NameIdPair nameIdPair, RepNode repNode) {
        this.nameIdPair = nameIdPair;
        this.repNode = repNode;

        nodeCBVLSN = NULL_VLSN;
        updatePending = false;

        logger = LoggerUtils.getLogger(getClass());
    }

    /**
     * Sets the current CBVLSN for this node, and trips the updatePending
     * flag so that we know there is something to store to the RepGroupDB.
     *
     * @param syncableVLSN the new local CBVLSN
     * @throws InterruptedException
     */
    private void set(VLSN syncableVLSN, String source) {

        assert repNode.isMaster() :
               "LocalCBVLSNUpdater.set() can only be called by the master";

        if (!nodeCBVLSN.equals(syncableVLSN)) {
            LoggerUtils.fine(logger, repNode.getRepImpl(),
                             "update local CBVLSN for " + nameIdPair +
                             " from nodeCBVLSN " + nodeCBVLSN + " to " +
                             syncableVLSN + " from " + source);
            if (nodeCBVLSN.compareTo(syncableVLSN) >= 0) {

                /*
                 * LCBVLSN must not decrease, since it can result in a GCBVLSN
                 * value that's outside a truncated VLSNIndex range. See SR
                 * [#17343]
                 */
                throw EnvironmentFailureException.unexpectedState
                    (repNode.getRepImpl(),
                     "nodeCBVLSN" + nodeCBVLSN + " >= " + syncableVLSN +
                     " attempted update local CBVLSN for " + nameIdPair +
                     " from " + source);
            }
            nodeCBVLSN = syncableVLSN;
            updatePending = true;
        }
    }

    /**
     * Exercise caution when using this method. The normal mode of updating the
     * CBVLSN is via the heartbeat. So, if the CBVLSN is updated through the
     * method, ensure that it supplies an increasing CBCLSN and that it's
     * CBVLSN is coordinated with the one supplied by
     * {@link #updateForReplica(com.sleepycat.je.rep.stream.Protocol.HeartbeatResponse)}
     * . The two methods together, must maintain the invariant that the local
     * CBVLSN value must always be ascending.
     *
     * @param syncableVLSN the new local CBVLSN
     */
    public void updateForReplica(VLSN syncableVLSN) {
        set(syncableVLSN, VLSN_SOURCE);
        update();
    }

    /**
     * Sets the current CBVLSN for this node. Can only be used by the
     * master. The new cbvlsn value comes from an incoming heartbeat response
     * message.
     * @param heartbeat The incoming heartbeat response message from the
     * replica containing its newest local cbvlsn.
     */
    public void updateForReplica(Protocol.HeartbeatResponse heartbeat) {
        set(heartbeat.getSyncupVLSN(), HEARTBEAT_SOURCE);
        update();
    }

    /**
     * As a master, update the database with the local CBVLSN for this node.
     * This call is needed because the master's local CBVLSN will not be
     * broadcast via a heartbeat, so it needs to get to the updater another
     * way.
     * @throws InterruptedException
     */
    void updateForMaster(LocalCBVLSNTracker tracker)
        throws InterruptedException {

        set(tracker.getBroadcastCBVLSN(), MASTER_SOURCE);
        update();
    }

    /**
     * Update the database, with the local CBVLSN associated with the node Id
     * if required. Note that updates can only be invoked on the master
     * @throws InterruptedException
     */
    private void update() {

        if (!updatePending) {
            return;
        }

        if (suppressGroupDBUpdates) {
            /* Short circuit the database update. For testing only. */
            updatePending = false;
            return;
        }

        if (repNode.isShutdown()) {

            /*
             * Don't advance VLSNs after a shutdown request, to minimize the
             * need for a hard recovery.
             */
            return;
        }

        try {
            VLSN candidate = nodeCBVLSN;

            if (candidate.isNull()) {
                return;
            }

            if (candidate.compareTo(repNode.getGroupCBVLSN()) < 0) {
                /* Don't let the group CBVLSN regress.*/
                return;
            }

            boolean updated = repNode.repGroupDB.updateLocalCBVLSN(nameIdPair,
                                                                   candidate);
            /* If not updated, we'll try again later. */
            if (updated) {
                updatePending = false;
            }
        } catch (EnvironmentFailureException e) {

            /*
             * Propagate environment failure exception so that the master
             * can shut down.
             */
            throw e;
        } catch (DatabaseException e) {

            e.printStackTrace();
            LoggerUtils.warning(repNode.logger, repNode.getRepImpl(),
                                "local cbvlsn update failed for node: " +
                                nameIdPair + " Error: " + e.getMessage());
        }
    }

    /**
     * Used during testing to suppress CBVLSN updates at this node. Note that
     * the cleaner must also typically be turned off (first) in conjunction
     * with the suppression. If multiple nodes are running in the VM all nodes
     * will have the CBVLSN updates turned off.
     * @param suppressGroupDBUpdates If true, the group DB and the group CBVLSN
     * won't be updated at the master.
     */
    static public
    void setSuppressGroupDBUpdates(boolean suppressGroupDBUpdates) {
        LocalCBVLSNUpdater.suppressGroupDBUpdates = suppressGroupDBUpdates;
    }

    /* For unit testing */
    static boolean getSuppressGroupDBUpdates() {
        return suppressGroupDBUpdates;
    }
}
