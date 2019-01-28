package org.bimserver.tools.generators;

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

import javax.activation.DataHandler;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class GenerateUtils {
	public static String makeGetter(EStructuralFeature eStructuralFeature) {
		StringBuilder sb = new StringBuilder();
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
			sb.append("is");
		} else {
			sb.append("get");
		}
		sb.append(firstLetterUpperCase(eStructuralFeature.getName()));
		if (eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) {
			sb.append("Id");
		}
		return sb.toString();
	}
	
	public static String makeSetter(EStructuralFeature eStructuralFeature) {
		StringBuilder sb = new StringBuilder();
		sb.append("set" + firstLetterUpperCase(eStructuralFeature.getName()));
		if (eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) {
			sb.append("Id");
		}
		return sb.toString();
	}
	
	public static String getType(EStructuralFeature eStructuralFeature) {
		boolean embedsReference = eStructuralFeature.getEAnnotation("embedsreference") != null;
		EClassifier eType = eStructuralFeature.getEType();
		if (eStructuralFeature.isMany()) {
			if (eType instanceof EDataType) {
				if (eType == EcorePackage.eINSTANCE.getEString()) {
					return "List<String>";
				} else if (eType == EcorePackage.eINSTANCE.getEInt() || eType == EcorePackage.eINSTANCE.getEIntegerObject()) {
					return "List<Integer>";
				} else if (eType == EcorePackage.eINSTANCE.getELong() || eType == EcorePackage.eINSTANCE.getELongObject()) {
					return "List<Long>";
				} else if (eType == EcorePackage.eINSTANCE.getEDouble() || eType == EcorePackage.eINSTANCE.getEDoubleObject()) {
					return "List<Double>";
				} else if (eType == EcorePackage.eINSTANCE.getEBoolean() || eType == EcorePackage.eINSTANCE.getEBooleanObject()) {
					return "List<Boolean>";
				} else if (eType == EcorePackage.eINSTANCE.getEFloat() || eType == EcorePackage.eINSTANCE.getEFloatObject()) {
					return "List<Float>";
				} else if (eType == EcorePackage.eINSTANCE.getEDate()) {
					return "List<Date>";
				}
			} else if (eType instanceof EClass) {
				if (embedsReference) {
					return "List<S" + eType.getName() + ">";
				} else {
					return "List<Long>";
				}
			}
		} else {
			if (eType instanceof EDataType) {
				if (eType == EcorePackage.eINSTANCE.getEString()) {
					return "String";
				} else if (eType == EcorePackage.eINSTANCE.getEInt() || eType == EcorePackage.eINSTANCE.getEIntegerObject()) {
					return "Integer";
				} else if (eType == EcorePackage.eINSTANCE.getELong() || eType == EcorePackage.eINSTANCE.getELongObject()) {
					return "Long";
				} else if (eType == EcorePackage.eINSTANCE.getEShort() || eType == EcorePackage.eINSTANCE.getEShortObject()) {
					return "Short";
				} else if (eType == EcorePackage.eINSTANCE.getEDouble() || eType == EcorePackage.eINSTANCE.getEDoubleObject()) {
					return "Double";
				} else if (eType == EcorePackage.eINSTANCE.getEBoolean() || eType == EcorePackage.eINSTANCE.getEBooleanObject()) {
					return "Boolean";
				} else if (eType == EcorePackage.eINSTANCE.getEFloat() || eType == EcorePackage.eINSTANCE.getEFloatObject()) {
					return "Float";
				} else if (eType == EcorePackage.eINSTANCE.getEDate()) {
					return "Date";
				} else if (eType == EcorePackage.eINSTANCE.getEByteArray()) {
					return "byte[]";
				} else if (eType.getInstanceClass() == DataHandler.class) {
					return "DataHandler";
				}
			} else if (eType instanceof EClass) {
				if (embedsReference) {
					return "S" + eType.getName();
				} else {
					return "Long";
				}
			}
		}
		return "S" + eType.getName();
	}

	private static String firstLetterUpperCase(String in) {
		return in.substring(0, 1).toUpperCase() + in.substring(1);
	}
}