package org.bimserver.interfaces.objects;

import java.util.*;
public enum SObjectState {
	ACTIVE(0),
	DELETED(1);
	int ordinal;

	SObjectState(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}