/*
 * Copyright 2009, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


/**
 * @fileoverview This file contains various error handing functions for o3d.
 *
 */

o3djs.provide('o3djs.error');

/**
 * A Module with various error handing functions.
 *
 * This module is for helping to manage the client's error callback.
 * Because you can not read the current callback on the client we wrap it with
 * these utilities which track the last callback added so as long as you use
 * o3djs.error.setErrorHandler(client, callback) instead of
 * client.setErrorCallback you'll be able to get and restore the error callback
 * when you need to.
 * @namespace
 */
o3djs.error = o3djs.error || {};

/**
 * A map of error callbacks by client.
 * @private
 * @type {!Array.<(function(string): void|null)>}
 */
o3djs.error.callbacks_ = [];

/**
 * Sets the error handler on a client to a handler that manages the client's
 * error callback.
 * displays an alert on the first error.
 * @param {!o3d.Client} client The client object of the plugin.
 * @param {(function(string): void|null)} callback The callack to use, null to
 *     clear.
 * @return {(function(string): void|null)} the previous error callback for this
 *     client.
 */
o3djs.error.setErrorHandler = function(client, callback) {
  var clientId = client.clientId;
  var old_callback = o3djs.error.callbacks_[clientId];
  o3djs.error.callbacks_[clientId] = callback;
  if (callback) {
    client.setErrorCallback(callback);
  } else {
    client.clearErrorCallback();
  }
  return old_callback;
};

/**
 * Sets a default error handler on the client.
 * The default error handler displays an alert on the first error encountered.
 * @param {!o3d.Client} client The client object of the plugin.
 */
o3djs.error.setDefaultErrorHandler = function(client) {
  o3djs.error.setErrorHandler(
      client,
      function(msg) {
        // Clear the error callback. Otherwise if the callback is happening
        // during rendering it's possible the user will not be able to
        // get out of an infinite loop of alerts.
        o3djs.error.setErrorHandler(client, null);
        alert('ERROR: ' + msg);
      });
};

/**
 * Creates an ErrorCollector.
 * @param {!o3d.Client} client The client object of the plugin.
 * @return {!o3djs.error.ErrorCollector} The created error collector.
 */
o3djs.error.createErrorCollector = function(client) {
  return new o3djs.error.ErrorCollector(client);
};

/**
 * An ErrorCollector takes over the client error callback and continues
 * to collect errors until ErrorCollector.finish() is called.
 * @constructor
 * @param {!o3d.Client} client The client object of the plugin.
 */
o3djs.error.ErrorCollector = function(client) {
  var that = this;
  this.client_ = client;
  /**
   * The collected errors.
   * @type {!Array.<string>}
   */
  this.errors = [];
  this.oldCallback_ = o3djs.error.setErrorHandler(client, function(msg) {
          that.errors.push(msg);
      });
};

/**
 * Stops the ErrorCollector from collecting errors and restores the previous
 * error callback.
 */
o3djs.error.ErrorCollector.prototype.finish = function() {
  o3djs.error.setErrorHandler(this.client_, this.oldCallback_);
};
