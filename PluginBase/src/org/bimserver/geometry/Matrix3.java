package org.bimserver.geometry;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

public class Matrix3 {
	public static double[] invert(double[] out, double[] a) {
		double a00 = a[0], a01 = a[1], a02 = a[2];
		double a10 = a[3], a11 = a[4], a12 = a[5];
		double a20 = a[6], a21 = a[7], a22 = a[8];
		double b01 = a22 * a11 - a12 * a21;
		double b11 = -a22 * a10 + a12 * a20;
		double b21 = a21 * a10 - a11 * a20;
		// Calculate the determinant
		double det = a00 * b01 + a01 * b11 + a02 * b21;
		if (!Double.isFinite(det)) {
			return null;
		}
		det = 1.0 / det;
		out[0] = b01 * det;
		out[1] = (-a22 * a01 + a02 * a21) * det;
		out[2] = (a12 * a01 - a02 * a11) * det;
		out[3] = b11 * det;
		out[4] = (a22 * a00 - a02 * a20) * det;
		out[5] = (-a12 * a00 + a02 * a10) * det;
		out[6] = b21 * det;
		out[7] = (-a21 * a00 + a01 * a20) * det;
		out[8] = (a11 * a00 - a01 * a10) * det;
		return out;
	}

	public static void transpose(double[] out, double[] a) {
		 // If we are transposing ourselves we can skip a few steps but have to cache some values
		  if (out == a) {
		    double a01 = a[1], a02 = a[2], a12 = a[5];
		    out[1] = a[3];
		    out[2] = a[6];
		    out[3] = a01;
		    out[5] = a[7];
		    out[6] = a02;
		    out[7] = a12;
		  } else {
		    out[0] = a[0];
		    out[1] = a[3];
		    out[2] = a[6];
		    out[3] = a[1];
		    out[4] = a[4];
		    out[5] = a[7];
		    out[6] = a[2];
		    out[7] = a[5];
		    out[8] = a[8];
		  }
	}

	public static void fromMat4(double[] out, double[] a) {
		 out[0] = a[0];
		  out[1] = a[1];
		  out[2] = a[2];
		  out[3] = a[4];
		  out[4] = a[5];
		  out[5] = a[6];
		  out[6] = a[8];
		  out[7] = a[9];
		  out[8] = a[10];
	}

	public static void multiplyMV(float[] out, float[] a, double[] m) {
		 double x = a[0], y = a[1], z = a[2];
		  out[0] = (float) (x * m[0] + y * m[3] + z * m[6]);
		  out[1] = (float) (x * m[1] + y * m[4] + z * m[7]);
		  out[2] = (float) (x * m[2] + y * m[5] + z * m[8]);
	}
}
