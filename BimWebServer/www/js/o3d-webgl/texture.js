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
 * The Texture class is a base class for image data used in texture mapping.
 * @constructor
 */
o3d.Texture = function() {
  o3d.ParamObject.call(this);

  /**
   * The memory format used for storing the bitmap associated with the texture
   * object.
   * @type {o3d.Texture.Format}
   */
  this.format = o3d.Texture.UNKNOWN_FORMAT;

  /**
   * The number of mipmap levels used by the texture.
   * @type {number}
   */
  this.levels = 1;

  /**
   * True if all the alpha values in the texture are 1.0
   * @type {boolean}
   */
  this.alphaIsOne = true;

  /**
   * The associated gl texture.
   * @type {WebGLTexture}
   * @private
   */
  this.texture_ = null;

  /**
   * The associated GL texture target: TEXTURE_2D or TEXTURE_CUBE_MAP.
   * This is the argument "target" to calls to bindTeture.
   * NOT THE SAME THING AS the argument "target" to texImage2D.
   * @type {number}
   * @private
   */
  this.texture_target_ = 0;

  /**
   * The width of the underlying webgl texture.
   * @type {number}
   * private
   */
  this.texture_width_ = 0;

  /**
   * The width of the underlying webgl texture.
   * @type {number}
   * private
   */
  this.texture_height_ = 0;

 /**
  * When texParameters get set, this keeps track of what they are so we don't
  * set them again next time if we don't have to.
  * @private
  */
  this.parameter_cache_ = {};
};
o3d.inherit('Texture', 'ParamObject');


/**
 * @type {number}
 */
o3d.Texture.Format = goog.typedef;

/**
 *  Format,
 *  UNKNOWN_FORMAT
 *  XRGB8
 *  ARGB8
 *  ABGR16F
 *  R32F
 *  ABGR32F
 *  DXT1
 *  DXT3
 *  DXT5
 *
 * The in-memory format of the texture bitmap.
 *
 * NOTE: The R32F format is different on GL vs D3D. If you use it in a shader
 * you must only use the red channel. The green, blue and alpha channels are
 * undefined.
 *
 * For example:
 *
 * ...
 *
 * sampler texSampler0;
 *
 * ...
 *
 * struct PixelShaderInput {
 *   float4 position : POSITION;
 *   float2 texcoord : TEXCOORD0;
 * };
 *
 * float4 pixelShaderFunction(PixelShaderInput input): COLOR {
 *   return tex2D(texSampler0, input.texcoord).rrrr;
 * }
 *
 * @param {number} levels The number of mip levels in this texture.
 */
o3d.Texture.UNKNOWN_FORMAT = 0;
o3d.Texture.XRGB8 = 1;
o3d.Texture.ARGB8 = 2;
o3d.Texture.ABGR16F = 3;
o3d.Texture.R32F = 4;
o3d.Texture.ABGR32F = 5;
o3d.Texture.DXT1 = 6;
o3d.Texture.DXT3 = 7;
o3d.Texture.DXT5 = 8;


/**
 * Generates Mips.
 * @param {number} source_level the mip to use as the source.
 * @param {number} num_levels the number of mips from the source to generate.
 */
o3d.Texture.prototype.generateMips =
    function(source_level, num_levels) {
  this.gl.bindTexture(this.texture_target_, this.texture_);
  this.gl.generateMipmap(this.texture_target_);
  this.levels = num_levels;
};


/**
 * Indicates whether the given number is a power of two.
 * @param {number} value The number.
 * @private
 */
o3d.Texture.isPowerOfTwo_ = function(value) {
  return (value & (value - 1)) == 0;
};


/**
 * Computes the smallest power of two that is greater than or equal to the
 * the given number.
 * @param {number} value The number.
 * @private
 */
o3d.Texture.nextHighestPowerOfTwo_ = function(value) {
  var r = 1;
  while (r < value) {
    r *= 2;
  }
  return r;
};


/**
 * Returns the GL texture format that is closest to this texture's O3D texture
 * format. Not all formats specified in o3d.Texture have a webgl equivalent,
 * thus we return the one with the correct number of channels, if such exists.
 *
 * @return {number} A webgl format.
 * @private
 */
o3d.Texture.prototype.getGLTextureFormat_ = function() {
  switch (this.format) {
    case o3d.Texture.XRGB8:
      return this.gl.RGB;

    case o3d.Texture.ARGB8:
    case o3d.Texture.ABGR16F:
    case o3d.Texture.ABGR32F:
      return this.gl.RGBA;

    case o3d.Texture.R32F:
    case o3d.Texture.DXT1:
    case o3d.Texture.DXT3:
    case o3d.Texture.DXT5:
    default:
      o3d.notImplemented();
      return 0;
  }
}


/**
 * Helper function to determine the proper argument for the texture target
 * This is either gl.TEXTURE_2D or gl.TEXTURE_CUBE_MAP_POSITIVE_X + face.
 *
 * @param {o3d.TextureCUBE.CubeFace} face The current face if applicable.
 * @return {number} The proper argument for the texture target.
 */
o3d.Texture.prototype.getTexImage2DTarget_ = function(opt_face) {
  if (this.texture_target_ == this.gl.TEXTURE_CUBE_MAP) {
    return this.gl.TEXTURE_CUBE_MAP_POSITIVE_X + opt_face;
  } else {
    return this.gl.TEXTURE_2D;
  }
};


/**
 * Computes the maximum number of levels of mips a given width and height could
 * use.
 * @param {number} width Width of texture.
 * @param {number} height Height of texture.
 * @return {number} The maximum number of levels for the given width and height.
 */
o3d.Texture.maxLevels_ = function(width, height) {
  if (width == 0 || height == 0) {
    return 0;
  }
  var max = Math.max(width, height);
  var levels = 0;
  while (max > 0) {
    ++levels;
    max = max >> 1;
  }
  return levels;
};


var g_counter = 0;


/**
 * Creates a webgl texture from the given image object rescaling to the
 * smallest power of 2 in each dimension still no smaller than the original
 * size.
 * @param {HTMLCanvas} canvas The canvas to load into the texture.
 * @param {boolean} resize_to_pot Whether or not to resize to a power of two
 *     size.
 * @param {boolean} generate_mips Whether or not to generate mips.
 * @param {o3d.TextureCUBE.CubeFace} opt_face The face number, if this is a
 *     cube map.
 * @private
 */
o3d.Texture.prototype.setFromCanvas_ =
    function(canvas, resize_to_pot, flip, generate_mips, opt_face) {
  var gl = this.gl;

  if (resize_to_pot && (!o3d.Texture.isPowerOfTwo_(canvas.width) ||
      !o3d.Texture.isPowerOfTwo_(canvas.height))) {
    // Get a scratch canvas.
    var scratch = o3d.Bitmap.getScratchCanvas_();
    // Set the size of the canvas to the power-of-two size.
    scratch.width = o3d.Texture.nextHighestPowerOfTwo_(canvas.width);
    scratch.height = o3d.Texture.nextHighestPowerOfTwo_(canvas.height);
    // Draw the given canvas into that scratch canvas.
    scratch.getContext("2d").drawImage(canvas,
        0, 0, canvas.width, canvas.height,
        0, 0, scratch.width, scratch.height);
    canvas = scratch;
  }

  gl.pixelStorei(gl.UNPACK_FLIP_Y_WEBGL, flip);

  gl.bindTexture(this.texture_target_, this.texture_);
  gl.texImage2D(this.getTexImage2DTarget_(opt_face), 0 /*level*/, gl.RGBA,
      gl.RGBA, gl.UNSIGNED_BYTE, canvas);

  gl.pixelStorei(gl.UNPACK_FLIP_Y_WEBGL, 0);


  this.texture_width_ = canvas.width;
  this.texture_height_ = canvas.height;

  if (generate_mips) {
    // The texture target is already bound so why bind it again by calling
    // this.generateMip.
    this.gl.generateMipmap(this.texture_target_);
    this.levels = o3d.Texture.maxLevels_(
        this.texture_width_, this.texture_height_);
  }

  g_counter++;
};


/**
 * Copy pixels from source bitmap to certain mip level.
 * Scales if the width and height of source and dest do not match.
 *
 * @param {HTMLCanvas} source_img The source canvas.
 * @param {number} source_x x-coordinate of the starting pixel in the
 *     source image.
 * @param {number} source_y y-coordinate of the starting pixel in the
 *     source image.
 * @param {number} source_width width of the source image to draw.
 * @param {number} source_height Height of the source image to draw.
 * @param {number} dest_mip on which mip level to draw to.
 * @param {number} dest_x x-coordinate of the starting pixel in the
 *     destination texture.
 * @param {number} dest_y y-coordinate of the starting pixel in the
 *     destination texture.
 * @param {number} dest_width width of the dest image.
 * @param {number} dest_height height of the dest image.
 * @param {number} opt_face The face number if this is a cube map.
 */
o3d.Texture.prototype.drawImageFromCanvas_ =
    function(source_canvas, source_x, source_y, source_width, source_height,
             dest_mip, dest_x, dest_y, dest_width, dest_height, opt_face) {
  var canvas = o3d.Bitmap.getScratchCanvas_();
  canvas.width = dest_width;
  canvas.height = dest_height;

  // Get a scratch canvas and set its size to that of the source material.
  // Set up transformation so that the draw into the canvas fill it with the
  // source bitmap.
  var context = canvas.getContext('2d');
  context.save();

  context.translate(-source_x, -source_y);
  context.scale(dest_width / source_width,
                dest_height / source_height);

  // Draw the source image into the canvas, filling it.
  context.drawImage(
      source_canvas, 0, 0, source_canvas.width, source_canvas.height);

  // Call texSubImage2D to upload the source image from the scratch canvas
  // to the texture.
  var gl = this.gl;
  gl.bindTexture(this.texture_target_, this.texture_);
  var format = this.getGLTextureFormat_();

  //*/
  // TODO(petersont): Replace this with a call to texSubImage2D once
  // browsers support it.
  gl.texImage2D(this.getTexImage2DTarget_(opt_face), dest_mip, gl.RGBA,
      gl.RGBA, gl.UNSIGNED_BYTE, canvas);
  /*/
  gl.texSubImage2D(target, 0, dest_x, dest_y, dest_width, dest_height,
      gl.RGBA, gl.UNSIGNED_BYTE, canvas);
  //*/
  this.texture_width_ = canvas.width;
  this.texture_height_ = canvas.height;

  context.restore();
};


/**
 * Sets the values of the data stored in the texture.
 *
 * @param {number} level the mip level to update.
 * @param {number} values Values to be stored in the buffer.
 * @param {o3d.TextureCUBE.CubeFace} opt_face The face to set if this is a cube
 *     texture.
 * @private
 */
o3d.Texture.prototype.setValues_ = function(level, values, opt_face) {
  var pixels = new Uint8Array(values.length);
  for (var i = 0; i < values.length; ++i) {
    pixels[i] = Math.min(255, Math.max(0, values[i] * 256.0));
  }

  var format = this.getGLTextureFormat_();
  this.gl.bindTexture(this.texture_target_, this.texture_);

  this.gl.texSubImage2D(this.getTexImage2DTarget_(opt_face),
      level, 0, 0, this.texture_width_, this.texture_height_,
      format, this.gl.UNSIGNED_BYTE, pixels);
};


/**
 * Initializes this Texture2D object of the specified size and format and
 * reserves the necessary resources for it.
 *
 * Note: If enable_render_surfaces is true, then the dimensions must be a
 * power of two.
 *
 * @param {number} texture_target The apropriate value for texture_target.
 * @param {number} width The width of the texture area in texels (max = 2048)
 * @param {number} height The height of the texture area in texels (max = 2048)
 * @param {o3d.Texture.Format} format The memory format of each texel
 * @param {number} levels The number of mipmap levels.  Use zero to create the
 *     compelete mipmap chain.
 * @param {boolean} enable_render_surfaces If true, the texture object will
 *     expose RenderSurface objects through GetRenderSurface(...).
 * @return {!o3d.Texture2D}  The Texture2D object.
 */
o3d.Texture.prototype.initWithTarget_ =
    function(texture_target, width, height, format, levels,
        enable_render_surfaces, debug) {
  this.width = width;
  this.height = height;
  this.format = format;
  this.levels = levels;
  this.texture_ = this.gl.createTexture();
  this.texture_target_ = texture_target;

  if (width != undefined && height != undefined) {
    this.gl.bindTexture(this.texture_target_, this.texture_);

    var format = this.getGLTextureFormat_();

    // TODO(petersont): remove this allocation once Firefox supports
    // passing null as argument to this form of ... some function.
    var pixels = new Uint8Array(width * height * 4);

    var canvas = o3d.Bitmap.getScratchCanvas_();
    canvas.width = width;
    canvas.height = height;

    var numFaces = 1;
    if (this.texture_target_ == this.gl.TEXTURE_CUBE_MAP) {
      numFaces = 6;
    }

    for (var face = 0; face < numFaces; ++face) {
      this.gl.texImage2D(this.getTexImage2DTarget_(face), 0, format, width,
          height, 0, format, this.gl.UNSIGNED_BYTE, pixels);
    }

    this.texture_width_ = width;
    this.texture_height_ = height;
  }
};


/**
 * A class for 2D textures that defines the interface for getting
 * the dimensions of the texture, its memory format and number of mipmap levels.
 *
 * @param {number} opt_width The width of this texture in pixels.
 * @param {number} opt_height The height of this texture in pixels.
 * @constructor
 */
o3d.Texture2D = function(opt_width, opt_height) {
  o3d.Texture.call(this);

  /**
   * The width of the texture, in texels.
   * @type {number}
   */
  this.width = opt_width || 0;

  /**
   * The height of the texture, in texels.
   * @type {number}
   */
  this.height = opt_height || 0;

  /**
   * The cache of rendersurface objects.
   * @private
   */
  this.renderSurfaces_ = [];
};
o3d.inherit('Texture2D', 'Texture');

o3d.ParamObject.setUpO3DParam_(o3d.Texture2D, 'width', 'ParamInteger');
o3d.ParamObject.setUpO3DParam_(o3d.Texture2D, 'height', 'ParamInteger');


/**
 * Initializes this Texture2D object of the specified size and format and
 * reserves the necessary resources for it.
 *
 * Note: If enable_render_surfaces is true, then the dimensions must be a
 * power of two.
 *
 * @param {number} width The width of the texture area in texels (max = 2048)
 * @param {number} height The height of the texture area in texels (max = 2048)
 * @param {o3d.Texture.Format} format The memory format of each texel
 * @param {number} levels The number of mipmap levels.  Use zero to create the
 *     compelete mipmap chain.
 * @param {boolean} enable_render_surfaces If true, the texture object will
 *     expose RenderSurface objects through GetRenderSurface(...).
 * @return {!o3d.Texture2D}  The Texture2D object.
 */
o3d.Texture2D.prototype.init_ =
    function(width, height, format, levels, enable_render_surfaces) {
  this.initWithTarget_(this.gl.TEXTURE_2D,
      width, height, format, levels, enable_render_surfaces);
};


/**
 * Returns a RenderSurface object associated with a mip_level of a texture.
 *
 * @param {number} mip_level The mip-level of the surface to be returned.
 * @return {o3d.RenderSurface}  The RenderSurface object.
 */
o3d.Texture2D.prototype.getRenderSurface =
    function(mip_level) {
  if (!this.renderSurfaces_[mip_level]) {
    var renderSurface = new o3d.RenderSurface();
    renderSurface.gl = this.gl;
    renderSurface.initWithTexture(this, mip_level);
    this.renderSurfaces_[mip_level] = renderSurface;
  }

  return this.renderSurfaces_[mip_level];
};


/**
 * Sets the values of the data stored in the texture.
 *
 * It is not recommend that you call this for large textures but it is useful
 * for making simple ramps or noise textures for shaders.
 *
 * NOTE: the number of values must equal the size of the texture * the number
 *  of elements. In other words, for a XRGB8 texture there must be
 *  width * height * 3 values. For an ARGB8, ABGR16F or ABGR32F texture there
 *  must be width * height * 4 values. For an R32F texture there must be
 *  width * height values.
 *
 * NOTE: the order of channels is R G B for XRGB8 textures and R G B A
 * for ARGB8, ABGR16F and ABGR32F textures so for example for XRGB8 textures
 *
 * [1, 0, 0] = a red pixel
 * [0, 0, 1] = a blue pixel
 *
 * For ARGB8, ABGR16F, ABGR32F textures
 *
 * [1, 0, 0, 0] = a red pixel with zero alpha
 * [1, 0, 0, 1] = a red pixel with one alpha
 * [0, 0, 1, 1] = a blue pixel with one alpha
 *
 * @param {number} level the mip level to update.
 * @param {values} values Values to be stored in the buffer.
 */
o3d.Texture2D.prototype.set =
    function(level, values) {
  this.setValues_(level, values);
};


/**
 * Sets a rectangular area of values in a texture.
 *
 * Does clipping. In other words if you pass in a 10x10 pixel array
 * and give it destination of (-5, -5) it will only use the bottom 5x5
 * pixels of the array you passed in to set the top 5x5 pixels of the
 * texture.
 *
 * See o3d.Texture2D.set for details on formats.
 *
 * @param {number} level the mip level to update.
 * @param {number} destination_x The x coordinate of the area in the texture
 *     to affect.
 * @param {number} destination_y The y coordinate of the area in the texture
 *     to affect.
 * @param {number} source_width The width of the area to effect. The height is
 *     determined by the size of the array passed in.
 * @param {number} values Values to be stored in the buffer.
 */
o3d.Texture2D.prototype.setRect =
    function(level, destination_x, destination_y, source_width, values) {
  var format = this.getGLTextureFormat_();
  var numChannels = (format == this.gl.RGB ? 3 : 4);
  var source_height = (values.length / numChannels) / source_width;

  // If completely clipped off, do nothing and return.
  if (destination_x > this.width || destination_y > this.height ||
      destination_x + source_width < 0 || destination_y + source_height < 0) {
    return;
  }

  // Size of the unclipped, remaining rectangle.
  var size_x = source_width;
  if (destination_x < 0) {
    size_x += destination_x;
  }
  if (destination_x + source_width > this.width) {
    size_x -= (destination_x + source_width) - this.width;
  }

  var size_y = source_height;
  if (destination_y < 0) {
    size_y += destination_y;
  }
  if (destination_y + source_height > this.height) {
    size_y -= (destination_y + source_height) - this.height;
  }

  // The upper left corner of the rectangle that is not clipped and will be
  // copied into the texture.
  var start_x = (destination_x < 0) ? Math.abs(destination_x) : 0;
  var start_y = (destination_y < 0) ? Math.abs(destination_y) : 0;

  var keptPixels = new Uint8Array(size_x * size_y * numChannels);
  var count = 0;
  for (var y = 0; y < size_y; ++y) {
    for (var x = 0; x < size_x; ++x) {
      var t = (((start_y + y) * source_width) + (start_x + x)) * numChannels;
      keptPixels[count++] = Math.min(255, Math.max(0, values[t] * 256.0));
      keptPixels[count++] = Math.min(255, Math.max(0, values[t + 1] * 256.0));
      keptPixels[count++] = Math.min(255, Math.max(0, values[t + 2] * 256.0));
      keptPixels[count++] = Math.min(255, Math.max(0, values[t + 3] * 256.0));
    }
  }

  // The (x, y) at which to begin drawing the rectangle on the original texture,
  // measured from the *BOTTOM* left hand corner.
  var where_x = Math.max(destination_x, 0);
  var where_y = this.height - (Math.max(destination_y, 0) + size_y);

  this.gl.bindTexture(this.texture_target_, this.texture_);
  this.gl.texSubImage2D(this.gl.TEXTURE_2D, level, where_x, where_y,
      size_x, size_y, format, this.gl.UNSIGNED_BYTE, keptPixels);
};


/**
 * Gets a rectangular area of values from a texture.
 *
 * See o3d.Texture2D.set for details on formats.
 * Can not be used for compressed textures.
 *
 * @param {number} level the mip level to get.
 * @param {number} x The x coordinate of the area in the texture to retrieve.
 * @param {number} y The y coordinate of the area in the texture to retrieve.
 * @param {number} width The width of the area to retrieve.
 * @param {number} height The height of the area to retrieve.
 * @return {number}  Array of pixel values.
 */
o3d.Texture2D.prototype.getRect =
    function(level, x, y, width, height) {
  o3d.notImplemented();
};


/**
 * Sets the content of the texture to the content of the bitmap. The texture
 * and the bitmap must be the same dimensions and the same format.
 *
 * @param {o3d.Bitmap} bitmap The bitmap to copy data from.
 */
o3d.Texture2D.prototype.setFromBitmap = function(bitmap) {
  // Whether to resize the texture to power-of-two size.
  var resize_to_pot = bitmap.defer_mipmaps_to_texture_;
  this.setFromCanvas_(bitmap.canvas_,
                      resize_to_pot,
                      bitmap.defer_flip_vertically_to_texture_,
                      bitmap.defer_mipmaps_to_texture_);
};


/**
 * Copy pixels from source bitmap to certain face and mip level.
 * Scales if the width and height of source and dest do not match.
 *
 * @param {o3d.Bitmap} source_img The source bitmap.
 * @param {number} source_mip which mip of the source to copy from.
 * @param {number} source_x x-coordinate of the starting pixel in the
 *     source image.
 * @param {number} source_y y-coordinate of the starting pixel in the
 *     source image.
 * @param {number} source_width width of the source image to draw.
 * @param {number} source_height Height of the source image to draw.
 * @param {number} dest_mip on which mip level to draw to.
 * @param {number} dest_x x-coordinate of the starting pixel in the
 *     destination texture.
 * @param {number} dest_y y-coordinate of the starting pixel in the
 *     destination texture.
 * @param {number} dest_width width of the destination image.
 * @param {number} dest_height height of the destination image.
 */
o3d.Texture2D.prototype.drawImage =
    function(source_img, source_mip, source_x, source_y, source_width,
             source_height, dest_mip, dest_x, dest_y, dest_width, dest_height) {
  this.drawImageFromCanvas_(source_img.canvas_,
      source_x, source_y, source_width, source_height, dest_mip,
      dest_x, dest_y, dest_width, dest_height);
};


/**
 * TextureCUBE is a class for textures used for cube mapping.  A cube texture
 * stores bitmaps for the 6 faces of a cube and is addressed via three texture
 * coordinates.
 *
 * @param {number} edgeLength The length of any edge of this texture
 * @constructor
 */
o3d.TextureCUBE = function() {
  o3d.Texture.call(this);

  /**
   * The length of each edge of the cube, in texels.
   * @type {number}
   */
  this.edgeLength = 0;

  /**
   * Keeps track of whether the faces of the cube map have been set to a
   * bitmap of some sort.  Used to prolong the generation of mipmaps until the
   * last cube face has been set to something.
   * @type {!Object}
   * @private
   */
   this.faces_set_ = {
     0: false, 1: false, 2: false, 3: false, 4: false, 5: false
   };
};
o3d.inherit('TextureCUBE', 'Texture');


/**
 * @type {number}
 */
o3d.TextureCUBE.CubeFace = goog.typedef;


/**
 *  CubeFace,
 *  FACE_POSITIVE_X
 *  FACE_NEGATIVE_X
 *  FACE_POSITIVE_Y
 *  FACE_NEGATIVE_Y
 *  FACE_POSITIVE_Z
 *  FACE_NEGATIVE_Z
 *
 * The names of each of the six faces of a cube map texture.
 */
o3d.TextureCUBE.FACE_POSITIVE_X = 0;
o3d.TextureCUBE.FACE_NEGATIVE_X = 1;
o3d.TextureCUBE.FACE_POSITIVE_Y = 2;
o3d.TextureCUBE.FACE_NEGATIVE_Y = 3;
o3d.TextureCUBE.FACE_POSITIVE_Z = 4;
o3d.TextureCUBE.FACE_NEGATIVE_Z = 5;

o3d.ParamObject.setUpO3DParam_(o3d.TextureCUBE, 'edgeLength', 'ParamInteger');


/**
 * Initializes this TextureCUBE object of the specified size and format and
 * reserves the necessary resources for it.
 * Note:  If enable_render_surfaces is true, then the dimensions must be a
 * power of two.
 *
 * @param {number} edgeLength The edge of the texture area in texels
 *     (max = 2048)
 * @param {o3d.Texture.Format} format The memory format of each texel.
 * @param {number} levels The number of mipmap levels.   Use zero to create
 *     the compelete mipmap chain.
 * @param {boolean} enableRenderSurfaces If true, the texture object
 *     will expose RenderSurface objects through GetRenderSurface(...).
 * @private
 */
o3d.TextureCUBE.prototype.init_ =
    function(edgeLength, format, levels, enable_render_surfaces, debug) {
  this.initWithTarget_(this.gl.TEXTURE_CUBE_MAP,
      edgeLength, edgeLength, format, levels, enable_render_surfaces, debug);
};


/**
 * Returns a RenderSurface object associated with a given cube face and
 * mip_level of a texture.
 *
 * @param {o3d.TextureCUBE.CubeFace} face The cube face from which to extract
 *     the surface.
 * @param {o3d.Pack} pack This parameter is no longer used. The surface exists
 *     as long as the texture it came from exists.
 * @param {number} mip_level The mip-level of the surface to be returned.
 * @return {o3d.RenderSurface}  The RenderSurface object.
 */
o3d.TextureCUBE.prototype.getRenderSurface =
    function(face, mip_level, opt_pack) {
  o3d.notImplemented();
};


/**
 * Sets the values of the data stored in the texture.
 *
 * It is not recommend that you call this for large textures but it is useful
 * for making simple ramps or noise textures for shaders.
 *
 * See o3d.Texture2D.set for details on formats.
 *
 * @param {o3d.TextureCUBE.CubeFace} face the face to update.
 * @param {number} level the mip level to update.
 * @param {number} values Values to be stored in the buffer.
 */
o3d.TextureCUBE.prototype.set =
    function(face, level, values) {
  this.setValues_(level, values, face);
  this.faces_set_[face] = true;
};


/**
 * Sets a rectangular area of values in a texture.
 *
 * Does clipping. In other words if you pass in a 10x10 pixel array
 * and give it destination of (-5, -5) it will only use the bottom 5x5
 * pixels of the array you passed in to set the top 5x5 pixels of the
 * texture.
 *
 * See o3d.Texture2D.set for details on formats.
 *
 * @param {o3d.TextureCUBE.CubeFace} face the face to update.
 * @param {number} level the mip level to update.
 * @param {number} destination_x The x coordinate of the area in the texture
 *     to affect.
 * @param {number} destination_y The y coordinate of the area in the texture
 *     to affect.
 * @param {number} source_width The width of the area to effect. The height is
 *     determined by the size of the array passed in.
 * @param {number} values Values to be stored in the buffer.
 */
o3d.TextureCUBE.prototype.setRect =
    function(face, level, destination_x, destination_y, source_width, values) {
  o3d.notImplemented();
};


/**
 * Gets a rectangular area of values from a texture.
 *
 * See o3d.Texture2D.set for details on formats.
 * Can not be used for compressed textures.
 *
 * @param {o3d.TextureCUBE.CubeFace} face the face to get.
 * @param {number} level the mip level to get.
 * @param {number} x The x coordinate of the area in the texture to retrieve.
 * @param {number} y The y coordinate of the area in the texture to retrieve.
 * @param {number} width The width of the area to retrieve.
 * @param {number} height The height of the area to retrieve.
 * @return {number}  Array of pixel values.
 */
o3d.TextureCUBE.prototype.getRect =
    function(face, level, x, y, width, height) {
  o3d.notImplemented();
};


/**
 * Sets the content of a face of the texture to the content of the bitmap. The
 * texture and the bitmap must be the same dimensions and the same format.
 *
 * @param {o3d.TextureCUBE.CubeFace} face The face to set.
 * @param {o3d.Bitmap} bitmap The bitmap to copy data from.
 */
o3d.TextureCUBE.prototype.setFromBitmap =
    function(face, bitmap) {
  var generate_mipmaps = bitmap.defer_mipmaps_to_texture_;
  for (var f in this.faces_set_) {
    generate_mipmaps = generate_mipmaps &&
        (this.faces_set_[f] || f == face);
  }
  var resize_to_pot = bitmap.defer_mipmaps_to_texture_;
  this.setFromCanvas_(bitmap.canvas_,
                      resize_to_pot,
                      false, // Never flip cube maps.
                      generate_mipmaps,
                      face);
  this.faces_set_[face] = true;
};


/**
 * Copy pixels from source bitmap to certain face and mip level.
 * Scales if the width and height of source and dest do not match.
 * TODO(petersont): Should take optional arguments.
 *
 * @param {o3d.Bitmap} source_img The source bitmap.
 * @param {number} source_mip which mip of the source to copy from.
 * @param {number} source_x x-coordinate of the starting pixel in the
 *     source image.
 * @param {number} source_y y-coordinate of the starting pixel in the
 *     source image.
 * @param {number} source_width width of the source image to draw.
 * @param {number} source_height Height of the source image to draw.
 * @param {o3d.TextureCUBE.CubeFace} face on which face to draw on.
 * @param {number} dest_mip on which mip level to draw on.
 * @param {number} dest_x x-coordinate of the starting pixel in the
 *     destination texture.
 * @param {number} dest_y y-coordinate of the starting pixel in the
 *     destination texture.
 * @param {number} dest_width width of the destination image.
 * @param {number} dest_height height of the destination image.
 */
o3d.TextureCUBE.prototype.drawImage =
    function(source_img, source_mip, source_x, source_y, source_width,
             source_height, face, dest_mip, dest_x, dest_y, dest_width,
             dest_height) {
  this.drawImageFromCanvas_(source_img.canvas_,
      source_x, source_y, source_width, source_height, dest_mip,
      dest_x, dest_y, dest_width, dest_height, face);
};


/**
 * Makes this texture currrent, and sets various texParameters provided they
 * have changed since the last time bindAndSetParameters_ was called for this
 * texture.
 * @param {number} addressModeU  The address mode in the U coordinate.
 * @param {number} addressModeV  The address mode in the V coordinate.
 * @param {number} minFilter The type of the min filter.
 * @param {number} magFilter The type of the mag filter.
 */
o3d.Texture.prototype.bindAndSetParameters_ =
    function(addressModeU, addressModeV, minFilter, magFilter) {
  var target = this.texture_target_;
  this.gl.bindTexture(target, this.texture_);

  if (!(o3d.Texture.isPowerOfTwo_(this.texture_width_) &&
        o3d.Texture.isPowerOfTwo_(this.texture_height_)) ||
        this.texture_target_ == this.gl.TEXTURE_CUBE_MAP) {
    addressModeU = addressModeV = this.gl.CLAMP_TO_EDGE;
  }

  if (this.parameter_cache_.addressModeU != addressModeU) {
    this.gl.texParameteri(target, this.gl.TEXTURE_WRAP_S, addressModeU);
    this.parameter_cache_.addressModeU = addressModeU;
  }

  if (this.parameter_cache_.addressModeV != addressModeV) {
    this.gl.texParameteri(target, this.gl.TEXTURE_WRAP_T, addressModeV);
    this.parameter_cache_.addressModeV = addressModeV;
  }

  if (this.parameter_cache_.minFilter != minFilter) {
    this.gl.texParameteri(target, this.gl.TEXTURE_MIN_FILTER, minFilter);
    this.parameter_cache_.minFilter = minFilter;
  }

  if (this.parameter_cache_.magFilter != magFilter) {
    this.gl.texParameteri(target, this.gl.TEXTURE_MAG_FILTER, magFilter);
    this.parameter_cache_.magFilter = magFilter;
  }
};


