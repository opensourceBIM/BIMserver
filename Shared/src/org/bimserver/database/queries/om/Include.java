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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.QueryException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class Include extends PartOfQuery implements CanInclude {
	private Set<EClass> types;
	private List<EClass> outputTypes;
	private List<EReference> fields;
	private List<Include> includes;
	private PackageMetaData packageMetaData;
	
	public Include(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}
	
	/**
	 * Add the fields _after_ adding the types, because the fields will be checked against the types, all types should have the given field.
	 * 
	 * @param fieldName
	 * @throws QueryException 
	 */
	public void addField(String fieldName) throws QueryException {
		EReference feature = null;
		for (EClass eClass : types) {
			if (eClass.getEStructuralFeature(fieldName) == null) {
				throw new QueryException("Class \"" + eClass.getName() + "\" does not have the field \"" + fieldName + "\"");
			}
			if (feature == null) {
				if (!(eClass.getEStructuralFeature(fieldName) instanceof EReference)) {
					throw new QueryException(fieldName + " is not a reference");
				}
				feature = (EReference) eClass.getEStructuralFeature(fieldName);
			} else {
				if (feature != eClass.getEStructuralFeature(fieldName)) {
					throw new QueryException("Classes \"" + eClass.getName() + "\" and \"" + feature.getEContainingClass().getName() + "\" have fields with the same name, but they are not logically the same");
				}
			}
		}
		if (fields == null) {
			fields = new ArrayList<EReference>();
		}
		fields.add(feature);
	}

	public void addInclude(Include newInclude) {
		if (includes == null) {
			includes = new ArrayList<Include>();
		}
		includes.add(newInclude);
	}

	public List<EReference> getFields() {
		return fields;
	}
	
	public void addType(EClass eClass, boolean includeAllSubTypes) {
		if (eClass == null) {
			throw new IllegalArgumentException("eClass cannot be null");
		}
		if (types == null) {
			types = new HashSet<>();
		}
		types.add(eClass);
		if (includeAllSubTypes) {
			types.addAll(packageMetaData.getAllSubClasses(eClass));
		}
	}

	public void addOutputType(EClass eClass) {
		if (outputTypes == null) {
			outputTypes = new ArrayList<>();
		}
		outputTypes.add(eClass);
	}
	
	public List<EClass> getOutputTypes() {
		return outputTypes;
	}
	
	public boolean hasOutputTypes() {
		return outputTypes != null;
	}
	
	public Set<EClass> getTypes() {
		return types;
	}

	public boolean hasFields() {
		return fields != null;
	}

	public boolean hasTypes() {
		return types != null;
	}
	
	public List<Include> getIncludes() {
		return includes;
	}

	public boolean hasIncludes() {
		return includes != null;
	}

	@Override
	public boolean isIncludeAllFields() {
		return false;
	}

	public void dump(int indent, StringBuilder sb) {
		if (indent > 10) {
			sb.append("..trimmed\n");
			return;
		}
		if (hasTypes()) {
			sb.append(indent(indent) + "types\n");
			for (EClass eClass : getTypes()) {
				sb.append(indent(indent + 1) + eClass.getName() + "\n");
			}
		}
		if (hasFields()) {
			sb.append(indent(indent) + "fields\n");
			for (EReference field : getFields()) {
				sb.append(indent(indent + 1) + field.getName() + "\n");
			}
		}
		if (hasIncludes()) {
			sb.append(indent(indent) + "includes\n");
			for (Include include : getIncludes()) {
				include.dump(indent + 1, sb);
			}
		}
		if (hasOutputTypes()) {
			sb.append(indent(indent) + "outputTypes\n");
			for (EClass outputType : getOutputTypes()) {
				sb.append(indent(indent + 1) + outputType.getName() + "\n");
			}
		}
	}

	public Include createInclude() {
		Include include = new Include(packageMetaData);
		addInclude(include);
		return include;
	}
}