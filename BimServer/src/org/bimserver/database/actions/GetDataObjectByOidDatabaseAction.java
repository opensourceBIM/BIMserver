package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDataValue;
import org.bimserver.interfaces.objects.SListDataValue;
import org.bimserver.interfaces.objects.SReferenceDataValue;
import org.bimserver.interfaces.objects.SSimpleDataValue;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.models.ifc2x3.WrappedValue;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.exceptions.UserException;
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
			eObject = getDatabaseSession().get(cid, oid, concreteRevision.getProject().getId(), concreteRevision.getId(), subModel, false, null);
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
			dataObject = new SDataObject();
			dataObject.setType(eObject.eClass().getName());
			dataObject.setOid(oid);
			dataObject.setGuid(guid);
			dataObject.setName(name);
		} else {
			dataObject = new SDataObject();
			dataObject.setType(eObject.eClass().getName());
			dataObject.setOid(oid);
			dataObject.setName("");
			dataObject.setGuid("");
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
					SSimpleDataValue dataValue = new SSimpleDataValue();
					if (eGet instanceof String) {
						dataValue.setStringValue((String) eGet);
					} else if (eGet != null) {
						dataValue.setStringValue(eGet.toString());
					} else {
						dataValue.setStringValue("");
					}
					dataValue.setFieldName(eStructuralFeature.getName());
					dataObject.getValues().add(dataValue);
				}
			} else if (eStructuralFeature instanceof EReference) {
				if (eStructuralFeature.getUpperBound() == 1) {
					EObject eObject2 = (EObject) eGet;
					if (eObject2 != null) {
						if (eObject2 instanceof WrappedValue || eObject2 instanceof IfcGloballyUniqueId) {
							EObject referenceEObject = (EObject) eGet;
							SSimpleDataValue e = new SSimpleDataValue();
							Object eGet2 = referenceEObject.eGet(referenceEObject.eClass().getEStructuralFeature("wrappedValue"));
							if (eGet2 instanceof String) {
								e.setStringValue((String) eGet2);
							} else if (eGet2 != null) {
								e.setStringValue(eGet2.toString());
							} else {
								e.setStringValue("");
							}
							e.setFieldName(eStructuralFeature.getName());
							dataObject.getValues().add(e);
						} else {
							Long oid = mapResult.inverse().get(eObject2);
							String guid = getGuid(eObject2);
							SReferenceDataValue reference = new SReferenceDataValue();
							reference.setTypeName(eObject2.eClass().getName());
							reference.setOid(oid);
							reference.setGuid(guid);
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
						SListDataValue dataValue = new SListDataValue();
						dataValue.setFieldName(eStructuralFeature.getName());
						dataObject.getValues().add(dataValue);
						if (item instanceof WrappedValue || item instanceof IfcGloballyUniqueId) {
							EObject referenceEObject = (EObject) item;
							SSimpleDataValue simpleDataValue = new SSimpleDataValue();
							simpleDataValue.setStringValue(referenceEObject.eGet(referenceEObject.eClass().getEStructuralFeature("wrappedValue")).toString());
							dataValue.getValues().add(simpleDataValue);
						} else {
							Long oid = mapResult.inverse().get(item);
							String guid = getGuid(item);
							SReferenceDataValue referenceDataValue = new SReferenceDataValue();
							referenceDataValue.setTypeName(item.eClass().getName());
							referenceDataValue.setOid(oid);
							referenceDataValue.setGuid(guid);
							dataValue.getValues().add(referenceDataValue);
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