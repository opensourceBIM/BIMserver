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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.PackageMetaData;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class Include extends PartOfQuery implements CanInclude {
	
	public static class TypeDef {
		private EClass eClass;
		private boolean includeSubTypes;
		private Set<EClass> excluded;
		
		public TypeDef(EClass eClass, boolean includeSubTypes) {
			this.eClass = eClass;
			this.includeSubTypes = includeSubTypes;
		}

		public TypeDef(EClass eClass, boolean includeSubTypes, Set<EClass> excluded) {
			this.eClass = eClass;
			this.includeSubTypes = includeSubTypes;
			this.excluded = excluded;
		}
		
		public EClass geteClass() {
			return eClass;
		}
		
		public boolean isIncludeSubTypes() {
			return includeSubTypes;
		}
		
		public Set<EClass> getExcluded() {
			return excluded;
		}

		public boolean excludes(EClass subType) {
			return excluded != null && excluded.contains(subType);
		}

		public boolean hasExcludes() {
			return excluded != null;
		}
	}
	
	private Set<TypeDef> types;
	private List<TypeDef> outputTypes;
	private List<EReference> fields;
	private List<EReference> fieldsDirect;
	private List<Include> includes;
	private List<Reference> references;
	private PackageMetaData packageMetaData;
	private boolean includeAllFields;
	private Set<String> includesToResolve;
	private boolean exclude;
	
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
		for (TypeDef typeDef : types) {
			if (typeDef.geteClass().getEStructuralFeature(fieldName) == null) {
				throw new QueryException("Class \"" + typeDef.geteClass().getName() + "\" does not have the field \"" + fieldName + "\"");
			}
			if (feature == null) {
				if (!(typeDef.geteClass().getEStructuralFeature(fieldName) instanceof EReference)) {
					throw new QueryException(fieldName + " is not a reference");
				}
				feature = (EReference) typeDef.geteClass().getEStructuralFeature(fieldName);
			} else {
				if (feature != typeDef.geteClass().getEStructuralFeature(fieldName)) {
					throw new QueryException("Classes \"" + typeDef.geteClass().getName() + "\" and \"" + feature.getEContainingClass().getName() + "\" have fields with the same name, but they are not logically the same");
				}
			}
		}
		if (fields == null) {
			fields = new ArrayList<>();
		}
		fields.add(feature);
	}
	
	public void addFieldDirect(String fieldName) throws QueryException {
		EReference feature = null;
		for (TypeDef typeDef : types) {
			if (typeDef.geteClass().getEStructuralFeature(fieldName) == null) {
				throw new QueryException("Class \"" + typeDef.geteClass().getName() + "\" does not have the field \"" + fieldName + "\"");
			}
			if (feature == null) {
				if (!(typeDef.geteClass().getEStructuralFeature(fieldName) instanceof EReference)) {
					throw new QueryException(fieldName + " is not a reference");
				}
				feature = (EReference) typeDef.geteClass().getEStructuralFeature(fieldName);
			} else {
				if (feature != typeDef.geteClass().getEStructuralFeature(fieldName)) {
					throw new QueryException("Classes \"" + typeDef.geteClass().getName() + "\" and \"" + feature.getEContainingClass().getName() + "\" have fields with the same name, but they are not logically the same");
				}
			}
		}
		if (fieldsDirect == null) {
			fieldsDirect = new ArrayList<>();
		}
		fieldsDirect.add(feature);
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
	
	public List<EReference> getFieldsDirect() {
		return fieldsDirect;
	}
	
	@Override
	public void addType(EClass eClass, boolean includeAllSubTypes, Set<EClass> excludedEClasses) {
		if (eClass == null) {
			throw new IllegalArgumentException("eClass cannot be null");
		}
		if (types == null) {
			types = new HashSet<>();
		}
		types.add(new TypeDef(eClass, includeAllSubTypes, excludedEClasses));
	}
	
	public void addType(EClass eClass, boolean includeAllSubTypes) {
		if (eClass == null) {
			throw new IllegalArgumentException("eClass cannot be null");
		}
		if (types == null) {
			types = new HashSet<>();
		}
		types.add(new TypeDef(eClass, includeAllSubTypes));
//		if (includeAllSubTypes) {
//			types.addAll(packageMetaData.getAllSubClasses(eClass));
//		}
	}

	public void addOutputType(EClass eClass, boolean includeAllSubTypes) {
		if (eClass == null) {
			throw new IllegalArgumentException("eClass cannot be null");
		}
		if (outputTypes == null) {
			outputTypes = new ArrayList<>();
		}
		outputTypes.add(new TypeDef(eClass, includeAllSubTypes));
	}
	
	@Override
	public void addOutputType(EClass eClass, boolean includeAllSubTypes, Set<EClass> excludedEClasses) {
		if (eClass == null) {
			throw new IllegalArgumentException("eClass cannot be null");
		}
		if (outputTypes == null) {
			outputTypes = new ArrayList<>();
		}
		outputTypes.add(new TypeDef(eClass, includeAllSubTypes, excludedEClasses));
	}
	
	public List<TypeDef> getOutputTypes() {
		return outputTypes;
	}
	
	public boolean hasOutputTypes() {
		return outputTypes != null;
	}
	
	public Set<TypeDef> getTypes() {
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
		return includeAllFields;
	}

	public void dump(int indent, StringBuilder sb) {
		if (indent > 10) {
			sb.append("..trimmed\n");
			return;
		}
		if (hasTypes()) {
			sb.append(indent(indent) + "types\n");
			for (TypeDef typeDef : getTypes()) {
				sb.append(indent(indent + 1) + typeDef.geteClass().getName() + "\n");
			}
		}
		if (hasFields()) {
			sb.append(indent(indent) + "fields\n");
			for (EReference field : getFields()) {
				sb.append(indent(indent + 1) + field.getName() + "\n");
			}
		}
		if (hasDirectFields()) {
			sb.append(indent(indent) + "directfields\n");
			for (EReference field : getFieldsDirect()) {
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
			for (TypeDef outputType : getOutputTypes()) {
				sb.append(indent(indent + 1) + outputType.geteClass().getName() + "\n");
			}
		}
	}

	public Include createInclude() {
		Include include = new Include(packageMetaData);
		addInclude(include);
		return include;
	}

	public boolean hasDirectFields() {
		return fieldsDirect != null && !fieldsDirect.isEmpty();
	}

	public void addIncludeReference(Include down, String name) {
		if (references == null) {
			references = new ArrayList<>();
		}
		references.add(new Reference(down, name));
	}

	public List<Reference> getReferences() {
		return references;
	}

	public boolean hasReferences() {
		return references != null;
	}

	public void makeDirectRecursive(Set<Include> done) {
		if (done.contains(this)) {
			return;
		}
		done.add(this);
		if (this.fieldsDirect == null) {
			this.fieldsDirect = new ArrayList<>();
		}
		if (this.fields != null) {
			this.fieldsDirect.addAll(this.fields);
			this.fields.clear();
		}
		if (hasIncludes()) {
			for (Include inc : this.includes) {
				inc.makeDirectRecursive(done);
			}
		}
		if (hasReferences()) {
			for (Reference reference : references) {
				reference.getInclude().makeDirectRecursive(done);
			}
		}
	}

	public void addType(TypeDef typeDef) {
		if (types == null) {
			types = new HashSet<>();
		}
		types.add(typeDef);
	}

	public void addField(EReference field) throws QueryException {
		this.addField(field.getName());
	}
	
	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}

	public boolean hasField(EReference fieldName) {
		return fields.contains(fieldName);
	}

	public Include copy() throws QueryException {
		Include newInclude = new Include(getPackageMetaData());
		if (hasDirectFields()) {
			for (EReference eReference : getFieldsDirect()) {
				newInclude.addFieldDirect(eReference.getName());
			}
		}
		if (hasTypes()) {
			for (TypeDef typeDef : getTypes()) {
				newInclude.addType(typeDef);
			}
		}
		if (hasFields()) {
			for (EReference eReference : getFields()) {
				newInclude.addField(eReference);
			}
		}
		if (hasReferences()) {
			for (Reference reference : getReferences()) {
				newInclude.addIncludeReference(reference.getInclude(), reference.getName());
			}
		}
		return newInclude;
	}

	@Override
	public boolean hasOids() {
		return false;
	}

	public void setIncludeAllFields(boolean includeAllFields) {
		this.includeAllFields = includeAllFields;
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

	public void setExclude(boolean exclude) {
		this.exclude = exclude;
	}
	
	public boolean isExclude() {
		return exclude;
	}
}