package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.AdminAuthorization;
import org.bimserver.webservices.authorization.Authorization;

public class GetAllRelatedProjectsDatabaseAction extends BimDatabaseAction<List<SProjectSmall>> {

	private Long poid;
	private BimServer bimServer;
	private Authorization authorization;

	public GetAllRelatedProjectsDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, Authorization authorization, AccessMethod accessMethod, Long poid) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.poid = poid;
	}

	@Override
	public List<SProjectSmall> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		List<SProjectSmall> list = new ArrayList<SProjectSmall>();
		Project project = getDatabaseSession().get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
		Project rootProject = getRootProject(project);
		User user = getUserByUoid(authorization.getUoid());
		addProjects(list, rootProject, user);
		return list;
	}
	
	private Project getRootProject(Project project) {
		if (project.getParent() != null) {
			return getRootProject(project.getParent());
		} else {
			return project;
		}
	}
	
	private void addProjects(List<SProjectSmall> list, Project project, User user) {
		if (project.getState() == ObjectState.DELETED && !(authorization instanceof AdminAuthorization)) {
			return;
		}
		list.add(GetAllProjectsSmallDatabaseAction.createSmallProject(authorization, bimServer, project, user));
		List<Project> subProjects = new ArrayList<Project>(project.getSubProjects());
		Collections.sort(subProjects, new Comparator<Project>(){
			@Override
			public int compare(Project o1, Project o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		for (Project subProject : subProjects) {
			addProjects(list, subProject, user);
		}
	}
}