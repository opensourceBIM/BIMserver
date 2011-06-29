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
 * A ParamObject is the base class for all objects that can have Params.
 * Defines methods to add and remove params, search for params, etc.
 * @constructor
 */
o3d.ParamObject = function() {
  o3d.NamedObject.call(this);
  this.params_ = {};
};
o3d.inherit('ParamObject', 'NamedObject');

o3d.ParamObject.prototype.__defineGetter__('params',
    function() {
      var paramList = [];
      for (name in this.params_) {
        paramList.push(this.params_[name]);
      }
      return paramList;
    });

o3d.ParamObject.prototype.__defineSetter__('params', function() {});

o3d.ParamObject.O3D_PREFIX_ = 'o3d.';

/**
 * Creates a Param with the given name and type on the ParamObject.
 * Will fail if a param with the same name already exists.
 *
 * @param {string} param_name The name of the Param to be created.
 * @param {string} param_type_name The type of Param to create.
 *     Valid types are
 *     'ParamBoolean'
 *     'ParamBoundingBox'
 *     'ParamDrawContext'
 *     'ParamDrawList'
 *     'ParamEffect'
 *     'ParamFloat'
 *     'ParamFloat2'
 *     'ParamFloat3'
 *     'ParamFloat4'
 *     'ParamFunction'
 *     'ParamInteger'
 *     'ParamMaterial'
 *     'ParamMatrix4'
 *     'ParamParamArray'
 *     'ParamRenderSurface'
 *     'ParamRenderDepthStencilSurface'
 *     'ParamSampler'
 *     'ParamSkin'
 *     'ParamSteamBank'
 *     'ParamState'
 *     'ParamString'
 *     'ParamTexture'
 *     'ParamTransform'
 *     'ProjectionParamMatrix4'
 *     'ProjectionInverseParamMatrix4'
 *     'ProjectionTransposeParamMatrix4'
 *     'ProjectionInverseTransposeParamMatrix4'
 *     'ViewParamMatrix4'
 *     'ViewInverseParamMatrix4'
 *     'ViewTransposeParamMatrix4'
 *     'ViewInverseTransposeParamMatrix4'
 *     'ViewProjectionParamMatrix4'
 *     'ViewProjectionInverseParamMatrix4'
 *     'ViewProjectionTransposeParamMatrix4'
 *     'ViewProjectionInverseTransposeParamMatrix4'
 *     'WorldParamMatrix4'
 *     'WorldInverseParamMatrix4'
 *     'WorldTransposeParamMatrix4'
 *     'WorldInverseTransposeParamMatrix4'
 *     'WorldViewParamMatrix4'
 *     'WorldViewInverseParamMatrix4'
 *     'WorldViewTransposeParamMatrix4'
 *     'WorldViewInverseTransposeParamMatrix4'
 *     'WorldViewProjectionParamMatrix4'
 *     'WorldViewProjectionInverseParamMatrix4'
 *     'WorldViewProjectionTransposeParamMatrix4'
 *     'WorldViewProjectionInverseTransposeParamMatrix4'
 * @return {!o3d.Param}  The newly created Param or null on failure.
 */
o3d.ParamObject.prototype.createParam =
    function(param_name, param_type_name) {
  if (this.params_[param_name])
    return null;
  param_type_name = o3d.filterTypeName_(param_type_name);
  if (!o3d.global.o3d[param_type_name])
    throw ('Invalid param type name: ' + param_type_name);
  var param = new o3d.global.o3d[param_type_name];
  param.gl = this.gl;
  param.owner_ = this;
  param.name = param_name;
  this.params_[param_name] = param;
  return this.filterResult_(this.params_[param_name]);
};


/**
 * Searches by name for a Param defined in the object.
 *
 * @param {string} param_name Name to search for.
 * @return {!o3d.Param}  The Param with the given name, or null otherwise.
 */
o3d.ParamObject.prototype.getParam =
    function(param_name) {
  var result = this.params_[param_name];
  var o3d_name;
  if (!result) {
    // Try again with O3D prefix.
    o3d_name = o3d.ParamObject.O3D_PREFIX_ + param_name;
    result = this.params_[o3d_name];
  }

  if (!result) {
    // See if it's one of the params which needs to be created lazily.
    // If it is, initialize it with the current value in the object.
    var lazyParamMap = this.lazyParamMap_;
    if (lazyParamMap) {
      var name = param_name;
      var param_type = this.lazyParamMap_[name];
      if (!param_type) {
        name = o3d_name;
        param_type = this.lazyParamMap_[name];
      }
      if (param_type) {
        result = this.createParam(name, param_type);
      }
    }
  }

  return this.filterResult_(result);
};


/**
 * Removes a Param from a ParamObject.
 *
 * This function will fail if the param does not exist on this ParamObject
 * or if the param is unremovable.
 *
 * @param {!o3d.Param} param param to remove.
 * @return {boolean}  True if the param was removed.
 */
o3d.ParamObject.prototype.removeParam =
    function(param) {
  for (var i in this.params_) {
    if (this.params_[i] == param) {
      delete this.params_[i];
    }
  }
};


/**
 * Gets all the param on this param object.
 *
 * Each access to this field gets the entire list, so it is best to get it
 * just once. For example:
 *
 * var params = paramObject.params;
 * for (var i = 0; i < params.length; i++) {
 *   var param = params[i];
 * }
 *
 * Note that modifications to this array [e.g. push()] will not affect
 * the underlying ParamObject, while modifications to the array's members
 * will affect them.
 */
o3d.ParamObject.prototype.params_ = {};


/**
 * Copies all the params from a the given source_param_object to this param
 * object. Does not replace any currently existing params with the same name.
 *
 * @param {o3d.ParamObject} source_param_object param object to copy params
 *     from.
 */
o3d.ParamObject.prototype.copyParams =
    function(source_param_object) {
  for (name in source_param_object.params_) {
    var param = source_param_object.params_[name];
    this.createParam(name, param.className);
    this.getParam(name).value = param.value;
  }
};


/**
 * Filters results, turning 'undefined' into 'null'.
 * @private
 */
o3d.ParamObject.prototype.filterResult_= function(result) {
  return (result ? result : null);
};


/**
 * Sets up an o3d-scoped parameter against the given constructor
 * function of the given type for the given field.
 * @private
 */
o3d.ParamObject.setUpO3DParam_ = function(constructor,
                                          fieldName,
                                          paramType) {
  var o3dParamName = o3d.ParamObject.O3D_PREFIX_ + fieldName;

  // The lazyParamMap primarily handles the case where getParam is
  // called before the getter or setter below. It also simplifies the
  // code below since it can simply call getParam and the param will
  // be created on demand.
  var lazyParamMap = constructor.prototype.lazyParamMap_;
  if (!lazyParamMap) {
    lazyParamMap = {};
    constructor.prototype.lazyParamMap_ = lazyParamMap;
  }
  lazyParamMap[o3dParamName] = paramType;

  constructor.prototype.__defineGetter__(fieldName,
      function() {
        var param = this.getParam(o3dParamName);
        return param.value;
      });
  constructor.prototype.__defineSetter__(fieldName,
      function(v) {
        var param = this.getParam(o3dParamName);
        param.value = v;
      });
};

