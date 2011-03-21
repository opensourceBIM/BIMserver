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
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite.Builder;
import com.googlecode.protobuf.socketrpc.RpcConnectionFactory.Connection;

/**
 * Persistent wrapper for a {@link Connection}. This connection can be used
 * multiple times and is also thread safe.
 *
 * @author Shardul Deo
 */
class PersistentConnection implements Connection {

  private final boolean client;
  final Connection inner;

  // Using fair locks so threads don't wait for too long
  private final Semaphore readLock = new Semaphore(1, true /* fair */);
  private final ReentrantLock writeLock = new ReentrantLock(true /* fair */);

  PersistentConnection(Connection connection, boolean client) {
    this.inner = connection;
    this.client = client;
  }

  @Override
  public void sendProtoMessage(MessageLite message)
      throws IOException {
    try {
      writeLock.lockInterruptibly();
    } catch (InterruptedException e) {
      throw new IOException("Interrupted while waiting for write lock", e);
    }
    try {
      inner.sendProtoMessage(message);
    } finally {
      writeLock.unlock();
    }
  }

  /**
   * Try to acquire read lock on this connection and block until it is
   * available.
   *
   * @throws IOException If acquiring read lock was interrupted.
   */
  void acquireReadLock() throws IOException {
    try {
      readLock.acquire();
    } catch (InterruptedException e) {
      throw new IOException("Interrupted while waiting for read lock", e);
    }
  }

  @Override
  public void receiveProtoMessage(Builder messageBuilder) throws IOException {
    // Get lock if client, for server it should already have lock
    if (client) {
      acquireReadLock();
    } else {
      readLock.drainPermits();
    }
    try {
      inner.receiveProtoMessage(messageBuilder);
    } finally {
      readLock.release();
    }
  }

  @Override
  public void close() {
    // No-op since we want to reuse it.
  }

  @Override
  public boolean isClosed() {
    return inner.isClosed();
  }
}
