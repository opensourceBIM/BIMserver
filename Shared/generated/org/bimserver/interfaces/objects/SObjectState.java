package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;
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