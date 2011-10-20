package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.Date;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ProgressHandler;
import org.bimserver.database.actions.CheckinPart2DatabaseAction;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.CheckinResult;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongCheckinAction extends LongAction<LongCheckinActionKey> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongCheckinAction.class);
	private final CheckinPart2DatabaseAction createCheckinAction;
	private final User user;
	private int progress;
	private final BimServer bimServer;

	public LongCheckinAction(BimServer bimServer, User user, CheckinPart2DatabaseAction createCheckinAction) {
		this.user = user;
		this.bimServer = bimServer;
		this.createCheckinAction = createCheckinAction;
	}

	public void execute() {
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			createCheckinAction.setDatabaseSession(session);
			session.executeAndCommitAction(createCheckinAction, 10, new ProgressHandler() {
				@Override
				public void progress(int current, int max) {
					LongCheckinAction.this.progress = current * 100 / max;
				}
			});
			session.close();

			BimDatabaseSession extraSession = bimServer.getDatabase().createSession(true);
			try {
				ConcreteRevision concreteRevision = (ConcreteRevision) extraSession.get(StorePackage.eINSTANCE.getConcreteRevision(), createCheckinAction.getCroid(), false, null);
				for (Revision r : concreteRevision.getRevisions()) {
					Revision latest = null;
					for (Revision r2 : r.getProject().getRevisions()) {
						if (latest == null || r2.getId() > latest.getId()) {
							latest = r2;
						}
					}
					if (latest != null) {
						latest.getProject().setLastRevision(latest);
						extraSession.store(latest.getProject());
					}
				}
				extraSession.commit();
			} finally {
				extraSession.close();
			}

			session = bimServer.getDatabase().createReadOnlySession();
			for (Revision revision : createCheckinAction.getConcreteRevision(createCheckinAction.getCroid()).getRevisions()) {
				NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
				newRevisionAdded.setDate(new Date());
				newRevisionAdded.setExecutor(user);
				newRevisionAdded.setRevision(revision);
				newRevisionAdded.setAccessMethod(createCheckinAction.getAccessMethod());

//				bimServer.getNotificationsManager().notify(newRevisionAdded);
			}
			startClashDetection(session);
		} catch (OutOfMemoryError e) {
			bimServer.getServerInfoManager().setOutOfMemory();
			return;
		} catch (Exception e) {
			LOGGER.error("", e);
			long croid = createCheckinAction.getCroid();
			try {
				BimDatabaseSession rollBackSession = bimServer.getDatabase().createSession(true);
				try {
					Throwable throwable = e;
					while (throwable.getCause() != null) {
						throwable = throwable.getCause();
					}
					ConcreteRevision concreteRevision = (ConcreteRevision) rollBackSession.get(StorePackage.eINSTANCE.getConcreteRevision(), croid, false, null);
					concreteRevision.setState(CheckinState.ERROR);
					concreteRevision.setLastError(throwable.getMessage());
					for (Revision revision : concreteRevision.getRevisions()) {
						revision.setState(CheckinState.ERROR);
						revision.setLastError(throwable.getMessage());
					}
					rollBackSession.store(concreteRevision);
					rollBackSession.commit();
				} finally {
					rollBackSession.close();
				}
			} catch (BimDeadlockException e1) {
				LOGGER.error("", e1);
			} catch (BimDatabaseException e1) {
				LOGGER.error("", e1);
			}
		} finally {
			session.close();
		}
//		bimServer.getLongActionManager().remove(this);
	}

	private void startClashDetection(BimDatabaseSession session) throws BimDeadlockException, BimDatabaseException, UserException, IfcEngineException, SerializerException {
		ConcreteRevision concreteRevision = (ConcreteRevision) session.get(StorePackage.eINSTANCE.getConcreteRevision(), createCheckinAction.getCroid(), false, null);
		Project project = concreteRevision.getProject();
		Project mainProject = project;
		while (mainProject.getParent() != null) {
			mainProject = mainProject.getParent();
		}
		if (mainProject.getClashDetectionSettings().isEnabled()) {
			ClashDetectionLongAction clashDetectionLongAction = new ClashDetectionLongAction(bimServer, user, createCheckinAction.getActingUid(), mainProject.getOid());
			try {
				bimServer.getLongActionManager().start(clashDetectionLongAction);
			} catch (CannotBeScheduledException e) {
				throw new UserException("Server is shutting down", e);
			}
		}
	}

	@Override
	public String getDescription() {
		return getClass().getSimpleName() + " " + createCheckinAction.getCroid();
	}

	public User getUser() {
		return user;
	}

	public int getProgress() {
		return progress;
	}

	public CheckinResult getCheckinResult() {
		CheckinResult checkinResult = StoreFactory.eINSTANCE.createCheckinResult();
		checkinResult.setProject(createCheckinAction.getProject());
		checkinResult.setRevision(createCheckinAction.getConcreteRevision().getRevisions().get(0));
		checkinResult.setProgress(progress);
		return checkinResult;
	}
	
	@Override
	public void init() {
	}

	@Override
	public LongCheckinActionKey getKey() {
		return new LongCheckinActionKey(createCheckinAction.getCroid());
	}
	
	public CheckinPart2DatabaseAction getCreateCheckinAction() {
		return createCheckinAction;
	}
}