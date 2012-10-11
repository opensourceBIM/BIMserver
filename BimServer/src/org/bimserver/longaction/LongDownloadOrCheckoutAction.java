package org.bimserver.longaction;

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

import javax.activation.DataHandler;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.IfcEnginePluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.EmfSerializerDataSource;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.IncrementingOidProvider;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongDownloadOrCheckoutAction extends LongAction<DownloadParameters> implements Reporter {
	protected static final Logger LOGGER = LoggerFactory.getLogger(LongDownloadAction.class);
	protected final AccessMethod accessMethod;
	protected final DownloadParameters downloadParameters;
	protected SCheckoutResult checkoutResult;

	protected LongDownloadOrCheckoutAction(BimServer bimServer, String username, String userUsername, DownloadParameters downloadParameters, AccessMethod accessMethod,
			Authorization authorization) {
		super(bimServer, username, userUsername, authorization);
		this.accessMethod = accessMethod;
		this.downloadParameters = downloadParameters;
	}

	public SCheckoutResult getCheckoutResult() {
		return checkoutResult;
	}

	protected SCheckoutResult convertModelToCheckoutResult(Project project, String username, IfcModelInterface model, IfcEngine ifcEngine, DownloadParameters downloadParameters)
			throws UserException, NoSerializerFoundException {
		SCheckoutResult checkoutResult = new SCheckoutResult();
		if (model.isValid()) {
			checkoutResult.setProjectName(project.getName());
			checkoutResult.setRevisionNr(model.getRevisionNr());
			try {
				model.fixOids(new IncrementingOidProvider(1L));
				
				org.bimserver.plugins.serializers.Serializer serializer = getBimServer().getEmfSerializerFactory().create(project, username, model, ifcEngine, downloadParameters);
				if (serializer == null) {
					throw new UserException("Error, no serializer found " + downloadParameters.getSerializerOid());
				}
				checkoutResult.setFile(new DataHandler(new EmfSerializerDataSource(serializer)));
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
		return checkoutResult;
	}

	protected void executeAction(BimDatabaseAction<? extends IfcModelInterface> action, DownloadParameters downloadParameters, DatabaseSession session, boolean commit)
			throws BimserverDatabaseException, UserException, NoSerializerFoundException {
		try {
			if (action == null) {
				checkoutResult = new SCheckoutResult();
				checkoutResult.setFile(new DataHandler(getBimServer().getDiskCacheManager().get(downloadParameters)));
			} else {
				Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), false, null);
				revision.getProject().getGeoTag().load(); // Little hack to make
															// sure this is
															// lazily loaded,
															// because after the
															// executeAndCommitAction
															// the session won't
															// be usable
				IfcModelInterface ifcModel = session.executeAndCommitAction(action);
				// Session is closed after this

				DatabaseSession newSession = getBimServer().getDatabase().createSession();
				IfcEnginePlugin ifcEnginePlugin = null;
				try {
					SerializerPluginConfiguration serializerPluginConfiguration = newSession.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), downloadParameters.getSerializerOid(), false, null);
					if (serializerPluginConfiguration != null) {
						IfcEnginePluginConfiguration ifcEngine = serializerPluginConfiguration.getIfcEngine();
						if (ifcEngine != null) {
							ifcEnginePlugin = (IfcEnginePlugin) getBimServer().getPluginManager().getIfcEngine(ifcEngine.getClassName(), true);
						}
					}
				} catch (BimserverDatabaseException e) {
					LOGGER.error("", e);
				} finally {
					newSession.close();
				}

				IfcEngine ifcEngine = null;
				if (ifcEnginePlugin != null) {
					try {
						ifcEngine = ifcEnginePlugin.createIfcEngine();
					} catch (IfcEngineException e) {
						LOGGER.error("", e);
					}
				}

				checkoutResult = convertModelToCheckoutResult(revision.getProject(), getUserName(), ifcModel, ifcEngine, downloadParameters);
				if (checkoutResult != null) {
					getBimServer().getDiskCacheManager().store(downloadParameters, checkoutResult.getFile());
				}
			}
		} finally {
			done();
		}
	}
}