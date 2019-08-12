package org.bimserver.plugins;

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
import org.bimserver.shared.GuidCompressor;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ModelHelper {

	private final HashMap<IdEObject, IdEObject> converted = new HashMap<IdEObject, IdEObject>();
	private ObjectFactory objectFactory;
	private IfcModelInterface targetModel;
	private OidProvider oidProvider;
	private boolean keepOriginalOids;
	private final HashMap<Long, InverseFix> inverseFixes = new HashMap<>();
	
	public ModelHelper(MetaDataManager metaDataManager, IfcModelInterface targetModel) {
		synchronized (ModelHelper.class) {
		}
		this.targetModel = targetModel;
		this.objectFactory = targetModel;
	}

	public IdEObject copy(IdEObject object, boolean setOid) throws IfcModelInterfaceException {
		return copy(object.eClass(), object, setOid);
	}

	public void setKeepOriginalOids(boolean keepOriginalOids) {
		this.keepOriginalOids = keepOriginalOids;
	}

	@SuppressWarnings("unchecked")
	public void copyDecomposes(IdEObject ifcObjectDefinition, IdEObject ownerHistory) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		IdEObject newObjectDefinition = copy(ifcObjectDefinition, false);
		EStructuralFeature decomposesFeature = newObjectDefinition.eClass().getEStructuralFeature("Decomposes");
		for (IdEObject ifcRelDecomposes : (List<IdEObject>)ifcObjectDefinition.eGet(decomposesFeature)) {
			copy(ifcRelDecomposes, false);
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
				IdEObject newRelatingStructre = copy(((IdEObject)containedInStructure.eGet(relatingStructureFeature)), false);
				newContainedInSpatialStructure.eSet(relatingStructureFeature, newRelatingStructre);
				getTargetModel().add(oidProvider.newOid(newContainedInSpatialStructure.eClass()), newContainedInSpatialStructure);
				copyDecomposes((IdEObject)containedInStructure.eGet(relatingStructureFeature), ownerHistory);
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IdEObject copy(EClass originalEClass, IdEObject original, boolean setOid) throws IfcModelInterfaceException {
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
			boolean canFollow = true;
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
									IdEObject result = copy(originalEClass, (IdEObject) o, setOid);
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
								newObject.eSet(eStructuralFeature, copy(originalEClass, (IdEObject) get, setOid));
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

	public IdEObject copyBasicObjects(IfcModelInterface model, Map<IdEObject, IdEObject> bigMap) throws IfcModelInterfaceException {
		PackageMetaData packageMetaData = model.getPackageMetaData();
		IdEObject newProject = null;
		for (IdEObject idEObject : model.getAllWithSubTypes(packageMetaData.getEClass("IfcProject"))) {
			newProject = copy(idEObject, false);
			bigMap.put(newProject, idEObject);
		}
		IdEObject newOwnerHistory = null;
		for (IdEObject idEObject : model.getAllWithSubTypes(packageMetaData.getEClass("IfcOwnerHistory"))) {
			newOwnerHistory = copy(idEObject, false);
			bigMap.put(newOwnerHistory, idEObject);
		}
		for (IdEObject idEObject : model.getAllWithSubTypes(packageMetaData.getEClass("IfcUnit"))) {
			bigMap.put(copy(idEObject, false), idEObject);
		}
		for (IdEObject idEObject : model.getAllWithSubTypes(packageMetaData.getEClass("IfcUnitAssignment"))) {
			bigMap.put(copy(idEObject, false), idEObject);
		}
		return newOwnerHistory;
	}
}