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
 * @fileoverview This file contains functions for implementing picking.
 * It puts them in the "picking" module on the o3djs object.
 *
 *
 * This example shows one way to implement picking. Because O3D is shader
 * agnostic we can't handle picking automatically since we have no way of
 * knowing what the developer is going to do with their shaders. On the other
 * hand, we can provide various functions that make it possible to do your own
 * picking. Only you know which objects are pickable and which are not. For
 * example if you are making an RTS game, only you would know that units are
 * pickable but ground and explosions are not and that neither is your HUD.
 * Similarly, only you would know how your shaders manipulate the vertices
 * passed to them.
 *
 * It's possible that someone, maybe us, will create an engine to use o3d
 * that given a bunch of restrictions and flags on the data it accepts can
 * do picking in a more automatic way but that is not the goal of the o3d
 * api. Its goal is to provide a LOW-LEVEL shader agnostic API.
 */

o3djs.provide('o3djs.picking');

o3djs.require('o3djs.math');
o3djs.require('o3djs.dump');

/**
 * A Module for picking.
 * @namespace
 */
o3djs.picking = o3djs.picking || {};

/**
 * A ray.
 * @type {{near: !o3djs.math.Vector3, far: !o3djs.math.Vector3}}
 */
o3djs.picking.Ray = goog.typedef;

/**
 * Creates a new PickInfo.
 * @param {!o3d.Element} element The Element that was picked.
 * @param {!o3djs.picking.ShapeInfo} shapeInfo The ShapeInfo that was picked.
 * @param {!o3d.RayIntersectionInfo} rayIntersectionInfo Information about the
 *     pick.
 * @param {!o3djs.math.Vector3} worldIntersectionPosition world position of
 *     intersection.
 * @return {!o3djs.picking.PickInfo} The new PickInfo.
 */
o3djs.picking.createPickInfo = function(element,
                                        shapeInfo,
                                        rayIntersectionInfo,
                                        worldIntersectionPosition) {
  return new o3djs.picking.PickInfo(element,
                                    shapeInfo,
                                    rayIntersectionInfo,
                                    worldIntersectionPosition);
};

/**
 * Creates a new ShapeInfo.
 * @param {!o3d.Shape} shape Shape to keep info about.
 * @param {!o3djs.picking.TransformInfo} parent Parent transform of the shape.
 * @return {!o3djs.picking.ShapeInfo} The new ShapeInfo.
 */
o3djs.picking.createShapeInfo = function(shape, parent) {
  return new o3djs.picking.ShapeInfo(shape, parent);
};

/**
 * Creates a new TransformInfo.
 * @param {!o3d.Transform} transform Transform to keep info about.
 * @param {o3djs.picking.TransformInfo} parent Parent transform of the
 *     transform. Can be null.
 * @return {!o3djs.picking.TransformInfo} The new TransformInfo.
 */
o3djs.picking.createTransformInfo = function(transform, parent) {
  return new o3djs.picking.TransformInfo(transform, parent);
};

/**
 * Convert a pixel position relative to the top left corner of the client area
 * into the corresponding ray through the frustum in world space.
 * @param {number} clientXPosition x position relative to client area.
 * @param {number} clientYPosition y position relative to client area.
 * @param {!o3djs.math.Matrix4} view View matrix to transform with.
 * @param {!o3djs.math.Matrix4} projection Projection matrix to transform
 *     with.
 * @param {number} clientWidth width of client area.
 * @param {number} clientHeight height of client area.
 * @return {!o3djs.picking.Ray} ray in world space.
 */
o3djs.picking.clientPositionToWorldRayEx = function(clientXPosition,
                                                    clientYPosition,
                                                    view,
                                                    projection,
                                                    clientWidth,
                                                    clientHeight) {
  // compute the world position of a ray going through the view frustum
  var inverseViewProjectionMatrix = o3djs.math.inverse(
      o3djs.math.matrix4.composition(projection, view));
  // normScreenX, normScreenY are in frustum coordinates.
  var normScreenX = clientXPosition / (clientWidth * 0.5) - 1;
  var normScreenY = -(clientYPosition / (clientHeight * 0.5) - 1);

  // Apply inverse view-projection matrix to get the ray in world coordinates.
  return {
      near: o3djs.math.matrix4.transformPoint(
          inverseViewProjectionMatrix, [normScreenX, normScreenY, 0]),
      far: o3djs.math.matrix4.transformPoint(
          inverseViewProjectionMatrix, [normScreenX, normScreenY, 1])
  };
};

/**
 * Convert a pixel position relative to the top left corner of the client area
 * into the corresponding ray through the frustum in world space.
 * @param {number} clientXPosition x position relative to client area.
 * @param {number} clientYPosition y position relative to client area.
 * @param {!o3d.DrawContext} drawContext DrawContext to get view and
 *     projection matrices from.
 * @param {number} clientWidth width of client area.
 * @param {number} clientHeight height of client area.
 * @return {!o3djs.picking.Ray} ray in world space.
 */
o3djs.picking.clientPositionToWorldRay = function(clientXPosition,
                                                  clientYPosition,
                                                  drawContext,
                                                  clientWidth,
                                                  clientHeight) {
  return o3djs.picking.clientPositionToWorldRayEx(
      clientXPosition,
      clientYPosition,
      drawContext.view,
      drawContext.projection,
      clientWidth,
      clientHeight);
};

/**
 * A local dump function so we can easily comment it out.
 * @param {string} msg Message to dump.
 */
o3djs.picking.dprint = function(msg) {
  //o3djs.dump.dump(msg);
};

/**
 * A local dump function so we can easily comment it out.
 * @param {string} label Label to print before value.
 * @param {!o3djs.math.Vector3} float3 Value to print.
 * @param {string} prefix optional prefix for indenting.
 */
o3djs.picking.dprintPoint3 = function(label, float3, prefix) {
  //o3djs.dump.dumpPoint3(label, float3, prefix);
};

/**
 * A local dump function so we can easily comment it out.
 * @param {string} label Label to put in front of dump.
 * @param {!o3d.BoundingBox} boundingBox BoundingBox to dump.
 * @param {string} opt_prefix optional prefix for indenting.
 */
o3djs.picking.dprintBoundingBox = function(label,
                                           boundingBox,
                                           opt_prefix) {
  //o3djs.dump.dumpBoundingBox(label, boundingBox, opt_prefix);
};

/**
 * A local dump function so we can easily comment it out.
 * @param {string} label Label to print before value.
 * @param {!o3d.RayIntersectionInfo} rayIntersectionInfo Value to print.
 */
o3djs.picking.dumpRayIntersectionInfo = function(label,
                                                 rayIntersectionInfo) {
  o3djs.picking.dprint(label + ' : valid = ' +
  rayIntersectionInfo.valid + ' : intersected = ' +
  rayIntersectionInfo.intersected);
  if (rayIntersectionInfo.intersected) {
    o3djs.picking.dprint(
        ' : pos: ' +
        rayIntersectionInfo.position[0] + ', ' +
        rayIntersectionInfo.position[1] + ', ' +
        rayIntersectionInfo.position[2] + ', ');
  }
  o3djs.picking.dprint('\n');
};

/**
 * Creates a new PickInfo. Used to return picking information.
 * @constructor
 * @param {!o3d.Element} element The Element that was picked.
 * @param {!o3djs.picking.ShapeInfo} shapeInfo The ShapeInfo that was picked.
 * @param {!o3d.RayIntersectionInfo} rayIntersectionInfo Information about the
 *     pick.
 * @param {!o3djs.math.Vector3} worldIntersectionPosition world position of
 *     intersection.
 */
o3djs.picking.PickInfo = function(element,
                                  shapeInfo,
                                  rayIntersectionInfo,
                                  worldIntersectionPosition) {
  /**
   * The Element that was picked (Primitive).
   * @type {!o3d.Element}
   */
  this.element = element;

  /**
   * The ShapeInfo that was picked.
   * @type {!o3djs.picking.ShapeInfo}
   */
  this.shapeInfo = shapeInfo;

  /**
   * Information about the pick.
   * @type {!o3d.RayIntersectionInfo}
   */
  this.rayIntersectionInfo = rayIntersectionInfo;

  /**
   * The worldIntersectionPosition world position of intersection.
   * @type {!o3djs.math.Vector3}
   */
  this.worldIntersectionPosition = worldIntersectionPosition
};

/**
 * Creates a new ShapeInfo. Used to store information about Shapes.
 * @constructor
 * @param {!o3d.Shape} shape Shape to keep info about.
 * @param {!o3djs.picking.TransformInfo} parent Parent transform of the shape.
 */
o3djs.picking.ShapeInfo = function(shape, parent) {
  /**
   * The Shape for this ShapeInfo
   * @type {!o3d.Shape}
   */
  this.shape = shape;

  /**
   * The parent TransformInfo of this Shape.
   * @type {!o3djs.picking.TransformInfo}
   */
  this.parent = parent;

  /**
   * The bounding box for this Shape
   * @type {o3d.BoundingBox}
   */
  this.boundingBox = null;

  this.update();
};

/**
 * Gets the BoundingBox of the Shape in this ShapeInfo.
 * @return {o3d.BoundingBox} The Shape's BoundingBox.
 */
o3djs.picking.ShapeInfo.prototype.getBoundingBox = function() {
  return this.boundingBox;
};

/**
 * Updates the BoundingBox of the Shape in this ShapeInfo.
 */
o3djs.picking.ShapeInfo.prototype.update = function() {
  var elements = this.shape.elements;
  if (elements.length > 0) {
    this.boundingBox = elements[0].getBoundingBox(0);
    for (var ee = 1; ee < elements.length; ee++) {
      this.boundingBox = this.boundingBox.add(elements[ee].getBoundingBox(0));
    }
  }
};

/**
 * Attempts to "pick" this Shape by checking for the intersection of a ray
 * in world space to the triangles this shape uses.
 * @param {!o3djs.picking.Ray} worldRay A ray in world space to pick against.
 * @return {o3djs.picking.PickInfo} Information about the picking.
 *     null if the ray did not intersect any triangles.
 */
o3djs.picking.ShapeInfo.prototype.pick = function(worldRay) {
  var worldMatrix = this.parent.transform.getUpdatedWorldMatrix()
  var inverseWorldMatrix = o3djs.math.inverse(worldMatrix);
  var relativeNear = o3djs.math.matrix4.transformPoint(
      inverseWorldMatrix, worldRay.near);
  var relativeFar = o3djs.math.matrix4.transformPoint(
      inverseWorldMatrix, worldRay.far);
  var rayIntersectionInfo =
      this.boundingBox.intersectRay(relativeNear,
                                    relativeFar);

  o3djs.picking.dumpRayIntersectionInfo('SHAPE(box): ' + this.shape.name,
                                        rayIntersectionInfo);

  if (rayIntersectionInfo.intersected) {
    var elements = this.shape.elements;
    for (var e = 0; e < elements.length; e++) {
      var element = elements[e];
      rayIntersectionInfo = element.intersectRay(
          0,
          o3djs.base.o3d.State.CULL_CCW,
          relativeNear,
          relativeFar);
      o3djs.picking.dumpRayIntersectionInfo(
          'SHAPE(tris): ' + this.shape.name + ' : element ' + element.name,
          rayIntersectionInfo);

      // TODO: get closest element not just first element.
      if (rayIntersectionInfo.intersected) {
        var worldIntersectionPosition = o3djs.math.matrix4.transformPoint(
            worldMatrix, rayIntersectionInfo.position);
        return o3djs.picking.createPickInfo(element,
                                            this,
                                            rayIntersectionInfo,
                                            worldIntersectionPosition);
      }
    }
  }
  return null;
};

/**
 * Dumps info about a ShapeInfo
 * @param {string} prefix optional prefix for indenting.
 */
o3djs.picking.ShapeInfo.prototype.dump = function(prefix) {
  o3djs.picking.dprint(prefix + 'SHAPE: ' + this.shape.name + '\n');
  o3djs.picking.dprintPoint3('bb min',
                             this.boundingBox.minExtent,
                             prefix + '    ');
  o3djs.picking.dprintPoint3('bb max',
                             this.boundingBox.maxExtent,
                             prefix + '    ');
};

/**
 * Creates a new TransformInfo. Used to store information about Transforms.
 * @constructor
 * @param {!o3d.Transform} transform Transform to keep info about.
 * @param {o3djs.picking.TransformInfo} parent Parent transformInfo of the
 *     transform. Can be null.
 */
o3djs.picking.TransformInfo = function(transform, parent) {
  this.childTransformInfos = {};  // Object of TransformInfo by id
  this.shapeInfos = {};  // Object of ShapeInfo by id
  /**
   * The transform of this transform info.
   * @type {!o3d.Transform}
   */
  this.transform = transform;
  /**
   * The parent of this transform info.
   * @type {o3djs.picking.TransformInfo}
   */
  this.parent = parent;
  this.boundingBox = null;
};

/**
 * Gets the BoundingBox of the Transform in this TransformInfo.
 * @return {o3d.BoundingBox} The Transform's BoundingBox.
 */
o3djs.picking.TransformInfo.prototype.getBoundingBox = function() {
  return this.boundingBox;
};

/**
 * Updates the shape and child lists for this TransformInfo and recomputes its
 * BoundingBox.
 */
o3djs.picking.TransformInfo.prototype.update = function() {
  var newChildTransformInfos = {};
  var newShapeInfos = {};
  var children = this.transform.children;
  for (var c = 0; c < children.length; c++) {
    var child = children[c];
    var transformInfo = this.childTransformInfos[child.clientId];
    if (!transformInfo) {
      transformInfo = o3djs.picking.createTransformInfo(child, this);
    } else {
      // clear the boundingBox so we'll regenerate it.
      transformInfo.boundingBox = null;
    }
    transformInfo.update();
    newChildTransformInfos[child.clientId] = transformInfo;
  }
  var shapes = this.transform.shapes;
  for (var s = 0; s < shapes.length; s++) {
    var shape = shapes[s];
    var shapeInfo = this.shapeInfos[shape.clientId];
    if (!shapeInfo) {
      shapeInfo = o3djs.picking.createShapeInfo(shape, this);
    } else {
      // unless the vertices or elements change there is no need to
      // recompute this.
      // shape.update();
    }
    newShapeInfos[shape.clientId] = shapeInfo;
  }

  // o3djs.picking.dprint(
  //   'num Children: ' + children.length + '\n');
  // o3djs.picking.dprint(
  //   'num Shapes: ' + shapes.length + '\n');

  this.childTransformInfos = newChildTransformInfos;
  this.shapeInfos = newShapeInfos;

  var boundingBox = null;
  for (var key in newShapeInfos) {
    var shapeInfo = newShapeInfos[key];
    var box = shapeInfo.getBoundingBox().mul(this.transform.localMatrix);
    if (!boundingBox) {
      boundingBox = box;
    } else if (box) {
      boundingBox = boundingBox.add(box);
    }
  }

  for (var key in newChildTransformInfos) {
    var transformInfo = newChildTransformInfos[key];
    // Note: If there is no shape at the leaf on this branch
    // there will be no bounding box.
    var box = transformInfo.getBoundingBox();
    if (box) {
      if (!boundingBox) {
        boundingBox = box.mul(this.transform.localMatrix);
      } else {
        boundingBox = boundingBox.add(box.mul(this.transform.localMatrix));
      }
    }
  }

  this.boundingBox = boundingBox;
};

/**
 * Attempts to "pick" this TransformInfo by checking for the intersection of a
 * ray in world space to the boundingbox of the TransformInfo. If intesection
 * is succesful recursively calls its children and shapes to try to find
 * a single Shape that is hit by the ray.
 * @param {!o3djs.picking.Ray} worldRay A ray in world space to pick against.
 * @return {o3djs.picking.PickInfo} Information about the picking.
 *     null if the ray did not intersect any triangles.
 */
o3djs.picking.TransformInfo.prototype.pick = function(worldRay) {
  if (this.boundingBox) {
    var inverseWorldMatrix = o3djs.math.matrix4.identity();
    if (this.parent) {
      inverseWorldMatrix = o3djs.math.inverse(
          this.parent.transform.getUpdatedWorldMatrix());
    }
    var relativeNear =
        o3djs.math.matrix4.transformPoint(inverseWorldMatrix, worldRay.near);
    var relativeFar =
        o3djs.math.matrix4.transformPoint(inverseWorldMatrix, worldRay.far);
    var rayIntersectionInfo =
        this.boundingBox.intersectRay(relativeNear, relativeFar);
    o3djs.picking.dumpRayIntersectionInfo(
        'TRANSFORM(box): ' + this.transform.name, rayIntersectionInfo);

    if (rayIntersectionInfo.intersected) {
      var closestPickInfo = null;
      var minDistance = -1;
      for (var key in this.childTransformInfos) {
        var transformInfo = this.childTransformInfos[key];
        var pickInfo = transformInfo.pick(worldRay);
        if (pickInfo) {
          // is this closer than the last one?
          var distance = o3djs.math.lengthSquared(
              o3djs.math.subVector(worldRay.near,
                                   pickInfo.worldIntersectionPosition));
          if (!closestPickInfo || distance < minDistance) {
            minDistance = distance;
            closestPickInfo = pickInfo;
          }
        }
      }

      for (var key in this.shapeInfos) {
        var shapeInfo = this.shapeInfos[key];
        var pickInfo = shapeInfo.pick(worldRay);
        if (pickInfo) {
          // is this closer than the last one?
          var distance = o3djs.math.lengthSquared(
              o3djs.math.subVector(worldRay.near,
                                   pickInfo.worldIntersectionPosition));
          if (!closestPickInfo || distance < minDistance) {
            minDistance = distance;
            closestPickInfo = pickInfo;
          }
        }
      }
      return closestPickInfo;
    }
  }
  return null;
};

/**
 * Dumps info about a TransformInfo
 * @param {string} prefix optional prefix for indenting.
 */
o3djs.picking.TransformInfo.prototype.dump = function(prefix) {
  prefix = prefix || '';

  o3djs.picking.dprint(prefix + 'TRANSFORM: ' + this.transform.name +
                       '\n');

  if (this.boundingBox) {
    o3djs.picking.dprintPoint3('bb min',
                               this.boundingBox.minExtent,
                               prefix + '    ');
    o3djs.picking.dprintPoint3('bb max',
                               this.boundingBox.maxExtent,
                               prefix + '    ');
  } else {
    o3djs.picking.dprint(prefix + '    bb *NA*\n');
  }

  o3djs.picking.dprint(prefix + '--Shapes--\n');
  for (var key in this.shapeInfos) {
    var shapeInfo = this.shapeInfos[key];
    shapeInfo.dump(prefix + '    ');
  }

  o3djs.picking.dprint(prefix + '--Children--\n');
  for (var key in this.childTransformInfos) {
    var transformInfo = this.childTransformInfos[key];
    transformInfo.dump(prefix + '    ');
  }
};



