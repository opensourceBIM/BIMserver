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

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.QueryEnginePluginConfiguration;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.queryengine.QueryEngineException;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;

public class DownloadQueryDatabaseAction extends BimDatabaseAction<IfcModelInterface> {

	private final BimServer bimServer;
	private final ObjectIDM objectIDM;
	private final long qeid;
	private final String code;
	private final long roid;
	private final Reporter reporter;
	private Authorization authorization;
	private long serializerOid;

	public DownloadQueryDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, long qeid, long serializerOid, String code, Authorization authorization, ObjectIDM objectIDM, Reporter reporter) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
		this.qeid = qeid;
		this.serializerOid = serializerOid;
		this.code = code;
		this.authorization = authorization;
		this.objectIDM = objectIDM;
		this.reporter = reporter;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SerializerPluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), SerializerPluginConfiguration.class, serializerOid);
			BimDatabaseAction<IfcModelInterface> action = new DownloadDatabaseAction(bimServer, session, AccessMethod.INTERNAL, roid, -1, serializerPluginConfiguration.getOid(), authorization, null, reporter);
			IfcModelInterface ifcModel = session.executeAndCommitAction(action);
			QueryEnginePluginConfiguration queryEngineObject = session.get(StorePackage.eINSTANCE.getQueryEnginePluginConfiguration(), qeid, false, null);
			if (queryEngineObject != null) {
				QueryEnginePlugin queryEnginePlugin = bimServer.getPluginManager().getQueryEngine(queryEngineObject.getClassName(), true);
				if (queryEnginePlugin != null) {
					org.bimserver.plugins.queryengine.QueryEngine queryEngine = queryEnginePlugin.getQueryEngine();
					return queryEngine.query(ifcModel, code, reporter, new ModelHelper(objectIDM));
				} else {
					throw new UserException("No Query Engine found " + queryEngineObject.getClassName());
				}
			} else {
				throw new UserException("No configured query engine found with qeid " + qeid);
			}
		} catch (BimserverDatabaseException e) {
			throw new UserException(e);
		} catch (QueryEngineException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
	}
}