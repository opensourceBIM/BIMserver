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
 * @fileoverview This file contains sample code for controlling the camera
 * (ie view matrix) using the mouse and keyboard.
 */

o3djs.provide('o3djs.cameracontroller');

o3djs.require('o3djs.math');

/**
 * A Module for user control of the camera / view matrix.
 * @namespace
 */
o3djs.cameracontroller = o3djs.cameracontroller || {};

/**
 * The possible modes that a CameraController can be in.
 * One of these is usually set when a mouse button is pressed down,
 * and then NONE is set when the mouse button is released.
 * When the mouse is moved, the DragMode determines what effect the mouse move
 * has on the camera parameters (such as position and orientation).
 * If the DragMode is NONE, mouse moves have no effect.
 * @enum {number}
 */
o3djs.cameracontroller.DragMode = {
  /**
   * Dragging the mouse has no effect.
   */
  NONE: 0,
  /**
   * Dragging left or right changes rotationAngle,
   * dragging up or down changes heightAngle.
   */
  SPIN_ABOUT_CENTER: 1,
  /**
   * Dragging up or down changes the backpedal.
   */
  DOLLY_IN_OUT: 2,
  /**
   * Dragging up or down changes the fieldOfViewAngle.
   */
  ZOOM_IN_OUT: 3,
  /**
   * Dragging up or down changes the amount of perspective.
   * Perspective is focused on the centerPos.
   * If backpedal is negative or zero, there is no effect.
   */
  DOLLY_ZOOM: 4,
  /**
   * Dragging moves the centerPos around the plane perpendicular to
   * the camera view direction.
   */
  MOVE_CENTER_IN_VIEW_PLANE: 5,
};

/**
 * Creates a CameraController.
 * @param {!o3djs.math.Vector3} centerPos The position that the camera is
 *     looking at and rotating around; or if backpedal is zero, the location
 *     of the camera. In world space.
 * @param {number} backpedal The distance the camera moves back from the
 *     centerPos.
 * @param {number} heightAngle The angle the camera rotates up or down
 *     (about the x axis that passes through the centerPos). In radians.
 * @param {number} rotationAngle The angle the camera rotates left or right
 *     (about the y axis that passes through the centerPos). In radians.
 * @param {number} fieldOfViewAngle The vertical angle of the viewing frustum.
 *     In radians, between 0 and PI/2. This does not affect the view matrix,
 *     but it can still be useful to let the CameraController control the
 *     field of view.
 * @param {function(!o3djs.cameracontroller.CameraController): void}
 *     opt_onChange Pointer to a callback to call when the camera changes.
 * @return {!o3djs.cameracontroller.CameraController} The created
 *     CameraController.
 */
o3djs.cameracontroller.createCameraController = function(centerPos,
                                                         backpedal,
                                                         heightAngle,
                                                         rotationAngle,
                                                         fieldOfViewAngle,
                                                         opt_onChange) {
  return new o3djs.cameracontroller.CameraController(centerPos,
                                                     backpedal,
                                                     heightAngle,
                                                     rotationAngle,
                                                     fieldOfViewAngle,
                                                     opt_onChange);
};

/**
 * Class to hold user-controlled camera information and handle user events.
 * It can control and output a view matrix, and can also control some aspects
 * of a projection matrix.
 *
 * Most of the parameters it controls affect the view matrix, and it can
 * generate a view matrix based on its parameters.
 * It can also control certain parameters that affect the projection matrix,
 * such as field of view. Rather than deal with all the parameters needed for
 * a projection matrix, this class leaves generation of the projection matrix
 * up to the user code, and simply exposes the parameters it has.
 * @constructor
 * @param {!o3djs.math.Vector3} centerPos The position that the camera is
 *     looking at and rotating around; or if backpedal is zero, the location
 *     of the camera. In world space.
 * @param {number} backpedal The distance the camera moves back from the
 *     centerPos.
 * @param {number} heightAngle The angle the camera rotates up or down
 *     (about the x axis that passes through the centerPos). In radians.
 * @param {number} rotationAngle The angle the camera rotates left or right
 *     (about the y axis that passes through the centerPos). In radians.
 * @param {number} fieldOfViewAngle The vertical angle of the viewing frustum.
 *     In radians, between 0 and PI/2. This does not affect the view matrix,
 *     but it can still be useful to let this class control the field of view.
 * @param {function(!o3djs.cameracontroller.CameraController): void}
 *     opt_onChange Pointer to a callback to call when the camera changes.
 */
o3djs.cameracontroller.CameraController = function(centerPos,
                                                   backpedal,
                                                   heightAngle,
                                                   rotationAngle,
                                                   fieldOfViewAngle,
                                                   opt_onChange) {
  /**
   * The position that the camera is looking at and rotating around.
   * Or if backpedal is zero, the location of the camera. In world space.
   * @type {!o3djs.math.Vector3}
   */
  this.centerPos = centerPos;

  /**
   * The distance the camera moves back from the centerPos.
   * @type {number}
   */
  this.backpedal = backpedal;

  /**
   * The angle the camera rotates up or down.
   * @type {number}
   */
  this.heightAngle = heightAngle;

  /**
   * The angle the camera rotates left or right.
   * @type {number}
   */
  this.rotationAngle = rotationAngle;

  /**
   * The vertical angle of the perspective viewing frustum.
   * In radians, between 0 and PI/2. This does not affect the view matrix.
   * The user code can access this value and use it to construct a
   * projection matrix, or it can simply ignore it.
   * @type {number}
   */
  this.fieldOfViewAngle = fieldOfViewAngle;


  /**
   * Points to a callback to call when the camera changes.
   * @type {function(!o3djs.cameracontroller.CameraController): void}
   */
  this.onChange = opt_onChange || null;

  /**
   * The current mouse-drag mode, ie what happens when you move the mouse.
   * @private
   * @type {o3djs.cameracontroller.DragMode}
   */
  this.dragMode_ = o3djs.cameracontroller.DragMode.NONE;

  /**
   * The last X coordinate of the mouse.
   * @private
   * @type {number}
   */
  this.mouseX_ = 0;

  /**
   * The last Y coordinate of the mouse.
   * @private
   * @type {number}
   */
  this.mouseY_ = 0;


  // Some variables to control how quickly the camera changes when you
  // move the mouse a certain distance. Feel free to modify these.
  // Mouse pixels are converted into arbitrary "units" (for lack of
  // a better term), and then "units" are converted into an angle,
  // or a distance, etc as the case may be.

  /**
   * Controls how quickly the mouse moves the camera (in general).
   * Used to convert pixels into "units".
   * @type {number}
   */
  this.pixelsPerUnit = 300.0;

  /**
   * Controls how quickly the mouse affects rotation angles.
   * Used to convert "units" into radians.
   * @type {number}
   */
  this.radiansPerUnit = 1.0;

  /**
   * Controls how quickly the mouse affects camera translation.
   * Used to convert "units" into world space units of distance.
   * @type {number}
   */
  this.distancePerUnit = 10.0;

  /**
   * Controls how quickly the mouse affects zooming.
   * Used to convert "units" into zoom factor.
   * @type {number}
   */
  this.zoomPerUnit = 1.0;
};

/**
 * Calculates the center point and backpedal which will make the
 * camera view the entire supplied bounding box, assuming a symmetric
 * perspective projection. The heightAngle and rotationAngle are
 * unchanged.
 * @param {!o3d.BoundingBox} The bounding box to enclose in the view
 * volume.
 * @param {number} aspectRatio The aspect ratio of the viewing plane.
 */
o3djs.cameracontroller.CameraController.prototype.viewAll =
  function(boundingBox,
           aspectRatio) {
  // Form a view matrix facing in the correct direction but whose
  // origin is at the center of the bounding box
  var minExtent = boundingBox.minExtent;
  var maxExtent = boundingBox.maxExtent;
  var centerPos = o3djs.math.divVectorScalar(
      o3djs.math.addVector(minExtent, maxExtent), 2.0);
  var viewMatrix = this.calculateViewMatrix_(centerPos, 0);
  var maxBackpedal = 0;
  var vertFOV = this.fieldOfViewAngle;
  var tanVertFOV = Math.tan(vertFOV);
  var horizFOV = Math.atan(aspectRatio * tanVertFOV);
  var tanHorizFOV = Math.tan(horizFOV);
  var extents = [minExtent, maxExtent];
  for (var zi = 0; zi < 2; zi++) {
    for (var yi = 0; yi < 2; yi++) {
      for (var xi = 0; xi < 2; xi++) {
        // Form world space vector of this corner
        var vec = [extents[xi][0], extents[yi][1], extents[zi][2], 1];
        // Transform by the temporary view matrix
        vec = o3djs.math.mulVectorMatrix(vec, viewMatrix);
        // Consider only points on the +z side of the origin
        if (vec[2] >= 0.0) {
          // Figure out the backpedal based on the horizontal and
          // vertical view angles, and the z coordinate of the
          // corner
          maxBackpedal = Math.max(maxBackpedal,
                                  vec[2] + vec[0] / tanHorizFOV);
          maxBackpedal = Math.max(maxBackpedal,
                                  vec[2] + vec[1] / tanVertFOV);
        }
      }
    }
  }
  // Now set up the center point, backpedal and distancePerUnit
  this.centerPos = centerPos;
  this.backpedal = maxBackpedal;
  // This is heuristic based on some experimentation
  this.distancePerUnit = maxBackpedal / 5.0;
};

/**
 * Calculates the view matrix for this camera.
 * @return {!o3djs.math.Matrix4} The view matrix.
 */
o3djs.cameracontroller.CameraController.prototype.calculateViewMatrix =
    function() {
  return this.calculateViewMatrix_(this.centerPos, this.backpedal);
};

/**
 * Calculates the view matrix for this camera given the specified
 * center point and backpedal.
 * @param {!o3djs.math.Vector3} centerPoint Center point for the
 * camera.
 * @param {number} backpedal Backpedal from the center point for the
 * camera.
 */
o3djs.cameracontroller.CameraController.prototype.calculateViewMatrix_ =
    function(centerPoint, backpedal) {
  var matrix4 = o3djs.math.matrix4;
  var view = matrix4.translation(o3djs.math.negativeVector(centerPoint));
  view = matrix4.mul(view, matrix4.rotationY(this.rotationAngle));
  view = matrix4.mul(view, matrix4.rotationX(this.heightAngle));
  view = matrix4.mul(view, matrix4.translation([0, 0, -backpedal]));
  return view;
};

/**
 * Change the current mouse-drag mode, ie what happens when you move the mouse.
 * Usually you would set it to something when a mouse button is pressed down,
 * and then set it to NONE when the button is released.
 * @param {o3djs.cameracontroller.DragMode} dragMode The new DragMode.
 * @param {number} x The current mouse X coordinate.
 * @param {number} y The current mouse Y coordinate.
 */
o3djs.cameracontroller.CameraController.prototype.setDragMode =
    function(dragMode, x, y) {
  this.dragMode_ = dragMode;
  this.mouseX_ = x;
  this.mouseY_ = y;
};

/**
 * Method which should be called by end user code upon receiving a
 * mouse-move event.
 * @param {number} x The new mouse X coordinate.
 * @param {number} y The new mouse Y coordinate.
 */
o3djs.cameracontroller.CameraController.prototype.mouseMoved = function(x, y) {
  var deltaX = (x - this.mouseX_) / this.pixelsPerUnit;
  var deltaY = (y - this.mouseY_) / this.pixelsPerUnit;
  this.mouseX_ = x;
  this.mouseY_ = y;

  if (this.dragMode_ == o3djs.cameracontroller.DragMode.SPIN_ABOUT_CENTER) {
    this.rotationAngle += deltaX * this.radiansPerUnit;
    this.heightAngle += deltaY * this.radiansPerUnit;
  }
  if (this.dragMode_ == o3djs.cameracontroller.DragMode.DOLLY_IN_OUT) {
    this.backpedal += deltaY * this.distancePerUnit;
  }
  if (this.dragMode_ == o3djs.cameracontroller.DragMode.ZOOM_IN_OUT) {
    var width = Math.tan(this.fieldOfViewAngle);
    width *= Math.pow(2, deltaY * this.zoomPerUnit);
    this.fieldOfViewAngle = Math.atan(width);
  }
  if (this.dragMode_ == o3djs.cameracontroller.DragMode.DOLLY_ZOOM) {
    if (this.backpedal > 0) {
      var oldWidth = Math.tan(this.fieldOfViewAngle);
      this.fieldOfViewAngle += deltaY * this.radiansPerUnit;
      this.fieldOfViewAngle = Math.min(this.fieldOfViewAngle, 0.98 * Math.PI/2);
      this.fieldOfViewAngle = Math.max(this.fieldOfViewAngle, 0.02 * Math.PI/2);
      var newWidth = Math.tan(this.fieldOfViewAngle);
      this.backpedal *= oldWidth / newWidth;
    }
  }
  if (this.dragMode_ ==
      o3djs.cameracontroller.DragMode.MOVE_CENTER_IN_VIEW_PLANE) {
    var matrix4 = o3djs.math.matrix4;
    var translationVector = [-deltaX * this.distancePerUnit,
                              deltaY * this.distancePerUnit, 0];
    var inverseViewMatrix = matrix4.inverse(this.calculateViewMatrix());
    translationVector = matrix4.transformDirection(
        inverseViewMatrix, translationVector);
    this.centerPos = o3djs.math.addVector(this.centerPos, translationVector);
  }

  if (this.onChange != null &&
      this.dragMode_ != o3djs.cameracontroller.DragMode.NONE) {
    this.onChange(this);
  }
};
