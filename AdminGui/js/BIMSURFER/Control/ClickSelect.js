"use strict"

/**
 * Class: BIMSURFER.Control.ClickSelect
 * Control to select and hightlight a Scene JS by clicking on it.
 */
BIMSURFER.Control.ClickSelect = BIMSURFER.Class(BIMSURFER.Control, {
	CLASS: "BIMSURFER.Control.ClickSelect",

	/**
	 * X coordinate of the last mouse event
	 */
	downX: null,

	/**
	 * Y coordinate of the last mouse event
	 */
	downY: null,
	
	active: false,

	/**
	 * The selected and highlighted SceneJS node
	 */
	highlighted: null,

	/**
	 * Timestamp of the last selection
	 */
	lastSelected: 0,

	/**
	 * Constructor.
	 *
	 * @constructor
	 */
	__construct: function() {
		this.events = new BIMSURFER.Events(this);
	},

	/**
	 * Activates the contol
	 */
	activate: function() {
		if(this.SYSTEM == null || !this.SYSTEM.sceneLoaded) {
			console.error('Cannot activate ' + this.CLASS + ': Surfer or scene not ready');
			return null;
		}
		if (!this.active) {
			this.active = true;
			this.initEvents();
			this.events.trigger('activated');
		}
		return this;
	},

	/**
	 * Initializes the events necessary for the operation of this control
	 *
	 * @return this
	 */
	initEvents: function() {
		if(this.active) {
			this.SYSTEM.events.register('pick', this.pick, this);
			this.SYSTEM.events.register('mouseDown', this.mouseDown, this);
			this.SYSTEM.events.register('mouseUp', this.mouseUp, this);
		} else {
			this.SYSTEM.events.unregister('pick', this.pick, this);
			this.SYSTEM.events.unregister('mouseDown', this.mouseDown, this);
			this.SYSTEM.events.unregister('mouseUp', this.mouseUp, this);
		}
		return this;
	},

	/**
	 * Event listener
	 *
	 * @param {mouseEvent} e Mouse event
	 */
	mouseDown: function(e) {
		this.downX = e.offsetX;
		this.downY = e.offsetY;
	},

	/**
	 * Event listener
	 *
	 * @param {mouseEvent} e Mouse event
	 */
	mouseUp: function(e) {
		if(((e.offsetX > this.downX) ? (e.offsetX - this.downX < 5) : (this.downX - e.offsetX < 5)) &&	((e.offsetY > this.downY) ? (e.offsetY - this.downY < 5) : (this.downY - e.offsetY < 5))) {
			if(Date.now() - this.lastSelected > 10) {
				this.unselect();
			}
		}
	},

	/**
	 * Event listener
	 *
	 * @param {SceneJS.node} hit Selected SceneJS node
	 */
	pick: function(hit) {
		this.unselect();
		this.highlighted = this.SYSTEM.scene.findNode(hit.nodeId);
		this.highlighted.insert('node', BIMSURFER.Constants.highlightSelectedObject);
		this.lastSelected = Date.now();
		var groupId = this.highlighted.findParentByType("translate").data.groupId;
		this.events.trigger('select', [groupId, this.highlighted]);
	},

	/**
	 * Event listener
	 */
	unselect: function() {
		var node = this.SYSTEM.scene.findNode(BIMSURFER.Constants.highlightSelectedObject.id);
		if(node != null)
		{
			node.splice();
			this.events.trigger('unselect', [this.highlighted == null ? null : this.highlighted.findParentByType("translate").groupId, this.highlighted]);
			this.highlighted = null;
		}
	}
});