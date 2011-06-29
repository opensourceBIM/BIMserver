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
 * A RenderSurfaceSet node will bind depth and color RenderSurface nodes
 * to the current rendering context.  All RenderNodes descending
 * from the given RenderSurfaceSet node will operate on the contents of
 * the bound depth and color buffers.
 * Note the following usage constraints of this node:
 * 1)  If both a color and depth surface is bound, then they must be of
 *     matching dimensions.
 * 2)  At least one of render_surface and render_depth_surface must non-null.
 *
 * @param {o3d.RenderSurface} opt_renderSurface The render surface to set.
 * @param {o3d.RenderDepthStencilSurface} opt_renderDepthStencilSurface The
 *     depth stencil render surface to set.
 * @constructor
 */
o3d.RenderSurfaceSet =
    function(opt_renderSurface, opt_renderDepthStencilSurface) {
  o3d.RenderNode.call(this);

  /**
   * The render surface to which the color contents of all RenderNode children
   * should be drawn.
   * @type {o3d.RenderSurface}
   */
  this.renderSurface = opt_renderSurface || null;


  /**
   * The render depth stencil surface to which the depth contents of all
   * RenderNode children should be drawn.
   * @type {o3d.RenderDepthStencilSurface}
   */
  this.renderDepthStencilSurface = opt_renderDepthStencilSurface || null;
};
o3d.inherit('RenderSurfaceSet', 'RenderNode');


o3d.ParamObject.setUpO3DParam_(o3d.RenderSurfaceSet,
                               'renderSurface', 'ParamRenderSurface');
o3d.ParamObject.setUpO3DParam_(o3d.RenderSurfaceSet,
                               'renderDepthStencilSurface',
                               'ParamRenderDepthStencilSurface');

/**
 * Helper function to set the framebuffer back to the default one.
 * @private
 */
o3d.RenderSurfaceSet.prototype.clearFramebufferObjects_ =
    function() {
  this.gl.bindFramebuffer(
      this.gl.FRAMEBUFFER, this.renderSurface.framebuffer_);

  this.gl.framebufferRenderbuffer(
      this.gl.FRAMEBUFFER,
      this.gl.COLOR_ATTACHMENT0,
      this.gl.RENDERBUFFER,
      null);

  this.gl.framebufferRenderbuffer(
      this.gl.FRAMEBUFFER,
      this.gl.DEPTH_ATTACHMENT,
      this.gl.RENDERBUFFER,
      null);

  this.gl.bindFramebuffer(this.gl.FRAMEBUFFER, null);
};


/**
 * Helper function to set up both the color and depth-stencil targets.
 * @private
 */
o3d.RenderSurfaceSet.prototype.installFramebufferObjects_ =
    function() {
  // Reset the bound attachments to the current framebuffer object.
  this.clearFramebufferObjects_();

  this.gl.bindFramebuffer(
      this.gl.FRAMEBUFFER, this.renderSurface.framebuffer_);

  if (this.renderSurface) {
    var texture = this.renderSurface.texture.texture_;
    var level = this.renderSurface.level;

    // TODO(petersont): If it's a cube, this call should be different.
    this.gl.bindTexture(this.gl.TEXTURE_2D, texture);
    this.gl.framebufferTexture2D(
        this.gl.FRAMEBUFFER,
        this.gl.COLOR_ATTACHMENT0,
        this.gl.TEXTURE_2D,
        texture,
        level);
  }

  if (this.renderDepthStencilSurface) {
    var depth_stencil_buffer =
        this.renderDepthStencilSurface.depth_stencil_buffer_;

    // TODO(petersont): In the WebGL spec, there is a depth-stencil
    // attachment, but it hasn't been implemented yet, once it is,
    // this should use one of those.
    this.gl.bindRenderbuffer(this.gl.RENDERBUFFER, depth_stencil_buffer);
    this.gl.framebufferRenderbuffer(
        this.gl.FRAMEBUFFER,
        this.gl.DEPTH_ATTACHMENT,
        this.gl.RENDERBUFFER,
        depth_stencil_buffer);
  }
};


/**
 * Called during the rendergraph traversal before the children are rendered.
 * @private
 */
o3d.RenderSurfaceSet.prototype.before = function() {
  this.installFramebufferObjects_();
  this.previousHeight = this.gl.displayInfo.height;
  this.previousWidth = this.gl.displayInfo.width;
  this.previousRenderSurfaceSet = this.gl.currentRenderSurfaceSet;
  this.gl.displayInfo.height = this.renderSurface.height;
  this.gl.displayInfo.width = this.renderSurface.width;
  this.gl.currentRenderSurfaceSet = this;
};


/**
 * Called during the rendergraph traversal after the children are rendered.
 * @private
 */
o3d.RenderSurfaceSet.prototype.after = function() {
  this.clearFramebufferObjects_();
  this.gl.displayInfo.height = this.previousHeight;
  this.gl.displayInfo.width = this.previousWidth;
  // This is consumed in effect.js.
  this.gl.currentRenderSurfaceSet = this.previousRenderSurfaceSet;
};


