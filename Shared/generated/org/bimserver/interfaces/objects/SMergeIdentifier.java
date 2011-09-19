package org.bimserver.interfaces.objects;

public enum SMergeIdentifier {
	NAME(0),
	GUID(1);
	int ordinal;

	SMergeIdentifier(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}