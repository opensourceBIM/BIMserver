package org.bimserver.plugins.objectidms;

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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FieldIgnoreMap implements ObjectIDM {
	private final Set<StructuralFeatureIdentifier> generalIgnoreSet = new HashSet<StructuralFeatureIdentifier>();
	private final Map<EClass, Set<StructuralFeatureIdentifier>> specificIncludeMap = new HashMap<EClass, Set<StructuralFeatureIdentifier>>();
	private final Set<? extends EPackage> packages;

	public FieldIgnoreMap(Set<? extends EPackage> ePackages) {
		packages = ePackages;
	}
	
	public void addToGeneralIgnoreSet(StructuralFeatureIdentifier structuralFeatureIdentifier) {
		generalIgnoreSet.add(structuralFeatureIdentifier);
	}

	public void addToSpecificIncludeMap(EClass eClass, StructuralFeatureIdentifier structuralFeatureIdentifier) {
		if (specificIncludeMap.containsKey(eClass)) {
			specificIncludeMap.get(eClass).add(structuralFeatureIdentifier);
		} else {
			HashSet<StructuralFeatureIdentifier> hashSet = new HashSet<StructuralFeatureIdentifier>();
			specificIncludeMap.put(eClass, hashSet);
			specificIncludeMap.put(eClass, hashSet);
		}
	}
	
	protected EClass getEClass(String className) {
		for (EPackage ePackage : packages) {
			if (ePackage.getEClassifier(className) != null) {
				return (EClass)ePackage.getEClassifier(className);
			}
		}
		return null;
	}
	
	public void removeFromGeneralIgnoreSet(EStructuralFeature eStructuralFeature) {
		Iterator<StructuralFeatureIdentifier> iterator = generalIgnoreSet.iterator();
		while (iterator.hasNext()) {
			StructuralFeatureIdentifier next = iterator.next();
			if (next.geteStructuralFeature().equals(eStructuralFeature.getName())) {
				iterator.remove();
			}
		}
	}
	
	public boolean removeFromGeneralIgnoreSet(StructuralFeatureIdentifier structuralFeatureIdentifier) {
		return generalIgnoreSet.remove(structuralFeatureIdentifier);
	}
	
	protected EStructuralFeature getEStructuralFeature(String className, String fieldName) {
		for (EPackage ePackage : packages) {
			if (ePackage.getEClassifier(className) != null) {
				EClass eClass = (EClass)ePackage.getEClassifier(className);
				return eClass.getEStructuralFeature(fieldName);
			}
		}
		return null;
	}

	public boolean shouldFollowReference(EClass originalQueryClass, EClass eClass, EStructuralFeature eStructuralFeature) {
		StructuralFeatureIdentifier o = new StructuralFeatureIdentifier(eClass.getName(), eStructuralFeature.getName());
		boolean generalShouldIgnoreAnswer = generalIgnoreSet.contains(o);
		if (generalShouldIgnoreAnswer) {
			// If the general ignore file says ignore, we should check for a specific override
			if (specificIncludeMap.containsKey(originalQueryClass)) {
				return specificIncludeMap.get(originalQueryClass).contains(o);
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean shouldIncludeClass(EClass originalClass, EClass eClass) {
		return true;
	}
}