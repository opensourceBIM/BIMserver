/*
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

/**
 * @see com.sleepycat.je.EnvironmentFailureException
 */
public enum EnvironmentFailureReason {

    ENV_LOCKED
        (false /*invalidates*/,
         "The je.lck file could not be locked."),
    ENV_NOT_FOUND
        (false /*invalidates*/,
         "EnvironmentConfig.setAllowCreate is false so environment " +
         "creation is not permitted, but there are no log files in the " +
         "environment directory."),
    HANDSHAKE_ERROR
        (true /*invalidates*/,
         "Error during the handshake between two nodes. " +
         "Some validity or compatibility check failed, " +
         "preventing further communication between the nodes."),
    HARD_RECOVERY
        (true /*invalidates*/,
         "Rolled back past transaction commit or abort. Must run recovery by" +
         " re-opening Environment handles"),
    JAVA_ERROR
        (true /*invalidates*/,
         "Java Error occurred, recovery may not be possible."),
    LATCH_ALREADY_HELD
        (false /*invalidates*/,
         "Attempt to acquire a latch that is already held, " +
         "may cause a hard deadlock."),
    LATCH_NOT_HELD
        (false /*invalidates*/,
         "Attempt to release a latch that is not currently not held, " +
         "may indicate a thread safety problem."),
    LISTENER_EXCEPTION
        (true, /* invalidates. */
         "An exception was thrown from an application supplied Listener."),
    LOG_CHECKSUM
        (true /*invalidates*/,
         "Checksum invalid on read, log is likely invalid."),
    LOG_FILE_NOT_FOUND
        (true /*invalidates*/,
         "Log file missing, log is likely invalid."),
    LOG_INCOMPLETE
        (true /*invalidates*/,
         "Transaction logging is incomplete, replica is invalid."),
    LOG_INTEGRITY
        (false /*invalidates*/,
         "Log information is incorrect, problem is likely persistent."),
    LOG_READ
        (true /*invalidates*/,
         "IOException on read, log is likely invalid."),
    INSUFFICIENT_LOG
        (true /*invalidates*/,
         "Log files at this node are obsolete."),
    LOG_WRITE
        (true /*invalidates*/,
         "IOException on write, log is likely incomplete."),
    MASTER_TO_REPLICA_TRANSITION
        (true /*invalidates*/,
         "This node was a master and must reinitialize internal state to " +
         "become a replica. The application must close and reopen all " +
         "handles."),
    MONITOR_REGISTRATION
        (false /*invalidates*/,
         "JMX JE monitor could not be registered."),
    PROTOCOL_VERSION_MISMATCH
        (true /*invalidates*/,
         "Two communicating nodes could not agree on a common protocol " +
         "version."),
    ROLLBACK_PROHIBITED
        (true /*invalidates*/,
         "Node would like to roll back past committed transactions, but " +
         "would exceed the limit specified by je.rep.txnRollbackLimit. " +
         "Manual intervention required."),
    SHUTDOWN_REQUESTED
        (true /*invalidates*/,
        "The Replica was shutdown via a remote shutdown request."),
    TEST_INVALIDATE
        (true /*invalidates*/,
         "Test program invalidated the environment."),
    THREAD_INTERRUPTED
        (true /*invalidates*/,
         "InterruptedException may cause incorrect internal state, " +
         "unable to continue."),
    UNCAUGHT_EXCEPTION
        (true /*invalidates*/,
         "Uncaught Exception in internal thread, unable to continue."),
    UNEXPECTED_EXCEPTION
        (false /*invalidates*/,
         "Unexpected internal Exception, may have side effects."),
    UNEXPECTED_EXCEPTION_FATAL
        (true /*invalidates*/,
         "Unexpected internal Exception, unable to continue."),
    UNEXPECTED_STATE
        (false /*invalidates*/,
         "Unexpected internal state, may have side effects."),
    UNEXPECTED_STATE_FATAL
        (true /*invalidates*/,
         "Unexpected internal state, unable to continue."),
    VERSION_MISMATCH
        (false /*invalidates*/,
         "The existing log was written with a version of JE that is " +
         "later than the running version of JE, the log cannot be read.");

    private final boolean invalidates;
    private final String description;

    private EnvironmentFailureReason(boolean invalidates, String description) {
        this.invalidates = invalidates;
        this.description = description;
    }

    public boolean invalidatesEnvironment() {
        return invalidates;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + description;
    }
}
