package org.bimserver.longaction;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.ProgressHandler;
import org.bimserver.database.RollbackListener;
import org.bimserver.database.actions.ProjectBasedDatabaseAction;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.ActionState;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongGenericAction extends LongAction<LongActionKey> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LongStreamingCheckinAction.class);
	private String fileName;
	private ProjectBasedDatabaseAction<?> action;

	public LongGenericAction(Long topicId, BimServer bimServer, String username, String userUsername, Authorization authorization, ProjectBasedDatabaseAction<?> action) {
		super(bimServer, username, userUsername, authorization);
		this.action = action;
		this.fileName = action.getFileName();

		if (topicId != -1) {
			setProgressTopic(bimServer.getNotificationsManager().getProgressTopic(topicId));
		} else {
			setProgressTopic(bimServer.getNotificationsManager().createProgressOnProjectTopic(authorization.getUoid(), action.getPoid(), SProgressTopicType.UPLOAD, "Checkin"));
		}
		action.addProgressListener(this);
	}

	public LongGenericAction(BimServer bimServer, String username, String userUsername, Authorization authorization, ProjectBasedDatabaseAction<?> checkinDatabaseAction) {
		this(-1L, bimServer, username, userUsername, authorization, checkinDatabaseAction);
	}

	public void execute() {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			action.setDatabaseSession(session);
			session.executeAndCommitAction(action, new ProgressHandler() {
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
						action.rollback();
					} catch (BimserverDatabaseException e) {
						LOGGER.error("", e);
					}
				}
			});
		} catch (Exception e) {
			if (e instanceof UserException) {
			} else if (e instanceof BimserverConcurrentModificationDatabaseException) {
				// Ignore
			} else {
				LOGGER.error("", e);
			}
			error(e);
		} finally {
			try {
				action.close();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			session.close();
			if (getActionState() != ActionState.AS_ERROR) {
				changeActionState(ActionState.FINISHED, action.doneMessage(), 100);
			}
			done();
		}
	}

	@Override
	protected void done() {
		super.done();

		// This is very important! The LongCheckinAction will probably live another 30 minutes 
		// before it will be cleaned up (this is useful for clients asking for the progress/status of this checkin)
		action = null;
	}

	@Override
	public String getDescription() {
		return getClass().getSimpleName();
	}
}