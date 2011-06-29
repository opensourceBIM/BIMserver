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
 * A State object sets the RenderStates for a particular material or StateSet.
 * @constructor
 */
o3d.State = function() {
  o3d.ParamObject.call(this);

  this.state_params_ = {};

 /**
 * The names types and default values of all the state variables.
 * @type {Object}
 * @private
 */
 o3d.State.stateVariableInfos_ = o3d.State.stateVariableInfos_ || {
    'AlphaBlendEnable':
        {paramType: 'ParamBoolean', defaultValue: false},
    'AlphaComparisonFunction':
        {paramType: 'ParamInteger', defaultValue: o3d.State.CMP_ALWAYS},
    'AlphaReference':
        {paramType: 'ParamFloat', defaultValue: 0},
    'AlphaTestEnable':
        {paramType: 'ParamBoolean', defaultValue: false},
    'BlendAlphaEquation':
        {paramType: 'ParamInteger', defaultValue: o3d.State.BLEND_ADD},
    'BlendEquation':
        {paramType: 'ParamInteger', defaultValue: o3d.State.BLEND_ADD},
    'CCWStencilComparisonFunction':
        {paramType: 'ParamInteger', defaultValue: o3d.State.CMP_ALWAYS},
    'CCWStencilFailOperation':
        {paramType: 'ParamInteger', defaultValue: o3d.State.STENCIL_KEEP},
    'CCWStencilPassOperation':
        {paramType: 'ParamInteger', defaultValue: o3d.State.STENCIL_KEEP},
    'CCWStencilZFailOperation':
        {paramType: 'ParamInteger', defaultValue: o3d.State.STENCIL_KEEP},
    'ColorWriteEnable':
        {paramType: 'ParamInteger', defaultValue: 15},
    'CullMode':
        {paramType: 'ParamInteger', defaultValue: o3d.State.CULL_CW},
    'DestinationBlendAlphaFunction':
        {paramType: 'ParamInteger', defaultValue: o3d.State.BLENDFUNC_ZERO},
    'DestinationBlendFunction':
        {paramType: 'ParamInteger', defaultValue: o3d.State.BLENDFUNC_ZERO},
    'DitherEnable':
        {paramType: 'ParamBoolean', defaultValue: false},
    'FillMode':
        {paramType: 'ParamInteger', defaultValue: o3d.State.SOLID},
    'LineSmoothEnable':
        {paramType: 'ParamBoolean', defaultValue: false},
    'PointSize':
        {paramType: 'ParamFloat', defaultValue: 0},
    'PointSpriteEnable':
        {paramType: 'ParamBoolean', defaultValue: false},
    'PolygonOffset1':
        {paramType: 'ParamFloat', defaultValue: 0},
    'PolygonOffset2':
        {paramType: 'ParamFloat', defaultValue: 0},
    'SeparateAlphaBlendEnable':
        {paramType: 'ParamBoolean', defaultValue: false},
    'SourceBlendAlphaFunction':
        {paramType: 'ParamInteger', defaultValue: o3d.State.BLENDFUNC_ONE},
    'SourceBlendFunction':
        {paramType: 'ParamInteger', defaultValue: o3d.State.BLENDFUNC_ONE},
    'StencilComparisonFunction':
        {paramType: 'ParamInteger', defaultValue: o3d.State.CMP_ALWAYS},
    'StencilEnable':
        {paramType: 'ParamBoolean', defaultValue: false},
    'StencilFailOperation':
        {paramType: 'ParamInteger', defaultValue: o3d.State.STENCIL_KEEP},
    'StencilMask':
        {paramType: 'ParamInteger', defaultValue: 255},
    'StencilPassOperation':
        {paramType: 'ParamInteger', defaultValue: o3d.State.STENCIL_KEEP},
    'StencilReference':
        {paramType: 'ParamInteger', defaultValue: 0},
    'StencilWriteMask':
        {paramType: 'ParamInteger', defaultValue: 255},
    'StencilZFailOperation':
        {paramType: 'ParamInteger', defaultValue: o3d.State.STENCIL_KEEP},
    'TwoSidedStencilEnable':
        {paramType: 'ParamBoolean', defaultValue: false},
    'ZComparisonFunction':
        {paramType: 'ParamInteger', defaultValue: o3d.State.CMP_LESS},
    'ZEnable':
        {paramType: 'ParamBoolean', defaultValue: true},
    'ZWriteEnable':
        {paramType: 'ParamBoolean', defaultValue: true}
  };
};
o3d.inherit('State', 'ParamObject');


/**
 * A private object containing the the state params by name.
 */
o3d.State.prototype.state_params_ = { };


/**
 *  Comparison
 *  CMP_NEVER  (Never)
 *  CMP_LESS  (Less Than)
 *  CMP_EQUAL  (Equal To)
 *  CMP_LEQUAL  (Less Than or Equal To)
 *  CMP_GREATER  (Greater Than)
 *  CMP_NOTEQUAL  (Not Equal To)
 *  CMP_GEQUAL  (Greater Than or Equal To)
 *  CMP_ALWAYS  (Always)
 */
o3d.State.CMP_NEVER = 0;
o3d.State.CMP_LESS = 1;
o3d.State.CMP_EQUAL = 2;
o3d.State.CMP_LEQUAL = 3;
o3d.State.CMP_GREATER = 4;
o3d.State.CMP_NOTEQUAL = 5;
o3d.State.CMP_GEQUAL = 6;
o3d.State.CMP_ALWAYS = 7;



/**
 * type {number}
 */
o3d.Cull = goog.typedef;

/**
 *  Cull
 *  CULL_NONE  Don't Cull by face
 *  CULL_CW  Cull clock-wise faces
 *  CULL_CCW  Cull counter clock-wise faces
 */
o3d.State.CULL_NONE = 0;
o3d.State.CULL_CW = 1;
o3d.State.CULL_CCW = 2;




/**
 *  Fill
 *  POINT
 *  WIREFRAME
 *  SOLID
 */
o3d.State.POINT = 0;
o3d.State.WIREFRAME = 1;
o3d.State.SOLID = 2;



/**
 *  BlendingFunction
 *  BLENDFUNC_ZERO
 *  BLENDFUNC_ONE
 *  BLENDFUNC_SOURCE_COLOR
 *  BLENDFUNC_INVERSE_SOURCE_COLOR
 *  BLENDFUNC_SOURCE_ALPHA
 *  BLENDFUNC_INVERSE_SOURCE_ALPHA
 *  BLENDFUNC_DESTINATION_ALPHA
 *  BLENDFUNC_INVERSE_DESTINATION_ALPHA
 *  BLENDFUNC_DESTINATION_COLOR
 *  BLENDFUNC_INVERSE_DESTINATION_COLOR
 *  BLENDFUNC_SOURCE_ALPHA_SATUTRATE
 */
o3d.State.BLENDFUNC_ZERO = 0;
o3d.State.BLENDFUNC_ONE = 1;
o3d.State.BLENDFUNC_SOURCE_COLOR = 2;
o3d.State.BLENDFUNC_INVERSE_SOURCE_COLOR = 3;
o3d.State.BLENDFUNC_SOURCE_ALPHA = 4;
o3d.State.BLENDFUNC_INVERSE_SOURCE_ALPHA = 5;
o3d.State.BLENDFUNC_DESTINATION_ALPHA = 6;
o3d.State.BLENDFUNC_INVERSE_DESTINATION_ALPHA = 7;
o3d.State.BLENDFUNC_DESTINATION_COLOR = 8;
o3d.State.BLENDFUNC_INVERSE_DESTINATION_COLOR = 9;
o3d.State.BLENDFUNC_SOURCE_ALPHA_SATUTRATE = 10;



/**
 *  BlendingEquation
 *  BLEND_ADD
 *  BLEND_SUBTRACT
 *  BLEND_REVERSE_SUBTRACT
 *  BLEND_MIN
 *  BLEND_MAX
 */
o3d.State.BLEND_ADD = 0;
o3d.State.BLEND_SUBTRACT = 1;
o3d.State.BLEND_REVERSE_SUBTRACT = 2;
o3d.State.BLEND_MIN = 3;
o3d.State.BLEND_MAX = 4;



/**
 *  StencilOperation
 *  STENCIL_KEEP
 *  STENCIL_ZERO
 *  STENCIL_REPLACE
 *  STENCIL_INCREMENT_SATURATE
 *  STENCIL_DECREMENT_SATURATE
 *  STENCIL_INVERT
 *  STENCIL_INCREMENT
 *  STENCIL_DECREMENT
 */
o3d.State.STENCIL_KEEP = 0;
o3d.State.STENCIL_ZERO = 1;
o3d.State.STENCIL_REPLACE = 2;
o3d.State.STENCIL_INCREMENT_SATURATE = 3;
o3d.State.STENCIL_DECREMENT_SATURATE = 4;
o3d.State.STENCIL_INVERT = 5;
o3d.State.STENCIL_INCREMENT = 6;
o3d.State.STENCIL_DECREMENT = 7;



/**
 * Returns a Param for a given state. If the param does not already exist it
 * will be created. If the state_name is invalid it will return null.
 * @param {string} state_name name of the state
 * @return {o3d.Param}  param or null if no matching state.
 *
 * Example:
 *
 *
 * g_o3d = document.o3d.o3d;
 * ...
 *
 * var state = my_pack.createState("my_state");
 *
 *
 * state.getStateParam('StencilEnable').value = true;
 * state.getStateParam('StencilReference').value = 25;
 * state.getStateParam('StencilPassOperation').value =
 *     g_o3d.State.STENCIL_REPLACE;
 * state.getStateParam('StencilComparisonFunction').value =
 *     g_o3d.State.CMP_ALWAYS;
 * state.getStateParam('ZEnable').value = false;
 * state.getStateParam('ZWriteEnable').value = false;
 * state.getStateParam('ColorWriteEnable').value = 0;
 *
 * Valid states:
 *
 * State NameTypeDefault Value
 * o3d.AlphaBlendEnableParamBoolean
 *     default = false
 * o3d.AlphaComparisonFunctionParamInteger,
 *     State.Comparisondefault = State.CMP_ALWAYS
 * o3d.AlphaReferenceParamFloat 0-1
 *     default = 0
 * o3d.AlphaTestEnableParamBoolean
 *     default = false
 * o3d.BlendAlphaEquation
 *     ParamInteger, State.BlendingEquation
 *     default = State.BLEND_ADD
 * o3d.BlendEquation
 *     ParamInteger, State.BlendingEquation
 *     default = State.BLEND_ADD
 * o3d.CCWStencilComparisonFunction
 *     ParamInteger, State.Comparison
 *     default = State.CMP_ALWAYS
 * o3d.CCWStencilFailOperation
 *     ParamInteger, State.StencilOperation
 *     default = State.STENCIL_KEEP
 * o3d.CCWStencilPassOperation
 *     ParamInteger, State.StencilOperation
 *     default = State.STENCIL_KEEP
 * o3d.CCWStencilZFailOperation
 *     ParamInteger, State.StencilOperation
 *     default = State.STENCIL_KEEP
 * o3d.ColorWriteEnable
 *     ParamInteger 0-15 bit 0 = red, bit 1 = green,
 *     bit 2 = blue, bit 3 = alphadefault = 15
 * o3d.CullModeParamInteger, State.Cull
 *     default = State.CULL_CW
 * o3d.DestinationBlendAlphaFunction
 *     ParamInteger, State.BlendingFunction
 *     default = State.BLENDFUNC_ZERO
 * o3d.DestinationBlendFunction
 *     ParamInteger, State.BlendingFunction
 *     default = State.BLENDFUNC_ZERO
 * o3d.DitherEnableParamBoolean
 *     default = false
 * o3d.FillModeParamInteger, State.Fill
 *     default = State.SOLID
 * o3d.LineSmoothEnableParamBoolean
 *     default = false
 * o3d.PointSizeParamFloatTBD
 * o3d.PointSpriteEnableParamBoolean
 *     default = false
 * o3d.PolygonOffset1
 *     ParamFloat, polygon offset slope factor0
 * o3d.PolygonOffset2ParamFloat, polygon offset bias (in
 *     resolvable units)0
 * o3d.SeparateAlphaBlendEnableParamBoolean
 *     default = false
 * o3d.SourceBlendAlphaFunction
 *     ParamInteger, State.BlendingFunction
 *     default = State.BLENDFUNC_ONE
 * o3d.SourceBlendFunction
 *     ParamInteger, State.BlendingFunction
 *     default = State.BLENDFUNC_ONE
 * o3d.StencilComparisonFunction
 *     ParamInteger, State.Comparison
 *     default = State.CMP_ALWAYS
 * o3d.StencilEnableParamBoolean
 *     default = false
 * o3d.StencilFailOperation
 *     ParamInteger, State.StencilOperation
 *     default = State.STENCIL_KEEP
 * o3d.StencilMaskParamInteger 0-255
 *     default = 255
 * o3d.StencilPassOperation
 *     ParamInteger, State.StencilOperation
 *     default = State.STENCIL_KEEP
 * o3d.StencilReferenceParamInteger 0-255
 *     default = 0
 * o3d.StencilWriteMaskParamInteger 0-255
 *     default = 255
 * o3d.StencilZFailOperation
 *     ParamInteger, State.StencilOperation
 *     default = State.STENCIL_KEEP
 * o3d.TwoSidedStencilEnableParamBoolean
 *     default = false
 * o3d.ZComparisonFunction
 *     ParamInteger, State.Comparison
 *     default = State.CMP_LESS
 * o3d.ZEnableParamBoolean
 *     default = true
 * o3d.ZWriteEnableParamBoolean
 *     default = true
 *
 *
 * Note: Polygon offset is computed with the following formula:
 *
 * totalOffset = PolygonOffset1 * slope + PolygonOffset2 * r
 *
 * Slope is the maximum difference in depth between 2 adjacent pixels of the
 * polygon. r is the smallest value that would fail the NOTEQUAL test against
 * 0.
 * Typical useful values to layer a polygon on top of another one are -1.0 for
 * each of PolygonOffset1 and PolygonOffset2.
 */
o3d.State.prototype.getStateParam =
    function(state_name) {
  if (!this.state_params_[state_name]) {
    var info = o3d.State.stateVariableInfos_[state_name];
    var param = new o3d.global.o3d[info.paramType];
    param.value = info.defaultValue;
    this.state_params_[state_name] = param;
  }
  return this.state_params_[state_name];
};


/**
 * Constructs a state to set all state variables to their default value.
 * This is meant to be called once at client initialization.
 * @param {WebGLContext} gl The context associated with the calling client.
 * @return {o3d.State} A new state object.
 * @private
 */
o3d.State.createDefaultState_ = function(gl) {
  var state = new o3d.State;
  state.gl = gl;
  var infos = o3d.State.stateVariableInfos_;
  for (name in infos) {
    var info = infos[name];
    state.getStateParam(name).value = info.defaultValue;
  }
  return state;
};


/**
 * Converts a comparison function type constant from o3d to WebGL.
 * @param {!WebGLContext} gl The current context.
 * @param {number} blend_func The o3d constant.
 * @return {number} The WebGL version of the constant.
 * @private
 */
o3d.State.convertCmpFunc_ = function(gl, cmp) {
  switch(cmp) {
    case o3d.State.CMP_ALWAYS:
      return gl.ALWAYS;
    case o3d.State.CMP_NEVER:
      return gl.NEVER;
    case o3d.State.CMP_LESS:
      return gl.LESS;
    case o3d.State.CMP_GREATER:
      return gl.GREATER;
    case o3d.State.CMP_LEQUAL:
      return gl.LEQUAL;
    case o3d.State.CMP_GEQUAL:
      return gl.GEQUAL;
    case o3d.State.CMP_EQUAL:
      return gl.EQUAL;
    case o3d.State.CMP_NOTEQUAL:
      return gl.NOTEQUAL;
    default:
      break;
  }
  return gl.ALWAYS;
};


/**
 * Converts a blend function type constant from o3d to WebGL.
 * @param {!WebGLContext} gl The current context.
 * @param {number} blend_func The o3d constant.
 * @return {number} The WebGL version of the constant.
 * @private
 */
o3d.State.convertBlendFunc_ = function(gl, blend_func) {
  switch (blend_func) {
    case o3d.State.BLENDFUNC_ZERO:
      return gl.ZERO;
    case o3d.State.BLENDFUNC_ONE:
      return gl.ONE;
    case o3d.State.BLENDFUNC_SOURCE_COLOR:
      return gl.SRC_COLOR;
    case o3d.State.BLENDFUNC_INVERSE_SOURCE_COLOR:
      return gl.ONE_MINUS_SRC_COLOR;
    case o3d.State.BLENDFUNC_SOURCE_ALPHA:
      return gl.SRC_ALPHA;
    case o3d.State.BLENDFUNC_INVERSE_SOURCE_ALPHA:
      return gl.ONE_MINUS_SRC_ALPHA;
    case o3d.State.BLENDFUNC_DESTINATION_ALPHA:
      return gl.DST_ALPHA;
    case o3d.State.BLENDFUNC_INVERSE_DESTINATION_ALPHA:
      return gl.ONE_MINUS_DST_ALPHA;
    case o3d.State.BLENDFUNC_DESTINATION_COLOR:
      return gl.DST_COLOR;
    case o3d.State.BLENDFUNC_INVERSE_DESTINATION_COLOR:
      return gl.ONE_MINUS_DST_COLOR;
    case o3d.State.BLENDFUNC_SOURCE_ALPHA_SATUTRATE:
      return gl.SRC_ALPHA_SATURATE;
    default:
      break;
  }
  return gl.ONE;
};


/**
 * Converts a stencil type constant from o3d to WebGL.
 * @param {!WebGLContext} gl The current context.
 * @param {number} stencil_func The o3d constant.
 * @return {number} The WebGL version of the constant.
 * @private
 */
o3d.State.convertBlendEquation_ = function(gl, blend_equation) {
  switch (blend_equation) {
    case o3d.State.BLEND_ADD:
      return gl.FUNC_ADD;
    case o3d.State.BLEND_SUBTRACT:
      return gl.FUNC_SUBTRACT;
    case o3d.State.BLEND_REVERSE_SUBTRACT:
      return gl.FUNC_REVERSE_SUBTRACT;
    case o3d.State.BLEND_MIN:
      return gl.MIN;
    case o3d.State.BLEND_MAX:
      return gl.MAX;
    default:
      break;
  }
  return gl.FUNC_ADD;
};


/**
 * Sets the internal state to the this state.
 * @private
 */
o3d.State.prototype.push_ = function() {
  this.gl.client.pushState_(this.getVariableMap_());
};


/**
 * Recovers the internal state prior to this state gettings set.
 * @private
 */
o3d.State.prototype.pop_ = function() {
  this.gl.client.popState_();
};


/**
 * Returns a new javascript object of name value pairs indicating
 * what values to set each of the (changing) state variables.
 * @return {!Object} The variable map.
 * @private
 */
o3d.State.prototype.getVariableMap_ = function() {
  var m = {};
  var stateParams = this.state_params_;
  for (var name in stateParams) {
    m[name] = stateParams[name].value;
  }
  return m;
};



/**
 * Helper function for setVariables_, looks for each of the given state
 * variables' names in the given variable map.  If any one of them is a key
 * in the map, it fills in the rest in the target_map with the value either
 * from the variable map or from the state if it isn't on the variable map.
 * @param {Array.<!string>} names The names of the variables in question.
 * @param {!Object} variable_map An object connecting names to values.
 * @param {!Object} target_map An object to fill out with the variables from
 *    the given array of names.
 * @return {boolean} True if any of the variable names in the given array were
 *    found in the variable_map
 * @private
 */
o3d.State.relevantValues_ =
    function(gl, names, variable_map, target_map) {
  var found = false;
  for (var i = 0; i < names.length; ++i) {
    var name = names[i];
    if (variable_map[name] !== undefined) {
      found = true;
      break;
    }
  }

  if (found) {
    for (var i = 0; i < names.length; ++i) {
      var name = names[i];
      var value = variable_map[name];
      if (value === undefined) {
        value = gl.client.getState_(name);
      }
      target_map[name] = value;
    }
  }
  return found;
};


/**
 * Sets the internal state according to the name value pairs in the given
 * object.
 * @param {WebGLContext} gl The gl context to use.
 * @param {Object} variable_map A map linking state variable names to values.
 * @private
 */
o3d.State.setVariables_ = function(gl, variable_map) {
  // TODO(petersont): Only some of the state variables have been implemented.
  // Others are unavailable in webgl.

  // Remember, any state variable might be missing from variable_map.  When the
  // key is not present, the state should be left alone.

  // Temporary map to hold name value pairs.
  var v = {};

  if (this.relevantValues_(gl, ['AlphaBlendEnable'], variable_map, v)) {
    if (v['AlphaBlendEnable']) {
      gl.enable(gl.BLEND);
    } else {
      gl.disable(gl.BLEND);
    }
  }

  if (this.relevantValues_(gl, ['SeparateAlphaBlendEnable',
                                'SourceBlendFunction',
                                'SourceBlendAlphaFunction',
                                'DestinationBlendAlphaFunction',
                                'BlendEquation',
                                'BlendAlphaEquation'], variable_map, v)) {
    if (v['SeparateAlphaBlendEnable']) {
      gl.blendFuncSeparate(
          o3d.State.convertBlendFunc_(gl, v['SourceBlendFunction']),
          o3d.State.convertBlendFunc_(gl, v['DestinationBlendFunction']),
          o3d.State.convertBlendFunc_(gl, v['SourceBlendAlphaFunction']),
          o3d.State.convertBlendFunc_(gl, v['DestinationBlendAlphaFunction']));
      gl.blendEquationSeparate(
        o3d.State.convertBlendEquation_(gl, v['BlendEquation']),
        o3d.State.convertBlendEquation_(gl, v['BlendAlphaEquation']));
    }
  }

  if (this.relevantValues_(gl, ['SourceBlendFunction',
                                'DestinationBlendFunction'], variable_map, v)) {
    gl.blendFunc(
        o3d.State.convertBlendFunc_(gl, v['SourceBlendFunction']),
        o3d.State.convertBlendFunc_(gl, v['DestinationBlendFunction']));
  }

  if (this.relevantValues_(gl, ['BlendEquation'], variable_map, v)) {
    gl.blendEquation(o3d.State.convertBlendEquation_(gl, v['BlendEquation']));
  }

  if (this.relevantValues_(gl, ['CullMode'], variable_map, v)) {
    switch (v['CullMode']) {
      case o3d.State.CULL_CW:
        gl.enable(gl.CULL_FACE);
        gl.cullFace(gl.BACK);
        break;
      case o3d.State.CULL_CCW:
        gl.enable(gl.CULL_FACE);
        gl.cullFace(gl.FRONT);
        break;
      default:
        gl.disable(gl.CULL_FACE);
        break;
    }
  }

  if (this.relevantValues_(gl, ['DitherEnable'], variable_map, v)) {
    if (v['DitherEnable']) {
      gl.enable(gl.DITHER);
    } else {
      gl.disable(gl.DITHER);
    }
  }

  if (this.relevantValues_(gl, ['ZEnable', 'ZComparisonFunction'],
      variable_map, v)) {
    if (v['ZEnable']) {
      gl.enable(gl.DEPTH_TEST);
      gl.depthFunc(
          this.convertCmpFunc_(gl, v['ZComparisonFunction']));
    } else {
      gl.disable(gl.DEPTH_TEST);
    }
  }

  if (this.relevantValues_(gl, ['ZWriteEnable'], variable_map, v)) {
    gl.depthMask(v['ZWriteEnable']);
  }

  if (this.relevantValues_(gl, ['StencilEnable', 'StencilComparisonFunction'],
      variable_map, v)) {
    if (v['StencilEnable']) {
      gl.enable(gl.STENCIL_TEST);
      gl.stencilFunc(
          this.convertCmpFunc_(gl, v['StencilComparisonFunction']));
    } else {
      gl.disable(gl.STENCIL_TEST);
    }
  }

  if (this.relevantValues_(gl, ['PolygonOffset1',
                                'PolygonOffset2'], variable_map, v)) {
    var polygon_offset_factor = v['PolygonOffset1'] || 0;
    var polygon_offset_bias = v['PolygonOffset2'] || 0;

    if (polygon_offset_factor || polygon_offset_bias) {
      gl.enable(gl.POLYGON_OFFSET_FILL);
      gl.polygonOffset(polygon_offset_factor, polygon_offset_bias);
    } else {
      gl.disable(gl.POLYGON_OFFSET_FILL);
    }
  }

  if (this.relevantValues_(gl, ['FillMode'], variable_map, v)) {
    // We emulate the behavior of the fill mode state in the primitive class.
    gl.fillMode_ = v['FillMode'];
  }
};



