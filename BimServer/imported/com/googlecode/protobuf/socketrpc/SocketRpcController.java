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

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.googlecode.protobuf.socketrpc.SocketRpcProtos.ErrorReason;

/**
 * Simple {@link RpcController}.
 *
 * @author Shardul Deo
 */
public class SocketRpcController implements RpcController {

  private boolean failed = false;
  private String error = null;
  private ErrorReason reason = null;

  public void reset() {
    failed = false;
    error = null;
    reason = null;
  }

  public boolean failed() {
    return failed;
  }

  /**
   * @return Reason for rpc error, to be used client side. Note that the reason
   *         might have been specified by the server or client.
   */
  public ErrorReason errorReason() {
    return reason;
  }

  public String errorText() {
    return error;
  }

  public void startCancel() {
    // Not yet supported
    throw new UnsupportedOperationException(
        "Cannot cancel request in Socket RPC");
  }

  public void setFailed(String reason) {
    failed = true;
    error = reason;
  }

  void setFailed(String error, ErrorReason errorReason) {
    setFailed(error);
    reason = errorReason;
  }

  public boolean isCanceled() {
    // Not yet supported
    throw new UnsupportedOperationException(
        "Cannot cancel request in Socket RPC");
  }

  public void notifyOnCancel(RpcCallback<Object> callback) {
    // Not yet supported
    throw new UnsupportedOperationException(
        "Cannot cancel request in Socket RPC");
  }

  @Override
  public String toString() {
    return new StringBuffer("SocketRpcController:")
        .append("\nFailed: " + failed)
        .append("\nError: " + error)
        .append("\nReason: " + reason).toString();
  }
}
