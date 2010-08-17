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
 * @fileoverview This file contains various functions related to effects.
 * It puts them in the "effect" module on the o3djs object.
 *
 *     Note: This library is only a sample. It is not meant to be some official
 *     library. It is provided only as example code.
 *
 */

o3djs.provide('o3djs.effect');

o3djs.require('o3djs.io');

/**
 * A Module for dealing with effects.
 * @namespace
 */
o3djs.effect = o3djs.effect || {};

/**
 * The name of standard 2 color checker effect.
 * @type {string}
 */
o3djs.effect.TWO_COLOR_CHECKER_EFFECT_NAME = 
    'o3djs.effect.twoColorCheckerEffect';

/**
 * An effect string for a 2 color checker effect.
 * @type {string}
 */
o3djs.effect.TWO_COLOR_CHECKER_FXSTRING = '' +
    'float4x4 worldViewProjection : WORLDVIEWPROJECTION;\n' +
    'float4x4 worldInverseTranspose : WORLDINVERSETRANSPOSE;\n' +
    'float4x4 world : WORLD;\n' +
    'float4 color1;\n' +
    'float4 color2;\n' +
    'float checkSize;\n' +
    'float3 lightWorldPos;\n' +
    'float3 lightColor;\n' +
    '\n' +
    'struct VertexShaderInput {\n' +
    '  float4 position : POSITION;\n' +
    '  float4 normal : NORMAL;\n' +
    '  float2 texcoord : TEXCOORD0;\n' +
    '};\n' +
    '\n' +
    'struct PixelShaderInput {\n' +
    '  float4 position : POSITION;\n' +
    '  float2 texcoord : TEXCOORD0;\n' +
    '  float3 normal : TEXCOORD1;\n' +
    '  float3 worldPosition : TEXCOORD2;\n' +
    '};\n' +
    '\n' +
    'float4 checker(float2 uv) {\n' +
    '  float fmodResult = fmod(floor(checkSize * uv.x) + \n' +
    '                          floor(checkSize * uv.y), 2.0);\n' +
    '  return (fmodResult < 1) ? color1 : color2;\n' +
    '}\n' +
    '\n' +
    'PixelShaderInput vertexShaderFunction(VertexShaderInput input) {\n' +
    '  PixelShaderInput output;\n' +
    '\n' +
    '  output.position = mul(input.position, worldViewProjection);\n' +
    '  output.normal = mul(input.normal, worldInverseTranspose).xyz;\n' +
    '  output.worldPosition = mul(input.position, world).xyz;\n' +
    '  output.texcoord = input.texcoord;\n' +
    '  return output;\n' +
    '}\n' +
    '\n' +
    'float4 pixelShaderFunction(PixelShaderInput input): COLOR {\n' +
    '  float3 surfaceToLight = \n' +
    '      normalize(lightWorldPos - input.worldPosition);\n' +
    '  float3 worldNormal = normalize(input.normal);\n' +
    '  float4 check = checker(input.texcoord);\n' +
    '  float4 directionalIntensity = \n' +
    '      saturate(dot(worldNormal, surfaceToLight));\n' +
    '  float4 outColor = directionalIntensity * check;\n' +
    '  return float4(outColor.rgb, check.a);\n' +
    '}\n' +
    '\n' +
    '// #o3d VertexShaderEntryPoint vertexShaderFunction\n' +
    '// #o3d PixelShaderEntryPoint pixelShaderFunction\n' +
    '// #o3d MatrixLoadOrder RowMajor\n';

/**
 * The name of the parameter on a material if it's a collada standard
 * material.
 *
 * NOTE: This parameter is just a string attached to a material. It has no
 *     meaning to the plugin, it is passed from the conditioner to the
 *     javascript libraries so that they can build collada like effects.
 *
 * @type {string}
 */
o3djs.effect.COLLADA_LIGHTING_TYPE_PARAM_NAME = 'collada.lightingType';

/**
 * The collada standard lighting types.
 * @type {!Object}
 */
o3djs.effect.COLLADA_LIGHTING_TYPES = {phong: 1,
                                       lambert: 1,
                                       blinn: 1,
                                       constant: 1};

/**
 * The FCollada standard materials sampler parameter name prefixes.
 * @type {!Array.<string>}
 */
o3djs.effect.COLLADA_SAMPLER_PARAMETER_PREFIXES = ['emissive',
                                                   'ambient',
                                                   'diffuse',
                                                   'specular',
                                                   'bump'];

/**
 * Check if lighting type is a collada lighting type.
 * @param {string} lightingType Lighting type to check.
 * @return {boolean} true if it's a collada lighting type.
 */
o3djs.effect.isColladaLightingType = function(lightingType) {
  return o3djs.effect.COLLADA_LIGHTING_TYPES[lightingType.toLowerCase()] ==
      1;
};

/**
 * Returns the collada lighting type of a collada standard material.
 * @param {!o3d.Material} material Material to get lighting type from.
 * @return {string} The lighting type or "" if it's not a collada standard
 *      material.
 */
o3djs.effect.getColladaLightingType = function(material) {
  var lightingTypeParam = material.getParam(
      o3djs.effect.COLLADA_LIGHTING_TYPE_PARAM_NAME);
  if (lightingTypeParam) {
    var lightingType = lightingTypeParam.value.toLowerCase();
    if (o3djs.effect.isColladaLightingType(lightingType)) {
      return lightingType;
    }
  }
  return '';
};

/**
 * Get the number of TEXCOORD streams needed by this material.
 * @param {!o3d.Material} material The material MUST be a standard
 *     collada material.
 * @return {number} The number oc TEXCOORD streams needed.
 */
o3djs.effect.getNumTexCoordStreamsNeeded = function(material) {
  var lightingType = o3djs.effect.getColladaLightingType(material);
  if (!o3djs.effect.isColladaLightingType(lightingType)) {
    throw 'not a collada standard material';
  }
  var colladaSamplers = o3djs.effect.COLLADA_SAMPLER_PARAMETER_PREFIXES;
  var numTexCoordStreamsNeeded = 0
  for (var cc = 0; cc < colladaSamplers.length; ++cc) {
    var samplerPrefix = colladaSamplers[cc];
    var samplerParam = material.getParam(samplerPrefix + 'Sampler');
    if (samplerParam) {
      ++numTexCoordStreamsNeeded;
    }
  }
  return numTexCoordStreamsNeeded;
};

/**
 * Loads shader source from an external file and creates shaders for an effect.
 * @param {!o3d.Effect} effect The effect to create the shaders in.
 * @param {string} url The url of the shader source.
 */
o3djs.effect.loadEffect = function(effect, url) {
  var fxString = o3djs.io.loadTextFileSynchronous(url);
  effect.loadFromFXString(fxString);
};

/**
 * Creates an effect from a file.
 * If the effect already exists in the pack that effect will be returned.
 * @param {!o3d.Pack} pack Pack to create effect in.
 * @param {string} url Url for effect file.
 * @return {!o3d.Effect} The effect.
 */
o3djs.effect.createEffectFromFile = function(pack, url) {
  var effect = pack.getObjects(url, 'o3d.Effect')[0];
  if (!effect) {
    effect = pack.createObject('Effect');
    o3djs.effect.loadEffect(effect, url);
    effect.name = url;
  }
  return effect;
};

/**
 * Builds a shader string for a given standard COLLADA material type.
 *
 * @param {!o3d.Material} material Material for which to build the shader.
 * @param {string} effectType Type of effect to create ('phong', 'lambert',
 *     'constant').
 * @return {{description: string, shader: string}} A description and the shader
 *     string.
 */
o3djs.effect.buildStandardShaderString = function(material,
                                                  effectType) {
  var bumpSampler = material.getParam('bumpSampler');
  var bumpUVInterpolant;

  /**
   * Extracts the texture type from a texture param.
   * @param {!o3d.ParamTexture} textureParam The texture parameter to
   *     inspect.
   * @return {string} The texture type (1D, 2D, 3D or CUBE).
   */
  var getTextureType = function(textureParam) {
    var texture = textureParam.value;
    if (!texture) return '2D';  // No texture value, have to make a guess.
    switch (texture.className) {
      case 'o3d.Texture1D' : return '1D';
      case 'o3d.Texture2D' : return '2D';
      case 'o3d.Texture3D' : return '3D';
      case 'o3d.TextureCUBE' : return 'CUBE';
      default : return '2D';
    }
  }

  /**
   * Extracts the sampler type from a sampler param.  It does it by inspecting
   * the texture associated with the sampler.
   * @param {!o3d.ParamTexture} samplerParam The texture parameter to
   *     inspect.
   * @return {string} The texture type (1D, 2D, 3D or CUBE).
   */
  var getSamplerType = function(samplerParam) {
    var sampler = samplerParam.value;
    if (!sampler) return '2D';
    var textureParam = sampler.getParam('Texture');
    if (textureParam)
      return getTextureType(textureParam);
    else
      return '2D';
  };

  /**
   * Builds uniform variables common to all standard lighting types.
   * @return {string} The effect code for the common shader uniforms.
   */
  var buildCommonUniforms = function() {
    return 'uniform float4x4 worldViewProjection : WORLDVIEWPROJECTION;\n' +
           'uniform float3 lightWorldPos;\n' +
           'uniform float4 lightColor;\n'
  };

  /**
   * Builds uniform variables common to lambert, phong and blinn lighting types.
   * @return {string} The effect code for the common shader uniforms.
   */
  var buildLightingUniforms = function() {
    return 'uniform float4x4 world : WORLD;\n' +
           'uniform float4x4 viewInverse : VIEWINVERSE;\n' +
           'uniform float4x4 worldInverseTranspose : WORLDINVERSETRANSPOSE;\n';
  };

  /**
   * Builds uniform parameters for a given color input.  If the material
   * has a sampler parameter, a sampler uniform is created, otherwise a
   * float4 color value is created.
   * @param {!o3d.Material} material The material to inspect.
   * @param {!Array.<string>} descriptions Array to add descriptions too.
   * @param {string} name The name of the parameter to look for.  Usually
   *                      emissive, ambient, diffuse or specular.
   * @param {boolean} opt_addColorParam Whether to add a color param if no
   *     sampler exists. Default = true.
   * @return {string} The effect code for the uniform parameter.
   */
  var buildColorParam = function(material, descriptions, name,
                                 opt_addColorParam) {
    if (opt_addColorParam === undefined) {
      opt_addColorParam = true;
    }
    var samplerParam = material.getParam(name + 'Sampler');
    if (samplerParam) {
      var type = getSamplerType(samplerParam);
      descriptions.push(name + type + 'Texture');
      return 'sampler' + type + ' ' + name + 'Sampler;\n'
    } else if (opt_addColorParam) {
      descriptions.push(name + 'Color');
      return 'uniform float4 ' + name + ';\n';
    } else {
      return '';
    }
  };

  /**
   * Builds the effect code to retrieve a given color input.  If the material
   * has a sampler parameter of that name, a texture lookup is done.  Otherwise
   * it's a no-op, since the value is retrieved directly from the color uniform
   * of that name.
   * @param {!o3d.Material} material The material to inspect.
   * @param {string} name The name of the parameter to look for.  Usually
   *                      emissive, ambient, diffuse or specular.
   * @return {string} The effect code for the uniform parameter retrieval.
   */
  var getColorParam = function(material, name) {
    var samplerParam = material.getParam(name + 'Sampler');
    if (samplerParam) {
      var type = getSamplerType(samplerParam);
      return '  float4 ' + name + ' = tex' + type +
             '(' + name + 'Sampler, input.' + name + 'UV);\n'
    } else {
      return '';
    }
  };

  /**
   * Builds the vertex and fragment shader entry point in the format that
   * o3d can parse.
   * @return {string} The effect code for the entry points.
   */
  var buildEntryPoints = function() {
    return '  // #o3d VertexShaderEntryPoint vertexShaderFunction\n' +
           '  // #o3d PixelShaderEntryPoint pixelShaderFunction\n' +
           '  // #o3d MatrixLoadOrder RowMajor\n';
  };

  /**
   * Builds vertex and fragment shader string for the Constant lighting type.
   * @param {!o3d.Material} material The material for which to build
   *     shaders.
   * @param {!Array.<string>} descriptions Array to add descriptions too.
   * @return {string} The effect code for the shader, ready to be parsed.
   */
  var buildConstantShaderString = function(material, descriptions) {
    descriptions.push('constant');
    return buildCommonUniforms() +
           buildColorParam(material, descriptions, 'emissive') +
           buildVertexDecls(material, false, false) +
           'OutVertex vertexShaderFunction(InVertex input) {\n' +
           '  OutVertex output;\n' +
           positionVertexShaderCode() +
           buildUVPassthroughs(material) +
           '  return output;\n' +
           '}\n' +
           'float4 pixelShaderFunction(OutVertex input) : COLOR {\n' +
           getColorParam(material, 'emissive') +
           '  return emissive;\n' +
           '}\n' +
           '\n' +
           buildEntryPoints();
  };

  /**
   * Builds vertex and fragment shader string for the Lambert lighting type.
   * @param {!o3d.Material} material The material for which to build
   *     shaders.
   * @param {!Array.<string>} descriptions Array to add descriptions too.
   * @return {string} The effect code for the shader, ready to be parsed.
   */
  var buildLambertShaderString = function(material, descriptions) {
    descriptions.push('lambert');
    return buildCommonUniforms() +
           buildLightingUniforms() +
           buildColorParam(material, descriptions, 'emissive') +
           buildColorParam(material, descriptions, 'ambient') +
           buildColorParam(material, descriptions, 'diffuse') +
           buildColorParam(material, descriptions, 'bump', false) +
           buildVertexDecls(material, true, false) +
           'OutVertex vertexShaderFunction(InVertex input) {\n' +
           '  OutVertex output;\n' +
           buildUVPassthroughs(material) +
           positionVertexShaderCode() +
           normalVertexShaderCode() +
           surfaceToLightVertexShaderCode() +
           bumpVertexShaderCode() +
           '  return output;\n' +
           '}\n' +
           'float4 pixelShaderFunction(OutVertex input) : COLOR\n' +
           '{\n' +
           getColorParam(material, 'emissive') +
           getColorParam(material, 'ambient') +
           getColorParam(material, 'diffuse') +
           getNormalShaderCode() +
           '  float3 surfaceToLight = normalize(input.surfaceToLight);\n' +
           '  float4 litR = lit(dot(normal, surfaceToLight), 0, 0);\n' +
           '  return float4((emissive +\n' +
           '      lightColor * (ambient * diffuse + diffuse * litR.y)).rgb,' +
           '      diffuse.a);\n' +
           '}\n' +
           '\n' +
           buildEntryPoints();

  };

  /**
   * Builds vertex and fragment shader string for the Blinn lighting type.
   * @param {!o3d.Material} material The material for which to build
   *     shaders.
   * @param {!Array.<string>} descriptions Array to add descriptions too.
   * @return {string} The effect code for the shader, ready to be parsed.
   * TODO: This is actually just a copy of the Phong code.
   *     Change to Blinn.
   */
  var buildBlinnShaderString = function(material, descriptions) {
    descriptions.push('blinn');
    return buildCommonUniforms() +
        buildLightingUniforms() +
        buildColorParam(material, descriptions, 'emissive') +
        buildColorParam(material, descriptions, 'ambient') +
        buildColorParam(material, descriptions, 'diffuse') +
        buildColorParam(material, descriptions, 'specular') +
        buildColorParam(material, descriptions, 'bump', false) +
        'uniform float shininess;\n' +
        'uniform float specularFactor;\n' +
        buildVertexDecls(material, true, true) +
        'OutVertex vertexShaderFunction(InVertex input) {\n' +
        '  OutVertex output;\n' +
        buildUVPassthroughs(material) +
        positionVertexShaderCode() +
        normalVertexShaderCode() +
        surfaceToLightVertexShaderCode() +
        surfaceToViewVertexShaderCode() +
        bumpVertexShaderCode() +
        '  return output;\n' +
        '}\n' +
        'float4 pixelShaderFunction(OutVertex input) : COLOR\n' +
        '{\n' +
        getColorParam(material, 'emissive') +
        getColorParam(material, 'ambient') +
        getColorParam(material, 'diffuse') +
        getColorParam(material, 'specular') +
        getNormalShaderCode() +
        '  float3 surfaceToLight = normalize(input.surfaceToLight);\n' +
        '  float3 surfaceToView = normalize(input.surfaceToView);\n' +
        '  float3 halfVector = normalize(surfaceToLight + surfaceToView);\n' +
        '  float4 litR = lit(dot(normal, surfaceToLight), \n' +
        '                    dot(normal, halfVector), shininess);\n' +
        '  return float4((emissive +\n' +
        '  lightColor * (ambient * diffuse + diffuse * litR.y +\n' +
        '                        + specular * litR.z * specularFactor)).rgb,' +
        '      diffuse.a);\n' +
        '}\n' +
        '\n' +
        buildEntryPoints();
  };

  /**
   * Builds vertex and fragment shader string for the Phong lighting type.
   * @param {!o3d.Material} material The material for which to build
   *     shaders.
   * @param {!Array.<string>} descriptions Array to add descriptions too.
   * @return {string} The effect code for the shader, ready to be parsed.
   */
  var buildPhongShaderString = function(material, descriptions) {
    descriptions.push('phong');
    return buildCommonUniforms() +
        buildLightingUniforms() +
        buildColorParam(material, descriptions, 'emissive') +
        buildColorParam(material, descriptions, 'ambient') +
        buildColorParam(material, descriptions, 'diffuse') +
        buildColorParam(material, descriptions, 'specular') +
        buildColorParam(material, descriptions, 'bump', false) +
        'uniform float shininess;\n' +
        'uniform float specularFactor;\n' +
        buildVertexDecls(material, true, true) +
        'OutVertex vertexShaderFunction(InVertex input) {\n' +
        '  OutVertex output;\n' +
        buildUVPassthroughs(material) +
        positionVertexShaderCode() +
        normalVertexShaderCode() +
        surfaceToLightVertexShaderCode() +
        surfaceToViewVertexShaderCode() +
        bumpVertexShaderCode() +
        '  return output;\n' +
        '}\n' +
        'float4 pixelShaderFunction(OutVertex input) : COLOR\n' +
        '{\n' +
        getColorParam(material, 'emissive') +
        getColorParam(material, 'ambient') +
        getColorParam(material, 'diffuse') +
        getColorParam(material, 'specular') +
        getNormalShaderCode() +
        '  float3 surfaceToLight = normalize(input.surfaceToLight);\n' +
        '  float3 surfaceToView = normalize(input.surfaceToView);\n' +
        '  float3 halfVector = normalize(surfaceToLight + surfaceToView);\n' +
        '  float4 litR = lit(dot(normal, surfaceToLight), \n' +
        '                    dot(normal, halfVector), shininess);\n' +
        '  return float4((emissive +\n' +
        '  lightColor * (ambient * diffuse + diffuse * litR.y +\n' +
        '                        + specular * litR.z * specularFactor)).rgb,' +
        '      diffuse.a);\n' +
        '}\n' +
        '\n' +
        buildEntryPoints();
  };

  // An integer value which keeps track of the next available interpolant.
  var interpolant;

  /**
   * Builds the texture coordinate declaration for a given color input
   * (usually emissive, anmbient, diffuse or specular).  If the color
   * input does not have a sampler, no TEXCOORD declaration is built.
   * @param {!o3d.Material} material The material to inspect.
   * @param {string} name The name of the color input.
   * @return {string} The code for the texture coordinate declaration.
   */
  var buildTexCoord = function(material, name) {
    if (material.getParam(name + 'Sampler')) {
      return '  float2 ' + name + 'UV : TEXCOORD' + interpolant++ + ';\n';
    } else {
      return '';
    }
  };

  /**
   * Builds all the texture coordinate declarations for a vertex attribute
   * declaration.
   * @param {!o3d.Material} material The material to inspect.
   * @return {string} The code for the texture coordinate declarations.
   */
  var buildTexCoords = function(material) {
    interpolant = 0;
    return buildTexCoord(material, 'emissive') +
           buildTexCoord(material, 'ambient') +
           buildTexCoord(material, 'diffuse') +
           buildTexCoord(material, 'specular');
  };

  /**
   * Builds the texture coordinate passthrough statement for a given
   * color input (usually emissive, ambient, diffuse or specular).  These
   * assigments are used in the vertex shader to pass the texcoords to be
   * interpolated to the rasterizer.  If the color input does not have
   * a sampler, no code is generated.
   * @param {!o3d.Material} material The material to inspect.
   * @param {string} name The name of the color input.
   * @return {string} The code for the texture coordinate passthrough statement.
   */
  var buildUVPassthrough = function(material, name) {
    if (material.getParam(name + 'Sampler')) {
      return '  output.' + name + 'UV = input.' + name + 'UV;\n';
    } else {
      return '';
    }
  };

  /**
   * Builds all the texture coordinate passthrough statements for the
   * vertex shader.
   * @param {!o3d.Material} material The material to inspect.
   * @return {string} The code for the texture coordinate passthrough
   *                  statements.
   */
  var buildUVPassthroughs = function(material) {
    return buildUVPassthrough(material, 'emissive') +
           buildUVPassthrough(material, 'ambient') +
           buildUVPassthrough(material, 'diffuse') +
           buildUVPassthrough(material, 'specular') +
           buildUVPassthrough(material, 'bump');
  };

  /**
   * Builds bump input coords if needed.
   * @return {string} The code for bump input coords.
   */
  var buildBumpInputCoords = function() {
    return bumpSampler ?
        ('  float3 tangent      : TANGENT;\n' +
         '  float3 binormal     : BINORMAL;\n' +
         '  float2 bumpUV       : TEXCOORD' + interpolant++ + ';\n') : '';
  };

  /**
   * Builds bump output coords if needed.
   * @return {string} The code for bump input coords.
   */
  var buildBumpOutputCoords = function() {
    return bumpSampler ?
        ('  float3 tangent      : TEXCOORD' + interpolant++ + ';\n' +
         '  float3 binormal     : TEXCOORD' + interpolant++ + ';\n' +
         '  float2 bumpUV       : TEXCOORD' + interpolant++ + ';\n') : '';
  };

  /**
   * Builds the position code for the vertex shader.
   * @return {string} The code for the vertex shader.
   */
  var positionVertexShaderCode = function() {
    return '  output.position = mul(input.position, worldViewProjection);\n';
  };

  /**
   * Builds the normal code for the vertex shader.
   * @return {string} The code for the vertex shader.
   */
  var normalVertexShaderCode = function() {
    return '  output.normal = mul(float4(input.normal, 0),\n' +
           '                      worldInverseTranspose).xyz;\n';
  };

  /**
   * Builds the surface to light code for the vertex shader.
   * @return {string} The code for the vertex shader.
   */
  var surfaceToLightVertexShaderCode = function() {
    return '  output.surfaceToLight = lightWorldPos - \n' +
           '                          mul(input.position, world).xyz;\n';
  };

  /**
   * Builds the surface to view code for the vertex shader.
   * @return {string} The code for the vertex shader.
   */
  var surfaceToViewVertexShaderCode = function() {
    return '  output.surfaceToView = (viewInverse[3] - mul(input.position,\n' +
           '                                               world)).xyz;\n';
  };

  /**
   * Builds the normal map part of the vertex shader.
   * @return {string} The code for normal mapping in the vertex shader.
   */
  var bumpVertexShaderCode = function() {
    return bumpSampler ?
        ('  output.binormal = ' +
         'mul(float4(input.binormal, 0), worldInverseTranspose).xyz;\n' +
         '  output.tangent = ' +
         'mul(float4(input.tangent, 0), worldInverseTranspose).xyz;\n') : '';
  };

  /**
   * Builds the normal calculation of the pixel shader.
   * @return {string} The code for normal computation in the pixel shader.
   */
  var getNormalShaderCode = function() {
    return bumpSampler ?
        ('float3x3 tangentToWorld = float3x3(input.tangent,\n' +
         '                                   input.binormal,\n' +
         '                                   input.normal);\n' +
         'float3 tangentNormal = tex2D(bumpSampler, input.bumpUV.xy).xyz -\n' +
         '                       float3(0.5, 0.5, 0.5);\n' +
         'float3 normal = mul(tangentNormal, tangentToWorld);\n' +
         'normal = normalize(normal);\n') :
        '  float3 normal = normalize(input.normal);\n';
  };

  /**
   * Builds the vertex declarations for a given material.
   * @param {!o3d.Material} material The material to inspect.
   * @param {boolean} diffuse Whether to include stuff for diffuse calculations.
   * @param {boolean} specular Whether to include stuff for diffuse
   *     calculations.
   * @return {string} The code for the vertex declarations.
   */
  var buildVertexDecls = function(material, diffuse, specular) {
    var str = 'struct InVertex {\n' +
              '  float4 position     : POSITION;\n';
    if (diffuse || specular) {
      str += '  float3 normal       : NORMAL;\n';
    }
    str += buildTexCoords(material) +
           buildBumpInputCoords() +
           '};\n' +
           'struct OutVertex {\n' +
           '  float4 position     : POSITION;\n' +
           buildTexCoords(material) +
           buildBumpOutputCoords();
    if (diffuse || specular) {
      str += '  float3 normal        : TEXCOORD' + interpolant++ + ';\n' +
             '  float3 surfaceToLight: TEXCOORD' + interpolant++ + ';\n';
    }
    if (specular) {
      str += '  float3 surfaceToView : TEXCOORD' + interpolant++ + ';\n';
    }
    str += '};\n'
    return str;
  };

  // Create a shader string of the appropriate type, based on the
  // effectType.
  var str;
  var descriptions = [];
  if (effectType == 'phong') {
    str = buildPhongShaderString(material, descriptions);
  } else if (effectType == 'lambert') {
    str = buildLambertShaderString(material, descriptions);
  } else if (effectType == 'blinn') {
    str = buildBlinnShaderString(material, descriptions);
  } else if (effectType == 'constant') {
    str = buildConstantShaderString(material, descriptions);
  } else {
    throw ('unknown effect type "' + effectType + '"');
  }

  return {description: descriptions.join('_'), shader: str};
};

/**
 * Gets or builds a shader for given standard COLLADA material type.
 *
 * Looks at the material passed in and assigns it an Effect that matches its
 * Params. If a suitable Effect already exists in pack it will use that Effect.
 *
 * @param {!o3d.Pack} pack Pack in which to create the new Effect.
 * @param {!o3d.Material} material Material for which to build the shader.
 * @param {string} effectType Type of effect to create ('phong', 'lambert',
 *     'constant').
 * @return {o3d.Effect} The created effect.
 */
o3djs.effect.getStandardShader = function(pack,
                                          material,
                                          effectType) {
  var record = o3djs.effect.buildStandardShaderString(material,
                                                      effectType);
  var effects = pack.getObjectsByClassName('o3d.Effect');
  for (var ii = 0; ii < effects.length; ++ii) {
    if (effects[ii].name == record.description &&
        effects[ii].source == record.shader) {
      return effects[ii];
    }
  }
  var effect = pack.createObject('Effect');
  if (effect) {
    effect.name = record.description;
    if (effect.loadFromFXString(record.shader)) {
      return effect;
    }
    pack.removeObject(effect);
  }
  return null;
};

/**
 * Attaches a shader for a given standard COLLADA material type to the material.
 *
 * Looks at the material passed in and assigns it an Effect that matches its
 * Params. If a suitable Effect already exists in pack it will use that Effect.
 *
 * @param {!o3d.Pack} pack Pack in which to create the new Effect.
 * @param {!o3d.Material} material Material for which to build the shader.
 * @param {!o3djs.math.Vector3} lightPos Position of the default light.
 * @param {string} effectType Type of effect to create ('phong', 'lambert',
 *     'constant').
 * @return {boolean} True on success.
 */
o3djs.effect.attachStandardShader = function(pack,
                                             material,
                                             lightPos,
                                             effectType) {
  var effect = o3djs.effect.getStandardShader(pack,
                                              material,
                                              effectType);
  if (effect) {
    material.effect = effect;
    effect.createUniformParameters(material);

    // Set a couple of the default parameters in the hopes that this will
    // help the user get something on the screen. We check to make sure they
    // are not connected to something otherwise we'll get an error.
    var param = material.getParam('lightWorldPos');
    if (!param.inputConnection) {
      param.value = lightPos;
    }
    var param = material.getParam('lightColor');
    if (!param.inputConnection) {
      param.value = [1, 1, 1, 1];
    }
    return true;
  } else {
    return false;
  }
};

/**
 * Creates the uniform parameters needed for an Effect on the given ParamObject.
 * @param {!o3d.Pack} pack Pack to create extra objects in like Samplers and
 *     ParamArrays.
 * @param {!o3d.Effect} effect Effect.
 * @param {!o3d.ParamObject} paramObject ParamObject on which to create Params.
 */
o3djs.effect.createUniformParameters = function(pack, effect, paramObject) {
  effect.createUniformParameters(paramObject);
  var infos = effect.getParameterInfo();
  for (var ii = 0; ii < infos.length; ++ii) {
    var info = infos[ii];
    if (info.sasClassName.length == 0) {
      if (info.numElements > 0) {
        var paramArray = pack.createObject('ParamArray');
        var param = paramObject.getParam(info.name);
        param.value = paramArray;
        paramArray.resize(info.numElements, info.className);
        if (info.className == 'o3d.ParamSampler') {
          for (var jj = 0; jj < info.numElements; ++jj) {
            var sampler = pack.createObject('Sampler');
            paramArray.getParam(jj).value = sampler;
          }
        }
      } else if (info.className == 'o3d.ParamSampler') {
        var sampler = pack.createObject('Sampler');
        var param = paramObject.getParam(info.name);
        param.value = sampler;
      }
    }
  }
};

/**
 * Creates an effect that draws a 2 color procedural checker pattern.
 * @param {!o3d.Pack} pack The pack to create the effect in. If the pack
 *     already has an effect with the same name that effect will be returned.
 * @return {!o3d.Effect} The effect.
 */
o3djs.effect.createCheckerEffect = function(pack) {
  var effects = pack.getObjects(o3djs.effect.TWO_COLOR_CHECKER_EFFECT_NAME,
                                'o3d.Effect');
  if (effects.length > 0) {
    return effects[0];
  }

  var effect = pack.createObject('Effect');
  effect.loadFromFXString(o3djs.effect.TWO_COLOR_CHECKER_FXSTRING);
  effect.name = o3djs.effect.TWO_COLOR_CHECKER_EFFECT_NAME;
  return effect;
};
