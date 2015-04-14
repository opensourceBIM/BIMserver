package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import org.bimserver.emf.ObjectFactory;
import org.bimserver.emf.OidProvider;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ModelHelper {

	private ObjectIDM objectIDM;
	private final HashMap<IdEObject, IdEObject> converted = new HashMap<IdEObject, IdEObject>();
	private ObjectFactory objectFactory;
	private IfcModelInterface targetModel;
	private OidProvider<Long> oidProvider;
	private boolean keepOriginalOids;
	private final HashMap<Long, InverseFix> inverseFixes = new HashMap<>();

	public ModelHelper(ObjectIDM objectIDM, IfcModelInterface targetModel) {
		this.objectIDM = objectIDM;
		this.targetModel = targetModel;
		this.objectFactory = targetModel;
	}
	
	public ModelHelper(IfcModelInterface targetModel) {
		this.targetModel = targetModel;
		this.objectIDM = null;
		this.objectFactory = targetModel;
	}

	public IdEObject copy(IdEObject object, boolean setOid) throws IfcModelInterfaceException {
		return copy(object.eClass(), object, setOid);
	}

	public void setKeepOriginalOids(boolean keepOriginalOids) {
		this.keepOriginalOids = keepOriginalOids;
	}
	
	@SuppressWarnings("unchecked")
	private IdEObject copy(EClass originalEClass, IdEObject original, boolean setOid) throws IfcModelInterfaceException {
		if (!((IdEObjectImpl)original).isLoadedOrLoading()) {
			return null;
		}
		if (converted.containsKey(original)) {
			return converted.get(original);
		}
		IdEObject newObject = (IdEObject) objectFactory.create(original.eClass());
		((IdEObjectImpl)newObject).setLoadingState(State.LOADED);
		long oid = -1;
		if (keepOriginalOids) {
			oid = original.getOid();
		} else {
			if (newObject.getOid() == -1) {
				if (oidProvider != null) {
					oid = oidProvider.newOid(newObject.eClass());
				} else {
					oid = original.getOid();
				}
			}
		}
		if (setOid) {
			((IdEObjectImpl)newObject).setOid(oid);
		}
		converted.put(original, newObject);
		if (newObject.eClass().getEAnnotation("wrapped") == null) {
			targetModel.add(newObject.getOid(), newObject);
		}

		if (inverseFixes.containsKey(original.getOid())) {
			InverseFix inverseFix = inverseFixes.get(original.getOid());
			inverseFix.apply(newObject);
		}

		for (EStructuralFeature eStructuralFeature : original.eClass().getEAllStructuralFeatures()) {
			boolean canFollow = objectIDM == null ||  objectIDM.shouldFollowReference(originalEClass, original.eClass(), eStructuralFeature);
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
						EList<EObject> list = (EList<EObject>) get;
						AbstractEList<EObject> toList = (AbstractEList<EObject>) newObject.eGet(eStructuralFeature);
						
						for (Object o : list) {
							if (converted.containsKey(o)) {
								toList.addUnique(converted.get(o));
							} else {
								if (canFollow) {
									IdEObject result = copy(originalEClass, (IdEObject) o, setOid);
									if (result != null) {
										toList.addUnique(result);
									}
								} else {
									// In some cases the object is not already converted AND canFollow = false AND there is an opposite mismatch
									if (eStructuralFeature.getName().equals("RelatedElements")) {
										inverseFixes.put(((IdEObject)o).getOid(), new InverseFix(Ifc2x3tc1Package.eINSTANCE.getIfcRelContainedInSpatialStructure_RelatedElements(), newObject));
									}
								}
							}
						}
					} else {
						if (converted.containsKey(get)) {
							newObject.eSet(eStructuralFeature, converted.get(get));
						} else {
							if (canFollow) {
								newObject.eSet(eStructuralFeature, copy(originalEClass, (IdEObject) get, setOid));
							}
						}
					}
				}
			}
		}
		return newObject;
	}

	public void setOidProvider(OidProvider<Long> oidProvider) {
		this.oidProvider = oidProvider;
	}
	
	public void setTargetModel(IfcModelInterface targetModel) {
		this.targetModel = targetModel;
	}

	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}
	
	public IfcModelInterface getTargetModel() {
		return targetModel;
	}

	public void setObjectIDM(ObjectIDM idm) {
		this.objectIDM = idm;
	}

	public ObjectIDM getObjectIDM() {
		return objectIDM;
	}
}