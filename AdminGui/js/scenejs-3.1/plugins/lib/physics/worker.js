/**
 * Web worker containing a JigLibJS rigid-body physics system.
 *
 * This worker accepts various commands to configure the system, add or
 * remove bodies, and integrate (which means run the system for one frame).
 *
 * After each integration, this worker posts back an array buffer containing
 * an updated position and direction for each body.
 *
 *
 * Input Commands
 * --------------------------------------------------------------------------
 *
 * Configure the system:
 * {
 *      cmd: "setConfigs",
 *      //..configs
 * }
 *
 * Create a body:
 * {
 *      cmd: "createBody",
 *      bodyId: Number,
 *      bodyCfg: {
 *          shape: "plane" | "box" | "sphere",
 *          movable: true | false,
 *          pos: [Number, Number, Number],
 *          mass: Number,
 *          restitution: Number,
 *          friction: Number,
 *          velocity: [Number, Number, Number]
 *      }
 *  }
 *
 * Remove a body:
 * {
 *      cmd: "removeBody",
 *      bodyId: Number
 * }
 *
 * Update a body:
 * {
 *      cmd: "updateBody",
 *      bodyId: Number,
 *      bodyCfg: {
 *          movable: true | false,
 *          pos: [Number, Number, Number],
 *          mass: Number,
 *          restitution: Number,
 *          friction: Number,
 *          velocity: [Number, Number, Number]
 *      }
 * }
 *
 * Integrate the phsycis system:
 * {
 *      cmd: "integrate"
 * }
 *
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
 *
 * Output Buffer
 * --------------------------------------------------------------------------
 *
 * The output buffer contains a 20-element portion for each physics body, each of
 * which contains the body ID, a new position, and a 16-element rotation matrix:
 *
 * [
 *      bodyId, xPos, yPos, zPos, mat0, ... mat15,
 *      bodyId, xPos, yPos, zPos, mat0, ... mat15,
 *      ...
 * ]
 *
 */
importScripts("jiglib.all.min.js");

var bodies = [];
var numBodies = 0;

// Array in which this worker posts back
// an updated position and direction for each body
var output;

// Physics engine system
var system = jigLib.PhysicsSystem.getInstance();

// Set initial default configuration for physics system
setConfigs();

/** Configures JigLibJS
 */
function setConfigs(params) {
    params = params || {};
    system.setGravity(params.gravity || [0, -9.8, 0, 0]); //-120
    system.setSolverType(params.solver || 'ACCUMULATED'); //FAST, NORMAL, ACCUMULATED
}

// System starts immediately
var then = (new Date()).getTime();

// Handle command from worker owner
addEventListener("message",
    function (e) {

        var data = e.data;

        switch (data.cmd) {

            // Configure the physics system
            case "setConfigs":
                setConfigs(data.configs);
                break;

            // Create a physics body
            case "createBody":

                var bodyId = data.bodyId;
                var bodyCfg = data.bodyCfg;
                var shape = bodyCfg.shape;
                var body;

                switch (shape) {

                    case "plane":
                        body = new jigLib.JPlane(null, bodyCfg.dir || [0, 1, 0]);
                        break;

                    case "box":
                        body = new jigLib.JBox(null, bodyCfg.width || 1.0, bodyCfg.depth || 1.0, bodyCfg.height || 1.0);
                        break;

                    case "sphere":
                        body = new jigLib.JSphere(null, bodyCfg.radius || 1.0);
                        break;

                    default:
                        // Unsupported body type
                        return;
                }

                bodies[bodyId] = {
                    body:body,
                    spherical:shape == "sphere"
                };

                system.addBody(body);

                if (bodyCfg.movable != undefined) {
                    body.set_movable(!!bodyCfg.movable);
                }

                if (bodyCfg.pos) {
                    body.moveTo(bodyCfg.pos);
                }

                if (bodyCfg.mass != undefined) {
                    body.set_mass(bodyCfg.mass);
                }

                if (bodyCfg.restitution != undefined) {
                    body.set_restitution(bodyCfg.restitution);
                }

                if (bodyCfg.friction != undefined) {
                    body.set_friction(bodyCfg.friction);
                }

                if (bodyCfg.velocity != undefined) {
                    body.setVelocity(bodyCfg.velocity);
                }

                numBodies++;

                break;

            // Update a physics body
            case "updateBody":

                var bodyId = data.bodyId;
                var body = bodies[bodyId].body;

                if (!body) {
                    return;
                }

                var bodyCfg = data.bodyCfg;

                if (bodyCfg.movable != undefined) {
                    body.set_movable(!!bodyCfg.movable);
                }

                if (bodyCfg.pos) {
                    body.moveTo(bodyCfg.pos);
                }

                if (bodyCfg.mass != undefined) {
                    body.set_mass(bodyCfg.mass);
                }

                if (bodyCfg.restitution != undefined) {
                    body.set_restitution(bodyCfg.restitution);
                }

                if (bodyCfg.friction != undefined) {
                    body.set_friction(bodyCfg.friction);
                }

                if (bodyCfg.velocity != undefined) {
                    body.setVelocity(bodyCfg.velocity);
                }

                break;

            // Remove a physics body
            case "removeBody":
                var body = bodies[data.bodyId];
                if (!body) {
                    return;
                }
                bodies[data.bodyId] = null;
                system.removeBody(body);
                numBodies--;
                break;

            // Integrate the physics system and post back the body updates
            case "integrate":

                var output = new Float32Array(data.buffer);

                var now = (new Date()).getTime();

                //       if (numBodies > 0) { // Only integrate and post if there are bodies

                var secs = (now - then) / 1000;
                var item;
                var body;
                var spherical;
                var state;
                var pos;
                var dir;
                var ibuf = 0;

                system.integrate(secs);

                for (var bodyId = 0, ibody = 0; ibody < numBodies; bodyId++) {

                    item = bodies[bodyId];

                    if (!item) { // Deleted
                        continue;
                    }

                    body = item.body;
                    spherical = item.spherical;

                    state = body.get_currentState();

                    // Body ID
                    output[ibuf++] = bodyId;

                    // New position

                    pos = state.position;

                    output[ibuf++] = pos[0];
                    output[ibuf++] = pos[1];
                    output[ibuf++] = pos[2];

                    if (spherical) {

                        // No rotation necessary for spheres
                        ibuf += 16;

                    } else {

                        // New rotation matrix

                        dir = state.get_orientation().glmatrix;

                        output[ibuf++] = dir[0];
                        output[ibuf++] = dir[1];
                        output[ibuf++] = dir[2];
                        output[ibuf++] = dir[3];
                        output[ibuf++] = dir[4];
                        output[ibuf++] = dir[5];
                        output[ibuf++] = dir[6];
                        output[ibuf++] = dir[7];
                        output[ibuf++] = dir[8];
                        output[ibuf++] = dir[9];
                        output[ibuf++] = dir[10];
                        output[ibuf++] = dir[11];
                        output[ibuf++] = dir[12];
                        output[ibuf++] = dir[13];
                        output[ibuf++] = dir[14];
                        output[ibuf++] = dir[15];
                    }

                    ibody++; // Next body;
                }

                // Post the output

                var response = {
                    buffer:output.buffer,
                    lenOutput:ibuf - 20
                };

                self.postMessage(response, [response.buffer]);

                then = now;

                break;

            default:


                break;
        }
    }, false);

