/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.stream;

import java.net.InetSocketAddress;

import com.sleepycat.je.rep.elections.Acceptor;
import com.sleepycat.je.rep.elections.MasterValue;
import com.sleepycat.je.rep.elections.Proposer.Proposal;
import com.sleepycat.je.rep.elections.Protocol.Value;
import com.sleepycat.je.rep.impl.node.RepNode;

/**
 * A Basic suggestion generator.
 *
 * A more sophisticated version may contact other replica nodes to see if it
 * has sufficient connectivity to implement the commit policy in effect for
 * the Replication Group. KIS for now.
 */
public class MasterSuggestionGenerator
    implements Acceptor.SuggestionGenerator {

    private final RepNode repNode;

    /* Determines whether to use pre-emptive ranking to make this
     * node the Master during the next election */
    private boolean forceAsMaster = false;

    /* Used during a forced election to guarantee this proposal as a winner. */
    private static final long PREMPTIVE_RANKING = Long.MAX_VALUE;
    /* The ranking used to ensure that a current master is reselected. */
    private static final long MASTER_RANKING= PREMPTIVE_RANKING-1;

    public MasterSuggestionGenerator(RepNode repNode) {
        this.repNode = repNode;
    }

    @SuppressWarnings("unused")
    public Value get(Proposal proposal) {
        /* Suggest myself as master */
        final InetSocketAddress socket = repNode.getSocket();
        return new MasterValue(socket.getAddress().getHostAddress(),
                               socket.getPort(),
                               repNode.getNameIdPair());
    }

    public long getRanking(Proposal proposal) {
        if (forceAsMaster) {
            return PREMPTIVE_RANKING;
        }
        repNode.getVLSNFreezeLatch().freeze(proposal);

        if (repNode.getMasterStatus().isGroupMaster()) {
            return MASTER_RANKING;
        }

        return repNode.getVLSNIndex().getRange().getLast().getSequence();
    }

    /**
     * This entry point is for testing only.
     *
     * It will submit a Proposal with a premptive ranking so that it's
     * guaranteed to be the selected as the master at the next election.
     *
     * @param force determines whether the forced proposal is in effect
     */
    public void forceMaster(boolean force) {
        this.forceAsMaster = force;
    }
}
