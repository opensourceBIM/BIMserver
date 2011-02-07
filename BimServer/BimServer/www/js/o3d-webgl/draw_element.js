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
 * A DrawElement causes an Element to be Drawn with a particular material.
 * You can override other Effect parameters by adding corresponding params to
 * the DrawElement.
 *
 * @param {!o3d.Material} opt_material The material used to render this element.
 * @constructor
 */
o3d.DrawElement = function(opt_material) {
  o3d.ParamObject.call(this);

  /**
   * The Material for this DrawElement. If it is null the material of
   * owner will be used.
   * @type {o3d.Material}
   */
  this.material = opt_material || null;

  /**
   * The current owner of this Draw Element. Set to null to stop being owned.
   *
   * Note: DrawElements are referenced by the Pack they are created in
   * and their owner. If the DrawElement is removed from its Pack then
   * setting the owner to null will free the DrawElement. Or, visa
   * versa, if you set the DrawElement's owner to null then removing
   * it from its Pack will free the DrawElement.
   * @type {o3d.Element}
   */
  this.owner_ = null;
};
o3d.inherit('DrawElement', 'ParamObject');

o3d.ParamObject.setUpO3DParam_(o3d.DrawElement, 'material', 'ParamMaterial');

