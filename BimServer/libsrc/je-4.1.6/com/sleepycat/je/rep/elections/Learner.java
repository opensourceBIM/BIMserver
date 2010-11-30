/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.elections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.UnknownMasterException;
import com.sleepycat.je.rep.elections.Proposer.Proposal;
import com.sleepycat.je.rep.elections.Protocol.MasterQueryResponse;
import com.sleepycat.je.rep.elections.Protocol.Result;
import com.sleepycat.je.rep.elections.Protocol.Value;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.TextProtocol.InvalidMessageException;
import com.sleepycat.je.rep.impl.TextProtocol.MessageExchange;
import com.sleepycat.je.rep.impl.TextProtocol.RequestMessage;
import com.sleepycat.je.rep.impl.TextProtocol.ResponseMessage;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.utilint.ServiceDispatcher;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StoppableThread;
import com.sleepycat.je.utilint.StoppableThreadFactory;

/**
 * The Learner agent. It runs in its own dedicated thread, listening for
 * messages announcing the results of elections. The Learner in turn invokes
 * Listeners within the process to propagate the result.
 */
public class Learner extends ElectionAgentThread {

    /* The service dispatcher used by the Learner */
    private final ServiceDispatcher serviceDispatcher;

    /* The listeners interested in Election outcomes. */
    private final List<Listener> listeners = new LinkedList<Listener>();

    /* The latest winning proposal and value known to the Listener */
    private Proposal currentProposal = null;
    private Value currentValue = null;

    /* Identifies the Learner Service. */
    public static final String SERVICE_NAME = "Learner";

    /**
     * Creates an instance of a Learner which will listen for and propagate
     * messages to local Listeners.
     *
     * Note that this constructor, does not take a repNode as an argument, so
     * that it can be used as the basis for the standalone Monitor.
     *
     * @param protocol the protocol used for message exchange.
     *
     * @param nameIdPair a unique identifier for this election module
     *
     * @throws IOException if the listener socket could not be established.
     */
    public Learner(Protocol protocol,
                   ServiceDispatcher serviceDispatcher,
                   NameIdPair nameIdPair)
        throws IOException {

       this(null, protocol, serviceDispatcher, nameIdPair);
    }

    public Learner(Protocol protocol, RepNode repNode) {
        this(repNode, protocol, repNode.getServiceDispatcher(),
             repNode.getNameIdPair());
    }

    private Learner(RepNode repNode,
                    Protocol protocol,
                    ServiceDispatcher serviceDispatcher,
                    NameIdPair nameIdPair) {
        super(repNode, protocol, nameIdPair,
              "Learner Thread " + nameIdPair.getName());
        this.serviceDispatcher = serviceDispatcher;

        /* Add a listener for logging. */
        addListener(new Listener() {
                public void notify(Proposal proposal, Value value) {
                    LoggerUtils.logMsg(logger, envImpl, formatter, Level.FINE,
                                       "Learner notified. Proposal:" +
                                       proposal + " Value: " + value);
                }
            });
    }

    /**
     * Adds a Listener to the existing set of listeners, so that it can be
     * informed of the outcome of election results.
     *
     * @param listener the new listener to be added
     */
    public void addListener(Listener listener) {
        synchronized (listeners) {
            if (!listeners.contains(listener)) {
                listeners.add(listener);
            }
        }
    }

    /**
     * Removes a Listeners from the existing set of listeners.
     *
     * @param listener the listener to be removed.
     */
    void removeListener(Listener listener) {
        synchronized (listeners) {
            listeners.remove(listener);
        }
    }

    /**
     * Processes a result message
     *
     * @param proposal the winning proposal
     * @param value the winning value
     */
    synchronized public void processResult(Proposal proposal, Value value) {
        if ((currentProposal != null) &&
            (proposal.compareTo(currentProposal) < 0)) {
            LoggerUtils.logMsg(logger, envImpl, formatter, Level.FINE,
                               "Ignoring obsolete winner: " + proposal);
            return;
        }
        currentProposal = proposal;
        currentValue =  value;

        /* We have a new winning proposal and value, inform the listeners */
        synchronized (listeners) {
            for (Listener listener : listeners) {
                try {
                    listener.notify(currentProposal, currentValue);
                } catch (Exception e) {
                    e.printStackTrace();
                    /* Report the exception and keep going. */
                    LoggerUtils.logMsg
                        (logger, envImpl, formatter, Level.SEVERE,
                         "Exception in Learner Listener: " + e.getMessage());
                    continue;
                }
            }
        }
    }

    /**
     * The main Learner loop. It accepts requests and propagates them to its
     * Listeners, if the proposal isn't out of date.
     */
    @Override
    public void run() {
        serviceDispatcher.register(SERVICE_NAME, channelQueue);
        LoggerUtils.logMsg
            (logger, envImpl, formatter, Level.FINE, "Learner started");
        SocketChannel channel = null;
        try {
            while (true) {
                channel = serviceDispatcher.takeChannel
                    (SERVICE_NAME,
                     true /* blocking socket */,
                     protocol.getReadTimeout());

                if (channel == null) {
                    /* A soft shutdown. */
                   return;
                }

                final Socket socket = channel.socket();
                BufferedReader in = null;
                PrintWriter out = null;
                try {
                    in = new BufferedReader
                        (new InputStreamReader(socket.getInputStream()));
                    final String requestLine = in.readLine();
                    if (requestLine == null) {
                        continue;
                    }
                    RequestMessage requestMessage;
                    try {
                        requestMessage = protocol.parseRequest(requestLine);
                    } catch (InvalidMessageException e) {
                        LoggerUtils.logMsg
                            (logger, envImpl, formatter, Level.WARNING,
                             "Message format exception: " + e.getMessage());
                        out = new PrintWriter(socket.getOutputStream(), true);
                        out.println(protocol.new
                                    ProtocolError(e).wireFormat());
                        continue;
                    }

                    LoggerUtils.logMsg(logger, envImpl, formatter,
                                       Level.FINEST,
                                       "learner request: " +
                                       requestMessage.getOp() +
                                       " sender: " +
                                       requestMessage.getSenderId());
                    if (requestMessage.getOp() == protocol.RESULT) {
                        Result result = (Result) requestMessage;
                        processResult(result.getProposal(),result.getValue());
                    } else if (requestMessage.getOp() ==
                               protocol.MASTER_QUERY) {
                        synchronized (this) {
                            if ((currentProposal != null) &&
                                    (currentValue != null)) {
                                out = new PrintWriter(socket.getOutputStream(),
                                                      true);
                                MasterQueryResponse responseMessage =
                                    protocol.new MasterQueryResponse
                                        (currentProposal, currentValue);

                                /*
                                 * The request message may be of an earlier 
                                 * version. If so, this node transparently read
                                 * the older version. JE only throws out 
                                 * InvalidMessageException when the version of
                                 * the request message is newer than the 
                                 * current protocol. To avoid sending a 
                                 * response that the requester cannot 
                                 * understand, we send a response in the same
                                 * version as that of the original request
                                 * message. 
                                 */
                                responseMessage.setSendVersion
                                    (requestMessage.getSendVersion());
                                out.println(responseMessage.wireFormat());
                            }
                        }
                    } else if (requestMessage.getOp() == protocol.SHUTDOWN) {
                        LoggerUtils.logMsg
                            (logger, envImpl, formatter, Level.FINE,
                             "Learner thread exiting");
                        break;
                    } else {
                        throw EnvironmentFailureException.unexpectedState
                            ("Unrecognized request: " + requestLine);
                    }
                } catch (IOException e) {
                    LoggerUtils.logMsg
                        (logger, envImpl, formatter, Level.WARNING,
                         "IO exception: " + e.getMessage());
                } catch (Exception e) {
                    throw EnvironmentFailureException.unexpectedException(e);
                } finally {
                    Utils.cleanup(logger, envImpl, formatter, socket, in, out);
                }
            }
        } catch (InterruptedException e) {
            if (isShutdown()) {
                /* Treat it like a shutdown, exit the thread. */
                return;
            }
            LoggerUtils.logMsg(logger, envImpl, formatter, Level.WARNING,
                               "Learner unexpected interrupted");
            throw EnvironmentFailureException.unexpectedException(e);
       } finally {
            serviceDispatcher.cancel(SERVICE_NAME);
            cleanup();
       }
    }

    /**
     * Queries other learners to determine whether they know of a master in
     * the group.
     *
     * @param learnerSockets
     */
    public void queryForMaster(Set<InetSocketAddress> learnerSockets) {
        int threadPoolSize = Math.max(learnerSockets.size(), 10);
        final ExecutorService pool =
            Executors.newFixedThreadPool
               (threadPoolSize, new StoppableThreadFactory("JE Learner",
                                                           logger));
        try {
            RequestMessage masterQuery = protocol.new MasterQuery();
            List<Future<MessageExchange>> futures =
                Utils.broadcastMessage(learnerSockets,
                                       Learner.SERVICE_NAME,
                                       masterQuery,
                                       pool);
            LoggerUtils.logMsg(logger, envImpl, formatter, Level.FINE,
                               "Sent master request " + masterQuery + " to " +
                               learnerSockets);
            for (final Future<MessageExchange> f : futures) {
                new Utils.WithFutureExceptionHandler () {
                    @Override
                    protected void processFuture ()
                    throws ExecutionException, InterruptedException {
                        MessageExchange me = f.get();

                        if (me.getResponseMessage() == null) {
                            return;
                        }
                        if (me.getResponseMessage().getOp() ==
                            protocol.MASTER_QUERY_RESPONSE){
                            MasterQueryResponse accept =
                                (MasterQueryResponse) me.getResponseMessage();
                            processResult(accept.getProposal(),
                                          accept.getValue());
                        }
                    }
                }.execute(logger, envImpl, formatter);
            }
        } finally {
            pool.shutdown();
        }
    }

    /**
     * Returns the socket address for the current master, or null if one
     * could not be determined from the available set of learners. This API
     * is suitable for tools which need to contact the master for a specific
     * service, e.g. to delete a replication node, or to add a monitor. This
     * method could be used in principle to establish other types of nodes as
     * well via a tool, but that is currently done by the handshake process.
     *
     * @param protocol the protocol to be used when determining the master
     *
     * @param learnerSockets the learner to be queried for the master
     * @param logger for log messages
     * @return the MasterValue identifying the master
     * @throws UnknownMasterException if no master could be established
     */
    static public MasterValue findMaster
        (final Protocol protocol,
         Set<InetSocketAddress> learnerSockets,
         final Logger logger,
         final RepImpl repImpl,
         final Formatter formatter )
        throws UnknownMasterException {

        int threadPoolSize = Math.max(learnerSockets.size(), 10);
        final ExecutorService pool =
            Executors.newFixedThreadPool(threadPoolSize);
        try {
            List<Future<MessageExchange>> futures =
                Utils.broadcastMessage(learnerSockets,
                                       Learner.SERVICE_NAME,
                                       protocol.new MasterQuery(),
                                       pool);
            final List<MasterQueryResponse> results =
                new LinkedList<MasterQueryResponse>();
            for (final Future<MessageExchange> f : futures) {
                new Utils.WithFutureExceptionHandler () {
                    @Override
                    protected void processFuture ()
                        throws ExecutionException, InterruptedException {
                        /**
                         *  Wait for futures to complete and check for errors.
                         */
                        MessageExchange me = f.get();
                        ResponseMessage response = me.getResponseMessage();
                        if (response == null) {
                            return;
                        }
                        if (response.getOp() ==
                            protocol.MASTER_QUERY_RESPONSE){
                            results.add((MasterQueryResponse)response);
                        } else {
                            LoggerUtils.logMsg(logger,
                                               repImpl,
                                               formatter,
                                               Level.WARNING,
                                               "Unexpected MasterQuery " +
                                               "response:" +
                                               response.wireFormat());
                        }
                    }
                }.execute(logger, repImpl, formatter);
            }
            MasterQueryResponse bestResponse = null;
            for (MasterQueryResponse result : results) {
                if ((bestResponse == null) ||
                    (result.getProposal().
                            compareTo(bestResponse.getProposal()) > 0)) {
                    bestResponse = result;
                }
            }
            if (bestResponse == null) {
                throw new UnknownMasterException
                    ("Could not determine master from helpers at:" +
                     learnerSockets.toString());
            }
            return(MasterValue) bestResponse.getValue();
        } finally {
            pool.shutdown();
        }
    }

    /**
     * A utility method used to broadcast the results of an election to
     * Listeners.
     *
     * @param learners that need to be informed.
     * @param winningProposal the result that needs to be propagated
     * @param protocol to be used for communication
     * @param threadPool used to supply threads for the broadcast
     */
    public static void informLearners(Set<InetSocketAddress> learners,
                                      Proposer.WinningProposal winningProposal,
                                      Protocol protocol,
                                      ExecutorService threadPool,
                                      Logger logger,
                                      RepImpl repImpl,
                                      Formatter formatter) {

        if ((learners == null) || (learners.size() == 0)) {
            throw EnvironmentFailureException.unexpectedState
                ("There must be at least one learner");
        }

        LoggerUtils.logMsg(logger, repImpl, formatter, Level.FINE,
                           "Informing " + learners.size() + " learners.");
        List<Future<MessageExchange>> futures =
            Utils.broadcastMessage(learners,
                                   Learner.SERVICE_NAME,
                                   protocol.new Result
                                   (winningProposal.proposal,
                                    winningProposal.chosenValue),
                                   threadPool);

        /* Consume the futures. */
        int errors = 0;
        for (Future<MessageExchange> f : futures) {
            try {
                MessageExchange me = f.get();
                if (me.getResponseMessage() == null) {
                    /* Simply log it, the nodes may be down. */
                    LoggerUtils.logMsg(logger,
                                       repImpl,
                                       formatter,
                                       Level.FINE,
                                       "No response from: " + me.target +
                                       " reason: " + me.exception);
                }
            } catch (InterruptedException e) {
                errors++;
                LoggerUtils.logMsg
                    (logger, repImpl, formatter, Level.FINE,
                     "informLearners: interrupted while informing ");
            } catch (ExecutionException e) {
                errors++;
                LoggerUtils.logMsg
                    (logger, repImpl, formatter, Level.FINE,
                     "informLearners: exception while informing " +
                     e.getMessage());
            }
        }
        LoggerUtils.logMsg
            (logger, repImpl, formatter, Level.FINE,
             "Informed learners: " + (learners.size()-errors));
    }

    /**
     * @see StoppableThread#getLogger
     */
    @Override
    protected Logger getLogger() {
        return logger;
    }

    /*
     * Notifies the listener that a new proposal has been accepted. Note that
     * the value may be unchanged. The proposals may be out of sequence, it's
     * up to the listener to deal with it appropriately.
     */
    public static interface Listener {
        void notify(Proposal proposal, Value value);
    }
}
