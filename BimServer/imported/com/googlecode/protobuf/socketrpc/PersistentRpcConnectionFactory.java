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

import java.io.Closeable;
import java.io.IOException;
import java.net.UnknownHostException;

import com.googlecode.protobuf.socketrpc.RpcConnectionFactory.Connection;

/**
 * An {@link RpcConnectionFactory} that uses a single {@link Connection} to send
 * and receive multiple RPCs. Note that this class and any channel created with
 * it sends RPCs serially if multiple threads try to send RPCs at the same time.
 * i.e. Any threads that make RPCs while one is currently in progress will be
 * blocked until previous RPCs complete. Also note that it does not guarantee
 * the order in which requests will be sent or received, therefore non-blocking
 * RPCs might not send and receive messages in any predictable order.
 * <p>
 * Also, since only a single {@link Connection} is used for all RPCs, the
 * {@link #close()} method must explicitly be called when the client has
 * finished using the factory.
 * <p>
 * If used with {@link SocketRpcConnectionFactories}, only delimited connection
 * factories can be used.
 *
 * @author Shardul Deo
 */
public class PersistentRpcConnectionFactory implements
    ServerRpcConnectionFactory, Closeable {

  private final RpcConnectionFactory factory;
  private volatile PersistentConnection connection = null;
  private final boolean server;

  /**
   * Create a client-side persistent {@link RpcConnectionFactory} which uses the
   * given factory to create the persistent {@link Connection}.
   * <p>
   * Since only a single {@link Connection} is used for all RPCs, the
   * {@link #close()} method must explicitly be called when the client has
   * finished using the factory.
   */
  public static PersistentRpcConnectionFactory createInstance(
      RpcConnectionFactory factory) {
    return new PersistentRpcConnectionFactory(factory, false /* server */);
  }

  /**
   * Create a server-side persistent {@link ServerRpcConnectionFactory} which
   * uses the given factory to create the persistent {@link Connection}.
   * <p>
   * Note: {@link #close()} shuts down both the {@link Connection} and the
   * factory.
   */
  public static ServerRpcConnectionFactory createServerInstance(
      ServerRpcConnectionFactory factory) {
    return new PersistentRpcConnectionFactory(factory, true /* server */);
  }

  private PersistentRpcConnectionFactory(
      RpcConnectionFactory rpcConnectionFactory, boolean server) {
    this.factory = rpcConnectionFactory;
    this.server = server;
  }

  @Override
  public Connection createConnection() throws UnknownHostException,
      IOException {
    // Use Java 1.5+ double checked locking to lazy init
    PersistentConnection local = connection;
    if (local == null) {
      local = initConnecton();
    }

    if (server) {
      // Server thread blocks here for readLock so that multiple handler threads
      // aren't created.
      local.acquireReadLock();
    }

    return local;
  }

  private synchronized PersistentConnection initConnecton()
      throws UnknownHostException, IOException {
    PersistentConnection local = connection;
    if (local == null) {
      connection = local = new PersistentConnection(factory.createConnection(),
          !server);
    }
    return local;
  }

  /**
   * Closes the connection used by this factory and in case of server-side,
   * closes the factory as well.
   *
   * @see Connection#close()
   * @see ServerRpcConnectionFactory#close()
   */
  public void close() throws IOException {
    PersistentConnection local = connection;
    if (local != null) {
      local.inner.close();
    }

    // Close server if needed.
    if (factory instanceof ServerRpcConnectionFactory) {
      ((ServerRpcConnectionFactory) factory).close();
    }
  }
}