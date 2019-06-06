package org.bimserver.geometry;

/******************************************************************************
 * Copyright (C) 2009-2019 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see
 * {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

public class Vector3D extends Vector0D implements Comparable<Vector3D> {

	private double x;
	private double y;
	private double z;

	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static float[] normalize(float[] out, float[] a) {
		float x = a[0];
		float y = a[1];
		float z = a[2];
		float len = x * x + y * y + z * z;
		if (len > 0) {
			// TODO: evaluate use of glm_invsqrt here?
			len = (float) (1 / Math.sqrt(len));
		}
		out[0] = a[0] * len;
		out[1] = a[1] * len;
		out[2] = a[2] * len;
		return out;
	}

	public Double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	@Override
	public double get(int index) {
		switch (index) {
		case 0:
			return x;
		case 1:
			return y;
		case 2:
			return z;
		}
		return 0;
	}

	@Override
	public int compareTo(Vector3D o) {
		if (o.x != x) {
			return Double.compare(o.x, x);
		}
		if (o.y != y) {
			return Double.compare(o.y, y);
		}
		if (o.z != z) {
			return Double.compare(o.z, z);
		}
		return 0;
	}
}