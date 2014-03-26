"use strict"

/**
 * Class: BIMSURFER.Events
 * Event system that can be used for all BIMSURFER classes.
 * Enables the user to register, unregister and trigger events, based on object instances
 */
BIMSURFER.Events = BIMSURFER.Class({
	CLASS: 'BIMSURFER.Events',
	SYSTEM: null,

	listeners: {},
	object: null,

	__construct: function(object) {
		this.object = object;
		this.listeners = {};
	},

	/**
	 * Register an event.
	 *
	 * @param {String} event The event name
	 * @param {Function} callback The callback function that will be fired when the event is triggered
	 * @param {Object} [object] The object that will be used as "this" in the callback function. Defaut = this.object
	 */
	register: function(event, callback, object) {
		if(typeof event != 'string' || typeof callback != 'function') {
			return;
		}

		if(!this.listeners[event]) {
			this.listeners[event] = new Array();
		}
		this.listeners[event].push({object: (!BIMSURFER.Util.isset(object) ? this.object : object), callback: callback});
	},

	/**
	 * Unregister a registered event
	 *
	 * @param {String} event The event name
	 * @param {Function} callback The callback function that would be called when teh event was triggered
	 * @param {Object} [object] The object that would be used as "this" in the callback function. Default = this.object
	 */
	unregister: function(event, callback, object) {
		if(typeof event != 'string' || typeof callback != 'function') {
			return;
		}

		object = (!BIMSURFER.Util.isset(object) ? this.object : object);

		if(this.listeners[event]) {
			for(var i = 0; i < this.listeners[event].length; i++) {
				if(this.listeners[event][i].object == object && this.listeners[event][i].callback == callback) {
					this.listeners[event].splice(i, 1);
					break;
				}
			}
		}
	},

	/**
	 * Trigger an event
	 *
	 * @param {String} event The event name
	 * @param {Array} [eventArguments] The parameters that will be passed to the registered callback function(s)
	 * @param {Object} [object] The object that will be used as "this" in the callback function instead of the preset one.
	 * @return success
	 */
	trigger: function(event, eventArguments, object) {
		if(typeof event != 'string') {
			return false;
		}
		eventArguments = eventArguments || new Array();
		if(!BIMSURFER.Util.isset(eventArguments)) {
			eventArguments = new Array();
		} else if(!BIMSURFER.Util.isArray(eventArguments)) {
			eventArguments = [eventArguments];
		}

		if(event.substring(0, 5).toLowerCase() == 'mouse') {
			eventArguments[0] = this.normalizeEvent(eventArguments[0]);
		}

		if(!this.listeners[event] || this.listeners[event].length == 0) {
			return true;
		}

		var listeners = this.listeners[event].slice(0);

		for(var i = 0; i < listeners.length; i++) {
			var continueEvent = null;
			if(BIMSURFER.Util.isset(object)) {
				continueEvent = listeners[i].callback.apply(object, eventArguments);
			} else {
				continueEvent = listeners[i].callback.apply(listeners[i].object, eventArguments);
			}

			if(continueEvent === false) {
				return false;
			}
		}
		return true;
	},

	/**
	 * Normalize mouse/touch events for browser compability
	 *
	 * @param {Event} event The event to be normalized
	 * @return event
	 */
	normalizeEvent: function(event) {
		if(!event.offsetX) {
			event.offsetX = (event.pageX - jQuery(event.target).offset().left);
			event.offsetY = (event.pageY - jQuery(event.target).offset().top);
		}
		return event;
	}
});