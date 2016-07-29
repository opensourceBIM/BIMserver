package org.bimserver.geometry;

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