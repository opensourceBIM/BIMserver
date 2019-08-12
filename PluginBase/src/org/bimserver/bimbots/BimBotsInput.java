package org.bimserver.bimbots;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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
