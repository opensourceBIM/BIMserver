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
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcChannel;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.googlecode.protobuf.socketrpc.RpcConnectionFactory.Connection;
import com.googlecode.protobuf.socketrpc.SocketRpcProtos.ErrorReason;
import com.googlecode.protobuf.socketrpc.SocketRpcProtos.Response;

/**
 * {@link RpcChannel} implementation that uses a {@link RpcConnectionFactory} to
 * perform blocking and non-blocking rpcs.
 *
 * @author Shardul Deo
 */
class RpcChannelImpl implements RpcChannel, BlockingRpcChannel {

  private final static Logger LOG =
      Logger.getLogger(RpcChannelImpl.class.getName());

  private final RpcConnectionFactory connectionFactory;
  private final Executor executor;

  RpcChannelImpl(RpcConnectionFactory connectionFactory, Executor executor) {
    this.connectionFactory = connectionFactory;
    this.executor = executor;
  }

  @Override
  public void callMethod(MethodDescriptor method, RpcController controller,
      Message request, final Message responsePrototype,
      final RpcCallback<Message> done) {
    // Must pass in a SocketRpcController
    final SocketRpcController socketController
        = (SocketRpcController) controller;

    // Send request over connection
    final Connection connection;
    try {
      connection = createConnection(socketController);
    } catch (ServiceException e) {
      // Call done with null, controller has the error information
      callbackWithNull(done);
      return;
    }

    try {
      sendRpcRequest(method, socketController, request, connection);
    } catch (ServiceException e) {
      // Call done with null, controller has the error information
      try {
        callbackWithNull(done);
      } finally {
        close(connection);
      }
      return;
    }

    // Listen for the response using the executor
    executor.execute(new Runnable() {
      @Override
      public void run() {
        try {
          // Thread blocks here until server sends a response
          Response rpcResponse = receiveRpcResponse(socketController,
              connection);
          Message response = handleRpcResponse(responsePrototype, rpcResponse,
              socketController);

          // Callback if failed or server invoked callback
          if (socketController.failed() || rpcResponse.getCallback()) {
            if (done != null) {
              done.run(response);
            }
          }
        } catch (ServiceException e) {
          // Call done with null, controller has the error information
          callbackWithNull(done);
        } finally {
          close(connection);
        }
      }
    });
  }

  private static void callbackWithNull(RpcCallback<Message> done) {
    if (done != null) {
      done.run(null);
    }
  }

  @Override
  public Message callBlockingMethod(MethodDescriptor method,
      RpcController controller, Message request, Message responsePrototype)
      throws ServiceException {
    // Must pass in a SocketRpcController
    SocketRpcController socketController = (SocketRpcController) controller;
    final Connection connection = createConnection(socketController);
    try {
      sendRpcRequest(method, socketController, request, connection);
      Response rpcResponse = receiveRpcResponse(socketController, connection);
      return handleRpcResponse(responsePrototype, rpcResponse,
          socketController);
    } finally {
      close(connection);
    }
  }

  private Connection createConnection(SocketRpcController socketController)
      throws ServiceException {
    try {
      return connectionFactory.createConnection();
    } catch (UnknownHostException e) {
      return handleError(socketController, ErrorReason.UNKNOWN_HOST,
          "Could not find host: " + e.getMessage(), e);
    } catch (IOException e) {
      return handleError(socketController, ErrorReason.IO_ERROR, String.format(
          "Error creating connection using factory %s", connectionFactory), e);
    }
  }

  private void close(Connection connection) {
    try {
      connection.close();
    } catch (IOException e) {
      // It's ok
    }
  }

  private void sendRpcRequest(MethodDescriptor method,
      SocketRpcController socketController, Message request,
      Connection connection) throws ServiceException {
    // Check request
    if (!request.isInitialized()) {
      handleError(socketController, ErrorReason.INVALID_REQUEST_PROTO,
          "Request is uninitialized", null);
    }

    // Create RPC request protobuf
    SocketRpcProtos.Request rpcRequest = SocketRpcProtos.Request.newBuilder()
        .setRequestProto(request.toByteString())
        .setServiceName(method.getService().getFullName())
        .setMethodName(method.getName())
        .build();

    // Send request
    try {
      connection.sendProtoMessage(rpcRequest);
    } catch (IOException e) {
      handleError(socketController, ErrorReason.IO_ERROR, String.format(
          "Error writing over connection %s", connection), e);
    }
  }

  private Response receiveRpcResponse(SocketRpcController socketController,
      Connection connection) throws ServiceException {
    try {
      // Read and handle response
      SocketRpcProtos.Response.Builder builder = SocketRpcProtos.Response
          .newBuilder();
      connection.receiveProtoMessage(builder);
      if (!builder.isInitialized()) {
        return handleError(socketController, ErrorReason.BAD_RESPONSE_PROTO,
            "Bad response from server", null);
      }
      return builder.build();
    } catch (IOException e) {
      return handleError(socketController, ErrorReason.IO_ERROR, String.format(
          "Error reading over connection %s", connection), e);
    }
  }

  private Message handleRpcResponse(Message responsePrototype,
      SocketRpcProtos.Response rpcResponse,
      SocketRpcController socketController)
      throws ServiceException {

    // Check for error
    if (rpcResponse.hasError()) {
      return handleError(socketController, rpcResponse.getErrorReason(),
          rpcResponse.getError(), null);
    }

    if (!rpcResponse.hasResponseProto()) {
      // No response
      return null;
    }

    try {
      Message.Builder builder = responsePrototype.newBuilderForType()
          .mergeFrom(rpcResponse.getResponseProto());
      if (!builder.isInitialized()) {
        return handleError(socketController, ErrorReason.BAD_RESPONSE_PROTO,
            "Uninitialized RPC Response Proto", null);
      }
      return builder.build();
    } catch (InvalidProtocolBufferException e) {
      return handleError(socketController, ErrorReason.BAD_RESPONSE_PROTO,
          "Response could be parsed as "
              + responsePrototype.getClass().getName(), e);
    }
  }

  private <T> T handleError(SocketRpcController socketController,
      ErrorReason reason, String msg, Exception e)
      throws ServiceException {
    if (e == null) {
      LOG.log(Level.WARNING, reason + ": " + msg);
    } else {
      LOG.log(Level.WARNING, reason + ": " + msg, e);
    }
    socketController.setFailed(msg, reason);
    throw new ServiceException(msg);
  }
}
