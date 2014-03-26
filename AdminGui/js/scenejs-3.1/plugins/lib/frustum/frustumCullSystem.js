/**
 * A frustum cuilling system, which manages a frustum culling worker implemented in frustumCullWorker.js
 */
(function () {

    define(function () {
        return System;
    });

    function System(systemId) {

        this.systemId = systemId;

        // Maximum number of bodies supported per system
        var maxBodies = 1000;

        var bodies = [];
        var map = new Map(bodies);

        // Create engine in worker
        var workerPath = SceneJS.getConfigs().pluginPath + "/lib/frustum/frustumCullWorker.js";
        var worker = new Worker(workerPath);

        var workerOutputBuf = new ArrayBuffer(maxBodies * 3);

        // True while worker is busy integrating
        // We don't send integration requests to it while this is true
        var integrating = false;

        // System is integrating only when this true
        var enabled = true;

        // Schedules integration when true
        var needIntegrate = true;

        // Route updates from engine to bodies
        worker.addEventListener('message',
            function (e) {

                var data = e.data;
                workerOutputBuf = data.buffer; // Worker transfers ownership of buffer to us
                var output = new Int16Array(workerOutputBuf);
                var lenOutput = data.lenOutput;
                var bodyId;
                var body;
                var intersect;
                var canvasSize;

                // The data buffer from the web worker contains a 3-element portion for
                // each body, each of which contains the body ID, frustum intesection status
                // and projected canvas size:
                //
                // [
                //      bodyId, intersect, canvasSize
                //      bodyId, intersect, canvasSize
                //      ...
                // ]
                for (var i = 0, len = lenOutput - 2; i < len; i += 3) {
                    bodyId = output[i]; // First element for body ID
                    body = bodies[bodyId];
                    intersect = output[i + 1];
                    canvasSize = output[i + 2];
                    if (body) { // May have been deleted
                        body.callback(intersect, canvasSize);
                    }
                }

                integrating = false;

            }, false);

        /**
         * Configures this system
         * @param configs Values for configs
         */
        this.setConfigs = function (configs) {
            needIntegrate = true;
            worker.postMessage({ cmd:"setConfigs", configs:configs });
        };

        /**
         * Enable or disable this system.
         * To save on CPU, you would typically disable the system when its not in view.
         * @param enable
         */
        this.setEnabled = function (enable) {
            enabled = enable;
            if (enable) {
                needIntegrate = true;
            }
        };

        /**
         * Creates a body, returns it's unique ID
         * @param params Body params
         * @param callback Callback fired whenever body updated
         * @return Body ID
         */
        this.createBody = function (params, callback) {
            needIntegrate = true;
            var bodyId = map.add({
                callback:callback
            });
            worker.postMessage({ cmd:"createBody", bodyId:bodyId, bodyCfg:params });
            return bodyId;
        };

        /**
         * Updates an existing body
         * @param bodyId Body ID
         * @param params Body params
         */
        this.updateBody = function (bodyId, params) {
            needIntegrate = true;
            worker.postMessage({ cmd:"updateBody", bodyId:bodyId, bodyCfg:params });
        };

        /**
         * Removes a body
         */
        this.removeBody = function (bodyId) {
            worker.postMessage({ cmd:"removeBody", bodyId:bodyId });
            map.remove(bodyId);
        };

        /**
         * Integrates this system
         * Does nothing when system is disabled with {@link System#setEnabled}.
         */
        this.integrate = function () {
            if (!enabled) {
                return;
            }
            if (integrating) { // Don't choke worker
                return;
            }
            if (needIntegrate) {
                integrating = true;
                needIntegrate = false;
                // Transfer ownership of output buffer to the worker
                var msg = {
                    cmd:"integrate",
                    buffer:workerOutputBuf
                };
                worker.postMessage(msg, [msg.buffer]);
            }
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
            // when posting output.

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
})();