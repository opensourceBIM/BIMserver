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
 * @fileoverview This file contains various functions and classes for dealing
 * with 3d scenes.
 */

o3djs.provide('o3djs.scene');

o3djs.require('o3djs.io');
o3djs.require('o3djs.serialization');

/**
 * A Module with various scene functions and classes.
 * @namespace
 */
o3djs.scene = o3djs.scene || {};

/**
 * Loads a scene.
 * @param {!o3d.Client} client An O3D client object.
 * @param {!o3d.Pack} pack Pack to load scene into.
 * @param {!o3d.Transform} parent Transform to parent scene under.
 * @param {string} url URL of scene to load.
 * @param {!function(!o3d.Pack, !o3d.Transform, *): void} callback
 *     Callback when scene is loaded. It will be passed the pack, the parent and
 *     an exception which is null on success.
 * @param {!o3djs.serialization.Options} opt_options Options passed into the
 *     loader.
 * @return {!o3djs.io.LoadInfo} A LoadInfo for tracking progress.
 * @see o3djs.loader.createLoader
 */
o3djs.scene.loadScene = function(client,
                                 pack,
                                 parent,
                                 url,
                                 callback,
                                 opt_options) {
  // Starts the deserializer once the entire archive is available.
  function onFinished(archiveInfo, exception) {
    if (!exception) {
      var finishCallback = function(pack, parent, exception) {
        archiveInfo.destroy();
        callback(pack, parent, exception);
      };
      o3djs.serialization.deserializeArchive(archiveInfo,
                                             'scene.json',
                                             client,
                                             pack,
                                             parent,
                                             finishCallback,
                                             opt_options);
    } else {
      archiveInfo.destroy();
      callback(pack, parent, exception);
    }
  }
  return o3djs.io.loadArchive(pack, url, onFinished);
};


