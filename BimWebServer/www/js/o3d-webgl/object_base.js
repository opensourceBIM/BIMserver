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
 * A ObjectBase is a base class that manages a set of components in a
 * Buffer of a specific type. ObjectBases are managed by Buffers and can
 * not be directly created. When a Buffer is destroyed or if a ObjectBase
 * is removed from a Buffer the ObjectBase's buffer property will be set
 * to null.
 */
o3d.ObjectBase = function() { };


/**
 * Used by isAClassName.
 * @type {string}
 */
o3d.ObjectBase.prototype.className = 'o3d.ObjectBase';

/**
 * @type {o3d.ObjectBase}
 */
o3d.ObjectBase.prototype.superClass = null;

/**
 * Traverses the current object's class and all its superclasses and
 * determines if any of them are of the given name.
 * @param {string} class_type_name The name of a class.
 * @return {boolean} Whether this is counts as a className.
 */
o3d.ObjectBase.prototype.isAClassName = function(class_type_name) {
  class_type_name = o3d.filterTypeName_(class_type_name);
  var object = this;
  while (object != undefined) {
    if (object.className == class_type_name) {
      return true;
    }
    object = object.superClass && object.superClass.prototype;
  }
  return false;
};


