package org.bimserver.database.actions;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.SummaryMap;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OidCounters;
import org.bimserver.database.OldQuery;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.SpecialQueryType;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloneToNewProjectDatabaseAction extends GenericCheckinDatabaseAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(CloneToNewProjectDatabaseAction.class);
	private final Long roid;
	private final String projectName;
	private final String comment;
	private Authorization authorization;
	private Project newProject;

	public CloneToNewProjectDatabaseAction(DatabaseSession session, AccessMethod accessMethod, BimServer bimServer, Authorization authorization, Long roid, String projectName,
			String comment) {
		super(bimServer, session, accessMethod);
		this.authorization = authorization;
		this.roid = roid;
		this.projectName = projectName;
		this.comment = comment;
	}
	
	@Override
	public ConcreteRevision execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision oldRevision = getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
		Project oldProject = oldRevision.getProject();
		final User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), OldQuery.getDefault());
		if (!authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		if (oldRevision.getConcreteRevisions().size() != 1) {
			throw new UserException("This method can only be used on Revisions that contain just one ConcreteRevision");
		}
		PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(oldProject.getSchema());
		newProject = new AddProjectDatabaseAction(getBimServer(), getDatabaseSession(), getAccessMethod(), projectName, packageMetaData.getSchema().getEPackageName(), authorization).execute();
		
		ConcreteRevision oldConcreteRevision = oldRevision.getConcreteRevisions().get(0);
		SummaryMap summaryMap = new SummaryMap(packageMetaData, oldConcreteRevision.getSummary());
		
		Query query = new Query(packageMetaData);
		query.setSpecialQueryType(SpecialQueryType.ALL);
		CreateRevisionResult result = createNewConcreteRevision(getDatabaseSession(), oldRevision.getSize(), newProject, user, comment.trim());
		ConcreteRevision newConcreteRevision = result.getConcreteRevision();
		QueryContext newQueryContext = new QueryContext(getDatabaseSession(), packageMetaData, newProject.getId(), result.getRevisions().get(0).getId(), roid, newConcreteRevision.getOid(), -1);

		newConcreteRevision.setSummary(summaryMap.toRevisionSummary(getDatabaseSession()));
		newConcreteRevision.setOidCounters(new OidCounters(getDatabaseSession(), oldConcreteRevision.getOidCounters()).getBytes());
		newConcreteRevision.setIfcHeader(oldConcreteRevision.getIfcHeader());
		
		newConcreteRevision.setMultiplierToMm(oldConcreteRevision.getMultiplierToMm());
		newConcreteRevision.setBounds(oldConcreteRevision.getBounds());
		newConcreteRevision.setBoundsUntransformed(oldConcreteRevision.getBoundsUntransformed());
		
		try {
			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), getBimServer(), query, Collections.singleton(roid), packageMetaData);
			HashMapVirtualObject next = queryObjectProvider.next();
			
			// Phase 1, copy all objects
			Map<Long, Long> oldOidToNew = new HashMap<>();
			while (next != null) {
				long oldOid = next.getOid();
				next.prepareForCopy(newQueryContext);
				Long newOid = getOrCreateOid(oldOidToNew, next.getReusable(), oldOid);
				next.setOid(newOid);
				
				for (EReference eReference : next.eClass().getEAllReferences()) {
					if (eReference.isMany()) {
						List<Object> list = (List<Object>) next.get(eReference.getName());
						if (list != null) {
							for (int i=0; i<list.size(); i++) {
								Object object = list.get(i);
								if (object instanceof Long) {
									long refOid = (long)object;
									Long newRefOid = getOrCreateOid(oldOidToNew, next.getReusable(), refOid);
									list.set(i, newRefOid);
								}
							}
						}
					} else {
						Object object = next.eGet(eReference);
						if (object != null) {
							if (object instanceof Long) {
								long refOid = (long) object;
								long newRefOid = getOrCreateOid(oldOidToNew, next.getReusable(), refOid);
								next.set(eReference.getName(), newRefOid);
							}
						}
					}
				}
				
				next.save();
				next = queryObjectProvider.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (QueryException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private long getOrCreateOid(Map<Long, Long> map, QueryContext queryContext, long oldOid) throws BimserverDatabaseException {
		Long newOid = map.get(oldOid);
		if (newOid == null) {
			newOid = queryContext.getDatabaseInterface().newOid(queryContext.getDatabaseInterface().getEClassForOid(oldOid));
			map.put(oldOid, newOid);
		}
		return newOid;
	}

	public long getPoid() {
		return -1;
	}
}