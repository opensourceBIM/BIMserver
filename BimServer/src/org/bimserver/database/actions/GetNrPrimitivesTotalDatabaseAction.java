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

import java.io.IOException;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GetNrPrimitivesTotalDatabaseAction extends BimDatabaseAction<Long> {

	private BimServer bimServer;
	private Set<Long> roids;

	public GetNrPrimitivesTotalDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roids = roids;
	}

	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
//		Revision revision = getDatabaseSession().get(roids.iterator().next(), OldQuery.getDefault());
//		PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
//		if (packageMetaData == null) {
//			throw new UserException("Schema not fond");
//		}
//		Query query = new Query("test", packageMetaData);
//		QueryPart queryPart = query.createQueryPart();
//		queryPart.addType(packageMetaData.getEClassIncludingDependencies("GeometryInfo"), true);
//		QueryObjectProvider queryObjectProvider;
//		long totalPrimitives = 0;
//		try {
//			queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), bimServer, query, roids, packageMetaData);
//			HashMapVirtualObject next = queryObjectProvider.next();
//			while (next != null) {
//				int nrPrimitives = (int) next.get("primitiveCount");
//				totalPrimitives += nrPrimitives;
//				next = queryObjectProvider.next();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (QueryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return totalPrimitives;
		

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			long totalPrimitives = 0;
			
			for (long roid : roids) {
				Revision revision = getDatabaseSession().get(roid, OldQuery.getDefault());
				for (ExtendedData extendedData : revision.getExtendedData()) {
					// TODO ugly
					if (extendedData.getTitle().equals("Geometry generation report (application/json)") || extendedData.getTitle().equals("Geometry generation report (json)")) {
						ObjectNode generationReport = objectMapper.readValue(extendedData.getFile().getData(), ObjectNode.class);
						totalPrimitives += generationReport.get("ifcModel").get("triangles").asLong();
					}
				}
			}
			
			return totalPrimitives;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
