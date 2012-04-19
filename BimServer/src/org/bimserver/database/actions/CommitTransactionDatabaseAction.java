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

import org.bimserver.changes.Change;
import org.bimserver.changes.CreateObjectChange;
import org.bimserver.changes.RemoveObjectChange;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.BimserverDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class CommitTransactionDatabaseAction extends GenericCheckinDatabaseAction {

	private final Set<Change> changes;
	private final long currentUoid;
	private final String comment;
	private Revision revision;
	private final long poid;

	public CommitTransactionDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Set<Change> changes, long currentUoid, long poid,
			String comment) {
		super(databaseSession, accessMethod, null);
		this.changes = changes;
		this.currentUoid = currentUoid;
		this.poid = poid;
		this.comment = comment;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimserverDeadlockException, BimserverDatabaseException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(currentUoid);
		if (project == null) {
			throw new UserException("Project with poid " + poid + " not found");
		}
		if (!RightsManager.hasRightsOnProjectOrSuperProjects(user, project)) {
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
		ConcreteRevision concreteRevision = createNewConcreteRevision(getDatabaseSession(), size, project, user, comment.trim());
		revision = concreteRevision.getRevisions().get(0);
		project.setLastRevision(revision);
		NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
		newRevisionAdded.setDate(new Date());
		newRevisionAdded.setExecutor(user);
		newRevisionAdded.setRevision(concreteRevision.getRevisions().get(0));
		newRevisionAdded.setAccessMethod(getAccessMethod());
		
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
