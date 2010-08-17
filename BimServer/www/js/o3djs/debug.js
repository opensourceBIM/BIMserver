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
 * @fileoverview This file contains various functions to help debug for o3d
 * applications.
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.debug');

o3djs.require('o3djs.math');
o3djs.require('o3djs.primitives');

var O3D_DEBUG_PREFIX = 'o3dDebug_';
var O3D_DEBUG_PREFIX_LENGTH = O3D_DEBUG_PREFIX.length;
var O3D_DEBUG_COLOR_PARAM_NAME = O3D_DEBUG_PREFIX + 'Color';
var O3D_DEBUG_VECTOR_SCALE_PARAM_NAME =
    O3D_DEBUG_PREFIX + 'VectorScale';
var O3D_DEBUG_AXIS_SHAPE_NAME = O3D_DEBUG_PREFIX + 'AxisShape';
var O3D_DEBUG_LINE_SHAPE_NAME = O3D_DEBUG_PREFIX + 'LineShape';
var O3D_DEBUG_SPHERE_SHAPE_NAME = O3D_DEBUG_PREFIX + 'SphereShape';
var O3D_DEBUG_CUBE_SHAPE_NAME = O3D_DEBUG_PREFIX + 'CubeShape';

var O3D_DEBUG_AXIS_INFO_ = [
    {offset: [1, 0, 0], color: [1, 0, 0, 1]},
    {offset: [0, 1, 0], color: [0, 1, 0, 1]},
    {offset: [0, 0, 1], color: [0, 0, 1, 1]}];

/**
 * Checks whether or not a transform is a debug transform.
 * @param {!o3d.Transform} transform Transform to check.
 * @return {boolean} true if this transform is a debug transform.
 */
o3djs.debug.isDebugTransform = function(transform) {
  var name = transform.name;
  var isDT =
    name.length >= O3D_DEBUG_PREFIX_LENGTH &&
    name.substr(0, O3D_DEBUG_PREFIX_LENGTH) == O3D_DEBUG_PREFIX;
  return isDT;
};

/**
 * Gets the debug transform.
 * @private
 * @param {!o3d.Transform} transform Transform to get debug Transform
 *     from.
 * @param {string} name Name of debug transform to get.
 * @return {o3d.Transform} Debug Transform or null if not found.
 */
o3djs.debug.getDebugTransform_ = function(transform, name) {
  if (transform.name == name) {
    return transform;
  } else {
    var children = transform.children;
    for (var cc = 0; cc < children.length; ++cc) {
      if (children[cc].name == name) {
        return children[cc];
      }
    }
  }
  return null;
};

/**
 * Creates shaders that output the constant color from a parameter.
 * @private
 * @param {string} colorParamName Name of color parameter to use.
 * @return {string} Shader string.
 */
o3djs.debug.createColorShaders_ = function(colorParamName) {
  var shaders =
  'uniform float4 ' + colorParamName + ';\n' +
  'uniform float4x4 worldViewProjection: WORLDVIEWPROJECTION;\n' +
  'struct VertexShaderInput {\n' +
  '  float4 position : POSITION;\n' +
  '};\n' +
  'struct PixelShaderInput {\n' +
  '  float4 position : POSITION;\n' +
  '};\n' +
  'PixelShaderInput vertexShaderFunction(VertexShaderInput input) {\n' +
  '  PixelShaderInput output;\n' +
  '  output.position = mul(input.position, worldViewProjection);\n' +
  '  return output;\n' +
  '}\n' +
  'float4 pixelShaderFunction(PixelShaderInput input) : COLOR {\n' +
  '  return ' + colorParamName + ';\n' +
  '}\n' +
  '// #o3d VertexShaderEntryPoint vertexShaderFunction\n' +
  '// #o3d PixelShaderEntryPoint pixelShaderFunction\n' +
  '// #o3d MatrixLoadOrder RowMajor\n';
  return shaders;
};

/**
 * Creates shaders that output the constant color from a parameter and scale
 * the vertices in object space.
 * @private
 * @param {string} colorParamName Name of color parameter to use.
 * @param {string} scaleParamName Name of scale parameter to use.
 * @return {string} Shader string.
 */
o3djs.debug.createScaleShaders_ = function(colorParamName, scaleParamName) {
  var shaders =
  'uniform float4 ' + colorParamName + ';\n' +
  'uniform float3 ' + scaleParamName + ';\n' +
  'uniform float4x4 worldViewProjection: WORLDVIEWPROJECTION;\n' +
  'struct VertexShaderInput {\n' +
  '  float4 position : POSITION;\n' +
  '};\n' +
  'struct PixelShaderInput {\n' +
  '  float4 position : POSITION;\n' +
  '};\n' +
  'PixelShaderInput vertexShaderFunction(VertexShaderInput input) {\n' +
  '  PixelShaderInput output;\n' +
  '  float4 position = float4(\n' +
  '      input.position.x * ' + scaleParamName + '.x,\n' +
  '      input.position.y * ' + scaleParamName + '.y,\n' +
  '      input.position.z * ' + scaleParamName + '.z,\n' +
  '      1);\n' +
  '  output.position = mul(position, worldViewProjection);\n' +
  '  return output;\n' +
  '}\n' +
  'float4 pixelShaderFunction(PixelShaderInput input) : COLOR {\n' +
  '  return ' + colorParamName + ';\n' +
  '}\n' +
  '// #o3d VertexShaderEntryPoint vertexShaderFunction\n' +
  '// #o3d PixelShaderEntryPoint pixelShaderFunction\n' +
  '// #o3d MatrixLoadOrder RowMajor\n';
  return shaders;
};


/**
 * Defines a namespace for o3djs.debug.
 * @namespace
 */
o3djs.debug = o3djs.debug || {};

/**
 * Creates a line list shape and primitive given a material, vertex array and
 * index array.
 *
 * @param {!o3d.Pack} pack Pack to create objects in.
 * @param {!o3d.Material} material to use.
 * @param {!Array.<!o3djs.math.Vector3>} vertices array of numbers in the
 *     format positionX, positionY, positionZ.
 * @param {!Array.<number>} indices array of vertex indices, 2 per line.
 * @return {!o3d.Shape} The created shape.
 */
o3djs.debug.createLineShape = function(pack,
                                       material,
                                       vertices,
                                       indices) {
  // create a shape and primitive for the vertices.
  var shape = pack.createObject('Shape');
  var primitive = pack.createObject('Primitive');
  var streamBank = pack.createObject('StreamBank');
  primitive.owner = shape;
  primitive.streamBank = streamBank;

  // Apply the material
  primitive.material = material;

  primitive.numberPrimitives = indices.length / 2;
  primitive.primitiveType = o3djs.base.o3d.Primitive.LINELIST;
  primitive.numberVertices = vertices.length / 3;
  primitive.createDrawElement(pack, null);

  var vertexBuffer = pack.createObject('VertexBuffer');
  var positionField = vertexBuffer.createField('FloatField', 3);
  vertexBuffer.set(vertices);

  // Attach our buffers to our primitive.
  streamBank.setVertexStream(o3djs.base.o3d.Stream.POSITION,
                             0,
                             positionField,
                             0);

  var indexBuffer = pack.createObject('IndexBuffer');
  indexBuffer.set(indices);
  primitive.indexBuffer = indexBuffer;
  return shape;
};

/**
 * VertexInfo. Used to store vertices and indices.
 * @constructor
 * @param {!Array.<!o3djs.math.Vector3>} opt_vertices array of numbers in the
 *     format positionX, positionY, positionZ.
 * @param {!Array.<number>} opt_indices array of indices in pairs.
 */
o3djs.debug.VertexInfo = function(opt_vertices, opt_indices) {
  /**
   * The vertices for this VertexInfo.
   * @type {!Array.<o3djs.math.Vector3>}
   */
  this.vertices = opt_vertices || [];

  /**
   * The vertex indices this VertexInfo.
   * @type {!Array.<number>}
   */
  this.indices = opt_indices || [];
};

/**
 * Creates a new VertexInfo.
 * @param {!Array.<!o3djs.math.Vector3>} opt_vertices array of numbers in the
 *     format positionX, positionY, positionZ.
 * @param {!Array.<number>} opt_indices array of indices, 2 per line.
 * @return {!o3djs.debug.VertexInfo} The new VertexInfo.
 */
o3djs.debug.createVertexInfo = function(opt_vertices, opt_indices) {
  return new o3djs.debug.VertexInfo(opt_vertices, opt_indices);
};

/**
 * Enum for vertex component offsets.
 *
 * To get/set a vertex component you can do something like this.
 *
 * vertInfo.vertices[vertInfo.vertexIndex(index) + vertInfo.Offset.X] *= 2;
 *
 * @enum {number}
 */
o3djs.debug.VertexInfo.prototype.Offset = {
  X: 0,
  Y: 1,
  Z: 2
};

/**
 * Computes the number of vertices in this vertex info.
 * @return {number} The number of vertices.
 */
o3djs.debug.VertexInfo.prototype.numVertices = function() {
  return this.vertices.length / 3;
};


/**
 * Given the number of a vertex returns the index in the array where
 * the coordinates of that vertex vertexIndex.
 * @param {number} vertexNumber The vertex number.
 * @return {number} The index where that vertex begins.
 */
o3djs.debug.VertexInfo.prototype.vertexIndex = function(vertexNumber) {
  return vertexNumber * 3;
}

/**
 * Adds a vertex.
 * @param {number} positionX The x position of the vertex.
 * @param {number} positionY The y position of the vertex.
 * @param {number} positionZ The z position of the vertex.
 */
o3djs.debug.VertexInfo.prototype.addVertex = function(
    positionX, positionY, positionZ) {
  this.vertices.push(positionX, positionY, positionZ);
};

/**
 * Adds a line.
 * @param {number} index1 The index of the first vertex of the triangle.
 * @param {number} index2 The index of the second vertex of the triangle.
 */
o3djs.debug.VertexInfo.prototype.addLine = function(
    index1, index2) {
  this.indices.push(index1, index2);
};

/**
 * Creates a shape from a VertexInfo
 * @param {!o3d.Pack} pack Pack to create objects in.
 * @param {!o3d.Material} material to use.
 * @return {!o3d.Shape} The created shape.
 */
o3djs.debug.VertexInfo.prototype.createShape = function(
    pack,
    material) {
  return o3djs.debug.createLineShape(pack,
                                     material,
                                     this.vertices,
                                     this.indices);
};


/**
 * Reorients the vertex positions of this vertexInfo by the
 * given matrix. In other words it multiplies each vertex by the
 * given matrix.
 * @param {!o3djs.math.Matrix4} matrix Matrix to multiply by.
 */
o3djs.debug.VertexInfo.prototype.reorient = function(matrix) {
  var math = o3djs.math;
  var numVerts = this.numVertices();
  for (var v = 0; v < numVerts; ++v) {
    var index = this.vertexIndex(v);
    var position = [this.vertices[index + this.Offset.X],
                    this.vertices[index + this.Offset.Y],
                    this.vertices[index + this.Offset.Z],
                    1];
    position = math.mulVectorMatrix(position, matrix);
    this.vertices[index + this.Offset.X] = position[0];
    this.vertices[index + this.Offset.Y] = position[1];
    this.vertices[index + this.Offset.Z] = position[2];
  }
};

/**
 * Creates the vertices and indices for a cube of lines. The
 * cube will be created around the origin. (-size / 2, size / 2)
 * The created cube has a position stream only and can therefore only be used
 * with shaders that support those a position stream.
 *
 * @param {number} size Width, height and depth of the cube.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3djs.debug.VertexInfo} The created cube vertices.
 */
o3djs.debug.createLineCubeVertices = function(size, opt_matrix) {
  var k = size / 2;

  var vertices = [
    -k, -k, -k,
    +k, -k, -k,
    -k, +k, -k,
    +k, +k, -k,
    -k, -k, +k,
    +k, -k, +k,
    -k, +k, +k,
    +k, +k, +k
  ];

  var indices = [
    0, 1, 1, 3, 3, 2, 2, 0,
    4, 5, 5, 7, 7, 6, 6, 4,
    0, 4, 1, 5, 2, 6, 3, 7
  ];

  var vertexInfo = o3djs.debug.createVertexInfo(vertices, indices);
  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a cube of lines.
 * @param {!o3d.Pack} pack Pack to create sphere elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} size Width, height and depth of the cube.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3d.Shape} The created cube.
 */
o3djs.debug.createLineCube = function(pack,
                                      material,
                                      size,
                                      opt_matrix) {
  var vertexInfo = o3djs.debug.createLineCubeVertices(size, opt_matrix);
  return vertexInfo.createShape(pack, material);
};

/**
 * Creates sphere vertices.
 * The created sphere has a position stream only and can therefore only be
 * used with shaders that support those a position stream.
 *
 * @param {number} radius radius of the sphere.
 * @param {number} subdivisionsAxis number of steps around the sphere.
 * @param {number} subdivisionsHeight number of vertically on the sphere.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3djs.debug.VertexInfo} The created sphere vertices.
 */
o3djs.debug.createLineSphereVertices = function(radius,
                                                subdivisionsAxis,
                                                subdivisionsHeight,
                                                opt_matrix) {
  if (subdivisionsAxis <= 0 || subdivisionsHeight <= 0) {
    throw Error('subdivisionAxis and subdivisionHeight must be > 0');
  }

  // We are going to generate our sphere by iterating through its
  // spherical coordinates and generating 1 quad for each quad on a
  // ring of the sphere.

  var vertexInfo = o3djs.debug.createVertexInfo();

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
      vertexInfo.addVertex(radius * ux, radius * uy, radius * uz);
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
 * The created sphere has position, normal, uv and vertex color streams only
 * and can therefore only be used with shaders that support those 4
 * streams.
 *
 * @param {!o3d.Pack} pack Pack to create sphere elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} radius radius of the sphere.
 * @param {number} subdivisionsAxis number of steps around the sphere.
 * @param {number} subdivisionsHeight number of vertically on the sphere.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply all
 *     the vertices.
 * @return {!o3d.Shape} The created sphere.
 *
 * @see o3d.Pack
 * @see o3d.Shape
 */
o3djs.debug.createLineSphere = function(pack,
                                        material,
                                        radius,
                                        subdivisionsAxis,
                                        subdivisionsHeight,
                                        opt_matrix) {
  var vertexInfo = o3djs.debug.createLineSphereVertices(
      radius,
      subdivisionsAxis,
      subdivisionsHeight,
      opt_matrix);

  return vertexInfo.createShape(pack, material);
};

/**
 * An object to manage a single debug line.
 * @constructor
 * @param {!o3djs.debug.DebugLineGroup} debugLineGroup DebugLineGroup
 *     this line belongs too.
 */
o3djs.debug.DebugLine = function(debugLineGroup) {
  /**
   * The DebugLineGroup this DebugLine is managed by.
   * @private
   * @type {!o3djs.debug.DebugLineGroup}
   */
  this.debugLineGroup_ = debugLineGroup;
  var pack = debugLineGroup.getPack();

  /**
   * The transform for this DebugLine.
   * @private
   * @type {!o3d.Transform}
   */
  this.transform_ = pack.createObject('Transform');
  this.transform_.name = O3D_DEBUG_LINE_SHAPE_NAME;
  this.transform_.addShape(debugLineGroup.getLineShape());

  /**
   * The start position of the line.
   * @private
   * @type {!o3djs.math.Vector3}
   */
  this.start_ = [0, 0, 0];

  /**
   * The start position of the line.
   * @private
   * @type {!o3djs.math.Vector3}
   */
  this.end_ = [0, 0, 0];

  /**
   * The color param for the line.
   * @private
   * @type {!o3d.ParamFloat4}
   */
  this.colorParam_ = this.transform_.createParam(
      O3D_DEBUG_COLOR_PARAM_NAME, 'ParamFloat4');
  this.colorParam_.value = debugLineGroup.getColor();
};

/**
 * Destroys this line object cleaning up the resources used by it.
 */
o3djs.debug.DebugLine.prototype.destroy = function() {
  this.debugLineGroup_.getPack().removeObject(this.transform_);
};

/**
 * Returns a unique Id for the line.
 * @return {number} the Id of the line.
 */
o3djs.debug.DebugLine.prototype.getId = function() {
  return this.transform_.clientId;
};

/**
 * Updates the line with the current start and end settings.
 * @private
 */
o3djs.debug.DebugLine.prototype.update_ = function() {
  var math = o3djs.math;
  var vector = math.subVector(this.end_, this.start_);
  var direction = math.normalize(vector);
  var dot = math.dot(direction, [0, 1, 0]);
  var perp1;
  var perp2;
  if (dot > 0.99) {
    perp2 = math.cross([1, 0, 0], direction);
    perp1 = math.cross(perp2, direction);
  } else {
    perp1 = math.cross([0, 1, 0], direction);
    perp2 = math.cross(perp1, direction);
  }
  this.transform_.localMatrix =
      [perp2.concat(0),
       direction.concat(0),
       perp1.concat(0),
       this.start_.concat(1)];
  this.transform_.scale(1, math.length(vector), 1);
};

/**
 * Sets the end points of the DebugLine.
 * @param {!o3djs.math.Vector3} start Start point for line.
 * @param {!o3djs.math.Vector3} end End point for line.
 */
o3djs.debug.DebugLine.prototype.setEndPoints = function(start, end) {
  this.start_ = start;
  this.end_ = end;
  this.update_();
};

/**
 * Sets the start point of the DebugLine.
 * @param {!o3djs.math.Vector3} start Start point for line.
 */
 o3djs.debug.DebugLine.prototype.setStart = function(start) {
  this.start_ = start;
  this.update_();
};

/**
 * Sets the end point of the DebugLine.
 * @param {!o3djs.math.Vector3} end End point for line.
 */
o3djs.debug.DebugLine.prototype.setEnd = function(end) {
  this.end_ = end;
  this.update_();
};

/**
 * Sets the color of the DebugLine.
 * @param {!o3djs.math.Vector4} color The color of the debug line.
 */
o3djs.debug.DebugLine.prototype.setColor = function(color) {
  this.colorParam_.value = color;
};

/**
 * Sets the visibility of the DebugLine.
 * @param {boolean} visible True = visible.
 */
o3djs.debug.DebugLine.prototype.setVisible = function(visible) {
  this.transform_.parent = visible ? this.debugLineGroup_.getRoot() : null;
};

/**
 * Removes this line.
 */
o3djs.debug.DebugLine.prototype.remove = function() {
  this.transform_.parent = null;
  this.debugLineGroup_.remove(this);
};

/**
 * An object to manage debug lines.
 * @constructor
 * @param {!o3djs.debug.DebugHelper} debugHelper The DebugHelper
 *     associated with this object.
 * @param {!o3d.Transform} root Transform to put debug lines under.
 */
o3djs.debug.DebugLineGroup = function(debugHelper, root) {
  /**
   * The default color to make new lines.
   * @private
   * @type {!o3djs.math.Vector4}
   */
  this.currentColor_ = [1, 1, 1, 1];

  /**
   * The lines in this group indexed by clientId.
   * @private
   * @type {!Object.<number, !o3djs.debug.DebugLine>}
   */
  this.lineTransforms_ = { };

  /**
   * The unused lines in this group indexed by clientId.
   * @private
   * @type {!Object.<number, !o3djs.debug.DebugLine>}
   */
  this.freeLineTransforms_ = { };

  /**
   * The DebugHelper managing this DebugLineGroup.
   * @private
   * @type {!o3djs.debug.DebugHelper}
   */
  this.debugHelper_ = debugHelper;

  /**
   * The root transform for lines in this group.
   * @private
   * @type {!o3d.Transform}
   */
  this.root_ = root;
};

/**
 * Gets the root transform for this line group.
 * @return {!o3d.Transform} The root transform for this line group.
 */
o3djs.debug.DebugLineGroup.prototype.getRoot = function() {
  return this.root_;
};

/**
 * Gets the pack for this line group.
 * @return {!o3d.Pack} The pack for this line group.
 */
o3djs.debug.DebugLineGroup.prototype.getPack = function() {
  return this.debugHelper_.getPack();
};

/**
 * Gets the shape for lines.
 * @return {!o3d.Shape} The shape for lines.
 */
o3djs.debug.DebugLineGroup.prototype.getLineShape = function() {
  return this.debugHelper_.getLineShape();
};

/**
 * Gets the current color for this line group.
 * @return {!o3djs.math.Vector4} The current color.
 */
o3djs.debug.DebugLineGroup.prototype.getColor = function() {
  return this.currentColor_;
};

/**
 * Sets the current color for this line group.  All lines added after
 * setting this will be this color by default.
 * @param {!o3djs.math.Vector4} color The color for this line group.
 */
o3djs.debug.DebugLineGroup.prototype.setColor = function(color) {
  this.currentColor_ = color;
};

/**
 * Gets a debug line. If none exist creates a new one.
 * @private
 * @return {!o3djs.debug.DebugLine} The DebugLine.
 */
o3djs.debug.DebugLineGroup.prototype.getLine_ = function() {
  for (var sid in this.freeLineTransforms_) {
    var id = /** @type {number} */ (sid);
    var line = this.freeLineTransforms_[id];
    delete this.freeLineTransforms_[id];
    return line;
  }
  return new o3djs.debug.DebugLine(this);
};

/**
 * Adds a debug line.
 * @param {!o3djs.math.Vector3} opt_start Start position for line.
 * @param {!o3djs.math.Vector3} opt_end End position for line.
 * @param {!o3djs.math.Vector4} opt_color Color for line.
 * @return {!o3djs.debug.DebugLine} The DebugLine.
 */
o3djs.debug.DebugLineGroup.prototype.addLine = function(opt_start,
                                                        opt_end,
                                                        opt_color) {
  var line = this.getLine_();
  line.setEndPoints(opt_start || [0, 0, 0], opt_end || [0, 0, 0]);
  line.setColor(opt_color || this.currentColor_);
  line.setVisible(true);
  this.lineTransforms_[line.getId()] = line;
  return line;
};

/**
 * Clears all the lines in this group.
 */
o3djs.debug.DebugLineGroup.prototype.clear = function() {
  for (var sid in this.lineTransforms_) {
    var id = /** @type {number} */ (sid);
    var line = this.lineTransforms_[id];
    line.setVisible(false);
    this.freeLineTransforms_[id] = line;
  }
  this.lineTransforms_ = { };
};

/**
 * Destroys a DeubgLineGroup, freeing all its lines and resources.
 */
o3djs.debug.DebugLineGroup.prototype.destroy = function() {
  this.clear();
  for (var sid in this.freeLineTransforms_) {
    var id = /** @type {number} */ (sid);
    this.freeLineTransforms_[id].destroy();
  }
  this.freeLineTransforms_ = { };
};

/**
 * Removes a line.
 * @param {!o3djs.debug.DebugLine} line Line to remove.
 */
o3djs.debug.DebugLineGroup.prototype.remove = function(line) {
  var id = line.getId();
  delete this.lineTransforms_[id];
  this.freeLineTransforms_[id] = line;
};

/**
 * A Debug object to help with debugging o3d apps.
 *
 * A debug helper object provides functions to help debug your o3d
 * application and manages the resources needed to do that for you. For
 * example it can add axes, spheres and boxes to your transforms as well as
 * draw lines in 3d space given 2 points.
 *
 * @constructor
 * @param {!o3d.Pack} pack Pack for this debug object to use to manage
 *     its resources.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo ViewInfo for debug
 *     visuals.
 */
o3djs.debug.DebugHelper = function(pack, viewInfo) {
  this.pack_ = pack;
  this.viewInfo_ = viewInfo;
  this.axisPrimitives_ = [];
  this.axisShape_ = pack.createObject('Shape');
  this.axisShape_.name = O3D_DEBUG_AXIS_SHAPE_NAME;
  this.lineShape_ = pack.createObject('Shape');
  this.lineShape_.name = O3D_DEBUG_LINE_SHAPE_NAME;

  // Setup shape, material, primitive for axes.
  {
    // create a simple material for the axis.
    var effect = pack.createObject('Effect');
    var shaders = o3djs.debug.createScaleShaders_(
        O3D_DEBUG_COLOR_PARAM_NAME,
        O3D_DEBUG_VECTOR_SCALE_PARAM_NAME);
    effect.loadFromFXString(shaders);
    var material = pack.createObject('Material');
    material.effect = effect;
    material.drawList = viewInfo.performanceDrawList;
    effect.createUniformParameters(material);

    // Set the default color to white.
    material.getParam(O3D_DEBUG_COLOR_PARAM_NAME).value = [1, 1, 1, 1];

    // Set the default scale.
    material.getParam(O3D_DEBUG_VECTOR_SCALE_PARAM_NAME).value =
        [1, 1, 1];

    // Create the axis shape.
    for (var ii = 0; ii < O3D_DEBUG_AXIS_INFO_.length; ++ii) {
      var info = O3D_DEBUG_AXIS_INFO_[ii];
      var cubeShape = o3djs.primitives.createCube(pack,
                                                  material,
                                                  1,
                                                  [[1, 0, 0, 0],
                                                   [0, 1, 0, 0],
                                                   [0, 0, 1, 0],
                                                   [info.offset[0] * 0.5,
                                                    info.offset[1] * 0.5,
                                                    info.offset[2] * 0.5,
                                                    1]]);
      var cube = cubeShape.elements[0];
      cube.owner = this.axisShape_;
      pack.removeObject(cubeShape);
      cube.createParam(O3D_DEBUG_COLOR_PARAM_NAME, 'ParamFloat4').value =
          info.color;
      cube.createParam(O3D_DEBUG_VECTOR_SCALE_PARAM_NAME, 'ParamFloat3');
      this.axisPrimitives_[ii] = cube;
    }

    this.axisMaterial_ = material;
    this.setAxisScale(10, 1);
  }

  // Setup shape, material, primitive for debug lines.
  {
    // create a simple material for the debug lines.
    var effect = pack.createObject('Effect');
    var shaders = o3djs.debug.createColorShaders_(O3D_DEBUG_COLOR_PARAM_NAME);
    effect.loadFromFXString(shaders);
    var material = pack.createObject('Material');
    material.effect = effect;
    material.drawList = viewInfo.performanceDrawList;
    effect.createUniformParameters(material);

    // Set the default color to white.
    material.getParam(O3D_DEBUG_COLOR_PARAM_NAME).value = [1, 1, 1, 1];

    // Create the debug line shape.
    var vertices = [0, 0, 0, 0, 1, 0];
    var streamBank = pack.createObject('StreamBank');
    var primitive = pack.createObject('Primitive');
    var shape = pack.createObject('Shape');
    var vertexBuffer = pack.createObject('VertexBuffer');
    var positionField = vertexBuffer.createField('FloatField', 3);
    vertexBuffer.set(vertices);
    primitive.owner = shape;
    primitive.createDrawElement(pack, null);
    primitive.streamBank = streamBank;
    primitive.material = material;
    primitive.numberVertices = 2;
    primitive.numberPrimitives = 1;
    primitive.primitiveType = o3djs.base.o3d.Primitive.LINELIST;
    streamBank.setVertexStream(o3djs.base.o3d.Stream.POSITION,
                               0,
                               positionField,
                               0);
    this.lineShape_ = shape;
    this.lineShape_.name = O3D_DEBUG_LINE_SHAPE_NAME;
    this.lineMaterial_ = material;
  }

  {
    this.sphereShape_ = o3djs.debug.createLineSphere(pack,
                                                     this.axisMaterial_,
                                                     0.5, 8, 8);
    this.sphereShape_.name = O3D_DEBUG_SPHERE_SHAPE_NAME;
    var primitive = this.sphereShape_.elements[0];
    this.sphereScaleParam_ = primitive.createParam(
        O3D_DEBUG_VECTOR_SCALE_PARAM_NAME,
        'ParamFloat3').value = [1, 1, 1];
  }

  {
    this.cubeShape_ = o3djs.debug.createLineCube(pack,
                                                 this.axisMaterial_,
                                                 1);
    this.cubeShape_.name = O3D_DEBUG_CUBE_SHAPE_NAME;
    var primitive = this.cubeShape_.elements[0];
    this.cubeScaleParam_ = primitive.createParam(
        O3D_DEBUG_VECTOR_SCALE_PARAM_NAME,
        'ParamFloat3').value = [1, 1, 1];
  }
};


/**
 * Gets the pack for this DebugHelper.
 * @return {!o3d.Pack} The pack for this DebugHelper.
 */
o3djs.debug.DebugHelper.prototype.getPack = function() {
  return this.pack_;
};

/**
 * Gets the line shape.
 * @return {!o3d.Shape} The shape for debug lines.
 */
o3djs.debug.DebugHelper.prototype.getLineShape = function() {
  return this.lineShape_;
};

/**
 * Sets the length and width of the axis lines.
 * @param {number} length Length of an axis in the direction of the axis.
 * @param {number} width Width of the axis or its thickness.
 */
o3djs.debug.DebugHelper.prototype.setAxisScale = function(length,
                                                          width) {
  for (var ii = 0; ii < O3D_DEBUG_AXIS_INFO_.length; ++ii) {
    var info = O3D_DEBUG_AXIS_INFO_[ii];
    this.axisPrimitives_[ii].getParam(
        O3D_DEBUG_VECTOR_SCALE_PARAM_NAME).value = [
            info.offset[0] ? length : width,
            info.offset[1] ? length : width,
            info.offset[2] ? length : width];
  }
};

/**
 * Creates a debug shape at a world position.
 * @private
 * @param {!o3djs.math.Vector3} position Position at which to create shape.
 * @param {!o3d.Shape} shape Shape to add to transform.
 * @return {!o3d.Transform} transform for shape.
 */
o3djs.debug.DebugHelper.prototype.createShape_ = function(position, shape) {

  var debugTransform = this.getPack().createObject('Transform');
  debugTransform.name = shape.name;
  debugTransform.addShape(shape);
  debugTransform.parent = this.viewInfo_.treeRoot;
  debugTransform.translate(position);
  return debugTransform;
};

/**
 * Adds an debug shape to a transform.
 * @private
 * @param {!o3d.Transform} transform Transform to add shape to.
 * @param {!o3d.Shape} shape Shape to add to transform.
 */
o3djs.debug.DebugHelper.prototype.addShape_ = function(transform,
                                                       shape) {

  var debugTransform = o3djs.debug.getDebugTransform_(transform, shape.name);
  if (!debugTransform) {
    var debugTransform = this.getPack().createObject('Transform');
    debugTransform.name = shape.name;
    debugTransform.addShape(shape);
    debugTransform.parent = transform;
  }
};

/**
 * Removes a debug shape from a transform
 * @private
 * @param {!o3d.Transform} transform Transform to remove shape from.
 * @param {!o3d.Shape} shape Shape to remove from transform.
 */
o3djs.debug.DebugHelper.prototype.removeShape_ = function(transform,
                                                          shape) {
  var name = shape.name;
  var debugTransform = o3djs.debug.getDebugTransform_(transform, shape.name);
  if (debugTransform) {
    debugTransform.parent = null;
    this.getPack().removeObject(debugTransform);
  }
};

/**
 * Adds a debug shape to all transform a tree.
 * @private
 * @param {!o3d.Transform} treeRoot root of tree to add shape to.
 * @param {!o3d.Shape} shape Shape to add to transforms.
 */
o3djs.debug.DebugHelper.prototype.addShapes_ = function(treeRoot,
                                                        shape) {
  this.addShape_(treeRoot, shape);
  var children = treeRoot.children;
  for (var cc = 0; cc < children.length; ++cc) {
    var child = children[cc];
    if (!o3djs.debug.isDebugTransform(child)) {
      this.addShapes_(child, shape);
    }
  }
};

/**
 * Removes a debug shape from all transforms in a tree.
 * @private
 * @param {!o3d.Transform} treeRoot root of tree to remove axes from.
 * @param {!o3d.Shape} shape Shape to remove from transforms.
 */
o3djs.debug.DebugHelper.prototype.removeShapes_ = function(treeRoot,
                                                           shape) {
  this.removeShape_(treeRoot, shape);
  var children = treeRoot.children;
  for (var cc = 0; cc < children.length; ++cc) {
    var child = children[cc];
    if (!o3djs.debug.isDebugTransform(child)) {
      this.removeShapes_(child, shape);
    }
  }
};

/**
 * Sets a param value on a debug transform. If the param does not exist it
 * will be created.
 * @private
 * @param {!o3d.Transform} transform Transform on which debug transform
 *     exists.
 * @param {string} name Name of debug transform.
 * @param {string} paramName Name of param to set.
 * @param {string} paramType type of param to set.
 * @param {*} paramValue value to set param.
 */
o3djs.debug.DebugHelper.prototype.addSetDebugTransformParam_ = function(
    transform,
    name,
    paramName,
    paramType,
    paramValue) {
  var debugTransform = o3djs.debug.getDebugTransform_(transform, name);
  if (debugTransform) {
    var param = debugTransform.getParam(paramName);
    if (!param) {
      param = debugTransform.createParam(paramName, paramType);
    }
    param.value = paramValue;
  }
};

/**
 * Adds an axis to a transform.
 * @param {!o3d.Transform} transform Transform to add axis to.
 */
o3djs.debug.DebugHelper.prototype.addAxis = function(transform) {
  this.addShape_(transform, this.axisShape_);
};

/**
 * Removes an axis from a transform
 * @param {!o3d.Transform} transform Transform to remove axis from.
 */
o3djs.debug.DebugHelper.prototype.removeAxis = function(transform) {
  this.removeShape_(transform, this.axisShape_);
};

/**
 * Adds axes to all transform in a tree.
 * @param {!o3d.Transform} treeRoot root of tree to add axes to.
 */
o3djs.debug.DebugHelper.prototype.addAxes = function(treeRoot) {
  this.addShapes_(treeRoot, this.axisShape_);
};

/**
 * Removes axes from all transforms in a tree.
 * @param {!o3d.Transform} treeRoot root of tree to remove axes from.
 */
o3djs.debug.DebugHelper.prototype.removeAxes = function(treeRoot) {
  this.removeShapes_(treeRoot, this.axisShape_);
};

/**
 * Set axis color.
 * @param {!o3d.Transform} transform Transform on which to change axis
 *     color.
 * @param {!o3djs.math.Vector4} color 4 number array in RGBA format.
 */
o3djs.debug.DebugHelper.prototype.setAxisColor = function(transform,
                                                          color) {
  this.addSetDebugTransformParam_(transform,
                                  O3D_DEBUG_AXIS_SHAPE_NAME,
                                  O3D_DEBUG_COLOR_PARAM_NAME,
                                  'ParamFloat4',
                                  color);
};

/**
 * Removes the color from an axis.
 * @param {!o3d.Transform} transform Transform on which to remove color.
 */
o3djs.debug.DebugHelper.prototype.clearAxisColor = function(transform) {
  var debugTransform = o3djs.debug.getDebugTransform_(
      transform,
      O3D_DEBUG_AXIS_SHAPE_NAME);
  if (debugTransform) {
    var colorParam = debugTransform.getParam(O3D_DEBUG_COLOR_PARAM_NAME);
    if (colorParam) {
      debugTransform.removeParam(colorParam);
    }
  }
};

/**
 * Creates a sphere in world space.
 * @param {!o3djs.math.Vector3} position Position at which to create sphere.
 * @param {!o3djs.math.Vector4} opt_color RGBA color for sphere.
 * @param {number} opt_scale of sphere.
 * @return {!o3d.Transform} transform for sphere.
 */
o3djs.debug.DebugHelper.prototype.createSphere = function(position,
                                                          opt_color,
                                                          opt_scale) {
  var transform = this.createShape_(position, this.sphereShape_);
  if (opt_color) {
    this.setSphereColor(transform, opt_color);
  }
  if (opt_scale) {
    this.setSphereScale(transform, opt_scale);
  }
  return transform;
};

/**
 * Adds a sphere to a transform.
 * @param {!o3d.Transform} transform Transform to add sphere to.
 * @param {!o3djs.math.Vector4} opt_color RGBA color for sphere.
 * @param {number} opt_scale of sphere.
 */
o3djs.debug.DebugHelper.prototype.addSphere = function(transform,
                                                       opt_color,
                                                       opt_scale) {
  this.addShape_(transform, this.sphereShape_);
  if (opt_color) {
    this.setSphereColor(transform, opt_color);
  }
  if (opt_scale) {
    this.setSphereScale(transform, opt_scale);
  }
};

/**
 * Removes a sphere from a transform
 * @param {!o3d.Transform} transform Transform to remove sphere from.
 */
o3djs.debug.DebugHelper.prototype.removeSphere = function(transform) {
  this.removeShape_(transform, this.sphereShape_);
};

/**
 * Adds spheres to all transform a tree.
 * @param {!o3d.Transform} treeRoot root of tree to add spheres to.
 */
o3djs.debug.DebugHelper.prototype.addSpheres = function(treeRoot) {
  this.addShapes_(treeRoot, this.sphereShape_);
};

/**
 * Removes spheres from all transforms in a tree.
 * @param {!o3d.Transform} treeRoot root of tree to remove spheres from.
 */
o3djs.debug.DebugHelper.prototype.removeSpheres = function(treeRoot) {
  this.removeShapes_(treeRoot, this.sphereShape_);
};

/**
 * Set sphere color.
 * @param {!o3d.Transform} transform Transform on which to change sphere
 *     color.
 * @param {!o3djs.math.Vector4} color 4 number array in RGBA format.
 */
o3djs.debug.DebugHelper.prototype.setSphereColor = function(transform,
                                                            color) {
  this.addSetDebugTransformParam_(transform,
                                  O3D_DEBUG_SPHERE_SHAPE_NAME,
                                  O3D_DEBUG_COLOR_PARAM_NAME,
                                  'ParamFloat4',
                                  color);
};

/**
 * Sets the scale of a debug sphere.
 * @param {!o3d.Transform} transform Transform on which to change sphere
 *     scale.
 * @param {number} scale Scale to make the sphere.
 */
o3djs.debug.DebugHelper.prototype.setSphereScale = function(transform,
                                                            scale) {
  this.addSetDebugTransformParam_(transform,
                                  O3D_DEBUG_SPHERE_SHAPE_NAME,
                                  O3D_DEBUG_VECTOR_SCALE_PARAM_NAME,
                                  'ParamFloat3',
                                  [scale, scale, scale]);
};

/**
 * Creates a cube at a world position..
 * @param {!o3djs.math.Vector3} position Position at which to create sphere.
 * @param {!o3djs.math.Vector4} opt_color RGBA color for cube.
 * @param {number} opt_scale of cube.
 * @return {!o3d.Transform} transform for cube.
 */
o3djs.debug.DebugHelper.prototype.createCube = function(position,
                                                        opt_color,
                                                        opt_scale) {
  var transform = this.createShape_(position, this.cubeShape_);
  if (opt_color) {
    this.setCubeColor(transform, opt_color);
  }
  if (opt_scale) {
    this.setCubeScale(transform, opt_scale);
  }
  return transform;
};

/**
 * Adds a cube to a transform.
 * @param {!o3d.Transform} transform Transform to add cube to.
 * @param {!o3djs.math.Vector4} opt_color RGBA color for cube.
 * @param {number} opt_scale of cube.
 */
o3djs.debug.DebugHelper.prototype.addCube = function(transform,
                                                     opt_color,
                                                     opt_scale) {
  this.addShape_(transform, this.cubeShape_);
  if (opt_color) {
    this.setCubeColor(transform, opt_color);
  }
  if (opt_scale) {
    this.setCubeScale(transform, opt_scale);
  }
};

/**
 * Removes a cube from a transform
 * @param {!o3d.Transform} transform Transform to remove cube from.
 */
o3djs.debug.DebugHelper.prototype.removeCube = function(transform) {
  this.removeShape_(transform, this.cubeShape_);
};

/**
 * Adds cubes to all transform in a tree.
 * @param {!o3d.Transform} treeRoot root of tree to add cubes to.
 */
o3djs.debug.DebugHelper.prototype.addCubes = function(treeRoot) {
  this.addShapes_(treeRoot, this.cubeShape_);
};

/**
 * Removes cubes from all transforms in a tree.
 * @param {!o3d.Transform} treeRoot root of tree to remove cubes from.
 */
o3djs.debug.DebugHelper.prototype.removeCubes = function(treeRoot) {
  this.removeShapes_(treeRoot, this.cubeShape_);
};

/**
 * Set cube color.
 * @param {!o3d.Transform} transform Transform on which to change cube
 *     color.
 * @param {!o3djs.math.Vector3} color 4 number array in RGBA format.
 */
o3djs.debug.DebugHelper.prototype.setCubeColor = function(transform,
                                                          color) {
  this.addSetDebugTransformParam_(transform,
                                  O3D_DEBUG_CUBE_SHAPE_NAME,
                                  O3D_DEBUG_COLOR_PARAM_NAME,
                                  'ParamFloat4',
                                  color);
};

/**
 * Sets the scale of a cubes.
 * @param {!o3d.Transform} transform Transform on which to change cube
 *     scale.
 * @param {number} scale Scale to make the cube.
 */
o3djs.debug.DebugHelper.prototype.setCubeScale = function(transform,
                                                          scale) {
  this.addSetDebugTransformParam_(transform,
                                  O3D_DEBUG_CUBE_SHAPE_NAME,
                                  O3D_DEBUG_VECTOR_SCALE_PARAM_NAME,
                                  'ParamFloat3',
                                  [scale, scale, scale]);
};

/**
 * Creates a debug line group. A Debug line group's purpose is the let you
 * quickly delete a set of lines.
 * @param {!o3d.Transform} root Root transform to use for lines.
 * @return {!o3djs.debug.DebugLineGroup} The debug line group.
 */
o3djs.debug.DebugHelper.prototype.createDebugLineGroup =
    function(root) {
  return new o3djs.debug.DebugLineGroup(this, root);
};

/**
 * Creates a debug helper object.
 *
 * A debug helper object provides functions to help debug your o3d
 * application and manages the resources needed to do that for you. For
 * example it can add axes, spheres and boxes to your transforms as well as
 * draw lines in 3d space given 2 points.
 *
 * @param {!o3d.Pack} pack Pack for DebugHelper to manage its resources
 *      with.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo ViewInfo for debug
 *     visuals.
 * @return {!o3djs.debug.DebugHelper} the DebugHelper object.
 */
o3djs.debug.createDebugHelper = function(pack, viewInfo) {
  return new o3djs.debug.DebugHelper(pack, viewInfo);
};

