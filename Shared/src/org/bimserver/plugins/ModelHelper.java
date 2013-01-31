package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ModelHelper {

	private final ObjectIDM objectIDM;
	private final HashMap<IdEObject, IdEObject> converted = new HashMap<IdEObject, IdEObject>();

	public ModelHelper(ObjectIDM objectIDM) {
		this.objectIDM = objectIDM;
	}
	
	public ModelHelper() {
		this.objectIDM = null;
	}

	public void copy(IdEObject object, IfcModelInterface destModel) throws IfcModelInterfaceException {
		copy(object.eClass(), object, destModel);
	}
	
	@SuppressWarnings("unchecked")
	private IdEObject copy(EClass originalEClass, IdEObject original, IfcModelInterface newModel) throws IfcModelInterfaceException {
		if (!((IdEObjectImpl)original).isLoadedOrLoading()) {
			return null;
		}
		if (converted.containsKey(original)) {
			return converted.get(original);
		}
		IdEObject newObject = (IdEObject) original.eClass().getEPackage().getEFactoryInstance().create(original.eClass());
		((IdEObjectImpl)newObject).setOid(original.getOid());
		converted.put(original, newObject);
		if (newObject.eClass().getEAnnotation("wrapped") == null) {
			newModel.add(newObject.getOid(), newObject);
		}
		for (EStructuralFeature eStructuralFeature : original.eClass().getEAllStructuralFeatures()) {
			if (objectIDM == null ||  objectIDM.shouldFollowReference(originalEClass, original.eClass(), eStructuralFeature)) {
				Object get = original.eGet(eStructuralFeature);
				if (eStructuralFeature instanceof EAttribute) {
					if (get instanceof Double) {
						EStructuralFeature doubleStringFeature = original.eClass().getEStructuralFeature("wrappedValueAsString");
						if (doubleStringFeature != null) {
							Object doubleString = original.eGet(doubleStringFeature);
							newObject.eSet(doubleStringFeature, doubleString);
						} else {
							newObject.eSet(eStructuralFeature, get);
						}
					} else {
						newObject.eSet(eStructuralFeature, get);
					}
				} else if (eStructuralFeature instanceof EReference) {
					if (get == null) {
					} else {
						if (eStructuralFeature.isMany()) {
							BasicEList<EObject> list = (BasicEList<EObject>) get;
							BasicEList<EObject> toList = (BasicEList<EObject>) newObject.eGet(eStructuralFeature);
							for (Object o : list) {
								if (converted.containsKey(o)) {
									toList.addUnique(converted.get(o));
								} else {
									IdEObject result = copy(originalEClass, (IdEObject) o, newModel);
									if (result != null) {
										toList.addUnique(result);
									}
								}
							}
						} else {
							if (converted.containsKey(get)) {
								newObject.eSet(eStructuralFeature, converted.get(get));
							} else {
								newObject.eSet(eStructuralFeature, copy(originalEClass, (IdEObject) get, newModel));
							}
						}
					}
				}
			}
		}
		return newObject;
	}
}