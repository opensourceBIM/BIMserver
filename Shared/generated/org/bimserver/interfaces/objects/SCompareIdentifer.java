package org.bimserver.interfaces.objects;

public enum SCompareIdentifer {
	NAME(0),
	GUID(1);
	int ordinal;

	SCompareIdentifer(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}