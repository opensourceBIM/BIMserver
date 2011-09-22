package org.bimserver.interfaces.objects;

public enum SCompareIdentifier {
	NAME_ID(0),
	GUID_ID(1);
	int ordinal;

	SCompareIdentifier(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}