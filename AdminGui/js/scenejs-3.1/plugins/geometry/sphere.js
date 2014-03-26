SceneJS.Plugins.addPlugin(

    "geometry", // Node type
    "sphere",

    new (function() {

        this.getSource = function () {
            var publish;
            return {
                subscribe:function (fn) {
                    publish = fn;
                },
                configure:function (cfg) {
                    publish(build(cfg));
                }
            };
        };

        function build(cfg) {

            // Thanks awfully to: http://learningwebgl.com/cookbook/index.php/How_to_draw_a_sphere

            var latitudeBands = cfg.latitudeBands || 30;
            var longitudeBands = cfg.longitudeBands || 30;
            var radius = cfg.radius || 1;

            var positions = [];
            var normals = [];
            var uvs = [];
            for (var latNumber = 0; latNumber <= latitudeBands; latNumber++) {
                var theta = latNumber * Math.PI / latitudeBands;
                var sinTheta = Math.sin(theta);
                var cosTheta = Math.cos(theta);

                for (var longNumber = 0; longNumber <= longitudeBands; longNumber++) {
                    var phi = longNumber * 2 * Math.PI / longitudeBands;
                    var sinPhi = Math.sin(phi);
                    var cosPhi = Math.cos(phi);

                    var x = cosPhi * sinTheta;
                    var y = cosTheta;
                    var z = sinPhi * sinTheta;
                    var u = 1- (longNumber / longitudeBands);
                    var v = latNumber / latitudeBands;

                    normals.push(x);
                    normals.push(y);
                    normals.push(z);
                    uvs.push(u);
                    uvs.push(v);
                    positions.push(radius * x);
                    positions.push(radius * y);
                    positions.push(radius * z);
                }
            }

            var indices = [];
            for (var latNumber = 0; latNumber < latitudeBands; latNumber++) {
                for (var longNumber = 0; longNumber < longitudeBands; longNumber++) {
                    var first = (latNumber * (longitudeBands + 1)) + longNumber;
                    var second = first + longitudeBands + 1;
                    indices.push(first);
                    indices.push(second);
                    indices.push(first + 1);

                    indices.push(second);
                    indices.push(second + 1);
                    indices.push(first + 1);
                }
            }

            return {
                primitive:cfg.wire ? "lines" : "triangles",
                coreId : "sphere_" + (cfg.wire ? "wire" : "_solid") + radius + "_" + longitudeBands + "_" + latitudeBands,
                positions : new Float32Array(positions),
                normals: new Float32Array(normals),
                uv : new Float32Array(uvs),
                indices : new Uint16Array(indices)
            };
        }
    })());
