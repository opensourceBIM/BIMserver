package org.bimserver;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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