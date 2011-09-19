package org.bimserver.client;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class Session {

	private ServiceInterface serviceInterface;
	private Set<IdEObject> newObjects = new HashSet<IdEObject>();

	public Session(ServiceInterface serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T create(Class<T> cl) {
		EClass eClass = (EClass) Ifc2x3Package.eINSTANCE.getEClassifier(cl.getSimpleName());
		IdEObject eObject = (IdEObject) Ifc2x3Factory.eINSTANCE.create(eClass);
		try {
			Long oid = serviceInterface.createObject(cl.getSimpleName());
			newObjects.add(eObject);
			eObject.setOid(oid);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return (T) eObject;
	}

	public void startTransaction(int pid) {
		try {
			serviceInterface.startTransaction(pid);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	public long commitTransaction() {
		try {
			for (IdEObject eObject : newObjects) {
				for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
					Object val = eObject.eGet(eStructuralFeature);
					if (val != null) {
						if (eStructuralFeature instanceof EAttribute) {
							EAttribute eAttribute = (EAttribute) eStructuralFeature;
							if (eAttribute.isMany()) {
								@SuppressWarnings("rawtypes")
								List list = (List) val;
								for (Object o : list) {
									if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEString()) {
										serviceInterface.addStringAttribute(eObject.getOid(), eObject.eClass().getName(), eAttribute.getName(), (String) o);
									} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEInt()) {
										serviceInterface.addIntegerAttribute(eObject.getOid(), eObject.eClass().getName(), eAttribute.getName(), (Integer) o);
									} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
										serviceInterface.addFloatAttribute(eObject.getOid(), eObject.eClass().getName(), eAttribute.getName(), (Float) o);
									} else {
										throw new RuntimeException("Unimplemented: " + eAttribute.getEType());
									}
								}
							} else {
								if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEString()) {
									serviceInterface.setStringAttribute(eObject.getOid(), eObject.eClass().getName(), eAttribute.getName(), (String) val);
								} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEInt()) {
									serviceInterface.setIntegerAttribute(eObject.getOid(), eObject.eClass().getName(), eAttribute.getName(), (Integer) val);
								} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
									serviceInterface.setFloatAttribute(eObject.getOid(), eObject.eClass().getName(), eAttribute.getName(), (Float) val);
								} else if (eAttribute.getEType() instanceof EEnum) {
									serviceInterface.setEnumAttribute(eObject.getOid(), eObject.eClass().getName(), eAttribute.getName(), val.toString());
								} else {
									throw new RuntimeException("Unimplemented: " + eAttribute.getEType());
								}
							}
						} else if (eStructuralFeature instanceof EReference) {
							EReference eReference = (EReference) eStructuralFeature;
							if (eReference.isMany()) {
								@SuppressWarnings("unchecked")
								List<IdEObject> list = (List<IdEObject>) val;
								for (IdEObject object : list) {
									serviceInterface.addReference(eObject.getOid(), eObject.eClass().getName(), eReference.getName(), object.getOid(), object.eClass().getName());
								}
							} else {
								IdEObject referredObject = (IdEObject) val;
								serviceInterface.setReference(eObject.getOid(), eObject.eClass().getName(), eReference.getName(), referredObject.getOid(), referredObject.eClass()
										.getName());
							}
						}
					}
				}
			}
			return serviceInterface.commitTransaction();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return -1;
	}
}