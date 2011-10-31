package org.bimserver.database.actions;

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

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.RevisionUpdated;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class UpdateRevisionDatabaseAction extends BimDatabaseAction<Void> {

	private final SRevision sRevision;
	private final long actingUoid;

	public UpdateRevisionDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, SRevision sRevision) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.sRevision = sRevision;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		final Revision revision = getRevisionByRoid(sRevision.getOid());
		if (revision == null) {
			throw new UserException("Revision with pid " + sRevision.getOid() + " not found");
		}
		Project project = revision.getProject();
		if (!RightsManager.hasRightsOnProjectOrSuperProjects(actingUser, project)) {
			throw new UserException("User has no rights to update project properties");
		}
		RevisionUpdated revisionUpdated = LogFactory.eINSTANCE.createRevisionUpdated();
		revisionUpdated.setRevision(revision);
		revisionUpdated.setDate(new Date());
		revisionUpdated.setExecutor(actingUser);
		revisionUpdated.setAccessMethod(getAccessMethod());
		revision.setTag(sRevision.getTag());
		getDatabaseSession().store(revisionUpdated);
		getDatabaseSession().store(revision);
		return null;
	}
}