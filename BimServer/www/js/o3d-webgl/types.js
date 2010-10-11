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
 * Namespace for math types.
 */
o3d.math = {}


/**
 * An Array of 3 numbers.
 * @type {!Array.<number>}
 */
o3d.math.Point3 = goog.typedef;


/**
 * An Array of 3 numbers.
 * @type {!Array.<number>}
 */
o3d.math.Vector3 = goog.typedef;


/**
 * An Array of 2 numbers.
 * @type {!Array.<number>}
 */
o3d.Float2 = goog.typedef;


/**
 * An Array of 3 numbers.
 * @type {!Array.<number>}
 */
o3d.Float3 = goog.typedef;


/**
 * An Array of 4 numbers.
 * @type {!Array.<number>}
 */
o3d.Float4 = goog.typedef;


/**
 * A 4x4 Matrix of numbers.
 * @type {!Array.<!Array.<number>>}
 */
o3d.math.Matrix4 = goog.typedef;

/**
 * An array of 4 numbers.
 * @type {!Array.<number>}
 */
o3d.math.Quat = goog.typedef;


/**
 * A function.
 * @type {Object}
 */
o3d.ErrorCallback = goog.typedef;


/**
 * A function.
 * @type {Object}
 */
o3d.TickCallback = goog.typedef;


/**
 * A function.
 * @type {Object}
 */
o3d.RenderCallback = goog.typedef;


/**
 * A function.
 * @type {Object}
 */
o3d.LostResourcesCallback = goog.typedef;


/**
 * A function.
 * @type {Object}
 */
o3d.EventCallback = goog.typedef;
