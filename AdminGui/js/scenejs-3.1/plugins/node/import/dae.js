/**
 * .DAE importer
 *
 * Uses the K3D library to parse .DAE
 * © 2012 Ivan Kuckir
 * http://k3d.ivank.net/
 *
 */
require([

    // This prefix routes to the 3rd-party libs directory containing resources used by plugins
    "scenejsPluginDeps/k3d"
],
    function () {

        SceneJS.Types.addType("import/dae", {

            construct:function (params) {

                if (!params.src) {
                    this.log("error", "Attribute expected: src");
                }

                // Notify SceneJS so it can support loading/busy indicators etc
                this._taskId = this.taskStarted("Loading .DAE");

                var self = this;

                load(params.src,
                    function (data) {

                        var m = K3D.parse.fromCollada(data);

                        console.log(m);

                        //var imgs = {};
                        //for (var n in m.images) imgs[n] = new BitmapData("sport_car/models/" + m.images[n]);

                        for (var i = 0; i < m.geometries.length; i++) {
                            var g = m.geometries[i];
                            for (var j = 0; j < g.triangles.length; j++) {

                                var t = g.triangles[j];

                                var mat = m.materials[t.material];
                                var eff = m.effects[mat];
                                if (eff.surface == null) continue;	// skip meshes without texture

                                var verts = K3D.edit.unwrap(t.i_VERTEX, g.sources[t.s_VERTEX  ], 3);
                                var uvt = K3D.edit.unwrap(t.i_TEXCOORD, g.sources[t.s_TEXCOORD], 2);

                                for (var k = 1; k < uvt.length; k += 2) {
                                    uvt[k] = 1 - uvt[k];
                                }
                                var inds = [];
                                for (var k = 0; k < t.i_VERTEX.length; k++) {
                                    inds.push(k);
                                }

                                self.addNode({
                                    type:"geometry",
                                    primitive:"triangles",
                                    positions:verts,
                                    uv:uvt.length > 0 ? uvt : undefined,

                                    indices:inds
                                });
                            }
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