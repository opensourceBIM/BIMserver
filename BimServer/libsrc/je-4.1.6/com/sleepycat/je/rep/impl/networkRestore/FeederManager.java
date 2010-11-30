/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.networkRestore;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.dbi.EnvironmentFailureReason;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.utilint.RepUtils;
import com.sleepycat.je.rep.utilint.ServiceDispatcher;
import com.sleepycat.je.util.DbBackup;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StoppableThread;

/**
 * Manages the multiple log file feeders that may be servicing requests from
 * multiple clients requesting log files.
 */
public class FeederManager extends StoppableThread {

    /*
     * The queue into which the ServiceDispatcher queues socket channels for
     * new Feeder instances.
     */
    private final BlockingQueue<SocketChannel> channelQueue =
        new LinkedBlockingQueue<SocketChannel>();

    /*
     * Map indexed by the client id. Each Feeder adds itself to the Map when
     * its first created and removes itself when it exits.
     */
    final Map<Integer, LogFileFeeder> feeders =
        new ConcurrentHashMap<Integer, LogFileFeeder>();

    /*
     * Maps the client id to its Lease. Except for instantaneous overlaps,
     * a client will have an entry in either the feeders map or the leases
     * map, but not in both maps.
     */
    final Map<Integer, Lease> leases = new ConcurrentHashMap<Integer, Lease>();

    /*
     * A cache of StatResponses to try minimize the recomputation of SHA1
     * hashes.
     */
    final Map<String, Protocol.FileInfoResp> statResponses =
        new ConcurrentHashMap<String, Protocol.FileInfoResp>();

    /* Implements the timer used to maintain the leases. */
    final Timer leaseTimer = new Timer(true);

    /* This node's name and internal id */
    final NameIdPair nameIdPair;

    /* Counts the number of times the lease was renewed. */
    public int leaseRenewalCount;

    /* The duration of leases. */
    long leaseDuration = DEFAULT_LEASE_DURATION;

    final ServiceDispatcher serviceDispatcher;

    /* Determines whether the feeder manager has been shutdown. */
    final AtomicBoolean shutdown = new AtomicBoolean(false);

    final Logger logger;

    /* Wait indefinitely for somebody to request the service. */
    private static long POLL_TIMEOUT = Long.MAX_VALUE;

    /* Identifies the Feeder Service. */
    public static final String FEEDER_SERVICE = "LogFileFeeder";

    /*
     * Default duration of lease on DbBackup associated with the client. It's
     * five minutes.
     */
    private static final long DEFAULT_LEASE_DURATION = 5 * 60 * 1000;

    /**
     * Creates a FeederManager but does not start it.
     *
     * @param serviceDispatcher The service dispatcher with which the
     * FeederManager must register itself. It's null only in a test
     * environment.
     *
     * @param nameIdPair The node name and id  associated with the feeder
     *
     * @param envImpl the environment that will provide the log files
     */
    public FeederManager(ServiceDispatcher serviceDispatcher,
                         EnvironmentImpl envImpl,
                         NameIdPair nameIdPair) {

        super(envImpl, "Feeder Manager node: " + nameIdPair.getName());
        this.serviceDispatcher = serviceDispatcher;
        serviceDispatcher.register
            (serviceDispatcher.new
                 LazyQueuingService(FEEDER_SERVICE, channelQueue, this));
        this.nameIdPair = nameIdPair;
        logger = LoggerUtils.getLogger(getClass());
    }

    EnvironmentImpl getEnvImpl() {
        return envImpl;
    }

    /**
     * Returns the number of times the lease was actually renewed.
     */
    public int getLeaseRenewalCount() {
        return leaseRenewalCount;
    }

    /**
     * Returns the number of leases that are currently outstanding.
     */
    public int getLeaseCount() {
        return leases.size();
    }

    /**
     * Returns the number of feeders that are currently active with this node.
     * Note that active leases are included in this count, since it's expected
     * that the clients will try to reconnect.
     */
    public int getActiveFeederCount() {
        return feeders.size() + getLeaseCount();
    }

    public long getLeaseDuration() {
        return leaseDuration;
    }

    public void setLeaseDuration(long leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    /**
     * The dispatcher method that starts up new log file feeders.
     */
    @Override
    public void run() {
        try {
            while (true) {
                final SocketChannel channel =
                    channelQueue.poll(POLL_TIMEOUT, TimeUnit.MILLISECONDS);
                if (channel == RepUtils.CHANNEL_EOF_MARKER) {
                    LoggerUtils.info(logger, envImpl,
                                     "Log file Feeder manager soft shutdown.");
                    return;
                }
                new LogFileFeeder(this, channel).start();
            }
        } catch (InterruptedException ie) {
            LoggerUtils.info
                (logger, envImpl, "Log file feeder manager interrupted");
        } catch (Exception e) {
            LoggerUtils.severe(logger, envImpl,
                               "unanticipated exception: " + e.getMessage());
            throw new EnvironmentFailureException
                (envImpl, EnvironmentFailureReason.UNCAUGHT_EXCEPTION, e);
        } finally {
            shutdown();
        }
    }

    public void shutdown() {
        LoggerUtils.fine
            (logger, envImpl, "Shutting down log file feeder manager");

        if (!shutdown.compareAndSet(false, true)) {
            return;
        }
        shutdownThread(logger);

        /* shutdown active feeder threads */
        for (LogFileFeeder feeder :
             new ArrayList<LogFileFeeder>(feeders.values())) {
            feeder.shutdown();
        }
        leaseTimer.cancel();
        /*
         * Terminate any outstanding leases, so we don't hold back file
         * deletion by the cleaner.
         */
        for (Lease l : new ArrayList<Lease>(leases.values())) {
            l.terminate();
        }
        serviceDispatcher.cancel(FEEDER_SERVICE);
        cleanup();
        LoggerUtils.fine(logger, envImpl,
                         "Shut down log file feeder manager completed");
    }

    @Override
    protected int initiateSoftShutdown() {
        /* Shutdown invoked from a different thread. */
        channelQueue.clear();
        /* Add special entry so that the channelQueue.poll operation exits. */
        channelQueue.add(RepUtils.CHANNEL_EOF_MARKER);
        return 0;
    }

    /**
     * Provides the lease mechanism used to maintain a handle to the DbBackup
     * object across Server client disconnects.
     */
    class Lease extends TimerTask {
        private final int id;
        private DbBackup dbBackup;

        public Lease(int id, long duration, DbBackup dbbackup) {
            super();
            this.dbBackup = dbbackup;
            this.id = id;
            Lease oldLease = leases.put(id, this);
            if (oldLease != null) {
                throw EnvironmentFailureException.unexpectedState
                    ("Found an old lease for node: " + id);
            }
            leaseTimer.schedule(this, duration);
        }

        @Override
        /* The timer went off, expire the lease if it hasn't been terminated */
        public synchronized void run() {
            if (dbBackup == null) {
                return;
            }
            dbBackup.endBackup();
            terminate();
        }

        /**
         * Fetches the leased DbBackup instance and terminates the lease.
         *
         * @return the dbBackup instance, if the lease hasn't already been
         * terminated
         */
        public synchronized DbBackup terminate() {
            if (dbBackup == null) {
                return null;
            }
            cancel();
            Lease l = leases.remove(id);
            assert(l == this);
            DbBackup saveDbBackup = dbBackup;
            dbBackup = null;
            return saveDbBackup;
        }

        public synchronized DbBackup getOpenDbBackup() {
            return (dbBackup != null) && dbBackup.backupIsOpen() ?
                    dbBackup :
                    null;
        }
    }

    /**
     * @see StoppableThread#getLogger
     */
    @Override
    protected Logger getLogger() {
        return logger;
    }
}
