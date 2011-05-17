package org.bimserver.plugins.serializers;

import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.WrappedValue;
import org.bimserver.plugins.ifcengine.IfcEngineFactory;
import org.bimserver.plugins.ignoreproviders.IgnoreProvider;
import org.bimserver.plugins.schema.Schema;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class BimModelSerializer extends EmfSerializer {

	public void init(IfcModelInterface model, Schema schema, IgnoreProvider ignoreProvider, IfcEngineFactory ifcEngineFactory) throws SerializerException {
		super.init(model, schema, ignoreProvider, ifcEngineFactory);
	}

	@SuppressWarnings("unchecked")
	protected EObject convertToSubset(EClass originalClass, IdEObject ifcRootObject, IfcModelInterface newModel, Map<EObject, EObject> converted) {
		IdEObject newObject = (IdEObject) Ifc2x3Factory.eINSTANCE.create(ifcRootObject.eClass());
		newObject.setOid(ifcRootObject.getOid());
		converted.put(ifcRootObject, newObject);
		if (!(newObject instanceof WrappedValue) && !(newObject instanceof IfcGloballyUniqueId)) {
			newModel.add(newObject.getOid(), newObject);
		}
		for (EStructuralFeature eStructuralFeature : ifcRootObject.eClass().getEAllStructuralFeatures()) {
			if (!getIgnoreProvider().shouldIgnoreField(originalClass, ifcRootObject.eClass(), eStructuralFeature)) {
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
}