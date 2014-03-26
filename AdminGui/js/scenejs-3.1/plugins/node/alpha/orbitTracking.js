/**
 * Camera that flies to ray-picked point on scene object
 *
 * Usage example
 * -------------
 *
 * someNode.addNode({
 *      type: "alpha/orbitTracking",
 *      eye:{ x: y:0 },
 *      look:{ y:0 },
 *      yaw: 340,,
 *      pitch: -20,
 *      zoom: 350,
 *      zoomSensitivity:10.0,
 *      showPick: true
 * });
 *
 * The camera is initially positioned at the given 'eye' and 'look', then the distance of 'eye' is zoomed out
 * away from 'look' by the amount given in 'zoom', and then 'eye' is rotated by 'yaw' and 'pitch'.
 *
 */
require([
    SceneJS.getConfigs("pluginPath") + "/lib/gl-matrix-min.js"
],
    function (glmat) {

        SceneJS.Types.addType("alpha/orbitTracking", {

            construct:function (params) {

                var lookat = this.addNode({
                    type:"lookAt",

                    nodes:[
                        {
                            type:"name",
                            name:"noname",

                            // A plugin node type is responsible for attaching specified
                            // child nodes within itself
                            nodes:params.nodes
                        }
                    ]
                });

                var indicatorPos;
                var indicatorVis;

                if (params.showPick) {

                    // Red sphere to indicate current point-of-interest. We'll update the
                    // position of this whenever a new 3D position has been ray-picked.
                    // This will be the position about which we'll orbit.

                    // Sphere position, with a ID so we can update this node:
                    indicatorPos = lookat.addNode({
                        type:"translate",
                        id:"__spherePOI"
                    });

                    indicatorVis = indicatorPos.addNode({
                        type:"flags",
                        flags:{
                            enabled:false,
                            transparent:true,
                            specular: true,
                            diffuse: false
                        },
                        nodes:[
                            {
                                type:"scale",
                                x:50.1,
                                y:50.1,
                                z:50.1,
                                nodes:[
                                    {
                                        type:"material",
                                        color:{ r:1.0, g:1.0, b:0.0 },
                                        specularColor: { r:1.0, g:1.0, b:1.0 },

                                        alpha:0.5,
                                        emit:1.0,
                                        nodes:[

                                            // Sphere primitive implemented by plugin at
                                            // http://scenejs.org/api/latest/plugins/node/prims/sphere.js
                                            {
                                                type:"prims/sphere"
                                            }
                                        ]
                                    }
                                ]
                            }
                        ]
                    });
                }

                var eye = params.eye || { x:0, y:0, z:0 };
                var look = params.look || { x:0, y:0, z:0};
                var zoom = params.zoom || 1000;
                var zoomSensitivity = params.zoomSensitivity || 1.0;

                lookat.set({
                    eye:{ x:eye.x, y:eye.y, z:eye.z},
                    look:{ x:look.x, y:look.y, z:look.z },
                    up:{ x:0, y:1, z:0 }
                });

                var canvas = this.getScene().getCanvas();

                canvas.addEventListener('mousedown', mouseDown, true);
                canvas.addEventListener('mouseup', mouseUp, true);
                canvas.addEventListener('touchstart', touchStart, true);
                canvas.addEventListener('touchend', touchEnd, true);
                canvas.addEventListener('mousemove', mouseMove, true);
                canvas.addEventListener('touchmove', touchMove, true);
                canvas.addEventListener('mousewheel', mouseWheel, true);
                canvas.addEventListener('DOMMouseScroll', mouseWheel, true);

                var downX;
                var downY;
                var lastX;
                var lastY;
                var dragging;

                var yaw = params.yaw || 0;
                var pitch = params.pitch || 0;

                var currentPivot = [look.x || 0, look.y || 0, look.z || 0];
                var targetPivot = [look.x || 0, look.y || 0, look.z || 0];

                var needFlightUpdate = true;
                var needRotateUpdate = true;

                function mouseDown(event) {
                    lastX = downX = event.clientX;
                    lastY = downY = event.clientY;
                    dragging = true;
                }

                function touchStart(event) {
                    lastX = downX = event.targetTouches[0].clientX;
                    lastY = downY = event.targetTouches[0].clientY;
                    dragging = true;
                }

                function mouseUp(event) {
                    if (dragging && event.clientX == downX && event.clientY == downY) {
                        pick(event.clientX, event.clientY);
                    }
                    dragging = false;
                }

                function touchEnd(event) {
                    if (dragging && event.targetTouches[0].clientX == downX && event.targetTouches[0].clientY == downY) {
                        pick(event.targetTouches[0].clientX, event.targetTouches[0].clientY);
                    }
                    dragging = false;
                }

                function mouseMove(event) {
                    var posX = event.clientX;
                    var posY = event.clientY;
                    actionMove(posX, posY);
                }

                function touchMove(event) {
                    var posX = event.targetTouches[0].clientX;
                    var posY = event.targetTouches[0].clientY;
                    actionMove(posX, posY);
                }

                function actionMove(posX, posY) {
                    if (dragging) {
                        yaw += (posX - lastX) * 0.1;
                        pitch -= (posY - lastY) * 0.1;
                        needRotateUpdate = true;
                    }
                    lastX = posX;
                    lastY = posY;
                }

                function mouseWheel(event) {
                    var delta = 0;
                    if (!event) event = window.event;
                    if (event.wheelDelta) {
                        delta = event.wheelDelta / 120;
                        if (window.opera) delta = -delta;
                    } else if (event.detail) {
                        delta = -event.detail / 3;
                    }
                    if (delta) {
                        if (delta < 0) {
                            zoom -= zoomSensitivity;
                        } else {
                            zoom += zoomSensitivity;
                        }
                    }
                    if (event.preventDefault) {
                        event.preventDefault();
                    }
                    event.returnValue = false;
                    needRotateUpdate = true;
                }

                function pick(canvasX, canvasY) {
                    scene.pick(canvasX, canvasY, { rayPick:true });
                }

                var scene = this.getScene();

                scene.on("pick",
                    function (hit) {
                        targetPivot = hit.worldPos;
                        if (indicatorVis) {
                            indicatorVis.setEnabled(true);
                            indicatorPos.setXYZ({x:targetPivot[0], y:targetPivot[1], z:targetPivot[2] });
                        }
                        needFlightUpdate = true;
                    });

                scene.on("tick",
                    function () {


                        if (needFlightUpdate) {

                            // Continue flight
                            // Find new pivot point, interpolated on path towards new point

                            var a = glmat.vec3.fromValues(targetPivot[0], targetPivot[1], targetPivot[2]);
                            var b = glmat.vec3.fromValues(currentPivot[0], currentPivot[1], currentPivot[2]);
                            var vec = glmat.vec3.create();
                            glmat.vec3.sub(vec, a, b);
                            var dist = glmat.vec3.length(vec);

                            if (dist > 15.0) {
                                var vel = glmat.vec3.normalize(vec, vec);
                                currentPivot[0] += vec[0] * 10.2;
                                currentPivot[1] += vec[1] * 10.2;
                                currentPivot[2] += vec[2] * 10.2;

                                // Need to rotate lookat
                                needRotateUpdate = true;
                            } else {

                                // Stop flying
                                needFlightUpdate = false;

                                // Hide pick indicator
                                if (indicatorVis) {
                                    indicatorVis.setEnabled(false);
                                }
                            }
                        }


                        if (needRotateUpdate) {

                            // Update location of point-of-interest indicator
                            if (indicatorVis) {
                                indicatorVis.setEnabled(true);
                            }

                            var eye = glmat.vec3.fromValues(0, 0, zoom);
                            var look = glmat.vec3.fromValues(currentPivot[0], currentPivot[1], currentPivot[2]);
                            //    var up = glmat.vec3.fromValues(0, 1, 0);

                            var eyeVec = glmat.vec3.create();
                            glmat.vec3.sub(eyeVec, eye, look);

                            var mat = glmat.mat4.create();

                            glmat.mat4.rotateY(mat, mat, -yaw * 0.0174532925);
                            glmat.mat4.rotateX(mat, mat, -pitch * 0.0174532925);

                            var eye3 = glmat.vec3.create();

                            glmat.vec3.transformMat4(eye3, eye, mat);

                            // Update view transform
                            lookat.setLook({x:look[0], y:look[1], z:look[2] });
                            lookat.setEye({x:look[0] - eye3[0], y:look[1] - eye3[1], z:look[2] - eye3[2] });

                            // Rotate complete
                            needRotateUpdate = false;
                        }
                    });
            },

            destruct:function () {
                // TODO: remove mouse handlers
            }
        });
    });