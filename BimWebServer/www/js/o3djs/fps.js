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
 * @fileoverview This file contains a class for displaying frames per second.
 */

o3djs.provide('o3djs.fps');

o3djs.require('o3djs.rendergraph');
o3djs.require('o3djs.canvas');
o3djs.require('o3djs.effect');
o3djs.require('o3djs.math');
o3djs.require('o3djs.primitives');

/**
 * A Module with a fps class for helping to easily display frames per second.
 * @namespace
 */
o3djs.fps = o3djs.fps || {};

/**
 * Number of frames to average over for computing FPS.
 * @type {number}
 */
o3djs.fps.NUM_FRAMES_TO_AVERAGE = 16;

/**
 * Colors used for each second of the performance bar.
 * @type {!Array.<!o3djs.math.Vector4>}
 */
o3djs.fps.PERF_BAR_COLORS = [
  [0, 0, 1, 1],
  [0, 1, 0, 1],
  [1, 1, 0, 1],
  [1, 0.5, 0, 1],
  [1, 0, 0, 1]];

/**
 * Generate a shader to be used by the pref quads.
 * @return {string}
 */
o3djs.fps.buildShaderString = function() {
  var p = o3djs.effect;

  var varyingDecls = p.BEGIN_OUT_STRUCT +
    p.VARYING + p.FLOAT4 + ' ' +
    p.VARYING_DECLARATION_PREFIX + 'position' +
    p.semanticSuffix('POSITION') + ';\n' +
    p.END_STRUCT;

  return '' +
    'uniform ' + p.MATRIX4 + ' worldViewProjection' +
    p.semanticSuffix('WORLDVIEWPROJECTION') + ';\n' +
    '\n' +
    p.BEGIN_IN_STRUCT +
    p.ATTRIBUTE + p.FLOAT4 + ' position' +
    p.semanticSuffix('POSITION') + ';\n' +
    p.END_STRUCT +
    '\n' +
    varyingDecls +
    '\n' +
    p.beginVertexShaderMain() +
    '  ' + p.VERTEX_VARYING_PREFIX + 'position = ' +
    p.mul(p.ATTRIBUTE_PREFIX + 'position',
        'worldViewProjection') + ';\n' +
    p.endVertexShaderMain() +
    '\n' +
    p.pixelShaderHeader() +
    'uniform ' + p.FLOAT4 + ' color;\n' +
    p.repeatVaryingDecls(varyingDecls) +
    p.beginPixelShaderMain() +
    p.endPixelShaderMain('color') +
    p.entryPoints() +
    p.matrixLoadOrder();
};


/**
 * Creates an object for displaying frames per second.
 *
 * You can use it like this.
 * <pre>
 * &lt;html&gt;&lt;body&gt;
 * &lt;script type="text/javascript" src="o3djs/base.js"&gt;
 * &lt;/script&gt;
 * &lt;script type="text/javascript"&gt;
 * o3djs.require('o3djs.util');
 * o3djs.require('o3djs.rendergraph');
 * o3djs.require('o3djs.fps');
 * window.onload = init;
 * window.onunload = uninit;
 *
 * var g_client;
 * var g_fpsManager;
 *
 * function init() {
 *   o3djs.base.makeClients(initStep2);
 * }
 *
 * function initStep2(clientElements) {
 *   var clientElement = clientElements[0];
 *   var g_client = clientElement.client;
 *   var pack = g_client.createPack();
 *   var viewInfo = o3djs.rendergraph.createBasicView(
 *       pack,
 *       g_client.root,
 *       g_client.renderGraphRoot);
 *   g_fpsManager = o3djs.fps.createFPSManager(pack,
 *                                             g_client.width,
 *                                             g_client.height,
 *                                             g_client.renderGraphRoot);
 *   g_client.setRenderCallback(onRender);
 * }
 *
 * function onrender(renderEvent) {
 *   g_fpsManager.update(renderEvent);
 * }
 *
 * function uninit() {
 *   if (g_client) {
 *     g_client.cleanup();
 *   }
 * }
 * &lt;/script&gt;
 * &lt;div id="o3d" style="width: 600px; height: 600px"&gt;&lt;/div&gt;
 * &lt;/body&gt;&lt;/html&gt;
 * </pre>
 *
 * @param {!o3d.Pack} pack Pack to create objects in.
 * @param {number} clientWidth width of client area.
 * @param {number} clientHeight Height of client area.
 * @param {!o3d.RenderNode} opt_parent RenderNode to use as parent for
 *     ViewInfo that will be used to render the FPS with.
 * @return {!o3djs.fps.FPSManager} The created FPSManager.
 */
o3djs.fps.createFPSManager = function(pack,
                                      clientWidth,
                                      clientHeight,
                                      opt_parent) {
  return new o3djs.fps.FPSManager(pack, clientWidth, clientHeight, opt_parent);
};

/**
 * A class for displaying frames per second.
 * @constructor
 * @param {!o3d.Pack} pack Pack to create objects in.
 * @param {number} clientWidth width of client area.
 * @param {number} clientHeight Height of client area.
 * @param {!o3d.RenderNode} opt_parent RenderNode to use as parent for
 *     ViewInfo that will be used to render the FPS with.
 */
o3djs.fps.FPSManager = function(pack, clientWidth, clientHeight, opt_parent) {
  // total time spent for last N frames.
  this.totalTime_ = 0.0;

  // total active time  for last N frames.
  this.totalActiveTime_ = 0.0;

  // elapsed time for last N frames.
  this.timeTable_ = [];

  // active time for last N frames.
  this.activeTimeTable_ = [];

  // where to record next elapsed time.
  this.timeTableCursor_ = 0;

  // Initialize the FPS elapsed time history table.
  for (var tt = 0; tt < o3djs.fps.NUM_FRAMES_TO_AVERAGE; ++tt) {
    this.timeTable_[tt] = 0.0;
    this.activeTimeTable_[tt] = 0.0;
  }

  // The root transform for this sub graph.
  this.root_ = pack.createObject('Transform');

  /**
   * The ViewInfo to display FPS.
   * @type {!o3djs.rendergraph.ViewInfo}
   */
  this.viewInfo = o3djs.rendergraph.createBasicView(pack,
                                                    this.root_,
                                                    opt_parent);
  this.viewInfo.root.priority = 100000;
  this.viewInfo.clearBuffer.clearColorFlag = false;

  this.viewInfo.zOrderedState.getStateParam('CullMode').value =
      o3djs.base.o3d.State.CULL_NONE;

  this.viewInfo.drawContext.view = o3djs.math.matrix4.lookAt(
      [0, 0, 1],  // eye
      [0, 0, 0],  // target
      [0, 1, 0]); // up

  // create a view just for the FPS. That way it's indepdendent of other views.
  this.canvasLib_ = o3djs.canvas.create(pack,
                                        this.root_,
                                        this.viewInfo);

  this.paint_ = pack.createObject('CanvasPaint');

  /**
   * The quad used to display the FPS.
   *
   */
  this.fpsQuad = this.canvasLib_.createXYQuad(0, 0, -1, 64, 32, true);

  // create a unit plane with a const color effect we can use to draw
  // rectangles.
  this.colorEffect_ = pack.createObject('Effect');
  this.colorEffect_.loadFromFXString(o3djs.fps.buildShaderString());
  this.colorMaterial_ = pack.createObject('Material');
  this.colorMaterial_.effect = this.colorEffect_;
  this.colorMaterial_.drawList = this.viewInfo.zOrderedDrawList;
  this.colorEffect_.createUniformParameters(this.colorMaterial_);
  this.colorMaterial_.getParam('color').value = [1, 1, 1, 1];
  this.colorQuadShape_ = o3djs.primitives.createPlane(
     pack,
     this.colorMaterial_,
     1,
     1,
     1,
     1,
     [[1, 0, 0, 0],
      [0, 0, 1, 0],
      [0, -1, 0, 0],
      [0.5, 0.5, 0, 1]]);

  var barXOffset = 10;
  var barYOffset = 2;
  var barWidth = clientWidth - barXOffset * 2;
  var barHeight = 7;
  this.numPerfBars_ = o3djs.fps.PERF_BAR_COLORS.length - 1;
  this.perfBarRoot_ = pack.createObject('Transform');
  this.perfBarRoot_.parent = this.root_;
  this.perfBarBack_ = new o3djs.fps.ColorRect(
      pack, this.colorQuadShape_, this.perfBarRoot_,
      barXOffset, barYOffset, -3, barWidth, barHeight,
      [0, 0, 0, 1]);
  this.perfMarker_ = [];
  for (var ii = 0; ii < this.numPerfBars_; ++ii) {
    this.perfMarker_[ii] = new o3djs.fps.ColorRect(
        pack, this.colorQuadShape_, this.perfBarRoot_,
        barXOffset + barWidth / (this.numPerfBars_ + 1) * (ii + 1),
        barYOffset - 1, -1,
        1, barHeight + 2,
        [1, 1, 1, 1]);
  }
  this.perfBar_ = new o3djs.fps.ColorRect(
      pack, this.colorQuadShape_, this.perfBarRoot_,
      barXOffset + 1, barYOffset + 1, -2, 1, barHeight - 2,
      [1, 1, 0, 1]);
  this.perfBarWidth_ = barWidth - 2;
  this.perfBarHeight_ = barHeight - 2;
  this.perfBarXOffset_ = barXOffset;
  this.perfBarYOffset_ = barYOffset;

  // set the size and position.
  this.resize(clientWidth, clientHeight);
  this.setPosition(10, 10);
};

/**
 * Sets the position of the FPS display
 *
 * The position is in pixels assuming the size of the client matches the size
 * last set either on creation or with FPSManager.resize.
 *
 * @param {number} x The x position.
 * @param {number} y The y position.
 */
o3djs.fps.FPSManager.prototype.setPosition = function(x, y) {
  this.fpsQuad.transform.identity();
  this.fpsQuad.transform.translate(x, y, -1);
};

/**
 * Sets the visiblity of the fps display.
 * @param {boolean} visible true = visible.
 */
o3djs.fps.FPSManager.prototype.setVisible = function(visible) {
  this.viewInfo.root.active = visible;
};

/**
 * Sets the visibility of the performance bar.
 * @param {boolean} visible true = visible.
 */
o3djs.fps.FPSManager.prototype.setPerfVisible = function(visible) {
  this.perfBarRoot_.visible = visible;
};

/**
 * Resizes the area for the FPS display.
 * Note: you must call this if your client area changes size.
 * @param {number} clientWidth width of client area.
 * @param {number} clientHeight height of client area.
 */
o3djs.fps.FPSManager.prototype.resize = function(clientWidth, clientHeight) {
  this.viewInfo.drawContext.projection = o3djs.math.matrix4.orthographic(
      0 + 0.5,
      clientWidth + 0.5,
      clientHeight + 0.5,
      0 + 0.5,
      0.001,
      1000);

  var barWidth = clientWidth - this.perfBarXOffset_ * 2;
  this.perfBarBack_.setSize(barWidth, this.perfBarHeight_);
  for (var ii = 0; ii < this.numPerfBars_; ++ii) {
    this.perfMarker_[ii].setPosition(
      this.perfBarXOffset_ + barWidth / (this.numPerfBars_ + 1) * (ii + 1),
      this.perfBarYOffset_ - 1);
  }
  this.perfBarWidth_ = barWidth - 2;
};

/**
 * Updates the fps display.
 * You must call this every frame to update the FPS display.
 *
 * <pre>
 * ...
 * client.setRenderCallback(onRender);
 * ...
 * function onRender(renderEvent) {
 *   myFpsManager.update(renderEvent);
 * }
 * </pre>
 *
 * @param {!o3d.RenderEvent} renderEvent The object passed into the render
 *     callback.
 */
o3djs.fps.FPSManager.prototype.update = function(renderEvent) {
  var elapsedTime = renderEvent.elapsedTime;
  var activeTime = renderEvent.activeTime;
  // Keep the total time and total active time for the last N frames.
  this.totalTime_ += elapsedTime - this.timeTable_[this.timeTableCursor_];
  this.totalActiveTime_ +=
      activeTime - this.activeTimeTable_[this.timeTableCursor_];

  // Save off the elapsed time for this frame so we can subtract it later.
  this.timeTable_[this.timeTableCursor_] = elapsedTime;
  this.activeTimeTable_[this.timeTableCursor_] = activeTime;

  // Wrap the place to store the next time sample.
  ++this.timeTableCursor_;
  if (this.timeTableCursor_ == o3djs.fps.NUM_FRAMES_TO_AVERAGE) {
    this.timeTableCursor_ = 0;
  }

  // Print the average frame rate for the last N frames as well as the
  // instantaneous frame rate.
  var fps = '' +
      Math.floor((1.0 / (this.totalTime_ /
                  o3djs.fps.NUM_FRAMES_TO_AVERAGE)) + 0.5) +
      ' : ' + Math.floor(1.0 / elapsedTime + 0.5);

  var canvas = this.fpsQuad.canvas;
  canvas.clear([0, 0, 0, 0]);

  var paint = this.paint_;

  canvas.saveMatrix();
  paint.setOutline(3, [0, 0, 0, 1]);
  paint.textAlign = o3djs.base.o3d.CanvasPaint.LEFT;
  paint.textSize = 12;
  paint.textTypeface = 'Arial';
  paint.color = [1, 1, 0, 1];
  canvas.drawText(fps, 2, 16, paint);
  canvas.restoreMatrix();

  this.fpsQuad.updateTexture();

  var frames = this.totalActiveTime_ / o3djs.fps.NUM_FRAMES_TO_AVERAGE /
               (1 / 60.0);
  var colorIndex = Math.min(frames, o3djs.fps.PERF_BAR_COLORS.length - 1);
  colorIndex = Math.floor(Math.max(colorIndex, 0));

  if (!isNaN(colorIndex)) {
    this.perfBar_.setColor(o3djs.fps.PERF_BAR_COLORS[colorIndex]);
    this.perfBar_.setSize(frames * this.perfBarWidth_ / this.numPerfBars_,
                          this.perfBarHeight_);
  }
};

/**
 * A Class the manages a color rect.
 * @constructor
 * @param {!o3d.Pack} pack Pack to create things in.
 * @param {!o3d.Shape} shape Shape to use for rectangle.
 * @param {!o3d.Transform} parent Transform to parent rect under.
 * @param {number} x initial x position.
 * @param {number} y initial y position.
 * @param {number} z initial z position.
 * @param {number} width initial width.
 * @param {number} height initial height.
 * @param {!o3djs.math.Vector4} color initial color.
 */
o3djs.fps.ColorRect = function(pack, shape, parent,
                               x, y, z, width, height, color) {
  this.transform_ = pack.createObject('Transform');
  this.colorParam_ = this.transform_.createParam('color', 'ParamFloat4');
  this.transform_.addShape(shape);
  this.transform_.parent = parent;
  this.width_ = 0;
  this.height_ = 0;
  this.x_ = 0;
  this.y_ = 0;
  this.z_ = z;
  this.setPosition(x, y);
  this.setSize(width, height);
  this.setColor(color);
};

/**
 * Updates the transform of this ColorRect
 * @private
 */
o3djs.fps.ColorRect.prototype.updateTransform_ = function() {
  this.transform_.identity();
  this.transform_.translate(this.x_, this.y_, this.z_);
  this.transform_.scale(this.width_, this.height_, 1);
};

/**
 * Sets the position of this ColorRect.
 * @param {number} x x position.
 * @param {number} y y position.
 */
o3djs.fps.ColorRect.prototype.setPosition = function(x, y) {
  this.x_ = x;
  this.y_ = y;
  this.updateTransform_();
};

/**
 * Sets the size of this ColorRect
 * @param {number} width width.
 * @param {number} height height.
 */
o3djs.fps.ColorRect.prototype.setSize = function(width, height) {
  this.width_ = width;
  this.height_ = height;
  this.updateTransform_();
};

/**
 * Sets the color of this ColorRect.
 * @param {!o3djs.math.Vector4} color initial color.
 */
o3djs.fps.ColorRect.prototype.setColor = function(color) {
  this.colorParam_.value = color;
};


