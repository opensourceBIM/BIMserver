package org.bimserver.ifc.printer;

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

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

public class IfcPrinter {
	
	@SuppressWarnings("unchecked")
	public void printMap(Map<Long, EObject> map) {
		for (Long key : map.keySet()) {
			EObject object = map.get(key);
			System.out.println("#" + key + " " + object.eClass().getName());
			for (EAttribute attribute : object.eClass().getEAllAttributes()) {
				System.out.println("\t" + attribute.getName() + "(" + attribute.getEType().getName() + "): " + object.eGet(attribute));
			}
			for (EReference reference : object.eClass().getEAllReferences()) {
				System.out.println("\t" + reference.getName() + "(" + reference.getEReferenceType().getName() + "): ");
				if (object.eGet(reference) instanceof EObjectResolvingEList) {
					EObjectResolvingEList<EObject> referencedObjectList = (EObjectResolvingEList<EObject>)object.eGet(reference);
					if (referencedObjectList != null && referencedObjectList.size() > 0) {
						if (reference.getEReferenceType().getEStructuralFeature("wrappedValue") != null) {
							for (Object obj : referencedObjectList) {
								Object wrappedValue = ((EObject)obj).eGet(reference.getEReferenceType().getEStructuralFeature("wrappedValue"));
								System.out.println(wrappedValue.toString());
								if (referencedObjectList.get(referencedObjectList.size()-1) != obj) {
									System.out.println();
									System.out.println("\t" + reference.getName() + "(" + reference.getEReferenceType().getName() + "): ");
								}
							}
						} else {
							for (Object obj : referencedObjectList) {
								if (obj != null) {
									System.out.println("=> ");
								}
							}
						}
					}
				} else if (reference.getEReferenceType().getEStructuralFeature("wrappedValue") != null) {
//					EObject object2 = (EObject)object.eGet(reference);
//					if (object2 != null) {
//						Object wrappedValue = object2.eGet(reference.getEReferenceType().getEStructuralFeature("wrappedValue"));
//						Logger.log(wrappedValue);
//					}
				} else {
					if (object.eGet(reference) != null) {
						System.out.println("=>");
					} else {
						System.out.println("null");
					}
				}
				System.out.println();
			}
		}
	}
}