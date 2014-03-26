(function () {

    SceneJS.Types.addType("heightmaps/custom", {

        construct:function (params) {

            if (!params.src) {
                throw "heightmap param expected: src";
            }

            params.xSize = params.xSize || 1.0;
            params.ySize = params.ySize || 1.0;
            params.zSize = params.zSize || 1.0;

            params.xSegments = params.xSegments || 1;
            params.zSegments = params.zSegments || 1;

            var self = this;

            // Notify SceneJS so it can support loading/busy indicators etc
            this._taskId = this.taskStarted("Loading heightmap");

            var image = new Image();

            image.onload = function (e) {

                var element = window.document.createElement('canvas');
                element.width = image.width;
                element.height = image.height;

                var c = element.getContext("2d");

                c.drawImage(image, 0, 0);

                var imageData = c.getImageData(0, 0, image.width, image.height).data;

                var mesh = createMeshData(params, image, imageData);

                var wire = params.wire;

                if (self._taskId) {

                    self._taskId = self.taskFinished(self._taskId);

                    // Create geometry node
                    self.addNode({
                        type:"rotate",
                        x:1,
                        angle:90,
                        nodes:[
                            {
                                type:"geometry",
                                primitive:wire ? "lines" : "triangles",
                                positions:mesh.positions,
                                normals:!wire ? "auto" : null, // Get SceneJS to compute the normals
                                uv:!wire ? mesh.uv : null,
                                indices:mesh.indices,
                                coreId:"heightmap_" + (wire == true ? "wire_" : "") + params.zSize + "_" + params.xSize + "_" + params.xSegments + "_" + params.zSegments
                            }
                        ]
                    });
                }
            };

            image.onerror = function () {
                self._taskId = self.taskFailed(self._taskId);
            };

            image.src = params.src;
        },

        destruct:function () {
            this._taskId = self.taskFinished(this._taskId);
        }
    });

    function createMeshData(params, image, imageData) {

        var imageWidth = image.width;
        var imageHeight = image.height;

        var positions = [];
        var uvs = [];
        var indices = [];

        var width = params.xSize;
        var height = params.zSize;

        var xSegments = params.xSegments;
        var zSegments = params.zSegments;

        var halfWidth = width / 2;
        var halfHeight = height / 2;

        var gridX = xSegments;
        var gridZ = zSegments;

        var gridX1 = gridX + 1;
        var gridZ1 = gridZ + 1;

        var segWidth = width / gridX;
        var segHeight = height / gridZ;

        var imgX;
        var imgY;

        var x;
        var y;
        var z;

        for (var px = 0; px <= gridZ; px++) {
            for (var py = 0; py <= gridX; py++) {

                x = px * segWidth;
                y = py * segHeight;

                imgX = Math.round((x / width) * imageWidth);
                imgY = Math.round((y / height) * imageHeight);

                z = (imageData[(imageWidth * imgY + imgX) * 4]) / 255 * params.ySize;

                if (z == undefined) {
                    z = 0;
                }

                positions.push(x - halfWidth);
                positions.push(-y + halfHeight);
                positions.push(-z);
            }
        }

        var a;
        var b;
        var c;
        var d;

        for (var iz = 0; iz < gridZ; iz++) {
            for (var ix = 0; ix < gridX; ix++) {

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
            positions:positions,
            uv:uvs,
            indices:indices
        };
    }
})();