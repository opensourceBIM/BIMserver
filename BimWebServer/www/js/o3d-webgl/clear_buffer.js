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
 * A ClearBuffer is a render node that clears the color buffer, zbuffer and/or
 * stencil buffer of the current render target.
 *
 * @constructor
 */
o3d.ClearBuffer = function() {
  o3d.RenderNode.call(this);
  /**
   * The color to clear the buffer in RGBA Float4 format.
   * @type {!o3d.Float4}
   */
  this.clearColor = [0, 0, 0, 1];

  /**
   * true clears the current render target's color buffer to the clear color.
   * false does not clear the color buffer.
   * @type {boolean}
   */
  this.clearColorFlag = true;

  /**
   * The value to clear the depth buffer (0.0 - 1.0)
   * @type {number}
   */
  this.clearDepth = 1;

  /**
   * true clears the current render target's depth buffer to the clear depth
   * value. false does not clear the depth buffer.
   * @type {boolean}
   */
  this.clearDepthFlag = true;

  /**
   * The value to clear the stencil buffer to (0 - 255).
   * @type {number}
   */
  this.clearStencil = 0;

  /**
   * true clears the current render target's stencil buffer to the clear stencil
   * value. false does not clear the stencil buffer
   * @type {boolean}
   */
  this.clearStencilFlag = true;
};
o3d.inherit('ClearBuffer', 'RenderNode');

o3d.ParamObject.setUpO3DParam_(o3d.ClearBuffer, 'clearColor', 'ParamFloat4');
o3d.ParamObject.setUpO3DParam_(o3d.ClearBuffer,
                               'clearColorFlag', 'ParamBoolean');
o3d.ParamObject.setUpO3DParam_(o3d.ClearBuffer, 'clearDepth', 'ParamFloat');
o3d.ParamObject.setUpO3DParam_(o3d.ClearBuffer,
                               'clearDepthFlag', 'ParamBoolean');
o3d.ParamObject.setUpO3DParam_(o3d.ClearBuffer,
                               'clearStencil', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.ClearBuffer,
                               'clearStencilFlag', 'ParamBoolean');

/**
 * Function called in the render graph traversal before the children are
 * rendered.
 */
o3d.ClearBuffer.prototype.before = function() {
  var flags = 0;

  this.gl.clearColor(
      this.clearColor[0],
      this.clearColor[1],
      this.clearColor[2],
      this.clearColor[3]);

  this.gl.clearDepth(this.clearDepth);
  this.gl.clearStencil(this.clearStencil);

  if (this.clearColorFlag)
    flags = flags | this.gl.COLOR_BUFFER_BIT;
  if (this.clearDepthFlag)
    flags = flags | this.gl.DEPTH_BUFFER_BIT;
  if (this.clearStencilFlag)
    flags = flags | this.gl.STENCIL_BUFFER_BIT;

  this.gl.clear(flags);
};



