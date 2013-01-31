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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.store.CompareContainer;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.DataValue;
import org.bimserver.models.store.ListDataValue;
import org.bimserver.models.store.ObjectModified;
import org.bimserver.models.store.ReferenceDataValue;
import org.bimserver.models.store.SimpleDataValue;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.modelcompare.ModelCompare;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class AbstractModelCompare implements ModelCompare {
	private final ObjectIDM objectIDM;
	private final Map<EClass, CompareContainer> map = new HashMap<EClass, CompareContainer>();

	public AbstractModelCompare(ObjectIDM objectIDM) {
		this.objectIDM = objectIDM;
	}

	protected DataObject makeDataObject(IdEObject eObject) {
		DataObject dataObject = StoreFactory.eINSTANCE.createDataObject();
		((IdEObjectImpl)dataObject).setOid(eObject.getOid());
		if (eObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot)eObject;
			dataObject.setName(ifcRoot.getName());
			if (ifcRoot.getGlobalId() != null) {
				dataObject.setGuid(ifcRoot.getGlobalId());
			}
		}
		for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
			Object val = eObject.eGet(eStructuralFeature);
			if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					ListDataValue listDataValue = StoreFactory.eINSTANCE.createListDataValue();
					listDataValue.setFieldName(eReference.getName());
					EList<DataValue> values = listDataValue.getValues();
					for (Object v : (List<?>)val) {
						IdEObject ref = (IdEObject)v;
						ReferenceDataValue referenceDataValue = StoreFactory.eINSTANCE.createReferenceDataValue();
						referenceDataValue.setTypeName(eReference.getEType().getName());
						((IdEObjectImpl)referenceDataValue).setOid(ref.getOid());
						values.add(referenceDataValue);
					}
					dataObject.getValues().add(listDataValue);
				} else {
					IdEObject ref = (IdEObject)val;
					if (ref == null) {
						
					} else {
						ReferenceDataValue referenceDataValue = StoreFactory.eINSTANCE.createReferenceDataValue();
						referenceDataValue.setFieldName(eReference.getName());
						referenceDataValue.setTypeName(eReference.getEType().getName());
						((IdEObjectImpl)referenceDataValue).setOid(ref.getOid());
						dataObject.getValues().add(referenceDataValue);
					}
				}
			} else if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.isMany()) {
					ListDataValue listDataValue = StoreFactory.eINSTANCE.createListDataValue();
					listDataValue.setFieldName(eAttribute.getName());
					EList<DataValue> values = listDataValue.getValues();
					for (Object v : (List<?>)val) {
						SimpleDataValue simpleDataValue = StoreFactory.eINSTANCE.createSimpleDataValue();
						simpleDataValue.setFieldName(eAttribute.getName());
						simpleDataValue.setStringValue(v.toString());
						values.add(simpleDataValue);
					}
					dataObject.getValues().add(listDataValue);
				} else {
					SimpleDataValue simpleDataValue = StoreFactory.eINSTANCE.createSimpleDataValue();
					simpleDataValue.setFieldName(eAttribute.getName());
					simpleDataValue.setStringValue(val == null ? "null" : val.toString());
				}
			}
		}
		return dataObject;
	}
	
	protected Map<EClass, CompareContainer> getMap() {
		return map;
	}
	
	protected CompareContainer getCompareContainer(EClass eClass) {
		if (!map.containsKey(eClass)) {
			CompareContainer compareContainer = StoreFactory.eINSTANCE.createCompareContainer();
			compareContainer.setType(eClass.getName());
			map.put(eClass, compareContainer);
			return compareContainer;
		}
		return map.get(eClass);
	}

	protected void compareEObjects(EClass originalQueryClass, IdEObject eObject1, IdEObject eObject2, CompareResult result, CompareType sCompareType) {
		if (eObject1.eClass() != eObject2.eClass()) {
			return;
		}
		EClass eClass = eObject1.eClass();
		if (sCompareType == CompareType.ALL || sCompareType == CompareType.MODIFY) {
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				if (objectIDM.shouldFollowReference(originalQueryClass, eClass, eStructuralFeature)) {
					if (eStructuralFeature.getEAnnotation("hidden") != null) {
						continue;
					}
					Object value1 = eObject1.eGet(eStructuralFeature);
					Object value2 = eObject2.eGet(eStructuralFeature);
					if (eStructuralFeature.isMany()) {
					} else {
						if (eStructuralFeature.getEType() instanceof EClass) {
							if (value1 == null && value2 == null) {
							} else if (value1 == null && value2 != null) {
								EClass value2Class = ((EObject) value2).eClass();
								if (value2Class.getEAnnotation("wrapped") != null) {
									Object realVal2 = ((EObject) value2).eGet(value2Class.getEStructuralFeature("wrappedValue"));
									ObjectModified objectModified = StoreFactory.eINSTANCE.createObjectModified();
									objectModified.setDataObject(makeDataObject(eObject1));
									objectModified.setFieldName(eStructuralFeature.getName());
									objectModified.setOldValue(null);
									objectModified.setNewValue(realVal2.toString());
									getCompareContainer(eObject1.eClass()).getItems().add(objectModified);
								}
							} else if (value1 != null && value2 == null) {
								EClass value1Class = ((EObject) value1).eClass();
								if (value1Class.getEAnnotation("wrapped") != null) {
									Object realVal1 = ((EObject) value1).eGet(value1Class.getEStructuralFeature("wrappedValue"));
									ObjectModified objectModified = StoreFactory.eINSTANCE.createObjectModified();
									objectModified.setDataObject(makeDataObject(eObject1));
									objectModified.setFieldName(eStructuralFeature.getName());
									objectModified.setOldValue(realVal1.toString());
									objectModified.setNewValue(null);
									getCompareContainer(eObject1.eClass()).getItems().add(objectModified);
								}
							} else {
								EClass value1Class = ((EObject) value1).eClass();
								if (((EObject) value1).eClass().getEAnnotation("wrapped") != null) {
									Object realVal1 = ((EObject) value1).eGet(value1Class.getEStructuralFeature("wrappedValue"));
									Object realVal2 = ((EObject) value2).eGet(value1Class.getEStructuralFeature("wrappedValue"));
									if (!realVal1.equals(realVal2)) {
										ObjectModified objectModified = StoreFactory.eINSTANCE.createObjectModified();
										objectModified.setDataObject(makeDataObject(eObject1));
										objectModified.setFieldName(eStructuralFeature.getName());
										objectModified.setOldValue(realVal1.toString());
										objectModified.setNewValue(realVal2.toString());
										getCompareContainer(eObject1.eClass()).getItems().add(objectModified);
									}
								}
							}
						} else if (eStructuralFeature.getEType() instanceof EDataType) {
							if (value1 == null && value2 == null) {
							} else if (value1 == null && value2 != null) {
								ObjectModified objectModified = StoreFactory.eINSTANCE.createObjectModified();
								objectModified.setDataObject(makeDataObject(eObject1));
								objectModified.setFieldName(eStructuralFeature.getName());
								objectModified.setOldValue(null);
								objectModified.setNewValue(value2.toString());
								getCompareContainer(eObject1.eClass()).getItems().add(objectModified);
							} else if (value1 != null && value2 == null) {
								ObjectModified objectModified = StoreFactory.eINSTANCE.createObjectModified();
								objectModified.setDataObject(makeDataObject(eObject1));
								objectModified.setFieldName(eStructuralFeature.getName());
								objectModified.setOldValue(value1.toString());
								objectModified.setNewValue(null);
								getCompareContainer(eObject1.eClass()).getItems().add(objectModified);
							} else if (!value1.equals(value2)) {
								ObjectModified objectModified = StoreFactory.eINSTANCE.createObjectModified();
								objectModified.setDataObject(makeDataObject(eObject1));
								objectModified.setFieldName(eStructuralFeature.getName());
								objectModified.setOldValue(value1.toString());
								objectModified.setNewValue(value2.toString());
								getCompareContainer(eObject1.eClass()).getItems().add(objectModified);
							}
						}
					}
				}
			}
		}
	}
}