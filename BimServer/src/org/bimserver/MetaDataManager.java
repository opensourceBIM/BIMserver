package org.bimserver;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class MetaDataManager {
	private final Map<String, EPackage> ePackages = new HashMap<String, EPackage>();
	
	public MetaDataManager() {
		addEPackage(Ifc2x3Package.eINSTANCE);
		addEPackage(StorePackage.eINSTANCE);
		addEPackage(LogPackage.eINSTANCE);
	}

	private void addEPackage(EPackage ePackage) {
		ePackages.put(ePackage.getName(), ePackage);
	}

	public EClass getEClass(String type) {
		for (EPackage ePackage : ePackages.values()) {
			EClassifier eClassifier = ePackage.getEClassifier(type);
			if (eClassifier instanceof EClass) {
				return (EClass) eClassifier;
			}
		}
		return null;
	}

	public EAttribute getEAttribute(String className, String attributeName) {
		for (EPackage ePackage : ePackages.values()) {
			EClassifier eClassifier = ePackage.getEClassifier(className);
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(attributeName);
				if (eStructuralFeature instanceof EAttribute) {
					return (EAttribute) eStructuralFeature;
				}
			}
		}
		return null;
	}

	public EReference getEReference(String className, String referenceName) {
		for (EPackage ePackage : ePackages.values()) {
			EClassifier eClassifier = ePackage.getEClassifier(className);
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(referenceName);
				if (eStructuralFeature instanceof EReference) {
					return (EReference) eStructuralFeature;
				}
			}
		}
		return null;
	}
}