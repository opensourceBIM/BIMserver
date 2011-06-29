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
 * A Material holds the various uniform parameters an Effect needs to render.
 * For example a Lambert effect might need "diffuse", "ambient", "emissive".
 * The parameters needed on a Material will vary depending its Effect.
 * Note that a material MUST have its drawList set in order for objects using it
 * to render.
 *
 * @param {!o3d.State} opt_state The State used by this material.
 * @param {!o3d.Effect} opt_effect The Effect used by this material.
 * @param {!o3d.DrawList} opt_draw_list The the DrawList used by this material.
 * @constructor
 */
o3d.Material = function(opt_state, opt_effect, opt_draw_list) {
  o3d.ParamObject.call(this);
  /**
   * The State for this material.
   * @type {o3d.State}
   */
  this.state = opt_state || null;

  /**
   * The Effect for this material.
   * @type {o3d.Effect}
   */
  this.effect = opt_effect || null;

  /**
   * The DrawList this material will render on.
   * @type {o3d.DrawList}
   */
  this.drawList = opt_draw_list || null;
};
o3d.inherit('Material', 'ParamObject');

o3d.ParamObject.setUpO3DParam_(o3d.Material, 'effect', 'ParamEffect');
o3d.ParamObject.setUpO3DParam_(o3d.Material, 'state', 'ParamState');
o3d.ParamObject.setUpO3DParam_(o3d.Material, 'drawList', 'ParamDrawList');

