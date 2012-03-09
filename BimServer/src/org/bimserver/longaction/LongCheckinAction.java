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
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.ProgressHandler;
import org.bimserver.database.actions.CheckinDatabaseAction;
import org.bimserver.models.store.CheckinResult;
import org.bimserver.models.store.CheckinStatus;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongCheckinAction extends LongAction<LongCheckinActionKey> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongCheckinAction.class);
	private final CheckinDatabaseAction createCheckinAction;
	private CheckinStatus status = CheckinStatus.NONE;

	public LongCheckinAction(BimServer bimServer, User user, CheckinDatabaseAction createCheckinAction) {
		super(bimServer, user);
		this.createCheckinAction = createCheckinAction;
	}

	public void execute() {
		status = CheckinStatus.STARTED;
		BimDatabaseSession session = getBimServer().getDatabase().createSession(true);
		try {
			createCheckinAction.setDatabaseSession(session);
			session.executeAndCommitAction(createCheckinAction, 10, new ProgressHandler() {
				@Override
				public void progress(int current, int max) {
					updateProgress(current * 100 / max);
				}
			});
		} catch (OutOfMemoryError e) {
			getBimServer().getServerInfoManager().setOutOfMemory();
			return;
		} catch (Exception e) {
			LOGGER.error("", e);
			createCheckinAction.rollback(e);
		} finally {
			session.close();
			done();
		}
	}
	
	@Override
	protected void done() {
		super.done();
		status = CheckinStatus.FINISHED;
	}

	@Override
	public String getDescription() {
		return getClass().getSimpleName();
	}

	public CheckinResult getCheckinResult() {
		CheckinResult checkinResult = StoreFactory.eINSTANCE.createCheckinResult();
		checkinResult.setProgress(getProgress());
		checkinResult.setStatus(status );
		return checkinResult;
	}
	
	@Override
	public void init() {
	}

	@Override
	public LongCheckinActionKey getKey() {
		return new LongCheckinActionKey(createCheckinAction.getCroid());
	}
	
	public CheckinDatabaseAction getCreateCheckinAction() {
		return createCheckinAction;
	}
}