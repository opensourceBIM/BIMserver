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

/**
 * {@link RpcConnectionFactory} for an RPC server. Similar to the client-side
 * factory, but also has a method to close the factory, which should to be
 * called when the server is being shut down.
 *
 * @author Shardul Deo
 */
public interface ServerRpcConnectionFactory extends RpcConnectionFactory,
    Closeable {

  /**
   * Stop accepting any more requests, should be called when shutting down the
   * server.
   */
  public void close() throws IOException;
}
