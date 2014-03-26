/**
 * MD2 importer
 *
 * Uses the K3D library to parse .MD2
 * © 2012 Ivan Kuckir
 * http://k3d.ivank.net/
 *
 */
require([

    // This prefix routes to the 3rd-party libs directory containing resources used by plugins
    "scenejsPluginDeps/k3d"
],
    function () {

        SceneJS.Types.addType("import/md2", {

            construct:function (params) {

                if (!params.src) {
                    this.log("error", "Attribute expected: src");
                }

                // Notify SceneJS so it can support loading/busy indicators etc
                this._taskId = this.taskStarted("Loading .MD2");

                var self = this;

                load(params.src,
                    function (data) {

                        var m = K3D.parse.fromMD2(data);

                        // Build morph targets
                        var keys = [];
                        var morphTargets = [];
                        for (var i = 0, len = m.frames.length - 3; i < len; i++) { // TODO: why do I need to skip the last three frames?
                            var f = m.frames[i];
                            keys.push((1.0 / len) * i);

                            // Target
                            var verts = K3D.edit.unwrap(m.i_verts, f.verts, 3);

                            // In my model, Y and Z are swapped
                            K3D.edit.transform(verts, K3D.mat.rotateDeg(90, 0, 0));
                            morphTargets.push({
                                positions:verts
                            })
                        }

                        // Build UVs
                        var uv = K3D.edit.unwrap(m.i_uvt, m.c_uvt, 2);
                        for (var i = 1, len = uv.length; i < len; i += 2) { // Flip UVs on Y-axis for SceneJS
                            uv[i] *= -1.0;
                        }

                        // Build indices
                        var indices = [];
                        for (var i = 0; i < m.i_verts.length; i++) {
                            indices.push(i);
                        }

                        // Create morph wrapping geometry
                        // Morph has positions in targets, geometry has UVs and indices
                        var morph = self.addNode({
                            type:"morphGeometry",
                            factor:0,
                            keys:keys,
                            targets:morphTargets,
                            nodes:[
                                {
                                    type:"geometry",
                                    primitive:"triangles",
                                    uv:uv,
                                    indices:indices
                                }
                            ]
                        });

                        // If rate param is given, then
                        // automatically play the morph

                        if (params.rate) {

                            var factor = 0;
                            var lastKey = (keys.length > 0) ? keys[keys.length - 1] : 0;
                            var rate = params.rate;

                            // Start morphing
                            this._tick = self.getScene().on("tick",
                                function () {
                                    morph.setFactor(factor);
                                    factor += rate;
                                    if (factor > lastKey) {
                                        factor = factor % lastKey;
                                    }
                                });
                        }

                        // Done
                        self._taskId = self.taskFinished(self._taskId);
                    },

                    function (err) {
                        self.log("error", "Failed to load file: " + err);
                        self._taskId = self.taskFailed(self._taskId);
                    });

            },

            destruct:function () {
                if (this._tick) {
                    this.getScene().off(this._tick); // Stop morphing
                }
                this._taskId = this.taskFinished(this._taskId); // Just in case
            }
        });


        function load(url, ok, error) {
            var xhr = new XMLHttpRequest();
            xhr.responseType = "arraybuffer";
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