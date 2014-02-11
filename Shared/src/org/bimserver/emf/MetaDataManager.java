package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
	private final Map<String, EPackage> ePackages = new TreeMap<String, EPackage>();
	private final Map<String, Set<EClass>> directSubClasses = new TreeMap<String, Set<EClass>>();
	private final Map<String, Set<EClass>> allSubClasses = new TreeMap<String, Set<EClass>>();
	private final Map<String, EClassifier> caseInsensitive = new TreeMap<String, EClassifier>();
	private final Map<String, EClassifier> caseSensitive = new TreeMap<String, EClassifier>();
	
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
				if (!allSubClasses.containsKey(eClass.getName())) {
					allSubClasses.put(eClass.getName(), new HashSet<EClass>());
				}
				if (!directSubClasses.containsKey(eClass.getName())) {
					directSubClasses.put(eClass.getName(), new HashSet<EClass>());
				}
				for (EClass superClass : eClass.getEAllSuperTypes()) {
					if (!allSubClasses.containsKey(superClass.getName())) {
						allSubClasses.put(superClass.getName(), new HashSet<EClass>());
					}
					allSubClasses.get(superClass.getName()).add(eClass);
				}
				for (EClass superClass : eClass.getESuperTypes()) {
					if (!directSubClasses.containsKey(superClass.getName())) {
						directSubClasses.put(superClass.getName(), new HashSet<EClass>());
					}
					directSubClasses.get(superClass.getName()).add(eClass);
				}
			}
		}
	}

	public Set<EClass> getDirectSubClasses(EClass superClass) {
		return directSubClasses.get(superClass.getName());
	}
	
	public Set<EClass> getAllSubClasses(EClass superClass) {
		return allSubClasses.get(superClass.getName());
	}

	public EClassifier getEClassifier(String type) {
		return caseSensitive.get(type);
	}

	public EClassifier getEClassifierCaseInsensitive(String type) {
		return caseInsensitive.get(type.toLowerCase());
	}
	
	public EAttribute getEAttribute(String className, String attributeName) {
		// TODO add packageName argument and use hashmap for lookup
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
		// TODO add packageName argument and use hashmap for lookup
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