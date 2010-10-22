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

// A shout out to Terence J. Grant at tatewake.com for his tutorial on arcball
// implementations.

/**
 * @fileoverview This file contains functions for implementing an arcball
 * calculation.  It puts them in the "arcball" module on the o3djs object.
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.arcball');

o3djs.require('o3djs.math');
o3djs.require('o3djs.quaternions');

/**
 * A Module for arcball manipulation.
 *
 * This is useful for rotating a model with the mouse.
 *
 * @namespace
 */
o3djs.arcball = o3djs.arcball || {};

/**
 * Creates a new arcball.
 * @param {number} areaWidth width of area arcball should cover.
 * @param {number} areaHeight height of area arcball should cover.
 * @return {!o3djs.arcball.ArcBall} The created arcball.
 * @see o3djs.arcball
 */
o3djs.arcball.create = function(areaWidth, areaHeight) {
  return new o3djs.arcball.ArcBall(areaWidth, areaHeight);
};

/**
 * A class that implements an arcball.
 * @constructor
 * @param {number} areaWidth width of area arcball should cover.
 * @param {number} areaHeight height of area arcball should cover.
 * @see o3djs.arcball
 */
o3djs.arcball.ArcBall = function(areaWidth, areaHeight) {
  /**
   * The start vector.
   * @private
   * @type {!o3djs.math.Vector3}
   */
  this.startVector_ = [0, 0, 0];

  /**
   * The end vector.
   * @private
   * @type {!o3djs.math.Vector3}
   */
  this.endVector_ = [0, 0, 0];

  /**
   * The width of the arcBall area.
   * @private
   * @type {number}
   */
  this.areaWidth_ = areaWidth;

  /**
   * The height of the arcBall area.
   * @private
   * @type {number}
   */
  this.areaHeight_ = areaHeight;
};


/**
 * Sets the size of the arcball.
 * @param {number} areaWidth width of area arcball should cover.
 * @param {number} areaHeight height of area arcball should cover.
 */
o3djs.arcball.ArcBall.prototype.setAreaSize = function(areaWidth, areaHeight) {
  this.areaWidth_ = areaWidth;
  this.areaHeight_ = areaHeight;
};

/**
 * Converts a 2d point to a point on the sphere of radius 1 sphere.
 * @param {!o3djs.math.Vector2} newPoint A point in 2d.
 * @return {!o3djs.math.Vector3} A point on the sphere of radius 1.
 */
o3djs.arcball.ArcBall.prototype.mapToSphere = function(newPoint) {
  // Copy parameter into temp
  var tempPoint = o3djs.math.copyVector(newPoint);

  // Scale to -1.0 <-> 1.0
  tempPoint[0] = tempPoint[0] / this.areaWidth_ * 2.0 - 1.0;
  tempPoint[1] = 1.0 - tempPoint[1] / this.areaHeight_ * 2.0;

  // Compute square of length from center
  var lengthSquared = o3djs.math.lengthSquared(tempPoint);

  // If the point is mapped outside of the sphere... (length > radius squared)
  if (lengthSquared > 1.0) {
    return o3djs.math.normalize(tempPoint).concat(0);
  } else {
    // Otherwise it's on the inside.
    return tempPoint.concat(Math.sqrt(1.0 - lengthSquared));
  }
};

/**
 * Records the starting point on the sphere.
 * @param {!o3djs.math.Vector2} newPoint point in 2d.
 */
o3djs.arcball.ArcBall.prototype.click = function(newPoint) {
  this.startVector_ = this.mapToSphere(newPoint);
};

/**
 * Computes the rotation of the sphere based  on the initial point clicked as
 * set through Arcball.click and the current point passed in as newPoint
 * @param {!o3djs.math.Vector2} newPoint point in 2d.
 * @return {!o3djs.quaternions.Quaternion} A quaternion representing the new
 *     orientation.
 */
o3djs.arcball.ArcBall.prototype.drag = function(newPoint) {
  this.endVector_ = this.mapToSphere(newPoint);

  return o3djs.math.cross(this.startVector_, this.endVector_).concat(
      o3djs.math.dot(this.startVector_, this.endVector_));
};
