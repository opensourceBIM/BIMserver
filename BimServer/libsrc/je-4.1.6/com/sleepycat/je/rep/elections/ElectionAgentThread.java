/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.elections;

import java.nio.channels.SocketChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Formatter;
import java.util.logging.Logger;

import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.impl.node.RepNode;
import com.sleepycat.je.rep.utilint.RepUtils;
import com.sleepycat.je.rep.utilint.ReplicationFormatter;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StoppableThread;

/**
 * ElectionAgentThread is the base class for the election agent threads
 * underlying the Acceptor and Learner agents.
 */
public class ElectionAgentThread extends StoppableThread {

    /* The instance of the protocol bound to a specific Value and Proposal */
    protected final Protocol protocol;

    protected final Logger logger;

    /*
     * Used when the unit test AcceptorTest creates a RepNode without a RepIml
     * instance.
     */
    protected final Formatter formatter;

    /*
     * The queue into which the ServiceDispatcher queues socket channels for
     * new Feeder instances.
     */
    protected final BlockingQueue<SocketChannel> channelQueue =
        new LinkedBlockingQueue<SocketChannel>();


    protected ElectionAgentThread(RepNode repNode,
                                  Protocol protocol,
                                  NameIdPair nameIdPair,
                                  String threadName) {
        super((repNode == null ? null : repNode.getRepImpl()), threadName);
        this.protocol = protocol;

        logger = (envImpl != null) ?
            LoggerUtils.getLogger(getClass()) :
            LoggerUtils.getLoggerFormatterNeeded(getClass());

        formatter = new ReplicationFormatter(nameIdPair);
    }

    protected ElectionAgentThread(RepNode repNode, 
                                  Protocol protocol,
                                  String threadName) {
        this(repNode, protocol, repNode.getNameIdPair(), threadName);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    /**
     * Shuts down the Agent.
     * @throws InterruptedException
     */
    public void shutdown()
        throws InterruptedException{

        if (shutdownDone()) {
            return;
        }
        shutdownThread(logger);
    }

    @Override
    protected int initiateSoftShutdown() {
        channelQueue.clear();
        /* Add special entry so that the channelQueue.poll operation exits. */
        channelQueue.add(RepUtils.CHANNEL_EOF_MARKER);
        return 0;
    }
}
