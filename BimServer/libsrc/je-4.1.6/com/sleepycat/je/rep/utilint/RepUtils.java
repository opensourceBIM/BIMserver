/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_MESSAGES_WRITTEN;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_WRITE_NANOS;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.ReplicaConsistencyPolicy;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.rep.NoConsistencyRequiredPolicy;
import com.sleepycat.je.rep.TimeConsistencyPolicy;
import com.sleepycat.je.utilint.PropUtil;
import com.sleepycat.je.utilint.StatGroup;

public class RepUtils {

    public static final boolean DEBUG_PRINT_THREAD = true;
    public static final boolean DEBUG_PRINT_TIME = true;

    /**
     * Maps from uppercase ReplicaConsistencyPolicy name to the policy's
     * format.
     */
    private static final Map<String, ConsistencyPolicyFormat<?>>
        consistencyPolicyFormats =
            new HashMap<String, ConsistencyPolicyFormat<?>>();
    static {
        addConsistencyPolicyFormat(TimeConsistencyPolicy.NAME,
                                   new TimeConsistencyPolicyFormat());
        addConsistencyPolicyFormat(NoConsistencyRequiredPolicy.NAME,
                                   new NoConsistencyRequiredPolicyFormat());
    }

    /*
     * Canonical channel instance used to indicate that this is the last
     * instance of a channel in a channel queue and that the queue is
     * effectively closed. This value is typically used during a soft shutdown
     * of a thread to cause the thread waiting on the queue to wake up and
     * take notice.
     */
    public final static SocketChannel CHANNEL_EOF_MARKER;

    static {
        try {
            CHANNEL_EOF_MARKER = SocketChannel.open();
        } catch (IOException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
    }

    /**
     * Define a new ConsistencyPolicyFormat.  Should only be called outside of
     * this class to add support custom policies for testing.  Must be called
     * when the system is quiescent, since the map is unsynchronized.
     *
     * @param name must be the first part of the policy string with a
     * non-letter delimiter following it, or must be the entire policy string.
     *
     * @param format to register.
     */
    public static void
        addConsistencyPolicyFormat(final String name,
                                   final ConsistencyPolicyFormat<?> format) {
        consistencyPolicyFormats.put
            (name.toUpperCase(java.util.Locale.ENGLISH), format);
    }

    /**
     * ReplicaConsistencyPolicy must be stored as a String for use with
     * ReplicationConfig and je.properties.  ConsistencyPolicyFormat is an
     * internal handler that formats and parses the string representation of
     * the policy.  Only a fixed number of string-representable policies are
     * supported. Other policies that are not string-representable can only be
     * used in TransactionConfig, not ReplicationConfig.  For testing only, we
     * allow defining new custom policies.
     */
    public interface
        ConsistencyPolicyFormat<T extends ReplicaConsistencyPolicy>  {

        String policyToString(final T policy);

        T stringToPolicy(final String string);
    }

    private static class TimeConsistencyPolicyFormat
        implements ConsistencyPolicyFormat<TimeConsistencyPolicy> {

        public String policyToString(final TimeConsistencyPolicy policy) {
            return policy.getName() +
                "(" + policy.getPermissibleLag(TimeUnit.MILLISECONDS) +
                " ms," + policy.getTimeout(TimeUnit.MILLISECONDS) +
                " ms)";
        }

        public TimeConsistencyPolicy stringToPolicy(final String string) {
            /* Format: (<lag>, <timeout>) */
            String args =
                string.substring(TimeConsistencyPolicy.NAME.length());
            if (args.charAt(0) != '(' ||
                args.charAt(args.length()-1) != ')') {
                throw new IllegalArgumentException
                    ("Incorrect property value syntax: " + string);
            }
            int arg1 = args.indexOf(',');
            if (arg1 == -1) {
                throw new IllegalArgumentException
                    ("Incorrect property value syntax: " + string);
            }
            int lag = PropUtil.parseDuration(args.substring(1,arg1));
            int arg2 = args.indexOf(')');
            if (arg2 == -1) {
                throw new IllegalArgumentException
                    ("Incorrect property value syntax: " + string);
            }
            int timeout =
                PropUtil.parseDuration(args.substring(arg1 + 1, arg2));
            return new TimeConsistencyPolicy
                (lag, TimeUnit.MILLISECONDS, timeout, TimeUnit.MILLISECONDS);
        }
    }

    private static class NoConsistencyRequiredPolicyFormat
        implements ConsistencyPolicyFormat<NoConsistencyRequiredPolicy> {

        public String
            policyToString(final NoConsistencyRequiredPolicy policy) {
            return NoConsistencyRequiredPolicy.NAME;
        }

        public NoConsistencyRequiredPolicy
            stringToPolicy(final String string) {
            return NoConsistencyRequiredPolicy.NO_CONSISTENCY;
        }
    }

    /**
     * Converts a policy into a string suitable for use as a property value
     * in a je.properties file or elsewhere.
     *
     * @param policy the policy being converted.
     *
     * @return the formatted string representing the policy.
     *
     * @throws IllegalArgumentException if the specific policy does not have a
     * property value format, via ReplicationConfig(Properties) ctor and
     * setter.
     *
     * @see #getReplicaConsistencyPolicy(String)
     */
    public static String getPropertyString(ReplicaConsistencyPolicy policy)
        throws IllegalArgumentException {

        ConsistencyPolicyFormat format =
            consistencyPolicyFormats.get(policy.getName().toUpperCase());
        if (format == null) {
            throw new IllegalArgumentException
                ("Policy: " + policy + " cannot be used as a property");
        }
        return format.policyToString(policy);
    }

    /**
     * Converts a property string into a policy instance.
     *
     * @param propertyValue the formatted string representing the policy.
     *
     * @return the policy computed from the string
     *
     * @throws IllegalArgumentException via ReplicationConfig(Properties) ctor
     * and setter.
     */
    public static ReplicaConsistencyPolicy
        getReplicaConsistencyPolicy(String propertyValue)
        throws IllegalArgumentException {

        final String upperCasePropertyValue = 
            propertyValue.toUpperCase(java.util.Locale.ENGLISH);
        for (final Map.Entry<String, ConsistencyPolicyFormat<?>> entry :
             consistencyPolicyFormats.entrySet()) {
            final String name = entry.getKey();
            if (upperCasePropertyValue.equals(name) ||
                (upperCasePropertyValue.startsWith(name) &&
                 upperCasePropertyValue.length() > name.length() &&
                 !Character.isLetter
                    (upperCasePropertyValue.charAt(name.length())))) {
                ConsistencyPolicyFormat<?> format = entry.getValue();
                return format.stringToPolicy(propertyValue);
            }
        }
        throw new IllegalArgumentException
            ("Invalid consistency policy: " + propertyValue);
    }

    /**
     * Like CountDownLatch, but makes provision in the await for the await, or
     * more specifically the new awaitOrException method to be exited via an
     * exception.
     */
    public static class ExceptionAwareCountDownLatch extends CountDownLatch {
        /* The environment that may need to be invalidated. */
        final EnvironmentImpl envImpl;

        /* The exception (if any) that caused the latch to be released */
        private final AtomicReference<Exception> terminatingException =
            new AtomicReference<Exception> ();

        public ExceptionAwareCountDownLatch(EnvironmentImpl envImpl,
                                            int count) {
            super(count);
            this.envImpl = envImpl;
        }

        /**
         * The method used to free an await, ensuring that it throws an
         * exception at the awaitOrException.
         *
         * @param exception the exception to be wrapped in a DatabaseException
         * and thrown.
         */
        public void releaseAwait(Exception exception) {
            terminatingException.compareAndSet(null, exception);
            countDown();
            assert(getCount() == 0);
        }

        /**
         * It's like the CountDownLatch.await() method but provides an
         * additional way to exit the method via a DatabaseException that wraps
         * the original exception. The exception is thrown in every thread
         * that is waiting in this method.
         */
        public boolean awaitOrException(long timeout, TimeUnit unit)
            throws InterruptedException,
                   DatabaseException {

            boolean done = super.await(timeout, unit);
            if (!done) {
                return done;
            }
            final Exception exception = terminatingException.get();
            if (exception != null) {
                if (exception instanceof DatabaseException) {
                    throw (DatabaseException) exception;
                }
                throw EnvironmentFailureException.
                    unexpectedException(envImpl, exception);
            }
            return done;
        }

        public void awaitOrException()
            throws InterruptedException,
                   DatabaseException {
            awaitOrException(Integer.MAX_VALUE, TimeUnit.SECONDS);
        }

        /**
         * DO NOT use this method. Use awaitOrException instead, so that any
         * outstanding exceptions are thrown.
         */
        @Override
        @Deprecated
        @SuppressWarnings("unused")
        public boolean await(long timeout, TimeUnit unit) {
            throw EnvironmentFailureException.unexpectedState
                ("Use awaitOrException() instead of await");
        }
    }

    /**
     * Lisp inspired Map function.
     *
     * @param <R> The result element type for the list being returned.
     * @param <E> The type of the element being mapped over.
     */
    public static abstract class MapOver<R,E> {
        final Collection<E> c;
        MapOver(Collection<E> c) {
            this.c = c;
        }
        List<R> run() {
            List<R> l = new LinkedList<R>();
            for (E e : c) {
                l.add(fun(e));
            }
            return l;
        }
        /* The function invoked for each element in the collection. */
        abstract R fun(E e);
    }

    /**
     * Forces a shutdown of the channel ignoring any errors that may be
     * encountered in the process.
     *
     * @param namedChannel the channel to be shutdown
     */
    public static void shutdownChannel(NamedChannel namedChannel) {
        if (namedChannel == null) {
            return;
        }
        SocketChannel channel = namedChannel.getChannel();
        if (channel == null) {
            return;
        }
        try {
            channel.socket().shutdownInput();
        } catch (IOException ignore) {
            /* Ignore */
        }
        try {
            channel.socket().shutdownOutput();
        } catch (IOException e) {
            /* Ignore */
        }
        try {
            channel.close();
        } catch (IOException e) {
            /* Ignore */
        }
    }

    public static SocketChannel openBlockingChannel(InetSocketAddress addr,
            boolean tcpNoDelay, int timeout) throws IOException {
        SocketChannel channel = SocketChannel.open();
        Socket socket = channel.socket();
        channel.configureBlocking(true);
        /* Disable Nagle, the client only sends short messages. */
        socket.setTcpNoDelay(tcpNoDelay);
        socket.setSoTimeout(timeout);
        socket.connect(addr);
        return channel;
    }

    /**
     * Chains an old outstanding exception to the tail of a new one, so it's
     * not lost.
     *
     * @param newt the new throwable
     * @param oldt the old throwable
     * @return the new throwable extended withthe old cause
     */
    public static Throwable chainExceptionCause(Throwable newt,
                                                Throwable oldt) {
        /* Don't lose the original exception */
        for (Throwable tail = newt; true; tail = newt.getCause()) {
            if (tail.getCause() == null) {
                tail.initCause(oldt);
                break;
            }
        }
        return newt;
    }

    public static String writeTimesString(StatGroup stats) {
        long nMessagesWritten = stats.getLong(N_MESSAGES_WRITTEN);
        long nWriteNanos = stats.getLong(N_WRITE_NANOS);

        long avgWriteNanos =
            (nMessagesWritten <= 0) ? 0 : (nWriteNanos / nMessagesWritten);

        return String.format(" write time: %, dms Avg write time: %,dus",
                             nWriteNanos / 1000000, avgWriteNanos / 1000);
    }
}
