package org.bimserver.ifc;

import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Factory;
import org.bimserver.ifc.emf.Ifc2x3.WrappedValue;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class BimModelSerializer extends EmfSerializer {
	private final FieldIgnoreMap fieldIgnoreMap;

	public BimModelSerializer(String fileName, IfcModel model, FieldIgnoreMap fieldIgnoreMap) {
		super(fileName, model);
		this.fieldIgnoreMap = fieldIgnoreMap;
	}

	@SuppressWarnings("unchecked")
	protected EObject convertToSubset(EClass originalClass, IdEObject ifcRootObject, IfcModel newModel, Map<EObject, EObject> converted) {
		IdEObject newObject = (IdEObject) Ifc2x3Factory.eINSTANCE.create(ifcRootObject.eClass());
		converted.put(ifcRootObject, newObject);
		if (!(newObject instanceof WrappedValue)) {
			newModel.add(newObject);
		}
		for (EStructuralFeature eStructuralFeature : ifcRootObject.eClass().getEAllStructuralFeatures()) {
			if (!fieldIgnoreMap.shouldIgnoreField(ifcRootObject.eClass(), ifcRootObject.eClass(), eStructuralFeature)) {
				Object get = ifcRootObject.eGet(eStructuralFeature);
				if (eStructuralFeature instanceof EAttribute) {
					if (get instanceof Float || get instanceof Double) {
						EStructuralFeature floatStringFeature = ifcRootObject.eClass().getEStructuralFeature("wrappedValueAsString");
						if (floatStringFeature != null) {
							Object floatString = ifcRootObject.eGet(floatStringFeature);
							newObject.eSet(floatStringFeature, floatString);
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
									toList.addUnique(convertToSubset(originalClass, (IdEObject) o, newModel, converted));
								}
							}
						} else {
							if (converted.containsKey(get)) {
								newObject.eSet(eStructuralFeature, converted.get(get));
							} else {
								newObject.eSet(eStructuralFeature, convertToSubset(originalClass, (IdEObject) get, newModel, converted));
							}
						}
					}
				}
			}
		}
		return newObject;
	}

	public FieldIgnoreMap getFieldIgnoreMap() {
		return fieldIgnoreMap;
	}
}