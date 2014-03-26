(function () {

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
                    parseOBJ.call(self, data);
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

        xhr.addEventListener('progress',
            function (event) {
                // TODO: Update the task? { type:'progress', loaded:event.loaded, total:event.total }
            }, false);

        xhr.addEventListener('load',
            function (event) {
                if (event.target.responseText) {
                    ok(event.target.responseText);
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

    function parseOBJ(data) {

        // Adapted from the THREE.js OBJLoader
        // https://github.com/mrdoob/three.js/blob/8f1d55542a18c664603f48d352a5d261034e81d8/examples/js/loaders/OBJLoader.js

        var group = {};

        var positions = [];
        var normals = [];
        var uv = [];

        var pattern, result;

        // v float float float

        pattern = /v( +[\d|\.|\+|\-|e]+)( [\d|\.|\+|\-|e]+)( [\d|\.|\+|\-|e]+)/g;

        while (( result = pattern.exec(data) ) != null) {

            // ["v 1.0 2.0 3.0", "1.0", "2.0", "3.0"]

            positions.push(parseFloat(result[ 1 ]));
            positions.push(parseFloat(result[ 2 ]));
            positions.push(parseFloat(result[ 3 ]));
        }

        // vn float float float

        pattern = /vn( +[\d|\.|\+|\-|e]+)( [\d|\.|\+|\-|e]+)( [\d|\.|\+|\-|e]+)/g;

        while (( result = pattern.exec(data) ) != null) {

            // ["vn 1.0 2.0 3.0", "1.0", "2.0", "3.0"]

            normals.push(parseFloat(result[ 1 ]));
            normals.push(parseFloat(result[ 2 ]));
            normals.push(parseFloat(result[ 3 ]));
        }

        // vt float float

        pattern = /vt( +[\d|\.|\+|\-|e]+)( [\d|\.|\+|\-|e]+)/g;

        while (( result = pattern.exec(data) ) != null) {

            // ["vt 0.1 0.2", "0.1", "0.2"]

            uv.push(parseFloat(result[ 1 ]));
            uv.push(parseFloat(result[ 2 ]));
        }

        var data = data.split('\no ');

        for (var i = 0, l = data.length; i < l; i++) {

            var object = data[ i ];

            var geometry = {
                type:"geometry",
                //  coreId:params.objectId + "." + i,
                positions:positions,
                uv:[],
                normals:[],
                indices:[]
            };

            // f vertex vertex vertex ...

            pattern = /f( +[\d]+)( [\d]+)( [\d]+)( [\d]+)?/g;

            while (( result = pattern.exec(object) ) != null) {

                // ["f 1 2 3", "1", "2", "3", undefined]

                if (result[ 4 ] === undefined) {

                    geometry.indices.push(parseInt(result[ 1 ]) - 1);
                    geometry.indices.push(parseInt(result[ 2 ]) - 1);
                    geometry.indices.push(parseInt(result[ 3 ]) - 1);


                } else {

                    geometry.indices.push(parseInt(result[ 1 ]) - 1);
                    geometry.indices.push(parseInt(result[ 2 ]) - 1);
                    geometry.indices.push(parseInt(result[ 3 ]) - 1);
                    geometry.indices.push(parseInt(result[ 4 ]) - 1);
                }
            }

            // f vertex/uv vertex/uv vertex/uv ...

            pattern = /f( +([\d]+)\/([\d]+))( ([\d]+)\/([\d]+))( ([\d]+)\/([\d]+))( ([\d]+)\/([\d]+))?/g;

            while (( result = pattern.exec(object) ) != null) {

                // ["f 1/1 2/2 3/3", " 1/1", "1", "1", " 2/2", "2", "2", " 3/3", "3", "3", undefined, undefined, undefined]

                if (result[ 10 ] === undefined) {

                    geometry.indices.push(parseInt(result[ 2 ]) - 1);
                    geometry.indices.push(parseInt(result[ 5 ]) - 1);
                    geometry.indices.push(parseInt(result[ 8 ]) - 1);

                    geometry.uv.push(uv[ parseInt(result[ 3 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 6 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 9 ]) - 1 ]);

                } else {

                    geometry.indices.push(parseInt(result[ 2 ]) - 1);
                    geometry.indices.push(parseInt(result[ 5 ]) - 1);
                    geometry.indices.push(parseInt(result[ 8 ]) - 1);
                    geometry.indices.push(parseInt(result[ 11 ]) - 1);

                    geometry.uv.push(uv[ parseInt(result[ 3 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 6 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 9 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 12 ]) - 1 ]);
                }
            }

            // f vertex/uv/normal vertex/uv/normal vertex/uv/normal ...

            pattern = /f( +([\d]+)\/([\d]+)\/([\d]+))( ([\d]+)\/([\d]+)\/([\d]+))( ([\d]+)\/([\d]+)\/([\d]+))( ([\d]+)\/([\d]+)\/([\d]+))?/g;

            while (( result = pattern.exec(object) ) != null) {

                // ["f 1/1/1 2/2/2 3/3/3", " 1/1/1", "1", "1", "1", " 2/2/2", "2", "2", "2", " 3/3/3", "3", "3", "3", undefined, undefined, undefined, undefined]

                if (result[ 13 ] === undefined) {

                    geometry.indices.push(parseInt(result[ 2 ]) - 1);
                    geometry.indices.push(parseInt(result[ 6 ]) - 1);
                    geometry.indices.push(parseInt(result[ 10 ]) - 1);

                    geometry.uv.push(uv[ parseInt(result[ 3 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 7 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 11 ]) - 1 ]);

                    geometry.normals.push(normals[ parseInt(result[ 4 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 8 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 12 ]) - 1 ]);


                } else {

                    geometry.indices.push(parseInt(result[ 2 ]) - 1);
                    geometry.indices.push(parseInt(result[ 6 ]) - 1);
                    geometry.indices.push(parseInt(result[ 10 ]) - 1);
                    geometry.indices.push(parseInt(result[ 14 ]) - 1);

                    geometry.uv.push(uv[ parseInt(result[ 3 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 7 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 11 ]) - 1 ]);
                    geometry.uv.push(uv[ parseInt(result[ 15 ]) - 1 ]);

                    geometry.normals.push(normals[ parseInt(result[ 4 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 8 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 12 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 16 ]) - 1 ]);

                }
            }

            // f vertex//normal vertex//normal vertex//normal ...

            pattern = /f( +([\d]+)\/\/([\d]+))( ([\d]+)\/\/([\d]+))( ([\d]+)\/\/([\d]+))( ([\d]+)\/\/([\d]+))?/g;

            while (( result = pattern.exec(object) ) != null) {

                // ["f 1//1 2//2 3//3", " 1//1", "1", "1", " 2//2", "2", "2", " 3//3", "3", "3", undefined, undefined, undefined]

                if (result[ 10 ] === undefined) {

                    geometry.indices.push(parseInt(result[ 2 ]) - 1);
                    geometry.indices.push(parseInt(result[ 5 ]) - 1);
                    geometry.indices.push(parseInt(result[ 8 ]) - 1);

                    geometry.normals.push(normals[ parseInt(result[ 3 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 6 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 9 ]) - 1 ]);

                } else {

                    geometry.indices.push(parseInt(result[ 2 ]) - 1);
                    geometry.indices.push(parseInt(result[ 5 ]) - 1);
                    geometry.indices.push(parseInt(result[ 8 ]) - 1);
                    geometry.indices.push(parseInt(result[ 11 ]) - 1);

                    geometry.normals.push(normals[ parseInt(result[ 3 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 6 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 9 ]) - 1 ]);
                    geometry.normals.push(normals[ parseInt(result[ 12 ]) - 1 ]);
                }
            }

            this.addNode(geometry);
        }
    }

})();