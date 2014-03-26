SceneJS.Plugins.addPlugin(

    "geometry",

    "wobblyBox",

    new (function () {

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

        function build (cfg) {
            var randomFactor = cfg.randomFactor;
            return {
                primitive:"triangles", // Geometry only uses this on create, ignores on update
                positions:new Float32Array(randomize([  5, 5, 5, -5, 5, 5, -5, -5, 5, 5, -5, 5, 5, 5, 5, 5, -5, 5, 5, -5, -5, 5, 5, -5, 5, 5, 5, 5, 5, -5, -5, 5, -5, -5, 5, 5, -5, 5, 5, -5, 5, -5, -5, -5, -5, -5, -5, 5, -5, -5, -5, 5, -5, -5, 5, -5, 5, -5, -5, 5, 5, -5, -5, -5, -5, -5, -5, 5, -5, 5, 5, -5], randomFactor)),
                normals:new Float32Array(randomize([  0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1], randomFactor)),
                uv:new Float32Array(randomize([  5, 5, 0, 5, 0, 0, 5, 0, 0, 5, 0, 0, 5, 0, 5, 5, 5, 0, 5, 5, 0, 5, 0, 0, 5, 5, 0, 5, 0, 0, 5, 0, 0, 0, 5, 0, 5, 5, 0, 5, 0, 0, 5, 0, 5, 5, 0, 5], randomFactor)),
                uv2:null,
                indices:new Uint16Array([ 0, 1, 2, 0, 2, 3, 4, 5, 6, 4, 6, 7, 8, 9, 10, 8, 10, 11, 12, 13, 14, 12, 14, 15, 16, 17, 18, 16, 18, 19, 20, 21, 22, 20, 22, 23])
            };
        }

        function randomize (arry, randomFactor) {
            if (randomFactor == 0) {
                return arry;
            }
            var halfRandomFactor = randomFactor / 2.0;
            for (var i = 0, len = arry.length; i < len; i++) {
                arry[i] += (Math.random() * randomFactor) - halfRandomFactor;
            }
            return arry;
        }

    })());