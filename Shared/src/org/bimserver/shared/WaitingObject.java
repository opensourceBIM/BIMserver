package org.bimserver.shared;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class WaitingObject {
	// The object that has a missing reference
	private final EObject object;

	// The structural feature (usually a reference) on which to 'connect' the object on
	private final EStructuralFeature structuralFeature;
	
	public WaitingObject(EObject object, EStructuralFeature structuralFeature) {
		this.object = object;
		this.structuralFeature = structuralFeature;
	}

	public EObject getObject() {
		return object;
	}

	public EStructuralFeature getStructuralFeature() {
		return structuralFeature;
	}
}