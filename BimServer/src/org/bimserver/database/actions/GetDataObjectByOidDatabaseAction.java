package org.bimserver.database.actions;

import java.util.LinkedHashSet;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ReadSet;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.emf.Ifc2x3.IfcGloballyUniqueId;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.bimserver.ifc.emf.Ifc2x3.WrappedValue;
import org.bimserver.shared.DataObject;
import org.bimserver.shared.UserException;
import org.bimserver.shared.DataObject.ListDataValue;
import org.bimserver.shared.DataObject.ReferenceDataValue;
import org.bimserver.shared.DataObject.SimpleDataValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.BiMap;

public class GetDataObjectByOidDatabaseAction extends BimDatabaseAction<DataObject> {

	private final long oid;
	private final short cid;
	private final long roid;

	public GetDataObjectByOidDatabaseAction(AccessMethod accessMethod, long roid, long oid, short cid) {
		super(accessMethod);
		this.roid = roid;
		this.oid = oid;
		this.cid = cid;
	}

	@Override
	public DataObject execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Revision virtualRevision = bimDatabaseSession.getVirtualRevision(roid);
		EObject eObject = null;
		LinkedHashSet<IfcModel> ifcModels = new LinkedHashSet<IfcModel>();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			ReadSet readSet = new ReadSet(concreteRevision.getProject().getId(), concreteRevision.getId());
			eObject = bimDatabaseSession.get(cid, oid, readSet);
			IfcModel subModel = new IfcModel(readSet.getMap());
			subModel.setDate(concreteRevision.getDate());
			ifcModels.add(subModel);
			if (eObject != null) {
				break;
			}
		}
		IfcModel ifcModel = merge(virtualRevision.getProject(), ifcModels);
		if (eObject == null) {
			throw new UserException("Object not found");
		}
		DataObject dataObject = null;
		if (eObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot) eObject;
			String guid = ifcRoot.getGlobalId() != null ? ifcRoot.getGlobalId().getWrappedValue() : "";
			String name = ifcRoot.getName() != null ? ifcRoot.getName() : "";
			dataObject = new DataObject(eObject.eClass().getName(), oid, guid, name);
		} else {
			dataObject = new DataObject(eObject.eClass().getName(), oid, "", "");
		}
		fillDataObject(ifcModel.getMap(), eObject, dataObject);
		return dataObject;
	}

	@SuppressWarnings("unchecked")
	public static void fillDataObject(BiMap<? extends Long, ? extends EObject> mapResult, EObject eObject, DataObject dataObject) {
		for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
			Object eGet = eObject.eGet(eStructuralFeature);
			if (eStructuralFeature instanceof EAttribute) {
				if (!eStructuralFeature.getName().endsWith("AsString")) {
					dataObject.addField(eStructuralFeature.getName(), new SimpleDataValue(eGet));
				}
			} else if (eStructuralFeature instanceof EReference) {
				if (eStructuralFeature.getUpperBound() == 1) {
					EObject eObject2 = (EObject) eGet;
					if (eObject2 != null) {
						if (eObject2 instanceof WrappedValue || eObject2 instanceof IfcGloballyUniqueId) {
							EObject referenceEObject = (EObject) eGet;
							dataObject.addField(eStructuralFeature.getName(), new SimpleDataValue(referenceEObject.eGet(referenceEObject.eClass().getEStructuralFeature(
									"wrappedValue"))));
						} else {
							Long oid = mapResult.inverse().get(eObject2);
							String guid = getGuid(eObject2);
							dataObject.addField(eStructuralFeature.getName(), new ReferenceDataValue(eObject2.eClass().getName(), oid, guid));
						}
					} else {
						dataObject.addField(eStructuralFeature.getName(), null);
					}
				} else {
					EList<? extends EObject> list = (EList<EObject>) eGet;
					for (EObject item : list) {
						ListDataValue dataValue = new ListDataValue();
						dataObject.addField(eStructuralFeature.getName(), dataValue);
						if (item instanceof WrappedValue || item instanceof IfcGloballyUniqueId) {
							EObject referenceEObject = (EObject) item;
							dataValue.addValue(referenceEObject.eGet(referenceEObject.eClass().getEStructuralFeature("wrappedValue")));
						} else {
							Long oid = mapResult.inverse().get(item);
							String guid = getGuid(item);
							dataValue.addValue(item.eClass().getName(), oid, guid);
						}
					}
				}
			}
		}
	}

	private static String getGuid(EObject eObject2) {
		String guid = null;
		if (Ifc2x3Package.eINSTANCE.getIfcRoot().isSuperTypeOf(eObject2.eClass())) {
			EObject guidObject = (EObject) eObject2.eGet(eObject2.eClass().getEStructuralFeature("GlobalId"));
			if (guidObject != null) {
				guid = (String) guidObject.eGet(guidObject.eClass().getEStructuralFeature("wrappedValue"));
			}
		}
		return guid;
	}
}