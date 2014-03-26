SceneJS.Plugins.addPlugin(

    "geometry", // Node type
    "box", // Plugin type

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

            var normals = [
                0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, // v0-v1-v2-v3 front
                1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, // v0-v3-v4-v5 right
                0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, // v0-v5-v6-v1 top
                -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, // v1-v6-v7-v2 left
                0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, // v7-v4-v3-v2 bottom
                0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1     // v4-v7-v6-v5 back
            ];

            var uv = [
                x, y, 0, y, 0, 0, x, 0, // v0-v1-v2-v3 front
                0, y, 0, 0, x, 0, x, y, // v0-v3-v4-v5 right
                x, 0, x, y, 0, y, 0, 0, // v0-v5-v6-v1 top
                x, y, 0, y, 0, 0, x, 0, // v1-v6-v7-v2 left
                0, 0, x, 0, x, y, 0, y, // v7-v4-v3-v2 bottom
                0, 0, x, 0, x, y, 0, y
            ];   // v4-v7-v6-v5 back

            var indices = [
                0, 1, 2, 0, 2, 3, // front
                4, 5, 6, 4, 6, 7, // right
                8, 9, 10, 8, 10, 11, // top
                12, 13, 14, 12, 14, 15, // left
                16, 17, 18, 16, 18, 19, // bottom
                20, 21, 22, 20, 22, 23
            ];  // back

            return {
                primitive:cfg.wire ? "lines" : "triangles",
                coreId:"box_" + x + "_" + y + "_" + z + (cfg.wire ? "wire" : "_solid"),
                positions:new Float32Array(positions),
                normals:new Float32Array(normals),
                uv:new Float32Array(uv),
                indices:new Uint16Array(indices)
            };
        }

    })());
