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
 * materials for o3d.  It puts them in the "material" module on the
 * o3djs object.
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.material');

o3djs.require('o3djs.math');
o3djs.require('o3djs.effect');

/**
 * A Module for materials.
 * @namespace
 */
o3djs.material = o3djs.material || {};

/**
 * Checks a material's params by name to see if it possibly has non 1.0 alpha.
 * Given a name, checks for a ParamTexture called 'nameTexture' and if that
 * fails, checks for a ParamFloat4 'name'.
 * @private
 * @param {!o3d.Material} material Materal to check.
 * @param {string} name name of color params to check.
 * @return {{found: boolean, nonOneAlpha: boolean}} found is true if one of
 *     the params was found, nonOneAlpha is true if that param had non 1.0
 *     alpha.
 */
o3djs.material.hasNonOneAlpha_ = function(material, name) {
  var found = false;
  var nonOneAlpha = false;
  var texture = null;
  var samplerParam = material.getParam(name + 'Sampler');
  if (samplerParam && samplerParam.isAClassName('o3d.ParamSampler')) {
    found = true;
    var sampler = samplerParam.value;
    if (sampler) {
      texture = sampler.texture;
    }
  } else {
    var textureParam = material.getParam(name + 'Texture');
    if (textureParam && textureParam.isAClassName('o3d.ParamTexture')) {
      found = true;
      texture = textureParam.value;
    }
  }

  if (texture && !texture.alphaIsOne) {
    nonOneAlpha = true;
  }

  if (!found) {
    var colorParam = material.getParam(name);
    if (colorParam && colorParam.isAClassName('o3d.ParamFloat4')) {
      found = true;
      // TODO: this check does not work. We need to check for the
      // <transparency> and <transparent> elements or something.
      // if (colorParam.value[3] < 1) {
      //   nonOneAlpha = true;
      // }
    }
  }
  return {found: found, nonOneAlpha: nonOneAlpha};
};

/**
 * Prepares a material by setting their drawList and possibly creating
 * an standard effect if one does not already exist.
 *
 * This function is very specific to our sample importer. It expects that if
 * no Effect exists on a material that certain extra Params have been created
 * on the Material to give us instructions on what to Effects to create.
 *
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo as returned from
 *     o3djs.rendergraph.createView.
 * @param {!o3d.Material} material to prepare.
 * @param {string} opt_effectType type of effect to create ('phong',
 *     'lambert', 'constant').
 *
 * @see o3djs.material.attachStandardEffect
 */
o3djs.material.prepareMaterial = function(pack,
                                          viewInfo,
                                          material,
                                          opt_effectType) {
  // Assume we want the performance list
  var drawList = viewInfo.performanceDrawList;
  // First check if we have a tag telling us that it is or is not
  // transparent
  if (!material.drawList) {
    var param = material.getParam('collada.transparent');
    if (param && param.className == 'o3d.ParamBoolean') {
      material.drawList = param.value ? viewInfo.zOrderedDrawList :
                                        viewInfo.performanceDrawList;
    }
  }
  // If the material has no effect, try to build shaders for it.
  if (!material.effect) {
    // If the user didn't pass an effect type in see if one was stored there
    // by our importer.
    if (!opt_effectType) {
      // Retrieve the lightingType parameter from the material, if any.
      var lightingType = o3djs.effect.getColladaLightingType(material);
      if (lightingType) {
        opt_effectType = lightingType;
      }
    }
    if (opt_effectType) {
      o3djs.material.attachStandardEffect(pack,
                                          material,
                                          viewInfo,
                                          opt_effectType);
      // For collada common profile stuff guess what drawList to use. Note: We
      // can only do this for collada common profile stuff because we supply
      // the shaders and therefore now the inputs and how they are used.
      // For other shaders you've got to do this stuff yourself. On top of
      // that this is a total guess. Just because a texture has no alpha
      // it does not follow that you don't want it in the zOrderedDrawList.
      // That is application specific. Here we are just making a guess and
      // hoping that it covers most cases.
      if (material.drawList == null) {
        // Check the common profile params.
        var result = o3djs.material.hasNonOneAlpha_(material, 'diffuse');
        if (!result.found) {
          result = o3djs.material.hasNonOneAlpha_(material, 'emissive');
        }
        if (result.nonOneAlpha) {
          drawList = viewInfo.zOrderedDrawList;
        }
      }
    }
  }
  if (!material.drawList) {
    material.drawList = drawList;
  }
};

/**
 * Prepares all the materials in the given pack by setting their drawList and
 * if they don't have an Effect, creating one for them.
 *
 * This function is very specific to our sample importer. It expects that if
 * no Effect exists on a material that certain extra Params have been created
 * on the Material to give us instructions on what to Effects to create.
 *
 * @param {!o3d.Pack} pack Pack to prepare.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo as returned from
 *     o3djs.rendergraph.createView.
 * @param {!o3d.Pack} opt_effectPack Pack to create effects in. If this
 *     is not specifed the pack to prepare above will be used.
 *
 * @see o3djs.material.prepareMaterial
 */
o3djs.material.prepareMaterials = function(pack,
                                           viewInfo,
                                           opt_effectPack) {
  var materials = pack.getObjectsByClassName('o3d.Material');
  for (var mm = 0; mm < materials.length; mm++) {
    o3djs.material.prepareMaterial(opt_effectPack || pack,
                                   viewInfo,
                                   materials[mm]);
  }
};

/**
 * Builds a standard effect for a given material.  The position of the
 * default light is set to the view position.  If the material already has
 * an effect, none is created.
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3d.Material} material The material for which to create an
 *     effect.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo as returned from
 *     o3djs.rendergraph.createView.
 * @param {string} effectType Type of effect to create ('phong', 'lambert',
 *     'constant').
 *
 * @see o3djs.effect.attachStandardShader
 */
o3djs.material.attachStandardEffect = function(pack,
                                               material,
                                               viewInfo,
                                               effectType) {
  if (!material.effect) {
    var lightPos =
        o3djs.math.matrix4.getTranslation(
            o3djs.math.inverse(viewInfo.drawContext.view));
    if (!o3djs.effect.attachStandardShader(pack,
                                           material,
                                           lightPos,
                                           effectType)) {
      throw 'Could not attach a standard effect';
    }
  }
};


/**
 * Prepares all the materials in the given pack by setting their
 * drawList.
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3d.DrawList} drawList DrawList to assign to materials.
 */
o3djs.material.setDrawListOnMaterials = function(pack, drawList) {
  var materials = pack.getObjectsByClassName('o3d.Material');
  for (var mm = 0; mm < materials.length; mm++) {
    var material = materials[mm];
    // TODO: look at flags on the material left by the importer
    //   to decide which draw list to use.
    material.drawList = drawList;
  }
};

/**
 * This function creates a basic material for when you just want to get
 * something on the screen quickly without having to manually setup shaders.
 * You can call this function something like.
 *
 * <pre>
 * &lt;html&gt;&lt;body&gt;
 * &lt;script type="text/javascript" src="o3djs/all.js"&gt;
 * &lt;/script&gt;
 * &lt;script&gt;
 * window.onload = init;
 *
 * function init() {
 *   o3djs.base.makeClients(initStep2);
 * }
 *
 * function initStep2(clientElements) {
 *   var clientElement = clientElements[0];
 *   var client = clientElement.client;
 *   var pack = client.createPack();
 *   var viewInfo = o3djs.rendergraph.createBasicView(
 *       pack,
 *       client.root,
 *       client.renderGraphRoot);
 *   var material = o3djs.material.createBasicMaterial(
 *       pack,
 *       viewInfo,
 *       [1, 0, 0, 1]);  // red
 *   var shape = o3djs.primitives.createCube(pack, material, 10);
 *   var transform = pack.createObject('Transform');
 *   transform.parent = client.root;
 *   transform.addShape(shape);
 *   o3djs.camera.fitContextToScene(client.root,
 *                                  client.width,
 *                                  client.height,
 *                                  viewInfo.drawContext);
 * }
 * &lt;/script&gt;
 * &lt;div id="o3d" style="width: 600px; height: 600px"&gt;&lt;/div&gt;
 * &lt;/body&gt;&lt;/html&gt;
 * </pre>
 *
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo as returned from
 *     o3djs.rendergraph.createBasicView.
 * @param {(!o3djs.math.Vector4|!o3d.Texture)} colorOrTexture Either a color in
 *     the format [r, g, b, a] or an O3D texture.
 * @param {boolean} opt_transparent Whether or not the material is transparent.
 *     Defaults to false.
 * @return {!o3d.Material} The created material.
 */
o3djs.material.createBasicMaterial = function(pack,
                                              viewInfo,
                                              colorOrTexture,
                                              opt_transparent) {
  var material = pack.createObject('Material');
  material.drawList = opt_transparent ? viewInfo.zOrderedDrawList :
                                        viewInfo.performanceDrawList;

  // If it has a length assume it's a color, otherwise assume it's a texture.
  if (colorOrTexture.length) {
    material.createParam('diffuse', 'ParamFloat4').value = colorOrTexture;
  } else {
    var paramSampler = material.createParam('diffuseSampler', 'ParamSampler');
    var sampler = pack.createObject('Sampler');
    paramSampler.value = sampler;
    sampler.texture = colorOrTexture;
  }

  // Create some suitable defaults for the material to save the user having
  // to know all this stuff right off the bat.
  material.createParam('emissive', 'ParamFloat4').value = [0, 0, 0, 1];
  material.createParam('ambient', 'ParamFloat4').value = [0, 0, 0, 1];
  material.createParam('specular', 'ParamFloat4').value = [1, 1, 1, 1];
  material.createParam('shininess', 'ParamFloat').value = 50;
  material.createParam('specularFactor', 'ParamFloat').value = 1;
  material.createParam('lightColor', 'ParamFloat4').value = [1, 1, 1, 1];
  var lightPositionParam = material.createParam('lightWorldPos',
                                                'ParamFloat3');

  o3djs.material.attachStandardEffect(pack, material, viewInfo, 'phong');

  // We have to set the light position after calling attachStandardEffect
  // because attachStandardEffect sets it based on the view.
  lightPositionParam.value = [1000, 2000, 3000];

  return material;
};

/**
 * This function creates a constant material. No lighting. It is especially
 * useful for debugging shapes and 2d UI elements.
 *
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo as returned from
 *     o3djs.rendergraph.createBasicView.
 * @param {(!o3djs.math.Vector4|!o3d.Texture)} colorOrTexture Either a color in
 *     the format [r, g, b, a] or an O3D texture.
 * @param {boolean} opt_transparent Whether or not the material is transparent.
 *     Defaults to false.
 * @return {!o3d.Material} The created material.
 */
o3djs.material.createConstantMaterial = function(pack,
                                                 viewInfo,
                                                 colorOrTexture,
                                                 opt_transparent) {
  var material = pack.createObject('Material');
  material.drawList = opt_transparent ? viewInfo.zOrderedDrawList :
                                        viewInfo.performanceDrawList;

  // If it has a length assume it's a color, otherwise assume it's a texture.
  if (colorOrTexture.length) {
    material.createParam('emissive', 'ParamFloat4').value = colorOrTexture;
  } else {
    var paramSampler = material.createParam('emissiveSampler', 'ParamSampler');
    var sampler = pack.createObject('Sampler');
    paramSampler.value = sampler;
    sampler.texture = colorOrTexture;
  }

  o3djs.material.attachStandardEffect(pack, material, viewInfo, 'constant');

  return material;
};

/**
 * This function creates 2 color procedureal texture material.
 *
 * @see o3djs.material.createBasicMaterial
 *
 * @param {!o3d.Pack} pack Pack to manage created objects.
 * @param {!o3djs.rendergraph.ViewInfo} viewInfo as returned from
 *     o3djs.rendergraph.createBasicView.
 * @param {!o3djs.math.Vector4} opt_color1 a color in the format [r, g, b, a].
 *     Defaults to a medium blue-green.
 * @param {!o3djs.math.Vector4} opt_color2 a color in the format [r, g, b, a].
 *     Defaults to a light blue-green.
 * @param {boolean} opt_transparent Whether or not the material is transparent.
 *     Defaults to false.
 * @param {number} opt_checkSize Defaults to 10 units.
 * @return {!o3d.Material} The created material.
 */
o3djs.material.createCheckerMaterial = function(pack,
                                                viewInfo,
                                                opt_color1,
                                                opt_color2,
                                                opt_transparent,
                                                opt_checkSize) {
  opt_color1 = opt_color1 || [0.4, 0.5, 0.5, 1];
  opt_color2 = opt_color2 || [0.6, 0.8, 0.8, 1];
  opt_checkSize = opt_checkSize || 10;

  var effect = o3djs.effect.createCheckerEffect(pack);
  var material = pack.createObject('Material');
  material.effect = effect;
  material.drawList = opt_transparent ? viewInfo.zOrderedDrawList :
                                        viewInfo.performanceDrawList;
  o3djs.effect.createUniformParameters(pack, effect, material);

  material.getParam('color1').value = opt_color1;
  material.getParam('color2').value = opt_color2;
  material.getParam('checkSize').value = opt_checkSize;

  return material;
};

/**
 * Creates a material for an effect loaded from a file.
 * If the effect has already been loaded in the pack it will be reused.
 * @param {!o3d.Pack} pack Pack to create effect in.
 * @param {string} url Url for effect file.
 * @param {!o3d.DrawList} drawList DrawList to assign effect to.
 * @return {!o3d.Material} The material.
 */
o3djs.material.createMaterialFromFile = function(pack, url, drawList) {
  var effect = o3djs.effect.createEffectFromFile(pack, url);

  var material = pack.createObject('Material');
  material.effect = effect;
  material.drawList = drawList;
  o3djs.effect.createUniformParameters(pack, effect, material);

  return material;
};

/**
 * Binds params to all materials in a pack by name.
 * @param {!o3d.Material} material Material to bind params on.
 * @param {!Object} params A object where each property is the name of a param
 *     and its value is that param.
 */
o3djs.material.bindParamsOnMaterial = function(material, params) {
  for (var paramName in params) {
    var sourceParam = params[paramName];
    var param = material.getParam(paramName);
    if (param && sourceParam.isAClassName(param.className)) {
      param.bind(sourceParam);
    }
  }
};

/**
 * Binds params to all materials in a pack by name.
 * @param {!o3d.Pack} pack Pack with materials to bind.
 * @param {!Object} params A object where each property is the name of a param
 *     and its value is that param.
 */
o3djs.material.bindParams = function(pack, params) {
  var materials = pack.getObjectsByClassName('o3d.Material');
  for (var mm = 0; mm < materials.length; ++mm) {
    o3djs.material.bindParamsOnMaterial(materials[mm], params);
  }
};

/**
 * Creates params from a param spec.
 * @param {!o3d.Pack} pack Pack to create params in.
 * @param {!Object} paramSpec An object where each property is the name of a
 *     param and its value is the type of param.
 * @return {!Object} params A object where each property is the name of a param
 *     and its value is that param.
 */
o3djs.material.createParams = function(pack, paramSpec) {
  var paramObject = pack.createObject('ParamObject');
  var params = { };
  for (var paramName in paramSpec) {
    params[paramName] = paramObject.createParam(paramName,
                                                paramSpec[paramName]);
  }
  return params;
};

/**
 * Creates the global params need by the shaders built in effect.js
 *
 * The params currently created are 'lightColor' which is a ParamFloat4 and
 * 'lightWorldPos' which is a ParamFloat3. You can set their values like this
 *
 * <pre>
 * var params = o3djs.material.createStandardParams(pack);
 * param.lightColor.value = [1, 0, 0, 1];  // red
 * param.lightWorldPos.value = [1000, 2000, 3000];  // set light position.
 * </pre>
 *
 * Note: This function just creates the params. It does not connect them to
 * anything. See o3djs.material.createAndBindStandardParams,
 * o3djs.material.createParams and o3djs.material.bindParams
 *
 * @see o3djs.material.createAndBindStandardParams
 * @see o3djs.material.createParams
 * @see o3djs.material.bindParams
 *
 * @param {!o3d.Pack} pack Pack to create params in.
 * @return {!Object} params A object where each property is the name of a param
 *     and its value is that param.
 */
o3djs.material.createStandardParams = function(pack) {
  var paramSpec = {
    'lightColor': 'ParamFloat4',
    'lightWorldPos': 'ParamFloat3'};
  return o3djs.material.createParams(pack, paramSpec);
};

/**
 * Creates the global params need by the shaders built in effect.js then binds
 * all the matching params on materials in pack to these global params.
 *
 * The params currently created are 'lightColor' which is a ParamFloat4 and
 * 'lightWorldPos' which is a ParamFloat3. You can set their values like this
 *
 * <pre>
 * var params = o3djs.material.createAndBindStandardParams(pack);
 * param.lightColor.value = [1, 0, 0, 1];  // red
 * param.lightWorldPos.value = [1000, 2000, 3000];  // set light position.
 * </pre>
 *
 * @see o3djs.material.createParams
 * @see o3djs.material.bindParams
 *
 * @param {!o3d.Pack} pack Pack to create params in.
 * @return {!Object} params A object where each property is the name of a param
 *     and its value is that param.
 */
o3djs.material.createAndBindStandardParams = function(pack) {
  var params = o3djs.material.createStandardParams(pack);
  o3djs.material.bindParams(pack, params);
  return params;
};

