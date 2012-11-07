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

import org.bimserver.BimServer;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.ProgressHandler;
import org.bimserver.database.actions.CheckinDatabaseAction;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.CheckinResult;
import org.bimserver.models.store.CheckinStatus;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongCheckinAction extends LongAction<LongCheckinActionKey> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongCheckinAction.class);
	private CheckinDatabaseAction checkinDatabaseAction;
	private CheckinStatus status = CheckinStatus.CH_NONE;
	private String lastError;

	public LongCheckinAction(BimServer bimServer, String username, String userUsername, Authorization authorization, CheckinDatabaseAction checkinDatabaseAction) {
		super(bimServer, username, userUsername, authorization);
		this.checkinDatabaseAction = checkinDatabaseAction;
		checkinDatabaseAction.addProgressListener(this);
	}

	public void execute() {
		changeActionState(ActionState.STARTED);
		status = CheckinStatus.CH_STARTED;
		updateProgress("Storing data...", 0);
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			checkinDatabaseAction.setDatabaseSession(session);
			session.executeAndCommitAction(checkinDatabaseAction, 10, new ProgressHandler() {
				@Override
				public void progress(int current, int max) {
					updateProgress("Storing data...", current * 100 / max);
				}
			});
		} catch (OutOfMemoryError e) {
			lastError = e.getMessage();
			status = CheckinStatus.CH_ERROR;
			getBimServer().getServerInfoManager().setOutOfMemory();
		} catch (Exception e) {
			if (e instanceof UserException) {
			} else {
				LOGGER.error("", e);
			}
			lastError = e.getMessage();
			status = CheckinStatus.CH_ERROR;
		} finally {
			session.close();
			done();
			changeActionState(ActionState.FINISHED);
		}
	}
	
	@Override
	protected void done() {
		super.done();
		if (status != CheckinStatus.CH_ERROR) {
			status = CheckinStatus.CH_FINISHED;
		}

		// This is very important! The LongCheckinAction will probably live another 30 minutes 
		// before it will be cleaned up (this is useful for clients asking for the progress/status of this checkin)
		checkinDatabaseAction = null;
	}

	@Override
	public String getDescription() {
		return getClass().getSimpleName();
	}

	public CheckinResult getCheckinResult() {
		CheckinResult checkinResult = StoreFactory.eINSTANCE.createCheckinResult();
		checkinResult.setProgress(getProgress());
		checkinResult.setStatus(status);
		checkinResult.setLastError(lastError);
		return checkinResult;
	}
	
	@Override
	public void init() {
	}
}