package org.bimserver.database.actions;

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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.changes.Change;
import org.bimserver.changes.CreateObjectChange;
import org.bimserver.changes.RemoveObjectChange;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.emf.IdEObject;
import org.bimserver.interfaces.SConverter;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;

public class CommitTransactionDatabaseAction extends GenericCheckinDatabaseAction {

	private final Set<Change> changes;
	private final String comment;
	private Revision revision;
	private final long poid;
	private Authorization authorization;
	private BimServer bimServer;

	public CommitTransactionDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Change> changes, Authorization authorization, long poid,
			String comment) {
		super(databaseSession, accessMethod, null);
		this.bimServer = bimServer;
		this.changes = changes;
		this.authorization = authorization;
		this.poid = poid;
		this.comment = comment;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(authorization.getUoid());
		if (project == null) {
			throw new UserException("Project with poid " + poid + " not found");
		}
		if (!authorization.hasRightsOnProjectOrSuperProjects(user, project)) {
			throw new UserException("User has no rights to checkin models to this project");
		}
		if (!MailSystem.isValidEmailAddress(user.getUsername())) {
			throw new UserException("Users must have a valid e-mail address to checkin");
		}
		long size = 0;
		if (project.getLastRevision() != null) {
			for (ConcreteRevision concreteRevision : project.getLastRevision().getConcreteRevisions()) {
				size += concreteRevision.getSize();
			}
		}
		for (Change change : changes) {
			if (change instanceof CreateObjectChange) {
				size++;
			} else if (change instanceof RemoveObjectChange) {
				size--;
			}
		}
		CreateRevisionResult result = createNewConcreteRevision(getDatabaseSession(), size, project, user, comment.trim());
		ConcreteRevision concreteRevision = result.getConcreteRevision();
		revision = concreteRevision.getRevisions().get(0);
		project.setLastRevision(revision);
		final NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
		newRevisionAdded.setDate(new Date());
		newRevisionAdded.setExecutor(user);
		newRevisionAdded.setRevision(concreteRevision.getRevisions().get(0));
		newRevisionAdded.setProject(project);
		newRevisionAdded.setAccessMethod(getAccessMethod());
		
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(newRevisionAdded));
			}
		});
		
		// First create all new objects
		Map<Long, IdEObject> created = new HashMap<Long, IdEObject>();
		for (Change change : changes) {
			if (change instanceof CreateObjectChange) {
				change.execute(project.getId(), concreteRevision.getId(), getDatabaseSession(), created);
			}
		}
		// Then do the rest
		for (Change change : changes) {
			if (!(change instanceof CreateObjectChange)) {
				change.execute(project.getId(), concreteRevision.getId(), getDatabaseSession(), created);
			}
		}
		getDatabaseSession().store(newRevisionAdded);
		getDatabaseSession().store(concreteRevision);
		getDatabaseSession().store(project);
		return concreteRevision;
	}

	public Revision getRevision() {
		return revision;
	}
}
