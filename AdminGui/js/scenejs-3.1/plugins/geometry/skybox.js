SceneJS.Plugins.addPlugin(

    "geometry", // Node type
    "skybox", // Plugin type

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

        function build(cfg) {

            var x = cfg.xSize || 1;
            var y = cfg.ySize || 1;
            var z = cfg.zSize || 1;

            var positions = [
                x, y, z, -x, y, z, -x, -y, z, x, -y, z, // v0-v1-v2-v3 front
                x, y, z, x, -y, z, x, -y, -z, x, y, -z, // v0-v3-v4-v5 right
                x, y, z, x, y, -z, -x, y, -z, -x, y, z, // v0-v5-v6-v1 top
                -x, y, z, -x, y, -z, -x, -y, -z, -x, -y, z, // v1-v6-v7-v2 left
                -x, -y, -z, x, -y, -z, x, -y, z, -x, -y, z, // v7-v4-v3-v2 bottom
                x, -y, -z, -x, -y, -z, -x, y, -z, x, y, -z // v4-v7-v6-v5 back
            ];

            var uv = [
                0.5, 0.6666,
                0.25, 0.6666,
                0.25, 0.3333,
                0.5, 0.3333,
                0.5, 0.6666,
                0.5, 0.3333,
                0.75, 0.3333,
                0.75, 0.6666,
                0.5, 0.6666,
                0.5, 1,
                0.25, 1,
                0.25, 0.6666,
                0.25, 0.6666,
                0.0, 0.6666,
                0.0, 0.3333,
                0.25, 0.3333,
                0.50, 0,
                0.25, 0,
                0.25, 0.3333,
                0.50, 0.3333,
                0.75, 0.3333,
                1.0, 0.3333,
                1.0, 0.6666,
                0.75, 0.6666
            ];

            var indices = [
                0, 1, 2,
                0, 2, 3,
                4, 5, 6,
                4, 6, 7,
                8, 9, 10,
                8, 10, 11,
                12, 13, 14,
                12, 14, 15,
                16, 17, 18,
                16, 18, 19,
                20, 21, 22,
                20, 22, 23
            ];

            return {
                primitive:"triangles",
                coreId:"skybox_" + x + "_" + y + "_" + z,
                positions:new Float32Array(positions),
                uv:new Float32Array(uv),
                indices:new Uint16Array(indices)
            };
        }

    })());
