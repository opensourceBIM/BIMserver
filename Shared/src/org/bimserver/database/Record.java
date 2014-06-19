package org.bimserver.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Record {

	private EClass eClass;
	private final Map<EStructuralFeature, Object> values = new HashMap<EStructuralFeature, Object>();
	private long oid;

	public Record(EClass eClass) {
		this.eClass = eClass;
	}

	public void eUnset(EStructuralFeature structuralFeature) {
	}

	public void eSet(EStructuralFeature doubleStringFeature, String val) {
	}

	public void eSet(EStructuralFeature doubleStringFeature, boolean val) {
	}

	public void eSet(EStructuralFeature doubleStringFeature, Enumerator enumerator) {
	}
	
	public void setReference(EStructuralFeature eStructuralFeature, long referredOid) {
	}

	public void setWrapped(EStructuralFeature structuralFeature, EClass eClass, Enumerator enumerator) {
	}

	@SuppressWarnings("unchecked")
	public List<Record> getList(EStructuralFeature structuralFeature) {
		return (List<Record>) values.get(structuralFeature);
	}

	public EClass eClass() {
		return eClass;
	}

	public long getOid() {
		return oid;
	}
}
