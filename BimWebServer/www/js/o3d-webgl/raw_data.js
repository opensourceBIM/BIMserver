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
 * A RawData object contains raw binary data which could contain
 * image, audio, text, or other information.
 *
 * var request =  g_pack.createArchiveRequest();
 *
 * request.onfileavailable = function(rawData) {
 *   var texture = g_pack.createTextureFromRawData(rawData, true);
 *   ...
 * };
 *
 * request.send();
 * @constructor
 */
o3d.RawData = function() {
  o3d.NamedObject.call(this);
};
o3d.inherit('RawData', 'NamedObject');


/**
 * Returns the raw data as a string. The data must be a valid utf-8 string
 * and the uri must end in .json, .txt, .xml, .ini or .csv
 * @type {string}
 */
o3d.RawData.prototype.stringValue = '';


/**
 * The data as an image if it is an image.
 * @type {Image}
 * @private
 */
o3d.RawData.prototype.image_ = null;


/**
 * The uri of the RawData.
 * @type {string}
 */
o3d.RawData.prototype.uri = '';



/**
 * The length in bytes of the RawData.
 * @type {number}
 */
o3d.RawData.prototype.length = 0;



/**
 * Discards all the resources associated with this data object.
 */
o3d.RawData.prototype.discard = function() {
  o3d.notImplemented();
};



/**
 * Flushes the memory resources associated with this data object,
 * but keeps a cache in case the data object is used later.
 */
o3d.RawData.prototype.flush = function() {
  o3d.notImplemented();
};



