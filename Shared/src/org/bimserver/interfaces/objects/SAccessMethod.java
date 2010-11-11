package org.bimserver.interfaces.objects;

public enum SAccessMethod {
	SOAP(0),
	WEB_INTERFACE(1),
	INTERNAL(2);
	int ordinal;

	SAccessMethod(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}