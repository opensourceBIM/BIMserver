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
import org.bimserver.database.ProgressHandler;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.CloneToNewProjectDatabaseAction;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongCopyAction extends LongAction<LongCheckinActionKey> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LongCopyAction.class);

	private BimDatabaseAction<ConcreteRevision> action;

	public LongCopyAction(BimServer bimServer, String username, String userUsername, Authorization authorization, CloneToNewProjectDatabaseAction action) {
		super(bimServer, username, userUsername, authorization);
		setProgressTopic(bimServer.getNotificationsManager().createProgressOnProjectTopic(authorization.getUoid(), action.getPoid(), SProgressTopicType.BRANCH, "Branching"));
		this.action = action;
	}

	@Override
	public String getDescription() {
		return "Branch to new project";
	}

	@Override
	public void execute() {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			action.setDatabaseSession(session);
			session.executeAndCommitAction(action, new ProgressHandler() {
				private int count;

				@Override
				public void progress(int current, int max) {
					if (count == 0) {
						updateProgress("Storing data...", current * 100 / max);
					} else {
						updateProgress("Storing data (" + (count + 1) + ")...", current * 100 / max);
					}
				}

				@Override
				public void retry(int count) {
					this.count = count;
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
			session.close();
			done();
			if (getActionState() != ActionState.AS_ERROR) {
				changeActionState(ActionState.FINISHED, "Done", 100);
			}
		}
	}
}