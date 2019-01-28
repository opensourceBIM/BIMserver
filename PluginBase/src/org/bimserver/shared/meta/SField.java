package org.bimserver.shared.meta;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

public class SField implements Comparable<SField> {
	private String name;
	private final SClass type;
	private final boolean aggregate;
	private final SClass genericType;
	private String doc = "";
	
	public SField(String name, SClass type, SClass generticType) {
		this(name, type, generticType, false);
	}

	public SField(String name, SClass type, SClass genericType, boolean aggregate) {
		this.name = name;
		if (type == null) {
			throw new RuntimeException("Type cannot be null " + name);
		}
		this.type = type;
		this.genericType = genericType;
		this.aggregate = aggregate;
	}

	public boolean isAggregate() {
		return aggregate;
	}
	
	public SClass getGenericType() {
		return genericType;
	}
	
	public SClass getBestType() {
		return genericType != null ? genericType : type;
	}
	
	public SClass getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}

	public String getDoc() {
		return doc;
	}

	public ObjectNode toJson(ObjectMapper OBJECT_MAPPER) {
		ObjectNode json = OBJECT_MAPPER.createObjectNode();
		json.put("name", name);
		json.set("type", getType().toJson(OBJECT_MAPPER));
		json.set("genericType", getGenericType().toJson(OBJECT_MAPPER));
		json.put("doc", getDoc());
		return json;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SField other = (SField) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int compareTo(SField o) {
		return name.compareTo(o.getName());
	}
}