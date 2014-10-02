package org.bimserver.plugins;

import java.util.List;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class InverseFix {

	private EStructuralFeature eStructuralFeature;
	private IdEObject newObject;

	public InverseFix(EStructuralFeature eStructuralFeature, IdEObject newObject) {
		this.eStructuralFeature = eStructuralFeature;
		this.newObject = newObject;
	}

	public void apply(IdEObject value) {
		System.out.println("Apply");
		if (eStructuralFeature.isMany()) {
			List list = (List)newObject.eGet(eStructuralFeature);
			list.add(value);
		} else {
			newObject.eSet(eStructuralFeature, value);
		}
	}
}
