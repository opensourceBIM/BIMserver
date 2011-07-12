package org.bimserver.shared;

import java.util.ArrayList;
import java.util.List;

public class SRevisionSummaryContainer {

	private String name;
	private List<SRevisionSummaryType> types = new ArrayList<SRevisionSummaryType>();

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public List<SRevisionSummaryType> getTypes() {
		return types;
	}

	public void setTypes(List<SRevisionSummaryType> types) {
		this.types = types;
	}

	public SRevisionSummaryType getType(String name) {
		for (SRevisionSummaryType type : types) {
			if (type.getName().equals(name)) {
				return type;
			}
		}
		SRevisionSummaryType newType = new SRevisionSummaryType();
		newType.setName(name);
		types.add(newType);
		return newType;
	}
	
	public boolean containsType(String name) {
		return getType(name) != null;
	}

	public void increment(String name, int count) {
		getType(name).increment(count);
	}
}