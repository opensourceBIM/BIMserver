// Geometry plugin which renders a box primitive defined as min-max extents
SceneJS.Plugins.addPlugin(

    "geometry", // Node type
    "boundary", // Plugin type

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

            var xmin = cfg.xmin != undefined ? cfg.xmin : 0;
            var ymin = cfg.ymin != undefined ? cfg.ymin : 0;
            var zmin = cfg.zmin != undefined ? cfg.zmin : 0;
            var xmax = cfg.xmax != undefined ? cfg.xmax : 0;
            var ymax = cfg.ymax != undefined ? cfg.ymax : 0;
            var zmax = cfg.zmax != undefined ? cfg.zmax : 0;

            var positions = [
                xmax, ymax, zmax,
                xmax, ymin, zmax,
                xmin, ymin, zmax,
                xmin, ymax, zmax,
                xmax, ymax, zmin,
                xmax, ymin, zmin,
                xmin, ymin, zmin,
                xmin, ymax, zmin
            ];

            var indices = [
                0, 1, 1,
                2, 2, 3,
                3, 0, 4,
                5, 5, 6,
                6, 7, 7,
                4, 0, 4,
                1, 5, 2,
                6, 3, 7
            ];

            return {
                primitive:"lines",
                positions:new Float32Array(positions),
                indices:new Uint16Array(indices)
            };
        }

    })());
