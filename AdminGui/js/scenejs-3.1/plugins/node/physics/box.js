/**
 * A box geometry with rigid-body physics behavior
 *
 * Documentation: https://github.com/xeolabs/scenejs/wiki/Physics
 *
 */
SceneJS.Types.addType("physics/box", {
    construct:function (params) {

        this.addNode({
            type:"physics/body",
            shape: "box",
            pos: params.pos,
            size: params.size,
            mass: params.mass,
            restitution: params.restitution,
            friction: params.friction,
            velocity: params.velocity,
            movable: params.movable,

            nodes:[
                {
                    type:"prims/box",
                    size: params.size
                }
            ]
        });
    }
});

