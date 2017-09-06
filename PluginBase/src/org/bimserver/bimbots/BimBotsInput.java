package org.bimserver.bimbots;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.SchemaName;

public class BimBotsInput {
	private SchemaName schemaName;
	private byte[] data;

	public BimBotsInput(SchemaName schemaName, byte[] data) {
		this.schemaName = schemaName;
		this.data = data;
	}
	
	public SchemaName getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(SchemaName schemaName) {
		this.schemaName = schemaName;
	}

	public byte[] getData() {
		return data;
	}

	public IfcModelInterface getIfcModel() {
		return null;
	}
}
