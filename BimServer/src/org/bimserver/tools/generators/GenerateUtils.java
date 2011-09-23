package org.bimserver.tools.generators;

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

	private static String firstLetterUpperCase(String in) {
		return in.substring(0, 1).toUpperCase() + in.substring(1);
	}
}