package org.bimserver.shared;

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

import java.util.Set;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.google.common.base.Charsets;

public abstract class AbstractHashMapVirtualObject {
	
	public int getPrimitiveSize(EDataType eDataType, Object val) {
		if (eDataType == EcorePackage.eINSTANCE.getEInt() || eDataType == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEShort() || eDataType == EcorePackage.eINSTANCE.getEShortObject()) {
			return 2;
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

	public abstract EClass eClass();

	public abstract AbstractHashMapVirtualObject getDirectFeature(EStructuralFeature eReference);

	public abstract Object get(String string);

	public abstract Set<HashMapVirtualObject> getDirectListFeature(EStructuralFeature representationsFeature);
}
