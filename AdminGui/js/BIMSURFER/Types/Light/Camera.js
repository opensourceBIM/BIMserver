"use strict"

/**
 * Class: BIMSURFER.Light.Camera
 * This light will allways be behind the camera and pointed to the middle of the model
 */
BIMSURFER.Light.Camera = BIMSURFER.Class(BIMSURFER.Light, {
	CLASS: 'BIMSURFER.Light.Camera',
	__construct: function(system)`{
		this.SYSTEM = system;
		this.lightObject = {
			type:		'light',
			id:			'sun-light',
			mode:		'dir',
			color:		{r: 1, g: 1, b: 1},
			dir:   		{x: -0.5, y: -0.5, z: -1.0},
			space:		'world',
			diffuse:	true,
			specular:	true
		};
	}
});