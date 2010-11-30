package com.sleepycat.je.rep.utilint;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.TextProtocol;
import com.sleepycat.je.rep.impl.TextProtocol.RequestMessage;
import com.sleepycat.je.rep.impl.TextProtocol.ResponseMessage;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StoppableThread;

/**
 * ServiceDispatcher listens on a specific socket for service requests
 * and dispatches control to the service that is being requested. A service
 * request message has the format:
 *
 * Service:<one byte ServiceName.length><ServiceName>
 *
 * The format of the message is binary, with all text being encoded in ascii.
 *
 * Upon receipt of service request message, the new SocketChannel is queued for
 * processing by the service in the Queue associated with the service. The
 * SocketChannel is the responsibility of the service after this point. It can
 * configure the channel to best suit the requirements of the specific service.
 *
 * The dispatcher returns a single byte to indicate success or failure. The
 * byte value encodes a ServiceDispatcher.Response enumerator.
 *
 */
public class ServiceDispatcher extends StoppableThread {

    /* The socket on which the dispatcher is listening */
    private final InetSocketAddress socketAddress;

    /*
     * The selector that watches for accept events on the server socket and
     * on subsequent read events.
     */
    private final Selector selector;

    /* The server socket channel */
    private final ServerSocketChannel serverChannel;

    /* Determines whether new connections should be accepted. */
    private boolean processAcceptRequests = true;

    /* Maintains the error count, used primarily for testing. */
    private int errorCount = 0;

    /*
     * Maps the service name to the queue of sockets processed by the
     * service.
     */
    private final Map<String, Service> serviceMap =
        new ConcurrentHashMap<String, Service>();

    /* The thread pool used to manage the threads used by services */
    private final ExecutorService pool = Executors.newCachedThreadPool();

    private final Logger logger;
    private final Formatter formatter;

    /* The prefix for a service request. */
    private static final String REQUEST_PREFIX = "Service:";
    private static final byte[] REQUEST_PREFIX_BYTES;

    /*
     * A reference to a replicated environment, only used for error
     * propagation when this dispatcher has been created for a replicated
     * node.
     */
    private final RepImpl repImpl;

    /**
     * The response to a service request.
     *
     * Do not rearrange the order of the enumerators, since their ordinal
     * values are currently used in messages.
     */
    public static enum Response {

        OK, BUSY, FORMAT_ERROR, UNKNOWN_SERVICE ;

        ByteBuffer byteBuffer() {
            ByteBuffer buffer = ByteBuffer.allocate(1);
            buffer.put((byte)ordinal());
            buffer.flip();
            return buffer;
        }

        static Response get(int ordinal) {
            if (ordinal < values().length) {
                return values()[ordinal];
            }
            return null;
        }
    }

    static {
        try {
            REQUEST_PREFIX_BYTES = REQUEST_PREFIX.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
    }

    /*
     * The initial size is the prefix plus the byte that holds the length of
     * the service name.
     */
    private static final int INITIAL_BUFFER_SIZE =
        REQUEST_PREFIX_BYTES.length+1;

    /**
     * Create a ServiceDispatcher listening on a specific socket for service
     * requests. This service dispatcher has been created on behalf of a
     * replicated environment, and the node will be informed of any unexpected
     * failures seen by the dispatcher.
     *
     * @param socketAddress the socket on which it listens for service requests
     *
     * @throws IOException if the socket could not be bound.
     */
    public ServiceDispatcher(InetSocketAddress socketAddress,
                             RepImpl repImpl)
        throws IOException {

        super(repImpl, "ServiceDispatcher-" + socketAddress.getHostName() +
                       ":" + socketAddress.getPort());

        this.repImpl = repImpl;
        this.socketAddress = socketAddress;
        serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        ServerSocket acceptSocket = serverChannel.socket();
        /* No timeout */
        acceptSocket.setSoTimeout(0);
        acceptSocket.bind(socketAddress);
        if (repImpl == null) {
            logger = LoggerUtils.getLoggerFormatterNeeded(getClass());
        } else {
            logger = LoggerUtils.getLogger(getClass());
        }
        NameIdPair nameIdPair =
            (repImpl == null) ? NameIdPair.NULL : repImpl.getNameIdPair();
        formatter = new ReplicationFormatter(nameIdPair);
    }

    /**
     * Convenience overloading for when the dispatcher is created without a
     * replicated environment, e.g. when used by the Monitor, and in unit test
     * situations.
     *
     * @see #ServiceDispatcher(InetSocketAddress, RepImpl)
     */
    public ServiceDispatcher(InetSocketAddress socketAddress)
        throws IOException {

        this(socketAddress, null /* repImpl */);
    }

    /**
     * Stop accepting new connections, while the individual services quiesce
     * and shut themselves down.
     */
    public void preShutdown() {
        processAcceptRequests = false;
    }

    /**
     * Shuts down the dispatcher, so that it's no longer listening for service
     * requests. The port is freed up upon return and the thread used to
     * listen on the port is shutdown.
     */
    public void shutdown() {
        if (shutdownDone()) {
            return;
        }

        LoggerUtils.logMsg(logger, repImpl, formatter, Level.INFO,
                           "ServiceDispatcher shutdown starting. HostPort=" +
                           socketAddress.getHostName() + ":" +
                           + socketAddress.getPort() +
                           " Registered services: " + serviceMap.keySet());

        shutdownThread(logger);

        for (String serviceName : serviceMap.keySet()) {
            cancel(serviceName);
        }

        /* Shutdown any executing and queued service requests. */
        pool.shutdownNow();
        try {
            serverChannel.socket().close();
            selector.close();
        } catch (IOException e) {
            LoggerUtils.logMsg
                (logger, repImpl, formatter, Level.WARNING,
                 "Ignoring I/O error during close: " + e.getMessage());
        }
        LoggerUtils.logMsg(logger, repImpl, formatter, Level.INFO,
                           "ServiceDispatcher shutdown completed." +
                           " HostPort=" + socketAddress.getHostName() +
                           ":" + socketAddress.getPort());
    }

    @Override
    protected int initiateSoftShutdown() {
        selector.wakeup();
        return 0;
    }

    /**
     * @see StoppableThread#getLogger
     */
    @Override
    protected Logger getLogger() {
        return logger;
    }

    /**
     * Builds a service request suitable for sending over to a
     * ServiceDispatcher.
     *
     * @param serviceName the service that is being requested.
     *
     * @return the byte encoding of the service request message
     */
    private static byte[] serviceRequestMessage(String serviceName) {
        byte[] serviceNameBytes;
        try {
            serviceNameBytes = serviceName.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
        int length = REQUEST_PREFIX_BYTES.length + 1 +
                      serviceNameBytes.length;
        ByteBuffer buffer = ByteBuffer.allocate(length);
        buffer.put(REQUEST_PREFIX_BYTES).
               put((byte)serviceNameBytes.length).
               put(serviceNameBytes);
        return buffer.array();
    }

    /**
     * Used by the client to establish an output stream for the service on the
     * socket. It sends out the request for the service and interprets the
     * response to determine if it was successful.
     *
     * @param socket the connected socket that will be the basis for the stream
     * @param serviceName the service running on the stream
     *
     * @return the output stream ready for subsequent output
     *
     * @throws IOException if the output stream could not be established
     * @throws ServiceConnectFailedException if the connection could not be
     * made.
     */
    static public OutputStream getServiceOutputStream(Socket socket,
                                                      String serviceName)
        throws IOException, ServiceConnectFailedException {

        assert socket.isConnected();
        byte[] message = ServiceDispatcher.serviceRequestMessage(serviceName);
        OutputStream out = socket.getOutputStream();
        out.write(message);
        out.flush();
        InputStream in = socket.getInputStream();
        int result = in.read();
        if (result < 0) {
            throw new IOException("No service response byte: " + result);
        }
        Response response = Response.get(result);
        if (response == null) {
            throw new IOException("Unexpected read response byte: " + result);
        }
        if (response != Response.OK) {
            throw new ServiceConnectFailedException(serviceName, response);
        }
        return out;
    }

    /**
     * A variation on the method above. It's used by the client to setup a
     * channel for the service. It performs the initial handshake requesting
     * the service and interpreting the response to determine if it was
     * successful.
     *
     * @param channel the channel that is the basis for the service
     * @param serviceName the service running on the channel
     *
     * @throws ServiceConnectFailedException if the connection could not be
     * made.
     */
    static public void doServiceHandshake(SocketChannel channel,
                                          String serviceName)
        throws IOException, ServiceConnectFailedException {

        ByteBuffer message =
            ByteBuffer.wrap(ServiceDispatcher.serviceRequestMessage(serviceName));
        while (message.remaining() > 0) {
            channel.write(message);
        }
        ByteBuffer buffer = ByteBuffer.allocate(1);
        while (buffer.remaining() > 0) {
            if (channel.read(buffer) < 0) {
                throw new IOException("EOF in response to service request:" +
                                      serviceName);
            }
        }
        int result = channel.read(buffer);
        if (result < 0) {
            throw new IOException("No service response byte: " + result);
        }
        buffer.flip();
        Response response = Response.get(buffer.get());
        if (response == null) {
            throw new IOException("Unexpected read response byte: " + result);
        }
        if (response != Response.OK) {
            throw new ServiceConnectFailedException(serviceName, response);
        }
    }

    /**
     * Returns the next socketChannel created in response to a request for the
     * service. The socketChannel and the associated socket is configured as
     * requested in the arguments.
     *
     * @param serviceName the service for which the channel must be created.
     * @param blocking true if the channel must be configured to block
     * @param soTimeout the timeout for the underlying socket
     * @return the configured channel or null if there are no more channels,
     * because the service has been shut down.
     * @throws InterruptedException
     */
    public SocketChannel takeChannel(String serviceName,
                                     boolean blocking,
                                     int soTimeout)
        throws InterruptedException {

        while (true) {
            Service service = serviceMap.get(serviceName);
            if (service == null) {
                throw EnvironmentFailureException.unexpectedState
                ("Service: " + serviceName + " was not registered");
            }
            if (! (service instanceof QueuingService)) {
                throw EnvironmentFailureException.unexpectedState
                ("Service: " + serviceName + " is not a queuing service");
            }
            Socket socket = null;
            SocketChannel channel = null;
            try {
                channel = ((QueuingService)service).take();
                assert channel != null;

                if (channel == RepUtils.CHANNEL_EOF_MARKER) {
                    /* A pseudo channel to indicate EOF, return null */
                    return null;
                }

                channel.configureBlocking(blocking);
                socket = channel.socket();
                socket.setSoTimeout(soTimeout);
                return channel;
            } catch (IOException e) {
                LoggerUtils.logMsg(logger, repImpl, formatter, Level.WARNING,
                                   "Unable to configure channel " +
                                   "for service: " + serviceName + "\n" +
                                   e.getMessage());
                try {
                    if (channel != null) {
                        channel.close();
                    }
                } catch (IOException e1) {
                    LoggerUtils.logMsg(logger, repImpl, formatter, Level.FINEST,
                                       "Cleanup failed for service: " +
                                       serviceName + "\n" + e.getMessage());
                }
                /* Wait for the next request. */
                continue;
            }
        }
    }

    /**
     * Returns the socket associated with the dispatcher
     */
    public InetSocketAddress getSocketAddress() {
        return socketAddress;
    }

    /**
     * Registers a service queue with the ServiceDispatcher. Requests for a
     * service result in a new SocketChannel being created on which the service
     * can communicate with the requester of the service.
     *
     * @param serviceName the name of the service being requested
     * @param serviceQueue the queue that will be used to hold channels
     * established for the service.
     */
    public void register(String serviceName,
                         BlockingQueue<SocketChannel> serviceQueue) {
        if (serviceName == null) {
            throw EnvironmentFailureException.unexpectedState
                ("The serviceName argument must not be null");
        }
        if (serviceMap.containsKey(serviceName)) {
            throw EnvironmentFailureException.unexpectedState
                ("Service: " + serviceName + " is already registered");
        }
        if (serviceQueue == null) {
            throw EnvironmentFailureException.unexpectedState
                ("The serviceQueue argument must not be null");
        }
        serviceMap.put(serviceName,
                       new QueuingService(serviceName, serviceQueue));
    }

    public void register(Service service) {
        if (service == null) {
            throw EnvironmentFailureException.unexpectedState
                ("The service argument must not be null");
        }

        if (serviceMap.containsKey(service.name)) {
            throw EnvironmentFailureException.unexpectedState
                ("Service: " + service.name + " is already registered");
        }
        LoggerUtils.logMsg(logger, repImpl, formatter, Level.FINE,
                           "Service: " + service.name + " registered.");
        serviceMap.put(service.name, service);
    }

    public boolean isRegistered(String serviceName) {
        if (serviceName == null) {
            throw EnvironmentFailureException.unexpectedState
                ("The serviceName argument must not be null");
        }
        return serviceMap.containsKey(serviceName);
    }

    /**
     * Cancels the registration of a service. Subsequent attempts to access the
     * service will be ignored and the channel will be closed and will not be
     * queued.
     *
     * @param serviceName the name of the service being cancelled
     */
    public void cancel(String serviceName) {
        if (serviceName == null) {
            throw EnvironmentFailureException.unexpectedState
                ("The serviceName argument must not be null.");
        }
        Service service = serviceMap.remove(serviceName);

        if (service == null) {
            throw EnvironmentFailureException.unexpectedState
                ("Service: " + serviceName + " was not registered.");
        }
        service.cancel();
        LoggerUtils.logMsg(logger, repImpl, formatter, Level.FINE,
                           "Service: " + serviceName + " shut down.");
    }

    /**
     * Processes an accept event on the server socket. As a result of the
     * processing a new socketChannel is created, and the selector is
     * registered with the new channel so that it can process subsequent read
     * events.
     */
    private void processAccept() {

        SocketChannel socketChannel = null;
        try {
            socketChannel = serverChannel.accept();
            if (!processAcceptRequests) {
                closeChannel(socketChannel);
                return;
            }
            socketChannel.configureBlocking(false);
            socketChannel.register
                (selector,
                 SelectionKey.OP_READ,
                 ByteBuffer.allocate(INITIAL_BUFFER_SIZE));
        } catch (IOException e) {
            LoggerUtils.logMsg(logger, repImpl, formatter, Level.WARNING,
                               "Server accept exception: " + e.getMessage());
            closeChannel(socketChannel);
        }
    }

    /**
     * Processes read events on newly established socket channels. Input on the
     * channel is verified to ensure that it is a service request. The read is
     * accomplished in two parts, a read for the fixed size prefix and the name
     * length byte, followed by a read of the variable length name itself.
     *
     * Errors result in the channel being closed(with the key being canceled
     * as a result) and a null value being returned.
     *
     * @param readKey the read key associated with the channel.
     *
     * @return the ServiceName or null if there was insufficient input, or an
     * error was encountered.
     */
    private String processRead(SelectionKey readKey) {
        SocketChannel socketChannel = null;
        try {
            ByteBuffer readBuffer = (ByteBuffer) readKey.attachment();
            socketChannel = (SocketChannel) readKey.channel();
            int readBytes = socketChannel.read(readBuffer);
            if (readBytes < 0 ) {
                /* Premature EOF */
                errorCount++;
                LoggerUtils.logMsg(logger, repImpl, formatter, Level.WARNING,
                                   "Premature EOF on channel: " +
                                   socketChannel + " read() returned: " +
                                   readBytes);
                socketChannel.close();
                return null;
            }
            if (readBuffer.remaining() == 0) {
                readBuffer.flip();
                if (readBuffer.capacity() == INITIAL_BUFFER_SIZE) {
                    String prefix = new String(readBuffer.array(),
                                               0, REQUEST_PREFIX.length(),
                                               "US-ASCII");
                    if (!prefix.equals(REQUEST_PREFIX)) {
                        errorCount++;
                        LoggerUtils.logMsg
                            (logger, repImpl, formatter, Level.WARNING,
                             "Malformed service request: " + prefix);
                        socketChannel.write
                            (Response.FORMAT_ERROR.byteBuffer());
                        socketChannel.close();
                        return null;
                    }
                    /* Enlarge the buffer to read the service name as well */
                    int nameLength = readBuffer.get(INITIAL_BUFFER_SIZE-1);
                    if (nameLength <= 0) {
                        errorCount++;
                        LoggerUtils.logMsg
                            (logger, repImpl, formatter, Level.WARNING,
                             "Bad service service name length: " + nameLength);
                        socketChannel.write
                            (Response.FORMAT_ERROR.byteBuffer());
                        socketChannel.close();
                        return null;
                    }
                    ByteBuffer buffer = ByteBuffer.allocate
                        (INITIAL_BUFFER_SIZE + nameLength);
                    buffer.put(readBuffer);
                    readKey.attach(buffer);

                    return processRead(readKey);
                }
                String request = new String(readBuffer.array(), "US-ASCII");
                readKey.cancel();
                return request.substring(REQUEST_PREFIX.length()+1);
            }
            /* Buffer not full as yet, keep reading */
            return null;
        } catch (IOException e) {
            LoggerUtils.logMsg(logger, repImpl, formatter, Level.WARNING,
                               "Exception during read: " + e.getMessage());
            closeChannel(socketChannel);
            return null;
        }
    }

    /**
     * Closes the channel, logging any resulting exceptions.
     *
     * @param channel the channel being closed
     */
    private void closeChannel(Channel channel) {
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e1) {
                LoggerUtils.logMsg(logger, repImpl, formatter, Level.WARNING,
                                   "Exception during cleanup: " +
                                   e1.getMessage());
            }
        }
    }

    /**
     * The central run method. It dispatches to the "accept" and "read" event
     * processing methods. Upon a completed read, it verifies the validity of
     * the service name and queues the channel for subsequent consumption
     * by the service.
     *
     */
    @Override
    public void run() {
        LoggerUtils.logMsg(logger, repImpl, formatter, Level.INFO,
                           "Started ServiceDispatcher. HostPort=" +
                           socketAddress.getHostName() + ":" +
                           socketAddress.getPort());
        try {
            while (true) {
                try {
                    int result = selector.select();
                    if (isShutdown()) {
                        return;
                    }
                    if (result == 0) {
                        continue;
                    }
                } catch (IOException e) {
                    LoggerUtils.logMsg
                        (logger, repImpl, formatter, Level.SEVERE,
                         "Server socket exception " + e.getMessage());
                    throw EnvironmentFailureException.unexpectedException(e);
                }
                Set<SelectionKey> skeys = selector.selectedKeys();
                for (SelectionKey key : skeys) {
                    switch (key.readyOps()) {

                        case SelectionKey.OP_ACCEPT:
                            processAccept();
                            break;

                        case SelectionKey.OP_READ:
                            String serviceName = processRead(key);
                            if (serviceName == null) {
                                break;
                            }
                            key.cancel();
                            processService((SocketChannel)key.channel(),
                                           serviceName);
                            break;

                        default:
                            throw EnvironmentFailureException.unexpectedState
                                ("Unexpected ops bit set: " + key.readyOps());
                    }
                }
                /* All keys have been processed clear them. */
                skeys.clear();
            }
        } finally {
            closeChannel(serverChannel);
            cleanup();
        }
    }

    /**
     * Performs the guts of the work underlying a service request. It validates
     * the service request and writes an appropriate response to the channel.
     * @param channel
     * @param serviceName
     */
    private void processService(SocketChannel channel, String serviceName) {
        final Service service = serviceMap.get(serviceName);
        try {
            if (service == null) {
                errorCount++;
                channel.write(Response.UNKNOWN_SERVICE.byteBuffer());
                closeChannel(channel);
                /*
                 * Not unexpected in a distributed app due to calls being made
                 * before a service is actually registered.
                 */
                LoggerUtils.logMsg(logger, repImpl, formatter, Level.INFO,
                                   "Request for unknown Service: " +
                                   serviceName + " Registered services: " +
                                   serviceMap.keySet());
                return;
            }
            Response response = service.isBusy() ? Response.BUSY : Response.OK;
            LoggerUtils.logMsg(logger, repImpl, formatter, Level.FINE,
                               "Service response: " + response +
                               " for service: " + service.name);

            if (channel.write(response.byteBuffer()) == 0) {
                throw EnvironmentFailureException.unexpectedState
                    ("Failed to write byte. Send buffer size: " +
                     channel.socket().getSendBufferSize());
            }
            if (response == Response.OK) {
                service.requestDispatch(channel);
            }
        } catch (IOException e) {
            closeChannel(channel);
            LoggerUtils.logMsg(logger, repImpl, formatter, Level.WARNING,
                               "IO error writing to channel for " +
                               "service: " +  serviceName + e.getMessage());
        }
    }

    /**
     * The abstract class underlying all services.
     */
    static private abstract class Service {

        /* The name associated with the service. */
        final String name;

        public Service(String name) {
            super();
            if (name == null) {
                throw EnvironmentFailureException.unexpectedState
                    ("Service name was null");
            }
            this.name = name;
        }

        /**
         * Informs the service of a new request. The implementation of the
         * method must not block.
         *
         * @param channel the channel on which the request was made
         */
        abstract void requestDispatch(SocketChannel channel);

        /*
         * Used to limit a particular type of service to avoid excess load.
         */
        public boolean isBusy() {
            return false;
        }

        /**
         * Cancel the service as part of the registration being canceled.
         */
        abstract void cancel();
    }

    /**
     * A service where requests are simply added to the supplied queue. It's
     * the responsibility of the service creator to drain the queue. This
     * service is used when the service carries out a long-running dialog with
     * the service requester. For example, a Feeder service.
     */
    public class QueuingService extends Service {
        /* Holds the queue of pending requests, one per channel */
        private final BlockingQueue<SocketChannel> queue;

        QueuingService(String serviceName,
                       BlockingQueue<SocketChannel> queue) {
            super(serviceName);
            this.queue = queue;
        }

        SocketChannel take() throws InterruptedException {
            return queue.take();
        }

        @Override
        void requestDispatch(SocketChannel channel) {
            if (!queue.add(channel)) {
                throw EnvironmentFailureException.unexpectedState
                    ("request queue overflow");
            }
        }

        @Override
        void cancel() {
            /*
             * Drain any existing pending requests. It's safe to just iterate
             * since the service dispatcher has already stopped accepting new
             * requests for the service.
             */
            for (SocketChannel channel : queue) {
                try {
                    channel.close();
                } catch (IOException e) {
                    // Ignore it, it's only cleanup
                }
            }
            queue.add(RepUtils.CHANNEL_EOF_MARKER);
        }
    }

    /**
     * A queuing service that starts the thread that services the requests
     * lazily, upon first request and terminates the thread when the service is
     * unregistered. The thread must be "interrupt aware" and must exit when
     * it receives an interrupt.
     *
     * This type of service is suitable for services that are used
     * infrequently.
     */
    public class LazyQueuingService extends QueuingService {

        private final Thread serviceThread;

        public LazyQueuingService(String serviceName,
                                  BlockingQueue<SocketChannel> queue,
                                  Thread serviceThread) {

            super(serviceName, queue);
            this.serviceThread = serviceThread;
        }

        @Override
        void requestDispatch(SocketChannel channel) {

            switch (serviceThread.getState()) {

                case NEW:
                    serviceThread.start();
                    LoggerUtils.logMsg(logger, repImpl, formatter, Level.FINE,
                                       "Thread started for service: " + name);
                    break;

                case RUNNABLE:
                case TIMED_WAITING:
                case WAITING:
                case BLOCKED:
                    /* Was previously activated. */
                    LoggerUtils.logMsg(logger, repImpl, formatter, Level.FINE,
                                       "Thread started for service: " + name);
                    break;

                default:
                    RuntimeException e =
                        EnvironmentFailureException.unexpectedState
                            ("Thread for service:" + name +
                             "is in state:" + serviceThread.getState());
                    LoggerUtils.logMsg(logger, repImpl, formatter,
                                       Level.WARNING, e.getMessage());
                    throw e;
            }
            super.requestDispatch(channel);
        }

        @Override
        /**
         * Interrupts the thread to cause it to exit.
         */
        void cancel() {
            if (serviceThread.isAlive()) {
                serviceThread.interrupt();
                try {
                    serviceThread.join();
                } catch (InterruptedException e) {
                    /* Ignore it on shutdown. */
                }
            }
            super.cancel();
        }
    }

    /**
     * A service that is run immediately in a thread allocated to it. Subtypes
     * implement the getRunnable() method which provides the runnable object
     * for the service. This service frees up the caller from managing the the
     * threads associated with the service. The runnable must manage interrupts
     * so that it can be shut down by the underlying thread pool.
     */
    static public abstract class ExecutingService extends Service {
        final private ServiceDispatcher dispatcher;

        public ExecutingService(String serviceName,
                                ServiceDispatcher dispatcher) {
            super(serviceName);
            this.dispatcher = dispatcher;
        }

        public abstract Runnable getRunnable(SocketChannel socketChannel);

        @Override
        void requestDispatch(SocketChannel channel) {
            dispatcher.pool.execute(getRunnable(channel));
        }

        @Override
        void cancel() {
            /* Nothing to do */
        }
    }

    @SuppressWarnings("serial")
    static public class ServiceConnectFailedException extends Exception {
        final Response response;
        final String serviceName;

        ServiceConnectFailedException(String serviceName,
                                      Response response) {
            assert(response != Response.OK);
            this.response = response;
            this.serviceName = serviceName;
        }

        public Response getResponse() {
            return response;
        }

        @Override
        public String getMessage() {
            switch (response) {
                case FORMAT_ERROR:
                    return "Bad message format, for service:" + serviceName;

                case UNKNOWN_SERVICE:
                    return "Unknown service request:" + serviceName;

                case BUSY:
                    return "Service was busy";

                case OK:
                    /*
                     * Don't expect an OK response to provoke an exception.
                     * Fall through.
                     */
                default:
                    throw EnvironmentFailureException.unexpectedState
                        ("Unexpected response:" + response +
                         " for service:" + serviceName);
            }
        }
    }

    abstract public static class ExecutingRunnable implements Runnable {
        protected final SocketChannel channel;
        protected final TextProtocol protocol;
        protected final boolean expectResponse;

        public ExecutingRunnable(SocketChannel channel,
                                 TextProtocol protocol,
                                 boolean expectResponse) {
            this.channel = channel;
            this.protocol = protocol;
            this.expectResponse = expectResponse;
        }

        /* Read request and send out response. */
        public void run() {
            try {
                channel.configureBlocking(true);
                RequestMessage request = protocol.getRequestMessage(channel);
                if (request == null) {
                    return;
                }
                ResponseMessage response = getResponse(request);
                if (expectResponse) {
                    PrintWriter out = new PrintWriter
                        (channel.socket().getOutputStream(), true);
                    out.println(response.wireFormat());
                } else {
                    assert (response == null);
                }
            } catch (IOException e) {
                logMessage("IO error on socket: " + e.getMessage());
                return;
            } finally {
                if (channel.isOpen()) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        logMessage("IO error on socket: " + e.getMessage());
                         return;
                    }
                }
            }
        }

        /* Get the response for a request. */
        abstract protected ResponseMessage getResponse(RequestMessage request)
            throws IOException;

        /* Log the message. */
        abstract protected void logMessage(String message);
    }
}
