package org.bimserver.database.actions;

import java.io.IOException;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

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
		PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
		if (packageMetaData == null) {
			throw new UserException("Schema not fond");
		}
		try {
			Query query = new Query("test", packageMetaData);
			QueryPart queryPart = query.createQueryPart();
			queryPart.addType(packageMetaData.getEClassIncludingDependencies("GeometryInfo"), true);
			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), bimServer, query, java.util.Collections.singleton(roid), packageMetaData);
			HashMapVirtualObject next = queryObjectProvider.next();
			long totalPrimitives = 0;
			while (next != null) {
				int nrPrimitives = (int) next.get("primitiveCount");
				totalPrimitives += nrPrimitives;
				next = queryObjectProvider.next();
			}
			return totalPrimitives;
		} catch (QueryException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
