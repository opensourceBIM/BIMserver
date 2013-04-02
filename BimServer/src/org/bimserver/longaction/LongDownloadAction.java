package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadByGuidsDatabaseAction;
import org.bimserver.database.actions.DownloadByNamesDatabaseAction;
import org.bimserver.database.actions.DownloadByOidsDatabaseAction;
import org.bimserver.database.actions.DownloadByTypesDatabaseAction;
import org.bimserver.database.actions.DownloadCompareDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.actions.DownloadProjectsDatabaseAction;
import org.bimserver.database.actions.DownloadQueryDatabaseAction;
import org.bimserver.database.actions.ProgressListener;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.ObjectIDMPluginConfiguration;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class LongDownloadAction extends LongDownloadOrCheckoutAction implements ProgressListener {

	private BimDatabaseAction<? extends IfcModelInterface> action;
	private DatabaseSession session;

	public LongDownloadAction(BimServer bimServer, String username, String userUsername, DownloadParameters downloadParameters, Authorization authorization, AccessMethod accessMethod) {
		super(bimServer, username, userUsername, downloadParameters, accessMethod, authorization);

		// TODO it is hard to determine on which project/revision this download is occurring, could be a list of...
		setProgressTopic(bimServer.getNotificationsManager().createProgressTopic(authorization.getUoid(), SProgressTopicType.DOWNLOAD, "Download"));
	}

	public void execute() {
		changeActionState(ActionState.STARTED, "Starting download", 0);
		try {
			executeAction(action, downloadParameters, session, false);
 		} catch (UserException e) {
 			error(e.getMessage());
 		} catch (Exception e) {
 			error(e.getMessage());
			LOGGER.error("", e);
		} finally {
			if (session != null) {
				session.close();
			}
			updateProgress("Done", 100);
			changeActionState(ActionState.FINISHED, "Done", 100);
		}
	}

	public void init() {
		if (getBimServer().getServerSettingsCache().getServerSettings().getCacheOutputFiles() && getBimServer().getDiskCacheManager().contains(downloadParameters)) {
			return;
		}
		ObjectIDM objectIDM = null;
		session = getBimServer().getDatabase().createSession();
		try {
			SerializerPluginConfiguration serializerPluginConfiguration = session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), downloadParameters.getSerializerOid(), Query.getDefault());
			if (serializerPluginConfiguration != null) {
				ObjectIDMPluginConfiguration objectIdm = serializerPluginConfiguration.getObjectIDM();
				if (objectIdm != null) {
					ObjectIDMPlugin objectIDMPlugin = getBimServer().getPluginManager().getObjectIDMByName(objectIdm.getClassName(), true);
					if (objectIDMPlugin != null) {
						objectIDM = objectIDMPlugin.getObjectIDM(new PluginConfiguration());
					}
				}
			}
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		
		session = getBimServer().getDatabase().createSession();
		Reporter reporter = this;
		switch (downloadParameters.getDownloadType()) {
		case DOWNLOAD_REVISION:
			action = new DownloadDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoid(), downloadParameters.getIgnoreUoid(), downloadParameters.getSerializerOid(), getAuthorization(), objectIDM, reporter);
			break;
		case DOWNLOAD_BY_OIDS:
			action = new DownloadByOidsDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getOids(), downloadParameters.getSerializerOid(), getAuthorization(), objectIDM, reporter, downloadParameters.getDeep());
			break;
		case DOWNLOAD_BY_GUIDS:
			action = new DownloadByGuidsDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getGuids(), downloadParameters.getSerializerOid(), getAuthorization(), objectIDM, reporter, downloadParameters.getDeep());
			break;
		case DOWNLOAD_BY_NAMES:
			action = new DownloadByNamesDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getNames(), downloadParameters.getSerializerOid(), getAuthorization(), objectIDM, reporter, downloadParameters.getDeep());
			break;
		case DOWNLOAD_OF_TYPE:
			action = new DownloadByTypesDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getClassNames(), downloadParameters.getSerializerOid(), downloadParameters.isIncludeAllSubtypes(), downloadParameters.getUseObjectIDM(), getAuthorization(), objectIDM, reporter, downloadParameters.getDeep());
			break;
		case DOWNLOAD_PROJECTS:
			action = new DownloadProjectsDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getSerializerOid(), getAuthorization(), objectIDM, reporter);
			break;
		case DOWNLOAD_COMPARE:
			action = new DownloadCompareDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getModelCompareIdentifier(), downloadParameters.getCompareType(), getAuthorization(), objectIDM, reporter);
			break;
		case DOWNLOAD_QUERY:
			action = new DownloadQueryDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoid(), downloadParameters.getQeid(), downloadParameters.getSerializerOid(), downloadParameters.getCode(), getAuthorization(), objectIDM, reporter);
			break;
		}
		action.addProgressListener(this);
	}

	@Override
	public String getDescription() {
		return "Download";
	}
	
	@Override
	protected void done() {
		super.done();
		// This is very important! The LongDownloadAction will probably live another 30 minutes 
		// before it will be cleaned up (this is useful for clients asking for the progress/status of this download)
		action = null;
	}
}