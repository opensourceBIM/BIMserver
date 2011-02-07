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
 * @fileoverview This file contains various camera utility functions for
 * o3d.  It puts them in the "camera" module on the o3djs object.
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.camera');

o3djs.require('o3djs.util');
o3djs.require('o3djs.math');

/**
 * A Module for camera utilites.
 * @namespace
 */
o3djs.camera = o3djs.camera || {};

/**
 * Class to hold Camera information.
 * @constructor
 * @param {!o3djs.math.Matrix4} view The 4-by-4 view matrix.
 * @param {number} zNear near z plane.
 * @param {number} zFar far z plane.
 * @param {!o3djs.math.Vector3} opt_eye The eye position.
 * @param {!o3djs.math.Vector3} opt_target The target position.
 * @param {!o3djs.math.Vector3} opt_up The up vector.
 */
o3djs.camera.CameraInfo = function(view,
                                   zNear,
                                   zFar,
                                   opt_eye,
                                   opt_target,
                                   opt_up) {
  /**
   * View Matrix.
   * @type {!o3djs.math.Matrix4}
   */
  this.view = view;

  /**
   * Projection Matrix.
   * @type {!o3djs.math.Matrix4}
   */
  this.projection = o3djs.math.matrix4.identity();

  /**
   * Projection is orthographic.
   * @type {boolean}
   */
  this.orthographic = false;

  /**
   * Near z plane.
   * @type {number}
   */
  this.zNear = zNear;

  /**
   * Far z plane.
   * @type {number}
   */
  this.zFar = zFar;

  /**
   * Field of view in radians.
   * @type {number}
   */
  this.fieldOfViewRadians = o3djs.math.degToRad(30);

  /**
   * Eye position.
   * @type {(!o3djs.math.Vector3|undefined)}
   */
  this.eye = opt_eye;

  /**
   * Target position.
   * @type {(!o3djs.math.Vector3|undefined)}
   */
  this.target = opt_target;

  /**
   * Up Vector.
   * @type {(!o3djs.math.Vector3|undefined)}
   */
  this.up = opt_up;

  /**
   * horizontal magnification for an orthographic view.
   * @type {(number|undefined)}
   */
  this.magX = undefined;

  /**
   * vertical magnification for an orthographic view.
   * @type {(number|undefined)}
   */
  this.magY = undefined;
};

/**
 * Sets the CameraInfo to an orthographic camera.
 * @param {number} magX horizontal magnification.
 * @param {number} magY vertical magnification.
 */
o3djs.camera.CameraInfo.prototype.setAsOrthographic = function(
    magX, magY) {
  this.orthographic = true
  this.magX = magX;
  this.magY = magY;
};

/**
 * Sets the CameraInfo to an orthographic camera.
 * @param {number} fieldOfView Field of view in radians.
 */
o3djs.camera.CameraInfo.prototype.setAsPerspective = function(
    fieldOfView) {
  this.orthographic = false;
  this.fieldOfViewRadians = fieldOfView;
};

/**
 * Computes a projection matrix for this CameraInfo using the areaWidth
 * and areaHeight passed in.
 *
 * @param {number} areaWidth width of client area.
 * @param {number} areaHeight heigh of client area.
 * @return {!o3djs.math.Matrix4} The computed projection matrix.
 */
o3djs.camera.CameraInfo.prototype.computeProjection = function(
    areaWidth,
    areaHeight) {
  if (this.orthographic) {
    // TODO: figure out if there is a way to make this take the areaWidth
    //     and areaHeight into account. As it is, magX and magY from the
    //     collada file are relative to the aspect ratio of Maya's render
    //     settings which are not available here.
    // var magX = areaWidth * 0.5 / this.magX;
    // var magY = areaHeight * 0.5 / this.magY;
    var magX = /** @type {number} */ (this.magX);
    var magY = /** @type {number} */ (this.magY);
    this.projection = o3djs.math.matrix4.orthographic(
        -magX, magX, -magY, magY, this.zNear, this.zFar);
  } else {
    this.projection = o3djs.math.matrix4.perspective(
        this.fieldOfViewRadians,  // field of view.
        areaWidth / areaHeight,   // Aspect ratio.
        this.zNear,               // Near plane.
        this.zFar);               // Far plane.
  }
  return this.projection;
};

/**
 * Searches for all nodes with a "o3d.tags" ParamString
 * that contains the word "camera" assuming comma separated
 * words.
 * @param {!o3d.Transform} treeRoot Root of tree to search for cameras.
 * @return {!Array.<!o3d.Transform>} Array of camera transforms.
 */
o3djs.camera.findCameras = function(treeRoot) {
  return o3djs.util.getTransformsInTreeByTags(treeRoot, 'camera');
};

/**
 * Creates a object with view and projection matrices using paramters found on
 * the camera 'o3d.projection_near_z', 'o3d.projection_far_z', and
 * 'o3d.perspective_fov_y' as well as the areaWidth and areaHeight passed
 * in.
 * @param {!o3d.Transform} camera Transform with camera information on it.
 * @param {number} areaWidth width of client area.
 * @param {number} areaHeight height of client area.
 * @return {!o3djs.camera.CameraInfo} A CameraInfo object.
 */
o3djs.camera.getViewAndProjectionFromCamera = function(camera,
                                                       areaWidth,
                                                       areaHeight) {
  var fieldOfView = 30;
  var zNear = 1;
  var zFar = 5000;
  var eye = undefined;
  var target = undefined;
  var up = undefined;
  var view;
  var math = o3djs.math;
  var cameraInfo;

  // Check if any LookAt elements were found for the camera and use their
  // values to compute a view matrix.
  var eyeParam = camera.getParam('collada.eyePosition');
  var targetParam = camera.getParam('collada.targetPosition');
  var upParam = camera.getParam('collada.upVector');
  if (eyeParam != null && targetParam != null && upParam != null) {
    eye = eyeParam.value;
    target = targetParam.value;
    up = upParam.value;
    view = math.matrix4.lookAt(eye, target, up);
  } else {
    // Set it to the orientation of the camera.
    view = math.inverse(camera.getUpdatedWorldMatrix());
  }

  var projectionType = camera.getParam('collada.projectionType');
  if (projectionType) {
    zNear = camera.getParam('collada.projectionNearZ').value;
    zFar = camera.getParam('collada.projectionFarZ').value;

    if (projectionType.value == 'orthographic') {
      var magX = camera.getParam('collada.projectionMagX').value;
      var magY = camera.getParam('collada.projectionMagY').value;

      cameraInfo = new o3djs.camera.CameraInfo(view, zNear, zFar);
      cameraInfo.setAsOrthographic(magX, magY);
    } else if (projectionType.value == 'perspective') {
      fieldOfView = camera.getParam('collada.perspectiveFovY').value;
    }
  }

  if (!cameraInfo) {
    cameraInfo = new o3djs.camera.CameraInfo(view, zNear, zFar,
                                                  eye, target, up);
    cameraInfo.setAsPerspective(math.degToRad(fieldOfView));
  }

  cameraInfo.computeProjection(areaWidth, areaHeight);
  return cameraInfo;
};

/**
 * Get CameraInfo that represents a view of the bounding box that encompasses
 * a tree of transforms.
 * @param {!o3d.Transform} treeRoot Root of sub tree to get extents from.
 * @param {number} clientWidth width of client area.
 * @param {number} clientHeight height of client area.
 * @return {!o3djs.camera.CameraInfo} A CameraInfo object.
 */
o3djs.camera.getCameraFitToScene = function(treeRoot,
                                            clientWidth,
                                            clientHeight) {
  var math = o3djs.math;
  var box = o3djs.util.getBoundingBoxOfTree(treeRoot);
  var target = math.lerpVector(box.minExtent, box.maxExtent, 0.5);
  var boxDimensions = math.subVector(box.maxExtent, box.minExtent);
  var diag = o3djs.math.distance(box.minExtent, box.maxExtent);
  var eye = math.addVector(target, [boxDimensions[0] * 0.3,
                                    boxDimensions[1] * 0.7,
                                    diag * 1.5]);
  var nearPlane = diag / 1000;
  var farPlane = diag * 10;

  var up = [0, 1, 0];
  var cameraInfo = new o3djs.camera.CameraInfo(
      math.matrix4.lookAt(eye, target, up),
      nearPlane,
      farPlane);

  cameraInfo.setAsPerspective(math.degToRad(45));
  cameraInfo.computeProjection(clientWidth, clientHeight);
  return cameraInfo;
};

/**
 * Calls findCameras and takes the first camera. Then calls
 * o3djs.camera.getViewAndProjectionFromCamera. If no camera is found it
 * sets up some defaults.
 * @param {!o3d.Transform} treeRoot Root of tree to search for cameras.
 * @param {number} areaWidth Width of client area.
 * @param {number} areaHeight Height of client area.
 * @return {!o3djs.camera.CameraInfo} A CameraInfo object.
 */
o3djs.camera.getViewAndProjectionFromCameras = function(treeRoot,
                                                        areaWidth,
                                                        areaHeight) {
  var cameras = o3djs.camera.findCameras(treeRoot);

  if (cameras.length > 0) {
    return o3djs.camera.getViewAndProjectionFromCamera(cameras[0],
                                                       areaWidth,
                                                       areaHeight);
  } else {
    // There was no camera in the file so make up a hopefully resonable default.
    return o3djs.camera.getCameraFitToScene(treeRoot,
                                            areaWidth,
                                            areaHeight);
  }
};

/**
 * Calls findCameras and creates an array of CameraInfos for each camera found.
 * @param {!o3d.Transform} treeRoot Root of tree to search for cameras.
 * @param {number} areaWidth Width of client area.
 * @param {number} areaHeight Height of client area.
 * @return {!Array.<!o3djs.camera.CameraInfo>} A CameraInfo object.
 */
o3djs.camera.getCameraInfos = function(treeRoot, areaWidth, areaHeight) {
  var cameras = o3djs.camera.findCameras(treeRoot);
  var cameraInfos = [];

  for (var cc = 0; cc < cameras.length; ++cc) {
    cameraInfos.push(o3djs.camera.getViewAndProjectionFromCamera(
        cameras[cc], areaWidth, areaHeight));
  }
  return cameraInfos;
};

/**
 * Sets the view and projection of a DrawContext to view the bounding box
 * that encompasses the tree of transforms passed.
 *
 * This function is here to help debug a program by providing an easy way to
 * attempt to get your content in front of the camera.
 *
 * @param {!o3d.Transform} treeRoot Root of sub tree to get extents from.
 * @param {number} clientWidth width of client area.
 * @param {number} clientHeight height of client area.
 * @param {!o3d.DrawContext} drawContext DrawContext to set view and
 *     projection on.
 */
o3djs.camera.fitContextToScene = function(treeRoot,
                                          clientWidth,
                                          clientHeight,
                                          drawContext) {
  var cameraInfo = o3djs.camera.getCameraFitToScene(treeRoot,
                                                    clientWidth,
                                                    clientHeight);
  drawContext.view = cameraInfo.view;
  drawContext.projection = cameraInfo.projection;
};
