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

// TODO(kbr): figure out how we can reuse the o3djs.io package from
// within here.
// o3djs.require('o3djs.io');

// TODO(kbr): factor this out into e.g. o3djs.json and require
// o3djs.json here.
if(!this.JSON){this.JSON={};}
(function(){function f(n){return n<10?'0'+n:n;}
if(typeof Date.prototype.toJSON!=='function'){Date.prototype.toJSON=function(key){return isFinite(this.valueOf())?this.getUTCFullYear()+'-'+
f(this.getUTCMonth()+1)+'-'+
f(this.getUTCDate())+'T'+
f(this.getUTCHours())+':'+
f(this.getUTCMinutes())+':'+
f(this.getUTCSeconds())+'Z':null;};String.prototype.toJSON=Number.prototype.toJSON=Boolean.prototype.toJSON=function(key){return this.valueOf();};}
var cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,escapable=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,gap,indent,meta={'\b':'\\b','\t':'\\t','\n':'\\n','\f':'\\f','\r':'\\r','"':'\\"','\\':'\\\\'},rep;function quote(string){escapable.lastIndex=0;return escapable.test(string)?'"'+string.replace(escapable,function(a){var c=meta[a];return typeof c==='string'?c:'\\u'+('0000'+a.charCodeAt(0).toString(16)).slice(-4);})+'"':'"'+string+'"';}
function str(key,holder){var i,k,v,length,mind=gap,partial,value=holder[key];if(value&&typeof value==='object'&&typeof value.toJSON==='function'){value=value.toJSON(key);}
if(typeof rep==='function'){value=rep.call(holder,key,value);}
switch(typeof value){case'string':return quote(value);case'number':return isFinite(value)?String(value):'null';case'boolean':case'null':return String(value);case'object':if(!value){return'null';}
gap+=indent;partial=[];if(Object.prototype.toString.apply(value)==='[object Array]'){length=value.length;for(i=0;i<length;i+=1){partial[i]=str(i,value)||'null';}
v=partial.length===0?'[]':gap?'[\n'+gap+
partial.join(',\n'+gap)+'\n'+
mind+']':'['+partial.join(',')+']';gap=mind;return v;}
if(rep&&typeof rep==='object'){length=rep.length;for(i=0;i<length;i+=1){k=rep[i];if(typeof k==='string'){v=str(k,value);if(v){partial.push(quote(k)+(gap?': ':':')+v);}}}}else{for(k in value){if(Object.hasOwnProperty.call(value,k)){v=str(k,value);if(v){partial.push(quote(k)+(gap?': ':':')+v);}}}}
v=partial.length===0?'{}':gap?'{\n'+gap+partial.join(',\n'+gap)+'\n'+
mind+'}':'{'+partial.join(',')+'}';gap=mind;return v;}}
if(typeof JSON.stringify!=='function'){JSON.stringify=function(value,replacer,space){var i;gap='';indent='';if(typeof space==='number'){for(i=0;i<space;i+=1){indent+=' ';}}else if(typeof space==='string'){indent=space;}
rep=replacer;if(replacer&&typeof replacer!=='function'&&(typeof replacer!=='object'||typeof replacer.length!=='number')){throw new Error('JSON.stringify');}
return str('',{'':value});};}
if(typeof JSON.parse!=='function'){JSON.parse=function(text,reviver){var j;function walk(holder,key){var k,v,value=holder[key];if(value&&typeof value==='object'){for(k in value){if(Object.hasOwnProperty.call(value,k)){v=walk(value,k);if(v!==undefined){value[k]=v;}else{delete value[k];}}}}
return reviver.call(holder,key,value);}
text=String(text);cx.lastIndex=0;if(cx.test(text)){text=text.replace(cx,function(a){return'\\u'+
('0000'+a.charCodeAt(0).toString(16)).slice(-4);});}
if(/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,'@').replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,']').replace(/(?:^|:|,)(?:\s*\[)+/g,''))){j=eval('('+text+')');return typeof reviver==='function'?walk({'':j},''):j;}
throw new SyntaxError('JSON.parse');};}}());


/**
  An ArchiveRequest object is used to carry out an asynchronous request for a
  compressed archive (containing multiple files).

  Note: The archive must have as its first file a file named 'aaaaaaaa.o3d'
  who's contents is 'o3d'. This is to prevent O3D being used to open
  archive files that were not meant for it.

  \code
  var request = pack.createArchiveRequest();
  request.open("GET", url);

  request.onfileavailable = myFileAvailableCallback;
  request.onreadystatechange = myReadyStateChangeCallback;
  request.send();

  function myFileAvailableCallback(rawData) {
    dump("uri: " + rawData.uri + "\n");
    dump("content: " + rawData.stringValue + "\n");

    // You can pass a RawData to various creation functions. Note: rawData
    // is only valid until you remove the request.
    // Examples:
    if (rawData.uri == 'mytexture.jpg')
      pack.createTexture2d(rawData, makeMips);
    if (rawData.uri == 'myvertices.bin')
      vertexBuffer.set(rawData);
    if (rawData.uri == 'myAudio.mp3')
      audioSystem.createSound(rawData);
  }

  function myReadyStateChangeCallback() {
    if (request.done) {
      if (request.success) {
        // there were no errors trying to read the archive
      } else {
        dump(request.error);
      }
    }
  }

  // When you are done with the RawDatas loaded by the request, remove
  // the request from the pack to free them.
  pack.removeObject(request);
*/

o3d.ArchiveRequest = function() {
  o3d.ObjectBase.call(this);
  this.method_ = null;
};
o3d.inherit('ArchiveRequest', 'ObjectBase');

/**
 * The URI this request is for.
 * @type {string}
 */
o3d.ArchiveRequest.prototype.uri = '';

/**
 * Set up several of the request fields.
 * @param {string} method "GET" is the only supported method at this time
 * @param {string} uri the location of the file to fetch
 * @param {boolean} async true is the only legal value at this time.
 */
o3d.ArchiveRequest.prototype.open =
    function(method, uri) {
  this.uri = uri;

  // Compute the parent directory of this URI.
  var parentURI = uri;
  var lastSlash = uri.lastIndexOf('/');
  if (lastSlash != -1) {
    parentURI = parentURI.substring(0, lastSlash + 1);
  }

  this.parentURI_ = parentURI;
};

/**
 * Sends the request.  In this implementation, this function sets up a callback
 * which searches the json it loads for more files to load.  It then sends
 * requests for each of those files.  When the last of those files has loaded,
 * the onreadystatechange callback will get called.  Unlike XMLHttpRequest the
 * onreadystatechange callback will be called no matter what, with success or
 * failure.
 */
o3d.ArchiveRequest.prototype.send = function() {
  var that = this;
  this.done = false;
  this.success = true;
  this.error = null;
  var callback = function(sourceJSON, exc) {
    // Don't send down the original scene.json because 'eval' is used
    // elsewhere to reconstitute it, which is risky.
    var filteredJSON = JSON.stringify(JSON.parse(sourceJSON));

    var rawData = new o3d.RawData();
    rawData.uri = 'scene.json';
    rawData.stringValue = filteredJSON;

    // In o3d-webgl, the "archive" is really just the top-level
    // scene.json. We run a regexp on it to find URIs for certain
    // well-known file types (.fx, .png, .jpg) and issue file requests
    // for them.
    var uriRegex = /\"([^\"]*\.(fx|png|jpg))\"/g;
    var matchArray;
    var uris = [];
    while ((matchArray = uriRegex.exec(sourceJSON)) != null) {
      uris.push(matchArray[1]);
    }

    // Plus one for the current request.
    that.pendingRequests_ = uris.length + 1;

    // Issue requests for each of these URIs.
    for (var ii = 0; ii < uris.length; ++ii) {
      if (that.stringEndsWith_(uris[ii], ".fx")) {
        var func = function(uri) {
          var completion = function(value, exc) {
            var rawData = null;
            if (exc == null) {
              rawData = new o3d.RawData();
              rawData.uri = uri;
              rawData.stringValue = value;
            }
            that.resolvePendingRequest_(rawData, exc);
          };
          o3djs.io.loadTextFile(that.relativeToAbsoluteURI_(uri),
                                completion);
        };
        func(uris[ii]);
      } else if (that.stringEndsWith_(uris[ii], ".png") ||
                 that.stringEndsWith_(uris[ii], ".jpg")) {
        var func = function(uri) {
          var image = new Image();
          image.onload = function() {
            var rawData = new o3d.RawData();
            rawData.uri = uri;
            rawData.image_ = image;
            that.resolvePendingRequest_(rawData, exc);
          };
          image.onerror = function() {
            that.resolvePendingRequest_(null, exc);
          }
          image.src = that.relativeToAbsoluteURI_(uri);
        };
        func(uris[ii]);
      }
    }

    that.resolvePendingRequest_(rawData);
  };

  o3djs.io.loadTextFile(this.uri, callback);
};

/**
 * A callback to call whenever the ready state of the request changes.
 * @type {function(): void}
 */
o3d.ArchiveRequest.prototype.onreadystatechange = null;

/**
 * A callback to call when each file comes in.
 * @type {function(!o3d.RawData): void}
 */
o3d.ArchiveRequest.prototype.onfileavailable = null;

/**
 * Converts a local URI to an absolute URI.
 * @private
 */
o3d.ArchiveRequest.prototype.relativeToAbsoluteURI_ = function(relativeURI) {
  return this.parentURI_ + relativeURI;
};

/**
 * Indicates whether one string ends with another.
 * @private
 */
o3d.ArchiveRequest.prototype.stringEndsWith_ = function(string, suffix) {
  return string.substring(string.length - suffix.length) == suffix;
};

/**
 * Decrements the number of pending requests.  Calls onfileavailable callback
 * if one is provided, calls onreadystatechange if this is the last of the
 * requests.
 * @param {o3d.RawData} rawData The current raw data object.
 * @param {Object} opt_exc An optional exception.
 * @private
 */
o3d.ArchiveRequest.prototype.resolvePendingRequest_ =
    function(rawData, opt_exc) {
  this.success = this.success && rawData && (!opt_exc);
  if (opt_exc != null) {
    this.error = "" + opt_exc;
  }
  if (rawData && this.onfileavailable) {
    this.onfileavailable(rawData);
  }
  if (--this.pendingRequests_ == 0) {
    this.done = true;
    if (this.onreadystatechange) {
      this.onreadystatechange();
    }
  }
};
