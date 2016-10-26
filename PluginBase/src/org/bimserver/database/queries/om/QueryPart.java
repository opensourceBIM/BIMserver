package org.bimserver.database.queries.om;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.PackageMetaData;
import org.eclipse.emf.ecore.EClass;

public class QueryPart extends PartOfQuery implements CanInclude {
	private List<EClass> types;
	private Set<Long> oids;
	private Set<String> guids;
	private Set<String> names;
	private Map<String, Object> properties;
	private PackageMetaData packageMetaData;
	private InBoundingBox inBoundingBox;
	private List<Include> includes;
	private boolean includeAllFields;
	
	public QueryPart(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}

	public void addType(EClass type, boolean includeAllSubTypes) {
		if (types == null) {
			types = new ArrayList<>();
		}
		types.add(type);
		if (includeAllSubTypes) {
			types.addAll(packageMetaData.getAllSubClasses(type));
		}
	}

	public void addOid(long oid) {
		if (oids == null) {
			oids = new LinkedHashSet<>();
		}
		oids.add(oid);
	}

	public void addGuid(String guid) {
		if (guids == null) {
			guids = new LinkedHashSet<>();
		}
		guids.add(guid);
	}
	
	public List<EClass> getTypes() {
		return types;
	}
	
	public Set<Long> getOids() {
		return oids;
	}
	
	public Set<String> getGuids() {
		return guids;
	}
	
	public Map<String, Object> getProperties() {
		return properties;
	}

	public void addProperty(String key, boolean value) {
		if (this.properties == null) {
			this.properties = new HashMap<String, Object>();
		}
		this.properties.put(key, value);
	}

	public void setInBoundingBox(InBoundingBox inBoundingBox) {
		this.inBoundingBox = inBoundingBox;
	}
	
	public InBoundingBox getInBoundingBox() {
		return inBoundingBox;
	}
	
	public boolean isIncludeAllFields() {
		return includeAllFields;
	}

	public void setIncludeAllFields(boolean includeAllFields) {
		this.includeAllFields = includeAllFields;
	}
	
	@Override
	public void addInclude(Include include) {
		if (includes == null) {
			includes = new ArrayList<Include>();
		}
		includes.add(include);
	}
	
	public List<Include> getIncludes() {
		return includes;
	}

	public boolean hasIncludes() {
		return includes != null;
	}

	public boolean hasOids() {
		return oids != null;
	}

	public boolean hasGuids() {
		return guids != null;
	}

	public boolean hasTypes() {
		return types != null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}
	
	public boolean hasProperties() {
		return properties != null;
	}

	public void dump(int indent, StringBuilder sb) {
		if (indent > 10) {
			// TODO this is also used for caching...
			sb.append("..trimmed\n");
			return;
		}
		if (hasTypes()) {
			sb.append(indent(indent) + "types\n");
			for (EClass type : getTypes()) {
				sb.append(indent(indent + 1) + type.getName() + "\n");
			}
		}
		if (hasOids()) {
			sb.append(indent(indent) + "oids\n");
			for (long oid : getOids()) {
				sb.append(indent(indent + 1) + oid + "\n");
			}
		}
		if (hasGuids()) {
			sb.append(indent(indent) + "guids\n");
			for (String guid : getGuids()) {
				sb.append(indent(indent + 1) + guid + "\n");
			}
		}
		if (hasIncludes()) {
			sb.append(indent(indent) + "includes\n");
			for (Include include : getIncludes()) {
				include.dump(indent + 1, sb);
			}
		}
		if (hasInBoundingBox()) {
			sb.append(indent(indent) + "inBoundingBox\n");
			inBoundingBox.dump(indent + 1, sb);
		}
		if (hasProperties()) {
			sb.append(indent(indent) + "properties\n");
			for (String key : properties.keySet()) {
				sb.append(indent(indent + 1) + key + ": " + properties.get(key));
			}
		}
	}
	
	public boolean hasInBoundingBox() {
		return inBoundingBox != null;
	}

	public Include createInclude() {
		Include include = new Include(packageMetaData);
		addInclude(include);
		return include;
	}

	public void addName(String name) {
		if (names == null) {
			names = new LinkedHashSet<>();
		}
		names.add(name);
	}

	public Set<String> getNames() {
		return names;
	}
}