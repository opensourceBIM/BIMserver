package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;
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