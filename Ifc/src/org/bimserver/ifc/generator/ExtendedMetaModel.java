package org.bimserver.ifc.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public class ExtendedMetaModel {
	private final Random random = new Random();
	private final EPackage ePackage;
	private final Map<EClass, List<EClass>> directSubClasses = new HashMap<EClass, List<EClass>>();
	private final Map<EClass, List<EClass>> inheritedSubClasses = new HashMap<EClass, List<EClass>>();

	public ExtendedMetaModel(EPackage ePackage) {
		this.ePackage = ePackage;
		init();
	}

	private void init() {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				directSubClasses.put((EClass) eClassifier, new ArrayList<EClass>());
				inheritedSubClasses.put((EClass) eClassifier, new ArrayList<EClass>());
			}
		}
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				for (EClass superClass : eClass.getESuperTypes()) {
					directSubClasses.get(superClass).add(eClass);
				}
			}
		}
		for (EClass eClass : directSubClasses.keySet()) {
			addInheritedSubClasses(eClass, eClass);
		}
	}

	private void addInheritedSubClasses(EClass eClass, EClass currentEClass) {
		for (EClass e : directSubClasses.get(currentEClass)) {
			inheritedSubClasses.get(eClass).add(e);
			addInheritedSubClasses(eClass, e);
		}
	}

	public EClass getRandomInstantiableSubClassOrSelf(EClass eType) {
		List<EClass> list = inheritedSubClasses.get(eType);
		EClass result = null;
		if (random.nextInt(list.size() + 1) == 0) {
			result = eType;
		} else {
			result = list.get(random.nextInt(list.size()));
		}
		if (result.isAbstract() || result.isInterface()) {
			return getRandomInstantiableSubClassOrSelf(eType);
		} else {
			return result;
		}
	}
}