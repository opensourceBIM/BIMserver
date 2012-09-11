package org.bimserver.plugins;

import java.util.HashMap;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.WrappedValue;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class QueryEngineHelper {

	private final ObjectIDM objectIDM;
	private HashMap<IdEObject, IdEObject> converted;

	public QueryEngineHelper(ObjectIDM objectIDM) {
		this.objectIDM = objectIDM;
		this.converted = new HashMap<IdEObject, IdEObject>();
	}

	public void copy(IdEObject object, IfcModelInterface destModel) {
		try {
			copy(object.eClass(), object, destModel);
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private IdEObject copy(EClass originalEClass, IdEObject original, IfcModelInterface newModel) throws IfcModelInterfaceException {
		if (converted.containsKey(original)) {
			return converted.get(original);
		}
		IdEObject newObject = (IdEObject) original.eClass().getEPackage().getEFactoryInstance().create(original.eClass());
		((IdEObjectImpl)newObject).setOid(original.getOid());
		converted.put(original, newObject);
		if (!(newObject instanceof WrappedValue) && !(newObject instanceof IfcGloballyUniqueId)) {
			newModel.add(newObject.getOid(), newObject);
		}
		for (EStructuralFeature eStructuralFeature : original.eClass().getEAllStructuralFeatures()) {
			if (objectIDM.shouldFollowReference(originalEClass, original.eClass(), eStructuralFeature)) {
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
