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
 * A DrawList gets used during rendering to collect DrawElements to
 * render.  Each Material references a DrawList.  Depending on the material, as
 * DrawElements get collected they will be put on different DrawLists.
 * @constructor
 */
o3d.DrawList = function() {
  o3d.NamedObject.call(this);
  this.list_ = [];
};
o3d.inherit('DrawList', 'NamedObject');

/**
 * Private list to actually hold the DrawElements
 * @type {!Array.<!Object>}
 */
this.list_ = [];


/**
 * @type {number}
 */
o3d.DrawList.SortMethod = goog.typedef;


/**
 *  SortMethod,
 *    BY_PERFORMANCE
 *    BY_Z_ORDER
 *    BY_PRIORITY
 *
 * Method to sort DrawList by.
 */
o3d.DrawList.BY_PERFORMANCE = 0;
o3d.DrawList.BY_Z_ORDER = 1;
o3d.DrawList.BY_PRIORITY = 2;


/**
 * Compare function for by-priority sort.
 */
o3d.DrawList.comparePriority_ = function(drawElementInfoA, drawElementInfoB) {
  return drawElementInfoA.drawElement.owner.priority -
         drawElementInfoB.drawElement.owner.priority;
};


/**
 * Compare function for by-z-coordinate sort.
 * @param {!o3d.DrawElement} drawElementInfoA
 * @param {!o3d.DrawElement} drawElementInfoB
 */
o3d.DrawList.compareZ_ = function(drawElementInfoA, drawElementInfoB) {
  return o3d.Transform.transformPointZOnly(
            drawElementInfoB.worldViewProjection,
            drawElementInfoB.drawElement.owner.zSortPoint) -
         o3d.Transform.transformPointZOnly(
            drawElementInfoA.worldViewProjection,
            drawElementInfoA.drawElement.owner.zSortPoint);
};


/**
 * Sorts this list according to the given sort method.
 * @param {o3d.DrawList.SortMethod} sort_method Which method to use.
 * @private
 */
o3d.DrawList.prototype.sort_ = function(sort_method) {
  switch (sort_method) {
    case o3d.DrawList.BY_PRIORITY:
      this.list_.sort(o3d.DrawList.comparePriority_);
      break;

    case o3d.DrawList.BY_Z_ORDER:
      this.list_.sort(o3d.DrawList.compareZ_);
      break;

    case o3d.DrawList.BY_PERFORMANCE:
    default:
      break;
  }
};


/**
 * Renders the draw list.
 */
o3d.DrawList.prototype.render = function() {
  for (var i = 0; i < this.list_.length; ++i) {
    var drawElementInfo = this.list_[i];
    var world = drawElementInfo.world;
    var view = drawElementInfo.view;
    var viewProjection = drawElementInfo.viewProjection;
    var worldViewProjection = drawElementInfo.worldViewProjection;
    var projection = drawElementInfo.projection;
    var transform = drawElementInfo.transform;
    var drawElement = drawElementInfo.drawElement;
    var element = drawElement.owner;
    var material = drawElement.material || element.material;
    var effect = material.effect;

    o3d.Param.SAS.setWorld(world);
    o3d.Param.SAS.setView(view);
    o3d.Param.SAS.setProjection(projection);
    o3d.Param.SAS.setViewProjection(viewProjection);
    o3d.Param.SAS.setWorldViewProjection(worldViewProjection);

    var paramObjects = [
      transform,
      drawElement,
      element
    ];
    if (element.streamBank) {
      paramObjects.push(element.streamBank);
    }
    paramObjects.push(
      material,
      effect,
      o3d.Param.SAS);

    effect.searchForParams_(paramObjects);

    var state_on = (material.state != undefined);
    if (state_on) {
      material.state.push_();
    }
    element.render();
    if (state_on) {
      material.state.pop_();
    }
  }
};


