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
 * A StateSet is a render node that sets render states of all of its
 * children. You can make this a parent of a part of the render graph to set
 * render states in a more global way.
 *
 * @param {o3d.State} opt_state The State the defines what states to set.
 * @constructor
 */
o3d.StateSet = function(opt_state) {
  o3d.RenderNode.call(this);

  /**
   * The State for this StateSet.
   * @type {o3d.State}
   */
  this.state = opt_state || null;
};
o3d.inherit('StateSet', 'RenderNode');

o3d.ParamObject.setUpO3DParam_(o3d.StateSet, 'state', 'ParamState');

/**
 * Sets the current state to the member state.
 */
o3d.StateSet.prototype.before = function() {
  if (this.state) {
    this.state.push_();
  }
};

/**
 * Sets the current state to the member state.
 */
o3d.StateSet.prototype.after = function() {
  if (this.state) {
    this.state.pop_();
  }
};
