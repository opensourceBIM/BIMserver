package org.bimserver.bimbots;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.SchemaName;

public class BimBotsInput {
	private String schemaName;
	private byte[] data;
	private IfcModelInterface model;

	public BimBotsInput(SchemaName schemaName, byte[] data) {
		this.schemaName = schemaName.name();
		this.data = data;
	}
	
	public BimBotsInput(String schemaName, byte[] data) {
		this.schemaName = schemaName;
		this.data = data;
	}
	
	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public byte[] getData() {
		return data;
	}

	public IfcModelInterface getIfcModel() {
		return model;
	}

	public void setIfcModel(IfcModelInterface model) {
		this.model = model;
	}
}
