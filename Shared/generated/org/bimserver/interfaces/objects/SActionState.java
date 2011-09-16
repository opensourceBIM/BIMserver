package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.bimserver.shared.meta.*;
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