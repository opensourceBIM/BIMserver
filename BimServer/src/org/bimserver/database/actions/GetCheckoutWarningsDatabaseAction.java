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
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetCheckoutWarningsDatabaseAction extends BimDatabaseAction<Set<String>> {

	private final long poid;
	private Authorization authorization;

	public GetCheckoutWarningsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.poid = poid;
		this.authorization = authorization;
	}

	@Override
	public Set<String> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(authorization.getUoid());
		Set<String> warnings = new HashSet<String>();
		checkOtherUsersCheckouts(project, user, warnings);
		return warnings;
	}

	public void checkOtherUsersCheckouts(Project project, User user, Set<String> warnings) {
		int activeCheckouts = 0;
		for (Project p : getAllRelatedProjects(project)) {
			for (Checkout checkout : p.getCheckouts()) {
				if (checkout.getActive() && checkout.getUser() != user) {
					activeCheckouts++;
				}
			}
		}
		if (activeCheckouts == 1) {
			warnings.add("Warning, another user is possibly working on this model because there is one active checkout");
		} else if (activeCheckouts > 1) {
			warnings.add("Warning, other users are possibly working on this model because there are " + activeCheckouts + " active checkouts");
		}
	}
	
	private Set<Project> getAllRelatedProjects(Project project) {
		Set<Project> projects = new HashSet<Project>();
		getAllRelatedProjects(projects, project);
		return projects;
	}
	
	private void getAllRelatedProjects(Set<Project> projects, Project project) {
		if (projects.contains(project)) {
			return;
		}
		projects.add(project);
		if (project.getParent() != null) {
			getAllRelatedProjects(projects, project.getParent());
		}
		for (Project subProject : project.getSubProjects()) {
			getAllRelatedProjects(projects, subProject);
		}
	}
}