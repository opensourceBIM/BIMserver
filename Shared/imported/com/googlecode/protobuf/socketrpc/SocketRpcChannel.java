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

import javax.net.SocketFactory;

import com.google.protobuf.RpcCallback;

/**
 * Socket implementation of {@code RpcChannel}. Makes a synchronous RPC call to
 * a server running {@link SocketRpcServer} with the RPC method implementation
 * running on it.
 * <p>
 * If an {@link RpcCallback} is given, the {@code #callMethod(MethodDescriptor,
 * RpcController, Message, Message, RpcCallback)} method will invoke it with the
 * same protobuf that the RPC method implementation on the server side invoked
 * the callback with, or will not invoke it if that was the case on the server
 * side. If some error occurred, the callback will be invoked with null and the
 * controller will be updated.
 *
 * @deprecated Use {@link RpcChannels} to create {@code RpcChannel}s.
 *
 * @author Shardul Deo
 */
@Deprecated
public class SocketRpcChannel extends RpcChannelImpl {

  /**
   * Create a channel for TCP/IP RPCs.
   */
  public SocketRpcChannel(String host, int port) {
    this(host, port, SocketFactory.getDefault());
  }

  // Used for testing
  SocketRpcChannel(String host, int port, SocketFactory socketFactory) {
    super(new SocketRpcConnectionFactory(host, port, socketFactory,
        false /* delimited */), RpcChannels.SAME_THREAD_EXECUTOR);
  }

  /**
   * Create new rpc controller to be used to control one request.
   */
  public SocketRpcController newRpcController() {
    return new SocketRpcController();
  }
}
