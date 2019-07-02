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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.File;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GetNrPrimitivesDatabaseAction extends BimDatabaseAction<Long> {

	private Long roid;
	private BimServer bimServer;

	public GetNrPrimitivesDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Long roid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
	}

	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		Revision revision = getDatabaseSession().get(roid, OldQuery.getDefault());
		for (ExtendedData extendedData : revision.getExtendedData()) {
			if (extendedData.getSchema().getName().contentEquals("GEOMETRY_GENERATION_REPORT_JSON_1_1")) {
				File file = extendedData.getFile();
				try {
					ObjectNode report = new ObjectMapper().readValue(file.getData(), ObjectNode.class);
					return report.get("ifcModel").get("triangles").asLong();
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		return -1L;
//		PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
//		if (packageMetaData == null) {
//			throw new UserException("Schema not fond");
//		}
//		try {
//			Query query = new Query("test", packageMetaData);
//			QueryPart queryPart = query.createQueryPart();
//			queryPart.addType(packageMetaData.getEClassIncludingDependencies("GeometryInfo"), false);
//			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), bimServer, query, java.util.Collections.singleton(roid), packageMetaData);
//			HashMapVirtualObject next = queryObjectProvider.next();
//			long totalPrimitives = 0;
//			while (next != null) {
//				int nrPrimitives = (int) next.get("primitiveCount");
//				totalPrimitives += nrPrimitives;
//				next = queryObjectProvider.next();
//			}
//			return totalPrimitives;
//		} catch (QueryException e) {
//			e.printStackTrace();
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
	}
}
