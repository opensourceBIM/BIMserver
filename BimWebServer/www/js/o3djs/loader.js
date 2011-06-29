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
 * @fileoverview This file contains a loader class for helping to load
 *     muliple assets in an asynchronous manner.
 */

o3djs.provide('o3djs.loader');

o3djs.require('o3djs.io');
o3djs.require('o3djs.scene');

/**
 * A Module with a loader class for helping to load muliple assets in an
 * asynchronous manner.
 * @namespace
 */
o3djs.loader = o3djs.loader || {};

/**
 * A simple Loader class to call some callback when everything has loaded.
 * @constructor
 * @param {!function(): void} onFinished Function to call when final item has
 *        loaded.
 */
o3djs.loader.Loader = function(onFinished)  {
  this.count_ = 1;
  this.onFinished_ = onFinished;

  /**
   * The LoadInfo for this loader you can use to track progress.
   * @type {!o3djs.io.LoadInfo}
   */
  this.loadInfo = o3djs.io.createLoadInfo();
};

/**
 * Creates a Loader for helping to load a bunch of items asychronously.
 *
 * The way you use this is as follows.
 *
 * <pre>
 * var loader = o3djs.loader.createLoader(myFinishedCallback);
 * loader.loadTexture(pack, texture1Url, callbackForTexture);
 * loader.loadTexture(pack, texture2Url, callbackForTexture);
 * loader.loadTexture(pack, texture3Url, callbackForTexture);
 * loader.finish();
 * </pre>
 *
 * The loader guarantees that myFinishedCallback will be called after
 * all the items have been loaded.
 *
* @param {!function(): void} onFinished Function to call when final item has
*        loaded.
* @return {!o3djs.loader.Loader} A Loader Object.
 */
o3djs.loader.createLoader = function(onFinished) {
  return new o3djs.loader.Loader(onFinished);
};

/**
 * Loads a texture.
 * @param {!o3d.Pack} pack Pack to load texture into.
 * @param {string} url URL of texture to load.
 * @param {!function(o3d.Texture, *): void} opt_onTextureLoaded
 *     optional callback when texture is loaded. It will be passed the texture
 *     and an exception which is null on success.
 */
o3djs.loader.Loader.prototype.loadTexture = function(pack,
                                                     url,
                                                     opt_onTextureLoaded) {
  var that = this;  // so the function below can see "this".
  ++this.count_;
  var loadInfo = o3djs.io.loadTexture(pack, url, function(texture, exception) {
    if (opt_onTextureLoaded) {
      opt_onTextureLoaded(texture, exception);
    }
    that.countDown_();
  });
  this.loadInfo.addChild(loadInfo);
};

/**
 * Loads a RawData.
 * @param {!o3d.Pack} pack Pack to load texture into.
 * @param {string} url URL of image file to load.
 * @param {!function(!o3d.FileRequest, o3d.RawData, *): void} onLoaded Callback
 *     when RawData is loaded. It will be passed the request, a RawData and an
 *     exception which is null on success. The RawData is associated with
 *     the request so it will stay in memory until you free with request with
 *     pack.removeObject(request).
 */
o3djs.loader.Loader.prototype.loadRawData = function(pack,
                                                     url,
                                                     onLoaded) {
  var that = this;  // so the function below can see "this".
  ++this.count_;
  var loadInfo = o3djs.io.loadRawData(
      pack, url, function(request, rawData, exception) {
    onLoaded(request, rawData, exception);
    that.countDown_();
  });
  this.loadInfo.addChild(loadInfo);
};

/**
 * Loads bitmaps.
 * @param {!o3d.Pack} pack Pack to load texture into.
 * @param {string} url URL of image file to load.
 * @param {!function(!Array.<!o3d.Bitmap>, *): void} onBitmapsLoaded Callback
 *     when bitmaps are loaded. It will be passed an array of bitmaps and an
 *     exception which is null on success.
 */
o3djs.loader.Loader.prototype.loadBitmaps = function(pack,
                                                     url,
                                                     onBitmapsLoaded) {
  var that = this;  // so the function below can see "this".
  ++this.count_;
  var loadInfo = o3djs.io.loadBitmaps(pack, url, function(bitmaps, exception) {
    onBitmapsLoaded(bitmaps, exception);
    that.countDown_();
  });
  this.loadInfo.addChild(loadInfo);
};

/**
 * Loads a 3d scene.
 * @param {!o3d.Client} client An O3D client object.
 * @param {!o3d.Pack} pack Pack to load texture into.
 * @param {!o3d.Transform} parent Transform to parent scene under.
 * @param {string} url URL of scene to load.
 * @param {!o3djs.serialization.Options} opt_options Options passed into the
 *     loader.
 * @param {!function(!o3d.Pack, !o3d.Transform, *): void}
 *     opt_onSceneLoaded optional callback when scene is loaded. It will be
 *     passed the pack and parent and an exception which is null on success.
 */
o3djs.loader.Loader.prototype.loadScene = function(client,
                                                   pack,
                                                   parent,
                                                   url,
                                                   opt_onSceneLoaded,
                                                   opt_options) {
  var that = this;  // so the function below can see "this".
  ++this.count_;
  var loadInfo = o3djs.scene.loadScene(
      client, pack, parent, url, function(pack, parent, exception) {
        if (opt_onSceneLoaded) {
          opt_onSceneLoaded(pack, parent, exception);
        }
        that.countDown_();
      },
      opt_options);
  this.loadInfo.addChild(loadInfo);
};

/**
 * Loads a text file.
 * @param {string} url URL of scene to load.
 * @param {!function(string, *): void} onTextLoaded Function to call when
 *     the file is loaded. It will be passed the contents of the file as a
 *     string and an exception which is null on success.
 */
o3djs.loader.Loader.prototype.loadTextFile = function(url, onTextLoaded) {
  var that = this;  // so the function below can see "this".
  ++this.count_;
  var loadInfo = o3djs.io.loadTextFile(url, function(string, exception) {
    onTextLoaded(string, exception);
    that.countDown_();
  });
  this.loadInfo.addChild(loadInfo);
};

/**
 * Creates a loader that is tracked by this loader so that when the new loader
 * is finished it will be reported to this loader.
 * @param {!function(): void} onFinished Function to be called when everything
 *      loaded with this loader has finished.
 * @return {!o3djs.loader.Loader} The new Loader.
 */
o3djs.loader.Loader.prototype.createLoader = function(onFinished) {
  var that = this;
  ++this.count_;
  var loader = o3djs.loader.createLoader(function() {
      onFinished();
      that.countDown_();
  });
  this.loadInfo.addChild(loader.loadInfo);
  return loader;
};

/**
 * Counts down the internal count and if it gets to zero calls the callback.
 * @private
 */
o3djs.loader.Loader.prototype.countDown_ = function() {
  --this.count_;
  if (this.count_ === 0) {
    this.onFinished_();
  }
};

/**
 * Finishes the loading process.
 * Actually this just calls countDown_ to account for the count starting at 1.
 */
o3djs.loader.Loader.prototype.finish = function() {
  this.countDown_();
};


