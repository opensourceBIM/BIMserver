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
 * Acts like ParamFloat, but has an unsettable value which always calls
 * this.owner_.updateOutputs to find the updated output value.
 * @constructor
 * @extends {o3d.ParamFloat}
 */
o3d.ParamFloatOutput = function() {
  o3d.ParamFloat.call(this);
};
o3d.inherit('ParamFloatOutput', 'ParamFloat');
o3d.ParamFloatOutput.prototype.__defineGetter__("value",
    function() {
      return this.owner_.updateOutputs();
    }
);
o3d.ParamFloatOutput.prototype.__defineSetter__("value",
    function(value) {}
);

/**
 * Acts like ParamFloat2, but has an unsettable value which always calls
 * this.owner_.updateOutputs to find the updated output value.
 * @constructor
 * @extends {o3d.ParamFloat2}
 */
o3d.ParamFloat2Output = function() {
  o3d.ParamFloat2.call(this);
};
o3d.inherit('ParamFloat2Output', 'ParamFloat2');
o3d.ParamFloat2Output.prototype.__defineGetter__("value",
    function() {
      return this.owner_.updateOutputs();
    }
);
o3d.ParamFloat2Output.prototype.__defineSetter__("value",
    function(value) {}
);

/**
 * Acts like ParamFloat3, but has an unsettable value which always calls
 * this.owner_.updateOutputs to find the updated output value.
 * @constructor
 * @extends {o3d.ParamFloat3}
 */
o3d.ParamFloat3Output = function() {
  o3d.ParamFloat3.call(this);
};
o3d.inherit('ParamFloat3Output', 'ParamFloat3');
o3d.ParamFloat3Output.prototype.__defineGetter__("value",
    function() {
      return this.owner_.updateOutputs();
    }
);
o3d.ParamFloat3Output.prototype.__defineSetter__("value",
    function(value) {}
);

/**
 * Acts like ParamFloat4, but has an unsettable value which always calls
 * this.owner_.updateOutputs to find the updated output value.
 * @constructor
 * @extends {o3d.ParamFloat4}
 */
o3d.ParamFloat4Output = function() {
  o3d.ParamFloat4.call(this);
};
o3d.inherit('ParamFloat4Output', 'ParamFloat4');
o3d.ParamFloat4Output.prototype.__defineGetter__("value",
    function() {
      return this.owner_.updateOutputs();
    }
);
o3d.ParamFloat4Output.prototype.__defineSetter__("value",
    function(value) {}
);

/**
 * Acts like ParamMatrix4, but has an unsettable value which always calls
 * this.owner_.updateOutputs to find the updated output value.
 * @constructor
 * @extends {o3d.ParamMatrix4}
 */
o3d.ParamMatrix4Output = function() {
  o3d.ParamMatrix4.call(this);
};
o3d.inherit('ParamMatrix4Output', 'ParamMatrix4');
o3d.ParamMatrix4Output.prototype.__defineGetter__("value",
    function() {
      return this.owner_.updateOutputs();
    }
);
o3d.ParamMatrix4Output.prototype.__defineSetter__("value",
    function(value) {}
);

/**
 * A Param operation that takes 2 floats to produce a float2.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.ParamOp2FloatsToFloat2 = function() {
  o3d.ParamObject.call(this);
  this.last_output_value_ = [0, 0];
};
o3d.inherit('ParamOp2FloatsToFloat2', 'ParamObject');

(function(){
  for (var i = 0; i < 2; i++) {
    o3d.ParamObject.setUpO3DParam_(
        o3d.ParamOp2FloatsToFloat2, "input"+i, "ParamFloat");
  }
  o3d.ParamObject.setUpO3DParam_(
      o3d.ParamOp2FloatsToFloat2, "output", "ParamMatrix4Output");
})();

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * @return {!Array.<number>} 2-element array equal to [input0,input1]
 */
o3d.ParamOp2FloatsToFloat2.prototype.updateOutputs = function() {
  this.last_output_value_[0] = this.getParam("input0").value;
  this.last_output_value_[1] = this.getParam("input1").value;
  return this.last_output_value_;
};

/**
 * A Param operation that takes 3 floats to produce a float3.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.ParamOp3FloatsToFloat3 = function() {
  o3d.ParamObject.call(this);
  this.last_output_value_ = [0, 0, 0];
};
o3d.inherit('ParamOp3FloatsToFloat3', 'ParamObject');

(function(){
  for (var i = 0; i < 3; i++) {
    o3d.ParamObject.setUpO3DParam_(
        o3d.ParamOp3FloatsToFloat3, "input"+i, "ParamFloat");
  }
  o3d.ParamObject.setUpO3DParam_(
      o3d.ParamOp3FloatsToFloat3, "output", "ParamMatrix4Output");
})();

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * @return {!Array.<number>} 3-element array equal to [input0,input1,input2]
 */
o3d.ParamOp3FloatsToFloat3.prototype.updateOutputs = function() {
  this.last_output_value_[0] = this.getParam("input0").value;
  this.last_output_value_[1] = this.getParam("input1").value;
  this.last_output_value_[2] = this.getParam("input2").value;
  return this.last_output_value_;
};

/**
 * A Param operation that takes 4 floats to produce a float4.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.ParamOp4FloatsToFloat4 = function() {
  o3d.ParamObject.call(this);
  this.last_output_value_ = [0, 0, 0, 0];
};
o3d.inherit('ParamOp4FloatsToFloat4', 'ParamObject');

(function(){
  for (var i = 0; i < 4; i++) {
    o3d.ParamObject.setUpO3DParam_(
        o3d.ParamOp4FloatsToFloat4, "input"+i, "ParamFloat");
  }
  o3d.ParamObject.setUpO3DParam_(
      o3d.ParamOp4FloatsToFloat4, "output", "ParamMatrix4Output");
})();

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * @return {!Array.<number>} 4-element array equal to
 *     [input0,input1,input2,input3]
 */
o3d.ParamOp4FloatsToFloat4.prototype.updateOutputs = function() {
  this.last_output_value_[0] = this.getParam("input0").value;
  this.last_output_value_[1] = this.getParam("input1").value;
  this.last_output_value_[2] = this.getParam("input2").value;
  this.last_output_value_[3] = this.getParam("input3").value;
  return this.last_output_value_;
};

/**
 * A Param operation that takes 16 floats to produce a 4-by-4 matrix.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.ParamOp16FloatsToMatrix4 = function() {
  o3d.ParamObject.call(this);
  this.last_output_value_ =
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];
};
o3d.inherit('ParamOp16FloatsToMatrix4', 'ParamObject');

(function(){
  for (var i = 0; i < 16; i++) {
    o3d.ParamObject.setUpO3DParam_(
        o3d.ParamOp16FloatsToMatrix4, "input"+i, "ParamFloat");
  }
  o3d.ParamObject.setUpO3DParam_(
      o3d.ParamOp16FloatsToMatrix4, "output", "ParamMatrix4Output");
})();

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * @return {!Array.<!Array.<number>>} 4x4 array equal to
 *     [[i0,i1,i2,i3],[i4,i5,i6,i7],[i8,i9,i10,i11],[i12,i13,i14,i15]]
 */
o3d.ParamOp16FloatsToMatrix4.prototype.updateOutputs = function() {
  for (var i = 0; i < 16; i++) {
    this.last_output_value_[Math.floor(i/4)][i%4] =
        this.getParam("input"+i).value;
  }
  return this.last_output_value_;
};

/**
 * A Param operation that takes 9 floats to produce a 4-by-4 matrix.
 * The 9 floats encode a translation vector, angles of rotation around
 * the x, y, and z axes, and three scaling factors. The resulting
 * transformation scales first, then then rotates around the z-axis,
 * then the y-axis, then the x-axis, then translates.
 * @param {string} name Tne name of the parameter.
 * @param {string} className The param class name.
 * @param {number} numElements The number of Elements if the param is an array.
 * @param {string} sasClassName The sas class name if the param is an sas type.
 * @param {string} semantic The relevant semantic.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.TRSToMatrix4 = function() {
  o3d.ParamObject.call(this);

  this.rotateX = 0;
  this.rotateY = 0;
  this.rotateZ = 0;

  this.translateX = 0;
  this.translateY = 0;
  this.translateZ = 0;

  this.scaleX = 1;
  this.scaleY = 1;
  this.scaleZ = 1;

  this.last_output_value_ =
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];
};
o3d.inherit('TRSToMatrix4', 'ParamObject');

(function(){
  var proplist = ["rotateX", "rotateY", "rotateZ",
                  "translateX", "translateY", "translateZ",
                  "scaleX", "scaleY", "scaleZ"];
  for (var i = 0; i < proplist.length; i++) {
    o3d.ParamObject.setUpO3DParam_(o3d.TRSToMatrix4, proplist[i], "ParamFloat");
  }
  o3d.ParamObject.setUpO3DParam_(
      o3d.TRSToMatrix4, "output", "ParamMatrix4Output");
})();

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * @return {!Array.<!Array.<number>>} Matrix4 equal to applying the operations
 *     in the order Translate * Rotate * Scale.
 */
o3d.TRSToMatrix4.prototype.updateOutputs = function () {
  var ret = this.last_output_value_;
  var rX = this.rotateX;
  var rY = this.rotateY;
  var rZ = this.rotateZ;
  var sX = this.scaleX;
  var sY = this.scaleY;
  var sZ = this.scaleZ;
  var sinX = Math.sin(rX);
  var cosX = Math.cos(rX);
  var sinY = Math.sin(rY);
  var cosY = Math.cos(rY);
  var sinZ = Math.sin(rZ);
  var cosZ = Math.cos(rZ);
  var cosZSinY = cosZ * sinY;
  var sinZSinY = sinZ * sinY;

  ret[0].splice(0, 4, cosZ * cosY * sX,
                      sinZ * cosY * sX,
                      -sinY * sX,
                      0);
  ret[1].splice(0, 4, (cosZSinY * sinX - sinZ * cosX) * sY,
                      (sinZSinY * sinX + cosZ * cosX) * sY,
                      cosY * sinX * sY,
                      0);
  ret[2].splice(0, 4, (cosZSinY * cosX + sinZ * sinX) * sZ,
                      (sinZSinY * cosX - cosZ * sinX) * sZ,
                      cosY * cosX * sZ,
                      0);
  ret[3].splice(0, 4, this.translateX,
                      this.translateY,
                      this.translateZ,
                      1);
  return ret;
};

/**
 * A Param operation that takes an input matrix and a local matrix
 * to produce an output matrix.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.Matrix4Composition = function() {
  o3d.ParamObject.call(this);
  this.last_output_value_ =
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];
};
o3d.inherit('Matrix4Composition', 'ParamObject');

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4Composition, "inputMatrix", "ParamMatrix4");

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4Composition, "localMatrix", "ParamMatrix4");

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4Composition, "outputMatrix", "ParamMatrix4Output");

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * @return {!Array.<!Array.<number>>} 4x4 array equal to
 *     inputMatrix * localMatrix
 */
o3d.Matrix4Composition.prototype.updateOutputs = function() {
  var input = this.getParam("inputMatrix").value;
  var local = this.getParam("localMatrix").value;
  o3d.Transform.compose(input, local, this.last_output_value_);
  return this.last_output_value_;
};


/**
 * A Param operation that takes an input matrix, a float3 axis and an angle
 * to produce an output matrix.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.Matrix4AxisRotation = function() {
  o3d.ParamObject.call(this);
  this.last_output_value_ =
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];
};
o3d.inherit('Matrix4AxisRotation', 'ParamObject');

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4AxisRotation, "inputMatrix", "ParamMatrix4");

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4AxisRotation, "axis", "ParamFloat3");

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4AxisRotation, "angle", "ParamFloat");

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4AxisRotation, "outputMatrix", "ParamMatrix4Output");

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * @return {!Array.<!Array.<number>>} 4x4 array from rotating inputMatrix around
 *     axis by angle.
 */
o3d.Matrix4AxisRotation.prototype.updateOutputs = function() {
  var input = this.getParam("inputMatrix").value;
  var axis = this.getParam("axis").value;
  var angle = this.getParam("angle").value;
  o3d.Transform.axisRotateMatrix(input, axis, angle, this.last_output_value_);
  return this.last_output_value_;
};


/**
 * A Param operation that takes an input matrix and a float3 scale
 * to produce an output matrix.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.Matrix4Scale = function() {
  o3d.ParamObject.call(this);
  this.last_output_value_ =
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];
};
o3d.inherit('Matrix4Scale', 'ParamObject');

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4Scale, "inputMatrix", "ParamMatrix4");

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4Scale, "scale", "ParamFloat3");

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4Scale, "outputMatrix", "ParamMatrix4Output");

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * @return {!Array.<!Array.<number>>} 4x4 array from scaling inputMatrix by
 *      scale.
 */
o3d.Matrix4Scale.prototype.updateOutputs = function() {
  var m = this.getParam("inputMatrix").value;
  var ret = this.last_output_value_;
  var v = this.getParam("scale").value;

  var v0 = v[0];
  var v1 = v[1];
  var v2 = v[2];

  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];

  ret[0].splice(0, 4, v0 * m0[0], v0 * m0[1], v0 * m0[2], v0 * m0[3]);
  ret[1].splice(0, 4, v1 * m1[0], v1 * m1[1], v1 * m1[2], v1 * m1[3]);
  ret[2].splice(0, 4, v2 * m2[0], v2 * m2[1], v2 * m2[2], v2 * m2[3]);
  ret[3] = m3.slice(0);
  return ret;
};


/**
 * A Param operation that takes an input matrix, and a translation
 * to produce an output matrix.
 * @constructor
 * @extends {o3d.ParamObject}
 */
o3d.Matrix4Translation = function() {
  o3d.ParamObject.call(this);
  this.last_output_value_ =
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];
};
o3d.inherit('Matrix4Translation', 'ParamObject');

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4Translation, "inputMatrix", "ParamMatrix4");

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4Translation, "translation", "ParamFloat3");

o3d.ParamObject.setUpO3DParam_(
    o3d.Matrix4Translation, "outputMatrix", "ParamMatrix4Output");

/**
 * Called by o3d.Param*Output whenever its value gets read.
 * @return {!Array.<!Array.<number>>} 4x4 array from translating inputMatrix
 *     by translation.
 */
o3d.Matrix4Translation.prototype.updateOutputs = function() {
  var m = this.getParam("inputMatrix").value;
  var ret = this.last_output_value_;
  var v = this.getParam("translation").value;

  var v0 = v[0];
  var v1 = v[1];
  var v2 = v[2];

  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];

  ret[0] = m0.slice(0);
  ret[1] = m1.slice(0);
  ret[2] = m2.slice(0);
  ret[3].splice(0, 4, m0[0] * v0 + m1[0] * v1 + m2[0] * v2 + m3[0],
                      m0[1] * v0 + m1[1] * v1 + m2[1] * v2 + m3[1],
                      m0[2] * v0 + m1[2] * v1 + m2[2] * v2 + m3[2],
                      m0[3] * v0 + m1[3] * v1 + m2[3] * v2 + m3[3]);
  return ret;
};


