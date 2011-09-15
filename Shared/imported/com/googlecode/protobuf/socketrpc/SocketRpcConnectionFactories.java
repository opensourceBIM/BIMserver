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

import java.net.InetAddress;

import com.google.protobuf.Message;
import com.googlecode.protobuf.socketrpc.RpcConnectionFactory.Connection;

/**
 * Utility class for creating {@link RpcConnectionFactory}s which use sockets
 * for client/server communication.
 * <p>
 * This class contains deprecated methods to create factories that are to be
 * used with client/servers that are using old code which use the old style
 * undelimited communication mode. It is highly recommended you update both the
 * client and servers to use the new methods which use the delimited
 * communication mode.
 * <p>
 * The delimited communication mode allows multiple request and/or responses to
 * be send over the a single {@link Connection} instance.
 *
 * @see Message#writeDelimitedTo(java.io.OutputStream)
 * @see Message.Builder#mergeDelimitedFrom(java.io.InputStream)
 *
 * @author Shardul Deo
 */
public class SocketRpcConnectionFactories {

  private SocketRpcConnectionFactories() {
  }

  /**
   * Create a client-side {@link RpcConnectionFactory}. This uses delimited
   * communication mode which allows multiple protocol buffers to be
   * sent/received over a single {@link Connection}.
   */
  public static RpcConnectionFactory createRpcConnectionFactory(String host,
      int port) {
    return new SocketRpcConnectionFactory(host, port, true /* delimited */);
  }

  /**
   * Create an undelimited mode client-side {@link RpcConnectionFactory}. Only
   * one RPC (request/response pair) can be performed over a single
   * {@link Connection}.
   *
   * @deprecated Uses old delimited communication mode. Change client/server to
   *             use delimited mode.
   */
  @Deprecated
  public static RpcConnectionFactory createUndelimitedRpcConnectionFactory(
      String host, int port) {
    return new SocketRpcConnectionFactory(host, port, false /* delimited */);
  }

  /**
   * Create a server-side {@link ServerRpcConnectionFactory} at the given port.
   * This uses delimited communication mode which allows multiple protocol
   * buffers to be sent/received over a single {@link Connection}.
   */
  public static ServerRpcConnectionFactory createServerRpcConnectionFactory(
      int port) {
    return new SocketServerRpcConnectionFactory(port, true /* delimited */);
  }

  /**
   * Create a server-side {@link ServerRpcConnectionFactory} at the given port.
   * This uses delimited communication mode which allows multiple protocol
   * buffers to be sent/received over a single {@link Connection}.
   *
   * @param port Port that this server socket will be started on.
   * @param backlog the maximum length of the queue. A value <=0 uses default
   *        backlog.
   * @param bindAddr the local InetAddress the server socket will bind to. A
   *        null value binds to any/all local IP addresses.
   */
  public static ServerRpcConnectionFactory createServerRpcConnectionFactory(
      int port, int backlog, InetAddress bindAddr) {
    return new SocketServerRpcConnectionFactory(port, backlog, bindAddr,
        true /* delimited */);
  }

  /**
   * Create an undelimited server-side {@link ServerRpcConnectionFactory} at the
   * given port. This uses delimited communication mode. Only one RPC
   * (request/response pair) can be performed over a single {@link Connection}.
   *
   * @param port Port that this server socket will be started on.
   * @param backlog the maximum length of the queue. A value <=0 uses default
   *        backlog.
   * @param bindAddr the local InetAddress the server socket will bind to. A
   *        null value binds to any/all local IP addresses.
   *
   * @deprecated Uses old delimited communication mode. Change client/server to
   *             use delimited mode.
   */
  @Deprecated
  public static ServerRpcConnectionFactory
      createUndelimitedServerRpcConnectionFactory(
          int port, int backlog, InetAddress bindAddr) {
    return new SocketServerRpcConnectionFactory(port, backlog, bindAddr,
        false /* delimited */);
  }
}
