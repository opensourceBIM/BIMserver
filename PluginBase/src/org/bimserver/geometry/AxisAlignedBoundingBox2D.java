package org.bimserver.geometry;

import org.eclipse.emf.common.util.EList;

public class AxisAlignedBoundingBox2D {

	private double[] min = new double[2];
	private double[] max = new double[2];
	
	public AxisAlignedBoundingBox2D() {
		min[0] = Double.MAX_VALUE;
		min[1] = Double.MAX_VALUE;
		max[0] = -Double.MAX_VALUE;
		max[1] = -Double.MAX_VALUE;
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

	public Vector2D getCenter() {
		return new Vector2D(min[0] + (max[0] - min[0]) / 2d, min[1] + (max[1] - min[1]) / 2d);
	}
}
