package org.bimserver.utils;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.geometry.Matrix;

public class Cube {
	
	private List<Coord> coords = new ArrayList<>();
	
	public Cube(double[] min, double[] max) {
		coords.add(new Coord(min[0], min[1], min[2])); // min
		coords.add(new Coord(max[0], min[1], min[2])); // front
		coords.add(new Coord(max[0], max[1], min[2])); // front
		coords.add(new Coord(min[0], max[1], min[2])); // front

		coords.add(new Coord(max[0], max[1], max[2])); // max
		coords.add(new Coord(min[0], max[1], max[2])); // max
		coords.add(new Coord(min[0], min[1], max[2])); // max
		coords.add(new Coord(max[0], min[1], max[2])); // max
	}

	public Cube() {
	}

	public void transform(double[] matrix) {
		for (Coord coord : coords) {
			double[] result = new double[4];
			Matrix.multiplyMV(result, 0, matrix, 0, coord.asVector(), 0);
			coord.setVector(result);
		}
	}

	public double[] getMin() {
		Coord min = new Coord(Double.MAX_VALUE);
		for (Coord coord : coords) {
			for (int i=0; i<3; i++) {
				if (coord.get(i) < min.get(i)) {
					min.set(i, coord.get(i));
				}
			}
		}
		return min.asVector();
	}

	public double[] getMax() {
		Coord max = new Coord(-Double.MAX_VALUE);
		for (Coord coord : coords) {
			for (int i=0; i<3; i++) {
				if (coord.get(i) > max.get(i)) {
					max.set(i, coord.get(i));
				}
			}
		}
		return max.asVector();
	}

	public void add(Coord coord) {
		coords.add(coord);
	}
}
