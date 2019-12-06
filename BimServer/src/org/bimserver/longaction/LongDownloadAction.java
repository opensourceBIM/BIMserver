package org.bimserver.longaction;

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
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OperationType;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadByNewJsonQueryDatabaseAction;
import org.bimserver.database.actions.DownloadCompareDatabaseAction;
import org.bimserver.database.actions.DownloadProjectsDatabaseAction;
import org.bimserver.database.actions.ProgressListener;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ActionState;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class LongDownloadAction extends LongDownloadOrCheckoutAction implements ProgressListener {

	private BimDatabaseAction<? extends IfcModelInterface> action;
	private DatabaseSession readOnlyDatabaseSession;

	public LongDownloadAction(BimServer bimServer, String username, String userUsername, DownloadParameters downloadParameters, Authorization authorization, AccessMethod accessMethod) {
		super(bimServer, username, userUsername, downloadParameters, accessMethod, authorization);

		// TODO it is hard to determine on which project/revision this download is occurring, could be a list of...
		setProgressTopic(bimServer.getNotificationsManager().createProgressTopic(SProgressTopicType.DOWNLOAD, "Download"));
	}

	public void execute() {
		changeActionState(ActionState.STARTED, "Starting download", 0);
		try {
			executeAction(action, downloadParameters, readOnlyDatabaseSession, false);
 		} catch (UserException e) {
 			error(e);
 		} catch (Exception e) {
 			error(e);
			LOGGER.error("", e);
		} finally {
			if (readOnlyDatabaseSession != null) {
				readOnlyDatabaseSession.close();
			}
			if (getErrors().size() == 0) {
				changeActionState(ActionState.STARTED, "Done preparing", 0);
			}
		}
	}

	public void init() {
		super.init();
		if (getBimServer().getServerSettingsCache().getServerSettings().getCacheOutputFiles() && getBimServer().getDiskCacheManager().contains(downloadParameters)) {
			return;
		}

		readOnlyDatabaseSession = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		switch (downloadParameters.getDownloadType()) {
		case DOWNLOAD_BY_NEW_JSON_QUERY:
			action = new DownloadByNewJsonQueryDatabaseAction(getBimServer(), readOnlyDatabaseSession, accessMethod, downloadParameters.getRoids(), downloadParameters.getJsonQuery(), downloadParameters.getSerializerOid(), getAuthorization());
			break;
		case DOWNLOAD_PROJECTS:
			action = new DownloadProjectsDatabaseAction(getBimServer(), readOnlyDatabaseSession, accessMethod, downloadParameters.getRoids(), downloadParameters.getSerializerOid(), getAuthorization());
			break;
		case DOWNLOAD_COMPARE:
			action = new DownloadCompareDatabaseAction(getBimServer(), readOnlyDatabaseSession, accessMethod, downloadParameters.getRoids(), downloadParameters.getModelCompareIdentifier(), downloadParameters.getCompareType(), getAuthorization());
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