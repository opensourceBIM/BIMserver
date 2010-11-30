/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * MasterReplicaTransitionException is thrown in JE replication systems when
 * this environment is a master and must transition to replica state. In some
 * cases,the environment must reinitialize internal state to become a replica.
 * MasterReplicaTransitionException is a {@link RestartRequiredException}, and
 * the application must close and reopen its environment handle, thereby
 * properly reinitializing the node.
 */
public class MasterReplicaTransitionException 
    extends RestartRequiredException {

    private static final long serialVersionUID = 1;

    public MasterReplicaTransitionException(EnvironmentImpl envImpl,
                                            Exception cause) {
        super(envImpl, 
              EnvironmentFailureReason.MASTER_TO_REPLICA_TRANSITION, 
              cause);
    }

    /**
     * @hidden
     * For internal use only.
     */
    public MasterReplicaTransitionException
        (String message, 
         MasterReplicaTransitionException cause) {
        super(message, cause);
    }

    /**
     * @hidden
     * For internal use only.
     */
    @Override
    public EnvironmentFailureException wrapSelf(String msg) {
        return new MasterReplicaTransitionException(msg, this);
    }
}
