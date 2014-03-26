/**
 * Physics material
 *
 * Documentation: https://github.com/xeolabs/scenejs/wiki/Physics
 */
require([
    // Prefix routes to plugin support libs
    "scenejsPluginDeps/physics/physics"
],
    function (physics) {

        SceneJS.Types.addType("physics/material", {

            construct:function (params) {
                this._material = params;
                if (params.nodes) {
                    this.addNodes(params.nodes);
                }
            },

            preCompile:function () {

                // Child "physics/body" nodes will look for this on the window scope.

                // Seems a bit dirty to put it on window scope, but it's OK because
                // there can only be one scene compilation happening at any moment.

                window._sceneJSPhysicsMaterial = this._material;
            },

            postCompile:function () {
                window._sceneJSPhysicsMaterial = null;
            }
        });
    });
