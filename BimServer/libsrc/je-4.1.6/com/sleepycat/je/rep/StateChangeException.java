/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.rep;

import java.util.Date;

import com.sleepycat.je.OperationFailureException;
import com.sleepycat.je.txn.Locker;

/**
 * Provides a synchronous mechanism for informing an application about a change
 * in the state of the replication node. StateChangeException is an abstract
 * class, with subtypes for each type of Transition.
 * <p>
 * A single state change can result in multiple state change exceptions (one
 * per thread operating against the environment). Each exception is associated
 * with the event that provoked the exception. The application can use this
 * association to ensure that each such event is processed just once.
 */
public abstract class StateChangeException extends OperationFailureException {
    private static final long serialVersionUID = 1;

    /* Null if the event is not available. */
    private final StateChangeEvent stateChangeEvent;

    /**
     * For internal use only.
     * @hidden
     */
    protected StateChangeException(Locker locker,
                                   StateChangeEvent stateChangeEvent) {
        super(locker, (locker != null),
              makeMessage(stateChangeEvent), null);
        this.stateChangeEvent = stateChangeEvent;
    }

    /**
     * Returns the event that resulted in this exception.
     *
     * @return the state change event
     */
    public StateChangeEvent getEvent() {
        return stateChangeEvent;
    }

    private static String makeMessage(StateChangeEvent event) {
        return (event != null) ?
              ("The current state is:" + event.getState() + "." +
                " The node transitioned to this state at:" +
                 new Date(event.getEventTime())) :
               "Node state inconsistent with operation";
    }

    /**
     * For internal use only.
     * @hidden
     * Only for use by wrapSelf methods.
     */
    protected StateChangeException(String message,
                                   StateChangeException cause) {
        super(message, cause);
        stateChangeEvent =
            (cause != null) ? cause.stateChangeEvent : null;
    }
}
