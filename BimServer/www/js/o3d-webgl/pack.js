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
 * A Pack object functions as a container for O3D objects. The Pack
 * is used to control the lifetime scope of a collection of objects in bulk. The
 * Pack object achieves this by simply storing a set of references to its
 * contained objects, which ensures that the ref-counts for those objects never
 * reach zero while the pack is alive.
 * @constructor
 */
o3d.Pack = function() {
  o3d.NamedObject.call(this);
  this.objects_ = [];
};
o3d.inherit('Pack', 'NamedObject');


/**
 * Removes all internal references to the Pack from the client.
 * The pack, and all objects contained in it are permitted to be destroyed
 * after the pack's destruction.  Objects will only be destroyed after all
 * references to them have been removed.
 *
 * NOTE: Calling pack.destroy does NOT free your resources. It justs releases
 * the pack's reference to those resources.  An example should hopefully make
 * it clearer.
 *
 * pack.destroy() is effectively almost the same as this.
 *
 * var objectsInPack = pack.getObjectsByClassName('o3d.ObjectBase');
 * for (var ii = 0; ii < objectsInPack.length; ++ii) {
 *   pack.removeObject(objectsInPack[ii]);
 * }
 *
 * The only difference is that after all the objects are removed the pack
 * itself will be released from the client.  See documentation on
 * pack.removeObject for why this is important.
 *
 * It's important to note that many objects are only referenced by the pack.
 * Textures, Effects, Materials, for example. That means the moment you call
 * pack.destroy() those objects will be freed. If the client then tries to
 * render and some objects are missing you'll immediately get an error.
 */
o3d.Pack.prototype.destroy = function() {
  this.objects_ = [];
  this.client.destroyPack(this);
};



/**
 * Removes a pack's reference to an object. Any object created from
 * pack.create___ function can be removed. This releases the pack's reference
 * to that object so if nothing else is referencing that object it will be
 * deleted.
 *
 * NOTE: Calling pack.removeObject does NOT automatically free your resource.
 * It just releases the pack's reference to that resource. An example should
 * hopefully make it clearer.
 *
 * Suppose you make a transform like this:
 *
 *
 * var myTransform = pack.createObject('Transform');
 * myTransform.parent = g_client.root;
 * pack.removeObject(myTransform);
 *
 *
 * In the code above, myTransform is referenced twice. Once by the pack, and
 * again by g_client.root  So in this case, calling pack.removeObject()
 * only releases the pack's reference leaving the reference by g_client.root.
 *
 *
 * myTransform.parent = null;
 *
 *
 * Now the last reference has been removed and myTransform will be freed.
 *
 * @param {o3d.ObjectBase} object Object to remove.
 * @return {boolean}  True if the object was successfully removed.
 *     False if the object is not part of this pack.
 */
o3d.Pack.prototype.removeObject =
    function(object) {
  o3d.removeFromArray(this.objects_, object);
};


/**
 * Creates an Object by Class name.
 *
 * Note: You may omit the 'o3d.'.
 *
 * @param {string} type_name name of Class to create. Valid type names are:
 *      Bitmap
 *      Canvas
 *      CanvasLinearGradient
 *      CanvasPaint
 *      ClearBuffer
 *      Counter
 *      Curve
 *      DrawContext
 *      DrawElement
 *      DrawList
 *      DrawPass
 *      Effect
 *      FunctionEval
 *      IndexBuffer
 *      Material
 *      ParamArray
 *      ParamObject
 *      Primitive
 *      RenderFrameCounter
 *      RenderNode
 *      RenderSurfaceSet
 *      Sampler
 *      SecondCounter
 *      Shape
 *      Skin
 *      SkinEval
 *      SourceBuffer
 *      State
 *      StateSet
 *      StreamBank
 *      Texture2D
 *      TextureCUBE
 *      TickCounter
 *      Transform
 *      TreeTraversal
 *      VertexBuffer
 *      Viewport
 *      Matrix4AxisRotation
 *      Matrix4Composition
 *      Matrix4Scale
 *      Matrix4Translation
 *      ParamOp2FloatsToFloat2
 *      ParamOp3FloatsToFloat3
 *      ParamOp4FloatsToFloat4
 *      ParamOp16FloatsToMatrix4
 *      TRSToMatrix4
 * @return {o3d.ObjectBase}  The created object.
 */
o3d.Pack.prototype.createObject =
    function(type_name) {
  var foo = o3d.global.o3d[o3d.filterTypeName_(type_name)];
  if (typeof foo != 'function') {
    throw 'cannot find type in o3d namespace: ' + type_name
  }
  var object = new foo();
  object.gl = this.gl;
  object.clientId = o3d.Client.nextId++;
  this.objects_.push(object);
  return object;
};


/**
 * Creates a new Texture2D object of the specified size and format and
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
o3d.Pack.prototype.createTexture2D =
    function(width, height, format, levels, enable_render_surfaces) {
  var texture = this.createObject('Texture2D');
  texture.init_(width, height, format, levels, enable_render_surfaces);
  return texture;
};


/**
 * Creates a new TextureCUBE object of the specified size and format and
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
 * @return {!o3d.TextureCUBE}  The TextureCUBE object.
 */
o3d.Pack.prototype.createTextureCUBE =
    function(edgeLength, format, levels, enableRenderSurfaces) {
  var textureCube = this.createObject('TextureCUBE');
  textureCube.init_(edgeLength, format, levels, enableRenderSurfaces);
  return textureCube;
};


/**
 * Creates a new RenderDepthStencilSurface object of a format suitable for use
 * as a depth-stencil render target.
 * Note: The dimensions of the RenderDepthStencilSurface must be a power of
 *     two.
 *
 * @param {number} width The width of the RenderSurface in pixels
 * @param {number} height The height of the RenderSurface in pixels
 * @return {!o3d.RenderDepthStencilSurface}  The RenderSurface object.
 */
o3d.Pack.prototype.createDepthStencilSurface =
    function(width, height) {
  var surface = this.createObject("RenderDepthStencilSurface");
  surface.initWithSize_(width, height);
  return surface;
};


/**
 * Search the pack for all objects of a certain class with a certain name.
 *
 * Note that modifications to this array [e.g. push()] will not affect
 * the underlying Pack, while modifications to the array's members
 * will affect them.
 *
 * @param {string} name Name to look for
 * @param {string} class_type_name the Class of the object. It is okay
 *     to pass base types for example "o3d.RenderNode" will return
 *     ClearBuffers, DrawPasses, etc...
 * @return {!Array.<!o3d.ObjectBase>}  Array of Objects.
 */
o3d.Pack.prototype.getObjects =
    function(name, class_type_name) {
  class_type_name = o3d.filterTypeName_(class_type_name);

  var found = [];

  for (var i = 0; i < this.objects_.length; ++i) {
    var object = this.objects_[i];
    if (object.isAClassName(class_type_name) &&
        object.name == name) {
      found.push(object);
    }
  }

  return found;
};


/**
 * Search the pack for all objects of a certain class
 *
 * Note that modifications to this array [e.g. push()] will not affect
 * the underlying Pack, while modifications to the array's members
 * will affect them.
 *
 * @param {string} class_type_name the Class of the object. It is
 *     okay to pass base types for example "o3d.RenderNode" will return
 *     ClearBuffers, DrawPasses, etc...
 * @return {!Array.<!o3d.ObjectBase>}  Array of Objects.
 */
o3d.Pack.prototype.getObjectsByClassName =
    function(class_type_name) {
  class_type_name = o3d.filterTypeName_(class_type_name);

  var found = [];

  for (var i = 0; i < this.objects_.length; ++i) {
    var object = this.objects_[i];
    if (object.isAClassName(class_type_name)) {
      found.push(object);
    }
  }

  return found;
};


/**
 * All the objects managed by this pack.
 *
 * Each access to this field gets the entire list so it is best to get it
 * just once. For example:
 *
 * var objects = pack.objects;
 * for (var i = 0; i < objects.length; i++) {
 *   var object = objects[i];
 * }
 *
 *
 * Note that modifications to this array [e.g. push()] will not affect
 * the underlying Pack, while modifications to the array's members
 * will affect them.
 */
o3d.Pack.prototype.objects_ = [];


/**
 * Creates a FileRequest to be used to asynchronously load a Texture or
 * RawData. Note: Loading a "TEXTURE" is deprecated. The recommended way to
 * load a texture is to load a RawData, use that to create Bitmap, Massage
 * the Bitmap to your liking the use that to create a Texture.
 * @param {string} type Must be "TEXTURE" or "RAWDATA"
 * @return {!o3d.FileRequest}  a FileRequest
 */
o3d.Pack.prototype.createFileRequest =
    function(type) {
  return this.createObject('FileRequest');
};

/**
 * Creates an ArchiveRequest so we can stream in assets from an archive.
 * @return {!o3d.ArchiveRequest}  an ArchiveRequest
 */
o3d.Pack.prototype.createArchiveRequest =
    function() {
  return this.createObject('ArchiveRequest');
};

/**
 * Create Bitmaps from RawData.
 *
 * If you load a cube map you'll get an array of 6 Bitmaps.
 * If you load a volume map you'll get an array of n Bitmaps.
 * If there is an error you'll get an empty array.
 *
 * @param {!o3d.RawData} raw_data contains the bitmap data in a supported
 *     format.
 * @return {!Array.<!o3d.Bitmap>}  An Array of Bitmaps object.
 */
o3d.Pack.prototype.createBitmapsFromRawData =
    function(raw_data) {
  var bitmap = this.createObject('Bitmap')
  if (!raw_data.image_) {
    throw ('Cannot create bitmap from non-image data.');
    return [];
  }
  bitmap.height = raw_data.image_.height;
  bitmap.width = raw_data.image_.width;

  var canvas = document.createElement('CANVAS');

  canvas.width = bitmap.width;
  canvas.height = bitmap.height;
  var context = canvas.getContext('2d');
  context.drawImage(raw_data.image_,
      0, 0, bitmap.width, bitmap.height);

  bitmap.canvas_ = canvas;
  // Most images require a vertical flip.
  bitmap.flipVerticallyLazily_();

  // TODO(petersont): Find out if any other formats are possible at this point.
  bitmap.format = o3d.Texture.ARGB8;
  bitmap.numMipmaps = 1;

  return [bitmap];
};


/**
 * Create RawData given a data URL.
 * @param {string} data_url The data URL from which to create the RawData.
 * @return {!o3d.RawData}  The RawData.
 */
o3d.Pack.prototype.createRawDataFromDataURL =
    function(data_url) {
  o3d.notImplemented();
};

