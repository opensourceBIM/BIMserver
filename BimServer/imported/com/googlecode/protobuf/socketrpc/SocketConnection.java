// Copyright (c) 2010 Shardul Deo
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

package com.googlecode.protobuf.socketrpc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite.Builder;
import com.googlecode.protobuf.socketrpc.RpcConnectionFactory.Connection;

/**
 * {@link Connection} impl that wraps a {@link Socket}.
 *
 * @author Shardul Deo
 */
class SocketConnection implements Connection {

  private final Socket socket;
  private final OutputStream out;
  private final InputStream in;
  private final boolean delimited;

  SocketConnection(Socket socket, boolean delimited) throws IOException {
    this.socket = socket;
    this.delimited = delimited;

    // Create input/output streams
    try {
      out = new BufferedOutputStream(socket.getOutputStream());
      in = new BufferedInputStream(socket.getInputStream());
    } catch (IOException e) {
      // Cleanup and rethrow
      try {
        socket.close();
      } catch (IOException ioe) {
        // It's ok
      }
      throw e;
    }
  }

  @Override
  public void sendProtoMessage(MessageLite message) throws IOException {
    // Write message
    if (delimited) {
      try {
        message.writeDelimitedTo(out);
        out.flush();
      } catch (IOException e) {
        // Cannot write anymore, just close socket
        socket.close();
        throw e;
      }
    } else {
      message.writeTo(out);
      out.flush();
      socket.shutdownOutput();
    }
  }

  @Override
  public void receiveProtoMessage(Builder messageBuilder) throws IOException {
    // Read message
    if (delimited) {
      messageBuilder.mergeDelimitedFrom(in);
    } else {
      messageBuilder.mergeFrom(in);
    }
  }

  @Override
  public void close() throws IOException {
    if (!socket.isClosed()) {
      socket.close();
    }
  }

  @Override
  public boolean isClosed() {
    return socket.isClosed();
  }
}