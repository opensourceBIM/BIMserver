package org.bimserver.ifc.compare;

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

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.store.CompareContainer;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.ObjectAdded;
import org.bimserver.models.store.ObjectRemoved;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.modelcompare.ModelCompareException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

public class NameBasedModelCompare extends AbstractModelCompare {

	public NameBasedModelCompare(ObjectIDM objectIDM) {
		super(objectIDM);
	}
	
	public CompareResult compare(IfcModelInterface model1, IfcModelInterface model2, CompareType compareType) throws ModelCompareException {
		CompareResult result = StoreFactory.eINSTANCE.createCompareResult();
		try {
			for (EClassifier eClassifier : Ifc2x3tc1Package.eINSTANCE.getEClassifiers()) {
				if (eClassifier instanceof EClass && Ifc2x3tc1Package.eINSTANCE.getIfcRoot().isSuperTypeOf((EClass) eClassifier)) {
					EClass eClass = (EClass) eClassifier;
					for (String name : model1.getNames(eClass)) {
						IdEObject eObject1 = model1.getByName(eClass, name);
						IdEObject eObject2 = model2.getByName(eClass, name);
						if  (eObject2 == null) {
							if (compareType == CompareType.ALL || compareType == CompareType.DELETE) {
								ObjectRemoved objectRemoved = StoreFactory.eINSTANCE.createObjectRemoved();
								objectRemoved.setDataObject(makeDataObject(eObject1));
								getCompareContainer(eObject1.eClass()).getItems().add(objectRemoved);
							}
						}
					}
					for (String name : model2.getNames(eClass)) {
						IdEObject eObject1 = model1.getByName(eClass, name);
						IdEObject eObject2 = model2.getByName(eClass, name);
						if (eObject1 == null) {
							if (compareType == CompareType.ALL || compareType == CompareType.ADD) {
								ObjectAdded objectAdded = StoreFactory.eINSTANCE.createObjectAdded();
								objectAdded.setDataObject(makeDataObject(eObject2));
								getCompareContainer(eObject2.eClass()).getItems().add(objectAdded);
							}
						} else {
							compareEObjects(eClass, eObject1, eObject2, result, compareType);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new ModelCompareException(e);
		}
		for (CompareContainer compareContainer : getMap().values()) {
			result.getItems().add(compareContainer);
		}
		return result;
	}
}
