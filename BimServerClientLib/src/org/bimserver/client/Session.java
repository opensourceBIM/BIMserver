package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDataValue;
import org.bimserver.interfaces.objects.SListDataValue;
import org.bimserver.interfaces.objects.SReferenceDataValue;
import org.bimserver.interfaces.objects.SSimpleDataValue;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Session {

	private static final Logger LOGGER = LoggerFactory.getLogger(Session.class);
	private ServiceInterface serviceInterface;
	private Set<IdEObject> newObjects = new HashSet<IdEObject>();

	public Session(ServiceInterface serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T create(Class<T> cl) {
		EClass eClass = (EClass) Ifc2x3tc1Package.eINSTANCE.getEClassifier(cl.getSimpleName());
		IdEObject eObject = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create(eClass);
		try {
			Long oid = serviceInterface.createObject(cl.getSimpleName());
			newObjects.add(eObject);
			((IdEObjectImpl)eObject).setOid(oid);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		return (T) eObject;
	}

	public void startTransaction(long poid) {
		try {
			serviceInterface.startTransaction(poid);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
	}

	public long commitTransaction(String comment) {
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
										serviceInterface.addStringAttribute(eObject.getOid(), eAttribute.getName(), (String) o);
									} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEInt()) {
										serviceInterface.addIntegerAttribute(eObject.getOid(), eAttribute.getName(), (Integer) o);
									} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
										serviceInterface.addDoubleAttribute(eObject.getOid(), eAttribute.getName(), (Double) o);
									} else {
										throw new RuntimeException("Unimplemented: " + eAttribute.getEType());
									}
								}
							} else {
								if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEString()) {
									serviceInterface.setStringAttribute(eObject.getOid(), eAttribute.getName(), (String) val);
								} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEInt()) {
									serviceInterface.setIntegerAttribute(eObject.getOid(), eAttribute.getName(), (Integer) val);
								} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
									serviceInterface.setDoubleAttribute(eObject.getOid(), eAttribute.getName(), (Double) val);
								} else if (eAttribute.getEType() instanceof EEnum) {
									serviceInterface.setEnumAttribute(eObject.getOid(), eAttribute.getName(), val.toString());
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
									serviceInterface.addReference(eObject.getOid(), eReference.getName(), object.getOid());
								}
							} else {
								IdEObject referredObject = (IdEObject) val;
								serviceInterface.setReference(eObject.getOid(), eReference.getName(), referredObject.getOid());
							}
						}
					}
				}
			}
			return serviceInterface.commitTransaction(comment);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		return -1;
	}

	@SuppressWarnings("unused")
	public IfcModelInterface loadModel(long roid) {
		try {
			List<SDataObject> dataObjects = serviceInterface.getDataObjects(roid);
			for (SDataObject dataObject : dataObjects) {
				EClass eClass = (EClass) Ifc2x3tc1Package.eINSTANCE.getEClassifier(dataObject.getType());
				EObject eObject = Ifc2x3tc1Factory.eINSTANCE.create(eClass);
				for (SDataValue dataValue : dataObject.getValues()) {
					EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(dataValue.getFieldName());
					if (dataValue instanceof SSimpleDataValue) {
						SSimpleDataValue simpleDataValue = (SSimpleDataValue)dataValue;
						if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
							eObject.eSet(eStructuralFeature, simpleDataValue.getStringValue());
						} else if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEInt()) {
							eObject.eSet(eStructuralFeature, Integer.parseInt(simpleDataValue.getStringValue()));
						} else if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
							eObject.eSet(eStructuralFeature, Float.parseFloat(simpleDataValue.getStringValue()));
						} 
					} else if (dataValue instanceof SReferenceDataValue) {
						SReferenceDataValue referenceDataValue = (SReferenceDataValue)dataValue;
					} else if (dataValue instanceof SListDataValue) {
						SListDataValue listDataValue = (SListDataValue)dataValue;
					}
				}
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		return null;
	}
}