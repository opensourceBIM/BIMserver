/*
 * Based on PlaneGeometry by Mr. Doob
 */
SceneJS.Plugins.addPlugin(

    "geometry", // Node type
    "plane",

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

            var positions = [];
            var normals = [];
            var uvs = [];
            var indices = [];

            var width = cfg.width || 1.0;
            var height = cfg.height || 1.0;

            var widthSegments = cfg.widthSegments || 1;
            var heightSegments = cfg.heightSegments || 1;

            var coreId = "plane_" + (cfg.wire == true ? "wire_" : "") + height + "_" + widthSegments + "_" + heightSegments;

            var ix, iz;
            var halfWidth = width / 2;
            var halfHeight = height / 2;

            var gridX = widthSegments;
            var gridZ = heightSegments;

            var gridX1 = gridX + 1;
            var gridZ1 = gridZ + 1;

            var segWidth = width / gridX;
            var segHeight = height / gridZ;

            var x;
            var y;

            for (iz = 0; iz < gridZ1; iz++) {
                for (ix = 0; ix < gridX1; ix++) {

                    x = ix * segWidth - halfWidth;
                    y = iz * segHeight - halfHeight;

                    positions.push(x);
                    positions.push(-y);
                    positions.push(0);

                    normals.push(0);
                    normals.push(0);
                    normals.push(1);
                }
            }

            var a;
            var b;
            var c;
            var d;

            for (iz = 0; iz < gridZ; iz++) {
                for (ix = 0; ix < gridX; ix++) {

                    a = ix + gridX1 * iz;
                    b = ix + gridX1 * ( iz + 1 );
                    c = ( ix + 1 ) + gridX1 * ( iz + 1 );
                    d = ( ix + 1 ) + gridX1 * iz;

                    indices.push(a);
                    indices.push(b);
                    indices.push(c);

                    indices.push(c);
                    indices.push(d);
                    indices.push(a);

                    // a
                    uvs.push(ix / gridX);
                    uvs.push(1 - iz / gridZ);

                    //b
                    uvs.push(ix / gridX);
                    uvs.push(1 - ( iz + 1 ) / gridZ);

                    //c
                    uvs.push(( ix + 1 ) / gridX);
                    uvs.push(1 - ( iz + 1 ) / gridZ);

                    //c
                    uvs.push(( ix + 1 ) / gridX);
                    uvs.push(1 - ( iz + 1 ) / gridZ);

                    //d
                    uvs.push(( ix + 1 ) / gridX, 1 - iz / gridZ);
                    uvs.push(1 - iz / gridZ);

                    //a
                    uvs.push(ix / gridX);
                    uvs.push(1 - iz / gridZ);
                }
            }

            return {
                primitive:cfg.wire ? "lines" : "triangles",
                coreId:coreId,
                positions:new Float32Array(positions),
                normals:new Float32Array(normals),
                uv:new Float32Array(uvs),
                indices:new Uint16Array(indices)
            };
        }
    })());
