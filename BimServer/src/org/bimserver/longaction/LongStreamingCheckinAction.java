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

import java.io.IOException;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.ProgressHandler;
import org.bimserver.database.RollbackListener;
import org.bimserver.database.actions.StreamingCheckinDatabaseAction;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.LongCheckinActionState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongStreamingCheckinAction extends LongAction<LongCheckinActionKey> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongStreamingCheckinAction.class);
	private StreamingCheckinDatabaseAction checkinDatabaseAction;
	private String fileName;
	private long roid;
	private DeserializeException deserializerException;

	public LongStreamingCheckinAction(Long topicId, BimServer bimServer, String username, String userUsername, Authorization authorization, StreamingCheckinDatabaseAction checkinDatabaseAction) {
		super(bimServer, username, userUsername, authorization);
		this.checkinDatabaseAction = checkinDatabaseAction;
		this.fileName = checkinDatabaseAction.getFileName();

		if (topicId != -1) {
			setProgressTopic(bimServer.getNotificationsManager().getProgressTopic(topicId));
		} else {
			setProgressTopic(bimServer.getNotificationsManager().createProgressOnProjectTopic(authorization.getUoid(), checkinDatabaseAction.getPoid(), SProgressTopicType.UPLOAD, "Checkin"));
		}
		checkinDatabaseAction.addProgressListener(this);
	}

	public LongStreamingCheckinAction(BimServer bimServer, String username, String userUsername, Authorization authorization, StreamingCheckinDatabaseAction checkinDatabaseAction) {
		this(-1L, bimServer, username, userUsername, authorization, checkinDatabaseAction);
	}

	public void execute() {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			checkinDatabaseAction.setDatabaseSession(session);
			session.executeAndCommitAction(checkinDatabaseAction, new ProgressHandler() {
				private int count;

				@Override
				public void progress(int current, int max) {
					if (count == 0) {
						updateProgress("Saving to database (" + fileName + ")", current * 100 / max);
					} else {
						updateProgress("Saving to database (" + fileName + ", " + count + " try)", current * 100 / max);
					}
				}

				@Override
				public void retry(int count) {
					this.count = count;
				}
			}, new RollbackListener() {
				@Override
				public void rollback() {
					try {
						checkinDatabaseAction.rollback();
					} catch (BimserverDatabaseException e) {
						LOGGER.error("", e);
					}
				}
			});
			this.roid = checkinDatabaseAction.getRevision().getOid();
		} catch (Exception e) {
			try (DatabaseSession tmpSession = getBimServer().getDatabase().createSession(OperationType.READ_WRITE)) {
				Project project = tmpSession.get(checkinDatabaseAction.getPoid(), OldQuery.getDefault());
				project.setCheckinInProgress(0);
				tmpSession.store(project);
				try {
					tmpSession.commit();
				} catch (ServiceException e2) {
					LOGGER.error("", e2);
				}
			} catch (BimserverDatabaseException e1) {
				LOGGER.error("", e1);
			}
			if (e instanceof UserException) {
				if (e.getCause() instanceof DeserializeException) {
					this.deserializerException = (DeserializeException) e.getCause();
				}
			} else if (e instanceof BimserverConcurrentModificationDatabaseException) {
				// Ignore
			} else {
				LOGGER.error("", e);
			}
			error(e);
		} finally {
			try {
				checkinDatabaseAction.close();
			} catch (IOException e) {
				LOGGER.error("", e);
			}
			session.close();
			if (getActionState() != ActionState.AS_ERROR) {
				changeActionState(ActionState.FINISHED, "Checkin of " + fileName, 100);
			}
			done();
		}
	}
	
	@Override
	protected void done() {
		super.done();

		// This is very important! The LongCheckinAction will probably live another 30 minutes 
		// before it will be cleaned up (this is useful for clients asking for the progress/status of this checkin)
		checkinDatabaseAction = null;
	}

	@Override
	public String getDescription() {
		return getClass().getSimpleName();
	}
	
	@Override
	public synchronized LongActionState getState() {
		LongCheckinActionState ds = StoreFactory.eINSTANCE.createLongCheckinActionState();
		ds.setRoid(roid);
		if (deserializerException != null) {
			ds.setDeserializeErrorCode(deserializerException.getDeserializerErrorCode().getCode());
		}
		super.fillState(ds);
		return ds;
	}
}