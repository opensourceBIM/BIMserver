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
 * EffectParameterInfo holds information about the Parameters an Effect needs.
 * o3d.Effect.getParameterInfo
 * @param {string} name Tne name of the parameter.
 * @param {string} className The param class name.
 * @param {number} numElements The number of Elements if the param is an array.
 * @param {string} sasClassName The sas class name if the param is an sas type.
 * @param {string} semantic The relevant semantic.
 */
o3d.EffectParameterInfo =
    function(name, className, numElements, semantic, sasClassName) {
  /**
   * The name of the parameter.
   * @type {string}
   */
  this.name = name || '';

  /**
   * The type of the parameter.
   * @type {string}
   */
  this.className = className || '';

  /**
   * The number of elements.  Non-zero for array types, zero for non-array
   * types.
   * @type {number}
   */
  this.numElements = numElements || 0;

  /**
   * The semantic of the parameter. This is always in UPPERCASE.
   * @type {string}
   */
  this.semantic = semantic || '';

  /**
   * If this is a standard parameter (SAS) this will be the name of the type
   * of Param needed. Otherwise it will be the empty string.
   *
   * Standard Parameters are generally handled automatically by o3d but you
   * can supply your own if you have a unique situation.
   *
   * @type {string}
   */
  this.sasClassName = sasClassName || '';
};
o3d.inherit('EffectParameterInfo', 'NamedObject');


/**
 * EffectStreamInfo holds information about the Streams an Effect needs.
 * @param {o3d.Stream.Semantic} opt_semantic The semantic of the stream
 * @param {number} opt_semantic_index
 * @constructor
 */
o3d.EffectStreamInfo = function(opt_semantic, opt_semantic_index) {
  o3d.NamedObject.call(this);
  if (!opt_semantic) {
    opt_semantic = o3d.Stream.UNKNOWN_SEMANTIC;
  }
  if (!opt_semantic_index) {
    opt_semantic_index = 0;
  }
  this.semantic = opt_semantic;
  this.opt_semantic_index = opt_semantic_index;
};
o3d.inherit('EffectStreamInfo', 'NamedObject');


/**
 * The semantic of the stream.
 * @type {!o3d.Stream.Semantic}
 */
o3d.EffectStreamInfo.prototype.semantic = o3d.Stream.UNKNOWN_SEMANTIC;



/**
 * The semantic index of the stream.
 * @type {number}
 */
o3d.EffectStreamInfo.prototype.semanticIndex = 0;


/**
 * An Effect contains a vertex and pixel shader.
 * @constructor
 */
o3d.Effect = function() {
  o3d.ParamObject.call(this);
  this.program_ = null;
  this.uniforms_ = {};
  this.attributes_ = {};
};
o3d.inherit('Effect', 'ParamObject');

o3d.Effect.HELPER_CONSTANT_NAME = 'dx_clipping';


/**
 * An object mapping the names of uniform variables to objects containing
 * information about the variable.
 * @type {Object}
 * @private
 */
o3d.Effect.prototype.uniforms_ = {};


/**
 * An object mapping the names of attributes to objects containing
 * information about the attribute.
 * @type {Object}
 * @private
 */
o3d.Effect.prototype.attributes_ = {};


/**
 * Indicates whether the vertex shader has been loaded, so we can
 * postpone linking until both shaders are in.
 *
 * @type {boolean}
 */
o3d.Effect.prototype.vertexShaderLoaded_ = false;


/**
 * Indicates whether the fragment shader has been loaded, so we can
 * postpone linking until both shaders are in.
 *
 * @type {boolean}
 */
o3d.Effect.prototype.fragmentShaderLoaded_ = false;


/**
 * Binds standard attribute locations for the shader.
 */
o3d.Effect.prototype.bindAttributesAndLinkIfReady = function() {
  if (this.vertexShaderLoaded_ && this.fragmentShaderLoaded_) {
    var semanticMap = o3d.Effect.semanticMap_;
    for (var name in semanticMap) {
      this.gl.bindAttribLocation(
          this.program_, semanticMap[name].gl_index, name);
    }
    this.gl.linkProgram(this.program_);
    if (!this.gl.getProgramParameter(this.program_, this.gl.LINK_STATUS)) {
      var log = this.gl.getShaderInfoLog(this.program_);
      this.gl.client.error_callback(
          'Program link failed with error log:\n' + log);
    }
    this.getUniforms_();
    this.getAttributes_();
  }
};


/**
 * Helper function for loadVertexShaderFromString and
 * loadPixelShaderFromString that takes the type as an argument.
 * @param {string} shaderString The shader code.
 * @param {number} type The type of the shader: either
 *    VERTEX_SHADER or FRAGMENT_SHADER.
 * @return {bool} Success.
 */
o3d.Effect.prototype.loadShaderFromString = function(shaderString, type) {
  if (!this.program_) {
    this.program_ = this.gl.createProgram();
  }

  var success = true;

  var shader = this.gl.createShader(type);
  this.gl.shaderSource(
      shader, "#ifdef GL_ES\nprecision highp float;\n#endif\n" + shaderString);
  this.gl.compileShader(shader);
  if (!this.gl.getShaderParameter(shader, this.gl.COMPILE_STATUS)) {
    success = false;
    var log = this.gl.getShaderInfoLog(shader);
    this.gl.client.error_callback(
        'Shader compile failed with error log:\n' + log);
  }

  this.gl.attachShader(this.program_, shader);

  return success;
};


/**
 * Loads a glsl vertex shader for this effect from a string.
 * @param {string} shaderString The string.
 * @return {bool} Success.
 */
o3d.Effect.prototype.loadVertexShaderFromString =
    function(shaderString) {
  var success =
      this.loadShaderFromString(shaderString, this.gl.VERTEX_SHADER);
  this.vertexShaderLoaded_ = success;
  o3d.Effect.prototype.bindAttributesAndLinkIfReady();
  return success;
};


/**
 * Loads a glsl vertex shader for this effect from a string.
 * @param {string} shaderString The string.
 * @return {bool} Success.
 */
o3d.Effect.prototype.loadPixelShaderFromString =
    function(shaderString) {
  var success =
      this.loadShaderFromString(shaderString, this.gl.FRAGMENT_SHADER);
  this.fragmentShaderLoaded_ = success;
  this.bindAttributesAndLinkIfReady();
  return success;
};


/**
 * Loads a glsl vertex shader and pixel shader from one string.
 * Assumes the vertex shader and pixel shader are separated by
 * the text '// #o3d SplitMarker'.
 * @param {string} shaderString The string.
 * @return {bool} Success.
 */
o3d.Effect.prototype.loadFromFXString =
    function(shaderString) {
  var splitIndex = shaderString.indexOf('// #o3d SplitMarker');
  return this.loadVertexShaderFromString(shaderString.substr(0, splitIndex)) &&
      this.loadPixelShaderFromString(shaderString.substr(splitIndex));
};


/**
 * Generates an array of indexed strings. For example, given 'arr' and a size
 * of 10, generates 'arr[0]', 'arr[1]', 'arr[2]' up to 'arr[9]'.
 *
 * @param {string} base The name of the array.
 * @param {number} size The number of elements in the array.
 * @return {!Array.<string>}
 * @private
 */
o3d.Effect.prototype.getParamArrayNames_ = function(base, size) {
  var names = [];
  for (var i = 0; i < size; i++) {
    names[i] = base + '[' + i + ']';
  }
  return names;
}


/**
 * Iterates through the active uniforms of the program and gets the
 * location of each one and stores them by name in the uniforms
 * object.
 * @private
 */
o3d.Effect.prototype.getUniforms_ =
    function() {
  this.uniforms_ = {};
  var numUniforms = this.gl.getProgramParameter(
      this.program_, this.gl.ACTIVE_UNIFORMS);
  for (var i = 0; i < numUniforms; ++i) {
    var info = this.gl.getActiveUniform(this.program_, i);
    var name = info.name;
    if (name.indexOf('[') != -1) {
      // This is an array param and we need to individually query each item in
      // the array to get its location.
      var baseName = info.name.substring(0, info.name.indexOf('['));
      var names = this.getParamArrayNames_(baseName, info.size);
      var locations = [];
      for (var j = 0; j < names.length; j++) {
        locations[j] = this.gl.getUniformLocation(this.program_, names[j]);
      }
      this.uniforms_[baseName] = {
          info: {name: baseName, size: info.size, type: info.type},
          kind: o3d.Effect.ARRAY,
          locations: locations /* mind the s */
      };
    } else {
      // Not an array param.
      this.uniforms_[name] = {
          info: info,
          kind: o3d.Effect.ELEMENT,
          location: this.gl.getUniformLocation(this.program_, name)
      };
    }
  }
};


/**
 * Iterates through the active attributes of the program and gets the
 * location of each one and stores them by name in the attributes
 * object.
 * @private
 */
o3d.Effect.prototype.getAttributes_ =
    function() {
  this.attributes_ = {};
  var numAttributes = this.gl.getProgramParameter(
      this.program_, this.gl.ACTIVE_ATTRIBUTES);
  for (var i = 0; i < numAttributes; ++i) {
    var info = this.gl.getActiveAttrib(this.program_, i);
    this.attributes_[info.name] = {info:info,
        location:this.gl.getAttribLocation(this.program_, info.name)};
  }
};


/**
 * A map linking the WebGL type of a uniform to the appropriate param type.
 * This gets memoized in the function createUniformParameters.
 * @private
 */
o3d.Effect.paramTypes_ = null;

/**
 * Accesses the paramTypes map, builds it if it isn't already built.
 * @private;
 */
o3d.Effect.getParamTypes_ = function(gl)  {
  // Even though these constants should be the same for different webgl
  // contexts, we can't create this table until the context is loaded, so
  // we initialize it here rather than when the file loads.
  if (!o3d.Effect.paramTypes_) {
    o3d.Effect.paramTypes_ = {};
    o3d.Effect.paramTypes_[gl.FLOAT] = 'ParamFloat';
    o3d.Effect.paramTypes_[gl.FLOAT_VEC2] = 'ParamFloat2';
    o3d.Effect.paramTypes_[gl.FLOAT_VEC3] = 'ParamFloat3';
    o3d.Effect.paramTypes_[gl.FLOAT_VEC4] = 'ParamFloat4';
    o3d.Effect.paramTypes_[gl.INT] = 'ParamInteger';
    o3d.Effect.paramTypes_[gl.BOOL] = 'ParamBoolean';
    o3d.Effect.paramTypes_[gl.FLOAT_MAT4] = 'ParamMatrix4';
    o3d.Effect.paramTypes_[gl.SAMPLER_2D] = 'ParamSampler';
    o3d.Effect.paramTypes_[gl.SAMPLER_CUBE] = 'ParamSampler';
  }

  return o3d.Effect.paramTypes_;
}


/**
 * A map linking names of certain attributes in the shader to the corresponding
 * semantic and semantic index.
 * @private
 */
o3d.Effect.semanticMap_ = {
  'position': {semantic: o3d.Stream.POSITION, index: 0, gl_index: 0},
  'normal': {semantic: o3d.Stream.NORMAL, index: 0, gl_index: 1},
  'tangent': {semantic: o3d.Stream.TANGENT, index: 0, gl_index: 2},
  'binormal': {semantic: o3d.Stream.BINORMAL, index: 0, gl_index: 3},
  'color': {semantic: o3d.Stream.COLOR, index: 0, gl_index: 4},
  'texCoord0': {semantic: o3d.Stream.TEXCOORD, index: 0, gl_index: 5},
  'texCoord1': {semantic: o3d.Stream.TEXCOORD, index: 1, gl_index: 6},
  'texCoord2': {semantic: o3d.Stream.TEXCOORD, index: 2, gl_index: 7},
  'texCoord3': {semantic: o3d.Stream.TEXCOORD, index: 3, gl_index: 8},
  'texCoord4': {semantic: o3d.Stream.TEXCOORD, index: 4, gl_index: 9},
  'texCoord5': {semantic: o3d.Stream.TEXCOORD, index: 5, gl_index: 10},
  'texCoord6': {semantic: o3d.Stream.TEXCOORD, index: 6, gl_index: 11},
  'texCoord7': {semantic: o3d.Stream.TEXCOORD, index: 7, gl_index: 12},
  'influenceWeights': {semantic: o3d.Stream.INFLUENCE_WEIGHTS, index: 0,
                       gl_index: 13},
  'influenceIndices': {semantic: o3d.Stream.INFLUENCE_INDICES, index: 0,
                       gl_index: 14}
};

o3d.Effect.reverseSemanticMap_ = [];
(function(){
  var revmap = o3d.Effect.reverseSemanticMap_;
  for (var key in o3d.Effect.semanticMap_) {
    var value = o3d.Effect.semanticMap_[key];
    revmap[value.semantic] = revmap[value.semantic] || [];
    revmap[value.semantic][value.index] = value.gl_index;
  }
})();


/**
 * For each of the effect's uniform parameters, creates corresponding
 * parameters on the given ParamObject. Skips SAS Parameters.
 *
 * If a Param with the same name but the wrong type already exists on the
 * given ParamObject createUniformParameters will attempt to replace it with
 * one of the correct type.
 *
 * Note: The most common thing to pass to this function is a Material but
 * depending on your application it may be more appropriate to pass in a
 * Transform, Effect, Element or DrawElement.
 *
 * @param {!o3d.ParamObject} param_object The param object on which the
 *     new paramters will be created.
 */
o3d.Effect.prototype.createUniformParameters =
    function(param_object) {
  var sasTypes = o3d.Param.sasTypes_;
  var paramTypes = o3d.Effect.getParamTypes_(this.gl);
  for (var name in this.uniforms_) {
    var uniformData = this.uniforms_[name];
    if (!sasTypes[name]) {
      switch (uniformData.kind) {
        case o3d.Effect.ARRAY:
          var param = param_object.createParam(name, 'ParamParamArray');
          var array = new o3d.ParamArray;
          array.gl = this.gl;
          array.resize(uniformData.info.size,
              paramTypes[uniformData.info.type]);
          param.value = array;
          break;
        case o3d.Effect.STRUCT:
          o3d.notImplemented();
          break;
        case o3d.Effect.ELEMENT:
        default:
          param_object.createParam(name, paramTypes[uniformData.info.type]);
          break;
      }
    }
  }
};


/**
 * For each of the effect's uniform parameters, if it is a SAS parameter
 * creates corresponding StandardParamMatrix4 parameters on the given
 * ParamObject.  Note that SAS parameters are handled automatically by the
 * rendering system. so except in some rare cases there is no reason to call
 * this function.  Also be aware that the StandardParamMatrix4 Paramters like
 * WorldViewProjectionParamMatrix4, etc.. are only valid during rendering.
 * At all other times they will not return valid values.
 *
 * If a Param with the same name but the wrong type already exists on the
 * given ParamObject CreateSASParameters will attempt to replace it with
 * one of the correct type.
 *
 * @param {!o3d.ParamObject} param_object The param object on which the new
 *     paramters will be created.
 */
o3d.Effect.prototype.createSASParameters =
    function(param_object) {
  var sasTypes = o3d.Param.sasTypes_;
  for (var name in this.uniforms_) {
    var info = this.uniforms_[name].info;
    var sasType = sasTypes[name];
    if (sasType) {
      param_object.createParam(info.name, sasType);
    }
  }
};


/**
 * Gets info about the parameters this effect needs.
 * @return {!Array.<!o3d.EffectParameterInfo>} an array of
 *     EffectParameterInfo objects.
 */
o3d.Effect.prototype.getParameterInfo = function() {
  var infoArray = [];
  var sasTypes = o3d.Param.sasTypes_;
  var semanticMap = o3d.Effect.semanticMap_;
  var paramTypes = o3d.Effect.getParamTypes_(this.gl);

  for (var name in this.uniforms_) {
    var uniformData = this.uniforms_[name];
    var sasClassName = sasTypes[name] || '';
    var dataType = paramTypes[uniformData.info.type] || '';
    var numElements = (uniformData.kind == o3d.Effect.ARRAY) ?
        uniformData.info.size : 0; // 0 if a non-array type.
    var semantic = semanticMap[name] ? name : '';
    infoArray.push(new o3d.EffectParameterInfo(
      name, dataType, numElements, semantic.toUpperCase(), sasClassName));
  }

  return infoArray;
};


/**
 * Gets info about the streams this effect needs.
 * @return {!Array.<!o3d.EffectStreamInfo>} an array of
 *     EffectStreamInfo objects.
 */
o3d.Effect.prototype.getStreamInfo = function() {
  var infoList = [];

  for (var name in this.attributes_) {
    var semantic_index_pair = o3d.Effect.semanticMap_[name];
    infoList.push(new o3d.EffectStreamInfo(
        semantic_index_pair.semantic, semantic_index_pair.index));
  }
  return infoList;
};


/**
 * Searches the objects in the given list for parameters to apply to the
 * uniforms defined on this effects program, and applies them, favoring
 * the objects nearer the beginning of the list.
 *
 * @param {!Array.<!o3d.ParamObject>} object_list The param objects to search.
 * @private
 */
o3d.Effect.prototype.searchForParams_ = function(object_list) {
  var unfilledMap = {};
  for (var uniformName in this.uniforms_) {
    unfilledMap[uniformName] = true;
  }
  this.gl.useProgram(this.program_);
  o3d.Param.texture_index_ = 0;
  var object_list_length = object_list.length;
  for (var i = 0; i < object_list_length; ++i) {
    var obj = object_list[i];
    for (var name in this.uniforms_) {
      if (unfilledMap[name]) {
        var uniformInfo = this.uniforms_[name];
        var param = obj.getParam(name);
        if (param) {
          if (uniformInfo.kind == o3d.Effect.ARRAY) {
            param.applyToLocations(this.gl, uniformInfo.locations);
          } else {
            param.applyToLocation(this.gl, uniformInfo.location);
          }
          delete unfilledMap[name];
        }
      }
    }
  }

  this.updateHelperConstants_(this.gl.displayInfo.width,
                              this.gl.displayInfo.height);
  delete unfilledMap[o3d.Effect.HELPER_CONSTANT_NAME];
  for (var name in unfilledMap) {
    if (this.uniforms_[name].info.type == this.gl.SAMPLER_2D) {
      if (this.gl.client.reportErrors_()) {
        this.gl.client.error_callback("Missing ParamSampler");
      }
      var defaultParamSampler = o3d.ParamSampler.defaultParamSampler_;
      defaultParamSampler.gl = this.gl;
      defaultParamSampler.applyToLocation(this.gl,
          this.uniforms_[name].location);
    } else {
      throw ('Uniform param not filled: "'+ name + '"');
    }
  }
};


/**
 * Updates certain parameters used to make the GLSL shaders have the
 * same clipping semantics as D3D's.
 * @param {number} width width of the viewport in pixels
 * @param {number} height height of the viewport in pixels
 * @private
 */
o3d.Effect.prototype.updateHelperConstants_ = function(width, height) {
  var uniformInfo = this.uniforms_[o3d.Effect.HELPER_CONSTANT_NAME];
  var dx_clipping = [ 0.0, 0.0, 0.0, 0.0 ];
  if (uniformInfo) {
    // currentRenderSurfaceSet is set in render_surface_set.js.
    dx_clipping[0] = 1.0 / width;
    dx_clipping[1] = -1.0 / height;
    dx_clipping[2] = 2.0;
    if (this.gl.currentRenderSurfaceSet) {
      dx_clipping[3] = -1.0;
    } else {
      dx_clipping[3] = 1.0;
    }

    this.gl.uniform4f(uniformInfo.location,
                      dx_clipping[0], dx_clipping[1],
                      dx_clipping[2], dx_clipping[3]);
  }
};

/**
 * @type {number}
 */
o3d.Effect.MatrixLoadOrder = goog.typedef;

/**
 *  MatrixLoadOrder,
 *  ROW_MAJOR,  Matrix parameters are loaded in row-major order (DX-style).
 *  COLUMN_MAJOR,   Matrix parameters are loaded in column-major order
 *     (OpenGL-style).
 */
o3d.Effect.ROW_MAJOR = 0;
o3d.Effect.COLUMN_MAJOR = 1;


/**
 * UniformType,
 * ELEMENT,   the param is a single gl.* element
 * ARRAY,   the param is an array of same-typed elements
 * STRUCT,   not implemented
 */
o3d.Effect.ELEMENT = 0;
o3d.Effect.ARRAY = 1;
o3d.Effect.STRUCT = 2;


/**
 * The order in which matrix data is loaded to the GPU.
 * @type {o3d.Effect.MatrixLoadOrder}
 */
o3d.Effect.prototype.matrix_load_order_ = o3d.Effect.ROW_MAJOR;


/**
 * The source for the shaders on this Effect.
 * @type {string}
 */
o3d.Effect.prototype.source_ = '';
