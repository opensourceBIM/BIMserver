/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_BYTES_READ;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_BYTES_WRITTEN;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_MESSAGES_READ;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_MESSAGES_WRITTEN;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_READ_NANOS;
import static com.sleepycat.je.rep.utilint.BinaryProtocolStatDefinition.N_WRITE_NANOS;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.rep.impl.RepGroupImpl;
import com.sleepycat.je.rep.impl.RepNodeImpl;
import com.sleepycat.je.rep.impl.RepParams;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.utilint.InternalException;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.VLSN;

/**
 * Supplies the basic infrastructure for BinaryProtocols used to exchange
 * messages by the replications stream and during network based restore
 * operations.
 *
 * Note that this class and its subclasses are not synchronized. There must be
 * one instance of this class per thread of control.
 *
 * IMPORTANT: Please avoid all uses of ByteBuffer.get/put when serializing
 * message fields of types: long, int and short to avoid byte order issues.
 * Use LogUtils.read/write methods instead, since they use a single canonical
 * byte-independent representation.
 */
public abstract class BinaryProtocol {

    protected static final int MESSAGE_HEADER_SIZE =
        2 /* Message op id (short) */ +
        4 /* message size (int) */;

    /* Buffer reused to process the header of every message. */
    protected final ByteBuffer header =
        ByteBuffer.allocate((MESSAGE_HEADER_SIZE));

    /* The version as implemented by the actual code. */
    protected final int codeVersion;

    /* The version that this instance is actually configured to use. */
    /* It's not final to facilitate testing */
    protected int configuredVersion;

    /* Identifies the node using this protocol. */
    protected final NameIdPair nameIdPair;

    /* Maps the message op id to its canonical descriptor instance. */
    private final Map<Short, MessageOp> ops = new HashMap<Short, MessageOp>();
    private final int predefinedMessageCount;

    /* The max message size which will be accepted. */
    private final long maxMessageSize;

    /*
     * The predefined messages. IMPORTANT: Note that predefined message ops
     * start at 1000. to stay out of the way of subtype ops.
     */
    public final MessageOp CLIENT_VERSION =
        new MessageOp((short) 1001, ClientVersion.class);

    public final MessageOp SERVER_VERSION =
        new MessageOp((short) 1002, ServerVersion.class);

    public final MessageOp INCOMPATIBLE_VERSION =
        new MessageOp((short) 1003, IncompatibleVersion.class);

    public final MessageOp PROTOCOL_ERROR =
        new MessageOp((short) 1004, ProtocolError.class);

    /* Statistics definition. */
    protected final StatGroup stats;
    protected final LongStat nReadNanos;
    protected final LongStat nWriteNanos;
    protected final LongStat nBytesRead;
    protected final LongStat nMessagesRead;
    protected final LongStat nBytesWritten;
    protected final LongStat nMessagesWritten;

    protected final Logger logger;
    protected final Formatter formatter;
    protected final EnvironmentImpl envImpl;

    /**
     * Returns a Protocol object configured that implements the specified
     * (supported) version.
     *
     * @param codeVersion the version actually implemented by the protocol.
     * @param configuredVersion the version of the protocol that must be
     * implemented/simulated by this protocol when communicating with the
     * recipient.
     */
    protected BinaryProtocol(NameIdPair nameIdPair,
                             int codeVersion,
                             int configuredVersion,
                             EnvironmentImpl envImpl) {
        this.nameIdPair = nameIdPair;
        this.codeVersion = codeVersion;
        this.configuredVersion = configuredVersion;
        this.envImpl = envImpl;

        if (envImpl != null) {
            this.logger = LoggerUtils.getLogger(getClass());
        } else {
            this.logger = LoggerUtils.getLoggerFormatterNeeded(getClass());
        }
        this.formatter = new ReplicationFormatter(nameIdPair);

        stats = new StatGroup(BinaryProtocolStatDefinition.GROUP_NAME,
                              BinaryProtocolStatDefinition.GROUP_DESC);
        nReadNanos = new LongStat(stats, N_READ_NANOS);
        nWriteNanos = new LongStat(stats, N_WRITE_NANOS);
        nBytesRead = new LongStat(stats, N_BYTES_READ);
        nMessagesRead = new LongStat(stats, N_MESSAGES_READ);
        nBytesWritten = new LongStat(stats, N_BYTES_WRITTEN);
        nMessagesWritten = new LongStat(stats, N_MESSAGES_WRITTEN);

        /* Initialize with the pre-defined protocol messages. */
        for (MessageOp op :
            new MessageOp[] { CLIENT_VERSION,
                              SERVER_VERSION,
                              INCOMPATIBLE_VERSION,
                              PROTOCOL_ERROR }) {

            if (ops.put(op.opId, op) != null) {
                throw EnvironmentFailureException.unexpectedState
                    ("Duplicate op: " + op.opId);
            }
        }
        predefinedMessageCount = ops.size();
        if (envImpl != null) {
            DbConfigManager configManager = envImpl.getConfigManager();
            long mMSz =
                configManager.getLong(RepParams.MAX_MESSAGE_SIZE);
            maxMessageSize = (mMSz == 0) ?
                (envImpl.getMemoryBudget().getMaxMemory() >> 1) :
                mMSz;
        } else {
            /* Some unit tests pass in null EnvImpl. */
            maxMessageSize = 1 << 20;
        }
    }

    /*
     * Must be invoked after the constructor has completed, to get around
     * base/subclass initialization dependences; MessageOps are instances of
     * nested classes declared in the subclass.
     */
    protected void initializeMessageOps(MessageOp[] protocolOps) {

        for (MessageOp op : protocolOps) {
            if (ops.put(op.opId, op) != null) {
                throw EnvironmentFailureException.unexpectedState
                    ("Duplicate op: " + op.opId);
            }
        }
    }

    /*
     * The total number of messages defined by the protocol. Includes messages
     * defined by the subclass.
     */
    public int messageCount() {
        return ops.size();
    }

    /* The messages defined in this class. */
    final public int getPredefinedMessageCount() {
        return predefinedMessageCount;
    }

    /**
     * Returns the version associated with this protocol instance. Request
     * message generated by this instance conform to this version and responses
     * are expected to conform to this version as well.
     *
     * @return the version that is actually being used.
     */
    public int getVersion() {
        return configuredVersion;
    }

    public StatGroup getStats(StatsConfig config) {
        StatGroup ret = stats.cloneGroup(config.getClear());

        return ret;
    }

    public void resetStats() {
        stats.clear();
    }

    /* Messages <= this size will use the shared buffer. */
    private static int CACHED_BUFFER_SIZE = 0x4000;

    /* The shared buffer that is reused. */
    private final ByteBuffer cachedBuffer =
        ByteBuffer.allocate(CACHED_BUFFER_SIZE);

    /**
     * Returns a buffer of the requested size. In future, this would the place
     * where buffers used to construct messages could be reused.
     *
     * @param size the size of the requested buffer in bytes
     * @return the requested
     */
    private ByteBuffer allocateBuffer(int size) {
        if(size <= CACHED_BUFFER_SIZE ) {
            cachedBuffer.rewind();
            cachedBuffer.limit(size);
            return cachedBuffer;
        }
        return ByteBuffer.allocate(size);
    }

    /* Serialize the string into the buffer. */
    public static void putString(String s, ByteBuffer buffer) {
        LogUtils.writeInt(buffer, s.getBytes().length);
        buffer.put(s.getBytes());
    }

    /**
     * Reconstitutes the string serialized by the above method.
     *
     * @param buffer the buffer containing the string
     *
     * @return the de-serialized string
     */
    public static String getString(ByteBuffer buffer) {
        int length = LogUtils.readInt(buffer);
        byte b[] = new byte[length];
        buffer.get(b);
        return new String(b);
    }

    /**
     * The Operations that are part of the protocol.
     */
    public static class MessageOp {

        /* The string denoting the operation for the request message. */
        private final short opId;

        /* The class used to represent the message. */
        private final Class<? extends Message> messageClass;
        /* The constructor used to create message instances. */
        private Constructor<? extends Message> constructor;

        /* The label is used for debugging purposes. */
        private final String label;

        public MessageOp(short opId, Class<? extends Message> messageClass) {
            this.opId = opId;
            this.messageClass = messageClass;
            this.label = messageClass.getSimpleName();
            try {
                constructor = messageClass.getConstructor
                    (messageClass.getEnclosingClass(), ByteBuffer.class);
            } catch (SecurityException e) {
                throw EnvironmentFailureException.unexpectedException(e);
            } catch (NoSuchMethodException e) {
                throw EnvironmentFailureException.unexpectedException(e);
            }
        }

        public short getOpId() {
            return opId;
        }

        Class<? extends Message> getMessageClass() {
            return messageClass;
        }

        public Constructor<? extends Message> getConstructor() {
            return constructor;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    /**
     * Returns the Op from a message buffer. It's always the first item in the
     * buffer. Leaves the message buffer positioned after the Op.
     *
     * @param messageBuffer a message buffer the the protocol
     * @return the OpId
     */
    private MessageOp getOp(ByteBuffer messageBuffer) {
        short opId = LogUtils.readShort(messageBuffer);
        final MessageOp messageOp = ops.get(opId);

        if (messageOp == null) {
            throw EnvironmentFailureException.unexpectedState
                (envImpl,
                 "Unknown message op id:" + opId +
                 " Known op ids:" + Arrays.toString(ops.keySet().toArray()));
        }
        return messageOp;
    }

    /*
     * Used to indicate that an entity is formatable and can be serialized and
     * de-serialized.
     */
    interface WireFormatable {

        /*
         * Returns a ByteBuffer holding the message in a representation
         * suitable for use in a network transmission. The buffer is flipped
         * and ready for relative reads.
         */
        abstract ByteBuffer wireFormat();
    }

    /**
     * Fills a dedicated empty buffer with bytes read from the channel. It
     * flips the buffer after it has been filled, so it's ready for reading.
     *
     * @param channel the channel to be read
     * @param buffer the buffer to be filled
     * @throws IOException if the errors were encountered while reading from
     * the channel or the buffer could not be filled with the expected number
     * of bytes
     */
    private void fillBuffer(ReadableByteChannel channel,
                            ByteBuffer buffer)
        throws IOException {

        final long start = System.nanoTime();
        assert(buffer.position() == 0);
        while (buffer.position() < buffer.limit()) {
            int numRead = channel.read(buffer);
            if (numRead <= 0) {
                throw new IOException("Expected bytes: " + buffer.limit() +
                                      " read bytes: " + buffer.position());
            }
        }
        nReadNanos.add(System.nanoTime() - start);
        buffer.flip();
    }

    /**
     * Read and parse an incoming message, specifying the incoming version.
     *
     * @param channel the channel to read from. Declared as a
     * ReadableByteChannel rather than the more obvious SocketChannel to
     * facilitate unit testing.
     *
     * @throws IOException
     */
    public Message read(ReadableByteChannel channel)
        throws IOException {

        /* Get the message header. */
        fillBuffer(channel, header);

        /* Use the type value to determine the message type. */
        MessageOp op = getOp(header);
        try {
            Constructor<? extends Message> cons = op.getConstructor();

            /* Read the size to determine the body of the message. */
            int messageBodySize = LogUtils.readInt(header);
            nBytesRead.add(MESSAGE_HEADER_SIZE + messageBodySize);
            nMessagesRead.increment();
            if (messageBodySize > 0) {
                if (messageBodySize > maxMessageSize) {
                    throw EnvironmentFailureException.unexpectedState
                        ("Message op: " + op + " Body size: " +
                         messageBodySize + " is too large.  maxSizeAllowed: " +
                         maxMessageSize +
                         "\nIf a larger value is needed, set the " +
                         "'je.rep.maxMessageSize' parameter.");
                }

                ByteBuffer body = allocateBuffer(messageBodySize);
                fillBuffer(channel, body);
                return cons.newInstance(this, body);
            }

            if (messageBodySize < 0) {
                throw EnvironmentFailureException.unexpectedState
                    ("Message op: " + op + " Body size: " + messageBodySize);
            }
            /* No body */
            return cons.newInstance(this, null);
        } catch (InstantiationException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        } catch (IllegalAccessException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        } catch (SecurityException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        } catch (InvocationTargetException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        } finally {
            /* The header buffer will be reused, so clear it. */
            header.clear();
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends Message> T read(ReadableByteChannel channel, Class<T> cl)
        throws IOException, ProtocolException {

        Message message = read(channel);

        /*
         * Not the subclassing check instead an equality check makes it
         * convenient to deal with responses when there can be multiple
         * possible but related responses.
         */
        if (cl.isAssignableFrom(message.getClass())) {
            return (T)message;
        }
        throw new ProtocolException(message, cl);
    }

    /**
     * Write a message out to a channel.
     * @throws IOException
     */
    public void write(Message message, NamedChannel namedChannel)
        throws IOException {

        write(message, namedChannel, namedChannel.getNameIdPair());
    }

    /**
     * Write a message out to a channel.
     * @throws IOException
     */
    public void write(Message message, WritableByteChannel channel)
        throws IOException {

        write(message, channel, NameIdPair.NULL);
    }

    /**
     * Write a message out to a channel.
     * @throws IOException
     */
    private void write(Message message,
                       WritableByteChannel channel,
                       NameIdPair destinationNameIdPair)
        throws IOException {

        ByteBuffer messageBuffer = message.wireFormat();
        nBytesWritten.add(MESSAGE_HEADER_SIZE +
                                     messageBuffer.limit() -
                                     messageBuffer.position());
        nMessagesWritten.increment();

        final long start = System.nanoTime();
        while (messageBuffer.remaining() > 0) {
            int bytes = channel.write(messageBuffer);
            if (bytes == 0) {

                /*
                 * This should not happen since it's a blocking channel, but
                 * the java doc is vague on this subject, so yield control if
                 * we are not making progress.
                 */
                Thread.yield();
            }
        }
        nWriteNanos.add(System.nanoTime() -start);

        if (logger.isLoggable(Level.FINER)) {
            if (destinationNameIdPair == NameIdPair.NULL) {
                /* No nameIdPair was supplied, so use the channel. */
                LoggerUtils.logMsg(logger, envImpl, formatter, Level.FINER,
                                   "Sent " + message + " to " + channel);
            } else {
                LoggerUtils.logMsg(logger, envImpl, formatter, Level.FINER,
                                   "Sent to " +
                                   destinationNameIdPair.getName() +
                                   ": "+  message);
            }
        }

        /* Rewind the message buffer in case it's a reusable wire format */
        messageBuffer.rewind();
    }

    /**
     * Base message class for all messages exchanged in the protocol.
     * Serialized layout of a message: - opType (short) - size of the body of
     * the message (int) - body of the message - message specific fields
     * <p>
     * All non-abstract subclasses must implement a constructor with a
     * ByteBuffer argument. This constructor is used during serialization to
     * recreate the Message instance. It's considered good practice to declare
     * all attributes of a message as final. It's a simple way to ensure that
     * the above constructor has initialized all the attributes of the message.
     */
    public abstract class Message implements WireFormatable {

        public abstract MessageOp getOp();

        /**
         * The default message consists of the operation enum and just a 0
         * length size.
         */
        public ByteBuffer wireFormat() {
            ByteBuffer messageBuffer = allocateInitializedBuffer(0);
            messageBuffer.flip();
            return messageBuffer;
        }

        @Override
        public String toString() {
            return getOp().toString();
        }

        /*
         * For unit test support, so we can compare a message created for
         * sending against a message received. Some message types need to
         * override.
         */
        public boolean match(Message other) {
            return Arrays.equals(wireFormat().array().clone(),
                                 other.wireFormat().array().clone());
        }

        /**
         * Allocate a buffer for the message with the header initialized.
         *
         * @param size size of the message contents following the buffer
         *
         * @return the initialized buffer
         */
        public ByteBuffer allocateInitializedBuffer(int size) {
            ByteBuffer messageBuffer =
                allocateBuffer(MESSAGE_HEADER_SIZE + size);
            LogUtils.writeShort(messageBuffer, getOp().getOpId());
            LogUtils.writeInt(messageBuffer, size);
            return messageBuffer;
        }
    }

    /**
     * Base class for simple messages. Ones where performance is not of the
     * utmost importance and reflection can be used to simplify message
     * serialization and de-serialization.
     */
    protected abstract class SimpleMessage extends Message {

        /**
         * Assembles a sequence of arguments into its byte based wire format.
         * The method does the serialization in two steps. In step 1, it
         * calculates the length of the buffer. In step 2, it assembles the
         * bytes into the allocated buffer. The interpretive approach used here
         * is suitable for the low performance requirements of the handshake
         * protocol, but not for the core data stream itself. It's for this
         * reason that the method is associated with the Handshake message
         * class and not the Message class.
         *
         * @param opId the operation indicated by the message
         *
         * @param arguments the arguments to be passed in the message
         *
         * @return a byte buffer containing the serialized form of the message
         */
        protected ByteBuffer wireFormat(Object... arguments) {
            int size = getMessageSize(arguments);

            /* Allocate the buffer and fill it up */
            ByteBuffer buffer = allocateInitializedBuffer(size);

            for (Object obj : arguments) {
                Class<?> cl = obj.getClass();
                if (cl == Long.class) {
                    LogUtils.writeLong(buffer, ((Long)obj).longValue());
                } else if (cl == Integer.class) {
                    LogUtils.writeInt(buffer, ((Integer)obj).intValue());
                } else if (cl == Short.class) {
                    LogUtils.writeShort(buffer, ((Short)obj).shortValue());
                } else if (cl == Byte.class) {
                    buffer.put(((Byte)obj).byteValue());
                }  else if (cl == Boolean.class) {
                    buffer.put(((Boolean)obj).booleanValue() ?
                                (byte)1 :
                                (byte)0);
                } else if (cl == VLSN.class) {
                    LogUtils.writeLong(buffer, ((VLSN)obj).getSequence());
                } else if (Enum.class.isAssignableFrom(cl)) {
                    /* An enum is stored as it's identifier string. */
                    Enum<?> e = (Enum<?>)obj;
                    putString(e.name(), buffer);
                } else if (cl == String.class) {

                    /*
                     * A string is stored with its length followed by its
                     * contents.
                     */
                    putString((String)obj, buffer);
                } else if (cl == String[].class) {
                    String sa[] = (String[])obj;
                    LogUtils.writeInt(buffer, sa.length);
                    for (String element : sa) {
                        putString(element, buffer);
                    }
                } else if (cl == byte[].class) {
                    putByteArray(buffer, (byte[])obj);
                } else if (cl == RepNodeImpl[].class) {
                    putRepNodeImplArray(buffer, (RepNodeImpl[])obj);
                } else {
                    throw EnvironmentFailureException.unexpectedState
                        ("Unknow type: " + cl);
                }
            }
            buffer.flip();
            return buffer;
        }

        private void putByteArray(ByteBuffer buffer, byte[] ba) {
            LogUtils.writeInt(buffer, ba.length);
            buffer.put(ba);
        }

        private void putRepNodeImplArray(ByteBuffer buffer,
                                         RepNodeImpl[] ra) {
            LogUtils.writeInt(buffer, ra.length);
            for (RepNodeImpl node : ra) {
                putByteArray(buffer, RepGroupImpl.serializeBytes(node));
            }
        }

        protected RepNodeImpl[] getRepNodeImplArray(ByteBuffer buffer) {
            RepNodeImpl[] ra = new RepNodeImpl[LogUtils.readInt(buffer)];
            for (int i=0; i < ra.length; i++) {
                ra[i] = RepGroupImpl.deserializeNode(getByteArray(buffer));
            }
            return ra;
        }

        private int getSize(RepNodeImpl[] ra) {
            int size = 4; /* array length */
            for (RepNodeImpl node : ra) {
                size += (4 /* Node size */ +
                         RepGroupImpl.serializeBytes(node).length);
            }
            return size;
        }

        /**
         * Computes the size of a message with the supplied arguments. It must
         * match the actual serialization done in the wireFormat method above.
         */
        private int getMessageSize(Object... arguments) {
            int size = 0;
            /* Calculate the size */
            for (Object obj : arguments) {
                Class<?> cl = obj.getClass();
                if (cl == Long.class) {
                    size += 8;
                } else if (cl == Integer.class) {
                    size +=4;
                } else if (cl == Short.class) {
                    size +=2;
                } else if (cl == Byte.class) {
                    size +=1;
                } else if (cl == Boolean.class) {
                    size +=1;
                } else if (cl == VLSN.class) {
                    size += 8;
                } else if (Enum.class.isAssignableFrom(cl)) {
                    size += 4 + ((Enum<?>)obj).name().getBytes().length;
                } else if (cl == String.class) {
                   size += 4 + ((String)obj).getBytes().length;
                } else if (cl == String[].class) {
                    size += 4; /* array length */
                    String sa[] = (String[])obj;
                    for (String element : sa) {
                        size += element.getBytes().length + 4;
                    }
                } else if (cl == byte[].class) {
                    size += 4 + ((byte[])obj).length;
                } else if (cl == RepNodeImpl[].class) {
                    size += getSize((RepNodeImpl[])obj);
                } else {
                    throw EnvironmentFailureException.unexpectedState
                        ("Unknown type: " + cl);
                }
            }
            return size;
        }

        /**
         * Reconstitutes an array of strings.
         * @param buffer
         * @return
         */
        protected String[] getStringArray(ByteBuffer buffer) {
            String sa[] = new String[LogUtils.readInt(buffer)];
            for (int i=0; i < sa.length; i++) {
                sa[i] = getString(buffer);
            }
            return sa;
        }

        protected byte[] getByteArray(ByteBuffer buffer) {
            byte ba[] = new byte[LogUtils.readInt(buffer)];
            buffer.get(ba);
            return ba;
        }

        protected boolean getBoolean(ByteBuffer buffer) {
            byte b = buffer.get();
            if (b == 0) {
                return false;
            } else if (b == 1) {
                return true;
            } else {
                throw EnvironmentFailureException.unexpectedState
                    ("Unknown boolean value: " + b);
            }
        }

        protected VLSN getVLSN(ByteBuffer buffer) {
            long vlsn = LogUtils.readLong(buffer);
            return (vlsn == VLSN.NULL_VLSN.getSequence()) ?
                 VLSN.NULL_VLSN :
                 new VLSN(vlsn);
        }

        protected <T extends Enum<T>> T getEnum(Class<T> enumType,
                                                ByteBuffer buffer) {
            String enumName = getString(buffer);
            return Enum.valueOf(enumType, enumName);
        }
    }

    /**
     * The base class for reject responses to requests
     */
    public abstract class RejectMessage extends SimpleMessage {
        protected String errorMessage;

        protected RejectMessage(String errorMessage) {
            super();
            this.errorMessage = errorMessage;
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(errorMessage);

        }

        public RejectMessage(ByteBuffer buffer) {
            errorMessage = getString(buffer);
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        @Override
        public String toString() {
            return errorMessage;
        }
    }

    public class ProtocolError extends RejectMessage {

        public ProtocolError(String errorMessage) {
            super(errorMessage);
        }

        public ProtocolError(ByteBuffer buffer) {
            super(buffer);
        }

        @Override
        public MessageOp getOp() {
            return PROTOCOL_ERROR;
        }
    }

    /**
     * Version broadcasts the sending node's protocol version.
     */
    abstract class ProtocolVersion extends SimpleMessage {

        private final int version;

        private final int nodeId;

        public ProtocolVersion(int version) {
            super();
            this.version = version;
            this.nodeId = BinaryProtocol.this.nameIdPair.getId();
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(version, nodeId);
        }

        public ProtocolVersion(ByteBuffer buffer) {
            version = LogUtils.readInt(buffer);
            nodeId = LogUtils.readInt(buffer);
        }

        /**
         * @return the version
         */
        public int getVersion() {
            return version;
        }

        /**
         * The nodeId of the sender
         *
         * @return nodeId
         */
        public int getNodeId() {
            return nodeId;
        }
    }

    public class ClientVersion extends ProtocolVersion {

        public ClientVersion() {
            super(codeVersion);
        }

        public ClientVersion(ByteBuffer buffer) {
            super(buffer);
        }

        @Override
        public MessageOp getOp() {
            return CLIENT_VERSION;
        }
    }

    public class ServerVersion extends ProtocolVersion {

        public ServerVersion() {
            super(codeVersion);
        }

        public ServerVersion(ByteBuffer buffer) {
            super(buffer);
        }

        @Override
        public MessageOp getOp() {
            return SERVER_VERSION;
        }
    }

    public class IncompatibleVersion extends RejectMessage {
        public IncompatibleVersion(String message) {
            super(message);
        }

        public IncompatibleVersion(ByteBuffer buffer) {
            super(buffer);
        }

        @Override
        public MessageOp getOp() {
            return INCOMPATIBLE_VERSION;
        }
    }

    /**
     * Thrown in response to an unexpected response to a request.
     */
    @SuppressWarnings("serial")
    static public class ProtocolException extends InternalException {
        private final Message unexpectedMessage;

        private final Class<? extends Message> cl;

        /**
         * Constructor used for message sequencing errors.
         */
        public ProtocolException(Message unexpectedMessage,
                                 Class<? extends Message> cl) {
            super();
            this.unexpectedMessage = unexpectedMessage;
            this.cl = cl;
        }

        public ProtocolException(String message) {
            super(message);
            this.unexpectedMessage = null;
            this.cl = null;
        }

        @Override
        public String getMessage() {
            return (unexpectedMessage != null) ?
                    ("Expected message type: " + cl + " but found: " +
                     unexpectedMessage.getClass()) :
                    super.getMessage();
        }

        public Message getUnexpectedMessage() {
            return unexpectedMessage;
        }
    }
}
