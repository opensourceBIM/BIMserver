/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.util.Set;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.utilint.VLSN;

/**
 * This exception indicates that the log files constituting the Environment are
 * insufficient and cannot be used as the basis for continuing with the
 * replication stream provided by the current master.
 * <p>
 * This exception is typically thrown by the ReplicatedEnvironment constructor
 * when a node has been down for a long period of time and is being started up
 * again. It may also be thrown when a brand new node attempts to become a
 * member of the group and it does not have a sufficiently current set of log
 * files. If the group experiences sustained network connectivity problems,
 * this exception may also be thrown by an active Replica that has been unable
 * to stay in touch with the members of its group for an extended period of
 * time.
 * <p>
 * In the typical case, application handles the exception by invoking
 * {@link NetworkRestore#execute} to obtain the log files it needs from one of
 * the members of the replication group. After the log files are obtained, the
 * node recreates its environment handle and resumes participation as an active
 * member of the group.
 *
 * @see NetworkRestore
 */
public class InsufficientLogException extends RestartRequiredException {
    private static final long serialVersionUID = 1;

    /* The replication node that encountered the exception. */
    private transient final RepNode repNode;

    /*
     * The refreshed log files must cover at least this VLSN, so that a syncup
     * is guaranteed to succeed.
     */
    private final VLSN refreshVLSN;

    /* Candidate nodes for a log file refresh. */
    private final Set<ReplicationNode> logProviders;

    /**
     * @hidden
     */
    private InsufficientLogException(RepNode repNode,
                                     VLSN refreshVLSN,
                                     Set<ReplicationNode> logProviders,
                                     Exception cause) {
        super(repNode.getRepImpl(),
              EnvironmentFailureReason.INSUFFICIENT_LOG, cause);
        this.repNode = repNode;
        this.refreshVLSN = refreshVLSN;
        this.logProviders = logProviders;
    }

    /**
     * @hidden
     *
     * Creates an instance of the exception and packages up the information
     * needed by NetworkRestore.
     */
    public InsufficientLogException(RepNode repNode,
                                    VLSN    refreshVLSN,
                                    Set<ReplicationNode> hashSet) {
        this(repNode, refreshVLSN, hashSet, null /*cause*/);
    }

    /**
     * @hidden
     *
     * Used to create a copy of the original exception, that originated in a
     * different thread, so that the original call stack can be preserved.
     */
    public InsufficientLogException(InsufficientLogException cause) {
        this(cause.getRepNode(),
             cause.getRefreshVLSN(),
             cause.getLogProviders(),
             null /*cause*/);
    }

    /**
     * For internal use only.
     * @hidden
     */
    private InsufficientLogException(String message,
                                     InsufficientLogException cause) {
        super(message, cause);
        this.repNode = cause.getRepNode();
        this.refreshVLSN = cause.getRefreshVLSN();
        this.logProviders = cause.getLogProviders();
    }

    /**
     * For internal use only.
     * @hidden
     */
    @Override
    public EnvironmentFailureException wrapSelf(String msg) {
        return new InsufficientLogException(msg, this);
    }

    /**
     * @hidden
     *
     * Returns a VLSN identifying the amount of log information needed so that
     * this node is sufficiently consistent and can join the replication group.
     *
     * @return the VLSN identifying the amount of log information
     * required.
     */
    public VLSN getRefreshVLSN() {
        return refreshVLSN;
    }

    /**
     * Returns the members of the replication group that can serve as candidate
     * log providers to supply the logs needed by this node.
     *
     * @return a list of members that can provide logs
     */
    public Set<ReplicationNode> getLogProviders() {
        return logProviders;
    }

    /**
     * @hidden
     *
     * Returns the replication node whose log files need to be refreshed.
     */
    public RepNode getRepNode() {
        return repNode;
    }
}
