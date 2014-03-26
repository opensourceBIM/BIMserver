SceneJS.Types.addType("labels/lod", {

    construct:function (params) {

        var min = params.min || [0, 0, 0];
        var max = params.max || [0, 0, 0];

        var xPos = min[0] + ((max[0] - min[0]) / 2.0);
        var yPos = min[1] + ((max[1] - min[1]) / 2.0);
        var zPos = min[2] + ((max[2] - min[2]) / 2.0);

        this.addNode({
            type:"frustum/lod",

            // World-space axis-aligned bounding box
            min:min,
            max:max,

            // 2D canvas size thresholds, one for each child node, in ascending
            // order for size, unlimited quantity
            sizes:[
                50, 250
            ],

            // Option to show the boundary as a wireframe box for debugging - default false
            showBoundary:true,

            // Option to disable all child nodes when the bounding box
            // falls outside the view frustum - true by default
            frustumCull:true,

            // A child node for each size threshold, in ascending order of
            // detail, unlimited quantity
            nodes:[
                // Detail level 1 (lowest)
                // A light blue box

                {
                    type:"material", color:{ r:0.6, g:0.6, b:1.0 },
                    nodes:[
                        {
                            type:"translate", x:xPos, y:yPos, z:zPos,
                            nodes:[
                                {
                                    type:"scale", x:4, y:3, z:4,
                                    nodes:[

                                        // Box primitive, implemented by plugin at
                                        // http://scenejs.org/api/latest/plugins/node/prims/box.js
                                        {
                                            type:"prims/box"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },

                // Detail level 2 (middle)
                // A medium-blue sphere

                {
                    type:"material", color:{r:0.5, g:0.5, b:1.0 },
                    nodes:[
                        {
                            type:"translate", x:xPos, y:yPos, z:zPos,
                            nodes:[
                                {
                                    type:"scale", x:1.0, y:0.7, z:1.0,
                                    nodes:[

                                        // Sphere primitive, implemented by plugin at
                                        // http://scenejs.org/api/latest/plugins/node/prims/sphere.js
                                        {
                                            type:"prims/sphere",
                                            radius:5,
                                            latitudeBands:16, // A fairly low-rez sphere
                                            longitudeBands:16
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ]
        });
    }
});