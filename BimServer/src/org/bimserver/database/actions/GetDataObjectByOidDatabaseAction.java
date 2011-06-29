package org.bimserver.database.actions;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.models.ifc2x3.WrappedValue;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.SDataObject;
import org.bimserver.shared.SDataObject.SDataValue;
import org.bimserver.shared.SDataObject.SListDataValue;
import org.bimserver.shared.SDataObject.SReferenceDataValue;
import org.bimserver.shared.SDataObject.SSimpleDataValue;
import org.bimserver.shared.UserException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.BiMap;

public class GetDataObjectByOidDatabaseAction extends BimDatabaseAction<SDataObject> {

	private final long oid;
	private final short cid;
	private final long roid;
	private final BimServer bimServer;

	public GetDataObjectByOidDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid, long oid, short cid) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
		this.oid = oid;
		this.cid = cid;
	}

	@Override
	public SDataObject execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision virtualRevision = getVirtualRevision(roid);
		EObject eObject = null;
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			IfcModel subModel = new IfcModel();
			eObject = getDatabaseSession().get(cid, oid, concreteRevision.getProject().getId(), concreteRevision.getId(), subModel, false);
			subModel.setDate(concreteRevision.getDate());
			ifcModelSet.add(subModel);
			if (eObject != null) {
				break;
			}
		}
		IfcModelInterface ifcModel = bimServer.getMergerFactory().createMerger().merge(virtualRevision.getProject(), ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
		if (eObject == null) {
			throw new UserException("Object not found in this project/revision");
		}
		SDataObject dataObject = null;
		if (eObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot) eObject;
			String guid = ifcRoot.getGlobalId() != null ? ifcRoot.getGlobalId().getWrappedValue() : "";
			String name = ifcRoot.getName() != null ? ifcRoot.getName() : "";
			dataObject = new SDataObject(eObject.eClass().getName(), oid, guid, name);
		} else {
			dataObject = new SDataObject(eObject.eClass().getName(), oid, "", "");
		}
		fillDataObject(ifcModel.getMap(), eObject, dataObject);
		return dataObject;
	}

	@SuppressWarnings("unchecked")
	public static void fillDataObject(BiMap<? extends Long, ? extends EObject> mapResult, EObject eObject, SDataObject dataObject) {
		for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
			Object eGet = eObject.eGet(eStructuralFeature);
			if (eStructuralFeature instanceof EAttribute) {
				if (!eStructuralFeature.getName().endsWith("AsString")) {
					SSimpleDataValue dataValue = new SSimpleDataValue(eGet);
					dataValue.setFieldName(eStructuralFeature.getName());
					dataObject.getValues().add(dataValue);
				}
			} else if (eStructuralFeature instanceof EReference) {
				if (eStructuralFeature.getUpperBound() == 1) {
					EObject eObject2 = (EObject) eGet;
					if (eObject2 != null) {
						if (eObject2 instanceof WrappedValue || eObject2 instanceof IfcGloballyUniqueId) {
							EObject referenceEObject = (EObject) eGet;
							SSimpleDataValue e = new SSimpleDataValue(referenceEObject.eGet(referenceEObject.eClass().getEStructuralFeature(
									"wrappedValue")));
							e.setFieldName(eStructuralFeature.getName());
							dataObject.getValues().add(e);
						} else {
							Long oid = mapResult.inverse().get(eObject2);
							String guid = getGuid(eObject2);
							SReferenceDataValue reference = new SReferenceDataValue(eObject2.eClass().getName(), oid, guid);
							reference.setFieldName(eStructuralFeature.getName());
							dataObject.getValues().add(reference);
						}
					} else {
						SDataValue empty = new SDataValue();
						empty.setFieldName(eStructuralFeature.getName());
						dataObject.getValues().add(empty);
					}
				} else {
					EList<? extends EObject> list = (EList<EObject>) eGet;
					for (EObject item : list) {
						SListDataValue dataValue = new SListDataValue(eStructuralFeature.getName());
						dataValue.setFieldName(eStructuralFeature.getName());
						dataObject.getValues().add(dataValue);
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