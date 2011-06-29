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
 * A RayIntersectionInfo is used to return the results of ray intersection
 * tests.
 * @constructor
 */
o3d.RayIntersectionInfo = function() {
  o3d.NamedObject.call(this);
  o3d.RayIntersectionInfo.prototype.position = [0, 0, 0];
};
o3d.inherit('RayIntersectionInfo', 'NamedObject');


/**
 * True if this ray intersection info is valid. For example if you call
 * element.intersectRay on an element that has no vertex buffers the result
 * will be invalid.
 * @type {boolean}
 */
o3d.RayIntersectionInfo.prototype.valid = false;


/**
 * True if the origin of the ray is found to be inside the box.
 * @type {boolean}
 */
o3d.RayIntersectionInfo.prototype.inside = false;


/**
 * True if this ray intersection intersected something.
 * @type {boolean}
 */
o3d.RayIntersectionInfo.prototype.intersected = false;



/**
 * The position the ray intersected something.
 * type {!o3d.Point3}
 */
o3d.RayIntersectionInfo.prototype.position = [0, 0, 0];



/**
 * The index of the primitive that was intersected.
 * @type {number}
 */
o3d.RayIntersectionInfo.prototype.primitiveIndex = -1;



