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
 * A DrawPass renders a DrawList.
 *
 * @param {o3d.DrawList} drawList The DrawList used by this DrawPass.
 * @param {o3d.DrawPass.SortMethod} sortMethod ParamInteger The method
 *     of sorting this DrawPass.
 * @constructor
 */
o3d.DrawPass = function(opt_drawList, opt_sortMethod) {
  o3d.RenderNode.call(this);

  /**
   * The DrawList for this DrawPass.
   * @type {o3d.DrawList}
   */
  this.drawList = opt_drawList || null;

  /**
   * The sort method for this DrawPass to draw the DrawList by.
   * Default = BY_PERFORMANCE.
   * @type {o3d.DrawList.SortMethod}
   */
  this.sortMethod = opt_sortMethod || o3d.DrawList.BY_PERFORMANCE;
};
o3d.inherit('DrawPass', 'RenderNode');

/**
 * @type {number}
 */
o3d.DrawPass.SortMethod = goog.typedef;

o3d.ParamObject.setUpO3DParam_(o3d.DrawPass, 'drawList', 'ParamDrawList');
o3d.ParamObject.setUpO3DParam_(o3d.DrawPass, 'sortMethod', 'ParamInteger');

/**
 * Called in rendergraph traversal before children are rendered.
 */
o3d.DrawPass.prototype.before = function() {
  if (this.drawList) {
    this.drawList.sort_(this.sortMethod);
    this.drawList.render();
  }
};


