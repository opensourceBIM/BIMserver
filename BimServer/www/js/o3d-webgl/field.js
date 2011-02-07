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
 * A Field is a base class that manages a set of components in a
 * Buffer of a specific type. Fields are managed by Buffers and can not be
 * directly created. When a Buffer is destroyed or if a Field is removed from a
 * Buffer the Field's buffer property will be set to null.
 * @constructor
 */
o3d.Field = function() {
  o3d.NamedObject.call(this);
};
o3d.inherit('Field', 'NamedObject');

/**
 * The number of components in this field.
 * @type {number}
 */
o3d.Field.prototype.numComponents = 0;


/**
 * The Buffer the field belongs to.
 * @type {o3d.Buffer}
 */
o3d.Field.prototype.buffer = null;


/**
 * The offset of this field in the Buffer.
 * @type {number}
 */
o3d.Field.prototype.offset_ = 0;


/**
 * The size of one element of this field.
 * @type {number}
 */
o3d.Field.prototype.size = 0;


/**
 * Sets the values of the data stored in the field.
 *
 * The buffer for the field  must have already been created either through
 * buffer.set or through buffer.allocateElements.
 *
 * The number of values passed in must be a multiple of the number of
 * components needed for the field.
 *
 * @param {number} start_index index of first value to set.
 * @param {!Array.<number>} values Values to be stored in the buffer starting at
 *     index.
 */
o3d.Field.prototype.setAt =
    function(start_index, values) {
  this.buffer.lock();
  var l = values.length / this.numComponents;
  for (var i = 0; i < l; ++i) {
    for (var c = 0; c < this.numComponents; ++c) {
      this.buffer.array_[
          (start_index + i) * this.buffer.totalComponents + this.offset_ + c] =
              values[this.numComponents * i + c];
    }
  }
  this.buffer.unlock();
  return true;
};


/**
 * Gets the values stored in the field.
 *
 * @param {number} start_index index of the first value to get.
 * @param {number} num_elements number of elements to read from field.
 * @return {!Array.<number>}  The values of the field.
 */
o3d.Field.prototype.getAt =
    function(start_index, num_elements) {
  return this.buffer.getAtHelper_(start_index, num_elements, this.offset_,
      this.numComponents);
};



/**
 * A field that contains floating point numbers.
 * @constructor
 */
o3d.FloatField = function() {
  o3d.Field.call(this);
};
o3d.inherit('FloatField', 'Field');

/**
 * A field that contains unsigned integers.
 * @constructor
 */
o3d.UInt32Field = function() {
  o3d.Field.call(this);
};
o3d.inherit('UInt32Field', 'Field');

/**
 * A field that contains unsigned bytes.
 * @constructor
 */
o3d.UByteNField = function() {
  o3d.Field.call(this);
};
o3d.inherit('UByteNField', 'Field');


