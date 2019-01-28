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

import org.bimserver.models.geometry.Vector3f;

public class AxisAlignedBoundingBox {
	private float[] min;
	private float[] max;

	public AxisAlignedBoundingBox(float[] min, float[] max) {
		this.min = min;
		this.max = max;
	}

	public AxisAlignedBoundingBox(Vector3f min, Vector3f max) {
		this.min = new float[]{(float)min.getX(), (float)min.getY(), (float)min.getZ()};
		this.max = new float[]{(float)max.getX(), (float)max.getY(), (float)max.getZ()};
	}

	public AxisAlignedBoundingBox() {
		min = new float[] { Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE };
		max = new float[] { -Float.MAX_VALUE, -Float.MAX_VALUE, -Float.MAX_VALUE };
	}

	public void process(float[] point) {
		for (int i = 0; i < 3; i++) {
			if (point[i] < min[i]) {
				min[i] = point[i];
			}
			if (point[i] > max[i]) {
				max[i] = point[i];
			}
		}
	}

	@Override
	public String toString() {
		return min[0] + ", " + min[1] + ", " + min[2] + " / " + max[0] + ", " + max[1] + ", " + max[2];
	}

	public boolean closeTo(AxisAlignedBoundingBox other) {
		for (int i = 0; i < 3; i++) {
			if (Math.abs(min[i] - other.min[i]) > .005) {
				return false;
			}
			if (Math.abs(max[i] - other.max[i]) > .005) {
				return false;
			}
		}
		return true;
	}
	
	public float[] getMin() {
		return min;
	}
	
	public float[] getMax() {
		return max;
	}

	public void enlarge(float f) {
		for (int i=0; i<3; i++) {
			min[i] = min[i] - f;
			max[i] = max[i] + f;
		}
	}
}