/**
 * A sphere geometry with rigid-body physics behavior
 *
 * Documentation: https://github.com/xeolabs/scenejs/wiki/Physics
 *
 */
SceneJS.Types.addType("physics/sphere", {
    construct:function (params) {

        this.addNode({
            type:"physics/sphere",
            shape: "sphere",
            pos: params.pos,
            radius: params.radius,
            mass: params.mass,
            restitution: params.restitution,
            friction: params.friction,
            velocity: params.velocity,
            movable: params.movable,

            nodes:[
                {
                    type:"prims/radius",
                    latitudeBands: params.latitudeBands,
                    longitudeBands: params.longitudeBands,
                    radius: params.radius
                }
            ]
        });
    }
});

