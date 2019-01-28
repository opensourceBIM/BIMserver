package org.bimserver.ifc.generator;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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