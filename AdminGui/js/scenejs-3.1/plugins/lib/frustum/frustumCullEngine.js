//
// 3D frustum culling engine
//
// Has a view matrix, projection matrix, viewport and
//
// This file is supposed to  be loaded into a Web Worker, so everything's global
// and we're not bothering with name spaces etc.
//

var OUTSIDE_FRUSTUM = 0;
var INTERSECT_FRUSTUM = 1;
var INSIDE_FRUSTUM = 2;

/**
 * A frustum culling engine
 * @param cfg
 * @constructor
 */
function Engine(cfg) {

    // The current view matrix
    this._viewMat = identityMat4();

    // Current projection matrix
    this._projMat = identityMat4();

    // Current viewport
    this._viewport = [0, 0, 1, 1];

    // Culling frustum constructed from matrices and viewport
    this._frustum = null;

    // Set when matrices or viewport reconfigured, causes frustum lazy-rebuild on next integration
    this._frustumDirty = true;

    // Body map, holds bodies by ID
    this._bodies = {};

    // Bodies in array for efficient iteration
    this._bodyList = [];
    this._numBodies = 0;

    // Set when body map updated, causes body list lazy-rebuild on next integration
    this._bodyListDirty = false;

    // Output array containing updated bodies after each integration    
    this._updatedBodies = [];

    if (cfg) {
        this.setConfigs(cfg);
    }
}

/**
 * Configures the engine
 * @param cfg
 * @param {Array(16)} [cfg.viewMat] View matrix
 * @param {Array(16)} [cfg.projMat] Projection matrix
 * @param {Array(4)} [cfg.viewport] Viewport
 */
Engine.prototype.setConfigs = function (cfg) {
    // Configure view matrix
    if (cfg.viewMat) {
        this._viewMat = cfg.viewMat;
        this._frustumDirty = true;
    }
    // Configure projection matrix
    if (cfg.projMat) {
        this._projMat = cfg.projMat;
        this._frustumDirty = true;
    }
    // Configure viewport
    if (cfg.viewport) {
        this._viewport = cfg.viewport;
        this._frustumDirty = true;
    }
};

/**
 * Adds a body to the engine
 * @param {Number} bodyId Unique body ID
 * @param {*} cfg Body properties
 */
Engine.prototype.addBody = function (bodyId, cfg) {
    if (this._bodies[bodyId]) {
        throw "Body with this ID already added: " + bodyId;
    }
    this._bodies[bodyId] = new Body(bodyId, cfg);
    this._bodyListDirty = true;
};

/**
 * Updates a body
 * @param {Number} bodyId Unique body ID
 * @param {*} cfg New values for body properties
 */
Engine.prototype.updateBody = function (bodyId, cfg) {
    var body = this._bodies[bodyId];
    if (!body) {
        throw "Body with this ID not found: " + bodyId;
    }
    body.update(cfg);
};

/**
 * Removes a body that was added with {@link #addBody}
 * @param {Number} bodyId ID of body
 */
Engine.prototype.removeBody = function (bodyId) {
    delete this._bodies[bodyId];
    this._bodyListDirty = true;
};

/**
 * Finds updates in frustum intersection status for bodies,
 * Returns an array of ststus updates for the bodies in a callback
 * @param {Function(Array,Number)} callback Returns array of {@link Body}s that have changed status,
 * plus length of the array
 */
Engine.prototype.integrate = function (callback) {
    // Lazy-rebuilds frustum after engine reconfiguration
    if (this._frustumDirty) {
        this._rebuildFrustum();
    }
    // Lazy-rebuilds body list after body map updated
    if (this._bodyListDirty) {
        this._rebuildBodyList();
    }
    var numUpdatedBodies = 0;
    var body;
    var intersect;
    var canvasSize;

    for (var i = 0; i < this._numBodies; i++) {
        body = this._bodyList[i];
        intersect = -1;
        canvasSize = -1;
        if (body.frustumCull) {
            // Frustum cull this body
            intersect = this._frustum.textAxisBoxIntersection(body);
            if (body.detailCull) {
                // And detail cull
                switch (intersect) {
                    case INTERSECT_FRUSTUM:
                    case INSIDE_FRUSTUM:
                        body.projBox.fromPoints(body.viewBox);
                        canvasSize = this._frustum.getProjectedSize(body.projBox);
                        break;
                }
            }
        } else {
            // Just detail cull
            body.projBox.fromPoints(body.viewBox);
            canvasSize = this._frustum.getProjectedSize(body.projBox);
        }

        if (intersect !== body.intersect || canvasSize != body.canvasSize) {
            body.intersect = intersect;
            body.canvasSize = canvasSize;
            this._updatedBodies[numUpdatedBodies++] = body;
        }
    }
    callback(this._updatedBodies, numUpdatedBodies);
};

/**
 * Rebuilds culling frustum from matrices and viewport
 */
Engine.prototype._rebuildFrustum = function () {
    this._frustum = new Frustum(this._viewMat, this._projMat, this._viewport);
    this._frustumDirty = false;
};

/**
 * Rebuilds body list from body map
 */
Engine.prototype._rebuildBodyList = function () {
    this._numBodies = 0;
    for (var bodyId in this._bodies) {
        if (this._bodies.hasOwnProperty(bodyId)) {
            this._bodyList[this._numBodies++] = this._bodies[bodyId];
        }
    }
    this._bodyListDirty = false;
};

/**
 * A body in the frustum culling engine
 * @param {Number} bodyId Body ID, unique within the engine
 * @param {*} cfg Body properties
 * @param {*} [cfg.box] Axis-aligned world-space bounding box
 * @param {Array(3)} [cfg.box.min] Axis-aligned bounding box minimum extents
 * @param {Array(3)} [cfg.box.max] Axis-aligned bounding box maximum extents
 * @constructor
 */
function Body(bodyId, cfg) {

    /**
     * Unique ID within engine
     * @type {*}
     */
    this.bodyId = bodyId;

    /**
     * World-space extents
     */
    this.min = cfg.min;
    this.max = cfg.max;

    /**
     * True when frustum culling is to be performed for this body
     */
    this.frustumCull = cfg.frustumCull != undefined ? cfg.frustumCull : true;

    /**
     * True when projected canvas size is to be determined for this body
     */
    this.detailCull = cfg.detailCull != undefined ? cfg.detailCull : true;

    /**
     * View-space extents
     */
    this.viewBox = [
        [this.min[0], this.min[1], this.min[2]],
        [this.max[0], this.min[1], this.min[2]],
        [this.max[0], this.max[1], this.min[2]],
        [this.min[0], this.max[1], this.min[2]],
        [this.min[0], this.min[1], this.max[2]],
        [this.max[0], this.min[1], this.max[2]],
        [this.max[0], this.max[1], this.max[2]],
        [this.min[0], this.max[1], this.max[2]]
    ];

    /**
     * Projection-space extents
     */
    this.projBox = new Box3();

    /**
     * Intersection status
     * @type {Number}
     */
    this.intersect = null;

    /**
     * Projected size
     * @type {Number}
     */
    this.canvasSize = null;
}

Body.prototype.update = function (cfg) {
//    if (cfg.min || cfg.max) {
//        if (cfg.min) {
//            this.min = cfg.min;
//            this.viewBox[0][0] = this.min[0];
//            this.viewBox[0][1] = this.min[1];
//            this.viewBox[0][2] = this.min[2];
//
//                [this.max[0], this.min[1], this.min[2]],
//                [this.max[0], this.max[1], this.min[2]],
//                [this.min[0], this.max[1], this.min[2]],
//                [this.min[0], this.min[1], this.max[2]],
//                [this.max[0], this.min[1], this.max[2]],
//                [this.max[0], this.max[1], this.max[2]],
//                [this.min[0], this.max[1], this.max[2]]
//        }
//        if (cfg.max) {
//            this.max = cfg.max;
//        }
//        this.viewBox[0][0]
//            [this.min[0], this.min[1], this.min[2]],
//            [this.max[0], this.min[1], this.min[2]],
//            [this.max[0], this.max[1], this.min[2]],
//            [this.min[0], this.max[1], this.min[2]],
//            [this.min[0], this.min[1], this.max[2]],
//            [this.max[0], this.min[1], this.max[2]],
//            [this.max[0], this.max[1], this.max[2]],
//            [this.min[0], this.max[1], this.max[2]]
//    ]
//        ;
//
//    }
};

function Frustum(viewMat, projMat, viewport) {

    var m = mat4();

    mulMat4(projMat, viewMat, m);

    // cache m indexes
    var m0 = m[0], m1 = m[1], m2 = m[2], m3 = m[3];
    var m4 = m[4], m5 = m[5], m6 = m[6], m7 = m[7];
    var m8 = m[8], m9 = m[9], m10 = m[10], m11 = m[11];
    var m12 = m[12], m13 = m[13], m14 = m[14], m15 = m[15];

    //var q = [ m[3], m[7], m[11] ]; just reuse m indexes instead of making new var
    var planes = [
        new FrustumPlane(m3 - m0, m7 - m4, m11 - m8, m15 - m12),
        new FrustumPlane(m3 + m0, m7 + m4, m11 + m8, m15 + m12),
        new FrustumPlane(m3 - m1, m7 - m5, m11 - m9, m15 - m13),
        new FrustumPlane(m3 + m1, m7 + m5, m11 + m9, m15 + m13),
        new FrustumPlane(m3 - m2, m7 - m6, m11 - m10, m15 - m14),
        new FrustumPlane(m3 + m2, m7 + m6, m11 + m10, m15 + m14)
    ];

    // Resources for LOD

    var rotVec = [
        getColMat4(viewMat, 0),
        getColMat4(viewMat, 1),
        getColMat4(viewMat, 2)
    ];

    var scaleVec = [
        lenVec4(rotVec[0]),
        lenVec4(rotVec[1]),
        lenVec4(rotVec[2])
    ];

    var scaleVecRcp = rcpVec3(scaleVec);
    var sMat = scalingMat4v(scaleVec);
    var sMatInv = scalingMat4v(scaleVecRcp);

    mulVec4Scalar(rotVec[0], scaleVecRcp[0]);
    mulVec4Scalar(rotVec[1], scaleVecRcp[1]);
    mulVec4Scalar(rotVec[2], scaleVecRcp[2]);

    var rotMatInverse = identityMat4();

    setRowMat4(rotMatInverse, 0, rotVec[0]);
    setRowMat4(rotMatInverse, 1, rotVec[1]);
    setRowMat4(rotMatInverse, 2, rotVec[2]);

    if (!this.matrix) {
        this.matrix = mat4();
    }

    mulMat4(projMat, viewMat, this.matrix);

    if (!this.billboardMatrix) {
        this.billboardMatrix = mat4();
    }

    mulMat4(sMatInv, mulMat4(rotMatInverse, sMat), this.billboardMatrix);
    this.viewport = viewport.slice(0, 4);

    this.textAxisBoxIntersection = function (box) {
        var ret = INSIDE_FRUSTUM;
        var bminmax = [ box.min, box.max ];
        var plane = null;
        for (var i = 0; i < 6; ++i) {
            plane = planes[i];
            if (((plane.normal[0] * bminmax[plane.testVertex[0]][0]) +
                (plane.normal[1] * bminmax[plane.testVertex[1]][1]) +
                (plane.normal[2] * bminmax[plane.testVertex[2]][2]) +
                (plane.offset)) < 0.0) {
                return OUTSIDE_FRUSTUM;
            }
            if (((plane.normal[0] * bminmax[1 - plane.testVertex[0]][0]) +
                (plane.normal[1] * bminmax[1 - plane.testVertex[1]][1]) +
                (plane.normal[2] * bminmax[1 - plane.testVertex[2]][2]) +
                (plane.offset)) < 0.0) {
                ret = INTERSECT_FRUSTUM;
            }
        }
        return ret;
    };

    this.getProjectedSize = function (box) {
        var diagVec = mat4();
        subVec3(box.max, box.min, diagVec);

        var diagSize = lenVec3(diagVec);

        var size = Math.abs(diagSize);

        var p0 = [
            (box.min[0] + box.max[0]) * 0.5,
            (box.min[1] + box.max[1]) * 0.5,
            (box.min[2] + box.max[2]) * 0.5,
            0.0];

        var halfSize = size * 0.5;
        var p1 = [ -halfSize, 0.0, 0.0, 1.0 ];
        var p2 = [  halfSize, 0.0, 0.0, 1.0 ];

        p1 = mulMat4v4(this.billboardMatrix, p1);
        p1 = addVec4(p1, p0);
        p1 = projectVec4(mulMat4v4(this.matrix, p1));

        p2 = mulMat4v4(this.billboardMatrix, p2);
        p2 = addVec4(p2, p0);
        p2 = projectVec4(mulMat4v4(this.matrix, p2));

        return viewport[2] * Math.abs(p2[0] - p1[0]);
    };


    this.getProjectedState = function (modelviewBox) {
        var viewviewBox = transformPoints3(this.matrix, modelviewBox);

        //var canvasBox = {
        //    min: [10000000, 10000000 ],
        //    max: [-10000000, -10000000]
        //};
        // separate variables instead of indexing an array
        var canvasBoxMin0 = 10000000, canvasBoxMin1 = 10000000;
        var canvasBoxMax0 = -10000000, canvasBoxMax1 = -10000000;

        var v, x, y;

        var arrLen = viewviewBox.length;
        for (var i = 0; i < arrLen; ++i) {
            v = projectVec4(viewviewBox[i]);
            x = v[0];
            y = v[1];

            if (x < -0.5) {
                x = -0.5;
            }

            if (y < -0.5) {
                y = -0.5;
            }

            if (x > 0.5) {
                x = 0.5;
            }

            if (y > 0.5) {
                y = 0.5;
            }


            if (x < canvasBoxMin0) {
                canvasBoxMin0 = x;
            }
            if (y < canvasBoxMin1) {
                canvasBoxMin1 = y;
            }
            if (x > canvasBoxMax0) {
                canvasBoxMax0 = x;
            }
            if (y > canvasBoxMax1) {
                canvasBoxMax1 = y;
            }
        }

        canvasBoxMin0 += 0.5;
        canvasBoxMin1 += 0.5;
        canvasBoxMax0 += 0.5;
        canvasBoxMax1 += 0.5;

        // cache viewport indexes
        var viewport2 = viewport[2], viewport3 = viewport[3];

        canvasBoxMin0 = (canvasBoxMin0 * (viewport2 + 15));
        canvasBoxMin1 = (canvasBoxMin1 * (viewport3 + 15));
        canvasBoxMax0 = (canvasBoxMax0 * (viewport2 + 15));
        canvasBoxMax1 = (canvasBoxMax1 * (viewport3 + 15));

        var diagCanvasBoxVec = mat4();
        subVec2([canvasBoxMax0, canvasBoxMax1], [canvasBoxMin0, canvasBoxMin1], diagCanvasBoxVec);
        var diagCanvasBoxSize = lenVec2(diagCanvasBoxVec);

        if (canvasBoxMin0 < 0) {
            canvasBoxMin0 = 0;
        }
        if (canvasBoxMax0 > viewport2) {
            canvasBoxMax0 = viewport2;
        }

        if (canvasBoxMin1 < 0) {
            canvasBoxMin1 = 0;
        }
        if (canvasBoxMax1 > viewport3) {
            canvasBoxMax1 = viewport3;
        }
        return diagCanvasBoxSize;
//        return {
//            canvasBox:{
//                min:[canvasBoxMin0, canvasBoxMin1 ],
//                max:[canvasBoxMax0, canvasBoxMax1 ]
//            },
//            canvasSize:diagCanvasBoxSize
//        };
    };
}

function mat4() {
    return new Array(16);
}

function mulMat4(a, b, dest) {

    if (!dest) {
        dest = a;
    }

    // Cache the matrix values (makes for huge speed increases!)
    var a00 = a[0], a01 = a[1], a02 = a[2], a03 = a[3];
    var a10 = a[4], a11 = a[5], a12 = a[6], a13 = a[7];
    var a20 = a[8], a21 = a[9], a22 = a[10], a23 = a[11];
    var a30 = a[12], a31 = a[13], a32 = a[14], a33 = a[15];

    var b00 = b[0], b01 = b[1], b02 = b[2], b03 = b[3];
    var b10 = b[4], b11 = b[5], b12 = b[6], b13 = b[7];
    var b20 = b[8], b21 = b[9], b22 = b[10], b23 = b[11];
    var b30 = b[12], b31 = b[13], b32 = b[14], b33 = b[15];

    dest[0] = b00 * a00 + b01 * a10 + b02 * a20 + b03 * a30;
    dest[1] = b00 * a01 + b01 * a11 + b02 * a21 + b03 * a31;
    dest[2] = b00 * a02 + b01 * a12 + b02 * a22 + b03 * a32;
    dest[3] = b00 * a03 + b01 * a13 + b02 * a23 + b03 * a33;
    dest[4] = b10 * a00 + b11 * a10 + b12 * a20 + b13 * a30;
    dest[5] = b10 * a01 + b11 * a11 + b12 * a21 + b13 * a31;
    dest[6] = b10 * a02 + b11 * a12 + b12 * a22 + b13 * a32;
    dest[7] = b10 * a03 + b11 * a13 + b12 * a23 + b13 * a33;
    dest[8] = b20 * a00 + b21 * a10 + b22 * a20 + b23 * a30;
    dest[9] = b20 * a01 + b21 * a11 + b22 * a21 + b23 * a31;
    dest[10] = b20 * a02 + b21 * a12 + b22 * a22 + b23 * a32;
    dest[11] = b20 * a03 + b21 * a13 + b22 * a23 + b23 * a33;
    dest[12] = b30 * a00 + b31 * a10 + b32 * a20 + b33 * a30;
    dest[13] = b30 * a01 + b31 * a11 + b32 * a21 + b33 * a31;
    dest[14] = b30 * a02 + b31 * a12 + b32 * a22 + b33 * a32;
    dest[15] = b30 * a03 + b31 * a13 + b32 * a23 + b33 * a33;

    return dest;
}

function FrustumPlane(nx, ny, nz, offset) {
    var s = 1.0 / Math.sqrt(nx * nx + ny * ny + nz * nz);
    this.normal = [nx * s, ny * s, nz * s];
    this.offset = offset * s;
    this.testVertex = [
        (this.normal[0] >= 0.0) ? (1) : (0),
        (this.normal[1] >= 0.0) ? (1) : (0),
        (this.normal[2] >= 0.0) ? (1) : (0)];
}

function getColMat4(m, c) {
    var i = c * 4;
    return [m[i], m[i + 1], m[i + 2], m[i + 3]];
}

function lenVec4(v) {
    return Math.sqrt(sqLenVec4(v));
}

function sqLenVec4(v) {
    return dotVec4(v, v);
}

function dotVec4(u, v) {
    return (u[0] * v[0] + u[1] * v[1] + u[2] * v[2] + u[3] * v[3]);
}

function rcpVec3(v, dest) {
    return divScalarVec3(1.0, v, dest);
}

function divScalarVec3(s, v, dest) {
    if (!dest) {
        dest = v;
    }
    dest[0] = s / v[0];
    dest[1] = s / v[1];
    dest[2] = s / v[2];
    return dest;
}

function scalingMat4v(v) {
    var m = identityMat4();
    m[0] = v[0];
    m[5] = v[1];
    m[10] = v[2];
    return m;
}

function identityMat4() {
    return diagonalMat4v([1.0, 1.0, 1.0, 1.0]);
}

function diagonalMat4v(v) {
    return [
        v[0], 0.0, 0.0, 0.0,
        0.0, v[1], 0.0, 0.0,
        0.0, 0.0, v[2], 0.0,
        0.0, 0.0, 0.0, v[3]
    ];
}

function mulVec4Scalar(v, s, dest) {
    if (!dest) {
        dest = v;
    }
    dest[0] = v[0] * s;
    dest[1] = v[1] * s;
    dest[2] = v[2] * s;
    dest[3] = v[3] * s;
    return dest;
}

function setRowMat4(m, r, v) {
    m[r] = v[0];
    m[r + 4] = v[1];
    m[r + 8] = v[2];
    m[r + 12] = v[3];
}

function subVec3(u, v, dest) {
    if (!dest) {
        dest = u;
    }
    dest[0] = u[0] - v[0];
    dest[1] = u[1] - v[1];
    dest[2] = u[2] - v[2];
    return dest;
}

function lenVec3(v) {
    return Math.sqrt(sqLenVec3(v));
}

function mulMat4v4(m, v) {
    var v0 = v[0], v1 = v[1], v2 = v[2], v3 = v[3];

    return [
        m[0] * v0 + m[4] * v1 + m[8] * v2 + m[12] * v3,
        m[1] * v0 + m[5] * v1 + m[9] * v2 + m[13] * v3,
        m[2] * v0 + m[6] * v1 + m[10] * v2 + m[14] * v3,
        m[3] * v0 + m[7] * v1 + m[11] * v2 + m[15] * v3
    ];
}

function sqLenVec3(v) {
    return dotVector3(v, v);
}

function dotVector3(u, v) {
    return (u[0] * v[0] + u[1] * v[1] + u[2] * v[2]);
}

function addVec4(u, v, dest) {
    if (!dest) {
        dest = u;
    }
    dest[0] = u[0] + v[0];
    dest[1] = u[1] + v[1];
    dest[2] = u[2] + v[2];
    dest[3] = u[3] + v[3];
    return dest;
}

function projectVec4(v) {
    var f = 1.0 / v[3];
    return [v[0] * f, v[1] * f, v[2] * f, 1.0];
}

function transformPoints3(m, points) {
    var result = new Array(points.length);
    var len = points.length;
    var p0, p1, p2;
    var pi;
    // cache values
    var m0 = m[0], m1 = m[1], m2 = m[2], m3 = m[3];
    var m4 = m[4], m5 = m[5], m6 = m[6], m7 = m[7];
    var m8 = m[8], m9 = m[9], m10 = m[10], m11 = m[11];
    var m12 = m[12], m13 = m[13], m14 = m[14], m15 = m[15];
    for (var i = 0; i < len; ++i) {
        // cache values
        pi = points[i];
        p0 = pi[0];
        p1 = pi[1];
        p2 = pi[2];
        result[i] = [
            (m0 * p0) + (m4 * p1) + (m8 * p2) + m12,
            (m1 * p0) + (m5 * p1) + (m9 * p2) + m13,
            (m2 * p0) + (m6 * p1) + (m10 * p2) + m14,
            (m3 * p0) + (m7 * p1) + (m11 * p2) + m15
        ];
    }
    return result;
}

//function subVec2(u, v, dest) {
//    if (!dest) {
//        dest = u;
//    }
//    dest[0] = u[0] - v[0];
//    dest[1] = u[1] - v[1];
//    return dest;
//}
//
//function lenVec2(v) {
//    return Math.sqrt(sqLenVec2(v));
//}

function sqLenVec2(v) {
    return dotVector2(v, v);
}

function dotVector2(u, v) {
    return (u[0] * v[0] + u[1] * v[1]);
}

var MAX_DOUBLE = Number.POSITIVE_INFINITY;
var MIN_DOUBLE = Number.NEGATIVE_INFINITY;

function Box3(min, max) {

    this.min = min || [ MAX_DOUBLE, MAX_DOUBLE, MAX_DOUBLE ];
    this.max = max || [ MIN_DOUBLE, MIN_DOUBLE, MIN_DOUBLE ];

    this.init = function (min, max) {
        this.min[0] = min[0];
        this.min[1] = min[1];
        this.min[2] = min[2];
        this.max[0] = max[0];
        this.max[1] = max[1];
        this.max[2] = max[2];
        return this;
    };

    this.fromPoints = function (points) {
        var pointsLength = points.length;
        for (var i = 0; i < pointsLength; ++i) {
            //   var points_i3 = points[i][3];
            var points_i3 = 1;
            var pDiv0 = points[i][0] / points_i3;
            var pDiv1 = points[i][1] / points_i3;
            var pDiv2 = points[i][2] / points_i3;

            if (pDiv0 < this.min[0]) {
                this.min[0] = pDiv0;
            }
            if (pDiv1 < this.min[1]) {
                this.min[1] = pDiv1;
            }
            if (pDiv2 < this.min[2]) {
                this.min[2] = pDiv2;
            }
            if (pDiv0 > this.max[0]) {
                this.max[0] = pDiv0;
            }
            if (pDiv1 > this.max[1]) {
                this.max[1] = pDiv1;
            }
            if (pDiv2 > this.max[2]) {
                this.max[2] = pDiv2;
            }
        }
        return this;
    };

    this.isEmpty = function () {
        return (
            (this.min[0] >= this.max[0]) &&
                (this.min[1] >= this.max[1]) &&
                (this.min[2] >= this.max[2])
            );
    };

    this.getCenter = function () {
        return [
            (this.max[0] + this.min[0]) / 2.0,
            (this.max[1] + this.min[1]) / 2.0,
            (this.max[2] + this.min[2]) / 2.0
        ];
    };

    this.getSize = function () {
        return [
            (this.max[0] - this.min[0]),
            (this.max[1] - this.min[1]),
            (this.max[2] - this.min[2])
        ];
    };

    this.getFacesAreas = function () {
        var s = this.size;
        return [
            (s[1] * s[2]),
            (s[0] * s[2]),
            (s[0] * s[1])
        ];
    };

    this.getSurfaceArea = function () {
        var a = this.getFacesAreas();
        return ((a[0] + a[1] + a[2]) * 2.0);
    };

    this.getVolume = function () {
        var s = this.size;
        return (s[0] * s[1] * s[2]);
    };

    this.getOffset = function (half_delta) {
        this.min[0] -= half_delta;
        this.min[1] -= half_delta;
        this.min[2] -= half_delta;
        this.max[0] += half_delta;
        this.max[1] += half_delta;
        this.max[2] += half_delta;
        return this;
    };
}
