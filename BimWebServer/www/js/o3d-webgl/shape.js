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
 * The Shape represents a collection of Elements. The typical example is a
 * cube with 6 faces where each face uses a different material would be
 * represented as 1 Shape with 6 Elements, one for each material.
 * @constructor
 */
o3d.Shape = function() {
  o3d.ParamObject.call(this);
  this.elements = [];
};
o3d.inherit('Shape', 'ParamObject');


/**
 * The elements owned by this shape.
 *
 * Each access to this field gets the entire list so it is best to get it
 * just once. For example:
 *
 * var elements = renderNode.elements;
 * for (var i = 0; i < elements.length; i++) {
 *   var element = elements[i];
 * }
 *
 * Note that modifications to this array [e.g. push()] will not affect
 * the underlying Shape, while modifications to the array's members
 * will affect them.
 */
o3d.Shape.prototype.elements = [];


/**
 * Finds a draw element in the given list of draw elements that uses the given
 * material if such a draw element exists.  Returns null otherwise.
 * @param {Array.<!o3d.DrawElements>} drawElements An array of draw elements.
 * @param {o3d.Material} material A material to search for.
 * @private
 */
o3d.Shape.findDrawElementWithMaterial_ = function(drawElements, material) {
  for (var j = 0; j < drawElements.length; ++j) {
    if (drawElements[j].material == material) {
      return drawElements[j];
    }
  }
  return null;
};


/**
 * Creates a DrawElement for each Element owned by this Shape.
 * If an Element already has a DrawElement that uses material a new
 * DrawElement will not be created.
 * @param {o3d.Pack} pack pack used to manage created DrawElements.
 * @param {o3d.Material} material material to use for each DrawElement.
 *     Note: When a DrawElement with a material of null is rendered, the
 *     material on the corresponding Element will get used instead.
 *     This allows you to easily setup the default (just draw as is) by
 *     passing null or setup a shadow pass by passing in a shadow material.
 */
o3d.Shape.prototype.createDrawElements =
    function(pack, material) {
  var elements = this.elements;
  for (var i = 0; i < elements.length; ++i) {
    var element = elements[i];
    if (!o3d.Shape.findDrawElementWithMaterial_(element.drawElements,
                                                material)) {
      element.createDrawElement(pack, material);
    }
  }
};


/**
 * Adds and element to the list of elements for this shape.
 * @param {o3d.Element} element The element to add.
 */
o3d.Shape.prototype.addElement = function(element) {
  this.elements.push(element);
};


/**
 * Removes and element to the list of elements for this shape.
 * @param {o3d.Element} element The element to add.
 */
o3d.Shape.prototype.removeElement = function(element) {
  o3d.removeFromArray(this.elements, element);
};


/**
 * Called when the tree traversal finds this shape in the transform tree.
 * Adds objects to the given drawlists if the drawlist of the material matches.
 * @param {Array.<Object>} drawListInfos A list of objects containing
 *     drawlists and matrix info.
 * @param {o3d.math.Matrix4} world The world matrix.
 */
o3d.Shape.prototype.writeToDrawLists =
    function(drawListInfos, world, transform) {
  var elements = this.elements;

  // Iterate through elements of this shape.
  for (var i = 0; i < elements.length; ++i) {
    var element = elements[i];

    // For each element look at the DrawElements for that element.
    for (var j = 0; j < element.drawElements.length; ++j) {
      this.gl.client.render_stats_['drawElementsProcessed']++;
      var drawElement = element.drawElements[j];
      var material = drawElement.material || drawElement.owner.material;
      var materialDrawList = material.drawList;
      var rendered = false;

      // Iterate through the drawlists we might write to.
      for (var k = 0; k < drawListInfos.length; ++k) {
        var drawListInfo = drawListInfos[k];
        var list = drawListInfo.list;

        // If any of those drawlists matches the material on the drawElement,
        // add the drawElement to the list.
        if (materialDrawList == list) {
          var context = drawListInfo.context;
          var view = context.view;
          var projection = context.projection;

          var worldViewProjection = [[], [], [], []];
          var viewProjection = [[], [], [], []];
          o3d.Transform.compose(projection, view, viewProjection);
          o3d.Transform.compose(viewProjection, world, worldViewProjection);

          if (element.cull && element.boundingBox) {
            if (!element.boundingBox.inFrustum(worldViewProjection)) {
              continue;
            }
          }

          rendered = true;
          list.list_.push({
            view: view,
            projection: projection,
            world: world,
            viewProjection: viewProjection,
            worldViewProjection: worldViewProjection,
            transform: transform,
            drawElement: drawElement
          });
        }
      }

      if (rendered) {
        this.gl.client.render_stats_['drawElementsRendered']++;
      } else {
        this.gl.client.render_stats_['drawElementsCulled']++;
      }
    }
  }
};


