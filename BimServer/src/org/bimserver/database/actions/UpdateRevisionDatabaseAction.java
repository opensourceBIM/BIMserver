package org.bimserver.database.actions;

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

import java.util.Date;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.RevisionUpdated;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class UpdateRevisionDatabaseAction extends BimDatabaseAction<Void> {

	private final SRevision sRevision;
	private Authorization authorization;
	private BimServer bimServer;

	public UpdateRevisionDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, SRevision sRevision) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.sRevision = sRevision;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User actingUser = getUserByUoid(authorization.getUoid());
		final Revision revision = getRevisionByRoid(sRevision.getOid());
		if (revision == null) {
			throw new UserException("Revision with pid " + sRevision.getOid() + " not found");
		}
		Project project = revision.getProject();
		if (!authorization.hasRightsOnProjectOrSuperProjects(actingUser, project)) {
			throw new UserException("User has no rights to update project properties");
		}
		final RevisionUpdated revisionUpdated = getDatabaseSession().create(RevisionUpdated.class);
		revisionUpdated.setRevision(revision);
		revisionUpdated.setDate(new Date());
		revisionUpdated.setExecutor(actingUser);
		revisionUpdated.setAccessMethod(getAccessMethod());
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(revisionUpdated));
			}
		});
		revision.setTag(sRevision.getTag());
		getDatabaseSession().store(revision);
		return null;
	}
}