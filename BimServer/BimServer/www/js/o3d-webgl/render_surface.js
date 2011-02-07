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
 * A RenderSurfaceBase is the base for RenderSurface and
 * RenderDepthStencilSurface.
 *
 * @param {number} width The width of this RenderSurface.
 * @param {number} height The height of this RenderSurface.
 * @param {o3d.Texture} texture The texture of this RenderSurface.
 * @constructor
 */
o3d.RenderSurfaceBase = function(width, height, texture) {
  o3d.ParamObject.call(this);

  /**
   * The width of the surface, in pixels.
   * @type {number}
   */
  this.width = width || 0;

  /**
   * The height of the surface, in pixels.
   * @type {number}
   */
  this.height = height || 0;

  /**
   * The texture in which this surface is contained.
   */
  this.texture = texture || null;

  /**
   * The mip level targeted by this render surface.
   * @type {number}
   */
  this.level = 0;

  /**
   * The underlying GL framebuffer object.
   * @type {WebGLFramebuffer}
   * @private
   */
  this.framebuffer_ = null;

};
o3d.inherit('RenderSurfaceBase', 'ParamObject');

o3d.ParamObject.setUpO3DParam_(o3d.RenderSurfaceBase, 'width', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.RenderSurfaceBase, 'height', 'ParamInteger');

/**
 * A RenderSurface encapsulates the notion of a renderable surface.
 * When used in conjunction with a RenderSurfaceSet node in the render graph,
 * the API allows for rendering of primitives to the given surface.
 * RenderSurface objects are not constructable through the Pack API, they may
 * only be accessed through the texture getRenderSurface(...) interfaces.
 * @constructor
 */
o3d.RenderSurface = function() {
  o3d.RenderSurfaceBase.call(this);
};
o3d.inherit('RenderSurface', 'RenderSurfaceBase');


/**
 * Initializes a render surface to render to the given texture.
 * @param {o3d.Texture2D} texture The texture.
 */
o3d.RenderSurface.prototype.initWithTexture = function(texture, level) {
  this.framebuffer_ = this.gl.createFramebuffer();
  this.texture = texture;
  this.level = level;
  this.width = texture.width;
  this.height = texture.height;
};

/**
 * A RenderDepthStencilSurface represents a depth stencil render surface.
 * @constructor
 */
o3d.RenderDepthStencilSurface = function() {
  o3d.RenderSurfaceBase.call(this);

  /**
   * The GL renderbuffer object for the depth / stencil buffer.
   * @type {WebGLRenderbuffer}
   * @private
   */
  this.depth_stencil_buffer_ = null;
};
o3d.inherit('RenderDepthStencilSurface', 'RenderSurfaceBase');


/**
 * Allocates depth and stnecil buffers of the given size.
 * @param {number} width
 * @param {number} height
 * @private
 */
o3d.RenderDepthStencilSurface.prototype.initWithSize_ =
    function(width, height) {
  this.depth_stencil_buffer_ = this.gl.createRenderbuffer();
  this.gl.bindRenderbuffer(this.gl.RENDERBUFFER, this.depth_stencil_buffer_);
  this.gl.renderbufferStorage(
     this.gl.RENDERBUFFER, this.gl.DEPTH_COMPONENT16, width, height);
  this.width = width;
  this.height = height;
};
