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

import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetCheckinWarningsDatabaseAction extends BimDatabaseAction<Set<String>> {

	private final long poid;
	private Authorization authorization;

	public GetCheckinWarningsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.poid = poid;
		this.authorization = authorization;
	}

	@Override
	public Set<String> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(authorization.getUoid());
		Set<String> warnings = new HashSet<String>();
		checkInterleavingCommits(project, user, warnings);
		new GetCheckoutWarningsDatabaseAction(getDatabaseSession(), getAccessMethod(), poid, authorization).checkOtherUsersCheckouts(project, user, warnings);
		return warnings;
	}

	private void checkInterleavingCommits(Project project, User user, Set<String> warnings) {
		Checkout lastOwnActiveCheckout = null;
		for (Checkout checkout : project.getCheckouts()) {
			if (checkout.getUser() == user && checkout.getActive()) {
				lastOwnActiveCheckout = checkout;
			}
		}
		if (lastOwnActiveCheckout != null) {
			Project mainProject = project;
			while (mainProject.getParent() != null) {
				mainProject = mainProject.getParent();
			}
			int newRevisionsAfterCheckout = 0;
			for (Revision virtualRevision : mainProject.getRevisions()) {
				if (lastOwnActiveCheckout.getDate().before(virtualRevision.getDate()) && lastOwnActiveCheckout.getRevision() != virtualRevision) {
					newRevisionsAfterCheckout++;
				}
			}
			if (newRevisionsAfterCheckout == 1) {
				warnings.add("Warning, after your last checkout of this project (revision " + lastOwnActiveCheckout.getRevision().getId() + "), a new revision has been checked-in");
			} else if (newRevisionsAfterCheckout > 1) {
				warnings.add("Warning, after your last checkout of this project (revision " + lastOwnActiveCheckout.getRevision().getId() + "), " + newRevisionsAfterCheckout + " new revisions have been checked-in");
			}
		}
	}
}