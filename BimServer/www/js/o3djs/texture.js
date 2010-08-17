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
 * @fileoverview This file contains functions helping to manipulate and manage
 *     textures.
 */

o3djs.provide('o3djs.texture');

/**
 * A Module for bitmaps.
 * @namespace
 */
o3djs.texture = o3djs.texture || {};

/**
 * The maximum dimension of a texture.
 * @type {number}
 */
o3djs.texture.MAX_TEXTURE_DIMENSION = 2048;

/**
 * Computes the maximum number of levels of mips a given width and height could
 * use.
 * @param {number} width Width of texture.
 * @param {number} height Height of texture.
 * @return {number} The maximum number of levels for the given width and height.
 */
o3djs.texture.computeNumLevels = function(width, height) {
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

/**
 * Creates a texture from a RawData object.
 * @param {!o3d.Pack} pack The pack to create the texture in.
 * @param {!o3d.RawData} rawData The raw data to create the texture from.
 * @param {boolean} opt_generateMips Whether or not to generate mips. Note, mips
 *    can not be generated for DXT textures although they will be loaded if they
 *    exist in the RawData.
 * @param {boolean} opt_flip Whether or not to flip the texture. Most DCC tools
 *    Like Maya, Max, etc expect the textures to be flipped.  Note that only
 *    2D (image) textures will be flipped. Cube textures will not be flipped.
 *    Default = true.
 * @param {number} opt_maxWidth The maximum width of the texture. If the RawData
 *    is larger than this size it will be scaled down to this size. Note that
 *    DXT format textures can not be scaled. Default = 2048.
 * @param {number} opt_maxHeight The maximum width of the texture. If the
 *    RawData is larger than this size it will be scaled down to this size. Note
 *    that DXT format textures can not be scaled. Default = 2048.
 * @return {!o3d.Texture} The created texture.
 */
o3djs.texture.createTextureFromRawData = function(
    pack,
    rawData,
    opt_generateMips,
    opt_flip,
    opt_maxWidth,
    opt_maxHeight) {
  // Make a bitmaps from the raw data.
  var bitmaps = pack.createBitmapsFromRawData(rawData);
  if (opt_flip || typeof opt_flip === 'undefined') {
    for (var ii = 0; ii < bitmaps.length; ++ii) {
      var bitmap = bitmaps[ii];
      if (bitmap.semantic == o3djs.base.o3d.Bitmap.IMAGE) {
        bitmaps[ii].flipVertically();
      }
    }
  }

  // Create a texture from the bitmaps.
  var texture = o3djs.texture.createTextureFromBitmaps(
      pack, bitmaps, opt_generateMips);

  // Delete the bitmaps.
  for (var ii = 0; ii < bitmaps.length; ++ii) {
    pack.removeObject(bitmaps[ii]);
  }

  return texture;
};

/**
 * Returns whether or not a given texture format can be scaled.
 * @param {!o3d.Texture.Format} format The format to check.
 * @return {boolean} True if you can scale and make mips for the given format.
 */
o3djs.texture.canMakeMipsAndScale = function(format) {
  switch (format) {
  case o3djs.base.o3d.Texture.XRGB8:
  case o3djs.base.o3d.Texture.ARGB8:
  case o3djs.base.o3d.Texture.ABGR16F:
  case o3djs.base.o3d.Texture.R32F:
  case o3djs.base.o3d.Texture.ABGR32F:
    return true;
  case o3djs.base.o3d.Texture.DXT1:
  case o3djs.base.o3d.Texture.DXT3:
  case o3djs.base.o3d.Texture.DXT5:
    return false;
  }
  return false;
};

/**
 * Creates a Texture from an array of bitmaps.
 * @param {!o3d.Pack} pack The pack to create the texture in.
 * @param {!Array.<!o3d.Bitmap>} bitmaps An array of bitmaps to create the
 *     texture from. For a 2D texture this would be 1 bitmap. For a cubemap this
 *     would be 6 bitmaps.
 * @param {boolean} opt_generateMips Whether or not to generate mips. Note, mips
 *    can not be generated for DXT textures although they will be loaded if they
 *    exist in the RawData. Default = true.
 * @return {!o3d.Texture} The created texture.
 */
o3djs.texture.createTextureFromBitmaps = function(
    pack,
    bitmaps,
    opt_generateMips) {

  if (bitmaps.length == 0) {
    throw 'no bitmaps';
  }

  var srcWidth = bitmaps[0].width;
  var srcHeight = bitmaps[0].height;
  var format = bitmaps[0].format;
  var mipMaps = bitmaps[0].numMipmaps;
  var maxMips = o3djs.texture.computeNumLevels(srcWidth, srcHeight);
  var targetMips = mipMaps;
  var dstWidth = srcWidth;
  var dstHeight = srcHeight;
  if ((typeof opt_generateMips === 'undefined' || opt_generateMips) &&
      o3djs.texture.canMakeMipsAndScale(format) &&
      mipMaps == 1 && maxMips > 1) {
    targetMips = maxMips;
  }

  // Check that all the bitmaps are the same size and make mips
  for (var ii = 0; ii < bitmaps.length; ++ii) {
    var bitmap = bitmaps[ii];
    if (bitmap.width != srcWidth ||
        bitmap.height != srcHeight ||
        bitmap.format != format ||
        bitmap.numMipmaps != mipMaps) {
      throw 'bitmaps must all be the same width, height, mips and format';
    }
    if (targetMips != mipMaps) {
      bitmap.generateMips(0, targetMips - 1);
    }
  }

  var levels = bitmap.numMipmaps > 1 ? bitmap.numMipmaps :
               o3djs.texture.computeNumLevels(dstWidth, dstHeight);
  var texture;
  if (bitmaps.length == 6 &&
      bitmaps[0].semantic != o3djs.base.o3d.Bitmap.SLICE) {
    if (srcWidth != srcHeight ||
        srcWidth != dstWidth ||
        srcHeight != dstHeight) {
      throw 'Cubemaps must be square';
    }
    texture = pack.createTextureCUBE(dstWidth, format, targetMips, false);
    for (var ii = 0; ii < 6; ++ii) {
      texture.setFromBitmap(
          /** @type {o3d.TextureCUBE.CubeFace} */ (ii),
          bitmaps[ii]);
    }
  } else if (bitmaps.length == 1) {
    texture = pack.createTexture2D(
        dstWidth, dstHeight, format, targetMips, false);
    texture.setFromBitmap(bitmaps[0]);
  }

  return /** @type{!o3d.Texture} */ (texture);
};

/**
 * Creates a TextureCUBE from 6 bitmaps. The bitmaps do not have to be the same
 * size thought they do have to be the same format.
 *
 * @param {!o3d.Pack} pack The pack to create the texture in.
 * @param {number} edgeLength The size of the cubemap.
 * @param {!Array.<!o3d.Bitmap>} bitmaps An array of 6 bitmaps in the order
 *     FACE_POSITIVE_X, FACE_NEGATIVE_X, FACE_POSITIVE_Y, FACE_NEGATIVE_Y,
 *     FACE_POSITIVE_Z, FACE_NEGATIVE_Z.
 * @return {!o3d.Texture} The created texture.
 */
o3djs.texture.createCubeTextureFrom6Bitmaps = function(
    pack, edgeLength, bitmaps) {
  var numMips = o3djs.texture.computeNumLevels(edgeLength, edgeLength);
  var texture = pack.createTextureCUBE(
      edgeLength, bitmaps[0].format, numMips, false);
  for (var ii = 0; ii < 6; ++ii) {
    var bitmap = bitmaps[ii];
    texture.drawImage(bitmap, 0, 0, 0, bitmap.width, bitmap.height,
                      ii, 0, 0, edgeLength, edgeLength);
  }
  texture.generateMips(0, numMips - 1);
  return texture;
};

