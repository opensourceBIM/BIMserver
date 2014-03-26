"use strict"

/**
 * Class: BIMSURFER.ProgressLoader
 * A class to manage the BIMServer progress.
 * Can register progress listeners on the server for long running actions
 */
BIMSURFER.ProgressLoader = BIMSURFER.Class({
	CLASS: 'BIMSURFER.Class',
	SYSTEM: null,

	server: null,
	laid: null,
	step: null,
	done: null,
	autoUnregister: null,
	registered: null,

	/**
	 * @constructor
	 * @param {BIMSURFER.Viewer instance} system The viewer instance
	 * @param {BimServerAPI instance} server The API provided by a connected BIMServer
	 * @param {Number} laid The Long-running Action ID, provided by the BIMServer
	 * @param {Function} step The callback function for everey progress response by the server
	 * @param {Function done The callback function that will be fired when the server gives a STATE == Finished
	 * @param {Boolean} [autoUnregister] Should it automatically unregister the progress listener on the server?
	 */

	__construct: function(system, server, laid, step, done, autoUnregister) {
		this.SYSTEM = system;
		this.server = server;
		this.laid = laid;
		this.step = step;
		this.done = done;
		this.autoUnregister = autoUnregister;
		this.registered = false;

		var _this = this;
		var registering = true;

		this.responseHandler = function(topicId, state) {
			if(!_this.registered && !registering) {
				return;
			}
			_this.registered = true;
			_this.progressHandler.apply(_this, [topicId, state]);
		};

		this.server.registerProgressHandler(this.laid, this.responseHandler, function() {
			_this.registered = true; registering = false;
		});
	},

	unregister: function() {
		var _this = this;
		this.server.unregisterProgressHandler(this.laid, this.responseHandler);
		this.registered = false;
	},

	responseHandler: null,

	progressHandler: function(topicId, state) {
		if(state.state == "FINISHED") {
			if(this.autoUnregister && this.registered) {
				this.unregister();
			}
			this.done(state, this);
		} else {
			this.step(state, this);
		}
	}
});
