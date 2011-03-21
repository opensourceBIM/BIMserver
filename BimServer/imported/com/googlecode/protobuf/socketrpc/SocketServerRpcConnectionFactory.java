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

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.logging.Logger;

import javax.net.ServerSocketFactory;

/**
 * Implementation of {@link SocketServerRpcConnectionFactory} that uses
 * {@link ServerSocket} to receive/respond RPCs. Use
 * {@link SocketRpcConnectionFactories} to create instances.
 *
 * @author Shardul Deo
 */
class SocketServerRpcConnectionFactory implements ServerRpcConnectionFactory {

  private static final Logger LOG =
      Logger.getLogger(SocketServerRpcConnectionFactory.class.getName());

  private final int port;
  private final int backlog;
  private final InetAddress bindAddr;
  private final boolean delimited;
  private final ServerSocketFactory socketFactory;

  private volatile ServerSocket serverSocket = null;

  /**
   * @param port Port that this server socket will be started on.
   * @param delimited Use delimited communication mode.
   */
  public SocketServerRpcConnectionFactory(int port, boolean delimited) {
    this(port, 0, null, delimited);
  }

  /**
   * @param port Port that this server socket will be started on.
   * @param backlog the maximum length of the queue. A value <=0 uses default
   *        backlog.
   * @param bindAddr the local InetAddress the server socket will bind to. A
   *        null value binds to any/all local IP addresses.
   * @param delimited Use delimited communication mode.
   */
  public SocketServerRpcConnectionFactory(int port, int backlog,
      InetAddress bindAddr, boolean delimited) {
    this(port, backlog, bindAddr, delimited, ServerSocketFactory.getDefault());
  }

  // Visible for testing
  SocketServerRpcConnectionFactory(int port, int backlog,
      InetAddress bindAddr, boolean delimited,
      ServerSocketFactory socketFactory) {
    this.port = port;
    this.backlog = backlog;
    this.bindAddr = bindAddr;
    this.delimited = delimited;
    this.socketFactory = socketFactory;
  }

  @Override
  public Connection createConnection() throws IOException {
    // Use Java 1.5+ double checked locking to lazy init
    ServerSocket local = serverSocket;
    if (local == null) {
      local = initServerSocket();
    }
    // Thread blocks here waiting for requests
    return new SocketConnection(serverSocket.accept(), delimited);
  }

  private synchronized ServerSocket initServerSocket() throws IOException {
    ServerSocket local = serverSocket;
    if (local == null) {
      LOG.info("Listening for requests on port: " + port);
      serverSocket = local = socketFactory.createServerSocket(port, backlog,
          bindAddr);
    }
    return local;
  }

  @Override
  public void close() throws IOException {
    ServerSocket local = serverSocket;
    if (local != null && !local.isClosed()) {
      local.close();
    }
  }
}
