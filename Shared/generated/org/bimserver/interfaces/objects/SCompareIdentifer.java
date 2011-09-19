package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
public enum SCompareIdentifer {
	NAME(0),
	GUID(1);
	int ordinal;

	SCompareIdentifer(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}