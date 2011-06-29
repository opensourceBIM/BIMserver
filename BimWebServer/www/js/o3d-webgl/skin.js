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
 * A Skin holds an array of matrix indices and influences for vertices in a
 * skin. A Skin is data only and can be used by one or more SkinEvals to
 * implement skinning.
 *
 * @constructor
 * @extends {o3d.NamedObject}
 */
o3d.Skin = function() {
  o3d.NamedObject.call(this);

  /**
   * Set of influences contained in this skin.
   * @type {!Array<!Array<number>>}
   */
  this.influences = [];

  /**
   * The array of inverse bone matrices (Array<matrix4>)
   *
   * @type {!Array<!Array<!Array<number>>>}
   */
  this.inverseBindPoseMatrices = [];

  /**
   * Whether the getHighestMatrixIndex and getHighestInfluences are up-to-date.
   *
   * @type {boolean}
   * @private
   */
  this.info_valid_ = false;

  /**
   * Cache of getHighestMatrixIndex().
   *
   * @type {number}
   * @private
   */
  this.highest_matrix_index_ = 0;

  /**
   * Cache of getHighestInfluences().
   *
   * @type {number}
   * @private
   */
  this.highest_influences_ = 0;

  /**
   * True if the list of weights and matrix index streams could be downloaded.
   *
   * @type {boolean}
   * @private
   */
  this.supports_vertex_shader_ = false;

  /**
   * Whether the WEIGHTS and MATRIX_INDICES buffers are up-to-date.
   *
   * @type {boolean}
   * @private
   */
  this.buffers_valid_ = false;

  /**
   * Vertex buffer containing indices and weights for this skin.
   *
   * @type {VertexBuffer}
   */
  this.vertex_buffer_ = null;

  /**
   * Buffer in which to store vertex weights.
   * weights_field_ will be passed into the WEIGHTS stream.
   *
   * @type {o3d.Field}
   * @private
   */
  this.weights_field_ = null;

  /**
   * Buffer in which to store list of matrix_indices per vertex.
   * matrix_indices_field_ will be passed into the MATRIX_INDICES stream.
   *
   * @type {o3d.Field}
   * @private
   */
  this.matrix_indices_field_ = null;
};
o3d.inherit('Skin', 'NamedObject');

/**
 * Updates the weights and indices vertex buffers attached to this skin, only
 * if they have been invalidated by some param change.
 * Also checks if we can support skinning based on the number of bones we need
 * in this skin.
 * @private
 * @return {boolean} true if our mesh is small enough to enable skin shader.
 */
o3d.Skin.prototype.updateVertexShader = function() {
  if (!this.buffers_valid_) {
    var numcomp = 4;
    var numvert = this.influences.length;
    if (!this.weights_field_ && !this.matrix_indices_field_) {
      var vertex_buffer = new o3d.VertexBuffer;
      vertex_buffer.gl = this.gl;
      this.weights_field_ =
          vertex_buffer.createField("FloatField", numcomp);
      this.matrix_indices_field_ =
          vertex_buffer.createField("FloatField", numcomp);
      vertex_buffer.allocateElements(numvert);
    }
    var ii, jj;
    var weights_field = this.weights_field_;
    var indices_field = this.matrix_indices_field_;
    var highest_influences = this.getHighestInfluences();

    this.buffers_valid_ = true;
    weights_field.buffer.lock();
    indices_field.buffer.lock();
    var max_num_bones = o3d.SkinEval.getMaxNumBones(this);
    this.supports_vertex_shader_ = (highest_influences <= numcomp) &&
        (this.inverseBindPoseMatrices.length <= max_num_bones);
    if (this.supports_vertex_shader_) {
      // NOTE: If you make these Array's instead, you must initialize to 0.
      var weights_arr = new Float32Array(numvert * numcomp);
      var indices_arr = new Float32Array(numvert * numcomp);
      // Float32rray is initialized to 0 by default.
      for (ii = 0; ii < numvert; ++ii) {
        var influence = this.influences[ii];
        for (jj = 0; jj < influence.length && jj < numcomp * 2; jj += 2) {
          indices_arr[ii * numcomp + jj / 2] = influence[jj];
          weights_arr[ii * numcomp + jj / 2] = influence[jj + 1];
        }
      }
      weights_field.setAt(0, weights_arr);
      indices_field.setAt(0, indices_arr);
    }
    // Otherwise, weights will be filled with 0's by default.
    weights_field.buffer.unlock();
    indices_field.buffer.unlock();
  }
  return this.supports_vertex_shader_;
};

/**
 * Sets the influences for an individual vertex.
 *
 * @param {number} vertex_index The index of the vertex to set influences for.
 * @param {!Array<number>} influences An array of pairs of numbers where
 *     the first number is the index of the matrix to influence the vertex
 *     and the second number is the amount of influence where:
 *     0 = no influence and 1 = 100% influence.
 */
o3d.Skin.prototype.setVertexInfluences = function(
    vertex_index, influences) {
  if (influences.length % 2 != 0) {
    this.gl.client.error_callback("odd number of values passed into" +
        "SetVertexInfluence. Even number required as they are pairs.");
    return;
  }
  this.influences[vertex_index] = influences;
  this.info_valid_ = false;
  this.buffers_valid_ = false;
};

/**
 * Gets the influences for an individual vertex.
 *
 * @param {number} vertex_index The index of the vertex to get influences from.
 * @return {!Array<number>} An array of pairs of numbers where the first number
 *     of each pair is the index of the matrix that influence this vertex and
 *     the second number is the amount of influence where:
 *     0 = no influence and 1 = 100% influence.
 */
o3d.Skin.prototype.getVertexInfluences = function(vertex_index) {
  return this.influences[vertex_index] || [];
};

/**
 * Update the highest influences and highest matrix index.
 * @private
 */
o3d.Skin.prototype.updateInfo_ = function() {
  if (!this.info_valid_) {
    this.info_valid_ = true;
    this.highest_matrix_index_ = 0;
    this.highest_influences_ = 0;
    for (var ii = 0; ii < this.influences.length; ++ii) {
      var influences = this.influences[ii];
      var len = influences.length;
      if (len > this.highest_influences_) {
        this.highest_influences_ = len;
      }
      // Influences array is in pairs: even are vertices, odd are weights
      for (var jj = 0; jj < influences.length; jj += 2) {
        if (influences[jj] > this.highest_matrix_index_) {
          this.highest_matrix_index_ = influences[jj];
        }
      }
    }
    // this.highest_influences_ should be the number of pairs.
    if (this.highest_influences_ % 2) {
      this.gl.client.error_callback(
          "Skin.updateInfo: Influences should not have odd length ");
    }
    this.highest_influences_ = Math.floor(this.highest_influences_/2);
  }
};

/**
 * Gets the highest matrix index referenced by the influences.
 *
 * @return {number} The highest matrix index referenced by the influences.
 * @private
 */
o3d.Skin.prototype.getHighestMatrixIndex = function() {
  this.updateInfo_();
  return this.highest_matrix_index_;
};

/**
 * Gets the highest number of influences on any vertex.
 *
 * @return {number} The highest number of influences on any vertex.
 * @private
 */
o3d.Skin.prototype.getHighestInfluences = function() {
  this.updateInfo_();
  return this.highest_influences_;
};

/**
 * Sets the inverse bind pose matrix for a particular joint/bone/transform.
 *
 * @param {number} index Index of bone/joint/transform.
 * @param {!Array<!Array<number>>} matrix Inverse bind pose matrix for this
 *     joint.
 */
o3d.Skin.prototype.setInverseBindPoseMatrix = function(index, matrix) {
  this.inverseBindPoseMatrices[index] = matrix;
};

/**
 * Deserializes from the skin data given a RawData object.
 *
 * @param {!o3d.RawData} rawData contains skin data
 * @param {number} opt_offset is a byte offset from the start of raw_data
 * @param {number} opt_length is the byte length of the data to set
 * @return {boolean} True if operation was successful.
 *
 */
o3d.Skin.prototype.set = function(rawData, opt_offset, opt_length) {
  o3d.notImplemented();
};



/**
 * A SkinEval is a VertexSource that takes its Streams, a ParamArray of 4-by-4
 * matrices and a Skin and skins the vertices in its streams storing the results
 * in bound output streams.
 *
 * Note: Extends StreamBank, which keeps track of storing vertexStreams objects.
 * The C++ Plugin had this inherit from VertexSource, but reading through the
 * code, I can't find any good reason why.
 *
 * @constructor
 * @extends {o3d.StreamBank}
 */
o3d.SkinEval = function() {
  o3d.StreamBank.call(this);

  /**
   * The base matrix to subtract from the matrices before skinning.
   * @type {!Array<!Array<number>>}
   */
  this.base = [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];

  /**
   * Temporary storage for matrix ops.
   * @type {!Array<!Array<number>>}
   * @private
   */
  this.temp_matrix_ = [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];

  /**
   * Array of matrices representing each bone.
   * @type {!Array<!Array<!Array<number>>>}
   * @private
   */
  this.bones_ = [];

  /**
   * Float32 array containing all matrices in 3x4 format.
   * @type {Float32Array}
   * @private
   */
  this.bone_array_ = null;

  /**
   * Cache of StreamInfo objects for input values. Saved to avoid reallocating.
   * @type {!Array<o3d.SkinEval.StreamInfo>}
   * @private
   */
  this.input_stream_infos_ = [];

  /**
   * Cache of StreamInfo objects for output values. Saved to avoid reallocating.
   * @type {!Array<o3d.SkinEval.StreamInfo>}
   * @private
   */
  this.output_stream_infos_ = [];

  /**
   * The base matrix to subtract from the matrices before skinning.
   *
   * @type {ParamArray}
   * @private
   */
  this.createParam("boneToWorld3x4", "ParamParamArrayOutput");

  this.usingSkinShader = 0.0;
};
o3d.inherit('SkinEval', 'StreamBank');

/**
 * The base matrix to subtract from the matrices before skinning.
 *
 * @type {!Array<!Array<number>>}
 */
o3d.ParamObject.setUpO3DParam_(o3d.SkinEval, "base", "ParamMatrix4");

/**
 * Non-zero if we are using a shader for skinning.
 *
 * Holds state of whether the boneToWorld3x4 uniform is being used. If its
 * value has been read, copy over the original vertex buffers, else we
 * assume the shader does not support skinning.
 *
 * Do not write to this value. Set disableShader to true instead.
 *
 * @type {number}
 * @see disableShader
 */
o3d.ParamObject.setUpO3DParam_(o3d.SkinEval, "usingSkinShader", "ParamFloat");

/**
 * Set this value to true to force skin not to use a shader.
 *
 * @type {boolean}
 * @default false
 */
o3d.ParamObject.setUpO3DParam_(o3d.SkinEval, "disableShader", "ParamBoolean");

/**
 * The Skin to use for skinning.
 * @type {Skin}
 */
o3d.ParamObject.setUpO3DParam_(o3d.SkinEval, "skin", "ParamSkin");

/**
 * The array of matrices to use for skinning.
 * @type {ParamArray}
 */
o3d.ParamObject.setUpO3DParam_(o3d.SkinEval, "matrices", "ParamArray");

/**
 * Skins use 3 vec4's per matrix, since the last row is redundant.
 * If we don't know, 32 is safe minimum value required by standard = (128-32)/3.
 * @param {!o3d.NamedObject} obj Some object with access to gl.
 * @return {number} Maximum number of bones allowed for shader-based skinning.
 */
o3d.SkinEval.getMaxNumBones = function(obj) {
  // Quote from spec:
  // GL_MAX_VERTEX_UNIFORM_VECTORS
  // params returns one value, the maximum number of four-element
  // floating-point, integer, or boolean vectors that can be held in
  // uniform variable storage for a vertex shader.
  // The value must be at least 128. See glUniform.
  var gl = obj.gl;
  var maxVertexUniformVectors = gl.getParameter(gl.MAX_VERTEX_UNIFORM_VECTORS);
  return Math.floor((maxVertexUniformVectors - 32) / 3);
};

/**
 * Someone bound a stream to this SkinEval. Enable the shader on the primitive,
 * and bind any additional weights or indices streams if necessary.
 *
 * @param {o3d.VertexSource} dest VertexSource that bound to this VertexSource.
 * @param {o3d.ParamVertexBufferStream} dest_param Other param which was bound.
 * @override
 */
o3d.SkinEval.prototype.streamWasBound_ = function(
    dest, semantic, semantic_index) {
  this.skin.updateVertexShader();

  if (this.skin.weights_field_ && this.skin.matrix_indices_field_) {
    var weights_stream = dest.getVertexStream(o3d.Stream.INFLUENCE_WEIGHTS, 0);
    var indices_stream = dest.getVertexStream(o3d.Stream.INFLUENCE_INDICES, 0);
    if (!weights_stream || !indices_stream ||
        weights_stream.field != this.skin.weights_field_ ||
        indices_stream.field != this.skin.matrix_indices_field_) {
      dest.setVertexStream(o3d.Stream.INFLUENCE_WEIGHTS, 0,
          this.skin.weights_field_, 0);
      dest.setVertexStream(o3d.Stream.INFLUENCE_INDICES, 0,
          this.skin.matrix_indices_field_, 0);
    }

    var destParam = dest.getParam("boneToWorld3x4");
    if (!destParam) {
      destParam = dest.createParam("boneToWorld3x4", "ParamParamArray");
    }
    destParam.bind(this.getParam("boneToWorld3x4"));

    destParam = dest.getParam("usingSkinShader");
    if (!destParam) {
      destParam = dest.createParam("usingSkinShader", "ParamFloat");
    }
    destParam.bind(this.getParam("usingSkinShader"));
  }
};

/**
 * Multiplies input by weight, and adds with and returns into output.
 *
 * @param {!Array<!Array<number>>} input Input matrix4 to weight.
 * @param {number} weight Amount to weight input matrix by.
 * @param {!Array<!Array<number>>} output The result of computing
 *     output += (input * weight)
 * @private
 */
o3d.SkinEval.prototype.multiplyAdd_ = function(input, weight, output) {
  var a0 = input[0];
  var a1 = input[1];
  var a2 = input[2];
  var a3 = input[3];
  var b0 = output[0];
  var b1 = output[1];
  var b2 = output[2];
  var b3 = output[3];
  b0[0] += a0[0] * weight;
  b0[1] += a0[1] * weight;
  b0[2] += a0[2] * weight;
  b0[3] += a0[3] * weight;
  b1[0] += a1[0] * weight;
  b1[1] += a1[1] * weight;
  b1[2] += a1[2] * weight;
  b1[3] += a1[3] * weight;
  b2[0] += a2[0] * weight;
  b2[1] += a2[1] * weight;
  b2[2] += a2[2] * weight;
  b2[3] += a2[3] * weight;
  b3[0] += a3[0] * weight;
  b3[1] += a3[1] * weight;
  b3[2] += a3[2] * weight;
  b3[3] += a3[3] * weight;
};

/**
 * Initializes all the input and output streams for this mesh, but does no
 * copying yet. You should follow with uninitStreams_ when you are done.
 *
 * @param {o3d.Skin} skin The skin.
 * @private
 */
o3d.SkinEval.prototype.initStreams_ = function(skin) {
  var ii, jj, ll, num_streams;

  var num_vertices = this.skin.influences.length;
  // Update our inputs, lock all the inputs and outputs and check that we have
  // the same number of vertices as vertex influences.
  for (ii = 0, num_streams = 0; ii < this.vertex_streams_.length; ++ii) {
    var array = this.vertex_streams_[ii];
    if (array) {
      for (jj = 0; jj < array.length; ++jj, ++num_streams) {
        var source_param = array[jj];

        // Make sure our upstream streams are ready
        var input = source_param.inputConnection;
        if (input && input.isAClassName("ParamVertexBufferStream")) {
          input.owner_.updateStreams();  // will automatically mark us as valid.
        } else {
          // Mark source_param as valid so we don't evaluate a second time.
          // TODO(pathorn): Caching previous computed values.
        }

        var source_stream = source_param.stream;
        if (source_stream.getMaxVertices_() != num_vertices) {
          // TODO: Change semantic below to semantic_name.
          this.gl.client.error_callback("SkinEval.doSkinning_: "
              + "stream " + source_stream.semantic + " index "
              + source_stream.semanticIndex + " in SkinEval '" + this.name
              + " does not have the same number of vertices as Skin '"
              + skin.name + "'");
          return;
        }

        // Lock this input.
        if (!this.input_stream_infos_[num_streams]) {
          this.input_stream_infos_[num_streams] = new o3d.SkinEval.StreamInfo;
        }
        if (!this.input_stream_infos_[num_streams].init(source_stream, false)) {
          var buffer_name;
          if (source_stream.field.buffer) {
            buffer_name = source_stream.field.buffer.name;
          }
          this.gl.client.error_callback("SkinEval.doSkinning_: "
              + "unable to lock buffer '" + buffer_name
              + " used by stream " + source_stream.semantic + " index "
              + source_stream.semanticIndex + " in SkinEval '" + this.name
              + "'");
          return;
        }

        // Lock the outputs to this input.
        var outputs = source_param.outputConnections; //ParamVector
        if (!this.output_stream_infos_[num_streams]) {
          this.output_stream_infos_[num_streams] = [];
        }
        var output_stream_info = this.output_stream_infos_[num_streams];
        output_stream_info.length = outputs.length;

        for (ll = 0; ll < outputs.length; ++ll) {
          var destination_param = outputs[ll];
          if (destination_param.isAClassName('ParamVertexBufferStream')) {
            // Mark destination_param valid so we don't evaluate a second time.
            // TODO(pathorn): Caching previous computed values.
          } else {
            this.gl.client.error_callback("SkinEval.doSkinning: "
                + destination_param.className + " not ParamVertexBufferStream");
          }
          var destination_stream = destination_param.stream;
          if (destination_stream.getMaxVertices_() != num_vertices) {
            this.gl.client.error_callback("SkinEval.doSkinning_: "
                + "stream " + destination_stream.semantic + " index "
                + destination_stream.semanticIndex + " targeted by SkinEval '"
                + this.name + " does not have the same number of vertices as "
                + "Skin '" + skin.name + "'");
            return;
          }

          if (!output_stream_info[ll]) {
            output_stream_info[ll] = new o3d.SkinEval.StreamInfo;
          }
          if (!output_stream_info[ll].init(destination_stream,true)) {
            var buffer_name;
            if (destination_stream.field.buffer) {
              buffer_name = destination_stream.field.buffer.name;
            }
            this.gl.client.error_callback("SkinEval.doSkinning_: "
                + "unable to lock buffer '" + buffer_name
                + " used by stream " + destination_stream.semantic + " index "
                + destination_stream.semanticIndex + " targeted by SkinEval '"
                + this.name + "'");
            return;
          }
        }
      }
    }
  }

  this.input_stream_infos_.length = num_streams;
  this.output_stream_infos_.length = num_streams;
};

/**
 * Saves the result of the skinning operation in the graphics hardware.
 *
 * @private
 */
o3d.SkinEval.prototype.uninitStreams_ = function() {
  // Unlock any buffers that were locked during skinning
  for (ii = 0; ii < this.input_stream_infos_.length; ++ii) {
    this.input_stream_infos_[ii].uninit();
  }
  for (ii = 0; ii < this.output_stream_infos_.length; ++ii) {
    var output_streams = this.output_stream_infos_[ii];
    for (var jj = 0; jj < output_streams.length; ++jj) {
      output_streams[jj].uninit();
    }
  }
};

/**
 * Does skinning in software. Performs the actual matrix-point mulitplications
 * and saves the result in all the output streams.
 *
 * @private
 */
o3d.SkinEval.prototype.doSkinning_ = function() {
  this.initStreams_();

  var ii, jj, ll;
  var influences_array = this.skin.influences;
  var num_vertices = influences_array.length;

  for (ii = 0; ii < num_vertices; ++ii) {
    var influences = influences_array[ii];
    if (influences.length) {
      // Even are vertices, odd are weights
      var this_matrix_index = influences[0];
      // Get the first matrix.
      var this_weight = influences[1];

      // combine the matrixes for this vertex.
      var accumulated_matrix =
          [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]];
      this.multiplyAdd_(this.bones_[this_matrix_index],
          this_weight, accumulated_matrix);
      var num_influences = influences.length;
      for (jj = 2; jj < num_influences; jj+=2) {
        var influence_matrix_index = influences[jj];
        var influence_weight = influences[jj + 1];
        this.multiplyAdd_(this.bones_[influence_matrix_index],
            influence_weight, accumulated_matrix);
      }

      // for each source, compute and copy to destination.
      for (jj = 0; jj < this.input_stream_infos_.length; ++jj) {
        var input_stream_info = this.input_stream_infos_[jj];
        input_stream_info.compute_function_(accumulated_matrix);
        var output_streams = this.output_stream_infos_[jj];
        var num_output_streams = output_streams.length;
        for (ll = 0; ll < num_output_streams; ++ll) {
          output_streams[ll].copy_function_(input_stream_info);
        }
      }
    }
  }

  this.uninitStreams_();
};

/**
 * Updates the bones from this.matrices.
 *
 * @private
 */
o3d.SkinEval.prototype.updateBones_ = function() {
  // Get our matrices.
  var param_array = this.matrices;
  if (!param_array) {
    this.gl.client.error_callback("SkinEval.updateBones_: "
        + "no matrices for SkinEval '" + this.name + "'");
    return;
  }

  var the_skin = this.skin;
  if (!the_skin) {
    this.gl.client.error_callback("SkinEval.updateBones_: "
        + "no skin specified in SkinEval '" + this.name + "'");
    return;
  }

  // Make sure the bone indices are in range.
  if (the_skin.getHighestMatrixIndex() >= param_array.length) {
    this.gl.client.error_callback("SkinEval.updateBones_: "
        + "skin '" + the_skin.name + " specified in SkinEval '"
        + this.name
        + "' references matrices outside the valid range in ParamArray '"
        + param_array.name + "'");
    return;
  }

  // Make sure the bind pose array size matches the matrices
  var inverse_bind_pose_array = the_skin.inverseBindPoseMatrices;
  if (inverse_bind_pose_array.length != param_array.length) {
    this.gl.client.error_callback("SkinEval.updateBones_: "
        + "skin '" + the_skin.name + " specified in SkinEval '"
        + this.name + "' and the ParamArray '"
        + param_array.name + "' do not have the same number of matrices.");
    return;
  }

  // Get the inverse of our base to remove from the bones.
  var inverse_base = this.temp_matrix_;
  o3d.Transform.inverse(this.base, inverse_base);

  for (var ii = 0; ii < param_array.length; ++ii) {
    var param = param_array.getParam(ii); // ParamMatrix4
    if (!param) {
      this.gl.client.error_callback("SkinEval.updateBones_: "
          + "In SkinEval '" + this.name + "' param at index " + ii
          + " in ParamArray '" + param_array.name
          + " is not a ParamMatrix4");
      return;
    }
    this.bones_[ii] = [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]];
    o3d.Transform.compose(param.value, inverse_bind_pose_array[ii],
                          this.bones_[ii]);
    o3d.Transform.compose(inverse_base, this.bones_[ii], this.bones_[ii]);
  }
};

/**
 * Updates the VertexBuffers bound to streams on this VertexSource.
 */
o3d.SkinEval.prototype.updateStreams = function() {
  if (this.disableShader || !this.usingSkinShader ||
      !this.skin.updateVertexShader()) {
    this.updateBones_();
    this.doSkinning_(this.skin);
    this.usingSkinShader = 0.0;
  }
};

/**
 * Should be called on boneToWorld3x4's get value.
 * Updates ParamArray for bones uniform sent to vertex shader.
 *
 * @param {ParamParamArrayOutput} param The array uniform parameter to update.
 * @return {ParamArray} The array containing all of the float4 params.
 */
o3d.SkinEval.prototype.updateOutputs = function(param) {
  this.updateBones_();
  if (!this.bone_array_) {
    this.bone_array_ = new o3d.ParamArray;
    this.bone_array_.gl = this.gl;
    var max_num_bones = o3d.SkinEval.getMaxNumBones(this);
    this.bone_array_.resize(max_num_bones * 3, "ParamFloat4");
    param.value = this.bone_array_;
  }
  var boneArray = this.bone_array_;
  var ii, jj;
  if (!this.disableShader && this.skin.updateVertexShader()) {
    // Is this the first time the param has been read?
    if (!this.usingSkinShader) {
      // If so, we disable skinning in software.
      this.usingSkinShader = 1.0;
      // Copy the default positions of all vertex buffers.
      this.initStreams_();
      var num_vertices = this.skin.influences.length;
      for (ii = 0; ii < this.input_stream_infos_.length; ++ii) {
        var input_stream_info = this.input_stream_infos_[ii];
        var output_streams = this.output_stream_infos_[ii];
        for (jj = 0; jj < output_streams.length; ++jj) {
          var values = input_stream_info.field_.getAt(0, num_vertices);
          output_streams[jj].field_.setAt(0, values);
        }
      }
      this.uninitStreams_();
    }
    var row;
    for (ii = 0; ii < this.bones_.length; ++ii) {
      var bone = this.bones_[ii];
      row = boneArray.getParam(ii*3);
      row.value[0] = bone[0][0];
      row.value[1] = bone[1][0];
      row.value[2] = bone[2][0];
      row.value[3] = bone[3][0];
      row = boneArray.getParam(ii*3 + 1);
      row.value[0] = bone[0][1];
      row.value[1] = bone[1][1];
      row.value[2] = bone[2][1];
      row.value[3] = bone[3][1];
      row = boneArray.getParam(ii*3 + 2);
      row.value[0] = bone[0][2];
      row.value[1] = bone[1][2];
      row.value[2] = bone[2][2];
      row.value[3] = bone[3][2];
    }
  }
  return boneArray;
};

/**
 * This class helps manage each stream. Because allocating memory is slow we
 * keep these around across calls and reuse them in place by calling init.
 *
 * @param {o3d.Stream} stream
 * @param {o3d.Buffer.AccessMode} access_mode
 * @constructor
 * @private
 */
o3d.SkinEval.StreamInfo = function() {
  this.compute_function_ = null;
  this.copy_function_ = null;
  this.result_ = null;
  this.field_ = null;
  this.values_ = null;
  this.buffer_ = null;
  this.index_ = 0;
  this.writable_ = false;
};


/**
 * Initialize this StreamInfo object from the given Stream.
 *
 * @param {o3d.Stream} stream Stream to lock.
 * @param {boolean} access_mode true if writable, false otherwise.
 * @return {boolean} True if the buffer lock was successful, false if error.
 */
o3d.SkinEval.StreamInfo.prototype.init = function(stream, access_mode) {
  if (this.values_ || this.buffer_) {
    return false;
  }
  var field = stream.field;
  var buffer = field.buffer;
  // field must be a FloatField, but in o3d-webgl, Field is the same type so
  // we can't check isAClassName.
  if (!buffer) {
    return false;
  }
  switch (field.numComponents) {
    case 3:
      this.copy_function_ = this.copyFloat3;
      this.compute_function_ = (stream.semantic == o3d.Stream.POSITION) ?
          this.computeFloat3AsPoint3 : this.computeFloat3AsVector3;
      break;
    case 4:
      this.compute_function_ = this.computeFloat4AsVector4;
      this.copy_function_ = this.copyFloat4;
      break;
    default:
      return false;
  }

  buffer.lock();
  this.field_ = field;
  this.buffer_ = buffer;
  this.values_ = buffer.array_;
  this.index_ = this.field_.offset_;
  this.writable_ = access_mode;
  this.stride_ = buffer.totalComponents;
  return true;
};

/**
 * Uninitialize this StreamInfo object, and unlock the stream.
 * Can be reused for another init() call.
 */
o3d.SkinEval.StreamInfo.prototype.uninit = function() {
  if (this.buffer_) {
    if (this.writable_) {
      this.buffer_.unlock();
    }
    this.buffer_ = null;
    this.field_ = null;
    this.values_ = null;
  }
};

/**
 * Consumes the next 3 values from this.values_.
 * Multiplies the current value by the matrix and stores it in result_ and
 * advances to the next value.
 *
 * @param {!Array<!Array<number>>} matrix matrix4 to apply to the vector3.
 */
o3d.SkinEval.StreamInfo.prototype.computeFloat3AsVector3 = function(matrix) {
  var ii = this.index_;
  var vec = [this.values_[ii], this.values_[ii + 1], this.values_[ii + 2], 0];
  this.result_ = o3d.Transform.multiplyVector(matrix, vec);
  this.index_ = ii + this.stride_;
};

/**
 * Consumes the next 3 values from this.values_.
 * Multiplies the current value by the matrix and stores it in result_ and
 * advances to the next value.
 *
 * @param {!Array<!Array<number>>} matrix matrix4 to apply to the vector3.
 */
o3d.SkinEval.StreamInfo.prototype.computeFloat3AsPoint3 = function(matrix) {
  var ii = this.index_;
  // TODO: The C++ code just dropped element 3 of the return Vector4, while
  // o3d.Transform.transformPoint divides by the last value to make it 1.
  // Which is the right one to use?
  var point = [this.values_[ii], this.values_[ii + 1], this.values_[ii + 2], 1];
  this.result_ = o3d.Transform.multiplyVector(matrix, point);
  this.index_ = ii + this.stride_;
};

/**
 * Consumes the next 4 this.values_.
 * Multiplies the current value by the matrix and stores it in result_ and
 * advances to the next value.
 *
 * @param {!Array<!Array<number>>} matrix matrix4 to apply to the vector4.
 */
o3d.SkinEval.StreamInfo.prototype.computeFloat4AsVector4 = function(matrix) {
  var ii = this.index_;
  var vec = [this.values_[ii], this.values_[ii + 1], this.values_[ii + 2],
             this.values_[ii + 3]];
  this.result_ = o3d.Transform.multiplyVector(matrix, vec);
  this.index_ = ii + this.stride_;
};

/**
 * Copies the Float3 result_ from source and advances to the next value.
 *
 * @param {!o3d.SkinEval.StreamInfo} source Source StreamInfo to copy from.
 */
o3d.SkinEval.StreamInfo.prototype.copyFloat3 = function(source) {
  var ii = this.index_;
  this.values_[ii] = source.result_[0];
  this.values_[ii+1] = source.result_[1];
  this.values_[ii+2] = source.result_[2];
  this.index_ = ii + this.stride_;
};

/**
 * Copies the Float4 result_ from source and advances to the next value.
 *
 * @param {!o3d.SkinEval.StreamInfo} source Source StreamInfo to copy from.
 */
o3d.SkinEval.StreamInfo.prototype.copyFloat4 = function(source) {
  var ii = this.index_;
  this.values_[ii] = source.result_[0];
  this.values_[ii+1] = source.result_[1];
  this.values_[ii+2] = source.result_[2];
  this.values_[ii+3] = source.result_[3];
  this.index_ = ii + this.stride_;
};

