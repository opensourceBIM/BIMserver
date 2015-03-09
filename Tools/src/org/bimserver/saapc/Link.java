package org.bimserver.saapc;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EReference;

public class Link {
	private EReference eReference;
	private int index;
	private IdEObject idEObject;

	public Link(EReference eReference, int index, IdEObject idEObject) {
		this.eReference = eReference;
		this.index = index;
		this.idEObject = idEObject;
	}
	
	@Override
	public String toString() {
		return eReference.getName() + " -> " + idEObject.eClass().getName();
	}
}
