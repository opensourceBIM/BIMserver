/**
 * Container of physics systems
 */
define(
    function () {

        // Physics systems
        var items = {};

        return  {

            /**
             * Acquire a physics system for the given SceneJS scene, creating first if not existing
             * @param {SceneJS.Scene} scene
             * @param {String} [systemId] Optional systemId
             */
            getSystem:function (scene, systemId) {
                systemId = systemId ? scene.getId() + "." + systemId : scene.getId();
                var item = items[systemId];
                if (item) {
                    item.useCount++;
                    return item.system;
                }
                var system = new System(systemId);
                items[systemId] = {
                    useCount:1,
                    system:system,
                    scene:scene,
                    tick:scene.on("tick", // Start integrating the system on scene tick
                        function () {
                            system.integrate();
                        })
                };
                return system;
            },

            /**
             * Release a physics system, destroying it if no more users
             * @param {System} system
             */
            putSystem:function (system) {
                var item = items[system.systemId];
                if (item) {
                    if (item.useCount-- <= 0) {
                        item.system.destroy();
                        item.scene.off(item.tick); // Stop integrating the system
                        delete items[system.systemId];
                    }
                }
            }
        };

        /**
         * A physics system
         */
        function System(systemId) {

            this.systemId = systemId;

            // Maximum number of bodies supported
            var maxBodies = 10000;

            var bodies = [];
            var map = new Map(bodies);

            // Create physics engine in worker
            var workerPath = SceneJS.getConfigs().pluginPath + "/lib/physics/worker.js";
            var worker = new Worker(workerPath);

            var workerOutputBuf = new ArrayBuffer(maxBodies * 20);

            // True while worker is busy integrating
            // We don't send integration requests to it while this is true
            var integrating = false;

            // System is integrating only when this true
            var enabled = true;

            // Route updates from physics engine to bodies
            worker.addEventListener('message',
                function (e) {

                    var data = e.data;
                    workerOutputBuf = data.buffer; // Worker transfers ownership of buffer to us
                    var output = new Float32Array(workerOutputBuf);
                    var lenOutput = data.lenOutput;
                    var bodyId;
                    var body;

                    // The data buffer from the web worker contains a 20-element portion for
                    // each physics body, each of which contains the body ID, a new position,
                    // and a 16-element rotation matrix:
                    //
                    // [
                    //      bodyId, xPos, yPos, zPos, mat0, ... mat15,
                    //      bodyId, xPos, yPos, zPos, mat0, ... mat15,
                    //      ...
                    // ]
                    for (var i = 0, len = lenOutput - 20; i < len; i += 20) {
                        bodyId = Math.round(output[i]); // First element for body ID
                        body = bodies[bodyId];
                        if (body) { // May have been deleted
                            body.callback(
                                output.subarray(i + 1, i + 4),
                                null);
//                                , // 3 elements for position
//                                output.subarray(i + 4, i + 20)); // 16 elements for rotation matrix
                        }
                    }

                    integrating = false;

                }, false);

            /**
             * Configures this physics system
             * @param params Values for configs
             */
            this.setConfigs = function (params) {
                worker.postMessage({ cmd:"setConfigs", configs:params });
            };

            /**
             * Enable or disable this physics system.
             * To save on CPU, you would typically disable the system when its not in view.
             * @param enable
             */
            this.setEnabled = function (enable) {
                enabled = enable;
            };

            /**
             * Creates a physics body, returns it's unique ID
             * @param params Body params
             * @param callback Callback fired whenever body updated
             * @return Body ID
             */
            this.createBody = function (params, callback) {
                var bodyId = map.add({
                    callback:callback
                });
                worker.postMessage({ cmd:"createBody", bodyId:bodyId, bodyCfg:params });
                return bodyId;
            };

            /**
             * Updates an existing physics body
             * @param bodyId Body ID
             * @param params Body params
             */
            this.updateBody = function (bodyId, params) {
                worker.postMessage({ cmd:"updateBody", bodyId:bodyId, bodyCfg:params });
            };

            /**
             * Removes a physics body
             */
            this.removeBody = function (bodyId) {
                worker.postMessage({ cmd:"removeBody", bodyId:bodyId });
                map.remove(bodyId);
            };

            /**
             * Integrates this physics system
             * Does nothing when system is disabled with {@link System#setEnabled}
             */
            this.integrate = function () {

                if (!enabled) {
                    return;
                }

                if (integrating) { // Don't choke worker
                    return;
                }

                integrating = true;

                // Transfer ownership of output buffer to the worker
                var msg = {
                    cmd:"integrate",
                    buffer:workerOutputBuf
                };
                worker.postMessage(msg, [msg.buffer]);
            };

            /**
             * Destroys system, terminating its worker
             */
            this.destroy = function () {
                worker.terminate();
            };
        }

        /**
         * Uniquely ID'd map of items
         * @param items Array that will contain the items
         */
        function Map(items) {
            this.add = function (item) {

                // Start looking from the beginning of the array
                // because we don't want an infinitely-expanding
                // sparse array as we remove then add nodes.

                // We're trading insertion overhead for the benefit
                // of a nicely packed array that's fast to traverse
                // when posting updates back to the physics body nodes.

                var i = 0;
                while (true) {
                    if (!items[i]) {
                        items[i] = item;
                        return i;
                    }
                    i++;
                }
            };
            this.remove = function (id) {
                delete items[id];
            };
        }
    });
