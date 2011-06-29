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
 * A ParamArray is an object that holds an array of Params.
 * @constructor
 */
o3d.ParamArray = function() {
  o3d.NamedObject.call(this);
  this.params_ = [];
};
o3d.inherit('ParamArray', 'NamedObject');


/**
 * Creates a Param of the given type at the index requested. If a Param already
 * exists at that index the new param will be replace it. If the index is past
 * the end of the current array params of the requested type will be created to
 * fill out the array to the requested index.
 *
 * @param {number} index Index at which to create new param.
 * @param {string} param_type_name The type of Param to create. For a list of
 *     valid types see ParamObject.createParam
 * @return {!o3d.ParamArray}  The newly created Param or null if failure.
 */
o3d.ParamArray.prototype.createParam = function(index, param_type_name) {
  param_type_name = o3d.filterTypeName_(param_type_name);
  if (!o3d.global.o3d[param_type_name])
    throw ('Invalid param type name: ' + param_type_name);
  if (index >= this.params_.length) {
    this.resize(index + 1, param_type_name);
  } else {
    var param = new o3d.global.o3d[param_type_name];
    param.gl = this.gl;
    param.owner_ = this;
    this.params_[index] = param;
  }

  return this.filterResult_(this.params_[index]);
};


/**
 * Gets a Param by index.
 *
 * @param {number} index Index of Param to get.
 * @return {!o3d.Param}  The Param at index, or null if out of range.
 */
o3d.ParamArray.prototype.getParam = function(index) {
  var result = this.params_[index];
  return this.filterResult_(result);
};


/**
 * Removes a range of params. This shrinks the array and affects the indices of
 * later occurring items.
 *
 * @param {number} start_index Index of first param to remove.
 * @param {number} num_to_remove The number of params to remove starting at
 *     start_index.
 */
o3d.ParamArray.prototype.removeParams = function(start_index, num_to_remove) {
  var paramsNew = [];
  var j = 0;
  for (var i = 0; i < this.params_.length; i++) {
    if (i >= start_index && i < start_index + num_to_remove) {
      // Skip these to remove them.
    } else {
      paramsNew[j] = this.params_[i];
      j++;
    }
  }
  this.params_ = paramsNew;
};


/**
 * Resizes the array.
 *
 * @param {number} num_params The number of params to make the array.
 * @param {string} param_type_name The type of Param to create if resizing
 *     requires params to be created. For a list of valid types see
 *     ParamObject.createParam.
 */
o3d.ParamArray.prototype.resize = function(num_params, param_type_name) {
  param_type_name = o3d.filterTypeName_(param_type_name);
  if (!o3d.global.o3d[param_type_name])
    throw ('Invalid param type name: ' + param_type_name);

  for (var i = this.params_.length; i < num_params; i++) {
    var param = new o3d.global.o3d[param_type_name];
    param.gl = this.gl;
    param.owner_ = this;
    this.params_[i] = param;
  }
};

/**
 * The params stored in this ParamArray.
 *
 * @type {!Array.<!o3d.Param>}
 * @private
 */
o3d.ParamArray.prototype.params_ = [];

/**
 * Gets all the param on this param object.
 *
 * Each access to this field gets the entire list, so it is best to get it
 * just once. For example:
 *
 * var params = ParamArray.params;
 * for (var i = 0; i < params.length; i++) {
 *   var param = params[i];
 * }
 *
 * Note that modifications to this array [e.g. push()] will not affect
 * the underlying ParamArray, while modifications to the array's members
 * <b>will</b> affect them.
 *
 * @type {!Array.<!o3d.Param>}
 */
o3d.ParamArray.prototype.__defineGetter__('params',
    function() {
      var params = [];
      for (var i = 0; i < this.length; i++) {
        params[i] = this.params_[i];
      }
      return params;
    }
);


/**
 * Returns the number of parameters in this ParamArray.
 *
 * @type {number}
 */
o3d.ParamArray.prototype.__defineGetter__('length',
    function() {
      return this.params_.length;
    }
);


/**
 * Filters results, turning 'undefined' into 'null'.
 *
 * @param {*} result
 * @private
 */
o3d.ParamArray.prototype.filterResult_= function(result) {
  return (result ? result : null);
};
