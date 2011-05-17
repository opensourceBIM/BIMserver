package org.bimserver.plugins.schema;

public class IntegerBound extends Bound {
	//-1 == unbounded
	private int bound_value = -1;

	public int getBound_value() {
		return bound_value;
	}

	public void setBound_value(int bound_value) {
		this.bound_value = bound_value;
	}

	public IntegerBound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IntegerBound(int bound_value) {
		super();
		this.bound_value = bound_value;
	}
	
}
