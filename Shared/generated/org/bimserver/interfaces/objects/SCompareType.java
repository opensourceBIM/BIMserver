package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;
public enum SCompareType {
	ALL(0),
	ADD(1),
	MODIFY(2),
	DELETE(3);
	int ordinal;

	SCompareType(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}