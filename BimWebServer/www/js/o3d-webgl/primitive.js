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
 * A Primitive is a type of Element that is made from a list of points,
 * lines or triangles that use a single material.
 *
 * @param opt_streamBank o3d.StreamBank The StreamBank used by this
 *     Primitive.
 * @constructor
 */
o3d.Primitive = function(opt_streamBank) {
  o3d.Element.call(this);

  /**
   * The index buffer for the primitive. If null the primitive is non-indexed.
   * @type {o3d.IndexBuffer}
   */
  this.indexBuffer = null;

  /**
   * The stream bank this primitive uses for vertices.
   * @type {o3d.StreamBank}
   */
  this.streamBank = opt_streamBank || null;

  /**
   * The type of primitive the primitive is (i.e., POINTLIST, LINELIST,
   * TRIANGLELIST, etc.)
   *
   * @type {o3d.Primitive.Type}
   */
  this.primitiveType = o3d.Primitive.TRIANGLELIST;

  /**
   * The number of vertices the primitive has.
   *
   * @type {number}
   */
  this.numberVertices = 0;

  /**
   * The number of rendering primitives (i.e., triangles, points, lines) the
   * primitive has.
   *
   * @type {number}
   */
  this.numberPrimitives = 0;

  /**
   * The index of the first vertex to render.
   *
   * @type {number}
   */
  this.startIndex = 0;

  /**
   * The index buffer for the wireframe version of the primitive.
   * @type {o3d.IndexBuffer}
   * @private
   */
  this.wireframeIndexBuffer_ = null;
};
o3d.inherit('Primitive', 'Element');


/**
 * @type {number}
 */
o3d.Primitive.Type = goog.typedef;

/**
 * Type of geometric primitives used by the Primitive.
 */
o3d.Primitive.POINTLIST = 1;
o3d.Primitive.LINELIST = 2;
o3d.Primitive.LINESTRIP = 3;
o3d.Primitive.TRIANGLELIST = 4;
o3d.Primitive.TRIANGLESTRIP = 5;
o3d.Primitive.TRIANGLEFAN = 6;

o3d.ParamObject.setUpO3DParam_(o3d.Primitive, 'streamBank', 'ParamStreamBank');

/**
 * Binds the vertex and index streams required to draw the shape.
 */
o3d.Primitive.prototype.render = function() {
  var streamBank = this.streamBank;
  var indexBuffer = this.indexBuffer;

  var enabled_attribs = [];

  for (var semantic = 0;
       semantic < streamBank.vertex_streams_.length;
       ++semantic) {
    var streams = streamBank.vertex_streams_[semantic];
    if (streams && streams.length) {
      for (var semantic_index = 0;
           semantic_index < streams.length;
           ++semantic_index) {
        var gl_index = o3d.Effect.reverseSemanticMap_[semantic][semantic_index];
        var stream = streams[semantic_index].stream;
        var field = stream.field;
        var buffer = field.buffer;

        if (gl_index == undefined) {
          this.gl.client.error_callback('uknown semantic');
        }

        var stream_param = streams[semantic_index];
        while (!stream_param.owner_.updateStreams &&
               stream_param.inputConnection) {
          stream_param = stream_param.inputConnection;
        }
        if (stream_param.owner_.updateStreams) {
          // By now, stream_param should point to the SkinEval's streams.
          stream_param.owner_.updateStreams();  // Triggers updating.
        }

        this.gl.bindBuffer(this.gl.ARRAY_BUFFER, buffer.gl_buffer_);
        this.gl.enableVertexAttribArray(gl_index);
        enabled_attribs.push(gl_index);

        var kFloatSize = Float32Array.BYTES_PER_ELEMENT;

        this.gl.vertexAttribPointer(
            gl_index, field.numComponents, this.gl.FLOAT, false,
            buffer.totalComponents * kFloatSize, field.offset_ * kFloatSize);
      }
    }
  }

  this.gl.client.render_stats_['primitivesRendered'] += this.numberPrimitives;

  var glMode;
  var glNumElements;

  switch (this.primitiveType) {
    case o3d.Primitive.POINTLIST:
      glMode = this.gl.POINTS;
      glNumElements = this.numberPrimitives;
      break;
    case o3d.Primitive.LINELIST:
      glMode = this.gl.LINES;
      glNumElements = this.numberPrimitives * 2;
      break;
    case o3d.Primitive.LINESTRIP:
      glMode = this.gl.LINE_STRIP;
      glNumElements = this.numberPrimitives + 1;
      break;
    case o3d.Primitive.TRIANGLELIST:
      glMode = this.gl.TRIANGLES;
      glNumElements = this.numberPrimitives * 3;
      break;
    case o3d.Primitive.TRIANGLESTRIP:
      glMode = this.gl.TRIANGLE_STRIP;
      glNumElements = this.numberPrimitives + 2;
      break;
    case o3d.Primitive.TRIANGLEFAN:
      glMode = this.gl.TRIANGLE_FAN;
      glNumElements = this.numberPrimitives + 2;
      break;
    case o3d.Primitive.TRIANGLELIST:
    default:
      glMode = this.gl.TRIANGLES;
      glNumElements = this.numberPrimitives * 3;
      break;
  }

  var use_wireframe_indices = false;

  if (this.gl.fillMode_ == o3d.State.POINT) {
    // If the fill mode is points, then we just replace the gl primitive type
    // with POINTS and let the (possibly redundant) list of points draw.
    glMode = this.gl.POINTS;
  } else if (this.gl.fillMode_ == o3d.State.WIREFRAME) {
    // If the fill mode is lines, and the primitive type is some kind of
    // triangle, then we need to reorder indices to draw the right thing.

    if (this.primitiveType == o3d.Primitive.TRIANGLELIST ||
        this.primitiveType == o3d.Primitive.TRIANGLEFAN ||
        this.primitiveType == o3d.Primitive.TRIANGLESTRIP) {
      use_wireframe_indices = true;
      glMode = this.gl.LINES;
      this.computeWireframeIndices_();
    }
  }

  if (use_wireframe_indices) {
    indexBuffer = this.wireframeIndexBuffer_;

    switch(this.primitiveType) {
      default:
      case o3d.Primitive.TRIANGLELIST:
        glNumElements = this.numberPrimitives * 6;
        break;
      case o3d.Primitive.TRIANGLESTRIP:
      case o3d.Primitive.TRIANGLEFAN:
        glNumElements = (this.numberPrimitives == 0) ? 0 :
            this.numberPrimitives * 4 + 2;
        break;
    }
  }

  if (!indexBuffer) {
    this.gl.drawArrays(glMode, 0, glNumElements);
  } else {
    this.gl.bindBuffer(this.gl.ELEMENT_ARRAY_BUFFER, indexBuffer.gl_buffer_);
    this.gl.drawElements(glMode,
                         glNumElements,
                         this.gl.UNSIGNED_SHORT,
                         0);
  }

  for (var i = 0; i < enabled_attribs.length; ++i) {
    this.gl.disableVertexAttribArray(enabled_attribs[i]);
  }
};


/**
 * Given n, gets index number n in the index buffer if there is an index buffer
 * otherwise returns n.
 * @param {number} n The number of the entry in the index buffer.
 * @return {return} The index.
 * @private
 */
o3d.Primitive.prototype.getIndex_ = function(n) {
  if (this.indexBuffer) {
    return this.indexBuffer.array_[n]
  }
  return n;
};


/**
 * Generates an index buffer for a wireframe outline of a triangle-based
 * primitive.
 * @private
 */
o3d.Primitive.prototype.computeWireframeIndices_ = function() {
  this.wireframeIndexBuffer_ = new o3d.IndexBuffer;
  this.wireframeIndexBuffer_.gl = this.gl;

  var numTriangles = this.numberPrimitives;
  var numLines = (this.primitiveType == o3d.Primitive.TRIANGLELIST) ?
    (3 * numTriangles) : (2 * numTriangles + 1);

  this.wireframeIndexBuffer_.resize(2 * numLines);

  var j = 0;  // The current index in wireframeIndices.
  switch (this.primitiveType) {
    default:
    case o3d.Primitive.TRIANGLELIST: {
      var wireframeIndices = this.wireframeIndexBuffer_.array_;
      this.wireframeIndexBuffer_.lock();
      // Iterate through triangles.
      for (var i = 0; i < numTriangles; ++i) {
        // Indices the vertices of the triangle a, b, c.
        var a = this.getIndex_(3 * i);
        var b = this.getIndex_(3 * i + 1);
        var c = this.getIndex_(3 * i + 2);
        wireframeIndices[j++] = a;
        wireframeIndices[j++] = b;
        wireframeIndices[j++] = b;
        wireframeIndices[j++] = c;
        wireframeIndices[j++] = c;
        wireframeIndices[j++] = a;
      }
      this.wireframeIndexBuffer_.unlock();
    }
    break;

    case o3d.Primitive.TRIANGLEFAN: {
      var wireframeIndices = this.wireframeIndexBuffer_.array_;
      this.wireframeIndexBuffer_.lock();
      // The first two points make a line.
      var z;
      if (numTriangles > 0) {
        z = this.getIndex_(0);
        wireframeIndices[j++] = z;
        wireframeIndices[j++] = this.getIndex_(1);
      }
      // Each additional point forms a new triangle by adding two lines.
      for (var i = 2; i < numTriangles + 2; ++i) {
        var a = this.getIndex_(i);
        wireframeIndices[j++] = z;
        wireframeIndices[j++] = a;
        wireframeIndices[j++] = a;
        wireframeIndices[j++] = this.getIndex_(i - 1);
      }
      this.wireframeIndexBuffer_.unlock();
    }
    break;

    case o3d.Primitive.TRIANGLESTRIP: {
      var wireframeIndices = this.wireframeIndexBuffer_.array_;
      this.wireframeIndexBuffer_.lock();
      // The frist two points make a line.
      var a;
      var b;
      if (numTriangles > 0) {
        a = this.getIndex_(0);
        b = this.getIndex_(1);
        wireframeIndices[j++] = a;
        wireframeIndices[j++] = b;
      }
      // Each additional point forms a new triangle by adding two lines.
      for (var i = 2; i < numTriangles + 2; ++i) {
        var c = this.getIndex_(i);
        wireframeIndices[j++] = b;
        wireframeIndices[j++] = c;
        wireframeIndices[j++] = c;
        wireframeIndices[j++] = a;
        a = b;
        b = c;
      }
      this.wireframeIndexBuffer_.unlock();
    }
    break;
  }
};

/**
 * Returns the three indices of the n-th triangle of this primitive. If the
 * primitive has no index buffer, then the buffer is assumed to be [0 ... n-1].
 * These indices can then be used to reference the vertex buffer and get the
 * triangle vertices' positions.
 *
 * @param {number} n The number of the triangle we want. Zero-indexed.
 * @return {!Array.<Number>} Array containing three indices that correspond to
 *    the n-th triangle of this primitive.
 * @private
 */
o3d.Primitive.prototype.computeTriangleIndices_ = function(n) {
  var indices;
  switch (this.primitiveType) {
    case o3d.Primitive.TRIANGLESTRIP:
      if (n % 2 == 0) {
        indices = [n, n + 1, n + 2];
      } else {
        indices = [n + 1, n, n + 2];
      }
      break;
    case o3d.Primitive.TRIANGLEFAN:
      indices = [0, n + 1, n + 2];
      break;
    case o3d.Primitive.TRIANGLELIST:
    default:
      indices = [3 * n, 3 * n + 1, 3 * n + 2];
      break;
  }
  if (this.indexBuffer) {
    var buffer = this.indexBuffer.array_;
    return [buffer[indices[0]],
            buffer[indices[1]],
            buffer[indices[2]]];
  } else {
    return indices;
  }
};

/**
 * Computes the intersection of a ray in the coordinate system of
 * the specified POSITION stream.
 * @param {number} position_stream_index Index of POSITION stream.
 * @param {o3d.Cull} cull which side of the triangles to ignore.
 * @param {!o3d.math.Point3} start position of start of ray in local space.
 * @param {!o3d.math.Point3} end position of end of ray. in local space.
 * @return {!o3d.RayIntersectionInfo}  RayIntersectionInfo class. If valid()
 *     is false then something was wrong, Check GetLastError(). If
 *     intersected() is true then the ray intersected a something. position()
 *     is the exact point of intersection.
 */
o3d.Primitive.prototype.intersectRay =
    function(position_stream_index, cull, start, end) {
  var result = new o3d.RayIntersectionInfo;
  result.valid = true;

  var streamBank = this.streamBank;
  var indexBuffer = this.indexBuffer;
  var positionStreams = this.streamBank.vertex_streams_[o3d.Stream.POSITION];
  var stream = positionStreams[position_stream_index].stream;

  var field = stream.field;
  var buffer = field.buffer;
  var numPoints = buffer.array_.length / buffer.totalComponents;
  var elements = field.getAt(0, numPoints);

  // The direction of the vector of the ray.
  var x = end[0] - start[0];
  var y = end[1] - start[1];
  var z = end[2] - start[2];

  // Find two vectors orthogonal to direction for use in quickly eliminating
  // triangles which can't possibly intersect the ray.
  var direction = [x, y, z];

  // Pick a vector orthogonal to direction called u.
  var ux = -y;
  var uy = x;
  var uz = 0;
  if (x * x + y * y < z * z) {
    ux = -z;
    uy = 0;
    uz = x;
  }

  // Cross product direction and u get a third orthogonal vector v.
  var vx = y * uz - z * uy;
  var vy = z * ux - x * uz;
  var vz = x * uy - y * ux;

  var udotstart = ux * start[0] + uy * start[1] + uz * start[2];
  var vdotstart = vx * start[0] + vy * start[1] + vz * start[2];

  // As we search for an intersection point, we keep track of how far out
  // from the start the point with this variable.
  var min_distance = 0;

  // Iterate through the indices and examine triples of indices that each
  // define a triangle.  For each triangle, we test for intersection with
  // the ray.  We need to find the closest one to start, so we have to
  // check them all.

  var numIndices = indexBuffer ? indexBuffer.array_.length : numPoints;
  switch (this.primitiveType) {
    case o3d.Primitive.TRIANGLESTRIP:
      numTriangles = numIndices - 2;
      break;
    case o3d.Primitive.TRIANGLEFAN:
      numTriangles = numIndices - 2;
      break;
    case o3d.Primitive.TRIANGLELIST:
    default:
      numTriangles = numIndices / 3;
      break;
  }

  for (var i = 0; i < numTriangles; ++i) {
    var indices = this.computeTriangleIndices_(i);

    // Check if the current triangle is too far to one side of the ray
    // to intersect at all.  (This is what the orthogonal vectors are for)
    var u_sides = [false, false, false];
    var v_sides = [false, false, false];
    for (var j = 0; j < 3; ++j) {
      var t = 3 * indices[j];
      var r = elements.slice(t, t + 3);
      u_sides[j] = ux * r[0] + uy * r[1] + uz * r[2] - udotstart > 0;
      v_sides[j] = vx * r[0] + vy * r[1] + vz * r[2] - vdotstart > 0;
    }

    // All vertices of the triangle are on the same side of the start point,
    // the ray cannot intersect, so we move on.
    if (((u_sides[0] == u_sides[1]) && (u_sides[0] == u_sides[2])) ||
        ((v_sides[0] == v_sides[1]) && (v_sides[0] == v_sides[2]))) {
      continue;
    }

    // Compute a matrix that transforms the unit triangle
    // (1, 0, 0)..(0, 1, 0)..(0, 0, 1) into the current triangle.
    var t;
    t = 3 * indices[0];
    var m00 = elements[t] - start[0];
    var m01 = elements[t + 1] - start[1];
    var m02 = elements[t + 2] - start[2];
    t = 3 * indices[1];
    var m10 = elements[t] - start[0];
    var m11 = elements[t + 1] - start[1];
    var m12 = elements[t + 2] - start[2];
    t = 3 * indices[2];
    var m20 = elements[t] - start[0];
    var m21 = elements[t + 1] - start[1];
    var m22 = elements[t + 2] - start[2];

    var t00 = m11 * m22 - m12 * m21;
    var t10 = m01 * m22 - m02 * m21;
    var t20 = m01 * m12 - m02 * m11;

    // Compute the determinant of the matrix.  The sign (+/-) tells us
    // if it's culled.
    var d = m00 * t00 - m10 * t10 + m20 * t20;

    if ((cull == o3d.State.CULL_CW && d < 0) ||
        (cull == o3d.State.CULL_CCW && d > 0)) {
      continue;
    }

    // Transform the direction vector by the inverse of that matrix.
    // If the end point is in the first octant, it's a hit.
    var v0 = (t00 * x -
        (m10 * m22 - m12 * m20) * y +
        (m10 * m21 - m11 * m20) * z) / d;
    var v1 = (-t10 * x +
        (m00 * m22 - m02 * m20) * y -
        (m00 * m21 - m01 * m20) * z) / d;
    var v2 = (t20 * x -
        (m00 * m12 - m02 * m10) * y +
        (m00 * m11 - m01 * m10) * z) / d;

    if (v0 >= 0 && v1 >= 0 && v2 >= 0 && (v0 + v1 + v2 > 0)) {
      // Rescale by the one-norm to find the intersection of the transformed.
      // ray with the unit triangle.
      var one_norm = v0 + v1 + v2;
      v0 /= one_norm;
      v1 /= one_norm;
      v2 /= one_norm;
      // Multiply m to get back to the original triangle.
      var px = m00 * v0 + m10 * v1 + m20 * v2;
      var py = m01 * v0 + m11 * v1 + m21 * v2;
      var pz = m02 * v0 + m12 * v1 + m22 * v2;
      // Compute the distance (actually distance squared) from the start point
      // to the intersection.
      var distance = px * px + py * py + pz * pz;
      if (!result.intersected || distance < min_distance) {
        min_distance = distance;
        result.position[0] = px + start[0];
        result.position[1] = py + start[1];
        result.position[2] = pz + start[2];
        result.primitiveIndex = i;
      }
      result.intersected = true;
    }
  }

  return result;
};


/**
 * Computes the bounding box in same coordinate system as the specified
 * POSITION stream.
 * @param {number} position_stream_index Index of POSITION stream.
 * @return {!o3d.BoundingBox}  The boundingbox for this element in local space.
 */
o3d.Primitive.prototype.getBoundingBox =
    function(position_stream_index) {
  var streamBank = this.streamBank;
  var indexBuffer = this.indexBuffer;
  var stream =
    this.streamBank.getVertexStream(o3d.Stream.POSITION, position_stream_index);

  var points = [];
  var field = stream.field;
  var buffer = field.buffer;
  var numPoints = buffer.array_.length / buffer.totalComponents;

  var elements = field.getAt(0, numPoints);

  for (var index = 0; index < numPoints; ++index) {
    var p = [0, 0, 0];
    for (var i = 0; i < field.numComponents; ++i) {
      p[i] = elements[field.numComponents * index + i];
    }
    points.push(p);
  }

  o3d.BoundingBox.fitBoxToPoints_(points, this.boundingBox);
  return this.boundingBox;
};



