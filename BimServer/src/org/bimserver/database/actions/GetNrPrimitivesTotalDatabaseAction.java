package org.bimserver.database.actions;

import java.io.IOException;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.HashMapVirtualObject;
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
