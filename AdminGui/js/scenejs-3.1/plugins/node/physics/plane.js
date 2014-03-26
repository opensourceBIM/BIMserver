/**
 * A plane geometry with rigid-body physics behavior
 *
 * Documentation: https://github.com/xeolabs/scenejs/wiki/Physics
 *
 */
SceneJS.Types.addType("physics/plane", {
    construct:function (params) {

        this.addNode({
            type:"physics/body",
            shape:"plane",
            pos:params.pos,
            dir:params.dir,
            mass:params.mass,
            restitution:params.restitution,
            friction:params.friction,
            velocity:params.velocity,
            movable:params.movable,

            nodes:[
                {
                    type:"scale",
                    x:1000,
                    y:.5,
                    z:1000,
                    nodes:[
                        {
                            type:"rotate",
                            x:1,
                            angle:90,
                            nodes:[
                                {
                                    type:"prims/plane",
                                    wire:params.wire,
                                    xSegments:params.xSegments || 100,
                                    zSegments:params.zSegments || 100
                                }
                            ]
                        }
                    ]
                }
            ]
        });
    }
});

