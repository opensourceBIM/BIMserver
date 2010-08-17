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
 * @fileoverview This file contains a basic utility library that simplifies the
 * creation of simple 2D Canvas surfaces for the purposes of drawing 2D elements
 * in O3D.
 *
 * Example
 *
 * <pre>
 * &lt;html&gt;&lt;body&gt;
 * &lt;script type="text/javascript" src="o3djs/all.js"&gt;
 * &lt;/script&gt;
 * &lt;script&gt;
 * window.onload = init;
 *
 * function init() {
 *   o3djs.base.makeClients(initStep2);
 * }
 *
 * function initStep2(clientElements) {
 *   var clientElement = clientElements[0];
 *   var client = clientElement.client;
 *   var pack = client.createPack();
 *   var viewInfo = o3djs.rendergraph.createBasicView(
 *       pack,
 *       client.root,
 *       client.renderGraphRoot);
 *
 *   // Create an instance of the canvas utility library.
 *   var canvasLib = o3djs.canvas.create(
 *       pack, client.root, g_viewInfo);
 *
 *   // Create a 700x500 rectangle at (x,y,z) = (4, 10, 0)
 *   var canvasQuad = canvasLib.createXYQuad(4, 10, 0, 700, 500, false);
 *
 *   // Draw into the canvas.
 *   canvasQuad.canvas.clear([1, 0, 0, 1]);
 *   canvasQuad.canvas.drawText('Hello', 0, 10, canvasPaint);
 *   ...
 *   ...
 *
 *   // Update the o3d texture associated with the canvas.
 *   canvasQuad.updateTexture();
 * }
 * &lt;/script&gt;
 * &lt;div id="o3d" style="width: 600px; height: 600px"&gt;&lt;/div&gt;
 * &lt;/body&gt;&lt;/html&gt;
 * </pre>
 *
 */

o3djs.provide('o3djs.canvas');

o3djs.require('o3djs.effect');
o3djs.require('o3djs.primitives');

/**
 * A Module for using a 2d canvas.
 * @namespace
 */
o3djs.canvas = o3djs.canvas || {};

/**
 * Creates an o3djs.canvas library object through which CanvasQuad objects
 * can be created.
 * @param {!o3d.Pack} pack to manage objects created by this library.
 * @param {!o3d.Transform} root Default root for visual objects.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo A ViewInfo object as
 *  created by o3djs.createView which contains draw lists that the created
 *  quads will be placed into.
 * @return {!o3djs.canvas.CanvasInfo} A CanvasInfo object containing
 *         references to all the common O3D elements used by this instance
 *         of the library.
 */
o3djs.canvas.create = function(pack, root, viewInfo) {
  return new o3djs.canvas.CanvasInfo(pack, root, viewInfo);
};

/**
 * The shader code used by the canvas quads.  It only does two things:
 *   1. Transforms the shape to screen space via the worldViewProjection matrix.
 *   2. Performs a texture lookup to display the contents of the texture
 *      bound to texSampler0.
 * @type {string}
 */
o3djs.canvas.FX_STRING =
    'float4x4 worldViewProjection : WORLDVIEWPROJECTION;\n' +
    'sampler texSampler0;\n' +
    'struct VertexShaderInput {\n' +
    ' float4 position : POSITION;\n' +
    ' float2 texcoord : TEXCOORD0;\n' +
    '};\n'+
    'struct PixelShaderInput {\n' +
    '  float4 position : POSITION;\n' +
    '  float2 texcoord : TEXCOORD0;\n' +
    '};\n' +
    'PixelShaderInput vertexShaderFunction(VertexShaderInput input) {\n' +
    '  PixelShaderInput output;\n' +
    '  output.position = mul(input.position, worldViewProjection);\n' +
    '  output.texcoord = input.texcoord;\n' +
    '  return output;\n' +
    '}\n' +
    'float4 pixelShaderFunction(PixelShaderInput input): COLOR {\n' +
    '  return tex2D(texSampler0, input.texcoord);\n' +
    '}\n' +
    '// #o3d VertexShaderEntryPoint vertexShaderFunction\n' +
    '// #o3d PixelShaderEntryPoint pixelShaderFunction\n' +
    '// #o3d MatrixLoadOrder RowMajor\n';

/**
 * The CanvasInfo object creates and keeps references to the O3D objects
 * that are shared between all CanvasQuad objects created through it.
 * @constructor
 * @param {!o3d.Pack} pack Pack to manage CanvasInfo objects.
 * @param {!o3d.Transform} root Default root for visual objects.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo A ViewInfo object as
 *     created by o3djs.createView which contains draw lists that the
 *     created quads will be placed into.
 */
o3djs.canvas.CanvasInfo = function(pack, root, viewInfo) {
  /**
   * The pack being used to manage objects created by this CanvasInfo.
   * @type {!o3d.Pack}
   */
  this.pack = pack;

  /**
   * The ViewInfo this CanvasInfo uses for rendering.
   * @type {!o3djs.rendergraph.ViewInfo}
   */
  this.viewInfo = viewInfo;

  /**
   * The default root for objects created by this CanvasInfo.
   * @type {!o3d.Transform}
   */
  this.root = root;

  /**
   * The Effect object shared by all CanvasQuad instances.
   * @type {!o3d.Effect}
   */
  this.effect_ = this.pack.createObject('Effect');
  this.effect_.loadFromFXString(o3djs.canvas.FX_STRING);

  /**
   * Material for canvases with transparent content
   * @type {!o3d.Material}
   */
  this.transparentMaterial_ = this.pack.createObject('Material');

  /**
   * Material for canvases with opaque content.
   * @type {!o3d.Material}
   */
  this.opaqueMaterial_ = this.pack.createObject('Material');

  this.transparentMaterial_.effect = this.effect_;
  this.opaqueMaterial_.effect = this.effect_;

  this.transparentMaterial_.drawList = viewInfo.zOrderedDrawList;
  this.opaqueMaterial_.drawList = viewInfo.performanceDrawList;

  /**
   * State object to handle the transparency blending mode
   * for transparent canvas quads.
   * The canvas bitmap already multiplies the color values by alpha.  In order
   * to avoid a black halo around text drawn on a transparent background we
   * need to set the blending mode as follows.
   * @type {!o3d.State}
   */
  this.transparentState_ = this.pack.createObject('State');
  this.transparentState_.getStateParam('AlphaBlendEnable').value = true;
  this.transparentState_.getStateParam('SourceBlendFunction').value =
      o3djs.base.o3d.State.BLENDFUNC_ONE;
  this.transparentState_.getStateParam('DestinationBlendFunction').value =
      o3djs.base.o3d.State.BLENDFUNC_INVERSE_SOURCE_ALPHA;

  this.transparentMaterial_.state = this.transparentState_;

  // Create 2d plane shapes. createPlane makes an XZ plane by default
  // so we pass in matrix to rotate it to an XY plane. We could do
  // all our manipulations in XZ but most people seem to like XY for 2D.

  /**
   * A shape for transparent quads.
   * @type {!o3d.Shape}
   */
  this.transparentQuadShape = o3djs.primitives.createPlane(
      this.pack,
      this.transparentMaterial_,
      1,
      1,
      1,
      1,
      [[1, 0, 0, 0],
       [0, 0, 1, 0],
       [0, -1, 0, 0],
       [0, 0, 0, 1]]);

  /**
   * A shape for opaque quads.
   * @type {!o3d.Shape}
   */
  this.opaqueQuadShape = o3djs.primitives.createPlane(
      this.pack,
      this.opaqueMaterial_,
      1,
      1,
      1,
      1,
      [[1, 0, 0, 0],
       [0, 0, 1, 0],
       [0, -1, 0, 0],
       [0, 0, 0, 1]]);
};
/**
 * The CanvasQuad object encapsulates a Transform, a rectangle Shape,
 * an effect that applies a texture to render the quad, and a matching Canvas
 * object that can render into the texture.  The dimensions of the texture and
 * the canvas object match those of the quad in order to get pixel-accurate
 * results with the appropriate orthographic projection.
 * The resulting rectangle Shape is positioned at the origin.  It can be moved
 * around by setting the localMatrix on the Transform object referenced to by
 * the canvasQuad.transform property.
 * The Canvas associated with the returned CanvasQuad object can be retrieved
 * from the object's 'canvas' property.  After issuing any draw commands on the
 * Canvas, you need to call the updateTexture() method on the CanvasQuad to
 * update the contents of the quad surface.
 * @constructor
 * @param {!o3djs.canvas.CanvasInfo} canvasInfo The CanvasInfo object
 *     instance creating this CanvasQuad.
 * @param {number} width The width of the quad.
 * @param {number} height The height of the quad.
 * @param {boolean} transparent Set to true if the canvas will
 *     be transparent so that the appropriate blending modes are set.
 * @param {!o3d.Transform} opt_parent parent transform to parent
 *     the newly created quad under. If no parent transform is provided then
 *     the quad gets parented under the CanvasInfo's root.
 */
o3djs.canvas.CanvasQuad = function(canvasInfo,
                                   width,
                                   height,
                                   transparent,
                                   opt_parent) {
  /**
   * The CanvasInfo managing this CanvasQuad
   * @type {!o3djs.canvas.CanvasInfo}
   */
  this.canvasInfo = canvasInfo;
  var parentTransform = opt_parent || canvasInfo.root;

  // create a transform for positioning

  /**
   * A transform for this quad.
   * @type {!o3d.Transform}
   */
  this.transform = canvasInfo.pack.createObject('Transform');
  this.transform.parent = parentTransform;

  // create a transform for scaling to the size of the image just so
  // we don't have to manage that manually in the transform above.

  /**
   * A scale transform for this quad.
   * You can change the scale the quad without effecting its positon using
   * this transform.
   * @type {!o3d.Transform}
   */
  this.scaleTransform = canvasInfo.pack.createObject('Transform');
  this.scaleTransform.parent = this.transform;

  /**
   * The texture the canvas will draw on.
   * @type {!o3d.Texture2D}
   */
  this.texture = /** @type {!o3d.Texture2D} */ (canvasInfo.pack.createTexture2D(
      width,
      height,
      o3djs.base.o3d.Texture.ARGB8,
      1, // mipmap levels
      false));

  // Create a Canvas object to go with the quad.

  /**
   * The Canvas object used to draw on this quad.
   * @type {!o3d.Canvas}
   */
  this.canvas = canvasInfo.pack.createObject('Canvas');
  this.canvas.setSize(width, height);

  /**
   * The sampler for the texture.
   * @type {!o3d.Sampler}
   */
  this.sampler = canvasInfo.pack.createObject('Sampler');
  this.sampler.addressModeU = o3djs.base.o3d.Sampler.CLAMP;
  this.sampler.addressModeV = o3djs.base.o3d.Sampler.CLAMP;

  /**
   * The param sampler for this transform.
   * @private
   * @type {!o3d.ParamSampler}
   */
  this.paramSampler_ = this.scaleTransform.createParam('texSampler0',
                                                       'ParamSampler');
  this.paramSampler_.value = this.sampler;

  this.sampler.texture = this.texture;
  if (transparent) {
    this.scaleTransform.addShape(canvasInfo.transparentQuadShape);
  } else {
    this.scaleTransform.addShape(canvasInfo.opaqueQuadShape);
  }
  this.scaleTransform.translate(width / 2, height / 2, 0);
  this.scaleTransform.scale(width, -height, 1);
};

/**
 * Copies the current contents of the Canvas object to the texture associated
 * with the quad.  This method should be called after any new draw calls have
 * been issued to the CanvasQuad's Canvas object.
 */
o3djs.canvas.CanvasQuad.prototype.updateTexture = function() {
  var width = this.texture.width;
  var height = this.texture.height;
  this.texture.drawImage(this.canvas, 0, height - 1, width, -height,
                         0, 0, 0, width, height);
};

/**
 * Creates a CanvasQuad object on the XY plane at the specified position.
 * @param {number} topX The x coordinate of the top left corner of the quad.
 * @param {number} topY The y coordinate of the top left corner of the quad.
 * @param {number} z The z coordinate of the quad.  z values are negative
 *     numbers, the smaller the number the further back the quad will be.
 * @param {number} width The width of the quad.
 * @param {number} height The height of the quad.
 * @param {boolean} transparent Set to true if the canvas bitmap uses
 *     transparency so that the appropriate blending modes are set.
 * @param {!o3d.Transform} opt_parent parent transform to parent the newly
 *     created quad under.  If no parent transform is provided then the quad
 *     gets parented under the CanvasInfo's root.
 * @return {!o3djs.canvas.CanvasQuad} The newly created CanvasQuad object.
 */
o3djs.canvas.CanvasInfo.prototype.createXYQuad = function(topX,
                                                          topY,
                                                          z,
                                                          width,
                                                          height,
                                                          transparent,
                                                          opt_parent) {
  var canvasQuad = new o3djs.canvas.CanvasQuad(this,
                                               width,
                                               height,
                                               transparent,
                                               opt_parent);

  canvasQuad.transform.translate(topX, topY, z);
  return canvasQuad;
};

/**
 * Creates a CanvasQuad object of the given size. The resulting rectangle Shape
 * is centered at the origin.  It can be moved around by setting the
 * localMatrix on the Transform object referenced to by the canvasQuad.transform
 * property.
 * @param {number} width The width of the quad.
 * @param {number} height The height of the quad.
 * @param {boolean} transparent Set to true if the canvas bitmap uses
 *     transparency so that the appropriate blending modes are set.
 * @param {!o3d.Transform} opt_parent parent transform to parent the newly
 *     created quad under.  If no parent transform is provided then the quad
 *     gets parented under the CanvasInfo's root.
 * @return {!o3djs.canvas.CanvasQuad} The newly created CanvasQuad object.
 */
o3djs.canvas.CanvasInfo.prototype.createQuad = function(width,
                                                        height,
                                                        transparent,
                                                        opt_parent) {
  return new o3djs.canvas.CanvasQuad(this,
                                     width,
                                     height,
                                     transparent,
                                     opt_parent);
};
