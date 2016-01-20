package org.bimserver.geometry;

public class Colord {

	public int r;
	public int g;
	public int b;
	private int a;
	
	public Colord(int r, int g, int b, int a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public Colord(double d) {
		// TODO Auto-generated constructor stub
	}

	public double r() {
		return r;
	}

	public double g() {
		return g;
	}

	public double b() {
		return b;
	}
	
	public double a() {
		return a;
	}
}
