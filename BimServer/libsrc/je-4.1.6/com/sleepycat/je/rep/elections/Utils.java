/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.elections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.rep.impl.TextProtocol.MessageExchange;
import com.sleepycat.je.rep.impl.TextProtocol.RequestMessage;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ServiceConnectFailedException;
import com.sleepycat.je.utilint.LoggerUtils;

public class Utils {

    /**
     * Cleans up the socket and its related streams after a request/response
     * cycle.
     *
     * @param socket the socket to be closed
     * @param in the request stream to be closed
     * @param out the response stream to be closed
     */
    static public void cleanup(Logger logger,
                               EnvironmentImpl envImpl,
                               Formatter formatter,
                               Socket socket,
                               BufferedReader in,
                               PrintWriter out) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                /* Ignore it, it's only cleanup. */
            }
        }
        if (out != null) {
            out.close();
        }
        if ((socket != null) && !socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                /* Log it and continue. */
                LoggerUtils.logMsg
                    (logger, envImpl, formatter, Level.FINE,
                     "Socket exception on close: " + e.getMessage());
            }
        }
    }

    /**
     * @hidden
     * Utility to broadcast a request to set of targets.
     *
     * @param targets of the broadcast
     * @param requestMessage to be broadcast
     * @param threadPool used to issue message in parallel
     *
     * @return the list of futures representing the results of the broadcast
     */
    public static List<Future<MessageExchange>>
        broadcastMessage(Set<InetSocketAddress> targets,
                         String serviceName,
                         RequestMessage requestMessage,
                         ExecutorService threadPool) {

        List<Future<MessageExchange>> futures =
            new LinkedList<Future<MessageExchange>>();

        for (InetSocketAddress socketAddress : targets) {
            MessageExchange me = requestMessage.getProtocol()
              .new MessageExchange(socketAddress, serviceName, requestMessage);
            futures.add(threadPool.submit(me, me));
        }
        return futures;
    }

    /**
     * Utility to wait for completion of futures.
     *
     * @param futures the futures to wait for
     * @param logger used to report any error messages
     */
    static void checkFutures(List<Future<MessageExchange>> futures,
                             Logger logger,
                             EnvironmentImpl envImpl,
                             Formatter formatter) {

        for (final Future<MessageExchange> f : futures) {
            new WithFutureExceptionHandler () {
                @Override
                protected void processFuture ()
                    throws ExecutionException, InterruptedException {
                    f.get();
                }
            }.execute(logger, envImpl, formatter);
        }
    }

    /**
     * Discard futures computations, since we no longer care about their
     * outcomes.
     *
     * @param futures futures to be discarded.
     */
    static void discardFutures(List<Future<MessageExchange>> futures) {
        for (Future<MessageExchange> f : futures) {
            f.cancel(false);
        }
    }

    /**
     * @hidden
     *
     * A utility wrapper to handle all exceptions from futures in a consistent
     * way. The above method illustrates its intended usage pattern
     */
    public static abstract class WithFutureExceptionHandler {

        /* The method represents the future process code being wrapped. */
        protected abstract void processFuture ()
            throws ExecutionException, InterruptedException;

        public final void execute(Logger logger, 
                                  EnvironmentImpl envImpl, 
                                  Formatter formatter) {
            try {
                processFuture();
            } catch (InterruptedException e) {
                throw EnvironmentFailureException.unexpectedException(e);
            } catch (ExecutionException e) {
                /* Get the true cause, unwrap the intermediate wrappers */
                Exception cause = (Exception)e.getCause();
                while (cause instanceof RuntimeException) {
                    Throwable t = ((RuntimeException)cause).getCause();
                    if ((t != null) && (t instanceof Exception)) {
                        cause = (Exception)t;
                    } else {
                        break;
                    }
                }
                if ((cause instanceof ConnectException) ||
                    (cause instanceof SocketException) ||
                    (cause instanceof SocketTimeoutException) ||
                    (cause instanceof ServiceConnectFailedException)){
                    // Network exceptions are expected, log it and keep moving
                    LoggerUtils.logMsg(logger, envImpl, formatter, Level.FINE, 
                                       "Election connection failure " +
                                       cause.getMessage());
                    return;
                }
                /* Unanticipated exception, higher level will handle it */
                throw EnvironmentFailureException.unexpectedException(e);
            }
        }
    }
}
