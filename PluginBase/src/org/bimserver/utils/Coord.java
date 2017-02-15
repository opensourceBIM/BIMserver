package org.bimserver.utils;

public class Coord {
	private double x;
	private double y;
	private double z;

	public Coord(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Coord(double value) {
		x = value;
		y = value;
		z = value;
	}

	public double[] asVector() {
		return new double[]{x, y, z, 1};
	}

	public void setVector(double[] result) {
		x = result[0];
		y = result[1];
		z = result[2];
	}

	public double get(int i) {
		if (i == 0) {
			return x;
		} else if (i == 1) {
			return y;
		} else if (i == 2) {
			return z;
		}
		return 0;
	}

	public void set(int i, double d) {
		if (i == 0) {
			x = d;
		} else if (i == 1) {
			y = d;
		} else if (i == 2) {
			z = d;
		}
	}
}
