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
 * Namespace o3d
 * @constructor
 */
o3d.Stream = function(semantic, semantic_index, field, start_index) {
  o3d.NamedObject.call(this);
  this.semantic = semantic;
  this.semanticIndex = semantic_index;
  this.field = field;
  this.startIndex = start_index;
};
o3d.inherit('Stream', 'NamedObject');

/**
 * @type {number}
 */
o3d.Stream.Semantic = goog.typedef;

/**
 *  Semantic,
 *  UNKNOWN_SEMANTIC = 0,
 *  POSITION,
 *  NORMAL,
 *  TANGENT,
 *  BINORMAL,
 *  COLOR,
 *  TEXCOORD,
 *  INFLUENCE_WEIGHTS,
 *  INFLUENCE_INDICES
 *
 * Semantics used when binding buffers to the streambank.  They determine how
 * the Stream links up to the shader inputs.
 */
o3d.Stream.UNKNOWN_SEMANTIC = 0;
o3d.Stream.POSITION = 1;
o3d.Stream.NORMAL = 2;
o3d.Stream.TANGENT = 3;
o3d.Stream.BINORMAL = 4;
o3d.Stream.COLOR = 5;
o3d.Stream.TEXCOORD = 6;
o3d.Stream.INFLUENCE_WEIGHTS = 7;
o3d.Stream.INFLUENCE_INDICES = 8;



/**
 * The associated Field.
 */
o3d.Stream.prototype.field = null;



/**
 * The semantic specified for the Stream.
 */
o3d.Stream.prototype.semantic = o3d.Stream.UNKNOWN_SEMANTIC;



/**
 * The semantic index specified for the Stream
 * (eg., TEXCOORD1 = 1, BINORMAL7 = 7, etc).
 */
o3d.Stream.prototype.semanticIndex = 0;



/**
 * The start index for the Stream.
 */
o3d.Stream.prototype.startIndex = 0;


/**
 * Gets the max number of vertices in this stream.
 *
 * @return {number} The maximum vertices available given the stream's settings
 *     and its buffer.
 * @private
 */
o3d.Stream.prototype.getMaxVertices_ = function() {
  var buffer = this.field.buffer;
  if (!buffer)
    return 0;

  var num_elements = buffer.numElements;
  if (this.startIndex > num_elements)
    return 0;

  return num_elements - this.startIndex;
};

