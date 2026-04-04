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

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.*;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.common.util.EList;

public class SetRevisionTagDatabaseAction extends BimDatabaseAction<String> {
	private final Long roid;
	private final String tag;
	private Authorization authorization;

	public SetRevisionTagDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Long roid, String tag, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.roid = roid;
		this.tag = tag;
		this.authorization = authorization;
	}

	@Override
	public String execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		String trimmedTag = tag.trim();
		Project project = revision.getProject();
		User actingUser = getUserByUoid(authorization.getUoid());
		if (actingUser.getUserType() == UserType.READ_ONLY) {
			throw new UserException("User not allowed to set a tag on a revision");
		}
		if (project.getParent() != null) {
			throw new UserException("Revision is not contained by a top project.");
		}
		EList<Revision> projRevs = project.getRevisions();
		revision.setTag(trimmedTag);
		getDatabaseSession().store(revision);
		EList<ConcreteRevision> concreteRevisions = revision.getConcreteRevisions();
		for (ConcreteRevision cRev : concreteRevisions) {
			EList<Revision> revisions = cRev.getRevisions();
			for (Revision vRev : revisions) {
				if (projRevs.contains(vRev)) {
					continue;
				}
				vRev.setTag(trimmedTag);
				getDatabaseSession().store(vRev);
			}
		}
		return null;
	}
}