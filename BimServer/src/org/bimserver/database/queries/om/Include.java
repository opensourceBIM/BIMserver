package org.bimserver.database.queries.om;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.database.queries.QueryException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Include implements CanInclude {
	private List<EClass> types;
	private List<EClass> outputTypes;
	private List<EStructuralFeature> fields;
	private List<Include> includes;
	
	/**
	 * Add the fields _after_ adding the types, because the fields will be checked against the types, all types should have the given field.
	 * 
	 * @param fieldName
	 * @throws QueryException 
	 */
	public void addField(String fieldName) throws QueryException {
		EStructuralFeature feature = null;
		for (EClass eClass : types) {
			if (eClass.getEStructuralFeature(fieldName) == null) {
				throw new QueryException("Class \"" + eClass.getName() + "\" does not have the field \"" + fieldName + "\"");
			}
			if (feature == null) {
				feature = eClass.getEStructuralFeature(fieldName);
			} else {
				if (feature != eClass.getEStructuralFeature(fieldName)) {
					throw new QueryException("Classes \"" + eClass.getName() + "\" and \"" + feature.getEContainingClass().getName() + "\" have fields with the same name, but they are not logically the same");
				}
			}
		}
		if (fields == null) {
			fields = new ArrayList<EStructuralFeature>();
		}
		fields.add(feature);
	}

	public void addInclude(Include newInclude) {
		if (includes == null) {
			includes = new ArrayList<Include>();
		}
		includes.add(newInclude);
	}

	public List<EStructuralFeature> getFields() {
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
}