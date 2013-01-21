package org.bimserver.shared;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class SingleWaitingObject extends WaitingObject {

	public SingleWaitingObject(EObject object, EStructuralFeature structuralFeature) {
		super(object, structuralFeature);
	}
}