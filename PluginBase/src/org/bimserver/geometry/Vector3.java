package org.bimserver.geometry;

public class Vector3 {

	public static float[] normalize(float[] out, float[] a) {
		float x = a[0];
		float y = a[1];
		float z = a[2];
		float len = x*x + y*y + z*z;
		  if (len > 0) {
		    //TODO: evaluate use of glm_invsqrt here?
		    len = (float) (1 / Math.sqrt(len));
		  }
		  out[0] = a[0] * len;
		  out[1] = a[1] * len;
		  out[2] = a[2] * len;
		  return out;
	}
}
