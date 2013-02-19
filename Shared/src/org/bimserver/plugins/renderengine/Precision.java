package org.bimserver.plugins.renderengine;

public enum Precision {
	SINGLE(32),
	DOUBLE(64);
	
	public static final int BIT = 4;
	private int width;

	public int getWidth() {
		return width;
	}
	
	Precision(int width) {
		this.width = width;
	}

	public int getValue() {
		return this == SINGLE ? 0 : BIT;
	}
}
