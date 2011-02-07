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
 * @fileoverview This file contains various functions for helping create
 * render graphs for o3d.  It puts them in the "rendergraph" module on
 * the o3djs object.
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.rendergraph');

/**
 * A Module for creating render graphs.
 * @namespace
 */
o3djs.rendergraph = o3djs.rendergraph || {};

/**
 * Creates a basic render graph setup to draw opaque and transparent
 * 3d objects.
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3d.Transform} treeRoot root Transform of tree to render.
 * @param {!o3d.RenderNode} opt_parent RenderNode to build this view under.
 * @param {!o3djs.math.Vector4} opt_clearColor color to clear view.
 * @param {number} opt_priority Optional base priority for created objects.
 * @param {!o3djs.math.Vector4} opt_viewport viewport settings for view.
 * @param {!o3d.DrawList} opt_performanceDrawList Optional DrawList to
 *     use for performanceDrawPass.
 * @param {!o3d.DrawList} opt_zOrderedDrawList Optional DrawList to
 *     use for zOrderedDrawPass.
 * @param {!o3d.DrawContext} opt_drawContext Optional DrawContext to
 *     use. If not passed in one is created.
 * @return {!o3djs.rendergraph.ViewInfo} A ViewInfo object with info about
 *         everything created.
 */
o3djs.rendergraph.createView = function(pack,
                                        treeRoot,
                                        opt_parent,
                                        opt_clearColor,
                                        opt_priority,
                                        opt_viewport,
                                        opt_performanceDrawList,
                                        opt_zOrderedDrawList,
                                        opt_drawContext) {
  return new o3djs.rendergraph.ViewInfo(pack,
                                        treeRoot,
                                        opt_parent,
                                        opt_clearColor,
                                        opt_priority,
                                        opt_viewport,
                                        opt_performanceDrawList,
                                        opt_zOrderedDrawList,
                                        opt_drawContext);
};

/**
 * Creates a basic render graph setup to draw opaque and transparent
 * 3d objects.
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3d.Transform} treeRoot root Transform of tree to render.
 * @param {!o3d.RenderNode} opt_parent RenderNode to build this view under.
 * @param {!o3djs.math.Vector4} opt_clearColor color to clear view.
 * @param {number} opt_priority Optional base priority for created objects.
 * @param {!o3djs.math.Vector4} opt_viewport viewport settings for view.
 * @return {!o3djs.rendergraph.ViewInfo} A ViewInfo object with info about
 *     everything created.
 */
o3djs.rendergraph.createBasicView = function(pack,
                                             treeRoot,
                                             opt_parent,
                                             opt_clearColor,
                                             opt_priority,
                                             opt_viewport) {
   return o3djs.rendergraph.createView(pack,
                                       treeRoot,
                                       opt_parent,
                                       opt_clearColor,
                                       opt_priority,
                                       opt_viewport);
};

/**
 * Creates an extra view render graph setup to draw opaque and transparent
 * 3d objects based on a previously created view. It uses the previous view
 * to share draw lists and to set the priority.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo ViewInfo returned from
 *     createBasicView.
 * @param {!o3djs.math.Vector4} opt_viewport viewport settings for view.
 * @param {!o3djs.math.Vector4} opt_clearColor color to clear view.
 * @param {number} opt_priority base priority for created objects.
 * @return {!o3djs.rendergraph.ViewInfo} A ViewInfo object with info about
 *     everything created.
 */
o3djs.rendergraph.createExtraView = function(viewInfo,
                                             opt_viewport,
                                             opt_clearColor,
                                             opt_priority) {
  return o3djs.rendergraph.createView(viewInfo.pack,
                                      viewInfo.treeRoot,
                                      viewInfo.renderGraphRoot,
                                      opt_clearColor,
                                      opt_priority,
                                      opt_viewport,
                                      viewInfo.performanceDrawList,
                                      viewInfo.zOrderedDrawList);
};

/**
 * A ViewInfo object creates the standard o3d objects needed for
 * a single 3d view. Those include a ClearBuffer followed by a TreeTraveral
 * followed by 2 DrawPasses all of which are children of a Viewport. On top of
 * those a DrawContext and optionally 2 DrawLists although you can pass in your
 * own DrawLists if there is a reason to reuse the same DrawLists such was with
 * mulitple views of the same scene.
 *
 * The render graph created is something like:
 * <pre>
 *        [Viewport]
 *            |
 *     +------+--------+------------------+---------------------+
 *     |               |                  |                     |
 * [ClearBuffer] [TreeTraversal] [Performance StateSet] [ZOrdered StateSet]
 *                                        |                     |
 *                               [Performance DrawPass] [ZOrdered DrawPass]
 * </pre>
 *
 * @constructor
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3d.Transform} treeRoot root Transform of tree to render.
 * @param {!o3d.RenderNode} opt_parent RenderNode to build this view under.
 * @param {!o3djs.math.Vector4} opt_clearColor color to clear view.
 * @param {number} opt_priority Optional base priority for created objects.
 * @param {!o3djs.math.Vector4} opt_viewport viewport settings for view.
 * @param {!o3d.DrawList} opt_performanceDrawList DrawList to use for
 *     performanceDrawPass.
 * @param {!o3d.DrawList} opt_zOrderedDrawList DrawList to use for
 *     zOrderedDrawPass.
 * @param {!o3d.DrawContext} opt_drawContext Optional DrawContext to
 *     use. If not passed in one is created.
 */
o3djs.rendergraph.ViewInfo = function(pack,
                                      treeRoot,
                                      opt_parent,
                                      opt_clearColor,
                                      opt_priority,
                                      opt_viewport,
                                      opt_performanceDrawList,
                                      opt_zOrderedDrawList,
                                      opt_drawContext) {
  var that = this;
  var clearColor = opt_clearColor || [0.5, 0.5, 0.5, 1.0];
  var viewPriority = opt_priority || 0;
  var priority = 0;

  // Create Viewport.
  var viewport = pack.createObject('Viewport');
  if (opt_viewport) {
    viewport.viewport = opt_viewport;
  }
  viewport.priority = viewPriority;

  // Create a clear buffer.
  var clearBuffer = pack.createObject('ClearBuffer');
  clearBuffer.clearColor = clearColor;
  clearBuffer.priority = priority++;
  clearBuffer.parent = viewport;

  // Creates a TreeTraversal and parents it to the root.
  var treeTraversal = pack.createObject('TreeTraversal');
  treeTraversal.priority = priority++;
  treeTraversal.parent = viewport;
  treeTraversal.transform = treeRoot;

  this.drawPassInfos_ = [];

  /**
   * Pack that manages the objects created for this ViewInfo.
   * @type {!o3d.Pack}
   */
  this.pack = pack;

  /**
   * The RenderNode this ViewInfo render graph subtree is parented under.
   * @type {(!o3d.RenderNode|undefined)}
   */
  this.renderGraphRoot = opt_parent;

  /**
   * The root node of the transform graph this ViewInfo renders.
   * @type {!o3d.Transform}
   */
  this.treeRoot = treeRoot;

  /**
   * The root of the subtree of the render graph this ViewInfo is managing.
   * If you want to set the priority of a ViewInfo's rendergraph subtree use
   * <pre>
   * viewInfo.root.priority = desiredPriority;
   * </pre>
   * @type {!o3d.RenderNode}
   */
  this.root = viewport;

  /**
   * The Viewport RenderNode created for this ViewInfo.
   * @type {!o3d.Viewport}
   */
  this.viewport = viewport;

  /**
   * The ClearBuffer RenderNode created for this ViewInfo.
   * @type {!o3d.ClearBuffer}
   */
  this.clearBuffer = clearBuffer;

  // Create DrawContext.
  var drawContext = opt_drawContext || pack.createObject('DrawContext');

  /**
   * The DrawContext used by this ViewInfo.
   * @type {!o3d.DrawContext}
   */
  this.drawContext = drawContext;

  /**
   * The TreeTraversal used by this ViewInfo.
   * @type {!o3d.TreeTraversal}
   */
  this.treeTraversal = treeTraversal;

  /**
   * The highest priority used for objects under the Viewport RenderNode created
   * by this ViewInfo.
   * @type {number}
   */
  this.priority = priority;

  /**
   * This function is here just because the inside use case of
   * ViewInfo.createDrawPass is the less common case.
   * @param {o3d.DrawList.SortMethod} sortMethod how to sort.
   * @param {!o3d.DrawList} opt_drawList DrawList to use.
   */
  function createDrawPass(sortMethod, opt_drawList) {
    return that.createDrawPass(
        sortMethod,
        undefined,
        undefined,
        undefined,
        opt_drawList);
  }

  // Setup a Performance Ordered DrawPass
  var performanceDrawPassInfo = createDrawPass(
      o3djs.base.o3d.DrawList.BY_PERFORMANCE,
      opt_performanceDrawList);

  var performanceState = performanceDrawPassInfo.state;

  // Setup a z Ordered DrawPass
  var zOrderedDrawPassInfo = createDrawPass(
      o3djs.base.o3d.DrawList.BY_Z_ORDER,
      opt_zOrderedDrawList);

  var zOrderedState = zOrderedDrawPassInfo.state;

  zOrderedState.getStateParam('AlphaBlendEnable').value = true;
  zOrderedState.getStateParam('SourceBlendFunction').value =
      o3djs.base.o3d.State.BLENDFUNC_SOURCE_ALPHA;
  zOrderedState.getStateParam('DestinationBlendFunction').value =
      o3djs.base.o3d.State.BLENDFUNC_INVERSE_SOURCE_ALPHA;
  zOrderedState.getStateParam('AlphaTestEnable').value = true;
  zOrderedState.getStateParam('AlphaComparisonFunction').value =
      o3djs.base.o3d.State.CMP_GREATER;

  // Parent whatever the root is to the parent passed in.
  if (opt_parent) {
    this.root.parent = opt_parent;
  }

  /**
   * The DrawPassInfo for the performance draw pass.
   * @type {!o3djs.rendergraph.DrawPassInfo}
   */
  this.performanceDrawPassInfo = performanceDrawPassInfo;

  /**
   * The DrawPassInfo for the zOrdered draw pass.
   * @type {!o3djs.rendergraph.DrawPassInfo}
   */
  this.zOrderedDrawPassInfo = zOrderedDrawPassInfo;

  // Legacy properties

  /**
   * The StateSet RenderNode above the performance DrawPass in this ViewInfo
   * @type {!o3d.StateSet}
   */
  this.performanceStateSet = performanceDrawPassInfo.stateSet;

  /**
   * The State object used by the performanceStateSet object in this ViewInfo.
   * By default, no states are set here.
   * @type {!o3d.State}
   */
  this.performanceState = performanceState;

  /**
   * The DrawList used for the performance draw pass. Generally for opaque
   * materials.
   * @type {!o3d.DrawList}
   */
  this.performanceDrawList = performanceDrawPassInfo.drawList;

  /**
   * The StateSet RenderNode above the ZOrdered DrawPass in this ViewInfo
   * @type {!o3d.StateSet}
   */
  this.zOrderedStateSet = zOrderedDrawPassInfo.stateSet;

  /**
   * The State object used by the zOrderedStateSet object in this ViewInfo.
   * By default AlphaBlendEnable is set to true, SourceBlendFucntion is set to
   * State.BLENDFUNC_SOURCE_ALPHA and DestinationBlendFunction is set to
   * State.BLENDFUNC_INVERSE_SOURCE_ALPHA
   * @type {!o3d.State}
   */
  this.zOrderedState = zOrderedState;

  /**
   * The DrawList used for the zOrdered draw pass. Generally for transparent
   * materials.
   * @type {!o3d.DrawList}
   */
  this.zOrderedDrawList = zOrderedDrawPassInfo.drawList;

  /**
   * The DrawPass used with the performance DrawList created by this ViewInfo.
   * @type {!o3d.DrawPass}
   */
  this.performanceDrawPass = performanceDrawPassInfo.drawPass;

  /**
   * The DrawPass used with the zOrdered DrawList created by this ViewInfo.
   * @type {!o3d.DrawPass}
   */
  this.zOrderedDrawPass = zOrderedDrawPassInfo.drawPass;

  /**
   * A flag whether or not we created the DrawContext for this DrawPassInfo.
   * @private
   * @type {boolean}
   */
  this.ownDrawContext_ = opt_drawContext ? false : true;
};

/**
 * Destroys the various objects created for the view.
 *
 * @param {boolean} opt_destroyDrawContext True if you want view's DrawContext
 *     destroyed. Default = true.
 * @param {boolean} opt_destroyDrawList True if you want view's DrawLists
 *     destroyed. Default = true.
 */
o3djs.rendergraph.ViewInfo.prototype.destroy = function(
    opt_destroyDrawContext,
    opt_destroyDrawList) {
  if (opt_destroyDrawContext === undefined) {
    opt_destroyDrawContext = true;
  }

  for (var ii = 0; ii < this.drawPassInfos_.length; ++ii) {
    this.drawPassInfos_[ii].destroy();
  }

  // Remove everything we created from the pack.
  this.pack.removeObject(this.viewport);
  this.pack.removeObject(this.clearBuffer);
  if (opt_destroyDrawContext && this.ownDrawContext_) {
    this.pack.removeObject(this.drawContext);
  }
  this.pack.removeObject(this.treeTraversal);
  // Remove our substree from its parent.
  this.viewport.parent = null;

  // At this point, IF nothing else is referencing any of these objects
  // they should get removed.
};

/**
 * Creates a draw pass in this ViewInfo.
 *
 * @param {o3d.DrawList.SortMethod} sortMethod How to sort this draw pass's
 *     DrawElements.
 * @param {!o3d.DrawContext} opt_drawContext The DrawContext for this draw pass.
 *     If not passed in the default DrawContext for this ViewInfo will be used.
 * @param {number} opt_priority The priority for this draw pass. If not passed
 *     in the priority will be the next priority for this ViewInfo.
 * @param {!o3d.RenderNode} opt_parent The RenderNode to parent this draw pass
 *     under. If not passed in the draw pass will be parented under the
 *     ViewInfo's viewport RenderNode.
 * @param {!o3d.DrawList} opt_drawList The DrawList for this draw pass. If not
 *     passed in one will be created.
 * @return {!o3djs.rendergraph.DrawPassInfo}
 */
o3djs.rendergraph.ViewInfo.prototype.createDrawPass = function(
    sortMethod,
    opt_drawContext,
    opt_priority,
    opt_parent,
    opt_drawList) {
  opt_drawContext = opt_drawContext || this.drawContext;
  opt_parent = opt_parent || this.viewport;
  opt_priority = (typeof opt_priority !== 'undefined') ? opt_priority :
                 this.priority++;
  var drawPassInfo = o3djs.rendergraph.createDrawPassInfo(
     this.pack,
     opt_drawContext,
     sortMethod,
     opt_parent,
     opt_drawList);
  drawPassInfo.root.priority = opt_priority;
  this.treeTraversal.registerDrawList(
      drawPassInfo.drawList, opt_drawContext, true);

  this.drawPassInfos_.push(drawPassInfo);

  return drawPassInfo;
};

/**
 * Creates a DrawPassInfo to manage a draw pass.
 *
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3d.DrawContext} drawContext The DrawContext for this draw pass.
 * @param {o3d.DrawList.SortMethod} sortMethod How to sort this draw pass's
 *     DrawElements.
 * @param {!o3d.DrawList} opt_drawList The DrawList for this draw pass. If not
 *     passed in one will be created.
 * @param {!o3d.RenderNode} opt_parent The RenderNode to parent this draw pass
 *     under. If not passed the draw pass will not be parented.
 * @return {!o3djs.rendergraph.DrawPassInfo}
 */
o3djs.rendergraph.createDrawPassInfo = function(
    pack,
    drawContext,
    sortMethod,
    opt_parent,
    opt_drawList) {
  return new o3djs.rendergraph.DrawPassInfo(
      pack, drawContext, sortMethod, opt_parent, opt_drawList);
};

/**
 * A class to manage a draw pass.
 * @constructor
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3d.DrawContext} drawContext The DrawContext for this draw pass.
 * @param {o3d.DrawList.SortMethod} sortMethod How to sort this draw pass's
 *     DrawElements.
 * @param {!o3d.DrawList} opt_drawList The DrawList for this draw pass. If not
 *     passed in one will be created.
 * @param {!o3d.RenderNode} opt_parent The RenderNode to parent this draw pass
 *     under. If not passed the draw pass will not be parented.
 * @return {!o3djs.rendergraph.DrawPassInfo}
 */
o3djs.rendergraph.DrawPassInfo = function(pack,
                                          drawContext,
                                          sortMethod,
                                          opt_parent,
                                          opt_drawList) {
  var ownDrawList = opt_drawList ? false : true;

  opt_parent = opt_parent || null;
  opt_drawList = opt_drawList || pack.createObject('DrawList');

  var stateSet = pack.createObject('StateSet');
  var state = pack.createObject('State');
  stateSet.state = state;
  stateSet.parent = opt_parent;

  var drawPass = pack.createObject('DrawPass');
  drawPass.drawList = opt_drawList;
  drawPass.sortMethod = sortMethod;
  drawPass.parent = stateSet;

  /**
   * The pack managing the objects created for this DrawPassInfo.
   * @type {!o3d.Pack}
   */
  this.pack = pack;

  /**
   * The State that affects all things drawn in this DrawPassInfo.
   * @type {!o3d.State}
   */
  this.state = state;

  /**
   * The StateSet that applies the state for this DrawPassInfo.
   * @type {!o3d.StateSet}
   */
  this.stateSet = stateSet;

  /**
   * The DrawPass for this DrawPassInfo.
   * @type {!o3d.DrawPass}
   */
  this.drawPass = drawPass;

  /**
   * The DrawList for this DrawPassInfo.
   * @type {!o3d.DrawList}
   */
  this.drawList = opt_drawList;

  /**
   * The root RenderNode of this DrawPassInfo. This is the RenderNdoe you should
   * use if you want to turn this draw pass off or reparent it.
   * @type {!o3d.RenderNode}
   */
  this.root = stateSet;

  /**
   * A flag whether or not we created the DrawList for this DrawPassInfo.
   * @private
   * @type {boolean}
   */
  this.ownDrawList_ = ownDrawList;
};

/**
 * Frees the resources created for this DrawPassInfo.
 */
o3djs.rendergraph.DrawPassInfo.prototype.destroy = function() {
  // Remove everything we created from the pack.
  if (this.ownDrawList_) {
    this.drawPass.drawList = null;
    this.pack.removeObject(this.drawList);
  }
  this.drawPass.parent = null;
  this.stateSet.parent = null;
  this.pack.removeObject(this.drawPass);
  this.pack.removeObject(this.stateSet);
  this.pack.removeObject(this.state);
};

