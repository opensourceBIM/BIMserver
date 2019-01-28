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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class DownloadByNewQueryDatabaseAction extends BimDatabaseAction<ObjectProvider> {
	
	private Authorization authorization;
	private Set<Long> roids;
	private String json;
	private BimServer bimServer;

	public DownloadByNewQueryDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, String json, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roids = roids;
		this.json = json;
		this.authorization = authorization;
	}

	@Override
	public ObjectProvider execute()	throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		User user = getUserByUoid(authorization.getUoid());
		Project project = null;
		Map<Integer, Long> pidRoidMap = new HashMap<>();
		
		for (Long roid : roids) {
			Revision virtualRevision = getRevisionByRoid(roid);
			pidRoidMap.put(virtualRevision.getProject().getId(), virtualRevision.getOid());
			project = virtualRevision.getProject();
			try {
				authorization.canDownload(roid);
			} catch (UserException e) {
				if (!authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
					throw new UserException("User has insufficient rights to download revisions from this project");
				}
				if (!authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
					throw new UserException("User has insufficient rights to download revisions from this project");
				}
			}
		}

		PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(project.getSchema());

		try {
			return QueryObjectProvider.fromJsonString(getDatabaseSession(), bimServer, json, roids, packageMetaData);
		} catch (Exception e) {
			throw new UserException(e);
		}
	}
}