package org.bimserver.database.queries.om;

import com.fasterxml.jackson.databind.JsonNode;

public class Reference {

	private String name;
	private Include include;

	public Reference(Include include, String name) {
		this.include = include;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Include getInclude() {
		return include;
	}
}