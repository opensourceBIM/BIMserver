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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.AdminAuthorization;
import org.bimserver.webservices.authorization.Authorization;

public class GetAllProjectsSmallDatabaseAction extends BimDatabaseAction<List<SProjectSmall>> {

	private Authorization authorization;
	private BimServer bimServer;

	public GetAllProjectsSmallDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
	}

	@Override
	public List<SProjectSmall> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		List<SProjectSmall> list = new ArrayList<SProjectSmall>();
		User user = getUserByUoid(authorization.getUoid());
		IfcModelInterface model = getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getProject(), OldQuery.getDefault());
		List<Project> projects = model.getAll(Project.class);
		for (Project project : projects) {
			if (project.getParent() == null && !project.getName().equals(Database.STORE_PROJECT_NAME)) {
				Project rootProject = getRootProject(project);
				addProjects(list, rootProject, user);
			}
		}
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
		list.add(createSmallProject(authorization, bimServer, project, user));
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
	
	public static SProjectSmall createSmallProject(Authorization authorization, BimServer bimServer, Project project, User user) {
		SProjectSmall small = new SProjectSmall();
		small.setName(project.getName());
		small.setOid(project.getOid());
		small.setLastRevisionId(project.getLastRevision() == null ? -1 : project.getLastRevision().getOid());
		small.setNrRevisions(project.getRevisions().size());
		small.setSchema(project.getSchema());
		small.setNrSubProjects(project.getSubProjects().size());
		small.setHasCheckinRights(authorization.hasRightsOnProject(user, project));
		small.setState(bimServer.getSConverter().convertToSObject(project.getState()));
		small.setParentId(project.getParent() == null ? -1 : project.getParent().getOid());
		return small;
	}
}