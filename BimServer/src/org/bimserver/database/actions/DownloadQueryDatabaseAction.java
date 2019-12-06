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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.OidProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.QueryEnginePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.queryengine.QueryEngine;
import org.bimserver.plugins.queryengine.QueryEngineException;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EClass;

public class DownloadQueryDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private final long qeid;
	private final String code;
	private final long roid;
	private long serializerOid;

	public DownloadQueryDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, long qeid, long serializerOid, String code, Authorization authorization) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.roid = roid;
		this.qeid = qeid;
		this.serializerOid = serializerOid;
		this.code = code;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			SerializerPluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), serializerOid, OldQuery.getDefault());
			BimDatabaseAction<IfcModelInterface> action = new DownloadDatabaseAction(getBimServer(), session, AccessMethod.INTERNAL, roid, -1, serializerPluginConfiguration.getOid(), getAuthorization());
			IfcModelInterface ifcModel = session.executeAndCommitAction(action);
			QueryEnginePluginConfiguration queryEngineObject = session.get(StorePackage.eINSTANCE.getQueryEnginePluginConfiguration(), qeid, OldQuery.getDefault());
			Revision revision = session.get(roid, OldQuery.getDefault());
			PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
			
			if (queryEngineObject != null) {
				QueryEnginePlugin queryEnginePlugin = getBimServer().getPluginManager().getQueryEngine(queryEngineObject.getPluginDescriptor().getPluginClassName(), true);
				if (queryEnginePlugin != null) {
					QueryEngine queryEngine = queryEnginePlugin.getQueryEngine(getBimServer().getPluginSettingsCache().getPluginSettings(queryEngineObject.getOid()));
					final IfcModelInterface result = getDatabaseSession().createServerModel(packageMetaData, null);
					ModelHelper modelHelper = new ModelHelper(getBimServer().getMetaDataManager(), result);
					modelHelper.setOidProvider(new OidProvider(){
						private long oid = 1000000;
						@Override
						public long newOid(EClass eClass) {
							return oid++;
						}});
					IfcModelInterface finalResult = queryEngine.query(ifcModel, code, new Reporter(){
						@Override
						public void error(Throwable error) {
						}

						@Override
						public void warning(String warning) {
						}

						@Override
						public void info(String info) {
						}}, modelHelper);
					return finalResult;
				} else {
					throw new UserException("No Query Engine found " + queryEngineObject.getPluginDescriptor().getPluginClassName());
				}
			} else {
				throw new UserException("No configured query engine found with qeid " + qeid);
			}
		} catch (BimserverDatabaseException e) {
			throw new UserException(e);
		} catch (QueryEngineException e) {
			throw new UserException(e);
		} catch (PluginException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
	}
}