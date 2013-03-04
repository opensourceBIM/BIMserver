package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.ListDataValue;
import org.bimserver.models.store.ReferenceDataValue;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SimpleDataValue;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.google.common.base.Charsets;
import com.google.common.collect.BiMap;

public class GetDataObjectByOidDatabaseAction extends AbstractDownloadDatabaseAction<DataObject> {

	private final long oid;
	private final long roid;
	private final BimServer bimServer;

	public GetDataObjectByOidDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, long oid, Authorization authorization) {
		super(databaseSession, accessMethod, authorization);
		this.bimServer = bimServer;
		this.roid = roid;
		this.oid = oid;
	}

	@Override
	public DataObject execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision virtualRevision = getRevisionByRoid(roid);
		EObject eObject = null;
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			IfcModel subModel = new IfcModel();
			int highestStopId = findHighestStopRid(concreteRevision.getProject(), concreteRevision);
			Query query = new Query(concreteRevision.getProject().getId(), concreteRevision.getId(), null, Deep.NO, highestStopId);
			eObject = getDatabaseSession().get(null, oid, subModel, query);
			subModel.getModelMetaData().setDate(concreteRevision.getDate());
			ifcModelSet.add(subModel);
			if (eObject != null) {
				break;
			}
		}
		IfcModelInterface ifcModel;
		try {
			ifcModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(virtualRevision.getProject(), ifcModelSet, new ModelHelper());
		} catch (MergeException e) {
			throw new UserException(e);
		}
		if (eObject == null) {
			throw new UserException("Object not found in this project/revision");
		}
		DataObject dataObject = null;
		if (eObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot) eObject;
			String guid = ifcRoot.getGlobalId() != null ? ifcRoot.getGlobalId() : "";
			String name = ifcRoot.getName() != null ? ifcRoot.getName() : "";
			dataObject = StoreFactory.eINSTANCE.createDataObject();
			dataObject.setType(eObject.eClass().getName());
			((IdEObjectImpl)dataObject).setOid(oid);
			dataObject.setGuid(guid);
			dataObject.setName(name);
		} else {
			dataObject = StoreFactory.eINSTANCE.createDataObject();
			dataObject.setType(eObject.eClass().getName());
			((IdEObjectImpl)dataObject).setOid(oid);
			dataObject.setName("");
			dataObject.setGuid("");
		}
		fillDataObject(ifcModel.getObjects(), eObject, dataObject);
		return dataObject;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void fillDataObject(BiMap<? extends Long, ? extends EObject> mapResult, EObject eObject, DataObject dataObject) {
		for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
			Object eGet = eObject.eGet(eStructuralFeature);
			if (eStructuralFeature.getEAnnotation("hidden") == null) {
				if (eStructuralFeature instanceof EAttribute) {
					if (eStructuralFeature.isMany()) {
						ListDataValue listDataValue = StoreFactory.eINSTANCE.createListDataValue();
						listDataValue.setFieldName(eStructuralFeature.getName());
						dataObject.getValues().add(listDataValue);
						if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
							EStructuralFeature asStringFeature = eObject.eClass().getEStructuralFeature(eStructuralFeature.getName() + "AsString");
							List list = (List) eObject.eGet(asStringFeature);
							for (Object o : list) {
								SimpleDataValue dataValue = StoreFactory.eINSTANCE.createSimpleDataValue();
								dataValue.setStringValue(o.toString());
								listDataValue.getValues().add(dataValue);
							}
						} else {
							List list = (List)eGet;
							for (Object o : list) {
								SimpleDataValue dataValue = StoreFactory.eINSTANCE.createSimpleDataValue();
								if (eGet != null) {
									dataValue.setStringValue(o.toString());
								} else {
									dataValue.setStringValue(null);
								}
								listDataValue.getValues().add(dataValue);
							}
						}
					} else {
						SimpleDataValue dataValue = StoreFactory.eINSTANCE.createSimpleDataValue();
						if (eGet != null) {
							if (eGet instanceof byte[]) {
								dataValue.setStringValue(new String(((byte[])eGet), Charsets.UTF_8));
							} else {
								dataValue.setStringValue(eGet.toString());
							}
						} else {
							dataValue.setStringValue(null);
						}
						dataValue.setFieldName(eStructuralFeature.getName());
						dataObject.getValues().add(dataValue);
					}
				} else if (eStructuralFeature instanceof EReference) {
					if (eStructuralFeature.isMany()) {
						if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
							List list = (List)eObject.eGet(eObject.eClass().getEStructuralFeature(eStructuralFeature.getName() + "AsString"));
							ListDataValue dataValue = StoreFactory.eINSTANCE.createListDataValue();
							dataValue.setFieldName(eStructuralFeature.getName());
							dataObject.getValues().add(dataValue);
							for (Object o : list) {
								SimpleDataValue simpleDataValue = StoreFactory.eINSTANCE.createSimpleDataValue();
								simpleDataValue.setStringValue(o.toString());
								dataValue.getValues().add(simpleDataValue);
							}
						} else {
							EList<? extends EObject> list = (EList<EObject>) eGet;
							ListDataValue dataValue = StoreFactory.eINSTANCE.createListDataValue();
							dataObject.getValues().add(dataValue);
							dataValue.setFieldName(eStructuralFeature.getName());
							for (EObject item : list) {
								if (item.eClass().getEAnnotation("wrapped") != null) {
									EObject referenceEObject = (EObject) item;
									SimpleDataValue simpleDataValue = StoreFactory.eINSTANCE.createSimpleDataValue();
									simpleDataValue.setStringValue(referenceEObject.eGet(referenceEObject.eClass().getEStructuralFeature("wrappedValue")).toString());
									dataValue.getValues().add(simpleDataValue);
								} else {
									Long oid = ((IdEObject)item).getOid();
									ReferenceDataValue referenceDataValue = StoreFactory.eINSTANCE.createReferenceDataValue();
									if (item instanceof IfcRoot) {
										IfcRoot ifcRoot = (IfcRoot)item;
										String guid = ifcRoot.getGlobalId();
										referenceDataValue.setGuid(guid);
									}
									referenceDataValue.setTypeName(item.eClass().getName());
									((IdEObjectImpl)referenceDataValue).setOid(oid);
									dataValue.getValues().add(referenceDataValue);
								}
							}
						}
					} else {
						EObject eObject2 = (EObject) eGet;
						if (eObject2 != null) {
							if (eObject2.eClass().getEAnnotation("wrapped") != null) {
								EObject referenceEObject = (EObject) eGet;
								SimpleDataValue e = StoreFactory.eINSTANCE.createSimpleDataValue();
								EStructuralFeature wrappedValueFeature = referenceEObject.eClass().getEStructuralFeature("wrappedValue");
								Object eGet2 = referenceEObject.eGet(wrappedValueFeature);
	//							if (wrappedValueFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject() || wrappedValueFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
	//								e.setStringValue((String)referenceEObject.eGet(referenceEObject.eClass().getEStructuralFeature("wrappedValueAsString")));
	//							} else {
									if (eGet2 != null) {
										e.setStringValue(eGet2.toString());
									} else {
										e.setStringValue(null);
									}
	//							}
								e.setFieldName(eStructuralFeature.getName());
								dataObject.getValues().add(e);
							} else {
								Long oid = ((IdEObject)eObject2).getOid();
								ReferenceDataValue reference = StoreFactory.eINSTANCE.createReferenceDataValue();
								if (eObject2 instanceof IfcRoot) {
									IfcRoot ifcRoot = (IfcRoot)eObject2;
									String guid = ifcRoot.getGlobalId();
									reference.setGuid(guid);
								}
								reference.setTypeName(eObject2.eClass().getName());
								((IdEObjectImpl)reference).setOid(oid);
								reference.setFieldName(eStructuralFeature.getName());
								dataObject.getValues().add(reference);
							}
						}
					}
				}
			}
		}
	}
}