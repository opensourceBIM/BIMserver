package org.bimserver.ifc.compare;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.store.CompareContainer;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.DataValue;
import org.bimserver.models.store.ListDataValue;
import org.bimserver.models.store.ObjectAdded;
import org.bimserver.models.store.ObjectModified;
import org.bimserver.models.store.ObjectRemoved;
import org.bimserver.models.store.ReferenceDataValue;
import org.bimserver.models.store.SimpleDataValue;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Compare {
	private static final Logger LOGGER = LoggerFactory.getLogger(Compare.class);
	private final GuidanceProvider guidanceProvider;
	private final Map<EClass, CompareContainer> map = new HashMap<EClass, CompareContainer>();

	public Compare(GuidanceProvider guidanceProvider) {
		this.guidanceProvider = guidanceProvider;
	}

	private DataObject makeDataObject(IdEObject eObject) {
		DataObject dataObject = StoreFactory.eINSTANCE.createDataObject();
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
						referenceDataValue.setOid(ref.getOid());
						values.add(referenceDataValue);
					}
					dataObject.getValues().add(listDataValue);
				} else {
					IdEObject ref = (IdEObject)val;
					ReferenceDataValue referenceDataValue = StoreFactory.eINSTANCE.createReferenceDataValue();
					referenceDataValue.setFieldName(eReference.getName());
					referenceDataValue.setTypeName(eReference.getEType().getName());
					referenceDataValue.setOid(ref.getOid());
					dataObject.getValues().add(referenceDataValue);
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
					simpleDataValue.setStringValue(val.toString());
				}
			}
		}
		return dataObject;
	}
	
	private CompareContainer getCompareContainer(EClass eClass) {
		if (!map.containsKey(eClass)) {
			CompareContainer compareContainer = StoreFactory.eINSTANCE.createCompareContainer();
			compareContainer.setType(eClass.getName());
			map.put(eClass, compareContainer);
			return compareContainer;
		}
		return map.get(eClass);
	}
	
	public CompareResult compareOnGuids(IfcModelInterface model1, IfcModelInterface model2, CompareType compareType) {
		CompareResult result = StoreFactory.eINSTANCE.createCompareResult();
		try {
			for (EClassifier eClassifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
				if (eClassifier instanceof EClass && Ifc2x3Package.eINSTANCE.getIfcRoot().isSuperTypeOf((EClass) eClassifier)) {
					EClass eClass = (EClass) eClassifier;
					for (String guid : model1.getGuids(eClass)) {
						IdEObject eObject1 = model1.getByGuid(eClass, guid);
						IdEObject eObject2 = model2.getByGuid(eClass, guid);
						if  (eObject2 == null) {
							if (compareType == CompareType.ALL || compareType == CompareType.DELETE) {
								ObjectRemoved objectRemoved = StoreFactory.eINSTANCE.createObjectRemoved();
								objectRemoved.setDataObject(makeDataObject(eObject1));
								getCompareContainer(eObject1.eClass()).getItems().add(objectRemoved);
							}
						}
					}
					for (String guid : model2.getGuids(eClass)) {
						IdEObject eObject1 = model1.getByGuid(eClass, guid);
						IdEObject eObject2 = model2.getByGuid(eClass, guid);
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
			LOGGER.error("", e);
		}
		return result;
	}

	public CompareResult compareOnNames(IfcModelInterface model1, IfcModelInterface model2, CompareType compareType) {
		CompareResult result = StoreFactory.eINSTANCE.createCompareResult();
		try {
			for (EClassifier eClassifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
				if (eClassifier instanceof EClass && Ifc2x3Package.eINSTANCE.getIfcRoot().isSuperTypeOf((EClass) eClassifier)) {
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
			LOGGER.error("", e);
		}
		return result;
	}

	private void compareEObjects(EClass originalQueryClass, IdEObject eObject1, IdEObject eObject2, CompareResult result, CompareType sCompareType) {
		if (eObject1.eClass() != eObject2.eClass()) {
			return;
		}
		EClass eClass = eObject1.eClass();
		if (sCompareType == CompareType.ALL || sCompareType == CompareType.MODIFY) {
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				if (!guidanceProvider.shouldIgnoreField(originalQueryClass, eClass, eStructuralFeature)) {
					if (eStructuralFeature.getName().endsWith("AsString")) {
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
								if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(value2Class)) {
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
								if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(value1Class)) {
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
								if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(((EObject) value1).eClass())) {
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
								objectModified.setOldValue(value1.toString());
								objectModified.setNewValue(value2.toString());
								getCompareContainer(eObject1.eClass()).getItems().add(objectModified);
							} else if (value1 != null && value2 == null) {
								ObjectModified objectModified = StoreFactory.eINSTANCE.createObjectModified();
								objectModified.setDataObject(makeDataObject(eObject1));
								objectModified.setFieldName(eStructuralFeature.getName());
								objectModified.setOldValue(value1.toString());
								objectModified.setNewValue(value2.toString());
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