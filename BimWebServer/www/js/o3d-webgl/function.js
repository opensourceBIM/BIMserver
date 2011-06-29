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
 * A Function is a class that has an Evaluate method.
 * Evaluate takes 1 input and returns 1 output.
 * @param {function(number)=} opt_func  evaluate function to use (unless this
 *     class is extended
 * @constructor
 * @extends {o3d.NamedObject}
 */
o3d.Function = function(opt_func) {
    o3d.NamedObject.call(this);
    this.func_ = opt_func;
};
o3d.inherit('Function', 'NamedObject');

/**
 * Gets an output for this function for the given input.
 * @param {number} input Input to get output at.
 * @param {object=} opt_context Cached state from the previous evaluate call.
 * @return {number} The output for the given input.
 */
o3d.Function.prototype.evaluate = function(input, opt_context) {
    this.func_.call(this, input, opt_context);
};

/**
 * A FunctionEval evaluates a Function through parameters.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.FunctionEval = function() {
  o3d.ParamObject.call(this);

  /**
   * Read/write input value to the function.
   * @private
   * @type {o3d.ParamFloat}
   */
  this.input_param_ = this.getParam("input");

  /**
   * ParamFunction whose value is a o3d.Function or subclass.
   * @private
   * @type {o3d.ParamFunction}
   */
  this.func_param_ = this.getParam("functionObject");

  /**
   * Read-only output value. Value is cached if input does not change.
   * @private
   * @type {o3d.ParamFloatOutput}
   */
  this.output_param_ = this.getParam("output");

  /**
   * Context value to allow faster evaluation for adjacent input values.
   * Used by the o3d.Function itself, but stored here to allow multiple
   * FunctionEval objects to share the same Function object.
   * @private
   * @type {object}
   */
  this.func_context_ = {};

  /**
   * Last input value to check if cache needs to be invalidated.
   * @private
   * @type {number}
   */
  this.last_input_value_ = null;

  /**
   * Cache of the last output value.
   * @private
   * @type {number}
   */
  this.last_output_value_ = null;
};
o3d.inherit('FunctionEval', 'ParamObject');

/**
 * Read-only output value. Value is cached if input does not change.
 * @type {number}
 */
o3d.ParamObject.setUpO3DParam_(o3d.FunctionEval, "output", "ParamFloatOutput");

/**
 * Read/write input value to the function.
 * @type {number}
 */
o3d.ParamObject.setUpO3DParam_(o3d.FunctionEval, "input", "ParamFloat");

/**
 * o3d.Function object (or subclass) with evaluate function.
 * @type {o3d.Function}
 */
o3d.ParamObject.setUpO3DParam_(o3d.FunctionEval, "functionObject",
    "ParamFunction");

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * This function should be responsible for caching the last value if necessary.
 * @return {number} The result of evaluating the function.
 */
o3d.FunctionEval.prototype.updateOutputs = function() {
  var new_input_value = this.input_param_.value;
  if (this.last_input_value_ != new_input_value) {
    this.last_output_value_ =
        this.func_param_.value.evaluate(this.last_input_value_,
                                        this.func_context_);
    this.last_input_value_ = new_input_value;
  }
  return this.last_output_value_;
};
