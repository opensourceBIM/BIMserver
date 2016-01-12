package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.utils.GrowingByteBuffer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class RecordSizeEstimater {
	// These are guesses, needs testing
	private static final int AVERAGE_PRIMITIVE_LIST_SIZE = 2;
	private static final int AVERAGE_REFERENCE_LIST_SIZE = 2;
	private static final int AVERAGE_STRING_SIZE = 5;
	private static final int AVERAGE_BYTE_ARRAY_SIZE = 0;
	
	private final Map<EClass, Integer> bufferSizeEstimates = new HashMap<EClass, Integer>();

	public void init(Set<EPackage> ePackages) {
		// Initialise a map of estimated required buffer sizes
		for (EPackage ePackage : ePackages) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					bufferSizeEstimates.put(eClass, estimateBufferSize(eClass));
				}
			}
		}
	}
	
	private int estimateBufferSize(EClass eClass) {
		int size = 0;
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.isMany()) {
					size += 2 + AVERAGE_PRIMITIVE_LIST_SIZE * getPrimitiveSize((EDataType) eAttribute.getEType());
				} else {
					size += getPrimitiveSize((EDataType) eAttribute.getEType());
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					size += 2 + AVERAGE_REFERENCE_LIST_SIZE * 10;
				} else {
					size += 10;
				}
			}
		}
		return size;
	}

	public int getPrimitiveSize(EDataType eDataType) {
		if (eDataType == EcorePackage.eINSTANCE.getEInt() || eDataType == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEFloat() || eDataType == EcorePackage.eINSTANCE.getEFloatObject()) {
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEBoolean() || eDataType == EcorePackage.eINSTANCE.getEBooleanObject()) {
			return 1;
		} else if (eDataType == EcorePackage.eINSTANCE.getEDate()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getELong() || eDataType == EcorePackage.eINSTANCE.getELongObject()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getEString()) {
			return AVERAGE_STRING_SIZE;
		} else if (eDataType == EcorePackage.eINSTANCE.getEDouble() || eDataType == EcorePackage.eINSTANCE.getEDoubleObject()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getEByteArray() || eDataType.getName().equals("DataHandler")) {
			return AVERAGE_BYTE_ARRAY_SIZE;
		} else if (eDataType instanceof EEnum) {
			return 4;
		}
		throw new RuntimeException("Unimplemented: " + eDataType);
	}

	public int getEstimate(EClass eClass) {
		return bufferSizeEstimates.get(eClass);
	}

	public void adjustBasedOnDefault(GrowingByteBuffer buffer, EClass eClass, int size) {
		if (size > AVERAGE_REFERENCE_LIST_SIZE) {
			buffer.ensureExtraCapacity(10 * (size - AVERAGE_REFERENCE_LIST_SIZE));
		}
	}

	public void adjustBasedOnDefault(GrowingByteBuffer buffer, EDataType eType, int size) {
		if (size > AVERAGE_PRIMITIVE_LIST_SIZE) {
			buffer.ensureExtraCapacity(getPrimitiveSize(eType) * (size - AVERAGE_PRIMITIVE_LIST_SIZE));
		}
	}
}