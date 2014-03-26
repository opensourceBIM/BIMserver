/*
 * A gradient background
 *
 * The background is a quad that sits at the back of the view frustum.
 *
 * The color for the quad is specified as a color for each of the quad's vertices. The color is given as
 * a flat array of 16 double precision numbers, in the range [0.0..1.0], in this format:
 *
 *   [r, g, b, a, r, b, b, a, r, g, b, a, r, g, b, a]
 *
 * which is for top-left, top-right, bottom-right and bottom-left corners, respectively.
 *
 * The 'a' components are for the alpha channel, and should be given the value 1.0. That's just
 * there in case we want to do something fancy with alpha channel at some point, like blending.
 *
 * var bg = myNode.addNode({
 *      depth: -30, // default
 *      colors:[
 *          0.05, 0.06, 0.07, 1.0, // top left (R,G,B,A)
 *          0.05, 0.06, 0.07, 1.0, // top right
 *          0.85, 0.9, 0.98, 1.0, // bottom right
 *          0.85, 0.9, 0.98, 1.0   // bottom left
 *      ]
 * });
 *
 * // Change the colors:
 *
 * bg.setColors([
 *          0.01, 0.03, 0.07, 1.0,
 *          0.01, 0.03, 0.07, 1.0,
 *          0.21, 0.2, 0.98, 1.0,
 *          0.21, 0.2, 0.98, 1.0
 * ]);
 *
 * // Change the depth:
 *
 * bg.setDepth(-50);
 *
 */
(function () {

    var defaultColors = [
        0.05, 0.06, 0.07, 1.0, // top left (R,G,B,A)
        0.05, 0.06, 0.07, 1.0, // top right
        0.85, 0.9, 0.98, 1.0, // bottom right
        0.85, 0.9, 0.98, 1.0   // bottom left
    ];

    var defaultDepth = -30;

    SceneJS.Types.addType("backgrounds/gradient", {

        construct:function (params) {

            var colors = params.colors;
            if (colors && colors.length != 16) {
                this.log("error", "Invalid 'colors' param for backgrounds/gradients: should be 16-element array");
                colors = defaultColors;
            }

            this._lookat = this.addNode({
                type:"lookAt",
                eye:{ x:0, y:0, z:params.depth || defaultDepth },
                look:{ x:0, y:0, z:0 },
                up:{ x:0, y:1, z:.0 }
            });

            var lights = this._lookat.addNode({
                type:"lights",
                lights:[
                    {
                        mode:"dir",
                        color:{ r:1.0, g:1.0, b:1.0 },
                        dir:{ x:0.0, y:0.0, z:-1.0 },
                        diffuse:true,
                        specular:true,
                        space:"view"
                    }
                ]
            });

            var material = lights.addNode({
                type:"material",
                baseColor:{ r:.95, g:.95, b:.95 },
                specularColor:{ r:0.0, g:0.0, b:0.0 },
                emit:0.2,
                specular:0.9,
                shine:3.0
            });

            // TODO: width and height, perhaps from frustum

            this._geometry = material.addNode({
                type:"geometry",
                primitive:"triangles",

                positions:[
                    3000, 2000, 300,
                    -3000, 2000, 300,
                    -3000, -2000, 300,
                    3000, -2000, 300
                ],

                normals:[
                    0, 0, -1,
                    0, 0, -1,
                    0, 0, -1,
                    0, 0, -1
                ],

                uv:[
                    10, 10,
                    0, 10,
                    0, 0,
                    10, 0
                ],

                colors:params.colors || defaultColors,

                indices:[
                    0, 1, 2, 0, 2, 3
                ]
            });
        },

        /**
         * Sets the gradient colors
         *
         * @param {Array} [colors] 16-element flat array of colors for vertices - reverts to default when not given
         */
        setColors:function (colors) {
            this._geometry.setColors(colors || defaultColors);
        },

        /** Sets the depth
         *
         * @param {Number} [depth] Depth on Z-axis - default is -30, reverets to that when no parameter given
         */
        setDepth: function(depth) {
            this._lookat.setEye({ x:0, y:0, z:params.depth || defaultDepth });
        },

        destruct:function () {
            // Not used
        }
    });

})();
