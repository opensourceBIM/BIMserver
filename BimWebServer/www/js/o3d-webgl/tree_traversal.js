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
 * A TreeTraversal has multiple DrawLists registered with it. Each DrawList has
 * a DrawContext registered with it. At render time the TreeTraversal walks the
 * transform graph from the transform it's pointing at and for each DrawElement
 * it finds who's matertial matches one of its registered DrawLists it adds that
 * DrawElement to that DrawList.
 *
 * @param {o3d.Transform} opt_transform The root transform to start traversing
 *     by this TreeTraveral.
 * @constructor
 */
o3d.TreeTraversal = function(opt_transform) {
  o3d.RenderNode.call(this);

  /**
   * The root Transform this TreeTraversal will start traversing from.
   */
  this.transform = opt_transform || null;

  /**
   * Private list of registered drawlists.
   * @private
   */
  this.drawLists_ = [];

  /**
   * Private list of drawlists to reset at render-time before traversal.
   * @private
   */
  this.drawListsToReset_ = [];
};
o3d.inherit('TreeTraversal', 'RenderNode');

o3d.ParamObject.setUpO3DParam_(o3d.TreeTraversal,
                               'transform', 'ParamTransform');

/**
 * Registers a DrawList with this TreeTraversal so that when this
 * TreeTraversal traverses its tree, DrawElements using materials that use
 * this DrawList will be added though possibly culled by the view frustum of
 * the DrawContext. Note: passing in the same DrawList more than once will
 * override the previous settings for that DrawList.
 * @param {o3d.DrawList} draw_list DrawList to register.
 * @param {o3d.DrawContext} draw_context DrawContext to use with the DrawList.
 * @param {boolean} reset true if you want the DrawList reset before
 *     traversing.
 */
o3d.TreeTraversal.prototype.registerDrawList =
    function(draw_list, draw_context, reset) {
  if (reset == undefined || reset) {
    this.drawListsToReset_.push(draw_list);
  }
  this.drawLists_.push({
    list:draw_list,
    context:draw_context});
};


/**
 * Unregisters a DrawList with this TreeTraversal.
 * @param {o3d.DrawList} draw_list DrawList to unregister.
 * @return {boolean}  true if unregistered. false if this draw_list was
 *     not registered.
 */
o3d.TreeTraversal.prototype.unregisterDrawList =
    function(draw_list) {
  o3d.notImplemented();
};


/**
 * Called in the render graph traversal before the children are rendered.
 */
o3d.TreeTraversal.prototype.before =
    function() {
  for(var i = 0; i < this.drawListsToReset_.length; ++i) {
    this.drawListsToReset_[i].list_ = [];
  }
  this.transform.traverse(this.drawLists_);
};
