package org.bimserver.longaction;

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

import javax.activation.DataHandler;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.MessagingSerializerPluginConfiguration;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.CacheStoringEmfSerializerDataSource;
import org.bimserver.plugins.serializers.EmfSerializerDataSource;
import org.bimserver.plugins.serializers.MessagingSerializer;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongDownloadOrCheckoutAction extends LongAction<DownloadParameters> implements Reporter {
	protected static final Logger LOGGER = LoggerFactory.getLogger(LongDownloadAction.class);
	protected final AccessMethod accessMethod;
	protected final DownloadParameters downloadParameters;
	protected SCheckoutResult checkoutResult;
	protected MessagingSerializer messagingSerializer;

	protected LongDownloadOrCheckoutAction(BimServer bimServer, String username, String userUsername, DownloadParameters downloadParameters, AccessMethod accessMethod,
			Authorization authorization) {
		super(bimServer, username, userUsername, authorization);
		this.accessMethod = accessMethod;
		this.downloadParameters = downloadParameters;
	}

	public SCheckoutResult getCheckoutResult() {
		return checkoutResult;
	}

	protected SCheckoutResult convertModelToCheckoutResult(Project project, String username, IfcModelInterface model, RenderEnginePlugin renderEnginePlugin, DownloadParameters downloadParameters)
			throws UserException, NoSerializerFoundException {
		SCheckoutResult checkoutResult = new SCheckoutResult();
		if (model.isValid()) {
			checkoutResult.setProjectName(project.getName());
			checkoutResult.setRevisionNr(model.getModelMetaData().getRevisionId());
			try {
				Serializer serializer = getBimServer().getSerializerFactory().create(project, username, model, renderEnginePlugin, downloadParameters);
				if (serializer == null) {
					throw new UserException("Error, no serializer found " + downloadParameters.getSerializerOid());
				}
				if (getBimServer().getServerSettingsCache().getServerSettings().getCacheOutputFiles() && serializer.allowCaching()) {
					if (getBimServer().getDiskCacheManager().contains(downloadParameters)) {
						checkoutResult.setFile(new CachingDataHandler(getBimServer().getDiskCacheManager(), downloadParameters));
					} else {
						checkoutResult.setFile(new DataHandler(new CacheStoringEmfSerializerDataSource(serializer, getBimServer().getDiskCacheManager().startCaching(downloadParameters))));
					}
				} else {
					checkoutResult.setFile(new DataHandler(new EmfSerializerDataSource(serializer)));
				}
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
		return checkoutResult;
	}
	
	public MessagingSerializer getMessagingSerializer() {
		return messagingSerializer;
	}

	protected void executeAction(BimDatabaseAction<? extends IfcModelInterface> action, DownloadParameters downloadParameters, DatabaseSession session, boolean commit)
			throws BimserverDatabaseException, UserException, NoSerializerFoundException, ServerException {
		try {
			if (action == null) {
				checkoutResult = new SCheckoutResult();
				checkoutResult.setFile(new CachingDataHandler(getBimServer().getDiskCacheManager(), downloadParameters));
			} else {
				Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), Query.getDefault());
				if (revision == null) {
					throw new UserException("Revision with roid " + downloadParameters.getRoid() + " not found");
				}
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
				RenderEnginePlugin renderEnginePlugin = null;
				try {
					PluginConfiguration serializerPluginConfiguration = newSession.get(StorePackage.eINSTANCE.getPluginConfiguration(), downloadParameters.getSerializerOid(), Query.getDefault());
					if (serializerPluginConfiguration != null) {
						if (serializerPluginConfiguration instanceof SerializerPluginConfiguration) {
							RenderEnginePluginConfiguration renderEngine = ((SerializerPluginConfiguration)serializerPluginConfiguration).getRenderEngine();
							if (renderEngine != null) {
								renderEnginePlugin = getBimServer().getPluginManager().getRenderEngine(renderEngine.getPluginDescriptor().getPluginClassName(), true);
							}
							checkoutResult = convertModelToCheckoutResult(revision.getProject(), getUserName(), ifcModel, renderEnginePlugin, downloadParameters);
						} else if (serializerPluginConfiguration instanceof MessagingSerializerPluginConfiguration) {
							try {
								messagingSerializer = getBimServer().getSerializerFactory().createMessagingSerializer(getUserName(), ifcModel, renderEnginePlugin, downloadParameters);
							} catch (SerializerException e) {
								e.printStackTrace();
							}
						}
					}
				} catch (BimserverDatabaseException e) {
					LOGGER.error("", e);
				} finally {
					newSession.close();
				}
			}
		} finally {
			done();
		}
	}
}