package org.bimserver.shared;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;

import com.google.common.base.Charsets;

public abstract class AbstractHashMapVirtualObject {
	
	public int getPrimitiveSize(EDataType eDataType, Object val) {
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
		} else if (eDataType == EcorePackage.eINSTANCE.getEDouble() || eDataType == EcorePackage.eINSTANCE.getEDoubleObject()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getEString()) {
			if (val != null) {
				return 4 + ((String) val).getBytes(Charsets.UTF_8).length;
			}
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEByteArray()) {
			if (val != null) {
				return 4 + ((byte[]) val).length;
			}
			return 4;
		} else if (eDataType instanceof EEnum) {
			return 4;
		}
		throw new RuntimeException("Unimplemented: " + eDataType);
	}
}
