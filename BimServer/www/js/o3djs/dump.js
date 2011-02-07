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
 * @fileoverview This file contains various dumping functions for o3d.  It
 * puts them in the "dump" module on the o3djs object.
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.dump');

/**
 * A Module for dumping information about o3d objects.
 * @namespace
 */
o3djs.dump = o3djs.dump || {};

/**
 * Dump the 3 elements of an array of numbers.
 * @private
 * @param {string} label Label to put in front of dump.
 * @param {!Array.<number>} object Array.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpXYZ_ = function(label, object, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dump(opt_prefix + label + ' : ' + object[0] + ', ' +
                  object[1] + ', ' + object[2] + '\n');
};

/**
 * Dump the 4 elements of an array of numbers.
 * @private
 * @param {string} label Label to put in front of dump.
 * @param {!Array.<number>} object Array.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpXYZW_ = function(label, object, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dump(opt_prefix + label + ' : ' +
                  object[0] + ', ' +
                  object[1] + ', ' +
                  object[2] + ', ' +
                  object[3] + '\n');
};

/**
 * Get the name of a function.
 * @private
 * @param {!function(...): *} theFunction Function.
 * @return {string} The function name.
 */
o3djs.dump.getFunctionName_ = function(theFunction) {
  if (theFunction.name) {
    return theFunction.name;
  }

  // try to parse the function name from the definition
  var definition = theFunction.toString();
  var name = definition.substring(definition.indexOf('function') + 8,
                                  definition.indexOf('('));
  if (name) {
    return name;
  }

  // sometimes there won't be a function name
  // like for dynamic functions
  return '*anonymous*';
};

/**
 * Get the signature of a function.
 * @private
 * @param {!function(...): *} theFunction Function.
 * @return {string} The function signature.
 */
o3djs.dump.getSignature_ = function(theFunction) {
  var signature = o3djs.dump.getFunctionName_(theFunction);
  signature += '(';
  for (var x = 0; x < theFunction.arguments.length; x++) {
    // trim long arguments
    var nextArgument = theFunction.arguments[x];
    if (nextArgument.length > 30) {
      nextArgument = nextArgument.substring(0, 30) + '...';
    }

    // apend the next argument to the signature
    signature += "'" + nextArgument + "'";

    // comma separator
    if (x < theFunction.arguments.length - 1) {
      signature += ', ';
    }
  }
  signature += ')';
  return signature;
};

/**
 * Prints a value the console or log or wherever it thinks is appropriate
 * for debugging.
 * @param {string} string String to print.
 */
o3djs.dump.dump = function(string) {
  o3djs.BROWSER_ONLY = true;
  if (window.dump) {
    window.dump(string);
  } else if (window.console && window.console.log) {
    window.console.log(string);
  }
};

/**
 * Gets the value of a matrix as a string.
 * @param {!o3djs.math.Matrix4} matrix Matrix4 to get value of.
 * @param {string} opt_prefix Optional prefix for indenting.
 * @return {string} Value of param.
 */
o3djs.dump.getMatrixAsString = function(matrix, opt_prefix) {
  opt_prefix = opt_prefix || '';
  var result = opt_prefix + '[';
  for (var i = 0; 1; ++i){
    var mi = matrix[i];
    result += '[';
    for (var j = 0; 1; ++j) {
      result += mi[j];
      if (j < mi.length - 1) {
        result += ', ';
      } else {
        result += ']';
        break;
      }
    }
    if (i < matrix.length - 1) {
      result += '\n';
      result += opt_prefix;
    } else {
      break;
    }
  }
  result += ']';
  return result;
};

/**
 * Dumps a float3
 * @param {string} label Label to put in front of dump.
 * @param {!o3d.Float3} float3 Float3 to dump.
 * @param {string} opt_prefix optional prefix for indenting.
 */
o3djs.dump.dumpFloat3 = function(label, float3, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dumpXYZ_(label, float3, opt_prefix);
};

/**
 * Dumps a float4
 * @param {string} label Label to put in front of dump.
 * @param {!o3d.Float4} float4 Float4 to dump.
 * @param {string} opt_prefix optional prefix for indenting.
 */
o3djs.dump.dumpFloat4 = function(label, float4, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dumpXYZW_(label, float4, opt_prefix);
};

/**
 * Dumps a vector4
 * @param {string} label Label to put in front of dump.
 * @param {!Array.<number>} vector4 vector to dump.
 * @param {string} opt_prefix optional prefix for indenting.
 */
o3djs.dump.dumpVector4 = function(label, vector4, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dumpXYZW_(label, vector4, opt_prefix);
};

/**
 * Dumps a matrix
 * @param {string} label Label to put in front of dump.
 * @param {!o3djs.math.Matrix4} matrix Matrix to dump.
 * @param {string} opt_prefix optional prefix for indenting.
 */
o3djs.dump.dumpMatrix = function(label, matrix, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dump(
      opt_prefix + label + ' :\n' +
      o3djs.dump.getMatrixAsString(matrix, opt_prefix + '    ') +
      '\n');
};

/**
 * Dump a bounding box.
 * @param {string} label Label to put in front of dump.
 * @param {!o3d.BoundingBox} boundingBox BoundingBox to dump.
 * @param {string} opt_prefix optional prefix for indenting.
 */
o3djs.dump.dumpBoundingBox = function(label,
                                      boundingBox,
                                      opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dump(opt_prefix + label + ' :\n');
  o3djs.dump.dumpFloat3('min : ',
                        boundingBox.minExtent,
                        opt_prefix + '    ');
  o3djs.dump.dumpFloat3('max : ',
                        boundingBox.maxExtent,
                        opt_prefix + '    ');
};

/**
 * Gets the value of a parameter as a string.
 * @param {!o3d.Param} param Parameter to get value of.
 * @param {string} opt_prefix Optional prefix for indenting.
 * @return {string} Value of param.
 */
o3djs.dump.getParamValueAsString = function(param, opt_prefix) {
  opt_prefix = opt_prefix || '';
  var value = '*unknown*';

  if (param.isAClassName('o3d.ParamFloat')) {
    value = param.value.toString();
  } else if (param.isAClassName('o3d.ParamFloat2')) {
    value = '[' + param.value[0] + ', ' +
                  param.value[1] + ']';
  } else if (param.isAClassName('o3d.ParamFloat3')) {
    value = '[' + param.value[0] + ', ' +
                  param.value[1] + ', ' +
                  param.value[2] + ']';
  } else if (param.isAClassName('o3d.ParamFloat4')) {
    value = '[' + param.value[0] + ', ' +
                  param.value[1] + ', ' +
                  param.value[2] + ', ' +
                  param.value[3] + ']';
  } else if (param.isAClassName('o3d.ParamInteger')) {
    value = param.value.toString();
  } else if (param.isAClassName('o3d.ParamBoolean')) {
    value = param.value.toString();
  } else if (param.isAClassName('o3d.ParamMatrix4')) {
    value = '\n' + o3djs.dump.getMatrixAsString(param.value,
                                                opt_prefix + '    ');
  } else if (param.isAClassName('o3d.ParamString')) {
    value = param.value;
  } else if (param.isAClassName('o3d.ParamTexture')) {
    value = param.value;
    value = 'texture : "' + (value ? value.name : 'NULL') + '"';
  } else if (param.isAClassName('o3d.ParamSampler')) {
    value = param.value;
    value = 'sampler : "' + (value ? value.name : 'NULL') + '"';
  } else if (param.isAClassName('o3d.ParamMaterial')) {
    value = param.value;
    value = 'material : "' + (value ? value.name : 'NULL') + '"';
  } else if (param.isAClassName('o3d.ParamEffect')) {
    value = param.value;
    value = 'effect : "' + (value ? value.name : 'NULL') + '"';
  } else if (param.isAClassName('o3d.ParamState')) {
    value = param.value;
    value = 'state : "' + (value ? value.name : 'NULL') + '"';
  } else if (param.isAClassName('o3d.ParamTransform')) {
    value = param.value;
    value = 'transform : "' + (value ? value.name : 'NULL') + '"';
  } else if (param.isAClassName('o3d.ParamDrawList')) {
    value = param.value;
    value = 'drawlist : "' + (value ? value.name : 'NULL') + '"';
  } else if (param.isAClassName('o3d.ParamRenderSurface')) {
    value = param.value;
    value = 'renderSurface : "' + (value ? value.name : 'NULL') + '"';
  } else if (param.isAClassName('o3d.ParamRenderDepthStencilSurface')) {
    value = param.value;
    value = 'renderDepthStencilSurface: "' + (value ? value.name : 'NULL') +
            '"';
  } else if (param.isAClassName('o3d.ParamDrawContext')) {
    value = param.value;
    value = 'drawcontext : "' + (value ? value.name : 'NULL') + '"';
  }

  return value;
};

/**
 * Dumps an single parameter
 * @param {!o3d.Param} param Param to dump.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpParam = function(param, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dump (
      opt_prefix + param.className + ' : "' + param.name + '" : ' +
      o3djs.dump.getParamValueAsString(param, opt_prefix) + '\n');
};

/**
 * Given a ParamObject dumps all the Params on it.
 * @param {!o3d.ParamObject} param_object ParamObject to dump Params of.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpParams = function(param_object, opt_prefix) {
  opt_prefix = opt_prefix || '';
  // print params
  var params = param_object.params;
  for (var p = 0; p < params.length; p++) {
    o3djs.dump.dumpParam(params[p], opt_prefix);
  }
};

/**
 * Given a ParamObject dumps it and all the Params on it.
 * @param {!o3d.ParamObject} param_object ParamObject to dump.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpParamObject = function(param_object, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dump (
      opt_prefix + param_object.className + ' : "' +
      param_object.name + '"\n');
  o3djs.dump.dumpParams(param_object, opt_prefix + '    ');
};

/**
 * Given a Stream dumps it and all the Params on it.
 * @param {!o3d.Stream} stream Stream to dump.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpStream = function(stream, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dump(
      opt_prefix + 'semantic: ' + stream.semantic +
      ', index: ' + stream.semanticIndex +
      ', dataType: ' + stream.dataType +
      ', field: ' + stream.field.name + '\n');
};

/**
 * Given a element dumps its name, all the Params and DrawElements on
 * it.
 * @param {!o3d.Element} element Element to dump.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpElement = function(element, opt_prefix) {
  opt_prefix = opt_prefix || '';

  o3djs.dump.dump (opt_prefix + '------------ Element --------------\n');

  // get type
  o3djs.dump.dump (
      opt_prefix + 'Element: "' + element.name + '"\n');

  // print params
  o3djs.dump.dump (opt_prefix + '  --Params--\n');
  o3djs.dump.dumpParams (element, opt_prefix + '  ');

  // print elements.
  o3djs.dump.dump (opt_prefix + '  --DrawElements--\n');
  var drawElements = element.drawElements;
  for (var g = 0; g < drawElements.length; g++) {
    var drawElement = drawElements[g]
    o3djs.dump.dumpParamObject(drawElement, opt_prefix + '    ');
  }

  if (element.isAClassName('o3d.Primitive')) {
    o3djs.dump.dump (
        opt_prefix + '  primitive type: ' + element.primitiveType + '\n');
    o3djs.dump.dump (
        opt_prefix + '  number vertices: ' + element.numberVertices + '\n');
    o3djs.dump.dump (
        opt_prefix + '  number primitives: ' + element.numberPrimitives +
        '\n');
    var streamBank = element.streamBank;
    if (streamBank) {
      var streams = streamBank.vertexStreams;
      for (var ss = 0; ss < streams.length; ss++) {
        var stream = streams[ss];
        o3djs.dump.dump(opt_prefix + '  stream ' + ss + ': ');
        o3djs.dump.dumpStream(stream);
      }
    }
  }
};

/**
 * Given a shape dumps its name, all the Params and Primitves on
 * it.
 * @param {!o3d.Shape} shape Shape to dump.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpShape = function(shape, opt_prefix) {
  opt_prefix = opt_prefix || '';

  o3djs.dump.dump (opt_prefix + '------------ Shape --------------\n');

  // get type
  o3djs.dump.dump (
      opt_prefix + 'Shape: "' + shape.name + '"\n');

  // print params
  o3djs.dump.dump (opt_prefix + '  --Params--\n');
  o3djs.dump.dumpParams (shape, opt_prefix + '  ');

  // print elements.
  o3djs.dump.dump (opt_prefix + '  --Elements--\n');
  var elements = shape.elements;
  for (var p = 0; p < elements.length; p++) {
    var element = elements[p];
    o3djs.dump.dumpElement(element, opt_prefix + '    ');
  }
};

/**
 * Given a texture dumps its name and other info.
 * it.
 * @param {!o3d.Texture} texture Texture to dump.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpTexture = function(texture, opt_prefix) {
  opt_prefix = opt_prefix || '';
  var uri = '';
  var param = texture.getParam('uri');
  if (param) {
    uri = param.value;
  }
  o3djs.dump.dump (
      opt_prefix + texture.className +
      ' : "' + texture.name +
      '" uri : "' + uri +
      '" width: ' + texture.width +
      ' height: ' + texture.height +
      ' alphaIsOne: ' + texture.alphaIsOne +
      '\n');
};

/**
 * Given a transform dumps its name and all the Params and Shapes on it.
 * @param {!o3d.Transform} transform Transform to dump.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpTransform = function(transform, opt_prefix) {
  opt_prefix = opt_prefix || '';

  o3djs.dump.dump (opt_prefix + '----------- Transform -------------\n');

  // get type
  o3djs.dump.dump (
      opt_prefix + 'Transform: ' + transform.name + '"\n');

  // print params
  o3djs.dump.dump (opt_prefix + '  --Local Matrix--\n');
  o3djs.dump.dump (
      o3djs.dump.getMatrixAsString(transform.localMatrix,
                                   opt_prefix + '    ') + '\n');

  // print params
  o3djs.dump.dump (opt_prefix + '  --Params--\n');
  o3djs.dump.dumpParams (transform, opt_prefix + '  ');

  // print shapes.
  o3djs.dump.dump (opt_prefix + '  --Shapes--\n');
  var shapes = transform.shapes;
  for (var s = 0; s < shapes.length; s++) {
    var shape = shapes[s];
    o3djs.dump.dumpNamedObjectName(shape, opt_prefix + '  ');
  }
};

/**
 * Dumps an entire transform graph tree.
 * @param {!o3d.Transform} transform Transform to start dumping from.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpTransformTree = function(transform, opt_prefix) {
  opt_prefix = opt_prefix || '';

  o3djs.dump.dumpTransform(transform, opt_prefix);

  var child_prefix = opt_prefix + '    ';
  var children = transform.children;
  for (var c = 0; c < children.length; c++) {
    o3djs.dump.dumpTransformTree(children[c], child_prefix);
  }
};

/**
 * Dumps a list of Transforms.
 * @param {!Array.<!o3d.Transform>} transform_list Array of Transforms to dump.
 */
o3djs.dump.dumpTransformList = function(transform_list) {
  o3djs.dump.dump (transform_list.length + ' transforms in list!!!\n');
  for (var i = 0; i < transform_list.length; i++) {
    o3djs.dump.dumpTransform(transform_list[i]);
  }
};

/**
 * Dumps the name and class of a NamedObject.
 * @param {!o3d.NamedObject} namedObject to use.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpNamedObjectName = function(namedObject, opt_prefix) {
  opt_prefix = opt_prefix || '';
  o3djs.dump.dump (
      opt_prefix + namedObject.className + ' : "' + namedObject.name +
      '"\n');
};

/**
 * Dumps a RenderNode and all its paramaters.
 * @param {!o3d.RenderNode} render_node RenderNode to use.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpRenderNode = function(render_node, opt_prefix) {
  opt_prefix = opt_prefix || '';

  o3djs.dump.dump (opt_prefix + '----------- Render Node -----------\n');
  // get type
  o3djs.dump.dumpNamedObjectName(render_node, opt_prefix);

  // print params
  o3djs.dump.dump (opt_prefix + '  --Params--\n');
  o3djs.dump.dumpParams(render_node, opt_prefix + '  ');
};

/**
 * Dumps an entire RenderGraph tree.
 * @param {!o3d.RenderNode} render_node RenderNode to start dumping from.
 * @param {string} opt_prefix Optional prefix for indenting.
 */
o3djs.dump.dumpRenderNodeTree = function(render_node, opt_prefix) {
  opt_prefix = opt_prefix || '';

  o3djs.dump.dumpRenderNode(render_node, opt_prefix);

  var child_prefix = opt_prefix + '    ';
  // Get the list of children sorted by priority.
  var children = render_node.children.sort(function(a, b) {
        return a.priority - b.priority;
      });
  for (var c = 0; c < children.length; c++) {
    o3djs.dump.dumpRenderNodeTree(children[c], child_prefix);
  }
};

/**
 * Dumps a javascript stack track.
 */
o3djs.dump.dumpStackTrace = function() {
  o3djs.dump.dump('Stack trace:\n');
  var nextCaller = arguments.callee.caller;
  while (nextCaller) {
    o3djs.dump.dump(o3djs.dump.getSignature_(nextCaller) + '\n');
    nextCaller = nextCaller.caller;
  }
  o3djs.dump.dump('\n\n');
};

