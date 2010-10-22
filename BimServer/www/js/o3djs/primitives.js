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
 * @fileoverview This file contains functions to create geometric primitives for
 * o3d.  It puts them in the "primitives" module on the o3djs object.
 *
 * For more information about o3d see http://code.google.com/p/o3d
 *
 *
 * Requires base.js
 */

o3djs.provide('o3djs.primitives');

o3djs.require('o3djs.math');

/**
 * A Module for creating primitives.
 * @namespace
 */
o3djs.primitives = o3djs.primitives || {};


/**
 * Sets the bounding box and zSortPoint for a primitive based on its vertices
 *
 * @param {!o3d.Primitive} primitive Primitive to set culling info for.
 */
o3djs.primitives.setCullingInfo = function(primitive) {
  var box = primitive.getBoundingBox(0);
  primitive.boundingBox = box;
  var minExtent = box.minExtent;
  var maxExtent = box.maxExtent;
  primitive.zSortPoint = o3djs.math.divVectorScalar(
      o3djs.math.addVector(minExtent, maxExtent), 2);
};

/**
 * Used to store the elements of a stream.
 * @param {number} numComponents The number of numerical components per
 *     element.
 * @param {!o3d.Stream.Semantic} semantic The semantic of the stream.
 * @param {number} opt_semanticIndex The semantic index of the stream.
 *     Defaults to zero.
 * @constructor
 */
o3djs.primitives.VertexStreamInfo = function(numComponents,
                                             semantic,
                                             opt_semanticIndex) {
  /**
   * The number of numerical components per element.
   * @type {number}
   */
  this.numComponents = numComponents;

  /**
   * The semantic of the stream.
   * @type {!o3d.Stream.Semantic}
   */
  this.semantic = semantic;

  /**
   * The semantic index of the stream.
   * @type {number}
   */
  this.semanticIndex = opt_semanticIndex || 0;

  /**
   * The elements of the stream.
   * @type {!Array.<number>}
   */
  this.elements = [];

  /**
   * Adds an element to this VertexStreamInfo. The number of values passed must
   * match the number of components for this VertexStreamInfo.
   * @param {number} value1 First value.
   * @param {number} opt_value2 Second value.
   * @param {number} opt_value3 Third value.
   * @param {number} opt_value4 Fourth value.
   */
  this.addElement = function(value1, opt_value2, opt_value3, opt_value4) { };

  /**
   * Sets an element on this VertexStreamInfo. The number of values passed must
   * match the number of components for this VertexStreamInfo.
   * @param {number} index Index of element to set.
   * @param {number} value1 First value.
   * @param {number} opt_value2 Second value.
   * @param {number} opt_value3 Third value.
   * @param {number} opt_value4 Fourth value.
   */
  this.setElement = function(
      index, value1, opt_value2, opt_value3, opt_value4) { };

  /**
   * Adds an element to this VertexStreamInfo. The number of values in the
   * vector must match the number of components for this VertexStreamInfo.
   * @param {!Array.<number>} vector Array of values for element.
   */
  this.addElementVector = function(vector) { };  // replaced below.

  /**
   * Sets an element on this VertexStreamInfo. The number of values in the
   * vector must match the number of components for this VertexStreamInfo.
   * @param {number} index Index of element to set.
   * @param {!Array.<number>} vector Array of values for element.
   */
  this.setElementVector = function(index, vector) { };  // replaced below.

  /**
   * Sets an element on this VertexStreamInfo. The number of values in the
   * vector will match the number of components for this VertexStreamInfo.
   * @param {number} index Index of element to set.
   * @return {!Array.<number>} Array of values for element.
   */
  this.getElementVector = function(index) { return []; };  // replaced below.

  switch (numComponents) {
    case 1:
      this.addElement = function(value) {
        this.elements.push(value);
      }
      this.getElement = function(index) {
        return this.elements[index];
      }
      this.setElement = function(index, value) {
        this.elements[index] = value;
      }
      break;
    case 2:
      this.addElement = function(value0, value1) {
        this.elements.push(value0, value1);
      }
      this.addElementVector = function(vector) {
        this.elements.push(vector[0], vector[1]);
      }
      this.getElementVector = function(index) {
        return this.elements.slice(index * numComponents,
                                   (index + 1) * numComponents);
      }
      this.setElement = function(index, value0, value1) {
        this.elements[index * numComponents + 0] = value0;
        this.elements[index * numComponents + 1] = value1;
      }
      this.setElementVector = function(index, vector) {
        this.elements[index * numComponents + 0] = vector[0];
        this.elements[index * numComponents + 1] = vector[1];
      }
      break;
    case 3:
      this.addElement = function(value0, value1, value2) {
        this.elements.push(value0, value1, value2);
      }
      this.addElementVector = function(vector) {
        this.elements.push(vector[0], vector[1], vector[2]);
      }
      this.getElementVector = function(index) {
        return this.elements.slice(index * numComponents,
                                   (index + 1) * numComponents);
      }
      this.setElement = function(index, value0, value1, value2) {
        this.elements[index * numComponents + 0] = value0;
        this.elements[index * numComponents + 1] = value1;
        this.elements[index * numComponents + 2] = value2;
      }
      this.setElementVector = function(index, vector) {
        this.elements[index * numComponents + 0] = vector[0];
        this.elements[index * numComponents + 1] = vector[1];
        this.elements[index * numComponents + 2] = vector[2];
      }
      break;
    case 4:
      this.addElement = function(value0, value1, value2, value3) {
        this.elements.push(value0, value1, value2, value3);
      }
      this.addElementVector = function(vector) {
        this.elements.push(vector[0], vector[1], vector[2], vector[3]);
      }
      this.getElementVector = function(index) {
        return this.elements.slice(index * numComponents,
                                   (index + 1) * numComponents);
      }
      this.setElement = function(index, value0, value1, value2, value3) {
        this.elements[index * numComponents + 0] = value0;
        this.elements[index * numComponents + 1] = value1;
        this.elements[index * numComponents + 2] = value2;
        this.elements[index * numComponents + 3] = value3;
      }
      this.setElementVector = function(index, vector) {
        this.elements[index * numComponents + 0] = vector[0];
        this.elements[index * numComponents + 1] = vector[1];
        this.elements[index * numComponents + 2] = vector[2];
        this.elements[index * numComponents + 3] = vector[3];
      }
      break;
    default:
      throw 'A stream must contain between 1 and 4 components';
  }
};

/**
 * Get the number of elements in the stream.
 * @return {number} The number of elements in the stream.
 */
o3djs.primitives.VertexStreamInfo.prototype.numElements = function() {
  return this.elements.length / this.numComponents;
};

/**
 * Create a VertexStreamInfo.
 * @param {number} numComponents The number of numerical components per
 *     element.
 * @param {!o3d.Stream.Semantic} semantic The semantic of the stream.
 * @param {number} opt_semanticIndex The semantic index of the stream.
 *     Defaults to zero.
 * @return {!o3djs.primitives.VertexStreamInfo} The new stream.
 */
o3djs.primitives.createVertexStreamInfo = function(numComponents,
                                                   semantic,
                                                   opt_semanticIndex) {
  return new o3djs.primitives.VertexStreamInfo(numComponents,
                                               semantic,
                                               opt_semanticIndex);
};

/**
 * VertexInfoBase. Used to store vertices and indices.
 * @constructor
 */
o3djs.primitives.VertexInfoBase = function() {
  this.streams = [];
  this.indices = [];
};

/**
 * Add a new stream to the VertexInfo, replacing it with a new empty one
 *     if it already exists.
 * @param {number} numComponents The number of components per vector.
 * @param {!o3d.Stream.Semantic} semantic The semantic of the stream.
 * @param {number} opt_semanticIndex The semantic index of the stream.
 *     Defaults to zero.
 * @return {!o3djs.primitives.VertexStreamInfo} The new stream.
 */
o3djs.primitives.VertexInfoBase.prototype.addStream = function(
    numComponents,
    semantic,
    opt_semanticIndex) {
  this.removeStream(semantic, opt_semanticIndex);
  var stream = o3djs.primitives.createVertexStreamInfo(
      numComponents,
      semantic,
      opt_semanticIndex);
  this.streams.push(stream);
  return stream;
};

/**
 * Find a stream in the VertexInfo.
 * @param {!o3d.Stream.Semantic} semantic The semantic of the stream.
 * @param {number} opt_semanticIndex The semantic index of the stream.
 *     Defaults to zero.
 * @return {o3djs.primitives.VertexStreamInfo} The stream or null if it
 *     is not present.
 */
o3djs.primitives.VertexInfoBase.prototype.findStream = function(
    semantic,
    opt_semanticIndex) {
  opt_semanticIndex = opt_semanticIndex || 0;
  for (var i = 0; i < this.streams.length; ++i) {
    if (this.streams[i].semantic === semantic &&
        this.streams[i].semanticIndex == opt_semanticIndex) {
      return this.streams[i];
    }
  }
  return null;
};

/**
 * Remove a stream from the VertexInfo. Does nothing if a matching stream
 * does not exist.
 * @param {!o3d.Stream.Semantic} semantic The semantic of the stream.
 * @param {number} opt_semanticIndex The semantic index of the stream.
 *     Defaults to zero.
 */
o3djs.primitives.VertexInfoBase.prototype.removeStream = function(
    semantic,
    opt_semanticIndex) {
  opt_semanticIndex = opt_semanticIndex || 0;
  for (var i = 0; i < this.streams.length; ++i) {
    if (this.streams[i].semantic === semantic &&
        this.streams[i].semanticIndex == opt_semanticIndex) {
      this.streams.splice(i, 1);
      return;
    }
  }
};

/**
 * Appends all of the information in the passed VertexInfo on to the
 * end of this one. This is useful for putting multiple primitives'
 * vertices, appropriately transformed, into a single Shape. Both
 * VertexInfo objects must contain the same number of streams, with
 * the same semantics and number of components.
 * @param {!o3djs.primitives.VertexInfoBase} info The VertexInfo whose
 *     information should be appended to this one.
 */
o3djs.primitives.VertexInfoBase.prototype.append = function(info) {
  if (this.streams.length == 0 && info.streams.length != 0) {
    // Special case
    for (var i = 0; i < info.streams.length; i++) {
      var srcStream = info.streams[i];
      var stream = this.addStream(srcStream.numComponents,
                                  srcStream.semantic,
                                  srcStream.semanticIndex);
      stream.elements = stream.elements.concat(srcStream.elements);
    }
    this.indices = this.indices.concat(info.indices);
    return;
  }

  // First verify that both have the same streams
  if (this.streams.length != info.streams.length) {
    throw 'Number of VertexInfoStreams did not match';
  }
  for (var i = 0; i < this.streams.length; i++) {
    var found = false;
    var semantic = this.streams[i].semantic;
    var numComponents = this.streams[i].numComponents;
    var semanticIndex = this.streams[i].semanticIndex;
    for (var j = 0; j < info.streams.length; j++) {
      var otherStream = info.streams[j];
      if (otherStream.semantic === semantic &&
          otherStream.numComponents == numComponents &&
          otherStream.semanticIndex == semanticIndex) {
        found = true;
        break;
      }
    }
    if (!found) {
      throw 'Did not find stream with semantic=' + semantic +
        ', numComponents=' + numComponents +
        ', and semantic index=' + semanticIndex +
        ' in given VertexInfo';
    }
  }

  // Compute the number of vertices currently in the shape
  var positionStream = this.findStream(o3djs.base.o3d.Stream.POSITION);
  if (!positionStream)
    throw 'POSITION stream is missing';
  var numVertices = positionStream.numElements();

  // Concatenate all VertexStreamInfos' data
  for (var i = 0; i < this.streams.length; i++) {
    var stream = this.streams[i];
    var srcStream = info.findStream(stream.semantic, stream.semanticIndex);
    stream.elements = stream.elements.concat(srcStream.elements);
  }

  // Concatenate and adjust indices
  for (var i = 0; i < info.indices.length; i++) {
    this.indices.push(info.indices[i] + numVertices);
  }
};

/**
 * Validates that all the streams contain the same number of elements, that
 * all the indices are within range and that a position stream is present.
 */
o3djs.primitives.VertexInfoBase.prototype.validate = function() {
  // Check the position stream is present.
  var positionStream = this.findStream(o3djs.base.o3d.Stream.POSITION);
  if (!positionStream)
    throw 'POSITION stream is missing';

  // Check all the streams have the same number of elements.
  var numElements = positionStream.numElements();
  for (var s = 0; s < this.streams.length; ++s) {
    if (this.streams[s].numElements() !== numElements) {
      throw 'Stream ' + s + ' contains ' + this.streams[s].numElements() +
          ' elements whereas the POSITION stream contains ' + numElements;
    }
  }

  // Check all the indices are in range.
  for (var i = 0; i < this.indices.length; ++i) {
    if (this.indices[i] < 0 || this.indices[i] >= numElements) {
      throw 'The index ' + this.indices[i] + ' is out of range [0, ' +
        numElements + ']';
    }
  }
};

/**
 * Reorients the vertices, positions and normals, of this vertexInfo by the
 * given matrix. In other words, it multiplies each vertex by the given matrix
 * and each normal by the inverse-transpose of the given matrix.
 * @param {!o3djs.math.Matrix4} matrix Matrix by which to multiply.
 */
o3djs.primitives.VertexInfoBase.prototype.reorient = function(matrix) {
  var math = o3djs.math;
  var matrixInverse = math.inverse(math.matrix4.getUpper3x3(matrix));

  for (var s = 0; s < this.streams.length; ++s) {
    var stream = this.streams[s];
    if (stream.numComponents == 3) {
      var numElements = stream.numElements();
      switch (stream.semantic) {
        case o3djs.base.o3d.Stream.POSITION:
          for (var i = 0; i < numElements; ++i) {
            stream.setElementVector(i,
                math.matrix4.transformPoint(matrix,
                    stream.getElementVector(i)));
          }
          break;
        case o3djs.base.o3d.Stream.NORMAL:
          for (var i = 0; i < numElements; ++i) {
            stream.setElementVector(i,
                math.matrix4.transformNormal(matrix,
                    stream.getElementVector(i)));
          }
          break;
        case o3djs.base.o3d.Stream.TANGENT:
        case o3djs.base.o3d.Stream.BINORMAL:
          for (var i = 0; i < numElements; ++i) {
            stream.setElementVector(i,
                math.matrix4.transformDirection(matrix,
                    stream.getElementVector(i)));
          }
          break;
      }
    }
  }
};

/**
 * Creates a shape from a VertexInfoBase
 * @param {!o3d.Pack} pack Pack to create objects in.
 * @param {!o3d.Material} material to use.
 * @param {!o3d.Primitive.PrimitiveType} primitiveType The type of primitive.
 * @return {!o3d.Shape} The created shape.
 */
o3djs.primitives.VertexInfoBase.prototype.createShapeByType = function(
    pack,
    material,
    primitiveType) {
  this.validate();

  var numIndices = this.indices.length;
  var numPrimitives;
  switch (primitiveType) {
    case o3djs.base.o3d.Primitive.POINTLIST:
      numPrimitives = numIndices / 1;
      break;
    case o3djs.base.o3d.Primitive.LINELIST:
      numPrimitives = numIndices / 2;
      break;
    case o3djs.base.o3d.Primitive.LINESTRIP:
      numPrimitives = numIndices - 1;
      break;
    case o3djs.base.o3d.Primitive.TRIANGLELIST:
      numPrimitives = numIndices / 3;
      break;
    case o3djs.base.o3d.Primitive.TRIANGLESTRIP:
    case o3djs.base.o3d.Primitive.TRIANGLEFAN:
      numPrimitives = numIndices - 2;
      break;
    default:
      throw 'unknown primitive type';
  }

  var positionStream = this.findStream(o3djs.base.o3d.Stream.POSITION);
  var numVertices = positionStream.numElements();

  // create a shape and primitive for the vertices.
  var shape = pack.createObject('Shape');
  var primitive = pack.createObject('Primitive');
  var streamBank = pack.createObject('StreamBank');
  primitive.owner = shape;
  primitive.streamBank = streamBank;
  primitive.material = material;
  primitive.numberPrimitives = numPrimitives;
  primitive.primitiveType = primitiveType;
  primitive.numberVertices = numVertices;
  primitive.createDrawElement(pack, null);

  // Calculate the tangent and binormal or provide defaults or fail if the
  // effect requires either and they are not present.
  var streamInfos = material.effect.getStreamInfo();
  for (var s = 0; s < streamInfos.length; ++s) {
    var semantic = streamInfos[s].semantic;
    var semanticIndex = streamInfos[s].semanticIndex;

    var requiredStream = this.findStream(semantic, semanticIndex);
    if (!requiredStream) {
      switch (semantic) {
        case o3djs.base.o3d.Stream.TANGENT:
        case o3djs.base.o3d.Stream.BINORMAL:
          if (primitiveType == o3djs.base.o3d.Primitive.TRIANGLELIST) {
            this.addTangentStreams(semanticIndex);
          } else {
            throw 'Can not create tangents and binormals for primitive type' +
                primitiveType;
          }
          break;
        case o3djs.base.o3d.Stream.COLOR:
          requiredStream = this.addStream(4, semantic, semanticIndex);
          for (var i = 0; i < numVertices; ++i) {
            requiredStream.addElement(1, 1, 1, 1);
          }
          break;
        case o3djs.base.o3d.Stream.INFLUENCE_WEIGHTS:
        case o3djs.base.o3d.Stream.INFLUENCE_INDICES:
          break;
        default:
          throw 'Missing stream for semantic ' + semantic +
              ' with semantic index ' + semanticIndex;
      }
    }
  }

  // These next few lines take our javascript streams and load them into a
  // 'buffer' where the 3D hardware can find them. We have to do this
  // because the 3D hardware can't 'see' javascript data until we copy it to
  // a buffer.
  var vertexBuffer = pack.createObject('VertexBuffer');
  var fields = [];
  for (var s = 0; s < this.streams.length; ++s) {
    var stream = this.streams[s];
    var fieldType = (stream.semantic == o3djs.base.o3d.Stream.COLOR &&
                     stream.numComponents == 4) ? 'UByteNField' : 'FloatField';
    fields[s] = vertexBuffer.createField(fieldType, stream.numComponents);
    streamBank.setVertexStream(stream.semantic,
                               stream.semanticIndex,
                               fields[s],
                               0);
  }
  vertexBuffer.allocateElements(numVertices);
  for (var s = 0; s < this.streams.length; ++s) {
    fields[s].setAt(0, this.streams[s].elements);
  }

  var indexBuffer = pack.createObject('IndexBuffer');
  indexBuffer.set(this.indices);
  primitive.indexBuffer = indexBuffer;
  o3djs.primitives.setCullingInfo(primitive);
  return shape;
};

/**
 * A VertexInfo is a specialization of VertexInfoBase for triangle based
 * geometry.
 * @constructor
 * @extends {o3djs.primitives.VertexInfoBase}
 */
o3djs.primitives.VertexInfo = function() {
  o3djs.primitives.VertexInfoBase.call(this);
}

o3djs.base.inherit(o3djs.primitives.VertexInfo,
                   o3djs.primitives.VertexInfoBase);

/**
 * Returns the number of triangles represented by the VertexInfo.
 * @return {number} The number of triangles represented by VertexInfo.
 */
o3djs.primitives.VertexInfo.prototype.numTriangles = function() {
  return this.indices.length / 3;
};

/**
 * Adds a triangle.
 * @param {number} index1 The index of the first vertex of the triangle.
 * @param {number} index2 The index of the second vertex of the triangle.
 * @param {number} index3 The index of the third vertex of the triangle.
 */
o3djs.primitives.VertexInfo.prototype.addTriangle = function(
    index1, index2, index3) {
  this.indices.push(index1, index2, index3);
};

/**
 * Gets the vertex indices of the triangle at the given triangle index.
 * @param {number} triangleIndex The index of the triangle.
 * @return {!Array.<number>} An array of three triangle indices.
 */
o3djs.primitives.VertexInfo.prototype.getTriangle = function(
    triangleIndex) {
  var indexIndex = triangleIndex * 3;
  return [this.indices[indexIndex + 0],
          this.indices[indexIndex + 1],
          this.indices[indexIndex + 2]];
};

/**
 * Sets the vertex indices of the triangle at the given triangle index.
 * @param {number} triangleIndex The index of the triangle.
 * @param {number} index1 The index of the first vertex of the triangle.
 * @param {number} index2 The index of the second vertex of the triangle.
 * @param {number} index3 The index of the third vertex of the triangle.
 */
o3djs.primitives.VertexInfo.prototype.setTriangle = function(
    triangleIndex, index1, index2, index3) {
  var indexIndex = triangleIndex * 3;
  this.indices[indexIndex + 0] = index1;
  this.indices[indexIndex + 1] = index2;
  this.indices[indexIndex + 2] = index3;
};

/**
 * Creates a shape from a VertexInfo
 * @param {!o3d.Pack} pack Pack to create objects in.
 * @param {!o3d.Material} material to use.
 * @return {!o3d.Shape} The created shape.
 */
o3djs.primitives.VertexInfo.prototype.createShape = function(
    pack,
    material) {
  return this.createShapeByType(
      pack, material, o3djs.base.o3d.Primitive.TRIANGLELIST);
};

/**
 * Calculate tangents and binormals based on the positions, normals and
 *     texture coordinates found in existing streams.
 * @param {number} opt_semanticIndex The semantic index of the texture
 *     coordinate to use and the tangent and binormal streams to add. Defaults
 *     to zero.
 */
o3djs.primitives.VertexInfo.prototype.addTangentStreams =
    function(opt_semanticIndex) {
  opt_semanticIndex = opt_semanticIndex || 0;
  var math = o3djs.math;

  this.validate();

  // Find and validate the position, normal and texture coordinate frames.
  var positionStream = this.findStream(o3djs.base.o3d.Stream.POSITION);
  if (!positionStream)
    throw 'Cannot calculate tangent frame because POSITION stream is missing';
  if (positionStream.numComponents != 3)
    throw 'Cannot calculate tangent frame because POSITION stream is not 3D';

  var normalStream = this.findStream(o3djs.base.o3d.Stream.NORMAL);
  if (!normalStream)
    throw 'Cannot calculate tangent frame because NORMAL stream is missing';
  if (normalStream.numComponents != 3)
    throw 'Cannot calculate tangent frame because NORMAL stream is not 3D';

  var texCoordStream = this.findStream(o3djs.base.o3d.Stream.TEXCOORD,
                                       opt_semanticIndex);
  if (!texCoordStream)
    throw 'Cannot calculate tangent frame because TEXCOORD stream ' +
        opt_semanticIndex + ' is missing';

  // Maps from position, normal key to tangent and binormal matrix.
  var tangentFrames = {};

  // Rounds a vector to integer components.
  function roundVector(v) {
    return [Math.round(v[0]), Math.round(v[1]), Math.round(v[2])];
  }

  // Generates a key for the tangentFrames map from a position and normal
  // vector. Rounds position and normal to allow some tolerance.
  function tangentFrameKey(position, normal) {
    return roundVector(math.mulVectorScalar(position, 100)) + ',' +
        roundVector(math.mulVectorScalar(normal, 100));
  }

  // Accumulates into the tangent and binormal matrix at the approximate
  // position and normal.
  function addTangentFrame(position, normal, tangent, binormal) {
    var key = tangentFrameKey(position, normal);
    var frame = tangentFrames[key];
    if (!frame) {
      frame = [[0, 0, 0], [0, 0, 0]];
    }
    frame = math.addMatrix(frame, [tangent, binormal]);
    tangentFrames[key] = frame;
  }

  // Get the tangent and binormal matrix at the approximate position and
  // normal.
  function getTangentFrame(position, normal) {
    var key = tangentFrameKey(position, normal);
    return tangentFrames[key];
  }

  var numTriangles = this.numTriangles();
  for (var triangleIndex = 0; triangleIndex < numTriangles; ++triangleIndex) {
    // Get the vertex indices, uvs and positions for the triangle.
    var vertexIndices = this.getTriangle(triangleIndex);
    var uvs = [];
    var positions = [];
    var normals = [];
    for (var i = 0; i < 3; ++i) {
      var vertexIndex = vertexIndices[i];
      uvs[i] = texCoordStream.getElementVector(vertexIndex);
      positions[i] = positionStream.getElementVector(vertexIndex);
      normals[i] = normalStream.getElementVector(vertexIndex);
    }

    // Calculate the tangent and binormal for the triangle using method
    // described in Maya documentation appendix A: tangent and binormal
    // vectors.
    var tangent = [0, 0, 0];
    var binormal = [0, 0, 0];
    for (var axis = 0; axis < 3; ++axis) {
      var edge1 = [positions[1][axis] - positions[0][axis],
                   uvs[1][0] - uvs[0][0], uvs[1][1] - uvs[0][1]];
      var edge2 = [positions[2][axis] - positions[0][axis],
                   uvs[2][0] - uvs[0][0], uvs[2][1] - uvs[0][1]];
      var edgeCross = math.normalize(math.cross(edge1, edge2));
      if (edgeCross[0] == 0) {
        edgeCross[0] = 1;
      }
      tangent[axis] = -edgeCross[1] / edgeCross[0];
      binormal[axis] = -edgeCross[2] / edgeCross[0];
    }

    // Normalize the tangent and binornmal.
    var tangentLength = math.length(tangent);
    if (tangentLength > 0.001) {
      tangent = math.mulVectorScalar(tangent, 1 / tangentLength);
    }
    var binormalLength = math.length(binormal);
    if (binormalLength > 0.001) {
      binormal = math.mulVectorScalar(binormal, 1 / binormalLength);
    }

    // Accumulate the tangent and binormal into the tangent frame map.
    for (var i = 0; i < 3; ++i) {
      addTangentFrame(positions[i], normals[i], tangent, binormal);
    }
  }

  // Add the tangent and binormal streams.
  var tangentStream = this.addStream(3,
                                     o3djs.base.o3d.Stream.TANGENT,
                                     opt_semanticIndex);
  var binormalStream = this.addStream(3,
                                      o3djs.base.o3d.Stream.BINORMAL,
                                      opt_semanticIndex);

  // Extract the tangent and binormal for each vertex.
  var numVertices = positionStream.numElements();
  for (var vertexIndex = 0; vertexIndex < numVertices; ++vertexIndex) {
    var position = positionStream.getElementVector(vertexIndex);
    var normal = normalStream.getElementVector(vertexIndex);
    var frame = getTangentFrame(position, normal);

    // Orthonormalize the tangent with respect to the normal.
    var tangent = frame[0];
    tangent = math.subVector(
        tangent, math.mulVectorScalar(normal, math.dot(normal, tangent)));
    var tangentLength = math.length(tangent);
    if (tangentLength > 0.001) {
      tangent = math.mulVectorScalar(tangent, 1 / tangentLength);
    }

    // Orthonormalize the binormal with respect to the normal and the tangent.
    var binormal = frame[1];
    binormal = math.subVector(
        binormal, math.mulVectorScalar(tangent, math.dot(tangent, binormal)));
    binormal = math.subVector(
        binormal, math.mulVectorScalar(normal, math.dot(normal, binormal)));
    var binormalLength = math.length(binormal);
    if (binormalLength > 0.001) {
      binormal = math.mulVectorScalar(binormal, 1 / binormalLength);
    }

    tangentStream.setElementVector(vertexIndex, tangent);
    binormalStream.setElementVector(vertexIndex, binormal);
  }
};

/**
 * Creates a new VertexInfo.
 * @return {!o3djs.primitives.VertexInfo} The new VertexInfo.
 */
o3djs.primitives.createVertexInfo = function() {
  return new o3djs.primitives.VertexInfo();
};

/**
 * Creates sphere vertices.
 * The created sphere has position, normal and uv streams.
 *
 * @param {number} radius radius of the sphere.
 * @param {number} subdivisionsAxis number of steps around the sphere.
 * @param {number} subdivisionsHeight number of vertically on the sphere.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3djs.primitives.VertexInfo} The created sphere vertices.
 */
o3djs.primitives.createSphereVertices = function(radius,
                                                 subdivisionsAxis,
                                                 subdivisionsHeight,
                                                 opt_matrix) {
  if (subdivisionsAxis <= 0 || subdivisionsHeight <= 0) {
    throw Error('subdivisionAxis and subdivisionHeight must be > 0');
  }

  // We are going to generate our sphere by iterating through its
  // spherical coordinates and generating 2 triangles for each quad on a
  // ring of the sphere.

  var vertexInfo = o3djs.primitives.createVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);
  var normalStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.NORMAL);
  var texCoordStream = vertexInfo.addStream(
      2, o3djs.base.o3d.Stream.TEXCOORD, 0);

  // Generate the individual vertices in our vertex buffer.
  for (var y = 0; y <= subdivisionsHeight; y++) {
    for (var x = 0; x <= subdivisionsAxis; x++) {
      // Generate a vertex based on its spherical coordinates
      var u = x / subdivisionsAxis;
      var v = y / subdivisionsHeight;
      var theta = 2 * Math.PI * u;
      var phi = Math.PI * v;
      var sinTheta = Math.sin(theta);
      var cosTheta = Math.cos(theta);
      var sinPhi = Math.sin(phi);
      var cosPhi = Math.cos(phi);
      var ux = cosTheta * sinPhi;
      var uy = cosPhi;
      var uz = sinTheta * sinPhi;
      positionStream.addElement(radius * ux, radius * uy, radius * uz);
      normalStream.addElement(ux, uy, uz);
      texCoordStream.addElement(1 - u, 1 - v);
    }
  }
  var numVertsAround = subdivisionsAxis + 1;

  for (var x = 0; x < subdivisionsAxis; x++) {
    for (var y = 0; y < subdivisionsHeight; y++) {
      // Make triangle 1 of quad.
      vertexInfo.addTriangle(
          (y + 0) * numVertsAround + x,
          (y + 0) * numVertsAround + x + 1,
          (y + 1) * numVertsAround + x);

      // Make triangle 2 of quad.
      vertexInfo.addTriangle(
          (y + 1) * numVertsAround + x,
          (y + 0) * numVertsAround + x + 1,
          (y + 1) * numVertsAround + x + 1);
    }
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a sphere.
 * The created sphere has position, normal and uv streams.
 *
 * @param {!o3d.Pack} pack Pack to create sphere elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} radius radius of the sphere.
 * @param {number} subdivisionsAxis number of steps around the sphere.
 * @param {number} subdivisionsHeight number of vertically on the sphere.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created sphere.
 *
 * @see o3d.Pack
 * @see o3d.Shape
 */
o3djs.primitives.createSphere = function(pack,
                                         material,
                                         radius,
                                         subdivisionsAxis,
                                         subdivisionsHeight,
                                         opt_matrix) {
  var vertexInfo = o3djs.primitives.createSphereVertices(
      radius,
      subdivisionsAxis,
      subdivisionsHeight,
      opt_matrix);

  return vertexInfo.createShape(pack, material);
};

/**
 * Array of the indices of corners of each face of a cube.
 * @private
 * @type {!Array.<!Array.<number>>}
 */
o3djs.primitives.CUBE_FACE_INDICES_ = [
  [3, 7, 5, 1],
  [0, 4, 6, 2],
  [6, 7, 3, 2],
  [0, 1, 5, 4],
  [5, 7, 6, 4],
  [2, 3, 1, 0]
];

/**
 * Creates the vertices and indices for a cube. The
 * cube will be created around the origin. (-size / 2, size / 2)
 * The created cube has position, normal and uv streams.
 *
 * @param {number} size Width, height and depth of the cube.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3djs.primitives.VertexInfo} The created cube vertices.
 */
o3djs.primitives.createCubeVertices = function(size, opt_matrix) {
  var k = size / 2;

  var cornerVertices = [
    [-k, -k, -k],
    [+k, -k, -k],
    [-k, +k, -k],
    [+k, +k, -k],
    [-k, -k, +k],
    [+k, -k, +k],
    [-k, +k, +k],
    [+k, +k, +k]
  ];

  var faceNormals = [
    [+1, +0, +0],
    [-1, +0, +0],
    [+0, +1, +0],
    [+0, -1, +0],
    [+0, +0, +1],
    [+0, +0, -1]
  ];

  var uvCoords = [
    [0, 0],
    [1, 0],
    [1, 1],
    [0, 1]
  ];

  var vertexInfo = o3djs.primitives.createVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);
  var normalStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.NORMAL);
  var texCoordStream = vertexInfo.addStream(
      2, o3djs.base.o3d.Stream.TEXCOORD, 0);

  for (var f = 0; f < 6; ++f) {
    var faceIndices = o3djs.primitives.CUBE_FACE_INDICES_[f];
    for (var v = 0; v < 4; ++v) {
      var position = cornerVertices[faceIndices[v]];
      var normal = faceNormals[f];
      var uv = uvCoords[v];

      // Each face needs all four vertices because the normals and texture
      // coordinates are not all the same.
      positionStream.addElementVector(position);
      normalStream.addElementVector(normal);
      texCoordStream.addElementVector(uv);

      // Two triangles make a square face.
      var offset = 4 * f;
      vertexInfo.addTriangle(offset + 0, offset + 1, offset + 2);
      vertexInfo.addTriangle(offset + 0, offset + 2, offset + 3);
    }
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a cube.
 * The cube will be created around the origin. (-size / 2, size / 2)
 * The created cube has position, normal and uv streams.
 *
 * @param {!o3d.Pack} pack Pack to create cube elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} size Width, height and depth of the cube.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created cube.
 *
 * @see o3d.Pack
 * @see o3d.Shape
 */
o3djs.primitives.createCube = function(pack,
                                       material,
                                       size,
                                       opt_matrix) {
  var vertexInfo = o3djs.primitives.createCubeVertices(size, opt_matrix);
  return vertexInfo.createShape(pack, material);
};

/**
 * Creates a box. The box will be created around the origin.
 * The created box has position, normal and uv streams.
 *
 * @param {!o3d.Pack} pack Pack to create Box elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} width Width of the box.
 * @param {number} height Height of the box.
 * @param {number} depth Depth of the box.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created Box.
 *
 * @see o3d.Pack
 * @see o3d.Shape
 */
o3djs.primitives.createBox = function(pack,
                                      material,
                                      width,
                                      height,
                                      depth,
                                      opt_matrix) {
  var vertexInfo = o3djs.primitives.createCubeVertices(1);
  vertexInfo.reorient([[width, 0, 0, 0],
                       [0, height, 0, 0],
                       [0, 0, depth, 0],
                       [0, 0, 0, 1]]);

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo.createShape(pack, material);
};

/**
 * Creates a cube with varying vertex colors. The cube will be created
 * around the origin. (-size / 2, size / 2)
 *
 * @param {!o3d.Pack} pack Pack to create cube elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} size Width, height and depth of the cube.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created cube.
 *
 * @see o3d.Pack
 * @see o3d.Shape
 */
o3djs.primitives.createRainbowCube = function(pack,
                                              material,
                                              size,
                                              opt_matrix) {
  var vertexInfo = o3djs.primitives.createCubeVertices(size, opt_matrix);
  var colorStream = vertexInfo.addStream(
      4, o3djs.base.o3d.Stream.COLOR);

  var colors = [
    [1, 0, 0, 1],
    [0, 1, 0, 1],
    [0, 0, 1, 1],
    [1, 1, 0, 1],
    [0, 1, 1, 1],
    [1, 0, 1, 1],
    [0, .5, .3, 1],
    [.3, 0, .5, 1]
  ];

  var vertices = vertexInfo.vertices;
  for (var f = 0; f < 6; ++f) {
    var faceIndices = o3djs.primitives.CUBE_FACE_INDICES_[f];
    for (var v = 0; v < 4; ++v) {
      var color = colors[faceIndices[v]];
      colorStream.addElementVector(color);
    }
  }

  return vertexInfo.createShape(pack, material);
};

/**
 * Creates disc vertices. The disc will be in the xz plane, centered
 * at the origin. When creating, at least 3 divisions, or pie pieces, need
 * to be specified, otherwise the triangles making up the disc will be
 * degenerate. You can also specify the number of radial pieces (opt_stacks).
 * A value of 1 for opt_stacks will give you a simple disc of pie pieces.  If
 * you want to create an annulus by omitting some of the center stacks, you
 * can specify the stack at which to start creating triangles.  Finally,
 * stackPower allows you to have the widths increase or decrease as you move
 * away from the center. This is particularly useful when using the disc as a
 * ground plane with a fixed camera such that you don't need the resolution of
 * small triangles near the perimeter.  For example, a value of 2 will produce
 * stacks whose ouside radius increases with the square of the stack index. A
 * value of 1 will give uniform stacks.
 *
 * @param {number} radius Radius of the ground plane.
 * @param {number} divisions Number of triangles in the ground plane
 *                 (at least 3).
 * @param {number} opt_stacks Number of radial divisions (default=1).
 * @param {number} opt_startStack Which radial division to start dividing at.
 * @param {number} opt_stackPower Power to raise stack size to for decreasing
 *                 width.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3djs.primitives.VertexInfo} The created plane vertices.
 */
o3djs.primitives.createDiscVertices = function(radius,
                                               divisions,
                                               opt_stacks,
                                               opt_startStack,
                                               opt_stackPower,
                                               opt_matrix) {
  if (divisions < 3) {
    throw Error('divisions must be at least 3');
  }

  var stacks = opt_stacks ? opt_stacks : 1;
  var startStack = opt_startStack ? opt_startStack : 0;
  var stackPower = opt_stackPower ? opt_stackPower : 1;

  var vertexInfo = o3djs.primitives.createVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);
  var normalStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.NORMAL);
  var texCoordStream = vertexInfo.addStream(
      2, o3djs.base.o3d.Stream.TEXCOORD, 0);

  // Initialize the center vertex.
  // x  y  z nx ny nz  r  g  b  a  u  v
  var firstIndex = 0;

  if (startStack == 0) {
    positionStream.addElement(0, 0, 0);
    normalStream.addElement(0, 1, 0);
    texCoordStream.addElement(0, 0);
    firstIndex++;
  }

  // Build the disk one stack at a time.
  for (var currentStack = Math.max(startStack, 1);
       currentStack <= stacks;
       ++currentStack) {
    var stackRadius = radius * Math.pow(currentStack / stacks, stackPower);

    for (var i = 0; i < divisions; ++i) {
      var theta = 2.0 * Math.PI * i / divisions;
      var x = stackRadius * Math.cos(theta);
      var z = stackRadius * Math.sin(theta);

      positionStream.addElement(x, 0, z);
      normalStream.addElement(0, 1, 0);
      texCoordStream.addElement(x, z);

      if (currentStack > startStack) {
        // a, b, c and d are the indices of the vertices of a quad.  unless
        // the current stack is the one closest to the center, in which case
        // the vertices a and b connect to the center vertex.
        var a = firstIndex + (i + 1) % divisions;
        var b = firstIndex + i;
        if (currentStack > 1) {
          var c = firstIndex + i - divisions;
          var d = firstIndex + (i + 1) % divisions - divisions;

          // Make a quad of the vertices a, b, c, d.
          vertexInfo.addTriangle(a, b, c);
          vertexInfo.addTriangle(a, c, d);
        } else {
          // Make a single triangle of a, b and the center.
          vertexInfo.addTriangle(0, a, b);
        }
      }
    }

    firstIndex += divisions;
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a disc shape. The disc will be in the xz plane, centered
 * at the origin. When creating, at least 3 divisions, or pie pieces, need
 * to be specified, otherwise the triangles making up the disc will be
 * degenerate. You can also specify the number of radial pieces (opt_stacks).
 * A value of 1 for opt_stacks will give you a simple disc of pie pieces.  If
 * you want to create an annulus by omitting some of the center stacks, you
 * can specify the stack at which to start creating triangles.  Finally,
 * stackPower allows you to have the widths increase or decrease as you move
 * away from the center. This is particularly useful when using the disc as a
 * ground plane with a fixed camera such that you don't need the resolution of
 * small triangles near the perimeter.  For example, a value of 2 will produce
 * stacks whose ouside radius increases with the square of the stack index. A
 * value of 1 will give uniform stacks.
 *
 * @param {!o3d.Pack} pack Pack to create disc elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} radius Radius of the disc.
 * @param {number} divisions Number of triangles in the disc (at least 3).
 * @param {number} stacks Number of radial divisions.
 * @param {number} startStack Which radial division to start dividing at.
 * @param {number} stackPower Power to raise stack size to for decreasing width.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created disc.
 *
 * @see o3d.Pack
 * @see o3d.Shape
 */
o3djs.primitives.createDisc = function(pack, material,
                                       radius, divisions, stacks,
                                       startStack, stackPower,
                                       opt_matrix) {
  var vertexInfo = o3djs.primitives.createDiscVertices(radius, divisions,
                                                       stacks,
                                                       startStack,
                                                       stackPower,
                                                       opt_matrix);

  return vertexInfo.createShape(pack, material);
};

/**
 * Creates cylinder vertices. The cylinder will be created around the origin
 * along the y-axis. The created cylinder has position, normal and uv streams.
 *
 * @param {number} radius Radius of cylinder.
 * @param {number} height Height of cylinder.
 * @param {number} radialSubdivisions The number of subdivisions around the
 *     cylinder.
 * @param {number} verticalSubdivisions The number of subdivisions down the
 *     cylinder.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3djs.primitives.VertexInfo} The created cylinder vertices.
 */
o3djs.primitives.createCylinderVertices = function(radius,
                                                   height,
                                                   radialSubdivisions,
                                                   verticalSubdivisions,
                                                   opt_matrix) {
  return o3djs.primitives.createTruncatedConeVertices(radius,
                                                      radius,
                                                      height,
                                                      radialSubdivisions,
                                                      verticalSubdivisions,
                                                      opt_matrix);
};

/**
 * Creates a cylinder shape. The cylinder will be created around the
 * origin along the y-axis. The created cylinder has position, normal
 * and uv streams.
 *
 * @param {!o3d.Pack} pack Pack to create cylinder elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} radius Radius of cylinder.
 * @param {number} height Height of cylinder.
 * @param {number} radialSubdivisions The number of subdivisions around the
 *     cylinder.
 * @param {number} verticalSubdivisions The number of subdivisions down the
 *     cylinder.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created cylinder.
 */
o3djs.primitives.createCylinder = function(pack,
                                           material,
                                           radius,
                                           height,
                                           radialSubdivisions,
                                           verticalSubdivisions,
                                           opt_matrix) {
  var vertexInfo = o3djs.primitives.createCylinderVertices(
      radius,
      height,
      radialSubdivisions,
      verticalSubdivisions,
      opt_matrix);
  return vertexInfo.createShape(pack, material);
};

/**
 * Creates vertices for a truncated cone, which is like a cylinder
 * except that it has different top and bottom radii. A truncated cone
 * can also be used to create cylinders and regular cones. The
 * truncated cone will be created centered about the origin, with the
 * y axis as its vertical axis. The created cone has position, normal
 * and uv streams.
 *
 * @param {number} bottomRadius Bottom radius of truncated cone.
 * @param {number} topRadius Top radius of truncated cone.
 * @param {number} height Height of truncated cone.
 * @param {number} radialSubdivisions The number of subdivisions around the
 *     truncated cone.
 * @param {number} verticalSubdivisions The number of subdivisions down the
 *     truncated cone.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3djs.primitives.VertexInfo} The created truncated cone vertices.
 */
o3djs.primitives.createTruncatedConeVertices = function(bottomRadius,
                                                        topRadius,
                                                        height,
                                                        radialSubdivisions,
                                                        verticalSubdivisions,
                                                        opt_matrix) {
  if (radialSubdivisions < 3) {
    throw Error('radialSubdivisions must be 3 or greater');
  }

  if (verticalSubdivisions < 1) {
    throw Error('verticalSubdivisions must be 1 or greater');
  }

  var vertexInfo = o3djs.primitives.createVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);
  var normalStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.NORMAL);
  var texCoordStream = vertexInfo.addStream(
      2, o3djs.base.o3d.Stream.TEXCOORD, 0);

  var vertsAroundEdge = radialSubdivisions + 1;

  // The slant of the cone is constant across its surface
  var slant = Math.atan2(bottomRadius - topRadius, height);
  var cosSlant = Math.cos(slant);
  var sinSlant = Math.sin(slant);

  for (var yy = -2; yy <= verticalSubdivisions + 2; ++yy) {
    var v = yy / verticalSubdivisions
    var y = height * v;
    var ringRadius;
    if (yy < 0) {
      y = 0;
      v = 1;
      ringRadius = bottomRadius;
    } else if (yy > verticalSubdivisions) {
      y = height;
      v = 1;
      ringRadius = topRadius;
    } else {
      ringRadius = bottomRadius +
        (topRadius - bottomRadius) * (yy / verticalSubdivisions);
    }
    if (yy == -2 || yy == verticalSubdivisions + 2) {
      ringRadius = 0;
      v = 0;
    }
    y -= height / 2;
    for (var ii = 0; ii < vertsAroundEdge; ++ii) {
      var sin = Math.sin(ii * Math.PI * 2 / radialSubdivisions);
      var cos = Math.cos(ii * Math.PI * 2 / radialSubdivisions);
      positionStream.addElement(sin * ringRadius, y, cos * ringRadius);
      normalStream.addElement(
          (yy < 0 || yy > verticalSubdivisions) ? 0 : (sin * cosSlant),
          (yy < 0) ? -1 : (yy > verticalSubdivisions ? 1 : sinSlant),
          (yy < 0 || yy > verticalSubdivisions) ? 0 : (cos * cosSlant));
      texCoordStream.addElement(ii / radialSubdivisions, v);
    }
  }

  for (var yy = 0; yy < verticalSubdivisions + 4; ++yy) {
    for (var ii = 0; ii < radialSubdivisions; ++ii) {
      vertexInfo.addTriangle(vertsAroundEdge * (yy + 0) + 0 + ii,
                             vertsAroundEdge * (yy + 0) + 1 + ii,
                             vertsAroundEdge * (yy + 1) + 1 + ii);
      vertexInfo.addTriangle(vertsAroundEdge * (yy + 0) + 0 + ii,
                             vertsAroundEdge * (yy + 1) + 1 + ii,
                             vertsAroundEdge * (yy + 1) + 0 + ii);
    }
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a truncated cone shape, which is like a cylinder except
 * that it has different top and bottom radii. A truncated cone can
 * also be used to create cylinders, by setting the bottom and top
 * radii equal, and cones, by setting either the top or bottom radius
 * to 0. The truncated cone will be created centered about the origin,
 * with the y axis as its vertical axis. The created cone has
 * position, normal and uv streams.
 *
 * @param {!o3d.Pack} pack Pack in which to create the truncated cone.
 * @param {!o3d.Material} material to use.
 * @param {number} bottomRadius Bottom radius of truncated cone.
 * @param {number} topRadius Top radius of truncated cone.
 * @param {number} height Height of truncated cone.
 * @param {number} radialSubdivisions The number of subdivisions around the
 *     truncated cone.
 * @param {number} verticalSubdivisions The number of subdivisions down the
 *     truncated cone.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created truncated cone.
 */
o3djs.primitives.createTruncatedCone = function(pack,
                                                material,
                                                bottomRadius,
                                                topRadius,
                                                height,
                                                radialSubdivisions,
                                                verticalSubdivisions,
                                                opt_matrix) {
  var vertexInfo = o3djs.primitives.createTruncatedConeVertices(
      bottomRadius,
      topRadius,
      height,
      radialSubdivisions,
      verticalSubdivisions,
      opt_matrix);
  return vertexInfo.createShape(pack, material);
};

/**
 * Creates vertices for a torus. The torus will be created centered about the
 * origin, with the y axis as its vertical axis. The created torus has
 * position, normal and uv streams.
 *
 * @param {number} torusRadius Distance from the center of the tube to
 *     the center of the torus.
 * @param {number} tubeRadius Radius of the tube.
 * @param {number} tubeLengthSubdivisions The number of subdivisions around the
 *     vertical axis of the torus, i.e. along the length of the tube.
 * @param {number} circleSubdivisions The number of subdivisions in the circle
 *     that is rotated about the vertical axis to create the torus.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3djs.primitives.VertexInfo} The created torus vertices.
 */
o3djs.primitives.createTorusVertices = function(torusRadius,
                                                tubeRadius,
                                                tubeLengthSubdivisions,
                                                circleSubdivisions,
                                                opt_matrix) {
  if (tubeLengthSubdivisions < 3) {
    throw Error('tubeLengthSubdivisions must be 3 or greater');
  }

  if (circleSubdivisions < 3) {
    throw Error('circleSubdivisions must be 3 or greater');
  }

  var vertexInfo = o3djs.primitives.createVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);
  var normalStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.NORMAL);
  var texCoordStream = vertexInfo.addStream(
      2, o3djs.base.o3d.Stream.TEXCOORD, 0);

  for (var uu = 0; uu < tubeLengthSubdivisions; ++uu) {
    var u = (uu / tubeLengthSubdivisions) * 2 * Math.PI;
    for (var vv = 0; vv < circleSubdivisions; ++vv) {
      var v = (vv / circleSubdivisions) * 2 * Math.PI;
      var sinu = Math.sin(u);
      var cosu = Math.cos(u);
      var sinv = Math.sin(v);
      var cosv = Math.cos(v);
      positionStream.addElement((torusRadius + tubeRadius * cosv) * cosu,
                                tubeRadius * sinv,
                                (torusRadius + tubeRadius * cosv) * sinu);
      normalStream.addElement(cosv * cosu,
                              sinv,
                              cosv * sinu);
      texCoordStream.addElement(uu / tubeLengthSubdivisions,
                                vv / circleSubdivisions);
    }
  }

  for (var uu = 0; uu < tubeLengthSubdivisions; ++uu) {
    for (var vv = 0; vv < circleSubdivisions; ++vv) {
      // We want to wrap the indices around at the seams.
      var uuPlusOne = (uu + 1) % tubeLengthSubdivisions;
      var vvPlusOne = (vv + 1) % circleSubdivisions;
      // The indices of four points forming a quad.
      var a = circleSubdivisions * uu        + vv;
      var b = circleSubdivisions * uuPlusOne + vv;
      var c = circleSubdivisions * uu        + vvPlusOne;
      var d = circleSubdivisions * uuPlusOne + vvPlusOne;
      vertexInfo.addTriangle(a, d, b);
      vertexInfo.addTriangle(a, c, d);
    }
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a torus shape. The torus will be created centered about the
 * origin, with the y axis as its vertical axis. The created torus has
 * position, normal and uv streams.
 *
 * @param {!o3d.Pack} pack Pack in which to create the torus.
 * @param {!o3d.Material} material to use.
 * @param {number} torusRadius Distance from the center of the tube to
 *     the center of the torus.
 * @param {number} tubeRadius Radius of the tube.
 * @param {number} tubeLengthSubdivisions The number of subdivisions around the
 *     vertical axis of the torus, i.e. along the length of the tube.
 * @param {number} circleSubdivisions The number of subdivisions in the circle
 *     that is rotated about the vertical axis to create the torus.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created torus.
 */
o3djs.primitives.createTorus = function(pack,
                                        material,
                                        torusRadius,
                                        tubeRadius,
                                        tubeLengthSubdivisions,
                                        circleSubdivisions,
                                        opt_matrix) {
  var vertexInfo = o3djs.primitives.createTorusVertices(
      torusRadius,
      tubeRadius,
      tubeLengthSubdivisions,
      circleSubdivisions,
      opt_matrix);
  return vertexInfo.createShape(pack, material);
};

/**
 * Creates wedge vertices, wedge being an extruded triangle. The wedge will be
 * created around the 3 2d points passed in and extruded along the z axis. The
 * created wedge has position, normal and uv streams.
 *
 * @param {!Array.<!Array.<number>>} inPoints Array of 2d points in the format
 *   [[x1, y1], [x2, y2], [x3, y3]] that describe a 2d triangle.
 * @param {number} depth The depth to extrude the triangle.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3djs.primitives.VertexInfo} The created wedge vertices.
 */
o3djs.primitives.createWedgeVertices = function(inPoints, depth,
                                                opt_matrix) {
  var math = o3djs.math;

  var vertexInfo = o3djs.primitives.createVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);
  var normalStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.NORMAL);
  var texCoordStream = vertexInfo.addStream(
      2, o3djs.base.o3d.Stream.TEXCOORD, 0);

  var z1 = -depth * 0.5;
  var z2 = depth * 0.5;
  var face = [];
  var points = [[inPoints[0][0], inPoints[0][1]],
                [inPoints[1][0], inPoints[1][1]],
                [inPoints[2][0], inPoints[2][1]]];

  face[0] = math.cross(
      math.normalize([points[1][0] - points[0][0],
                      points[1][1] - points[0][1],
                      z1 - z1]),
      math.normalize([points[1][0] - points[1][0],
                      points[1][1] - points[1][1],
                      z2 - z1]));
  face[1] = math.cross(
      math.normalize([points[2][0] - points[1][0],
                      points[2][1] - points[1][1],
                      z1 - z1]),
      math.normalize([points[2][0] - points[2][0],
                      points[2][1] - points[2][1],
                      z2 - z1]));
  face[2] = math.cross(
      [points[0][0] - points[2][0], points[0][1] - points[2][1], z1 - z1],
      [points[0][0] - points[0][0], points[0][1] - points[0][1], z2 - z1]);

  positionStream.addElement(points[0][0], points[0][1], z1);
  normalStream.addElement(0, 0, -1);
  texCoordStream.addElement(0, 1);
  positionStream.addElement(points[1][0], points[1][1], z1);
  normalStream.addElement(0, 0, -1);
  texCoordStream.addElement(1, 0);
  positionStream.addElement(points[2][0], points[2][1], z1);
  normalStream.addElement(0, 0, -1);
  texCoordStream.addElement(0, 0);
                  // back
  positionStream.addElement(points[0][0], points[0][1], z2);
  normalStream.addElement(0, 0, 1);
  texCoordStream.addElement(0, 1);
  positionStream.addElement(points[1][0], points[1][1], z2);
  normalStream.addElement(0, 0, 1);
  texCoordStream.addElement(1, 0);
  positionStream.addElement(points[2][0], points[2][1], z2);
  normalStream.addElement(0, 0, 1);
  texCoordStream.addElement(0, 0);
                  // face 0
  positionStream.addElement(points[0][0], points[0][1], z1);
  normalStream.addElement(face[0][0], face[0][1], face[0][2]);
  texCoordStream.addElement(0, 1);
  positionStream.addElement(points[1][0], points[1][1], z1);
  normalStream.addElement(face[0][0], face[0][1], face[0][2]);
  texCoordStream.addElement(0, 0);
  positionStream.addElement(points[1][0], points[1][1], z2);
  normalStream.addElement(face[0][0], face[0][1], face[0][2]);
  texCoordStream.addElement(1, 0);
  positionStream.addElement(points[0][0], points[0][1], z2);
  normalStream.addElement(face[0][0], face[0][1], face[0][2]);
  texCoordStream.addElement(1, 1);
                  // face 1
  positionStream.addElement(points[1][0], points[1][1], z1);
  normalStream.addElement(face[1][0], face[1][1], face[1][2]);
  texCoordStream.addElement(0, 1);
  positionStream.addElement(points[2][0], points[2][1], z1);
  normalStream.addElement(face[1][0], face[1][1], face[1][2]);
  texCoordStream.addElement(0, 0);
  positionStream.addElement(points[2][0], points[2][1], z2);
  normalStream.addElement(face[1][0], face[1][1], face[1][2]);
  texCoordStream.addElement(1, 0);
  positionStream.addElement(points[1][0], points[1][1], z2);
  normalStream.addElement(face[1][0], face[1][1], face[1][2]);
  texCoordStream.addElement(1, 1);
                  // face 2
  positionStream.addElement(points[2][0], points[2][1], z1);
  normalStream.addElement(face[2][0], face[2][1], face[2][2]);
  texCoordStream.addElement(0, 1);
  positionStream.addElement(points[0][0], points[0][1], z1);
  normalStream.addElement(face[2][0], face[2][1], face[2][2]);
  texCoordStream.addElement(0, 0);
  positionStream.addElement(points[0][0], points[0][1], z2);
  normalStream.addElement(face[2][0], face[2][1], face[2][2]);
  texCoordStream.addElement(1, 0);
  positionStream.addElement(points[2][0], points[2][1], z2);
  normalStream.addElement(face[2][0], face[2][1], face[2][2]);
  texCoordStream.addElement(1, 1);

  vertexInfo.addTriangle(0, 2, 1);
  vertexInfo.addTriangle(3, 4, 5);
  vertexInfo.addTriangle(6, 7, 8);
  vertexInfo.addTriangle(6, 8, 9);
  vertexInfo.addTriangle(10, 11, 12);
  vertexInfo.addTriangle(10, 12, 13);
  vertexInfo.addTriangle(14, 15, 16);
  vertexInfo.addTriangle(14, 16, 17);

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a wedge shape. A wedge being an extruded triangle. The wedge will
 * be created around the 3 2d points passed in and extruded along the z-axis.
 * The created wedge has position, normal and uv streams.
 *
 * @param {!o3d.Pack} pack Pack to create wedge elements in.
 * @param {!o3d.Material} material to use.
 * @param {!Array.<!Array.<number>>} points Array of 2d points in the format
 *     [[x1, y1], [x2, y2], [x3, y3]] that describe a 2d triangle.
 * @param {number} depth The depth to extrude the triangle.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created wedge.
 */
o3djs.primitives.createWedge = function(pack,
                                        material,
                                        points,
                                        depth,
                                        opt_matrix) {
  var vertexInfo = o3djs.primitives.createWedgeVertices(points,
                                                        depth,
                                                        opt_matrix);
  return vertexInfo.createShape(pack, material);
};

/**
 * Creates prism vertices by extruding a polygon. The prism will be created
 * around the 2d points passed in and extruded along the z axis.  The end caps
 * of the prism are constructed using a triangle fan originating at point 0,
 * so a non-convex polygon might not get the desired shape, but it will if it
 * is convex with respect to point 0.  Texture coordinates map each face of
 * the wall exactly to the unit square.  Texture coordinates on the front
 * and back faces are scaled such that the bounding rectangle of the polygon
 * is mapped to the unit square. The created prism has position, normal,
 * uv streams.
 *
 * @param {!Array.<!Array.<number>>} points Array of 2d points in the format
 *     [[x1, y1], [x2, y2], [x3, y3],...] that describe a 2d polygon.
 * @param {number} depth The depth to extrude the polygon.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3djs.primitives.VertexInfo} The created prism vertices.
 */
o3djs.primitives.createPrismVertices = function(points,
                                                depth,
                                                opt_matrix) {
  if (points.length < 3) {
    throw Error('there must be 3 or more points');
  }

  var backZ = -0.5 * depth;
  var frontZ = 0.5 * depth;
  var normals = [];

  var vertexInfo = o3djs.primitives.createVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);
  var normalStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.NORMAL);
  var texCoordStream = vertexInfo.addStream(
      2, o3djs.base.o3d.Stream.TEXCOORD, 0);

  // Normals for the wall faces.
  var n = points.length;

  for (var i = 0; i < n; ++i) {
    var j = (i + 1) % n;
    var x = points[j][0] - points[i][0];
    var y = points[j][1] - points[i][1];
    var length = Math.sqrt(x * x + y * y);
    normals[i] = [y / length, -x / length, 0];
  }

  // Compute the minimum and maxiumum x and y coordinates of points in the
  // polygon.
  var minX = points[0][0];
  var minY = points[0][1];
  var maxX = points[0][0];
  var maxY = points[0][1];
  for (var i = 1; i < n; ++i) {
    var x = points[i][0];
    var y = points[i][1];
    minX = Math.min(minX, x);
    minY = Math.min(minY, y);
    maxX = Math.max(maxX, x);
    maxY = Math.max(maxY, y);
  }

  // Scale the x and y coordinates of the points of the polygon to fit the
  // bounding rectangle, and use the scaled coordinates for the uv
  // of the front and back cap.
  var frontUV = [];
  var backUV = [];
  var rangeX = maxX - minX;
  var rangeY = maxY - minY;
  for (var i = 0; i < n; ++i) {
    frontUV[i] = [
      (points[i][0] - minX) / rangeX,
      (points[i][1] - minY) / rangeY
    ];
    backUV[i] = [
      (maxX - points[i][0]) / rangeX,
      (points[i][1] - minY) / rangeY
    ];
  }

  for (var i = 0; i < n; ++i) {
    var j = (i + 1) % n;
    // Vertex on the back face.
    positionStream.addElement(points[i][0], points[i][1], backZ);
    normalStream.addElement(0, 0, -1);
    texCoordStream.addElement(backUV[i][0], backUV[i][1]);

    // Vertex on the front face.
    positionStream.addElement(points[i][0], points[i][1], frontZ),
    normalStream.addElement(0, 0, 1);
    texCoordStream.addElement(frontUV[i][0], frontUV[i][1]);

    // Vertices for a quad on the wall.
    positionStream.addElement(points[i][0], points[i][1], backZ),
    normalStream.addElement(normals[i][0], normals[i][1], normals[i][2]);
    texCoordStream.addElement(0, 1);

    positionStream.addElement(points[j][0], points[j][1], backZ),
    normalStream.addElement(normals[i][0], normals[i][1], normals[i][2]);
    texCoordStream.addElement(0, 0);

    positionStream.addElement(points[j][0], points[j][1], frontZ),
    normalStream.addElement(normals[i][0], normals[i][1], normals[i][2]);
    texCoordStream.addElement(1, 0);

    positionStream.addElement(points[i][0], points[i][1], frontZ),
    normalStream.addElement(normals[i][0], normals[i][1], normals[i][2]);
    texCoordStream.addElement(1, 1);

    if (i > 0 && i < n - 1) {
      // Triangle for the back face.
      vertexInfo.addTriangle(0, 6 * (i + 1), 6 * i);

      // Triangle for the front face.
      vertexInfo.addTriangle(1, 6 * i + 1, 6 * (i + 1) + 1);
    }

    // Quad on the wall.
    vertexInfo.addTriangle(6 * i + 2, 6 * i + 3, 6 * i + 4);
    vertexInfo.addTriangle(6 * i + 2, 6 * i + 4, 6 * i + 5);
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates a prism shape by extruding a polygon. The prism will be created
 * around the 2d points passed in an array and extruded along the z-axis.
 * The end caps of the prism are constructed using a triangle fan originating
 * at the first point, so a non-convex polygon might not get the desired
 * shape, but it will if it is convex with respect to the first point.
 * Texture coordinates map each face of the wall exactly to the unit square.
 * Texture coordinates on the front and back faces are scaled such that the
 * bounding rectangle of the polygon is mapped to the unit square.
 * The created prism has position, normal and uv streams.
 *
 * @param {!o3d.Pack} pack Pack to create wedge elements in.
 * @param {!o3d.Material} material to use.
 * @param {!Array.<!Array.<number>>} points Array of 2d points in the format:
 *     [[x1, y1], [x2, y2], [x3, y3],...] that describe a 2d polygon.
 * @param {number} depth The depth to extrude the polygon.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created prism.
 */
o3djs.primitives.createPrism = function(pack,
                                        material,
                                        points,
                                        depth,
                                        opt_matrix) {
  var vertexInfo = o3djs.primitives.createPrismVertices(points,
                                                        depth,
                                                        opt_matrix);
  return vertexInfo.createShape(pack, material);
};

/**
 * Creates XZ plane vertices.
 * The created plane has position, normal and uv streams.
 *
 * @param {number} width Width of the plane.
 * @param {number} depth Depth of the plane.
 * @param {number} subdivisionsWidth Number of steps across the plane.
 * @param {number} subdivisionsDepth Number of steps down the plane.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3djs.primitives.VertexInfo} The created plane vertices.
 */
o3djs.primitives.createPlaneVertices = function(width,
                                                depth,
                                                subdivisionsWidth,
                                                subdivisionsDepth,
                                                opt_matrix) {
  if (subdivisionsWidth <= 0 || subdivisionsDepth <= 0) {
    throw Error('subdivisionWidth and subdivisionDepth must be > 0');
  }

  var vertexInfo = o3djs.primitives.createVertexInfo();
  var positionStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.POSITION);
  var normalStream = vertexInfo.addStream(
      3, o3djs.base.o3d.Stream.NORMAL);
  var texCoordStream = vertexInfo.addStream(
      2, o3djs.base.o3d.Stream.TEXCOORD, 0);

  // Generate the individual vertices in our vertex buffer.
  for (var z = 0; z <= subdivisionsDepth; z++) {
    for (var x = 0; x <= subdivisionsWidth; x++) {
      var u = x / subdivisionsWidth;
      var v = z / subdivisionsDepth;
      positionStream.addElement(width * u - width * 0.5,
                                0,
                                depth * v - depth * 0.5);
      normalStream.addElement(0, 1, 0);
      texCoordStream.addElement(u, 1 - v);
    }
  }

  var numVertsAcross = subdivisionsWidth + 1;

  for (var z = 0; z < subdivisionsDepth; z++) {
    for (var x = 0; x < subdivisionsWidth; x++) {
      // triangle 1 of quad
      vertexInfo.addTriangle(
          (z + 0) * numVertsAcross + x,
          (z + 1) * numVertsAcross + x,
          (z + 0) * numVertsAcross + x + 1);

      // triangle 2 of quad
      vertexInfo.addTriangle(
          (z + 1) * numVertsAcross + x,
          (z + 1) * numVertsAcross + x + 1,
          (z + 0) * numVertsAcross + x + 1);
    }
  }

  if (opt_matrix) {
    vertexInfo.reorient(opt_matrix);
  }
  return vertexInfo;
};

/**
 * Creates an XZ plane.
 * The created plane has position, normal and uv streams.
 *
 * @param {!o3d.Pack} pack Pack to create plane elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} width Width of the plane.
 * @param {number} depth Depth of the plane.
 * @param {number} subdivisionsWidth Number of steps across the plane.
 * @param {number} subdivisionsDepth Number of steps down the plane.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created plane.
 *
 * @see o3d.Pack
 * @see o3d.Shape
 */
o3djs.primitives.createPlane = function(pack,
                                        material,
                                        width,
                                        depth,
                                        subdivisionsWidth,
                                        subdivisionsDepth,
                                        opt_matrix) {
  var vertexInfo = o3djs.primitives.createPlaneVertices(
      width,
      depth,
      subdivisionsWidth,
      subdivisionsDepth,
      opt_matrix);

  return vertexInfo.createShape(pack, material);
};

/**
 * Creates an XZ fade plane, where the alpha channel of the color stream
 * fades from 1 to 0.
 * The created plane has position, normal, uv and vertex color streams.
 *
 * @param {!o3d.Pack} pack Pack to create plane elements in.
 * @param {!o3d.Material} material to use.
 * @param {number} width Width of the plane.
 * @param {number} depth Depth of the plane.
 * @param {number} subdivisionsWidth Number of steps across the plane.
 * @param {number} subdivisionsDepth Number of steps down the plane.
 * @param {!o3djs.math.Matrix4} opt_matrix A matrix by which to multiply
 *     all the vertices.
 * @return {!o3d.Shape} The created plane.
 *
 * @see o3d.Pack
 * @see o3d.Shape
 */
o3djs.primitives.createFadePlane = function(pack,
                                            material,
                                            width,
                                            depth,
                                            subdivisionsWidth,
                                            subdivisionsDepth,
                                            opt_matrix) {
  var vertexInfo = o3djs.primitives.createPlaneVertices(
      width,
      depth,
      subdivisionsWidth,
      subdivisionsDepth,
      opt_matrix);
  var colorStream = vertexInfo.addStream(4, o3djs.base.o3d.Stream.COLOR);
  for (var z = 0; z <= subdivisionsDepth; z++) {
    var alpha = z / subdivisionsDepth;
    for (var x = 0; x <= subdivisionsWidth; x++) {
      colorStream.addElement(1, 1, 1, alpha);
    }
  }
  return vertexInfo.createShape(pack, material);
};

