/**
 * Camera that flies to ray-picked point on scene object
 *
 * Usage example
 * -------------
 *
 * someNode.addNode({
 *      type: "cameras/pickFlyOrbit",
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
    function (glmat, jquery) {

        // Create target indicator div

        var label = (function () {
            var body = document.getElementsByTagName("body")[0];
            var div = document.createElement('div');

            var style = div.style;
            style.display = "none";
            style.position = "absolute";
            style["font-family"] = "Helvetica";
            style["font-size"] = "14px";
            style.padding = "5px";
            style.margin = "4px";
            style["padding-left"] = "12px";
            style["border"] = "1px solid #000055";
            style.color = "black";
            style.background = "#AAFFAA";
            style.opacity = "0.8";
            style["border-radius"] = "3px";
            style["-moz-border-radius"] = "3px";
            style["box-shadow"] = "3px 3px 3px #444444";
            style.left = "0";
            style.top = "0";
            style.height = "auto";
            style.width = "auto";
            div.innerHTML += 'Foo';
            body.appendChild(div);
            return {
                setShown:function (shown) {
                    style.display = shown ? "" : "none";
                },
                setPos:function (pos) {
                    style.left = "" + pos.x + "px";
                    style.top = "" + pos.y + "px";
                },
                setText:function (text) {
                    div.innerHTML = "<span>" + text + "</span>";
                }
            }
        })();

        SceneJS.Types.addType("cameras/pickFlyOrbit", {

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
                var indicatorSize;

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
                            specular:true,
                            diffuse:false
                        }
                    });

                    var cursorSize = params.cursorSize || 1;

                    indicatorSize = indicatorVis.addNode({
                        type:"scale",
                        id:"__sphereSize",
                        x:cursorSize,
                        y:cursorSize,
                        z:cursorSize,
                        nodes:[
                            {
                                type:"material",
                                color:{ r:0.4, g:1.0, b:0.4 },
                                specularColor:{ r:1.0, g:1.0, b:1.0 },
                                emit:0.2,
                                nodes:[
                                    {
                                        type:"style",
                                        lineWidth:2,
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

                    this.getScene().getNode("__sphereSize", function (n) {
                        n.on("rendered",
                            function (event) {
                                label.setPos(event.getCanvasPos());
                            });
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

                var startPivot;
                var currentPivot = glmat.vec3.fromValues(look.x || 0, look.y || 0, look.z || 0);
                var endPivot = glmat.vec3.fromValues(look.x || 0, look.y || 0, look.z || 0);

                var flightStartTime = null;
                var flightDist;
                var flightDuration;
                var flying = false;
                var orbiting = false;

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
                        orbiting = true;
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
                    orbiting = true;
                }

                function pick(canvasX, canvasY) {
                    scene.pick(canvasX, canvasY, { rayPick:true });
                }

                var scene = this.getScene();

                scene.on("pick",
                    function (hit) {

                        if (hit.name == "__SceneJS_dontPickMe") {
                            return;
                        }

                        startPivot = glmat.vec3.fromValues(currentPivot[0], currentPivot[1], currentPivot[2]);
                        endPivot = hit.worldPos;

                        if (indicatorVis) {
                            indicatorVis.setEnabled(true);
                            indicatorPos.setXYZ({x:endPivot[0], y:endPivot[1], z:endPivot[2] });
                            label.setShown(true);
                        }

                        var vec = glmat.vec3.create();
                        glmat.vec3.sub(vec, endPivot, startPivot);

                        flightDist = glmat.vec3.length(vec);
                        flightStartTime = null;
                        flightDuration = 1000.0 * ((flightDist / 1000) + 1); // extra seconds to ensure arrival
                        flying = true;

                        label.setText("[ " + Math.round(endPivot[0]) + ", " + Math.round(endPivot[1]) + ", " + Math.round(endPivot[2]) + " ]");
                    });

                scene.on("tick",
                    function () {

                        if (flying) {

                            if (flightStartTime == null) {
                                flightStartTime = (new Date()).getTime();
                            }

                            var timeNow = (new Date()).getTime();
                            var timeElapsed = timeNow - flightStartTime;

                            if (timeElapsed >= flightDuration) {
                                flying = false;
                                flying = false;
                                flightStartTime = null;

                                // Hide pick indicator
                                if (indicatorVis) {
//                                    indicatorVis.setEnabled(false);
//                                    label.setShown(false);
                                }
                            } else {


                                var easedTime = easeOut((timeNow - flightStartTime) / flightDuration, 0, 1, 1);

                                // Continue flight
                                // Find new pivot point, interpolated on path towards new point

                                glmat.vec3.lerp(currentPivot, startPivot, endPivot, easedTime);

                                // Need to rotate lookat
                                orbiting = true;
                            }
                        }


                        if (orbiting) {

                            // Update location of point-of-interest indicator
                            if (indicatorVis) {
                                indicatorVis.setEnabled(true);
                                label.setShown(true);
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
                            orbiting = false;

                            if (indicatorVis) {
                                setTimeout(function () {
                                    indicatorVis.setEnabled(false);
                                    label.setShown(false);
                                }, 2000);
                            }
                        }
                    });
            },

            destruct:function () {
                // TODO: remove mouse handlers
            }
        });


        function easeOut(t, b, c, d) {
            var ts = (t /= d) * t;
            var tc = ts * t;
            return b + c * (-1 * ts * ts + 4 * tc + -6 * ts + 4 * t);
        }

        function easeIn(t, b, c, d) {
            var ts = (t /= d) * t;
            var tc = ts * t;
            return b + c * (tc * ts);
        }

    });