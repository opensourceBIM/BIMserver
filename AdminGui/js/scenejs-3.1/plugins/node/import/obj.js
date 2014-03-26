/**
 * WaveFront .OBJ mesh importer
 *
 * Uses the K3D library to parse .OBJ
 * © 2012 Ivan Kuckir
 * http://k3d.ivank.net/
 *
 */
require([

    // This prefix routes to the 3rd-party libs directory containing resources used by plugins
    "scenejsPluginDeps/k3d"
],
    function () {

        SceneJS.Types.addType("import/obj", {

            construct:function (params) {

                if (!params.src) {
                    this.log("error", "Attribute expected: src");
                }

                // Notify SceneJS so it can support loading/busy indicators etc
                this._taskId = this.taskStarted("Loading .OBJ");

                var self = this;

                load(params.src,
                    function (data) {

                        var m = K3D.parse.fromOBJ(data);	// done !

                        // unwrap simply duplicates some values, so they can be indexed with indices [0,1,2,3 ... ]
                        // In some rendering engines, you can have only one index value for vertices, UVs, normals ...,
                        // so "unwrapping" is a simple solution.

                        var positions = K3D.edit.unwrap(m.i_verts, m.c_verts, 3);
                        var normals = K3D.edit.unwrap(m.i_norms, m.c_norms, 3);
                        var uv = K3D.edit.unwrap(m.i_uvt, m.c_uvt, 2);

                        var indices = [];
                        for (var i = 0; i < m.i_verts.length; i++) {
                            indices.push(i);
                        }

                        // Need to flip the UV coordinates on Y-axis for SceneJS geometry
                        for (var i = 1, len = uv.length; i < len; i += 2) {
                            uv[i] *= -1.0;
                        }

                        self.addNode({
                            type:"geometry",
                            primitive:"triangles",
                            positions:positions,
                            uv:uv.length > 0 ? uv : undefined,
                            normals:normals.length > 0 ? normals : undefined,
                            indices:indices
                        });

                        self._taskId = self.taskFinished(self._taskId);
                    },

                    function (err) {
                        self.log("error", "Failed to load file: " + err);
                        self._taskId = self.taskFailed(self._taskId);
                    });

            },

            destruct:function () {
                this._taskId = this.taskFinished(this._taskId);
            }
        });


        function load(url, ok, error) {
            var xhr = new XMLHttpRequest();
            xhr.responseType = "arraybuffer";
//            xhr.addEventListener('progress',
//                function (event) {
//                    // TODO: Update the task? { type:'progress', loaded:event.loaded, total:event.total }
//                }, false);
            xhr.addEventListener('load',
                function (event) {
                    if (event.target.response) {
                        ok(event.target.response);
                    } else {
                        error('Invalid file [' + url + ']');
                    }
                }, false);
            xhr.addEventListener('error',
                function () {
                    error('Couldn\'t load URL [' + url + ']');
                }, false);
            xhr.open('GET', url, true);
            xhr.send(null);
        }

    })();