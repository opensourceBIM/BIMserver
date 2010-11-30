/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep.impl.node;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.rep.ReplicatedEnvironment;
import com.sleepycat.je.rep.StateChangeEvent;
import com.sleepycat.je.rep.StateChangeListener;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * NodeState encapsulates the current replicator state, and the ability to wait
 * for state transition and fire state change notifications.
 */
public class NodeState {
    /* The rep impl whose state is being tracked. */
    private final RepImpl repImpl;

    /* The application registered state change listener for this node. */
    private StateChangeListener stateChangeListener = null;

    /* The state change event that resulted in the current state. */
    private StateChangeEvent stateChangeEvent = null;
    private final AtomicReference<ReplicatedEnvironment.State> currentState;
    private final Logger logger;
    private final NameIdPair nameIdPair;

    public NodeState(NameIdPair nameIdPair,
                     RepImpl repImpl) {

        currentState = new AtomicReference<ReplicatedEnvironment.State>
            (ReplicatedEnvironment.State.DETACHED);
        this.nameIdPair = nameIdPair;
        this.repImpl = repImpl;
        logger = LoggerUtils.getLogger(getClass());
    }

    synchronized public
        void setChangeListener(StateChangeListener stateChangeListener){
        this.stateChangeListener = stateChangeListener;
    }

    synchronized public StateChangeListener getChangeListener() {
        return stateChangeListener;
    }

    /**
     * Change to a new node state and release any threads waiting for a state
     * transition.
     */
    synchronized public void changeAndNotify(ReplicatedEnvironment.State state,
                                             NameIdPair masterNameId) {

        ReplicatedEnvironment.State newState = state;
        ReplicatedEnvironment.State oldState = currentState.getAndSet(state);
        stateChangeEvent = new StateChangeEvent(state, masterNameId);

        LoggerUtils.finest(logger, repImpl, 
                           "state change from " + oldState + " to " + 
                           newState);


        if (stateChangeListener != null) {
            try {
                stateChangeListener.stateChange(stateChangeEvent);
            } catch (Exception e) {
                LoggerUtils.severe(logger, repImpl, 
                                   "State Change listener exception" + 
                                   e.getMessage());
                throw new EnvironmentFailureException
                    (repImpl, EnvironmentFailureReason.LISTENER_EXCEPTION, e);
            }
        }

        /* Make things obvious in thread dumps */
        Thread.currentThread().setName(currentState + " " + nameIdPair);
    }

    synchronized public ReplicatedEnvironment.State getRepEnvState() {
        return currentState.get();
    }

    synchronized public StateChangeEvent getStateChangeEvent() {
        return stateChangeEvent;
    }
}
