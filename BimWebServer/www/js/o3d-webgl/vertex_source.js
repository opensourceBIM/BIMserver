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
 * A VertexSource is an object that allows binding Streams such that the
 * VertexSource updates the Buffers of the Streams that have been bound to it.
 * An example of a VertexSource object is a SkinEval
 *
 * @constructor
 * @extends ParamObject
 */
o3d.VertexSource = function() {
  o3d.ParamObject.call(this);
};
o3d.inherit('VertexSource', 'ParamObject');

/**
 * Bind the source stream to the corresponding stream in this VertexSource.
 *
 * @param {o3d.VertexSource} source Source to get vertices from.
 * @param {o3d.Stream.Semantic} semantic The semantic of the vertices to get.
 * @param {number} semantic_index The semantic index of the vertices to get.
 * @return {boolean} True if success. False if failure. If the requested
 *     semantic or semantic index do not exist on the source or this source
 *     the bind will fail.
 */
o3d.VertexSource.prototype.bindStream = function(
    source, semantic, semantic_index) {
  if (source) {
    var source_param = source.getVertexStreamParam(semantic, semantic_index);
    var dest_param = this.getVertexStreamParam(semantic, semantic_index);
    if (source_param && dest_param &&
        source_param.stream.field.className ==
            dest_param.stream.field.className &&
        source_param.stream.field.numComponents ==
        dest_param.stream.field.numComponents) {
      dest_param.bind(source_param);
      source.streamWasBound_(this, semantic, semantic_index);
      return true;
    }
  }

  return false;
};

/**
 * Unbinds the requested stream.
 *
 * @param {o3d.Stream.Semantic} semantic The semantic of the vertices to unbind.
 * @param {number} semantic_index The semantic index of the vertices to unbind.
 * @return {boolean} True if unbound. False those vertices do not exist or were
 *     not bound.
 */
o3d.VertexSource.prototype.unbindStream = function(semantic, semantic_index) {
  var dest_param = this.getVertexStreamParam(semantic, semantic_index);
  if (dest_param && dest_param.inputConnection != null) {
    dest_param.unbindInput();
    return true;
  }
  return false;
};

/**
 * Used by bindStream. Each derived class must provide this function.
 *
 * @param {o3d.Stream.Semantic} semantic The semantic of the vertices to get.
 * @param {number} semantic_index The semantic index of the vertices to get.
 * @return {ParamVertexBufferStream} Returns the ParamVertexBufferStream that
 *     manages the given stream as an output param for this VertexSource.
 * @protected
 */
o3d.VertexSource.prototype.getVertexStreamParam = function(
    semantic, semantic_index) {
  o3d.notImplemented();
};

/**
 * Used by bindStream. Derived classes may override if needed.
 *
 * @param {o3d.VertexSource} dest VertexSource that bound to this VertexSource.
 * @param {o3d.ParamVertexBufferStream} dest_param Other param which was bound.
 * @protected
 */
o3d.VertexSource.prototype.streamWasBound_ = function(
    dest, semantic, semantic_index) {
};

