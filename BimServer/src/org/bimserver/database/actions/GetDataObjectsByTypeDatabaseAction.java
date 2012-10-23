package org.bimserver.database.actions;

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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class GetDataObjectsByTypeDatabaseAction extends BimDatabaseAction<List<DataObject>> {

	private final String className;
	private final long roid;
	private final BimServer bimServer;
	private Authorization authorization;

	public GetDataObjectsByTypeDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, String className, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
		this.className = className;
		this.authorization = authorization;
	}

	@Override
	public List<DataObject> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		EClass eClass = getDatabaseSession().getEClassForName(className);
		Revision virtualRevision = getVirtualRevision(roid);
		if (virtualRevision == null) {
			throw new UserException("No revision with roid " + roid + " found");
		}
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			IfcModelInterface subModel = getDatabaseSession().getAllOfType(className, concreteRevision.getProject().getId(), concreteRevision.getId(), false, null);
			subModel.setDate(concreteRevision.getDate());
			ifcModelSet.add(subModel);
		}
		long s = System.nanoTime();
		IfcModelInterface ifcModel;
		try {
			ifcModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), authorization.getUoid()).merge(virtualRevision.getProject(), ifcModelSet, new ModelHelper());
		} catch (MergeException e) {
			throw new UserException(e);
		}
		System.out.println(((System.nanoTime() - s) / 1000000) + " ms merge");
		List<DataObject> dataObjects = new ArrayList<DataObject>();
		for (Long oid : ifcModel.keySet()) {
			EObject eObject = ifcModel.get(oid);
			if (eClass.isInstance(eObject)) {
				DataObject dataObject = StoreFactory.eINSTANCE.createDataObject();
				if (eObject instanceof IfcRoot) {
					IfcRoot ifcRoot = (IfcRoot)eObject;
					String guid = ifcRoot.getGlobalId() != null ? ifcRoot.getGlobalId().getWrappedValue() : "";
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
					dataObject.setGuid("");
					dataObject.setName("");
				}
				GetDataObjectByOidDatabaseAction.fillDataObject(ifcModel.getMap(), eObject, dataObject);
				dataObjects.add(dataObject);
			}
		}
		return dataObjects;
	}
}