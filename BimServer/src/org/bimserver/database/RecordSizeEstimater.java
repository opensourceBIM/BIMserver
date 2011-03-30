package org.bimserver.database;

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
		if (eDataType == EcorePackage.eINSTANCE.getEInt()) {
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEFloat()) {
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEBoolean()) {
			return 1;
		} else if (eDataType == EcorePackage.eINSTANCE.getEDate()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getELong()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getEString()) {
			return AVERAGE_STRING_SIZE;
		} else if (eDataType == EcorePackage.eINSTANCE.getEDouble()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getEByteArray()) {
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