/**
 * A teapot geometry with rigid-body physics behavior
 *
 * Documentation: https://github.com/xeolabs/scenejs/wiki/Physics
 *
 */
SceneJS.Types.addType("physics/teapot", {
    construct:function (params) {

        this.addNode({
            type:"physics/body",
            shape: "sphere",
            pos: params.pos,
            radius: 1,
            mass: params.mass,
            restitution: params.restitution,
            friction: params.friction,
            velocity: params.velocity,
            movable: params.movable,

            nodes:[
                {
                    type:"prims/teapot"
                }
            ]
        });
    }
});

