SceneJS.Plugins.addPlugin(

    "geometry", // Node type
    "quad",

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

            var positions = [ 1, 1, 0, -1, 1, 0, -1, -1, 0, 1, -1, 0 ];
            var normals = [ -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0 ];
            var uv = [ 1, 1, 0, 1, 0, 0, 1, 0 ];
            var indices = [ 0, 1, 2, 0, 2, 3 ];

            return {
                primitive:cfg.wire ? "lines" : "triangles",
                coreId:"quad" + (cfg.wire ? "wire" : "_solid"),
                positions:new Float32Array(positions),
                normals:new Float32Array(normals),
                uv:new Float32Array(uv),
                indices:new Uint16Array(indices)
            };
        }

    })());
