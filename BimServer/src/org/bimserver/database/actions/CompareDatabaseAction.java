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
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.ModelComparePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.modelcompare.ModelCompareException;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.LoggerFactory;


public class CompareDatabaseAction extends BimDatabaseAction<CompareResult> {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CompareDatabaseAction.class);
	private final long roid1;
	private final long roid2;
	private final CompareType sCompareType;
	private final BimServer bimServer;
	private final long mcid;
	private Authorization authorization;
	private long serializerOid;

	public CompareDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long serializerOid, long roid1, long roid2,
			CompareType sCompareType, long mcid) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.serializerOid = serializerOid;
		this.roid1 = roid1;
		this.roid2 = roid2;
		this.sCompareType = sCompareType;
		this.mcid = mcid;
	}

	public org.bimserver.plugins.modelcompare.ModelCompare getModelCompare() throws ModelCompareException, BimserverDatabaseException {
		Revision revision1 = getDatabaseSession().get(roid1, OldQuery.getDefault());
		Revision revision2 = getDatabaseSession().get(roid2, OldQuery.getDefault());
		PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision1.getProject().getSchema());
		if (revision1.getProject().getSchema().equals(revision2.getProject().getSchema())) {
			ModelComparePluginConfiguration modelCompareObject = getDatabaseSession().get(StorePackage.eINSTANCE.getModelComparePluginConfiguration(), mcid, OldQuery.getDefault());
			if (modelCompareObject != null) {
				ModelComparePlugin modelComparePlugin = bimServer.getPluginManager().getModelComparePlugin(modelCompareObject.getPluginDescriptor().getPluginClassName(), true);
				if (modelComparePlugin != null) {
					org.bimserver.plugins.modelcompare.ModelCompare modelCompare = modelComparePlugin.createModelCompare(bimServer.getPluginSettingsCache().getPluginSettings(modelCompareObject.getOid()), packageMetaData);
					return modelCompare;
				} else {
					throw new ModelCompareException("No Model Compare found " + modelCompareObject.getPluginDescriptor().getPluginClassName());
				}
			} else {
				throw new ModelCompareException("No configured Model Compare found");
			}
		} else {
			throw new ModelCompareException("Not the same schema");
		}
	}

	@Override
	public CompareResult execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		CompareResult compareResults = null;// bimServer.getCompareCache().getCompareResults(roid1,
											// roid2, sCompareType,
											// sCompareIdentifier);
		if (compareResults == null) {
			IfcModelInterface model1 = new DownloadDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), roid1, -1, serializerOid, authorization).execute();
			try(DatabaseSession secondSession = bimServer.getDatabase().createSession(OperationType.READ_ONLY)){
				IfcModelInterface model2 = new DownloadDatabaseAction(bimServer, secondSession, getAccessMethod(), roid2, -1, serializerOid, authorization).execute();
				try {
					compareResults = getModelCompare().compare(model1, model2, sCompareType);
				} catch (ModelCompareException e) {
					LOGGER.error("", e);
					throw new UserException(e);
				}
				// bimServer.getCompareCache().storeResults(roid1, roid2, sCompareType, sCompareIdentifier, compareResults);
			}
		}
		return compareResults;
	}
}