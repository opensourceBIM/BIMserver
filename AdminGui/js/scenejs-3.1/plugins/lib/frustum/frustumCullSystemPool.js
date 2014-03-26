/**
 * Container of frustum culling systems
 */
define([
    // Prefix routes to plugin support libs
    "scenejsPluginDeps/frustum/frustumCullSystem"
],
    function (System) {

        // Systems
        var items = {};

        // Each scene/lookat/camera combination will have its own culling system
        // Each system will actually be distributed across multiple systems
        // This is the number of client scene nodes that will be served by each of those
        // TODO: tune this
        var BODIES_PER_SYSTEM = 100;

        return  {

            /**
             * Acquire a frustum culling system for a SceneJS node
             *
             * @param {SceneJS.Node} node
             * @return {System} The system
             */
            getSystem:function (node) {

                // Get parent lookat and camera nodes,
                // along with the scene root

                var lookat = node.getParentOfType("lookAt");
                var camera = node.getParentOfType("camera");
                var scene = node.getScene();

                // Generate a system ID unique to the
                // scene and whatever view and projection
                // coordinate system we are within

                var systemBaseId =
                    scene.getId()
                        + (lookat ? ("." + lookat.getId()) : ".default")
                        + (camera ? ("." + camera.getId()) : ".default")
                        + ".";

                var systemId;
                var item;

                // Try to acquire an existing system
                // using the system ID

                for (var i = 0, done = false; !done; i++) {
                    systemId = systemBaseId + i;
                    item = items[systemId];
                    if (item) {
                        if (item.useCount < BODIES_PER_SYSTEM) {
                            item.useCount++;
                            return item.system;
                        }
                    } else {
                        done = true;
                    }
                }

                // Did not acquire a system - create a new system

                var system = new System(systemId);

                item = {
                    useCount:1,
                    system:system,
                    scene:scene
                };

                var systemConfigs = {};

                // Updates to a parent 'lookat' node
                // will update the system's frustum

                if (lookat) {
                    item.lookat = lookat;
                    item.viewMatSub = lookat.on("matrix",
                        function (matrix) {
                            system.setConfigs({
                                viewMat:matrix
                            });
                        });
                } else {
                    systemConfigs.viewMat = SceneJS.Lookat.getDefaultMatrix();
                }

                // Updates to a parent 'camera' node
                // will update the system's frustum

                if (camera) {
                    item.camera = camera;
                    item.projMatSub = camera.on("matrix",
                        function (matrix) {
                            system.setConfigs({
                                projMat:matrix
                            });
                        });
                } else {
                    systemConfigs.projMat = SceneJS.Camera.getDefaultMatrix();
                }

                // Updates to a parent 'enable' node will
                // enable or disable this culling system

//                var enabled = true;
//                var enable = node.getParentOfType("enable");
//                if (enable) {
//                    item.enable = enable;
//                    item.enableSub = enable.on("enabled",
//                        function (_enabled) {
//                            enabled = _enabled;
//                        });
//                }

                // Integrate the system on each scene tick,
                // unless disabled by parent 'enable' node

                item.tickSub = scene.on("tick", // Start integrating the system on scene tick
                    function () {
                       // if (enabled) {
                            system.integrate();
                       // }
                    });

                //

                var canvas = scene.getCanvas();
                systemConfigs.viewport = [0, 0, canvas.width, canvas.height];

                system.setConfigs(systemConfigs);

                items[systemId] = item;

                return system;
            },


            /**
             * Release a frustum culling system, destroying it if no more users.
             * @param {System} system
             */
            putSystem:function (system) {
                var item = items[system.systemId];
                if (item) {
                    if (item.useCount-- <= 0) {
                        item.system.destroy();

                        // Unsubscribe from any parent nodes
                        // we were updating the system off

                        if (item.lookat) {
                            item.lookat.off(item.viewMatSub);
                        }
                        if (item.camera) {
                            item.camera.off(item.projMatSub);
                        }
                        if (item.enable) {
                            item.enable.off(item.enableSub);
                        }

                        // Stop integrating the system
                        item.scene.off(item.tickSub);

                        delete items[system.systemId];
                    }
                }
            }
        };
    });