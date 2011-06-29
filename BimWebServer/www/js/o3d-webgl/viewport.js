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
 * A Viewport is a render node that sets the render viewport and depth range
 * for its children.  It uses an array in the format [left, top, width, height]
 * where left, top, width and height are in a 0.0 to 1.0 range that represent
 * positions and dimensions relative to the size of the client's rendering
 * area. The depth range is represented by an array in the format
 * [min Z, max Z]. The depth range provides the mapping of the clip space
 * coordinates into normalized z buffer coordinates.
 *
 * @param {o3d.math.Float4} viewport The viewport setting.
 * @param {o3d.math.Float2} depthRange ParamFloat2 The depth range setting.
 * @constructor
 */
o3d.Viewport = function(opt_viewport, opt_depthRange) {
  o3d.RenderNode.call(this);

  /**
   * The position and size to set the viewport in
   * [left, top, width, height] format.
   *
   * Note: These values must describe a rectangle that is 100% inside
   * the client area. In other words, [0.5, 0.0, 1.0, 1.0] would
   * describe an area that is 1/2 off right side of the screen. That
   * is an invalid value and will be clipped to [0.5, 0.0, 0.5, 1.0].
   *
   * Default = [0.0, 0.0, 1.0, 1.0]. In other words, the full area.
   *
   * @type {!Array.<number>}
   */
  this.viewport = opt_viewport || [0.0, 0.0, 1.0, 1.0];

  /**
   * The min Z and max Z depth range in [min Z, max Z] format.
   * Default = [0.0, 1.0].
   *
   * @type {!Array.<number>}
   */
  this.depthRange = opt_depthRange || [0.0, 1.0];
};
o3d.inherit('Viewport', 'RenderNode');

o3d.ParamObject.setUpO3DParam_(o3d.Viewport, 'viewport', 'ParamFloat4');
o3d.ParamObject.setUpO3DParam_(o3d.Viewport, 'depthRange', 'ParamFloat2');

/**
 * Called before the children are rendered.  Sets up a viewport and
 * scissor region in gl.
 */
o3d.Viewport.prototype.before = function() {
  var x = this.viewport[0] * this.gl.displayInfo.width;
  var y = (1 - this.viewport[1] - this.viewport[3]) *
      this.gl.displayInfo.height;
  var width = this.viewport[2] * this.gl.displayInfo.width;
  var height = this.viewport[3] * this.gl.displayInfo.height;

  this.gl.viewport(x, y, width, height);
  if (x != 0 || y != 0 || this.viewport[2] != 1 || this.viewport[3] != 1) {
    this.gl.enable(this.gl.SCISSOR_TEST);
    this.gl.scissor(x, y, width, height);
  } else {
     this.gl.disable(this.gl.SCISSOR_TEST);
  }
};

