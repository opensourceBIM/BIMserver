package org.bimserver.geometry;

import org.eclipse.emf.common.util.EList;

public class AxisAlignedBoundingBox3D {

	private double[] min = new double[3];
	private double[] max = new double[3];
	
	public AxisAlignedBoundingBox3D() {
		min[0] = Double.MAX_VALUE;
		min[1] = Double.MAX_VALUE;
		min[2] = Double.MAX_VALUE;
		max[0] = -Double.MAX_VALUE;
		max[1] = -Double.MAX_VALUE;
		max[2] = -Double.MAX_VALUE;
	}
	
	public void process(EList<Double> coordinates) {
		for (int i=0; i<coordinates.size(); i++) {
			Double value = coordinates.get(i);
			if (value < min[i]) {
				min[i] = value;
			}
			if (value > max[i]) {
				max[i] = value;
			}
		}
	}

	public Vector3D getCenter() {
		return new Vector3D(min[0] + (max[0] - min[0]) / 2d, min[1] + (max[1] - min[1]) / 2d, min[2] + (max[2] - min[2]) / 2d);
	}
}
