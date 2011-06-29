/*
 * Copyright 2009, Google Inc.
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
 * @fileoverview This file contains various functions to help
 * create line primitives for o3d applications.
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.lineprimitives');

o3djs.require('o3djs.math');
o3djs.require('o3djs.primitives');

/**
 * Defines a namespace for o3djs.lineprimitives.
 * @namespace
 */
o3djs.lineprimitives = o3djs.lineprimitives || {};

/**
 * A LineVertexInfo is a specialization of VertexInfoBase for line based
 * geometry.
 * @constructor
 * @extends {o3djs.primitives.VertexInfoBase}
 */
o3djs.lineprimitives.LineVertexInfo = function() {
  o3djs.primitives.VertexInfoBase.call(this);
}

o3djs.base.inherit(o3djs.lineprimitives.LineVertexInfo,
                   o3djs.primitives.VertexInfoBase);

/**
 * Returns the number of lines represented by the LineVertexInfo.
 * @return {number} The number of lines represented by LineVertexInfo.
 */
o3djs.lineprimitives.LineVertexInfo.prototype.numLines = function() {
  return this.indices.length / 2;
};

/**
 * Adds a line.
 * @param {number} index1 The index of the first vertex of the line.
 * @param {number} index2 The index of the second vertex of the line.
 */
o3djs.lineprimitives.LineVertexInfo.prototype.addLine = function(
    index1, index2) {
  this.indices.push(index1, index2);
};

/**
 * Gets the vertex indices of the triangle at the given triangle index.
 * @param {number} triangleIndex The index of the triangle.
 * @return {!Array.<number>} An array of three triangle indices.
 */
o3djs.lineprimitives.LineVertexInfo.prototype.getLine = function(
    triangleIndex) {
  var indexIndex = triangleIndex * 3;
  return [this.indices[indexIndex + 0],
          this.indices[indexIndex + 1],
          this.indices[indexIndex + 2]];
};

/**
 * Sets the vertex indices of the line at the given line index.
 * @param {number} lineIndex The index of the line.
 * @param {number} index1 The index of the first vertex of the line.
 * @param {number} index2 The index of the second vertex of the line.
 */
o3djs.lineprimitives.LineVertexInfo.prototype.setLine = function(
    lineIndex, index1, index2) {
  var indexIndex = lineIndex * 2;
  this.indices[indexIndex + 0] = index1;
  this.indices[indexIndex + 1] = index2;
};

/**
 * Creates a shape from a LineVertexInfo
 * @param {!o3d.Pack} pack Pack to create objects in.
 * @param {!o3d.Material} material to use.
 * @return {!o3d.Shape} The created shape.
 */
o3djs.lineprimitives.LineVertexInfo.prototype.createShape = function(
    pack,
    material) {
  return this.createShapeByType(
      pack, material, o3djs.base.o3d.Primitive.LINELIST);
};

/**
 * Creates a new LineVertexInfo.
 * @return {!o3djs.lineprimitives.LineVertexInfo} The new LineVertexInfo.
 */
o3djs.lineprimitives.createLineVertexInfo = function() {
  return new o3djs.lineprimitives.LineVertexInfo();
};

/**
 * Creates the vertices and indices for a cube of lines.
 * The cube will be created around the origin (-size / 2, size / 2).
 * The created cube has a position stream only and can therefore only be used
 * with appropriate shaders.
 *
 * @param {number} size Width, height and depth of the cube.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3djs.lineprimitives.LineVertexInfo} The created cube vertices.
 */
o3djs.lineprimitives.createLineCubeVertices = function(size, opt_matrix) {
  var k = size / 2;

  var vertices = [
    [-k, -k, -k],
    [+k, -k, -k],
    [-k, +k, -k],
    [+k, +k, -k],
    [-k, -k, +k],
    [+k, -k, +k],
    [-k, +k, +k],
    [+k, +k, +k]
  ];

  var indices = [
    [0, 1],
    [1, 3],
    [3, 2],
    [2, 0],
    [4, 5],
    [5, 7],
    [7, 6],
    [6, 4],
    [0, 4],
    [1, 5],
    [2, 6],
    [3, 7]
  ];

  var vertexInfo = o3djs.lineprimitives.createLineVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);

  for (var v = 0; v < vertices.length; ++v) {
    positionStream.addElementVector(vertices[v]);
  }

  for (var i = 0; i < indices.length; ++i) {
    vertexInfo.addLine(indices[i][0], indices[i][1]);
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a cube of lines.
 * The cube will be created around the origin (-size / 2, size / 2).
 * The created cube has a position stream only and can therefore only be used
 * with appropriate shaders.
 *
 * @param {!o3d.Pack} pack Pack to create cube elements in.
 * @param {!o3d.Material} material Material to use.
 * @param {number} size Width, height and depth of the cube.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3d.Shape} The created cube.
 */
o3djs.lineprimitives.createLineCube = function(
    pack,
    material,
    size,
    opt_matrix) {
  var vertexInfo =
      o3djs.lineprimitives.createLineCubeVertices(size, opt_matrix);
  return vertexInfo.createShape(pack, material);
};

/**
 * Creates sphere vertices.
 * The created sphere has a position stream only and can therefore only be
 * used with appropriate shaders.
 *
 * @param {number} radius radius of the sphere.
 * @param {number} subdivisionsAxis number of steps around the sphere.
 * @param {number} subdivisionsHeight number of steps vertically on the sphere.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3djs.lineprimitives.LineVertexInfo} The created sphere vertices.
 */
o3djs.lineprimitives.createLineSphereVertices = function(
    radius,
    subdivisionsAxis,
    subdivisionsHeight,
    opt_matrix) {
  if (subdivisionsAxis <= 0 || subdivisionsHeight <= 0) {
    throw Error('subdivisionAxis and subdivisionHeight must be > 0');
  }

  // We are going to generate our sphere by iterating through its
  // spherical coordinates and generating 1 quad for each quad on a
  // ring of the sphere.

  var vertexInfo = o3djs.lineprimitives.createLineVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);

  // Generate the individual vertices in our vertex buffer.
  for (var y = 0; y <= subdivisionsHeight; y++) {
    for (var x = 0; x <= subdivisionsAxis; x++) {
      // Generate a vertex based on its spherical coordinates
      var u = x / subdivisionsAxis
      var v = y / subdivisionsHeight;
      var theta = 2 * Math.PI * u;
      var phi = Math.PI * v;
      var sinTheta = Math.sin(theta);
      var cosTheta = Math.cos(theta);
      var sinPhi = Math.sin(phi);
      var cosPhi = Math.cos(phi);
      var ux = cosTheta * sinPhi;
      var uy = cosPhi;
      var uz = sinTheta * sinPhi;
      positionStream.addElement(radius * ux, radius * uy, radius * uz);
    }
  }
  var numVertsAround = subdivisionsAxis + 1;

  for (var x = 0; x < subdivisionsAxis; x++) {
    for (var y = 0; y < subdivisionsHeight; y++) {
      // Make 2 lines per quad.
      vertexInfo.addLine(
          (y + 0) * numVertsAround + x,
          (y + 0) * numVertsAround + x + 1);
      vertexInfo.addLine(
          (y + 0) * numVertsAround + x,
          (y + 1) * numVertsAround + x);
    }
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a sphere.
 * The created sphere has a position stream only and can therefore only be
 * used with appropriate shaders.
 *
 * @param {!o3d.Pack} pack Pack to create sphere elements in.
 * @param {!o3d.Material} material Material to use.
 * @param {number} radius radius of the sphere.
 * @param {number} subdivisionsAxis number of steps around the sphere.
 * @param {number} subdivisionsHeight number of steps vertically on the sphere.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3d.Shape} The created sphere.
 *
 * @see o3d.Pack
 * @see o3d.Shape
 */
o3djs.lineprimitives.createLineSphere = function(
    pack,
    material,
    radius,
    subdivisionsAxis,
    subdivisionsHeight,
    opt_matrix) {
  var vertexInfo = o3djs.lineprimitives.createLineSphereVertices(
      radius,
      subdivisionsAxis,
      subdivisionsHeight,
      opt_matrix);

  return vertexInfo.createShape(pack, material);
};

/**
 * Creates ring vertices.
 * The ring is a circle in the XZ plane, centered at the origin.
 * The created ring has position, normal, and 1-D texcoord streams.
 * The normals point outwards from the center of the ring.
 * The texture coordinates are based on angle about the center.
 *
 * @param {number} radius Radius of the ring.
 * @param {number} subdivisions Number of steps around the ring.
 * @param {number} maxTexCoord 1-D texture coordinates will range from 0 to
 *     this value, based on angle about the center.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3djs.lineprimitives.LineVertexInfo} The created ring vertices.
 */
o3djs.lineprimitives.createLineRingVertices = function(
    radius,
    subdivisions,
    maxTexCoord,
    opt_matrix) {
  if (subdivisions < 3) {
    throw Error('subdivisions must be >= 3');
  }

  var vertexInfo = o3djs.lineprimitives.createLineVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);
  var normalStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.NORMAL);
  var texCoordStream = vertexInfo.addStream(
      1, o3djs.base.o3d.Stream.TEXCOORD, 0);

  // Generate the individual vertices in our vertex buffer.
  for (var i = 0; i <= subdivisions; i++) {
    var theta = 2 * Math.PI * i / subdivisions;
    positionStream.addElement(radius * Math.cos(theta), 0,
                              radius * Math.sin(theta));
    normalStream.addElement(Math.cos(theta), 0, Math.sin(theta));
    texCoordStream.addElement(maxTexCoord * i / subdivisions);
  }

  // Connect the vertices by simple lines.
  for (var i = 0; i < subdivisions; i++) {
    vertexInfo.addLine(i, i+1);
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a ring.
 * The ring is a circle in the XZ plane, centered at the origin.
 * The created ring has position, normal, and 1-D texcoord streams.
 * The normals point outwards from the center of the ring.
 * The texture coordinates are based on angle about the center.
 *
 * @param {!o3d.Pack} pack Pack to create ring elements in.
 * @param {!o3d.Material} material Material to use.
 * @param {number} radius Radius of the ring.
 * @param {number} subdivisions Number of steps around the ring.
 * @param {number} maxTexCoord 1-D texture coordinates will range from 0 to
 *     this value, based on angle about the center.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3d.Shape} The created ring.
 */
o3djs.lineprimitives.createLineRing = function(
    pack,
    material,
    radius,
    subdivisions,
    maxTexCoord,
    opt_matrix) {
  var vertexInfo = o3djs.lineprimitives.createLineRingVertices(
      radius,
      subdivisions,
      maxTexCoord,
      opt_matrix);

  return vertexInfo.createShape(pack, material);
};

