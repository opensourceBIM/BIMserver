package org.bimserver.plugins.guidanceproviders;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FieldIgnoreMap implements GuidanceProvider {
	public static class StructuralFeatureIdentifier {
		private final String eClass;
		private final String eStructuralFeature;
		
		public StructuralFeatureIdentifier(String eClass, String eStructuralFeature) {
			this.eClass = eClass;
			this.eStructuralFeature = eStructuralFeature;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((eClass == null) ? 0 : eClass.hashCode());
			result = prime * result + ((eStructuralFeature == null) ? 0 : eStructuralFeature.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			StructuralFeatureIdentifier other = (StructuralFeatureIdentifier) obj;
			if (eClass == null) {
				if (other.eClass != null)
					return false;
			} else if (!eClass.equals(other.eClass))
				return false;
			if (eStructuralFeature == null) {
				if (other.eStructuralFeature != null)
					return false;
			} else if (!eStructuralFeature.equals(other.eStructuralFeature))
				return false;
			return true;
		}
	}
	
	protected final Set<StructuralFeatureIdentifier> generalSet = new HashSet<StructuralFeatureIdentifier>();
	protected final Map<EClass, Set<StructuralFeatureIdentifier>> specificMap = new HashMap<EClass, Set<StructuralFeatureIdentifier>>();
	private final Set<? extends EPackage> packages;

	public FieldIgnoreMap(Set<? extends EPackage> ePackages) {
		packages = ePackages;
//		for (EPackage ePackage : ePackages) {
//			for (EClassifier classifier : ePackage.getEClassifiers()) {
//				if (classifier instanceof EClass) {
//					EClass eClass = (EClass) classifier;
//					for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
//						String name = feature.getName();
//						if (name.equals("ProvidesBoundaries") || name.equals("ContainedInStructure") || name.equals("FillsVoids") || name.equals("IsDecomposedBy")
//								|| name.equals("Decomposes") || name.equals("RelatedObjects") || name.equals("IsDefinedBy") || name.equals("ReferencedBy")
//								|| name.equals("HasAssociations") || name.equals("HasAssignments") || name.equals("ReferencedByPlacements") || name.equals("ConnectedTo")
//								|| name.equals("HasCoverings") || name.equals("HasProjections") || name.equals("HasStructuralMember") || name.equals("ReferencedInStructures")
//								|| name.equals("VoidsElements") || name.equals("ConnectedFrom")) {
//							set.add(feature);
//						}
//					}
//				}
//			}
//		}
	}
	
	protected EClass getEClass(String className) {
		for (EPackage ePackage : packages) {
			if (ePackage.getEClassifier(className) != null) {
				return (EClass)ePackage.getEClassifier(className);
			}
		}
		return null;
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

	public boolean shouldIgnoreField(EClass originalQueryClass, EClass eClass, EStructuralFeature eStructuralFeature) {
		StructuralFeatureIdentifier o = new StructuralFeatureIdentifier(eClass.getName(), eStructuralFeature.getName());
		boolean generalAnswer = generalSet.contains(o);
		if (generalAnswer == true) {
			// If the general ignore file says ignore, we should check for a specific override
			if (specificMap.containsKey(originalQueryClass)) {
				return !specificMap.get(originalQueryClass).contains(o);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldIgnoreClass(EClass eClass) {
		return false;
	}
}