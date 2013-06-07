package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
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
	private final Map<EClass, Set<EClass>> directSubClasses = new HashMap<EClass, Set<EClass>>();
	private final Map<EClass, Set<EClass>> allSubClasses = new HashMap<EClass, Set<EClass>>();
	private final Map<String, EClassifier> caseInsensitive = new HashMap<String, EClassifier>();
	private final Map<String, EClassifier> caseSensitive = new HashMap<String, EClassifier>();
	
	public MetaDataManager(Set<EPackage> ePackages) {
		for (EPackage ePackage : ePackages) {
			addEPackage(ePackage);
		}
	}
	
	public MetaDataManager() {
		addEPackage(Ifc2x3tc1Package.eINSTANCE);
		addEPackage(StorePackage.eINSTANCE);
		addEPackage(LogPackage.eINSTANCE);
	}

	public void addEPackage(EPackage ePackage) {
		ePackages.put(ePackage.getName(), ePackage);
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			caseInsensitive.put(eClassifier.getName().toLowerCase(), eClassifier);
			caseSensitive.put(eClassifier.getName(), eClassifier);
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				if (!allSubClasses.containsKey(eClass)) {
					allSubClasses.put(eClass, new HashSet<EClass>());
				}
				if (!directSubClasses.containsKey(eClass)) {
					directSubClasses.put(eClass, new HashSet<EClass>());
				}
				for (EClass superClass : eClass.getEAllSuperTypes()) {
					if (!allSubClasses.containsKey(superClass)) {
						allSubClasses.put(superClass, new HashSet<EClass>());
					}
					allSubClasses.get(superClass).add(eClass);
				}
				for (EClass superClass : eClass.getESuperTypes()) {
					if (!directSubClasses.containsKey(superClass)) {
						directSubClasses.put(superClass, new HashSet<EClass>());
					}
					directSubClasses.get(superClass).add(eClass);
				}
			}
		}
	}

	public Set<EClass> getDirectSubClasses(EClass superClass) {
		return directSubClasses.get(superClass);
	}
	
	public Set<EClass> getAllSubClasses(EClass superClass) {
		return allSubClasses.get(superClass);
	}

	public EClassifier getEClassifier(String type) {
		return caseSensitive.get(type);
	}

	public EClassifier getEClassifierCaseInsensitive(String type) {
		return caseInsensitive.get(type.toLowerCase());
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