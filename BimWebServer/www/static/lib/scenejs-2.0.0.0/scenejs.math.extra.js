/* 
 * Extra routines missing from scenejs.math.js
 */

/**
 * @param u vec3
 * @param v vec3
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, u otherwise
 * @private
 */
var SceneJS_math_mulVec3 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    dest[0] = u[0] * v[0];
    dest[1] = u[1] * v[1];
    dest[2] = u[2] * v[2];

    return dest;
};

/**
 * Also see http://www.euclideanspace.com/maths/geometry/rotations/conversions/matrixToQuaternion/index.htm
 * @param m mat3
 */
var SceneJS_math_newQuaternionFromMat3 = function(m) {
  var tr = m[0 + 0*3] + m[1 + 1*3] + m[2 + 2*3];
  if (tr > 0) {
    var s = Math.sqrt(tr+1.0) * 2;
    return [
      (m[2 + 1*3] - m[1 + 2*3]) / s,
      (m[0 + 2*3] - m[2 + 0*3]) / s,
      (m[1 + 0*3] - m[0 + 1*3]) / s,
      0.25 * s
    ];
  } else if ((m[0 + 0*3] > m[1 + 1*3])&(m[0 + 0*3] > m[2 + 2*3])) { 
    var s = Math.sqrt(1.0 + m[0 + 0*3] - m[1 + 1*3] - m[2 + 2*3]) * 2;
    return [
      0.25 * s,
      (m[0 + 1*3] + m[1 + 0*3]) / s,
      (m[0 + 2*3] + m[2 + 0*3]) / s,
      (m[2 + 1*3] - m[1 + 2*3]) / s
    ];
  } else if (m[1 + 1*3] > m[2 + 2*3]) { 
    var s = Math.sqrt(1.0 + m[1 + 1*3] - m[0 + 0*3] - m[2 + 2*3]) * 2;
    return [
      qx = (m[0 + 1*3] + m[1 + 0*3]) / s,
      qy = 0.25 * s,
      qz = (m[1 + 2*3] + m[2 + 1*3]) / s,
      qw = (m[0 + 2*3] - m[2 + 0*3]) / s
    ];
  } else {
    var s = Math.sqrt(1.0 + m[2 + 2*3] - m[0 + 0*3] - m[1 + 1*3]) * 2;
    return [
      (m[0 + 2*3] + m[2 + 0*3]) / s,
      (m[1 + 2*3] + m[2 + 1*3]) / s,
      0.25 * s,
      (m[1 + 0*3] - m[0 + 1*3]) / s
    ];
  }
};

/** 
 * Get the y-axis row vector of the matrix representation of a quaternion.
 * This function is convenient for some quaternion-camera calculations
 * See also SceneJS_math_newMat4FromQuaternion
 * @param m mat3
 */
var SceneJS_math_newUpVec3FromQuaternion = function(q) {
    var tx = 2.0 * q[0];
    var ty = 2.0 * q[1];
    var tz = 2.0 * q[2];

    var twx = tx * q[3];
    var twz = tz * q[3];
    var txx = tx * q[0];
    var txy = ty * q[0];
    var tyz = tz * q[1];
    var tzz = tz * q[2];
    
    return [txy - twz, 1.0 - (txx + tzz), tyz + twx];
};

