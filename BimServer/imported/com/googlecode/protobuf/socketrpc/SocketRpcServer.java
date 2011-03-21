// Copyright (c) 2009 Shardul Deo
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
import java.util.concurrent.ExecutorService;

/**
 * Socket server for running RPC services. It can serve requests for any
 * registered service from any client who is using a
 * {@link SocketRpcConnectionFactory}.
 * <p>
 * Note that this server can only handle synchronous requests, so if the service
 * implementation does not invoke the callback in the same thread, no response
 * will be sent back to the client.
 *
 * @deprecated Use {@link RpcServer} with
 *             {@link SocketServerRpcConnectionFactory} instead.
 *
 * @author Shardul Deo
 */
@Deprecated
public class SocketRpcServer extends RpcServer {

  /**
   * @param port Port that this server will be started on.
   * @param executorService To be used for handling requests.
   */
  public SocketRpcServer(int port, ExecutorService executorService) {
    this(port, 0, null, executorService);
  }

  /**
   * Constructor with customization to pass into java.net.ServerSocket(int port,
   * int backlog, InetAddress bindAddr)
   *
   * @param port
   *          Port that this server will be started on.
   * @param backlog
   *          the maximum length of the queue. A value <=0 uses default backlog.
   * @param bindAddr
   *          the local InetAddress the server will bind to. A null value binds
   *          to any/all local ip addresses.
   * @param executorService
   *          executorService To be used for handling requests.
   */
	public SocketRpcServer(int port, int backlog, InetAddress bindAddr,
			ExecutorService executorService) {
    super(new SocketServerRpcConnectionFactory(port, backlog, bindAddr,
        false /* delimited */), executorService,
        true /* closeConnectionAfterInvokingService */);
	}
}
