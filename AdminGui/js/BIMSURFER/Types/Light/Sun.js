"use strict"

/**
 * Class: BIMSURFER.Light.Camera
 * This light mimics the sunlight
 */
BIMSURFER.Light.Sun = BIMSURFER.Class(BIMSURFER.Light, {
	CLASS: 'BIMSURFER.Light.Sun',
	__construct: function(system) {
		this.SYSTEM = system;
		this.lightObject = {
			type:		'light',
			id:			'sun-light',
			mode:		'dir',
			color:		{r: 0.8, g: 0.8, b: 0.8},
			dir:   		{x: -0.5, y: 0.5, z: -1.0},
			diffuse:	true,
			specular:	true
		};
	}
});
