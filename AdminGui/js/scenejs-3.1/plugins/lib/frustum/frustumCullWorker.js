/**
 * Web worker containing an instance of a frustum culling engine implemented
 * in frustumCullEngine.js
 *
 * This worker accepts various commands to configure the engine, add or remove
 * bodies, and integrate, which means find and changes in frustum intersection
 * status and projected canvas size of the bodies.
 *
 * On each integration, for each body whose intersection state and/or canvas size
 * has changed, this worker posts back an Int16Array containing those updates.
 *
 * Input Commands
 * --------------------------------------------------------------------------
 *
 * Configure the system
 * --------------------
 * {
 *      cmd: "setConfigs",
 *      viewMat: Array(16),
 *      projMat: Array(16),
 *      viewport: Array[4]
 * }
 *
 * Create a body
 * -------------
 *
 * Axis-aligned bounding box:
 * {
 *      cmd: "createBody",
 *      bodyId: Number,
 *      bodyCfg: {
 *          shape: "box",
 *          min: [Number, Number, Number],
 *          max: [Number, Number, Number],
 *          frustumCull: Boolean, // Perform frustum culling for this body? Default is true.
 *          detailCull: Boolean, // Perform detail culling for this body? Default is true.
 *      }
 *  }
 *
 * Remove a body:
 * {
 *      cmd: "removeBody",
 *      bodyId: Number
 * }
 *
 * Integrate the engine:
 * {
 *      cmd: "integrate"
 * }
 *
 * For efficiency, the physics system manages bodies in an array. The "bodyId"
 * parameter on the "createBody" command is the index for that body in the array.
 *
 * The "removeBody" command will delete a body from the array, leaving a hole.
 *
 * The worker can handle holes in the array OK, but in order to keep the array
 * from getting too sparse, it's the reponsibility of the worker client to make
 * its next "createBody" command specify a "bodyId" that indexes that hole, to plug
 * the gap with the next new body.
 *
 * Output Buffer
 * --------------------------------------------------------------------------
 *
 * The output buffer is an Int16Array containing a 3-element portion for each
 * body, each of which contains the body ID, its frustum intersection status and the
 * projected size within the viewport:
 *
 * [
 *      bodyId, intersect, canvasSize,
 *      bodyId, intersect, canvasSize
 *      ...
 * ]
 *
 * intersect:
 *      0 == body is completely outside frustum
 *      1 == body is partially inside frustum
 *      2 == body is completely inside frustum
 *      Undefined when body frustumCull == false
 *
 * canvasSize:
 *      For box, will be the length of diagonal size of projected boundary.
 *      Undefined when body detailCull == false or intersect == 0.
 *
 */
importScripts("frustumCullEngine.js");

// Array in which this worker posts back status for each updated body
var output;

// The engine
var engine = new Engine();

// Handle a command from worker owner
addEventListener("message",
    function (e) {

        var data = e.data;

        switch (data.cmd) {

            // Configure the engine
            case "setConfigs":
                engine.setConfigs(data.configs);
                break;

            // Create a body
            case "createBody":
                engine.addBody(data.bodyId, data.bodyCfg);
                break;

            // Remove a body
            case "removeBody":
                engine.removeBody(data.bodyId);
                break;

            // Integrate the engine and post back the body updates
            case "integrate":
                var output = new Int16Array(data.buffer);
                var body;
                var ibuf = 0;
                engine.integrate(
                    function (updatedBodies, numUpdated) {
                        for (var i = 0; i < numUpdated; i++) {
                            body = updatedBodies[i];
                            output[ibuf++] = body.bodyId;
                            output[ibuf++] = body.intersect;
                            output[ibuf++] = body.canvasSize;
                        }
                        // Post the output
                        var response = {
                            buffer:output.buffer,
                            lenOutput:ibuf
                        };
                        self.postMessage(response, [response.buffer]);
                    });
                break;

            default:
                break;
        }
    }, false);

