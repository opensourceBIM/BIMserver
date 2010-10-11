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
 * The Transform defines parent child relationship and a localMatrix..
 * A Transform can have one or no parents and
 * an arbitrary number of children.
 *
 * @param {o3d.math.Matrix4} opt_localMatrix The local matrix for this
 *     transform.
 * @param {o3d.math.Matrix4} opt_worldMatrix ParamMatrix4 The world matrix of
 *     this transform.
 * @param {boolean} opt_visible Whether or not this transform and all its
 *     children are visible.
 * @param {o3d.BoundingBox} opt_boundingBox ParamBoundingBox The bounding box
 *     for this transform and all its children.
 * @param {boolean} opt_cull ParamBoolean Whether or not to attempt to
 *    cull this transform and all its children based on whether or not its
 *    bounding box is in the view frustum.
 * @constructor
 */
o3d.Transform =
    function(opt_localMatrix, opt_worldMatrix, opt_visible, opt_boundingBox,
             opt_cull) {
  o3d.ParamObject.call(this);

  /**
   * Local transformation matrix.
   * Default = Identity.
   */
  this.localMatrix = opt_localMatrix ||
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];

  /**
   * World (model) matrix as it was last computed.
   */
  this.worldMatrix = opt_worldMatrix ||
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];

  /**
   * Sets the parent of the transform by re-parenting the transform under
   * parent. Setting parent to null removes the transform and the
   * entire subtree below it from the transform graph.
   * If the operation would create a cycle it fails.
   */
  this.parent = null;

  /**
   * The Visibility for this transform.
   * Default = true.
   */
  this.visible = opt_visible || true;

  /**
   * The BoundingBox for this Transform. If culling is on this
   * bounding box will be tested against the view frustum of any draw
   * context used to with this Transform.
   * @type {!o3d.BoundingBox}
   */
  this.boundingBox = opt_boundingBox ||
      new o3d.BoundingBox([-1, -1, -1], [1, 1, 1]);

  /**
   * The cull setting for this transform. If true this Transform will
   * be culled by having its bounding box compared to the view frustum
   * of any draw context it is used with.
   * Default = false.
   */
  this.cull = opt_cull || false;

  /**
   * The immediate children of this Transform.
   *
   * Each access to this field gets the entire list, so it is best to get it
   * just once. For example:
   *
   * var children = transform.children;
   * for (var i = 0; i < children.length; i++) {
   *   var child = children[i];
   * }
   *
   * Note that modifications to this array [e.g. additions to it] will
   * not affect the underlying Transform, while modifications to the
   * members of the array will affect them.
   */
  this.children = [];

  /**
   * Gets the shapes owned by this transform.
   *
   * Each access to this field gets the entire list so it is best to get it
   * just once. For example:
   *
   * var shapes = transform.shapes;
   * for (var i = 0; i < shapes.length; i++) {
   *   var shape = shapes[i];
   * }
   *
   *
   * Note that modifications to this array [e.g. additions to it] will
   * not affect the underlying Transform, while modifications to the
   * members of the array will affect them.
   */
  this.shapes = [];
};
o3d.inherit('Transform', 'ParamObject');

o3d.ParamObject.setUpO3DParam_(o3d.Transform, 'visible', 'ParamBoolean');
// TODO(petersont): need to better understand and possibly implement
// the semantics of SlaveParamMatrix4.
o3d.ParamObject.setUpO3DParam_(o3d.Transform, 'worldMatrix', 'ParamMatrix4');
o3d.ParamObject.setUpO3DParam_(o3d.Transform, 'localMatrix', 'ParamMatrix4');
o3d.ParamObject.setUpO3DParam_(o3d.Transform, 'cull', 'ParamBoolean');
o3d.ParamObject.setUpO3DParam_(o3d.Transform,
                               'boundingBox', 'ParamBoundingBox');


o3d.Transform.prototype.__defineSetter__('parent',
    function(p) {
      if (this.parent_ != null) {
        o3d.removeFromArray(this.parent_.children, this);
      }
      this.parent_ = p;
      if (p) {
        p.addChild(this);
      }
    }
);

o3d.Transform.prototype.__defineGetter__('parent',
    function(p) {
      return this.parent_;
    }
);

/**
 * Adds a child transform.
 * @param {o3d.Transform} The new child.
 */
o3d.Transform.prototype.addChild = function(child) {
  this.children.push(child);
};


/**
 * Returns all the transforms under this transform including this one.
 *
 * Note that modifications to this array [e.g. additions to it] will not affect
 * the underlying Transform, while modifications to the members of the array
 * will affect them.
 *
 *  An array containing the transforms of the subtree.
 */
o3d.Transform.prototype.getTransformsInTree =
    function() {
  var result = [];
  o3d.Transform.getTransformInTreeRecursive_(this, result);
  return result;
};


/**
 * Recursive helper function for getTransformInTree.
 * @private
 */
o3d.Transform.getTransformInTreeRecursive_ =
    function(treeRoot, children) {
  children.push(treeRoot);
  var childrenArray = treeRoot.children;
  for (var ii = 0; ii < childrenArray.length; ++ii) {
    o3d.Transform.getTransformInTreeRecursive_(childrenArray[ii], children);
  }
};


/**
 * Searches for transforms that match the given name in the hierarchy under and
 * including this transform. Since there can be more than one transform with a
 * given name, results are returned in an array.
 *
 * Note that modifications to this array [e.g. additions to it] will not affect
 * the underlying Transform, while modifications to the members of the array
 * will affect them.
 *
 * @param {string} name Transform name to look for.
 * @return {Array.<o3d.Transform>}  An array containing the transforms of the
 *     under and including this transform matching the given name.
 */
o3d.Transform.prototype.getTransformsByNameInTree =
    function(name) {
  o3d.notImplemented();
};

/**
 * Evaluates and returns the current world matrix.
 *
 *  The updated world matrix.
 */
o3d.Transform.prototype.getUpdatedWorldMatrix =
    function() {
  var parentWorldMatrix;
  if (!this.parent) {
    parentWorldMatrix =
        [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];
  } else {
    parentWorldMatrix = this.parent.getUpdatedWorldMatrix();
  }
  o3d.Transform.compose(parentWorldMatrix, this.localMatrix, this.worldMatrix);
  return this.worldMatrix;
};


/**
 * Adds a shape do this transform.
 * @param {o3d.Shape} shape Shape to add.
 */
o3d.Transform.prototype.addShape =
    function(shape) {
  this.shapes.push(shape);
};


/**
 * Removes a shape from this transform.
 * @param {o3d.Shape} shape Shape to remove.
 * @return {boolean}  true if successful, false if shape was not in
 *     this transform.
 */
o3d.Transform.prototype.removeShape =
    function(shape) {
  o3d.removeFromArray(this.shapes, shape);
};


/**
 * Walks the tree of transforms starting with this transform and creates
 * draw elements. If an Element already has a DrawElement that uses material a
 * new DrawElement will not be created.
 * @param {o3d.Pack} pack Pack used to manage created elements.
 * @param {o3d.Material} material Material to use for each element. If you
 *     pass null, it will use the material on the element to which a draw
 *     element is being added. In other words, a DrawElement will use the
 *     material of the corresponding Element if material is null. This allows
 *     you to easily setup the default (just draw as is) by passing null or
 *     setup a shadow pass by passing in a shadow material.
 */
o3d.Transform.prototype.createDrawElements =
    function(pack, material) {
  var children = this.children;
  var shapes = this.shapes;

  for (var i = 0; i < shapes.length; ++i) {
    shapes[i].createDrawElements(pack, material);
  }

  for (var i = 0; i < children.length; ++i) {
    children[i].createDrawElements(pack, material);
  }
};


/**
 * Sets the local matrix of this transform to the identity matrix.
 */
o3d.Transform.prototype.identity = function() {
  var m = this.localMatrix;
  for (var i = 0; i < 4; ++i) {
    for (var j = 0; j < 4; ++j) {
      m[i][j] = i==j ? 1 : 0;
    }
  }
};


/*
 * Utility function to copose a matrix with another matrix.
 * Precomposes b with a, changing a, or if the target matrix if
 * one is provided.
 *
 * @param {!Array.<!Array.<number>>} a
 * @param {!Array.<!Array.<number>>} b
 * @param {!Array.<!Array.<number>>} opt_target
 */
o3d.Transform.compose = function(a, b, opt_target) {
  var t = opt_target || a;
  var a0 = a[0];
  var a1 = a[1];
  var a2 = a[2];
  var a3 = a[3];
  var b0 = b[0];
  var b1 = b[1];
  var b2 = b[2];
  var b3 = b[3];
  var a00 = a0[0];
  var a01 = a0[1];
  var a02 = a0[2];
  var a03 = a0[3];
  var a10 = a1[0];
  var a11 = a1[1];
  var a12 = a1[2];
  var a13 = a1[3];
  var a20 = a2[0];
  var a21 = a2[1];
  var a22 = a2[2];
  var a23 = a2[3];
  var a30 = a3[0];
  var a31 = a3[1];
  var a32 = a3[2];
  var a33 = a3[3];
  var b00 = b0[0];
  var b01 = b0[1];
  var b02 = b0[2];
  var b03 = b0[3];
  var b10 = b1[0];
  var b11 = b1[1];
  var b12 = b1[2];
  var b13 = b1[3];
  var b20 = b2[0];
  var b21 = b2[1];
  var b22 = b2[2];
  var b23 = b2[3];
  var b30 = b3[0];
  var b31 = b3[1];
  var b32 = b3[2];
  var b33 = b3[3];
  t[0].splice(0, 4, a00 * b00 + a10 * b01 + a20 * b02 + a30 * b03,
                    a01 * b00 + a11 * b01 + a21 * b02 + a31 * b03,
                    a02 * b00 + a12 * b01 + a22 * b02 + a32 * b03,
                    a03 * b00 + a13 * b01 + a23 * b02 + a33 * b03);
  t[1].splice(0, 4, a00 * b10 + a10 * b11 + a20 * b12 + a30 * b13,
                    a01 * b10 + a11 * b11 + a21 * b12 + a31 * b13,
                    a02 * b10 + a12 * b11 + a22 * b12 + a32 * b13,
                    a03 * b10 + a13 * b11 + a23 * b12 + a33 * b13);
  t[2].splice(0, 4, a00 * b20 + a10 * b21 + a20 * b22 + a30 * b23,
                    a01 * b20 + a11 * b21 + a21 * b22 + a31 * b23,
                    a02 * b20 + a12 * b21 + a22 * b22 + a32 * b23,
                    a03 * b20 + a13 * b21 + a23 * b22 + a33 * b23);
  t[3].splice(0, 4, a00 * b30 + a10 * b31 + a20 * b32 + a30 * b33,
                    a01 * b30 + a11 * b31 + a21 * b32 + a31 * b33,
                    a02 * b30 + a12 * b31 + a22 * b32 + a32 * b33,
                    a03 * b30 + a13 * b31 + a23 * b32 + a33 * b33);
};


/**
 * Tests whether two matrices are either equal in the sense that they
 * refer to the same memory, or equal in the sense that they have equal
 * entries.
 *
 * @param {!Array.<!Array.<number>>} a A matrix.
 * @param {!Array.<!Array.<number>>} b Another matrix.
 * @return {boolean} Whether they are equal.
 */
o3d.Transform.matricesEqual = function(a, b) {
  if (a==b) {
    return true;
  }
  for (var i = 0; i < 4; ++i) {
    for (var j = 0; j < 4; ++j) {
      if (a[i][j] != b[i][j]) {
        return false;
      }
    }
  }
  return true;
};


/**
 * Computes the transpose of the matrix a in place if no target is provided.
 * Or if a target is provided, turns the target into the transpose of a.
 *
 * @param {!Array.<!Array.<number>>} m A matrix.
 * @param {Array.<!Array.<number>>} opt_target
 *     The matrix to become the transpose of m.
 */
o3d.Transform.transpose = function(m, opt_target) {
  var t = opt_target || m;
  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];
  var m00 = m0[0];
  var m01 = m0[1];
  var m02 = m0[2];
  var m03 = m0[3];
  var m10 = m1[0];
  var m11 = m1[1];
  var m12 = m1[2];
  var m13 = m1[3];
  var m20 = m2[0];
  var m21 = m2[1];
  var m22 = m2[2];
  var m23 = m2[3];
  var m30 = m3[0];
  var m31 = m3[1];
  var m32 = m3[2];
  var m33 = m3[3];
  t[0].splice(0, 4, m00, m10, m20, m30);
  t[1].splice(0, 4, m01, m11, m21, m31);
  t[2].splice(0, 4, m02, m12, m22, m32);
  t[3].splice(0, 4, m03, m13, m23, m33);
};


/**
 * Computes the inverse of the matrix a in place if no target is provided.
 * Or if a target is provided, turns the target into the transpose of a.
 *
 * @param {!Array.<!Array.<number>>} m A matrix.
 * @param {Array.<!Array.<number>>} opt_target The matrix to become the
 *     inverse of a.
 */
o3d.Transform.inverse = function(m, opt_target) {
  var t = opt_target || m;
  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];
  var m00 = m0[0];
  var m01 = m0[1];
  var m02 = m0[2];
  var m03 = m0[3];
  var m10 = m1[0];
  var m11 = m1[1];
  var m12 = m1[2];
  var m13 = m1[3];
  var m20 = m2[0];
  var m21 = m2[1];
  var m22 = m2[2];
  var m23 = m2[3];
  var m30 = m3[0];
  var m31 = m3[1];
  var m32 = m3[2];
  var m33 = m3[3];

  var tmp_0 = m22 * m33;
  var tmp_1 = m32 * m23;
  var tmp_2 = m12 * m33;
  var tmp_3 = m32 * m13;
  var tmp_4 = m12 * m23;
  var tmp_5 = m22 * m13;
  var tmp_6 = m02 * m33;
  var tmp_7 = m32 * m03;
  var tmp_8 = m02 * m23;
  var tmp_9 = m22 * m03;
  var tmp_10 = m02 * m13;
  var tmp_11 = m12 * m03;
  var tmp_12 = m20 * m31;
  var tmp_13 = m30 * m21;
  var tmp_14 = m10 * m31;
  var tmp_15 = m30 * m11;
  var tmp_16 = m10 * m21;
  var tmp_17 = m20 * m11;
  var tmp_18 = m00 * m31;
  var tmp_19 = m30 * m01;
  var tmp_20 = m00 * m21;
  var tmp_21 = m20 * m01;
  var tmp_22 = m00 * m11;
  var tmp_23 = m10 * m01;

  var t0 = (tmp_0 * m11 + tmp_3 * m21 + tmp_4 * m31) -
      (tmp_1 * m11 + tmp_2 * m21 + tmp_5 * m31);
  var t1 = (tmp_1 * m01 + tmp_6 * m21 + tmp_9 * m31) -
      (tmp_0 * m01 + tmp_7 * m21 + tmp_8 * m31);
  var t2 = (tmp_2 * m01 + tmp_7 * m11 + tmp_10 * m31) -
      (tmp_3 * m01 + tmp_6 * m11 + tmp_11 * m31);
  var t3 = (tmp_5 * m01 + tmp_8 * m11 + tmp_11 * m21) -
      (tmp_4 * m01 + tmp_9 * m11 + tmp_10 * m21);

  var d = 1.0 / (m00 * t0 + m10 * t1 + m20 * t2 + m30 * t3);

  t[0].splice(0, 4, d * t0, d * t1, d * t2, d * t3);
  t[1].splice(0, 4, d * ((tmp_1 * m10 + tmp_2 * m20 + tmp_5 * m30) -
          (tmp_0 * m10 + tmp_3 * m20 + tmp_4 * m30)),
       d * ((tmp_0 * m00 + tmp_7 * m20 + tmp_8 * m30) -
          (tmp_1 * m00 + tmp_6 * m20 + tmp_9 * m30)),
       d * ((tmp_3 * m00 + tmp_6 * m10 + tmp_11 * m30) -
          (tmp_2 * m00 + tmp_7 * m10 + tmp_10 * m30)),
       d * ((tmp_4 * m00 + tmp_9 * m10 + tmp_10 * m20) -
          (tmp_5 * m00 + tmp_8 * m10 + tmp_11 * m20)));
  t[2].splice(0, 4, d * ((tmp_12 * m13 + tmp_15 * m23 + tmp_16 * m33) -
          (tmp_13 * m13 + tmp_14 * m23 + tmp_17 * m33)),
       d * ((tmp_13 * m03 + tmp_18 * m23 + tmp_21 * m33) -
          (tmp_12 * m03 + tmp_19 * m23 + tmp_20 * m33)),
       d * ((tmp_14 * m03 + tmp_19 * m13 + tmp_22 * m33) -
          (tmp_15 * m03 + tmp_18 * m13 + tmp_23 * m33)),
       d * ((tmp_17 * m03 + tmp_20 * m13 + tmp_23 * m23) -
          (tmp_16 * m03 + tmp_21 * m13 + tmp_22 * m23)));
  t[3].splice(0, 4, d * ((tmp_14 * m22 + tmp_17 * m32 + tmp_13 * m12) -
          (tmp_16 * m32 + tmp_12 * m12 + tmp_15 * m22)),
       d * ((tmp_20 * m32 + tmp_12 * m02 + tmp_19 * m22) -
          (tmp_18 * m22 + tmp_21 * m32 + tmp_13 * m02)),
       d * ((tmp_18 * m12 + tmp_23 * m32 + tmp_15 * m02) -
          (tmp_22 * m32 + tmp_14 * m02 + tmp_19 * m12)),
       d * ((tmp_22 * m22 + tmp_16 * m02 + tmp_21 * m12) -
          (tmp_20 * m12 + tmp_23 * m22 + tmp_17 * m02)));
};


/**
 * Pre-composes the local matrix of this Transform with a translation.  For
 * example, if the local matrix is a rotation then new local matrix will
 * translate by the given vector and then rotated.
 */
o3d.Transform.prototype.translate =
    function() {
  var v;
  if (arguments.length == 3) {
    v = arguments;
  } else {
    v = arguments[0];
  }
  var m = this.localMatrix;

  var v0 = v[0];
  var v1 = v[1];
  var v2 = v[2];
  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];
  var m00 = m0[0];
  var m01 = m0[1];
  var m02 = m0[2];
  var m03 = m0[3];
  var m10 = m1[0];
  var m11 = m1[1];
  var m12 = m1[2];
  var m13 = m1[3];
  var m20 = m2[0];
  var m21 = m2[1];
  var m22 = m2[2];
  var m23 = m2[3];
  var m30 = m3[0];
  var m31 = m3[1];
  var m32 = m3[2];
  var m33 = m3[3];

  m3.splice(0, 4, m00 * v0 + m10 * v1 + m20 * v2 + m30,
                  m01 * v0 + m11 * v1 + m21 * v2 + m31,
                  m02 * v0 + m12 * v1 + m22 * v2 + m32,
                  m03 * v0 + m13 * v1 + m23 * v2 + m33);
};


/**
 * Pre-composes the local matrix of this Transform with a rotation about the
 * x-axis.  For example, if the local matrix is a tranlsation, the new local
 * matrix will rotate around the x-axis and then translate.
 *
 * @param {number} radians The number of radians to rotate around x-axis.
 */
o3d.Transform.prototype.rotateX =
    function(angle) {
  var m = this.localMatrix;

  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];
  var m10 = m1[0];
  var m11 = m1[1];
  var m12 = m1[2];
  var m13 = m1[3];
  var m20 = m2[0];
  var m21 = m2[1];
  var m22 = m2[2];
  var m23 = m2[3];
  var c = Math.cos(angle);
  var s = Math.sin(angle);

  m1.splice(0, 4, c * m10 + s * m20,
                  c * m11 + s * m21,
                  c * m12 + s * m22,
                  c * m13 + s * m23);
  m2.splice(0, 4, c * m20 - s * m10,
                  c * m21 - s * m11,
                  c * m22 - s * m12,
                  c * m23 - s * m13);
};


/**
 * Takes a 4-by-4 matrix and a vector with 3 entries,
 * interprets the vector as a point, transforms that point by the matrix, and
 * returns the result as a vector with 3 entries.
 * @param {!o3djs.math.Matrix4} m The matrix.
 * @param {!o3djs.math.Vector3} v The point.
 * @return {!o3djs.math.Vector3} The transformed point.
 */
o3d.Transform.transformPoint = function(m, v) {
  var v0 = v[0];
  var v1 = v[1];
  var v2 = v[2];
  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];

  var d = v0 * m0[3] + v1 * m1[3] + v2 * m2[3] + m3[3];
  return [(v0 * m0[0] + v1 * m1[0] + v2 * m2[0] + m3[0]) / d,
          (v0 * m0[1] + v1 * m1[1] + v2 * m2[1] + m3[1]) / d,
          (v0 * m0[2] + v1 * m1[2] + v2 * m2[2] + m3[2]) / d];
};


/**
 * Takes a 4-by-4 matrix and a vector with 4 entries,
 * interprets the vector as a point, transforms that point by the matrix, and
 * returns the result as a vector with 4 entries.
 * @param {!o3djs.math.Matrix4} m The matrix.
 * @param {!o3djs.math.Vector4} v The vector.
 * @return {!o3djs.math.Vector4} The transformed vector.
 */
o3d.Transform.multiplyVector = function(m, v) {
  var v0 = v[0];
  var v1 = v[1];
  var v2 = v[2];
  var v3 = v[3];
  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];

  return [(v0 * m0[0] + v1 * m1[0] + v2 * m2[0] + v3 * m3[0]),
          (v0 * m0[1] + v1 * m1[1] + v2 * m2[1] + v3 * m3[1]),
          (v0 * m0[2] + v1 * m1[2] + v2 * m2[2] + v3 * m3[2]),
          (v0 * m0[3] + v1 * m1[3] + v2 * m2[3] + v3 * m3[3])];
};


/**
 * Takes a 4-by-4 matrix and a vector with 3 entries,
 * interprets the vector as a point, transforms that point by the matrix,
 * returning the z-component of the result only.
 * @param {!o3djs.math.Matrix4} m The matrix.
 * @param {!o3djs.math.Vector3} v The point.
 * @return {number} The z coordinate of the transformed point.
 */
o3d.Transform.transformPointZOnly = function(m, v) {
  var v0 = v[0];
  var v1 = v[1];
  var v2 = v[2];
  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];

  return (v0 * m0[2] + v1 * m1[2] + v2 * m2[2] + m3[2]) /
      (v0 * m0[3] + v1 * m1[3] + v2 * m2[3] + m3[3]);
};


/**
 * Pre-composes the local matrix of this Transform with a rotation about the
 * y-axis.  For example, if the local matrix is a translation, the new local
 * matrix will rotate around the y-axis and then translate.
 *
 * @param {number} radians The number of radians to rotate around y-axis.
 */
o3d.Transform.prototype.rotateY =
    function(angle) {
  var m = this.localMatrix;

  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];
  var m00 = m0[0];
  var m01 = m0[1];
  var m02 = m0[2];
  var m03 = m0[3];
  var m20 = m2[0];
  var m21 = m2[1];
  var m22 = m2[2];
  var m23 = m2[3];
  var c = Math.cos(angle);
  var s = Math.sin(angle);

  m0.splice(0, 4, c * m00 - s * m20,
                  c * m01 - s * m21,
                  c * m02 - s * m22,
                  c * m03 - s * m23);
  m2.splice(0, 4, c * m20 + s * m00,
                  c * m21 + s * m01,
                  c * m22 + s * m02,
                  c * m23 + s * m03);
};


/**
 * Pre-composes the local matrix of this Transform with a rotation about the
 * z-axis.  For example, if the local matrix is a translation, the new local
 * matrix will rotate around the z-axis and then translate.
 *
 * @param {number} radians The number of radians to rotate around z-axis.
 */
o3d.Transform.prototype.rotateZ =
    function(angle) {
  var m = this.localMatrix;

  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];
  var m00 = m0[0];
  var m01 = m0[1];
  var m02 = m0[2];
  var m03 = m0[3];
  var m10 = m1[0];
  var m11 = m1[1];
  var m12 = m1[2];
  var m13 = m1[3];
  var c = Math.cos(angle);
  var s = Math.sin(angle);

  m0.splice(0, 4, c * m00 + s * m10,
                  c * m01 + s * m11,
                  c * m02 + s * m12,
                  c * m03 + s * m13);
  m1.splice(0, 4, c * m10 - s * m00,
                  c * m11 - s * m01,
                  c * m12 - s * m02,
                  c * m13 - s * m03);
};


/**
 * Pre-composes the local matrix of this Transform with a rotation.
 * Interprets the three entries of the given vector as angles by which to
 * rotate around the x, y and z axes.  Rotates around the x-axis first,
 * then the y-axis, then the z-axis.
 *
 * @param {!o3d.math.Vector3} v A vector of angles (in radians) by which
 *     to rotate around the x, y and z axes.
 */
o3d.Transform.prototype.rotateZYX =
    function(v) {
  var m = this.localMatrix;

  var sinX = Math.sin(v[0]);
  var cosX = Math.cos(v[0]);
  var sinY = Math.sin(v[1]);
  var cosY = Math.cos(v[1]);
  var sinZ = Math.sin(v[2]);
  var cosZ = Math.cos(v[2]);

  var cosZSinY = cosZ * sinY;
  var sinZSinY = sinZ * sinY;

  var r00 = cosZ * cosY;
  var r01 = sinZ * cosY;
  var r02 = -sinY;
  var r10 = cosZSinY * sinX - sinZ * cosX;
  var r11 = sinZSinY * sinX + cosZ * cosX;
  var r12 = cosY * sinX;
  var r20 = cosZSinY * cosX + sinZ * sinX;
  var r21 = sinZSinY * cosX - cosZ * sinX;
  var r22 = cosY * cosX;

  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];

  var m00 = m0[0];
  var m01 = m0[1];
  var m02 = m0[2];
  var m03 = m0[3];
  var m10 = m1[0];
  var m11 = m1[1];
  var m12 = m1[2];
  var m13 = m1[3];
  var m20 = m2[0];
  var m21 = m2[1];
  var m22 = m2[2];
  var m23 = m2[3];
  var m30 = m3[0];
  var m31 = m3[1];
  var m32 = m3[2];
  var m33 = m3[3];

  m0.splice(0, 4,
      r00 * m00 + r01 * m10 + r02 * m20,
      r00 * m01 + r01 * m11 + r02 * m21,
      r00 * m02 + r01 * m12 + r02 * m22,
      r00 * m03 + r01 * m13 + r02 * m23);

  m1.splice(0, 4,
      r10 * m00 + r11 * m10 + r12 * m20,
      r10 * m01 + r11 * m11 + r12 * m21,
      r10 * m02 + r11 * m12 + r12 * m22,
      r10 * m03 + r11 * m13 + r12 * m23);

  m2.splice(0, 4,
      r20 * m00 + r21 * m10 + r22 * m20,
      r20 * m01 + r21 * m11 + r22 * m21,
      r20 * m02 + r21 * m12 + r22 * m22,
      r20 * m03 + r21 * m13 + r22 * m23);
};


/**
 * Pre-composes the local matrix of this Transform with a rotation around the
 * given axis.  For example, if the local matrix is a translation, the new
 * local matrix will rotate around the given axis and then translate.
 *
 * @param {number} angle The number of radians to rotate.
 * @param {!o3d.math.Vector3} axis a non-zero vector representing the axis
 *     around which to rotate.
 */
o3d.Transform.prototype.axisRotate =
    function(axis, angle) {
  o3d.Transform.axisRotateMatrix(this.localMatrix, axis, angle);
};

o3d.Transform.axisRotateMatrix =
    function(m, axis, angle, opt_target) {
  opt_target = opt_target || m;
  var x = axis[0];
  var y = axis[1];
  var z = axis[2];
  var n = Math.sqrt(x * x + y * y + z * z);
  x /= n;
  y /= n;
  z /= n;
  var xx = x * x;
  var yy = y * y;
  var zz = z * z;
  var c = Math.cos(angle);
  var s = Math.sin(angle);
  var oneMinusCosine = 1 - c;

  var r00 = xx + (1 - xx) * c;
  var r01 = x * y * oneMinusCosine + z * s;
  var r02 = x * z * oneMinusCosine - y * s;
  var r10 = x * y * oneMinusCosine - z * s;
  var r11 = yy + (1 - yy) * c;
  var r12 = y * z * oneMinusCosine + x * s;
  var r20 = x * z * oneMinusCosine + y * s;
  var r21 = y * z * oneMinusCosine - x * s;
  var r22 = zz + (1 - zz) * c;

  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];

  var m00 = m0[0];
  var m01 = m0[1];
  var m02 = m0[2];
  var m03 = m0[3];
  var m10 = m1[0];
  var m11 = m1[1];
  var m12 = m1[2];
  var m13 = m1[3];
  var m20 = m2[0];
  var m21 = m2[1];
  var m22 = m2[2];
  var m23 = m2[3];
  var m30 = m3[0];
  var m31 = m3[1];
  var m32 = m3[2];
  var m33 = m3[3];

  opt_target[0].splice(0, 4,
      r00 * m00 + r01 * m10 + r02 * m20,
      r00 * m01 + r01 * m11 + r02 * m21,
      r00 * m02 + r01 * m12 + r02 * m22,
      r00 * m03 + r01 * m13 + r02 * m23);

  opt_target[1].splice(0, 4,
      r10 * m00 + r11 * m10 + r12 * m20,
      r10 * m01 + r11 * m11 + r12 * m21,
      r10 * m02 + r11 * m12 + r12 * m22,
      r10 * m03 + r11 * m13 + r12 * m23);

  opt_target[2].splice(0, 4,
      r20 * m00 + r21 * m10 + r22 * m20,
      r20 * m01 + r21 * m11 + r22 * m21,
      r20 * m02 + r21 * m12 + r22 * m22,
      r20 * m03 + r21 * m13 + r22 * m23);

  opt_target[3].splice(0, 4, m30, m31, m32, m33);
};


/**
 * Pre-composes the local matrix of this Transform with a rotation defined by
 * the given quaternion.
 *
 * @param {o3d.math.Quat} q A non-zero quaternion to be interpreted as a
 *     rotation.
 */
o3d.Transform.prototype.quaternionRotate =
    function(q) {
   var m = this.localMatrix;

  var qX = q[0];
  var qY = q[1];
  var qZ = q[2];
  var qW = q[3];

  var qWqW = qW * qW;
  var qWqX = qW * qX;
  var qWqY = qW * qY;
  var qWqZ = qW * qZ;
  var qXqW = qX * qW;
  var qXqX = qX * qX;
  var qXqY = qX * qY;
  var qXqZ = qX * qZ;
  var qYqW = qY * qW;
  var qYqX = qY * qX;
  var qYqY = qY * qY;
  var qYqZ = qY * qZ;
  var qZqW = qZ * qW;
  var qZqX = qZ * qX;
  var qZqY = qZ * qY;
  var qZqZ = qZ * qZ;

  var d = qWqW + qXqX + qYqY + qZqZ;

  o3d.Transform.compose(this.localMatrix, [
    [(qWqW + qXqX - qYqY - qZqZ) / d,
     2 * (qWqZ + qXqY) / d,
     2 * (qXqZ - qWqY) / d, 0],
    [2 * (qXqY - qWqZ) / d,
     (qWqW - qXqX + qYqY - qZqZ) / d,
     2 * (qWqX + qYqZ) / d, 0],
    [2 * (qWqY + qXqZ) / d,
     2 * (qYqZ - qWqX) / d,
     (qWqW - qXqX - qYqY + qZqZ) / d, 0],
    [0, 0, 0, 1]]);
};


/**
 * Pre-composes the local matrix of this transform by a scaling transformation.
 * For example, if the local matrix is a rotation, the new local matrix will
 * scale and then rotate.
 */
o3d.Transform.prototype.scale =
    function() {
     var v;
  if (arguments.length == 3) {
    v = arguments;
  } else {
    v = arguments[0];
  }

  var m = this.localMatrix;

  var v0 = v[0];
  var v1 = v[1];
  var v2 = v[2];

  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];

  m0.splice(0, 4, v0 * m0[0], v0 * m0[1], v0 * m0[2], v0 * m0[3]);
  m1.splice(0, 4, v1 * m1[0], v1 * m1[1], v1 * m1[2], v1 * m1[3]);
  m2.splice(0, 4, v2 * m2[0], v2 * m2[1], v2 * m2[2], v2 * m2[3]);
};


/**
 * Utility function to flatten an o3djs-style matrix
 * (which is an array of arrays) into one array of entries.
 * @param {Array.<Array.<number> >} m The o3djs-style matrix.
 * @return {Array.<number>} The flattened matrix.
 */
o3d.Transform.flattenMatrix4 = function(m) {
  var m0 = m[0];
  var m1 = m[1];
  var m2 = m[2];
  var m3 = m[3];
  return [m0[0], m0[1], m0[2], m0[3],
          m1[0], m1[1], m1[2], m1[3],
          m2[0], m2[1], m2[2], m2[3],
          m3[0], m3[1], m3[2], m3[3]];
};


/**
 * Traverses the transform tree starting at this node and adds DrawElements
 * for each shape to DrawList.
 * @param {Array.<Object>} drawListInfos A list of objects containing a draw
 *     list and matrix information.
 * @param {o3d.math.Matrix4} opt_parentWorldMatrix
 */
o3d.Transform.prototype.traverse =
    function(drawListInfos, opt_parentWorldMatrix) {
  this.gl.client.render_stats_['transformsProcessed']++;
  if (drawListInfos.length == 0 || !this.visible) {
    return;
  }
  opt_parentWorldMatrix =
      opt_parentWorldMatrix ||
          [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];

  o3d.Transform.compose(
      opt_parentWorldMatrix, this.localMatrix, this.worldMatrix);

  var remainingDrawListInfos = [];

  if (this.cull) {
    if (this.boundingBox) {
      for (var i = 0; i < drawListInfos.length; ++i) {
        var drawListInfo = drawListInfos[i];

        var worldViewProjection = [[], [], [], []];
        o3d.Transform.compose(drawListInfo.context.view,
            this.worldMatrix, worldViewProjection);
        o3d.Transform.compose(drawListInfo.context.projection,
            worldViewProjection, worldViewProjection);

        if (this.boundingBox.inFrustum(worldViewProjection)) {
          remainingDrawListInfos.push(drawListInfo);
        }
      }
    }
  } else {
    remainingDrawListInfos = drawListInfos;
  }

  if (remainingDrawListInfos.length == 0) {
    this.gl.client.render_stats_['transformsCulled']++;
    return;
  }

  var children = this.children;
  var shapes = this.shapes;

  for (var i = 0; i < shapes.length; ++i) {
    shapes[i].writeToDrawLists(remainingDrawListInfos, this.worldMatrix, this);
  }

  for (var i = 0; i < children.length; ++i) {
    children[i].traverse(remainingDrawListInfos, this.worldMatrix);
  }
};


