package org.bimserver;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

public class Entry {
	protected EObject eObject;
	protected EStructuralFeature eStructuralFeature;

	public Entry(InternalEObject eObject, EStructuralFeature eStructuralFeature) {
		this.eObject = eObject;
		this.eStructuralFeature = eStructuralFeature;
	}

	@Override
	public boolean equals(Object that) {
		if (that instanceof Entry) {
			Entry entry = (Entry) that;
			return eObject == entry.eObject && eStructuralFeature == entry.eStructuralFeature;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return eObject.hashCode() ^ eStructuralFeature.hashCode();
	}
}