package org.bimserver.database.actions;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OldQuery.Deep;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class GetDataObjectsByTypeDatabaseAction extends AbstractDownloadDatabaseAction<List<DataObject>> {

	private final String className;
	private final long roid;
	private boolean flat;
	private String packageName;

	public GetDataObjectsByTypeDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, String packageName, String className, Authorization authorization, boolean flat) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.roid = roid;
		this.packageName = packageName;
		this.className = className;
		this.flat = flat;
	}

	@Override
	public List<DataObject> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		EClass eClass = getDatabaseSession().getEClassForName(packageName, className);
		Revision virtualRevision = getRevisionByRoid(roid);
		if (virtualRevision == null) {
			throw new UserException("No revision with roid " + roid + " found");
		}
		Map<Integer, Long> pidRoidMap = new HashMap<>();
		IfcModelSet ifcModelSet = new IfcModelSet();
		pidRoidMap.put(virtualRevision.getProject().getId(), virtualRevision.getOid());
		PackageMetaData lastPackageMetaData = null;
		Project project = virtualRevision.getProject();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
			int highestStopId = findHighestStopRid(project, concreteRevision);
			OldQuery query = new OldQuery(packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), -1, Deep.NO, highestStopId);
			lastPackageMetaData = packageMetaData;
			IfcModelInterface subModel = getDatabaseSession().getAllOfType(packageMetaData.getEPackage().getName(), className, query);
			subModel.getModelMetaData().setDate(concreteRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModelInterface ifcModel = getDatabaseSession().createServerModel(lastPackageMetaData, pidRoidMap);
		if (ifcModelSet.size() > 1) {
			try {
				ifcModel = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(project, ifcModelSet, new ModelHelper(getBimServer().getMetaDataManager(), ifcModel));
			} catch (MergeException e) {
				throw new UserException(e);
			}
		} else {
			ifcModel = ifcModelSet.iterator().next();
		}
		List<DataObject> dataObjects = new ArrayList<DataObject>();
		for (Long oid : new HashSet<>(ifcModel.keySet())) {
			EObject eObject = ifcModel.get(oid);
			if (eClass.isInstance(eObject)) {
				DataObject dataObject = StoreFactory.eINSTANCE.createDataObject();
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
				if (!flat) {
					GetDataObjectByOidDatabaseAction.fillDataObject(ifcModel.getObjects(), eObject, dataObject);
				}
				dataObjects.add(dataObject);
			}
		}
		return dataObjects;
	}
}