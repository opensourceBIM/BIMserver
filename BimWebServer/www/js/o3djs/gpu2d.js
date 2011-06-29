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
 * @fileoverview This file provides GPU-accelerated rendering of 2D
 * vector graphics in 3D.
 */
o3djs.provide('o3djs.gpu2d');

o3djs.require('o3djs.base');

/**
 * A module providing GPU-accelerated rendering of 2D vector graphics
 * in 3D.
 * @namespace
 */
o3djs.gpu2d = o3djs.gpu2d || {};

/**
 * Creates a new Path, which holds one or more closed contours
 * composed of 2D primitives like lines, quadratic curves, and cubic
 * curves.
 * @param {!o3d.Pack} pack Pack in which geometry and materials
 *     associated with the curves will be created.
 * @param {!o3d.DrawList} drawList The DrawList on which the triangle
 *     mesh will be drawn. Typically this will be the
 *     zOrderedDrawList from an o3djs.rendergraph.ViewInfo.
 * @return {!o3djs.gpu2d.Path} The created Path.
 */
o3djs.gpu2d.createPath = function(pack,
                                  drawList) {
  return new o3djs.gpu2d.Path(pack, drawList);
};

/**
 * Constructs a new Path. Do not call this directly; use
 * o3djs.gpu2d.createPath instead.
 * @param {!o3d.Pack} pack Pack in which geometry and materials
 *     associated with the curves will be created.
 * @param {!o3d.DrawList} drawList The DrawList on which the triangle
 *     mesh will be drawn. Typically this will be the
 *     zOrderedDrawList.
 * @constructor
 */
o3djs.gpu2d.Path = function(pack, drawList) {
  /**
   * Pack in which curves' geometry and materials are created.
   * @type {!o3d.Pack}
   * @private
   */
  this.pack_ = pack;

  /**
   * DrawList in which curves' geometry and materials will be
   * rendered.
   * @type {!o3d.DrawList}
   * @private
   */
  this.drawList_ = drawList;

  /**
   * Internal object which manages the triangle mesh associated with
   * the curves.
   * @type {!o3d.ProcessedPath}
   * @private
   */
  this.path_ = pack.createObject('ProcessedPath');

  // Set up the Primitives in the ProcessedPath.
  //
  // The mesh is separated into two different regions. The exterior
  // region of the mesh is the portion containing the cubic curve
  // segments. It is this region whose alpha value is computed using
  // Loop and Blinn's shader. The interior region of the mesh is
  // simply filled with a constant alpha. The reason for the split is
  // that it is difficult to assign texture coordinates to cause Loop
  // and Blinn's shader to fill a region with constant alpha. While
  // there is some cost associated with switching shaders and
  // performing two draw calls, doing so simplifies the logic.

  // Create state objects so we can turn on alpha blending for the
  // exterior triangles. We also disable backface culling so that we
  // can view the vector shapes from both sides.
  var exteriorState = pack.createObject('State');
  exteriorState.getStateParam('o3d.AlphaBlendEnable').value = true;
  exteriorState.getStateParam('o3d.SourceBlendFunction').value =
      o3djs.base.o3d.State.BLENDFUNC_SOURCE_ALPHA;
  exteriorState.getStateParam('o3d.DestinationBlendFunction').value =
      o3djs.base.o3d.State.BLENDFUNC_INVERSE_SOURCE_ALPHA;
  exteriorState.getStateParam('o3d.CullMode').value =
      o3djs.base.o3d.State.CULL_NONE;

  var interiorState = pack.createObject('State');
  interiorState.getStateParam('o3d.CullMode').value =
      o3djs.base.o3d.State.CULL_NONE;

  // Create the materials for the exterior and interior regions.

  /**
   * The material for the exterior triangles, filled with Loop and
   * Blinn's shader.
   * @type {!o3d.Material}
   * @private
   */
  this.exteriorMaterial_ = pack.createObject('Material');
  this.exteriorMaterial_.name = 'ExteriorMaterial';
  this.exteriorMaterial_.state = exteriorState;
  this.exteriorMaterial_.drawList = drawList;

  /**
   * The material for the interior triangles, filled with a solid
   * shader.
   * @type {!o3d.Material}
   * @private
   */
  this.interiorMaterial_ = pack.createObject('Material');
  this.interiorMaterial_.name = 'InteriorMaterial';
  this.interiorMaterial_.state = interiorState;
  this.interiorMaterial_.drawList = drawList;

  /**
   * The Shape which is the transform graph's view of the Path.
   * @type {!o3d.Shape}
   */
  this.shape = pack.createObject('Shape');

  // Create the exterior region.
  var primitive = pack.createObject('Primitive');
  var streamBank = pack.createObject('StreamBank');
  var vertexBuffer = pack.createObject('VertexBuffer');
  // The coordinates of the triangles are 2D
  var vertices = vertexBuffer.createField('FloatField', 2);
  /**
   * The Field for the exterior vertices.
   * @type {!o3d.FloatField}
   * @private
   */
  this.exteriorVertices_ = vertices;
  // The (Loop/Blinn) texture coordinates are 3D
  var texcoords = vertexBuffer.createField('FloatField', 3);
  /**
   * The Field for the exterior texture coordinates.
   * @type {!o3d.FloatField}
   * @private
   */
  this.exteriorTexCoords_ = texcoords;
  streamBank.setVertexStream(o3djs.base.o3d.Stream.POSITION, 0, vertices, 0);
  streamBank.setVertexStream(o3djs.base.o3d.Stream.TEXCOORD, 0, texcoords, 0);
  primitive.streamBank = streamBank;
  primitive.primitiveType = o3djs.base.o3d.Primitive.TRIANGLELIST;
  primitive.material = this.exteriorMaterial_;
  primitive.owner = this.shape;
  /**
   * The Primitive for the exterior triangles.
   * @type {!o3d.Primitive}
   * @private
   */
  this.exteriorTriangles_ = primitive;

  // Create the interior region.
  primitive = pack.createObject('Primitive');
  streamBank = pack.createObject('StreamBank');
  vertexBuffer = pack.createObject('VertexBuffer');
  // The coordinates of the triangles are 2D
  vertices = vertexBuffer.createField('FloatField', 2);
  /**
   * The Field for the interior vertices.
   * @type {!o3d.FloatField}
   * @private
   */
  this.interiorVertices_ = vertices;
  streamBank.setVertexStream(o3djs.base.o3d.Stream.POSITION, 0, vertices, 0);
  primitive.streamBank = streamBank;
  primitive.primitiveType = o3djs.base.o3d.Primitive.TRIANGLELIST;
  primitive.material = this.interiorMaterial_;
  primitive.owner = this.shape;
  /**
   * The Primitive for the interior triangles.
   * @type {!o3d.Primitive}
   * @private
   */
  this.interiorTriangles_ = primitive;

  // Initialize the fill to a solid color.
  this.setFill(o3djs.gpu2d.createColor(pack, 0.0, 0.0, 0.0, 1.0));

  // Create draw elements for the shape.
  this.shape.createDrawElements(pack, null);
};

/**
 * Clears out any previously added segments or generated triangles
 * from this Path.
 */
o3djs.gpu2d.Path.prototype.clear = function() {
  this.path_.clear();
};

/**
 * Moves the pen to the given absolute X,Y coordinates. If a contour
 * isn't currently open on this path, one is opened.
 * @param {number} x the x coordinate to move to.
 * @param {number} y the y coordinate to move to.
 */
o3djs.gpu2d.Path.prototype.moveTo = function(x, y) {
  this.path_.moveTo(x, y);
};

/**
 * Draws a line from the current coordinates to the given absolute
 * X,Y coordinates.
 * @param {number} x the x coordinate to draw a line to.
 * @param {number} y the y coordinate to draw a line to.
 */
o3djs.gpu2d.Path.prototype.lineTo = function(x, y) {
  this.path_.lineTo(x, y);
};

/**
 * Draws a quadratic curve from the current coordinates through the
 * given control point and end point, specified in absolute
 * coordinates.
 * @param {number} cx the x coordinate of the quadratic's control point
 * @param {number} cy the y coordinate of the quadratic's control point
 * @param {number} x the x coordinate of the quadratic's end point
 * @param {number} y the y coordinate of the quadratic's end point
 */
o3djs.gpu2d.Path.prototype.quadraticTo = function(cx, cy, x, y) {
  this.path_.quadraticTo(cx, cy, x, y);
};

/**
 * Draws a cubic curve from the current coordinates through the
 * given control points and end point, specified in absolute
 * coordinates.
 * @param {number} c0x the x coordinate of the cubic's first control point
 * @param {number} c0y the y coordinate of the cubic's first control point
 * @param {number} c1x the x coordinate of the cubic's second control point
 * @param {number} c1y the y coordinate of the cubic's second control point
 * @param {number} x the x coordinate of the cubic's end point
 * @param {number} y the y coordinate of the cubic's end point
 */
o3djs.gpu2d.Path.prototype.cubicTo = function(c0x, c0y, c1x, c1y, x, y) {
  this.path_.cubicTo(c0x, c0y, c1x, c1y, x, y);
};

/**
 * Closes the current contour on this Path.
 */
o3djs.gpu2d.Path.prototype.close = function() {
  this.path_.close();
};

/**
 * Updates the triangle mesh associated with this Path. Call this
 * after adding any new segments to the Path.
 */
o3djs.gpu2d.Path.prototype.update = function() {
  this.path_.createMesh(this.exteriorVertices_,
                        this.exteriorTexCoords_,
                        this.interiorVertices_);
  var numVertices = this.exteriorVertices_.buffer.numElements;
  if (numVertices == 1) {
    this.exteriorTriangles_.numberVertices = 0;
    this.exteriorTriangles_.numberPrimitives = 0;
  } else {
    this.exteriorTriangles_.numberVertices = numVertices;
    this.exteriorTriangles_.numberPrimitives = numVertices / 3;
  }
  numVertices = this.interiorVertices_.buffer.numElements;
  if (numVertices == 1) {
    this.interiorTriangles_.numberVertices = 0;
    this.interiorTriangles_.numberPrimitives = 0;
  } else {
    this.interiorTriangles_.numberVertices = numVertices;
    this.interiorTriangles_.numberPrimitives = numVertices / 3;
  }
};

/**
 * Sets the polygon offset parameters for the triangles associated
 * with this Path.
 * @param {number} slopeFactor polygon offset slope factor.
 * @param {number} depthBias polygon offset depth bias.
 */
o3djs.gpu2d.Path.prototype.setPolygonOffset = function(slopeFactor,
                                                       depthBias) {
  this.exteriorMaterial_.state.getStateParam('o3d.PolygonOffset1').value =
      slopeFactor;
  this.exteriorMaterial_.state.getStateParam('o3d.PolygonOffset2').value =
      depthBias;
  this.interiorMaterial_.state.getStateParam('o3d.PolygonOffset1').value =
      slopeFactor;
  this.interiorMaterial_.state.getStateParam('o3d.PolygonOffset2').value =
      depthBias;
}

//----------------------------------------------------------------------
// Fills

/**
 * Sets the fill for this Path.
 * @param {!o3djs.gpu2d.Fill} fill the fill for this Path.
 */
o3djs.gpu2d.Path.prototype.setFill = function(fill) {
  if (this.fill_) {
    this.fill_.detach_(this);
  }
  this.interiorMaterial_.effect = fill.interiorEffect;
  this.exteriorMaterial_.effect = fill.exteriorEffect;
  this.fill_ = fill;
  fill.attach_(this);
};

/**
 * Base class for all Fills. Do not call this directly; use, for
 * example, o3djs.gpu2d.createColor instead.
 * @param {!o3d.Pack} pack the Pack in which to create materials.
 * @constructor
 */
o3djs.gpu2d.Fill = function(pack) {
  this.pack_ = pack;
  this.attachedPaths_ = [];
};

/**
 * Attaches this Fill to the given path.
 * @param {!o3djs.gpu2d.Path} path Path to attach the fill to.
 * @private
 */
o3djs.gpu2d.Fill.prototype.attach_ = function(path) {
  if (this.attachedPaths_.indexOf(path) < 0)
    this.attachedPaths_.push(path);
  this.apply_(path);
};

/**
 * Detaches this Fill from the given path.
 * @param {!o3djs.gpu2d.Path} path Path to detach the fill from.
 * @private
 */
o3djs.gpu2d.Fill.prototype.detach_ = function(path) {
  var idx = this.attachedPaths_.indexOf(path);
  if (idx >= 0)
    this.attachedPaths_.splice(idx, idx);
};

/**
 * Applies this Fill to all attached paths.
 * @private
 */
o3djs.gpu2d.Fill.prototype.applyToPaths_ = function() {
  for (var i = 0; i < this.attachedPaths_.length; i++) {
    this.apply_(this.attachedPaths_[i]);
  }
};

/**
 * Base "apply" operation for fills -- a no-op.
 * @private
 */
o3djs.gpu2d.Fill.prototype.apply_ = function(path) {
};

/**
 * A class for a solid color fill. Do not call this directly; use
 * o3djs.gpu2d.createColor instead.
 * @param {!o3d.Pack} pack the Pack in which to create materials.
 * @constructor
 * @extends {o3djs.gpu2d.Fill}
 */
o3djs.gpu2d.Color = function(pack) {
  o3djs.gpu2d.Fill.call(this, pack);
  this.interiorEffect =
    o3djs.gpu2d.loadEffect_(pack, o3djs.gpu2d.FillTypes_.COLOR, true);
  this.exteriorEffect =
    o3djs.gpu2d.loadEffect_(pack, o3djs.gpu2d.FillTypes_.COLOR, false);
  this.r_ = 0.0;
  this.g_ = 0.0;
  this.b_ = 0.0;
  this.a_ = 1.0;
};

o3djs.base.inherit(o3djs.gpu2d.Color,
                   o3djs.gpu2d.Fill);

/**
 * Sets the color of this fill.
 * @param {number} r Red component (0.0 - 1.0).
 * @param {number} g Green component (0.0 - 1.0).
 * @param {number} b Blue component (0.0 - 1.0).
 * @param {number} a Alpha component (0.0 - 1.0).
 */
o3djs.gpu2d.Color.prototype.set = function(r, g, b, a) {
  this.r_ = r;
  this.g_ = g;
  this.b_ = b;
  this.a_ = a;
  this.applyToPaths_();
};

/**
 * Gets the value of the Color fill as an array.
 * @return {!o3d.Float4}
 */
o3djs.gpu2d.Color.prototype.get = function() {
  return [this.r_, this.g_, this.b_, this.a_];
};

/**
 * Applies this color to the given path.
 * @param {!o3djs.gpu2d.Path} path to apply the fill to.
 * @private
 */
o3djs.gpu2d.Color.prototype.apply_ = function(path) {
  this.applyToMaterial_(path.interiorMaterial_);
  this.applyToMaterial_(path.exteriorMaterial_);
};

/**
 * Applies this color to the given material
 * @param {!o3d.Material} material to apply the fill to.
 * @private
 */
o3djs.gpu2d.Color.prototype.applyToMaterial_ = function(material) {
  var paramName = 'color';
  var paramType = 'ParamFloat4';
  var param = material.getParam(paramName);
  if (!param) {
    param = material.createParam(paramName, paramType);
  }
  param.set(this.r_, this.g_, this.b_, this.a_);
};

/**
 * Creates a solid color fill.
 * @param {!o3d.Pack} pack the Pack in which to create materials.
 * @param {number} red Red component (0.0 - 1.0).
 * @param {number} green Green component (0.0 - 1.0).
 * @param {number} blue Blue component (0.0 - 1.0).
 * @param {number} alpha Alpha component (0.0 - 1.0).
 * @return {!o3djs.gpu2d.Color} The created Color.
 */
o3djs.gpu2d.createColor = function(pack, red, green, blue, alpha) {
  var result = new o3djs.gpu2d.Color(pack);
  result.set(red, green, blue, alpha);
  return result;
};

//----------------------------------------------------------------------
// Shaders and effects

// TODO(kbr): antialiasing in the Cg backend is not supported yet
// because the ddx and ddy instructions are not part of the shader
// model 2.0. On Windows we could easily upgrade to ps2.0a, but on Mac
// and Linux there isn't an easy upgrade path from ARBVP1.0 and
// ARBFP1.0 which incorporates these instructions.
//
// The solution within O3D is to compute the gradients using the
// closed-form solution in Loop and Blinn's SIGGRAPH '05 paper. This
// requires computation of the Psi matrix per vertex. In GLSL this is
// not necessary; derivative instructions are always available there.

/**
 * Generates the source for the shader used on the exterior triangles
 * of the shape -- the ones that evaluate the curve function.
 * @param {boolean} antialias whether to enable antialiasing.
 * @param {string} fillUniforms the uniforms for the fill.
 * @param {string} fillSource the source code snippet for the fill.
 * @return {string}
 * @private
 */
o3djs.gpu2d.generateLoopBlinnShaderSource_ = function(antialias,
                                                      fillUniforms,
                                                      fillSource) {
  if (o3djs.base.glsl) {
    var result = '' +
      '// Vertex shader\n' +
      'uniform mat4 worldViewProjection;\n' +
      '\n' +
      'attribute vec2 position;\n' +
      'attribute vec3 texCoord0;\n' +
      '\n' +
      'varying vec3 klm;\n' +
      '\n' +
      'void main() {\n' +
      '  // TODO(kbr): figure out why this multiplication needs to be\n' +
      '  // transposed compared to the Cg version.\n' +
      '  gl_Position = worldViewProjection * vec4(position, 0.0, 1.0);\n' +
      '  klm = texCoord0;\n' +
      '}\n' +
      '// #o3d SplitMarker\n' +
      '// Fragment shader\n' +
      'varying vec3 klm;\n' +
      fillUniforms +
      'void main() {\n';
    var alphaComputation;
    if (antialias) {
      alphaComputation = '' +
        '  // Gradients\n' +
        '  vec3 px = dFdx(klm);\n' +
        '  vec3 py = dFdy(klm);\n' +
        '\n' +
        '  // Chain rule\n' +
        '  float k2 = klm.x * klm.x;\n' +
        '  float c = k2 * klm.x - klm.y * klm.z;\n' +
        '  float k23 = 3.0 * k2;\n' +
        '  float cx = k23 * px.x - klm.z * px.y - klm.y * px.z;\n' +
        '  float cy = k23 * py.x - klm.z * py.y - klm.y * py.z;\n' +
        '\n' +
        '  // Signed distance\n' +
        '  float sd = c / sqrt(cx * cx + cy * cy);\n' +
        '\n' +
        '  // Linear alpha\n' +
        '  // TODO(kbr): figure out why this needs to be\n' +
        '  // negated compared to Cg version, and also why\n' +
        '  // we need an adjustment by +1.0 for it to look good.\n' +
        '  // float alpha = clamp(0.5 - sd, 0.0, 1.0);\n' +
        '  float alpha = clamp(sd + 0.5, 0.0, 1.0);\n';
    } else {
      alphaComputation = '' +
        '  float t = klm.x * klm.x * klm.x - klm.y * klm.z;\n' +
        '  float alpha = clamp(sign(t), 0.0, 1.0);\n';
    }
    return result + alphaComputation +
      '\n' +
      fillSource +
      '}\n' +
      '\n' +
      '// #o3d MatrixLoadOrder RowMajor\n';
  } else {
    antialias = false;  // See above why
    var result = '' +
      'uniform float4x4 worldViewProjection : WORLDVIEWPROJECTION;\n' +
      fillUniforms +
      '\n' +
      'struct VertexShaderInput {\n' +
      '  float2 position : POSITION;\n' +
      '  float3 klm : TEXCOORD0;\n' +
      '};\n' +
      '\n' +
      'struct PixelShaderInput {\n' +
      '  float4 position : POSITION;\n' +
      '  float3 klm : TEXCOORD0;\n' +
      '};\n' +
      '\n' +
      'PixelShaderInput vertexShaderFunction(VertexShaderInput input) {\n' +
      '  PixelShaderInput output;\n' +
      '\n' +
      '  output.position = mul(float4(input.position, 0, 1),\n' +
      '                        worldViewProjection);\n' +
      '  output.klm = input.klm;\n' +
      '  return output;\n' +
      '}\n' +
      '\n' +
      'float4 pixelShaderFunction(PixelShaderInput input) : COLOR {\n' +
      '  float3 klm = input.klm;\n';
    var alphaComputation;
    if (antialias) {
      alphaComputation = '' +
        '  // Gradients\n' +
        '  float3 px = ddx(input.klm);\n' +
        '  float3 py = ddy(input.klm);\n' +
        '\n' +
        '  // Chain rule\n' +
        '  float k2 = klm.x * klm.x;\n' +
        '  float c = k2 * klm.x - klm.y * klm.z;\n' +
        '  float k23 = 3.0 * k2;\n' +
        '  float cx = k23 * px.x - klm.z * px.y - klm.y * px.z;\n' +
        '  float cy = k23 * py.x - klm.z * py.y - klm.y * py.z;\n' +
        '\n' +
        '  // Signed distance\n' +
        '  float sd = c / sqrt(cx * cx + cy * cy);\n' +
        '\n' +
        '  // Linear alpha\n' +
        '  float alpha = clamp(0.5 - sd, 0.0, 1.0);\n';
    } else {
      alphaComputation = '' +
        '  float t = klm.x * klm.x * klm.x - klm.y * klm.z;\n' +
        '  float alpha = clamp(sign(t), 0.0, 1.0);\n';
    }

    return result + alphaComputation +
      '\n' +
      fillSource +
      '}\n' +
      '\n' +
      '// #o3d VertexShaderEntryPoint vertexShaderFunction\n' +
      '// #o3d PixelShaderEntryPoint pixelShaderFunction\n' +
      '// #o3d MatrixLoadOrder RowMajor\n';
  }
};

/**
 * Generates the source for the shader used on the interior triangles
 * of the shape.
 * @param {string} fillUniforms the uniforms for the fill.
 * @param {string} fillSource the source code snippet for the fill.
 * @return {string}
 * @private
 */
o3djs.gpu2d.generateSolidShaderSource_ = function(fillUniforms, fillSource) {
  if (o3djs.base.glsl) {
    var result = '' +
      '// Vertex shader\n' +
      'uniform mat4 worldViewProjection;\n' +
      '\n' +
      'attribute vec2 position;\n' +
      '\n' +
      'void main() {\n' +
      '  // TODO(kbr): figure out why this multiplication needs to be\n' +
      '  // transposed compared to the Cg version.\n' +
      '  gl_Position = worldViewProjection * vec4(position, 0.0, 1.0);\n' +
      '}\n' +
      '// #o3d SplitMarker\n' +
      '// Fragment shader\n' +
      fillUniforms +
      'void main() {\n' +
      '  float alpha = 1.0;\n' +
      fillSource +
      '}\n' +
      '\n' +
      '// #o3d MatrixLoadOrder RowMajor\n';
    return result;
  } else {
    var result = '' +
      'uniform float4x4 worldViewProjection : WORLDVIEWPROJECTION;\n' +
      fillUniforms +
      '\n' +
      'struct VertexShaderInput {\n' +
      '  float2 position : POSITION;\n' +
      '};\n' +
      '\n' +
      'struct PixelShaderInput {\n' +
      '  float4 position : POSITION;\n' +
      '};\n' +
      '\n' +
      'PixelShaderInput vertexShaderFunction(VertexShaderInput input) {\n' +
      '  PixelShaderInput output;\n' +
      '\n' +
      '  output.position = mul(float4(input.position, 0, 1),\n' +
      '                        worldViewProjection);\n' +
      '  return output;\n' +
      '}\n' +
      '\n' +
      'float4 pixelShaderFunction(PixelShaderInput input) : COLOR {\n' +
      '  float alpha = 1.0;\n' +
      fillSource +
      '}\n' +
      '\n' +
      '// #o3d VertexShaderEntryPoint vertexShaderFunction\n' +
      '// #o3d PixelShaderEntryPoint pixelShaderFunction\n' +
      '// #o3d MatrixLoadOrder RowMajor\n';
    return result;
  }
};

/**
 * Enum for the types of fills.
 * @enum
 * @private
 */
o3djs.gpu2d.FillTypes_ = {
  COLOR: 0
};

/**
 * Shader code for the various Cg fills, indexed by FillTypes_.
 * @type {!Array.<{uniforms: string, source: string}>}
 * @private
 */
o3djs.gpu2d.FILL_CODE_CG_ = [
  { uniforms:
      'uniform float4 color;\n',
    source:
      'return float4(color.r, color.g, color.b, color.a * alpha);\n'
  }
];

/**
 * Shader code for the various fills, indexed by FillTypes_.
 * @type {!Array.<{uniforms: string, source: string}>}
 * @private
 */
o3djs.gpu2d.FILL_CODE_GLSL_ = [
  { uniforms:
      'uniform vec4 color;\n',
    source:
      'gl_FragColor = vec4(color.r, color.g, color.b, color.a * alpha);\n'
  }
];

/**
 * Cache of effects indexed by pack's client ID. Each entry is an
 * array indexed by fill type.
 * @type {!Array.<!Array.<!o3d.Effect>>}
 * @private
 */
o3djs.gpu2d.interiorEffectCache_ = [];

/**
 * Cache of effects indexed by pack's client ID. Each entry is an
 * array indexed by fill type.
 * @type {!Array.<!Array.<!o3d.Effect>>}
 * @private
 */
o3djs.gpu2d.exteriorEffectCache_ = [];

/**
 * Loads a fill effect for a Path.
 * @param {!o3d.Pack} pack the Pack in which to create materials.
 * @param {o3djs.gpu2d.FillTypes_} fillType the fill type to create.
 * @param {boolean} interior whether this effect is filling the solid
 *     interior portion of the shape or the exterior region containing
 *     the curves.
 * @return {!o3d.Effect}
 * @private
 */
o3djs.gpu2d.loadEffect_ = function(pack, fillType, interior) {
  var effectCache;
  if (interior) {
    effectCache = o3djs.gpu2d.interiorEffectCache_;
  } else {
    effectCache = o3djs.gpu2d.exteriorEffectCache_;
  }
  var effectList = o3djs.gpu2d.getEffectList_(pack, effectCache);
  var effect = effectList[fillType];
  if (!effect) {
    effect = pack.createObject('Effect');
    var result = false;
    var sourceSnippets;
    if (o3djs.base.glsl) {
      sourceSnippets = o3djs.gpu2d.FILL_CODE_GLSL_[fillType];
    } else {
      sourceSnippets = o3djs.gpu2d.FILL_CODE_CG_[fillType];
    }
    if (interior) {
      result = effect.loadFromFXString(
          o3djs.gpu2d.generateSolidShaderSource_(sourceSnippets.uniforms,
                                                 sourceSnippets.source));
    } else {
      result = effect.loadFromFXString(
          o3djs.gpu2d.generateLoopBlinnShaderSource_(true,
                                                     sourceSnippets.uniforms,
                                                     sourceSnippets.source));
    }
    if (!result) {
      alert('Error loading shader: interior = ' + interior);
    }
    effectList[fillType] = effect;
  }
  return effect;
};

/**
 * Fetches and/or creates the effect list for a given pack from the
 * passed effect cache.
 * @param {!o3d.Pack} pack the Pack in which to create materials.
 * @param {!Array.<!Array.<!o3d.Effect>>} effectCache the effect cache.
 * @return {!Array.<o3d.Effect>}
 * @private
 */
o3djs.gpu2d.getEffectList_ = function(pack, effectCache) {
  var list = effectCache[pack.clientId];
  if (!list) {
    list = [];
    effectCache[pack.clientId] = list;
  }
  return list;
};

