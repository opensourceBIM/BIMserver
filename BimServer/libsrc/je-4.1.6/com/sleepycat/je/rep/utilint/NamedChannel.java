/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.utilint;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;

import com.sleepycat.je.rep.impl.node.NameIdPair;

/**
 * Packages a SocketChannel and a NameIdPair together so that logging
 * messages can show the node name instead of the channel toString();
 */
public class NamedChannel implements ByteChannel {

    private NameIdPair nameIdPair;
    protected final SocketChannel channel;

    public NamedChannel(SocketChannel channel, NameIdPair nameIdPair) {
        this.channel = channel;
        this.nameIdPair = nameIdPair;
    }

    /*
     * NameIdPair unknown at this time.
     */
    public NamedChannel(SocketChannel channel) {
        this.channel = channel;
        this.nameIdPair = NameIdPair.NULL;
    }

    public void setNameIdPair(NameIdPair nameIdPair) {
        this.nameIdPair = nameIdPair;
    }

    public NameIdPair getNameIdPair() {
        return nameIdPair;
    }

    public SocketChannel getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        if (getNameIdPair() == null) {
            return getChannel().toString();
        }

        return "(" + getNameIdPair() + ")" + getChannel();
    }

    /*
     * The following ByteChannel implementation methods delegate to the wrapped
     * channel object.
     */
    public int read(ByteBuffer dst) throws IOException {
        return channel.read(dst);
    }

    public void close() throws IOException {
        channel.close();
    }

    public boolean isOpen() {
        return channel.isOpen();
    }

    public int write(ByteBuffer src) throws IOException {
        return channel.write(src);
    }
}

