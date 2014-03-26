/**
 * 3DS importer plugin
 *
 * Uses the K3D library to parse .3DS
 * © 2012 Ivan Kuckir
 * http://k3d.ivank.net/
 *
 */
require([

    // This prefix routes to the 3rd-party libs directory containing resources used by plugins
    "scenejsPluginDeps/k3d"
],
    function () {

        SceneJS.Types.addType("import/3ds", {

            construct:function (params) {

                if (!params.src) {
                    this.log("error", "Attribute expected: src");
                }

                // Notify SceneJS so it can support loading/busy indicators etc
                this._taskId = this.taskStarted("Loading .3DS");

                var self = this;

                load(params.src,
                    function (data) {

                        var m = K3D.parse.from3DS(data);

                        console.log(m);

                        var mesh = m.edit.objects[0].mesh;

                        // Need to flip the UV coordinates on Y-axis for SceneJS geometry
                        for (var i = 1, len = mesh.uvt.length; i < len; i += 2) {
                            mesh.uvt[i] *= -1.0;
                        }

                        self.addNode({
                            type:"geometry",
                            primitive:"triangles",
                            positions:mesh.vertices,
                            uv:mesh.uvt,
                            //normals:"auto",
                            indices:mesh.indices
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