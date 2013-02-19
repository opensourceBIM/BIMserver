package org.bimserver.plugins.renderengine;

public enum IndexFormat {
	I32(32),
	I64(64), 
	AUTO_DETECT(-1);

	public static final int BIT = 8;
	private int width;

	IndexFormat(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}

	public int getValue() {
		if (this == AUTO_DETECT) {
			if (System.getProperty("sun.arch.data.model").equals("32")) {
				return 0;
			} else {
				return BIT;
			}
		}
		return this == I32 ? 0 : BIT;
	}
}
