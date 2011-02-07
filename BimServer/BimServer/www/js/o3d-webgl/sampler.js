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
 * Sampler is the base of all texture samplers.  Texture samplers encapsulate
 * a texture reference with a set of states that define how the texture
 * gets applied to a surface.  Sampler states are set either via Params defined
 * on the Sampler object or directly via one the convenience methods defined
 * on the Sampler.  The following states are supported (default values are in
 * parenthesis):
 *  \li 'addressModeU' (WRAP)
 *  \li 'addressModeV' (WRAP)
 *  \li 'addressModeW' (WRAP)
 *  \li 'magFilter' (LINEAR)
 *  \li 'minFilter' (LINEAR)
 *  \li 'mipFilter' (POINT)
 *  \li 'borderColor' ([0,0,0,0])
 *  \li 'maxAnisotropy' (1)
 */
o3d.Sampler = function() {
  o3d.ParamObject.call(this);

  /**
   * The texture address mode for the u coordinate.
   * @type {!o3d.Sampler.AddressMode}
   */
  this.addressModeU = o3d.Sampler.WRAP;

  /**
   * The texture address mode for the v coordinate.
   * @type {!o3d.Sampler.AddressMode}
   */
  this.addressModeV = o3d.Sampler.WRAP;

  /**
   * The texture address mode for the w coordinate.
   * @type {!o3d.Sampler.AddressMode}
   */
  this.addressModeW = o3d.Sampler.WRAP;

  /**
   * The magnification filter.  Valid values for the mag filter are:
   * POINT and LINEAR. Default = LINEAR.
   * @type {!o3d.Sampler.FilterType}
   */
  this.magFilter = o3d.Sampler.LINEAR;

  /**
   * The minification filter. Valid values for the min filter are:
   * POINT, LINEAR and ANISOTROPIC. Default = LINEAR.
   * @type {!o3d.Sampler.FilterType}
   */
  this.minFilter = o3d.Sampler.LINEAR;

  /**
   * The mipmap filter used during minification.  Valid values for the
   * mip filter are: NONE, POINT and LINEAR. Default = LINEAR.
   * @type {!o3d.Sampler.FilterType}
   */
  this.mipFilter = o3d.Sampler.LINEAR;

  /**
   * Color returned for texture coordinates outside the [0,1] range when the
   * address mode is set to BORDER.
   * @type {!Array.<number>}
   */
  this.borderColor = [0, 0, 0, 0];

  /**
   * Degree of anisotropy used when the ANISOTROPIC filter type is used.
   * @type {number}
   */
  this.maxAnisotropy = 1;

  /**
   * The Texture object used by this Sampler.
   * @type {o3d.Texture}
   */
  this.texture = null;
};
o3d.inherit('Sampler', 'ParamObject');



/**
 * @type {number}
 */
o3d.Sampler.AddressMode = goog.typedef;


/**
 *  AddressMode,
 *   Controls what happens with texture coordinates outside the [0..1] range.
 *  WRAP
 *  MIRROR
 *  CLAMP
 *  BORDER
 */
o3d.Sampler.WRAP = 0;
o3d.Sampler.MIRROR = 1;
o3d.Sampler.CLAMP = 2;
o3d.Sampler.BORDER = 3;


/**
 * @type {number}
 */
o3d.Sampler.FilterType = goog.typedef;

/**
 *  FilterType,
 *   Texture filtering types.
 *  NONE
 *  POINT
 *  LINEAR
 *  ANISOTROPIC
 */
o3d.Sampler.NONE = 0;
o3d.Sampler.POINT = 1;
o3d.Sampler.LINEAR = 2;
o3d.Sampler.ANISOTROPIC = 3;


o3d.ParamObject.setUpO3DParam_(o3d.Sampler, 'addressModeU', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.Sampler, 'addressModeV', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.Sampler, 'addressModeW', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.Sampler, 'magFilter', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.Sampler, 'minFilter', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.Sampler, 'mipFilter', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.Sampler, 'borderColor', 'ParamFloat4');
o3d.ParamObject.setUpO3DParam_(o3d.Sampler, 'maxAnisotropy', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.Sampler, 'texture', 'ParamTexture');


/**
 * Converts the addressing mode of the sampler from an o3d constant to a webgl
 * constant.
 * @param {!o3d.Sampler.AddressMode} o3d_mode, the O3D addressing mode.
 * @return {number} The webgl mode.
 */
o3d.Sampler.prototype.convertAddressMode_ = function(o3d_mode) {
  var gl_mode = this.gl.REPEAT;
  switch (o3d_mode) {
    case o3d.Sampler.WRAP:
      gl_mode = this.gl.REPEAT;
      break;
    case o3d.Sampler.MIRROR:
      gl_mode = this.gl.MIRRORED_REPEAT;
      break;
    case o3d.Sampler.CLAMP:
      gl_mode = this.gl.CLAMP_TO_EDGE;
      break;
    case o3d.Sampler.BORDER:
      // This is not supported in WebGL.
    default:
      this.gl.client.error_callback("Unknown/Unavailable Address mode");
      break;
  }
  return gl_mode;
}


/**
 * Converts the min filter mode of the sampler from an o3d constant to a webgl
 * constant.
 * @param {!o3d.Sampler.FilterType} o3d_filter, the O3D filter.
 * @param {!o3d.Sampler.FilterType} mip_filter, the O3D mip filter.
 * @return {number} The webgl filter.
 */
o3d.Sampler.prototype.convertMinFilter_ = function(o3d_filter, mip_filter) {
  switch (o3d_filter) {
    case o3d.Sampler.NONE:
      return this.gl.NEAREST;
    case o3d.Sampler.POINT:
      if (mip_filter == o3d.Sampler.NONE) {
        return this.gl.NEAREST;
      } else if (mip_filter == o3d.Sampler.POINT) {
        return this.gl.NEAREST_MIPMAP_NEAREST;
      } else if (mip_filter == o3d.Sampler.LINEAR) {
        return this.gl.NEAREST_MIPMAP_LINEAR;
      } else if (mip_filter == o3d.Sampler.ANISOTROPIC) {
        return this.gl.NEAREST_MIPMAP_LINEAR;
      }
    case o3d.Sampler.ANISOTROPIC:
    case o3d.Sampler.LINEAR:
      if (mip_filter == o3d.Sampler.NONE) {
        return this.gl.LINEAR;
      } else if (mip_filter == o3d.Sampler.POINT) {
        return this.gl.LINEAR_MIPMAP_NEAREST;
      } else if (mip_filter == o3d.Sampler.LINEAR) {
        return this.gl.LINEAR_MIPMAP_LINEAR;
      } else if (mip_filter == o3d.Sampler.ANISOTROPIC) {
        return this.gl.LINEAR_MIPMAP_LINEAR;
      }
  }

  this.gl.client.error_callback("Unknown filter.");
  return this.gl.NONE;
}


/**
 * Converts the mag filter mode of the sampler from an o3d constant to a webgl
 * constant.
 * @param {!o3d.Sampler.FilterType} o3d_filter, the O3D filter.
 * @return {number} The webgl filter.
 */
o3d.Sampler.prototype.convertMagFilter_ = function(o3d_filter) {
  switch (o3d_filter) {
    case o3d.Sampler.NONE:
    case o3d.Sampler.POINT:
      return this.gl.NEAREST;
    case o3d.Sampler.LINEAR:
    case o3d.Sampler.ANISOTROPIC:
      return this.gl.LINEAR;
  }
  this.gl.client.error_callback("Unknown filter.");
  return this.gl.LINEAR;
}


/**
 * A default Sampler that has no texture, thus uses the client's error texture.
 *
 * @type {!o3d.Sampler}
 * @private
 */
o3d.Sampler.defaultSampler_ = new o3d.Sampler();
o3d.Sampler.defaultSampler_.magFilter = o3d.Sampler.POINT;

/**
 * Binds the texture for this sampler and sets texParameters according to the
 * states of the sampler.
 * @param {boolean} opt_isCube Optional boolean indicating if this is a cube
 *     map, so we can use the right error texture.
 */
o3d.Sampler.prototype.bindAndSetParameters_ = function(opt_isCube) {
  var currentTexture = null;
  if (this.texture) {
    currentTexture = this.texture;
  } else if (!this.gl.client.reportErrors_()) {
    if (opt_isCube) {
      currentTexture = this.gl.client.error_texture_cube_;
    } else {
      currentTexture = this.gl.client.error_texture_;
    }
  } else {
    currentTexture = this.gl.client.fallback_error_texture_;
    this.gl.client.error_callback("Missing texture for sampler " + this.name);
  }

  var mip_filter = this.mipFilter;
  if (currentTexture.levels == 1) {
    mip_filter = o3d.Sampler.NONE;
  }
  currentTexture.bindAndSetParameters_(
    this.convertAddressMode_(this.addressModeU),
    this.convertAddressMode_(this.addressModeV),
    this.convertMinFilter_(this.minFilter, mip_filter),
    this.convertMagFilter_(this.magFilter));
}

