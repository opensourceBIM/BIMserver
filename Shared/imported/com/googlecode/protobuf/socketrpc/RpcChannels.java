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

import java.util.concurrent.Executor;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.RpcChannel;

/**
 * Utility class to create implementations of {@link RpcChannel} and
 * {@link BlockingRpcChannel} using a {@link RpcConnectionFactory}.
 * <p>
 * Use {@link SocketRpcConnectionFactory} to create channels that are
 * multithreaded (since a new socket is created for every RPC).
 * <p>
 * All channels created using this class MUST be used with
 * {@link SocketRpcController}.
 *
 * @see SocketRpcConnectionFactory
 * @see SocketRpcController
 *
 * @author Shardul Deo
 */
public final class RpcChannels {

  static final Executor SAME_THREAD_EXECUTOR = new Executor() {
    @Override
    public void execute(Runnable command) {
      command.run();
    }
  };

  private RpcChannels() {
  }

  /**
   * Create a {@link RpcChannel} that uses the given
   * {@link RpcConnectionFactory} to connect to the RPC server and the given
   * {@link Executor} to listen for the RPC response after sending the request.
   * RPCs made using this {@link RpcChannel} will not block the thread calling
   * the RPC method. Use {@link #newBlockingRpcChannel(RpcConnectionFactory)} if
   * you want the RPC method to block.
   * <p>
   * This channel doesn't call the callback if the server-side implementation
   * did not call the callback. If any error occurs, it will call the callback
   * with null and update the controller with the error.
   */
  public static RpcChannel newRpcChannel(
      RpcConnectionFactory connectionFactory, Executor executor) {
    return new RpcChannelImpl(connectionFactory, executor);
  }

  /**
   * Create a {@link BlockingRpcChannel} that uses the given
   * {@link RpcConnectionFactory} to connect to the RPC server.
   */
  public static BlockingRpcChannel newBlockingRpcChannel(
      RpcConnectionFactory connectionFactory) {
    return new RpcChannelImpl(connectionFactory, SAME_THREAD_EXECUTOR);
  }
}
