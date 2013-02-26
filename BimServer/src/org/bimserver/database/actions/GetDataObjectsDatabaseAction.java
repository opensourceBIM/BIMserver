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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcModel;
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
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EObject;

public class GetDataObjectsDatabaseAction extends AbstractDownloadDatabaseAction<List<DataObject>> {

	private final long roid;
	private final BimServer bimServer;

	public GetDataObjectsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, long roid, Authorization authorization) {
		super(databaseSession, accessMethod, authorization);
		this.bimServer = bimServer;
		this.roid = roid;
	}

	@Override
	public List<DataObject> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision virtualRevision = getRevisionByRoid(roid);
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			int highestStopId = findHighestStopRid(concreteRevision.getProject(), concreteRevision);
			IfcModel subModel = new IfcModel();
			Query query = new Query(concreteRevision.getProject().getId(), concreteRevision.getId(), null, Deep.YES, highestStopId);
			getDatabaseSession().getMap(subModel, query);
			subModel.getModelMetaData().setDate(concreteRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModelInterface ifcModel;
		try {
			ifcModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(virtualRevision.getProject(), ifcModelSet, new ModelHelper());
		} catch (MergeException e) {
			throw new UserException(e);
		}
		List<DataObject> dataObjects = new ArrayList<DataObject>();
		for (Long oid : ifcModel.keySet()) {
			EObject eObject = ifcModel.get(oid);
			if (eObject.eClass().getEAnnotation("hidden") == null) {
				DataObject dataObject = null;
				if (eObject instanceof IfcRoot) {
					IfcRoot ifcRoot = (IfcRoot)eObject;
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
					dataObject.setGuid("");
					dataObject.setName("");
				}
				GetDataObjectByOidDatabaseAction.fillDataObject(ifcModel.getObjects(), eObject, dataObject);
				dataObjects.add(dataObject);
			}
		}
		return dataObjects;
	}
}