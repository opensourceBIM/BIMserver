package org.bimserver.database.queries.om;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.PackageMetaData;
import org.eclipse.emf.ecore.EClass;

public class QueryPart extends PartOfQuery implements CanInclude {
	private List<EClass> types;
	private List<Long> oids;
	private Set<String> guids;
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
			oids = new ArrayList<>();
		}
		oids.add(oid);
	}

	public void addGuid(String guid) {
		if (guids == null) {
			guids = new HashSet<>();
		}
		guids.add(guid);
	}
	
	public List<EClass> getTypes() {
		return types;
	}
	
	public List<Long> getOids() {
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

	public boolean hasTypes() {
		return types != null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public void dump(int indent, StringBuilder sb) {
		if (indent > 10) {
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
		if (hasIncludes()) {
			sb.append(indent(indent) + "includes\n");
			for (Include include : getIncludes()) {
				include.dump(indent + 1, sb);
			}
		}
	}

	public Include createInclude() {
		Include include = new Include(packageMetaData);
		addInclude(include);
		return include;
	}
}