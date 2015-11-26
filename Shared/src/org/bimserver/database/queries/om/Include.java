package org.bimserver.database.queries.om;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.shared.QueryException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class Include extends PartOfQuery implements CanInclude {
	private List<EClass> types;
	private List<EClass> outputTypes;
	private List<EReference> fields;
	private List<Include> includes;
	
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
	
	public void addType(EClass eClass) {
		if (eClass == null) {
			throw new IllegalArgumentException("eClass cannot be null");
		}
		if (types == null) {
			types = new ArrayList<>();
		}
		types.add(eClass);
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
	
	public List<EClass> getTypes() {
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
	}
}