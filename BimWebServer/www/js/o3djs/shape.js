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
 * @fileoverview This file contains various functions for helping setup
 * shapes for o3d.  It puts them in the "shape" module on the o3djs
 * object.
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.shape');

o3djs.require('o3djs.math');
o3djs.require('o3djs.element');

/**
 * A Module for shapes.
 * @namespace
 */
o3djs.shape = o3djs.shape || {};

/**
 * Adds missing tex coord streams to a shape's elements.
 * @param {!o3d.Shape} shape Shape to add missing streams to.
 * @see o3djs.element.addMissingTexCoordStreams
 */
o3djs.shape.addMissingTexCoordStreams = function(shape) {
  var elements = shape.elements;
  for (var ee = 0; ee < elements.length; ++ee) {
    var element = elements[ee];
    o3djs.element.addMissingTexCoordStreams(element);
  }
};

/**
 * Sets the bounding box and z sort points of a shape's elements.
 * @param {!o3d.Shape} shape Shape to set info on.
 */
o3djs.shape.setBoundingBoxesAndZSortPoints = function(shape) {
  var elements = shape.elements;
  for (var ee = 0; ee < elements.length; ++ee) {
    var element = elements[ee];
    o3djs.element.setBoundingBoxAndZSortPoint(element);
  }
};

/**
 * Prepares a shape by setting its boundingBox, zSortPoint and creating
 * DrawElements.
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3d.Shape} shape Shape to prepare.
 */
o3djs.shape.prepareShape = function(pack, shape) {
  shape.createDrawElements(pack, null);
  o3djs.shape.setBoundingBoxesAndZSortPoints(shape);
  o3djs.shape.addMissingTexCoordStreams(shape);
};

/**
 * Prepares all the shapes in the given pack by setting their boundingBox,
 * zSortPoint and creating DrawElements.
 * @param {!o3d.Pack} pack Pack to manage created objects.
 */
o3djs.shape.prepareShapes = function(pack) {
  var shapes = pack.getObjectsByClassName('o3d.Shape');
  for (var ss = 0; ss < shapes.length; ++ss) {
    o3djs.shape.prepareShape(pack, shapes[ss]);
  }
};

/**
 * Attempts to delete the parts of a shape that were created by
 * duplicateShape as well as any drawElements attached to it.
 * @param {!o3d.Shape} shape shape to delete.
 * @param {!o3d.Pack} pack Pack to release objects from.
 */
o3djs.shape.deleteDuplicateShape = function(shape, pack) {
   var elements = shape.elements;
   for (var ee = 0; ee < elements.length; ee++) {
     var element = elements[ee];
     var drawElements = element.drawElements;
     for (var dd = 0; dd < drawElements.length; dd++) {
       var drawElement = drawElements[dd];
       pack.removeObject(drawElement);
     }
     pack.removeObject(element);
   }
   pack.removeObject(shape);
};

/**
 * Copies a shape's elements and streambank or buffers so the two will share
 * streambanks, vertex and index buffers.
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3d.Shape} source The Shape to copy.
 * @return {!o3d.Shape} the new copy of the shape.
 */
o3djs.shape.duplicateShape = function(pack, source) {
  var newShape = pack.createObject('Shape');
  var elements = source.elements;
  for (var ee = 0; ee < elements.length; ee++) {
    var newElement = o3djs.element.duplicateElement(pack, elements[ee]);
    newElement.owner = newShape;
  }
  newShape.createDrawElements(pack, null);
  return newShape;
};

