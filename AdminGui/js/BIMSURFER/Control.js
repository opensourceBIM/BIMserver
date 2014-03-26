"use strict"

/**
 * Class: BIMSURFER.Control
 * Controls affect the behavior of the viewer.
 * They allow everything from zooming, panning and navigating to selecting en showing an object tree.
 * Controls can be added to a Viewer. Some controls need a div to be binded to.
 *
 * Example:
 * The following example shows how to add controls to a viewer
 *
 * > var viewer = new BIM.Viewer('viewport');
 * > var panOrbit = new BIMSURFER.Control.PickFlyOrbit();
 * > viewer.addControl(panOrbit);
 * > panOrbit.activate();
 * >
 * > var clickSelect = new BIMSURFER.Control.ClickSelect();
 * > clickSelect.events.register('select', nodeSelected);
 * > clickSelect.events.register('unselect', nodeUnselected);
 * > viewer.addControl(clickSelect);
 * > clickSelect.activate();
 */
BIMSURFER.Control = BIMSURFER.Class({
	CLASS: 'BIMSURFER.Control',

	/**
	 * BIMSURFER.Viewer instance
	 */
	SYSTEM: null,

	/**
	 * The DIV element containing the control
	 */
	div: null,

	/**
	 * The DOM element of the control (drawn by the function redraw)
	 */
	DOMelement: null,

	/**
	 * Is the control active?
	 */
	active: false,

	/**
	 * BIMSURFER.Events instance. The events meganism of this control
	 */
	events: null,

	/**
	 * Default constructor for the controls
	 *
	 * @constructor
	 * @param {string|DOMelement} div ID or reference to a div
	 */
	__construct: function(div) {
		if(typeof div == 'string') {
			this.div = jQuery(document).find('div#' + div)[0] || null;
		} else if(jQuery(div).is('div')) {
			this.div = div;
		}

		this.events = new BIMSURFER.Events(this);
	},

	/**
	 * Default function to redraw the control
	 * @return this
	 */
	redraw: function() {
		jQuery(this.div).empty();
		jQuery(this.DOMelement).remove();
		this.DOMelement = jQuery('<div />').addClass(this.CLASS.replace(/\./g,"-"));
		if(this.active) {
			jQuery(this.div).append(this.DOMelement);
		}
		return this;
	},

	/**
	 * Default function to set the parent viewer
	 *
	 * @param {BIMSURFER.Viewer} viewer The viewer the control is working for
	 * @return this
	 */
	setViewer: function(viewer) {
		if(this.active) {
			this.deactivate();
		}
		this.SYSTEM = viewer;
		return this;
	},

	/**
	 * Default function to remove the control from the viewer
	 * Sets the this.SYSTEM to null
	 *
	 * @return this
	 */
	removeFromSurfer: function() {
		this.SYSTEM = null;
		return this;
	},

	/**
	 * Default function to initialize the control events
	 *
	 * @return this
	 */
	initEvents: function() {
		return this;
	},


	/**
	 * Default function to activate the control
	 *
	 * @return this
	 */
	activate: function() {
		if(this.div) {
			this.active = true;
			this.redraw();
			this.initEvents();
			this.show();
		}
		this.events.trigger('activated');
		return this;
	},

	/**
	 * Default function to activate the control when the scene is loaded
	 *
	 * @return this
	 */
	activateWhenReady: function() {
		if(this.SYSTEM.sceneLoaded) {
			this.activate();
		} else {
			var _this = this;
			var sceneLoaded = function() {
				_this.SYSTEM.events.unregister('sceneLoaded', sceneLoaded);
				_this.activate();
			}
			this.SYSTEM.events.register('sceneLoaded', sceneLoaded);
		}
		return this;
	},

	/**
	 * Default function to deactivate the control
	 *
	 * @return this
	 */
	deactivate: function() {
		this.active = false;
		this.initEvents();
		jQuery(this.DOMelement).remove();
		this.DOMelement = null;
		this.events.trigger('deactivated');
		return this;
	},

	/**
	 * Default function to show the control
	 *
	 * @param {String} [speed] The speed of the animation ('fast', 'normal' or 'slow'). Leave empty for no animation
	 * @return this
	 */
	show: function(speed) {
		switch(speed) {
			case 'fast':
			case 'normal':
			case 'slow':
				jQuery(this.DOMelement).stop().fadeIn(speed);
				break;
			default:
				jQuery(this.DOMelement).stop().show();
		}
		return this;
	},

	/**
	 * Default function to hide the control
	 *
	 * @param {String} [speed] The speed of the animation ('fast', 'normal' or 'slow'). Leave empty for no animation
	 * @return this
	 */
	hide: function(speed) {
		switch(speed) {
			case 'fast':
			case 'normal':
			case 'slow':
				jQuery(this.DOMelement).stop().fadeOut(speed);
				break;
			default:
				jQuery(this.DOMelement).stop().hide();
		}
		return this;
	}
});