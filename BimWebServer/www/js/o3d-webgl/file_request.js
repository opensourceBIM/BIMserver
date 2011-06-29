/*
 * Copyright 2010, Google Inc.
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
 * A FileRequest is used to carry out an asynchronous request for a file
 * to be loaded.  Its use parallels that of XMLHttpRequest; you create one, call
 * open, set the onreadystatechange callback, and call send.
 * Note that unlike XMLHttpRequests, FileRequests cannot be reused.
 *
 * For RawData loads, on success the RawData will be stored in the data field
 * on the FileRequest itself. It is only valid until the FileRequest is freed by
 * calling pack.removeObject(request).
 *
 * var request = pack.createFileRequest("RAWDATA");
 * request.open("GET", url, true);
 * request.onreadystatechange = function() {
 *   if (request.done) {
 *     if (request.success) {
 *       var rawData = request.data;
 *
 *       ...
 *     } else {
 *       dump('Load of rawdata returned failure.');
 *     }
 *
 *     pack.removeObject(request);
 *   }
 * };
 * request.send();
 */
o3d.FileRequest = function() {
  this.method_ = "";
  this.async_ = true;
  this.request_ = new XMLHttpRequest();
  var fileRequest = this;
  this.request_.onreadystatechange = function() {
    fileRequest.readyState = this.readyState;
    fileRequest.done = fileRequest.done || this.done;
    if (this.readyState == 4) {
      if (this.responseText) {
        fileRequest.success = true;
      }
      fileRequest.done = true;
    }
    fileRequest.data = this.responseText;
    if (fileRequest.onreadystatechange)
      fileRequest.onreadystatechange.apply(fileRequest, arguments);
  }
};
o3d.inherit('FileRequest', 'NamedObject');


/**
 * A callback to call whenever the ready state of the request changes.
 * @type {Object}
 */
o3d.FileRequest.prototype.onreadystatechange = null;



/**
 * The URI this request is for.
 * @type {string}
 */
o3d.FileRequest.prototype.uri = '';



/**
 * On completion of successful RawData file loads, this holds the loaded
 * RawData.
 * @type {o3d.RawData}
 */
o3d.FileRequest.prototype.data = null;



/**
 * This holds the same values as in XMLHttpRequest:
 *  0 = uninitialized
 *  1 = opened
 *  2 = sent
 *  3 = receiving
 *  4 = loaded (the file has been downloaded, but may or may not have been
 * parsed yet)
 * @type {number}
 */
o3d.FileRequest.prototype.readyState = 0;



/**
 * This indicates whether any further processing will be done on this
 * FileRequest.
 * @type {boolean}
 */
o3d.FileRequest.prototype.done = false;



/**
 * This field is only valid if done is true.  It indicates whether or not the
 * request succeeded. If it failed error holds an error message.
 * @type {boolean}
 */
o3d.FileRequest.prototype.success = false;


/**
 * The image object if we are opening an image.
 * @type {Image}
 * @private
 */
o3d.FileRequest.prototype.image_ = null;


/**
 * An error message.
 * If done is true and success is false this will be an error message
 * describing what went wrong.
 * @type {string}
 */
o3d.FileRequest.prototype.error = '';


/**
 * Guesses from a url whether the url is an image file.
 * @param {string} url The URL.
 * @private
 */
o3d.FileRequest.prototype.isImageUrl_ = function(url) {
  var extension = url.substring(url.length - 4);
  return (extension == '.png' || extension == '.jpg');
};


/**
 * Called by the image class when the image file is loaded... if we're
 * loading an image.
 * @private
 */
o3d.FileRequest.prototype.imageLoaded_ = function() {
  if (this.image_.complete) {
    this.success = true;
    this.done = true;
    this.readyState = 4;
    this.data = new o3d.RawData();
    this.data.image_ = this.image_;
  }
  this.onreadystatechange.apply(this, arguments);
};


/**
 * Set up several of the request fields.
 * @param {string} method "GET" is the only supported method at this time
 * @param {string} uri the location of the file to fetch
 * @param {boolean} async true is the only legal value at this time.
 */
o3d.FileRequest.prototype.open =
    function(method, uri, async) {
  this.uri = uri;
  this.method_ = method;
  this.async_ = async;
};


/**
 * Send the request.
 * Unlike XMLHttpRequest the onreadystatechange callback will be called no
 * matter what, with success or failure.
 */
o3d.FileRequest.prototype.send = function() {
  if (this.isImageUrl_(this.uri)) {
    this.image_ = new Image();
    var that = this;
    this.image_.onload = function() {
      that.imageLoaded_.call(that);
    }
    this.image_.src = this.uri;
  } else {
    this.request_.open(this.method_, this.uri, this.async_);
  }
};



