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
 * Creates BoundingBox from minExtent and maxExtent
 * @param {!o3d.math.Point3} opt_minExtent optional minimum extent of the box.
 * @param {!o3d.math.Point3} opt_maxExtent optional maximum extent of the box.
 * @constructor
 */
o3d.BoundingBox =
    function(opt_minExtent, opt_maxExtent) {
  o3d.ParamObject.call(this);
  var minExtent = opt_minExtent || [0, 0, 0];
  var maxExtent = opt_maxExtent || [0, 0, 0];

  this.minExtent = [minExtent[0], minExtent[1], minExtent[2]];
  this.maxExtent = [maxExtent[0], maxExtent[1], maxExtent[2]];

  // If there were extents passed in, that validates the box.
  if (opt_minExtent && opt_maxExtent) {
    this.valid = true;
  }
};
o3d.inherit('BoundingBox', 'ParamObject');


/**
 * Computes a list of 8 3-dimensional vectors for the corners of the box.
 * @return {!Array.<Array<numbers>>} The list of corners.
 */
o3d.BoundingBox.prototype.corners_ = function() {
  var result = [];
  var m = [this.minExtent, this.maxExtent];
  for (var i = 0; i < 2; ++i) {
    for (var j = 0; j < 2; ++j) {
      for (var k = 0; k < 2; ++k) {
        result.push([m[i][0], m[j][1], m[k][2]]);
      }
    }
  }

  return result;
};


/**
 * Computes the smallest bounding box containing all the points in the given
 * list, and either modifies the optional box passed in to match, or returns
 * that box as a new box.
 * @param {!Array.<Array<numbers>>} points A non-empty list of points.
 * @param {o3d.BoundingBox} opt_targetBox Optional box to modify instead of
 *     returning a new box.
 * @private
 */
o3d.BoundingBox.fitBoxToPoints_ = function(points, opt_targetBox) {
  var target = opt_targetBox || new o3d.BoundingBox();
  for (var index = 0; index < 3; ++index) {
    target.maxExtent[index] = target.minExtent[index] = points[0][index];
    for (var i = 1; i < points.length; ++i) {
      var point = points[i];
      target.minExtent[index] = Math.min(target.minExtent[index], point[index]);
      target.maxExtent[index] = Math.max(target.maxExtent[index], point[index]);
    }
  }
  target.valid = true;
  return target;
};


/**
 * True if this boundingbox has been initialized.
 * @type {boolean}
 */
o3d.BoundingBox.prototype.valid = false;


/**
 * The min extent of the box.
 * @type {!o3d.math.Point3}
 */
o3d.BoundingBox.prototype.minExtent = [0, 0, 0];


/**
 * The max extent of the box.
 * @type {!o3d.math.Point3}
 */
o3d.BoundingBox.prototype.maxExtent = [0, 0, 0];


/**
 * Multiplies the bounding box by the given matrix returning a new bounding
 * box.
 * @param {!o3d.math.Matrix4} matrix The matrix to multiply by.
 * @return {!o3d.BoundingBox}  The new bounding box.
 */
o3d.BoundingBox.prototype.mul =
    function(matrix) {
  var corners = this.corners_();
  var new_corners = [];

  for (var i = 0; i < corners.length; ++i) {
    new_corners.push(o3d.Transform.transformPoint(matrix, corners[i]));
  }

  return o3d.BoundingBox.fitBoxToPoints_(new_corners);
};


/**
 * Adds a bounding box to this bounding box returning a bounding box that
 * encompases both.
 * @param {!o3d.BoundingBox} box BoundingBox to add to this BoundingBox.
 * @return {!o3d.BoundingBox}  The new bounding box.
 */
o3d.BoundingBox.prototype.add =
    function(box) {
  return new o3d.BoundingBox(
    [Math.min(box.minExtent[0], this.minExtent[0]),
     Math.min(box.minExtent[1], this.minExtent[1]),
     Math.min(box.minExtent[2], this.minExtent[2])],
    [Math.max(box.maxExtent[0], this.maxExtent[0]),
     Math.max(box.maxExtent[1], this.maxExtent[1]),
     Math.max(box.maxExtent[2], this.maxExtent[2])]);
};


/**
 * Checks if a ray defined in same coordinate system as this box intersects
 * this bounding box.
 * @param {!o3d.math.Point3} start position of start of ray in local space.
 * @param {!o3d.math.Point3} end position of end of ray in local space.
 * @return {!o3d.RayIntersectionInfo}  RayIntersectionInfo. If result.value
 *     is false then something was wrong like using this function with an
 *     uninitialized bounding box. If result.intersected is true then the ray
 *     intersected the box and result.position is the exact point of
 *     intersection.
 */
o3d.BoundingBox.prototype.intersectRay =
    function(start, end) {
  // If there are six arguments, assume they are the coordinates of two points.
  if (arguments.length == 6) {
    start = [arguments[0], arguments[1], arguments[2]];
    end = [arguments[3], arguments[4], arguments[5]];
  }

  var result = new o3d.RayIntersectionInfo;

  if (this.valid) {
    result.valid = true;
    result.intersected = true;  // True until proven false.

    var kNumberOfDimensions = 3;
    var kRight = 0;
    var kLeft = 1;
    var kMiddle = 2;

    var direction = [end[0] - start[0], end[1] - start[1], end[2] - start[2]];
    var coord = [0, 0, 0];
    var inside = true;

    var quadrant = [];
    var max_t = [];
    var candidate_plane = [];

    for (var i = 0; i < kNumberOfDimensions; ++i) {
      quadrant.push(0.0);
      max_t.push(0.0);
      candidate_plane.push(0,0);
    }

    var which_plane;

    // Find candidate planes; this loop can be avoided if rays cast all from
    // the eye (assumes perpsective view).
    for (var i = 0; i < kNumberOfDimensions; ++i) {
      if (start[i] < this.minExtent[i]) {
        quadrant[i] = kLeft;
        candidate_plane[i] = this.minExtent[i];
        inside = false;
      } else if (start[i] >  this.maxExtent[i]) {
        quadrant[i] = kRight;
        candidate_plane[i] =  this.maxExtent[i];
        inside = false;
      } else  {
        quadrant[i] = kMiddle;
      }
    }

    // Ray origin inside bounding box.
    if (inside) {
      result.position = start;
      result.inside = true;
    } else {
      // Calculate T distances to candidate planes.
      for (var i = 0; i < kNumberOfDimensions; ++i) {
        if (quadrant[i] != kMiddle && direction[i] != 0.0) {
          max_t[i] = (candidate_plane[i] - start[i]) / direction[i];
        } else {
          max_t[i] = -1.0;
        }
      }

      // Get largest of the max_t's for final choice of intersection.
      which_plane = 0;
      for (var i = 1; i < kNumberOfDimensions; ++i) {
        if (max_t[which_plane] < max_t[i]) {
          which_plane = i;
        }
      }

      // Check final candidate actually inside box.
      if (max_t[which_plane] < 0.0) {
        result.intersected = false;
      } else {
        for (var i = 0; i < kNumberOfDimensions; ++i) {
          if (which_plane != i) {
            coord[i] = start[i] + max_t[which_plane] * direction[i];
            if (coord[i] < this.minExtent[i] || coord[i] > this.maxExtent[i]) {
              result.intersected = false;
              break;
            }
          } else {
            coord[i] = candidate_plane[i];
          }
        }

        // Ray hits box.
        result.position = coord;
      }
    }
  }

  return result;
};


/**
 * Returns true if the bounding box is inside the frustum matrix.
 * It checks all 8 corners of the bounding box against the 6 frustum planes
 * and determines whether there's at least one plane for which all 6 points lie
 * on the outside side of it.  In that case it reports that the bounding box
 * is outside the frustum.  Note that this is a conservative check in that
 * it in certain cases it will report that a box is in the frustum even if it
 * really isn't.  However if it reports that the box is outside then it's
 * guaranteed to be outside.
 * @param {!o3d.math.Matrix4} matrix Matrix to transform the box from its
 *     local space to view frustum space.
 * @return {boolean} True if the box is in the frustum.
 */
o3d.BoundingBox.prototype.inFrustum =
    function(matrix) {
  var corners = this.corners_();
  var bb_test = 0x3f;
  for (var i = 0; i < corners.length; ++i) {
    var corner = corners[i];
    var p = o3d.Transform.transformPoint(matrix, corner);
    bb_test &= (((p[0] > 1.0) << 0) |
                ((p[0] < -1.0) << 1) |
                ((p[1] > 1.0) << 2) |
                ((p[1] < -1.0) << 3) |
                ((p[2] > 1.0) << 4) |
                ((p[2] < 0.0) << 5));
    if (bb_test == 0) {
      return true;
    }
  }

  return (bb_test == 0);
};


