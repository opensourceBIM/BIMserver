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
 * @fileoverview This file contains various functions and class for io.
 */

o3djs.provide('o3djs.io');

o3djs.require('o3djs.texture');


/**
 * A Module with various io functions and classes.
 * @namespace
 */
o3djs.io = o3djs.io || {};

/**
 * Creates a LoadInfo object.
 * @param {(!o3d.ArchiveRequest|!o3d.FileRequest|!XMLHttpRequest)} opt_request
 *     The request to watch.
 * @param {boolean} opt_hasStatus true if opt_request is a
 *     o3d.ArchiveRequest vs for example an o3d.FileRequest or an
 *     XMLHttpRequest.
 * @return {!o3djs.io.LoadInfo} The new LoadInfo.
 * @see o3djs.io.LoadInfo
 */
o3djs.io.createLoadInfo = function(opt_request, opt_hasStatus) {
  return new o3djs.io.LoadInfo(opt_request, opt_hasStatus);
};

/**
 * A class to help with progress reporting for most loading utilities.
 *
 * Example:
 * <pre>
 * var g_loadInfo = null;
 * g_id = window.setInterval(statusUpdate, 500);
 * g_loadInfo = o3djs.scene.loadScene(client, pack, parent,
 *                                    'http://google.com/somescene.o3dtgz',
 *                                    callback);
 *
 * function callback(pack, parent, exception) {
 *   g_loadInfo = null;
 *   window.clearInterval(g_id);
 *   if (!exception) {
 *     // do something with scene just loaded
 *   }
 * }
 *
 * function statusUpdate() {
 *   if (g_loadInfo) {
 *     var progress = g_loadInfo.getKnownProgressInfoSoFar();
 *     document.getElementById('loadstatus').innerHTML = progress.percent;
 *   }
 * }
 * </pre>
 *
 * @constructor
 * @param {(!o3d.ArchiveRequest|!o3d.FileRequest|!XMLHttpRequest)} opt_request
 *     The request to watch.
 * @param {boolean} opt_hasStatus true if opt_request is a
 *     o3d.ArchiveRequest vs for example an o3d.FileRequest or an
 *     XMLHttpRequest.
 * @see o3djs.scene.loadScene
 * @see o3djs.io.loadArchive
 * @see o3djs.io.loadTexture
 * @see o3djs.loader.Loader
 */
o3djs.io.LoadInfo = function(opt_request, opt_hasStatus) {
  this.request_ = opt_request;
  this.hasStatus_ = opt_hasStatus;
  this.streamLength_ = 0;  // because the request may have been freed.
  this.children_ = [];
};

/**
 * Adds another LoadInfo as a child of this LoadInfo so they can be
 * managed as a group.
 * @param {!o3djs.io.LoadInfo} loadInfo The child LoadInfo.
 */
o3djs.io.LoadInfo.prototype.addChild = function(loadInfo) {
  this.children_.push(loadInfo);
};

/**
 * Marks this LoadInfo as finished.
 */
o3djs.io.LoadInfo.prototype.finish = function() {
  if (this.request_) {
    if (this.hasStatus_) {
      this.streamLength_ = this.request_.streamLength;
    }
    this.request_ = null;
  }
};

/**
 * Gets the total bytes that will be streamed known so far.
 * If you are only streaming 1 file then this will be the info for that file but
 * if you have queued up many files using an o3djs.loader.Loader only a couple of
 * files are streamed at a time meaning that the size is not known for files
 * that have yet started to download.
 *
 * If you are downloading many files for your application and you want to
 * provide a progress status you have about 4 options
 *
 * 1) Use LoadInfo.getTotalBytesDownloaded() /
 * LoadInfo.getTotalKnownBytesToStreamSoFar() and just be aware the bar will
 * grown and then shrink as new files start to download and their lengths
 * become known.
 *
 * 2) Use LoadInfo.getTotalRequestsDownloaded() /
 * LoadInfo.getTotalKnownRequestsToStreamSoFar() and be aware the granularity
 * is not all that great since it only reports fully downloaded files. If you
 * are downloading a bunch of small files this might be ok.
 *
 * 3) Put all your files in one archive. Then there will be only one file and
 * method 1 will work well.
 *
 * 4) Figure out the total size in bytes of the files you will download and put
 * that number in your application, then use LoadInfo.getTotalBytesDownloaded()
 * / MY_APPS_TOTAL_BYTES_TO_DOWNLOAD.
 *
 * @return {number} The total number of currently known bytes to be streamed.
 */
o3djs.io.LoadInfo.prototype.getTotalKnownBytesToStreamSoFar = function() {
  if (!this.streamLength_ && this.request_ && this.hasStatus_) {
    this.streamLength_ = this.request_.streamLength;
  }
  var total = this.streamLength_;
  for (var cc = 0; cc < this.children_.length; ++cc) {
    total += this.children_[cc].getTotalKnownBytesToStreamSoFar();
  }
  return total;
};

/**
 * Gets the total bytes downloaded so far.
 * @return {number} The total number of currently known bytes to be streamed.
 */
o3djs.io.LoadInfo.prototype.getTotalBytesDownloaded = function() {
  var total = (this.request_ && this.hasStatus_) ?
              this.request_.bytesReceived : this.streamLength_;
  for (var cc = 0; cc < this.children_.length; ++cc) {
    total += this.children_[cc].getTotalBytesDownloaded();
  }
  return total;
};

/**
 * Gets the total streams that will be download known so far.
 * We can't know all the streams since you could use an o3djs.loader.Loader
 * object, request some streams, then call this function, then request some
 * more.
 *
 * See LoadInfo.getTotalKnownBytesToStreamSoFar for details.
 * @return {number} The total number of requests currently known to be streamed.
 * @see o3djs.io.LoadInfo.getTotalKnownBytesToStreamSoFar
 */
o3djs.io.LoadInfo.prototype.getTotalKnownRequestsToStreamSoFar = function() {
  var total = 1;
  for (var cc = 0; cc < this.children_.length; ++cc) {
    total += this.children_[cc].getTotalKnownRequestToStreamSoFar();
  }
  return total;
};

/**
 * Gets the total requests downloaded so far.
 * @return {number} The total requests downloaded so far.
 */
o3djs.io.LoadInfo.prototype.getTotalRequestsDownloaded = function() {
  var total = this.request_ ? 0 : 1;
  for (var cc = 0; cc < this.children_.length; ++cc) {
    total += this.children_[cc].getTotalRequestsDownloaded();
  }
  return total;
};

/**
 * Gets progress info.
 * This is commonly formatted version of the information available from a
 * LoadInfo.
 *
 * See LoadInfo.getTotalKnownBytesToStreamSoFar for details.
 * @return {{percent: number, downloaded: string, totalBytes: string,
 *     base: number, suffix: string}} progress info.
 * @see o3djs.io.LoadInfo.getTotalKnownBytesToStreamSoFar
 */
o3djs.io.LoadInfo.prototype.getKnownProgressInfoSoFar = function() {
  var percent = 0;
  var bytesToDownload = this.getTotalKnownBytesToStreamSoFar();
  var bytesDownloaded = this.getTotalBytesDownloaded();
  if (bytesToDownload > 0) {
    percent = Math.floor(bytesDownloaded / bytesToDownload * 100);
  }

  var base = (bytesToDownload < 1024 * 1024) ? 1024 : (1024 * 1024);

  return {
    percent: percent,
    downloaded: (bytesDownloaded / base).toFixed(2),
    totalBytes: (bytesToDownload / base).toFixed(2),
    base: base,
    suffix: (base == 1024 ? 'kb' : 'mb')}

};

/**
 * Loads text from an external file. This function is synchronous.
 * @param {string} url The url of the external file.
 * @return {string} the loaded text if the request is synchronous.
 */
o3djs.io.loadTextFileSynchronous = function(url) {
  o3djs.BROWSER_ONLY = true;

  var error = 'loadTextFileSynchronous failed to load url "' + url + '"';
  var request;
  if (!o3djs.base.IsMSIE() && window.XMLHttpRequest) {
    request = new XMLHttpRequest();
    if (request.overrideMimeType) {
      request.overrideMimeType('text/plain');
    }
  } else if (window.ActiveXObject) {
    request = new ActiveXObject('MSXML2.XMLHTTP.3.0');
  } else {
    throw 'XMLHttpRequest is disabled';
  }
  request.open('GET', url, false);
  request.send(null);
  if (request.readyState != 4) {
    throw error;
  }
  return request.responseText;
};

/**
 * Loads text from an external file. This function is asynchronous.
 * @param {string} url The url of the external file.
 * @param {function(string, *): void} callback A callback passed the loaded
 *     string and an exception which will be null on success.
 * @return {!o3djs.io.LoadInfo} A LoadInfo to track progress.
 */
o3djs.io.loadTextFile = function(url, callback) {
  o3djs.BROWSER_ONLY = true;

  var error = 'loadTextFile failed to load url "' + url + '"';
  var request;
  if (!o3djs.base.IsMSIE() && window.XMLHttpRequest) {
    request = new XMLHttpRequest();
    if (request.overrideMimeType) {
      request.overrideMimeType('text/plain');
    }
  } else if (window.ActiveXObject) {
    request = new ActiveXObject('MSXML2.XMLHTTP.3.0');
  } else {
    throw 'XMLHttpRequest is disabled';
  }
  var loadInfo = o3djs.io.createLoadInfo(request, false);
  request.open('GET', url, true);
  var finish = function() {
    if (request.readyState == 4) {
      var text = '';
      // HTTP reports success with a 200 status. The file protocol reports
      // success with zero. HTTP does not use zero as a status code (they
      // start at 100).
      // https://developer.mozilla.org/En/Using_XMLHttpRequest
      var success = request.status == 200 || request.status == 0;
      if (success) {
        text = request.responseText;
      }
      loadInfo.finish();
      callback(text, success ? null : 'could not load: ' + url);
    }
  };
  request.onreadystatechange = finish;
  request.send(null);
  return loadInfo;
};

/**
 * A ArchiveInfo object loads and manages an archive of files.
 * There are methods for locating a file by uri and for freeing
 * the archive.
 *
 * You can only read archives that have as their first file a file named
 * 'aaaaaaaa.o3d' the contents of the which is 'o3d'. This is to prevent O3D
 * from being used to read arbitrary tar gz files.
 *
 * Example:
 * <pre>
 * var loadInfo = o3djs.io.loadArchive(pack,
 *                                     'http://google.com/files.o3dtgz',
 *                                     callback);
 *
 * function callback(archiveInfo, exception) {
 *   if (!exception) {
 *     o3djs.texture.createTextureFromRawData(
 *         pack, archiveInfo.getFileByURI('logo.jpg'), true);
 *     o3djs.texture.createTextureFromRawData(
 *         pack, archiveInfo.getFileByURI('wood/oak.png'), true);
 *     o3djs.texture.createTextureFromRawData(
 *         pack, archiveInfo.getFileByURI('wood/maple.dds'), true);
 *     archiveInfo.destroy();
 *   } else {
 *     alert(exception);
 *   }
 * }
 * </pre>
 *
 * @constructor
 * @param {!o3d.Pack} pack Pack to create request in.
 * @param {string} url The url of the archive file.
 * @param {!function(!o3djs.io.ArchiveInfo, *): void} onFinished A
 *     callback that is called when the archive is finished loading and passed
 *     the ArchiveInfo and an exception which is null on success.
 */
o3djs.io.ArchiveInfo = function(pack, url, onFinished) {
  var that = this;

  /**
   * The list of files in the archive by uri.
   * @type {!Object}
   */
  this.files = {};

  /**
   * The pack used to create the archive request.
   * @type {!o3d.Pack}
   */
  this.pack = pack;

  /**
   * True if this archive has not be destroyed.
   * @type {boolean}
   */
  this.destroyed = false;

  this.request_ = null;

  /**
   * Records each RawData file as it comes in.
   * @private
   * @param {!o3d.RawData} rawData RawData from archive request.
   */
  function addFile(rawData) {
    that.files[rawData.uri] = rawData;
  }

  /**
   * The LoadInfo to track loading progress.
   * @type {!o3djs.io.LoadInfo}
   */
  this.loadInfo = o3djs.io.loadArchiveAdvanced(
      pack,
      url,
      addFile,
      function(request, exception) {
        that.request_ = request;
        onFinished(that, exception);
      });
};

/**
 * Releases all the RAW data associated with this archive. It does not release
 * any objects created from that RAW data.
 */
o3djs.io.ArchiveInfo.prototype.destroy = function() {
  if (!this.destroyed) {
    this.pack.removeObject(this.request_);
    this.destroyed = true;
    this.files = {};
  }
};

/**
 * Gets files by regular expression or wildcards from the archive.
 * @param {(string|!RegExp)} uri of file to get. Can have wildcards '*' and '?'.
 * @param {boolean} opt_caseInsensitive Only valid if it's a wildcard string.
 * @return {!Array.<!o3d.RawData>} An array of the matching RawDatas for
 *      the files matching or undefined if it doesn't exist.
 */
o3djs.io.ArchiveInfo.prototype.getFiles = function(uri,
                                                   opt_caseInsensitive) {
  if (!(uri instanceof RegExp)) {
    uri = uri.replace(/(\W)/g, '\\$&');
    uri = uri.replace(/\\\*/g, '.*');
    uri = uri.replace(/\\\?/g, '.');
    uri = new RegExp(uri, opt_caseInsensitive ? 'i' : '');
  }
  var files = [];
  for (var key in this.files) {
    if (uri.test(key)) {
      files.push(this.files[key]);
    }
  }

  return files;
};

/**
 * Gets a file by URI from the archive.
 * @param {string} uri of file to get.
 * @param {boolean} opt_caseInsensitive True to be case insensitive. Default
 *      false.
 * @return {(o3d.RawData|undefined)} The RawData for the file or undefined if
 *      it doesn't exist.
 */
o3djs.io.ArchiveInfo.prototype.getFileByURI = function(
    uri,
    opt_caseInsensitive) {
  if (opt_caseInsensitive) {
    uri = uri.toLowerCase();
    for (var key in this.files) {
      if (key.toLowerCase() == uri) {
        return this.files[key];
      }
    }
    return undefined;
  } else {
    return this.files[uri];
  }
};

/**
 * Loads an archive file.
 * When the entire archive is ready the onFinished callback will be called
 * with an ArchiveInfo for accessing the archive.
 *
 * @param {!o3d.Pack} pack Pack to create request in.
 * @param {string} url The url of the archive file.
 * @param {!function(!o3djs.io.ArchiveInfo, *): void} onFinished A
 *     callback that is called when the archive is successfully loaded and an
 *     Exception object which is null on success.
 * @return {!o3djs.io.LoadInfo} The a LoadInfo for tracking progress.
 * @see o3djs.io.ArchiveInfo
 */
o3djs.io.loadArchive = function(pack,
                                url,
                                onFinished) {
  var archiveInfo = new o3djs.io.ArchiveInfo(pack, url, onFinished);
  return archiveInfo.loadInfo;
};

/**
 * Loads an archive file. This function is asynchronous. This is a low level
 * version of o3djs.io.loadArchive which can be used for things like
 * progressive loading.
 *
 * @param {!o3d.Pack} pack Pack to create request in.
 * @param {string} url The url of the archive file.
 * @param {!function(!o3d.RawData): void} onFileAvailable A callback, taking a
 *     single argument 'data'. As each file is loaded from the archive, this
 *     function is called with the file's data.
 * @param {!function(!o3d.ArchiveRequest, *): void} onFinished
 *     A callback that is called when the archive is successfully loaded. It is
 *     passed the ArchiveRquest and null on success or a javascript exception on
 *     failure.
 * @return {!o3djs.io.LoadInfo} A LoadInfo for tracking progress.
 */
o3djs.io.loadArchiveAdvanced = function(pack,
                                        url,
                                        onFileAvailable,
                                        onFinished) {
  var error = 'loadArchive failed to load url "' + url + '"';
  var request = pack.createArchiveRequest();
  var loadInfo = o3djs.io.createLoadInfo(request, true);
  request.open('GET', url);
  request.onfileavailable = onFileAvailable;
  /**
   * @ignore
   */
  request.onreadystatechange = function() {
    if (request.done) {
      loadInfo.finish();
      var success = request.success;
      var exception = null;
      if (!success) {
        exception = request.error;
        if (!exception) {
          exception = 'unknown error loading archive';
        }
      }
      onFinished(request, exception);
    }
  };
  request.send();
  return loadInfo;
};

/**
 * Loads RawData.
 *
 * RawData is loaded asynchronously.
 *
 * @param {!o3d.Pack} pack Pack to create the request in.
 * @param {string} url URL of raw data to load.
 * @param {!function(!o3d.FileRequest, o3d.RawData, *): void} callback Callback
 *     when RawData is loaded. It will be passed the FileRequest, a RawData and
 *     an exception on error or null on success. The RawData is associated with
 *     the request so it will stay in memory until you free with request with
 *     pack.removeObject(request).
 * @return {!o3djs.io.LoadInfo} A LoadInfo to track progress.
 * @see o3djs.io.loadTexture
 * @see o3djs.io.loadBitmaps
 * @see o3djs.loader.createLoader
 */
o3djs.io.loadRawData = function(pack, url, callback) {
  var request = pack.createFileRequest('RAWDATA');
  var loadInfo = o3djs.io.createLoadInfo(
      /** @type {!o3d.FileRequest} */ (request),
      false);
  request.open('GET', url, true);
  /**
   * @ignore
   */
  request.onreadystatechange = function() {
    if (request.done) {
      var data = request.data;
      var success = request.success;
      var exception = request.error;
      loadInfo.finish();
      if (!success && !exception) {
          exception = 'unknown error loading RawData: ' + url;
      }
      callback(request, data, success ? null : exception);
    }
  };
  request.send();
  return loadInfo;
};

/**
 * Loads bitmaps.
 *
 * Bitmaps are loaded asynchronously.
 *
 * Example:
 * <pre>
 * var loadInfo = o3djs.io.loadBitamps(pack,
 *                                     'http://google.com/someimage.jpg',
 *                                     callback);
 *
 * function callback(bitmaps, exception) {
 *   if (!exception) {
 *     o3djs.texture.createTextureFromBitmaps(g_pack, bitmaps, true);
 *   } else {
 *     alert(exception);
 *   }
 * }
 * </pre>
 *
 *
 * @param {!o3d.Pack} pack Pack to load texture into.
 * @param {string} url URL of image to load.
 * @param {!function(!Array.<!o3d.Bitmap>, *): void} callback Callback when
 *     image is loaded. It will be passed an array of bitmaps and an exception
 *     on error or null on success.
 * @param {boolean} opt_generateMips Generate Mips. Default = true.
 * @return {!o3djs.io.LoadInfo} A LoadInfo to track progress.
 * @see o3djs.io.loadTexture
 * @see o3djs.loader.createLoader
 */
o3djs.io.loadBitmaps = function(pack, url, callback, opt_generateMips) {
  if (typeof opt_generateMips === 'undefined') {
    opt_generateMips = true;
  }
  return o3djs.io.loadRawData(pack, url, function(request, rawData, exception) {
    var bitmaps = [];
    if (!exception) {
      bitmaps = pack.createBitmapsFromRawData(rawData);
      pack.removeObject(request);
    }
    callback(bitmaps, exception);
  });
};

/**
 * Loads a texture.
 *
 * Textures are loaded asynchronously.
 *
 * Example:
 * <pre>
 * var loadInfo = o3djs.io.loadTexture(pack,
 *                                     'http://google.com/someimage.jpg',
 *                                     callback);
 *
 * function callback(texture, exception) {
 *   if (!exception) {
 *     g_mySampler.texture = texture;
 *   } else {
 *     alert(exception);
 *   }
 * }
 * </pre>
 *
 *
 * @param {!o3d.Pack} pack Pack to load texture into.
 * @param {string} url URL of texture to load.
 * @param {!function(o3d.Texture, *): void} callback Callback when
 *     texture is loaded. It will be passed the texture and an exception on
 *     error or null on success.
 * @param {boolean} opt_generateMips Generate Mips. Default = true.
 * @param {boolean} opt_flip Flip texture. Default = true.
 * @return {!o3djs.io.LoadInfo} A LoadInfo to track progress.
 * @see o3djs.io.loadBitmaps
 * @see o3djs.loader.createLoader
 */
o3djs.io.loadTexture = function(
    pack, url, callback, opt_generateMips, opt_flip) {
  function onLoaded(request, rawData, exception) {
    var texture = null;
    if (!exception) {
      texture = o3djs.texture.createTextureFromRawData(
          pack, rawData, opt_generateMips, opt_flip);
      pack.removeObject(request);
    }
    callback(texture, exception);
  };

  return o3djs.io.loadRawData(pack, url, onLoaded);
};


