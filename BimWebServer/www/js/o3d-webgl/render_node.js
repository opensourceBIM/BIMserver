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
 * RenderNode is the base of all RenderNodes in the render graph.
 * RenderNodes are rendered in order of priority.
 *
 * @param {number} opt_priority The priority of this render node. Lower
 *     priorities are rendered first.
 * @param {boolean} opt_active If true this node is processed. If false
 *     it is not.
 * @constructor
 */
o3d.RenderNode = function(opt_priority, opt_active) {
  o3d.ParamObject.call(this);

  /**
   * Sets the priority of this render node. lower priorities are
   * rendered first.
   *
   * @type {number}
   */
  this.priority = opt_priority || 0;

  /**
   * The immediate children of this RenderNode.
   *
   * Each access to this field gets the entire list so it is best to get it
   * just once. For example:
   *
   * var children = renderNode.children;
   * for (var i = 0; i < children.length; i++) {
   *   var child = children[i];
   * }
   *
   * Note that modifications to this array [e.g. push()] will not affect
   * the underlying RenderNode, while modifications to the array's members
   * will affect them.
   *
   * @type {!Array.<o3d.RenderNode>}
   */
  this.children = [];

  /**
   * Setting false skips this render node. Setting true processes this render
   * node. (ie, renders whatever it's supposed to render)
   *
   * @type {boolean}
   */
  this.active = opt_active || true;

  /**
   * Sets the parent of the node by re-parenting the node under parent_node.
   * Setting parent_node to null removes the node and the entire subtree below
   * it from the render graph.
   *
   * @type {o3d.RenderNode}
   */
  this.parent = null;
};
o3d.inherit('RenderNode','ParamObject');

o3d.ParamObject.setUpO3DParam_(o3d.RenderNode, 'priority', 'ParamFloat');
o3d.ParamObject.setUpO3DParam_(o3d.RenderNode, 'active', 'ParamBoolean');

o3d.RenderNode.prototype.__defineSetter__('parent',
    function(p) {
      if (this.parent_) {
        this.parent_.removeChild(this);
      }
      this.parent_ = p;
      if (this.parent_) {
        if (!this.parent_.addChild) {
          throw ('Parent of render node must be render node or null.');
        }
        this.parent_.addChild(this);
      }
    }
);

o3d.RenderNode.prototype.__defineGetter__('parent',
    function(p) {
      return this.parent_;
    }
);

/**
 * Adds a child node.
 * @param {o3d.RenderNode} child The child to add.
 */
o3d.RenderNode.prototype.addChild = function(child) {
  this.children.push(child);
};


/**
 * Removes a child node.
 * @param {o3d.RenderNode} child The child to add.
 */
o3d.RenderNode.prototype.removeChild = function(child) {
  o3d.removeFromArray(this.children, child);
};


/**
 * Returns this render node and all its descendants. Note that this render node
 * might not be in the render graph.
 *
 * Note that modifications to this array [e.g. push()] will not affect
 * the underlying RenderNode, while modifications to the array's members
 * will affect them.
 *
 * An array containing all render nodes of the subtree.
 */
o3d.RenderNode.prototype.getRenderNodesInTree =
    function() {
  o3d.notImplemented();
};



/**
 * Searches for render nodes that match the given name in the hierarchy under
 * and including this render node. Since there can be several render nodes
 * with a given name the results are returned in an array.
 *
 * Note that modifications to this array [e.g. push()] will not affect
 * the underlying RenderNode, while modifications to the array's members
 * will affect them.
 *
 * @param {string} name Rendernode name to look for.
 * @return {Array.<!o3d.RenderNode>}  An array containing all nodes among
 *     this node and its decendants that have the given name.
 */
o3d.RenderNode.prototype.getRenderNodesByNameInTree =
    function(name) {
  o3d.notImplemented();
};


/**
 * Searches for render nodes that match the given class name in the hierarchy
 * under and including this render node.
 *
 * Note that modifications to this array [e.g. push()] will not affect
 * the underlying RenderNode, while modifications to the array's members
 * will affect them.
 *
 * @param {string} class_name class name to look for.
 * @return {Array.<!o3d.RenderNode>}  An array containing all nodes among
 *     this node and its decendants whose type is class_name.
 */
o3d.RenderNode.prototype.getRenderNodesByClassNameInTree =
    function(class_name) {
  o3d.notImplemented();
};


/**
 * Recursively traverses the render graph starting at this node.
 */
o3d.RenderNode.prototype.render = function() {
  function compare(a, b) {
    return a.priority - b.priority;
  }
  this.children.sort(compare);
  var children = this.children;

  this.before();
  for (var i = 0; i < children.length; ++i) {
    children[i].render();
  }
  this.after();
};


/**
 * Called during the rendergraph traversal before the children are rendered.
 */
o3d.RenderNode.prototype.before = function() { };


/**
 * Called during the rendergraph traversal after the children are rendered.
 */
o3d.RenderNode.prototype.after = function() { };


