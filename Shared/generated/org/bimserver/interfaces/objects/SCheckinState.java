package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;
public enum SCheckinState {
	UPLOADING(0),
	PARSING(1),
	STORING(2),
	SEARCHING_CLASHES(3),
	DONE(4),
	ERROR(5),
	CLASHES_ERROR(6);
	int ordinal;

	SCheckinState(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}