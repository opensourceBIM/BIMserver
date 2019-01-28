package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.ObjectFactory;
import org.bimserver.emf.OidProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.objectidms.HideAllInversesObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.shared.GuidCompressor;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ModelHelper {

	private static ObjectIDM skipRepresentation;
	private static Map<EPackage, HideAllInversesObjectIDM> hideAllInverseMap;
	private static Map<EClass, ObjectIDM> objectIdmCache = null;

	private ObjectIDM objectIDM;
	private final HashMap<IdEObject, IdEObject> converted = new HashMap<IdEObject, IdEObject>();
	private ObjectFactory objectFactory;
	private IfcModelInterface targetModel;
	private OidProvider oidProvider;
	private boolean keepOriginalOids;
	private final HashMap<Long, InverseFix> inverseFixes = new HashMap<>();
	
	public static ObjectIDM createObjectIdm(final EClass onlyIncludeRepresentationForThisClass) {
		return objectIdmCache.get(onlyIncludeRepresentationForThisClass);
	}

	private static void initObjectIdmCache(final MetaDataManager metaDataManager) {
		hideAllInverseMap = new HashMap<EPackage, HideAllInversesObjectIDM>();
		objectIdmCache = new HashMap<EClass, ObjectIDM>();
		for (PackageMetaData packageMetaData : metaDataManager.getAllIfc()) {
			final HideAllInversesObjectIDM hideAllInverse = new HideAllInversesObjectIDM(Collections.singleton(packageMetaData.getEPackage()), packageMetaData);
			hideAllInverseMap.put(packageMetaData.getEPackage(), hideAllInverse);
			for (final EClass onlyIncludeRepresentationForThisClass : packageMetaData.getAllSubClasses(packageMetaData.getEClass("IfcProduct"))) {
				ObjectIDM objectIdm = new ObjectIDM() {
					@Override
					public boolean shouldIncludeClass(EClass originalClass, EClass eClass) {
						return hideAllInverse.shouldIncludeClass(originalClass, eClass);
					}
					
					@Override
					public boolean shouldFollowReference(EClass originalClass, EClass eClass, EStructuralFeature eStructuralFeature) {
						if (eStructuralFeature.getName().equals("Representation") && onlyIncludeRepresentationForThisClass != eClass) {
							return false;
						} else {
							if (eStructuralFeature.getName().equals("StyledByItem")) {
								return true;
							}
							return hideAllInverse.shouldFollowReference(originalClass, eClass, eStructuralFeature);
						}
					}
				};
				objectIdmCache.put(onlyIncludeRepresentationForThisClass, objectIdm);
			}
		}
		skipRepresentation = new ObjectIDM() {
			private ObjectIDM hideAllInverse = new HideAllInversesObjectIDM(hideAllInverseMap.keySet(), metaDataManager.getPackageMetaData("ifc2x3tc1"));
			@Override
			public boolean shouldIncludeClass(EClass originalClass, EClass eClass) {
				return hideAllInverse.shouldIncludeClass(originalClass, eClass);
			}
			
			@Override
			public boolean shouldFollowReference(EClass originalClass, EClass eClass, EStructuralFeature eStructuralFeature) {
				if (eStructuralFeature.getName().equals("Representation")) {
					return false;
				} else {
					return hideAllInverse.shouldFollowReference(originalClass, eClass, eStructuralFeature);
				}
			}
		};
	}
	
	public ModelHelper(MetaDataManager metaDataManager, ObjectIDM objectIDM, IfcModelInterface targetModel) {
		synchronized (ModelHelper.class) {
			if (hideAllInverseMap == null) {
				initObjectIdmCache(metaDataManager);
			}
		}
		this.objectIDM = objectIDM;
		this.targetModel = targetModel;
		this.objectFactory = targetModel;
	}
	
	public ModelHelper(MetaDataManager metaDataManager, IfcModelInterface targetModel) {
		synchronized (ModelHelper.class) {
			if (hideAllInverseMap == null) {
				initObjectIdmCache(metaDataManager);
			}
		}
		this.targetModel = targetModel;
		this.objectIDM = null;
		this.objectFactory = targetModel;
	}

	public IdEObject copy(IdEObject object, boolean setOid) throws IfcModelInterfaceException {
		return copy(object.eClass(), object, setOid);
	}

	public IdEObject copy(IdEObject object, boolean setOid, ObjectIDM objectIDM) throws IfcModelInterfaceException {
		return copy(object.eClass(), object, setOid, objectIDM);
	}

	public void setKeepOriginalOids(boolean keepOriginalOids) {
		this.keepOriginalOids = keepOriginalOids;
	}

	private IdEObject copy(EClass originalEClass, IdEObject original, boolean setOid) throws IfcModelInterfaceException {
		return copy(originalEClass, original, setOid, this.objectIDM);
	}
	
	@SuppressWarnings("unchecked")
	public void copyDecomposes(IdEObject ifcObjectDefinition, IdEObject ownerHistory) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		IdEObject newObjectDefinition = copy(ifcObjectDefinition, false, skipRepresentation);
		EStructuralFeature decomposesFeature = newObjectDefinition.eClass().getEStructuralFeature("Decomposes");
		for (IdEObject ifcRelDecomposes : (List<IdEObject>)ifcObjectDefinition.eGet(decomposesFeature)) {
			copy(ifcRelDecomposes, false, skipRepresentation);
			EStructuralFeature relatingObjectFeature = ifcRelDecomposes.eClass().getEStructuralFeature("RelatingObject");
			IdEObject relatingObject = (IdEObject) ifcRelDecomposes.eGet(relatingObjectFeature);
			if (relatingObject != null) {
				copyDecomposes(relatingObject, ownerHistory);
			}
		}
		if (ifcObjectDefinition.eClass().getEPackage().getEClassifier("IfcElement").isInstance(ifcObjectDefinition)) {
			EStructuralFeature containedInStructureFeature = ifcObjectDefinition.eClass().getEStructuralFeature("ContainedInStructure");
			for (IdEObject containedInStructure : (List<IdEObject>)ifcObjectDefinition.eGet(containedInStructureFeature)) {
				IdEObject newContainedInSpatialStructure = getTargetModel().create(containedInStructure.eClass());
				newContainedInSpatialStructure.eSet(newContainedInSpatialStructure.eClass().getEStructuralFeature("GlobalId"), GuidCompressor.getNewIfcGloballyUniqueId());
				newContainedInSpatialStructure.eSet(newContainedInSpatialStructure.eClass().getEStructuralFeature("OwnerHistory"), ownerHistory);
				EStructuralFeature relatedElementsFeature = newContainedInSpatialStructure.eClass().getEStructuralFeature("RelatedElements");
				((List<IdEObject>)newContainedInSpatialStructure.eGet(relatedElementsFeature)).add(newObjectDefinition);
				EStructuralFeature relatingStructureFeature = containedInStructure.eClass().getEStructuralFeature("RelatingStructure");
				IdEObject newRelatingStructre = copy(((IdEObject)containedInStructure.eGet(relatingStructureFeature)), false, skipRepresentation);
				newContainedInSpatialStructure.eSet(relatingStructureFeature, newRelatingStructre);
				getTargetModel().add(oidProvider.newOid(newContainedInSpatialStructure.eClass()), newContainedInSpatialStructure);
				copyDecomposes((IdEObject)containedInStructure.eGet(relatingStructureFeature), ownerHistory);
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IdEObject copy(EClass originalEClass, IdEObject original, boolean setOid, ObjectIDM objectIDM) throws IfcModelInterfaceException {
		if (!((IdEObjectImpl)original).isLoadedOrLoading()) {
			return null;
		}
		if (converted.containsKey(original)) {
			return converted.get(original);
		}
		IdEObject newObject = (IdEObject) objectFactory.create(original.eClass());
		((IdEObjectImpl)newObject).setPid(original.getPid());
		((IdEObjectImpl)newObject).setLoadingState(State.LOADED);
		long oid = -1;
		if (keepOriginalOids) {
			oid = original.getOid();
			((IdEObjectImpl)newObject).setOid(oid);
		} else {
			if (newObject.getOid() == -1) {
				if (oidProvider != null) {
					oid = oidProvider.newOid(newObject.eClass());
				} else {
					oid = original.getOid();
				}
			}
		}
		if (setOid && newObject.getOid() == -1) {
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
			boolean canFollow = objectIDM == null || objectIDM.shouldFollowReference(originalEClass, original.eClass(), eStructuralFeature);
			Object get = original.eGet(eStructuralFeature);
			if (eStructuralFeature instanceof EAttribute) {
				if (get instanceof List) {
					List list = (List)get;
					List targetList = (List)newObject.eGet(eStructuralFeature);
					for (Object o : list) {
						targetList.add(o);
					}
				} else {
					newObject.eSet(eStructuralFeature, get);
				}
			} else if (eStructuralFeature instanceof EReference) {
				if (!canFollow) {
					continue;
				}
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
									IdEObject result = copy(originalEClass, (IdEObject) o, setOid, objectIDM);
									if (result != null) {
										toList.addUnique(result);
									}
								} else {
									// In some cases the object is not already converted AND canFollow = false AND there is an opposite mismatch
									// Findbugs says canFollow is always true at this point and it's right, TODO
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
								newObject.eSet(eStructuralFeature, copy(originalEClass, (IdEObject) get, setOid, objectIDM));
							}
						}
					}
				}
			}
		}
		return newObject;
	}

	public void setOidProvider(OidProvider oidProvider) {
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

	public IdEObject copyBasicObjects(IfcModelInterface model, Map<IdEObject, IdEObject> bigMap) throws IfcModelInterfaceException {
		PackageMetaData packageMetaData = model.getPackageMetaData();
		IdEObject newProject = null;
		for (IdEObject idEObject : model.getAllWithSubTypes(packageMetaData.getEClass("IfcProject"))) {
			newProject = copy(idEObject, false, skipRepresentation);
			bigMap.put(newProject, idEObject);
		}
		IdEObject newOwnerHistory = null;
		for (IdEObject idEObject : model.getAllWithSubTypes(packageMetaData.getEClass("IfcOwnerHistory"))) {
			newOwnerHistory = copy(idEObject, false, skipRepresentation);
			bigMap.put(newOwnerHistory, idEObject);
		}
		for (IdEObject idEObject : model.getAllWithSubTypes(packageMetaData.getEClass("IfcUnit"))) {
			bigMap.put(copy(idEObject, false, skipRepresentation), idEObject);
		}
		for (IdEObject idEObject : model.getAllWithSubTypes(packageMetaData.getEClass("IfcUnitAssignment"))) {
			bigMap.put(copy(idEObject, false, skipRepresentation), idEObject);
		}
		return newOwnerHistory;
	}
}