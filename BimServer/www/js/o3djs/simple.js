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
 * @fileoverview This file contains functions to make it extremely simple
 *     to get something on the screen in o3d. The disadvantage is it
 *     is less flexible and creates inefficient assets.
 *
 * Example
 *
 * <pre>
 * &lt;html&gt;&lt;body&gt;
 * &lt;script type="text/javascript" src="o3djs/all.js"&gt;
 * &lt;/script&gt;
 * &lt;script type="text/javascript"&gt;
 * window.init = init;
 *
 * function init() {
 *   o3djs.base.makeClients(initStep2);
 * }
 *
 * function initStep2(clientElements) {
 *   var clientElement = clientElements[0];
 *
 *   // Create an o3djs.simple object to manage things in a simple way.
 *   g_simple = o3djs.simple.create(clientElement);
 *
 *   // Create a cube.
 *   g_cube = g_simple.createCube(50);
 *
 *   // DONE!
 * }
 * &lt;/script&gt;
 * &lt;div id="o3d" style="width: 600px; height: 600px"&gt;&lt;/div&gt;
 * &lt;/body&gt;&lt;/html&gt;
 * </pre>
 *
 * Some more examples:
 *
 *   g_cube.setDiffuseColor(1, 0, 0, 1);  // Cube is now red.
 *   g_cube.transform.translate(10, 0, 0);  // Cube translates.
 *   g_cube.loadTexture('http://google.com/someimage.jpg"); // Cube is textured
 *
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.simple');

o3djs.require('o3djs.math');
o3djs.require('o3djs.material');
o3djs.require('o3djs.effect');
o3djs.require('o3djs.shape');
o3djs.require('o3djs.util');
o3djs.require('o3djs.rendergraph');
o3djs.require('o3djs.pack');
o3djs.require('o3djs.primitives');
o3djs.require('o3djs.io');
o3djs.require('o3djs.scene');
o3djs.require('o3djs.camera');

/**
 * A Module for using o3d in a very simple way.
 * @namespace
 */
o3djs.simple = o3djs.simple || {};

/**
 * Creates an o3djs.simple library object that helps manage o3d
 * for the extremely simple cases.
 *
 * <pre>
 * &lt;html&gt;&lt;body&gt;
 * &lt;script type="text/javascript" src="o3djs/all.js"&gt;
 * &lt;/script&gt;
 * &lt;script type="text/javascript"&gt;
 * windows.onload = init;
 *
 * function init() {
 *   o3djs.base.makeClients(initStep2);
 * }
 *
 * function initStep2(clientElements) {
 *   var clientElement = clientElements[0];
 *
 *   // Create an o3djs.simple object to manage things in a simple way.
 *   g_simple = o3djs.simple.create(clientElement);
 *
 *   // Create a cube.
 *   g_cube = g_simple.createCube(50);
 *
 *   // DONE!
 * }
 * &lt;/script&gt;
 * &lt;div id="o3d" style="width: 600px; height: 600px"&gt;&lt;/div&gt;
 * &lt;/body&gt;&lt;/html&gt;
 * </pre>
 *
 * @param {!Element} clientObject O3D.Plugin Object.
 * @return {!o3djs.simple.SimpleInfo} Javascript object that hold info for the
 *     simple library.
 *
 */
o3djs.simple.create = function(clientObject) {
  return new o3djs.simple.SimpleInfo(clientObject);
};

/**
 * A SimpleInfo contains information for the simple library.
 * @constructor
 * @param {!Element} clientObject O3D.Plugin Object.
 */
o3djs.simple.SimpleInfo = function(clientObject) {
  /**
   * The O3D Element.
   * @type {!Element}
   */
  this.clientObject = clientObject;

  /**
   * The O3D namespace object.
   * @type {!o3d}
   */
  this.o3d = clientObject.o3d;

  /**
   * The client object used by the SimpleInfo
   * @type {!o3d.Client}
   */
  this.client = clientObject.client;

  /**
   * The main pack for this SimpleInfo.
   * @type {!o3d.Pack}
   */
  this.pack = this.client.createPack();

  /**
   * The root transform for this SimpleInfo
   * @type {!o3d.Transform}
   */
  this.root = this.pack.createObject('Transform');

  /**
   * The ViewInfo created by this SimpleInfo.
   * @type {!o3djs.rendergraph.ViewInfo}
   */
  this.viewInfo = o3djs.rendergraph.createBasicView(
      this.pack,
      this.root,
      this.client.renderGraphRoot);

  /**
   * The list of objects that need to have an update function called indexed by
   * id.
   * @private
   * @type {!Object.<number,!o3djs.simple.SimpleObject>}
   */
  this.updateObjects_ = { };

  /**
   * The next available id for objects.
   * @private
   * @type {number}
   */
  this.nextId_ = 1;

  // Create 1 non-textured material and 1 textured material.
  //
  // TODO: Refactor.
  // This is slightly backward. What we really want is to be able to request
  // an effect of a specific type from our shader builder but the current shader
  // builder expects a material to already exist. So, we create a material here
  // just to pass it to the shader builder, then we keep the effect it created
  // but throw away the material.
  //
  // TODO: Fix shader builder so it creates diffuseColorMult,
  //   diffuseColorOffset and  diffuseTexture so
  //   diffuse = diffuseTexture * diffuseColorMult + diffuseColorOffset.

  var material = this.pack.createObject('Material');

  o3djs.effect.attachStandardShader(this.pack,
                                         material,
                                         [0, 0, 0],
                                         'phong');

  this.nonTexturedEffect_ = material.effect;
  this.pack.removeObject(material);

  var material = this.pack.createObject('Material');
  var samplerParam = material.createParam('diffuseSampler', 'ParamSampler');
  o3djs.effect.attachStandardShader(this.pack,
                                         material,
                                         [0, 0, 0],
                                         'phong');

  this.texturedEffect_ = material.effect;
  this.pack.removeObject(material);

  this.globalParamObject = this.pack.createObject('ParamObject');
  this.lightWorldPosParam = this.globalParamObject.createParam('lightWorldPos',
                                                               'ParamFloat3');
  this.lightColorParam = this.globalParamObject.createParam('lightColor',
                                                            'ParamFloat4');
  this.setLightColor(1, 1, 1, 1);
  this.setLightPosition(255, 150, 150);  // same as camera.

  // Attempt to setup a resonable default perspective matrix.
  this.zNear = 0.1;
  this.zFar = 1000;
  this.fieldOfView = o3djs.math.degToRad(45);
  this.setPerspectiveMatrix_();

  // Attempt to setup a resonable default view.
  this.cameraPosition = [250, 150, 150];
  this.cameraTarget = [0, 0, 0];
  this.cameraUp = [0, 1, 0];
  this.setViewMatrix_();

  var that = this;

  this.client.setRenderCallback(function(renderEvent) {
        var elapsedTime = Math.min(renderEvent.elapsedTime, 0.1);
        that.onRender_(elapsedTime);
      });
};

/**
 * Gets the next available id.
 * @return {number} The next available id.
 */
o3djs.simple.SimpleInfo.prototype.getNextId = function() {
  return this.nextId_++;
};

/**
 * Creates a SimpleShape. A SimpleShape manages a transform with 1 shape that
 * holds 1 primitive and 1 unique material.
 * @param {!o3d.Shape} shape that holds 1 primitive and 1 unique material.
 * @return {!o3djs.simple.SimpleShape} the created SimpleShape.
 */
o3djs.simple.SimpleInfo.prototype.createSimpleShape = function(shape) {
  shape.createDrawElements(this.pack, null);
  var transform = this.pack.createObject('Transform');
  transform.parent = this.root;
  transform.addShape(shape);
  return new o3djs.simple.SimpleShape(this, transform);
};

/**
 * The on render handler for a SimpleInfo.
 * @private
 * @param {number} elapsedTime Time elapsed since last frame.
 */
o3djs.simple.SimpleInfo.prototype.onRender_ = function(elapsedTime) {
  for (var sid in this.updateObjects_) {
    var id = /** @type {number} */ (sid);
    this.updateObjects_[id].onUpdate(elapsedTime);
  }
};

/**
 * Register an object for updating. You should not call this directly.
 * @param {!o3djs.simple.SimpleObject} simpleObject SimpleObject to register.
 */
o3djs.simple.SimpleInfo.prototype.registerObjectForUpdate =
    function (simpleObject) {
  this.updateObjects_[simpleObject.id] = simpleObject;
};

/**
 * Unregister an object for updating. You should not call this directly.
 * @param {!o3djs.simple.SimpleObject} simpleObject SimpleObject to register.
 */
o3djs.simple.SimpleInfo.prototype.unregisterObjectForUpdate =
    function (simpleObject) {
  delete this.updateObjects_[simpleObject.id];
};

/**
 * Sets the perspective matrix.
 * @private
 */
o3djs.simple.SimpleInfo.prototype.setPerspectiveMatrix_ = function() {
  this.viewInfo.drawContext.projection = o3djs.math.matrix4.perspective(
      this.fieldOfView,
      this.client.width / this.client.height,
      this.zNear,
      this.zFar);
};

/**
 * Sets the view matrix.
 * @private
 */
o3djs.simple.SimpleInfo.prototype.setViewMatrix_ = function() {
  this.viewInfo.drawContext.view = o3djs.math.matrix4.lookAt(
      this.cameraPosition,
      this.cameraTarget,
      this.cameraUp);
};

/**
 * Sets the field of view
 * @param {number} fieldOfView in Radians.
 *
 * For degrees use setFieldOfView(o3djs.math.degToRad(degrees)).
 */
o3djs.simple.SimpleInfo.prototype.setFieldOfView =
  function(fieldOfView) {
  this.fieldOfView = fieldOfView;
  this.setPerspectiveMatrix_();
};

/**
 * Sets the z clip range.
 * @param {number} zNear near z value.
 * @param {number} zFar far z value.
 */
o3djs.simple.SimpleInfo.prototype.setZClip = function(zNear, zFar) {
  this.zNear = zNear;
  this.zFar = zFar;
  this.setPerspectiveMatrix_();
};

/**
 * Sets the light position
 * @param {number} x x position.
 * @param {number} y y position.
 * @param {number} z z position.
 */
o3djs.simple.SimpleInfo.prototype.setLightPosition = function(x, y, z) {
  this.lightWorldPosParam.set(x, y, z);
};

/**
 * Sets the light color
 * @param {number} r red (0-1).
 * @param {number} g green (0-1).
 * @param {number} b blue (0-1).
 * @param {number} a alpha (0-1).
 */
o3djs.simple.SimpleInfo.prototype.setLightColor = function(r, g, b, a) {
  this.lightColorParam.set(r, g, b, a);
};

/**
 * Sets the camera position
 * @param {number} x x position.
 * @param {number} y y position.
 * @param {number} z z position.
 */
o3djs.simple.SimpleInfo.prototype.setCameraPosition = function(x, y, z) {
  this.cameraPosition = [x, y, z];
  this.setViewMatrix_();
};

/**
 * Sets the camera target
 * @param {number} x x position.
 * @param {number} y y position.
 * @param {number} z z position.
 */
o3djs.simple.SimpleInfo.prototype.setCameraTarget = function(x, y, z) {
  this.cameraTarget = [x, y, z];
  this.setViewMatrix_();
};

/**
 * Sets the camera up
 * @param {number} x x position.
 * @param {number} y y position.
 * @param {number} z z position.
 */
o3djs.simple.SimpleInfo.prototype.setCameraUp = function(x, y, z) {
  this.cameraUp = [x, y, z];
  this.setViewMatrix_();
};

/**
 * Create meterial from effect.
 * @param {!o3d.Effect} effect Effect to use for material.
 * @return {!o3d.Material} The created material.
 */
o3djs.simple.SimpleInfo.prototype.createMaterialFromEffect =
    function(effect) {
  var material = this.pack.createObject('Material');
  material.drawList = this.viewInfo.performanceDrawList;
  material.effect = effect;
  effect.createUniformParameters(material);
  material.getParam('lightWorldPos').bind(this.lightWorldPosParam);
  material.getParam('lightColor').bind(this.lightColorParam);
  return material;
};

/**
 * Create a new non-textured material.
 * @param {string} type Type of material 'phong', 'lambert', 'constant'.
 * @return {!o3d.Material} The created material.
 */
o3djs.simple.SimpleInfo.prototype.createNonTexturedMaterial =
    function(type) {
  var material = this.createMaterialFromEffect(this.nonTexturedEffect_);
  material.getParam('diffuse').set(1, 1, 1, 1);
  material.getParam('emissive').set(0, 0, 0, 1);
  material.getParam('ambient').set(0, 0, 0, 1);
  material.getParam('specular').set(1, 1, 1, 1);
  material.getParam('shininess').value = 20;
  return material;
};

/**
 * @param {string} type Type of material 'phong', 'lambert', 'constant'.
 * @return {!o3d.Material} The created material.
 */
o3djs.simple.SimpleInfo.prototype.createTexturedMaterial =
    function(type) {
  var material = this.createMaterialFromEffect(this.texturedEffect_);
  var samplerParam = material.getParam('diffuseSampler');
  var sampler = this.pack.createObject('Sampler');
  samplerParam.value = sampler;
  return material;
};

/**
 * Creates a cube and adds it to the root of this SimpleInfo's transform graph.
 * @param {number} size Width, height and depth of the cube.
 * @return {!o3djs.simple.SimpleShape} A Javascript object to manage the
 *     shape.
 */
o3djs.simple.SimpleInfo.prototype.createCube = function(size) {
  var material = this.createNonTexturedMaterial('phong');
  var shape = o3djs.primitives.createCube(this.pack, material, size);
  return this.createSimpleShape(shape);
};

/**
 * Creates a box and adds it to the root of this SimpleInfo's transform graph.
 * @param {number} width Width of the box.
 * @param {number} height Height of the box.
 * @param {number} depth Depth of the box.
 * @return {!o3djs.simple.SimpleShape} A Javascript object to manage the
 *     shape.
 */
o3djs.simple.SimpleInfo.prototype.createBox = function(width,
                                                       height,
                                                       depth) {
  var material = this.createNonTexturedMaterial('phong');
  var shape = o3djs.primitives.createBox(this.pack,
                                         material,
                                         width,
                                         height,
                                         depth);
  return this.createSimpleShape(shape);
};

/**
 * Creates a sphere and adds it to the root of this SimpleInfo's transform
 * graph.
 * @param {number} radius radius of sphere.
 * @param {number} smoothness determines the number of subdivisions.
 * @return {!o3djs.simple.SimpleShape} A Javascript object to manage the
 *     shape.
 */
o3djs.simple.SimpleInfo.prototype.createSphere = function(radius,
                                                          smoothness) {
  var material = this.createNonTexturedMaterial('phong');
  var shape = o3djs.primitives.createSphere(this.pack,
                                            material,
                                            radius,
                                            smoothness * 2,
                                            smoothness);
  return this.createSimpleShape(shape);
};

/**
 * Loads a scene from a URL.
 * @param {string} url Url of scene to load.
 * @param {!function(o3djs.simple.SimpleScene, *): void} callback a callback to
 *     call when the scene is loaded. The first argument will be null if the
 *     scene failed to load and last object will be an exception.
 * @return {!o3djs.io.LoadInfo}
 */
o3djs.simple.SimpleInfo.prototype.loadScene = function(url, callback) {
  var pack = this.client.createPack();
  var root = pack.createObject('Transform');
  var paramObject = pack.createObject('ParamObject');
  var animTimeParam = paramObject.createParam('animTime', 'ParamFloat');
  var that = this;

  var prepScene = function(pack, root, exception) {
    var simpleScene = null;
    if (exception) {
      pack.destroy();
    } else {
      simpleScene = new o3djs.simple.SimpleScene(
          that, url, pack, root, paramObject);
    }
    callback(simpleScene, exception);
  };

  return o3djs.scene.loadScene(
      this.client,
      pack,
      root,
      url,
      prepScene,
      /** @type {!o3djs.serialization.Options} */
      ({opt_animSource: animTimeParam}));
};

/**
 * Moves the camera so everything in the current scene is visible.
 */
o3djs.simple.SimpleInfo.prototype.viewAll = function() {
  var bbox = o3djs.util.getBoundingBoxOfTree(this.root);
  var target = o3djs.math.lerpVector(bbox.minExtent, bbox.maxExtent, 0.5);
  this.setCameraTarget(target[0], target[1], target[2]);
  // TODO: Refactor this so it takes a vector from the current camera
  // position to the center of the scene and moves the camera along that
  // vector away from the center of the scene until for the given fieldOfView
  // everything is visible.
  var diag = o3djs.math.distance(bbox.minExtent, bbox.maxExtent);
  var eye = o3djs.math.addVector(target, [
      bbox.maxExtent[0],
      bbox.minExtent[1] + 0.5 * diag,
      bbox.maxExtent[2]]);
  this.setCameraPosition(eye[0], eye[1], eye[2]);
  this.setZClip(diag / 1000, diag * 10);
};

/**
 * An object for managing things simply.
 * @constructor
 */
o3djs.simple.SimpleObject = function() {
};

/**
 * Initializes a SimpleObject.
 * @param {!o3djs.simple.SimpleInfo} simpleInfo The SimpleInfo to manage this
 *     object.
 * @param {!o3d.Transform} transform Transform that orients this object.
 */
o3djs.simple.SimpleObject.prototype.init = function(simpleInfo, transform) {
  /**
   * The SimpleInfo managing this object.
   * @type {!o3djs.simple.SimpleInfo}
   */
  this.simpleInfo = simpleInfo;

  /**
   * The Id for this SimpleInfo.
   * @type {number}
   */
  this.id = simpleInfo.getNextId();

  /**
   * The Transform that orients this object.
   * @type {!o3d.Transform}
   */
  this.transform = transform;

  /**
   * The update callback for this object.
   * @private
   * @type {?function(number): void}
   */
  this.updateCallback_ = null;

  /**
   * The pick callback for this object.
   * @private
   * @type {?function(number): void}
   */
  this.pickCallback_ = null;
};

/**
 * Registers on an on picked callback.
 * @param {!function(!o3djs.simple.SimpleObject): void} onPickedCallback A
 *     function called when this object is picked.
 */
o3djs.simple.SimpleObject.prototype.onPicked = function(onPickedCallback) {
  throw 'not implemented';
};

/**
 * Used to call the update callback on this object. You should not call this
 * directly. Use o3djs.simple.SimpleObject.setOnUpdate to add your own update
 * callback.
 * @param {number} elapsedTime ElapsedTime in seconds for this frame.
 * @see o3djs.simple.SimpleObject.setOnUpdate
 */
o3djs.simple.SimpleObject.prototype.onUpdate = function(elapsedTime) {
  if (this.updateCallback_) {
    this.updateCallback_(elapsedTime);
  }
};

/**
 * Sets a function to be called every frame for this object.
 * @param {function(number): void} onUpdateCallback A function that is passed
 *     the elapsed time in seconds. Pass in null to clear the callback function.
 * @return {(function(number): void|null)} The previous callback function.
 */
o3djs.simple.SimpleObject.prototype.setOnUpdate = function(onUpdateCallback) {
  if (onUpdateCallback) {
    this.simpleInfo.registerObjectForUpdate(this);
  } else {
    this.simpleInfo.unregisterObjectForUpdate(this);
  }
  var oldCallback = this.updateCallback_;
  this.updateCallback_ = onUpdateCallback;
  return oldCallback;
};

/**
 * A SimpleShape manages a transform with 1 shape that holds 1 primitive
 * and 1 unique material.
 * @constructor
 * @extends {o3djs.simple.SimpleObject}
 * @param {!o3djs.simple.SimpleInfo} simpleInfo The SimpleInfo to manage this
 *     shape.
 * @param {!o3d.Transform} transform Transform with 1 shape that holds 1
 *     primitive and 1 unique material.
 */
o3djs.simple.SimpleShape = function(simpleInfo, transform) {
  this.init(simpleInfo, transform);
};

o3djs.simple.SimpleShape.prototype = new o3djs.simple.SimpleObject();

/**
 * Gets the current material for this shape.
 * @return {o3d.Material} the material for this SimpleShape.
 */
o3djs.simple.SimpleShape.prototype.getMaterial = function() {
  return this.transform.shapes[0].elements[0].material;
};

/**
 * Sets the material for this SimpleShape, deleting any old one.
 * @param {!o3d.Material} material new material.
 */
o3djs.simple.SimpleShape.prototype.setMaterial = function(material) {
  var old_material = this.getMaterial();
  if (old_material != null) {
    this.simpleInfo.pack.removeObject(old_material);
  }
  this.transform.shapes[0].elements[0].material = material;
};

/**
 * Sets the diffuse color of this shape.
 * @param {number} r Red (0-1).
 * @param {number} g Green (0-1).
 * @param {number} b Blue (0-1).
 * @param {number} a Alpha (0-1).
 */
o3djs.simple.SimpleShape.prototype.setDiffuseColor =
    function(r, g, b, a) {
  var material = this.getMaterial();
  material.getParam('diffuse').set(r, g, b, a);
  if (a < 1) {
    material.drawList = this.simpleInfo.viewInfo.zOrderedDrawList;
  } else {
    material.drawList = this.simpleInfo.viewInfo.performanceDrawList;
  }
};

/**
 * Gets the texture on this shape.
 * @return {o3d.Texture} The texture on this shape. May be null.
 */
o3djs.simple.SimpleShape.prototype.getTexture = function() {
  var material = this.getMaterial();
  var samplerParam = material.getParam('diffuseSampler');
  if (samplerParam.className == 'o3d.ParamSampler') {
    return samplerParam.texture;
  }
  return null;
};

/**
 * Loads a texture onto the given shape. It will replace the material
 * if it needs to with one that supports a texture. Note that the texture
 * is loaded asynchronously and so the result of this call may appear several
 * seconds after it is called depending on how long it takes to download the
 * texture.
 * @param {string} url Url of texture.
 */
o3djs.simple.SimpleShape.prototype.loadTexture = function(url) {
  var that = this;
  o3djs.io.loadTexture(
      this.simpleInfo.pack,
      url,
      function(texture, exception) {
        if (!exception) {
          // See if this is a textured material.
          var material = that.getMaterial();
          if (material.effect != that.simpleInfo.texturedEffect_) {
            // replace the material with a textured one.
            var new_material = that.simpleInfo.createTexturedMaterial('phong');
            new_material.copyParams(material);
            // Reset the effect since copy Params just copied the non-textured
            // one.
            new_material.effect = that.simpleInfo.texturedEffect_;
            that.setMaterial(new_material);
            material = new_material;
          }
          var samplerParam = material.getParam('diffuseSampler');
          samplerParam.value.texture = texture;
        } else {
          alert('Load texture file returned failure. \n' + exception);
        }
      });
};

/**
 * An object to simply manage a scene.
 * @constructor
 * @extends {o3djs.simple.SimpleObject}
 * @param {!o3djs.simple.SimpleInfo} simpleInfo The SimpleInfo to manage this
 *     scene.
 * @param {string} url Url scene was loaded from.
 * @param {!o3d.Pack} pack Pack that is managing scene.
 * @param {!o3d.Transform} root Root transform of scene.
 * @param {!o3d.ParamObject} paramObject the holds global parameters.
 */
o3djs.simple.SimpleScene = function(
    simpleInfo, url, pack, root, paramObject) {
  this.init(simpleInfo, root);
  /**
   * The url this scene was loaded from.
   * @type {string}
   */
  this.url = url;

  /**
   * The pack managing this scene.
   * @type {!o3d.Pack}
   */
  this.pack = pack;

  /**
   * The param object holding global parameters for this scene.
   * @type {!o3d.ParamObject}
   */
  this.paramObject = paramObject;

  /**
   * The animation parameter for this scene.
   * @type {!o3d.ParamFloat}
   */
  this.animTimeParam = paramObject.getParam('animTime');

  o3djs.pack.preparePack(pack, simpleInfo.viewInfo);

  this.cameraInfos_ = o3djs.camera.getCameraInfos(
      root,
      simpleInfo.client.width,
      simpleInfo.client.height);


  /**
   * Binds a param if it exists.
   * @param {!o3d.ParamObject} paramObject The object that has the param.
   * @param {string} paramName name of param.
   * @param {!o3d.Param} sourceParam The param to bind to.
   */
  var bindParam = function(paramObject, paramName, sourceParam) {
    var param = paramObject.getParam(paramName);
    if (param) {
      param.bind(sourceParam);
    }
  }

  var materials = pack.getObjectsByClassName('o3d.Material');
  for (var m = 0; m < materials.length; ++m) {
    var material = materials[m];
    bindParam(material, 'lightWorldPos', simpleInfo.lightWorldPosParam);
    bindParam(material, 'lightColor', simpleInfo.lightColorParam);
  }

  this.transform.parent = this.simpleInfo.root;
};

o3djs.simple.SimpleScene.prototype = new o3djs.simple.SimpleObject();

/**
 * Sets the animation time for the scene.
 * @param {number} time Animation time in seconds.
 */
o3djs.simple.SimpleScene.prototype.setAnimTime = function(time) {
  this.animTimeParam.value = time;
};


