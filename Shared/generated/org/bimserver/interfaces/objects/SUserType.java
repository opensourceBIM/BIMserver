package org.bimserver.interfaces.objects;

public enum SUserType {
	SYSTEM(0),
	ADMIN(1),
	USER(2),
	ANONYMOUS(3);
	int ordinal;

	SUserType(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}