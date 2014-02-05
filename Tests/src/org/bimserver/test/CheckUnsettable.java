package org.bimserver.test;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

public class CheckUnsettable {
	public static void main(String[] args) {
		int nrFeatures = 0;
		int nrUnsettableFeatures = 0;
		for (EClassifier eClassifier : Ifc2x3tc1Package.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
					nrFeatures++;
					if (eStructuralFeature.isUnsettable()) {
						nrUnsettableFeatures++;
					} else {
						System.out.println(eClass.getName() + "." + eStructuralFeature.getName());
					}
				}
			}
		}
		System.out.println(nrUnsettableFeatures + " / " + nrFeatures);
	}
}
