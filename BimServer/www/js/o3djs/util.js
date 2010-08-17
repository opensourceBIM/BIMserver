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
 * @fileoverview This file contains various utility functions for o3d.  It
 * puts them in the "util" module on the o3djs object.
 *
 */

o3djs.provide('o3djs.util');

o3djs.require('o3djs.io');
o3djs.require('o3djs.event');
o3djs.require('o3djs.error');

/**
 * A Module with various utilities.
 * @namespace
 */
o3djs.util = o3djs.util || {};

/**
 * The name of the o3d plugin. Used to find the plugin when checking
 * for its version.
 * @type {string}
 */
o3djs.util.PLUGIN_NAME = 'O3D Plugin';

/**
 * The version of the plugin needed to use this version of the javascript
 * utility libraries.
 * @type {string}
 */
o3djs.util.REQUIRED_VERSION = '0.1.42.0';

/**
 * The width an O3D must be to put a failure message inside
 * @type {number}
 */
o3djs.util.MINIMUM_WIDTH_FOR_MESSAGE = 200;

/**
 * The height an O3D must be to put a failure message inside
 * @type {number}
 */
o3djs.util.MINIMUM_HEIGHT_FOR_MESSAGE = 200;

/**
 * A URL at which to download the client.
 * @type {string}
 */
o3djs.util.PLUGIN_DOWNLOAD_URL = 'http://tools.google.com/dlpage/o3d';

/**
 * The Renderer InitStatus constants so we don't need an o3d object to look
 * them up.
 * @enum {number}
 */
o3djs.util.rendererInitStatus = {
  NO_PLUGIN: -1,
  UNINITIALIZED: 0,
  SUCCESS: 1,
  OUT_OF_RESOURCES: 2,
  GPU_NOT_UP_TO_SPEC: 3,
  INITIALIZATION_ERROR: 4
};

/**
 * This implements a JavaScript version of currying. Currying allows you to
 * take a function and fix its initial arguments, resulting in a function
 * expecting only the remaining arguments when it is invoked. For example:
 * <pre>
 * function add(a, b) {
 *   return a + b;
 * }
 * var increment = o3djs.util.curry(add, 1);
 * var result = increment(10);
 * </pre>
 * Now result equals 11.
 * @param {!function(...): *} func The function to curry.
 * @return {!function(...): *} The curried function.
 */
o3djs.util.curry = function(func) {
  var outerArgs = [];
  for (var i = 1; i < arguments.length; ++i) {
    outerArgs.push(arguments[i]);
  }
  return function() {
    var innerArgs = outerArgs.slice();
    for (var i = 0; i < arguments.length; ++i) {
      innerArgs.push(arguments[i]);
    }
    return func.apply(this, innerArgs);
  }
}

/**
 * Gets the URI in which the current page is located, omitting the file name.
 * @return {string} The base URI of the page. If the page is
 *     "http://some.com/folder/somepage.html" returns
 *     "http://some.com/folder/".
 */
o3djs.util.getCurrentURI = function() {
  var path = window.location.href;
  var index = path.lastIndexOf('/');
  return path.substring(0, index + 1);
};

/**
 * Given a URI that is relative to the current page, returns the absolute
 * URI.
 * @param {string} uri URI relative to the current page.
 * @return {string} Absolute uri. If the page is
 *     "http://some.com/folder/sompage.html" and you pass in
 *     "images/someimage.jpg" will return
 *     "http://some.com/folder/images/someimage.jpg".
 */
o3djs.util.getAbsoluteURI = function(uri) {
  return o3djs.util.getCurrentURI() + uri;
};

/**
 * Searches an array for a specific value.
 * @param {!Array.<*>} array Array to search.
 * @param {*} value Value to search for.
 * @return {boolean} True if value is in array.
 */
o3djs.util.arrayContains = function(array, value) {
  for (var i = 0; i < array.length; i++) {
    if (array[i] == value) {
      return true;
    }
  }
  return false;
};

/**
 * Searches for all transforms with a "o3d.tags" ParamString
 * that contains specific tag keywords assuming comma separated
 * words.
 * @param {!o3d.Transform} treeRoot Root of tree to search for tags.
 * @param {string} searchTags Tags to look for. eg "camera", "ogre,dragon".
 * @return {!Array.<!o3d.Transform>} Array of transforms.
 */
o3djs.util.getTransformsInTreeByTags = function(treeRoot, searchTags) {
  var splitTags = searchTags.split(',');
  var transforms = treeRoot.getTransformsInTree();
  var found = [];
  for (var n = 0; n < transforms.length; n++) {
    var tagParam = transforms[n].getParam('collada.tags');
    if (tagParam) {
       var tags = tagParam.value.split(',');
       for (var t = 0; t < tags.length; t++) {
         if (o3djs.util.arrayContains(splitTags, tags[t])) {
           found[found.length] = transforms[n];
           break;
         }
      }
    }
  }
  return found;
};

/**
 * Finds transforms in the tree by prefix.
 * @param {!o3d.Transform} treeRoot Root of tree to search.
 * @param {string} prefix Prefix to look for.
 * @return {!Array.<!o3d.Transform>} Array of transforms matching prefix.
 */
o3djs.util.getTransformsInTreeByPrefix = function(treeRoot, prefix) {
  var found = [];
  var transforms = treeRoot.getTransformsInTree();
  for (var ii = 0; ii < transforms.length; ii++) {
    var transform = transforms[ii];
    if (transform.name.indexOf(prefix) == 0) {
      found[found.length] = transform;
    }
  }
  return found;
};

/**
 * Finds the bounding box of all primitives in the tree, in the local space of
 * the tree root. This will use existing bounding boxes on transforms and
 * elements, but not create new ones.
 * @param {!o3d.Transform} treeRoot Root of tree to search.
 * @return {!o3d.BoundingBox} The boundinding box of the tree.
 */
o3djs.util.getBoundingBoxOfTree = function(treeRoot) {
  // If we already have a bounding box, use that one.
  var box = treeRoot.boundingBox;
  if (box.valid) {
    return box;
  }
  var o3d = o3djs.base.o3d;
  // Otherwise, create it as the union of all the children bounding boxes and
  // all the shape bounding boxes.
  var transforms = treeRoot.children;
  for (var i = 0; i < transforms.length; ++i) {
    var transform = transforms[i];
    var childBox = o3djs.util.getBoundingBoxOfTree(transform);
    if (childBox.valid) {
      // transform by the child local matrix.
      childBox = childBox.mul(transform.localMatrix);
      if (box.valid) {
        box = box.add(childBox);
      } else {
        box = childBox;
      }
    }
  }
  var shapes = treeRoot.shapes;
  for (var i = 0; i < shapes.length; ++i) {
    var elements = shapes[i].elements;
    for (var j = 0; j < elements.length; ++j) {
      var elementBox = elements[j].boundingBox;
      if (!elementBox.valid) {
        elementBox = elements[j].getBoundingBox(0);
      }
      if (box.valid) {
        box = box.add(elementBox);
      } else {
        box = elementBox;
      }
    }
  }
  return box;
};

/**
 * Returns the smallest power of 2 that is larger than or equal to size.
 * @param {number} size Size to get power of 2 for.
 * @return {number} smallest power of 2 that is larger than or equal to size.
 */
o3djs.util.getPowerOfTwoSize = function(size) {
  var powerOfTwo = 1;
  while (size) {
    size = size >> 1;
    powerOfTwo = powerOfTwo << 1;
  }
  return powerOfTwo;
};

/**
 * Gets the version of the installed plugin.
 * @return {?string} version string in 'major.minor.revision.build' format.
 *    If the plugin does not exist returns null.
 */
o3djs.util.getPluginVersion = function() {
  var version = null;
  var description = null;
  if (navigator.plugins != null && navigator.plugins.length > 0) {
    var plugin = navigator.plugins[o3djs.util.PLUGIN_NAME];
    if (plugin) {
      description = plugin.description;
    }
  } else if (o3djs.base.IsMSIE()) {
    try {
      var activeXObject = new ActiveXObject('o3d_host.O3DHostControl');
      description = activeXObject.description;
    } catch (e) {
      // O3D plugin was not found.
    }
  }
  if (description) {
    var re = /.*version:(\d+)\.(\d+)\.(\d+)\.(\d+).*/;
    // Parse the version out of the description.
    var parts = re.exec(description);
    if (parts && parts.length == 5) {
      // make sure the format is #.#.#.#  no whitespace, no trailing comments
      version = '' + parseInt(parts[1], 10) + '.' +
                     parseInt(parts[2], 10) + '.' +
                     parseInt(parts[3], 10) + '.' +
                     parseInt(parts[4], 10);
    }
  }
  return version;
};

/**
 * Checks if the required version of the plugin in available.
 * @param {string} requiredVersion version string in
 *    "major.minor.revision.build" format. You can leave out any non-important
 *    numbers for example "3" = require major version 3, "2.4" = require major
 *    version 2, minor version 4.
 * @return {boolean} True if the required version is available.
 */
o3djs.util.requiredVersionAvailable = function(requiredVersion) {
  var version = o3djs.util.getPluginVersion();
  if (!version) {
    return false;
  }
  var haveParts = version.split('.');
  var requiredParts = requiredVersion.split('.');
  if (requiredParts.length > 4) {
    throw Error('requiredVersion has more than 4 parts!');
  }
  for (var pp = 0; pp < requiredParts.length; ++pp) {
    var have = parseInt(haveParts[pp], 10);
    var required = parseInt(requiredParts[pp], 10);
    if (have < required) {
      return false;
    }
    if (have > required) {
      return true;
    }
  }
  return true;
};

/**
 * Gets all the elements of a certain tag that have a certain id.
 * @param {string} tag The tag to look for. (eg. 'div').
 * @param {string} id The id to look for. This can be a regular expression.
 * @return {!Array.<!Element>} An array of the elements found.
 */
o3djs.util.getElementsByTagAndId = function(tag, id) {
  var elements = [];
  var allElements = document.getElementsByTagName(tag);
  for (var ee = 0; ee < allElements.length; ++ee) {
    var element = allElements[ee];
    if (element.id && element.id.match(id)) {
      elements.push(element);
    }
  }
  return elements;
};

/**
 * Gets all the Elements that contain or would contain O3D plugin objects.
 * @param {string} opt_id The id to look for. This can be a regular
 *     expression. The default is "^o3d".
 * @param {string} opt_tag The type of tag to look for. The default is "div".
 */
o3djs.util.getO3DContainerElements = function(opt_id, opt_tag) {
  var tag = opt_tag || 'div';
  var id = opt_id || '^o3d';
  return o3djs.util.getElementsByTagAndId(tag, id);
}

/**
 * Offers the user the option to download the plugin.
 *
 * Finds all divs with the id "^o3d" and inserts a message and link
 * inside to download the plugin. If no areas exist OR if none of them are
 * large enough for the message then displays an alert.
 *
 * @param {string} opt_id The id to look for. This can be a regular
 *     expression. The default is "^o3d".
 * @param {string} opt_tag The type of tag to look for. The default is "div".
 */
o3djs.util.offerPlugin = function(opt_id, opt_tag) {
  var havePlugin = o3djs.util.requiredVersionAvailable('');
  var elements = o3djs.util.getO3DContainerElements(opt_id, opt_tag);
  var addedMessage = false;
  // TODO: This needs to be localized OR we could insert a html like
  // <script src="http://google.com/o3d_plugin_dl"></script>
  // in which case google could serve the message localized and update the
  // link.
  var subMessage =
    (havePlugin ?
     'This page requires a newer version of the O3D plugin.' :
     'This page requires the O3D plugin to be installed.');
  var message =
      '<div style="background: lightblue; width: 100%; height: 100%; ' +
      'text-align:center;">' +
      '<br/><br/>' + subMessage + '<br/>' +
      '<a href="' + o3djs.util.PLUGIN_DOWNLOAD_URL +
      '">Click here to download.</a>' +
      '</div>'
  for (var ee = 0; ee < elements.length; ++ee) {
    var element = elements[ee];
    if (element.clientWidth >= o3djs.util.MINIMUM_WIDTH_FOR_MESSAGE &&
        element.clientHeight >= o3djs.util.MINIMUM_HEIGHT_FOR_MESSAGE &&
        element.style.display.toLowerCase() != 'none' &&
        element.style.visibility.toLowerCase() != 'hidden') {
      addedMessage = true;
      element.innerHTML = message;
    }
  }
  if (!addedMessage) {
    if (confirm(subMessage + '\n\nClick OK to download.')) {
      window.location = o3djs.util.PLUGIN_DOWNLOAD_URL;
    }
  }
};

/**
 * Tells the user their graphics card is not able to run the plugin or is out
 * of resources etc.
 *
 * Finds all divs with the id "^o3d" and inserts a message. If no areas
 * exist OR if none of them are large enough for the message then displays an
 * alert.
 *
 * @param {!o3d.Renderer.InitStatus} initStatus The initializaion status of
 *     the renderer.
 * @param {string} error An error message. Will be '' if there is no message.
 * @param {string} opt_id The id to look for. This can be a regular
 *     expression. The default is "^o3d".
 * @param {string} opt_tag The type of tag to look for. The default is "div".
 */
o3djs.util.informNoGraphics = function(initStatus, error, opt_id, opt_tag) {
  var elements = o3djs.util.getO3DContainerElements(opt_id, opt_tag);
  var addedMessage = false;
  var subMessage;
  var message;
  var alertMessage = '';
  var alertFunction = function() { };

  var moreInfo = function(error) {
    var html = '';
    if (error.length > 0) {
      html = '' +
          '<br/><br/><div>More Info:<br/>' + error + '</div>';
    }
    return html;
  };

  // TODO: This needs to be localized OR we could insert a html like
  // <script src="http://google.com/o3d_plugin_dl"></script>
  // in which case google could serve the message localized and update the
  // link.
  if (initStatus == o3djs.util.rendererInitStatus.GPU_NOT_UP_TO_SPEC) {
    subMessage =
        'We are terribly sorry but it appears your graphics card is not ' +
        'able to run o3d. We are working on a solution.';
    message =
        '<div style="background: lightgray; width: 100%; height: 100%; ' +
        'text-align: center;">' +
        '<br/><br/>' + subMessage +
        '<br/><br/><a href="' + o3djs.util.PLUGIN_DOWNLOAD_URL +
        '">Click Here to go the O3D website</a>' +
        moreInfo(error) +
        '</div>';
    alertMessage = '\n\nClick OK to go to the o3d website.';
    alertFunction = function() {
          window.location = o3djs.util.PLUGIN_DOWNLOAD_URL;
        };
  } else if (initStatus == o3djs.util.rendererInitStatus.OUT_OF_RESOURCES) {
    subMessage =
        'Your graphics system appears to be out of resources. Try closing ' +
        'some applications and then refreshing this page.';
    message =
        '<div style="background: lightgray; width: 100%; height: 100%; ' +
        'text-align: center;">' +
        '<br/><br/>' + subMessage +
        moreInfo(error) +
        '</div>';
  } else {
    subMessage =
        'A unknown error has prevented O3D from starting. Try downloading ' +
        'new drivers or checking for OS updates.';
    message =
        '<div style="background: lightgray; width: 100%; height: 100%; ' +
        'text-align: center;">' +
        '<br/><br/>' + subMessage +
        moreInfo(error) +
        '</div>';
  }
  for (var ee = 0; ee < elements.length; ++ee) {
    var element = elements[ee];
    if (element.clientWidth >= o3djs.util.MINIMUM_WIDTH_FOR_MESSAGE &&
        element.clientHeight >= o3djs.util.MINIMUM_HEIGHT_FOR_MESSAGE &&
        element.style.display.toLowerCase() != 'none' &&
        element.style.visibility.toLowerCase() != 'hidden') {
      addedMessage = true;
      element.innerHTML = message;
    }
  }
  if (!addedMessage) {
    if (confirm(subMessage + alertMessage)) {
      alertFunction();
    }
  }
};

/**
 * Handles failure to create the plugin.
 *
 * @param {!o3d.Renderer.InitStatus} initStatus The initializaion status of
 *     the renderer.
 * @param {string} error An error message. Will be '' if there is no message.
 * @param {string} opt_id The id to look for. This can be a regular
 *     expression. The default is "^o3d".
 * @param {string} opt_tag The type of tag to look for. The default is "div".
 */
o3djs.util.informPluginFailure = function(initStatus, error, opt_id, opt_tag) {
  if (initStatus == o3djs.util.rendererInitStatus.NO_PLUGIN) {
    o3djs.util.offerPlugin(opt_id, opt_tag);
  } else {
    o3djs.util.informNoGraphics(initStatus, error, opt_id, opt_tag);
  }
};

/**
 * Utility to get the text contents of a DOM element with a particular ID.
 * Currently only supports textarea and script nodes.
 * @param {string} id The Node id.
 * @return {string} The text content.
 */
o3djs.util.getElementContentById = function(id) {
  // DOM manipulation is not currently supported in IE.
  o3djs.BROWSER_ONLY = true;

  var node = document.getElementById(id);
  if (!node) {
    throw 'getElementContentById could not find node with id ' + id;
  }
  switch (node.tagName) {
    case 'TEXTAREA':
      return node.value;
    case 'SCRIPT':
      return node.text;
    default:
      throw 'getElementContentById does not no how to get content from a ' +
          node.tagName + ' element';
  }
};

/**
 * Utility to get an element from the DOM by ID. This must be used from V8
 * in preference to document.getElementById because we do not currently
 * support invoking methods on DOM objects in IE.
 * @param {string} id The Element id.
 * @return {Element} The Element or null if not found.
 */
o3djs.util.getElementById = function(id) {
  o3djs.BROWSER_ONLY = true;
  return document.getElementById(id);
};

/**
 * Identifies a JavaScript engine.
 * @enum {number}
 */
o3djs.util.Engine = {
  /**
   * The JavaScript engine provided by the browser.
   */
  BROWSER: 0,
  /**
   * The V8 JavaScript engine embedded in the plugin.
   */
  V8: 1
};

/**
 * The engine selected as the main engine (the one the makeClients callback
 * will be invoked on).
 * @private
 * @type {o3djs.util.Engine}
 */
o3djs.util.mainEngine_ = o3djs.util.Engine.BROWSER;

/**
 * Select an engine to use as the main engine (the one the makeClients
 * callback will be invoked on). If an embedded engine is requested, one
 * element must be identified with the id 'o3d'. The callback will be invoked
 * in this element.
 * @param {o3djs.util.Engine} engine The engine.
 */
o3djs.util.setMainEngine = function(engine) {
  o3djs.util.mainEngine_ = engine;
};

/**
 * A regex used to cleanup the string representation of a function before
 * it is evaled.
 * @private
 * @type {!RegExp}
 */
o3djs.util.fixFunctionString_ = /^\s*function\s+[^\s]+\s*\(([^)]*)\)/

/**
 * Evaluate a callback function in the V8 engine.
 * @param {!Object} clientElement The plugin containing the V8 engine.
 * @param {!function(...): *} callback A function to call.
 * @param {!Object} thisArg The value to be bound to "this".
 * @param {!Array.<*>} args The arguments to pass to the callback.
 * @return {*} The result of calling the callback.
 */
o3djs.util.callV8 = function(clientElement, callback, thisArg, args) {
  // Sometimes a function will be converted to a string like this:
  //   function foo(a, b) { ... }
  // In this case, convert to this form:
  //   function(a, b) { ... }
  var functionString = callback.toString();
  functionString = functionString.replace(o3djs.util.fixFunctionString_,
                                          'function($1)');

  // Make a V8 function that will invoke the callback.
  var v8Code =
      'function(thisArg, args) {\n' +
      '  var localArgs = [];\n' +
      '  var numArgs = args.length;\n' +
      '  for (var i = 0; i < numArgs; ++i) {\n' +
      '    localArgs.push(args[i]);\n' +
      '  }\n' +
      '  var func = ' + functionString + ';\n' +
      '  return func.apply(thisArg, localArgs);\n' +
      '}\n';

  // Evaluate the function in V8.
  var v8Function = clientElement.eval(v8Code);
  return v8Function(thisArg, args);
};

/**
 * A regex to remove .. from a URI.
 * @private
 * @type {!RegExp}
 */
o3djs.util.stripDotDot_ = /\/[^\/]+\/\.\./;

/**
 * Turn a URI into an absolute URI.
 * @param {string} uri The URI.
 * @return {string} The absolute URI.
 */
o3djs.util.toAbsoluteUri = function(uri) {
  if (uri.indexOf('://') == -1) {
    var baseUri = document.location.toString();
    var lastSlash = baseUri.lastIndexOf('/');
    if (lastSlash != -1) {
      baseUri = baseUri.substring(0, lastSlash);
    }
    uri = baseUri + '/' + uri;
  }

  do {
    var lastUri = uri;
    uri = uri.replace(o3djs.util.stripDotDot_, '');
  } while (lastUri !== uri);

  return uri;
};

/**
 * The script URIs.
 * @private
 * @type {!Array.<string>}
 */
o3djs.util.scriptUris_ = [];

/**
 * Add a script URI. Scripts that are referenced from script tags that are
 * within this URI are automatically loaded into the alternative JavaScript
 * main JavaScript engine. Do not include directories of scripts that are
 * included with o3djs.require. These are always available. This mechanism
 * is not able to load scripts in a different domain from the document.
 * @param {string} uri The URI.
 */
o3djs.util.addScriptUri = function(uri) {
  o3djs.util.scriptUris_.push(o3djs.util.toAbsoluteUri(uri));
};

/**
 * Determine whether a URI is a script URI that should be loaded into the
 * alternative main JavaScript engine.
 * @param {string} uri The URI.
 * @return {boolean} Whether it is a script URI.
 */
o3djs.util.isScriptUri = function(uri) {
  uri = o3djs.util.toAbsoluteUri(uri);
  for (var i = 0; i < o3djs.util.scriptUris_.length; ++i) {
    var scriptUri = o3djs.util.scriptUris_[i];
    if (uri.substring(0, scriptUri.length) === scriptUri) {
      return true;
    }
  }
  return false;
};

/**
 * Returns whether or not this is a script tag we want. Currently that is
 * only script tags with an id that starts with "o3d".
 * @private
 * @param {!Element} scriptElement The script element to check.
 * @return {boolean} True if we want this script tag.
 */
o3djs.util.isWantedScriptTag_ = function(scriptElement) {
  return scriptElement.id && scriptElement.id.match(/^o3dscript/);
};

/**
 * Concatenate the text of all the script tags in the document and invokes
 * the callback when complete. This function is asynchronous if any of the
 * script tags reference JavaScript through a URI.
 * @private
 * @return {string} The script tag text.
 */
o3djs.util.getScriptTagText_ = function() {
  var scriptTagText = '';
  var scriptElements = document.getElementsByTagName('script');
  for (var i = 0; i < scriptElements.length; ++i) {
    var scriptElement = scriptElements[i];
    if (scriptElement.type === '' ||
        scriptElement.type === 'text/javascript') {
      if ('text' in scriptElement && scriptElement.text &&
          o3djs.util.isWantedScriptTag_(scriptElement)) {
        scriptTagText += scriptElement.text;
      }
      if ('src' in scriptElement && scriptElement.src &&
          o3djs.util.isScriptUri(scriptElement.src)) {
        // It would be better to make this an asynchronous load but the script
        // file is very likely to be in the browser cache because it should
        // have just been loaded via the browser script tag.
        scriptTagText += o3djs.io.loadTextFileSynchronous(scriptElement.src);
      }
    }
  }
  return scriptTagText;
};

/**
 * Creates a client element.  In other words it creates an <OBJECT> tag for o3d.
 * <b>Note that the browser may not have initialized the plugin before
 * returning.</b>
 * @param {!Element} element The DOM element under which the client element
 *    will be appended.
 * @param {string} opt_features A comma separated list of the
 *    features you need for your application. The current list of features:
 *    <li>FloatingPointTextures: Includes the formats R32F, ABGR16F and
 *    ABGR32F</li>
 *    The features are case sensitive.
 * @param {string} opt_requestVersion version string in
 *    "major.minor.revision.build" format. You can leave out any non-important
 *    numbers for example "3" = request major version 3, "2.4" = request major
 *    version 2, minor version 4. If no string is passed in the newest version
 *    of the plugin will be created.
 * @return {Element} O3D element or null if requested version is not
 *    available.
 */
o3djs.util.createClient = function(element, opt_features, opt_requestVersion) {
  opt_features = opt_features || '';
  opt_requestVersion = opt_requestVersion || o3djs.util.REQUIRED_VERSION;
  if (!o3djs.util.requiredVersionAvailable(opt_requestVersion)) {
    return null;
  }
  opt_features += (opt_features ? ',' : '') + 'APIVersion=' +
                  opt_requestVersion;
  var objElem;
  // TODO: Use opt_requiredVersion to set a version so the plugin
  //    can make sure it offers that version of the API.
  // Note:  The IE version of the plug-in does not receive attributes during
  //  construction, unless the innerHTML construction style is used.
  if (o3djs.base.IsMSIE()) {
    element.innerHTML =
        '<OBJECT ' +
          'WIDTH="100%" HEIGHT="100%"' +
          'CLASSID="CLSID:9666A772-407E-4F90-BC37-982E8160EB2D">' +
            '<PARAM name="o3d_features" value="' + opt_features + '"/>' +
        '</OBJECT>';
    objElem = element.childNodes[0];
  } else {
    objElem = document.createElement('object');
    objElem.type = 'application/vnd.o3d.auto';
    objElem.style.width = '100%';
    objElem.style.height = '100%';
    objElem.setAttribute('o3d_features', opt_features);
    element.appendChild(objElem);
  }

  return objElem;
};

/**
 * Finds all divs with the an id that starts with "o3d" and inserts a client
 * area inside.
 *
 * NOTE: the size of the client area is always set to 100% which means the div
 * must have its size set or managed by the browser. Examples:
 *
 * -- A div of a specific size --
 * &lt;div id="o3d" style="width:800px; height:600px">&lt;/div>
 *
 * -- A div that fills its containing element --
 * &lt;div id="o3d" style="width:100%; height:100%">&lt;/div>
 *
 * In both cases, a DOCTYPE is probably required.
 *
 * You can also request certain features by adding the attribute
 * 'o3d_features' as in
 *
 * &lt;div id="o3d" o3d_features="FloatingPointTextures">&lt;/div>
 *
 * This allows you to specify different features per area. Otherwise you can
 * request features as an argument to this function.
 *
 * Normally this function handles failure for you but if you want to handle
 * failure in your own way you can supply a failure callback. Here is an example
 * of using this function with your own failure callback.
 *
 * <pre>
 * &lt;script type="text/javascript" id="o3dscript"&gt;
 * o3djs.require('o3djs.util');
 *
 * window.onload = init;
 *
 * function init() {
 *  o3djs.util.makeClients(onSuccess, '', undefined, onFailure);
 * }
 *
 * function onFailure(initStatus, error, id, tag) {
 *   // Get a list of the elements that would have had an O3D plugin object
 *   // inserted if it had succeed.
 *   var elements = o3djs.util.getO3DContainerElements(id, tag);
 *
 *   switch (initStatus) {
 *     case o3djs.util.rendererInitStatus.NO_PLUGIN:
 *       // Tell the user there is no plugin
 *       ...
 *       break;
 *     case o3djs.util.rendererInitStatus.OUT_OF_RESOURCES:
 *     case o3djs.util.rendererInitStatus.GPU_NOT_UP_TO_SPEC:,
 *     case o3djs.util.rendererInitStatus.INITIALIZATION_ERROR:
 *     default:
 *       // Tell the user there are other issues
 *       ...
 *       break;
 *   }
 * }
 *
 * function onSuccess(o3dElementsArray) {
 *   // Run your app.
 *   ...
 * }
 * &lt;/script&gt;
 * </pre>
 *
 * @param {!function(Array.<!Element>): void} callback Function to call when
 *     client objects have been created.
 * @param {string} opt_features A comma separated list of the
 *     features you need for your application. The current list of features:
 *
 *     <li>FloatingPointTextures: Includes the formats R32F, ABGR16F and
 *     ABGR32F</li>
 *     <li>LargeGeometry: Allows buffers to have more than 65534 elements.</li>
 *     <li>NotAntiAliased: Turns off anti-aliasing</li>
 *     <li>InitStatus=X: Where X is a number. Allows simulatation of the plugin
 *     failing</li>
 *
 *     The features are case sensitive.
 * @param {string} opt_requiredVersion version string in
 *     "major.minor.revision.build" format. You can leave out any
 *     non-important numbers for example "3" = require major version 3,
 *     "2.4" = require major version 2, minor version 4. If no string is
 *     passed in the version of the needed by this version of the javascript
 *     libraries will be created.
 * @param {!function(!o3d.Renderer.InitStatus, string, (string|undefined),
 *     (string|undefined)): void} opt_failureCallback Function to call if the
 *     plugin does not exist, if the required version is not installed, or if
 *     for some other reason the plugin can not start. If this function is not
 *     specified or is null the default behavior of leading the user to the
 *     download page will be provided. See o3djs.util.informPluginFailure for an
 *     example of this type of callback.
 * @param {string} opt_id The id to look for. This can be a regular
 *     expression. The default is "^o3d".
 * @param {string} opt_tag The type of tag to look for. The default is "div".
 * @see o3djs.util.informPluginFailure
 */
o3djs.util.makeClients = function(callback,
                                  opt_features,
                                  opt_requiredVersion,
                                  opt_failureCallback,
                                  opt_id,
                                  opt_tag) {
  opt_failureCallback = opt_failureCallback || o3djs.util.informPluginFailure;
  opt_requiredVersion = opt_requiredVersion || o3djs.util.REQUIRED_VERSION;
  if (!o3djs.util.requiredVersionAvailable(opt_requiredVersion)) {
    opt_failureCallback(o3djs.util.rendererInitStatus.NO_PLUGIN, '',
                        opt_id, opt_tag);
  } else {
    var clientElements = [];
    var elements = o3djs.util.getO3DContainerElements(opt_id, opt_tag);
    var mainClientElement = null;
    for (var ee = 0; ee < elements.length; ++ee) {
      var element = elements[ee];
      var features = opt_features;
      if (!features) {
        var o3d_features = element.getAttribute('o3d_features');
        if (o3d_features) {
          features = o3d_features;
        } else {
          features = '';
        }
      }

      var objElem = o3djs.util.createClient(element, features);
      clientElements.push(objElem);

      // If the callback is to be invoked in an embedded JavaScript engine,
      // one element must be identified with the id 'o3d'. This callback
      // will be invoked in the element identified as such.
      if (element.id === 'o3d') {
        mainClientElement = objElem;
      }
    }

    // Chrome 1.0 sometimes doesn't create the plugin instance. To work
    // around this, force a re-layout by changing the plugin size until it
    // is loaded. We toggle between 1 pixel and 100% until the plugin has
    // loaded.
    var chromeWorkaround = o3djs.base.IsChrome10();
    {
      // Wait for the browser to initialize the clients.
      var clearId = window.setInterval(function() {
        var initStatus = 0;
        var error = '';
        var o3d;
        for (var cc = 0; cc < clientElements.length; ++cc) {
          var element = clientElements[cc];
          o3d = element.o3d;
          var ready = o3d &&
              element.client &&
              element.client.rendererInitStatus >
                  o3djs.util.rendererInitStatus.UNINITIALIZED;
          if (!ready) {
            if (chromeWorkaround) {
              if (element.style.width != '100%') {
                element.style.width = '100%';
              } else {
                element.style.width = '1px';
              }
            }
            return;
          }
          if (chromeWorkaround && element.style.width != '100%') {
            // The plugin has loaded but it may not be the right size yet.
            element.style.width = '100%';
            return;
          }
          var status = clientElements[cc].client.rendererInitStatus;
          // keep the highest status. This is the worst status.
          if (status > initStatus) {
            initStatus = status;
            error = clientElements[cc].client.lastError;
          }
        }

        window.clearInterval(clearId);

        // If the plugin could not initialize the graphics delete all of
        // the plugin objects
        if (initStatus > 0 && initStatus != o3d.Renderer.SUCCESS) {
          for (var cc = 0; cc < clientElements.length; ++cc) {
            var clientElement = clientElements[cc];
            clientElement.parentNode.removeChild(clientElement);
          }
          opt_failureCallback(initStatus, error, opt_id, opt_tag);
        } else {
          o3djs.base.snapshotProvidedNamespaces();

          // TODO: Is this needed with the new event code?
          for (var cc = 0; cc < clientElements.length; ++cc) {
            o3djs.base.initV8(clientElements[cc]);
            o3djs.event.startKeyboardEventSynthesis(clientElements[cc]);
            o3djs.error.setDefaultErrorHandler(clientElements[cc].client);
          }
          o3djs.base.init(clientElements[0]);

          switch (o3djs.util.mainEngine_) {
            case o3djs.util.Engine.BROWSER:
              callback(clientElements);
              break;
            case o3djs.util.Engine.V8:
              if (!mainClientElement) {
                throw 'V8 engine was requested but there is no element with' +
                    ' the id "o3d"';
              }

              // Retreive the code from the script tags and eval it in V8 to
              // duplicate the browser environment.
              var scriptTagText = o3djs.util.getScriptTagText_();
              mainClientElement.eval(scriptTagText);

              // Invoke the vallback in V8.
              o3djs.util.callV8(mainClientElement,
                                callback,
                                o3djs.global,
                                [clientElements]);
              break;
            default:
              throw 'Unknown engine ' + o3djs.util.mainEngine_;
          }
        }
      }, 10);
    }
  }
};

