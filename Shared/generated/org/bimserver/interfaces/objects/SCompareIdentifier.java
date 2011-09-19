package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;
public enum SCompareIdentifier {
	NAME(0),
	GUID(1);
	int ordinal;

	SCompareIdentifier(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}