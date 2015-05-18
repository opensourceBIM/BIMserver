package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import org.bimserver.ServerIfcModel;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.OidProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.QueryEnginePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.objectidms.HideAllInversesObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.queryengine.QueryEngine;
import org.bimserver.plugins.queryengine.QueryEngineException;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EClass;

public class DownloadQueryDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private ObjectIDM objectIDM;
	private final long qeid;
	private final String code;
	private final long roid;
	private long serializerOid;

	public DownloadQueryDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, long qeid, long serializerOid, String code, Authorization authorization, ObjectIDM objectIDM) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.roid = roid;
		this.qeid = qeid;
		this.serializerOid = serializerOid;
		this.code = code;
		this.objectIDM = objectIDM;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SerializerPluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), serializerOid, Query.getDefault());
			BimDatabaseAction<IfcModelInterface> action = new DownloadDatabaseAction(getBimServer(), session, AccessMethod.INTERNAL, roid, -1, serializerPluginConfiguration.getOid(), getAuthorization(), null);
			IfcModelInterface ifcModel = session.executeAndCommitAction(action);
			QueryEnginePluginConfiguration queryEngineObject = session.get(StorePackage.eINSTANCE.getQueryEnginePluginConfiguration(), qeid, Query.getDefault());
			Revision revision = session.get(roid, Query.getDefault());
			PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
			
			if (objectIDM == null) {
				objectIDM = new HideAllInversesObjectIDM(CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), packageMetaData.getSchemaDefinition());
			}
			
			if (queryEngineObject != null) {
				QueryEnginePlugin queryEnginePlugin = getBimServer().getPluginManager().getQueryEngine(queryEngineObject.getPluginDescriptor().getPluginClassName(), true);
				if (queryEnginePlugin != null) {
					QueryEngine queryEngine = queryEnginePlugin.getQueryEngine(new PluginConfiguration(queryEngineObject.getSettings()));
					final IfcModelInterface result = new ServerIfcModel(packageMetaData, null, getDatabaseSession());
					ModelHelper modelHelper = new ModelHelper(getBimServer().getMetaDataManager(), objectIDM, result);
					modelHelper.setOidProvider(new OidProvider<Long>(){
						private long oid = 1000000;
						@Override
						public Long newOid(EClass eClass) {
							return oid++;
						}});
					IfcModelInterface finalResult = queryEngine.query(ifcModel, code, new Reporter(){
						@Override
						public void error(Exception error) {
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
		} finally {
			session.close();
		}
	}
}