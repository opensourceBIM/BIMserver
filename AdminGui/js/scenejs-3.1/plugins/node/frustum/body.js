require([
    // Prefix routes to plugin support libs
    "scenejsPluginDeps/frustum/frustumCullSystemPool"
],
    function (pool) {

        SceneJS.Types.addType("frustum/body", {

            construct:function (params) {

                // Frustum culling and projected canvas size enabled by default
                this._frustumCull = params.frustumCull != undefined ? params.frustumCull : true;
                this._detailCull = params.detailCull != undefined ? params.detailCull : true;

                var shape = params.shape || "box";

                switch (shape) {
                    case "box":
                        this._bodyCfg = {
                            shape:shape,
                            min:params.min || [0, 0, 0],
                            max:params.max || [0, 0, 0],
                            frustumCull:this._frustumCull,
                            detailCull:this._detailCull
                        };
                        if (params.showBoundary) {
                            this.addNode({
                                type:"prims/boundary",
                                min:params.min || [0, 0, 0],
                                max:params.max || [0, 0, 0],
                                wire:true
                            });
                        }
                        break;

//                    case "sphere":
//                        this._bodyCfg = {
//                            shape:"sphere",
//                            center:params.center || [0, 0, 0],
//                            radius:params.radius || 1.0
//                        };
//                        break;

                    default:
                        this.log("error", "Unsupported value for attribute 'shape'");
                }

                if (params.nodes) {
                    this.addNodes(params.nodes);
                }
            },

            preCompile:function () {

                // This node might have been relocated in the scene graph
                // and therefore inherits new view and projection transforms,
                // so we'll release any existing system just in case.

                this._putBody();
                this._getBody();
            },

            _putBody:function () {
                if (this._bodyId) {
                    this._system.removeBody(this._bodyId);
                    this._bodyId = null;
                }
                if (this._system) {
                    pool.putSystem(this._system);
                    this._system = null;
                }
            },

            _getBody:function () {
                try {
                    this._system = pool.getSystem(this);
                    var self = this;
                    this._bodyId = this._system.createBody(this._bodyCfg,
                        function (intersect, canvasSize) { // Body update handler

                            // Not that much overhead in relaying status
                            // updates via pub/sub because they only happen sparsely,
                            // ie. for bodies whose status actually changes

                            if (self._frustumCull) { // Frustum culling switching enabled
                                self.publish("intersect", intersect);
                            }

                            if (self._detailCull) { // LOD switching enabled
                                self.publish("canvasSize", canvasSize);
                            }

                            //  self.log(" intersect = " + intersect + ", canvasSize = " + canvasSize);
                        });
                } catch (e) {
                    this.log("Error : " + e);
                    if (this._system) {
                        pool.putSystem(this._system);
                        this._system = null;
                    }
                }
            },

            postCompile:function () {
                // Not used
            },

            destruct:function () {
                this._putBody();
            }
        });
    });
