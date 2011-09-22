package org.bimserver.interfaces.objects;

public enum SCompareType {
	ALL(0),
	ADD(1),
	MODIFY(2),
	DELETE(3);
	int ordinal;

	SCompareType(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}