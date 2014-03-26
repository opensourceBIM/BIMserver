"use strict"

/**
 * Class: BIMSURFER.Light
 * This is the base class for Light objects.
 * Lights can be used to modify the lighting in the viewer
 */
BIMSURFER.Light = BIMSURFER.Class({
	CLASS: 'BIMSURFER.Light',
	SYSTEM: null,
	lightObject: null,
	__construct: function() {
	},
	activate: function() {
		var myLights = this.SYSTEM.scene.findNode('my-lights');
		var lights = myLights._core.lights;

		if(BIMSURFER.Util.isArray(this.lightObject)) {
			for(var i = 0; i < this.lightObject.length; i++) {
				if(lights.indexOf(this.lightObject[i]) == -1) {
					lights.push(this.lightObject[i]);
				}
			}
		} else if(lights.indexOf(this.lightObject) == -1) {
			lights.push(this.lightObject);
		}
		myLights.setLights(lights);
	},
	deactivate: function() {
		var myLight = this.SYSTEM.scene.findNode('my-lights');
		var lights = myLights._core.lights;

		var i = -1;
		if(BIMSURFER.Util.isArray(this.lightObject)) {
			for(i = 0; i < this.lightObject.length; i++) {
				var y = lights.indexOf(this.lightObject[i]);
				if(y > -1) {
					lights.splice(y, 1);
				}
			}
		} else if(i = lights.indexOf(this.lightObject) > -1) {
			lights.splice(i, 1);
		}
		myLights.setLights(lights);
	},

	setViewer: function(viewer) {
		this.SYSTEM = viewer;
	}
});