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
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.BlockingService;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.Service;
import com.googlecode.protobuf.socketrpc.RpcConnectionFactory.Connection;
import com.googlecode.protobuf.socketrpc.RpcForwarder.RpcException;
import com.googlecode.protobuf.socketrpc.SocketRpcProtos.ErrorReason;

/**
 * Generic RPC server that serves requests in the following way:
 * <ul>
 * <li>Connections are made using the provided
 * {@link ServerRpcConnectionFactory}. The implementation used must be
 * compatible with the implementation being used by the client making the RPC.
 * <li>Requests are handled in the provided {@link ExecutorService}.
 * <li>Handles both blocking and nonblocking RPCs. The server doesn't care
 * whether the client is blocking or not. It just finds the matching RPC
 * implementation and calls it.
 * <li>When calling a nonblocking service, the connection may be left open until
 * the callback is called based on the {@code
 * closeConnectionAfterInvokingService} constructor argument.
 * </ul>
 *
 * @author Shardul Deo
 */
public class RpcServer {

  private static final Logger LOG = Logger.getLogger(RpcServer.class.getName());

  private final RpcForwarder rpcForwarder;
  private final ServerRpcConnectionFactory rpcConnectionFactory;
  private final ExecutorService executor;
  private final ServerThread serverThread;
  private final boolean waitForCallback;

  /**
   * @param rpcConnectionFactory Factory to use to receive connections from
   *        clients. The implementation should be compatible with the factory
   *        being used by the client.
   * @param executorService Executor service be used for handling requests.
   * @param closeConnectionAfterInvokingService If set to false, when calling a
   *        nonblocking RPC, the incoming connection is left open until the
   *        callback is invoked by the service. This behavior is needed for
   *        truly async RPCs. If set to true, the incoming connection is closed
   *        immediately after invoking the service. This means that the service
   *        must invoke the callback passed to it in the same thread. Blocking
   *        services are not affected by this parameter.
   */
  public RpcServer(ServerRpcConnectionFactory rpcConnectionFactory,
      ExecutorService executorService,
      boolean closeConnectionAfterInvokingService) {
	  this.rpcForwarder = new RpcForwarder();
	  this.rpcConnectionFactory = rpcConnectionFactory;
		this.executor = executorService;
		this.serverThread = new ServerThread();
		serverThread.setDaemon(true);
		this.waitForCallback = !closeConnectionAfterInvokingService;
	}

  /**
   * Register an RPC service implementation on this server.
   */
  public void registerService(Service service) {
    rpcForwarder.registerService(service);
  }

  /**
   * Register an RPC blocking service implementation on this server.
   */
  public void registerBlockingService(BlockingService service) {
    rpcForwarder.registerBlockingService(service);
  }

  /**
   * Start the server to listen for requests. The calling thread is blocked
   * permanently.
   */
  public void run() {
    serverThread.run();
  }

  /**
   * Start the server to listen for requests in a separate. The calling thread
   * is not blocked. The server runs in a daemon thread so the JVM will exit
   * when no other thread is running. To manually shut down the server, call
   * {@link #shutDown()}.
   */
  public void startServer() {
    serverThread.start();
  }

  /**
   * Returns a {@link Runnable} which runs the server. This is useful if you
   * want to run the server using your own {@link ExecutorService}. Note that
   * {@link #shutDown()} can still be used to stop the server.
   */
  public Runnable getServerRunnable() {
    return serverThread;
  }

  /**
   * @return Whether the server is running.
   */
  public boolean isRunning() {
    return serverThread.isRunning();
  }

  /**
   * Stops this server. Any requests that are in progress are immediately shut
   * down. Also the {@link ExecutorService} provided while constructing the
   * server is also shut down.
   */
  public void shutDown() {
    serverThread.stopServer();
  }

  /**
   * Thread that runs the server.
   */
  private class ServerThread extends Thread {

    // Whether the server is running
    private volatile boolean running = false;

    @Override
    public void run() {
      LOG.info("Starting RPC server");
      try {
        running = true;
        while (running) {
          // Thread blocks here waiting for requests
          Connection connection = rpcConnectionFactory.createConnection();
          if (running && !executor.isShutdown()) {
            if (connection.isClosed()) {
              // Connection was closed, don't execute
              try {
                Thread.sleep(100);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            } else {
              executor.execute(new ConnectionHandler(connection));
            }
          }
        }
      } catch (IOException ex) {
        stopServer();
      } finally {
        running = false;
      }
    }

    private boolean isRunning() {
      return running;
    }

    private void stopServer() {
      if (isRunning()) {
        LOG.info("Shutting down RPC server");
        running = false;
        if (!executor.isShutdown()) {
          executor.shutdownNow();
        }
        try {
          rpcConnectionFactory.close();
        } catch (IOException e) {
          LOG.log(Level.WARNING, "Error while shutting down server", e);
        }
      }
    }
  }

  /**
   * Handles socket requests.
   */
  class ConnectionHandler implements Runnable {

    private final Connection connection;

    ConnectionHandler(Connection connection) {
      this.connection = connection;
    }

    public void run() {
      try {
        // Parse request
        SocketRpcProtos.Request.Builder builder = SocketRpcProtos.Request
            .newBuilder();
        connection.receiveProtoMessage(builder);
        if (!builder.isInitialized()) {
          sendResponse(handleError("Invalid request from client",
              ErrorReason.BAD_REQUEST_DATA, null));
          return;
        }

        SocketRpcProtos.Request rpcRequest = builder.build();
        if (waitForCallback) {
          forwardRpc(rpcRequest);
        } else {
          forwardBlockingRpc(rpcRequest);
        }
      } catch (IOException e) {
        sendResponse(handleError("Bad request data from client",
            ErrorReason.BAD_REQUEST_DATA, e));
      }
    }

    private void forwardRpc(SocketRpcProtos.Request rpcRequest) {
      // Create callback to pass to the forwarder
      RpcCallback<SocketRpcProtos.Response> rpcCallback =
          new RpcCallback<SocketRpcProtos.Response>() {
        @Override
        public void run(SocketRpcProtos.Response rpcResponse) {
          sendResponse(rpcResponse);
        }
      };

      // Forward request
      try {
        rpcForwarder.doRpc(rpcRequest, rpcCallback);
      } catch (RpcException e) {
        sendResponse(handleError(e.msg, e.errorReason, e.getCause()));
      }
    }

    private void forwardBlockingRpc(SocketRpcProtos.Request rpcRequest) {
      // Forward request
      try {
        SocketRpcProtos.Response rpcResponse =
            rpcForwarder.doBlockingRpc(rpcRequest);
        sendResponse(rpcResponse);
      } catch (RpcException e) {
        sendResponse(handleError(e.msg, e.errorReason, e.getCause()));
      }
    }

    private void sendResponse(SocketRpcProtos.Response rpcResponse) {
      try {
        if (connection.isClosed()) {
          // Connection was closed for some reason
          LOG.warning("Connection closed");
          return;
        }
        connection.sendProtoMessage(rpcResponse);
      } catch (IOException e) {
        LOG.log(Level.WARNING, "Error while writing", e);
      } finally {
        try {
          connection.close();
        } catch (IOException e) {
          // It's ok
          LOG.log(Level.WARNING, "Error while closing I/O", e);
        }
      }
    }

    private SocketRpcProtos.Response handleError(String msg,
        ErrorReason reason, Throwable throwable) {
      LOG.log(Level.WARNING, reason + ": " + msg, throwable);
      return SocketRpcProtos.Response
          .newBuilder()
          .setError(msg)
          .setErrorReason(reason)
          .build();
    }
  }
}
