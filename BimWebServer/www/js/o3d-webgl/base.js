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
 * @fileoverview Base for all o3d classes implemented in javscript.
 *    Include just this file in a script tag and it will include all other
 *    source files needed by o3d.
 *    For more information about o3d see
 *    http://code.google.com/p/o3d.
 */

/**
 * A namespace for all the o3d classes.
 * @namespace
 */
var o3d = o3d || {};

/**
 * Define this because the Google internal JSCompiler needs goog.typedef below.
 */
var goog = goog || {};

/**
 * A macro for defining composite types.
 *
 * By assigning goog.typedef to a name, this tells Google internal JSCompiler
 * that this is not the name of a class, but rather it's the name of a composite
 * type.
 *
 * For example,
 * /** @type {Array|NodeList} / goog.ArrayLike = goog.typedef;
 * will tell JSCompiler to replace all appearances of goog.ArrayLike in type
 * definitions with the union of Array and NodeList.
 *
 * Does nothing in uncompiled code.
 */
goog.typedef = true;

/**
 * Reference to the global context.  In most cases this will be 'window'.
 */
o3d.global = this;

/**
 * Path for included scripts.
 * @type {string}
 */
o3d.basePath = '';

/**
 * Some javascripts don't support __defineGetter__ or __defineSetter__
 * so we define some here so at least we don't get compile errors.
 * We expect the initialzation code will check and complain. This stubs
 * are just here to make sure we can actually get to the initialization code.
 */
if (!Object.prototype.__defineSetter__) {
  Object.prototype.__defineSetter__ = function() {}
  Object.prototype.__defineGetter__ = function() {}
}

/**
 * Tries to detect the base path of the base.js script that
 * bootstraps the o3d libraries.
 * @private
 */
o3d.findBasePath_ = function() {
  var doc = o3d.global.document;
  if (typeof doc == 'undefined') {
    return;
  }
  if (o3d.global.BASE_PATH) {
    o3d.basePath = o3d.global.BASE_PATH;
    return;
  } else {
    // HACK to hide compiler warnings :(
    o3d.global.BASE_PATH = null;
  }
  var scripts = doc.getElementsByTagName('script');
  for (var script, i = 0; script = scripts[i]; i++) {
    var src = script.src;
    var l = src.length;
    var s = 'o3d-webgl/base.js';
    var sl = s.length;
    if (src.substr(l - sl) == s) {
      o3d.basePath = src.substr(0, l - sl) + 'o3d-webgl/';
      return;
    }
  }
};

/**
 * Writes a script tag for the given o3d source file name
 * to the document.  (Must be called at execution time.)
 * @param {string} src The full path to the source file.
 * @private
 */
o3d.writeScriptTag_ = function(src) {
  var doc = o3d.global.document;
  if (typeof doc != 'undefined') {
    doc.write('<script type="text/javascript" src="' +
              src + '"></' + 'script>');
  }
};

/**
 * Filters any "o3d." prefix from the given type name.
 * @param {string} type_name The type name to filter.
 * @return {string} Filtered type name.
 * @private
 */
o3d.filterTypeName_ = function(type_name) {
  if (type_name.length >= 4 && type_name.substr(0, 4) == 'o3d.') {
    type_name = type_name.substr(4);
  }
  return type_name;
};

/**
 * Includes the file indicated by the rule by adding a script tag.
 * @param {string} rule Rule to include, in the form o3d.package.part.
 */
o3d.include = function(rule) {
  var parts = rule.split('.');
  var path = parts[parts.length - 1] + '.js';
  o3d.writeScriptTag_(o3d.basePath + path);
};


/**
 * Makes one class inherit from another.  Adds the member variables superClass
 * and superClassName to the prototype of the sub class.
 * @param {string} subClass Class that wants to inherit.
 * @param {string} superClass Class to inherit from.
 */
o3d.inherit = function(subClassName, superClassName) {
  var superClass = o3d.global.o3d[superClassName];
  var subClass = o3d.global.o3d[subClassName];

  if (!superClass)
    throw ('Invalid superclass: ' + superClassName);
  if (!subClass)
    throw ('Invalid subclass: ' + subClassName);

  subClass.prototype = new superClass;
  subClass.prototype.superClassName = superClassName;
  subClass.prototype.superClass = superClass;
  subClass.prototype.className = subClassName;
};


/**
 * Utility function to remove an object from an array.
 * @param {!Array} array The array.
 * @param {Object} object The thing to be removed.
 */
o3d.removeFromArray = function(array, object) {
  var i = array.indexOf(object);
  if (i >= 0) {
    array.splice(i, 1);
  }
};


/**
 * Determine whether a value is an array. Do not use instanceof because that
 * will not work for V8 arrays (the browser thinks they are Objects).
 * @param {*} value A value.
 * @return {boolean} Whether the value is an array.
 */
o3d.isArray_ = function(value) {
  var valueAsObject = /** @type {!Object} **/ (value);
  return typeof(value) === 'object' && value !== null &&
      'length' in valueAsObject && 'splice' in valueAsObject;
};


/**
 * Utility function to clone an object.
 *
 * @param {Object} object The object to clone.
 * @return {Object} A clone of that object.
 */
o3d.clone = function(object) {
  var result = o3d.isArray_(object) ? [] : {};
  for (var name in object) {
    var property = object[name];
    if (typeof property == 'Object') {
      result[name] = o3d.clone(property);
    } else {
      result[name] = property;
    }
  }
  return result;
};


/**
 * If an o3d function has not been implemented in javascript yet, it should
 * call this function to throw an error because it's better than doing
 * nothing.
 */
o3d.notImplemented = function() {
  debugger;
  throw 'Not implemented.';
};


// First find the path to the directory where all o3d-webgl sources live.
o3d.findBasePath_();


// Unlike o3djs, we include all o3d-webgl files at once, this way, an o3d
// developer converting to use these classes only has to include this
// javascript file.
o3d.include('object_base');
o3d.include('named_object_base');
o3d.include('named_object');
o3d.include('param_object');
o3d.include('param_array');
o3d.include('param');
o3d.include('event');
o3d.include('raw_data');
o3d.include('texture');
o3d.include('bitmap');
o3d.include('file_request');
o3d.include('client');
o3d.include('render_node');
o3d.include('clear_buffer');
o3d.include('state_set');
o3d.include('viewport');
o3d.include('tree_traversal');
o3d.include('draw_list');
o3d.include('draw_pass');
o3d.include('render_surface_set');
o3d.include('render_surface');
o3d.include('state');
o3d.include('draw_context');
o3d.include('ray_intersection_info');
o3d.include('sampler');
o3d.include('transform');
o3d.include('pack');
o3d.include('bounding_box');
o3d.include('draw_element');
o3d.include('element');
o3d.include('field');
o3d.include('buffer');
o3d.include('stream');
o3d.include('vertex_source');
o3d.include('stream_bank');
o3d.include('primitive');
o3d.include('shape');
o3d.include('effect');
o3d.include('material');
o3d.include('archive_request');
o3d.include('param_operation');
o3d.include('function');
o3d.include('counter');
o3d.include('curve');
o3d.include('skin');


