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
 * A CurveKey prepresents a key on an Curve.
 *
 * @constructor
 * @extends {o3d.ObjectBase}
 */
o3d.CurveKey = function(owner) {
  o3d.ObjectBase.call(this);
  /**
   * The only owner of this CurveKey (cannot be shared).
   * @private
   * @type {!o3d.Curve}
   */
  this.owner_ = owner;

  /**
   * See input setter.
   * @private
   * @type {number}
   */
  this.input_ = 0;

  /**
   * See input setter.
   * @private
   * @type {number}
   */
  this.output_ = 0;
};
o3d.inherit('CurveKey', 'ObjectBase');

/**
 * Destroys this key, removing it from its owner.
 *
 */
o3d.CurveKey.prototype.destroy = function() {
  o3d.removeFromArray(this.owner_.keys, this);
  this.owner_.invalidateCache_();
};

/**
 * Computes the value within the range from this.input to next_key.input.
 * Defaults to the LinearCurveKey implementation which is continuous.
 * @param {number} offset  Offset within the key (function input - this.input)
 * @param {o3d.CurveKey} next_key The next key in the set, can not be null.
 * @return {number} return
 */
o3d.CurveKey.prototype.getOutputAtOffset = function(offset, next_key) {
  var input_span = next_key.input - this.input;
  var output_span = next_key.output - this.output;
  return this.output + offset / input_span * output_span;
};

/**
 * Input for this key. This curve key will apply until the next key's input.
 * @type {number}
 */
o3d.CurveKey.prototype.__defineGetter__("input", function() {
  return this.input_;
});
o3d.CurveKey.prototype.__defineSetter__("input", function(new_input) {
  if (new_input != this.input_) {
    this.input_ = new_input;
    this.owner_.invalidateCache_();
  }
});

/**
 * Output corresponding to input.
 * @type {number}
 */
o3d.CurveKey.prototype.__defineGetter__("output", function() {
  return this.output_;
});
o3d.CurveKey.prototype.__defineSetter__("output", function(new_output) {
  if (new_output != this.output_) {
    this.output_ = new_output;
    this.owner_.invalidateCache_();
  }
});

/**
 * An CurveKey that holds its output (is not interpolated between this key
 * and the next.)
 *
 * Other discontinuous CurveKey classes must be derived from StepCurveKey.
 *
 * @constructor
 * @extends {o3d.CurveKey}
 */
o3d.StepCurveKey = function(owner) {
  o3d.CurveKey.call(this, owner);
  owner.num_step_keys_++;
};
o3d.inherit('StepCurveKey', 'CurveKey');

/**
 * Simple discontinuous implementation.
 * @param {number} offset  Ignored: constant output within a StepCurveKey
 * @param {o3d.CurveKey} next_key Ignored: discontinuous
 * @return {number} output
 */
o3d.StepCurveKey.prototype.getOutputAtOffset = function(offset, next_key) {
  return this.output;
};

/**
 * Specialized destroy method to update the num_step_keys_ of the owner_.
 */
o3d.StepCurveKey.prototype.destroy = function() {
  o3d.CurveKey.prototype.destroy.call(this);
  this.owner_.num_step_keys_--;
};

/**
 * An CurveKey that linearly interpolates between this key and the next key.
 *
 * @constructor
 * @extends {o3d.CurveKey}
 */
o3d.LinearCurveKey = function(owner) {
  o3d.CurveKey.call(this, owner);
};
o3d.inherit('LinearCurveKey', 'CurveKey');

/**
 * An CurveKey that uses a bezier curve for interpolation between this key
 * and the next.
 *
 * @constructor
 * @extends {o3d.CurveKey}
 */
o3d.BezierCurveKey = function(owner) {
  o3d.CurveKey.call(this, owner);

  /**
   * See input setter.
   * @private
   * @type {Array.<number>}
   */
  this.in_tangent_ = [0, 0];

  /**
   * See input setter.
   * @private
   * @type {Array.<number>}
   */
  this.out_tangent_ = [0, 0];
};
o3d.inherit('BezierCurveKey', 'CurveKey');

/**
 * Tangent for values approaching this key. Do not set elements in the array
 * directly as that will prevent calling invalidateCache_.
 * @type {Array.<number>}
 */
o3d.BezierCurveKey.prototype.__defineGetter__("inTangent", function() {
  return this.in_tangent_;
});
o3d.BezierCurveKey.prototype.__defineSetter__("inTangent", function(new_t) {
  if (new_t != this.in_tangent_) {
    this.in_tangent_ = new_t;
    this.owner_.invalidateCache_();
  }
});

/**
 * Tangent for values approaching the next key. Do not set elements in the array
 * directly as that will prevent calling invalidateCache_.
 * @type {Array.<number>}
 */
o3d.BezierCurveKey.prototype.__defineGetter__("outTangent", function() {
  return this.out_tangent_;
});
o3d.BezierCurveKey.prototype.__defineSetter__("outTangent", function(new_t) {
  if (new_t != this.out_tangent_) {
    this.out_tangent_ = new_t;
    this.owner_.invalidateCache_();
  }
});

/**
 * Uses iterative method to accurately pin-point the 't' of the Bezier
 * equation that corresponds to the current time.
 * @param {number} control_point_0_x  this.input
 * @param {number} control_point_1_x  this.outTangent
 * @param {number} control_point_2_x  next.inTangent
 * @param {number} control_point_3_x  next.input
 * @param {number} input Absolute input value relative to span
 * @param {number} initial_guess Starting point assuming mostly linear.
 * @private
 */
o3d.BezierCurveKey.findT_ = function(control_point_0_x,
                                    control_point_1_x,
                                    control_point_2_x,
                                    control_point_3_x,
                                    input,
                                    initial_guess) {
  var local_tolerance = 0.001;
  var high_t = 1.0;
  var low_t = 0.0;

  // TODO: Optimize here, start with a more intuitive value than 0.5
  //     (comment left over from original code)
  var mid_t = 0.5;
  if (initial_guess <= 0.1) {
    mid_t = 0.1;  // clamp to 10% or 90%, because if miss, the cost is
                   // too high.
  } else if (initial_guess >= 0.9) {
    mid_t = 0.9;
  } else {
    mid_t = initial_guess;
  }
  var once = true;
  while ((high_t-low_t) > local_tolerance) {
    if (once) {
      once = false;
    } else {
      mid_t = (high_t - low_t) / 2.0 + low_t;
    }
    var ti = 1.0 - mid_t;  // (1 - t)
    var calculated_time = control_point_0_x * ti * ti * ti +
                            3 * control_point_1_x * mid_t * ti * ti +
                            3 * control_point_2_x * mid_t * mid_t * ti +
                            control_point_3_x * mid_t * mid_t * mid_t;
    if (Math.abs(calculated_time - input) <= local_tolerance) {
      break;  // If we 'fall' very close, we like it and break.
    }
    if (calculated_time > input) {
      high_t = mid_t;
    } else {
      low_t = mid_t;
    }
  }
  return mid_t;
};

/**
 * Computes the value of the Bezier curve within the range from this.input
 * to next_key.input.
 * @param {number} offset  Offset within the key (function input - this.input)
 * @param {o3d.CurveKey} next_key The next key in the set, can not be null.
 * @return {number} return
 */
o3d.BezierCurveKey.prototype.getOutputAtOffset = function(offset, next_key) {
  var input_span = next_key.input - this.input;
  var output_span = next_key.output - this.output;
  var in_tangent;

  // We check bezier first because it's the most likely match for another
  // bezier key.
  if (next_key.inTangent) {
    in_tangent = next_key.inTangent;
  } else {
    in_tangent = [next_key.input - input_span / 3.0,
                  next_key.output - output_span / 3.0];
  }

  // Do a bezier calculation.
  var t = offset / input_span;
  t = o3d.BezierCurveKey.findT_(this.input,
                               this.outTangent[0],
                               in_tangent[0],
                               next_key.input,
                               this.input + offset,
                               t);
  var b = this.outTangent[1];
  var c = in_tangent[1];
  var ti = 1.0 - t;
  var br = 3.0;
  var cr = 3.0;
  return this.output * ti * ti * ti + br * b * ti * ti * t +
      cr * c * ti * t * t + next_key.output * t * t * t;
};

/**
 * A Curve stores a bunch of CurveKeys and given a value
 * representing an input point on a curve returns the output of the curve for
 * that input. Curve is data only. It is used by 1 or more
 * FunctionEval objects or by direct use from javascript.
 *
 * @constructor
 * @extends {o3d.Function}
 */
o3d.Curve = function() {
  o3d.Function.call(this, this.evaluate);

  /**
   * The behavior of the curve before the first key.
   * @see o3d.Curve.CONSTANT
   * @see o3d.Curve.LINEAR
   * @see o3d.Curve.CYCLE
   * @see o3d.Curve.CYCLE_RELATIVE
   * @see o3d.Curve.OSCILLATE
   * @type {o3d.Curve.Infinity}
   * @default CONSTANT
   */
  this.preInfinity = o3d.Curve.CONSTANT;

  /**
   * The behavior of the curve before the first key.
   * @see o3d.Curve.CONSTANT
   * @see o3d.Curve.LINEAR
   * @see o3d.Curve.CYCLE
   * @see o3d.Curve.CYCLE_RELATIVE
   * @see o3d.Curve.OSCILLATE
   * @type {o3d.Curve.Infinity}
   * @default CONSTANT
   */
  this.postInfinity = o3d.Curve.CONSTANT;

  /**
   * Whether or not a cache is used to speed up evaluation of this Curve.
   */
  this.useCache = true;

  /**
   * Data for sampleRate setter.
   * @type {number}
   * @private
   */
  this.sample_rate_ = o3d.Curve.kDefaultSampleRate;

  /**
   * The keys for this curve.
   *
   * This property is read-only.
   * @type {!Array.<!o3d.CurveKey>}
   */
  this.keys = [];

  /**
   * Keep track if a new key has been added which hasn't been sorted.
   * @type {boolean}
   * @private
   */
  this.sorted_ = true;

  /**
   * True if the curve needs to checks for discontinuity errors before the next
   * evauluation.
   * @see updateCurveInfo_
   * @type {boolean}
   * @private
   */
  this.check_discontinuity_ = false;

  /**
   * Keep track if any discontinuous (steps or gaps) keys are in the mix.
   * Call isDiscontinuous to access this value, which updates it if necessary.
   * @type {boolean}
   * @private
   */
  this.discontinuous_= false;

  /**
   * @type {number} Number of step keys--used to speed up updateCurveInfo_
   *     discontinuity check if it's non-zero.
   * @private
   */
  this.num_step_keys_ = 0;

};

o3d.inherit('Curve', 'Function');

/**
 * Constant representing the fastest possible sample period. More samples take
 * more computation initially and more memroy.
 */
o3d.Curve.kMinimumSampleRate = 1.0 / 240.0;

/**
 * By default, sample 30 times per curve key.
 */
o3d.Curve.kDefaultSampleRate = 1.0 / 30.0;

/**
 * Gets the sample rate for the cache.  By default Animation data is
 * cached so that using the animation is fast. To do this the keys that
 * represent the animation are sampled. The higher the frequency of the
 * samples the closer the cache will match the actual keys.
 * The default is 1/30 (30hz). You can set it anywhere from 1/240th (240hz) to
 * any larger value. Note: Setting the sample rate has the side effect of
 * invalidating the cache thereby causing it to get rebuilt.
 * Must be 1/240 or greater. Default = 1/30.
 *
 * @type {number}
 */
o3d.Curve.prototype.__defineGetter__("sampleRate", function() {
  return this.sample_rate_;
});

o3d.Curve.prototype.__defineSetter__("sampleRate", function(rate) {
  if (rate < o3d.Curve.kMinimumSampleRate) {
    rate = o3d.Curve.kMinimumSampleRate;
    this.gl.client.error_callback(
        "attempt to set sample rate to " + rate +
        " which is lower than the minimum of " + o3d.Curve.kMinimumSampleRate);
  } else if (rate != this.sample_rate_) {
    this.sample_rate_ = rate;
    this.invalidateCache_();
  }
});

/**
 * @type {number}
 */
o3d.Curve.Infinity = goog.typedef;

/**
 * Uses the output value of the first or last animation key.
 * @type {o3d.Curve.Infinity}
 */
o3d.Curve.CONSTANT = 0;

/**
 * Takes the distance between the closest animation key input value and the
 * evaluation time. Multiplies this distance against the instant slope at the
 * closest animation key and offsets the result with the closest animation key
 * output value.
 * @type {o3d.Curve.Infinity}
 */
o3d.Curve.LINEAR = 1;

/**
 * Cycles over the first and last keys using:
 *       input = (input - first) % (last - first) + first;
 * Note that in CYCLE mode you can never get the end output because a cycle
 * goes from start to end exclusive of end.
 * @type {o3d.Curve.Infinity}
 */
o3d.Curve.CYCLE = 2;

/**
 * Same as cycle except the offset of the entire cycle is added to each
 * consecutive cycle.
 * @type {o3d.Curve.Infinity}
 */
o3d.Curve.CYCLE_RELATIVE = 3;

/**
 * Ping Pongs between the first and last keys.
 * @type {o3d.Curve.Infinity}
 */
o3d.Curve.OSCILLATE = 4;

/**
 * Deserializes from the curve data given a RawData object.
 *
 * @param {!o3d.RawData} rawData contains curve data
 * @param {number} opt_offset is a byte offset from the start of raw_data
 * @param {number} opt_length is the byte length of the data to set
 * @return {boolean} True if operation was successful.
 *
 */
o3d.Curve.prototype.set = function(rawData, opt_offset, opt_length) {
  o3d.notImplemented();
};

/**
 * Creates a new key for this curve.
 * @param {string} keyType name of key class to create. Valid type names are:
 *     <li> 'StepCurveKey',
 *     <li> 'LinearCurveKey',
 *     <li> 'BezierCurveKey',
 * @return {!o3d.CurveKey} The created key.
 *
 */
o3d.Curve.prototype.createKey = function(keyType) {
  var newKey = new (o3d[keyType]) (this);
  this.keys.push(newKey);
  return newKey;
};

/**
 * Adds 1 or more LinearKeys to this Curve.
 *
 * Example:
 * <pre>
 * // Creates 2 keys.
 * // 1 key at 0 with an output of 10
 * // 1 key at 20 with an output of 30
 * curve.addLinearKeys([0,10,20,30]);
 * </pre>.
 *
 * @param {!Array.<number>} values Array of input, output pairs.
 *     Length must be a multiple of 2
 */
o3d.Curve.prototype.addLinearKeys = function(values) {
  var kNumLinearKeyValues = 2;
  if (values.length % kNumLinearKeyValues != 0) {
    this.gl.client.error_callback(
        "addLinearKeys: expected multiple of 2 values got "+values.size());
    return;
  }
  for (var i = 0; i < values.length; i += kNumLinearKeyValues) {
    var newKey = this.createKey("LinearCurveKey");
    newKey.input = values[i];
    newKey.output = values[i+1];
  }
  this.sorted_ = false;
};

/**
 * Adds 1 or more StepKeys to this Curve.
 *
 * Example:
 * <pre>
 * // Creates 2 keys.
 * // 1 key at 0 with an output of 10
 * // 1 key at 20 with an output of 30
 * curve.addStepKeys([0,10,20,30]);
 * </pre>.
 *
 * @param {!Array.<number>} values Array of input, output pairs.
 *     Length must be a multiple of 2
 */
o3d.Curve.prototype.addStepKeys = function(values) {
  var kNumStepKeyValues = 2;
  if (values.length % kNumStepKeyValues != 0) {
    this.gl.client.error_callback(
        "addStepKeys: expected multiple of 2 values got "+values.size());
    return;
  }
  for (var i = 0; i < values.length; i += kNumStepKeyValues) {
    var newKey = this.createKey("StepCurveKey");
    newKey.input = values[i];
    newKey.output = values[i+1];
  }
  this.sorted_ = false;
};

/**
 * Adds 1 or more BezierKeys to this Curve.
 *
 * Example:
 * <pre>
 * // Creates 2 keys.
 * // 1 key at 0 with an output of 10, in tangent of 1,9, out tangent 9,0.5
 * // 1 key at 20 with an output of 30, in tangent of 30, 3, out tangent 4, 28
 * curve.addBezierKeys([0,10,1,9,9,0.5,2,30,3,4,28]);
 * </pre>.
 *
 * @param {!Array.<number>} values Array of tuples of the form (input, output,
 *     inTangent[0], inTangent[1], outTangent[0], outTangent[1]).
 *     Length must be a multiple of 6.
 */
o3d.Curve.prototype.addBezierKeys = function(values) {
  var kNumBezierKeyValues = 6;
  if (values.length % kNumBezierKeyValues != 0) {
    this.gl.client.error_callback(
        "addBezierKeys: expected multiple of 6 values got "+values.size());
    return;
  }
  for (var i = 0; i < values.length; i += kNumBezierKeyValues) {
    var newKey = this.createKey("BezierCurveKey");
    newKey.input = values[i];
    newKey.output = values[i+1];
    newKey.inTangent[0] = values[i+2];
    newKey.inTangent[1] = values[i+3];
    newKey.outTangent[0] = values[i+4];
    newKey.outTangent[1] = values[i+5];
  }
  this.sorted_ = false;
};

/**
 * Force updating the cache or checking discontinuity.
 * @private
 */
o3d.Curve.prototype.invalidateCache_ = function() {
  this.check_valid_ = false;
  this.check_discontinuity_ = true;
};

/**
 * Returns whether or not the curve is discontinuous. A discontinuous curve
 * takes more time to evaluate.
 * @return {boolean} True if the curve is discontinuous.
 */
o3d.Curve.prototype.isDiscontinuous = function() {
  this.updateCurveInfo_();
  return this.discontinuous_;
};

/**
 * Comparator to allow sorting by keys by their input value.
 * @param {o3d.CurveKey} a First input to compare.
 * @param {o3d.CurveKey} b Second input to compare.
 * @return {number} positive, zero, or negative (see Array.sort)
 */
o3d.Curve.compareInputs_ = function(a, b) {
  return a.input - b.input;
};

/**
 * Sorts keys (if sorted_ is false) and updates discontinuous_
 * (if check_discontinuity_ is true).
 * Called automatically when necessary in evaluate and isDiscontinuous.
 * @private
 */
o3d.Curve.prototype.updateCurveInfo_ = function() {
  if (!this.sorted_) {
    // resort keys
    this.keys.sort(o3d.Curve.compareInputs_);
    this.sorted_ = true;
    this.invalidateCache_();
  }
  if (this.check_discontinuity_) {
    // Mark the curve as discontinuous if any 2 keys share the same input and
    // if their outputs are different.
    this.check_discontinuity_ = false;
    var keys_size = this.keys.length;
    this.discontinuous_ = (this.num_step_keys_ > 0 &&
                           this.num_step_keys_ != keys_size);
    if (!this.discontinuous_ && keys_size > 1) {
      for (var ii = 0; ii < keys_size - 1; ++ii) {
        if (this.keys[ii].input == this.keys[ii + 1].input &&
            this.keys[ii].output != this.keys[ii + 1].output) {
          this.discontinuous_ = true;
          break;
        }
      }
    }
  }
};

/**
 * @param {number} input  Guaranteed to be between the first and last key.
 * @param {object} context  Generic cache to speed up adjacent computations.
 * @return {number} Final output value
 * @private
 */
o3d.Curve.prototype.getOutputInSpan_ = function(input, context) {
  var keys = this.keys;
  var keys_size = keys.length;
  if (input < keys[0].input) {
    this.gl.client.error_callback(
      "Curve.getOutputInSpan_: input is lower than any key");
    return 0;
  }

  if (input >= keys[keys_size-1].input) {
    return keys[keys_size-1].output;
  }

  // use the keys directly.
  var start = 0;
  var end = keys_size;
  var key_index;
  var found = false;

  var kKeysToSearch = 3;

  // See if the context already has a index to the correct key.
  if (context) {
    key_index = context.curve_last_key_index_;
    // is that index in range.
    if (key_index < end - 1) {
      // Are we between these keys.
      if (keys[key_index].input <= input &&
          keys[key_index + 1].input > input) {
        // Yes!
        found = true;
      } else {
        // No, so check which way we need to go.
        if (input > keys[key_index].input) {
          // search forward a few keys. If it's not within a few keys give up.
          var check_end = key_index + kKeysToSearch;
          if (check_end > end) {
            check_end = end;
          }
          for (++key_index; key_index < check_end; ++key_index) {
            if (keys[key_index].input <= input &&
                keys[key_index + 1].input > input) {
              // Yes!
              found = true;
              break;
            }
          }
        } else if (key_index > 0) {
          // search backward a few keys. If it's not within a few keys give up.
          var check_end = key_index - kKeysToSearch;
          if (check_end < 0) {
            check_end = 0;
          }
          for (--key_index; key_index >= check_end; --key_index) {
            if (keys[key_index].input <= input &&
                keys[key_index + 1].input > input) {
              // Yes!
              found = true;
              break;
            }
          }
        }
      }
    }
  }

  if (!found) {
    // TODO: If we assume the most common case is sampled keys and
    // constant intervals we can make a quick guess where that key is.

    // Find the current the keys that cover our input.
    while (start <= end) {
      var mid = Math.floor((start + end)/2);
      if (input > keys[mid].input) {
        start = mid + 1;
      } else {
        if (mid == 0) {
          break;
        }
        end = mid - 1;
      }
    }

    end = keys_size;
    while (start < end) {
      if (keys[start].input > input) {
        break;
      }
      ++start;
    }
    if (start <= 0 || start >= end) {
          this.gl.client.error_callback(
            "Curve.getOutputInSpan_: start is outside range.");
    }

    key_index = start - 1;
  }

  var key = keys[key_index];
  if (context) {
    context.curve_last_key_index_ = key_index;
  }
  if (key_index+1 >= keys_size || !keys[key_index+1]) {
    this.gl.client.error_callback(
        "Curve.getOutputInSpan_: next key is null: index is "+key_index+
        "; size is "+keys_size);
    return key.output;
  } else {
    return key.getOutputAtOffset(input - key.input, keys[key_index+1]);
  }
};

/**
 * Evaluates a point on this bezier curve corresponding to input.
 *
 * @param {number} input Input value to evaluate.
 * @param {number} context Context of the last evaluation.
 * @return {number} output value
 */
o3d.Curve.prototype.evaluate = function(input, context) {
  var keys = this.keys;
  var keys_size = keys.length;

  if (keys_size == 0) {
    return 0.0;
  }

  if (keys_size == 1) {
    return keys[0].output;
  }

  this.updateCurveInfo_();

  var start_input = keys[0].input;
  var end_input = keys[keys_size-1].input;
  var input_span = end_input - start_input;
  var start_output = keys[0].output;
  var end_output = keys[keys_size-1].output;
  var output_delta = end_output - start_output;

  var kEpsilon = 0.00001;

  var output_offset = 0.0;
  // check for pre-infinity
  if (input < start_input) {
    if (input_span <= 0.0) {
      return start_output;
    }
    var pre_infinity_offset = start_input - input;
    switch (this.preInfinity) {
      case o3d.Curve.CONSTANT:
        return start_output;
      case o3d.Curve.LINEAR: {
        var second_key = keys[1];
        var input_delta = second_key.input - start_input;
        if (input_delta > kEpsilon) {
          return start_output - pre_infinity_offset *
              (second_key.output - start_output) / input_delta;
        } else {
          return start_output;
        }
      }
      case o3d.Curve.CYCLE: {
        var cycle_count = Math.ceil(pre_infinity_offset / input_span);
        input += cycle_count * input_span;
        input = start_input + (input - start_input) % input_span;
        break;
      }
      case o3d.Curve.CYCLE_RELATIVE: {
        var cycle_count = Math.ceil(pre_infinity_offset / input_span);
        input += cycle_count * input_span;
        input = start_input + (input - start_input) % input_span;
        output_offset -= cycle_count * output_delta;
        break;
      }
      case o3d.Curve.OSCILLATE: {
        var cycle_count = Math.ceil(pre_infinity_offset / (2.0 * input_span));
        input += cycle_count * 2.0 * input_span;
        input = end_input - Math.abs(input - end_input);
        break;
      }
      default:
        this.gl.client.error_callback(
            "Curve: invalid value "+this.preInfinity+"for pre-infinity");
        return start_output;
    }
  } else if (input >= end_input) {
    // check for post-infinity
    if (input_span <= 0.0) {
      return end_output;
    }
    var post_infinity_offset = input - end_input;
    switch (this.postInfinity) {
      case o3d.Curve.CONSTANT:
        return end_output;
      case o3d.Curve.LINEAR: {
        var next_to_last_key = keys[keys_size - 2];
        var input_delta = end_input - next_to_last_key.input;
        if (input_delta > kEpsilon) {
          return end_output + post_infinity_offset *
              (end_output - next_to_last_key.output) /
              input_delta;
        } else {
          return end_output;
        }
      }
      case o3d.Curve.CYCLE: {
        var cycle_count = Math.ceil(post_infinity_offset / input_span);
        input -= cycle_count * input_span;
        input = start_input + (input - start_input) % input_span;
        break;
      }
      case o3d.Curve.CYCLE_RELATIVE: {
        var cycle_count = Math.floor((input - start_input) / input_span);
        input -= cycle_count * input_span;
        input = start_input + (input - start_input) % input_span;
        output_offset += cycle_count * output_delta;
        break;
      }
      case o3d.Curve.OSCILLATE: {
        var cycle_count = Math.ceil(post_infinity_offset / (2.0 *
                                                          input_span));
        input -= cycle_count * 2.0 * input_span;
        input = start_input + Math.abs(input - start_input);
        break;
      }
      default:
        this.gl.client.error_callback(
            "Curve.invalid value "+this.postInfinity+"for post-infinity");
        return end_output;
    }
  }

  // At this point input should be between start_input and end_input
  // inclusive.

  // If we are at end_input then just return end_output since we can't
  // interpolate end_input to anything past it.
  if (input >= end_input) {
    return end_output + output_offset;
  }

  // TODO(pathorn): Implement curve cache in javascript.
  // See 'void Curve::CreateCache' in o3d/core/cross/curve.cc

  return this.getOutputInSpan_(input, context) + output_offset;
};
