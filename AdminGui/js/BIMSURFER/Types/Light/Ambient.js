"use strict"

/**
 * Class: BIMSURFER.Light.Ambient
 * Default ambient light
 */
 BIMSURFER.Light.Ambient = BIMSURFER.Class(BIMSURFER.Light, {
	CLASS: 'BIMSURFER.Light.Ambient',
	__construct: function(system) {
		this.SYSTEM = system;
		this.lightObject = new Array({
				mode:"ambient",
				color:{ r:0.3, g:0.3, b:0.3 },
				diffuse:false,
				specular:false
			},
			{
				mode:"dir",
				color:{ r:1.0, g:1.0, b:1.0 },
				diffuse:true,
				specular:true,
				dir:{ x:-0.5, y:-0.5, z:-1.0 },
				space:"view"
			}
		);
	}
});