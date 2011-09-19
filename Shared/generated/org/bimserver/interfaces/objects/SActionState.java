package org.bimserver.interfaces.objects;

public enum SActionState {
	UNKNOWN(0),
	STARTED(1),
	FINISHED(2);
	int ordinal;

	SActionState(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}