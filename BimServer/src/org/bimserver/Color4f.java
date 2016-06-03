package org.bimserver;

public class Color4f {
	private float r;
	private float g;
	private float b;
	private float a;

	public Color4f(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public Color4f() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(a);
		result = prime * result + Float.floatToIntBits(b);
		result = prime * result + Float.floatToIntBits(g);
		result = prime * result + Float.floatToIntBits(r);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color4f other = (Color4f) obj;
		if (Float.floatToIntBits(a) != Float.floatToIntBits(other.a))
			return false;
		if (Float.floatToIntBits(b) != Float.floatToIntBits(other.b))
			return false;
		if (Float.floatToIntBits(g) != Float.floatToIntBits(other.g))
			return false;
		if (Float.floatToIntBits(r) != Float.floatToIntBits(other.r))
			return false;
		return true;
	}

	public void set(int index, float val) {
		if (index == 0) {
			r = val;
		} else if (index == 1) {
			g = val;
		} else if (index == 2) {
			b = val;
		} else if (index == 3) {
			a = val;
		}
	}
	
	@Override
	public String toString() {
		return r + ", " + g + ", " + b + ", " + a;
	}
}