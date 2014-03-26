"use strict"

/**
 * Class: BIMSURFER.Control.PickFlyOrbit
 * Control to control the main camera of the scene.
 * Allows the user to pan, orbit and zoom-in.
 */
BIMSURFER.Control.PickFlyOrbit = BIMSURFER.Class(BIMSURFER.Control, {
	CLASS: "BIMSURFER.Control.PickFlyOrbit",

	touching: false,
	orbitDragging: false,
	panDragging: false,
	orbiting: false,
	flying: false,
	lastX: null,
	lastY: null,
	downX: null,
	downY: null,

	direction: 1,
	yaw: 0,
	pitch: 0,
	zoom: 0,
	prevZoom: 0,

	lookAt: null,
	startEye: { x: 0, y: 0, z: 0 },
	eye: { x: 0, y: 0, z: 0 },
	look: { x: 0, y: 0, z: 0 },

	startPivot: { x: 0, y: 0, z: 0 },
	endPivot: { x: 0, y: 0, z: 0 },
	currentPivot: { x: 0, y: 0, z: 0 },

	flightStartTime: null,
	flightDuration: null,

	/**
	 * Consturctor
	 *
	 * @constructor
	 * @param {object} params Options
	 */
	__construct: function(params)	{
		this.events = new BIMSURFER.Events(this);
		if(BIMSURFER.Util.isset(params)) {
			this.eye = params.eye || this.eye;
			this.look = params.look || this.look;
			this.zoom = params.zoom || this.zoom;
		}
	},

	/**
	 * Activates the control
	 *
	 * @return this
	 */
	activate: function()
	{
		if(this.SYSTEM == null || !this.SYSTEM.sceneLoaded) {
			console.error('Cannot activate ' + this.CLASS + ': Surfer or scene not ready');
			return null;
		}

		this.lookAt = this.SYSTEM.scene.findNode('main-lookAt');
		this.eye = this.lookAt.getEye();
		this.startEye = this.lookAt.getEye();

		this.look = this.lookAt.getLook();
		this.currentPivot = this.look;
		this.active = true;
		this.initEvents();
		this.events.trigger('activated');
		return this;
	},

	/**
	 * Deactivates the control
	 *
	 * @return this
	 */
	deactivate: function()
	{
		this.active = false;
		this.initEvents();
		this.events.trigger('deactivated');
		return this;
	},

	/**
	 * Initializes the events necessary for the operation of this control
	 *
	 * @return this
	 */
	initEvents: function() {
		if(this.active) {
		  	this.SYSTEM.events.register('mouseDown', this.mouseDown, this);
			this.SYSTEM.events.register('mouseUp', this.mouseUp, this);
			this.SYSTEM.events.register('mouseMove', this.mouseMove, this);
			this.SYSTEM.events.register('mouseWheel', this.mouseWheel, this);
			this.SYSTEM.events.register('DOMMouseScroll', this.mouseWheel, this);
			this.SYSTEM.events.register('touchStart', this.touchStart, this);
			this.SYSTEM.events.register('touchMove', this.touchMove, this);
			this.SYSTEM.events.register('touchEnd', this.touchEnd, this);
			this.SYSTEM.events.register('pick', this.pick, this);
			this.SYSTEM.events.register('tick', this.tick, this);
		} else {
			this.SYSTEM.events.unregister('mouseDown', this.mouseDown, this);
			this.SYSTEM.events.unregister('mouseUp', this.mouseUp, this);
			this.SYSTEM.events.unregister('mouseMove', this.mouseMove, this);
			this.SYSTEM.events.unregister('mouseWheel', this.mouseWheel, this);
			this.SYSTEM.events.unregister('touchStart', this.touchStart, this);
			this.SYSTEM.events.unregister('touchMove', this.touchMove, this);
			this.SYSTEM.events.unregister('touchEnd', this.touchEnd, this);
			this.SYSTEM.events.unregister('pick', this.pick, this);
			this.SYSTEM.events.unregister('tick', this.tick, this);
		}
		return this;
	},

	/**
	 * Event listener for every SceneJS tick
	 */
	tick: function()
	{
		if(this.flying) {
			var timeNow = (new Date()).getTime();

			if(this.flightStartTime == null) {
				this.flightStartTime = timeNow;
			}

			var timeElapsed = timeNow - this.flightStartTime;

			if (timeElapsed >= this.flightDuration) {
				this.flying = false;
				this.flightStartTime = null;
			} else {
				var easedTime = (function(t, b, c, d) {
					var ts = (t /= d) * t;
					var tc = ts * t;
					return b + c * (-1 * ts * ts + 4 * tc + -6 * ts + 4 * t);
				})((timeNow - this.flightStartTime) / this.flightDuration, 0, 1, 1);

				this.currentPivot.x = this.startPivot.x + easedTime * (this.endPivot.x - this.startPivot.x);
				this.currentPivot.y = this.startPivot.y + easedTime * (this.endPivot.y - this.startPivot.y);
				this.currentPivot.z = this.startPivot.z + easedTime * (this.endPivot.z - this.startPivot.z);

				// Need to rotate lookat
				this.orbiting = true;
			}
		}
		if(this.orbiting) {
			var startX = this.startEye.x;
			var startY = this.startEye.y;
			var startZ = this.startEye.z;
			var radius = Math.sqrt(startX*startX + startY*startY + startZ*startZ);

			var startPhi = Math.acos(this.startEye.z/radius);
			var startTheta = Math.asin(this.startEye.y/(radius*Math.sin(startPhi))) + Math.PI;

			var phi = 2*Math.PI - this.pitch * BIMSURFER.Constants.camera.orbitSpeedFactor - startPhi;
			while(phi > 2*Math.PI) phi -= 2 * Math.PI;
			while(phi < 0) phi += 2*Math.PI;
			if(phi < Math.PI && this.direction != -1) {
				this.direction = -1;
				this.lookAt.set('up', {x: 0, y:0, z: -1});
			} else if(phi >= Math.PI && this.direction != 1) {
				this.direction = 1;
				this.lookAt.set('up', {x: 0, y:0, z: 1});
			}


			var theta = 2 * Math.PI - this.yaw * BIMSURFER.Constants.camera.orbitSpeedFactor + startTheta;
			var x = radius * Math.sin(phi) * Math.cos(theta);
			var y = radius * Math.sin(phi) * Math.sin(theta);
			var z = radius * Math.cos(phi);

			var zoomX = x * this.zoom*BIMSURFER.Constants.camera.zoomSpeedFactor;
			var zoomY = y * this.zoom*BIMSURFER.Constants.camera.zoomSpeedFactor;
			var zoomZ = z * this.zoom*BIMSURFER.Constants.camera.zoomSpeedFactor;

	   		if((x >= 0 && zoomX > x) || (x < 0 && zoomX < x) || (y >= 0 && zoomY > y) || (y < 0 && zoomY < y) || (z >= 0 && zoomZ > z) || (z < 0 && zoomZ < z)) {
	  			this.zoom = this.prevZoom;
				zoomX = x * this.zoom*BIMSURFER.Constants.camera.zoomSpeedFactor;
				zoomY = y * this.zoom*BIMSURFER.Constants.camera.zoomSpeedFactor;
				zoomZ = z * this.zoom*BIMSURFER.Constants.camera.zoomSpeedFactor;
	  		}

			x -= zoomX;
			y -= zoomY;
			z -= zoomZ;

			this.prevZoom = this.zoom;

			x += this.currentPivot.x;
			y += this.currentPivot.y;
			z += this.currentPivot.z;

			this.eye = { x: x, y: y, z: z };

			// Update view transform
			this.lookAt.setLook(this.currentPivot);
			this.lookAt.setEye(this.eye);

			this.orbiting = false;
		}
	},

	/**
	 * Event listener
	 *
	 * @param {SceneJS.node} hit Selected SceneJS node
	 */
	pick: function(hit) {
		// Some plugins wrap things in this name to
		// avoid them being picked, such as skyboxes
		if (hit.name == "__SceneJS_dontPickMe") {
			return;
		}

		this.startPivot = {x: this.currentPivot.x, y: this.currentPivot.y, z: this.currentPivot.z};
		this.endPivot = {x: hit.worldPos[0], y: hit.worldPos[1], z: hit.worldPos[2]};
		var dif = {x: this.endPivot.x - this.startPivot.x, y: this.endPivot.y - this.startPivot.y, z: this.endPivot.z - this.startPivot.z};

		var flightDist = Math.sqrt(dif.x*dif.x + dif.y*dif.y + dif.z*dif.z);

		this.flightStartTime = null;
		this.flightDuration = 1000.0 * ((flightDist / 15000) + 1); // extra seconds to ensure arrival

		this.flying = true;
	},

	/**
	 * Handler for mouse and touch drag events
	 *
	 * @param {Number} x X coordinate
	 * @param {Number} y Y coordinate
	 */
	actionMove: function(x, y) {
		if(this.orbitDragging) {
			this.yaw += (x - this.lastX) * this.direction * 0.1;
			this.pitch -= (y - this.lastY) * 0.1;
			this.orbiting = true;
		} else if(this.panDragging) {

		}

		this.lastX = x;
		this.lastY = y;
	},

	/**
	 * Event listener
	 *
	 * @param {mouseEvent} e Mouse event
	 */
	mouseDown: function(e) {
		this.lastX = this.downX = e.offsetX;
		this.lastY = this.downY = e.offsetY;
		if(e.which == 1) { // Left click
			this.orbitDragging = true;
		}
		if(e.which == 2) { // Middle click
			this.panDragging = true;
		}
	},

	/**
	 * Event listener
	 *
	 * @param {mouseEvent} e Mouse event
	 */
	mouseUp: function(e) {
		this.orbitDragging = false;
		this.panDragging = false;
	},

	/**
	 * Event listener
	 *
	 * @param {mouseEvent} e Mouse event
	 */
	mouseMove: function(e) {
		if(!this.touching) {
			this.actionMove(e.offsetX, e.offsetY);
		}
	},

	/**
	 * Event listener
	 *
	 * @param {mouseEvent} e Mouse event
	 */
	mouseWheel: function(e) {
		var delta = 0;
		event = e;
		if (event.wheelDelta) {
			delta = event.wheelDelta / 120;
			if (window.opera) {
				delta = -delta;
			}
		}
		else if (event.detail) {
			delta = -event.detail / 3;
		}

		if (delta) {
			if (delta < 0  && this.zoom > -25) {
				this.zoom -= 1;
			} else if(delta > 0) {
				this.zoom += 1;
			}
		}

		if (event.preventDefault) {
			event.preventDefault();
		}

		event.preventDefault();
		this.orbiting = true;
	},

	/**
	 * Event listener
	 *
	 * @param {touchEvent} e Touch event
	 */
	touchStart: function(e) {
		this.lastX = this.downX = e.targetTouches[0].clientX;
		this.lastY = this.downY = e.targetTouches[0].clientY;
		this.orbitDragging = true;
		this.touching = true;
	},

	/**
	 * Event listener
	 *
	 * @param {touchEvent} e Touch event
	 */
	touchMove: function(e) {
		this.actionMove(e.targetTouches[0].clientX, e.targetTouches[0].clientY);

	},

	/**
	 * Event listener
	 *
	 * @param {touchEvent} e Touch event
	 */
	touchEnd: function(e) {
		this.orbitDragging = false;
		this.panDragging = false;
		this.touching = false;
	},

});