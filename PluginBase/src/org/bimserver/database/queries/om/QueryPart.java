package org.bimserver.database.queries.om;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.queries.om.Include.TypeDef;
import org.bimserver.emf.PackageMetaData;
import org.eclipse.emf.ecore.EClass;

public class QueryPart extends PartOfQuery implements CanInclude {
	private Set<TypeDef> types;
	private Set<Long> oids;
	private Set<String> guids;
	private Set<String> names;
	private Map<String, Properties> properties;
	private Set<String> classifications;
	private PackageMetaData packageMetaData;
	private InBoundingBox inBoundingBox;
	private List<Include> includes;
	private boolean includeAllFields;
	private List<Reference> references;
	private Tiles tiles;
	private int minimumReuseThreshold = -1;
	private Set<String> includesToResolve;
	
	public QueryPart(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}

	public void addType(EClass type, boolean includeAllSubTypes) {
		if (types == null) {
			types = new LinkedHashSet<>();
		}
		types.add(new TypeDef(type, includeAllSubTypes));
	}
	
	@Override
	public void addOutputType(EClass eClass, boolean includeAllSubTypes) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void addOutputType(EClass eClass, boolean includeAllSubTypes, Set<EClass> excludedEClasses) {
		throw new UnsupportedOperationException();
	}
	
	public void addType(EClass type, boolean includeAllSubTypes, Set<EClass> excludedEClasses) {
		if (types == null) {
			types = new LinkedHashSet<>();
		}
		types.add(new TypeDef(type, includeAllSubTypes, excludedEClasses));
//		if (includeAllSubTypes) {
//			types.addAll(packageMetaData.getAllSubClasses(type));
//		}
	}
	
	public void addType(TypeDef typeDef) {
		if (types == null) {
			types = new LinkedHashSet<>();
		}
		types.add(typeDef);
	}

	public void addOid(long oid) {
		if (oids == null) {
			oids = new LinkedHashSet<>();
		}
		oids.add(oid);
	}
	
	public void addOids(Collection<Long> oids) {
		if (this.oids == null) {
			this.oids = new LinkedHashSet<>();
		}
		this.oids.addAll(oids);
	}

	public void addGuid(String guid) {
		if (guids == null) {
			guids = new LinkedHashSet<>();
		}
		guids.add(guid);
	}
	
	public Set<TypeDef> getTypes() {
		return types;
	}
	
	public Set<Long> getOids() {
		return oids;
	}
	
	public Set<String> getGuids() {
		return guids;
	}
	
	public Map<String, Properties> getProperties() {
		return properties;
	}

	public void addProperty(String propertySetName, String key, Object value) {
		if (this.properties == null) {
			this.properties = new HashMap<>();
		}
		Properties properties = this.properties.get(propertySetName);
		if (properties == null) {
			properties = new Properties(key, value);
			this.properties.put(propertySetName, properties);
		} else {
			properties.add(key, value);
		}
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
			for (TypeDef type : getTypes()) {
				sb.append(indent(indent + 1) + type.geteClass().getName() + ", " + type.isIncludeSubTypes() + "\n");
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
		if (hasIncludesToResolve()) {
			sb.append(indent(indent) + "includes (to resolve)\n");
			for (String include : getIncludesToResolve()) {
				sb.append(indent(indent + 1) + include + "\n");
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

	public void addClassification(String classification) {
		if (classifications == null) {
			classifications = new HashSet<>();
		}
		classifications.add(classification);
	}

	public Set<String> getClassifications() {
		return classifications;
	}

	@Override
	public void addIncludeReference(Include down, String name) {
		if (references == null) {
			references = new ArrayList<>();
		}
		references.add(new Reference(down, name));
	}

	public boolean hasReferences() {
		return references != null;
	}

	public List<Reference> getReferences() {
		return references;
	}

	public Tiles getTiles() {
		return tiles;
	}

	public void setTiles(Tiles tiles) {
		this.tiles = tiles;
	}
	
	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}

	public void setMinimumReuseThreshold(int minimumReuseThreshold) {
		this.minimumReuseThreshold = minimumReuseThreshold;
	}
	
	public int getMinimumReuseThreshold() {
		return minimumReuseThreshold;
	}


	@Override
	public void addInclude(String name) {
		if (includesToResolve == null) {
			includesToResolve = new HashSet<String>();
		}
		includesToResolve.add(name);
	}
	
	public Set<String> getIncludesToResolve() {
		return includesToResolve;
	}
	
	public boolean hasIncludesToResolve() {
		return includesToResolve != null;
	}

	public boolean hasTiles() {
		return tiles != null;
	}
}