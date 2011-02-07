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
 * The DrawContext defines the parameters used for a particular drawing pass.
 * It contains two 4-by-4 matrix params, view and
 * projection. These correspond to the viewing and projection transformation
 * matrices.
 *
 * @param {!o3d.Matrix4} opt_view The view matrix for this DrawContext.
 * @param {!o3d.Matrix4} opt_projection The projection matrix
 *     for this DrawContext.
 * @constructor
 */
o3d.DrawContext = function(opt_view, opt_projection) {
  o3d.ParamObject.call(this);

  /**
   * The view matrix represents the viewing transformation, used to
   * take vertices from world space to view space.
   * @type {o3d.Matrix4}
   */
  this.view = opt_view ||
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];

  /**
   * The projection matrix represents the projection transformation,
   * used to take vertices from view space to screen space.  This
   * matrix is usually an orthographic or perspective transformation.
   * @type {o3d.Matrix4}
   */
  this.projection = opt_projection ||
      [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];
};
o3d.inherit('DrawContext', 'ParamObject');

o3d.ParamObject.setUpO3DParam_(o3d.DrawContext, 'view', 'ParamMatrix4');
o3d.ParamObject.setUpO3DParam_(o3d.DrawContext, 'projection', 'ParamMatrix4');

