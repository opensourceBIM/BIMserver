/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.node;

import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.Durability.SyncPolicy;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.log.ChecksumException;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.rep.MasterReplicaTransitionException;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.RepParams;
import com.sleepycat.je.rep.stream.FeederReplicaHandshake;
import com.sleepycat.je.rep.stream.FeederReplicaSyncup;
import com.sleepycat.je.rep.stream.FeederSource;
import com.sleepycat.je.rep.stream.MasterFeederSource;
import com.sleepycat.je.rep.stream.MasterStatus;
import com.sleepycat.je.rep.stream.OutputWireRecord;
import com.sleepycat.je.rep.stream.Protocol;
import com.sleepycat.je.rep.stream.FeederReplicaSyncup.NetworkRestoreException;
import com.sleepycat.je.rep.stream.MasterStatus.MasterSyncException;
import com.sleepycat.je.rep.stream.Protocol.Ack;
import com.sleepycat.je.rep.stream.Protocol.HeartbeatResponse;
import com.sleepycat.je.rep.txn.MasterTxn;
import com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition;
import com.sleepycat.je.rep.utilint.NamedChannelWithTimeout;
import com.sleepycat.je.rep.utilint.RepUtils;
import com.sleepycat.je.rep.utilint.BinaryProtocol.Message;
import com.sleepycat.je.rep.vlsn.VLSNRange;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.StoppableThread;
import com.sleepycat.je.utilint.VLSN;

/**
 * There is an instance of a Feeder for each client that needs a replication
 * stream. Either a master, or replica (providing feeder services) may
 * establish a feeder.
 *
 * A feeder is created in response to a request from a Replica, and is shutdown
 * either upon loss of connectivity, or upon a change in mastership.
 *
 * The protocol used to validate and negotiate a connection is synchronous, but
 * once this phase has been completed, the communication between the feeder and
 * replica is asynchronous. To handle the async communications, the feeder has
 * two threads associated with it:
 *
 * 1) An output thread whose sole purpose is to pump log records (and if
 * necessary heart beat requests) down to the replica as fast as the network
 * will allow it
 *
 * 2) An input thread that listens for responses to transaction commits and
 * heart beat responses.
 */
final public class Feeder {
    /* In milliseconds, used to trigger a heart beat request. Is mutable */
    private int heartbeatInterval;

    /* The manager for all Feeder instances. */
    private final FeederManager feederManager;

    /* The replication node that is associated with this Feeder */
    private final RepNode repNode;
    /* The RepImpl that is associated with this rep node. */
    private final RepImpl repImpl;

    /* The socket on which the feeder communicates with the Replica. */
    private final NamedChannelWithTimeout feederReplicaChannel;

    /* The Threads that implement the Feeder */
    private final InputThread inputThread;
    private final OutputThread outputThread;

    /* The source of log records to be sent to the Replica. */
    private final FeederSource feederSource;

    /* Negotiated message protocol version for the replication stream. */
    private int protocolVersion;

    /*
     * The current position of the feeder, that is this VLSN that has been sent
     * next to the Replica.
     */
    private VLSN feederVLSN;

    /* The time that the feeder last heard from its Replica */
    @SuppressWarnings("unused")
    private volatile long lastResponseTime = 0l;

    /* Used to track the status of the master. */
    private final MasterStatus masterStatus;

    /*
     * Determines whether the Feeder has been shutdown. Usually this is held
     * within the StoppableThread, but the Feeder's two child threads have
     * their shutdown coordinated by the parent Feeder.
     */
    private final AtomicBoolean shutdown = new AtomicBoolean(false);

    private final Logger logger;

    /* The Feeder's node id. */
    private final NameIdPair nameIdPair;

    /*
     * The replica node id, that is, the node that is the recipient of the
     * replication stream. Its established at the time of the Feeder/Replica
     * handshake.
     */
    private NameIdPair replicaNameIdPair = NameIdPair.NULL;

    /*
     * The threshold used to trigger the logging of transfers of commit
     * records.
     */
    private static int TRANSFER_LOGGING_THRESHOLD_MS = 1000; // ms

    /**
     * Returns a configured SocketChannel
     *
     * @param channel the channel to be configured
     * @return the configured SocketChannel
     * @throws IOException
     */
    private NamedChannelWithTimeout configureChannel(SocketChannel channel)
        throws IOException {

        try {
            channel.configureBlocking(true);
            LoggerUtils.info
                (logger, repImpl, "Feeder accepted connection from " + channel);
            final int timeoutMs = repNode.getConfigManager().
                getDuration(RepParams.PRE_HEARTBEAT_TIMEOUT);
            /* Disable Nagle's algorithm. */
            channel.socket().setTcpNoDelay(true);
            return new NamedChannelWithTimeout(repNode, channel, timeoutMs);
        } catch (IOException e) {
            LoggerUtils.warning(logger, repImpl,
                                "IO exception while configuring channel " +
                                "Exception:" + e.getMessage());
            throw e;
        }
    }

    Feeder(FeederManager feederManager, SocketChannel socketChannel)
        throws DatabaseException, IOException {

        this.feederManager = feederManager;
        this.repNode = feederManager.repNode();
        this.repImpl = repNode.getRepImpl();
        this.masterStatus = repNode.getMasterStatus();
        nameIdPair = repNode.getNameIdPair();
        this.feederSource = new MasterFeederSource(repNode.getRepImpl(),
                                                   repNode.getVLSNIndex(),
                                                   nameIdPair);
        logger = LoggerUtils.getLogger(getClass());

        this.feederReplicaChannel = configureChannel(socketChannel);
        inputThread = new InputThread(repNode.getRepImpl());
        outputThread = new OutputThread(repNode.getRepImpl());
        heartbeatInterval = feederManager.repNode().getHeartbeatInterval();
    }

    void startFeederThreads() {
        inputThread.start();
    }

    /**
     * @hidden
     * Place holder Feeder for testing only
     */
    public Feeder() {
        feederManager = null;
        repNode = null;
        repImpl = null;
        masterStatus = null;
        feederSource = null;
        feederReplicaChannel = null;
        nameIdPair = NameIdPair.NULL;
        logger = LoggerUtils.getLoggerFixedPrefix(getClass(), "TestFeeder");
        inputThread = null;
        outputThread = null;
        shutdown.set(true);
    }

    /* Get the protocol stats of this Feeder. */
    public StatGroup getProtocolStats(StatsConfig config) {
        final Protocol protocol = outputThread.protocol;

        return (protocol != null) ?
               protocol.getStats(config) :
               new StatGroup(BinaryProtocolStatDefinition.GROUP_NAME,
                             BinaryProtocolStatDefinition.GROUP_DESC);
    }

    void resetStats() {
        final Protocol protocol = outputThread.protocol;
        if (protocol != null) {
            protocol.resetStats();
        }
    }

    /**
     * Returns the channel between this Feeder and its Replica.
     *
     * @return the channel
     */
    public SocketChannel getFeederReplicaChannel() {
        return feederReplicaChannel.getChannel();
    }

    public RepNode getRepNode() {
        return repNode;
    }

    public NameIdPair getReplicaNameIdPair() {
        return replicaNameIdPair;
    }

    /**
     * Shutdown the feeder, closing its channel and releasing its threads.  May
     * be called internally upon noticing a problem, or externally when the
     * RepNode is shutting down.
     */
    void shutdown(Exception shutdownException) {

        boolean changed = shutdown.compareAndSet(false, true);
        if (!changed) {
            return;
        }

        feederManager.removeFeeder(this);

        StatGroup pstats = (inputThread.protocol != null) ?
            inputThread.protocol.getStats(StatsConfig.DEFAULT) :
            new StatGroup(BinaryProtocolStatDefinition.GROUP_NAME,
                          BinaryProtocolStatDefinition.GROUP_DESC);
        if (outputThread.protocol != null) {
            pstats.addAll(outputThread.protocol.getStats(StatsConfig.DEFAULT));
        }
        feederManager.incStats(pstats);

        LoggerUtils.info(logger, repImpl,
                         "Shutting down feeder for replica " +
                         replicaNameIdPair.getName() +
                         ((shutdownException == null) ?
                          "" :
                          (" Reason: " + shutdownException.getMessage())) +
                         RepUtils.writeTimesString(pstats));

        if (repNode.getReplicaCloseCatchupMs() >= 0) {

            /*
             * Need to shutdown the group cleanly, wait for it to let the
             * replica catchup and exit in the allowed time period.
             */
            try {

                /*
                 * Note that we wait on the Input thread, since it's the one
                 * that will exit on the ShutdownResponse message from the
                 * Replica. The output thread will exit immediately after
                 * sending the ShutdownRequest.
                 */
                inputThread.join();
                /* Timed out, or the input thread exited; keep going. */
            } catch (InterruptedException e) {
                LoggerUtils.warning(logger, repImpl,
                                    "Interrupted while waiting to join " +
                                    "thread:" + outputThread);
            }
        }

        outputThread.shutdownThread(logger);
        inputThread.shutdownThread(logger);

        LoggerUtils.finest(logger, repImpl,
                           feederReplicaChannel + " isOpen=" +
                           feederReplicaChannel.getChannel().isOpen());
    }

    public boolean isShutdown() {
        return shutdown.get();
    }

    /**
     * Used by InputThread and OutputThread to decide what to do with a
     * MasterSyncException. As explained in [#19177], masters cannot transition
     * to replica without requiring an environment recovery.  Usually, a master
     * would issue a MasterReplicaTransitionException in this case. However, if
     * the feederManager has issued a shutdown already we can ignore the
     * MasterSync exception, as it is the natural aftermath of a
     * shutdown. [#19177]
     */
    private void checkMasterReplicaTransition(MasterSyncException syncEx) 
        throws MasterReplicaTransitionException {

        if (isShutdown()) {
            /* This exception is expected  */
            return;
        }

        /* 
         * [#19177] We don't let a master transition to a replica state without
         * an environment shutdown. See explanation in FeederManager.
         */
        throw new MasterReplicaTransitionException(repImpl, syncEx);
    }

    /**
     * Implements the thread responsible for processing the responses from a
     * Replica.
     */
    private class InputThread extends StoppableThread {

        Protocol protocol = null;
        private LocalCBVLSNUpdater replicaCBVLSN;

        InputThread(RepImpl repImpl) {
            /* 
             * The thread will be renamed later on during the life of this
             * thread, when we're sure who the replica is.
             */
            super(repImpl, new IOThreadsHandler(), "Feeder Input");
        }

        /**
         * Does the initial negotiation to validate replication group wide
         * consistency and establish the starting VLSN. It then starts up the
         * Output thread and enters the response loop.
         */
        @Override
        public void run() {

            /* Set to indicate an error-initiated shutdown. */
            Error feederInputError = null;
            Exception shutdownException = null;

            try {
                FeederReplicaHandshake handshake =
                    new FeederReplicaHandshake(repNode,
                                               Feeder.this,
                                               feederReplicaChannel);
                protocol = handshake.execute();
                protocolVersion = protocol.getVersion();
                replicaNameIdPair = handshake.getReplicaNameIdPair();

                /*
                 * Rename the thread when we get the replica name in, so that
                 * it's clear who is on the other end.
                 */
                Thread.currentThread().setName("Feeder Input for " +
                                               replicaNameIdPair.getName());

                FeederReplicaSyncup syncup =
                    new FeederReplicaSyncup(Feeder.this,
                                            feederReplicaChannel,
                                            protocol);

                /*
                 * The replicaCBVLSN can only be instantiated after we know the
                 * replica's name. We need to pass the updater into
                 * FeederReplicaSyncup so that the replica's local CBVLSN can
                 * be updated while the global CBVLSN update is locked out.
                 */
                this.replicaCBVLSN = new LocalCBVLSNUpdater(replicaNameIdPair,
                                                            repNode);
                feederVLSN = syncup.execute(replicaCBVLSN);
                feederSource.init(feederVLSN);

                /* Start the thread to pump out log records */
                outputThread.start();
                lastResponseTime = System.currentTimeMillis();
                masterStatus.assertSync();
                feederManager.activateFeeder(Feeder.this);

                runResponseLoop();
            } catch (NetworkRestoreException e) {
                shutdownException = e;
                /* The replica will retry after a network restore. */
                LoggerUtils.info(logger, repImpl, e.getMessage());
            } catch (IOException e) {
                /* Trio of benign "expected" exceptions below. */
                shutdownException = e; /* Expected. */
            } catch (MasterSyncException e) {
                checkMasterReplicaTransition(e) ;
                shutdownException = e; /* Expected. */
            } catch (InterruptedException e) {
                shutdownException = e; /* Expected. */
            } catch (ExitException e) {
                shutdownException = e;
                LoggerUtils.warning(logger, repImpl,
                                    "Exiting feeder loop: " + e.getMessage());
            } catch (Error e) {
                feederInputError = e;
                repNode.getRepImpl().invalidate(e);
            } catch (ChecksumException e) {
                shutdownException = e;

                /* An internal, unexpected error. Invalidate the environment. */
                throw new EnvironmentFailureException
                    (repNode.getRepImpl(),
                     EnvironmentFailureReason.LOG_CHECKSUM, e);
            } catch (RuntimeException e) {
                shutdownException = e;

                /*
                 * An internal error. Shut down the rep node as well for now
                 * by throwing the exception out of the thread.
                 *
                 * In future we may want to close down just the impacted Feeder
                 * but this is the safe course of action.
                 */
                LoggerUtils.severe(logger, repImpl,
                                   "Unexpected exception: " + e.getMessage() +
                                   LoggerUtils.getStackTrace(e));
                throw e;
            } finally {
                if (feederInputError != null) {
                    /* Propagate the error, skip cleanup. */
                    throw feederInputError;
                }

                /*
                 * Shutdown the feeder in its entirety, in case the input
                 * thread is the only one to notice a problem. The Replica can
                 * decide to re-establish the connection
                 */
                shutdown(shutdownException);
                cleanup();
            }
        }

        /*
         * This method deals with responses from the Replica. There are exactly
         * two types of responses from the Replica:
         *
         * 1) Responses acknowledging a successful commit by the Replica.
         *
         * 2) Responses to heart beat messages.
         *
         * This loop (like the loop in the OutputThread) is terminated under
         * one of the following conditions:
         *
         * 1) The thread detects a change in masters.
         * 2) There is network connection issue (which might also be an
         *    indication of an unfolding change in masters).
         * 3) If the replica closes its connection -- variation of the above.
         *
         * In addition, the loop will also exit if it gets a ShutdownResponse
         * message sent in response to a ShutdownRequest sent by the
         * OutputThread.
         */
        private void runResponseLoop()
            throws IOException, MasterSyncException {

            /*
             * Start the acknowledgment loop. It's very important that this
             * loop be wait/contention free.
             */
            while (!checkShutdown()) {
                Message response = protocol.read(feederReplicaChannel);
                if (checkShutdown()) {

                    /*
                     * Shutdown quickly, in particular, don't update sync
                     * VLSNs.
                     */
                    break;
                }
                masterStatus.assertSync();

                lastResponseTime = System.currentTimeMillis();

                if (response.getOp() == Protocol.HEARTBEAT_RESPONSE) {
                    /* Last response has been updated, keep going. */
                    HeartbeatResponse hbResponse =
                        (Protocol.HeartbeatResponse)response;
                    replicaCBVLSN.updateForReplica(hbResponse);
                    continue;
                } else if (response.getOp() == Protocol.ACK) {

                    /*
                     * Check if a commit has been waiting for this
                     * acknowledgment and signal any waiters.
                     */
                    long txnId = ((Ack) response).getTxnId();
                    if (logger.isLoggable(Level.FINE)) {
                        LoggerUtils.fine(logger, repImpl, "Ack for: " + txnId);
                    }
                    repNode.getFeederTxns().noteReplicaAck(txnId);
                    continue;
                } else if (response.getOp() == Protocol.SHUTDOWN_RESPONSE) {
                    LoggerUtils.info(logger, repImpl,
                                     "Shutdown confirmed by replica " +
                                     replicaNameIdPair.getName());
                    /* Exit the loop and the thread. */
                    break;
                } else {
                    throw EnvironmentFailureException.unexpectedState
                        ("Unexpected message: " + response);
                }
            }
        }

        /*
         * Returns true if the InputThread should be shutdown, that is, if the
         * thread has been marked for shutdown and it's not a group shutdown
         * request. For a group shutdown the input thread will wait for an
         * acknowledgment of the shutdown message from the Replica.
         */
        private boolean checkShutdown() {
            return shutdown.get() &&
                   (repNode.getReplicaCloseCatchupMs() < 0);
        }

        @Override
        protected int initiateSoftShutdown() {

            /*
             * Provoke an I/O exception that will cause the input thread to
             * exit.
             */
            RepUtils.shutdownChannel(feederReplicaChannel);
            return repNode.getThreadWaitInterval();
        }

        @Override
        protected Logger getLogger() {
            return logger;
        }
    }

    /*
     * If non-0, then after sprayAfterNMessagesCount enter a tight loop and
     * continuously spray the same message. Used for network bandwidth testing.
     * See ScaleTest.
     */
    private static long sprayAfterNMessagesCount = 0;

    public static void setSprayAfterNMessagesCount(long sANMC) {
        sprayAfterNMessagesCount = sANMC;
    }

    /**
     * Simply pumps out log entries as rapidly as it can.
     */
    private class OutputThread extends StoppableThread {
        /* Tracks when the last heartbeat was sent. */
        private long lastHeartbeat = 0l;

        Protocol protocol = null;

        private long totalTransferDelay = 0;

        /* The time at which the group shutdown was initiated. */
        private long shutdownRequestStart = 0;

        private final RepImpl threadRepImpl;

        OutputThread(RepImpl repImpl) {
            /*
             * The thread will be renamed later on during the life of this 
             * thread, when we know who the replica is.
             */
            super(repImpl, new IOThreadsHandler(), "Feeder Output");
            this.threadRepImpl = repImpl;
        }

        /**
         * Determines whether we should exit the output loop. If we are trying
         * to shutdown the Replica cleanly, that is, this is a group shutdown,
         * the method delays the shutdown until the Replica has had a chance
         * to catch up to the current commit VLSN on this node, after which
         * it sends the Replica a Shutdown message.
         *
         * @return true if the output thread should be shutdown.
         *
         * @throws IOException
         */
        private boolean checkShutdown()
            throws IOException {

            if (!shutdown.get()) {
                return false;
            }
            if (repNode.getReplicaCloseCatchupMs() >= 0) {
                if (shutdownRequestStart == 0) {
                    shutdownRequestStart = System.currentTimeMillis();
                }
                /* Determines if the feeder has waited long enough. */
                boolean timedOut  =
                    (System.currentTimeMillis() - shutdownRequestStart) >
                    repNode.getReplicaCloseCatchupMs();
                if (!timedOut &&
                    (feederVLSN.compareTo
                                (repNode.getCurrentCommitVLSN()) < 0)) {
                    /* Replica is not caught up. */
                    return false;
                }
                /* Replica is caught up or has timed out, shut it down. */
                protocol.write(protocol.new
                               ShutdownRequest(shutdownRequestStart),
                               feederReplicaChannel);

                String shutdownMessage =
                    String.format("Shutdown message sent to: %s " +
                                  " Shutdown elapsed time: %,dms",
                                  replicaNameIdPair,
                                  (System.currentTimeMillis() -
                                   shutdownRequestStart));
                LoggerUtils.info(logger, threadRepImpl, shutdownMessage);
                return true;
            }
            return true;
        }

        @Override
        public void run() {
            protocol = Protocol.get(repNode, protocolVersion);
            Thread.currentThread().setName
                ("Feeder Output for " +
                 Feeder.this.getReplicaNameIdPair().getName());

            final int testDelayMs = feederManager.getTestDelayMs();
            if (testDelayMs > 0) {
                LoggerUtils.info(logger, threadRepImpl,
                                 "Test delay of:" + testDelayMs + "ms." +
                                 " after each message sent");
            }

            {
                VLSNRange range = repNode.getVLSNIndex().getRange();
                LoggerUtils.info
                    (logger, threadRepImpl, String.format
                     ("Feeder output thread for replica %s started at " +
                      "VLSN %,d master at %,d VLSN delta=%,d socket=%s",
                      replicaNameIdPair.getName(),
                      feederVLSN.getSequence(),
                      range.getLast().getSequence(),
                      range.getLast().getSequence() - feederVLSN.getSequence(),
                      feederReplicaChannel));
            }

            /* Set to indicate an error-initiated shutdown. */
            Error feederOutputError = null;
            Exception shutdownException = null;
            try {

                /*
                 *  Always start out with a heartbeat; the replica is counting
                 *  on it.
                 */
                sendHeartbeat();
                final int timeoutMs = repNode.getConfigManager().
                        getDuration(RepParams.FEEDER_TIMEOUT);
                feederReplicaChannel.setTimeoutMs(timeoutMs);

                while (!checkShutdown()) {
                    if (feederVLSN.compareTo
                            (repNode.getCurrentCommitVLSN()) >= 0) {

                        /*
                         * The replica is caught up, if we are a Primary stop
                         * playing that role, and start requesting acks from
                         * the replica.
                         */
                        repNode.passivatePrimary();
                    }
                    OutputWireRecord record = feederSource.getWireRecord
                        (feederVLSN, heartbeatInterval);

                    masterStatus.assertSync();
                    if (record == null) {
                        /* No new log entry, timed out wait. */
                        sendHeartbeat();
                    } else {
                        Message entry = createMessage(record);
                        validate(record);

                        maybeSpray(entry, record);

                        protocol.write(entry, feederReplicaChannel);
                        sendHeartbeat();
                        feederVLSN = feederVLSN.getNext();
                    }

                    /*
                     * Socket has Nagle's algorithm turned off, that is,
                     * tcp_nodelay is true, so packets are not buffered.
                     */
                    if (testDelayMs > 0) {
                        Thread.sleep(testDelayMs);
                    }
                }

            } catch (IOException e) {
                /* Trio of benign "expected" exceptions below. */
                shutdownException = e;  /* Expected. */
            } catch (MasterSyncException e) {
                checkMasterReplicaTransition(e) ;
                shutdownException = e; /* Expected. */
            } catch (InterruptedException e) {
                /* Expected, shutdown just the feeder. */
                shutdownException = e;  /* Expected. */
            } catch (RuntimeException e) {
                shutdownException = e;

                /*
                 * An internal error. Shut down the rep node as well for now
                 * by throwing the exception out of the thread.
                 *
                 * In future we may want to close down just the impacted
                 * Feeder but this is the safe course of action.
                 */
                LoggerUtils.severe(logger, threadRepImpl,
                                   "Unexpected exception: " + e.getMessage() +
                                   LoggerUtils.getStackTrace(e));
                throw e;
            } catch (Error e) {
                feederOutputError = e;
                repNode.getRepImpl().invalidate(e);
            } finally {
                if (feederOutputError != null) {
                    /* Propagate the error, skip cleanup. */
                    throw feederOutputError;
                }
                LoggerUtils.info(logger, threadRepImpl,
                                 "Feeder output for replica " +
                                 replicaNameIdPair.getName() +
                                 " shutdown. feeder VLSN: " + feederVLSN +
                                 " currentCommitVLSN: " +
                                 repNode.getCurrentCommitVLSN());

                /*
                 * Shutdown the feeder in its entirety, in case the output
                 * thread is the only one to notice a problem. The Replica can
                 * decide to re-establish the connection
                 */
                shutdown(shutdownException);
                cleanup();
            }
        }

        /* Check if spray count has been reached and if so, start spraying. */
        final void maybeSpray(Message entry, OutputWireRecord record)
            throws IOException {

            if (--sprayAfterNMessagesCount == 0) {
                /* Ensure only LN_TX's get sprayed. */
                if (record.getEntryType() !=
                    LogEntryType.LOG_LN_TRANSACTIONAL.getTypeNum()) {
                    sprayAfterNMessagesCount++;
                    return;
                }
                LoggerUtils.info(logger, threadRepImpl,
                                 "Initiating message spray: " + entry);
                while (true) {
                    protocol.write(entry, feederReplicaChannel);
                }
            }
        }

        /**
         * Sends a heartbeat message, if we have exceeded the heartbeat
         * interval.
         *
         * @param protocol protocol to use for the heartbeat.
         *
         * @throws IOException
         */
        private void sendHeartbeat()
            throws IOException {

            long now = System.currentTimeMillis();
            long interval = now - lastHeartbeat;

            if (interval <= heartbeatInterval) {
                return;
            }
            VLSN vlsn = repNode.getCurrentCommitVLSN();
            protocol.write(protocol.new Heartbeat(now, vlsn.getSequence()),
                           feederReplicaChannel);
            lastHeartbeat = now;
        }

        @Override
        protected int initiateSoftShutdown() {

            /*
             * Provoke an I/O exception that will cause the output thread to
             * exit.
             */
            RepUtils.shutdownChannel(feederReplicaChannel);
            return repNode.getThreadWaitInterval();
        }

        /**
         * Converts a log entry into a specific Message to be sent out by the
         * Feeder.
         *
         * @param logBytes the bytes representing the log entry
         *
         * @return the Message representing the entry
         *
         * @throws DatabaseException
         */
        private Message createMessage(OutputWireRecord wireRecord)
            throws DatabaseException {

            long txnId = wireRecord.getCommitTxnId();

            if (txnId != 0) {
                /* A commit log entry */
                MasterTxn ackTxn = repNode.getFeederTxns().getAckTxn(txnId);
                if (ackTxn != null) {
                    ackTxn.stampRepWriteTime();
                    long messageTransferMs = ackTxn.messageTransferMs();
                    totalTransferDelay  += messageTransferMs;
                    if (messageTransferMs > TRANSFER_LOGGING_THRESHOLD_MS) {
                        LoggerUtils.info(logger, threadRepImpl,
                                         (String.format
                                          ("Feeder for: %s, Txn: %,d " +
                                           " log to rep stream time %,dms." +
                                           " Total transfer time: %,dms.",
                                           replicaNameIdPair.getName(),
                                           txnId, messageTransferMs,
                                           totalTransferDelay)));
                    }
                }
                SyncPolicy replicaSync =
                    (ackTxn != null) ?
                    ackTxn.getCommitDurability().getReplicaSync() :

                    /*
                     * Replica is catching up. Specify the weakest and leave it
                     * up to the replica.
                     */
                    SyncPolicy.NO_SYNC;
                return protocol.new Commit((ackTxn != null),
                                           replicaSync,
                                           wireRecord);
            }
            /* A vanilla entry */
            return protocol.new Entry(wireRecord);
        }

        /**
         * Sanity check the outgoing record.
         */
        private void validate(OutputWireRecord record) {

            /* Check that we've fetched the right message. */
            if (!record.getVLSN().equals(feederVLSN)) {
                throw EnvironmentFailureException.unexpectedState
                    ("Expected VLSN:" + feederVLSN + " log entry VLSN:" +
                     record.getVLSN());
            }

            if (!threadRepImpl.isConverted()) {
                assert record.verifyNegativeSequences("node=" + nameIdPair);
            }
        }

        @Override
        protected Logger getLogger() {
            return logger;
        }
    }

    /**
     * Defines the handler for the RepNode thread. The handler invalidates the
     * environment by ensuring that an EnvironmentFailureException is in place.
     *
     * The handler communicates the cause of the exception back to the
     * FeederManager's thread by setting the repNodeShutdownException and then
     * interrupting the FM thread. The FM thread upon handling the interrupt
     * notices the exception and propagates it out in turn to other threads
     * that might be coordinating activities with it.
     */
    private class IOThreadsHandler implements UncaughtExceptionHandler {

        public void uncaughtException(Thread t, Throwable e) {
            LoggerUtils.severe(logger, repImpl,
                               "Uncaught exception in feeder thread " + t +
                               e.getMessage() +
                               LoggerUtils.getStackTrace(e));

            /* Bring the exception to the parent thread's attention. */
            feederManager.setRepNodeShutdownException
                (EnvironmentFailureException.promote
                 (repNode.getRepImpl(),
                  EnvironmentFailureReason.UNCAUGHT_EXCEPTION,
                  "Uncaught exception in feeder thread:" + t,
                  e));

            /*
             * Bring it to the FeederManager's attention, it's currently the
             * same as the rep node's thread.
             */
            repNode.interrupt();
        }
    }

    /**
     * A marker exception that wraps the real exception. It indicates that the
     * wrapped exception was sufficient cause to exit the Feeder, but not the
     * RepNode.
     */
    @SuppressWarnings("serial")
    public static class ExitException extends Exception {

        public ExitException(String message) {
            super(message);
        }

        public ExitException(Throwable cause) {
            super(cause);
        }

    }

    /**  For debugging and exception messages. */
    public String dumpState() {
        return "feederVLSN=" + feederVLSN;
    }
}
