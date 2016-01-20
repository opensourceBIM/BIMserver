package org.bimserver.geometry;

public class Vector2d {

	public static final Vector2d ZERO = null;
	
	public double x;
	public double y;
	public double z;

	public Vector2d(double d, double e) {
		// TODO Auto-generated constructor stub
	}

	public Vector2d() {
		// TODO Auto-generated constructor stub
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}

	public void y(double y) {
		this.y = y;
	}
	
	public void z(double z) {
		this.z = z;
	}
	
	public void x(double x) {
		this.x = x;
	}

	public void sub(Vector2d center) {
		// TODO Auto-generated method stub
		
	}
}
