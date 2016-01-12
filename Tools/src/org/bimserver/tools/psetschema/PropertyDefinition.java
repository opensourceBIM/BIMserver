package org.bimserver.tools.psetschema;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

public class PropertyDefinition {

	private String name;
	private String definition;
	private PropertyTypeDefinition type;

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public String getDefinition() {
		return definition;
	}

	public PropertyTypeDefinition getType() {
		return type;
	}

	public void setType(PropertyTypeDefinition type) {
		this.type = type;
	}
}